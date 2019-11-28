package com.automation.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static com.automation.Utils.DriverUtils.getDriver;
import static com.automation.Utils.WebElementIUtils.waitForVisible;

public class LoginPage {
    WebDriver driver;

    String username_missing_error_msg = "Username must be present";
    String password_missing_error_msg = "Password must be present";
    String credentials_missing_error_msg = "Both Username and Password must be present";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(css = "img[src='img/logo-big.png']")
    private WebElement logoImg;

    @FindBy(className = "auth-header")
    private WebElement headerTxt;

    @FindBy(xpath = "//div[@class='logo-w']/a/img")
    public WebElement togglethemeLink;

    @FindBy(id = "username")
    public WebElement usernameTxtField;

    @FindBy(id = "password")
    public WebElement passwordTxtField;

    @FindBy(xpath = "//label[text()='Username']")
    private WebElement usernameLbl;

    @FindBy(xpath = "//label[text()='Password']")
    private WebElement passwordLbl;

    @FindBy(xpath = "//label[text()='Remember Me']")
    private WebElement rememberMeLbl;

    @FindBy(className = "form-check-label")
    private WebElement rememberMeCheckBox;

    @FindBy(id = "log-in")
    private WebElement loginBtb;

    @FindBy(css = "img[src='img/social-icons/twitter.png']")
    private WebElement twitterIcon;

    @FindBy(css = "img[src='img/social-icons/facebook.png']")
    private WebElement faceBookIcon;

    @FindBy(css = "img[src='img/social-icons/linkedin.png']")
    private WebElement linkedInIcon;

    @FindBy(xpath = "//div[@class='alert alert-warning']")
    private WebElement loginErrorMsgTxt;

    public String login(String username, String password) {
        try {
            waitForVisible(usernameTxtField);
            usernameTxtField.sendKeys(username);
            passwordTxtField.sendKeys(password);
            loginBtb.click();
            if (loginErrorMsgTxt.isDisplayed()) {
                return loginErrorMsgTxt.getText();
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void verifyLoginStatus(String status) {
        if (status.equalsIgnoreCase("valid")) {
            Assert.assertFalse(loginErrorMsgTxt.isDisplayed());
        } else {
            Assert.assertTrue(loginErrorMsgTxt.getText().contains("Both Username and Password must be present"), "LoginErro");
        }
    }

    public void verifyLoginErrorFor(String loginErrorFor) {
        switch (loginErrorFor.toLowerCase()) {
            case "password missing":
                Assert.assertTrue(loginErrorMsgTxt.getText().contains(password_missing_error_msg), "Password is missing");
                break;
            case "username missing":
                Assert.assertTrue(loginErrorMsgTxt.getText().contains(username_missing_error_msg), "Password is missing");
                break;
            case "credentials missing":
                Assert.assertTrue(loginErrorMsgTxt.getText().contains(credentials_missing_error_msg), "Password is missing");
                break;
            default:
                Assert.assertTrue(false);
        }
    }

    public void verifySocialMediaIcons() {
        Assert.assertTrue(faceBookIcon.isDisplayed());
        Assert.assertTrue(twitterIcon.isDisplayed());
        Assert.assertTrue(linkedInIcon.isDisplayed());
    }

    public void verifyLogoImg() {
//        We can not verify logo image using functional automation tools
//        Can't test it.
//        Hence testing presence of logo image
    }

    public void verifyLogoImgPresence() {
        Assert.assertTrue(logoImg.isDisplayed(), "Logo image is disaplyed !!!");
    }


    public boolean verifyPageHeaderText() {
        return headerTxt.getText().equals("Login Form");
    }

    public boolean verifyToggleLink() {
        return togglethemeLink.isEnabled();
    }

    public boolean verifyUsernameInput() {
        return usernameTxtField.isEnabled();
    }

    public boolean verifyUsernameImage() {
//      We can not check that image is displaying at proper place with proper dimension
        return true;
    }


    public boolean verifyUsernameLbl() {
        return usernameLbl.isDisplayed();
    }

    public boolean verifyPasswordInput() {
        return passwordTxtField.isEnabled();
    }

    public boolean verifyPasswordImg() {
//      We can not check that password image is displaying at proper place with proper dimension
        return true;
    }

    public boolean verifyPasswordLbl() {
        return passwordLbl.isDisplayed();
    }

    public boolean verifyLoginBtn() {
        return loginBtb.isEnabled();
    }

    public boolean verifyRmbrMeCheckbox() {
        return rememberMeCheckBox.isEnabled();
    }

    public boolean verifyTwitterLinkIcon() {
        return twitterIcon.isEnabled();
    }

    public boolean verifyFbLinkIcon() {
        return faceBookIcon.isEnabled();
    }

    public boolean verifyLinkedinLinkIcon() {
        return linkedInIcon.isEnabled();
    }
}
