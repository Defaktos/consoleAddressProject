package com.infomaximum.service;
import com.infomaximum.entity.Address;

import java.util.List;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StatisticsService {


    public static void countingDuplicates(List<Address> addresses) {
        addresses.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(p -> p.getValue() > 1)
                .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()))
                .entrySet()
                .forEach(System.out::println);
    }

    public static void countingFloorInCities(List<Address> addresses) {
        addresses.stream()
                .collect(Collectors
                        .groupingBy(
                        Address::getCity,
                        TreeMap::new,
                        Collectors.groupingBy(
                                Address::getFloor, TreeMap::new, Collectors.counting())))
                .entrySet()
                .forEach(System.out::println);
    }
}


