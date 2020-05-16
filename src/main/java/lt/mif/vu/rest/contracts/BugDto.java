package lt.mif.vu.rest.contracts;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BugDto {

    private String Title;

    private Integer Severity;

    private Integer ProjectId;
}
