package lt.mif.vu.persistence;

import lt.mif.vu.entities.Bug;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class BugsDAO {
    @Inject
    private EntityManager em;

    public List<Bug> loadAll() {
        return em.createNamedQuery("Bug.findAll", Bug.class).getResultList();
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void persist(Bug bug) {
        this.em.persist(bug);
    }

    public Bug findOne(Integer id){
        return em.find(Bug.class, id);
    }

    public Bug update(Bug bug){
        return em.merge(bug);
    }
}

