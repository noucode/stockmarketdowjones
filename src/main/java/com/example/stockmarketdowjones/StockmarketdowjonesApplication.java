package com.example.stockmarketdowjones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.example.stockmarketdowjones.property.StorageProperties;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class StockmarketdowjonesApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockmarketdowjonesApplication.class, args);
	}

}
