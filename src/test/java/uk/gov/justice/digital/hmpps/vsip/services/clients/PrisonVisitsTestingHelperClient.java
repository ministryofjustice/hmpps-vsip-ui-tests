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
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import uk.gov.justice.digital.hmpps.vsip.services.clients.dto.VisitStatus;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.function.Function;
import java.util.function.Predicate;

@Component
public class PrisonVisitsTestingHelperClient {

    private static final Logger LOG = LoggerFactory.getLogger(PrisonVisitsTestingHelperClient.class);
    public Predicate<HttpStatusCode> validateCreateStatusHandler = i -> (HttpStatus.CREATED.value() != i.value());
    public Predicate<HttpStatusCode> validateOkStatusHandler = i -> (HttpStatus.OK.value() != i.value());
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    @Qualifier("vsipTestingClient")
    private WebClient webClient;
    @Value("${default.timeout:60}")
    private int apiTimeout;

    public void put(String uri, Object dto, Predicate<HttpStatusCode> statusToCheckHandler, String errorMessage) {

        try {
            LOG.debug("Entered put uri:" + uri + " DTO:" + objectMapper.writeValueAsString(dto));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        Function<ClientResponse, Mono<? extends Throwable>> statusHandler = response -> {
            LOG.error("Error PUT failed :" + uri, response.statusCode());
            return Mono.error(new AssertionError(errorMessage));
        };

        var response = webClient.put()
                .uri(uri)
                .body(BodyInserters.fromValue(dto))
                .retrieve()
                .onStatus(statusToCheckHandler, statusHandler)
                .toBodilessEntity();

        try {
            ResponseEntity<Void> results = response.block(Duration.ofSeconds(apiTimeout));
            LOG.error("put  :" + results.getStatusCode());
        } catch(Exception e) {
            LOG.error("Error PUT failed :" + uri, e);
            throw e;
        }
    }

    public void updateModifyTimestamp(String applicationReference, LocalDateTime updatedModifyTimestamp) {
        final var uri = "/test/application/" + applicationReference + "/modifiedTimestamp/" + updatedModifyTimestamp;

        LOG.debug("Enter updateModifyTimestamp {}", uri);

        Function<ClientResponse, Mono<? extends Throwable>> statusHandler = response -> {
            var message = "Error updateModifyTimestamp failed :" + uri + " http_status:" + response.statusCode();
            LOG.error(message);
            return Mono.error(new AssertionError(message));
        };

        var response = webClient.put()
                .uri(uri)
                .retrieve()
                .onStatus(validateOkStatusHandler, statusHandler)
                .toBodilessEntity();

        try {
            ResponseEntity<Void> results = response.block(Duration.ofSeconds(apiTimeout));
            LOG.error("put  :{}", results.getStatusCode());
        } catch(Exception e) {
            LOG.error("Error PUT failed :{}", uri, e);
            throw e;
        }
    }

    public void changeVisitPrison(String bookingReference, String prisonCode) {
        final var uri = "/test/visit/" + bookingReference + "/change/prison/" + prisonCode;
        LOG.debug("Enter changeVisitPrison {}", uri);

        Function<ClientResponse, Mono<? extends Throwable>> statusHandler = response -> {
            var message = "Error changeVisitPrison failed :" + uri + " http_status:" + response.statusCode();
            LOG.error(message);
            return Mono.error(new AssertionError(message));
        };

        var response = webClient.put()
                .uri(uri)
                .retrieve()
                .onStatus(validateOkStatusHandler, statusHandler)
                .toBodilessEntity();

        try {
            ResponseEntity<Void> results = response.block(Duration.ofSeconds(apiTimeout));
            LOG.error("put  :{}", results.getStatusCode());
        } catch(Exception e) {
            LOG.error("Error PUT failed :{}", uri, e);
            throw e;
        }
    }


    public void changeStatus(String bookingReference, VisitStatus status) {

        final var uri = "/test/visit/" + bookingReference + "/status/" + status.name();

        LOG.debug("Enter changeStatus " + uri);

        Function<ClientResponse, Mono<? extends Throwable>> statusHandler = response -> {
            var message = "Error changeStatus failed :" + uri + " http_status:" + response.statusCode();
            LOG.error(message);
            return Mono.error(new AssertionError(message));
        };

        var response = webClient.put()
                .uri(uri)
                .retrieve()
                .onStatus(validateOkStatusHandler, statusHandler)
                .toBodilessEntity();

        try {
            ResponseEntity<Void> results = response.block(Duration.ofSeconds(apiTimeout));
            LOG.error("put  :" + results.getStatusCode());
        } catch(Exception e) {
            LOG.error("Error PUT failed :" + uri, e);
            throw e;
        }
    }

    public void deleteVisits(String bookingReference) {

        final var uri = "/test/visit/" + bookingReference;

        LOG.debug("Enter deleteVisits " + uri);

        Function<ClientResponse, Mono<? extends Throwable>> statusHandler = response -> {
            var message = "Error deleteVisits failed :" + uri + " http_status:" + response.statusCode();
            LOG.error(message);
            return Mono.error(new AssertionError(message));
        };

        var response = webClient.delete()
                .uri(uri)
                .retrieve()
                .onStatus(validateOkStatusHandler, statusHandler)
                .toBodilessEntity();

        try {
            ResponseEntity<Void> results = response.block(Duration.ofSeconds(apiTimeout));
            LOG.error("put  :" + results.getStatusCode());
        } catch(Exception e) {
            LOG.error("Error PUT failed :" + uri, e);
            throw e;
        }
    }

    public void deleteApplication(String applicationReference) {

        final var uri = "/test/application/" + applicationReference;

        LOG.debug("Enter deleteApplication " + uri);

        Function<ClientResponse, Mono<? extends Throwable>> statusHandler = response -> {
            var message = "Error deleteApplication failed :" + uri + " http_status:" + response.statusCode();
            LOG.error(message);
            return Mono.error(new AssertionError(message));
        };

        var response = webClient.delete()
                .uri(uri)
                .retrieve()
                .onStatus(validateOkStatusHandler, statusHandler)
                .toBodilessEntity();

        try {
            ResponseEntity<Void> results = response.block(Duration.ofSeconds(apiTimeout));
            LOG.error("put  :" + results.getStatusCode());
        } catch(Exception e) {
            LOG.error("Error PUT failed :" + uri, e);
            throw e;
        }
    }


    public void changeClosedSessionSlotCapacityForApplication(String applicationReference, Integer capacity) {
        final var uri = "/test/application/"+applicationReference+"/session/capacity/closed/" + capacity;

        LOG.debug("Enter changeClosedSessionSlotCapacityForApplication " + uri);

        Function<ClientResponse, Mono<? extends Throwable>> statusHandler = response -> {
            var message = "Error changeClosedSessionSlotCapacityForApplication failed :" + uri + " http_status:" + response.statusCode();
            LOG.error(message);
            return Mono.error(new AssertionError(message));
        };

        putCall(uri, statusHandler);
    }

    public void changeOpenSessionSlotCapacityForApplication(String applicationReference, Integer capacity) {
        final var uri = "/test/application/"+applicationReference+"/session/capacity/open/" + capacity;

        LOG.debug("Enter changeOpenSessionSlotCapacityForApplication " + uri);

        Function<ClientResponse, Mono<? extends Throwable>> statusHandler = response -> {
            var message = "Error changeOpenSessionSlotCapacityForApplication failed :" + uri + " http_status:" + response.statusCode();
            LOG.error(message);
            return Mono.error(new AssertionError(message));
        };

        putCall(uri, statusHandler);
    }

    private void putCall(String uri, Function<ClientResponse, Mono<? extends Throwable>> statusHandler ) {




        var response = webClient.put()
                .uri(uri)
                .retrieve()
                .onStatus(validateOkStatusHandler, statusHandler)
                .toBodilessEntity();

        try {
            ResponseEntity<Void> results = response.block(Duration.ofSeconds(apiTimeout));
            LOG.error("put  :" + results.getStatusCode());
        } catch(Exception e) {
            LOG.error("Error PUT failed :" + uri, e);
            throw e;
        }
    }

}
