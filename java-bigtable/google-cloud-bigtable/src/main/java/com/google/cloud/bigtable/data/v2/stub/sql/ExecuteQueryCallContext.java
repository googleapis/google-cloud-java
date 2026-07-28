/*
 * Copyright 2024 Google LLC
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
package com.google.cloud.bigtable.data.v2.stub.sql;

import com.google.api.core.InternalApi;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.ApiExceptions;
import com.google.api.gax.rpc.StatusCode;
import com.google.bigtable.v2.ExecuteQueryRequest;
import com.google.cloud.bigtable.data.v2.internal.PrepareResponse;
import com.google.cloud.bigtable.data.v2.internal.PreparedStatementImpl.PreparedQueryData;
import com.google.cloud.bigtable.data.v2.internal.RequestContext;
import com.google.cloud.bigtable.data.v2.models.sql.BoundStatement;
import com.google.cloud.bigtable.data.v2.models.sql.PreparedStatementRefreshTimeoutException;
import com.google.cloud.bigtable.data.v2.models.sql.ResultSetMetadata;
import com.google.common.base.Preconditions;
import com.google.protobuf.ByteString;
import io.grpc.Deadline;
import io.grpc.Status.Code;
import java.time.Instant;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.Nullable;

/**
 * Used to handle the state associated with an ExecuteQuery call. This includes plan refresh, resume
 * tokens, and metadata resolution.
 *
 * <p>This should only be constructed by {@link ExecuteQueryCallable} not directly by users.
 *
 * <p>This is considered an internal implementation detail and should not be used by applications.
 */
@InternalApi("For internal use only")
public class ExecuteQueryCallContext {

  private final BoundStatement boundStatement;
  private final SettableApiFuture<ResultSetMetadata> metadataFuture;
  private PreparedQueryData latestPrepareResponse;
  private @Nullable ByteString resumeToken;
  private final Instant startTimeOfCall;

  private ExecuteQueryCallContext(
      BoundStatement boundStatement, SettableApiFuture<ResultSetMetadata> metadataFuture) {
    this.boundStatement = boundStatement;
    this.metadataFuture = metadataFuture;
    this.latestPrepareResponse = boundStatement.getLatestPrepareResponse();
    this.startTimeOfCall = Instant.now();
  }

  public static ExecuteQueryCallContext create(
      BoundStatement boundStatement, SettableApiFuture<ResultSetMetadata> metadataFuture) {
    return new ExecuteQueryCallContext(boundStatement, metadataFuture);
  }

  /**
   * Builds a request using the latest PrepareQuery data, blocking if necessary for prepare refresh
   * to complete. If waiting on refresh, throws a {@link PreparedStatementRefreshTimeoutException}
   * exception based on the passed deadline.
   *
   * <p>translates all other exceptions to be retryable so that ExecuteQuery can refresh the plan
   * and try again if it has not exhausted its retries
   *
   * <p>If currentAttemptDeadline is null it times out after Long.MAX_VALUE nanoseconds
   */
  ExecuteQueryRequest buildRequestWithDeadline(
      RequestContext requestContext, @Nullable Deadline currentAttemptDeadline)
      throws PreparedStatementRefreshTimeoutException {
    // Use max Long as default timeout for simplicity if no deadline is set
    long planRefreshWaitTimeoutNanos = Long.MAX_VALUE;
    if (currentAttemptDeadline != null) {
      planRefreshWaitTimeoutNanos = currentAttemptDeadline.timeRemaining(TimeUnit.NANOSECONDS);
    }
    try {
      PrepareResponse response =
          latestPrepareResponse
              .prepareFuture()
              .get(planRefreshWaitTimeoutNanos, TimeUnit.NANOSECONDS);
      return boundStatement.toProto(response.preparedQuery(), requestContext, resumeToken);
    } catch (TimeoutException e) {
      throw new PreparedStatementRefreshTimeoutException(
          "Exceeded deadline waiting for PreparedQuery to refresh");
    } catch (ExecutionException e) {
      StatusCode retryStatusCode = GrpcStatusCode.of(Code.FAILED_PRECONDITION);
      Throwable cause = e.getCause();
      if (cause instanceof ApiException) {
        retryStatusCode = ((ApiException) cause).getStatusCode();
      }
      throw ApiExceptionFactory.createException("Plan refresh error", cause, retryStatusCode, true);
    } catch (InterruptedException e) {
      throw ApiExceptionFactory.createException(
          "Plan refresh error", e, GrpcStatusCode.of(Code.FAILED_PRECONDITION), true);
    }
  }

  /**
   * Metadata can change as the plan is refreshed. Once a resume token or complete has been received
   * from the stream we know that the {@link com.google.bigtable.v2.PrepareQueryResponse} can no
   * longer change, so we can set the metadata.
   */
  void finalizeMetadata() {
    // We don't ever expect an exception here, since we've already received responses at the point
    // this is called
    try {
      Preconditions.checkState(
          latestPrepareResponse.prepareFuture().isDone(),
          "Unexpected attempt to finalize metadata with unresolved prepare response. This should"
              + " never as this is called after we receive ExecuteQuery responses, which requires"
              + " the future to be resolved");
      PrepareResponse response =
          ApiExceptions.callAndTranslateApiException(latestPrepareResponse.prepareFuture());
      metadataFuture.set(response.resultSetMetadata());
    } catch (Throwable t) {
      metadataFuture.setException(t);
      throw t;
    }
  }

  /**
   * If the stream receives an error before receiving any response it needs to be passed through to
   * the metadata future
   */
  void setMetadataException(Throwable t) {
    metadataFuture.setException(t);
  }

  SettableApiFuture<ResultSetMetadata> resultSetMetadataFuture() {
    return this.metadataFuture;
  }

  void setLatestResumeToken(ByteString resumeToken) {
    this.resumeToken = resumeToken;
  }

  boolean hasResumeToken() {
    return this.resumeToken != null;
  }

  void triggerImmediateRefreshOfPreparedQuery() {
    latestPrepareResponse =
        this.boundStatement.markExpiredAndStartRefresh(latestPrepareResponse.version());
  }

  Instant startTimeOfCall() {
    return this.startTimeOfCall;
  }
}
