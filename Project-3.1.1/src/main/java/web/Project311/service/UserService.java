package web.Project311.service;

import web.Project311.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    void save(User user);

    User getUser(int id);

    void delete(int id);
}
