const repository = require('../repository/rating.repository');

function getPriceMonths(pricing) {
    var prices = [];
    prices.push(pricing.january);
    prices.push(pricing.february);
    prices.push(pricing.march);
    prices.push(pricing.april);
    prices.push(pricing.may);
    prices.push(pricing.june);
    prices.push(pricing.july);
    prices.push(pricing.august);
    prices.push(pricing.september);
    prices.push(pricing.october);
    prices.push(pricing.november);
    prices.push(pricing.december);
    return prices;
}

function pricingsToAccommodations(pricings, month, days) {
    var accommodations = [];
    for (let pricing of pricings) {
        var prices = getPriceMonths(pricing);
        var accommodation = pricing.accommodationUnit;
        accommodation.price = prices[month] * days;
        accommodations.push(accommodation);
    }

    return accommodations;
}

function calcAverage(accommodations, idx, resolve, reject) {
    if (idx == accommodations.length) {
        resolve(accommodations);
        return;
    }

    repository.getByAccommodation(accommodations[idx].id).then((x) => {
        var avg = 0;
        for (let rating of x) {
            avg += rating.rating;
        }
        if (x.length != 0) {
            accommodations[idx].rating = avg / x.length;
        }
        calcAverage(accommodations, idx + 1, resolve, reject);
    }, (err) => {
        reject({ myError: true, code: 500, message: `Error: ${err.code}: ${err.sqlMessage}` });
    })
}

function average(pricings, month, days) {
    pricings = pricings.map(x=>{
        x.pricing.accommodationUnit.images = x.images;
	return x.pricing;
    });

    var accommodations = pricingsToAccommodations(pricings, month, days);

    return new Promise(function (resolve, reject) {
        calcAverage(accommodations, 0, resolve, reject);
    })
}

module.exports = {
    average
}