package com.dilendra.linkedin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dilendra.linkedinbackend.dao.PeopleDAO;

@Controller
public class PageController
{
	

	@Autowired
	private PeopleDAO peopleDAO;

	@RequestMapping(value = {"/","/home","/index"})
	public ModelAndView index()
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");

		// passing the list of categories
		mv.addObject("peoples", peopleDAO.list());

		return mv;
	}
}
