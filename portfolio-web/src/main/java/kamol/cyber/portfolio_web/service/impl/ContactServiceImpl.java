package kamol.cyber.portfolio_web.service.impl;

import jakarta.transaction.Transactional;
import kamol.cyber.portfolio_web.DTO.ContactDto;
import kamol.cyber.portfolio_web.entity.Contact;
import kamol.cyber.portfolio_web.repository.ContactRepository;
import kamol.cyber.portfolio_web.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    private ContactDto mapToDto(Contact contact) {
        return ContactDto.builder()
                .id(contact.getId())
                .fullName(contact.getFullName())
                .email(contact.getEmail())
                .subject(contact.getSubject())
                .message(contact.getMessage())
                .build();
    }

    private Contact mapToEntity(ContactDto dto) {
        return Contact.builder()
                .id(dto.getId())
                .fullName(dto.getFullName())
                .email(dto.getEmail())
                .subject(dto.getSubject())
                .message(dto.getMessage())
                .build();
    }

    @Override
    public ContactDto create(ContactDto contactDto) {
        Contact saved = contactRepository.save(mapToEntity(contactDto));
        return mapToDto(saved);
    }

    @Override
    public List<ContactDto> getAll() {
        return contactRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        contactRepository.deleteById(id);
    }
}
