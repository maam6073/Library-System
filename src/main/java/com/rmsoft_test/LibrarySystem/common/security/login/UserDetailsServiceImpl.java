package com.rmsoft_test.LibrarySystem.common.security.login;

import com.rmsoft_test.LibrarySystem.common.exception.BusinessLogicException;
import com.rmsoft_test.LibrarySystem.user.entity.User;
import com.rmsoft_test.LibrarySystem.user.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException{
        Optional<User> findUser = userRepository.findById(id);
        if(!findUser.isPresent()) throw new UsernameNotFoundException("존재하지 않는 username 입니다.");
        return new SecurityUser(findUser.get());
    }
}
