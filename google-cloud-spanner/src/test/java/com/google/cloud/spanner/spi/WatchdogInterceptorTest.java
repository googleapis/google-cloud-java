/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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

package com.google.cloud.spanner.spi;

import static com.google.common.base.Preconditions.checkNotNull;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.argThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.same;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.common.testing.FakeTicker;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import java.util.concurrent.TimeUnit;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/** Unit tests for {@link WatchdogInterceptor}. */
@RunWith(JUnit4.class)
public class WatchdogInterceptorTest {
  private static final long TIMEOUT_NANOS = 1000000;

  FakeTicker ticker;
  WatchdogInterceptor watchdog;

  CallOptions options;
  Metadata metadata;

  @Mock Channel channel;
  @Mock MethodDescriptor<Void, Void> descriptor;
  @Mock ClientCall<Void, Void> innerCall;
  @Mock ClientCall.Listener<Void> listener;

  @Captor ArgumentCaptor<ClientCall.Listener<Void>> innerListener;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    ticker = new FakeTicker();
    watchdog = new WatchdogInterceptor(TIMEOUT_NANOS, TimeUnit.NANOSECONDS, ticker);
    // Nothing special about the deadline: we just want a particular CallOptions instance to expect.
    options = CallOptions.DEFAULT.withDeadlineAfter(10, TimeUnit.SECONDS);
    metadata = new Metadata();
  }

  private ClientCall<Void, Void> startCall() {
    when(channel.newCall(Mockito.<MethodDescriptor<Void, Void>>any(), same(options)))
        .thenReturn(innerCall);
    doNothing().when(innerCall).start(innerListener.capture(), Mockito.<Metadata>any());

    ClientCall<Void, Void> watchdogCall = watchdog.interceptCall(descriptor, options, channel);
    watchdogCall.start(listener, metadata);
    return watchdogCall;
  }

  @Test
  public void noTimeout() {
    startCall();

    // Finish RPC with ABORTED.
    Metadata trailers = new Metadata();
    innerListener.getValue().onClose(Status.ABORTED, trailers);

    // Check that this was propagated.
    verify(listener).onClose(Status.ABORTED, trailers);
  }

  @Test
  public void timeout() {
    startCall();

    ticker.advance(TIMEOUT_NANOS + 1);
    watchdog.tick();

    verify(innerCall, times(1)).cancel(anyString(), Mockito.<Throwable>any());

    // Finish RPC with CANCELLED.
    Metadata trailers = new Metadata();
    innerListener.getValue().onClose(Status.CANCELLED, trailers);

    // Should translate to UNAVAILABLE.
    verify(listener).onClose(argThat(isStatusWithCode(Status.Code.UNAVAILABLE)), same(trailers));
  }

  @Test
  public void callerCancelsBeforeTimeout() {
    ClientCall<Void, Void> call = startCall();

    // Cancel the call before the watchdog does.
    call.cancel("Cancelled by user", null);

    ticker.advance(TIMEOUT_NANOS + 1);

    // Finish RPC with CANCELLED.
    Metadata trailers = new Metadata();
    innerListener.getValue().onClose(Status.CANCELLED, trailers);

    watchdog.tick();

    // The call should be cancelled exactly once.
    verify(innerCall, times(1)).cancel(anyString(), Mockito.<Throwable>any());

    // No translation, since the user beat the watchdog.
    verify(listener).onClose(argThat(isStatusWithCode(Status.Code.CANCELLED)), same(trailers));
  }

  @Test
  public void callerCancelsAfterTimeout() {
    ClientCall<Void, Void> call = startCall();

    ticker.advance(TIMEOUT_NANOS + 1);
    // Cancel the call before the watchdog does.
    call.cancel("Cancelled by user", null);
    watchdog.tick();

    // The call should be cancelled exactly once.
    verify(innerCall, times(1)).cancel(anyString(), Mockito.<Throwable>any());

    // Finish RPC with CANCELLED.
    Metadata trailers = new Metadata();
    innerListener.getValue().onClose(Status.CANCELLED, trailers);

    // No translation, since the user beat the watchdog.
    verify(listener).onClose(argThat(isStatusWithCode(Status.Code.CANCELLED)), same(trailers));
  }

  @Test
  public void failureAfterTimeout() {
    startCall();

    ticker.advance(TIMEOUT_NANOS + 1);
    watchdog.tick();

    // The call should be cancelled exactly once.
    verify(innerCall, times(1)).cancel(anyString(), Mockito.<Throwable>any());

    // Finish RPC with error.
    Metadata trailers = new Metadata();
    innerListener.getValue().onClose(Status.DATA_LOSS, trailers);

    // No translation expected.
    verify(listener).onClose(argThat(isStatusWithCode(Status.Code.DATA_LOSS)), same(trailers));
  }

  private static Matcher<Status> isStatusWithCode(Status.Code code) {
    return new StatusCodeMatcher(code);
  }

  private static class StatusCodeMatcher extends BaseMatcher<Status> {
    private final Status.Code expectedCode;

    StatusCodeMatcher(Status.Code expectedCode) {
      this.expectedCode = checkNotNull(expectedCode);
    }

    @Override
    public boolean matches(Object item) {
      if (!(item instanceof Status)) {
        return false;
      }
      Status s = (Status) item;
      return s.getCode() == expectedCode;
    }

    @Override
    public void describeTo(Description description) {
      description.appendText("Status[" + expectedCode + "]");
    }
  }
}
