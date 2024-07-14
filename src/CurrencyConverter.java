package com.example.CurrencyConverter;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.hc.client5.http.fluent.Request;
import org.apache.hc.core5.http.ParseException;

import java.io.IOException;

public class CurrencyConverter {

    public double convert(String from, String to, double amount) {
        try {
            String url = String.format("https://api.exchangerate-api.com/v4/latest/%s", from);
            String response = Request.get(url).execute().returnContent().asString();

            // Parse the response to get the exchange rate
            double rate = parseExchangeRate(response, to);

            return amount * rate;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }

    private double parseExchangeRate(String response, String to) {
        JsonObject jsonObject = JsonParser.parseString(response).getAsJsonObject();
        return jsonObject.getAsJsonObject("rates").get(to).getAsDouble();
    }
}
