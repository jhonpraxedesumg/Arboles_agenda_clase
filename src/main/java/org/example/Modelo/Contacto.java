package org.example.Modelo;

import java.time.LocalDate;

public class Contacto {
    private String nombre;
    private Long telefono;
    private String correoElectronico;
    private LocalDate fechaNacimiento;



    public Contacto(String nombre, Long telefono, String correoElectronico, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correoElectronico=correoElectronico;
        this.fechaNacimiento=fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public Long getTelefono() {
        return telefono;

    }

    public String getCorreoElectronico(){
        return correoElectronico;
    }
    public LocalDate getFechaNacimiento(){
        return fechaNacimiento;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    //hacer el set para nombre
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setCorreoElectronico(String correoElectronico){
        this.correoElectronico=correoElectronico;
    }
    public void setFechaNacimiento(LocalDate fechaNacimiento){
        this.fechaNacimiento=fechaNacimiento;
    }
}
