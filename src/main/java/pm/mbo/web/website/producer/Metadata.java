package pm.mbo.web.website.producer;

import lombok.Getter;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Properties;

@Named
@ApplicationScoped
public class Metadata implements Serializable {

    private final Properties properties = new Properties();

    @Getter
    private String projectVersion;

    @Getter
    private String buildDate;

    @PostConstruct
    private void init() {
        try (final InputStream in = this.getClass().getClassLoader().getResourceAsStream("metadata.properties")) {
            properties.load(in);
        } catch (IOException e) {
            throw new IllegalStateException("could not load metadata", e);
        }

        projectVersion = properties.getProperty("project.version", "n/a");
        buildDate = properties.getProperty("build.date", "n/a");
    }

}
