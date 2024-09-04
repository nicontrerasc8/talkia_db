package com.upc.parte1_avance2.servicesImpl;

import com.upc.parte1_avance2.entities.Perfil;
import com.upc.parte1_avance2.repositories.PerfilRepository;
import com.upc.parte1_avance2.services.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class PerfilServiceImpl implements PerfilService {
    @Autowired
    private PerfilRepository perfilRepository;
    @Override
    public Perfil searchPerfil(Long perfilID) {
        return perfilRepository.findById(perfilID).get();
    }

    @Override
    public List<Perfil> listPerfiles() {
        return perfilRepository.findAll();
    }

    @Override
    @Transactional
    public Perfil updatePerfil(Perfil perfil) {
        if(perfilRepository.existsById(perfil.getId())) {
            return perfilRepository.save(perfil);
        }
        return null;
    }

    @Override
    @Transactional
    public Perfil createPerfil(@RequestBody Perfil perfil) {
        return perfilRepository.save(perfil);
    }
}
