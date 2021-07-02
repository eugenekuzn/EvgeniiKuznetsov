package ru.training.at.hw3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private final HeaderOfHomePageObjects headerOfHomePageObjects;
    private final LeftSideMenuOfHomePageObjects leftSideMenuOfHomePageObjects;
    private final FrameOnHomePage frameOnHomePage;

    //login
    @FindBy(className = "profile-photo")
    private WebElement profileMenu;
    @FindBy(id = "name")
    private WebElement loginInputField;
    @FindBy(id = "password")
    private WebElement passwordInputField;
    @FindBy(id = "login-button")
    private WebElement submitButton;

    //images and texts
    @FindBy(xpath = "//*[@class=\"icons-benefit icon-practise\"]")
    private WebElement firstImg;
    @FindBy(xpath = "//span[contains(text(), 'good practices')]")
    private WebElement textUnderFirstImg;
    @FindBy(xpath = "//*[@class=\"icons-benefit icon-custom\"]")
    private WebElement secondImg;
    @FindBy(xpath = "//span[contains(text(), 'flexible')]")
    private WebElement textUnderSecondImg;
    @FindBy(xpath = "//*[@class=\"icons-benefit icon-multi\"]")
    private WebElement thirdImg;
    @FindBy(xpath = "//span[contains(text(), 'multiplatform')]")
    private WebElement textUnderThirdImg;
    @FindBy(xpath = "//*[@class=\"icons-benefit icon-base\"]")
    private WebElement fourthImg;
    @FindBy(xpath = "//span[contains(text(), 'have good base')]")
    private WebElement textUnderFourthImg;

    //frame
    @FindBy(id = "frame")
    private WebElement frame;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        headerOfHomePageObjects = new HeaderOfHomePageObjects(driver);
        leftSideMenuOfHomePageObjects = new LeftSideMenuOfHomePageObjects(driver);
        frameOnHomePage = new FrameOnHomePage(driver);
    }

    public void login(String username, String password) {
        profileMenu.click();
        loginInputField.sendKeys(username);
        passwordInputField.sendKeys(password);
        submitButton.click();
    }

    public HeaderOfHomePageObjects getHeaderOfHomePageObjects() {
        return headerOfHomePageObjects;
    }

    public LeftSideMenuOfHomePageObjects getLeftSideMenuOfHomePageObjects() {
        return leftSideMenuOfHomePageObjects;
    }

    public FrameOnHomePage getFrameOnHomePage() {
        return frameOnHomePage;
    }

    public void openDifferentElementsPage() {
        headerOfHomePageObjects.accessToDifferentElementsPage();
    }

    public WebElement getFirstImg() {
        return firstImg;
    }

    public String getTextUnderFirstImg() {
        return textUnderFirstImg.getText();
    }

    public WebElement getSecondImg() {
        return secondImg;
    }

    public String getTextUnderSecondImg() {
        return textUnderSecondImg.getText();
    }

    public WebElement getThirdImg() {
        return thirdImg;
    }

    public String getTextUnderThirdImg() {
        return textUnderThirdImg.getText();
    }

    public WebElement getFourthImg() {
        return fourthImg;
    }

    public String getTextUnderFourthImg() {
        return textUnderFourthImg.getText();
    }

    public WebElement getIFrame() {
        return frame;
    }
}

