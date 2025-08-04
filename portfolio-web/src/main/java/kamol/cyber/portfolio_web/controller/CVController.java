package kamol.cyber.portfolio_web.controller;

import kamol.cyber.portfolio_web.DTO.CVDto;
import kamol.cyber.portfolio_web.entity.CV;
import kamol.cyber.portfolio_web.service.CVService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
        import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/cv")
@RequiredArgsConstructor
public class CVController {

    private final CVService cvService;

    @PostMapping
    public ResponseEntity<CV> uploadCV(@RequestParam("file") MultipartFile file) throws Exception {
        CVDto dto = CVDto.builder().file(file).build();
        return ResponseEntity.ok(cvService.saveCV(dto));
    }

    @GetMapping
    public ResponseEntity<List<CV>> getAllCVs() {
        return ResponseEntity.ok(cvService.getAllCVs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CV> getCV(@PathVariable Long id) {
        return ResponseEntity.ok(cvService.getCVById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CV> updateCV(@PathVariable Long id, @RequestParam("file") MultipartFile file) throws Exception {
        CVDto dto = CVDto.builder().file(file).build();
        return ResponseEntity.ok(cvService.updateCV(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCV(@PathVariable Long id) {
        cvService.deleteCV(id);
        return ResponseEntity.noContent().build();
    }
}



