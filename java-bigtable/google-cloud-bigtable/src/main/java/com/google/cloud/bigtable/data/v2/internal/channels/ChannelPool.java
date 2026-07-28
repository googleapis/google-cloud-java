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
import io.grpc.MethodDescriptor;

public interface ChannelPool extends AutoCloseable {

  void start();

  @Override
  void close();

  SessionStream newStream(
      MethodDescriptor<SessionRequest, SessionResponse> desc, CallOptions callOptions);

  void updateConfig(ChannelPoolConfiguration config);
}
