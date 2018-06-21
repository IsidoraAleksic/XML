const controller = require('./controller');
const ratingService = require('./service/rating.service');
const accommodationService = require('./service/accommodation.service');

require('@google-cloud/debug-agent');
exports.ratings = controller([
    "POST", function (req, res) {
        ratingService.insert(req.body).then((result) => {
            res.status(200).send(result);
        }, (err) => {
            if (err.myError) {
                res.status(err.code).send(err.message);
            } else {
                res.status(500).send(err);
            }
        })
    }
]);

exports.average = controller([
    "POST", function (req, res) {
        if (!req.query.month) {
            res.status(400).send("Query param 'month' required");
            return;
        }

        var month = Number.parseInt(req.query.month + "");

        if (month < 0 || month > 11) {
            res.status(400).send("Query param 'month' must be between 0 and 11");
            return;
        }

        if (!req.query.days) {
            res.status(400).send("Query param 'month' required");
            return;
        }

        var days = Number.parseInt(req.query.days + "");

        accommodationService.average(req.body, month, days).then((accommodations) => {
            res.send(accommodations);
        }, (err) => {
            if (err.myError) {
                res.status(err.code).send(err.message);
            } else {
                res.status(500).send(err);
            }
        })
    }
]);