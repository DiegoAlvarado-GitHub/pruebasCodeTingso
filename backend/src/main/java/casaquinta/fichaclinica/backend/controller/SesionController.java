package casaquinta.fichaclinica.backend.controller;

import java.io.FileNotFoundException;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.DocumentException;

import casaquinta.fichaclinica.backend.repository.SesionRepository;
import casaquinta.fichaclinica.backend.repository.TerapiaRepository;
import casaquinta.fichaclinica.backend.repository.UsuarioRepository;
import casaquinta.fichaclinica.backend.repository.FichaClinicaRepository;
import casaquinta.fichaclinica.backend.model.entity.FichaClinica;
import casaquinta.fichaclinica.backend.model.entity.Sesion;
import casaquinta.fichaclinica.backend.model.entity.Terapia;
import casaquinta.fichaclinica.backend.model.entity.Usuario;
import casaquinta.fichaclinica.backend.service.ITextPdfService;



@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class SesionController {
    
    @Autowired
    private final SesionRepository sesionRepository;
    @Autowired
    private final FichaClinicaRepository fichaClinicaRepository;
    @Autowired
    private final UsuarioRepository usuarioRepository;
    @Autowired
    private final TerapiaRepository terapiaRepository;

    @Autowired
    private final ITextPdfService pdfService;

    SesionController (SesionRepository sesion, FichaClinicaRepository ficha, UsuarioRepository usuario, TerapiaRepository terapia, ITextPdfService pdfService){
        this.sesionRepository = sesion;
        this.fichaClinicaRepository = ficha;
        this.usuarioRepository = usuario;
        this.terapiaRepository = terapia;
        this.pdfService = pdfService;
        
    }



    //Leer todas las sesiones
    @GetMapping("/sesion")
    List<Sesion> all() {
        return sesionRepository.findAll();
    }

    //Buscar una sesion
    @GetMapping("/sesion/{id}")
    Sesion  buscarSesion(@PathVariable long id){
        return sesionRepository.findById(id).orElseThrow();
    }

    //Obtener sesiones de una ficha clinica
    @GetMapping("/sesion/ficha/{idFicha}")
    List<Sesion>  buscarSesionesDeFicha(@PathVariable long idFicha){
        return sesionRepository.findSesionesFicha(idFicha);
    }

     //Crear una sesion
    @PostMapping("/sesion/{idTerapia}/{idFicha}")
    Sesion newSesion(@RequestBody Sesion newSesion,@PathVariable long idTerapia,@PathVariable long idFicha) {
        FichaClinica ficha = fichaClinicaRepository.findById(idFicha).orElseThrow();
        Usuario usuario = usuarioRepository.findById(220361020L).orElseThrow();
        Terapia terapia = terapiaRepository.findById(idTerapia).orElseThrow();
        if(!ficha.getTerapias().contains(terapia)){
            ficha.getTerapias().add(terapia);
            ficha.setTerapias_recibidas(ficha.getTerapias_recibidas() +'/' + terapia.getTipo_terapia());
            fichaClinicaRepository.save(ficha);
        }   
        newSesion.setFichaClinica(ficha);
        newSesion.setUsuario(usuario);
        newSesion.setTerapia(terapia);
        return sesionRepository.save(newSesion);
    }


    //Eliminar una sesion
    @DeleteMapping("/sesion/{id}")
    void deleteSesion(@PathVariable Long id) {
        sesionRepository.deleteById(id);
    }

    //Crear PDf de una sesion
    //TODO: enviar la sesion desde el front ya que ya se rescata desde ahi;
    @GetMapping("/sesion/pdf/{id}")
    void pdfSesion(@PathVariable Long id) throws FileNotFoundException, DocumentException{
        Sesion sesion = sesionRepository.findById(id).orElseThrow();

        try {
            this.pdfService.createPdfSesion(sesion,sesion.obtnerFichaClinica().getCorreo());
        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    //Actualizar una sesion --> esto no se debe aplicar
    

    
}
