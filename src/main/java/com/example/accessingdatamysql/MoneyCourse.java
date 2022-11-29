package com.example.accessingdatamysql;

import org.springframework.stereotype.Component;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component("ABean")
public class MoneyCourse {
    public static final Logger logger = Logger.getLogger(MoneyCourse.class.getName());
    public MoneyCourse(){ }

    public static String WEB_OUTPUT;

    public String getHTML(String urlToRead) throws Exception {
        logger.info("[log] enter point in getHTML");
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpsURLConnection) url.openConnection();

        conn.setRequestMethod("GET");
        try (BufferedReader reader = new BufferedReader (
                new InputStreamReader(conn.getInputStream()))){
            for(String line; (line = reader.readLine()) != null; ){
                result.append(line);
            }
        }
        logger.info("[log] out point in getHTML");
        return result.toString();
    }

    public void MoneyCourse() throws Exception {
        logger.info("[log] enter point in MoneyCourse");
        String url = "https://api.privatbank.ua/p24api/pubinfo?exchange&coursid=5";

        Pattern pattern = Pattern.compile("\\d+\\.\\d+");
        Matcher matcher = pattern.matcher(getHTML(url));

        String EUR_UAH_BUY = "";
        String EUR_UAH_SALE = "";
        String USD_UAH_BUY = "";
        String USD_UAH_SALE = "";

        int counter = 0;
        while (matcher.find()) {
            if(counter == 0) {
                EUR_UAH_BUY = matcher.group();
                counter++;
            } else if(counter == 1) {
                EUR_UAH_SALE = matcher.group();
                counter++;
            } else if(counter == 2) {
                USD_UAH_BUY = matcher.group();
                counter++;
            } else if (counter == 3) {
                USD_UAH_SALE = matcher.group();
                counter++;
            }
        }
        WEB_OUTPUT = "EUR: Buy = " + EUR_UAH_BUY + " Sale = " + EUR_UAH_SALE
                + "\nUSD: But = " + USD_UAH_BUY + " Sale = " + USD_UAH_SALE;
        System.out.println(WEB_OUTPUT);
        logger.info("[log] out point in MoneyCourse");
    }

}
