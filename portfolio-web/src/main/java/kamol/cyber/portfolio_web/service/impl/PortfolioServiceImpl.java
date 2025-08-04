package kamol.cyber.portfolio_web.service.impl;

import kamol.cyber.portfolio_web.DTO.PortfolioRequestDto;
import kamol.cyber.portfolio_web.DTO.PortfolioResponseDto;
import kamol.cyber.portfolio_web.entity.Portfolio;
import kamol.cyber.portfolio_web.exception.ResourceNotFoundException;
import kamol.cyber.portfolio_web.repository.PortfolioRepository;
import kamol.cyber.portfolio_web.service.PortfolioService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PortfolioServiceImpl implements PortfolioService {
    private final PortfolioRepository portfolioRepository;
    private final ModelMapper modelMapper;

    @Override
    public PortfolioResponseDto save(PortfolioRequestDto dto) {
        Portfolio portfolio = modelMapper.map(dto, Portfolio.class);
        return modelMapper.map(portfolioRepository.save(portfolio), PortfolioResponseDto.class);
    }

    @Override
    public PortfolioResponseDto update(Long id, PortfolioRequestDto dto) {
        Portfolio portfolio = portfolioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Portfolio not found"));

        portfolio.setTitle(dto.getTitle());
        portfolio.setDescription(dto.getDescription());
        portfolio.setImageUrl(dto.getImageUrl());
        portfolio.setLink(dto.getLink());
        portfolio.setLanguage(dto.getLanguage());

        return modelMapper.map(portfolioRepository.save(portfolio), PortfolioResponseDto.class);
    }

    @Override
    public PortfolioResponseDto getById(Long id) {
        Portfolio portfolio = portfolioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Portfolio not found"));
        return modelMapper.map(portfolio, PortfolioResponseDto.class);
    }

    @Override
    public void delete(Long id) {
        Portfolio portfolio = portfolioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Portfolio not found"));
        portfolioRepository.delete(portfolio);
    }

    @Override
    public List<PortfolioResponseDto> getAll() {
        return portfolioRepository.findAll().stream()
                .map(p -> modelMapper.map(p, PortfolioResponseDto.class))
                .collect(Collectors.toList());
    }
}
