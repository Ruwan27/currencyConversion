package com.example.currencyConversion.service;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class CurrencyService {
    //private final String API_KEY = "YOUR_API_KEY_HERE";
    private final String API_URL = "https://openexchangerates.org/api/historical/2022-05-12.json?app_id=5c1ca022aae046d39992f94bd487b4d6";

    public double getExchangeAmount(Double AmountInSourceCurrency,String sourceCurrency, String targetCurrency) throws IOException {
        String url = API_URL;

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        System.out.println(response);
        in.close();

        JSONObject jsonObject = new JSONObject(response.toString());
        JSONObject rates = jsonObject.getJSONObject("rates");
        System.out.println(rates.getDouble(targetCurrency));

        return AmountInSourceCurrency/ rates.getDouble(sourceCurrency)*rates.getDouble(targetCurrency);
    }
}