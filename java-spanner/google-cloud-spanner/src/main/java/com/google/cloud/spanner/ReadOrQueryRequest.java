/*
 * Copyright 2026 Google LLC
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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.StatusCode.Code;
import com.google.cloud.spanner.spi.v1.SpannerRpc;
import com.google.protobuf.ByteString;
import com.google.spanner.v1.DirectedReadOptions;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.ReadRequest;
import com.google.spanner.v1.RequestOptions;
import com.google.spanner.v1.TransactionSelector;
import java.util.Map;
import java.util.Set;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * Package-private abstraction around either an {@link ExecuteSqlRequest.Builder} or a {@link
 * ReadRequest.Builder} to unify common request options, streaming request preparation, and
 * execution in {@link AbstractReadContext}.
 */
@NullMarked
abstract class ReadOrQueryRequest {

  static Query forQuery(
      AbstractReadContext context,
      ExecuteSqlRequest.Builder builder,
      Statement statement,
      Options options,
      @Nullable ByteString partitionToken) {
    return applyOptions(new Query(builder, statement), context, options, partitionToken);
  }

  static Read forRead(
      AbstractReadContext context,
      ReadRequest.Builder builder,
      Options options,
      @Nullable ByteString partitionToken) {
    return applyOptions(new Read(builder), context, options, partitionToken);
  }

  private static <T extends ReadOrQueryRequest> T applyOptions(
      T request,
      AbstractReadContext context,
      Options options,
      @Nullable ByteString partitionToken) {
    request.setSession(context.session.getName());
    if (partitionToken != null) {
      request.setPartitionToken(partitionToken);
    }
    if (options.hasDataBoostEnabled()) {
      request.setDataBoostEnabled(options.dataBoostEnabled());
    }
    if (options.hasDirectedReadOptions()) {
      request.setDirectedReadOptions(options.directedReadOptions());
    } else if (context.defaultDirectedReadOptions != null) {
      request.setDirectedReadOptions(context.defaultDirectedReadOptions);
    }
    request.setRequestOptions(context.buildRequestOptions(options));
    return request;
  }

  /**
   * Indicates whether the most recently configured {@link TransactionSelector} carries an inlined
   * {@code begin} option. The underlying protobuf {@code Builder} is only accessed from {@code
   * startStream()}, whereas this field is {@code volatile} so {@link #isWithBeginTransaction()} can
   * be read safely from a concurrent {@link GrpcResultSet#close()} call.
   */
  private volatile boolean withBeginTransaction;

  private ReadOrQueryRequest(boolean withBeginTransaction) {
    this.withBeginTransaction = withBeginTransaction;
  }

  abstract String getOperationName();

  abstract RetrySettings getRetrySettings(SpannerRpc rpc);

  abstract Set<Code> getRetryableCodes(SpannerRpc rpc);

  abstract @Nullable Statement getStatement();

  abstract void setSession(String session);

  abstract void setPartitionToken(ByteString partitionToken);

  abstract void setDataBoostEnabled(boolean dataBoostEnabled);

  abstract void setDirectedReadOptions(DirectedReadOptions directedReadOptions);

  abstract void setRequestOptions(RequestOptions requestOptions);

  abstract void setResumeToken(ByteString resumeToken);

  abstract boolean hasTransaction();

  final void setTransaction(TransactionSelector selector) {
    setTransactionInternal(selector);
    this.withBeginTransaction = selector.hasBegin();
  }

  /**
   * Returns {@code true} if the current {@link TransactionSelector} on this request includes an
   * inlined {@code BeginTransaction} option. Safe to call concurrently with {@code startStream()}.
   */
  final boolean isWithBeginTransaction() {
    return withBeginTransaction;
  }

  abstract void setTransactionInternal(TransactionSelector selector);

  abstract SpannerRpc.StreamingCall start(
      SpannerRpc rpc,
      SpannerRpc.ResultStreamConsumer consumer,
      @Nullable Map<SpannerRpc.Option, ?> channelHint,
      XGoogSpannerRequestId requestId,
      boolean routeToLeader);

  static final class Query extends ReadOrQueryRequest {
    private final ExecuteSqlRequest.Builder builder;
    private final Statement statement;

    private Query(ExecuteSqlRequest.Builder builder, Statement statement) {
      super(checkNotNull(builder).getTransaction().hasBegin());
      this.builder = builder;
      this.statement = checkNotNull(statement);
    }

    ExecuteSqlRequest.Builder getBuilder() {
      return builder;
    }

    @Override
    String getOperationName() {
      return SpannerImpl.QUERY;
    }

    @Override
    RetrySettings getRetrySettings(SpannerRpc rpc) {
      return rpc.getExecuteQueryRetrySettings();
    }

    @Override
    Set<Code> getRetryableCodes(SpannerRpc rpc) {
      return rpc.getExecuteQueryRetryableCodes();
    }

    @Override
    Statement getStatement() {
      return statement;
    }

    @Override
    void setSession(String session) {
      builder.setSession(session);
    }

    @Override
    void setPartitionToken(ByteString partitionToken) {
      builder.setPartitionToken(partitionToken);
    }

    @Override
    void setDataBoostEnabled(boolean dataBoostEnabled) {
      builder.setDataBoostEnabled(dataBoostEnabled);
    }

    @Override
    void setDirectedReadOptions(DirectedReadOptions directedReadOptions) {
      builder.setDirectedReadOptions(directedReadOptions);
    }

    @Override
    void setRequestOptions(RequestOptions requestOptions) {
      builder.setRequestOptions(requestOptions);
    }

    @Override
    void setResumeToken(ByteString resumeToken) {
      builder.setResumeToken(resumeToken);
    }

    @Override
    boolean hasTransaction() {
      return builder.hasTransaction();
    }

    @Override
    void setTransactionInternal(TransactionSelector selector) {
      builder.setTransaction(selector);
    }

    @Override
    SpannerRpc.StreamingCall start(
        SpannerRpc rpc,
        SpannerRpc.ResultStreamConsumer consumer,
        @Nullable Map<SpannerRpc.Option, ?> channelHint,
        XGoogSpannerRequestId requestId,
        boolean routeToLeader) {
      return rpc.executeQuery(builder.build(), consumer, channelHint, requestId, routeToLeader);
    }
  }

  static final class Read extends ReadOrQueryRequest {
    private final ReadRequest.Builder builder;

    private Read(ReadRequest.Builder builder) {
      super(checkNotNull(builder).getTransaction().hasBegin());
      this.builder = builder;
    }

    @Override
    String getOperationName() {
      return SpannerImpl.READ;
    }

    @Override
    RetrySettings getRetrySettings(SpannerRpc rpc) {
      return rpc.getReadRetrySettings();
    }

    @Override
    Set<Code> getRetryableCodes(SpannerRpc rpc) {
      return rpc.getReadRetryableCodes();
    }

    @Override
    @Nullable Statement getStatement() {
      return null;
    }

    @Override
    void setSession(String session) {
      builder.setSession(session);
    }

    @Override
    void setPartitionToken(ByteString partitionToken) {
      builder.setPartitionToken(partitionToken);
    }

    @Override
    void setDataBoostEnabled(boolean dataBoostEnabled) {
      builder.setDataBoostEnabled(dataBoostEnabled);
    }

    @Override
    void setDirectedReadOptions(DirectedReadOptions directedReadOptions) {
      builder.setDirectedReadOptions(directedReadOptions);
    }

    @Override
    void setRequestOptions(RequestOptions requestOptions) {
      builder.setRequestOptions(requestOptions);
    }

    @Override
    void setResumeToken(ByteString resumeToken) {
      builder.setResumeToken(resumeToken);
    }

    @Override
    boolean hasTransaction() {
      return builder.hasTransaction();
    }

    @Override
    void setTransactionInternal(TransactionSelector selector) {
      builder.setTransaction(selector);
    }

    @Override
    SpannerRpc.StreamingCall start(
        SpannerRpc rpc,
        SpannerRpc.ResultStreamConsumer consumer,
        @Nullable Map<SpannerRpc.Option, ?> channelHint,
        XGoogSpannerRequestId requestId,
        boolean routeToLeader) {
      return rpc.read(builder.build(), consumer, channelHint, requestId, routeToLeader);
    }
  }
}
