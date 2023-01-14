package net.studenture.api.restcontroller.body;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLogin {
    private String name;
    private String password;
    private Long id;
}
