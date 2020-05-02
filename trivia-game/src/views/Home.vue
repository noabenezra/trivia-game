<template>
    <section>
        <div class="title">
            <div cols="12" class="summery">
                <p>
                    ברוכים הבאים למשחק הטריוויה הראשון מסוגו בעולם שמפעיל את התאים האחוריים במח שלנו, עליכם למצוא משחקי
                    מילים נסתרים וצמדי ביטויים אשר נשמעים בדיוק אותו הדבר.
                    <br>
                    מאחלים לכם בהצלחה!
                </p>
            </div>
        </div>

        <div class="container">

            <div class="center">
                <div class="title">
                    <div class="x">
                        <b-form-input class="name" v-model="userEntity.name" placeholder="בבקשה הכנס שם"/>
                        <div>
                            <span v-if="this.error" class="errors">{{this.error}}</span>
                        </div>

                    </div>
                </div>
                <b-button class="btn" @click="startGame">
                    <!--  <svg width="180px" height="60px" viewBox="0 0 180 60">
                          <polyline points="179,1 179,59 1,59 1,1 179,1" class="bg-line"/>
                          <polyline points="179,1 179,59 1,59 1,1 179,1" class="hl-line"/>
                      </svg>-->
                    <span>התחל לשחק</span>
                </b-button>
            </div>
        </div>
    </section>

</template>

<script lang="ts">
    import {Component, Prop, Vue, Watch} from 'vue-property-decorator';
    import {UserEntity} from "@/models/UserEntity";

    @Component({})
    export default class Home extends Vue {
        @Prop() private msg!: string;
        private error: string = "";
        $router: any;
        $store: any;
        private userEntity: UserEntity = {
            name: "",
            score: 100,
            numberOfAnswerQuestions: 0
        }


        startGame() {
            if (!this.userEntity.name) {
                this.error = 'אנא הכנס שם';
            } else {
                this.saveUser();
                this.$router.push({name: 'Instructions', params: {fromHomePage: true}});
            }
        }

        saveUser() {
            this.$store.dispatch('triviaGameStore/saveUser', this.userEntity).then((res: any) => {
                    if (res && res.data) {
                        this.userEntity.id = res.data;
                    }
                }
            ).catch();
        }
    }
</script>
<style scoped lang="scss">
    .title {
        font-size: 23px;

        .summery {
        }
    }

    .title {
        .x {
            margin-bottom: 4%;

            .name {
                border: solid 1px black;
                text-align: center;
            }
        }
    }

    .errors {
        position: relative;
        color: red;
        font-size: 15px;
    }

    .container {
        width: 100px;
        height: 100px;
        // position: absolute;

        // left: 48%;
        // transform: translate(-28%, 0%);
        display: flex;
        justify-content: center;
        align-items: center;

        .center {
            width: 180px;
            height: 60px;
            position: absolute;

            .btn {
                width: 180px;
                height: 60px;
                cursor: pointer !important;
                border: 1px solid black;
                outline: none;
                transition: 1s ease-in-out;
                background: #fffffff5;
            }

            svg {
                position: absolute;
                left: 0px;
                top: 45px;
                fill: none;
                stroke: black;
                stroke-dasharray: 150 480;
                stroke-dashoffset: 150;
                transition: 1s ease-in-out;
            }

            .btn:hover {
                transition: 1s ease-in-out;
                background: #fffffff5;
            }

            .btn:hover svg {
                stroke-dashoffset: -480;
            }

            .btn span {
                color: black;
                font-size: 18px;
                font-weight: 100;
            }
        }
    }


    @media only screen and (max-width: 1000px) {
        .title {
            .summery {
                padding: 5% 5% 0 5%;
            }
        }
        .container {
            .center {
            }
        }

    }
</style>
