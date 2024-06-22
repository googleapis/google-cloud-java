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

package com.google.cloud.networkservices.v1;

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
import com.google.cloud.networkservices.v1.stub.DepServiceStub;
import com.google.cloud.networkservices.v1.stub.DepServiceStubSettings;
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
 * try (DepServiceClient depServiceClient = DepServiceClient.create()) {
 *   LbTrafficExtensionName name =
 *       LbTrafficExtensionName.of("[PROJECT]", "[LOCATION]", "[LB_TRAFFIC_EXTENSION]");
 *   LbTrafficExtension response = depServiceClient.getLbTrafficExtension(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the DepServiceClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> ListLbTrafficExtensions</td>
 *      <td><p> Lists `LbTrafficExtension` resources in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listLbTrafficExtensions(ListLbTrafficExtensionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listLbTrafficExtensions(LocationName parent)
 *           <li><p> listLbTrafficExtensions(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listLbTrafficExtensionsPagedCallable()
 *           <li><p> listLbTrafficExtensionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetLbTrafficExtension</td>
 *      <td><p> Gets details of the specified `LbTrafficExtension` resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getLbTrafficExtension(GetLbTrafficExtensionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getLbTrafficExtension(LbTrafficExtensionName name)
 *           <li><p> getLbTrafficExtension(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getLbTrafficExtensionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateLbTrafficExtension</td>
 *      <td><p> Creates a new `LbTrafficExtension` resource in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createLbTrafficExtensionAsync(CreateLbTrafficExtensionRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createLbTrafficExtensionAsync(LocationName parent, LbTrafficExtension lbTrafficExtension, String lbTrafficExtensionId)
 *           <li><p> createLbTrafficExtensionAsync(String parent, LbTrafficExtension lbTrafficExtension, String lbTrafficExtensionId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createLbTrafficExtensionOperationCallable()
 *           <li><p> createLbTrafficExtensionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateLbTrafficExtension</td>
 *      <td><p> Updates the parameters of the specified `LbTrafficExtension` resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateLbTrafficExtensionAsync(UpdateLbTrafficExtensionRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateLbTrafficExtensionAsync(LbTrafficExtension lbTrafficExtension, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateLbTrafficExtensionOperationCallable()
 *           <li><p> updateLbTrafficExtensionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteLbTrafficExtension</td>
 *      <td><p> Deletes the specified `LbTrafficExtension` resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteLbTrafficExtensionAsync(DeleteLbTrafficExtensionRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteLbTrafficExtensionAsync(LbTrafficExtensionName name)
 *           <li><p> deleteLbTrafficExtensionAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteLbTrafficExtensionOperationCallable()
 *           <li><p> deleteLbTrafficExtensionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListLbRouteExtensions</td>
 *      <td><p> Lists `LbRouteExtension` resources in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listLbRouteExtensions(ListLbRouteExtensionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listLbRouteExtensions(LocationName parent)
 *           <li><p> listLbRouteExtensions(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listLbRouteExtensionsPagedCallable()
 *           <li><p> listLbRouteExtensionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetLbRouteExtension</td>
 *      <td><p> Gets details of the specified `LbRouteExtension` resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getLbRouteExtension(GetLbRouteExtensionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getLbRouteExtension(LbRouteExtensionName name)
 *           <li><p> getLbRouteExtension(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getLbRouteExtensionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateLbRouteExtension</td>
 *      <td><p> Creates a new `LbRouteExtension` resource in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createLbRouteExtensionAsync(CreateLbRouteExtensionRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createLbRouteExtensionAsync(LocationName parent, LbRouteExtension lbRouteExtension, String lbRouteExtensionId)
 *           <li><p> createLbRouteExtensionAsync(String parent, LbRouteExtension lbRouteExtension, String lbRouteExtensionId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createLbRouteExtensionOperationCallable()
 *           <li><p> createLbRouteExtensionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateLbRouteExtension</td>
 *      <td><p> Updates the parameters of the specified `LbRouteExtension` resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateLbRouteExtensionAsync(UpdateLbRouteExtensionRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateLbRouteExtensionAsync(LbRouteExtension lbRouteExtension, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateLbRouteExtensionOperationCallable()
 *           <li><p> updateLbRouteExtensionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteLbRouteExtension</td>
 *      <td><p> Deletes the specified `LbRouteExtension` resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteLbRouteExtensionAsync(DeleteLbRouteExtensionRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteLbRouteExtensionAsync(LbRouteExtensionName name)
 *           <li><p> deleteLbRouteExtensionAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteLbRouteExtensionOperationCallable()
 *           <li><p> deleteLbRouteExtensionCallable()
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
 * <p>This class can be customized by passing in a custom instance of DepServiceSettings to
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
 * DepServiceSettings depServiceSettings =
 *     DepServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DepServiceClient depServiceClient = DepServiceClient.create(depServiceSettings);
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
 * DepServiceSettings depServiceSettings =
 *     DepServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DepServiceClient depServiceClient = DepServiceClient.create(depServiceSettings);
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
 * DepServiceSettings depServiceSettings = DepServiceSettings.newHttpJsonBuilder().build();
 * DepServiceClient depServiceClient = DepServiceClient.create(depServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class DepServiceClient implements BackgroundResource {
  private final DepServiceSettings settings;
  private final DepServiceStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of DepServiceClient with default settings. */
  public static final DepServiceClient create() throws IOException {
    return create(DepServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of DepServiceClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final DepServiceClient create(DepServiceSettings settings) throws IOException {
    return new DepServiceClient(settings);
  }

  /**
   * Constructs an instance of DepServiceClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(DepServiceSettings).
   */
  public static final DepServiceClient create(DepServiceStub stub) {
    return new DepServiceClient(stub);
  }

  /**
   * Constructs an instance of DepServiceClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected DepServiceClient(DepServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((DepServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected DepServiceClient(DepServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final DepServiceSettings getSettings() {
    return settings;
  }

  public DepServiceStub getStub() {
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
   * Lists `LbTrafficExtension` resources in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DepServiceClient depServiceClient = DepServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (LbTrafficExtension element :
   *       depServiceClient.listLbTrafficExtensions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location from which the `LbTrafficExtension` resources
   *     are listed, specified in the following format: `projects/{project}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLbTrafficExtensionsPagedResponse listLbTrafficExtensions(LocationName parent) {
    ListLbTrafficExtensionsRequest request =
        ListLbTrafficExtensionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listLbTrafficExtensions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `LbTrafficExtension` resources in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DepServiceClient depServiceClient = DepServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (LbTrafficExtension element :
   *       depServiceClient.listLbTrafficExtensions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location from which the `LbTrafficExtension` resources
   *     are listed, specified in the following format: `projects/{project}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLbTrafficExtensionsPagedResponse listLbTrafficExtensions(String parent) {
    ListLbTrafficExtensionsRequest request =
        ListLbTrafficExtensionsRequest.newBuilder().setParent(parent).build();
    return listLbTrafficExtensions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `LbTrafficExtension` resources in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DepServiceClient depServiceClient = DepServiceClient.create()) {
   *   ListLbTrafficExtensionsRequest request =
   *       ListLbTrafficExtensionsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (LbTrafficExtension element :
   *       depServiceClient.listLbTrafficExtensions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLbTrafficExtensionsPagedResponse listLbTrafficExtensions(
      ListLbTrafficExtensionsRequest request) {
    return listLbTrafficExtensionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `LbTrafficExtension` resources in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DepServiceClient depServiceClient = DepServiceClient.create()) {
   *   ListLbTrafficExtensionsRequest request =
   *       ListLbTrafficExtensionsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<LbTrafficExtension> future =
   *       depServiceClient.listLbTrafficExtensionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (LbTrafficExtension element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListLbTrafficExtensionsRequest, ListLbTrafficExtensionsPagedResponse>
      listLbTrafficExtensionsPagedCallable() {
    return stub.listLbTrafficExtensionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `LbTrafficExtension` resources in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DepServiceClient depServiceClient = DepServiceClient.create()) {
   *   ListLbTrafficExtensionsRequest request =
   *       ListLbTrafficExtensionsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListLbTrafficExtensionsResponse response =
   *         depServiceClient.listLbTrafficExtensionsCallable().call(request);
   *     for (LbTrafficExtension element : response.getLbTrafficExtensionsList()) {
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
  public final UnaryCallable<ListLbTrafficExtensionsRequest, ListLbTrafficExtensionsResponse>
      listLbTrafficExtensionsCallable() {
    return stub.listLbTrafficExtensionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the specified `LbTrafficExtension` resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DepServiceClient depServiceClient = DepServiceClient.create()) {
   *   LbTrafficExtensionName name =
   *       LbTrafficExtensionName.of("[PROJECT]", "[LOCATION]", "[LB_TRAFFIC_EXTENSION]");
   *   LbTrafficExtension response = depServiceClient.getLbTrafficExtension(name);
   * }
   * }</pre>
   *
   * @param name Required. A name of the `LbTrafficExtension` resource to get. Must be in the format
   *     `projects/{project}/locations/{location}/lbTrafficExtensions/{lb_traffic_extension}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LbTrafficExtension getLbTrafficExtension(LbTrafficExtensionName name) {
    GetLbTrafficExtensionRequest request =
        GetLbTrafficExtensionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getLbTrafficExtension(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the specified `LbTrafficExtension` resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DepServiceClient depServiceClient = DepServiceClient.create()) {
   *   String name =
   *       LbTrafficExtensionName.of("[PROJECT]", "[LOCATION]", "[LB_TRAFFIC_EXTENSION]").toString();
   *   LbTrafficExtension response = depServiceClient.getLbTrafficExtension(name);
   * }
   * }</pre>
   *
   * @param name Required. A name of the `LbTrafficExtension` resource to get. Must be in the format
   *     `projects/{project}/locations/{location}/lbTrafficExtensions/{lb_traffic_extension}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LbTrafficExtension getLbTrafficExtension(String name) {
    GetLbTrafficExtensionRequest request =
        GetLbTrafficExtensionRequest.newBuilder().setName(name).build();
    return getLbTrafficExtension(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the specified `LbTrafficExtension` resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DepServiceClient depServiceClient = DepServiceClient.create()) {
   *   GetLbTrafficExtensionRequest request =
   *       GetLbTrafficExtensionRequest.newBuilder()
   *           .setName(
   *               LbTrafficExtensionName.of("[PROJECT]", "[LOCATION]", "[LB_TRAFFIC_EXTENSION]")
   *                   .toString())
   *           .build();
   *   LbTrafficExtension response = depServiceClient.getLbTrafficExtension(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LbTrafficExtension getLbTrafficExtension(GetLbTrafficExtensionRequest request) {
    return getLbTrafficExtensionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the specified `LbTrafficExtension` resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DepServiceClient depServiceClient = DepServiceClient.create()) {
   *   GetLbTrafficExtensionRequest request =
   *       GetLbTrafficExtensionRequest.newBuilder()
   *           .setName(
   *               LbTrafficExtensionName.of("[PROJECT]", "[LOCATION]", "[LB_TRAFFIC_EXTENSION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<LbTrafficExtension> future =
   *       depServiceClient.getLbTrafficExtensionCallable().futureCall(request);
   *   // Do something.
   *   LbTrafficExtension response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLbTrafficExtensionRequest, LbTrafficExtension>
      getLbTrafficExtensionCallable() {
    return stub.getLbTrafficExtensionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new `LbTrafficExtension` resource in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DepServiceClient depServiceClient = DepServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   LbTrafficExtension lbTrafficExtension = LbTrafficExtension.newBuilder().build();
   *   String lbTrafficExtensionId = "lbTrafficExtensionId1150549907";
   *   LbTrafficExtension response =
   *       depServiceClient
   *           .createLbTrafficExtensionAsync(parent, lbTrafficExtension, lbTrafficExtensionId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the `LbTrafficExtension` resource. Must be in
   *     the format `projects/{project}/locations/{location}`.
   * @param lbTrafficExtension Required. `LbTrafficExtension` resource to be created.
   * @param lbTrafficExtensionId Required. User-provided ID of the `LbTrafficExtension` resource to
   *     be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<LbTrafficExtension, OperationMetadata> createLbTrafficExtensionAsync(
      LocationName parent, LbTrafficExtension lbTrafficExtension, String lbTrafficExtensionId) {
    CreateLbTrafficExtensionRequest request =
        CreateLbTrafficExtensionRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setLbTrafficExtension(lbTrafficExtension)
            .setLbTrafficExtensionId(lbTrafficExtensionId)
            .build();
    return createLbTrafficExtensionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new `LbTrafficExtension` resource in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DepServiceClient depServiceClient = DepServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   LbTrafficExtension lbTrafficExtension = LbTrafficExtension.newBuilder().build();
   *   String lbTrafficExtensionId = "lbTrafficExtensionId1150549907";
   *   LbTrafficExtension response =
   *       depServiceClient
   *           .createLbTrafficExtensionAsync(parent, lbTrafficExtension, lbTrafficExtensionId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the `LbTrafficExtension` resource. Must be in
   *     the format `projects/{project}/locations/{location}`.
   * @param lbTrafficExtension Required. `LbTrafficExtension` resource to be created.
   * @param lbTrafficExtensionId Required. User-provided ID of the `LbTrafficExtension` resource to
   *     be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<LbTrafficExtension, OperationMetadata> createLbTrafficExtensionAsync(
      String parent, LbTrafficExtension lbTrafficExtension, String lbTrafficExtensionId) {
    CreateLbTrafficExtensionRequest request =
        CreateLbTrafficExtensionRequest.newBuilder()
            .setParent(parent)
            .setLbTrafficExtension(lbTrafficExtension)
            .setLbTrafficExtensionId(lbTrafficExtensionId)
            .build();
    return createLbTrafficExtensionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new `LbTrafficExtension` resource in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DepServiceClient depServiceClient = DepServiceClient.create()) {
   *   CreateLbTrafficExtensionRequest request =
   *       CreateLbTrafficExtensionRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setLbTrafficExtensionId("lbTrafficExtensionId1150549907")
   *           .setLbTrafficExtension(LbTrafficExtension.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   LbTrafficExtension response = depServiceClient.createLbTrafficExtensionAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<LbTrafficExtension, OperationMetadata> createLbTrafficExtensionAsync(
      CreateLbTrafficExtensionRequest request) {
    return createLbTrafficExtensionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new `LbTrafficExtension` resource in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DepServiceClient depServiceClient = DepServiceClient.create()) {
   *   CreateLbTrafficExtensionRequest request =
   *       CreateLbTrafficExtensionRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setLbTrafficExtensionId("lbTrafficExtensionId1150549907")
   *           .setLbTrafficExtension(LbTrafficExtension.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<LbTrafficExtension, OperationMetadata> future =
   *       depServiceClient.createLbTrafficExtensionOperationCallable().futureCall(request);
   *   // Do something.
   *   LbTrafficExtension response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateLbTrafficExtensionRequest, LbTrafficExtension, OperationMetadata>
      createLbTrafficExtensionOperationCallable() {
    return stub.createLbTrafficExtensionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new `LbTrafficExtension` resource in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DepServiceClient depServiceClient = DepServiceClient.create()) {
   *   CreateLbTrafficExtensionRequest request =
   *       CreateLbTrafficExtensionRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setLbTrafficExtensionId("lbTrafficExtensionId1150549907")
   *           .setLbTrafficExtension(LbTrafficExtension.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       depServiceClient.createLbTrafficExtensionCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateLbTrafficExtensionRequest, Operation>
      createLbTrafficExtensionCallable() {
    return stub.createLbTrafficExtensionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of the specified `LbTrafficExtension` resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DepServiceClient depServiceClient = DepServiceClient.create()) {
   *   LbTrafficExtension lbTrafficExtension = LbTrafficExtension.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   LbTrafficExtension response =
   *       depServiceClient.updateLbTrafficExtensionAsync(lbTrafficExtension, updateMask).get();
   * }
   * }</pre>
   *
   * @param lbTrafficExtension Required. `LbTrafficExtension` resource being updated.
   * @param updateMask Optional. Used to specify the fields to be overwritten in the
   *     `LbTrafficExtension` resource by the update. The fields specified in the update_mask are
   *     relative to the resource, not the full request. A field is overwritten if it is in the
   *     mask. If the user does not specify a mask, then all fields are overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<LbTrafficExtension, OperationMetadata> updateLbTrafficExtensionAsync(
      LbTrafficExtension lbTrafficExtension, FieldMask updateMask) {
    UpdateLbTrafficExtensionRequest request =
        UpdateLbTrafficExtensionRequest.newBuilder()
            .setLbTrafficExtension(lbTrafficExtension)
            .setUpdateMask(updateMask)
            .build();
    return updateLbTrafficExtensionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of the specified `LbTrafficExtension` resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DepServiceClient depServiceClient = DepServiceClient.create()) {
   *   UpdateLbTrafficExtensionRequest request =
   *       UpdateLbTrafficExtensionRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setLbTrafficExtension(LbTrafficExtension.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   LbTrafficExtension response = depServiceClient.updateLbTrafficExtensionAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<LbTrafficExtension, OperationMetadata> updateLbTrafficExtensionAsync(
      UpdateLbTrafficExtensionRequest request) {
    return updateLbTrafficExtensionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of the specified `LbTrafficExtension` resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DepServiceClient depServiceClient = DepServiceClient.create()) {
   *   UpdateLbTrafficExtensionRequest request =
   *       UpdateLbTrafficExtensionRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setLbTrafficExtension(LbTrafficExtension.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<LbTrafficExtension, OperationMetadata> future =
   *       depServiceClient.updateLbTrafficExtensionOperationCallable().futureCall(request);
   *   // Do something.
   *   LbTrafficExtension response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UpdateLbTrafficExtensionRequest, LbTrafficExtension, OperationMetadata>
      updateLbTrafficExtensionOperationCallable() {
    return stub.updateLbTrafficExtensionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of the specified `LbTrafficExtension` resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DepServiceClient depServiceClient = DepServiceClient.create()) {
   *   UpdateLbTrafficExtensionRequest request =
   *       UpdateLbTrafficExtensionRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setLbTrafficExtension(LbTrafficExtension.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       depServiceClient.updateLbTrafficExtensionCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateLbTrafficExtensionRequest, Operation>
      updateLbTrafficExtensionCallable() {
    return stub.updateLbTrafficExtensionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified `LbTrafficExtension` resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DepServiceClient depServiceClient = DepServiceClient.create()) {
   *   LbTrafficExtensionName name =
   *       LbTrafficExtensionName.of("[PROJECT]", "[LOCATION]", "[LB_TRAFFIC_EXTENSION]");
   *   depServiceClient.deleteLbTrafficExtensionAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the `LbTrafficExtension` resource to delete. Must be in the
   *     format
   *     `projects/{project}/locations/{location}/lbTrafficExtensions/{lb_traffic_extension}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteLbTrafficExtensionAsync(
      LbTrafficExtensionName name) {
    DeleteLbTrafficExtensionRequest request =
        DeleteLbTrafficExtensionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteLbTrafficExtensionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified `LbTrafficExtension` resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DepServiceClient depServiceClient = DepServiceClient.create()) {
   *   String name =
   *       LbTrafficExtensionName.of("[PROJECT]", "[LOCATION]", "[LB_TRAFFIC_EXTENSION]").toString();
   *   depServiceClient.deleteLbTrafficExtensionAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the `LbTrafficExtension` resource to delete. Must be in the
   *     format
   *     `projects/{project}/locations/{location}/lbTrafficExtensions/{lb_traffic_extension}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteLbTrafficExtensionAsync(
      String name) {
    DeleteLbTrafficExtensionRequest request =
        DeleteLbTrafficExtensionRequest.newBuilder().setName(name).build();
    return deleteLbTrafficExtensionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified `LbTrafficExtension` resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DepServiceClient depServiceClient = DepServiceClient.create()) {
   *   DeleteLbTrafficExtensionRequest request =
   *       DeleteLbTrafficExtensionRequest.newBuilder()
   *           .setName(
   *               LbTrafficExtensionName.of("[PROJECT]", "[LOCATION]", "[LB_TRAFFIC_EXTENSION]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   depServiceClient.deleteLbTrafficExtensionAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteLbTrafficExtensionAsync(
      DeleteLbTrafficExtensionRequest request) {
    return deleteLbTrafficExtensionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified `LbTrafficExtension` resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DepServiceClient depServiceClient = DepServiceClient.create()) {
   *   DeleteLbTrafficExtensionRequest request =
   *       DeleteLbTrafficExtensionRequest.newBuilder()
   *           .setName(
   *               LbTrafficExtensionName.of("[PROJECT]", "[LOCATION]", "[LB_TRAFFIC_EXTENSION]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       depServiceClient.deleteLbTrafficExtensionOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteLbTrafficExtensionRequest, Empty, OperationMetadata>
      deleteLbTrafficExtensionOperationCallable() {
    return stub.deleteLbTrafficExtensionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified `LbTrafficExtension` resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DepServiceClient depServiceClient = DepServiceClient.create()) {
   *   DeleteLbTrafficExtensionRequest request =
   *       DeleteLbTrafficExtensionRequest.newBuilder()
   *           .setName(
   *               LbTrafficExtensionName.of("[PROJECT]", "[LOCATION]", "[LB_TRAFFIC_EXTENSION]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       depServiceClient.deleteLbTrafficExtensionCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteLbTrafficExtensionRequest, Operation>
      deleteLbTrafficExtensionCallable() {
    return stub.deleteLbTrafficExtensionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `LbRouteExtension` resources in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DepServiceClient depServiceClient = DepServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (LbRouteExtension element : depServiceClient.listLbRouteExtensions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location from which the `LbRouteExtension` resources
   *     are listed, specified in the following format: `projects/{project}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLbRouteExtensionsPagedResponse listLbRouteExtensions(LocationName parent) {
    ListLbRouteExtensionsRequest request =
        ListLbRouteExtensionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listLbRouteExtensions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `LbRouteExtension` resources in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DepServiceClient depServiceClient = DepServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (LbRouteExtension element : depServiceClient.listLbRouteExtensions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location from which the `LbRouteExtension` resources
   *     are listed, specified in the following format: `projects/{project}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLbRouteExtensionsPagedResponse listLbRouteExtensions(String parent) {
    ListLbRouteExtensionsRequest request =
        ListLbRouteExtensionsRequest.newBuilder().setParent(parent).build();
    return listLbRouteExtensions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `LbRouteExtension` resources in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DepServiceClient depServiceClient = DepServiceClient.create()) {
   *   ListLbRouteExtensionsRequest request =
   *       ListLbRouteExtensionsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (LbRouteExtension element :
   *       depServiceClient.listLbRouteExtensions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLbRouteExtensionsPagedResponse listLbRouteExtensions(
      ListLbRouteExtensionsRequest request) {
    return listLbRouteExtensionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `LbRouteExtension` resources in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DepServiceClient depServiceClient = DepServiceClient.create()) {
   *   ListLbRouteExtensionsRequest request =
   *       ListLbRouteExtensionsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<LbRouteExtension> future =
   *       depServiceClient.listLbRouteExtensionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (LbRouteExtension element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListLbRouteExtensionsRequest, ListLbRouteExtensionsPagedResponse>
      listLbRouteExtensionsPagedCallable() {
    return stub.listLbRouteExtensionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `LbRouteExtension` resources in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DepServiceClient depServiceClient = DepServiceClient.create()) {
   *   ListLbRouteExtensionsRequest request =
   *       ListLbRouteExtensionsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListLbRouteExtensionsResponse response =
   *         depServiceClient.listLbRouteExtensionsCallable().call(request);
   *     for (LbRouteExtension element : response.getLbRouteExtensionsList()) {
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
  public final UnaryCallable<ListLbRouteExtensionsRequest, ListLbRouteExtensionsResponse>
      listLbRouteExtensionsCallable() {
    return stub.listLbRouteExtensionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the specified `LbRouteExtension` resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DepServiceClient depServiceClient = DepServiceClient.create()) {
   *   LbRouteExtensionName name =
   *       LbRouteExtensionName.of("[PROJECT]", "[LOCATION]", "[LB_ROUTE_EXTENSION]");
   *   LbRouteExtension response = depServiceClient.getLbRouteExtension(name);
   * }
   * }</pre>
   *
   * @param name Required. A name of the `LbRouteExtension` resource to get. Must be in the format
   *     `projects/{project}/locations/{location}/lbRouteExtensions/{lb_route_extension}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LbRouteExtension getLbRouteExtension(LbRouteExtensionName name) {
    GetLbRouteExtensionRequest request =
        GetLbRouteExtensionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getLbRouteExtension(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the specified `LbRouteExtension` resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DepServiceClient depServiceClient = DepServiceClient.create()) {
   *   String name =
   *       LbRouteExtensionName.of("[PROJECT]", "[LOCATION]", "[LB_ROUTE_EXTENSION]").toString();
   *   LbRouteExtension response = depServiceClient.getLbRouteExtension(name);
   * }
   * }</pre>
   *
   * @param name Required. A name of the `LbRouteExtension` resource to get. Must be in the format
   *     `projects/{project}/locations/{location}/lbRouteExtensions/{lb_route_extension}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LbRouteExtension getLbRouteExtension(String name) {
    GetLbRouteExtensionRequest request =
        GetLbRouteExtensionRequest.newBuilder().setName(name).build();
    return getLbRouteExtension(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the specified `LbRouteExtension` resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DepServiceClient depServiceClient = DepServiceClient.create()) {
   *   GetLbRouteExtensionRequest request =
   *       GetLbRouteExtensionRequest.newBuilder()
   *           .setName(
   *               LbRouteExtensionName.of("[PROJECT]", "[LOCATION]", "[LB_ROUTE_EXTENSION]")
   *                   .toString())
   *           .build();
   *   LbRouteExtension response = depServiceClient.getLbRouteExtension(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LbRouteExtension getLbRouteExtension(GetLbRouteExtensionRequest request) {
    return getLbRouteExtensionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the specified `LbRouteExtension` resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DepServiceClient depServiceClient = DepServiceClient.create()) {
   *   GetLbRouteExtensionRequest request =
   *       GetLbRouteExtensionRequest.newBuilder()
   *           .setName(
   *               LbRouteExtensionName.of("[PROJECT]", "[LOCATION]", "[LB_ROUTE_EXTENSION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<LbRouteExtension> future =
   *       depServiceClient.getLbRouteExtensionCallable().futureCall(request);
   *   // Do something.
   *   LbRouteExtension response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLbRouteExtensionRequest, LbRouteExtension>
      getLbRouteExtensionCallable() {
    return stub.getLbRouteExtensionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new `LbRouteExtension` resource in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DepServiceClient depServiceClient = DepServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   LbRouteExtension lbRouteExtension = LbRouteExtension.newBuilder().build();
   *   String lbRouteExtensionId = "lbRouteExtensionId-1336830649";
   *   LbRouteExtension response =
   *       depServiceClient
   *           .createLbRouteExtensionAsync(parent, lbRouteExtension, lbRouteExtensionId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the `LbRouteExtension` resource. Must be in the
   *     format `projects/{project}/locations/{location}`.
   * @param lbRouteExtension Required. `LbRouteExtension` resource to be created.
   * @param lbRouteExtensionId Required. User-provided ID of the `LbRouteExtension` resource to be
   *     created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<LbRouteExtension, OperationMetadata> createLbRouteExtensionAsync(
      LocationName parent, LbRouteExtension lbRouteExtension, String lbRouteExtensionId) {
    CreateLbRouteExtensionRequest request =
        CreateLbRouteExtensionRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setLbRouteExtension(lbRouteExtension)
            .setLbRouteExtensionId(lbRouteExtensionId)
            .build();
    return createLbRouteExtensionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new `LbRouteExtension` resource in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DepServiceClient depServiceClient = DepServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   LbRouteExtension lbRouteExtension = LbRouteExtension.newBuilder().build();
   *   String lbRouteExtensionId = "lbRouteExtensionId-1336830649";
   *   LbRouteExtension response =
   *       depServiceClient
   *           .createLbRouteExtensionAsync(parent, lbRouteExtension, lbRouteExtensionId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the `LbRouteExtension` resource. Must be in the
   *     format `projects/{project}/locations/{location}`.
   * @param lbRouteExtension Required. `LbRouteExtension` resource to be created.
   * @param lbRouteExtensionId Required. User-provided ID of the `LbRouteExtension` resource to be
   *     created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<LbRouteExtension, OperationMetadata> createLbRouteExtensionAsync(
      String parent, LbRouteExtension lbRouteExtension, String lbRouteExtensionId) {
    CreateLbRouteExtensionRequest request =
        CreateLbRouteExtensionRequest.newBuilder()
            .setParent(parent)
            .setLbRouteExtension(lbRouteExtension)
            .setLbRouteExtensionId(lbRouteExtensionId)
            .build();
    return createLbRouteExtensionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new `LbRouteExtension` resource in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DepServiceClient depServiceClient = DepServiceClient.create()) {
   *   CreateLbRouteExtensionRequest request =
   *       CreateLbRouteExtensionRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setLbRouteExtensionId("lbRouteExtensionId-1336830649")
   *           .setLbRouteExtension(LbRouteExtension.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   LbRouteExtension response = depServiceClient.createLbRouteExtensionAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<LbRouteExtension, OperationMetadata> createLbRouteExtensionAsync(
      CreateLbRouteExtensionRequest request) {
    return createLbRouteExtensionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new `LbRouteExtension` resource in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DepServiceClient depServiceClient = DepServiceClient.create()) {
   *   CreateLbRouteExtensionRequest request =
   *       CreateLbRouteExtensionRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setLbRouteExtensionId("lbRouteExtensionId-1336830649")
   *           .setLbRouteExtension(LbRouteExtension.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<LbRouteExtension, OperationMetadata> future =
   *       depServiceClient.createLbRouteExtensionOperationCallable().futureCall(request);
   *   // Do something.
   *   LbRouteExtension response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateLbRouteExtensionRequest, LbRouteExtension, OperationMetadata>
      createLbRouteExtensionOperationCallable() {
    return stub.createLbRouteExtensionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new `LbRouteExtension` resource in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DepServiceClient depServiceClient = DepServiceClient.create()) {
   *   CreateLbRouteExtensionRequest request =
   *       CreateLbRouteExtensionRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setLbRouteExtensionId("lbRouteExtensionId-1336830649")
   *           .setLbRouteExtension(LbRouteExtension.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       depServiceClient.createLbRouteExtensionCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateLbRouteExtensionRequest, Operation>
      createLbRouteExtensionCallable() {
    return stub.createLbRouteExtensionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of the specified `LbRouteExtension` resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DepServiceClient depServiceClient = DepServiceClient.create()) {
   *   LbRouteExtension lbRouteExtension = LbRouteExtension.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   LbRouteExtension response =
   *       depServiceClient.updateLbRouteExtensionAsync(lbRouteExtension, updateMask).get();
   * }
   * }</pre>
   *
   * @param lbRouteExtension Required. `LbRouteExtension` resource being updated.
   * @param updateMask Optional. Used to specify the fields to be overwritten in the
   *     `LbRouteExtension` resource by the update. The fields specified in the update_mask are
   *     relative to the resource, not the full request. A field is overwritten if it is in the
   *     mask. If the user does not specify a mask, then all fields are overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<LbRouteExtension, OperationMetadata> updateLbRouteExtensionAsync(
      LbRouteExtension lbRouteExtension, FieldMask updateMask) {
    UpdateLbRouteExtensionRequest request =
        UpdateLbRouteExtensionRequest.newBuilder()
            .setLbRouteExtension(lbRouteExtension)
            .setUpdateMask(updateMask)
            .build();
    return updateLbRouteExtensionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of the specified `LbRouteExtension` resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DepServiceClient depServiceClient = DepServiceClient.create()) {
   *   UpdateLbRouteExtensionRequest request =
   *       UpdateLbRouteExtensionRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setLbRouteExtension(LbRouteExtension.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   LbRouteExtension response = depServiceClient.updateLbRouteExtensionAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<LbRouteExtension, OperationMetadata> updateLbRouteExtensionAsync(
      UpdateLbRouteExtensionRequest request) {
    return updateLbRouteExtensionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of the specified `LbRouteExtension` resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DepServiceClient depServiceClient = DepServiceClient.create()) {
   *   UpdateLbRouteExtensionRequest request =
   *       UpdateLbRouteExtensionRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setLbRouteExtension(LbRouteExtension.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<LbRouteExtension, OperationMetadata> future =
   *       depServiceClient.updateLbRouteExtensionOperationCallable().futureCall(request);
   *   // Do something.
   *   LbRouteExtension response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateLbRouteExtensionRequest, LbRouteExtension, OperationMetadata>
      updateLbRouteExtensionOperationCallable() {
    return stub.updateLbRouteExtensionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of the specified `LbRouteExtension` resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DepServiceClient depServiceClient = DepServiceClient.create()) {
   *   UpdateLbRouteExtensionRequest request =
   *       UpdateLbRouteExtensionRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setLbRouteExtension(LbRouteExtension.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       depServiceClient.updateLbRouteExtensionCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateLbRouteExtensionRequest, Operation>
      updateLbRouteExtensionCallable() {
    return stub.updateLbRouteExtensionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified `LbRouteExtension` resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DepServiceClient depServiceClient = DepServiceClient.create()) {
   *   LbRouteExtensionName name =
   *       LbRouteExtensionName.of("[PROJECT]", "[LOCATION]", "[LB_ROUTE_EXTENSION]");
   *   depServiceClient.deleteLbRouteExtensionAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the `LbRouteExtension` resource to delete. Must be in the
   *     format `projects/{project}/locations/{location}/lbRouteExtensions/{lb_route_extension}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteLbRouteExtensionAsync(
      LbRouteExtensionName name) {
    DeleteLbRouteExtensionRequest request =
        DeleteLbRouteExtensionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteLbRouteExtensionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified `LbRouteExtension` resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DepServiceClient depServiceClient = DepServiceClient.create()) {
   *   String name =
   *       LbRouteExtensionName.of("[PROJECT]", "[LOCATION]", "[LB_ROUTE_EXTENSION]").toString();
   *   depServiceClient.deleteLbRouteExtensionAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the `LbRouteExtension` resource to delete. Must be in the
   *     format `projects/{project}/locations/{location}/lbRouteExtensions/{lb_route_extension}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteLbRouteExtensionAsync(String name) {
    DeleteLbRouteExtensionRequest request =
        DeleteLbRouteExtensionRequest.newBuilder().setName(name).build();
    return deleteLbRouteExtensionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified `LbRouteExtension` resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DepServiceClient depServiceClient = DepServiceClient.create()) {
   *   DeleteLbRouteExtensionRequest request =
   *       DeleteLbRouteExtensionRequest.newBuilder()
   *           .setName(
   *               LbRouteExtensionName.of("[PROJECT]", "[LOCATION]", "[LB_ROUTE_EXTENSION]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   depServiceClient.deleteLbRouteExtensionAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteLbRouteExtensionAsync(
      DeleteLbRouteExtensionRequest request) {
    return deleteLbRouteExtensionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified `LbRouteExtension` resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DepServiceClient depServiceClient = DepServiceClient.create()) {
   *   DeleteLbRouteExtensionRequest request =
   *       DeleteLbRouteExtensionRequest.newBuilder()
   *           .setName(
   *               LbRouteExtensionName.of("[PROJECT]", "[LOCATION]", "[LB_ROUTE_EXTENSION]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       depServiceClient.deleteLbRouteExtensionOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteLbRouteExtensionRequest, Empty, OperationMetadata>
      deleteLbRouteExtensionOperationCallable() {
    return stub.deleteLbRouteExtensionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified `LbRouteExtension` resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DepServiceClient depServiceClient = DepServiceClient.create()) {
   *   DeleteLbRouteExtensionRequest request =
   *       DeleteLbRouteExtensionRequest.newBuilder()
   *           .setName(
   *               LbRouteExtensionName.of("[PROJECT]", "[LOCATION]", "[LB_ROUTE_EXTENSION]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       depServiceClient.deleteLbRouteExtensionCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteLbRouteExtensionRequest, Operation>
      deleteLbRouteExtensionCallable() {
    return stub.deleteLbRouteExtensionCallable();
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
   * try (DepServiceClient depServiceClient = DepServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : depServiceClient.listLocations(request).iterateAll()) {
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
   * try (DepServiceClient depServiceClient = DepServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       depServiceClient.listLocationsPagedCallable().futureCall(request);
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
   * try (DepServiceClient depServiceClient = DepServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = depServiceClient.listLocationsCallable().call(request);
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
   * try (DepServiceClient depServiceClient = DepServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = depServiceClient.getLocation(request);
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
   * try (DepServiceClient depServiceClient = DepServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = depServiceClient.getLocationCallable().futureCall(request);
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
   * try (DepServiceClient depServiceClient = DepServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = depServiceClient.setIamPolicy(request);
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
   * try (DepServiceClient depServiceClient = DepServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = depServiceClient.setIamPolicyCallable().futureCall(request);
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
   * try (DepServiceClient depServiceClient = DepServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = depServiceClient.getIamPolicy(request);
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
   * try (DepServiceClient depServiceClient = DepServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = depServiceClient.getIamPolicyCallable().futureCall(request);
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
   * try (DepServiceClient depServiceClient = DepServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = depServiceClient.testIamPermissions(request);
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
   * try (DepServiceClient depServiceClient = DepServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       depServiceClient.testIamPermissionsCallable().futureCall(request);
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

  public static class ListLbTrafficExtensionsPagedResponse
      extends AbstractPagedListResponse<
          ListLbTrafficExtensionsRequest,
          ListLbTrafficExtensionsResponse,
          LbTrafficExtension,
          ListLbTrafficExtensionsPage,
          ListLbTrafficExtensionsFixedSizeCollection> {

    public static ApiFuture<ListLbTrafficExtensionsPagedResponse> createAsync(
        PageContext<
                ListLbTrafficExtensionsRequest, ListLbTrafficExtensionsResponse, LbTrafficExtension>
            context,
        ApiFuture<ListLbTrafficExtensionsResponse> futureResponse) {
      ApiFuture<ListLbTrafficExtensionsPage> futurePage =
          ListLbTrafficExtensionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListLbTrafficExtensionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListLbTrafficExtensionsPagedResponse(ListLbTrafficExtensionsPage page) {
      super(page, ListLbTrafficExtensionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListLbTrafficExtensionsPage
      extends AbstractPage<
          ListLbTrafficExtensionsRequest,
          ListLbTrafficExtensionsResponse,
          LbTrafficExtension,
          ListLbTrafficExtensionsPage> {

    private ListLbTrafficExtensionsPage(
        PageContext<
                ListLbTrafficExtensionsRequest, ListLbTrafficExtensionsResponse, LbTrafficExtension>
            context,
        ListLbTrafficExtensionsResponse response) {
      super(context, response);
    }

    private static ListLbTrafficExtensionsPage createEmptyPage() {
      return new ListLbTrafficExtensionsPage(null, null);
    }

    @Override
    protected ListLbTrafficExtensionsPage createPage(
        PageContext<
                ListLbTrafficExtensionsRequest, ListLbTrafficExtensionsResponse, LbTrafficExtension>
            context,
        ListLbTrafficExtensionsResponse response) {
      return new ListLbTrafficExtensionsPage(context, response);
    }

    @Override
    public ApiFuture<ListLbTrafficExtensionsPage> createPageAsync(
        PageContext<
                ListLbTrafficExtensionsRequest, ListLbTrafficExtensionsResponse, LbTrafficExtension>
            context,
        ApiFuture<ListLbTrafficExtensionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListLbTrafficExtensionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListLbTrafficExtensionsRequest,
          ListLbTrafficExtensionsResponse,
          LbTrafficExtension,
          ListLbTrafficExtensionsPage,
          ListLbTrafficExtensionsFixedSizeCollection> {

    private ListLbTrafficExtensionsFixedSizeCollection(
        List<ListLbTrafficExtensionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLbTrafficExtensionsFixedSizeCollection createEmptyCollection() {
      return new ListLbTrafficExtensionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLbTrafficExtensionsFixedSizeCollection createCollection(
        List<ListLbTrafficExtensionsPage> pages, int collectionSize) {
      return new ListLbTrafficExtensionsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListLbRouteExtensionsPagedResponse
      extends AbstractPagedListResponse<
          ListLbRouteExtensionsRequest,
          ListLbRouteExtensionsResponse,
          LbRouteExtension,
          ListLbRouteExtensionsPage,
          ListLbRouteExtensionsFixedSizeCollection> {

    public static ApiFuture<ListLbRouteExtensionsPagedResponse> createAsync(
        PageContext<ListLbRouteExtensionsRequest, ListLbRouteExtensionsResponse, LbRouteExtension>
            context,
        ApiFuture<ListLbRouteExtensionsResponse> futureResponse) {
      ApiFuture<ListLbRouteExtensionsPage> futurePage =
          ListLbRouteExtensionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListLbRouteExtensionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListLbRouteExtensionsPagedResponse(ListLbRouteExtensionsPage page) {
      super(page, ListLbRouteExtensionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListLbRouteExtensionsPage
      extends AbstractPage<
          ListLbRouteExtensionsRequest,
          ListLbRouteExtensionsResponse,
          LbRouteExtension,
          ListLbRouteExtensionsPage> {

    private ListLbRouteExtensionsPage(
        PageContext<ListLbRouteExtensionsRequest, ListLbRouteExtensionsResponse, LbRouteExtension>
            context,
        ListLbRouteExtensionsResponse response) {
      super(context, response);
    }

    private static ListLbRouteExtensionsPage createEmptyPage() {
      return new ListLbRouteExtensionsPage(null, null);
    }

    @Override
    protected ListLbRouteExtensionsPage createPage(
        PageContext<ListLbRouteExtensionsRequest, ListLbRouteExtensionsResponse, LbRouteExtension>
            context,
        ListLbRouteExtensionsResponse response) {
      return new ListLbRouteExtensionsPage(context, response);
    }

    @Override
    public ApiFuture<ListLbRouteExtensionsPage> createPageAsync(
        PageContext<ListLbRouteExtensionsRequest, ListLbRouteExtensionsResponse, LbRouteExtension>
            context,
        ApiFuture<ListLbRouteExtensionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListLbRouteExtensionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListLbRouteExtensionsRequest,
          ListLbRouteExtensionsResponse,
          LbRouteExtension,
          ListLbRouteExtensionsPage,
          ListLbRouteExtensionsFixedSizeCollection> {

    private ListLbRouteExtensionsFixedSizeCollection(
        List<ListLbRouteExtensionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLbRouteExtensionsFixedSizeCollection createEmptyCollection() {
      return new ListLbRouteExtensionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLbRouteExtensionsFixedSizeCollection createCollection(
        List<ListLbRouteExtensionsPage> pages, int collectionSize) {
      return new ListLbRouteExtensionsFixedSizeCollection(pages, collectionSize);
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
