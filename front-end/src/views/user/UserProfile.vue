<template>
    <div class="container">
        <section style="background-color: #eee;">
            <div class="container py-5">  
              <div class="row">
                <div class="col-lg-4">
                  <div class="card mb-4">
                    <div class="card-body text-center">
                      <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava3.webp" alt="avatar"
                        class="rounded-circle img-fluid" style="width: 150px;">
                      <h5 class="my-3">{{userName}}</h5>                     
                      
                      <div class="d-flex justify-content-center mb-2">
                        <!-- <button type="button" class="btn btn-primary">Follow</button> -->
                        <button type="button" class="btn btn-outline-primary ms-1">Message</button>
                      </div>
                    </div>
                  </div>
                  
                </div>
                <div class="col-lg-8">
                  <div class="card mb-4">
                    <div class="card-body">
                      <div class="row">
                        <div class="col-sm-3">
                          <p class="mb-0">User Name</p>
                        </div>
                        <div class="col-sm-9">
                          <p class="text-muted mb-0">{{userName}}</p>
                        </div>
                      </div>
                      <hr>
                      <div class="row">
                        <div class="col-sm-3">
                          <p class="mb-0">Email</p>
                        </div>
                        <div class="col-sm-9">
                          <p class="text-muted mb-0">{{userEmail}}</p>
                        </div>
                      </div>
                      
                      <hr>
                      <div class="row">
                        <div class="col-sm-3">
                          <p class="mb-0">Role</p>
                        </div>
                        <div class="col-sm-9">
                          <p class="text-muted mb-0">{{userRole}}</p>
                        </div>
                      </div>
                      <hr>
                     
                      <div class="row">
                        <div class="col-sm-3">
                          <p class="mb-0">Status</p>
                        </div>
                        <div class="col-sm-9">
                          <p class="text-muted mb-0">{{userStatus == 0 ? "banned" : "active"}}</p>
                        </div>
                      </div>
                      
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-md-6">
                      <div class="card mb-4 mb-md-0">
                        
                      </div>
                    </div>
                    <div class="col-md-6">
                      <div class="card mb-4 mb-md-0">
                        
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
            </div>
        </section>
    </div>
</template>

<script>
import {UserServices} from "../../services/user.services"

export default ({
    data() {
        return{
            userId: "",
            userName: "",
            userRole: "",
            userEmail: "",
            userStatus: 1,
        }
    }, 
    mounted() {
        this.getUserById();
    },
    methods: {
        async getUserById() {
            let id = this.$route.query["id"]
            let res = await UserServices.getUserById(id)
            if("id" in res.data){
                this.userId = res.data["id"]
                this.userName = res.data["username"]
                this.userEmail = res.data["email"]
                this.userRole = res.data["role"]
                this.userStatus = res.data["status"]
            }
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
</style>