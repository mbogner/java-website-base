package pm.mbo.web.website;

import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class SessionBean implements Serializable {

    @Getter
    @Setter
    private String language = "de";

    @Getter
    @Setter
    private String template = "default";

}
