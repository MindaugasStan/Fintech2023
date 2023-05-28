package com.example.fintech2023.parsers;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class ECBRatesParser {
    public static String getRateFromECB(InputStream stream) throws IOException {
        String result = "";
        try {
            DocumentBuilderFactory xmlDocFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder xmlDocBuilder = xmlDocFactory.newDocumentBuilder();
            Document doc = xmlDocBuilder.parse(stream);

            NodeList rateNodes = doc.getElementsByTagName("Cube");
            for (int i = 0; i < rateNodes.getLength(); ++i) {
                Element cube = (Element) rateNodes.item(i);
                if (cube.hasAttribute("currency")){
                    String currencyName = cube.getAttribute("currency");
                    result += "Currency: " + currencyName + "rate is " + cube.getAttribute("rate") + "\n";
                }
            }
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
