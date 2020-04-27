<template>
    <div class="container">
        <div class="center">
            <b-button class="btn" @click="startGame">
                <svg width="180px" height="60px" viewBox="0 0 180 60">
                    <polyline points="179,1 179,59 1,59 1,1 179,1" class="bg-line"/>
                    <polyline points="179,1 179,59 1,59 1,1 179,1" class="hl-line"/>
                </svg>
                <span>התחל לשחק</span>
            </b-button>
        </div>
    </div>
</template>

<script lang="ts">
    import {Component, Prop, Vue} from 'vue-property-decorator';

    @Component({})
    export default class Home extends Vue {
        @Prop() private msg!: string;
        $router: any;

        startGame() {
            this.$router.push({name: 'Instructions', params: {fromHomePage: true}});
        }
    }
</script>
<style scoped lang="scss">

    .container {
        width: 400px;
        height: 400px;
        position: absolute;
        left: 50%;
        transform: translate(-28%, 41%);
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
                left: 0;
                top: 0;
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

    @media screen and (min-width: 1300px) and (max-width: 1800px) {
        .container {
            left: 40%;
        }
    }

    @media screen and (min-width: 1150px) and (max-width: 1299px) {
        .container {
            left: 30%;
        }
    }

    @media screen and (min-width: 1000px) and (max-width: 1149px) {
        .container {
            left: 25%;
        }
    }

    @media screen and (min-width: 771px) and (max-width: 999px) {
        .container {
            left: 17%;
        }
    }

    @media only screen and (max-width: 770px) {
        .container {
            align-items: flex-start;

            .center {
                left: 10%;
            }
        }

    }
</style>
