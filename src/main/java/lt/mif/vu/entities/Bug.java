package lt.mif.vu.entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.websocket.server.ServerEndpoint;
import java.io.Serializable;
import java.util.Objects;

@Entity
@NamedQueries(value = {
        @NamedQuery(name = "Bug.findAll", query = "select b from Bug as b")
})
@Table(name = "BUG")
@Getter @Setter
public class Bug implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 50)
    @Column(name = "TITLE")
    private String title;

    @Column(name = "SEVERITY")
    private Integer severity = 0;

    @ManyToOne
    @JoinColumn(name="PROJECT_ID")
    private Project project;

    @Version
    @Column(name = "OPT_LOCK_VERSION")
    private Integer version;

    public Bug() {
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
