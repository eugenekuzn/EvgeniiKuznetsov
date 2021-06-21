package ru.training.at.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FunctionOfAdditionTest {

    @DataProvider(name = "test-data")
    public static Object[][] dataForAddition() {
        return new Object[][] {{1.15, 9.32, 10.47}, {11.0, 7.0, 18.0}, {135.0, 0.27, 135.27}, {-10.0, -7.0, -17.0}};
    }

    @Test(dataProvider = "test-data", groups = GroupTags.ADD_AND_SUBTRACT_GROUP)
    public void addition(Double a, Double b, Double expected) {
        Calculator calculator = new Calculator();
        Double actual = calculator.sum(a, b);
        Assert.assertEquals(actual, expected);
    }
}

