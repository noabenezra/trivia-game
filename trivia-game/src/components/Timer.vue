<template>
    <div class="Timer">
        {{ time | prettify }}
    </div>

</template>

<script lang="ts">
    import {Component, Prop, Vue, Watch} from 'vue-property-decorator';
    import EventBus from '../main';

    @Component({
        filters: {
            prettify(value: any) {
                let time: any = value / 60;
                let minutes: any = parseInt(time);
                let secondes: any = Math.round((time - minutes) * 60);
                if (minutes < 10) {
                    minutes = "0" + minutes;
                }
                if (secondes < 10) {
                    secondes = "0" + secondes;
                }
                return minutes + ":" + secondes;
            }
        }
    })
    export default class Timer extends Vue {
        private isRunning: boolean = false;
        private minutes: number = 2;
        private seconds: number = 0;
        private timer: any = null;
        private time: any = 0;

        mounted() {
            this.setTime();
            this.startClock();
        }

        @Watch('timer')
        eventBus() {
            EventBus.$on('stopTimer', (isStop: any) => {
                if (isStop) {
                    clearInterval(this.timer);
                }
            });
        }


        setTime() {
            this.time = (this.minutes * 60 + this.seconds);
        }


        startClock() {
            this.isRunning = true;
            if (!this.timer) {
                this.timer = setInterval(() => {
                    if (this.time > 0) {
                        this.time--;
                        this.$emit("timer", this.time);
                    } else {
                        // clearInterval(this.timer);
                        this.reset();
                    }
                }, 500);
            }
        }

        reset() {
            this.stop();
            this.time = 0;
            //this.seconds = 0;
            // this.minutes = 0;
        }

        stop() {
            this.isRunning = false;
            clearInterval(this.timer);
            this.timer = null;
        }


    }
</script>