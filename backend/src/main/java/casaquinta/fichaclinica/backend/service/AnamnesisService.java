package casaquinta.fichaclinica.backend.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import casaquinta.fichaclinica.backend.model.entity.Anamnesis;
import casaquinta.fichaclinica.backend.repository.AnamnesisRepository;


@Service
public class AnamnesisService {

	// Esta anotación indica al servicio que está conectado con el repositorio y está haciendo uso
	// de la base de datos y los objetos
	@Autowired
	AnamnesisRepository anamnesisRep;

	// Guarda una nueva anamnesis en la base de datos
	public Anamnesis save(Anamnesis anamnesis) {
		Anamnesis nueva_anamnesis = anamnesisRep.save(anamnesis);
		return nueva_anamnesis;
	}

	// Retorna todas las anamnesis
	public List<Anamnesis> getAllAnamnesis(){
		return anamnesisRep.findAll();
	}

	// Retorna una anamnesis según su ID
	public Anamnesis getAnamnesisById(Long id){
		return anamnesisRep.findById(id).orElse(null);
	}

  // ARREGLAR
  // Actualizar datos de anamnesis
	public Anamnesis update(Anamnesis anamnesis){
		Anamnesis anamnesis_modificada = anamnesisRep.save(anamnesis);
		return anamnesis_modificada;
	}

}
