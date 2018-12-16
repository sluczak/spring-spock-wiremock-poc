package com.example.demo.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Set;

@Service
public class MyService {

    RestTemplate template;

    MyService() {
         template = new RestTemplate();
    }

    public Set<String> get() throws URISyntaxException {
        URI uri = new URI("http://localhost:9005/findosome");
        return template.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<Set<String>>() {}).getBody();
    }
}
