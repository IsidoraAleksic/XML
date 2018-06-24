import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Login from '@/components/Login'
import ImageForm from '@/components/ImageForm'
import ImageView from '@/components/ImageView'
import AccommodationForm from '@/components/AccommodationForm'
import Datepicker from '@/components/Datepicker'
import AccommodationList from '@/components/AccommodationList'
import AccommodationView from '@/components/AccommodationView'
import Message from '@/components/Message'
import Reservation from '@/components/Reservation'
import Home from '@/components/Home'


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
    },
    {
      path: '/accommodationUnit/:id',
      name: 'AccommodationView',
      component: AccommodationView
    },
    {
      path: '/msg',
      name: 'Message',
      component: Message
    },
    {
      path: '/reservation',
      name: 'Reservation',
      component: Reservation
    },
    {
      path: '/home',
      name: 'Home',
      component: Home
    }
  ]
})
