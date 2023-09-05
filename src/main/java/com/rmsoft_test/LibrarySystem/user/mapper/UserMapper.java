package com.rmsoft_test.LibrarySystem.user.mapper;

import com.rmsoft_test.LibrarySystem.user.dto.UserPatchDto;
import com.rmsoft_test.LibrarySystem.user.dto.UserPostDto;
import com.rmsoft_test.LibrarySystem.user.dto.UserResponseDto;
import com.rmsoft_test.LibrarySystem.user.entity.Role;
import com.rmsoft_test.LibrarySystem.user.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    default User userPostDtoToUser(UserPostDto userPostDto){
        return User.builder()
                .id(userPostDto.getId())
                .password(userPostDto.getPassword())
                .name(userPostDto.getName())
                .role(Role.ROLE_USER)
                .build();
    }
    User userPatchToUser(UserPatchDto userPatchDto);
    UserResponseDto userToUserResponseDto(User user);
}
