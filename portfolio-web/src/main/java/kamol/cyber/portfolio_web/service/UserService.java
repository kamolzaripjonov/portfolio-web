package kamol.cyber.portfolio_web.service;

import kamol.cyber.portfolio_web.DTO.UserDto;

import java.util.List;

public interface UserService {
    UserDto create(UserDto userDto);

    UserDto update(Long id, UserDto userDto);

    void delete(Long id);

    UserDto getById(Long id);

    List<UserDto> getAll();
}
