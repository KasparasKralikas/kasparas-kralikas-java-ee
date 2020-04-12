package lt.mif.vu.usecases;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

import lt.mif.vu.entities.Project;
import lt.mif.vu.persistence.ProjectsDAO;

@Model
public class BugsForProject implements Serializable {

    @Inject
    private ProjectsDAO projectsDAO;

    @Getter @Setter
    private Project project;

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer projectId = Integer.parseInt((requestParameters.get("projectId")));
        this.project = projectsDAO.findOne(projectId);
    }

}
