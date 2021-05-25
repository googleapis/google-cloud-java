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
import javax.annotation.Nullable;

/** Options for the {@link GcpManagedChannel}. */
public class GcpManagedChannelOptions {
  private static final Logger logger = Logger.getLogger(GcpManagedChannelOptions.class.getName());

  @Nullable private final GcpMetricsOptions metricsOptions;
  @Nullable private final GcpResiliencyOptions resiliencyOptions;

  public GcpManagedChannelOptions() {
    metricsOptions = null;
    resiliencyOptions = null;
  }

  public GcpManagedChannelOptions(Builder builder) {
    metricsOptions = builder.metricsOptions;
    resiliencyOptions = builder.resiliencyOptions;
  }

  @Nullable
  public GcpMetricsOptions getMetricsOptions() {
    return metricsOptions;
  }

  @Nullable
  public GcpResiliencyOptions getResiliencyOptions() {
    return resiliencyOptions;
  }

  /** Creates a new GcpManagedChannelOptions.Builder. */
  public static Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {
    private GcpMetricsOptions metricsOptions;
    private GcpResiliencyOptions resiliencyOptions;

    public Builder() {}

    public GcpManagedChannelOptions build() {
      return new GcpManagedChannelOptions(this);
    }

    /**
     * Sets the metrics configuration for the {@link GcpManagedChannel}.
     *
     * <p>If a {@link MetricRegistry} is provided in {@link GcpMetricsOptions} then the
     * GcpManagedChannel will emit metrics using that registry. The metrics options also allow to
     * set up labels (tags) and a prefix for metrics names. The GcpManagedChannel will add its own
     * label "pool_index" with values "pool-0", "pool-1", etc. for each instance of
     * GcpManagedChannel created.
     *
     * <p>Example usage (e. g. with export to Cloud Monitoring)
     *
     * <pre>
     * // Enable Cloud Monitoring exporter.
     * StackdriverStatsExporter.createAndRegister();
     *
     * // Configure metrics options.
     * GcpMetricsOptions metricsOptions = GcpMetricsOptions.newBuilder(Metrics.getMetricRegistry())
     *     .withNamePrefix("myapp/gcp-pool/")
     *     .build());
     *
     * final GcpManagedChannel pool =
     *     (GcpManagedChannel)
     *         GcpManagedChannelBuilder.forDelegateBuilder(builder)
     *             .withOptions(
     *                 GcpManagedChannelOptions.newBuilder()
     *                     .withMetricsOptions(metricsOptions)
     *                     .build())
     *             .build();
     *
     * // Use the pool that will emit metrics which will be exported to Cloud Monitoring.
     * </pre>
     *
     * @param metricsOptions a {@link GcpMetricsOptions} to use as metrics configuration.
     */
    public Builder withMetricsOptions(GcpMetricsOptions metricsOptions) {
      this.metricsOptions = metricsOptions;
      return this;
    }

    /**
     * Sets the resiliency configuration for the {@link GcpManagedChannel}.
     *
     * @param resiliencyOptions a {@link GcpResiliencyOptions} to use as resiliency configuration.
     */
    public Builder withResiliencyOptions(GcpResiliencyOptions resiliencyOptions) {
      this.resiliencyOptions = resiliencyOptions;
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

  /** Resiliency configuration for the GCP managed channel. */
  public static class GcpResiliencyOptions {
    private final boolean notReadyFallbackEnabled;

    public GcpResiliencyOptions(Builder builder) {
      notReadyFallbackEnabled = builder.notReadyFallbackEnabled;
    }

    /** Creates a new GcpResiliencyOptions.Builder. */
    public static Builder newBuilder() {
      return new Builder();
    }

    public boolean isNotReadyFallbackEnabled() {
      return notReadyFallbackEnabled;
    }

    public static class Builder {
      private boolean notReadyFallbackEnabled = false;

      public Builder() {}

      public GcpResiliencyOptions build() {
        return new GcpResiliencyOptions(this);
      }

      /**
       * Temporarily fallback requests to a ready channel from a channel which is not ready to send
       * a request immediately. The fallback will happen if the pool has another channel in the
       * READY state and that channel has less than maximum allowed concurrent active streams.
       */
      public Builder enableNotReadyFallback() {
        notReadyFallbackEnabled = true;
        return this;
      }
    }
  }
}
