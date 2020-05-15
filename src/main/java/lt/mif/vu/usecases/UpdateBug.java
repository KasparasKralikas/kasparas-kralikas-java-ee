package lt.mif.vu.usecases;

import lombok.Getter;
import lombok.Setter;

import lt.mif.vu.entities.Bug;
import lt.mif.vu.persistence.BugsDAO;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@ViewScoped
@Named
@Getter @Setter
public class UpdateBug implements Serializable {

    private Bug bug;

    @Inject
    private BugsDAO bugsDAO;

    @PostConstruct
    private void init() {
        System.out.println("UpdateBug init is called");
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer bugId = Integer.parseInt(requestParameters.get("bugId"));
        this.bug = bugsDAO.findOne(bugId);
    }

    @Transactional
    public String updateBugSeverity() {
        try {
            bugsDAO.update(this.bug);
        } catch (OptimisticLockException e) {
            return "bugDetails.xhtml?faces-redirect=true&bugId=" + this.bug.getId() + "&error=optimistic-lock-exception";
        }
        return "bugs.xhtml?projectId=" + this.bug.getProject().getId() + "&faces-redirect=true";
    }
}
