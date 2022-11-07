package casaquinta.fichaclinica.backend.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import casaquinta.fichaclinica.backend.model.entity.FichaClinica;
import casaquinta.fichaclinica.backend.repository.FichaClinicaRepository;


@Service
public class FichaClinicaService {

	// Esta anotación indica al servicio que está conectado con el repositorio y está haciendo uso
	// de la base de datos y los objetos
	@Autowired
	FichaClinicaRepository ficha_clinicaRep;

	// Guarda una nueva ficha clínica en la base de datos
	public FichaClinica save(FichaClinica ficha_clinica) {
		FichaClinica nueva_ficha = ficha_clinicaRep.save(ficha_clinica);
		return nueva_ficha;
	}

	// Retorna todas las fichas clínicas
	public List<FichaClinica> getAllFichas(){
		return ficha_clinicaRep.findAll();
	}

	// Retorna una ficha clínica según su ID
	public FichaClinica getFichaById(Long id){
		return ficha_clinicaRep.findById(id).orElse(null);
	}

	// Comprobar si una ficha clinica existe
	public Boolean existeFicha(Long id){
		return ficha_clinicaRep.existsById(id);
	}

	// Actualizar datos de ficha clínica
	public FichaClinica update(FichaClinica ficha_clinica){
		FichaClinica ficha_modificada = ficha_clinicaRep.save(ficha_clinica);
		return ficha_modificada;
	}


	// buscar las fichas segun un nombre del usuario
	public List<FichaClinica> getFichaByName(String nombre){
		List<FichaClinica> fichas = ficha_clinicaRep.findAll();
		List<FichaClinica> matchs = new ArrayList<FichaClinica>();
		String [] listaNombre = nombre.toLowerCase().split(" ");
		for(int i =0; i < fichas.size();++i){
			for (String palabra : listaNombre) {
				if(fichas.get(i).getNombre().toLowerCase().contains(palabra)){
					matchs.add(fichas.get(i));
					break;
				}
			}
		}
		return matchs;
	}
	// // soft delete
}
