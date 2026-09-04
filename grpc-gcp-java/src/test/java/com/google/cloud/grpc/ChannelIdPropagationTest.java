/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.grpc;

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.grpc.GcpManagedChannel.ChannelAffinityRef;
import com.google.cloud.grpc.GcpManagedChannelOptions.GcpChannelPoolOptions;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ForwardingClientCall;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ChannelIdPropagationTest {
  private static final MethodDescriptor<String, String> METHOD_DESCRIPTOR =
      MethodDescriptor.<String, String>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("test/method")
          .setRequestMarshaller(new FakeMarshaller<>())
          .setResponseMarshaller(new FakeMarshaller<>())
          .build();

  private static class FakeMarshaller<T> implements MethodDescriptor.Marshaller<T> {
    @Override
    public InputStream stream(T value) {
      return null;
    }

    @Override
    public T parse(InputStream stream) {
      return null;
    }
  }

  @Test
  public void testChannelIdKeySetWithoutAffinity() {
    ManagedChannelBuilder<?> builder = ManagedChannelBuilder.forAddress("localhost", 443);
    final AtomicInteger channelId = new AtomicInteger(-1);

    ClientInterceptor channelIdInterceptor =
        new ClientInterceptor() {
          @Override
          public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
              MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, Channel next) {
            return new ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT>(
                next.newCall(method, callOptions)) {
              @Override
              public void start(Listener<RespT> responseListener, Metadata headers) {
                if (callOptions.getOption(GcpManagedChannel.CHANNEL_ID_KEY) != null) {
                  channelId.set(callOptions.getOption(GcpManagedChannel.CHANNEL_ID_KEY));
                }
                super.start(responseListener, headers);
              }
            };
          }
        };

    // Add interceptor to the delegate builder so it runs on the underlying channels.
    builder.intercept(channelIdInterceptor);

    // Creating a pool.
    final GcpManagedChannel pool =
        (GcpManagedChannel)
            GcpManagedChannelBuilder.forDelegateBuilder(builder)
                .withOptions(
                    GcpManagedChannelOptions.newBuilder()
                        .withChannelPoolOptions(
                            GcpChannelPoolOptions.newBuilder().setMinSize(3).setMaxSize(3).build())
                        .build())
                .build();

    // Use the pool directly (interceptor is already inside)
    ClientCall<String, String> newCall = pool.newCall(METHOD_DESCRIPTOR, CallOptions.DEFAULT);
    Metadata headers = new Metadata();

    // First call (should initialize channel and correct ID)
    newCall.start(
        new ForwardingClientCall.SimpleForwardingClientCall.Listener<String>() {}, headers);

    // Should be one of the possible 3 ids: 0, 1, 2.
    assertThat(channelId.get()).isAnyOf(0, 1, 2);

    // Attempt 2
    newCall = pool.newCall(METHOD_DESCRIPTOR, CallOptions.DEFAULT);
    newCall.start(
        new ForwardingClientCall.SimpleForwardingClientCall.Listener<String>() {}, headers);

    // Should be one of the possible 3 ids: 0, 1, 2.
    assertThat(channelId.get()).isAnyOf(0, 1, 2);

    pool.shutdownNow();
  }

  @Test
  public void testChannelAffinityRefSticksToSameChannel() {
    List<Integer> channelIds = new ArrayList<>();
    GcpManagedChannel pool = newPoolWithChannelIdInterceptor(channelIds);

    try {
      ChannelAffinityRef affinityRef = new ChannelAffinityRef();
      CallOptions callOptions =
          CallOptions.DEFAULT.withOption(GcpManagedChannel.CHANNEL_AFFINITY_REF_KEY, affinityRef);

      startCall(pool, callOptions);
      startCall(pool, callOptions);
      startCall(pool, callOptions);

      assertThat(channelIds).hasSize(3);
      assertThat(channelIds.get(1)).isEqualTo(channelIds.get(0));
      assertThat(channelIds.get(2)).isEqualTo(channelIds.get(0));
      assertThat(pool.affinityKeyToChannelRef).isEmpty();
    } finally {
      pool.shutdownNow();
    }
  }

  @Test
  public void testChannelAffinityRefCanMoveToDifferentChannelOnNextCall() {
    List<Integer> channelIds = new ArrayList<>();
    GcpManagedChannel pool = newPoolWithChannelIdInterceptor(channelIds);

    try {
      ChannelAffinityRef affinityRef = new ChannelAffinityRef();
      CallOptions callOptions =
          CallOptions.DEFAULT.withOption(GcpManagedChannel.CHANNEL_AFFINITY_REF_KEY, affinityRef);

      startCall(pool, callOptions);
      affinityRef.useDifferentChannelOnNextCall();
      startCall(pool, callOptions);
      startCall(pool, callOptions);

      assertThat(channelIds).hasSize(3);
      assertThat(channelIds.get(1)).isNotEqualTo(channelIds.get(0));
      assertThat(channelIds.get(2)).isEqualTo(channelIds.get(1));
      assertThat(pool.affinityKeyToChannelRef).isEmpty();
    } finally {
      pool.shutdownNow();
    }
  }

  private static GcpManagedChannel newPoolWithChannelIdInterceptor(List<Integer> channelIds) {
    ManagedChannelBuilder<?> builder = ManagedChannelBuilder.forAddress("localhost", 443);
    builder.intercept(
        new ClientInterceptor() {
          @Override
          public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
              MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, Channel next) {
            Integer channelId = callOptions.getOption(GcpManagedChannel.CHANNEL_ID_KEY);
            if (channelId != null) {
              channelIds.add(channelId);
            }
            return next.newCall(method, callOptions);
          }
        });
    return (GcpManagedChannel)
        GcpManagedChannelBuilder.forDelegateBuilder(builder)
            .withOptions(
                GcpManagedChannelOptions.newBuilder()
                    .withChannelPoolOptions(
                        GcpChannelPoolOptions.newBuilder().setMinSize(3).setMaxSize(3).build())
                    .build())
            .build();
  }

  private static void startCall(GcpManagedChannel pool, CallOptions callOptions) {
    pool.newCall(METHOD_DESCRIPTOR, callOptions)
        .start(
            new ForwardingClientCall.SimpleForwardingClientCall.Listener<String>() {},
            new Metadata());
  }
}
