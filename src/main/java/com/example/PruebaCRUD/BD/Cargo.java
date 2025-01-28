package com.example.PruebaCRUD.BD;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "cargo")
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_cargo", nullable = false)
    private Integer id_cargo;

    @Column(name = "Cargo", nullable = false, length = 100)
    private String cargo;

    //    ================= RELACIONES INVERSAS CON OTRAS TABLAS ========================
    @OneToMany(mappedBy = "idCargoCD", cascade = CascadeType.PERSIST)
    private List<CargoDocente> CDDetails;

    public Cargo() {}

    public Cargo(Integer idCargo, String Cargo) {
        this.id_cargo = idCargo;
        this.cargo = Cargo;
    }

    public Cargo(String Cargo) {
        this.cargo = Cargo;
    }

    public Integer getIdCargo() {
        return id_cargo;
    }

    public void setIdCargo(Integer idCargo) {
        this.id_cargo = idCargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public List<CargoDocente> getCDDetails() {
        return CDDetails;
    }

    public void setCDDetails(List<CargoDocente> CDDetails) {
        this.CDDetails = CDDetails;
    }
}
