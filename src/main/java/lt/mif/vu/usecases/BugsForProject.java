package lt.mif.vu.usecases;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

import lt.mif.vu.entities.Project;
import lt.mif.vu.entities.Bug;
import lt.mif.vu.persistence.ProjectsDAO;
import lt.mif.vu.persistence.BugsDAO;
import lt.mif.vu.interceptors.LoggedInvocation;
import lt.mif.vu.processors.BugTitleProcessor;

@Model
public class BugsForProject implements Serializable {

    @Inject
    private ProjectsDAO projectsDAO;

    @Inject
    private BugsDAO bugsDAO;

    @Inject
    BugTitleProcessor bugTitleProcessor;

    @Getter @Setter
    private Project project;

    @Getter @Setter
    private Bug bugToCreate = new Bug();

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer projectId = Integer.parseInt((requestParameters.get("projectId")));
        this.project = projectsDAO.findOne(projectId);
    }

    @LoggedInvocation
    @Transactional
    public String createBug() {
        bugToCreate.setProject(this.project);
        bugTitleProcessor.process(bugToCreate);
        bugsDAO.persist(bugToCreate);
        return "/bugs.xhtml?faces-redirect=true&projectId=" + this.project.getId();
    }

}
