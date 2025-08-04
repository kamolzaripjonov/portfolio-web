package kamol.cyber.portfolio_web.controller;

import kamol.cyber.portfolio_web.DTO.AboutRequestDto;
import kamol.cyber.portfolio_web.DTO.AboutResponseDto;
import kamol.cyber.portfolio_web.service.AboutService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/about")
@RequiredArgsConstructor
public class AboutController {

    private final AboutService aboutService;

    @PostMapping
    public ResponseEntity<AboutResponseDto> create(@RequestBody AboutRequestDto dto) {
        return ResponseEntity.ok(aboutService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AboutResponseDto> update(@PathVariable Long id, @RequestBody AboutRequestDto dto) {
        return ResponseEntity.ok(aboutService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        aboutService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<AboutResponseDto>> getAll(@RequestParam(defaultValue = "UZ") String language) {
        return ResponseEntity.ok(aboutService.getAll(language));
    }
}
