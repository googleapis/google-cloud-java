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
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StatusCode.Code;
import com.google.bigtable.v2.CheckAndMutateRowRequest;
import com.google.bigtable.v2.MutateRowRequest;
import com.google.bigtable.v2.MutateRowsRequest;
import com.google.bigtable.v2.ReadModifyWriteRowRequest;
import com.google.bigtable.v2.ReadRowsRequest;
import com.google.bigtable.v2.SampleRowKeysRequest;
import com.google.bigtable.v2.TableName;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.StatusRuntimeException;
import io.opencensus.tags.TagValue;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

/** Utilities to help integrating with OpenCensus. */
@InternalApi("For internal use only")
public class Util {
  static final Metadata.Key<String> ATTEMPT_HEADER_KEY =
      Metadata.Key.of("bigtable-attempt", Metadata.ASCII_STRING_MARSHALLER);
  static final Metadata.Key<String> ATTEMPT_EPOCH_KEY =
      Metadata.Key.of("bigtable-client-attempt-epoch-usec", Metadata.ASCII_STRING_MARSHALLER);

  private static final Metadata.Key<String> SERVER_TIMING_HEADER_KEY =
      Metadata.Key.of("server-timing", Metadata.ASCII_STRING_MARSHALLER);
  private static final Pattern SERVER_TIMING_HEADER_PATTERN = Pattern.compile(".*dur=(?<dur>\\d+)");
  static final Metadata.Key<byte[]> METADATA_KEY =
      Metadata.Key.of("x-goog-ext-425905942-bin", Metadata.BINARY_BYTE_MARSHALLER);

  /** Convert an exception into a value that can be used to create an OpenCensus tag value. */
  static String extractStatus(@Nullable Throwable error) {
    final String statusString;

    if (error == null) {
      return StatusCode.Code.OK.toString();
    } else if (error instanceof CancellationException) {
      statusString = Status.Code.CANCELLED.toString();
    } else if (error instanceof ApiException) {
      statusString = ((ApiException) error).getStatusCode().getCode().toString();
    } else if (error instanceof StatusRuntimeException) {
      statusString = ((StatusRuntimeException) error).getStatus().getCode().toString();
    } else if (error instanceof StatusException) {
      statusString = ((StatusException) error).getStatus().getCode().toString();
    } else {
      statusString = Code.UNKNOWN.toString();
    }

    return statusString;
  }

  /**
   * Await the result of the future and convert it into a value that can be used as an OpenCensus
   * tag value.
   */
  static TagValue extractStatusFromFuture(Future<?> future) {
    Throwable error = null;

    try {
      future.get();
    } catch (InterruptedException e) {
      error = e;
      Thread.currentThread().interrupt();
    } catch (ExecutionException e) {
      error = e.getCause();
    } catch (RuntimeException e) {
      error = e;
    }
    return TagValue.create(extractStatus(error));
  }

  static String extractTableId(Object request) {
    String tableName = null;
    if (request instanceof ReadRowsRequest) {
      tableName = ((ReadRowsRequest) request).getTableName();
    } else if (request instanceof MutateRowsRequest) {
      tableName = ((MutateRowsRequest) request).getTableName();
    } else if (request instanceof MutateRowRequest) {
      tableName = ((MutateRowRequest) request).getTableName();
    } else if (request instanceof SampleRowKeysRequest) {
      tableName = ((SampleRowKeysRequest) request).getTableName();
    } else if (request instanceof CheckAndMutateRowRequest) {
      tableName = ((CheckAndMutateRowRequest) request).getTableName();
    } else if (request instanceof ReadModifyWriteRowRequest) {
      tableName = ((ReadModifyWriteRowRequest) request).getTableName();
    }
    return !Strings.isNullOrEmpty(tableName) ? TableName.parse(tableName).getTable() : "undefined";
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

  static Long getGfeLatency(Metadata metadata) {
    if (metadata != null && metadata.get(SERVER_TIMING_HEADER_KEY) != null) {
      String serverTiming = metadata.get(SERVER_TIMING_HEADER_KEY);
      Matcher matcher = SERVER_TIMING_HEADER_PATTERN.matcher(serverTiming);
      // this should always be true
      if (matcher.find()) {
        long latency = Long.valueOf(matcher.group("dur"));
        return latency;
      }
    }
    return null;
  }
}
