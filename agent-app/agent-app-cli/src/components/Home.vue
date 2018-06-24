<template>
    <div class="row">
        <div class="col-md-3">
            <div class="card bg-light mb-3" style="max-width: 18rem;">
              <div class="card-body">
                <h5 class="card-title"><a @click="$router.push('/main')" href="#" >Create new accommodation unit</a></h5>
                <p class="card-text">Make your offer visible to the world.</p>
              </div>
            </div>    
        </div>
        <div class="col-md-3">
            <div class="card text-white bg-dark mb-3" style="max-width: 18rem;">
              <div class="card-body">
                <h5 class="card-title"><a @click="$router.push('/accList')" href="#" >Book an interval</a></h5>
                <p class="card-text">Make your accommodation unit unavailable for the desired period.</p>
              </div>
            </div>
        </div>
        <div class="col-md-3">
            <div class="card bg-light mb-3" style="max-width: 18rem;">
               <div class="card-body">
                <h5 class="card-title"><a @click="$router.push('/msg')" href="#" >Show messages</a></h5>
                <p class="card-text">See messages from reservations.</p>
              </div>
            </div>
        </div>
        <div class="col-md-3">
            <div class="card text-white bg-dark mb-3" style="max-width: 18rem;">
              <div class="card-body">
                <h5 class="card-title"><a @click="$router.push('/reservation')" href="#">Confirm reservations</a></h5>
                <p class="card-text">Confirm that reservations took place.</p>
              </div>
            </div>
        </div>
    </div>
</template>

<script>

    import * as axios from 'axios';


    const BASE_URL = 'http://localhost:8082/agent';


    export default {
        name : 'Home',
        data() {
            return {
                username : ''
            }
        },
        methods : {

        }
    }
    
</script>

<style>
    
</style>