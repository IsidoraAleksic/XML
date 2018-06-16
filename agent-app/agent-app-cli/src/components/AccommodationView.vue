<template>

    <div class="jumbotron ">
        <h4 class="display-4" v-if="unit">{{ unit.place }}</h4>
                    <br>
                    <br>
        <div class="row">
            <div class="col-md-5">
                <form>

                    <div class="form-row">  
                        <label class="col-md-2">City:</label>
                        <input v-model="city" type="text" class="form-control col-md-10" placeholder="">
                    </div>
                    <br>
                   <div class="form-row">
                        <label class="col-md-2">Country:</label>
                        <input v-model="country" type="text" class="form-control col-md-10" placeholder="">
                    </div>
                    <br>
                    <div class="form-row">
                        <label class="col-md-2">Address:</label>
                        <input v-model="address" type="text" class="form-control col-md-10" placeholder="">
                    </div>
                    <br>

                    <div class="form-row">
                        
                            <label class="col-md-2">Enter description: </label>                
                        <hr>
                       
                            <textarea class="col-md-10" v-if="unit.description" v-model="unit.description" rows="4" cols="44">
                            </textarea>    
                        
                    </div> 
                </form>
            </div>
            <div class="col-md-7 text-center text-lg-left">
                <ImageView v-if="id" v-bind:unit="id"></ImageView>
            </div>
        </div>

        </div>
    </div>
    
</template>

<script>

    import ImageView from './ImageView';
    import * as axios from 'axios';

    const BASE_URL = 'http://localhost:8082/agent';

    export default {
        name : 'AccommodationView',
        components : { ImageView },
        data() {
            return {
                id : 0,
                place : '',
                unit : {}
            }
        },
        computed : {
            address() {
                return this.unit.place.split(',')[0];
            },
            city() {
                return this.unit.place.split(',')[1];
            },
            country() {
                return this.unit.place.split(',')[2];
            }
        },
        methods : {
            initData() {
                const url = `${BASE_URL}/accommodationUnit/`+this.id;

                axios.get(url)
                        .then(x => {
                         alert(JSON.stringify(x.data));
                         this.unit = x.data;   
                        });
            }
        },
        created() {
            this.id = this.$route.params.unitId;
            this.initData();
        }
    }
    
</script>

<style>
    
</style>