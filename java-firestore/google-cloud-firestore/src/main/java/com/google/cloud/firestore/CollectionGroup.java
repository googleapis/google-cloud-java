/*
 * Copyright 2020 Google LLC
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

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptions;
import com.google.api.gax.rpc.ApiStreamObserver;
import com.google.cloud.firestore.telemetry.MetricsUtil.MetricsContext;
import com.google.cloud.firestore.telemetry.TelemetryConstants;
import com.google.cloud.firestore.telemetry.TelemetryConstants.MetricType;
import com.google.cloud.firestore.telemetry.TraceUtil;
import com.google.cloud.firestore.telemetry.TraceUtil.Scope;
import com.google.cloud.firestore.v1.FirestoreClient.PartitionQueryPagedResponse;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.firestore.v1.Cursor;
import com.google.firestore.v1.PartitionQueryRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import javax.annotation.Nullable;

/**
 * A Collection Group query matches all documents that are contained in a collection or
 * subcollection with a specific collection ID.
 */
public class CollectionGroup extends Query {

  final Query partitionQuery;

  CollectionGroup(FirestoreRpcContext<?> rpcContext, String collectionId) {
    super(
        rpcContext,
        QueryOptions.builder()
            .setParentPath(rpcContext.getResourcePath())
            .setCollectionId(collectionId)
            .setAllDescendants(true)
            .build());

    // Partition queries require explicit ordering by __name__.
    partitionQuery = orderBy(FieldPath.DOCUMENT_ID);
  }

  /**
   * Partitions a query by returning partition cursors that can be used to run the query in
   * parallel. The returned partition cursors are split points that can be used as starting/end
   * points for the query results.
   *
   * @deprecated Please use {@link #getPartitions(long)} instead. All cursors will be loaded before
   *     any value will be provided to {@code observer}.
   * @param desiredPartitionCount The desired maximum number of partition points. The number must be
   *     strictly positive. The actual number of partitions returned may be fewer.
   * @param observer a stream observer that receives the result of the Partition request.
   */
  public void getPartitions(
      long desiredPartitionCount, final ApiStreamObserver<QueryPartition> observer) {
    if (desiredPartitionCount == 1) {
      // Short circuit if the user only requested a single partition.
      observer.onNext(new QueryPartition(partitionQuery, null, null));
    } else {
      PartitionQueryRequest request = buildRequest(desiredPartitionCount);

      final PartitionQueryPagedResponse response;
      try {
        response =
            ApiExceptions.callAndTranslateApiException(
                rpcContext.sendRequest(
                    request, rpcContext.getClient().partitionQueryPagedCallable()));

        consumePartitions(
            response,
            queryPartition -> {
              observer.onNext(queryPartition);
              return null;
            });

        observer.onCompleted();
      } catch (ApiException exception) {
        throw FirestoreException.forApiException(exception);
      }
    }
  }

  public ApiFuture<List<QueryPartition>> getPartitions(long desiredPartitionCount) {
    if (desiredPartitionCount == 1) {
      // Short circuit if the user only requested a single partition.
      return ApiFutures.immediateFuture(
          Collections.singletonList(new QueryPartition(partitionQuery, null, null)));
    } else {
      PartitionQueryRequest request = buildRequest(desiredPartitionCount);

      TraceUtil.Span span =
          rpcContext
              .getFirestore()
              .getOptions()
              .getTraceUtil()
              .startSpan(TelemetryConstants.METHOD_NAME_PARTITION_QUERY);

      MetricsContext metricsContext =
          rpcContext
              .getFirestore()
              .getOptions()
              .getMetricsUtil()
              .createMetricsContext(TelemetryConstants.METHOD_NAME_PARTITION_QUERY);

      try (Scope ignored = span.makeCurrent()) {
        ApiFuture<List<QueryPartition>> result =
            ApiFutures.transform(
                rpcContext.sendRequest(
                    request, rpcContext.getClient().partitionQueryPagedCallable()),
                response -> {
                  final ImmutableList.Builder<QueryPartition> partitions = ImmutableList.builder();
                  consumePartitions(
                      response,
                      queryPartition -> {
                        partitions.add(queryPartition);
                        return null;
                      });
                  return partitions.build();
                },
                MoreExecutors.directExecutor());
        span.endAtFuture(result);
        metricsContext.recordLatencyAtFuture(MetricType.END_TO_END_LATENCY, result);
        return result;
      } catch (ApiException exception) {
        span.end(exception);
        metricsContext.recordLatency(MetricType.END_TO_END_LATENCY, exception);
        throw FirestoreException.forApiException(exception);
      } catch (Throwable throwable) {
        span.end(throwable);
        metricsContext.recordLatency(MetricType.END_TO_END_LATENCY, throwable);
        throw throwable;
      }
    }
  }

  private PartitionQueryRequest buildRequest(long desiredPartitionCount) {
    Preconditions.checkArgument(
        desiredPartitionCount > 0, "Desired partition count must be one or greater");

    PartitionQueryRequest.Builder request = PartitionQueryRequest.newBuilder();
    request.setStructuredQuery(partitionQuery.buildQuery());
    request.setParent(options.getParentPath().toString());

    // Since we are always returning an extra partition (with en empty endBefore cursor), we
    // reduce the desired partition count by one.
    request.setPartitionCount(desiredPartitionCount - 1);
    return request.build();
  }

  private void consumePartitions(
      PartitionQueryPagedResponse response, Function<QueryPartition, Void> consumer) {
    List<Cursor> cursors = new ArrayList<>();
    for (Cursor cursor : response.iterateAll()) {
      cursors.add(cursor);
    }

    // Sort the partitions as they may not be ordered if responses are paged.
    cursors.sort(
        (left, right) -> Order.INSTANCE.compareArrays(left.getValuesList(), right.getValuesList()));

    @Nullable Object[] lastCursor = null;
    for (Cursor cursor : cursors) {
      Object[] decodedCursorValue = new Object[cursor.getValuesCount()];
      for (int i = 0; i < cursor.getValuesCount(); ++i) {
        decodedCursorValue[i] = UserDataConverter.decodeValue(rpcContext, cursor.getValues(i));
      }
      consumer.apply(new QueryPartition(partitionQuery, lastCursor, decodedCursorValue));
      lastCursor = decodedCursorValue;
    }
    consumer.apply(new QueryPartition(partitionQuery, lastCursor, null));
  }

  @SuppressWarnings("MethodDoesntCallSuperMethod")
  @Override
  public String toString() {
    return String.format("CollectionGroup{partitionQuery=%s, options=%s}", partitionQuery, options);
  }
}
