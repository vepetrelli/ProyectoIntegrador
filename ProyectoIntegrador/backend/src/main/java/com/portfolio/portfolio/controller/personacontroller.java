package com.portfolio.portfolio.controller;

import com.portfolio.portfolio.entity.persona;
import com.portfolio.portfolio.interfase.ipersonaservice;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class personacontroller {
    @Autowired ipersonaservice ipersonaservice;

    @GetMapping("persona/traer")
    public List<persona> getpersona(){
        return ipersonaservice.getpersona();
}
    @PostMapping("/persona/crear")
    public String createpersona(@RequestBody){
    ipersonaservice.savepersona(persona);
    return "la persona fue creada correctamente";
            }

    @DeleteMapping("/persona/borrar/{id}")
    public String deletepersona(@PathVariable Long id){
    ipersonaservice.deletepersona(id);
    return "la persona fue eliminada correctamente";
    }
    //URL:puerto/editar/id/4/nombre & apellido & img
    @PutMapping("/persona/editar/{id}")
    public persona editpersona(@PathVariable Long id,
                                @RequestParam("nombre") String nuevonombre,
                                @RequestParam("apellido") String nuevoapellido,
                                @RequestParam("img") String nuevoimg){
    persona persona= ipersonaservice.findpersona(id);
    persona.setNombre(nuevonombre);
    persona.setApellido(nuevoapellido);
    persona.setImg(nuevoimg);
    
    ipersonaservice.savepersona(persona);
    return persona;
    }
}