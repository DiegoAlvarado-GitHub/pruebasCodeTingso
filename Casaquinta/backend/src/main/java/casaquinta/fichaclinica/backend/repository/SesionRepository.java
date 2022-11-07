package casaquinta.fichaclinica.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import casaquinta.fichaclinica.backend.model.entity.Sesion;


public interface SesionRepository extends JpaRepository <Sesion, Long>{
    
    
    @Query(value = "SELECT * FROM sesion  WHERE id_ficha_clinica  = ?1",
    nativeQuery = true)
    List<Sesion> findSesionesFicha(Long idFicha);
}


