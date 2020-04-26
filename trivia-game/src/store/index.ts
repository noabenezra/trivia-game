import Vue from 'vue'
import Vuex from 'vuex'
import triviaGameStore from './modules/triviaGame/triviaGame';
import createPersistedState from 'vuex-persistedstate';

Vue.use(Vuex);

export default new Vuex.Store({
    modules: {
        triviaGameStore
    },
    plugins: [createPersistedState()]

})
