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
    public void testAnalyze() {
        Item[] items = {
                new Item("milk", 1.25, "food", "1/1/1970"),
                new Item("milk", 1.25, "food", "1/1/1934"),
                new Item("milk", 3.00, "food", "1/1/20XX")
        };

        String expected = "";
        String actual = ItemAnalyser.analyze(Arrays.asList(items));

        assertEquals(expected, actual);
    }
}