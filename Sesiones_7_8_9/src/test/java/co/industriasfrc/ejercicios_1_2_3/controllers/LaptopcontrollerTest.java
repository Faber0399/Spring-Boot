package co.industriasfrc.ejercicios_1_2_3.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplication.*;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.test.web.reactive.server.WebTestClient;

import co.industriasfrc.ejercicios_1_2_3.entities.Laptop;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LaptopcontrollerTest {

    private TestRestTemplate testRestTemplate;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port);
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }

    @Test
    void testLaptops() {
        ResponseEntity<Laptop[]> response = testRestTemplate.getForEntity("/api/laptops", Laptop[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(200, response.getStatusCodeValue());

        List<Laptop> books = Arrays.asList(response.getBody());
        System.out.println(books.size());
        
    }

    @Test
    void testCreateLaptop() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json = "{\"name\": \"Destroyer\",\"brand\": \"Acer\",\"model\": \"2021\",\"os\":\"Windows\",\"computer_line\": \"Gamer\",\"inventary\": \"Full\",\"type_import\": false}";

        HttpEntity<String> request = new HttpEntity<>(json, headers);

        ResponseEntity<Laptop> response = testRestTemplate.exchange("/api/laptops/create", HttpMethod.POST, request,
                Laptop.class);

        Laptop result = response.getBody();
        

        assertEquals(1L, result.getId());
        assertEquals("Destroyer", result.getName());
    }

    @Test
    void testDelete() {
        ResponseEntity<Laptop[]> response = testRestTemplate.getForEntity("/api/laptops/1", Laptop[].class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

    }

    @Test
    void testDeleteAll() {
        ResponseEntity<Laptop[]> response = testRestTemplate.getForEntity("/api/laptops", Laptop[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void testLaptopById() {
        ResponseEntity<Laptop> response = testRestTemplate.getForEntity("/api/laptops/1", Laptop.class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    

    @Test
    void testUpdate() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json = "{\"id\":1,\"name\": \"Destroyer\",\"brand\": \"Acer\",\"model\": \"2021\",\"os\":\"Windows\",\"computer_line\": \"Gamer\",\"inventary\": \"Full\",\"type_import\": false}";

        HttpEntity<String> request = new HttpEntity<>(json, headers);

        ResponseEntity<Laptop> response = testRestTemplate.exchange("/api/laptops", HttpMethod.PUT, request, Laptop.class);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

    
    }

}
