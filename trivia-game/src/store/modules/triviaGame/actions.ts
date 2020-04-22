import axios from "axios";

const actions = {
    getData() {
        debugger;
        return new Promise((resolve, reject) => {
            axios({url: 'http://18.216.240.67/trivia/data', method: 'GET'})
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

