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
}