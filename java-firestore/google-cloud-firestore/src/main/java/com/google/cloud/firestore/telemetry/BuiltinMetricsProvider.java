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
import static com.google.cloud.firestore.telemetry.TelemetryConstants.METRIC_NAME_TRANSACTION_ATTEMPT_COUNT;
import static com.google.cloud.firestore.telemetry.TelemetryConstants.METRIC_NAME_TRANSACTION_LATENCY;
import static com.google.cloud.firestore.telemetry.TelemetryConstants.METRIC_PREFIX;

import com.google.api.gax.tracing.ApiTracerFactory;
import com.google.api.gax.tracing.MetricsTracerFactory;
import com.google.api.gax.tracing.OpenTelemetryMetricsRecorder;
import com.google.cloud.firestore.telemetry.TelemetryConstants.MetricType;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.api.metrics.DoubleHistogram;
import io.opentelemetry.api.metrics.LongCounter;
import io.opentelemetry.api.metrics.Meter;
import io.opentelemetry.api.metrics.MeterProvider;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A provider for built-in metrics. This class is responsible for storing OpenTelemetry metrics
 * configuration and recording built-in metrics for the Firestore SDK.
 */
class BuiltinMetricsProvider {
  private static final Logger logger = Logger.getLogger(BuiltinMetricsProvider.class.getName());

  private OpenTelemetry openTelemetry;
  private DoubleHistogram endToEndLatency;
  private DoubleHistogram firstResponseLatency;
  private DoubleHistogram transactionLatency;
  private LongCounter transactionAttemptCount;

  private ApiTracerFactory apiTracerFactory;
  private final Map<String, String> staticAttributes;

  private static final String MILLISECOND_UNIT = "ms";
  private static final String INTEGER_UNIT = "1";
  private static final String FIRESTORE_LIBRARY_NAME = "com.google.cloud.firestore";

  public BuiltinMetricsProvider(OpenTelemetry openTelemetry) {
    this.openTelemetry = openTelemetry;
    this.staticAttributes = createStaticAttributes();

    if (openTelemetry.getMeterProvider() != MeterProvider.noop()) {
      configureRPCLayerMetrics();
      configureSDKLayerMetrics();
    }
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

  /** Creates an ApiTracerFactory to be passed into GAX library and collect RPC layer metrics. */
  private void configureRPCLayerMetrics() {
    OpenTelemetryMetricsRecorder recorder =
        new OpenTelemetryMetricsRecorder(openTelemetry, METRIC_PREFIX);
    this.apiTracerFactory = new MetricsTracerFactory(recorder, staticAttributes);
  }

  /** Registers metrics to be collected at the Firestore SDK layer */
  private void configureSDKLayerMetrics() {
    Meter meter = openTelemetry.getMeter(FIRESTORE_METER_NAME);

    this.endToEndLatency =
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

    this.transactionLatency =
        meter
            .histogramBuilder(METRIC_PREFIX + "/" + METRIC_NAME_TRANSACTION_LATENCY)
            .setDescription("Firestore transactions' end-to-end latency")
            .setUnit(MILLISECOND_UNIT)
            .build();

    this.transactionAttemptCount =
        meter
            .counterBuilder(METRIC_PREFIX + "/" + METRIC_NAME_TRANSACTION_ATTEMPT_COUNT)
            .setDescription("Number of Firestore transaction attempts including retries")
            .setUnit(INTEGER_UNIT)
            .build();
  }

  public ApiTracerFactory getApiTracerFactory() {
    return this.apiTracerFactory;
  }

  public void latencyRecorder(
      MetricType metricType, double latency, Map<String, String> attributes) {
    DoubleHistogram histogram = getHistogram(metricType);
    if (histogram != null) {
      attributes.putAll(staticAttributes);
      try {
        histogram.record(latency, toOtelAttributes(attributes));
      } catch (Exception e) {
        logger.log(Level.WARNING, "Failed to record latency metric: " + e.getMessage(), e);
      }
    }
  }

  public void counterRecorder(MetricType metricType, long count, Map<String, String> attributes) {
    LongCounter counter = getCounter(metricType);
    if (counter != null) {
      attributes.putAll(staticAttributes);
      try {
        counter.add(count, toOtelAttributes(attributes));
      } catch (Exception e) {
        logger.log(Level.WARNING, "Failed to record counter metric:" + e.getMessage(), e);
      }
    }
  }

  public DoubleHistogram getHistogram(MetricType metricType) {
    switch (metricType) {
      case END_TO_END_LATENCY:
        return endToEndLatency;
      case FIRST_RESPONSE_LATENCY:
        return firstResponseLatency;
      case TRANSACTION_LATENCY:
        return transactionLatency;
      default:
        throw new IllegalArgumentException("Unknown latency MetricType: " + metricType);
    }
  }

  public LongCounter getCounter(MetricType metricType) {
    if (metricType == MetricType.TRANSACTION_ATTEMPT_COUNT) {
      return transactionAttemptCount;
    } else {
      throw new IllegalArgumentException("Unknown counter MetricType: " + metricType);
    }
  }

  private Attributes toOtelAttributes(Map<String, String> attributes) {
    AttributesBuilder attributesBuilder = Attributes.builder();
    attributes.forEach(attributesBuilder::put);
    return attributesBuilder.build();
  }
}
