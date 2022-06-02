package ru.alfa_bank.convertor_to_gif.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ru.alfa_bank.convertor_to_gif.dto.ExchangeRateDto;

@FeignClient(name = "openexchange-client", url = "${giphy.api.url}")
public interface ExchangeRateClient {

    @GetMapping("/historical/{date}.json")
    ExchangeRateDto getHistoricalRate(
            @PathVariable String date,
            @RequestParam("app_id") String appId
    );

    @GetMapping("/latest.json")
    ExchangeRateDto getLatestRate(
            @RequestParam("app_id") String appId
    );
}
