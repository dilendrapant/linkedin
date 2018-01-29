package com.dilendra.linkedinbackend.dao;

import java.util.List;

import com.dilendra.linkedinbackend.dto.People;

public interface PeopleDAO {

	void fetchData(String URL);

	boolean add(People people);

	boolean delete(People people);

	List<People> list();
	boolean update(People people);

}
