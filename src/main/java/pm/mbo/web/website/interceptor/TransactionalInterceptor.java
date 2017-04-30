package pm.mbo.web.website.interceptor;

import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import java.io.Serializable;

@Transactional
@Interceptor
public class TransactionalInterceptor implements Serializable {

    private static final Logger LOG = Logger.getLogger(TransactionalInterceptor.class);

    @Inject
    private EntityManager em;

    @AroundInvoke
    public Object method(final InvocationContext ctx) throws Exception {
        try {
            if (!em.getTransaction().isActive()) {
                LOG.debug("start transaction");
                em.getTransaction().begin();
            }
            return ctx.proceed();
        } catch (final Exception exc) {
            throw exc;
        } finally {
            if (em.getTransaction().getRollbackOnly()) {
                LOG.debug("rollback transaction");
                em.getTransaction().rollback();
            } else {
                if (em.getTransaction().isActive()) {
                    LOG.debug("commit transaction");
                    em.getTransaction().commit();
                }
            }
        }
    }

}
