/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.workflows.v1beta;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.workflows.v1beta.stub.WorkflowsStub;
import com.google.cloud.workflows.v1beta.stub.WorkflowsStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
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
 * <p>Note: close() needs to be called on the WorkflowsClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
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
 * <p>This class can be customized by passing in a custom instance of WorkflowsSettings to create().
 * For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
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
 * WorkflowsSettings workflowsSettings =
 *     WorkflowsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * WorkflowsClient workflowsClient = WorkflowsClient.create(workflowsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator")
public class WorkflowsClient implements BackgroundResource {
  private final WorkflowsSettings settings;
  private final WorkflowsStub stub;
  private final OperationsClient operationsClient;

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
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
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
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected WorkflowsClient(WorkflowsStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final WorkflowsSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public WorkflowsStub getStub() {
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
   * Lists Workflows in a given project and location. The default order is not specified.
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
   * Lists Workflows in a given project and location. The default order is not specified.
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
   * Lists Workflows in a given project and location. The default order is not specified.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListWorkflowsPagedResponse listWorkflows(ListWorkflowsRequest request) {
    return listWorkflowsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Workflows in a given project and location. The default order is not specified.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListWorkflowsRequest, ListWorkflowsPagedResponse>
      listWorkflowsPagedCallable() {
    return stub.listWorkflowsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Workflows in a given project and location. The default order is not specified.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListWorkflowsRequest, ListWorkflowsResponse> listWorkflowsCallable() {
    return stub.listWorkflowsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Workflow.
   *
   * @param name Required. Name of the workflow which information should be retrieved. Format:
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
   * Gets details of a single Workflow.
   *
   * @param name Required. Name of the workflow which information should be retrieved. Format:
   *     projects/{project}/locations/{location}/workflows/{workflow}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Workflow getWorkflow(String name) {
    GetWorkflowRequest request = GetWorkflowRequest.newBuilder().setName(name).build();
    return getWorkflow(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Workflow.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Workflow getWorkflow(GetWorkflowRequest request) {
    return getWorkflowCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Workflow.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<GetWorkflowRequest, Workflow> getWorkflowCallable() {
    return stub.getWorkflowCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new workflow. If a workflow with the specified name already exists in the specified
   * project and location, the long running operation will return
   * [ALREADY_EXISTS][google.rpc.Code.ALREADY_EXISTS] error.
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
   * project and location, the long running operation will return
   * [ALREADY_EXISTS][google.rpc.Code.ALREADY_EXISTS] error.
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
   * project and location, the long running operation will return
   * [ALREADY_EXISTS][google.rpc.Code.ALREADY_EXISTS] error.
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
   * project and location, the long running operation will return
   * [ALREADY_EXISTS][google.rpc.Code.ALREADY_EXISTS] error.
   *
   * <p>Sample code:
   */
  public final OperationCallable<CreateWorkflowRequest, Workflow, OperationMetadata>
      createWorkflowOperationCallable() {
    return stub.createWorkflowOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new workflow. If a workflow with the specified name already exists in the specified
   * project and location, the long running operation will return
   * [ALREADY_EXISTS][google.rpc.Code.ALREADY_EXISTS] error.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<CreateWorkflowRequest, Operation> createWorkflowCallable() {
    return stub.createWorkflowCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a workflow with the specified name. This method also cancels and deletes all running
   * executions of the workflow.
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
   */
  public final UnaryCallable<DeleteWorkflowRequest, Operation> deleteWorkflowCallable() {
    return stub.deleteWorkflowCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing workflow. Running this method has no impact on already running executions
   * of the workflow. A new revision of the workflow may be created as a result of a successful
   * update operation. In that case, such revision will be used in new workflow executions.
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
   * of the workflow. A new revision of the workflow may be created as a result of a successful
   * update operation. In that case, such revision will be used in new workflow executions.
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
   * of the workflow. A new revision of the workflow may be created as a result of a successful
   * update operation. In that case, such revision will be used in new workflow executions.
   *
   * <p>Sample code:
   */
  public final OperationCallable<UpdateWorkflowRequest, Workflow, OperationMetadata>
      updateWorkflowOperationCallable() {
    return stub.updateWorkflowOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing workflow. Running this method has no impact on already running executions
   * of the workflow. A new revision of the workflow may be created as a result of a successful
   * update operation. In that case, such revision will be used in new workflow executions.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<UpdateWorkflowRequest, Operation> updateWorkflowCallable() {
    return stub.updateWorkflowCallable();
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
          new ApiFunction<ListWorkflowsPage, ListWorkflowsPagedResponse>() {
            @Override
            public ListWorkflowsPagedResponse apply(ListWorkflowsPage input) {
              return new ListWorkflowsPagedResponse(input);
            }
          },
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
}
