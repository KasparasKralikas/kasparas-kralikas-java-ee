package lt.mif.vu.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Entity
@NamedQueries(value = {
        @NamedQuery(name = "Bug.findAll", query = "select b from Bug b")
})
@Table(name = "BUG")
public class Bug implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 50)
    @Column(name = "TITLE")
    private String title;

    public Bug() {
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            return false;
        } else {
            Bug bug = (Bug) obj;
            return Objects.equals(id, bug.id) && Objects.equals(title, bug.title);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }
}
