package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.DAO.IPersonaDAO;
import mx.com.gm.domain.Persona;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/* @author David E. Ochoa Diaz <davideochoa@gmail.com> */
@Service
public class PersonaServiceImpl implements IPersonaService{

    @Autowired
    IPersonaDAO iPersonaDAO;
    
    @Override
    @Transactional(readOnly = true)
    public List<Persona> listarPErsonas() {
        return (List<Persona>) iPersonaDAO.findAll();
    }

    @Override
    @Transactional
    public void guardar(Persona persona) {
        iPersonaDAO.save(persona);
    }

    @Override
    @Transactional
    public void eliminar(Persona persona) {
    	
        iPersonaDAO.delete(persona);
    }

    @Override
    @Transactional(readOnly = true)
    public Persona encontrarPersona(Persona persona) {
        return iPersonaDAO.findById(persona.getIdPersona()).orElse(null);        
    }

}
