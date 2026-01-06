package com.example.educonnect_platform.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
//only set getters because it safer for response
@AllArgsConstructor
public class UserResponseDTO {

    private String userName;
    private String firebaseUid;
}
