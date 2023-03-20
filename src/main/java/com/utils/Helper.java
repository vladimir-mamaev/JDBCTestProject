package com.utils;


import com.dto.Director;
import com.dto.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Helper {
    private static final String SQL_DIRECTOR_MOVIES="SELECT director.director_name, movies.name FROM director LEFT " +
            "JOIN movies on director.director_id=movies.director_id;";
    private static final String SQL_ALL_USERS="SELECT * FROM users";
    public static List<User> extractUsers(Connection connection) throws SQLException {
        List<User> people = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SQL_ALL_USERS);

        while (resultSet.next()) {
            people.add( userMapper(resultSet));
        }
        return people;
    }

    public static List<Director> extractDirector(Connection connection) throws SQLException {
        List<Director> directors = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SQL_DIRECTOR_MOVIES);
        while (resultSet.next()) {
            directors.add(directorMapper(resultSet));
        }
        return directors;
    }
    public static void insertUser(Connection connection,User user) {
        try {

            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO users VALUES( ?, ?, ?)");
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getAge());
            preparedStatement.setString(4, user.getEmail());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void deleteEntity(Connection connection,int id) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM users WHERE id=?");

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    public static User userMapper(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setName(resultSet.getString("name"));
        user.setEmail(resultSet.getString("email"));
        user.setAge(resultSet.getString("age"));
        return user;
    }
    public static Director directorMapper(ResultSet resultSet) throws SQLException {
        Director director = new Director();
        director.setDirectorName(resultSet.getString("director_name"));
        director.setMovieName(resultSet.getString("name"));
        return director;
    }
}
