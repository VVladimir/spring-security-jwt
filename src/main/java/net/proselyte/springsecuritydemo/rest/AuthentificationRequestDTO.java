package net.proselyte.springsecuritydemo.rest;

import lombok.Data;

@Data
public class AuthentificationRequestDTO {
    String email;
    String password;
}
