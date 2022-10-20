import { UserServices } from '@/services/user.services.js'

export default {
  getCurrent ({ commit }) {
    return UserServices.getCurrent()
      .then(user => commit('SET_CURRENT_USER', user.data))
      .catch(error => {error})
  }
}
