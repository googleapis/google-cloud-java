/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.storage;

import static com.google.cloud.storage.TestUtils.assertAll;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpResponseException;
import com.google.api.core.NanoClock;
import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.cloud.storage.Conversions.Decoder;
import com.google.cloud.storage.Retrying.DefaultRetrier;
import com.google.cloud.storage.Retrying.HttpRetrier;
import com.google.cloud.storage.Retrying.RetrierWithAlg;
import com.google.cloud.storage.Retrying.RetryingDependencies;
import com.google.cloud.storage.spi.v1.HttpRpcContext;
import io.grpc.Status.Code;
import java.time.Duration;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;
import org.junit.Test;

public final class RetryingTest {
  private static final Pattern UUID_PATTERN =
      Pattern.compile("[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}");

  private static final RetryingDependencies RETRYING_DEPENDENCIES =
      RetryingDependencies.simple(
          NanoClock.getDefaultClock(),
          RetrySettings.newBuilder()
              .setMaxAttempts(3)
              .setInitialRetryDelayDuration(Duration.ofMillis(30))
              .setMaxRetryDelayDuration(Duration.ofSeconds(35))
              .setRetryDelayMultiplier(1.0)
              .build());

  @Test
  public void run() throws Exception {
    ApiException t1 = apiException(Code.UNAVAILABLE, "{unavailable}");
    ApiException t2 = apiException(Code.INTERNAL, "{internal}");
    ApiException t3 = apiException(Code.RESOURCE_EXHAUSTED, "{resource exhausted}");

    AtomicInteger counter = new AtomicInteger(0);
    RetrierWithAlg retrier =
        new DefaultRetrier(UnaryOperator.identity(), RETRYING_DEPENDENCIES)
            .withAlg(Retrying.alwaysRetry());
    StorageException actual =
        assertThrows(
            StorageException.class,
            () ->
                retrier.run(
                    () -> {
                      int i = counter.incrementAndGet();
                      switch (i) {
                        case 1:
                          throw t1;
                        case 2:
                          throw t2;
                        case 3:
                          throw t3;
                        default:
                          throw new RuntimeException("unexpected");
                      }
                    },
                    Decoder.identity()));
    String messages = TestUtils.messagesToText(actual);
    assertAll(
        () ->
            assertThat(messages)
                .contains(
                    "Operation failed to complete within attempt budget (attempts: 3, maxAttempts:"
                        + " 3"),
        () -> assertThat(messages).contains("{unavailable}"),
        () -> assertThat(messages).contains("{internal}"));
  }

  @Test
  public void http() throws Exception {

    RetrierWithAlg retrier =
        new HttpRetrier(new DefaultRetrier(UnaryOperator.identity(), RETRYING_DEPENDENCIES))
            .withAlg(Retrying.alwaysRetry());

    AtomicInteger counter = new AtomicInteger(0);
    StorageException actual =
        assertThrows(
            StorageException.class,
            () ->
                retrier.run(
                    () -> {
                      int i = counter.incrementAndGet();
                      UUID invocationId = HttpRpcContext.getInstance().getInvocationId();
                      switch (i) {
                        case 1:
                          throw apiException(Code.UNAVAILABLE, "{unavailable} " + invocationId);
                        case 2:
                          throw apiException(Code.INTERNAL, "{internal} " + invocationId);
                        case 3:
                          throw apiException(
                              Code.RESOURCE_EXHAUSTED, "{resource exhausted} " + invocationId);
                        default:
                          throw new RuntimeException("unexpected");
                      }
                    },
                    Decoder.identity()));
    String messages = TestUtils.messagesToText(actual);
    assertAll(
        () ->
            assertThat(messages)
                .contains(
                    "Operation failed to complete within attempt budget (attempts: 3, maxAttempts:"
                        + " 3"),
        () -> assertThat(messages).contains("{unavailable}"),
        () -> assertThat(messages).contains("{internal}"),
        () -> assertThat(messages).containsMatch(UUID_PATTERN));
  }

  @Test
  public void http503ThenSuccess_idempotent_retries() throws Exception {
    AtomicInteger counter = new AtomicInteger(0);
    String actual =
        new DefaultRetrier(UnaryOperator.identity(), RETRYING_DEPENDENCIES)
            .run(
                DefaultStorageRetryStrategy.INSTANCE.getIdempotentHandler(),
                () -> {
                  int i = counter.incrementAndGet();
                  if (i < 3) {
                    throw httpResponseException(503, "Service Unavailable");
                  }
                  return "ok";
                },
                Decoder.identity());
    assertAll(
        () -> assertThat(actual).isEqualTo("ok"), () -> assertThat(counter.get()).isEqualTo(3));
  }

  @Test
  public void http503_nonIdempotent_noRetry() throws Exception {
    AtomicInteger counter = new AtomicInteger(0);
    StorageException actual =
        assertThrows(
            StorageException.class,
            () ->
                new DefaultRetrier(UnaryOperator.identity(), RETRYING_DEPENDENCIES)
                    .run(
                        DefaultStorageRetryStrategy.INSTANCE.getNonidempotentHandler(),
                        () -> {
                          counter.incrementAndGet();
                          throw httpResponseException(503, "Service Unavailable");
                        },
                        Decoder.identity()));
    assertAll(
        () -> assertThat(actual.getCode()).isEqualTo(503),
        () -> assertThat(counter.get()).isEqualTo(1));
  }

  @Test
  public void http404_idempotent_noRetry() throws Exception {
    AtomicInteger counter = new AtomicInteger(0);
    StorageException actual =
        assertThrows(
            StorageException.class,
            () ->
                new DefaultRetrier(UnaryOperator.identity(), RETRYING_DEPENDENCIES)
                    .run(
                        DefaultStorageRetryStrategy.INSTANCE.getIdempotentHandler(),
                        () -> {
                          counter.incrementAndGet();
                          throw httpResponseException(404, "Not Found");
                        },
                        Decoder.identity()));
    String messages = TestUtils.messagesToText(actual);
    assertAll(
        () -> assertThat(actual.getCode()).isEqualTo(404),
        () -> assertThat(actual.getCause()).isInstanceOf(HttpResponseException.class),
        () -> assertThat(counter.get()).isEqualTo(1),
        () -> assertThat(messages).contains("Unretryable error"));
  }

  @Test
  public void http503_exhaustsBudget() throws Exception {
    AtomicInteger counter = new AtomicInteger(0);
    StorageException actual =
        assertThrows(
            StorageException.class,
            () ->
                new DefaultRetrier(UnaryOperator.identity(), RETRYING_DEPENDENCIES)
                    .run(
                        DefaultStorageRetryStrategy.INSTANCE.getIdempotentHandler(),
                        () -> {
                          counter.incrementAndGet();
                          throw httpResponseException(503, "Service Unavailable");
                        },
                        Decoder.identity()));
    String messages = TestUtils.messagesToText(actual);
    assertAll(
        () -> assertThat(actual.getCode()).isEqualTo(503),
        () -> assertThat(counter.get()).isEqualTo(3),
        () -> assertThat(messages).contains("Operation failed to complete within attempt budget"));
  }

  private static HttpResponseException httpResponseException(int code, String statusMessage) {
    return new HttpResponseException.Builder(code, statusMessage, new HttpHeaders())
        .setContent("<Error><Code>" + statusMessage + "</Code></Error>")
        .build();
  }

  private static ApiException apiException(Code code, String message) {
    return ApiExceptionFactory.createException(message, null, GrpcStatusCode.of(code), false);
  }
}
