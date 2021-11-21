package ru.training.at.hw7.pages.metalscolorsjsontestdata;

import com.epam.jdi.tools.DataClass;

public class MetalsNColorsJsonData extends DataClass<MetalsNColorsJsonData> {

    private final Integer[] summary;
    private final String[] elements;
    private final String color;
    private final String metals;
    private final String[] vegetables;

    public MetalsNColorsJsonData(Integer[] summary, String[] elements, String color, String metals,
                                 String[] vegetables) {
        this.summary = summary;
        this.elements = elements;
        this.color = color;
        this.metals = metals;
        this.vegetables = vegetables;
    }

    public Integer[] getSummary() {
        return summary;
    }

    public String[] getElements() {
        return elements;
    }

    public String getColor() {
        return color;
    }

    public String getMetals() {
        return metals;
    }

    public String[] getVegetables() {
        return vegetables;
    }
}
