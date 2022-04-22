package com.iconos.iconos.service.impl;

import com.iconos.iconos.dto.ContinenteDTO;
import com.iconos.iconos.service.ContinenteService;
import org.springframework.stereotype.Service;

@Service
public class ContinenteServiceImpl implements ContinenteService {

    public ContinenteDTO save(ContinenteDTO dto){
        //TODO: guardar
        System.out.println("GUARDAR CONTINENTE");
        return dto;
    }
}
