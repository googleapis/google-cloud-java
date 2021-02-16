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

package com.google.cloud.networkconnectivity.v1alpha1;

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
import com.google.cloud.networkconnectivity.v1alpha1.stub.HubServiceStub;
import com.google.cloud.networkconnectivity.v1alpha1.stub.HubServiceStubSettings;
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
 * Service Description: Network Connectivity Center is a hub-and-spoke abstraction for network
 * connectivity management in Google Cloud. It reduces operational complexity through a simple,
 * centralized connectivity management model.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <p>Note: close() needs to be called on the HubServiceClient object to clean up resources such as
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
 * <p>This class can be customized by passing in a custom instance of HubServiceSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * HubServiceSettings hubServiceSettings =
 *     HubServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * HubServiceClient hubServiceClient = HubServiceClient.create(hubServiceSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * HubServiceSettings hubServiceSettings =
 *     HubServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * HubServiceClient hubServiceClient = HubServiceClient.create(hubServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HubServiceClient implements BackgroundResource {
  private final HubServiceSettings settings;
  private final HubServiceStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of HubServiceClient with default settings. */
  public static final HubServiceClient create() throws IOException {
    return create(HubServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of HubServiceClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final HubServiceClient create(HubServiceSettings settings) throws IOException {
    return new HubServiceClient(settings);
  }

  /**
   * Constructs an instance of HubServiceClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(HubServiceSettings).
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final HubServiceClient create(HubServiceStub stub) {
    return new HubServiceClient(stub);
  }

  /**
   * Constructs an instance of HubServiceClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected HubServiceClient(HubServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((HubServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected HubServiceClient(HubServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final HubServiceSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public HubServiceStub getStub() {
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
   * Lists Hubs in a given project and location.
   *
   * @param parent Required. The parent resource's name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListHubsPagedResponse listHubs(LocationName parent) {
    ListHubsRequest request =
        ListHubsRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listHubs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Hubs in a given project and location.
   *
   * @param parent Required. The parent resource's name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListHubsPagedResponse listHubs(String parent) {
    ListHubsRequest request = ListHubsRequest.newBuilder().setParent(parent).build();
    return listHubs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Hubs in a given project and location.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListHubsPagedResponse listHubs(ListHubsRequest request) {
    return listHubsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Hubs in a given project and location.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListHubsRequest, ListHubsPagedResponse> listHubsPagedCallable() {
    return stub.listHubsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Hubs in a given project and location.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListHubsRequest, ListHubsResponse> listHubsCallable() {
    return stub.listHubsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Hub.
   *
   * @param name Required. Name of the Hub resource to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Hub getHub(HubName name) {
    GetHubRequest request =
        GetHubRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getHub(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Hub.
   *
   * @param name Required. Name of the Hub resource to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Hub getHub(String name) {
    GetHubRequest request = GetHubRequest.newBuilder().setName(name).build();
    return getHub(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Hub.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Hub getHub(GetHubRequest request) {
    return getHubCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Hub.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<GetHubRequest, Hub> getHubCallable() {
    return stub.getHubCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Hub in a given project and location.
   *
   * @param parent Required. The parent resource's name of the Hub.
   * @param hub Required. Initial values for a new Hub.
   * @param hubId Optional. Unique id for the Hub to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Hub, OperationMetadata> createHubAsync(
      LocationName parent, Hub hub, String hubId) {
    CreateHubRequest request =
        CreateHubRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setHub(hub)
            .setHubId(hubId)
            .build();
    return createHubAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Hub in a given project and location.
   *
   * @param parent Required. The parent resource's name of the Hub.
   * @param hub Required. Initial values for a new Hub.
   * @param hubId Optional. Unique id for the Hub to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Hub, OperationMetadata> createHubAsync(
      String parent, Hub hub, String hubId) {
    CreateHubRequest request =
        CreateHubRequest.newBuilder().setParent(parent).setHub(hub).setHubId(hubId).build();
    return createHubAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Hub in a given project and location.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Hub, OperationMetadata> createHubAsync(CreateHubRequest request) {
    return createHubOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Hub in a given project and location.
   *
   * <p>Sample code:
   */
  public final OperationCallable<CreateHubRequest, Hub, OperationMetadata>
      createHubOperationCallable() {
    return stub.createHubOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Hub in a given project and location.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<CreateHubRequest, Operation> createHubCallable() {
    return stub.createHubCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Hub.
   *
   * @param hub Required. The state that the Hub should be in after the update.
   * @param updateMask Optional. Field mask is used to specify the fields to be overwritten in the
   *     Hub resource by the update. The fields specified in the update_mask are relative to the
   *     resource, not the full request. A field will be overwritten if it is in the mask. If the
   *     user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Hub, OperationMetadata> updateHubAsync(
      Hub hub, FieldMask updateMask) {
    UpdateHubRequest request =
        UpdateHubRequest.newBuilder().setHub(hub).setUpdateMask(updateMask).build();
    return updateHubAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Hub.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Hub, OperationMetadata> updateHubAsync(UpdateHubRequest request) {
    return updateHubOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Hub.
   *
   * <p>Sample code:
   */
  public final OperationCallable<UpdateHubRequest, Hub, OperationMetadata>
      updateHubOperationCallable() {
    return stub.updateHubOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Hub.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<UpdateHubRequest, Operation> updateHubCallable() {
    return stub.updateHubCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Hub.
   *
   * @param name Required. The name of the Hub to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteHubAsync(HubName name) {
    DeleteHubRequest request =
        DeleteHubRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteHubAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Hub.
   *
   * @param name Required. The name of the Hub to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteHubAsync(String name) {
    DeleteHubRequest request = DeleteHubRequest.newBuilder().setName(name).build();
    return deleteHubAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Hub.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteHubAsync(DeleteHubRequest request) {
    return deleteHubOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Hub.
   *
   * <p>Sample code:
   */
  public final OperationCallable<DeleteHubRequest, Empty, OperationMetadata>
      deleteHubOperationCallable() {
    return stub.deleteHubOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Hub.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<DeleteHubRequest, Operation> deleteHubCallable() {
    return stub.deleteHubCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Spokes in a given project and location.
   *
   * @param parent Required. The parent's resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSpokesPagedResponse listSpokes(LocationName parent) {
    ListSpokesRequest request =
        ListSpokesRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listSpokes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Spokes in a given project and location.
   *
   * @param parent Required. The parent's resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSpokesPagedResponse listSpokes(String parent) {
    ListSpokesRequest request = ListSpokesRequest.newBuilder().setParent(parent).build();
    return listSpokes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Spokes in a given project and location.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSpokesPagedResponse listSpokes(ListSpokesRequest request) {
    return listSpokesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Spokes in a given project and location.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListSpokesRequest, ListSpokesPagedResponse> listSpokesPagedCallable() {
    return stub.listSpokesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Spokes in a given project and location.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListSpokesRequest, ListSpokesResponse> listSpokesCallable() {
    return stub.listSpokesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Spoke.
   *
   * @param name Required. The name of Spoke resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Spoke getSpoke(SpokeName name) {
    GetSpokeRequest request =
        GetSpokeRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getSpoke(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Spoke.
   *
   * @param name Required. The name of Spoke resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Spoke getSpoke(String name) {
    GetSpokeRequest request = GetSpokeRequest.newBuilder().setName(name).build();
    return getSpoke(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Spoke.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Spoke getSpoke(GetSpokeRequest request) {
    return getSpokeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Spoke.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<GetSpokeRequest, Spoke> getSpokeCallable() {
    return stub.getSpokeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Spoke in a given project and location.
   *
   * @param parent Required. The parent's resource name of the Spoke.
   * @param spoke Required. Initial values for a new Hub.
   * @param spokeId Optional. Unique id for the Spoke to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Spoke, OperationMetadata> createSpokeAsync(
      LocationName parent, Spoke spoke, String spokeId) {
    CreateSpokeRequest request =
        CreateSpokeRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSpoke(spoke)
            .setSpokeId(spokeId)
            .build();
    return createSpokeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Spoke in a given project and location.
   *
   * @param parent Required. The parent's resource name of the Spoke.
   * @param spoke Required. Initial values for a new Hub.
   * @param spokeId Optional. Unique id for the Spoke to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Spoke, OperationMetadata> createSpokeAsync(
      String parent, Spoke spoke, String spokeId) {
    CreateSpokeRequest request =
        CreateSpokeRequest.newBuilder()
            .setParent(parent)
            .setSpoke(spoke)
            .setSpokeId(spokeId)
            .build();
    return createSpokeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Spoke in a given project and location.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Spoke, OperationMetadata> createSpokeAsync(
      CreateSpokeRequest request) {
    return createSpokeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Spoke in a given project and location.
   *
   * <p>Sample code:
   */
  public final OperationCallable<CreateSpokeRequest, Spoke, OperationMetadata>
      createSpokeOperationCallable() {
    return stub.createSpokeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Spoke in a given project and location.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<CreateSpokeRequest, Operation> createSpokeCallable() {
    return stub.createSpokeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Spoke.
   *
   * @param spoke Required. The state that the Spoke should be in after the update.
   * @param updateMask Optional. Field mask is used to specify the fields to be overwritten in the
   *     Spoke resource by the update. The fields specified in the update_mask are relative to the
   *     resource, not the full request. A field will be overwritten if it is in the mask. If the
   *     user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Spoke, OperationMetadata> updateSpokeAsync(
      Spoke spoke, FieldMask updateMask) {
    UpdateSpokeRequest request =
        UpdateSpokeRequest.newBuilder().setSpoke(spoke).setUpdateMask(updateMask).build();
    return updateSpokeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Spoke.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Spoke, OperationMetadata> updateSpokeAsync(
      UpdateSpokeRequest request) {
    return updateSpokeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Spoke.
   *
   * <p>Sample code:
   */
  public final OperationCallable<UpdateSpokeRequest, Spoke, OperationMetadata>
      updateSpokeOperationCallable() {
    return stub.updateSpokeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Spoke.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<UpdateSpokeRequest, Operation> updateSpokeCallable() {
    return stub.updateSpokeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Spoke.
   *
   * @param name Required. The name of the Spoke to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteSpokeAsync(SpokeName name) {
    DeleteSpokeRequest request =
        DeleteSpokeRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteSpokeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Spoke.
   *
   * @param name Required. The name of the Spoke to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteSpokeAsync(String name) {
    DeleteSpokeRequest request = DeleteSpokeRequest.newBuilder().setName(name).build();
    return deleteSpokeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Spoke.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteSpokeAsync(
      DeleteSpokeRequest request) {
    return deleteSpokeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Spoke.
   *
   * <p>Sample code:
   */
  public final OperationCallable<DeleteSpokeRequest, Empty, OperationMetadata>
      deleteSpokeOperationCallable() {
    return stub.deleteSpokeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Spoke.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<DeleteSpokeRequest, Operation> deleteSpokeCallable() {
    return stub.deleteSpokeCallable();
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

  public static class ListHubsPagedResponse
      extends AbstractPagedListResponse<
          ListHubsRequest, ListHubsResponse, Hub, ListHubsPage, ListHubsFixedSizeCollection> {

    public static ApiFuture<ListHubsPagedResponse> createAsync(
        PageContext<ListHubsRequest, ListHubsResponse, Hub> context,
        ApiFuture<ListHubsResponse> futureResponse) {
      ApiFuture<ListHubsPage> futurePage =
          ListHubsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListHubsPage, ListHubsPagedResponse>() {
            @Override
            public ListHubsPagedResponse apply(ListHubsPage input) {
              return new ListHubsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListHubsPagedResponse(ListHubsPage page) {
      super(page, ListHubsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListHubsPage
      extends AbstractPage<ListHubsRequest, ListHubsResponse, Hub, ListHubsPage> {

    private ListHubsPage(
        PageContext<ListHubsRequest, ListHubsResponse, Hub> context, ListHubsResponse response) {
      super(context, response);
    }

    private static ListHubsPage createEmptyPage() {
      return new ListHubsPage(null, null);
    }

    @Override
    protected ListHubsPage createPage(
        PageContext<ListHubsRequest, ListHubsResponse, Hub> context, ListHubsResponse response) {
      return new ListHubsPage(context, response);
    }

    @Override
    public ApiFuture<ListHubsPage> createPageAsync(
        PageContext<ListHubsRequest, ListHubsResponse, Hub> context,
        ApiFuture<ListHubsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListHubsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListHubsRequest, ListHubsResponse, Hub, ListHubsPage, ListHubsFixedSizeCollection> {

    private ListHubsFixedSizeCollection(List<ListHubsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListHubsFixedSizeCollection createEmptyCollection() {
      return new ListHubsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListHubsFixedSizeCollection createCollection(
        List<ListHubsPage> pages, int collectionSize) {
      return new ListHubsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListSpokesPagedResponse
      extends AbstractPagedListResponse<
          ListSpokesRequest,
          ListSpokesResponse,
          Spoke,
          ListSpokesPage,
          ListSpokesFixedSizeCollection> {

    public static ApiFuture<ListSpokesPagedResponse> createAsync(
        PageContext<ListSpokesRequest, ListSpokesResponse, Spoke> context,
        ApiFuture<ListSpokesResponse> futureResponse) {
      ApiFuture<ListSpokesPage> futurePage =
          ListSpokesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListSpokesPage, ListSpokesPagedResponse>() {
            @Override
            public ListSpokesPagedResponse apply(ListSpokesPage input) {
              return new ListSpokesPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListSpokesPagedResponse(ListSpokesPage page) {
      super(page, ListSpokesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSpokesPage
      extends AbstractPage<ListSpokesRequest, ListSpokesResponse, Spoke, ListSpokesPage> {

    private ListSpokesPage(
        PageContext<ListSpokesRequest, ListSpokesResponse, Spoke> context,
        ListSpokesResponse response) {
      super(context, response);
    }

    private static ListSpokesPage createEmptyPage() {
      return new ListSpokesPage(null, null);
    }

    @Override
    protected ListSpokesPage createPage(
        PageContext<ListSpokesRequest, ListSpokesResponse, Spoke> context,
        ListSpokesResponse response) {
      return new ListSpokesPage(context, response);
    }

    @Override
    public ApiFuture<ListSpokesPage> createPageAsync(
        PageContext<ListSpokesRequest, ListSpokesResponse, Spoke> context,
        ApiFuture<ListSpokesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSpokesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSpokesRequest,
          ListSpokesResponse,
          Spoke,
          ListSpokesPage,
          ListSpokesFixedSizeCollection> {

    private ListSpokesFixedSizeCollection(List<ListSpokesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSpokesFixedSizeCollection createEmptyCollection() {
      return new ListSpokesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSpokesFixedSizeCollection createCollection(
        List<ListSpokesPage> pages, int collectionSize) {
      return new ListSpokesFixedSizeCollection(pages, collectionSize);
    }
  }
}
