/*
 * Copyright 2017 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.google.api.gax.httpjson;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpMethods;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.http.HttpStatusCodes;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.FakeApiClock;
import com.google.api.gax.core.RecordingScheduler;
import com.google.api.gax.httpjson.testing.TestApiTracerFactory;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.FailedPreconditionException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StatusCode.Code;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.gax.rpc.UnknownException;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.UncheckedExecutionException;
import com.google.protobuf.TypeRegistry;
import java.util.Set;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

class RetryingTest {

  @SuppressWarnings("unchecked")
  private final UnaryCallable<Integer, Integer> callInt = Mockito.mock(UnaryCallable.class);

  private final ApiMethodDescriptor<Integer, Integer> FAKE_METHOD_DESCRIPTOR_FOR_REQUEST_MUTATOR =
      ApiMethodDescriptor.newBuilder()
          .setFullMethodName("google.cloud.v1.Fake/FakeMethodForRequestMutator")
          .setHttpMethod(HttpMethods.POST)
          .setRequestFormatter(Mockito.mock(HttpRequestFormatter.class))
          .setResponseParser(Mockito.mock(HttpResponseParser.class))
          .build();

  private final Integer initialRequest = 1;
  private final Integer modifiedRequest = 0;
  private TestApiTracerFactory tracerFactory;

  private final HttpJsonCallSettings<Integer, Integer> httpJsonCallSettings =
      HttpJsonCallSettings.<Integer, Integer>newBuilder()
          .setRequestMutator(request -> modifiedRequest)
          .setMethodDescriptor(FAKE_METHOD_DESCRIPTOR_FOR_REQUEST_MUTATOR)
          .setTypeRegistry(TypeRegistry.newBuilder().build())
          .build();

  private RecordingScheduler executor;
  private FakeApiClock fakeClock;
  private ClientContext clientContext;
  private static final int HTTP_CODE_PRECONDITION_FAILED = 412;

  private HttpResponseException HTTP_SERVICE_UNAVAILABLE_EXCEPTION =
      new HttpResponseException.Builder(
              HttpStatusCodes.STATUS_CODE_SERVICE_UNAVAILABLE,
              "server unavailable",
              new HttpHeaders())
          .build();

  private static final RetrySettings FAST_RETRY_SETTINGS =
      RetrySettings.newBuilder()
          .setInitialRetryDelayDuration(java.time.Duration.ofMillis(2L))
          .setRetryDelayMultiplier(1)
          .setMaxRetryDelayDuration(java.time.Duration.ofMillis(2L))
          .setInitialRpcTimeoutDuration(java.time.Duration.ofMillis(2L))
          .setRpcTimeoutMultiplier(1)
          .setMaxRpcTimeoutDuration(java.time.Duration.ofMillis(2L))
          .setTotalTimeoutDuration(java.time.Duration.ofMillis(10L))
          .build();

  @BeforeEach
  void resetClock() {
    fakeClock = new FakeApiClock(System.nanoTime());
    executor = RecordingScheduler.create(fakeClock);
    tracerFactory = new TestApiTracerFactory();
    clientContext =
        ClientContext.newBuilder()
            // we use a custom tracer to confirm whether the retrials are being recorded.
            .setTracerFactory(tracerFactory)
            .setExecutor(executor)
            .setClock(fakeClock)
            .setDefaultCallContext(HttpJsonCallContext.createDefault())
            .build();
  }

  @AfterEach
  void teardown() {
    executor.shutdownNow();
  }

  @Test
  void retry() {
    // set a retriable that will fail 3 times before returning "2"
    ImmutableSet<StatusCode.Code> retryable = ImmutableSet.of(Code.UNAVAILABLE);
    Mockito.when(callInt.futureCall((Integer) any(), (ApiCallContext) any()))
        .thenReturn(ApiFutures.<Integer>immediateFailedFuture(HTTP_SERVICE_UNAVAILABLE_EXCEPTION))
        .thenReturn(ApiFutures.<Integer>immediateFailedFuture(HTTP_SERVICE_UNAVAILABLE_EXCEPTION))
        .thenReturn(ApiFutures.<Integer>immediateFailedFuture(HTTP_SERVICE_UNAVAILABLE_EXCEPTION))
        .thenReturn(ApiFutures.<Integer>immediateFuture(2));

    UnaryCallSettings<Integer, Integer> callSettings =
        createSettings(retryable, FAST_RETRY_SETTINGS);
    UnaryCallable<Integer, Integer> callable =
        HttpJsonCallableFactory.createUnaryCallable(
            callInt, callSettings, httpJsonCallSettings, clientContext);
    assertThat(callable.call(initialRequest)).isEqualTo(2);
    assertThat(tracerFactory.getInstance().getAttemptsFailed().get()).isEqualTo(3);
    assertThat(tracerFactory.getInstance().getAttemptsStarted().get()).isEqualTo(4);
    assertThat(tracerFactory.getInstance().getRetriesExhausted().get()).isFalse();

    // Capture the argument passed to futureCall
    ArgumentCaptor<Integer> argumentCaptor = ArgumentCaptor.forClass(Integer.class);
    verify(callInt, atLeastOnce()).futureCall(argumentCaptor.capture(), any(ApiCallContext.class));
    assertThat(argumentCaptor.getAllValues()).containsExactly(0, 0, 0, 0).inOrder();
  }

  @Test
  void retryTotalTimeoutExceeded() {
    ImmutableSet<StatusCode.Code> retryable = ImmutableSet.of(Code.UNAVAILABLE);
    HttpResponseException httpResponseException =
        new HttpResponseException.Builder(
                HttpStatusCodes.STATUS_CODE_SERVICE_UNAVAILABLE,
                "server unavailable",
                new HttpHeaders())
            .build();
    ApiException apiException =
        ApiExceptionFactory.createException(
            "foobar",
            httpResponseException,
            HttpJsonStatusCode.of(Code.FAILED_PRECONDITION),
            false);
    Mockito.when(callInt.futureCall((Integer) any(), (ApiCallContext) any()))
        .thenReturn(ApiFutures.<Integer>immediateFailedFuture(apiException))
        .thenReturn(ApiFutures.<Integer>immediateFuture(2));

    RetrySettings retrySettings =
        FAST_RETRY_SETTINGS.toBuilder()
            .setInitialRetryDelayDuration(java.time.Duration.ofMillis(Integer.MAX_VALUE))
            .setMaxRetryDelayDuration(java.time.Duration.ofMillis(Integer.MAX_VALUE))
            .build();
    UnaryCallSettings<Integer, Integer> callSettings = createSettings(retryable, retrySettings);
    UnaryCallable<Integer, Integer> callable =
        HttpJsonCallableFactory.createUnaryCallable(
            callInt, callSettings, httpJsonCallSettings, clientContext);
    assertThrows(ApiException.class, () -> callable.call(initialRequest));
    assertThat(tracerFactory.getInstance().getAttemptsStarted().get()).isEqualTo(1);
    assertThat(tracerFactory.getInstance().getAttemptsFailed().get()).isEqualTo(0);
    assertThat(tracerFactory.getInstance().getRetriesExhausted().get()).isFalse();
    // Capture the argument passed to futureCall
    ArgumentCaptor<Integer> argumentCaptor = ArgumentCaptor.forClass(Integer.class);
    verify(callInt, atLeastOnce()).futureCall(argumentCaptor.capture(), any(ApiCallContext.class));
    assertThat(argumentCaptor.getAllValues()).containsExactly(0);
  }

  @Test
  void retryMaxAttemptsExceeded() {
    ImmutableSet<StatusCode.Code> retryable = ImmutableSet.of(Code.UNAVAILABLE);
    Mockito.when(callInt.futureCall((Integer) any(), (ApiCallContext) any()))
        .thenReturn(ApiFutures.<Integer>immediateFailedFuture(HTTP_SERVICE_UNAVAILABLE_EXCEPTION))
        .thenReturn(ApiFutures.<Integer>immediateFailedFuture(HTTP_SERVICE_UNAVAILABLE_EXCEPTION))
        .thenReturn(ApiFutures.<Integer>immediateFuture(2));

    RetrySettings retrySettings = FAST_RETRY_SETTINGS.toBuilder().setMaxAttempts(2).build();
    UnaryCallSettings<Integer, Integer> callSettings = createSettings(retryable, retrySettings);
    UnaryCallable<Integer, Integer> callable =
        HttpJsonCallableFactory.createUnaryCallable(
            callInt, callSettings, httpJsonCallSettings, clientContext);
    assertThrows(ApiException.class, () -> callable.call(initialRequest));
    assertThat(tracerFactory.getInstance().getAttemptsStarted().get()).isEqualTo(2);
    assertThat(tracerFactory.getInstance().getAttemptsFailed().get()).isEqualTo(2);
    assertThat(tracerFactory.getInstance().getRetriesExhausted().get()).isTrue();
    // Capture the argument passed to futureCall
    ArgumentCaptor<Integer> argumentCaptor = ArgumentCaptor.forClass(Integer.class);
    verify(callInt, atLeastOnce()).futureCall(argumentCaptor.capture(), any(ApiCallContext.class));
    assertThat(argumentCaptor.getAllValues()).containsExactly(0, 0).inOrder();
  }

  @Test
  void retryWithinMaxAttempts() {
    ImmutableSet<StatusCode.Code> retryable = ImmutableSet.of(Code.UNAVAILABLE);
    Mockito.when(callInt.futureCall((Integer) any(), (ApiCallContext) any()))
        .thenReturn(ApiFutures.<Integer>immediateFailedFuture(HTTP_SERVICE_UNAVAILABLE_EXCEPTION))
        .thenReturn(ApiFutures.<Integer>immediateFailedFuture(HTTP_SERVICE_UNAVAILABLE_EXCEPTION))
        .thenReturn(ApiFutures.<Integer>immediateFuture(2));

    RetrySettings retrySettings = FAST_RETRY_SETTINGS.toBuilder().setMaxAttempts(3).build();
    UnaryCallSettings<Integer, Integer> callSettings = createSettings(retryable, retrySettings);
    UnaryCallable<Integer, Integer> callable =
        HttpJsonCallableFactory.createUnaryCallable(
            callInt, callSettings, httpJsonCallSettings, clientContext);
    assertThat(callable.call(initialRequest)).isEqualTo(2);
    assertThat(tracerFactory.getInstance().getAttemptsStarted().get()).isEqualTo(3);
    assertThat(tracerFactory.getInstance().getAttemptsFailed().get()).isEqualTo(2);
    assertThat(tracerFactory.getInstance().getRetriesExhausted().get()).isFalse();
    // Capture the argument passed to futureCall
    ArgumentCaptor<Integer> argumentCaptor = ArgumentCaptor.forClass(Integer.class);
    verify(callInt, atLeastOnce()).futureCall(argumentCaptor.capture(), any(ApiCallContext.class));
    assertThat(argumentCaptor.getAllValues()).containsExactly(0, 0, 0).inOrder();
  }

  @Test
  void retryOnStatusUnknown() {
    ImmutableSet<StatusCode.Code> retryable = ImmutableSet.of(Code.UNKNOWN);
    HttpResponseException throwable =
        new HttpResponseException.Builder(
                HttpStatusCodes.STATUS_CODE_TEMPORARY_REDIRECT,
                "temporary redirect",
                new HttpHeaders())
            .build();
    Mockito.when(callInt.futureCall((Integer) any(), (ApiCallContext) any()))
        .thenReturn(ApiFutures.<Integer>immediateFailedFuture(throwable))
        .thenReturn(ApiFutures.<Integer>immediateFailedFuture(throwable))
        .thenReturn(ApiFutures.<Integer>immediateFailedFuture(throwable))
        .thenReturn(ApiFutures.<Integer>immediateFuture(2));
    UnaryCallSettings<Integer, Integer> callSettings =
        createSettings(retryable, FAST_RETRY_SETTINGS);
    UnaryCallable<Integer, Integer> callable =
        HttpJsonCallableFactory.createUnaryCallable(
            callInt, callSettings, httpJsonCallSettings, clientContext);
    assertThat(callable.call(initialRequest)).isEqualTo(2);
    assertThat(tracerFactory.getInstance().getAttemptsStarted().get()).isEqualTo(4);
    assertThat(tracerFactory.getInstance().getAttemptsFailed().get()).isEqualTo(3);
    assertThat(tracerFactory.getInstance().getRetriesExhausted().get()).isFalse();
    // Capture the argument passed to futureCall
    ArgumentCaptor<Integer> argumentCaptor = ArgumentCaptor.forClass(Integer.class);
    verify(callInt, atLeastOnce()).futureCall(argumentCaptor.capture(), any(ApiCallContext.class));
    assertThat(argumentCaptor.getAllValues()).containsExactly(0, 0, 0, 0).inOrder();
  }

  @Test
  void retryOnUnexpectedException() {
    ImmutableSet<StatusCode.Code> retryable = ImmutableSet.of(Code.UNKNOWN);
    Throwable throwable = new RuntimeException("foobar");
    Mockito.when(callInt.futureCall((Integer) any(), (ApiCallContext) any()))
        .thenReturn(ApiFutures.<Integer>immediateFailedFuture(throwable));
    UnaryCallSettings<Integer, Integer> callSettings =
        createSettings(retryable, FAST_RETRY_SETTINGS);
    UnaryCallable<Integer, Integer> callable =
        HttpJsonCallableFactory.createUnaryCallable(
            callInt, callSettings, httpJsonCallSettings, clientContext);
    ApiException exception = assertThrows(ApiException.class, () -> callable.call(initialRequest));
    assertThat(tracerFactory.getInstance().getAttemptsStarted().get()).isEqualTo(1);
    assertThat(tracerFactory.getInstance().getAttemptsFailed().get()).isEqualTo(0);
    assertThat(tracerFactory.getInstance().getRetriesExhausted().get()).isFalse();
    assertThat(exception).hasCauseThat().isSameInstanceAs(throwable);
    // Capture the argument passed to futureCall
    ArgumentCaptor<Integer> argumentCaptor = ArgumentCaptor.forClass(Integer.class);
    verify(callInt, atLeastOnce()).futureCall(argumentCaptor.capture(), any(ApiCallContext.class));
    assertThat(argumentCaptor.getAllValues()).containsExactly(0).inOrder();
  }

  @Test
  void retryNoRecover() {
    ImmutableSet<StatusCode.Code> retryable = ImmutableSet.of(Code.UNAVAILABLE);
    HttpResponseException httpResponseException =
        new HttpResponseException.Builder(
                HTTP_CODE_PRECONDITION_FAILED, "foobar", new HttpHeaders())
            .build();
    ApiException apiException =
        ApiExceptionFactory.createException(
            "foobar",
            httpResponseException,
            HttpJsonStatusCode.of(Code.FAILED_PRECONDITION),
            false);
    Mockito.when(callInt.futureCall((Integer) any(), (ApiCallContext) any()))
        .thenReturn(ApiFutures.<Integer>immediateFailedFuture(apiException))
        .thenReturn(ApiFutures.<Integer>immediateFuture(2));
    UnaryCallSettings<Integer, Integer> callSettings =
        createSettings(retryable, FAST_RETRY_SETTINGS);
    UnaryCallable<Integer, Integer> callable =
        HttpJsonCallableFactory.createUnaryCallable(
            callInt, callSettings, httpJsonCallSettings, clientContext);
    ApiException exception = assertThrows(ApiException.class, () -> callable.call(initialRequest));
    assertThat(tracerFactory.getInstance().getAttemptsStarted().get()).isEqualTo(1);
    assertThat(tracerFactory.getInstance().getAttemptsFailed().get()).isEqualTo(0);
    assertThat(tracerFactory.getInstance().getRetriesExhausted().get()).isFalse();
    assertThat(exception).isSameInstanceAs(apiException);
    // Capture the argument passed to futureCall
    ArgumentCaptor<Integer> argumentCaptor = ArgumentCaptor.forClass(Integer.class);
    verify(callInt, atLeastOnce()).futureCall(argumentCaptor.capture(), any(ApiCallContext.class));
    assertThat(argumentCaptor.getAllValues()).containsExactly(0);
  }

  @Test
  void retryKeepFailing() {
    ImmutableSet<StatusCode.Code> retryable = ImmutableSet.of(Code.UNAVAILABLE);
    HttpResponseException throwable =
        new HttpResponseException.Builder(
                HttpStatusCodes.STATUS_CODE_SERVICE_UNAVAILABLE, "Unavailable", new HttpHeaders())
            .build();
    Mockito.when(callInt.futureCall((Integer) any(), (ApiCallContext) any()))
        .thenReturn(ApiFutures.<Integer>immediateFailedFuture(throwable));
    UnaryCallSettings<Integer, Integer> callSettings =
        createSettings(retryable, FAST_RETRY_SETTINGS);
    UnaryCallable<Integer, Integer> callable =
        HttpJsonCallableFactory.createUnaryCallable(
            callInt, callSettings, httpJsonCallSettings, clientContext);
    // Need to advance time inside the call.
    ApiFuture<Integer> future = callable.futureCall(initialRequest);

    UncheckedExecutionException exception =
        assertThrows(UncheckedExecutionException.class, () -> Futures.getUnchecked(future));
    assertThat(tracerFactory.getInstance().getAttemptsFailed().get()).isGreaterThan(0);
    assertThat(tracerFactory.getInstance().getAttemptsFailed().get())
        .isEqualTo(tracerFactory.getInstance().getAttemptsStarted().get());
    assertThat(tracerFactory.getInstance().getRetriesExhausted().get()).isTrue();
    assertThat(exception).hasCauseThat().isInstanceOf(ApiException.class);
    assertThat(exception).hasCauseThat().hasMessageThat().contains("Unavailable");
    // Capture the argument passed to futureCall
    ArgumentCaptor<Integer> argumentCaptor = ArgumentCaptor.forClass(Integer.class);
    verify(callInt, atLeastOnce()).futureCall(argumentCaptor.capture(), any(ApiCallContext.class));
    assertThat(argumentCaptor.getValue()).isEqualTo(0);
  }

  @Test
  void testKnownStatusCode() {
    ImmutableSet<StatusCode.Code> retryable = ImmutableSet.of(Code.UNAVAILABLE);
    String throwableMessage =
        "{\n"
            + " \"error\": {\n"
            + "  \"errors\": [\n"
            + "   {\n"
            + "    \"domain\": \"global\",\n"
            + "    \"reason\": \"FAILED_PRECONDITION\",\n"
            + "   }\n"
            + "  ],\n"
            + "  \"code\": 400,\n"
            + "  \"message\": \"Failed precondition.\"\n"
            + " }\n"
            + "}";
    HttpResponseException throwable =
        new HttpResponseException.Builder(
                HTTP_CODE_PRECONDITION_FAILED, "precondition failed", new HttpHeaders())
            .setMessage(throwableMessage)
            .build();
    Mockito.when(callInt.futureCall((Integer) any(), (ApiCallContext) any()))
        .thenReturn(ApiFutures.<Integer>immediateFailedFuture(throwable));
    UnaryCallSettings<Integer, Integer> callSettings =
        UnaryCallSettings.<Integer, Integer>newUnaryCallSettingsBuilder()
            .setRetryableCodes(retryable)
            .build();
    UnaryCallable<Integer, Integer> callable =
        HttpJsonCallableFactory.createUnaryCallable(
            callInt, callSettings, httpJsonCallSettings, clientContext);
    ApiException exception =
        assertThrows(FailedPreconditionException.class, () -> callable.call(initialRequest));
    assertThat(tracerFactory.getInstance().getAttemptsStarted().get()).isEqualTo(1);
    assertThat(tracerFactory.getInstance().getAttemptsFailed().get()).isEqualTo(0);
    assertThat(tracerFactory.getInstance().getRetriesExhausted().get()).isFalse();
    assertThat(exception.getStatusCode().getTransportCode())
        .isEqualTo(HTTP_CODE_PRECONDITION_FAILED);
    assertThat(exception).hasMessageThat().contains("precondition failed");
    // Capture the argument passed to futureCall
    ArgumentCaptor<Integer> argumentCaptor = ArgumentCaptor.forClass(Integer.class);
    verify(callInt, atLeastOnce()).futureCall(argumentCaptor.capture(), any(ApiCallContext.class));
    assertThat(argumentCaptor.getAllValues()).containsExactly(0).inOrder();
  }

  @Test
  void testUnknownStatusCode() {
    ImmutableSet<StatusCode.Code> retryable = ImmutableSet.of();
    Mockito.when(callInt.futureCall((Integer) any(), (ApiCallContext) any()))
        .thenReturn(ApiFutures.<Integer>immediateFailedFuture(new RuntimeException("unknown")));
    UnaryCallSettings<Integer, Integer> callSettings =
        UnaryCallSettings.<Integer, Integer>newUnaryCallSettingsBuilder()
            .setRetryableCodes(retryable)
            .build();
    UnaryCallable<Integer, Integer> callable =
        HttpJsonCallableFactory.createUnaryCallable(
            callInt, callSettings, httpJsonCallSettings, clientContext);
    UnknownException exception =
        assertThrows(UnknownException.class, () -> callable.call(initialRequest));
    assertThat(exception).hasMessageThat().isEqualTo("java.lang.RuntimeException: unknown");
    assertThat(tracerFactory.getInstance().getAttemptsStarted().get()).isEqualTo(1);
    assertThat(tracerFactory.getInstance().getAttemptsFailed().get()).isEqualTo(0);
    assertThat(tracerFactory.getInstance().getRetriesExhausted().get()).isFalse();
    // Capture the argument passed to futureCall
    ArgumentCaptor<Integer> argumentCaptor = ArgumentCaptor.forClass(Integer.class);
    verify(callInt, atLeastOnce()).futureCall(argumentCaptor.capture(), any(ApiCallContext.class));
    assertThat(argumentCaptor.getAllValues()).containsExactly(0).inOrder();
  }

  public static UnaryCallSettings<Integer, Integer> createSettings(
      Set<StatusCode.Code> retryableCodes, RetrySettings retrySettings) {
    return UnaryCallSettings.<Integer, Integer>newUnaryCallSettingsBuilder()
        .setRetryableCodes(retryableCodes)
        .setRetrySettings(retrySettings)
        .build();
  }
}
