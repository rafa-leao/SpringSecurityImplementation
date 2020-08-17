package com.rafa.seguranca.config.auth;

import com.rafa.seguranca.user.User;
import com.rafa.seguranca.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String nome) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByNome(nome);
        if(user.isPresent()) {
            return user.get();
        }
        throw new UsernameNotFoundException("User doesn't exist");
    }
}
