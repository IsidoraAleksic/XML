<template>

    <div class="container">


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
        props : ['unit'],
        data() {
            return {
                unitId : this.unit, //ovo ce da se dobavlja na osnovu otvorenog smjestaja
                images : []
            }
        },
        methods : {
            getImageSrc(imgData) {
                return 'data:image/' + imgData.format + ';base64,' + imgData.content;
            }
        },
        created() {
            //ovo nece ici na mounted nego na event i id ce bit dinamicki
            axios.get(BASE_URL + '/photos/get/'+this.unitId)
                    .then(x => {
                        this.images = this.images.concat(x.data);
                    });
        }
    }
</script>

<style>
    
</style>