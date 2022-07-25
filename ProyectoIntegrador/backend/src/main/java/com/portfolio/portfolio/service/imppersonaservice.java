package com.portfolio.portfolio.service;

import com.portfolio.portfolio.entity.persona;
import com.portfolio.portfolio.interfase.ipersonaservice;
import com.portfolio.portfolio.repository.ipersonarepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class imppersonaservice implements ipersonaservice{
    @Autowired ipersonarepository ipersonarepository
    
    @Override
    public List<persona> getpersona() {
       List<persona> persona =  ipersonarepository.findAll();
       return persona;
    }

    @Override
    public void savepersona(persona persona) {
        ipersonarepository.save(persona);
    }

    @Override
    public void deletepersona(Long id) {
        ipersonarepository.delete(Id);
    }

    @Override
    public persona findpersona(Long id) {
        persona persona = ipersonarepository.findById(id) .orElse(null);
        return persona;
    }
    
}
