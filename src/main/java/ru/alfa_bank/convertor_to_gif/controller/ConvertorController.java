package ru.alfa_bank.convertor_to_gif.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.alfa_bank.convertor_to_gif.service.ExchangeRateServiceImpl;
import ru.alfa_bank.convertor_to_gif.service.GifServiceImpl;

import java.util.Map;

@RestController
@RequestMapping("/convertor")
public class ConvertorController {

    @Autowired
    private GifServiceImpl gifService;
    @Autowired
    private ExchangeRateServiceImpl exchangeRateService;

    @GetMapping("/gif/{symbols}")
    public ResponseEntity<Map> getRateGif(@PathVariable String symbols) {
        String tag = exchangeRateService.getTag(symbols);
        return gifService.getGif(tag);
    }
}
