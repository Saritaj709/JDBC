package com.bridgelabz.service;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import com.bridgelabz.model.Person;

public interface AddressBookService {
public void addPerson() throws SQLException, JsonGenerationException, JsonMappingException, IOException, Exception;
public void deletePerson() throws SQLException, JsonGenerationException, JsonMappingException, IOException;
public void updatePerson() throws SQLException, JsonGenerationException, JsonMappingException, IOException;
public void seePersonDetails() throws SQLException, JsonGenerationException, JsonMappingException, IOException;
public void createMultipleAddressBook(String book) throws JsonParseException, JsonMappingException, IOException, SQLException;
public File searchMultipleAddressBook(String book) throws JsonParseException, JsonMappingException, IOException, SQLException;
public void displayMultipleAddressBook() throws JsonParseException, JsonMappingException, IOException, SQLException;
public void getConnection();
}
