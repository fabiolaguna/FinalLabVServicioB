package edu.utn.serviceB.services;

import edu.utn.serviceB.models.RestTemplateResponse;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@Service
public class RestService {

    private RestTemplate restTemplate;

    @PostConstruct
    private void init(){
        restTemplate = new RestTemplateBuilder().build();
    }

    public ResponseEntity<RestTemplateResponse[]> get() {

        String url = "http://localhost:8080/printers";

        ResponseEntity<RestTemplateResponse[]> response = null;
        try {
            response = restTemplate.exchange(url, HttpMethod.GET, null, RestTemplateResponse[].class);
        } catch (RestClientException e){
            e.printStackTrace();
        }

        return response;
    }
}
