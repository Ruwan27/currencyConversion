package com.example.currencyConversion.request;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ConversionRequest {
    private double amountInSourceCurrency;
    private String sourceCurrency;
    private String targetCurrency;

    // getters and setters
}