package lt.mif.vu.entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Project.findAll", query = "select p from Project as p")
})
@Table(name = "PROJECT")
@Getter @Setter
public class Project {

    public Project() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "project", fetch = FetchType.EAGER)
    private List<Bug> bugs = new ArrayList<>();

    @ManyToMany
    @JoinTable(name="PROJECT_USERS")
    private List<User> users = new ArrayList<>();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            return false;
        } else {
            Project project = (Project) obj;
            return Objects.equals(name, project.name);
        }
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}
