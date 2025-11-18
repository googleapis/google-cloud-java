/*
 * Copyright 2025 Google LLC
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
package com.google.cloud.bigtable.gaxx.grpc;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import com.google.api.gax.grpc.ChannelFactory;
import com.google.common.collect.Iterables;
import io.grpc.CallOptions;
import io.grpc.ClientCall;
import io.grpc.ManagedChannel;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

@RunWith(JUnit4.class)
public class BigtableChannelPoolTest {
  @Rule public final MockitoRule mockito = MockitoJUnit.rule();

  @Mock private ChannelFactory mockChannelFactory;
  @Mock private ChannelPrimer mockChannelPrimer;
  @Mock private ManagedChannel mockChannel;
  @Mock private ClientCall<String, String> mockClientCall;

  private MethodDescriptor<String, String> unaryMethodDescriptor;
  private MethodDescriptor<String, String> streamingMethodDescriptor;

  @Captor private ArgumentCaptor<ClientCall.Listener<String>> listenerCaptor;

  private BigtableChannelPool channelPool;
  private ScheduledExecutorService executorService;

  private static class StringMarshaller implements MethodDescriptor.Marshaller<String> {
    @Override
    public InputStream stream(String value) {
      return null; // Not used in this test
    }

    @Override
    public String parse(InputStream stream) {
      return null; // Not used in this test
    }
  }

  @Before
  public void setUp() throws IOException {
    when(mockChannelFactory.createSingleChannel()).thenReturn(mockChannel);
    when(mockChannel.newCall(
            ArgumentMatchers.<MethodDescriptor<String, String>>any(), any(CallOptions.class)))
        .thenReturn(mockClientCall);
    // Setup MethodDescriptors
    // Initialize real MethodDescriptor instances
    MethodDescriptor.Marshaller<String> marshaller = new StringMarshaller();
    unaryMethodDescriptor =
        MethodDescriptor.<String, String>newBuilder()
            .setType(MethodDescriptor.MethodType.UNARY)
            .setFullMethodName(MethodDescriptor.generateFullMethodName("bigtable", "MutateRow"))
            .setRequestMarshaller(marshaller)
            .setResponseMarshaller(marshaller)
            .build();

    streamingMethodDescriptor =
        MethodDescriptor.<String, String>newBuilder()
            .setType(MethodDescriptor.MethodType.SERVER_STREAMING)
            .setFullMethodName(MethodDescriptor.generateFullMethodName("bigtable", "ReadRows"))
            .setRequestMarshaller(marshaller)
            .setResponseMarshaller(marshaller)
            .build();

    executorService = Executors.newSingleThreadScheduledExecutor();

    BigtableChannelPoolSettings settings =
        BigtableChannelPoolSettings.builder()
            .setInitialChannelCount(1)
            .setMinChannelCount(1)
            .setMaxChannelCount(1)
            .build();
    channelPool =
        new BigtableChannelPool(settings, mockChannelFactory, mockChannelPrimer, executorService);

    // Capture the listener when start is called
    // Configure mockClientCall.start to capture the listener
    doNothing().when(mockClientCall).start(listenerCaptor.capture(), any(Metadata.class));
  }

  private BigtableChannelPool.Entry getSingleEntry() {
    List<? extends BigtableChannelObserver> infos = channelPool.getChannelInfos();
    return (BigtableChannelPool.Entry) Iterables.getOnlyElement(infos);
  }

  private ClientCall.Listener<String> startCall(MethodDescriptor<String, String> method) {
    ClientCall<String, String> call = channelPool.newCall(method, CallOptions.DEFAULT);
    call.start(mock(ClientCall.Listener.class), new Metadata());
    return listenerCaptor.getValue();
  }

  @Test
  public void testUnaryRpcSuccess() {
    BigtableChannelPool.Entry entry = getSingleEntry();

    // Before call
    assertThat(entry.getOutstandingUnaryRpcs()).isEqualTo(0);
    assertThat(entry.getOutstandingStreamingRpcs()).isEqualTo(0);

    ClientCall.Listener<String> listener = startCall(unaryMethodDescriptor);

    // After start
    assertThat(entry.getOutstandingUnaryRpcs()).isEqualTo(1);
    assertThat(entry.getOutstandingStreamingRpcs()).isEqualTo(0);
    assertThat(entry.totalOutstandingRpcs()).isEqualTo(1);

    // Simulate call success
    listener.onClose(Status.OK, new Metadata());

    // After close
    assertThat(entry.getOutstandingUnaryRpcs()).isEqualTo(0);
    assertThat(entry.getOutstandingStreamingRpcs()).isEqualTo(0);
    assertThat(entry.totalOutstandingRpcs()).isEqualTo(0);
    assertThat(entry.getAndResetSuccessCount()).isEqualTo(1);
    assertThat(entry.getAndResetErrorCount()).isEqualTo(0);
  }

  @Test
  public void testUnaryRpcFailure() {
    BigtableChannelPool.Entry entry = getSingleEntry();
    ClientCall.Listener<String> listener = startCall(unaryMethodDescriptor);

    assertThat(entry.getOutstandingUnaryRpcs()).isEqualTo(1);

    // Simulate call failure
    listener.onClose(Status.UNAVAILABLE, new Metadata());

    // After close
    assertThat(entry.getOutstandingUnaryRpcs()).isEqualTo(0);
    assertThat(entry.totalOutstandingRpcs()).isEqualTo(0);
    assertThat(entry.getAndResetSuccessCount()).isEqualTo(0);
    assertThat(entry.getAndResetErrorCount()).isEqualTo(1);
  }

  @Test
  public void testStreamingRpcSuccess() {
    BigtableChannelPool.Entry entry = getSingleEntry();

    ClientCall.Listener<String> listener = startCall(streamingMethodDescriptor);

    // After start
    assertThat(entry.getOutstandingUnaryRpcs()).isEqualTo(0);
    assertThat(entry.getOutstandingStreamingRpcs()).isEqualTo(1);
    assertThat(entry.totalOutstandingRpcs()).isEqualTo(1);

    // Simulate call success
    listener.onClose(Status.OK, new Metadata());

    // After close
    assertThat(entry.getOutstandingStreamingRpcs()).isEqualTo(0);
    assertThat(entry.totalOutstandingRpcs()).isEqualTo(0);
    assertThat(entry.getAndResetSuccessCount()).isEqualTo(1);
    assertThat(entry.getAndResetErrorCount()).isEqualTo(0);
  }

  @Test
  public void testStreamingRpcFailure() {
    BigtableChannelPool.Entry entry = getSingleEntry();
    ClientCall.Listener<String> listener = startCall(streamingMethodDescriptor);

    assertThat(entry.getOutstandingStreamingRpcs()).isEqualTo(1);

    // Simulate call failure
    listener.onClose(Status.DEADLINE_EXCEEDED, new Metadata());

    // After close
    assertThat(entry.getOutstandingStreamingRpcs()).isEqualTo(0);
    assertThat(entry.totalOutstandingRpcs()).isEqualTo(0);
    assertThat(entry.getAndResetSuccessCount()).isEqualTo(0);
    assertThat(entry.getAndResetErrorCount()).isEqualTo(1);
  }

  @Test
  public void testMixedRpcs() {
    BigtableChannelPool.Entry entry = getSingleEntry();

    // 1 Unary OK
    startCall(unaryMethodDescriptor).onClose(Status.OK, new Metadata());
    // 1 Unary Fail
    startCall(unaryMethodDescriptor).onClose(Status.INTERNAL, new Metadata());
    // 1 Streaming OK
    startCall(streamingMethodDescriptor).onClose(Status.OK, new Metadata());
    // 2 Streaming Fail
    startCall(streamingMethodDescriptor).onClose(Status.CANCELLED, new Metadata());
    ClientCall.Listener<String> streamingListener = startCall(streamingMethodDescriptor);

    // Before the last one closes
    assertThat(entry.getOutstandingUnaryRpcs()).isEqualTo(0);
    assertThat(entry.getOutstandingStreamingRpcs()).isEqualTo(1);
    assertThat(entry.getAndResetSuccessCount()).isEqualTo(2); // 1 Unary + 1 Streaming
    assertThat(entry.getAndResetErrorCount()).isEqualTo(2); // 1 Unary + 1 Streaming

    // Close the last one
    streamingListener.onClose(Status.UNKNOWN, new Metadata());
    assertThat(entry.getOutstandingStreamingRpcs()).isEqualTo(0);
    assertThat(entry.getAndResetSuccessCount()).isEqualTo(0);
    assertThat(entry.getAndResetErrorCount()).isEqualTo(1); // The last failure
    assertThat(entry.totalOutstandingRpcs()).isEqualTo(0);
  }
}
