<template>
    <b-container fluid class="game">
        <b-row class="about-us">
            <b-col class="about" cols="12">
                <b-row class="who-are-we">
                    <b-col cols="12">
                        <span class="title">מי אנחנו</span>
                    </b-col>
                </b-row>

                <b-row class="about-me">
                    <b-col cols="2" class="image-column">
                        <img class="image" src="../assets/noa3.png">
                    </b-col>
                    <b-col cols="9" class="p-0">
                        <span>
                              מפתחת האתר – נועה בן עזרא, בעלת תואר במדעי המחשב, בעל ניסיון של מפתחת
                            Full-Stack מזה כשלוש שנים. כיום עובדת בכימיקלים לישראל.
                        </span>
                    </b-col>
                </b-row>
                <b-row class="about-me">
                    <b-col cols="2" class="image-column ">
                        <img class="image" src="../assets/avi3.png">
                    </b-col>
                    <b-col cols="9" class="p-0">
                        <span>
                           כותב החידות – אבי אידל, בעל תואר בראיית חשבון, כיום עובד במשרד האוצר.
                        </span>
                    </b-col>
                </b-row>
                <b-row class="next">
                    <b-col cols="12">
                        המשחק נועד לתת במה לחידות רבות שנאספו ורק חיפשו את הבמה על מנת לשתף
                        אותן עם קהל רב יותר של אנשים. החידות מכילות אלמנט של משחקי מילים כמו גם
                        משחק כפל לשון ומעוררות חושים רבים שלא תמיד מופעלים אצלנו במוח.
                    </b-col>
                </b-row>
            </b-col>
        </b-row>

    </b-container>
</template>

<script lang="ts">
    import {Component, Prop, Vue} from 'vue-property-decorator';

    @Component({})
    export default class About extends Vue {

    }
</script>
<style scoped lang="scss">

    .avatar {
        display: block;
        border-radius: 200px;
        box-sizing: border-box;
        background-color: #DDD;
        border: 5px solid #cfd8dc;
    }

    img {
        height: 200px;
        width: 200px
    }


    .game {
        background-image: url("../assets/t.png");
        background-repeat: no-repeat;
        background-size: cover;
        background-color: #ffffff69;
        margin-left: 20%;
        height: 97%;
        border: #ffffff69;

        .about-us {
            padding: 100px 50px 100px 50px;

            .about {
                font-size: 20px;
                font-weight: bold;
                padding: 5px;

                .next {
                    padding-right: 116px;
                    padding-left: 100px;
                }

                .about-me {
                    margin-bottom: 40px;
                    align-items: center;

                    .image-column {
                        padding: 0;


                        height: 100px;
                        width: 80px;

                        .image {

                            height: 100%;
                            width: 80%;
                            border-radius: 50%;
                            border: solid 3px white;
                        }
                    }
                }

                .who-are-we {
                    margin-bottom: 40px;

                    .title {
                        font-weight: bold;
                        font-size: 50px;
                    }
                }
            }
        }
    }
</style>