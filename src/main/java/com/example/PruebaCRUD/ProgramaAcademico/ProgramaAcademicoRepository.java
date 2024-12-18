package com.example.PruebaCRUD.ProgramaAcademico;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProgramaAcademicoRepository extends JpaRepository<ProgramaAcademico, String> {
    Optional<ProgramaAcademico> findByNombre(String Nombre);
}
