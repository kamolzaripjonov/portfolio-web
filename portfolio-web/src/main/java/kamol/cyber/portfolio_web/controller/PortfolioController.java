package kamol.cyber.portfolio_web.controller;

import kamol.cyber.portfolio_web.DTO.PortfolioRequestDto;
import kamol.cyber.portfolio_web.DTO.PortfolioResponseDto;
import kamol.cyber.portfolio_web.service.PortfolioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/portfolio")
@RequiredArgsConstructor
public class PortfolioController {
    private final PortfolioService portfolioService;

    @PostMapping
    public ResponseEntity<PortfolioResponseDto> create(@RequestBody PortfolioRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(portfolioService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PortfolioResponseDto> update(@PathVariable Long id, @RequestBody PortfolioRequestDto dto) {
        return ResponseEntity.ok(portfolioService.update(id, dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PortfolioResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(portfolioService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<PortfolioResponseDto>> getAll() {
        return ResponseEntity.ok(portfolioService.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        portfolioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
