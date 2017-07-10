package com.kepler.rominfo.action;

import com.kepler.rominfo.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Map;

/**
 * Created by Dragos on 10.07.2017.
 */

public class LogoutAction extends ActionSupport {
    private static final Log LOGGER = LogFactory.getLog(LogoutAction.class);

    public String execute() {
        // invalidate the session
        Map<String, Object> session = ActionContext.getContext().getSession();
        LOGGER.debug("invalidating session for " + ((User) session.get("user")).getEmail());
        session.remove("user");

        return SUCCESS;
    }
}
