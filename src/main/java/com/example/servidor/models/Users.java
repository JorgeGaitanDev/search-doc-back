package com.example.servidor.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    private String firstName;
    private String secondName;
    private String firstSurname;
    private String secondSurname;
    private Long phone;
    private String address;
    private String cityResident;
    private String identificationType;
    private Long userId;
}



