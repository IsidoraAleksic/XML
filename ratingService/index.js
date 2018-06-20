const controller = require('./controller');

require('@google-cloud/debug-agent');
exports.helloHttp = controller([
    "GET", function (req, res) {
        res.send("Hello there");
    },
    "POST", function (req, res) {
        res.send("Post there")
    }
    ]);