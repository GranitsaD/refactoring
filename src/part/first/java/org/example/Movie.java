package org.example;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Movie {
    public static final int CHILDREN = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String title;
    private Price price;

    public Movie(String title, int priceCode) {
        this.title = title;
        setPriceCode(priceCode);
    }

    public void setPriceCode(int arg) {
        switch (arg) {
            case REGULAR -> price = new RegularPrice();
            case CHILDREN -> price = new ChildrenPrice();
            case NEW_RELEASE -> price = new NewReleasePrice();
            default -> throw new IllegalArgumentException("Incorrect Price Code");
        }
    }

    public int getPriceCode() {
        return price.getPriceCode();
    }

    public double getCharge(int daysRented) {
        return price.getCharge(daysRented);
    }


    public int getFrequentRenterPoints(int daysRented) {
        return price.getFrequentRenterPoints(daysRented);
    }
}
