package com.example.servidor.repositories;

import com.example.servidor.exceptions.UserNotFoundException;
import com.example.servidor.models.Users;
import com.example.servidor.entitys.UserInformationDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryJsonImpl implements UserRepository {

    private List<Users> usersList = new ArrayList<>();

    @PostConstruct
    public void init() {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Users>> typeReference = new TypeReference<List<Users>>() {};
        InputStream inputStream = TypeReference.class.getResourceAsStream("/data.json");
        if (inputStream == null) {
            System.out.println("Archivo no encontrado.");
        } else {
            System.out.println("Archivo encontrado.");
        }

        try {
            usersList = mapper.readValue(inputStream, typeReference);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public UserInformationDTO findByIdentificationTypeAndUserId(String identificationType, Long userId) {
        Users user = usersList.stream()
                .filter(u -> u.getUserId().equals(userId) && u.getIdentificationType().equals(identificationType))
                .findFirst()
                .orElse(null);

        if (user == null) {
            throw new UserNotFoundException("User not found with ID: " + userId + " and identification type: " + identificationType);
        }

        return UserInformationDTO.builder()
                .firstName(user.getFirstName())
                .secondName(user.getSecondName())
                .firstSurname(user.getFirstSurname())
                .secondSurname(user.getSecondSurname())
                .phone(user.getPhone())
                .address(user.getAddress())
                .cityResident(user.getCityResident())
                .build();
    }
}

