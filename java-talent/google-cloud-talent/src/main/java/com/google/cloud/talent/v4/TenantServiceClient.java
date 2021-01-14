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

package com.google.cloud.talent.v4;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.talent.v4.stub.TenantServiceStub;
import com.google.cloud.talent.v4.stub.TenantServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: A service that handles tenant management, including CRUD and enumeration.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <p>Note: close() needs to be called on the TenantServiceClient object to clean up resources such
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
 * <p>This class can be customized by passing in a custom instance of TenantServiceSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * TenantServiceSettings tenantServiceSettings =
 *     TenantServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * TenantServiceClient tenantServiceClient = TenantServiceClient.create(tenantServiceSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * TenantServiceSettings tenantServiceSettings =
 *     TenantServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * TenantServiceClient tenantServiceClient = TenantServiceClient.create(tenantServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class TenantServiceClient implements BackgroundResource {
  private final TenantServiceSettings settings;
  private final TenantServiceStub stub;

  /** Constructs an instance of TenantServiceClient with default settings. */
  public static final TenantServiceClient create() throws IOException {
    return create(TenantServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of TenantServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final TenantServiceClient create(TenantServiceSettings settings)
      throws IOException {
    return new TenantServiceClient(settings);
  }

  /**
   * Constructs an instance of TenantServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(TenantServiceSettings).
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final TenantServiceClient create(TenantServiceStub stub) {
    return new TenantServiceClient(stub);
  }

  /**
   * Constructs an instance of TenantServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected TenantServiceClient(TenantServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((TenantServiceStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected TenantServiceClient(TenantServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final TenantServiceSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public TenantServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new tenant entity.
   *
   * @param parent Required. Resource name of the project under which the tenant is created.
   *     <p>The format is "projects/{project_id}", for example, "projects/foo".
   * @param tenant Required. The tenant to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Tenant createTenant(ProjectName parent, Tenant tenant) {
    CreateTenantRequest request =
        CreateTenantRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setTenant(tenant)
            .build();
    return createTenant(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new tenant entity.
   *
   * @param parent Required. Resource name of the project under which the tenant is created.
   *     <p>The format is "projects/{project_id}", for example, "projects/foo".
   * @param tenant Required. The tenant to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Tenant createTenant(String parent, Tenant tenant) {
    CreateTenantRequest request =
        CreateTenantRequest.newBuilder().setParent(parent).setTenant(tenant).build();
    return createTenant(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new tenant entity.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Tenant createTenant(CreateTenantRequest request) {
    return createTenantCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new tenant entity.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<CreateTenantRequest, Tenant> createTenantCallable() {
    return stub.createTenantCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves specified tenant.
   *
   * @param name Required. The resource name of the tenant to be retrieved.
   *     <p>The format is "projects/{project_id}/tenants/{tenant_id}", for example,
   *     "projects/foo/tenants/bar".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Tenant getTenant(TenantName name) {
    GetTenantRequest request =
        GetTenantRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getTenant(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves specified tenant.
   *
   * @param name Required. The resource name of the tenant to be retrieved.
   *     <p>The format is "projects/{project_id}/tenants/{tenant_id}", for example,
   *     "projects/foo/tenants/bar".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Tenant getTenant(String name) {
    GetTenantRequest request = GetTenantRequest.newBuilder().setName(name).build();
    return getTenant(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves specified tenant.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Tenant getTenant(GetTenantRequest request) {
    return getTenantCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves specified tenant.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<GetTenantRequest, Tenant> getTenantCallable() {
    return stub.getTenantCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates specified tenant.
   *
   * @param tenant Required. The tenant resource to replace the current resource in the system.
   * @param updateMask Strongly recommended for the best service experience.
   *     <p>If [update_mask][google.cloud.talent.v4.UpdateTenantRequest.update_mask] is provided,
   *     only the specified fields in [tenant][google.cloud.talent.v4.UpdateTenantRequest.tenant]
   *     are updated. Otherwise all the fields are updated.
   *     <p>A field mask to specify the tenant fields to be updated. Only top level fields of
   *     [Tenant][google.cloud.talent.v4.Tenant] are supported.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Tenant updateTenant(Tenant tenant, FieldMask updateMask) {
    UpdateTenantRequest request =
        UpdateTenantRequest.newBuilder().setTenant(tenant).setUpdateMask(updateMask).build();
    return updateTenant(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates specified tenant.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Tenant updateTenant(UpdateTenantRequest request) {
    return updateTenantCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates specified tenant.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<UpdateTenantRequest, Tenant> updateTenantCallable() {
    return stub.updateTenantCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes specified tenant.
   *
   * @param name Required. The resource name of the tenant to be deleted.
   *     <p>The format is "projects/{project_id}/tenants/{tenant_id}", for example,
   *     "projects/foo/tenants/bar".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTenant(TenantName name) {
    DeleteTenantRequest request =
        DeleteTenantRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteTenant(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes specified tenant.
   *
   * @param name Required. The resource name of the tenant to be deleted.
   *     <p>The format is "projects/{project_id}/tenants/{tenant_id}", for example,
   *     "projects/foo/tenants/bar".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTenant(String name) {
    DeleteTenantRequest request = DeleteTenantRequest.newBuilder().setName(name).build();
    deleteTenant(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes specified tenant.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTenant(DeleteTenantRequest request) {
    deleteTenantCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes specified tenant.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<DeleteTenantRequest, Empty> deleteTenantCallable() {
    return stub.deleteTenantCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all tenants associated with the project.
   *
   * @param parent Required. Resource name of the project under which the tenant is created.
   *     <p>The format is "projects/{project_id}", for example, "projects/foo".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTenantsPagedResponse listTenants(ProjectName parent) {
    ListTenantsRequest request =
        ListTenantsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listTenants(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all tenants associated with the project.
   *
   * @param parent Required. Resource name of the project under which the tenant is created.
   *     <p>The format is "projects/{project_id}", for example, "projects/foo".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTenantsPagedResponse listTenants(String parent) {
    ListTenantsRequest request = ListTenantsRequest.newBuilder().setParent(parent).build();
    return listTenants(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all tenants associated with the project.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTenantsPagedResponse listTenants(ListTenantsRequest request) {
    return listTenantsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all tenants associated with the project.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListTenantsRequest, ListTenantsPagedResponse>
      listTenantsPagedCallable() {
    return stub.listTenantsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all tenants associated with the project.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListTenantsRequest, ListTenantsResponse> listTenantsCallable() {
    return stub.listTenantsCallable();
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

  public static class ListTenantsPagedResponse
      extends AbstractPagedListResponse<
          ListTenantsRequest,
          ListTenantsResponse,
          Tenant,
          ListTenantsPage,
          ListTenantsFixedSizeCollection> {

    public static ApiFuture<ListTenantsPagedResponse> createAsync(
        PageContext<ListTenantsRequest, ListTenantsResponse, Tenant> context,
        ApiFuture<ListTenantsResponse> futureResponse) {
      ApiFuture<ListTenantsPage> futurePage =
          ListTenantsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListTenantsPage, ListTenantsPagedResponse>() {
            @Override
            public ListTenantsPagedResponse apply(ListTenantsPage input) {
              return new ListTenantsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListTenantsPagedResponse(ListTenantsPage page) {
      super(page, ListTenantsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListTenantsPage
      extends AbstractPage<ListTenantsRequest, ListTenantsResponse, Tenant, ListTenantsPage> {

    private ListTenantsPage(
        PageContext<ListTenantsRequest, ListTenantsResponse, Tenant> context,
        ListTenantsResponse response) {
      super(context, response);
    }

    private static ListTenantsPage createEmptyPage() {
      return new ListTenantsPage(null, null);
    }

    @Override
    protected ListTenantsPage createPage(
        PageContext<ListTenantsRequest, ListTenantsResponse, Tenant> context,
        ListTenantsResponse response) {
      return new ListTenantsPage(context, response);
    }

    @Override
    public ApiFuture<ListTenantsPage> createPageAsync(
        PageContext<ListTenantsRequest, ListTenantsResponse, Tenant> context,
        ApiFuture<ListTenantsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListTenantsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTenantsRequest,
          ListTenantsResponse,
          Tenant,
          ListTenantsPage,
          ListTenantsFixedSizeCollection> {

    private ListTenantsFixedSizeCollection(List<ListTenantsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTenantsFixedSizeCollection createEmptyCollection() {
      return new ListTenantsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTenantsFixedSizeCollection createCollection(
        List<ListTenantsPage> pages, int collectionSize) {
      return new ListTenantsFixedSizeCollection(pages, collectionSize);
    }
  }
}
