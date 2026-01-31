package com.example.educonnect_platform.dto;

public class UserResponseDTO {

    private String userName;
    private String firebaseUid;

    public UserResponseDTO(String userName, String firebaseUid) {
        this.userName = userName;
        this.firebaseUid = firebaseUid;
    }

    public String getUserName() {
        return userName;
    }

    public String getFirebaseUid() {
        return firebaseUid;
    }
} //commen
