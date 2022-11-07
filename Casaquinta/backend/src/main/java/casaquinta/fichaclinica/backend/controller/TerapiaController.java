package casaquinta.fichaclinica.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import casaquinta.fichaclinica.backend.repository.SesionRepository;
import casaquinta.fichaclinica.backend.repository.TerapiaRepository;
import casaquinta.fichaclinica.backend.repository.UsuarioRepository;
import casaquinta.fichaclinica.backend.repository.FichaClinicaRepository;
import casaquinta.fichaclinica.backend.model.entity.Terapia;



@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class TerapiaController {
    
    // @Autowired
    // private final SesionRepository sesionRepository;
    // @Autowired
    // private final FichaClinicaRepository fichaClinicaRepository;
    // @Autowired
    // private final UsuarioRepository usuarioRepository;
    @Autowired
    private final TerapiaRepository terapiaRepository;

    TerapiaController (SesionRepository sesion, FichaClinicaRepository ficha, UsuarioRepository usuario, TerapiaRepository terapia){
        // this.sesionRepository = sesion;
        // this.fichaClinicaRepository = ficha;
        // this.usuarioRepository = usuario;
        this.terapiaRepository = terapia;
        
    }



    

    //Buscar una sesion
    @GetMapping("/terapia/{id}")
    Terapia  buscarTerapia(@PathVariable long id){
        return terapiaRepository.findById(id).orElseThrow();
    }

    //Leer todas las sesiones
    @GetMapping("/terapia")
    List<Terapia> all() {
        return terapiaRepository.findAll();
    }

    @GetMapping("/terapia/usuario/{id}")
    List<Terapia>  terapiasPorUsuario(@PathVariable Integer id){
        return terapiaRepository.findTerapiasUsuario(id);
    }

    @GetMapping("/terapia/faltantes/usuario/{id}")
    List<Terapia>  terapiasFaltantes(@PathVariable Integer id){
        //terapiaRepository.findAll().removeAll(terapiaRepository.findTerapiasUsuario(id));
        List<Terapia> salida = terapiaRepository.findAll();
        salida.removeAll(terapiaRepository.findTerapiasUsuario(id));
        return salida;
    }

    //  //Crear una sesion
    // @PostMapping("/sesion")
    // Sesion newSesion(@RequestBody Sesion newSesion) {
    //     Long id = 1L;
    //     FichaClinica ficha = fichaClinicaRepository.findById(id).orElseThrow();
    //     Usuario usuario = usuarioRepository.findById(220361020L).orElseThrow();
    //     Terapia terapia = terapiaRepository.findById(id).orElseThrow();
    //     newSesion.setFichaClinica(ficha);
    //     newSesion.setUsuario(usuario);
    //     newSesion.setTerapia(terapia);
    //     return sesionRepository.save(newSesion);
    // }


    // //Eliminar una sesion
    // @DeleteMapping("/sesion/{id}")
    // void deleteSesion(@PathVariable Long id) {
    //     sesionRepository.deleteById(id);
    // }

    //Actualizar una sesion --> esto no se debe aplicar
    

    
}
