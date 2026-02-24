/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.bigtable.data.v2.internal.csm.metrics;

import com.google.cloud.bigtable.data.v2.internal.csm.attributes.ClientInfo;
import com.google.cloud.bigtable.data.v2.internal.csm.attributes.EnvInfo;
import com.google.cloud.bigtable.data.v2.internal.csm.schema.GrpcClientSchema;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import java.util.List;

/**
 * Base class for gRpc metrics that are exported using bigtable_client schema.
 *
 * <p>gRPC doesn't record the bigtable specific metric labels, so they must be passed to the
 * exporter via a side channel.
 */
public class GrpcMetric extends MetricWrapper<GrpcClientSchema> {
  public static final String METER_SCOPE = "grpc-java";

  private final List<AttributeKey<?>> metricKeys;

  public GrpcMetric(String name, List<String> metricKeys) {
    super(GrpcClientSchema.INSTANCE, name);
    this.metricKeys =
        metricKeys.stream().map(AttributeKey::stringKey).collect(ImmutableList.toImmutableList());
  }

  @Override
  public ImmutableMap<String, String> extractMetricLabels(
      Attributes metricAttrs, EnvInfo ignored1, ClientInfo ignored2) {
    ImmutableMap.Builder<String, String> attributes = ImmutableMap.builder();

    for (AttributeKey<?> key : metricKeys) {
      String newKeyName = key.getKey().replace('.', '_');
      Object value = metricAttrs.get(key);
      if (value != null) {
        attributes.put(newKeyName, value.toString());
      }
    }

    return attributes.build();
  }

  @Override
  public String getExternalName() {
    return "bigtable.googleapis.com/internal/client/" + getName().replace('.', '/');
  }
}
