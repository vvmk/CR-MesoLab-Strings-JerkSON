package io.zipcoder;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * filename:
 * project: PainfullAfternoon
 * author: https://github.com/vvmk
 * date: 3/17/18
 */
public class ItemAnalyser {
    public static String analyze(List<Item> items) {
        Set<String> uniqueItems = buildSetFromItems(items);
        StringBuilder sb = new StringBuilder();

        for (String name : uniqueItems) {
            sb.append(String.format("\nname: \t%8s\t\ttimes seen:  %3d\n", name, getOccurrencesOfItem(name, items)));
            sb.append("================\t\t================\n");

            Set<Double> prices = buildSetFromPrices(name, items);
            for (Double price : prices) {
                sb.append(String.format("price:\t%8s\t\ttimes seen:  %3d\n", price, getOccurrencesOfPrice(price, name, items)));
                sb.append("----------------\t\t----------------\n");
            }
        }
        return sb.toString();
    }

    public static Set<String> buildSetFromItems(List<Item> items) {
        Set<String> result = new HashSet<>();
        for (Item i : items)
            result.add(i.getName());
        return result;
    }

    public static Set<Double> buildSetFromPrices(String targetItem, List<Item> items) {
        Set<Double> result = new HashSet<>();
        for (Item i : items) {
            if (i.getName().equals(targetItem))
                result.add(i.getPrice());
        }
        return result;
    }

    public static int getOccurrencesOfItem(String item, List<Item> items) {
        int sum = 0;
        for (Item i : items) {
            if (i.getName().equalsIgnoreCase(item))
                sum++;
        }
        return sum;
    }

    public static int getOccurrencesOfPrice(Double price, String item, List<Item> items) {
        int sum = 0;
        for (Item i : items) {
            if (i.getName().equals(item) && i.getPrice().equals(price))
                sum++;
        }
        return sum;
    }
}
