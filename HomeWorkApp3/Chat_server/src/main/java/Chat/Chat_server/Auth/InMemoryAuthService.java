package Chat.Chat_server.Auth;

import Chat.Chat_server.Error.BadRequestException;
import Chat.Chat_server.Error.UserNotFoundExeption;
import Chat.Chat_server.Error.WrongCredentialsException;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InMemoryAuthService implements AuthService{
    private static Connection connection;
    private static Statement stmt;

    public InMemoryAuthService(){
        try {
            connect();
//            deleteAuth();
            create();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void deleteAuth() throws SQLException {
        stmt.executeUpdate("DELETE FROM auth;");
    }

    private void create() throws SQLException {
        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS auth(id integer primary key autoincrement, login text, password text, nickname text);");
        stmt.executeUpdate("INSERT INTO auth(login, password, nickname) VALUES ('log1', 'pass', 'nick1')," +
                "('log2', 'pass', 'nick2'), ('log3', 'pass', 'nick3'), ('log4', 'pass', 'nick4')");
    }

    @Override
    public void connect() throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:auth.db");
        stmt = connection.createStatement();
    }

    @Override
    public void disconnect() {
        try {
            if (stmt !=null){
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
        if (connection != null) {
            connection.close();
        }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    @Override
    public void start() {
        System.out.println("Сервис авторизации запущен ");
    }

    @Override
    public void stop() {
        System.out.println("Сервис авторизации остановлен");
    }

    @Override
    public String getNicknameByLoginAndPassword(String login, String password) {
        try(ResultSet rs = stmt.executeQuery("SELECT * FROM auth;")){
            while (rs.next()) {
                if ((login.equals(rs.getString("login"))) && (password.equals(rs.getString("password")))) return rs.getString("nickname");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }throw new UserNotFoundExeption("Пользователь не найден");
    }

    @Override
    public String changeNickname(String oldNick, String newNick) {
        try(ResultSet rs = stmt.executeQuery("SELECT * FROM auth;")){
            while (rs.next()){
                if (newNick.equals(rs.getString("nickname"))) throw new UserNotFoundExeption("Этот ник занят");
            }
            stmt.executeUpdate("UPDATE auth SET nickname = '" + newNick +"' WHERE nickname = '" + oldNick + "';");
            return newNick;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new UserNotFoundExeption("Пользователь не найден");
    }

    @Override
    public void changePassword(String nickname, String oldPassword, String newPassword) {
        try{
            stmt.executeUpdate("UPDATE auth SET password = '" + newPassword +"' WHERE nickname = '" + nickname + "';");
            return;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createNewUser(String login, String password, String nickname) {
        try(ResultSet rs = stmt.executeQuery("SELECT * FROM auth;")){
            while (rs.next()){
                if (login.equals(rs.getString(login)) || nickname.equals(rs.getString(nickname))){
                    throw new BadRequestException("Этот ник или логин занят");
                }
            }
            stmt.executeUpdate("insert into auth(login, password, nickname) VALUES ('" + login + "', '" + password + "', '" + nickname+ "')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(String nickname) {
        try {
            stmt.executeUpdate("DELETE FROM auth WHERE nickname = '" + nickname + "';");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
