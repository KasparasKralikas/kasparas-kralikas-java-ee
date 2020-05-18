package lt.mif.vu.processors;

import lt.mif.vu.entities.Bug;

import java.io.Serializable;

public interface BugTitleProcessor extends Serializable {
    void process(Bug bug);
}
