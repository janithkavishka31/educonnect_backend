package com.example.educonnect_platform.controllers;


import com.example.educonnect_platform.dto.LoginRequestDTO;
import com.example.educonnect_platform.dto.UserResponseDTO;
import com.example.educonnect_platform.services.FirebaseAuthService;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class FirebaseAuthController {

    private final FirebaseAuthService firebaseAuthService;

    public FirebaseAuthController(FirebaseAuthService firebaseAuthService){
        this.firebaseAuthService = firebaseAuthService;
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> login (@RequestBody LoginRequestDTO request) throws FirebaseAuthException {

        UserResponseDTO response = firebaseAuthService.loginWithFirebase(request);
        return ResponseEntity.ok(response);

    }

}
