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

package com.google.cloud.networkmanagement.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.httpjson.longrunning.OperationsClient;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.networkmanagement.v1.stub.ReachabilityServiceStub;
import com.google.cloud.networkmanagement.v1.stub.ReachabilityServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The Reachability service in the Google Cloud Network Management API provides
 * services that analyze the reachability within a single Google Virtual Private Cloud (VPC)
 * network, between peered VPC networks, between VPC and on-premises networks, or between VPC
 * networks and internet hosts. A reachability analysis is based on Google Cloud network
 * configurations.
 *
 * <p>You can use the analysis results to verify these configurations and to troubleshoot
 * connectivity issues.
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
 * try (ReachabilityServiceClient reachabilityServiceClient = ReachabilityServiceClient.create()) {
 *   String name = "name3373707";
 *   ConnectivityTest response = reachabilityServiceClient.getConnectivityTest(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ReachabilityServiceClient object to clean up resources
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
 *      <td><p> ListConnectivityTests</td>
 *      <td><p> Lists all Connectivity Tests owned by a project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listConnectivityTests(ListConnectivityTestsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listConnectivityTests(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listConnectivityTestsPagedCallable()
 *           <li><p> listConnectivityTestsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetConnectivityTest</td>
 *      <td><p> Gets the details of a specific Connectivity Test.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getConnectivityTest(GetConnectivityTestRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getConnectivityTest(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getConnectivityTestCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateConnectivityTest</td>
 *      <td><p> Creates a new Connectivity Test. After you create a test, the reachability analysis is performed as part of the long running operation, which completes when the analysis completes.
 * <p>  If the endpoint specifications in `ConnectivityTest` are invalid (for example, containing non-existent resources in the network, or you don't have read permissions to the network configurations of listed projects), then the reachability result returns a value of `UNKNOWN`.
 * <p>  If the endpoint specifications in `ConnectivityTest` are incomplete, the reachability result returns a value of &lt;code&gt;AMBIGUOUS&lt;/code&gt;. For more information, see the Connectivity Test documentation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createConnectivityTestAsync(CreateConnectivityTestRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createConnectivityTestAsync(String parent, String testId, ConnectivityTest resource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createConnectivityTestOperationCallable()
 *           <li><p> createConnectivityTestCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateConnectivityTest</td>
 *      <td><p> Updates the configuration of an existing `ConnectivityTest`. After you update a test, the reachability analysis is performed as part of the long running operation, which completes when the analysis completes. The Reachability state in the test resource is updated with the new result.
 * <p>  If the endpoint specifications in `ConnectivityTest` are invalid (for example, they contain non-existent resources in the network, or the user does not have read permissions to the network configurations of listed projects), then the reachability result returns a value of &lt;code&gt;UNKNOWN&lt;/code&gt;.
 * <p>  If the endpoint specifications in `ConnectivityTest` are incomplete, the reachability result returns a value of `AMBIGUOUS`. See the documentation in `ConnectivityTest` for for more details.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateConnectivityTestAsync(UpdateConnectivityTestRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateConnectivityTestAsync(FieldMask updateMask, ConnectivityTest resource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateConnectivityTestOperationCallable()
 *           <li><p> updateConnectivityTestCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RerunConnectivityTest</td>
 *      <td><p> Rerun an existing `ConnectivityTest`. After the user triggers the rerun, the reachability analysis is performed as part of the long running operation, which completes when the analysis completes.
 * <p>  Even though the test configuration remains the same, the reachability result may change due to underlying network configuration changes.
 * <p>  If the endpoint specifications in `ConnectivityTest` become invalid (for example, specified resources are deleted in the network, or you lost read permissions to the network configurations of listed projects), then the reachability result returns a value of `UNKNOWN`.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> rerunConnectivityTestAsync(RerunConnectivityTestRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> rerunConnectivityTestOperationCallable()
 *           <li><p> rerunConnectivityTestCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteConnectivityTest</td>
 *      <td><p> Deletes a specific `ConnectivityTest`.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteConnectivityTestAsync(DeleteConnectivityTestRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteConnectivityTestAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteConnectivityTestOperationCallable()
 *           <li><p> deleteConnectivityTestCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListLocations</td>
 *      <td><p> Lists information about the supported locations for this service.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listLocations(ListLocationsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listLocationsPagedCallable()
 *           <li><p> listLocationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetLocation</td>
 *      <td><p> Gets information about a location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getLocation(GetLocationRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getLocationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SetIamPolicy</td>
 *      <td><p> Sets the access control policy on the specified resource. Replacesany existing policy.
 * <p> Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED`errors.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> setIamPolicy(SetIamPolicyRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> setIamPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetIamPolicy</td>
 *      <td><p> Gets the access control policy for a resource. Returns an empty policyif the resource exists and does not have a policy set.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getIamPolicy(GetIamPolicyRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getIamPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> TestIamPermissions</td>
 *      <td><p> Returns permissions that a caller has on the specified resource. If theresource does not exist, this will return an empty set ofpermissions, not a `NOT_FOUND` error.
 * <p> Note: This operation is designed to be used for buildingpermission-aware UIs and command-line tools, not for authorizationchecking. This operation may "fail open" without warning.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> testIamPermissions(TestIamPermissionsRequest request)
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
 * <p>This class can be customized by passing in a custom instance of ReachabilityServiceSettings to
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
 * ReachabilityServiceSettings reachabilityServiceSettings =
 *     ReachabilityServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ReachabilityServiceClient reachabilityServiceClient =
 *     ReachabilityServiceClient.create(reachabilityServiceSettings);
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
 * ReachabilityServiceSettings reachabilityServiceSettings =
 *     ReachabilityServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ReachabilityServiceClient reachabilityServiceClient =
 *     ReachabilityServiceClient.create(reachabilityServiceSettings);
 * }</pre>
 *
 * <p>To use REST (HTTP1.1/JSON) transport (instead of gRPC) for sending and receiving requests over
 * the wire:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ReachabilityServiceSettings reachabilityServiceSettings =
 *     ReachabilityServiceSettings.newHttpJsonBuilder().build();
 * ReachabilityServiceClient reachabilityServiceClient =
 *     ReachabilityServiceClient.create(reachabilityServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class ReachabilityServiceClient implements BackgroundResource {
  private final ReachabilityServiceSettings settings;
  private final ReachabilityServiceStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of ReachabilityServiceClient with default settings. */
  public static final ReachabilityServiceClient create() throws IOException {
    return create(ReachabilityServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ReachabilityServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ReachabilityServiceClient create(ReachabilityServiceSettings settings)
      throws IOException {
    return new ReachabilityServiceClient(settings);
  }

  /**
   * Constructs an instance of ReachabilityServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(ReachabilityServiceSettings).
   */
  public static final ReachabilityServiceClient create(ReachabilityServiceStub stub) {
    return new ReachabilityServiceClient(stub);
  }

  /**
   * Constructs an instance of ReachabilityServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected ReachabilityServiceClient(ReachabilityServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ReachabilityServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected ReachabilityServiceClient(ReachabilityServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final ReachabilityServiceSettings getSettings() {
    return settings;
  }

  public ReachabilityServiceStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final com.google.longrunning.OperationsClient getOperationsClient() {
    return operationsClient;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  @BetaApi
  public final OperationsClient getHttpJsonOperationsClient() {
    return httpJsonOperationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all Connectivity Tests owned by a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReachabilityServiceClient reachabilityServiceClient = ReachabilityServiceClient.create()) {
   *   String parent = "parent-995424086";
   *   for (ConnectivityTest element :
   *       reachabilityServiceClient.listConnectivityTests(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the Connectivity Tests:
   *     `projects/{project_id}/locations/global`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListConnectivityTestsPagedResponse listConnectivityTests(String parent) {
    ListConnectivityTestsRequest request =
        ListConnectivityTestsRequest.newBuilder().setParent(parent).build();
    return listConnectivityTests(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all Connectivity Tests owned by a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReachabilityServiceClient reachabilityServiceClient = ReachabilityServiceClient.create()) {
   *   ListConnectivityTestsRequest request =
   *       ListConnectivityTestsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (ConnectivityTest element :
   *       reachabilityServiceClient.listConnectivityTests(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListConnectivityTestsPagedResponse listConnectivityTests(
      ListConnectivityTestsRequest request) {
    return listConnectivityTestsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all Connectivity Tests owned by a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReachabilityServiceClient reachabilityServiceClient = ReachabilityServiceClient.create()) {
   *   ListConnectivityTestsRequest request =
   *       ListConnectivityTestsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<ConnectivityTest> future =
   *       reachabilityServiceClient.listConnectivityTestsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ConnectivityTest element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListConnectivityTestsRequest, ListConnectivityTestsPagedResponse>
      listConnectivityTestsPagedCallable() {
    return stub.listConnectivityTestsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all Connectivity Tests owned by a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReachabilityServiceClient reachabilityServiceClient = ReachabilityServiceClient.create()) {
   *   ListConnectivityTestsRequest request =
   *       ListConnectivityTestsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListConnectivityTestsResponse response =
   *         reachabilityServiceClient.listConnectivityTestsCallable().call(request);
   *     for (ConnectivityTest element : response.getResourcesList()) {
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
  public final UnaryCallable<ListConnectivityTestsRequest, ListConnectivityTestsResponse>
      listConnectivityTestsCallable() {
    return stub.listConnectivityTestsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a specific Connectivity Test.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReachabilityServiceClient reachabilityServiceClient = ReachabilityServiceClient.create()) {
   *   String name = "name3373707";
   *   ConnectivityTest response = reachabilityServiceClient.getConnectivityTest(name);
   * }
   * }</pre>
   *
   * @param name Required. `ConnectivityTest` resource name using the form:
   *     `projects/{project_id}/locations/global/connectivityTests/{test_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ConnectivityTest getConnectivityTest(String name) {
    GetConnectivityTestRequest request =
        GetConnectivityTestRequest.newBuilder().setName(name).build();
    return getConnectivityTest(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a specific Connectivity Test.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReachabilityServiceClient reachabilityServiceClient = ReachabilityServiceClient.create()) {
   *   GetConnectivityTestRequest request =
   *       GetConnectivityTestRequest.newBuilder().setName("name3373707").build();
   *   ConnectivityTest response = reachabilityServiceClient.getConnectivityTest(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ConnectivityTest getConnectivityTest(GetConnectivityTestRequest request) {
    return getConnectivityTestCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a specific Connectivity Test.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReachabilityServiceClient reachabilityServiceClient = ReachabilityServiceClient.create()) {
   *   GetConnectivityTestRequest request =
   *       GetConnectivityTestRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<ConnectivityTest> future =
   *       reachabilityServiceClient.getConnectivityTestCallable().futureCall(request);
   *   // Do something.
   *   ConnectivityTest response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetConnectivityTestRequest, ConnectivityTest>
      getConnectivityTestCallable() {
    return stub.getConnectivityTestCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Connectivity Test. After you create a test, the reachability analysis is
   * performed as part of the long running operation, which completes when the analysis completes.
   *
   * <p>If the endpoint specifications in `ConnectivityTest` are invalid (for example, containing
   * non-existent resources in the network, or you don't have read permissions to the network
   * configurations of listed projects), then the reachability result returns a value of `UNKNOWN`.
   *
   * <p>If the endpoint specifications in `ConnectivityTest` are incomplete, the reachability result
   * returns a value of &lt;code&gt;AMBIGUOUS&lt;/code&gt;. For more information, see the
   * Connectivity Test documentation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReachabilityServiceClient reachabilityServiceClient = ReachabilityServiceClient.create()) {
   *   String parent = "parent-995424086";
   *   String testId = "testId-877170355";
   *   ConnectivityTest resource = ConnectivityTest.newBuilder().build();
   *   ConnectivityTest response =
   *       reachabilityServiceClient.createConnectivityTestAsync(parent, testId, resource).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the Connectivity Test to create:
   *     `projects/{project_id}/locations/global`
   * @param testId Required. The logical name of the Connectivity Test in your project with the
   *     following restrictions:
   *     <ul>
   *       <li>Must contain only lowercase letters, numbers, and hyphens.
   *       <li>Must start with a letter.
   *       <li>Must be between 1-40 characters.
   *       <li>Must end with a number or a letter.
   *       <li>Must be unique within the customer project
   *     </ul>
   *
   * @param resource Required. A `ConnectivityTest` resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ConnectivityTest, OperationMetadata> createConnectivityTestAsync(
      String parent, String testId, ConnectivityTest resource) {
    CreateConnectivityTestRequest request =
        CreateConnectivityTestRequest.newBuilder()
            .setParent(parent)
            .setTestId(testId)
            .setResource(resource)
            .build();
    return createConnectivityTestAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Connectivity Test. After you create a test, the reachability analysis is
   * performed as part of the long running operation, which completes when the analysis completes.
   *
   * <p>If the endpoint specifications in `ConnectivityTest` are invalid (for example, containing
   * non-existent resources in the network, or you don't have read permissions to the network
   * configurations of listed projects), then the reachability result returns a value of `UNKNOWN`.
   *
   * <p>If the endpoint specifications in `ConnectivityTest` are incomplete, the reachability result
   * returns a value of &lt;code&gt;AMBIGUOUS&lt;/code&gt;. For more information, see the
   * Connectivity Test documentation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReachabilityServiceClient reachabilityServiceClient = ReachabilityServiceClient.create()) {
   *   CreateConnectivityTestRequest request =
   *       CreateConnectivityTestRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setTestId("testId-877170355")
   *           .setResource(ConnectivityTest.newBuilder().build())
   *           .build();
   *   ConnectivityTest response =
   *       reachabilityServiceClient.createConnectivityTestAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ConnectivityTest, OperationMetadata> createConnectivityTestAsync(
      CreateConnectivityTestRequest request) {
    return createConnectivityTestOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Connectivity Test. After you create a test, the reachability analysis is
   * performed as part of the long running operation, which completes when the analysis completes.
   *
   * <p>If the endpoint specifications in `ConnectivityTest` are invalid (for example, containing
   * non-existent resources in the network, or you don't have read permissions to the network
   * configurations of listed projects), then the reachability result returns a value of `UNKNOWN`.
   *
   * <p>If the endpoint specifications in `ConnectivityTest` are incomplete, the reachability result
   * returns a value of &lt;code&gt;AMBIGUOUS&lt;/code&gt;. For more information, see the
   * Connectivity Test documentation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReachabilityServiceClient reachabilityServiceClient = ReachabilityServiceClient.create()) {
   *   CreateConnectivityTestRequest request =
   *       CreateConnectivityTestRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setTestId("testId-877170355")
   *           .setResource(ConnectivityTest.newBuilder().build())
   *           .build();
   *   OperationFuture<ConnectivityTest, OperationMetadata> future =
   *       reachabilityServiceClient.createConnectivityTestOperationCallable().futureCall(request);
   *   // Do something.
   *   ConnectivityTest response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateConnectivityTestRequest, ConnectivityTest, OperationMetadata>
      createConnectivityTestOperationCallable() {
    return stub.createConnectivityTestOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Connectivity Test. After you create a test, the reachability analysis is
   * performed as part of the long running operation, which completes when the analysis completes.
   *
   * <p>If the endpoint specifications in `ConnectivityTest` are invalid (for example, containing
   * non-existent resources in the network, or you don't have read permissions to the network
   * configurations of listed projects), then the reachability result returns a value of `UNKNOWN`.
   *
   * <p>If the endpoint specifications in `ConnectivityTest` are incomplete, the reachability result
   * returns a value of &lt;code&gt;AMBIGUOUS&lt;/code&gt;. For more information, see the
   * Connectivity Test documentation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReachabilityServiceClient reachabilityServiceClient = ReachabilityServiceClient.create()) {
   *   CreateConnectivityTestRequest request =
   *       CreateConnectivityTestRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setTestId("testId-877170355")
   *           .setResource(ConnectivityTest.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       reachabilityServiceClient.createConnectivityTestCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateConnectivityTestRequest, Operation>
      createConnectivityTestCallable() {
    return stub.createConnectivityTestCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the configuration of an existing `ConnectivityTest`. After you update a test, the
   * reachability analysis is performed as part of the long running operation, which completes when
   * the analysis completes. The Reachability state in the test resource is updated with the new
   * result.
   *
   * <p>If the endpoint specifications in `ConnectivityTest` are invalid (for example, they contain
   * non-existent resources in the network, or the user does not have read permissions to the
   * network configurations of listed projects), then the reachability result returns a value of
   * &lt;code&gt;UNKNOWN&lt;/code&gt;.
   *
   * <p>If the endpoint specifications in `ConnectivityTest` are incomplete, the reachability result
   * returns a value of `AMBIGUOUS`. See the documentation in `ConnectivityTest` for for more
   * details.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReachabilityServiceClient reachabilityServiceClient = ReachabilityServiceClient.create()) {
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   ConnectivityTest resource = ConnectivityTest.newBuilder().build();
   *   ConnectivityTest response =
   *       reachabilityServiceClient.updateConnectivityTestAsync(updateMask, resource).get();
   * }
   * }</pre>
   *
   * @param updateMask Required. Mask of fields to update. At least one path must be supplied in
   *     this field.
   * @param resource Required. Only fields specified in update_mask are updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ConnectivityTest, OperationMetadata> updateConnectivityTestAsync(
      FieldMask updateMask, ConnectivityTest resource) {
    UpdateConnectivityTestRequest request =
        UpdateConnectivityTestRequest.newBuilder()
            .setUpdateMask(updateMask)
            .setResource(resource)
            .build();
    return updateConnectivityTestAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the configuration of an existing `ConnectivityTest`. After you update a test, the
   * reachability analysis is performed as part of the long running operation, which completes when
   * the analysis completes. The Reachability state in the test resource is updated with the new
   * result.
   *
   * <p>If the endpoint specifications in `ConnectivityTest` are invalid (for example, they contain
   * non-existent resources in the network, or the user does not have read permissions to the
   * network configurations of listed projects), then the reachability result returns a value of
   * &lt;code&gt;UNKNOWN&lt;/code&gt;.
   *
   * <p>If the endpoint specifications in `ConnectivityTest` are incomplete, the reachability result
   * returns a value of `AMBIGUOUS`. See the documentation in `ConnectivityTest` for for more
   * details.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReachabilityServiceClient reachabilityServiceClient = ReachabilityServiceClient.create()) {
   *   UpdateConnectivityTestRequest request =
   *       UpdateConnectivityTestRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setResource(ConnectivityTest.newBuilder().build())
   *           .build();
   *   ConnectivityTest response =
   *       reachabilityServiceClient.updateConnectivityTestAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ConnectivityTest, OperationMetadata> updateConnectivityTestAsync(
      UpdateConnectivityTestRequest request) {
    return updateConnectivityTestOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the configuration of an existing `ConnectivityTest`. After you update a test, the
   * reachability analysis is performed as part of the long running operation, which completes when
   * the analysis completes. The Reachability state in the test resource is updated with the new
   * result.
   *
   * <p>If the endpoint specifications in `ConnectivityTest` are invalid (for example, they contain
   * non-existent resources in the network, or the user does not have read permissions to the
   * network configurations of listed projects), then the reachability result returns a value of
   * &lt;code&gt;UNKNOWN&lt;/code&gt;.
   *
   * <p>If the endpoint specifications in `ConnectivityTest` are incomplete, the reachability result
   * returns a value of `AMBIGUOUS`. See the documentation in `ConnectivityTest` for for more
   * details.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReachabilityServiceClient reachabilityServiceClient = ReachabilityServiceClient.create()) {
   *   UpdateConnectivityTestRequest request =
   *       UpdateConnectivityTestRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setResource(ConnectivityTest.newBuilder().build())
   *           .build();
   *   OperationFuture<ConnectivityTest, OperationMetadata> future =
   *       reachabilityServiceClient.updateConnectivityTestOperationCallable().futureCall(request);
   *   // Do something.
   *   ConnectivityTest response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateConnectivityTestRequest, ConnectivityTest, OperationMetadata>
      updateConnectivityTestOperationCallable() {
    return stub.updateConnectivityTestOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the configuration of an existing `ConnectivityTest`. After you update a test, the
   * reachability analysis is performed as part of the long running operation, which completes when
   * the analysis completes. The Reachability state in the test resource is updated with the new
   * result.
   *
   * <p>If the endpoint specifications in `ConnectivityTest` are invalid (for example, they contain
   * non-existent resources in the network, or the user does not have read permissions to the
   * network configurations of listed projects), then the reachability result returns a value of
   * &lt;code&gt;UNKNOWN&lt;/code&gt;.
   *
   * <p>If the endpoint specifications in `ConnectivityTest` are incomplete, the reachability result
   * returns a value of `AMBIGUOUS`. See the documentation in `ConnectivityTest` for for more
   * details.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReachabilityServiceClient reachabilityServiceClient = ReachabilityServiceClient.create()) {
   *   UpdateConnectivityTestRequest request =
   *       UpdateConnectivityTestRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setResource(ConnectivityTest.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       reachabilityServiceClient.updateConnectivityTestCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateConnectivityTestRequest, Operation>
      updateConnectivityTestCallable() {
    return stub.updateConnectivityTestCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Rerun an existing `ConnectivityTest`. After the user triggers the rerun, the reachability
   * analysis is performed as part of the long running operation, which completes when the analysis
   * completes.
   *
   * <p>Even though the test configuration remains the same, the reachability result may change due
   * to underlying network configuration changes.
   *
   * <p>If the endpoint specifications in `ConnectivityTest` become invalid (for example, specified
   * resources are deleted in the network, or you lost read permissions to the network
   * configurations of listed projects), then the reachability result returns a value of `UNKNOWN`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReachabilityServiceClient reachabilityServiceClient = ReachabilityServiceClient.create()) {
   *   RerunConnectivityTestRequest request =
   *       RerunConnectivityTestRequest.newBuilder().setName("name3373707").build();
   *   ConnectivityTest response =
   *       reachabilityServiceClient.rerunConnectivityTestAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ConnectivityTest, OperationMetadata> rerunConnectivityTestAsync(
      RerunConnectivityTestRequest request) {
    return rerunConnectivityTestOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Rerun an existing `ConnectivityTest`. After the user triggers the rerun, the reachability
   * analysis is performed as part of the long running operation, which completes when the analysis
   * completes.
   *
   * <p>Even though the test configuration remains the same, the reachability result may change due
   * to underlying network configuration changes.
   *
   * <p>If the endpoint specifications in `ConnectivityTest` become invalid (for example, specified
   * resources are deleted in the network, or you lost read permissions to the network
   * configurations of listed projects), then the reachability result returns a value of `UNKNOWN`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReachabilityServiceClient reachabilityServiceClient = ReachabilityServiceClient.create()) {
   *   RerunConnectivityTestRequest request =
   *       RerunConnectivityTestRequest.newBuilder().setName("name3373707").build();
   *   OperationFuture<ConnectivityTest, OperationMetadata> future =
   *       reachabilityServiceClient.rerunConnectivityTestOperationCallable().futureCall(request);
   *   // Do something.
   *   ConnectivityTest response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<RerunConnectivityTestRequest, ConnectivityTest, OperationMetadata>
      rerunConnectivityTestOperationCallable() {
    return stub.rerunConnectivityTestOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Rerun an existing `ConnectivityTest`. After the user triggers the rerun, the reachability
   * analysis is performed as part of the long running operation, which completes when the analysis
   * completes.
   *
   * <p>Even though the test configuration remains the same, the reachability result may change due
   * to underlying network configuration changes.
   *
   * <p>If the endpoint specifications in `ConnectivityTest` become invalid (for example, specified
   * resources are deleted in the network, or you lost read permissions to the network
   * configurations of listed projects), then the reachability result returns a value of `UNKNOWN`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReachabilityServiceClient reachabilityServiceClient = ReachabilityServiceClient.create()) {
   *   RerunConnectivityTestRequest request =
   *       RerunConnectivityTestRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Operation> future =
   *       reachabilityServiceClient.rerunConnectivityTestCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RerunConnectivityTestRequest, Operation>
      rerunConnectivityTestCallable() {
    return stub.rerunConnectivityTestCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific `ConnectivityTest`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReachabilityServiceClient reachabilityServiceClient = ReachabilityServiceClient.create()) {
   *   String name = "name3373707";
   *   reachabilityServiceClient.deleteConnectivityTestAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Connectivity Test resource name using the form:
   *     `projects/{project_id}/locations/global/connectivityTests/{test_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteConnectivityTestAsync(String name) {
    DeleteConnectivityTestRequest request =
        DeleteConnectivityTestRequest.newBuilder().setName(name).build();
    return deleteConnectivityTestAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific `ConnectivityTest`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReachabilityServiceClient reachabilityServiceClient = ReachabilityServiceClient.create()) {
   *   DeleteConnectivityTestRequest request =
   *       DeleteConnectivityTestRequest.newBuilder().setName("name3373707").build();
   *   reachabilityServiceClient.deleteConnectivityTestAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteConnectivityTestAsync(
      DeleteConnectivityTestRequest request) {
    return deleteConnectivityTestOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific `ConnectivityTest`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReachabilityServiceClient reachabilityServiceClient = ReachabilityServiceClient.create()) {
   *   DeleteConnectivityTestRequest request =
   *       DeleteConnectivityTestRequest.newBuilder().setName("name3373707").build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       reachabilityServiceClient.deleteConnectivityTestOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteConnectivityTestRequest, Empty, OperationMetadata>
      deleteConnectivityTestOperationCallable() {
    return stub.deleteConnectivityTestOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific `ConnectivityTest`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReachabilityServiceClient reachabilityServiceClient = ReachabilityServiceClient.create()) {
   *   DeleteConnectivityTestRequest request =
   *       DeleteConnectivityTestRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Operation> future =
   *       reachabilityServiceClient.deleteConnectivityTestCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteConnectivityTestRequest, Operation>
      deleteConnectivityTestCallable() {
    return stub.deleteConnectivityTestCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReachabilityServiceClient reachabilityServiceClient = ReachabilityServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : reachabilityServiceClient.listLocations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLocationsPagedResponse listLocations(ListLocationsRequest request) {
    return listLocationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReachabilityServiceClient reachabilityServiceClient = ReachabilityServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       reachabilityServiceClient.listLocationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Location element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return stub.listLocationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReachabilityServiceClient reachabilityServiceClient = ReachabilityServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         reachabilityServiceClient.listLocationsCallable().call(request);
   *     for (Location element : response.getLocationsList()) {
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
  public final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return stub.listLocationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReachabilityServiceClient reachabilityServiceClient = ReachabilityServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = reachabilityServiceClient.getLocation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Location getLocation(GetLocationRequest request) {
    return getLocationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReachabilityServiceClient reachabilityServiceClient = ReachabilityServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future =
   *       reachabilityServiceClient.getLocationCallable().futureCall(request);
   *   // Do something.
   *   Location response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return stub.getLocationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replacesany existing policy.
   *
   * <p>Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED`errors.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReachabilityServiceClient reachabilityServiceClient = ReachabilityServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource("SetIamPolicyRequest1223629066".toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = reachabilityServiceClient.setIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(SetIamPolicyRequest request) {
    return setIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replacesany existing policy.
   *
   * <p>Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED`errors.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReachabilityServiceClient reachabilityServiceClient = ReachabilityServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource("SetIamPolicyRequest1223629066".toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       reachabilityServiceClient.setIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return stub.setIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. Returns an empty policyif the resource exists
   * and does not have a policy set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReachabilityServiceClient reachabilityServiceClient = ReachabilityServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource("GetIamPolicyRequest-1527610370".toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = reachabilityServiceClient.getIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(GetIamPolicyRequest request) {
    return getIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. Returns an empty policyif the resource exists
   * and does not have a policy set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReachabilityServiceClient reachabilityServiceClient = ReachabilityServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource("GetIamPolicyRequest-1527610370".toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       reachabilityServiceClient.getIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return stub.getIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource. If theresource does not exist,
   * this will return an empty set ofpermissions, not a `NOT_FOUND` error.
   *
   * <p>Note: This operation is designed to be used for buildingpermission-aware UIs and
   * command-line tools, not for authorizationchecking. This operation may "fail open" without
   * warning.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReachabilityServiceClient reachabilityServiceClient = ReachabilityServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource("TestIamPermissionsRequest942398222".toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = reachabilityServiceClient.testIamPermissions(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(TestIamPermissionsRequest request) {
    return testIamPermissionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource. If theresource does not exist,
   * this will return an empty set ofpermissions, not a `NOT_FOUND` error.
   *
   * <p>Note: This operation is designed to be used for buildingpermission-aware UIs and
   * command-line tools, not for authorizationchecking. This operation may "fail open" without
   * warning.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReachabilityServiceClient reachabilityServiceClient = ReachabilityServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource("TestIamPermissionsRequest942398222".toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       reachabilityServiceClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something.
   *   TestIamPermissionsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
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

  public static class ListConnectivityTestsPagedResponse
      extends AbstractPagedListResponse<
          ListConnectivityTestsRequest,
          ListConnectivityTestsResponse,
          ConnectivityTest,
          ListConnectivityTestsPage,
          ListConnectivityTestsFixedSizeCollection> {

    public static ApiFuture<ListConnectivityTestsPagedResponse> createAsync(
        PageContext<ListConnectivityTestsRequest, ListConnectivityTestsResponse, ConnectivityTest>
            context,
        ApiFuture<ListConnectivityTestsResponse> futureResponse) {
      ApiFuture<ListConnectivityTestsPage> futurePage =
          ListConnectivityTestsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListConnectivityTestsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListConnectivityTestsPagedResponse(ListConnectivityTestsPage page) {
      super(page, ListConnectivityTestsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListConnectivityTestsPage
      extends AbstractPage<
          ListConnectivityTestsRequest,
          ListConnectivityTestsResponse,
          ConnectivityTest,
          ListConnectivityTestsPage> {

    private ListConnectivityTestsPage(
        PageContext<ListConnectivityTestsRequest, ListConnectivityTestsResponse, ConnectivityTest>
            context,
        ListConnectivityTestsResponse response) {
      super(context, response);
    }

    private static ListConnectivityTestsPage createEmptyPage() {
      return new ListConnectivityTestsPage(null, null);
    }

    @Override
    protected ListConnectivityTestsPage createPage(
        PageContext<ListConnectivityTestsRequest, ListConnectivityTestsResponse, ConnectivityTest>
            context,
        ListConnectivityTestsResponse response) {
      return new ListConnectivityTestsPage(context, response);
    }

    @Override
    public ApiFuture<ListConnectivityTestsPage> createPageAsync(
        PageContext<ListConnectivityTestsRequest, ListConnectivityTestsResponse, ConnectivityTest>
            context,
        ApiFuture<ListConnectivityTestsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListConnectivityTestsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListConnectivityTestsRequest,
          ListConnectivityTestsResponse,
          ConnectivityTest,
          ListConnectivityTestsPage,
          ListConnectivityTestsFixedSizeCollection> {

    private ListConnectivityTestsFixedSizeCollection(
        List<ListConnectivityTestsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListConnectivityTestsFixedSizeCollection createEmptyCollection() {
      return new ListConnectivityTestsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListConnectivityTestsFixedSizeCollection createCollection(
        List<ListConnectivityTestsPage> pages, int collectionSize) {
      return new ListConnectivityTestsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListLocationsPagedResponse
      extends AbstractPagedListResponse<
          ListLocationsRequest,
          ListLocationsResponse,
          Location,
          ListLocationsPage,
          ListLocationsFixedSizeCollection> {

    public static ApiFuture<ListLocationsPagedResponse> createAsync(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ApiFuture<ListLocationsResponse> futureResponse) {
      ApiFuture<ListLocationsPage> futurePage =
          ListLocationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListLocationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListLocationsPagedResponse(ListLocationsPage page) {
      super(page, ListLocationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListLocationsPage
      extends AbstractPage<
          ListLocationsRequest, ListLocationsResponse, Location, ListLocationsPage> {

    private ListLocationsPage(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ListLocationsResponse response) {
      super(context, response);
    }

    private static ListLocationsPage createEmptyPage() {
      return new ListLocationsPage(null, null);
    }

    @Override
    protected ListLocationsPage createPage(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ListLocationsResponse response) {
      return new ListLocationsPage(context, response);
    }

    @Override
    public ApiFuture<ListLocationsPage> createPageAsync(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ApiFuture<ListLocationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListLocationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListLocationsRequest,
          ListLocationsResponse,
          Location,
          ListLocationsPage,
          ListLocationsFixedSizeCollection> {

    private ListLocationsFixedSizeCollection(List<ListLocationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLocationsFixedSizeCollection createEmptyCollection() {
      return new ListLocationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLocationsFixedSizeCollection createCollection(
        List<ListLocationsPage> pages, int collectionSize) {
      return new ListLocationsFixedSizeCollection(pages, collectionSize);
    }
  }
}
