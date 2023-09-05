package com.rmsoft_test.LibrarySystem.common.security.login;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;


@Getter
@Setter
public class SecurityUser extends User {
    private com.rmsoft_test.LibrarySystem.user.entity.User users;

    public SecurityUser(com.rmsoft_test.LibrarySystem.user.entity.User users){
        super(users.getId(),users.getPassword(),
                AuthorityUtils.createAuthorityList(users.getRole().toString()));
        this.users = users;
    }
}
