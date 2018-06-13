<template>

    <div class="container">

        <h1 class="my-4 text-center text-lg-left">Accommodation photos</h1>

        <div class="row text-center text-lg-left">
            <template v-for="item in images">
                <div class="col-lg-3 col-md-4 col-xs-6">
                    <a href="#" class="d-block mb-4 h-100">
                        <img :src="getImageSrc(item)" class="img-fluid img-thumbnail">
                    </a>
                </div>
            </template>
        </div>
        
    </div>

</template>

<script>
    import * as axios from 'axios';

    const BASE_URL = 'http://localhost:8082/agent';


    export default {
        name : 'ImageView',
        data() {
            return {
                unitId : 0, //ovo ce da se dobavlja na osnovu otvorenog smjestaja
                images : []
            }
        },
        methods : {
            getImageSrc(imgData) {
                return 'data:image/' + imgData.format + ';base64,' + imgData.content;
            }
        },
        mounted() {
            //ovo nece ici na mounted nego na event i id ce bit dinamicki
            axios.get(BASE_URL + '/photos/get/1')
                    .then(x => {
                        this.images = this.images.concat(x.data);
                    });
        }
    }
</script>

<style>
    
</style>