package com.example.expenserecord.controller;

import com.example.expenserecord.dto.auth.LoginDTO;
import com.example.expenserecord.dto.auth.SignupDTO;
import com.example.expenserecord.dto.auth.TokenDTO;
import com.example.expenserecord.model.Customer;
import com.example.expenserecord.security.TokenGenerator;
import com.example.expenserecord.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.server.resource.BearerTokenAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationProvider;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/api/v1/auth/")
public class AuthController {
    private final AuthService authService;
    private final JwtAuthenticationProvider jwtAuthenticationProvider;
    private final DaoAuthenticationProvider daoAuthenticationProvider;
    private final TokenGenerator tokenGenerator;

    public AuthController(AuthService authService,
                          JwtAuthenticationProvider jwtAuthenticationProvider,
                          DaoAuthenticationProvider daoAuthenticationProvider,
                          TokenGenerator tokenGenerator) {
        this.authService = authService;
        this.jwtAuthenticationProvider = jwtAuthenticationProvider;
        this.daoAuthenticationProvider = daoAuthenticationProvider;
        this.tokenGenerator = tokenGenerator;
    }

    @PostMapping("/register")
    public ResponseEntity<TokenDTO> register(@RequestBody SignupDTO signupDTO) {
        Customer customer = new Customer(signupDTO.getDefaultMoneyId(), signupDTO.getName(), signupDTO.getPassword());
        authService.createUser(customer);

        Authentication authentication = UsernamePasswordAuthenticationToken.authenticated(customer,
                signupDTO.getPassword(), Collections.emptyList());

        return ResponseEntity.ok(tokenGenerator.createToken(authentication));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDTO> login(@RequestBody LoginDTO loginDTO) {
        Authentication authentication = daoAuthenticationProvider.authenticate(UsernamePasswordAuthenticationToken.unauthenticated(loginDTO.getUsername(), loginDTO.getPassword()));

        return ResponseEntity.ok(tokenGenerator.createToken(authentication));
    }

    @PostMapping("/token")
    public ResponseEntity<TokenDTO> token(@RequestBody TokenDTO tokenDTO) {
        Authentication authentication = jwtAuthenticationProvider
                .authenticate(new BearerTokenAuthenticationToken(tokenDTO.getRefreshToken()));

        return ResponseEntity.ok(tokenGenerator.createToken(authentication));
    }
}
