package com.mobgen.stepDefinitions;

import com.mobgen.Utilities.ConfigReader;
import com.mobgen.Utilities.Driver;
import com.mobgen.pages.LoginPage;
import io.cucumber.java.en.Given;

public class LoginStepDef {

    LoginPage loginPage = new LoginPage();

    @Given("the user goes to link")
    public void the_user_goes_to_link() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }

    @Given("the user logs in")
    public void the_user_logs_in() throws InterruptedException {
       loginPage.login();
    }


}
