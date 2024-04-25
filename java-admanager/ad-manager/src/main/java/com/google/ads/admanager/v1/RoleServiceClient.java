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

package com.google.ads.admanager.v1;

import com.google.ads.admanager.v1.stub.RoleServiceStub;
import com.google.ads.admanager.v1.stub.RoleServiceStubSettings;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Provides methods for handling Role objects.
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
 * try (RoleServiceClient roleServiceClient = RoleServiceClient.create()) {
 *   RoleName name = RoleName.of("[NETWORK_CODE]", "[ROLE]");
 *   Role response = roleServiceClient.getRole(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the RoleServiceClient object to clean up resources such as
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
 *      <td><p> GetRole</td>
 *      <td><p> API to retrieve a Role object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getRole(GetRoleRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getRole(RoleName name)
 *           <li><p> getRole(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getRoleCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListRoles</td>
 *      <td><p> API to retrieve a list of Role objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listRoles(ListRolesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listRoles(NetworkName parent)
 *           <li><p> listRoles(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listRolesPagedCallable()
 *           <li><p> listRolesCallable()
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
 * <p>This class can be customized by passing in a custom instance of RoleServiceSettings to
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
 * RoleServiceSettings roleServiceSettings =
 *     RoleServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * RoleServiceClient roleServiceClient = RoleServiceClient.create(roleServiceSettings);
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
 * RoleServiceSettings roleServiceSettings =
 *     RoleServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * RoleServiceClient roleServiceClient = RoleServiceClient.create(roleServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class RoleServiceClient implements BackgroundResource {
  private final RoleServiceSettings settings;
  private final RoleServiceStub stub;

  /** Constructs an instance of RoleServiceClient with default settings. */
  public static final RoleServiceClient create() throws IOException {
    return create(RoleServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of RoleServiceClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final RoleServiceClient create(RoleServiceSettings settings) throws IOException {
    return new RoleServiceClient(settings);
  }

  /**
   * Constructs an instance of RoleServiceClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(RoleServiceSettings).
   */
  public static final RoleServiceClient create(RoleServiceStub stub) {
    return new RoleServiceClient(stub);
  }

  /**
   * Constructs an instance of RoleServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected RoleServiceClient(RoleServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((RoleServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected RoleServiceClient(RoleServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final RoleServiceSettings getSettings() {
    return settings;
  }

  public RoleServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a Role object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RoleServiceClient roleServiceClient = RoleServiceClient.create()) {
   *   RoleName name = RoleName.of("[NETWORK_CODE]", "[ROLE]");
   *   Role response = roleServiceClient.getRole(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Role. Format:
   *     `networks/{network_code}/roles/{role_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Role getRole(RoleName name) {
    GetRoleRequest request =
        GetRoleRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getRole(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a Role object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RoleServiceClient roleServiceClient = RoleServiceClient.create()) {
   *   String name = RoleName.of("[NETWORK_CODE]", "[ROLE]").toString();
   *   Role response = roleServiceClient.getRole(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Role. Format:
   *     `networks/{network_code}/roles/{role_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Role getRole(String name) {
    GetRoleRequest request = GetRoleRequest.newBuilder().setName(name).build();
    return getRole(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a Role object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RoleServiceClient roleServiceClient = RoleServiceClient.create()) {
   *   GetRoleRequest request =
   *       GetRoleRequest.newBuilder()
   *           .setName(RoleName.of("[NETWORK_CODE]", "[ROLE]").toString())
   *           .build();
   *   Role response = roleServiceClient.getRole(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Role getRole(GetRoleRequest request) {
    return getRoleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a Role object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RoleServiceClient roleServiceClient = RoleServiceClient.create()) {
   *   GetRoleRequest request =
   *       GetRoleRequest.newBuilder()
   *           .setName(RoleName.of("[NETWORK_CODE]", "[ROLE]").toString())
   *           .build();
   *   ApiFuture<Role> future = roleServiceClient.getRoleCallable().futureCall(request);
   *   // Do something.
   *   Role response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRoleRequest, Role> getRoleCallable() {
    return stub.getRoleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of Role objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RoleServiceClient roleServiceClient = RoleServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (Role element : roleServiceClient.listRoles(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of Roles. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRolesPagedResponse listRoles(NetworkName parent) {
    ListRolesRequest request =
        ListRolesRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listRoles(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of Role objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RoleServiceClient roleServiceClient = RoleServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (Role element : roleServiceClient.listRoles(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of Roles. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRolesPagedResponse listRoles(String parent) {
    ListRolesRequest request = ListRolesRequest.newBuilder().setParent(parent).build();
    return listRoles(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of Role objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RoleServiceClient roleServiceClient = RoleServiceClient.create()) {
   *   ListRolesRequest request =
   *       ListRolesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (Role element : roleServiceClient.listRoles(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRolesPagedResponse listRoles(ListRolesRequest request) {
    return listRolesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of Role objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RoleServiceClient roleServiceClient = RoleServiceClient.create()) {
   *   ListRolesRequest request =
   *       ListRolesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<Role> future = roleServiceClient.listRolesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Role element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListRolesRequest, ListRolesPagedResponse> listRolesPagedCallable() {
    return stub.listRolesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of Role objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RoleServiceClient roleServiceClient = RoleServiceClient.create()) {
   *   ListRolesRequest request =
   *       ListRolesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListRolesResponse response = roleServiceClient.listRolesCallable().call(request);
   *     for (Role element : response.getRolesList()) {
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
  public final UnaryCallable<ListRolesRequest, ListRolesResponse> listRolesCallable() {
    return stub.listRolesCallable();
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

  public static class ListRolesPagedResponse
      extends AbstractPagedListResponse<
          ListRolesRequest, ListRolesResponse, Role, ListRolesPage, ListRolesFixedSizeCollection> {

    public static ApiFuture<ListRolesPagedResponse> createAsync(
        PageContext<ListRolesRequest, ListRolesResponse, Role> context,
        ApiFuture<ListRolesResponse> futureResponse) {
      ApiFuture<ListRolesPage> futurePage =
          ListRolesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListRolesPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListRolesPagedResponse(ListRolesPage page) {
      super(page, ListRolesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListRolesPage
      extends AbstractPage<ListRolesRequest, ListRolesResponse, Role, ListRolesPage> {

    private ListRolesPage(
        PageContext<ListRolesRequest, ListRolesResponse, Role> context,
        ListRolesResponse response) {
      super(context, response);
    }

    private static ListRolesPage createEmptyPage() {
      return new ListRolesPage(null, null);
    }

    @Override
    protected ListRolesPage createPage(
        PageContext<ListRolesRequest, ListRolesResponse, Role> context,
        ListRolesResponse response) {
      return new ListRolesPage(context, response);
    }

    @Override
    public ApiFuture<ListRolesPage> createPageAsync(
        PageContext<ListRolesRequest, ListRolesResponse, Role> context,
        ApiFuture<ListRolesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListRolesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRolesRequest, ListRolesResponse, Role, ListRolesPage, ListRolesFixedSizeCollection> {

    private ListRolesFixedSizeCollection(List<ListRolesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListRolesFixedSizeCollection createEmptyCollection() {
      return new ListRolesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListRolesFixedSizeCollection createCollection(
        List<ListRolesPage> pages, int collectionSize) {
      return new ListRolesFixedSizeCollection(pages, collectionSize);
    }
  }
}
