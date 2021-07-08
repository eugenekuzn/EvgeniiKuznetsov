package ru.training.at.hw6.testinit;

public abstract class AbstractTextTestComponent {
    protected final String textUnderFirstImg = "To include good practices\nand ideas from successful\nEPAM project";
    protected final String textUnderSecondImg = "To be flexible and\ncustomizable";
    protected final String textUnderThirdImg = "To be multiplatform";
    protected final String textUnderFourthImg =
        "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…";

    protected final String waterCheckboxLog = "Water: condition changed to true";
    protected final String windCheckboxLog = "Wind: condition changed to true";
    protected final String selenRadioButtonLog = "metal: value changed to Selen";
    protected final String yellowColorLog = "Colors: value changed to Yellow";

    protected final String url = "https://jdi-testing.github.io/jdi-light/index.html";
    protected final String login = "Roman";
    protected final String password = "Jdi1234";

    protected final String checkingPage = "Home Page";
    protected final String checkingUserName = "ROMAN IOVLEV";

    protected final String[] headerElements = {"HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"};
    protected final String[] leftSideMenuElements =
        {"Home", "Contact form", "Service", "Metals & Colors", "Elements packs"};
    protected final String[] textUnderImages =
        {textUnderFirstImg, textUnderSecondImg, textUnderThirdImg, textUnderFourthImg};
    protected final String[] logTextComponents =
        {waterCheckboxLog, windCheckboxLog, selenRadioButtonLog, yellowColorLog};
}
