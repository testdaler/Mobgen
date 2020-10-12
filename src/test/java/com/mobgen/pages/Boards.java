package com.mobgen.pages;

import com.mobgen.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Boards {

    public Boards(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath ="//input[@name='name']")
    public WebElement name;

}
