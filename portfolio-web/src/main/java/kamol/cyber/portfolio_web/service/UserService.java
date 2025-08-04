package kamol.cyber.portfolio_web.service;

import kamol.cyber.portfolio_web.DTO.RegisterDTO;
import kamol.cyber.portfolio_web.DTO.UserDTO;
import kamol.cyber.portfolio_web.entity.User;
import kamol.cyber.portfolio_web.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public String register(RegisterDTO dto) {
        if (userRepository.existsByUsername(dto.getUsername()))
            return "Username already exists";

        User user = User.builder()
                .fullname(dto.getFullname())
                .username(dto.getUsername())
                .password(passwordEncoder.encode(dto.getPassword()))
                .build();

        userRepository.save(user);
        return "User registered successfully";
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(user -> new UserDTO(user.getId(), user.getFullname(), user.getUsername()))
                .collect(Collectors.toList());
    }
}
