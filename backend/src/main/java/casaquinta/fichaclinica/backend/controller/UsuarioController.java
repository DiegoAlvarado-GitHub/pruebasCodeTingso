package casaquinta.fichaclinica.backend.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import casaquinta.fichaclinica.backend.model.entity.Rol;
import casaquinta.fichaclinica.backend.model.entity.Usuario;
import casaquinta.fichaclinica.backend.repository.RolRepository;
import casaquinta.fichaclinica.backend.repository.UsuarioRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class UsuarioController {
    @Autowired 
    private SendEmail senderService;

    @Autowired
    private final UsuarioRepository usuarioRepository;

    @Autowired
    private final RolRepository rolRepository;

    UsuarioController (UsuarioRepository usuario, RolRepository rol,SendEmail senderService){
        this.usuarioRepository = usuario;
        this.rolRepository = rol;
        this.senderService = senderService;

    }

    @GetMapping("/usuario")
    List<Usuario> all() {
        return usuarioRepository.findAll();
    }

    @GetMapping("/usuario/{id}")
    Usuario getUsuario(@PathVariable Long id) {
        return usuarioRepository.findById(id).orElseThrow();
    }


    @PostMapping("/usuario/{id_rol}")
    Usuario postUsuario(@RequestBody Usuario user, @PathVariable Long id_rol) {
        String asunto = "Contraseña provisional para ingresar a Casaquinta";
        String contenido = "Nos alegra que te hayas unido al equipo de Casaquinta, como primer paso te invitamos a que entres a la intranet de Casaquinta y cambies tu contraseña.\nPara lo anterior te proporcionaremos una clave provisional que la puedes ver a continuación:\n\n";
        
        this.senderService.enviarEmail(user.getCorreo(), asunto, contenido+user.getId() );
        Rol rol = rolRepository.findById(id_rol).orElseThrow();
        user.setRol(rol);
        return usuarioRepository.save(user);
    }


    @PutMapping("/usuario/{id}")
    Usuario putUsuario(@RequestBody Usuario usuario, @PathVariable("id") long id) {
        Usuario user = usuarioRepository.findById(id).orElseThrow();
        user.setNombre(usuario.getNombre());
        user.setApellidos(usuario.getApellidos());
        user.setCorreo(usuario.getCorreo());
        user.getTerapias().addAll(usuario.getTerapias());
        user.setEspecialidad(usuario.getEspecialidad());
        return usuarioRepository.save(user);            
    }    


    @PutMapping("/usuario/password/{id}")
    Usuario putUsuarioPassword(@RequestBody Usuario usuario, @PathVariable("id") long id) {
        Usuario user = usuarioRepository.findById(id).orElseThrow();
        user.setPassword(usuario.getPassword());
        return usuarioRepository.save(user);            
    }    
}
