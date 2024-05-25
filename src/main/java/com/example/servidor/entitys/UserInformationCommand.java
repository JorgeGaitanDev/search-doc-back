package com.example.servidor.entitys;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserInformationCommand {

    private Long userId;
    private IdentificationType identificationType;
}
