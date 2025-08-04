package kamol.cyber.portfolio_web.service;

import kamol.cyber.portfolio_web.DTO.CVDto;
import kamol.cyber.portfolio_web.entity.CV;

import java.util.List;

public interface CVService {
    CV saveCV(CVDto dto) throws Exception;

    List<CV> getAllCVs();

    CV getCVById(Long id);

    CV updateCV(Long id, CVDto dto) throws Exception;

    void deleteCV(Long id);
}