import axios from "axios";

const actions = {
    getData() {
        debugger;
        return new Promise((resolve, reject) => {
            axios({url: 'http://localhost:8080/trivia/data', method: 'GET'})
                .then(response => {
                    debugger;
                    resolve(response);
                })
                .catch(err => {
                    reject(err)
                })
        })
    }
}
export default actions;

