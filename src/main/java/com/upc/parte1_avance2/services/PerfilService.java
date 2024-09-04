package com.upc.parte1_avance2.services;

import com.upc.parte1_avance2.entities.Perfil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PerfilService {
    public Perfil createPerfil(Perfil perfil);
    public Perfil updatePerfil(Perfil perfil);
    public List<Perfil> listPerfiles();
    public Perfil searchPerfil(Long perfilID);
}
