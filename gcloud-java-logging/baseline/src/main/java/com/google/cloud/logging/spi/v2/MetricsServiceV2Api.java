/*
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

/*
 * EDITING INSTRUCTIONS
 * This file was generated from the file
 * https://github.com/google/googleapis/blob/master/google/logging/v2/logging_metrics.proto
 * and updates to that file get reflected here through a refresh process.
 * For the short term, the refresh process will only be runnable by Google engineers.
 * Manual additions are allowed because the refresh process performs
 * a 3-way merge in order to preserve those manual additions. In order to not
 * break the refresh process, only certain types of modifications are
 * allowed.
 *
 * Allowed modifications - currently these are the only types allowed:
 * 1. New methods (these should be added to the end of the class)
 * 2. New imports
 * 3. Additional documentation between "manual edit" demarcations
 *
 * Happy editing!
 */

package com.google.cloud.logging.spi.v2;

import com.google.api.gax.core.PageAccessor;
import com.google.api.gax.grpc.ApiCallable;
import com.google.api.gax.protobuf.PathTemplate;
import com.google.logging.v2.CreateLogMetricRequest;
import com.google.logging.v2.DeleteLogMetricRequest;
import com.google.logging.v2.GetLogMetricRequest;
import com.google.logging.v2.ListLogMetricsRequest;
import com.google.logging.v2.ListLogMetricsResponse;
import com.google.logging.v2.LogMetric;
import com.google.logging.v2.UpdateLogMetricRequest;
import com.google.protobuf.Empty;
import io.grpc.ManagedChannel;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

// Manually-added imports: add custom (non-generated) imports after this point.

// AUTO-GENERATED DOCUMENTATION AND SERVICE - see instructions at the top of the file for editing.
/**
 * Service Description:
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (MetricsServiceV2Api metricsServiceV2Api = MetricsServiceV2Api.createWithDefaults()) {
 *   String formattedProjectName = MetricsServiceV2Api.formatProjectName("[PROJECT]");
 *   ListLogMetricsResponse response = metricsServiceV2Api.listLogMetrics(formattedProjectName);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the metricsServiceV2Api object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's methods:
 *
 * <ol>
 * <li> A "flattened" method. With this type of method, the fields of the request type have been
 * converted into function parameters. It may be the case that not all fields are available
 * as parameters, and not every API method will have a flattened method entry point.
 * <li> A "request object" method. This type of method only takes one parameter, a request
 * object, which must be constructed before the call. Not every API method will have a request
 * object method.
 * <li> A "callable" method. This type of method takes no parameters and returns an immutable
 * ApiCallable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist
 * with these names, this class includes a format method for each type of name, and additionally
 * a parse method to extract the individual identifiers contained within names that are
 * returned.
 *
 * <p>This class can be customized by passing in a custom instance of MetricsServiceV2Settings to
 * create(). For example:
 *
 * <pre>
 * <code>
 * MetricsServiceV2Settings metricsServiceV2Settings = MetricsServiceV2Settings.defaultBuilder()
 *     .provideChannelWith(myCredentials)
 *     .build();
 * MetricsServiceV2Api metricsServiceV2Api = MetricsServiceV2Api.create(metricsServiceV2Settings);
 * </code>
 * </pre>
 *
 * <!-- manual edit -->
 * <!-- end manual edit -->
 */
@javax.annotation.Generated("by GAPIC")
public class MetricsServiceV2Api implements AutoCloseable {
  private final MetricsServiceV2Settings settings;
  private final ManagedChannel channel;
  private final ScheduledExecutorService executor;
  private final List<AutoCloseable> closeables = new ArrayList<>();

  private final ApiCallable<ListLogMetricsRequest, ListLogMetricsResponse> listLogMetricsCallable;
  private final ApiCallable<ListLogMetricsRequest, PageAccessor<LogMetric>>
      listLogMetricsPagedCallable;
  private final ApiCallable<GetLogMetricRequest, LogMetric> getLogMetricCallable;
  private final ApiCallable<CreateLogMetricRequest, LogMetric> createLogMetricCallable;
  private final ApiCallable<UpdateLogMetricRequest, LogMetric> updateLogMetricCallable;
  private final ApiCallable<DeleteLogMetricRequest, Empty> deleteLogMetricCallable;

  public final MetricsServiceV2Settings getSettings() {
    return settings;
  }

  private static final PathTemplate PROJECT_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}");

  private static final PathTemplate METRIC_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/metrics/{metric}");

  /**
   * Formats a string containing the fully-qualified path to represent
   * a project resource.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public static final String formatProjectName(String project) {
    return PROJECT_PATH_TEMPLATE.instantiate("project", project);
  }

  /**
   * Formats a string containing the fully-qualified path to represent
   * a metric resource.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public static final String formatMetricName(String project, String metric) {
    return METRIC_PATH_TEMPLATE.instantiate("project", project, "metric", metric);
  }

  /**
   * Parses the project from the given fully-qualified path which
   * represents a project resource.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public static final String parseProjectFromProjectName(String projectName) {
    return PROJECT_PATH_TEMPLATE.parse(projectName).get("project");
  }

  /**
   * Parses the project from the given fully-qualified path which
   * represents a metric resource.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public static final String parseProjectFromMetricName(String metricName) {
    return METRIC_PATH_TEMPLATE.parse(metricName).get("project");
  }

  /**
   * Parses the metric from the given fully-qualified path which
   * represents a metric resource.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public static final String parseMetricFromMetricName(String metricName) {
    return METRIC_PATH_TEMPLATE.parse(metricName).get("metric");
  }

  /**
   * Constructs an instance of MetricsServiceV2Api with default settings.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public static final MetricsServiceV2Api createWithDefaults() throws IOException {
    return create(MetricsServiceV2Settings.defaultBuilder().build());
  }

  /**
   * Constructs an instance of MetricsServiceV2Api, using the given settings.
   * The channels are created based on the settings passed in, or defaults for any
   * settings that are not set.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public static final MetricsServiceV2Api create(MetricsServiceV2Settings settings)
      throws IOException {
    return new MetricsServiceV2Api(settings);
  }

  /**
   * Constructs an instance of MetricsServiceV2Api, using the given settings.
   * This is protected so that it easy to make a subclass, but otherwise, the static
   * factory methods should be preferred.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  protected MetricsServiceV2Api(MetricsServiceV2Settings settings) throws IOException {
    this.settings = settings;
    this.executor = settings.getExecutorProvider().getOrBuildExecutor();
    this.channel = settings.getChannelProvider().getOrBuildChannel(this.executor);

    this.listLogMetricsCallable =
        ApiCallable.create(settings.listLogMetricsSettings(), this.channel, this.executor);
    this.listLogMetricsPagedCallable =
        ApiCallable.createPagedVariant(
            settings.listLogMetricsSettings(), this.channel, this.executor);
    this.getLogMetricCallable =
        ApiCallable.create(settings.getLogMetricSettings(), this.channel, this.executor);
    this.createLogMetricCallable =
        ApiCallable.create(settings.createLogMetricSettings(), this.channel, this.executor);
    this.updateLogMetricCallable =
        ApiCallable.create(settings.updateLogMetricSettings(), this.channel, this.executor);
    this.deleteLogMetricCallable =
        ApiCallable.create(settings.deleteLogMetricSettings(), this.channel, this.executor);

    if (settings.getChannelProvider().shouldAutoClose()) {
      closeables.add(
          new Closeable() {
            @Override
            public void close() throws IOException {
              channel.shutdown();
            }
          });
    }
    if (settings.getExecutorProvider().shouldAutoClose()) {
      closeables.add(
          new Closeable() {
            @Override
            public void close() throws IOException {
              executor.shutdown();
            }
          });
    }
  }

  // ----- listLogMetrics -----

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Lists logs-based metrics.
   *
   * Sample code:
   * <pre><code>
   * try (MetricsServiceV2Api metricsServiceV2Api = MetricsServiceV2Api.createWithDefaults()) {
   *   String formattedProjectName = MetricsServiceV2Api.formatProjectName("[PROJECT]");
   *   for (LogMetric elements : metricsServiceV2Api.listLogMetrics(formattedProjectName)) {
   *     // doThingsWith(elements);
   *   }
   * }
   * </code></pre>
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   *
   * @param projectName Required. The resource name of the project containing the metrics.
   * Example: `"projects/my-project-id"`.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final PageAccessor<LogMetric> listLogMetrics(String projectName) {
    PROJECT_PATH_TEMPLATE.validate(projectName);
    ListLogMetricsRequest request =
        ListLogMetricsRequest.newBuilder().setProjectName(projectName).build();
    return listLogMetrics(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Lists logs-based metrics.
   *
   * Sample code:
   * <pre><code>
   * try (MetricsServiceV2Api metricsServiceV2Api = MetricsServiceV2Api.createWithDefaults()) {
   *   String formattedProjectName = MetricsServiceV2Api.formatProjectName("[PROJECT]");
   *   ListLogMetricsRequest request = ListLogMetricsRequest.newBuilder()
   *     .setProjectName(formattedProjectName)
   *     .build();
   *   for (LogMetric elements : metricsServiceV2Api.listLogMetrics(request)) {
   *     // doThingsWith(elements);
   *   }
   * }
   * </code></pre>
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final PageAccessor<LogMetric> listLogMetrics(ListLogMetricsRequest request) {
    return listLogMetricsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Lists logs-based metrics.
   *
   * Sample code:
   * <pre><code>
   * try (MetricsServiceV2Api metricsServiceV2Api = MetricsServiceV2Api.createWithDefaults()) {
   *   String formattedProjectName = MetricsServiceV2Api.formatProjectName("[PROJECT]");
   *   ListLogMetricsRequest request = ListLogMetricsRequest.newBuilder()
   *     .setProjectName(formattedProjectName)
   *     .build();
   *   ListenableFuture&lt;PageAccessor&lt;LogMetric&gt;&gt; future = metricsServiceV2Api.listLogMetricsPagedCallable().futureCall(request);
   *   // Do something
   *   for (LogMetric elements : future.get()) {
   *     // doThingsWith(elements);
   *   }
   * }
   * </code></pre>
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public final ApiCallable<ListLogMetricsRequest, PageAccessor<LogMetric>>
      listLogMetricsPagedCallable() {
    return listLogMetricsPagedCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Lists logs-based metrics.
   *
   * Sample code:
   * <pre><code>
   * try (MetricsServiceV2Api metricsServiceV2Api = MetricsServiceV2Api.createWithDefaults()) {
   *   String formattedProjectName = MetricsServiceV2Api.formatProjectName("[PROJECT]");
   *   ListLogMetricsRequest request = ListLogMetricsRequest.newBuilder()
   *     .setProjectName(formattedProjectName)
   *     .build();
   *   while (true) {
   *     ListLogMetricsResponse response = metricsServiceV2Api.listLogMetricsCallable().call(request);
   *     for (LogMetric elements : response.getMetricsList()) {
   *       // doThingsWith(elements);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * </code></pre>
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public final ApiCallable<ListLogMetricsRequest, ListLogMetricsResponse> listLogMetricsCallable() {
    return listLogMetricsCallable;
  }

  // ----- getLogMetric -----

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Gets a logs-based metric.
   *
   * Sample code:
   * <pre><code>
   * try (MetricsServiceV2Api metricsServiceV2Api = MetricsServiceV2Api.createWithDefaults()) {
   *   String formattedMetricName = MetricsServiceV2Api.formatMetricName("[PROJECT]", "[METRIC]");
   *   LogMetric response = metricsServiceV2Api.getLogMetric(formattedMetricName);
   * }
   * </code></pre>
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   *
   * @param metricName The resource name of the desired metric.
   * Example: `"projects/my-project-id/metrics/my-metric-id"`.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final LogMetric getLogMetric(String metricName) {
    METRIC_PATH_TEMPLATE.validate(metricName);
    GetLogMetricRequest request =
        GetLogMetricRequest.newBuilder().setMetricName(metricName).build();
    return getLogMetric(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Gets a logs-based metric.
   *
   * Sample code:
   * <pre><code>
   * try (MetricsServiceV2Api metricsServiceV2Api = MetricsServiceV2Api.createWithDefaults()) {
   *   String formattedMetricName = MetricsServiceV2Api.formatMetricName("[PROJECT]", "[METRIC]");
   *   GetLogMetricRequest request = GetLogMetricRequest.newBuilder()
   *     .setMetricName(formattedMetricName)
   *     .build();
   *   LogMetric response = metricsServiceV2Api.getLogMetric(request);
   * }
   * </code></pre>
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  private LogMetric getLogMetric(GetLogMetricRequest request) {
    return getLogMetricCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Gets a logs-based metric.
   *
   * Sample code:
   * <pre><code>
   * try (MetricsServiceV2Api metricsServiceV2Api = MetricsServiceV2Api.createWithDefaults()) {
   *   String formattedMetricName = MetricsServiceV2Api.formatMetricName("[PROJECT]", "[METRIC]");
   *   GetLogMetricRequest request = GetLogMetricRequest.newBuilder()
   *     .setMetricName(formattedMetricName)
   *     .build();
   *   ListenableFuture&lt;LogMetric&gt; future = metricsServiceV2Api.getLogMetricCallable().futureCall(request);
   *   // Do something
   *   LogMetric response = future.get();
   * }
   * </code></pre>
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public final ApiCallable<GetLogMetricRequest, LogMetric> getLogMetricCallable() {
    return getLogMetricCallable;
  }

  // ----- createLogMetric -----

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Creates a logs-based metric.
   *
   * Sample code:
   * <pre><code>
   * try (MetricsServiceV2Api metricsServiceV2Api = MetricsServiceV2Api.createWithDefaults()) {
   *   String formattedProjectName = MetricsServiceV2Api.formatProjectName("[PROJECT]");
   *   LogMetric metric = LogMetric.newBuilder().build();
   *   LogMetric response = metricsServiceV2Api.createLogMetric(formattedProjectName, metric);
   * }
   * </code></pre>
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   *
   * @param projectName The resource name of the project in which to create the metric.
   * Example: `"projects/my-project-id"`.
   *
   * The new metric must be provided in the request.
   * @param metric The new logs-based metric, which must not have an identifier that
   * already exists.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final LogMetric createLogMetric(String projectName, LogMetric metric) {
    PROJECT_PATH_TEMPLATE.validate(projectName);

    CreateLogMetricRequest request =
        CreateLogMetricRequest.newBuilder().setProjectName(projectName).setMetric(metric).build();
    return createLogMetric(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Creates a logs-based metric.
   *
   * Sample code:
   * <pre><code>
   * try (MetricsServiceV2Api metricsServiceV2Api = MetricsServiceV2Api.createWithDefaults()) {
   *   String formattedProjectName = MetricsServiceV2Api.formatProjectName("[PROJECT]");
   *   LogMetric metric = LogMetric.newBuilder().build();
   *   CreateLogMetricRequest request = CreateLogMetricRequest.newBuilder()
   *     .setProjectName(formattedProjectName)
   *     .setMetric(metric)
   *     .build();
   *   LogMetric response = metricsServiceV2Api.createLogMetric(request);
   * }
   * </code></pre>
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public LogMetric createLogMetric(CreateLogMetricRequest request) {
    return createLogMetricCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Creates a logs-based metric.
   *
   * Sample code:
   * <pre><code>
   * try (MetricsServiceV2Api metricsServiceV2Api = MetricsServiceV2Api.createWithDefaults()) {
   *   String formattedProjectName = MetricsServiceV2Api.formatProjectName("[PROJECT]");
   *   LogMetric metric = LogMetric.newBuilder().build();
   *   CreateLogMetricRequest request = CreateLogMetricRequest.newBuilder()
   *     .setProjectName(formattedProjectName)
   *     .setMetric(metric)
   *     .build();
   *   ListenableFuture&lt;LogMetric&gt; future = metricsServiceV2Api.createLogMetricCallable().futureCall(request);
   *   // Do something
   *   LogMetric response = future.get();
   * }
   * </code></pre>
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public final ApiCallable<CreateLogMetricRequest, LogMetric> createLogMetricCallable() {
    return createLogMetricCallable;
  }

  // ----- updateLogMetric -----

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Creates or updates a logs-based metric.
   *
   * Sample code:
   * <pre><code>
   * try (MetricsServiceV2Api metricsServiceV2Api = MetricsServiceV2Api.createWithDefaults()) {
   *   String formattedMetricName = MetricsServiceV2Api.formatMetricName("[PROJECT]", "[METRIC]");
   *   LogMetric metric = LogMetric.newBuilder().build();
   *   LogMetric response = metricsServiceV2Api.updateLogMetric(formattedMetricName, metric);
   * }
   * </code></pre>
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   *
   * @param metricName The resource name of the metric to update.
   * Example: `"projects/my-project-id/metrics/my-metric-id"`.
   *
   * The updated metric must be provided in the request and have the
   * same identifier that is specified in `metricName`.
   * If the metric does not exist, it is created.
   * @param metric The updated metric, whose name must be the same as the
   * metric identifier in `metricName`. If `metricName` does not
   * exist, then a new metric is created.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final LogMetric updateLogMetric(String metricName, LogMetric metric) {
    METRIC_PATH_TEMPLATE.validate(metricName);

    UpdateLogMetricRequest request =
        UpdateLogMetricRequest.newBuilder().setMetricName(metricName).setMetric(metric).build();
    return updateLogMetric(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Creates or updates a logs-based metric.
   *
   * Sample code:
   * <pre><code>
   * try (MetricsServiceV2Api metricsServiceV2Api = MetricsServiceV2Api.createWithDefaults()) {
   *   String formattedMetricName = MetricsServiceV2Api.formatMetricName("[PROJECT]", "[METRIC]");
   *   LogMetric metric = LogMetric.newBuilder().build();
   *   UpdateLogMetricRequest request = UpdateLogMetricRequest.newBuilder()
   *     .setMetricName(formattedMetricName)
   *     .setMetric(metric)
   *     .build();
   *   LogMetric response = metricsServiceV2Api.updateLogMetric(request);
   * }
   * </code></pre>
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public LogMetric updateLogMetric(UpdateLogMetricRequest request) {
    return updateLogMetricCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Creates or updates a logs-based metric.
   *
   * Sample code:
   * <pre><code>
   * try (MetricsServiceV2Api metricsServiceV2Api = MetricsServiceV2Api.createWithDefaults()) {
   *   String formattedMetricName = MetricsServiceV2Api.formatMetricName("[PROJECT]", "[METRIC]");
   *   LogMetric metric = LogMetric.newBuilder().build();
   *   UpdateLogMetricRequest request = UpdateLogMetricRequest.newBuilder()
   *     .setMetricName(formattedMetricName)
   *     .setMetric(metric)
   *     .build();
   *   ListenableFuture&lt;LogMetric&gt; future = metricsServiceV2Api.updateLogMetricCallable().futureCall(request);
   *   // Do something
   *   LogMetric response = future.get();
   * }
   * </code></pre>
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public final ApiCallable<UpdateLogMetricRequest, LogMetric> updateLogMetricCallable() {
    return updateLogMetricCallable;
  }

  // ----- deleteLogMetric -----

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Deletes a logs-based metric.
   *
   * Sample code:
   * <pre><code>
   * try (MetricsServiceV2Api metricsServiceV2Api = MetricsServiceV2Api.createWithDefaults()) {
   *   String formattedMetricName = MetricsServiceV2Api.formatMetricName("[PROJECT]", "[METRIC]");
   *   metricsServiceV2Api.deleteLogMetric(formattedMetricName);
   * }
   * </code></pre>
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   *
   * @param metricName The resource name of the metric to delete.
   * Example: `"projects/my-project-id/metrics/my-metric-id"`.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final void deleteLogMetric(String metricName) {
    METRIC_PATH_TEMPLATE.validate(metricName);
    DeleteLogMetricRequest request =
        DeleteLogMetricRequest.newBuilder().setMetricName(metricName).build();
    deleteLogMetric(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Deletes a logs-based metric.
   *
   * Sample code:
   * <pre><code>
   * try (MetricsServiceV2Api metricsServiceV2Api = MetricsServiceV2Api.createWithDefaults()) {
   *   String formattedMetricName = MetricsServiceV2Api.formatMetricName("[PROJECT]", "[METRIC]");
   *   DeleteLogMetricRequest request = DeleteLogMetricRequest.newBuilder()
   *     .setMetricName(formattedMetricName)
   *     .build();
   *   metricsServiceV2Api.deleteLogMetric(request);
   * }
   * </code></pre>
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  private void deleteLogMetric(DeleteLogMetricRequest request) {
    deleteLogMetricCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Deletes a logs-based metric.
   *
   * Sample code:
   * <pre><code>
   * try (MetricsServiceV2Api metricsServiceV2Api = MetricsServiceV2Api.createWithDefaults()) {
   *   String formattedMetricName = MetricsServiceV2Api.formatMetricName("[PROJECT]", "[METRIC]");
   *   DeleteLogMetricRequest request = DeleteLogMetricRequest.newBuilder()
   *     .setMetricName(formattedMetricName)
   *     .build();
   *   ListenableFuture&lt;Void&gt; future = metricsServiceV2Api.deleteLogMetricCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public final ApiCallable<DeleteLogMetricRequest, Empty> deleteLogMetricCallable() {
    return deleteLogMetricCallable;
  }

  /**
   * Initiates an orderly shutdown in which preexisting calls continue but new calls are immediately
   * cancelled.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  @Override
  public final void close() throws Exception {
    for (AutoCloseable closeable : closeables) {
      closeable.close();
    }
  }

  // ========
  // Manually-added methods: add custom (non-generated) methods after this point.
  // ========

}
