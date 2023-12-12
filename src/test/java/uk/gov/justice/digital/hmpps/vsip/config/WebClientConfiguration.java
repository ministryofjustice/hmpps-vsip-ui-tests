package uk.gov.justice.digital.hmpps.vsip.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.codec.ClientCodecConfigurer;
import org.springframework.http.codec.support.DefaultClientCodecConfigurer;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProviderBuilder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.reactive.function.client.ServletOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.web.reactive.function.client.ServletOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.security.oauth2.client.AuthorizedClientServiceOAuth2AuthorizedClientManager;

@Configuration
public class WebClientConfiguration {

    private static final String CLIENT_REGISTRATION_ID = "hmpps-apis";

    @Value("${vsip.test-api.url}")
    private String vsipTestUrl;

    public WebClientConfiguration() {

    }

    @PostConstruct
    public void get() {
        "aled".toLowerCase();
    }

    @Bean("vsipTestingClient")
    public WebClient vsipTestingClient(OAuth2AuthorizedClientManager authorizedClientManager) {
        return getWebClient(vsipTestUrl, authorizedClientManager);
    }

    private WebClient getWebClient(String baseUrl, OAuth2AuthorizedClientManager authorizedClientManager) {

        var oauth2Client = new ServletOAuth2AuthorizedClientExchangeFilterFunction(authorizedClientManager);
        oauth2Client.setDefaultClientRegistrationId(CLIENT_REGISTRATION_ID);

        return WebClient.builder()
                .baseUrl(baseUrl)
                .apply(oauth2Client.oauth2Configuration())
                .exchangeStrategies(getExchangeStrategies())
                .build();
    }

    private ExchangeStrategies getExchangeStrategies() {
        return ExchangeStrategies.builder()
                .codecs(configurer -> {
                    ClientCodecConfigurer.create().defaultCodecs().maxInMemorySize(-1);
                })
                .build();
    }

    @Bean
    public OAuth2AuthorizedClientManager authorizedClientManager(
            ClientRegistrationRepository clientRegistrationRepository,
            OAuth2AuthorizedClientService oAuth2AuthorizedClientService
            )  {
        var authorizedClientProvider = OAuth2AuthorizedClientProviderBuilder.builder().clientCredentials().build();
        var authorizedClientManager = new AuthorizedClientServiceOAuth2AuthorizedClientManager(clientRegistrationRepository, oAuth2AuthorizedClientService);
        authorizedClientManager.setAuthorizedClientProvider(authorizedClientProvider);
        return authorizedClientManager;
    }
}