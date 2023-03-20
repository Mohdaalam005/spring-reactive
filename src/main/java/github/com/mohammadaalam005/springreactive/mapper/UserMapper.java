package github.com.mohammadaalam005.springreactive.mapper;

import github.com.mohammadaalam005.springreactive.entity.UserEntity;
import github.com.mohammadaalam005.springreactive.model.UserRequest;
import github.com.mohammadaalam005.springreactive.model.UserResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserRequest entityToModel(UserEntity userEntity);

    UserEntity modelToEntity(UserRequest userRequest);

    List<UserRequest> entitiesToModels(List<UserEntity> userEntities);

    UserResponse entityToResponse(UserEntity userEntity);


}
