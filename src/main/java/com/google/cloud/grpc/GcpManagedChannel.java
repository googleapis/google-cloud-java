/*
 * Copyright 2019 Google LLC
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

import com.google.cloud.grpc.GcpManagedChannelOptions.GcpMetricsOptions;
import com.google.cloud.grpc.GcpManagedChannelOptions.GcpResiliencyOptions;
import com.google.cloud.grpc.proto.AffinityConfig;
import com.google.cloud.grpc.proto.ApiConfig;
import com.google.cloud.grpc.proto.MethodConfig;
import com.google.common.annotations.VisibleForTesting;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.MessageOrBuilder;
import io.grpc.CallOptions;
import io.grpc.ClientCall;
import io.grpc.ConnectivityState;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.Status.Code;
import io.opencensus.common.ToLongFunction;
import io.opencensus.metrics.DerivedLongCumulative;
import io.opencensus.metrics.DerivedLongGauge;
import io.opencensus.metrics.LabelKey;
import io.opencensus.metrics.LabelValue;
import io.opencensus.metrics.MetricOptions;
import io.opencensus.metrics.MetricRegistry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.annotation.Nullable;

/** A channel management factory that implements grpc.Channel APIs. */
public class GcpManagedChannel extends ManagedChannel {
  private static final Logger logger = Logger.getLogger(GcpManagedChannel.class.getName());
  static final AtomicInteger channelPoolIndex = new AtomicInteger();
  private static final int DEFAULT_MAX_CHANNEL = 10;
  private static final int DEFAULT_MAX_STREAM = 100;

  private final ManagedChannelBuilder<?> delegateChannelBuilder;
  private final GcpManagedChannelOptions options;
  private final boolean fallbackEnabled;
  private final boolean unresponsiveDetectionEnabled;
  private final int unresponsiveMs;
  private final int unresponsiveDropCount;
  private int maxSize = DEFAULT_MAX_CHANNEL;
  private int maxConcurrentStreamsLowWatermark = DEFAULT_MAX_STREAM;

  @VisibleForTesting
  final Map<String, AffinityConfig> methodToAffinity = new HashMap<String, AffinityConfig>();

  @VisibleForTesting
  final Map<String, ChannelRef> affinityKeyToChannelRef = new ConcurrentHashMap<>();

  // Map from a broken channel id to the remapped affinity keys (key => ready channel id).
  private final Map<Integer, Map<String, Integer>> fallbackMap = new ConcurrentHashMap<>();

  @VisibleForTesting final List<ChannelRef> channelRefs = new CopyOnWriteArrayList<>();

  private final Map<Integer, ChannelRef> channelRefById = new HashMap<>();

  // Metrics configuration.
  private MetricRegistry metricRegistry;
  private final List<LabelKey> labelKeys = new ArrayList<>();
  private final List<LabelKey> labelKeysWithResult =
      new ArrayList<>(
          Collections.singletonList(
              LabelKey.create(GcpMetricsConstants.RESULT_LABEL, GcpMetricsConstants.RESULT_DESC)));
  private final List<LabelValue> labelValues = new ArrayList<>();
  private final List<LabelValue> labelValuesSuccess =
      new ArrayList<>(
          Collections.singletonList(LabelValue.create(GcpMetricsConstants.RESULT_SUCCESS)));
  private final List<LabelValue> labelValuesError =
      new ArrayList<>(
          Collections.singletonList(LabelValue.create(GcpMetricsConstants.RESULT_ERROR)));
  private String metricPrefix;

  // Metrics counters.
  private final AtomicInteger readyChannels = new AtomicInteger();
  private int minReadyChannels = 0;
  private int maxReadyChannels = 0;
  private final AtomicLong numChannelConnect = new AtomicLong();
  private final AtomicLong numChannelDisconnect = new AtomicLong();
  private long minReadinessTime = 0;
  private long maxReadinessTime = 0;
  private final AtomicLong totalReadinessTime = new AtomicLong();
  private final AtomicLong readinessTimeOccurrences = new AtomicLong();
  private final AtomicInteger totalActiveStreams = new AtomicInteger();
  private int minActiveStreams = 0;
  private int maxActiveStreams = 0;
  private int minTotalActiveStreams = 0;
  private int maxTotalActiveStreams = 0;
  private long minOkCalls = 0;
  private long maxOkCalls = 0;
  private final AtomicLong totalOkCalls = new AtomicLong();
  private boolean minOkReported = false;
  private boolean maxOkReported = false;
  private long minErrCalls = 0;
  private long maxErrCalls = 0;
  private final AtomicLong totalErrCalls = new AtomicLong();
  private boolean minErrReported = false;
  private boolean maxErrReported = false;
  private int minAffinity = 0;
  private int maxAffinity = 0;
  private final AtomicInteger totalAffinityCount = new AtomicInteger();
  private final AtomicLong fallbacksSucceeded = new AtomicLong();
  private final AtomicLong fallbacksFailed = new AtomicLong();
  private final AtomicLong unresponsiveDetectionCount = new AtomicLong();
  private long minUnresponsiveMs = 0;
  private long maxUnresponsiveMs = 0;
  private long minUnresponsiveDrops = 0;
  private long maxUnresponsiveDrops = 0;

  /**
   * Constructor for GcpManagedChannel.
   *
   * @param delegateChannelBuilder the underlying delegate ManagedChannelBuilder.
   * @param apiConfig the ApiConfig object for configuring GcpManagedChannel.
   * @param options the options for GcpManagedChannel.
   */
  public GcpManagedChannel(
      ManagedChannelBuilder<?> delegateChannelBuilder,
      ApiConfig apiConfig,
      int poolSize,
      GcpManagedChannelOptions options) {
    loadApiConfig(apiConfig);
    if (poolSize != 0) {
      this.maxSize = poolSize;
    }
    this.delegateChannelBuilder = delegateChannelBuilder;
    this.options = options;
    initOptions();
    if (options.getResiliencyOptions() != null) {
      fallbackEnabled = options.getResiliencyOptions().isNotReadyFallbackEnabled();
      unresponsiveDetectionEnabled =
          options.getResiliencyOptions().isUnresponsiveDetectionEnabled();
      unresponsiveMs = options.getResiliencyOptions().getUnresponsiveDetectionMs();
      unresponsiveDropCount = options.getResiliencyOptions().getUnresponsiveDetectionDroppedCount();
    } else {
      fallbackEnabled = false;
      unresponsiveDetectionEnabled = false;
      unresponsiveMs = 0;
      unresponsiveDropCount = 0;
    }
  }

  private void initOptions() {
    initMetrics();
  }

  private void initMetrics() {
    final GcpMetricsOptions metricsOptions = options.getMetricsOptions();
    if (metricsOptions == null) {
      logger.info("Metrics options are empty. Metrics disabled.");
      return;
    }
    if (metricsOptions.getMetricRegistry() == null) {
      logger.info("Metric registry is null. Metrics disabled.");
      return;
    }
    logger.info("Metrics enabled.");

    metricRegistry = metricsOptions.getMetricRegistry();
    labelKeys.addAll(metricsOptions.getLabelKeys());
    labelKeysWithResult.addAll(metricsOptions.getLabelKeys());
    labelValues.addAll(metricsOptions.getLabelValues());
    labelValuesSuccess.addAll(metricsOptions.getLabelValues());
    labelValuesError.addAll(metricsOptions.getLabelValues());

    final LabelKey poolKey =
        LabelKey.create(GcpMetricsConstants.POOL_INDEX_LABEL, GcpMetricsConstants.POOL_INDEX_DESC);
    labelKeys.add(poolKey);
    labelKeysWithResult.add(poolKey);
    final LabelValue poolIndex =
        LabelValue.create(String.format("pool-%d", channelPoolIndex.incrementAndGet()));
    labelValues.add(poolIndex);
    labelValuesSuccess.add(poolIndex);
    labelValuesError.add(poolIndex);

    metricPrefix = metricsOptions.getNamePrefix();

    createDerivedLongGaugeTimeSeries(
        GcpMetricsConstants.METRIC_MIN_READY_CHANNELS,
        "The minimum number of channels simultaneously in the READY state.",
        GcpMetricsConstants.COUNT,
        this,
        GcpManagedChannel::reportMinReadyChannels);

    createDerivedLongGaugeTimeSeries(
        GcpMetricsConstants.METRIC_MAX_READY_CHANNELS,
        "The maximum number of channels simultaneously in the READY state.",
        GcpMetricsConstants.COUNT,
        this,
        GcpManagedChannel::reportMaxReadyChannels);

    createDerivedLongGaugeTimeSeries(
        GcpMetricsConstants.METRIC_MAX_CHANNELS,
        "The maximum number of channels in the pool.",
        GcpMetricsConstants.COUNT,
        this,
        GcpManagedChannel::reportMaxChannels);

    createDerivedLongGaugeTimeSeries(
        GcpMetricsConstants.METRIC_MAX_ALLOWED_CHANNELS,
        "The maximum number of channels allowed in the pool. (The poll max size)",
        GcpMetricsConstants.COUNT,
        this,
        GcpManagedChannel::reportMaxAllowedChannels);

    createDerivedLongCumulativeTimeSeries(
        GcpMetricsConstants.METRIC_NUM_CHANNEL_DISCONNECT,
        "The number of disconnections (occurrences when a channel deviates from the READY state)",
        GcpMetricsConstants.COUNT,
        this,
        GcpManagedChannel::reportNumChannelDisconnect);

    createDerivedLongCumulativeTimeSeries(
        GcpMetricsConstants.METRIC_NUM_CHANNEL_CONNECT,
        "The number of times when a channel reached the READY state.",
        GcpMetricsConstants.COUNT,
        this,
        GcpManagedChannel::reportNumChannelConnect);

    createDerivedLongGaugeTimeSeries(
        GcpMetricsConstants.METRIC_MIN_CHANNEL_READINESS_TIME,
        "The minimum time it took to transition a channel to the READY state.",
        GcpMetricsConstants.MICROSECOND,
        this,
        GcpManagedChannel::reportMinReadinessTime);

    createDerivedLongGaugeTimeSeries(
        GcpMetricsConstants.METRIC_AVG_CHANNEL_READINESS_TIME,
        "The average time it took to transition a channel to the READY state.",
        GcpMetricsConstants.MICROSECOND,
        this,
        GcpManagedChannel::reportAvgReadinessTime);

    createDerivedLongGaugeTimeSeries(
        GcpMetricsConstants.METRIC_MAX_CHANNEL_READINESS_TIME,
        "The maximum time it took to transition a channel to the READY state.",
        GcpMetricsConstants.MICROSECOND,
        this,
        GcpManagedChannel::reportMaxReadinessTime);

    createDerivedLongGaugeTimeSeries(
        GcpMetricsConstants.METRIC_MIN_ACTIVE_STREAMS,
        "The minimum number of active streams on any channel.",
        GcpMetricsConstants.COUNT,
        this,
        GcpManagedChannel::reportMinActiveStreams);

    createDerivedLongGaugeTimeSeries(
        GcpMetricsConstants.METRIC_MAX_ACTIVE_STREAMS,
        "The maximum number of active streams on any channel.",
        GcpMetricsConstants.COUNT,
        this,
        GcpManagedChannel::reportMaxActiveStreams);

    createDerivedLongGaugeTimeSeries(
        GcpMetricsConstants.METRIC_MIN_TOTAL_ACTIVE_STREAMS,
        "The minimum total number of active streams across all channels.",
        GcpMetricsConstants.COUNT,
        this,
        GcpManagedChannel::reportMinTotalActiveStreams);

    createDerivedLongGaugeTimeSeries(
        GcpMetricsConstants.METRIC_MAX_TOTAL_ACTIVE_STREAMS,
        "The maximum total number of active streams across all channels.",
        GcpMetricsConstants.COUNT,
        this,
        GcpManagedChannel::reportMaxTotalActiveStreams);

    createDerivedLongGaugeTimeSeries(
        GcpMetricsConstants.METRIC_MIN_AFFINITY,
        "The minimum number of affinity count on any channel.",
        GcpMetricsConstants.COUNT,
        this,
        GcpManagedChannel::reportMinAffinity);

    createDerivedLongGaugeTimeSeries(
        GcpMetricsConstants.METRIC_MAX_AFFINITY,
        "The maximum number of affinity count on any channel.",
        GcpMetricsConstants.COUNT,
        this,
        GcpManagedChannel::reportMaxAffinity);

    createDerivedLongGaugeTimeSeries(
        GcpMetricsConstants.METRIC_NUM_AFFINITY,
        "The total number of affinity count across all channels.",
        GcpMetricsConstants.COUNT,
        this,
        GcpManagedChannel::reportNumAffinity);

    createDerivedLongGaugeTimeSeriesWithResult(
        GcpMetricsConstants.METRIC_MIN_CALLS,
        "The minimum number of completed calls on any channel.",
        GcpMetricsConstants.COUNT,
        this,
        GcpManagedChannel::reportMinOkCalls,
        GcpManagedChannel::reportMinErrCalls);

    createDerivedLongGaugeTimeSeriesWithResult(
        GcpMetricsConstants.METRIC_MAX_CALLS,
        "The maximum number of completed calls on any channel.",
        GcpMetricsConstants.COUNT,
        this,
        GcpManagedChannel::reportMaxOkCalls,
        GcpManagedChannel::reportMaxErrCalls);

    createDerivedLongCumulativeTimeSeriesWithResult(
        GcpMetricsConstants.METRIC_NUM_CALLS_COMPLETED,
        "The number of calls completed across all channels.",
        GcpMetricsConstants.COUNT,
        this,
        GcpManagedChannel::reportTotalOkCalls,
        GcpManagedChannel::reportTotalErrCalls);

    createDerivedLongCumulativeTimeSeriesWithResult(
        GcpMetricsConstants.METRIC_NUM_FALLBACKS,
        "The number of calls that had fallback to another channel.",
        GcpMetricsConstants.COUNT,
        this,
        GcpManagedChannel::reportSucceededFallbacks,
        GcpManagedChannel::reportFailedFallbacks);

    createDerivedLongCumulativeTimeSeries(
        GcpMetricsConstants.METRIC_NUM_UNRESPONSIVE_DETECTIONS,
        "The number of unresponsive connections detected.",
        GcpMetricsConstants.COUNT,
        this,
        GcpManagedChannel::reportUnresponsiveDetectionCount);

    createDerivedLongGaugeTimeSeries(
        GcpMetricsConstants.METRIC_MIN_UNRESPONSIVE_DETECTION_TIME,
        "The minimum time it took to detect an unresponsive connection.",
        GcpMetricsConstants.MILLISECOND,
        this,
        GcpManagedChannel::reportMinUnresponsiveMs);

    createDerivedLongGaugeTimeSeries(
        GcpMetricsConstants.METRIC_MAX_UNRESPONSIVE_DETECTION_TIME,
        "The maximum time it took to detect an unresponsive connection.",
        GcpMetricsConstants.MILLISECOND,
        this,
        GcpManagedChannel::reportMaxUnresponsiveMs);

    createDerivedLongGaugeTimeSeries(
        GcpMetricsConstants.METRIC_MIN_UNRESPONSIVE_DROPPED_CALLS,
        "The minimum calls dropped before detection of an unresponsive connection.",
        GcpMetricsConstants.MILLISECOND,
        this,
        GcpManagedChannel::reportMinUnresponsiveDrops);

    createDerivedLongGaugeTimeSeries(
        GcpMetricsConstants.METRIC_MAX_UNRESPONSIVE_DROPPED_CALLS,
        "The maximum calls dropped before detection of an unresponsive connection.",
        GcpMetricsConstants.MILLISECOND,
        this,
        GcpManagedChannel::reportMaxUnresponsiveDrops);
  }

  private MetricOptions createMetricOptions(
      String description, List<LabelKey> labelKeys, String unit) {
    return MetricOptions.builder()
        .setDescription(description)
        .setLabelKeys(labelKeys)
        .setUnit(unit)
        .build();
  }

  private <T> void createDerivedLongGaugeTimeSeries(
      String name, String description, String unit, T obj, ToLongFunction<T> func) {
    final DerivedLongGauge metric =
        metricRegistry.addDerivedLongGauge(
            metricPrefix + name, createMetricOptions(description, labelKeys, unit));

    metric.removeTimeSeries(labelValues);
    metric.createTimeSeries(labelValues, obj, func);
  }

  private <T> void createDerivedLongGaugeTimeSeriesWithResult(
      String name,
      String description,
      String unit,
      T obj,
      ToLongFunction<T> funcSucc,
      ToLongFunction<T> funcErr) {
    final DerivedLongGauge metric =
        metricRegistry.addDerivedLongGauge(
            metricPrefix + name, createMetricOptions(description, labelKeysWithResult, unit));

    metric.removeTimeSeries(labelValuesSuccess);
    metric.createTimeSeries(labelValuesSuccess, obj, funcSucc);
    metric.removeTimeSeries(labelValuesError);
    metric.createTimeSeries(labelValuesError, obj, funcErr);
  }

  private <T> void createDerivedLongCumulativeTimeSeries(
      String name, String description, String unit, T obj, ToLongFunction<T> func) {
    final DerivedLongCumulative metric =
        metricRegistry.addDerivedLongCumulative(
            metricPrefix + name, createMetricOptions(description, labelKeys, unit));

    metric.removeTimeSeries(labelValues);
    metric.createTimeSeries(labelValues, obj, func);
  }

  private <T> void createDerivedLongCumulativeTimeSeriesWithResult(
      String name,
      String description,
      String unit,
      T obj,
      ToLongFunction<T> funcSucc,
      ToLongFunction<T> funcErr) {
    final DerivedLongCumulative metric =
        metricRegistry.addDerivedLongCumulative(
            metricPrefix + name, createMetricOptions(description, labelKeysWithResult, unit));

    metric.removeTimeSeries(labelValuesSuccess);
    metric.createTimeSeries(labelValuesSuccess, obj, funcSucc);
    metric.removeTimeSeries(labelValuesError);
    metric.createTimeSeries(labelValuesError, obj, funcErr);
  }

  private long reportMaxChannels() {
    return getNumberOfChannels();
  }

  private long reportMaxAllowedChannels() {
    return maxSize;
  }

  private long reportMinReadyChannels() {
    int value = minReadyChannels;
    minReadyChannels = readyChannels.get();
    return value;
  }

  private long reportMaxReadyChannels() {
    int value = maxReadyChannels;
    maxReadyChannels = readyChannels.get();
    return value;
  }

  private long reportNumChannelConnect() {
    return numChannelConnect.get();
  }

  private long reportNumChannelDisconnect() {
    return numChannelDisconnect.get();
  }

  private long reportMinReadinessTime() {
    long value = minReadinessTime;
    minReadinessTime = 0;
    return value;
  }

  private long reportAvgReadinessTime() {
    long value = 0;
    long total = totalReadinessTime.getAndSet(0);
    long occ = readinessTimeOccurrences.getAndSet(0);
    if (occ != 0) {
      value = total / occ;
    }
    return value;
  }

  private long reportMaxReadinessTime() {
    long value = maxReadinessTime;
    maxReadinessTime = 0;
    return value;
  }

  private int reportMinActiveStreams() {
    int value = minActiveStreams;
    minActiveStreams =
        channelRefs.stream().mapToInt(ChannelRef::getActiveStreamsCount).min().orElse(0);
    return value;
  }

  private int reportMaxActiveStreams() {
    int value = maxActiveStreams;
    maxActiveStreams =
        channelRefs.stream().mapToInt(ChannelRef::getActiveStreamsCount).max().orElse(0);
    return value;
  }

  private int reportMinTotalActiveStreams() {
    int value = minTotalActiveStreams;
    minTotalActiveStreams = totalActiveStreams.get();
    return value;
  }

  private int reportMaxTotalActiveStreams() {
    int value = maxTotalActiveStreams;
    maxTotalActiveStreams = totalActiveStreams.get();
    return value;
  }

  private int reportMinAffinity() {
    int value = minAffinity;
    minAffinity = channelRefs.stream().mapToInt(ChannelRef::getAffinityCount).min().orElse(0);
    return value;
  }

  private int reportMaxAffinity() {
    int value = maxAffinity;
    maxAffinity = channelRefs.stream().mapToInt(ChannelRef::getAffinityCount).max().orElse(0);
    return value;
  }

  private int reportNumAffinity() {
    return totalAffinityCount.get();
  }

  private synchronized long reportMinOkCalls() {
    minOkReported = true;
    calcMinMaxOkCalls();
    return minOkCalls;
  }

  private synchronized long reportMaxOkCalls() {
    maxOkReported = true;
    calcMinMaxOkCalls();
    return maxOkCalls;
  }

  private long reportTotalOkCalls() {
    return totalOkCalls.get();
  }

  private void calcMinMaxOkCalls() {
    if (minOkReported && maxOkReported) {
      minOkReported = false;
      maxOkReported = false;
      return;
    }
    final LongSummaryStatistics stats =
        channelRefs.stream().collect(Collectors.summarizingLong(ChannelRef::getAndResetOkCalls));
    minOkCalls = stats.getMin();
    maxOkCalls = stats.getMax();
  }

  private synchronized long reportMinErrCalls() {
    minErrReported = true;
    calcMinMaxErrCalls();
    return minErrCalls;
  }

  private synchronized long reportMaxErrCalls() {
    maxErrReported = true;
    calcMinMaxErrCalls();
    return maxErrCalls;
  }

  private long reportTotalErrCalls() {
    return totalErrCalls.get();
  }

  private void calcMinMaxErrCalls() {
    if (minErrReported && maxErrReported) {
      minErrReported = false;
      maxErrReported = false;
      return;
    }
    final LongSummaryStatistics stats =
        channelRefs.stream().collect(Collectors.summarizingLong(ChannelRef::getAndResetErrCalls));
    minErrCalls = stats.getMin();
    maxErrCalls = stats.getMax();
  }

  private long reportSucceededFallbacks() {
    return fallbacksSucceeded.get();
  }

  private long reportFailedFallbacks() {
    return fallbacksFailed.get();
  }

  private long reportUnresponsiveDetectionCount() {
    return unresponsiveDetectionCount.get();
  }

  private long reportMinUnresponsiveMs() {
    long value = minUnresponsiveMs;
    minUnresponsiveMs = 0;
    return value;
  }

  private long reportMaxUnresponsiveMs() {
    long value = maxUnresponsiveMs;
    maxUnresponsiveMs = 0;
    return value;
  }

  private long reportMinUnresponsiveDrops() {
    long value = minUnresponsiveDrops;
    minUnresponsiveDrops = 0;
    return value;
  }

  private long reportMaxUnresponsiveDrops() {
    long value = maxUnresponsiveDrops;
    maxUnresponsiveDrops = 0;
    return value;
  }

  private void incReadyChannels() {
    numChannelConnect.incrementAndGet();
    final int newReady = readyChannels.incrementAndGet();
    if (maxReadyChannels < newReady) {
      maxReadyChannels = newReady;
    }
  }

  private void decReadyChannels() {
    numChannelDisconnect.incrementAndGet();
    final int newReady = readyChannels.decrementAndGet();
    if (minReadyChannels > newReady) {
      minReadyChannels = newReady;
    }
  }

  private void saveReadinessTime(long readinessNanos) {
    long readinessTimeUs = readinessNanos / 1000;
    if (minReadinessTime == 0 || readinessTimeUs < minReadinessTime) {
      minReadinessTime = readinessTimeUs;
    }
    if (readinessTimeUs > maxReadinessTime) {
      maxReadinessTime = readinessTimeUs;
    }
    totalReadinessTime.addAndGet(readinessTimeUs);
    readinessTimeOccurrences.incrementAndGet();
  }

  private void recordUnresponsiveDetection(long nanos, long dropCount) {
    unresponsiveDetectionCount.incrementAndGet();
    final long ms = nanos / 1000000;
    if (minUnresponsiveMs == 0 || minUnresponsiveMs > ms) {
      minUnresponsiveMs = ms;
    }
    if (maxUnresponsiveMs < ms) {
      maxUnresponsiveMs = ms;
    }
    if (minUnresponsiveDrops == 0 || minUnresponsiveDrops > dropCount) {
      minUnresponsiveDrops = dropCount;
    }
    if (maxUnresponsiveDrops < dropCount) {
      maxUnresponsiveDrops = dropCount;
    }
  }

  /**
   * ChannelStateMonitor subscribes to channel's state changes and informs {@link GcpManagedChannel}
   * on any new state. This monitor allows to detect when a channel is not ready and temporarily
   * route requests via another ready channel if the option is enabled.
   */
  private class ChannelStateMonitor implements Runnable {
    private final int channelId;
    private final ManagedChannel channel;
    private ConnectivityState currentState;
    private long connectingStartNanos;

    private ChannelStateMonitor(ManagedChannel channel, int channelId) {
      this.channelId = channelId;
      this.channel = channel;
      run();
    }

    @Override
    public void run() {
      if (channel == null) {
        return;
      }
      ConnectivityState newState = channel.getState(false);
      if (newState == ConnectivityState.READY && currentState != ConnectivityState.READY) {
        incReadyChannels();
        saveReadinessTime(System.nanoTime() - connectingStartNanos);
      }
      if (newState != ConnectivityState.READY && currentState == ConnectivityState.READY) {
        decReadyChannels();
      }
      if (newState == ConnectivityState.CONNECTING
          && currentState != ConnectivityState.CONNECTING) {
        connectingStartNanos = System.nanoTime();
      }
      currentState = newState;
      processChannelStateChange(channelId, newState);
      if (newState != ConnectivityState.SHUTDOWN) {
        channel.notifyWhenStateChanged(newState, this);
      }
    }
  }

  void processChannelStateChange(int channelId, ConnectivityState state) {
    if (!fallbackEnabled) {
      return;
    }
    if (state == ConnectivityState.READY || state == ConnectivityState.IDLE) {
      // Ready
      fallbackMap.remove(channelId);
      return;
    }
    // Not ready
    fallbackMap.putIfAbsent(channelId, new ConcurrentHashMap<>());
  }

  public int getMaxSize() {
    return maxSize;
  }

  public int getNumberOfChannels() {
    return channelRefs.size();
  }

  public int getStreamsLowWatermark() {
    return maxConcurrentStreamsLowWatermark;
  }

  public int getMinActiveStreams() {
    return channelRefs.stream().mapToInt(ChannelRef::getActiveStreamsCount).min().orElse(0);
  }

  public int getMaxActiveStreams() {
    return channelRefs.stream().mapToInt(ChannelRef::getActiveStreamsCount).max().orElse(0);
  }

  /**
   * Pick a {@link ChannelRef} (and create a new one if necessary). If notReadyFallbackEnabled is
   * true in the {@link GcpResiliencyOptions} then instead of a channel in a non-READY state another
   * channel in the READY state and having fewer than maximum allowed number of active streams will
   * be provided if available. Subsequent calls with the same affinity key will provide the same
   * fallback channel as long as the fallback channel is in the READY state.
   *
   * @param key affinity key. If it is specified, pick the ChannelRef bound with the affinity key.
   *     Otherwise pick the one with the smallest number of streams.
   */
  protected ChannelRef getChannelRef(@Nullable String key) {
    if (key == null || key.equals("")) {
      return pickLeastBusyChannel();
    }
    ChannelRef mappedChannel = affinityKeyToChannelRef.get(key);
    if (mappedChannel == null || !fallbackEnabled) {
      return mappedChannel;
    }
    // Look up if the channelRef is not ready.
    Map<String, Integer> tempMap = fallbackMap.get(mappedChannel.getId());
    if (tempMap == null) {
      // Channel is ready.
      return mappedChannel;
    }
    // Channel is not ready. Look up if the affinity key mapped to another channel.
    Integer channelId = tempMap.get(key);
    if (channelId != null && !fallbackMap.containsKey(channelId)) {
      // Fallback channel is ready.
      fallbacksSucceeded.incrementAndGet();
      return channelRefById.get(channelId);
    }
    // No temp mapping for this key or fallback channel is also broken.
    ChannelRef channelRef = pickLeastBusyChannel();
    if (!fallbackMap.containsKey(channelRef.getId())
        && channelRef.getActiveStreamsCount() < DEFAULT_MAX_STREAM) {
      // Got a ready and not an overloaded channel.
      fallbacksSucceeded.incrementAndGet();
      tempMap.put(key, channelRef.getId());
      return channelRef;
    }
    fallbacksFailed.incrementAndGet();
    if (channelId != null) {
      // Stick with previous mapping if fallback has failed.
      return channelRefById.get(channelId);
    }
    return mappedChannel;
  }

  // Create a new channel and add it to channelRefs synchronously to make sure its id matches its
  // channelRef's index.
  private synchronized ChannelRef createNewChannel() {
    final int size = channelRefs.size();
    ChannelRef channelRef = new ChannelRef(delegateChannelBuilder.build(), size);
    channelRefs.add(channelRef);
    channelRefById.put(size, channelRef);
    return channelRef;
  }

  /**
   * Pick a {@link ChannelRef} (and create a new one if necessary). If notReadyFallbackEnabled is
   * true in the {@link GcpResiliencyOptions} then instead of a channel in a non-READY state another
   * channel in the READY state and having fewer than maximum allowed number of active streams will
   * be provided if available.
   */
  private ChannelRef pickLeastBusyChannel() {
    if (channelRefs.size() == 0) {
      return createNewChannel();
    }

    // Pick the least busy channel and the least busy ready and not overloaded channel (this could
    // be the same channel or different or no channel).
    ChannelRef channelCandidate = channelRefs.get(0);
    int minStreams = channelCandidate.getActiveStreamsCount();
    ChannelRef readyCandidate = null;
    int readyMinStreams = Integer.MAX_VALUE;

    for (ChannelRef channelRef : channelRefs) {
      int cnt = channelRef.getActiveStreamsCount();
      if (cnt < minStreams) {
        minStreams = cnt;
        channelCandidate = channelRef;
      }
      if (cnt < readyMinStreams
          && !fallbackMap.containsKey(channelRef.getId())
          && channelRef.getActiveStreamsCount() < DEFAULT_MAX_STREAM) {
        readyMinStreams = cnt;
        readyCandidate = channelRef;
      }
    }

    if (!fallbackEnabled) {
      if (channelRefs.size() < maxSize && minStreams >= maxConcurrentStreamsLowWatermark) {
        return createNewChannel();
      }
      return channelCandidate;
    }

    if (channelRefs.size() < maxSize && readyMinStreams >= maxConcurrentStreamsLowWatermark) {
      return createNewChannel();
    }

    if (readyCandidate != null) {
      return readyCandidate;
    }

    return channelCandidate;
  }

  @Override
  public String authority() {
    if (channelRefs.size() > 0) {
      return channelRefs.get(0).getChannel().authority();
    }
    final ManagedChannel channel = delegateChannelBuilder.build();
    final String authority = channel.authority();
    channel.shutdownNow();
    return authority;
  }

  /**
   * Manage the channelpool using GcpClientCall().
   *
   * <p>If method-affinity is specified, we will use the GcpClientCall to fetch the affinitykey and
   * bind/unbind the channel, otherwise we just need the SimpleGcpClientCall to keep track of the
   * number of streams in each channel.
   */
  @Override
  public <ReqT, RespT> ClientCall<ReqT, RespT> newCall(
      MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions) {
    AffinityConfig affinity = methodToAffinity.get(methodDescriptor.getFullMethodName());
    if (affinity == null) {
      return new GcpClientCall.SimpleGcpClientCall<ReqT, RespT>(
          getChannelRef(null), methodDescriptor, callOptions);
    }
    return new GcpClientCall<ReqT, RespT>(this, methodDescriptor, callOptions, affinity);
  }

  @Override
  public ManagedChannel shutdownNow() {
    for (ChannelRef channelRef : channelRefs) {
      if (!channelRef.getChannel().isTerminated()) {
        channelRef.getChannel().shutdownNow();
      }
    }
    return this;
  }

  @Override
  public ManagedChannel shutdown() {
    for (ChannelRef channelRef : channelRefs) {
      channelRef.getChannel().shutdown();
    }
    return this;
  }

  @Override
  public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
    long endTimeNanos = System.nanoTime() + unit.toNanos(timeout);
    for (ChannelRef channelRef : channelRefs) {
      if (channelRef.getChannel().isTerminated()) {
        continue;
      }
      long awaitTimeNanos = endTimeNanos - System.nanoTime();
      if (awaitTimeNanos <= 0) {
        break;
      }
      channelRef.getChannel().awaitTermination(awaitTimeNanos, TimeUnit.NANOSECONDS);
    }
    return isTerminated();
  }

  @Override
  public boolean isShutdown() {
    for (ChannelRef channelRef : channelRefs) {
      if (!channelRef.getChannel().isShutdown()) {
        return false;
      }
    }
    return true;
  }

  @Override
  public boolean isTerminated() {
    for (ChannelRef channelRef : channelRefs) {
      if (!channelRef.getChannel().isTerminated()) {
        return false;
      }
    }
    return true;
  }

  /** Get the current connectivity state of the channel pool. */
  @Override
  public ConnectivityState getState(boolean requestConnection) {
    int ready = 0;
    int idle = 0;
    int connecting = 0;
    int transientFailure = 0;
    int shutdown = 0;
    for (ChannelRef channelRef : channelRefs) {
      ConnectivityState cur = channelRef.getChannel().getState(requestConnection);
      if (cur.equals(ConnectivityState.READY)) {
        ready++;
      } else if (cur.equals(ConnectivityState.SHUTDOWN)) {
        shutdown++;
      } else if (cur.equals(ConnectivityState.TRANSIENT_FAILURE)) {
        transientFailure++;
      } else if (cur.equals(ConnectivityState.CONNECTING)) {
        connecting++;
      } else if (cur.equals(ConnectivityState.IDLE)) {
        idle++;
      }
    }

    if (ready > 0) {
      return ConnectivityState.READY;
    } else if (connecting > 0) {
      return ConnectivityState.CONNECTING;
    } else if (transientFailure > 0) {
      return ConnectivityState.TRANSIENT_FAILURE;
    } else if (idle > 0) {
      return ConnectivityState.IDLE;
    } else if (shutdown > 0) {
      return ConnectivityState.SHUTDOWN;
    }
    // When no channels are created yet it is also IDLE.
    return ConnectivityState.IDLE;
  }

  /**
   * Bind channel with affinity key.
   *
   * <p>One channel can be mapped to more than one keys. But one key can only be mapped to one
   * channel.
   */
  protected void bind(ChannelRef channelRef, List<String> affinityKeys) {
    for (String affinityKey : affinityKeys) {
      while (affinityKeyToChannelRef.putIfAbsent(affinityKey, channelRef) != null) {
        unbind(Collections.singletonList(affinityKey));
      }
      channelRef.affinityCountIncr();
    }
  }

  /** Unbind channel with affinity key. */
  protected void unbind(List<String> affinityKeys) {
    for (String affinityKey : affinityKeys) {
      ChannelRef channelRef = affinityKeyToChannelRef.remove(affinityKey);
      if (channelRef != null) {
        channelRef.affinityCountDecr();
      }
    }
  }

  /** Load parameters from ApiConfig. */
  private void loadApiConfig(ApiConfig apiConfig) {
    if (apiConfig == null) {
      return;
    }
    // Get the channelPool parameters
    if (apiConfig.getChannelPool().getMaxSize() > 0) {
      maxSize = apiConfig.getChannelPool().getMaxSize();
    }
    final int lowWatermark = apiConfig.getChannelPool().getMaxConcurrentStreamsLowWatermark();
    if (lowWatermark >= 0 && lowWatermark <= DEFAULT_MAX_STREAM) {
      this.maxConcurrentStreamsLowWatermark = lowWatermark;
    }
    // Get method parameters.
    for (MethodConfig method : apiConfig.getMethodList()) {
      if (method.getAffinity().equals(AffinityConfig.getDefaultInstance())) {
        continue;
      }
      for (String methodName : method.getNameList()) {
        methodToAffinity.put(methodName, method.getAffinity());
      }
    }
  }

  /**
   * Get the affinity key from the request message.
   *
   * <p>The message can be written in the format of:
   *
   * <p>session1: "the-key-we-want" \n transaction_id: "not-useful" \n transaction { \n session2:
   * "another session"} \n}
   *
   * <p>If the (affinity) name is "session1", it will return "the-key-we-want".
   *
   * <p>If you want to get the key "another session" in the nested message, the name should be
   * "session1.session2".
   */
  @VisibleForTesting
  static List<String> getKeysFromMessage(MessageOrBuilder msg, String name) {
    // The field names in a nested message name are splitted by '.'.
    int currentLength = name.indexOf('.');
    String currentName = name;
    if (currentLength != -1) {
      currentName = name.substring(0, currentLength);
    }

    List<String> keys = new ArrayList<>();
    Map<FieldDescriptor, Object> obs = msg.getAllFields();
    for (Map.Entry<FieldDescriptor, Object> entry : obs.entrySet()) {
      if (entry.getKey().getName().equals(currentName)) {
        if (currentLength == -1 && entry.getValue() instanceof String) {
          // Value of the current field.
          keys.add(entry.getValue().toString());
        } else if (currentLength != -1 && entry.getValue() instanceof MessageOrBuilder) {
          // One nested MessageOrBuilder.
          keys.addAll(
              getKeysFromMessage(
                  (MessageOrBuilder) entry.getValue(), name.substring(currentLength + 1)));
        } else if (currentLength != -1 && entry.getValue() instanceof List) {
          // Repeated nested MessageOrBuilder.
          List<?> list = (List<?>) entry.getValue();
          if (list.size() > 0 && list.get(0) instanceof MessageOrBuilder) {
            for (int i = 0; i < list.size(); i++) {
              keys.addAll(
                  getKeysFromMessage(
                      (MessageOrBuilder) list.get(i), name.substring(currentLength + 1)));
            }
          }
        }
      }
    }
    return keys;
  }

  /**
   * Fetch the affinity key from the message.
   *
   * @param message the <reqT> or <respT> prototype message.
   * @param isReq indicates if the message is a request message.
   */
  protected <ReqT, RespT> List<String> checkKeys(
      Object message, boolean isReq, MethodDescriptor<ReqT, RespT> methodDescriptor) {
    if (!(message instanceof MessageOrBuilder)) {
      return null;
    }

    AffinityConfig affinity = methodToAffinity.get(methodDescriptor.getFullMethodName());
    if (affinity != null) {
      AffinityConfig.Command cmd = affinity.getCommand();
      String keyName = affinity.getAffinityKey();
      List<String> keys = getKeysFromMessage((MessageOrBuilder) message, keyName);
      if (isReq && (cmd == AffinityConfig.Command.UNBIND || cmd == AffinityConfig.Command.BOUND)) {
        if (keys.size() > 1) {
          throw new IllegalStateException("Duplicate affinity key in the request message");
        }
        return keys;
      }
      if (!isReq && cmd == AffinityConfig.Command.BIND) {
        return keys;
      }
    }
    return null;
  }

  /**
   * A wrapper of real grpc channel, it provides helper functions to calculate affinity counts and
   * active streams count.
   */
  protected class ChannelRef {

    private final ManagedChannel delegate;
    private final int channelId;
    private final AtomicInteger affinityCount;
    // activeStreamsCount are mutated from the GcpClientCall concurrently using the
    // `activeStreamsCountIncr()` and `activeStreamsCountDecr()` methods.
    private final AtomicInteger activeStreamsCount;
    private long lastResponseNanos = System.nanoTime();
    private final AtomicInteger deadlineExceededCount = new AtomicInteger();
    private final AtomicLong okCalls = new AtomicLong();
    private final AtomicLong errCalls = new AtomicLong();

    protected ChannelRef(ManagedChannel channel, int channelId) {
      this(channel, channelId, 0, 0);
    }

    protected ChannelRef(
        ManagedChannel channel, int channelId, int affinityCount, int activeStreamsCount) {
      this.delegate = channel;
      this.channelId = channelId;
      this.affinityCount = new AtomicInteger(affinityCount);
      this.activeStreamsCount = new AtomicInteger(activeStreamsCount);
      new ChannelStateMonitor(channel, channelId);
    }

    protected ManagedChannel getChannel() {
      return delegate;
    }

    protected int getId() {
      return channelId;
    }

    protected void affinityCountIncr() {
      affinityCount.incrementAndGet();
      totalAffinityCount.incrementAndGet();
    }

    protected void affinityCountDecr() {
      affinityCount.decrementAndGet();
      totalAffinityCount.decrementAndGet();
    }

    protected void activeStreamsCountIncr() {
      int actStreams = activeStreamsCount.incrementAndGet();
      if (maxActiveStreams < actStreams) {
        maxActiveStreams = actStreams;
      }
      int totalActStreams = totalActiveStreams.incrementAndGet();
      if (maxTotalActiveStreams < totalActStreams) {
        maxTotalActiveStreams = totalActStreams;
      }
    }

    protected void activeStreamsCountDecr(long startNanos, Status status, boolean fromClientSide) {
      int actStreams = activeStreamsCount.decrementAndGet();
      if (minActiveStreams > actStreams) {
        minActiveStreams = actStreams;
      }
      int totalActStreams = totalActiveStreams.decrementAndGet();
      if (minTotalActiveStreams > totalActStreams) {
        minTotalActiveStreams = totalActStreams;
      }
      if (status.isOk()) {
        okCalls.incrementAndGet();
        totalOkCalls.incrementAndGet();
      } else {
        errCalls.incrementAndGet();
        totalErrCalls.incrementAndGet();
      }
      if (unresponsiveDetectionEnabled) {
        detectUnresponsiveConnection(startNanos, status, fromClientSide);
      }
    }

    protected void messageReceived() {
      lastResponseNanos = System.nanoTime();
      deadlineExceededCount.set(0);
    }

    protected int getAffinityCount() {
      return affinityCount.get();
    }

    protected int getActiveStreamsCount() {
      return activeStreamsCount.get();
    }

    protected long getAndResetOkCalls() {
      return okCalls.getAndSet(0);
    }

    protected long getAndResetErrCalls() {
      return errCalls.getAndSet(0);
    }

    private void detectUnresponsiveConnection(
        long startNanos, Status status, boolean fromClientSide) {
      if (status.getCode().equals(Code.DEADLINE_EXCEEDED)) {
        if (startNanos < lastResponseNanos) {
          // Skip deadline exceeded from past calls.
          return;
        }
        if (deadlineExceededCount.incrementAndGet() >= unresponsiveDropCount
            && unresponsiveTimingConditionMet()) {
          maybeReconnectUnresponsive();
        }
        return;
      }
      if (!fromClientSide) {
        // If not a deadline exceeded and not coming from the client side then reset time and count.
        lastResponseNanos = System.nanoTime();
        deadlineExceededCount.set(0);
      }
    }

    private boolean unresponsiveTimingConditionMet() {
      return (System.nanoTime() - lastResponseNanos) / 1000000 >= unresponsiveMs;
    }

    private synchronized void maybeReconnectUnresponsive() {
      if (deadlineExceededCount.get() >= unresponsiveDropCount
          && unresponsiveTimingConditionMet()) {
        recordUnresponsiveDetection(
            System.nanoTime() - lastResponseNanos, deadlineExceededCount.get());
        delegate.enterIdle();
        lastResponseNanos = System.nanoTime();
        deadlineExceededCount.set(0);
      }
    }
  }
}
