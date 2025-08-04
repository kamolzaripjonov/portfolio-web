package kamol.cyber.portfolio_web.service;

import kamol.cyber.portfolio_web.DTO.AboutRequestDto;
import kamol.cyber.portfolio_web.DTO.AboutResponseDto;

import java.util.List;

public interface AboutService {
    AboutResponseDto create(AboutRequestDto dto);

    AboutResponseDto update(Long id, AboutRequestDto dto);

    void delete(Long id);

    List<AboutResponseDto> getAll(String language);
}
