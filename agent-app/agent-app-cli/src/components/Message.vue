<template>
    <div>
        <nav class="navbar navbar-dark bg-dark">
                <a @click="$router.push('/home')" class="navbar-brand" href="#">Home</a>
                <a @click="$router.push(-1)" class="navbar-brand" href="#">Back</a>
    </nav>
    <div class="container">
    <div class="row">
        <div class="col-md-6">
        <div class="panel panel-default widget">
            <div class="panel-heading">
                <span class="glyphicon glyphicon-comment"></span>
                <br>
                <h1 class="panel-title">
                    Messages
                </h1>    
            </div>
            <br>
            <hr>
            <div class="panel-body">
                <ul class="list-group">
                    <li v-for="res in reservations" class="list-group-item">
                        <div class="row">
                            <div class="col-xs-2 col-md-1">
                                <img src="https://previews.123rf.com/images/axsimen/axsimen1604/axsimen160400120/55913562-email-message-concept-new-incoming-message-sms-hand-holding-envelope-letter-delivery-of-messages-sms.jpg" class="img-circle img-responsive" alt="" width="80" height="80"/></div>
                            <div class="col-xs-10 col-md-11">
                                <div>
                                    <div class="mic-info">
                                        <h3>
                                        Reservation id: <a href="#">{{res.id}}</a>
                                        </h3>
                                    </div>
                                </div>
                                <div class="comment-text">
                                    <h4>
                                    {{res.accommodationUnit.place}}
                                    </h4>
                                </div>
                               
                                <button @click="setCurrentReservationId(res.id)" class="btn btn-primary btn-lg">
                                  <span class="glyphicon glyphicon-envelope"></span>Show messages
                                </button>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>

    <div v-if="!messages.length" class="col-md-6">
    <br><br><br>
        <h4>No messages</h4>
    </div>
    <div v-if="messages.length" class="col-md-6">
        <br><br><br>
        <ul class="list-group">
                    <li v-for="msg in messages" class="list-group-item">
                        <div class="row">
                            <div class="col-xs-10 col-md-11">
                                <div class="comment-text">
                                    <h5>{{msg.message}}</h5>
                                </div>
                            </div>
                        </div>
                    </li>
        </ul>
        <input v-model="messageContent" type="text" class="form-control" placeholder="">
        <button @click="sendMessage()" class="btn btn-primary btn-lg" >
            <span class="glyphicon glyphicon-envelope"></span>Reply
        </button>
    </div>
    </div>


</div>

</div>
</template>

<script>

    import * as axios from 'axios';

    const BASE_URL = 'http://localhost:8082/agent';

    export default {
        name : 'Message',
        data() {
            return {
                messages : [],
                reservations : [],
                currentReservationId : null,
                messageContent : ''
            }
        },
        methods : {
            reset() {
                this.messages = [];
                this.messageContent = '';
            },
            initData() {
                const url = `${BASE_URL}/book/getAll`;

                axios.get(url)
                        .then(x => {
                            this.reservations = this.reservations.concat(x.data);
                        });
            },
            setCurrentReservationId(resId) {
                this.currentReservationId = resId;
                const url = BASE_URL+'/message/all/'+resId;

                axios.get(url)
                        .then(x => {
                            this.messages = [];
                            this.messages = this.messages.concat(x.data);
                        });
            },
            sendMessage() {
                let data = {
                    message : this.messageContent,
                    agent : true,
                    reservation : {
                        id : this.currentReservationId
                    }
                }

                const url = `${BASE_URL}/message/send`;

                axios.post(url, data)
                        .then(x => {
                            alert('Message sent!');
                        });
                this.reset();
            }
        },
        created() {
            this.initData();
        }
    }

</script>

<style>
body { padding-top:30px; }
.widget .panel-body { padding:0px; }
.widget .list-group { margin-bottom: 0; }
.widget .panel-title { display:inline }
.widget .label-info { float: right; }
.widget li.list-group-item {border-radius: 0;border: 0;border-top: 1px solid #ddd;}
.widget li.list-group-item:hover { background-color: rgba(86,61,124,.1); }
.widget .mic-info { color: #666666;font-size: 11px; }
.widget .action { margin-top:5px; }
.widget .comment-text { font-size: 12px; }
.widget .btn-block { border-top-left-radius:0px;border-top-right-radius:0px; }
.ui-group-buttons .or{position:relative;float:left;width:.3em;height:1.3em;z-index:3;font-size:12px}
.ui-group-buttons .or:before{position:absolute;top:50%;left:50%;content:'';background-color:#5a5a5a;margin-top:-.1em;margin-left:-.9em;width:1.8em;height:1.8em;line-height:1.55;color:#fff;font-style:normal;font-weight:400;text-align:center;border-radius:500px;-webkit-box-shadow:0 0 0 1px rgba(0,0,0,0.1);box-shadow:0 0 0 1px rgba(0,0,0,0.1);-webkit-box-sizing:border-box;-moz-box-sizing:border-box;-ms-box-sizing:border-box;box-sizing:border-box}
.ui-group-buttons .or:after{position:absolute;top:0;left:0;content:' ';width:.3em;height:2.84em;background-color:rgba(0,0,0,0);border-top:.6em solid #5a5a5a;border-bottom:.6em solid #5a5a5a}
.ui-group-buttons .or.or-lg{height:1.3em;font-size:16px}
.ui-group-buttons .or.or-lg:after{height:2.85em}
.ui-group-buttons .or.or-sm{height:1em}
.ui-group-buttons .or.or-sm:after{height:2.5em}
.ui-group-buttons .or.or-xs{height:.25em}
.ui-group-buttons .or.or-xs:after{height:1.84em;z-index:-1000}
.ui-group-buttons{display:inline-block;}
.ui-group-buttons:after{content:".";display:block;height:0;clear:both;visibility:hidden}
.ui-group-buttons .btn{float:left;border-radius:0}
.ui-group-buttons .btn:first-child{margin-left:0;border-top-left-radius:.25em;border-bottom-left-radius:.25em;padding-right:15px}
.ui-group-buttons .btn:last-child{border-top-right-radius:.25em;border-bottom-right-radius:.25em;padding-left:15px}
</style>