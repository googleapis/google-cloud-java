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
import com.google.auth.Credentials;
import com.google.bigtable.v2.AuthorizedViewName;
import com.google.bigtable.v2.CheckAndMutateRowRequest;
import com.google.bigtable.v2.GenerateInitialChangeStreamPartitionsRequest;
import com.google.bigtable.v2.InstanceName;
import com.google.bigtable.v2.MaterializedViewName;
import com.google.bigtable.v2.MutateRowRequest;
import com.google.bigtable.v2.MutateRowsRequest;
import com.google.bigtable.v2.PeerInfo;
import com.google.bigtable.v2.ReadChangeStreamRequest;
import com.google.bigtable.v2.ReadModifyWriteRowRequest;
import com.google.bigtable.v2.ReadRowsRequest;
import com.google.bigtable.v2.ResponseParams;
import com.google.bigtable.v2.SampleRowKeysRequest;
import com.google.bigtable.v2.TableName;
import com.google.cloud.bigtable.data.v2.BigtableDataSettings;
import com.google.cloud.bigtable.data.v2.stub.MetadataExtractorInterceptor;
import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.StatusRuntimeException;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.metrics.InstrumentSelector;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.SdkMeterProviderBuilder;
import io.opentelemetry.sdk.metrics.View;
import io.opentelemetry.sdk.metrics.export.MetricExporter;
import io.opentelemetry.sdk.metrics.export.PeriodicMetricReader;
import io.opentelemetry.sdk.metrics.export.PeriodicMetricReaderBuilder;
import java.io.IOException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nullable;

/** Utilities to help integrating with OpenCensus. */
@InternalApi("For internal use only")
public class Util {
  static final Metadata.Key<String> ATTEMPT_HEADER_KEY =
      Metadata.Key.of("bigtable-attempt", Metadata.ASCII_STRING_MARSHALLER);
  static final Metadata.Key<String> ATTEMPT_EPOCH_KEY =
      Metadata.Key.of("bigtable-client-attempt-epoch-usec", Metadata.ASCII_STRING_MARSHALLER);

  /** Convert an exception into a value that can be used to create an OpenCensus tag value. */
  public static String extractStatus(@Nullable Throwable error) {
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

  public static OpenTelemetrySdk createBuiltinOtel(
      InstanceName instanceName,
      String appProfileId,
      @Nullable Credentials defaultCredentials,
      @Nullable String metricsEndpoint,
      String universeDomain,
      ScheduledExecutorService executor)
      throws IOException {

    Credentials credentials =
        BigtableDataSettings.getMetricsCredentials() != null
            ? BigtableDataSettings.getMetricsCredentials()
            : defaultCredentials;

    SdkMeterProviderBuilder meterProvider = SdkMeterProvider.builder();

    for (Map.Entry<InstrumentSelector, View> entry :
        BuiltinMetricsConstants.getAllViews().entrySet()) {
      meterProvider.registerView(entry.getKey(), entry.getValue());
    }

    for (Map.Entry<InstrumentSelector, View> e :
        BuiltinMetricsConstants.getInternalViews().entrySet()) {
      meterProvider.registerView(e.getKey(), e.getValue());
    }

    MetricExporter publicExporter =
        BigtableCloudMonitoringExporter.create(
            credentials,
            metricsEndpoint,
            universeDomain,
            ImmutableList.of(
                new BigtableCloudMonitoringExporter.PublicTimeSeriesConverter(),
                new BigtableCloudMonitoringExporter.InternalTimeSeriesConverter(
                    Suppliers.memoize(
                        () ->
                            BigtableExporterUtils.createInternalMonitoredResource(
                                instanceName, appProfileId)))),
            executor);
    PeriodicMetricReaderBuilder readerBuilder =
        PeriodicMetricReader.builder(publicExporter).setExecutor(executor);
    meterProvider.registerMetricReader(readerBuilder.build());

    return OpenTelemetrySdk.builder().setMeterProvider(meterProvider.build()).build();
  }

  public static String formatTransportTypeMetricLabel(
      MetadataExtractorInterceptor.SidebandData sidebandData) {
    return Optional.ofNullable(sidebandData)
        .flatMap(s -> Optional.ofNullable(s.getPeerInfo()))
        .map(PeerInfo::getTransportType)
        .orElse(PeerInfo.TransportType.TRANSPORT_TYPE_UNKNOWN)
        .name()
        .replace("TRANSPORT_TYPE_", "")
        .toLowerCase(Locale.ENGLISH);
  }

  public static String formatClusterIdMetricLabel(
      @Nullable MetadataExtractorInterceptor.SidebandData sidebandData) {
    return Optional.ofNullable(sidebandData)
        .flatMap(d -> Optional.ofNullable(d.getResponseParams()))
        .map(ResponseParams::getClusterId)
        .filter(s -> !s.isEmpty())
        .orElse("<unspecified>");
  }

  public static String formatZoneIdMetricLabel(
      @Nullable MetadataExtractorInterceptor.SidebandData sidebandData) {
    return Optional.ofNullable(sidebandData)
        .flatMap(d -> Optional.ofNullable(d.getResponseParams()))
        .map(ResponseParams::getZoneId)
        .filter(s -> !s.isEmpty())
        .orElse("global");
  }
}
