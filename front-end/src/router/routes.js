import HomePage from "../views/HomePage.vue"

export const routes = [
  {
    path: "/",
    name: "HomePage",
    component: HomePage,
    meta: { requiresAuth: false, title: `home`},
  }
]