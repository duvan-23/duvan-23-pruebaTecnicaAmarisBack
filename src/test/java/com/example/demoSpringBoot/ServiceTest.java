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

            Assertions.assertEquals("Tiger Nixon",employee.getEmployee_name(),"Correcta decodificación de datos ");
            Assertions.assertEquals(320800,employee.getEmployee_salary(),"Correcta decodificación de datos ");
            Assertions.assertEquals(61,employee.getEmployee_age(),"Correcta decodificación de datos ");
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

        Assertions.assertEquals("200 OK",statusCode, "Response url dummy service 200");

    }
}
