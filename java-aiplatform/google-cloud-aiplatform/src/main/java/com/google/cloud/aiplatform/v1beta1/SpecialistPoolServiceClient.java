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

package com.google.cloud.aiplatform.v1beta1;

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
import com.google.cloud.aiplatform.v1beta1.stub.SpecialistPoolServiceStub;
import com.google.cloud.aiplatform.v1beta1.stub.SpecialistPoolServiceStubSettings;
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
 * Service Description: A service for creating and managing Customer SpecialistPools. When customers
 * start Data Labeling jobs, they can reuse/create Specialist Pools to bring their own Specialists
 * to label the data. Customers can add/remove Managers for the Specialist Pool on Cloud console,
 * then Managers will get email notifications to manage Specialists and tasks on CrowdCompute
 * console.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <p>Note: close() needs to be called on the SpecialistPoolServiceClient object to clean up
 * resources such as threads. In the example above, try-with-resources is used, which automatically
 * calls close().
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
 * <p>This class can be customized by passing in a custom instance of SpecialistPoolServiceSettings
 * to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * SpecialistPoolServiceSettings specialistPoolServiceSettings =
 *     SpecialistPoolServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * SpecialistPoolServiceClient specialistPoolServiceClient =
 *     SpecialistPoolServiceClient.create(specialistPoolServiceSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * SpecialistPoolServiceSettings specialistPoolServiceSettings =
 *     SpecialistPoolServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * SpecialistPoolServiceClient specialistPoolServiceClient =
 *     SpecialistPoolServiceClient.create(specialistPoolServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator")
public class SpecialistPoolServiceClient implements BackgroundResource {
  private final SpecialistPoolServiceSettings settings;
  private final SpecialistPoolServiceStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of SpecialistPoolServiceClient with default settings. */
  public static final SpecialistPoolServiceClient create() throws IOException {
    return create(SpecialistPoolServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of SpecialistPoolServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final SpecialistPoolServiceClient create(SpecialistPoolServiceSettings settings)
      throws IOException {
    return new SpecialistPoolServiceClient(settings);
  }

  /**
   * Constructs an instance of SpecialistPoolServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(SpecialistPoolServiceSettings).
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final SpecialistPoolServiceClient create(SpecialistPoolServiceStub stub) {
    return new SpecialistPoolServiceClient(stub);
  }

  /**
   * Constructs an instance of SpecialistPoolServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected SpecialistPoolServiceClient(SpecialistPoolServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((SpecialistPoolServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected SpecialistPoolServiceClient(SpecialistPoolServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final SpecialistPoolServiceSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public SpecialistPoolServiceStub getStub() {
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
   * Creates a SpecialistPool.
   *
   * @param parent Required. The parent Project name for the new SpecialistPool. The form is
   *     `projects/{project}/locations/{location}`.
   * @param specialistPool Required. The SpecialistPool to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<SpecialistPool, CreateSpecialistPoolOperationMetadata>
      createSpecialistPoolAsync(LocationName parent, SpecialistPool specialistPool) {
    CreateSpecialistPoolRequest request =
        CreateSpecialistPoolRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSpecialistPool(specialistPool)
            .build();
    return createSpecialistPoolAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a SpecialistPool.
   *
   * @param parent Required. The parent Project name for the new SpecialistPool. The form is
   *     `projects/{project}/locations/{location}`.
   * @param specialistPool Required. The SpecialistPool to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<SpecialistPool, CreateSpecialistPoolOperationMetadata>
      createSpecialistPoolAsync(String parent, SpecialistPool specialistPool) {
    CreateSpecialistPoolRequest request =
        CreateSpecialistPoolRequest.newBuilder()
            .setParent(parent)
            .setSpecialistPool(specialistPool)
            .build();
    return createSpecialistPoolAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a SpecialistPool.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<SpecialistPool, CreateSpecialistPoolOperationMetadata>
      createSpecialistPoolAsync(CreateSpecialistPoolRequest request) {
    return createSpecialistPoolOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a SpecialistPool.
   *
   * <p>Sample code:
   */
  public final OperationCallable<
          CreateSpecialistPoolRequest, SpecialistPool, CreateSpecialistPoolOperationMetadata>
      createSpecialistPoolOperationCallable() {
    return stub.createSpecialistPoolOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a SpecialistPool.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<CreateSpecialistPoolRequest, Operation>
      createSpecialistPoolCallable() {
    return stub.createSpecialistPoolCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a SpecialistPool.
   *
   * @param name Required. The name of the SpecialistPool resource. The form is
   *     <p>`projects/{project}/locations/{location}/specialistPools/{specialist_pool}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SpecialistPool getSpecialistPool(SpecialistPoolName name) {
    GetSpecialistPoolRequest request =
        GetSpecialistPoolRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getSpecialistPool(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a SpecialistPool.
   *
   * @param name Required. The name of the SpecialistPool resource. The form is
   *     <p>`projects/{project}/locations/{location}/specialistPools/{specialist_pool}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SpecialistPool getSpecialistPool(String name) {
    GetSpecialistPoolRequest request = GetSpecialistPoolRequest.newBuilder().setName(name).build();
    return getSpecialistPool(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a SpecialistPool.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SpecialistPool getSpecialistPool(GetSpecialistPoolRequest request) {
    return getSpecialistPoolCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a SpecialistPool.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<GetSpecialistPoolRequest, SpecialistPool> getSpecialistPoolCallable() {
    return stub.getSpecialistPoolCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists SpecialistPools in a Location.
   *
   * @param parent Required. The name of the SpecialistPool's parent resource. Format:
   *     `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSpecialistPoolsPagedResponse listSpecialistPools(LocationName parent) {
    ListSpecialistPoolsRequest request =
        ListSpecialistPoolsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listSpecialistPools(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists SpecialistPools in a Location.
   *
   * @param parent Required. The name of the SpecialistPool's parent resource. Format:
   *     `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSpecialistPoolsPagedResponse listSpecialistPools(String parent) {
    ListSpecialistPoolsRequest request =
        ListSpecialistPoolsRequest.newBuilder().setParent(parent).build();
    return listSpecialistPools(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists SpecialistPools in a Location.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSpecialistPoolsPagedResponse listSpecialistPools(
      ListSpecialistPoolsRequest request) {
    return listSpecialistPoolsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists SpecialistPools in a Location.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListSpecialistPoolsRequest, ListSpecialistPoolsPagedResponse>
      listSpecialistPoolsPagedCallable() {
    return stub.listSpecialistPoolsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists SpecialistPools in a Location.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListSpecialistPoolsRequest, ListSpecialistPoolsResponse>
      listSpecialistPoolsCallable() {
    return stub.listSpecialistPoolsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a SpecialistPool as well as all Specialists in the pool.
   *
   * @param name Required. The resource name of the SpecialistPool to delete. Format:
   *     `projects/{project}/locations/{location}/specialistPools/{specialist_pool}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteSpecialistPoolAsync(
      SpecialistPoolName name) {
    DeleteSpecialistPoolRequest request =
        DeleteSpecialistPoolRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteSpecialistPoolAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a SpecialistPool as well as all Specialists in the pool.
   *
   * @param name Required. The resource name of the SpecialistPool to delete. Format:
   *     `projects/{project}/locations/{location}/specialistPools/{specialist_pool}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteSpecialistPoolAsync(
      String name) {
    DeleteSpecialistPoolRequest request =
        DeleteSpecialistPoolRequest.newBuilder().setName(name).build();
    return deleteSpecialistPoolAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a SpecialistPool as well as all Specialists in the pool.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteSpecialistPoolAsync(
      DeleteSpecialistPoolRequest request) {
    return deleteSpecialistPoolOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a SpecialistPool as well as all Specialists in the pool.
   *
   * <p>Sample code:
   */
  public final OperationCallable<DeleteSpecialistPoolRequest, Empty, DeleteOperationMetadata>
      deleteSpecialistPoolOperationCallable() {
    return stub.deleteSpecialistPoolOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a SpecialistPool as well as all Specialists in the pool.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<DeleteSpecialistPoolRequest, Operation>
      deleteSpecialistPoolCallable() {
    return stub.deleteSpecialistPoolCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a SpecialistPool.
   *
   * @param specialistPool Required. The SpecialistPool which replaces the resource on the server.
   * @param updateMask Required. The update mask applies to the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<SpecialistPool, UpdateSpecialistPoolOperationMetadata>
      updateSpecialistPoolAsync(SpecialistPool specialistPool, FieldMask updateMask) {
    UpdateSpecialistPoolRequest request =
        UpdateSpecialistPoolRequest.newBuilder()
            .setSpecialistPool(specialistPool)
            .setUpdateMask(updateMask)
            .build();
    return updateSpecialistPoolAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a SpecialistPool.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<SpecialistPool, UpdateSpecialistPoolOperationMetadata>
      updateSpecialistPoolAsync(UpdateSpecialistPoolRequest request) {
    return updateSpecialistPoolOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a SpecialistPool.
   *
   * <p>Sample code:
   */
  public final OperationCallable<
          UpdateSpecialistPoolRequest, SpecialistPool, UpdateSpecialistPoolOperationMetadata>
      updateSpecialistPoolOperationCallable() {
    return stub.updateSpecialistPoolOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a SpecialistPool.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<UpdateSpecialistPoolRequest, Operation>
      updateSpecialistPoolCallable() {
    return stub.updateSpecialistPoolCallable();
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

  public static class ListSpecialistPoolsPagedResponse
      extends AbstractPagedListResponse<
          ListSpecialistPoolsRequest,
          ListSpecialistPoolsResponse,
          SpecialistPool,
          ListSpecialistPoolsPage,
          ListSpecialistPoolsFixedSizeCollection> {

    public static ApiFuture<ListSpecialistPoolsPagedResponse> createAsync(
        PageContext<ListSpecialistPoolsRequest, ListSpecialistPoolsResponse, SpecialistPool>
            context,
        ApiFuture<ListSpecialistPoolsResponse> futureResponse) {
      ApiFuture<ListSpecialistPoolsPage> futurePage =
          ListSpecialistPoolsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListSpecialistPoolsPage, ListSpecialistPoolsPagedResponse>() {
            @Override
            public ListSpecialistPoolsPagedResponse apply(ListSpecialistPoolsPage input) {
              return new ListSpecialistPoolsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListSpecialistPoolsPagedResponse(ListSpecialistPoolsPage page) {
      super(page, ListSpecialistPoolsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSpecialistPoolsPage
      extends AbstractPage<
          ListSpecialistPoolsRequest,
          ListSpecialistPoolsResponse,
          SpecialistPool,
          ListSpecialistPoolsPage> {

    private ListSpecialistPoolsPage(
        PageContext<ListSpecialistPoolsRequest, ListSpecialistPoolsResponse, SpecialistPool>
            context,
        ListSpecialistPoolsResponse response) {
      super(context, response);
    }

    private static ListSpecialistPoolsPage createEmptyPage() {
      return new ListSpecialistPoolsPage(null, null);
    }

    @Override
    protected ListSpecialistPoolsPage createPage(
        PageContext<ListSpecialistPoolsRequest, ListSpecialistPoolsResponse, SpecialistPool>
            context,
        ListSpecialistPoolsResponse response) {
      return new ListSpecialistPoolsPage(context, response);
    }

    @Override
    public ApiFuture<ListSpecialistPoolsPage> createPageAsync(
        PageContext<ListSpecialistPoolsRequest, ListSpecialistPoolsResponse, SpecialistPool>
            context,
        ApiFuture<ListSpecialistPoolsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSpecialistPoolsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSpecialistPoolsRequest,
          ListSpecialistPoolsResponse,
          SpecialistPool,
          ListSpecialistPoolsPage,
          ListSpecialistPoolsFixedSizeCollection> {

    private ListSpecialistPoolsFixedSizeCollection(
        List<ListSpecialistPoolsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSpecialistPoolsFixedSizeCollection createEmptyCollection() {
      return new ListSpecialistPoolsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSpecialistPoolsFixedSizeCollection createCollection(
        List<ListSpecialistPoolsPage> pages, int collectionSize) {
      return new ListSpecialistPoolsFixedSizeCollection(pages, collectionSize);
    }
  }
}
