package aston.task.jdbc.dao;

import aston.task.jdbc.model.User;
import aston.task.jdbc.util.UtilConnector;
import org.postgresql.util.PSQLException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDaoJDBCImpl extends UtilConnector implements UserDao {

    Logger logger = Logger.getLogger(UserDaoJDBCImpl.class.getName());

    public UserDaoJDBCImpl() {
    }

    @Override
    public void createUsersTable() {

        String CREATE_TABLE_QUERY =
                "CREATE TABLE IF NOT EXISTS users " +
                        "(ID SERIAL PRIMARY KEY, " +
                        "NAME VARCHAR(255), " +
                        "LASTNAME VARCHAR(255), " +
                        "AGE INT)";

        try (Connection connection = getConnectionToDB();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(CREATE_TABLE_QUERY);
            logger.log(Level.INFO, "Table was created successfully!");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void dropUsersTable() {
        String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS users";

        try (Connection connection = getConnectionToDB();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(DROP_TABLE_QUERY);
            logger.log(Level.INFO, "Table was dropped successfully!");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        String INSERT_USER_QUERY = "INSERT INTO users (NAME, LASTNAME, AGE) VALUES(?, ?, ?)";

        try (Connection connection = getConnectionToDB();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_QUERY)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();
            logger.log(Level.INFO, "User was added successfully!");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        String DELETE_USER_QUERY = "DELETE FROM users WHERE ID=?";

        try (Connection connection = getConnectionToDB();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER_QUERY)) {

            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();
            logger.log(Level.INFO, "User was deleted successfully!");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();

        String GET_ALL_USERS_QUERY = "SELECT NAME, LASTNAME, AGE FROM users";

        try (Connection connection = getConnectionToDB();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(GET_ALL_USERS_QUERY);
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("ID"));
                user.setName(resultSet.getString("NAME"));
                user.setLastName(resultSet.getString("LASTNAME"));
                user.setAge(resultSet.getByte("AGE"));
                userList.add(user);
            }
            logger.log(Level.INFO, "List of users created successfully!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userList;
    }

    public void cleanUsersTable() {
        String sql = "DELETE FROM users";
        try (Connection connection = getConnectionToDB();
             Statement statement = connection.createStatement()) {

            statement.executeUpdate(sql);
            logger.log(Level.INFO, "All users was deleted from table successfully!");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}