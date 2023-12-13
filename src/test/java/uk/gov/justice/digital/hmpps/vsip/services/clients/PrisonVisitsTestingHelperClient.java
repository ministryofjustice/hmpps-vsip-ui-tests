package uk.gov.justice.digital.hmpps.vsip.services.clients;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.function.Function;
import java.util.function.Predicate;

@Component
public class PrisonVisitsTestingHelperClient {

    private static final Logger LOG = LoggerFactory.getLogger(PrisonVisitsTestingHelperClient.class);

    @Autowired
    @Qualifier("vsipTestingClient")
    private WebClient webClient;

    @Value("${default.timeout:60}")
    private int apiTimeout;

    @Autowired
    ObjectMapper objectMapper;

    public Predicate<HttpStatusCode> validateCreateStatusHandler = i -> (HttpStatus.CREATED.value() != i.value());

    public void put(String uri, Object dto, Predicate<HttpStatusCode> statusToCheckHandler, String errorMessage) {

        try {
            LOG.debug("Entered put uri:" + uri + " DTO:" + objectMapper.writeValueAsString(dto));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        Function<ClientResponse, Mono<? extends Throwable>> statusHandler = response -> {
            LOG.error("Error PUT failed :" + uri,response.statusCode());
            return Mono.error(new AssertionError(errorMessage));
        };

        var response = webClient.put()
                .uri(uri)
                .body(BodyInserters.fromValue(dto))
                .retrieve()
                .onStatus(statusToCheckHandler,statusHandler)
                .toBodilessEntity()
                .onErrorResume(e -> {
                    LOG.error("Error PUT failed :" + uri,e);
                    return Mono.error(e);});

        response.block(Duration.ofSeconds(apiTimeout));
    }

}
