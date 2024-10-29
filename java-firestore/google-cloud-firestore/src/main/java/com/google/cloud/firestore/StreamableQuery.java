/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.firestore;

import static com.google.cloud.firestore.telemetry.TraceUtil.*;
import static com.google.common.collect.Lists.reverse;

import com.google.api.core.ApiFuture;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.rpc.ApiStreamObserver;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StreamController;
import com.google.cloud.Timestamp;
import com.google.cloud.firestore.telemetry.TraceUtil;
import com.google.cloud.firestore.v1.FirestoreSettings;
import com.google.common.collect.ImmutableMap;
import com.google.firestore.v1.Document;
import com.google.firestore.v1.RunQueryRequest;
import com.google.firestore.v1.RunQueryResponse;
import com.google.protobuf.ByteString;
import io.grpc.Status;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.threeten.bp.Duration;

/**
 * Represents a query whose results can be streamed. If the stream fails with a retryable error,
 * implementations of StreamableQuery can optionally support retries with a cursor, as indicated by
 * `isRetryableWithCursor`. Retrying with a cursor means that the StreamableQuery can be resumed
 * where it failed by first calling `startAfter(lastDocumentReceived)`.
 */
public abstract class StreamableQuery<SnapshotType> {
  final Query.QueryOptions options;
  final FirestoreRpcContext<?> rpcContext;

  StreamableQuery(FirestoreRpcContext<?> rpcContext, Query.QueryOptions options) {
    this.rpcContext = rpcContext;
    this.options = options;
  }

  abstract RunQueryRequest.Builder toRunQueryRequestBuilder(
      @Nullable final ByteString transactionId,
      @Nullable final Timestamp readTime,
      @Nullable ExplainOptions explainOptions);

  abstract boolean isRetryableWithCursor();

  abstract StreamableQuery<SnapshotType> startAfter(@Nonnull DocumentSnapshot snapshot);

  abstract SnapshotType createSnaphot(
      Timestamp readTime, final List<QueryDocumentSnapshot> documents);

  /**
   * Gets the Firestore instance associated with this query.
   *
   * @return The Firestore instance associated with this query.
   */
  @Nonnull
  public Firestore getFirestore() {
    return rpcContext.getFirestore();
  }
  /**
   * Executes the query and returns the results as QuerySnapshot.
   *
   * @return An ApiFuture that will be resolved with the results of the Query.
   */
  @Nonnull
  public abstract ApiFuture<SnapshotType> get();

  /**
   * Executes the query and returns the results as QuerySnapshot.
   *
   * @return An ApiFuture that will be resolved with the results of the Query.
   */
  ApiFuture<SnapshotType> get(
      @Nullable ByteString transactionId, @Nullable Timestamp requestReadTime) {
    TraceUtil.Span span =
        getFirestore()
            .getOptions()
            .getTraceUtil()
            .startSpan(
                transactionId == null
                    ? TraceUtil.SPAN_NAME_QUERY_GET
                    : TraceUtil.SPAN_NAME_TRANSACTION_GET_QUERY);
    try (Scope ignored = span.makeCurrent()) {
      final SettableApiFuture<SnapshotType> result = SettableApiFuture.create();
      internalStream(
          new ApiStreamObserver<RunQueryResponse>() {
            final List<QueryDocumentSnapshot> documentSnapshots = new ArrayList<>();
            Timestamp responseReadTime;

            @Override
            public void onNext(RunQueryResponse runQueryResponse) {
              if (runQueryResponse.hasDocument()) {
                Document document = runQueryResponse.getDocument();
                QueryDocumentSnapshot documentSnapshot =
                    QueryDocumentSnapshot.fromDocument(
                        rpcContext, Timestamp.fromProto(runQueryResponse.getReadTime()), document);
                documentSnapshots.add(documentSnapshot);
              }
              if (responseReadTime == null) {
                responseReadTime = Timestamp.fromProto(runQueryResponse.getReadTime());
              }
            }

            @Override
            public void onError(Throwable throwable) {
              result.setException(throwable);
            }

            @Override
            public void onCompleted() {
              // The results for limitToLast queries need to be flipped since we reversed the
              // ordering constraints before sending the query to the backend.
              List<QueryDocumentSnapshot> resultView =
                  Query.LimitType.Last.equals(options.getLimitType())
                      ? reverse(documentSnapshots)
                      : documentSnapshots;
              SnapshotType querySnapshot = createSnaphot(responseReadTime, resultView);
              result.set(querySnapshot);
            }
          },
          /* startTimeNanos= */ rpcContext.getClock().nanoTime(),
          transactionId,
          /* readTime= */ requestReadTime,
          /* explainOptions= */ null,
          /* isRetryRequestWithCursor= */ false);

      span.endAtFuture(result);
      return result;
    } catch (Exception error) {
      span.end(error);
      throw error;
    }
  }

  /**
   * Plans and optionally executes this query. Returns an ApiFuture that will be resolved with the
   * planner information, statistics from the query execution (if any), and the query results (if
   * any).
   *
   * @return An ApiFuture that will be resolved with the planner information, statistics from the
   *     query execution (if any), and the query results (if any).
   */
  @Nonnull
  public ApiFuture<ExplainResults<SnapshotType>> explain(ExplainOptions options) {
    TraceUtil.Span span =
        getFirestore().getOptions().getTraceUtil().startSpan(TraceUtil.SPAN_NAME_QUERY_GET);

    try (Scope ignored = span.makeCurrent()) {
      final SettableApiFuture<ExplainResults<SnapshotType>> result = SettableApiFuture.create();
      internalStream(
          new ApiStreamObserver<RunQueryResponse>() {
            @Nullable List<QueryDocumentSnapshot> documentSnapshots = null;
            Timestamp readTime;
            ExplainMetrics metrics;

            @Override
            public void onNext(RunQueryResponse runQueryResponse) {
              if (runQueryResponse.hasDocument()) {
                if (documentSnapshots == null) {
                  documentSnapshots = new ArrayList<>();
                }

                Document document = runQueryResponse.getDocument();
                QueryDocumentSnapshot documentSnapshot =
                    QueryDocumentSnapshot.fromDocument(
                        rpcContext, Timestamp.fromProto(runQueryResponse.getReadTime()), document);
                documentSnapshots.add(documentSnapshot);
              }

              if (readTime == null) {
                readTime = Timestamp.fromProto(runQueryResponse.getReadTime());
              }

              if (runQueryResponse.hasExplainMetrics()) {
                metrics = new ExplainMetrics(runQueryResponse.getExplainMetrics());
                if (documentSnapshots == null && metrics.getExecutionStats() != null) {
                  // This indicates that the query was executed, but no documents
                  // had matched the query. Create an empty list.
                  documentSnapshots = Collections.emptyList();
                }
              }
            }

            @Override
            public void onError(Throwable throwable) {
              result.setException(throwable);
            }

            @Override
            public void onCompleted() {
              @Nullable SnapshotType snapshot = null;
              if (documentSnapshots != null) {
                // The results for limitToLast queries need to be flipped since we reversed the
                // ordering constraints before sending the query to the backend.
                List<QueryDocumentSnapshot> resultView =
                    Query.LimitType.Last.equals(StreamableQuery.this.options.getLimitType())
                        ? reverse(documentSnapshots)
                        : documentSnapshots;
                snapshot = createSnaphot(readTime, resultView);
              }
              result.set(new ExplainResults<>(metrics, snapshot));
            }
          },
          /* startTimeNanos= */ rpcContext.getClock().nanoTime(),
          /* transactionId= */ null,
          /* readTime= */ null,
          /* explainOptions= */ options,
          /* isRetryRequestWithCursor= */ false);

      span.endAtFuture(result);
      return result;
    } catch (Exception error) {
      span.end(error);
      throw error;
    }
  }

  protected void internalStream(
      final ApiStreamObserver<RunQueryResponse> runQueryResponseObserver,
      final long startTimeNanos,
      @Nullable final ByteString transactionId,
      @Nullable final Timestamp readTime,
      @Nullable final ExplainOptions explainOptions,
      final boolean isRetryRequestWithCursor) {
    TraceUtil traceUtil = getFirestore().getOptions().getTraceUtil();
    // To reduce the size of traces, we only register one event for every 100 responses
    // that we receive from the server.
    final int NUM_RESPONSES_PER_TRACE_EVENT = 100;

    TraceUtil.Span currentSpan = traceUtil.currentSpan();
    currentSpan.addEvent(
        TraceUtil.SPAN_NAME_RUN_QUERY,
        new ImmutableMap.Builder<String, Object>()
            .put(ATTRIBUTE_KEY_IS_TRANSACTIONAL, transactionId != null)
            .put(ATTRIBUTE_KEY_IS_RETRY_WITH_CURSOR, isRetryRequestWithCursor)
            .build());

    final AtomicReference<QueryDocumentSnapshot> lastReceivedDocument = new AtomicReference<>();

    ResponseObserver<RunQueryResponse> observer =
        new ResponseObserver<RunQueryResponse>() {
          Timestamp readTime;
          boolean firstResponse = false;
          int numDocuments = 0;

          // The stream's `onComplete()` could be called more than once,
          // this flag makes sure only the first one is actually processed.
          boolean hasCompleted = false;

          @Override
          public void onStart(StreamController streamController) {}

          @Override
          public void onResponse(RunQueryResponse response) {
            if (!firstResponse) {
              firstResponse = true;
              currentSpan.addEvent(TraceUtil.SPAN_NAME_RUN_QUERY + ": First Response");
            }

            runQueryResponseObserver.onNext(response);

            if (response.hasDocument()) {
              numDocuments++;
              if (numDocuments % NUM_RESPONSES_PER_TRACE_EVENT == 0) {
                currentSpan.addEvent(
                    TraceUtil.SPAN_NAME_RUN_QUERY + ": Received " + numDocuments + " documents");
              }
              Document document = response.getDocument();
              QueryDocumentSnapshot documentSnapshot =
                  QueryDocumentSnapshot.fromDocument(
                      rpcContext, Timestamp.fromProto(response.getReadTime()), document);
              lastReceivedDocument.set(documentSnapshot);
            }

            if (response.getDone()) {
              currentSpan.addEvent(
                  TraceUtil.SPAN_NAME_RUN_QUERY + ": Received RunQueryResponse.Done");
              onComplete();
            }
          }

          @Override
          public void onError(Throwable throwable) {
            QueryDocumentSnapshot cursor = lastReceivedDocument.get();
            if (isRetryableWithCursor() && shouldRetry(cursor, throwable)) {
              currentSpan.addEvent(
                  TraceUtil.SPAN_NAME_RUN_QUERY + ": Retryable Error",
                  Collections.singletonMap("error.message", throwable.getMessage()));

              startAfter(cursor)
                  .internalStream(
                      runQueryResponseObserver,
                      startTimeNanos,
                      /* transactionId= */ null,
                      options.getRequireConsistency() ? cursor.getReadTime() : null,
                      explainOptions,
                      /* isRetryRequestWithCursor= */ true);
            } else {
              currentSpan.addEvent(
                  TraceUtil.SPAN_NAME_RUN_QUERY + ": Error",
                  Collections.singletonMap("error.message", throwable.getMessage()));
              runQueryResponseObserver.onError(throwable);
            }
          }

          @Override
          public void onComplete() {
            if (hasCompleted) return;
            hasCompleted = true;
            currentSpan.addEvent(
                TraceUtil.SPAN_NAME_RUN_QUERY + ": Completed",
                Collections.singletonMap(ATTRIBUTE_KEY_DOC_COUNT, numDocuments));
            runQueryResponseObserver.onCompleted();
          }

          boolean shouldRetry(DocumentSnapshot lastDocument, Throwable t) {
            if (lastDocument == null) {
              // Only retry if we have received a single result. Retries for RPCs with initial
              // failure are handled by Google Gax, which also implements backoff.
              return false;
            }

            // Do not retry EXPLAIN requests because it'd be executing
            // multiple queries. This means stats would have to be aggregated,
            // and that may not even make sense for many statistics.
            if (explainOptions != null) {
              return false;
            }

            Set<StatusCode.Code> retryableCodes =
                FirestoreSettings.newBuilder().runQuerySettings().getRetryableCodes();
            return shouldRetryQuery(t, transactionId, startTimeNanos, retryableCodes);
          }
        };

    rpcContext.streamRequest(
        toRunQueryRequestBuilder(transactionId, readTime, explainOptions).build(),
        observer,
        rpcContext.getClient().runQueryCallable());
  }

  /** Returns whether a query that failed in the given scenario should be retried. */
  boolean shouldRetryQuery(
      Throwable throwable,
      @Nullable ByteString transactionId,
      long startTimeNanos,
      Set<StatusCode.Code> retryableCodes) {
    if (transactionId != null) {
      // Transactional queries are retried via the transaction runner.
      return false;
    }

    if (!isRetryableError(throwable, retryableCodes)) {
      return false;
    }

    if (rpcContext.getTotalRequestTimeout().isZero()) {
      return true;
    }

    Duration duration = Duration.ofNanos(rpcContext.getClock().nanoTime() - startTimeNanos);
    return duration.compareTo(rpcContext.getTotalRequestTimeout()) < 0;
  }

  /** Verifies whether the given exception is retryable based on the RunQuery configuration. */
  private boolean isRetryableError(Throwable throwable, Set<StatusCode.Code> retryableCodes) {
    if (!(throwable instanceof FirestoreException)) {
      return false;
    }
    Status status = ((FirestoreException) throwable).getStatus();
    for (StatusCode.Code code : retryableCodes) {
      if (code.equals(StatusCode.Code.valueOf(status.getCode().name()))) {
        return true;
      }
    }
    return false;
  }

  @Override
  public String toString() {
    return String.format("%s{options=%s}", getClass().getSimpleName(), options);
  }
}
