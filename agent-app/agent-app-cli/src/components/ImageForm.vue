<template>
  
    <div class="container">
      <!--UPLOAD-->
      <h5 v-if="isSuccess">Upload success!</h5>
      <h5 v-if="isFailed">Upload failure!</h5>

      <form enctype="multipart/form-data" novalidate v-if="isInitial || isSaving">
        <div class="dropbox">
          <input type="file" multiple :name="uploadFieldName" :disabled="isSaving" @change="filesChange($event.target.name, $event.target.files); fileCount = $event.target.files.length" accept="image/*" class="input-file">
            <p v-if="isInitial">
              Drag your file(s) here to begin<br> or click to browse
            </p>
            <p v-if="isSaving">
              Uploading {{ fileCount }} files...
            </p>
        </div>
      </form>

      <ul class="list-unstyled">
          <li v-for="item in uploadedFiles">
            <img :src="item.url" class="img-responsive img-thumbnail" :alt="item.originalName">
          </li>
      </ul>
      
    </div>
  

</template>

<script>

    import * as axios from 'axios';

    const BASE_URL = 'http://localhost:8082/agent';

    const STATUS_INITIAL = 0, STATUS_SAVING = 1, STATUS_SUCCESS = 2, STATUS_FAILED = 3;
    
    export default {
    name : 'ImageForm',
    data() {
        return {
            uploadedFiles: [],
            uploadError: null,
            currentStatus: null,
            uploadFieldName: 'photos',
            formData : null
        }
    },
    computed: {
        isInitial() {
            return this.currentStatus === STATUS_INITIAL;
        },
        isSaving() {
            return this.currentStatus === STATUS_SAVING;
        },
        isSuccess() {
            return this.currentStatus === STATUS_SUCCESS;
        },
        isFailed() {
            return this.currentStatus === STATUS_FAILED;
        }
    },
    methods: {
        reset() {
          // reset form to initial state
          this.currentStatus = STATUS_INITIAL;
          this.uploadedFiles = [];
          this.uploadError = null;
        },
        upload(formData, unitId) {
            const url = `${BASE_URL}/photos/` + unitId + `/upload`;
            return axios.post(url, formData)
                          .then(x => {
                            (x.data === true) ? alert('Success!') : alert('Failure!');
                          });
        },
        saveImages(unitId) {  //ovo preko eventa dobija
            if (!this.formData) return; 
            this.currentStatus = STATUS_SAVING;
            this.upload(this.formData, unitId);
        },
        filesChange(fieldName, fileList) {

            const formData = new FormData();

            if (!fileList.length) return;

            Array
              .from(Array(fileList.length).keys())
              .map(x => {
                formData.append(fieldName, fileList[x], fileList[x].name);
              });
              this.formData = formData;

            //hmmmm
            this.currentStatus = STATUS_SUCCESS;
        }
      },
      mounted() {
          this.reset();
      },
      created() {
        this.$parent.$on('upload', this.saveImages);
      }
}
</script>

<style>
  .dropbox {
    outline: 2px dashed grey;
    outline-offset: -10px;
    background: lightcyan;
    color: dimgray;
    padding: 10px 10px;
    min-height: 200px;
    position: relative;
    cursor: pointer;
  }

  .input-file {
    opacity: 0;
    width: 100%;
    height: 200px;
    position: absolute;
    cursor: pointer;
  }

  .dropbox:hover {
    background: lightblue; 
  }

  .dropbox p {
    font-size: 1.2em;
    text-align: center;
    padding: 50px 0;
  }
</style>