package casaquinta.fichaclinica.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import casaquinta.fichaclinica.backend.model.entity.Usuario;


public interface UsuarioRepository extends JpaRepository <Usuario, Long>{

}
