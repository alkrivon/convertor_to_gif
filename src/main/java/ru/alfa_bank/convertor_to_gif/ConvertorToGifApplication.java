package ru.alfa_bank.convertor_to_gif;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ConvertorToGifApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConvertorToGifApplication.class, args);
	}

}
