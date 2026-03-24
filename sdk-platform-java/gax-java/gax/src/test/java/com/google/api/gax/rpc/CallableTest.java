/*
 * Copyright 2021 Google LLC
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
package com.google.api.gax.rpc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.api.core.ApiClock;
import com.google.api.core.ApiFuture;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.testing.FakeCallContext;
import java.util.concurrent.ScheduledExecutorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CallableTest {

  @Mock private UnaryCallable<String, String> innerCallable;
  private SettableApiFuture<String> innerResult;

  @Mock private ServerStreamingCallable<Object, Object> innerServerStreamingCallable;

  private RetrySettings retrySettings =
      RetrySettings.newBuilder()
          .setInitialRpcTimeoutDuration(java.time.Duration.ofMillis(5L))
          .setMaxRpcTimeoutDuration(java.time.Duration.ofMillis(5L))
          .setTotalTimeoutDuration(java.time.Duration.ofMillis(10L))
          .build();

  @Spy private ApiCallContext callContext = FakeCallContext.createDefault();

  @Spy
  private ApiCallContext callContextWithRetrySettings =
      FakeCallContext.createDefault().withRetrySettings(retrySettings);

  private ClientContext clientContext =
      ClientContext.newBuilder().setDefaultCallContext(callContext).build();

  @Test
  void testNonRetriedCallable() throws Exception {
    innerResult = SettableApiFuture.create();
    when(innerCallable.futureCall(anyString(), any(ApiCallContext.class))).thenReturn(innerResult);
    java.time.Duration timeout = java.time.Duration.ofMillis(5L);
    String initialRequest = "Is your refrigerator running?";
    String modifiedRequest = "What about now?";

    RequestMutator requestMutator = (request -> modifiedRequest);

    UnaryCallSettings<Object, Object> callSettings =
        UnaryCallSettings.newUnaryCallSettingsBuilder()
            .setSimpleTimeoutNoRetriesDuration(timeout)
            .build();
    UnaryCallable<String, String> callable =
        Callables.retrying(innerCallable, callSettings, clientContext, requestMutator);
    String expectedResponse = "No, my refrigerator is not running!";
    innerResult.set(expectedResponse);

    ApiFuture<String> futureResponse = callable.futureCall(initialRequest, callContext);

    ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
    verify(innerCallable).futureCall(argumentCaptor.capture(), any(ApiCallContext.class));
    String expectedRequest = "What about now?";
    assertEquals(expectedRequest, argumentCaptor.getValue());
    verify(callContext, atLeastOnce()).getRetrySettings();
    verify(callContext).getTimeoutDuration();
    verify(callContext).withTimeoutDuration(timeout);
    assertEquals(expectedResponse, futureResponse.get());
  }

  @Test
  void testNonRetriedCallableWithRetrySettings() throws Exception {
    innerResult = SettableApiFuture.create();
    when(innerCallable.futureCall(anyString(), any(ApiCallContext.class))).thenReturn(innerResult);

    String initialRequest = "Is your refrigerator running?";
    String modifiedRequest = "What about now?";
    RequestMutator requestMutator = (request -> modifiedRequest);

    UnaryCallSettings<Object, Object> callSettings =
        UnaryCallSettings.newUnaryCallSettingsBuilder()
            .setSimpleTimeoutNoRetriesDuration(java.time.Duration.ofMillis(10L))
            .build();
    UnaryCallable<String, String> callable =
        Callables.retrying(innerCallable, callSettings, clientContext, requestMutator);
    String expectedResponse = "No, my refrigerator is not running!";
    innerResult.set(expectedResponse);

    java.time.Duration timeout = retrySettings.getInitialRpcTimeoutDuration();

    ApiFuture<String> futureResponse =
        callable.futureCall(initialRequest, callContextWithRetrySettings);

    ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
    verify(innerCallable).futureCall(argumentCaptor.capture(), any(ApiCallContext.class));
    String expectedRequest = "What about now?";
    assertEquals(expectedRequest, argumentCaptor.getValue());

    verify(callContextWithRetrySettings, atLeastOnce()).getRetrySettings();
    verify(callContextWithRetrySettings).getTimeoutDuration();
    verify(callContextWithRetrySettings).withTimeoutDuration(timeout);
    assertEquals(expectedResponse, futureResponse.get());
  }

  @Test
  void testNonRetriedServerStreamingCallable() throws Exception {
    java.time.Duration timeout = java.time.Duration.ofMillis(5L);
    ServerStreamingCallSettings<Object, Object> callSettings =
        ServerStreamingCallSettings.newBuilder().setSimpleTimeoutNoRetriesDuration(timeout).build();
    ServerStreamingCallable<Object, Object> callable =
        Callables.retrying(innerServerStreamingCallable, callSettings, clientContext);

    callable.call("Is your refrigerator running?", callContext);

    verify(callContext, atLeastOnce()).getRetrySettings();
    verify(callContext).getTimeoutDuration();
    verify(callContext).withTimeoutDuration(timeout);
  }

  @Test
  void testNonRetriedServerStreamingCallableWithRetrySettings() throws Exception {
    ServerStreamingCallSettings<Object, Object> callSettings =
        ServerStreamingCallSettings.newBuilder()
            .setSimpleTimeoutNoRetriesDuration(java.time.Duration.ofMillis(10L))
            .build();
    ServerStreamingCallable<Object, Object> callable =
        Callables.retrying(innerServerStreamingCallable, callSettings, clientContext);

    java.time.Duration timeout = retrySettings.getInitialRpcTimeoutDuration();

    callable.call("Is your refrigerator running?", callContextWithRetrySettings);

    verify(callContextWithRetrySettings, atLeastOnce()).getRetrySettings();
    verify(callContextWithRetrySettings).getTimeoutDuration();
    verify(callContextWithRetrySettings).withTimeoutDuration(timeout);
  }

  @Test
  void testWatched_usesJavaTimeMethods() {
    java.time.Duration timeout = java.time.Duration.ofMillis(5L);
    doReturn(callContext).when(callContext).withStreamIdleTimeoutDuration(eq(timeout));
    Watchdog watchdog =
        Watchdog.createDuration(
            Mockito.mock(ApiClock.class),
            java.time.Duration.ZERO,
            Mockito.mock(ScheduledExecutorService.class));
    ClientContext clientContext =
        ClientContext.newBuilder()
            .setStreamWatchdog(watchdog)
            .setDefaultCallContext(callContext)
            .build();
    ServerStreamingCallSettings<Object, Object> callSettings =
        ServerStreamingCallSettings.newBuilder()
            .setIdleTimeoutDuration(timeout)
            .setWaitTimeoutDuration(timeout)
            .build();
    ServerStreamingCallable<Object, Object> callable =
        Callables.retrying(innerServerStreamingCallable, callSettings, clientContext);
    Callables.watched(callable, callSettings, clientContext);
    verify(callContext, atLeastOnce()).withStreamIdleTimeoutDuration(eq(timeout));
    verify(callContext, atLeastOnce()).withStreamWaitTimeoutDuration(eq(timeout));
  }
}
