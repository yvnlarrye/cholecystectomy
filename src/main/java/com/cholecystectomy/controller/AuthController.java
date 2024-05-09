package com.cholecystectomy.controller;

import com.cholecystectomy.domain.dto.auth.JwtAuthenticationResponse;
import com.cholecystectomy.domain.dto.auth.SignInRequest;
import com.cholecystectomy.domain.dto.auth.SignUpRequest;
import com.cholecystectomy.exceptions.InvalidSignInDataException;
import com.cholecystectomy.service.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Tag(name = "Аутентификация")
public class AuthController {
    private final AuthenticationService authenticationService;

    @Operation(summary = "Регистрация пользователя")
    @PostMapping("/sign-up")
    public ResponseEntity<JwtAuthenticationResponse> signUp(@RequestBody @Valid SignUpRequest request) {
        return new ResponseEntity<>(authenticationService.signUp(request), HttpStatus.CREATED);
    }

    @Operation(summary = "Авторизация пользователя")
    @PostMapping("/sign-in")
    public ResponseEntity<JwtAuthenticationResponse> signIn(@RequestBody @Valid SignInRequest request) throws InvalidSignInDataException {
        return ResponseEntity.ok(authenticationService.signIn(request));
    }
}