package pm.mbo.web.website.initializer;

import org.omnifaces.cdi.Eager;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.io.Serializable;

@Eager
@ApplicationScoped
public class DefaultEmfInitializer implements Serializable {

    @Inject
    private EntityManager em;

    @PostConstruct
    private void init() {
        em.createNativeQuery("SELECT 1").getSingleResult();
    }

}
