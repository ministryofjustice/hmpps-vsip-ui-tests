package uk.gov.justice.digital.hmpps.vsip.services.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.function.Predicate;

@Component
public class PrisonVisitsTestingHelperClient {

    @Qualifier("vsipTestingClient")
    private WebClient webClient;

    @Value("${default.timeout:60s}")
    private Duration apiTimeout;

    public Predicate<HttpStatusCode> statusCreatedHandler = i -> (i.value() == HttpStatus.CREATED.value());

    public void put(String uri, Object dto, Predicate<HttpStatusCode> statusHandler, String errorMessage) {
        webClient.put()
                .uri(uri)
                .body(BodyInserters.fromValue(dto))
                .retrieve().onStatus(statusHandler,error -> Mono.error(new AssertionError(errorMessage))).toBodilessEntity().block(apiTimeout);
    }

}
