package kamol.cyber.portfolio_web.util;

import kamol.cyber.portfolio_web.entity.*;
import kamol.cyber.portfolio_web.entity.enums.RoleName;
import kamol.cyber.portfolio_web.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final AboutRepository aboutRepository;
    private final ProjectRepository projectRepository;
    private final SkillRepository skillRepository;

    public DataLoader(UserRepository userRepository, RoleRepository roleRepository,
                      PasswordEncoder passwordEncoder, AboutRepository aboutRepository,
                      ProjectRepository projectRepository, SkillRepository skillRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.aboutRepository = aboutRepository;
        this.projectRepository = projectRepository;
        this.skillRepository = skillRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (roleRepository.findByRoleName(RoleName.ADMIN).isEmpty()) {
            Role adminRole = new Role();
            adminRole.setRoleName(RoleName.ADMIN);
            roleRepository.save(adminRole);
        }

        if (userRepository.findByUsername("admin").isEmpty()) {
            Set<Role> roles = new HashSet<>();
            roleRepository.findByRoleName(RoleName.ADMIN).ifPresent(roles::add);

            User adminUser = new User();
            adminUser.setUsername("admin");
            adminUser.setPassword(passwordEncoder.encode("adminpass"));
            adminUser.setRoles(roles);
            userRepository.save(adminUser);
        }

        if (aboutRepository.count() == 0) {
            About about = new About();
            about.setDescription("Men [Ismingiz] professional dasturchiman. 2 yil mobaynida ... dasturlash tillari bilan ishlaganman.");
            about.setImageUrl("https://example.com/profile.jpg");
            aboutRepository.save(about);
        }

        if (projectRepository.count() == 0) {
            Project project = new Project();
            project.setTitle("Online do'kon uchun E-commerce ilova");
            project.setDescription("Bu loyiha Spring Boot backend va ReactJS frontend yordamida yaratilgan e-commerce platformasi.");
            project.setImageUrl("https://example.com/project-image.jpg");
            projectRepository.save(project);
        }

        // Test uchun Skill ma'lumotini qo'shish
        if (skillRepository.count() == 0) {
            Skill skill1 = new Skill();
            skill1.setName("Java Spring Boot");
            skill1.setLevel("Expert");
            skillRepository.save(skill1);

            Skill skill2 = new Skill();
            skill2.setName("Databases (PostgreSQL, MySQL)");
            skill2.setLevel("Advanced");
            skillRepository.save(skill2);
        }
    }
}