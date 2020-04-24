<template>
    <b-container fluid class="game">
        <b-row class="instructions">
            <b-col cols="12">
                <div>
                    <span class="title"> הנחיות</span>
                </div>
                <div class="instructions">
                    בכל חידה תופיע שאלה שאת התשובה שלה ניתן לגלות על ידי משחק מילים, כאשר
                    ברוב החידות ניתן יהיה לשמוע את אותו הדבר בדיוק עבור שתי משמעויות שונות.
                    על מנת לענות על החידות יש להעביר את האותיות אל המקום המתאים להם בשורת
                    התשובה, יש לכתוב את המילה בצורה המדויקת. לאחר מתן תשובה נכונה אפשר
                    יהיה לעבור לשאלה הבאה. מומלץ לנסות לחשוב בראש על תשובה לאחת מהשאלות
                    ולאחר מכן לבדוק האם היא תואמת לחצי השני של השאלה.
                    את המשחק מתחילים עם 100 מטבעות ועל כל שאלה נכונה שעונים עליה תוך פחות
                    מ-2 דקות יתקבל בונוס של 10 מטבעות.
                    במידה ורוצים לקבל עזרה – ניתן ללחוץ על מקש &quot;מתקשה? קח רמז&quot; עזרה זו תוריד
                    30 מטבעות

                </div>
            </b-col>
        </b-row>

    </b-container>
</template>

<script lang="ts">
    import {Component, Prop, Vue} from 'vue-property-decorator';

    @Component
    export default class Instructions extends Vue {

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
            padding: 100px;

            .title {
                font-size: 50px;
            }

            .instructions {
                margin-top: 20px;
                padding: 5px;
            }


        }

    }
</style>