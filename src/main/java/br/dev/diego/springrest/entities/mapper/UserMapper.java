package br.dev.diego.springrest.entities.mapper;

import br.dev.diego.springrest.entities.User;
import br.dev.diego.springrest.entities.dto.UserDto;
import br.dev.diego.springrest.entities.dto.UserInsertDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto userToUserDto(User entity);

    @Mapping(target = "id", ignore = true)
    User userInsertDtoToUser(UserInsertDto entity);

}
