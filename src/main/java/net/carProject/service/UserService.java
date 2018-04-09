package net.carProject.service;

import net.carProject.domain.User;

/**
 * Created by Алексей on 24.04.2017.
 */
public interface UserService {

    public void save(User user);

    public User getUserByName(String name);

    public User login(String email,String password);

    public User changeProfile(User user);
}
