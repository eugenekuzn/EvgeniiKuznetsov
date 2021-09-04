package ru.training.at.hw7;

import static ru.training.at.hw7.JdiSite.homePage;
import static ru.training.at.hw7.JdiSite.metalsColorsPage;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.training.at.hw7.entities.User;
import ru.training.at.hw7.pages.metalscolorsjsontestdata.MetalsNColorsJsonData;

public class MetalsNColorsPageElementsTest extends TestInit {

    @DataProvider(name = "metalsColorsDataSet")
    public Object[][] metalsColorsDataSet() throws FileNotFoundException {
        Gson gson = new Gson();
        String path = "src/test/resources/testdatahw7/JDI_ex8_metalsColorsDataSet.json";
        JsonObject jsonObject = new JsonParser().parseReader(new FileReader(path)).getAsJsonObject();
        List<MetalsNColorsJsonData> data = jsonObject.keySet().stream()
                                                     .map(key -> gson
                                                         .fromJson(jsonObject.get(key), MetalsNColorsJsonData.class))
                                                     .collect(Collectors.toList());
        return data.stream().map(value -> new MetalsNColorsJsonData[] {value}).toArray(Object[][]::new);
    }

    @Test(dataProvider = "metalsColorsDataSet")
    public void metalsNColorsPageElementsTest(MetalsNColorsJsonData metalsNColorsJsonData) {
        JdiSite.openHomePage();
        homePage.login(User.ROMAN);
        homePage.checkUserName();
        homePage.openMetalsNColorsPage();
        metalsColorsPage.checkMetalsNColorsPageIsOpen();
        metalsColorsPage.interactionWithElementsOnMetalsNColorsPage(metalsNColorsJsonData);
        metalsColorsPage.assertResultsOnMetalsNColorsPage(metalsNColorsJsonData);
    }
}
