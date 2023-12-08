package uk.gov.justice.digital.hmpps.vsip.util;

/**
 * Created by Anusha Nagula on 15/05/23.
 */
public class Configuration {
    private final String baseUrl;
    private final int timeout;

    public Configuration(String baseUrl, int timeout) {
        this.baseUrl = baseUrl;
        this.timeout = timeout;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public int getTimeOut() {
        return timeout;
    }
}