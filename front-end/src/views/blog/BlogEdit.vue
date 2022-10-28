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
                    <h6 id="set-scroll" class="section-title bg-white text-center text-primary px-3">Blog Edit</h6>
                    <button type="button" class="btn btn-primary">Add</button>
                </div>
                <div class="container wow fadeInUp g-4" data-wow-delay="0.3s">   
                    <div class="contact-form">                       
                        <form method="post" role="form">
                        <div class="controls">
                            <div class="form-group">
                                    <p>Title</p>
                                    <input type="text" name="title" v-model="blogTitle" class="form-input-text form-control"  required="required">                              
                            </div>
                            <div class="form-group">
                                <p >Thumbnai URL</p>
                                <input type="text" name="thumbnai" v-model="thumnailUrl" class="form-input-text form-control"  required="required">                           
                            </div>
                            <div class="form-group">
                                <p>Description</p>
                                <textarea name="description" v-model="blogDescription" class="form-input-text form-control" rows="4" required="required"></textarea>                       
                            </div>   
                            <div class="form-group">
                                <p>Content</p>
                                <textarea name="content" v-model="blogContent" class="form-input-text form-control" rows="6" required="required"></textarea>
                                </div>
                                <div class="bottom-margin" >
                                    <div class="btn bt-send-msg" @click="updateBlog()">Update</div>
                                </div>
                            </div>
                        </form>
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
            blogTitle: "",
            blogDescription: "",
            blogContent: "",
            thumnailUrl: "",
        }
    }, 
    mounted() {
        this.getBlogById()
        document.getElementById('set-scroll').scrollIntoView();
    },
    methods: {
        async getBlogById(){
            let id = this.$route.query["id"]
            let res = await BlogServices.getBlogById(id)
            if("id" in res.data){
                this.blogTitle = res.data.title
                this.blogDescription = res.data.description
                this.blogContent = res.data.content
                this.thumnailUrl = res.data.thumbnailUrl
            }
        },
        async updateBlog(){
            try{
                let id = this.$route.query["id"]
                let res = await BlogServices.updateBlogById(id, this.blogTitle, this.blogDescription, this.blogContent, this.thumnailUrl)
                if(res.data == true){
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
            }catch(error){
                this.$notify({
                    group: 'foo',
                    type: 'warn',
                    text: 'update failed'
                });
            }
        }    
   }
})
</script>

<style>
.contact-form{width:800px;margin:0 auto;}
.contact-form .form-control{
	border:none;
	box-shadow:none;
	border-radius:0;
	border-bottom: 1px solid #cfd8dc;
	transition: 1s ease;
	font-weight: bold;
	}
	.contact-form .form-control:focus{
	transition: 1s ease;
	border-bottom: 1px solid #2abfcc;
	}
	.contact-main  .contact-main-title h2{
	margin-top:0;
	}

	.contact-form .bt-send-msg{
	color:#2abfcc;
	border:1px solid #2abfcc;
	height:40px;
	background-color:transparent;
	transition: all 0.8s ease-out;
	margin-top:40px;
	}

	.contact-form .bt-send-msg:hover{
	color:#fff;
	border:1px solid #fff;
	height:40px;
	background-color:#2abfcc;
	}
.form-group{
    margin-top: 20px;
}
</style>