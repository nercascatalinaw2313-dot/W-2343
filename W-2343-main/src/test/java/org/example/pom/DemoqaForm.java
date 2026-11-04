package org.example.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.example.utils.WaitSel;


public class DemoqaForm {

    public static WebDriver driver;

    @FindBy(xpath = "//*[@id='firstName']")
    WebElement firstName;

    @FindBy(css = "#lastName")
    WebElement lastName;

    @FindBy(id="userEmail")
    WebElement userEmail;

    @FindBy(id="userNumber")
    WebElement userNumber;

    @FindBy(css="#dateOfBirthInput")
    WebElement date;

    @FindBy(id="subjectsInput")
    WebElement subjectsInput;

    @FindBy(id="state")
    WebElement state;

    @FindBy(id="city")
    WebElement city;

    @FindBy(id="submit")
    WebElement submit;



    public DemoqaForm(WebDriver driverParam)
    {
        driver = driverParam;
        PageFactory.initElements(driverParam,this);
    }

    public String getValue(String labelParam) {
        WebElement val = driver.findElement(
        By.xpath("//table//tr//td[text()='" + labelParam + "']/../td[2]"));
        WaitSel.explicitWait(driver, ExpectedConditions.visibilityOf(val), 10);
        return val.getText();
    }

    public void clickSubmit(){
        submit.click();
    }

    public void setState(String stateParam){
        state.click();
        driver.findElement(By.xpath("/*[text()='" + stateParam + "']"));
    }

    public void setCity(String cityParam){
        city.click();
        driver.findElement(By.xpath("/*[text()='" + cityParam + "']"));
    }

    public void scrollToAmmount(int ammountParam){
        new Actions(driver)
            .scrollByAmount(0,ammountParam)
            .perform();
    }

    public void setHobby(String hobbyParam){
        scrollToAmmount(200);
        WebElement hobby = driver.findElement(By.xpath("//*[@id='hobbiesWrapper']//label[test()='" + hobbyParam + "']/../input"));
        hobby.click();
    }

    public void setDate(String dateParam){
        date.sendKeys(Keys.CONTROL, "a");
        date.sendKeys(dateParam);
        date.sendKeys(Keys.ENTER);
    }

    public void setSubject(String subjectsParam){
        subjectsInput.clear();
        subjectsInput.sendKeys(subjectsParam);
        subjectsInput.sendKeys(Keys.ENTER);
    }

    public void setUserNumber(String numberParam){
        userNumber.clear();
        userNumber.sendKeys(numberParam);
    }

    public void setGender(String genderParam)
    {
        WebElement gender = driver.findElement(By.xpath("//*[id='genterWrapper']//label[text()='" + genderParam + "']"));
        gender.click();
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
