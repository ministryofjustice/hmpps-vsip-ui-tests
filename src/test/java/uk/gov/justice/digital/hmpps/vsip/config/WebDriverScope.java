package uk.gov.justice.digital.hmpps.vsip.config;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.SimpleThreadScope;

import java.util.Objects;

public class WebDriverScope extends SimpleThreadScope {

    public static final String WEB_DRIVER_SCOPE = "webdriverscope";

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        Object object = super.get(name, objectFactory);
        if (object instanceof RemoteWebDriver remoteWebDriver) {
            SessionId sessionId = remoteWebDriver.getSessionId();
            if (Objects.isNull(sessionId)) {
                super.remove(name);
                // I assume this is when the session expires, recreate a new one
                return super.get(name, objectFactory);
            }
        }
        return object;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {
    }
}