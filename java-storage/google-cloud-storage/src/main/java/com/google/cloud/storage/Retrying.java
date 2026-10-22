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
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.api.metrics.LongCounter;
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
      return new DefaultRetrierWithAlg(this, alg);
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

    default <Response, Model> Model run(
        Callable<Response> c,
        Decoder<Response, Model> d,
        @Nullable StorageMetricsContext metricsContext) {
      return run(neverRetry(), c, d, metricsContext);
    }

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
      try {
        Response call = c.call();
        return call == null ? null : d.decode(call);
      } catch (Exception iae) {
        throw StorageException.coalesce(iae);
      }
    }
  }

  static final class DefaultRetrierWithAlg implements RetrierWithAlg {
    private final Retrier retrier;
    private final ResultRetryAlgorithm<?> alg;

    private DefaultRetrierWithAlg(Retrier retrier, ResultRetryAlgorithm<?> alg) {
      this.retrier = retrier;
      this.alg = alg;
    }

    @Override
    public <Response, Model> Model run(
        ResultRetryAlgorithm<?> alg,
        Callable<Response> c,
        Decoder<Response, Model> d,
        @Nullable StorageMetricsContext metricsContext) {
      return retrier.run(alg, c, d, metricsContext);
    }

    @Override
    public <Response, Model> Model run(Callable<Response> c, Decoder<Response, Model> d) {
      return retrier.run(alg, c, d, null);
    }

    @Override
    public <Response, Model> Model run(
        Callable<Response> c,
        Decoder<Response, Model> d,
        @Nullable StorageMetricsContext metricsContext) {
      return retrier.run(alg, c, d, metricsContext);
    }
  }

  static final class DefaultRetrier implements Retrier {
    private final UnaryOperator<RetryContext> decorator;
    private final RetryingDependencies deps;
    @Nullable private final StorageClientMetrics metrics;

    DefaultRetrier(UnaryOperator<RetryContext> decorator, RetryingDependencies deps) {
      this(decorator, deps, deps != null ? deps.getStorageClientMetrics() : null);
    }

    DefaultRetrier(
        UnaryOperator<RetryContext> decorator,
        RetryingDependencies deps,
        @Nullable StorageClientMetrics metrics) {
      this.decorator = decorator;
      this.deps = deps;
      this.metrics =
          metrics != null ? metrics : (deps != null ? deps.getStorageClientMetrics() : null);
    }

    @Override
    public <Response, Model> Model run(
        ResultRetryAlgorithm<?> alg,
        Callable<Response> c,
        Decoder<Response, Model> d,
        @Nullable StorageMetricsContext metricsContext) {
      if (metrics == null || metricsContext == null) {
        return runWithoutMetrics(alg, c, d);
      }

      StorageMetricsContext activeContext = metricsContext;
      Attributes clientAttributes = metrics.getClientAttributes();

      AttributesBuilder baseBuilder = Attributes.builder();
      baseBuilder.putAll(clientAttributes);
      activeContext
          .getBaseAttributes()
          .forEach(
              (key, val) -> {
                if (!key.equals(StorageClientMetrics.KEY_RPC_METHOD)
                    && !key.equals(StorageClientMetrics.KEY_NETWORK_PATH)
                    && !key.equals(StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE)
                    && !key.equals(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE)) {
                  @SuppressWarnings("unchecked")
                  AttributeKey<Object> objKey = (AttributeKey<Object>) key;
                  baseBuilder.put(objKey, val);
                }
              });
      baseBuilder.put(
          StorageClientMetrics.KEY_GCP_STORAGE_OPERATION, activeContext.getOperationName());
      Attributes baseAttributes = baseBuilder.build();

      LongCounter attemptsCounter = metrics.getAttempts();
      LongCounter errorsCounter = metrics.getErrors();

      try (Scope ignore = activeContext.getOtelContext().makeCurrent()) {
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
            activeContext.incrementAttempts();
            try {
              Response result = c.call();
              recordAttemptSuccess(attemptsCounter, baseAttributes, activeContext);
              return result == null ? null : d.decode(result);
            } catch (StorageException se) {
              String errorType = StorageErrorTypeMapper.mapThrowable(se);
              recordAttemptFailure(
                  attemptsCounter, errorsCounter, baseAttributes, activeContext, se, errorType);
              ctx.recordError(se, () -> attemptAgain.set(true), failure::set);
            } catch (IllegalArgumentException iae) {
              String errorType = StorageErrorTypeMapper.mapThrowable(iae);
              recordAttemptFailure(
                  attemptsCounter, errorsCounter, baseAttributes, activeContext, iae, errorType);
              ctx.recordError(iae, () -> attemptAgain.set(true), failure::set);
            } catch (Exception e) {
              String errorType = StorageErrorTypeMapper.mapThrowable(e);
              recordAttemptFailure(
                  attemptsCounter, errorsCounter, baseAttributes, activeContext, e, errorType);
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
          if (activeContext.shouldRecordOperationOnRetrierExit()) {
            activeContext.recordOperation(metrics, terminalThrowable);
          }
        }
      }
    }

    private static void recordAttemptSuccess(
        @Nullable LongCounter attemptsCounter,
        Attributes baseAttributes,
        StorageMetricsContext activeContext) {
      if (attemptsCounter == null) {
        return;
      }
      AttributesBuilder builder =
          baseAttributes.toBuilder()
              .put(StorageClientMetrics.KEY_ERROR_TYPE, StorageErrorTypeMapper.STATUS_OK)
              .put(StorageClientMetrics.KEY_NETWORK_PATH, resolveNetworkPath(activeContext));
      String rpcSystemName =
          activeContext.getBaseAttributes().get(StorageClientMetrics.KEY_RPC_SYSTEM_NAME);
      if ("grpc".equals(rpcSystemName)) {
        builder.put(StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE, "OK");
      } else if ("http".equals(rpcSystemName)) {
        builder.put(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE, 200L);
      }
      String rpcCode =
          activeContext.getBaseAttributes().get(StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE);
      if (rpcCode != null) {
        builder.put(StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE, rpcCode);
      }
      Long httpCode =
          activeContext.getBaseAttributes().get(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE);
      if (httpCode != null) {
        builder.put(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE, httpCode);
      }
      attemptsCounter.add(1, builder.build());
    }

    private static void recordAttemptFailure(
        @Nullable LongCounter attemptsCounter,
        @Nullable LongCounter errorsCounter,
        Attributes baseAttributes,
        StorageMetricsContext activeContext,
        Throwable e,
        String errorType) {
      String networkPath = resolveNetworkPath(activeContext);
      if (errorsCounter != null) {
        Attributes errorAttributes =
            baseAttributes.toBuilder()
                .put(StorageClientMetrics.KEY_ERROR_TYPE, errorType)
                .put(StorageClientMetrics.KEY_NETWORK_PATH, networkPath)
                .build();
        errorsCounter.add(1, errorAttributes);
      }
      if (attemptsCounter != null) {
        AttributesBuilder builder =
            baseAttributes.toBuilder()
                .put(StorageClientMetrics.KEY_ERROR_TYPE, errorType)
                .put(StorageClientMetrics.KEY_NETWORK_PATH, networkPath);
        String rpcStatus = extractRpcStatusCode(e, activeContext);
        if (rpcStatus != null) {
          builder.put(StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE, rpcStatus);
        }
        Long httpStatus = extractHttpStatusCode(e, activeContext);
        if (httpStatus != null) {
          builder.put(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE, httpStatus);
        }
        attemptsCounter.add(1, builder.build());
      }
    }

    private static String resolveNetworkPath(StorageMetricsContext ctx) {
      String path = ctx.getBaseAttributes().get(StorageClientMetrics.KEY_NETWORK_PATH);
      if (path != null && !path.isEmpty()) {
        return path;
      }
      return StorageClientMetrics.NETWORK_PATH_CLOUDPATH;
    }

    @Nullable
    private static String extractRpcStatusCode(Throwable e, StorageMetricsContext activeContext) {
      String fromContext =
          activeContext.getBaseAttributes().get(StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE);
      if (fromContext != null) {
        return fromContext;
      }
      Throwable curr = e;
      while (curr != null) {
        if (curr instanceof io.grpc.StatusRuntimeException) {
          return ((io.grpc.StatusRuntimeException) curr).getStatus().getCode().name();
        }
        if (curr instanceof io.grpc.StatusException) {
          return ((io.grpc.StatusException) curr).getStatus().getCode().name();
        }
        if (curr instanceof com.google.api.gax.rpc.ApiException) {
          return ((com.google.api.gax.rpc.ApiException) curr).getStatusCode().getCode().name();
        }
        curr = curr.getCause();
      }
      return null;
    }

    @Nullable
    private static Long extractHttpStatusCode(Throwable e, StorageMetricsContext activeContext) {
      Long fromContext =
          activeContext.getBaseAttributes().get(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE);
      if (fromContext != null) {
        return fromContext;
      }
      Throwable curr = e;
      while (curr != null) {
        if (curr instanceof StorageException) {
          int code = ((StorageException) curr).getCode();
          if (code > 0) {
            return (long) code;
          }
        }
        if (curr instanceof com.google.api.client.http.HttpResponseException) {
          int code = ((com.google.api.client.http.HttpResponseException) curr).getStatusCode();
          if (code > 0) {
            return (long) code;
          }
        }
        curr = curr.getCause();
      }
      return null;
    }

    private <Response, Model> Model runWithoutMetrics(
        ResultRetryAlgorithm<?> alg, Callable<Response> c, Decoder<Response, Model> d) {
      RetryContext ctx =
          decorator.apply(
              RetryContext.of(
                  RetryContext.directScheduledExecutorService(),
                  deps,
                  alg,
                  Jitterer.threadLocalRandom()));
      AtomicReference<Exception> failure = new AtomicReference<>();
      AtomicBoolean attemptAgain = new AtomicBoolean(false);

      do {
        attemptAgain.set(false);
        try {
          Response result = c.call();
          return result == null ? null : d.decode(result);
        } catch (StorageException se) {
          ctx.recordError(se, () -> attemptAgain.set(true), failure::set);
        } catch (IllegalArgumentException iae) {
          ctx.recordError(iae, () -> attemptAgain.set(true), failure::set);
        } catch (Exception e) {
          BaseServiceException coalesced = StorageException.coalesce(e);
          ctx.recordError(coalesced, () -> attemptAgain.set(true), failure::set);
        }
      } while (attemptAgain.get());

      Exception throwable = failure.get();
      if (throwable instanceof StorageException) {
        throw (StorageException) throwable;
      } else {
        throw StorageException.coalesce(throwable);
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

    default @Nullable StorageClientMetrics getStorageClientMetrics() {
      return null;
    }

    static RetryingDependencies attemptOnce() {
      return RetryingDependencies.simple(
          NanoClock.getDefaultClock(), RetrySettings.newBuilder().setMaxAttempts(1).build());
    }

    static RetryingDependencies simple(ApiClock clock, RetrySettings retrySettings) {
      return new SimpleRetryingDependencies(clock, retrySettings, null);
    }

    static RetryingDependencies simple(
        ApiClock clock, RetrySettings retrySettings, @Nullable StorageClientMetrics metrics) {
      return new SimpleRetryingDependencies(clock, retrySettings, metrics);
    }
  }

  private static final class SimpleRetryingDependencies implements RetryingDependencies {
    private final ApiClock clock;
    private final RetrySettings retrySettings;
    @Nullable private final StorageClientMetrics storageClientMetrics;

    private SimpleRetryingDependencies(
        ApiClock clock,
        RetrySettings retrySettings,
        @Nullable StorageClientMetrics storageClientMetrics) {
      this.retrySettings = retrySettings;
      this.clock = clock;
      this.storageClientMetrics = storageClientMetrics;
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
    public @Nullable StorageClientMetrics getStorageClientMetrics() {
      return storageClientMetrics;
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("clock", clock)
          .add("retrySettings", retrySettings)
          .add("storageClientMetrics", storageClientMetrics)
          .toString();
    }
  }
}
