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

import io.grpc.CallOptions;
import io.grpc.ClientCall;
import io.grpc.ClientCall.Listener;
import io.grpc.ConnectivityState;
import io.grpc.ForwardingClientCall;
import io.grpc.ForwardingClientCallListener;
import io.grpc.ManagedChannel;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * A wrapper of real grpc channel. Also provides helper functions to calculate affinity counts and
 * active streams count.
 */
public class ChannelRef extends ManagedChannel {

  private final ManagedChannel delegate;
  private final int channelId;
  // The numbber of times this channel has been bound with a affinityKey.
  private AtomicInteger affinityCount;
  private AtomicInteger activeStreamsCount;

  public ChannelRef(ManagedChannel channel, int channelId) {
    this.delegate = channel;
    this.channelId = channelId;
    this.affinityCount = new AtomicInteger(0);
    this.activeStreamsCount = new AtomicInteger(0);
  }

  public ChannelRef(
      ManagedChannel channel, int channelId, int affinityCount, int activeStreamsCount) {
    this.delegate = channel;
    this.channelId = channelId;
    this.affinityCount = new AtomicInteger(affinityCount);
    this.activeStreamsCount = new AtomicInteger(activeStreamsCount);
  }

  public void affinityCountIncr() {
    affinityCount.incrementAndGet();
  }

  public void affinityCountDecr() {
    affinityCount.decrementAndGet();
  }

  public int getAffinityCount() {
    return affinityCount.get();
  }

  public int getActiveStreamsCount() {
    return activeStreamsCount.get();
  }

  public ManagedChannel getChannel() {
    return delegate;
  }

  @Override
  public ManagedChannel shutdown() {
    return delegate.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return delegate.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return delegate.isTerminated();
  }

  @Override
  public ManagedChannel shutdownNow() {
    return delegate.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
    return delegate.awaitTermination(timeout, unit);
  }

  @Override
  public ConnectivityState getState(boolean requestConnection) {
    return delegate.getState(requestConnection);
  }

  /**
   * The mechanism of managing the channel pool.
   *
   * <p>We select a managed channel, and change its call's listener. Everytime a call starts/ ends,
   * the number of streams of that channel will be changed.
   */
  @Override
  public <ReqT, RespT> ClientCall<ReqT, RespT> newCall(
      MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions) {

    final AtomicBoolean decremented = new AtomicBoolean(false);

    return new ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT>(
        delegate.newCall(methodDescriptor, callOptions)) {

      @Override
      public void start(io.grpc.ClientCall.Listener<RespT> responseListener, Metadata headers) {
        Listener<RespT> listener =
            new ForwardingClientCallListener.SimpleForwardingClientCallListener<RespT>(
                responseListener) {
              @Override
              public void onClose(Status status, Metadata trailers) {
                if (!decremented.getAndSet(true)) {
                  activeStreamsCount.decrementAndGet();
                }
                super.onClose(status, trailers);
              }
            };
        activeStreamsCount.incrementAndGet();
        super.start(listener, headers);
      }

      @Override
      public void cancel(String message, Throwable cause) {
        if (!decremented.getAndSet(true)) {
          activeStreamsCount.decrementAndGet();
        }
        super.cancel(message, cause);
      }
    };
  }

  @Override
  public String authority() {
    return delegate.authority();
  }
}
