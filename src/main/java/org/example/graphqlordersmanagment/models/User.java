package org.example.graphqlordersmanagment.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.example.graphqlordersmanagment.enums.Gender;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message ="the name shouldn't be empty")
    @Size(min = 5, max = 50,message = "the title should be between 5 to 50 characters")
    private String name;

    @NotBlank(message ="the gender shouldn't be empty")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @NotBlank(message ="the email shouldn't be empty")
    @Email(message = "Email is not valid")
    private String email;

    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$",message = "password should be 6 minimum characters and numbers")
    private String password;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", id=" + id +
                '}';
    }
}

