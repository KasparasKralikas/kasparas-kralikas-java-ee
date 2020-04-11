package lt.mif.vu.entities;

import java.io.Serializable;

public class Bug implements Serializable {

    private int id;

    private String title;

    public Bug(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
