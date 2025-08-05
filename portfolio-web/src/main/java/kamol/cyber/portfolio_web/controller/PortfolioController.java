package kamol.cyber.portfolio_web.controller;

import kamol.cyber.portfolio_web.entity.About;
import kamol.cyber.portfolio_web.entity.Project;
import kamol.cyber.portfolio_web.entity.Skill;
import kamol.cyber.portfolio_web.repository.AboutRepository;
import kamol.cyber.portfolio_web.repository.ProjectRepository;
import kamol.cyber.portfolio_web.repository.SkillRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/portfolio")
public class PortfolioController {

    private final AboutRepository aboutRepository;
    private final ProjectRepository projectRepository;
    private final SkillRepository skillRepository;

    public PortfolioController(AboutRepository aboutRepository,
                               ProjectRepository projectRepository,
                               SkillRepository skillRepository) {
        this.aboutRepository = aboutRepository;
        this.projectRepository = projectRepository;
        this.skillRepository = skillRepository;
    }

    @GetMapping("/about")
    public ResponseEntity<About> getAbout() {
        return aboutRepository.findById(1L)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/projects")
    public ResponseEntity<List<Project>> getProjects() {
        List<Project> projects = projectRepository.findAll();
        return ResponseEntity.ok(projects);
    }

    @GetMapping("/skills")
    public ResponseEntity<List<Skill>> getSkills() {
        List<Skill> skills = skillRepository.findAll();
        return ResponseEntity.ok(skills);
    }
}