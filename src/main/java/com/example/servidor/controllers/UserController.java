package com.example.servidor.controllers;

import com.example.servidor.entitys.IdentificationType;
import com.example.servidor.entitys.UserInformationCommand;
import com.example.servidor.entitys.UserInformationDTO;
import com.example.servidor.exceptions.InvalidIdentificationTypeException;
import com.example.servidor.services.UserInformationService;
import com.example.servidor.utils.RouterConstanst;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    public UserInformationService userInformationService;

    @GetMapping(RouterConstanst.userInformationPath)
    public ResponseEntity<String> getUserInformation(@PathVariable String identificationType,
                                                     @PathVariable Long userId) throws JsonProcessingException {

        try {
            IdentificationType type = IdentificationType.valueOf(identificationType.toUpperCase());

            UserInformationCommand command = UserInformationCommand
                    .builder()
                    .userId(userId)
                    .identificationType(type)
                    .build();

            UserInformationDTO userInformationDTO = userInformationService.getUserInformation(command);

            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(userInformationDTO);

            return ResponseEntity.ok(json);
        } catch (IllegalArgumentException e) {

            throw new InvalidIdentificationTypeException(identificationType);
        }
    }
}
