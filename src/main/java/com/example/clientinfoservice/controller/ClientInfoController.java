package com.example.clientinfoservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/client")
public class ClientInfoController {

    @GetMapping("/info")
    public ResponseEntity<Object> getClientInfo(@RequestParam String tipoDocumento, @RequestParam String numeroDocumento) {
        // Validar tipo de documento
        if (!tipoDocumento.equals("C") && !tipoDocumento.equals("P")) {
            return new ResponseEntity<>("Tipo de documento no válido", HttpStatus.BAD_REQUEST);
        }

        // Mockear datos del cliente
        if (tipoDocumento.equals("C") && numeroDocumento.equals("23445322")) {
            Map<String, String> clientData = new HashMap<>();
            clientData.put("primerNombre", "Kener");
            clientData.put("segundoNombre", "Joahn");
            clientData.put("primerApellido", "Alvarado");
            clientData.put("segundoApellido", "Sanchez");
            clientData.put("telefono", "3188361500");
            clientData.put("direccion", "Carrera 19 A # 21-11");
            clientData.put("ciudad", "Bogotá");
            return new ResponseEntity<>(clientData, HttpStatus.OK);
        }else if (tipoDocumento.equals("C") && numeroDocumento.equals("1007819695")) {
            Map<String, String> clientData = new HashMap<>();
            clientData.put("primerNombre", "Anderson");
            clientData.put("segundoNombre", "Yesid");
            clientData.put("primerApellido", "Alvarado");
            clientData.put("segundoApellido", "Sanchez");
            clientData.put("telefono", "3188361500");
            clientData.put("direccion", "Carrera 19 A # 21-11");
            clientData.put("ciudad", "Bogotá");
            return new ResponseEntity<>(clientData, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Cliente no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return new ResponseEntity<>("Error interno del servidor", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
