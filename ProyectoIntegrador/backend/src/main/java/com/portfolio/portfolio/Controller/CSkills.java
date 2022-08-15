package com.portfolio.portfolio.Controller;

import com.portfolio.portfolio.Dto.dtoSkills;
import com.portfolio.portfolio.Entity.Skills;
import com.portfolio.portfolio.Security.Controller.Mensaje;
import com.portfolio.portfolio.Service.Sskills;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/skills")
@CrossOrigin(origins = "http://localhost:4200")
public class CSkills {
    @Autowired
    Sskills sSkills;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Skills>> list(){
    List<Skills> list = sSkills.list();
    return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Skills> getById(@PathVariable ("id") int id){
    if(!sSkills.existsById(id)){
        return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
    }
    Skills skills = sSkills.getOne(id).get();
    return new ResponseEntity(skills, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
    if(!sSkills.existsById(id)){
    return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
    } sSkills.delete(id);
    return new ResponseEntity(new Mensaje("Skill eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoSkills dtoskills){
    if(StringUtils.isBlank(dtoskills.getNombreS())){
    return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
    }
    if(sSkills.existsByNombreS(dtoskills.getNombreS())){
    return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
    }
    Skills skills = new Skills(
            dtoskills.getNombreS(),dtoskills.getPorcentajeS(), dtoskills.getImgS()
    );
    sSkills.save(skills);
    return new ResponseEntity(new Mensaje("Skill creada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable ("id") int id, @RequestBody dtoSkills dtoskills){
    if(!sSkills.existsById(id)){
    return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
    }
    if(sSkills.existsByNombreS(dtoskills.getNombreS()) && sSkills.getByNombreS(dtoskills.getNombreS()).get().getId() !=id){
    return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
    }
    if (StringUtils.isBlank(dtoskills.getNombreS())){
    return new ResponseEntity(new Mensaje("El campo no puede estar vacío"), HttpStatus.BAD_REQUEST);
    }
    
    Skills skills = sSkills.getOne(id).get();
    skills.setNombreS(dtoskills.getNombreS());
    skills.setPorcentajeS(dtoskills.getPorcentajeS());
    skills.setImgS(dtoskills.getImgS());
    
    sSkills.save(skills);
    return new ResponseEntity(new Mensaje("Skill actualizada"), HttpStatus.OK);
    }
}

