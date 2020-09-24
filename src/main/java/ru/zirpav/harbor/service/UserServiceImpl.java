package ru.zirpav.harbor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.zirpav.harbor.dao.UserDao;
import ru.zirpav.harbor.model.User;

import java.util.List;
import java.util.Set;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserDao userDao, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDao = userDao;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public List<User> allUsers() {
        return userDao.allUsers();
    }

    @Override
    public User findById(int id) {
        return userDao.findById(id);
    }

    @Override
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    @Override
    public void saveUser(User user) {

        User userFromDBEmail = userDao.findByUserForEmail(user.getEmail());
        User userFromDBNickname = userDao.findByUserForNickname(user.getNickName());

        if ((userFromDBEmail != null) || (userFromDBNickname != null)) {
            return;
        }

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userDao.saveUser(user);
    }

    @Override
    public void edit(User user) {

        User userOld = userDao.findById(user.getId());

        if (user.getPassword().isEmpty()) {
            user.setPassword(userOld.getPassword());
        } else {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        }
        userDao.edit(user);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user = userDao.findByUserForEmail(s);
        if (user == null) {
            user = userDao.findByUserForNickname(s);
            if (user == null) {
                System.err.println("User not found");
            }
        }
        return user;
    }
}
