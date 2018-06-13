
import * as axios from 'axios';

const BASE_URL = 'http://localhost:8080/agent/';

export default class RestResource {

  upload(formData) {
    // Use vue-resource or any other http library to send your request
    const url = `${BASE_URL}/photos/upload`;
    return axios.post(url, formData)
        // get data
        .then(x => x.data)
        // add url field
        .then(x => x.map(img => Object.assign({},
            img, { url: `${BASE_URL}/images/${img.id}` })));

  }
}
