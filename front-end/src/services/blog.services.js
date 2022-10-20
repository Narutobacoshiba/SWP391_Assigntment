import { BaseService, ErrorWrapper, ResponseWrapper } from './base.js'

export class BlogServices extends BaseService {
    static get entity() {
      return 'blog'
    }

    static async getAllBlog() {
        try {
          const response = await this.request({ auth: false }).post(`SWP_391_Assignment/${this.entity}/getListBlog`, {})
          return new ResponseWrapper(response, response.data)
        } catch (error) {
          throw new ErrorWrapper(error)
        }
    }

    static async getBlogById(id) {
        try {
          const response = await this.request({ auth: false }).post(`SWP_391_Assignment/${this.entity}/getBlogById`, {"id":id})
          return new ResponseWrapper(response, response.data)
        } catch (error) {
          throw new ErrorWrapper(error)
        }
    }

    static async deleteBlogById(id){
        try {
            const response = await this.request({ auth: true }).post(`SWP_391_Assignment/${this.entity}/deleteBlogById`, {"id":id})
            return new ResponseWrapper(response, response.data)
          } catch (error) {
            throw new ErrorWrapper(error)
          }
    }

    static async updateBlogById(id, title, description, content, url){
        try {
            const response = await this.request({ auth: true }).post(`SWP_391_Assignment/${this.entity}/updateBlogById`,
             {"id":id,"title":title,"description":description,"content":content,"url":url})
            return new ResponseWrapper(response, response.data)
          } catch (error) {
            throw new ErrorWrapper(error)
          }
    }
}