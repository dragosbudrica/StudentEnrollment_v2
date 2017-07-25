$(document).ready(function () {
    checkFields();
    createCourse();
});

function checkFields() {
    // Course Name can't be blank
    $('#newCourse_courseName').on('input', function () {
        var input = $(this);
        var is_courseName = input.val();
        if (is_courseName) {
            input.removeClass("invalid").addClass("valid");
            if (input.next().hasClass("error_show")) {
                input.next().removeClass("error_show").addClass("error");
            }
        }
        else {
            input.removeClass("valid").addClass("invalid");
            input.next().removeClass("error").addClass("error_show");
        }
    });

    // Description must be valid
    $('#newCourse_description').on('input', function () {
        var input = $(this);
        var is_description = input.val();
        if (is_description) {
            input.removeClass("invalid").addClass("valid");
            if (input.next().hasClass("error_show")) {
                input.next().removeClass("error_show").addClass("error");
            }
        }
        else {
            input.removeClass("valid").addClass("invalid");
            input.next().removeClass("error").addClass("error_show");
        }
    });
}

function createCourse() {
    $('#submit').click(function (event) {
        var form_data = $("#newCourse input[type=text], textarea").serializeArray();
        var error_free = true;
        for (var input in form_data) {
            var element = $("#newCourse_" + form_data[input]['name']);
            var valid = element.hasClass("valid");
            var error_element = $("span", element.parent());
            if (!valid) {
                error_element.removeClass("error").addClass("error_show");
                error_free = false;
            }
            else {
                error_element.removeClass("error_show").addClass("error");
            }
        }
        if (!error_free) {
            event.preventDefault();
        }
        else {
            var courseName = $('#newCourse_courseName').val();
            var category = $('#category').val();
            var numberOfLectures = $('#numberOfLectures').val();
            var description = $('#newCourse_description').val();

            var jsonParams = JSON.stringify({
                'courseName': courseName,
                'category': category,
                'numberOfLectures': numberOfLectures,
                'description': description
            });

            console.log(jsonParams);

            $.ajax({
                url: 'addNewCourse.action',
                type: 'POST',
                data: jsonParams,
                dataType: "json",
                contentType: 'application/json',
                success: function (data) {
                    console.log(data);
                    var message = $('#message');
                    if (data.newCourseResult === "Course creation successful!") {
                        message.text("Course Creation Successful!");
                        message.css('color', 'green');
                        message.show('slow');
                    }
                    else {
                        message.text(data.newCourseResult);
                        message.css('color', 'red');
                        message.show('slow');
                    }
                },
                error: function (data) {
                    console.log(data);
                }
            });
        }
    });
}
