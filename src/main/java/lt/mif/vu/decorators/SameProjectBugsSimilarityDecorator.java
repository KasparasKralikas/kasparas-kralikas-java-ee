package lt.mif.vu.decorators;

import lt.mif.vu.entities.Bug;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import java.util.List;

@Decorator
public class SameProjectBugsSimilarityDecorator implements BugsSimilarity {

    @Inject
    @Delegate
    @Any
    BugsSimilarity bugsSimilarity;

    @Override
    public Integer findTheMostSimilar(Bug bug, List<Bug> bugs) {
        System.out.println("Decorated similarity finder is called");
        bugs.removeIf(b -> b.getProject().getId() != bug.getProject().getId());
        return bugsSimilarity.findTheMostSimilar(bug, bugs);
    }
}
