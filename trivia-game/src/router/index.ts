import Vue from 'vue';
import VueRouter, {RouteConfig} from 'vue-router';
import Home from '../views/Home.vue';
import FinishGame from '../views/FinishGame.vue';

Vue.use(VueRouter)

const routes: Array<RouteConfig> = [
    {
        path: '/',
        name: 'Home',
        component: Home
    },
    {
        path: '/about',
        name: 'About',
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () => import( '../views/About.vue')
    },


    {
        path: '/instructions',
        name: 'Instructions',
        component: () => import( '../views/Instructions.vue')
    },
    {
        path: '/winners',
        name: 'Winners',
        component: () => import( '../views/Winners.vue')
    },

    {
        path: '/finish',
        name: 'FinishGame',
        component: FinishGame
    },
    {
        path: '/game',
        name: 'Game',
        component: () => import( '../views/Game.vue')
    }
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router
