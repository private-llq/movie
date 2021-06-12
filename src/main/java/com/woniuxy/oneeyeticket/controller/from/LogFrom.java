package com.woniuxy.oneeyeticket.controller.from;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LogFrom {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
