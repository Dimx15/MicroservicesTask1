package org.itm.springtask1.service;


import org.itm.springtask1.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getById(int id);

    void deleteUser(int parseUnsignedInt);

    void createOrUpdateUser(User user);
}
