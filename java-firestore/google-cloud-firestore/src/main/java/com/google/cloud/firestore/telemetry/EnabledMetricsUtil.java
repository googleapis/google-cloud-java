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

import static com.google.cloud.firestore.telemetry.TelemetryConstants.COMMON_ATTRIBUTES;
import static com.google.cloud.firestore.telemetry.TelemetryConstants.FIRESTORE_METER_NAME;
import static com.google.cloud.firestore.telemetry.TelemetryConstants.FIRESTORE_METRICS;
import static com.google.cloud.firestore.telemetry.TelemetryConstants.GAX_METER_NAME;
import static com.google.cloud.firestore.telemetry.TelemetryConstants.GAX_METRICS;
import static com.google.cloud.firestore.telemetry.TelemetryConstants.METRIC_ATTRIBUTE_KEY_METHOD;
import static com.google.cloud.firestore.telemetry.TelemetryConstants.METRIC_ATTRIBUTE_KEY_STATUS;
import static com.google.cloud.firestore.telemetry.TelemetryConstants.METRIC_PREFIX;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutureCallback;
import com.google.api.core.ApiFutures;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.tracing.ApiTracerFactory;
import com.google.cloud.firestore.FirestoreException;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.cloud.firestore.telemetry.TelemetryConstants.MetricType;
import com.google.cloud.opentelemetry.metric.GoogleCloudMetricExporter;
import com.google.cloud.opentelemetry.metric.MetricConfiguration;
import com.google.common.base.Stopwatch;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.MoreExecutors;
import io.grpc.Status;
import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.metrics.InstrumentSelector;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.SdkMeterProviderBuilder;
import io.opentelemetry.sdk.metrics.View;
import io.opentelemetry.sdk.metrics.export.MetricExporter;
import io.opentelemetry.sdk.metrics.export.PeriodicMetricReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.annotation.Nullable;

/**
 * An implementation of {@link MetricsUtil} that uses OpenTelemetry to collect and export metrics.
 * `FirestoreOpenTelemetryOptions` in `FirestoreOptions` can be used to configure its behavior.
 */
class EnabledMetricsUtil implements MetricsUtil {
  private BuiltinMetricsProvider defaultMetricsProvider;
  private BuiltinMetricsProvider customMetricsProvider;

  private static final Logger logger = Logger.getLogger(EnabledMetricsUtil.class.getName());

  EnabledMetricsUtil(FirestoreOptions firestoreOptions) {
    try {
      configureDefaultMetricsProvider(firestoreOptions);
      configureCustomMetricsProvider(firestoreOptions);
    } catch (IOException e) {
      logger.warning(
          "Unable to create MetricsUtil object for client side metrics, will skip exporting client"
              + " side metrics"
              + e);
    }
  }

  private void configureDefaultMetricsProvider(FirestoreOptions firestoreOptions)
      throws IOException {
    OpenTelemetry defaultOpenTelemetry;
    boolean exportBuiltinMetricsToGoogleCloudMonitoring =
        firestoreOptions.getOpenTelemetryOptions().exportBuiltinMetricsToGoogleCloudMonitoring();
    if (exportBuiltinMetricsToGoogleCloudMonitoring) {
      defaultOpenTelemetry = getDefaultOpenTelemetryInstance(firestoreOptions.getProjectId());
    } else {
      defaultOpenTelemetry = OpenTelemetry.noop();
    }
    this.defaultMetricsProvider = new BuiltinMetricsProvider(defaultOpenTelemetry);
  }

  private void configureCustomMetricsProvider(FirestoreOptions firestoreOptions)
      throws IOException {
    OpenTelemetry customOpenTelemetry =
        firestoreOptions.getOpenTelemetryOptions().getOpenTelemetry();
    if (customOpenTelemetry == null) {
      customOpenTelemetry = GlobalOpenTelemetry.get();
    }
    this.customMetricsProvider = new BuiltinMetricsProvider(customOpenTelemetry);
  }

  @Override
  public MetricsContext createMetricsContext(String methodName) {
    return new MetricsContext(methodName);
  }

  @Override
  public void addMetricsTracerFactory(List<ApiTracerFactory> apiTracerFactories) {
    addTracerFactory(apiTracerFactories, defaultMetricsProvider);
    addTracerFactory(apiTracerFactories, customMetricsProvider);
  }

  /**
   * Creates a default {@link OpenTelemetry} instance to collect and export built-in client side
   * metrics to Google Cloud Monitoring.
   */
  private OpenTelemetry getDefaultOpenTelemetryInstance(String projectId) throws IOException {
    SdkMeterProviderBuilder sdkMeterProviderBuilder = SdkMeterProvider.builder();

    // Filter out attributes that are not defined
    for (Map.Entry<InstrumentSelector, View> entry : getAllViews().entrySet()) {
      sdkMeterProviderBuilder.registerView(entry.getKey(), entry.getValue());
    }

    MetricExporter metricExporter =
        GoogleCloudMetricExporter.createWithConfiguration(
            MetricConfiguration.builder()
                .setProjectId(projectId)
                // Ignore library info as it is collected by the metric attributes as well
                .setInstrumentationLibraryLabelsEnabled(false)
                .build());
    sdkMeterProviderBuilder.registerMetricReader(PeriodicMetricReader.create(metricExporter));

    return OpenTelemetrySdk.builder().setMeterProvider(sdkMeterProviderBuilder.build()).build();
  }

  private static Map<InstrumentSelector, View> getAllViews() {
    ImmutableMap.Builder<InstrumentSelector, View> views = ImmutableMap.builder();
    GAX_METRICS.forEach(metric -> defineView(views, metric, GAX_METER_NAME));
    FIRESTORE_METRICS.forEach(metric -> defineView(views, metric, FIRESTORE_METER_NAME));
    return views.build();
  }

  private static void defineView(
      ImmutableMap.Builder<InstrumentSelector, View> viewMap, String id, String meter) {
    InstrumentSelector selector =
        InstrumentSelector.builder().setMeterName(meter).setName(METRIC_PREFIX + "/" + id).build();
    Set<String> attributesFilter =
        ImmutableSet.<String>builder()
            .addAll(
                COMMON_ATTRIBUTES.stream().map(AttributeKey::getKey).collect(Collectors.toSet()))
            .build();
    View view = View.builder().setAttributeFilter(attributesFilter).build();

    viewMap.put(selector, view);
  }

  private void addTracerFactory(
      List<ApiTracerFactory> apiTracerFactories, BuiltinMetricsProvider metricsProvider) {
    ApiTracerFactory tracerFactory = metricsProvider.getApiTracerFactory();
    if (tracerFactory != null) {
      apiTracerFactories.add(tracerFactory);
    }
  }

  class MetricsContext implements MetricsUtil.MetricsContext {
    private final Stopwatch stopwatch;
    private int counter;
    protected final String methodName;

    public MetricsContext(String methodName) {
      this.stopwatch = Stopwatch.createStarted();
      this.methodName = methodName;
      this.counter = 0;
    }

    public <T> void recordLatencyAtFuture(MetricType metric, ApiFuture<T> futureValue) {
      ApiFutures.addCallback(
          futureValue,
          new ApiFutureCallback<T>() {
            @Override
            public void onFailure(Throwable t) {
              recordLatency(metric, t);
            }

            @Override
            public void onSuccess(T result) {
              recordLatency(metric);
            }
          },
          MoreExecutors.directExecutor());
    }

    public void recordLatency(MetricType metric) {
      recordLatency(metric, StatusCode.Code.OK.toString());
    }

    public void recordLatency(MetricType metric, Throwable t) {
      recordLatency(metric, extractErrorStatus(t));
    }

    private void recordLatency(MetricType metric, String status) {
      double elapsedTime = stopwatch.elapsed(TimeUnit.MILLISECONDS);
      Map<String, String> attributes = createAttributes(status, methodName);
      defaultMetricsProvider.latencyRecorder(metric, elapsedTime, attributes);
      customMetricsProvider.latencyRecorder(metric, elapsedTime, attributes);
    }

    public void incrementCounter() {
      counter++;
    }

    public <T> void recordCounterAtFuture(MetricType metric, ApiFuture<T> futureValue) {
      ApiFutures.addCallback(
          futureValue,
          new ApiFutureCallback<T>() {
            @Override
            public void onFailure(Throwable t) {
              recordCounter(metric, extractErrorStatus(t));
            }

            @Override
            public void onSuccess(T result) {
              recordCounter(metric, StatusCode.Code.OK.toString());
            }
          },
          MoreExecutors.directExecutor());
    }

    private void recordCounter(MetricType metric, String status) {
      Map<String, String> attributes = createAttributes(status, methodName);
      defaultMetricsProvider.counterRecorder(
          MetricType.TRANSACTION_ATTEMPT_COUNT, (long) counter, attributes);
      customMetricsProvider.counterRecorder(
          MetricType.TRANSACTION_ATTEMPT_COUNT, (long) counter, attributes);
    }
  }

  private Map<String, String> createAttributes(String status, String methodName) {
    Map<String, String> attributes = new HashMap<>();
    attributes.put(METRIC_ATTRIBUTE_KEY_METHOD.getKey(), methodName);
    attributes.put(METRIC_ATTRIBUTE_KEY_STATUS.getKey(), status);
    return attributes;
  }

  private String extractErrorStatus(@Nullable Throwable throwable) {
    if (!(throwable instanceof FirestoreException)) {
      return StatusCode.Code.UNKNOWN.toString();
    }

    Status status = ((FirestoreException) throwable).getStatus();
    if (status == null) {
      return StatusCode.Code.UNKNOWN.toString();
    }
    return status.getCode().name();
  }
}
