package edu.utn.serviceB.controllers;

import edu.utn.serviceB.models.RestTemplateResponse;
import edu.utn.serviceB.services.RestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/rest")
@Api(tags = "RestController")
@RequiredArgsConstructor
public class RestTemplateController {

    private final RestService restService;

    @GetMapping
    @ApiOperation(value = "get", notes = "Metodo encargado de retornar todas las impresoras del servicio A")
    @ApiResponses({
            @ApiResponse(code = HttpServletResponse.SC_NO_CONTENT, message = "Retorna una lista vacia de impresoras"),
            @ApiResponse(code = HttpServletResponse.SC_OK, message = "Retorna una lista de impresoras")
    })
    public ResponseEntity<RestTemplateResponse[]> get(){

        return restService.get();
    }
}
