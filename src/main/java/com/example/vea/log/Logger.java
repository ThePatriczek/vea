package com.example.vea.log;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

@Component
@Aspect
public class Logger {
    public static final String filePath = "log.txt";

    @Before("execution(* com.example.vea.*.*.*(..))")
    public void log(JoinPoint joinPoint) {
        Date date = new Date();
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(filePath, true);
            fileWriter.write("Action: " + joinPoint.getSignature());
            fileWriter.write("\nTime: " + date.toString() + "\n\n");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}