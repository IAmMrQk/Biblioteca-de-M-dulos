package lm.ServicioModulos.web.controladores;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController // Esto es para definir la clase como que va a manejar solicitudes HTTP, estos
                // devolverán datos que se serializarán automáticamente en formato JSON
@RequestMapping("/Usuarios") // Define la URL base para todas las solicitudes manejadas por este controlador

public class UsuarioControlador {

}

