package com.dgwl.model;

import com.dgwl.eo.User;
import org.springframework.stereotype.Component;

/**
 * @author lee
 **/
@Component
public class HostHolder {

    private ThreadLocal<User> users = new ThreadLocal<User>();

    public void setUser(User user) {
        users.set(user);
    }

    public User getUser() {
        return users.get();
    }

    public void clear() {
        users.remove();
    }
}
