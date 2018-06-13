import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Login from '@/components/Login'
import ImageForm from '@/components/ImageForm'
import ImageView from '@/components/ImageView'
import AccommodationForm from '@/components/AccommodationForm'
import Datepicker from '@/components/Datepicker'
import AccommodationList from '@/components/AccommodationList'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/form',
      name: 'ImageForm',
      component: ImageForm
    },
    {
      path: '/images',
      name: 'ImageView',
      component: ImageView
    },
    {
      path: '/main',
      name: 'AccommodationForm',
      component: AccommodationForm
    },
    {
      path: '/dp',
      name: 'dp',
      component: Datepicker
    },
    {
      path: '/accList',
      name: 'AccommodationList',
      component: AccommodationList
    }
  ]
})
