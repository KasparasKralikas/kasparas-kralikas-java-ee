package lt.mif.vu.usecases;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lt.mif.vu.entities.Bug;
import lt.mif.vu.persistence.BugsDAO;

@Model
public class Bugs implements Serializable {

    private BugsDAO bugsDAO;

    private Bug bugToCreate = new Bug();

    private List<Bug> bugs;
    @PostConstruct
    public void init() {
        loadBugs();
    }

    public void loadBugs() {
        this.bugs = bugsDAO.loadAll();
    }

    public List<Bug> getBugs() {
        return bugs;
    }

    @Transactional
    public String createBug() {
        this.bugsDAO.persist(bugToCreate);
        return "success";
    }

    public Bug getBugToCreate() {
        return bugToCreate;
    }

    public void setBugToCreate(Bug bugToCreate) {
        this.bugToCreate = bugToCreate;
    }

}
