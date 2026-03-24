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
package com.google.api.gax.rpc;

import static org.junit.jupiter.api.Assertions.assertSame;

import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.StatusCode.Code;
import com.google.api.gax.rpc.testing.FakeCallContext;
import com.google.api.gax.rpc.testing.FakeCallableFactory;
import com.google.api.gax.rpc.testing.FakeChannel;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.api.gax.rpc.testing.FakeStreamingApi.ClientStreamingStashCallable;
import com.google.api.gax.rpc.testing.FakeTransportChannel;
import com.google.auth.Credentials;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.truth.Truth;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class StreamingCallableTest {
  private ClientContext clientContext;

  @BeforeEach
  void setUp() {
    clientContext =
        ClientContext.newBuilder()
            .setDefaultCallContext(FakeCallContext.createDefault())
            .setTransportChannel(FakeTransportChannel.create(new FakeChannel()))
            .build();
  }

  private static class AccumulatingStreamObserver implements ApiStreamObserver<Integer> {
    private List<Integer> values = new ArrayList<>();
    private Throwable error;
    private boolean completed = false;

    @Override
    public void onNext(Integer value) {
      values.add(value);
    }

    @Override
    public void onError(Throwable t) {
      error = t;
    }

    @Override
    public void onCompleted() {
      completed = true;
    }

    public List<Integer> getValues() {
      if (!completed) {
        throw new IllegalStateException("Stream not completed.");
      }
      if (error != null) {
        throw ApiExceptionFactory.createException(error, FakeStatusCode.of(Code.UNKNOWN), false);
      }
      return values;
    }
  }

  @Test
  void clientStreaming() {
    ClientStreamingStashCallable<Integer, Integer> callIntList =
        new ClientStreamingStashCallable<>(100);

    ClientStreamingCallable<Integer, Integer> callable =
        FakeCallableFactory.createClientStreamingCallable(
            callIntList,
            StreamingCallSettings.<Integer, Integer>newBuilder().build(),
            clientContext);

    AccumulatingStreamObserver responseObserver = new AccumulatingStreamObserver();
    ApiStreamObserver<Integer> requestObserver = callable.clientStreamingCall(responseObserver);
    requestObserver.onNext(0);
    requestObserver.onNext(2);
    requestObserver.onNext(4);
    requestObserver.onCompleted();

    Truth.assertThat(ImmutableList.copyOf(responseObserver.getValues()))
        .containsExactly(100)
        .inOrder();
    Truth.assertThat(callIntList.getActualRequests()).containsExactly(0, 2, 4).inOrder();
  }

  @Test
  @SuppressWarnings("unchecked")
  void testClientStreamingCall() {
    ApiCallContext defaultCallContext = FakeCallContext.createDefault();
    ClientStreamingStashCallable<Integer, Integer> stashCallable =
        new ClientStreamingStashCallable<>();
    ApiStreamObserver<Integer> observer = Mockito.mock(ApiStreamObserver.class);
    ClientStreamingCallable<Integer, Integer> callable =
        stashCallable.withDefaultCallContext(defaultCallContext);
    callable.clientStreamingCall(observer);
    assertSame(observer, stashCallable.getActualObserver());
    assertSame(defaultCallContext, stashCallable.getContext());
  }

  @Test
  @SuppressWarnings("unchecked")
  void testClientStreamingCallWithContext() {
    FakeChannel channel = new FakeChannel();
    Credentials credentials = Mockito.mock(Credentials.class);
    RetrySettings retrySettings = Mockito.mock(RetrySettings.class);
    Set<StatusCode.Code> retryableCodes =
        ImmutableSet.of(
            StatusCode.Code.INTERNAL,
            StatusCode.Code.UNAVAILABLE,
            StatusCode.Code.DEADLINE_EXCEEDED);
    ApiCallContext context =
        FakeCallContext.createDefault()
            .withChannel(channel)
            .withCredentials(credentials)
            .withRetrySettings(retrySettings)
            .withRetryableCodes(retryableCodes);
    ClientStreamingStashCallable<Integer, Integer> stashCallable =
        new ClientStreamingStashCallable<>();
    ApiStreamObserver<Integer> observer = Mockito.mock(ApiStreamObserver.class);
    ClientStreamingCallable<Integer, Integer> callable =
        stashCallable.withDefaultCallContext(FakeCallContext.createDefault());
    callable.clientStreamingCall(observer, context);
    assertSame(observer, stashCallable.getActualObserver());
    FakeCallContext actualContext = (FakeCallContext) stashCallable.getContext();
    assertSame(channel, actualContext.getChannel());
    assertSame(credentials, actualContext.getCredentials());
    assertSame(retrySettings, actualContext.getRetrySettings());
    assertSame(retryableCodes, actualContext.getRetryableCodes());
  }
}
