package com.example.educonnect_platform.services;

import com.example.educonnect_platform.dto.LoginRequestDTO;
import com.example.educonnect_platform.dto.UserResponseDTO;
import com.example.educonnect_platform.entity.User;
import com.example.educonnect_platform.repository.UserRepository;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FirebaseAuthService {

    private final FirebaseApp firebaseApp;
    private final UserRepository userRepository;

    public FirebaseAuthService(FirebaseApp firebaseApp,UserRepository userRepository){
        this.firebaseApp = firebaseApp;
        this.userRepository = userRepository;
    }

    public UserResponseDTO loginWithFirebase (LoginRequestDTO loginRequestDTO) throws FirebaseAuthException {

        String idToken = loginRequestDTO.getIdToken();

        FirebaseToken decodedToken = FirebaseAuth.getInstance(firebaseApp).verifyIdToken(idToken);
        String uid = decodedToken.getUid();
        String email =decodedToken.getEmail();

        Optional<User> optionalUser = userRepository.findByFireBaseUid(uid);
        User user;

        if(optionalUser.isPresent()){
            user = optionalUser.get();
        }
        else{
            user = new User();
            user.setFireBaseUid(uid);
            user.setEmail(email);
            user.setUserName("temp-" + uid.substring(0, 5)); // temporary username
            userRepository.save(user);
        }

        return new UserResponseDTO(user.getUserName(),user.getFireBaseUid());
    }
}
