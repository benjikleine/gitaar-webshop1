package com.example.Gitaar.Webshop.exception;

import lombok.Getter;

@Getter
public class PasswordConfigException extends RuntimeException {

    private final String password2Error;

    public PasswordConfigException(String password2Error) { this.password2Error = password2Error; }
}
