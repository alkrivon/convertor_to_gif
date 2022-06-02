package ru.alfa_bank.convertor_to_gif.service;

import org.springframework.http.ResponseEntity;
import ru.alfa_bank.convertor_to_gif.dto.ExchangeRateDto;

public interface ExchangeRateService {
    ResponseEntity<ExchangeRateDto> getRate(String date, String base);
}
