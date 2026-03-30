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
import com.google.cloud.networksecurity.v1.stub.OrganizationSecurityProfileGroupServiceStub;
import com.google.cloud.networksecurity.v1.stub.OrganizationSecurityProfileGroupServiceStubSettings;
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
 * Service Description: Organization SecurityProfileGroup is created under organization.
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
 * try (OrganizationSecurityProfileGroupServiceClient
 *     organizationSecurityProfileGroupServiceClient =
 *         OrganizationSecurityProfileGroupServiceClient.create()) {
 *   SecurityProfileGroupName name =
 *       SecurityProfileGroupName.ofOrganizationLocationSecurityProfileGroupName(
 *           "[ORGANIZATION]", "[LOCATION]", "[SECURITY_PROFILE_GROUP]");
 *   SecurityProfileGroup response =
 *       organizationSecurityProfileGroupServiceClient.getSecurityProfileGroup(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the OrganizationSecurityProfileGroupServiceClient object
 * to clean up resources such as threads. In the example above, try-with-resources is used, which
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
 *      <td><p> ListSecurityProfileGroups</td>
 *      <td><p> Lists SecurityProfileGroups in a given organization and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listSecurityProfileGroups(ListSecurityProfileGroupsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listSecurityProfileGroups(LocationName parent)
 *           <li><p> listSecurityProfileGroups(OrganizationLocationName parent)
 *           <li><p> listSecurityProfileGroups(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listSecurityProfileGroupsPagedCallable()
 *           <li><p> listSecurityProfileGroupsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetSecurityProfileGroup</td>
 *      <td><p> Gets details of a single SecurityProfileGroup.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getSecurityProfileGroup(GetSecurityProfileGroupRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getSecurityProfileGroup(SecurityProfileGroupName name)
 *           <li><p> getSecurityProfileGroup(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getSecurityProfileGroupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateSecurityProfileGroup</td>
 *      <td><p> Creates a new SecurityProfileGroup in a given organization and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createSecurityProfileGroupAsync(CreateSecurityProfileGroupRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createSecurityProfileGroupAsync(LocationName parent, SecurityProfileGroup securityProfileGroup, String securityProfileGroupId)
 *           <li><p> createSecurityProfileGroupAsync(OrganizationLocationName parent, SecurityProfileGroup securityProfileGroup, String securityProfileGroupId)
 *           <li><p> createSecurityProfileGroupAsync(String parent, SecurityProfileGroup securityProfileGroup, String securityProfileGroupId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createSecurityProfileGroupOperationCallable()
 *           <li><p> createSecurityProfileGroupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateSecurityProfileGroup</td>
 *      <td><p> Updates the parameters of a single SecurityProfileGroup.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateSecurityProfileGroupAsync(UpdateSecurityProfileGroupRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateSecurityProfileGroupAsync(SecurityProfileGroup securityProfileGroup, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateSecurityProfileGroupOperationCallable()
 *           <li><p> updateSecurityProfileGroupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteSecurityProfileGroup</td>
 *      <td><p> Deletes a single SecurityProfileGroup.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteSecurityProfileGroupAsync(DeleteSecurityProfileGroupRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteSecurityProfileGroupAsync(SecurityProfileGroupName name)
 *           <li><p> deleteSecurityProfileGroupAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteSecurityProfileGroupOperationCallable()
 *           <li><p> deleteSecurityProfileGroupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListSecurityProfiles</td>
 *      <td><p> Lists SecurityProfiles in a given organization and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listSecurityProfiles(ListSecurityProfilesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listSecurityProfiles(LocationName parent)
 *           <li><p> listSecurityProfiles(OrganizationLocationName parent)
 *           <li><p> listSecurityProfiles(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listSecurityProfilesPagedCallable()
 *           <li><p> listSecurityProfilesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetSecurityProfile</td>
 *      <td><p> Gets details of a single SecurityProfile.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getSecurityProfile(GetSecurityProfileRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getSecurityProfile(SecurityProfileName name)
 *           <li><p> getSecurityProfile(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getSecurityProfileCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateSecurityProfile</td>
 *      <td><p> Creates a new SecurityProfile in a given organization and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createSecurityProfileAsync(CreateSecurityProfileRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createSecurityProfileAsync(LocationName parent, SecurityProfile securityProfile, String securityProfileId)
 *           <li><p> createSecurityProfileAsync(OrganizationLocationName parent, SecurityProfile securityProfile, String securityProfileId)
 *           <li><p> createSecurityProfileAsync(String parent, SecurityProfile securityProfile, String securityProfileId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createSecurityProfileOperationCallable()
 *           <li><p> createSecurityProfileCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateSecurityProfile</td>
 *      <td><p> Updates the parameters of a single SecurityProfile.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateSecurityProfileAsync(UpdateSecurityProfileRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateSecurityProfileAsync(SecurityProfile securityProfile, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateSecurityProfileOperationCallable()
 *           <li><p> updateSecurityProfileCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteSecurityProfile</td>
 *      <td><p> Deletes a single SecurityProfile.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteSecurityProfileAsync(DeleteSecurityProfileRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteSecurityProfileAsync(SecurityProfileName name)
 *           <li><p> deleteSecurityProfileAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteSecurityProfileOperationCallable()
 *           <li><p> deleteSecurityProfileCallable()
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
 * <p>This class can be customized by passing in a custom instance of
 * OrganizationSecurityProfileGroupServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * OrganizationSecurityProfileGroupServiceSettings
 *     organizationSecurityProfileGroupServiceSettings =
 *         OrganizationSecurityProfileGroupServiceSettings.newBuilder()
 *             .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *             .build();
 * OrganizationSecurityProfileGroupServiceClient organizationSecurityProfileGroupServiceClient =
 *     OrganizationSecurityProfileGroupServiceClient.create(
 *         organizationSecurityProfileGroupServiceSettings);
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
 * OrganizationSecurityProfileGroupServiceSettings
 *     organizationSecurityProfileGroupServiceSettings =
 *         OrganizationSecurityProfileGroupServiceSettings.newBuilder()
 *             .setEndpoint(myEndpoint)
 *             .build();
 * OrganizationSecurityProfileGroupServiceClient organizationSecurityProfileGroupServiceClient =
 *     OrganizationSecurityProfileGroupServiceClient.create(
 *         organizationSecurityProfileGroupServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class OrganizationSecurityProfileGroupServiceClient implements BackgroundResource {
  private final OrganizationSecurityProfileGroupServiceSettings settings;
  private final OrganizationSecurityProfileGroupServiceStub stub;
  private final OperationsClient operationsClient;

  /**
   * Constructs an instance of OrganizationSecurityProfileGroupServiceClient with default settings.
   */
  public static final OrganizationSecurityProfileGroupServiceClient create() throws IOException {
    return create(OrganizationSecurityProfileGroupServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of OrganizationSecurityProfileGroupServiceClient, using the given
   * settings. The channels are created based on the settings passed in, or defaults for any
   * settings that are not set.
   */
  public static final OrganizationSecurityProfileGroupServiceClient create(
      OrganizationSecurityProfileGroupServiceSettings settings) throws IOException {
    return new OrganizationSecurityProfileGroupServiceClient(settings);
  }

  /**
   * Constructs an instance of OrganizationSecurityProfileGroupServiceClient, using the given stub
   * for making calls. This is for advanced usage - prefer using
   * create(OrganizationSecurityProfileGroupServiceSettings).
   */
  public static final OrganizationSecurityProfileGroupServiceClient create(
      OrganizationSecurityProfileGroupServiceStub stub) {
    return new OrganizationSecurityProfileGroupServiceClient(stub);
  }

  /**
   * Constructs an instance of OrganizationSecurityProfileGroupServiceClient, using the given
   * settings. This is protected so that it is easy to make a subclass, but otherwise, the static
   * factory methods should be preferred.
   */
  protected OrganizationSecurityProfileGroupServiceClient(
      OrganizationSecurityProfileGroupServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub =
        ((OrganizationSecurityProfileGroupServiceStubSettings) settings.getStubSettings())
            .createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  protected OrganizationSecurityProfileGroupServiceClient(
      OrganizationSecurityProfileGroupServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final OrganizationSecurityProfileGroupServiceSettings getSettings() {
    return settings;
  }

  public OrganizationSecurityProfileGroupServiceStub getStub() {
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
   * Lists SecurityProfileGroups in a given organization and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityProfileGroupServiceClient
   *     organizationSecurityProfileGroupServiceClient =
   *         OrganizationSecurityProfileGroupServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (SecurityProfileGroup element :
   *       organizationSecurityProfileGroupServiceClient
   *           .listSecurityProfileGroups(parent)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project or organization and location from which the
   *     SecurityProfileGroups should be listed, specified in the format
   *     `projects|organizations/&#42;/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSecurityProfileGroupsPagedResponse listSecurityProfileGroups(
      LocationName parent) {
    ListSecurityProfileGroupsRequest request =
        ListSecurityProfileGroupsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listSecurityProfileGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists SecurityProfileGroups in a given organization and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityProfileGroupServiceClient
   *     organizationSecurityProfileGroupServiceClient =
   *         OrganizationSecurityProfileGroupServiceClient.create()) {
   *   OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
   *   for (SecurityProfileGroup element :
   *       organizationSecurityProfileGroupServiceClient
   *           .listSecurityProfileGroups(parent)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project or organization and location from which the
   *     SecurityProfileGroups should be listed, specified in the format
   *     `projects|organizations/&#42;/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSecurityProfileGroupsPagedResponse listSecurityProfileGroups(
      OrganizationLocationName parent) {
    ListSecurityProfileGroupsRequest request =
        ListSecurityProfileGroupsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listSecurityProfileGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists SecurityProfileGroups in a given organization and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityProfileGroupServiceClient
   *     organizationSecurityProfileGroupServiceClient =
   *         OrganizationSecurityProfileGroupServiceClient.create()) {
   *   String parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString();
   *   for (SecurityProfileGroup element :
   *       organizationSecurityProfileGroupServiceClient
   *           .listSecurityProfileGroups(parent)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project or organization and location from which the
   *     SecurityProfileGroups should be listed, specified in the format
   *     `projects|organizations/&#42;/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSecurityProfileGroupsPagedResponse listSecurityProfileGroups(String parent) {
    ListSecurityProfileGroupsRequest request =
        ListSecurityProfileGroupsRequest.newBuilder().setParent(parent).build();
    return listSecurityProfileGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists SecurityProfileGroups in a given organization and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityProfileGroupServiceClient
   *     organizationSecurityProfileGroupServiceClient =
   *         OrganizationSecurityProfileGroupServiceClient.create()) {
   *   ListSecurityProfileGroupsRequest request =
   *       ListSecurityProfileGroupsRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (SecurityProfileGroup element :
   *       organizationSecurityProfileGroupServiceClient
   *           .listSecurityProfileGroups(request)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSecurityProfileGroupsPagedResponse listSecurityProfileGroups(
      ListSecurityProfileGroupsRequest request) {
    return listSecurityProfileGroupsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists SecurityProfileGroups in a given organization and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityProfileGroupServiceClient
   *     organizationSecurityProfileGroupServiceClient =
   *         OrganizationSecurityProfileGroupServiceClient.create()) {
   *   ListSecurityProfileGroupsRequest request =
   *       ListSecurityProfileGroupsRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<SecurityProfileGroup> future =
   *       organizationSecurityProfileGroupServiceClient
   *           .listSecurityProfileGroupsPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (SecurityProfileGroup element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListSecurityProfileGroupsRequest, ListSecurityProfileGroupsPagedResponse>
      listSecurityProfileGroupsPagedCallable() {
    return stub.listSecurityProfileGroupsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists SecurityProfileGroups in a given organization and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityProfileGroupServiceClient
   *     organizationSecurityProfileGroupServiceClient =
   *         OrganizationSecurityProfileGroupServiceClient.create()) {
   *   ListSecurityProfileGroupsRequest request =
   *       ListSecurityProfileGroupsRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListSecurityProfileGroupsResponse response =
   *         organizationSecurityProfileGroupServiceClient
   *             .listSecurityProfileGroupsCallable()
   *             .call(request);
   *     for (SecurityProfileGroup element : response.getSecurityProfileGroupsList()) {
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
  public final UnaryCallable<ListSecurityProfileGroupsRequest, ListSecurityProfileGroupsResponse>
      listSecurityProfileGroupsCallable() {
    return stub.listSecurityProfileGroupsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single SecurityProfileGroup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityProfileGroupServiceClient
   *     organizationSecurityProfileGroupServiceClient =
   *         OrganizationSecurityProfileGroupServiceClient.create()) {
   *   SecurityProfileGroupName name =
   *       SecurityProfileGroupName.ofOrganizationLocationSecurityProfileGroupName(
   *           "[ORGANIZATION]", "[LOCATION]", "[SECURITY_PROFILE_GROUP]");
   *   SecurityProfileGroup response =
   *       organizationSecurityProfileGroupServiceClient.getSecurityProfileGroup(name);
   * }
   * }</pre>
   *
   * @param name Required. A name of the SecurityProfileGroup to get. Must be in the format
   *     `projects|organizations/&#42;/locations/{location}/securityProfileGroups/{security_profile_group}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SecurityProfileGroup getSecurityProfileGroup(SecurityProfileGroupName name) {
    GetSecurityProfileGroupRequest request =
        GetSecurityProfileGroupRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getSecurityProfileGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single SecurityProfileGroup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityProfileGroupServiceClient
   *     organizationSecurityProfileGroupServiceClient =
   *         OrganizationSecurityProfileGroupServiceClient.create()) {
   *   String name =
   *       SecurityProfileGroupName.ofOrganizationLocationSecurityProfileGroupName(
   *               "[ORGANIZATION]", "[LOCATION]", "[SECURITY_PROFILE_GROUP]")
   *           .toString();
   *   SecurityProfileGroup response =
   *       organizationSecurityProfileGroupServiceClient.getSecurityProfileGroup(name);
   * }
   * }</pre>
   *
   * @param name Required. A name of the SecurityProfileGroup to get. Must be in the format
   *     `projects|organizations/&#42;/locations/{location}/securityProfileGroups/{security_profile_group}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SecurityProfileGroup getSecurityProfileGroup(String name) {
    GetSecurityProfileGroupRequest request =
        GetSecurityProfileGroupRequest.newBuilder().setName(name).build();
    return getSecurityProfileGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single SecurityProfileGroup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityProfileGroupServiceClient
   *     organizationSecurityProfileGroupServiceClient =
   *         OrganizationSecurityProfileGroupServiceClient.create()) {
   *   GetSecurityProfileGroupRequest request =
   *       GetSecurityProfileGroupRequest.newBuilder()
   *           .setName(
   *               SecurityProfileGroupName.ofOrganizationLocationSecurityProfileGroupName(
   *                       "[ORGANIZATION]", "[LOCATION]", "[SECURITY_PROFILE_GROUP]")
   *                   .toString())
   *           .build();
   *   SecurityProfileGroup response =
   *       organizationSecurityProfileGroupServiceClient.getSecurityProfileGroup(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SecurityProfileGroup getSecurityProfileGroup(
      GetSecurityProfileGroupRequest request) {
    return getSecurityProfileGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single SecurityProfileGroup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityProfileGroupServiceClient
   *     organizationSecurityProfileGroupServiceClient =
   *         OrganizationSecurityProfileGroupServiceClient.create()) {
   *   GetSecurityProfileGroupRequest request =
   *       GetSecurityProfileGroupRequest.newBuilder()
   *           .setName(
   *               SecurityProfileGroupName.ofOrganizationLocationSecurityProfileGroupName(
   *                       "[ORGANIZATION]", "[LOCATION]", "[SECURITY_PROFILE_GROUP]")
   *                   .toString())
   *           .build();
   *   ApiFuture<SecurityProfileGroup> future =
   *       organizationSecurityProfileGroupServiceClient
   *           .getSecurityProfileGroupCallable()
   *           .futureCall(request);
   *   // Do something.
   *   SecurityProfileGroup response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSecurityProfileGroupRequest, SecurityProfileGroup>
      getSecurityProfileGroupCallable() {
    return stub.getSecurityProfileGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new SecurityProfileGroup in a given organization and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityProfileGroupServiceClient
   *     organizationSecurityProfileGroupServiceClient =
   *         OrganizationSecurityProfileGroupServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   SecurityProfileGroup securityProfileGroup = SecurityProfileGroup.newBuilder().build();
   *   String securityProfileGroupId = "securityProfileGroupId-357991055";
   *   SecurityProfileGroup response =
   *       organizationSecurityProfileGroupServiceClient
   *           .createSecurityProfileGroupAsync(parent, securityProfileGroup, securityProfileGroupId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the SecurityProfileGroup. Must be in the format
   *     `projects|organizations/&#42;/locations/{location}`.
   * @param securityProfileGroup Required. SecurityProfileGroup resource to be created.
   * @param securityProfileGroupId Required. Short name of the SecurityProfileGroup resource to be
   *     created. This value should be 1-63 characters long, containing only letters, numbers,
   *     hyphens, and underscores, and should not start with a number. E.g.
   *     "security_profile_group1".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<SecurityProfileGroup, OperationMetadata>
      createSecurityProfileGroupAsync(
          LocationName parent,
          SecurityProfileGroup securityProfileGroup,
          String securityProfileGroupId) {
    CreateSecurityProfileGroupRequest request =
        CreateSecurityProfileGroupRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSecurityProfileGroup(securityProfileGroup)
            .setSecurityProfileGroupId(securityProfileGroupId)
            .build();
    return createSecurityProfileGroupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new SecurityProfileGroup in a given organization and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityProfileGroupServiceClient
   *     organizationSecurityProfileGroupServiceClient =
   *         OrganizationSecurityProfileGroupServiceClient.create()) {
   *   OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
   *   SecurityProfileGroup securityProfileGroup = SecurityProfileGroup.newBuilder().build();
   *   String securityProfileGroupId = "securityProfileGroupId-357991055";
   *   SecurityProfileGroup response =
   *       organizationSecurityProfileGroupServiceClient
   *           .createSecurityProfileGroupAsync(parent, securityProfileGroup, securityProfileGroupId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the SecurityProfileGroup. Must be in the format
   *     `projects|organizations/&#42;/locations/{location}`.
   * @param securityProfileGroup Required. SecurityProfileGroup resource to be created.
   * @param securityProfileGroupId Required. Short name of the SecurityProfileGroup resource to be
   *     created. This value should be 1-63 characters long, containing only letters, numbers,
   *     hyphens, and underscores, and should not start with a number. E.g.
   *     "security_profile_group1".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<SecurityProfileGroup, OperationMetadata>
      createSecurityProfileGroupAsync(
          OrganizationLocationName parent,
          SecurityProfileGroup securityProfileGroup,
          String securityProfileGroupId) {
    CreateSecurityProfileGroupRequest request =
        CreateSecurityProfileGroupRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSecurityProfileGroup(securityProfileGroup)
            .setSecurityProfileGroupId(securityProfileGroupId)
            .build();
    return createSecurityProfileGroupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new SecurityProfileGroup in a given organization and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityProfileGroupServiceClient
   *     organizationSecurityProfileGroupServiceClient =
   *         OrganizationSecurityProfileGroupServiceClient.create()) {
   *   String parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString();
   *   SecurityProfileGroup securityProfileGroup = SecurityProfileGroup.newBuilder().build();
   *   String securityProfileGroupId = "securityProfileGroupId-357991055";
   *   SecurityProfileGroup response =
   *       organizationSecurityProfileGroupServiceClient
   *           .createSecurityProfileGroupAsync(parent, securityProfileGroup, securityProfileGroupId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the SecurityProfileGroup. Must be in the format
   *     `projects|organizations/&#42;/locations/{location}`.
   * @param securityProfileGroup Required. SecurityProfileGroup resource to be created.
   * @param securityProfileGroupId Required. Short name of the SecurityProfileGroup resource to be
   *     created. This value should be 1-63 characters long, containing only letters, numbers,
   *     hyphens, and underscores, and should not start with a number. E.g.
   *     "security_profile_group1".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<SecurityProfileGroup, OperationMetadata>
      createSecurityProfileGroupAsync(
          String parent, SecurityProfileGroup securityProfileGroup, String securityProfileGroupId) {
    CreateSecurityProfileGroupRequest request =
        CreateSecurityProfileGroupRequest.newBuilder()
            .setParent(parent)
            .setSecurityProfileGroup(securityProfileGroup)
            .setSecurityProfileGroupId(securityProfileGroupId)
            .build();
    return createSecurityProfileGroupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new SecurityProfileGroup in a given organization and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityProfileGroupServiceClient
   *     organizationSecurityProfileGroupServiceClient =
   *         OrganizationSecurityProfileGroupServiceClient.create()) {
   *   CreateSecurityProfileGroupRequest request =
   *       CreateSecurityProfileGroupRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setSecurityProfileGroupId("securityProfileGroupId-357991055")
   *           .setSecurityProfileGroup(SecurityProfileGroup.newBuilder().build())
   *           .build();
   *   SecurityProfileGroup response =
   *       organizationSecurityProfileGroupServiceClient
   *           .createSecurityProfileGroupAsync(request)
   *           .get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<SecurityProfileGroup, OperationMetadata>
      createSecurityProfileGroupAsync(CreateSecurityProfileGroupRequest request) {
    return createSecurityProfileGroupOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new SecurityProfileGroup in a given organization and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityProfileGroupServiceClient
   *     organizationSecurityProfileGroupServiceClient =
   *         OrganizationSecurityProfileGroupServiceClient.create()) {
   *   CreateSecurityProfileGroupRequest request =
   *       CreateSecurityProfileGroupRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setSecurityProfileGroupId("securityProfileGroupId-357991055")
   *           .setSecurityProfileGroup(SecurityProfileGroup.newBuilder().build())
   *           .build();
   *   OperationFuture<SecurityProfileGroup, OperationMetadata> future =
   *       organizationSecurityProfileGroupServiceClient
   *           .createSecurityProfileGroupOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   SecurityProfileGroup response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateSecurityProfileGroupRequest, SecurityProfileGroup, OperationMetadata>
      createSecurityProfileGroupOperationCallable() {
    return stub.createSecurityProfileGroupOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new SecurityProfileGroup in a given organization and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityProfileGroupServiceClient
   *     organizationSecurityProfileGroupServiceClient =
   *         OrganizationSecurityProfileGroupServiceClient.create()) {
   *   CreateSecurityProfileGroupRequest request =
   *       CreateSecurityProfileGroupRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setSecurityProfileGroupId("securityProfileGroupId-357991055")
   *           .setSecurityProfileGroup(SecurityProfileGroup.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       organizationSecurityProfileGroupServiceClient
   *           .createSecurityProfileGroupCallable()
   *           .futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateSecurityProfileGroupRequest, Operation>
      createSecurityProfileGroupCallable() {
    return stub.createSecurityProfileGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single SecurityProfileGroup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityProfileGroupServiceClient
   *     organizationSecurityProfileGroupServiceClient =
   *         OrganizationSecurityProfileGroupServiceClient.create()) {
   *   SecurityProfileGroup securityProfileGroup = SecurityProfileGroup.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   SecurityProfileGroup response =
   *       organizationSecurityProfileGroupServiceClient
   *           .updateSecurityProfileGroupAsync(securityProfileGroup, updateMask)
   *           .get();
   * }
   * }</pre>
   *
   * @param securityProfileGroup Required. Updated SecurityProfileGroup resource.
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     SecurityProfileGroup resource by the update. The fields specified in the update_mask are
   *     relative to the resource, not the full request. A field will be overwritten if it is in the
   *     mask.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<SecurityProfileGroup, OperationMetadata>
      updateSecurityProfileGroupAsync(
          SecurityProfileGroup securityProfileGroup, FieldMask updateMask) {
    UpdateSecurityProfileGroupRequest request =
        UpdateSecurityProfileGroupRequest.newBuilder()
            .setSecurityProfileGroup(securityProfileGroup)
            .setUpdateMask(updateMask)
            .build();
    return updateSecurityProfileGroupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single SecurityProfileGroup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityProfileGroupServiceClient
   *     organizationSecurityProfileGroupServiceClient =
   *         OrganizationSecurityProfileGroupServiceClient.create()) {
   *   UpdateSecurityProfileGroupRequest request =
   *       UpdateSecurityProfileGroupRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setSecurityProfileGroup(SecurityProfileGroup.newBuilder().build())
   *           .build();
   *   SecurityProfileGroup response =
   *       organizationSecurityProfileGroupServiceClient
   *           .updateSecurityProfileGroupAsync(request)
   *           .get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<SecurityProfileGroup, OperationMetadata>
      updateSecurityProfileGroupAsync(UpdateSecurityProfileGroupRequest request) {
    return updateSecurityProfileGroupOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single SecurityProfileGroup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityProfileGroupServiceClient
   *     organizationSecurityProfileGroupServiceClient =
   *         OrganizationSecurityProfileGroupServiceClient.create()) {
   *   UpdateSecurityProfileGroupRequest request =
   *       UpdateSecurityProfileGroupRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setSecurityProfileGroup(SecurityProfileGroup.newBuilder().build())
   *           .build();
   *   OperationFuture<SecurityProfileGroup, OperationMetadata> future =
   *       organizationSecurityProfileGroupServiceClient
   *           .updateSecurityProfileGroupOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   SecurityProfileGroup response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UpdateSecurityProfileGroupRequest, SecurityProfileGroup, OperationMetadata>
      updateSecurityProfileGroupOperationCallable() {
    return stub.updateSecurityProfileGroupOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single SecurityProfileGroup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityProfileGroupServiceClient
   *     organizationSecurityProfileGroupServiceClient =
   *         OrganizationSecurityProfileGroupServiceClient.create()) {
   *   UpdateSecurityProfileGroupRequest request =
   *       UpdateSecurityProfileGroupRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setSecurityProfileGroup(SecurityProfileGroup.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       organizationSecurityProfileGroupServiceClient
   *           .updateSecurityProfileGroupCallable()
   *           .futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateSecurityProfileGroupRequest, Operation>
      updateSecurityProfileGroupCallable() {
    return stub.updateSecurityProfileGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single SecurityProfileGroup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityProfileGroupServiceClient
   *     organizationSecurityProfileGroupServiceClient =
   *         OrganizationSecurityProfileGroupServiceClient.create()) {
   *   SecurityProfileGroupName name =
   *       SecurityProfileGroupName.ofOrganizationLocationSecurityProfileGroupName(
   *           "[ORGANIZATION]", "[LOCATION]", "[SECURITY_PROFILE_GROUP]");
   *   organizationSecurityProfileGroupServiceClient.deleteSecurityProfileGroupAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. A name of the SecurityProfileGroup to delete. Must be in the format
   *     `projects|organizations/&#42;/locations/{location}/securityProfileGroups/{security_profile_group}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteSecurityProfileGroupAsync(
      SecurityProfileGroupName name) {
    DeleteSecurityProfileGroupRequest request =
        DeleteSecurityProfileGroupRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteSecurityProfileGroupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single SecurityProfileGroup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityProfileGroupServiceClient
   *     organizationSecurityProfileGroupServiceClient =
   *         OrganizationSecurityProfileGroupServiceClient.create()) {
   *   String name =
   *       SecurityProfileGroupName.ofOrganizationLocationSecurityProfileGroupName(
   *               "[ORGANIZATION]", "[LOCATION]", "[SECURITY_PROFILE_GROUP]")
   *           .toString();
   *   organizationSecurityProfileGroupServiceClient.deleteSecurityProfileGroupAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. A name of the SecurityProfileGroup to delete. Must be in the format
   *     `projects|organizations/&#42;/locations/{location}/securityProfileGroups/{security_profile_group}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteSecurityProfileGroupAsync(
      String name) {
    DeleteSecurityProfileGroupRequest request =
        DeleteSecurityProfileGroupRequest.newBuilder().setName(name).build();
    return deleteSecurityProfileGroupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single SecurityProfileGroup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityProfileGroupServiceClient
   *     organizationSecurityProfileGroupServiceClient =
   *         OrganizationSecurityProfileGroupServiceClient.create()) {
   *   DeleteSecurityProfileGroupRequest request =
   *       DeleteSecurityProfileGroupRequest.newBuilder()
   *           .setName(
   *               SecurityProfileGroupName.ofOrganizationLocationSecurityProfileGroupName(
   *                       "[ORGANIZATION]", "[LOCATION]", "[SECURITY_PROFILE_GROUP]")
   *                   .toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   organizationSecurityProfileGroupServiceClient.deleteSecurityProfileGroupAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteSecurityProfileGroupAsync(
      DeleteSecurityProfileGroupRequest request) {
    return deleteSecurityProfileGroupOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single SecurityProfileGroup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityProfileGroupServiceClient
   *     organizationSecurityProfileGroupServiceClient =
   *         OrganizationSecurityProfileGroupServiceClient.create()) {
   *   DeleteSecurityProfileGroupRequest request =
   *       DeleteSecurityProfileGroupRequest.newBuilder()
   *           .setName(
   *               SecurityProfileGroupName.ofOrganizationLocationSecurityProfileGroupName(
   *                       "[ORGANIZATION]", "[LOCATION]", "[SECURITY_PROFILE_GROUP]")
   *                   .toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       organizationSecurityProfileGroupServiceClient
   *           .deleteSecurityProfileGroupOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteSecurityProfileGroupRequest, Empty, OperationMetadata>
      deleteSecurityProfileGroupOperationCallable() {
    return stub.deleteSecurityProfileGroupOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single SecurityProfileGroup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityProfileGroupServiceClient
   *     organizationSecurityProfileGroupServiceClient =
   *         OrganizationSecurityProfileGroupServiceClient.create()) {
   *   DeleteSecurityProfileGroupRequest request =
   *       DeleteSecurityProfileGroupRequest.newBuilder()
   *           .setName(
   *               SecurityProfileGroupName.ofOrganizationLocationSecurityProfileGroupName(
   *                       "[ORGANIZATION]", "[LOCATION]", "[SECURITY_PROFILE_GROUP]")
   *                   .toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Operation> future =
   *       organizationSecurityProfileGroupServiceClient
   *           .deleteSecurityProfileGroupCallable()
   *           .futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteSecurityProfileGroupRequest, Operation>
      deleteSecurityProfileGroupCallable() {
    return stub.deleteSecurityProfileGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists SecurityProfiles in a given organization and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityProfileGroupServiceClient
   *     organizationSecurityProfileGroupServiceClient =
   *         OrganizationSecurityProfileGroupServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (SecurityProfile element :
   *       organizationSecurityProfileGroupServiceClient.listSecurityProfiles(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project or organization and location from which the
   *     SecurityProfiles should be listed, specified in the format
   *     `projects|organizations/&#42;/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSecurityProfilesPagedResponse listSecurityProfiles(LocationName parent) {
    ListSecurityProfilesRequest request =
        ListSecurityProfilesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listSecurityProfiles(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists SecurityProfiles in a given organization and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityProfileGroupServiceClient
   *     organizationSecurityProfileGroupServiceClient =
   *         OrganizationSecurityProfileGroupServiceClient.create()) {
   *   OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
   *   for (SecurityProfile element :
   *       organizationSecurityProfileGroupServiceClient.listSecurityProfiles(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project or organization and location from which the
   *     SecurityProfiles should be listed, specified in the format
   *     `projects|organizations/&#42;/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSecurityProfilesPagedResponse listSecurityProfiles(
      OrganizationLocationName parent) {
    ListSecurityProfilesRequest request =
        ListSecurityProfilesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listSecurityProfiles(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists SecurityProfiles in a given organization and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityProfileGroupServiceClient
   *     organizationSecurityProfileGroupServiceClient =
   *         OrganizationSecurityProfileGroupServiceClient.create()) {
   *   String parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString();
   *   for (SecurityProfile element :
   *       organizationSecurityProfileGroupServiceClient.listSecurityProfiles(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project or organization and location from which the
   *     SecurityProfiles should be listed, specified in the format
   *     `projects|organizations/&#42;/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSecurityProfilesPagedResponse listSecurityProfiles(String parent) {
    ListSecurityProfilesRequest request =
        ListSecurityProfilesRequest.newBuilder().setParent(parent).build();
    return listSecurityProfiles(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists SecurityProfiles in a given organization and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityProfileGroupServiceClient
   *     organizationSecurityProfileGroupServiceClient =
   *         OrganizationSecurityProfileGroupServiceClient.create()) {
   *   ListSecurityProfilesRequest request =
   *       ListSecurityProfilesRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (SecurityProfile element :
   *       organizationSecurityProfileGroupServiceClient
   *           .listSecurityProfiles(request)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSecurityProfilesPagedResponse listSecurityProfiles(
      ListSecurityProfilesRequest request) {
    return listSecurityProfilesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists SecurityProfiles in a given organization and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityProfileGroupServiceClient
   *     organizationSecurityProfileGroupServiceClient =
   *         OrganizationSecurityProfileGroupServiceClient.create()) {
   *   ListSecurityProfilesRequest request =
   *       ListSecurityProfilesRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<SecurityProfile> future =
   *       organizationSecurityProfileGroupServiceClient
   *           .listSecurityProfilesPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (SecurityProfile element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListSecurityProfilesRequest, ListSecurityProfilesPagedResponse>
      listSecurityProfilesPagedCallable() {
    return stub.listSecurityProfilesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists SecurityProfiles in a given organization and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityProfileGroupServiceClient
   *     organizationSecurityProfileGroupServiceClient =
   *         OrganizationSecurityProfileGroupServiceClient.create()) {
   *   ListSecurityProfilesRequest request =
   *       ListSecurityProfilesRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListSecurityProfilesResponse response =
   *         organizationSecurityProfileGroupServiceClient
   *             .listSecurityProfilesCallable()
   *             .call(request);
   *     for (SecurityProfile element : response.getSecurityProfilesList()) {
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
  public final UnaryCallable<ListSecurityProfilesRequest, ListSecurityProfilesResponse>
      listSecurityProfilesCallable() {
    return stub.listSecurityProfilesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single SecurityProfile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityProfileGroupServiceClient
   *     organizationSecurityProfileGroupServiceClient =
   *         OrganizationSecurityProfileGroupServiceClient.create()) {
   *   SecurityProfileName name =
   *       SecurityProfileName.ofOrganizationLocationSecurityProfileName(
   *           "[ORGANIZATION]", "[LOCATION]", "[SECURITY_PROFILE]");
   *   SecurityProfile response =
   *       organizationSecurityProfileGroupServiceClient.getSecurityProfile(name);
   * }
   * }</pre>
   *
   * @param name Required. A name of the SecurityProfile to get. Must be in the format
   *     `projects|organizations/&#42;/locations/{location}/securityProfiles/{security_profile_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SecurityProfile getSecurityProfile(SecurityProfileName name) {
    GetSecurityProfileRequest request =
        GetSecurityProfileRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getSecurityProfile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single SecurityProfile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityProfileGroupServiceClient
   *     organizationSecurityProfileGroupServiceClient =
   *         OrganizationSecurityProfileGroupServiceClient.create()) {
   *   String name =
   *       SecurityProfileName.ofOrganizationLocationSecurityProfileName(
   *               "[ORGANIZATION]", "[LOCATION]", "[SECURITY_PROFILE]")
   *           .toString();
   *   SecurityProfile response =
   *       organizationSecurityProfileGroupServiceClient.getSecurityProfile(name);
   * }
   * }</pre>
   *
   * @param name Required. A name of the SecurityProfile to get. Must be in the format
   *     `projects|organizations/&#42;/locations/{location}/securityProfiles/{security_profile_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SecurityProfile getSecurityProfile(String name) {
    GetSecurityProfileRequest request =
        GetSecurityProfileRequest.newBuilder().setName(name).build();
    return getSecurityProfile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single SecurityProfile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityProfileGroupServiceClient
   *     organizationSecurityProfileGroupServiceClient =
   *         OrganizationSecurityProfileGroupServiceClient.create()) {
   *   GetSecurityProfileRequest request =
   *       GetSecurityProfileRequest.newBuilder()
   *           .setName(
   *               SecurityProfileName.ofOrganizationLocationSecurityProfileName(
   *                       "[ORGANIZATION]", "[LOCATION]", "[SECURITY_PROFILE]")
   *                   .toString())
   *           .build();
   *   SecurityProfile response =
   *       organizationSecurityProfileGroupServiceClient.getSecurityProfile(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SecurityProfile getSecurityProfile(GetSecurityProfileRequest request) {
    return getSecurityProfileCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single SecurityProfile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityProfileGroupServiceClient
   *     organizationSecurityProfileGroupServiceClient =
   *         OrganizationSecurityProfileGroupServiceClient.create()) {
   *   GetSecurityProfileRequest request =
   *       GetSecurityProfileRequest.newBuilder()
   *           .setName(
   *               SecurityProfileName.ofOrganizationLocationSecurityProfileName(
   *                       "[ORGANIZATION]", "[LOCATION]", "[SECURITY_PROFILE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<SecurityProfile> future =
   *       organizationSecurityProfileGroupServiceClient
   *           .getSecurityProfileCallable()
   *           .futureCall(request);
   *   // Do something.
   *   SecurityProfile response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSecurityProfileRequest, SecurityProfile>
      getSecurityProfileCallable() {
    return stub.getSecurityProfileCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new SecurityProfile in a given organization and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityProfileGroupServiceClient
   *     organizationSecurityProfileGroupServiceClient =
   *         OrganizationSecurityProfileGroupServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   SecurityProfile securityProfile = SecurityProfile.newBuilder().build();
   *   String securityProfileId = "securityProfileId-1121673916";
   *   SecurityProfile response =
   *       organizationSecurityProfileGroupServiceClient
   *           .createSecurityProfileAsync(parent, securityProfile, securityProfileId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the SecurityProfile. Must be in the format
   *     `projects|organizations/&#42;/locations/{location}`.
   * @param securityProfile Required. SecurityProfile resource to be created.
   * @param securityProfileId Required. Short name of the SecurityProfile resource to be created.
   *     This value should be 1-63 characters long, containing only letters, numbers, hyphens, and
   *     underscores, and should not start with a number. E.g. "security_profile1".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<SecurityProfile, OperationMetadata> createSecurityProfileAsync(
      LocationName parent, SecurityProfile securityProfile, String securityProfileId) {
    CreateSecurityProfileRequest request =
        CreateSecurityProfileRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSecurityProfile(securityProfile)
            .setSecurityProfileId(securityProfileId)
            .build();
    return createSecurityProfileAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new SecurityProfile in a given organization and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityProfileGroupServiceClient
   *     organizationSecurityProfileGroupServiceClient =
   *         OrganizationSecurityProfileGroupServiceClient.create()) {
   *   OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
   *   SecurityProfile securityProfile = SecurityProfile.newBuilder().build();
   *   String securityProfileId = "securityProfileId-1121673916";
   *   SecurityProfile response =
   *       organizationSecurityProfileGroupServiceClient
   *           .createSecurityProfileAsync(parent, securityProfile, securityProfileId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the SecurityProfile. Must be in the format
   *     `projects|organizations/&#42;/locations/{location}`.
   * @param securityProfile Required. SecurityProfile resource to be created.
   * @param securityProfileId Required. Short name of the SecurityProfile resource to be created.
   *     This value should be 1-63 characters long, containing only letters, numbers, hyphens, and
   *     underscores, and should not start with a number. E.g. "security_profile1".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<SecurityProfile, OperationMetadata> createSecurityProfileAsync(
      OrganizationLocationName parent, SecurityProfile securityProfile, String securityProfileId) {
    CreateSecurityProfileRequest request =
        CreateSecurityProfileRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSecurityProfile(securityProfile)
            .setSecurityProfileId(securityProfileId)
            .build();
    return createSecurityProfileAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new SecurityProfile in a given organization and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityProfileGroupServiceClient
   *     organizationSecurityProfileGroupServiceClient =
   *         OrganizationSecurityProfileGroupServiceClient.create()) {
   *   String parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString();
   *   SecurityProfile securityProfile = SecurityProfile.newBuilder().build();
   *   String securityProfileId = "securityProfileId-1121673916";
   *   SecurityProfile response =
   *       organizationSecurityProfileGroupServiceClient
   *           .createSecurityProfileAsync(parent, securityProfile, securityProfileId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the SecurityProfile. Must be in the format
   *     `projects|organizations/&#42;/locations/{location}`.
   * @param securityProfile Required. SecurityProfile resource to be created.
   * @param securityProfileId Required. Short name of the SecurityProfile resource to be created.
   *     This value should be 1-63 characters long, containing only letters, numbers, hyphens, and
   *     underscores, and should not start with a number. E.g. "security_profile1".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<SecurityProfile, OperationMetadata> createSecurityProfileAsync(
      String parent, SecurityProfile securityProfile, String securityProfileId) {
    CreateSecurityProfileRequest request =
        CreateSecurityProfileRequest.newBuilder()
            .setParent(parent)
            .setSecurityProfile(securityProfile)
            .setSecurityProfileId(securityProfileId)
            .build();
    return createSecurityProfileAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new SecurityProfile in a given organization and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityProfileGroupServiceClient
   *     organizationSecurityProfileGroupServiceClient =
   *         OrganizationSecurityProfileGroupServiceClient.create()) {
   *   CreateSecurityProfileRequest request =
   *       CreateSecurityProfileRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setSecurityProfileId("securityProfileId-1121673916")
   *           .setSecurityProfile(SecurityProfile.newBuilder().build())
   *           .build();
   *   SecurityProfile response =
   *       organizationSecurityProfileGroupServiceClient.createSecurityProfileAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<SecurityProfile, OperationMetadata> createSecurityProfileAsync(
      CreateSecurityProfileRequest request) {
    return createSecurityProfileOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new SecurityProfile in a given organization and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityProfileGroupServiceClient
   *     organizationSecurityProfileGroupServiceClient =
   *         OrganizationSecurityProfileGroupServiceClient.create()) {
   *   CreateSecurityProfileRequest request =
   *       CreateSecurityProfileRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setSecurityProfileId("securityProfileId-1121673916")
   *           .setSecurityProfile(SecurityProfile.newBuilder().build())
   *           .build();
   *   OperationFuture<SecurityProfile, OperationMetadata> future =
   *       organizationSecurityProfileGroupServiceClient
   *           .createSecurityProfileOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   SecurityProfile response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateSecurityProfileRequest, SecurityProfile, OperationMetadata>
      createSecurityProfileOperationCallable() {
    return stub.createSecurityProfileOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new SecurityProfile in a given organization and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityProfileGroupServiceClient
   *     organizationSecurityProfileGroupServiceClient =
   *         OrganizationSecurityProfileGroupServiceClient.create()) {
   *   CreateSecurityProfileRequest request =
   *       CreateSecurityProfileRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setSecurityProfileId("securityProfileId-1121673916")
   *           .setSecurityProfile(SecurityProfile.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       organizationSecurityProfileGroupServiceClient
   *           .createSecurityProfileCallable()
   *           .futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateSecurityProfileRequest, Operation>
      createSecurityProfileCallable() {
    return stub.createSecurityProfileCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single SecurityProfile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityProfileGroupServiceClient
   *     organizationSecurityProfileGroupServiceClient =
   *         OrganizationSecurityProfileGroupServiceClient.create()) {
   *   SecurityProfile securityProfile = SecurityProfile.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   SecurityProfile response =
   *       organizationSecurityProfileGroupServiceClient
   *           .updateSecurityProfileAsync(securityProfile, updateMask)
   *           .get();
   * }
   * }</pre>
   *
   * @param securityProfile Required. Updated SecurityProfile resource.
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     SecurityProfile resource by the update. The fields specified in the update_mask are
   *     relative to the resource, not the full request. A field will be overwritten if it is in the
   *     mask.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<SecurityProfile, OperationMetadata> updateSecurityProfileAsync(
      SecurityProfile securityProfile, FieldMask updateMask) {
    UpdateSecurityProfileRequest request =
        UpdateSecurityProfileRequest.newBuilder()
            .setSecurityProfile(securityProfile)
            .setUpdateMask(updateMask)
            .build();
    return updateSecurityProfileAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single SecurityProfile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityProfileGroupServiceClient
   *     organizationSecurityProfileGroupServiceClient =
   *         OrganizationSecurityProfileGroupServiceClient.create()) {
   *   UpdateSecurityProfileRequest request =
   *       UpdateSecurityProfileRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setSecurityProfile(SecurityProfile.newBuilder().build())
   *           .build();
   *   SecurityProfile response =
   *       organizationSecurityProfileGroupServiceClient.updateSecurityProfileAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<SecurityProfile, OperationMetadata> updateSecurityProfileAsync(
      UpdateSecurityProfileRequest request) {
    return updateSecurityProfileOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single SecurityProfile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityProfileGroupServiceClient
   *     organizationSecurityProfileGroupServiceClient =
   *         OrganizationSecurityProfileGroupServiceClient.create()) {
   *   UpdateSecurityProfileRequest request =
   *       UpdateSecurityProfileRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setSecurityProfile(SecurityProfile.newBuilder().build())
   *           .build();
   *   OperationFuture<SecurityProfile, OperationMetadata> future =
   *       organizationSecurityProfileGroupServiceClient
   *           .updateSecurityProfileOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   SecurityProfile response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateSecurityProfileRequest, SecurityProfile, OperationMetadata>
      updateSecurityProfileOperationCallable() {
    return stub.updateSecurityProfileOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single SecurityProfile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityProfileGroupServiceClient
   *     organizationSecurityProfileGroupServiceClient =
   *         OrganizationSecurityProfileGroupServiceClient.create()) {
   *   UpdateSecurityProfileRequest request =
   *       UpdateSecurityProfileRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setSecurityProfile(SecurityProfile.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       organizationSecurityProfileGroupServiceClient
   *           .updateSecurityProfileCallable()
   *           .futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateSecurityProfileRequest, Operation>
      updateSecurityProfileCallable() {
    return stub.updateSecurityProfileCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single SecurityProfile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityProfileGroupServiceClient
   *     organizationSecurityProfileGroupServiceClient =
   *         OrganizationSecurityProfileGroupServiceClient.create()) {
   *   SecurityProfileName name =
   *       SecurityProfileName.ofOrganizationLocationSecurityProfileName(
   *           "[ORGANIZATION]", "[LOCATION]", "[SECURITY_PROFILE]");
   *   organizationSecurityProfileGroupServiceClient.deleteSecurityProfileAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. A name of the SecurityProfile to delete. Must be in the format
   *     `projects|organizations/&#42;/locations/{location}/securityProfiles/{security_profile_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteSecurityProfileAsync(
      SecurityProfileName name) {
    DeleteSecurityProfileRequest request =
        DeleteSecurityProfileRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteSecurityProfileAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single SecurityProfile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityProfileGroupServiceClient
   *     organizationSecurityProfileGroupServiceClient =
   *         OrganizationSecurityProfileGroupServiceClient.create()) {
   *   String name =
   *       SecurityProfileName.ofOrganizationLocationSecurityProfileName(
   *               "[ORGANIZATION]", "[LOCATION]", "[SECURITY_PROFILE]")
   *           .toString();
   *   organizationSecurityProfileGroupServiceClient.deleteSecurityProfileAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. A name of the SecurityProfile to delete. Must be in the format
   *     `projects|organizations/&#42;/locations/{location}/securityProfiles/{security_profile_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteSecurityProfileAsync(String name) {
    DeleteSecurityProfileRequest request =
        DeleteSecurityProfileRequest.newBuilder().setName(name).build();
    return deleteSecurityProfileAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single SecurityProfile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityProfileGroupServiceClient
   *     organizationSecurityProfileGroupServiceClient =
   *         OrganizationSecurityProfileGroupServiceClient.create()) {
   *   DeleteSecurityProfileRequest request =
   *       DeleteSecurityProfileRequest.newBuilder()
   *           .setName(
   *               SecurityProfileName.ofOrganizationLocationSecurityProfileName(
   *                       "[ORGANIZATION]", "[LOCATION]", "[SECURITY_PROFILE]")
   *                   .toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   organizationSecurityProfileGroupServiceClient.deleteSecurityProfileAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteSecurityProfileAsync(
      DeleteSecurityProfileRequest request) {
    return deleteSecurityProfileOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single SecurityProfile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityProfileGroupServiceClient
   *     organizationSecurityProfileGroupServiceClient =
   *         OrganizationSecurityProfileGroupServiceClient.create()) {
   *   DeleteSecurityProfileRequest request =
   *       DeleteSecurityProfileRequest.newBuilder()
   *           .setName(
   *               SecurityProfileName.ofOrganizationLocationSecurityProfileName(
   *                       "[ORGANIZATION]", "[LOCATION]", "[SECURITY_PROFILE]")
   *                   .toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       organizationSecurityProfileGroupServiceClient
   *           .deleteSecurityProfileOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteSecurityProfileRequest, Empty, OperationMetadata>
      deleteSecurityProfileOperationCallable() {
    return stub.deleteSecurityProfileOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single SecurityProfile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityProfileGroupServiceClient
   *     organizationSecurityProfileGroupServiceClient =
   *         OrganizationSecurityProfileGroupServiceClient.create()) {
   *   DeleteSecurityProfileRequest request =
   *       DeleteSecurityProfileRequest.newBuilder()
   *           .setName(
   *               SecurityProfileName.ofOrganizationLocationSecurityProfileName(
   *                       "[ORGANIZATION]", "[LOCATION]", "[SECURITY_PROFILE]")
   *                   .toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Operation> future =
   *       organizationSecurityProfileGroupServiceClient
   *           .deleteSecurityProfileCallable()
   *           .futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteSecurityProfileRequest, Operation>
      deleteSecurityProfileCallable() {
    return stub.deleteSecurityProfileCallable();
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
   * try (OrganizationSecurityProfileGroupServiceClient
   *     organizationSecurityProfileGroupServiceClient =
   *         OrganizationSecurityProfileGroupServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element :
   *       organizationSecurityProfileGroupServiceClient.listLocations(request).iterateAll()) {
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
   * try (OrganizationSecurityProfileGroupServiceClient
   *     organizationSecurityProfileGroupServiceClient =
   *         OrganizationSecurityProfileGroupServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       organizationSecurityProfileGroupServiceClient
   *           .listLocationsPagedCallable()
   *           .futureCall(request);
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
   * try (OrganizationSecurityProfileGroupServiceClient
   *     organizationSecurityProfileGroupServiceClient =
   *         OrganizationSecurityProfileGroupServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         organizationSecurityProfileGroupServiceClient.listLocationsCallable().call(request);
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
   * try (OrganizationSecurityProfileGroupServiceClient
   *     organizationSecurityProfileGroupServiceClient =
   *         OrganizationSecurityProfileGroupServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = organizationSecurityProfileGroupServiceClient.getLocation(request);
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
   * try (OrganizationSecurityProfileGroupServiceClient
   *     organizationSecurityProfileGroupServiceClient =
   *         OrganizationSecurityProfileGroupServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future =
   *       organizationSecurityProfileGroupServiceClient.getLocationCallable().futureCall(request);
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
   * try (OrganizationSecurityProfileGroupServiceClient
   *     organizationSecurityProfileGroupServiceClient =
   *         OrganizationSecurityProfileGroupServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AddressGroupName.ofProjectLocationAddressGroupName(
   *                       "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = organizationSecurityProfileGroupServiceClient.setIamPolicy(request);
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
   * try (OrganizationSecurityProfileGroupServiceClient
   *     organizationSecurityProfileGroupServiceClient =
   *         OrganizationSecurityProfileGroupServiceClient.create()) {
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
   *       organizationSecurityProfileGroupServiceClient.setIamPolicyCallable().futureCall(request);
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
   * try (OrganizationSecurityProfileGroupServiceClient
   *     organizationSecurityProfileGroupServiceClient =
   *         OrganizationSecurityProfileGroupServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AddressGroupName.ofProjectLocationAddressGroupName(
   *                       "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = organizationSecurityProfileGroupServiceClient.getIamPolicy(request);
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
   * try (OrganizationSecurityProfileGroupServiceClient
   *     organizationSecurityProfileGroupServiceClient =
   *         OrganizationSecurityProfileGroupServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AddressGroupName.ofProjectLocationAddressGroupName(
   *                       "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       organizationSecurityProfileGroupServiceClient.getIamPolicyCallable().futureCall(request);
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
   * try (OrganizationSecurityProfileGroupServiceClient
   *     organizationSecurityProfileGroupServiceClient =
   *         OrganizationSecurityProfileGroupServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               AddressGroupName.ofProjectLocationAddressGroupName(
   *                       "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response =
   *       organizationSecurityProfileGroupServiceClient.testIamPermissions(request);
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
   * try (OrganizationSecurityProfileGroupServiceClient
   *     organizationSecurityProfileGroupServiceClient =
   *         OrganizationSecurityProfileGroupServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               AddressGroupName.ofProjectLocationAddressGroupName(
   *                       "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       organizationSecurityProfileGroupServiceClient
   *           .testIamPermissionsCallable()
   *           .futureCall(request);
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

  public static class ListSecurityProfileGroupsPagedResponse
      extends AbstractPagedListResponse<
          ListSecurityProfileGroupsRequest,
          ListSecurityProfileGroupsResponse,
          SecurityProfileGroup,
          ListSecurityProfileGroupsPage,
          ListSecurityProfileGroupsFixedSizeCollection> {

    public static ApiFuture<ListSecurityProfileGroupsPagedResponse> createAsync(
        PageContext<
                ListSecurityProfileGroupsRequest,
                ListSecurityProfileGroupsResponse,
                SecurityProfileGroup>
            context,
        ApiFuture<ListSecurityProfileGroupsResponse> futureResponse) {
      ApiFuture<ListSecurityProfileGroupsPage> futurePage =
          ListSecurityProfileGroupsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListSecurityProfileGroupsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListSecurityProfileGroupsPagedResponse(ListSecurityProfileGroupsPage page) {
      super(page, ListSecurityProfileGroupsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSecurityProfileGroupsPage
      extends AbstractPage<
          ListSecurityProfileGroupsRequest,
          ListSecurityProfileGroupsResponse,
          SecurityProfileGroup,
          ListSecurityProfileGroupsPage> {

    private ListSecurityProfileGroupsPage(
        PageContext<
                ListSecurityProfileGroupsRequest,
                ListSecurityProfileGroupsResponse,
                SecurityProfileGroup>
            context,
        ListSecurityProfileGroupsResponse response) {
      super(context, response);
    }

    private static ListSecurityProfileGroupsPage createEmptyPage() {
      return new ListSecurityProfileGroupsPage(null, null);
    }

    @Override
    protected ListSecurityProfileGroupsPage createPage(
        PageContext<
                ListSecurityProfileGroupsRequest,
                ListSecurityProfileGroupsResponse,
                SecurityProfileGroup>
            context,
        ListSecurityProfileGroupsResponse response) {
      return new ListSecurityProfileGroupsPage(context, response);
    }

    @Override
    public ApiFuture<ListSecurityProfileGroupsPage> createPageAsync(
        PageContext<
                ListSecurityProfileGroupsRequest,
                ListSecurityProfileGroupsResponse,
                SecurityProfileGroup>
            context,
        ApiFuture<ListSecurityProfileGroupsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSecurityProfileGroupsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSecurityProfileGroupsRequest,
          ListSecurityProfileGroupsResponse,
          SecurityProfileGroup,
          ListSecurityProfileGroupsPage,
          ListSecurityProfileGroupsFixedSizeCollection> {

    private ListSecurityProfileGroupsFixedSizeCollection(
        List<ListSecurityProfileGroupsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSecurityProfileGroupsFixedSizeCollection createEmptyCollection() {
      return new ListSecurityProfileGroupsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSecurityProfileGroupsFixedSizeCollection createCollection(
        List<ListSecurityProfileGroupsPage> pages, int collectionSize) {
      return new ListSecurityProfileGroupsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListSecurityProfilesPagedResponse
      extends AbstractPagedListResponse<
          ListSecurityProfilesRequest,
          ListSecurityProfilesResponse,
          SecurityProfile,
          ListSecurityProfilesPage,
          ListSecurityProfilesFixedSizeCollection> {

    public static ApiFuture<ListSecurityProfilesPagedResponse> createAsync(
        PageContext<ListSecurityProfilesRequest, ListSecurityProfilesResponse, SecurityProfile>
            context,
        ApiFuture<ListSecurityProfilesResponse> futureResponse) {
      ApiFuture<ListSecurityProfilesPage> futurePage =
          ListSecurityProfilesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListSecurityProfilesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListSecurityProfilesPagedResponse(ListSecurityProfilesPage page) {
      super(page, ListSecurityProfilesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSecurityProfilesPage
      extends AbstractPage<
          ListSecurityProfilesRequest,
          ListSecurityProfilesResponse,
          SecurityProfile,
          ListSecurityProfilesPage> {

    private ListSecurityProfilesPage(
        PageContext<ListSecurityProfilesRequest, ListSecurityProfilesResponse, SecurityProfile>
            context,
        ListSecurityProfilesResponse response) {
      super(context, response);
    }

    private static ListSecurityProfilesPage createEmptyPage() {
      return new ListSecurityProfilesPage(null, null);
    }

    @Override
    protected ListSecurityProfilesPage createPage(
        PageContext<ListSecurityProfilesRequest, ListSecurityProfilesResponse, SecurityProfile>
            context,
        ListSecurityProfilesResponse response) {
      return new ListSecurityProfilesPage(context, response);
    }

    @Override
    public ApiFuture<ListSecurityProfilesPage> createPageAsync(
        PageContext<ListSecurityProfilesRequest, ListSecurityProfilesResponse, SecurityProfile>
            context,
        ApiFuture<ListSecurityProfilesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSecurityProfilesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSecurityProfilesRequest,
          ListSecurityProfilesResponse,
          SecurityProfile,
          ListSecurityProfilesPage,
          ListSecurityProfilesFixedSizeCollection> {

    private ListSecurityProfilesFixedSizeCollection(
        List<ListSecurityProfilesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSecurityProfilesFixedSizeCollection createEmptyCollection() {
      return new ListSecurityProfilesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSecurityProfilesFixedSizeCollection createCollection(
        List<ListSecurityProfilesPage> pages, int collectionSize) {
      return new ListSecurityProfilesFixedSizeCollection(pages, collectionSize);
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
