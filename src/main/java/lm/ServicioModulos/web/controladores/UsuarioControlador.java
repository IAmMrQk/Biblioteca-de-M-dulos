package lm.ServicioModulos.web.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lm.ServicioModulos.modelos.entidad.Usuario;
import lm.ServicioModulos.servicios.UsuarioService;

@RestController
//Esto es una API
@RequestMapping("/Usuarios")

public class UsuarioControlador {
    
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/Lista_Usuarios")
    public List<Usuario> obtenerUsuarios() {

        var usuarios = usuarioService.listarUsuarios();
        return usuarios;
    }
}
