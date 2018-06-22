package com.bridgelabz.service;

import java.sql.SQLException;

public interface UserService {
	public void login() throws SQLException;

	public void register() throws SQLException;
}
