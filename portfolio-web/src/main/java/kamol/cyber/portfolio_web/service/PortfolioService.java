package kamol.cyber.portfolio_web.service;

import kamol.cyber.portfolio_web.DTO.PortfolioRequestDto;
import kamol.cyber.portfolio_web.DTO.PortfolioResponseDto;

import java.util.List;

public interface PortfolioService {
    PortfolioResponseDto save(PortfolioRequestDto dto);

    PortfolioResponseDto update(Long id, PortfolioRequestDto dto);

    PortfolioResponseDto getById(Long id);

    void delete(Long id);

    List<PortfolioResponseDto> getAll();
}
