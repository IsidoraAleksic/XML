const mysql = require('mysql');

const con = mysql.createConnection({
    host: "localhost",
    user: "root",
    password: "root",
    database: "ratingservice"
});

con.connect(function (err) {
    if (err) throw err;
    console.log("Connected!");
})

function getAll() {
    return new Promise(function (resolve, reject) {
        con.query("SELECT * from ratings", function (err, result, fields) {
            if (err) {
                reject(err);
            }
            else {
                resolve(result);
            }
        })
    });
}

function get(rating) {
    return new Promise(function (resolve, reject) {
        con.query(`SELECT * from ratings where user_id = ${rating.user_id} and reservation_id = ${rating.reservation_id};`, function (err, results, fields) {
            if (err) {
                reject(err)
            } else {
                resolve(results);
            }
        });
    })
}

function insert(rating) {
    return new Promise(function (resolve, reject) {
        get(rating).then((exists) => {
            if (exists.length == 0) {
                con.query(`INSERT INTO ratings (user_id, reservation_id, rating) VALUES ('${rating.user_id}', '${rating.reservation_id}', '${rating.rating}');`, function (err, result, fields) {
                    if (err) {
                        reject(err);
                    }
                    else {
                        resolve(result);
                    }
                });
            } else {
                reject({ myError: true, code: "409", message: "Already rated" });
            }
        }, (err) => {
            reject(err);
        })
    })
}

module.exports = {
    getAll,
    get,
    insert
}