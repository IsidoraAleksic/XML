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
                        <input v-model="data.city" type="text" class="form-control" placeholder="">
                    </div>

                    <div class="col-md-6">
                        <label>Country:</label>
                        <input v-model="data.country" type="text" class="form-control" placeholder="">
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label>Address:</label>
                <input v-model="data.address" type="text" class="form-control" placeholder="">
            </div>

            <div class="form-group">
                <label>Accommodation type: </label>
                  <select v-model="data.accommodationType" class="form-control">
                      <option value="0">Hotel</option>
                      <option value="1">Bed & breakfast</option>
                      <option value="2">Apartment</option>
                  </select>
            </div>
            <br>

            <div class="form-row">
                <div class="form-group">
                    <label>Enter description: </label>                
                </div><hr>
                <div class="form-group">
                    <textarea v-model="data.description" rows="4" cols="44">
                    </textarea>    
                </div>
            </div> 

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

            <div class="form-group">
                <label>Choose options: </label>
                <div class="row">
                    
                    <div class="col-md-4">
                        <div class="form-check">
                            <input v-model="data.wifi" class="form-check-input" type="checkbox" value="" >
                            <label class="form-check-label" for="defaultCheck1">
                            WiFi
                            </label>
                        </div>
                        <div class="form-check">
                            <input v-model="data.parking" class="form-check-input" type="checkbox" value="" >
                            <label class="form-check-label" for="defaultCheck2">
                            Parking
                            </label>
                        </div>    
                    </div>

                    <div class="col-md-4">
                        <div class="form-check">
                            <input v-model="data.breakfast" class="form-check-input" type="checkbox" value="" >
                            <label class="form-check-label" for="defaultCheck1">
                            Breakfast
                            </label>
                        </div>
                        <div class="form-check">
                            <input v-model="data.tv" class="form-check-input" type="checkbox" value="" >
                            <label class="form-check-label" for="defaultCheck2">
                            TV
                            </label>
                        </div>    
                    </div>

                    <div class="col-md-4">
                        <div class="form-check">
                            <input v-model="data.privateBathroom" class="form-check-input" type="checkbox" value="" >
                            <label class="form-check-label" for="defaultCheck1">
                            Private bathroom
                            </label>
                        </div>
                        <div class="form-check">
                            <input v-model="data.kitchen" class="form-check-input" type="checkbox" value="" >
                            <label class="form-check-label" for="defaultCheck2">
                            Kitchen
                            </label>
                        </div>    
                    </div>
                </div>      
            </div> <!-- checkbox area done -->

            <br>

            <div class="form-group">
                <button @click="sendFormData" type="button" class="btn btn-primary btn-block"> Save  </button>
            </div> <!-- form-group// -->                                      
        </form>
        </article> <!-- card-body end .// -->
        </div> <!-- card.// -->
        </div> <!-- col.//-->

        </div> <!-- row.//-->


</div> 

</template>

<script>

    import ImageForm from './ImageForm'
    import * as axios from 'axios';

    const BASE_URL = 'http://localhost:8082/agent';

    export default {
        name : 'AccommodationForm',
        components : {
            ImageForm
        },
        data() {
            return {
                data: {
                    city : '',
                    country : '',
                    address : '',
                    description : '',
                    capacity : 1,
                    accommodationType : '1',      //kad budes slala na bek salji kao int
                    wifi: false,
                    parking : false,
                    breakfast : false,
                    tv : false,
                    privateBathroom : false,
                    kitchen : false    
                }
            }
        },
        methods : {
            sendFormData() {
                //axios request
                //kad vrati accommodation unit
                //this.$event.emit() za upload slika
                let sendData = this.data;
                sendData.capacity = parseInt(sendData.capacity);
                sendData.accommodationType = parseInt(sendData.accommodationType);
                // sendData = JSON.stringify(sendData);
                alert(JSON.stringify(sendData))
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
        }
    }
    
</script>

<style>

</style>