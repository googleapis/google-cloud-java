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
import com.google.cloud.compute.v1.stub.RegionCompositeHealthChecksStub;
import com.google.cloud.compute.v1.stub.RegionCompositeHealthChecksStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The RegionCompositeHealthChecks API.
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
 * try (RegionCompositeHealthChecksClient regionCompositeHealthChecksClient =
 *     RegionCompositeHealthChecksClient.create()) {
 *   String project = "project-309310695";
 *   String region = "region-934795532";
 *   String compositeHealthCheck = "compositeHealthCheck-1727645947";
 *   CompositeHealthCheck response =
 *       regionCompositeHealthChecksClient.get(project, region, compositeHealthCheck);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the RegionCompositeHealthChecksClient object to clean up
 * resources such as threads. In the example above, try-with-resources is used, which automatically
 * calls close().
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
 *      <td><p> Retrieves the list of all CompositeHealthCheck resources (all regional) available to the specified project.
 * <p>  To prevent failure, it is recommended that you set the `returnPartialSuccess` parameter to `true`.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> aggregatedList(AggregatedListRegionCompositeHealthChecksRequest request)
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
 *      <td><p> Deletes the specified CompositeHealthCheck in the given region</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteAsync(DeleteRegionCompositeHealthCheckRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteAsync(String project, String region, String compositeHealthCheck)
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
 *      <td><p> Returns the specified CompositeHealthCheck resource in the given region.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> get(GetRegionCompositeHealthCheckRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> get(String project, String region, String compositeHealthCheck)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetHealth</td>
 *      <td><p> Gets the most recent health check results for this regional CompositeHealthCheck.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getHealth(GetHealthRegionCompositeHealthCheckRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getHealth(String project, String region, String compositeHealthCheck)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getHealthCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Insert</td>
 *      <td><p> Create a CompositeHealthCheck in the specified project in the given region using the parameters that are included in the request.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> insertAsync(InsertRegionCompositeHealthCheckRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> insertAsync(String project, String region, CompositeHealthCheck compositeHealthCheckResource)
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
 *      <td><p> Lists the CompositeHealthChecks for a project in the given region.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> list(ListRegionCompositeHealthChecksRequest request)
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
 *      <td><p> Updates the specified regional CompositeHealthCheck resource with the data included in the request.  This method supportsPATCH semantics and uses theJSON merge patch format and processing rules.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> patchAsync(PatchRegionCompositeHealthCheckRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> patchAsync(String project, String region, String compositeHealthCheck, CompositeHealthCheck compositeHealthCheckResource)
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
 *           <li><p> testIamPermissions(TestIamPermissionsRegionCompositeHealthCheckRequest request)
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
 * RegionCompositeHealthChecksSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * RegionCompositeHealthChecksSettings regionCompositeHealthChecksSettings =
 *     RegionCompositeHealthChecksSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * RegionCompositeHealthChecksClient regionCompositeHealthChecksClient =
 *     RegionCompositeHealthChecksClient.create(regionCompositeHealthChecksSettings);
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
 * RegionCompositeHealthChecksSettings regionCompositeHealthChecksSettings =
 *     RegionCompositeHealthChecksSettings.newBuilder().setEndpoint(myEndpoint).build();
 * RegionCompositeHealthChecksClient regionCompositeHealthChecksClient =
 *     RegionCompositeHealthChecksClient.create(regionCompositeHealthChecksSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class RegionCompositeHealthChecksClient implements BackgroundResource {
  private final RegionCompositeHealthChecksSettings settings;
  private final RegionCompositeHealthChecksStub stub;

  /** Constructs an instance of RegionCompositeHealthChecksClient with default settings. */
  public static final RegionCompositeHealthChecksClient create() throws IOException {
    return create(RegionCompositeHealthChecksSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of RegionCompositeHealthChecksClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final RegionCompositeHealthChecksClient create(
      RegionCompositeHealthChecksSettings settings) throws IOException {
    return new RegionCompositeHealthChecksClient(settings);
  }

  /**
   * Constructs an instance of RegionCompositeHealthChecksClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(RegionCompositeHealthChecksSettings).
   */
  public static final RegionCompositeHealthChecksClient create(
      RegionCompositeHealthChecksStub stub) {
    return new RegionCompositeHealthChecksClient(stub);
  }

  /**
   * Constructs an instance of RegionCompositeHealthChecksClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected RegionCompositeHealthChecksClient(RegionCompositeHealthChecksSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((RegionCompositeHealthChecksStubSettings) settings.getStubSettings()).createStub();
  }

  protected RegionCompositeHealthChecksClient(RegionCompositeHealthChecksStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final RegionCompositeHealthChecksSettings getSettings() {
    return settings;
  }

  public RegionCompositeHealthChecksStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of all CompositeHealthCheck resources (all regional) available to the
   * specified project.
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
   * try (RegionCompositeHealthChecksClient regionCompositeHealthChecksClient =
   *     RegionCompositeHealthChecksClient.create()) {
   *   String project = "project-309310695";
   *   for (Map.Entry<String, CompositeHealthChecksScopedList> element :
   *       regionCompositeHealthChecksClient.aggregatedList(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Name of the project scoping this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(String project) {
    AggregatedListRegionCompositeHealthChecksRequest request =
        AggregatedListRegionCompositeHealthChecksRequest.newBuilder().setProject(project).build();
    return aggregatedList(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of all CompositeHealthCheck resources (all regional) available to the
   * specified project.
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
   * try (RegionCompositeHealthChecksClient regionCompositeHealthChecksClient =
   *     RegionCompositeHealthChecksClient.create()) {
   *   AggregatedListRegionCompositeHealthChecksRequest request =
   *       AggregatedListRegionCompositeHealthChecksRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setIncludeAllScopes(true)
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .setServiceProjectNumber(-1293855239)
   *           .build();
   *   for (Map.Entry<String, CompositeHealthChecksScopedList> element :
   *       regionCompositeHealthChecksClient.aggregatedList(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(
      AggregatedListRegionCompositeHealthChecksRequest request) {
    return aggregatedListPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of all CompositeHealthCheck resources (all regional) available to the
   * specified project.
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
   * try (RegionCompositeHealthChecksClient regionCompositeHealthChecksClient =
   *     RegionCompositeHealthChecksClient.create()) {
   *   AggregatedListRegionCompositeHealthChecksRequest request =
   *       AggregatedListRegionCompositeHealthChecksRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setIncludeAllScopes(true)
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .setServiceProjectNumber(-1293855239)
   *           .build();
   *   ApiFuture<Map.Entry<String, CompositeHealthChecksScopedList>> future =
   *       regionCompositeHealthChecksClient.aggregatedListPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Map.Entry<String, CompositeHealthChecksScopedList> element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          AggregatedListRegionCompositeHealthChecksRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return stub.aggregatedListPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of all CompositeHealthCheck resources (all regional) available to the
   * specified project.
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
   * try (RegionCompositeHealthChecksClient regionCompositeHealthChecksClient =
   *     RegionCompositeHealthChecksClient.create()) {
   *   AggregatedListRegionCompositeHealthChecksRequest request =
   *       AggregatedListRegionCompositeHealthChecksRequest.newBuilder()
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
   *     CompositeHealthCheckAggregatedList response =
   *         regionCompositeHealthChecksClient.aggregatedListCallable().call(request);
   *     for (Map.Entry<String, CompositeHealthChecksScopedList> element : response.getItemsList()) {
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
          AggregatedListRegionCompositeHealthChecksRequest, CompositeHealthCheckAggregatedList>
      aggregatedListCallable() {
    return stub.aggregatedListCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified CompositeHealthCheck in the given region
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionCompositeHealthChecksClient regionCompositeHealthChecksClient =
   *     RegionCompositeHealthChecksClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String compositeHealthCheck = "compositeHealthCheck-1727645947";
   *   Operation response =
   *       regionCompositeHealthChecksClient
   *           .deleteAsync(project, region, compositeHealthCheck)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param compositeHealthCheck Name of the CompositeHealthCheck resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> deleteAsync(
      String project, String region, String compositeHealthCheck) {
    DeleteRegionCompositeHealthCheckRequest request =
        DeleteRegionCompositeHealthCheckRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setCompositeHealthCheck(compositeHealthCheck)
            .build();
    return deleteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified CompositeHealthCheck in the given region
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionCompositeHealthChecksClient regionCompositeHealthChecksClient =
   *     RegionCompositeHealthChecksClient.create()) {
   *   DeleteRegionCompositeHealthCheckRequest request =
   *       DeleteRegionCompositeHealthCheckRequest.newBuilder()
   *           .setCompositeHealthCheck("compositeHealthCheck-1727645947")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = regionCompositeHealthChecksClient.deleteAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> deleteAsync(
      DeleteRegionCompositeHealthCheckRequest request) {
    return deleteOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified CompositeHealthCheck in the given region
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionCompositeHealthChecksClient regionCompositeHealthChecksClient =
   *     RegionCompositeHealthChecksClient.create()) {
   *   DeleteRegionCompositeHealthCheckRequest request =
   *       DeleteRegionCompositeHealthCheckRequest.newBuilder()
   *           .setCompositeHealthCheck("compositeHealthCheck-1727645947")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       regionCompositeHealthChecksClient.deleteOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteRegionCompositeHealthCheckRequest, Operation, Operation>
      deleteOperationCallable() {
    return stub.deleteOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified CompositeHealthCheck in the given region
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionCompositeHealthChecksClient regionCompositeHealthChecksClient =
   *     RegionCompositeHealthChecksClient.create()) {
   *   DeleteRegionCompositeHealthCheckRequest request =
   *       DeleteRegionCompositeHealthCheckRequest.newBuilder()
   *           .setCompositeHealthCheck("compositeHealthCheck-1727645947")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       regionCompositeHealthChecksClient.deleteCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteRegionCompositeHealthCheckRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified CompositeHealthCheck resource in the given region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionCompositeHealthChecksClient regionCompositeHealthChecksClient =
   *     RegionCompositeHealthChecksClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String compositeHealthCheck = "compositeHealthCheck-1727645947";
   *   CompositeHealthCheck response =
   *       regionCompositeHealthChecksClient.get(project, region, compositeHealthCheck);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param compositeHealthCheck Name of the CompositeHealthCheck resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CompositeHealthCheck get(
      String project, String region, String compositeHealthCheck) {
    GetRegionCompositeHealthCheckRequest request =
        GetRegionCompositeHealthCheckRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setCompositeHealthCheck(compositeHealthCheck)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified CompositeHealthCheck resource in the given region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionCompositeHealthChecksClient regionCompositeHealthChecksClient =
   *     RegionCompositeHealthChecksClient.create()) {
   *   GetRegionCompositeHealthCheckRequest request =
   *       GetRegionCompositeHealthCheckRequest.newBuilder()
   *           .setCompositeHealthCheck("compositeHealthCheck-1727645947")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .build();
   *   CompositeHealthCheck response = regionCompositeHealthChecksClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CompositeHealthCheck get(GetRegionCompositeHealthCheckRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified CompositeHealthCheck resource in the given region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionCompositeHealthChecksClient regionCompositeHealthChecksClient =
   *     RegionCompositeHealthChecksClient.create()) {
   *   GetRegionCompositeHealthCheckRequest request =
   *       GetRegionCompositeHealthCheckRequest.newBuilder()
   *           .setCompositeHealthCheck("compositeHealthCheck-1727645947")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .build();
   *   ApiFuture<CompositeHealthCheck> future =
   *       regionCompositeHealthChecksClient.getCallable().futureCall(request);
   *   // Do something.
   *   CompositeHealthCheck response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRegionCompositeHealthCheckRequest, CompositeHealthCheck>
      getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the most recent health check results for this regional CompositeHealthCheck.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionCompositeHealthChecksClient regionCompositeHealthChecksClient =
   *     RegionCompositeHealthChecksClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String compositeHealthCheck = "compositeHealthCheck-1727645947";
   *   CompositeHealthCheckHealth response =
   *       regionCompositeHealthChecksClient.getHealth(project, region, compositeHealthCheck);
   * }
   * }</pre>
   *
   * @param project Name of the project scoping this request.
   * @param region Name of the region scoping this request.
   * @param compositeHealthCheck Name of the CompositeHealthCheck resource to get health for.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CompositeHealthCheckHealth getHealth(
      String project, String region, String compositeHealthCheck) {
    GetHealthRegionCompositeHealthCheckRequest request =
        GetHealthRegionCompositeHealthCheckRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setCompositeHealthCheck(compositeHealthCheck)
            .build();
    return getHealth(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the most recent health check results for this regional CompositeHealthCheck.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionCompositeHealthChecksClient regionCompositeHealthChecksClient =
   *     RegionCompositeHealthChecksClient.create()) {
   *   GetHealthRegionCompositeHealthCheckRequest request =
   *       GetHealthRegionCompositeHealthCheckRequest.newBuilder()
   *           .setCompositeHealthCheck("compositeHealthCheck-1727645947")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .build();
   *   CompositeHealthCheckHealth response = regionCompositeHealthChecksClient.getHealth(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CompositeHealthCheckHealth getHealth(
      GetHealthRegionCompositeHealthCheckRequest request) {
    return getHealthCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the most recent health check results for this regional CompositeHealthCheck.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionCompositeHealthChecksClient regionCompositeHealthChecksClient =
   *     RegionCompositeHealthChecksClient.create()) {
   *   GetHealthRegionCompositeHealthCheckRequest request =
   *       GetHealthRegionCompositeHealthCheckRequest.newBuilder()
   *           .setCompositeHealthCheck("compositeHealthCheck-1727645947")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .build();
   *   ApiFuture<CompositeHealthCheckHealth> future =
   *       regionCompositeHealthChecksClient.getHealthCallable().futureCall(request);
   *   // Do something.
   *   CompositeHealthCheckHealth response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetHealthRegionCompositeHealthCheckRequest, CompositeHealthCheckHealth>
      getHealthCallable() {
    return stub.getHealthCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a CompositeHealthCheck in the specified project in the given region using the parameters
   * that are included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionCompositeHealthChecksClient regionCompositeHealthChecksClient =
   *     RegionCompositeHealthChecksClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   CompositeHealthCheck compositeHealthCheckResource = CompositeHealthCheck.newBuilder().build();
   *   Operation response =
   *       regionCompositeHealthChecksClient
   *           .insertAsync(project, region, compositeHealthCheckResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param compositeHealthCheckResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> insertAsync(
      String project, String region, CompositeHealthCheck compositeHealthCheckResource) {
    InsertRegionCompositeHealthCheckRequest request =
        InsertRegionCompositeHealthCheckRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setCompositeHealthCheckResource(compositeHealthCheckResource)
            .build();
    return insertAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a CompositeHealthCheck in the specified project in the given region using the parameters
   * that are included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionCompositeHealthChecksClient regionCompositeHealthChecksClient =
   *     RegionCompositeHealthChecksClient.create()) {
   *   InsertRegionCompositeHealthCheckRequest request =
   *       InsertRegionCompositeHealthCheckRequest.newBuilder()
   *           .setCompositeHealthCheckResource(CompositeHealthCheck.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = regionCompositeHealthChecksClient.insertAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> insertAsync(
      InsertRegionCompositeHealthCheckRequest request) {
    return insertOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a CompositeHealthCheck in the specified project in the given region using the parameters
   * that are included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionCompositeHealthChecksClient regionCompositeHealthChecksClient =
   *     RegionCompositeHealthChecksClient.create()) {
   *   InsertRegionCompositeHealthCheckRequest request =
   *       InsertRegionCompositeHealthCheckRequest.newBuilder()
   *           .setCompositeHealthCheckResource(CompositeHealthCheck.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       regionCompositeHealthChecksClient.insertOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<InsertRegionCompositeHealthCheckRequest, Operation, Operation>
      insertOperationCallable() {
    return stub.insertOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a CompositeHealthCheck in the specified project in the given region using the parameters
   * that are included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionCompositeHealthChecksClient regionCompositeHealthChecksClient =
   *     RegionCompositeHealthChecksClient.create()) {
   *   InsertRegionCompositeHealthCheckRequest request =
   *       InsertRegionCompositeHealthCheckRequest.newBuilder()
   *           .setCompositeHealthCheckResource(CompositeHealthCheck.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       regionCompositeHealthChecksClient.insertCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<InsertRegionCompositeHealthCheckRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the CompositeHealthChecks for a project in the given region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionCompositeHealthChecksClient regionCompositeHealthChecksClient =
   *     RegionCompositeHealthChecksClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   for (CompositeHealthCheck element :
   *       regionCompositeHealthChecksClient.list(project, region).iterateAll()) {
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
    ListRegionCompositeHealthChecksRequest request =
        ListRegionCompositeHealthChecksRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the CompositeHealthChecks for a project in the given region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionCompositeHealthChecksClient regionCompositeHealthChecksClient =
   *     RegionCompositeHealthChecksClient.create()) {
   *   ListRegionCompositeHealthChecksRequest request =
   *       ListRegionCompositeHealthChecksRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   for (CompositeHealthCheck element :
   *       regionCompositeHealthChecksClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListRegionCompositeHealthChecksRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the CompositeHealthChecks for a project in the given region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionCompositeHealthChecksClient regionCompositeHealthChecksClient =
   *     RegionCompositeHealthChecksClient.create()) {
   *   ListRegionCompositeHealthChecksRequest request =
   *       ListRegionCompositeHealthChecksRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<CompositeHealthCheck> future =
   *       regionCompositeHealthChecksClient.listPagedCallable().futureCall(request);
   *   // Do something.
   *   for (CompositeHealthCheck element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListRegionCompositeHealthChecksRequest, ListPagedResponse>
      listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the CompositeHealthChecks for a project in the given region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionCompositeHealthChecksClient regionCompositeHealthChecksClient =
   *     RegionCompositeHealthChecksClient.create()) {
   *   ListRegionCompositeHealthChecksRequest request =
   *       ListRegionCompositeHealthChecksRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   while (true) {
   *     CompositeHealthCheckList response =
   *         regionCompositeHealthChecksClient.listCallable().call(request);
   *     for (CompositeHealthCheck element : response.getItemsList()) {
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
  public final UnaryCallable<ListRegionCompositeHealthChecksRequest, CompositeHealthCheckList>
      listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified regional CompositeHealthCheck resource with the data included in the
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
   * try (RegionCompositeHealthChecksClient regionCompositeHealthChecksClient =
   *     RegionCompositeHealthChecksClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String compositeHealthCheck = "compositeHealthCheck-1727645947";
   *   CompositeHealthCheck compositeHealthCheckResource = CompositeHealthCheck.newBuilder().build();
   *   Operation response =
   *       regionCompositeHealthChecksClient
   *           .patchAsync(project, region, compositeHealthCheck, compositeHealthCheckResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param compositeHealthCheck Name of the CompositeHealthCheck to update. The name must be 1-63
   *     characters long, and comply with RFC1035.
   * @param compositeHealthCheckResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> patchAsync(
      String project,
      String region,
      String compositeHealthCheck,
      CompositeHealthCheck compositeHealthCheckResource) {
    PatchRegionCompositeHealthCheckRequest request =
        PatchRegionCompositeHealthCheckRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setCompositeHealthCheck(compositeHealthCheck)
            .setCompositeHealthCheckResource(compositeHealthCheckResource)
            .build();
    return patchAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified regional CompositeHealthCheck resource with the data included in the
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
   * try (RegionCompositeHealthChecksClient regionCompositeHealthChecksClient =
   *     RegionCompositeHealthChecksClient.create()) {
   *   PatchRegionCompositeHealthCheckRequest request =
   *       PatchRegionCompositeHealthCheckRequest.newBuilder()
   *           .setCompositeHealthCheck("compositeHealthCheck-1727645947")
   *           .setCompositeHealthCheckResource(CompositeHealthCheck.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = regionCompositeHealthChecksClient.patchAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> patchAsync(
      PatchRegionCompositeHealthCheckRequest request) {
    return patchOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified regional CompositeHealthCheck resource with the data included in the
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
   * try (RegionCompositeHealthChecksClient regionCompositeHealthChecksClient =
   *     RegionCompositeHealthChecksClient.create()) {
   *   PatchRegionCompositeHealthCheckRequest request =
   *       PatchRegionCompositeHealthCheckRequest.newBuilder()
   *           .setCompositeHealthCheck("compositeHealthCheck-1727645947")
   *           .setCompositeHealthCheckResource(CompositeHealthCheck.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       regionCompositeHealthChecksClient.patchOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<PatchRegionCompositeHealthCheckRequest, Operation, Operation>
      patchOperationCallable() {
    return stub.patchOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified regional CompositeHealthCheck resource with the data included in the
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
   * try (RegionCompositeHealthChecksClient regionCompositeHealthChecksClient =
   *     RegionCompositeHealthChecksClient.create()) {
   *   PatchRegionCompositeHealthCheckRequest request =
   *       PatchRegionCompositeHealthCheckRequest.newBuilder()
   *           .setCompositeHealthCheck("compositeHealthCheck-1727645947")
   *           .setCompositeHealthCheckResource(CompositeHealthCheck.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       regionCompositeHealthChecksClient.patchCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PatchRegionCompositeHealthCheckRequest, Operation> patchCallable() {
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
   * try (RegionCompositeHealthChecksClient regionCompositeHealthChecksClient =
   *     RegionCompositeHealthChecksClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String resource = "resource-341064690";
   *   TestPermissionsRequest testPermissionsRequestResource =
   *       TestPermissionsRequest.newBuilder().build();
   *   TestPermissionsResponse response =
   *       regionCompositeHealthChecksClient.testIamPermissions(
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
    TestIamPermissionsRegionCompositeHealthCheckRequest request =
        TestIamPermissionsRegionCompositeHealthCheckRequest.newBuilder()
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
   * try (RegionCompositeHealthChecksClient regionCompositeHealthChecksClient =
   *     RegionCompositeHealthChecksClient.create()) {
   *   TestIamPermissionsRegionCompositeHealthCheckRequest request =
   *       TestIamPermissionsRegionCompositeHealthCheckRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setResource("resource-341064690")
   *           .setTestPermissionsRequestResource(TestPermissionsRequest.newBuilder().build())
   *           .build();
   *   TestPermissionsResponse response =
   *       regionCompositeHealthChecksClient.testIamPermissions(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestPermissionsResponse testIamPermissions(
      TestIamPermissionsRegionCompositeHealthCheckRequest request) {
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
   * try (RegionCompositeHealthChecksClient regionCompositeHealthChecksClient =
   *     RegionCompositeHealthChecksClient.create()) {
   *   TestIamPermissionsRegionCompositeHealthCheckRequest request =
   *       TestIamPermissionsRegionCompositeHealthCheckRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setResource("resource-341064690")
   *           .setTestPermissionsRequestResource(TestPermissionsRequest.newBuilder().build())
   *           .build();
   *   ApiFuture<TestPermissionsResponse> future =
   *       regionCompositeHealthChecksClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something.
   *   TestPermissionsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          TestIamPermissionsRegionCompositeHealthCheckRequest, TestPermissionsResponse>
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
          AggregatedListRegionCompositeHealthChecksRequest,
          CompositeHealthCheckAggregatedList,
          Map.Entry<String, CompositeHealthChecksScopedList>,
          AggregatedListPage,
          AggregatedListFixedSizeCollection> {

    public static ApiFuture<AggregatedListPagedResponse> createAsync(
        PageContext<
                AggregatedListRegionCompositeHealthChecksRequest,
                CompositeHealthCheckAggregatedList,
                Map.Entry<String, CompositeHealthChecksScopedList>>
            context,
        ApiFuture<CompositeHealthCheckAggregatedList> futureResponse) {
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
          AggregatedListRegionCompositeHealthChecksRequest,
          CompositeHealthCheckAggregatedList,
          Map.Entry<String, CompositeHealthChecksScopedList>,
          AggregatedListPage> {

    private AggregatedListPage(
        PageContext<
                AggregatedListRegionCompositeHealthChecksRequest,
                CompositeHealthCheckAggregatedList,
                Map.Entry<String, CompositeHealthChecksScopedList>>
            context,
        CompositeHealthCheckAggregatedList response) {
      super(context, response);
    }

    private static AggregatedListPage createEmptyPage() {
      return new AggregatedListPage(null, null);
    }

    @Override
    protected AggregatedListPage createPage(
        PageContext<
                AggregatedListRegionCompositeHealthChecksRequest,
                CompositeHealthCheckAggregatedList,
                Map.Entry<String, CompositeHealthChecksScopedList>>
            context,
        CompositeHealthCheckAggregatedList response) {
      return new AggregatedListPage(context, response);
    }

    @Override
    public ApiFuture<AggregatedListPage> createPageAsync(
        PageContext<
                AggregatedListRegionCompositeHealthChecksRequest,
                CompositeHealthCheckAggregatedList,
                Map.Entry<String, CompositeHealthChecksScopedList>>
            context,
        ApiFuture<CompositeHealthCheckAggregatedList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregatedListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AggregatedListRegionCompositeHealthChecksRequest,
          CompositeHealthCheckAggregatedList,
          Map.Entry<String, CompositeHealthChecksScopedList>,
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
          ListRegionCompositeHealthChecksRequest,
          CompositeHealthCheckList,
          CompositeHealthCheck,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<
                ListRegionCompositeHealthChecksRequest,
                CompositeHealthCheckList,
                CompositeHealthCheck>
            context,
        ApiFuture<CompositeHealthCheckList> futureResponse) {
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
          ListRegionCompositeHealthChecksRequest,
          CompositeHealthCheckList,
          CompositeHealthCheck,
          ListPage> {

    private ListPage(
        PageContext<
                ListRegionCompositeHealthChecksRequest,
                CompositeHealthCheckList,
                CompositeHealthCheck>
            context,
        CompositeHealthCheckList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<
                ListRegionCompositeHealthChecksRequest,
                CompositeHealthCheckList,
                CompositeHealthCheck>
            context,
        CompositeHealthCheckList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<
                ListRegionCompositeHealthChecksRequest,
                CompositeHealthCheckList,
                CompositeHealthCheck>
            context,
        ApiFuture<CompositeHealthCheckList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRegionCompositeHealthChecksRequest,
          CompositeHealthCheckList,
          CompositeHealthCheck,
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
