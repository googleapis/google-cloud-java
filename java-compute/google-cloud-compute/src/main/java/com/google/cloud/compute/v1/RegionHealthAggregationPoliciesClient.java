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
import com.google.cloud.compute.v1.stub.RegionHealthAggregationPoliciesStub;
import com.google.cloud.compute.v1.stub.RegionHealthAggregationPoliciesStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The RegionHealthAggregationPolicies API.
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
 * try (RegionHealthAggregationPoliciesClient regionHealthAggregationPoliciesClient =
 *     RegionHealthAggregationPoliciesClient.create()) {
 *   String project = "project-309310695";
 *   String region = "region-934795532";
 *   String healthAggregationPolicy = "healthAggregationPolicy755484600";
 *   HealthAggregationPolicy response =
 *       regionHealthAggregationPoliciesClient.get(project, region, healthAggregationPolicy);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the RegionHealthAggregationPoliciesClient object to clean
 * up resources such as threads. In the example above, try-with-resources is used, which
 * automatically calls close().
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
 *      <td><p> Retrieves the list of all HealthAggregationPolicy resources, regional and global, available to the specified project.
 * <p>  To prevent failure, it is recommended that you set the `returnPartialSuccess` parameter to `true`.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> aggregatedList(AggregatedListRegionHealthAggregationPoliciesRequest request)
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
 *      <td><p> Deletes the specified HealthAggregationPolicy in the given region.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteAsync(DeleteRegionHealthAggregationPolicyRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteAsync(String project, String region, String healthAggregationPolicy)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteOperationCallable()
 *           <li><p> deleteCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Get</td>
 *      <td><p> Returns the specified HealthAggregationPolicy resource in the given region.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> get(GetRegionHealthAggregationPolicyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> get(String project, String region, String healthAggregationPolicy)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Insert</td>
 *      <td><p> Create a HealthAggregationPolicy in the specified project in the given region using the parameters that are included in the request.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> insertAsync(InsertRegionHealthAggregationPolicyRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> insertAsync(String project, String region, HealthAggregationPolicy healthAggregationPolicyResource)
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
 *      <td><p> Lists the HealthAggregationPolicies for a project in the given region.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> list(ListRegionHealthAggregationPoliciesRequest request)
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
 *      <td><p> Patch</td>
 *      <td><p> Updates the specified regional HealthAggregationPolicy resource with the data included in the request. This method supportsPATCH semantics and uses theJSON merge patch format and processing rules.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> patchAsync(PatchRegionHealthAggregationPolicyRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> patchAsync(String project, String region, String healthAggregationPolicy, HealthAggregationPolicy healthAggregationPolicyResource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> patchOperationCallable()
 *           <li><p> patchCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> TestIamPermissions</td>
 *      <td><p> Returns permissions that a caller has on the specified resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> testIamPermissions(TestIamPermissionsRegionHealthAggregationPolicyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> testIamPermissions(String project, String region, String resource, TestPermissionsRequest testPermissionsRequestResource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> testIamPermissionsCallable()
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
 * <p>This class can be customized by passing in a custom instance of
 * RegionHealthAggregationPoliciesSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * RegionHealthAggregationPoliciesSettings regionHealthAggregationPoliciesSettings =
 *     RegionHealthAggregationPoliciesSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * RegionHealthAggregationPoliciesClient regionHealthAggregationPoliciesClient =
 *     RegionHealthAggregationPoliciesClient.create(regionHealthAggregationPoliciesSettings);
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
 * RegionHealthAggregationPoliciesSettings regionHealthAggregationPoliciesSettings =
 *     RegionHealthAggregationPoliciesSettings.newBuilder().setEndpoint(myEndpoint).build();
 * RegionHealthAggregationPoliciesClient regionHealthAggregationPoliciesClient =
 *     RegionHealthAggregationPoliciesClient.create(regionHealthAggregationPoliciesSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class RegionHealthAggregationPoliciesClient implements BackgroundResource {
  private final RegionHealthAggregationPoliciesSettings settings;
  private final RegionHealthAggregationPoliciesStub stub;

  /** Constructs an instance of RegionHealthAggregationPoliciesClient with default settings. */
  public static final RegionHealthAggregationPoliciesClient create() throws IOException {
    return create(RegionHealthAggregationPoliciesSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of RegionHealthAggregationPoliciesClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final RegionHealthAggregationPoliciesClient create(
      RegionHealthAggregationPoliciesSettings settings) throws IOException {
    return new RegionHealthAggregationPoliciesClient(settings);
  }

  /**
   * Constructs an instance of RegionHealthAggregationPoliciesClient, using the given stub for
   * making calls. This is for advanced usage - prefer using
   * create(RegionHealthAggregationPoliciesSettings).
   */
  public static final RegionHealthAggregationPoliciesClient create(
      RegionHealthAggregationPoliciesStub stub) {
    return new RegionHealthAggregationPoliciesClient(stub);
  }

  /**
   * Constructs an instance of RegionHealthAggregationPoliciesClient, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected RegionHealthAggregationPoliciesClient(RegionHealthAggregationPoliciesSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub =
        ((RegionHealthAggregationPoliciesStubSettings) settings.getStubSettings()).createStub();
  }

  protected RegionHealthAggregationPoliciesClient(RegionHealthAggregationPoliciesStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final RegionHealthAggregationPoliciesSettings getSettings() {
    return settings;
  }

  public RegionHealthAggregationPoliciesStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of all HealthAggregationPolicy resources, regional and global, available to
   * the specified project.
   *
   * <p>To prevent failure, it is recommended that you set the `returnPartialSuccess` parameter to
   * `true`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthAggregationPoliciesClient regionHealthAggregationPoliciesClient =
   *     RegionHealthAggregationPoliciesClient.create()) {
   *   String project = "project-309310695";
   *   for (Map.Entry<String, HealthAggregationPoliciesScopedList> element :
   *       regionHealthAggregationPoliciesClient.aggregatedList(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Name of the project scoping this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(String project) {
    AggregatedListRegionHealthAggregationPoliciesRequest request =
        AggregatedListRegionHealthAggregationPoliciesRequest.newBuilder()
            .setProject(project)
            .build();
    return aggregatedList(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of all HealthAggregationPolicy resources, regional and global, available to
   * the specified project.
   *
   * <p>To prevent failure, it is recommended that you set the `returnPartialSuccess` parameter to
   * `true`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthAggregationPoliciesClient regionHealthAggregationPoliciesClient =
   *     RegionHealthAggregationPoliciesClient.create()) {
   *   AggregatedListRegionHealthAggregationPoliciesRequest request =
   *       AggregatedListRegionHealthAggregationPoliciesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setIncludeAllScopes(true)
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .setServiceProjectNumber(-1293855239)
   *           .build();
   *   for (Map.Entry<String, HealthAggregationPoliciesScopedList> element :
   *       regionHealthAggregationPoliciesClient.aggregatedList(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(
      AggregatedListRegionHealthAggregationPoliciesRequest request) {
    return aggregatedListPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of all HealthAggregationPolicy resources, regional and global, available to
   * the specified project.
   *
   * <p>To prevent failure, it is recommended that you set the `returnPartialSuccess` parameter to
   * `true`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthAggregationPoliciesClient regionHealthAggregationPoliciesClient =
   *     RegionHealthAggregationPoliciesClient.create()) {
   *   AggregatedListRegionHealthAggregationPoliciesRequest request =
   *       AggregatedListRegionHealthAggregationPoliciesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setIncludeAllScopes(true)
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .setServiceProjectNumber(-1293855239)
   *           .build();
   *   ApiFuture<Map.Entry<String, HealthAggregationPoliciesScopedList>> future =
   *       regionHealthAggregationPoliciesClient.aggregatedListPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Map.Entry<String, HealthAggregationPoliciesScopedList> element :
   *       future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          AggregatedListRegionHealthAggregationPoliciesRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return stub.aggregatedListPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of all HealthAggregationPolicy resources, regional and global, available to
   * the specified project.
   *
   * <p>To prevent failure, it is recommended that you set the `returnPartialSuccess` parameter to
   * `true`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthAggregationPoliciesClient regionHealthAggregationPoliciesClient =
   *     RegionHealthAggregationPoliciesClient.create()) {
   *   AggregatedListRegionHealthAggregationPoliciesRequest request =
   *       AggregatedListRegionHealthAggregationPoliciesRequest.newBuilder()
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
   *     HealthAggregationPolicyAggregatedList response =
   *         regionHealthAggregationPoliciesClient.aggregatedListCallable().call(request);
   *     for (Map.Entry<String, HealthAggregationPoliciesScopedList> element :
   *         response.getItemsList()) {
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
  public final UnaryCallable<
          AggregatedListRegionHealthAggregationPoliciesRequest,
          HealthAggregationPolicyAggregatedList>
      aggregatedListCallable() {
    return stub.aggregatedListCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified HealthAggregationPolicy in the given region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthAggregationPoliciesClient regionHealthAggregationPoliciesClient =
   *     RegionHealthAggregationPoliciesClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String healthAggregationPolicy = "healthAggregationPolicy755484600";
   *   Operation response =
   *       regionHealthAggregationPoliciesClient
   *           .deleteAsync(project, region, healthAggregationPolicy)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param healthAggregationPolicy Name of the HealthAggregationPolicy resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> deleteAsync(
      String project, String region, String healthAggregationPolicy) {
    DeleteRegionHealthAggregationPolicyRequest request =
        DeleteRegionHealthAggregationPolicyRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setHealthAggregationPolicy(healthAggregationPolicy)
            .build();
    return deleteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified HealthAggregationPolicy in the given region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthAggregationPoliciesClient regionHealthAggregationPoliciesClient =
   *     RegionHealthAggregationPoliciesClient.create()) {
   *   DeleteRegionHealthAggregationPolicyRequest request =
   *       DeleteRegionHealthAggregationPolicyRequest.newBuilder()
   *           .setHealthAggregationPolicy("healthAggregationPolicy755484600")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = regionHealthAggregationPoliciesClient.deleteAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> deleteAsync(
      DeleteRegionHealthAggregationPolicyRequest request) {
    return deleteOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified HealthAggregationPolicy in the given region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthAggregationPoliciesClient regionHealthAggregationPoliciesClient =
   *     RegionHealthAggregationPoliciesClient.create()) {
   *   DeleteRegionHealthAggregationPolicyRequest request =
   *       DeleteRegionHealthAggregationPolicyRequest.newBuilder()
   *           .setHealthAggregationPolicy("healthAggregationPolicy755484600")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       regionHealthAggregationPoliciesClient.deleteOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteRegionHealthAggregationPolicyRequest, Operation, Operation>
      deleteOperationCallable() {
    return stub.deleteOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified HealthAggregationPolicy in the given region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthAggregationPoliciesClient regionHealthAggregationPoliciesClient =
   *     RegionHealthAggregationPoliciesClient.create()) {
   *   DeleteRegionHealthAggregationPolicyRequest request =
   *       DeleteRegionHealthAggregationPolicyRequest.newBuilder()
   *           .setHealthAggregationPolicy("healthAggregationPolicy755484600")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       regionHealthAggregationPoliciesClient.deleteCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteRegionHealthAggregationPolicyRequest, Operation>
      deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified HealthAggregationPolicy resource in the given region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthAggregationPoliciesClient regionHealthAggregationPoliciesClient =
   *     RegionHealthAggregationPoliciesClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String healthAggregationPolicy = "healthAggregationPolicy755484600";
   *   HealthAggregationPolicy response =
   *       regionHealthAggregationPoliciesClient.get(project, region, healthAggregationPolicy);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param healthAggregationPolicy Name of the HealthAggregationPolicy resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HealthAggregationPolicy get(
      String project, String region, String healthAggregationPolicy) {
    GetRegionHealthAggregationPolicyRequest request =
        GetRegionHealthAggregationPolicyRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setHealthAggregationPolicy(healthAggregationPolicy)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified HealthAggregationPolicy resource in the given region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthAggregationPoliciesClient regionHealthAggregationPoliciesClient =
   *     RegionHealthAggregationPoliciesClient.create()) {
   *   GetRegionHealthAggregationPolicyRequest request =
   *       GetRegionHealthAggregationPolicyRequest.newBuilder()
   *           .setHealthAggregationPolicy("healthAggregationPolicy755484600")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .build();
   *   HealthAggregationPolicy response = regionHealthAggregationPoliciesClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HealthAggregationPolicy get(GetRegionHealthAggregationPolicyRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified HealthAggregationPolicy resource in the given region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthAggregationPoliciesClient regionHealthAggregationPoliciesClient =
   *     RegionHealthAggregationPoliciesClient.create()) {
   *   GetRegionHealthAggregationPolicyRequest request =
   *       GetRegionHealthAggregationPolicyRequest.newBuilder()
   *           .setHealthAggregationPolicy("healthAggregationPolicy755484600")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .build();
   *   ApiFuture<HealthAggregationPolicy> future =
   *       regionHealthAggregationPoliciesClient.getCallable().futureCall(request);
   *   // Do something.
   *   HealthAggregationPolicy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRegionHealthAggregationPolicyRequest, HealthAggregationPolicy>
      getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a HealthAggregationPolicy in the specified project in the given region using the
   * parameters that are included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthAggregationPoliciesClient regionHealthAggregationPoliciesClient =
   *     RegionHealthAggregationPoliciesClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   HealthAggregationPolicy healthAggregationPolicyResource =
   *       HealthAggregationPolicy.newBuilder().build();
   *   Operation response =
   *       regionHealthAggregationPoliciesClient
   *           .insertAsync(project, region, healthAggregationPolicyResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param healthAggregationPolicyResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> insertAsync(
      String project, String region, HealthAggregationPolicy healthAggregationPolicyResource) {
    InsertRegionHealthAggregationPolicyRequest request =
        InsertRegionHealthAggregationPolicyRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setHealthAggregationPolicyResource(healthAggregationPolicyResource)
            .build();
    return insertAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a HealthAggregationPolicy in the specified project in the given region using the
   * parameters that are included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthAggregationPoliciesClient regionHealthAggregationPoliciesClient =
   *     RegionHealthAggregationPoliciesClient.create()) {
   *   InsertRegionHealthAggregationPolicyRequest request =
   *       InsertRegionHealthAggregationPolicyRequest.newBuilder()
   *           .setHealthAggregationPolicyResource(HealthAggregationPolicy.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = regionHealthAggregationPoliciesClient.insertAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> insertAsync(
      InsertRegionHealthAggregationPolicyRequest request) {
    return insertOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a HealthAggregationPolicy in the specified project in the given region using the
   * parameters that are included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthAggregationPoliciesClient regionHealthAggregationPoliciesClient =
   *     RegionHealthAggregationPoliciesClient.create()) {
   *   InsertRegionHealthAggregationPolicyRequest request =
   *       InsertRegionHealthAggregationPolicyRequest.newBuilder()
   *           .setHealthAggregationPolicyResource(HealthAggregationPolicy.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       regionHealthAggregationPoliciesClient.insertOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<InsertRegionHealthAggregationPolicyRequest, Operation, Operation>
      insertOperationCallable() {
    return stub.insertOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a HealthAggregationPolicy in the specified project in the given region using the
   * parameters that are included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthAggregationPoliciesClient regionHealthAggregationPoliciesClient =
   *     RegionHealthAggregationPoliciesClient.create()) {
   *   InsertRegionHealthAggregationPolicyRequest request =
   *       InsertRegionHealthAggregationPolicyRequest.newBuilder()
   *           .setHealthAggregationPolicyResource(HealthAggregationPolicy.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       regionHealthAggregationPoliciesClient.insertCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<InsertRegionHealthAggregationPolicyRequest, Operation>
      insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the HealthAggregationPolicies for a project in the given region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthAggregationPoliciesClient regionHealthAggregationPoliciesClient =
   *     RegionHealthAggregationPoliciesClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   for (HealthAggregationPolicy element :
   *       regionHealthAggregationPoliciesClient.list(project, region).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project, String region) {
    ListRegionHealthAggregationPoliciesRequest request =
        ListRegionHealthAggregationPoliciesRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the HealthAggregationPolicies for a project in the given region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthAggregationPoliciesClient regionHealthAggregationPoliciesClient =
   *     RegionHealthAggregationPoliciesClient.create()) {
   *   ListRegionHealthAggregationPoliciesRequest request =
   *       ListRegionHealthAggregationPoliciesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   for (HealthAggregationPolicy element :
   *       regionHealthAggregationPoliciesClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListRegionHealthAggregationPoliciesRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the HealthAggregationPolicies for a project in the given region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthAggregationPoliciesClient regionHealthAggregationPoliciesClient =
   *     RegionHealthAggregationPoliciesClient.create()) {
   *   ListRegionHealthAggregationPoliciesRequest request =
   *       ListRegionHealthAggregationPoliciesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<HealthAggregationPolicy> future =
   *       regionHealthAggregationPoliciesClient.listPagedCallable().futureCall(request);
   *   // Do something.
   *   for (HealthAggregationPolicy element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListRegionHealthAggregationPoliciesRequest, ListPagedResponse>
      listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the HealthAggregationPolicies for a project in the given region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthAggregationPoliciesClient regionHealthAggregationPoliciesClient =
   *     RegionHealthAggregationPoliciesClient.create()) {
   *   ListRegionHealthAggregationPoliciesRequest request =
   *       ListRegionHealthAggregationPoliciesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   while (true) {
   *     HealthAggregationPolicyList response =
   *         regionHealthAggregationPoliciesClient.listCallable().call(request);
   *     for (HealthAggregationPolicy element : response.getItemsList()) {
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
  public final UnaryCallable<
          ListRegionHealthAggregationPoliciesRequest, HealthAggregationPolicyList>
      listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified regional HealthAggregationPolicy resource with the data included in the
   * request. This method supportsPATCH semantics and uses theJSON merge patch format and processing
   * rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthAggregationPoliciesClient regionHealthAggregationPoliciesClient =
   *     RegionHealthAggregationPoliciesClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String healthAggregationPolicy = "healthAggregationPolicy755484600";
   *   HealthAggregationPolicy healthAggregationPolicyResource =
   *       HealthAggregationPolicy.newBuilder().build();
   *   Operation response =
   *       regionHealthAggregationPoliciesClient
   *           .patchAsync(project, region, healthAggregationPolicy, healthAggregationPolicyResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param healthAggregationPolicy Name of the HealthAggregationPolicy to update. The name must be
   *     1-63 characters long, and comply with RFC1035.
   * @param healthAggregationPolicyResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> patchAsync(
      String project,
      String region,
      String healthAggregationPolicy,
      HealthAggregationPolicy healthAggregationPolicyResource) {
    PatchRegionHealthAggregationPolicyRequest request =
        PatchRegionHealthAggregationPolicyRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setHealthAggregationPolicy(healthAggregationPolicy)
            .setHealthAggregationPolicyResource(healthAggregationPolicyResource)
            .build();
    return patchAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified regional HealthAggregationPolicy resource with the data included in the
   * request. This method supportsPATCH semantics and uses theJSON merge patch format and processing
   * rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthAggregationPoliciesClient regionHealthAggregationPoliciesClient =
   *     RegionHealthAggregationPoliciesClient.create()) {
   *   PatchRegionHealthAggregationPolicyRequest request =
   *       PatchRegionHealthAggregationPolicyRequest.newBuilder()
   *           .setHealthAggregationPolicy("healthAggregationPolicy755484600")
   *           .setHealthAggregationPolicyResource(HealthAggregationPolicy.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = regionHealthAggregationPoliciesClient.patchAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> patchAsync(
      PatchRegionHealthAggregationPolicyRequest request) {
    return patchOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified regional HealthAggregationPolicy resource with the data included in the
   * request. This method supportsPATCH semantics and uses theJSON merge patch format and processing
   * rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthAggregationPoliciesClient regionHealthAggregationPoliciesClient =
   *     RegionHealthAggregationPoliciesClient.create()) {
   *   PatchRegionHealthAggregationPolicyRequest request =
   *       PatchRegionHealthAggregationPolicyRequest.newBuilder()
   *           .setHealthAggregationPolicy("healthAggregationPolicy755484600")
   *           .setHealthAggregationPolicyResource(HealthAggregationPolicy.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       regionHealthAggregationPoliciesClient.patchOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<PatchRegionHealthAggregationPolicyRequest, Operation, Operation>
      patchOperationCallable() {
    return stub.patchOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified regional HealthAggregationPolicy resource with the data included in the
   * request. This method supportsPATCH semantics and uses theJSON merge patch format and processing
   * rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthAggregationPoliciesClient regionHealthAggregationPoliciesClient =
   *     RegionHealthAggregationPoliciesClient.create()) {
   *   PatchRegionHealthAggregationPolicyRequest request =
   *       PatchRegionHealthAggregationPolicyRequest.newBuilder()
   *           .setHealthAggregationPolicy("healthAggregationPolicy755484600")
   *           .setHealthAggregationPolicyResource(HealthAggregationPolicy.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       regionHealthAggregationPoliciesClient.patchCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PatchRegionHealthAggregationPolicyRequest, Operation> patchCallable() {
    return stub.patchCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthAggregationPoliciesClient regionHealthAggregationPoliciesClient =
   *     RegionHealthAggregationPoliciesClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String resource = "resource-341064690";
   *   TestPermissionsRequest testPermissionsRequestResource =
   *       TestPermissionsRequest.newBuilder().build();
   *   TestPermissionsResponse response =
   *       regionHealthAggregationPoliciesClient.testIamPermissions(
   *           project, region, resource, testPermissionsRequestResource);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region The name of the region for this request.
   * @param resource Name or id of the resource for this request.
   * @param testPermissionsRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestPermissionsResponse testIamPermissions(
      String project,
      String region,
      String resource,
      TestPermissionsRequest testPermissionsRequestResource) {
    TestIamPermissionsRegionHealthAggregationPolicyRequest request =
        TestIamPermissionsRegionHealthAggregationPolicyRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setResource(resource)
            .setTestPermissionsRequestResource(testPermissionsRequestResource)
            .build();
    return testIamPermissions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthAggregationPoliciesClient regionHealthAggregationPoliciesClient =
   *     RegionHealthAggregationPoliciesClient.create()) {
   *   TestIamPermissionsRegionHealthAggregationPolicyRequest request =
   *       TestIamPermissionsRegionHealthAggregationPolicyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setResource("resource-341064690")
   *           .setTestPermissionsRequestResource(TestPermissionsRequest.newBuilder().build())
   *           .build();
   *   TestPermissionsResponse response =
   *       regionHealthAggregationPoliciesClient.testIamPermissions(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestPermissionsResponse testIamPermissions(
      TestIamPermissionsRegionHealthAggregationPolicyRequest request) {
    return testIamPermissionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthAggregationPoliciesClient regionHealthAggregationPoliciesClient =
   *     RegionHealthAggregationPoliciesClient.create()) {
   *   TestIamPermissionsRegionHealthAggregationPolicyRequest request =
   *       TestIamPermissionsRegionHealthAggregationPolicyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setResource("resource-341064690")
   *           .setTestPermissionsRequestResource(TestPermissionsRequest.newBuilder().build())
   *           .build();
   *   ApiFuture<TestPermissionsResponse> future =
   *       regionHealthAggregationPoliciesClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something.
   *   TestPermissionsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          TestIamPermissionsRegionHealthAggregationPolicyRequest, TestPermissionsResponse>
      testIamPermissionsCallable() {
    return stub.testIamPermissionsCallable();
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
          AggregatedListRegionHealthAggregationPoliciesRequest,
          HealthAggregationPolicyAggregatedList,
          Map.Entry<String, HealthAggregationPoliciesScopedList>,
          AggregatedListPage,
          AggregatedListFixedSizeCollection> {

    public static ApiFuture<AggregatedListPagedResponse> createAsync(
        PageContext<
                AggregatedListRegionHealthAggregationPoliciesRequest,
                HealthAggregationPolicyAggregatedList,
                Map.Entry<String, HealthAggregationPoliciesScopedList>>
            context,
        ApiFuture<HealthAggregationPolicyAggregatedList> futureResponse) {
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
          AggregatedListRegionHealthAggregationPoliciesRequest,
          HealthAggregationPolicyAggregatedList,
          Map.Entry<String, HealthAggregationPoliciesScopedList>,
          AggregatedListPage> {

    private AggregatedListPage(
        PageContext<
                AggregatedListRegionHealthAggregationPoliciesRequest,
                HealthAggregationPolicyAggregatedList,
                Map.Entry<String, HealthAggregationPoliciesScopedList>>
            context,
        HealthAggregationPolicyAggregatedList response) {
      super(context, response);
    }

    private static AggregatedListPage createEmptyPage() {
      return new AggregatedListPage(null, null);
    }

    @Override
    protected AggregatedListPage createPage(
        PageContext<
                AggregatedListRegionHealthAggregationPoliciesRequest,
                HealthAggregationPolicyAggregatedList,
                Map.Entry<String, HealthAggregationPoliciesScopedList>>
            context,
        HealthAggregationPolicyAggregatedList response) {
      return new AggregatedListPage(context, response);
    }

    @Override
    public ApiFuture<AggregatedListPage> createPageAsync(
        PageContext<
                AggregatedListRegionHealthAggregationPoliciesRequest,
                HealthAggregationPolicyAggregatedList,
                Map.Entry<String, HealthAggregationPoliciesScopedList>>
            context,
        ApiFuture<HealthAggregationPolicyAggregatedList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregatedListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AggregatedListRegionHealthAggregationPoliciesRequest,
          HealthAggregationPolicyAggregatedList,
          Map.Entry<String, HealthAggregationPoliciesScopedList>,
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

  public static class ListPagedResponse
      extends AbstractPagedListResponse<
          ListRegionHealthAggregationPoliciesRequest,
          HealthAggregationPolicyList,
          HealthAggregationPolicy,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<
                ListRegionHealthAggregationPoliciesRequest,
                HealthAggregationPolicyList,
                HealthAggregationPolicy>
            context,
        ApiFuture<HealthAggregationPolicyList> futureResponse) {
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
      extends AbstractPage<
          ListRegionHealthAggregationPoliciesRequest,
          HealthAggregationPolicyList,
          HealthAggregationPolicy,
          ListPage> {

    private ListPage(
        PageContext<
                ListRegionHealthAggregationPoliciesRequest,
                HealthAggregationPolicyList,
                HealthAggregationPolicy>
            context,
        HealthAggregationPolicyList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<
                ListRegionHealthAggregationPoliciesRequest,
                HealthAggregationPolicyList,
                HealthAggregationPolicy>
            context,
        HealthAggregationPolicyList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<
                ListRegionHealthAggregationPoliciesRequest,
                HealthAggregationPolicyList,
                HealthAggregationPolicy>
            context,
        ApiFuture<HealthAggregationPolicyList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRegionHealthAggregationPoliciesRequest,
          HealthAggregationPolicyList,
          HealthAggregationPolicy,
          ListPage,
          ListFixedSizeCollection> {

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
}
