package ru.alfa_bank.convertor_to_gif.dto;

import lombok.Data;

import java.util.Map;

@Data
public class ExchangeRateDto {

    private String disclaimer;
    private String license;
    private Integer timestamp;
    private String base;
    private Map<String, Double> rates;
}
