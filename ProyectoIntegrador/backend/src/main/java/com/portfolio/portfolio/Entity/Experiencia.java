package com.portfolio.portfolio.Entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Experiencia{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreE;
    private String descripcionE;
    private int anoE;
    private String imgE;
    
    //constructores

    public Experiencia() {
    }

    public Experiencia(String nombreE, String descripcionE, int anoE, String imgE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.anoE = anoE;
        this.imgE = imgE;
    }
    //getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }

    public int getAnoE() {
        return anoE;
    }

    public void setAnoE(int anoE) {
        this.anoE = anoE;
    }
      public String getImgE() {
        return imgE;
    }

    public void setImgE(String imgE) {
        this.imgE = imgE;
    }
    
}
