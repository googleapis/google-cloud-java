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
package com.google.api.gax.grpc;

import com.google.api.core.InternalExtensionOnly;
import com.google.api.gax.core.ResourceCloseException;
import com.google.api.gax.rpc.TransportChannel;
import com.google.auto.value.AutoValue;
import io.grpc.Channel;
import io.grpc.ManagedChannel;
import java.util.concurrent.TimeUnit;

/** Implementation of TransportChannel based on gRPC. */
@AutoValue
@InternalExtensionOnly
public abstract class GrpcTransportChannel implements TransportChannel {

  /** The name of the Grpc transport. */
  public static String getGrpcTransportName() {
    return "grpc";
  }

  @Override
  public String getTransportName() {
    return getGrpcTransportName();
  }

  @Override
  public GrpcCallContext getEmptyCallContext() {
    return GrpcCallContext.createDefault();
  }

  /** The channel in use. */
  abstract ManagedChannel getManagedChannel();

  public abstract boolean isDirectPath();

  public Channel getChannel() {
    return getManagedChannel();
  }

  @Override
  public void shutdown() {
    getManagedChannel().shutdown();
  }

  @Override
  public boolean isShutdown() {
    return getManagedChannel().isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return getManagedChannel().isTerminated();
  }

  @Override
  public void shutdownNow() {
    getManagedChannel().shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return getManagedChannel().awaitTermination(duration, unit);
  }

  @Override
  public void close() {
    getManagedChannel().shutdown();
    try {
      awaitTermination(6, TimeUnit.MINUTES);
    } catch (InterruptedException e) {
      throw new ResourceCloseException(e);
    }
  }

  public static Builder newBuilder() {
    return new AutoValue_GrpcTransportChannel.Builder().setDirectPath(false);
  }

  public static GrpcTransportChannel create(ManagedChannel channel) {
    return newBuilder().setManagedChannel(channel).build();
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder setManagedChannel(ManagedChannel value);

    abstract Builder setDirectPath(boolean value);

    public abstract GrpcTransportChannel build();
  }
}
