package ru.training.at.hw7.pages;

import static ru.training.at.hw7.JdiSite.homePage;
import static ru.training.at.hw7.entities.User.ROMAN;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import ru.training.at.hw7.entities.User;
import ru.training.at.hw7.forms.LoginForm;

@Url("/index.html")
@Title("Home Page")
public class HomePage extends WebPage {

    private LoginForm loginForm;

    @FindBy(id = "user-name")
    private Label userName;

    @FindBy(id = "user-icon")
    private Icon userIcon;

    private Label getUserName() {
        return userName;
    }

    @FindBy(linkText = "Metals & Colors")
    private Button openMetalsNColorsPage;

    public void login(User user) {
        if (!homePage.getUserName().isDisplayed()) {
            userIcon.click();
            loginForm.login(user);
        }
    }

    public void checkUserName() {
        homePage.getUserName().is().text(ROMAN.getFullName());
    }

    public void openMetalsNColorsPage() {
        openMetalsNColorsPage.click();
    }
}
