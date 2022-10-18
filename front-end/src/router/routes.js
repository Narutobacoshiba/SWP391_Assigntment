import HomePage from "../views/HomePage.vue"
import LoginPage from "../views/LoginPage.vue"
import BlogPage from "../views/blog/BlogPage.vue"
import BlogDetail from "../views/blog/BlogDetail.vue"
import CourseList from "../views/course/CourseListForUser.vue"
import CourseRegister from "../views/course/CourseRegisterForUser.vue"

export const routes = [
  {
    path: "/",
    name: "HomePage",
    component: HomePage,
    meta: { requiresAuth: false, title: `home`},
  },
  {
    path: "/login",
    name: "LoginPage",
    component: LoginPage,
    meta: { requiresAuth: false, title: `login`},
  },
  {
    path: "/blog",
    name: "BlogPage",
    component: BlogPage,
    meta: { requiresAuth: false, title: `blog`},
  },
  {
    path: "/blog-detail",
    name: "BlogDetail",
    component: BlogDetail,
    meta: { requiresAuth: false, title: `blog-detail`},
  },
  {
    path: "/courses",
    name: "CourseList",
    component: CourseList,
    meta: { requiresAuth: false, title: `course-list`},
  },
  {
    path: "/course-register",
    name: "CourseRegister",
    component: CourseRegister,
    meta: { requiresAuth: false, title: `course-register`},
  }
]