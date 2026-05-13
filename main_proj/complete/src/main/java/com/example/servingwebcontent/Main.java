package com.example.servingwebcontent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Main.class, args);
        
        System.out.println("\n========================================");
        System.out.println(" APPLICATION STARTED SUCCESSFULLY!");
        System.out.println("========================================");
        
        System.out.println("\nControllers được scan:");
        String[] controllers = context.getBeanNamesForAnnotation(Controller.class);
        for (String controller : controllers) {
            System.out.println("  ✅ " + controller);
        }
        
        System.out.println("\n📋 RestControllers được scan:");
        String[] restControllers = context.getBeanNamesForAnnotation(RestController.class);
        for (String controller : restControllers) {
            System.out.println("  ✅ " + controller);
        }
        
        System.out.println("\n========================================\n");
    }
}