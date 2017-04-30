package pm.mbo.web.website;

import lombok.Getter;
import org.jboss.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

@Named
@RequestScoped
public class IndexController {

    private static final Logger LOG = Logger.getLogger(IndexController.class);

    @Inject
    private EntityManager em;

    @Getter
    private String name = "TEST";

}
