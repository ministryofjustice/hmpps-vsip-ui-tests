package uk.gov.justice.digital.hmpps.vsip.config;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.SimpleThreadScope;

import java.util.Objects;

public class WebdriverScope extends SimpleThreadScope {
    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        Object object = super.get(name, objectFactory);
        if (object instanceof RemoteWebDriver remoteWebDriver) {
            SessionId sessionId = remoteWebDriver.getSessionId();
            if (Objects.isNull(sessionId)) {
                super.remove(name);
                object = super.get(name, objectFactory);
            }
        }
        return object;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {
    }
}