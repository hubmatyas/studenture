package net.studenture.api.controller.body;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreate {
    private String name;
    private String email;
    private String password;
}
