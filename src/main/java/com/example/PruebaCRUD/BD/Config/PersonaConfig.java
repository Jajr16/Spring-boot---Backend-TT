package com.example.PruebaCRUD.BD.Config;

import com.example.PruebaCRUD.BD.Persona;
import com.example.PruebaCRUD.Repositories.PersonaRepository;
import com.example.PruebaCRUD.Repositories.SexoRepository;
import com.example.PruebaCRUD.Repositories.UnidadAcademicaRepository;
import com.example.PruebaCRUD.BD.Sexo;
import com.example.PruebaCRUD.BD.UnidadAcademica;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.List;

@Configuration
public class PersonaConfig {
    @Bean
    @Order(5)
    CommandLineRunner initDataPersona(PersonaRepository personaRepository,
                                      SexoRepository sexoRepository,
                                      UnidadAcademicaRepository unidadAcademicaRepository) {
        return args -> {

            if (personaRepository.count() == 0) {
//                Obtener ambos sexos
                List<Sexo> sexos = sexoRepository.findAll();
                Sexo masculino = sexos.stream().filter(s -> s.getNombre().equalsIgnoreCase("Masculino")).findFirst().orElseGet(() ->
                        sexoRepository.save(new Sexo("Masculino"))
                );
                Sexo femenino = sexos.stream().filter(s -> s.getNombre().equalsIgnoreCase("Femenino")).findFirst().orElseGet(() ->
                        sexoRepository.save(new Sexo("Femenino"))
                );

                UnidadAcademica ESCOM = unidadAcademicaRepository.findByNombre("ESCOM").orElseGet(() ->
                    unidadAcademicaRepository.save(new UnidadAcademica("ESCOM"))
                );

                UnidadAcademica ESCA = unidadAcademicaRepository.findByNombre("ESCA").orElseGet(() ->
                        unidadAcademicaRepository.save(new UnidadAcademica(("ESCA")))
                );

                personaRepository.save(new Persona("1", "José Alfredo", "Jiménez", "Rodríguez", masculino, ESCOM));
                personaRepository.save(new Persona("2", "Alejandra", "De la cruz", "De la cruz", femenino, ESCOM));
                personaRepository.save(new Persona("3", "Luis Antonio", "Flores", "Esquivel", masculino, ESCOM));
                personaRepository.save(new Persona("4", "Daniel Martin", "Huertas", "Ramírez", masculino, ESCOM));
                personaRepository.save(new Persona("5", "Luis Fernando", "Valle", "Hernández", masculino, ESCOM));
                personaRepository.save(new Persona("6", "Román Esteban", "Leyva", "Martínez", masculino, ESCOM));
                personaRepository.save(new Persona("7", "Esteban", "Ramírez", "Gutierrez", masculino, ESCOM));
                personaRepository.save(new Persona("8", "Flor", "Hernández", "Gutierrez", femenino, ESCOM));
                personaRepository.save(new Persona("9", "Carlos", "Rivera", "Martínez", femenino, ESCOM));
                personaRepository.save(new Persona("10", "Ulises", "Velez", "Saldaña", masculino, ESCOM));
                personaRepository.save(new Persona("11", "Saúl", "De la O", "Torres", masculino, ESCOM));
                personaRepository.save(new Persona("12", "Chadwick", "Carreto", "Arrellano", masculino, ESCOM));
                personaRepository.save(new Persona("13", "Andrés", "García", "Floriano", masculino, ESCOM));
            }
        };
    }
}
