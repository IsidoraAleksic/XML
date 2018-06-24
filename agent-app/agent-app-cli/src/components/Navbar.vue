template>
    
    <nav class="navbar navbar-dark bg-dark">
                <a @click="$router.push('/home')" class="navbar-brand" href="#">Home</a>
                <a @click="$router.push(-1)" class="navbar-brand" href="#">Back</a>
    </nav>

</template>


<script>
    import * as axios from 'axios';

    const BASE_URL = 'http://localhost:8082/agent';


    export default {
        name : 'Navbar',
        data() {
            return {
                username : ''
            }
        },
        methods : {
            initData() {
                const url = `${BASE_URL}/auth`;

                axios.get(url)
                        .then(x => {
                            this.username = x.data;
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