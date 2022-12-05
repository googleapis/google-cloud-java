/*
 * Copyright 2022 Google LLC
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

package com.google.monitoring.metricsscope.v1;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import com.google.monitoring.metricsscope.v1.stub.MetricsScopesStub;
import com.google.monitoring.metricsscope.v1.stub.MetricsScopesStubSettings;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Manages Cloud Monitoring Metrics Scopes, and the monitoring of Google Cloud
 * projects and AWS accounts.
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
 * try (MetricsScopesClient metricsScopesClient = MetricsScopesClient.create()) {
 *   MetricsScopeName name = MetricsScopeName.of("[METRICS_SCOPE]");
 *   MetricsScope response = metricsScopesClient.getMetricsScope(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the MetricsScopesClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's
 * methods:
 *
 * <ol>
 *   <li>A "flattened" method. With this type of method, the fields of the request type have been
 *       converted into function parameters. It may be the case that not all fields are available as
 *       parameters, and not every API method will have a flattened method entry point.
 *   <li>A "request object" method. This type of method only takes one parameter, a request object,
 *       which must be constructed before the call. Not every API method will have a request object
 *       method.
 *   <li>A "callable" method. This type of method takes no parameters and returns an immutable API
 *       callable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of MetricsScopesSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * MetricsScopesSettings metricsScopesSettings =
 *     MetricsScopesSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * MetricsScopesClient metricsScopesClient = MetricsScopesClient.create(metricsScopesSettings);
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
 * MetricsScopesSettings metricsScopesSettings =
 *     MetricsScopesSettings.newBuilder().setEndpoint(myEndpoint).build();
 * MetricsScopesClient metricsScopesClient = MetricsScopesClient.create(metricsScopesSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class MetricsScopesClient implements BackgroundResource {
  private final MetricsScopesSettings settings;
  private final MetricsScopesStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of MetricsScopesClient with default settings. */
  public static final MetricsScopesClient create() throws IOException {
    return create(MetricsScopesSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of MetricsScopesClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final MetricsScopesClient create(MetricsScopesSettings settings)
      throws IOException {
    return new MetricsScopesClient(settings);
  }

  /**
   * Constructs an instance of MetricsScopesClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(MetricsScopesSettings).
   */
  public static final MetricsScopesClient create(MetricsScopesStub stub) {
    return new MetricsScopesClient(stub);
  }

  /**
   * Constructs an instance of MetricsScopesClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected MetricsScopesClient(MetricsScopesSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((MetricsScopesStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  protected MetricsScopesClient(MetricsScopesStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final MetricsScopesSettings getSettings() {
    return settings;
  }

  public MetricsScopesStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final OperationsClient getOperationsClient() {
    return operationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a specific `Metrics Scope`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetricsScopesClient metricsScopesClient = MetricsScopesClient.create()) {
   *   MetricsScopeName name = MetricsScopeName.of("[METRICS_SCOPE]");
   *   MetricsScope response = metricsScopesClient.getMetricsScope(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the `Metrics Scope`. Example:
   *     `locations/global/metricsScopes/{SCOPING_PROJECT_ID_OR_NUMBER}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MetricsScope getMetricsScope(MetricsScopeName name) {
    GetMetricsScopeRequest request =
        GetMetricsScopeRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getMetricsScope(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a specific `Metrics Scope`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetricsScopesClient metricsScopesClient = MetricsScopesClient.create()) {
   *   String name = MetricsScopeName.of("[METRICS_SCOPE]").toString();
   *   MetricsScope response = metricsScopesClient.getMetricsScope(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the `Metrics Scope`. Example:
   *     `locations/global/metricsScopes/{SCOPING_PROJECT_ID_OR_NUMBER}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MetricsScope getMetricsScope(String name) {
    GetMetricsScopeRequest request = GetMetricsScopeRequest.newBuilder().setName(name).build();
    return getMetricsScope(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a specific `Metrics Scope`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetricsScopesClient metricsScopesClient = MetricsScopesClient.create()) {
   *   GetMetricsScopeRequest request =
   *       GetMetricsScopeRequest.newBuilder()
   *           .setName(MetricsScopeName.of("[METRICS_SCOPE]").toString())
   *           .build();
   *   MetricsScope response = metricsScopesClient.getMetricsScope(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MetricsScope getMetricsScope(GetMetricsScopeRequest request) {
    return getMetricsScopeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a specific `Metrics Scope`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetricsScopesClient metricsScopesClient = MetricsScopesClient.create()) {
   *   GetMetricsScopeRequest request =
   *       GetMetricsScopeRequest.newBuilder()
   *           .setName(MetricsScopeName.of("[METRICS_SCOPE]").toString())
   *           .build();
   *   ApiFuture<MetricsScope> future =
   *       metricsScopesClient.getMetricsScopeCallable().futureCall(request);
   *   // Do something.
   *   MetricsScope response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetMetricsScopeRequest, MetricsScope> getMetricsScopeCallable() {
    return stub.getMetricsScopeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of every `Metrics Scope` that a specific `MonitoredProject` has been added to.
   * The metrics scope representing the specified monitored project will always be the first entry
   * in the response.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetricsScopesClient metricsScopesClient = MetricsScopesClient.create()) {
   *   ListMetricsScopesByMonitoredProjectRequest request =
   *       ListMetricsScopesByMonitoredProjectRequest.newBuilder()
   *           .setMonitoredResourceContainer("monitoredResourceContainer884669850")
   *           .build();
   *   ListMetricsScopesByMonitoredProjectResponse response =
   *       metricsScopesClient.listMetricsScopesByMonitoredProject(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMetricsScopesByMonitoredProjectResponse listMetricsScopesByMonitoredProject(
      ListMetricsScopesByMonitoredProjectRequest request) {
    return listMetricsScopesByMonitoredProjectCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of every `Metrics Scope` that a specific `MonitoredProject` has been added to.
   * The metrics scope representing the specified monitored project will always be the first entry
   * in the response.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetricsScopesClient metricsScopesClient = MetricsScopesClient.create()) {
   *   ListMetricsScopesByMonitoredProjectRequest request =
   *       ListMetricsScopesByMonitoredProjectRequest.newBuilder()
   *           .setMonitoredResourceContainer("monitoredResourceContainer884669850")
   *           .build();
   *   ApiFuture<ListMetricsScopesByMonitoredProjectResponse> future =
   *       metricsScopesClient.listMetricsScopesByMonitoredProjectCallable().futureCall(request);
   *   // Do something.
   *   ListMetricsScopesByMonitoredProjectResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListMetricsScopesByMonitoredProjectRequest, ListMetricsScopesByMonitoredProjectResponse>
      listMetricsScopesByMonitoredProjectCallable() {
    return stub.listMetricsScopesByMonitoredProjectCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a `MonitoredProject` with the given project ID to the specified `Metrics Scope`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetricsScopesClient metricsScopesClient = MetricsScopesClient.create()) {
   *   MetricsScopeName parent = MetricsScopeName.of("[METRICS_SCOPE]");
   *   MonitoredProject monitoredProject = MonitoredProject.newBuilder().build();
   *   MonitoredProject response =
   *       metricsScopesClient.createMonitoredProjectAsync(parent, monitoredProject).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the existing `Metrics Scope` that will monitor
   *     this project. Example: `locations/global/metricsScopes/{SCOPING_PROJECT_ID_OR_NUMBER}`
   * @param monitoredProject Required. The initial `MonitoredProject` configuration. Specify only
   *     the `monitored_project.name` field. All other fields are ignored. The
   *     `monitored_project.name` must be in the format:
   *     `locations/global/metricsScopes/{SCOPING_PROJECT_ID_OR_NUMBER}/projects/{MONITORED_PROJECT_ID_OR_NUMBER}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MonitoredProject, OperationMetadata> createMonitoredProjectAsync(
      MetricsScopeName parent, MonitoredProject monitoredProject) {
    CreateMonitoredProjectRequest request =
        CreateMonitoredProjectRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setMonitoredProject(monitoredProject)
            .build();
    return createMonitoredProjectAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a `MonitoredProject` with the given project ID to the specified `Metrics Scope`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetricsScopesClient metricsScopesClient = MetricsScopesClient.create()) {
   *   String parent = MetricsScopeName.of("[METRICS_SCOPE]").toString();
   *   MonitoredProject monitoredProject = MonitoredProject.newBuilder().build();
   *   MonitoredProject response =
   *       metricsScopesClient.createMonitoredProjectAsync(parent, monitoredProject).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the existing `Metrics Scope` that will monitor
   *     this project. Example: `locations/global/metricsScopes/{SCOPING_PROJECT_ID_OR_NUMBER}`
   * @param monitoredProject Required. The initial `MonitoredProject` configuration. Specify only
   *     the `monitored_project.name` field. All other fields are ignored. The
   *     `monitored_project.name` must be in the format:
   *     `locations/global/metricsScopes/{SCOPING_PROJECT_ID_OR_NUMBER}/projects/{MONITORED_PROJECT_ID_OR_NUMBER}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MonitoredProject, OperationMetadata> createMonitoredProjectAsync(
      String parent, MonitoredProject monitoredProject) {
    CreateMonitoredProjectRequest request =
        CreateMonitoredProjectRequest.newBuilder()
            .setParent(parent)
            .setMonitoredProject(monitoredProject)
            .build();
    return createMonitoredProjectAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a `MonitoredProject` with the given project ID to the specified `Metrics Scope`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetricsScopesClient metricsScopesClient = MetricsScopesClient.create()) {
   *   CreateMonitoredProjectRequest request =
   *       CreateMonitoredProjectRequest.newBuilder()
   *           .setParent(MetricsScopeName.of("[METRICS_SCOPE]").toString())
   *           .setMonitoredProject(MonitoredProject.newBuilder().build())
   *           .build();
   *   MonitoredProject response = metricsScopesClient.createMonitoredProjectAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MonitoredProject, OperationMetadata> createMonitoredProjectAsync(
      CreateMonitoredProjectRequest request) {
    return createMonitoredProjectOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a `MonitoredProject` with the given project ID to the specified `Metrics Scope`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetricsScopesClient metricsScopesClient = MetricsScopesClient.create()) {
   *   CreateMonitoredProjectRequest request =
   *       CreateMonitoredProjectRequest.newBuilder()
   *           .setParent(MetricsScopeName.of("[METRICS_SCOPE]").toString())
   *           .setMonitoredProject(MonitoredProject.newBuilder().build())
   *           .build();
   *   OperationFuture<MonitoredProject, OperationMetadata> future =
   *       metricsScopesClient.createMonitoredProjectOperationCallable().futureCall(request);
   *   // Do something.
   *   MonitoredProject response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateMonitoredProjectRequest, MonitoredProject, OperationMetadata>
      createMonitoredProjectOperationCallable() {
    return stub.createMonitoredProjectOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a `MonitoredProject` with the given project ID to the specified `Metrics Scope`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetricsScopesClient metricsScopesClient = MetricsScopesClient.create()) {
   *   CreateMonitoredProjectRequest request =
   *       CreateMonitoredProjectRequest.newBuilder()
   *           .setParent(MetricsScopeName.of("[METRICS_SCOPE]").toString())
   *           .setMonitoredProject(MonitoredProject.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       metricsScopesClient.createMonitoredProjectCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateMonitoredProjectRequest, Operation>
      createMonitoredProjectCallable() {
    return stub.createMonitoredProjectCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a `MonitoredProject` from the specified `Metrics Scope`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetricsScopesClient metricsScopesClient = MetricsScopesClient.create()) {
   *   MonitoredProjectName name = MonitoredProjectName.of("[METRICS_SCOPE]", "[PROJECT]");
   *   metricsScopesClient.deleteMonitoredProjectAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the `MonitoredProject`. Example:
   *     `locations/global/metricsScopes/{SCOPING_PROJECT_ID_OR_NUMBER}/projects/{MONITORED_PROJECT_ID_OR_NUMBER}`
   *     <p>Authorization requires the following [Google IAM](https://cloud.google.com/iam)
   *     permissions on both the `Metrics Scope` and on the `MonitoredProject`:
   *     `monitoring.metricsScopes.link`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteMonitoredProjectAsync(
      MonitoredProjectName name) {
    DeleteMonitoredProjectRequest request =
        DeleteMonitoredProjectRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteMonitoredProjectAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a `MonitoredProject` from the specified `Metrics Scope`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetricsScopesClient metricsScopesClient = MetricsScopesClient.create()) {
   *   String name = MonitoredProjectName.of("[METRICS_SCOPE]", "[PROJECT]").toString();
   *   metricsScopesClient.deleteMonitoredProjectAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the `MonitoredProject`. Example:
   *     `locations/global/metricsScopes/{SCOPING_PROJECT_ID_OR_NUMBER}/projects/{MONITORED_PROJECT_ID_OR_NUMBER}`
   *     <p>Authorization requires the following [Google IAM](https://cloud.google.com/iam)
   *     permissions on both the `Metrics Scope` and on the `MonitoredProject`:
   *     `monitoring.metricsScopes.link`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteMonitoredProjectAsync(String name) {
    DeleteMonitoredProjectRequest request =
        DeleteMonitoredProjectRequest.newBuilder().setName(name).build();
    return deleteMonitoredProjectAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a `MonitoredProject` from the specified `Metrics Scope`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetricsScopesClient metricsScopesClient = MetricsScopesClient.create()) {
   *   DeleteMonitoredProjectRequest request =
   *       DeleteMonitoredProjectRequest.newBuilder()
   *           .setName(MonitoredProjectName.of("[METRICS_SCOPE]", "[PROJECT]").toString())
   *           .build();
   *   metricsScopesClient.deleteMonitoredProjectAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteMonitoredProjectAsync(
      DeleteMonitoredProjectRequest request) {
    return deleteMonitoredProjectOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a `MonitoredProject` from the specified `Metrics Scope`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetricsScopesClient metricsScopesClient = MetricsScopesClient.create()) {
   *   DeleteMonitoredProjectRequest request =
   *       DeleteMonitoredProjectRequest.newBuilder()
   *           .setName(MonitoredProjectName.of("[METRICS_SCOPE]", "[PROJECT]").toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       metricsScopesClient.deleteMonitoredProjectOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteMonitoredProjectRequest, Empty, OperationMetadata>
      deleteMonitoredProjectOperationCallable() {
    return stub.deleteMonitoredProjectOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a `MonitoredProject` from the specified `Metrics Scope`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetricsScopesClient metricsScopesClient = MetricsScopesClient.create()) {
   *   DeleteMonitoredProjectRequest request =
   *       DeleteMonitoredProjectRequest.newBuilder()
   *           .setName(MonitoredProjectName.of("[METRICS_SCOPE]", "[PROJECT]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       metricsScopesClient.deleteMonitoredProjectCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteMonitoredProjectRequest, Operation>
      deleteMonitoredProjectCallable() {
    return stub.deleteMonitoredProjectCallable();
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
}
