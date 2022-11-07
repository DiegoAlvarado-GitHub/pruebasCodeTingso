package casaquinta.fichaclinica.backend.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import casaquinta.fichaclinica.backend.model.entity.Anamnesis;


public interface AnamnesisRepository extends JpaRepository <Anamnesis, Long>{

}
