package io.zipcoder;

import java.util.ArrayList;
import java.util.List;

public class Item {
    private String name;
    private List<Double> prices;
    private String type;
    private String expiration;
    private int timesSeen;

    /**
     * Item should not be created unless you have all of the elements, which is why you are forcing
     * it to be set in the constructor. In ItemParser, if you do not find all the elements of a Item,
     * you should throw an Custom Exception.
     *
     * @param name
     * @param price
     * @param type
     * @param expiration
     */
    public Item(String name, Double price, String type, String expiration) {
        this.name = name;
        prices = new ArrayList<>();
        prices.add(price);
        this.type = type;
        this.expiration = expiration;
        timesSeen = 0;
    }

    public String getName() {
        return name;
    }

    public List<Double> getPrices() {
        return prices;
    }

    public String getType() {
        return type;
    }

    public String getExpiration() {
        return expiration;
    }

    public void addPrice(Double price) {
        prices.add(price);
    }

    @Override
    public String toString() {
        //return String.format("name: %-10s | price: %-7s | type: %-7s | expiration: %-10s", name, price, type, expiration);
        return null;
    }
}