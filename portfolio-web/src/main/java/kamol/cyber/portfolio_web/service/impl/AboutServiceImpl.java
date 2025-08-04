package kamol.cyber.portfolio_web.service.impl;

import kamol.cyber.portfolio_web.DTO.AboutRequestDto;
import kamol.cyber.portfolio_web.DTO.AboutResponseDto;
import kamol.cyber.portfolio_web.entity.About;
import kamol.cyber.portfolio_web.exception.ResourceNotFoundException;
import kamol.cyber.portfolio_web.repository.AboutRepository;
import kamol.cyber.portfolio_web.service.AboutService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AboutServiceImpl implements AboutService {

    private final AboutRepository aboutRepository;
    private final ModelMapper modelMapper;

    @Override
    public AboutResponseDto create(AboutRequestDto dto) {
        About about = modelMapper.map(dto, About.class);
        return modelMapper.map(aboutRepository.save(about), AboutResponseDto.class);
    }

    @Override
    public AboutResponseDto update(Long id, AboutRequestDto dto) {
        About about = aboutRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("About", "id", id));

        about.setTitle(dto.getTitle());
        about.setDescription(dto.getDescription());
        about.setImageUrl(dto.getImageUrl());
        about.setLanguage(dto.getLanguage());

        return modelMapper.map(aboutRepository.save(about), AboutResponseDto.class);
    }

    @Override
    public void delete(Long id) {
        aboutRepository.deleteById(id);
    }

    @Override
    public List<AboutResponseDto> getAll(String language) {
        return aboutRepository.findAllByLanguage(language)
                .stream()
                .map(a -> modelMapper.map(a, AboutResponseDto.class))
                .collect(Collectors.toList());
    }
}
