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
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.cloud.grpc.proto.AffinityConfig;
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

  private static final MethodDescriptor<String, String> STREAMING_METHOD_DESCRIPTOR =
      METHOD_DESCRIPTOR.toBuilder().setType(MethodDescriptor.MethodType.SERVER_STREAMING).build();

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

  @SuppressWarnings("unchecked")
  @Test
  public void unaryCallCountsExactlyOnceForWholeLifetime() {
    GcpClientCall.SimpleGcpClientCall<String, String> call =
        new GcpClientCall.SimpleGcpClientCall<>(
            gcpChannel, channelRef, METHOD_DESCRIPTOR, CallOptions.DEFAULT);

    assertThat(channelRef.getActiveStreamsCount()).isEqualTo(1);
    call.start(new ClientCall.Listener<String>() {}, new Metadata());
    assertThat(channelRef.getActiveStreamsCount()).isEqualTo(1);

    ArgumentCaptor<ClientCall.Listener<String>> listenerCaptor =
        (ArgumentCaptor<ClientCall.Listener<String>>)
            (ArgumentCaptor<?>) ArgumentCaptor.forClass(ClientCall.Listener.class);
    verify(delegateCall).start(listenerCaptor.capture(), any(Metadata.class));
    listenerCaptor.getValue().onClose(Status.OK, new Metadata());
    call.cancel("late cancel", null);

    assertThat(channelRef.getActiveStreamsCount()).isEqualTo(0);
  }

  @SuppressWarnings("unchecked")
  @Test
  public void streamingCallCountsOnceUntilTerminalClose() {
    when(delegateChannel.newCall(eq(STREAMING_METHOD_DESCRIPTOR), any(CallOptions.class)))
        .thenReturn(delegateCall);
    GcpClientCall.SimpleGcpClientCall<String, String> call =
        new GcpClientCall.SimpleGcpClientCall<>(
            gcpChannel, channelRef, STREAMING_METHOD_DESCRIPTOR, CallOptions.DEFAULT);

    call.start(new ClientCall.Listener<String>() {}, new Metadata());
    call.sendMessage("request");
    call.request(10);
    assertThat(channelRef.getActiveStreamsCount()).isEqualTo(1);

    ArgumentCaptor<ClientCall.Listener<String>> listenerCaptor =
        (ArgumentCaptor<ClientCall.Listener<String>>)
            (ArgumentCaptor<?>) ArgumentCaptor.forClass(ClientCall.Listener.class);
    verify(delegateCall).start(listenerCaptor.capture(), any(Metadata.class));
    listenerCaptor.getValue().onClose(Status.OK, new Metadata());

    assertThat(channelRef.getActiveStreamsCount()).isEqualTo(0);
  }

  @Test
  public void simpleCallCancelledBeforeStartNeverDecrementsBelowZero() {
    GcpClientCall.SimpleGcpClientCall<String, String> call =
        new GcpClientCall.SimpleGcpClientCall<>(
            gcpChannel, channelRef, METHOD_DESCRIPTOR, CallOptions.DEFAULT);

    assertThat(channelRef.getActiveStreamsCount()).isEqualTo(1);
    call.cancel("before start", null);
    assertThat(channelRef.getActiveStreamsCount()).isEqualTo(0);
    call.start(new ClientCall.Listener<String>() {}, new Metadata());

    assertThat(channelRef.getActiveStreamsCount()).isEqualTo(0);
  }

  @SuppressWarnings("unchecked")
  @Test
  public void affinityCallCancelledBeforeFirstMessageDoesNotLeakOrDoubleDecrement() {
    gcpChannel.channelRefs.add(channelRef);
    GcpClientCall<String, String> call =
        new GcpClientCall<>(
            gcpChannel,
            METHOD_DESCRIPTOR,
            CallOptions.DEFAULT,
            AffinityConfig.newBuilder()
                .setCommand(AffinityConfig.Command.BOUND)
                .setAffinityKey("name")
                .build());
    call.start(new ClientCall.Listener<String>() {}, new Metadata());
    call.cancel("before message", null);
    call.halfClose();
    assertThat(channelRef.getActiveStreamsCount()).isEqualTo(0);

    call.sendMessage("request");
    assertThat(channelRef.getActiveStreamsCount()).isEqualTo(0);
    ArgumentCaptor<ClientCall.Listener<String>> listenerCaptor =
        (ArgumentCaptor<ClientCall.Listener<String>>)
            (ArgumentCaptor<?>) ArgumentCaptor.forClass(ClientCall.Listener.class);
    verify(delegateCall).start(listenerCaptor.capture(), any(Metadata.class));
    verify(delegateCall).cancel("before message", null);
    verify(delegateCall, never()).halfClose();
    verify(delegateCall, never()).sendMessage(any());
    listenerCaptor.getValue().onClose(Status.CANCELLED, new Metadata());

    assertThat(channelRef.getActiveStreamsCount()).isEqualTo(0);
  }

  @Test
  public void affinityQueuedCallFailureClearsQueueAndReleasesCountOnce() {
    gcpChannel.channelRefs.add(channelRef);
    IllegalStateException failure = new IllegalStateException("queued start failed");
    doThrow(failure).when(delegateCall).start(any(), any(Metadata.class));
    GcpClientCall<String, String> call =
        new GcpClientCall<>(
            gcpChannel,
            METHOD_DESCRIPTOR,
            CallOptions.DEFAULT,
            AffinityConfig.newBuilder().setCommand(AffinityConfig.Command.BOUND).build());
    call.start(new ClientCall.Listener<String>() {}, new Metadata());
    call.request(1);
    assertThat(call.queuedCallCountForTest()).isEqualTo(2);

    IllegalStateException thrown =
        assertThrows(IllegalStateException.class, () -> call.sendMessage("request"));

    assertThat(thrown).isSameInstanceAs(failure);
    assertThat(call.queuedCallCountForTest()).isEqualTo(0);
    assertThat(channelRef.getActiveStreamsCount()).isEqualTo(0);
    call.sendMessage("ignored after failure");
    assertThat(channelRef.getActiveStreamsCount()).isEqualTo(0);
    call.cancel("late cancel", null);
    assertThat(channelRef.getActiveStreamsCount()).isEqualTo(0);
  }

  @Test
  public void affinityCallPropagatesSelectedChannelIdInCallOptions() {
    gcpChannel.channelRefs.add(channelRef);
    GcpClientCall<String, String> call =
        new GcpClientCall<>(
            gcpChannel,
            METHOD_DESCRIPTOR,
            CallOptions.DEFAULT,
            AffinityConfig.newBuilder().setCommand(AffinityConfig.Command.BOUND).build());

    call.sendMessage("request");

    ArgumentCaptor<CallOptions> optionsCaptor = ArgumentCaptor.forClass(CallOptions.class);
    verify(delegateChannel).newCall(eq(METHOD_DESCRIPTOR), optionsCaptor.capture());
    assertThat(optionsCaptor.getValue().getOption(GcpManagedChannel.CHANNEL_ID_KEY))
        .isEqualTo(channelRef.getId());
  }

  @Test
  public void gcpClientCall_exceptionInQueuedStart_doesNotLeakActiveStreamCount() {
    gcpChannel.channelRefs.add(channelRef);
    doThrow(new IllegalStateException("start failed"))
        .when(delegateCall)
        .start(any(), any(Metadata.class));
    GcpClientCall<String, String> call =
        new GcpClientCall<>(
            gcpChannel,
            METHOD_DESCRIPTOR,
            CallOptions.DEFAULT,
            AffinityConfig.newBuilder()
                .setCommand(AffinityConfig.Command.BOUND)
                .setAffinityKey("name")
                .build());
    call.start(new ClientCall.Listener<String>() {}, new Metadata());

    assertThrows(IllegalStateException.class, () -> call.sendMessage("request"));

    assertThat(channelRef.getActiveStreamsCount()).isEqualTo(0);
  }

  @Test
  public void simpleGcpClientCall_exceptionInStart_doesNotLeakActiveStreamCount() {
    doThrow(new IllegalStateException("start failed"))
        .when(delegateCall)
        .start(any(), any(Metadata.class));
    GcpClientCall.SimpleGcpClientCall<String, String> call =
        new GcpClientCall.SimpleGcpClientCall<>(
            gcpChannel, channelRef, METHOD_DESCRIPTOR, CallOptions.DEFAULT);

    assertThrows(
        IllegalStateException.class,
        () -> call.start(new ClientCall.Listener<String>() {}, new Metadata()));

    assertThat(channelRef.getActiveStreamsCount()).isEqualTo(0);
  }

  @Test
  public void gcpClientCall_exceptionInSendMessage_doesNotLeakActiveStreamCount() {
    gcpChannel.channelRefs.add(channelRef);
    doThrow(new IllegalStateException("send failed")).when(delegateCall).sendMessage("request");
    GcpClientCall<String, String> call =
        new GcpClientCall<>(
            gcpChannel,
            METHOD_DESCRIPTOR,
            CallOptions.DEFAULT,
            AffinityConfig.newBuilder()
                .setCommand(AffinityConfig.Command.BOUND)
                .setAffinityKey("name")
                .build());
    call.start(new ClientCall.Listener<String>() {}, new Metadata());

    assertThrows(IllegalStateException.class, () -> call.sendMessage("request"));

    assertThat(channelRef.getActiveStreamsCount()).isEqualTo(0);
  }

  @Test
  public void simpleGcpClientCall_exceptionInSendMessage_doesNotLeakActiveStreamCount() {
    doThrow(new IllegalStateException("send failed")).when(delegateCall).sendMessage("request");
    GcpClientCall.SimpleGcpClientCall<String, String> call =
        new GcpClientCall.SimpleGcpClientCall<>(
            gcpChannel, channelRef, METHOD_DESCRIPTOR, CallOptions.DEFAULT);
    call.start(new ClientCall.Listener<String>() {}, new Metadata());

    assertThrows(IllegalStateException.class, () -> call.sendMessage("request"));

    assertThat(channelRef.getActiveStreamsCount()).isEqualTo(0);
  }
}
