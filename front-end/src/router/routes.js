import HomePage from "../views/HomePage.vue"
import LoginPage from "../views/LoginPage.vue"
import BlogPage from "../views/blog/BlogPage.vue"
import BlogDetail from "../views/blog/BlogDetail.vue"
import BlogEdit from "../views/blog/BlogEdit.vue"
import BlogAdd from "../views/blog/BlogAdd.vue"
import CourseList from "../views/course/CourseListPage.vue"
import CourseDetail from "../views/course/CourseDetail.vue"
import CourseRegister from "../views/course/CourseRegisterForUser.vue"
import UserManager from "../views/user/UserManagerPage.vue"
import UserProfile from "../views/user/UserProfile.vue"
import EditUserProfile from "../views/user/EditUserProfile.vue"


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
    path: "/blog-edit",
    name: "BlogEdit",
    component: BlogEdit,
    meta: { requiresAuth: true, title: `blog-edit`},
  },
  {
    path: "/blog-add",
    name: "BlogAdd",
    component: BlogAdd,
    meta: { requiresAuth: true, title: `blog-add`},
  },
  {
    path: "/courses",
    name: "CourseList",
    component: CourseList,
    meta: { requiresAuth: false, title: `course-list`},
  },
  {
    path: "/course-detail",
    name: "CourseDetail",
    component: CourseDetail,
    meta: { requiresAuth: false, title: `course-detail`},
  },
  {
    path: "/course-register",
    name: "CourseRegister",
    component: CourseRegister,
    meta: { requiresAuth: true, title: `course-register`},
  },
  {
    path: "/user",
    name: "UserManager",
    component: UserManager,
    meta: { requiresAuth: true, title: `user-manager`},
  },
  {
    path: "/user-profile",
    name: "UserProfile",
    component: UserProfile,
    meta: { requiresAuth: true, title: `user-profile`},
  },
  {
    path: "/edit-user-profile",
    name: "EditUserProfile",
    component: EditUserProfile,
    meta: { requiresAuth: true, title: `edit-user`},
  }
]
