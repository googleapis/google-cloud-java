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
import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.StatusCode.Code;
import com.google.api.gax.rpc.StreamController;
import com.google.bigtable.v2.ExecuteQueryRequest;
import com.google.bigtable.v2.ExecuteQueryResponse;
import com.google.cloud.bigtable.data.v2.internal.RequestContext;
import com.google.cloud.bigtable.data.v2.models.sql.PreparedStatementRefreshTimeoutException;
import com.google.cloud.bigtable.data.v2.models.sql.ResultSetMetadata;
import com.google.cloud.bigtable.data.v2.stub.SafeResponseObserver;
import com.google.rpc.PreconditionFailure;
import com.google.rpc.PreconditionFailure.Violation;
import io.grpc.Deadline;
import io.grpc.Status;
import java.time.Duration;
import java.time.Instant;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/**
 * Callable that allows passing of {@link ResultSetMetadata} back to users throught the {@link
 * ExecuteQueryCallContext}.
 *
 * <p>This is considered an internal implementation detail and should not be used by applications.
 */
@InternalApi("For internal use only")
public class PlanRefreshingCallable
    extends ServerStreamingCallable<ExecuteQueryCallContext, ExecuteQueryResponse> {
  private final ServerStreamingCallable<ExecuteQueryRequest, ExecuteQueryResponse> inner;
  private final RequestContext requestContext;

  public PlanRefreshingCallable(
      ServerStreamingCallable<ExecuteQueryRequest, ExecuteQueryResponse> inner,
      RequestContext requestContext) {
    this.inner = inner;
    this.requestContext = requestContext;
  }

  @Override
  public void call(
      ExecuteQueryCallContext executeQueryCallContext,
      ResponseObserver<ExecuteQueryResponse> responseObserver,
      @Nullable ApiCallContext apiCallContext) {
    PlanRefreshingObserver observer =
        new PlanRefreshingObserver(responseObserver, executeQueryCallContext);
    ExecuteQueryRequest request;
    @Nullable GrpcCallContext grpcCallContext = (GrpcCallContext) apiCallContext;
    // Convert timeout to an absolute deadline, so we can use it for both the plan refresh and
    // the ExecuteQuery rpc
    Deadline deadline = getDeadline(grpcCallContext, executeQueryCallContext.startTimeOfCall());
    try {
      // TODO: this blocks. That is ok because ResultSet is synchronous. If we ever
      // need to make this async that needs to change
      request = executeQueryCallContext.buildRequestWithDeadline(requestContext, deadline);
    } catch (PreparedStatementRefreshTimeoutException e) {
      // If we timed out waiting for refresh, return the retryable error, but don't trigger a
      // new refresh since one is ongoing
      responseObserver.onError(e);
      return;
    } catch (Throwable throwable) {
      // If we already have a resumeToken we can't refresh the plan, so we throw an error.
      // This is not expected to happen, as the plan must be resolved in order for us to
      // receive a token
      if (executeQueryCallContext.hasResumeToken()) {
        responseObserver.onError(
            new IllegalStateException(
                "Unexpected plan refresh attempt after first token", throwable));
      }
      // We trigger refresh so the next attempt will use a fresh plan
      executeQueryCallContext.triggerImmediateRefreshOfPreparedQuery();
      responseObserver.onError(throwable);
      return;
    }
    ApiCallContext contextWithAbsoluteDeadline =
        Optional.ofNullable(grpcCallContext)
            .map(c -> c.withCallOptions(grpcCallContext.getCallOptions().withDeadline(deadline)))
            .orElse(null);
    inner.call(request, observer, contextWithAbsoluteDeadline);
  }

  // Checks for an attempt timeout first, then a total timeout. If found, converts the timeout
  // to an absolute deadline. Adjusts totalTimeout based on the time since startTimeOfOverallRequest
  private static @Nullable Deadline getDeadline(
      GrpcCallContext grpcCallContext, Instant startTimeOfOverallRequest) {
    Optional<Deadline> attemptDeadline =
        Optional.ofNullable(grpcCallContext)
            .flatMap(c -> Optional.ofNullable(c.getTimeoutDuration()))
            .map(d -> Deadline.after(d.toNanos(), TimeUnit.NANOSECONDS));
    if (attemptDeadline.isPresent()) {
      return attemptDeadline.get();
    }
    return Optional.ofNullable(grpcCallContext)
        .flatMap(c -> Optional.ofNullable(c.getRetrySettings()))
        .map(RetrySettings::getTotalTimeoutDuration)
        // TotalTimeout of zero means there is no timeout
        .filter(duration -> !duration.isZero())
        .map(
            d -> {
              Duration elapsedTime = Duration.between(startTimeOfOverallRequest, Instant.now());
              Duration remaining = d.minus(elapsedTime);
              // zero is treated as no deadline, so if full deadline is elapsed pass 1 nano
              long adjusted = Math.max(remaining.getNano(), 1);
              return Deadline.after(adjusted, TimeUnit.NANOSECONDS);
            })
        .orElse(null);
  }

  @InternalApi
  static boolean isPlanRefreshError(Throwable t) {
    if (!(t instanceof ApiException)) {
      return false;
    }
    ApiException e = (ApiException) t;
    if (!e.getStatusCode().getCode().equals(Code.FAILED_PRECONDITION)) {
      return false;
    }
    if (e.getErrorDetails() == null) {
      return false;
    }
    PreconditionFailure preconditionFailure = e.getErrorDetails().getPreconditionFailure();
    if (preconditionFailure == null) {
      return false;
    }
    for (Violation violation : preconditionFailure.getViolationsList()) {
      if (violation.getType().contains("PREPARED_QUERY_EXPIRED")) {
        return true;
      }
    }
    return false;
  }

  static final class PlanRefreshingObserver extends SafeResponseObserver<ExecuteQueryResponse> {

    private final ExecuteQueryCallContext callContext;
    private final ResponseObserver<ExecuteQueryResponse> outerObserver;
    // This doesn't need to be synchronized because this is called above the reframer
    // so onResponse will be called sequentially
    private boolean hasReceivedResumeToken;

    PlanRefreshingObserver(
        ResponseObserver<ExecuteQueryResponse> outerObserver, ExecuteQueryCallContext callContext) {
      super(outerObserver);
      this.outerObserver = outerObserver;
      this.callContext = callContext;
      this.hasReceivedResumeToken = false;
    }

    @Override
    protected void onStartImpl(StreamController streamController) {
      outerObserver.onStart(streamController);
    }

    @Override
    protected void onResponseImpl(ExecuteQueryResponse response) {
      // Defer finalizing metadata until we receive a resume token, because this is the
      // only point we can guarantee it won't change.
      //
      // An example of why this is necessary, for query "SELECT * FROM table":
      // - Make a request, table has one column family 'cf'
      // - Return an incomplete batch
      // - request fails with transient error
      // - Meanwhile the table has had a second column family added 'cf2'
      // - Retry the request, get an error indicating the `prepared_query` has expired
      // - Refresh the prepared_query and retry the request, the new prepared_query
      //   contains both 'cf' & 'cf2'
      // - It sends a new incomplete batch and resets the old outdated batch
      // - It send the next chunk with a checksum and resume_token, closing the batch.
      // In this case the row merger and the ResultSet should be using the updated schema from
      // the refreshed prepare request.
      if (!hasReceivedResumeToken && !response.getResults().getResumeToken().isEmpty()) {
        callContext.finalizeMetadata();
        hasReceivedResumeToken = true;
      }
      outerObserver.onResponse(response);
    }

    @Override
    protected void onErrorImpl(Throwable throwable) {
      boolean refreshPlan = isPlanRefreshError(throwable);
      // If we've received a resume token we shouldn't receive this error. Safeguard against
      // accidentally changing the schema mid-response though
      if (refreshPlan && !hasReceivedResumeToken) {
        callContext.triggerImmediateRefreshOfPreparedQuery();
        outerObserver.onError(
            new ApiException(throwable, GrpcStatusCode.of(Status.Code.FAILED_PRECONDITION), true));
      } else if (refreshPlan) {
        outerObserver.onError(
            new IllegalStateException(
                "Unexpected plan refresh attempt after first token", throwable));
      } else {
        // Note that we do not set exceptions on the metadata future here. This
        // needs to be done after the retries, so that retryable errors aren't set on
        // the future
        outerObserver.onError(throwable);
      }
    }

    @Override
    protected void onCompleteImpl() {
      if (!callContext.resultSetMetadataFuture().isDone()) {
        // If stream succeeds with no responses, we can finalize the metadata
        callContext.finalizeMetadata();
      }
      outerObserver.onComplete();
    }
  }
}
