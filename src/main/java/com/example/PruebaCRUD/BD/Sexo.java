package com.example.PruebaCRUD.BD;

import jakarta.persistence.*;

@Entity
@Table(name = "sexo")
public class Sexo {

    public Sexo() {}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idSexo")
    private Integer idSexo;

    @Column(name = "Nombre", nullable = false, unique = true, length = 9)
    private String nombre;


    public Sexo(int idSexo, String nombre) {
        this.idSexo = idSexo;
        this.nombre = nombre;
    }

    public Sexo(String nombre) {
        this.nombre = nombre;
    }

    // ############    GETTERS AND SETTERS    ############
    public Integer getIdSexo() {
        return idSexo;
    }

    public void setIdSexo(Integer idSexo) {
        this.idSexo = idSexo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
