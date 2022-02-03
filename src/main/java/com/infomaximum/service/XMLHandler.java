package com.infomaximum.service;

import com.infomaximum.entity.Address;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XMLHandler extends DefaultHandler {

    private static List<Address> addressList = new ArrayList<>();

    public static List<Address> getAddresses() {
        return addressList;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("item")) {
            String city = attributes.getValue("city");
            String street = attributes.getValue("street");
            String house = attributes.getValue("house");
            String floor = attributes.getValue("floor");
            addressList.add(new Address(city, street, house, floor));
        }
    }

    public static List<Address> readXml(String path) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        XMLHandler handler = new XMLHandler();
        parser.parse(new File(path), handler);
        return XMLHandler.getAddresses();
    }

}