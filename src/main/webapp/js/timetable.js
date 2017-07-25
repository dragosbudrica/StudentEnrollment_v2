$(document).ready(function () {
    getEvents();
});

function getEvents() {
    var index;
    var courses = [];
    $.ajax({
        url: 'getEvents.action',
        type: 'GET',
        dataType: 'json',
        traditional: true,
        success: function (data) {
            if(data.rendered) {
                for(index=0; index < data.events.length; ++index) {
                    courses.push({'title' : data.events[index].courseName, 'start' : data.events[index].startTime, 'end': data.events[index].endTime});
                }
                displayEvents(courses);
            } else {
                $("#calendar").hide();
                $("#image").show();
            }
        },
        error: function (data) {
            console.log(data);
        }
    });
}

function displayEvents(courses) {
    $('#calendar').fullCalendar({
        header: {
            left: 'prev,next today',
            center: 'title',
            right: 'month,agendaWeek,agendaDay,listWeek'
        },
        navLinks: true, // can click day/week names to navigate views
        editable: false,
        eventLimit: true, // allow "more" link when too many events
        events:  courses
    });
}
