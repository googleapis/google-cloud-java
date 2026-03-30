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

package com.google.cloud.networksecurity.v1;

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
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.networksecurity.v1.stub.FirewallActivationStub;
import com.google.cloud.networksecurity.v1.stub.FirewallActivationStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
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
 * Service Description: Service for managing Firewall Endpoints and Associations.
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
 * try (FirewallActivationClient firewallActivationClient = FirewallActivationClient.create()) {
 *   FirewallEndpointName name =
 *       FirewallEndpointName.ofOrganizationLocationFirewallEndpointName(
 *           "[ORGANIZATION]", "[LOCATION]", "[FIREWALL_ENDPOINT]");
 *   FirewallEndpoint response = firewallActivationClient.getFirewallEndpoint(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the FirewallActivationClient object to clean up resources
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
 *      <td><p> ListFirewallEndpoints</td>
 *      <td><p> Lists FirewallEndpoints in a given organization and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listFirewallEndpoints(ListFirewallEndpointsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listFirewallEndpoints(LocationName parent)
 *           <li><p> listFirewallEndpoints(OrganizationLocationName parent)
 *           <li><p> listFirewallEndpoints(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listFirewallEndpointsPagedCallable()
 *           <li><p> listFirewallEndpointsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetFirewallEndpoint</td>
 *      <td><p> Gets details of a single org Endpoint.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getFirewallEndpoint(GetFirewallEndpointRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getFirewallEndpoint(FirewallEndpointName name)
 *           <li><p> getFirewallEndpoint(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getFirewallEndpointCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateFirewallEndpoint</td>
 *      <td><p> Creates a new FirewallEndpoint in a given organization and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createFirewallEndpointAsync(CreateFirewallEndpointRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createFirewallEndpointAsync(LocationName parent, FirewallEndpoint firewallEndpoint, String firewallEndpointId)
 *           <li><p> createFirewallEndpointAsync(OrganizationLocationName parent, FirewallEndpoint firewallEndpoint, String firewallEndpointId)
 *           <li><p> createFirewallEndpointAsync(String parent, FirewallEndpoint firewallEndpoint, String firewallEndpointId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createFirewallEndpointOperationCallable()
 *           <li><p> createFirewallEndpointCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteFirewallEndpoint</td>
 *      <td><p> Deletes a single org Endpoint.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteFirewallEndpointAsync(DeleteFirewallEndpointRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteFirewallEndpointAsync(FirewallEndpointName name)
 *           <li><p> deleteFirewallEndpointAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteFirewallEndpointOperationCallable()
 *           <li><p> deleteFirewallEndpointCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateFirewallEndpoint</td>
 *      <td><p> Update a single org Endpoint.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateFirewallEndpointAsync(UpdateFirewallEndpointRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateFirewallEndpointAsync(FirewallEndpoint firewallEndpoint, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateFirewallEndpointOperationCallable()
 *           <li><p> updateFirewallEndpointCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListFirewallEndpointAssociations</td>
 *      <td><p> Lists Associations in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listFirewallEndpointAssociations(ListFirewallEndpointAssociationsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listFirewallEndpointAssociations(LocationName parent)
 *           <li><p> listFirewallEndpointAssociations(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listFirewallEndpointAssociationsPagedCallable()
 *           <li><p> listFirewallEndpointAssociationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetFirewallEndpointAssociation</td>
 *      <td><p> Gets details of a single FirewallEndpointAssociation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getFirewallEndpointAssociation(GetFirewallEndpointAssociationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getFirewallEndpointAssociation(FirewallEndpointAssociationName name)
 *           <li><p> getFirewallEndpointAssociation(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getFirewallEndpointAssociationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateFirewallEndpointAssociation</td>
 *      <td><p> Creates a new FirewallEndpointAssociation in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createFirewallEndpointAssociationAsync(CreateFirewallEndpointAssociationRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createFirewallEndpointAssociationAsync(LocationName parent, FirewallEndpointAssociation firewallEndpointAssociation, String firewallEndpointAssociationId)
 *           <li><p> createFirewallEndpointAssociationAsync(String parent, FirewallEndpointAssociation firewallEndpointAssociation, String firewallEndpointAssociationId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createFirewallEndpointAssociationOperationCallable()
 *           <li><p> createFirewallEndpointAssociationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteFirewallEndpointAssociation</td>
 *      <td><p> Deletes a single FirewallEndpointAssociation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteFirewallEndpointAssociationAsync(DeleteFirewallEndpointAssociationRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteFirewallEndpointAssociationAsync(FirewallEndpointAssociationName name)
 *           <li><p> deleteFirewallEndpointAssociationAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteFirewallEndpointAssociationOperationCallable()
 *           <li><p> deleteFirewallEndpointAssociationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateFirewallEndpointAssociation</td>
 *      <td><p> Update a single FirewallEndpointAssociation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateFirewallEndpointAssociationAsync(UpdateFirewallEndpointAssociationRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateFirewallEndpointAssociationAsync(FirewallEndpointAssociation firewallEndpointAssociation, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateFirewallEndpointAssociationOperationCallable()
 *           <li><p> updateFirewallEndpointAssociationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListLocations</td>
 *      <td><p> Lists information about the supported locations for this service.
 * <p> This method lists locations based on the resource scope provided inthe [ListLocationsRequest.name] field:
 * <p> &#42; &#42;&#42;Global locations&#42;&#42;: If `name` is empty, the method lists thepublic locations available to all projects. &#42; &#42;&#42;Project-specificlocations&#42;&#42;: If `name` follows the format`projects/{project}`, the method lists locations visible to thatspecific project. This includes public, private, or otherproject-specific locations enabled for the project.
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
 * <p>This class can be customized by passing in a custom instance of FirewallActivationSettings to
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
 * FirewallActivationSettings firewallActivationSettings =
 *     FirewallActivationSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * FirewallActivationClient firewallActivationClient =
 *     FirewallActivationClient.create(firewallActivationSettings);
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
 * FirewallActivationSettings firewallActivationSettings =
 *     FirewallActivationSettings.newBuilder().setEndpoint(myEndpoint).build();
 * FirewallActivationClient firewallActivationClient =
 *     FirewallActivationClient.create(firewallActivationSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class FirewallActivationClient implements BackgroundResource {
  private final FirewallActivationSettings settings;
  private final FirewallActivationStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of FirewallActivationClient with default settings. */
  public static final FirewallActivationClient create() throws IOException {
    return create(FirewallActivationSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of FirewallActivationClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final FirewallActivationClient create(FirewallActivationSettings settings)
      throws IOException {
    return new FirewallActivationClient(settings);
  }

  /**
   * Constructs an instance of FirewallActivationClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(FirewallActivationSettings).
   */
  public static final FirewallActivationClient create(FirewallActivationStub stub) {
    return new FirewallActivationClient(stub);
  }

  /**
   * Constructs an instance of FirewallActivationClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected FirewallActivationClient(FirewallActivationSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((FirewallActivationStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  protected FirewallActivationClient(FirewallActivationStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final FirewallActivationSettings getSettings() {
    return settings;
  }

  public FirewallActivationStub getStub() {
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
   * Lists FirewallEndpoints in a given organization and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirewallActivationClient firewallActivationClient = FirewallActivationClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (FirewallEndpoint element :
   *       firewallActivationClient.listFirewallEndpoints(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListEndpointsRequest
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFirewallEndpointsPagedResponse listFirewallEndpoints(LocationName parent) {
    ListFirewallEndpointsRequest request =
        ListFirewallEndpointsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listFirewallEndpoints(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists FirewallEndpoints in a given organization and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirewallActivationClient firewallActivationClient = FirewallActivationClient.create()) {
   *   OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
   *   for (FirewallEndpoint element :
   *       firewallActivationClient.listFirewallEndpoints(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListEndpointsRequest
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFirewallEndpointsPagedResponse listFirewallEndpoints(
      OrganizationLocationName parent) {
    ListFirewallEndpointsRequest request =
        ListFirewallEndpointsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listFirewallEndpoints(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists FirewallEndpoints in a given organization and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirewallActivationClient firewallActivationClient = FirewallActivationClient.create()) {
   *   String parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString();
   *   for (FirewallEndpoint element :
   *       firewallActivationClient.listFirewallEndpoints(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListEndpointsRequest
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFirewallEndpointsPagedResponse listFirewallEndpoints(String parent) {
    ListFirewallEndpointsRequest request =
        ListFirewallEndpointsRequest.newBuilder().setParent(parent).build();
    return listFirewallEndpoints(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists FirewallEndpoints in a given organization and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirewallActivationClient firewallActivationClient = FirewallActivationClient.create()) {
   *   ListFirewallEndpointsRequest request =
   *       ListFirewallEndpointsRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (FirewallEndpoint element :
   *       firewallActivationClient.listFirewallEndpoints(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFirewallEndpointsPagedResponse listFirewallEndpoints(
      ListFirewallEndpointsRequest request) {
    return listFirewallEndpointsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists FirewallEndpoints in a given organization and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirewallActivationClient firewallActivationClient = FirewallActivationClient.create()) {
   *   ListFirewallEndpointsRequest request =
   *       ListFirewallEndpointsRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<FirewallEndpoint> future =
   *       firewallActivationClient.listFirewallEndpointsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (FirewallEndpoint element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListFirewallEndpointsRequest, ListFirewallEndpointsPagedResponse>
      listFirewallEndpointsPagedCallable() {
    return stub.listFirewallEndpointsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists FirewallEndpoints in a given organization and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirewallActivationClient firewallActivationClient = FirewallActivationClient.create()) {
   *   ListFirewallEndpointsRequest request =
   *       ListFirewallEndpointsRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListFirewallEndpointsResponse response =
   *         firewallActivationClient.listFirewallEndpointsCallable().call(request);
   *     for (FirewallEndpoint element : response.getFirewallEndpointsList()) {
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
  public final UnaryCallable<ListFirewallEndpointsRequest, ListFirewallEndpointsResponse>
      listFirewallEndpointsCallable() {
    return stub.listFirewallEndpointsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single org Endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirewallActivationClient firewallActivationClient = FirewallActivationClient.create()) {
   *   FirewallEndpointName name =
   *       FirewallEndpointName.ofOrganizationLocationFirewallEndpointName(
   *           "[ORGANIZATION]", "[LOCATION]", "[FIREWALL_ENDPOINT]");
   *   FirewallEndpoint response = firewallActivationClient.getFirewallEndpoint(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FirewallEndpoint getFirewallEndpoint(FirewallEndpointName name) {
    GetFirewallEndpointRequest request =
        GetFirewallEndpointRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getFirewallEndpoint(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single org Endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirewallActivationClient firewallActivationClient = FirewallActivationClient.create()) {
   *   String name =
   *       FirewallEndpointName.ofOrganizationLocationFirewallEndpointName(
   *               "[ORGANIZATION]", "[LOCATION]", "[FIREWALL_ENDPOINT]")
   *           .toString();
   *   FirewallEndpoint response = firewallActivationClient.getFirewallEndpoint(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FirewallEndpoint getFirewallEndpoint(String name) {
    GetFirewallEndpointRequest request =
        GetFirewallEndpointRequest.newBuilder().setName(name).build();
    return getFirewallEndpoint(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single org Endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirewallActivationClient firewallActivationClient = FirewallActivationClient.create()) {
   *   GetFirewallEndpointRequest request =
   *       GetFirewallEndpointRequest.newBuilder()
   *           .setName(
   *               FirewallEndpointName.ofOrganizationLocationFirewallEndpointName(
   *                       "[ORGANIZATION]", "[LOCATION]", "[FIREWALL_ENDPOINT]")
   *                   .toString())
   *           .build();
   *   FirewallEndpoint response = firewallActivationClient.getFirewallEndpoint(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FirewallEndpoint getFirewallEndpoint(GetFirewallEndpointRequest request) {
    return getFirewallEndpointCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single org Endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirewallActivationClient firewallActivationClient = FirewallActivationClient.create()) {
   *   GetFirewallEndpointRequest request =
   *       GetFirewallEndpointRequest.newBuilder()
   *           .setName(
   *               FirewallEndpointName.ofOrganizationLocationFirewallEndpointName(
   *                       "[ORGANIZATION]", "[LOCATION]", "[FIREWALL_ENDPOINT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<FirewallEndpoint> future =
   *       firewallActivationClient.getFirewallEndpointCallable().futureCall(request);
   *   // Do something.
   *   FirewallEndpoint response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetFirewallEndpointRequest, FirewallEndpoint>
      getFirewallEndpointCallable() {
    return stub.getFirewallEndpointCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new FirewallEndpoint in a given organization and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirewallActivationClient firewallActivationClient = FirewallActivationClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   FirewallEndpoint firewallEndpoint = FirewallEndpoint.newBuilder().build();
   *   String firewallEndpointId = "firewallEndpointId-993710416";
   *   FirewallEndpoint response =
   *       firewallActivationClient
   *           .createFirewallEndpointAsync(parent, firewallEndpoint, firewallEndpointId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param firewallEndpoint Required. The resource being created
   * @param firewallEndpointId Required. Id of the requesting object. If auto-generating Id
   *     server-side, remove this field and firewall_endpoint_id from the method_signature of Create
   *     RPC.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<FirewallEndpoint, OperationMetadata> createFirewallEndpointAsync(
      LocationName parent, FirewallEndpoint firewallEndpoint, String firewallEndpointId) {
    CreateFirewallEndpointRequest request =
        CreateFirewallEndpointRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setFirewallEndpoint(firewallEndpoint)
            .setFirewallEndpointId(firewallEndpointId)
            .build();
    return createFirewallEndpointAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new FirewallEndpoint in a given organization and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirewallActivationClient firewallActivationClient = FirewallActivationClient.create()) {
   *   OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
   *   FirewallEndpoint firewallEndpoint = FirewallEndpoint.newBuilder().build();
   *   String firewallEndpointId = "firewallEndpointId-993710416";
   *   FirewallEndpoint response =
   *       firewallActivationClient
   *           .createFirewallEndpointAsync(parent, firewallEndpoint, firewallEndpointId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param firewallEndpoint Required. The resource being created
   * @param firewallEndpointId Required. Id of the requesting object. If auto-generating Id
   *     server-side, remove this field and firewall_endpoint_id from the method_signature of Create
   *     RPC.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<FirewallEndpoint, OperationMetadata> createFirewallEndpointAsync(
      OrganizationLocationName parent,
      FirewallEndpoint firewallEndpoint,
      String firewallEndpointId) {
    CreateFirewallEndpointRequest request =
        CreateFirewallEndpointRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setFirewallEndpoint(firewallEndpoint)
            .setFirewallEndpointId(firewallEndpointId)
            .build();
    return createFirewallEndpointAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new FirewallEndpoint in a given organization and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirewallActivationClient firewallActivationClient = FirewallActivationClient.create()) {
   *   String parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString();
   *   FirewallEndpoint firewallEndpoint = FirewallEndpoint.newBuilder().build();
   *   String firewallEndpointId = "firewallEndpointId-993710416";
   *   FirewallEndpoint response =
   *       firewallActivationClient
   *           .createFirewallEndpointAsync(parent, firewallEndpoint, firewallEndpointId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param firewallEndpoint Required. The resource being created
   * @param firewallEndpointId Required. Id of the requesting object. If auto-generating Id
   *     server-side, remove this field and firewall_endpoint_id from the method_signature of Create
   *     RPC.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<FirewallEndpoint, OperationMetadata> createFirewallEndpointAsync(
      String parent, FirewallEndpoint firewallEndpoint, String firewallEndpointId) {
    CreateFirewallEndpointRequest request =
        CreateFirewallEndpointRequest.newBuilder()
            .setParent(parent)
            .setFirewallEndpoint(firewallEndpoint)
            .setFirewallEndpointId(firewallEndpointId)
            .build();
    return createFirewallEndpointAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new FirewallEndpoint in a given organization and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirewallActivationClient firewallActivationClient = FirewallActivationClient.create()) {
   *   CreateFirewallEndpointRequest request =
   *       CreateFirewallEndpointRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setFirewallEndpointId("firewallEndpointId-993710416")
   *           .setFirewallEndpoint(FirewallEndpoint.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   FirewallEndpoint response =
   *       firewallActivationClient.createFirewallEndpointAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<FirewallEndpoint, OperationMetadata> createFirewallEndpointAsync(
      CreateFirewallEndpointRequest request) {
    return createFirewallEndpointOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new FirewallEndpoint in a given organization and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirewallActivationClient firewallActivationClient = FirewallActivationClient.create()) {
   *   CreateFirewallEndpointRequest request =
   *       CreateFirewallEndpointRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setFirewallEndpointId("firewallEndpointId-993710416")
   *           .setFirewallEndpoint(FirewallEndpoint.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<FirewallEndpoint, OperationMetadata> future =
   *       firewallActivationClient.createFirewallEndpointOperationCallable().futureCall(request);
   *   // Do something.
   *   FirewallEndpoint response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateFirewallEndpointRequest, FirewallEndpoint, OperationMetadata>
      createFirewallEndpointOperationCallable() {
    return stub.createFirewallEndpointOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new FirewallEndpoint in a given organization and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirewallActivationClient firewallActivationClient = FirewallActivationClient.create()) {
   *   CreateFirewallEndpointRequest request =
   *       CreateFirewallEndpointRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setFirewallEndpointId("firewallEndpointId-993710416")
   *           .setFirewallEndpoint(FirewallEndpoint.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       firewallActivationClient.createFirewallEndpointCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateFirewallEndpointRequest, Operation>
      createFirewallEndpointCallable() {
    return stub.createFirewallEndpointCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single org Endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirewallActivationClient firewallActivationClient = FirewallActivationClient.create()) {
   *   FirewallEndpointName name =
   *       FirewallEndpointName.ofOrganizationLocationFirewallEndpointName(
   *           "[ORGANIZATION]", "[LOCATION]", "[FIREWALL_ENDPOINT]");
   *   firewallActivationClient.deleteFirewallEndpointAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteFirewallEndpointAsync(
      FirewallEndpointName name) {
    DeleteFirewallEndpointRequest request =
        DeleteFirewallEndpointRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteFirewallEndpointAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single org Endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirewallActivationClient firewallActivationClient = FirewallActivationClient.create()) {
   *   String name =
   *       FirewallEndpointName.ofOrganizationLocationFirewallEndpointName(
   *               "[ORGANIZATION]", "[LOCATION]", "[FIREWALL_ENDPOINT]")
   *           .toString();
   *   firewallActivationClient.deleteFirewallEndpointAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteFirewallEndpointAsync(String name) {
    DeleteFirewallEndpointRequest request =
        DeleteFirewallEndpointRequest.newBuilder().setName(name).build();
    return deleteFirewallEndpointAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single org Endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirewallActivationClient firewallActivationClient = FirewallActivationClient.create()) {
   *   DeleteFirewallEndpointRequest request =
   *       DeleteFirewallEndpointRequest.newBuilder()
   *           .setName(
   *               FirewallEndpointName.ofOrganizationLocationFirewallEndpointName(
   *                       "[ORGANIZATION]", "[LOCATION]", "[FIREWALL_ENDPOINT]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   firewallActivationClient.deleteFirewallEndpointAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteFirewallEndpointAsync(
      DeleteFirewallEndpointRequest request) {
    return deleteFirewallEndpointOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single org Endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirewallActivationClient firewallActivationClient = FirewallActivationClient.create()) {
   *   DeleteFirewallEndpointRequest request =
   *       DeleteFirewallEndpointRequest.newBuilder()
   *           .setName(
   *               FirewallEndpointName.ofOrganizationLocationFirewallEndpointName(
   *                       "[ORGANIZATION]", "[LOCATION]", "[FIREWALL_ENDPOINT]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       firewallActivationClient.deleteFirewallEndpointOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteFirewallEndpointRequest, Empty, OperationMetadata>
      deleteFirewallEndpointOperationCallable() {
    return stub.deleteFirewallEndpointOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single org Endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirewallActivationClient firewallActivationClient = FirewallActivationClient.create()) {
   *   DeleteFirewallEndpointRequest request =
   *       DeleteFirewallEndpointRequest.newBuilder()
   *           .setName(
   *               FirewallEndpointName.ofOrganizationLocationFirewallEndpointName(
   *                       "[ORGANIZATION]", "[LOCATION]", "[FIREWALL_ENDPOINT]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       firewallActivationClient.deleteFirewallEndpointCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteFirewallEndpointRequest, Operation>
      deleteFirewallEndpointCallable() {
    return stub.deleteFirewallEndpointCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a single org Endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirewallActivationClient firewallActivationClient = FirewallActivationClient.create()) {
   *   FirewallEndpoint firewallEndpoint = FirewallEndpoint.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   FirewallEndpoint response =
   *       firewallActivationClient.updateFirewallEndpointAsync(firewallEndpoint, updateMask).get();
   * }
   * }</pre>
   *
   * @param firewallEndpoint Required. The resource being updated
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     Endpoint resource by the update. The fields specified in the update_mask are relative to
   *     the resource, not the full request. A field will be overwritten if it is in the mask. If
   *     the user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<FirewallEndpoint, OperationMetadata> updateFirewallEndpointAsync(
      FirewallEndpoint firewallEndpoint, FieldMask updateMask) {
    UpdateFirewallEndpointRequest request =
        UpdateFirewallEndpointRequest.newBuilder()
            .setFirewallEndpoint(firewallEndpoint)
            .setUpdateMask(updateMask)
            .build();
    return updateFirewallEndpointAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a single org Endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirewallActivationClient firewallActivationClient = FirewallActivationClient.create()) {
   *   UpdateFirewallEndpointRequest request =
   *       UpdateFirewallEndpointRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setFirewallEndpoint(FirewallEndpoint.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   FirewallEndpoint response =
   *       firewallActivationClient.updateFirewallEndpointAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<FirewallEndpoint, OperationMetadata> updateFirewallEndpointAsync(
      UpdateFirewallEndpointRequest request) {
    return updateFirewallEndpointOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a single org Endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirewallActivationClient firewallActivationClient = FirewallActivationClient.create()) {
   *   UpdateFirewallEndpointRequest request =
   *       UpdateFirewallEndpointRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setFirewallEndpoint(FirewallEndpoint.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<FirewallEndpoint, OperationMetadata> future =
   *       firewallActivationClient.updateFirewallEndpointOperationCallable().futureCall(request);
   *   // Do something.
   *   FirewallEndpoint response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateFirewallEndpointRequest, FirewallEndpoint, OperationMetadata>
      updateFirewallEndpointOperationCallable() {
    return stub.updateFirewallEndpointOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a single org Endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirewallActivationClient firewallActivationClient = FirewallActivationClient.create()) {
   *   UpdateFirewallEndpointRequest request =
   *       UpdateFirewallEndpointRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setFirewallEndpoint(FirewallEndpoint.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       firewallActivationClient.updateFirewallEndpointCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateFirewallEndpointRequest, Operation>
      updateFirewallEndpointCallable() {
    return stub.updateFirewallEndpointCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Associations in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirewallActivationClient firewallActivationClient = FirewallActivationClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (FirewallEndpointAssociation element :
   *       firewallActivationClient.listFirewallEndpointAssociations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListAssociationsRequest
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFirewallEndpointAssociationsPagedResponse listFirewallEndpointAssociations(
      LocationName parent) {
    ListFirewallEndpointAssociationsRequest request =
        ListFirewallEndpointAssociationsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listFirewallEndpointAssociations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Associations in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirewallActivationClient firewallActivationClient = FirewallActivationClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (FirewallEndpointAssociation element :
   *       firewallActivationClient.listFirewallEndpointAssociations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListAssociationsRequest
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFirewallEndpointAssociationsPagedResponse listFirewallEndpointAssociations(
      String parent) {
    ListFirewallEndpointAssociationsRequest request =
        ListFirewallEndpointAssociationsRequest.newBuilder().setParent(parent).build();
    return listFirewallEndpointAssociations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Associations in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirewallActivationClient firewallActivationClient = FirewallActivationClient.create()) {
   *   ListFirewallEndpointAssociationsRequest request =
   *       ListFirewallEndpointAssociationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (FirewallEndpointAssociation element :
   *       firewallActivationClient.listFirewallEndpointAssociations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFirewallEndpointAssociationsPagedResponse listFirewallEndpointAssociations(
      ListFirewallEndpointAssociationsRequest request) {
    return listFirewallEndpointAssociationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Associations in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirewallActivationClient firewallActivationClient = FirewallActivationClient.create()) {
   *   ListFirewallEndpointAssociationsRequest request =
   *       ListFirewallEndpointAssociationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<FirewallEndpointAssociation> future =
   *       firewallActivationClient
   *           .listFirewallEndpointAssociationsPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (FirewallEndpointAssociation element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListFirewallEndpointAssociationsRequest, ListFirewallEndpointAssociationsPagedResponse>
      listFirewallEndpointAssociationsPagedCallable() {
    return stub.listFirewallEndpointAssociationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Associations in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirewallActivationClient firewallActivationClient = FirewallActivationClient.create()) {
   *   ListFirewallEndpointAssociationsRequest request =
   *       ListFirewallEndpointAssociationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListFirewallEndpointAssociationsResponse response =
   *         firewallActivationClient.listFirewallEndpointAssociationsCallable().call(request);
   *     for (FirewallEndpointAssociation element : response.getFirewallEndpointAssociationsList()) {
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
          ListFirewallEndpointAssociationsRequest, ListFirewallEndpointAssociationsResponse>
      listFirewallEndpointAssociationsCallable() {
    return stub.listFirewallEndpointAssociationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single FirewallEndpointAssociation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirewallActivationClient firewallActivationClient = FirewallActivationClient.create()) {
   *   FirewallEndpointAssociationName name =
   *       FirewallEndpointAssociationName.of(
   *           "[PROJECT]", "[LOCATION]", "[FIREWALL_ENDPOINT_ASSOCIATION]");
   *   FirewallEndpointAssociation response =
   *       firewallActivationClient.getFirewallEndpointAssociation(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FirewallEndpointAssociation getFirewallEndpointAssociation(
      FirewallEndpointAssociationName name) {
    GetFirewallEndpointAssociationRequest request =
        GetFirewallEndpointAssociationRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getFirewallEndpointAssociation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single FirewallEndpointAssociation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirewallActivationClient firewallActivationClient = FirewallActivationClient.create()) {
   *   String name =
   *       FirewallEndpointAssociationName.of(
   *               "[PROJECT]", "[LOCATION]", "[FIREWALL_ENDPOINT_ASSOCIATION]")
   *           .toString();
   *   FirewallEndpointAssociation response =
   *       firewallActivationClient.getFirewallEndpointAssociation(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FirewallEndpointAssociation getFirewallEndpointAssociation(String name) {
    GetFirewallEndpointAssociationRequest request =
        GetFirewallEndpointAssociationRequest.newBuilder().setName(name).build();
    return getFirewallEndpointAssociation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single FirewallEndpointAssociation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirewallActivationClient firewallActivationClient = FirewallActivationClient.create()) {
   *   GetFirewallEndpointAssociationRequest request =
   *       GetFirewallEndpointAssociationRequest.newBuilder()
   *           .setName(
   *               FirewallEndpointAssociationName.of(
   *                       "[PROJECT]", "[LOCATION]", "[FIREWALL_ENDPOINT_ASSOCIATION]")
   *                   .toString())
   *           .build();
   *   FirewallEndpointAssociation response =
   *       firewallActivationClient.getFirewallEndpointAssociation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FirewallEndpointAssociation getFirewallEndpointAssociation(
      GetFirewallEndpointAssociationRequest request) {
    return getFirewallEndpointAssociationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single FirewallEndpointAssociation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirewallActivationClient firewallActivationClient = FirewallActivationClient.create()) {
   *   GetFirewallEndpointAssociationRequest request =
   *       GetFirewallEndpointAssociationRequest.newBuilder()
   *           .setName(
   *               FirewallEndpointAssociationName.of(
   *                       "[PROJECT]", "[LOCATION]", "[FIREWALL_ENDPOINT_ASSOCIATION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<FirewallEndpointAssociation> future =
   *       firewallActivationClient.getFirewallEndpointAssociationCallable().futureCall(request);
   *   // Do something.
   *   FirewallEndpointAssociation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetFirewallEndpointAssociationRequest, FirewallEndpointAssociation>
      getFirewallEndpointAssociationCallable() {
    return stub.getFirewallEndpointAssociationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new FirewallEndpointAssociation in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirewallActivationClient firewallActivationClient = FirewallActivationClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   FirewallEndpointAssociation firewallEndpointAssociation =
   *       FirewallEndpointAssociation.newBuilder().build();
   *   String firewallEndpointAssociationId = "firewallEndpointAssociationId-891991865";
   *   FirewallEndpointAssociation response =
   *       firewallActivationClient
   *           .createFirewallEndpointAssociationAsync(
   *               parent, firewallEndpointAssociation, firewallEndpointAssociationId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param firewallEndpointAssociation Required. The resource being created
   * @param firewallEndpointAssociationId Optional. Id of the requesting object. If auto-generating
   *     Id server-side, remove this field and firewall_endpoint_association_id from the
   *     method_signature of Create RPC.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<FirewallEndpointAssociation, OperationMetadata>
      createFirewallEndpointAssociationAsync(
          LocationName parent,
          FirewallEndpointAssociation firewallEndpointAssociation,
          String firewallEndpointAssociationId) {
    CreateFirewallEndpointAssociationRequest request =
        CreateFirewallEndpointAssociationRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setFirewallEndpointAssociation(firewallEndpointAssociation)
            .setFirewallEndpointAssociationId(firewallEndpointAssociationId)
            .build();
    return createFirewallEndpointAssociationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new FirewallEndpointAssociation in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirewallActivationClient firewallActivationClient = FirewallActivationClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   FirewallEndpointAssociation firewallEndpointAssociation =
   *       FirewallEndpointAssociation.newBuilder().build();
   *   String firewallEndpointAssociationId = "firewallEndpointAssociationId-891991865";
   *   FirewallEndpointAssociation response =
   *       firewallActivationClient
   *           .createFirewallEndpointAssociationAsync(
   *               parent, firewallEndpointAssociation, firewallEndpointAssociationId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param firewallEndpointAssociation Required. The resource being created
   * @param firewallEndpointAssociationId Optional. Id of the requesting object. If auto-generating
   *     Id server-side, remove this field and firewall_endpoint_association_id from the
   *     method_signature of Create RPC.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<FirewallEndpointAssociation, OperationMetadata>
      createFirewallEndpointAssociationAsync(
          String parent,
          FirewallEndpointAssociation firewallEndpointAssociation,
          String firewallEndpointAssociationId) {
    CreateFirewallEndpointAssociationRequest request =
        CreateFirewallEndpointAssociationRequest.newBuilder()
            .setParent(parent)
            .setFirewallEndpointAssociation(firewallEndpointAssociation)
            .setFirewallEndpointAssociationId(firewallEndpointAssociationId)
            .build();
    return createFirewallEndpointAssociationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new FirewallEndpointAssociation in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirewallActivationClient firewallActivationClient = FirewallActivationClient.create()) {
   *   CreateFirewallEndpointAssociationRequest request =
   *       CreateFirewallEndpointAssociationRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFirewallEndpointAssociationId("firewallEndpointAssociationId-891991865")
   *           .setFirewallEndpointAssociation(FirewallEndpointAssociation.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   FirewallEndpointAssociation response =
   *       firewallActivationClient.createFirewallEndpointAssociationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<FirewallEndpointAssociation, OperationMetadata>
      createFirewallEndpointAssociationAsync(CreateFirewallEndpointAssociationRequest request) {
    return createFirewallEndpointAssociationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new FirewallEndpointAssociation in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirewallActivationClient firewallActivationClient = FirewallActivationClient.create()) {
   *   CreateFirewallEndpointAssociationRequest request =
   *       CreateFirewallEndpointAssociationRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFirewallEndpointAssociationId("firewallEndpointAssociationId-891991865")
   *           .setFirewallEndpointAssociation(FirewallEndpointAssociation.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<FirewallEndpointAssociation, OperationMetadata> future =
   *       firewallActivationClient
   *           .createFirewallEndpointAssociationOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   FirewallEndpointAssociation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateFirewallEndpointAssociationRequest, FirewallEndpointAssociation, OperationMetadata>
      createFirewallEndpointAssociationOperationCallable() {
    return stub.createFirewallEndpointAssociationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new FirewallEndpointAssociation in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirewallActivationClient firewallActivationClient = FirewallActivationClient.create()) {
   *   CreateFirewallEndpointAssociationRequest request =
   *       CreateFirewallEndpointAssociationRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFirewallEndpointAssociationId("firewallEndpointAssociationId-891991865")
   *           .setFirewallEndpointAssociation(FirewallEndpointAssociation.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       firewallActivationClient.createFirewallEndpointAssociationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateFirewallEndpointAssociationRequest, Operation>
      createFirewallEndpointAssociationCallable() {
    return stub.createFirewallEndpointAssociationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single FirewallEndpointAssociation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirewallActivationClient firewallActivationClient = FirewallActivationClient.create()) {
   *   FirewallEndpointAssociationName name =
   *       FirewallEndpointAssociationName.of(
   *           "[PROJECT]", "[LOCATION]", "[FIREWALL_ENDPOINT_ASSOCIATION]");
   *   firewallActivationClient.deleteFirewallEndpointAssociationAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteFirewallEndpointAssociationAsync(
      FirewallEndpointAssociationName name) {
    DeleteFirewallEndpointAssociationRequest request =
        DeleteFirewallEndpointAssociationRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteFirewallEndpointAssociationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single FirewallEndpointAssociation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirewallActivationClient firewallActivationClient = FirewallActivationClient.create()) {
   *   String name =
   *       FirewallEndpointAssociationName.of(
   *               "[PROJECT]", "[LOCATION]", "[FIREWALL_ENDPOINT_ASSOCIATION]")
   *           .toString();
   *   firewallActivationClient.deleteFirewallEndpointAssociationAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteFirewallEndpointAssociationAsync(
      String name) {
    DeleteFirewallEndpointAssociationRequest request =
        DeleteFirewallEndpointAssociationRequest.newBuilder().setName(name).build();
    return deleteFirewallEndpointAssociationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single FirewallEndpointAssociation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirewallActivationClient firewallActivationClient = FirewallActivationClient.create()) {
   *   DeleteFirewallEndpointAssociationRequest request =
   *       DeleteFirewallEndpointAssociationRequest.newBuilder()
   *           .setName(
   *               FirewallEndpointAssociationName.of(
   *                       "[PROJECT]", "[LOCATION]", "[FIREWALL_ENDPOINT_ASSOCIATION]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   firewallActivationClient.deleteFirewallEndpointAssociationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteFirewallEndpointAssociationAsync(
      DeleteFirewallEndpointAssociationRequest request) {
    return deleteFirewallEndpointAssociationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single FirewallEndpointAssociation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirewallActivationClient firewallActivationClient = FirewallActivationClient.create()) {
   *   DeleteFirewallEndpointAssociationRequest request =
   *       DeleteFirewallEndpointAssociationRequest.newBuilder()
   *           .setName(
   *               FirewallEndpointAssociationName.of(
   *                       "[PROJECT]", "[LOCATION]", "[FIREWALL_ENDPOINT_ASSOCIATION]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       firewallActivationClient
   *           .deleteFirewallEndpointAssociationOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteFirewallEndpointAssociationRequest, Empty, OperationMetadata>
      deleteFirewallEndpointAssociationOperationCallable() {
    return stub.deleteFirewallEndpointAssociationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single FirewallEndpointAssociation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirewallActivationClient firewallActivationClient = FirewallActivationClient.create()) {
   *   DeleteFirewallEndpointAssociationRequest request =
   *       DeleteFirewallEndpointAssociationRequest.newBuilder()
   *           .setName(
   *               FirewallEndpointAssociationName.of(
   *                       "[PROJECT]", "[LOCATION]", "[FIREWALL_ENDPOINT_ASSOCIATION]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       firewallActivationClient.deleteFirewallEndpointAssociationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteFirewallEndpointAssociationRequest, Operation>
      deleteFirewallEndpointAssociationCallable() {
    return stub.deleteFirewallEndpointAssociationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a single FirewallEndpointAssociation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirewallActivationClient firewallActivationClient = FirewallActivationClient.create()) {
   *   FirewallEndpointAssociation firewallEndpointAssociation =
   *       FirewallEndpointAssociation.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   FirewallEndpointAssociation response =
   *       firewallActivationClient
   *           .updateFirewallEndpointAssociationAsync(firewallEndpointAssociation, updateMask)
   *           .get();
   * }
   * }</pre>
   *
   * @param firewallEndpointAssociation Required. The resource being updated
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     Association resource by the update. The fields specified in the update_mask are relative to
   *     the resource, not the full request. A field will be overwritten if it is in the mask. If
   *     the user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<FirewallEndpointAssociation, OperationMetadata>
      updateFirewallEndpointAssociationAsync(
          FirewallEndpointAssociation firewallEndpointAssociation, FieldMask updateMask) {
    UpdateFirewallEndpointAssociationRequest request =
        UpdateFirewallEndpointAssociationRequest.newBuilder()
            .setFirewallEndpointAssociation(firewallEndpointAssociation)
            .setUpdateMask(updateMask)
            .build();
    return updateFirewallEndpointAssociationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a single FirewallEndpointAssociation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirewallActivationClient firewallActivationClient = FirewallActivationClient.create()) {
   *   UpdateFirewallEndpointAssociationRequest request =
   *       UpdateFirewallEndpointAssociationRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setFirewallEndpointAssociation(FirewallEndpointAssociation.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   FirewallEndpointAssociation response =
   *       firewallActivationClient.updateFirewallEndpointAssociationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<FirewallEndpointAssociation, OperationMetadata>
      updateFirewallEndpointAssociationAsync(UpdateFirewallEndpointAssociationRequest request) {
    return updateFirewallEndpointAssociationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a single FirewallEndpointAssociation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirewallActivationClient firewallActivationClient = FirewallActivationClient.create()) {
   *   UpdateFirewallEndpointAssociationRequest request =
   *       UpdateFirewallEndpointAssociationRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setFirewallEndpointAssociation(FirewallEndpointAssociation.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<FirewallEndpointAssociation, OperationMetadata> future =
   *       firewallActivationClient
   *           .updateFirewallEndpointAssociationOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   FirewallEndpointAssociation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UpdateFirewallEndpointAssociationRequest, FirewallEndpointAssociation, OperationMetadata>
      updateFirewallEndpointAssociationOperationCallable() {
    return stub.updateFirewallEndpointAssociationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a single FirewallEndpointAssociation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirewallActivationClient firewallActivationClient = FirewallActivationClient.create()) {
   *   UpdateFirewallEndpointAssociationRequest request =
   *       UpdateFirewallEndpointAssociationRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setFirewallEndpointAssociation(FirewallEndpointAssociation.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       firewallActivationClient.updateFirewallEndpointAssociationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateFirewallEndpointAssociationRequest, Operation>
      updateFirewallEndpointAssociationCallable() {
    return stub.updateFirewallEndpointAssociationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>This method lists locations based on the resource scope provided inthe
   * [ListLocationsRequest.name] field:
   *
   * <p>&#42; &#42;&#42;Global locations&#42;&#42;: If `name` is empty, the method lists thepublic
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
   * try (FirewallActivationClient firewallActivationClient = FirewallActivationClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : firewallActivationClient.listLocations(request).iterateAll()) {
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
   * [ListLocationsRequest.name] field:
   *
   * <p>&#42; &#42;&#42;Global locations&#42;&#42;: If `name` is empty, the method lists thepublic
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
   * try (FirewallActivationClient firewallActivationClient = FirewallActivationClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       firewallActivationClient.listLocationsPagedCallable().futureCall(request);
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
   * [ListLocationsRequest.name] field:
   *
   * <p>&#42; &#42;&#42;Global locations&#42;&#42;: If `name` is empty, the method lists thepublic
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
   * try (FirewallActivationClient firewallActivationClient = FirewallActivationClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         firewallActivationClient.listLocationsCallable().call(request);
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
   * try (FirewallActivationClient firewallActivationClient = FirewallActivationClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = firewallActivationClient.getLocation(request);
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
   * try (FirewallActivationClient firewallActivationClient = FirewallActivationClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future =
   *       firewallActivationClient.getLocationCallable().futureCall(request);
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
   * try (FirewallActivationClient firewallActivationClient = FirewallActivationClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AddressGroupName.ofProjectLocationAddressGroupName(
   *                       "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = firewallActivationClient.setIamPolicy(request);
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
   * try (FirewallActivationClient firewallActivationClient = FirewallActivationClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AddressGroupName.ofProjectLocationAddressGroupName(
   *                       "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       firewallActivationClient.setIamPolicyCallable().futureCall(request);
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
   * try (FirewallActivationClient firewallActivationClient = FirewallActivationClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AddressGroupName.ofProjectLocationAddressGroupName(
   *                       "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = firewallActivationClient.getIamPolicy(request);
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
   * try (FirewallActivationClient firewallActivationClient = FirewallActivationClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AddressGroupName.ofProjectLocationAddressGroupName(
   *                       "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       firewallActivationClient.getIamPolicyCallable().futureCall(request);
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
   * try (FirewallActivationClient firewallActivationClient = FirewallActivationClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               AddressGroupName.ofProjectLocationAddressGroupName(
   *                       "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = firewallActivationClient.testIamPermissions(request);
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
   * try (FirewallActivationClient firewallActivationClient = FirewallActivationClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               AddressGroupName.ofProjectLocationAddressGroupName(
   *                       "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       firewallActivationClient.testIamPermissionsCallable().futureCall(request);
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

  public static class ListFirewallEndpointsPagedResponse
      extends AbstractPagedListResponse<
          ListFirewallEndpointsRequest,
          ListFirewallEndpointsResponse,
          FirewallEndpoint,
          ListFirewallEndpointsPage,
          ListFirewallEndpointsFixedSizeCollection> {

    public static ApiFuture<ListFirewallEndpointsPagedResponse> createAsync(
        PageContext<ListFirewallEndpointsRequest, ListFirewallEndpointsResponse, FirewallEndpoint>
            context,
        ApiFuture<ListFirewallEndpointsResponse> futureResponse) {
      ApiFuture<ListFirewallEndpointsPage> futurePage =
          ListFirewallEndpointsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListFirewallEndpointsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListFirewallEndpointsPagedResponse(ListFirewallEndpointsPage page) {
      super(page, ListFirewallEndpointsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListFirewallEndpointsPage
      extends AbstractPage<
          ListFirewallEndpointsRequest,
          ListFirewallEndpointsResponse,
          FirewallEndpoint,
          ListFirewallEndpointsPage> {

    private ListFirewallEndpointsPage(
        PageContext<ListFirewallEndpointsRequest, ListFirewallEndpointsResponse, FirewallEndpoint>
            context,
        ListFirewallEndpointsResponse response) {
      super(context, response);
    }

    private static ListFirewallEndpointsPage createEmptyPage() {
      return new ListFirewallEndpointsPage(null, null);
    }

    @Override
    protected ListFirewallEndpointsPage createPage(
        PageContext<ListFirewallEndpointsRequest, ListFirewallEndpointsResponse, FirewallEndpoint>
            context,
        ListFirewallEndpointsResponse response) {
      return new ListFirewallEndpointsPage(context, response);
    }

    @Override
    public ApiFuture<ListFirewallEndpointsPage> createPageAsync(
        PageContext<ListFirewallEndpointsRequest, ListFirewallEndpointsResponse, FirewallEndpoint>
            context,
        ApiFuture<ListFirewallEndpointsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFirewallEndpointsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListFirewallEndpointsRequest,
          ListFirewallEndpointsResponse,
          FirewallEndpoint,
          ListFirewallEndpointsPage,
          ListFirewallEndpointsFixedSizeCollection> {

    private ListFirewallEndpointsFixedSizeCollection(
        List<ListFirewallEndpointsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListFirewallEndpointsFixedSizeCollection createEmptyCollection() {
      return new ListFirewallEndpointsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListFirewallEndpointsFixedSizeCollection createCollection(
        List<ListFirewallEndpointsPage> pages, int collectionSize) {
      return new ListFirewallEndpointsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListFirewallEndpointAssociationsPagedResponse
      extends AbstractPagedListResponse<
          ListFirewallEndpointAssociationsRequest,
          ListFirewallEndpointAssociationsResponse,
          FirewallEndpointAssociation,
          ListFirewallEndpointAssociationsPage,
          ListFirewallEndpointAssociationsFixedSizeCollection> {

    public static ApiFuture<ListFirewallEndpointAssociationsPagedResponse> createAsync(
        PageContext<
                ListFirewallEndpointAssociationsRequest,
                ListFirewallEndpointAssociationsResponse,
                FirewallEndpointAssociation>
            context,
        ApiFuture<ListFirewallEndpointAssociationsResponse> futureResponse) {
      ApiFuture<ListFirewallEndpointAssociationsPage> futurePage =
          ListFirewallEndpointAssociationsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListFirewallEndpointAssociationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListFirewallEndpointAssociationsPagedResponse(
        ListFirewallEndpointAssociationsPage page) {
      super(page, ListFirewallEndpointAssociationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListFirewallEndpointAssociationsPage
      extends AbstractPage<
          ListFirewallEndpointAssociationsRequest,
          ListFirewallEndpointAssociationsResponse,
          FirewallEndpointAssociation,
          ListFirewallEndpointAssociationsPage> {

    private ListFirewallEndpointAssociationsPage(
        PageContext<
                ListFirewallEndpointAssociationsRequest,
                ListFirewallEndpointAssociationsResponse,
                FirewallEndpointAssociation>
            context,
        ListFirewallEndpointAssociationsResponse response) {
      super(context, response);
    }

    private static ListFirewallEndpointAssociationsPage createEmptyPage() {
      return new ListFirewallEndpointAssociationsPage(null, null);
    }

    @Override
    protected ListFirewallEndpointAssociationsPage createPage(
        PageContext<
                ListFirewallEndpointAssociationsRequest,
                ListFirewallEndpointAssociationsResponse,
                FirewallEndpointAssociation>
            context,
        ListFirewallEndpointAssociationsResponse response) {
      return new ListFirewallEndpointAssociationsPage(context, response);
    }

    @Override
    public ApiFuture<ListFirewallEndpointAssociationsPage> createPageAsync(
        PageContext<
                ListFirewallEndpointAssociationsRequest,
                ListFirewallEndpointAssociationsResponse,
                FirewallEndpointAssociation>
            context,
        ApiFuture<ListFirewallEndpointAssociationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFirewallEndpointAssociationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListFirewallEndpointAssociationsRequest,
          ListFirewallEndpointAssociationsResponse,
          FirewallEndpointAssociation,
          ListFirewallEndpointAssociationsPage,
          ListFirewallEndpointAssociationsFixedSizeCollection> {

    private ListFirewallEndpointAssociationsFixedSizeCollection(
        List<ListFirewallEndpointAssociationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListFirewallEndpointAssociationsFixedSizeCollection createEmptyCollection() {
      return new ListFirewallEndpointAssociationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListFirewallEndpointAssociationsFixedSizeCollection createCollection(
        List<ListFirewallEndpointAssociationsPage> pages, int collectionSize) {
      return new ListFirewallEndpointAssociationsFixedSizeCollection(pages, collectionSize);
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
