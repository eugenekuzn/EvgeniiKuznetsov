package ru.training.at.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FunctionOfMultiplicationTest {

    @DataProvider(name = "test-data")
    public static Object[][] dataForMultiplication() {
        return new Object[][] {{125.0, 5.0, 625.0}, {10.5, 0.0, 0.0}, {100.0, 0.5, 50.0}, {-10.0, -5.0, 50.0}};
    }

    @Test(dataProvider = "test-data", groups = GroupTags.MULT_AND_DIV_GROUP)
    public void multiplication(Double a, Double b, Double expected) {
        Calculator calculator = new Calculator();
        Double actual = calculator.mult(a, b);
        Assert.assertEquals(actual, expected);
    }
}

