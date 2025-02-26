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

package com.google.cloud.compute.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.stub.RoutersStub;
import com.google.cloud.compute.v1.stub.RoutersStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The Routers API.
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
 * try (RoutersClient routersClient = RoutersClient.create()) {
 *   String project = "project-309310695";
 *   String region = "region-934795532";
 *   String router = "router-925132983";
 *   Router response = routersClient.get(project, region, router);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the RoutersClient object to clean up resources such as
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
 *      <td><p> AggregatedList</td>
 *      <td><p> Retrieves an aggregated list of routers. To prevent failure, Google recommends that you set the `returnPartialSuccess` parameter to `true`.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> aggregatedList(AggregatedListRoutersRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> aggregatedList(String project)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> aggregatedListPagedCallable()
 *           <li><p> aggregatedListCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Delete</td>
 *      <td><p> Deletes the specified Router resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteAsync(DeleteRouterRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteAsync(String project, String region, String router)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteOperationCallable()
 *           <li><p> deleteCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteRoutePolicy</td>
 *      <td><p> Deletes Route Policy</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteRoutePolicyAsync(DeleteRoutePolicyRouterRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteRoutePolicyAsync(String project, String region, String router)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteRoutePolicyOperationCallable()
 *           <li><p> deleteRoutePolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Get</td>
 *      <td><p> Returns the specified Router resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> get(GetRouterRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> get(String project, String region, String router)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetNatIpInfo</td>
 *      <td><p> Retrieves runtime NAT IP information.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getNatIpInfo(GetNatIpInfoRouterRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getNatIpInfo(String project, String region, String router)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getNatIpInfoCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetNatMappingInfo</td>
 *      <td><p> Retrieves runtime Nat mapping information of VM endpoints.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getNatMappingInfo(GetNatMappingInfoRoutersRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getNatMappingInfo(String project, String region, String router)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getNatMappingInfoPagedCallable()
 *           <li><p> getNatMappingInfoCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetRoutePolicy</td>
 *      <td><p> Returns specified Route Policy</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getRoutePolicy(GetRoutePolicyRouterRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getRoutePolicy(String project, String region, String router)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getRoutePolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetRouterStatus</td>
 *      <td><p> Retrieves runtime information of the specified router.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getRouterStatus(GetRouterStatusRouterRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getRouterStatus(String project, String region, String router)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getRouterStatusCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Insert</td>
 *      <td><p> Creates a Router resource in the specified project and region using the data included in the request.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> insertAsync(InsertRouterRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> insertAsync(String project, String region, Router routerResource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> insertOperationCallable()
 *           <li><p> insertCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> List</td>
 *      <td><p> Retrieves a list of Router resources available to the specified project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> list(ListRoutersRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> list(String project, String region)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listPagedCallable()
 *           <li><p> listCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListBgpRoutes</td>
 *      <td><p> Retrieves a list of router bgp routes available to the specified project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listBgpRoutes(ListBgpRoutesRoutersRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listBgpRoutes(String project, String region, String router)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listBgpRoutesPagedCallable()
 *           <li><p> listBgpRoutesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListRoutePolicies</td>
 *      <td><p> Retrieves a list of router route policy subresources available to the specified project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listRoutePolicies(ListRoutePoliciesRoutersRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listRoutePolicies(String project, String region, String router)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listRoutePoliciesPagedCallable()
 *           <li><p> listRoutePoliciesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Patch</td>
 *      <td><p> Patches the specified Router resource with the data included in the request. This method supports PATCH semantics and uses JSON merge patch format and processing rules.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> patchAsync(PatchRouterRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> patchAsync(String project, String region, String router, Router routerResource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> patchOperationCallable()
 *           <li><p> patchCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> PatchRoutePolicy</td>
 *      <td><p> Patches Route Policy</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> patchRoutePolicyAsync(PatchRoutePolicyRouterRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> patchRoutePolicyAsync(String project, String region, String router, RoutePolicy routePolicyResource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> patchRoutePolicyOperationCallable()
 *           <li><p> patchRoutePolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Preview</td>
 *      <td><p> Preview fields auto-generated during router create and update operations. Calling this method does NOT create or update the router.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> preview(PreviewRouterRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> preview(String project, String region, String router, Router routerResource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> previewCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Update</td>
 *      <td><p> Updates the specified Router resource with the data included in the request. This method conforms to PUT semantics, which requests that the state of the target resource be created or replaced with the state defined by the representation enclosed in the request message payload.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateAsync(UpdateRouterRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateAsync(String project, String region, String router, Router routerResource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateOperationCallable()
 *           <li><p> updateCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateRoutePolicy</td>
 *      <td><p> Updates or creates new Route Policy</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateRoutePolicyAsync(UpdateRoutePolicyRouterRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateRoutePolicyAsync(String project, String region, String router, RoutePolicy routePolicyResource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateRoutePolicyOperationCallable()
 *           <li><p> updateRoutePolicyCallable()
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
 * <p>This class can be customized by passing in a custom instance of RoutersSettings to create().
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
 * RoutersSettings routersSettings =
 *     RoutersSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * RoutersClient routersClient = RoutersClient.create(routersSettings);
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
 * RoutersSettings routersSettings = RoutersSettings.newBuilder().setEndpoint(myEndpoint).build();
 * RoutersClient routersClient = RoutersClient.create(routersSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class RoutersClient implements BackgroundResource {
  private final RoutersSettings settings;
  private final RoutersStub stub;

  /** Constructs an instance of RoutersClient with default settings. */
  public static final RoutersClient create() throws IOException {
    return create(RoutersSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of RoutersClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final RoutersClient create(RoutersSettings settings) throws IOException {
    return new RoutersClient(settings);
  }

  /**
   * Constructs an instance of RoutersClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(RoutersSettings).
   */
  public static final RoutersClient create(RoutersStub stub) {
    return new RoutersClient(stub);
  }

  /**
   * Constructs an instance of RoutersClient, using the given settings. This is protected so that it
   * is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected RoutersClient(RoutersSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((RoutersStubSettings) settings.getStubSettings()).createStub();
  }

  protected RoutersClient(RoutersStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final RoutersSettings getSettings() {
    return settings;
  }

  public RoutersStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an aggregated list of routers. To prevent failure, Google recommends that you set the
   * `returnPartialSuccess` parameter to `true`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RoutersClient routersClient = RoutersClient.create()) {
   *   String project = "project-309310695";
   *   for (Map.Entry<String, RoutersScopedList> element :
   *       routersClient.aggregatedList(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(String project) {
    AggregatedListRoutersRequest request =
        AggregatedListRoutersRequest.newBuilder().setProject(project).build();
    return aggregatedList(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an aggregated list of routers. To prevent failure, Google recommends that you set the
   * `returnPartialSuccess` parameter to `true`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RoutersClient routersClient = RoutersClient.create()) {
   *   AggregatedListRoutersRequest request =
   *       AggregatedListRoutersRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setIncludeAllScopes(true)
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .setServiceProjectNumber(-1293855239)
   *           .build();
   *   for (Map.Entry<String, RoutersScopedList> element :
   *       routersClient.aggregatedList(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(AggregatedListRoutersRequest request) {
    return aggregatedListPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an aggregated list of routers. To prevent failure, Google recommends that you set the
   * `returnPartialSuccess` parameter to `true`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RoutersClient routersClient = RoutersClient.create()) {
   *   AggregatedListRoutersRequest request =
   *       AggregatedListRoutersRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setIncludeAllScopes(true)
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .setServiceProjectNumber(-1293855239)
   *           .build();
   *   ApiFuture<Map.Entry<String, RoutersScopedList>> future =
   *       routersClient.aggregatedListPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Map.Entry<String, RoutersScopedList> element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<AggregatedListRoutersRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return stub.aggregatedListPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an aggregated list of routers. To prevent failure, Google recommends that you set the
   * `returnPartialSuccess` parameter to `true`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RoutersClient routersClient = RoutersClient.create()) {
   *   AggregatedListRoutersRequest request =
   *       AggregatedListRoutersRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setIncludeAllScopes(true)
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .setServiceProjectNumber(-1293855239)
   *           .build();
   *   while (true) {
   *     RouterAggregatedList response = routersClient.aggregatedListCallable().call(request);
   *     for (Map.Entry<String, RoutersScopedList> element : response.getItemsList()) {
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
  public final UnaryCallable<AggregatedListRoutersRequest, RouterAggregatedList>
      aggregatedListCallable() {
    return stub.aggregatedListCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified Router resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RoutersClient routersClient = RoutersClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String router = "router-925132983";
   *   Operation response = routersClient.deleteAsync(project, region, router).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region for this request.
   * @param router Name of the Router resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> deleteAsync(
      String project, String region, String router) {
    DeleteRouterRequest request =
        DeleteRouterRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setRouter(router)
            .build();
    return deleteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified Router resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RoutersClient routersClient = RoutersClient.create()) {
   *   DeleteRouterRequest request =
   *       DeleteRouterRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setRouter("router-925132983")
   *           .build();
   *   Operation response = routersClient.deleteAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> deleteAsync(DeleteRouterRequest request) {
    return deleteOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified Router resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RoutersClient routersClient = RoutersClient.create()) {
   *   DeleteRouterRequest request =
   *       DeleteRouterRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setRouter("router-925132983")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       routersClient.deleteOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteRouterRequest, Operation, Operation>
      deleteOperationCallable() {
    return stub.deleteOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified Router resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RoutersClient routersClient = RoutersClient.create()) {
   *   DeleteRouterRequest request =
   *       DeleteRouterRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setRouter("router-925132983")
   *           .build();
   *   ApiFuture<Operation> future = routersClient.deleteCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteRouterRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes Route Policy
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RoutersClient routersClient = RoutersClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String router = "router-925132983";
   *   Operation response = routersClient.deleteRoutePolicyAsync(project, region, router).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region for this request.
   * @param router Name of the Router resource where Route Policy is defined.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> deleteRoutePolicyAsync(
      String project, String region, String router) {
    DeleteRoutePolicyRouterRequest request =
        DeleteRoutePolicyRouterRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setRouter(router)
            .build();
    return deleteRoutePolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes Route Policy
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RoutersClient routersClient = RoutersClient.create()) {
   *   DeleteRoutePolicyRouterRequest request =
   *       DeleteRoutePolicyRouterRequest.newBuilder()
   *           .setPolicy("policy-982670030")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setRouter("router-925132983")
   *           .build();
   *   Operation response = routersClient.deleteRoutePolicyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> deleteRoutePolicyAsync(
      DeleteRoutePolicyRouterRequest request) {
    return deleteRoutePolicyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes Route Policy
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RoutersClient routersClient = RoutersClient.create()) {
   *   DeleteRoutePolicyRouterRequest request =
   *       DeleteRoutePolicyRouterRequest.newBuilder()
   *           .setPolicy("policy-982670030")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setRouter("router-925132983")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       routersClient.deleteRoutePolicyOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteRoutePolicyRouterRequest, Operation, Operation>
      deleteRoutePolicyOperationCallable() {
    return stub.deleteRoutePolicyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes Route Policy
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RoutersClient routersClient = RoutersClient.create()) {
   *   DeleteRoutePolicyRouterRequest request =
   *       DeleteRoutePolicyRouterRequest.newBuilder()
   *           .setPolicy("policy-982670030")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setRouter("router-925132983")
   *           .build();
   *   ApiFuture<Operation> future = routersClient.deleteRoutePolicyCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteRoutePolicyRouterRequest, Operation>
      deleteRoutePolicyCallable() {
    return stub.deleteRoutePolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified Router resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RoutersClient routersClient = RoutersClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String router = "router-925132983";
   *   Router response = routersClient.get(project, region, router);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region for this request.
   * @param router Name of the Router resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Router get(String project, String region, String router) {
    GetRouterRequest request =
        GetRouterRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setRouter(router)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified Router resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RoutersClient routersClient = RoutersClient.create()) {
   *   GetRouterRequest request =
   *       GetRouterRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRouter("router-925132983")
   *           .build();
   *   Router response = routersClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Router get(GetRouterRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified Router resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RoutersClient routersClient = RoutersClient.create()) {
   *   GetRouterRequest request =
   *       GetRouterRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRouter("router-925132983")
   *           .build();
   *   ApiFuture<Router> future = routersClient.getCallable().futureCall(request);
   *   // Do something.
   *   Router response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRouterRequest, Router> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves runtime NAT IP information.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RoutersClient routersClient = RoutersClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String router = "router-925132983";
   *   NatIpInfoResponse response = routersClient.getNatIpInfo(project, region, router);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region for this request.
   * @param router Name of the Router resource to query for Nat IP information. The name should
   *     conform to RFC1035.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NatIpInfoResponse getNatIpInfo(String project, String region, String router) {
    GetNatIpInfoRouterRequest request =
        GetNatIpInfoRouterRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setRouter(router)
            .build();
    return getNatIpInfo(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves runtime NAT IP information.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RoutersClient routersClient = RoutersClient.create()) {
   *   GetNatIpInfoRouterRequest request =
   *       GetNatIpInfoRouterRequest.newBuilder()
   *           .setNatName("natName1727733580")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRouter("router-925132983")
   *           .build();
   *   NatIpInfoResponse response = routersClient.getNatIpInfo(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NatIpInfoResponse getNatIpInfo(GetNatIpInfoRouterRequest request) {
    return getNatIpInfoCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves runtime NAT IP information.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RoutersClient routersClient = RoutersClient.create()) {
   *   GetNatIpInfoRouterRequest request =
   *       GetNatIpInfoRouterRequest.newBuilder()
   *           .setNatName("natName1727733580")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRouter("router-925132983")
   *           .build();
   *   ApiFuture<NatIpInfoResponse> future =
   *       routersClient.getNatIpInfoCallable().futureCall(request);
   *   // Do something.
   *   NatIpInfoResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetNatIpInfoRouterRequest, NatIpInfoResponse> getNatIpInfoCallable() {
    return stub.getNatIpInfoCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves runtime Nat mapping information of VM endpoints.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RoutersClient routersClient = RoutersClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String router = "router-925132983";
   *   for (VmEndpointNatMappings element :
   *       routersClient.getNatMappingInfo(project, region, router).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region for this request.
   * @param router Name of the Router resource to query for Nat Mapping information of VM endpoints.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GetNatMappingInfoPagedResponse getNatMappingInfo(
      String project, String region, String router) {
    GetNatMappingInfoRoutersRequest request =
        GetNatMappingInfoRoutersRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setRouter(router)
            .build();
    return getNatMappingInfo(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves runtime Nat mapping information of VM endpoints.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RoutersClient routersClient = RoutersClient.create()) {
   *   GetNatMappingInfoRoutersRequest request =
   *       GetNatMappingInfoRoutersRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setNatName("natName1727733580")
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .setRouter("router-925132983")
   *           .build();
   *   for (VmEndpointNatMappings element : routersClient.getNatMappingInfo(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GetNatMappingInfoPagedResponse getNatMappingInfo(
      GetNatMappingInfoRoutersRequest request) {
    return getNatMappingInfoPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves runtime Nat mapping information of VM endpoints.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RoutersClient routersClient = RoutersClient.create()) {
   *   GetNatMappingInfoRoutersRequest request =
   *       GetNatMappingInfoRoutersRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setNatName("natName1727733580")
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .setRouter("router-925132983")
   *           .build();
   *   ApiFuture<VmEndpointNatMappings> future =
   *       routersClient.getNatMappingInfoPagedCallable().futureCall(request);
   *   // Do something.
   *   for (VmEndpointNatMappings element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<GetNatMappingInfoRoutersRequest, GetNatMappingInfoPagedResponse>
      getNatMappingInfoPagedCallable() {
    return stub.getNatMappingInfoPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves runtime Nat mapping information of VM endpoints.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RoutersClient routersClient = RoutersClient.create()) {
   *   GetNatMappingInfoRoutersRequest request =
   *       GetNatMappingInfoRoutersRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setNatName("natName1727733580")
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .setRouter("router-925132983")
   *           .build();
   *   while (true) {
   *     VmEndpointNatMappingsList response =
   *         routersClient.getNatMappingInfoCallable().call(request);
   *     for (VmEndpointNatMappings element : response.getResultList()) {
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
  public final UnaryCallable<GetNatMappingInfoRoutersRequest, VmEndpointNatMappingsList>
      getNatMappingInfoCallable() {
    return stub.getNatMappingInfoCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns specified Route Policy
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RoutersClient routersClient = RoutersClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String router = "router-925132983";
   *   RoutersGetRoutePolicyResponse response =
   *       routersClient.getRoutePolicy(project, region, router);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region for this request.
   * @param router Name of the Router resource to query for the route policy. The name should
   *     conform to RFC1035.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RoutersGetRoutePolicyResponse getRoutePolicy(
      String project, String region, String router) {
    GetRoutePolicyRouterRequest request =
        GetRoutePolicyRouterRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setRouter(router)
            .build();
    return getRoutePolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns specified Route Policy
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RoutersClient routersClient = RoutersClient.create()) {
   *   GetRoutePolicyRouterRequest request =
   *       GetRoutePolicyRouterRequest.newBuilder()
   *           .setPolicy("policy-982670030")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRouter("router-925132983")
   *           .build();
   *   RoutersGetRoutePolicyResponse response = routersClient.getRoutePolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RoutersGetRoutePolicyResponse getRoutePolicy(GetRoutePolicyRouterRequest request) {
    return getRoutePolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns specified Route Policy
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RoutersClient routersClient = RoutersClient.create()) {
   *   GetRoutePolicyRouterRequest request =
   *       GetRoutePolicyRouterRequest.newBuilder()
   *           .setPolicy("policy-982670030")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRouter("router-925132983")
   *           .build();
   *   ApiFuture<RoutersGetRoutePolicyResponse> future =
   *       routersClient.getRoutePolicyCallable().futureCall(request);
   *   // Do something.
   *   RoutersGetRoutePolicyResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRoutePolicyRouterRequest, RoutersGetRoutePolicyResponse>
      getRoutePolicyCallable() {
    return stub.getRoutePolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves runtime information of the specified router.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RoutersClient routersClient = RoutersClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String router = "router-925132983";
   *   RouterStatusResponse response = routersClient.getRouterStatus(project, region, router);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region for this request.
   * @param router Name of the Router resource to query.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RouterStatusResponse getRouterStatus(String project, String region, String router) {
    GetRouterStatusRouterRequest request =
        GetRouterStatusRouterRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setRouter(router)
            .build();
    return getRouterStatus(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves runtime information of the specified router.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RoutersClient routersClient = RoutersClient.create()) {
   *   GetRouterStatusRouterRequest request =
   *       GetRouterStatusRouterRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRouter("router-925132983")
   *           .build();
   *   RouterStatusResponse response = routersClient.getRouterStatus(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RouterStatusResponse getRouterStatus(GetRouterStatusRouterRequest request) {
    return getRouterStatusCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves runtime information of the specified router.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RoutersClient routersClient = RoutersClient.create()) {
   *   GetRouterStatusRouterRequest request =
   *       GetRouterStatusRouterRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRouter("router-925132983")
   *           .build();
   *   ApiFuture<RouterStatusResponse> future =
   *       routersClient.getRouterStatusCallable().futureCall(request);
   *   // Do something.
   *   RouterStatusResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRouterStatusRouterRequest, RouterStatusResponse>
      getRouterStatusCallable() {
    return stub.getRouterStatusCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Router resource in the specified project and region using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RoutersClient routersClient = RoutersClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   Router routerResource = Router.newBuilder().build();
   *   Operation response = routersClient.insertAsync(project, region, routerResource).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region for this request.
   * @param routerResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> insertAsync(
      String project, String region, Router routerResource) {
    InsertRouterRequest request =
        InsertRouterRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setRouterResource(routerResource)
            .build();
    return insertAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Router resource in the specified project and region using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RoutersClient routersClient = RoutersClient.create()) {
   *   InsertRouterRequest request =
   *       InsertRouterRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setRouterResource(Router.newBuilder().build())
   *           .build();
   *   Operation response = routersClient.insertAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> insertAsync(InsertRouterRequest request) {
    return insertOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Router resource in the specified project and region using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RoutersClient routersClient = RoutersClient.create()) {
   *   InsertRouterRequest request =
   *       InsertRouterRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setRouterResource(Router.newBuilder().build())
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       routersClient.insertOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<InsertRouterRequest, Operation, Operation>
      insertOperationCallable() {
    return stub.insertOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Router resource in the specified project and region using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RoutersClient routersClient = RoutersClient.create()) {
   *   InsertRouterRequest request =
   *       InsertRouterRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setRouterResource(Router.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = routersClient.insertCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<InsertRouterRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of Router resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RoutersClient routersClient = RoutersClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   for (Router element : routersClient.list(project, region).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project, String region) {
    ListRoutersRequest request =
        ListRoutersRequest.newBuilder().setProject(project).setRegion(region).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of Router resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RoutersClient routersClient = RoutersClient.create()) {
   *   ListRoutersRequest request =
   *       ListRoutersRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   for (Router element : routersClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListRoutersRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of Router resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RoutersClient routersClient = RoutersClient.create()) {
   *   ListRoutersRequest request =
   *       ListRoutersRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<Router> future = routersClient.listPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Router element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListRoutersRequest, ListPagedResponse> listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of Router resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RoutersClient routersClient = RoutersClient.create()) {
   *   ListRoutersRequest request =
   *       ListRoutersRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   while (true) {
   *     RouterList response = routersClient.listCallable().call(request);
   *     for (Router element : response.getItemsList()) {
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
  public final UnaryCallable<ListRoutersRequest, RouterList> listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of router bgp routes available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RoutersClient routersClient = RoutersClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String router = "router-925132983";
   *   for (BgpRoute element : routersClient.listBgpRoutes(project, region, router).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region for this request.
   * @param router Name or id of the resource for this request. Name should conform to RFC1035.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBgpRoutesPagedResponse listBgpRoutes(
      String project, String region, String router) {
    ListBgpRoutesRoutersRequest request =
        ListBgpRoutesRoutersRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setRouter(router)
            .build();
    return listBgpRoutes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of router bgp routes available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RoutersClient routersClient = RoutersClient.create()) {
   *   ListBgpRoutesRoutersRequest request =
   *       ListBgpRoutesRoutersRequest.newBuilder()
   *           .setAddressFamily("addressFamily-1130029960")
   *           .setDestinationPrefix("destinationPrefix-1718345664")
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setPeer("peer3436898")
   *           .setPolicyApplied(true)
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .setRouteType("routeType167668003")
   *           .setRouter("router-925132983")
   *           .build();
   *   for (BgpRoute element : routersClient.listBgpRoutes(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBgpRoutesPagedResponse listBgpRoutes(ListBgpRoutesRoutersRequest request) {
    return listBgpRoutesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of router bgp routes available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RoutersClient routersClient = RoutersClient.create()) {
   *   ListBgpRoutesRoutersRequest request =
   *       ListBgpRoutesRoutersRequest.newBuilder()
   *           .setAddressFamily("addressFamily-1130029960")
   *           .setDestinationPrefix("destinationPrefix-1718345664")
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setPeer("peer3436898")
   *           .setPolicyApplied(true)
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .setRouteType("routeType167668003")
   *           .setRouter("router-925132983")
   *           .build();
   *   ApiFuture<BgpRoute> future = routersClient.listBgpRoutesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (BgpRoute element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListBgpRoutesRoutersRequest, ListBgpRoutesPagedResponse>
      listBgpRoutesPagedCallable() {
    return stub.listBgpRoutesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of router bgp routes available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RoutersClient routersClient = RoutersClient.create()) {
   *   ListBgpRoutesRoutersRequest request =
   *       ListBgpRoutesRoutersRequest.newBuilder()
   *           .setAddressFamily("addressFamily-1130029960")
   *           .setDestinationPrefix("destinationPrefix-1718345664")
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setPeer("peer3436898")
   *           .setPolicyApplied(true)
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .setRouteType("routeType167668003")
   *           .setRouter("router-925132983")
   *           .build();
   *   while (true) {
   *     RoutersListBgpRoutes response = routersClient.listBgpRoutesCallable().call(request);
   *     for (BgpRoute element : response.getResultList()) {
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
  public final UnaryCallable<ListBgpRoutesRoutersRequest, RoutersListBgpRoutes>
      listBgpRoutesCallable() {
    return stub.listBgpRoutesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of router route policy subresources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RoutersClient routersClient = RoutersClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String router = "router-925132983";
   *   for (RoutePolicy element :
   *       routersClient.listRoutePolicies(project, region, router).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region for this request.
   * @param router Name or id of the resource for this request. Name should conform to RFC1035.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRoutePoliciesPagedResponse listRoutePolicies(
      String project, String region, String router) {
    ListRoutePoliciesRoutersRequest request =
        ListRoutePoliciesRoutersRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setRouter(router)
            .build();
    return listRoutePolicies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of router route policy subresources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RoutersClient routersClient = RoutersClient.create()) {
   *   ListRoutePoliciesRoutersRequest request =
   *       ListRoutePoliciesRoutersRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .setRouter("router-925132983")
   *           .build();
   *   for (RoutePolicy element : routersClient.listRoutePolicies(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRoutePoliciesPagedResponse listRoutePolicies(
      ListRoutePoliciesRoutersRequest request) {
    return listRoutePoliciesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of router route policy subresources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RoutersClient routersClient = RoutersClient.create()) {
   *   ListRoutePoliciesRoutersRequest request =
   *       ListRoutePoliciesRoutersRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .setRouter("router-925132983")
   *           .build();
   *   ApiFuture<RoutePolicy> future =
   *       routersClient.listRoutePoliciesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (RoutePolicy element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListRoutePoliciesRoutersRequest, ListRoutePoliciesPagedResponse>
      listRoutePoliciesPagedCallable() {
    return stub.listRoutePoliciesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of router route policy subresources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RoutersClient routersClient = RoutersClient.create()) {
   *   ListRoutePoliciesRoutersRequest request =
   *       ListRoutePoliciesRoutersRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .setRouter("router-925132983")
   *           .build();
   *   while (true) {
   *     RoutersListRoutePolicies response = routersClient.listRoutePoliciesCallable().call(request);
   *     for (RoutePolicy element : response.getResultList()) {
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
  public final UnaryCallable<ListRoutePoliciesRoutersRequest, RoutersListRoutePolicies>
      listRoutePoliciesCallable() {
    return stub.listRoutePoliciesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the specified Router resource with the data included in the request. This method
   * supports PATCH semantics and uses JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RoutersClient routersClient = RoutersClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String router = "router-925132983";
   *   Router routerResource = Router.newBuilder().build();
   *   Operation response = routersClient.patchAsync(project, region, router, routerResource).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region for this request.
   * @param router Name of the Router resource to patch.
   * @param routerResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> patchAsync(
      String project, String region, String router, Router routerResource) {
    PatchRouterRequest request =
        PatchRouterRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setRouter(router)
            .setRouterResource(routerResource)
            .build();
    return patchAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the specified Router resource with the data included in the request. This method
   * supports PATCH semantics and uses JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RoutersClient routersClient = RoutersClient.create()) {
   *   PatchRouterRequest request =
   *       PatchRouterRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setRouter("router-925132983")
   *           .setRouterResource(Router.newBuilder().build())
   *           .build();
   *   Operation response = routersClient.patchAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> patchAsync(PatchRouterRequest request) {
    return patchOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the specified Router resource with the data included in the request. This method
   * supports PATCH semantics and uses JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RoutersClient routersClient = RoutersClient.create()) {
   *   PatchRouterRequest request =
   *       PatchRouterRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setRouter("router-925132983")
   *           .setRouterResource(Router.newBuilder().build())
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       routersClient.patchOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<PatchRouterRequest, Operation, Operation>
      patchOperationCallable() {
    return stub.patchOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the specified Router resource with the data included in the request. This method
   * supports PATCH semantics and uses JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RoutersClient routersClient = RoutersClient.create()) {
   *   PatchRouterRequest request =
   *       PatchRouterRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setRouter("router-925132983")
   *           .setRouterResource(Router.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = routersClient.patchCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PatchRouterRequest, Operation> patchCallable() {
    return stub.patchCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches Route Policy
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RoutersClient routersClient = RoutersClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String router = "router-925132983";
   *   RoutePolicy routePolicyResource = RoutePolicy.newBuilder().build();
   *   Operation response =
   *       routersClient.patchRoutePolicyAsync(project, region, router, routePolicyResource).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region for this request.
   * @param router Name of the Router resource where Route Policy is defined.
   * @param routePolicyResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> patchRoutePolicyAsync(
      String project, String region, String router, RoutePolicy routePolicyResource) {
    PatchRoutePolicyRouterRequest request =
        PatchRoutePolicyRouterRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setRouter(router)
            .setRoutePolicyResource(routePolicyResource)
            .build();
    return patchRoutePolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches Route Policy
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RoutersClient routersClient = RoutersClient.create()) {
   *   PatchRoutePolicyRouterRequest request =
   *       PatchRoutePolicyRouterRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setRoutePolicyResource(RoutePolicy.newBuilder().build())
   *           .setRouter("router-925132983")
   *           .build();
   *   Operation response = routersClient.patchRoutePolicyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> patchRoutePolicyAsync(
      PatchRoutePolicyRouterRequest request) {
    return patchRoutePolicyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches Route Policy
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RoutersClient routersClient = RoutersClient.create()) {
   *   PatchRoutePolicyRouterRequest request =
   *       PatchRoutePolicyRouterRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setRoutePolicyResource(RoutePolicy.newBuilder().build())
   *           .setRouter("router-925132983")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       routersClient.patchRoutePolicyOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<PatchRoutePolicyRouterRequest, Operation, Operation>
      patchRoutePolicyOperationCallable() {
    return stub.patchRoutePolicyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches Route Policy
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RoutersClient routersClient = RoutersClient.create()) {
   *   PatchRoutePolicyRouterRequest request =
   *       PatchRoutePolicyRouterRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setRoutePolicyResource(RoutePolicy.newBuilder().build())
   *           .setRouter("router-925132983")
   *           .build();
   *   ApiFuture<Operation> future = routersClient.patchRoutePolicyCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PatchRoutePolicyRouterRequest, Operation> patchRoutePolicyCallable() {
    return stub.patchRoutePolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Preview fields auto-generated during router create and update operations. Calling this method
   * does NOT create or update the router.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RoutersClient routersClient = RoutersClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String router = "router-925132983";
   *   Router routerResource = Router.newBuilder().build();
   *   RoutersPreviewResponse response =
   *       routersClient.preview(project, region, router, routerResource);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region for this request.
   * @param router Name of the Router resource to query.
   * @param routerResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RoutersPreviewResponse preview(
      String project, String region, String router, Router routerResource) {
    PreviewRouterRequest request =
        PreviewRouterRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setRouter(router)
            .setRouterResource(routerResource)
            .build();
    return preview(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Preview fields auto-generated during router create and update operations. Calling this method
   * does NOT create or update the router.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RoutersClient routersClient = RoutersClient.create()) {
   *   PreviewRouterRequest request =
   *       PreviewRouterRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRouter("router-925132983")
   *           .setRouterResource(Router.newBuilder().build())
   *           .build();
   *   RoutersPreviewResponse response = routersClient.preview(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RoutersPreviewResponse preview(PreviewRouterRequest request) {
    return previewCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Preview fields auto-generated during router create and update operations. Calling this method
   * does NOT create or update the router.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RoutersClient routersClient = RoutersClient.create()) {
   *   PreviewRouterRequest request =
   *       PreviewRouterRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRouter("router-925132983")
   *           .setRouterResource(Router.newBuilder().build())
   *           .build();
   *   ApiFuture<RoutersPreviewResponse> future =
   *       routersClient.previewCallable().futureCall(request);
   *   // Do something.
   *   RoutersPreviewResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PreviewRouterRequest, RoutersPreviewResponse> previewCallable() {
    return stub.previewCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified Router resource with the data included in the request. This method
   * conforms to PUT semantics, which requests that the state of the target resource be created or
   * replaced with the state defined by the representation enclosed in the request message payload.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RoutersClient routersClient = RoutersClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String router = "router-925132983";
   *   Router routerResource = Router.newBuilder().build();
   *   Operation response = routersClient.updateAsync(project, region, router, routerResource).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region for this request.
   * @param router Name of the Router resource to update.
   * @param routerResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> updateAsync(
      String project, String region, String router, Router routerResource) {
    UpdateRouterRequest request =
        UpdateRouterRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setRouter(router)
            .setRouterResource(routerResource)
            .build();
    return updateAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified Router resource with the data included in the request. This method
   * conforms to PUT semantics, which requests that the state of the target resource be created or
   * replaced with the state defined by the representation enclosed in the request message payload.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RoutersClient routersClient = RoutersClient.create()) {
   *   UpdateRouterRequest request =
   *       UpdateRouterRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setRouter("router-925132983")
   *           .setRouterResource(Router.newBuilder().build())
   *           .build();
   *   Operation response = routersClient.updateAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> updateAsync(UpdateRouterRequest request) {
    return updateOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified Router resource with the data included in the request. This method
   * conforms to PUT semantics, which requests that the state of the target resource be created or
   * replaced with the state defined by the representation enclosed in the request message payload.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RoutersClient routersClient = RoutersClient.create()) {
   *   UpdateRouterRequest request =
   *       UpdateRouterRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setRouter("router-925132983")
   *           .setRouterResource(Router.newBuilder().build())
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       routersClient.updateOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateRouterRequest, Operation, Operation>
      updateOperationCallable() {
    return stub.updateOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified Router resource with the data included in the request. This method
   * conforms to PUT semantics, which requests that the state of the target resource be created or
   * replaced with the state defined by the representation enclosed in the request message payload.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RoutersClient routersClient = RoutersClient.create()) {
   *   UpdateRouterRequest request =
   *       UpdateRouterRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setRouter("router-925132983")
   *           .setRouterResource(Router.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = routersClient.updateCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateRouterRequest, Operation> updateCallable() {
    return stub.updateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates or creates new Route Policy
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RoutersClient routersClient = RoutersClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String router = "router-925132983";
   *   RoutePolicy routePolicyResource = RoutePolicy.newBuilder().build();
   *   Operation response =
   *       routersClient.updateRoutePolicyAsync(project, region, router, routePolicyResource).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region for this request.
   * @param router Name of the Router resource where Route Policy is defined.
   * @param routePolicyResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> updateRoutePolicyAsync(
      String project, String region, String router, RoutePolicy routePolicyResource) {
    UpdateRoutePolicyRouterRequest request =
        UpdateRoutePolicyRouterRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setRouter(router)
            .setRoutePolicyResource(routePolicyResource)
            .build();
    return updateRoutePolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates or creates new Route Policy
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RoutersClient routersClient = RoutersClient.create()) {
   *   UpdateRoutePolicyRouterRequest request =
   *       UpdateRoutePolicyRouterRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setRoutePolicyResource(RoutePolicy.newBuilder().build())
   *           .setRouter("router-925132983")
   *           .build();
   *   Operation response = routersClient.updateRoutePolicyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> updateRoutePolicyAsync(
      UpdateRoutePolicyRouterRequest request) {
    return updateRoutePolicyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates or creates new Route Policy
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RoutersClient routersClient = RoutersClient.create()) {
   *   UpdateRoutePolicyRouterRequest request =
   *       UpdateRoutePolicyRouterRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setRoutePolicyResource(RoutePolicy.newBuilder().build())
   *           .setRouter("router-925132983")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       routersClient.updateRoutePolicyOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateRoutePolicyRouterRequest, Operation, Operation>
      updateRoutePolicyOperationCallable() {
    return stub.updateRoutePolicyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates or creates new Route Policy
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RoutersClient routersClient = RoutersClient.create()) {
   *   UpdateRoutePolicyRouterRequest request =
   *       UpdateRoutePolicyRouterRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setRoutePolicyResource(RoutePolicy.newBuilder().build())
   *           .setRouter("router-925132983")
   *           .build();
   *   ApiFuture<Operation> future = routersClient.updateRoutePolicyCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateRoutePolicyRouterRequest, Operation>
      updateRoutePolicyCallable() {
    return stub.updateRoutePolicyCallable();
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

  public static class AggregatedListPagedResponse
      extends AbstractPagedListResponse<
          AggregatedListRoutersRequest,
          RouterAggregatedList,
          Map.Entry<String, RoutersScopedList>,
          AggregatedListPage,
          AggregatedListFixedSizeCollection> {

    public static ApiFuture<AggregatedListPagedResponse> createAsync(
        PageContext<
                AggregatedListRoutersRequest,
                RouterAggregatedList,
                Map.Entry<String, RoutersScopedList>>
            context,
        ApiFuture<RouterAggregatedList> futureResponse) {
      ApiFuture<AggregatedListPage> futurePage =
          AggregatedListPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new AggregatedListPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private AggregatedListPagedResponse(AggregatedListPage page) {
      super(page, AggregatedListFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class AggregatedListPage
      extends AbstractPage<
          AggregatedListRoutersRequest,
          RouterAggregatedList,
          Map.Entry<String, RoutersScopedList>,
          AggregatedListPage> {

    private AggregatedListPage(
        PageContext<
                AggregatedListRoutersRequest,
                RouterAggregatedList,
                Map.Entry<String, RoutersScopedList>>
            context,
        RouterAggregatedList response) {
      super(context, response);
    }

    private static AggregatedListPage createEmptyPage() {
      return new AggregatedListPage(null, null);
    }

    @Override
    protected AggregatedListPage createPage(
        PageContext<
                AggregatedListRoutersRequest,
                RouterAggregatedList,
                Map.Entry<String, RoutersScopedList>>
            context,
        RouterAggregatedList response) {
      return new AggregatedListPage(context, response);
    }

    @Override
    public ApiFuture<AggregatedListPage> createPageAsync(
        PageContext<
                AggregatedListRoutersRequest,
                RouterAggregatedList,
                Map.Entry<String, RoutersScopedList>>
            context,
        ApiFuture<RouterAggregatedList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregatedListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AggregatedListRoutersRequest,
          RouterAggregatedList,
          Map.Entry<String, RoutersScopedList>,
          AggregatedListPage,
          AggregatedListFixedSizeCollection> {

    private AggregatedListFixedSizeCollection(List<AggregatedListPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static AggregatedListFixedSizeCollection createEmptyCollection() {
      return new AggregatedListFixedSizeCollection(null, 0);
    }

    @Override
    protected AggregatedListFixedSizeCollection createCollection(
        List<AggregatedListPage> pages, int collectionSize) {
      return new AggregatedListFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class GetNatMappingInfoPagedResponse
      extends AbstractPagedListResponse<
          GetNatMappingInfoRoutersRequest,
          VmEndpointNatMappingsList,
          VmEndpointNatMappings,
          GetNatMappingInfoPage,
          GetNatMappingInfoFixedSizeCollection> {

    public static ApiFuture<GetNatMappingInfoPagedResponse> createAsync(
        PageContext<
                GetNatMappingInfoRoutersRequest, VmEndpointNatMappingsList, VmEndpointNatMappings>
            context,
        ApiFuture<VmEndpointNatMappingsList> futureResponse) {
      ApiFuture<GetNatMappingInfoPage> futurePage =
          GetNatMappingInfoPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new GetNatMappingInfoPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private GetNatMappingInfoPagedResponse(GetNatMappingInfoPage page) {
      super(page, GetNatMappingInfoFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class GetNatMappingInfoPage
      extends AbstractPage<
          GetNatMappingInfoRoutersRequest,
          VmEndpointNatMappingsList,
          VmEndpointNatMappings,
          GetNatMappingInfoPage> {

    private GetNatMappingInfoPage(
        PageContext<
                GetNatMappingInfoRoutersRequest, VmEndpointNatMappingsList, VmEndpointNatMappings>
            context,
        VmEndpointNatMappingsList response) {
      super(context, response);
    }

    private static GetNatMappingInfoPage createEmptyPage() {
      return new GetNatMappingInfoPage(null, null);
    }

    @Override
    protected GetNatMappingInfoPage createPage(
        PageContext<
                GetNatMappingInfoRoutersRequest, VmEndpointNatMappingsList, VmEndpointNatMappings>
            context,
        VmEndpointNatMappingsList response) {
      return new GetNatMappingInfoPage(context, response);
    }

    @Override
    public ApiFuture<GetNatMappingInfoPage> createPageAsync(
        PageContext<
                GetNatMappingInfoRoutersRequest, VmEndpointNatMappingsList, VmEndpointNatMappings>
            context,
        ApiFuture<VmEndpointNatMappingsList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class GetNatMappingInfoFixedSizeCollection
      extends AbstractFixedSizeCollection<
          GetNatMappingInfoRoutersRequest,
          VmEndpointNatMappingsList,
          VmEndpointNatMappings,
          GetNatMappingInfoPage,
          GetNatMappingInfoFixedSizeCollection> {

    private GetNatMappingInfoFixedSizeCollection(
        List<GetNatMappingInfoPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static GetNatMappingInfoFixedSizeCollection createEmptyCollection() {
      return new GetNatMappingInfoFixedSizeCollection(null, 0);
    }

    @Override
    protected GetNatMappingInfoFixedSizeCollection createCollection(
        List<GetNatMappingInfoPage> pages, int collectionSize) {
      return new GetNatMappingInfoFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListPagedResponse
      extends AbstractPagedListResponse<
          ListRoutersRequest, RouterList, Router, ListPage, ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListRoutersRequest, RouterList, Router> context,
        ApiFuture<RouterList> futureResponse) {
      ApiFuture<ListPage> futurePage =
          ListPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListPagedResponse(ListPage page) {
      super(page, ListFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPage
      extends AbstractPage<ListRoutersRequest, RouterList, Router, ListPage> {

    private ListPage(
        PageContext<ListRoutersRequest, RouterList, Router> context, RouterList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListRoutersRequest, RouterList, Router> context, RouterList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListRoutersRequest, RouterList, Router> context,
        ApiFuture<RouterList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRoutersRequest, RouterList, Router, ListPage, ListFixedSizeCollection> {

    private ListFixedSizeCollection(List<ListPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListFixedSizeCollection createEmptyCollection() {
      return new ListFixedSizeCollection(null, 0);
    }

    @Override
    protected ListFixedSizeCollection createCollection(List<ListPage> pages, int collectionSize) {
      return new ListFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListBgpRoutesPagedResponse
      extends AbstractPagedListResponse<
          ListBgpRoutesRoutersRequest,
          RoutersListBgpRoutes,
          BgpRoute,
          ListBgpRoutesPage,
          ListBgpRoutesFixedSizeCollection> {

    public static ApiFuture<ListBgpRoutesPagedResponse> createAsync(
        PageContext<ListBgpRoutesRoutersRequest, RoutersListBgpRoutes, BgpRoute> context,
        ApiFuture<RoutersListBgpRoutes> futureResponse) {
      ApiFuture<ListBgpRoutesPage> futurePage =
          ListBgpRoutesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListBgpRoutesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListBgpRoutesPagedResponse(ListBgpRoutesPage page) {
      super(page, ListBgpRoutesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListBgpRoutesPage
      extends AbstractPage<
          ListBgpRoutesRoutersRequest, RoutersListBgpRoutes, BgpRoute, ListBgpRoutesPage> {

    private ListBgpRoutesPage(
        PageContext<ListBgpRoutesRoutersRequest, RoutersListBgpRoutes, BgpRoute> context,
        RoutersListBgpRoutes response) {
      super(context, response);
    }

    private static ListBgpRoutesPage createEmptyPage() {
      return new ListBgpRoutesPage(null, null);
    }

    @Override
    protected ListBgpRoutesPage createPage(
        PageContext<ListBgpRoutesRoutersRequest, RoutersListBgpRoutes, BgpRoute> context,
        RoutersListBgpRoutes response) {
      return new ListBgpRoutesPage(context, response);
    }

    @Override
    public ApiFuture<ListBgpRoutesPage> createPageAsync(
        PageContext<ListBgpRoutesRoutersRequest, RoutersListBgpRoutes, BgpRoute> context,
        ApiFuture<RoutersListBgpRoutes> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListBgpRoutesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListBgpRoutesRoutersRequest,
          RoutersListBgpRoutes,
          BgpRoute,
          ListBgpRoutesPage,
          ListBgpRoutesFixedSizeCollection> {

    private ListBgpRoutesFixedSizeCollection(List<ListBgpRoutesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListBgpRoutesFixedSizeCollection createEmptyCollection() {
      return new ListBgpRoutesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListBgpRoutesFixedSizeCollection createCollection(
        List<ListBgpRoutesPage> pages, int collectionSize) {
      return new ListBgpRoutesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListRoutePoliciesPagedResponse
      extends AbstractPagedListResponse<
          ListRoutePoliciesRoutersRequest,
          RoutersListRoutePolicies,
          RoutePolicy,
          ListRoutePoliciesPage,
          ListRoutePoliciesFixedSizeCollection> {

    public static ApiFuture<ListRoutePoliciesPagedResponse> createAsync(
        PageContext<ListRoutePoliciesRoutersRequest, RoutersListRoutePolicies, RoutePolicy> context,
        ApiFuture<RoutersListRoutePolicies> futureResponse) {
      ApiFuture<ListRoutePoliciesPage> futurePage =
          ListRoutePoliciesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListRoutePoliciesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListRoutePoliciesPagedResponse(ListRoutePoliciesPage page) {
      super(page, ListRoutePoliciesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListRoutePoliciesPage
      extends AbstractPage<
          ListRoutePoliciesRoutersRequest,
          RoutersListRoutePolicies,
          RoutePolicy,
          ListRoutePoliciesPage> {

    private ListRoutePoliciesPage(
        PageContext<ListRoutePoliciesRoutersRequest, RoutersListRoutePolicies, RoutePolicy> context,
        RoutersListRoutePolicies response) {
      super(context, response);
    }

    private static ListRoutePoliciesPage createEmptyPage() {
      return new ListRoutePoliciesPage(null, null);
    }

    @Override
    protected ListRoutePoliciesPage createPage(
        PageContext<ListRoutePoliciesRoutersRequest, RoutersListRoutePolicies, RoutePolicy> context,
        RoutersListRoutePolicies response) {
      return new ListRoutePoliciesPage(context, response);
    }

    @Override
    public ApiFuture<ListRoutePoliciesPage> createPageAsync(
        PageContext<ListRoutePoliciesRoutersRequest, RoutersListRoutePolicies, RoutePolicy> context,
        ApiFuture<RoutersListRoutePolicies> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListRoutePoliciesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRoutePoliciesRoutersRequest,
          RoutersListRoutePolicies,
          RoutePolicy,
          ListRoutePoliciesPage,
          ListRoutePoliciesFixedSizeCollection> {

    private ListRoutePoliciesFixedSizeCollection(
        List<ListRoutePoliciesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListRoutePoliciesFixedSizeCollection createEmptyCollection() {
      return new ListRoutePoliciesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListRoutePoliciesFixedSizeCollection createCollection(
        List<ListRoutePoliciesPage> pages, int collectionSize) {
      return new ListRoutePoliciesFixedSizeCollection(pages, collectionSize);
    }
  }
}
