package ru.alfa_bank.convertor_to_gif.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.alfa_bank.convertor_to_gif.client.ExchangeRateClient;
import ru.alfa_bank.convertor_to_gif.dto.ExchangeRateDto;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {

    @Value("${openexchangerates.key}")
    private String key;
    @Autowired
    private ExchangeRateClient exchangeRateClient;

    @Override
    public ExchangeRateDto getHistoricalRate(String date, String symbols) {
        return exchangeRateClient.getHistoricalRate(date, key, symbols);
    }

    @Override
    public ExchangeRateDto getLatestRate(String symbols) {
        return exchangeRateClient.getLatestRate(key, symbols);
    }

    public String getFormatDate() {
        Instant yesterdayDate = Instant.now().minus(1, ChronoUnit.DAYS);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(yesterdayDate, ZoneOffset.UTC);
        return localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public String getTag(String symbols) {
        String tag;
        String formateDate = getFormatDate();
        Double todayRate = getLatestRate(symbols).getRates().get(symbols);
        Double yesterdayRate = getHistoricalRate(formateDate, symbols).getRates().get(symbols);
        System.out.println(todayRate + " ... " + yesterdayRate);
        if (todayRate > yesterdayRate) {
            tag = "rich";
        } else {
            tag = "broke";
        }
        return tag;
    }
}
