
package com.portfolio.portfolio.repository;

import com.portfolio.portfolio.entity.persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ipersonarepository extends JpaRepository<persona,Long>{
    
}
