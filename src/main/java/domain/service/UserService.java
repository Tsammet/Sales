package domain.service;

import domain.entity.User;

public interface UserService {
    void createUser(User user);
    void updateUser(User user);
    User findUserById(Long id);
}