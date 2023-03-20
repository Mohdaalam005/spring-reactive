package github.com.mohammadaalam005.springreactive.repository;

import github.com.mohammadaalam005.springreactive.entity.UserEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends R2dbcRepository<UserEntity, Long> {
}
