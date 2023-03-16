package github.com.mohammadaalam005.springreactive.model;

import lombok.Data;

@Data
public class UserRequest  extends  UserResponse{

    private String name;
    private String email;
    private String gender;
}
