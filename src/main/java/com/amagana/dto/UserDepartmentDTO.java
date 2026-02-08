package com.amagana.dto;

import com.amagana.domain.UserDepartment;
import com.amagana.domain.UserEntity;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

public record UserDepartmentDTO(Long id, @NotNull String code,@NotNull String name, String description,
                                UserDepartment parent, Set<UserDepartment> children,
                                UserEntity manager) {
}
