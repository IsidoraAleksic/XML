module.exports = function (methodsAndFunctions) {
    let methods = [];
    let functions = [];

    for (var i = 0; i < methodsAndFunctions.length; ++i) {
        if (i % 2 == 0) {
            methods.push(methodsAndFunctions[i]);
        } else {
            functions.push(methodsAndFunctions[i]);
        }
    }

    return function (req, res) {
        var idx = methods.indexOf(req.method);
        if (idx == -1) {
            var err = {
                message: "Unsupported method",
                method: req.method,
                supportedMethods: methods 
            }
            res.status(405).send(err);
            return;
        }

        functions[idx](req, res);
    }

}