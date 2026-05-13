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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import io.grpc.CallOptions;
import io.grpc.ClientCall;
import io.grpc.ConnectivityState;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import java.io.InputStream;
import java.util.Collections;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public final class GcpClientCallTest {

  private static final class FakeMarshaller<T> implements MethodDescriptor.Marshaller<T> {
    @Override
    public InputStream stream(T value) {
      return null;
    }

    @Override
    public T parse(InputStream stream) {
      return null;
    }
  }

  private static final MethodDescriptor<String, String> METHOD_DESCRIPTOR =
      MethodDescriptor.<String, String>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("test/method")
          .setRequestMarshaller(new FakeMarshaller<>())
          .setResponseMarshaller(new FakeMarshaller<>())
          .build();

  @Mock private ManagedChannel delegateChannel;
  @Mock private ClientCall<String, String> delegateCall;

  private GcpManagedChannel gcpChannel;
  private GcpManagedChannel.ChannelRef channelRef;

  @Before
  public void setUp() {
    ManagedChannelBuilder<?> builder = ManagedChannelBuilder.forAddress("localhost", 443);
    gcpChannel = (GcpManagedChannel) GcpManagedChannelBuilder.forDelegateBuilder(builder).build();

    when(delegateChannel.getState(anyBoolean())).thenReturn(ConnectivityState.IDLE);
    when(delegateChannel.newCall(eq(METHOD_DESCRIPTOR), any(CallOptions.class)))
        .thenReturn(delegateCall);

    channelRef = gcpChannel.new ChannelRef(delegateChannel);
  }

  @After
  public void tearDown() {
    gcpChannel.shutdownNow();
  }

  @SuppressWarnings("unchecked")
  @Test
  public void simpleCallUnbindsAffinityKeyOnCloseWhenRequested() {
    String affinityKey = "txn-1";
    gcpChannel.bind(channelRef, Collections.singletonList(affinityKey));

    GcpClientCall.SimpleGcpClientCall<String, String> call =
        new GcpClientCall.SimpleGcpClientCall<>(
            gcpChannel,
            channelRef,
            METHOD_DESCRIPTOR,
            CallOptions.DEFAULT
                .withOption(GcpManagedChannel.AFFINITY_KEY, affinityKey)
                .withOption(GcpManagedChannel.UNBIND_AFFINITY_KEY, true));

    call.start(new ClientCall.Listener<String>() {}, new Metadata());

    ArgumentCaptor<ClientCall.Listener<String>> listenerCaptor =
        (ArgumentCaptor<ClientCall.Listener<String>>)
            (ArgumentCaptor<?>) ArgumentCaptor.forClass(ClientCall.Listener.class);
    verify(delegateCall).start(listenerCaptor.capture(), any(Metadata.class));

    assertThat(gcpChannel.affinityKeyToChannelRef).containsKey(affinityKey);

    listenerCaptor.getValue().onClose(Status.OK, new Metadata());

    assertThat(gcpChannel.affinityKeyToChannelRef).doesNotContainKey(affinityKey);
    assertThat(channelRef.getAffinityCount()).isEqualTo(0);
  }

  @SuppressWarnings("unchecked")
  @Test
  public void simpleCallKeepsAffinityKeyOnCloseWhenUnbindNotRequested() {
    String affinityKey = "txn-2";
    gcpChannel.bind(channelRef, Collections.singletonList(affinityKey));

    GcpClientCall.SimpleGcpClientCall<String, String> call =
        new GcpClientCall.SimpleGcpClientCall<>(
            gcpChannel,
            channelRef,
            METHOD_DESCRIPTOR,
            CallOptions.DEFAULT.withOption(GcpManagedChannel.AFFINITY_KEY, affinityKey));

    call.start(new ClientCall.Listener<String>() {}, new Metadata());

    ArgumentCaptor<ClientCall.Listener<String>> listenerCaptor =
        (ArgumentCaptor<ClientCall.Listener<String>>)
            (ArgumentCaptor<?>) ArgumentCaptor.forClass(ClientCall.Listener.class);
    verify(delegateCall).start(listenerCaptor.capture(), any(Metadata.class));

    listenerCaptor.getValue().onClose(Status.OK, new Metadata());

    assertThat(gcpChannel.affinityKeyToChannelRef).containsEntry(affinityKey, channelRef);
    assertThat(channelRef.getAffinityCount()).isEqualTo(1);
  }

  @Test
  public void simpleCallUnbindsAffinityKeyOnCancel() {
    String affinityKey = "txn-3";
    gcpChannel.bind(channelRef, Collections.singletonList(affinityKey));

    GcpClientCall.SimpleGcpClientCall<String, String> call =
        new GcpClientCall.SimpleGcpClientCall<>(
            gcpChannel,
            channelRef,
            METHOD_DESCRIPTOR,
            CallOptions.DEFAULT.withOption(GcpManagedChannel.AFFINITY_KEY, affinityKey));

    call.start(new ClientCall.Listener<String>() {}, new Metadata());
    call.cancel("cancelled", null);

    assertThat(gcpChannel.affinityKeyToChannelRef).doesNotContainKey(affinityKey);
    assertThat(channelRef.getAffinityCount()).isEqualTo(0);
    verify(delegateCall).cancel("cancelled", null);
  }
}
