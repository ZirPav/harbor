package ru.zirpav.harbor.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.zirpav.harbor.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<User> allUsers();

    User findById(int id);

    void deleteUser(int id);

    void saveUser(User user);

    void edit(User user);


}
