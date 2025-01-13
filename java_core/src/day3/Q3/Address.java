package day3.Q3;

import java.io.Serializable;

public class Address implements Serializable {
    String city;
    String state;
    String country;
    String exactAddress;

    public Address(String city, String state, String country, String exactAddress) {
        this.city = city;
        this.state = state;
        this.country = country;
        this.exactAddress = exactAddress;
    }
}