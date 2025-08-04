package kamol.cyber.portfolio_web.controller;

import kamol.cyber.portfolio_web.DTO.RegisterDTO;
import kamol.cyber.portfolio_web.DTO.UserDTO;
import kamol.cyber.portfolio_web.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDTO dto) {
        String result = userService.register(dto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
}
