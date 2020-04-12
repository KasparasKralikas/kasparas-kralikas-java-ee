package lt.mif.vu.usecases;

import lombok.Getter;
import lombok.Setter;

import lt.mif.vu.entities.Project;
import lt.mif.vu.persistence.ProjectsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Projects {

    @Inject
    private ProjectsDAO projectsDAO;

    @Getter @Setter
    private Project projectToCreate = new Project();

    @Getter
    private List<Project> allProjects;

    @PostConstruct
    public void init() {
        loadAllProjects();
    }

    @Transactional
    public String createProject() {
        this.projectsDAO.persist(projectToCreate);
        return "success";
    }

    private void loadAllProjects() {
        this.allProjects = projectsDAO.loadAll();
    }
}
