package ru.alfa_bank.convertor_to_gif.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.alfa_bank.convertor_to_gif.client.GifClient;

import java.util.Map;

@Service
public class GifServiceImpl implements GifService {

    @Value("${giphy.api.key}")
    private String key;
    @Autowired
    private GifClient gifClient;

    @Override
    public ResponseEntity<Map> getGif(String tag) {
        return gifClient.getGif(key, tag);
    }
}
