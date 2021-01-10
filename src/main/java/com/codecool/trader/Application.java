package com.codecool.trader;

import com.codecool.trader.logger.Logger;
import com.codecool.trader.service.RemoteURLReader;
import com.codecool.trader.service.Trader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
