<template>
    <div id="app" class="app">


        <div class="nav-for-laptop">
            <nav class="navbar navbar-expand-md tm-nav-bar" id="tmNav">
                <div class="container">
                    <div class="tm-next">
                        <a class="nav-bar-brand  current">כפל לשון</a>
                    </div>
                    <button class="navbar-toggler" type="button" data-toggle="collapse"
                            data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                            aria-expanded="false" aria-label="Toggle navigation">
                        <i class="fas fa-bars navbar-toggler-icon"></i>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav ml-auto">
                            <li class="nav-item">
                                <router-link class="nav-link tm-nav-link current" to="/">דף הבית</router-link>
                            </li>
                            <li class="nav-item">
                                <router-link class="nav-link tm-nav-link current" to="/instructions">הנחיות
                                </router-link>
                            </li>
                            <li class="nav-item">
                                <router-link class="nav-link tm-nav-link" to="/about">מי אנחנו</router-link>
                            </li>

                        </ul>
                    </div>
                </div>
            </nav>
        </div>
        <div class="nav-for-mobile">
        </div>

        <div class="trivia-game">
            <router-view></router-view>
        </div>
    </div>
</template>

<style scoped lang="scss">

    .app {
        position: relative;
        height: 1200px;
        background-color: black;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
        text-align: center;
        color: #2c3e50;
        background-image: url("../public/images/background.png");
        background-repeat: repeat;
        background-size: 100%;

        .nav-for-laptop {
            .tm-nav-bar {
                width: 100%;
                z-index: 1000;
                background-color: transparent;
                transition: all 0.3s ease;
                margin-bottom: 2%;

                .nav-bar-brand {
                    color: black;
                    font-size: 1.4rem;
                    font-weight: bold;
                }

                .nav-item {
                    list-style: none;
                    font-size: 20px;

                    .tm-nav-link {
                        color: black;
                    }
                }

                .navbar-toggler {
                    border: 1px solid black;
                    padding-left: 10px;
                    padding-right: 10px;
                }
            }

            @media (min-width: 768px) {
                .navbar-expand-md .navbar-nav .nav-link {
                    padding-right: 30px;
                    padding-left: 30px;
                }
            }
        }

        .nav-for-mobile {
            display: none;
        }

        .trivia-game {
            position: absolute;
            left: 21%;
            height: 80%;
            padding-left: 66px;
            padding-right: 66px;
            width: 1050px;
        }
    }

    @media screen and (max-width: 770px) {
        .app {
            // width: 188%;
            //  height: 812px;
            min-height: 812px;

            .nav-for-laptop {
                display: none;
            }

            .nav-for-mobile {
                display: block;
            }
        }
        .trivia-game {
            position: unset !important;
            width: auto !important;
            left: 0 !important;
            height: 0 !important;

            padding-right: 20px !important;
            padding-left: 20px !important;
            // width: 0 !important;
            //  height: 0 !important;
        }
    }
</style>
