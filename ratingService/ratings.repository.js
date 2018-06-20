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

module.exports = {
    getAll() {
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
    },
    insert(rating) {
        return new Promise(function(resolve, reject) {
            con.query(`INSERT INTO ratings (user_id, accommodation_unit_id, rating) VALUES ('${rating.user_id}', '${rating.accommodation_unit_id}', '${rating.rating}');`, function (err, result, fields) {
                if (err) {
                    reject(err);
                }
                else {
                    resolve(result);
                }
            })
        })
    }
}