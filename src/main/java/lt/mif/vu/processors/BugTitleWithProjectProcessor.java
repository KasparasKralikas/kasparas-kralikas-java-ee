package lt.mif.vu.processors;

import lt.mif.vu.entities.Bug;

import javax.enterprise.inject.Alternative;

@Alternative
public class BugTitleWithProjectProcessor implements BugTitleProcessor {

    protected String getProjectName(Bug bug) {
        return bug.getProject().getName();
    }

    @Override
    public void process(Bug bug) {
        String newTitle = "[" + getProjectName(bug) + "]" + bug.getTitle();
        bug.setTitle(newTitle);
    }
}
