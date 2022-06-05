package ru.alfa_bank.convertor_to_gif.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import ru.alfa_bank.convertor_to_gif.service.ExchangeRateServiceImpl;
import ru.alfa_bank.convertor_to_gif.service.GifServiceImpl;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc(addFilters = false)
@WebMvcTest(ConvertorController.class)
class ConvertorControllerTest {

    @MockBean
    private GifServiceImpl gifService;
    @MockBean
    private ExchangeRateServiceImpl exchangeRateService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void returnRichGif() throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("key", "rich");
        ResponseEntity<Map> responseEntity = new ResponseEntity<>(map, HttpStatus.OK);
        when(exchangeRateService.getTag(anyString())).thenReturn("rich");
        when(gifService.getGif("rich")).thenReturn(responseEntity);
        mockMvc.perform(get("http://localhost:8080/convertor/gif/test")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$.key").value("rich"))
                .andExpect(status().isOk());
    }

    @Test
    public void returnBrokeGif() throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("key", "broke");
        ResponseEntity<Map> responseEntity = new ResponseEntity<>(map, HttpStatus.OK);
        when(exchangeRateService.getTag(anyString())).thenReturn("broke");
        when(gifService.getGif("broke")).thenReturn(responseEntity);
        mockMvc.perform(get("http://localhost:8080/convertor/gif/test")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$.key").value("broke"))
                .andExpect(status().isOk());
    }
}