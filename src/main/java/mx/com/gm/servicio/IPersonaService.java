package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.domain.Persona;

/* @author David E. Ochoa Diaz <davideochoa@gmail.com> */
public interface IPersonaService {
    public List<Persona> listarPErsonas();
    
    public void guardar(Persona persona);
    
    public void eliminar(Persona persona);
    
    public Persona encontrarPersona(Persona persona);
}
