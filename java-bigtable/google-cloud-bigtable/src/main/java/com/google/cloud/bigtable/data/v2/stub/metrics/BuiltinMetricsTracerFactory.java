/*
 * Copyright 2022 Google LLC
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

import static com.google.cloud.bigtable.data.v2.stub.metrics.BuiltinMetricsConstants.APPLICATION_BLOCKING_LATENCIES_NAME;
import static com.google.cloud.bigtable.data.v2.stub.metrics.BuiltinMetricsConstants.ATTEMPT_LATENCIES_NAME;
import static com.google.cloud.bigtable.data.v2.stub.metrics.BuiltinMetricsConstants.CLIENT_BLOCKING_LATENCIES_NAME;
import static com.google.cloud.bigtable.data.v2.stub.metrics.BuiltinMetricsConstants.CONNECTIVITY_ERROR_COUNT_NAME;
import static com.google.cloud.bigtable.data.v2.stub.metrics.BuiltinMetricsConstants.FIRST_RESPONSE_LATENCIES_NAME;
import static com.google.cloud.bigtable.data.v2.stub.metrics.BuiltinMetricsConstants.METER_NAME;
import static com.google.cloud.bigtable.data.v2.stub.metrics.BuiltinMetricsConstants.OPERATION_LATENCIES_NAME;
import static com.google.cloud.bigtable.data.v2.stub.metrics.BuiltinMetricsConstants.RETRY_COUNT_NAME;
import static com.google.cloud.bigtable.data.v2.stub.metrics.BuiltinMetricsConstants.SERVER_LATENCIES_NAME;

import com.google.api.core.InternalApi;
import com.google.api.gax.tracing.ApiTracer;
import com.google.api.gax.tracing.ApiTracerFactory;
import com.google.api.gax.tracing.BaseApiTracerFactory;
import com.google.api.gax.tracing.SpanName;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.metrics.DoubleHistogram;
import io.opentelemetry.api.metrics.LongCounter;
import io.opentelemetry.api.metrics.Meter;
import java.io.IOException;

/**
 * {@link ApiTracerFactory} that will generate OpenTelemetry metrics by using the {@link ApiTracer}
 * api.
 */
@InternalApi("For internal use only")
public class BuiltinMetricsTracerFactory extends BaseApiTracerFactory {

  private final Attributes attributes;

  private static final String MILLISECOND = "ms";
  private static final String COUNT = "1";

  private final DoubleHistogram operationLatenciesHistogram;
  private final DoubleHistogram attemptLatenciesHistogram;
  private final DoubleHistogram serverLatenciesHistogram;
  private final DoubleHistogram firstResponseLatenciesHistogram;
  private final DoubleHistogram clientBlockingLatenciesHistogram;
  private final DoubleHistogram applicationBlockingLatenciesHistogram;
  private final LongCounter connectivityErrorCounter;
  private final LongCounter retryCounter;

  public static BuiltinMetricsTracerFactory create(
      OpenTelemetry openTelemetry, Attributes attributes) throws IOException {
    return new BuiltinMetricsTracerFactory(openTelemetry, attributes);
  }

  BuiltinMetricsTracerFactory(OpenTelemetry openTelemetry, Attributes attributes) {
    this.attributes = attributes;
    Meter meter = openTelemetry.getMeter(METER_NAME);

    operationLatenciesHistogram =
        meter
            .histogramBuilder(OPERATION_LATENCIES_NAME)
            .setDescription(
                "Total time until final operation success or failure, including retries and backoff.")
            .setUnit(MILLISECOND)
            .build();
    attemptLatenciesHistogram =
        meter
            .histogramBuilder(ATTEMPT_LATENCIES_NAME)
            .setDescription("Client observed latency per RPC attempt.")
            .setUnit(MILLISECOND)
            .build();
    serverLatenciesHistogram =
        meter
            .histogramBuilder(SERVER_LATENCIES_NAME)
            .setDescription(
                "The latency measured from the moment that the RPC entered the Google data center until the RPC was completed.")
            .setUnit(MILLISECOND)
            .build();
    firstResponseLatenciesHistogram =
        meter
            .histogramBuilder(FIRST_RESPONSE_LATENCIES_NAME)
            .setDescription(
                "Latency from operation start until the response headers were received. The publishing of the measurement will be delayed until the attempt response has been received.")
            .setUnit(MILLISECOND)
            .build();
    clientBlockingLatenciesHistogram =
        meter
            .histogramBuilder(CLIENT_BLOCKING_LATENCIES_NAME)
            .setDescription(
                "The artificial latency introduced by the client to limit the number of outstanding requests. The publishing of the measurement will be delayed until the attempt trailers have been received.")
            .setUnit(MILLISECOND)
            .build();
    applicationBlockingLatenciesHistogram =
        meter
            .histogramBuilder(APPLICATION_BLOCKING_LATENCIES_NAME)
            .setDescription(
                "The latency of the client application consuming available response data.")
            .setUnit(MILLISECOND)
            .build();
    connectivityErrorCounter =
        meter
            .counterBuilder(CONNECTIVITY_ERROR_COUNT_NAME)
            .setDescription(
                "Number of requests that failed to reach the Google datacenter. (Requests without google response headers")
            .setUnit(COUNT)
            .build();
    retryCounter =
        meter
            .counterBuilder(RETRY_COUNT_NAME)
            .setDescription("The number of additional RPCs sent after the initial attempt.")
            .setUnit(COUNT)
            .build();
  }

  @Override
  public ApiTracer newTracer(ApiTracer parent, SpanName spanName, OperationType operationType) {
    return new BuiltinMetricsTracer(
        operationType,
        spanName,
        attributes,
        operationLatenciesHistogram,
        attemptLatenciesHistogram,
        serverLatenciesHistogram,
        firstResponseLatenciesHistogram,
        clientBlockingLatenciesHistogram,
        applicationBlockingLatenciesHistogram,
        connectivityErrorCounter,
        retryCounter);
  }
}
