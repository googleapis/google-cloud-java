/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.workflows.v1;

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
import com.google.cloud.workflows.v1.stub.WorkflowsStub;
import com.google.cloud.workflows.v1.stub.WorkflowsStubSettings;
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
 * Service Description: Workflows is used to deploy and execute workflow programs. Workflows makes
 * sure the program executes reliably, despite hardware and networking interruptions.
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
 * try (WorkflowsClient workflowsClient = WorkflowsClient.create()) {
 *   WorkflowName name = WorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]");
 *   Workflow response = workflowsClient.getWorkflow(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the WorkflowsClient object to clean up resources such as
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
 *      <td><p> ListWorkflows</td>
 *      <td><p> Lists workflows in a given project and location. The default order is not specified.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listWorkflows(ListWorkflowsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listWorkflows(LocationName parent)
 *           <li><p> listWorkflows(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listWorkflowsPagedCallable()
 *           <li><p> listWorkflowsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetWorkflow</td>
 *      <td><p> Gets details of a single workflow.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getWorkflow(GetWorkflowRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getWorkflow(WorkflowName name)
 *           <li><p> getWorkflow(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getWorkflowCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateWorkflow</td>
 *      <td><p> Creates a new workflow. If a workflow with the specified name already exists in the specified project and location, the long running operation returns a [ALREADY_EXISTS][google.rpc.Code.ALREADY_EXISTS] error.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createWorkflowAsync(CreateWorkflowRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createWorkflowAsync(LocationName parent, Workflow workflow, String workflowId)
 *           <li><p> createWorkflowAsync(String parent, Workflow workflow, String workflowId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createWorkflowOperationCallable()
 *           <li><p> createWorkflowCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteWorkflow</td>
 *      <td><p> Deletes a workflow with the specified name. This method also cancels and deletes all running executions of the workflow.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteWorkflowAsync(DeleteWorkflowRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteWorkflowAsync(WorkflowName name)
 *           <li><p> deleteWorkflowAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteWorkflowOperationCallable()
 *           <li><p> deleteWorkflowCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateWorkflow</td>
 *      <td><p> Updates an existing workflow. Running this method has no impact on already running executions of the workflow. A new revision of the workflow might be created as a result of a successful update operation. In that case, the new revision is used in new workflow executions.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateWorkflowAsync(UpdateWorkflowRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateWorkflowAsync(Workflow workflow, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateWorkflowOperationCallable()
 *           <li><p> updateWorkflowCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListWorkflowRevisions</td>
 *      <td><p> Lists revisions for a given workflow.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listWorkflowRevisions(ListWorkflowRevisionsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listWorkflowRevisionsPagedCallable()
 *           <li><p> listWorkflowRevisionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListLocations</td>
 *      <td><p> Lists information about the supported locations for this service.</td>
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
 * <p>This class can be customized by passing in a custom instance of WorkflowsSettings to create().
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
 * WorkflowsSettings workflowsSettings =
 *     WorkflowsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * WorkflowsClient workflowsClient = WorkflowsClient.create(workflowsSettings);
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
 * WorkflowsSettings workflowsSettings =
 *     WorkflowsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * WorkflowsClient workflowsClient = WorkflowsClient.create(workflowsSettings);
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
 * WorkflowsSettings workflowsSettings = WorkflowsSettings.newHttpJsonBuilder().build();
 * WorkflowsClient workflowsClient = WorkflowsClient.create(workflowsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class WorkflowsClient implements BackgroundResource {
  private final WorkflowsSettings settings;
  private final WorkflowsStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of WorkflowsClient with default settings. */
  public static final WorkflowsClient create() throws IOException {
    return create(WorkflowsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of WorkflowsClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final WorkflowsClient create(WorkflowsSettings settings) throws IOException {
    return new WorkflowsClient(settings);
  }

  /**
   * Constructs an instance of WorkflowsClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(WorkflowsSettings).
   */
  public static final WorkflowsClient create(WorkflowsStub stub) {
    return new WorkflowsClient(stub);
  }

  /**
   * Constructs an instance of WorkflowsClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected WorkflowsClient(WorkflowsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((WorkflowsStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected WorkflowsClient(WorkflowsStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final WorkflowsSettings getSettings() {
    return settings;
  }

  public WorkflowsStub getStub() {
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
   * Lists workflows in a given project and location. The default order is not specified.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkflowsClient workflowsClient = WorkflowsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Workflow element : workflowsClient.listWorkflows(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Project and location from which the workflows should be listed. Format:
   *     projects/{project}/locations/{location}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListWorkflowsPagedResponse listWorkflows(LocationName parent) {
    ListWorkflowsRequest request =
        ListWorkflowsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listWorkflows(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists workflows in a given project and location. The default order is not specified.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkflowsClient workflowsClient = WorkflowsClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Workflow element : workflowsClient.listWorkflows(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Project and location from which the workflows should be listed. Format:
   *     projects/{project}/locations/{location}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListWorkflowsPagedResponse listWorkflows(String parent) {
    ListWorkflowsRequest request = ListWorkflowsRequest.newBuilder().setParent(parent).build();
    return listWorkflows(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists workflows in a given project and location. The default order is not specified.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkflowsClient workflowsClient = WorkflowsClient.create()) {
   *   ListWorkflowsRequest request =
   *       ListWorkflowsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Workflow element : workflowsClient.listWorkflows(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListWorkflowsPagedResponse listWorkflows(ListWorkflowsRequest request) {
    return listWorkflowsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists workflows in a given project and location. The default order is not specified.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkflowsClient workflowsClient = WorkflowsClient.create()) {
   *   ListWorkflowsRequest request =
   *       ListWorkflowsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Workflow> future = workflowsClient.listWorkflowsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Workflow element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListWorkflowsRequest, ListWorkflowsPagedResponse>
      listWorkflowsPagedCallable() {
    return stub.listWorkflowsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists workflows in a given project and location. The default order is not specified.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkflowsClient workflowsClient = WorkflowsClient.create()) {
   *   ListWorkflowsRequest request =
   *       ListWorkflowsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListWorkflowsResponse response = workflowsClient.listWorkflowsCallable().call(request);
   *     for (Workflow element : response.getWorkflowsList()) {
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
  public final UnaryCallable<ListWorkflowsRequest, ListWorkflowsResponse> listWorkflowsCallable() {
    return stub.listWorkflowsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single workflow.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkflowsClient workflowsClient = WorkflowsClient.create()) {
   *   WorkflowName name = WorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]");
   *   Workflow response = workflowsClient.getWorkflow(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the workflow for which information should be retrieved. Format:
   *     projects/{project}/locations/{location}/workflows/{workflow}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Workflow getWorkflow(WorkflowName name) {
    GetWorkflowRequest request =
        GetWorkflowRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getWorkflow(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single workflow.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkflowsClient workflowsClient = WorkflowsClient.create()) {
   *   String name = WorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]").toString();
   *   Workflow response = workflowsClient.getWorkflow(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the workflow for which information should be retrieved. Format:
   *     projects/{project}/locations/{location}/workflows/{workflow}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Workflow getWorkflow(String name) {
    GetWorkflowRequest request = GetWorkflowRequest.newBuilder().setName(name).build();
    return getWorkflow(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single workflow.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkflowsClient workflowsClient = WorkflowsClient.create()) {
   *   GetWorkflowRequest request =
   *       GetWorkflowRequest.newBuilder()
   *           .setName(WorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]").toString())
   *           .setRevisionId("revisionId-1507445162")
   *           .build();
   *   Workflow response = workflowsClient.getWorkflow(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Workflow getWorkflow(GetWorkflowRequest request) {
    return getWorkflowCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single workflow.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkflowsClient workflowsClient = WorkflowsClient.create()) {
   *   GetWorkflowRequest request =
   *       GetWorkflowRequest.newBuilder()
   *           .setName(WorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]").toString())
   *           .setRevisionId("revisionId-1507445162")
   *           .build();
   *   ApiFuture<Workflow> future = workflowsClient.getWorkflowCallable().futureCall(request);
   *   // Do something.
   *   Workflow response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetWorkflowRequest, Workflow> getWorkflowCallable() {
    return stub.getWorkflowCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new workflow. If a workflow with the specified name already exists in the specified
   * project and location, the long running operation returns a
   * [ALREADY_EXISTS][google.rpc.Code.ALREADY_EXISTS] error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkflowsClient workflowsClient = WorkflowsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Workflow workflow = Workflow.newBuilder().build();
   *   String workflowId = "workflowId-360387270";
   *   Workflow response = workflowsClient.createWorkflowAsync(parent, workflow, workflowId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Project and location in which the workflow should be created. Format:
   *     projects/{project}/locations/{location}
   * @param workflow Required. Workflow to be created.
   * @param workflowId Required. The ID of the workflow to be created. It has to fulfill the
   *     following requirements:
   *     <ul>
   *       <li>Must contain only letters, numbers, underscores and hyphens.
   *       <li>Must start with a letter.
   *       <li>Must be between 1-64 characters.
   *       <li>Must end with a number or a letter.
   *       <li>Must be unique within the customer project and location.
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Workflow, OperationMetadata> createWorkflowAsync(
      LocationName parent, Workflow workflow, String workflowId) {
    CreateWorkflowRequest request =
        CreateWorkflowRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setWorkflow(workflow)
            .setWorkflowId(workflowId)
            .build();
    return createWorkflowAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new workflow. If a workflow with the specified name already exists in the specified
   * project and location, the long running operation returns a
   * [ALREADY_EXISTS][google.rpc.Code.ALREADY_EXISTS] error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkflowsClient workflowsClient = WorkflowsClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Workflow workflow = Workflow.newBuilder().build();
   *   String workflowId = "workflowId-360387270";
   *   Workflow response = workflowsClient.createWorkflowAsync(parent, workflow, workflowId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Project and location in which the workflow should be created. Format:
   *     projects/{project}/locations/{location}
   * @param workflow Required. Workflow to be created.
   * @param workflowId Required. The ID of the workflow to be created. It has to fulfill the
   *     following requirements:
   *     <ul>
   *       <li>Must contain only letters, numbers, underscores and hyphens.
   *       <li>Must start with a letter.
   *       <li>Must be between 1-64 characters.
   *       <li>Must end with a number or a letter.
   *       <li>Must be unique within the customer project and location.
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Workflow, OperationMetadata> createWorkflowAsync(
      String parent, Workflow workflow, String workflowId) {
    CreateWorkflowRequest request =
        CreateWorkflowRequest.newBuilder()
            .setParent(parent)
            .setWorkflow(workflow)
            .setWorkflowId(workflowId)
            .build();
    return createWorkflowAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new workflow. If a workflow with the specified name already exists in the specified
   * project and location, the long running operation returns a
   * [ALREADY_EXISTS][google.rpc.Code.ALREADY_EXISTS] error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkflowsClient workflowsClient = WorkflowsClient.create()) {
   *   CreateWorkflowRequest request =
   *       CreateWorkflowRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setWorkflow(Workflow.newBuilder().build())
   *           .setWorkflowId("workflowId-360387270")
   *           .build();
   *   Workflow response = workflowsClient.createWorkflowAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Workflow, OperationMetadata> createWorkflowAsync(
      CreateWorkflowRequest request) {
    return createWorkflowOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new workflow. If a workflow with the specified name already exists in the specified
   * project and location, the long running operation returns a
   * [ALREADY_EXISTS][google.rpc.Code.ALREADY_EXISTS] error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkflowsClient workflowsClient = WorkflowsClient.create()) {
   *   CreateWorkflowRequest request =
   *       CreateWorkflowRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setWorkflow(Workflow.newBuilder().build())
   *           .setWorkflowId("workflowId-360387270")
   *           .build();
   *   OperationFuture<Workflow, OperationMetadata> future =
   *       workflowsClient.createWorkflowOperationCallable().futureCall(request);
   *   // Do something.
   *   Workflow response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateWorkflowRequest, Workflow, OperationMetadata>
      createWorkflowOperationCallable() {
    return stub.createWorkflowOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new workflow. If a workflow with the specified name already exists in the specified
   * project and location, the long running operation returns a
   * [ALREADY_EXISTS][google.rpc.Code.ALREADY_EXISTS] error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkflowsClient workflowsClient = WorkflowsClient.create()) {
   *   CreateWorkflowRequest request =
   *       CreateWorkflowRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setWorkflow(Workflow.newBuilder().build())
   *           .setWorkflowId("workflowId-360387270")
   *           .build();
   *   ApiFuture<Operation> future = workflowsClient.createWorkflowCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateWorkflowRequest, Operation> createWorkflowCallable() {
    return stub.createWorkflowCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a workflow with the specified name. This method also cancels and deletes all running
   * executions of the workflow.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkflowsClient workflowsClient = WorkflowsClient.create()) {
   *   WorkflowName name = WorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]");
   *   workflowsClient.deleteWorkflowAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the workflow to be deleted. Format:
   *     projects/{project}/locations/{location}/workflows/{workflow}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteWorkflowAsync(WorkflowName name) {
    DeleteWorkflowRequest request =
        DeleteWorkflowRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteWorkflowAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a workflow with the specified name. This method also cancels and deletes all running
   * executions of the workflow.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkflowsClient workflowsClient = WorkflowsClient.create()) {
   *   String name = WorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]").toString();
   *   workflowsClient.deleteWorkflowAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the workflow to be deleted. Format:
   *     projects/{project}/locations/{location}/workflows/{workflow}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteWorkflowAsync(String name) {
    DeleteWorkflowRequest request = DeleteWorkflowRequest.newBuilder().setName(name).build();
    return deleteWorkflowAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a workflow with the specified name. This method also cancels and deletes all running
   * executions of the workflow.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkflowsClient workflowsClient = WorkflowsClient.create()) {
   *   DeleteWorkflowRequest request =
   *       DeleteWorkflowRequest.newBuilder()
   *           .setName(WorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]").toString())
   *           .build();
   *   workflowsClient.deleteWorkflowAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteWorkflowAsync(
      DeleteWorkflowRequest request) {
    return deleteWorkflowOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a workflow with the specified name. This method also cancels and deletes all running
   * executions of the workflow.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkflowsClient workflowsClient = WorkflowsClient.create()) {
   *   DeleteWorkflowRequest request =
   *       DeleteWorkflowRequest.newBuilder()
   *           .setName(WorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]").toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       workflowsClient.deleteWorkflowOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteWorkflowRequest, Empty, OperationMetadata>
      deleteWorkflowOperationCallable() {
    return stub.deleteWorkflowOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a workflow with the specified name. This method also cancels and deletes all running
   * executions of the workflow.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkflowsClient workflowsClient = WorkflowsClient.create()) {
   *   DeleteWorkflowRequest request =
   *       DeleteWorkflowRequest.newBuilder()
   *           .setName(WorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]").toString())
   *           .build();
   *   ApiFuture<Operation> future = workflowsClient.deleteWorkflowCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteWorkflowRequest, Operation> deleteWorkflowCallable() {
    return stub.deleteWorkflowCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing workflow. Running this method has no impact on already running executions
   * of the workflow. A new revision of the workflow might be created as a result of a successful
   * update operation. In that case, the new revision is used in new workflow executions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkflowsClient workflowsClient = WorkflowsClient.create()) {
   *   Workflow workflow = Workflow.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Workflow response = workflowsClient.updateWorkflowAsync(workflow, updateMask).get();
   * }
   * }</pre>
   *
   * @param workflow Required. Workflow to be updated.
   * @param updateMask List of fields to be updated. If not present, the entire workflow will be
   *     updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Workflow, OperationMetadata> updateWorkflowAsync(
      Workflow workflow, FieldMask updateMask) {
    UpdateWorkflowRequest request =
        UpdateWorkflowRequest.newBuilder().setWorkflow(workflow).setUpdateMask(updateMask).build();
    return updateWorkflowAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing workflow. Running this method has no impact on already running executions
   * of the workflow. A new revision of the workflow might be created as a result of a successful
   * update operation. In that case, the new revision is used in new workflow executions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkflowsClient workflowsClient = WorkflowsClient.create()) {
   *   UpdateWorkflowRequest request =
   *       UpdateWorkflowRequest.newBuilder()
   *           .setWorkflow(Workflow.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Workflow response = workflowsClient.updateWorkflowAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Workflow, OperationMetadata> updateWorkflowAsync(
      UpdateWorkflowRequest request) {
    return updateWorkflowOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing workflow. Running this method has no impact on already running executions
   * of the workflow. A new revision of the workflow might be created as a result of a successful
   * update operation. In that case, the new revision is used in new workflow executions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkflowsClient workflowsClient = WorkflowsClient.create()) {
   *   UpdateWorkflowRequest request =
   *       UpdateWorkflowRequest.newBuilder()
   *           .setWorkflow(Workflow.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<Workflow, OperationMetadata> future =
   *       workflowsClient.updateWorkflowOperationCallable().futureCall(request);
   *   // Do something.
   *   Workflow response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateWorkflowRequest, Workflow, OperationMetadata>
      updateWorkflowOperationCallable() {
    return stub.updateWorkflowOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing workflow. Running this method has no impact on already running executions
   * of the workflow. A new revision of the workflow might be created as a result of a successful
   * update operation. In that case, the new revision is used in new workflow executions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkflowsClient workflowsClient = WorkflowsClient.create()) {
   *   UpdateWorkflowRequest request =
   *       UpdateWorkflowRequest.newBuilder()
   *           .setWorkflow(Workflow.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = workflowsClient.updateWorkflowCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateWorkflowRequest, Operation> updateWorkflowCallable() {
    return stub.updateWorkflowCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists revisions for a given workflow.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkflowsClient workflowsClient = WorkflowsClient.create()) {
   *   ListWorkflowRevisionsRequest request =
   *       ListWorkflowRevisionsRequest.newBuilder()
   *           .setName(WorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Workflow element : workflowsClient.listWorkflowRevisions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListWorkflowRevisionsPagedResponse listWorkflowRevisions(
      ListWorkflowRevisionsRequest request) {
    return listWorkflowRevisionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists revisions for a given workflow.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkflowsClient workflowsClient = WorkflowsClient.create()) {
   *   ListWorkflowRevisionsRequest request =
   *       ListWorkflowRevisionsRequest.newBuilder()
   *           .setName(WorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Workflow> future =
   *       workflowsClient.listWorkflowRevisionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Workflow element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListWorkflowRevisionsRequest, ListWorkflowRevisionsPagedResponse>
      listWorkflowRevisionsPagedCallable() {
    return stub.listWorkflowRevisionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists revisions for a given workflow.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkflowsClient workflowsClient = WorkflowsClient.create()) {
   *   ListWorkflowRevisionsRequest request =
   *       ListWorkflowRevisionsRequest.newBuilder()
   *           .setName(WorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListWorkflowRevisionsResponse response =
   *         workflowsClient.listWorkflowRevisionsCallable().call(request);
   *     for (Workflow element : response.getWorkflowsList()) {
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
  public final UnaryCallable<ListWorkflowRevisionsRequest, ListWorkflowRevisionsResponse>
      listWorkflowRevisionsCallable() {
    return stub.listWorkflowRevisionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkflowsClient workflowsClient = WorkflowsClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : workflowsClient.listLocations(request).iterateAll()) {
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
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkflowsClient workflowsClient = WorkflowsClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future = workflowsClient.listLocationsPagedCallable().futureCall(request);
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
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkflowsClient workflowsClient = WorkflowsClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = workflowsClient.listLocationsCallable().call(request);
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
   * try (WorkflowsClient workflowsClient = WorkflowsClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = workflowsClient.getLocation(request);
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
   * try (WorkflowsClient workflowsClient = WorkflowsClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = workflowsClient.getLocationCallable().futureCall(request);
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

  public static class ListWorkflowsPagedResponse
      extends AbstractPagedListResponse<
          ListWorkflowsRequest,
          ListWorkflowsResponse,
          Workflow,
          ListWorkflowsPage,
          ListWorkflowsFixedSizeCollection> {

    public static ApiFuture<ListWorkflowsPagedResponse> createAsync(
        PageContext<ListWorkflowsRequest, ListWorkflowsResponse, Workflow> context,
        ApiFuture<ListWorkflowsResponse> futureResponse) {
      ApiFuture<ListWorkflowsPage> futurePage =
          ListWorkflowsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListWorkflowsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListWorkflowsPagedResponse(ListWorkflowsPage page) {
      super(page, ListWorkflowsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListWorkflowsPage
      extends AbstractPage<
          ListWorkflowsRequest, ListWorkflowsResponse, Workflow, ListWorkflowsPage> {

    private ListWorkflowsPage(
        PageContext<ListWorkflowsRequest, ListWorkflowsResponse, Workflow> context,
        ListWorkflowsResponse response) {
      super(context, response);
    }

    private static ListWorkflowsPage createEmptyPage() {
      return new ListWorkflowsPage(null, null);
    }

    @Override
    protected ListWorkflowsPage createPage(
        PageContext<ListWorkflowsRequest, ListWorkflowsResponse, Workflow> context,
        ListWorkflowsResponse response) {
      return new ListWorkflowsPage(context, response);
    }

    @Override
    public ApiFuture<ListWorkflowsPage> createPageAsync(
        PageContext<ListWorkflowsRequest, ListWorkflowsResponse, Workflow> context,
        ApiFuture<ListWorkflowsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListWorkflowsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListWorkflowsRequest,
          ListWorkflowsResponse,
          Workflow,
          ListWorkflowsPage,
          ListWorkflowsFixedSizeCollection> {

    private ListWorkflowsFixedSizeCollection(List<ListWorkflowsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListWorkflowsFixedSizeCollection createEmptyCollection() {
      return new ListWorkflowsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListWorkflowsFixedSizeCollection createCollection(
        List<ListWorkflowsPage> pages, int collectionSize) {
      return new ListWorkflowsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListWorkflowRevisionsPagedResponse
      extends AbstractPagedListResponse<
          ListWorkflowRevisionsRequest,
          ListWorkflowRevisionsResponse,
          Workflow,
          ListWorkflowRevisionsPage,
          ListWorkflowRevisionsFixedSizeCollection> {

    public static ApiFuture<ListWorkflowRevisionsPagedResponse> createAsync(
        PageContext<ListWorkflowRevisionsRequest, ListWorkflowRevisionsResponse, Workflow> context,
        ApiFuture<ListWorkflowRevisionsResponse> futureResponse) {
      ApiFuture<ListWorkflowRevisionsPage> futurePage =
          ListWorkflowRevisionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListWorkflowRevisionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListWorkflowRevisionsPagedResponse(ListWorkflowRevisionsPage page) {
      super(page, ListWorkflowRevisionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListWorkflowRevisionsPage
      extends AbstractPage<
          ListWorkflowRevisionsRequest,
          ListWorkflowRevisionsResponse,
          Workflow,
          ListWorkflowRevisionsPage> {

    private ListWorkflowRevisionsPage(
        PageContext<ListWorkflowRevisionsRequest, ListWorkflowRevisionsResponse, Workflow> context,
        ListWorkflowRevisionsResponse response) {
      super(context, response);
    }

    private static ListWorkflowRevisionsPage createEmptyPage() {
      return new ListWorkflowRevisionsPage(null, null);
    }

    @Override
    protected ListWorkflowRevisionsPage createPage(
        PageContext<ListWorkflowRevisionsRequest, ListWorkflowRevisionsResponse, Workflow> context,
        ListWorkflowRevisionsResponse response) {
      return new ListWorkflowRevisionsPage(context, response);
    }

    @Override
    public ApiFuture<ListWorkflowRevisionsPage> createPageAsync(
        PageContext<ListWorkflowRevisionsRequest, ListWorkflowRevisionsResponse, Workflow> context,
        ApiFuture<ListWorkflowRevisionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListWorkflowRevisionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListWorkflowRevisionsRequest,
          ListWorkflowRevisionsResponse,
          Workflow,
          ListWorkflowRevisionsPage,
          ListWorkflowRevisionsFixedSizeCollection> {

    private ListWorkflowRevisionsFixedSizeCollection(
        List<ListWorkflowRevisionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListWorkflowRevisionsFixedSizeCollection createEmptyCollection() {
      return new ListWorkflowRevisionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListWorkflowRevisionsFixedSizeCollection createCollection(
        List<ListWorkflowRevisionsPage> pages, int collectionSize) {
      return new ListWorkflowRevisionsFixedSizeCollection(pages, collectionSize);
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
