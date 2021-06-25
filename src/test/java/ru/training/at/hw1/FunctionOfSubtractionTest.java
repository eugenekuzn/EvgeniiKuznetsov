package ru.training.at.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FunctionOfSubtractionTest {

    private static Calculator calculator;

    @DataProvider(name = "test-data")
    public static Object[][] dataForSubtraction() {
        return new Object[][] {{0.5, 0.2, 0.3}, {25.0, 7.0, 18.0}, {10.0, 0.2, 9.8}, {-76.0, -10.0, -66.0}};
    }

    @Test(dataProvider = "test-data", groups = GroupTags.ADD_AND_SUBTRACT_GROUP)
    public void subtraction(Double a, Double b, Double expected) {
        calculator = new Calculator();
        Double actual = calculator.sub(a, b);
        Assert.assertEquals(actual, expected);
    }
}

