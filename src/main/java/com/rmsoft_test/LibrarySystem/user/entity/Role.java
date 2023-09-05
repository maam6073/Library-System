package com.rmsoft_test.LibrarySystem.user.entity;

import lombok.Getter;

@Getter
public enum Role {
    ROLE_ADMIN("관리자"),
    ROLE_USER("일반사용자");

    @Getter
    private String description;

    Role(String description){
        this.description = description;
    }
}
