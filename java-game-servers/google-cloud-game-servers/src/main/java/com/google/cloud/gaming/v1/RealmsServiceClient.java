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

package com.google.cloud.gaming.v1;

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
import com.google.cloud.gaming.v1.stub.RealmsServiceStub;
import com.google.cloud.gaming.v1.stub.RealmsServiceStubSettings;
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
 * Service Description: A realm is a grouping of game server clusters that are considered
 * interchangeable.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <p>Note: close() needs to be called on the RealmsServiceClient object to clean up resources such
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
 * <p>This class can be customized by passing in a custom instance of RealmsServiceSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * RealmsServiceSettings realmsServiceSettings =
 *     RealmsServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * RealmsServiceClient realmsServiceClient = RealmsServiceClient.create(realmsServiceSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * RealmsServiceSettings realmsServiceSettings =
 *     RealmsServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * RealmsServiceClient realmsServiceClient = RealmsServiceClient.create(realmsServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class RealmsServiceClient implements BackgroundResource {
  private final RealmsServiceSettings settings;
  private final RealmsServiceStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of RealmsServiceClient with default settings. */
  public static final RealmsServiceClient create() throws IOException {
    return create(RealmsServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of RealmsServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final RealmsServiceClient create(RealmsServiceSettings settings)
      throws IOException {
    return new RealmsServiceClient(settings);
  }

  /**
   * Constructs an instance of RealmsServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(RealmsServiceSettings).
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final RealmsServiceClient create(RealmsServiceStub stub) {
    return new RealmsServiceClient(stub);
  }

  /**
   * Constructs an instance of RealmsServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected RealmsServiceClient(RealmsServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((RealmsServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected RealmsServiceClient(RealmsServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final RealmsServiceSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public RealmsServiceStub getStub() {
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
   * Lists realms in a given project and location.
   *
   * @param parent Required. The parent resource name. Uses the form:
   *     `projects/{project}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRealmsPagedResponse listRealms(LocationName parent) {
    ListRealmsRequest request =
        ListRealmsRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listRealms(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists realms in a given project and location.
   *
   * @param parent Required. The parent resource name. Uses the form:
   *     `projects/{project}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRealmsPagedResponse listRealms(String parent) {
    ListRealmsRequest request = ListRealmsRequest.newBuilder().setParent(parent).build();
    return listRealms(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists realms in a given project and location.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRealmsPagedResponse listRealms(ListRealmsRequest request) {
    return listRealmsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists realms in a given project and location.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListRealmsRequest, ListRealmsPagedResponse> listRealmsPagedCallable() {
    return stub.listRealmsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists realms in a given project and location.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListRealmsRequest, ListRealmsResponse> listRealmsCallable() {
    return stub.listRealmsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single realm.
   *
   * @param name Required. The name of the realm to retrieve. Uses the form:
   *     `projects/{project}/locations/{location}/realms/{realm}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Realm getRealm(RealmName name) {
    GetRealmRequest request =
        GetRealmRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getRealm(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single realm.
   *
   * @param name Required. The name of the realm to retrieve. Uses the form:
   *     `projects/{project}/locations/{location}/realms/{realm}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Realm getRealm(String name) {
    GetRealmRequest request = GetRealmRequest.newBuilder().setName(name).build();
    return getRealm(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single realm.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Realm getRealm(GetRealmRequest request) {
    return getRealmCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single realm.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<GetRealmRequest, Realm> getRealmCallable() {
    return stub.getRealmCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new realm in a given project and location.
   *
   * @param parent Required. The parent resource name. Uses the form:
   *     `projects/{project}/locations/{location}`.
   * @param realm Required. The realm resource to be created.
   * @param realmId Required. The ID of the realm resource to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Realm, OperationMetadata> createRealmAsync(
      LocationName parent, Realm realm, String realmId) {
    CreateRealmRequest request =
        CreateRealmRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setRealm(realm)
            .setRealmId(realmId)
            .build();
    return createRealmAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new realm in a given project and location.
   *
   * @param parent Required. The parent resource name. Uses the form:
   *     `projects/{project}/locations/{location}`.
   * @param realm Required. The realm resource to be created.
   * @param realmId Required. The ID of the realm resource to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Realm, OperationMetadata> createRealmAsync(
      String parent, Realm realm, String realmId) {
    CreateRealmRequest request =
        CreateRealmRequest.newBuilder()
            .setParent(parent)
            .setRealm(realm)
            .setRealmId(realmId)
            .build();
    return createRealmAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new realm in a given project and location.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Realm, OperationMetadata> createRealmAsync(
      CreateRealmRequest request) {
    return createRealmOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new realm in a given project and location.
   *
   * <p>Sample code:
   */
  public final OperationCallable<CreateRealmRequest, Realm, OperationMetadata>
      createRealmOperationCallable() {
    return stub.createRealmOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new realm in a given project and location.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<CreateRealmRequest, Operation> createRealmCallable() {
    return stub.createRealmCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single realm.
   *
   * @param name Required. The name of the realm to delete. Uses the form:
   *     `projects/{project}/locations/{location}/realms/{realm}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteRealmAsync(RealmName name) {
    DeleteRealmRequest request =
        DeleteRealmRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteRealmAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single realm.
   *
   * @param name Required. The name of the realm to delete. Uses the form:
   *     `projects/{project}/locations/{location}/realms/{realm}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteRealmAsync(String name) {
    DeleteRealmRequest request = DeleteRealmRequest.newBuilder().setName(name).build();
    return deleteRealmAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single realm.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteRealmAsync(
      DeleteRealmRequest request) {
    return deleteRealmOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single realm.
   *
   * <p>Sample code:
   */
  public final OperationCallable<DeleteRealmRequest, Empty, OperationMetadata>
      deleteRealmOperationCallable() {
    return stub.deleteRealmOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single realm.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<DeleteRealmRequest, Operation> deleteRealmCallable() {
    return stub.deleteRealmCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches a single realm.
   *
   * @param realm Required. The realm to be updated. Only fields specified in update_mask are
   *     updated.
   * @param updateMask Required. The update mask applies to the resource. For the `FieldMask`
   *     definition, see
   *     <p>https: //developers.google.com/protocol-buffers //
   *     /docs/reference/google.protobuf#fieldmask
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Realm, OperationMetadata> updateRealmAsync(
      Realm realm, FieldMask updateMask) {
    UpdateRealmRequest request =
        UpdateRealmRequest.newBuilder().setRealm(realm).setUpdateMask(updateMask).build();
    return updateRealmAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches a single realm.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Realm, OperationMetadata> updateRealmAsync(
      UpdateRealmRequest request) {
    return updateRealmOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches a single realm.
   *
   * <p>Sample code:
   */
  public final OperationCallable<UpdateRealmRequest, Realm, OperationMetadata>
      updateRealmOperationCallable() {
    return stub.updateRealmOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches a single realm.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<UpdateRealmRequest, Operation> updateRealmCallable() {
    return stub.updateRealmCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Previews patches to a single realm.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PreviewRealmUpdateResponse previewRealmUpdate(PreviewRealmUpdateRequest request) {
    return previewRealmUpdateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Previews patches to a single realm.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<PreviewRealmUpdateRequest, PreviewRealmUpdateResponse>
      previewRealmUpdateCallable() {
    return stub.previewRealmUpdateCallable();
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

  public static class ListRealmsPagedResponse
      extends AbstractPagedListResponse<
          ListRealmsRequest,
          ListRealmsResponse,
          Realm,
          ListRealmsPage,
          ListRealmsFixedSizeCollection> {

    public static ApiFuture<ListRealmsPagedResponse> createAsync(
        PageContext<ListRealmsRequest, ListRealmsResponse, Realm> context,
        ApiFuture<ListRealmsResponse> futureResponse) {
      ApiFuture<ListRealmsPage> futurePage =
          ListRealmsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListRealmsPage, ListRealmsPagedResponse>() {
            @Override
            public ListRealmsPagedResponse apply(ListRealmsPage input) {
              return new ListRealmsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListRealmsPagedResponse(ListRealmsPage page) {
      super(page, ListRealmsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListRealmsPage
      extends AbstractPage<ListRealmsRequest, ListRealmsResponse, Realm, ListRealmsPage> {

    private ListRealmsPage(
        PageContext<ListRealmsRequest, ListRealmsResponse, Realm> context,
        ListRealmsResponse response) {
      super(context, response);
    }

    private static ListRealmsPage createEmptyPage() {
      return new ListRealmsPage(null, null);
    }

    @Override
    protected ListRealmsPage createPage(
        PageContext<ListRealmsRequest, ListRealmsResponse, Realm> context,
        ListRealmsResponse response) {
      return new ListRealmsPage(context, response);
    }

    @Override
    public ApiFuture<ListRealmsPage> createPageAsync(
        PageContext<ListRealmsRequest, ListRealmsResponse, Realm> context,
        ApiFuture<ListRealmsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListRealmsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRealmsRequest,
          ListRealmsResponse,
          Realm,
          ListRealmsPage,
          ListRealmsFixedSizeCollection> {

    private ListRealmsFixedSizeCollection(List<ListRealmsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListRealmsFixedSizeCollection createEmptyCollection() {
      return new ListRealmsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListRealmsFixedSizeCollection createCollection(
        List<ListRealmsPage> pages, int collectionSize) {
      return new ListRealmsFixedSizeCollection(pages, collectionSize);
    }
  }
}
