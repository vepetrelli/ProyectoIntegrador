package com.portfolio.portfolio.Dto;

import javax.validation.constraints.NotBlank;


public class dtoExperiencia {
@NotBlank
private String nombreE;
@NotBlank
    private String descripcionE;
@NotBlank
private int anoE;

//constructores 

    public dtoExperiencia() {
    }

    public dtoExperiencia(String nombreE, String descripcionE, int anoE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.anoE = anoE;
    }
//getters and setters

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
    
}
