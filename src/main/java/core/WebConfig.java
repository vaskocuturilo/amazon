package core;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;
import org.aeonbits.owner.Reloadable;

public interface WebConfig extends Config, Reloadable {

    WebConfig BASE_CONFIG = ConfigFactory.create(WebConfig.class, System.getenv(), System.getProperties());

    @Key("url")
    @DefaultValue("http://localhost")
    String url();

    @Key("regexpGroup")
    @DefaultValue("1")
    int regexpGroup();
}
