/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casaquinta.fichaclinica.backend.controller;

import casaquinta.fichaclinica.backend.model.entity.Anamnesis;
import casaquinta.fichaclinica.backend.service.AnamnesisService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author valentina
 */
// Se usan los lineamientos de API REST para dar respuesta a las consultas
@CrossOrigin("*")
@RestController
// Por donde empieza a escuchar el controlador
@RequestMapping(path="/api")
public class AnamnesisController {
    @Autowired
	AnamnesisService anamnesisService; // Referencia a la capa de servicio

	// Obtener todas las anamnesis
	@GetMapping("/anamnesis")
	public ResponseEntity<List<Anamnesis>> getAll(){
		List<Anamnesis> anamnesis = anamnesisService.getAllAnamnesis(); // Interactua con la capa de servicio

		if(anamnesis.isEmpty()) {
			// Da código HTTP de respuesta para cuando no hay contenido
			return ResponseEntity.noContent().build();
		}
		// Da código HTTP de respuesta exitosa y también devuelve las anamnesis
		return ResponseEntity.ok(anamnesis);
	}

	// Obtener según Id
	@GetMapping("/anamnesis/{id}")
	public ResponseEntity<Anamnesis> getAnamnesisById(@PathVariable("id") Long id){
		// @PathVariable permite configurar variables dentro de los segmentos URL
		Anamnesis anamnesis = anamnesisService.getAnamnesisById(id);

		if(anamnesis == null) {
			// Da código HTTP de respuesta para cuando no se ha encontrado
			return ResponseEntity.notFound().build();
		}
		// Retorna la anamnesis y una respuesta HTTP exitosa
		return ResponseEntity.ok(anamnesis);
	}

	// Guardar
	@PostMapping("/anamnesis")
	public ResponseEntity<Anamnesis> add(@RequestBody Anamnesis anamnesis){
		// @RequestBody son los datos que se envían en el cuerpo de la petición de HTPP POST

		Anamnesis nueva_anamnesis = anamnesisService.save(anamnesis);
		return ResponseEntity.ok(nueva_anamnesis);
	}

  // Actualizar
	@PutMapping("/anamnesis/{id}")
	public ResponseEntity<Anamnesis> updateFicha(@PathVariable("id") Long id, @RequestBody Anamnesis anamnesis) {
		//TODO: process PUT request
		Anamnesis anamnesis_modificada = anamnesisService.update(anamnesis);
		return ResponseEntity.ok(anamnesis_modificada);
	}

}
