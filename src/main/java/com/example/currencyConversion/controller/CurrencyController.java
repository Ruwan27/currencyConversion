package com.example.currencyConversion.controller;

import com.example.currencyConversion.common.StatusCode;
import com.example.currencyConversion.request.ConversionRequest;
import com.example.currencyConversion.response.ApiResponse;
import com.example.currencyConversion.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1")
public class CurrencyController {
    @Autowired
    private CurrencyService currencyService;

    @PostMapping("/convert-currency")
    public ResponseEntity<ApiResponse> convertCurrency(@RequestBody ConversionRequest request) throws IOException {
        double exchangeAmount = currencyService.getExchangeAmount(request.getAmountInSourceCurrency(),request.getSourceCurrency(), request.getTargetCurrency());

        return ResponseEntity.ok(ApiResponse.forStatus(StatusCode.S0000)
                .withMessage(StatusCode.S0000.getMessage())
                .withPayload(exchangeAmount));
    }

}
