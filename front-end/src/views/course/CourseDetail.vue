<template>
    <div class="container card-content">
        <div class="row">
            <div class="col-12">
                <div class="card mb-3">
                <img :src="courseThumbnail" class="card-img-top card-img" alt="...">
                <div class="card-body">
                    <h5 class="card-title">{{courseName}}</h5>
                    <p class="card-text">{{courseAbout}}</p>
                    <p class="card-text">Author: Dang Cong Kien</p>
                    <p class="card-text">5 Lessons</p>
                    <p class="card-text">Price: {{coursePrice}} $</p>
                    <div class="card-text footer-card">
                    <a href="">Take quiz</a>
                    <div v-if="getRole == 'admin'">
                        <div class="card-btn" v-if="courseStatus == 0">
                            <div class="btn btn-success btn-sm" @click="changeCourseStatus(courseId,1)">Accept</div>
                            <div class="btn btn-danger btn-sm" @click="removeCourse(courseId)">Reject</div>
                        </div>
                        <div class="card-btn" v-if="courseStatus == 1">
                            <div class="btn btn-success btn-sm" @click="changeCourseStatus(courseId,0)">Pending</div>
                            <div class="btn btn-danger btn-sm" @click="removeCourse(courseId)">Remove</div>
                        </div>
                    </div>
                    </div>
                </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import {CourseServices} from "../../services/course.services"

export default ({
    data() {
        return{
            courseStatus: 2,
            courseName: "",
            courseAbout: "",
            coursePrice: 0.0,
            courseThumbnail: "",
            courseId: -1,
        }
    }, 
    mounted() {
        this.getCourseById();
    },
    computed: {
        getRole(){
            return this.$store.state.user.currentUser.role
        }
    },
    methods: {
        async getCourseById() {
            let id = this.$route.query["id"]
            let res = await CourseServices.getCourseById(id)
            if("courseID" in res.data){
                this.courseStatus = res.data["status"]
                this.courseName = res.data["name"]
                this.courseAbout = res.data["aboutCourse"]
                this.coursePrice = res.data["price"]
                this.courseThumbnail = res.data["thumbnailUrl"]
                this.courseId = res.data["courseID"]
            }
        },
        async changeCourseStatus(id, status){
            let res = await CourseServices.updateCourseStatus(id, status)
            if(res.data == true){
                this.getCourseById();
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
