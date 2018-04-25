/*
 * Copyright 2017 Google LLC
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

package com.google.cloud.spanner;

import com.google.api.core.ApiClock;
import com.google.api.core.CurrentMillisClock;
import com.google.api.gax.retrying.BasicResultRetryAlgorithm;
import com.google.api.gax.retrying.PollException;
import com.google.api.gax.retrying.RetrySettings;
import com.google.cloud.BaseServiceException;
import com.google.cloud.RetryHelper;
import com.google.cloud.RetryOption;
import com.google.cloud.spanner.spi.v1.SpannerRpc;
import com.google.common.annotations.VisibleForTesting;
import com.google.longrunning.Operation.ResultCase;
import com.google.protobuf.Any;
import com.google.rpc.Status;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import javax.annotation.Nullable;
import org.threeten.bp.Duration;

/** Represents a long running operation. */
// TODO(user): Implement other operations on Operation.
public class Operation<R, M> {

  private final RetrySettings DEFAULT_OPERATION_WAIT_SETTINGS =
      RetrySettings.newBuilder()
          .setTotalTimeout(Duration.ofHours(12L))
          .setInitialRetryDelay(Duration.ofMillis(500L))
          .setRetryDelayMultiplier(1.0)
          .setJittered(false)
          .setMaxRetryDelay(Duration.ofMinutes(500L))
          .build();

  static interface Parser<R, M> {
    R parseResult(Any response);

    M parseMetadata(Any metadata);
  }

  private final M metadata;
  private final R result;
  private final SpannerException exception;
  private final boolean isDone;
  private final SpannerRpc rpc;
  private final String name;
  private final Parser<R, M> parser;
  private final ApiClock clock;

  @VisibleForTesting
  Operation(
      SpannerRpc rpc,
      String name,
      @Nullable M metadata,
      @Nullable R result,
      @Nullable SpannerException exception,
      boolean isDone,
      Parser<R, M> parser,
      ApiClock clock) {
    this.rpc = rpc;
    this.name = name;
    this.metadata = metadata;
    this.result = result;
    this.exception = exception;
    this.isDone = isDone;
    this.parser = parser;
    this.clock = clock;
  }

  private static <R, M> Operation<R, M> failed(
      SpannerRpc rpc, String name, Status status, M metadata, Parser<R, M> parser, ApiClock clock) {
    SpannerException e =
        SpannerExceptionFactory.newSpannerException(
            ErrorCode.fromRpcStatus(status), status.getMessage(), null);
    return new Operation<R, M>(rpc, name, metadata, null, e, true, parser, clock);
  }

  private static <R, M> Operation<R, M> successful(
      SpannerRpc rpc, String name, M metadata, R result, Parser<R, M> parser, ApiClock clock) {
    return new Operation<>(rpc, name, metadata, result, null, true, parser, clock);
  }

  private static <R, M> Operation<R, M> pending(
      SpannerRpc rpc, String name, M metadata, Parser<R, M> parser, ApiClock clock) {
    return new Operation<>(rpc, name, metadata, null, null, false, parser, clock);
  }

  static <R, M> Operation<R, M> create(
      SpannerRpc rpc, com.google.longrunning.Operation proto, Parser<R, M> parser) {
    return Operation.<R, M>create(rpc, proto, parser, CurrentMillisClock.getDefaultClock());
  }

  static <R, M> Operation<R, M> create(
      SpannerRpc rpc, com.google.longrunning.Operation proto, Parser<R, M> parser, ApiClock clock) {
    M metadata = proto.hasMetadata() ? parser.parseMetadata(proto.getMetadata()) : null;
    String name = proto.getName();
    if (proto.getDone()) {
      if (proto.getResultCase() == ResultCase.ERROR) {
        return Operation.<R, M>failed(rpc, name, proto.getError(), metadata, parser, clock);
      } else {
        return Operation.<R, M>successful(
            rpc, name, metadata, parser.parseResult(proto.getResponse()), parser, clock);
      }
    } else {
      return Operation.<R, M>pending(rpc, name, metadata, parser, clock);
    }
  }

  /** Fetches the current status of this operation. */
  public Operation<R, M> reload() throws SpannerException {
    if (isDone) {
      return this;
    }
    com.google.longrunning.Operation proto = rpc.getOperation(name);
    return Operation.<R, M>create(rpc, proto, parser);
  }

  /**
   * Blocks till the operation is complete or maximum time, if specified, has elapsed.
   *
   * @return null if operation is not found otherwise the current operation.
   */
  public Operation<R, M> waitFor(RetryOption... waitOptions) throws SpannerException {
    if (isDone()) {
      return this;
    }
    RetrySettings waitSettings =
        RetryOption.mergeToSettings(DEFAULT_OPERATION_WAIT_SETTINGS, waitOptions);
    try {
      com.google.longrunning.Operation proto = RetryHelper.poll(
          new Callable<com.google.longrunning.Operation>() {
            @Override
            public com.google.longrunning.Operation call() throws Exception {
              return rpc.getOperation(name);
            }
          },
          waitSettings,
          new BasicResultRetryAlgorithm<com.google.longrunning.Operation>() {
            @Override
            public boolean shouldRetry(
                Throwable prevThrowable, com.google.longrunning.Operation prevResponse) {
              if (prevResponse != null) {
                return !prevResponse.getDone();
              }
              if (prevThrowable instanceof SpannerException) {
                SpannerException spannerException = (SpannerException) prevThrowable;
                return spannerException.getErrorCode() != ErrorCode.NOT_FOUND
                    && spannerException.isRetryable();
              }
              return false;
            }
          },
          clock);
      return Operation.create(rpc, proto, parser);
    } catch (InterruptedException e) {
      throw SpannerExceptionFactory.propagateInterrupt(e);
    } catch (ExecutionException e) {
      Throwable cause = e.getCause();
      if (cause instanceof SpannerException) {
        SpannerException spannerException = (SpannerException) cause;
        if(spannerException.getErrorCode() == ErrorCode.NOT_FOUND) {
          return null;
        }
        throw spannerException;
      }
      if (cause instanceof PollException) {
        throw SpannerExceptionFactory.newSpannerException(
            ErrorCode.DEADLINE_EXCEEDED, "Operation did not complete in the given time");
      }
      throw SpannerExceptionFactory.newSpannerException(cause);
    }
  }

  /**
   * Returns the metadata returned by the last refresh of this operation. Returns null if no
   * metadata was returned or if this operation has not been refereshed.
   */
  public M getMetadata() {
    return metadata;
  }

  /** Returns true if the operation is done. */
  public boolean isDone() {
    return isDone;
  }

  /**
   * Returns result of the operation if the operation is complete and had a result. Returns null if
   * the operation is not complete or did not have a result.
   *
   * @throws SpannerException if the operation failed.
   */
  public R getResult() throws SpannerException {
    if (exception != null) {
      throw exception;
    }
    return result;
  }

  /** Returns the name of the operation. */
  public String getName() {
    return name;
  }

  /** Returns true if the operation completed sucessfully. */
  public boolean isSuccessful() {
    return isDone && exception == null;
  }
}
