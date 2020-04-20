package lt.mif.vu.usecases;

import lombok.Getter;
import lombok.Setter;

import lt.mif.vu.mybatis.dao.ProjectMapper;
import lt.mif.vu.mybatis.model.Project;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class ProjectsMyBatis {
    @Inject
    private ProjectMapper projectMapper;

    @Getter
    private List<Project> allProjects;

    @Getter @Setter
    private Project projectToCreate = new Project();

    @PostConstruct
    public void init() {
        this.loadAllProjects();
    }

    private void loadAllProjects() {
        this.allProjects = projectMapper.selectAll();
    }

    @Transactional
    public String createProject() {
        projectMapper.insert(projectToCreate);
        return "/myBatis/projects?faces-redirect=true";
    }
}
