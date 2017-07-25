/**
 * Created by Dragos on 10.07.2017.
 */
$(document).ready(function () {
    getAllCourses();
    confirmEnrollment();
});

function confirmEnrollment() {
    $('#grid').on('click', '#enroll', function () {
        var courseCode = this.value;
        $.confirm({
                title: 'Confirmation',
                content: 'Are you sure you want to be enrolled at this course?',
                buttons: {
                    enroll: {
                        btnClass: 'btn-blue',
                        text: 'Enroll',
                        action: function () {
                            enroll(courseCode);
                        }
                    },
                    cancel: {
                        btnClass: 'btn-red',
                        text: 'Cancel'
                    }
            }
        });
    });
}

function enroll(courseCode) {
    var jsonParam = JSON.stringify({
        'courseCode' : courseCode
    });
    $.ajax({
        url: 'enroll.action',
        type: 'PUT',
        data: jsonParam,
        dataType: "json",
        contentType: 'application/json',
        success: function (data) {
            var message = $('#message2');
            console.log(data);
            if (data.enrollmentResult === "Enrollment successful!") {
                message.text("Enrollment successful!");
                message.css('font-size', '200%');
                message.css('color', 'green');
                message.show('slow');
            }
            else {
                message.text("You're already enrolled in that course!");
                message.css('font-size', '200%');
                message.css('color', 'red');
                message.show('slow');
            }
        },
        error: function (data) {
            console.log(data);
        }
    });
}

function getAllCourses() {
    $("#grid").jqGrid({
        colModel: [
            {name: "courseName", label: "Course Name"},
            {name: "category", label: "Category"},
            {name: "professor", label: "Professor"},
            {name: "enroll", label: "Enrollment"}
        ],
        viewrecords: true, // show the current page, data rang and total records on the toolbar
        width: 800,
        height: 600,
        rowNum: 10,
        datatype: 'local',
        pager: "#jqGridPager",
        caption: "List of Courses"
    });

    fetchGridData();
}

function fetchGridData() {
    var gridArrayData = [];
    // show loading message
    var table = $("#grid");
    table[0].grid.beginReq();
    $.ajax({
        url: 'getAllCourses.action',
        type: 'GET',
        dataType: 'json',
        traditional: true,
        success: function (data) {
            console.log(data.allCourses[0]);
            for (var i = 0; i < data.allCourses.length; i++) {
                var item = data.allCourses[i];
                gridArrayData.push({
                    courseName: item.courseName,
                    category: item.category,
                    professor: item.professor,
                    enroll: "<button id='enroll' value=" + item.courseCode + " ><img src=\"/resources/images/rsz_1enroll-button.png\"></button>"
                });
            }
            // set the new data
            table.jqGrid('setGridParam', {data: gridArrayData});
            // hide the show message
            table[0].grid.endReq();
            // refresh the grid
            table.trigger('reloadGrid');
        },
        error: function (data) {
            console.log(data);
        }
    });
}
