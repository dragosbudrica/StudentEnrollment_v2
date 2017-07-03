/**
 * Created by Dragos on 30.06.2017.
 */
$(document).ready(function () {
    login();
});

function login() {
    $('#submit').click(function() {
        var email = $('#email').val();
        var password = $('#password').val();
        console.log(email + " " + password);
        $.ajax({
            url: 'login.action',
            type: 'POST',
            data: {
                email: email,
                password: password
            },
            traditional: true,
            success: function (data) {
                var warning = $('#warning');
                if (data.loginResult === "AllCourses") {
                    window.location.href = 'allCourses.jsp';
                } else if (data.loginResult === "Register") {
                    window.location.href = 'register.jsp';
                } else if (data.loginResult === "ProfessorCourses") {
                    window.location.href = 'professorCourses.jsp';
                } else if (data.loginResult === "Wrong password!") {
                    console.log(data.loginResult);
                    warning.text(data.loginResult);
                    warning.show('slow');
                } else {
                    console.log(data.loginResult);
                    warning.text(data.loginResult);
                    warning.show('slow');
                }
            },
            error: function (data) {
                console.log(data);
            }
        });
    });
}