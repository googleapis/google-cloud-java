/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.workloadmanager.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.httpjson.longrunning.OperationsClient;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.workloadmanager.v1.stub.WorkloadManagerStub;
import com.google.cloud.workloadmanager.v1.stub.WorkloadManagerStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The Workload Manager provides various tools to deploy, validate and observe
 * your workloads running on Google Cloud.
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
 * try (WorkloadManagerClient workloadManagerClient = WorkloadManagerClient.create()) {
 *   EvaluationName name = EvaluationName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]");
 *   Evaluation response = workloadManagerClient.getEvaluation(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the WorkloadManagerClient object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> ListEvaluations</td>
 *      <td><p> Lists Evaluations in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listEvaluations(ListEvaluationsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listEvaluations(LocationName parent)
 *           <li><p> listEvaluations(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listEvaluationsPagedCallable()
 *           <li><p> listEvaluationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetEvaluation</td>
 *      <td><p> Gets details of a single Evaluation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getEvaluation(GetEvaluationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getEvaluation(EvaluationName name)
 *           <li><p> getEvaluation(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getEvaluationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateEvaluation</td>
 *      <td><p> Creates a new Evaluation in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createEvaluationAsync(CreateEvaluationRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createEvaluationAsync(LocationName parent, Evaluation evaluation, String evaluationId)
 *           <li><p> createEvaluationAsync(String parent, Evaluation evaluation, String evaluationId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createEvaluationOperationCallable()
 *           <li><p> createEvaluationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateEvaluation</td>
 *      <td><p> Updates the parameters of a single Evaluation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateEvaluationAsync(UpdateEvaluationRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateEvaluationAsync(Evaluation evaluation, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateEvaluationOperationCallable()
 *           <li><p> updateEvaluationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteEvaluation</td>
 *      <td><p> Deletes a single Evaluation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteEvaluationAsync(DeleteEvaluationRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteEvaluationAsync(EvaluationName name)
 *           <li><p> deleteEvaluationAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteEvaluationOperationCallable()
 *           <li><p> deleteEvaluationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListExecutions</td>
 *      <td><p> Lists Executions in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listExecutions(ListExecutionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listExecutions(EvaluationName parent)
 *           <li><p> listExecutions(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listExecutionsPagedCallable()
 *           <li><p> listExecutionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetExecution</td>
 *      <td><p> Gets details of a single Execution.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getExecution(GetExecutionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getExecution(ExecutionName name)
 *           <li><p> getExecution(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getExecutionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RunEvaluation</td>
 *      <td><p> Creates a new Execution in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> runEvaluationAsync(RunEvaluationRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> runEvaluationAsync(EvaluationName name, Execution execution, String executionId)
 *           <li><p> runEvaluationAsync(String name, Execution execution, String executionId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> runEvaluationOperationCallable()
 *           <li><p> runEvaluationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteExecution</td>
 *      <td><p> Deletes a single Execution.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteExecutionAsync(DeleteExecutionRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteExecutionAsync(ExecutionName name)
 *           <li><p> deleteExecutionAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteExecutionOperationCallable()
 *           <li><p> deleteExecutionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListExecutionResults</td>
 *      <td><p> Lists the result of a single evaluation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listExecutionResults(ListExecutionResultsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listExecutionResults(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listExecutionResultsPagedCallable()
 *           <li><p> listExecutionResultsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListRules</td>
 *      <td><p> Lists rules in a given project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listRules(ListRulesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listRules(LocationName parent)
 *           <li><p> listRules(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listRulesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListScannedResources</td>
 *      <td><p> List all scanned resources for a single Execution.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listScannedResources(ListScannedResourcesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listScannedResources(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listScannedResourcesPagedCallable()
 *           <li><p> listScannedResourcesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListLocations</td>
 *      <td><p> Lists information about the supported locations for this service.This method can be called in two ways:
 * <p> &#42;   &#42;&#42;List all public locations:&#42;&#42; Use the path `GET /v1/locations`.&#42;   &#42;&#42;List project-visible locations:&#42;&#42; Use the path`GET /v1/projects/{project_id}/locations`. This may include publiclocations as well as private or other locations specifically visibleto the project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listLocations(ListLocationsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listLocationsPagedCallable()
 *           <li><p> listLocationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetLocation</td>
 *      <td><p> Gets information about a location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getLocation(GetLocationRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getLocationCallable()
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
 * <p>This class can be customized by passing in a custom instance of WorkloadManagerSettings to
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
 * WorkloadManagerSettings workloadManagerSettings =
 *     WorkloadManagerSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * WorkloadManagerClient workloadManagerClient =
 *     WorkloadManagerClient.create(workloadManagerSettings);
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
 * WorkloadManagerSettings workloadManagerSettings =
 *     WorkloadManagerSettings.newBuilder().setEndpoint(myEndpoint).build();
 * WorkloadManagerClient workloadManagerClient =
 *     WorkloadManagerClient.create(workloadManagerSettings);
 * }</pre>
 *
 * <p>To use REST (HTTP1.1/JSON) transport (instead of gRPC) for sending and receiving requests over
 * the wire:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * WorkloadManagerSettings workloadManagerSettings =
 *     WorkloadManagerSettings.newHttpJsonBuilder().build();
 * WorkloadManagerClient workloadManagerClient =
 *     WorkloadManagerClient.create(workloadManagerSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class WorkloadManagerClient implements BackgroundResource {
  private final WorkloadManagerSettings settings;
  private final WorkloadManagerStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of WorkloadManagerClient with default settings. */
  public static final WorkloadManagerClient create() throws IOException {
    return create(WorkloadManagerSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of WorkloadManagerClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final WorkloadManagerClient create(WorkloadManagerSettings settings)
      throws IOException {
    return new WorkloadManagerClient(settings);
  }

  /**
   * Constructs an instance of WorkloadManagerClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(WorkloadManagerSettings).
   */
  public static final WorkloadManagerClient create(WorkloadManagerStub stub) {
    return new WorkloadManagerClient(stub);
  }

  /**
   * Constructs an instance of WorkloadManagerClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected WorkloadManagerClient(WorkloadManagerSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((WorkloadManagerStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected WorkloadManagerClient(WorkloadManagerStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final WorkloadManagerSettings getSettings() {
    return settings;
  }

  public WorkloadManagerStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final com.google.longrunning.OperationsClient getOperationsClient() {
    return operationsClient;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  @BetaApi
  public final OperationsClient getHttpJsonOperationsClient() {
    return httpJsonOperationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Evaluations in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadManagerClient workloadManagerClient = WorkloadManagerClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Evaluation element : workloadManagerClient.listEvaluations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListEvaluationsRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEvaluationsPagedResponse listEvaluations(LocationName parent) {
    ListEvaluationsRequest request =
        ListEvaluationsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listEvaluations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Evaluations in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadManagerClient workloadManagerClient = WorkloadManagerClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Evaluation element : workloadManagerClient.listEvaluations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListEvaluationsRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEvaluationsPagedResponse listEvaluations(String parent) {
    ListEvaluationsRequest request = ListEvaluationsRequest.newBuilder().setParent(parent).build();
    return listEvaluations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Evaluations in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadManagerClient workloadManagerClient = WorkloadManagerClient.create()) {
   *   ListEvaluationsRequest request =
   *       ListEvaluationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Evaluation element : workloadManagerClient.listEvaluations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEvaluationsPagedResponse listEvaluations(ListEvaluationsRequest request) {
    return listEvaluationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Evaluations in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadManagerClient workloadManagerClient = WorkloadManagerClient.create()) {
   *   ListEvaluationsRequest request =
   *       ListEvaluationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Evaluation> future =
   *       workloadManagerClient.listEvaluationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Evaluation element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListEvaluationsRequest, ListEvaluationsPagedResponse>
      listEvaluationsPagedCallable() {
    return stub.listEvaluationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Evaluations in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadManagerClient workloadManagerClient = WorkloadManagerClient.create()) {
   *   ListEvaluationsRequest request =
   *       ListEvaluationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListEvaluationsResponse response =
   *         workloadManagerClient.listEvaluationsCallable().call(request);
   *     for (Evaluation element : response.getEvaluationsList()) {
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
  public final UnaryCallable<ListEvaluationsRequest, ListEvaluationsResponse>
      listEvaluationsCallable() {
    return stub.listEvaluationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Evaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadManagerClient workloadManagerClient = WorkloadManagerClient.create()) {
   *   EvaluationName name = EvaluationName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]");
   *   Evaluation response = workloadManagerClient.getEvaluation(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Evaluation getEvaluation(EvaluationName name) {
    GetEvaluationRequest request =
        GetEvaluationRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getEvaluation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Evaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadManagerClient workloadManagerClient = WorkloadManagerClient.create()) {
   *   String name = EvaluationName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]").toString();
   *   Evaluation response = workloadManagerClient.getEvaluation(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Evaluation getEvaluation(String name) {
    GetEvaluationRequest request = GetEvaluationRequest.newBuilder().setName(name).build();
    return getEvaluation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Evaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadManagerClient workloadManagerClient = WorkloadManagerClient.create()) {
   *   GetEvaluationRequest request =
   *       GetEvaluationRequest.newBuilder()
   *           .setName(EvaluationName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]").toString())
   *           .build();
   *   Evaluation response = workloadManagerClient.getEvaluation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Evaluation getEvaluation(GetEvaluationRequest request) {
    return getEvaluationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Evaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadManagerClient workloadManagerClient = WorkloadManagerClient.create()) {
   *   GetEvaluationRequest request =
   *       GetEvaluationRequest.newBuilder()
   *           .setName(EvaluationName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]").toString())
   *           .build();
   *   ApiFuture<Evaluation> future =
   *       workloadManagerClient.getEvaluationCallable().futureCall(request);
   *   // Do something.
   *   Evaluation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetEvaluationRequest, Evaluation> getEvaluationCallable() {
    return stub.getEvaluationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Evaluation in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadManagerClient workloadManagerClient = WorkloadManagerClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Evaluation evaluation = Evaluation.newBuilder().build();
   *   String evaluationId = "evaluationId407318903";
   *   Evaluation response =
   *       workloadManagerClient.createEvaluationAsync(parent, evaluation, evaluationId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource prefix of the evaluation location using the form:
   *     `projects/{project_id}/locations/{location_id}`.
   * @param evaluation Required. The resource being created.
   * @param evaluationId Required. Id of the requesting object.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Evaluation, OperationMetadata> createEvaluationAsync(
      LocationName parent, Evaluation evaluation, String evaluationId) {
    CreateEvaluationRequest request =
        CreateEvaluationRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setEvaluation(evaluation)
            .setEvaluationId(evaluationId)
            .build();
    return createEvaluationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Evaluation in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadManagerClient workloadManagerClient = WorkloadManagerClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Evaluation evaluation = Evaluation.newBuilder().build();
   *   String evaluationId = "evaluationId407318903";
   *   Evaluation response =
   *       workloadManagerClient.createEvaluationAsync(parent, evaluation, evaluationId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource prefix of the evaluation location using the form:
   *     `projects/{project_id}/locations/{location_id}`.
   * @param evaluation Required. The resource being created.
   * @param evaluationId Required. Id of the requesting object.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Evaluation, OperationMetadata> createEvaluationAsync(
      String parent, Evaluation evaluation, String evaluationId) {
    CreateEvaluationRequest request =
        CreateEvaluationRequest.newBuilder()
            .setParent(parent)
            .setEvaluation(evaluation)
            .setEvaluationId(evaluationId)
            .build();
    return createEvaluationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Evaluation in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadManagerClient workloadManagerClient = WorkloadManagerClient.create()) {
   *   CreateEvaluationRequest request =
   *       CreateEvaluationRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setEvaluationId("evaluationId407318903")
   *           .setEvaluation(Evaluation.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Evaluation response = workloadManagerClient.createEvaluationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Evaluation, OperationMetadata> createEvaluationAsync(
      CreateEvaluationRequest request) {
    return createEvaluationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Evaluation in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadManagerClient workloadManagerClient = WorkloadManagerClient.create()) {
   *   CreateEvaluationRequest request =
   *       CreateEvaluationRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setEvaluationId("evaluationId407318903")
   *           .setEvaluation(Evaluation.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Evaluation, OperationMetadata> future =
   *       workloadManagerClient.createEvaluationOperationCallable().futureCall(request);
   *   // Do something.
   *   Evaluation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateEvaluationRequest, Evaluation, OperationMetadata>
      createEvaluationOperationCallable() {
    return stub.createEvaluationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Evaluation in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadManagerClient workloadManagerClient = WorkloadManagerClient.create()) {
   *   CreateEvaluationRequest request =
   *       CreateEvaluationRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setEvaluationId("evaluationId407318903")
   *           .setEvaluation(Evaluation.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       workloadManagerClient.createEvaluationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateEvaluationRequest, Operation> createEvaluationCallable() {
    return stub.createEvaluationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Evaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadManagerClient workloadManagerClient = WorkloadManagerClient.create()) {
   *   Evaluation evaluation = Evaluation.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Evaluation response =
   *       workloadManagerClient.updateEvaluationAsync(evaluation, updateMask).get();
   * }
   * }</pre>
   *
   * @param evaluation Required. The resource being updated.
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     Evaluation resource by the update. The fields specified in the update_mask are relative to
   *     the resource, not the full request. A field will be overwritten if it is in the mask.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Evaluation, OperationMetadata> updateEvaluationAsync(
      Evaluation evaluation, FieldMask updateMask) {
    UpdateEvaluationRequest request =
        UpdateEvaluationRequest.newBuilder()
            .setEvaluation(evaluation)
            .setUpdateMask(updateMask)
            .build();
    return updateEvaluationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Evaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadManagerClient workloadManagerClient = WorkloadManagerClient.create()) {
   *   UpdateEvaluationRequest request =
   *       UpdateEvaluationRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setEvaluation(Evaluation.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Evaluation response = workloadManagerClient.updateEvaluationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Evaluation, OperationMetadata> updateEvaluationAsync(
      UpdateEvaluationRequest request) {
    return updateEvaluationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Evaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadManagerClient workloadManagerClient = WorkloadManagerClient.create()) {
   *   UpdateEvaluationRequest request =
   *       UpdateEvaluationRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setEvaluation(Evaluation.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Evaluation, OperationMetadata> future =
   *       workloadManagerClient.updateEvaluationOperationCallable().futureCall(request);
   *   // Do something.
   *   Evaluation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateEvaluationRequest, Evaluation, OperationMetadata>
      updateEvaluationOperationCallable() {
    return stub.updateEvaluationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Evaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadManagerClient workloadManagerClient = WorkloadManagerClient.create()) {
   *   UpdateEvaluationRequest request =
   *       UpdateEvaluationRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setEvaluation(Evaluation.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       workloadManagerClient.updateEvaluationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateEvaluationRequest, Operation> updateEvaluationCallable() {
    return stub.updateEvaluationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Evaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadManagerClient workloadManagerClient = WorkloadManagerClient.create()) {
   *   EvaluationName name = EvaluationName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]");
   *   workloadManagerClient.deleteEvaluationAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteEvaluationAsync(
      EvaluationName name) {
    DeleteEvaluationRequest request =
        DeleteEvaluationRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteEvaluationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Evaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadManagerClient workloadManagerClient = WorkloadManagerClient.create()) {
   *   String name = EvaluationName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]").toString();
   *   workloadManagerClient.deleteEvaluationAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteEvaluationAsync(String name) {
    DeleteEvaluationRequest request = DeleteEvaluationRequest.newBuilder().setName(name).build();
    return deleteEvaluationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Evaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadManagerClient workloadManagerClient = WorkloadManagerClient.create()) {
   *   DeleteEvaluationRequest request =
   *       DeleteEvaluationRequest.newBuilder()
   *           .setName(EvaluationName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]").toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .build();
   *   workloadManagerClient.deleteEvaluationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteEvaluationAsync(
      DeleteEvaluationRequest request) {
    return deleteEvaluationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Evaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadManagerClient workloadManagerClient = WorkloadManagerClient.create()) {
   *   DeleteEvaluationRequest request =
   *       DeleteEvaluationRequest.newBuilder()
   *           .setName(EvaluationName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]").toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       workloadManagerClient.deleteEvaluationOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteEvaluationRequest, Empty, OperationMetadata>
      deleteEvaluationOperationCallable() {
    return stub.deleteEvaluationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Evaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadManagerClient workloadManagerClient = WorkloadManagerClient.create()) {
   *   DeleteEvaluationRequest request =
   *       DeleteEvaluationRequest.newBuilder()
   *           .setName(EvaluationName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]").toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       workloadManagerClient.deleteEvaluationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteEvaluationRequest, Operation> deleteEvaluationCallable() {
    return stub.deleteEvaluationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Executions in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadManagerClient workloadManagerClient = WorkloadManagerClient.create()) {
   *   EvaluationName parent = EvaluationName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]");
   *   for (Execution element : workloadManagerClient.listExecutions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource prefix of the Execution using the form:
   *     `projects/{project}/locations/{location}/evaluations/{evaluation}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListExecutionsPagedResponse listExecutions(EvaluationName parent) {
    ListExecutionsRequest request =
        ListExecutionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listExecutions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Executions in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadManagerClient workloadManagerClient = WorkloadManagerClient.create()) {
   *   String parent = EvaluationName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]").toString();
   *   for (Execution element : workloadManagerClient.listExecutions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource prefix of the Execution using the form:
   *     `projects/{project}/locations/{location}/evaluations/{evaluation}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListExecutionsPagedResponse listExecutions(String parent) {
    ListExecutionsRequest request = ListExecutionsRequest.newBuilder().setParent(parent).build();
    return listExecutions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Executions in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadManagerClient workloadManagerClient = WorkloadManagerClient.create()) {
   *   ListExecutionsRequest request =
   *       ListExecutionsRequest.newBuilder()
   *           .setParent(EvaluationName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Execution element : workloadManagerClient.listExecutions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListExecutionsPagedResponse listExecutions(ListExecutionsRequest request) {
    return listExecutionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Executions in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadManagerClient workloadManagerClient = WorkloadManagerClient.create()) {
   *   ListExecutionsRequest request =
   *       ListExecutionsRequest.newBuilder()
   *           .setParent(EvaluationName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Execution> future =
   *       workloadManagerClient.listExecutionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Execution element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListExecutionsRequest, ListExecutionsPagedResponse>
      listExecutionsPagedCallable() {
    return stub.listExecutionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Executions in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadManagerClient workloadManagerClient = WorkloadManagerClient.create()) {
   *   ListExecutionsRequest request =
   *       ListExecutionsRequest.newBuilder()
   *           .setParent(EvaluationName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListExecutionsResponse response =
   *         workloadManagerClient.listExecutionsCallable().call(request);
   *     for (Execution element : response.getExecutionsList()) {
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
  public final UnaryCallable<ListExecutionsRequest, ListExecutionsResponse>
      listExecutionsCallable() {
    return stub.listExecutionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Execution.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadManagerClient workloadManagerClient = WorkloadManagerClient.create()) {
   *   ExecutionName name =
   *       ExecutionName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]", "[EXECUTION]");
   *   Execution response = workloadManagerClient.getExecution(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Execution getExecution(ExecutionName name) {
    GetExecutionRequest request =
        GetExecutionRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getExecution(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Execution.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadManagerClient workloadManagerClient = WorkloadManagerClient.create()) {
   *   String name =
   *       ExecutionName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]", "[EXECUTION]").toString();
   *   Execution response = workloadManagerClient.getExecution(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Execution getExecution(String name) {
    GetExecutionRequest request = GetExecutionRequest.newBuilder().setName(name).build();
    return getExecution(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Execution.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadManagerClient workloadManagerClient = WorkloadManagerClient.create()) {
   *   GetExecutionRequest request =
   *       GetExecutionRequest.newBuilder()
   *           .setName(
   *               ExecutionName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]", "[EXECUTION]")
   *                   .toString())
   *           .build();
   *   Execution response = workloadManagerClient.getExecution(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Execution getExecution(GetExecutionRequest request) {
    return getExecutionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Execution.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadManagerClient workloadManagerClient = WorkloadManagerClient.create()) {
   *   GetExecutionRequest request =
   *       GetExecutionRequest.newBuilder()
   *           .setName(
   *               ExecutionName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]", "[EXECUTION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Execution> future =
   *       workloadManagerClient.getExecutionCallable().futureCall(request);
   *   // Do something.
   *   Execution response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetExecutionRequest, Execution> getExecutionCallable() {
    return stub.getExecutionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Execution in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadManagerClient workloadManagerClient = WorkloadManagerClient.create()) {
   *   EvaluationName name = EvaluationName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]");
   *   Execution execution = Execution.newBuilder().build();
   *   String executionId = "executionId-454906285";
   *   Execution response =
   *       workloadManagerClient.runEvaluationAsync(name, execution, executionId).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Evaluation using the form:
   *     `projects/{project}/locations/{location}/evaluations/{evaluation}`.
   * @param execution Required. The resource being created.
   * @param executionId Required. ID of the execution which will be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Execution, OperationMetadata> runEvaluationAsync(
      EvaluationName name, Execution execution, String executionId) {
    RunEvaluationRequest request =
        RunEvaluationRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setExecution(execution)
            .setExecutionId(executionId)
            .build();
    return runEvaluationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Execution in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadManagerClient workloadManagerClient = WorkloadManagerClient.create()) {
   *   String name = EvaluationName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]").toString();
   *   Execution execution = Execution.newBuilder().build();
   *   String executionId = "executionId-454906285";
   *   Execution response =
   *       workloadManagerClient.runEvaluationAsync(name, execution, executionId).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Evaluation using the form:
   *     `projects/{project}/locations/{location}/evaluations/{evaluation}`.
   * @param execution Required. The resource being created.
   * @param executionId Required. ID of the execution which will be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Execution, OperationMetadata> runEvaluationAsync(
      String name, Execution execution, String executionId) {
    RunEvaluationRequest request =
        RunEvaluationRequest.newBuilder()
            .setName(name)
            .setExecution(execution)
            .setExecutionId(executionId)
            .build();
    return runEvaluationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Execution in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadManagerClient workloadManagerClient = WorkloadManagerClient.create()) {
   *   RunEvaluationRequest request =
   *       RunEvaluationRequest.newBuilder()
   *           .setName(EvaluationName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]").toString())
   *           .setExecutionId("executionId-454906285")
   *           .setExecution(Execution.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Execution response = workloadManagerClient.runEvaluationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Execution, OperationMetadata> runEvaluationAsync(
      RunEvaluationRequest request) {
    return runEvaluationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Execution in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadManagerClient workloadManagerClient = WorkloadManagerClient.create()) {
   *   RunEvaluationRequest request =
   *       RunEvaluationRequest.newBuilder()
   *           .setName(EvaluationName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]").toString())
   *           .setExecutionId("executionId-454906285")
   *           .setExecution(Execution.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Execution, OperationMetadata> future =
   *       workloadManagerClient.runEvaluationOperationCallable().futureCall(request);
   *   // Do something.
   *   Execution response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<RunEvaluationRequest, Execution, OperationMetadata>
      runEvaluationOperationCallable() {
    return stub.runEvaluationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Execution in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadManagerClient workloadManagerClient = WorkloadManagerClient.create()) {
   *   RunEvaluationRequest request =
   *       RunEvaluationRequest.newBuilder()
   *           .setName(EvaluationName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]").toString())
   *           .setExecutionId("executionId-454906285")
   *           .setExecution(Execution.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       workloadManagerClient.runEvaluationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RunEvaluationRequest, Operation> runEvaluationCallable() {
    return stub.runEvaluationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Execution.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadManagerClient workloadManagerClient = WorkloadManagerClient.create()) {
   *   ExecutionName name =
   *       ExecutionName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]", "[EXECUTION]");
   *   workloadManagerClient.deleteExecutionAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteExecutionAsync(ExecutionName name) {
    DeleteExecutionRequest request =
        DeleteExecutionRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteExecutionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Execution.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadManagerClient workloadManagerClient = WorkloadManagerClient.create()) {
   *   String name =
   *       ExecutionName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]", "[EXECUTION]").toString();
   *   workloadManagerClient.deleteExecutionAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteExecutionAsync(String name) {
    DeleteExecutionRequest request = DeleteExecutionRequest.newBuilder().setName(name).build();
    return deleteExecutionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Execution.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadManagerClient workloadManagerClient = WorkloadManagerClient.create()) {
   *   DeleteExecutionRequest request =
   *       DeleteExecutionRequest.newBuilder()
   *           .setName(
   *               ExecutionName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]", "[EXECUTION]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   workloadManagerClient.deleteExecutionAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteExecutionAsync(
      DeleteExecutionRequest request) {
    return deleteExecutionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Execution.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadManagerClient workloadManagerClient = WorkloadManagerClient.create()) {
   *   DeleteExecutionRequest request =
   *       DeleteExecutionRequest.newBuilder()
   *           .setName(
   *               ExecutionName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]", "[EXECUTION]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       workloadManagerClient.deleteExecutionOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteExecutionRequest, Empty, OperationMetadata>
      deleteExecutionOperationCallable() {
    return stub.deleteExecutionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Execution.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadManagerClient workloadManagerClient = WorkloadManagerClient.create()) {
   *   DeleteExecutionRequest request =
   *       DeleteExecutionRequest.newBuilder()
   *           .setName(
   *               ExecutionName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]", "[EXECUTION]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       workloadManagerClient.deleteExecutionCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteExecutionRequest, Operation> deleteExecutionCallable() {
    return stub.deleteExecutionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the result of a single evaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadManagerClient workloadManagerClient = WorkloadManagerClient.create()) {
   *   String parent = "parent-995424086";
   *   for (ExecutionResult element :
   *       workloadManagerClient.listExecutionResults(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The execution results. Format:
   *     {parent}/evaluations/&#42;/executions/&#42;/results.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListExecutionResultsPagedResponse listExecutionResults(String parent) {
    ListExecutionResultsRequest request =
        ListExecutionResultsRequest.newBuilder().setParent(parent).build();
    return listExecutionResults(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the result of a single evaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadManagerClient workloadManagerClient = WorkloadManagerClient.create()) {
   *   ListExecutionResultsRequest request =
   *       ListExecutionResultsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (ExecutionResult element :
   *       workloadManagerClient.listExecutionResults(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListExecutionResultsPagedResponse listExecutionResults(
      ListExecutionResultsRequest request) {
    return listExecutionResultsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the result of a single evaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadManagerClient workloadManagerClient = WorkloadManagerClient.create()) {
   *   ListExecutionResultsRequest request =
   *       ListExecutionResultsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<ExecutionResult> future =
   *       workloadManagerClient.listExecutionResultsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ExecutionResult element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListExecutionResultsRequest, ListExecutionResultsPagedResponse>
      listExecutionResultsPagedCallable() {
    return stub.listExecutionResultsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the result of a single evaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadManagerClient workloadManagerClient = WorkloadManagerClient.create()) {
   *   ListExecutionResultsRequest request =
   *       ListExecutionResultsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListExecutionResultsResponse response =
   *         workloadManagerClient.listExecutionResultsCallable().call(request);
   *     for (ExecutionResult element : response.getExecutionResultsList()) {
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
  public final UnaryCallable<ListExecutionResultsRequest, ListExecutionResultsResponse>
      listExecutionResultsCallable() {
    return stub.listExecutionResultsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists rules in a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadManagerClient workloadManagerClient = WorkloadManagerClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ListRulesResponse response = workloadManagerClient.listRules(parent);
   * }
   * }</pre>
   *
   * @param parent Required. The [project] on which to execute the request. The format is:
   *     projects/{project_id}/locations/{location} Currently, the pre-defined rules are global
   *     available to all projects and all regions.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRulesResponse listRules(LocationName parent) {
    ListRulesRequest request =
        ListRulesRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listRules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists rules in a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadManagerClient workloadManagerClient = WorkloadManagerClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   ListRulesResponse response = workloadManagerClient.listRules(parent);
   * }
   * }</pre>
   *
   * @param parent Required. The [project] on which to execute the request. The format is:
   *     projects/{project_id}/locations/{location} Currently, the pre-defined rules are global
   *     available to all projects and all regions.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRulesResponse listRules(String parent) {
    ListRulesRequest request = ListRulesRequest.newBuilder().setParent(parent).build();
    return listRules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists rules in a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadManagerClient workloadManagerClient = WorkloadManagerClient.create()) {
   *   ListRulesRequest request =
   *       ListRulesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setCustomRulesBucket("customRulesBucket-888019568")
   *           .build();
   *   ListRulesResponse response = workloadManagerClient.listRules(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRulesResponse listRules(ListRulesRequest request) {
    return listRulesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists rules in a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadManagerClient workloadManagerClient = WorkloadManagerClient.create()) {
   *   ListRulesRequest request =
   *       ListRulesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setCustomRulesBucket("customRulesBucket-888019568")
   *           .build();
   *   ApiFuture<ListRulesResponse> future =
   *       workloadManagerClient.listRulesCallable().futureCall(request);
   *   // Do something.
   *   ListRulesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ListRulesRequest, ListRulesResponse> listRulesCallable() {
    return stub.listRulesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all scanned resources for a single Execution.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadManagerClient workloadManagerClient = WorkloadManagerClient.create()) {
   *   String parent = "parent-995424086";
   *   for (ScannedResource element :
   *       workloadManagerClient.listScannedResources(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent for ListScannedResourcesRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListScannedResourcesPagedResponse listScannedResources(String parent) {
    ListScannedResourcesRequest request =
        ListScannedResourcesRequest.newBuilder().setParent(parent).build();
    return listScannedResources(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all scanned resources for a single Execution.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadManagerClient workloadManagerClient = WorkloadManagerClient.create()) {
   *   ListScannedResourcesRequest request =
   *       ListScannedResourcesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setRule("rule3512060")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (ScannedResource element :
   *       workloadManagerClient.listScannedResources(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListScannedResourcesPagedResponse listScannedResources(
      ListScannedResourcesRequest request) {
    return listScannedResourcesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all scanned resources for a single Execution.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadManagerClient workloadManagerClient = WorkloadManagerClient.create()) {
   *   ListScannedResourcesRequest request =
   *       ListScannedResourcesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setRule("rule3512060")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<ScannedResource> future =
   *       workloadManagerClient.listScannedResourcesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ScannedResource element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListScannedResourcesRequest, ListScannedResourcesPagedResponse>
      listScannedResourcesPagedCallable() {
    return stub.listScannedResourcesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all scanned resources for a single Execution.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadManagerClient workloadManagerClient = WorkloadManagerClient.create()) {
   *   ListScannedResourcesRequest request =
   *       ListScannedResourcesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setRule("rule3512060")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListScannedResourcesResponse response =
   *         workloadManagerClient.listScannedResourcesCallable().call(request);
   *     for (ScannedResource element : response.getScannedResourcesList()) {
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
  public final UnaryCallable<ListScannedResourcesRequest, ListScannedResourcesResponse>
      listScannedResourcesCallable() {
    return stub.listScannedResourcesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.This method can be called in
   * two ways:
   *
   * <p>&#42; &#42;&#42;List all public locations:&#42;&#42; Use the path `GET /v1/locations`.&#42;
   * &#42;&#42;List project-visible locations:&#42;&#42; Use the path`GET
   * /v1/projects/{project_id}/locations`. This may include publiclocations as well as private or
   * other locations specifically visibleto the project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadManagerClient workloadManagerClient = WorkloadManagerClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : workloadManagerClient.listLocations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLocationsPagedResponse listLocations(ListLocationsRequest request) {
    return listLocationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.This method can be called in
   * two ways:
   *
   * <p>&#42; &#42;&#42;List all public locations:&#42;&#42; Use the path `GET /v1/locations`.&#42;
   * &#42;&#42;List project-visible locations:&#42;&#42; Use the path`GET
   * /v1/projects/{project_id}/locations`. This may include publiclocations as well as private or
   * other locations specifically visibleto the project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadManagerClient workloadManagerClient = WorkloadManagerClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       workloadManagerClient.listLocationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Location element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return stub.listLocationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.This method can be called in
   * two ways:
   *
   * <p>&#42; &#42;&#42;List all public locations:&#42;&#42; Use the path `GET /v1/locations`.&#42;
   * &#42;&#42;List project-visible locations:&#42;&#42; Use the path`GET
   * /v1/projects/{project_id}/locations`. This may include publiclocations as well as private or
   * other locations specifically visibleto the project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadManagerClient workloadManagerClient = WorkloadManagerClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         workloadManagerClient.listLocationsCallable().call(request);
   *     for (Location element : response.getLocationsList()) {
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
  public final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return stub.listLocationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadManagerClient workloadManagerClient = WorkloadManagerClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = workloadManagerClient.getLocation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Location getLocation(GetLocationRequest request) {
    return getLocationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadManagerClient workloadManagerClient = WorkloadManagerClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = workloadManagerClient.getLocationCallable().futureCall(request);
   *   // Do something.
   *   Location response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return stub.getLocationCallable();
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

  public static class ListEvaluationsPagedResponse
      extends AbstractPagedListResponse<
          ListEvaluationsRequest,
          ListEvaluationsResponse,
          Evaluation,
          ListEvaluationsPage,
          ListEvaluationsFixedSizeCollection> {

    public static ApiFuture<ListEvaluationsPagedResponse> createAsync(
        PageContext<ListEvaluationsRequest, ListEvaluationsResponse, Evaluation> context,
        ApiFuture<ListEvaluationsResponse> futureResponse) {
      ApiFuture<ListEvaluationsPage> futurePage =
          ListEvaluationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListEvaluationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListEvaluationsPagedResponse(ListEvaluationsPage page) {
      super(page, ListEvaluationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListEvaluationsPage
      extends AbstractPage<
          ListEvaluationsRequest, ListEvaluationsResponse, Evaluation, ListEvaluationsPage> {

    private ListEvaluationsPage(
        PageContext<ListEvaluationsRequest, ListEvaluationsResponse, Evaluation> context,
        ListEvaluationsResponse response) {
      super(context, response);
    }

    private static ListEvaluationsPage createEmptyPage() {
      return new ListEvaluationsPage(null, null);
    }

    @Override
    protected ListEvaluationsPage createPage(
        PageContext<ListEvaluationsRequest, ListEvaluationsResponse, Evaluation> context,
        ListEvaluationsResponse response) {
      return new ListEvaluationsPage(context, response);
    }

    @Override
    public ApiFuture<ListEvaluationsPage> createPageAsync(
        PageContext<ListEvaluationsRequest, ListEvaluationsResponse, Evaluation> context,
        ApiFuture<ListEvaluationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListEvaluationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListEvaluationsRequest,
          ListEvaluationsResponse,
          Evaluation,
          ListEvaluationsPage,
          ListEvaluationsFixedSizeCollection> {

    private ListEvaluationsFixedSizeCollection(
        List<ListEvaluationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListEvaluationsFixedSizeCollection createEmptyCollection() {
      return new ListEvaluationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListEvaluationsFixedSizeCollection createCollection(
        List<ListEvaluationsPage> pages, int collectionSize) {
      return new ListEvaluationsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListExecutionsPagedResponse
      extends AbstractPagedListResponse<
          ListExecutionsRequest,
          ListExecutionsResponse,
          Execution,
          ListExecutionsPage,
          ListExecutionsFixedSizeCollection> {

    public static ApiFuture<ListExecutionsPagedResponse> createAsync(
        PageContext<ListExecutionsRequest, ListExecutionsResponse, Execution> context,
        ApiFuture<ListExecutionsResponse> futureResponse) {
      ApiFuture<ListExecutionsPage> futurePage =
          ListExecutionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListExecutionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListExecutionsPagedResponse(ListExecutionsPage page) {
      super(page, ListExecutionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListExecutionsPage
      extends AbstractPage<
          ListExecutionsRequest, ListExecutionsResponse, Execution, ListExecutionsPage> {

    private ListExecutionsPage(
        PageContext<ListExecutionsRequest, ListExecutionsResponse, Execution> context,
        ListExecutionsResponse response) {
      super(context, response);
    }

    private static ListExecutionsPage createEmptyPage() {
      return new ListExecutionsPage(null, null);
    }

    @Override
    protected ListExecutionsPage createPage(
        PageContext<ListExecutionsRequest, ListExecutionsResponse, Execution> context,
        ListExecutionsResponse response) {
      return new ListExecutionsPage(context, response);
    }

    @Override
    public ApiFuture<ListExecutionsPage> createPageAsync(
        PageContext<ListExecutionsRequest, ListExecutionsResponse, Execution> context,
        ApiFuture<ListExecutionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListExecutionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListExecutionsRequest,
          ListExecutionsResponse,
          Execution,
          ListExecutionsPage,
          ListExecutionsFixedSizeCollection> {

    private ListExecutionsFixedSizeCollection(List<ListExecutionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListExecutionsFixedSizeCollection createEmptyCollection() {
      return new ListExecutionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListExecutionsFixedSizeCollection createCollection(
        List<ListExecutionsPage> pages, int collectionSize) {
      return new ListExecutionsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListExecutionResultsPagedResponse
      extends AbstractPagedListResponse<
          ListExecutionResultsRequest,
          ListExecutionResultsResponse,
          ExecutionResult,
          ListExecutionResultsPage,
          ListExecutionResultsFixedSizeCollection> {

    public static ApiFuture<ListExecutionResultsPagedResponse> createAsync(
        PageContext<ListExecutionResultsRequest, ListExecutionResultsResponse, ExecutionResult>
            context,
        ApiFuture<ListExecutionResultsResponse> futureResponse) {
      ApiFuture<ListExecutionResultsPage> futurePage =
          ListExecutionResultsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListExecutionResultsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListExecutionResultsPagedResponse(ListExecutionResultsPage page) {
      super(page, ListExecutionResultsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListExecutionResultsPage
      extends AbstractPage<
          ListExecutionResultsRequest,
          ListExecutionResultsResponse,
          ExecutionResult,
          ListExecutionResultsPage> {

    private ListExecutionResultsPage(
        PageContext<ListExecutionResultsRequest, ListExecutionResultsResponse, ExecutionResult>
            context,
        ListExecutionResultsResponse response) {
      super(context, response);
    }

    private static ListExecutionResultsPage createEmptyPage() {
      return new ListExecutionResultsPage(null, null);
    }

    @Override
    protected ListExecutionResultsPage createPage(
        PageContext<ListExecutionResultsRequest, ListExecutionResultsResponse, ExecutionResult>
            context,
        ListExecutionResultsResponse response) {
      return new ListExecutionResultsPage(context, response);
    }

    @Override
    public ApiFuture<ListExecutionResultsPage> createPageAsync(
        PageContext<ListExecutionResultsRequest, ListExecutionResultsResponse, ExecutionResult>
            context,
        ApiFuture<ListExecutionResultsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListExecutionResultsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListExecutionResultsRequest,
          ListExecutionResultsResponse,
          ExecutionResult,
          ListExecutionResultsPage,
          ListExecutionResultsFixedSizeCollection> {

    private ListExecutionResultsFixedSizeCollection(
        List<ListExecutionResultsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListExecutionResultsFixedSizeCollection createEmptyCollection() {
      return new ListExecutionResultsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListExecutionResultsFixedSizeCollection createCollection(
        List<ListExecutionResultsPage> pages, int collectionSize) {
      return new ListExecutionResultsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListScannedResourcesPagedResponse
      extends AbstractPagedListResponse<
          ListScannedResourcesRequest,
          ListScannedResourcesResponse,
          ScannedResource,
          ListScannedResourcesPage,
          ListScannedResourcesFixedSizeCollection> {

    public static ApiFuture<ListScannedResourcesPagedResponse> createAsync(
        PageContext<ListScannedResourcesRequest, ListScannedResourcesResponse, ScannedResource>
            context,
        ApiFuture<ListScannedResourcesResponse> futureResponse) {
      ApiFuture<ListScannedResourcesPage> futurePage =
          ListScannedResourcesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListScannedResourcesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListScannedResourcesPagedResponse(ListScannedResourcesPage page) {
      super(page, ListScannedResourcesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListScannedResourcesPage
      extends AbstractPage<
          ListScannedResourcesRequest,
          ListScannedResourcesResponse,
          ScannedResource,
          ListScannedResourcesPage> {

    private ListScannedResourcesPage(
        PageContext<ListScannedResourcesRequest, ListScannedResourcesResponse, ScannedResource>
            context,
        ListScannedResourcesResponse response) {
      super(context, response);
    }

    private static ListScannedResourcesPage createEmptyPage() {
      return new ListScannedResourcesPage(null, null);
    }

    @Override
    protected ListScannedResourcesPage createPage(
        PageContext<ListScannedResourcesRequest, ListScannedResourcesResponse, ScannedResource>
            context,
        ListScannedResourcesResponse response) {
      return new ListScannedResourcesPage(context, response);
    }

    @Override
    public ApiFuture<ListScannedResourcesPage> createPageAsync(
        PageContext<ListScannedResourcesRequest, ListScannedResourcesResponse, ScannedResource>
            context,
        ApiFuture<ListScannedResourcesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListScannedResourcesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListScannedResourcesRequest,
          ListScannedResourcesResponse,
          ScannedResource,
          ListScannedResourcesPage,
          ListScannedResourcesFixedSizeCollection> {

    private ListScannedResourcesFixedSizeCollection(
        List<ListScannedResourcesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListScannedResourcesFixedSizeCollection createEmptyCollection() {
      return new ListScannedResourcesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListScannedResourcesFixedSizeCollection createCollection(
        List<ListScannedResourcesPage> pages, int collectionSize) {
      return new ListScannedResourcesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListLocationsPagedResponse
      extends AbstractPagedListResponse<
          ListLocationsRequest,
          ListLocationsResponse,
          Location,
          ListLocationsPage,
          ListLocationsFixedSizeCollection> {

    public static ApiFuture<ListLocationsPagedResponse> createAsync(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ApiFuture<ListLocationsResponse> futureResponse) {
      ApiFuture<ListLocationsPage> futurePage =
          ListLocationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListLocationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListLocationsPagedResponse(ListLocationsPage page) {
      super(page, ListLocationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListLocationsPage
      extends AbstractPage<
          ListLocationsRequest, ListLocationsResponse, Location, ListLocationsPage> {

    private ListLocationsPage(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ListLocationsResponse response) {
      super(context, response);
    }

    private static ListLocationsPage createEmptyPage() {
      return new ListLocationsPage(null, null);
    }

    @Override
    protected ListLocationsPage createPage(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ListLocationsResponse response) {
      return new ListLocationsPage(context, response);
    }

    @Override
    public ApiFuture<ListLocationsPage> createPageAsync(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ApiFuture<ListLocationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListLocationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListLocationsRequest,
          ListLocationsResponse,
          Location,
          ListLocationsPage,
          ListLocationsFixedSizeCollection> {

    private ListLocationsFixedSizeCollection(List<ListLocationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLocationsFixedSizeCollection createEmptyCollection() {
      return new ListLocationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLocationsFixedSizeCollection createCollection(
        List<ListLocationsPage> pages, int collectionSize) {
      return new ListLocationsFixedSizeCollection(pages, collectionSize);
    }
  }
}
