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

import com.google.api.gax.rpc.testing.FakeCallContext;
import com.google.api.gax.rpc.testing.FakeCallableFactory;
import com.google.api.gax.rpc.testing.FakeChannel;
import com.google.api.gax.rpc.testing.FakeSimpleApi.StashCallable;
import com.google.api.gax.rpc.testing.FakeStreamingApi.ServerStreamingStashCallable;
import com.google.api.gax.rpc.testing.FakeTransportChannel;
import com.google.auth.Credentials;
import com.google.common.collect.ImmutableList;
import com.google.common.truth.Truth;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServerStreamingCallableTest {
  private ClientContext clientContext;

  @BeforeEach
  void setUp() {
    clientContext =
        ClientContext.newBuilder()
            .setDefaultCallContext(FakeCallContext.createDefault())
            .setTransportChannel(FakeTransportChannel.create(new FakeChannel()))
            .build();
  }

  @Test
  void serverStreaming() {
    ServerStreamingStashCallable<Integer, Integer> callIntList =
        new ServerStreamingStashCallable<>(Arrays.asList(0, 1, 2));

    ServerStreamingCallable<Integer, Integer> callable =
        FakeCallableFactory.createServerStreamingCallable(
            callIntList,
            StreamingCallSettings.<Integer, Integer>newBuilder().build(),
            clientContext);

    AccumulatingStreamObserver responseObserver = new AccumulatingStreamObserver();
    callable.call(0, responseObserver);
    Truth.assertThat(ImmutableList.copyOf(responseObserver.getValues()))
        .containsExactly(0, 1, 2)
        .inOrder();
    Truth.assertThat(callIntList.getActualRequest()).isEqualTo(0);
  }

  @Test
  void testServerStreamingCall() {
    ApiCallContext defaultCallContext = FakeCallContext.createDefault();
    ServerStreamingStashCallable<Integer, Integer> stashCallable =
        new ServerStreamingStashCallable<>();
    ServerStreamingCallable<Integer, Integer> callable =
        stashCallable.withDefaultCallContext(defaultCallContext);
    @SuppressWarnings("unchecked")
    StateCheckingResponseObserver<Integer> observer =
        Mockito.mock(StateCheckingResponseObserver.class);
    Integer request = 1;
    callable.call(request, observer);
    Truth.assertThat(stashCallable.getActualObserver()).isSameInstanceAs(observer);
    Truth.assertThat(stashCallable.getActualRequest()).isSameInstanceAs(request);
    Truth.assertThat(stashCallable.getContext()).isSameInstanceAs(defaultCallContext);
  }

  @Test
  void testServerStreamingCallWithContext() {
    FakeChannel channel = new FakeChannel();
    Credentials credentials = Mockito.mock(Credentials.class);
    ApiCallContext context =
        FakeCallContext.createDefault().withChannel(channel).withCredentials(credentials);
    ServerStreamingStashCallable<Integer, Integer> stashCallable =
        new ServerStreamingStashCallable<>();
    ServerStreamingCallable<Integer, Integer> callable =
        stashCallable.withDefaultCallContext(FakeCallContext.createDefault());
    @SuppressWarnings("unchecked")
    ResponseObserver<Integer> observer = Mockito.mock(StateCheckingResponseObserver.class);
    Integer request = 1;
    callable.call(request, observer, context);
    Truth.assertThat(stashCallable.getActualObserver()).isSameInstanceAs(observer);
    Truth.assertThat(stashCallable.getActualRequest()).isSameInstanceAs(request);
    FakeCallContext actualContext = (FakeCallContext) stashCallable.getContext();
    Truth.assertThat(actualContext.getChannel()).isSameInstanceAs(channel);
    Truth.assertThat(actualContext.getCredentials()).isSameInstanceAs(credentials);
  }

  @Test
  void blockingServerStreaming() {
    ServerStreamingStashCallable<Integer, Integer> callIntList =
        new ServerStreamingStashCallable<>(Arrays.asList(0, 1, 2));

    ServerStreamingCallable<Integer, Integer> callable =
        FakeCallableFactory.createServerStreamingCallable(
            callIntList,
            StreamingCallSettings.<Integer, Integer>newBuilder().build(),
            clientContext);
    Truth.assertThat(ImmutableList.copyOf(callable.call(0))).containsExactly(0, 1, 2).inOrder();
    Truth.assertThat(callIntList.getActualRequest()).isEqualTo(0);
  }

  @Test
  void testIteratedServerStreamingCall() {
    ApiCallContext defaultCallContext = FakeCallContext.createDefault();
    ServerStreamingStashCallable<Integer, Integer> stashCallable =
        new ServerStreamingStashCallable<>();
    ServerStreamingCallable<Integer, Integer> callable =
        stashCallable.withDefaultCallContext(defaultCallContext);
    Integer request = 1;
    callable.call(request);
    Truth.assertThat(stashCallable.getActualRequest()).isSameInstanceAs(request);
    Truth.assertThat(stashCallable.getContext()).isSameInstanceAs(defaultCallContext);
  }

  @Test
  void testIteratedServerStreamingCallWithContext() {
    FakeChannel channel = new FakeChannel();
    Credentials credentials = Mockito.mock(Credentials.class);
    ApiCallContext context =
        FakeCallContext.createDefault().withChannel(channel).withCredentials(credentials);
    ServerStreamingStashCallable<Integer, Integer> stashCallable =
        new ServerStreamingStashCallable<>();
    ServerStreamingCallable<Integer, Integer> callable =
        stashCallable.withDefaultCallContext(FakeCallContext.createDefault());
    Integer request = 1;
    callable.call(request, context);
    Truth.assertThat(stashCallable.getActualRequest()).isSameInstanceAs(request);
    FakeCallContext actualContext = (FakeCallContext) stashCallable.getContext();
    Truth.assertThat(actualContext.getChannel()).isSameInstanceAs(channel);
    Truth.assertThat(actualContext.getCredentials()).isSameInstanceAs(credentials);
  }

  @Test
  void testFirstElementCall() {
    ServerStreamingStashCallable<Integer, Integer> callIntList =
        new ServerStreamingStashCallable<>(Arrays.asList(0, 1, 2));

    ServerStreamingCallable<Integer, Integer> streamingCallable =
        FakeCallableFactory.createServerStreamingCallable(
            callIntList,
            StreamingCallSettings.<Integer, Integer>newBuilder().build(),
            clientContext);

    UnaryCallable<Integer, Integer> callable = streamingCallable.first();
    Truth.assertThat(callable.call(0)).isEqualTo(0);
    Truth.assertThat(callIntList.getActualRequest()).isEqualTo(0);
  }

  @Test
  void testFirstElementCallWithDefaultContext() {
    ApiCallContext defaultCallContext = FakeCallContext.createDefault();

    final StashCallable<Integer, Integer> stashFirstCallable = new StashCallable<>(11);

    ServerStreamingStashCallable<Integer, Integer> stashCallable =
        new ServerStreamingStashCallable<Integer, Integer>() {
          @Override
          public UnaryCallable<Integer, Integer> first() {
            return stashFirstCallable;
          }
        };

    UnaryCallable<Integer, Integer> firstCallable =
        stashCallable.withDefaultCallContext(defaultCallContext).first();
    Integer request = 1;
    firstCallable.call(request);
    Truth.assertThat(stashFirstCallable.getRequest()).isSameInstanceAs(request);
    Truth.assertThat(stashFirstCallable.getContext()).isSameInstanceAs(defaultCallContext);
  }

  @Test
  void testFirstElementCallWithContext() {
    FakeChannel channel = new FakeChannel();
    Credentials credentials = Mockito.mock(Credentials.class);
    ApiCallContext context =
        FakeCallContext.createDefault().withChannel(channel).withCredentials(credentials);
    ServerStreamingStashCallable<Integer, Integer> stashCallable =
        new ServerStreamingStashCallable<>();

    UnaryCallable<Integer, Integer> firstCallable =
        stashCallable.first().withDefaultCallContext(FakeCallContext.createDefault());
    Integer request = 1;
    firstCallable.call(request, context);
    Truth.assertThat(stashCallable.getActualRequest()).isSameInstanceAs(request);
    FakeCallContext actualContext = (FakeCallContext) stashCallable.getContext();
    Truth.assertThat(actualContext.getChannel()).isSameInstanceAs(channel);
    Truth.assertThat(actualContext.getCredentials()).isSameInstanceAs(credentials);
  }

  @Test
  void testAllElementCall() {
    ServerStreamingStashCallable<Integer, Integer> callIntList =
        new ServerStreamingStashCallable<>(Arrays.asList(0, 1, 2));

    ServerStreamingCallable<Integer, Integer> streamingCallable =
        FakeCallableFactory.createServerStreamingCallable(
            callIntList,
            StreamingCallSettings.<Integer, Integer>newBuilder().build(),
            clientContext);

    UnaryCallable<Integer, List<Integer>> callable = streamingCallable.all();
    Truth.assertThat(callable.call(0)).containsExactly(0, 1, 2).inOrder();
    Truth.assertThat(callIntList.getActualRequest()).isEqualTo(0);
  }

  @Test
  void testAllElementCallWithDefaultContext() {
    ApiCallContext defaultCallContext = FakeCallContext.createDefault();
    ServerStreamingStashCallable<Integer, Integer> stashCallable =
        new ServerStreamingStashCallable<>();

    UnaryCallable<Integer, List<Integer>> firstCallable =
        stashCallable.all().withDefaultCallContext(defaultCallContext);
    Integer request = 1;
    firstCallable.call(request);
    Truth.assertThat(stashCallable.getActualRequest()).isSameInstanceAs(request);
    Truth.assertThat(stashCallable.getContext()).isSameInstanceAs(defaultCallContext);
  }

  @Test
  void testAllElementCallWithContext() {
    FakeChannel channel = new FakeChannel();
    Credentials credentials = Mockito.mock(Credentials.class);
    ApiCallContext context =
        FakeCallContext.createDefault().withChannel(channel).withCredentials(credentials);
    ServerStreamingStashCallable<Integer, Integer> stashCallable =
        new ServerStreamingStashCallable<>();

    UnaryCallable<Integer, List<Integer>> firstCallable =
        stashCallable.all().withDefaultCallContext(FakeCallContext.createDefault());
    Integer request = 1;
    firstCallable.call(request, context);
    Truth.assertThat(stashCallable.getActualRequest()).isSameInstanceAs(request);
    FakeCallContext actualContext = (FakeCallContext) stashCallable.getContext();
    Truth.assertThat(actualContext.getChannel()).isSameInstanceAs(channel);
    Truth.assertThat(actualContext.getCredentials()).isSameInstanceAs(credentials);
  }
}
