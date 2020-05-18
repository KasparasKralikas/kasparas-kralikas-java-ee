package lt.mif.vu.services;

import lombok.*;

import lt.mif.vu.decorators.BugsSimilarity;
import lt.mif.vu.entities.Bug;
import lt.mif.vu.persistence.BugsDAO;
import org.apache.deltaspike.core.api.future.Futureable;

import javax.ejb.AsyncResult;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.Future;
import java.util.Random;

@ApplicationScoped
public class DuplicateFinder implements Serializable {

    @Inject
    private BugsSimilarity bugsSimilarity;

    @Inject
    @Setter @Getter
    private BugsDAO bugsDAO;

    @Futureable
    public Future<Integer> FindPossibleDuplicate(Integer bugId) {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
        }

        List<Bug> bugs = bugsDAO.loadAll();

        Bug targetBug = bugsDAO.findOne(bugId);

        bugs.removeIf(bug -> bug.getId() == targetBug.getId());

        //Integer possibleDuplicateId = new Random(bugId).nextInt(100);
        Integer possibleDuplicateId = bugsSimilarity.findTheMostSimilar(targetBug, bugs);
        return new AsyncResult<>(possibleDuplicateId);
    }

}
