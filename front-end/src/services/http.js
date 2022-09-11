import axios from 'axios'
import { API_URL } from '../.env'

export class Http {
  constructor (status) {
    this.isAuth = status && status.auth ? status.auth : false
    this.instance = axios.create({
      baseURL: API_URL,
    })
    return this.init()
  }

  init () {
    if (this.isAuth) {
        // use some authentication mechanic
        return this.instance
    }

    return this.instance
  }
}