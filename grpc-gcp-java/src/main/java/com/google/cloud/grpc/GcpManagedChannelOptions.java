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

  /**
   * Strategy for picking the least busy channel from the pool.
   *
   * <p>This controls how a channel is selected when there is no affinity key or when a new affinity
   * binding is being established.
   */
  public enum ChannelPickStrategy {
    /**
     * Scans all channels and picks the one with the fewest active streams. Ties are broken by
     * iteration order (lowest index wins). This is the legacy behavior.
     *
     * <p>This strategy finds the global minimum but is susceptible to the thundering herd problem:
     * under burst traffic, all concurrent callers observe the same minimum and pile onto the same
     * channel.
     */
    LINEAR_SCAN,

    /**
     * Samples two channels at random with replacement and returns the one with lower picker load.
     * The first sample wins ties.
     *
     * <p>This is the default strategy. It avoids the thundering herd problem. The trade-off is that
     * it may not always find the global minimum, but in practice the difference is negligible
     * because stream counts are inherently racy.
     */
    POWER_OF_TWO,
  }

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
    // Maximum desired average concurrent calls per channel.
    private final int maxRpcPerChannel;
    // How often to check for a possibility to scale down.
    private final Duration scaleDownInterval;
    // Minimum interval between successful scale-up operations.
    private final Duration scaleUpCooldown;
    // Number of consecutive low-load observations required before scaling down.
    private final int scaleDownConsecutiveLowLoadChecks;
    // Maximum percentage of the active pool that one scale-up operation may add.
    private final int maxScaleUpPercent;
    // Maximum number of channels that one scale-down operation may remove.
    private final int maxScaleDownChannels;
    // How long an empty draining channel remains available for reuse.
    private final Duration drainIdleGrace;
    // Load added after a retryable channel error.
    private final int errorPenaltyStep;
    // How long the retryable-error penalty remains in effect.
    private final Duration errorPenaltyDuration;
    // Optional hook that warms a scaled-up channel before publication.
    @Nullable private final GcpChannelPrimer channelPrimer;
    // Maximum time to wait for one channel-primer future.
    private final Duration channelPrimeTimeout;
    // Maximum number of channel-primer attempts before rejecting a channel.
    private final int channelPrimeMaxAttempts;

    // Use round-robin channel selection for affinity binding calls.
    private final boolean useRoundRobinOnBind;
    // How long to keep an affinity key after its last use.
    private final Duration affinityKeyLifetime;
    // How frequently affinity key cleanup process runs.
    private final Duration cleanupInterval;
    // Strategy for picking the least busy channel.
    private final ChannelPickStrategy channelPickStrategy;

    public GcpChannelPoolOptions(Builder builder) {
      maxSize = builder.maxSize;
      minSize = builder.minSize;
      initSize = builder.initSize;
      minRpcPerChannel = builder.minRpcPerChannel;
      maxRpcPerChannel = builder.maxRpcPerChannel;
      scaleDownInterval = builder.scaleDownInterval;
      scaleUpCooldown = builder.scaleUpCooldown;
      scaleDownConsecutiveLowLoadChecks = builder.scaleDownConsecutiveLowLoadChecks;
      maxScaleUpPercent = builder.maxScaleUpPercent;
      maxScaleDownChannels = builder.maxScaleDownChannels;
      drainIdleGrace = builder.drainIdleGrace;
      errorPenaltyStep = builder.errorPenaltyStep;
      errorPenaltyDuration = builder.errorPenaltyDuration;
      channelPrimer = builder.channelPrimer;
      channelPrimeTimeout = builder.channelPrimeTimeout;
      channelPrimeMaxAttempts = builder.channelPrimeMaxAttempts;
      concurrentStreamsLowWatermark = builder.concurrentStreamsLowWatermark;
      useRoundRobinOnBind = builder.useRoundRobinOnBind;
      affinityKeyLifetime = builder.affinityKeyLifetime;
      cleanupInterval = builder.cleanupInterval;
      channelPickStrategy = builder.channelPickStrategy;
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

    public Duration getScaleUpCooldown() {
      return scaleUpCooldown;
    }

    public int getScaleDownConsecutiveLowLoadChecks() {
      return scaleDownConsecutiveLowLoadChecks;
    }

    public int getMaxScaleUpPercent() {
      return maxScaleUpPercent;
    }

    public int getMaxScaleDownChannels() {
      return maxScaleDownChannels;
    }

    public Duration getDrainIdleGrace() {
      return drainIdleGrace;
    }

    public int getErrorPenaltyStep() {
      return errorPenaltyStep;
    }

    public Duration getErrorPenaltyDuration() {
      return errorPenaltyDuration;
    }

    @Nullable
    public GcpChannelPrimer getChannelPrimer() {
      return channelPrimer;
    }

    public Duration getChannelPrimeTimeout() {
      return channelPrimeTimeout;
    }

    public int getChannelPrimeMaxAttempts() {
      return channelPrimeMaxAttempts;
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

    public ChannelPickStrategy getChannelPickStrategy() {
      return channelPickStrategy;
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
          "{maxSize: %d, minSize: %d, initSize: %d, minRpcPerChannel: %d, "
              + "maxRpcPerChannel: %d, scaleDownInterval: %s, scaleUpCooldown: %s, "
              + "scaleDownConsecutiveLowLoadChecks: %d, maxScaleUpPercent: %d, "
              + "maxScaleDownChannels: %d, drainIdleGrace: %s, errorPenaltyStep: %d, "
              + "errorPenaltyDuration: %s, concurrentStreamsLowWatermark: %d, "
              + "useRoundRobinOnBind: %s, affinityKeyLifetime: %s, cleanupInterval: %s, "
              + "channelPickStrategy: %s, channelPrimer: %s, channelPrimeTimeout: %s, "
              + "channelPrimeMaxAttempts: %d}",
          getMaxSize(),
          getMinSize(),
          getInitSize(),
          getMinRpcPerChannel(),
          getMaxRpcPerChannel(),
          getScaleDownInterval(),
          getScaleUpCooldown(),
          getScaleDownConsecutiveLowLoadChecks(),
          getMaxScaleUpPercent(),
          getMaxScaleDownChannels(),
          getDrainIdleGrace(),
          getErrorPenaltyStep(),
          getErrorPenaltyDuration(),
          getConcurrentStreamsLowWatermark(),
          isUseRoundRobinOnBind(),
          getAffinityKeyLifetime(),
          getCleanupInterval(),
          getChannelPickStrategy(),
          getChannelPrimer(),
          getChannelPrimeTimeout(),
          getChannelPrimeMaxAttempts());
    }

    public static class Builder {
      private int maxSize = GcpManagedChannel.DEFAULT_MAX_CHANNEL;
      private int minSize = 0;
      private int initSize = 0;
      private int minRpcPerChannel = 0;
      private int maxRpcPerChannel = 0;
      private Duration scaleDownInterval = Duration.ZERO;
      private Duration scaleUpCooldown = Duration.ofSeconds(10);
      private int scaleDownConsecutiveLowLoadChecks = 3;
      private int maxScaleUpPercent = 30;
      private int maxScaleDownChannels = 2;
      private Duration drainIdleGrace = Duration.ofMinutes(1);
      private int errorPenaltyStep = 5;
      private Duration errorPenaltyDuration = Duration.ofSeconds(5);
      @Nullable private GcpChannelPrimer channelPrimer;
      private Duration channelPrimeTimeout = Duration.ofSeconds(10);
      private int channelPrimeMaxAttempts = 3;
      private int concurrentStreamsLowWatermark = GcpManagedChannel.DEFAULT_MAX_STREAM;
      private boolean useRoundRobinOnBind = false;
      private Duration affinityKeyLifetime = Duration.ZERO;
      private Duration cleanupInterval = Duration.ZERO;
      private ChannelPickStrategy channelPickStrategy = ChannelPickStrategy.POWER_OF_TWO;

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
        this.scaleUpCooldown = options.getScaleUpCooldown();
        this.scaleDownConsecutiveLowLoadChecks = options.getScaleDownConsecutiveLowLoadChecks();
        this.maxScaleUpPercent = options.getMaxScaleUpPercent();
        this.maxScaleDownChannels = options.getMaxScaleDownChannels();
        this.drainIdleGrace = options.getDrainIdleGrace();
        this.errorPenaltyStep = options.getErrorPenaltyStep();
        this.errorPenaltyDuration = options.getErrorPenaltyDuration();
        this.channelPrimer = options.getChannelPrimer();
        this.channelPrimeTimeout = options.getChannelPrimeTimeout();
        this.channelPrimeMaxAttempts = options.getChannelPrimeMaxAttempts();
        this.concurrentStreamsLowWatermark = options.getConcurrentStreamsLowWatermark();
        this.useRoundRobinOnBind = options.isUseRoundRobinOnBind();
        this.affinityKeyLifetime = options.getAffinityKeyLifetime();
        this.cleanupInterval = options.getCleanupInterval();
        this.channelPickStrategy = options.getChannelPickStrategy();
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
       * <p>After a call is counted, load above <code>maxRpcPerChannel</code> on its selected
       * channel or across the pool average signals a background scale-up worker.
       *
       * <p>Every <code>scaleDownInterval</code> a check for downscaling is performed. Based on the
       * current active-call average, consecutive low-load observations, and midpoint target are
       * used to decide bounded scale-down. Least-loaded channels drain without new picks and close
       * after their calls complete and the configured idle grace expires. A READY draining channel
       * can be reused by a later scale-up before it closes.
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
            minRpcPerChannel <= maxRpcPerChannel,
            "Minimum RPCs per channel must not exceed maximum RPCs per channel.");
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
       * Sets the minimum interval between successful scale-up operations. Zero uses the 10-second
       * default.
       */
      public Builder setScaleUpCooldown(Duration scaleUpCooldown) {
        Preconditions.checkNotNull(scaleUpCooldown, "Scale up cooldown must not be null.");
        Preconditions.checkArgument(
            !scaleUpCooldown.isNegative(), "Scale up cooldown must not be negative.");
        this.scaleUpCooldown = scaleUpCooldown.isZero() ? Duration.ofSeconds(10) : scaleUpCooldown;
        return this;
      }

      /** Sets the number of consecutive low-load checks required before scaling down. */
      public Builder setScaleDownConsecutiveLowLoadChecks(int checks) {
        Preconditions.checkArgument(checks > 0, "Scale down checks must be positive.");
        this.scaleDownConsecutiveLowLoadChecks = checks;
        return this;
      }

      /**
       * Sets the maximum percentage of active channels added by one scale-up operation. The
       * percentage cap has a two-channel floor before desired-size and maximum-size clamps.
       */
      public Builder setMaxScaleUpPercent(int percent) {
        Preconditions.checkArgument(
            percent > 0 && percent <= 100, "Scale up percent must be in (0, 100].");
        this.maxScaleUpPercent = percent;
        return this;
      }

      /** Sets the maximum number of channels removed by one scale-down operation. */
      public Builder setMaxScaleDownChannels(int channels) {
        Preconditions.checkArgument(channels > 0, "Scale down channel limit must be positive.");
        this.maxScaleDownChannels = channels;
        return this;
      }

      /** Sets how long an empty draining channel remains available for reuse. */
      public Builder setDrainIdleGrace(Duration drainIdleGrace) {
        Preconditions.checkNotNull(drainIdleGrace, "Drain idle grace must not be null.");
        Preconditions.checkArgument(
            !drainIdleGrace.isNegative(), "Drain idle grace must not be negative.");
        this.drainIdleGrace = drainIdleGrace;
        return this;
      }

      /**
       * Sets the load penalty added after each retryable channel error. Zero uses the default of 5.
       * Set a negative {@link #setErrorPenaltyDuration(Duration) penalty duration} to disable
       * penalties.
       */
      public Builder setErrorPenaltyStep(int errorPenaltyStep) {
        Preconditions.checkArgument(
            errorPenaltyStep >= 0, "Error penalty step must not be negative.");
        this.errorPenaltyStep = errorPenaltyStep == 0 ? 5 : errorPenaltyStep;
        return this;
      }

      /**
       * Sets how long retryable-error penalty load remains in effect. A negative duration disables
       * penalties.
       */
      public Builder setErrorPenaltyDuration(Duration errorPenaltyDuration) {
        Preconditions.checkNotNull(
            errorPenaltyDuration, "Error penalty duration must not be null.");
        this.errorPenaltyDuration = errorPenaltyDuration;
        return this;
      }

      /**
       * Sets the optional hook that primes each newly built scale-up channel before publication. A
       * {@code null} primer disables priming and preserves the existing scale-up path.
       */
      public Builder setChannelPrimer(@Nullable GcpChannelPrimer channelPrimer) {
        this.channelPrimer = channelPrimer;
        return this;
      }

      /**
       * Sets the maximum time the scale-up worker waits for one channel-primer future. Zero uses
       * the 10-second default.
       */
      public Builder setChannelPrimeTimeout(Duration channelPrimeTimeout) {
        Preconditions.checkNotNull(channelPrimeTimeout, "Channel prime timeout must not be null.");
        Preconditions.checkArgument(
            !channelPrimeTimeout.isNegative(), "Channel prime timeout must not be negative.");
        this.channelPrimeTimeout =
            channelPrimeTimeout.isZero() ? Duration.ofSeconds(10) : channelPrimeTimeout;
        return this;
      }

      /**
       * Sets the maximum number of attempts to prime one scaled-up channel. Zero uses the default
       * of 3. Retry backoff is exponential from 100 ms and capped at 5 s.
       */
      public Builder setChannelPrimeMaxAttempts(int channelPrimeMaxAttempts) {
        Preconditions.checkArgument(
            channelPrimeMaxAttempts >= 0, "Channel prime max attempts must not be negative.");
        this.channelPrimeMaxAttempts = channelPrimeMaxAttempts == 0 ? 3 : channelPrimeMaxAttempts;
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

      /**
       * Sets the strategy for picking the least busy channel from the pool.
       *
       * <p>Defaults to {@link ChannelPickStrategy#POWER_OF_TWO} which avoids the thundering herd
       * problem by sampling two channels with replacement and picking the less busy one. The first
       * sample wins ties.
       *
       * <p>Use {@link ChannelPickStrategy#LINEAR_SCAN} to restore the legacy behavior of scanning
       * all channels and always picking the one with the fewest active streams.
       *
       * @param strategy the channel pick strategy to use.
       */
      public Builder setChannelPickStrategy(ChannelPickStrategy strategy) {
        Preconditions.checkNotNull(strategy, "Channel pick strategy must not be null.");
        this.channelPickStrategy = strategy;
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
