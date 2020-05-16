package lt.mif.vu.rest;

import lombok.*;

import lt.mif.vu.entities.Bug;
import lt.mif.vu.persistence.BugsDAO;
import lt.mif.vu.rest.contracts.BugDto;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/bugs")
public class BugsController {

    @Inject
    @Setter @Getter
    private BugsDAO bugsDAO;

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") final Integer id) {
        Bug bug = bugsDAO.findOne(id);
        if (bug == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        BugDto bugDto = new BugDto();
        bugDto.setTitle(bug.getTitle());
        bugDto.setSeverity(bug.getSeverity());
        bugDto.setProjectName(bug.getProject().getName());

        return Response.ok(bugDto).build();
    }
}
