package com.rmsoft_test.LibrarySystem.user.service;

import com.rmsoft_test.LibrarySystem.common.exception.BusinessLogicException;
import com.rmsoft_test.LibrarySystem.common.exception.ExceptionCode;
import com.rmsoft_test.LibrarySystem.user.entity.Role;
import com.rmsoft_test.LibrarySystem.user.entity.User;
import com.rmsoft_test.LibrarySystem.user.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Transactional
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    //회원가입
    public User createUser(User user){
        verifyExistId(user.getId());
        String encryptedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);

        return userRepository.save(user);
    }


    //회원수정(이름 수정)
    @Transactional(readOnly = true)
    public User updateNameUser(User user){
        //User findUser = findUserById()
        return null;
    }


    private void verifyExistId(String id){
        Optional<User> users = userRepository.findById(id);
        if(users.isPresent())
            throw new BusinessLogicException(ExceptionCode.USER_EXISTS);
    }

    User findUserById(long user_id){
        return userRepository.findById(user_id)
                .orElseThrow( () ->new BusinessLogicException(ExceptionCode.USER_NOT_FOUND));
    }
}
