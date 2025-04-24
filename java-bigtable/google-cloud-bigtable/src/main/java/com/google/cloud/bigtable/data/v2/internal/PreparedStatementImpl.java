/*
 * Copyright 2025 Google LLC
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
package com.google.cloud.bigtable.data.v2.internal;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.InternalApi;
import com.google.auto.value.AutoValue;
import com.google.cloud.bigtable.data.v2.models.sql.BoundStatement;
import com.google.cloud.bigtable.data.v2.models.sql.BoundStatement.Builder;
import com.google.cloud.bigtable.data.v2.models.sql.PreparedStatement;
import com.google.cloud.bigtable.data.v2.models.sql.SqlType;
import com.google.cloud.bigtable.data.v2.stub.EnhancedBigtableStub;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Futures;
import java.time.Duration;
import java.time.Instant;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Implementation of PreparedStatement that handles PreparedQuery refresh.
 *
 * <p>This allows for both hard refresh and background refresh of the current PreparedQueryData.
 * When the server returns an error indicating that a plan is expired, hardRefresh should be used.
 * Otherwise this will handle updating the PreparedQuery in the background, whenever it is accessed
 * within one second of expiry.
 *
 * <p>This is considered an internal implementation detail and should not be used by applications.
 */
@InternalApi("For internal use only")
public class PreparedStatementImpl implements PreparedStatement {
  // Time before plan expiry to trigger background refresh
  private static final Duration EXPIRY_REFRESH_WINDOW = Duration.ofSeconds(1L);
  private final AtomicReference<PrepareQueryState> currentState;
  private final Map<String, SqlType<?>> paramTypes;
  private final PrepareQueryRequest prepareRequest;
  private final EnhancedBigtableStub stub;

  @VisibleForTesting
  protected PreparedStatementImpl(
      PrepareResponse response,
      Map<String, SqlType<?>> paramTypes,
      PrepareQueryRequest request,
      EnhancedBigtableStub stub) {
    this.currentState = new AtomicReference<>(PrepareQueryState.createInitialState(response));
    this.paramTypes = paramTypes;
    this.prepareRequest = request;
    this.stub = stub;
  }

  public static PreparedStatement create(
      PrepareResponse response,
      Map<String, SqlType<?>> paramTypes,
      PrepareQueryRequest request,
      EnhancedBigtableStub stub) {
    return new PreparedStatementImpl(response, paramTypes, request, stub);
  }

  @Override
  public BoundStatement.Builder bind() {
    return new Builder(this, paramTypes);
  }

  /**
   * Asserts that the given stub matches the stub used for plan refresh. This is necessary to ensure
   * that the request comes from the same client and uses the same configuration. We enforce this
   * make sure plan refresh will continue to work as expected throughout the lifecycle of
   * executeQuery requests.
   */
  public void assertUsingSameStub(EnhancedBigtableStub stub) {
    Preconditions.checkArgument(
        this.stub == stub,
        "executeQuery must be called from the same client instance that created the"
            + " PreparedStatement being used.");
  }

  /**
   * When the client receives an error indicating the current plan has expired, it should call
   * immediate refresh with the version of the expired plan. UID is used to handle concurrent
   * refresh without making duplicate calls.
   *
   * @param expiredPreparedQueryVersion version of the PreparedQuery used to make the request that
   *     triggered immediate refresh
   * @return refreshed PreparedQuery to use for retry.
   */
  public synchronized PreparedQueryData markExpiredAndStartRefresh(
      PreparedQueryVersion expiredPreparedQueryVersion) {
    PrepareQueryState localState = this.currentState.get();
    // Check if the expired plan is the current plan.  If it's not, then the plan has already
    // been refreshed by another thread.
    if (!(localState.current().version() == expiredPreparedQueryVersion)) {
      return localState.current();
    }
    startBackgroundRefresh(expiredPreparedQueryVersion);
    // Immediately promote the refresh we just started
    return promoteBackgroundRefreshingPlan(expiredPreparedQueryVersion);
  }

  private synchronized PreparedQueryData promoteBackgroundRefreshingPlan(
      PreparedQueryVersion expiredPreparedQueryVersion) {
    PrepareQueryState localState = this.currentState.get();
    // If the expired plan has already been removed, return the current plan
    if (!(localState.current().version() == expiredPreparedQueryVersion)) {
      return localState.current();
    }
    // There is a chance that the background plan could be expired if the PreparedStatement
    // isn't used for a long time. It will be refreshed on the next retry if necessary.
    PrepareQueryState nextState = localState.promoteBackgroundPlan();
    this.currentState.set(nextState);
    return nextState.current();
  }

  /**
   * If planNearExpiry is still the latest plan, and there is no ongoing background refresh, start a
   * background refresh. Otherwise, refresh has already been triggered for this plan, so do nothing.
   */
  private synchronized void startBackgroundRefresh(PreparedQueryVersion planVersionNearExpiry) {
    PrepareQueryState localState = this.currentState.get();
    // We've already updated the plan we are triggering refresh based on
    if (!(localState.current().version() == planVersionNearExpiry)) {
      return;
    }
    // Another thread already started the refresh
    if (localState.maybeBackgroundRefresh().isPresent()) {
      return;
    }
    ApiFuture<PrepareResponse> nextPlanFuture = getFreshPlan();
    PrepareQueryState withRefresh = localState.withBackgroundPlan(nextPlanFuture);
    this.currentState.set(withRefresh);
  }

  ApiFuture<PrepareResponse> getFreshPlan() {
    return this.stub.prepareQueryCallable().futureCall(this.prepareRequest);
  }

  /**
   * Check the expiry of the current plan, if it's future is resolved. If we are within 1s of
   * expiry, call startBackgroundRefresh with the version of the latest PrepareQuery.
   */
  void backgroundRefreshIfNeeded() {
    PrepareQueryState localState = this.currentState.get();
    if (localState.maybeBackgroundRefresh().isPresent()) {
      // We already have an ongoing refresh
      return;
    }
    PreparedQueryData currentPlan = localState.current();
    // Can't access ttl until the current prepare future has resolved
    if (!currentPlan.prepareFuture().isDone()) {
      return;
    }
    try {
      // Trigger a background refresh if within 1 second of TTL
      Instant currentPlanExpireTime = Futures.getDone(currentPlan.prepareFuture()).validUntil();
      Instant backgroundRefreshTime = currentPlanExpireTime.minus(EXPIRY_REFRESH_WINDOW);
      if (Instant.now().isAfter(backgroundRefreshTime)) {
        // Initiate a background refresh. startBackgroundRefresh handles deduplication.
        startBackgroundRefresh(currentPlan.version());
      }
    } catch (ExecutionException | CancellationException e) {
      // Do nothing if we can't get the future result, a refresh will be done when it's actually
      // needed, or during the next call to this method
    }
  }

  /**
   * Returns the most recently refreshed PreparedQueryData. It may still be refreshing if the
   * previous plan has expired.
   */
  public PreparedQueryData getLatestPrepareResponse() {
    PrepareQueryState localState = currentState.get();
    if (localState.maybeBackgroundRefresh().isPresent()
        && localState.maybeBackgroundRefresh().get().prepareFuture().isDone()) {
      // TODO: consider checking if background plan has already expired and triggering
      // a new refresh if so. Right now we are ok with attempting a request w an expired
      // plan

      // Current background refresh has completed, so we should make it the current plan.
      // promoteBackgroundRefreshingPlan handles duplicate calls.
      return promoteBackgroundRefreshingPlan(localState.current().version());
    } else {
      backgroundRefreshIfNeeded();
      return localState.current();
    }
  }

  /**
   * Used to compare different versions of a PreparedQuery by comparing reference equality.
   *
   * <p>This is considered an internal implementation detail and not meant to be used by
   * applications.
   */
  @InternalApi("For internal use only")
  public static class PreparedQueryVersion {}

  /**
   * Manages the data around the latest prepared query
   *
   * <p>This is considered an internal implementation detail and not meant to be used by
   * applications.
   */
  @InternalApi("For internal use only")
  @AutoValue
  public abstract static class PreparedQueryData {
    /**
     * Unique identifier for each version of a PreparedQuery. Changes each time the plan is
     * refreshed
     */
    public abstract PreparedQueryVersion version();

    /**
     * A future holding the prepareResponse. It will never fail, so the caller is responsible for
     * timing out requests based on the retry settings of the execute query request
     */
    public abstract ApiFuture<PrepareResponse> prepareFuture();

    public static PreparedQueryData create(ApiFuture<PrepareResponse> prepareFuture) {
      return new AutoValue_PreparedStatementImpl_PreparedQueryData(
          new PreparedQueryVersion(), prepareFuture);
    }
  }

  /**
   * Encapsulates the state needed to for PreparedStatementImpl. This is both the latest
   * PrepareQuery response and, when present, any ongoing background refresh.
   *
   * <p>This is stored together because it is accessed concurrently. This makes it easy to reason
   * about and mutate the state atomically.
   */
  @AutoValue
  abstract static class PrepareQueryState {
    /** The data representing the latest PrepareQuery response */
    abstract PreparedQueryData current();

    /** An Optional, that if present represents an ongoing background refresh attempt */
    abstract Optional<PreparedQueryData> maybeBackgroundRefresh();

    /** Creates a fresh state, using initialPlan as current, with no backgroundRefresh */
    static PrepareQueryState createInitialState(PrepareResponse initialPlan) {
      PreparedQueryData initialData =
          PreparedQueryData.create(ApiFutures.immediateFuture(initialPlan));
      return new AutoValue_PreparedStatementImpl_PrepareQueryState(initialData, Optional.empty());
    }

    /**
     * Returns a new state with the same current PreparedQueryData, using the given PrepareResponse
     * future to add a backgroundRefresh
     */
    PrepareQueryState withBackgroundPlan(ApiFuture<PrepareResponse> backgroundPlan) {
      return new AutoValue_PreparedStatementImpl_PrepareQueryState(
          current(), Optional.of(PreparedQueryData.create(backgroundPlan)));
    }

    /**
     * Returns a new state with the background plan promoted to current, and without a new
     * background refresh. This should be used to update the state once a backgroundRefresh has
     * completed.
     */
    PrepareQueryState promoteBackgroundPlan() {
      if (maybeBackgroundRefresh().isPresent()) {
        return new AutoValue_PreparedStatementImpl_PrepareQueryState(
            maybeBackgroundRefresh().get(), Optional.empty());
      }
      // We don't expect this to happen, but if so returning the current plan allows retry on
      // subsequent attempts
      return this;
    }
  }
}
