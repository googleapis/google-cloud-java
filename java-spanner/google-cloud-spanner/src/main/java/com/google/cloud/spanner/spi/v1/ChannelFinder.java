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
import com.google.spanner.v1.DirectedReadOptions;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.ReadRequest;
import com.google.spanner.v1.RoutingHint;
import com.google.spanner.v1.TransactionOptions;
import com.google.spanner.v1.TransactionSelector;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Finds a server for a request using location-aware routing metadata.
 *
 * <p>This component is per-database and maintains both recipe and range caches.
 */
@InternalApi
public final class ChannelFinder {
  private final Object updateLock = new Object();
  private final AtomicLong databaseId = new AtomicLong();
  private final KeyRecipeCache recipeCache = new KeyRecipeCache();
  private final KeyRangeCache rangeCache;

  public ChannelFinder(ChannelEndpointCache endpointCache) {
    this.rangeCache = new KeyRangeCache(Objects.requireNonNull(endpointCache));
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
    }
  }

  public ChannelEndpoint findServer(ReadRequest.Builder reqBuilder) {
    return findServer(reqBuilder, preferLeader(reqBuilder.getTransaction()));
  }

  public ChannelEndpoint findServer(ReadRequest.Builder reqBuilder, boolean preferLeader) {
    recipeCache.computeKeys(reqBuilder);
    return fillRoutingHint(
        preferLeader,
        KeyRangeCache.RangeMode.COVERING_SPLIT,
        reqBuilder.getDirectedReadOptions(),
        reqBuilder.getRoutingHintBuilder());
  }

  public ChannelEndpoint findServer(ExecuteSqlRequest.Builder reqBuilder) {
    return findServer(reqBuilder, preferLeader(reqBuilder.getTransaction()));
  }

  public ChannelEndpoint findServer(ExecuteSqlRequest.Builder reqBuilder, boolean preferLeader) {
    recipeCache.computeKeys(reqBuilder);
    return fillRoutingHint(
        preferLeader,
        KeyRangeCache.RangeMode.PICK_RANDOM,
        reqBuilder.getDirectedReadOptions(),
        reqBuilder.getRoutingHintBuilder());
  }

  public ChannelEndpoint findServer(BeginTransactionRequest.Builder reqBuilder) {
    if (!reqBuilder.hasMutationKey()) {
      return null;
    }
    TargetRange target = recipeCache.mutationToTargetRange(reqBuilder.getMutationKey());
    if (target == null) {
      return null;
    }
    RoutingHint.Builder hintBuilder = RoutingHint.newBuilder();
    hintBuilder.setKey(target.start);
    if (!target.limit.isEmpty()) {
      hintBuilder.setLimitKey(target.limit);
    }
    return fillRoutingHint(
        preferLeader(reqBuilder.getOptions()),
        KeyRangeCache.RangeMode.COVERING_SPLIT,
        DirectedReadOptions.getDefaultInstance(),
        hintBuilder);
  }

  private ChannelEndpoint fillRoutingHint(
      TransactionSelector transactionSelector,
      DirectedReadOptions directedReadOptions,
      KeyRangeCache.RangeMode rangeMode,
      RoutingHint.Builder hintBuilder) {
    return fillRoutingHint(
        preferLeader(transactionSelector), rangeMode, directedReadOptions, hintBuilder);
  }

  private ChannelEndpoint fillRoutingHint(
      boolean preferLeader,
      KeyRangeCache.RangeMode rangeMode,
      DirectedReadOptions directedReadOptions,
      RoutingHint.Builder hintBuilder) {
    long id = databaseId.get();
    if (id == 0) {
      return null;
    }
    hintBuilder.setDatabaseId(id);
    return rangeCache.fillRoutingHint(preferLeader, rangeMode, directedReadOptions, hintBuilder);
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
