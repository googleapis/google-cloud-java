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
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/** A callable to fork traffic between classic and session based operations. */
public class DivertingUnaryCallable<ReqT, RespT> extends UnaryCallable<ReqT, RespT> {
  private static final Logger LOGGER = Logger.getLogger(DivertingUnaryCallable.class.getName());

  /** Bounds the cause walk so a self-referential or pathologically deep chain can't spin. */
  private static final int MAX_CAUSE_DEPTH = 32;

  /** Gates the WARNING-level log for unrecognized throwables to the first occurrence. */
  private final AtomicBoolean loggedUnrecognized = new AtomicBoolean();

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

    Status.Code code = findStatusCode(cause);
    if (code != null) {
      return ApiExceptionFactory.createException(
          cause.getMessage(), e, GrpcStatusCode.of(code), false);
    }

    // Nothing in the chain carries a gRPC status, so the only honest answer is UNKNOWN. Name the
    // throwable in the message rather than letting a bare "UNKNOWN" reach the caller: this is the
    // client's last chance to say what actually failed, and everything downstream (CSM, the
    // application's own error counters, the support case) sees only the code.
    reportUnrecognized(cause);
    return ApiExceptionFactory.createException(
        describeUnrecognized(cause), e, GrpcStatusCode.of(Status.Code.UNKNOWN), false);
  }

  /**
   * Returns the gRPC code for {@code t}, or null if nothing in its cause chain carries one.
   *
   * <p>Unlike a plain {@code instanceof} on the top-level throwable, this walks the whole chain: a
   * perfectly good {@link StatusRuntimeException} wrapped in any type other than Completion/
   * ExecutionException would otherwise lose its code and be reported as UNKNOWN. Mirrors {@code
   * csm.attributes.Util#extractStatus}, including its {@link CancellationException} case, so the
   * status the application sees agrees with the one CSM records for the same failure.
   */
  @Nullable
  private static Status.Code findStatusCode(Throwable t) {
    if (t instanceof CancellationException) {
      return Status.Code.CANCELLED;
    }
    Throwable current = t;
    for (int depth = 0; current != null && depth < MAX_CAUSE_DEPTH; depth++) {
      if (current instanceof StatusRuntimeException) {
        return ((StatusRuntimeException) current).getStatus().getCode();
      }
      if (current instanceof StatusException) {
        return ((StatusException) current).getStatus().getCode();
      }
      Throwable next = current.getCause();
      if (next == current) {
        break; // self-referential chain
      }
      current = next;
    }
    return null;
  }

  /** Renders the cause chain as class names, so the message identifies the failure by itself. */
  private static String describeUnrecognized(Throwable cause) {
    StringBuilder chain = new StringBuilder();
    Throwable current = cause;
    for (int depth = 0; current != null && depth < MAX_CAUSE_DEPTH; depth++) {
      if (chain.length() > 0) {
        chain.append(" <- ");
      }
      chain.append(current.getClass().getName());
      Throwable next = current.getCause();
      if (next == current) {
        break;
      }
      current = next;
    }
    String message = cause.getMessage();
    return "Session operation failed with an error that carries no gRPC status; reporting UNKNOWN."
        + " Cause chain: "
        + chain
        + (message != null ? ". Message: " + message : "");
  }

  /**
   * Logs the first unrecognized throwable per callable at WARNING with a full stack, and the rest
   * at FINE. A storm is exactly when this fires most, so an unconditional WARNING would flood the
   * log at the moment the operator can least afford it.
   */
  private void reportUnrecognized(Throwable cause) {
    if (loggedUnrecognized.compareAndSet(false, true)) {
      LOGGER.log(Level.WARNING, describeUnrecognized(cause), cause);
    } else if (LOGGER.isLoggable(Level.FINE)) {
      LOGGER.log(Level.FINE, describeUnrecognized(cause), cause);
    }
  }
}
