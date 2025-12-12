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

package com.google.cloud.grpc;

import com.google.common.base.Preconditions;
import io.opencensus.metrics.LabelKey;
import io.opencensus.metrics.LabelValue;
import io.opencensus.metrics.MetricRegistry;
import io.opentelemetry.api.metrics.Meter;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/** Options for the {@link GcpManagedChannel}. */
public class GcpManagedChannelOptions {
  private static final Logger logger = Logger.getLogger(GcpManagedChannelOptions.class.getName());

  @Nullable private final GcpChannelPoolOptions channelPoolOptions;
  @Nullable private final GcpMetricsOptions metricsOptions;
  @Nullable private final GcpResiliencyOptions resiliencyOptions;

  public GcpManagedChannelOptions() {
    channelPoolOptions = null;
    metricsOptions = null;
    resiliencyOptions = null;
  }

  public GcpManagedChannelOptions(Builder builder) {
    channelPoolOptions = builder.channelPoolOptions;
    metricsOptions = builder.metricsOptions;
    resiliencyOptions = builder.resiliencyOptions;
  }

  @Nullable
  public GcpChannelPoolOptions getChannelPoolOptions() {
    return channelPoolOptions;
  }

  @Nullable
  public GcpMetricsOptions getMetricsOptions() {
    return metricsOptions;
  }

  @Nullable
  public GcpResiliencyOptions getResiliencyOptions() {
    return resiliencyOptions;
  }

  @Override
  public String toString() {
    return String.format(
        "{channelPoolOptions: %s, resiliencyOptions: %s, metricsOptions: %s}",
        getChannelPoolOptions(), getResiliencyOptions(), getMetricsOptions());
  }

  /** Creates a new GcpManagedChannelOptions.Builder. */
  public static Builder newBuilder() {
    return new Builder();
  }

  /** Creates a new GcpManagedChannelOptions.Builder from GcpManagedChannelOptions. */
  public static Builder newBuilder(GcpManagedChannelOptions options) {
    return new Builder(options);
  }

  public static class Builder {
    private GcpChannelPoolOptions channelPoolOptions;
    private GcpMetricsOptions metricsOptions;
    private GcpResiliencyOptions resiliencyOptions;

    public Builder() {}

    public Builder(GcpManagedChannelOptions options) {
      this.channelPoolOptions = options.getChannelPoolOptions();
      this.metricsOptions = options.getMetricsOptions();
      this.resiliencyOptions = options.getResiliencyOptions();
    }

    public GcpManagedChannelOptions build() {
      return new GcpManagedChannelOptions(this);
    }

    /**
     * Sets the channel pool configuration for the {@link GcpManagedChannel}.
     *
     * @param channelPoolOptions a {@link GcpChannelPoolOptions} to use as a channel pool
     *     configuration.
     */
    public Builder withChannelPoolOptions(GcpChannelPoolOptions channelPoolOptions) {
      this.channelPoolOptions = channelPoolOptions;
      return this;
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

  /** Channel pool configuration for the GCP managed channel. */
  public static class GcpChannelPoolOptions {
    // The maximum number of channels in the pool.
    private final int maxSize;
    // The minimum size of the channel pool. This number of channels will be created and these
    // channels will try to always keep connection to the server.
    private final int minSize;
    // If every channel in the pool has at least this amount of concurrent streams then a new
    // channel will be created
    // in the pool unless the pool reached its maximum size.
    private final int concurrentStreamsLowWatermark;
    // The number of channels to initialize the pool with.
    // If it is less than minSize it is ignored.
    private final int initSize;

    // The following three options enable the dynamic scaling functionality
    // if all of them are positive.

    // Minimum desired average concurrent calls per channel.
    private final int minRpcPerChannel;
    // Maximim desired average concurrent calls per channel.
    private final int maxRpcPerChannel;
    // How often to check for a possibility to scale down.
    private final Duration scaleDownInterval;

    // Use round-robin channel selection for affinity binding calls.
    private final boolean useRoundRobinOnBind;
    // How long to keep an affinity key after its last use.
    private final Duration affinityKeyLifetime;
    // How frequently affinity key cleanup process runs.
    private final Duration cleanupInterval;

    public GcpChannelPoolOptions(Builder builder) {
      maxSize = builder.maxSize;
      minSize = builder.minSize;
      initSize = builder.initSize;
      minRpcPerChannel = builder.minRpcPerChannel;
      maxRpcPerChannel = builder.maxRpcPerChannel;
      scaleDownInterval = builder.scaleDownInterval;
      concurrentStreamsLowWatermark = builder.concurrentStreamsLowWatermark;
      useRoundRobinOnBind = builder.useRoundRobinOnBind;
      affinityKeyLifetime = builder.affinityKeyLifetime;
      cleanupInterval = builder.cleanupInterval;
    }

    public int getMaxSize() {
      return maxSize;
    }

    public int getMinSize() {
      return minSize;
    }

    public int getInitSize() {
      return initSize;
    }

    public int getMinRpcPerChannel() {
      return minRpcPerChannel;
    }

    public int getMaxRpcPerChannel() {
      return maxRpcPerChannel;
    }

    public Duration getScaleDownInterval() {
      return scaleDownInterval;
    }

    public int getConcurrentStreamsLowWatermark() {
      return concurrentStreamsLowWatermark;
    }

    public boolean isUseRoundRobinOnBind() {
      return useRoundRobinOnBind;
    }

    public Duration getAffinityKeyLifetime() {
      return affinityKeyLifetime;
    }

    public Duration getCleanupInterval() {
      return cleanupInterval;
    }

    /** Creates a new GcpChannelPoolOptions.Builder. */
    public static GcpChannelPoolOptions.Builder newBuilder() {
      return new GcpChannelPoolOptions.Builder();
    }

    /** Creates a new GcpChannelPoolOptions.Builder from GcpChannelPoolOptions. */
    public static GcpChannelPoolOptions.Builder newBuilder(GcpChannelPoolOptions options) {
      return new GcpChannelPoolOptions.Builder(options);
    }

    @Override
    public String toString() {
      return String.format(
          "{maxSize: %d, minSize: %d, concurrentStreamsLowWatermark: %d, useRoundRobinOnBind: %s}",
          getMaxSize(), getMinSize(), getConcurrentStreamsLowWatermark(), isUseRoundRobinOnBind());
    }

    public static class Builder {
      private int maxSize = GcpManagedChannel.DEFAULT_MAX_CHANNEL;
      private int minSize = 0;
      private int initSize = 0;
      private int minRpcPerChannel = 0;
      private int maxRpcPerChannel = 0;
      private Duration scaleDownInterval = Duration.ZERO;
      private int concurrentStreamsLowWatermark = GcpManagedChannel.DEFAULT_MAX_STREAM;
      private boolean useRoundRobinOnBind = false;
      private Duration affinityKeyLifetime = Duration.ZERO;
      private Duration cleanupInterval = Duration.ZERO;

      public Builder() {}

      public Builder(GcpChannelPoolOptions options) {
        this();
        if (options == null) {
          return;
        }
        this.maxSize = options.getMaxSize();
        this.minSize = options.getMinSize();
        this.initSize = options.getInitSize();
        this.minRpcPerChannel = options.getMinRpcPerChannel();
        this.maxRpcPerChannel = options.getMaxRpcPerChannel();
        this.scaleDownInterval = options.getScaleDownInterval();
        this.concurrentStreamsLowWatermark = options.getConcurrentStreamsLowWatermark();
        this.useRoundRobinOnBind = options.isUseRoundRobinOnBind();
        this.affinityKeyLifetime = options.getAffinityKeyLifetime();
        this.cleanupInterval = options.getCleanupInterval();
      }

      public GcpChannelPoolOptions build() {
        return new GcpChannelPoolOptions(this);
      }

      /**
       * Sets the maximum size of the channel pool.
       *
       * @param maxSize maximum number of channels the pool can have.
       */
      public Builder setMaxSize(int maxSize) {
        Preconditions.checkArgument(maxSize > 0, "Channel pool size must be positive.");
        this.maxSize = maxSize;
        return this;
      }

      /**
       * Sets the minimum size of the channel pool. This number of channels will be created and
       * these channels will try to always keep connection to the server established.
       *
       * @param minSize minimum number of channels the pool must have.
       */
      public Builder setMinSize(int minSize) {
        Preconditions.checkArgument(
            minSize >= 0, "Channel pool minimum size must be 0 or positive.");
        this.minSize = minSize;
        return this;
      }

      /**
       * Sets the initial channel pool size. This is the number of channels that the pool will start
       * with. If it is less than {@link #setMinSize(int)} it is ignored.
       *
       * @param initSize number of channels to start the pool with.
       * @return
       */
      public Builder setInitSize(int initSize) {
        Preconditions.checkArgument(
            initSize >= 0, "Channel pool initial size must be 0 or positive.");
        this.initSize = initSize;
        return this;
      }

      /**
       * Enables dynamic scaling functionality.
       *
       * <p>When the average number of concurrent calls per channel reaches <code>maxRpcPerChannel
       * </code> the pool will create and add a new channel unless already at max size.
       *
       * <p>Every <code>scaleDownInterval</code> a check for downscaling is performed. Based on the
       * maximum total concurrent calls observed since the last check, the desired number of
       * channels is calculated as:
       *
       * <p><code>(max_total_concurrent_calls / minRpcPerChannel)</code> rounded up.
       *
       * <p>If the calculated desired number of channels is lower than the current number of
       * channels, the pool will be downscaled to the desired number or min size (whichever is
       * greater).
       *
       * <p>When downscaling, channels with the oldest connections are selected. Then the selected
       * channels are removed from the pool but are not instructed to shutdown until all calls are
       * completed. In a case when the pool is scaling up and there is a ready channel awaiting
       * calls completion, the channel will be re-used instead of creating a new channel.
       *
       * @param minRpcPerChannel minimum desired average concurrent calls per channel.
       * @param maxRpcPerChannel maximum desired average concurrent calls per channel.
       * @param scaleDownInterval how often to check for a possibility to scale down.
       */
      public Builder setDynamicScaling(
          int minRpcPerChannel, int maxRpcPerChannel, Duration scaleDownInterval) {
        Preconditions.checkArgument(
            minRpcPerChannel > 0, "Minimum RPCs per channel must be positive.");
        Preconditions.checkArgument(
            maxRpcPerChannel > 0, "Maximum RPCs per channel must be positive.");
        Preconditions.checkArgument(
            !scaleDownInterval.isNegative() && !scaleDownInterval.isZero(),
            "Scale down interval must be positive.");
        this.minRpcPerChannel = minRpcPerChannel;
        this.maxRpcPerChannel = maxRpcPerChannel;
        this.scaleDownInterval = scaleDownInterval;
        return this;
      }

      /**
       * Disables dynamic scaling functionality.
       *
       * @see #setDynamicScaling(int, int, Duration)
       */
      public Builder disableDynamicScaling() {
        this.minRpcPerChannel = 0;
        this.maxRpcPerChannel = 0;
        this.scaleDownInterval = Duration.ZERO;
        return this;
      }

      /**
       * Sets the concurrent streams low watermark. If every channel in the pool has at least this
       * amount of concurrent streams then a new channel will be created in the pool unless the pool
       * reached its maximum size.
       *
       * @param concurrentStreamsLowWatermark number of streams every channel must reach before
       *     adding a new channel to the pool.
       */
      public Builder setConcurrentStreamsLowWatermark(int concurrentStreamsLowWatermark) {
        this.concurrentStreamsLowWatermark = concurrentStreamsLowWatermark;
        return this;
      }

      /**
       * Enables/disables using round-robin channel selection for affinity binding calls.
       *
       * @param enabled If true, use round-robin channel selection for affinity binding calls.
       */
      public Builder setUseRoundRobinOnBind(boolean enabled) {
        this.useRoundRobinOnBind = enabled;
        return this;
      }

      /**
       * How long to keep an affinity key after its last use. Zero value means keeping keys forever.
       *
       * @param affinityKeyLifetime time since last use of a key to include the key in a cleanup.
       */
      public Builder setAffinityKeyLifetime(Duration affinityKeyLifetime) {
        Preconditions.checkArgument(
            !affinityKeyLifetime.isNegative(), "Affinity key lifetime may not be negative.");
        this.affinityKeyLifetime = affinityKeyLifetime;
        if (!affinityKeyLifetime.isZero() && this.cleanupInterval.isZero()) {
          this.cleanupInterval = affinityKeyLifetime.dividedBy(10);
        }
        return this;
      }

      /**
       * How frequently affinity key cleanup process should run. Zero value disables cleanup
       * process. If affinityKeyLifetime is not zero, this defaults to affinityKeyLifetime / 10.
       *
       * @param cleanupInterval frequency of affinity key cleanup.
       */
      public Builder setCleanupInterval(Duration cleanupInterval) {
        Preconditions.checkArgument(
            !cleanupInterval.isNegative(), "Cleanup interval must not be negative.");
        Preconditions.checkArgument(
            !cleanupInterval.isZero() || this.affinityKeyLifetime.isZero(),
            "Cleanup interval must not be zero when affinity key interval is above zero.");
        this.cleanupInterval = cleanupInterval;
        return this;
      }
    }
  }

  /** Metrics configuration for the GCP managed channel. */
  public static class GcpMetricsOptions {
    private final MetricRegistry metricRegistry;
    private final List<LabelKey> labelKeys;
    private final List<LabelValue> labelValues;
    private final String namePrefix;
    @Nullable private final Meter otelMeter;
    @Nullable private final List<String> otelLabelKeys;
    @Nullable private final List<String> otelLabelValues;

    public GcpMetricsOptions(Builder builder) {
      metricRegistry = builder.metricRegistry;
      labelKeys = builder.labelKeys;
      labelValues = builder.labelValues;
      namePrefix = builder.namePrefix;
      otelMeter = builder.otelMeter;
      otelLabelKeys = builder.otelLabelKeys;
      otelLabelValues = builder.otelLabelValues;
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

    @Nullable
    public Meter getOpenTelemetryMeter() {
      return otelMeter;
    }

    @Nullable
    public List<String> getOtelLabelKeys() {
      return otelLabelKeys;
    }

    @Nullable
    public List<String> getOtelLabelValues() {
      return otelLabelValues;
    }

    @Override
    public String toString() {
      Iterator<LabelKey> keyIterator = getLabelKeys().iterator();
      Iterator<LabelValue> valueIterator = getLabelValues().iterator();

      final List<String> labels = new ArrayList<>();
      while (keyIterator.hasNext() && valueIterator.hasNext()) {
        labels.add(
            String.format(
                "%s: \"%s\"", keyIterator.next().getKey(), valueIterator.next().getValue()));
      }
      return String.format(
          "{namePrefix: \"%s\", labels: [%s], metricRegistry: %s, otelMeter: %s}",
          getNamePrefix(), String.join(", ", labels), getMetricRegistry(), getOpenTelemetryMeter());
    }

    /** Creates a new GcpMetricsOptions.Builder. */
    public static Builder newBuilder() {
      return new Builder();
    }

    /** Creates a new GcpMetricsOptions.Builder from GcpMetricsOptions. */
    public static Builder newBuilder(GcpMetricsOptions options) {
      return new Builder(options);
    }

    public static class Builder {
      private MetricRegistry metricRegistry;
      private List<LabelKey> labelKeys;
      private List<LabelValue> labelValues;
      private String namePrefix;
      private Meter otelMeter;
      private List<String> otelLabelKeys;
      private List<String> otelLabelValues;

      /** Constructor for GcpMetricsOptions.Builder. */
      public Builder() {
        labelKeys = new ArrayList<>();
        labelValues = new ArrayList<>();
        namePrefix = "";
        otelLabelKeys = new ArrayList<>();
        otelLabelValues = new ArrayList<>();
      }

      public Builder(GcpMetricsOptions options) {
        this();
        if (options == null) {
          return;
        }
        this.metricRegistry = options.getMetricRegistry();
        this.labelKeys = options.getLabelKeys();
        this.labelValues = options.getLabelValues();
        this.namePrefix = options.getNamePrefix();
        this.otelMeter = options.getOpenTelemetryMeter();
        this.otelLabelKeys = options.getOtelLabelKeys();
        this.otelLabelValues = options.getOtelLabelValues();
      }

      public GcpMetricsOptions build() {
        return new GcpMetricsOptions(this);
      }

      public Builder withMetricRegistry(MetricRegistry registry) {
        this.metricRegistry = registry;
        return this;
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

      /**
       * Sets the OpenTelemetry {@link Meter} to be used to emit metrics. If provided, metrics will
       * be exported using OpenTelemetry APIs. If both MetricRegistry and Meter are null, metrics
       * are disabled.
       */
      public Builder withOpenTelemetryMeter(Meter meter) {
        this.otelMeter = meter;
        return this;
      }

      /**
       * Sets label keys and values for OpenTelemetry metrics. The size of keys and values lists
       * must match. These labels are applied to all OTel metrics emitted by the channel.
       */
      public Builder withOtelLabels(List<String> labelKeys, List<String> labelValues) {
        if (labelKeys == null || labelValues == null || labelKeys.size() != labelValues.size()) {
          logger.warning("Unable to set OTel label keys and values - size mismatch or null.");
          return this;
        }
        this.otelLabelKeys = labelKeys;
        this.otelLabelValues = labelValues;
        return this;
      }
    }
  }

  /** Resiliency configuration for the GCP managed channel. */
  public static class GcpResiliencyOptions {
    private final boolean notReadyFallbackEnabled;
    private final boolean unresponsiveDetectionEnabled;
    private final int unresponsiveDetectionMs;
    private final int unresponsiveDetectionDroppedCount;

    public GcpResiliencyOptions(Builder builder) {
      notReadyFallbackEnabled = builder.notReadyFallbackEnabled;
      unresponsiveDetectionEnabled = builder.unresponsiveDetectionEnabled;
      unresponsiveDetectionMs = builder.unresponsiveDetectionMs;
      unresponsiveDetectionDroppedCount = builder.unresponsiveDetectionDroppedCount;
    }

    /** Creates a new GcpResiliencyOptions.Builder. */
    public static Builder newBuilder() {
      return new Builder();
    }

    /** Creates a new GcpResiliencyOptions.Builder from GcpResiliencyOptions. */
    public static Builder newBuilder(GcpResiliencyOptions options) {
      return new Builder(options);
    }

    public boolean isNotReadyFallbackEnabled() {
      return notReadyFallbackEnabled;
    }

    public boolean isUnresponsiveDetectionEnabled() {
      return unresponsiveDetectionEnabled;
    }

    public int getUnresponsiveDetectionMs() {
      return unresponsiveDetectionMs;
    }

    public int getUnresponsiveDetectionDroppedCount() {
      return unresponsiveDetectionDroppedCount;
    }

    @Override
    public String toString() {
      return String.format(
          "{notReadyFallbackEnabled: %s, unresponsiveDetectionEnabled: %s, "
              + "unresponsiveDetectionMs: %d, unresponsiveDetectionDroppedCount: %d}",
          isNotReadyFallbackEnabled(),
          isUnresponsiveDetectionEnabled(),
          getUnresponsiveDetectionMs(),
          getUnresponsiveDetectionDroppedCount());
    }

    public static class Builder {
      private boolean notReadyFallbackEnabled = false;
      private boolean unresponsiveDetectionEnabled = false;
      private int unresponsiveDetectionMs = 0;
      private int unresponsiveDetectionDroppedCount = 0;

      public Builder() {}

      public Builder(GcpResiliencyOptions options) {
        this.notReadyFallbackEnabled = options.isNotReadyFallbackEnabled();
        this.unresponsiveDetectionEnabled = options.isUnresponsiveDetectionEnabled();
        this.unresponsiveDetectionMs = options.getUnresponsiveDetectionMs();
        this.unresponsiveDetectionDroppedCount = options.getUnresponsiveDetectionDroppedCount();
      }

      public GcpResiliencyOptions build() {
        return new GcpResiliencyOptions(this);
      }

      /**
       * If true, temporarily fallback requests to a ready channel from a channel which is not ready
       * to send a request immediately. The fallback will happen if the pool has another channel in
       * the READY state and that channel has less than maximum allowed concurrent active streams.
       */
      public Builder setNotReadyFallback(boolean enabled) {
        notReadyFallbackEnabled = enabled;
        return this;
      }

      /**
       * Enable unresponsive connection detection.
       *
       * <p>If an RPC channel fails to receive any RPC message from the server for {@code ms}
       * milliseconds and there were {@code numDroppedRequests} calls (started after the last
       * response from the server) that resulted in DEADLINE_EXCEEDED then a graceful reconnection
       * of the channel will be performed.
       *
       * <p>During the reconnection a new subchannel (connection) will be created for new RPCs, and
       * the calls on the old subchannel will still have a chance to complete if the server side
       * responds. When all RPCs on the old subchannel finish the old connection will be closed.
       *
       * <p>The {@code ms} should not be less than the timeout used for the majority of calls. And
       * {@code numDroppedRequests} must be > 0.
       *
       * <p>The logic treats any message from the server almost as a "ping" response. But only calls
       * started after the last response received and ended up in DEADLINE_EXCEEDED count towards
       * {@code numDroppedRequests}. Because of that, it may not detect an unresponsive connection
       * if you have long-running streaming calls only.
       */
      public Builder withUnresponsiveConnectionDetection(int ms, int numDroppedRequests) {
        Preconditions.checkArgument(ms > 0, "ms should be > 0, got %s", ms);
        Preconditions.checkArgument(
            numDroppedRequests > 0, "numDroppedRequests should be > 0, got %s", numDroppedRequests);
        unresponsiveDetectionEnabled = true;
        unresponsiveDetectionMs = ms;
        unresponsiveDetectionDroppedCount = numDroppedRequests;
        return this;
      }

      /** Disable unresponsive connection detection. */
      public Builder disableUnresponsiveConnectionDetection() {
        unresponsiveDetectionEnabled = false;
        return this;
      }
    }
  }
}
