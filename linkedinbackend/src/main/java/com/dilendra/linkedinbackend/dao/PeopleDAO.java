package com.dilendra.linkedinbackend.dao;

import java.util.List;

import com.dilendra.linkedinbackend.dto.People;

public interface PeopleDAO {

	boolean add(People people);

	boolean delete(People people);

	People get(int id);

	List<People> list();

	boolean update(People people);

}
