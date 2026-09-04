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

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.NANOSECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

import com.google.cloud.grpc.GcpManagedChannelOptions.GcpChannelPoolOptions;
import com.google.cloud.grpc.GcpManagedChannelOptions.GcpMetricsOptions;
import com.google.cloud.grpc.GcpManagedChannelOptions.GcpResiliencyOptions;
import com.google.cloud.grpc.proto.AffinityConfig;
import com.google.cloud.grpc.proto.ApiConfig;
import com.google.cloud.grpc.proto.MethodConfig;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Joiner;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.TextFormat;
import io.grpc.CallOptions;
import io.grpc.ClientCall;
import io.grpc.ConnectivityState;
import io.grpc.Context;
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
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.api.metrics.Meter;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;
import java.util.function.IntUnaryOperator;
import java.util.function.LongUnaryOperator;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.annotation.Nullable;

/** A channel management factory that implements grpc.Channel APIs. */
public class GcpManagedChannel extends ManagedChannel {

  private static final Logger logger = Logger.getLogger(GcpManagedChannel.class.getName());
  static final AtomicInteger channelPoolIndex = new AtomicInteger();

  @FunctionalInterface
  interface NanoClock {
    long get();
  }

  // Counter for tracking channel ids.
  final AtomicInteger nextChannelId = new AtomicInteger();
  static final int DEFAULT_MAX_CHANNEL = 10;
  static final int DEFAULT_MAX_STREAM = 100;
  public static final Context.Key<Boolean> DISABLE_AFFINITY_CTX_KEY =
      Context.keyWithDefault("DisableAffinity", false);
  public static final CallOptions.Key<Boolean> DISABLE_AFFINITY_KEY =
      CallOptions.Key.createWithDefault("DisableAffinity", false);
  public static final Context.Key<String> AFFINITY_CTX_KEY = Context.key("AffinityKey");
  public static final CallOptions.Key<String> AFFINITY_KEY = CallOptions.Key.create("AffinityKey");

  /** When set to true, the affinity key will be unbound after the call completes. */
  public static final CallOptions.Key<Boolean> UNBIND_AFFINITY_KEY =
      CallOptions.Key.createWithDefault("UnbindAffinityKey", false);

  /**
   * CallOptions key that will be set by grpc-gcp with the actual channel ID used for the call. This
   * can be read by downstream interceptors to get the real channel ID after channel selection.
   */
  public static final CallOptions.Key<Integer> CHANNEL_ID_KEY =
      CallOptions.Key.create("GcpChannelId");

  /** CallOptions key for sticky channel routing without affinity-key map state. */
  public static final CallOptions.Key<ChannelAffinityRef> CHANNEL_AFFINITY_REF_KEY =
      CallOptions.Key.create("GcpChannelAffinityRef");

  /**
   * Opaque caller-owned channel reference for transaction-lifetime stickiness.
   *
   * <p>The reference remains on a draining channel until its delegate shuts down. Call {@link
   * #useDifferentChannelOnNextCall()} to move the next RPC to another active channel.
   */
  public static final class ChannelAffinityRef {
    private static final int USE_DIFFERENT_CHANNEL_ON_NEXT_CALL_MASK = 1 << 31;
    private static final int CHANNEL_ID_MASK = ~USE_DIFFERENT_CHANNEL_ON_NEXT_CALL_MASK;
    private static final int NO_CHANNEL_ID = -1;

    // Single allocation hot-path state:
    // * lower 31 bits: channel id + 1, or 0 when unset.
    // * high bit: use a different active channel on the next call.
    private final AtomicInteger state = new AtomicInteger();

    /** Forces the next RPC to prefer a different active channel if one is available. */
    public void useDifferentChannelOnNextCall() {
      state.getAndUpdate(value -> value | USE_DIFFERENT_CHANNEL_ON_NEXT_CALL_MASK);
    }

    @VisibleForTesting
    void setChannelIdForTest(int channelId) {
      state.set(stateFromChannelId(channelId));
    }

    private static int channelIdFromState(int state) {
      int encodedChannelId = state & CHANNEL_ID_MASK;
      return encodedChannelId == 0 ? NO_CHANNEL_ID : encodedChannelId - 1;
    }

    private static boolean useDifferentChannelOnNextCallFromState(int state) {
      return (state & USE_DIFFERENT_CHANNEL_ON_NEXT_CALL_MASK) != 0;
    }

    private static int stateFromChannelId(int channelId) {
      return (channelId + 1) & CHANNEL_ID_MASK;
    }
  }

  @GuardedBy("this")
  private Integer bindingIndex = -1;

  private final ManagedChannelBuilder<?> delegateChannelBuilder;
  private final GcpManagedChannelOptions options;
  private final boolean fallbackEnabled;
  private final boolean unresponsiveDetectionEnabled;
  private final int unresponsiveMs;
  private final int unresponsiveDropCount;
  private int maxSize = DEFAULT_MAX_CHANNEL;
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
  private long errorPenaltyDurationNanos = Duration.ofSeconds(5).toNanos();
  @Nullable private GcpChannelPrimeController channelPrimeController;
  private boolean isDynamicScalingEnabled = false;
  private int maxConcurrentStreamsLowWatermark = DEFAULT_MAX_STREAM;
  private GcpManagedChannelOptions.ChannelPickStrategy channelPickStrategy =
      GcpManagedChannelOptions.ChannelPickStrategy.POWER_OF_TWO;
  private Duration affinityKeyLifetime = Duration.ZERO;

  @VisibleForTesting final Map<String, AffinityConfig> methodToAffinity = new HashMap<>();

  @VisibleForTesting
  final Map<String, ChannelRef> affinityKeyToChannelRef = new ConcurrentHashMap<>();

  @VisibleForTesting final Map<String, Long> affinityKeyLastUsed = new ConcurrentHashMap<>();

  // Map from a broken channel id to the remapped affinity keys (key => ready channel id).
  private final Map<Integer, Map<String, Integer>> fallbackMap = new ConcurrentHashMap<>();

  // The channel pool.
  @VisibleForTesting final List<ChannelRef> channelRefs = new CopyOnWriteArrayList<>();
  private final Map<Integer, ChannelRef> channelIdToChannelRef = new ConcurrentHashMap<>();
  // A set of channels that we removed from the pool and wait for their RPCs to be completed before
  // we can shut them down.
  final Set<ChannelRef> removedChannelRefs = ConcurrentHashMap.newKeySet();

  @GuardedBy("this")
  private final Map<ChannelRef, ScheduledFuture<?>> drainTasks = new HashMap<>();

  // One-slot scale-up signal. At most one worker mutates pool size at a time.
  private final AtomicBoolean scaleUpSignalPending = new AtomicBoolean();
  private final AtomicBoolean scaleUpWorkerRunning = new AtomicBoolean();
  private final AtomicLong totalErrorPenaltyLoad = new AtomicLong();

  private volatile long lastScaleUpNanos = Long.MIN_VALUE;
  private int consecutiveLowLoadChecks;
  private volatile boolean shuttingDown;

  private final ExecutorService stateNotificationExecutor =
      Executors.newCachedThreadPool(
          GcpThreadFactory.newThreadFactory("gcp-mc-state-notifications-%d"));

  // Callbacks to call when state changes.
  @GuardedBy("this")
  private List<Runnable> stateChangeCallbacks = new LinkedList<>();

  // Metrics configuration.
  private MetricRegistry metricRegistry;
  private Meter otelMeter;
  private Attributes otelCommonAttributes;
  private final List<LabelKey> labelKeys = new ArrayList<>();
  private final List<LabelKey> labelKeysWithResult =
      new ArrayList<>(
          Collections.singletonList(
              LabelKey.create(GcpMetricsConstants.RESULT_LABEL, GcpMetricsConstants.RESULT_DESC)));
  private final List<LabelKey> labelKeysWithDirection =
      new ArrayList<>(
          Collections.singletonList(
              LabelKey.create(
                  GcpMetricsConstants.DIRECTION_LABEL, GcpMetricsConstants.DIRECTION_LABEL_DESC)));
  private final List<LabelValue> labelValues = new ArrayList<>();
  private final List<LabelValue> labelValuesSuccess =
      new ArrayList<>(
          Collections.singletonList(LabelValue.create(GcpMetricsConstants.RESULT_SUCCESS)));
  private final List<LabelValue> labelValuesError =
      new ArrayList<>(
          Collections.singletonList(LabelValue.create(GcpMetricsConstants.RESULT_ERROR)));
  private final List<LabelValue> labelValuesUp =
      new ArrayList<>(
          Collections.singletonList(LabelValue.create(GcpMetricsConstants.DIRECTION_UP)));
  private final List<LabelValue> labelValuesDown =
      new ArrayList<>(
          Collections.singletonList(LabelValue.create(GcpMetricsConstants.DIRECTION_DOWN)));
  private String metricPrefix;
  private final String metricPoolIndex =
      String.format("pool-%d", channelPoolIndex.incrementAndGet());
  private final Map<String, Long> cumulativeMetricValues = new ConcurrentHashMap<>();
  private static final ScheduledThreadPoolExecutor SHARED_BACKGROUND_SERVICE =
      createSharedBackgroundService();

  private ScheduledFuture<?> cleanupTask;
  private ScheduledFuture<?> scaleDownTask;
  private ScheduledFuture<?> logMetricsTask;
  private ScheduledExecutorService drainScheduler = SHARED_BACKGROUND_SERVICE;

  // Metrics counters.
  private final AtomicInteger readyChannels = new AtomicInteger();
  private AtomicInteger minChannels = new AtomicInteger();
  private AtomicInteger maxChannels = new AtomicInteger();
  private AtomicInteger minReadyChannels = new AtomicInteger();
  private AtomicInteger maxReadyChannels = new AtomicInteger();
  private final AtomicLong numChannelConnect = new AtomicLong();
  private final AtomicLong numChannelDisconnect = new AtomicLong();
  private AtomicLong minReadinessTime = new AtomicLong();
  private AtomicLong maxReadinessTime = new AtomicLong();
  private final AtomicLong totalReadinessTime = new AtomicLong();
  private final AtomicLong readinessTimeOccurrences = new AtomicLong();
  private final AtomicInteger totalActiveStreams = new AtomicInteger();
  private AtomicInteger minActiveStreams = new AtomicInteger();
  private AtomicInteger maxActiveStreams = new AtomicInteger();
  private AtomicInteger minTotalActiveStreams = new AtomicInteger();
  private AtomicInteger maxTotalActiveStreams = new AtomicInteger();
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
  private final AtomicInteger minAffinity = new AtomicInteger();
  private final AtomicInteger maxAffinity = new AtomicInteger();
  private final AtomicInteger totalAffinityCount = new AtomicInteger();
  private final AtomicLong fallbacksSucceeded = new AtomicLong();
  private final AtomicLong fallbacksFailed = new AtomicLong();
  private final AtomicLong unresponsiveDetectionCount = new AtomicLong();
  private AtomicLong minUnresponsiveMs = new AtomicLong();
  private AtomicLong maxUnresponsiveMs = new AtomicLong();
  private AtomicLong minUnresponsiveDrops = new AtomicLong();
  private AtomicLong maxUnresponsiveDrops = new AtomicLong();
  private AtomicLong scaleUpCount = new AtomicLong();
  private AtomicLong scaleDownCount = new AtomicLong();
  private final AtomicLong scaleUpPrimeFailures = new AtomicLong();

  // Clock supplier for nanoTime, injectable for testing.
  private NanoClock nanoClock = System::nanoTime;
  private IntUnaryOperator candidateIndexPicker =
      bound -> ThreadLocalRandom.current().nextInt(bound);
  @Nullable private volatile Consumer<ChannelRef> pickerValidationHookForTest;
  @Nullable private volatile Runnable inactiveMappingRemovalHookForTest;

  @VisibleForTesting
  void setNanoClock(NanoClock nanoClock) {
    this.nanoClock = nanoClock;
  }

  @VisibleForTesting
  void setPickerValidationHookForTest(Consumer<ChannelRef> hook) {
    pickerValidationHookForTest = hook;
  }

  @VisibleForTesting
  void setCandidateIndexPickerForTest(IntUnaryOperator candidateIndexPicker) {
    this.candidateIndexPicker = candidateIndexPicker;
  }

  @VisibleForTesting
  void setInactiveMappingRemovalHookForTest(Runnable hook) {
    inactiveMappingRemovalHookForTest = hook;
  }

  @VisibleForTesting
  void setDrainSchedulerForTest(ScheduledExecutorService drainScheduler) {
    this.drainScheduler = drainScheduler;
  }

  private boolean validatePickedChannel(ChannelRef channelRef) {
    Consumer<ChannelRef> hook = pickerValidationHookForTest;
    if (hook != null) {
      pickerValidationHookForTest = null;
      hook.accept(channelRef);
    }
    return channelRef.isActive();
  }

  @VisibleForTesting
  Map<Integer, Map<String, Integer>> fallbackMapForTest() {
    return fallbackMap;
  }

  @VisibleForTesting
  int readyChannelCountForTest() {
    return readyChannels.get();
  }

  @VisibleForTesting
  long scaleUpPrimeFailuresForTest() {
    return scaleUpPrimeFailures.get();
  }

  @VisibleForTesting
  boolean scaleUpWorkerRunningForTest() {
    return scaleUpWorkerRunning.get();
  }

  @VisibleForTesting
  synchronized int inFlightPrimeCountForTest() {
    return channelPrimeController == null ? 0 : channelPrimeController.inFlightCount();
  }

  @VisibleForTesting
  synchronized int abandonedPrimeCountForTest() {
    return channelPrimeController == null ? 0 : channelPrimeController.abandonedCount();
  }

  @VisibleForTesting
  static long primeBackoffMillisForTest(int attempt) {
    return GcpChannelPrimeController.backoffMillis(attempt);
  }

  @VisibleForTesting
  static long primeBackoffMillisForTest(int attempt, LongUnaryOperator random) {
    return GcpChannelPrimeController.backoffMillis(attempt, random);
  }

  @VisibleForTesting
  static long primeBaseBackoffMillisForTest(int attempt) {
    return GcpChannelPrimeController.baseBackoffMillis(attempt);
  }

  @VisibleForTesting
  synchronized int drainTaskCountForTest() {
    return drainTasks.size();
  }

  private static ScheduledThreadPoolExecutor createSharedBackgroundService() {
    ScheduledThreadPoolExecutor executor =
        new ScheduledThreadPoolExecutor(
            Math.max(2, Math.min(4, Runtime.getRuntime().availableProcessors() / 2)),
            GcpThreadFactory.newThreadFactory("gcp-mc-bg-%d"));
    executor.setRemoveOnCancelPolicy(true);
    executor.setExecuteExistingDelayedTasksAfterShutdownPolicy(false);
    executor.setContinueExistingPeriodicTasksAfterShutdownPolicy(false);
    return executor;
  }

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
      GcpManagedChannelOptions options) {
    loadApiConfig(apiConfig);
    this.delegateChannelBuilder = delegateChannelBuilder;
    this.options = options;
    logger.finer(
        log(
            "Created with api config: %s, and options: %s",
            apiConfig == null ? "null" : TextFormat.shortDebugString(apiConfig), options));
    initOptions();
    GcpResiliencyOptions resiliencyOptions = options.getResiliencyOptions();
    if (resiliencyOptions != null) {
      fallbackEnabled = resiliencyOptions.isNotReadyFallbackEnabled();
      unresponsiveDetectionEnabled = resiliencyOptions.isUnresponsiveDetectionEnabled();
      unresponsiveMs = resiliencyOptions.getUnresponsiveDetectionMs();
      unresponsiveDropCount = resiliencyOptions.getUnresponsiveDetectionDroppedCount();
    } else {
      fallbackEnabled = false;
      unresponsiveDetectionEnabled = false;
      unresponsiveMs = 0;
      unresponsiveDropCount = 0;
    }
    initChannels();
    GcpChannelPoolOptions channelPoolOptions = options.getChannelPoolOptions();
    if (channelPoolOptions != null) {
      affinityKeyLifetime = channelPoolOptions.getAffinityKeyLifetime();
      initCleanupTask(channelPoolOptions.getCleanupInterval());
      initScaleDownChecker(channelPoolOptions.getScaleDownInterval());
    }
  }

  /**
   * Constructor for GcpManagedChannel. Deprecated. Use the one without the poolSize and set the
   * maximum pool size in options. However, note that if setting the pool size from options then
   * concurrent streams low watermark (even the default one) will be also taken from the options and
   * not apiConfig.
   *
   * @param delegateChannelBuilder the underlying delegate ManagedChannelBuilder.
   * @param apiConfig the ApiConfig object for configuring GcpManagedChannel.
   * @param poolSize maximum number of channels the pool can have.
   * @param options the options for GcpManagedChannel.
   */
  @Deprecated
  public GcpManagedChannel(
      ManagedChannelBuilder<?> delegateChannelBuilder,
      ApiConfig apiConfig,
      int poolSize,
      GcpManagedChannelOptions options) {
    this(delegateChannelBuilder, apiConfig, options);
    if (poolSize != 0) {
      logger.finer(log("Pool size adjusted to %d", poolSize));
      this.maxSize = poolSize;
    }
  }

  @VisibleForTesting
  void cleanupAffinityKeys() {
    final long cutoff = nanoClock.get() - affinityKeyLifetime.toNanos();
    affinityKeyLastUsed.forEach(
        (String key, Long time) -> {
          if (time < cutoff) {
            unbind(Collections.singletonList(key));
          }
        });
  }

  /**
   * Evaluates instantaneous active load; consecutive checks provide the low-load history rather
   * than retaining a maximum observed between checks.
   */
  @VisibleForTesting
  void checkScaleDown() {
    List<ChannelRef> removedChannels;
    synchronized (this) {
      if (!isDynamicScalingEnabled || shuttingDown) {
        return;
      }

      int channelCount = channelRefs.size();
      if (channelCount <= minSize) {
        consecutiveLowLoadChecks = 0;
        return;
      }
      long activeLoad = activeLoad(channelRefs);
      if (activeLoad > (long) minRpcPerChannel * channelCount) {
        consecutiveLowLoadChecks = 0;
        return;
      }
      if (++consecutiveLowLoadChecks < scaleDownConsecutiveLowLoadChecks) {
        return;
      }
      consecutiveLowLoadChecks = 0;

      int desiredSize = Math.max(minSize, ceilDiv(activeLoad, targetRpcPerChannel()));
      int removeCount = Math.min(maxScaleDownChannels, Math.max(0, channelCount - desiredSize));
      removedChannels = removeChannels(removeCount);
    }
    for (ChannelRef channelRef : removedChannels) {
      channelRef.clearErrorPenalty();
    }
    List<String> keysToUnbind =
        affinityKeyToChannelRef.entrySet().stream()
            .filter(entry -> removedChannels.contains(entry.getValue()))
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
    for (String key : keysToUnbind) {
      ChannelRef mappedChannel = affinityKeyToChannelRef.get(key);
      if (removedChannels.contains(mappedChannel)) {
        unbindInactiveMapping(key, mappedChannel);
      }
    }
    for (ChannelRef channelRef : removedChannels) {
      scheduleDrain(channelRef);
    }
  }

  @GuardedBy("this")
  private List<ChannelRef> removeChannels(int num) {
    if (num <= 0) {
      return Collections.emptyList();
    }

    // Drain least-loaded channels first, preferring fewer affinity bindings, then older channels.
    final List<ChannelRef> channelsToRemove =
        channelRefs.stream()
            .sorted(
                Comparator.comparingInt(ChannelRef::getActiveStreamsCount)
                    .thenComparingInt(ChannelRef::getAffinityCount)
                    .thenComparingLong(ChannelRef::getCreatedNanos))
            .limit(num)
            .collect(Collectors.toList());

    for (ChannelRef channelRef : channelsToRemove) {
      // Stop new picks before publishing the shorter active list.
      channelRef.deactivateAndAccountReadiness();
    }
    channelRefs.removeAll(channelsToRemove);

    for (ChannelRef channelRef : channelsToRemove) {
      removedChannelRefs.add(channelRef);
    }
    minChannels.accumulateAndGet(getNumberOfChannels(), Math::min);
    scaleDownCount.addAndGet(channelsToRemove.size());
    executeStateChangeCallbacks();
    return channelsToRemove;
  }

  /** Drain task bookkeeping is guarded by the pool monitor. */
  @VisibleForTesting
  void scheduleDrain(ChannelRef channelRef) {
    boolean closeChannel = false;
    @Nullable DrainTask inlineTask = null;
    synchronized (this) {
      if (channelRef.isActive() || channelRef.getActiveStreamsCount() != 0 || shuttingDown) {
        return;
      }
      long elapsed = Math.max(0, nanoClock.get() - channelRef.getLastActivityNanos());
      long delay = Math.max(0, drainIdleGrace.toNanos() - elapsed);
      DrainTask drainTask = new DrainTask(channelRef);
      ScheduledFuture<?> task;
      try {
        task = drainScheduler.schedule(drainTask, delay, NANOSECONDS);
        drainTask.future = task;
      } catch (RejectedExecutionException e) {
        logger.fine(log("Drain task rejected: %s", e.getMessage()));
        closeChannel = removeDrainedChannel(channelRef);
        task = null;
      }
      if (task != null) {
        ScheduledFuture<?> previous = drainTasks.put(channelRef, task);
        if (previous != null) {
          previous.cancel(false);
        }
        if (drainTask.ranBeforeFutureAssignment) {
          inlineTask = drainTask;
        }
      }
    }
    if (inlineTask != null) {
      finishDrain(channelRef, inlineTask);
    } else if (closeChannel) {
      channelRef.getChannel().shutdown();
    }
  }

  @VisibleForTesting
  void finishDrain(ChannelRef channelRef) {
    finishDrain(channelRef, null);
  }

  private void finishDrain(ChannelRef channelRef, @Nullable DrainTask runningTask) {
    boolean closeChannel = false;
    boolean reschedule = false;
    synchronized (this) {
      ScheduledFuture<?> drainTask = drainTasks.get(channelRef);
      if (runningTask != null && drainTask != runningTask.future) {
        return;
      }
      drainTasks.remove(channelRef);
      if (drainTask != null) {
        drainTask.cancel(false);
      }
      if (channelRef.isActive()
          || channelRef.getActiveStreamsCount() != 0
          || !removedChannelRefs.contains(channelRef)
          || shuttingDown) {
        return;
      }
      long elapsed = Math.max(0, nanoClock.get() - channelRef.getLastActivityNanos());
      if (elapsed < drainIdleGrace.toNanos()) {
        reschedule = true;
      } else {
        closeChannel = removeDrainedChannel(channelRef);
      }
    }
    if (reschedule) {
      scheduleDrain(channelRef);
    } else if (closeChannel) {
      channelRef.getChannel().shutdown();
    }
  }

  private final class DrainTask implements Runnable {
    private final ChannelRef channelRef;

    @GuardedBy("GcpManagedChannel.this")
    private boolean ranBeforeFutureAssignment;

    @GuardedBy("GcpManagedChannel.this")
    @Nullable
    private ScheduledFuture<?> future;

    private DrainTask(ChannelRef channelRef) {
      this.channelRef = channelRef;
    }

    @Override
    public void run() {
      synchronized (GcpManagedChannel.this) {
        if (future == null) {
          ranBeforeFutureAssignment = true;
          return;
        }
      }
      finishDrain(channelRef, this);
    }
  }

  @GuardedBy("this")
  private boolean removeDrainedChannel(ChannelRef channelRef) {
    if (!removedChannelRefs.remove(channelRef)) {
      return false;
    }
    fallbackMap.remove(channelRef.getId());
    channelIdToChannelRef.remove(channelRef.getId(), channelRef);
    return true;
  }

  private static int ceilDiv(long numerator, int denominator) {
    if (numerator <= 0) {
      return 0;
    }
    return (int) Math.min(Integer.MAX_VALUE, 1 + ((numerator - 1) / denominator));
  }

  private static int ceilMultiplyDivide(int factor, long numerator, long denominator) {
    if (factor <= 0 || numerator <= 0 || denominator <= 0) {
      return 0;
    }
    if (numerator >= denominator) {
      return factor;
    }
    if (numerator <= Long.MAX_VALUE / factor) {
      long product = factor * numerator;
      return (int) (product / denominator + (product % denominator == 0 ? 0 : 1));
    }

    // Overflow-safe binary long division for unusually large configured durations or penalties.
    long quotient = 0;
    long remainder = 0;
    for (int bit = Integer.highestOneBit(factor); bit != 0; bit >>>= 1) {
      quotient <<= 1;
      long denominatorMinusRemainder = denominator - remainder;
      if (remainder >= denominatorMinusRemainder) {
        remainder -= denominatorMinusRemainder;
        quotient++;
      } else {
        remainder += remainder;
      }
      if ((factor & bit) != 0) {
        long denominatorMinusNumerator = denominator - numerator;
        if (remainder >= denominatorMinusNumerator) {
          remainder -= denominatorMinusNumerator;
          quotient++;
        } else {
          remainder += numerator;
        }
      }
    }
    return (int) (quotient + (remainder == 0 ? 0 : 1));
  }

  private int targetRpcPerChannel() {
    return Math.max(1, (minRpcPerChannel + maxRpcPerChannel) / 2);
  }

  private long activeLoad(List<ChannelRef> refs) {
    long load = 0;
    for (ChannelRef channelRef : refs) {
      if (channelRef.isActive()) {
        load += channelRef.getActiveStreamsCount();
      }
    }
    return load;
  }

  private long pickerLoad(List<ChannelRef> refs, long now) {
    // Expiry accounting is swept before dynamicUpscale acquires the pool monitor.
    long load = 0;
    for (ChannelRef channelRef : refs) {
      if (channelRef.isActive()) {
        load += channelRef.getPickerLoad(now);
      }
    }
    return load;
  }

  private Supplier<String> log(Supplier<String> messageSupplier) {
    return () -> String.format("%s: %s", metricPoolIndex, messageSupplier.get());
  }

  private String log(String message) {
    return String.format("%s: %s", metricPoolIndex, message);
  }

  private String log(String format, Object... args) {
    return String.format("%s: %s", metricPoolIndex, String.format(format, args));
  }

  private synchronized void initChannels() {
    while (Math.max(minSize, initSize) - getNumberOfChannels() > 0) {
      createNewChannel();
    }
  }

  private void initOptions() {
    GcpManagedChannelOptions.GcpChannelPoolOptions poolOptions = options.getChannelPoolOptions();
    if (poolOptions != null) {
      maxSize = poolOptions.getMaxSize();
      minSize = poolOptions.getMinSize();
      maxConcurrentStreamsLowWatermark = poolOptions.getConcurrentStreamsLowWatermark();
      initSize = poolOptions.getInitSize();
      minRpcPerChannel = poolOptions.getMinRpcPerChannel();
      maxRpcPerChannel = poolOptions.getMaxRpcPerChannel();
      scaleDownInterval = poolOptions.getScaleDownInterval();
      scaleUpCooldown = poolOptions.getScaleUpCooldown();
      scaleDownConsecutiveLowLoadChecks = poolOptions.getScaleDownConsecutiveLowLoadChecks();
      maxScaleUpPercent = poolOptions.getMaxScaleUpPercent();
      maxScaleDownChannels = poolOptions.getMaxScaleDownChannels();
      drainIdleGrace = poolOptions.getDrainIdleGrace();
      errorPenaltyStep = poolOptions.getErrorPenaltyStep();
      errorPenaltyDuration = poolOptions.getErrorPenaltyDuration();
      errorPenaltyDurationNanos = errorPenaltyDuration.toNanos();
      channelPrimeController = createChannelPrimeController(poolOptions);
      isDynamicScalingEnabled =
          minRpcPerChannel > 0 && maxRpcPerChannel > 0 && !scaleDownInterval.isZero();
      channelPickStrategy = poolOptions.getChannelPickStrategy();
    }
    initMetrics();
  }

  @Nullable
  private GcpChannelPrimeController createChannelPrimeController(
      GcpManagedChannelOptions.GcpChannelPoolOptions poolOptions) {
    GcpChannelPrimer primer = poolOptions.getChannelPrimer();
    if (primer == null) {
      return null;
    }
    GcpChannelPrimeController.Pool pool =
        new GcpChannelPrimeController.Pool() {
          @Override
          public boolean isShuttingDown() {
            return shuttingDown;
          }

          @Override
          public boolean isFull() {
            return channelRefs.size() >= maxSize;
          }

          @Override
          public void addPrimedChannel(ManagedChannel channel) {
            addBuiltChannel(channel);
            scaleUpCount.incrementAndGet();
          }

          @Override
          public void reportPrimeFailure(Throwable failure) {
            scaleUpPrimeFailures.incrementAndGet();
            logger.log(Level.WARNING, log("Scaled-up channel priming failed"), failure);
          }

          @Override
          public void reportPrimeAbandoned() {
            logger.warning(
                log(
                    "Channel priming abandoned without retry: prime() was still blocked at the"
                        + " timeout and nothing can stop it. The channel is closed and the blocked"
                        + " call keeps occupying a primer thread and a scale-up slot until it"
                        + " returns."));
          }
        };
    return new GcpChannelPrimeController(
        this,
        pool,
        primer,
        poolOptions.getChannelPrimeTimeout().toNanos(),
        poolOptions.getChannelPrimeMaxAttempts(),
        SHARED_BACKGROUND_SERVICE);
  }

  private synchronized void initCleanupTask(Duration cleanupInterval) {
    if (cleanupInterval.isZero()) {
      return;
    }
    cleanupTask =
        SHARED_BACKGROUND_SERVICE.scheduleAtFixedRate(
            this::cleanupAffinityKeys,
            cleanupInterval.toMillis(),
            cleanupInterval.toMillis(),
            MILLISECONDS);
  }

  private synchronized void initScaleDownChecker(Duration scaleDownInterval) {
    if (!isDynamicScalingEnabled || scaleDownInterval.isZero()) {
      return;
    }

    scaleDownTask =
        SHARED_BACKGROUND_SERVICE.scheduleAtFixedRate(
            () -> {
              try {
                checkScaleDown();
              } catch (Throwable failure) {
                logger.log(Level.WARNING, log("Scale-down check failed"), failure);
              }
            },
            scaleDownInterval.toMillis(),
            scaleDownInterval.toMillis(),
            MILLISECONDS);
  }

  private synchronized void initLogMetrics() {
    logMetricsTask =
        SHARED_BACKGROUND_SERVICE.scheduleAtFixedRate(this::logMetrics, 60, 60, SECONDS);
  }

  private void logMetricsOptions() {
    if (options.getMetricsOptions() != null) {
      logger.fine(log("Metrics options: %s", options.getMetricsOptions()));
    }
  }

  private void logChannelsStats() {
    logger.fine(
        log(
            "Active streams counts: [%s]",
            Joiner.on(", ")
                .join(
                    channelRefs.stream().mapToInt(ChannelRef::getActiveStreamsCount).iterator())));
    logger.fine(
        log(
            "Removed channels active streams counts: [%s]",
            Joiner.on(", ")
                .join(
                    removedChannelRefs.stream()
                        .mapToInt(ChannelRef::getActiveStreamsCount)
                        .iterator())));
    logger.fine(
        log(
            "Affinity counts: [%s]",
            Joiner.on(", ")
                .join(channelRefs.stream().mapToInt(ChannelRef::getAffinityCount).iterator())));
  }

  private void initMetrics() {
    final GcpMetricsOptions metricsOptions = options.getMetricsOptions();
    if (metricsOptions == null) {
      logger.info(log("Metrics options are empty. Metrics disabled."));
      initLogMetrics();
      return;
    }
    logMetricsOptions();
    if (metricsOptions.getOpenTelemetryMeter() != null) {
      // Prefer OpenTelemetry if provided.
      logger.info(log("OpenTelemetry meter detected. Using OpenTelemetry metrics."));
      setupOtelCommonAttributes(metricsOptions);
      metricPrefix = metricsOptions.getNamePrefix();
      initOtelMetrics(metricsOptions.getOpenTelemetryMeter());
      return;
    }
    if (metricsOptions.getMetricRegistry() == null) {
      logger.info(log("Metric registry is null. Metrics disabled."));
      initLogMetrics();
      return;
    }
    logger.info(log("Metrics enabled (OpenCensus)."));

    metricRegistry = metricsOptions.getMetricRegistry();
    labelKeys.addAll(metricsOptions.getLabelKeys());
    labelKeysWithResult.addAll(metricsOptions.getLabelKeys());
    labelKeysWithDirection.addAll(metricsOptions.getLabelKeys());
    labelValues.addAll(metricsOptions.getLabelValues());
    labelValuesSuccess.addAll(metricsOptions.getLabelValues());
    labelValuesError.addAll(metricsOptions.getLabelValues());
    labelValuesUp.addAll(metricsOptions.getLabelValues());
    labelValuesDown.addAll(metricsOptions.getLabelValues());

    final LabelKey poolKey =
        LabelKey.create(GcpMetricsConstants.POOL_INDEX_LABEL, GcpMetricsConstants.POOL_INDEX_DESC);
    labelKeys.add(poolKey);
    labelKeysWithResult.add(poolKey);
    labelKeysWithDirection.add(poolKey);
    final LabelValue poolIndex = LabelValue.create(metricPoolIndex);
    labelValues.add(poolIndex);
    labelValuesSuccess.add(poolIndex);
    labelValuesError.add(poolIndex);
    labelValuesUp.add(poolIndex);
    labelValuesDown.add(poolIndex);

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
        GcpMetricsConstants.METRIC_NUM_CHANNELS,
        "The number of channels currently in the pool.",
        GcpMetricsConstants.COUNT,
        this,
        GcpManagedChannel::reportNumChannels);

    createDerivedLongGaugeTimeSeries(
        GcpMetricsConstants.METRIC_MIN_CHANNELS,
        "The minimum number of channels in the pool.",
        GcpMetricsConstants.COUNT,
        this,
        GcpManagedChannel::reportMinChannels);

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
        GcpMetricsConstants.COUNT,
        this,
        GcpManagedChannel::reportMinUnresponsiveDrops);

    createDerivedLongGaugeTimeSeries(
        GcpMetricsConstants.METRIC_MAX_UNRESPONSIVE_DROPPED_CALLS,
        "The maximum calls dropped before detection of an unresponsive connection.",
        GcpMetricsConstants.COUNT,
        this,
        GcpManagedChannel::reportMaxUnresponsiveDrops);

    createDerivedLongCumulativeTimeSeriesWithDirection(
        GcpMetricsConstants.METRIC_CHANNEL_POOL_SCALING,
        "The number of channels channel pool scaled up or down.",
        GcpMetricsConstants.COUNT,
        this,
        GcpManagedChannel::reportScaleUp,
        GcpManagedChannel::reportScaleDown);

    createDerivedLongCumulativeTimeSeries(
        GcpMetricsConstants.METRIC_SCALE_UP_PRIME_FAILURES,
        "The number of scaled-up channels rejected because priming failed or timed out.",
        GcpMetricsConstants.COUNT,
        this,
        GcpManagedChannel::reportScaleUpPrimeFailures);
  }

  private void setupOtelCommonAttributes(GcpMetricsOptions metricsOptions) {
    AttributesBuilder builder = Attributes.builder();
    if (metricsOptions.getOtelLabelKeys() != null && metricsOptions.getOtelLabelValues() != null) {
      List<String> keys = metricsOptions.getOtelLabelKeys();
      List<String> values = metricsOptions.getOtelLabelValues();
      for (int i = 0; i < Math.min(keys.size(), values.size()); i++) {
        String k = keys.get(i);
        String v = values.get(i);
        if (k != null && !k.isEmpty() && v != null) {
          builder.put(k, v);
        }
      }
    }
    // pool_index label is always added
    builder.put(GcpMetricsConstants.POOL_INDEX_LABEL, metricPoolIndex);
    otelCommonAttributes = builder.build();
  }

  private Attributes withResult(String result) {
    return Attributes.builder()
        .putAll(otelCommonAttributes)
        .put(GcpMetricsConstants.RESULT_LABEL, result)
        .build();
  }

  private Attributes withDirection(String dir) {
    return Attributes.builder()
        .putAll(otelCommonAttributes)
        .put(GcpMetricsConstants.DIRECTION_LABEL, dir)
        .build();
  }

  private void initOtelMetrics(Meter meter) {
    this.otelMeter = meter;

    meter
        .gaugeBuilder(metricPrefix + GcpMetricsConstants.METRIC_NUM_CHANNELS)
        .ofLongs()
        .setDescription("The number of channels currently in the pool.")
        .setUnit(GcpMetricsConstants.COUNT)
        .buildWithCallback(m -> m.record(reportNumChannels(), otelCommonAttributes));

    meter
        .gaugeBuilder(metricPrefix + GcpMetricsConstants.METRIC_MIN_CHANNELS)
        .ofLongs()
        .setDescription("The minimum number of channels in the pool.")
        .setUnit(GcpMetricsConstants.COUNT)
        .buildWithCallback(m -> m.record(reportMinChannels(), otelCommonAttributes));

    meter
        .gaugeBuilder(metricPrefix + GcpMetricsConstants.METRIC_MAX_CHANNELS)
        .ofLongs()
        .setDescription("The maximum number of channels in the pool.")
        .setUnit(GcpMetricsConstants.COUNT)
        .buildWithCallback(m -> m.record(reportMaxChannels(), otelCommonAttributes));

    meter
        .gaugeBuilder(metricPrefix + GcpMetricsConstants.METRIC_MAX_ALLOWED_CHANNELS)
        .ofLongs()
        .setDescription("The maximum number of channels allowed in the pool. (The pool max size)")
        .setUnit(GcpMetricsConstants.COUNT)
        .buildWithCallback(m -> m.record(reportMaxAllowedChannels(), otelCommonAttributes));

    meter
        .gaugeBuilder(metricPrefix + GcpMetricsConstants.METRIC_MIN_READY_CHANNELS)
        .ofLongs()
        .setDescription("The minimum number of channels simultaneously in the READY state.")
        .setUnit(GcpMetricsConstants.COUNT)
        .buildWithCallback(m -> m.record(reportMinReadyChannels(), otelCommonAttributes));

    meter
        .gaugeBuilder(metricPrefix + GcpMetricsConstants.METRIC_MAX_READY_CHANNELS)
        .ofLongs()
        .setDescription("The maximum number of channels simultaneously in the READY state.")
        .setUnit(GcpMetricsConstants.COUNT)
        .buildWithCallback(m -> m.record(reportMaxReadyChannels(), otelCommonAttributes));

    meter
        .gaugeBuilder(metricPrefix + GcpMetricsConstants.METRIC_NUM_CHANNEL_CONNECT)
        .ofLongs()
        .setDescription("The number of times when a channel reached the READY state.")
        .setUnit(GcpMetricsConstants.COUNT)
        .buildWithCallback(m -> m.record(reportNumChannelConnect(), otelCommonAttributes));

    meter
        .gaugeBuilder(metricPrefix + GcpMetricsConstants.METRIC_NUM_CHANNEL_DISCONNECT)
        .ofLongs()
        .setDescription("The number of disconnections (deviations from READY state)")
        .setUnit(GcpMetricsConstants.COUNT)
        .buildWithCallback(m -> m.record(reportNumChannelDisconnect(), otelCommonAttributes));

    meter
        .gaugeBuilder(metricPrefix + GcpMetricsConstants.METRIC_MIN_CHANNEL_READINESS_TIME)
        .ofLongs()
        .setDescription("The minimum time it took to transition a channel to READY (us).")
        .setUnit(GcpMetricsConstants.MICROSECOND)
        .buildWithCallback(m -> m.record(reportMinReadinessTime(), otelCommonAttributes));

    meter
        .gaugeBuilder(metricPrefix + GcpMetricsConstants.METRIC_AVG_CHANNEL_READINESS_TIME)
        .ofLongs()
        .setDescription("The average time it took to transition a channel to READY (us).")
        .setUnit(GcpMetricsConstants.MICROSECOND)
        .buildWithCallback(
            m -> {
              m.record(reportAvgReadinessTime(), otelCommonAttributes);
            });

    meter
        .gaugeBuilder(metricPrefix + GcpMetricsConstants.METRIC_MAX_CHANNEL_READINESS_TIME)
        .ofLongs()
        .setDescription("The maximum time it took to transition a channel to READY (us).")
        .setUnit(GcpMetricsConstants.MICROSECOND)
        .buildWithCallback(m -> m.record(reportMaxReadinessTime(), otelCommonAttributes));

    meter
        .gaugeBuilder(metricPrefix + GcpMetricsConstants.METRIC_MIN_ACTIVE_STREAMS)
        .ofLongs()
        .setDescription("The minimum number of active streams on any channel.")
        .setUnit(GcpMetricsConstants.COUNT)
        .buildWithCallback(m -> m.record(reportMinActiveStreams(), otelCommonAttributes));

    meter
        .gaugeBuilder(metricPrefix + GcpMetricsConstants.METRIC_MAX_ACTIVE_STREAMS)
        .ofLongs()
        .setDescription("The maximum number of active streams on any channel.")
        .setUnit(GcpMetricsConstants.COUNT)
        .buildWithCallback(m -> m.record(reportMaxActiveStreams(), otelCommonAttributes));

    meter
        .gaugeBuilder(metricPrefix + GcpMetricsConstants.METRIC_MIN_TOTAL_ACTIVE_STREAMS)
        .ofLongs()
        .setDescription("The minimum total number of active streams across all channels.")
        .setUnit(GcpMetricsConstants.COUNT)
        .buildWithCallback(m -> m.record(reportMinTotalActiveStreams(), otelCommonAttributes));

    meter
        .gaugeBuilder(metricPrefix + GcpMetricsConstants.METRIC_MAX_TOTAL_ACTIVE_STREAMS)
        .ofLongs()
        .setDescription("The maximum total number of active streams across all channels.")
        .setUnit(GcpMetricsConstants.COUNT)
        .buildWithCallback(m -> m.record(reportMaxTotalActiveStreams(), otelCommonAttributes));

    meter
        .gaugeBuilder(metricPrefix + GcpMetricsConstants.METRIC_MIN_AFFINITY)
        .ofLongs()
        .setDescription("The minimum affinity count on any channel.")
        .setUnit(GcpMetricsConstants.COUNT)
        .buildWithCallback(m -> m.record(reportMinAffinity(), otelCommonAttributes));

    meter
        .gaugeBuilder(metricPrefix + GcpMetricsConstants.METRIC_MAX_AFFINITY)
        .ofLongs()
        .setDescription("The maximum affinity count on any channel.")
        .setUnit(GcpMetricsConstants.COUNT)
        .buildWithCallback(m -> m.record(reportMaxAffinity(), otelCommonAttributes));

    meter
        .gaugeBuilder(metricPrefix + GcpMetricsConstants.METRIC_NUM_AFFINITY)
        .ofLongs()
        .setDescription("The total affinity count across all channels.")
        .setUnit(GcpMetricsConstants.COUNT)
        .buildWithCallback(m -> m.record(reportNumAffinity(), otelCommonAttributes));

    meter
        .gaugeBuilder(metricPrefix + GcpMetricsConstants.METRIC_NUM_CALLS_COMPLETED)
        .ofLongs()
        .setDescription("The number of calls completed across all channels.")
        .setUnit(GcpMetricsConstants.COUNT)
        .buildWithCallback(
            m -> {
              m.record(reportTotalOkCalls(), withResult(GcpMetricsConstants.RESULT_SUCCESS));
              m.record(reportTotalErrCalls(), withResult(GcpMetricsConstants.RESULT_ERROR));
            });

    meter
        .gaugeBuilder(metricPrefix + GcpMetricsConstants.METRIC_MIN_CALLS)
        .ofLongs()
        .setDescription("The minimum number of completed calls on any channel.")
        .setUnit(GcpMetricsConstants.COUNT)
        .buildWithCallback(
            m -> {
              m.record(reportMinOkCalls(), withResult(GcpMetricsConstants.RESULT_SUCCESS));
              m.record(reportMinErrCalls(), withResult(GcpMetricsConstants.RESULT_ERROR));
            });

    meter
        .gaugeBuilder(metricPrefix + GcpMetricsConstants.METRIC_MAX_CALLS)
        .ofLongs()
        .setDescription("The maximum number of completed calls on any channel.")
        .setUnit(GcpMetricsConstants.COUNT)
        .buildWithCallback(
            m -> {
              m.record(reportMaxOkCalls(), withResult(GcpMetricsConstants.RESULT_SUCCESS));
              m.record(reportMaxErrCalls(), withResult(GcpMetricsConstants.RESULT_ERROR));
            });

    meter
        .gaugeBuilder(metricPrefix + GcpMetricsConstants.METRIC_NUM_FALLBACKS)
        .ofLongs()
        .setDescription("The number of calls that had fallback to another channel.")
        .setUnit(GcpMetricsConstants.COUNT)
        .buildWithCallback(
            m -> {
              m.record(reportSucceededFallbacks(), withResult(GcpMetricsConstants.RESULT_SUCCESS));
              m.record(reportFailedFallbacks(), withResult(GcpMetricsConstants.RESULT_ERROR));
            });

    meter
        .gaugeBuilder(metricPrefix + GcpMetricsConstants.METRIC_NUM_UNRESPONSIVE_DETECTIONS)
        .ofLongs()
        .setDescription("The number of unresponsive connections detected.")
        .setUnit(GcpMetricsConstants.COUNT)
        .buildWithCallback(m -> m.record(reportUnresponsiveDetectionCount(), otelCommonAttributes));

    meter
        .gaugeBuilder(metricPrefix + GcpMetricsConstants.METRIC_MIN_UNRESPONSIVE_DETECTION_TIME)
        .ofLongs()
        .setDescription("Min time to detect an unresponsive connection (ms).")
        .setUnit(GcpMetricsConstants.MILLISECOND)
        .buildWithCallback(m -> m.record(reportMinUnresponsiveMs(), otelCommonAttributes));

    meter
        .gaugeBuilder(metricPrefix + GcpMetricsConstants.METRIC_MAX_UNRESPONSIVE_DETECTION_TIME)
        .ofLongs()
        .setDescription("Max time to detect an unresponsive connection (ms).")
        .setUnit(GcpMetricsConstants.MILLISECOND)
        .buildWithCallback(m -> m.record(reportMaxUnresponsiveMs(), otelCommonAttributes));

    meter
        .gaugeBuilder(metricPrefix + GcpMetricsConstants.METRIC_MIN_UNRESPONSIVE_DROPPED_CALLS)
        .ofLongs()
        .setDescription("Min calls dropped before unresponsive detection.")
        .setUnit(GcpMetricsConstants.COUNT)
        .buildWithCallback(m -> m.record(reportMinUnresponsiveDrops(), otelCommonAttributes));

    meter
        .gaugeBuilder(metricPrefix + GcpMetricsConstants.METRIC_MAX_UNRESPONSIVE_DROPPED_CALLS)
        .ofLongs()
        .setDescription("Max calls dropped before unresponsive detection.")
        .setUnit(GcpMetricsConstants.COUNT)
        .buildWithCallback(m -> m.record(reportMaxUnresponsiveDrops(), otelCommonAttributes));

    meter
        .gaugeBuilder(metricPrefix + GcpMetricsConstants.METRIC_CHANNEL_POOL_SCALING)
        .ofLongs()
        .setDescription("The number of channels channel pool scaled up or down.")
        .setUnit(GcpMetricsConstants.COUNT)
        .buildWithCallback(
            m -> {
              m.record(reportScaleUp(), withDirection(GcpMetricsConstants.DIRECTION_UP));
              m.record(reportScaleDown(), withDirection(GcpMetricsConstants.DIRECTION_DOWN));
            });

    meter
        .gaugeBuilder(metricPrefix + GcpMetricsConstants.METRIC_SCALE_UP_PRIME_FAILURES)
        .ofLongs()
        .setDescription(
            "The number of scaled-up channels rejected because priming failed or timed out.")
        .setUnit(GcpMetricsConstants.COUNT)
        .buildWithCallback(m -> m.record(reportScaleUpPrimeFailures(), otelCommonAttributes));
  }

  private void logGauge(String key, long value) {
    logger.fine(log("stat: %s = %d", key, value));
  }

  private void logCumulative(String key, long value) {
    logger.fine(
        log(
            () -> {
              Long prevValue = cumulativeMetricValues.put(key, value);
              long logValue = prevValue == null ? value : value - prevValue;
              return String.format("stat: %s = %d", key, logValue);
            }));
  }

  @VisibleForTesting
  void logMetrics() {
    logMetricsOptions();
    logChannelsStats();
    reportMinReadyChannels();
    reportMaxReadyChannels();
    reportMinChannels();
    reportMaxChannels();
    reportNumChannels();
    reportMaxAllowedChannels();
    reportScaleUp();
    reportScaleDown();
    reportScaleUpPrimeFailures();
    reportNumChannelDisconnect();
    reportNumChannelConnect();
    reportMinReadinessTime();
    reportAvgReadinessTime();
    reportMaxReadinessTime();
    reportMinActiveStreams();
    reportMaxActiveStreams();
    reportMinTotalActiveStreams();
    reportMaxTotalActiveStreams();
    reportMinAffinity();
    reportMaxAffinity();
    reportNumAffinity();
    reportMinOkCalls();
    reportMinErrCalls();
    reportMaxOkCalls();
    reportMaxErrCalls();
    reportTotalOkCalls();
    reportTotalErrCalls();
    reportSucceededFallbacks();
    reportFailedFallbacks();
    reportUnresponsiveDetectionCount();
    reportMinUnresponsiveMs();
    reportMaxUnresponsiveMs();
    reportMinUnresponsiveDrops();
    reportMaxUnresponsiveDrops();
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

  private <T> void createDerivedLongCumulativeTimeSeriesWithDirection(
      String name,
      String description,
      String unit,
      T obj,
      ToLongFunction<T> funcUp,
      ToLongFunction<T> funcDown) {
    final DerivedLongCumulative metric =
        metricRegistry.addDerivedLongCumulative(
            metricPrefix + name, createMetricOptions(description, labelKeysWithDirection, unit));

    metric.removeTimeSeries(labelValuesUp);
    metric.createTimeSeries(labelValuesUp, obj, funcUp);
    metric.removeTimeSeries(labelValuesDown);
    metric.createTimeSeries(labelValuesDown, obj, funcDown);
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

  private long reportNumChannels() {
    int value = getNumberOfChannels();
    logGauge(GcpMetricsConstants.METRIC_NUM_CHANNELS, value);
    return value;
  }

  private long reportMinChannels() {
    int value = minChannels.getAndSet(getNumberOfChannels());
    logGauge(GcpMetricsConstants.METRIC_MIN_CHANNELS, value);
    return value;
  }

  private long reportMaxChannels() {
    int value = maxChannels.getAndSet(getNumberOfChannels());
    logGauge(GcpMetricsConstants.METRIC_MAX_CHANNELS, value);
    return value;
  }

  private long reportMaxAllowedChannels() {
    logGauge(GcpMetricsConstants.METRIC_MAX_ALLOWED_CHANNELS, maxSize);
    return maxSize;
  }

  private long reportMinReadyChannels() {
    int value = minReadyChannels.getAndSet(readyChannels.get());
    logGauge(GcpMetricsConstants.METRIC_MIN_READY_CHANNELS, value);
    return value;
  }

  private long reportMaxReadyChannels() {
    int value = maxReadyChannels.getAndSet(readyChannels.get());
    logGauge(GcpMetricsConstants.METRIC_MAX_READY_CHANNELS, value);
    return value;
  }

  private long reportNumChannelConnect() {
    long value = numChannelConnect.get();
    logCumulative(GcpMetricsConstants.METRIC_NUM_CHANNEL_CONNECT, value);
    return value;
  }

  private long reportNumChannelDisconnect() {
    long value = numChannelDisconnect.get();
    logCumulative(GcpMetricsConstants.METRIC_NUM_CHANNEL_DISCONNECT, value);
    return value;
  }

  private long reportMinReadinessTime() {
    long value = minReadinessTime.getAndSet(0);
    logGauge(GcpMetricsConstants.METRIC_MIN_CHANNEL_READINESS_TIME, value);
    return value;
  }

  private long reportAvgReadinessTime() {
    long value = 0;
    long total = totalReadinessTime.getAndSet(0);
    long occ = readinessTimeOccurrences.getAndSet(0);
    if (occ != 0) {
      value = total / occ;
    }
    logGauge(GcpMetricsConstants.METRIC_AVG_CHANNEL_READINESS_TIME, value);
    return value;
  }

  private long reportMaxReadinessTime() {
    long value = maxReadinessTime.getAndSet(0);
    logGauge(GcpMetricsConstants.METRIC_MAX_CHANNEL_READINESS_TIME, value);
    return value;
  }

  private int reportMinActiveStreams() {
    int value =
        minActiveStreams.getAndSet(
            channelRefs.stream().mapToInt(ChannelRef::getActiveStreamsCount).min().orElse(0));
    logGauge(GcpMetricsConstants.METRIC_MIN_ACTIVE_STREAMS, value);
    return value;
  }

  private int reportMaxActiveStreams() {
    int value =
        maxActiveStreams.getAndSet(
            channelRefs.stream().mapToInt(ChannelRef::getActiveStreamsCount).max().orElse(0));
    logGauge(GcpMetricsConstants.METRIC_MAX_ACTIVE_STREAMS, value);
    return value;
  }

  private int reportMinTotalActiveStreams() {
    int value = minTotalActiveStreams.getAndSet(totalActiveStreams.get());
    logGauge(GcpMetricsConstants.METRIC_MIN_TOTAL_ACTIVE_STREAMS, value);
    return value;
  }

  private int reportMaxTotalActiveStreams() {
    int value = maxTotalActiveStreams.getAndSet(totalActiveStreams.get());
    logGauge(GcpMetricsConstants.METRIC_MAX_TOTAL_ACTIVE_STREAMS, value);
    return value;
  }

  private int reportMinAffinity() {
    int value =
        minAffinity.getAndSet(
            channelRefs.stream().mapToInt(ChannelRef::getAffinityCount).min().orElse(0));
    logGauge(GcpMetricsConstants.METRIC_MIN_AFFINITY, value);
    return value;
  }

  private int reportMaxAffinity() {
    int value =
        maxAffinity.getAndSet(
            channelRefs.stream().mapToInt(ChannelRef::getAffinityCount).max().orElse(0));
    logGauge(GcpMetricsConstants.METRIC_MAX_AFFINITY, value);
    return value;
  }

  private int reportNumAffinity() {
    int value = totalAffinityCount.get();
    logGauge(GcpMetricsConstants.METRIC_NUM_AFFINITY, value);
    return value;
  }

  private synchronized long reportMinOkCalls() {
    minOkReported = true;
    calcMinMaxOkCalls();
    logGauge(GcpMetricsConstants.METRIC_MIN_CALLS + "_ok", minOkCalls);
    return minOkCalls;
  }

  private synchronized long reportMaxOkCalls() {
    maxOkReported = true;
    calcMinMaxOkCalls();
    logGauge(GcpMetricsConstants.METRIC_MAX_CALLS + "_ok", maxOkCalls);
    return maxOkCalls;
  }

  private long reportTotalOkCalls() {
    long value = totalOkCalls.get();
    logCumulative(GcpMetricsConstants.METRIC_NUM_CALLS_COMPLETED + "_ok", value);
    return value;
  }

  private LongSummaryStatistics calcStatsAndLog(String logLabel, ToLongFunction<ChannelRef> func) {
    StringBuilder str = new StringBuilder(logLabel + ": [");
    final LongSummaryStatistics stats =
        channelRefs.stream()
            .mapToLong(
                ch -> {
                  long count = func.applyAsLong(ch);
                  if (str.charAt(str.length() - 1) != '[') {
                    str.append(", ");
                  }
                  str.append(count);
                  return count;
                })
            .summaryStatistics();

    str.append("]");
    logger.fine(log(str.toString()));
    return stats;
  }

  private void calcMinMaxOkCalls() {
    if (minOkReported && maxOkReported) {
      minOkReported = false;
      maxOkReported = false;
      return;
    }
    final LongSummaryStatistics stats = calcStatsAndLog("Ok calls", ChannelRef::getAndResetOkCalls);
    minOkCalls = stats.getMin();
    maxOkCalls = stats.getMax();
  }

  private synchronized long reportMinErrCalls() {
    minErrReported = true;
    calcMinMaxErrCalls();
    logGauge(GcpMetricsConstants.METRIC_MIN_CALLS + "_err", minErrCalls);
    return minErrCalls;
  }

  private synchronized long reportMaxErrCalls() {
    maxErrReported = true;
    calcMinMaxErrCalls();
    logGauge(GcpMetricsConstants.METRIC_MAX_CALLS + "_err", maxErrCalls);
    return maxErrCalls;
  }

  private long reportTotalErrCalls() {
    long value = totalErrCalls.get();
    logCumulative(GcpMetricsConstants.METRIC_NUM_CALLS_COMPLETED + "_err", value);
    return value;
  }

  private void calcMinMaxErrCalls() {
    if (minErrReported && maxErrReported) {
      minErrReported = false;
      maxErrReported = false;
      return;
    }
    final LongSummaryStatistics stats =
        calcStatsAndLog("Failed calls", ChannelRef::getAndResetErrCalls);
    minErrCalls = stats.getMin();
    maxErrCalls = stats.getMax();
  }

  private long reportSucceededFallbacks() {
    long value = fallbacksSucceeded.get();
    logCumulative(GcpMetricsConstants.METRIC_NUM_FALLBACKS + "_ok", value);
    return value;
  }

  private long reportFailedFallbacks() {
    long value = fallbacksFailed.get();
    logCumulative(GcpMetricsConstants.METRIC_NUM_FALLBACKS + "_fail", value);
    return value;
  }

  private long reportUnresponsiveDetectionCount() {
    long value = unresponsiveDetectionCount.get();
    logCumulative(GcpMetricsConstants.METRIC_NUM_UNRESPONSIVE_DETECTIONS, value);
    return value;
  }

  private long reportMinUnresponsiveMs() {
    long value = minUnresponsiveMs.getAndSet(0);
    logGauge(GcpMetricsConstants.METRIC_MIN_UNRESPONSIVE_DETECTION_TIME, value);
    return value;
  }

  private long reportMaxUnresponsiveMs() {
    long value = maxUnresponsiveMs.getAndSet(0);
    logGauge(GcpMetricsConstants.METRIC_MAX_UNRESPONSIVE_DETECTION_TIME, value);
    return value;
  }

  private long reportMinUnresponsiveDrops() {
    long value = minUnresponsiveDrops.getAndSet(0);
    logGauge(GcpMetricsConstants.METRIC_MIN_UNRESPONSIVE_DROPPED_CALLS, value);
    return value;
  }

  private long reportMaxUnresponsiveDrops() {
    long value = maxUnresponsiveDrops.getAndSet(0);
    logGauge(GcpMetricsConstants.METRIC_MAX_UNRESPONSIVE_DROPPED_CALLS, value);
    return value;
  }

  private long reportScaleUp() {
    long value = scaleUpCount.get();
    logCumulative(GcpMetricsConstants.METRIC_CHANNEL_POOL_SCALING + "_up", value);
    return value;
  }

  private long reportScaleDown() {
    long value = scaleDownCount.get();
    logCumulative(GcpMetricsConstants.METRIC_CHANNEL_POOL_SCALING + "_down", value);
    return value;
  }

  private long reportScaleUpPrimeFailures() {
    long value = scaleUpPrimeFailures.get();
    logCumulative(GcpMetricsConstants.METRIC_SCALE_UP_PRIME_FAILURES, value);
    return value;
  }

  private void incReadyChannels(boolean connected) {
    if (connected) {
      numChannelConnect.incrementAndGet();
    }
    final int newReady = readyChannels.incrementAndGet();
    maxReadyChannels.accumulateAndGet(newReady, Math::max);
  }

  private void decReadyChannels(boolean disconnected) {
    if (disconnected) {
      numChannelDisconnect.incrementAndGet();
    }
    final int newReady = readyChannels.decrementAndGet();
    minReadyChannels.accumulateAndGet(newReady, Math::min);
  }

  private void saveReadinessTime(long readinessNanos) {
    long readinessTimeUs = readinessNanos / 1000;
    minReadinessTime.compareAndSet(0, readinessTimeUs);
    minReadinessTime.accumulateAndGet(readinessTimeUs, Math::min);
    maxReadinessTime.accumulateAndGet(readinessTimeUs, Math::max);
    totalReadinessTime.addAndGet(readinessTimeUs);
    readinessTimeOccurrences.incrementAndGet();
  }

  private void recordUnresponsiveDetection(long nanos, long dropCount) {
    unresponsiveDetectionCount.incrementAndGet();
    final long ms = nanos / 1000000;
    minUnresponsiveMs.compareAndSet(0, ms);
    minUnresponsiveMs.accumulateAndGet(ms, Math::min);
    maxUnresponsiveMs.accumulateAndGet(ms, Math::max);
    minUnresponsiveDrops.compareAndSet(0, dropCount);
    minUnresponsiveDrops.accumulateAndGet(dropCount, Math::min);
    maxUnresponsiveDrops.accumulateAndGet(dropCount, Math::max);
  }

  @Override
  public void notifyWhenStateChanged(ConnectivityState source, Runnable callback) {
    if (getState(false).equals(source)) {
      synchronized (this) {
        stateChangeCallbacks.add(callback);
      }
      return;
    }

    try {
      stateNotificationExecutor.execute(callback);
    } catch (RejectedExecutionException e) {
      // Ignore exceptions on shutdown.
      logger.fine(log("State notification change task rejected: %s", e.getMessage()));
    }
  }

  /**
   * ChannelStateMonitor subscribes to channel's state changes and informs {@link GcpManagedChannel}
   * on any new state. This monitor allows to detect when a channel is not ready and temporarily
   * route requests via another ready channel if the option is enabled.
   */
  private class ChannelStateMonitor implements Runnable {
    private final ChannelRef channelRef;
    private final ManagedChannel channel;
    private volatile ConnectivityState currentState;
    private long connectingStartNanos;

    @GuardedBy("channelRef")
    private boolean readyAccounted;

    private ChannelStateMonitor(ManagedChannel channel, ChannelRef channelRef) {
      this.channelRef = channelRef;
      this.channel = channel;
      run();
    }

    public ConnectivityState getCurrentState() {
      return currentState;
    }

    private boolean accountReadyIfNeeded() {
      if (currentState == ConnectivityState.READY && !readyAccounted) {
        readyAccounted = true;
        return true;
      }
      return false;
    }

    private boolean unaccountReadyIfNeeded() {
      if (readyAccounted) {
        readyAccounted = false;
        return true;
      }
      return false;
    }

    @Override
    public void run() {
      if (channel == null) {
        return;
      }

      // Keep minSize channels always connected.
      boolean requestConnection =
          channelRefs.size() < minSize
              || channelRefs.stream()
                  .mapToInt(ChannelRef::getId)
                  .sorted()
                  .limit(minSize)
                  .anyMatch(id -> (id == channelRef.getId()));

      ConnectivityState newState = channel.getState(requestConnection);
      boolean isActive;
      boolean incrementReady = false;
      boolean decrementReady = false;
      long readinessNanos = 0;
      synchronized (channelRef) {
        isActive = channelRef.isActive() && channelRefs.contains(channelRef);
        if (logger.isLoggable(Level.FINER)) {
          logger.finer(
              log(
                  "Channel %d state change detected: %s -> %s",
                  channelRef.getId(), currentState, newState));
        }
        if (newState == ConnectivityState.READY && currentState != ConnectivityState.READY) {
          if (isActive && !readyAccounted) {
            readyAccounted = true;
            incrementReady = true;
            if (connectingStartNanos > 0) {
              readinessNanos = nanoClock.get() - connectingStartNanos;
            }
          }
          connectingStartNanos = 0;
        }
        if (newState != ConnectivityState.READY && readyAccounted) {
          readyAccounted = false;
          decrementReady = true;
        }
        if (newState == ConnectivityState.CONNECTING
            && currentState != ConnectivityState.CONNECTING) {
          connectingStartNanos = nanoClock.get();
        }
        currentState = newState;
      }

      if (incrementReady) {
        incReadyChannels(true);
        if (readinessNanos > 0) {
          saveReadinessTime(readinessNanos);
        }
      } else if (decrementReady) {
        decReadyChannels(true);
      }

      processChannelStateChange(channelRef.getId(), newState);
      if (isActive) {
        executeStateChangeCallbacks();
      }

      // Resubscribe.
      if (newState != ConnectivityState.SHUTDOWN) {
        channel.notifyWhenStateChanged(newState, this);
      }
    }
  }

  private synchronized void executeStateChangeCallbacks() {
    List<Runnable> callbacksToTrigger = stateChangeCallbacks;
    stateChangeCallbacks = new LinkedList<>();
    try {
      callbacksToTrigger.forEach(stateNotificationExecutor::execute);
    } catch (RejectedExecutionException e) {
      // Ignore exceptions on shutdown.
      logger.fine(log("State notification change task rejected: %s", e.getMessage()));
    }
  }

  @VisibleForTesting
  void processChannelStateChange(int channelId, ConnectivityState state) {
    if (!fallbackEnabled) {
      return;
    }
    ChannelRef channelRef = channelIdToChannelRef.get(channelId);
    if (channelRef == null || !channelRef.isActive()) {
      fallbackMap.remove(channelId);
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

  public int getMinSize() {
    return minSize;
  }

  public int getNumberOfChannels() {
    return channelRefs.size();
  }

  public int getStreamsLowWatermark() {
    return maxConcurrentStreamsLowWatermark;
  }

  public int getMinActiveStreams() {
    return channelRefs.stream()
        .filter(ChannelRef::isActive)
        .mapToInt(ChannelRef::getActiveStreamsCount)
        .min()
        .orElse(0);
  }

  public int getMaxActiveStreams() {
    return channelRefs.stream()
        .filter(ChannelRef::isActive)
        .mapToInt(ChannelRef::getActiveStreamsCount)
        .max()
        .orElse(0);
  }

  /**
   * Returns a {@link ChannelRef} from the pool for a binding call. If round-robin on bind is
   * enabled, uses {@link #getChannelRefRoundRobin()} otherwise {@link #getChannelRef(String)}
   *
   * @return {@link ChannelRef} channel to use for a call.
   */
  protected ChannelRef getChannelRefForBind() {
    ChannelRef channelRef;
    if (options.getChannelPoolOptions() != null
        && options.getChannelPoolOptions().isUseRoundRobinOnBind()) {
      channelRef = getChannelRefRoundRobin();
      if (logger.isLoggable(Level.FINEST)) {
        logger.finest(
            log("Channel %d picked for bind operation using round-robin.", channelRef.getId()));
      }
    } else {
      channelRef = getChannelRef(null);
      if (logger.isLoggable(Level.FINEST)) {
        logger.finest(log("Channel %d picked for bind operation.", channelRef.getId()));
      }
    }
    return channelRef;
  }

  /**
   * Returns a {@link ChannelRef} from the pool in round-robin manner. Creates a new channel in the
   * pool until the pool reaches its max size.
   *
   * @return {@link ChannelRef}
   */
  protected synchronized ChannelRef getChannelRefRoundRobin() {
    ChannelRef first = createFirstChannel();
    if (first != null) {
      return first;
    }
    if (!isDynamicScalingEnabled && channelRefs.size() < maxSize) {
      return createNewChannel();
    }
    Object[] snapshot = channelRefs.toArray();
    if (snapshot.length > 0) {
      for (int attempts = 0; attempts < snapshot.length; attempts++) {
        bindingIndex = (bindingIndex + 1) % snapshot.length;
        ChannelRef candidate = (ChannelRef) snapshot[bindingIndex];
        if (candidate.isActive()) {
          return candidate;
        }
      }
    }
    return pickFromCandidates(channelRefs);
  }

  /**
   * Pick a {@link ChannelRef} (and create a new one if necessary). If notReadyFallbackEnabled is
   * true in the {@link GcpResiliencyOptions} then instead of a channel in a non-READY state another
   * channel in the READY state and having picker load below the maximum allowed threshold will be
   * provided if available. Subsequent calls with the same affinity key will provide the same
   * fallback channel as long as the fallback channel is in the READY state.
   *
   * @param key affinity key. If it is specified, pick the ChannelRef bound with the affinity key.
   *     Otherwise pick using the lowest picker load: active streams plus active error penalty.
   */
  protected ChannelRef getChannelRef(@Nullable String key) {
    if (key == null || key.isEmpty()) {
      return pickLeastBusyChannel(/* forFallback= */ false);
    }
    ChannelRef mappedChannel;
    while (true) {
      mappedChannel = affinityKeyToChannelRef.get(key);
      if (mappedChannel == null) {
        break;
      }
      long lastUsed = nanoClock.get();
      affinityKeyLastUsed.merge(key, lastUsed, Long::max);
      if (affinityKeyToChannelRef.get(key) == mappedChannel) {
        break;
      }
      affinityKeyLastUsed.remove(key, lastUsed);
    }
    while (mappedChannel != null && !mappedChannel.isActive()) {
      mappedChannel =
          unbindInactiveMapping(key, mappedChannel) ? null : affinityKeyToChannelRef.get(key);
    }
    if (mappedChannel == null) {
      ChannelRef channelRef = pickLeastBusyChannel(/* forFallback= */ false);
      channelRef = bind(channelRef, Collections.singletonList(key));
      return channelRef;
    }
    if (!fallbackEnabled) {
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
      ChannelRef fallbackChannel = channelIdToChannelRef.get(channelId);
      if (fallbackChannel != null && fallbackChannel.isActive()) {
        if (logger.isLoggable(Level.FINEST)) {
          logger.finest(log("Using fallback channel: %d -> %d", mappedChannel.getId(), channelId));
        }
        fallbacksSucceeded.incrementAndGet();
        return fallbackChannel;
      }
      tempMap.remove(key, channelId);
    }
    // No temp mapping for this key or fallback channel is also broken.
    ChannelRef channelRef = pickLeastBusyChannel(/* forFallback= */ true);
    if (!fallbackMap.containsKey(channelRef.getId())
        && channelRef.getActiveStreamsCount() < maxConcurrentStreamsLowWatermark) {
      // Got a ready and not an overloaded channel.
      if (channelRef.getId() != mappedChannel.getId()) {
        if (logger.isLoggable(Level.FINEST)) {
          logger.finest(
              log("Setting fallback channel: %d -> %d", mappedChannel.getId(), channelRef.getId()));
        }
        fallbacksSucceeded.incrementAndGet();
        tempMap.put(key, channelRef.getId());
      }
      return channelRef;
    }
    if (logger.isLoggable(Level.FINEST)) {
      logger.finest(log("Failed to find fallback for channel %d", mappedChannel.getId()));
    }
    fallbacksFailed.incrementAndGet();
    if (channelId != null) {
      // Stick with previous mapping if fallback has failed.
      ChannelRef fallbackChannel = channelIdToChannelRef.get(channelId);
      if (fallbackChannel != null && fallbackChannel.isActive()) {
        return fallbackChannel;
      }
    }
    return mappedChannel;
  }

  /**
   * Picks a {@link ChannelRef} using a caller-owned reference instead of grpc-gcp's affinity map. A
   * reference remains sticky while its delegate is open, including while the channel drains, and
   * re-resolves after delegate shutdown or an explicit request to use a different channel.
   */
  protected ChannelRef getChannelRefByAffinityRef(ChannelAffinityRef affinityRef) {
    // Retry if another thread updates the caller-owned affinity ref while we are picking a channel.
    while (true) {
      int state = affinityRef.state.get();
      int channelId = ChannelAffinityRef.channelIdFromState(state);
      boolean useDifferentChannel =
          ChannelAffinityRef.useDifferentChannelOnNextCallFromState(state);
      ChannelRef channelRef =
          channelId == ChannelAffinityRef.NO_CHANNEL_ID
              ? null
              : channelIdToChannelRef.get(channelId);
      if (!useDifferentChannel && channelRef != null && !channelRef.getChannel().isShutdown()) {
        return channelRef;
      }

      ChannelRef selectedChannelRef =
          useDifferentChannel
              ? pickLeastBusyChannelDifferentFrom(channelRef)
              : pickLeastBusyChannel(/* forFallback= */ false);
      if (affinityRef.state.compareAndSet(
          state, ChannelAffinityRef.stateFromChannelId(selectedChannelRef.getId()))) {
        return selectedChannelRef;
      }
    }
  }

  private ChannelRef pickLeastBusyChannelDifferentFrom(@Nullable ChannelRef excludedChannelRef) {
    ChannelRef channelRef = pickLeastBusyChannel(/* forFallback= */ false);
    if (excludedChannelRef == null) {
      return channelRef;
    }
    if (channelRef != excludedChannelRef && channelRef.isActive()) {
      return channelRef;
    }
    ChannelRef leastBusyChannelRef = null;
    int leastBusyStreams = Integer.MAX_VALUE;
    long now = nanoClock.get();
    for (ChannelRef candidate : channelRefs) {
      if (candidate == excludedChannelRef || !candidate.isActive()) {
        continue;
      }
      int streams = candidate.getPickerLoad(now);
      if (leastBusyChannelRef == null || streams < leastBusyStreams) {
        leastBusyChannelRef = candidate;
        leastBusyStreams = streams;
      }
    }
    return leastBusyChannelRef == null ? channelRef : leastBusyChannelRef;
  }

  // Create a new channel and add it to channelRefs.
  @VisibleForTesting
  synchronized ChannelRef createNewChannel() {
    ChannelRef channelRef = new ChannelRef(delegateChannelBuilder.build());
    channelRefs.add(channelRef);
    channelIdToChannelRef.put(channelRef.getId(), channelRef);
    channelRef.activateAndAccountReadiness();
    logger.finer(log("Channel %d created.", channelRef.getId()));
    maxChannels.accumulateAndGet(getNumberOfChannels(), Math::max);
    return channelRef;
  }

  @GuardedBy("this")
  private ChannelRef addBuiltChannel(ManagedChannel channel) {
    ChannelRef channelRef = new ChannelRef(channel);
    channelRefs.add(channelRef);
    channelIdToChannelRef.put(channelRef.getId(), channelRef);
    channelRef.activateAndAccountReadiness();
    maxChannels.accumulateAndGet(getNumberOfChannels(), Math::max);
    return channelRef;
  }

  // Returns first newly created channel or null if there are already some channels in the pool.
  @Nullable
  private ChannelRef createFirstChannel() {
    if (!channelRefs.isEmpty()) {
      return null;
    }
    synchronized (this) {
      if (channelRefs.isEmpty() && !shuttingDown) {
        return createNewChannel();
      }
    }
    return null;
  }

  // Creates new channel if maxSize is not reached.
  // Returns new channel or null.
  @Nullable
  private ChannelRef tryCreateNewChannel() {
    if (channelRefs.size() >= maxSize) {
      return null;
    }
    synchronized (this) {
      if (channelRefs.size() < maxSize) {
        return createNewChannel();
      }
    }
    return null;
  }

  private void maybeSignalScaleUp(ChannelRef selectedChannel) {
    int activeChannels = channelRefs.size();
    if (!selectedChannel.isActive()
        || !isDynamicScalingEnabled
        || shuttingDown
        || activeChannels == 0
        || activeChannels >= maxSize) {
      return;
    }
    long now = nanoClock.get();
    int selectedLoad = selectedChannel.getPickerLoad(now);
    long totalLoad = (long) totalActiveStreams.get() + totalErrorPenaltyLoad.get();
    // A pool at the average cap has no spare capacity, including when penalty represents loss.
    if (selectedLoad <= maxRpcPerChannel && totalLoad < (long) activeChannels * maxRpcPerChannel) {
      return;
    }
    signalScaleUp();
  }

  private void signalScaleUp() {
    scaleUpSignalPending.set(true);
    if (!scaleUpWorkerRunning.compareAndSet(false, true)) {
      return;
    }
    try {
      SHARED_BACKGROUND_SERVICE.execute(this::runScaleUpWorker);
    } catch (RejectedExecutionException e) {
      scaleUpWorkerRunning.set(false);
      logger.fine(log("Scale-up task rejected: %s", e.getMessage()));
    }
  }

  private void runScaleUpWorker() {
    try {
      do {
        scaleUpSignalPending.set(false);
        try {
          dynamicUpscale();
        } catch (Throwable failure) {
          logger.log(Level.WARNING, log("Scale-up failed"), failure);
        }
      } while (scaleUpSignalPending.get() && !shuttingDown);
    } finally {
      scaleUpWorkerRunning.set(false);
      // Close the race where a signal arrives between the final test and clearing running.
      if (scaleUpSignalPending.get() && !shuttingDown) {
        signalScaleUp();
      }
    }
  }

  private void dynamicUpscale() {
    long now = nanoClock.get();
    for (ChannelRef channelRef : channelRefs) {
      channelRef.currentErrorPenalty(now);
    }
    final int channelsToBuild;
    synchronized (this) {
      // Channels still priming are capacity already on its way: they count toward the size cap
      // and the desired size, so overlapping scale-ups cannot build the same shortfall twice.
      // Abandoned primes keep their slot until their blocked prime() call returns.
      int priming = channelPrimeController == null ? 0 : channelPrimeController.primingCount();
      if (!isDynamicScalingEnabled || shuttingDown || channelRefs.size() + priming >= maxSize) {
        return;
      }
      if (lastScaleUpNanos != Long.MIN_VALUE
          && now - lastScaleUpNanos < scaleUpCooldown.toNanos()) {
        return;
      }
      List<ChannelRef> activeChannels =
          channelRefs.stream().filter(ChannelRef::isActive).collect(Collectors.toList());
      int active = activeChannels.size();
      if (active == 0) {
        return;
      }
      int desired = ceilDiv(pickerLoad(activeChannels, now), targetRpcPerChannel());
      int add = desired - active - priming;
      // Small pools may add two channels per event before percentage growth dominates.
      int percentCap = Math.max(2, ceilDiv((long) active * maxScaleUpPercent, 100));
      add = Math.min(add, percentCap);
      add = Math.min(add, maxSize - channelRefs.size() - priming);
      if (add <= 0) {
        return;
      }
      channelsToBuild = add;
      // Claim cooldown before delegate construction begins.
      lastScaleUpNanos = now;
    }

    List<ManagedChannel> builtChannels = new ArrayList<>(channelsToBuild);
    try {
      for (int i = 0; i < channelsToBuild; i++) {
        builtChannels.add(delegateChannelBuilder.build());
      }
    } catch (Throwable failure) {
      for (ManagedChannel channel : builtChannels) {
        try {
          channel.shutdownNow();
        } catch (Throwable shutdownFailure) {
          failure.addSuppressed(shutdownFailure);
        }
      }
      throw failure;
    }

    if (channelPrimeController != null) {
      builtChannels.forEach(channelPrimeController::startPrime);
      return;
    }

    int added = 0;
    List<ManagedChannel> surplus = new ArrayList<>();
    synchronized (this) {
      for (ManagedChannel channel : builtChannels) {
        if (shuttingDown || channelRefs.size() >= maxSize) {
          surplus.add(channel);
        } else {
          addBuiltChannel(channel);
          added++;
        }
      }
    }
    surplus.forEach(ManagedChannel::shutdownNow);
    scaleUpCount.addAndGet(added);
  }

  // This is pre-dynamic scaling functionality where we only scale up when the minimum number of
  // streams on any channel reached maxConcurrentStreamsLowWatermark.
  // If dynamic scaling is enabled we do not use this logic.
  private boolean shouldScaleUp(int minStreams) {
    if (channelRefs.size() >= maxSize) {
      // Pool is full.
      return false;
    }

    return !isDynamicScalingEnabled && minStreams >= maxConcurrentStreamsLowWatermark;
  }

  /**
   * Pick a {@link ChannelRef} (and create a new one if necessary). If notReadyFallbackEnabled is
   * true in the {@link GcpResiliencyOptions} then instead of a channel in a non-READY state another
   * channel in the READY state and having picker load below the maximum allowed threshold will be
   * provided if available.
   */
  private ChannelRef pickLeastBusyChannel(boolean forFallback) {
    // Retries cover post-snapshot deactivation, not draining density.
    for (int attempt = 0; attempt < 3; attempt++) {
      ChannelRef first = createFirstChannel();
      if (first != null) {
        return first;
      }
      ChannelRef picked =
          fallbackEnabled ? pickLeastBusyWithFallback(forFallback) : pickLeastBusyNoFallback();
      if (validatePickedChannel(picked)) {
        return picked;
      }
    }
    return leastLoadedActiveChannel(channelRefs);
  }

  /**
   * Non-fallback channel selection. Uses the configured {@link
   * GcpManagedChannelOptions.ChannelPickStrategy}.
   */
  private ChannelRef pickLeastBusyNoFallback() {
    long now = nanoClock.get();
    ChannelRef channelCandidate = pickFromCandidates(channelRefs, now);
    if (!isDynamicScalingEnabled && channelRefs.size() < maxSize) {
      // With power-of-two, streams distribute approximately (not exactly) evenly.
      // Use max streams for scale-up: if ANY channel hits the watermark, it's overloaded now
      // and we should add capacity before other channels follow. This preserves the original
      // per-channel watermark semantics (with LINEAR_SCAN, min == max so it didn't matter).
      // Global min would delay scale-up; sampled min would be noisy.
      int streams =
          channelPickStrategy == GcpManagedChannelOptions.ChannelPickStrategy.POWER_OF_TWO
              ? getMaxActiveStreams()
              : channelCandidate.getPickerLoad(now);
      if (streams >= maxConcurrentStreamsLowWatermark) {
        ChannelRef newChannel = tryCreateNewChannel();
        if (newChannel != null) {
          scaleUpCount.incrementAndGet();
          return newChannel;
        }
      }
    }
    return channelCandidate;
  }

  /**
   * Fallback-enabled channel selection. Always uses a full linear scan because the fallback logic
   * needs to filter channels by readiness state and max stream limits.
   */
  private ChannelRef pickLeastBusyWithFallback(boolean forFallback) {
    // Full scan to collect eligible ("ready") channels not in fallbackMap and under max streams.
    List<ChannelRef> readyCandidates = new ArrayList<>();
    ChannelRef overallCandidate = null;
    int overallMinStreams = Integer.MAX_VALUE;
    int readyMaxStreams = 0;
    long now = nanoClock.get();

    for (ChannelRef channelRef : channelRefs) {
      if (!channelRef.isActive()) {
        continue;
      }
      int cnt = channelRef.getPickerLoad(now);
      if (overallCandidate == null || cnt < overallMinStreams) {
        overallMinStreams = cnt;
        overallCandidate = channelRef;
      }
      if (!fallbackMap.containsKey(channelRef.getId()) && cnt < maxConcurrentStreamsLowWatermark) {
        readyCandidates.add(channelRef);
        if (cnt > readyMaxStreams) {
          readyMaxStreams = cnt;
        }
      }
    }

    if (overallCandidate == null) {
      return leastLoadedActiveChannel(channelRefs, now);
    }

    // For scale-up, use maxStreams among ready channels (consistent with non-fallback path).
    int scaleUpStreams = readyCandidates.isEmpty() ? Integer.MAX_VALUE : readyMaxStreams;
    if (shouldScaleUp(scaleUpStreams)) {
      ChannelRef newChannel = tryCreateNewChannel();
      if (newChannel != null) {
        scaleUpCount.incrementAndGet();
        if (!forFallback && readyCandidates.isEmpty()) {
          if (logger.isLoggable(Level.FINEST)) {
            logger.finest(log("Fallback to newly created channel %d", newChannel.getId()));
          }
          fallbacksSucceeded.incrementAndGet();
        }
        return newChannel;
      }
    }

    if (!readyCandidates.isEmpty()) {
      // Apply power-of-two among eligible channels to avoid thundering herd.
      ChannelRef readyCandidate = pickFromCandidates(readyCandidates, now);
      if (!forFallback && readyCandidate.getId() != overallCandidate.getId()) {
        if (logger.isLoggable(Level.FINEST)) {
          logger.finest(
              log(
                  "Picking fallback channel: %d -> %d",
                  overallCandidate.getId(), readyCandidate.getId()));
        }
        fallbacksSucceeded.incrementAndGet();
      }
      return readyCandidate;
    }

    if (!forFallback) {
      if (logger.isLoggable(Level.FINEST)) {
        logger.finest(log("Failed to find fallback for channel %d", overallCandidate.getId()));
      }
      fallbacksFailed.incrementAndGet();
    }
    return overallCandidate;
  }

  /**
   * Picks a channel from the given candidate list using the configured strategy.
   *
   * <p>For {@code POWER_OF_TWO}: samples twice with replacement and picks the less busy sample. The
   * first sample wins ties. Draining or inactive samples are retried up to twice the candidate
   * count before a full active-channel scan.
   *
   * <p>For {@code LINEAR_SCAN}: deterministic scan picking the first least-busy active channel.
   */
  @VisibleForTesting
  ChannelRef pickFromCandidates(List<ChannelRef> candidates) {
    return pickFromCandidates(candidates, nanoClock.get());
  }

  private ChannelRef pickFromCandidates(List<ChannelRef> candidates, long now) {
    Object[] snapshot = candidates.toArray();
    int size = snapshot.length;
    if (channelPickStrategy == GcpManagedChannelOptions.ChannelPickStrategy.POWER_OF_TWO) {
      for (int attempt = 0; attempt < 2 * size; attempt++) {
        ChannelRef first = (ChannelRef) snapshot[candidateIndexPicker.applyAsInt(size)];
        ChannelRef second = (ChannelRef) snapshot[candidateIndexPicker.applyAsInt(size)];
        if (!first.isActive() || !second.isActive()) {
          continue;
        }
        ChannelRef picked = pickLessBusy(first, second, now);
        if (picked.isActive()) {
          return picked;
        }
      }
    }
    return leastLoadedActiveChannel(candidates, now);
  }

  private ChannelRef leastLoadedActiveChannel(List<ChannelRef> candidates) {
    return leastLoadedActiveChannel(candidates, nanoClock.get());
  }

  private ChannelRef leastLoadedActiveChannel(List<ChannelRef> candidates, long now) {
    ChannelRef best = null;
    int bestLoad = Integer.MAX_VALUE;
    for (ChannelRef candidate : candidates) {
      if (!candidate.isActive()) {
        continue;
      }
      int candidateLoad = candidate.getPickerLoad(now);
      if (best == null || candidateLoad < bestLoad) {
        best = candidate;
        bestLoad = candidateLoad;
      }
    }
    if (best != null) {
      return best;
    }
    throw Status.UNAVAILABLE.withDescription("No available channels").asRuntimeException();
  }

  @VisibleForTesting
  ChannelRef pickLessBusy(ChannelRef first, ChannelRef second, long now) {
    return first.getPickerLoad(now) <= second.getPickerLoad(now) ? first : second;
  }

  @Override
  public String authority() {
    if (!channelRefs.isEmpty()) {
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
   *
   * <p>A returned simple call reserves one unit of pool load immediately. If never started, callers
   * must invoke {@link ClientCall#cancel(String, Throwable)} to release that reservation.
   */
  @Override
  public <ReqT, RespT> ClientCall<ReqT, RespT> newCall(
      MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions) {
    ChannelAffinityRef channelAffinityRef = callOptions.getOption(CHANNEL_AFFINITY_REF_KEY);
    if (channelAffinityRef != null) {
      return new GcpClientCall.SimpleGcpClientCall<>(
          this, getChannelRefByAffinityRef(channelAffinityRef), methodDescriptor, callOptions);
    }

    if (callOptions.getOption(DISABLE_AFFINITY_KEY)
        || DISABLE_AFFINITY_CTX_KEY.get(Context.current())) {
      if (logger.isLoggable(Level.FINEST)) {
        logger.finest(log("Channel affinity is disabled via context or call options."));
      }
      return new GcpClientCall.SimpleGcpClientCall<>(
          this, getChannelRef(null), methodDescriptor, callOptions);
    }

    AffinityConfig affinity = methodToAffinity.get(methodDescriptor.getFullMethodName());
    String key = keyFromOptsCtx(callOptions);
    if (affinity != null && key == null) {
      return new GcpClientCall<>(this, methodDescriptor, callOptions, affinity);
    }

    return new GcpClientCall.SimpleGcpClientCall<>(
        this, getChannelRef(key), methodDescriptor, callOptions);
  }

  @Nullable
  private String keyFromOptsCtx(CallOptions callOptions) {
    String key = callOptions.getOption(AFFINITY_KEY);
    if (key != null) {
      if (logger.isLoggable(Level.FINEST)) {
        logger.finest(log("Affinity key \"%s\" set manually via call options.", key));
      }
      return key;
    }

    key = AFFINITY_CTX_KEY.get(Context.current());
    if (key != null && logger.isLoggable(Level.FINEST)) {
      logger.finest(log("Affinity key \"%s\" set manually via context.", key));
    }
    return key;
  }

  private synchronized List<GcpChannelPrimeController.PendingPrime> cancelBackgroundTasks() {
    shuttingDown = true;
    scaleUpSignalPending.set(false);
    if (cleanupTask != null) {
      cleanupTask.cancel(false);
      cleanupTask = null;
    }
    if (scaleDownTask != null) {
      scaleDownTask.cancel(false);
      scaleDownTask = null;
    }
    if (logMetricsTask != null) {
      logMetricsTask.cancel(false);
      logMetricsTask = null;
    }
    drainTasks.values().forEach(task -> task.cancel(false));
    drainTasks.clear();
    return channelPrimeController == null
        ? Collections.emptyList()
        : channelPrimeController.detachAll();
  }

  @Override
  public ManagedChannel shutdownNow() {
    logger.finer(log("Shutdown now started."));
    List<GcpChannelPrimeController.PendingPrime> primesToCancel = cancelBackgroundTasks();
    if (channelPrimeController != null) {
      channelPrimeController.cancel(primesToCancel, true);
    }
    List<ChannelRef> activeSnapshot = new ArrayList<>(channelRefs);
    List<ChannelRef> removedSnapshot = new ArrayList<>(removedChannelRefs);
    for (ChannelRef channelRef : activeSnapshot) {
      if (!channelRef.getChannel().isTerminated()) {
        channelRef.getChannel().shutdownNow();
      }
    }
    for (ChannelRef channelRef : removedSnapshot) {
      if (!channelRef.getChannel().isTerminated()) {
        channelRef.getChannel().shutdownNow();
      }
    }
    if (!stateNotificationExecutor.isTerminated()) {
      stateNotificationExecutor.shutdownNow();
    }
    return this;
  }

  @Override
  public ManagedChannel shutdown() {
    logger.finer(log("Shutdown started."));
    List<GcpChannelPrimeController.PendingPrime> primesToCancel = cancelBackgroundTasks();
    if (channelPrimeController != null) {
      channelPrimeController.cancel(primesToCancel, false);
    }
    List<ChannelRef> activeSnapshot = new ArrayList<>(channelRefs);
    List<ChannelRef> removedSnapshot = new ArrayList<>(removedChannelRefs);
    for (ChannelRef channelRef : activeSnapshot) {
      channelRef.getChannel().shutdown();
    }
    for (ChannelRef channelRef : removedSnapshot) {
      channelRef.getChannel().shutdown();
    }
    stateNotificationExecutor.shutdown();
    return this;
  }

  @Override
  public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
    long endTimeNanos = System.nanoTime() + unit.toNanos(timeout);
    List<ChannelRef> allChannelRefs = new ArrayList<>(channelRefs);
    allChannelRefs.addAll(removedChannelRefs);
    for (ChannelRef channelRef : allChannelRefs) {
      if (channelRef.getChannel().isTerminated()) {
        continue;
      }
      long awaitTimeNanos = endTimeNanos - System.nanoTime();
      if (awaitTimeNanos <= 0) {
        break;
      }
      channelRef.getChannel().awaitTermination(awaitTimeNanos, NANOSECONDS);
    }
    long awaitTimeNanos = endTimeNanos - System.nanoTime();
    awaitTimeNanos = endTimeNanos - System.nanoTime();
    if (awaitTimeNanos > 0) {
      // noinspection ResultOfMethodCallIgnored
      stateNotificationExecutor.awaitTermination(awaitTimeNanos, NANOSECONDS);
    }
    return isTerminated();
  }

  @Override
  public boolean isShutdown() {
    List<ChannelRef> allChannelRefs = new ArrayList<>(channelRefs);
    allChannelRefs.addAll(removedChannelRefs);
    for (ChannelRef channelRef : allChannelRefs) {
      if (!channelRef.getChannel().isShutdown()) {
        return false;
      }
    }
    return cleanupTask == null
        && scaleDownTask == null
        && logMetricsTask == null
        && stateNotificationExecutor.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    List<ChannelRef> allChannelRefs = new ArrayList<>(channelRefs);
    allChannelRefs.addAll(removedChannelRefs);
    for (ChannelRef channelRef : allChannelRefs) {
      if (!channelRef.getChannel().isTerminated()) {
        return false;
      }
    }
    return cleanupTask == null
        && scaleDownTask == null
        && logMetricsTask == null
        && stateNotificationExecutor.isTerminated();
  }

  /** Get the current connectivity state of the channel pool. */
  @Override
  public ConnectivityState getState(boolean requestConnection) {
    if (requestConnection && getNumberOfChannels() == 0) {
      createFirstChannel();
    }
    int ready = 0;
    int idle = 0;
    int connecting = 0;
    int transientFailure = 0;
    int shutdown = 0;
    for (ChannelRef channelRef : channelRefs) {
      ConnectivityState cur = channelRef.getChannel().getState(requestConnection);
      switch (cur) {
        case READY:
          ready++;
          break;
        case SHUTDOWN:
          shutdown++;
          break;
        case TRANSIENT_FAILURE:
          transientFailure++;
          break;
        case CONNECTING:
          connecting++;
          break;
        case IDLE:
          idle++;
          break;
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
  protected synchronized ChannelRef bind(ChannelRef channelRef, List<String> affinityKeys) {
    if (channelRef == null || affinityKeys == null) {
      return channelRef;
    }
    if (!channelRef.isActive()) {
      channelRef = pickLeastBusyChannel(/* forFallback= */ false);
      // Deactivation also holds the pool monitor, so this pick stays active through binding.
    }
    if (logger.isLoggable(Level.FINEST)) {
      logger.finest(
          log(
              "Binding %d key(s) to channel %d: [%s]",
              affinityKeys.size(), channelRef.getId(), String.join(", ", affinityKeys)));
    }
    for (String affinityKey : affinityKeys) {
      while (affinityKeyToChannelRef.putIfAbsent(affinityKey, channelRef) != null) {
        unbind(Collections.singletonList(affinityKey));
      }
      affinityKeyLastUsed.merge(affinityKey, nanoClock.get(), Long::max);
      channelRef.affinityCountIncr();
    }
    return channelRef;
  }

  private synchronized boolean unbindInactiveMapping(String affinityKey, ChannelRef mappedChannel) {
    Runnable hook = inactiveMappingRemovalHookForTest;
    if (hook != null) {
      inactiveMappingRemovalHookForTest = null;
      hook.run();
    }
    if (affinityKeyToChannelRef.remove(affinityKey, mappedChannel)) {
      affinityKeyLastUsed.remove(affinityKey);
      mappedChannel.affinityCountDecr();
      return true;
    }
    return false;
  }

  /** Unbind channel with affinity key. */
  protected synchronized void unbind(List<String> affinityKeys) {
    if (affinityKeys == null) {
      return;
    }
    for (String affinityKey : affinityKeys) {
      ChannelRef channelRef = affinityKeyToChannelRef.remove(affinityKey);
      affinityKeyLastUsed.remove(affinityKey);
      if (channelRef != null) {
        channelRef.affinityCountDecr();
        if (logger.isLoggable(Level.FINEST)) {
          logger.finest(log("Unbinding key %s from channel %d.", affinityKey, channelRef.getId()));
        }
      } else {
        if (logger.isLoggable(Level.FINEST)) {
          logger.finest(log("Unbinding key %s but it wasn't bound.", affinityKey));
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
          if (!list.isEmpty() && list.get(0) instanceof MessageOrBuilder) {
            for (Object item : list) {
              keys.addAll(
                  getKeysFromMessage((MessageOrBuilder) item, name.substring(currentLength + 1)));
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
   * @param message the &lt;ReqT&gt; or &lt;RespT&gt; prototype message.
   * @param isReq indicates if the message is a request message.
   */
  @Nullable
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
    private final long createdNanos = nanoClock.get();
    private volatile long lastActivityNanos = createdNanos;
    private long lastResponseNanos = createdNanos;

    private volatile int errorPenaltyLoad;
    private volatile long errorPenaltyExpiresAtNanos;

    private final AtomicInteger deadlineExceededCount = new AtomicInteger();
    private final AtomicLong okCalls = new AtomicLong();
    private final AtomicLong errCalls = new AtomicLong();
    private final ChannelStateMonitor channelStateMonitor;
    private volatile boolean active = true;

    protected ChannelRef(ManagedChannel channel) {
      this(channel, 0, 0);
    }

    protected ChannelRef(ManagedChannel channel, int affinityCount, int activeStreamsCount) {
      this.delegate = channel;
      this.channelId = nextChannelId.getAndIncrement();
      this.affinityCount = new AtomicInteger(affinityCount);
      this.activeStreamsCount = new AtomicInteger(activeStreamsCount);
      channelStateMonitor = new ChannelStateMonitor(channel, this);
    }

    protected long getCreatedNanos() {
      return createdNanos;
    }

    protected long getLastActivityNanos() {
      return lastActivityNanos;
    }

    protected ConnectivityState getState() {
      return channelStateMonitor.getCurrentState();
    }

    protected ManagedChannel getChannel() {
      return delegate;
    }

    protected int getId() {
      return channelId;
    }

    protected boolean isActive() {
      return active;
    }

    private void activateAndAccountReadiness() {
      boolean incrementReady;
      synchronized (this) {
        active = true;
        incrementReady = channelStateMonitor.accountReadyIfNeeded();
      }
      if (incrementReady) {
        incReadyChannels(false);
      }
    }

    private void deactivateAndAccountReadiness() {
      boolean decrementReady;
      synchronized (this) {
        decrementReady = channelStateMonitor.unaccountReadyIfNeeded();
        active = false;
      }
      if (decrementReady) {
        decReadyChannels(false);
      }
    }

    @VisibleForTesting
    void deactivateForTest() {
      deactivateAndAccountReadiness();
    }

    @VisibleForTesting
    void setActiveStreamsForTest(int streams) {
      int previous = activeStreamsCount.getAndSet(streams);
      totalActiveStreams.addAndGet(streams - previous);
    }

    protected void affinityCountIncr() {
      int count = affinityCount.incrementAndGet();
      maxAffinity.accumulateAndGet(count, Math::max);
      totalAffinityCount.incrementAndGet();
    }

    protected void affinityCountDecr() {
      int count = affinityCount.decrementAndGet();
      minAffinity.accumulateAndGet(count, Math::min);
      totalAffinityCount.decrementAndGet();
    }

    protected void resetAffinityCount() {
      affinityCount.set(0);
    }

    protected void activeStreamsCountIncr() {
      lastActivityNanos = nanoClock.get();
      int actStreams = activeStreamsCount.incrementAndGet();
      maxActiveStreams.accumulateAndGet(actStreams, Math::max);
      int totalActStreams = totalActiveStreams.incrementAndGet();
      maxTotalActiveStreams.accumulateAndGet(totalActStreams, Math::max);
      maybeSignalScaleUp(this);
    }

    protected void activeStreamsCountDecr(long startNanos, Status status, boolean fromClientSide) {
      lastActivityNanos = nanoClock.get();
      int actStreams = activeStreamsCount.decrementAndGet();
      minActiveStreams.accumulateAndGet(actStreams, Math::min);
      int totalActStreams = totalActiveStreams.decrementAndGet();
      minTotalActiveStreams.accumulateAndGet(totalActStreams, Math::min);
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
      applyErrorPenalty(status);
      if (actStreams == 0 && !isActive()) {
        scheduleDrain(this);
      }
    }

    protected void messageReceived() {
      lastResponseNanos = nanoClock.get();
      deadlineExceededCount.set(0);
    }

    protected int getAffinityCount() {
      return affinityCount.get();
    }

    protected int getActiveStreamsCount() {
      return activeStreamsCount.get();
    }

    protected int getPickerLoad() {
      return (int)
          Math.min(Integer.MAX_VALUE, (long) getActiveStreamsCount() + currentErrorPenalty());
    }

    @VisibleForTesting
    int currentErrorPenalty() {
      int penalty = errorPenaltyLoad;
      if (penalty == 0) {
        return 0;
      }
      return currentErrorPenalty(nanoClock.get());
    }

    private int currentErrorPenalty(long now) {
      int penalty = errorPenaltyLoad;
      long expiresAtNanos = errorPenaltyExpiresAtNanos;
      if (penalty == 0 || expiresAtNanos == 0) {
        return 0;
      }
      if (now - expiresAtNanos < 0) {
        return decayedErrorPenalty(penalty, now, expiresAtNanos);
      }
      int expiredPenalty;
      synchronized (this) {
        penalty = errorPenaltyLoad;
        expiresAtNanos = errorPenaltyExpiresAtNanos;
        if (penalty == 0 || expiresAtNanos == 0) {
          return 0;
        }
        if (now - expiresAtNanos < 0) {
          return decayedErrorPenalty(penalty, now, expiresAtNanos);
        }
        errorPenaltyLoad = 0;
        errorPenaltyExpiresAtNanos = 0;
        expiredPenalty = penalty;
      }
      totalErrorPenaltyLoad.addAndGet(-expiredPenalty);
      return 0;
    }

    private int getPickerLoad(long now) {
      int penalty = errorPenaltyLoad;
      long expiresAtNanos = errorPenaltyExpiresAtNanos;
      if (penalty != 0) {
        penalty = decayedErrorPenalty(penalty, now, expiresAtNanos);
      }
      return (int) Math.min(Integer.MAX_VALUE, (long) getActiveStreamsCount() + penalty);
    }

    private int decayedErrorPenalty(int penalty, long now, long expiresAtNanos) {
      if (expiresAtNanos == 0) {
        return 0;
      }
      long remainingNanos = expiresAtNanos - now;
      if (remainingNanos <= 0) {
        return 0;
      }
      // Picker steering decays smoothly. Aggregate accounting deliberately retains the full
      // contribution until expiry or clear, making scale-up load a conservative upper bound while
      // preserving one atomic net delta per aggregate transition.
      return ceilMultiplyDivide(
          penalty, Math.min(remainingNanos, errorPenaltyDurationNanos), errorPenaltyDurationNanos);
    }

    private void applyErrorPenalty(Status status) {
      if (!isDynamicScalingEnabled
          || !active
          || errorPenaltyStep == 0
          || (status.getCode() != Code.UNAVAILABLE
              && status.getCode() != Code.RESOURCE_EXHAUSTED)) {
        return;
      }
      long now = nanoClock.get();
      long addedPenalty;
      synchronized (this) {
        if (!active) {
          return;
        }
        int previousContribution = errorPenaltyLoad;
        long previousExpiry = errorPenaltyExpiresAtNanos;
        int current =
            previousContribution != 0 && previousExpiry != 0 && now - previousExpiry < 0
                ? previousContribution
                : 0;
        int next = (int) Math.min(maxRpcPerChannel, (long) current + errorPenaltyStep);
        long nextExpiry = now + errorPenaltyDurationNanos;
        // Zero is reserved as the cleared expiry sentinel.
        errorPenaltyExpiresAtNanos = nextExpiry == 0 ? 1 : nextExpiry;
        errorPenaltyLoad = next;
        addedPenalty = (long) next - previousContribution;
      }
      if (addedPenalty != 0) {
        totalErrorPenaltyLoad.addAndGet(addedPenalty);
      }
      if (addedPenalty > 0) {
        maybeSignalScaleUp(this);
      }
    }

    private void clearErrorPenalty() {
      int clearedPenalty;
      synchronized (this) {
        clearedPenalty = errorPenaltyLoad;
        if (clearedPenalty == 0) {
          return;
        }
        errorPenaltyLoad = 0;
        errorPenaltyExpiresAtNanos = 0;
      }
      totalErrorPenaltyLoad.addAndGet(-clearedPenalty);
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
            && msSinceLastResponse() >= unresponsiveMs) {
          maybeReconnectUnresponsive();
        }
        return;
      }
      if (!fromClientSide) {
        // If not a deadline exceeded and not coming from the client side then reset time and count.
        lastResponseNanos = nanoClock.get();
        deadlineExceededCount.set(0);
      }
    }

    private long msSinceLastResponse() {
      return (nanoClock.get() - lastResponseNanos) / 1000000;
    }

    private synchronized void maybeReconnectUnresponsive() {
      final long msSinceLastResponse = msSinceLastResponse();
      if (deadlineExceededCount.get() >= unresponsiveDropCount
          && msSinceLastResponse >= unresponsiveMs) {
        recordUnresponsiveDetection(
            nanoClock.get() - lastResponseNanos, deadlineExceededCount.get());
        logger.finer(
            log(
                "Channel %d connection is unresponsive for %d ms and %d deadline exceeded calls. "
                    + "Forcing channel to idle state.",
                channelId, msSinceLastResponse, deadlineExceededCount.get()));
        delegate.enterIdle();
        lastResponseNanos = nanoClock.get();
        deadlineExceededCount.set(0);
      }
    }
  }
}
