<template>

    <div class="jumbotron text-center text-lg-left">
        <div class="row">
            <div class="col-md-3">
                <label>From: </label>
                <datepicker v-model="fromDate.current" @input="selectedFromDate" :disabledDates="fromDate.disabled"></datepicker>    
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

    export default {

        name : 'dp',
        props : ['unit'],
        components : {
            Datepicker
        },
        data() {
            return {
                unitId : this.unit, 
                fromDate : {
                    current : new Date(),
                    disabled : {
                        ranges : []
                    }
                },
                toDate : {
                    current : new Date(),
                    disabled : {
                        to : new Date(2018, 1, 1),
                        ranges : []
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
                axios.post(url, data)
                        .then(x => {
                            (x.data === true) ? alert('Reservation success') : alert('Reservation failure'); 
                        });
                this.$parent.toggleShowBook();
            }
        },
        created() {
            const url = `${BASE_URL}/book/get/`+ this.unitId;
            let self = this;
            
            axios.get(url)
                    .then(res => {                        
                        let ret = res.data.map( x => {
                            let obj = {
                                from : new Date(
                                    new Date(x.fromDate).getFullYear(),
                                    new Date(x.fromDate).getMonth(),
                                    new Date(x.fromDate).getDate()
                                    ),
                                to : new Date(
                                    new Date(x.toDate).getFullYear(),
                                    new Date(x.toDate).getMonth(),
                                    new Date(x.toDate).getDate()
                                    ) 
                            }
                            return obj;
                        })  
                        self.fromDate.disabled.ranges = self.fromDate.disabled.ranges.concat(ret);
                        self.toDate.disabled.ranges = self.toDate.disabled.ranges.concat(ret);
                    });
        }
    }

</script>

<style>
    

</style>