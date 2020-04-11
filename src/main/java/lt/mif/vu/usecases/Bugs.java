package lt.mif.vu.usecases;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lt.mif.vu.entities.Bug;

@Model
public class Bugs implements Serializable {

    private List<Bug> bugs;
    @PostConstruct
    public void init() {
        loadBugs();
    }

    public void loadBugs() {
        // TODO connect a real data store, this is just a mock
        List<Bug> newBugs = new ArrayList<Bug>();
        newBugs.add(new Bug(1, "Test Bug 1"));
        newBugs.add(new Bug(2, "Test Bug 2"));
        this.bugs = newBugs;
    }

    public List<Bug> getBugs() {
        return bugs;
    }
}
