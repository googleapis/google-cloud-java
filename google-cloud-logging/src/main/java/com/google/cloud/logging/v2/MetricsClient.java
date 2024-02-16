/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.logging.v2;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.logging.v2.stub.MetricsServiceV2Stub;
import com.google.cloud.logging.v2.stub.MetricsServiceV2StubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.logging.v2.CreateLogMetricRequest;
import com.google.logging.v2.DeleteLogMetricRequest;
import com.google.logging.v2.GetLogMetricRequest;
import com.google.logging.v2.ListLogMetricsRequest;
import com.google.logging.v2.ListLogMetricsResponse;
import com.google.logging.v2.LogMetric;
import com.google.logging.v2.LogMetricName;
import com.google.logging.v2.ProjectName;
import com.google.logging.v2.UpdateLogMetricRequest;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for configuring logs-based metrics.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (MetricsClient metricsClient = MetricsClient.create()) {
 *   LogMetricName metricName = LogMetricName.of("[PROJECT]", "[METRIC]");
 *   LogMetric response = metricsClient.getLogMetric(metricName);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the MetricsClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> ListLogMetrics</td>
 *      <td><p> Lists logs-based metrics.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listLogMetrics(ListLogMetricsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listLogMetrics(ProjectName parent)
 *           <li><p> listLogMetrics(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listLogMetricsPagedCallable()
 *           <li><p> listLogMetricsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetLogMetric</td>
 *      <td><p> Gets a logs-based metric.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getLogMetric(GetLogMetricRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getLogMetric(LogMetricName metricName)
 *           <li><p> getLogMetric(String metricName)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getLogMetricCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateLogMetric</td>
 *      <td><p> Creates a logs-based metric.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createLogMetric(CreateLogMetricRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createLogMetric(ProjectName parent, LogMetric metric)
 *           <li><p> createLogMetric(String parent, LogMetric metric)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createLogMetricCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateLogMetric</td>
 *      <td><p> Creates or updates a logs-based metric.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateLogMetric(UpdateLogMetricRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateLogMetric(LogMetricName metricName, LogMetric metric)
 *           <li><p> updateLogMetric(String metricName, LogMetric metric)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateLogMetricCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteLogMetric</td>
 *      <td><p> Deletes a logs-based metric.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteLogMetric(DeleteLogMetricRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteLogMetric(LogMetricName metricName)
 *           <li><p> deleteLogMetric(String metricName)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteLogMetricCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *  </table>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of MetricsSettings to create().
 * For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * MetricsSettings metricsSettings =
 *     MetricsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * MetricsClient metricsClient = MetricsClient.create(metricsSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * MetricsSettings metricsSettings = MetricsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * MetricsClient metricsClient = MetricsClient.create(metricsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class MetricsClient implements BackgroundResource {
  private final MetricsSettings settings;
  private final MetricsServiceV2Stub stub;

  /** Constructs an instance of MetricsClient with default settings. */
  public static final MetricsClient create() throws IOException {
    return create(MetricsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of MetricsClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final MetricsClient create(MetricsSettings settings) throws IOException {
    return new MetricsClient(settings);
  }

  /**
   * Constructs an instance of MetricsClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(MetricsSettings).
   */
  public static final MetricsClient create(MetricsServiceV2Stub stub) {
    return new MetricsClient(stub);
  }

  /**
   * Constructs an instance of MetricsClient, using the given settings. This is protected so that it
   * is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected MetricsClient(MetricsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((MetricsServiceV2StubSettings) settings.getStubSettings()).createStub();
  }

  protected MetricsClient(MetricsServiceV2Stub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final MetricsSettings getSettings() {
    return settings;
  }

  public MetricsServiceV2Stub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists logs-based metrics.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetricsClient metricsClient = MetricsClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   for (LogMetric element : metricsClient.listLogMetrics(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the project containing the metrics:
   *     <p>"projects/[PROJECT_ID]"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLogMetricsPagedResponse listLogMetrics(ProjectName parent) {
    ListLogMetricsRequest request =
        ListLogMetricsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listLogMetrics(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists logs-based metrics.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetricsClient metricsClient = MetricsClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   for (LogMetric element : metricsClient.listLogMetrics(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the project containing the metrics:
   *     <p>"projects/[PROJECT_ID]"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLogMetricsPagedResponse listLogMetrics(String parent) {
    ListLogMetricsRequest request = ListLogMetricsRequest.newBuilder().setParent(parent).build();
    return listLogMetrics(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists logs-based metrics.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetricsClient metricsClient = MetricsClient.create()) {
   *   ListLogMetricsRequest request =
   *       ListLogMetricsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .build();
   *   for (LogMetric element : metricsClient.listLogMetrics(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLogMetricsPagedResponse listLogMetrics(ListLogMetricsRequest request) {
    return listLogMetricsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists logs-based metrics.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetricsClient metricsClient = MetricsClient.create()) {
   *   ListLogMetricsRequest request =
   *       ListLogMetricsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .build();
   *   ApiFuture<LogMetric> future = metricsClient.listLogMetricsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (LogMetric element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListLogMetricsRequest, ListLogMetricsPagedResponse>
      listLogMetricsPagedCallable() {
    return stub.listLogMetricsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists logs-based metrics.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetricsClient metricsClient = MetricsClient.create()) {
   *   ListLogMetricsRequest request =
   *       ListLogMetricsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .build();
   *   while (true) {
   *     ListLogMetricsResponse response = metricsClient.listLogMetricsCallable().call(request);
   *     for (LogMetric element : response.getMetricsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListLogMetricsRequest, ListLogMetricsResponse>
      listLogMetricsCallable() {
    return stub.listLogMetricsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a logs-based metric.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetricsClient metricsClient = MetricsClient.create()) {
   *   LogMetricName metricName = LogMetricName.of("[PROJECT]", "[METRIC]");
   *   LogMetric response = metricsClient.getLogMetric(metricName);
   * }
   * }</pre>
   *
   * @param metricName Required. The resource name of the desired metric:
   *     <p>"projects/[PROJECT_ID]/metrics/[METRIC_ID]"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LogMetric getLogMetric(LogMetricName metricName) {
    GetLogMetricRequest request =
        GetLogMetricRequest.newBuilder()
            .setMetricName(metricName == null ? null : metricName.toString())
            .build();
    return getLogMetric(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a logs-based metric.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetricsClient metricsClient = MetricsClient.create()) {
   *   String metricName = LogMetricName.of("[PROJECT]", "[METRIC]").toString();
   *   LogMetric response = metricsClient.getLogMetric(metricName);
   * }
   * }</pre>
   *
   * @param metricName Required. The resource name of the desired metric:
   *     <p>"projects/[PROJECT_ID]/metrics/[METRIC_ID]"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LogMetric getLogMetric(String metricName) {
    GetLogMetricRequest request =
        GetLogMetricRequest.newBuilder().setMetricName(metricName).build();
    return getLogMetric(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a logs-based metric.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetricsClient metricsClient = MetricsClient.create()) {
   *   GetLogMetricRequest request =
   *       GetLogMetricRequest.newBuilder()
   *           .setMetricName(LogMetricName.of("[PROJECT]", "[METRIC]").toString())
   *           .build();
   *   LogMetric response = metricsClient.getLogMetric(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LogMetric getLogMetric(GetLogMetricRequest request) {
    return getLogMetricCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a logs-based metric.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetricsClient metricsClient = MetricsClient.create()) {
   *   GetLogMetricRequest request =
   *       GetLogMetricRequest.newBuilder()
   *           .setMetricName(LogMetricName.of("[PROJECT]", "[METRIC]").toString())
   *           .build();
   *   ApiFuture<LogMetric> future = metricsClient.getLogMetricCallable().futureCall(request);
   *   // Do something.
   *   LogMetric response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLogMetricRequest, LogMetric> getLogMetricCallable() {
    return stub.getLogMetricCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a logs-based metric.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetricsClient metricsClient = MetricsClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   LogMetric metric = LogMetric.newBuilder().build();
   *   LogMetric response = metricsClient.createLogMetric(parent, metric);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the project in which to create the metric:
   *     <p>"projects/[PROJECT_ID]"
   *     <p>The new metric must be provided in the request.
   * @param metric Required. The new logs-based metric, which must not have an identifier that
   *     already exists.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LogMetric createLogMetric(ProjectName parent, LogMetric metric) {
    CreateLogMetricRequest request =
        CreateLogMetricRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setMetric(metric)
            .build();
    return createLogMetric(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a logs-based metric.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetricsClient metricsClient = MetricsClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   LogMetric metric = LogMetric.newBuilder().build();
   *   LogMetric response = metricsClient.createLogMetric(parent, metric);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the project in which to create the metric:
   *     <p>"projects/[PROJECT_ID]"
   *     <p>The new metric must be provided in the request.
   * @param metric Required. The new logs-based metric, which must not have an identifier that
   *     already exists.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LogMetric createLogMetric(String parent, LogMetric metric) {
    CreateLogMetricRequest request =
        CreateLogMetricRequest.newBuilder().setParent(parent).setMetric(metric).build();
    return createLogMetric(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a logs-based metric.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetricsClient metricsClient = MetricsClient.create()) {
   *   CreateLogMetricRequest request =
   *       CreateLogMetricRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setMetric(LogMetric.newBuilder().build())
   *           .build();
   *   LogMetric response = metricsClient.createLogMetric(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LogMetric createLogMetric(CreateLogMetricRequest request) {
    return createLogMetricCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a logs-based metric.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetricsClient metricsClient = MetricsClient.create()) {
   *   CreateLogMetricRequest request =
   *       CreateLogMetricRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setMetric(LogMetric.newBuilder().build())
   *           .build();
   *   ApiFuture<LogMetric> future = metricsClient.createLogMetricCallable().futureCall(request);
   *   // Do something.
   *   LogMetric response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateLogMetricRequest, LogMetric> createLogMetricCallable() {
    return stub.createLogMetricCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates or updates a logs-based metric.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetricsClient metricsClient = MetricsClient.create()) {
   *   LogMetricName metricName = LogMetricName.of("[PROJECT]", "[METRIC]");
   *   LogMetric metric = LogMetric.newBuilder().build();
   *   LogMetric response = metricsClient.updateLogMetric(metricName, metric);
   * }
   * }</pre>
   *
   * @param metricName Required. The resource name of the metric to update:
   *     <p>"projects/[PROJECT_ID]/metrics/[METRIC_ID]"
   *     <p>The updated metric must be provided in the request and it's `name` field must be the
   *     same as `[METRIC_ID]` If the metric does not exist in `[PROJECT_ID]`, then a new metric is
   *     created.
   * @param metric Required. The updated metric.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LogMetric updateLogMetric(LogMetricName metricName, LogMetric metric) {
    UpdateLogMetricRequest request =
        UpdateLogMetricRequest.newBuilder()
            .setMetricName(metricName == null ? null : metricName.toString())
            .setMetric(metric)
            .build();
    return updateLogMetric(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates or updates a logs-based metric.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetricsClient metricsClient = MetricsClient.create()) {
   *   String metricName = LogMetricName.of("[PROJECT]", "[METRIC]").toString();
   *   LogMetric metric = LogMetric.newBuilder().build();
   *   LogMetric response = metricsClient.updateLogMetric(metricName, metric);
   * }
   * }</pre>
   *
   * @param metricName Required. The resource name of the metric to update:
   *     <p>"projects/[PROJECT_ID]/metrics/[METRIC_ID]"
   *     <p>The updated metric must be provided in the request and it's `name` field must be the
   *     same as `[METRIC_ID]` If the metric does not exist in `[PROJECT_ID]`, then a new metric is
   *     created.
   * @param metric Required. The updated metric.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LogMetric updateLogMetric(String metricName, LogMetric metric) {
    UpdateLogMetricRequest request =
        UpdateLogMetricRequest.newBuilder().setMetricName(metricName).setMetric(metric).build();
    return updateLogMetric(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates or updates a logs-based metric.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetricsClient metricsClient = MetricsClient.create()) {
   *   UpdateLogMetricRequest request =
   *       UpdateLogMetricRequest.newBuilder()
   *           .setMetricName(LogMetricName.of("[PROJECT]", "[METRIC]").toString())
   *           .setMetric(LogMetric.newBuilder().build())
   *           .build();
   *   LogMetric response = metricsClient.updateLogMetric(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LogMetric updateLogMetric(UpdateLogMetricRequest request) {
    return updateLogMetricCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates or updates a logs-based metric.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetricsClient metricsClient = MetricsClient.create()) {
   *   UpdateLogMetricRequest request =
   *       UpdateLogMetricRequest.newBuilder()
   *           .setMetricName(LogMetricName.of("[PROJECT]", "[METRIC]").toString())
   *           .setMetric(LogMetric.newBuilder().build())
   *           .build();
   *   ApiFuture<LogMetric> future = metricsClient.updateLogMetricCallable().futureCall(request);
   *   // Do something.
   *   LogMetric response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateLogMetricRequest, LogMetric> updateLogMetricCallable() {
    return stub.updateLogMetricCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a logs-based metric.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetricsClient metricsClient = MetricsClient.create()) {
   *   LogMetricName metricName = LogMetricName.of("[PROJECT]", "[METRIC]");
   *   metricsClient.deleteLogMetric(metricName);
   * }
   * }</pre>
   *
   * @param metricName Required. The resource name of the metric to delete:
   *     <p>"projects/[PROJECT_ID]/metrics/[METRIC_ID]"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteLogMetric(LogMetricName metricName) {
    DeleteLogMetricRequest request =
        DeleteLogMetricRequest.newBuilder()
            .setMetricName(metricName == null ? null : metricName.toString())
            .build();
    deleteLogMetric(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a logs-based metric.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetricsClient metricsClient = MetricsClient.create()) {
   *   String metricName = LogMetricName.of("[PROJECT]", "[METRIC]").toString();
   *   metricsClient.deleteLogMetric(metricName);
   * }
   * }</pre>
   *
   * @param metricName Required. The resource name of the metric to delete:
   *     <p>"projects/[PROJECT_ID]/metrics/[METRIC_ID]"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteLogMetric(String metricName) {
    DeleteLogMetricRequest request =
        DeleteLogMetricRequest.newBuilder().setMetricName(metricName).build();
    deleteLogMetric(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a logs-based metric.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetricsClient metricsClient = MetricsClient.create()) {
   *   DeleteLogMetricRequest request =
   *       DeleteLogMetricRequest.newBuilder()
   *           .setMetricName(LogMetricName.of("[PROJECT]", "[METRIC]").toString())
   *           .build();
   *   metricsClient.deleteLogMetric(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteLogMetric(DeleteLogMetricRequest request) {
    deleteLogMetricCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a logs-based metric.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetricsClient metricsClient = MetricsClient.create()) {
   *   DeleteLogMetricRequest request =
   *       DeleteLogMetricRequest.newBuilder()
   *           .setMetricName(LogMetricName.of("[PROJECT]", "[METRIC]").toString())
   *           .build();
   *   ApiFuture<Empty> future = metricsClient.deleteLogMetricCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteLogMetricRequest, Empty> deleteLogMetricCallable() {
    return stub.deleteLogMetricCallable();
  }

  @Override
  public final void close() {
    stub.close();
  }

  @Override
  public void shutdown() {
    stub.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return stub.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return stub.isTerminated();
  }

  @Override
  public void shutdownNow() {
    stub.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return stub.awaitTermination(duration, unit);
  }

  public static class ListLogMetricsPagedResponse
      extends AbstractPagedListResponse<
          ListLogMetricsRequest,
          ListLogMetricsResponse,
          LogMetric,
          ListLogMetricsPage,
          ListLogMetricsFixedSizeCollection> {

    public static ApiFuture<ListLogMetricsPagedResponse> createAsync(
        PageContext<ListLogMetricsRequest, ListLogMetricsResponse, LogMetric> context,
        ApiFuture<ListLogMetricsResponse> futureResponse) {
      ApiFuture<ListLogMetricsPage> futurePage =
          ListLogMetricsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListLogMetricsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListLogMetricsPagedResponse(ListLogMetricsPage page) {
      super(page, ListLogMetricsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListLogMetricsPage
      extends AbstractPage<
          ListLogMetricsRequest, ListLogMetricsResponse, LogMetric, ListLogMetricsPage> {

    private ListLogMetricsPage(
        PageContext<ListLogMetricsRequest, ListLogMetricsResponse, LogMetric> context,
        ListLogMetricsResponse response) {
      super(context, response);
    }

    private static ListLogMetricsPage createEmptyPage() {
      return new ListLogMetricsPage(null, null);
    }

    @Override
    protected ListLogMetricsPage createPage(
        PageContext<ListLogMetricsRequest, ListLogMetricsResponse, LogMetric> context,
        ListLogMetricsResponse response) {
      return new ListLogMetricsPage(context, response);
    }

    @Override
    public ApiFuture<ListLogMetricsPage> createPageAsync(
        PageContext<ListLogMetricsRequest, ListLogMetricsResponse, LogMetric> context,
        ApiFuture<ListLogMetricsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListLogMetricsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListLogMetricsRequest,
          ListLogMetricsResponse,
          LogMetric,
          ListLogMetricsPage,
          ListLogMetricsFixedSizeCollection> {

    private ListLogMetricsFixedSizeCollection(List<ListLogMetricsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLogMetricsFixedSizeCollection createEmptyCollection() {
      return new ListLogMetricsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLogMetricsFixedSizeCollection createCollection(
        List<ListLogMetricsPage> pages, int collectionSize) {
      return new ListLogMetricsFixedSizeCollection(pages, collectionSize);
    }
  }
}
