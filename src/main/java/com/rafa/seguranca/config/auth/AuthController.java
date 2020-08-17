package com.rafa.seguranca.config.auth;

import com.rafa.seguranca.config.auth.token.TokenDTO;
import com.rafa.seguranca.config.auth.token.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<?> authenticate(@RequestBody UserAuthDTO userAuthDTO) {
        UsernamePasswordAuthenticationToken user = userAuthDTO.convert();
        try {
            Authentication authentication = authenticationManager.authenticate(user);
            String token = tokenService.generate(authentication);
            return new ResponseEntity<>(new TokenDTO(token, "Bearer"), HttpStatus.OK);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return new ResponseEntity<>("It was not possible to authenticate a user", HttpStatus.BAD_REQUEST);
        }
    }
}
