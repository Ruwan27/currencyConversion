package com.example.currencyConversion.controller;

import com.example.currencyConversion.Request.ConversionRequest;
import com.example.currencyConversion.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1")
public class CurrencyController {
    @Autowired
    private CurrencyService currencyService;

    @PostMapping("/convert-currency")
    public double convertCurrency(@RequestBody ConversionRequest request) throws IOException {
        double exchangeAmount = currencyService.getExchangeAmount(request.getAmountInSourceCurrency(),request.getSourceCurrency(), request.getTargetCurrency());

        return   exchangeAmount;
    }

}
