package ru.training.at.hw7;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import ru.training.at.hw7.pages.HomePage;
import ru.training.at.hw7.pages.MetalsColorsPage;

@JSite("https://jdi-testing.github.io/jdi-light")
public class JdiSite {
    public static HomePage homePage;
    public static MetalsColorsPage metalsColorsPage;

    public static void openHomePage() {
        homePage.open();
    }
}
