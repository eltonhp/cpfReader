package br.com.iteris.cpfReader.view;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;

import java.time.LocalTime;

public class Load implements CommandLineRunner {
    ApplicationContext applicationContext;


    public Load(ApplicationContext applicationContext) {
       this.applicationContext = applicationContext;
    }

    @Override
    public void run(String... args) throws Exception {
         this.applicationContext.toString();
    }
}
