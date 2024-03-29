package com.agricloud.context;

import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Scope;

@Component
@Scope("singleton")
public class UserContext {
    public boolean connected;

    private String loggedInUser;

    public void setLoggedInUser(String loggedInUser) {
        this.loggedInUser = loggedInUser;
        connected = true;
    }

    public String getLoggedInUser() {
        return this.loggedInUser;
    }
}
