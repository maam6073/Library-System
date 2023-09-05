package com.rmsoft_test.LibrarySystem.user.controller;

import com.rmsoft_test.LibrarySystem.user.dto.UserPatchDto;
import com.rmsoft_test.LibrarySystem.user.dto.UserPostDto;
import com.rmsoft_test.LibrarySystem.user.entity.User;
import com.rmsoft_test.LibrarySystem.user.mapper.UserMapper;
import com.rmsoft_test.LibrarySystem.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Validated
@RequestMapping(value = "/users")
public class UserController {

    private final UserMapper userMapper;
    private final UserService userService;

    UserController(UserMapper userMapper , UserService userService){
        this.userMapper = userMapper;
        this.userService = userService;
    }

    //회원가입
    @PostMapping("/registry")
    public ResponseEntity postUser(@Valid @RequestBody UserPostDto userPostDto){
        userService.createUser(userMapper.userPostDtoToUser(userPostDto));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //이름수정
    @PatchMapping("/update")
    public ResponseEntity patchUser(@Valid @RequestBody UserPatchDto userPatchDto){
        userService.updateNameUser(userMapper.userPatchToUser(userPatchDto));
        return new ResponseEntity<>(null);
    }




}
