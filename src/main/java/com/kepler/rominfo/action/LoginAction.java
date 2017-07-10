package com.kepler.rominfo.action;

import com.kepler.rominfo.model.Course;
import com.kepler.rominfo.model.User;
import com.kepler.rominfo.service.CourseService;
import com.kepler.rominfo.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Map;

/**
 * Created by Dragos on 29.06.2017.
 */

@Component
public class LoginAction extends ActionSupport {

    private static final Log LOGGER = LogFactory.getLog(LoginAction.class);

    private static final String ALL_COURSES_REDIRECT = "AllCourses";
    private static final String PROFESSOR_COURSES_REDIRECT = "ProfessorCourses";
    private static final String REGISTER_REDIRECT = "Register";

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    private String email;
    private String password;
    private String loginResult;

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String execute(){
        User user = userService.findUser(email);
        if (user != null) {
            if (userService.checkCredentials(user, email, password)) {
                Map<String, Object> session = ActionContext.getContext().getSession();
                session.put("user", user);
                if (user.getEmail().equals("admin")) {
                    loginResult = REGISTER_REDIRECT;

                } else if (user.getRole().equals("Professor")) {
                    loginResult = PROFESSOR_COURSES_REDIRECT;
                } else {
                    loginResult = ALL_COURSES_REDIRECT;
                }
                LOGGER.info(loginResult);
            }
            else {
                LOGGER.info("login failed for " + email + ". Reason: Wrong password!");
                loginResult = "Wrong password!";
                addActionError("Wrong password!");
            }
        } else {
            LOGGER.info("Login failed for " + email + ". Reason: That user does not exists!");
            loginResult = "Invalid email!";
            addActionError("Invalid email!");
        }

        return loginResult;
    }

    public String getLoginResult() {
        return loginResult;
    }

    public void setLoginResult(String loginResult) {
        this.loginResult = loginResult;
    }

    public UserService getUserService() {
        return userService;
    }

    public boolean isLoggedIn() {
        return email != null;
    }
}
