package com.example.catalogo_libros.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.stereotype.Service;

@Service
public class GutendexApiService {

    private final String BASE_URL = "https://gutendex.com/books";

    public JsonNode fetchBooksFromApi(String query) {
        try {
            // Crear el cliente HTTP
            HttpClient client = HttpClient.newHttpClient();

            // Construir la solicitud
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(BASE_URL + "?search=" + query))
                    .GET()
                    .build();

            // Enviar la solicitud y obtener la respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Parsear el JSON usando ObjectMapper
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readTree(response.body());

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
