import axios from "axios";
import {UserEntity} from "@/models/UserEntity";

// @ts-ignore
const actions = {
    getData() {
        return new Promise((resolve, reject) => {
            axios({url: 'http://localhost:8080/trivia/data', method: 'GET'})
                .then(response => {
                    resolve(response);
                })
                .catch(err => {
                    reject(err)
                })
        })
    },
    saveUser({commit}: any, userEntity: UserEntity) {
        return new Promise((resolve, reject) => {
            axios({url: 'http://localhost:8080/trivia/add', data: userEntity, method: 'POST'})
                .then(response => {
                    userEntity.id = response.data;
                    const userDetails: UserEntity = {
                        id: userEntity.id,
                        name: userEntity.name,
                    };
                    commit('userDetails', userDetails);
                    resolve(response);
                })
                .catch(err => {
                    reject(err)
                })
        })
    },
    updateUser({commit}: any, userEntity: UserEntity) {
        return new Promise((resolve, reject) => {
            axios({url: 'http://localhost:8080/trivia/update', data: userEntity, method: 'POST'})
                .then(response => {
                    const userDetails: UserEntity = {
                        id: userEntity.id,
                        name: userEntity.name,
                        numberOfAnswerQuestions: userEntity.numberOfAnswerQuestions,
                        score: userEntity.score,

                    };
                    commit('userDetails', userDetails);
                    resolve(response);
                })
                .catch(err => {
                    reject(err)
                })
        })
    },

    getUsers() {
        return new Promise((resolve, reject) => {
            axios({url: 'http://localhost:8080/trivia/getAllUsers', method: 'GET'})
                .then(response => {
                    resolve(response);
                })
                .catch(err => {
                    reject(err)
                })
        })
    },


}
export default actions;


