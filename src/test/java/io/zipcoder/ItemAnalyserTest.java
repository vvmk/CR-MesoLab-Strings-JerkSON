package io.zipcoder;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * filename:
 * project: PainfullAfternoon
 * author: https://github.com/vvmk
 * date: 3/17/18
 */
public class ItemAnalyserTest {

    @Test
    public void testGetItemOccurrences() {
        Item[] items = {
                new Item("milk", 1.25, "food", "1/1/1970"),
                new Item("milk", 1.25, "food", "1/1/1934"),
                new Item("bread", 2.00, "food", "4/4/4444"),
                new Item("milk", 3.00, "food", "1/1/20XX")
        };

        int expected = 3;
        int actual = ItemAnalyser.getOccurrencesOfItem(items[0], Arrays.asList(items));

        assertEquals(expected, actual);
    }

    @Test
    public void testGetPriceOccurrences() {
        Item[] items = {
                new Item("milk", 1.25, "food", "1/1/1970"),
                new Item("milk", 1.25, "food", "1/1/1934"),
                new Item("bread", 2.00, "food", "4/4/4444"),
                new Item("milk", 3.00, "food", "1/1/20XX")
        };

        int expected = 2;
        int actual = ItemAnalyser.getOccurrencesOfPrice(items[1].getPrice(), items[1], Arrays.asList(items));

        assertEquals(expected, actual);
    }
}