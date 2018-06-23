package com.bridgelabz.datacontroller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.impl.DefaultPrettyPrinter;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.codehaus.jackson.map.type.CollectionType;

import com.bridgelabz.addressbookfactory.DataService;
import com.bridgelabz.model.Person;

public class JsonSerializer implements DataService {
	ObjectMapper mapper=new ObjectMapper();

	@Override
	public List<Person> read(List<Person> personList) throws JsonParseException, JsonMappingException, IOException {
		// TODO Auto-generated method stub
		File file = new File("/home/bridgelabz/JSarita/AddressBook/Address.json");
		     personList=new LinkedList<Person>();
			Class<Person> parser=Person.class;
			CollectionType javaType=mapper.getTypeFactory().constructCollectionType(List.class,parser);
			personList=mapper.readValue(file, javaType);
		return personList;
	}

	@Override
	public void save(List<Person> person) throws JsonGenerationException, JsonMappingException, IOException {
		// TODO Auto-generated method stub
		File file = new File("/home/bridgelabz/JSarita/AddressBook/Address.json");
		 person = new LinkedList<>();
		ObjectMapper mapper = new ObjectMapper();
		ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
		writer.writeValue(file, person);
		System.out.println("saved file");
	}
}
