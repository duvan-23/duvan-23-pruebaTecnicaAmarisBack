package com.example.demoSpringBoot.service;

import com.example.demoSpringBoot.models.TipoList;
import com.example.demoSpringBoot.models.TipoObject;
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

        try {
            String responseJson = servicio(urlEmpleados);
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(responseJson, TipoList.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public TipoObject empleado(int num){
        try {
            String responseJson = servicio(urlEmpleado+num);
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(responseJson, TipoObject.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    private String servicio(String url){
        WebClient client = WebClient.create();
        return  client.get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
