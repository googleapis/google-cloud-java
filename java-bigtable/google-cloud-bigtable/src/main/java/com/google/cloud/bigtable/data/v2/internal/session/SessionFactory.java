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

package com.google.cloud.bigtable.data.v2.internal.session;

import com.google.bigtable.v2.SessionRequest;
import com.google.bigtable.v2.SessionResponse;
import com.google.cloud.bigtable.data.v2.internal.channels.ChannelPool;
import com.google.cloud.bigtable.data.v2.internal.channels.SessionStream;
import io.grpc.CallOptions;
import io.grpc.MethodDescriptor;

/** Wrapper around a channel to centralize per call session customizations. */
public final class SessionFactory {
  private final ChannelPool channelPool;
  private final MethodDescriptor<SessionRequest, SessionResponse> methodDescriptor;
  private final CallOptions callOptions;

  public SessionFactory(
      ChannelPool channelPool,
      MethodDescriptor<SessionRequest, SessionResponse> methodDescriptor,
      CallOptions callOptions) {
    this.channelPool = channelPool;
    this.methodDescriptor = methodDescriptor;
    this.callOptions = callOptions;
  }

  public SessionStream createNew() {
    return channelPool.newStream(methodDescriptor, callOptions);
  }
}
