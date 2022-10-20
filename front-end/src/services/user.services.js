import { BaseService, ErrorWrapper, ResponseWrapper } from './base.js'

export class UserServices extends BaseService {
    static get entity() {
      return 'user'
    }

    static async getCurrent () {
      try {
        const response = await this.request({ auth: true }).get(`SWP_391_Assignment/${this.entity}/getCurrent`)
        return new ResponseWrapper(response, response.data)
      } catch (error) {
        const message = error.response.data ? error.response.data.error : error.response.statusText
        throw new ErrorWrapper(error, message)
      }
    }

    static async getUser(username, password) {
        try {
          const response = await this.request({ auth: false }).post(`SWP_391_Assignment/${this.entity}/get`, {"username":username,"password":password})
          return new ResponseWrapper(response, response.data)
        } catch (error) {
          throw new ErrorWrapper(error)
        }
    }

    static async getUserById(id) {
      try {
        const response = await this.request({ auth: false }).post(`SWP_391_Assignment/${this.entity}/getUserById`, {"id":id})
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

    static async listAllUser(){
      try {
        const response = await this.request({ auth: false }).post(`SWP_391_Assignment/${this.entity}/listAllUser`, {})
        return new ResponseWrapper(response, response.data)
      } catch(error){
        throw new ErrorWrapper(error)
      }
    }

    static async banUser(id){
      try {
        const response = await this.request({ auth: false }).post(`SWP_391_Assignment/${this.entity}/banUser`, {"id":id})
        return new ResponseWrapper(response, response.data)
      } catch(error){
        throw new ErrorWrapper(error)
      }
    }

    static async unbanUser(id){
      try {
        const response = await this.request({ auth: false }).post(`SWP_391_Assignment/${this.entity}/unbanUser`, {"id":id})
        return new ResponseWrapper(response, response.data)
      } catch(error){
        throw new ErrorWrapper(error)
      }
    }

    static async editUserProfile(id, username, role, status, email){
      try {
        const response = await this.request({ auth: false }).post(`SWP_391_Assignment/${this.entity}/editUserProfile`, 
        {"id":id,"username":username,"role":role,"status":status,"email":email})
        return new ResponseWrapper(response, response.data)
      } catch(error){
        throw new ErrorWrapper(error)
      }
    }

    static async deleteUserById(id){
      try {
        const response = await this.request({ auth: false }).post(`SWP_391_Assignment/${this.entity}/deleteUserById`, {"id":id})
        return new ResponseWrapper(response, response.data)
      } catch(error){
        throw new ErrorWrapper(error)
      }
    }
}