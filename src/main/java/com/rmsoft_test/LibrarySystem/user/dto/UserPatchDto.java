package com.rmsoft_test.LibrarySystem.user.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@Getter
@Setter
public class UserPatchDto {

    //수정할 이름
    @NotBlank(message = "이름은 20자까지 허용 됩니다.")
    @Length(max = 20)
    private String name;
}
