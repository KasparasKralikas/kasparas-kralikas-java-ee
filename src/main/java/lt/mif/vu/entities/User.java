package lt.mif.vu.entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.websocket.server.ServerEndpoint;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lt.mif.vu.entities.Project;

@Entity
@NamedQueries(value = {
        @NamedQuery(name = "User.findAll", query = "select u from User as u")
})
@Table(name = "USER")
@Getter @Setter
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 50)
    @Column(name = "USERNAME")
    private String username;

    @ManyToMany
    @JoinTable(name="USER_PROJECTS")
    private List<Project> projects = new ArrayList<>();

    public User() {
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            return false;
        } else {
            User user = (User) obj;
            return Objects.equals(id, user.id) && Objects.equals(username, user.username);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username);
    }

}
