package com.example;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@MicronautTest
class JsonviewIssueTest {

    @Inject
    @Client("/")
    HttpClient client;

    @Test
    void testJsonViewPojo() {
        HttpResponse<String> response = client.toBlocking().exchange("/pojo", String.class);
        assertEquals(HttpStatus.OK, response.getStatus());
        assertFalse(response.body().contains("password"));
    }

    @Test
    void testJsonViewList() {
        HttpResponse<String> response = client.toBlocking().exchange("/list", String.class);
        assertEquals(HttpStatus.OK, response.getStatus());
        assertFalse(response.body().contains("password"));
    }

    @Test
    void testJsonViewOptional() {
        HttpResponse<String> response = client.toBlocking().exchange("/optional", String.class);
        assertEquals(HttpStatus.OK, response.getStatus());
        assertFalse(response.body().contains("password"));
    }

    @Test
    void testJsonViewMono() {
        HttpResponse<String> response = client.toBlocking().exchange("/mono", String.class);
        assertEquals(HttpStatus.OK, response.getStatus());
        assertFalse(response.body().contains("password"));
    }

    @Test
    void testJsonViewFlux() {
        HttpResponse<String> response = client.toBlocking().exchange("/flux", String.class);
        assertEquals(HttpStatus.OK, response.getStatus());
        assertFalse(response.body().contains("password"));
    }
}
