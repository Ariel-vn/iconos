package com.iconos.iconos.controller;

import com.iconos.iconos.dto.ContinenteDTO;
import com.iconos.iconos.service.ContinenteService;
import com.iconos.iconos.service.impl.ContinenteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("continentes")
public class ContinenteController {

    @Autowired
    private ContinenteService continenteService;

    @PostMapping
    //ResponseEntity es un objeto que nos ayuda con las response
    public ResponseEntity<ContinenteDTO> save(@RequestBody ContinenteDTO continente){
        ContinenteDTO continenteGuardado= continenteService.save(continente);

        //Devolvemos el código 201 de creado y devolvemos un body que va a contener el continente guardado
        return ResponseEntity.status(HttpStatus.CREATED).body(continenteGuardado);
    }

}
