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

package com.google.cloud.firestore.telemetry;

import static com.google.cloud.firestore.telemetry.TelemetryConstants.FIRESTORE_METER_NAME;
import static com.google.cloud.firestore.telemetry.TelemetryConstants.METRIC_ATTRIBUTE_KEY_CLIENT_UID;
import static com.google.cloud.firestore.telemetry.TelemetryConstants.METRIC_ATTRIBUTE_KEY_LIBRARY_NAME;
import static com.google.cloud.firestore.telemetry.TelemetryConstants.METRIC_ATTRIBUTE_KEY_LIBRARY_VERSION;
import static com.google.cloud.firestore.telemetry.TelemetryConstants.METRIC_NAME_END_TO_END_LATENCY;
import static com.google.cloud.firestore.telemetry.TelemetryConstants.METRIC_NAME_FIRST_RESPONSE_LATENCY;
import static com.google.cloud.firestore.telemetry.TelemetryConstants.METRIC_PREFIX;

import com.google.api.gax.tracing.ApiTracerFactory;
import com.google.api.gax.tracing.MetricsTracerFactory;
import com.google.api.gax.tracing.OpenTelemetryMetricsRecorder;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.api.metrics.DoubleHistogram;
import io.opentelemetry.api.metrics.Meter;
import io.opentelemetry.api.metrics.MeterProvider;
import java.util.HashMap;
import java.util.Map;

/**
 * A provider for built-in metrics. This class is responsible for storing OpenTelemetry metrics
 * configuration and recording built-in metrics for the Firestore SDK.
 */
class BuiltinMetricsProvider {
  private OpenTelemetry openTelemetry;
  private Meter meter;
  private DoubleHistogram endToEndRequestLatency;
  private DoubleHistogram firstResponseLatency;

  private ApiTracerFactory apiTracerFactory;
  private final Map<String, String> staticAttributes;

  private static final String MILLISECOND_UNIT = "ms";
  private static final String FIRESTORE_LIBRARY_NAME = "com.google.cloud.firestore";

  public BuiltinMetricsProvider(OpenTelemetry openTelemetry) {
    this.openTelemetry = openTelemetry;
    this.staticAttributes = createStaticAttributes();

    if (openTelemetry.getMeterProvider() != MeterProvider.noop()) {
      configureRPCLayerMetrics();
      configureSDKLayerMetrics();
    }
  }

  public ApiTracerFactory getApiTracerFactory() {
    return this.apiTracerFactory;
  }

  public void endToEndLatencyRecorder(double latency, Map<String, String> attributes) {
    recordLatency(endToEndRequestLatency, latency, attributes);
  }

  public void firstResponseLatencyRecorder(double latency, Map<String, String> attributes) {
    recordLatency(firstResponseLatency, latency, attributes);
  }

  private void recordLatency(
      DoubleHistogram latencyHistogram, double latency, Map<String, String> attributes) {
    if (latencyHistogram != null) {
      attributes.putAll(staticAttributes);
      latencyHistogram.record(latency, toOtelAttributes(attributes));
    }
  }

  /** Creates an ApiTracerFactory to be passed into GAX library and collect RPC layer metrics. */
  private void configureRPCLayerMetrics() {
    OpenTelemetryMetricsRecorder recorder =
        new OpenTelemetryMetricsRecorder(openTelemetry, METRIC_PREFIX);
    this.apiTracerFactory = new MetricsTracerFactory(recorder, staticAttributes);
  }

  /** Registers metrics to be collected at the Firestore SDK layer */
  private void configureSDKLayerMetrics() {
    this.meter = openTelemetry.getMeter(FIRESTORE_METER_NAME);

    this.endToEndRequestLatency =
        meter
            .histogramBuilder(METRIC_PREFIX + "/" + METRIC_NAME_END_TO_END_LATENCY)
            .setDescription("Firestore operations' end-to-end latency")
            .setUnit(MILLISECOND_UNIT)
            .build();

    this.firstResponseLatency =
        meter
            .histogramBuilder(METRIC_PREFIX + "/" + METRIC_NAME_FIRST_RESPONSE_LATENCY)
            .setDescription("Firestore streaming operations' first response latency")
            .setUnit(MILLISECOND_UNIT)
            .build();
    // TODO(metrics): add transaction latency and retry count metrics
  }

  private Map<String, String> createStaticAttributes() {
    Map<String, String> staticAttributes = new HashMap<>();
    staticAttributes.put(METRIC_ATTRIBUTE_KEY_CLIENT_UID.getKey(), ClientIdentifier.getClientUid());
    staticAttributes.put(METRIC_ATTRIBUTE_KEY_LIBRARY_NAME.getKey(), FIRESTORE_LIBRARY_NAME);
    String pkgVersion = this.getClass().getPackage().getImplementationVersion();
    if (pkgVersion != null) {
      staticAttributes.put(METRIC_ATTRIBUTE_KEY_LIBRARY_VERSION.getKey(), pkgVersion);
    }
    return staticAttributes;
  }

  private Attributes toOtelAttributes(Map<String, String> attributes) {
    AttributesBuilder attributesBuilder = Attributes.builder();
    attributes.forEach(attributesBuilder::put);
    return attributesBuilder.build();
  }
}
