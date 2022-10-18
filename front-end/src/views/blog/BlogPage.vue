<template>
    <div>
        <!-- Header Start -->
        <div class="container-fluid bg-primary py-5 mb-5 page-header">
            <div class="container py-5">
                <div class="row justify-content-center">
                    <div class="col-lg-10 text-center">
                        <h1 class="display-3 text-white animated slideInDown">Blog</h1>
                        <nav aria-label="breadcrumb">
                            <ol class="breadcrumb justify-content-center">
                                <li class="breadcrumb-item"><a class="text-white" href="#">Home</a></li>
                                <li class="breadcrumb-item"><a class="text-white" href="#">Pages</a></li>
                                <li class="breadcrumb-item text-white active" aria-current="page">About</li>
                            </ol>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
        <!-- Header End -->
        
        <!-- Blog List Start -->
        <div class="container-xxl py-5">
            <div class="container">
                <div class="text-center wow fadeInUp" data-wow-delay="0.1s">
                    <h6 class="section-title bg-white text-center text-primary px-3">Blog</h6>
                    <h1 class="mb-5">Latest Posts</h1>
                </div>
                <div class="row g-4 justify-content-center">
                    <div v-for="blog in GetListBlog" :key="blog.id" class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.1s">
                        <div class="course-item bg-light">
                            <div class="position-relative overflow-hidden">
                                <img class="img-fluid" src="" alt="">
                                <div class="w-100 d-flex justify-content-center position-absolute bottom-0 start-0 mb-4">
                                    <a href="blogDetail.html" class="flex-shrink-0 btn btn-sm btn-primary px-3 border-end" style="border-radius: 30px 30px 30px 30px;">Read More</a>
                                </div>
                            </div>
                            <div class="p-4 pb-0 mb-0">
                                <h4 class="text-center" @click="showDetail(blog.id)" style="cursor: pointer;">{{blog.title}}</h4>
                                <p>{{blog.description}}</p>
                            </div>
                            <div class="d-flex border-top">
                                <small class="flex-fill text-center border-end py-2"><i class="fa fa-user-tie text-primary me-2"></i>{{blog.author}}</small>
                                <small class="flex-fill text-center border-end py-2"><i class="bi bi-calendar text-primary me-2"></i>{{blog.createdDate}}</small>
                                <small class="flex-fill text-center py-2"><i class="bi bi-eye-fill text-primary me-2"></i>{{blog.numberOfView}}</small>
                            </div>
                        </div>
                    </div>
                    
                </div>
            </div>
        </div>
        <!-- Blog list End -->
    </div>
</template>

<script>
import { BlogServices } from "../../services/blog.services"

export default ({
    data() {
        return{
            blogList: [],
            selectedBlog: "",
        }
    }, 
    mounted() {
        this.getListBlog();
    },
    computed: {
        GetListBlog(){
            return this.blogList
        }
    },
    methods: {
      async getListBlog() {
         let res = await BlogServices.getAllBlog()
         this.blogList = res.data
      },
      showDetail(id){
        this.$router.push({name: "BlogDetail", query: {"id": id} });
      }
   }
})
</script>

<style>
</style>