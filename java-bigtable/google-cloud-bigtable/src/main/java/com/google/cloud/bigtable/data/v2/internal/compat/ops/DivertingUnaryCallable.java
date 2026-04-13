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

import com.google.api.core.ApiFuture;
import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.bigtable.data.v2.internal.compat.FutureAdapter;
import com.google.cloud.bigtable.data.v2.internal.compat.Util;
import com.google.cloud.bigtable.data.v2.internal.util.ClientConfigurationManager;
import com.google.common.base.Throwables;
import io.grpc.Context;
import io.grpc.Context.CancellableContext;
import io.grpc.Deadline;
import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.StatusRuntimeException;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadLocalRandom;

/** A callable to fork traffic between classic and session based operations. */
public class DivertingUnaryCallable<ReqT, RespT> extends UnaryCallable<ReqT, RespT> {
  private final ClientConfigurationManager configurationManager;

  private final UnaryCallable<ReqT, RespT> classic;
  private final UnaryShim<ReqT, RespT> experimental;

  private final Duration defaultTimeout;

  public DivertingUnaryCallable(
      ClientConfigurationManager configurationManager,
      UnaryCallable<ReqT, RespT> classic,
      UnaryShim<ReqT, RespT> experimental,
      Duration defaultTimeout) {
    this.configurationManager = configurationManager;
    this.classic = classic;
    this.experimental = experimental;
    this.defaultTimeout = defaultTimeout;
  }

  @Override
  public ApiFuture<RespT> futureCall(ReqT request, ApiCallContext context) {
    if (!useExperimental(request)) {
      return classic.futureCall(request, context);
    }

    Deadline deadline = Util.extractDeadline((GrpcCallContext) context, defaultTimeout);

    // Java8 futures dont chain cancellations
    // ApiFutures do, so we pipe cancellation via the ambient Context
    // futureCall is responsible for attaching/detaching
    // FutureAdapter is responsible for cleaning up the context
    CancellableContext ambientCtx = Context.current().withCancellation();

    CompletableFuture<RespT> f;

    try {
      f = ambientCtx.call(() -> experimental.call(request, deadline));
    } catch (Throwable e) {
      ambientCtx.close();

      Throwables.throwIfUnchecked(e);
      throw new RuntimeException(e);
    }

    f =
        f.handle(
            (r, e) -> {
              if (e != null) {
                throw translateException(e);
              }
              return r;
            });

    return new FutureAdapter<>(f, ambientCtx);
  }

  private boolean useExperimental(ReqT req) {
    if (!experimental.supports(req)) {
      return false;
    }

    float ratio =
        configurationManager.getClientConfiguration().getSessionConfiguration().getSessionLoad();
    if (ratio == 0) {
      return false;
    }
    if (ratio != 1.0 && ThreadLocalRandom.current().nextFloat() > ratio) {
      return false;
    }
    return true;
  }

  ApiException translateException(Throwable e) {
    Throwable cause = e;
    while (cause instanceof CompletionException || cause instanceof ExecutionException) {
      if (cause.getCause() != null) {
        cause = cause.getCause();
      } else {
        break;
      }
    }

    Status.Code code = Status.Code.UNKNOWN;

    if (cause instanceof StatusRuntimeException) {
      code = ((StatusRuntimeException) cause).getStatus().getCode();
    }
    if (cause instanceof StatusException) {
      code = ((StatusException) cause).getStatus().getCode();
    }

    return ApiExceptionFactory.createException(
        cause.getMessage(), e, GrpcStatusCode.of(code), false);
  }
}
