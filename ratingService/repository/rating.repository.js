const mysql = require('mysql');
const db = require('../db.connection.json')

const con = mysql.createConnection({
    host: db.host,
    user: db.user,
    password: db.password,
    database: db.database
});

con.connect(function (err) {
    if (err) throw err;
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

function getByAccommodation(accommodation_id) {
    return new Promise(function (resolve, reject) {
        con.query(`SELECT * from ratings where accommodation_id = ${accommodation_id};`, function (err, results, fields) {
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
        con.query(`INSERT INTO ratings (user_id, reservation_id, accommodation_id, rating) VALUES ('${rating.user_id}', '${rating.reservation_id}', '${rating.accommodation_id}', '${rating.rating}');`, function (err, result, fields) {
            if (err) {
                reject(err);
            }
            else {
                resolve(result);
            }
        });
    })
}

module.exports = {
    getAll,
    getByAccommodation,
    insert
}