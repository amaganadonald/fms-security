package com.amagana.dto;

import com.amagana.domain.UserDepartment;
import com.amagana.domain.UserProfile;
import com.amagana.domain.UserService;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public record UserEntityDTO(Long id, String username,@NotNull String code, String firstName,
        String lastName, String fullName, String phoneNumber, String jobTitle, String hierarchyDepartment,
                            @Email @Size(min = 5, max = 254) String email,
                            @Size(min = 2, max = 10) String langKey,
                            @Size(max = 256) String imageUrl, List<UserProfile> userProfiles,
                            UserDepartment departments, UserService service) {
}
