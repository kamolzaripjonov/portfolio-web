package kamol.cyber.portfolio_web.service;

import kamol.cyber.portfolio_web.DTO.ContactDto;

import java.util.List;

public interface ContactService {
    ContactDto create(ContactDto contactDto);

    List<ContactDto> getAll();

    void delete(Long id);
}
