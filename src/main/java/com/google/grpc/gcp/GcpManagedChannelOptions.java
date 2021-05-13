/*
 * Copyright 2021 Google LLC
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

import io.opencensus.metrics.LabelKey;
import io.opencensus.metrics.LabelValue;
import io.opencensus.metrics.MetricRegistry;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/** Options for the {@link GcpManagedChannel}. */
public class GcpManagedChannelOptions {
  private static final Logger logger = Logger.getLogger(GcpManagedChannelOptions.class.getName());

  private final GcpMetricsOptions metricsOptions;

  public GcpManagedChannelOptions() {
    metricsOptions = null;
  }

  public GcpManagedChannelOptions(Builder builder) {
    metricsOptions = builder.metricsOptions;
  }

  public GcpMetricsOptions getMetricsOptions() {
    return metricsOptions;
  }

  /** Creates a new GcpManagedChannelOptions.Builder. */
  public static Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {
    private GcpMetricsOptions metricsOptions;

    public Builder() {}

    public GcpManagedChannelOptions build() {
      return new GcpManagedChannelOptions(this);
    }

    /**
     * Sets the metrics configuration for the {@link GcpManagedChannel}.
     *
     * @param metricsOptions a {@link GcpMetricsOptions} to use as metrics configuration.
     */
    public Builder withMetricsOptions(GcpMetricsOptions metricsOptions) {
      this.metricsOptions = metricsOptions;
      return this;
    }
  }

  /** Metrics configuration for the GCP managed channel. */
  public static class GcpMetricsOptions {
    // Unit to represent count.
    static final String COUNT = "1";

    private final MetricRegistry metricRegistry;
    private final List<LabelKey> labelKeys;
    private final List<LabelValue> labelValues;
    private final String namePrefix;

    public GcpMetricsOptions(Builder builder) {
      metricRegistry = builder.metricRegistry;
      labelKeys = builder.labelKeys;
      labelValues = builder.labelValues;
      namePrefix = builder.namePrefix;
    }

    public MetricRegistry getMetricRegistry() {
      return metricRegistry;
    }

    public List<LabelKey> getLabelKeys() {
      return labelKeys;
    }

    public List<LabelValue> getLabelValues() {
      return labelValues;
    }

    public String getNamePrefix() {
      return namePrefix;
    }

    /**
     * Creates a new GcpMetricsOptions.Builder.
     *
     * @param metricRegistry {@link MetricRegistry} to create and register metrics.
     */
    public static Builder newBuilder(MetricRegistry metricRegistry) {
      return new Builder(metricRegistry);
    }

    public static class Builder {
      private final MetricRegistry metricRegistry;
      private List<LabelKey> labelKeys;
      private List<LabelValue> labelValues;
      private String namePrefix;

      /**
       * Constructor for GcpMetricsOptions.Builder.
       *
       * @param metricRegistry {@link MetricRegistry} to create and register metrics.
       */
      public Builder(MetricRegistry metricRegistry) {
        this.metricRegistry = metricRegistry;
        labelKeys = new ArrayList<>();
        labelValues = new ArrayList<>();
        namePrefix = "";
      }

      public GcpMetricsOptions build() {
        return new GcpMetricsOptions(this);
      }

      /**
       * Sets label keys and values to report with the metrics. The size of keys and values lists
       * must match. Otherwise the labels will not be applied.
       *
       * @param labelKeys a list of {@link LabelKey}.
       * @param labelValues a list of {@link LabelValue}.
       */
      public Builder withLabels(List<LabelKey> labelKeys, List<LabelValue> labelValues) {
        if (labelKeys == null || labelValues == null || labelKeys.size() != labelValues.size()) {
          logger.warning("Unable to set label keys and values - size mismatch or null.");
          return this;
        }
        this.labelKeys = labelKeys;
        this.labelValues = labelValues;
        return this;
      }

      /**
       * Sets the prefix for all metric names reported by GcpManagedChannel.
       *
       * @param namePrefix the prefix for metrics names.
       */
      public Builder withNamePrefix(String namePrefix) {
        this.namePrefix = namePrefix;
        return this;
      }
    }
  }
}
