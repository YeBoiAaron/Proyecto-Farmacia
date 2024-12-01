
import com.daos.interfaces.IEmpleadoDAO;
import com.dtos.EmpleadoDTO;
import com.persistencias.EmpleadoPersistencia;
import com.persistencias.UsuarioPersistencia;
import java.time.LocalDate;
import javax.persistence.EntityManager;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author martinez
 */
public class Test {
    public static void main(String[] args) {
     
        UsuarioPersistencia up = new UsuarioPersistencia();
        EmpleadoDTO edto = new EmpleadoDTO();
        
        // Asignar valores a los atributos heredados de UsuarioDTO
        edto.setNombreUsuario("maria.lopez");
        edto.setCorreo("maria.lopez@example.com");
        edto.setContrasena("567890");
        
        // Asignar valores a los atributos específicos de EmpleadoDTO
        edto.setNombreCompleto("María López");
        edto.setNumeroTelefono("555-9876");
        edto.setFechaNacimiento(LocalDate.of(1985, 12, 22));
        edto.setTipoEmpleado("Gerente");
        
        up.agregarUsuarioEmpleado(edto);
    }
}
