package com.dilendra.linkedinbackend.daoimpl;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dilendra.linkedinbackend.dao.PeopleDAO;
import com.dilendra.linkedinbackend.dto.People;


@Repository("peopleDAO")
@Transactional
public class PeopleDAOImpl implements PeopleDAO {

	@Autowired
	private SessionFactory sessionFactory;

	
	
	
	@Override
	
	public boolean add(People people) {
		try {

			sessionFactory.getCurrentSession().persist(people);
			return true;

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(People people) {
		people.setIsactive(false);
		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().update(people);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public List<People> list() {

		String selectActivePeople = "FROM People WHERE isactive=:isactive";

		Query query = sessionFactory.getCurrentSession().createQuery(selectActivePeople);

		query.setParameter("isactive", true);

		return query.getResultList();
	}

	@Override
	public boolean update(People people) {
		try {

			sessionFactory.getCurrentSession().update(people);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

	@Override
	public void fetchData(String URL) {
		
	
		String Profile = null;
		String Experience = null;
		String Education = null;

		WebDriver driver;

		System.setProperty("webdriver.gecko.driver",
				"D:\\SpringWorkspace\\linkedinAutomation\\linkedin\\chromedriver.exe");

		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://www.linkedin.com");

		driver.findElement(By.xpath("//input[@id='login-email']")).sendKeys("pantdilendra@gmail.com");
		driver.findElement(By.xpath("//input[@id='login-password']")).sendKeys("*********");
		driver.findElement(By.xpath("//input[@id='login-submit']")).click();
		driver.get(URL);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		WebElement name = driver.findElement(By.cssSelector(".pv-top-card-section__name"));
		String[] arr = driver.findElement(By.cssSelector("body")).getText().split("\n");
		String regex = "^[0-9]+.*";

		int i = 0;
		int j = 0;
		int k = 0;
		int x = 0;
		int y = 0;
		int z = 0;

		for (String all : arr) {

			if (all.equals(name.getText())) {
				++i;

			}

			else {

				if (i >= 1) {

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

		} // Loop

		System.out.println("Name: " + name);
		System.out.println("............................................");
		System.out.println("Profile:  " + Profile.substring(4));
		System.out.println("............................................");
		System.out.println("Experience: " + Experience.substring(4));
		System.out.println("............................................");
		System.out.println("Education: " + Education.substring(4));

	}

//	public static void main(String[] args) {
//
//		PeopleDAOImpl pd = new PeopleDAOImpl();
//		pd.fetchData("https://www.linkedin.com/in/manoj");
//	}

}
