/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.storage;

import com.google.api.core.ApiClock;
import com.google.api.core.NanoClock;
import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.gax.retrying.BasicResultRetryAlgorithm;
import com.google.api.gax.retrying.ResultRetryAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.cloud.BaseServiceException;
import com.google.cloud.storage.Backoff.Jitterer;
import com.google.cloud.storage.Conversions.Decoder;
import com.google.cloud.storage.spi.v1.HttpRpcContext;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import io.opentelemetry.context.Scope;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.UnaryOperator;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

final class Retrying {

  /**
   * A simple interface to abstract the lifecycle of running an operation, and conditionally
   * retrying if an error is encountered.
   */
  interface Retrier {
    /**
     * A convenience method to invoke a callable, and possibly retry it again if an exception is
     * thrown. If the result of {@code c} is non-null, Decoder {@code d} will be applied to the
     * result before returning.
     *
     * @param <Response> The result type of {@code c}
     * @param <Model> The result type of any mapping that takes place via {@code d}
     * @param alg The {@link ResultRetryAlgorithm} to use when determining if a retry is possible
     * @param c The {@link Callable} which will be passed to runWithRetries producing some {@code
     *     T}, can optionally return null
     * @param d A post process mapping {@link Function} which can be used to transform the result
     *     from {@code c} if it is successful and non-null
     * @param metricsContext optional metrics context for tracking logical operation metrics
     * @return A {@code U} (possibly null) after applying {@code f} to the result of {@code c}
     * @throws StorageException if {@code c} fails due to any retry exhaustion
     */
    <Response, Model> Model run(
        ResultRetryAlgorithm<?> alg,
        Callable<Response> c,
        Decoder<Response, Model> d,
        @Nullable StorageMetricsContext metricsContext);

    default <Response, Model> Model run(
        ResultRetryAlgorithm<?> alg, Callable<Response> c, Decoder<Response, Model> d) {
      return run(alg, c, d, null);
    }

    default RetrierWithAlg withAlg(ResultRetryAlgorithm<?> alg) {
      return withAlg(alg, null);
    }

    default RetrierWithAlg withAlg(
        ResultRetryAlgorithm<?> alg, @Nullable StorageMetricsContext metricsContext) {
      return new DefaultRetrierWithAlg(this, alg, metricsContext);
    }

    default Retrier withMetricsContext(@Nullable StorageMetricsContext metricsContext) {
      return metricsContext == null ? this : new ContextBoundRetrier(this, metricsContext);
    }

    static Retrier attemptOnce() {
      return AttemptOnceRetrier.INSTANCE;
    }
  }

  /**
   * A specialization of {@link Retrier} where the {@link ResultRetryAlgorithm} is bound to the
   * instance of this interface, and need to be supplied to the {@link #run(Callable, Decoder)}
   * method.
   */
  interface RetrierWithAlg extends Retrier {

    <Response, Model> Model run(Callable<Response> c, Decoder<Response, Model> d);

    <Response, Model> Model run(
        Callable<Response> c,
        Decoder<Response, Model> d,
        @Nullable StorageMetricsContext metricsContext);

    static RetrierWithAlg attemptOnce() {
      return AttemptOnceRetrier.INSTANCE_WITH_ALG;
    }
  }

  static final class AttemptOnceRetrier implements Retrier {
    private static final AttemptOnceRetrier INSTANCE = new AttemptOnceRetrier();
    private static final RetrierWithAlg INSTANCE_WITH_ALG = INSTANCE.withAlg(neverRetry());

    @Override
    public <Response, Model> Model run(
        ResultRetryAlgorithm<?> alg,
        Callable<Response> c,
        Decoder<Response, Model> d,
        @Nullable StorageMetricsContext metricsContext) {
      try (Scope ignore =
          metricsContext != null ? metricsContext.getOtelContext().makeCurrent() : null) {
        if (metricsContext != null) {
          metricsContext.incrementAttempts();
        }
        Response call = c.call();
        return call == null ? null : d.decode(call);
      } catch (Exception iae) {
        throw StorageException.coalesce(iae);
      }
    }
  }

  static final class ContextBoundRetrier implements Retrier {
    private final Retrier delegate;
    private final StorageMetricsContext metricsContext;

    ContextBoundRetrier(Retrier delegate, StorageMetricsContext metricsContext) {
      this.delegate = delegate;
      this.metricsContext = metricsContext;
    }

    @Override
    public <Response, Model> Model run(
        ResultRetryAlgorithm<?> alg,
        Callable<Response> c,
        Decoder<Response, Model> d,
        @Nullable StorageMetricsContext explicitCtx) {
      return delegate.run(alg, c, d, explicitCtx != null ? explicitCtx : metricsContext);
    }

    @Override
    public <Response, Model> Model run(
        ResultRetryAlgorithm<?> alg, Callable<Response> c, Decoder<Response, Model> d) {
      return delegate.run(alg, c, d, metricsContext);
    }

    @Override
    public RetrierWithAlg withAlg(ResultRetryAlgorithm<?> alg) {
      return delegate.withAlg(alg, metricsContext);
    }

    @Override
    public RetrierWithAlg withAlg(
        ResultRetryAlgorithm<?> alg, @Nullable StorageMetricsContext explicitCtx) {
      return delegate.withAlg(alg, explicitCtx != null ? explicitCtx : metricsContext);
    }

    @Override
    public Retrier withMetricsContext(@Nullable StorageMetricsContext explicitCtx) {
      return explicitCtx != null ? new ContextBoundRetrier(delegate, explicitCtx) : this;
    }
  }

  static final class DefaultRetrierWithAlg implements RetrierWithAlg {
    private final Retrier retrier;
    private final ResultRetryAlgorithm<?> alg;
    @Nullable private final StorageMetricsContext boundMetricsContext;

    private DefaultRetrierWithAlg(
        Retrier retrier,
        ResultRetryAlgorithm<?> alg,
        @Nullable StorageMetricsContext boundMetricsContext) {
      this.retrier = retrier;
      this.alg = alg;
      this.boundMetricsContext = boundMetricsContext;
    }

    @Override
    public <Response, Model> Model run(Callable<Response> c, Decoder<Response, Model> d) {
      return retrier.run(alg, c, d, boundMetricsContext);
    }

    @Override
    public <Response, Model> Model run(
        ResultRetryAlgorithm<?> alg, Callable<Response> c, Decoder<Response, Model> d) {
      return retrier.run(alg, c, d, boundMetricsContext);
    }

    @Override
    public <Response, Model> Model run(
        Callable<Response> c,
        Decoder<Response, Model> d,
        @Nullable StorageMetricsContext metricsContext) {
      return retrier.run(alg, c, d, metricsContext != null ? metricsContext : boundMetricsContext);
    }

    @Override
    public <Response, Model> Model run(
        ResultRetryAlgorithm<?> alg,
        Callable<Response> c,
        Decoder<Response, Model> d,
        @Nullable StorageMetricsContext metricsContext) {
      return retrier.run(alg, c, d, metricsContext != null ? metricsContext : boundMetricsContext);
    }
  }

  static final class DefaultRetrier implements Retrier {
    private final UnaryOperator<RetryContext> decorator;
    private final RetryingDependencies deps;
    @Nullable private final StorageClientMetrics metrics;

    DefaultRetrier(UnaryOperator<RetryContext> decorator, RetryingDependencies deps) {
      this(decorator, deps, null);
    }

    DefaultRetrier(
        UnaryOperator<RetryContext> decorator,
        RetryingDependencies deps,
        @Nullable StorageClientMetrics metrics) {
      this.decorator = decorator;
      this.deps = deps;
      this.metrics = metrics;
    }

    @Override
    public <Response, Model> Model run(
        ResultRetryAlgorithm<?> alg,
        Callable<Response> c,
        Decoder<Response, Model> d,
        @Nullable StorageMetricsContext metricsContext) {
      try (Scope ignore =
          metricsContext != null ? metricsContext.getOtelContext().makeCurrent() : null) {
        RetryContext ctx =
            decorator.apply(
                RetryContext.of(
                    RetryContext.directScheduledExecutorService(),
                    deps,
                    alg,
                    Jitterer.threadLocalRandom()));
        AtomicReference<Exception> failure = new AtomicReference<>();
        AtomicBoolean attemptAgain = new AtomicBoolean(false);
        Throwable terminalThrowable = null;

        try {
          do {
            attemptAgain.set(false);
            if (metricsContext != null) {
              metricsContext.incrementAttempts();
            }
            try {
              Response result = c.call();
              Model decoded = result == null ? null : d.decode(result);
              if (metricsContext != null) {
                metricsContext.recordAttemptSuccess(metrics);
              }
              return decoded;
            } catch (StorageException se) {
              if (metricsContext != null) {
                metricsContext.recordAttemptFailure(metrics, se);
              }
              ctx.recordError(se, () -> attemptAgain.set(true), failure::set);
            } catch (IllegalArgumentException iae) {
              if (metricsContext != null) {
                metricsContext.recordAttemptFailure(metrics, iae);
              }
              ctx.recordError(iae, () -> attemptAgain.set(true), failure::set);
            } catch (Exception e) {
              if (metricsContext != null) {
                metricsContext.recordAttemptFailure(metrics, e);
              }
              BaseServiceException coalesced = StorageException.coalesce(e);
              ctx.recordError(coalesced, () -> attemptAgain.set(true), failure::set);
            }
          } while (attemptAgain.get());

          Exception throwable = failure.get();
          terminalThrowable = throwable;
          if (throwable instanceof StorageException) {
            throw (StorageException) throwable;
          } else if (throwable != null) {
            throw StorageException.coalesce(throwable);
          } else {
            throw new StorageException(0, "Retry failed without exception");
          }
        } catch (Throwable t) {
          terminalThrowable = t;
          throw t;
        } finally {
          if (metricsContext != null && metricsContext.shouldRecordOperationOnRetrierExit()) {
            metricsContext.recordOperation(metrics, terminalThrowable);
          }
        }
      }
    }
  }

  static final class HttpRetrier implements Retrier {
    private final Retrier delegate;

    HttpRetrier(Retrier delegate) {
      this.delegate = delegate;
    }

    @Override
    public <Response, Model> Model run(
        ResultRetryAlgorithm<?> alg,
        Callable<Response> c,
        Decoder<Response, Model> d,
        @Nullable StorageMetricsContext metricsContext) {
      HttpRpcContext httpRpcContext = HttpRpcContext.getInstance();
      try {
        httpRpcContext.newInvocationId();
        return delegate.run(alg, c, d, metricsContext);
      } finally {
        httpRpcContext.clearInvocationId();
      }
    }
  }

  @NonNull
  static GrpcCallContext newCallContext() {
    return newCallContext(null);
  }

  @NonNull
  static GrpcCallContext newCallContext(@Nullable StorageMetricsContext metricsContext) {
    GrpcCallContext context =
        GrpcCallContext.createDefault()
            .withExtraHeaders(
                ImmutableMap.of(
                    "x-goog-gcs-idempotency-token",
                    ImmutableList.of(UUID.randomUUID().toString())));
    if (metricsContext != null) {
      context = metricsContext.attach(context);
    }
    return context;
  }

  static ResultRetryAlgorithm<?> neverRetry() {
    return new BasicResultRetryAlgorithm<Object>() {
      @Override
      public boolean shouldRetry(Throwable previousThrowable, Object previousResponse) {
        return false;
      }
    };
  }

  static ResultRetryAlgorithm<?> alwaysRetry() {
    return new BasicResultRetryAlgorithm<Object>() {
      @Override
      public boolean shouldRetry(Throwable previousThrowable, Object previousResponse) {
        return true;
      }
    };
  }

  /**
   * Rather than requiring a full set of {@link StorageOptions} to be passed specify what we
   * actually need and have StorageOptions implement this interface.
   */
  interface RetryingDependencies {

    RetrySettings getRetrySettings();

    ApiClock getClock();

    static RetryingDependencies attemptOnce() {
      return RetryingDependencies.simple(
          NanoClock.getDefaultClock(), RetrySettings.newBuilder().setMaxAttempts(1).build());
    }

    static RetryingDependencies simple(ApiClock clock, RetrySettings retrySettings) {
      return new SimpleRetryingDependencies(clock, retrySettings);
    }
  }

  private static final class SimpleRetryingDependencies implements RetryingDependencies {
    private final ApiClock clock;
    private final RetrySettings retrySettings;

    private SimpleRetryingDependencies(ApiClock clock, RetrySettings retrySettings) {
      this.retrySettings = retrySettings;
      this.clock = clock;
    }

    @Override
    public ApiClock getClock() {
      return clock;
    }

    @Override
    public RetrySettings getRetrySettings() {
      return retrySettings;
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("clock", clock)
          .add("retrySettings", retrySettings)
          .toString();
    }
  }
}
