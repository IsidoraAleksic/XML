require('@google-cloud/debug-agent');
exports.helloHttp = function helloHttp(req, res) {
    res.status(200).send(req.method);
}