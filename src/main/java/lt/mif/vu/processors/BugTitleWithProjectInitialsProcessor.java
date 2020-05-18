package lt.mif.vu.processors;

import lt.mif.vu.entities.Bug;

import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Specializes;

@Specializes
@Alternative
public class BugTitleWithProjectInitialsProcessor extends BugTitleWithProjectProcessor {

    protected String getProjectName(Bug bug) {
        String projectName = super.getProjectName(bug);
        String[] nameWords = projectName.split(" ");
        String initials = "";
        for (String word : nameWords) {
            initials += word.charAt(0);
        }
        return initials;
    }
}
