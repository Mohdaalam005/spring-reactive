package github.com.mohammadaalam005.springreactive.service;

import github.com.mohammadaalam005.springreactive.entity.UserEntity;
import github.com.mohammadaalam005.springreactive.mapper.UserMapper;
import github.com.mohammadaalam005.springreactive.model.UserRequest;
import github.com.mohammadaalam005.springreactive.model.UserResponse;
import github.com.mohammadaalam005.springreactive.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {
    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public Mono<UserResponse> createUser(UserRequest userRequest) {
        UserEntity userEntity = userMapper.modelToEntity(userRequest);
        Mono<UserEntity> save = userRepository.save(userEntity);
        return save.map(userMapper::entityToResponse);
    }

    public Flux<UserRequest> getUsers() {
        Flux<UserEntity> users = userRepository.findAll();
        return users.map(userMapper::entityToModel);
    }

    public Mono<UserRequest> getUser(Long userId) {
        Mono<UserEntity> user = userRepository.findById(userId);
        return user.map(userMapper::entityToModel);
    }

    public Mono<UserRequest> updateUser(Long userId, UserRequest userRequest) {
        UserEntity userEntity = userMapper.modelToEntity(userRequest);
        userEntity.setId(userId);
        Mono<UserEntity> save = userRepository.save(userEntity);
        return save.map(userMapper::entityToModel);

    }

    public Mono<Void> deleteUser(Long userId) {
        return userRepository.deleteById(userId);

    }


}
