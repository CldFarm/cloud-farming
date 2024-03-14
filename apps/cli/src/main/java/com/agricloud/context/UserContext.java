package com.agricloud.context;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.context.annotation.Scope;


@Component
@Scope("singleton")
public class UserContext {
    private String loggedInUser;

    public void setLoggedInUser(String loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public String getLoggedInUser() {
        return loggedInUser;
    }
}
