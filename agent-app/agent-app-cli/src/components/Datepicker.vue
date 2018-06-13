<template>

    <div class="jumbotron text-center text-lg-left">
        <div class="row">
            <div class="col-md-3">
                <label>From: </label>
                <datepicker v-model="fromDate.current" @input="selectedFromDate"></datepicker>    
            </div>
            <div class="col-md-3">
                <label>To: </label>
                <datepicker v-model="toDate.current" :disabledDates="toDate.disabled"></datepicker>    
            </div>
            <div class="col-md-2">
                <br>
                <button @click="sendDates" class="btn btn-primary" type="button">OK</button>
            </div>            
        </div>
    </div>

</template>


<script>
    import * as axios from 'axios';
    
    import Datepicker from 'vuejs-datepicker';

    const BASE_URL = 'http://localhost:8082/agent';

    // kad se ucita ovo za izabrani smjestaj, treba getovati zauzete intervale i disable-ovat ih 

    export default {

        name : 'dp',
        components : {
            Datepicker
        },
        data() {
            return {
                unitId : 1,  //ovo ce se proslijediti iz parent komponente nekako 
                fromDate : {
                    current : new Date()
                },
                toDate : {
                    current : new Date(),
                    disabled : {
                        to : new Date(2018, 1, 1)
                    }
                }
            }
        },
        methods : {
            selectedFromDate() {
                let d = this.fromDate.current;
                this.toDate.disabled.to = new Date(d.getFullYear(), d.getMonth(), d.getDate()+1);
            },
            sendDates() {
                let data = {   
                    unitId : this.unitId,
                    from : this.fromDate.current.getTime(),
                    to : this.toDate.current.getTime()
                }
                this.sendRequest(data);
            },
            sendRequest(data) {
                const url = `${BASE_URL}/book/bookInterval`;
                axios.post(url, data);  //then
            }
        }
    }

</script>

<style>
    

</style>