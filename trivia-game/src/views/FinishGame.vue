<template>
    <div class="pyro">
        <span class="success">
            הצלחת!
        </span>
        <span class="wow">
            אתה גאון!
        </span>
        <br>
        <span class="money">
            צברת
            {{$route.params.userMoney ?$route.params.userMoney: 100 }}
            מטבעות
        </span>
        <div class="go-winners">
              <span>
                סקרן לדעת מה יכולותיך ביחס לאחרים?
                     <router-link class="nav-link tm-nav-link current color" to="/winners">  לחץ כאן
                                </router-link>

              </span>
        </div>
        <div class="before"></div>
        <div class="after"></div>
    </div>
</template>

<script lang="ts">
    import {Component, Vue} from 'vue-property-decorator';

    @Component({})
    export default class FinishGame extends Vue {

    }

</script>
<style scoped lang="scss">

    $particles: 500;
    $width: 3000;
    $height: 1200;
    // Create the explosion...
    $box-shadow: ();
    $box-shadow2: ();
    @for $i from 0 through $particles {
        $box-shadow: $box-shadow,
        random($width)-$width / 2 + px random($height)-$height / 1.2 + px hsl(random(360), 100, 50);
        $box-shadow2: $box-shadow2, 0 0 #fff
    }

    @mixin keyframes($animationName) {
        @-webkit-keyframes #{$animationName} {
            @content;
        }

        @-moz-keyframes #{$animationName} {
            @content;
        }

        @-o-keyframes #{$animationName} {
            @content;
        }

        @-ms-keyframes #{$animationName} {
            @content;
        }

        @keyframes #{$animationName} {
            @content;
        }
    }

    @mixin animation-delay($settings) {
        -moz-animation-delay: $settings;
        -webkit-animation-delay: $settings;
        -o-animation-delay: $settings;
        -ms-animation-delay: $settings;
        animation-delay: $settings;
    }

    @mixin animation-duration($settings) {
        -moz-animation-duration: $settings;
        -webkit-animation-duration: $settings;
        -o-animation-duration: $settings;
        -ms-animation-duration: $settings;
        animation-duration: $settings;
    }

    @mixin animation($settings) {
        -moz-animation: $settings;
        -webkit-animation: $settings;
        -o-animation: $settings;
        -ms-animation: $settings;
        animation: $settings;
    }

    @mixin transform($settings) {
        transform: $settings;
        -moz-transform: $settings;
        -webkit-transform: $settings;
        -o-transform: $settings;
        -ms-transform: $settings;
    }


    .pyro > .before, .pyro > .after {
        position: absolute;
        width: 5px;
        height: 5px;
        border-radius: 50%;
        box-shadow: $box-shadow2;
        @include animation((1s bang ease-out infinite backwards, 1s gravity ease-in infinite backwards, 5s position linear infinite backwards));
    }

    .pyro > .after {
        @include animation-delay((1.25s, 1.25s, 1.25s));
        @include animation-duration((1.25s, 1.25s, 6.25s));
    }

    @include keyframes(bang) {
        to {
            box-shadow: $box-shadow;
        }
    }

    @include keyframes(gravity) {
        to {
            @include transform(translateY(200px));
            opacity: 0;
        }
    }

    @include keyframes(position) {
        0%, 19.9% {
            margin-top: 20%;
            margin-left: 40%;
        }
        20%, 39.9% {
            margin-top: 40%;
            margin-left: 30%;
        }
        40%, 59.9% {
            margin-top: 20%;
            margin-left: 70%
        }
        60%, 79.9% {
            margin-top: 30%;
            margin-left: 20%;
        }
        80%, 99.9% {
            margin-top: 30%;
            margin-left: 80%;
        }
    }

    .success {
        font-size: 50px;
        font-weight: 1000;
    }

    .wow {
        font-size: 50px;
        color: red;
        font-weight: 1000;
    }

    .money {
        font-size: 25px;
        font-weight: 1000;

    }

    .go-winners {
        .color {
            color: #2c3e50;
        }

        font-size: 25px;
    }

</style>