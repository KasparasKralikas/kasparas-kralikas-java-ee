package lt.mif.vu.persistence;

import lt.mif.vu.entities.Project;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class ProjectsDAO {

    @PersistenceContext
    private EntityManager em;

    public List<Project> loadAll() {
        return em.createNamedQuery("Project.findAll", Project.class).getResultList();
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void persist(Project project) {
        this.em.persist(project);
    }

    public Project findOne(Integer id) { return em.find(Project.class, id); }

}
