const repository = require('../repository/rating.repository');

function insert(rating) {
    return new Promise(function (resolve, reject) {
        repository.insert(rating).then((result) => {
            resolve();
        }, (err) => {
            if (err.errno == 1062) {
                reject({ myError: true, code: 409, message: "Already rated." });
            } else {
                reject({myError: true, code: 500, message: `Error: ${err.code}: ${err.sqlMessage}`});
            }

        })
    })
}

module.exports = {
    insert
}