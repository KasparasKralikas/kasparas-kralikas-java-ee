package lt.mif.vu.processors;

import lt.mif.vu.entities.Bug;

import javax.enterprise.inject.Alternative;

@Alternative
public class BugTitleWithIdProcessor implements BugTitleProcessor {
    @Override
    public void process(Bug bug) {
        String newTitle = "[ID: " + bug.getId() + "]" + bug.getTitle();
        bug.setTitle(newTitle);
    }
}
