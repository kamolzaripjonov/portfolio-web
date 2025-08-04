package kamol.cyber.portfolio_web.service.impl;

import kamol.cyber.portfolio_web.DTO.CVDto;
import kamol.cyber.portfolio_web.entity.CV;
import kamol.cyber.portfolio_web.repository.CVRepository;
import kamol.cyber.portfolio_web.service.CVService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CVServiceImpl implements CVService {

    private final CVRepository cvRepository;

    @Override
    public CV saveCV(CVDto dto) throws IOException {
        MultipartFile file = dto.getFile();
        CV cv = CV.builder()
                .fileName(file.getOriginalFilename())
                .fileType(file.getContentType())
                .data(file.getBytes())
                .build();
        return cvRepository.save(cv);
    }

    @Override
    public List<CV> getAllCVs() {
        return cvRepository.findAll();
    }

    @Override
    public CV getCVById(Long id) {
        return cvRepository.findById(id).orElse(null);
    }

    @Override
    public CV updateCV(Long id, CVDto dto) throws IOException {
        CV existing = cvRepository.findById(id).orElse(null);
        if (existing != null) {
            MultipartFile file = dto.getFile();
            existing.setFileName(file.getOriginalFilename());
            existing.setFileType(file.getContentType());
            existing.setData(file.getBytes());
            return cvRepository.save(existing);
        }
        return null;
    }

    @Override
    public void deleteCV(Long id) {
        cvRepository.deleteById(id);
    }
}