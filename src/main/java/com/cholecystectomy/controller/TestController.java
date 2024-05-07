package com.cholecystectomy.controller;

import com.cholecystectomy.domain.model.User;
import com.cholecystectomy.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/v1/test")
@RequiredArgsConstructor
public class TestController {

    private final UserService userService;

    @GetMapping("/test-endpoint")
    public ResponseEntity<String> getAllUsers() {
        return ResponseEntity.ok("Hello, this is secured zone");
    }
}
