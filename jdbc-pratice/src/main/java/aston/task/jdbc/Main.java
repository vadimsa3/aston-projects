package aston.task.jdbc;

import aston.task.jdbc.model.User;
import aston.task.jdbc.service.UserService;
import aston.task.jdbc.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {

        Logger logger = Logger.getLogger(Main.class.getName());

        UserService userService = new UserServiceImpl();

        userService.cleanUsersTable();
        userService.dropUsersTable();
        userService.createUsersTable();

        List<User> users = new ArrayList<>();
        users.add(new User("Anna", "Ivanova", (byte) 32));
        users.add(new User("Vadim", "Petrov", (byte) 43));
        users.add(new User("Evgeniy", "Zotov", (byte) 24));
        users.add(new User("Sergey", "Pavlov", (byte) 58));

        for (User user : users) {
            userService.saveUser(user.getName(), user.getLastName(), user.getAge());
            logger.log(Level.INFO, "User с именем – " + user.getName() + " добавлен в базу данных");
        }

        userService.getAllUsers().forEach(user ->
                System.out.println(user.getName() + user.getLastName() + user.getAge()));
    }
}