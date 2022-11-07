package casaquinta.fichaclinica.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import casaquinta.fichaclinica.backend.model.entity.Terapia;


public interface TerapiaRepository extends JpaRepository <Terapia, Long>{
    //Esta mal?
    @Query(value = "SELECT terapia.id_terapia, terapia.tipo_terapia FROM (SELECT id_terapia FROM usuario_terapia WHERE id_usuario = ?1) AS terapiaUsuario INNER  JOIN terapia ON terapiaUsuario.id_terapia = terapia.id_terapia",
    nativeQuery = true)
    List<Terapia> findTerapiasUsuario(Integer a);
}