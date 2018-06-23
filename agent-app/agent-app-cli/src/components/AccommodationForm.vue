<template>
    <div class="container text-center text-lg-left">
        <div class="row justify-content-center">
        <div class="col-md-6">
        <div class="card">
        <header class="card-header">
            <a href="" class="float-right btn btn-outline-primary mt-1">Back</a>
            <h5 class="card-title mt-2">New accommodation unit</h5>
        </header>
        <article class="card-body">
        <form id="form">
            <div class="form-group">
                <div class="row">
                    <div class="col-md-6">
                        <label>City:</label>
                        <input v-model="temp.city" type="text" class="form-control" placeholder="">
                    </div>

                    <div class="col-md-6">
                        <label>Country:</label>
                        <input v-model="temp.country" type="text" class="form-control" placeholder="">
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label>Address:</label>
                <input v-model="temp.address" type="text" class="form-control" placeholder="">
            </div>

            <div class="form-row">
                <div class="form-group">
                    <label>Enter description: </label>                
                </div><hr>
                <div class="form-group">
                    <textarea v-model="data.description" rows="4" cols="44">
                    </textarea>    
                </div>
            </div> 

            <br>

            <div class="form-group">
                <label>Upload photos: </label>
                <ImageForm></ImageForm>
            </div>

           <br>

           <div class="row">
            
            <div class="col-md-2">
                <label>Capacity:</label>                
            </div>

            <div class="col-md-7">
                <div class="row">
                    <div class="col-md-4">
                        <div class="input-group">
                            <input v-model="data.capacity" type="number" class="form-control input-number" min="1" max="500">
                        </div>
                    </div>
                </div>
            </div>

           </div>
           <br>
           <br>

           <div class="row">
                <div class="col-md-6">
                   <label>Enter accommodation pricing (per day of month):</label>
                </div>
           </div>
           <br>

           <hr>
           <div class="row">
                <div class="col-md-4">
                    <div class="row">
                        <div class="col-md-6">
                            <label>January:</label>
                        </div>                
                    </div>
                    <div class="row">
                        <div class="col-md-8">
                            <input v-model="data.accommodationPricing.january" type="number" class="form-control input-number" min="1" max="500">
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="row">
                        <div class="col-md-6">
                            <label>February:</label>                
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-8">
                            <input v-model="data.accommodationPricing.february" type="number" class="form-control input-number" min="1" max="500">
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="row">
                        <div class="col-md-6">
                            <label>March:</label>                
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-8">
                            <input v-model="data.accommodationPricing.march" type="number" class="form-control input-number" min="1" max="500">
                        </div>
                    </div>
                </div>                
           </div> 

            <div class="row">
                <div class="col-md-4">
                    <div class="row">
                        <div class="col-md-6">
                            <label>April:</label>
                        </div>                
                    </div>
                    <div class="row">
                        <div class="col-md-8">
                            <input v-model="data.accommodationPricing.april" type="number" class="form-control input-number" min="1" max="500">
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="row">
                        <div class="col-md-6">
                            <label>May:</label>                
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-8">
                            <input v-model="data.accommodationPricing.may" type="number" class="form-control input-number" min="1" max="500">
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="row">
                        <div class="col-md-6">
                            <label>June:</label>                
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-8">
                            <input v-model="data.accommodationPricing.june" type="number" class="form-control input-number" min="1" max="500">
                        </div>
                    </div>
                </div>  
           </div> <!-- row 2 end -->

            <div class="row">
                <div class="col-md-4">
                    <div class="row">
                        <div class="col-md-6">
                            <label>July:</label>
                        </div>                
                    </div>
                    <div class="row">
                        <div class="col-md-8">
                            <input v-model="data.accommodationPricing.july" type="number" class="form-control input-number" min="1" max="500">
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="row">
                        <div class="col-md-6">
                            <label>August:</label>                
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-8">
                            <input v-model="data.accommodationPricing.august" type="number" class="form-control input-number" min="1" max="500">
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="row">
                        <div class="col-md-6">
                            <label>September:</label>                
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-8">
                            <input v-model="data.accommodationPricing.september" type="number" class="form-control input-number" min="1" max="500">
                        </div>
                    </div>
                </div> 
           </div> <!-- row 3 end -->

            <div class="row">
                <div class="col-md-4">
                    <div class="row">
                        <div class="col-md-6">
                            <label>October:</label>
                        </div>                
                    </div>
                    <div class="row">
                        <div class="col-md-8">
                            <input v-model="data.accommodationPricing.october" type="number" class="form-control input-number" min="1" max="500">
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="row">
                        <div class="col-md-6">
                            <label>November:</label>                
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-8">
                            <input v-model="data.accommodationPricing.november" type="number" class="form-control input-number" min="1" max="500">
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="row">
                        <div class="col-md-6">
                            <label>December:</label>                
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-8">
                            <input v-model="data.accommodationPricing.december" type="number" class="form-control input-number" min="1" max="500">
                        </div>
                    </div>
                </div>
           </div> <!-- row 4 end -->
            <hr>
            <br>
            <!-- end pricing -->

            <div class="form-group">
                <label>Choose accommodation type: </label>
                <div> 
                    <template>
                      <div>
                        <multiselect v-model="selectedType" :options="types" ></multiselect>
                      </div>
                    </template>
                </div>
            </div>


            <div class="form-group">
                <label>Choose accommodation category: </label>
                <div> 
                    <template>
                      <div>
                        <multiselect v-model="selectedCategory" :options="categories"></multiselect>
                      </div>
                    </template>
                </div>
            </div>


            <div class="form-group">
                <label>Choose additional services: </label>
                <div> 
                    <template>
                      <div>
                        <multiselect v-model="selectedServices" :options="additionalServices" :multiple="true"></multiselect>
                      </div>
                    </template>
                </div>
            </div>                    

            <br>

            <div class="form-group">
                <button @click="sendFormData" type="button" class="btn btn-primary btn-block"> Save  </button>
            </div>                                      
        </form>
        </article> 
        </div> 
        </div> 

        </div> 


</div> 

</template>

<script>

    import ImageForm from './ImageForm'
    import Multiselect from 'vue-multiselect'

    import * as axios from 'axios';

    const BASE_URL = 'http://localhost:8082/agent';

    export default {
        name : 'AccommodationForm',
        components : {
            ImageForm, Multiselect
        },
        data() {
            return {
                temp: {
                    city : '',
                    country : '',
                    address : ''
                },
                data: {
                    agent : {
                        id : 1
                    },
                    place : '',
                    description : '',
                    capacity : 1,
                    accommodationPricing : {
                        january : 0,
                        february : 0,
                        march : 0,
                        april : 0, 
                        may : 0, 
                        june : 0, 
                        july : 0, 
                        august : 0, 
                        september : 0, 
                        october : 0, 
                        november : 0, 
                        december : 0
                    }
                },
                selectedServices : null,
                selectedCategory : null,
                selectedType : null,
                categories: [],
                types : [],
                additionalServices : []
            }
        },
        methods : {
            sendFormData() {
                let sendData = this.data;

                //getuj id logovanog agenta i sendData.agent = {id}

                sendData.place = this.temp.address + ',' + this.temp.city + ',' + this.temp.country;
                sendData.capacity = parseInt(sendData.capacity);
                sendData.accommodationType = { typeName : this.selectedType};
                sendData.category = { categoryName : this.selectedCategory };
                sendData.additionalServices = this.selectedServices
                    .map( x => { return { name : x } });

                let tmpMap = {};
                tmpMap.accommodationUnit = {
                    id : 3333
                }
                Object.keys(sendData.accommodationPricing)
                    .forEach(function(key, index) {
                        tmpMap[key] = parseInt(sendData.accommodationPricing[key]);
                    });
                    
                sendData.accommodationPricing = tmpMap;

                // this.$emit('sendImages', JSON.stringify(sendData)); 

                //neces sad ovo nego pozovi slike da ti vrati child
                this.sendRequest(sendData);
            },
            sendRequest(data) {
                const url = `${BASE_URL}/accommodationUnit`;  //ovdje ce ovo 1 bit dinamicki
                let unitId = -1;

                axios.post(url, data)
                        .then(x => {
                            alert(x.data.id);
                            // unitId = x.data.id;
                            this.$emit('upload', x.data.id); 
                        });
            }
        },
        created() {
            const url = `${BASE_URL}/attributes`;
            axios.get(url)
                    .then(x => {
                        this.categories = x.data.categories;
                        this.types = x.data.types;
                        this.additionalServices = x.data.additionalServices;
                    });
        }
    }
    
</script>

<style src="vue-multiselect/dist/vue-multiselect.min.css"></style>
<style>

</style>