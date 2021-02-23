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

package com.google.cloud.aiplatform.v1;

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
import com.google.cloud.aiplatform.v1.stub.EndpointServiceStub;
import com.google.cloud.aiplatform.v1.stub.EndpointServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * This class provides the ability to make remote calls to the backing service through method calls
 * that map to API methods. Sample code to get started:
 *
 * <p>Note: close() needs to be called on the EndpointServiceClient object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
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
 * <p>This class can be customized by passing in a custom instance of EndpointServiceSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * EndpointServiceSettings endpointServiceSettings =
 *     EndpointServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * EndpointServiceClient endpointServiceClient =
 *     EndpointServiceClient.create(endpointServiceSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * EndpointServiceSettings endpointServiceSettings =
 *     EndpointServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * EndpointServiceClient endpointServiceClient =
 *     EndpointServiceClient.create(endpointServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class EndpointServiceClient implements BackgroundResource {
  private final EndpointServiceSettings settings;
  private final EndpointServiceStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of EndpointServiceClient with default settings. */
  public static final EndpointServiceClient create() throws IOException {
    return create(EndpointServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of EndpointServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final EndpointServiceClient create(EndpointServiceSettings settings)
      throws IOException {
    return new EndpointServiceClient(settings);
  }

  /**
   * Constructs an instance of EndpointServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(EndpointServiceSettings).
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final EndpointServiceClient create(EndpointServiceStub stub) {
    return new EndpointServiceClient(stub);
  }

  /**
   * Constructs an instance of EndpointServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected EndpointServiceClient(EndpointServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((EndpointServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected EndpointServiceClient(EndpointServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final EndpointServiceSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public EndpointServiceStub getStub() {
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
   * Creates an Endpoint.
   *
   * @param parent Required. The resource name of the Location to create the Endpoint in. Format:
   *     `projects/{project}/locations/{location}`
   * @param endpoint Required. The Endpoint to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Endpoint, CreateEndpointOperationMetadata> createEndpointAsync(
      LocationName parent, Endpoint endpoint) {
    CreateEndpointRequest request =
        CreateEndpointRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setEndpoint(endpoint)
            .build();
    return createEndpointAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an Endpoint.
   *
   * @param parent Required. The resource name of the Location to create the Endpoint in. Format:
   *     `projects/{project}/locations/{location}`
   * @param endpoint Required. The Endpoint to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Endpoint, CreateEndpointOperationMetadata> createEndpointAsync(
      String parent, Endpoint endpoint) {
    CreateEndpointRequest request =
        CreateEndpointRequest.newBuilder().setParent(parent).setEndpoint(endpoint).build();
    return createEndpointAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an Endpoint.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Endpoint, CreateEndpointOperationMetadata> createEndpointAsync(
      CreateEndpointRequest request) {
    return createEndpointOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an Endpoint.
   *
   * <p>Sample code:
   */
  public final OperationCallable<CreateEndpointRequest, Endpoint, CreateEndpointOperationMetadata>
      createEndpointOperationCallable() {
    return stub.createEndpointOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an Endpoint.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<CreateEndpointRequest, Operation> createEndpointCallable() {
    return stub.createEndpointCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an Endpoint.
   *
   * @param name Required. The name of the Endpoint resource. Format:
   *     `projects/{project}/locations/{location}/endpoints/{endpoint}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Endpoint getEndpoint(EndpointName name) {
    GetEndpointRequest request =
        GetEndpointRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getEndpoint(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an Endpoint.
   *
   * @param name Required. The name of the Endpoint resource. Format:
   *     `projects/{project}/locations/{location}/endpoints/{endpoint}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Endpoint getEndpoint(String name) {
    GetEndpointRequest request = GetEndpointRequest.newBuilder().setName(name).build();
    return getEndpoint(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an Endpoint.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Endpoint getEndpoint(GetEndpointRequest request) {
    return getEndpointCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an Endpoint.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<GetEndpointRequest, Endpoint> getEndpointCallable() {
    return stub.getEndpointCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Endpoints in a Location.
   *
   * @param parent Required. The resource name of the Location from which to list the Endpoints.
   *     Format: `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEndpointsPagedResponse listEndpoints(LocationName parent) {
    ListEndpointsRequest request =
        ListEndpointsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listEndpoints(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Endpoints in a Location.
   *
   * @param parent Required. The resource name of the Location from which to list the Endpoints.
   *     Format: `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEndpointsPagedResponse listEndpoints(String parent) {
    ListEndpointsRequest request = ListEndpointsRequest.newBuilder().setParent(parent).build();
    return listEndpoints(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Endpoints in a Location.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEndpointsPagedResponse listEndpoints(ListEndpointsRequest request) {
    return listEndpointsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Endpoints in a Location.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListEndpointsRequest, ListEndpointsPagedResponse>
      listEndpointsPagedCallable() {
    return stub.listEndpointsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Endpoints in a Location.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListEndpointsRequest, ListEndpointsResponse> listEndpointsCallable() {
    return stub.listEndpointsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an Endpoint.
   *
   * @param endpoint Required. The Endpoint which replaces the resource on the server.
   * @param updateMask Required. The update mask applies to the resource. See
   *     [FieldMask](https://tinyurl.com/protobufs/google.protobuf#fieldmask).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Endpoint updateEndpoint(Endpoint endpoint, FieldMask updateMask) {
    UpdateEndpointRequest request =
        UpdateEndpointRequest.newBuilder().setEndpoint(endpoint).setUpdateMask(updateMask).build();
    return updateEndpoint(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an Endpoint.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Endpoint updateEndpoint(UpdateEndpointRequest request) {
    return updateEndpointCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an Endpoint.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<UpdateEndpointRequest, Endpoint> updateEndpointCallable() {
    return stub.updateEndpointCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an Endpoint.
   *
   * @param name Required. The name of the Endpoint resource to be deleted. Format:
   *     `projects/{project}/locations/{location}/endpoints/{endpoint}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteEndpointAsync(
      EndpointName name) {
    DeleteEndpointRequest request =
        DeleteEndpointRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteEndpointAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an Endpoint.
   *
   * @param name Required. The name of the Endpoint resource to be deleted. Format:
   *     `projects/{project}/locations/{location}/endpoints/{endpoint}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteEndpointAsync(String name) {
    DeleteEndpointRequest request = DeleteEndpointRequest.newBuilder().setName(name).build();
    return deleteEndpointAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an Endpoint.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteEndpointAsync(
      DeleteEndpointRequest request) {
    return deleteEndpointOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an Endpoint.
   *
   * <p>Sample code:
   */
  public final OperationCallable<DeleteEndpointRequest, Empty, DeleteOperationMetadata>
      deleteEndpointOperationCallable() {
    return stub.deleteEndpointOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an Endpoint.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<DeleteEndpointRequest, Operation> deleteEndpointCallable() {
    return stub.deleteEndpointCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deploys a Model into this Endpoint, creating a DeployedModel within it.
   *
   * @param endpoint Required. The name of the Endpoint resource into which to deploy a Model.
   *     Format: `projects/{project}/locations/{location}/endpoints/{endpoint}`
   * @param deployedModel Required. The DeployedModel to be created within the Endpoint. Note that
   *     [Endpoint.traffic_split][google.cloud.aiplatform.v1.Endpoint.traffic_split] must be updated
   *     for the DeployedModel to start receiving traffic, either as part of this call, or via
   *     [EndpointService.UpdateEndpoint][google.cloud.aiplatform.v1.EndpointService.UpdateEndpoint].
   * @param trafficSplit A map from a DeployedModel's ID to the percentage of this Endpoint's
   *     traffic that should be forwarded to that DeployedModel.
   *     <p>If this field is non-empty, then the Endpoint's
   *     [traffic_split][google.cloud.aiplatform.v1.Endpoint.traffic_split] will be overwritten with
   *     it. To refer to the ID of the just being deployed Model, a "0" should be used, and the
   *     actual ID of the new DeployedModel will be filled in its place by this method. The traffic
   *     percentage values must add up to 100.
   *     <p>If this field is empty, then the Endpoint's
   *     [traffic_split][google.cloud.aiplatform.v1.Endpoint.traffic_split] is not updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DeployModelResponse, DeployModelOperationMetadata> deployModelAsync(
      EndpointName endpoint, DeployedModel deployedModel, Map<String, Integer> trafficSplit) {
    DeployModelRequest request =
        DeployModelRequest.newBuilder()
            .setEndpoint(endpoint == null ? null : endpoint.toString())
            .setDeployedModel(deployedModel)
            .putAllTrafficSplit(trafficSplit)
            .build();
    return deployModelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deploys a Model into this Endpoint, creating a DeployedModel within it.
   *
   * @param endpoint Required. The name of the Endpoint resource into which to deploy a Model.
   *     Format: `projects/{project}/locations/{location}/endpoints/{endpoint}`
   * @param deployedModel Required. The DeployedModel to be created within the Endpoint. Note that
   *     [Endpoint.traffic_split][google.cloud.aiplatform.v1.Endpoint.traffic_split] must be updated
   *     for the DeployedModel to start receiving traffic, either as part of this call, or via
   *     [EndpointService.UpdateEndpoint][google.cloud.aiplatform.v1.EndpointService.UpdateEndpoint].
   * @param trafficSplit A map from a DeployedModel's ID to the percentage of this Endpoint's
   *     traffic that should be forwarded to that DeployedModel.
   *     <p>If this field is non-empty, then the Endpoint's
   *     [traffic_split][google.cloud.aiplatform.v1.Endpoint.traffic_split] will be overwritten with
   *     it. To refer to the ID of the just being deployed Model, a "0" should be used, and the
   *     actual ID of the new DeployedModel will be filled in its place by this method. The traffic
   *     percentage values must add up to 100.
   *     <p>If this field is empty, then the Endpoint's
   *     [traffic_split][google.cloud.aiplatform.v1.Endpoint.traffic_split] is not updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DeployModelResponse, DeployModelOperationMetadata> deployModelAsync(
      String endpoint, DeployedModel deployedModel, Map<String, Integer> trafficSplit) {
    DeployModelRequest request =
        DeployModelRequest.newBuilder()
            .setEndpoint(endpoint)
            .setDeployedModel(deployedModel)
            .putAllTrafficSplit(trafficSplit)
            .build();
    return deployModelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deploys a Model into this Endpoint, creating a DeployedModel within it.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DeployModelResponse, DeployModelOperationMetadata> deployModelAsync(
      DeployModelRequest request) {
    return deployModelOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deploys a Model into this Endpoint, creating a DeployedModel within it.
   *
   * <p>Sample code:
   */
  public final OperationCallable<
          DeployModelRequest, DeployModelResponse, DeployModelOperationMetadata>
      deployModelOperationCallable() {
    return stub.deployModelOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deploys a Model into this Endpoint, creating a DeployedModel within it.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<DeployModelRequest, Operation> deployModelCallable() {
    return stub.deployModelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeploys a Model from an Endpoint, removing a DeployedModel from it, and freeing all resources
   * it's using.
   *
   * @param endpoint Required. The name of the Endpoint resource from which to undeploy a Model.
   *     Format: `projects/{project}/locations/{location}/endpoints/{endpoint}`
   * @param deployedModelId Required. The ID of the DeployedModel to be undeployed from the
   *     Endpoint.
   * @param trafficSplit If this field is provided, then the Endpoint's
   *     [traffic_split][google.cloud.aiplatform.v1.Endpoint.traffic_split] will be overwritten with
   *     it. If last DeployedModel is being undeployed from the Endpoint, the
   *     [Endpoint.traffic_split] will always end up empty when this call returns. A DeployedModel
   *     will be successfully undeployed only if it doesn't have any traffic assigned to it when
   *     this method executes, or if this field unassigns any traffic to it.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<UndeployModelResponse, UndeployModelOperationMetadata>
      undeployModelAsync(
          EndpointName endpoint, String deployedModelId, Map<String, Integer> trafficSplit) {
    UndeployModelRequest request =
        UndeployModelRequest.newBuilder()
            .setEndpoint(endpoint == null ? null : endpoint.toString())
            .setDeployedModelId(deployedModelId)
            .putAllTrafficSplit(trafficSplit)
            .build();
    return undeployModelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeploys a Model from an Endpoint, removing a DeployedModel from it, and freeing all resources
   * it's using.
   *
   * @param endpoint Required. The name of the Endpoint resource from which to undeploy a Model.
   *     Format: `projects/{project}/locations/{location}/endpoints/{endpoint}`
   * @param deployedModelId Required. The ID of the DeployedModel to be undeployed from the
   *     Endpoint.
   * @param trafficSplit If this field is provided, then the Endpoint's
   *     [traffic_split][google.cloud.aiplatform.v1.Endpoint.traffic_split] will be overwritten with
   *     it. If last DeployedModel is being undeployed from the Endpoint, the
   *     [Endpoint.traffic_split] will always end up empty when this call returns. A DeployedModel
   *     will be successfully undeployed only if it doesn't have any traffic assigned to it when
   *     this method executes, or if this field unassigns any traffic to it.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<UndeployModelResponse, UndeployModelOperationMetadata>
      undeployModelAsync(
          String endpoint, String deployedModelId, Map<String, Integer> trafficSplit) {
    UndeployModelRequest request =
        UndeployModelRequest.newBuilder()
            .setEndpoint(endpoint)
            .setDeployedModelId(deployedModelId)
            .putAllTrafficSplit(trafficSplit)
            .build();
    return undeployModelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeploys a Model from an Endpoint, removing a DeployedModel from it, and freeing all resources
   * it's using.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<UndeployModelResponse, UndeployModelOperationMetadata>
      undeployModelAsync(UndeployModelRequest request) {
    return undeployModelOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeploys a Model from an Endpoint, removing a DeployedModel from it, and freeing all resources
   * it's using.
   *
   * <p>Sample code:
   */
  public final OperationCallable<
          UndeployModelRequest, UndeployModelResponse, UndeployModelOperationMetadata>
      undeployModelOperationCallable() {
    return stub.undeployModelOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeploys a Model from an Endpoint, removing a DeployedModel from it, and freeing all resources
   * it's using.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<UndeployModelRequest, Operation> undeployModelCallable() {
    return stub.undeployModelCallable();
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

  public static class ListEndpointsPagedResponse
      extends AbstractPagedListResponse<
          ListEndpointsRequest,
          ListEndpointsResponse,
          Endpoint,
          ListEndpointsPage,
          ListEndpointsFixedSizeCollection> {

    public static ApiFuture<ListEndpointsPagedResponse> createAsync(
        PageContext<ListEndpointsRequest, ListEndpointsResponse, Endpoint> context,
        ApiFuture<ListEndpointsResponse> futureResponse) {
      ApiFuture<ListEndpointsPage> futurePage =
          ListEndpointsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListEndpointsPage, ListEndpointsPagedResponse>() {
            @Override
            public ListEndpointsPagedResponse apply(ListEndpointsPage input) {
              return new ListEndpointsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListEndpointsPagedResponse(ListEndpointsPage page) {
      super(page, ListEndpointsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListEndpointsPage
      extends AbstractPage<
          ListEndpointsRequest, ListEndpointsResponse, Endpoint, ListEndpointsPage> {

    private ListEndpointsPage(
        PageContext<ListEndpointsRequest, ListEndpointsResponse, Endpoint> context,
        ListEndpointsResponse response) {
      super(context, response);
    }

    private static ListEndpointsPage createEmptyPage() {
      return new ListEndpointsPage(null, null);
    }

    @Override
    protected ListEndpointsPage createPage(
        PageContext<ListEndpointsRequest, ListEndpointsResponse, Endpoint> context,
        ListEndpointsResponse response) {
      return new ListEndpointsPage(context, response);
    }

    @Override
    public ApiFuture<ListEndpointsPage> createPageAsync(
        PageContext<ListEndpointsRequest, ListEndpointsResponse, Endpoint> context,
        ApiFuture<ListEndpointsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListEndpointsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListEndpointsRequest,
          ListEndpointsResponse,
          Endpoint,
          ListEndpointsPage,
          ListEndpointsFixedSizeCollection> {

    private ListEndpointsFixedSizeCollection(List<ListEndpointsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListEndpointsFixedSizeCollection createEmptyCollection() {
      return new ListEndpointsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListEndpointsFixedSizeCollection createCollection(
        List<ListEndpointsPage> pages, int collectionSize) {
      return new ListEndpointsFixedSizeCollection(pages, collectionSize);
    }
  }
}
