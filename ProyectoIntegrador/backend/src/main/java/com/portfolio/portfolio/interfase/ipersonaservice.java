package com.portfolio.portfolio.interfase;

import com.portfolio.portfolio.entity.persona;
import java.util.List;


public interface ipersonaservice {
    //trae una lista de personas
    public List<persona> getpersona();
    //guardar un objeto de tipo persona
    public void savepersona(persona persona);
    //eliminar un objeto pero lo buscamos por Id
    public void deletepersona(Long id);
    //buscar una persona por Id
    public persona findpersona(Long id);
}
