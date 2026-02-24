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

import com.google.api.MonitoredResource;
import com.google.cloud.bigtable.data.v2.internal.csm.attributes.ClientInfo;
import com.google.cloud.bigtable.data.v2.internal.csm.attributes.EnvInfo;
import com.google.cloud.bigtable.data.v2.internal.csm.schema.Schema;
import com.google.common.collect.ImmutableMap;
import io.opentelemetry.api.common.Attributes;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * Base class for all the metrics.
 *
 * <p>Each metric is composed of an OpenTelemetry instrument (ie histogram), and a set of resource
 * and metric attributes. Since some of the resource attributes are dynamic, all the resource
 * attributes are sent to the instrument as metric {@link Attributes}. Then during the export phase,
 * a {@link MonitoredResource} and a set of metric labels are extracted from the collected
 * attributes.
 *
 * <p>This base class implements the foundation of this lifecycle:
 *
 * <ul>
 *   <li>The instrument for recording is passed in during construction
 *   <li>The concrete subclass will define a metric specific typesafe record method to populate the
 *       metric labels for the instrument
 *   <li>The list of resource attribute keys are defined by a resource specific subclass and passed
 *       in during construction. These will be used by {@code MetricWrapper.createMonitoredResource}
 *       to create the monitored resource during the export phase
 *   <li>The remaining attributes will be added as metric labels
 * </ul>
 */
public abstract class MetricWrapper<SchemaT extends Schema> {
  private final SchemaT schema;
  private final String name;

  public MetricWrapper(SchemaT schema, String name) {
    this.schema = schema;
    this.name = name;
  }

  public SchemaT getSchema() {
    return schema;
  }

  /**
   * Used by the Exporter to compose metric labels to be sent to Cloud Monitoring.
   *
   * <p>Extracts metric labels from metric {@link Attributes}. By default, all keys that are not
   * listed in {@code resourceKeys} are extracted. However, subclasses can override this method to
   * inject data from {@link EnvInfo} and {@link ClientInfo}.
   */
  public ImmutableMap<String, String> extractMetricLabels(
      Attributes metricAttrs, EnvInfo envInfo, ClientInfo clientInfo) {
    ImmutableMap.Builder<String, String> builder = ImmutableMap.builder();
    metricAttrs.forEach(
        (k, v) -> {
          if (!getSchema().getResourceKeys().contains(k) && v != null) {
            builder.put(k.getKey(), v.toString());
          }
        });
    return builder.build();
  }

  /**
   * Used by the Exporter to match an instance of this class to the aggregated timeseries to export.
   *
   * <p>Gets the name of the metric. This is used by the exporter to look up this metric definition
   * in MetricRegistry during export.
   */
  public String getName() {
    return name;
  }

  /**
   * Used by the exporter to post process the metric name from grpc conventions to Cloud Monitoring.
   */
  public String getExternalName() {
    return getName();
  }

  /** Converts a duration in fractional milliseconds. */
  protected static double toMillis(Duration duration) {
    return Math.round(((double) duration.toNanos()) / TimeUnit.MILLISECONDS.toNanos(1) * 100.0)
        / 100.0;
  }
}
