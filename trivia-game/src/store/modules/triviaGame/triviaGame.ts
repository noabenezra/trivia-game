import actions from './actions';
import state from "./state";
import mutations from "./mutations";
import getters from "./getters";

const triviaGameStore = {
    state,
    actions,
    mutations,
    getters,
    namespaced: true
};

export default triviaGameStore;

