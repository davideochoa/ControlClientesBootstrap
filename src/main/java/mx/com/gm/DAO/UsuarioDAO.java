package mx.com.gm.DAO;

import mx.com.gm.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Usuario
 */
public interface UsuarioDAO extends JpaRepository<Usuario, Long>{
    Usuario findByUsername(String username);
}
