package aston.task.jdbc.service;

import aston.task.jdbc.dao.UserDaoJDBCImpl;
import aston.task.jdbc.model.User;

import java.util.List;

public class UserServiceImpl extends UserDaoJDBCImpl implements UserService {
//  service переиспользует методы dao

    public void createUsersTable() {
        super.createUsersTable();
    }

    public void dropUsersTable() {
        super.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        super.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        super.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return null;
    }

    public void cleanUsersTable() {
        super.cleanUsersTable();
    }
}