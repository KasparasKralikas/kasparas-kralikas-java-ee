package lt.mif.vu.usecases;

import lt.mif.vu.services.DuplicateFinder;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@SessionScoped
@Named
public class FindPossibleDuplicate implements Serializable {

    @Inject
    DuplicateFinder duplicateFinder;

    private Future<Integer> duplicateFindingTask = null;

    public String findPossibleDuplicate() {
        Map<String, String> requestParameters = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String bugIdParameter = requestParameters.get("bugId");
        duplicateFindingTask = duplicateFinder.FindPossibleDuplicate(Integer.parseInt(bugIdParameter));
        return  "/bugDetails.xhtml?faces-redirect=true&bugId=" + bugIdParameter;
    }

    public boolean isDuplicateFindingRunning() {
        return duplicateFindingTask != null && !duplicateFindingTask.isDone();
    }

    public String getDuplicateFindingStatus() throws ExecutionException, InterruptedException {
        if (duplicateFindingTask == null) {
            return null;
        } else if (isDuplicateFindingRunning()) {
            return "Duplicate finding is in progress...";
        }
        return "Possible duplicate id: " + duplicateFindingTask.get();
    }
}
