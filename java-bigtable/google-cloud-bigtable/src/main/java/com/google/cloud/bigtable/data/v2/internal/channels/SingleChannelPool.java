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

package com.google.cloud.bigtable.data.v2.internal.channels;

import com.google.bigtable.v2.SessionClientConfiguration.ChannelPoolConfiguration;
import com.google.bigtable.v2.SessionRequest;
import com.google.bigtable.v2.SessionResponse;
import io.grpc.CallOptions;
import io.grpc.ManagedChannel;
import io.grpc.MethodDescriptor;
import java.util.function.Supplier;

public class SingleChannelPool implements ChannelPool {
  private final Supplier<ManagedChannel> channelSupplier;
  private ManagedChannel channel;

  public SingleChannelPool(Supplier<ManagedChannel> channelSupplier) {
    this.channelSupplier = channelSupplier;
  }

  @Override
  public void start() {
    channel = channelSupplier.get();
  }

  @Override
  public void close() {
    channel.shutdown();
  }

  @Override
  public SessionStream newStream(
      MethodDescriptor<SessionRequest, SessionResponse> desc, CallOptions callOptions) {
    return new SessionStreamImpl(channel.newCall(desc, callOptions));
  }

  @Override
  public void updateConfig(ChannelPoolConfiguration config) {
    // No-op.
    return;
  }
}
