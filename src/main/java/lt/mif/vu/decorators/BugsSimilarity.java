package lt.mif.vu.decorators;

import lt.mif.vu.entities.Bug;

import java.util.List;

public interface BugsSimilarity {
    public Integer findTheMostSimilar(Bug bug, List<Bug> bugs);
}
