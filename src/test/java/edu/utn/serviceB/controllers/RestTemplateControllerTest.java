package edu.utn.serviceB.controllers;

import edu.utn.serviceB.models.RestTemplateResponse;
import edu.utn.serviceB.services.RestService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class RestTemplateControllerTest {

    RestTemplateController restTemplateController;

    @Mock
    RestService restService;

    @Before
    public void setUp(){
        initMocks(this);
        restTemplateController = new RestTemplateController(restService);
    }

    @Test
    public void get(){

        RestTemplateResponse[] response = {};
        ResponseEntity<RestTemplateResponse[]> responseEntity = ResponseEntity.of(Optional.of(response));

        when(restService.get()).thenReturn(responseEntity);

        Assert.assertEquals(responseEntity, restTemplateController.get());
    }
}
