$(document).ready(function () {
    getEvents();
    confirmScheduling();
});

function getEvents() {
    var index;
    $.ajax({
        url: 'getCourses.action',
        type: 'GET',
        dataType: 'json',
        traditional: true,
        success: function (data) {
            var events = buildEvents(data.events);
            getCourseTitles(events);
        },
        error: function (data) {
            console.log(data);
        }
    });
}

function getCourseTitles(events) {
    $.ajax({
        url: 'getCourseTitles.action',
        type: 'GET',
        dataType: 'json',
        traditional: true,
        success: function (data) {
            console.log(data.courseTitles);
            for (index = 0; index < data.courseTitles.length; ++index) {
                var div_data = "<option value=" + data.courseTitles[index] + ">" + data.courseTitles[index] + "</option>";
                $(div_data).appendTo('#courseName');
            }
            displayEvents(events);
        },
        error: function (data) {
            console.log(data);
        }
    });
}


function displayEvents(events) {
    $('#calendar').fullCalendar({
        header: {
            left: 'prev,next today',
            center: 'title',
            right: 'month,agendaWeek,agendaDay,listWeek'
        },
        navLinks: true, // can click day/week names to navigate views
        editable: false,
        eventLimit: true, // allow "more" link when too many events
        events: events,
        eventClick: function (event, element) {
            $("#startTime").val(event.start._i);
            $("#eventContent").dialog({width: 430, height: 200, modal: true});
        },
        dayClick: function (date, jsEvent, view) {
            var formattedDate = formatDateTime(date);
            $("#startTime").val(formattedDate);
            $("#eventContent").dialog({width: 430, height: 200, modal: true});
        }
    });
}

function formatDateTime(date) {
    var month, day, hours, minutes, seconds;
    if (date._d.getMonth() < 9)
        month = "0" + (date._d.getMonth() + 1);
    else
        month = date._d.getMonth() + 1;

    if (date._d.getDate() < 10)
        day = "0" + date._d.getDate();
    else
        day = date._d.getDate();

    if (date._d.getHours() < 10)
        hours = "0" + date._d.getHours();

    if (date._d.getMinutes() < 10)
        minutes = "0" + date._d.getMinutes();

    if (date._d.getSeconds() < 10)
        seconds = "0" + date._d.getSeconds();

    return date._d.getFullYear() + "-" + month + "-" + day + "T" + hours + ":" + minutes + ":" + seconds;
}

function confirmScheduling() {
    $('#submit').click(function (event) {
        $.confirm({
            title: 'Confirmation',
            content: 'Are you sure you want to schedule this course like this?',
            buttons: {
                schedule: {
                    btnClass: 'btn-blue',
                    text: 'Schedule',
                    action: function () {
                        schedule();
                    }
                },
                cancel: {
                    btnClass: 'btn-red',
                    text: 'Cancel',
                    action: function () {
                        $("#eventContent").dialog('close');
                    }
                }
            }
        });
    });
}

function schedule() {
    var jsonParam = JSON.stringify({
        'courseName': $('#courseName').find('option:selected').text(),
        'startTime': $('#startTime').val()
    });

    console.log(jsonParam);
    var message = $('#message');
    var calendar = $('#calendar');
    $.ajax({
        url: 'schedule.action',
        type: 'PUT',
        data: jsonParam,
        dataType: "json",
        contentType: 'application/json',
        success: function (data) {
            console.log(data);
            if (data.schedulingResult === "Scheduling successful!") {
                message.text(data.schedulingResult);
                message.css('font-size', '200%');
                message.css('color', 'green');
                message.show('slow');
                console.log(data.events);
                var events = buildEvents(data.events);
                calendar.fullCalendar('removeEvents');
                calendar.fullCalendar('addEventSource', events);
                calendar.fullCalendar('rerenderEvents' );
            }
            else {
                message.text(data.schedulingResult);
                message.css('font-size', '200%');
                message.css('color', 'red');
                message.show('slow');
            }
            $("#eventContent").dialog('close');
        },
        error: function (data) {
            console.log(data);
            $("#eventContent").dialog('close');
        }
    });
}

function buildEvents(dataEvents) {
    var events = [];
    for (index = 0; index < dataEvents.length; ++index) {
        events.push({
            'title': dataEvents[index].courseName,
            'start': dataEvents[index].startTime,
            'end': dataEvents[index].endTime
        });
    }
    return events;
}



