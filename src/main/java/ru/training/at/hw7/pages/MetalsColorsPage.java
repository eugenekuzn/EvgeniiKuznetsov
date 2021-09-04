package ru.training.at.hw7.pages;

import static ru.training.at.hw7.JdiSite.metalsColorsPage;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import edu.emory.mathcs.backport.java.util.Arrays;
import java.util.List;
import junit.framework.Assert;
import junit.framework.AssertionFailedError;
import ru.training.at.hw7.pages.metalscolorsjsontestdata.MetalsNColorsJsonData;

@Url("/metals-colors.html")
@Title("Metal and Colors")
public class MetalsColorsPage extends WebPage {

    @UI("p.radio")
    private RadioButtons summary;
    @UI("p.checkbox")
    private Checklist elements;
    @JDropdown(root = "div[id='colors']", value = "option", list = "li", expand = ".caret")
    private Dropdown colors;
    @JDropdown(root = "div[id='metals']", value = "option", list = "li", expand = ".caret")
    private Dropdown metals;
    @JDropdown(root = "div[id='vegetables']", value = "checkbox", list = "li", expand = ".caret")
    private Dropdown vegetables;
    @FindBy(id = "submit-button")
    private Button submitButton;

    @Css(".summ-res")
    public UIElement summaryResult;
    @Css(".col-res")
    public UIElement colorResult;
    @Css(".met-res")
    public UIElement metalResult;
    @Css(".sal-res")
    public UIElement vegetablesResult;
    @Css(".elem-res")
    public UIElement elementsResult;

    public void checkMetalsNColorsPageIsOpen() {
        metalsColorsPage.isOpened();
    }

    public void interactionWithElementsOnMetalsNColorsPage(MetalsNColorsJsonData testData) {
        selectSummaryButtons(testData);
        selectElement(testData);
        selectColor(testData);
        selectMetal(testData);
        selectVegetables(testData);
        submitButton.click();
    }

    public void assertResultsOnMetalsNColorsPage(MetalsNColorsJsonData testData) {
        assertSummaryResult(testData);
        assertElementsResult(testData);
        assertColorResult(testData);
        assertMetalResult(testData);
        assertVegetableResults(testData);
    }

    private void selectSummaryButtons(MetalsNColorsJsonData testData) {
        for (Integer checkingData : testData.getSummary()) {
            String nameOfButton = checkingData.toString();
            summary.list().forEach(el -> {
                if (el.getText().contains(nameOfButton)) {
                    el.click();
                }
            });
        }
    }

    private void selectElement(MetalsNColorsJsonData testData) {
        for (String elementName : testData.getElements()) {
            elements.list().forEach(el -> {
                if (el.getText().contains(elementName)) {
                    el.click();
                }
            });
        }
    }

    private void selectColor(MetalsNColorsJsonData testData) {
        colors.expand();

        for (UIElement element : colors.list()) {
            if (element.getText().equals(testData.getColor())) {
                element.click();
                break;
            }
        }
    }

    private void selectMetal(MetalsNColorsJsonData testData) {
        metals.expand();

        for (UIElement element : metals.list()) {
            if (element.getText().equals(testData.getMetals())) {
                element.click();
                break;
            }
        }
    }

    private void selectVegetables(MetalsNColorsJsonData testData) {
        vegetables.expand();
        vegetables.select(3);

        for (String name : testData.getVegetables()) {
            for (UIElement element : vegetables.list()) {
                if (element.getText().equals(name)) {
                    element.check();
                    break;
                }
            }
        }
    }

    public void assertSummaryResult(MetalsNColorsJsonData testData) {
        List<Integer> summaryList = Arrays.asList(testData.getSummary());
        Integer sum = 0;
        for (Integer integer : summaryList) {
            sum += integer;
        }
        Assert.assertTrue(summaryResult.getText().contains(sum.toString()));
    }

    public void assertElementsResult(MetalsNColorsJsonData testData) {
        List<String> elementsList = Arrays.asList(testData.getElements());
        elementsList.forEach(el -> Assert.assertTrue(elementsResult.getText().contains(el)));
    }

    public void assertColorResult(MetalsNColorsJsonData testData) {
        Assert.assertTrue(colorResult.getText().contains(testData.getColor()));
    }

    public void assertMetalResult(MetalsNColorsJsonData testData) {
        Assert.assertTrue(metalResult.getText().contains(testData.getMetals()));
    }

    public void assertVegetableResults(MetalsNColorsJsonData testData) {
        List<String> vegetablesList = Arrays.asList(testData.getVegetables());
        vegetablesList.forEach(el -> Assert.assertTrue(vegetablesResult.getText().contains(el)));
    }
}
