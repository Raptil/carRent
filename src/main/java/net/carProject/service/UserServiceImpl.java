package net.carProject.service;


import net.carProject.dao.RoleDao;
import net.carProject.dao.UserDao;
import net.carProject.domain.Role;
import net.carProject.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;

import java.util.List;
import java.util.Set;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier(value = "UserDao")
    private UserDao userDao;

    @Autowired
    @Qualifier(value = "RoleDao")
    private RoleDao roleDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    @Transactional
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        Set<Role> roles = new HashSet<>();
        roles.add(roleDao.getById(1));
        user.setRoles(roles);
        userDao.save(user);
    }

    public User login(String email,String password){
        List<User> users=userDao.readAll();
        for(User user:users)
            if(user.getEmail().equals(email) && bCryptPasswordEncoder.matches(password,user.getPassword()))
                return user;
        return null;
    }

    @Override
    public User getUserByName(String name) {
        return userDao.getUserByName(name);
    }

    @Override
    public User changeProfile(User user) {
        return userDao.update(user);
    }
}
