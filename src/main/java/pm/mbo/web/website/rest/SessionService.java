package pm.mbo.web.website.rest;

import org.jboss.logging.Logger;
import pm.mbo.web.website.SessionBean;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import java.io.IOException;

@Path("/session")
@ApplicationScoped
public class SessionService {

    private static final Logger LOG = Logger.getLogger(SessionService.class);

    @Context
    private HttpServletRequest request;

    @Context
    private HttpServletResponse response;

    @Inject
    private SessionBean sessionBean;

    @GET
    @Path("/template/{template}")
    public void chooseTemplate(@PathParam("template") final String template) throws IOException {
        LOG.debugf("setting template to %s", template);
        sessionBean.setTemplate(template);
        redirectToRoot();
    }

    @GET
    @Path("/language/{lang}")
    public void chooseLanguage(@PathParam("lang") final String lang) throws IOException {
        LOG.debugf("setting language to %s", lang);
        sessionBean.setLanguage(lang);
        redirectToRoot();
    }

    private void redirectToRoot() throws IOException {
        final String redirTarget = request.getRequestURL().toString()
                .replace(request.getRequestURI(), "");
        response.sendRedirect(redirTarget);
    }

}
