package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alec on 10/8/2015.
 */
public class UserResult {
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    private List<User> users = new ArrayList<User>();
}
