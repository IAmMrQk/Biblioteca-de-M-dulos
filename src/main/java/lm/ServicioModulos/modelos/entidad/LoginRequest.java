package lm.ServicioModulos.modelos.entidad;

import lombok.Data;

@Data
public class LoginRequest {
    private String nombreUsuario;
    private String contraseña;
}