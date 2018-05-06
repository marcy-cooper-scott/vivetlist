var search = "tylenol";
var openfda = function(search) { // brings back two things: meta and results
    var request = $.ajax({
        'url': 'https://api.fda.gov/drug/label.json?api_key=jhZsAyS9joDLO09BgKoNHnJS2GgKZxc3BEbQRiwZ&search=' +
        search});
    request.done(function (results) { // results is an object
        console.table(results);
        console.log("typeof: " + typeof(results));
        console.table(results["results"]); // interesting part here are the actual results
        console.log("typeof: " + typeof(results["results"])); // get the type of the actual results
        console.log("keys: " + Object.keys(results)); // grabs the keys... clever Cooper
        console.log("keys: " + Object.keys(results["results"])); // grab the keys to the interesting things as well
        console.log("keys: " + Object.keys(results["results"][0])); // grab the keys to the interesting things as well
        // testing out more access features
        console.log(results["results"][0]["purpose"]); // get purpose then
        var purpose = results["results"][0]["purpose"].toString();
        console.log("typeof var purpose: " + typeof(purpose) + " and contents: " + purpose);
    });
};

// version that allows for seraching the keys
var openfda = function(search) { // brings back two things: meta and results
    var request = $.ajax({
        'url': 'https://api.fda.gov/drug/label.json?api_key=jhZsAyS9joDLO09BgKoNHnJS2GgKZxc3BEbQRiwZ&search=' +
        search});
    request.done(function (results) { // results is an object
        console.table(results);
        console.log("typeof: " + typeof(results));
        console.table(results["results"]); // interesting part here are the actual results
        console.log("keys: " + Object.keys(results["results"])); // grab the keys to the interesting things as well
        console.log("keys: " + Object.keys(results["results"][0])); // grab the keys to the interesting things as well
        // testing out more access features
        var keys = Object.keys(results.results[0]); // get the keys
        var values = Object.values(results.results[0]); // get what the keys have inside
        for (var i = 0; i < keys.length; i++) {
            if (keys[i] === "drug_abuse_and_dependence") {
                alert("controlled substance");
            }
            console.log(keys[i] + ": " + values[i]);
        };
    });
};