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

package com.google.cloud.networkservices.v1beta1;

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
import com.google.cloud.networkservices.v1beta1.stub.NetworkServicesStub;
import com.google.cloud.networkservices.v1beta1.stub.NetworkServicesStubSettings;
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
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service describing handlers for resources.
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
 * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
 *   EndpointPolicyName name =
 *       EndpointPolicyName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT_POLICY]");
 *   EndpointPolicy response = networkServicesClient.getEndpointPolicy(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the NetworkServicesClient object to clean up resources
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
 *      <td><p> ListEndpointPolicies</td>
 *      <td><p> Lists EndpointPolicies in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listEndpointPolicies(ListEndpointPoliciesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listEndpointPolicies(LocationName parent)
 *           <li><p> listEndpointPolicies(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listEndpointPoliciesPagedCallable()
 *           <li><p> listEndpointPoliciesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetEndpointPolicy</td>
 *      <td><p> Gets details of a single EndpointPolicy.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getEndpointPolicy(GetEndpointPolicyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getEndpointPolicy(EndpointPolicyName name)
 *           <li><p> getEndpointPolicy(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getEndpointPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateEndpointPolicy</td>
 *      <td><p> Creates a new EndpointPolicy in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createEndpointPolicyAsync(CreateEndpointPolicyRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createEndpointPolicyAsync(LocationName parent, EndpointPolicy endpointPolicy, String endpointPolicyId)
 *           <li><p> createEndpointPolicyAsync(String parent, EndpointPolicy endpointPolicy, String endpointPolicyId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createEndpointPolicyOperationCallable()
 *           <li><p> createEndpointPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateEndpointPolicy</td>
 *      <td><p> Updates the parameters of a single EndpointPolicy.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateEndpointPolicyAsync(UpdateEndpointPolicyRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateEndpointPolicyAsync(EndpointPolicy endpointPolicy, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateEndpointPolicyOperationCallable()
 *           <li><p> updateEndpointPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteEndpointPolicy</td>
 *      <td><p> Deletes a single EndpointPolicy.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteEndpointPolicyAsync(DeleteEndpointPolicyRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteEndpointPolicyAsync(EndpointPolicyName name)
 *           <li><p> deleteEndpointPolicyAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteEndpointPolicyOperationCallable()
 *           <li><p> deleteEndpointPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListLocations</td>
 *      <td><p> Lists information about the supported locations for this service.
 * <p> This method lists locations based on the resource scope provided inthe [ListLocationsRequest.name][google.cloud.location.ListLocationsRequest.name] field: &#42;&#42;&#42;Global locations&#42;&#42;: If `name` is empty, the method lists thepublic locations available to all projects. &#42; &#42;&#42;Project-specificlocations&#42;&#42;: If `name` follows the format`projects/{project}`, the method lists locations visible to thatspecific project. This includes public, private, or otherproject-specific locations enabled for the project.
 * <p> For gRPC and client library implementations, the resource name ispassed as the `name` field. For direct service calls, the resourcename isincorporated into the request path based on the specific serviceimplementation and version.</td>
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
 * <p>This class can be customized by passing in a custom instance of NetworkServicesSettings to
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
 * NetworkServicesSettings networkServicesSettings =
 *     NetworkServicesSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * NetworkServicesClient networkServicesClient =
 *     NetworkServicesClient.create(networkServicesSettings);
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
 * NetworkServicesSettings networkServicesSettings =
 *     NetworkServicesSettings.newBuilder().setEndpoint(myEndpoint).build();
 * NetworkServicesClient networkServicesClient =
 *     NetworkServicesClient.create(networkServicesSettings);
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
 * NetworkServicesSettings networkServicesSettings =
 *     NetworkServicesSettings.newHttpJsonBuilder().build();
 * NetworkServicesClient networkServicesClient =
 *     NetworkServicesClient.create(networkServicesSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@BetaApi
@Generated("by gapic-generator-java")
public class NetworkServicesClient implements BackgroundResource {
  private final @Nullable NetworkServicesSettings settings;
  private final NetworkServicesStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of NetworkServicesClient with default settings. */
  public static final NetworkServicesClient create() throws IOException {
    return create(NetworkServicesSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of NetworkServicesClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final NetworkServicesClient create(NetworkServicesSettings settings)
      throws IOException {
    return new NetworkServicesClient(settings);
  }

  /**
   * Constructs an instance of NetworkServicesClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(NetworkServicesSettings).
   */
  public static final NetworkServicesClient create(NetworkServicesStub stub) {
    return new NetworkServicesClient(stub);
  }

  /**
   * Constructs an instance of NetworkServicesClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected NetworkServicesClient(NetworkServicesSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((NetworkServicesStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected NetworkServicesClient(NetworkServicesStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final @Nullable NetworkServicesSettings getSettings() {
    return settings;
  }

  public NetworkServicesStub getStub() {
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
   * Lists EndpointPolicies in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (EndpointPolicy element :
   *       networkServicesClient.listEndpointPolicies(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location from which the EndpointPolicies should be
   *     listed, specified in the format `projects/&#42;/locations/global`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEndpointPoliciesPagedResponse listEndpointPolicies(
      @Nullable LocationName parent) {
    ListEndpointPoliciesRequest request =
        ListEndpointPoliciesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listEndpointPolicies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists EndpointPolicies in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (EndpointPolicy element :
   *       networkServicesClient.listEndpointPolicies(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location from which the EndpointPolicies should be
   *     listed, specified in the format `projects/&#42;/locations/global`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEndpointPoliciesPagedResponse listEndpointPolicies(String parent) {
    ListEndpointPoliciesRequest request =
        ListEndpointPoliciesRequest.newBuilder().setParent(parent).build();
    return listEndpointPolicies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists EndpointPolicies in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   ListEndpointPoliciesRequest request =
   *       ListEndpointPoliciesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (EndpointPolicy element :
   *       networkServicesClient.listEndpointPolicies(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEndpointPoliciesPagedResponse listEndpointPolicies(
      ListEndpointPoliciesRequest request) {
    return listEndpointPoliciesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists EndpointPolicies in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   ListEndpointPoliciesRequest request =
   *       ListEndpointPoliciesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<EndpointPolicy> future =
   *       networkServicesClient.listEndpointPoliciesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (EndpointPolicy element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListEndpointPoliciesRequest, ListEndpointPoliciesPagedResponse>
      listEndpointPoliciesPagedCallable() {
    return stub.listEndpointPoliciesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists EndpointPolicies in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   ListEndpointPoliciesRequest request =
   *       ListEndpointPoliciesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListEndpointPoliciesResponse response =
   *         networkServicesClient.listEndpointPoliciesCallable().call(request);
   *     for (EndpointPolicy element : response.getEndpointPoliciesList()) {
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
  public final UnaryCallable<ListEndpointPoliciesRequest, ListEndpointPoliciesResponse>
      listEndpointPoliciesCallable() {
    return stub.listEndpointPoliciesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single EndpointPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   EndpointPolicyName name =
   *       EndpointPolicyName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT_POLICY]");
   *   EndpointPolicy response = networkServicesClient.getEndpointPolicy(name);
   * }
   * }</pre>
   *
   * @param name Required. A name of the EndpointPolicy to get. Must be in the format
   *     `projects/&#42;/locations/global/endpointPolicies/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EndpointPolicy getEndpointPolicy(@Nullable EndpointPolicyName name) {
    GetEndpointPolicyRequest request =
        GetEndpointPolicyRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getEndpointPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single EndpointPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   String name =
   *       EndpointPolicyName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT_POLICY]").toString();
   *   EndpointPolicy response = networkServicesClient.getEndpointPolicy(name);
   * }
   * }</pre>
   *
   * @param name Required. A name of the EndpointPolicy to get. Must be in the format
   *     `projects/&#42;/locations/global/endpointPolicies/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EndpointPolicy getEndpointPolicy(String name) {
    GetEndpointPolicyRequest request = GetEndpointPolicyRequest.newBuilder().setName(name).build();
    return getEndpointPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single EndpointPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   GetEndpointPolicyRequest request =
   *       GetEndpointPolicyRequest.newBuilder()
   *           .setName(
   *               EndpointPolicyName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT_POLICY]").toString())
   *           .build();
   *   EndpointPolicy response = networkServicesClient.getEndpointPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EndpointPolicy getEndpointPolicy(GetEndpointPolicyRequest request) {
    return getEndpointPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single EndpointPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   GetEndpointPolicyRequest request =
   *       GetEndpointPolicyRequest.newBuilder()
   *           .setName(
   *               EndpointPolicyName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT_POLICY]").toString())
   *           .build();
   *   ApiFuture<EndpointPolicy> future =
   *       networkServicesClient.getEndpointPolicyCallable().futureCall(request);
   *   // Do something.
   *   EndpointPolicy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetEndpointPolicyRequest, EndpointPolicy> getEndpointPolicyCallable() {
    return stub.getEndpointPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new EndpointPolicy in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   EndpointPolicy endpointPolicy = EndpointPolicy.newBuilder().build();
   *   String endpointPolicyId = "endpointPolicyId-509458782";
   *   EndpointPolicy response =
   *       networkServicesClient
   *           .createEndpointPolicyAsync(parent, endpointPolicy, endpointPolicyId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the EndpointPolicy. Must be in the format
   *     `projects/&#42;/locations/global`.
   * @param endpointPolicy Required. EndpointPolicy resource to be created.
   * @param endpointPolicyId Required. Short name of the EndpointPolicy resource to be created. E.g.
   *     "CustomECS".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<EndpointPolicy, OperationMetadata> createEndpointPolicyAsync(
      @Nullable LocationName parent, EndpointPolicy endpointPolicy, String endpointPolicyId) {
    CreateEndpointPolicyRequest request =
        CreateEndpointPolicyRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setEndpointPolicy(endpointPolicy)
            .setEndpointPolicyId(endpointPolicyId)
            .build();
    return createEndpointPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new EndpointPolicy in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   EndpointPolicy endpointPolicy = EndpointPolicy.newBuilder().build();
   *   String endpointPolicyId = "endpointPolicyId-509458782";
   *   EndpointPolicy response =
   *       networkServicesClient
   *           .createEndpointPolicyAsync(parent, endpointPolicy, endpointPolicyId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the EndpointPolicy. Must be in the format
   *     `projects/&#42;/locations/global`.
   * @param endpointPolicy Required. EndpointPolicy resource to be created.
   * @param endpointPolicyId Required. Short name of the EndpointPolicy resource to be created. E.g.
   *     "CustomECS".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<EndpointPolicy, OperationMetadata> createEndpointPolicyAsync(
      String parent, EndpointPolicy endpointPolicy, String endpointPolicyId) {
    CreateEndpointPolicyRequest request =
        CreateEndpointPolicyRequest.newBuilder()
            .setParent(parent)
            .setEndpointPolicy(endpointPolicy)
            .setEndpointPolicyId(endpointPolicyId)
            .build();
    return createEndpointPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new EndpointPolicy in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   CreateEndpointPolicyRequest request =
   *       CreateEndpointPolicyRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setEndpointPolicyId("endpointPolicyId-509458782")
   *           .setEndpointPolicy(EndpointPolicy.newBuilder().build())
   *           .build();
   *   EndpointPolicy response = networkServicesClient.createEndpointPolicyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<EndpointPolicy, OperationMetadata> createEndpointPolicyAsync(
      CreateEndpointPolicyRequest request) {
    return createEndpointPolicyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new EndpointPolicy in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   CreateEndpointPolicyRequest request =
   *       CreateEndpointPolicyRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setEndpointPolicyId("endpointPolicyId-509458782")
   *           .setEndpointPolicy(EndpointPolicy.newBuilder().build())
   *           .build();
   *   OperationFuture<EndpointPolicy, OperationMetadata> future =
   *       networkServicesClient.createEndpointPolicyOperationCallable().futureCall(request);
   *   // Do something.
   *   EndpointPolicy response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateEndpointPolicyRequest, EndpointPolicy, OperationMetadata>
      createEndpointPolicyOperationCallable() {
    return stub.createEndpointPolicyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new EndpointPolicy in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   CreateEndpointPolicyRequest request =
   *       CreateEndpointPolicyRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setEndpointPolicyId("endpointPolicyId-509458782")
   *           .setEndpointPolicy(EndpointPolicy.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       networkServicesClient.createEndpointPolicyCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateEndpointPolicyRequest, Operation>
      createEndpointPolicyCallable() {
    return stub.createEndpointPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single EndpointPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   EndpointPolicy endpointPolicy = EndpointPolicy.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   EndpointPolicy response =
   *       networkServicesClient.updateEndpointPolicyAsync(endpointPolicy, updateMask).get();
   * }
   * }</pre>
   *
   * @param endpointPolicy Required. Updated EndpointPolicy resource.
   * @param updateMask Optional. Field mask is used to specify the fields to be overwritten in the
   *     EndpointPolicy resource by the update. The fields specified in the update_mask are relative
   *     to the resource, not the full request. A field will be overwritten if it is in the mask. If
   *     the user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<EndpointPolicy, OperationMetadata> updateEndpointPolicyAsync(
      EndpointPolicy endpointPolicy, FieldMask updateMask) {
    UpdateEndpointPolicyRequest request =
        UpdateEndpointPolicyRequest.newBuilder()
            .setEndpointPolicy(endpointPolicy)
            .setUpdateMask(updateMask)
            .build();
    return updateEndpointPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single EndpointPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   UpdateEndpointPolicyRequest request =
   *       UpdateEndpointPolicyRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setEndpointPolicy(EndpointPolicy.newBuilder().build())
   *           .build();
   *   EndpointPolicy response = networkServicesClient.updateEndpointPolicyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<EndpointPolicy, OperationMetadata> updateEndpointPolicyAsync(
      UpdateEndpointPolicyRequest request) {
    return updateEndpointPolicyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single EndpointPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   UpdateEndpointPolicyRequest request =
   *       UpdateEndpointPolicyRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setEndpointPolicy(EndpointPolicy.newBuilder().build())
   *           .build();
   *   OperationFuture<EndpointPolicy, OperationMetadata> future =
   *       networkServicesClient.updateEndpointPolicyOperationCallable().futureCall(request);
   *   // Do something.
   *   EndpointPolicy response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateEndpointPolicyRequest, EndpointPolicy, OperationMetadata>
      updateEndpointPolicyOperationCallable() {
    return stub.updateEndpointPolicyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single EndpointPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   UpdateEndpointPolicyRequest request =
   *       UpdateEndpointPolicyRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setEndpointPolicy(EndpointPolicy.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       networkServicesClient.updateEndpointPolicyCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateEndpointPolicyRequest, Operation>
      updateEndpointPolicyCallable() {
    return stub.updateEndpointPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single EndpointPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   EndpointPolicyName name =
   *       EndpointPolicyName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT_POLICY]");
   *   networkServicesClient.deleteEndpointPolicyAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. A name of the EndpointPolicy to delete. Must be in the format
   *     `projects/&#42;/locations/global/endpointPolicies/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteEndpointPolicyAsync(
      @Nullable EndpointPolicyName name) {
    DeleteEndpointPolicyRequest request =
        DeleteEndpointPolicyRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteEndpointPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single EndpointPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   String name =
   *       EndpointPolicyName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT_POLICY]").toString();
   *   networkServicesClient.deleteEndpointPolicyAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. A name of the EndpointPolicy to delete. Must be in the format
   *     `projects/&#42;/locations/global/endpointPolicies/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteEndpointPolicyAsync(String name) {
    DeleteEndpointPolicyRequest request =
        DeleteEndpointPolicyRequest.newBuilder().setName(name).build();
    return deleteEndpointPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single EndpointPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   DeleteEndpointPolicyRequest request =
   *       DeleteEndpointPolicyRequest.newBuilder()
   *           .setName(
   *               EndpointPolicyName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT_POLICY]").toString())
   *           .build();
   *   networkServicesClient.deleteEndpointPolicyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteEndpointPolicyAsync(
      DeleteEndpointPolicyRequest request) {
    return deleteEndpointPolicyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single EndpointPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   DeleteEndpointPolicyRequest request =
   *       DeleteEndpointPolicyRequest.newBuilder()
   *           .setName(
   *               EndpointPolicyName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT_POLICY]").toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       networkServicesClient.deleteEndpointPolicyOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteEndpointPolicyRequest, Empty, OperationMetadata>
      deleteEndpointPolicyOperationCallable() {
    return stub.deleteEndpointPolicyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single EndpointPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   DeleteEndpointPolicyRequest request =
   *       DeleteEndpointPolicyRequest.newBuilder()
   *           .setName(
   *               EndpointPolicyName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT_POLICY]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       networkServicesClient.deleteEndpointPolicyCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteEndpointPolicyRequest, Operation>
      deleteEndpointPolicyCallable() {
    return stub.deleteEndpointPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>This method lists locations based on the resource scope provided inthe
   * [ListLocationsRequest.name][google.cloud.location.ListLocationsRequest.name] field:
   * &#42;&#42;&#42;Global locations&#42;&#42;: If `name` is empty, the method lists thepublic
   * locations available to all projects. &#42; &#42;&#42;Project-specificlocations&#42;&#42;: If
   * `name` follows the format`projects/{project}`, the method lists locations visible to
   * thatspecific project. This includes public, private, or otherproject-specific locations enabled
   * for the project.
   *
   * <p>For gRPC and client library implementations, the resource name ispassed as the `name` field.
   * For direct service calls, the resourcename isincorporated into the request path based on the
   * specific serviceimplementation and version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : networkServicesClient.listLocations(request).iterateAll()) {
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
   * <p>This method lists locations based on the resource scope provided inthe
   * [ListLocationsRequest.name][google.cloud.location.ListLocationsRequest.name] field:
   * &#42;&#42;&#42;Global locations&#42;&#42;: If `name` is empty, the method lists thepublic
   * locations available to all projects. &#42; &#42;&#42;Project-specificlocations&#42;&#42;: If
   * `name` follows the format`projects/{project}`, the method lists locations visible to
   * thatspecific project. This includes public, private, or otherproject-specific locations enabled
   * for the project.
   *
   * <p>For gRPC and client library implementations, the resource name ispassed as the `name` field.
   * For direct service calls, the resourcename isincorporated into the request path based on the
   * specific serviceimplementation and version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       networkServicesClient.listLocationsPagedCallable().futureCall(request);
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
   * <p>This method lists locations based on the resource scope provided inthe
   * [ListLocationsRequest.name][google.cloud.location.ListLocationsRequest.name] field:
   * &#42;&#42;&#42;Global locations&#42;&#42;: If `name` is empty, the method lists thepublic
   * locations available to all projects. &#42; &#42;&#42;Project-specificlocations&#42;&#42;: If
   * `name` follows the format`projects/{project}`, the method lists locations visible to
   * thatspecific project. This includes public, private, or otherproject-specific locations enabled
   * for the project.
   *
   * <p>For gRPC and client library implementations, the resource name ispassed as the `name` field.
   * For direct service calls, the resourcename isincorporated into the request path based on the
   * specific serviceimplementation and version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         networkServicesClient.listLocationsCallable().call(request);
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
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = networkServicesClient.getLocation(request);
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
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = networkServicesClient.getLocationCallable().futureCall(request);
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
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EndpointPolicyName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT_POLICY]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = networkServicesClient.setIamPolicy(request);
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
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EndpointPolicyName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT_POLICY]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = networkServicesClient.setIamPolicyCallable().futureCall(request);
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
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EndpointPolicyName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT_POLICY]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = networkServicesClient.getIamPolicy(request);
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
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EndpointPolicyName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT_POLICY]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = networkServicesClient.getIamPolicyCallable().futureCall(request);
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
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               EndpointPolicyName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT_POLICY]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = networkServicesClient.testIamPermissions(request);
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
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               EndpointPolicyName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT_POLICY]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       networkServicesClient.testIamPermissionsCallable().futureCall(request);
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

  public static class ListEndpointPoliciesPagedResponse
      extends AbstractPagedListResponse<
          ListEndpointPoliciesRequest,
          ListEndpointPoliciesResponse,
          EndpointPolicy,
          ListEndpointPoliciesPage,
          ListEndpointPoliciesFixedSizeCollection> {

    public static ApiFuture<ListEndpointPoliciesPagedResponse> createAsync(
        PageContext<ListEndpointPoliciesRequest, ListEndpointPoliciesResponse, EndpointPolicy>
            context,
        ApiFuture<ListEndpointPoliciesResponse> futureResponse) {
      ApiFuture<ListEndpointPoliciesPage> futurePage =
          ListEndpointPoliciesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListEndpointPoliciesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListEndpointPoliciesPagedResponse(ListEndpointPoliciesPage page) {
      super(page, ListEndpointPoliciesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListEndpointPoliciesPage
      extends AbstractPage<
          ListEndpointPoliciesRequest,
          ListEndpointPoliciesResponse,
          EndpointPolicy,
          ListEndpointPoliciesPage> {

    private ListEndpointPoliciesPage(
        @Nullable
            PageContext<ListEndpointPoliciesRequest, ListEndpointPoliciesResponse, EndpointPolicy>
            context,
        @Nullable ListEndpointPoliciesResponse response) {
      super(context, response);
    }

    private static ListEndpointPoliciesPage createEmptyPage() {
      return new ListEndpointPoliciesPage(null, null);
    }

    @Override
    protected ListEndpointPoliciesPage createPage(
        @Nullable
            PageContext<ListEndpointPoliciesRequest, ListEndpointPoliciesResponse, EndpointPolicy>
            context,
        @Nullable ListEndpointPoliciesResponse response) {
      return new ListEndpointPoliciesPage(context, response);
    }

    @Override
    public ApiFuture<ListEndpointPoliciesPage> createPageAsync(
        @Nullable
            PageContext<ListEndpointPoliciesRequest, ListEndpointPoliciesResponse, EndpointPolicy>
            context,
        ApiFuture<ListEndpointPoliciesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListEndpointPoliciesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListEndpointPoliciesRequest,
          ListEndpointPoliciesResponse,
          EndpointPolicy,
          ListEndpointPoliciesPage,
          ListEndpointPoliciesFixedSizeCollection> {

    private ListEndpointPoliciesFixedSizeCollection(
        @Nullable List<ListEndpointPoliciesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListEndpointPoliciesFixedSizeCollection createEmptyCollection() {
      return new ListEndpointPoliciesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListEndpointPoliciesFixedSizeCollection createCollection(
        @Nullable List<ListEndpointPoliciesPage> pages, int collectionSize) {
      return new ListEndpointPoliciesFixedSizeCollection(pages, collectionSize);
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
        @Nullable PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        @Nullable ListLocationsResponse response) {
      super(context, response);
    }

    private static ListLocationsPage createEmptyPage() {
      return new ListLocationsPage(null, null);
    }

    @Override
    protected ListLocationsPage createPage(
        @Nullable PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        @Nullable ListLocationsResponse response) {
      return new ListLocationsPage(context, response);
    }

    @Override
    public ApiFuture<ListLocationsPage> createPageAsync(
        @Nullable PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
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

    private ListLocationsFixedSizeCollection(
        @Nullable List<ListLocationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLocationsFixedSizeCollection createEmptyCollection() {
      return new ListLocationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLocationsFixedSizeCollection createCollection(
        @Nullable List<ListLocationsPage> pages, int collectionSize) {
      return new ListLocationsFixedSizeCollection(pages, collectionSize);
    }
  }
}
