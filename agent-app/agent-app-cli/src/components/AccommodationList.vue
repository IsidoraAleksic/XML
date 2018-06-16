<template>
    <div class="jumbotron">
        <div class="row" v-for="i in Math.ceil(accommodationUnits.length / 4)">
            <span v-for="unit in accommodationUnits.slice((i - 1) * 4, i * 4)">
                <div class="col-md-3 mb-4">
                    <div class="card" style="width: 18rem;">
                        <div class="card-header">
                            <h4><router-link :to="{ name: 'AccommodationView', params: { unitId : unit.id }}"> 
                            {{ getUnitAddress(unit.place) }}</router-link></h4>
                        </div>
                        <div class="card-body">
                            <p class="card-text"> {{ unit.description }}</p>
                        </div>
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item">{{ getUnitCity(unit.place) }}</li>
                            <li class="list-group-item">{{ getUnitCountry(unit.place) }}</li>
                        </ul>
                        <div class="card-body">
                            <a href="#" class="card-link">Card link</a>
                            <a href="#" class="card-link">Another link</a>
                        </div>
                    </div>
                </div>
            </span>
        </div>
        <br>
    </div>
</template>

<script>

    import * as axios from 'axios';

    const BASE_URL = 'http://localhost:8082/agent';

    export default {
        name : 'AccommodationList',
        data() {
            return {
                userId : 1,
                accommodationUnits : []
            }
        },
        methods : {
            getUnitAddress(location) {
                return location.split(',')[0];
            },
            getUnitCity(location) {
                return location.split(',')[1];
            },
            getUnitCountry(location) {
                return location.split(',')[2];
            }
        },
        created() {
            //post zahtjev da se dobavi lista svih smjestaja koje je kreirao loginovani user, salje se samo userId kad bude
            const url = `${BASE_URL}/accommodationUnit/get/1`;

            axios.get(url)
                    .then(x => {
                        alert(JSON.stringify(x.data));
                        this.accommodationUnits = this.accommodationUnits.concat(x.data); 
                    })
        }
    }
    
</script>

<style>
    
</style>