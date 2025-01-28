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
import com.google.cloud.networkmanagement.v1.stub.VpcFlowLogsServiceStub;
import com.google.cloud.networkmanagement.v1.stub.VpcFlowLogsServiceStubSettings;
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
 * Service Description: The VPC Flow Logs service in the Google Cloud Network Management API
 * provides configurations that generate Flow Logs. The service and the configuration resources
 * created using this service are global.
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
 * try (VpcFlowLogsServiceClient vpcFlowLogsServiceClient = VpcFlowLogsServiceClient.create()) {
 *   VpcFlowLogsConfigName name =
 *       VpcFlowLogsConfigName.of("[PROJECT]", "[LOCATION]", "[VPC_FLOW_LOGS_CONFIG]");
 *   VpcFlowLogsConfig response = vpcFlowLogsServiceClient.getVpcFlowLogsConfig(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the VpcFlowLogsServiceClient object to clean up resources
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
 *      <td><p> ListVpcFlowLogsConfigs</td>
 *      <td><p> Lists all `VpcFlowLogsConfigs` in a given project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listVpcFlowLogsConfigs(ListVpcFlowLogsConfigsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listVpcFlowLogsConfigs(LocationName parent)
 *           <li><p> listVpcFlowLogsConfigs(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listVpcFlowLogsConfigsPagedCallable()
 *           <li><p> listVpcFlowLogsConfigsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetVpcFlowLogsConfig</td>
 *      <td><p> Gets the details of a specific `VpcFlowLogsConfig`.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getVpcFlowLogsConfig(GetVpcFlowLogsConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getVpcFlowLogsConfig(VpcFlowLogsConfigName name)
 *           <li><p> getVpcFlowLogsConfig(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getVpcFlowLogsConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateVpcFlowLogsConfig</td>
 *      <td><p> Creates a new `VpcFlowLogsConfig`. If a configuration with the exact same settings already exists (even if the ID is different), the creation fails. Notes:
 * <p>    1. Creating a configuration with state=DISABLED will fail   2. The following fields are not considered as `settings` for the purpose   of the check mentioned above, therefore - creating another configuration   with the same fields but different values for the following fields will   fail as well:       &#42; name       &#42; create_time       &#42; update_time       &#42; labels       &#42; description</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createVpcFlowLogsConfigAsync(CreateVpcFlowLogsConfigRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createVpcFlowLogsConfigAsync(LocationName parent, VpcFlowLogsConfig vpcFlowLogsConfig, VpcFlowLogsConfigName vpcFlowLogsConfigId)
 *           <li><p> createVpcFlowLogsConfigAsync(LocationName parent, VpcFlowLogsConfig vpcFlowLogsConfig, String vpcFlowLogsConfigId)
 *           <li><p> createVpcFlowLogsConfigAsync(String parent, VpcFlowLogsConfig vpcFlowLogsConfig, VpcFlowLogsConfigName vpcFlowLogsConfigId)
 *           <li><p> createVpcFlowLogsConfigAsync(String parent, VpcFlowLogsConfig vpcFlowLogsConfig, String vpcFlowLogsConfigId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createVpcFlowLogsConfigOperationCallable()
 *           <li><p> createVpcFlowLogsConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateVpcFlowLogsConfig</td>
 *      <td><p> Updates an existing `VpcFlowLogsConfig`. If a configuration with the exact same settings already exists (even if the ID is different), the creation fails. Notes:
 * <p>    1. Updating a configuration with state=DISABLED will fail.   2. The following fields are not considered as `settings` for the purpose   of the check mentioned above, therefore - updating another configuration   with the same fields but different values for the following fields will   fail as well:       &#42; name       &#42; create_time       &#42; update_time       &#42; labels       &#42; description</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateVpcFlowLogsConfigAsync(UpdateVpcFlowLogsConfigRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateVpcFlowLogsConfigAsync(VpcFlowLogsConfig vpcFlowLogsConfig, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateVpcFlowLogsConfigOperationCallable()
 *           <li><p> updateVpcFlowLogsConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteVpcFlowLogsConfig</td>
 *      <td><p> Deletes a specific `VpcFlowLogsConfig`.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteVpcFlowLogsConfigAsync(DeleteVpcFlowLogsConfigRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteVpcFlowLogsConfigAsync(VpcFlowLogsConfigName name)
 *           <li><p> deleteVpcFlowLogsConfigAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteVpcFlowLogsConfigOperationCallable()
 *           <li><p> deleteVpcFlowLogsConfigCallable()
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
 * <p>This class can be customized by passing in a custom instance of VpcFlowLogsServiceSettings to
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
 * VpcFlowLogsServiceSettings vpcFlowLogsServiceSettings =
 *     VpcFlowLogsServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * VpcFlowLogsServiceClient vpcFlowLogsServiceClient =
 *     VpcFlowLogsServiceClient.create(vpcFlowLogsServiceSettings);
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
 * VpcFlowLogsServiceSettings vpcFlowLogsServiceSettings =
 *     VpcFlowLogsServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * VpcFlowLogsServiceClient vpcFlowLogsServiceClient =
 *     VpcFlowLogsServiceClient.create(vpcFlowLogsServiceSettings);
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
 * VpcFlowLogsServiceSettings vpcFlowLogsServiceSettings =
 *     VpcFlowLogsServiceSettings.newHttpJsonBuilder().build();
 * VpcFlowLogsServiceClient vpcFlowLogsServiceClient =
 *     VpcFlowLogsServiceClient.create(vpcFlowLogsServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class VpcFlowLogsServiceClient implements BackgroundResource {
  private final VpcFlowLogsServiceSettings settings;
  private final VpcFlowLogsServiceStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of VpcFlowLogsServiceClient with default settings. */
  public static final VpcFlowLogsServiceClient create() throws IOException {
    return create(VpcFlowLogsServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of VpcFlowLogsServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final VpcFlowLogsServiceClient create(VpcFlowLogsServiceSettings settings)
      throws IOException {
    return new VpcFlowLogsServiceClient(settings);
  }

  /**
   * Constructs an instance of VpcFlowLogsServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(VpcFlowLogsServiceSettings).
   */
  public static final VpcFlowLogsServiceClient create(VpcFlowLogsServiceStub stub) {
    return new VpcFlowLogsServiceClient(stub);
  }

  /**
   * Constructs an instance of VpcFlowLogsServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected VpcFlowLogsServiceClient(VpcFlowLogsServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((VpcFlowLogsServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected VpcFlowLogsServiceClient(VpcFlowLogsServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final VpcFlowLogsServiceSettings getSettings() {
    return settings;
  }

  public VpcFlowLogsServiceStub getStub() {
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
   * Lists all `VpcFlowLogsConfigs` in a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VpcFlowLogsServiceClient vpcFlowLogsServiceClient = VpcFlowLogsServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (VpcFlowLogsConfig element :
   *       vpcFlowLogsServiceClient.listVpcFlowLogsConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the VpcFlowLogsConfig:
   *     `projects/{project_id}/locations/global`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListVpcFlowLogsConfigsPagedResponse listVpcFlowLogsConfigs(LocationName parent) {
    ListVpcFlowLogsConfigsRequest request =
        ListVpcFlowLogsConfigsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listVpcFlowLogsConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all `VpcFlowLogsConfigs` in a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VpcFlowLogsServiceClient vpcFlowLogsServiceClient = VpcFlowLogsServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (VpcFlowLogsConfig element :
   *       vpcFlowLogsServiceClient.listVpcFlowLogsConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the VpcFlowLogsConfig:
   *     `projects/{project_id}/locations/global`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListVpcFlowLogsConfigsPagedResponse listVpcFlowLogsConfigs(String parent) {
    ListVpcFlowLogsConfigsRequest request =
        ListVpcFlowLogsConfigsRequest.newBuilder().setParent(parent).build();
    return listVpcFlowLogsConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all `VpcFlowLogsConfigs` in a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VpcFlowLogsServiceClient vpcFlowLogsServiceClient = VpcFlowLogsServiceClient.create()) {
   *   ListVpcFlowLogsConfigsRequest request =
   *       ListVpcFlowLogsConfigsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (VpcFlowLogsConfig element :
   *       vpcFlowLogsServiceClient.listVpcFlowLogsConfigs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListVpcFlowLogsConfigsPagedResponse listVpcFlowLogsConfigs(
      ListVpcFlowLogsConfigsRequest request) {
    return listVpcFlowLogsConfigsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all `VpcFlowLogsConfigs` in a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VpcFlowLogsServiceClient vpcFlowLogsServiceClient = VpcFlowLogsServiceClient.create()) {
   *   ListVpcFlowLogsConfigsRequest request =
   *       ListVpcFlowLogsConfigsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<VpcFlowLogsConfig> future =
   *       vpcFlowLogsServiceClient.listVpcFlowLogsConfigsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (VpcFlowLogsConfig element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListVpcFlowLogsConfigsRequest, ListVpcFlowLogsConfigsPagedResponse>
      listVpcFlowLogsConfigsPagedCallable() {
    return stub.listVpcFlowLogsConfigsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all `VpcFlowLogsConfigs` in a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VpcFlowLogsServiceClient vpcFlowLogsServiceClient = VpcFlowLogsServiceClient.create()) {
   *   ListVpcFlowLogsConfigsRequest request =
   *       ListVpcFlowLogsConfigsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListVpcFlowLogsConfigsResponse response =
   *         vpcFlowLogsServiceClient.listVpcFlowLogsConfigsCallable().call(request);
   *     for (VpcFlowLogsConfig element : response.getVpcFlowLogsConfigsList()) {
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
  public final UnaryCallable<ListVpcFlowLogsConfigsRequest, ListVpcFlowLogsConfigsResponse>
      listVpcFlowLogsConfigsCallable() {
    return stub.listVpcFlowLogsConfigsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a specific `VpcFlowLogsConfig`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VpcFlowLogsServiceClient vpcFlowLogsServiceClient = VpcFlowLogsServiceClient.create()) {
   *   VpcFlowLogsConfigName name =
   *       VpcFlowLogsConfigName.of("[PROJECT]", "[LOCATION]", "[VPC_FLOW_LOGS_CONFIG]");
   *   VpcFlowLogsConfig response = vpcFlowLogsServiceClient.getVpcFlowLogsConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. `VpcFlowLogsConfig` resource name using the form:
   *     `projects/{project_id}/locations/global/vpcFlowLogsConfigs/{vpc_flow_logs_config}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VpcFlowLogsConfig getVpcFlowLogsConfig(VpcFlowLogsConfigName name) {
    GetVpcFlowLogsConfigRequest request =
        GetVpcFlowLogsConfigRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getVpcFlowLogsConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a specific `VpcFlowLogsConfig`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VpcFlowLogsServiceClient vpcFlowLogsServiceClient = VpcFlowLogsServiceClient.create()) {
   *   String name =
   *       VpcFlowLogsConfigName.of("[PROJECT]", "[LOCATION]", "[VPC_FLOW_LOGS_CONFIG]").toString();
   *   VpcFlowLogsConfig response = vpcFlowLogsServiceClient.getVpcFlowLogsConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. `VpcFlowLogsConfig` resource name using the form:
   *     `projects/{project_id}/locations/global/vpcFlowLogsConfigs/{vpc_flow_logs_config}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VpcFlowLogsConfig getVpcFlowLogsConfig(String name) {
    GetVpcFlowLogsConfigRequest request =
        GetVpcFlowLogsConfigRequest.newBuilder().setName(name).build();
    return getVpcFlowLogsConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a specific `VpcFlowLogsConfig`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VpcFlowLogsServiceClient vpcFlowLogsServiceClient = VpcFlowLogsServiceClient.create()) {
   *   GetVpcFlowLogsConfigRequest request =
   *       GetVpcFlowLogsConfigRequest.newBuilder()
   *           .setName(
   *               VpcFlowLogsConfigName.of("[PROJECT]", "[LOCATION]", "[VPC_FLOW_LOGS_CONFIG]")
   *                   .toString())
   *           .build();
   *   VpcFlowLogsConfig response = vpcFlowLogsServiceClient.getVpcFlowLogsConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VpcFlowLogsConfig getVpcFlowLogsConfig(GetVpcFlowLogsConfigRequest request) {
    return getVpcFlowLogsConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a specific `VpcFlowLogsConfig`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VpcFlowLogsServiceClient vpcFlowLogsServiceClient = VpcFlowLogsServiceClient.create()) {
   *   GetVpcFlowLogsConfigRequest request =
   *       GetVpcFlowLogsConfigRequest.newBuilder()
   *           .setName(
   *               VpcFlowLogsConfigName.of("[PROJECT]", "[LOCATION]", "[VPC_FLOW_LOGS_CONFIG]")
   *                   .toString())
   *           .build();
   *   ApiFuture<VpcFlowLogsConfig> future =
   *       vpcFlowLogsServiceClient.getVpcFlowLogsConfigCallable().futureCall(request);
   *   // Do something.
   *   VpcFlowLogsConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetVpcFlowLogsConfigRequest, VpcFlowLogsConfig>
      getVpcFlowLogsConfigCallable() {
    return stub.getVpcFlowLogsConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new `VpcFlowLogsConfig`. If a configuration with the exact same settings already
   * exists (even if the ID is different), the creation fails. Notes:
   *
   * <p>1. Creating a configuration with state=DISABLED will fail 2. The following fields are not
   * considered as `settings` for the purpose of the check mentioned above, therefore - creating
   * another configuration with the same fields but different values for the following fields will
   * fail as well: &#42; name &#42; create_time &#42; update_time &#42; labels &#42; description
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VpcFlowLogsServiceClient vpcFlowLogsServiceClient = VpcFlowLogsServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   VpcFlowLogsConfig vpcFlowLogsConfig = VpcFlowLogsConfig.newBuilder().build();
   *   VpcFlowLogsConfigName vpcFlowLogsConfigId =
   *       VpcFlowLogsConfigName.of("[PROJECT]", "[LOCATION]", "[VPC_FLOW_LOGS_CONFIG]");
   *   VpcFlowLogsConfig response =
   *       vpcFlowLogsServiceClient
   *           .createVpcFlowLogsConfigAsync(parent, vpcFlowLogsConfig, vpcFlowLogsConfigId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the VPC Flow Logs configuration to create:
   *     `projects/{project_id}/locations/global`
   * @param vpcFlowLogsConfig Required. A `VpcFlowLogsConfig` resource
   * @param vpcFlowLogsConfigId Required. ID of the `VpcFlowLogsConfig`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<VpcFlowLogsConfig, OperationMetadata> createVpcFlowLogsConfigAsync(
      LocationName parent,
      VpcFlowLogsConfig vpcFlowLogsConfig,
      VpcFlowLogsConfigName vpcFlowLogsConfigId) {
    CreateVpcFlowLogsConfigRequest request =
        CreateVpcFlowLogsConfigRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setVpcFlowLogsConfig(vpcFlowLogsConfig)
            .setVpcFlowLogsConfigId(
                vpcFlowLogsConfigId == null ? null : vpcFlowLogsConfigId.toString())
            .build();
    return createVpcFlowLogsConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new `VpcFlowLogsConfig`. If a configuration with the exact same settings already
   * exists (even if the ID is different), the creation fails. Notes:
   *
   * <p>1. Creating a configuration with state=DISABLED will fail 2. The following fields are not
   * considered as `settings` for the purpose of the check mentioned above, therefore - creating
   * another configuration with the same fields but different values for the following fields will
   * fail as well: &#42; name &#42; create_time &#42; update_time &#42; labels &#42; description
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VpcFlowLogsServiceClient vpcFlowLogsServiceClient = VpcFlowLogsServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   VpcFlowLogsConfig vpcFlowLogsConfig = VpcFlowLogsConfig.newBuilder().build();
   *   String vpcFlowLogsConfigId =
   *       VpcFlowLogsConfigName.of("[PROJECT]", "[LOCATION]", "[VPC_FLOW_LOGS_CONFIG]").toString();
   *   VpcFlowLogsConfig response =
   *       vpcFlowLogsServiceClient
   *           .createVpcFlowLogsConfigAsync(parent, vpcFlowLogsConfig, vpcFlowLogsConfigId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the VPC Flow Logs configuration to create:
   *     `projects/{project_id}/locations/global`
   * @param vpcFlowLogsConfig Required. A `VpcFlowLogsConfig` resource
   * @param vpcFlowLogsConfigId Required. ID of the `VpcFlowLogsConfig`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<VpcFlowLogsConfig, OperationMetadata> createVpcFlowLogsConfigAsync(
      LocationName parent, VpcFlowLogsConfig vpcFlowLogsConfig, String vpcFlowLogsConfigId) {
    CreateVpcFlowLogsConfigRequest request =
        CreateVpcFlowLogsConfigRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setVpcFlowLogsConfig(vpcFlowLogsConfig)
            .setVpcFlowLogsConfigId(vpcFlowLogsConfigId)
            .build();
    return createVpcFlowLogsConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new `VpcFlowLogsConfig`. If a configuration with the exact same settings already
   * exists (even if the ID is different), the creation fails. Notes:
   *
   * <p>1. Creating a configuration with state=DISABLED will fail 2. The following fields are not
   * considered as `settings` for the purpose of the check mentioned above, therefore - creating
   * another configuration with the same fields but different values for the following fields will
   * fail as well: &#42; name &#42; create_time &#42; update_time &#42; labels &#42; description
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VpcFlowLogsServiceClient vpcFlowLogsServiceClient = VpcFlowLogsServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   VpcFlowLogsConfig vpcFlowLogsConfig = VpcFlowLogsConfig.newBuilder().build();
   *   VpcFlowLogsConfigName vpcFlowLogsConfigId =
   *       VpcFlowLogsConfigName.of("[PROJECT]", "[LOCATION]", "[VPC_FLOW_LOGS_CONFIG]");
   *   VpcFlowLogsConfig response =
   *       vpcFlowLogsServiceClient
   *           .createVpcFlowLogsConfigAsync(parent, vpcFlowLogsConfig, vpcFlowLogsConfigId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the VPC Flow Logs configuration to create:
   *     `projects/{project_id}/locations/global`
   * @param vpcFlowLogsConfig Required. A `VpcFlowLogsConfig` resource
   * @param vpcFlowLogsConfigId Required. ID of the `VpcFlowLogsConfig`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<VpcFlowLogsConfig, OperationMetadata> createVpcFlowLogsConfigAsync(
      String parent,
      VpcFlowLogsConfig vpcFlowLogsConfig,
      VpcFlowLogsConfigName vpcFlowLogsConfigId) {
    CreateVpcFlowLogsConfigRequest request =
        CreateVpcFlowLogsConfigRequest.newBuilder()
            .setParent(parent)
            .setVpcFlowLogsConfig(vpcFlowLogsConfig)
            .setVpcFlowLogsConfigId(
                vpcFlowLogsConfigId == null ? null : vpcFlowLogsConfigId.toString())
            .build();
    return createVpcFlowLogsConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new `VpcFlowLogsConfig`. If a configuration with the exact same settings already
   * exists (even if the ID is different), the creation fails. Notes:
   *
   * <p>1. Creating a configuration with state=DISABLED will fail 2. The following fields are not
   * considered as `settings` for the purpose of the check mentioned above, therefore - creating
   * another configuration with the same fields but different values for the following fields will
   * fail as well: &#42; name &#42; create_time &#42; update_time &#42; labels &#42; description
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VpcFlowLogsServiceClient vpcFlowLogsServiceClient = VpcFlowLogsServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   VpcFlowLogsConfig vpcFlowLogsConfig = VpcFlowLogsConfig.newBuilder().build();
   *   String vpcFlowLogsConfigId =
   *       VpcFlowLogsConfigName.of("[PROJECT]", "[LOCATION]", "[VPC_FLOW_LOGS_CONFIG]").toString();
   *   VpcFlowLogsConfig response =
   *       vpcFlowLogsServiceClient
   *           .createVpcFlowLogsConfigAsync(parent, vpcFlowLogsConfig, vpcFlowLogsConfigId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the VPC Flow Logs configuration to create:
   *     `projects/{project_id}/locations/global`
   * @param vpcFlowLogsConfig Required. A `VpcFlowLogsConfig` resource
   * @param vpcFlowLogsConfigId Required. ID of the `VpcFlowLogsConfig`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<VpcFlowLogsConfig, OperationMetadata> createVpcFlowLogsConfigAsync(
      String parent, VpcFlowLogsConfig vpcFlowLogsConfig, String vpcFlowLogsConfigId) {
    CreateVpcFlowLogsConfigRequest request =
        CreateVpcFlowLogsConfigRequest.newBuilder()
            .setParent(parent)
            .setVpcFlowLogsConfig(vpcFlowLogsConfig)
            .setVpcFlowLogsConfigId(vpcFlowLogsConfigId)
            .build();
    return createVpcFlowLogsConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new `VpcFlowLogsConfig`. If a configuration with the exact same settings already
   * exists (even if the ID is different), the creation fails. Notes:
   *
   * <p>1. Creating a configuration with state=DISABLED will fail 2. The following fields are not
   * considered as `settings` for the purpose of the check mentioned above, therefore - creating
   * another configuration with the same fields but different values for the following fields will
   * fail as well: &#42; name &#42; create_time &#42; update_time &#42; labels &#42; description
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VpcFlowLogsServiceClient vpcFlowLogsServiceClient = VpcFlowLogsServiceClient.create()) {
   *   CreateVpcFlowLogsConfigRequest request =
   *       CreateVpcFlowLogsConfigRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setVpcFlowLogsConfigId(
   *               VpcFlowLogsConfigName.of("[PROJECT]", "[LOCATION]", "[VPC_FLOW_LOGS_CONFIG]")
   *                   .toString())
   *           .setVpcFlowLogsConfig(VpcFlowLogsConfig.newBuilder().build())
   *           .build();
   *   VpcFlowLogsConfig response =
   *       vpcFlowLogsServiceClient.createVpcFlowLogsConfigAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<VpcFlowLogsConfig, OperationMetadata> createVpcFlowLogsConfigAsync(
      CreateVpcFlowLogsConfigRequest request) {
    return createVpcFlowLogsConfigOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new `VpcFlowLogsConfig`. If a configuration with the exact same settings already
   * exists (even if the ID is different), the creation fails. Notes:
   *
   * <p>1. Creating a configuration with state=DISABLED will fail 2. The following fields are not
   * considered as `settings` for the purpose of the check mentioned above, therefore - creating
   * another configuration with the same fields but different values for the following fields will
   * fail as well: &#42; name &#42; create_time &#42; update_time &#42; labels &#42; description
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VpcFlowLogsServiceClient vpcFlowLogsServiceClient = VpcFlowLogsServiceClient.create()) {
   *   CreateVpcFlowLogsConfigRequest request =
   *       CreateVpcFlowLogsConfigRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setVpcFlowLogsConfigId(
   *               VpcFlowLogsConfigName.of("[PROJECT]", "[LOCATION]", "[VPC_FLOW_LOGS_CONFIG]")
   *                   .toString())
   *           .setVpcFlowLogsConfig(VpcFlowLogsConfig.newBuilder().build())
   *           .build();
   *   OperationFuture<VpcFlowLogsConfig, OperationMetadata> future =
   *       vpcFlowLogsServiceClient.createVpcFlowLogsConfigOperationCallable().futureCall(request);
   *   // Do something.
   *   VpcFlowLogsConfig response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateVpcFlowLogsConfigRequest, VpcFlowLogsConfig, OperationMetadata>
      createVpcFlowLogsConfigOperationCallable() {
    return stub.createVpcFlowLogsConfigOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new `VpcFlowLogsConfig`. If a configuration with the exact same settings already
   * exists (even if the ID is different), the creation fails. Notes:
   *
   * <p>1. Creating a configuration with state=DISABLED will fail 2. The following fields are not
   * considered as `settings` for the purpose of the check mentioned above, therefore - creating
   * another configuration with the same fields but different values for the following fields will
   * fail as well: &#42; name &#42; create_time &#42; update_time &#42; labels &#42; description
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VpcFlowLogsServiceClient vpcFlowLogsServiceClient = VpcFlowLogsServiceClient.create()) {
   *   CreateVpcFlowLogsConfigRequest request =
   *       CreateVpcFlowLogsConfigRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setVpcFlowLogsConfigId(
   *               VpcFlowLogsConfigName.of("[PROJECT]", "[LOCATION]", "[VPC_FLOW_LOGS_CONFIG]")
   *                   .toString())
   *           .setVpcFlowLogsConfig(VpcFlowLogsConfig.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       vpcFlowLogsServiceClient.createVpcFlowLogsConfigCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateVpcFlowLogsConfigRequest, Operation>
      createVpcFlowLogsConfigCallable() {
    return stub.createVpcFlowLogsConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing `VpcFlowLogsConfig`. If a configuration with the exact same settings
   * already exists (even if the ID is different), the creation fails. Notes:
   *
   * <p>1. Updating a configuration with state=DISABLED will fail. 2. The following fields are not
   * considered as `settings` for the purpose of the check mentioned above, therefore - updating
   * another configuration with the same fields but different values for the following fields will
   * fail as well: &#42; name &#42; create_time &#42; update_time &#42; labels &#42; description
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VpcFlowLogsServiceClient vpcFlowLogsServiceClient = VpcFlowLogsServiceClient.create()) {
   *   VpcFlowLogsConfig vpcFlowLogsConfig = VpcFlowLogsConfig.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   VpcFlowLogsConfig response =
   *       vpcFlowLogsServiceClient
   *           .updateVpcFlowLogsConfigAsync(vpcFlowLogsConfig, updateMask)
   *           .get();
   * }
   * }</pre>
   *
   * @param vpcFlowLogsConfig Required. Only fields specified in update_mask are updated.
   * @param updateMask Required. Mask of fields to update. At least one path must be supplied in
   *     this field.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<VpcFlowLogsConfig, OperationMetadata> updateVpcFlowLogsConfigAsync(
      VpcFlowLogsConfig vpcFlowLogsConfig, FieldMask updateMask) {
    UpdateVpcFlowLogsConfigRequest request =
        UpdateVpcFlowLogsConfigRequest.newBuilder()
            .setVpcFlowLogsConfig(vpcFlowLogsConfig)
            .setUpdateMask(updateMask)
            .build();
    return updateVpcFlowLogsConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing `VpcFlowLogsConfig`. If a configuration with the exact same settings
   * already exists (even if the ID is different), the creation fails. Notes:
   *
   * <p>1. Updating a configuration with state=DISABLED will fail. 2. The following fields are not
   * considered as `settings` for the purpose of the check mentioned above, therefore - updating
   * another configuration with the same fields but different values for the following fields will
   * fail as well: &#42; name &#42; create_time &#42; update_time &#42; labels &#42; description
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VpcFlowLogsServiceClient vpcFlowLogsServiceClient = VpcFlowLogsServiceClient.create()) {
   *   UpdateVpcFlowLogsConfigRequest request =
   *       UpdateVpcFlowLogsConfigRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setVpcFlowLogsConfig(VpcFlowLogsConfig.newBuilder().build())
   *           .build();
   *   VpcFlowLogsConfig response =
   *       vpcFlowLogsServiceClient.updateVpcFlowLogsConfigAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<VpcFlowLogsConfig, OperationMetadata> updateVpcFlowLogsConfigAsync(
      UpdateVpcFlowLogsConfigRequest request) {
    return updateVpcFlowLogsConfigOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing `VpcFlowLogsConfig`. If a configuration with the exact same settings
   * already exists (even if the ID is different), the creation fails. Notes:
   *
   * <p>1. Updating a configuration with state=DISABLED will fail. 2. The following fields are not
   * considered as `settings` for the purpose of the check mentioned above, therefore - updating
   * another configuration with the same fields but different values for the following fields will
   * fail as well: &#42; name &#42; create_time &#42; update_time &#42; labels &#42; description
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VpcFlowLogsServiceClient vpcFlowLogsServiceClient = VpcFlowLogsServiceClient.create()) {
   *   UpdateVpcFlowLogsConfigRequest request =
   *       UpdateVpcFlowLogsConfigRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setVpcFlowLogsConfig(VpcFlowLogsConfig.newBuilder().build())
   *           .build();
   *   OperationFuture<VpcFlowLogsConfig, OperationMetadata> future =
   *       vpcFlowLogsServiceClient.updateVpcFlowLogsConfigOperationCallable().futureCall(request);
   *   // Do something.
   *   VpcFlowLogsConfig response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UpdateVpcFlowLogsConfigRequest, VpcFlowLogsConfig, OperationMetadata>
      updateVpcFlowLogsConfigOperationCallable() {
    return stub.updateVpcFlowLogsConfigOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing `VpcFlowLogsConfig`. If a configuration with the exact same settings
   * already exists (even if the ID is different), the creation fails. Notes:
   *
   * <p>1. Updating a configuration with state=DISABLED will fail. 2. The following fields are not
   * considered as `settings` for the purpose of the check mentioned above, therefore - updating
   * another configuration with the same fields but different values for the following fields will
   * fail as well: &#42; name &#42; create_time &#42; update_time &#42; labels &#42; description
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VpcFlowLogsServiceClient vpcFlowLogsServiceClient = VpcFlowLogsServiceClient.create()) {
   *   UpdateVpcFlowLogsConfigRequest request =
   *       UpdateVpcFlowLogsConfigRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setVpcFlowLogsConfig(VpcFlowLogsConfig.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       vpcFlowLogsServiceClient.updateVpcFlowLogsConfigCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateVpcFlowLogsConfigRequest, Operation>
      updateVpcFlowLogsConfigCallable() {
    return stub.updateVpcFlowLogsConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific `VpcFlowLogsConfig`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VpcFlowLogsServiceClient vpcFlowLogsServiceClient = VpcFlowLogsServiceClient.create()) {
   *   VpcFlowLogsConfigName name =
   *       VpcFlowLogsConfigName.of("[PROJECT]", "[LOCATION]", "[VPC_FLOW_LOGS_CONFIG]");
   *   vpcFlowLogsServiceClient.deleteVpcFlowLogsConfigAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. `VpcFlowLogsConfig` resource name using the form:
   *     `projects/{project_id}/locations/global/vpcFlowLogsConfigs/{vpc_flow_logs_config}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteVpcFlowLogsConfigAsync(
      VpcFlowLogsConfigName name) {
    DeleteVpcFlowLogsConfigRequest request =
        DeleteVpcFlowLogsConfigRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteVpcFlowLogsConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific `VpcFlowLogsConfig`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VpcFlowLogsServiceClient vpcFlowLogsServiceClient = VpcFlowLogsServiceClient.create()) {
   *   String name =
   *       VpcFlowLogsConfigName.of("[PROJECT]", "[LOCATION]", "[VPC_FLOW_LOGS_CONFIG]").toString();
   *   vpcFlowLogsServiceClient.deleteVpcFlowLogsConfigAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. `VpcFlowLogsConfig` resource name using the form:
   *     `projects/{project_id}/locations/global/vpcFlowLogsConfigs/{vpc_flow_logs_config}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteVpcFlowLogsConfigAsync(String name) {
    DeleteVpcFlowLogsConfigRequest request =
        DeleteVpcFlowLogsConfigRequest.newBuilder().setName(name).build();
    return deleteVpcFlowLogsConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific `VpcFlowLogsConfig`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VpcFlowLogsServiceClient vpcFlowLogsServiceClient = VpcFlowLogsServiceClient.create()) {
   *   DeleteVpcFlowLogsConfigRequest request =
   *       DeleteVpcFlowLogsConfigRequest.newBuilder()
   *           .setName(
   *               VpcFlowLogsConfigName.of("[PROJECT]", "[LOCATION]", "[VPC_FLOW_LOGS_CONFIG]")
   *                   .toString())
   *           .build();
   *   vpcFlowLogsServiceClient.deleteVpcFlowLogsConfigAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteVpcFlowLogsConfigAsync(
      DeleteVpcFlowLogsConfigRequest request) {
    return deleteVpcFlowLogsConfigOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific `VpcFlowLogsConfig`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VpcFlowLogsServiceClient vpcFlowLogsServiceClient = VpcFlowLogsServiceClient.create()) {
   *   DeleteVpcFlowLogsConfigRequest request =
   *       DeleteVpcFlowLogsConfigRequest.newBuilder()
   *           .setName(
   *               VpcFlowLogsConfigName.of("[PROJECT]", "[LOCATION]", "[VPC_FLOW_LOGS_CONFIG]")
   *                   .toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       vpcFlowLogsServiceClient.deleteVpcFlowLogsConfigOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteVpcFlowLogsConfigRequest, Empty, OperationMetadata>
      deleteVpcFlowLogsConfigOperationCallable() {
    return stub.deleteVpcFlowLogsConfigOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific `VpcFlowLogsConfig`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VpcFlowLogsServiceClient vpcFlowLogsServiceClient = VpcFlowLogsServiceClient.create()) {
   *   DeleteVpcFlowLogsConfigRequest request =
   *       DeleteVpcFlowLogsConfigRequest.newBuilder()
   *           .setName(
   *               VpcFlowLogsConfigName.of("[PROJECT]", "[LOCATION]", "[VPC_FLOW_LOGS_CONFIG]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       vpcFlowLogsServiceClient.deleteVpcFlowLogsConfigCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteVpcFlowLogsConfigRequest, Operation>
      deleteVpcFlowLogsConfigCallable() {
    return stub.deleteVpcFlowLogsConfigCallable();
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
   * try (VpcFlowLogsServiceClient vpcFlowLogsServiceClient = VpcFlowLogsServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : vpcFlowLogsServiceClient.listLocations(request).iterateAll()) {
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
   * try (VpcFlowLogsServiceClient vpcFlowLogsServiceClient = VpcFlowLogsServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       vpcFlowLogsServiceClient.listLocationsPagedCallable().futureCall(request);
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
   * try (VpcFlowLogsServiceClient vpcFlowLogsServiceClient = VpcFlowLogsServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         vpcFlowLogsServiceClient.listLocationsCallable().call(request);
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
   * try (VpcFlowLogsServiceClient vpcFlowLogsServiceClient = VpcFlowLogsServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = vpcFlowLogsServiceClient.getLocation(request);
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
   * try (VpcFlowLogsServiceClient vpcFlowLogsServiceClient = VpcFlowLogsServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future =
   *       vpcFlowLogsServiceClient.getLocationCallable().futureCall(request);
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
   * try (VpcFlowLogsServiceClient vpcFlowLogsServiceClient = VpcFlowLogsServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(ConnectivityTestName.of("[PROJECT]", "[TEST]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = vpcFlowLogsServiceClient.setIamPolicy(request);
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
   * try (VpcFlowLogsServiceClient vpcFlowLogsServiceClient = VpcFlowLogsServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(ConnectivityTestName.of("[PROJECT]", "[TEST]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       vpcFlowLogsServiceClient.setIamPolicyCallable().futureCall(request);
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
   * try (VpcFlowLogsServiceClient vpcFlowLogsServiceClient = VpcFlowLogsServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(ConnectivityTestName.of("[PROJECT]", "[TEST]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = vpcFlowLogsServiceClient.getIamPolicy(request);
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
   * try (VpcFlowLogsServiceClient vpcFlowLogsServiceClient = VpcFlowLogsServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(ConnectivityTestName.of("[PROJECT]", "[TEST]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       vpcFlowLogsServiceClient.getIamPolicyCallable().futureCall(request);
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
   * try (VpcFlowLogsServiceClient vpcFlowLogsServiceClient = VpcFlowLogsServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(ConnectivityTestName.of("[PROJECT]", "[TEST]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = vpcFlowLogsServiceClient.testIamPermissions(request);
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
   * try (VpcFlowLogsServiceClient vpcFlowLogsServiceClient = VpcFlowLogsServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(ConnectivityTestName.of("[PROJECT]", "[TEST]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       vpcFlowLogsServiceClient.testIamPermissionsCallable().futureCall(request);
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

  public static class ListVpcFlowLogsConfigsPagedResponse
      extends AbstractPagedListResponse<
          ListVpcFlowLogsConfigsRequest,
          ListVpcFlowLogsConfigsResponse,
          VpcFlowLogsConfig,
          ListVpcFlowLogsConfigsPage,
          ListVpcFlowLogsConfigsFixedSizeCollection> {

    public static ApiFuture<ListVpcFlowLogsConfigsPagedResponse> createAsync(
        PageContext<
                ListVpcFlowLogsConfigsRequest, ListVpcFlowLogsConfigsResponse, VpcFlowLogsConfig>
            context,
        ApiFuture<ListVpcFlowLogsConfigsResponse> futureResponse) {
      ApiFuture<ListVpcFlowLogsConfigsPage> futurePage =
          ListVpcFlowLogsConfigsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListVpcFlowLogsConfigsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListVpcFlowLogsConfigsPagedResponse(ListVpcFlowLogsConfigsPage page) {
      super(page, ListVpcFlowLogsConfigsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListVpcFlowLogsConfigsPage
      extends AbstractPage<
          ListVpcFlowLogsConfigsRequest,
          ListVpcFlowLogsConfigsResponse,
          VpcFlowLogsConfig,
          ListVpcFlowLogsConfigsPage> {

    private ListVpcFlowLogsConfigsPage(
        PageContext<
                ListVpcFlowLogsConfigsRequest, ListVpcFlowLogsConfigsResponse, VpcFlowLogsConfig>
            context,
        ListVpcFlowLogsConfigsResponse response) {
      super(context, response);
    }

    private static ListVpcFlowLogsConfigsPage createEmptyPage() {
      return new ListVpcFlowLogsConfigsPage(null, null);
    }

    @Override
    protected ListVpcFlowLogsConfigsPage createPage(
        PageContext<
                ListVpcFlowLogsConfigsRequest, ListVpcFlowLogsConfigsResponse, VpcFlowLogsConfig>
            context,
        ListVpcFlowLogsConfigsResponse response) {
      return new ListVpcFlowLogsConfigsPage(context, response);
    }

    @Override
    public ApiFuture<ListVpcFlowLogsConfigsPage> createPageAsync(
        PageContext<
                ListVpcFlowLogsConfigsRequest, ListVpcFlowLogsConfigsResponse, VpcFlowLogsConfig>
            context,
        ApiFuture<ListVpcFlowLogsConfigsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListVpcFlowLogsConfigsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListVpcFlowLogsConfigsRequest,
          ListVpcFlowLogsConfigsResponse,
          VpcFlowLogsConfig,
          ListVpcFlowLogsConfigsPage,
          ListVpcFlowLogsConfigsFixedSizeCollection> {

    private ListVpcFlowLogsConfigsFixedSizeCollection(
        List<ListVpcFlowLogsConfigsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListVpcFlowLogsConfigsFixedSizeCollection createEmptyCollection() {
      return new ListVpcFlowLogsConfigsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListVpcFlowLogsConfigsFixedSizeCollection createCollection(
        List<ListVpcFlowLogsConfigsPage> pages, int collectionSize) {
      return new ListVpcFlowLogsConfigsFixedSizeCollection(pages, collectionSize);
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
