package com.example.demoSpringBoot;

import com.example.demoSpringBoot.models.Empleado;
import com.example.demoSpringBoot.models.TipoObject;
import com.example.demoSpringBoot.service.EmpleadosApi;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class ServiceTest {
    private WebClient client ;
    @Test
    public  void empleadoTest(){
        client = WebClient.create();
        try {
            String responseJson = client.get()
                    .uri("https://dummy.restapiexample.com/api/v1/employee/1")
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            ObjectMapper objectMapper = new ObjectMapper();
            TipoObject response = objectMapper.readValue(responseJson, TipoObject.class);
            Empleado employee = response.getData();

            Assertions.assertEquals(employee.getEmployee_name(), "Tiger Nixon","Correcta decodificación de datos ");
            Assertions.assertEquals(employee.getEmployee_salary(), 320800,"Correcta decodificación de datos ");
            Assertions.assertEquals(employee.getEmployee_age(), 61,"Correcta decodificación de datos ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public  void service(){
        client = WebClient.create();
        Mono<HttpStatusCode> responseService  = client.get()
                .uri("https://dummy.restapiexample.com/api/v1/employees")
                .exchange()
                .map(response -> response.statusCode());

        HttpStatusCode response = responseService.block();
        String statusCode = response.toString();

        Assertions.assertEquals(statusCode, "200 OK", "Response url dummy service 200");

    }
}
