package com.portfolio.portfolio.Service;

import com.portfolio.portfolio.Entity.Skills;
import com.portfolio.portfolio.Repository.RSkills;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class Sskills {
    @Autowired
    RSkills rSkills;
    
    public List<Skills> list(){
    return rSkills.findAll();
    }
    
    public Optional<Skills> getOne(int id){
    return rSkills.findById(id);
    }
    
    public Optional<Skills> getByNombreS(String nombreS){
    return rSkills.findByNombreS(nombreS);
    }
    
    public void save(Skills skills){
    rSkills.save(skills);
    }
    
    public void delete(int id){
    rSkills.deleteById(id);
    }
    
    public boolean existsById(int id){
    return rSkills.existsById(id);
    }
    
    public boolean existsByNombreS(String nombreS){
    return rSkills.existsByNombreS(nombreS);
    }
}

