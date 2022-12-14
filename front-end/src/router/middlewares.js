import $store from '../store'
import { AuthService } from '@/services/auth.js'

export async function initCurrentUserStateMiddleware (to, from, next) {
  const currentUserId = $store.state.user.currentUser.id
  
  if (AuthService.hasRefreshToken() && !currentUserId) {
    try {
      await AuthService.debounceRefreshTokens()
      await $store.dispatch('user/getCurrent')
      next()
    } catch (e) {
      console.log(e)
    }
  } else {
    next()
  }  
}

export function checkAccessMiddleware (to, from, next) {
  const currentUserId = $store.state.user.currentUser.id
  const isAuthRoute = to.matched.some(record => record.meta.requiresAuth)

  if (isAuthRoute){
        if (currentUserId) {
          return next();
        }
        return next("/login");
  }

  const isGuestRoute = to.matched.some(record => record.meta.guest)
  if(isGuestRoute)
  {
    if (currentUserId) {
        return next("/home");
      }
      return next()
  }
  return next()
}

export function setPageTitleMiddleware (to, from, next) {
  const pageTitle = to.matched.find(record => record.meta.title)

  if (pageTitle) window.document.title = pageTitle.meta.title
  next()
}