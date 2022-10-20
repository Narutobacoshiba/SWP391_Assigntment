<template>
<div>
    <div class="container course-content">
    <div class="row">
      <div class="col-2">
        <div v-if="getRole == 'admin'">
            <h3>Status</h3>
            <div class="form-check">
            <input class="form-check-input" type="radio" value="2" v-model="courseStatus" id="defaultCheck1">
            <label class="form-check-label" for="defaultCheck1">
                All
            </label>
            </div>
            <div class="form-check">
            <input class="form-check-input" type="radio" value="1" v-model="courseStatus" id="defaultCheck1">
            <label class="form-check-label" for="defaultCheck1">
                Accepted
            </label>
            </div>
            <div class="form-check">
            <input class="form-check-input" type="radio" value="0" v-model="courseStatus" id="defaultCheck1">
            <label class="form-check-label" for="defaultCheck1">
                Pending
            </label>
            </div>
        </div>
        <h3>Category</h3>
        <div class="form-check">
          <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
          <label class="form-check-label" for="defaultCheck1">
            Java
          </label>
        </div>
        <div class="form-check">
          <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
          <label class="form-check-label" for="defaultCheck1">
            C/C++
          </label>
        </div>
        <div class="form-check">
          <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
          <label class="form-check-label" for="defaultCheck1">
            Python
          </label>
        </div>
        <div class="form-check">
          <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
          <label class="form-check-label" for="defaultCheck1">
            Golang
          </label>
        </div>
        <div class="form-check">
          <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
          <label class="form-check-label" for="defaultCheck1">
            C#
          </label>
        </div>
        <div class="form-check">
          <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
          <label class="form-check-label" for="defaultCheck1">
            PHP
          </label>
        </div>
      </div>
      <div class="col-10">
        <div class="course-list">

          <div class="course-items" v-for="course in GetListCourse" :key="course.courseID">
            <img :src="course.thumbnailUrl" alt="" class="course-img">
            <div class="course-text">
              <a href="" @click="showCourseDetail(course.courseID)"><h5 class="course-text__title">{{course.name}}</h5></a>
              <p class="course-text__desc">{{course.description}}</p>
              <p class="course-text__author">Dang Cong Kien</p>
              <p class="course-text__lession">5 lessions</p>
              <div class="price-and-button" v-if="getRole == 'admin'">
                <p class="course-text__featured">Featured</p>
                <div class="course-btn" v-if="course.status == 0">
                  <div class="btn btn-success btn-sm" @click="changeCourseStatus(course.courseID,1)">Accept</div>
                  <div class="btn btn-danger btn-sm" @click="removeCourse(course.courseID)">Reject</div>
                </div>
                <div class="course-btn" v-if="course.status == 1">
                  <div class="btn btn-success btn-sm" @click="changeCourseStatus(course.courseID,0)">Pending</div>
                  <div class="btn btn-danger btn-sm" @click="removeCourse(course.courseID)">Remove</div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <nav aria-label="Page navigation example">
    <ul class="pagination justify-content-center">
      <li class="page-item disabled">
        <a class="page-link" href="#" aria-label="Previous">
          <span aria-hidden="true">&laquo;</span>
        </a>
      </li>
      <li class="page-item"><a class="page-link" href="#">1</a></li>
      <li class="page-item"><a class="page-link" href="#">2</a></li>
      <li class="page-item"><a class="page-link" href="#">3</a></li>
      <li class="page-item">
        <a class="page-link" href="#" aria-label="Next">
          <span aria-hidden="true">&raquo;</span>
        </a>
      </li>
    </ul>
  </nav>
  </div>
</template>

<script>
import {CourseServices} from "../../services/course.services"

export default ({
    data() {
        return{
            courseStatus: 1,
            courseList: [],
        }
    }, 
    watch: {
        courseStatus(newStatus) {
           this.getListCourse(newStatus) 
        }
    },
    mounted() {
        if(this.$store.state.user.currentUser.role == 'admin'){
            this.courseStatus = 2;
        }
        this.getListCourse();
    },
    computed: {
        GetListCourse(){
            return this.courseList
        },
        getRole(){
            return this.$store.state.user.currentUser.role
        }
    },
    methods: {
        async getListCourse() {
            let res = await CourseServices.getListCourse(this.courseStatus)
            this.courseList = res.data
        },
        async changeCourseStatus(id, status){
            let res = await CourseServices.updateCourseStatus(id, status)
            if(res.data == true){
                this.getListCourse();
                this.$notify({
                    group: 'foo',
                    type: 'success ',
                    text: 'Update successful'
                });
            }else{
                this.$notify({
                    group: 'foo',
                    type: 'warn',
                    text: 'update failed'
                });
            }
        },
        async removeCourse(id){
            if(confirm("do you want to delete this course?")){
                let res = await CourseServices.deleteCourseById(id)
                if(res.data == true){
                    this.getListCourse();
                    this.$notify({
                        group: 'foo',
                        type: 'success ',
                        text: 'Delete course successful'
                    });
                }else{
                    this.$notify({
                        group: 'foo',
                        type: 'warn',
                        text: 'Delete course failed'
                    });
                }
            }
        },
        showCourseDetail(id){
            this.$router.push({name: "CourseDetail", query: {"id": id} });
        }
   }
})
</script>

<style>
.navbar .dropdown-toggle::after {
    border: none;
    content: "\f107";
    font-family: "Font Awesome 5 Free";
    font-weight: 900;
    vertical-align: middle;
    margin-left: 8px;
}

.navbar-light .navbar-nav .nav-link {
    margin-right: 30px;
    padding: 25px 0;
    color: #FFFFFF;
    font-size: 15px;
    text-transform: uppercase;
    outline: none;
}

.navbar-light .navbar-nav .nav-link:hover,
.navbar-light .navbar-nav .nav-link.active {
    color: var(--primary);
}

@media (max-width: 991.98px) {
    .navbar-light .navbar-nav .nav-link  {
        margin-right: 0;
        padding: 10px 0;
    }

    .navbar-light .navbar-nav {
        border-top: 1px solid #EEEEEE;
    }
}

.navbar-light .navbar-brand,
.navbar-light a.btn {
    height: 75px;
}

.navbar-light .navbar-nav .nav-link {
    color: var(--dark);
    font-weight: 500;
}

.navbar-light.sticky-top {
    top: -100px;
    transition: .5s;
}

@media (min-width: 992px) {
    .navbar .nav-item .dropdown-menu {
        display: block;
        margin-top: 0;
        opacity: 0;
        visibility: hidden;
        transition: .5s;
    }

    .navbar .dropdown-menu.fade-down {
        top: 100%;
        transform: rotateX(-75deg);
        transform-origin: 0% 0%;
    }

    .navbar .nav-item:hover .dropdown-menu {
        top: 100%;
        transform: rotateX(0deg);
        visibility: visible;
        transition: .5s;
        opacity: 1;
    }
}

.navar-user {
    list-style: none;
    position: relative;
    width: 220px;
    padding: 20px 0;
    margin: unset;
    cursor: pointer;
}
.navbar__img-user{
    width: 40px;
    height: 40px;
    overflow: hidden;
    border: 0px solid #E1E1E1;
    border-radius: 50%;
    background-color: #3BAFDA;
}

.navbar__user-name {
    letter-spacing: 0;
    font-size: 0.875rem;
    line-height: 1.25rem;
    font-weight: 400;
    max-width: 120px;
    color: #333;
    margin-right: 4px;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
}

.navbar__user-list {
    background-color: #FFFFFF;
    width: 198px;
    position: absolute;
    top: 100%;
    right: 0px;
    padding-left: 0;
    border-radius: 2px;
    border: 1px solid #d3d3d3;
    transform-origin: calc(100% - 20px) top;
    animation: notifyGrowup ease-in 0.2s;
    will-change: opacity, transform;
    display: none;
    z-index: 1;
    cursor: pointer;
}

.navbar__user-item {
    list-style: none;
    padding: 10px 12px;
    font-weight: 300;
    
}

.navbar__user-item a {
    text-decoration: none;
    color: #000;
}

.navbar__item--has-user-login:hover .navbar__user-list {
    display: block;
}

.navbar__user-item:hover{
    background-color: #f7f7f7;
}

.navbar__user-item--separate {
    border-top: 1px solid #d3d3d3;
}


.navbar__user-list::before {
    content: "";
    display: block;
    width: 100%;
    height: 20px;
    position: absolute;
    top: -15%;
    right: 0;
}

a {
    text-decoration: none;
    color: #212529;
}
.course-items {
    display: flex;
    align-items: flex-start;
    margin-bottom: 10px;
}
.course-img {
    width: 150px;
    height: 150px;
    max-width: 150px;
}
.course-text {
    margin-left: 20px;

}
.course-text__title {
    font-size: 16px;
    font-weight: 500;
}
.course-text__desc, 
.course-text__author, 
.course-text__lession,
.course-text__featured
{
    font-size: 14px;   
    margin-bottom: 5px;                                                                                                                                        
}
.course-text__author {
    font-weight: 500;
}
.course-text__lession {
    opacity: 0.7;
}
.course-text__featured {
    background-color: #141414;
    color: #fff;
    border-radius: 50px;
    width: 80px;
    text-align: center;
}
.course-text__price {
    font-size: 16px;
}

.price-and-button {
    display: flex;
    justify-content: space-between;
    align-items: flex-start;
}

.course-content,
.card-content {
    margin-top: 50px;
}

.card-img {
    /* position: relative;
    margin: auto;
    top: 0;
    bottom: 0;
    left: 0;
    width: 400px;
    height: 400px; */
    object-fit: contain;
    object-position: center;
    height: 400px;
    max-width: 100%;
}

.footer-card a {
    text-decoration: underline;
}

.footer-card {
    display: flex;
    justify-content: space-between;
    align-items: center;
}
.footer-link {
    text-decoration: none;
}
</style>
