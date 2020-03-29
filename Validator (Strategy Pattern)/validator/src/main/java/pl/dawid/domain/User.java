package pl.dawid.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class User{
    @Getter
    @Setter
    UserType userType;
    @Getter
    @Setter
    String name;
    @Getter
    @Setter
    String email;
}