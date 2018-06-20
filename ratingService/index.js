const controller = require('./controller');
const ratingsRepository = require('./ratings.repository');

require('@google-cloud/debug-agent');
exports.ratings = controller([
    "GET", function (req, res) {
        ratingsRepository.getAll().then((result) => {
            res.status(200).send(result);
        }, (err) => {
            res.status(500).send(err);
        })
    },
    "POST", function (req, res) {
        ratingsRepository.insert(req.body).then((result) => {
            res.status(200).send(result);
        }, (err) => {
            res.status(500).send({error: err});
        })
    }
]);