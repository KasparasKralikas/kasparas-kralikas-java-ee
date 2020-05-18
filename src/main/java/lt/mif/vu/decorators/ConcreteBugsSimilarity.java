package lt.mif.vu.decorators;

import lt.mif.vu.entities.Bug;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import info.debatty.java.stringsimilarity.*;

public class ConcreteBugsSimilarity implements BugsSimilarity {

    @Override
    public Integer findTheMostSimilar(Bug bug, List<Bug> bugs) {
        System.out.println("Concrete similarity finder is called");

        Levenshtein levenshtein = new Levenshtein();

        List<Integer> similarities = new ArrayList();

        for (Bug b : bugs) {
            similarities.add((int) levenshtein.distance(bug.getTitle(), b.getTitle()));
        }

        Integer smallestValue = Collections.min(similarities);

        Integer similarBugIndex = similarities.indexOf(smallestValue);

        Bug similarBug = bugs.get(similarBugIndex);

        return similarBug.getId();
    }
}
