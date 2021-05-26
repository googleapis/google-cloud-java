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

package com.google.grpc.gcp;

import static com.google.grpc.gcp.GcpMetricsConstants.METRIC_MAX_ACTIVE_STREAMS;
import static com.google.grpc.gcp.GcpMetricsConstants.METRIC_MAX_ALLOWED_CHANNELS;
import static com.google.grpc.gcp.GcpMetricsConstants.METRIC_MIN_ACTIVE_STREAMS;
import static com.google.grpc.gcp.GcpMetricsConstants.METRIC_NUM_CHANNELS;
import static com.google.grpc.gcp.GcpMetricsConstants.METRIC_NUM_TOTAL_ACTIVE_STREAMS;
import static com.google.grpc.gcp.GcpMetricsConstants.POOL_INDEX_DESC;
import static com.google.grpc.gcp.GcpMetricsConstants.POOL_INDEX_LABEL;

import com.google.common.annotations.VisibleForTesting;
import com.google.grpc.gcp.GcpManagedChannelOptions.GcpMetricsOptions;
import com.google.grpc.gcp.GcpManagedChannelOptions.GcpResiliencyOptions;
import com.google.grpc.gcp.proto.AffinityConfig;
import com.google.grpc.gcp.proto.ApiConfig;
import com.google.grpc.gcp.proto.MethodConfig;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.MessageOrBuilder;
import io.grpc.CallOptions;
import io.grpc.ClientCall;
import io.grpc.ConnectivityState;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.MethodDescriptor;
import io.opencensus.common.ToLongFunction;
import io.opencensus.metrics.DerivedLongGauge;
import io.opencensus.metrics.LabelKey;
import io.opencensus.metrics.LabelValue;
import io.opencensus.metrics.MetricOptions;
import io.opencensus.metrics.MetricRegistry;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/** A channel management factory that implements grpc.Channel APIs. */
public class GcpManagedChannel extends ManagedChannel {
  private static final Logger logger = Logger.getLogger(GcpManagedChannel.class.getName());
  private static final AtomicInteger channelPoolIndex = new AtomicInteger();
  private static final int DEFAULT_MAX_CHANNEL = 10;
  private static final int DEFAULT_MAX_STREAM = 100;

  private final ManagedChannelBuilder delegateChannelBuilder;
  private final GcpManagedChannelOptions options;
  private final boolean fallbackEnabled;
  private int maxSize = DEFAULT_MAX_CHANNEL;
  private int maxConcurrentStreamsLowWatermark = DEFAULT_MAX_STREAM;

  @VisibleForTesting
  final Map<String, AffinityConfig> methodToAffinity = new HashMap<String, AffinityConfig>();

  @VisibleForTesting
  @GuardedBy("bindLock")
  final Map<String, ChannelRef> affinityKeyToChannelRef = new HashMap<String, ChannelRef>();

  // Map from a broken channel id to the remapped affinity keys (key => ready channel id).
  private final Map<Integer, Map<String, Integer>> fallbackMap = new ConcurrentHashMap<>();

  @VisibleForTesting
  @GuardedBy("this")
  final List<ChannelRef> channelRefs = new ArrayList<ChannelRef>();

  private final Map<Integer, ChannelRef> channelRefById = new HashMap<>();

  private final Object bindLock = new Object();

  private MetricRegistry metricRegistry;
  private List<LabelKey> labelKeys = new ArrayList<>();
  private List<LabelValue> labelValues = new ArrayList<>();
  private String metricPrefix;

  /**
   * Constructor for GcpManagedChannel.
   *
   * @param delegateChannelBuilder the underlying delegate ManagedChannelBuilder.
   * @param apiConfig the ApiConfig object for configuring GcpManagedChannel.
   * @param options the options for GcpManagedChannel.
   */
  public GcpManagedChannel(
      ManagedChannelBuilder delegateChannelBuilder,
      ApiConfig apiConfig,
      int poolSize,
      GcpManagedChannelOptions options) {
    loadApiConfig(apiConfig);
    if (poolSize != 0) {
      this.maxSize = poolSize;
    }
    this.delegateChannelBuilder = delegateChannelBuilder;
    // Initialize the first delegate channel.
    getChannelRef(null);
    this.options = options;
    initOptions();
    if (options.getResiliencyOptions() != null) {
      fallbackEnabled = options.getResiliencyOptions().isNotReadyFallbackEnabled();
    } else {
      fallbackEnabled = false;
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
    labelKeys = new ArrayList<>(metricsOptions.getLabelKeys());
    labelValues = new ArrayList<>(metricsOptions.getLabelValues());
    labelKeys.add(LabelKey.create(POOL_INDEX_LABEL, POOL_INDEX_DESC));
    labelValues.add(
        LabelValue.create(String.format("pool-%d", channelPoolIndex.getAndIncrement())));
    metricPrefix = metricsOptions.getNamePrefix();

    createDerivedLongGaugeTimeSeries(
        METRIC_NUM_CHANNELS,
        "The number of channels in the pool.",
        GcpMetricsOptions.COUNT,
        this,
        GcpManagedChannel::getNumberOfChannels);

    createDerivedLongGaugeTimeSeries(
        METRIC_MAX_ALLOWED_CHANNELS,
        "The maximum number of channels allowed in the pool.",
        GcpMetricsOptions.COUNT,
        this,
        GcpManagedChannel::getMaxSize);

    createDerivedLongGaugeTimeSeries(
        METRIC_MIN_ACTIVE_STREAMS,
        "The minimum number of active streams on any channel.",
        GcpMetricsOptions.COUNT,
        this,
        GcpManagedChannel::getMinActiveStreams);

    createDerivedLongGaugeTimeSeries(
        METRIC_MAX_ACTIVE_STREAMS,
        "The maximum number of active streams on any channel.",
        GcpMetricsOptions.COUNT,
        this,
        GcpManagedChannel::getMaxActiveStreams);

    createDerivedLongGaugeTimeSeries(
        METRIC_NUM_TOTAL_ACTIVE_STREAMS,
        "The total number of active streams across all channels.",
        GcpMetricsOptions.COUNT,
        this,
        GcpManagedChannel::getTotalActiveStreams);
  }

  private <T> void createDerivedLongGaugeTimeSeries(
      String name, String description, String unit, T obj, ToLongFunction<T> func) {
    final DerivedLongGauge gauge =
        metricRegistry.addDerivedLongGauge(
            metricPrefix + name,
            MetricOptions.builder()
                .setDescription(description)
                .setLabelKeys(labelKeys)
                .setUnit(unit)
                .build());

    gauge.removeTimeSeries(labelValues);
    gauge.createTimeSeries(labelValues, obj, func);
  }

  /**
   * ChannelStateMonitor subscribes to channel's state changes and informs {@link GcpManagedChannel}
   * on any new state. This monitor allows to detect when a channel is not ready and temporarily
   * route requests via another ready channel if the option is enabled.
   */
  private class ChannelStateMonitor implements Runnable {
    private final int channelId;
    private final ManagedChannel channel;

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
      processChannelStateChange(channelId, newState);
      if (newState != ConnectivityState.SHUTDOWN) {
        channel.notifyWhenStateChanged(newState, this);
      }
    }
  }

  private void processChannelStateChange(int channelId, ConnectivityState state) {
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
    final OptionalInt minStreams =
        channelRefs.stream().mapToInt(ChannelRef::getActiveStreamsCount).min();
    if (minStreams.isPresent()) {
      return minStreams.getAsInt();
    }
    return 0;
  }

  public int getMaxActiveStreams() {
    final OptionalInt maxStreams =
        channelRefs.stream().mapToInt(ChannelRef::getActiveStreamsCount).max();
    if (maxStreams.isPresent()) {
      return maxStreams.getAsInt();
    }
    return 0;
  }

  public int getTotalActiveStreams() {
    return channelRefs.stream().mapToInt(ChannelRef::getActiveStreamsCount).sum();
  }

  /**
   * Pick a {@link ChannelRef} (and create a new one if necessary). If notReadyFallbackEnabled is
   * true in the {@link GcpResiliencyOptions} then instead of a channel in a non-READY state another
   * channel in the READY state and having fewer than maximum allowed number of active streams will
   * be provided if available. Subsequent calls with the same affinity key will provide the same
   * fallback channel as long as the fallback channel is in the READY state and has fewer than
   * maximum allowed number of active streams.
   *
   * @param key affinity key. If it is specified, pick the ChannelRef bound with the affinity key.
   *     Otherwise pick the one with the smallest number of streams.
   */
  protected ChannelRef getChannelRef(@Nullable String key) {
    if (key == null || key.equals("")) {
      return pickLeastBusyChannel();
    }
    ChannelRef channelRef = affinityKeyToChannelRef.get(key);
    if (channelRef == null || !fallbackEnabled) {
      return channelRef;
    }
    // Look up if the channelRef is not ready.
    Map<String, Integer> tempMap = fallbackMap.get(channelRef.getId());
    if (tempMap == null) {
      // Channel is ready.
      return channelRef;
    }
    // Channel is not ready. Look up if the affinity key mapped to another channel.
    Integer channelId = tempMap.get(key);
    if (channelId == null || fallbackMap.containsKey(channelId)) {
      // No temp mapping for this key or fallback channelId is also broken.
      channelRef = pickLeastBusyChannel();
      tempMap.put(key, channelRef.getId());
      return channelRef;
    }
    // Fallback channelId is ready.
    return channelRefById.get(channelId);
  }

  /**
   * Pick a {@link ChannelRef} (and create a new one if necessary). If notReadyFallbackEnabled is
   * true in the {@link GcpResiliencyOptions} then instead of a channel in a non-READY state another
   * channel in the READY state and having fewer than maximum allowed number of active streams will
   * be provided if available.
   */
  private synchronized ChannelRef pickLeastBusyChannel() {
    int size = channelRefs.size();
    channelRefs.sort(Comparator.comparingInt(ChannelRef::getActiveStreamsCount));

    // Create a new channel if the max size has not been reached.
    if (size == 0
        || (size < maxSize
            && channelRefs.get(0).getActiveStreamsCount() >= maxConcurrentStreamsLowWatermark)) {
      ChannelRef channelRef = new ChannelRef(delegateChannelBuilder.build(), size);
      channelRefs.add(channelRef);
      channelRefById.put(size, channelRef);
      return channelRef;
    }

    if (!fallbackEnabled) {
      return channelRefs.get(0);
    }

    // Pick the least busy ready channel.
    for (ChannelRef channelRef : channelRefs) {
      // Do not fallback to overloaded channels.
      if (channelRef.getActiveStreamsCount() >= DEFAULT_MAX_STREAM) {
        break;
      }
      // Skip not ready channels.
      if (fallbackMap.containsKey(channelRef.getId())) {
        continue;
      }
      return channelRef;
    }
    // Return the least busy non-ready channel if all others are not ready or overloaded.
    return channelRefs.get(0);
  }

  @Override
  public synchronized String authority() {
    return channelRefs.get(0).getChannel().authority();
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
  public synchronized ManagedChannel shutdownNow() {
    for (ChannelRef channelRef : channelRefs) {
      if (!channelRef.getChannel().isTerminated()) {
        channelRef.getChannel().shutdownNow();
      }
    }
    return this;
  }

  @Override
  public synchronized ManagedChannel shutdown() {
    for (ChannelRef channelRef : channelRefs) {
      channelRef.getChannel().shutdown();
    }
    return this;
  }

  @Override
  public synchronized boolean awaitTermination(long timeout, TimeUnit unit)
      throws InterruptedException {
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
  public synchronized boolean isShutdown() {
    for (ChannelRef channelRef : channelRefs) {
      if (!channelRef.getChannel().isShutdown()) {
        return false;
      }
    }
    return true;
  }

  @Override
  public synchronized boolean isTerminated() {
    for (ChannelRef channelRef : channelRefs) {
      if (!channelRef.getChannel().isTerminated()) {
        return false;
      }
    }
    return true;
  }

  /** Get the current connectivity state of the channel pool. */
  @Override
  public synchronized ConnectivityState getState(boolean requestConnection) {
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
    return null;
  }

  /**
   * Bind channel with affinity key.
   *
   * <p>One channel can be mapped to more than one keys. But one key can only be mapped to one
   * channel.
   */
  protected void bind(ChannelRef channelRef, List<String> affinityKeys) {
    synchronized (bindLock) {
      if (affinityKeys != null && channelRef != null) {
        for (String affinityKey : affinityKeys) {
          if (!affinityKeyToChannelRef.containsKey(affinityKey)) {
            affinityKeyToChannelRef.put(affinityKey, channelRef);
          }
          affinityKeyToChannelRef.get(affinityKey).affinityCountIncr();
        }
      }
    }
  }

  /**
   * Unbind channel with affinity key. If one ChannelRef has zero affinity key bound with it, delete
   * all the <affinityKey, channel> maps.
   */
  protected void unbind(List<String> affinityKeys) {
    synchronized (bindLock) {
      if (affinityKeys != null) {
        for (String affinityKey : affinityKeys) {
          if (!affinityKey.equals("") && affinityKeyToChannelRef.containsKey(affinityKey)) {
            ChannelRef removedChannelRef = affinityKeyToChannelRef.get(affinityKey);
            if (removedChannelRef.getAffinityCount() > 0) {
              removedChannelRef.affinityCountDecr();
            }

            // Current channel has no affinity key bound with it.
            if (removedChannelRef.getAffinityCount() == 0) {
              Set<String> removedKeys = new HashSet<String>();
              for (String key : affinityKeyToChannelRef.keySet()) {
                if (affinityKeyToChannelRef.get(key) == removedChannelRef) {
                  removedKeys.add(key);
                }
              }
              for (String key : removedKeys) {
                affinityKeyToChannelRef.remove(key);
              }
            }
          }
        }
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
    private int affinityCount;
    // activeStreamsCount are mutated from the GcpClientCall concurrently using the
    // `activeStreamsCountIncr()` and `activeStreamsCountDecr()` methods.
    private final AtomicInteger activeStreamsCount;

    protected ChannelRef(ManagedChannel channel, int channelId) {
      this(channel, channelId, 0, 0);
    }

    protected ChannelRef(
        ManagedChannel channel, int channelId, int affinityCount, int activeStreamsCount) {
      this.delegate = channel;
      this.channelId = channelId;
      this.affinityCount = affinityCount;
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
      affinityCount++;
    }

    protected void affinityCountDecr() {
      affinityCount--;
    }

    protected void activeStreamsCountIncr() {
      activeStreamsCount.incrementAndGet();
    }

    protected void activeStreamsCountDecr() {
      activeStreamsCount.decrementAndGet();
    }

    protected int getAffinityCount() {
      return affinityCount;
    }

    protected int getActiveStreamsCount() {
      return activeStreamsCount.get();
    }
  }
}
