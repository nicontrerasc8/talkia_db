package com.upc.parte1_avance2.controllers;

import com.upc.parte1_avance2.dtos.PerfilDTO;
import com.upc.parte1_avance2.entities.Perfil;
import com.upc.parte1_avance2.services.PerfilService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PerfilController {
    @Autowired
    private PerfilService perfilService;

    ModelMapper modelMapper = new ModelMapper();
    @PostMapping("/perfil")
    public PerfilDTO createPerfil(@RequestBody PerfilDTO perfilDTO){
        Perfil perfil = modelMapper.map(perfilDTO, Perfil.class);
        perfil = perfilService.createPerfil(perfil);
        return modelMapper.map(perfil, PerfilDTO.class);
    }
    @GetMapping("/perfiles")
    public List<PerfilDTO> listPerfiles(){
        List<Perfil> list = perfilService.listPerfiles();
        List<PerfilDTO> listDTO = modelMapper.map(list, List.class);
        return listDTO;
    }
    @GetMapping("/perfil/identity/{id}")
    public PerfilDTO searchPerfil(@PathVariable Long id){
        Perfil perfil = perfilService.searchPerfil(id);
        return modelMapper.map(perfil, PerfilDTO.class);
    }

    @PutMapping("/perfil")
    public PerfilDTO updatePerfil(@RequestBody PerfilDTO perfilDTO){
        Perfil perfil = modelMapper.map(perfilDTO, Perfil.class);
        perfil = perfilService.updatePerfil(perfil);
        return modelMapper.map(perfil, PerfilDTO.class);
    }

}
