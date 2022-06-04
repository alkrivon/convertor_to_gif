package ru.alfa_bank.convertor_to_gif.service;

import ru.alfa_bank.convertor_to_gif.dto.ExchangeRateDto;

public interface ExchangeRateService {
    ExchangeRateDto getHistoricalRate(String date, String symbols);

    ExchangeRateDto getLatestRate(String symbols);
}
