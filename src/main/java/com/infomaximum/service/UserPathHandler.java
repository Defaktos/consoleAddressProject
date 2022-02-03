package com.infomaximum.service;

import com.infomaximum.entity.Address;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserPathHandler {
    private static List<Address> addresses = new ArrayList<>();

    public static List<Address> readFileWithEnds(String path) throws ParserConfigurationException, IOException, SAXException {
        if (path.endsWith(".xml")) {
            addresses = XMLHandler.readXml(path);
        } else if (path.endsWith(".csv")) {
            addresses = CSVHandler.readCsv(path);
//        } else {
//            System.out.println("Error");
        }
        return addresses;
    }
}

