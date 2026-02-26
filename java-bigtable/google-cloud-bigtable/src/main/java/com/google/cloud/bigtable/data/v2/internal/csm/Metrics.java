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
package com.google.cloud.bigtable.data.v2.internal.csm;

import com.google.api.gax.tracing.ApiTracerFactory;
import com.google.cloud.bigtable.data.v2.internal.csm.attributes.ClientInfo;
import com.google.cloud.bigtable.data.v2.stub.metrics.ChannelPoolMetricsTracer;
import io.grpc.ManagedChannelBuilder;
import java.io.Closeable;
import java.io.IOException;
import javax.annotation.Nullable;

public interface Metrics extends Closeable {
  ApiTracerFactory createTracerFactory(ClientInfo clientInfo) throws IOException;

  <T extends ManagedChannelBuilder<?>> T configureGrpcChannel(T channelBuilder);

  @Nullable
  ChannelPoolMetricsTracer getChannelPoolMetricsTracer();

  void start();

  @Override
  void close();
}
