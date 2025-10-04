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
import com.google.cloud.compute.v1.stub.TargetInstancesStub;
import com.google.cloud.compute.v1.stub.TargetInstancesStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The TargetInstances API.
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
 * try (TargetInstancesClient targetInstancesClient = TargetInstancesClient.create()) {
 *   String project = "project-309310695";
 *   String zone = "zone3744684";
 *   String targetInstance = "targetInstance-1036957370";
 *   TargetInstance response = targetInstancesClient.get(project, zone, targetInstance);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the TargetInstancesClient object to clean up resources
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
 *      <td><p> Retrieves an aggregated list of target instances. To prevent failure, Google recommends that you set the `returnPartialSuccess` parameter to `true`.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> aggregatedList(AggregatedListTargetInstancesRequest request)
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
 *      <td><p> Deletes the specified TargetInstance resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteAsync(DeleteTargetInstanceRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteAsync(String project, String zone, String targetInstance)
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
 *      <td><p> Returns the specified TargetInstance resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> get(GetTargetInstanceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> get(String project, String zone, String targetInstance)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Insert</td>
 *      <td><p> Creates a TargetInstance resource in the specified project and zone using the data included in the request.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> insertAsync(InsertTargetInstanceRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> insertAsync(String project, String zone, TargetInstance targetInstanceResource)
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
 *      <td><p> Retrieves a list of TargetInstance resources available to the specified project and zone.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> list(ListTargetInstancesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> list(String project, String zone)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listPagedCallable()
 *           <li><p> listCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SetSecurityPolicy</td>
 *      <td><p> Sets the Google Cloud Armor security policy for the specified target instance. For more information, see Google Cloud Armor Overview</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> setSecurityPolicyAsync(SetSecurityPolicyTargetInstanceRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> setSecurityPolicyAsync(String project, String zone, String targetInstance, SecurityPolicyReference securityPolicyReferenceResource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> setSecurityPolicyOperationCallable()
 *           <li><p> setSecurityPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> TestIamPermissions</td>
 *      <td><p> Returns permissions that a caller has on the specified resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> testIamPermissions(TestIamPermissionsTargetInstanceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> testIamPermissions(String project, String zone, String resource, TestPermissionsRequest testPermissionsRequestResource)
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
 * <p>This class can be customized by passing in a custom instance of TargetInstancesSettings to
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
 * TargetInstancesSettings targetInstancesSettings =
 *     TargetInstancesSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * TargetInstancesClient targetInstancesClient =
 *     TargetInstancesClient.create(targetInstancesSettings);
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
 * TargetInstancesSettings targetInstancesSettings =
 *     TargetInstancesSettings.newBuilder().setEndpoint(myEndpoint).build();
 * TargetInstancesClient targetInstancesClient =
 *     TargetInstancesClient.create(targetInstancesSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class TargetInstancesClient implements BackgroundResource {
  private final TargetInstancesSettings settings;
  private final TargetInstancesStub stub;

  /** Constructs an instance of TargetInstancesClient with default settings. */
  public static final TargetInstancesClient create() throws IOException {
    return create(TargetInstancesSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of TargetInstancesClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final TargetInstancesClient create(TargetInstancesSettings settings)
      throws IOException {
    return new TargetInstancesClient(settings);
  }

  /**
   * Constructs an instance of TargetInstancesClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(TargetInstancesSettings).
   */
  public static final TargetInstancesClient create(TargetInstancesStub stub) {
    return new TargetInstancesClient(stub);
  }

  /**
   * Constructs an instance of TargetInstancesClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected TargetInstancesClient(TargetInstancesSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((TargetInstancesStubSettings) settings.getStubSettings()).createStub();
  }

  protected TargetInstancesClient(TargetInstancesStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final TargetInstancesSettings getSettings() {
    return settings;
  }

  public TargetInstancesStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an aggregated list of target instances. To prevent failure, Google recommends that
   * you set the `returnPartialSuccess` parameter to `true`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetInstancesClient targetInstancesClient = TargetInstancesClient.create()) {
   *   String project = "project-309310695";
   *   for (Map.Entry<String, TargetInstancesScopedList> element :
   *       targetInstancesClient.aggregatedList(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(String project) {
    AggregatedListTargetInstancesRequest request =
        AggregatedListTargetInstancesRequest.newBuilder().setProject(project).build();
    return aggregatedList(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an aggregated list of target instances. To prevent failure, Google recommends that
   * you set the `returnPartialSuccess` parameter to `true`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetInstancesClient targetInstancesClient = TargetInstancesClient.create()) {
   *   AggregatedListTargetInstancesRequest request =
   *       AggregatedListTargetInstancesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setIncludeAllScopes(true)
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .setServiceProjectNumber(-1293855239)
   *           .build();
   *   for (Map.Entry<String, TargetInstancesScopedList> element :
   *       targetInstancesClient.aggregatedList(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(
      AggregatedListTargetInstancesRequest request) {
    return aggregatedListPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an aggregated list of target instances. To prevent failure, Google recommends that
   * you set the `returnPartialSuccess` parameter to `true`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetInstancesClient targetInstancesClient = TargetInstancesClient.create()) {
   *   AggregatedListTargetInstancesRequest request =
   *       AggregatedListTargetInstancesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setIncludeAllScopes(true)
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .setServiceProjectNumber(-1293855239)
   *           .build();
   *   ApiFuture<Map.Entry<String, TargetInstancesScopedList>> future =
   *       targetInstancesClient.aggregatedListPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Map.Entry<String, TargetInstancesScopedList> element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<AggregatedListTargetInstancesRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return stub.aggregatedListPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an aggregated list of target instances. To prevent failure, Google recommends that
   * you set the `returnPartialSuccess` parameter to `true`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetInstancesClient targetInstancesClient = TargetInstancesClient.create()) {
   *   AggregatedListTargetInstancesRequest request =
   *       AggregatedListTargetInstancesRequest.newBuilder()
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
   *     TargetInstanceAggregatedList response =
   *         targetInstancesClient.aggregatedListCallable().call(request);
   *     for (Map.Entry<String, TargetInstancesScopedList> element : response.getItemsList()) {
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
  public final UnaryCallable<AggregatedListTargetInstancesRequest, TargetInstanceAggregatedList>
      aggregatedListCallable() {
    return stub.aggregatedListCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified TargetInstance resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetInstancesClient targetInstancesClient = TargetInstancesClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String targetInstance = "targetInstance-1036957370";
   *   Operation response = targetInstancesClient.deleteAsync(project, zone, targetInstance).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone Name of the zone scoping this request.
   * @param targetInstance Name of the TargetInstance resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> deleteAsync(
      String project, String zone, String targetInstance) {
    DeleteTargetInstanceRequest request =
        DeleteTargetInstanceRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setTargetInstance(targetInstance)
            .build();
    return deleteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified TargetInstance resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetInstancesClient targetInstancesClient = TargetInstancesClient.create()) {
   *   DeleteTargetInstanceRequest request =
   *       DeleteTargetInstanceRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setTargetInstance("targetInstance-1036957370")
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = targetInstancesClient.deleteAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> deleteAsync(
      DeleteTargetInstanceRequest request) {
    return deleteOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified TargetInstance resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetInstancesClient targetInstancesClient = TargetInstancesClient.create()) {
   *   DeleteTargetInstanceRequest request =
   *       DeleteTargetInstanceRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setTargetInstance("targetInstance-1036957370")
   *           .setZone("zone3744684")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       targetInstancesClient.deleteOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteTargetInstanceRequest, Operation, Operation>
      deleteOperationCallable() {
    return stub.deleteOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified TargetInstance resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetInstancesClient targetInstancesClient = TargetInstancesClient.create()) {
   *   DeleteTargetInstanceRequest request =
   *       DeleteTargetInstanceRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setTargetInstance("targetInstance-1036957370")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future = targetInstancesClient.deleteCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteTargetInstanceRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified TargetInstance resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetInstancesClient targetInstancesClient = TargetInstancesClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String targetInstance = "targetInstance-1036957370";
   *   TargetInstance response = targetInstancesClient.get(project, zone, targetInstance);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone Name of the zone scoping this request.
   * @param targetInstance Name of the TargetInstance resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TargetInstance get(String project, String zone, String targetInstance) {
    GetTargetInstanceRequest request =
        GetTargetInstanceRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setTargetInstance(targetInstance)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified TargetInstance resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetInstancesClient targetInstancesClient = TargetInstancesClient.create()) {
   *   GetTargetInstanceRequest request =
   *       GetTargetInstanceRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setTargetInstance("targetInstance-1036957370")
   *           .setZone("zone3744684")
   *           .build();
   *   TargetInstance response = targetInstancesClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TargetInstance get(GetTargetInstanceRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified TargetInstance resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetInstancesClient targetInstancesClient = TargetInstancesClient.create()) {
   *   GetTargetInstanceRequest request =
   *       GetTargetInstanceRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setTargetInstance("targetInstance-1036957370")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<TargetInstance> future = targetInstancesClient.getCallable().futureCall(request);
   *   // Do something.
   *   TargetInstance response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetTargetInstanceRequest, TargetInstance> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a TargetInstance resource in the specified project and zone using the data included in
   * the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetInstancesClient targetInstancesClient = TargetInstancesClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   TargetInstance targetInstanceResource = TargetInstance.newBuilder().build();
   *   Operation response =
   *       targetInstancesClient.insertAsync(project, zone, targetInstanceResource).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone Name of the zone scoping this request.
   * @param targetInstanceResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> insertAsync(
      String project, String zone, TargetInstance targetInstanceResource) {
    InsertTargetInstanceRequest request =
        InsertTargetInstanceRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setTargetInstanceResource(targetInstanceResource)
            .build();
    return insertAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a TargetInstance resource in the specified project and zone using the data included in
   * the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetInstancesClient targetInstancesClient = TargetInstancesClient.create()) {
   *   InsertTargetInstanceRequest request =
   *       InsertTargetInstanceRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setTargetInstanceResource(TargetInstance.newBuilder().build())
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = targetInstancesClient.insertAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> insertAsync(
      InsertTargetInstanceRequest request) {
    return insertOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a TargetInstance resource in the specified project and zone using the data included in
   * the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetInstancesClient targetInstancesClient = TargetInstancesClient.create()) {
   *   InsertTargetInstanceRequest request =
   *       InsertTargetInstanceRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setTargetInstanceResource(TargetInstance.newBuilder().build())
   *           .setZone("zone3744684")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       targetInstancesClient.insertOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<InsertTargetInstanceRequest, Operation, Operation>
      insertOperationCallable() {
    return stub.insertOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a TargetInstance resource in the specified project and zone using the data included in
   * the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetInstancesClient targetInstancesClient = TargetInstancesClient.create()) {
   *   InsertTargetInstanceRequest request =
   *       InsertTargetInstanceRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setTargetInstanceResource(TargetInstance.newBuilder().build())
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future = targetInstancesClient.insertCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<InsertTargetInstanceRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of TargetInstance resources available to the specified project and zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetInstancesClient targetInstancesClient = TargetInstancesClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   for (TargetInstance element : targetInstancesClient.list(project, zone).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone Name of the zone scoping this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project, String zone) {
    ListTargetInstancesRequest request =
        ListTargetInstancesRequest.newBuilder().setProject(project).setZone(zone).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of TargetInstance resources available to the specified project and zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetInstancesClient targetInstancesClient = TargetInstancesClient.create()) {
   *   ListTargetInstancesRequest request =
   *       ListTargetInstancesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .setZone("zone3744684")
   *           .build();
   *   for (TargetInstance element : targetInstancesClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListTargetInstancesRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of TargetInstance resources available to the specified project and zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetInstancesClient targetInstancesClient = TargetInstancesClient.create()) {
   *   ListTargetInstancesRequest request =
   *       ListTargetInstancesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<TargetInstance> future =
   *       targetInstancesClient.listPagedCallable().futureCall(request);
   *   // Do something.
   *   for (TargetInstance element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListTargetInstancesRequest, ListPagedResponse> listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of TargetInstance resources available to the specified project and zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetInstancesClient targetInstancesClient = TargetInstancesClient.create()) {
   *   ListTargetInstancesRequest request =
   *       ListTargetInstancesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .setZone("zone3744684")
   *           .build();
   *   while (true) {
   *     TargetInstanceList response = targetInstancesClient.listCallable().call(request);
   *     for (TargetInstance element : response.getItemsList()) {
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
  public final UnaryCallable<ListTargetInstancesRequest, TargetInstanceList> listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the Google Cloud Armor security policy for the specified target instance. For more
   * information, see Google Cloud Armor Overview
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetInstancesClient targetInstancesClient = TargetInstancesClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String targetInstance = "targetInstance-1036957370";
   *   SecurityPolicyReference securityPolicyReferenceResource =
   *       SecurityPolicyReference.newBuilder().build();
   *   Operation response =
   *       targetInstancesClient
   *           .setSecurityPolicyAsync(
   *               project, zone, targetInstance, securityPolicyReferenceResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone Name of the zone scoping this request.
   * @param targetInstance Name of the TargetInstance resource to which the security policy should
   *     be set. The name should conform to RFC1035.
   * @param securityPolicyReferenceResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> setSecurityPolicyAsync(
      String project,
      String zone,
      String targetInstance,
      SecurityPolicyReference securityPolicyReferenceResource) {
    SetSecurityPolicyTargetInstanceRequest request =
        SetSecurityPolicyTargetInstanceRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setTargetInstance(targetInstance)
            .setSecurityPolicyReferenceResource(securityPolicyReferenceResource)
            .build();
    return setSecurityPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the Google Cloud Armor security policy for the specified target instance. For more
   * information, see Google Cloud Armor Overview
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetInstancesClient targetInstancesClient = TargetInstancesClient.create()) {
   *   SetSecurityPolicyTargetInstanceRequest request =
   *       SetSecurityPolicyTargetInstanceRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setSecurityPolicyReferenceResource(SecurityPolicyReference.newBuilder().build())
   *           .setTargetInstance("targetInstance-1036957370")
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = targetInstancesClient.setSecurityPolicyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> setSecurityPolicyAsync(
      SetSecurityPolicyTargetInstanceRequest request) {
    return setSecurityPolicyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the Google Cloud Armor security policy for the specified target instance. For more
   * information, see Google Cloud Armor Overview
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetInstancesClient targetInstancesClient = TargetInstancesClient.create()) {
   *   SetSecurityPolicyTargetInstanceRequest request =
   *       SetSecurityPolicyTargetInstanceRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setSecurityPolicyReferenceResource(SecurityPolicyReference.newBuilder().build())
   *           .setTargetInstance("targetInstance-1036957370")
   *           .setZone("zone3744684")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       targetInstancesClient.setSecurityPolicyOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<SetSecurityPolicyTargetInstanceRequest, Operation, Operation>
      setSecurityPolicyOperationCallable() {
    return stub.setSecurityPolicyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the Google Cloud Armor security policy for the specified target instance. For more
   * information, see Google Cloud Armor Overview
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetInstancesClient targetInstancesClient = TargetInstancesClient.create()) {
   *   SetSecurityPolicyTargetInstanceRequest request =
   *       SetSecurityPolicyTargetInstanceRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setSecurityPolicyReferenceResource(SecurityPolicyReference.newBuilder().build())
   *           .setTargetInstance("targetInstance-1036957370")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future =
   *       targetInstancesClient.setSecurityPolicyCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetSecurityPolicyTargetInstanceRequest, Operation>
      setSecurityPolicyCallable() {
    return stub.setSecurityPolicyCallable();
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
   * try (TargetInstancesClient targetInstancesClient = TargetInstancesClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String resource = "resource-341064690";
   *   TestPermissionsRequest testPermissionsRequestResource =
   *       TestPermissionsRequest.newBuilder().build();
   *   TestPermissionsResponse response =
   *       targetInstancesClient.testIamPermissions(
   *           project, zone, resource, testPermissionsRequestResource);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @param resource Name or id of the resource for this request.
   * @param testPermissionsRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestPermissionsResponse testIamPermissions(
      String project,
      String zone,
      String resource,
      TestPermissionsRequest testPermissionsRequestResource) {
    TestIamPermissionsTargetInstanceRequest request =
        TestIamPermissionsTargetInstanceRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
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
   * try (TargetInstancesClient targetInstancesClient = TargetInstancesClient.create()) {
   *   TestIamPermissionsTargetInstanceRequest request =
   *       TestIamPermissionsTargetInstanceRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setResource("resource-341064690")
   *           .setTestPermissionsRequestResource(TestPermissionsRequest.newBuilder().build())
   *           .setZone("zone3744684")
   *           .build();
   *   TestPermissionsResponse response = targetInstancesClient.testIamPermissions(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestPermissionsResponse testIamPermissions(
      TestIamPermissionsTargetInstanceRequest request) {
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
   * try (TargetInstancesClient targetInstancesClient = TargetInstancesClient.create()) {
   *   TestIamPermissionsTargetInstanceRequest request =
   *       TestIamPermissionsTargetInstanceRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setResource("resource-341064690")
   *           .setTestPermissionsRequestResource(TestPermissionsRequest.newBuilder().build())
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<TestPermissionsResponse> future =
   *       targetInstancesClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something.
   *   TestPermissionsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TestIamPermissionsTargetInstanceRequest, TestPermissionsResponse>
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
          AggregatedListTargetInstancesRequest,
          TargetInstanceAggregatedList,
          Map.Entry<String, TargetInstancesScopedList>,
          AggregatedListPage,
          AggregatedListFixedSizeCollection> {

    public static ApiFuture<AggregatedListPagedResponse> createAsync(
        PageContext<
                AggregatedListTargetInstancesRequest,
                TargetInstanceAggregatedList,
                Map.Entry<String, TargetInstancesScopedList>>
            context,
        ApiFuture<TargetInstanceAggregatedList> futureResponse) {
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
          AggregatedListTargetInstancesRequest,
          TargetInstanceAggregatedList,
          Map.Entry<String, TargetInstancesScopedList>,
          AggregatedListPage> {

    private AggregatedListPage(
        PageContext<
                AggregatedListTargetInstancesRequest,
                TargetInstanceAggregatedList,
                Map.Entry<String, TargetInstancesScopedList>>
            context,
        TargetInstanceAggregatedList response) {
      super(context, response);
    }

    private static AggregatedListPage createEmptyPage() {
      return new AggregatedListPage(null, null);
    }

    @Override
    protected AggregatedListPage createPage(
        PageContext<
                AggregatedListTargetInstancesRequest,
                TargetInstanceAggregatedList,
                Map.Entry<String, TargetInstancesScopedList>>
            context,
        TargetInstanceAggregatedList response) {
      return new AggregatedListPage(context, response);
    }

    @Override
    public ApiFuture<AggregatedListPage> createPageAsync(
        PageContext<
                AggregatedListTargetInstancesRequest,
                TargetInstanceAggregatedList,
                Map.Entry<String, TargetInstancesScopedList>>
            context,
        ApiFuture<TargetInstanceAggregatedList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregatedListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AggregatedListTargetInstancesRequest,
          TargetInstanceAggregatedList,
          Map.Entry<String, TargetInstancesScopedList>,
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
          ListTargetInstancesRequest,
          TargetInstanceList,
          TargetInstance,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListTargetInstancesRequest, TargetInstanceList, TargetInstance> context,
        ApiFuture<TargetInstanceList> futureResponse) {
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
          ListTargetInstancesRequest, TargetInstanceList, TargetInstance, ListPage> {

    private ListPage(
        PageContext<ListTargetInstancesRequest, TargetInstanceList, TargetInstance> context,
        TargetInstanceList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListTargetInstancesRequest, TargetInstanceList, TargetInstance> context,
        TargetInstanceList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListTargetInstancesRequest, TargetInstanceList, TargetInstance> context,
        ApiFuture<TargetInstanceList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTargetInstancesRequest,
          TargetInstanceList,
          TargetInstance,
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
