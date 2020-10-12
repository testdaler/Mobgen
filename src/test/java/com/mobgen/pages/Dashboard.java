package com.mobgen.pages;

import com.mobgen.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard {

    public Dashboard(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//span[text()='Create new board'])[2]")
    public WebElement newBoard;

    @FindBy(xpath = "//input[@class='subtle-input']")
    public WebElement addBoardTitle;

    @FindBy(xpath = "//button[@title='blue']")
    public WebElement color;

    @FindBy(xpath = "//*[text()='Team Visible']")
    public WebElement visible;

    @FindBy(xpath = "(//*[@class='sub-name'])[3]")
    public WebElement selectPublic;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement makePublic;

    @FindBy(xpath = "//span[text()='Create Board']")
    public WebElement craeteBoardButton;








}
