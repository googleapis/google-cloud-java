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

import com.google.api.core.InternalApi;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.google.spanner.v1.BeginTransactionRequest;
import com.google.spanner.v1.CacheUpdate;
import com.google.spanner.v1.CommitRequest;
import com.google.spanner.v1.DirectedReadOptions;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.Mutation;
import com.google.spanner.v1.ReadRequest;
import com.google.spanner.v1.RoutingHint;
import com.google.spanner.v1.TransactionOptions;
import com.google.spanner.v1.TransactionSelector;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Predicate;
import javax.annotation.Nullable;

/**
 * Finds a server for a request using location-aware routing metadata.
 *
 * <p>This component is per-database and maintains both recipe and range caches.
 */
@InternalApi
public final class ChannelFinder {
  private static final Predicate<String> NO_EXCLUDED_ENDPOINTS = address -> false;
  private static final int CACHE_UPDATE_DRAIN_BATCH_SIZE = 64;
  private static final int MAX_CACHE_UPDATE_THREADS =
      Math.max(2, Runtime.getRuntime().availableProcessors());
  private static final ExecutorService CACHE_UPDATE_POOL = createCacheUpdatePool();

  private final Object updateLock = new Object();
  private final AtomicLong databaseId = new AtomicLong();
  private final KeyRecipeCache recipeCache = new KeyRecipeCache();
  private final KeyRangeCache rangeCache;
  private final ConcurrentLinkedQueue<PendingCacheUpdate> pendingUpdates =
      new ConcurrentLinkedQueue<>();
  private final AtomicBoolean drainScheduled = new AtomicBoolean();
  private volatile java.util.concurrent.CountDownLatch drainingLatch =
      new java.util.concurrent.CountDownLatch(0);
  @Nullable private final EndpointLifecycleManager lifecycleManager;
  @Nullable private final String finderKey;

  public ChannelFinder(ChannelEndpointCache endpointCache) {
    this(endpointCache, null, null);
  }

  public ChannelFinder(
      ChannelEndpointCache endpointCache, @Nullable EndpointLifecycleManager lifecycleManager) {
    this(endpointCache, lifecycleManager, null);
  }

  ChannelFinder(
      ChannelEndpointCache endpointCache,
      @Nullable EndpointLifecycleManager lifecycleManager,
      @Nullable String finderKey) {
    this.rangeCache = new KeyRangeCache(Objects.requireNonNull(endpointCache), lifecycleManager);
    this.lifecycleManager = lifecycleManager;
    this.finderKey = finderKey;
  }

  void useDeterministicRandom() {
    rangeCache.useDeterministicRandom();
  }

  private static ExecutorService createCacheUpdatePool() {
    ThreadPoolExecutor executor =
        new ThreadPoolExecutor(
            MAX_CACHE_UPDATE_THREADS,
            MAX_CACHE_UPDATE_THREADS,
            30L,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(),
            new ThreadFactoryBuilder()
                .setDaemon(true)
                .setNameFormat("spanner-cache-update-%d")
                .build());
    executor.allowCoreThreadTimeOut(true);
    return executor;
  }

  private static final class PendingCacheUpdate {
    private final CacheUpdate update;

    private PendingCacheUpdate(CacheUpdate update) {
      this.update = update;
    }
  }

  private boolean isMaterialUpdate(CacheUpdate update) {
    return update.getGroupCount() > 0
        || update.getRangeCount() > 0
        || (update.hasKeyRecipes() && update.getKeyRecipes().getRecipeCount() > 0);
  }

  private boolean shouldProcessUpdate(CacheUpdate update) {
    if (isMaterialUpdate(update)) {
      return true;
    }
    long updateDatabaseId = update.getDatabaseId();
    return updateDatabaseId != 0 && databaseId.get() != updateDatabaseId;
  }

  public void update(CacheUpdate update) {
    Set<String> currentAddresses;
    synchronized (updateLock) {
      applyUpdateLocked(update);
      currentAddresses = snapshotActiveAddressesLocked();
    }
    publishLifecycleUpdate(currentAddresses);
  }

  public void updateAsync(CacheUpdate update) {
    if (!shouldProcessUpdate(update)) {
      return;
    }
    pendingUpdates.add(new PendingCacheUpdate(update));
    if (drainScheduled.compareAndSet(false, true)) {
      java.util.concurrent.CountDownLatch latch = new java.util.concurrent.CountDownLatch(1);
      drainingLatch = latch;
      CACHE_UPDATE_POOL.execute(
          () -> {
            try {
              drainPendingUpdate();
            } finally {
              latch.countDown();
            }
          });
    }
  }

  private void drainPendingUpdate() {
    List<PendingCacheUpdate> batch = new ArrayList<>(CACHE_UPDATE_DRAIN_BATCH_SIZE);
    while (true) {
      drainBatch(batch);
      if (!batch.isEmpty()) {
        applyBatch(batch);
        batch.clear();
      }
      drainScheduled.set(false);
      if (pendingUpdates.isEmpty() || !drainScheduled.compareAndSet(false, true)) {
        return;
      }
    }
  }

  private void drainBatch(List<PendingCacheUpdate> batch) {
    PendingCacheUpdate toApply;
    while (batch.size() < CACHE_UPDATE_DRAIN_BATCH_SIZE
        && (toApply = pendingUpdates.poll()) != null) {
      batch.add(toApply);
    }
  }

  private void applyBatch(List<PendingCacheUpdate> batch) {
    Set<String> currentAddresses;
    synchronized (updateLock) {
      for (PendingCacheUpdate pendingUpdate : batch) {
        applyUpdateLocked(pendingUpdate.update);
      }
      currentAddresses = snapshotActiveAddressesLocked();
    }
    publishLifecycleUpdate(currentAddresses);
  }

  private void applyUpdateLocked(CacheUpdate update) {
    long currentId = databaseId.get();
    long updateDatabaseId = update.getDatabaseId();
    if (updateDatabaseId != 0 && currentId != updateDatabaseId) {
      if (currentId != 0) {
        recipeCache.clear();
        rangeCache.clear();
      }
      databaseId.set(updateDatabaseId);
    }
    if (update.hasKeyRecipes()) {
      recipeCache.addRecipes(update.getKeyRecipes());
    }
    rangeCache.addRanges(update);
  }

  @Nullable
  private Set<String> snapshotActiveAddressesLocked() {
    if (lifecycleManager == null || finderKey == null) {
      return null;
    }
    return rangeCache.getActiveAddresses();
  }

  private void publishLifecycleUpdate(@Nullable Set<String> currentAddresses) {
    if (currentAddresses == null) {
      return;
    }
    lifecycleManager.updateActiveAddressesAsync(finderKey, currentAddresses);
  }

  /**
   * Test-only hook used by {@link KeyAwareChannel#awaitPendingCacheUpdates()} to wait until the
   * async cache update worker has finished applying the latest pending update.
   */
  @VisibleForTesting
  void awaitPendingUpdates() throws InterruptedException {
    long deadline = System.nanoTime() + java.util.concurrent.TimeUnit.SECONDS.toNanos(5);
    while (System.nanoTime() < deadline) {
      java.util.concurrent.CountDownLatch latch = drainingLatch;
      if (latch != null) {
        long remainingNanos = deadline - System.nanoTime();
        if (remainingNanos <= 0) {
          break;
        }
        latch.await(remainingNanos, java.util.concurrent.TimeUnit.NANOSECONDS);
      }
      if (pendingUpdates.isEmpty() && !drainScheduled.get()) {
        return;
      }
    }
  }

  public ChannelEndpoint findServer(ReadRequest.Builder reqBuilder) {
    return findServer(reqBuilder, preferLeader(reqBuilder.getTransaction()), NO_EXCLUDED_ENDPOINTS);
  }

  public ChannelEndpoint findServer(
      ReadRequest.Builder reqBuilder, Predicate<String> excludedEndpoints) {
    return findServer(reqBuilder, preferLeader(reqBuilder.getTransaction()), excludedEndpoints);
  }

  public ChannelEndpoint findServer(ReadRequest.Builder reqBuilder, boolean preferLeader) {
    return findServer(reqBuilder, preferLeader, NO_EXCLUDED_ENDPOINTS);
  }

  public ChannelEndpoint findServer(
      ReadRequest.Builder reqBuilder, boolean preferLeader, Predicate<String> excludedEndpoints) {
    recipeCache.computeKeys(reqBuilder);
    return fillRoutingHint(
        preferLeader,
        KeyRangeCache.RangeMode.COVERING_SPLIT,
        reqBuilder.getDirectedReadOptions(),
        reqBuilder.getRoutingHintBuilder(),
        excludedEndpoints);
  }

  public ChannelEndpoint findServer(ExecuteSqlRequest.Builder reqBuilder) {
    return findServer(reqBuilder, preferLeader(reqBuilder.getTransaction()), NO_EXCLUDED_ENDPOINTS);
  }

  public ChannelEndpoint findServer(
      ExecuteSqlRequest.Builder reqBuilder, Predicate<String> excludedEndpoints) {
    return findServer(reqBuilder, preferLeader(reqBuilder.getTransaction()), excludedEndpoints);
  }

  public ChannelEndpoint findServer(ExecuteSqlRequest.Builder reqBuilder, boolean preferLeader) {
    return findServer(reqBuilder, preferLeader, NO_EXCLUDED_ENDPOINTS);
  }

  public ChannelEndpoint findServer(
      ExecuteSqlRequest.Builder reqBuilder,
      boolean preferLeader,
      Predicate<String> excludedEndpoints) {
    recipeCache.computeKeys(reqBuilder);
    return fillRoutingHint(
        preferLeader,
        KeyRangeCache.RangeMode.PICK_RANDOM,
        reqBuilder.getDirectedReadOptions(),
        reqBuilder.getRoutingHintBuilder(),
        excludedEndpoints);
  }

  public ChannelEndpoint findServer(BeginTransactionRequest.Builder reqBuilder) {
    return findServer(reqBuilder, NO_EXCLUDED_ENDPOINTS);
  }

  public ChannelEndpoint findServer(
      BeginTransactionRequest.Builder reqBuilder, Predicate<String> excludedEndpoints) {
    if (!reqBuilder.hasMutationKey()) {
      return null;
    }
    return routeMutation(
        reqBuilder.getMutationKey(),
        preferLeader(reqBuilder.getOptions()),
        reqBuilder.getRoutingHintBuilder(),
        excludedEndpoints);
  }

  public ChannelEndpoint fillRoutingHint(CommitRequest.Builder reqBuilder) {
    return fillRoutingHint(reqBuilder, NO_EXCLUDED_ENDPOINTS);
  }

  public ChannelEndpoint fillRoutingHint(
      CommitRequest.Builder reqBuilder, Predicate<String> excludedEndpoints) {
    Mutation mutation = selectMutationForRouting(reqBuilder.getMutationsList());
    if (mutation == null) {
      return null;
    }
    return routeMutation(
        mutation, /* preferLeader= */ true, reqBuilder.getRoutingHintBuilder(), excludedEndpoints);
  }

  private static Mutation selectMutationForRouting(List<Mutation> mutations) {
    if (mutations.isEmpty()) {
      return null;
    }
    List<Mutation> mutationsExcludingInsert = new ArrayList<>();
    Mutation largestInsertMutation = null;
    for (Mutation mutation : mutations) {
      if (!mutation.hasInsert()) {
        mutationsExcludingInsert.add(mutation);
        continue;
      }
      if (largestInsertMutation == null
          || mutation.getInsert().getValuesCount()
              > largestInsertMutation.getInsert().getValuesCount()) {
        largestInsertMutation = mutation;
      }
    }
    if (!mutationsExcludingInsert.isEmpty()) {
      return mutationsExcludingInsert.get(
          ThreadLocalRandom.current().nextInt(mutationsExcludingInsert.size()));
    }
    return largestInsertMutation;
  }

  private ChannelEndpoint routeMutation(
      Mutation mutation,
      boolean preferLeader,
      RoutingHint.Builder hintBuilder,
      Predicate<String> excludedEndpoints) {
    recipeCache.applySchemaGeneration(hintBuilder);
    TargetRange target = recipeCache.mutationToTargetRange(mutation);
    if (target == null) {
      return null;
    }
    recipeCache.applyTargetRange(hintBuilder, target);
    return fillRoutingHint(
        preferLeader,
        KeyRangeCache.RangeMode.COVERING_SPLIT,
        DirectedReadOptions.getDefaultInstance(),
        hintBuilder,
        excludedEndpoints);
  }

  private ChannelEndpoint fillRoutingHint(
      boolean preferLeader,
      KeyRangeCache.RangeMode rangeMode,
      DirectedReadOptions directedReadOptions,
      RoutingHint.Builder hintBuilder,
      Predicate<String> excludedEndpoints) {
    long id = databaseId.get();
    if (id == 0) {
      return null;
    }
    hintBuilder.setDatabaseId(id);
    return rangeCache.fillRoutingHint(
        preferLeader, rangeMode, directedReadOptions, hintBuilder, excludedEndpoints);
  }

  private static boolean preferLeader(TransactionSelector selector) {
    switch (selector.getSelectorCase()) {
      case BEGIN:
        return !selector.getBegin().hasReadOnly() || selector.getBegin().getReadOnly().getStrong();
      case SINGLE_USE:
        if (!selector.getSingleUse().hasReadOnly()) {
          return true;
        }
        return selector.getSingleUse().getReadOnly().getStrong();
      case ID:
      case SELECTOR_NOT_SET:
      default:
        return true;
    }
  }

  private static boolean preferLeader(TransactionOptions options) {
    if (options == null || !options.hasReadOnly()) {
      return true;
    }
    return options.getReadOnly().getStrong();
  }
}
