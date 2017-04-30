package pm.mbo.web.website.producer;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.Serializable;

@ApplicationScoped
public class EntityManagerFactoryProducer implements Serializable {

    @Produces
    @Default
    @ApplicationScoped
    private EntityManagerFactory createDefaultEmf() {
        return Persistence.createEntityManagerFactory("default");
    }
}
