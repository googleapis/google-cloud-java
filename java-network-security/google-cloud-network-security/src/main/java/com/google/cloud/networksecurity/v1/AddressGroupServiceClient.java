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
import com.google.cloud.networksecurity.v1.stub.AddressGroupServiceStub;
import com.google.cloud.networksecurity.v1.stub.AddressGroupServiceStubSettings;
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
 * Service Description: AddressGroup is a resource that manages a collection of IP or Domain Names,
 * it can be used in Firewall Policy to represent allow or deny traffic from all the IP or Domain
 * Names from the Address Group.
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
 * try (AddressGroupServiceClient addressGroupServiceClient = AddressGroupServiceClient.create()) {
 *   AddressGroupName name =
 *       AddressGroupName.ofProjectLocationAddressGroupName(
 *           "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]");
 *   AddressGroup response = addressGroupServiceClient.getAddressGroup(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the AddressGroupServiceClient object to clean up resources
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
 *      <td><p> ListAddressGroups</td>
 *      <td><p> Lists address groups in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAddressGroups(ListAddressGroupsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAddressGroups(LocationName parent)
 *           <li><p> listAddressGroups(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAddressGroupsPagedCallable()
 *           <li><p> listAddressGroupsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetAddressGroup</td>
 *      <td><p> Gets details of a single address group.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getAddressGroup(GetAddressGroupRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getAddressGroup(AddressGroupName name)
 *           <li><p> getAddressGroup(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getAddressGroupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateAddressGroup</td>
 *      <td><p> Creates a new address group in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createAddressGroupAsync(CreateAddressGroupRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createAddressGroupAsync(LocationName parent, AddressGroup addressGroup, String addressGroupId)
 *           <li><p> createAddressGroupAsync(OrganizationLocationName parent, AddressGroup addressGroup, String addressGroupId)
 *           <li><p> createAddressGroupAsync(String parent, AddressGroup addressGroup, String addressGroupId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createAddressGroupOperationCallable()
 *           <li><p> createAddressGroupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateAddressGroup</td>
 *      <td><p> Updates the parameters of a single address group.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateAddressGroupAsync(UpdateAddressGroupRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateAddressGroupAsync(AddressGroup addressGroup, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateAddressGroupOperationCallable()
 *           <li><p> updateAddressGroupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> AddAddressGroupItems</td>
 *      <td><p> Adds items to an address group.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> addAddressGroupItemsAsync(AddAddressGroupItemsRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> addAddressGroupItemsAsync(AddressGroupName addressGroup, List&lt;String&gt; items)
 *           <li><p> addAddressGroupItemsAsync(String addressGroup, List&lt;String&gt; items)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> addAddressGroupItemsOperationCallable()
 *           <li><p> addAddressGroupItemsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RemoveAddressGroupItems</td>
 *      <td><p> Removes items from an address group.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> removeAddressGroupItemsAsync(RemoveAddressGroupItemsRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> removeAddressGroupItemsAsync(AddressGroupName addressGroup, List&lt;String&gt; items)
 *           <li><p> removeAddressGroupItemsAsync(String addressGroup, List&lt;String&gt; items)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> removeAddressGroupItemsOperationCallable()
 *           <li><p> removeAddressGroupItemsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CloneAddressGroupItems</td>
 *      <td><p> Clones items from one address group to another.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> cloneAddressGroupItemsAsync(CloneAddressGroupItemsRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> cloneAddressGroupItemsAsync(AddressGroupName addressGroup, AddressGroupName sourceAddressGroup)
 *           <li><p> cloneAddressGroupItemsAsync(AddressGroupName addressGroup, String sourceAddressGroup)
 *           <li><p> cloneAddressGroupItemsAsync(String addressGroup, AddressGroupName sourceAddressGroup)
 *           <li><p> cloneAddressGroupItemsAsync(String addressGroup, String sourceAddressGroup)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> cloneAddressGroupItemsOperationCallable()
 *           <li><p> cloneAddressGroupItemsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteAddressGroup</td>
 *      <td><p> Deletes a single address group.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteAddressGroupAsync(DeleteAddressGroupRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteAddressGroupAsync(AddressGroupName name)
 *           <li><p> deleteAddressGroupAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteAddressGroupOperationCallable()
 *           <li><p> deleteAddressGroupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListAddressGroupReferences</td>
 *      <td><p> Lists references of an address group.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAddressGroupReferences(ListAddressGroupReferencesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAddressGroupReferences(AddressGroupName addressGroup)
 *           <li><p> listAddressGroupReferences(String addressGroup)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAddressGroupReferencesPagedCallable()
 *           <li><p> listAddressGroupReferencesCallable()
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
 * <p>This class can be customized by passing in a custom instance of AddressGroupServiceSettings to
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
 * AddressGroupServiceSettings addressGroupServiceSettings =
 *     AddressGroupServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * AddressGroupServiceClient addressGroupServiceClient =
 *     AddressGroupServiceClient.create(addressGroupServiceSettings);
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
 * AddressGroupServiceSettings addressGroupServiceSettings =
 *     AddressGroupServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * AddressGroupServiceClient addressGroupServiceClient =
 *     AddressGroupServiceClient.create(addressGroupServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class AddressGroupServiceClient implements BackgroundResource {
  private final AddressGroupServiceSettings settings;
  private final AddressGroupServiceStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of AddressGroupServiceClient with default settings. */
  public static final AddressGroupServiceClient create() throws IOException {
    return create(AddressGroupServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of AddressGroupServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final AddressGroupServiceClient create(AddressGroupServiceSettings settings)
      throws IOException {
    return new AddressGroupServiceClient(settings);
  }

  /**
   * Constructs an instance of AddressGroupServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(AddressGroupServiceSettings).
   */
  public static final AddressGroupServiceClient create(AddressGroupServiceStub stub) {
    return new AddressGroupServiceClient(stub);
  }

  /**
   * Constructs an instance of AddressGroupServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected AddressGroupServiceClient(AddressGroupServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((AddressGroupServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  protected AddressGroupServiceClient(AddressGroupServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final AddressGroupServiceSettings getSettings() {
    return settings;
  }

  public AddressGroupServiceStub getStub() {
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
   * Lists address groups in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AddressGroupServiceClient addressGroupServiceClient = AddressGroupServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (AddressGroup element :
   *       addressGroupServiceClient.listAddressGroups(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location from which the AddressGroups should be listed,
   *     specified in the format `projects/&#42;/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAddressGroupsPagedResponse listAddressGroups(LocationName parent) {
    ListAddressGroupsRequest request =
        ListAddressGroupsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAddressGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists address groups in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AddressGroupServiceClient addressGroupServiceClient = AddressGroupServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (AddressGroup element :
   *       addressGroupServiceClient.listAddressGroups(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location from which the AddressGroups should be listed,
   *     specified in the format `projects/&#42;/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAddressGroupsPagedResponse listAddressGroups(String parent) {
    ListAddressGroupsRequest request =
        ListAddressGroupsRequest.newBuilder().setParent(parent).build();
    return listAddressGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists address groups in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AddressGroupServiceClient addressGroupServiceClient = AddressGroupServiceClient.create()) {
   *   ListAddressGroupsRequest request =
   *       ListAddressGroupsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   for (AddressGroup element :
   *       addressGroupServiceClient.listAddressGroups(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAddressGroupsPagedResponse listAddressGroups(ListAddressGroupsRequest request) {
    return listAddressGroupsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists address groups in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AddressGroupServiceClient addressGroupServiceClient = AddressGroupServiceClient.create()) {
   *   ListAddressGroupsRequest request =
   *       ListAddressGroupsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<AddressGroup> future =
   *       addressGroupServiceClient.listAddressGroupsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (AddressGroup element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAddressGroupsRequest, ListAddressGroupsPagedResponse>
      listAddressGroupsPagedCallable() {
    return stub.listAddressGroupsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists address groups in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AddressGroupServiceClient addressGroupServiceClient = AddressGroupServiceClient.create()) {
   *   ListAddressGroupsRequest request =
   *       ListAddressGroupsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   while (true) {
   *     ListAddressGroupsResponse response =
   *         addressGroupServiceClient.listAddressGroupsCallable().call(request);
   *     for (AddressGroup element : response.getAddressGroupsList()) {
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
  public final UnaryCallable<ListAddressGroupsRequest, ListAddressGroupsResponse>
      listAddressGroupsCallable() {
    return stub.listAddressGroupsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single address group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AddressGroupServiceClient addressGroupServiceClient = AddressGroupServiceClient.create()) {
   *   AddressGroupName name =
   *       AddressGroupName.ofProjectLocationAddressGroupName(
   *           "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]");
   *   AddressGroup response = addressGroupServiceClient.getAddressGroup(name);
   * }
   * }</pre>
   *
   * @param name Required. A name of the AddressGroup to get. Must be in the format
   *     `projects/&#42;/locations/{location}/addressGroups/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AddressGroup getAddressGroup(AddressGroupName name) {
    GetAddressGroupRequest request =
        GetAddressGroupRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getAddressGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single address group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AddressGroupServiceClient addressGroupServiceClient = AddressGroupServiceClient.create()) {
   *   String name =
   *       AddressGroupName.ofProjectLocationAddressGroupName(
   *               "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
   *           .toString();
   *   AddressGroup response = addressGroupServiceClient.getAddressGroup(name);
   * }
   * }</pre>
   *
   * @param name Required. A name of the AddressGroup to get. Must be in the format
   *     `projects/&#42;/locations/{location}/addressGroups/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AddressGroup getAddressGroup(String name) {
    GetAddressGroupRequest request = GetAddressGroupRequest.newBuilder().setName(name).build();
    return getAddressGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single address group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AddressGroupServiceClient addressGroupServiceClient = AddressGroupServiceClient.create()) {
   *   GetAddressGroupRequest request =
   *       GetAddressGroupRequest.newBuilder()
   *           .setName(
   *               AddressGroupName.ofProjectLocationAddressGroupName(
   *                       "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
   *                   .toString())
   *           .build();
   *   AddressGroup response = addressGroupServiceClient.getAddressGroup(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AddressGroup getAddressGroup(GetAddressGroupRequest request) {
    return getAddressGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single address group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AddressGroupServiceClient addressGroupServiceClient = AddressGroupServiceClient.create()) {
   *   GetAddressGroupRequest request =
   *       GetAddressGroupRequest.newBuilder()
   *           .setName(
   *               AddressGroupName.ofProjectLocationAddressGroupName(
   *                       "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
   *                   .toString())
   *           .build();
   *   ApiFuture<AddressGroup> future =
   *       addressGroupServiceClient.getAddressGroupCallable().futureCall(request);
   *   // Do something.
   *   AddressGroup response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAddressGroupRequest, AddressGroup> getAddressGroupCallable() {
    return stub.getAddressGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new address group in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AddressGroupServiceClient addressGroupServiceClient = AddressGroupServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   AddressGroup addressGroup = AddressGroup.newBuilder().build();
   *   String addressGroupId = "addressGroupId705215846";
   *   AddressGroup response =
   *       addressGroupServiceClient
   *           .createAddressGroupAsync(parent, addressGroup, addressGroupId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the AddressGroup. Must be in the format
   *     `projects/&#42;/locations/{location}`.
   * @param addressGroup Required. AddressGroup resource to be created.
   * @param addressGroupId Required. Short name of the AddressGroup resource to be created. This
   *     value should be 1-63 characters long, containing only letters, numbers, hyphens, and
   *     underscores, and should not start with a number. E.g. "authz_policy".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AddressGroup, OperationMetadata> createAddressGroupAsync(
      LocationName parent, AddressGroup addressGroup, String addressGroupId) {
    CreateAddressGroupRequest request =
        CreateAddressGroupRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setAddressGroup(addressGroup)
            .setAddressGroupId(addressGroupId)
            .build();
    return createAddressGroupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new address group in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AddressGroupServiceClient addressGroupServiceClient = AddressGroupServiceClient.create()) {
   *   OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
   *   AddressGroup addressGroup = AddressGroup.newBuilder().build();
   *   String addressGroupId = "addressGroupId705215846";
   *   AddressGroup response =
   *       addressGroupServiceClient
   *           .createAddressGroupAsync(parent, addressGroup, addressGroupId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the AddressGroup. Must be in the format
   *     `projects/&#42;/locations/{location}`.
   * @param addressGroup Required. AddressGroup resource to be created.
   * @param addressGroupId Required. Short name of the AddressGroup resource to be created. This
   *     value should be 1-63 characters long, containing only letters, numbers, hyphens, and
   *     underscores, and should not start with a number. E.g. "authz_policy".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AddressGroup, OperationMetadata> createAddressGroupAsync(
      OrganizationLocationName parent, AddressGroup addressGroup, String addressGroupId) {
    CreateAddressGroupRequest request =
        CreateAddressGroupRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setAddressGroup(addressGroup)
            .setAddressGroupId(addressGroupId)
            .build();
    return createAddressGroupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new address group in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AddressGroupServiceClient addressGroupServiceClient = AddressGroupServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   AddressGroup addressGroup = AddressGroup.newBuilder().build();
   *   String addressGroupId = "addressGroupId705215846";
   *   AddressGroup response =
   *       addressGroupServiceClient
   *           .createAddressGroupAsync(parent, addressGroup, addressGroupId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the AddressGroup. Must be in the format
   *     `projects/&#42;/locations/{location}`.
   * @param addressGroup Required. AddressGroup resource to be created.
   * @param addressGroupId Required. Short name of the AddressGroup resource to be created. This
   *     value should be 1-63 characters long, containing only letters, numbers, hyphens, and
   *     underscores, and should not start with a number. E.g. "authz_policy".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AddressGroup, OperationMetadata> createAddressGroupAsync(
      String parent, AddressGroup addressGroup, String addressGroupId) {
    CreateAddressGroupRequest request =
        CreateAddressGroupRequest.newBuilder()
            .setParent(parent)
            .setAddressGroup(addressGroup)
            .setAddressGroupId(addressGroupId)
            .build();
    return createAddressGroupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new address group in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AddressGroupServiceClient addressGroupServiceClient = AddressGroupServiceClient.create()) {
   *   CreateAddressGroupRequest request =
   *       CreateAddressGroupRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setAddressGroupId("addressGroupId705215846")
   *           .setAddressGroup(AddressGroup.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   AddressGroup response = addressGroupServiceClient.createAddressGroupAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AddressGroup, OperationMetadata> createAddressGroupAsync(
      CreateAddressGroupRequest request) {
    return createAddressGroupOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new address group in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AddressGroupServiceClient addressGroupServiceClient = AddressGroupServiceClient.create()) {
   *   CreateAddressGroupRequest request =
   *       CreateAddressGroupRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setAddressGroupId("addressGroupId705215846")
   *           .setAddressGroup(AddressGroup.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<AddressGroup, OperationMetadata> future =
   *       addressGroupServiceClient.createAddressGroupOperationCallable().futureCall(request);
   *   // Do something.
   *   AddressGroup response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateAddressGroupRequest, AddressGroup, OperationMetadata>
      createAddressGroupOperationCallable() {
    return stub.createAddressGroupOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new address group in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AddressGroupServiceClient addressGroupServiceClient = AddressGroupServiceClient.create()) {
   *   CreateAddressGroupRequest request =
   *       CreateAddressGroupRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setAddressGroupId("addressGroupId705215846")
   *           .setAddressGroup(AddressGroup.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       addressGroupServiceClient.createAddressGroupCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateAddressGroupRequest, Operation> createAddressGroupCallable() {
    return stub.createAddressGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single address group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AddressGroupServiceClient addressGroupServiceClient = AddressGroupServiceClient.create()) {
   *   AddressGroup addressGroup = AddressGroup.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   AddressGroup response =
   *       addressGroupServiceClient.updateAddressGroupAsync(addressGroup, updateMask).get();
   * }
   * }</pre>
   *
   * @param addressGroup Required. Updated AddressGroup resource.
   * @param updateMask Optional. Field mask is used to specify the fields to be overwritten in the
   *     AddressGroup resource by the update. The fields specified in the update_mask are relative
   *     to the resource, not the full request. A field will be overwritten if it is in the mask. If
   *     the user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AddressGroup, OperationMetadata> updateAddressGroupAsync(
      AddressGroup addressGroup, FieldMask updateMask) {
    UpdateAddressGroupRequest request =
        UpdateAddressGroupRequest.newBuilder()
            .setAddressGroup(addressGroup)
            .setUpdateMask(updateMask)
            .build();
    return updateAddressGroupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single address group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AddressGroupServiceClient addressGroupServiceClient = AddressGroupServiceClient.create()) {
   *   UpdateAddressGroupRequest request =
   *       UpdateAddressGroupRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAddressGroup(AddressGroup.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   AddressGroup response = addressGroupServiceClient.updateAddressGroupAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AddressGroup, OperationMetadata> updateAddressGroupAsync(
      UpdateAddressGroupRequest request) {
    return updateAddressGroupOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single address group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AddressGroupServiceClient addressGroupServiceClient = AddressGroupServiceClient.create()) {
   *   UpdateAddressGroupRequest request =
   *       UpdateAddressGroupRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAddressGroup(AddressGroup.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<AddressGroup, OperationMetadata> future =
   *       addressGroupServiceClient.updateAddressGroupOperationCallable().futureCall(request);
   *   // Do something.
   *   AddressGroup response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateAddressGroupRequest, AddressGroup, OperationMetadata>
      updateAddressGroupOperationCallable() {
    return stub.updateAddressGroupOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single address group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AddressGroupServiceClient addressGroupServiceClient = AddressGroupServiceClient.create()) {
   *   UpdateAddressGroupRequest request =
   *       UpdateAddressGroupRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAddressGroup(AddressGroup.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       addressGroupServiceClient.updateAddressGroupCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateAddressGroupRequest, Operation> updateAddressGroupCallable() {
    return stub.updateAddressGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds items to an address group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AddressGroupServiceClient addressGroupServiceClient = AddressGroupServiceClient.create()) {
   *   AddressGroupName addressGroup =
   *       AddressGroupName.ofProjectLocationAddressGroupName(
   *           "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]");
   *   List<String> items = new ArrayList<>();
   *   AddressGroup response =
   *       addressGroupServiceClient.addAddressGroupItemsAsync(addressGroup, items).get();
   * }
   * }</pre>
   *
   * @param addressGroup Required. A name of the AddressGroup to add items to. Must be in the format
   *     `projects|organization/&#42;/locations/{location}/addressGroups/&#42;`.
   * @param items Required. List of items to add.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AddressGroup, OperationMetadata> addAddressGroupItemsAsync(
      AddressGroupName addressGroup, List<String> items) {
    AddAddressGroupItemsRequest request =
        AddAddressGroupItemsRequest.newBuilder()
            .setAddressGroup(addressGroup == null ? null : addressGroup.toString())
            .addAllItems(items)
            .build();
    return addAddressGroupItemsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds items to an address group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AddressGroupServiceClient addressGroupServiceClient = AddressGroupServiceClient.create()) {
   *   String addressGroup =
   *       AddressGroupName.ofProjectLocationAddressGroupName(
   *               "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
   *           .toString();
   *   List<String> items = new ArrayList<>();
   *   AddressGroup response =
   *       addressGroupServiceClient.addAddressGroupItemsAsync(addressGroup, items).get();
   * }
   * }</pre>
   *
   * @param addressGroup Required. A name of the AddressGroup to add items to. Must be in the format
   *     `projects|organization/&#42;/locations/{location}/addressGroups/&#42;`.
   * @param items Required. List of items to add.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AddressGroup, OperationMetadata> addAddressGroupItemsAsync(
      String addressGroup, List<String> items) {
    AddAddressGroupItemsRequest request =
        AddAddressGroupItemsRequest.newBuilder()
            .setAddressGroup(addressGroup)
            .addAllItems(items)
            .build();
    return addAddressGroupItemsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds items to an address group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AddressGroupServiceClient addressGroupServiceClient = AddressGroupServiceClient.create()) {
   *   AddAddressGroupItemsRequest request =
   *       AddAddressGroupItemsRequest.newBuilder()
   *           .setAddressGroup(
   *               AddressGroupName.ofProjectLocationAddressGroupName(
   *                       "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
   *                   .toString())
   *           .addAllItems(new ArrayList<String>())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   AddressGroup response = addressGroupServiceClient.addAddressGroupItemsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AddressGroup, OperationMetadata> addAddressGroupItemsAsync(
      AddAddressGroupItemsRequest request) {
    return addAddressGroupItemsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds items to an address group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AddressGroupServiceClient addressGroupServiceClient = AddressGroupServiceClient.create()) {
   *   AddAddressGroupItemsRequest request =
   *       AddAddressGroupItemsRequest.newBuilder()
   *           .setAddressGroup(
   *               AddressGroupName.ofProjectLocationAddressGroupName(
   *                       "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
   *                   .toString())
   *           .addAllItems(new ArrayList<String>())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<AddressGroup, OperationMetadata> future =
   *       addressGroupServiceClient.addAddressGroupItemsOperationCallable().futureCall(request);
   *   // Do something.
   *   AddressGroup response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<AddAddressGroupItemsRequest, AddressGroup, OperationMetadata>
      addAddressGroupItemsOperationCallable() {
    return stub.addAddressGroupItemsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds items to an address group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AddressGroupServiceClient addressGroupServiceClient = AddressGroupServiceClient.create()) {
   *   AddAddressGroupItemsRequest request =
   *       AddAddressGroupItemsRequest.newBuilder()
   *           .setAddressGroup(
   *               AddressGroupName.ofProjectLocationAddressGroupName(
   *                       "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
   *                   .toString())
   *           .addAllItems(new ArrayList<String>())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       addressGroupServiceClient.addAddressGroupItemsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AddAddressGroupItemsRequest, Operation>
      addAddressGroupItemsCallable() {
    return stub.addAddressGroupItemsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes items from an address group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AddressGroupServiceClient addressGroupServiceClient = AddressGroupServiceClient.create()) {
   *   AddressGroupName addressGroup =
   *       AddressGroupName.ofProjectLocationAddressGroupName(
   *           "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]");
   *   List<String> items = new ArrayList<>();
   *   AddressGroup response =
   *       addressGroupServiceClient.removeAddressGroupItemsAsync(addressGroup, items).get();
   * }
   * }</pre>
   *
   * @param addressGroup Required. A name of the AddressGroup to remove items from. Must be in the
   *     format `projects|organization/&#42;/locations/{location}/addressGroups/&#42;`.
   * @param items Required. List of items to remove.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AddressGroup, OperationMetadata> removeAddressGroupItemsAsync(
      AddressGroupName addressGroup, List<String> items) {
    RemoveAddressGroupItemsRequest request =
        RemoveAddressGroupItemsRequest.newBuilder()
            .setAddressGroup(addressGroup == null ? null : addressGroup.toString())
            .addAllItems(items)
            .build();
    return removeAddressGroupItemsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes items from an address group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AddressGroupServiceClient addressGroupServiceClient = AddressGroupServiceClient.create()) {
   *   String addressGroup =
   *       AddressGroupName.ofProjectLocationAddressGroupName(
   *               "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
   *           .toString();
   *   List<String> items = new ArrayList<>();
   *   AddressGroup response =
   *       addressGroupServiceClient.removeAddressGroupItemsAsync(addressGroup, items).get();
   * }
   * }</pre>
   *
   * @param addressGroup Required. A name of the AddressGroup to remove items from. Must be in the
   *     format `projects|organization/&#42;/locations/{location}/addressGroups/&#42;`.
   * @param items Required. List of items to remove.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AddressGroup, OperationMetadata> removeAddressGroupItemsAsync(
      String addressGroup, List<String> items) {
    RemoveAddressGroupItemsRequest request =
        RemoveAddressGroupItemsRequest.newBuilder()
            .setAddressGroup(addressGroup)
            .addAllItems(items)
            .build();
    return removeAddressGroupItemsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes items from an address group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AddressGroupServiceClient addressGroupServiceClient = AddressGroupServiceClient.create()) {
   *   RemoveAddressGroupItemsRequest request =
   *       RemoveAddressGroupItemsRequest.newBuilder()
   *           .setAddressGroup(
   *               AddressGroupName.ofProjectLocationAddressGroupName(
   *                       "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
   *                   .toString())
   *           .addAllItems(new ArrayList<String>())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   AddressGroup response = addressGroupServiceClient.removeAddressGroupItemsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AddressGroup, OperationMetadata> removeAddressGroupItemsAsync(
      RemoveAddressGroupItemsRequest request) {
    return removeAddressGroupItemsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes items from an address group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AddressGroupServiceClient addressGroupServiceClient = AddressGroupServiceClient.create()) {
   *   RemoveAddressGroupItemsRequest request =
   *       RemoveAddressGroupItemsRequest.newBuilder()
   *           .setAddressGroup(
   *               AddressGroupName.ofProjectLocationAddressGroupName(
   *                       "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
   *                   .toString())
   *           .addAllItems(new ArrayList<String>())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<AddressGroup, OperationMetadata> future =
   *       addressGroupServiceClient.removeAddressGroupItemsOperationCallable().futureCall(request);
   *   // Do something.
   *   AddressGroup response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<RemoveAddressGroupItemsRequest, AddressGroup, OperationMetadata>
      removeAddressGroupItemsOperationCallable() {
    return stub.removeAddressGroupItemsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes items from an address group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AddressGroupServiceClient addressGroupServiceClient = AddressGroupServiceClient.create()) {
   *   RemoveAddressGroupItemsRequest request =
   *       RemoveAddressGroupItemsRequest.newBuilder()
   *           .setAddressGroup(
   *               AddressGroupName.ofProjectLocationAddressGroupName(
   *                       "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
   *                   .toString())
   *           .addAllItems(new ArrayList<String>())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       addressGroupServiceClient.removeAddressGroupItemsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RemoveAddressGroupItemsRequest, Operation>
      removeAddressGroupItemsCallable() {
    return stub.removeAddressGroupItemsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Clones items from one address group to another.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AddressGroupServiceClient addressGroupServiceClient = AddressGroupServiceClient.create()) {
   *   AddressGroupName addressGroup =
   *       AddressGroupName.ofProjectLocationAddressGroupName(
   *           "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]");
   *   AddressGroupName sourceAddressGroup =
   *       AddressGroupName.ofProjectLocationAddressGroupName(
   *           "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]");
   *   AddressGroup response =
   *       addressGroupServiceClient
   *           .cloneAddressGroupItemsAsync(addressGroup, sourceAddressGroup)
   *           .get();
   * }
   * }</pre>
   *
   * @param addressGroup Required. A name of the AddressGroup to clone items to. Must be in the
   *     format `projects|organization/&#42;/locations/{location}/addressGroups/&#42;`.
   * @param sourceAddressGroup Required. Source address group to clone items from.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AddressGroup, OperationMetadata> cloneAddressGroupItemsAsync(
      AddressGroupName addressGroup, AddressGroupName sourceAddressGroup) {
    CloneAddressGroupItemsRequest request =
        CloneAddressGroupItemsRequest.newBuilder()
            .setAddressGroup(addressGroup == null ? null : addressGroup.toString())
            .setSourceAddressGroup(
                sourceAddressGroup == null ? null : sourceAddressGroup.toString())
            .build();
    return cloneAddressGroupItemsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Clones items from one address group to another.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AddressGroupServiceClient addressGroupServiceClient = AddressGroupServiceClient.create()) {
   *   AddressGroupName addressGroup =
   *       AddressGroupName.ofProjectLocationAddressGroupName(
   *           "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]");
   *   String sourceAddressGroup =
   *       AddressGroupName.ofProjectLocationAddressGroupName(
   *               "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
   *           .toString();
   *   AddressGroup response =
   *       addressGroupServiceClient
   *           .cloneAddressGroupItemsAsync(addressGroup, sourceAddressGroup)
   *           .get();
   * }
   * }</pre>
   *
   * @param addressGroup Required. A name of the AddressGroup to clone items to. Must be in the
   *     format `projects|organization/&#42;/locations/{location}/addressGroups/&#42;`.
   * @param sourceAddressGroup Required. Source address group to clone items from.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AddressGroup, OperationMetadata> cloneAddressGroupItemsAsync(
      AddressGroupName addressGroup, String sourceAddressGroup) {
    CloneAddressGroupItemsRequest request =
        CloneAddressGroupItemsRequest.newBuilder()
            .setAddressGroup(addressGroup == null ? null : addressGroup.toString())
            .setSourceAddressGroup(sourceAddressGroup)
            .build();
    return cloneAddressGroupItemsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Clones items from one address group to another.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AddressGroupServiceClient addressGroupServiceClient = AddressGroupServiceClient.create()) {
   *   String addressGroup =
   *       AddressGroupName.ofProjectLocationAddressGroupName(
   *               "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
   *           .toString();
   *   AddressGroupName sourceAddressGroup =
   *       AddressGroupName.ofProjectLocationAddressGroupName(
   *           "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]");
   *   AddressGroup response =
   *       addressGroupServiceClient
   *           .cloneAddressGroupItemsAsync(addressGroup, sourceAddressGroup)
   *           .get();
   * }
   * }</pre>
   *
   * @param addressGroup Required. A name of the AddressGroup to clone items to. Must be in the
   *     format `projects|organization/&#42;/locations/{location}/addressGroups/&#42;`.
   * @param sourceAddressGroup Required. Source address group to clone items from.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AddressGroup, OperationMetadata> cloneAddressGroupItemsAsync(
      String addressGroup, AddressGroupName sourceAddressGroup) {
    CloneAddressGroupItemsRequest request =
        CloneAddressGroupItemsRequest.newBuilder()
            .setAddressGroup(addressGroup)
            .setSourceAddressGroup(
                sourceAddressGroup == null ? null : sourceAddressGroup.toString())
            .build();
    return cloneAddressGroupItemsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Clones items from one address group to another.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AddressGroupServiceClient addressGroupServiceClient = AddressGroupServiceClient.create()) {
   *   String addressGroup =
   *       AddressGroupName.ofProjectLocationAddressGroupName(
   *               "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
   *           .toString();
   *   String sourceAddressGroup =
   *       AddressGroupName.ofProjectLocationAddressGroupName(
   *               "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
   *           .toString();
   *   AddressGroup response =
   *       addressGroupServiceClient
   *           .cloneAddressGroupItemsAsync(addressGroup, sourceAddressGroup)
   *           .get();
   * }
   * }</pre>
   *
   * @param addressGroup Required. A name of the AddressGroup to clone items to. Must be in the
   *     format `projects|organization/&#42;/locations/{location}/addressGroups/&#42;`.
   * @param sourceAddressGroup Required. Source address group to clone items from.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AddressGroup, OperationMetadata> cloneAddressGroupItemsAsync(
      String addressGroup, String sourceAddressGroup) {
    CloneAddressGroupItemsRequest request =
        CloneAddressGroupItemsRequest.newBuilder()
            .setAddressGroup(addressGroup)
            .setSourceAddressGroup(sourceAddressGroup)
            .build();
    return cloneAddressGroupItemsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Clones items from one address group to another.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AddressGroupServiceClient addressGroupServiceClient = AddressGroupServiceClient.create()) {
   *   CloneAddressGroupItemsRequest request =
   *       CloneAddressGroupItemsRequest.newBuilder()
   *           .setAddressGroup(
   *               AddressGroupName.ofProjectLocationAddressGroupName(
   *                       "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
   *                   .toString())
   *           .setSourceAddressGroup(
   *               AddressGroupName.ofProjectLocationAddressGroupName(
   *                       "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   AddressGroup response = addressGroupServiceClient.cloneAddressGroupItemsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AddressGroup, OperationMetadata> cloneAddressGroupItemsAsync(
      CloneAddressGroupItemsRequest request) {
    return cloneAddressGroupItemsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Clones items from one address group to another.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AddressGroupServiceClient addressGroupServiceClient = AddressGroupServiceClient.create()) {
   *   CloneAddressGroupItemsRequest request =
   *       CloneAddressGroupItemsRequest.newBuilder()
   *           .setAddressGroup(
   *               AddressGroupName.ofProjectLocationAddressGroupName(
   *                       "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
   *                   .toString())
   *           .setSourceAddressGroup(
   *               AddressGroupName.ofProjectLocationAddressGroupName(
   *                       "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<AddressGroup, OperationMetadata> future =
   *       addressGroupServiceClient.cloneAddressGroupItemsOperationCallable().futureCall(request);
   *   // Do something.
   *   AddressGroup response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CloneAddressGroupItemsRequest, AddressGroup, OperationMetadata>
      cloneAddressGroupItemsOperationCallable() {
    return stub.cloneAddressGroupItemsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Clones items from one address group to another.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AddressGroupServiceClient addressGroupServiceClient = AddressGroupServiceClient.create()) {
   *   CloneAddressGroupItemsRequest request =
   *       CloneAddressGroupItemsRequest.newBuilder()
   *           .setAddressGroup(
   *               AddressGroupName.ofProjectLocationAddressGroupName(
   *                       "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
   *                   .toString())
   *           .setSourceAddressGroup(
   *               AddressGroupName.ofProjectLocationAddressGroupName(
   *                       "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       addressGroupServiceClient.cloneAddressGroupItemsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CloneAddressGroupItemsRequest, Operation>
      cloneAddressGroupItemsCallable() {
    return stub.cloneAddressGroupItemsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single address group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AddressGroupServiceClient addressGroupServiceClient = AddressGroupServiceClient.create()) {
   *   AddressGroupName name =
   *       AddressGroupName.ofProjectLocationAddressGroupName(
   *           "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]");
   *   addressGroupServiceClient.deleteAddressGroupAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. A name of the AddressGroup to delete. Must be in the format
   *     `projects/&#42;/locations/{location}/addressGroups/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteAddressGroupAsync(
      AddressGroupName name) {
    DeleteAddressGroupRequest request =
        DeleteAddressGroupRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteAddressGroupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single address group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AddressGroupServiceClient addressGroupServiceClient = AddressGroupServiceClient.create()) {
   *   String name =
   *       AddressGroupName.ofProjectLocationAddressGroupName(
   *               "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
   *           .toString();
   *   addressGroupServiceClient.deleteAddressGroupAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. A name of the AddressGroup to delete. Must be in the format
   *     `projects/&#42;/locations/{location}/addressGroups/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteAddressGroupAsync(String name) {
    DeleteAddressGroupRequest request =
        DeleteAddressGroupRequest.newBuilder().setName(name).build();
    return deleteAddressGroupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single address group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AddressGroupServiceClient addressGroupServiceClient = AddressGroupServiceClient.create()) {
   *   DeleteAddressGroupRequest request =
   *       DeleteAddressGroupRequest.newBuilder()
   *           .setName(
   *               AddressGroupName.ofProjectLocationAddressGroupName(
   *                       "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   addressGroupServiceClient.deleteAddressGroupAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteAddressGroupAsync(
      DeleteAddressGroupRequest request) {
    return deleteAddressGroupOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single address group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AddressGroupServiceClient addressGroupServiceClient = AddressGroupServiceClient.create()) {
   *   DeleteAddressGroupRequest request =
   *       DeleteAddressGroupRequest.newBuilder()
   *           .setName(
   *               AddressGroupName.ofProjectLocationAddressGroupName(
   *                       "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       addressGroupServiceClient.deleteAddressGroupOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteAddressGroupRequest, Empty, OperationMetadata>
      deleteAddressGroupOperationCallable() {
    return stub.deleteAddressGroupOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single address group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AddressGroupServiceClient addressGroupServiceClient = AddressGroupServiceClient.create()) {
   *   DeleteAddressGroupRequest request =
   *       DeleteAddressGroupRequest.newBuilder()
   *           .setName(
   *               AddressGroupName.ofProjectLocationAddressGroupName(
   *                       "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       addressGroupServiceClient.deleteAddressGroupCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteAddressGroupRequest, Operation> deleteAddressGroupCallable() {
    return stub.deleteAddressGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists references of an address group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AddressGroupServiceClient addressGroupServiceClient = AddressGroupServiceClient.create()) {
   *   AddressGroupName addressGroup =
   *       AddressGroupName.ofProjectLocationAddressGroupName(
   *           "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]");
   *   for (ListAddressGroupReferencesResponse.AddressGroupReference element :
   *       addressGroupServiceClient.listAddressGroupReferences(addressGroup).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param addressGroup Required. A name of the AddressGroup to clone items to. Must be in the
   *     format `projects|organization/&#42;/locations/{location}/addressGroups/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAddressGroupReferencesPagedResponse listAddressGroupReferences(
      AddressGroupName addressGroup) {
    ListAddressGroupReferencesRequest request =
        ListAddressGroupReferencesRequest.newBuilder()
            .setAddressGroup(addressGroup == null ? null : addressGroup.toString())
            .build();
    return listAddressGroupReferences(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists references of an address group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AddressGroupServiceClient addressGroupServiceClient = AddressGroupServiceClient.create()) {
   *   String addressGroup =
   *       AddressGroupName.ofProjectLocationAddressGroupName(
   *               "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
   *           .toString();
   *   for (ListAddressGroupReferencesResponse.AddressGroupReference element :
   *       addressGroupServiceClient.listAddressGroupReferences(addressGroup).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param addressGroup Required. A name of the AddressGroup to clone items to. Must be in the
   *     format `projects|organization/&#42;/locations/{location}/addressGroups/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAddressGroupReferencesPagedResponse listAddressGroupReferences(
      String addressGroup) {
    ListAddressGroupReferencesRequest request =
        ListAddressGroupReferencesRequest.newBuilder().setAddressGroup(addressGroup).build();
    return listAddressGroupReferences(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists references of an address group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AddressGroupServiceClient addressGroupServiceClient = AddressGroupServiceClient.create()) {
   *   ListAddressGroupReferencesRequest request =
   *       ListAddressGroupReferencesRequest.newBuilder()
   *           .setAddressGroup(
   *               AddressGroupName.ofProjectLocationAddressGroupName(
   *                       "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (ListAddressGroupReferencesResponse.AddressGroupReference element :
   *       addressGroupServiceClient.listAddressGroupReferences(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAddressGroupReferencesPagedResponse listAddressGroupReferences(
      ListAddressGroupReferencesRequest request) {
    return listAddressGroupReferencesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists references of an address group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AddressGroupServiceClient addressGroupServiceClient = AddressGroupServiceClient.create()) {
   *   ListAddressGroupReferencesRequest request =
   *       ListAddressGroupReferencesRequest.newBuilder()
   *           .setAddressGroup(
   *               AddressGroupName.ofProjectLocationAddressGroupName(
   *                       "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<ListAddressGroupReferencesResponse.AddressGroupReference> future =
   *       addressGroupServiceClient.listAddressGroupReferencesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ListAddressGroupReferencesResponse.AddressGroupReference element :
   *       future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListAddressGroupReferencesRequest, ListAddressGroupReferencesPagedResponse>
      listAddressGroupReferencesPagedCallable() {
    return stub.listAddressGroupReferencesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists references of an address group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AddressGroupServiceClient addressGroupServiceClient = AddressGroupServiceClient.create()) {
   *   ListAddressGroupReferencesRequest request =
   *       ListAddressGroupReferencesRequest.newBuilder()
   *           .setAddressGroup(
   *               AddressGroupName.ofProjectLocationAddressGroupName(
   *                       "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListAddressGroupReferencesResponse response =
   *         addressGroupServiceClient.listAddressGroupReferencesCallable().call(request);
   *     for (ListAddressGroupReferencesResponse.AddressGroupReference element :
   *         response.getAddressGroupReferencesList()) {
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
  public final UnaryCallable<ListAddressGroupReferencesRequest, ListAddressGroupReferencesResponse>
      listAddressGroupReferencesCallable() {
    return stub.listAddressGroupReferencesCallable();
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
   * try (AddressGroupServiceClient addressGroupServiceClient = AddressGroupServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : addressGroupServiceClient.listLocations(request).iterateAll()) {
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
   * try (AddressGroupServiceClient addressGroupServiceClient = AddressGroupServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       addressGroupServiceClient.listLocationsPagedCallable().futureCall(request);
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
   * try (AddressGroupServiceClient addressGroupServiceClient = AddressGroupServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         addressGroupServiceClient.listLocationsCallable().call(request);
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
   * try (AddressGroupServiceClient addressGroupServiceClient = AddressGroupServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = addressGroupServiceClient.getLocation(request);
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
   * try (AddressGroupServiceClient addressGroupServiceClient = AddressGroupServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future =
   *       addressGroupServiceClient.getLocationCallable().futureCall(request);
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
   * try (AddressGroupServiceClient addressGroupServiceClient = AddressGroupServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AddressGroupName.ofProjectLocationAddressGroupName(
   *                       "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = addressGroupServiceClient.setIamPolicy(request);
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
   * try (AddressGroupServiceClient addressGroupServiceClient = AddressGroupServiceClient.create()) {
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
   *       addressGroupServiceClient.setIamPolicyCallable().futureCall(request);
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
   * try (AddressGroupServiceClient addressGroupServiceClient = AddressGroupServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AddressGroupName.ofProjectLocationAddressGroupName(
   *                       "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = addressGroupServiceClient.getIamPolicy(request);
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
   * try (AddressGroupServiceClient addressGroupServiceClient = AddressGroupServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AddressGroupName.ofProjectLocationAddressGroupName(
   *                       "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       addressGroupServiceClient.getIamPolicyCallable().futureCall(request);
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
   * try (AddressGroupServiceClient addressGroupServiceClient = AddressGroupServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               AddressGroupName.ofProjectLocationAddressGroupName(
   *                       "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = addressGroupServiceClient.testIamPermissions(request);
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
   * try (AddressGroupServiceClient addressGroupServiceClient = AddressGroupServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               AddressGroupName.ofProjectLocationAddressGroupName(
   *                       "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       addressGroupServiceClient.testIamPermissionsCallable().futureCall(request);
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

  public static class ListAddressGroupsPagedResponse
      extends AbstractPagedListResponse<
          ListAddressGroupsRequest,
          ListAddressGroupsResponse,
          AddressGroup,
          ListAddressGroupsPage,
          ListAddressGroupsFixedSizeCollection> {

    public static ApiFuture<ListAddressGroupsPagedResponse> createAsync(
        PageContext<ListAddressGroupsRequest, ListAddressGroupsResponse, AddressGroup> context,
        ApiFuture<ListAddressGroupsResponse> futureResponse) {
      ApiFuture<ListAddressGroupsPage> futurePage =
          ListAddressGroupsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAddressGroupsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAddressGroupsPagedResponse(ListAddressGroupsPage page) {
      super(page, ListAddressGroupsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAddressGroupsPage
      extends AbstractPage<
          ListAddressGroupsRequest,
          ListAddressGroupsResponse,
          AddressGroup,
          ListAddressGroupsPage> {

    private ListAddressGroupsPage(
        PageContext<ListAddressGroupsRequest, ListAddressGroupsResponse, AddressGroup> context,
        ListAddressGroupsResponse response) {
      super(context, response);
    }

    private static ListAddressGroupsPage createEmptyPage() {
      return new ListAddressGroupsPage(null, null);
    }

    @Override
    protected ListAddressGroupsPage createPage(
        PageContext<ListAddressGroupsRequest, ListAddressGroupsResponse, AddressGroup> context,
        ListAddressGroupsResponse response) {
      return new ListAddressGroupsPage(context, response);
    }

    @Override
    public ApiFuture<ListAddressGroupsPage> createPageAsync(
        PageContext<ListAddressGroupsRequest, ListAddressGroupsResponse, AddressGroup> context,
        ApiFuture<ListAddressGroupsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAddressGroupsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAddressGroupsRequest,
          ListAddressGroupsResponse,
          AddressGroup,
          ListAddressGroupsPage,
          ListAddressGroupsFixedSizeCollection> {

    private ListAddressGroupsFixedSizeCollection(
        List<ListAddressGroupsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAddressGroupsFixedSizeCollection createEmptyCollection() {
      return new ListAddressGroupsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAddressGroupsFixedSizeCollection createCollection(
        List<ListAddressGroupsPage> pages, int collectionSize) {
      return new ListAddressGroupsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListAddressGroupReferencesPagedResponse
      extends AbstractPagedListResponse<
          ListAddressGroupReferencesRequest,
          ListAddressGroupReferencesResponse,
          ListAddressGroupReferencesResponse.AddressGroupReference,
          ListAddressGroupReferencesPage,
          ListAddressGroupReferencesFixedSizeCollection> {

    public static ApiFuture<ListAddressGroupReferencesPagedResponse> createAsync(
        PageContext<
                ListAddressGroupReferencesRequest,
                ListAddressGroupReferencesResponse,
                ListAddressGroupReferencesResponse.AddressGroupReference>
            context,
        ApiFuture<ListAddressGroupReferencesResponse> futureResponse) {
      ApiFuture<ListAddressGroupReferencesPage> futurePage =
          ListAddressGroupReferencesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAddressGroupReferencesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAddressGroupReferencesPagedResponse(ListAddressGroupReferencesPage page) {
      super(page, ListAddressGroupReferencesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAddressGroupReferencesPage
      extends AbstractPage<
          ListAddressGroupReferencesRequest,
          ListAddressGroupReferencesResponse,
          ListAddressGroupReferencesResponse.AddressGroupReference,
          ListAddressGroupReferencesPage> {

    private ListAddressGroupReferencesPage(
        PageContext<
                ListAddressGroupReferencesRequest,
                ListAddressGroupReferencesResponse,
                ListAddressGroupReferencesResponse.AddressGroupReference>
            context,
        ListAddressGroupReferencesResponse response) {
      super(context, response);
    }

    private static ListAddressGroupReferencesPage createEmptyPage() {
      return new ListAddressGroupReferencesPage(null, null);
    }

    @Override
    protected ListAddressGroupReferencesPage createPage(
        PageContext<
                ListAddressGroupReferencesRequest,
                ListAddressGroupReferencesResponse,
                ListAddressGroupReferencesResponse.AddressGroupReference>
            context,
        ListAddressGroupReferencesResponse response) {
      return new ListAddressGroupReferencesPage(context, response);
    }

    @Override
    public ApiFuture<ListAddressGroupReferencesPage> createPageAsync(
        PageContext<
                ListAddressGroupReferencesRequest,
                ListAddressGroupReferencesResponse,
                ListAddressGroupReferencesResponse.AddressGroupReference>
            context,
        ApiFuture<ListAddressGroupReferencesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAddressGroupReferencesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAddressGroupReferencesRequest,
          ListAddressGroupReferencesResponse,
          ListAddressGroupReferencesResponse.AddressGroupReference,
          ListAddressGroupReferencesPage,
          ListAddressGroupReferencesFixedSizeCollection> {

    private ListAddressGroupReferencesFixedSizeCollection(
        List<ListAddressGroupReferencesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAddressGroupReferencesFixedSizeCollection createEmptyCollection() {
      return new ListAddressGroupReferencesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAddressGroupReferencesFixedSizeCollection createCollection(
        List<ListAddressGroupReferencesPage> pages, int collectionSize) {
      return new ListAddressGroupReferencesFixedSizeCollection(pages, collectionSize);
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
