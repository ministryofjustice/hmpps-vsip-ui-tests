package utils;

/**
 * Created by Anusha Nagula on 15/05/23.
 */

public class Configuration {
    private String baseUrl;
    private double timeout;
    public String getBaseUrl() {
        return baseUrl;
    }

    public double getTimeout() {
        return timeout;
    }
    public enum Environment {
        LOCAL, DEV, QA, STAGING
    }
    public static Configuration getConfiguration(Environment environment) {
        switch (environment) {
            case DEV:
                return new Configuration(
                        "https://manage-prison-visits-dev.prison.service.justice.gov.uk/",
                        10
                );
//          Findout local url
            case LOCAL:
                return new Configuration(
                        "http://localhost:3000/",
                        10
                );
//            Not available
//            case QA:
//                return new Configuration(
//                        "https://manage-prison-visits-qa.prison.service.justice.gov.uk/",
//                        10
//                );
            case STAGING:
                return new Configuration(
                        "https://manage-prison-visits-staging.prison.service.justice.gov.uk/",
                        10
                );
            default:
                throw new IllegalArgumentException("Environment '" + environment + "' not known");
        }
    }

    public Configuration(String baseUrl, double timeout) {
        this.baseUrl = baseUrl;
        this.timeout = timeout;
    }
}