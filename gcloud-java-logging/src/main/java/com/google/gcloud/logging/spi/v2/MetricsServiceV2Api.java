/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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
package com.google.gcloud.logging.spi.v2;

import com.google.logging.v2.CreateLogMetricRequest;
import com.google.logging.v2.DeleteLogMetricRequest;
import com.google.logging.v2.GetLogMetricRequest;
import com.google.logging.v2.ListLogMetricsRequest;
import com.google.logging.v2.ListLogMetricsResponse;
import com.google.logging.v2.LogMetric;
import com.google.logging.v2.MetricsServiceV2Grpc;
import com.google.logging.v2.UpdateLogMetricRequest;
import com.google.protobuf.Empty;
import io.gapi.gax.grpc.ApiCallable;
import io.gapi.gax.grpc.PageDescriptor;
import io.gapi.gax.grpc.ServiceApiSettings;
import io.gapi.gax.internal.ApiUtils;
import io.gapi.gax.protobuf.PathTemplate;
import io.grpc.ManagedChannel;
import java.io.IOException;

// Manually-added imports: add custom (non-generated) imports after this point.



// AUTO-GENERATED DOCUMENTATION AND SERVICE - see instructions at the top of the file for editing.
/**
 * See //google/logging/v1/logging.proto for documentation
 *
 * <!-- manual edit -->
 * <!-- end manual edit -->
 */
@javax.annotation.Generated("by API code generation")
public class MetricsServiceV2Api implements AutoCloseable {

  // =========
  // Constants
  // =========

  /**
   * The default address of the service.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public static final String SERVICE_ADDRESS = "logging.googleapis.com";

  /**
   * The default port of the service.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public static final int DEFAULT_SERVICE_PORT = 443;


  private static final ApiCallable<ListLogMetricsRequest, ListLogMetricsResponse>
      LIST_LOG_METRICS = ApiCallable.create(MetricsServiceV2Grpc.METHOD_LIST_LOG_METRICS);
  private static final ApiCallable<GetLogMetricRequest, LogMetric>
      GET_LOG_METRIC = ApiCallable.create(MetricsServiceV2Grpc.METHOD_GET_LOG_METRIC);
  private static final ApiCallable<CreateLogMetricRequest, LogMetric>
      CREATE_LOG_METRIC = ApiCallable.create(MetricsServiceV2Grpc.METHOD_CREATE_LOG_METRIC);
  private static final ApiCallable<UpdateLogMetricRequest, LogMetric>
      UPDATE_LOG_METRIC = ApiCallable.create(MetricsServiceV2Grpc.METHOD_UPDATE_LOG_METRIC);
  private static final ApiCallable<DeleteLogMetricRequest, Empty>
      DELETE_LOG_METRIC = ApiCallable.create(MetricsServiceV2Grpc.METHOD_DELETE_LOG_METRIC);

  private static PageDescriptor<ListLogMetricsRequest, ListLogMetricsResponse, LogMetric> LIST_LOG_METRICS_PAGE_DESC =
      new PageDescriptor<ListLogMetricsRequest, ListLogMetricsResponse, LogMetric>() {
        @Override
        public Object emptyToken() {
          return "";
        }
        @Override
        public ListLogMetricsRequest injectToken(
            ListLogMetricsRequest payload, Object token) {
          return ListLogMetricsRequest
            .newBuilder(payload)
            .setPageToken((String) token)
            .build();
        }
        @Override
        public Object extractNextToken(ListLogMetricsResponse payload) {
          return payload.getNextPageToken();
        }
        @Override
        public Iterable<LogMetric> extractResources(ListLogMetricsResponse payload) {
          return payload.getMetricsList();
        }
      };

  private static String ALL_SCOPES[] = {
    "https://www.googleapis.com/auth/logging.read",
    "https://www.googleapis.com/auth/logging.write",
    "https://www.googleapis.com/auth/logging.admin"
  };

  /**
   * A PathTemplate representing the fully-qualified path to represent
   * a project_name resource.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  private static final PathTemplate PROJECT_NAME_PATH_TEMPLATE =
      PathTemplate.create("/projects/{project}");
  /**
   * A PathTemplate representing the fully-qualified path to represent
   * a metric_name resource.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  private static final PathTemplate METRIC_NAME_PATH_TEMPLATE =
      PathTemplate.create("/projects/{project}/metrics/{metric}");

  // ========
  // Members
  // ========

  private final ManagedChannel channel;
  private final ServiceApiSettings settings;

  // ===============
  // Factory Methods
  // ===============

  /**
   * Constructs an instance of MetricsServiceV2Api with default settings.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public static MetricsServiceV2Api create() throws IOException {
    return create(new ServiceApiSettings());
  }

  /**
   * Constructs an instance of MetricsServiceV2Api, using the given settings. The channels are created based
   * on the settings passed in, or defaults for any settings that are not set.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public static MetricsServiceV2Api create(ServiceApiSettings settings) throws IOException {
    return new MetricsServiceV2Api(settings);
  }

  /**
   * Constructs an instance of MetricsServiceV2Api, using the given settings. This is protected so that it
   * easy to make a subclass, but otherwise, the static factory methods should be preferred.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  protected MetricsServiceV2Api(ServiceApiSettings settings) throws IOException {
    ServiceApiSettings internalSettings = ApiUtils.populateSettings(settings,
        SERVICE_ADDRESS, DEFAULT_SERVICE_PORT, ALL_SCOPES);
    this.settings = internalSettings;
    this.channel = internalSettings.getChannel();
  }

  // ==============================
  // Resource Name Helper Functions
  // ==============================

  /**
   * Creates a string containing the fully-qualified path to represent
   * a project_name resource.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public static final String createProjectNamePath(String project) {
    return PROJECT_NAME_PATH_TEMPLATE.instantiate(
        "project", project);
  }

  /**
   * Creates a string containing the fully-qualified path to represent
   * a metric_name resource.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public static final String createMetricNamePath(String project, String metric) {
    return METRIC_NAME_PATH_TEMPLATE.instantiate(
        "project", project,"metric", metric);
  }


  /**
   * Extracts the project from the given fully-qualified path which
   * represents a projectName resource.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public static final String extractProjectFromProjectNamePath(String projectNamePath) {
    return PROJECT_NAME_PATH_TEMPLATE.parse(projectNamePath).get("project");
  }

  /**
   * Extracts the project from the given fully-qualified path which
   * represents a metricName resource.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public static final String extractProjectFromMetricNamePath(String metricNamePath) {
    return METRIC_NAME_PATH_TEMPLATE.parse(metricNamePath).get("project");
  }

  /**
   * Extracts the metric from the given fully-qualified path which
   * represents a metricName resource.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public static final String extractMetricFromMetricNamePath(String metricNamePath) {
    return METRIC_NAME_PATH_TEMPLATE.parse(metricNamePath).get("metric");
  }


  // =============
  // Service Calls
  // =============

  // ----- listLogMetrics -----

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Lists logs-based metrics.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public Iterable<LogMetric> listLogMetrics(String projectName) {
    ListLogMetricsRequest request =
        ListLogMetricsRequest.newBuilder()
        .setProjectName(projectName)
        .build();
    return listLogMetrics(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Lists logs-based metrics.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   *
   * @param request The request object containing all of the parameters for the API call.
   */
  public Iterable<LogMetric> listLogMetrics(ListLogMetricsRequest request) {
    return listLogMetricsStreamingCallable()
        .iterableResponseStreamCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Lists logs-based metrics.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public ApiCallable<ListLogMetricsRequest, LogMetric> listLogMetricsStreamingCallable() {
    return listLogMetricsCallable().pageStreaming(LIST_LOG_METRICS_PAGE_DESC);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Lists logs-based metrics.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public ApiCallable<ListLogMetricsRequest, ListLogMetricsResponse> listLogMetricsCallable() {
    return ApiUtils.prepareIdempotentCallable(LIST_LOG_METRICS, settings).bind(channel);
  }

  // ----- getLogMetric -----

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Gets a logs-based metric.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   *
   * @param metricName The resource name of the desired metric.
   * Example: `"projects/my-project-id/metrics/my-metric-id"`.
   */
  public LogMetric getLogMetric(String metricName) {
    GetLogMetricRequest request =
        GetLogMetricRequest.newBuilder()
        .setMetricName(metricName)
        .build();

    return getLogMetric(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Gets a logs-based metric.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   *
   * @param request The request object containing all of the parameters for the API call.
   */
  public LogMetric getLogMetric(GetLogMetricRequest request) {
    return getLogMetricCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Gets a logs-based metric.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public ApiCallable<GetLogMetricRequest, LogMetric> getLogMetricCallable() {
    return ApiUtils.prepareIdempotentCallable(GET_LOG_METRIC, settings).bind(channel);
  }

  // ----- createLogMetric -----

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Creates a logs-based metric.
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
   */
  public LogMetric createLogMetric(String projectName, LogMetric metric) {
    CreateLogMetricRequest request =
        CreateLogMetricRequest.newBuilder()
        .setProjectName(projectName)
        .setMetric(metric)
        .build();

    return createLogMetric(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Creates a logs-based metric.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   *
   * @param request The request object containing all of the parameters for the API call.
   */
  public LogMetric createLogMetric(CreateLogMetricRequest request) {
    return createLogMetricCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Creates a logs-based metric.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public ApiCallable<CreateLogMetricRequest, LogMetric> createLogMetricCallable() {
    return CREATE_LOG_METRIC.bind(channel);
  }

  // ----- updateLogMetric -----

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Creates or updates a logs-based metric.
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
   */
  public LogMetric updateLogMetric(String metricName, LogMetric metric) {
    UpdateLogMetricRequest request =
        UpdateLogMetricRequest.newBuilder()
        .setMetricName(metricName)
        .setMetric(metric)
        .build();

    return updateLogMetric(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Creates or updates a logs-based metric.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   *
   * @param request The request object containing all of the parameters for the API call.
   */
  public LogMetric updateLogMetric(UpdateLogMetricRequest request) {
    return updateLogMetricCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Creates or updates a logs-based metric.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public ApiCallable<UpdateLogMetricRequest, LogMetric> updateLogMetricCallable() {
    return ApiUtils.prepareIdempotentCallable(UPDATE_LOG_METRIC, settings).bind(channel);
  }

  // ----- deleteLogMetric -----

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Deletes a logs-based metric.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   *
   * @param metricName The resource name of the metric to delete.
   * Example: `"projects/my-project-id/metrics/my-metric-id"`.
   */
  public void deleteLogMetric(String metricName) {
    DeleteLogMetricRequest request =
        DeleteLogMetricRequest.newBuilder()
        .setMetricName(metricName)
        .build();

    deleteLogMetric(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Deletes a logs-based metric.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   *
   * @param request The request object containing all of the parameters for the API call.
   */
  public void deleteLogMetric(DeleteLogMetricRequest request) {
    deleteLogMetricCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Deletes a logs-based metric.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public ApiCallable<DeleteLogMetricRequest, Empty> deleteLogMetricCallable() {
    return ApiUtils.prepareIdempotentCallable(DELETE_LOG_METRIC, settings).bind(channel);
  }


  // ========
  // Cleanup
  // ========

  /**
   * Initiates an orderly shutdown in which preexisting calls continue but new calls are immediately
   * cancelled.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  @Override
  public void close() {
    // Manually-added shutdown code

    // Auto-generated shutdown code
    channel.shutdown();

    // Manually-added shutdown code
  }


  // ========
  // Manually-added methods: add custom (non-generated) methods after this point.
  // ========

}
