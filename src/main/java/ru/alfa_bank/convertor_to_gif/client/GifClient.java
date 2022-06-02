package ru.alfa_bank.convertor_to_gif.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "giphy-client", url = "${giphy.api.url}")
public interface GifClient {

    @GetMapping("/random")
    ResponseEntity<Map> getGif(@RequestParam("api_key") String apiKey,
                               @RequestParam("tag") String tag);
}
