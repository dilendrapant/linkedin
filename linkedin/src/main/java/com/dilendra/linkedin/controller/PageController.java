package com.dilendra.linkedin.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dilendra.linkedinbackend.dao.PeopleDAO;
import com.dilendra.linkedinbackend.dto.People;
import com.google.gson.Gson;

@Controller

public class PageController {

	@Autowired
	private PeopleDAO peopleDAO;

	private People people;

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");

		// passing the list of peoples
		mv.addObject("peoples", peopleDAO.list());

		mv.addObject("userClickHome", true);
		return mv;
	}

	@RequestMapping(value = "/addUrl")
	public void fetchLinkedinData(@RequestParam("email") String email, @RequestParam("password") String password,
			@RequestParam("urls") String urls) {
		ModelAndView mv = new ModelAndView("page");

		if (!email.isEmpty() && !password.isEmpty() && !urls.isEmpty()) {
			mv.addObject("useraddUrl", true);

			List urlList = new ArrayList();
			if (urls.contains(",")) {
				String[] urlArray = urls.split(",");
				for (String splitUrls : urlArray) {
					urlList.add(splitUrls);
				}
			} else {
				urlList.add(urls);
			}

			WebDriver driver;

			System.setProperty("webdriver.gecko.driver",
					"D:\\SpringWorkspace\\linkedinAutomation\\linkedin\\chromedriver.exe");

			driver = new FirefoxDriver();
//
//			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			driver.get("https://www.linkedin.com");

			driver.findElement(By.xpath("//input[@id='login-email']")).sendKeys(email);
			driver.findElement(By.xpath("//input[@id='login-password']")).sendKeys(password);
			driver.findElement(By.xpath("//input[@id='login-submit']")).click();
			String Profile = null;
			String Experience = null;
			String Education = null;

			for (int i = 0; i < urlList.size(); i++) {

				String URL = "https://www.linkedin.com/in/" + urlList.get(i);

				driver.get(URL);
				
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

				WebElement name = driver.findElement(By.cssSelector("h1"));
				System.out.println(name.getText());

				if (name.getText().equals("This profile is not available")) {
					System.out.println("This profile is not available");
				}

				else {
					String[] arr = driver.findElement(By.cssSelector("body")).getText().split("\n");
					String regex = "^[0-9]+.*";

					int ii = 0;
					int j = 0;
					int k = 0;
					int x = 0;
					int y = 0;
					int z = 0;

					for (String all : arr) {

						if (all.equals(name.getText())) {
							++ii;

						}

						else {

							if (ii >= 1) {

								if (Pattern.matches(regex, all)) {

									++j;
								} else {
									if (j >= 1) {

										if (all.equals("Send InMail")) {

											++k;

										} else {
											if (k < 1) {

												Profile += "\n" + all;
											}
											if (k >= 1) {

												if (all.equals("Experience")) {
													++x;

												} else {
													if (x >= 1 && !all.equals("Show more positions")) {

														if (all.equals("Education")) {
															++y;
														} else {
															if (y < 1) {
																Experience += "\n" + all;
															}

															if (y >= 1) {

																if (all.equals("Show more education")) {
																	++z;
																} else {

																	if (z < 1) {
																		Education += "\n" + all;
																	}

																}

															}

														}
													}

												}

											}
										}

									}
								}

							}

						}

					}

					people = new People();
					System.out.println("Set people fields");
					if (Education != null) {
						people.setEducation(Education.substring(4));
						Education = null;
					} else {
						people.setEducation(Education);
					}
					if (Experience != null) {
						people.setExperience(Experience.substring(4));
						Experience = null;
					} else {
						people.setEducation(Experience);
					}

					if (Profile != null) {
						people.setProfile(Profile.substring(4));
						Profile = null;
					} else {
						people.setProfile(Profile);
					}
					people.setUrl(URL);
					people.setIsactive(true);
					people.setName(name.getText());

					// Convert String to JSON

					Gson g = new Gson();
					System.out.println("Json ...");
					String Json = g.toJson(people);
					people.setJson(Json);

					peopleDAO.add(people);
					people = null;

				}

			}
			System.out.println("Execution Completed");

		}

		System.out.println("Empty fields plz check.... ");

	}

	@RequestMapping(value = "/show/all/peoples")
	public ModelAndView showAllPeoples() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Peoples");

		// passing the list of Peoples
		mv.addObject("peoples", peopleDAO.list());

		mv.addObject("userClickAllPeoples", true);
		return mv;
	}

	@RequestMapping(value = "/show/people/{id}/peoples")
	public ModelAndView showPeoples(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("page");

		// fetch a single people
		People people = null;

		people = peopleDAO.get(id);

		mv.addObject("title", people.getName());

		// passing the list of peoples
		mv.addObject("peoples", peopleDAO.list());

		// passing the single people object
		mv.addObject("people", people);

		mv.addObject("userClickPeoplePeoples", true);
		return mv;
	}
}
