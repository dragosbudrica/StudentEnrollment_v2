/**
 * Created by Dragos on 12.07.2017.
 */
$(document).ready(function () {
    getProfessorCourses();
});

function getProfessorCourses() {
    $("#grid").jqGrid({
        colModel: [
            {name: "courseName", label: "Course Name"},
            {name: "category", label: "Category"}
        ],
        viewrecords: true, // show the current page, data rang and total records on the toolbar
        width: 800,
        height: 600,
        rowNum: 10,
        datatype: 'local',
        pager: "#jqGridPager",
        caption: "My Courses"
    });

    fetchGridData();
}

function fetchGridData() {
    var gridArrayData = [];
    // show loading message
    var table = $("#grid");
    table[0].grid.beginReq();
    $.ajax({
        url: 'getProfessorCourses.action',
        type: 'GET',
        dataType: 'json',
        traditional: true,
        success: function (data) {
            console.log(data.professorCourses[0]);
            for (var i = 0; i < data.professorCourses.length; i++) {
                var item = data.professorCourses[i];
                gridArrayData.push({
                    courseName: "<a href=\"secured\\courseDetails.action?courseCode="+item.courseCode+"\">"+item.courseName+"</a>",
                    category: item.category
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