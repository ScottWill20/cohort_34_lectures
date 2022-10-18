package heroes.security;

import heroes.data.AppUserJdbcTemplateRepository;
import heroes.models.AppUser;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class AppUserService implements UserDetailsService {

    private final AppUserJdbcTemplateRepository repository;

    public AppUserService (AppUserJdbcTemplateRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        AppUser user = repository.findByUsername(username);

        if (user == null || !user.isEnabled()) {
            throw new UsernameNotFoundException("username " + username + " not found.");
        }

        return user;
    }
}
