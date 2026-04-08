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
import com.google.spanner.v1.BeginTransactionRequest;
import com.google.spanner.v1.CacheUpdate;
import com.google.spanner.v1.CommitRequest;
import com.google.spanner.v1.DirectedReadOptions;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.Group;
import com.google.spanner.v1.Mutation;
import com.google.spanner.v1.ReadRequest;
import com.google.spanner.v1.RoutingHint;
import com.google.spanner.v1.Tablet;
import com.google.spanner.v1.TransactionOptions;
import com.google.spanner.v1.TransactionSelector;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
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

  private final Object updateLock = new Object();
  private final AtomicLong databaseId = new AtomicLong();
  private final KeyRecipeCache recipeCache = new KeyRecipeCache();
  private final KeyRangeCache rangeCache;
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

  public void update(CacheUpdate update) {
    synchronized (updateLock) {
      long currentId = databaseId.get();
      if (currentId != update.getDatabaseId()) {
        if (currentId != 0) {
          recipeCache.clear();
          rangeCache.clear();
        }
        databaseId.set(update.getDatabaseId());
      }
      if (update.hasKeyRecipes()) {
        recipeCache.addRecipes(update.getKeyRecipes());
      }
      rangeCache.addRanges(update);

      // Notify the lifecycle manager about server addresses so it can create endpoints
      // in the background and start probing, and evict stale endpoints atomically.
      if (lifecycleManager != null && finderKey != null) {
        Set<String> currentAddresses = new HashSet<>();
        for (Group group : update.getGroupList()) {
          for (Tablet tablet : group.getTabletsList()) {
            String addr = tablet.getServerAddress();
            if (!addr.isEmpty()) {
              currentAddresses.add(addr);
            }
          }
        }
        // Also include addresses from existing cached tablets not in this update.
        currentAddresses.addAll(rangeCache.getActiveAddresses());
        // Atomically ensure endpoints exist and evict stale ones.
        lifecycleManager.updateActiveAddresses(finderKey, currentAddresses);
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
