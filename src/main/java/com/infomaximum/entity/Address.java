package com.infomaximum.entity;

import java.util.ArrayList;
import java.util.List;

public class Address {
    private String city;
    private String street;
    private String house;
    private String floor;


    public Address(String city, String street, String house, String floor) {
        this.city = city;
        this.street = street;
        this.house = house;
        this.floor = floor;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getHouse() {
        return house;
    }

    public String getFloor() {
        return floor;
    }

    @Override
    public String toString() {
        return "City: " + city + " Street: " + street + " House: " + house + " Floor:  " + floor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (city != null ? !city.equals(address.city) : address.city != null) return false;
        if (street != null ? !street.equals(address.street) : address.street != null) return false;
        if (house != null ? !house.equals(address.house) : address.house != null) return false;
        return floor != null ? floor.equals(address.floor) : address.floor == null;
    }

    @Override
    public int hashCode() {
        int result = city != null ? city.hashCode() : 0;
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (house != null ? house.hashCode() : 0);
        result = 31 * result + (floor != null ? floor.hashCode() : 0);
        return result;
    }
}
