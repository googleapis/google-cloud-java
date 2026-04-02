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
import com.google.cloud.compute.v1.stub.RegionHealthSourcesStub;
import com.google.cloud.compute.v1.stub.RegionHealthSourcesStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The RegionHealthSources API.
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
 * try (RegionHealthSourcesClient regionHealthSourcesClient = RegionHealthSourcesClient.create()) {
 *   String project = "project-309310695";
 *   String region = "region-934795532";
 *   String healthSource = "healthSource513679767";
 *   HealthSource response = regionHealthSourcesClient.get(project, region, healthSource);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the RegionHealthSourcesClient object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
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
 *      <td><p> Retrieves the list of all HealthSource resources (all regional) available to the specified project.
 * <p>  To prevent failure, Google recommends that you set the `returnPartialSuccess` parameter to `true`.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> aggregatedList(AggregatedListRegionHealthSourcesRequest request)
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
 *      <td><p> Deletes the specified HealthSource in the given region</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteAsync(DeleteRegionHealthSourceRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteAsync(String project, String region, String healthSource)
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
 *      <td><p> Returns the specified HealthSource resource in the given region.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> get(GetRegionHealthSourceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> get(String project, String region, String healthSource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Insert</td>
 *      <td><p> Create a HealthSource in the specified project in the given region using the parameters that are included in the request.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> insertAsync(InsertRegionHealthSourceRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> insertAsync(String project, String region, HealthSource healthSourceResource)
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
 *      <td><p> Lists the HealthSources for a project in the given region.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> list(ListRegionHealthSourcesRequest request)
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
 *      <td><p> Updates the specified regional HealthSource resource with the data included in the request.  This method supportsPATCH semantics and uses theJSON merge patch format and processing rules.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> patchAsync(PatchRegionHealthSourceRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> patchAsync(String project, String region, String healthSource, HealthSource healthSourceResource)
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
 *           <li><p> testIamPermissions(TestIamPermissionsRegionHealthSourceRequest request)
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
 * <p>This class can be customized by passing in a custom instance of RegionHealthSourcesSettings to
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
 * RegionHealthSourcesSettings regionHealthSourcesSettings =
 *     RegionHealthSourcesSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * RegionHealthSourcesClient regionHealthSourcesClient =
 *     RegionHealthSourcesClient.create(regionHealthSourcesSettings);
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
 * RegionHealthSourcesSettings regionHealthSourcesSettings =
 *     RegionHealthSourcesSettings.newBuilder().setEndpoint(myEndpoint).build();
 * RegionHealthSourcesClient regionHealthSourcesClient =
 *     RegionHealthSourcesClient.create(regionHealthSourcesSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class RegionHealthSourcesClient implements BackgroundResource {
  private final RegionHealthSourcesSettings settings;
  private final RegionHealthSourcesStub stub;

  /** Constructs an instance of RegionHealthSourcesClient with default settings. */
  public static final RegionHealthSourcesClient create() throws IOException {
    return create(RegionHealthSourcesSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of RegionHealthSourcesClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final RegionHealthSourcesClient create(RegionHealthSourcesSettings settings)
      throws IOException {
    return new RegionHealthSourcesClient(settings);
  }

  /**
   * Constructs an instance of RegionHealthSourcesClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(RegionHealthSourcesSettings).
   */
  public static final RegionHealthSourcesClient create(RegionHealthSourcesStub stub) {
    return new RegionHealthSourcesClient(stub);
  }

  /**
   * Constructs an instance of RegionHealthSourcesClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected RegionHealthSourcesClient(RegionHealthSourcesSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((RegionHealthSourcesStubSettings) settings.getStubSettings()).createStub();
  }

  protected RegionHealthSourcesClient(RegionHealthSourcesStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final RegionHealthSourcesSettings getSettings() {
    return settings;
  }

  public RegionHealthSourcesStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of all HealthSource resources (all regional) available to the specified
   * project.
   *
   * <p>To prevent failure, Google recommends that you set the `returnPartialSuccess` parameter to
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
   * try (RegionHealthSourcesClient regionHealthSourcesClient = RegionHealthSourcesClient.create()) {
   *   String project = "project-309310695";
   *   for (Map.Entry<String, HealthSourcesScopedList> element :
   *       regionHealthSourcesClient.aggregatedList(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Name of the project scoping this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(String project) {
    AggregatedListRegionHealthSourcesRequest request =
        AggregatedListRegionHealthSourcesRequest.newBuilder().setProject(project).build();
    return aggregatedList(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of all HealthSource resources (all regional) available to the specified
   * project.
   *
   * <p>To prevent failure, Google recommends that you set the `returnPartialSuccess` parameter to
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
   * try (RegionHealthSourcesClient regionHealthSourcesClient = RegionHealthSourcesClient.create()) {
   *   AggregatedListRegionHealthSourcesRequest request =
   *       AggregatedListRegionHealthSourcesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setIncludeAllScopes(true)
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .setServiceProjectNumber(-1293855239)
   *           .build();
   *   for (Map.Entry<String, HealthSourcesScopedList> element :
   *       regionHealthSourcesClient.aggregatedList(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(
      AggregatedListRegionHealthSourcesRequest request) {
    return aggregatedListPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of all HealthSource resources (all regional) available to the specified
   * project.
   *
   * <p>To prevent failure, Google recommends that you set the `returnPartialSuccess` parameter to
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
   * try (RegionHealthSourcesClient regionHealthSourcesClient = RegionHealthSourcesClient.create()) {
   *   AggregatedListRegionHealthSourcesRequest request =
   *       AggregatedListRegionHealthSourcesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setIncludeAllScopes(true)
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .setServiceProjectNumber(-1293855239)
   *           .build();
   *   ApiFuture<Map.Entry<String, HealthSourcesScopedList>> future =
   *       regionHealthSourcesClient.aggregatedListPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Map.Entry<String, HealthSourcesScopedList> element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<AggregatedListRegionHealthSourcesRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return stub.aggregatedListPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of all HealthSource resources (all regional) available to the specified
   * project.
   *
   * <p>To prevent failure, Google recommends that you set the `returnPartialSuccess` parameter to
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
   * try (RegionHealthSourcesClient regionHealthSourcesClient = RegionHealthSourcesClient.create()) {
   *   AggregatedListRegionHealthSourcesRequest request =
   *       AggregatedListRegionHealthSourcesRequest.newBuilder()
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
   *     HealthSourceAggregatedList response =
   *         regionHealthSourcesClient.aggregatedListCallable().call(request);
   *     for (Map.Entry<String, HealthSourcesScopedList> element : response.getItemsList()) {
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
  public final UnaryCallable<AggregatedListRegionHealthSourcesRequest, HealthSourceAggregatedList>
      aggregatedListCallable() {
    return stub.aggregatedListCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified HealthSource in the given region
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthSourcesClient regionHealthSourcesClient = RegionHealthSourcesClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String healthSource = "healthSource513679767";
   *   Operation response =
   *       regionHealthSourcesClient.deleteAsync(project, region, healthSource).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param healthSource Name of the HealthSource resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> deleteAsync(
      String project, String region, String healthSource) {
    DeleteRegionHealthSourceRequest request =
        DeleteRegionHealthSourceRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setHealthSource(healthSource)
            .build();
    return deleteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified HealthSource in the given region
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthSourcesClient regionHealthSourcesClient = RegionHealthSourcesClient.create()) {
   *   DeleteRegionHealthSourceRequest request =
   *       DeleteRegionHealthSourceRequest.newBuilder()
   *           .setHealthSource("healthSource513679767")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = regionHealthSourcesClient.deleteAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> deleteAsync(
      DeleteRegionHealthSourceRequest request) {
    return deleteOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified HealthSource in the given region
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthSourcesClient regionHealthSourcesClient = RegionHealthSourcesClient.create()) {
   *   DeleteRegionHealthSourceRequest request =
   *       DeleteRegionHealthSourceRequest.newBuilder()
   *           .setHealthSource("healthSource513679767")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       regionHealthSourcesClient.deleteOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteRegionHealthSourceRequest, Operation, Operation>
      deleteOperationCallable() {
    return stub.deleteOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified HealthSource in the given region
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthSourcesClient regionHealthSourcesClient = RegionHealthSourcesClient.create()) {
   *   DeleteRegionHealthSourceRequest request =
   *       DeleteRegionHealthSourceRequest.newBuilder()
   *           .setHealthSource("healthSource513679767")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = regionHealthSourcesClient.deleteCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteRegionHealthSourceRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified HealthSource resource in the given region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthSourcesClient regionHealthSourcesClient = RegionHealthSourcesClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String healthSource = "healthSource513679767";
   *   HealthSource response = regionHealthSourcesClient.get(project, region, healthSource);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param healthSource Name of the HealthSource resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HealthSource get(String project, String region, String healthSource) {
    GetRegionHealthSourceRequest request =
        GetRegionHealthSourceRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setHealthSource(healthSource)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified HealthSource resource in the given region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthSourcesClient regionHealthSourcesClient = RegionHealthSourcesClient.create()) {
   *   GetRegionHealthSourceRequest request =
   *       GetRegionHealthSourceRequest.newBuilder()
   *           .setHealthSource("healthSource513679767")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .build();
   *   HealthSource response = regionHealthSourcesClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HealthSource get(GetRegionHealthSourceRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified HealthSource resource in the given region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthSourcesClient regionHealthSourcesClient = RegionHealthSourcesClient.create()) {
   *   GetRegionHealthSourceRequest request =
   *       GetRegionHealthSourceRequest.newBuilder()
   *           .setHealthSource("healthSource513679767")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .build();
   *   ApiFuture<HealthSource> future = regionHealthSourcesClient.getCallable().futureCall(request);
   *   // Do something.
   *   HealthSource response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRegionHealthSourceRequest, HealthSource> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a HealthSource in the specified project in the given region using the parameters that
   * are included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthSourcesClient regionHealthSourcesClient = RegionHealthSourcesClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   HealthSource healthSourceResource = HealthSource.newBuilder().build();
   *   Operation response =
   *       regionHealthSourcesClient.insertAsync(project, region, healthSourceResource).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param healthSourceResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> insertAsync(
      String project, String region, HealthSource healthSourceResource) {
    InsertRegionHealthSourceRequest request =
        InsertRegionHealthSourceRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setHealthSourceResource(healthSourceResource)
            .build();
    return insertAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a HealthSource in the specified project in the given region using the parameters that
   * are included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthSourcesClient regionHealthSourcesClient = RegionHealthSourcesClient.create()) {
   *   InsertRegionHealthSourceRequest request =
   *       InsertRegionHealthSourceRequest.newBuilder()
   *           .setHealthSourceResource(HealthSource.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = regionHealthSourcesClient.insertAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> insertAsync(
      InsertRegionHealthSourceRequest request) {
    return insertOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a HealthSource in the specified project in the given region using the parameters that
   * are included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthSourcesClient regionHealthSourcesClient = RegionHealthSourcesClient.create()) {
   *   InsertRegionHealthSourceRequest request =
   *       InsertRegionHealthSourceRequest.newBuilder()
   *           .setHealthSourceResource(HealthSource.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       regionHealthSourcesClient.insertOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<InsertRegionHealthSourceRequest, Operation, Operation>
      insertOperationCallable() {
    return stub.insertOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a HealthSource in the specified project in the given region using the parameters that
   * are included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthSourcesClient regionHealthSourcesClient = RegionHealthSourcesClient.create()) {
   *   InsertRegionHealthSourceRequest request =
   *       InsertRegionHealthSourceRequest.newBuilder()
   *           .setHealthSourceResource(HealthSource.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = regionHealthSourcesClient.insertCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<InsertRegionHealthSourceRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the HealthSources for a project in the given region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthSourcesClient regionHealthSourcesClient = RegionHealthSourcesClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   for (HealthSource element : regionHealthSourcesClient.list(project, region).iterateAll()) {
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
    ListRegionHealthSourcesRequest request =
        ListRegionHealthSourcesRequest.newBuilder().setProject(project).setRegion(region).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the HealthSources for a project in the given region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthSourcesClient regionHealthSourcesClient = RegionHealthSourcesClient.create()) {
   *   ListRegionHealthSourcesRequest request =
   *       ListRegionHealthSourcesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   for (HealthSource element : regionHealthSourcesClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListRegionHealthSourcesRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the HealthSources for a project in the given region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthSourcesClient regionHealthSourcesClient = RegionHealthSourcesClient.create()) {
   *   ListRegionHealthSourcesRequest request =
   *       ListRegionHealthSourcesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<HealthSource> future =
   *       regionHealthSourcesClient.listPagedCallable().futureCall(request);
   *   // Do something.
   *   for (HealthSource element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListRegionHealthSourcesRequest, ListPagedResponse>
      listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the HealthSources for a project in the given region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthSourcesClient regionHealthSourcesClient = RegionHealthSourcesClient.create()) {
   *   ListRegionHealthSourcesRequest request =
   *       ListRegionHealthSourcesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   while (true) {
   *     HealthSourceList response = regionHealthSourcesClient.listCallable().call(request);
   *     for (HealthSource element : response.getItemsList()) {
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
  public final UnaryCallable<ListRegionHealthSourcesRequest, HealthSourceList> listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified regional HealthSource resource with the data included in the request.
   * This method supportsPATCH semantics and uses theJSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthSourcesClient regionHealthSourcesClient = RegionHealthSourcesClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String healthSource = "healthSource513679767";
   *   HealthSource healthSourceResource = HealthSource.newBuilder().build();
   *   Operation response =
   *       regionHealthSourcesClient
   *           .patchAsync(project, region, healthSource, healthSourceResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param healthSource Name of the HealthSource to update. The name must be 1-63 characters long,
   *     and comply with RFC1035.
   * @param healthSourceResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> patchAsync(
      String project, String region, String healthSource, HealthSource healthSourceResource) {
    PatchRegionHealthSourceRequest request =
        PatchRegionHealthSourceRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setHealthSource(healthSource)
            .setHealthSourceResource(healthSourceResource)
            .build();
    return patchAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified regional HealthSource resource with the data included in the request.
   * This method supportsPATCH semantics and uses theJSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthSourcesClient regionHealthSourcesClient = RegionHealthSourcesClient.create()) {
   *   PatchRegionHealthSourceRequest request =
   *       PatchRegionHealthSourceRequest.newBuilder()
   *           .setHealthSource("healthSource513679767")
   *           .setHealthSourceResource(HealthSource.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = regionHealthSourcesClient.patchAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> patchAsync(
      PatchRegionHealthSourceRequest request) {
    return patchOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified regional HealthSource resource with the data included in the request.
   * This method supportsPATCH semantics and uses theJSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthSourcesClient regionHealthSourcesClient = RegionHealthSourcesClient.create()) {
   *   PatchRegionHealthSourceRequest request =
   *       PatchRegionHealthSourceRequest.newBuilder()
   *           .setHealthSource("healthSource513679767")
   *           .setHealthSourceResource(HealthSource.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       regionHealthSourcesClient.patchOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<PatchRegionHealthSourceRequest, Operation, Operation>
      patchOperationCallable() {
    return stub.patchOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified regional HealthSource resource with the data included in the request.
   * This method supportsPATCH semantics and uses theJSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthSourcesClient regionHealthSourcesClient = RegionHealthSourcesClient.create()) {
   *   PatchRegionHealthSourceRequest request =
   *       PatchRegionHealthSourceRequest.newBuilder()
   *           .setHealthSource("healthSource513679767")
   *           .setHealthSourceResource(HealthSource.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = regionHealthSourcesClient.patchCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PatchRegionHealthSourceRequest, Operation> patchCallable() {
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
   * try (RegionHealthSourcesClient regionHealthSourcesClient = RegionHealthSourcesClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String resource = "resource-341064690";
   *   TestPermissionsRequest testPermissionsRequestResource =
   *       TestPermissionsRequest.newBuilder().build();
   *   TestPermissionsResponse response =
   *       regionHealthSourcesClient.testIamPermissions(
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
    TestIamPermissionsRegionHealthSourceRequest request =
        TestIamPermissionsRegionHealthSourceRequest.newBuilder()
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
   * try (RegionHealthSourcesClient regionHealthSourcesClient = RegionHealthSourcesClient.create()) {
   *   TestIamPermissionsRegionHealthSourceRequest request =
   *       TestIamPermissionsRegionHealthSourceRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setResource("resource-341064690")
   *           .setTestPermissionsRequestResource(TestPermissionsRequest.newBuilder().build())
   *           .build();
   *   TestPermissionsResponse response = regionHealthSourcesClient.testIamPermissions(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestPermissionsResponse testIamPermissions(
      TestIamPermissionsRegionHealthSourceRequest request) {
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
   * try (RegionHealthSourcesClient regionHealthSourcesClient = RegionHealthSourcesClient.create()) {
   *   TestIamPermissionsRegionHealthSourceRequest request =
   *       TestIamPermissionsRegionHealthSourceRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setResource("resource-341064690")
   *           .setTestPermissionsRequestResource(TestPermissionsRequest.newBuilder().build())
   *           .build();
   *   ApiFuture<TestPermissionsResponse> future =
   *       regionHealthSourcesClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something.
   *   TestPermissionsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TestIamPermissionsRegionHealthSourceRequest, TestPermissionsResponse>
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
          AggregatedListRegionHealthSourcesRequest,
          HealthSourceAggregatedList,
          Map.Entry<String, HealthSourcesScopedList>,
          AggregatedListPage,
          AggregatedListFixedSizeCollection> {

    public static ApiFuture<AggregatedListPagedResponse> createAsync(
        PageContext<
                AggregatedListRegionHealthSourcesRequest,
                HealthSourceAggregatedList,
                Map.Entry<String, HealthSourcesScopedList>>
            context,
        ApiFuture<HealthSourceAggregatedList> futureResponse) {
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
          AggregatedListRegionHealthSourcesRequest,
          HealthSourceAggregatedList,
          Map.Entry<String, HealthSourcesScopedList>,
          AggregatedListPage> {

    private AggregatedListPage(
        PageContext<
                AggregatedListRegionHealthSourcesRequest,
                HealthSourceAggregatedList,
                Map.Entry<String, HealthSourcesScopedList>>
            context,
        HealthSourceAggregatedList response) {
      super(context, response);
    }

    private static AggregatedListPage createEmptyPage() {
      return new AggregatedListPage(null, null);
    }

    @Override
    protected AggregatedListPage createPage(
        PageContext<
                AggregatedListRegionHealthSourcesRequest,
                HealthSourceAggregatedList,
                Map.Entry<String, HealthSourcesScopedList>>
            context,
        HealthSourceAggregatedList response) {
      return new AggregatedListPage(context, response);
    }

    @Override
    public ApiFuture<AggregatedListPage> createPageAsync(
        PageContext<
                AggregatedListRegionHealthSourcesRequest,
                HealthSourceAggregatedList,
                Map.Entry<String, HealthSourcesScopedList>>
            context,
        ApiFuture<HealthSourceAggregatedList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregatedListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AggregatedListRegionHealthSourcesRequest,
          HealthSourceAggregatedList,
          Map.Entry<String, HealthSourcesScopedList>,
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
          ListRegionHealthSourcesRequest,
          HealthSourceList,
          HealthSource,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListRegionHealthSourcesRequest, HealthSourceList, HealthSource> context,
        ApiFuture<HealthSourceList> futureResponse) {
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
          ListRegionHealthSourcesRequest, HealthSourceList, HealthSource, ListPage> {

    private ListPage(
        PageContext<ListRegionHealthSourcesRequest, HealthSourceList, HealthSource> context,
        HealthSourceList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListRegionHealthSourcesRequest, HealthSourceList, HealthSource> context,
        HealthSourceList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListRegionHealthSourcesRequest, HealthSourceList, HealthSource> context,
        ApiFuture<HealthSourceList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRegionHealthSourcesRequest,
          HealthSourceList,
          HealthSource,
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
