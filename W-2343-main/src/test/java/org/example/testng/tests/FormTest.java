package org.example.testng.tests;

import org.example.pom.DemoqaForm;
import org.example.utils.Seleniumdriver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FormTest {

    static public WebDriver driver;
    public static String URI = "https://demoqa.com/automation-practice-form";
    public static String FIRST_NAME = "Nercas";
    public static String LAST_NAME = "Catalina";
    public static String USER_EMAIL = "nercascatalinaw2313@gmail.com";
    public static String GENDER = "Female";
    public static String USERNUMBER = "1234567890";
    public static String DATE = "18 Apr 1988";
    public static String SUBJECT = "Maths";
    public static String HOBBY = "Music";
    public static String STATE = "Rajasthar";
    public static String CITY = "Jaipur";


    @BeforeTest
    public void beforeTest()
    {
        driver = Seleniumdriver.getRemoteDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void formTest() throws InterruptedException
    {
        System.out.println("Start Test");
        driver.get(URI);
        DemoqaForm form = new DemoqaForm(driver);
        form.setFirstName(FIRST_NAME);
        form.setLastName(LAST_NAME);
        form.setUserEmail(USER_EMAIL);
        form.setGender(GENDER);
        form.setUserNumber(USERNUMBER);
        form.setDate(DATE);
        form.setSubject(SUBJECT);
        form.setHobby(HOBBY);
        form.setState(STATE);
        form.setCity(CITY);
        form.clickSubmit();
        String actualName = form.getValue("Student Name");
        Assert.assertEquals(actualName, FIRST_NAME + " " + LAST_NAME);
        Thread.sleep(10000);
        
        System.out.println("Finished test");
    }


    @AfterTest
    public void afterTest()
    {
        driver.quit();
    }
}
