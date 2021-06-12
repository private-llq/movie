import Vue from 'vue'
import VueRouter from 'vue-router'

import Home from '../views/Home.vue'
import cinema from "@/views/cinema";
import MovieDetail from "@/views/MovieDetail";
import seat from "@/views/seat";
import Order from "@/views/Order";
import MyOrder from "@/views/MyOrder";
Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/MovieDetail',
    name: 'MovieDetail',
    component: MovieDetail
  },
  {
    path: '/seat',
    name: 'seat',
    component: seat
  },
  {
    path:'/MyOrder',
    name:'MyOrder',
    component:MyOrder
  },

  {
    path:'/Order',
    name:'Order',
    component:Order
  },
  {
    path: '/cinema',
    name: 'cinema',
    component: cinema
  },
  {
    path: '/login',
    name: 'login',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/login.vue')
  },
  {
    path: '/register',
    name: 'register',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/register.vue')
  },
]

const router = new VueRouter({
  routes
})
//全局路由前置守卫
router.beforeEach((to,from,next)=>{
  console.log(to);
  if(!(to.path=='/seat'&&'/Order')){
    next();
  }else{
    //记载时，若没有登录，则跳转回登录页
    if(!sessionStorage.getItem("UserId")){
      alert("未登录请先登录")
      router.push("/login");
    }else{
      next();
    }
  }
})
export default router
