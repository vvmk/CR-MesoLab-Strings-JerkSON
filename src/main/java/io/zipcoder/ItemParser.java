package io.zipcoder;

import java.util.*;
import java.util.regex.Pattern;

public class ItemParser {


    public ArrayList<String> parseRawDataIntoStringArray(String rawData) {
        String stringPattern = "##";
        return splitStringWithRegexPattern(stringPattern, rawData);
    }

    public Item parseStringIntoItem(String rawItem) throws ItemParseException {
        rawItem = normalizeCase(rawItem);
        List<String> props = findKeyValuePairsInRawItemData(rawItem);

        Map<String, String> pMap = new HashMap<>();
        for (String prop : props) {
            String[] pair = getPairFromString(prop);
            try {
                pMap.put(pair[0], pair[1]);
            } catch (Exception e) {
                throw new ItemParseException("invalid prop value: " + e.getMessage());
            }
        }

        try {
            return new Item(pMap.get("name"), Double.parseDouble(pMap.get("price")), pMap.get("type"), pMap.get("expiration"));
        } catch (RuntimeException re) {
            throw new ItemParseException("creation failure: " + pMap.toString());
        }
    }

    public String[] getPairFromString(String prop) {
        Pattern delim = Pattern.compile(":");
        return delim.split(prop);
    }

    protected String normalizeCase(String input) {
        return input.toLowerCase();
    }

    protected String replaceZeros(String input) {
        Pattern p = Pattern.compile("(?![a-z]+)0(?=[a-z]*)");
        return p.matcher(input).replaceAll("o");
    }

    public ArrayList<String> findKeyValuePairsInRawItemData(String rawItem) {
        String stringPattern = "[;|^|!|%|*|@]";
        return splitStringWithRegexPattern(stringPattern, rawItem);
    }

    private ArrayList<String> splitStringWithRegexPattern(String stringPattern, String inputString) {
        return new ArrayList<>(Arrays.asList(inputString.split(stringPattern)));
    }
}
