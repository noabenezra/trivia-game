<template>
    <div class="Winners">
        <img class="image" src="../assets/11.png">
        <div class="title-winners">
            <span class="title">
             המובילים
            </span>
        </div>
        <div class="winner-table">
            <b-list-group v-for="user in users">
                <b-list-group-item>
                    <b-row>
                        <b-col cols="2"><span>{{ user.place }}</span></b-col>
                        <b-col cols="5"><span>{{ user.name }}</span></b-col>
                        <b-col cols="5"><span>{{ user.score }}<img src="../assets/123.png" class="money-img"
                                                                   alt="money"></span>
                        </b-col>
                    </b-row>

                </b-list-group-item>
            </b-list-group>
        </div>

    </div>
</template>

<script lang="ts">
    import {Component, Vue} from 'vue-property-decorator';
    import {UserEntity} from '@/models/UserEntity';

    @Component({})
    export default class FinishGame extends Vue {
        $store: any;
        private users: UserEntity[] = [];
        private placeInListOfWinners: number = 1;

        mounted() {
            this.getUsersList();
        }

        getUsersList() {
            this.$store.dispatch('triviaGameStore/getUsers').then((res: any) => {
                    if (res && res.data) {
                        res.data = res.data.sort(function (a: { score: number; }, b: { score: number; }) {
                            return b.score - a.score;
                        }).slice(0, 10);
                        res.data.forEach((item: UserEntity) => {
                            this.users.push({
                                id: item.id,
                                name: item.name,
                                score: item.score,
                                numberOfAnswerQuestions: item.numberOfAnswerQuestions,
                                place: this.placeInListOfWinners++
                            });
                        })
                    }
                }
            ).catch();
        }

    }
</script>
<style scoped lang="scss">
    .Winners {
        .image {
            width: 200px;
        }

        .title-winners {
            border: solid 1px black;
            background-color: white;
            margin-bottom: 5%;
            margin-top: -50px;
            position: relative;

            .title {
                font-size: 50px;
            }
        }

        .winner-table {
            margin-top: -47px;
            position: relative;

            .list-group {
                border: solid 1px black;
                display: flex;


                .list-group-item {
                    height: 70px;
                    font-size: 30px;

                    background-color: #ffffff9e;

                    .money-img {
                        width: 50px;
                    }
                }
            }
        }
    }
</style>
