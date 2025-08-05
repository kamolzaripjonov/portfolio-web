package kamol.cyber.portfolio_web.service;

import kamol.cyber.portfolio_web.entity.About;
import kamol.cyber.portfolio_web.exception.ResourceNotFoundException;
import kamol.cyber.portfolio_web.repository.AboutRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AboutService {
    private final AboutRepository aboutRepository;

    public AboutService(AboutRepository aboutRepository) {
        this.aboutRepository = aboutRepository;
    }

    public List<About> getAllAbouts() {
        return aboutRepository.findAll();
    }

    public About getAboutById(Long id) {
        return aboutRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("About section not found with id: " + id));
    }

    public About createAbout(About about) {
        return aboutRepository.save(about);
    }

    public About updateAbout(Long id, About aboutDetails) {
        About about = getAboutById(id);
        about.setDescription(aboutDetails.getDescription());
        about.setImageUrl(aboutDetails.getImageUrl());
        return aboutRepository.save(about);
    }

    public void deleteAbout(Long id) {
        About about = getAboutById(id);
        aboutRepository.delete(about);
    }
}