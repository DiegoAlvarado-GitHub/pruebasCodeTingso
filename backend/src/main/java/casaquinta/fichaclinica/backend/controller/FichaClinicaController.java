package casaquinta.fichaclinica.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import casaquinta.fichaclinica.backend.model.entity.FichaClinica;
import casaquinta.fichaclinica.backend.service.FichaClinicaService;

// Se usan los lineamientos de API REST para dar respuesta a las consultas
@CrossOrigin("*")
@RestController
// Por donde empieza a escuchar el controlador
@RequestMapping(path="/api")
public class FichaClinicaController {

	@Autowired
	FichaClinicaService ficha_clinicaService; // Referencia a la capa de servicio

	// Obtener todas las fichas clínicas
	@GetMapping("/ficha_clinica")
	public ResponseEntity<List<FichaClinica>> getAll(){
		List<FichaClinica> fichas_clinicas = ficha_clinicaService.getAllFichas(); // Interactua con la capa de servicio

		if(fichas_clinicas.isEmpty()) {
			// Da código HTTP de respuesta para cuando no hay contenido
			return ResponseEntity.noContent().build();
		}
		// Da código HTTP de respuesta exitosa y también devuelve las fichas clínicas
		return ResponseEntity.ok(fichas_clinicas);
	}

	// Obtener según Id
	@GetMapping("/ficha_clinica/{id}")
	public ResponseEntity<FichaClinica> getFichaById(@PathVariable("id") Long id){
		// @PathVariable permite configurar variables dentro de los segmentos URL
		FichaClinica ficha_clinica = ficha_clinicaService.getFichaById(id);

		if(ficha_clinica == null) {
			// Da código HTTP de respuesta para cuando no se ha encontrado
			return ResponseEntity.notFound().build();
		}
		// Retorna la ficha clínica y una respuesta HTTP exitosa
		return ResponseEntity.ok(ficha_clinica);
	}

	//Indicar si existe o no una ficha clinica
	@GetMapping("/ficha_clinica/existe/{id}")
	public Boolean getFichaById2(@PathVariable("id") Long id){
		return ficha_clinicaService.existeFicha(id);
	}





	// Obtener una ficha clinica segun un nombre aproximado
	@GetMapping("/ficha_clinica/name={name}")
	public List<FichaClinica> getFichaByName(@PathVariable("name") String name){
		// @PathVariable permite configurar variables dentro de los segmentos URL
		List<FichaClinica> ficha_clinica = ficha_clinicaService.getFichaByName(name);

		// Retorna la ficha clínica y una respuesta HTTP exitosa
		return ficha_clinica;
	}

	// Guardar
	@PostMapping("/ficha_clinica")
	public ResponseEntity<FichaClinica> add(@RequestBody FichaClinica ficha_clinica){
		// @RequestBody son los datos que se envían en el cuerpo de la petición de HTPP POST

		FichaClinica nueva_ficha = ficha_clinicaService.save(ficha_clinica);
		return ResponseEntity.ok(nueva_ficha);
	}

	// Actualizar
	@PutMapping("/ficha_clinica/{id}")
	public ResponseEntity<FichaClinica> updateFicha(@PathVariable("id") Long id, @RequestBody FichaClinica ficha_clinica) {
		//TODO: process PUT request
		FichaClinica ficha_modificada = ficha_clinicaService.update(ficha_clinica);
		return ResponseEntity.ok(ficha_modificada);
	}

	// Eliminar
	//@DeleteMapping("/ficha_clinica")

}
