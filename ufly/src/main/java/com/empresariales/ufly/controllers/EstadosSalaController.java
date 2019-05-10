package com.empresariales.ufly.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@CrossOrigin
@RestController
@RequestMapping("/rest/estadossala")
@Api(description = "Operaciones de los estados de la sala")
public class EstadosSalaController {

}
