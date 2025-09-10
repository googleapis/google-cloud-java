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

package com.google.cloud.networkconnectivity.v1;

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
import com.google.cloud.networkconnectivity.v1.stub.DataTransferServiceStub;
import com.google.cloud.networkconnectivity.v1.stub.DataTransferServiceStubSettings;
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
 * Service Description: DataTransferService is the service for the Data Transfer API.
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
 * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
 *   MulticloudDataTransferConfigName name =
 *       MulticloudDataTransferConfigName.of(
 *           "[PROJECT]", "[LOCATION]", "[MULTICLOUD_DATA_TRANSFER_CONFIG]");
 *   MulticloudDataTransferConfig response =
 *       dataTransferServiceClient.getMulticloudDataTransferConfig(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the DataTransferServiceClient object to clean up resources
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
 *      <td><p> ListMulticloudDataTransferConfigs</td>
 *      <td><p> Lists the `MulticloudDataTransferConfig` resources in a specified project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listMulticloudDataTransferConfigs(ListMulticloudDataTransferConfigsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listMulticloudDataTransferConfigs(LocationName parent)
 *           <li><p> listMulticloudDataTransferConfigs(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listMulticloudDataTransferConfigsPagedCallable()
 *           <li><p> listMulticloudDataTransferConfigsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetMulticloudDataTransferConfig</td>
 *      <td><p> Gets the details of a `MulticloudDataTransferConfig` resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getMulticloudDataTransferConfig(GetMulticloudDataTransferConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getMulticloudDataTransferConfig(MulticloudDataTransferConfigName name)
 *           <li><p> getMulticloudDataTransferConfig(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getMulticloudDataTransferConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateMulticloudDataTransferConfig</td>
 *      <td><p> Creates a `MulticloudDataTransferConfig` resource in a specified project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createMulticloudDataTransferConfigAsync(CreateMulticloudDataTransferConfigRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createMulticloudDataTransferConfigAsync(LocationName parent, MulticloudDataTransferConfig multicloudDataTransferConfig, String multicloudDataTransferConfigId)
 *           <li><p> createMulticloudDataTransferConfigAsync(String parent, MulticloudDataTransferConfig multicloudDataTransferConfig, String multicloudDataTransferConfigId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createMulticloudDataTransferConfigOperationCallable()
 *           <li><p> createMulticloudDataTransferConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateMulticloudDataTransferConfig</td>
 *      <td><p> Updates a `MulticloudDataTransferConfig` resource in a specified project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateMulticloudDataTransferConfigAsync(UpdateMulticloudDataTransferConfigRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateMulticloudDataTransferConfigAsync(MulticloudDataTransferConfig multicloudDataTransferConfig, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateMulticloudDataTransferConfigOperationCallable()
 *           <li><p> updateMulticloudDataTransferConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteMulticloudDataTransferConfig</td>
 *      <td><p> Deletes a `MulticloudDataTransferConfig` resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteMulticloudDataTransferConfigAsync(DeleteMulticloudDataTransferConfigRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteMulticloudDataTransferConfigAsync(MulticloudDataTransferConfigName name)
 *           <li><p> deleteMulticloudDataTransferConfigAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteMulticloudDataTransferConfigOperationCallable()
 *           <li><p> deleteMulticloudDataTransferConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListDestinations</td>
 *      <td><p> Lists the `Destination` resources in a specified project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listDestinations(ListDestinationsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listDestinations(MulticloudDataTransferConfigName parent)
 *           <li><p> listDestinations(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listDestinationsPagedCallable()
 *           <li><p> listDestinationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetDestination</td>
 *      <td><p> Gets the details of a `Destination` resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getDestination(GetDestinationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getDestination(DestinationName name)
 *           <li><p> getDestination(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getDestinationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateDestination</td>
 *      <td><p> Creates a `Destination` resource in a specified project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createDestinationAsync(CreateDestinationRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createDestinationAsync(MulticloudDataTransferConfigName parent, Destination destination, String destinationId)
 *           <li><p> createDestinationAsync(String parent, Destination destination, String destinationId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createDestinationOperationCallable()
 *           <li><p> createDestinationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateDestination</td>
 *      <td><p> Updates a `Destination` resource in a specified project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateDestinationAsync(UpdateDestinationRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateDestinationAsync(Destination destination, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateDestinationOperationCallable()
 *           <li><p> updateDestinationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteDestination</td>
 *      <td><p> Deletes a `Destination` resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteDestinationAsync(DeleteDestinationRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteDestinationAsync(DestinationName name)
 *           <li><p> deleteDestinationAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteDestinationOperationCallable()
 *           <li><p> deleteDestinationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetMulticloudDataTransferSupportedService</td>
 *      <td><p> Gets the details of a service that is supported for Data Transfer Essentials.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getMulticloudDataTransferSupportedService(GetMulticloudDataTransferSupportedServiceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getMulticloudDataTransferSupportedService(MulticloudDataTransferSupportedServiceName name)
 *           <li><p> getMulticloudDataTransferSupportedService(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getMulticloudDataTransferSupportedServiceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListMulticloudDataTransferSupportedServices</td>
 *      <td><p> Lists the services in the project for a region that are supported for Data Transfer Essentials.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listMulticloudDataTransferSupportedServices(ListMulticloudDataTransferSupportedServicesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listMulticloudDataTransferSupportedServices(LocationName parent)
 *           <li><p> listMulticloudDataTransferSupportedServices(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listMulticloudDataTransferSupportedServicesPagedCallable()
 *           <li><p> listMulticloudDataTransferSupportedServicesCallable()
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
 * <p>This class can be customized by passing in a custom instance of DataTransferServiceSettings to
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
 * DataTransferServiceSettings dataTransferServiceSettings =
 *     DataTransferServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DataTransferServiceClient dataTransferServiceClient =
 *     DataTransferServiceClient.create(dataTransferServiceSettings);
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
 * DataTransferServiceSettings dataTransferServiceSettings =
 *     DataTransferServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DataTransferServiceClient dataTransferServiceClient =
 *     DataTransferServiceClient.create(dataTransferServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class DataTransferServiceClient implements BackgroundResource {
  private final DataTransferServiceSettings settings;
  private final DataTransferServiceStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of DataTransferServiceClient with default settings. */
  public static final DataTransferServiceClient create() throws IOException {
    return create(DataTransferServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of DataTransferServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final DataTransferServiceClient create(DataTransferServiceSettings settings)
      throws IOException {
    return new DataTransferServiceClient(settings);
  }

  /**
   * Constructs an instance of DataTransferServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(DataTransferServiceSettings).
   */
  public static final DataTransferServiceClient create(DataTransferServiceStub stub) {
    return new DataTransferServiceClient(stub);
  }

  /**
   * Constructs an instance of DataTransferServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected DataTransferServiceClient(DataTransferServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((DataTransferServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  protected DataTransferServiceClient(DataTransferServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final DataTransferServiceSettings getSettings() {
    return settings;
  }

  public DataTransferServiceStub getStub() {
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
   * Lists the `MulticloudDataTransferConfig` resources in a specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (MulticloudDataTransferConfig element :
   *       dataTransferServiceClient.listMulticloudDataTransferConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMulticloudDataTransferConfigsPagedResponse listMulticloudDataTransferConfigs(
      LocationName parent) {
    ListMulticloudDataTransferConfigsRequest request =
        ListMulticloudDataTransferConfigsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listMulticloudDataTransferConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the `MulticloudDataTransferConfig` resources in a specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (MulticloudDataTransferConfig element :
   *       dataTransferServiceClient.listMulticloudDataTransferConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMulticloudDataTransferConfigsPagedResponse listMulticloudDataTransferConfigs(
      String parent) {
    ListMulticloudDataTransferConfigsRequest request =
        ListMulticloudDataTransferConfigsRequest.newBuilder().setParent(parent).build();
    return listMulticloudDataTransferConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the `MulticloudDataTransferConfig` resources in a specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   ListMulticloudDataTransferConfigsRequest request =
   *       ListMulticloudDataTransferConfigsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   for (MulticloudDataTransferConfig element :
   *       dataTransferServiceClient.listMulticloudDataTransferConfigs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMulticloudDataTransferConfigsPagedResponse listMulticloudDataTransferConfigs(
      ListMulticloudDataTransferConfigsRequest request) {
    return listMulticloudDataTransferConfigsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the `MulticloudDataTransferConfig` resources in a specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   ListMulticloudDataTransferConfigsRequest request =
   *       ListMulticloudDataTransferConfigsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<MulticloudDataTransferConfig> future =
   *       dataTransferServiceClient
   *           .listMulticloudDataTransferConfigsPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (MulticloudDataTransferConfig element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListMulticloudDataTransferConfigsRequest, ListMulticloudDataTransferConfigsPagedResponse>
      listMulticloudDataTransferConfigsPagedCallable() {
    return stub.listMulticloudDataTransferConfigsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the `MulticloudDataTransferConfig` resources in a specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   ListMulticloudDataTransferConfigsRequest request =
   *       ListMulticloudDataTransferConfigsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   while (true) {
   *     ListMulticloudDataTransferConfigsResponse response =
   *         dataTransferServiceClient.listMulticloudDataTransferConfigsCallable().call(request);
   *     for (MulticloudDataTransferConfig element :
   *         response.getMulticloudDataTransferConfigsList()) {
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
          ListMulticloudDataTransferConfigsRequest, ListMulticloudDataTransferConfigsResponse>
      listMulticloudDataTransferConfigsCallable() {
    return stub.listMulticloudDataTransferConfigsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a `MulticloudDataTransferConfig` resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   MulticloudDataTransferConfigName name =
   *       MulticloudDataTransferConfigName.of(
   *           "[PROJECT]", "[LOCATION]", "[MULTICLOUD_DATA_TRANSFER_CONFIG]");
   *   MulticloudDataTransferConfig response =
   *       dataTransferServiceClient.getMulticloudDataTransferConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the `MulticloudDataTransferConfig` resource to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MulticloudDataTransferConfig getMulticloudDataTransferConfig(
      MulticloudDataTransferConfigName name) {
    GetMulticloudDataTransferConfigRequest request =
        GetMulticloudDataTransferConfigRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getMulticloudDataTransferConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a `MulticloudDataTransferConfig` resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   String name =
   *       MulticloudDataTransferConfigName.of(
   *               "[PROJECT]", "[LOCATION]", "[MULTICLOUD_DATA_TRANSFER_CONFIG]")
   *           .toString();
   *   MulticloudDataTransferConfig response =
   *       dataTransferServiceClient.getMulticloudDataTransferConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the `MulticloudDataTransferConfig` resource to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MulticloudDataTransferConfig getMulticloudDataTransferConfig(String name) {
    GetMulticloudDataTransferConfigRequest request =
        GetMulticloudDataTransferConfigRequest.newBuilder().setName(name).build();
    return getMulticloudDataTransferConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a `MulticloudDataTransferConfig` resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   GetMulticloudDataTransferConfigRequest request =
   *       GetMulticloudDataTransferConfigRequest.newBuilder()
   *           .setName(
   *               MulticloudDataTransferConfigName.of(
   *                       "[PROJECT]", "[LOCATION]", "[MULTICLOUD_DATA_TRANSFER_CONFIG]")
   *                   .toString())
   *           .build();
   *   MulticloudDataTransferConfig response =
   *       dataTransferServiceClient.getMulticloudDataTransferConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MulticloudDataTransferConfig getMulticloudDataTransferConfig(
      GetMulticloudDataTransferConfigRequest request) {
    return getMulticloudDataTransferConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a `MulticloudDataTransferConfig` resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   GetMulticloudDataTransferConfigRequest request =
   *       GetMulticloudDataTransferConfigRequest.newBuilder()
   *           .setName(
   *               MulticloudDataTransferConfigName.of(
   *                       "[PROJECT]", "[LOCATION]", "[MULTICLOUD_DATA_TRANSFER_CONFIG]")
   *                   .toString())
   *           .build();
   *   ApiFuture<MulticloudDataTransferConfig> future =
   *       dataTransferServiceClient.getMulticloudDataTransferConfigCallable().futureCall(request);
   *   // Do something.
   *   MulticloudDataTransferConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetMulticloudDataTransferConfigRequest, MulticloudDataTransferConfig>
      getMulticloudDataTransferConfigCallable() {
    return stub.getMulticloudDataTransferConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `MulticloudDataTransferConfig` resource in a specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   MulticloudDataTransferConfig multicloudDataTransferConfig =
   *       MulticloudDataTransferConfig.newBuilder().build();
   *   String multicloudDataTransferConfigId = "multicloudDataTransferConfigId-1067608178";
   *   MulticloudDataTransferConfig response =
   *       dataTransferServiceClient
   *           .createMulticloudDataTransferConfigAsync(
   *               parent, multicloudDataTransferConfig, multicloudDataTransferConfigId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent resource.
   * @param multicloudDataTransferConfig Required. The `MulticloudDataTransferConfig` resource to
   *     create.
   * @param multicloudDataTransferConfigId Required. The ID to use for the
   *     `MulticloudDataTransferConfig` resource, which becomes the final component of the
   *     `MulticloudDataTransferConfig` resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MulticloudDataTransferConfig, OperationMetadata>
      createMulticloudDataTransferConfigAsync(
          LocationName parent,
          MulticloudDataTransferConfig multicloudDataTransferConfig,
          String multicloudDataTransferConfigId) {
    CreateMulticloudDataTransferConfigRequest request =
        CreateMulticloudDataTransferConfigRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setMulticloudDataTransferConfig(multicloudDataTransferConfig)
            .setMulticloudDataTransferConfigId(multicloudDataTransferConfigId)
            .build();
    return createMulticloudDataTransferConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `MulticloudDataTransferConfig` resource in a specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   MulticloudDataTransferConfig multicloudDataTransferConfig =
   *       MulticloudDataTransferConfig.newBuilder().build();
   *   String multicloudDataTransferConfigId = "multicloudDataTransferConfigId-1067608178";
   *   MulticloudDataTransferConfig response =
   *       dataTransferServiceClient
   *           .createMulticloudDataTransferConfigAsync(
   *               parent, multicloudDataTransferConfig, multicloudDataTransferConfigId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent resource.
   * @param multicloudDataTransferConfig Required. The `MulticloudDataTransferConfig` resource to
   *     create.
   * @param multicloudDataTransferConfigId Required. The ID to use for the
   *     `MulticloudDataTransferConfig` resource, which becomes the final component of the
   *     `MulticloudDataTransferConfig` resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MulticloudDataTransferConfig, OperationMetadata>
      createMulticloudDataTransferConfigAsync(
          String parent,
          MulticloudDataTransferConfig multicloudDataTransferConfig,
          String multicloudDataTransferConfigId) {
    CreateMulticloudDataTransferConfigRequest request =
        CreateMulticloudDataTransferConfigRequest.newBuilder()
            .setParent(parent)
            .setMulticloudDataTransferConfig(multicloudDataTransferConfig)
            .setMulticloudDataTransferConfigId(multicloudDataTransferConfigId)
            .build();
    return createMulticloudDataTransferConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `MulticloudDataTransferConfig` resource in a specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   CreateMulticloudDataTransferConfigRequest request =
   *       CreateMulticloudDataTransferConfigRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setMulticloudDataTransferConfigId("multicloudDataTransferConfigId-1067608178")
   *           .setMulticloudDataTransferConfig(MulticloudDataTransferConfig.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   MulticloudDataTransferConfig response =
   *       dataTransferServiceClient.createMulticloudDataTransferConfigAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MulticloudDataTransferConfig, OperationMetadata>
      createMulticloudDataTransferConfigAsync(CreateMulticloudDataTransferConfigRequest request) {
    return createMulticloudDataTransferConfigOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `MulticloudDataTransferConfig` resource in a specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   CreateMulticloudDataTransferConfigRequest request =
   *       CreateMulticloudDataTransferConfigRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setMulticloudDataTransferConfigId("multicloudDataTransferConfigId-1067608178")
   *           .setMulticloudDataTransferConfig(MulticloudDataTransferConfig.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<MulticloudDataTransferConfig, OperationMetadata> future =
   *       dataTransferServiceClient
   *           .createMulticloudDataTransferConfigOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   MulticloudDataTransferConfig response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateMulticloudDataTransferConfigRequest,
          MulticloudDataTransferConfig,
          OperationMetadata>
      createMulticloudDataTransferConfigOperationCallable() {
    return stub.createMulticloudDataTransferConfigOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `MulticloudDataTransferConfig` resource in a specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   CreateMulticloudDataTransferConfigRequest request =
   *       CreateMulticloudDataTransferConfigRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setMulticloudDataTransferConfigId("multicloudDataTransferConfigId-1067608178")
   *           .setMulticloudDataTransferConfig(MulticloudDataTransferConfig.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       dataTransferServiceClient
   *           .createMulticloudDataTransferConfigCallable()
   *           .futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateMulticloudDataTransferConfigRequest, Operation>
      createMulticloudDataTransferConfigCallable() {
    return stub.createMulticloudDataTransferConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `MulticloudDataTransferConfig` resource in a specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   MulticloudDataTransferConfig multicloudDataTransferConfig =
   *       MulticloudDataTransferConfig.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   MulticloudDataTransferConfig response =
   *       dataTransferServiceClient
   *           .updateMulticloudDataTransferConfigAsync(multicloudDataTransferConfig, updateMask)
   *           .get();
   * }
   * }</pre>
   *
   * @param multicloudDataTransferConfig Required. The `MulticloudDataTransferConfig` resource to
   *     update.
   * @param updateMask Optional. `FieldMask` is used to specify the fields in the
   *     `MulticloudDataTransferConfig` resource to be overwritten by the update. The fields
   *     specified in `update_mask` are relative to the resource, not the full request. A field is
   *     overwritten if it is in the mask. If you don't specify a mask, all fields are overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MulticloudDataTransferConfig, OperationMetadata>
      updateMulticloudDataTransferConfigAsync(
          MulticloudDataTransferConfig multicloudDataTransferConfig, FieldMask updateMask) {
    UpdateMulticloudDataTransferConfigRequest request =
        UpdateMulticloudDataTransferConfigRequest.newBuilder()
            .setMulticloudDataTransferConfig(multicloudDataTransferConfig)
            .setUpdateMask(updateMask)
            .build();
    return updateMulticloudDataTransferConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `MulticloudDataTransferConfig` resource in a specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   UpdateMulticloudDataTransferConfigRequest request =
   *       UpdateMulticloudDataTransferConfigRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setMulticloudDataTransferConfig(MulticloudDataTransferConfig.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   MulticloudDataTransferConfig response =
   *       dataTransferServiceClient.updateMulticloudDataTransferConfigAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MulticloudDataTransferConfig, OperationMetadata>
      updateMulticloudDataTransferConfigAsync(UpdateMulticloudDataTransferConfigRequest request) {
    return updateMulticloudDataTransferConfigOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `MulticloudDataTransferConfig` resource in a specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   UpdateMulticloudDataTransferConfigRequest request =
   *       UpdateMulticloudDataTransferConfigRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setMulticloudDataTransferConfig(MulticloudDataTransferConfig.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<MulticloudDataTransferConfig, OperationMetadata> future =
   *       dataTransferServiceClient
   *           .updateMulticloudDataTransferConfigOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   MulticloudDataTransferConfig response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UpdateMulticloudDataTransferConfigRequest,
          MulticloudDataTransferConfig,
          OperationMetadata>
      updateMulticloudDataTransferConfigOperationCallable() {
    return stub.updateMulticloudDataTransferConfigOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `MulticloudDataTransferConfig` resource in a specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   UpdateMulticloudDataTransferConfigRequest request =
   *       UpdateMulticloudDataTransferConfigRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setMulticloudDataTransferConfig(MulticloudDataTransferConfig.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       dataTransferServiceClient
   *           .updateMulticloudDataTransferConfigCallable()
   *           .futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateMulticloudDataTransferConfigRequest, Operation>
      updateMulticloudDataTransferConfigCallable() {
    return stub.updateMulticloudDataTransferConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a `MulticloudDataTransferConfig` resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   MulticloudDataTransferConfigName name =
   *       MulticloudDataTransferConfigName.of(
   *           "[PROJECT]", "[LOCATION]", "[MULTICLOUD_DATA_TRANSFER_CONFIG]");
   *   dataTransferServiceClient.deleteMulticloudDataTransferConfigAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the `MulticloudDataTransferConfig` resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteMulticloudDataTransferConfigAsync(
      MulticloudDataTransferConfigName name) {
    DeleteMulticloudDataTransferConfigRequest request =
        DeleteMulticloudDataTransferConfigRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteMulticloudDataTransferConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a `MulticloudDataTransferConfig` resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   String name =
   *       MulticloudDataTransferConfigName.of(
   *               "[PROJECT]", "[LOCATION]", "[MULTICLOUD_DATA_TRANSFER_CONFIG]")
   *           .toString();
   *   dataTransferServiceClient.deleteMulticloudDataTransferConfigAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the `MulticloudDataTransferConfig` resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteMulticloudDataTransferConfigAsync(
      String name) {
    DeleteMulticloudDataTransferConfigRequest request =
        DeleteMulticloudDataTransferConfigRequest.newBuilder().setName(name).build();
    return deleteMulticloudDataTransferConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a `MulticloudDataTransferConfig` resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   DeleteMulticloudDataTransferConfigRequest request =
   *       DeleteMulticloudDataTransferConfigRequest.newBuilder()
   *           .setName(
   *               MulticloudDataTransferConfigName.of(
   *                       "[PROJECT]", "[LOCATION]", "[MULTICLOUD_DATA_TRANSFER_CONFIG]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .setEtag("etag3123477")
   *           .build();
   *   dataTransferServiceClient.deleteMulticloudDataTransferConfigAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteMulticloudDataTransferConfigAsync(
      DeleteMulticloudDataTransferConfigRequest request) {
    return deleteMulticloudDataTransferConfigOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a `MulticloudDataTransferConfig` resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   DeleteMulticloudDataTransferConfigRequest request =
   *       DeleteMulticloudDataTransferConfigRequest.newBuilder()
   *           .setName(
   *               MulticloudDataTransferConfigName.of(
   *                       "[PROJECT]", "[LOCATION]", "[MULTICLOUD_DATA_TRANSFER_CONFIG]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .setEtag("etag3123477")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       dataTransferServiceClient
   *           .deleteMulticloudDataTransferConfigOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          DeleteMulticloudDataTransferConfigRequest, Empty, OperationMetadata>
      deleteMulticloudDataTransferConfigOperationCallable() {
    return stub.deleteMulticloudDataTransferConfigOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a `MulticloudDataTransferConfig` resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   DeleteMulticloudDataTransferConfigRequest request =
   *       DeleteMulticloudDataTransferConfigRequest.newBuilder()
   *           .setName(
   *               MulticloudDataTransferConfigName.of(
   *                       "[PROJECT]", "[LOCATION]", "[MULTICLOUD_DATA_TRANSFER_CONFIG]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Operation> future =
   *       dataTransferServiceClient
   *           .deleteMulticloudDataTransferConfigCallable()
   *           .futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteMulticloudDataTransferConfigRequest, Operation>
      deleteMulticloudDataTransferConfigCallable() {
    return stub.deleteMulticloudDataTransferConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the `Destination` resources in a specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   MulticloudDataTransferConfigName parent =
   *       MulticloudDataTransferConfigName.of(
   *           "[PROJECT]", "[LOCATION]", "[MULTICLOUD_DATA_TRANSFER_CONFIG]");
   *   for (Destination element : dataTransferServiceClient.listDestinations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDestinationsPagedResponse listDestinations(
      MulticloudDataTransferConfigName parent) {
    ListDestinationsRequest request =
        ListDestinationsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDestinations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the `Destination` resources in a specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   String parent =
   *       MulticloudDataTransferConfigName.of(
   *               "[PROJECT]", "[LOCATION]", "[MULTICLOUD_DATA_TRANSFER_CONFIG]")
   *           .toString();
   *   for (Destination element : dataTransferServiceClient.listDestinations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDestinationsPagedResponse listDestinations(String parent) {
    ListDestinationsRequest request =
        ListDestinationsRequest.newBuilder().setParent(parent).build();
    return listDestinations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the `Destination` resources in a specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   ListDestinationsRequest request =
   *       ListDestinationsRequest.newBuilder()
   *           .setParent(
   *               MulticloudDataTransferConfigName.of(
   *                       "[PROJECT]", "[LOCATION]", "[MULTICLOUD_DATA_TRANSFER_CONFIG]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   for (Destination element : dataTransferServiceClient.listDestinations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDestinationsPagedResponse listDestinations(ListDestinationsRequest request) {
    return listDestinationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the `Destination` resources in a specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   ListDestinationsRequest request =
   *       ListDestinationsRequest.newBuilder()
   *           .setParent(
   *               MulticloudDataTransferConfigName.of(
   *                       "[PROJECT]", "[LOCATION]", "[MULTICLOUD_DATA_TRANSFER_CONFIG]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<Destination> future =
   *       dataTransferServiceClient.listDestinationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Destination element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDestinationsRequest, ListDestinationsPagedResponse>
      listDestinationsPagedCallable() {
    return stub.listDestinationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the `Destination` resources in a specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   ListDestinationsRequest request =
   *       ListDestinationsRequest.newBuilder()
   *           .setParent(
   *               MulticloudDataTransferConfigName.of(
   *                       "[PROJECT]", "[LOCATION]", "[MULTICLOUD_DATA_TRANSFER_CONFIG]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   while (true) {
   *     ListDestinationsResponse response =
   *         dataTransferServiceClient.listDestinationsCallable().call(request);
   *     for (Destination element : response.getDestinationsList()) {
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
  public final UnaryCallable<ListDestinationsRequest, ListDestinationsResponse>
      listDestinationsCallable() {
    return stub.listDestinationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a `Destination` resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   DestinationName name =
   *       DestinationName.of(
   *           "[PROJECT]", "[LOCATION]", "[MULTICLOUD_DATA_TRANSFER_CONFIG]", "[DESTINATION]");
   *   Destination response = dataTransferServiceClient.getDestination(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the `Destination` resource to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Destination getDestination(DestinationName name) {
    GetDestinationRequest request =
        GetDestinationRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getDestination(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a `Destination` resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   String name =
   *       DestinationName.of(
   *               "[PROJECT]", "[LOCATION]", "[MULTICLOUD_DATA_TRANSFER_CONFIG]", "[DESTINATION]")
   *           .toString();
   *   Destination response = dataTransferServiceClient.getDestination(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the `Destination` resource to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Destination getDestination(String name) {
    GetDestinationRequest request = GetDestinationRequest.newBuilder().setName(name).build();
    return getDestination(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a `Destination` resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   GetDestinationRequest request =
   *       GetDestinationRequest.newBuilder()
   *           .setName(
   *               DestinationName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[MULTICLOUD_DATA_TRANSFER_CONFIG]",
   *                       "[DESTINATION]")
   *                   .toString())
   *           .build();
   *   Destination response = dataTransferServiceClient.getDestination(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Destination getDestination(GetDestinationRequest request) {
    return getDestinationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a `Destination` resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   GetDestinationRequest request =
   *       GetDestinationRequest.newBuilder()
   *           .setName(
   *               DestinationName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[MULTICLOUD_DATA_TRANSFER_CONFIG]",
   *                       "[DESTINATION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Destination> future =
   *       dataTransferServiceClient.getDestinationCallable().futureCall(request);
   *   // Do something.
   *   Destination response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDestinationRequest, Destination> getDestinationCallable() {
    return stub.getDestinationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `Destination` resource in a specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   MulticloudDataTransferConfigName parent =
   *       MulticloudDataTransferConfigName.of(
   *           "[PROJECT]", "[LOCATION]", "[MULTICLOUD_DATA_TRANSFER_CONFIG]");
   *   Destination destination = Destination.newBuilder().build();
   *   String destinationId = "destinationId306545097";
   *   Destination response =
   *       dataTransferServiceClient
   *           .createDestinationAsync(parent, destination, destinationId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent resource.
   * @param destination Required. The `Destination` resource to create.
   * @param destinationId Required. The ID to use for the `Destination` resource, which becomes the
   *     final component of the `Destination` resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Destination, OperationMetadata> createDestinationAsync(
      MulticloudDataTransferConfigName parent, Destination destination, String destinationId) {
    CreateDestinationRequest request =
        CreateDestinationRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setDestination(destination)
            .setDestinationId(destinationId)
            .build();
    return createDestinationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `Destination` resource in a specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   String parent =
   *       MulticloudDataTransferConfigName.of(
   *               "[PROJECT]", "[LOCATION]", "[MULTICLOUD_DATA_TRANSFER_CONFIG]")
   *           .toString();
   *   Destination destination = Destination.newBuilder().build();
   *   String destinationId = "destinationId306545097";
   *   Destination response =
   *       dataTransferServiceClient
   *           .createDestinationAsync(parent, destination, destinationId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent resource.
   * @param destination Required. The `Destination` resource to create.
   * @param destinationId Required. The ID to use for the `Destination` resource, which becomes the
   *     final component of the `Destination` resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Destination, OperationMetadata> createDestinationAsync(
      String parent, Destination destination, String destinationId) {
    CreateDestinationRequest request =
        CreateDestinationRequest.newBuilder()
            .setParent(parent)
            .setDestination(destination)
            .setDestinationId(destinationId)
            .build();
    return createDestinationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `Destination` resource in a specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   CreateDestinationRequest request =
   *       CreateDestinationRequest.newBuilder()
   *           .setParent(
   *               MulticloudDataTransferConfigName.of(
   *                       "[PROJECT]", "[LOCATION]", "[MULTICLOUD_DATA_TRANSFER_CONFIG]")
   *                   .toString())
   *           .setDestinationId("destinationId306545097")
   *           .setDestination(Destination.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Destination response = dataTransferServiceClient.createDestinationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Destination, OperationMetadata> createDestinationAsync(
      CreateDestinationRequest request) {
    return createDestinationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `Destination` resource in a specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   CreateDestinationRequest request =
   *       CreateDestinationRequest.newBuilder()
   *           .setParent(
   *               MulticloudDataTransferConfigName.of(
   *                       "[PROJECT]", "[LOCATION]", "[MULTICLOUD_DATA_TRANSFER_CONFIG]")
   *                   .toString())
   *           .setDestinationId("destinationId306545097")
   *           .setDestination(Destination.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Destination, OperationMetadata> future =
   *       dataTransferServiceClient.createDestinationOperationCallable().futureCall(request);
   *   // Do something.
   *   Destination response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateDestinationRequest, Destination, OperationMetadata>
      createDestinationOperationCallable() {
    return stub.createDestinationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `Destination` resource in a specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   CreateDestinationRequest request =
   *       CreateDestinationRequest.newBuilder()
   *           .setParent(
   *               MulticloudDataTransferConfigName.of(
   *                       "[PROJECT]", "[LOCATION]", "[MULTICLOUD_DATA_TRANSFER_CONFIG]")
   *                   .toString())
   *           .setDestinationId("destinationId306545097")
   *           .setDestination(Destination.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       dataTransferServiceClient.createDestinationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateDestinationRequest, Operation> createDestinationCallable() {
    return stub.createDestinationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `Destination` resource in a specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   Destination destination = Destination.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Destination response =
   *       dataTransferServiceClient.updateDestinationAsync(destination, updateMask).get();
   * }
   * }</pre>
   *
   * @param destination Required. The `Destination` resource to update.
   * @param updateMask Optional. `FieldMask is used to specify the fields to be overwritten in the
   *     `Destination` resource by the update. The fields specified in `update_mask` are relative to
   *     the resource, not the full request. A field is overwritten if it is in the mask. If you
   *     don't specify a mask, all fields are overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Destination, OperationMetadata> updateDestinationAsync(
      Destination destination, FieldMask updateMask) {
    UpdateDestinationRequest request =
        UpdateDestinationRequest.newBuilder()
            .setDestination(destination)
            .setUpdateMask(updateMask)
            .build();
    return updateDestinationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `Destination` resource in a specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   UpdateDestinationRequest request =
   *       UpdateDestinationRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setDestination(Destination.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Destination response = dataTransferServiceClient.updateDestinationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Destination, OperationMetadata> updateDestinationAsync(
      UpdateDestinationRequest request) {
    return updateDestinationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `Destination` resource in a specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   UpdateDestinationRequest request =
   *       UpdateDestinationRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setDestination(Destination.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Destination, OperationMetadata> future =
   *       dataTransferServiceClient.updateDestinationOperationCallable().futureCall(request);
   *   // Do something.
   *   Destination response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateDestinationRequest, Destination, OperationMetadata>
      updateDestinationOperationCallable() {
    return stub.updateDestinationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `Destination` resource in a specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   UpdateDestinationRequest request =
   *       UpdateDestinationRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setDestination(Destination.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       dataTransferServiceClient.updateDestinationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateDestinationRequest, Operation> updateDestinationCallable() {
    return stub.updateDestinationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a `Destination` resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   DestinationName name =
   *       DestinationName.of(
   *           "[PROJECT]", "[LOCATION]", "[MULTICLOUD_DATA_TRANSFER_CONFIG]", "[DESTINATION]");
   *   dataTransferServiceClient.deleteDestinationAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the `Destination` resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteDestinationAsync(
      DestinationName name) {
    DeleteDestinationRequest request =
        DeleteDestinationRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteDestinationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a `Destination` resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   String name =
   *       DestinationName.of(
   *               "[PROJECT]", "[LOCATION]", "[MULTICLOUD_DATA_TRANSFER_CONFIG]", "[DESTINATION]")
   *           .toString();
   *   dataTransferServiceClient.deleteDestinationAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the `Destination` resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteDestinationAsync(String name) {
    DeleteDestinationRequest request = DeleteDestinationRequest.newBuilder().setName(name).build();
    return deleteDestinationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a `Destination` resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   DeleteDestinationRequest request =
   *       DeleteDestinationRequest.newBuilder()
   *           .setName(
   *               DestinationName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[MULTICLOUD_DATA_TRANSFER_CONFIG]",
   *                       "[DESTINATION]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .setEtag("etag3123477")
   *           .build();
   *   dataTransferServiceClient.deleteDestinationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteDestinationAsync(
      DeleteDestinationRequest request) {
    return deleteDestinationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a `Destination` resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   DeleteDestinationRequest request =
   *       DeleteDestinationRequest.newBuilder()
   *           .setName(
   *               DestinationName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[MULTICLOUD_DATA_TRANSFER_CONFIG]",
   *                       "[DESTINATION]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .setEtag("etag3123477")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       dataTransferServiceClient.deleteDestinationOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteDestinationRequest, Empty, OperationMetadata>
      deleteDestinationOperationCallable() {
    return stub.deleteDestinationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a `Destination` resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   DeleteDestinationRequest request =
   *       DeleteDestinationRequest.newBuilder()
   *           .setName(
   *               DestinationName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[MULTICLOUD_DATA_TRANSFER_CONFIG]",
   *                       "[DESTINATION]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Operation> future =
   *       dataTransferServiceClient.deleteDestinationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteDestinationRequest, Operation> deleteDestinationCallable() {
    return stub.deleteDestinationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a service that is supported for Data Transfer Essentials.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   MulticloudDataTransferSupportedServiceName name =
   *       MulticloudDataTransferSupportedServiceName.of(
   *           "[PROJECT]", "[LOCATION]", "[MULTICLOUD_DATA_TRANSFER_SUPPORTED_SERVICE]");
   *   MulticloudDataTransferSupportedService response =
   *       dataTransferServiceClient.getMulticloudDataTransferSupportedService(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the service.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MulticloudDataTransferSupportedService getMulticloudDataTransferSupportedService(
      MulticloudDataTransferSupportedServiceName name) {
    GetMulticloudDataTransferSupportedServiceRequest request =
        GetMulticloudDataTransferSupportedServiceRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getMulticloudDataTransferSupportedService(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a service that is supported for Data Transfer Essentials.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   String name =
   *       MulticloudDataTransferSupportedServiceName.of(
   *               "[PROJECT]", "[LOCATION]", "[MULTICLOUD_DATA_TRANSFER_SUPPORTED_SERVICE]")
   *           .toString();
   *   MulticloudDataTransferSupportedService response =
   *       dataTransferServiceClient.getMulticloudDataTransferSupportedService(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the service.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MulticloudDataTransferSupportedService getMulticloudDataTransferSupportedService(
      String name) {
    GetMulticloudDataTransferSupportedServiceRequest request =
        GetMulticloudDataTransferSupportedServiceRequest.newBuilder().setName(name).build();
    return getMulticloudDataTransferSupportedService(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a service that is supported for Data Transfer Essentials.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   GetMulticloudDataTransferSupportedServiceRequest request =
   *       GetMulticloudDataTransferSupportedServiceRequest.newBuilder()
   *           .setName(
   *               MulticloudDataTransferSupportedServiceName.of(
   *                       "[PROJECT]", "[LOCATION]", "[MULTICLOUD_DATA_TRANSFER_SUPPORTED_SERVICE]")
   *                   .toString())
   *           .build();
   *   MulticloudDataTransferSupportedService response =
   *       dataTransferServiceClient.getMulticloudDataTransferSupportedService(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MulticloudDataTransferSupportedService getMulticloudDataTransferSupportedService(
      GetMulticloudDataTransferSupportedServiceRequest request) {
    return getMulticloudDataTransferSupportedServiceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a service that is supported for Data Transfer Essentials.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   GetMulticloudDataTransferSupportedServiceRequest request =
   *       GetMulticloudDataTransferSupportedServiceRequest.newBuilder()
   *           .setName(
   *               MulticloudDataTransferSupportedServiceName.of(
   *                       "[PROJECT]", "[LOCATION]", "[MULTICLOUD_DATA_TRANSFER_SUPPORTED_SERVICE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<MulticloudDataTransferSupportedService> future =
   *       dataTransferServiceClient
   *           .getMulticloudDataTransferSupportedServiceCallable()
   *           .futureCall(request);
   *   // Do something.
   *   MulticloudDataTransferSupportedService response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          GetMulticloudDataTransferSupportedServiceRequest, MulticloudDataTransferSupportedService>
      getMulticloudDataTransferSupportedServiceCallable() {
    return stub.getMulticloudDataTransferSupportedServiceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the services in the project for a region that are supported for Data Transfer Essentials.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (MulticloudDataTransferSupportedService element :
   *       dataTransferServiceClient
   *           .listMulticloudDataTransferSupportedServices(parent)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMulticloudDataTransferSupportedServicesPagedResponse
      listMulticloudDataTransferSupportedServices(LocationName parent) {
    ListMulticloudDataTransferSupportedServicesRequest request =
        ListMulticloudDataTransferSupportedServicesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listMulticloudDataTransferSupportedServices(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the services in the project for a region that are supported for Data Transfer Essentials.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (MulticloudDataTransferSupportedService element :
   *       dataTransferServiceClient
   *           .listMulticloudDataTransferSupportedServices(parent)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMulticloudDataTransferSupportedServicesPagedResponse
      listMulticloudDataTransferSupportedServices(String parent) {
    ListMulticloudDataTransferSupportedServicesRequest request =
        ListMulticloudDataTransferSupportedServicesRequest.newBuilder().setParent(parent).build();
    return listMulticloudDataTransferSupportedServices(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the services in the project for a region that are supported for Data Transfer Essentials.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   ListMulticloudDataTransferSupportedServicesRequest request =
   *       ListMulticloudDataTransferSupportedServicesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (MulticloudDataTransferSupportedService element :
   *       dataTransferServiceClient
   *           .listMulticloudDataTransferSupportedServices(request)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMulticloudDataTransferSupportedServicesPagedResponse
      listMulticloudDataTransferSupportedServices(
          ListMulticloudDataTransferSupportedServicesRequest request) {
    return listMulticloudDataTransferSupportedServicesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the services in the project for a region that are supported for Data Transfer Essentials.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   ListMulticloudDataTransferSupportedServicesRequest request =
   *       ListMulticloudDataTransferSupportedServicesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<MulticloudDataTransferSupportedService> future =
   *       dataTransferServiceClient
   *           .listMulticloudDataTransferSupportedServicesPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (MulticloudDataTransferSupportedService element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListMulticloudDataTransferSupportedServicesRequest,
          ListMulticloudDataTransferSupportedServicesPagedResponse>
      listMulticloudDataTransferSupportedServicesPagedCallable() {
    return stub.listMulticloudDataTransferSupportedServicesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the services in the project for a region that are supported for Data Transfer Essentials.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   ListMulticloudDataTransferSupportedServicesRequest request =
   *       ListMulticloudDataTransferSupportedServicesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListMulticloudDataTransferSupportedServicesResponse response =
   *         dataTransferServiceClient
   *             .listMulticloudDataTransferSupportedServicesCallable()
   *             .call(request);
   *     for (MulticloudDataTransferSupportedService element :
   *         response.getMulticloudDataTransferSupportedServicesList()) {
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
          ListMulticloudDataTransferSupportedServicesRequest,
          ListMulticloudDataTransferSupportedServicesResponse>
      listMulticloudDataTransferSupportedServicesCallable() {
    return stub.listMulticloudDataTransferSupportedServicesCallable();
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
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : dataTransferServiceClient.listLocations(request).iterateAll()) {
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
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       dataTransferServiceClient.listLocationsPagedCallable().futureCall(request);
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
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         dataTransferServiceClient.listLocationsCallable().call(request);
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
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = dataTransferServiceClient.getLocation(request);
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
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future =
   *       dataTransferServiceClient.getLocationCallable().futureCall(request);
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
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(GroupName.of("[PROJECT]", "[HUB]", "[GROUP]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = dataTransferServiceClient.setIamPolicy(request);
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
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(GroupName.of("[PROJECT]", "[HUB]", "[GROUP]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       dataTransferServiceClient.setIamPolicyCallable().futureCall(request);
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
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(GroupName.of("[PROJECT]", "[HUB]", "[GROUP]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = dataTransferServiceClient.getIamPolicy(request);
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
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(GroupName.of("[PROJECT]", "[HUB]", "[GROUP]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       dataTransferServiceClient.getIamPolicyCallable().futureCall(request);
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
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(GroupName.of("[PROJECT]", "[HUB]", "[GROUP]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = dataTransferServiceClient.testIamPermissions(request);
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
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(GroupName.of("[PROJECT]", "[HUB]", "[GROUP]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       dataTransferServiceClient.testIamPermissionsCallable().futureCall(request);
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

  public static class ListMulticloudDataTransferConfigsPagedResponse
      extends AbstractPagedListResponse<
          ListMulticloudDataTransferConfigsRequest,
          ListMulticloudDataTransferConfigsResponse,
          MulticloudDataTransferConfig,
          ListMulticloudDataTransferConfigsPage,
          ListMulticloudDataTransferConfigsFixedSizeCollection> {

    public static ApiFuture<ListMulticloudDataTransferConfigsPagedResponse> createAsync(
        PageContext<
                ListMulticloudDataTransferConfigsRequest,
                ListMulticloudDataTransferConfigsResponse,
                MulticloudDataTransferConfig>
            context,
        ApiFuture<ListMulticloudDataTransferConfigsResponse> futureResponse) {
      ApiFuture<ListMulticloudDataTransferConfigsPage> futurePage =
          ListMulticloudDataTransferConfigsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListMulticloudDataTransferConfigsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListMulticloudDataTransferConfigsPagedResponse(
        ListMulticloudDataTransferConfigsPage page) {
      super(page, ListMulticloudDataTransferConfigsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListMulticloudDataTransferConfigsPage
      extends AbstractPage<
          ListMulticloudDataTransferConfigsRequest,
          ListMulticloudDataTransferConfigsResponse,
          MulticloudDataTransferConfig,
          ListMulticloudDataTransferConfigsPage> {

    private ListMulticloudDataTransferConfigsPage(
        PageContext<
                ListMulticloudDataTransferConfigsRequest,
                ListMulticloudDataTransferConfigsResponse,
                MulticloudDataTransferConfig>
            context,
        ListMulticloudDataTransferConfigsResponse response) {
      super(context, response);
    }

    private static ListMulticloudDataTransferConfigsPage createEmptyPage() {
      return new ListMulticloudDataTransferConfigsPage(null, null);
    }

    @Override
    protected ListMulticloudDataTransferConfigsPage createPage(
        PageContext<
                ListMulticloudDataTransferConfigsRequest,
                ListMulticloudDataTransferConfigsResponse,
                MulticloudDataTransferConfig>
            context,
        ListMulticloudDataTransferConfigsResponse response) {
      return new ListMulticloudDataTransferConfigsPage(context, response);
    }

    @Override
    public ApiFuture<ListMulticloudDataTransferConfigsPage> createPageAsync(
        PageContext<
                ListMulticloudDataTransferConfigsRequest,
                ListMulticloudDataTransferConfigsResponse,
                MulticloudDataTransferConfig>
            context,
        ApiFuture<ListMulticloudDataTransferConfigsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListMulticloudDataTransferConfigsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListMulticloudDataTransferConfigsRequest,
          ListMulticloudDataTransferConfigsResponse,
          MulticloudDataTransferConfig,
          ListMulticloudDataTransferConfigsPage,
          ListMulticloudDataTransferConfigsFixedSizeCollection> {

    private ListMulticloudDataTransferConfigsFixedSizeCollection(
        List<ListMulticloudDataTransferConfigsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListMulticloudDataTransferConfigsFixedSizeCollection createEmptyCollection() {
      return new ListMulticloudDataTransferConfigsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListMulticloudDataTransferConfigsFixedSizeCollection createCollection(
        List<ListMulticloudDataTransferConfigsPage> pages, int collectionSize) {
      return new ListMulticloudDataTransferConfigsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListDestinationsPagedResponse
      extends AbstractPagedListResponse<
          ListDestinationsRequest,
          ListDestinationsResponse,
          Destination,
          ListDestinationsPage,
          ListDestinationsFixedSizeCollection> {

    public static ApiFuture<ListDestinationsPagedResponse> createAsync(
        PageContext<ListDestinationsRequest, ListDestinationsResponse, Destination> context,
        ApiFuture<ListDestinationsResponse> futureResponse) {
      ApiFuture<ListDestinationsPage> futurePage =
          ListDestinationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDestinationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDestinationsPagedResponse(ListDestinationsPage page) {
      super(page, ListDestinationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDestinationsPage
      extends AbstractPage<
          ListDestinationsRequest, ListDestinationsResponse, Destination, ListDestinationsPage> {

    private ListDestinationsPage(
        PageContext<ListDestinationsRequest, ListDestinationsResponse, Destination> context,
        ListDestinationsResponse response) {
      super(context, response);
    }

    private static ListDestinationsPage createEmptyPage() {
      return new ListDestinationsPage(null, null);
    }

    @Override
    protected ListDestinationsPage createPage(
        PageContext<ListDestinationsRequest, ListDestinationsResponse, Destination> context,
        ListDestinationsResponse response) {
      return new ListDestinationsPage(context, response);
    }

    @Override
    public ApiFuture<ListDestinationsPage> createPageAsync(
        PageContext<ListDestinationsRequest, ListDestinationsResponse, Destination> context,
        ApiFuture<ListDestinationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDestinationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDestinationsRequest,
          ListDestinationsResponse,
          Destination,
          ListDestinationsPage,
          ListDestinationsFixedSizeCollection> {

    private ListDestinationsFixedSizeCollection(
        List<ListDestinationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDestinationsFixedSizeCollection createEmptyCollection() {
      return new ListDestinationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDestinationsFixedSizeCollection createCollection(
        List<ListDestinationsPage> pages, int collectionSize) {
      return new ListDestinationsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListMulticloudDataTransferSupportedServicesPagedResponse
      extends AbstractPagedListResponse<
          ListMulticloudDataTransferSupportedServicesRequest,
          ListMulticloudDataTransferSupportedServicesResponse,
          MulticloudDataTransferSupportedService,
          ListMulticloudDataTransferSupportedServicesPage,
          ListMulticloudDataTransferSupportedServicesFixedSizeCollection> {

    public static ApiFuture<ListMulticloudDataTransferSupportedServicesPagedResponse> createAsync(
        PageContext<
                ListMulticloudDataTransferSupportedServicesRequest,
                ListMulticloudDataTransferSupportedServicesResponse,
                MulticloudDataTransferSupportedService>
            context,
        ApiFuture<ListMulticloudDataTransferSupportedServicesResponse> futureResponse) {
      ApiFuture<ListMulticloudDataTransferSupportedServicesPage> futurePage =
          ListMulticloudDataTransferSupportedServicesPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListMulticloudDataTransferSupportedServicesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListMulticloudDataTransferSupportedServicesPagedResponse(
        ListMulticloudDataTransferSupportedServicesPage page) {
      super(
          page,
          ListMulticloudDataTransferSupportedServicesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListMulticloudDataTransferSupportedServicesPage
      extends AbstractPage<
          ListMulticloudDataTransferSupportedServicesRequest,
          ListMulticloudDataTransferSupportedServicesResponse,
          MulticloudDataTransferSupportedService,
          ListMulticloudDataTransferSupportedServicesPage> {

    private ListMulticloudDataTransferSupportedServicesPage(
        PageContext<
                ListMulticloudDataTransferSupportedServicesRequest,
                ListMulticloudDataTransferSupportedServicesResponse,
                MulticloudDataTransferSupportedService>
            context,
        ListMulticloudDataTransferSupportedServicesResponse response) {
      super(context, response);
    }

    private static ListMulticloudDataTransferSupportedServicesPage createEmptyPage() {
      return new ListMulticloudDataTransferSupportedServicesPage(null, null);
    }

    @Override
    protected ListMulticloudDataTransferSupportedServicesPage createPage(
        PageContext<
                ListMulticloudDataTransferSupportedServicesRequest,
                ListMulticloudDataTransferSupportedServicesResponse,
                MulticloudDataTransferSupportedService>
            context,
        ListMulticloudDataTransferSupportedServicesResponse response) {
      return new ListMulticloudDataTransferSupportedServicesPage(context, response);
    }

    @Override
    public ApiFuture<ListMulticloudDataTransferSupportedServicesPage> createPageAsync(
        PageContext<
                ListMulticloudDataTransferSupportedServicesRequest,
                ListMulticloudDataTransferSupportedServicesResponse,
                MulticloudDataTransferSupportedService>
            context,
        ApiFuture<ListMulticloudDataTransferSupportedServicesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListMulticloudDataTransferSupportedServicesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListMulticloudDataTransferSupportedServicesRequest,
          ListMulticloudDataTransferSupportedServicesResponse,
          MulticloudDataTransferSupportedService,
          ListMulticloudDataTransferSupportedServicesPage,
          ListMulticloudDataTransferSupportedServicesFixedSizeCollection> {

    private ListMulticloudDataTransferSupportedServicesFixedSizeCollection(
        List<ListMulticloudDataTransferSupportedServicesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListMulticloudDataTransferSupportedServicesFixedSizeCollection
        createEmptyCollection() {
      return new ListMulticloudDataTransferSupportedServicesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListMulticloudDataTransferSupportedServicesFixedSizeCollection createCollection(
        List<ListMulticloudDataTransferSupportedServicesPage> pages, int collectionSize) {
      return new ListMulticloudDataTransferSupportedServicesFixedSizeCollection(
          pages, collectionSize);
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
