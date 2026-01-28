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

package com.google.cloud.kms.v1;

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
import com.google.cloud.kms.v1.stub.HsmManagementStub;
import com.google.cloud.kms.v1.stub.HsmManagementStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Google Cloud HSM Management Service
 *
 * <p>Provides interfaces for managing HSM instances.
 *
 * <p>Implements a REST model with the following objects:
 *
 * <ul>
 *   <li>[SingleTenantHsmInstance][google.cloud.kms.v1.SingleTenantHsmInstance]
 *   <li>[SingleTenantHsmInstanceProposal][google.cloud.kms.v1.SingleTenantHsmInstanceProposal]
 * </ul>
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
 * try (HsmManagementClient hsmManagementClient = HsmManagementClient.create()) {
 *   SingleTenantHsmInstanceName name =
 *       SingleTenantHsmInstanceName.of("[PROJECT]", "[LOCATION]", "[SINGLE_TENANT_HSM_INSTANCE]");
 *   SingleTenantHsmInstance response = hsmManagementClient.getSingleTenantHsmInstance(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the HsmManagementClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> ListSingleTenantHsmInstances</td>
 *      <td><p> Lists [SingleTenantHsmInstances][google.cloud.kms.v1.SingleTenantHsmInstance].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listSingleTenantHsmInstances(ListSingleTenantHsmInstancesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listSingleTenantHsmInstances(LocationName parent)
 *           <li><p> listSingleTenantHsmInstances(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listSingleTenantHsmInstancesPagedCallable()
 *           <li><p> listSingleTenantHsmInstancesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetSingleTenantHsmInstance</td>
 *      <td><p> Returns metadata for a given [SingleTenantHsmInstance][google.cloud.kms.v1.SingleTenantHsmInstance].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getSingleTenantHsmInstance(GetSingleTenantHsmInstanceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getSingleTenantHsmInstance(SingleTenantHsmInstanceName name)
 *           <li><p> getSingleTenantHsmInstance(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getSingleTenantHsmInstanceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateSingleTenantHsmInstance</td>
 *      <td><p> Creates a new [SingleTenantHsmInstance][google.cloud.kms.v1.SingleTenantHsmInstance] in a given Project and Location. User must create a RegisterTwoFactorAuthKeys proposal with this single-tenant HSM instance to finish setup of the instance.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createSingleTenantHsmInstanceAsync(CreateSingleTenantHsmInstanceRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createSingleTenantHsmInstanceAsync(LocationName parent, SingleTenantHsmInstance singleTenantHsmInstance, String singleTenantHsmInstanceId)
 *           <li><p> createSingleTenantHsmInstanceAsync(String parent, SingleTenantHsmInstance singleTenantHsmInstance, String singleTenantHsmInstanceId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createSingleTenantHsmInstanceOperationCallable()
 *           <li><p> createSingleTenantHsmInstanceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateSingleTenantHsmInstanceProposal</td>
 *      <td><p> Creates a new [SingleTenantHsmInstanceProposal][google.cloud.kms.v1.SingleTenantHsmInstanceProposal] for a given [SingleTenantHsmInstance][google.cloud.kms.v1.SingleTenantHsmInstance].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createSingleTenantHsmInstanceProposalAsync(CreateSingleTenantHsmInstanceProposalRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createSingleTenantHsmInstanceProposalAsync(SingleTenantHsmInstanceName parent, SingleTenantHsmInstanceProposal singleTenantHsmInstanceProposal, String singleTenantHsmInstanceProposalId)
 *           <li><p> createSingleTenantHsmInstanceProposalAsync(String parent, SingleTenantHsmInstanceProposal singleTenantHsmInstanceProposal, String singleTenantHsmInstanceProposalId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createSingleTenantHsmInstanceProposalOperationCallable()
 *           <li><p> createSingleTenantHsmInstanceProposalCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ApproveSingleTenantHsmInstanceProposal</td>
 *      <td><p> Approves a [SingleTenantHsmInstanceProposal][google.cloud.kms.v1.SingleTenantHsmInstanceProposal] for a given [SingleTenantHsmInstance][google.cloud.kms.v1.SingleTenantHsmInstance]. The proposal must be in the [PENDING][google.cloud.kms.v1.SingleTenantHsmInstanceProposal.State.PENDING] state.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> approveSingleTenantHsmInstanceProposal(ApproveSingleTenantHsmInstanceProposalRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> approveSingleTenantHsmInstanceProposal(SingleTenantHsmInstanceProposalName name, ApproveSingleTenantHsmInstanceProposalRequest.QuorumReply quorumReply)
 *           <li><p> approveSingleTenantHsmInstanceProposal(String name, ApproveSingleTenantHsmInstanceProposalRequest.QuorumReply quorumReply)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> approveSingleTenantHsmInstanceProposalCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ExecuteSingleTenantHsmInstanceProposal</td>
 *      <td><p> Executes a [SingleTenantHsmInstanceProposal][google.cloud.kms.v1.SingleTenantHsmInstanceProposal] for a given [SingleTenantHsmInstance][google.cloud.kms.v1.SingleTenantHsmInstance]. The proposal must be in the [APPROVED][google.cloud.kms.v1.SingleTenantHsmInstanceProposal.State.APPROVED] state.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> executeSingleTenantHsmInstanceProposalAsync(ExecuteSingleTenantHsmInstanceProposalRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> executeSingleTenantHsmInstanceProposalAsync(SingleTenantHsmInstanceProposalName name)
 *           <li><p> executeSingleTenantHsmInstanceProposalAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> executeSingleTenantHsmInstanceProposalOperationCallable()
 *           <li><p> executeSingleTenantHsmInstanceProposalCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetSingleTenantHsmInstanceProposal</td>
 *      <td><p> Returns metadata for a given [SingleTenantHsmInstanceProposal][google.cloud.kms.v1.SingleTenantHsmInstanceProposal].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getSingleTenantHsmInstanceProposal(GetSingleTenantHsmInstanceProposalRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getSingleTenantHsmInstanceProposal(SingleTenantHsmInstanceProposalName name)
 *           <li><p> getSingleTenantHsmInstanceProposal(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getSingleTenantHsmInstanceProposalCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListSingleTenantHsmInstanceProposals</td>
 *      <td><p> Lists [SingleTenantHsmInstanceProposals][google.cloud.kms.v1.SingleTenantHsmInstanceProposal].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listSingleTenantHsmInstanceProposals(ListSingleTenantHsmInstanceProposalsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listSingleTenantHsmInstanceProposals(SingleTenantHsmInstanceName parent)
 *           <li><p> listSingleTenantHsmInstanceProposals(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listSingleTenantHsmInstanceProposalsPagedCallable()
 *           <li><p> listSingleTenantHsmInstanceProposalsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteSingleTenantHsmInstanceProposal</td>
 *      <td><p> Deletes a [SingleTenantHsmInstanceProposal][google.cloud.kms.v1.SingleTenantHsmInstanceProposal].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteSingleTenantHsmInstanceProposal(DeleteSingleTenantHsmInstanceProposalRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteSingleTenantHsmInstanceProposal(SingleTenantHsmInstanceProposalName name)
 *           <li><p> deleteSingleTenantHsmInstanceProposal(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteSingleTenantHsmInstanceProposalCallable()
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
 * <p>This class can be customized by passing in a custom instance of HsmManagementSettings to
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
 * HsmManagementSettings hsmManagementSettings =
 *     HsmManagementSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * HsmManagementClient hsmManagementClient = HsmManagementClient.create(hsmManagementSettings);
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
 * HsmManagementSettings hsmManagementSettings =
 *     HsmManagementSettings.newBuilder().setEndpoint(myEndpoint).build();
 * HsmManagementClient hsmManagementClient = HsmManagementClient.create(hsmManagementSettings);
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
 * HsmManagementSettings hsmManagementSettings =
 *     HsmManagementSettings.newHttpJsonBuilder().build();
 * HsmManagementClient hsmManagementClient = HsmManagementClient.create(hsmManagementSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class HsmManagementClient implements BackgroundResource {
  private final HsmManagementSettings settings;
  private final HsmManagementStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of HsmManagementClient with default settings. */
  public static final HsmManagementClient create() throws IOException {
    return create(HsmManagementSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of HsmManagementClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final HsmManagementClient create(HsmManagementSettings settings)
      throws IOException {
    return new HsmManagementClient(settings);
  }

  /**
   * Constructs an instance of HsmManagementClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(HsmManagementSettings).
   */
  public static final HsmManagementClient create(HsmManagementStub stub) {
    return new HsmManagementClient(stub);
  }

  /**
   * Constructs an instance of HsmManagementClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HsmManagementClient(HsmManagementSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((HsmManagementStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected HsmManagementClient(HsmManagementStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final HsmManagementSettings getSettings() {
    return settings;
  }

  public HsmManagementStub getStub() {
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
   * Lists [SingleTenantHsmInstances][google.cloud.kms.v1.SingleTenantHsmInstance].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HsmManagementClient hsmManagementClient = HsmManagementClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (SingleTenantHsmInstance element :
   *       hsmManagementClient.listSingleTenantHsmInstances(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location associated with the
   *     [SingleTenantHsmInstances][google.cloud.kms.v1.SingleTenantHsmInstance] to list, in the
   *     format `projects/&#42;/locations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSingleTenantHsmInstancesPagedResponse listSingleTenantHsmInstances(
      LocationName parent) {
    ListSingleTenantHsmInstancesRequest request =
        ListSingleTenantHsmInstancesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listSingleTenantHsmInstances(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [SingleTenantHsmInstances][google.cloud.kms.v1.SingleTenantHsmInstance].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HsmManagementClient hsmManagementClient = HsmManagementClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (SingleTenantHsmInstance element :
   *       hsmManagementClient.listSingleTenantHsmInstances(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location associated with the
   *     [SingleTenantHsmInstances][google.cloud.kms.v1.SingleTenantHsmInstance] to list, in the
   *     format `projects/&#42;/locations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSingleTenantHsmInstancesPagedResponse listSingleTenantHsmInstances(
      String parent) {
    ListSingleTenantHsmInstancesRequest request =
        ListSingleTenantHsmInstancesRequest.newBuilder().setParent(parent).build();
    return listSingleTenantHsmInstances(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [SingleTenantHsmInstances][google.cloud.kms.v1.SingleTenantHsmInstance].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HsmManagementClient hsmManagementClient = HsmManagementClient.create()) {
   *   ListSingleTenantHsmInstancesRequest request =
   *       ListSingleTenantHsmInstancesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setShowDeleted(true)
   *           .build();
   *   for (SingleTenantHsmInstance element :
   *       hsmManagementClient.listSingleTenantHsmInstances(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSingleTenantHsmInstancesPagedResponse listSingleTenantHsmInstances(
      ListSingleTenantHsmInstancesRequest request) {
    return listSingleTenantHsmInstancesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [SingleTenantHsmInstances][google.cloud.kms.v1.SingleTenantHsmInstance].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HsmManagementClient hsmManagementClient = HsmManagementClient.create()) {
   *   ListSingleTenantHsmInstancesRequest request =
   *       ListSingleTenantHsmInstancesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setShowDeleted(true)
   *           .build();
   *   ApiFuture<SingleTenantHsmInstance> future =
   *       hsmManagementClient.listSingleTenantHsmInstancesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (SingleTenantHsmInstance element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListSingleTenantHsmInstancesRequest, ListSingleTenantHsmInstancesPagedResponse>
      listSingleTenantHsmInstancesPagedCallable() {
    return stub.listSingleTenantHsmInstancesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [SingleTenantHsmInstances][google.cloud.kms.v1.SingleTenantHsmInstance].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HsmManagementClient hsmManagementClient = HsmManagementClient.create()) {
   *   ListSingleTenantHsmInstancesRequest request =
   *       ListSingleTenantHsmInstancesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setShowDeleted(true)
   *           .build();
   *   while (true) {
   *     ListSingleTenantHsmInstancesResponse response =
   *         hsmManagementClient.listSingleTenantHsmInstancesCallable().call(request);
   *     for (SingleTenantHsmInstance element : response.getSingleTenantHsmInstancesList()) {
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
          ListSingleTenantHsmInstancesRequest, ListSingleTenantHsmInstancesResponse>
      listSingleTenantHsmInstancesCallable() {
    return stub.listSingleTenantHsmInstancesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns metadata for a given
   * [SingleTenantHsmInstance][google.cloud.kms.v1.SingleTenantHsmInstance].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HsmManagementClient hsmManagementClient = HsmManagementClient.create()) {
   *   SingleTenantHsmInstanceName name =
   *       SingleTenantHsmInstanceName.of("[PROJECT]", "[LOCATION]", "[SINGLE_TENANT_HSM_INSTANCE]");
   *   SingleTenantHsmInstance response = hsmManagementClient.getSingleTenantHsmInstance(name);
   * }
   * }</pre>
   *
   * @param name Required. The [name][google.cloud.kms.v1.SingleTenantHsmInstance.name] of the
   *     [SingleTenantHsmInstance][google.cloud.kms.v1.SingleTenantHsmInstance] to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SingleTenantHsmInstance getSingleTenantHsmInstance(
      SingleTenantHsmInstanceName name) {
    GetSingleTenantHsmInstanceRequest request =
        GetSingleTenantHsmInstanceRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getSingleTenantHsmInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns metadata for a given
   * [SingleTenantHsmInstance][google.cloud.kms.v1.SingleTenantHsmInstance].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HsmManagementClient hsmManagementClient = HsmManagementClient.create()) {
   *   String name =
   *       SingleTenantHsmInstanceName.of("[PROJECT]", "[LOCATION]", "[SINGLE_TENANT_HSM_INSTANCE]")
   *           .toString();
   *   SingleTenantHsmInstance response = hsmManagementClient.getSingleTenantHsmInstance(name);
   * }
   * }</pre>
   *
   * @param name Required. The [name][google.cloud.kms.v1.SingleTenantHsmInstance.name] of the
   *     [SingleTenantHsmInstance][google.cloud.kms.v1.SingleTenantHsmInstance] to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SingleTenantHsmInstance getSingleTenantHsmInstance(String name) {
    GetSingleTenantHsmInstanceRequest request =
        GetSingleTenantHsmInstanceRequest.newBuilder().setName(name).build();
    return getSingleTenantHsmInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns metadata for a given
   * [SingleTenantHsmInstance][google.cloud.kms.v1.SingleTenantHsmInstance].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HsmManagementClient hsmManagementClient = HsmManagementClient.create()) {
   *   GetSingleTenantHsmInstanceRequest request =
   *       GetSingleTenantHsmInstanceRequest.newBuilder()
   *           .setName(
   *               SingleTenantHsmInstanceName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SINGLE_TENANT_HSM_INSTANCE]")
   *                   .toString())
   *           .build();
   *   SingleTenantHsmInstance response = hsmManagementClient.getSingleTenantHsmInstance(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SingleTenantHsmInstance getSingleTenantHsmInstance(
      GetSingleTenantHsmInstanceRequest request) {
    return getSingleTenantHsmInstanceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns metadata for a given
   * [SingleTenantHsmInstance][google.cloud.kms.v1.SingleTenantHsmInstance].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HsmManagementClient hsmManagementClient = HsmManagementClient.create()) {
   *   GetSingleTenantHsmInstanceRequest request =
   *       GetSingleTenantHsmInstanceRequest.newBuilder()
   *           .setName(
   *               SingleTenantHsmInstanceName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SINGLE_TENANT_HSM_INSTANCE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<SingleTenantHsmInstance> future =
   *       hsmManagementClient.getSingleTenantHsmInstanceCallable().futureCall(request);
   *   // Do something.
   *   SingleTenantHsmInstance response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSingleTenantHsmInstanceRequest, SingleTenantHsmInstance>
      getSingleTenantHsmInstanceCallable() {
    return stub.getSingleTenantHsmInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new [SingleTenantHsmInstance][google.cloud.kms.v1.SingleTenantHsmInstance] in a given
   * Project and Location. User must create a RegisterTwoFactorAuthKeys proposal with this
   * single-tenant HSM instance to finish setup of the instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HsmManagementClient hsmManagementClient = HsmManagementClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   SingleTenantHsmInstance singleTenantHsmInstance =
   *       SingleTenantHsmInstance.newBuilder().build();
   *   String singleTenantHsmInstanceId = "singleTenantHsmInstanceId770829568";
   *   SingleTenantHsmInstance response =
   *       hsmManagementClient
   *           .createSingleTenantHsmInstanceAsync(
   *               parent, singleTenantHsmInstance, singleTenantHsmInstanceId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location associated with the
   *     [SingleTenantHsmInstance][google.cloud.kms.v1.SingleTenantHsmInstance], in the format
   *     `projects/&#42;/locations/&#42;`.
   * @param singleTenantHsmInstance Required. An
   *     [SingleTenantHsmInstance][google.cloud.kms.v1.SingleTenantHsmInstance] with initial field
   *     values.
   * @param singleTenantHsmInstanceId Optional. It must be unique within a location and match the
   *     regular expression `[a-zA-Z0-9_-]{1,63}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<SingleTenantHsmInstance, CreateSingleTenantHsmInstanceMetadata>
      createSingleTenantHsmInstanceAsync(
          LocationName parent,
          SingleTenantHsmInstance singleTenantHsmInstance,
          String singleTenantHsmInstanceId) {
    CreateSingleTenantHsmInstanceRequest request =
        CreateSingleTenantHsmInstanceRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSingleTenantHsmInstance(singleTenantHsmInstance)
            .setSingleTenantHsmInstanceId(singleTenantHsmInstanceId)
            .build();
    return createSingleTenantHsmInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new [SingleTenantHsmInstance][google.cloud.kms.v1.SingleTenantHsmInstance] in a given
   * Project and Location. User must create a RegisterTwoFactorAuthKeys proposal with this
   * single-tenant HSM instance to finish setup of the instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HsmManagementClient hsmManagementClient = HsmManagementClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   SingleTenantHsmInstance singleTenantHsmInstance =
   *       SingleTenantHsmInstance.newBuilder().build();
   *   String singleTenantHsmInstanceId = "singleTenantHsmInstanceId770829568";
   *   SingleTenantHsmInstance response =
   *       hsmManagementClient
   *           .createSingleTenantHsmInstanceAsync(
   *               parent, singleTenantHsmInstance, singleTenantHsmInstanceId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location associated with the
   *     [SingleTenantHsmInstance][google.cloud.kms.v1.SingleTenantHsmInstance], in the format
   *     `projects/&#42;/locations/&#42;`.
   * @param singleTenantHsmInstance Required. An
   *     [SingleTenantHsmInstance][google.cloud.kms.v1.SingleTenantHsmInstance] with initial field
   *     values.
   * @param singleTenantHsmInstanceId Optional. It must be unique within a location and match the
   *     regular expression `[a-zA-Z0-9_-]{1,63}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<SingleTenantHsmInstance, CreateSingleTenantHsmInstanceMetadata>
      createSingleTenantHsmInstanceAsync(
          String parent,
          SingleTenantHsmInstance singleTenantHsmInstance,
          String singleTenantHsmInstanceId) {
    CreateSingleTenantHsmInstanceRequest request =
        CreateSingleTenantHsmInstanceRequest.newBuilder()
            .setParent(parent)
            .setSingleTenantHsmInstance(singleTenantHsmInstance)
            .setSingleTenantHsmInstanceId(singleTenantHsmInstanceId)
            .build();
    return createSingleTenantHsmInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new [SingleTenantHsmInstance][google.cloud.kms.v1.SingleTenantHsmInstance] in a given
   * Project and Location. User must create a RegisterTwoFactorAuthKeys proposal with this
   * single-tenant HSM instance to finish setup of the instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HsmManagementClient hsmManagementClient = HsmManagementClient.create()) {
   *   CreateSingleTenantHsmInstanceRequest request =
   *       CreateSingleTenantHsmInstanceRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSingleTenantHsmInstanceId("singleTenantHsmInstanceId770829568")
   *           .setSingleTenantHsmInstance(SingleTenantHsmInstance.newBuilder().build())
   *           .build();
   *   SingleTenantHsmInstance response =
   *       hsmManagementClient.createSingleTenantHsmInstanceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<SingleTenantHsmInstance, CreateSingleTenantHsmInstanceMetadata>
      createSingleTenantHsmInstanceAsync(CreateSingleTenantHsmInstanceRequest request) {
    return createSingleTenantHsmInstanceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new [SingleTenantHsmInstance][google.cloud.kms.v1.SingleTenantHsmInstance] in a given
   * Project and Location. User must create a RegisterTwoFactorAuthKeys proposal with this
   * single-tenant HSM instance to finish setup of the instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HsmManagementClient hsmManagementClient = HsmManagementClient.create()) {
   *   CreateSingleTenantHsmInstanceRequest request =
   *       CreateSingleTenantHsmInstanceRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSingleTenantHsmInstanceId("singleTenantHsmInstanceId770829568")
   *           .setSingleTenantHsmInstance(SingleTenantHsmInstance.newBuilder().build())
   *           .build();
   *   OperationFuture<SingleTenantHsmInstance, CreateSingleTenantHsmInstanceMetadata> future =
   *       hsmManagementClient.createSingleTenantHsmInstanceOperationCallable().futureCall(request);
   *   // Do something.
   *   SingleTenantHsmInstance response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateSingleTenantHsmInstanceRequest,
          SingleTenantHsmInstance,
          CreateSingleTenantHsmInstanceMetadata>
      createSingleTenantHsmInstanceOperationCallable() {
    return stub.createSingleTenantHsmInstanceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new [SingleTenantHsmInstance][google.cloud.kms.v1.SingleTenantHsmInstance] in a given
   * Project and Location. User must create a RegisterTwoFactorAuthKeys proposal with this
   * single-tenant HSM instance to finish setup of the instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HsmManagementClient hsmManagementClient = HsmManagementClient.create()) {
   *   CreateSingleTenantHsmInstanceRequest request =
   *       CreateSingleTenantHsmInstanceRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSingleTenantHsmInstanceId("singleTenantHsmInstanceId770829568")
   *           .setSingleTenantHsmInstance(SingleTenantHsmInstance.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       hsmManagementClient.createSingleTenantHsmInstanceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateSingleTenantHsmInstanceRequest, Operation>
      createSingleTenantHsmInstanceCallable() {
    return stub.createSingleTenantHsmInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new
   * [SingleTenantHsmInstanceProposal][google.cloud.kms.v1.SingleTenantHsmInstanceProposal] for a
   * given [SingleTenantHsmInstance][google.cloud.kms.v1.SingleTenantHsmInstance].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HsmManagementClient hsmManagementClient = HsmManagementClient.create()) {
   *   SingleTenantHsmInstanceName parent =
   *       SingleTenantHsmInstanceName.of("[PROJECT]", "[LOCATION]", "[SINGLE_TENANT_HSM_INSTANCE]");
   *   SingleTenantHsmInstanceProposal singleTenantHsmInstanceProposal =
   *       SingleTenantHsmInstanceProposal.newBuilder().build();
   *   String singleTenantHsmInstanceProposalId = "singleTenantHsmInstanceProposalId-994202990";
   *   SingleTenantHsmInstanceProposal response =
   *       hsmManagementClient
   *           .createSingleTenantHsmInstanceProposalAsync(
   *               parent, singleTenantHsmInstanceProposal, singleTenantHsmInstanceProposalId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The [name][google.cloud.kms.v1.SingleTenantHsmInstance.name] of the
   *     [SingleTenantHsmInstance][google.cloud.kms.v1.SingleTenantHsmInstance] associated with the
   *     [SingleTenantHsmInstanceProposals][google.cloud.kms.v1.SingleTenantHsmInstanceProposal].
   * @param singleTenantHsmInstanceProposal Required. The
   *     [SingleTenantHsmInstanceProposal][google.cloud.kms.v1.SingleTenantHsmInstanceProposal] to
   *     create.
   * @param singleTenantHsmInstanceProposalId Optional. It must be unique within a location and
   *     match the regular expression `[a-zA-Z0-9_-]{1,63}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<
          SingleTenantHsmInstanceProposal, CreateSingleTenantHsmInstanceProposalMetadata>
      createSingleTenantHsmInstanceProposalAsync(
          SingleTenantHsmInstanceName parent,
          SingleTenantHsmInstanceProposal singleTenantHsmInstanceProposal,
          String singleTenantHsmInstanceProposalId) {
    CreateSingleTenantHsmInstanceProposalRequest request =
        CreateSingleTenantHsmInstanceProposalRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSingleTenantHsmInstanceProposal(singleTenantHsmInstanceProposal)
            .setSingleTenantHsmInstanceProposalId(singleTenantHsmInstanceProposalId)
            .build();
    return createSingleTenantHsmInstanceProposalAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new
   * [SingleTenantHsmInstanceProposal][google.cloud.kms.v1.SingleTenantHsmInstanceProposal] for a
   * given [SingleTenantHsmInstance][google.cloud.kms.v1.SingleTenantHsmInstance].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HsmManagementClient hsmManagementClient = HsmManagementClient.create()) {
   *   String parent =
   *       SingleTenantHsmInstanceName.of("[PROJECT]", "[LOCATION]", "[SINGLE_TENANT_HSM_INSTANCE]")
   *           .toString();
   *   SingleTenantHsmInstanceProposal singleTenantHsmInstanceProposal =
   *       SingleTenantHsmInstanceProposal.newBuilder().build();
   *   String singleTenantHsmInstanceProposalId = "singleTenantHsmInstanceProposalId-994202990";
   *   SingleTenantHsmInstanceProposal response =
   *       hsmManagementClient
   *           .createSingleTenantHsmInstanceProposalAsync(
   *               parent, singleTenantHsmInstanceProposal, singleTenantHsmInstanceProposalId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The [name][google.cloud.kms.v1.SingleTenantHsmInstance.name] of the
   *     [SingleTenantHsmInstance][google.cloud.kms.v1.SingleTenantHsmInstance] associated with the
   *     [SingleTenantHsmInstanceProposals][google.cloud.kms.v1.SingleTenantHsmInstanceProposal].
   * @param singleTenantHsmInstanceProposal Required. The
   *     [SingleTenantHsmInstanceProposal][google.cloud.kms.v1.SingleTenantHsmInstanceProposal] to
   *     create.
   * @param singleTenantHsmInstanceProposalId Optional. It must be unique within a location and
   *     match the regular expression `[a-zA-Z0-9_-]{1,63}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<
          SingleTenantHsmInstanceProposal, CreateSingleTenantHsmInstanceProposalMetadata>
      createSingleTenantHsmInstanceProposalAsync(
          String parent,
          SingleTenantHsmInstanceProposal singleTenantHsmInstanceProposal,
          String singleTenantHsmInstanceProposalId) {
    CreateSingleTenantHsmInstanceProposalRequest request =
        CreateSingleTenantHsmInstanceProposalRequest.newBuilder()
            .setParent(parent)
            .setSingleTenantHsmInstanceProposal(singleTenantHsmInstanceProposal)
            .setSingleTenantHsmInstanceProposalId(singleTenantHsmInstanceProposalId)
            .build();
    return createSingleTenantHsmInstanceProposalAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new
   * [SingleTenantHsmInstanceProposal][google.cloud.kms.v1.SingleTenantHsmInstanceProposal] for a
   * given [SingleTenantHsmInstance][google.cloud.kms.v1.SingleTenantHsmInstance].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HsmManagementClient hsmManagementClient = HsmManagementClient.create()) {
   *   CreateSingleTenantHsmInstanceProposalRequest request =
   *       CreateSingleTenantHsmInstanceProposalRequest.newBuilder()
   *           .setParent(
   *               SingleTenantHsmInstanceName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SINGLE_TENANT_HSM_INSTANCE]")
   *                   .toString())
   *           .setSingleTenantHsmInstanceProposalId("singleTenantHsmInstanceProposalId-994202990")
   *           .setSingleTenantHsmInstanceProposal(
   *               SingleTenantHsmInstanceProposal.newBuilder().build())
   *           .build();
   *   SingleTenantHsmInstanceProposal response =
   *       hsmManagementClient.createSingleTenantHsmInstanceProposalAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<
          SingleTenantHsmInstanceProposal, CreateSingleTenantHsmInstanceProposalMetadata>
      createSingleTenantHsmInstanceProposalAsync(
          CreateSingleTenantHsmInstanceProposalRequest request) {
    return createSingleTenantHsmInstanceProposalOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new
   * [SingleTenantHsmInstanceProposal][google.cloud.kms.v1.SingleTenantHsmInstanceProposal] for a
   * given [SingleTenantHsmInstance][google.cloud.kms.v1.SingleTenantHsmInstance].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HsmManagementClient hsmManagementClient = HsmManagementClient.create()) {
   *   CreateSingleTenantHsmInstanceProposalRequest request =
   *       CreateSingleTenantHsmInstanceProposalRequest.newBuilder()
   *           .setParent(
   *               SingleTenantHsmInstanceName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SINGLE_TENANT_HSM_INSTANCE]")
   *                   .toString())
   *           .setSingleTenantHsmInstanceProposalId("singleTenantHsmInstanceProposalId-994202990")
   *           .setSingleTenantHsmInstanceProposal(
   *               SingleTenantHsmInstanceProposal.newBuilder().build())
   *           .build();
   *   OperationFuture<
   *           SingleTenantHsmInstanceProposal, CreateSingleTenantHsmInstanceProposalMetadata>
   *       future =
   *           hsmManagementClient
   *               .createSingleTenantHsmInstanceProposalOperationCallable()
   *               .futureCall(request);
   *   // Do something.
   *   SingleTenantHsmInstanceProposal response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateSingleTenantHsmInstanceProposalRequest,
          SingleTenantHsmInstanceProposal,
          CreateSingleTenantHsmInstanceProposalMetadata>
      createSingleTenantHsmInstanceProposalOperationCallable() {
    return stub.createSingleTenantHsmInstanceProposalOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new
   * [SingleTenantHsmInstanceProposal][google.cloud.kms.v1.SingleTenantHsmInstanceProposal] for a
   * given [SingleTenantHsmInstance][google.cloud.kms.v1.SingleTenantHsmInstance].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HsmManagementClient hsmManagementClient = HsmManagementClient.create()) {
   *   CreateSingleTenantHsmInstanceProposalRequest request =
   *       CreateSingleTenantHsmInstanceProposalRequest.newBuilder()
   *           .setParent(
   *               SingleTenantHsmInstanceName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SINGLE_TENANT_HSM_INSTANCE]")
   *                   .toString())
   *           .setSingleTenantHsmInstanceProposalId("singleTenantHsmInstanceProposalId-994202990")
   *           .setSingleTenantHsmInstanceProposal(
   *               SingleTenantHsmInstanceProposal.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       hsmManagementClient.createSingleTenantHsmInstanceProposalCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateSingleTenantHsmInstanceProposalRequest, Operation>
      createSingleTenantHsmInstanceProposalCallable() {
    return stub.createSingleTenantHsmInstanceProposalCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Approves a
   * [SingleTenantHsmInstanceProposal][google.cloud.kms.v1.SingleTenantHsmInstanceProposal] for a
   * given [SingleTenantHsmInstance][google.cloud.kms.v1.SingleTenantHsmInstance]. The proposal must
   * be in the [PENDING][google.cloud.kms.v1.SingleTenantHsmInstanceProposal.State.PENDING] state.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HsmManagementClient hsmManagementClient = HsmManagementClient.create()) {
   *   SingleTenantHsmInstanceProposalName name =
   *       SingleTenantHsmInstanceProposalName.of(
   *           "[PROJECT]", "[LOCATION]", "[SINGLE_TENANT_HSM_INSTANCE]", "[PROPOSAL]");
   *   ApproveSingleTenantHsmInstanceProposalRequest.QuorumReply quorumReply =
   *       ApproveSingleTenantHsmInstanceProposalRequest.QuorumReply.newBuilder().build();
   *   ApproveSingleTenantHsmInstanceProposalResponse response =
   *       hsmManagementClient.approveSingleTenantHsmInstanceProposal(name, quorumReply);
   * }
   * }</pre>
   *
   * @param name Required. The [name][google.cloud.kms.v1.SingleTenantHsmInstanceProposal.name] of
   *     the [SingleTenantHsmInstanceProposal][google.cloud.kms.v1.SingleTenantHsmInstanceProposal]
   *     to approve.
   * @param quorumReply Required. The reply to
   *     [QuorumParameters][google.cloud.kms.v1.SingleTenantHsmInstanceProposal.QuorumParameters]
   *     for approving the proposal.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApproveSingleTenantHsmInstanceProposalResponse
      approveSingleTenantHsmInstanceProposal(
          SingleTenantHsmInstanceProposalName name,
          ApproveSingleTenantHsmInstanceProposalRequest.QuorumReply quorumReply) {
    ApproveSingleTenantHsmInstanceProposalRequest request =
        ApproveSingleTenantHsmInstanceProposalRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setQuorumReply(quorumReply)
            .build();
    return approveSingleTenantHsmInstanceProposal(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Approves a
   * [SingleTenantHsmInstanceProposal][google.cloud.kms.v1.SingleTenantHsmInstanceProposal] for a
   * given [SingleTenantHsmInstance][google.cloud.kms.v1.SingleTenantHsmInstance]. The proposal must
   * be in the [PENDING][google.cloud.kms.v1.SingleTenantHsmInstanceProposal.State.PENDING] state.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HsmManagementClient hsmManagementClient = HsmManagementClient.create()) {
   *   String name =
   *       SingleTenantHsmInstanceProposalName.of(
   *               "[PROJECT]", "[LOCATION]", "[SINGLE_TENANT_HSM_INSTANCE]", "[PROPOSAL]")
   *           .toString();
   *   ApproveSingleTenantHsmInstanceProposalRequest.QuorumReply quorumReply =
   *       ApproveSingleTenantHsmInstanceProposalRequest.QuorumReply.newBuilder().build();
   *   ApproveSingleTenantHsmInstanceProposalResponse response =
   *       hsmManagementClient.approveSingleTenantHsmInstanceProposal(name, quorumReply);
   * }
   * }</pre>
   *
   * @param name Required. The [name][google.cloud.kms.v1.SingleTenantHsmInstanceProposal.name] of
   *     the [SingleTenantHsmInstanceProposal][google.cloud.kms.v1.SingleTenantHsmInstanceProposal]
   *     to approve.
   * @param quorumReply Required. The reply to
   *     [QuorumParameters][google.cloud.kms.v1.SingleTenantHsmInstanceProposal.QuorumParameters]
   *     for approving the proposal.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApproveSingleTenantHsmInstanceProposalResponse
      approveSingleTenantHsmInstanceProposal(
          String name, ApproveSingleTenantHsmInstanceProposalRequest.QuorumReply quorumReply) {
    ApproveSingleTenantHsmInstanceProposalRequest request =
        ApproveSingleTenantHsmInstanceProposalRequest.newBuilder()
            .setName(name)
            .setQuorumReply(quorumReply)
            .build();
    return approveSingleTenantHsmInstanceProposal(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Approves a
   * [SingleTenantHsmInstanceProposal][google.cloud.kms.v1.SingleTenantHsmInstanceProposal] for a
   * given [SingleTenantHsmInstance][google.cloud.kms.v1.SingleTenantHsmInstance]. The proposal must
   * be in the [PENDING][google.cloud.kms.v1.SingleTenantHsmInstanceProposal.State.PENDING] state.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HsmManagementClient hsmManagementClient = HsmManagementClient.create()) {
   *   ApproveSingleTenantHsmInstanceProposalRequest request =
   *       ApproveSingleTenantHsmInstanceProposalRequest.newBuilder()
   *           .setName(
   *               SingleTenantHsmInstanceProposalName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SINGLE_TENANT_HSM_INSTANCE]", "[PROPOSAL]")
   *                   .toString())
   *           .build();
   *   ApproveSingleTenantHsmInstanceProposalResponse response =
   *       hsmManagementClient.approveSingleTenantHsmInstanceProposal(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApproveSingleTenantHsmInstanceProposalResponse
      approveSingleTenantHsmInstanceProposal(
          ApproveSingleTenantHsmInstanceProposalRequest request) {
    return approveSingleTenantHsmInstanceProposalCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Approves a
   * [SingleTenantHsmInstanceProposal][google.cloud.kms.v1.SingleTenantHsmInstanceProposal] for a
   * given [SingleTenantHsmInstance][google.cloud.kms.v1.SingleTenantHsmInstance]. The proposal must
   * be in the [PENDING][google.cloud.kms.v1.SingleTenantHsmInstanceProposal.State.PENDING] state.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HsmManagementClient hsmManagementClient = HsmManagementClient.create()) {
   *   ApproveSingleTenantHsmInstanceProposalRequest request =
   *       ApproveSingleTenantHsmInstanceProposalRequest.newBuilder()
   *           .setName(
   *               SingleTenantHsmInstanceProposalName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SINGLE_TENANT_HSM_INSTANCE]", "[PROPOSAL]")
   *                   .toString())
   *           .build();
   *   ApiFuture<ApproveSingleTenantHsmInstanceProposalResponse> future =
   *       hsmManagementClient.approveSingleTenantHsmInstanceProposalCallable().futureCall(request);
   *   // Do something.
   *   ApproveSingleTenantHsmInstanceProposalResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ApproveSingleTenantHsmInstanceProposalRequest,
          ApproveSingleTenantHsmInstanceProposalResponse>
      approveSingleTenantHsmInstanceProposalCallable() {
    return stub.approveSingleTenantHsmInstanceProposalCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Executes a
   * [SingleTenantHsmInstanceProposal][google.cloud.kms.v1.SingleTenantHsmInstanceProposal] for a
   * given [SingleTenantHsmInstance][google.cloud.kms.v1.SingleTenantHsmInstance]. The proposal must
   * be in the [APPROVED][google.cloud.kms.v1.SingleTenantHsmInstanceProposal.State.APPROVED] state.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HsmManagementClient hsmManagementClient = HsmManagementClient.create()) {
   *   SingleTenantHsmInstanceProposalName name =
   *       SingleTenantHsmInstanceProposalName.of(
   *           "[PROJECT]", "[LOCATION]", "[SINGLE_TENANT_HSM_INSTANCE]", "[PROPOSAL]");
   *   ExecuteSingleTenantHsmInstanceProposalResponse response =
   *       hsmManagementClient.executeSingleTenantHsmInstanceProposalAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The [name][google.cloud.kms.v1.SingleTenantHsmInstanceProposal.name] of
   *     the [SingleTenantHsmInstanceProposal][google.cloud.kms.v1.SingleTenantHsmInstanceProposal]
   *     to execute.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<
          ExecuteSingleTenantHsmInstanceProposalResponse,
          ExecuteSingleTenantHsmInstanceProposalMetadata>
      executeSingleTenantHsmInstanceProposalAsync(SingleTenantHsmInstanceProposalName name) {
    ExecuteSingleTenantHsmInstanceProposalRequest request =
        ExecuteSingleTenantHsmInstanceProposalRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return executeSingleTenantHsmInstanceProposalAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Executes a
   * [SingleTenantHsmInstanceProposal][google.cloud.kms.v1.SingleTenantHsmInstanceProposal] for a
   * given [SingleTenantHsmInstance][google.cloud.kms.v1.SingleTenantHsmInstance]. The proposal must
   * be in the [APPROVED][google.cloud.kms.v1.SingleTenantHsmInstanceProposal.State.APPROVED] state.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HsmManagementClient hsmManagementClient = HsmManagementClient.create()) {
   *   String name =
   *       SingleTenantHsmInstanceProposalName.of(
   *               "[PROJECT]", "[LOCATION]", "[SINGLE_TENANT_HSM_INSTANCE]", "[PROPOSAL]")
   *           .toString();
   *   ExecuteSingleTenantHsmInstanceProposalResponse response =
   *       hsmManagementClient.executeSingleTenantHsmInstanceProposalAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The [name][google.cloud.kms.v1.SingleTenantHsmInstanceProposal.name] of
   *     the [SingleTenantHsmInstanceProposal][google.cloud.kms.v1.SingleTenantHsmInstanceProposal]
   *     to execute.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<
          ExecuteSingleTenantHsmInstanceProposalResponse,
          ExecuteSingleTenantHsmInstanceProposalMetadata>
      executeSingleTenantHsmInstanceProposalAsync(String name) {
    ExecuteSingleTenantHsmInstanceProposalRequest request =
        ExecuteSingleTenantHsmInstanceProposalRequest.newBuilder().setName(name).build();
    return executeSingleTenantHsmInstanceProposalAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Executes a
   * [SingleTenantHsmInstanceProposal][google.cloud.kms.v1.SingleTenantHsmInstanceProposal] for a
   * given [SingleTenantHsmInstance][google.cloud.kms.v1.SingleTenantHsmInstance]. The proposal must
   * be in the [APPROVED][google.cloud.kms.v1.SingleTenantHsmInstanceProposal.State.APPROVED] state.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HsmManagementClient hsmManagementClient = HsmManagementClient.create()) {
   *   ExecuteSingleTenantHsmInstanceProposalRequest request =
   *       ExecuteSingleTenantHsmInstanceProposalRequest.newBuilder()
   *           .setName(
   *               SingleTenantHsmInstanceProposalName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SINGLE_TENANT_HSM_INSTANCE]", "[PROPOSAL]")
   *                   .toString())
   *           .build();
   *   ExecuteSingleTenantHsmInstanceProposalResponse response =
   *       hsmManagementClient.executeSingleTenantHsmInstanceProposalAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<
          ExecuteSingleTenantHsmInstanceProposalResponse,
          ExecuteSingleTenantHsmInstanceProposalMetadata>
      executeSingleTenantHsmInstanceProposalAsync(
          ExecuteSingleTenantHsmInstanceProposalRequest request) {
    return executeSingleTenantHsmInstanceProposalOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Executes a
   * [SingleTenantHsmInstanceProposal][google.cloud.kms.v1.SingleTenantHsmInstanceProposal] for a
   * given [SingleTenantHsmInstance][google.cloud.kms.v1.SingleTenantHsmInstance]. The proposal must
   * be in the [APPROVED][google.cloud.kms.v1.SingleTenantHsmInstanceProposal.State.APPROVED] state.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HsmManagementClient hsmManagementClient = HsmManagementClient.create()) {
   *   ExecuteSingleTenantHsmInstanceProposalRequest request =
   *       ExecuteSingleTenantHsmInstanceProposalRequest.newBuilder()
   *           .setName(
   *               SingleTenantHsmInstanceProposalName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SINGLE_TENANT_HSM_INSTANCE]", "[PROPOSAL]")
   *                   .toString())
   *           .build();
   *   OperationFuture<
   *           ExecuteSingleTenantHsmInstanceProposalResponse,
   *           ExecuteSingleTenantHsmInstanceProposalMetadata>
   *       future =
   *           hsmManagementClient
   *               .executeSingleTenantHsmInstanceProposalOperationCallable()
   *               .futureCall(request);
   *   // Do something.
   *   ExecuteSingleTenantHsmInstanceProposalResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          ExecuteSingleTenantHsmInstanceProposalRequest,
          ExecuteSingleTenantHsmInstanceProposalResponse,
          ExecuteSingleTenantHsmInstanceProposalMetadata>
      executeSingleTenantHsmInstanceProposalOperationCallable() {
    return stub.executeSingleTenantHsmInstanceProposalOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Executes a
   * [SingleTenantHsmInstanceProposal][google.cloud.kms.v1.SingleTenantHsmInstanceProposal] for a
   * given [SingleTenantHsmInstance][google.cloud.kms.v1.SingleTenantHsmInstance]. The proposal must
   * be in the [APPROVED][google.cloud.kms.v1.SingleTenantHsmInstanceProposal.State.APPROVED] state.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HsmManagementClient hsmManagementClient = HsmManagementClient.create()) {
   *   ExecuteSingleTenantHsmInstanceProposalRequest request =
   *       ExecuteSingleTenantHsmInstanceProposalRequest.newBuilder()
   *           .setName(
   *               SingleTenantHsmInstanceProposalName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SINGLE_TENANT_HSM_INSTANCE]", "[PROPOSAL]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       hsmManagementClient.executeSingleTenantHsmInstanceProposalCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ExecuteSingleTenantHsmInstanceProposalRequest, Operation>
      executeSingleTenantHsmInstanceProposalCallable() {
    return stub.executeSingleTenantHsmInstanceProposalCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns metadata for a given
   * [SingleTenantHsmInstanceProposal][google.cloud.kms.v1.SingleTenantHsmInstanceProposal].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HsmManagementClient hsmManagementClient = HsmManagementClient.create()) {
   *   SingleTenantHsmInstanceProposalName name =
   *       SingleTenantHsmInstanceProposalName.of(
   *           "[PROJECT]", "[LOCATION]", "[SINGLE_TENANT_HSM_INSTANCE]", "[PROPOSAL]");
   *   SingleTenantHsmInstanceProposal response =
   *       hsmManagementClient.getSingleTenantHsmInstanceProposal(name);
   * }
   * }</pre>
   *
   * @param name Required. The [name][google.cloud.kms.v1.SingleTenantHsmInstanceProposal.name] of
   *     the [SingleTenantHsmInstanceProposal][google.cloud.kms.v1.SingleTenantHsmInstanceProposal]
   *     to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SingleTenantHsmInstanceProposal getSingleTenantHsmInstanceProposal(
      SingleTenantHsmInstanceProposalName name) {
    GetSingleTenantHsmInstanceProposalRequest request =
        GetSingleTenantHsmInstanceProposalRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getSingleTenantHsmInstanceProposal(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns metadata for a given
   * [SingleTenantHsmInstanceProposal][google.cloud.kms.v1.SingleTenantHsmInstanceProposal].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HsmManagementClient hsmManagementClient = HsmManagementClient.create()) {
   *   String name =
   *       SingleTenantHsmInstanceProposalName.of(
   *               "[PROJECT]", "[LOCATION]", "[SINGLE_TENANT_HSM_INSTANCE]", "[PROPOSAL]")
   *           .toString();
   *   SingleTenantHsmInstanceProposal response =
   *       hsmManagementClient.getSingleTenantHsmInstanceProposal(name);
   * }
   * }</pre>
   *
   * @param name Required. The [name][google.cloud.kms.v1.SingleTenantHsmInstanceProposal.name] of
   *     the [SingleTenantHsmInstanceProposal][google.cloud.kms.v1.SingleTenantHsmInstanceProposal]
   *     to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SingleTenantHsmInstanceProposal getSingleTenantHsmInstanceProposal(String name) {
    GetSingleTenantHsmInstanceProposalRequest request =
        GetSingleTenantHsmInstanceProposalRequest.newBuilder().setName(name).build();
    return getSingleTenantHsmInstanceProposal(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns metadata for a given
   * [SingleTenantHsmInstanceProposal][google.cloud.kms.v1.SingleTenantHsmInstanceProposal].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HsmManagementClient hsmManagementClient = HsmManagementClient.create()) {
   *   GetSingleTenantHsmInstanceProposalRequest request =
   *       GetSingleTenantHsmInstanceProposalRequest.newBuilder()
   *           .setName(
   *               SingleTenantHsmInstanceProposalName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SINGLE_TENANT_HSM_INSTANCE]", "[PROPOSAL]")
   *                   .toString())
   *           .build();
   *   SingleTenantHsmInstanceProposal response =
   *       hsmManagementClient.getSingleTenantHsmInstanceProposal(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SingleTenantHsmInstanceProposal getSingleTenantHsmInstanceProposal(
      GetSingleTenantHsmInstanceProposalRequest request) {
    return getSingleTenantHsmInstanceProposalCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns metadata for a given
   * [SingleTenantHsmInstanceProposal][google.cloud.kms.v1.SingleTenantHsmInstanceProposal].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HsmManagementClient hsmManagementClient = HsmManagementClient.create()) {
   *   GetSingleTenantHsmInstanceProposalRequest request =
   *       GetSingleTenantHsmInstanceProposalRequest.newBuilder()
   *           .setName(
   *               SingleTenantHsmInstanceProposalName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SINGLE_TENANT_HSM_INSTANCE]", "[PROPOSAL]")
   *                   .toString())
   *           .build();
   *   ApiFuture<SingleTenantHsmInstanceProposal> future =
   *       hsmManagementClient.getSingleTenantHsmInstanceProposalCallable().futureCall(request);
   *   // Do something.
   *   SingleTenantHsmInstanceProposal response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          GetSingleTenantHsmInstanceProposalRequest, SingleTenantHsmInstanceProposal>
      getSingleTenantHsmInstanceProposalCallable() {
    return stub.getSingleTenantHsmInstanceProposalCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [SingleTenantHsmInstanceProposals][google.cloud.kms.v1.SingleTenantHsmInstanceProposal].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HsmManagementClient hsmManagementClient = HsmManagementClient.create()) {
   *   SingleTenantHsmInstanceName parent =
   *       SingleTenantHsmInstanceName.of("[PROJECT]", "[LOCATION]", "[SINGLE_TENANT_HSM_INSTANCE]");
   *   for (SingleTenantHsmInstanceProposal element :
   *       hsmManagementClient.listSingleTenantHsmInstanceProposals(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the single tenant HSM instance associated with the
   *     [SingleTenantHsmInstanceProposals][google.cloud.kms.v1.SingleTenantHsmInstanceProposal] to
   *     list, in the format `projects/&#42;/locations/&#42;/singleTenantHsmInstances/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSingleTenantHsmInstanceProposalsPagedResponse
      listSingleTenantHsmInstanceProposals(SingleTenantHsmInstanceName parent) {
    ListSingleTenantHsmInstanceProposalsRequest request =
        ListSingleTenantHsmInstanceProposalsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listSingleTenantHsmInstanceProposals(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [SingleTenantHsmInstanceProposals][google.cloud.kms.v1.SingleTenantHsmInstanceProposal].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HsmManagementClient hsmManagementClient = HsmManagementClient.create()) {
   *   String parent =
   *       SingleTenantHsmInstanceName.of("[PROJECT]", "[LOCATION]", "[SINGLE_TENANT_HSM_INSTANCE]")
   *           .toString();
   *   for (SingleTenantHsmInstanceProposal element :
   *       hsmManagementClient.listSingleTenantHsmInstanceProposals(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the single tenant HSM instance associated with the
   *     [SingleTenantHsmInstanceProposals][google.cloud.kms.v1.SingleTenantHsmInstanceProposal] to
   *     list, in the format `projects/&#42;/locations/&#42;/singleTenantHsmInstances/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSingleTenantHsmInstanceProposalsPagedResponse
      listSingleTenantHsmInstanceProposals(String parent) {
    ListSingleTenantHsmInstanceProposalsRequest request =
        ListSingleTenantHsmInstanceProposalsRequest.newBuilder().setParent(parent).build();
    return listSingleTenantHsmInstanceProposals(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [SingleTenantHsmInstanceProposals][google.cloud.kms.v1.SingleTenantHsmInstanceProposal].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HsmManagementClient hsmManagementClient = HsmManagementClient.create()) {
   *   ListSingleTenantHsmInstanceProposalsRequest request =
   *       ListSingleTenantHsmInstanceProposalsRequest.newBuilder()
   *           .setParent(
   *               SingleTenantHsmInstanceName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SINGLE_TENANT_HSM_INSTANCE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setShowDeleted(true)
   *           .build();
   *   for (SingleTenantHsmInstanceProposal element :
   *       hsmManagementClient.listSingleTenantHsmInstanceProposals(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSingleTenantHsmInstanceProposalsPagedResponse
      listSingleTenantHsmInstanceProposals(ListSingleTenantHsmInstanceProposalsRequest request) {
    return listSingleTenantHsmInstanceProposalsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [SingleTenantHsmInstanceProposals][google.cloud.kms.v1.SingleTenantHsmInstanceProposal].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HsmManagementClient hsmManagementClient = HsmManagementClient.create()) {
   *   ListSingleTenantHsmInstanceProposalsRequest request =
   *       ListSingleTenantHsmInstanceProposalsRequest.newBuilder()
   *           .setParent(
   *               SingleTenantHsmInstanceName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SINGLE_TENANT_HSM_INSTANCE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setShowDeleted(true)
   *           .build();
   *   ApiFuture<SingleTenantHsmInstanceProposal> future =
   *       hsmManagementClient
   *           .listSingleTenantHsmInstanceProposalsPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (SingleTenantHsmInstanceProposal element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListSingleTenantHsmInstanceProposalsRequest,
          ListSingleTenantHsmInstanceProposalsPagedResponse>
      listSingleTenantHsmInstanceProposalsPagedCallable() {
    return stub.listSingleTenantHsmInstanceProposalsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [SingleTenantHsmInstanceProposals][google.cloud.kms.v1.SingleTenantHsmInstanceProposal].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HsmManagementClient hsmManagementClient = HsmManagementClient.create()) {
   *   ListSingleTenantHsmInstanceProposalsRequest request =
   *       ListSingleTenantHsmInstanceProposalsRequest.newBuilder()
   *           .setParent(
   *               SingleTenantHsmInstanceName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SINGLE_TENANT_HSM_INSTANCE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setShowDeleted(true)
   *           .build();
   *   while (true) {
   *     ListSingleTenantHsmInstanceProposalsResponse response =
   *         hsmManagementClient.listSingleTenantHsmInstanceProposalsCallable().call(request);
   *     for (SingleTenantHsmInstanceProposal element :
   *         response.getSingleTenantHsmInstanceProposalsList()) {
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
          ListSingleTenantHsmInstanceProposalsRequest, ListSingleTenantHsmInstanceProposalsResponse>
      listSingleTenantHsmInstanceProposalsCallable() {
    return stub.listSingleTenantHsmInstanceProposalsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a
   * [SingleTenantHsmInstanceProposal][google.cloud.kms.v1.SingleTenantHsmInstanceProposal].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HsmManagementClient hsmManagementClient = HsmManagementClient.create()) {
   *   SingleTenantHsmInstanceProposalName name =
   *       SingleTenantHsmInstanceProposalName.of(
   *           "[PROJECT]", "[LOCATION]", "[SINGLE_TENANT_HSM_INSTANCE]", "[PROPOSAL]");
   *   hsmManagementClient.deleteSingleTenantHsmInstanceProposal(name);
   * }
   * }</pre>
   *
   * @param name Required. The [name][google.cloud.kms.v1.SingleTenantHsmInstanceProposal.name] of
   *     the [SingleTenantHsmInstanceProposal][google.cloud.kms.v1.SingleTenantHsmInstanceProposal]
   *     to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSingleTenantHsmInstanceProposal(
      SingleTenantHsmInstanceProposalName name) {
    DeleteSingleTenantHsmInstanceProposalRequest request =
        DeleteSingleTenantHsmInstanceProposalRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteSingleTenantHsmInstanceProposal(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a
   * [SingleTenantHsmInstanceProposal][google.cloud.kms.v1.SingleTenantHsmInstanceProposal].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HsmManagementClient hsmManagementClient = HsmManagementClient.create()) {
   *   String name =
   *       SingleTenantHsmInstanceProposalName.of(
   *               "[PROJECT]", "[LOCATION]", "[SINGLE_TENANT_HSM_INSTANCE]", "[PROPOSAL]")
   *           .toString();
   *   hsmManagementClient.deleteSingleTenantHsmInstanceProposal(name);
   * }
   * }</pre>
   *
   * @param name Required. The [name][google.cloud.kms.v1.SingleTenantHsmInstanceProposal.name] of
   *     the [SingleTenantHsmInstanceProposal][google.cloud.kms.v1.SingleTenantHsmInstanceProposal]
   *     to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSingleTenantHsmInstanceProposal(String name) {
    DeleteSingleTenantHsmInstanceProposalRequest request =
        DeleteSingleTenantHsmInstanceProposalRequest.newBuilder().setName(name).build();
    deleteSingleTenantHsmInstanceProposal(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a
   * [SingleTenantHsmInstanceProposal][google.cloud.kms.v1.SingleTenantHsmInstanceProposal].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HsmManagementClient hsmManagementClient = HsmManagementClient.create()) {
   *   DeleteSingleTenantHsmInstanceProposalRequest request =
   *       DeleteSingleTenantHsmInstanceProposalRequest.newBuilder()
   *           .setName(
   *               SingleTenantHsmInstanceProposalName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SINGLE_TENANT_HSM_INSTANCE]", "[PROPOSAL]")
   *                   .toString())
   *           .build();
   *   hsmManagementClient.deleteSingleTenantHsmInstanceProposal(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSingleTenantHsmInstanceProposal(
      DeleteSingleTenantHsmInstanceProposalRequest request) {
    deleteSingleTenantHsmInstanceProposalCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a
   * [SingleTenantHsmInstanceProposal][google.cloud.kms.v1.SingleTenantHsmInstanceProposal].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HsmManagementClient hsmManagementClient = HsmManagementClient.create()) {
   *   DeleteSingleTenantHsmInstanceProposalRequest request =
   *       DeleteSingleTenantHsmInstanceProposalRequest.newBuilder()
   *           .setName(
   *               SingleTenantHsmInstanceProposalName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SINGLE_TENANT_HSM_INSTANCE]", "[PROPOSAL]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       hsmManagementClient.deleteSingleTenantHsmInstanceProposalCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteSingleTenantHsmInstanceProposalRequest, Empty>
      deleteSingleTenantHsmInstanceProposalCallable() {
    return stub.deleteSingleTenantHsmInstanceProposalCallable();
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
   * try (HsmManagementClient hsmManagementClient = HsmManagementClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : hsmManagementClient.listLocations(request).iterateAll()) {
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
   * try (HsmManagementClient hsmManagementClient = HsmManagementClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       hsmManagementClient.listLocationsPagedCallable().futureCall(request);
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
   * try (HsmManagementClient hsmManagementClient = HsmManagementClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = hsmManagementClient.listLocationsCallable().call(request);
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
   * try (HsmManagementClient hsmManagementClient = HsmManagementClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = hsmManagementClient.getLocation(request);
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
   * try (HsmManagementClient hsmManagementClient = HsmManagementClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = hsmManagementClient.getLocationCallable().futureCall(request);
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
   * try (HsmManagementClient hsmManagementClient = HsmManagementClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = hsmManagementClient.setIamPolicy(request);
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
   * try (HsmManagementClient hsmManagementClient = HsmManagementClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = hsmManagementClient.setIamPolicyCallable().futureCall(request);
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
   * try (HsmManagementClient hsmManagementClient = HsmManagementClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = hsmManagementClient.getIamPolicy(request);
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
   * try (HsmManagementClient hsmManagementClient = HsmManagementClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = hsmManagementClient.getIamPolicyCallable().futureCall(request);
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
   * try (HsmManagementClient hsmManagementClient = HsmManagementClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = hsmManagementClient.testIamPermissions(request);
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
   * try (HsmManagementClient hsmManagementClient = HsmManagementClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       hsmManagementClient.testIamPermissionsCallable().futureCall(request);
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

  public static class ListSingleTenantHsmInstancesPagedResponse
      extends AbstractPagedListResponse<
          ListSingleTenantHsmInstancesRequest,
          ListSingleTenantHsmInstancesResponse,
          SingleTenantHsmInstance,
          ListSingleTenantHsmInstancesPage,
          ListSingleTenantHsmInstancesFixedSizeCollection> {

    public static ApiFuture<ListSingleTenantHsmInstancesPagedResponse> createAsync(
        PageContext<
                ListSingleTenantHsmInstancesRequest,
                ListSingleTenantHsmInstancesResponse,
                SingleTenantHsmInstance>
            context,
        ApiFuture<ListSingleTenantHsmInstancesResponse> futureResponse) {
      ApiFuture<ListSingleTenantHsmInstancesPage> futurePage =
          ListSingleTenantHsmInstancesPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListSingleTenantHsmInstancesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListSingleTenantHsmInstancesPagedResponse(ListSingleTenantHsmInstancesPage page) {
      super(page, ListSingleTenantHsmInstancesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSingleTenantHsmInstancesPage
      extends AbstractPage<
          ListSingleTenantHsmInstancesRequest,
          ListSingleTenantHsmInstancesResponse,
          SingleTenantHsmInstance,
          ListSingleTenantHsmInstancesPage> {

    private ListSingleTenantHsmInstancesPage(
        PageContext<
                ListSingleTenantHsmInstancesRequest,
                ListSingleTenantHsmInstancesResponse,
                SingleTenantHsmInstance>
            context,
        ListSingleTenantHsmInstancesResponse response) {
      super(context, response);
    }

    private static ListSingleTenantHsmInstancesPage createEmptyPage() {
      return new ListSingleTenantHsmInstancesPage(null, null);
    }

    @Override
    protected ListSingleTenantHsmInstancesPage createPage(
        PageContext<
                ListSingleTenantHsmInstancesRequest,
                ListSingleTenantHsmInstancesResponse,
                SingleTenantHsmInstance>
            context,
        ListSingleTenantHsmInstancesResponse response) {
      return new ListSingleTenantHsmInstancesPage(context, response);
    }

    @Override
    public ApiFuture<ListSingleTenantHsmInstancesPage> createPageAsync(
        PageContext<
                ListSingleTenantHsmInstancesRequest,
                ListSingleTenantHsmInstancesResponse,
                SingleTenantHsmInstance>
            context,
        ApiFuture<ListSingleTenantHsmInstancesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSingleTenantHsmInstancesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSingleTenantHsmInstancesRequest,
          ListSingleTenantHsmInstancesResponse,
          SingleTenantHsmInstance,
          ListSingleTenantHsmInstancesPage,
          ListSingleTenantHsmInstancesFixedSizeCollection> {

    private ListSingleTenantHsmInstancesFixedSizeCollection(
        List<ListSingleTenantHsmInstancesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSingleTenantHsmInstancesFixedSizeCollection createEmptyCollection() {
      return new ListSingleTenantHsmInstancesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSingleTenantHsmInstancesFixedSizeCollection createCollection(
        List<ListSingleTenantHsmInstancesPage> pages, int collectionSize) {
      return new ListSingleTenantHsmInstancesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListSingleTenantHsmInstanceProposalsPagedResponse
      extends AbstractPagedListResponse<
          ListSingleTenantHsmInstanceProposalsRequest,
          ListSingleTenantHsmInstanceProposalsResponse,
          SingleTenantHsmInstanceProposal,
          ListSingleTenantHsmInstanceProposalsPage,
          ListSingleTenantHsmInstanceProposalsFixedSizeCollection> {

    public static ApiFuture<ListSingleTenantHsmInstanceProposalsPagedResponse> createAsync(
        PageContext<
                ListSingleTenantHsmInstanceProposalsRequest,
                ListSingleTenantHsmInstanceProposalsResponse,
                SingleTenantHsmInstanceProposal>
            context,
        ApiFuture<ListSingleTenantHsmInstanceProposalsResponse> futureResponse) {
      ApiFuture<ListSingleTenantHsmInstanceProposalsPage> futurePage =
          ListSingleTenantHsmInstanceProposalsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListSingleTenantHsmInstanceProposalsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListSingleTenantHsmInstanceProposalsPagedResponse(
        ListSingleTenantHsmInstanceProposalsPage page) {
      super(page, ListSingleTenantHsmInstanceProposalsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSingleTenantHsmInstanceProposalsPage
      extends AbstractPage<
          ListSingleTenantHsmInstanceProposalsRequest,
          ListSingleTenantHsmInstanceProposalsResponse,
          SingleTenantHsmInstanceProposal,
          ListSingleTenantHsmInstanceProposalsPage> {

    private ListSingleTenantHsmInstanceProposalsPage(
        PageContext<
                ListSingleTenantHsmInstanceProposalsRequest,
                ListSingleTenantHsmInstanceProposalsResponse,
                SingleTenantHsmInstanceProposal>
            context,
        ListSingleTenantHsmInstanceProposalsResponse response) {
      super(context, response);
    }

    private static ListSingleTenantHsmInstanceProposalsPage createEmptyPage() {
      return new ListSingleTenantHsmInstanceProposalsPage(null, null);
    }

    @Override
    protected ListSingleTenantHsmInstanceProposalsPage createPage(
        PageContext<
                ListSingleTenantHsmInstanceProposalsRequest,
                ListSingleTenantHsmInstanceProposalsResponse,
                SingleTenantHsmInstanceProposal>
            context,
        ListSingleTenantHsmInstanceProposalsResponse response) {
      return new ListSingleTenantHsmInstanceProposalsPage(context, response);
    }

    @Override
    public ApiFuture<ListSingleTenantHsmInstanceProposalsPage> createPageAsync(
        PageContext<
                ListSingleTenantHsmInstanceProposalsRequest,
                ListSingleTenantHsmInstanceProposalsResponse,
                SingleTenantHsmInstanceProposal>
            context,
        ApiFuture<ListSingleTenantHsmInstanceProposalsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSingleTenantHsmInstanceProposalsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSingleTenantHsmInstanceProposalsRequest,
          ListSingleTenantHsmInstanceProposalsResponse,
          SingleTenantHsmInstanceProposal,
          ListSingleTenantHsmInstanceProposalsPage,
          ListSingleTenantHsmInstanceProposalsFixedSizeCollection> {

    private ListSingleTenantHsmInstanceProposalsFixedSizeCollection(
        List<ListSingleTenantHsmInstanceProposalsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSingleTenantHsmInstanceProposalsFixedSizeCollection createEmptyCollection() {
      return new ListSingleTenantHsmInstanceProposalsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSingleTenantHsmInstanceProposalsFixedSizeCollection createCollection(
        List<ListSingleTenantHsmInstanceProposalsPage> pages, int collectionSize) {
      return new ListSingleTenantHsmInstanceProposalsFixedSizeCollection(pages, collectionSize);
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
