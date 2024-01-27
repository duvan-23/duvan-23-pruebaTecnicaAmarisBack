package com.example.demoSpringBoot.models.service;

import com.example.demoSpringBoot.models.domain.TipoList;
import com.example.demoSpringBoot.models.domain.TipoObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class EmpleadosApi {
    @Value("${urlEmpleados}")
    private String urlEmpleados;
    @Value("${urlEmpleado}")
    private String urlEmpleado;

    public TipoList empleados(){
        WebClient client = WebClient.create();
        String responseJson = client.get()
                .uri(urlEmpleados)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(responseJson, TipoList.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public TipoObject empleado(int num){
        WebClient client = WebClient.create();
        String responseJson = client.get()
                .uri(urlEmpleado+num)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(responseJson, TipoObject.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
