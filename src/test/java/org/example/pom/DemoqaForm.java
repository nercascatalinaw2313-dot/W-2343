package org.example.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoqaForm {

    public static WebDriver driver;

    @FindBy(xpath = "//*[@id='firstName']")
    WebElement firstName;

    @FindBy(css = "#lastName")
    WebElement lastName;

    @FindBy(id="userEmail")
    WebElement userEmail;
    
    @FindBy(id="userNumber")
    WebElement userNumber

    public DemoqaForm(WebDriver driverParam)
    {
        driver = driverParam;
        PageFactory.initElements(driverParam,this);
    }

    public void setGender(String genderParam){
        WebElement gen=driver.findElement(By.xpath("//*[@id='genterWrapper']//label[text()='"+genderParam +"']"));
    gender.click();
    }

    public void set userNumber(set numberParam){
        userNumber.clear();
    }

    public void setLastName(String lastNameParam)
    {
        lastName.clear();
        lastName.sendKeys(lastNameParam);
    }


    public void setFirstName(String firstNameParam)
    {
        firstName.clear();
        firstName.sendKeys(firstNameParam);
    }

    public void setUserEmail(String userEmailParam)
    {
        userEmail.clear();
        userEmail.sendKeys(userEmailParam);
    }
}
