package com.example.PruebaCRUD.Repositories;

import com.example.PruebaCRUD.BD.ETS;
import com.example.PruebaCRUD.DTO.ETSDTO;
import com.example.PruebaCRUD.DTO.Saes.ETSDTOSaes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz que funcionará como la capa de persistencia entre el sistema y la base de datos.
 * Extiende de JpaRepository (ayuda a gestionar los datos de una BD)
 */
@Repository
public interface ETSRepository extends JpaRepository<ETS, Integer> {

    /**
     * En lugar de hacer la notación de findBy que nos proporciona JPA, se realiza una consulta más detallada y
     * personalizable con las clases del proyecto
     */
    @Query("""
            SELECT new com.example.PruebaCRUD.DTO.ETSDTO(
              ets.id_ETS,
              uapren.nombre,
              etsp.tipo,
              etsp.periodo,
              turno.nombre,
              CAST(ets.Fecha AS string),
              ets.Cupo,
              ets.Duracion
          )
          FROM ETS ets
          INNER JOIN UnidadAprendizaje as uapren ON uapren.idUA = ets.idUA.idUA
          INNER JOIN periodoETS as etsp ON etsp.idPeriodo = ets.idPeriodo.idPeriodo
          INNER JOIN Turno as turno ON turno.idTurno = ets.Turno.idTurno
          WHERE ets.id_ETS = :idets
            """)
    Optional<ETSDTO> findById_ETS(Integer idets);

    @Query("""
            SELECT new com.example.PruebaCRUD.DTO.Saes.ETSDTOSaes(
              ets.id_ETS,
              uapren.idUA,
              uapren.nombre,
              etsp.tipo,
              etsp.periodo,
              turno.nombre,
              CAST(ets.Fecha AS string),
              ets.Cupo,
              ets.Duracion,
              pa.nombre
          )
          FROM ETS ets
          INNER JOIN UnidadAprendizaje as uapren ON uapren.idUA = ets.idUA.idUA
          INNER JOIN ProgramaAcademico as pa ON pa.idPA = uapren.idPA.idPA
          INNER JOIN periodoETS as etsp ON etsp.idPeriodo = ets.idPeriodo.idPeriodo
          INNER JOIN Turno as turno ON turno.idTurno = ets.Turno.idTurno
            """)
    List<ETSDTOSaes> findETS();
}
