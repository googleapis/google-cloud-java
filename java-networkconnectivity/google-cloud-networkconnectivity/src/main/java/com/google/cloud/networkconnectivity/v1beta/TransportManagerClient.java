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

package com.google.cloud.networkconnectivity.v1beta;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
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
import com.google.cloud.networkconnectivity.v1beta.stub.TransportManagerStub;
import com.google.cloud.networkconnectivity.v1beta.stub.TransportManagerStubSettings;
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
 * Service Description: The CLH based service for managing RemoteTransportProfiles and Transports.
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
 * try (TransportManagerClient transportManagerClient = TransportManagerClient.create()) {
 *   RemoteTransportProfileName name =
 *       RemoteTransportProfileName.of("[PROJECT]", "[LOCATION]", "[REMOTE_TRANSPORT_PROFILE]");
 *   RemoteTransportProfile response = transportManagerClient.getRemoteTransportProfile(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the TransportManagerClient object to clean up resources
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
 *      <td><p> ListRemoteTransportProfiles</td>
 *      <td><p> Lists RemoteTransportProfiles in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listRemoteTransportProfiles(ListRemoteTransportProfilesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listRemoteTransportProfiles(LocationName parent)
 *           <li><p> listRemoteTransportProfiles(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listRemoteTransportProfilesPagedCallable()
 *           <li><p> listRemoteTransportProfilesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetRemoteTransportProfile</td>
 *      <td><p> Gets details of a single RemoteTransportProfile.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getRemoteTransportProfile(GetRemoteTransportProfileRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getRemoteTransportProfile(RemoteTransportProfileName name)
 *           <li><p> getRemoteTransportProfile(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getRemoteTransportProfileCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListTransports</td>
 *      <td><p> Lists Transports in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listTransports(ListTransportsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listTransports(LocationName parent)
 *           <li><p> listTransports(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listTransportsPagedCallable()
 *           <li><p> listTransportsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetTransport</td>
 *      <td><p> Gets details of a single Transport.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getTransport(GetTransportRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getTransport(TransportName name)
 *           <li><p> getTransport(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getTransportCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetStatus</td>
 *      <td><p> Gets the operational status of a single Transport.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getStatus(GetStatusRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getStatus(TransportName name)
 *           <li><p> getStatus(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getStatusCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateTransport</td>
 *      <td><p> Creates a new Transport in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createTransportAsync(CreateTransportRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createTransportAsync(LocationName parent, Transport transport, String transportId)
 *           <li><p> createTransportAsync(String parent, Transport transport, String transportId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createTransportOperationCallable()
 *           <li><p> createTransportCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateTransport</td>
 *      <td><p> Updates the parameters of a single Transport.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateTransportAsync(UpdateTransportRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateTransportAsync(Transport transport, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateTransportOperationCallable()
 *           <li><p> updateTransportCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteTransport</td>
 *      <td><p> Deletes a single Transport.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteTransportAsync(DeleteTransportRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteTransportAsync(TransportName name)
 *           <li><p> deleteTransportAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteTransportOperationCallable()
 *           <li><p> deleteTransportCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListLocations</td>
 *      <td><p> Lists information about the supported locations for this service.This method can be called in two ways:
 * <p> &#42;   &#42;&#42;List all public locations:&#42;&#42; Use the path `GET /v1/locations`.&#42;   &#42;&#42;List project-visible locations:&#42;&#42; Use the path`GET /v1/projects/{project_id}/locations`. This may include publiclocations as well as private or other locations specifically visibleto the project.</td>
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
 * <p>This class can be customized by passing in a custom instance of TransportManagerSettings to
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
 * TransportManagerSettings transportManagerSettings =
 *     TransportManagerSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * TransportManagerClient transportManagerClient =
 *     TransportManagerClient.create(transportManagerSettings);
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
 * TransportManagerSettings transportManagerSettings =
 *     TransportManagerSettings.newBuilder().setEndpoint(myEndpoint).build();
 * TransportManagerClient transportManagerClient =
 *     TransportManagerClient.create(transportManagerSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class TransportManagerClient implements BackgroundResource {
  private final TransportManagerSettings settings;
  private final TransportManagerStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of TransportManagerClient with default settings. */
  public static final TransportManagerClient create() throws IOException {
    return create(TransportManagerSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of TransportManagerClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final TransportManagerClient create(TransportManagerSettings settings)
      throws IOException {
    return new TransportManagerClient(settings);
  }

  /**
   * Constructs an instance of TransportManagerClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(TransportManagerSettings).
   */
  public static final TransportManagerClient create(TransportManagerStub stub) {
    return new TransportManagerClient(stub);
  }

  /**
   * Constructs an instance of TransportManagerClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected TransportManagerClient(TransportManagerSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((TransportManagerStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  protected TransportManagerClient(TransportManagerStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final TransportManagerSettings getSettings() {
    return settings;
  }

  public TransportManagerStub getStub() {
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
   * Lists RemoteTransportProfiles in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TransportManagerClient transportManagerClient = TransportManagerClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (RemoteTransportProfile element :
   *       transportManagerClient.listRemoteTransportProfiles(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListRemoteTransportProfilesRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRemoteTransportProfilesPagedResponse listRemoteTransportProfiles(
      LocationName parent) {
    ListRemoteTransportProfilesRequest request =
        ListRemoteTransportProfilesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listRemoteTransportProfiles(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists RemoteTransportProfiles in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TransportManagerClient transportManagerClient = TransportManagerClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (RemoteTransportProfile element :
   *       transportManagerClient.listRemoteTransportProfiles(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListRemoteTransportProfilesRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRemoteTransportProfilesPagedResponse listRemoteTransportProfiles(String parent) {
    ListRemoteTransportProfilesRequest request =
        ListRemoteTransportProfilesRequest.newBuilder().setParent(parent).build();
    return listRemoteTransportProfiles(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists RemoteTransportProfiles in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TransportManagerClient transportManagerClient = TransportManagerClient.create()) {
   *   ListRemoteTransportProfilesRequest request =
   *       ListRemoteTransportProfilesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (RemoteTransportProfile element :
   *       transportManagerClient.listRemoteTransportProfiles(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRemoteTransportProfilesPagedResponse listRemoteTransportProfiles(
      ListRemoteTransportProfilesRequest request) {
    return listRemoteTransportProfilesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists RemoteTransportProfiles in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TransportManagerClient transportManagerClient = TransportManagerClient.create()) {
   *   ListRemoteTransportProfilesRequest request =
   *       ListRemoteTransportProfilesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<RemoteTransportProfile> future =
   *       transportManagerClient.listRemoteTransportProfilesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (RemoteTransportProfile element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListRemoteTransportProfilesRequest, ListRemoteTransportProfilesPagedResponse>
      listRemoteTransportProfilesPagedCallable() {
    return stub.listRemoteTransportProfilesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists RemoteTransportProfiles in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TransportManagerClient transportManagerClient = TransportManagerClient.create()) {
   *   ListRemoteTransportProfilesRequest request =
   *       ListRemoteTransportProfilesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListRemoteTransportProfilesResponse response =
   *         transportManagerClient.listRemoteTransportProfilesCallable().call(request);
   *     for (RemoteTransportProfile element : response.getRemoteTransportProfilesList()) {
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
          ListRemoteTransportProfilesRequest, ListRemoteTransportProfilesResponse>
      listRemoteTransportProfilesCallable() {
    return stub.listRemoteTransportProfilesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single RemoteTransportProfile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TransportManagerClient transportManagerClient = TransportManagerClient.create()) {
   *   RemoteTransportProfileName name =
   *       RemoteTransportProfileName.of("[PROJECT]", "[LOCATION]", "[REMOTE_TRANSPORT_PROFILE]");
   *   RemoteTransportProfile response = transportManagerClient.getRemoteTransportProfile(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RemoteTransportProfile getRemoteTransportProfile(RemoteTransportProfileName name) {
    GetRemoteTransportProfileRequest request =
        GetRemoteTransportProfileRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getRemoteTransportProfile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single RemoteTransportProfile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TransportManagerClient transportManagerClient = TransportManagerClient.create()) {
   *   String name =
   *       RemoteTransportProfileName.of("[PROJECT]", "[LOCATION]", "[REMOTE_TRANSPORT_PROFILE]")
   *           .toString();
   *   RemoteTransportProfile response = transportManagerClient.getRemoteTransportProfile(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RemoteTransportProfile getRemoteTransportProfile(String name) {
    GetRemoteTransportProfileRequest request =
        GetRemoteTransportProfileRequest.newBuilder().setName(name).build();
    return getRemoteTransportProfile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single RemoteTransportProfile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TransportManagerClient transportManagerClient = TransportManagerClient.create()) {
   *   GetRemoteTransportProfileRequest request =
   *       GetRemoteTransportProfileRequest.newBuilder()
   *           .setName(
   *               RemoteTransportProfileName.of(
   *                       "[PROJECT]", "[LOCATION]", "[REMOTE_TRANSPORT_PROFILE]")
   *                   .toString())
   *           .build();
   *   RemoteTransportProfile response = transportManagerClient.getRemoteTransportProfile(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RemoteTransportProfile getRemoteTransportProfile(
      GetRemoteTransportProfileRequest request) {
    return getRemoteTransportProfileCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single RemoteTransportProfile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TransportManagerClient transportManagerClient = TransportManagerClient.create()) {
   *   GetRemoteTransportProfileRequest request =
   *       GetRemoteTransportProfileRequest.newBuilder()
   *           .setName(
   *               RemoteTransportProfileName.of(
   *                       "[PROJECT]", "[LOCATION]", "[REMOTE_TRANSPORT_PROFILE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<RemoteTransportProfile> future =
   *       transportManagerClient.getRemoteTransportProfileCallable().futureCall(request);
   *   // Do something.
   *   RemoteTransportProfile response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRemoteTransportProfileRequest, RemoteTransportProfile>
      getRemoteTransportProfileCallable() {
    return stub.getRemoteTransportProfileCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Transports in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TransportManagerClient transportManagerClient = TransportManagerClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Transport element : transportManagerClient.listTransports(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListTransportsRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTransportsPagedResponse listTransports(LocationName parent) {
    ListTransportsRequest request =
        ListTransportsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listTransports(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Transports in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TransportManagerClient transportManagerClient = TransportManagerClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Transport element : transportManagerClient.listTransports(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListTransportsRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTransportsPagedResponse listTransports(String parent) {
    ListTransportsRequest request = ListTransportsRequest.newBuilder().setParent(parent).build();
    return listTransports(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Transports in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TransportManagerClient transportManagerClient = TransportManagerClient.create()) {
   *   ListTransportsRequest request =
   *       ListTransportsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Transport element : transportManagerClient.listTransports(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTransportsPagedResponse listTransports(ListTransportsRequest request) {
    return listTransportsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Transports in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TransportManagerClient transportManagerClient = TransportManagerClient.create()) {
   *   ListTransportsRequest request =
   *       ListTransportsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Transport> future =
   *       transportManagerClient.listTransportsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Transport element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListTransportsRequest, ListTransportsPagedResponse>
      listTransportsPagedCallable() {
    return stub.listTransportsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Transports in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TransportManagerClient transportManagerClient = TransportManagerClient.create()) {
   *   ListTransportsRequest request =
   *       ListTransportsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListTransportsResponse response =
   *         transportManagerClient.listTransportsCallable().call(request);
   *     for (Transport element : response.getTransportsList()) {
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
  public final UnaryCallable<ListTransportsRequest, ListTransportsResponse>
      listTransportsCallable() {
    return stub.listTransportsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Transport.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TransportManagerClient transportManagerClient = TransportManagerClient.create()) {
   *   TransportName name = TransportName.of("[PROJECT]", "[LOCATION]", "[TRANSPORT]");
   *   Transport response = transportManagerClient.getTransport(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Transport getTransport(TransportName name) {
    GetTransportRequest request =
        GetTransportRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getTransport(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Transport.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TransportManagerClient transportManagerClient = TransportManagerClient.create()) {
   *   String name = TransportName.of("[PROJECT]", "[LOCATION]", "[TRANSPORT]").toString();
   *   Transport response = transportManagerClient.getTransport(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Transport getTransport(String name) {
    GetTransportRequest request = GetTransportRequest.newBuilder().setName(name).build();
    return getTransport(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Transport.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TransportManagerClient transportManagerClient = TransportManagerClient.create()) {
   *   GetTransportRequest request =
   *       GetTransportRequest.newBuilder()
   *           .setName(TransportName.of("[PROJECT]", "[LOCATION]", "[TRANSPORT]").toString())
   *           .build();
   *   Transport response = transportManagerClient.getTransport(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Transport getTransport(GetTransportRequest request) {
    return getTransportCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Transport.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TransportManagerClient transportManagerClient = TransportManagerClient.create()) {
   *   GetTransportRequest request =
   *       GetTransportRequest.newBuilder()
   *           .setName(TransportName.of("[PROJECT]", "[LOCATION]", "[TRANSPORT]").toString())
   *           .build();
   *   ApiFuture<Transport> future =
   *       transportManagerClient.getTransportCallable().futureCall(request);
   *   // Do something.
   *   Transport response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetTransportRequest, Transport> getTransportCallable() {
    return stub.getTransportCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the operational status of a single Transport.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TransportManagerClient transportManagerClient = TransportManagerClient.create()) {
   *   TransportName name = TransportName.of("[PROJECT]", "[LOCATION]", "[TRANSPORT]");
   *   GetStatusResponse response = transportManagerClient.getStatus(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GetStatusResponse getStatus(TransportName name) {
    GetStatusRequest request =
        GetStatusRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getStatus(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the operational status of a single Transport.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TransportManagerClient transportManagerClient = TransportManagerClient.create()) {
   *   String name = TransportName.of("[PROJECT]", "[LOCATION]", "[TRANSPORT]").toString();
   *   GetStatusResponse response = transportManagerClient.getStatus(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GetStatusResponse getStatus(String name) {
    GetStatusRequest request = GetStatusRequest.newBuilder().setName(name).build();
    return getStatus(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the operational status of a single Transport.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TransportManagerClient transportManagerClient = TransportManagerClient.create()) {
   *   GetStatusRequest request =
   *       GetStatusRequest.newBuilder()
   *           .setName(TransportName.of("[PROJECT]", "[LOCATION]", "[TRANSPORT]").toString())
   *           .build();
   *   GetStatusResponse response = transportManagerClient.getStatus(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GetStatusResponse getStatus(GetStatusRequest request) {
    return getStatusCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the operational status of a single Transport.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TransportManagerClient transportManagerClient = TransportManagerClient.create()) {
   *   GetStatusRequest request =
   *       GetStatusRequest.newBuilder()
   *           .setName(TransportName.of("[PROJECT]", "[LOCATION]", "[TRANSPORT]").toString())
   *           .build();
   *   ApiFuture<GetStatusResponse> future =
   *       transportManagerClient.getStatusCallable().futureCall(request);
   *   // Do something.
   *   GetStatusResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetStatusRequest, GetStatusResponse> getStatusCallable() {
    return stub.getStatusCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Transport in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TransportManagerClient transportManagerClient = TransportManagerClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Transport transport = Transport.newBuilder().build();
   *   String transportId = "transportId-1713251804";
   *   Transport response =
   *       transportManagerClient.createTransportAsync(parent, transport, transportId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param transport Required. The resource being created
   * @param transportId Required. Id of the requesting object
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Transport, OperationMetadata> createTransportAsync(
      LocationName parent, Transport transport, String transportId) {
    CreateTransportRequest request =
        CreateTransportRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setTransport(transport)
            .setTransportId(transportId)
            .build();
    return createTransportAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Transport in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TransportManagerClient transportManagerClient = TransportManagerClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Transport transport = Transport.newBuilder().build();
   *   String transportId = "transportId-1713251804";
   *   Transport response =
   *       transportManagerClient.createTransportAsync(parent, transport, transportId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param transport Required. The resource being created
   * @param transportId Required. Id of the requesting object
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Transport, OperationMetadata> createTransportAsync(
      String parent, Transport transport, String transportId) {
    CreateTransportRequest request =
        CreateTransportRequest.newBuilder()
            .setParent(parent)
            .setTransport(transport)
            .setTransportId(transportId)
            .build();
    return createTransportAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Transport in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TransportManagerClient transportManagerClient = TransportManagerClient.create()) {
   *   CreateTransportRequest request =
   *       CreateTransportRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setTransportId("transportId-1713251804")
   *           .setTransport(Transport.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Transport response = transportManagerClient.createTransportAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Transport, OperationMetadata> createTransportAsync(
      CreateTransportRequest request) {
    return createTransportOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Transport in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TransportManagerClient transportManagerClient = TransportManagerClient.create()) {
   *   CreateTransportRequest request =
   *       CreateTransportRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setTransportId("transportId-1713251804")
   *           .setTransport(Transport.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Transport, OperationMetadata> future =
   *       transportManagerClient.createTransportOperationCallable().futureCall(request);
   *   // Do something.
   *   Transport response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateTransportRequest, Transport, OperationMetadata>
      createTransportOperationCallable() {
    return stub.createTransportOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Transport in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TransportManagerClient transportManagerClient = TransportManagerClient.create()) {
   *   CreateTransportRequest request =
   *       CreateTransportRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setTransportId("transportId-1713251804")
   *           .setTransport(Transport.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       transportManagerClient.createTransportCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateTransportRequest, Operation> createTransportCallable() {
    return stub.createTransportCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Transport.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TransportManagerClient transportManagerClient = TransportManagerClient.create()) {
   *   Transport transport = Transport.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Transport response = transportManagerClient.updateTransportAsync(transport, updateMask).get();
   * }
   * }</pre>
   *
   * @param transport Required. The resource being updated.
   * @param updateMask Optional. Field mask is used to specify the fields to be overwritten in the
   *     Transport resource by the update. The fields specified in the update_mask are relative to
   *     the resource, not the full request. A field will be overwritten if it is in the mask. If
   *     the user does not provide a mask then all fields present in the request will be
   *     overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Transport, OperationMetadata> updateTransportAsync(
      Transport transport, FieldMask updateMask) {
    UpdateTransportRequest request =
        UpdateTransportRequest.newBuilder()
            .setTransport(transport)
            .setUpdateMask(updateMask)
            .build();
    return updateTransportAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Transport.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TransportManagerClient transportManagerClient = TransportManagerClient.create()) {
   *   UpdateTransportRequest request =
   *       UpdateTransportRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setTransport(Transport.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Transport response = transportManagerClient.updateTransportAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Transport, OperationMetadata> updateTransportAsync(
      UpdateTransportRequest request) {
    return updateTransportOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Transport.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TransportManagerClient transportManagerClient = TransportManagerClient.create()) {
   *   UpdateTransportRequest request =
   *       UpdateTransportRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setTransport(Transport.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Transport, OperationMetadata> future =
   *       transportManagerClient.updateTransportOperationCallable().futureCall(request);
   *   // Do something.
   *   Transport response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateTransportRequest, Transport, OperationMetadata>
      updateTransportOperationCallable() {
    return stub.updateTransportOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Transport.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TransportManagerClient transportManagerClient = TransportManagerClient.create()) {
   *   UpdateTransportRequest request =
   *       UpdateTransportRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setTransport(Transport.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       transportManagerClient.updateTransportCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateTransportRequest, Operation> updateTransportCallable() {
    return stub.updateTransportCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Transport.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TransportManagerClient transportManagerClient = TransportManagerClient.create()) {
   *   TransportName name = TransportName.of("[PROJECT]", "[LOCATION]", "[TRANSPORT]");
   *   transportManagerClient.deleteTransportAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteTransportAsync(TransportName name) {
    DeleteTransportRequest request =
        DeleteTransportRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteTransportAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Transport.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TransportManagerClient transportManagerClient = TransportManagerClient.create()) {
   *   String name = TransportName.of("[PROJECT]", "[LOCATION]", "[TRANSPORT]").toString();
   *   transportManagerClient.deleteTransportAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteTransportAsync(String name) {
    DeleteTransportRequest request = DeleteTransportRequest.newBuilder().setName(name).build();
    return deleteTransportAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Transport.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TransportManagerClient transportManagerClient = TransportManagerClient.create()) {
   *   DeleteTransportRequest request =
   *       DeleteTransportRequest.newBuilder()
   *           .setName(TransportName.of("[PROJECT]", "[LOCATION]", "[TRANSPORT]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   transportManagerClient.deleteTransportAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteTransportAsync(
      DeleteTransportRequest request) {
    return deleteTransportOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Transport.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TransportManagerClient transportManagerClient = TransportManagerClient.create()) {
   *   DeleteTransportRequest request =
   *       DeleteTransportRequest.newBuilder()
   *           .setName(TransportName.of("[PROJECT]", "[LOCATION]", "[TRANSPORT]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       transportManagerClient.deleteTransportOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteTransportRequest, Empty, OperationMetadata>
      deleteTransportOperationCallable() {
    return stub.deleteTransportOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Transport.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TransportManagerClient transportManagerClient = TransportManagerClient.create()) {
   *   DeleteTransportRequest request =
   *       DeleteTransportRequest.newBuilder()
   *           .setName(TransportName.of("[PROJECT]", "[LOCATION]", "[TRANSPORT]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       transportManagerClient.deleteTransportCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteTransportRequest, Operation> deleteTransportCallable() {
    return stub.deleteTransportCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.This method can be called in
   * two ways:
   *
   * <p>&#42; &#42;&#42;List all public locations:&#42;&#42; Use the path `GET /v1/locations`.&#42;
   * &#42;&#42;List project-visible locations:&#42;&#42; Use the path`GET
   * /v1/projects/{project_id}/locations`. This may include publiclocations as well as private or
   * other locations specifically visibleto the project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TransportManagerClient transportManagerClient = TransportManagerClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : transportManagerClient.listLocations(request).iterateAll()) {
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
   * Lists information about the supported locations for this service.This method can be called in
   * two ways:
   *
   * <p>&#42; &#42;&#42;List all public locations:&#42;&#42; Use the path `GET /v1/locations`.&#42;
   * &#42;&#42;List project-visible locations:&#42;&#42; Use the path`GET
   * /v1/projects/{project_id}/locations`. This may include publiclocations as well as private or
   * other locations specifically visibleto the project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TransportManagerClient transportManagerClient = TransportManagerClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       transportManagerClient.listLocationsPagedCallable().futureCall(request);
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
   * Lists information about the supported locations for this service.This method can be called in
   * two ways:
   *
   * <p>&#42; &#42;&#42;List all public locations:&#42;&#42; Use the path `GET /v1/locations`.&#42;
   * &#42;&#42;List project-visible locations:&#42;&#42; Use the path`GET
   * /v1/projects/{project_id}/locations`. This may include publiclocations as well as private or
   * other locations specifically visibleto the project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TransportManagerClient transportManagerClient = TransportManagerClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         transportManagerClient.listLocationsCallable().call(request);
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
   * try (TransportManagerClient transportManagerClient = TransportManagerClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = transportManagerClient.getLocation(request);
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
   * try (TransportManagerClient transportManagerClient = TransportManagerClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = transportManagerClient.getLocationCallable().futureCall(request);
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
   * try (TransportManagerClient transportManagerClient = TransportManagerClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(GroupName.of("[PROJECT]", "[HUB]", "[GROUP]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = transportManagerClient.setIamPolicy(request);
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
   * try (TransportManagerClient transportManagerClient = TransportManagerClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(GroupName.of("[PROJECT]", "[HUB]", "[GROUP]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = transportManagerClient.setIamPolicyCallable().futureCall(request);
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
   * try (TransportManagerClient transportManagerClient = TransportManagerClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(GroupName.of("[PROJECT]", "[HUB]", "[GROUP]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = transportManagerClient.getIamPolicy(request);
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
   * try (TransportManagerClient transportManagerClient = TransportManagerClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(GroupName.of("[PROJECT]", "[HUB]", "[GROUP]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = transportManagerClient.getIamPolicyCallable().futureCall(request);
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
   * try (TransportManagerClient transportManagerClient = TransportManagerClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(GroupName.of("[PROJECT]", "[HUB]", "[GROUP]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = transportManagerClient.testIamPermissions(request);
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
   * try (TransportManagerClient transportManagerClient = TransportManagerClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(GroupName.of("[PROJECT]", "[HUB]", "[GROUP]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       transportManagerClient.testIamPermissionsCallable().futureCall(request);
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

  public static class ListRemoteTransportProfilesPagedResponse
      extends AbstractPagedListResponse<
          ListRemoteTransportProfilesRequest,
          ListRemoteTransportProfilesResponse,
          RemoteTransportProfile,
          ListRemoteTransportProfilesPage,
          ListRemoteTransportProfilesFixedSizeCollection> {

    public static ApiFuture<ListRemoteTransportProfilesPagedResponse> createAsync(
        PageContext<
                ListRemoteTransportProfilesRequest,
                ListRemoteTransportProfilesResponse,
                RemoteTransportProfile>
            context,
        ApiFuture<ListRemoteTransportProfilesResponse> futureResponse) {
      ApiFuture<ListRemoteTransportProfilesPage> futurePage =
          ListRemoteTransportProfilesPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListRemoteTransportProfilesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListRemoteTransportProfilesPagedResponse(ListRemoteTransportProfilesPage page) {
      super(page, ListRemoteTransportProfilesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListRemoteTransportProfilesPage
      extends AbstractPage<
          ListRemoteTransportProfilesRequest,
          ListRemoteTransportProfilesResponse,
          RemoteTransportProfile,
          ListRemoteTransportProfilesPage> {

    private ListRemoteTransportProfilesPage(
        PageContext<
                ListRemoteTransportProfilesRequest,
                ListRemoteTransportProfilesResponse,
                RemoteTransportProfile>
            context,
        ListRemoteTransportProfilesResponse response) {
      super(context, response);
    }

    private static ListRemoteTransportProfilesPage createEmptyPage() {
      return new ListRemoteTransportProfilesPage(null, null);
    }

    @Override
    protected ListRemoteTransportProfilesPage createPage(
        PageContext<
                ListRemoteTransportProfilesRequest,
                ListRemoteTransportProfilesResponse,
                RemoteTransportProfile>
            context,
        ListRemoteTransportProfilesResponse response) {
      return new ListRemoteTransportProfilesPage(context, response);
    }

    @Override
    public ApiFuture<ListRemoteTransportProfilesPage> createPageAsync(
        PageContext<
                ListRemoteTransportProfilesRequest,
                ListRemoteTransportProfilesResponse,
                RemoteTransportProfile>
            context,
        ApiFuture<ListRemoteTransportProfilesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListRemoteTransportProfilesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRemoteTransportProfilesRequest,
          ListRemoteTransportProfilesResponse,
          RemoteTransportProfile,
          ListRemoteTransportProfilesPage,
          ListRemoteTransportProfilesFixedSizeCollection> {

    private ListRemoteTransportProfilesFixedSizeCollection(
        List<ListRemoteTransportProfilesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListRemoteTransportProfilesFixedSizeCollection createEmptyCollection() {
      return new ListRemoteTransportProfilesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListRemoteTransportProfilesFixedSizeCollection createCollection(
        List<ListRemoteTransportProfilesPage> pages, int collectionSize) {
      return new ListRemoteTransportProfilesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListTransportsPagedResponse
      extends AbstractPagedListResponse<
          ListTransportsRequest,
          ListTransportsResponse,
          Transport,
          ListTransportsPage,
          ListTransportsFixedSizeCollection> {

    public static ApiFuture<ListTransportsPagedResponse> createAsync(
        PageContext<ListTransportsRequest, ListTransportsResponse, Transport> context,
        ApiFuture<ListTransportsResponse> futureResponse) {
      ApiFuture<ListTransportsPage> futurePage =
          ListTransportsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListTransportsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListTransportsPagedResponse(ListTransportsPage page) {
      super(page, ListTransportsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListTransportsPage
      extends AbstractPage<
          ListTransportsRequest, ListTransportsResponse, Transport, ListTransportsPage> {

    private ListTransportsPage(
        PageContext<ListTransportsRequest, ListTransportsResponse, Transport> context,
        ListTransportsResponse response) {
      super(context, response);
    }

    private static ListTransportsPage createEmptyPage() {
      return new ListTransportsPage(null, null);
    }

    @Override
    protected ListTransportsPage createPage(
        PageContext<ListTransportsRequest, ListTransportsResponse, Transport> context,
        ListTransportsResponse response) {
      return new ListTransportsPage(context, response);
    }

    @Override
    public ApiFuture<ListTransportsPage> createPageAsync(
        PageContext<ListTransportsRequest, ListTransportsResponse, Transport> context,
        ApiFuture<ListTransportsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListTransportsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTransportsRequest,
          ListTransportsResponse,
          Transport,
          ListTransportsPage,
          ListTransportsFixedSizeCollection> {

    private ListTransportsFixedSizeCollection(List<ListTransportsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTransportsFixedSizeCollection createEmptyCollection() {
      return new ListTransportsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTransportsFixedSizeCollection createCollection(
        List<ListTransportsPage> pages, int collectionSize) {
      return new ListTransportsFixedSizeCollection(pages, collectionSize);
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
