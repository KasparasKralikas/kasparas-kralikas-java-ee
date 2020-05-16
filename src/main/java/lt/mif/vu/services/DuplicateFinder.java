package lt.mif.vu.services;

import org.apache.deltaspike.core.api.future.Futureable;

import javax.ejb.AsyncResult;
import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.concurrent.Future;
import java.util.Random;

@ApplicationScoped
public class DuplicateFinder implements Serializable {

    @Futureable
    public Future<Integer> FindPossibleDuplicate(Integer bugId) {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
        }
        Integer possibleDuplicateId = new Random(bugId).nextInt(100);
        return new AsyncResult<>(possibleDuplicateId);
    }

}
