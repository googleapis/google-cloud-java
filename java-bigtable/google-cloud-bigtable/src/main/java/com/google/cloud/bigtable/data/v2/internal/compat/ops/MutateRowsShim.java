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
package com.google.cloud.bigtable.data.v2.internal.compat.ops;

import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.bigtable.v2.SessionMutateRowsRequest;
import com.google.bigtable.v2.SessionMutateRowsResponse;
import com.google.cloud.bigtable.data.v2.internal.api.Util;
import com.google.cloud.bigtable.data.v2.internal.session.SessionPool;
import com.google.cloud.bigtable.data.v2.models.AuthorizedViewId;
import com.google.cloud.bigtable.data.v2.models.BulkMutation;
import com.google.cloud.bigtable.data.v2.models.MutateRowsException;
import com.google.cloud.bigtable.data.v2.models.MutateRowsException.FailedMutation;
import com.google.cloud.bigtable.data.v2.models.TableId;
import com.google.cloud.bigtable.data.v2.models.TargetId;
import com.google.cloud.bigtable.data.v2.stub.mutaterows.MutateRowsAttemptResult;
import com.google.common.collect.ImmutableSet;
import com.google.common.primitives.Ints;
import com.google.rpc.Code;
import io.grpc.Deadline;
import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.StatusRuntimeException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutionException;

public class MutateRowsShim implements UnaryShim<BulkMutation, MutateRowsAttemptResult> {

  private static final Set<StatusCode.Code> DEFAULT_RETRYABLE_CODES =
      ImmutableSet.of(StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE);

  private final SessionPoolMap sessionMap;
  private final Set<StatusCode.Code> retryableCodes;

  public MutateRowsShim(SessionPoolMap sessionMap) {
    this(sessionMap, DEFAULT_RETRYABLE_CODES);
  }

  public MutateRowsShim(SessionPoolMap sessionMap, Set<StatusCode.Code> retryableCodes) {
    this.sessionMap = sessionMap;
    this.retryableCodes = ImmutableSet.copyOf(retryableCodes);
  }

  @Override
  public void close() {}

  @Override
  public boolean supports(BulkMutation request) {
    TargetId targetId = request.getTargetId();
    SessionPool<?> pool;
    if (targetId instanceof TableId) {
      pool = sessionMap.get((TableId) targetId, SessionKey.Permission.WRITE).getSessionPool();
    } else if (targetId instanceof AuthorizedViewId) {
      pool =
          sessionMap.get((AuthorizedViewId) targetId, SessionKey.Permission.WRITE).getSessionPool();
    } else {
      return false;
    }
    return UnaryShim.shouldRouteToSession(pool);
  }

  @Override
  public CompletableFuture<MutateRowsAttemptResult> call(BulkMutation request, Deadline deadline) {
    TargetId targetId = request.getTargetId();
    SessionMutateRowsRequest innerReq = request.toSessionProto();

    CompletableFuture<SessionMutateRowsResponse> responseFuture;
    if (targetId instanceof TableId) {
      responseFuture =
          sessionMap.apply(
              (TableId) targetId,
              SessionKey.Permission.WRITE,
              t -> t.mutateRows(innerReq, deadline));
    } else if (targetId instanceof AuthorizedViewId) {
      responseFuture =
          sessionMap.apply(
              (AuthorizedViewId) targetId,
              SessionKey.Permission.WRITE,
              v -> v.mutateRows(innerReq, deadline));
    } else {
      CompletableFuture<MutateRowsAttemptResult> f = new CompletableFuture<>();
      f.completeExceptionally(
          new UnsupportedOperationException("Unsupported targetId type: " + targetId));
      return f;
    }

    return responseFuture.handle(
        (response, error) -> {
          if (error != null) {
            throw toWholeRpcException(innerReq, error);
          }
          return toAttemptResult(innerReq, response);
        });
  }

  private MutateRowsAttemptResult toAttemptResult(
      SessionMutateRowsRequest innerReq, SessionMutateRowsResponse response) {
    int entryCount = innerReq.getEntriesCount();
    boolean[] seenIndices = new boolean[entryCount];
    List<FailedMutation> failedMutations = new ArrayList<>();
    boolean anyRetryable = false;

    for (SessionMutateRowsResponse.Entry entry : response.getEntriesList()) {
      int index = Ints.checkedCast(entry.getIndex());
      if (index < 0 || index >= entryCount || seenIndices[index]) {
        continue;
      }
      seenIndices[index] = true;

      if (entry.getStatus().getCode() == Code.OK_VALUE) {
        continue;
      }

      Status grpcStatus =
          Status.fromCodeValue(entry.getStatus().getCode())
              .withDescription(entry.getStatus().getMessage());
      StatusCode gaxStatusCode = GrpcStatusCode.of(grpcStatus.getCode());
      boolean isEntryRetryable =
          retryableCodes.contains(gaxStatusCode.getCode())
              && Util.isIdempotent(innerReq.getEntries(index).getMutationsList());

      ApiException entryError =
          ApiExceptionFactory.createException(
              grpcStatus.asRuntimeException(), gaxStatusCode, isEntryRetryable);
      failedMutations.add(FailedMutation.create(index, entryError));
      if (isEntryRetryable) {
        anyRetryable = true;
      }
    }

    for (int i = 0; i < entryCount; i++) {
      if (!seenIndices[i]) {
        ApiException missingError =
            ApiExceptionFactory.createException(
                "Missing entry response for entry " + i,
                null,
                GrpcStatusCode.of(Status.Code.INTERNAL),
                false);
        failedMutations.add(FailedMutation.create(i, missingError));
      }
    }

    if (failedMutations.isEmpty()) {
      return MutateRowsAttemptResult.success();
    }
    return MutateRowsAttemptResult.create(failedMutations, anyRetryable);
  }

  private RuntimeException toWholeRpcException(SessionMutateRowsRequest innerReq, Throwable error) {
    Throwable cause = error;
    while (cause instanceof CompletionException || cause instanceof ExecutionException) {
      if (cause.getCause() != null) {
        cause = cause.getCause();
      } else {
        break;
      }
    }

    if (cause instanceof MutateRowsException) {
      return (MutateRowsException) cause;
    }

    ApiException rpcApiException;
    if (cause instanceof ApiException) {
      rpcApiException = (ApiException) cause;
    } else {
      Status.Code code = Status.Code.UNKNOWN;
      if (cause instanceof StatusRuntimeException) {
        code = ((StatusRuntimeException) cause).getStatus().getCode();
      } else if (cause instanceof StatusException) {
        code = ((StatusException) cause).getStatus().getCode();
      }
      StatusCode gaxStatusCode = GrpcStatusCode.of(code);
      boolean rpcRetryable = retryableCodes.contains(gaxStatusCode.getCode());
      rpcApiException =
          ApiExceptionFactory.createException(
              cause.getMessage(), cause, gaxStatusCode, rpcRetryable);
    }

    int entryCount = innerReq.getEntriesCount();
    if (entryCount == 0) {
      return rpcApiException;
    }

    List<FailedMutation> failedMutations = new ArrayList<>(entryCount);
    boolean anyEntryRetryable = false;
    for (int i = 0; i < entryCount; i++) {
      boolean entryRetryable =
          rpcApiException.isRetryable()
              && Util.isIdempotent(innerReq.getEntries(i).getMutationsList());
      ApiException entryError =
          ApiExceptionFactory.createException(
              rpcApiException,
              rpcApiException.getStatusCode(),
              entryRetryable,
              rpcApiException.getErrorDetails());
      failedMutations.add(FailedMutation.create(i, entryError));
      if (entryRetryable) {
        anyEntryRetryable = true;
      }
    }

    return MutateRowsException.create(
        rpcApiException, rpcApiException.getStatusCode(), failedMutations, anyEntryRetryable);
  }
}
