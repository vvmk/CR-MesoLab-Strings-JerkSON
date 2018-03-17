package io.zipcoder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * filename:
 * project: PainfullAfternoon
 * author: https://github.com/vvmk
 * date: 3/17/18
 */
public class ItemAnalyser {
    public static String analyze(List<Item> items) {
        //build map
        Map<String, ItemData> dataMap = new HashMap<>();
        for (Item i : items) {
            String key = dataMap.get(i.getName());

        }
        //return map to string
        return null;
    }

    class ItemData {
        int timesSeen;
        ArrayList<Prices> prices;

        class Prices {
            int timesSeen;
            Double price;
        }
    }
}
