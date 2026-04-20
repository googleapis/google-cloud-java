/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.spanner.spi.v1;

import com.google.api.core.ApiFunction;
import com.google.cloud.grpc.GcpManagedChannelBuilder;
import com.google.cloud.grpc.GcpManagedChannelOptions;
import io.grpc.ManagedChannelBuilder;
import javax.annotation.Nullable;

/**
 * Rebuilds the grpc-gcp wrapper for routed endpoint channels while preserving the base channel
 * configuration.
 */
final class GrpcGcpEndpointChannelConfigurator {
  @Nullable
  private final ApiFunction<ManagedChannelBuilder, ManagedChannelBuilder> baseConfigurator;

  private final String apiConfigJson;
  private final GcpManagedChannelOptions grpcGcpOptions;

  GrpcGcpEndpointChannelConfigurator(
      @Nullable ApiFunction<ManagedChannelBuilder, ManagedChannelBuilder> baseConfigurator,
      String apiConfigJson,
      GcpManagedChannelOptions grpcGcpOptions) {
    this.baseConfigurator = baseConfigurator;
    this.apiConfigJson = apiConfigJson;
    this.grpcGcpOptions = grpcGcpOptions;
  }

  ManagedChannelBuilder configure(ManagedChannelBuilder channelBuilder) {
    ManagedChannelBuilder effectiveBuilder = channelBuilder;
    if (baseConfigurator != null) {
      effectiveBuilder = baseConfigurator.apply(effectiveBuilder);
    }
    return GcpManagedChannelBuilder.forDelegateBuilder(effectiveBuilder)
        .withApiConfigJsonString(apiConfigJson)
        .withOptions(grpcGcpOptions);
  }
}
