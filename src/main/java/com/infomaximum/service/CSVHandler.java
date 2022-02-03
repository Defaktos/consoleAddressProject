package com.infomaximum.service;

import com.infomaximum.entity.Address;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVHandler {

    public static List<Address> readCsv(String path) {
        List<Address> addressList = new ArrayList<>();
        Path pathToFile = Paths.get(path);
        try {
            BufferedReader br = Files.newBufferedReader(pathToFile);
            String row = br.readLine();
            while (row != null) {
                List<String> attributes = Arrays.asList(row.split(";"));
                Address address = getOneAddress(attributes);
                addressList.add(address);
                row = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return addressList;
    }

    private static Address getOneAddress(List<String> attributes) {
        String city = attributes.get(0);
        String street = attributes.get(1);
        String house = attributes.get(2);
        String floor = attributes.get(3);
        Address address = new Address(city, street, house, floor);
        return address;
    }
}
