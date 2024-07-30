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

package com.google.cloud.privilegedaccessmanager.v1;

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
import com.google.cloud.privilegedaccessmanager.v1.stub.PrivilegedAccessManagerStub;
import com.google.cloud.privilegedaccessmanager.v1.stub.PrivilegedAccessManagerStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: This API allows customers to manage temporary, request based privileged
 * access to their resources.
 *
 * <p>It defines the following resource model:
 *
 * <ul>
 *   <li>A collection of `Entitlement` resources. An entitlement allows configuring (among other
 *       things):
 * </ul>
 *
 * <p>&#42; Some kind of privileged access that users can request. &#42; A set of users called
 * _requesters_ who can request this access. &#42; A maximum duration for which the access can be
 * requested. &#42; An optional approval workflow which must be satisfied before access is granted.
 *
 * <ul>
 *   <li>A collection of `Grant` resources. A grant is a request by a requester to get the
 *       privileged access specified in an entitlement for some duration.
 * </ul>
 *
 * <p>After the approval workflow as specified in the entitlement is satisfied, the specified access
 * is given to the requester. The access is automatically taken back after the requested duration is
 * over.
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
 * try (PrivilegedAccessManagerClient privilegedAccessManagerClient =
 *     PrivilegedAccessManagerClient.create()) {
 *   CheckOnboardingStatusRequest request =
 *       CheckOnboardingStatusRequest.newBuilder()
 *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
 *           .build();
 *   CheckOnboardingStatusResponse response =
 *       privilegedAccessManagerClient.checkOnboardingStatus(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the PrivilegedAccessManagerClient object to clean up
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
 *      <td><p> CheckOnboardingStatus</td>
 *      <td><p> CheckOnboardingStatus reports the onboarding status for a project/folder/organization. Any findings reported by this API need to be fixed before PAM can be used on the resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> checkOnboardingStatus(CheckOnboardingStatusRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> checkOnboardingStatusCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListEntitlements</td>
 *      <td><p> Lists entitlements in a given project/folder/organization and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listEntitlements(ListEntitlementsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listEntitlements(FolderLocationName parent)
 *           <li><p> listEntitlements(LocationName parent)
 *           <li><p> listEntitlements(OrganizationLocationName parent)
 *           <li><p> listEntitlements(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listEntitlementsPagedCallable()
 *           <li><p> listEntitlementsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SearchEntitlements</td>
 *      <td><p> `SearchEntitlements` returns entitlements on which the caller has the specified access.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> searchEntitlements(SearchEntitlementsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> searchEntitlementsPagedCallable()
 *           <li><p> searchEntitlementsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetEntitlement</td>
 *      <td><p> Gets details of a single entitlement.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getEntitlement(GetEntitlementRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getEntitlement(EntitlementName name)
 *           <li><p> getEntitlement(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getEntitlementCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateEntitlement</td>
 *      <td><p> Creates a new entitlement in a given project/folder/organization and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createEntitlementAsync(CreateEntitlementRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createEntitlementAsync(FolderLocationName parent, Entitlement entitlement, String entitlementId)
 *           <li><p> createEntitlementAsync(LocationName parent, Entitlement entitlement, String entitlementId)
 *           <li><p> createEntitlementAsync(OrganizationLocationName parent, Entitlement entitlement, String entitlementId)
 *           <li><p> createEntitlementAsync(String parent, Entitlement entitlement, String entitlementId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createEntitlementOperationCallable()
 *           <li><p> createEntitlementCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteEntitlement</td>
 *      <td><p> Deletes a single entitlement. This method can only be called when there are no in-progress (ACTIVE/ACTIVATING/REVOKING) grants under the entitlement.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteEntitlementAsync(DeleteEntitlementRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteEntitlementAsync(EntitlementName name)
 *           <li><p> deleteEntitlementAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteEntitlementOperationCallable()
 *           <li><p> deleteEntitlementCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateEntitlement</td>
 *      <td><p> Updates the entitlement specified in the request. Updated fields in the entitlement need to be specified in an update mask. The changes made to an entitlement are applicable only on future grants of the entitlement. However, if new approvers are added or existing approvers are removed from the approval workflow, the changes are effective on existing grants.
 * <p>  The following fields are not supported for updates:
 * <p>   &#42; All immutable fields  &#42; Entitlement name  &#42; Resource name  &#42; Resource type  &#42; Adding an approval workflow in an entitlement which previously had no    approval workflow.  &#42; Deleting the approval workflow from an entitlement.  &#42; Adding or deleting a step in the approval workflow (only one step is    supported)
 * <p>  Note that updates are allowed on the list of approvers in an approval workflow step.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateEntitlementAsync(UpdateEntitlementRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateEntitlementAsync(Entitlement entitlement, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateEntitlementOperationCallable()
 *           <li><p> updateEntitlementCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListGrants</td>
 *      <td><p> Lists grants for a given entitlement.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listGrants(ListGrantsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listGrants(EntitlementName parent)
 *           <li><p> listGrants(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listGrantsPagedCallable()
 *           <li><p> listGrantsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SearchGrants</td>
 *      <td><p> `SearchGrants` returns grants that are related to the calling user in the specified way.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> searchGrants(SearchGrantsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> searchGrantsPagedCallable()
 *           <li><p> searchGrantsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetGrant</td>
 *      <td><p> Get details of a single grant.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getGrant(GetGrantRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getGrant(GrantName name)
 *           <li><p> getGrant(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getGrantCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateGrant</td>
 *      <td><p> Creates a new grant in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createGrant(CreateGrantRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createGrant(EntitlementName parent, Grant grant)
 *           <li><p> createGrant(String parent, Grant grant)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createGrantCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ApproveGrant</td>
 *      <td><p> `ApproveGrant` is used to approve a grant. This method can only be called on a grant when it's in the `APPROVAL_AWAITED` state. This operation can't be undone.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> approveGrant(ApproveGrantRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> approveGrantCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DenyGrant</td>
 *      <td><p> `DenyGrant` is used to deny a grant. This method can only be called on a grant when it's in the `APPROVAL_AWAITED` state. This operation can't be undone.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> denyGrant(DenyGrantRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> denyGrantCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RevokeGrant</td>
 *      <td><p> `RevokeGrant` is used to immediately revoke access for a grant. This method can be called when the grant is in a non-terminal state.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> revokeGrantAsync(RevokeGrantRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> revokeGrantOperationCallable()
 *           <li><p> revokeGrantCallable()
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
 *  </table>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of
 * PrivilegedAccessManagerSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * PrivilegedAccessManagerSettings privilegedAccessManagerSettings =
 *     PrivilegedAccessManagerSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * PrivilegedAccessManagerClient privilegedAccessManagerClient =
 *     PrivilegedAccessManagerClient.create(privilegedAccessManagerSettings);
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
 * PrivilegedAccessManagerSettings privilegedAccessManagerSettings =
 *     PrivilegedAccessManagerSettings.newBuilder().setEndpoint(myEndpoint).build();
 * PrivilegedAccessManagerClient privilegedAccessManagerClient =
 *     PrivilegedAccessManagerClient.create(privilegedAccessManagerSettings);
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
 * PrivilegedAccessManagerSettings privilegedAccessManagerSettings =
 *     PrivilegedAccessManagerSettings.newHttpJsonBuilder().build();
 * PrivilegedAccessManagerClient privilegedAccessManagerClient =
 *     PrivilegedAccessManagerClient.create(privilegedAccessManagerSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class PrivilegedAccessManagerClient implements BackgroundResource {
  private final PrivilegedAccessManagerSettings settings;
  private final PrivilegedAccessManagerStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of PrivilegedAccessManagerClient with default settings. */
  public static final PrivilegedAccessManagerClient create() throws IOException {
    return create(PrivilegedAccessManagerSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of PrivilegedAccessManagerClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final PrivilegedAccessManagerClient create(PrivilegedAccessManagerSettings settings)
      throws IOException {
    return new PrivilegedAccessManagerClient(settings);
  }

  /**
   * Constructs an instance of PrivilegedAccessManagerClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(PrivilegedAccessManagerSettings).
   */
  public static final PrivilegedAccessManagerClient create(PrivilegedAccessManagerStub stub) {
    return new PrivilegedAccessManagerClient(stub);
  }

  /**
   * Constructs an instance of PrivilegedAccessManagerClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected PrivilegedAccessManagerClient(PrivilegedAccessManagerSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((PrivilegedAccessManagerStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected PrivilegedAccessManagerClient(PrivilegedAccessManagerStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final PrivilegedAccessManagerSettings getSettings() {
    return settings;
  }

  public PrivilegedAccessManagerStub getStub() {
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
   * CheckOnboardingStatus reports the onboarding status for a project/folder/organization. Any
   * findings reported by this API need to be fixed before PAM can be used on the resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivilegedAccessManagerClient privilegedAccessManagerClient =
   *     PrivilegedAccessManagerClient.create()) {
   *   CheckOnboardingStatusRequest request =
   *       CheckOnboardingStatusRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   CheckOnboardingStatusResponse response =
   *       privilegedAccessManagerClient.checkOnboardingStatus(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CheckOnboardingStatusResponse checkOnboardingStatus(
      CheckOnboardingStatusRequest request) {
    return checkOnboardingStatusCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * CheckOnboardingStatus reports the onboarding status for a project/folder/organization. Any
   * findings reported by this API need to be fixed before PAM can be used on the resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivilegedAccessManagerClient privilegedAccessManagerClient =
   *     PrivilegedAccessManagerClient.create()) {
   *   CheckOnboardingStatusRequest request =
   *       CheckOnboardingStatusRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   ApiFuture<CheckOnboardingStatusResponse> future =
   *       privilegedAccessManagerClient.checkOnboardingStatusCallable().futureCall(request);
   *   // Do something.
   *   CheckOnboardingStatusResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CheckOnboardingStatusRequest, CheckOnboardingStatusResponse>
      checkOnboardingStatusCallable() {
    return stub.checkOnboardingStatusCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists entitlements in a given project/folder/organization and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivilegedAccessManagerClient privilegedAccessManagerClient =
   *     PrivilegedAccessManagerClient.create()) {
   *   FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");
   *   for (Entitlement element :
   *       privilegedAccessManagerClient.listEntitlements(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent which owns the entitlement resources.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEntitlementsPagedResponse listEntitlements(FolderLocationName parent) {
    ListEntitlementsRequest request =
        ListEntitlementsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listEntitlements(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists entitlements in a given project/folder/organization and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivilegedAccessManagerClient privilegedAccessManagerClient =
   *     PrivilegedAccessManagerClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Entitlement element :
   *       privilegedAccessManagerClient.listEntitlements(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent which owns the entitlement resources.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEntitlementsPagedResponse listEntitlements(LocationName parent) {
    ListEntitlementsRequest request =
        ListEntitlementsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listEntitlements(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists entitlements in a given project/folder/organization and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivilegedAccessManagerClient privilegedAccessManagerClient =
   *     PrivilegedAccessManagerClient.create()) {
   *   OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
   *   for (Entitlement element :
   *       privilegedAccessManagerClient.listEntitlements(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent which owns the entitlement resources.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEntitlementsPagedResponse listEntitlements(OrganizationLocationName parent) {
    ListEntitlementsRequest request =
        ListEntitlementsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listEntitlements(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists entitlements in a given project/folder/organization and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivilegedAccessManagerClient privilegedAccessManagerClient =
   *     PrivilegedAccessManagerClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Entitlement element :
   *       privilegedAccessManagerClient.listEntitlements(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent which owns the entitlement resources.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEntitlementsPagedResponse listEntitlements(String parent) {
    ListEntitlementsRequest request =
        ListEntitlementsRequest.newBuilder().setParent(parent).build();
    return listEntitlements(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists entitlements in a given project/folder/organization and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivilegedAccessManagerClient privilegedAccessManagerClient =
   *     PrivilegedAccessManagerClient.create()) {
   *   ListEntitlementsRequest request =
   *       ListEntitlementsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Entitlement element :
   *       privilegedAccessManagerClient.listEntitlements(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEntitlementsPagedResponse listEntitlements(ListEntitlementsRequest request) {
    return listEntitlementsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists entitlements in a given project/folder/organization and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivilegedAccessManagerClient privilegedAccessManagerClient =
   *     PrivilegedAccessManagerClient.create()) {
   *   ListEntitlementsRequest request =
   *       ListEntitlementsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Entitlement> future =
   *       privilegedAccessManagerClient.listEntitlementsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Entitlement element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListEntitlementsRequest, ListEntitlementsPagedResponse>
      listEntitlementsPagedCallable() {
    return stub.listEntitlementsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists entitlements in a given project/folder/organization and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivilegedAccessManagerClient privilegedAccessManagerClient =
   *     PrivilegedAccessManagerClient.create()) {
   *   ListEntitlementsRequest request =
   *       ListEntitlementsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListEntitlementsResponse response =
   *         privilegedAccessManagerClient.listEntitlementsCallable().call(request);
   *     for (Entitlement element : response.getEntitlementsList()) {
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
  public final UnaryCallable<ListEntitlementsRequest, ListEntitlementsResponse>
      listEntitlementsCallable() {
    return stub.listEntitlementsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * `SearchEntitlements` returns entitlements on which the caller has the specified access.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivilegedAccessManagerClient privilegedAccessManagerClient =
   *     PrivilegedAccessManagerClient.create()) {
   *   SearchEntitlementsRequest request =
   *       SearchEntitlementsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Entitlement element :
   *       privilegedAccessManagerClient.searchEntitlements(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchEntitlementsPagedResponse searchEntitlements(
      SearchEntitlementsRequest request) {
    return searchEntitlementsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * `SearchEntitlements` returns entitlements on which the caller has the specified access.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivilegedAccessManagerClient privilegedAccessManagerClient =
   *     PrivilegedAccessManagerClient.create()) {
   *   SearchEntitlementsRequest request =
   *       SearchEntitlementsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Entitlement> future =
   *       privilegedAccessManagerClient.searchEntitlementsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Entitlement element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<SearchEntitlementsRequest, SearchEntitlementsPagedResponse>
      searchEntitlementsPagedCallable() {
    return stub.searchEntitlementsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * `SearchEntitlements` returns entitlements on which the caller has the specified access.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivilegedAccessManagerClient privilegedAccessManagerClient =
   *     PrivilegedAccessManagerClient.create()) {
   *   SearchEntitlementsRequest request =
   *       SearchEntitlementsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     SearchEntitlementsResponse response =
   *         privilegedAccessManagerClient.searchEntitlementsCallable().call(request);
   *     for (Entitlement element : response.getEntitlementsList()) {
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
  public final UnaryCallable<SearchEntitlementsRequest, SearchEntitlementsResponse>
      searchEntitlementsCallable() {
    return stub.searchEntitlementsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single entitlement.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivilegedAccessManagerClient privilegedAccessManagerClient =
   *     PrivilegedAccessManagerClient.create()) {
   *   EntitlementName name =
   *       EntitlementName.ofProjectLocationEntitlementName(
   *           "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]");
   *   Entitlement response = privilegedAccessManagerClient.getEntitlement(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Entitlement getEntitlement(EntitlementName name) {
    GetEntitlementRequest request =
        GetEntitlementRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getEntitlement(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single entitlement.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivilegedAccessManagerClient privilegedAccessManagerClient =
   *     PrivilegedAccessManagerClient.create()) {
   *   String name =
   *       EntitlementName.ofProjectLocationEntitlementName(
   *               "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]")
   *           .toString();
   *   Entitlement response = privilegedAccessManagerClient.getEntitlement(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Entitlement getEntitlement(String name) {
    GetEntitlementRequest request = GetEntitlementRequest.newBuilder().setName(name).build();
    return getEntitlement(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single entitlement.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivilegedAccessManagerClient privilegedAccessManagerClient =
   *     PrivilegedAccessManagerClient.create()) {
   *   GetEntitlementRequest request =
   *       GetEntitlementRequest.newBuilder()
   *           .setName(
   *               EntitlementName.ofProjectLocationEntitlementName(
   *                       "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]")
   *                   .toString())
   *           .build();
   *   Entitlement response = privilegedAccessManagerClient.getEntitlement(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Entitlement getEntitlement(GetEntitlementRequest request) {
    return getEntitlementCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single entitlement.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivilegedAccessManagerClient privilegedAccessManagerClient =
   *     PrivilegedAccessManagerClient.create()) {
   *   GetEntitlementRequest request =
   *       GetEntitlementRequest.newBuilder()
   *           .setName(
   *               EntitlementName.ofProjectLocationEntitlementName(
   *                       "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Entitlement> future =
   *       privilegedAccessManagerClient.getEntitlementCallable().futureCall(request);
   *   // Do something.
   *   Entitlement response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetEntitlementRequest, Entitlement> getEntitlementCallable() {
    return stub.getEntitlementCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new entitlement in a given project/folder/organization and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivilegedAccessManagerClient privilegedAccessManagerClient =
   *     PrivilegedAccessManagerClient.create()) {
   *   FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");
   *   Entitlement entitlement = Entitlement.newBuilder().build();
   *   String entitlementId = "entitlementId-1302274264";
   *   Entitlement response =
   *       privilegedAccessManagerClient
   *           .createEntitlementAsync(parent, entitlement, entitlementId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. Name of the parent resource for the entitlement. Possible formats:
   *     <ul>
   *       <li>`organizations/{organization-number}/locations/{region}`
   *       <li>`folders/{folder-number}/locations/{region}`
   *       <li>`projects/{project-id|project-number}/locations/{region}`
   *     </ul>
   *
   * @param entitlement Required. The resource being created
   * @param entitlementId Required. The ID to use for this entitlement. This becomes the last part
   *     of the resource name.
   *     <p>This value should be 4-63 characters in length, and valid characters are "[a-z]",
   *     "[0-9]", and "-". The first character should be from [a-z].
   *     <p>This value should be unique among all other entitlements under the specified `parent`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Entitlement, OperationMetadata> createEntitlementAsync(
      FolderLocationName parent, Entitlement entitlement, String entitlementId) {
    CreateEntitlementRequest request =
        CreateEntitlementRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setEntitlement(entitlement)
            .setEntitlementId(entitlementId)
            .build();
    return createEntitlementAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new entitlement in a given project/folder/organization and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivilegedAccessManagerClient privilegedAccessManagerClient =
   *     PrivilegedAccessManagerClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Entitlement entitlement = Entitlement.newBuilder().build();
   *   String entitlementId = "entitlementId-1302274264";
   *   Entitlement response =
   *       privilegedAccessManagerClient
   *           .createEntitlementAsync(parent, entitlement, entitlementId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. Name of the parent resource for the entitlement. Possible formats:
   *     <ul>
   *       <li>`organizations/{organization-number}/locations/{region}`
   *       <li>`folders/{folder-number}/locations/{region}`
   *       <li>`projects/{project-id|project-number}/locations/{region}`
   *     </ul>
   *
   * @param entitlement Required. The resource being created
   * @param entitlementId Required. The ID to use for this entitlement. This becomes the last part
   *     of the resource name.
   *     <p>This value should be 4-63 characters in length, and valid characters are "[a-z]",
   *     "[0-9]", and "-". The first character should be from [a-z].
   *     <p>This value should be unique among all other entitlements under the specified `parent`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Entitlement, OperationMetadata> createEntitlementAsync(
      LocationName parent, Entitlement entitlement, String entitlementId) {
    CreateEntitlementRequest request =
        CreateEntitlementRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setEntitlement(entitlement)
            .setEntitlementId(entitlementId)
            .build();
    return createEntitlementAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new entitlement in a given project/folder/organization and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivilegedAccessManagerClient privilegedAccessManagerClient =
   *     PrivilegedAccessManagerClient.create()) {
   *   OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
   *   Entitlement entitlement = Entitlement.newBuilder().build();
   *   String entitlementId = "entitlementId-1302274264";
   *   Entitlement response =
   *       privilegedAccessManagerClient
   *           .createEntitlementAsync(parent, entitlement, entitlementId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. Name of the parent resource for the entitlement. Possible formats:
   *     <ul>
   *       <li>`organizations/{organization-number}/locations/{region}`
   *       <li>`folders/{folder-number}/locations/{region}`
   *       <li>`projects/{project-id|project-number}/locations/{region}`
   *     </ul>
   *
   * @param entitlement Required. The resource being created
   * @param entitlementId Required. The ID to use for this entitlement. This becomes the last part
   *     of the resource name.
   *     <p>This value should be 4-63 characters in length, and valid characters are "[a-z]",
   *     "[0-9]", and "-". The first character should be from [a-z].
   *     <p>This value should be unique among all other entitlements under the specified `parent`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Entitlement, OperationMetadata> createEntitlementAsync(
      OrganizationLocationName parent, Entitlement entitlement, String entitlementId) {
    CreateEntitlementRequest request =
        CreateEntitlementRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setEntitlement(entitlement)
            .setEntitlementId(entitlementId)
            .build();
    return createEntitlementAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new entitlement in a given project/folder/organization and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivilegedAccessManagerClient privilegedAccessManagerClient =
   *     PrivilegedAccessManagerClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Entitlement entitlement = Entitlement.newBuilder().build();
   *   String entitlementId = "entitlementId-1302274264";
   *   Entitlement response =
   *       privilegedAccessManagerClient
   *           .createEntitlementAsync(parent, entitlement, entitlementId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. Name of the parent resource for the entitlement. Possible formats:
   *     <ul>
   *       <li>`organizations/{organization-number}/locations/{region}`
   *       <li>`folders/{folder-number}/locations/{region}`
   *       <li>`projects/{project-id|project-number}/locations/{region}`
   *     </ul>
   *
   * @param entitlement Required. The resource being created
   * @param entitlementId Required. The ID to use for this entitlement. This becomes the last part
   *     of the resource name.
   *     <p>This value should be 4-63 characters in length, and valid characters are "[a-z]",
   *     "[0-9]", and "-". The first character should be from [a-z].
   *     <p>This value should be unique among all other entitlements under the specified `parent`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Entitlement, OperationMetadata> createEntitlementAsync(
      String parent, Entitlement entitlement, String entitlementId) {
    CreateEntitlementRequest request =
        CreateEntitlementRequest.newBuilder()
            .setParent(parent)
            .setEntitlement(entitlement)
            .setEntitlementId(entitlementId)
            .build();
    return createEntitlementAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new entitlement in a given project/folder/organization and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivilegedAccessManagerClient privilegedAccessManagerClient =
   *     PrivilegedAccessManagerClient.create()) {
   *   CreateEntitlementRequest request =
   *       CreateEntitlementRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setEntitlementId("entitlementId-1302274264")
   *           .setEntitlement(Entitlement.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Entitlement response = privilegedAccessManagerClient.createEntitlementAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Entitlement, OperationMetadata> createEntitlementAsync(
      CreateEntitlementRequest request) {
    return createEntitlementOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new entitlement in a given project/folder/organization and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivilegedAccessManagerClient privilegedAccessManagerClient =
   *     PrivilegedAccessManagerClient.create()) {
   *   CreateEntitlementRequest request =
   *       CreateEntitlementRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setEntitlementId("entitlementId-1302274264")
   *           .setEntitlement(Entitlement.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Entitlement, OperationMetadata> future =
   *       privilegedAccessManagerClient.createEntitlementOperationCallable().futureCall(request);
   *   // Do something.
   *   Entitlement response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateEntitlementRequest, Entitlement, OperationMetadata>
      createEntitlementOperationCallable() {
    return stub.createEntitlementOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new entitlement in a given project/folder/organization and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivilegedAccessManagerClient privilegedAccessManagerClient =
   *     PrivilegedAccessManagerClient.create()) {
   *   CreateEntitlementRequest request =
   *       CreateEntitlementRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setEntitlementId("entitlementId-1302274264")
   *           .setEntitlement(Entitlement.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       privilegedAccessManagerClient.createEntitlementCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateEntitlementRequest, Operation> createEntitlementCallable() {
    return stub.createEntitlementCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single entitlement. This method can only be called when there are no in-progress
   * (ACTIVE/ACTIVATING/REVOKING) grants under the entitlement.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivilegedAccessManagerClient privilegedAccessManagerClient =
   *     PrivilegedAccessManagerClient.create()) {
   *   EntitlementName name =
   *       EntitlementName.ofProjectLocationEntitlementName(
   *           "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]");
   *   Entitlement response = privilegedAccessManagerClient.deleteEntitlementAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Entitlement, OperationMetadata> deleteEntitlementAsync(
      EntitlementName name) {
    DeleteEntitlementRequest request =
        DeleteEntitlementRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteEntitlementAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single entitlement. This method can only be called when there are no in-progress
   * (ACTIVE/ACTIVATING/REVOKING) grants under the entitlement.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivilegedAccessManagerClient privilegedAccessManagerClient =
   *     PrivilegedAccessManagerClient.create()) {
   *   String name =
   *       EntitlementName.ofProjectLocationEntitlementName(
   *               "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]")
   *           .toString();
   *   Entitlement response = privilegedAccessManagerClient.deleteEntitlementAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Entitlement, OperationMetadata> deleteEntitlementAsync(String name) {
    DeleteEntitlementRequest request = DeleteEntitlementRequest.newBuilder().setName(name).build();
    return deleteEntitlementAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single entitlement. This method can only be called when there are no in-progress
   * (ACTIVE/ACTIVATING/REVOKING) grants under the entitlement.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivilegedAccessManagerClient privilegedAccessManagerClient =
   *     PrivilegedAccessManagerClient.create()) {
   *   DeleteEntitlementRequest request =
   *       DeleteEntitlementRequest.newBuilder()
   *           .setName(
   *               EntitlementName.ofProjectLocationEntitlementName(
   *                       "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .build();
   *   Entitlement response = privilegedAccessManagerClient.deleteEntitlementAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Entitlement, OperationMetadata> deleteEntitlementAsync(
      DeleteEntitlementRequest request) {
    return deleteEntitlementOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single entitlement. This method can only be called when there are no in-progress
   * (ACTIVE/ACTIVATING/REVOKING) grants under the entitlement.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivilegedAccessManagerClient privilegedAccessManagerClient =
   *     PrivilegedAccessManagerClient.create()) {
   *   DeleteEntitlementRequest request =
   *       DeleteEntitlementRequest.newBuilder()
   *           .setName(
   *               EntitlementName.ofProjectLocationEntitlementName(
   *                       "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .build();
   *   OperationFuture<Entitlement, OperationMetadata> future =
   *       privilegedAccessManagerClient.deleteEntitlementOperationCallable().futureCall(request);
   *   // Do something.
   *   Entitlement response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteEntitlementRequest, Entitlement, OperationMetadata>
      deleteEntitlementOperationCallable() {
    return stub.deleteEntitlementOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single entitlement. This method can only be called when there are no in-progress
   * (ACTIVE/ACTIVATING/REVOKING) grants under the entitlement.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivilegedAccessManagerClient privilegedAccessManagerClient =
   *     PrivilegedAccessManagerClient.create()) {
   *   DeleteEntitlementRequest request =
   *       DeleteEntitlementRequest.newBuilder()
   *           .setName(
   *               EntitlementName.ofProjectLocationEntitlementName(
   *                       "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       privilegedAccessManagerClient.deleteEntitlementCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteEntitlementRequest, Operation> deleteEntitlementCallable() {
    return stub.deleteEntitlementCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the entitlement specified in the request. Updated fields in the entitlement need to be
   * specified in an update mask. The changes made to an entitlement are applicable only on future
   * grants of the entitlement. However, if new approvers are added or existing approvers are
   * removed from the approval workflow, the changes are effective on existing grants.
   *
   * <p>The following fields are not supported for updates:
   *
   * <p>&#42; All immutable fields &#42; Entitlement name &#42; Resource name &#42; Resource type
   * &#42; Adding an approval workflow in an entitlement which previously had no approval workflow.
   * &#42; Deleting the approval workflow from an entitlement. &#42; Adding or deleting a step in
   * the approval workflow (only one step is supported)
   *
   * <p>Note that updates are allowed on the list of approvers in an approval workflow step.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivilegedAccessManagerClient privilegedAccessManagerClient =
   *     PrivilegedAccessManagerClient.create()) {
   *   Entitlement entitlement = Entitlement.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Entitlement response =
   *       privilegedAccessManagerClient.updateEntitlementAsync(entitlement, updateMask).get();
   * }
   * }</pre>
   *
   * @param entitlement Required. The entitlement resource that is updated.
   * @param updateMask Required. The list of fields to update. A field is overwritten if, and only
   *     if, it is in the mask. Any immutable fields set in the mask are ignored by the server.
   *     Repeated fields and map fields are only allowed in the last position of a `paths` string
   *     and overwrite the existing values. Hence an update to a repeated field or a map should
   *     contain the entire list of values. The fields specified in the update_mask are relative to
   *     the resource and not to the request. (e.g. `MaxRequestDuration`; &#42;not&#42;
   *     `entitlement.MaxRequestDuration`) A value of '&#42;' for this field refers to full
   *     replacement of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Entitlement, OperationMetadata> updateEntitlementAsync(
      Entitlement entitlement, FieldMask updateMask) {
    UpdateEntitlementRequest request =
        UpdateEntitlementRequest.newBuilder()
            .setEntitlement(entitlement)
            .setUpdateMask(updateMask)
            .build();
    return updateEntitlementAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the entitlement specified in the request. Updated fields in the entitlement need to be
   * specified in an update mask. The changes made to an entitlement are applicable only on future
   * grants of the entitlement. However, if new approvers are added or existing approvers are
   * removed from the approval workflow, the changes are effective on existing grants.
   *
   * <p>The following fields are not supported for updates:
   *
   * <p>&#42; All immutable fields &#42; Entitlement name &#42; Resource name &#42; Resource type
   * &#42; Adding an approval workflow in an entitlement which previously had no approval workflow.
   * &#42; Deleting the approval workflow from an entitlement. &#42; Adding or deleting a step in
   * the approval workflow (only one step is supported)
   *
   * <p>Note that updates are allowed on the list of approvers in an approval workflow step.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivilegedAccessManagerClient privilegedAccessManagerClient =
   *     PrivilegedAccessManagerClient.create()) {
   *   UpdateEntitlementRequest request =
   *       UpdateEntitlementRequest.newBuilder()
   *           .setEntitlement(Entitlement.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Entitlement response = privilegedAccessManagerClient.updateEntitlementAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Entitlement, OperationMetadata> updateEntitlementAsync(
      UpdateEntitlementRequest request) {
    return updateEntitlementOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the entitlement specified in the request. Updated fields in the entitlement need to be
   * specified in an update mask. The changes made to an entitlement are applicable only on future
   * grants of the entitlement. However, if new approvers are added or existing approvers are
   * removed from the approval workflow, the changes are effective on existing grants.
   *
   * <p>The following fields are not supported for updates:
   *
   * <p>&#42; All immutable fields &#42; Entitlement name &#42; Resource name &#42; Resource type
   * &#42; Adding an approval workflow in an entitlement which previously had no approval workflow.
   * &#42; Deleting the approval workflow from an entitlement. &#42; Adding or deleting a step in
   * the approval workflow (only one step is supported)
   *
   * <p>Note that updates are allowed on the list of approvers in an approval workflow step.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivilegedAccessManagerClient privilegedAccessManagerClient =
   *     PrivilegedAccessManagerClient.create()) {
   *   UpdateEntitlementRequest request =
   *       UpdateEntitlementRequest.newBuilder()
   *           .setEntitlement(Entitlement.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<Entitlement, OperationMetadata> future =
   *       privilegedAccessManagerClient.updateEntitlementOperationCallable().futureCall(request);
   *   // Do something.
   *   Entitlement response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateEntitlementRequest, Entitlement, OperationMetadata>
      updateEntitlementOperationCallable() {
    return stub.updateEntitlementOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the entitlement specified in the request. Updated fields in the entitlement need to be
   * specified in an update mask. The changes made to an entitlement are applicable only on future
   * grants of the entitlement. However, if new approvers are added or existing approvers are
   * removed from the approval workflow, the changes are effective on existing grants.
   *
   * <p>The following fields are not supported for updates:
   *
   * <p>&#42; All immutable fields &#42; Entitlement name &#42; Resource name &#42; Resource type
   * &#42; Adding an approval workflow in an entitlement which previously had no approval workflow.
   * &#42; Deleting the approval workflow from an entitlement. &#42; Adding or deleting a step in
   * the approval workflow (only one step is supported)
   *
   * <p>Note that updates are allowed on the list of approvers in an approval workflow step.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivilegedAccessManagerClient privilegedAccessManagerClient =
   *     PrivilegedAccessManagerClient.create()) {
   *   UpdateEntitlementRequest request =
   *       UpdateEntitlementRequest.newBuilder()
   *           .setEntitlement(Entitlement.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       privilegedAccessManagerClient.updateEntitlementCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateEntitlementRequest, Operation> updateEntitlementCallable() {
    return stub.updateEntitlementCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists grants for a given entitlement.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivilegedAccessManagerClient privilegedAccessManagerClient =
   *     PrivilegedAccessManagerClient.create()) {
   *   EntitlementName parent =
   *       EntitlementName.ofProjectLocationEntitlementName(
   *           "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]");
   *   for (Grant element : privilegedAccessManagerClient.listGrants(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource which owns the grants.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGrantsPagedResponse listGrants(EntitlementName parent) {
    ListGrantsRequest request =
        ListGrantsRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listGrants(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists grants for a given entitlement.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivilegedAccessManagerClient privilegedAccessManagerClient =
   *     PrivilegedAccessManagerClient.create()) {
   *   String parent =
   *       EntitlementName.ofProjectLocationEntitlementName(
   *               "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]")
   *           .toString();
   *   for (Grant element : privilegedAccessManagerClient.listGrants(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource which owns the grants.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGrantsPagedResponse listGrants(String parent) {
    ListGrantsRequest request = ListGrantsRequest.newBuilder().setParent(parent).build();
    return listGrants(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists grants for a given entitlement.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivilegedAccessManagerClient privilegedAccessManagerClient =
   *     PrivilegedAccessManagerClient.create()) {
   *   ListGrantsRequest request =
   *       ListGrantsRequest.newBuilder()
   *           .setParent(
   *               EntitlementName.ofProjectLocationEntitlementName(
   *                       "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Grant element : privilegedAccessManagerClient.listGrants(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGrantsPagedResponse listGrants(ListGrantsRequest request) {
    return listGrantsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists grants for a given entitlement.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivilegedAccessManagerClient privilegedAccessManagerClient =
   *     PrivilegedAccessManagerClient.create()) {
   *   ListGrantsRequest request =
   *       ListGrantsRequest.newBuilder()
   *           .setParent(
   *               EntitlementName.ofProjectLocationEntitlementName(
   *                       "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Grant> future =
   *       privilegedAccessManagerClient.listGrantsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Grant element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListGrantsRequest, ListGrantsPagedResponse> listGrantsPagedCallable() {
    return stub.listGrantsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists grants for a given entitlement.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivilegedAccessManagerClient privilegedAccessManagerClient =
   *     PrivilegedAccessManagerClient.create()) {
   *   ListGrantsRequest request =
   *       ListGrantsRequest.newBuilder()
   *           .setParent(
   *               EntitlementName.ofProjectLocationEntitlementName(
   *                       "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListGrantsResponse response =
   *         privilegedAccessManagerClient.listGrantsCallable().call(request);
   *     for (Grant element : response.getGrantsList()) {
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
  public final UnaryCallable<ListGrantsRequest, ListGrantsResponse> listGrantsCallable() {
    return stub.listGrantsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * `SearchGrants` returns grants that are related to the calling user in the specified way.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivilegedAccessManagerClient privilegedAccessManagerClient =
   *     PrivilegedAccessManagerClient.create()) {
   *   SearchGrantsRequest request =
   *       SearchGrantsRequest.newBuilder()
   *           .setParent(
   *               EntitlementName.ofProjectLocationEntitlementName(
   *                       "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]")
   *                   .toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Grant element : privilegedAccessManagerClient.searchGrants(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchGrantsPagedResponse searchGrants(SearchGrantsRequest request) {
    return searchGrantsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * `SearchGrants` returns grants that are related to the calling user in the specified way.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivilegedAccessManagerClient privilegedAccessManagerClient =
   *     PrivilegedAccessManagerClient.create()) {
   *   SearchGrantsRequest request =
   *       SearchGrantsRequest.newBuilder()
   *           .setParent(
   *               EntitlementName.ofProjectLocationEntitlementName(
   *                       "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]")
   *                   .toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Grant> future =
   *       privilegedAccessManagerClient.searchGrantsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Grant element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<SearchGrantsRequest, SearchGrantsPagedResponse>
      searchGrantsPagedCallable() {
    return stub.searchGrantsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * `SearchGrants` returns grants that are related to the calling user in the specified way.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivilegedAccessManagerClient privilegedAccessManagerClient =
   *     PrivilegedAccessManagerClient.create()) {
   *   SearchGrantsRequest request =
   *       SearchGrantsRequest.newBuilder()
   *           .setParent(
   *               EntitlementName.ofProjectLocationEntitlementName(
   *                       "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]")
   *                   .toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     SearchGrantsResponse response =
   *         privilegedAccessManagerClient.searchGrantsCallable().call(request);
   *     for (Grant element : response.getGrantsList()) {
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
  public final UnaryCallable<SearchGrantsRequest, SearchGrantsResponse> searchGrantsCallable() {
    return stub.searchGrantsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details of a single grant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivilegedAccessManagerClient privilegedAccessManagerClient =
   *     PrivilegedAccessManagerClient.create()) {
   *   GrantName name =
   *       GrantName.ofProjectLocationEntitlementGrantName(
   *           "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]", "[GRANT]");
   *   Grant response = privilegedAccessManagerClient.getGrant(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Grant getGrant(GrantName name) {
    GetGrantRequest request =
        GetGrantRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getGrant(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details of a single grant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivilegedAccessManagerClient privilegedAccessManagerClient =
   *     PrivilegedAccessManagerClient.create()) {
   *   String name =
   *       GrantName.ofProjectLocationEntitlementGrantName(
   *               "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]", "[GRANT]")
   *           .toString();
   *   Grant response = privilegedAccessManagerClient.getGrant(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Grant getGrant(String name) {
    GetGrantRequest request = GetGrantRequest.newBuilder().setName(name).build();
    return getGrant(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details of a single grant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivilegedAccessManagerClient privilegedAccessManagerClient =
   *     PrivilegedAccessManagerClient.create()) {
   *   GetGrantRequest request =
   *       GetGrantRequest.newBuilder()
   *           .setName(
   *               GrantName.ofProjectLocationEntitlementGrantName(
   *                       "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]", "[GRANT]")
   *                   .toString())
   *           .build();
   *   Grant response = privilegedAccessManagerClient.getGrant(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Grant getGrant(GetGrantRequest request) {
    return getGrantCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details of a single grant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivilegedAccessManagerClient privilegedAccessManagerClient =
   *     PrivilegedAccessManagerClient.create()) {
   *   GetGrantRequest request =
   *       GetGrantRequest.newBuilder()
   *           .setName(
   *               GrantName.ofProjectLocationEntitlementGrantName(
   *                       "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]", "[GRANT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Grant> future =
   *       privilegedAccessManagerClient.getGrantCallable().futureCall(request);
   *   // Do something.
   *   Grant response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetGrantRequest, Grant> getGrantCallable() {
    return stub.getGrantCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new grant in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivilegedAccessManagerClient privilegedAccessManagerClient =
   *     PrivilegedAccessManagerClient.create()) {
   *   EntitlementName parent =
   *       EntitlementName.ofProjectLocationEntitlementName(
   *           "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]");
   *   Grant grant = Grant.newBuilder().build();
   *   Grant response = privilegedAccessManagerClient.createGrant(parent, grant);
   * }
   * }</pre>
   *
   * @param parent Required. Name of the parent entitlement for which this grant is being requested.
   * @param grant Required. The resource being created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Grant createGrant(EntitlementName parent, Grant grant) {
    CreateGrantRequest request =
        CreateGrantRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setGrant(grant)
            .build();
    return createGrant(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new grant in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivilegedAccessManagerClient privilegedAccessManagerClient =
   *     PrivilegedAccessManagerClient.create()) {
   *   String parent =
   *       EntitlementName.ofProjectLocationEntitlementName(
   *               "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]")
   *           .toString();
   *   Grant grant = Grant.newBuilder().build();
   *   Grant response = privilegedAccessManagerClient.createGrant(parent, grant);
   * }
   * }</pre>
   *
   * @param parent Required. Name of the parent entitlement for which this grant is being requested.
   * @param grant Required. The resource being created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Grant createGrant(String parent, Grant grant) {
    CreateGrantRequest request =
        CreateGrantRequest.newBuilder().setParent(parent).setGrant(grant).build();
    return createGrant(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new grant in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivilegedAccessManagerClient privilegedAccessManagerClient =
   *     PrivilegedAccessManagerClient.create()) {
   *   CreateGrantRequest request =
   *       CreateGrantRequest.newBuilder()
   *           .setParent(
   *               EntitlementName.ofProjectLocationEntitlementName(
   *                       "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]")
   *                   .toString())
   *           .setGrant(Grant.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Grant response = privilegedAccessManagerClient.createGrant(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Grant createGrant(CreateGrantRequest request) {
    return createGrantCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new grant in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivilegedAccessManagerClient privilegedAccessManagerClient =
   *     PrivilegedAccessManagerClient.create()) {
   *   CreateGrantRequest request =
   *       CreateGrantRequest.newBuilder()
   *           .setParent(
   *               EntitlementName.ofProjectLocationEntitlementName(
   *                       "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]")
   *                   .toString())
   *           .setGrant(Grant.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Grant> future =
   *       privilegedAccessManagerClient.createGrantCallable().futureCall(request);
   *   // Do something.
   *   Grant response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateGrantRequest, Grant> createGrantCallable() {
    return stub.createGrantCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * `ApproveGrant` is used to approve a grant. This method can only be called on a grant when it's
   * in the `APPROVAL_AWAITED` state. This operation can't be undone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivilegedAccessManagerClient privilegedAccessManagerClient =
   *     PrivilegedAccessManagerClient.create()) {
   *   ApproveGrantRequest request =
   *       ApproveGrantRequest.newBuilder()
   *           .setName(
   *               GrantName.ofProjectLocationEntitlementGrantName(
   *                       "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]", "[GRANT]")
   *                   .toString())
   *           .setReason("reason-934964668")
   *           .build();
   *   Grant response = privilegedAccessManagerClient.approveGrant(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Grant approveGrant(ApproveGrantRequest request) {
    return approveGrantCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * `ApproveGrant` is used to approve a grant. This method can only be called on a grant when it's
   * in the `APPROVAL_AWAITED` state. This operation can't be undone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivilegedAccessManagerClient privilegedAccessManagerClient =
   *     PrivilegedAccessManagerClient.create()) {
   *   ApproveGrantRequest request =
   *       ApproveGrantRequest.newBuilder()
   *           .setName(
   *               GrantName.ofProjectLocationEntitlementGrantName(
   *                       "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]", "[GRANT]")
   *                   .toString())
   *           .setReason("reason-934964668")
   *           .build();
   *   ApiFuture<Grant> future =
   *       privilegedAccessManagerClient.approveGrantCallable().futureCall(request);
   *   // Do something.
   *   Grant response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ApproveGrantRequest, Grant> approveGrantCallable() {
    return stub.approveGrantCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * `DenyGrant` is used to deny a grant. This method can only be called on a grant when it's in the
   * `APPROVAL_AWAITED` state. This operation can't be undone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivilegedAccessManagerClient privilegedAccessManagerClient =
   *     PrivilegedAccessManagerClient.create()) {
   *   DenyGrantRequest request =
   *       DenyGrantRequest.newBuilder()
   *           .setName(
   *               GrantName.ofProjectLocationEntitlementGrantName(
   *                       "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]", "[GRANT]")
   *                   .toString())
   *           .setReason("reason-934964668")
   *           .build();
   *   Grant response = privilegedAccessManagerClient.denyGrant(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Grant denyGrant(DenyGrantRequest request) {
    return denyGrantCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * `DenyGrant` is used to deny a grant. This method can only be called on a grant when it's in the
   * `APPROVAL_AWAITED` state. This operation can't be undone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivilegedAccessManagerClient privilegedAccessManagerClient =
   *     PrivilegedAccessManagerClient.create()) {
   *   DenyGrantRequest request =
   *       DenyGrantRequest.newBuilder()
   *           .setName(
   *               GrantName.ofProjectLocationEntitlementGrantName(
   *                       "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]", "[GRANT]")
   *                   .toString())
   *           .setReason("reason-934964668")
   *           .build();
   *   ApiFuture<Grant> future =
   *       privilegedAccessManagerClient.denyGrantCallable().futureCall(request);
   *   // Do something.
   *   Grant response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DenyGrantRequest, Grant> denyGrantCallable() {
    return stub.denyGrantCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * `RevokeGrant` is used to immediately revoke access for a grant. This method can be called when
   * the grant is in a non-terminal state.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivilegedAccessManagerClient privilegedAccessManagerClient =
   *     PrivilegedAccessManagerClient.create()) {
   *   RevokeGrantRequest request =
   *       RevokeGrantRequest.newBuilder()
   *           .setName(
   *               GrantName.ofProjectLocationEntitlementGrantName(
   *                       "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]", "[GRANT]")
   *                   .toString())
   *           .setReason("reason-934964668")
   *           .build();
   *   Grant response = privilegedAccessManagerClient.revokeGrantAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Grant, OperationMetadata> revokeGrantAsync(
      RevokeGrantRequest request) {
    return revokeGrantOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * `RevokeGrant` is used to immediately revoke access for a grant. This method can be called when
   * the grant is in a non-terminal state.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivilegedAccessManagerClient privilegedAccessManagerClient =
   *     PrivilegedAccessManagerClient.create()) {
   *   RevokeGrantRequest request =
   *       RevokeGrantRequest.newBuilder()
   *           .setName(
   *               GrantName.ofProjectLocationEntitlementGrantName(
   *                       "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]", "[GRANT]")
   *                   .toString())
   *           .setReason("reason-934964668")
   *           .build();
   *   OperationFuture<Grant, OperationMetadata> future =
   *       privilegedAccessManagerClient.revokeGrantOperationCallable().futureCall(request);
   *   // Do something.
   *   Grant response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<RevokeGrantRequest, Grant, OperationMetadata>
      revokeGrantOperationCallable() {
    return stub.revokeGrantOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * `RevokeGrant` is used to immediately revoke access for a grant. This method can be called when
   * the grant is in a non-terminal state.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivilegedAccessManagerClient privilegedAccessManagerClient =
   *     PrivilegedAccessManagerClient.create()) {
   *   RevokeGrantRequest request =
   *       RevokeGrantRequest.newBuilder()
   *           .setName(
   *               GrantName.ofProjectLocationEntitlementGrantName(
   *                       "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]", "[GRANT]")
   *                   .toString())
   *           .setReason("reason-934964668")
   *           .build();
   *   ApiFuture<Operation> future =
   *       privilegedAccessManagerClient.revokeGrantCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RevokeGrantRequest, Operation> revokeGrantCallable() {
    return stub.revokeGrantCallable();
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
   * try (PrivilegedAccessManagerClient privilegedAccessManagerClient =
   *     PrivilegedAccessManagerClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : privilegedAccessManagerClient.listLocations(request).iterateAll()) {
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
   * try (PrivilegedAccessManagerClient privilegedAccessManagerClient =
   *     PrivilegedAccessManagerClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       privilegedAccessManagerClient.listLocationsPagedCallable().futureCall(request);
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
   * try (PrivilegedAccessManagerClient privilegedAccessManagerClient =
   *     PrivilegedAccessManagerClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         privilegedAccessManagerClient.listLocationsCallable().call(request);
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
   * try (PrivilegedAccessManagerClient privilegedAccessManagerClient =
   *     PrivilegedAccessManagerClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = privilegedAccessManagerClient.getLocation(request);
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
   * try (PrivilegedAccessManagerClient privilegedAccessManagerClient =
   *     PrivilegedAccessManagerClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future =
   *       privilegedAccessManagerClient.getLocationCallable().futureCall(request);
   *   // Do something.
   *   Location response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return stub.getLocationCallable();
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

  public static class ListEntitlementsPagedResponse
      extends AbstractPagedListResponse<
          ListEntitlementsRequest,
          ListEntitlementsResponse,
          Entitlement,
          ListEntitlementsPage,
          ListEntitlementsFixedSizeCollection> {

    public static ApiFuture<ListEntitlementsPagedResponse> createAsync(
        PageContext<ListEntitlementsRequest, ListEntitlementsResponse, Entitlement> context,
        ApiFuture<ListEntitlementsResponse> futureResponse) {
      ApiFuture<ListEntitlementsPage> futurePage =
          ListEntitlementsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListEntitlementsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListEntitlementsPagedResponse(ListEntitlementsPage page) {
      super(page, ListEntitlementsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListEntitlementsPage
      extends AbstractPage<
          ListEntitlementsRequest, ListEntitlementsResponse, Entitlement, ListEntitlementsPage> {

    private ListEntitlementsPage(
        PageContext<ListEntitlementsRequest, ListEntitlementsResponse, Entitlement> context,
        ListEntitlementsResponse response) {
      super(context, response);
    }

    private static ListEntitlementsPage createEmptyPage() {
      return new ListEntitlementsPage(null, null);
    }

    @Override
    protected ListEntitlementsPage createPage(
        PageContext<ListEntitlementsRequest, ListEntitlementsResponse, Entitlement> context,
        ListEntitlementsResponse response) {
      return new ListEntitlementsPage(context, response);
    }

    @Override
    public ApiFuture<ListEntitlementsPage> createPageAsync(
        PageContext<ListEntitlementsRequest, ListEntitlementsResponse, Entitlement> context,
        ApiFuture<ListEntitlementsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListEntitlementsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListEntitlementsRequest,
          ListEntitlementsResponse,
          Entitlement,
          ListEntitlementsPage,
          ListEntitlementsFixedSizeCollection> {

    private ListEntitlementsFixedSizeCollection(
        List<ListEntitlementsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListEntitlementsFixedSizeCollection createEmptyCollection() {
      return new ListEntitlementsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListEntitlementsFixedSizeCollection createCollection(
        List<ListEntitlementsPage> pages, int collectionSize) {
      return new ListEntitlementsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class SearchEntitlementsPagedResponse
      extends AbstractPagedListResponse<
          SearchEntitlementsRequest,
          SearchEntitlementsResponse,
          Entitlement,
          SearchEntitlementsPage,
          SearchEntitlementsFixedSizeCollection> {

    public static ApiFuture<SearchEntitlementsPagedResponse> createAsync(
        PageContext<SearchEntitlementsRequest, SearchEntitlementsResponse, Entitlement> context,
        ApiFuture<SearchEntitlementsResponse> futureResponse) {
      ApiFuture<SearchEntitlementsPage> futurePage =
          SearchEntitlementsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new SearchEntitlementsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private SearchEntitlementsPagedResponse(SearchEntitlementsPage page) {
      super(page, SearchEntitlementsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class SearchEntitlementsPage
      extends AbstractPage<
          SearchEntitlementsRequest,
          SearchEntitlementsResponse,
          Entitlement,
          SearchEntitlementsPage> {

    private SearchEntitlementsPage(
        PageContext<SearchEntitlementsRequest, SearchEntitlementsResponse, Entitlement> context,
        SearchEntitlementsResponse response) {
      super(context, response);
    }

    private static SearchEntitlementsPage createEmptyPage() {
      return new SearchEntitlementsPage(null, null);
    }

    @Override
    protected SearchEntitlementsPage createPage(
        PageContext<SearchEntitlementsRequest, SearchEntitlementsResponse, Entitlement> context,
        SearchEntitlementsResponse response) {
      return new SearchEntitlementsPage(context, response);
    }

    @Override
    public ApiFuture<SearchEntitlementsPage> createPageAsync(
        PageContext<SearchEntitlementsRequest, SearchEntitlementsResponse, Entitlement> context,
        ApiFuture<SearchEntitlementsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class SearchEntitlementsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          SearchEntitlementsRequest,
          SearchEntitlementsResponse,
          Entitlement,
          SearchEntitlementsPage,
          SearchEntitlementsFixedSizeCollection> {

    private SearchEntitlementsFixedSizeCollection(
        List<SearchEntitlementsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static SearchEntitlementsFixedSizeCollection createEmptyCollection() {
      return new SearchEntitlementsFixedSizeCollection(null, 0);
    }

    @Override
    protected SearchEntitlementsFixedSizeCollection createCollection(
        List<SearchEntitlementsPage> pages, int collectionSize) {
      return new SearchEntitlementsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListGrantsPagedResponse
      extends AbstractPagedListResponse<
          ListGrantsRequest,
          ListGrantsResponse,
          Grant,
          ListGrantsPage,
          ListGrantsFixedSizeCollection> {

    public static ApiFuture<ListGrantsPagedResponse> createAsync(
        PageContext<ListGrantsRequest, ListGrantsResponse, Grant> context,
        ApiFuture<ListGrantsResponse> futureResponse) {
      ApiFuture<ListGrantsPage> futurePage =
          ListGrantsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListGrantsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListGrantsPagedResponse(ListGrantsPage page) {
      super(page, ListGrantsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListGrantsPage
      extends AbstractPage<ListGrantsRequest, ListGrantsResponse, Grant, ListGrantsPage> {

    private ListGrantsPage(
        PageContext<ListGrantsRequest, ListGrantsResponse, Grant> context,
        ListGrantsResponse response) {
      super(context, response);
    }

    private static ListGrantsPage createEmptyPage() {
      return new ListGrantsPage(null, null);
    }

    @Override
    protected ListGrantsPage createPage(
        PageContext<ListGrantsRequest, ListGrantsResponse, Grant> context,
        ListGrantsResponse response) {
      return new ListGrantsPage(context, response);
    }

    @Override
    public ApiFuture<ListGrantsPage> createPageAsync(
        PageContext<ListGrantsRequest, ListGrantsResponse, Grant> context,
        ApiFuture<ListGrantsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListGrantsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListGrantsRequest,
          ListGrantsResponse,
          Grant,
          ListGrantsPage,
          ListGrantsFixedSizeCollection> {

    private ListGrantsFixedSizeCollection(List<ListGrantsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListGrantsFixedSizeCollection createEmptyCollection() {
      return new ListGrantsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListGrantsFixedSizeCollection createCollection(
        List<ListGrantsPage> pages, int collectionSize) {
      return new ListGrantsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class SearchGrantsPagedResponse
      extends AbstractPagedListResponse<
          SearchGrantsRequest,
          SearchGrantsResponse,
          Grant,
          SearchGrantsPage,
          SearchGrantsFixedSizeCollection> {

    public static ApiFuture<SearchGrantsPagedResponse> createAsync(
        PageContext<SearchGrantsRequest, SearchGrantsResponse, Grant> context,
        ApiFuture<SearchGrantsResponse> futureResponse) {
      ApiFuture<SearchGrantsPage> futurePage =
          SearchGrantsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new SearchGrantsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private SearchGrantsPagedResponse(SearchGrantsPage page) {
      super(page, SearchGrantsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class SearchGrantsPage
      extends AbstractPage<SearchGrantsRequest, SearchGrantsResponse, Grant, SearchGrantsPage> {

    private SearchGrantsPage(
        PageContext<SearchGrantsRequest, SearchGrantsResponse, Grant> context,
        SearchGrantsResponse response) {
      super(context, response);
    }

    private static SearchGrantsPage createEmptyPage() {
      return new SearchGrantsPage(null, null);
    }

    @Override
    protected SearchGrantsPage createPage(
        PageContext<SearchGrantsRequest, SearchGrantsResponse, Grant> context,
        SearchGrantsResponse response) {
      return new SearchGrantsPage(context, response);
    }

    @Override
    public ApiFuture<SearchGrantsPage> createPageAsync(
        PageContext<SearchGrantsRequest, SearchGrantsResponse, Grant> context,
        ApiFuture<SearchGrantsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class SearchGrantsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          SearchGrantsRequest,
          SearchGrantsResponse,
          Grant,
          SearchGrantsPage,
          SearchGrantsFixedSizeCollection> {

    private SearchGrantsFixedSizeCollection(List<SearchGrantsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static SearchGrantsFixedSizeCollection createEmptyCollection() {
      return new SearchGrantsFixedSizeCollection(null, 0);
    }

    @Override
    protected SearchGrantsFixedSizeCollection createCollection(
        List<SearchGrantsPage> pages, int collectionSize) {
      return new SearchGrantsFixedSizeCollection(pages, collectionSize);
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
