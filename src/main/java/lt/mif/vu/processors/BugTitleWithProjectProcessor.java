package lt.mif.vu.processors;

import lt.mif.vu.entities.Bug;

import javax.enterprise.inject.Alternative;

@Alternative
public class BugTitleWithProjectProcessor implements BugTitleProcessor {

    @Override
    public void process(Bug bug) {
        String newTitle = "[" + bug.getProject().getName() + "]" + bug.getTitle();
        bug.setTitle(newTitle);
    }
}
