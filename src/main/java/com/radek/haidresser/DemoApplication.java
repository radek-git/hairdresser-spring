package com.radek.haidresser;

import com.radek.haidresser.entity.Appointment;
import com.radek.haidresser.entity.Client;
import com.radek.haidresser.repository.ClientRepository;
import com.radek.haidresser.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner sql(ClientRepository cr, EmployeeRepository er) {
        return args -> {
            Client client = new Client("name1", "surname1", "username1");

            cr.save(client);
        };
    }

}
