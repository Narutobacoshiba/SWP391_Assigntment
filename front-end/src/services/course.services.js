import { BaseService, ErrorWrapper, ResponseWrapper } from './base.js'

export class CourseServices extends BaseService {
    static get entity() {
      return 'course'
    }

    static async getListCourse(status) {
        try {
          const response = await this.request({ auth: false }).post(`SWP_391_Assignment/${this.entity}/getListCourse`, {"status":status})
          return new ResponseWrapper(response, response.data)
        } catch (error) {
          throw new ErrorWrapper(error)
        }
    }

    static async updateCourseStatus(id, status) {
        try {
          const response = await this.request({ auth: false }).post(`SWP_391_Assignment/${this.entity}/updateCourseStatus`, {"id":id,"status":status})
          return new ResponseWrapper(response, response.data)
        } catch (error) {
          throw new ErrorWrapper(error)
        }
    }

    static async deleteCourseById(id) {
        try {
          const response = await this.request({ auth: false }).post(`SWP_391_Assignment/${this.entity}/deleteCourseById`, {"id":id})
          return new ResponseWrapper(response, response.data)
        } catch (error) {
          throw new ErrorWrapper(error)
        }
    }

    static async getCourseById(id) {
        try {
          const response = await this.request({ auth: false }).post(`SWP_391_Assignment/${this.entity}/getCourseById`, {"id":id})
          return new ResponseWrapper(response, response.data)
        } catch (error) {
          throw new ErrorWrapper(error)
        }
    }
}