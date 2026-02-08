package com.amagana.dto;

import com.amagana.domain.UserEntity;

import java.util.List;

public record UserProfileDTO(Long id, String name, String description, List<UserEntity> userEntities) {
}
