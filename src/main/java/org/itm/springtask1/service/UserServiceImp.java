package org.itm.springtask1.service;


import org.itm.springtask1.model.User;
import org.itm.springtask1.repositories.Repositories;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {

    private final Repositories repositories;

    public UserServiceImp(Repositories repositories) {
        this.repositories = repositories;
    }


    @Override
    public List<User> getAllUsers() {
        return repositories.findAll();
    }

    @Override
    public User getById(int id) {
        return repositories.findById(id).orElse(null);
    }

    @Override
    public void deleteUser(int parseUnsignedInt) {
        repositories.deleteById(parseUnsignedInt);
    }

    @Override
    public void createOrUpdateUser(User user) {
        repositories.save(user);
    }


}
