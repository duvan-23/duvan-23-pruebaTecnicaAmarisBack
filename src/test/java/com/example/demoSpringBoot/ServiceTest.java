package com.example.demoSpringBoot;

import com.example.demoSpringBoot.models.domain.Empleado;
import com.example.demoSpringBoot.models.domain.TipoObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.reactive.function.client.WebClient;

public class ServiceTest {

    @Test
    public  void empleadoTest(){
        WebClient client = WebClient.create();
        String responseJson = client.get()
                .uri("https://dummy.restapiexample.com/api/v1/employee/1")
                .retrieve()
                .bodyToMono(String.class)
                .block();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            TipoObject response = objectMapper.readValue(responseJson, TipoObject.class);
            Empleado employee = response.getData();
            Assertions.assertEquals(employee.getEmployee_name(), "Tiger Nixon");
            Assertions.assertEquals(employee.getEmployee_salary(), 320800);
            Assertions.assertEquals(employee.getEmployee_age(), 61);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
