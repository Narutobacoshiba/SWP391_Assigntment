import { BaseService, ErrorWrapper, ResponseWrapper } from './base.js'

export class UserServices extends BaseService {
    static get entity() {
      return 'user'
    }

    static async getUser(username, password) {
        try {
          const response = await this.request({ auth: false }).post(`SWP_391_Assignment/${this.entity}/get`, {"username":username,"password":password})
          return new ResponseWrapper(response, response.data)
        } catch (error) {
          throw new ErrorWrapper(error)
        }
    }

    static async registerUser(username, password, dob, address){
      try {
        const response = await this.request({ auth: false }).post(`SWP_391_Assignment/${this.entity}/register`, {"username":username,"password":password,"dob":dob,"address":address})
        return new ResponseWrapper(response, response.data)
      } catch(error){
        throw new ErrorWrapper(error)
      }
    }

    static async updateUser(username, password, dob, address){
      try {
        const response = await this.request({ auth: false }).post(`SWP_391_Assignment/${this.entity}/update`, {"username":username,"password":password,"dob":dob,"address":address})
        return new ResponseWrapper(response, response.data)
      } catch(error){
        throw new ErrorWrapper(error)
      }
    }

    static async deleteUser(username, password){
      try {
        const response = await this.request({ auth: false }).post(`SWP_391_Assignment/${this.entity}/delete`, {"username":username,"password":password})
        return new ResponseWrapper(response, response.data)
      } catch(error){
        throw new ErrorWrapper(error)
      }
    }
}