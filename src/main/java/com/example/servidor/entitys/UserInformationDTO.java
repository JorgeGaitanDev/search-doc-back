package com.example.servidor.entitys;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserInformationDTO {
    private String firstName;
    private String secondName;
    private String firstSurname;
    private String secondSurname;
    private Long phone;
    private String address;
    private String cityResident;
}