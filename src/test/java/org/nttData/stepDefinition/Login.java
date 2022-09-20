package org.nttData.stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.nttData.listeners.Hook;
import org.nttData.pages.LoginPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;


public class Login {

    @Given("User is on login page")
    public void user_is_on_login_page() {
        try{
            System.out.println("LOGINFO---> User is on login page");
            LoginPage loginPage = new LoginPage(Hook.browserDriver);
            loginPage.waitLoadLoginPage();
        }catch(Exception e)
        {
            System.out.println("EEERROREEE--->"+e.getCause());
            throw new RuntimeException(e);
        }
    }
    @When("User enters username and password")
    public void user_enters_username_and_password() {
        try{
            System.out.println("LOGINFO---> User enters username and password");
            LoginPage loginPage = new LoginPage(Hook.browserDriver);
            loginPage.insertData();
        }catch(Exception e)
        {throw new RuntimeException(e);}
    }
    @When("Click on login button")
    public void click_on_login_button() {
        try{
            System.out.println("LOGINFO---> Click on login button");
            LoginPage loginPage = new LoginPage(Hook.browserDriver);
            loginPage.clickLoginButton();
        }catch(Exception e)
        {throw new RuntimeException(e);}
    }
    @Then("user is navigated to the home page")
    public void user_is_navigated_to_the_home_page() {
        try{
            System.out.println("LOGINFO---> user is navigated to the home page");
            LoginPage loginPage = new LoginPage(Hook.browserDriver);
            if(loginPage.loginSuccessfull()){
                System.out.println("LOGINFO---> user is logged successfull");
            }
            else {
                System.out.println("LOGINFO---> user is not logged!");
                Assert.fail("LOGINFO---> user is not logged!");
            }
        }catch(Exception e)
        {throw new RuntimeException(e);}
    }

}
