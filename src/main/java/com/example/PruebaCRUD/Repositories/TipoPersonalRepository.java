package com.example.PruebaCRUD.Repositories;

import com.example.PruebaCRUD.BD.TipoPersonal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfaz que funcionará como la capa de persistencia entre el sistema y la base de datos.
 * Extiende de JpaRepository (ayuda a gestionar los datos de una BD)
 */
@Repository
public interface TipoPersonalRepository extends JpaRepository<TipoPersonal, Integer> {
}
