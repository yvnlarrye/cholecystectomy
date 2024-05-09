package com.cholecystectomy.service;

import com.cholecystectomy.domain.dto.auth.JwtAuthenticationResponse;
import com.cholecystectomy.domain.dto.auth.SignInRequest;
import com.cholecystectomy.domain.dto.auth.SignUpRequest;
import com.cholecystectomy.domain.model.Patient;
import com.cholecystectomy.exceptions.InvalidSignInDataException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserService userService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final PatientService patientService;

    /**
     * Регистрация пользователя
     *
     * @param request данные пользователя
     * @return токен
     */


    public JwtAuthenticationResponse signUp(SignUpRequest request) {
        Patient patient = new Patient();
        patient.setName(request.getName());
        patient.setEmail(request.getEmail());
        patient.setPassword(passwordEncoder.encode(request.getPassword()));
        patient.setSex(request.getSex());

        patientService.create(patient);
        var jwt = jwtService.generateToken(patient);
        return new JwtAuthenticationResponse(jwt);
    }

    /**
     * Аутентификация пользователя
     *
     * @param request данные пользователя
     * @return токен
     */
    public JwtAuthenticationResponse signIn(SignInRequest request) throws InvalidSignInDataException {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    request.getEmail(),
                    request.getPassword()
            ));
            var userDetails = userService
                    .userDetailsService()
                    .loadUserByUsername(request.getEmail());

            var jwt = jwtService.generateToken(userDetails);
            return new JwtAuthenticationResponse(jwt);
        } catch (Exception e) {
            throw new InvalidSignInDataException("Неверное имя пользователя или пароль");
        }
    }
}
