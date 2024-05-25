package com.example.servidor.services;

import com.example.servidor.entitys.UserInformationCommand;
import com.example.servidor.entitys.UserInformationDTO;
import com.example.servidor.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInformationService {
    @Autowired UserRepository userRepository;

    public UserInformationDTO getUserInformation(UserInformationCommand command) {

        return userRepository.findByIdentificationTypeAndUserId(String.valueOf(command.getIdentificationType()), command.getUserId());
    }
}
