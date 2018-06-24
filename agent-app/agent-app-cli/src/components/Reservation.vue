<template>
<div>
    <nav class="navbar navbar-dark bg-dark">
                <a @click="$router.push('/home')" class="navbar-brand" href="#">Home</a>
                <a @click="$router.push(-1)" class="navbar-brand" href="#">Back</a>
    </nav>
    <div class="jumbotron">
        <div class="panel-body">
                <ul class="list-group">
                    <li v-for="res in reservations" class="list-group-item">
                        <div class="row">
                            <div class="col-xs-2 col-md-1">
                                <img src="http://icons.iconarchive.com/icons/double-j-design/origami-colored-pencil/256/blue-home-icon.png" alt="" width="80" height="80"/></div>
                            <div class="col-xs-10 col-md-11">
                                <div>
                                    <div class="mic-info">
                                        <h2>
                                            {{res.accommodationUnit.place}}
                                        </h2>
                                    </div>
                                </div>
                                <div class="comment-text">
                                    from {{getResDate(res.fromDate)}} to {{getResDate(res.toDate)}} 
                                </div>
                               
                                <button @click="setCurrentReservationId(res.id)" class="btn btn-primary btn-lg">
                                  <span class="glyphicon glyphicon-envelope"></span>Confirm reservation
                                </button>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
    </div>
</div>
</template>

<script>
    
    import * as axios from 'axios';

    const BASE_URL = 'http://localhost:8082/agent';


    export default {
        name : 'Reservation',
        data() {
            return {
                reservations : []
            }
        },
        methods : {
            initData() {
                const url = `${BASE_URL}/book/get/unconfirmed`;

                axios.get(url)
                        .then(x => {
                            this.reservations = this.reservations.concat(x.data);
                        });
            },
            getResDate(date) {
                let datee = new Date(date);
                return datee.getDate() + '-' + (datee.getMonth()+1) + '-' + datee.getFullYear();
            },
            setCurrentReservationId(resId) {

                const url = BASE_URL+'/book/confirm/'+resId;

                axios.get(url)
                        .then(x => {
                            (x.data === true) ? alert('Success!') : alert('Too early to confirm!');
                        });
            }
        },
        created() {
            this.initData();
        }
    }


</script>

<style>
    

</style>