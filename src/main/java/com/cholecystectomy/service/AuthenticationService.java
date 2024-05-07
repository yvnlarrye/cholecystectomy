package com.cholecystectomy.service;

import com.cholecystectomy.domain.dto.auth.JwtAuthenticationResponse;
import com.cholecystectomy.domain.dto.auth.SignInRequest;
import com.cholecystectomy.domain.dto.auth.SignUpRequest;
import com.cholecystectomy.domain.model.Patient;
import com.cholecystectomy.domain.model.Role;
import com.cholecystectomy.domain.model.User;
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

        var user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.ROLE_PATIENT)
                .build();

        User savedUser = userService.create(user);
        var patient = Patient.builder()
                .userDetails(savedUser)
                .sex(request.getSex())
                .build();
        patientService.create(patient);

        var jwt = jwtService.generateToken(user);
        return new JwtAuthenticationResponse(jwt, user.getUsername(), user.getName());
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
            var user = userService
                    .userDetailsService()
                    .loadUserByUsername(request.getEmail());

            var jwt = jwtService.generateToken(user);
            return new JwtAuthenticationResponse(jwt, user.getUsername(), ((User) user).getName());
        } catch (Exception e) {
            throw new InvalidSignInDataException("Неверное имя пользователя или пароль");
        }
    }
}
