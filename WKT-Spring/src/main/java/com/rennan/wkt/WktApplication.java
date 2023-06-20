package com.rennan.wkt;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rennan.wkt.domain.Donator;
import com.rennan.wkt.service.DonatorService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.SpringVersion;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Configuration
@SpringBootApplication
@EnableScheduling
public class WktApplication {

    private static DonatorService donatorService;

    public WktApplication(DonatorService donatorService) {
        WktApplication.donatorService = donatorService;
    }

    public static void main(String[] args) {
        SpringApplication springApplication=new SpringApplication(WktApplication.class);
        System.out.println("Spring Core Version:- " + SpringVersion.getVersion());
        springApplication.run(args);

        // Caminho do arquivo JSON
        String filePath = "Caminho Relativo JSON aqui";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            // Configurar o Gson para a leitura do JSON
            Gson gson = new GsonBuilder().create();

            // Ler o arquivo JSON em uma string
            StringBuilder jsonContent = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonContent.append(line);
            }

            // Converter a string do JSON para uma lista de objetos
            List<Donator> doadores = Arrays.asList(gson.fromJson(jsonContent.toString(), Donator[].class));

            // Salvar a lista de objetos
            WktApplication.salvarDoadoresSQL(doadores);

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo JSON: " + e.getMessage());
        }
}

    private static void salvarDoadoresSQL(List<Donator> doadores) {
        for (Donator doador : doadores) {
            donatorService.saveDonator(doador);
        }
    }
}
