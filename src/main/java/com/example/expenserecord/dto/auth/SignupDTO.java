package com.example.expenserecord.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SignupDTO {
    private String name;
    private String password;
    private String defaultMoneyId;
}
