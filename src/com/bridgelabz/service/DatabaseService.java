package com.bridgelabz.service;

import java.sql.SQLException;

import com.brigelabz.model.User;

public interface DatabaseService {
public void getConnection();
public void registerUser(User user) throws SQLException;
public void verifyUser() throws SQLException;
public void closeConnection() throws SQLException;
public boolean searchUser(String email) throws SQLException;
}
