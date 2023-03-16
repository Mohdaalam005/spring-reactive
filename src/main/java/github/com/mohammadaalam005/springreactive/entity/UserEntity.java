package github.com.mohammadaalam005.springreactive.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "users")
@Data
public class UserEntity {
    @Id
    private Long id;

    private String name;
    private String email;
    private String gender;
}
