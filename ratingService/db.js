const mysql = require('mysql');
const fs = require('fs');
const dbConnection = require('./db.connection');

const con = mysql.createConnection({
    host: dbConnection.host,
    user: dbConnection.user,
    password: dbConnection.password,
    database: dbConnection.database,
    multipleStatements: true
});

var args = process.argv.slice(2);

if (args.length < 1) {
    console.log("Run script as 'node db [QUERY_FILE_PATH]|$[QUERY_STRING],...'");
    process.exit(1);
}

var verbose = args.indexOf("--verbose");
if (verbose == -1) {
    console.log("To see statements being executed run with --verbose");
} else {
    args.splice(verbose, 1);
    verbose = true;
}

var argString = '';

for (var i = 0; i < args.length; ++i) {
    argString += args[i];
    if (!(
        args[i] == "," || args[i].startsWith(",") || args[i].endsWith(",")) && i < args.length - 1)
        argString += " ";
}

var queryArgs = argString.split(",");


if (queryArgs.length == 0)
    process.exit(1);

con.connect(function (err) {
    if (err) {
        console.log("Error:");
        console.log(err);
        process.exit(1);
    }

    console.log(`Connected to database '${dbConnection.database}'`);
    executeQueryStep(0);
})

function executeQueryStep(idx) {
    if (idx == queryArgs.length) {
        console.log("Success");
        process.exit(0);
    }

    if (queryArgs[idx].startsWith("$")) {
        executeQuery(idx, queryArgs[idx].substring(1));
    } else {
        if (!queryArgs[idx].endsWith(".sql"))
            queryArgs[idx] += ".sql";

        if (!fs.existsSync(queryArgs[idx])) {
            console.log(`File: '${queryArgs[idx]}' doesn't exist`);
            process.exit(1);
        }

        var query = fs.readFileSync(queryArgs[idx], 'utf-8');
        console.log(`Executing '${queryArgs[idx]}'...`);
        executeQuery(idx, query);
    }
}

function executeQuery(idx, query) {
    if (verbose) {
        console.log("\n" + query + "\n");
    }
    con.query(query, function (err, results, fields) {
        if (err) {
            if (verbose)
                console.log(err.toString());
            process.exit(1);
        }

        executeQueryStep(idx + 1);
    });
}