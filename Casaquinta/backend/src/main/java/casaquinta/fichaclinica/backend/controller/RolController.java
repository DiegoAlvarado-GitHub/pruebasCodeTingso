package casaquinta.fichaclinica.backend.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import casaquinta.fichaclinica.backend.model.entity.Rol;
import casaquinta.fichaclinica.backend.repository.RolRepository;
@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class RolController {
    
    @Autowired
    private final RolRepository rolRepository;

    RolController (RolRepository rol){
        this.rolRepository = rol;

    }

    //get alls rols
    @GetMapping("/rol")
    List<Rol> all() {
        return rolRepository.findAll();
    }

    //obtener un rol en especifico
    @GetMapping("/rol/{id}")
    Rol getRol(@PathVariable Long id) {
        return rolRepository.findById(id).orElseThrow();
    }
    //insertar un rol en la base de datos
    @PostMapping("/rol")
    Rol newSesion(@RequestBody Rol newRol) {
        return rolRepository.save(newRol);
    }
}
