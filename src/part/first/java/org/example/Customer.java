package org.example;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String name;
    private Vector _rentals = new Vector();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        Enumeration rentals = _rentals.elements();
        String result = "Учет аренды для " + getName() + "\n";
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += "\t" + each.getMovie().getTitle() + "\t" + each.getCharge() + "\n";
        }

        //добавить нижний колонтитул
        result += "Сумма задолженности составляет " + getTotalCharge() + "\n";
        result += "Вы заработали " + getTotalFrequentRenterPoints() + " очков за активность";
        return result;
    }

    public String htmlStatement() {
        Enumeration rentals = _rentals.elements();
        String result = "<H1>Операции аренды для <EM>" + getName() + "</EM></H1><P>\n";
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getMovie().getTitle() + ": " + each.getCharge() + "<BR>\n";
        }
        //добавить нижний колонтитул
        result += "<P>Ваша задолженность составляет <EM>" + getTotalCharge() + "</EM><P>\n";
        result += "На этой аренде вы заработали <EM>" + getTotalFrequentRenterPoints() + "</EM> очков за активность<P>";
        return result;
    }


    private double getTotalCharge() {
        double result = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getCharge();
        }
        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int result = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }
}
