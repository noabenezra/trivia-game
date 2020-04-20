<template>
    <b-container fluid class="game">
        <b-row class="instructions">
            <b-col cols="12">
                <div>
                    <span class="title"> הנחיות</span>
                </div>
                <div class="instructions">
                    ספר הוא טקסט מודפס או כתוב בכתב יד בנושא מסוים, שדפיו כרוכים יחדיו. בשלהי המאה העשרים החלה הפקתם של
                    ספרים אלקטרוניים המוצגים על קורא ספרים אלקטרוני, טאבלטים, צג המחשב ואפילו טלפונים חכמים.

                    עוד מימי בראשית אסף האדם את יצירותיו הספרותיות תחת ספרים. בתחילה היו אלה מגילות קלף, וספרים מצומצמים
                    בהיקפם. עם התפתחות הדפוס באמצע המאה ה-15 עלה היקפם של הספרים. במשך מאות שנים היו הספרים אמצעי עיקרי
                    להפצת ידע ולהעברתו מדור לדור. במאה העשרים נוספו לספרים המודפסים שלל אמצעים נוספים: רדיו, קולנוע,
                    טלוויזיה והאינטרנט, אך לספר ממשיך להישמר מקום מרכזי.

                    בתהליך יצירתו של ספר שני שלבים עיקריים:
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