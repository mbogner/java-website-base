package pm.mbo.web.website.producer;

import lombok.Getter;
import org.jboss.logging.Logger;
import org.omnifaces.cdi.Eager;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Properties;

@Eager
@Named
@ApplicationScoped
public class Metadata implements Serializable {

    private static final Logger LOG = Logger.getLogger(Metadata.class);

    private final Properties properties = new Properties();

    @Getter
    private String projectVersion;

    @Getter
    private String buildDate;

    @PostConstruct
    private void init() {
        LOG.debugf("init %s", this.getClass().getSimpleName());
        try (final InputStream in = this.getClass().getClassLoader().getResourceAsStream("metadata.properties")) {
            properties.load(in);
        } catch (IOException e) {
            throw new IllegalStateException("could not load metadata", e);
        }

        projectVersion = properties.getProperty("project.version", "n/a");
        buildDate = properties.getProperty("build.date", "n/a");
    }

}
