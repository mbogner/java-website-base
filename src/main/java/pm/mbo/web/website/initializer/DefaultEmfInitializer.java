package pm.mbo.web.website.initializer;

import org.jboss.logging.Logger;
import org.omnifaces.cdi.Eager;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.io.Serializable;

@Eager
@ApplicationScoped
public class DefaultEmfInitializer implements Serializable {

    private static final Logger LOG = Logger.getLogger(DefaultEmfInitializer.class);

    @Inject
    private EntityManager em;

    @PostConstruct
    private void init() {
        LOG.debugf("init %s", this.getClass().getSimpleName());
        em.createNativeQuery("SELECT 1").getSingleResult();
    }

}
