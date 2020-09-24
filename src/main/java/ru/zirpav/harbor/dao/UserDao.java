package ru.zirpav.harbor.dao;

import ru.zirpav.harbor.model.User;

import java.util.List;

public interface UserDao {

    List<User> allUsers();

    User findById(int id);

    void deleteUser(int id);

    void saveUser(User user);

    void edit(User user);

    User findByUserForEmail(String email);

    User findByUserForNickname(String nickName);
}
