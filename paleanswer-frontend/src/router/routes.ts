import { RouteRecordRaw } from "vue-router";
import HomeView from "@/views/HomeView.vue";
import UserLayout from "@/layouts/userLayout.vue";
import ACCESS_ENUM from "@/access/accessEnum";
import NoAuthPage from "@/views/NoAuthPage.vue";

export const routes: Array<RouteRecordRaw> = [
  {
    path: "/",
    name: "home",
    component: HomeView,
  },
  {
    path: "/noAuth",
    name: "无权限",
    component: NoAuthPage,
    meta: {
      access: ACCESS_ENUM.ADMIN,
    },
  },

  {
    path: "/admin",
    name: "管理页面",
    component: HomeView,
    meta: {
      access: ACCESS_ENUM.ADMIN,
    },
  },

  {
    path: "/about",
    name: "about",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/AboutView.vue"),
  },
  {
    path: "/user",
    name: "用户",
    component: UserLayout,
    children: [
      {
        path: "/user/login",
        name: "用户登录",
        component: HomeView,
      },
      {
        path: "/user/register",
        name: "用户注册",
        component: HomeView,
      },
    ],
    meta: {
      hideInMenu: true,
    },
  },
];
