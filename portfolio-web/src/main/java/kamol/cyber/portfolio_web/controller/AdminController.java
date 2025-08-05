package kamol.cyber.portfolio_web.controller;

import kamol.cyber.portfolio_web.entity.About;
import kamol.cyber.portfolio_web.entity.Project;
import kamol.cyber.portfolio_web.entity.Skill;
import kamol.cyber.portfolio_web.service.AboutService;
import kamol.cyber.portfolio_web.service.ProjectService;
import kamol.cyber.portfolio_web.service.SkillService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final AboutService aboutService;
    private final ProjectService projectService;
    private final SkillService skillService;

    public AdminController(AboutService aboutService, ProjectService projectService, SkillService skillService) {
        this.aboutService = aboutService;
        this.projectService = projectService;
        this.skillService = skillService;
    }

    // About uchun CRUD
    @PostMapping("/about")
    public About createAbout(@RequestBody About about) {
        return aboutService.createAbout(about);
    }

    @PutMapping("/about/{id}")
    public ResponseEntity<About> updateAbout(@PathVariable Long id, @RequestBody About aboutDetails) {
        return ResponseEntity.ok(aboutService.updateAbout(id, aboutDetails));
    }

    @DeleteMapping("/about/{id}")
    public ResponseEntity<Void> deleteAbout(@PathVariable Long id) {
        aboutService.deleteAbout(id);
        return ResponseEntity.noContent().build();
    }

    // Projects uchun CRUD
    @PostMapping("/projects")
    public Project createProject(@RequestBody Project project) {
        return projectService.createProject(project);
    }

    @PutMapping("/projects/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable Long id, @RequestBody Project projectDetails) {
        return ResponseEntity.ok(projectService.updateProject(id, projectDetails));
    }

    @DeleteMapping("/projects/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
        return ResponseEntity.noContent().build();
    }

    // Skills uchun CRUD
    @PostMapping("/skills")
    public Skill createSkill(@RequestBody Skill skill) {
        return skillService.createSkill(skill);
    }

    @PutMapping("/skills/{id}")
    public ResponseEntity<Skill> updateSkill(@PathVariable Long id, @RequestBody Skill skillDetails) {
        return ResponseEntity.ok(skillService.updateSkill(id, skillDetails));
    }

    @DeleteMapping("/skills/{id}")
    public ResponseEntity<Void> deleteSkill(@PathVariable Long id) {
        skillService.deleteSkill(id);
        return ResponseEntity.noContent().build();
    }
}