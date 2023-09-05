package com.rmsoft_test.LibrarySystem.user.dto;



import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.context.annotation.Role;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


@NoArgsConstructor
@Getter
public class UserPostDto {

    //아이디
    @Pattern(regexp = "^\\S+(\\s?\\S+)*$", message = "회원 닉네임은 공백이 아니어야 합니다.")
    //    이름 정보가 비어있으면(null) 유효성 검증을 하지 않습니다.
    //    이름 정보가 비어 있지 않고(not null), 공백 문자열이라면 검증에 실패합니다.
    //    시작 문자가 공백이면 검증에 실패합니다.
    //    끝 문자가 공백이면 검증에 실패합니다.
    //    문자와 문자 사이 공백이 1개를 초과하면 검증에 실패합니다.
    @NotBlank
    private String id;

    //비밀번호
    @NotBlank(message = "암호는 공백 없이 8-20자여야 합니다.")
    @Length(min = 8, max = 20)
    private String password;

    //이름
    @NotBlank(message = "이름은 20자까지 허용 됩니다.")
    @Length(max = 20)
    String name;

    //권한
    private Role role;
}
