function renderCalendar() {
    appointments = []; // clear all the events
    var request = $.ajax({'url': '/appointments.json'}); // make a request from the controller to fetch events in JSON format
    request.done(function (appts) {	// when done, we will move through each element in the array in order to grab the appointment object
        appts.forEach(function (appt) {
            var obj = {
                title: appt.name,
                start: appt.start,
                description: appt.location,
                allDay: false
            };
            appointments.push(obj);
            $('#calendar').fullCalendar('renderEvents', appointments, stick = true);
        });
    });
}

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