package ru.training.at.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CosineCalculationTest {

    private static Calculator calculator;

    @DataProvider(name = "test-data")
    public static Object[][] dataForCosineCalculation() {
        return new Object[][] {{180.0, -1.0}, {90.0, 0.0}, {360.0, 1.0}, {0.0, 1.0}};
    }

    @Test(dataProvider = "test-data", groups = GroupTags.COSINE_GROUP)
    public void cosine(Double a, Double expected) {
        calculator = new Calculator();
        Double actual = calculator.cos(a);
        Assert.assertEquals(actual, expected);
    }
}
