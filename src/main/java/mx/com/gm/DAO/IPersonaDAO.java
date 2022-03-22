package mx.com.gm.DAO;

import mx.com.gm.domain.Persona;
import org.springframework.data.repository.CrudRepository;

/* @author David E. Ochoa Diaz <davideochoa@gmail.com> */
public interface IPersonaDAO extends CrudRepository<Persona, Long>{

}
