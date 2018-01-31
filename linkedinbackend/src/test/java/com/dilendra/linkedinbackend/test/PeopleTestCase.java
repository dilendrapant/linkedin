package com.dilendra.linkedinbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dilendra.linkedinbackend.dao.PeopleDAO;
import com.dilendra.linkedinbackend.dto.People;


public class PeopleTestCase {

	private static AnnotationConfigApplicationContext context;

	private static PeopleDAO peopleDAO;

	private People people;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.dilendra.linkedinbackend");
		context.refresh();
		peopleDAO =  (PeopleDAO) context.getBean("peopleDAO");
	}
	
	
	
	@Test
	public void testGetPeople(){
		people = peopleDAO.get(1);
		assertEquals("Successfully get featched using people id","Manoj Narayanan",people.getName());
	}
	
	
	
	
	

//	@Test
//	public void testPeople() {
//
//		people = new People();
//		people.setName("Manoj Narayanan");
//		
//	
//		people.setEducation("Indian Institute of Management Ahmedabad" + "Degree Name" + "MBA" + "Field Of Study"
//				+ "Post Graduation in Business Administration" + "Dates attended or expected graduation" + "1999 – 2001"
//				+ "ESADE Business & Law School" + "Degree Name" + "MBA" + "Field Of Study" + "Visiting Graduate"
//				+ "Dates attended or expected graduation" + "2000 – 2000" + "University of Calicut" + "Degree Name"
//				+ "B.Tech" + "Field Of Study" + "Electronics & Communications" + "Dates attended or expected graduation"
//				+ "1993 – 1997");
//
//		people.setExperience("Director, Technology Consulting & Product Development" + "Company Name"
//				+ "Vista Consulting Group" + "Dates Employed" + "Aug 2016 – Present" + "Employment Duration"
//				+ "1 yr 6 mos" + "Location" + "Dallas/Fort Worth Area"
//				+ "Manoj focuses on Technology Consulting and Product Development across Vista's portfolio of companies as part of the Product and Technology team of Vista Consulting Group (“VCG”). VCG is the operations consulting arm of Vista Equity Partners, a leading private equity firm focused on investing in software and technology-enabled businesses with over $30 billion in cumulative capital commitments."
//				+ ""
//				+ "VCG drives value creation through operational excellence, which is a key differentiator in Vista’s success and ability to generate unparalleled returns. The VCG team works in conjunction with the Vista investment professionals and key portfolio company employees to help our current and newly acquired businesses strengthen their operations through the implementation of standardized, repeatable and proven processes and best practices."
//				+ "" + "Chief Technology Officer" + "Company Name" + "Cognizant Technology Solutions" + "Dates Employed"
//				+ "Feb 2014 – Aug 2016" + "Employment Duration" + "2 yrs 7 mos" + "Location" + "Dallas/Fort Worth Area"
//				+ "Conceptualize, manage and enable new services, products and technology solutions for the Quality Engineering Business Unit."
//				+ "" + "Provide senior leadership for strategic market opportunities." + "Principal" + "Company Name"
//				+ "Capgemini" + "Dates Employed" + "Nov 2012 – Feb 2014" + "Employment Duration" + "1 yr 4 mos"
//				+ "Location" + "Greater New York City Area");
//
//		people.setProfile("Director, Technology Consulting & Product Development at Vista Consulting Group"
//				+ "Vista Consulting Group Indian Institute of Management Ahmedabad" + "Dallas/Fort Worth Area 500+");
//
//		
//		people.setJson("{}");
//		people.setUrl("www.linkedin/in/manoj");
//		people.setIsactive(true);
//		
//		assertEquals("Successfully added a people inside the table!", true, peopleDAO.add(people));
//
//	}
	
	
	
	@Test
	public void testListPeople(){
		assertEquals("Successfully feateched list of people ",1,peopleDAO.list().size());
	}
	

}
