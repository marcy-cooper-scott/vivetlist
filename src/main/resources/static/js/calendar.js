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