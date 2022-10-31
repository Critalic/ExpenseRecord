package com.example.expenserecord;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ExpenseRecordApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        ApplicationContext context= SpringApplication.run(ExpenseRecordApplication.class, args);
//        context.getBean(ExpenseService.class).addMonetaryUnit(new MonetaryUnit(Currency.getInstance("USD")));

    }

}
