package ru.cryptoprices.mesler.cryptoprices.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "User")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    @NotNull
    private ROLE role;
    @NotEmpty(message = "first name can not be empty")
    @Size(min = 2, max = 40, message = "last name should be between 2 and 40 characters")
    private String firstName;
    @NotEmpty(message = "last name can not be empty")
    @Size(min = 2, max = 40, message = "last name should be between 2 and 40 characters")
    private String lastName;
    @NotNull
    @Size(min = 1, max = 30, message = "username should be between 1 and 30 characters")
    private String username;
    @NotNull
    private String sex;
    @NotEmpty(message = "age should be between 16 and 100")
    @Min(value = 16, message = "age should be between 16 and 100")
    @Max(value = 100, message = "age should be between 16 and 100")
    private int age;
    @NotEmpty(message = "email can not be empty")
    @Email(message = "email should be like: example@exmple.com")
    private String email;
}
