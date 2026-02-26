/*
 * Copyright 2019 Google LLC
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
package com.google.cloud.bigtable.data.v2.stub.metrics;

import com.google.api.core.InternalApi;
import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiException;
import com.google.bigtable.v2.AuthorizedViewName;
import com.google.bigtable.v2.CheckAndMutateRowRequest;
import com.google.bigtable.v2.GenerateInitialChangeStreamPartitionsRequest;
import com.google.bigtable.v2.MaterializedViewName;
import com.google.bigtable.v2.MutateRowRequest;
import com.google.bigtable.v2.MutateRowsRequest;
import com.google.bigtable.v2.ReadChangeStreamRequest;
import com.google.bigtable.v2.ReadModifyWriteRowRequest;
import com.google.bigtable.v2.ReadRowsRequest;
import com.google.bigtable.v2.SampleRowKeysRequest;
import com.google.bigtable.v2.TableName;
import com.google.common.collect.ImmutableMap;
import io.grpc.Metadata;
import io.grpc.Status;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import javax.annotation.Nullable;

/** Utilities to help integrating with OpenCensus. */
@InternalApi("For internal use only")
public class Util {
  static final Metadata.Key<String> ATTEMPT_HEADER_KEY =
      Metadata.Key.of("bigtable-attempt", Metadata.ASCII_STRING_MARSHALLER);
  static final Metadata.Key<String> ATTEMPT_EPOCH_KEY =
      Metadata.Key.of("bigtable-client-attempt-epoch-usec", Metadata.ASCII_STRING_MARSHALLER);

  public static Status.Code extractStatus(@Nullable Throwable error) {
    if (error == null) {
      return Status.Code.OK;
    }
    // Handle java CancellationException as if it was a gax CancelledException
    if (error instanceof CancellationException) {
      return Status.Code.CANCELLED;
    }
    if (error instanceof ApiException) {
      ApiException apiException = (ApiException) error;
      if (apiException.getStatusCode() instanceof GrpcStatusCode) {
        return ((GrpcStatusCode) apiException.getStatusCode()).getTransportCode();
      }
    }

    Status s = Status.fromThrowable(error);
    if (s != null) {
      return s.getCode();
    }
    return Status.Code.UNKNOWN;
  }

  static String extractTableId(Object request) {
    String tableName = null;
    String authorizedViewName = null;
    String materializedViewName = null;
    if (request instanceof ReadRowsRequest) {
      tableName = ((ReadRowsRequest) request).getTableName();
      authorizedViewName = ((ReadRowsRequest) request).getAuthorizedViewName();
      materializedViewName = ((ReadRowsRequest) request).getMaterializedViewName();
    } else if (request instanceof MutateRowsRequest) {
      tableName = ((MutateRowsRequest) request).getTableName();
      authorizedViewName = ((MutateRowsRequest) request).getAuthorizedViewName();
    } else if (request instanceof MutateRowRequest) {
      tableName = ((MutateRowRequest) request).getTableName();
      authorizedViewName = ((MutateRowRequest) request).getAuthorizedViewName();
    } else if (request instanceof SampleRowKeysRequest) {
      tableName = ((SampleRowKeysRequest) request).getTableName();
      authorizedViewName = ((SampleRowKeysRequest) request).getAuthorizedViewName();
      materializedViewName = ((SampleRowKeysRequest) request).getMaterializedViewName();
    } else if (request instanceof CheckAndMutateRowRequest) {
      tableName = ((CheckAndMutateRowRequest) request).getTableName();
      authorizedViewName = ((CheckAndMutateRowRequest) request).getAuthorizedViewName();
    } else if (request instanceof ReadModifyWriteRowRequest) {
      tableName = ((ReadModifyWriteRowRequest) request).getTableName();
      authorizedViewName = ((ReadModifyWriteRowRequest) request).getAuthorizedViewName();
    } else if (request instanceof GenerateInitialChangeStreamPartitionsRequest) {
      tableName = ((GenerateInitialChangeStreamPartitionsRequest) request).getTableName();
    } else if (request instanceof ReadChangeStreamRequest) {
      tableName = ((ReadChangeStreamRequest) request).getTableName();
    }
    if (tableName != null && !tableName.isEmpty()) {
      return TableName.parse(tableName).getTable();
    }
    if (authorizedViewName != null && !authorizedViewName.isEmpty()) {
      return AuthorizedViewName.parse(authorizedViewName).getTable();
    }
    if (materializedViewName != null && !materializedViewName.isEmpty()) {
      return MaterializedViewName.parse(materializedViewName).getMaterializedView();
    }
    return "<unspecified>";
  }

  /**
   * Add attempt number and client timestamp from api call context to request headers. Attempt
   * number starts from 0.
   */
  static Map<String, List<String>> createStatsHeaders(ApiCallContext apiCallContext) {
    ImmutableMap.Builder<String, List<String>> headers = ImmutableMap.builder();
    headers.put(
        ATTEMPT_EPOCH_KEY.name(),
        Arrays.asList(String.valueOf(Instant.EPOCH.until(Instant.now(), ChronoUnit.MICROS))));
    // This should always be true
    if (apiCallContext.getTracer() instanceof BigtableTracer) {
      int attemptCount = ((BigtableTracer) apiCallContext.getTracer()).getAttempt();
      headers.put(ATTEMPT_HEADER_KEY.name(), Arrays.asList(String.valueOf(attemptCount)));
    }
    return headers.build();
  }
}
