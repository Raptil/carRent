package net.carProject.service;

import net.carProject.domain.User;


public interface UserService {

    public void save(User user);

    public User getUserByName(String name);

    public User login(String email, String password);

    public User changeProfile(User user);
}
