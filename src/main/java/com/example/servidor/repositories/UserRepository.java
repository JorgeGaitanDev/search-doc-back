package com.example.servidor.repositories;

import com.example.servidor.entitys.UserInformationDTO;
import java.util.List;

public interface UserRepository {

    UserInformationDTO findByIdentificationTypeAndUserId(String identificationType, Long userId);
}
