<template>
<div class="container">
    <div class="row">
        <div class="col-md-offset-5 col-md-3">
            <div class="form-login">
            <h4>Welcome back.</h4>
            <input v-model="data.email" type="text" class="form-control input-sm chat-input" placeholder="username" />
            <br/>
            <input v-model="data.password" type="text" class="form-control input-sm chat-input" placeholder="password" />
            <br/>
            <div class="wrapper">
            <span class="group-btn">
                <a v-on:click="sendUserData"  class="btn btn-primary btn-md">login <i class="fa fa-sign-in"></i></a>
            </span>
            </div>
            </div>
        </div>
    </div>
</div>
</template>

<script>
    
    import * as axios from 'axios';

    const BASE_URL = 'http://localhost:8082/agent';

    
    export default {
        name: 'Login',
        data () {
            return {
                data: {
                    email: '',
                    password: ''      
                }
            }
        },
        methods: {
            sendUserData: function(event) {
                if (this.email === '' || this.password === '') {
                    alert('Email/password cannot be empty!');
                    return;
                }
                this.sendRequest(this.data);
            },
            sendRequest(data) {
                const url = `${BASE_URL}/auth`;
                axios.post(url, data)
                        .then( x => {
                            alert(x.data);
                            this.$router.push('/accList');
                        });
            }
        }
    }

</script>

<style>
    @import url(http://fonts.googleapis.com/css?family=Roboto:400);
body {
  background-color:#fff;
  -webkit-font-smoothing: antialiased;
  font: normal 14px Roboto,arial,sans-serif;
}

.container {
    padding: 25px;
    position: fixed;
}

.form-login {
    background-color: #EDEDED;
    padding-top: 10px;
    padding-bottom: 20px;
    padding-left: 20px;
    padding-right: 20px;
    border-radius: 15px;
    border-color:#d2d2d2;
    border-width: 5px;
    box-shadow:0 1px 0 #cfcfcf;
}

h4 { 
 border:0 solid #fff; 
 border-bottom-width:1px;
 padding-bottom:10px;
 text-align: center;
}

.form-control {
    border-radius: 10px;
}

.wrapper {
    text-align: center;
}

</style>
