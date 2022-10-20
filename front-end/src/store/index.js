import Vue from 'vue'
import Vuex from 'vuex'
import modules from './modules'
import createPersistedState from "vuex-persistedstate";
/* import * as Cookies from 'js-cookie' */
Vue.use(Vuex)

export default new Vuex.Store({
  modules,
  plugins: [createPersistedState()] 
})
