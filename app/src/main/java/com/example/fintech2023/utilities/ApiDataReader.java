package com.example.fintech2023.utilities;

import com.example.fintech2023.parsers.ECBRatesParser;
import com.example.fintech2023.parsers.FloatRatesXmlParser;
import com.example.fintech2023.parsers.GunfireHtmlParser;
import com.example.fintech2023.parsers.MeteoLtJsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static com.example.fintech2023.utilities.Constants.ECBEUROPE_URL;
import static com.example.fintech2023.utilities.Constants.FLOATRATES_API_URL;
import static com.example.fintech2023.utilities.Constants.GUNFIRE_URL;
import static com.example.fintech2023.utilities.Constants.METEOLT_API_URL;

public class ApiDataReader {
    public static String getValuesFromApi(String apiCode) throws IOException {
        InputStream apiContentStream = null;
        String result = "";
        try {
            switch (apiCode) {
                case METEOLT_API_URL:
                    apiContentStream = downloadUrlContent(METEOLT_API_URL);
                    result = MeteoLtJsonParser.getKaunasWeatherForecast(apiContentStream);
                    break;
                case FLOATRATES_API_URL:
                    apiContentStream = downloadUrlContent(FLOATRATES_API_URL);
                    result = FloatRatesXmlParser.getCurrencyRatesBaseUsd(apiContentStream);
                    break;
                case GUNFIRE_URL:
                    apiContentStream = downloadUrlContent(GUNFIRE_URL);
                    result = GunfireHtmlParser.getAmountAndDiscountFromGunfire(apiContentStream);
                    break;
                case ECBEUROPE_URL:
                    apiContentStream = downloadUrlContent(ECBEUROPE_URL);
                    result = ECBRatesParser.getRateFromECB(apiContentStream);
                    break;
                default:
            }
        }
        finally {
            if (apiContentStream != null) {
                apiContentStream.close();
            }
        }
        return result;
    }

    //Routine that creates and calls GET request to web page
    private static InputStream downloadUrlContent(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setReadTimeout(10000);
        conn.setConnectTimeout(15000);
        conn.setRequestMethod("GET");
        conn.setDoInput(true);
        conn.connect();
        return conn.getInputStream();
    }
}
