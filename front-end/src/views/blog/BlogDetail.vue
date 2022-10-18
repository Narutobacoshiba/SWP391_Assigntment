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
                    <h6 id="set-scroll" class="section-title bg-white text-center text-primary px-3">Blog</h6>
                    <h1 class="mb-5">{{blogDetail.title}}</h1>
                    <img :src="blogDetail.thumbnailUrl" alt="">
                </div>
                <div class="container wow fadeInUp g-4" data-wow-delay="0.3s">   
                    {{blogDetail.content}}
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
            blogDetail: {}
        }
    }, 
    mounted() {
        this.getBlogById()
        document.getElementById('set-scroll').scrollIntoView();
    },
    computed: {
        getBlogDetail(){
            return this.blogDetail
        }
    },
    methods: {
        async getBlogById(){
            let id = this.$route.query["id"]
            let res = await BlogServices.getBlogById(id)
            this.blogDetail = res.data
        }    
   }
})
</script>