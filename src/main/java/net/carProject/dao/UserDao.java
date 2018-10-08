package net.carProject.dao;

import net.carProject.domain.User;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;


@Repository("UserDao") // определяет, что это репозиторий с яным именем UserDao
public class UserDao extends CRUDImpl<User> { // наследование от CRUDImpl, передавай тип User

    public UserDao() {
        super(User.class);
    } // конструктор

    public User getUserByName(String name) {
        TypedQuery<User> query = entityManager.createQuery("SELECT u " +
                "FROM User u " +
                "WHERE u.name=:name", User.class); // создание запроса
        query.setParameter("name", name); // устанавливаем используемый параметр

        User user;
        try {
            user = query.getSingleResult(); //  сохраняем результат запроса
        } catch (Exception e) {
            return null;
        }
        return user;
    }
}
