/*
 * Copyright 2019 Google LLC
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

package com.google.grpc.gcp;

import com.google.common.base.MoreObjects;
import com.google.grpc.gcp.proto.AffinityConfig;
import io.grpc.Attributes;
import io.grpc.CallOptions;
import io.grpc.ClientCall;
import io.grpc.ForwardingClientCall;
import io.grpc.ForwardingClientCallListener;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/**
 * A wrapper of ClientCall that can fetch the affinitykey from the request/response message.
 *
 * <p>It stores the information such as method, calloptions, the ChannelRef which created it, etc to
 * facilitate creating new calls. It gets the affinitykey from the request/response message, and
 * defines the callback functions to manage the number of active streams and bind/unbind the
 * affinity key with the channel.
 */
public class GcpClientCall<ReqT, RespT> extends ClientCall<ReqT, RespT> {

  private static final Logger logger = Logger.getLogger(GcpClientCall.class.getName());

  private final MethodDescriptor<ReqT, RespT> methodDescriptor;
  private final CallOptions callOptions;
  private final GcpManagedChannel delegateChannel;
  private final AffinityConfig affinity;

  private GcpManagedChannel.ChannelRef delegateChannelRef = null;
  private ClientCall<ReqT, RespT> delegateCall = null;
  private List<String> keys = null;
  private boolean received = false;
  private final AtomicBoolean decremented = new AtomicBoolean(false);

  @GuardedBy("this")
  private final Queue<Runnable> calls = new ArrayDeque<>();

  @GuardedBy("this")
  private boolean started;

  protected GcpClientCall(
      GcpManagedChannel delegateChannel,
      MethodDescriptor<ReqT, RespT> methodDescriptor,
      CallOptions callOptions,
      AffinityConfig affinity) {
    this.methodDescriptor = methodDescriptor;
    this.callOptions = callOptions;
    this.delegateChannel = delegateChannel;
    this.affinity = affinity;
  }

  @Override
  public void start(Listener<RespT> responseListener, Metadata headers) {
    checkSendMessage(() -> delegateCall.start(getListener(responseListener), headers));
  }

  @Override
  public void request(int numMessages) {
    checkSendMessage(() -> delegateCall.request(numMessages));
  }

  @Override
  public void setMessageCompression(boolean enabled) {
    checkSendMessage(() -> delegateCall.setMessageCompression(enabled));
  }

  @Override
  public void cancel(@Nullable String message, @Nullable Throwable cause) {
    checkSendMessage(() -> checkedCancel(message, cause));
  }

  @Override
  public void halfClose() {
    checkSendMessage(() -> delegateCall.halfClose());
  }

  /**
   * Delay executing operations until call.sendMessage() is called, switch the channel, start the
   * call, do previous operations, and finally do sendMessage().
   */
  @Override
  public void sendMessage(ReqT message) {
    synchronized (this) {
      if (!started) {
        // Check if the current channelRef is bound with the key and change it if necessary.
        // If no channel is bound with the key, use the least busy one.
        keys = delegateChannel.checkKey(message, true, methodDescriptor);
        String key = null;
        if (keys != null
            && keys.size() == 1
            && delegateChannel.getChannelRef(keys.get(0)) != null) {
          key = keys.get(0);
        }
        delegateChannelRef = delegateChannel.getChannelRef(key);
        delegateChannelRef.activeStreamsCountIncr();

        // Create the client call and do the previous operations.
        delegateCall = delegateChannelRef.getChannel().newCall(methodDescriptor, callOptions);
        for (Runnable call : calls) {
          call.run();
        }
        calls.clear();
        started = true;
      }
    }
    delegateCall.sendMessage(message);
  }

  /** Calls that send exactly one message should not check this method. */
  @Override
  public boolean isReady() {
    synchronized (this) {
      return started && delegateCall.isReady();
    }
  }

  /** May only be called after Listener#onHeaders or Listener#onClose. */
  @Override
  public Attributes getAttributes() {
    synchronized (this) {
      if (started) {
        return delegateCall.getAttributes();
      } else {
        throw new IllegalStateException("Calling getAttributes() before sendMessage().");
      }
    }
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("delegate", delegateCall).toString();
  }

  private void checkedCancel(@Nullable String message, @Nullable Throwable cause) {
    if (!decremented.getAndSet(true)) {
      delegateChannelRef.activeStreamsCountDecr();
    }
    delegateCall.cancel(message, cause);
  }

  private void checkSendMessage(Runnable call) {
    synchronized (this) {
      if (started) {
        call.run();
      } else {
        calls.add(call);
      }
    }
  }

  private Listener<RespT> getListener(final Listener<RespT> responseListener) {

    return new ForwardingClientCallListener.SimpleForwardingClientCallListener<RespT>(
        responseListener) {
      // Decrement the stream number by one when the call is closed.
      @Override
      public void onClose(Status status, Metadata trailers) {
        if (!decremented.getAndSet(true)) {
          delegateChannelRef.activeStreamsCountDecr();
        }
        // If the operation completed successfully, bind/unbind the affinity key.
        if (keys != null && status.getCode() == Status.Code.OK) {
          if (affinity.getCommand() == AffinityConfig.Command.UNBIND) {
            delegateChannel.unbind(keys.get(0));
          } else if (affinity.getCommand() == AffinityConfig.Command.BIND) {
            delegateChannel.bind(delegateChannelRef, keys);
          }
        }
        responseListener.onClose(status, trailers);
      }

      // If the command is "BIND", fetch the affinitykey from the response message and bind it
      // with the channelRef.
      @Override
      public void onMessage(RespT message) {
        if (!received) {
          received = true;
          if (keys == null) {
            keys = delegateChannel.checkKey(message, false, methodDescriptor);
          }
        }
        responseListener.onMessage(message);
      }
    };
  }

  /**
   * A simple wrapper of ClientCall.
   *
   * <p>It defines the callback function to manage the number of active streams of a ChannelRef
   * everytime a call is started/closed.
   */
  public static class SimpleGcpClientCall<ReqT, RespT> extends ForwardingClientCall<ReqT, RespT> {

    private final GcpManagedChannel.ChannelRef channelRef;
    private final ClientCall<ReqT, RespT> delegateCall;

    private final AtomicBoolean decremented = new AtomicBoolean(false);

    protected SimpleGcpClientCall(
        GcpManagedChannel.ChannelRef channelRef,
        MethodDescriptor<ReqT, RespT> methodDescriptor,
        CallOptions callOptions) {
      this.channelRef = channelRef;
      this.delegateCall = channelRef.getChannel().newCall(methodDescriptor, callOptions);
    }

    @Override
    protected ClientCall<ReqT, RespT> delegate() {
      return delegateCall;
    }

    @Override
    public void start(Listener<RespT> responseListener, Metadata headers) {

      Listener<RespT> listener =
          new ForwardingClientCallListener.SimpleForwardingClientCallListener<RespT>(
              responseListener) {
            @Override
            public void onClose(Status status, Metadata trailers) {
              if (!decremented.getAndSet(true)) {
                channelRef.activeStreamsCountDecr();
              }
              super.onClose(status, trailers);
            }
          };

      channelRef.activeStreamsCountIncr();
      delegateCall.start(listener, headers);
    }

    @Override
    public void cancel(String message, Throwable cause) {
      if (!decremented.getAndSet(true)) {
        channelRef.activeStreamsCountDecr();
      }
      delegateCall.cancel(message, cause);
    }
  }
}
