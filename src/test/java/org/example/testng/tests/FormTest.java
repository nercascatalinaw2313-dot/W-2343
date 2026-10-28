package org.example.testng.tests;

import org.example.pom.DemoqaForm;
import org.example.utils.Seleniumdriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FormTest {

    static public WebDriver driver;
    public static String URI = "https://demoqa.com/automation-practice-form";
    public static String FIRST_NAME = "Eugeniu";
    public static String LAST_NAME = "Poberejnîi";
    public static String USER_EMAIL = "poberejniieugeniu@gmail.com";

    @BeforeTest
    public void beforeTest()
    {
        driver = Seleniumdriver.getAutoLocalDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void formTest()
    {
        System.out.println("Start Test");
        driver.get(URI);
        DemoqaForm form = new DemoqaForm(driver);
        form.setFirstName(FIRST_NAME);
        form.setLastName(LAST_NAME);
        form.setUserEmail(USER_EMAIL);
    }


    @AfterTest
    public void afterTest()
    {
        driver.quit();
    }
}
