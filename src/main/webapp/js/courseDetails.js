/**
 * Created by Dragos on 12.07.2017.
 */
$(document).ready(function () {
    getAllLectures(role, courseName);
});

function getAllLectures(role, courseName) {
    $("#grid").jqGrid({
        colModel: [
            {name: "lectureName", label: "Lecture Name"},
            {name: "pdf", label: "PDF"}
        ],
        viewrecords: true, // show the current page, data rang and total records on the toolbar
        width: 800,
        height: 600,
        rowNum: 10,
        datatype: 'local',
        pager: "#jqGridPager",
        scrollable: true,
        caption: courseName
    });

    fetchGridData(role);
}

function getUrlParameter(sParam) {
    var sPageURL = decodeURIComponent(window.location.search.substring(1)),
        sURLVariables = sPageURL.split('&'),
        sParameterName,
        i;

    for (i = 0; i < sURLVariables.length; i++) {
        sParameterName = sURLVariables[i].split('=');

        if (sParameterName[0] === sParam) {
            return sParameterName[1] === undefined ? true : sParameterName[1];
        }
    }
}

function fetchGridData(role) {
    var gridArrayData = [];
    var courseCode = getUrlParameter('courseCode');
    var jsonParam = JSON.stringify({
        'courseCode': courseCode
    });

    // show loading message
      var table = $("#grid");
    table[0].grid.beginReq();
    $.ajax({
        url: 'getLectures.action',
        type: 'POST',
        data: jsonParam,
        dataType: "json",
        contentType: 'application/json',
        success: function (data) {
            console.log(data.lectures[0]);
            for (var i = 0; i < data.lectures.length; i++) {
                var item = data.lectures[i];
                console.log(item);
                if(item.file === null && role === 'Student') {
                    gridArrayData.push({
                        lectureName: item.lectureName,
                        pdf: 'No PDF'
                    });
                } else if(item.file !== null && role === 'Student'){
                    gridArrayData.push({
                        lectureName: item.lectureName,
                        pdf : "<a style='float:left' href=download.action?lectureId="+item.lectureId+"><img src=\"/resources/images/rsz_download-pdf.png\"/></a>"
                    });
                } else if(item.file === null && role === 'Professor') {
                    gridArrayData.push({
                        lectureName: item.lectureName,
                       /* pdf: "<form action=\"upload.action?lectureId=" + item.lectureId + "&courseCode=" + courseCode + "\" method=\"POST\" enctype=\"multipart/form-data\"> <input value=\"Upload PDF\" name=\"fileUpload\" type=\"file\" /> <input type=\"submit\" value=\"Upload\"> </form>"*/
                        pdf: "<form action=\"upload.action?lectureId=" + item.lectureId + "&courseCode=" + courseCode + "\" method=\"POST\" enctype=\"multipart/form-data\"> <input value=\"Upload PDF\" name=\"fileUpload\" type=\"file\" onchange=\"submit()\"/> </form>"
                });
                } else if(item.file !== null && role === 'Professor'){
                    gridArrayData.push({
                        lectureName: item.lectureName,
                        pdf : "<a style='float:left' href=download.action?lectureId="+item.lectureId+"><img src=\"/resources/images/rsz_download-pdf.png\"/></a> <a style='float:right' href=remove.action?lectureId="+item.lectureId+"&courseCode="+courseCode+"> <img src=\"/resources/images/rsz_2delete-2-xxl.png\"/></a>"
                    });
                }
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