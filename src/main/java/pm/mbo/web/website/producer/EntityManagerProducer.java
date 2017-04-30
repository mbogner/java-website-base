package pm.mbo.web.website.producer;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.io.Serializable;

@ApplicationScoped
public class EntityManagerProducer implements Serializable {

    @Produces
    @Default
    @RequestScoped
    private EntityManager createDefaultEntityManager(final EntityManagerFactory defaultEmf) {
        return defaultEmf.createEntityManager();
    }

}
