/*
 * Copyright 2019 Google LLC
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

package com.google.cloud.spanner.connection;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.cloud.spanner.BatchReadOnlyTransaction;
import com.google.cloud.spanner.BatchTransactionId;
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.OpenTelemetryContextKeys;
import com.google.cloud.spanner.Options.QueryOption;
import com.google.cloud.spanner.Options.RpcPriority;
import com.google.cloud.spanner.Partition;
import com.google.cloud.spanner.PartitionOptions;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.ResultSets;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.Struct;
import com.google.cloud.spanner.Type.StructField;
import com.google.cloud.spanner.connection.AbstractStatementParser.ParsedStatement;
import com.google.cloud.spanner.connection.StatementExecutor.StatementTimeout;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.MoreExecutors;
import io.grpc.Context;
import io.grpc.Deadline;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.context.Scope;
import java.time.Duration;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/** Base for all {@link Connection}-based transactions and batches. */
abstract class AbstractBaseUnitOfWork implements UnitOfWork {
  static final String DB_STATEMENT = "db.statement";
  static final AttributeKey<String> DB_STATEMENT_KEY = AttributeKey.stringKey(DB_STATEMENT);
  static final AttributeKey<List<String>> DB_STATEMENT_ARRAY_KEY =
      AttributeKey.stringArrayKey(DB_STATEMENT);

  private final StatementExecutor statementExecutor;
  private final StatementTimeout statementTimeout;
  protected final String transactionTag;
  protected final List<TransactionRetryListener> transactionRetryListeners;
  protected final boolean excludeTxnFromChangeStreams;
  protected final RpcPriority rpcPriority;
  protected final com.google.spanner.v1.RequestOptions.ClientContext clientContext;
  protected final Span span;

  /** Class for keeping track of the stacktrace of the caller of an async statement. */
  static final class SpannerAsyncExecutionException extends RuntimeException {
    final Statement statement;

    SpannerAsyncExecutionException(Statement statement) {
      this.statement = statement;
    }

    public String getMessage() {
      // We only include the SQL of the statement and not the parameter values to prevent
      // potentially sensitive data to escape into an error message.
      return String.format("Execution failed for statement: %s", statement.getSql());
    }
  }

  /**
   * The {@link Future} that monitors the result of the statement currently being executed for this
   * unit of work.
   */
  @GuardedBy("this")
  private volatile Future<?> currentlyRunningStatementFuture = null;

  enum InterceptorsUsage {
    INVOKE_INTERCEPTORS,
    IGNORE_INTERCEPTORS
  }

  abstract static class Builder<B extends Builder<?, T>, T extends AbstractBaseUnitOfWork> {
    private StatementExecutor statementExecutor;
    private StatementTimeout statementTimeout = new StatementTimeout();
    private String transactionTag;
    private List<TransactionRetryListener> transactionRetryListeners;

    private boolean excludeTxnFromChangeStreams;
    private RpcPriority rpcPriority;
    private com.google.spanner.v1.RequestOptions.ClientContext clientContext;
    private Span span;

    Builder() {}

    @SuppressWarnings("unchecked")
    B self() {
      return (B) this;
    }

    B withStatementExecutor(StatementExecutor executor) {
      Preconditions.checkNotNull(executor);
      this.statementExecutor = executor;
      return self();
    }

    B setStatementTimeout(StatementTimeout timeout) {
      Preconditions.checkNotNull(timeout);
      this.statementTimeout = timeout;
      return self();
    }

    B setTransactionRetryListeners(List<TransactionRetryListener> listeners) {
      Preconditions.checkNotNull(listeners);
      this.transactionRetryListeners = listeners;
      return self();
    }

    boolean hasTransactionRetryListeners() {
      return this.transactionRetryListeners != null;
    }

    B setTransactionTag(@Nullable String tag) {
      this.transactionTag = tag;
      return self();
    }

    B setExcludeTxnFromChangeStreams(boolean excludeTxnFromChangeStreams) {
      this.excludeTxnFromChangeStreams = excludeTxnFromChangeStreams;
      return self();
    }

    B setRpcPriority(@Nullable RpcPriority rpcPriority) {
      this.rpcPriority = rpcPriority;
      return self();
    }

    B setClientContext(@Nullable com.google.spanner.v1.RequestOptions.ClientContext clientContext) {
      this.clientContext = clientContext;
      return self();
    }

    B setSpan(@Nullable Span span) {
      this.span = span;
      return self();
    }

    abstract T build();
  }

  AbstractBaseUnitOfWork(Builder<?, ?> builder) {
    Preconditions.checkState(builder.statementExecutor != null, "No statement executor specified");
    this.statementExecutor = builder.statementExecutor;
    this.statementTimeout = builder.statementTimeout;
    this.transactionTag = builder.transactionTag;
    this.transactionRetryListeners = builder.transactionRetryListeners;
    this.excludeTxnFromChangeStreams = builder.excludeTxnFromChangeStreams;
    this.rpcPriority = builder.rpcPriority;
    this.clientContext = builder.clientContext;
    this.span = Preconditions.checkNotNull(builder.span);
  }

  @Override
  public Span getSpan() {
    return this.span;
  }

  ApiFuture<Void> asyncEndUnitOfWorkSpan() {
    return this.statementExecutor.submit(this::endUnitOfWorkSpan);
  }

  private Void endUnitOfWorkSpan() {
    if (this.span != null) {
      this.span.end();
    }
    return null;
  }

  /**
   * Returns a descriptive name for the type of transaction / unit of work. This is used in error
   * messages.
   */
  abstract String getUnitOfWorkName();

  @Override
  public void savepoint(@Nonnull String name, @Nonnull Dialect dialect) {
    throw SpannerExceptionFactory.newSpannerException(
        ErrorCode.FAILED_PRECONDITION, "Savepoint is not supported for " + getUnitOfWorkName());
  }

  @Override
  public void releaseSavepoint(@Nonnull String name) {
    throw SpannerExceptionFactory.newSpannerException(
        ErrorCode.FAILED_PRECONDITION,
        "Release savepoint is not supported for " + getUnitOfWorkName());
  }

  @Override
  public void rollbackToSavepoint(
      @Nonnull String name, @Nonnull SavepointSupport savepointSupport) {
    throw SpannerExceptionFactory.newSpannerException(
        ErrorCode.FAILED_PRECONDITION,
        "Rollback to savepoint is not supported for " + getUnitOfWorkName());
  }

  @Override
  public ApiFuture<ResultSet> partitionQueryAsync(
      CallType callType,
      ParsedStatement query,
      PartitionOptions partitionOptions,
      QueryOption... options) {
    throw SpannerExceptionFactory.newSpannerException(
        ErrorCode.FAILED_PRECONDITION,
        "Partition query is not supported for " + getUnitOfWorkName());
  }

  ResultSet partitionQuery(
      BatchReadOnlyTransaction transaction,
      PartitionOptions partitionOptions,
      ParsedStatement query,
      QueryOption... options) {
    final String partitionColumnName = "PARTITION";
    BatchTransactionId transactionId = transaction.getBatchTransactionId();
    List<Partition> partitions =
        transaction.partitionQuery(partitionOptions, query.getStatement(), options);
    return ResultSets.forRows(
        com.google.cloud.spanner.Type.struct(
            StructField.of(partitionColumnName, com.google.cloud.spanner.Type.string())),
        partitions.stream()
            .map(
                partition ->
                    Struct.newBuilder()
                        .set(partitionColumnName)
                        .to(PartitionId.encodeToString(transactionId, partition))
                        .build())
            .collect(Collectors.toList()));
  }

  StatementExecutor getStatementExecutor() {
    return statementExecutor;
  }

  StatementTimeout getStatementTimeout() {
    return statementTimeout;
  }

  @Override
  public void cancel() {
    synchronized (this) {
      if (currentlyRunningStatementFuture != null
          && !currentlyRunningStatementFuture.isDone()
          && !currentlyRunningStatementFuture.isCancelled()) {
        currentlyRunningStatementFuture.cancel(true);
      }
    }
  }

  <T> ApiFuture<T> executeStatementAsync(
      CallType callType,
      ParsedStatement statement,
      Callable<T> callable,
      @Nullable MethodDescriptor<?, ?> applyStatementTimeoutToMethod) {
    return executeStatementAsync(
        callType,
        statement,
        callable,
        InterceptorsUsage.INVOKE_INTERCEPTORS,
        applyStatementTimeoutToMethod == null
            ? Collections.emptySet()
            : ImmutableList.of(applyStatementTimeoutToMethod));
  }

  <T> ApiFuture<T> executeStatementAsync(
      CallType callType,
      ParsedStatement statement,
      Callable<T> callable,
      Collection<MethodDescriptor<?, ?>> applyStatementTimeoutToMethods) {
    return executeStatementAsync(
        callType,
        statement,
        callable,
        InterceptorsUsage.INVOKE_INTERCEPTORS,
        applyStatementTimeoutToMethods);
  }

  <ResponseT, MetadataT> ResponseT getWithStatementTimeout(
      OperationFuture<ResponseT, MetadataT> operation, ParsedStatement statement) {
    ResponseT res;
    try {
      if (statementTimeout.hasTimeout()) {
        TimeUnit unit = statementTimeout.getAppropriateTimeUnit();
        res = operation.get(statementTimeout.getTimeoutValue(unit), unit);
      } else {
        res = operation.get();
      }
    } catch (TimeoutException e) {
      throw SpannerExceptionFactory.newSpannerException(
          ErrorCode.DEADLINE_EXCEEDED,
          "Statement execution timeout occurred for " + statement.getSql(),
          e);
    } catch (ExecutionException e) {
      Throwable cause = e.getCause();
      Set<Throwable> causes = new HashSet<>();
      while (cause != null && !causes.contains(cause)) {
        if (cause instanceof SpannerException) {
          throw (SpannerException) cause;
        }
        causes.add(cause);
        cause = cause.getCause();
      }
      throw SpannerExceptionFactory.newSpannerException(
          ErrorCode.fromGrpcStatus(Status.fromThrowable(e)),
          "Statement execution failed for " + statement.getSql(),
          e);
    } catch (InterruptedException e) {
      throw SpannerExceptionFactory.newSpannerException(
          ErrorCode.CANCELLED, "Statement execution was interrupted", e);
    } catch (CancellationException e) {
      throw SpannerExceptionFactory.newSpannerException(
          ErrorCode.CANCELLED, "Statement execution was cancelled", e);
    }
    return res;
  }

  <T> ApiFuture<T> executeStatementAsync(
      CallType callType,
      ParsedStatement statement,
      Callable<T> callable,
      InterceptorsUsage interceptorUsage,
      final Collection<MethodDescriptor<?, ?>> applyStatementTimeoutToMethods) {
    Preconditions.checkNotNull(statement);
    Preconditions.checkNotNull(callable);

    if (interceptorUsage == InterceptorsUsage.INVOKE_INTERCEPTORS) {
      statementExecutor.invokeInterceptors(
          statement, StatementExecutionStep.EXECUTE_STATEMENT, this);
    }
    Context context = Context.current();
    Deadline transactionDeadline = getTransactionDeadline();
    Deadline statementDeadline =
        statementTimeout.hasTimeout()
            ? Deadline.after(
                statementTimeout.getTimeoutValue(TimeUnit.NANOSECONDS), TimeUnit.NANOSECONDS)
            : null;
    Deadline effectiveDeadline = min(transactionDeadline, statementDeadline);
    if (effectiveDeadline != null && !applyStatementTimeoutToMethods.isEmpty()) {
      context =
          context.withValue(
              SpannerOptions.CALL_CONTEXT_CONFIGURATOR_KEY,
              new SpannerOptions.CallContextConfigurator() {
                @Override
                public <ReqT, RespT> ApiCallContext configure(
                    ApiCallContext context, ReqT request, MethodDescriptor<ReqT, RespT> method) {
                  if (applyStatementTimeoutToMethods.contains(method)) {
                    // Calculate the remaining timeout. This method could be called multiple times
                    // if the transaction is retried.
                    long remainingTimeout = effectiveDeadline.timeRemaining(TimeUnit.NANOSECONDS);
                    if (remainingTimeout <= 0) {
                      remainingTimeout = 1;
                    }
                    return GrpcCallContext.createDefault()
                        .withTimeoutDuration(Duration.ofNanos(remainingTimeout));
                  }
                  return null;
                }
              });
    }
    // Register the name of the thread that called this method as the thread name that should be
    // traced.
    try (Scope ignore =
        io.opentelemetry.context.Context.current()
            .with(OpenTelemetryContextKeys.THREAD_NAME_KEY, Thread.currentThread().getName())
            .makeCurrent()) {
      ApiFuture<T> f = statementExecutor.submit(context.wrap(callable));
      final SpannerAsyncExecutionException caller =
          callType == CallType.ASYNC
              ? new SpannerAsyncExecutionException(statement.getStatement())
              : null;
      final ApiFuture<T> future =
          ApiFutures.catching(
              f,
              Throwable.class,
              input -> {
                if (caller != null) {
                  input.addSuppressed(caller);
                }
                throw SpannerExceptionFactory.asSpannerException(input);
              },
              MoreExecutors.directExecutor());
      synchronized (this) {
        this.currentlyRunningStatementFuture = future;
      }
      future.addListener(
          new Runnable() {
            @Override
            public void run() {
              synchronized (this) {
                if (currentlyRunningStatementFuture == future) {
                  currentlyRunningStatementFuture = null;
                }
              }
              if (isSingleUse()) {
                endUnitOfWorkSpan();
              }
            }
          },
          MoreExecutors.directExecutor());
      return future;
    }
  }

  @Nullable
  static Deadline min(@Nullable Deadline a, @Nullable Deadline b) {
    if (a == null && b == null) {
      return null;
    }
    if (a == null) {
      return b;
    }
    if (b == null) {
      return a;
    }
    return a.minimum(b);
  }

  @Nullable
  Deadline getTransactionDeadline() {
    return null;
  }
}
