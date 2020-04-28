<template>
    <b-container fluid="true" class="game">
        <b-row class="nav">
            <b-col class="money" cols="2">
                <span class="user-money">{{userMoney}}</span>
                <img src="../assets/123.png" class="money-img" alt="money">
            </b-col>
            <b-col cols="5" class="block">
            </b-col>
            <b-col cols="4" class="timer">
                <Timer class="timer-clock" @timer="setTimer"
                       :key="componentKey"/>
                <img src="../assets/124.png" class="money-img" alt="timer">
            </b-col>
        </b-row>
        <b-row class="board">
            <b-col class="arrow-element-prev" cols="2">
                <!-- <span :disabled="!isPrev" :class="!isPrev ? 'disabled' : 'arrow'"
                       @click="isPrev ? goToPrevStage():''">  < </span>-->
            </b-col>
            <b-col cols="8" class="center">
                <div class="ask-question">
                    <p class="question">
                        {{question}}
                    </p>
                </div>
                <div class="missing-words">
                    <div :class="item.name ==='' ? 'letter' : (item.name==='_'? 'underscore':'block') "
                         v-for='item in resultList'
                         @click='onClickResultList(item)'>
                        {{ item.name }}
                    </div>
                </div>
                <div class="container">
                    <div :class="item.name ==='' ? 'letter' : 'block' " v-for='item in guessingList' :key='item.id'
                         @click='onClickGuessingList(item)'>
                        {{ item.name }}
                    </div>
                </div>
            </b-col>
            <b-col class="arrow-element" cols="2">
                <span :disabled="!isNext" :class="!isNext ? 'disabled' : 'arrow'"
                      @click="isNext ? goToNextStage() :'' ">>
                </span>
            </b-col>
        </b-row>
        <b-row>
            <b-col>
                <b-button :disabled="success"
                          :class="success ? 'disabled-button' : ''"
                          class="hint" @click="giveMeAHint()">
                       <span class="for-computer">
                                           מתקשה? קח רמז
                    </span>
                    <span class="for-mobile">
                                               קח רמז
                    </span>

                </b-button>
            </b-col>
            <b-col>
                <b-button :disabled="success || this.userMoney - 30  < 0"
                          :class="success  || this.userMoney - 30  < 0  ? 'disabled-button' : ''"
                          class="hint pass"
                          @click="nextQuestion()">
                    <span class="for-computer">
                                            עבור שאלה - בעלות 30 מטבעות
                    </span>
                    <span class="for-mobile">
                                            עבור שאלה
                    </span>
                </b-button>
            </b-col>
        </b-row>
        <b-row v-if="success === true" class="success">
            <b-col>
                <span class="beautiful">
                      יפה!
                </span>
                <br>
                <span class="message">
                      {{data[indexQuestion].success}}
                </span>
            </b-col>
        </b-row>
    </b-container>
</template>

<script lang="ts">
    import {Component, Vue} from 'vue-property-decorator';
    import {LetterBox} from '@/models/LetterBox';
    import {Result} from '@/models/Result';
    import Timer from '@/components/Timer.vue';
    import EventBus from '../main';

    @Component({
        components: {Timer}
    })
    export default class Game extends Vue {
        private numberOfLettersInGuessingList: number = 16;
        private question: string = "";
        private indexQuestion: number = 0;
        private data: Result[] = [];
        private success: boolean = false;
        private guessingList: LetterBox[] = [];
        private resultList: LetterBox[] = [];
        private arrayOfCharAnswer: string[] = [];
        private isNext: boolean = false;
        private isPressHint: boolean = false;
        private userMoney: number = 100;
        private time: any = 0;
        private componentKey: any = 0;
        $router: any;
        $store: any;


        mounted() {
            this.getDataFromServer();
        }

        setTimer(value: any) {
            this.time = value;
        }

        nextQuestion() {
            if (this.userMoney - 30 >= 0 && !this.success) {
                this.userMoney = this.userMoney - 30;
                if (this.time != 0) {
                    this.stopTimer();
                }
                this.success = true;
                this.isNext = true;
            }
        }

        onClickGuessingList(chosenItem: LetterBox) {
            let arrayIndex = this.resultList.findIndex(x => x.name === '');
            if (arrayIndex != -1) {
                this.moveToResultList(chosenItem, arrayIndex);
                this.removeFromGuessingList(chosenItem);
            }
            this.ifUserSuccess();
        }

        moveToResultList(chosenItem: LetterBox, arrayIndex: number) {
            this.resultList[arrayIndex].name = chosenItem.name;
            this.resultList[arrayIndex].id = chosenItem.id;
            this.resultList[arrayIndex].list = 2;
        }

        removeFromGuessingList(chosenItem: LetterBox) {
            this.guessingList[this.guessingList.findIndex(x => x.name === chosenItem.name && x.id === chosenItem.id)].name = '';

        }

        giveMeAHint() {
            this.isPressHint = true;
            this.dataManipulation();
            let hint = this.data[this.indexQuestion].hint;
            let answer = this.data[this.indexQuestion].answer;
            let startIndex = answer.indexOf(hint);
            let arrayHint = Array.from(this.data[this.indexQuestion].hint);
            arrayHint.forEach(item => {
                let foundItem = this.guessingList.find(x => x.name === item);
                if (foundItem) {
                    this.resultList[startIndex].id = foundItem.id;
                    this.resultList[startIndex].name = foundItem.name;
                    this.resultList[startIndex].list = 2;
                    startIndex++;
                    this.removeFromGuessingList(foundItem);
                }
            });
            this.isPressHint = false;
        }

        moveToGuessingList(item: LetterBox) {
            this.guessingList[(item.id) - 1].name = item.name;
            this.guessingList[(item.id) - 1].id = item.id;
            this.guessingList[(item.id) - 1].list = 1;
        }

        removeFromResultList(item: LetterBox) {
            let indexElement = this.resultList.findIndex(x => x.name === item.name && x.id == item.id);
            if (indexElement != -1) {
                this.resultList[indexElement] = {
                    id: 0,
                    name: '',
                    list: 2
                };
            }
        }

        onClickResultList(item: LetterBox) {
            if (item.id > 0 && item.name != "_") {
                this.moveToGuessingList(item);
                this.removeFromResultList(item);
            }
        }

        goToNextStage() {
            this.forceRerender();
            if (this.indexQuestion === this.data.length - 1) {
                this.$router.push({name: 'FinishGame', params: {userMoney: this.userMoney}});
            }
            this.indexQuestion++;
            this.dataManipulation();
        }

        forceRerender() {
            this.componentKey += 1;
        }

        dataManipulation() {
            this.init();
            //   if (this.success || this.indexQuestion === 0 || this.isPressHint) {
            this.question = this.data[this.indexQuestion].question;
            this.arrayOfCharAnswer = Array.from(this.data[this.indexQuestion].answer);
            this.createResultList();
            this.createGuessingList();
            // }
        }

        ifUserSuccess() {
            let isSuccess = this.resultList.every((value, index) => value.name === this.arrayOfCharAnswer[index]);
            if (isSuccess) {
                this.timeManipulation();
                this.success = true;
                this.isNext = true;
            }
        }

        timeManipulation() {
            if (this.time != 0) {
                this.userMoney = this.userMoney + 10;
                this.stopTimer();
            }
        }

        stopTimer() {
            EventBus.$emit("stopTimer", true);
        }

        init() {
            this.resultList = [];
            this.guessingList = [];
            this.success = false;
            this.isNext = false;
        }

        createResultList() {
            let resultListIds = 0;
            this.arrayOfCharAnswer.forEach(item => {
                this.resultList.push(
                    {
                        id: resultListIds--,
                        name: item === '_' ? '_' : '',
                        list: 2
                    }
                )
            });
        }

        createGuessingList() {
            let guessingListIds = 1;

            let arrayOfLettersForGuessingList = [...this.arrayOfCharAnswer];
            //mix array - random
            arrayOfLettersForGuessingList = this.shuffle(arrayOfLettersForGuessingList);

            //remove elements with '_'
            while (arrayOfLettersForGuessingList.findIndex(el => el === '_') != -1) {
                let indexForSpace = arrayOfLettersForGuessingList.findIndex(el => el === '_');
                if (indexForSpace != -1) {
                    arrayOfLettersForGuessingList.splice(indexForSpace, 1);
                }
            }
            //add mix letters for the guessing list
            arrayOfLettersForGuessingList = [...this.addLetters(this.numberOfLettersInGuessingList - arrayOfLettersForGuessingList.length), ...arrayOfLettersForGuessingList];

            arrayOfLettersForGuessingList.forEach(item => {
                this.guessingList.push(
                    {
                        id: guessingListIds++,
                        name: item,
                        list: 1
                    });
            });
        }

        shuffle(array: string[]) {
            for (let i = array.length - 1; i > 0; i--) {
                const j = Math.floor(Math.random() * (i + 1));
                [array[i], array[j]] = [array[j], array[i]];
            }
            return array;
        }

        addLetters(length: number) {
            let result = '';
            let characters = 'אבגדהוזחטיכלמנסעפצקרשת';
            let charactersLength = characters.length;
            for (let i = 0; i < length; i++) {
                result += characters.charAt(Math.floor(Math.random() * charactersLength));
            }
            return Array.from(result);
        }

        getDataFromServer() {
            this.$store.dispatch('triviaGameStore/getData').then((res: any) => {
                    if (res && res.data) {
                        this.data = res.data;
                    }
                    this.sortArray();
                    this.dataManipulation();
                }
            ).catch();
        }

        sortArray() {
            this.data.sort((item, item2) => item.difficulty - item2.difficulty);
        }

    }
</script>
<style scoped lang="scss">
    .game {
        .board {
            padding: 0 30px 0 30px;

            .missing-words {
                display: flex;
                margin-bottom: 30px;
                justify-content: space-evenly;

                .letter {
                    border: solid 1px black;
                    width: 40px;
                    height: 40px;
                    cursor: pointer !important;
                }

                .block {
                    border: solid 1px;
                    background-color: white;
                    width: 40px;
                    height: 40px;
                    font-size: 25px;
                    font-weight: bold;
                    cursor: pointer !important;

                }

                .underscore {

                }
            }

            .container {
                display: flex;
                margin-bottom: 30px;
                flex-wrap: wrap;

                .letter {
                    border: solid 1px white;
                    width: 40px;
                    height: 40px;
                    margin: 10px;
                }

                .block {
                    background-color: white;
                    border: solid 1px;
                    width: 40px;
                    height: 40px;
                    font-size: 25px;
                    font-weight: bold;
                    margin: 10px;
                    cursor: pointer !important;
                }
            }

            .ask-question {
                //background-color: #d5d8e7;
                // border: solid 1px;
                // border-radius: 10px;
                font-weight: bold;
                margin-bottom: 30px;
                font-size: 35px;

                .question {
                    margin-top: 10px;
                }
            }

            .input-group {
                width: 80%;
                margin-left: 9%;
            }

            .arrow-element {
                margin-top: 12%;
                cursor: pointer;
                font-size: 30px;
                font-weight: 900;

                .arrow {
                    color: black;
                }

                .disabled {
                    color: #dddddd;
                }
            }
        }

        background-image: url("../assets/t.png");
        background-repeat: no-repeat;
        background-size: cover;
        background-color: #ffffff69;
        // margin-left: 20%;
        height: 97%;
        border: #ffffff69;

        .nav {
            padding-top: 70px;

            .money {
                margin-right: 75px;
                display: flex;

                .user-money {
                    align-self: center;
                    font-size: 24px;
                    font-weight: bold;
                    margin-left: 10px;
                }

                .money-img {
                    width: 50px;
                }
            }

            .timer {
                margin-right: -24px;
                align-self: center;
                font-size: 24px;
                font-weight: bold;
                display: flex;

                .timer-clock {
                    align-self: center;
                    margin-left: 10px;
                    margin-right: 95px;
                }

                .money-img {
                    width: 50px;
                    height: 50px;
                }
            }
        }


        .hint {
            font-size: 20px;
            text-align: center;
            cursor: pointer;
            outline: none;
            color: black;
            background-color: white;
            border-radius: 36px;
            border: solid 1px #2c3e50;
            height: 34px;
            padding: 0 20px;
            line-height: 34px;
            margin-left: 85px;
        }

        .pass {
            margin-left: 30px;
        }

        .for-mobile {
            display: none;
        }

        .disabled-button {
            background-color: #dddddd;
        }

        .hint:hover:not([disabled]) {
            background-color: #e3dccc;
        }

        .hint:active:not([disabled]) {
            background-color: #e3dccc;
            transform: translateY(4px);
        }


        .for-mobile {
            display: none;
        }

        .success {
            margin-top: 5%;
            font-size: 25px;
            font-weight: bold;
            border: solid 2px;
            width: 392px;
            margin-right: 29%;
            padding: 5px;
            background: white;
            border-radius: 10px;

            .beautiful {
                font-size: 35px;
                color: #e21e00;
            }

            .message {
                font-size: 25px;
            }
        }
    }

    @media screen and (min-width: 771px) and (max-width: 1000px) {
        .game {
            width: 74%;
            height: 71%;
            margin-right: 47%;
            margin-top: 5%;

            .board {
                padding: 0 60px 0 0;

                .center {
                    flex: 0 0 82.666667%;
                    max-width: 82.666667%;
                    padding-right: 0;
                    padding-left: 0;

                    .missing-words {
                        display: flex;
                        margin-bottom: 30px;
                        justify-content: space-evenly;

                        .letter {
                            border: solid 1px black;
                            width: 20px;
                            height: 20px;
                            cursor: pointer !important;
                        }

                        .block {
                            border: solid 1px;
                            background-color: white;
                            width: 20px;
                            height: 20px;
                            font-size: 12px;
                            font-weight: bold;
                            cursor: pointer !important;

                        }

                        .underscore {

                        }
                    }

                    .container {
                        display: flex;
                        margin-bottom: 20px;
                        flex-wrap: wrap;

                        .letter {
                            border: solid 1px white;
                            width: 20px;
                            height: 20px;
                        }

                        .block {
                            background-color: white;
                            border: solid 1px;
                            width: 20px;
                            height: 20px;
                            font-size: 12px;
                            font-weight: bold;
                            margin: 10px;
                            cursor: pointer !important;
                        }
                    }

                    .ask-question {
                        font-weight: bold;
                        margin-bottom: 20px;

                        .question {
                            margin-top: 10px;
                            font-size: 25px;
                        }
                    }
                }

                .input-group {
                }

                .arrow-element-prev {
                    display: none;
                }

                .arrow-element {

                    font-size: 20px;
                    margin-top: 20%;
                    cursor: pointer;
                    font-weight: 900;

                    .arrow {
                        color: black;
                    }

                    .disabled {
                        color: #dddddd;
                    }
                }
            }

            .nav {
                justify-content: space-around;
                padding-top: 50px;

                .money {
                    flex: 0;
                    display: flex;
                    margin-right: 0;

                    .user-money {
                        margin-left: 10%;
                        align-self: center;
                        font-size: 12px;
                        font-weight: bold;
                    }

                    .money-img {
                        width: 30px;
                        height: 30px;
                    }
                }

                .block {
                    flex: 0;
                }

                .timer {
                    flex: 0;
                    margin-right: 0;
                    align-self: center;
                    font-size: 12px;
                    font-weight: bold;
                    display: flex;

                    .timer-clock {
                        margin-left: 10%;
                        align-self: center;
                        margin-right: 0;

                    }

                    .money-img {
                        width: 30px;
                        height: 30px;
                    }
                }
            }

            .row {
                margin-bottom: 10px;
            }

            .hint {
                font-size: 12px;
                text-align: center;
                cursor: pointer;
                outline: none;
                color: black;
                background-color: white;
                border-radius: 36px;
                border: solid 1px #2c3e50;
                line-height: 34px;
                content: 'עבור שאלה' !important;
                margin-left: 5%;

                button span {
                    display: none;

                }
            }

            .pass {
            }

            .disabled-button {
                background-color: #dddddd;
            }

            .hint:hover:not([disabled]) {
                background-color: #e3dccc;
            }

            .hint:active:not([disabled]) {
                background-color: #e3dccc;
                transform: translateY(4px);
            }

            .success {
                font-size: 12px;
                font-weight: bold;
                border: solid 2px;
                background: white;
                border-radius: 10px;
                width: 224px;
                margin-top: 10%;
                margin-left: auto;
                margin-right: auto;


                .beautiful {
                    font-size: 12px;
                    color: #e21e00;
                }

                .message {
                    font-size: 12px;
                }
            }
        }


    }

    @media screen and (min-width: 501px) and (max-width: 770px) {
        .game {
            background-image: unset;

            .board {
                padding: 0 60px 0 0;

                .center {
                    flex: 0 0 82.666667%;
                    max-width: 82.666667%;
                    padding-right: 0;
                    padding-left: 0;

                    .missing-words {
                        display: flex;
                        margin-bottom: 30px;
                        justify-content: space-evenly;

                        .letter {
                            border: solid 1px black;
                            width: 20px;
                            height: 20px;
                            cursor: pointer !important;
                        }

                        .block {
                            border: solid 1px;
                            background-color: white;
                            width: 20px;
                            height: 20px;
                            font-size: 12px;
                            font-weight: bold;
                            cursor: pointer !important;

                        }

                        .underscore {

                        }
                    }

                    .container {
                        display: flex;
                        margin-bottom: 20px;
                        flex-wrap: wrap;

                        .letter {
                            border: solid 1px white;
                            width: 20px;
                            height: 20px;
                        }

                        .block {
                            background-color: white;
                            border: solid 1px;
                            width: 20px;
                            height: 20px;
                            font-size: 12px;
                            font-weight: bold;
                            margin: 10px;
                            cursor: pointer !important;
                        }
                    }

                    .ask-question {
                        font-weight: bold;
                        margin-bottom: 20px;

                        .question {
                            margin-top: 10px;
                            font-size: 25px;
                        }
                    }
                }

                .input-group {
                }

                .arrow-element-prev {
                    display: none;
                }

                .arrow-element {
                    margin-top: 25%;
                    cursor: pointer;
                    font-size: 12px;
                    font-weight: 900;

                    .arrow {
                        color: black;
                    }

                    .disabled {
                        color: #dddddd;
                    }
                }
            }

            .nav {
                justify-content: space-between;
                padding-top: 30px;

                .money {
                    flex: 0;
                    display: flex;
                    margin-right: 5%;

                    .user-money {
                        margin-left: 10%;
                        align-self: center;
                        font-size: 12px;
                        font-weight: bold;
                    }

                    .money-img {
                        width: 30px;
                        height: 30px;
                    }
                }

                .block {
                    flex: 0;
                }

                .timer {
                    flex: 0;
                    margin-right: 0;
                    align-self: center;
                    font-size: 12px;
                    font-weight: bold;
                    display: flex;

                    .timer-clock {
                        margin-left: 10%;
                        align-self: center;
                        margin-right: 0;

                    }

                    .money-img {
                        width: 30px;
                        height: 30px;
                    }
                }
            }

            .row {
                margin-bottom: 10px;
            }

            .hint {
                font-size: 12px;
                text-align: center;
                cursor: pointer;
                outline: none;
                color: black;
                background-color: white;
                border-radius: 36px;
                border: solid 1px #2c3e50;
                line-height: 34px;
                content: 'עבור שאלה' !important;
                margin-left: 5%;

                button span {
                    display: none;

                }
            }

            .pass {
            }

            .disabled-button {
                background-color: #dddddd;
            }

            .hint:hover:not([disabled]) {
                background-color: #e3dccc;
            }

            .hint:active:not([disabled]) {
                background-color: #e3dccc;
                transform: translateY(4px);
            }

            .success {
                font-size: 12px;
                font-weight: bold;
                border: solid 2px;
                background: white;
                border-radius: 10px;
                width: 224px;
                margin-top: 10%;
                margin-left: auto;
                margin-right: auto;


                .beautiful {
                    font-size: 12px;
                    color: #e21e00;
                }

                .message {
                    font-size: 12px;
                }
            }
        }

    }

    @media screen and (max-width: 500px) {
        .game {
            .board {
                padding: 0 60px 0 0;

                .center {
                    flex: 0 0 82.666667%;
                    max-width: 82.666667%;
                    padding-right: 0;
                    padding-left: 0;

                    .missing-words {
                        display: flex;
                        margin-bottom: 30px;
                        justify-content: space-evenly;

                        .letter {
                            border: solid 1px black;
                            width: 20px;
                            height: 20px;
                            cursor: pointer !important;
                        }

                        .block {
                            border: solid 1px;
                            background-color: white;
                            width: 20px;
                            height: 20px;
                            font-size: 12px;
                            font-weight: bold;
                            cursor: pointer !important;

                        }

                        .underscore {

                        }
                    }

                    .container {
                        display: flex;
                        margin-bottom: 20px;
                        flex-wrap: wrap;

                        .letter {
                            border: solid 1px white;
                            width: 20px;
                            height: 20px;
                        }

                        .block {
                            background-color: white;
                            border: solid 1px;
                            width: 20px;
                            height: 20px;
                            font-size: 12px;
                            font-weight: bold;
                            margin: 10px;
                            cursor: pointer !important;
                        }
                    }

                    .ask-question {
                        font-weight: bold;
                        margin-bottom: 20px;


                        .question {
                            margin-top: 10px;
                            font-size: 16px;
                        }
                    }
                }

                .input-group {
                }

                .arrow-element-prev {
                    display: none;
                }

                .arrow-element {
                    margin-top: 37%;
                    font-size: 25px;
                    cursor: pointer;
                    font-weight: 900;

                    .arrow {
                        color: black;
                    }

                    .disabled {
                        color: #dddddd;
                    }
                }
            }

            .nav {
                justify-content: space-between;
                padding-top: 30px;

                .money {
                    flex: 0;
                    display: flex;
                    margin-right: 0;

                    .user-money {
                        margin-left: 10%;
                        align-self: center;
                        font-size: 12px;
                        font-weight: bold;
                    }

                    .money-img {
                        width: 30px;
                        height: 30px;
                    }
                }

                .block {
                    flex: 0;
                }

                .timer {
                    flex: 0;
                    margin-right: 0;
                    align-self: center;
                    font-size: 12px;
                    font-weight: bold;
                    display: flex;

                    .timer-clock {
                        margin-left: 10%;
                        align-self: center;
                        margin-right: 0;

                    }

                    .money-img {
                        width: 30px;
                        height: 30px;
                    }
                }
            }

            .row {
                margin-bottom: 10px;
            }

            .hint {
                font-size: 12px;
                text-align: center;
                cursor: pointer;
                outline: none;
                color: black;
                background-color: white;
                border-radius: 36px;
                border: solid 1px #2c3e50;
                line-height: 34px;
                content: 'עבור שאלה' !important;
                margin-left: 5%;

                button span {
                    display: none;

                }
            }

            .pass {
            }

            .for-mobile {
                display: block;
            }

            .for-computer {
                display: none;
            }

            .disabled-button {
                background-color: #dddddd;
            }

            .hint:hover:not([disabled]) {
                background-color: #e3dccc;
            }

            .hint:active:not([disabled]) {
                background-color: #e3dccc;
                transform: translateY(4px);
            }


            .success {
                font-size: 12px;
                font-weight: bold;
                border: solid 2px;
                background: white;
                border-radius: 10px;
                width: 224px;
                margin-top: 10%;
                margin-left: auto;
                margin-right: auto;


                .beautiful {
                    font-size: 12px;
                    color: #e21e00;
                }

                .message {
                    font-size: 12px;
                }
            }
        }


    }


</style>

