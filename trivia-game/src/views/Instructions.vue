<template>
    <b-container fluid class="game">
        <b-row class="instructions">
            <b-col cols="12">
                <b-row>
                    <b-col cols="12">
                        <span class="title"> הנחיות</span>
                    </b-col>
                </b-row>
                <b-row>
                    <b-col cols="12">
                        <div class="instructions">
                            <p>
                                בכל חידה תופיע שאלה שאת התשובה שלה ניתן לגלות על ידי משחק מילים, כאשר
                                ברוב החידות ניתן יהיה לשמוע את אותו הדבר בדיוק עבור שתי משמעויות שונות.
                                <br><br>
                                על מנת לענות על החידות יש להעביר את האותיות אל המקום המתאים להם בשורת
                                התשובה, יש לכתוב את המילה בצורה המדויקת. לאחר מתן תשובה נכונה אפשר
                                יהיה לעבור לשאלה הבאה. מומלץ לנסות לחשוב בראש על תשובה לאחת מהשאלות
                                ולאחר מכן לבדוק האם היא תואמת לחצי השני של השאלה.
                                <br><br>
                                את המשחק מתחילים עם 100 מטבעות ועל כל שאלה נכונה שעונים עליה תוך פחות
                                מ-2 דקות יתקבל בונוס של 10 מטבעות.
                                <br>
                                במידה ורוצים לקבל עזרה - ניתן ללחוץ על כפתור "מתקשה? קח רמז".
                                <br>
                                במידה ואתם לא מצליחים לפתור את השאלה
                                ניתן ללחוץ על כפתור עבור שאלה - לחיצה על כפתור זה תוריד 30 מטבעות
                                <br><br>
                                בהצלחה!
                            </p>
                            <b-button class="btn" @click="startGame" v-if="$route.params.fromHomePage">
                                <svg width="180px" height="60px" viewBox="0 0 180 60">
                                    <polyline points="179,1 179,59 1,59 1,1 179,1" class="bg-line"/>
                                    <polyline points="179,1 179,59 1,59 1,1 179,1" class="hl-line"/>
                                </svg>
                                <span>התחל לשחק</span>
                            </b-button>
                        </div>
                    </b-col>
                </b-row>
            </b-col>
        </b-row>
    </b-container>
</template>

<script lang="ts">
    import {Component, Prop, Vue} from 'vue-property-decorator';

    @Component({})
    export default class Instructions extends Vue {
        $router: any;

        startGame() {
            this.$router.push('/game');
        }
    }
</script>
<style scoped lang="scss">
    .game {
        background-image: url("../assets/t.png");
        background-repeat: no-repeat;
        background-size: cover;
        background-color: #ffffff69;
        margin-left: 20%;
        height: 97%;
        border: #ffffff69;

        .instructions {
            font-size: 22px;
            padding: 100px;
            font-weight: bold;

            .title {
                font-size: 50px;
            }

            .instructions {
                margin-top: 20px;
                padding: 5px;

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
                    left: 270px;
                    top: 592px;
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

    }

    @media screen and (max-width: 770px) {
        .game {
            background-image: none;
            margin-left: 0;
            height: 454px;

            padding-left: 0;
            margin-right: 0;
            border: none;
            background-color: transparent;
            width: unset;

            .instructions {
                font-size: 10px;
                font-weight: bold;
                padding: 10px;
                margin-top: 0;

                p {
                    font-size: 15px;
                }

                .title {
                    font-size: 17px;
                }

                .instructions {
                    margin-top: 5px;

                    .btn {
                        width: 150px;
                        height: 50px;
                        cursor: pointer !important;
                        border: 1px solid black;
                        outline: none;
                        background: #fffffff5;
                    }

                }


            }

        }
    }
</style>