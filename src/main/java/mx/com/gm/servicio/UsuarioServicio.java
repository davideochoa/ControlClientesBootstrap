package mx.com.gm.servicio;

import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import mx.com.gm.DAO.UsuarioDAO;
import mx.com.gm.domain.Rol;
import mx.com.gm.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/* @author David E. Ochoa D. <davideochoa@gmail.com> */

@Service("userDetailsService")
@Slf4j
public class UsuarioServicio implements UserDetailsService{

    @Autowired
    private UsuarioDAO usuarioDAO;
    
    @Override
    @Transactional(readOnly=true )
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioDAO.findByUsername(username);
        
        if(usuario == null){
            throw new UsernameNotFoundException(username);
        }
        
        var roles = new ArrayList<GrantedAuthority>();
        
        for(Rol rol: usuario.getRoles()){
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
        }
        
        return new User(usuario.getUsername(), usuario.getPassword(), roles);
        
    }
    
}
