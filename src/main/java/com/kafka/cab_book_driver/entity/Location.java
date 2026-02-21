package com.kafka.cab_book_driver.entity;


public class Location {
    private String address;

    public Location() {
    }

    public Location(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
