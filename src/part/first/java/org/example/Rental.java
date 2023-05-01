package org.example;

import lombok.Getter;

@Getter
public class Rental {
    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public double getCharge() {
        return movie.getCharge(daysRented);
    }


    public int getFrequentRenterPoints() {
        return movie.getFrequentRenterPoints(daysRented);
    }
}
