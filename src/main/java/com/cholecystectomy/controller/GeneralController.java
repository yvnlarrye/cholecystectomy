package com.cholecystectomy.controller;

import com.cholecystectomy.domain.model.User;
import com.cholecystectomy.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class GeneralController {

    private final UserService userService;

    @GetMapping("/user-info")
    public ResponseEntity<User> getUserInfo() {
        return new ResponseEntity<>(userService.getCurrentUser(), new HttpHeaders(), HttpStatus.OK);
    }

}
