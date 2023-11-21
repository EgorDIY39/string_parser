package ru.egordiy39.string_parser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;

@Controller
@SpringBootApplication
@EntityScan(basePackageClasses = {
        StringParser.class
})
public class StringParser {
    public static ConfigurableApplicationContext context;

    public static void main(String[] args) {
        context = SpringApplication.run(StringParser.class, args);
    }
}