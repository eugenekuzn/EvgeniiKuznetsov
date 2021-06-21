package ru.training.at.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FunctionOfDivisionTest {

    @DataProvider(name = "test-data")
    public static Object[][] dataForDivision() {
        return new Object[][] {{125.0, 5.0, 25.0}, {0.25, 0.5, 0.5}, {135.0, 0.5, 270.0}, {-10.0, -5.0, 2.0}};
    }

    @Test(dataProvider = "test-data", groups = GroupTags.MULT_AND_DIV_GROUP)
    public void division(Double a, Double b, Double expected) {
        Calculator calculator = new Calculator();
        Double actual = calculator.div(a, b);
        Assert.assertEquals(actual, expected);
    }
}

