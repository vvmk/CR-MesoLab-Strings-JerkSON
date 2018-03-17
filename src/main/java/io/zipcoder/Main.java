package io.zipcoder;

import org.apache.commons.io.IOUtils;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static int exceptionCount = 0;

    public static void main(String[] args) throws Exception {
        String output = (new Main()).readRawDataToString();
        System.out.println(output);

        ItemParser parser = new ItemParser();
        List<String> itemStrings = parser.parseRawDataIntoStringArray(output);
        List<Item> items = new ArrayList<>();
        for (String item : itemStrings) {
            try {
                Item i = parser.parseStringIntoItem(item);
                items.add(i);
            } catch (ItemParseException ipe) {
                exceptionCount++;
            }
        }

        System.out.println("\n**********************");
        System.out.println("Exceptions found: " + exceptionCount);
        System.out.println("**********************\n");

        items.forEach(i -> System.out.println(i.toString()));
    }

    public String readRawDataToString() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        return IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
    }
}
