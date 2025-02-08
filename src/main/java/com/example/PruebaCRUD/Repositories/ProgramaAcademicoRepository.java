package com.example.PruebaCRUD.Repositories;

import com.example.PruebaCRUD.BD.ProgramaAcademico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Interfaz que funcionará como la capa de persistencia entre el sistema y la base de datos.
 * Extiende de JpaRepository (ayuda a gestionar los datos de una BD)
 */
@Repository
public interface ProgramaAcademicoRepository extends JpaRepository<ProgramaAcademico, String> {
    // Notación findBy(Columna con primera mayúscula) proporcionada por JPA
    Optional<ProgramaAcademico> findByIdPA(String Nombre);
}
