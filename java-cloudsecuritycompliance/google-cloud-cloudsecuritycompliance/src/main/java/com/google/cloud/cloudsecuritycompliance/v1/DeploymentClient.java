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

package com.google.cloud.cloudsecuritycompliance.v1;

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
import com.google.cloud.cloudsecuritycompliance.v1.stub.DeploymentStub;
import com.google.cloud.cloudsecuritycompliance.v1.stub.DeploymentStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service describing handlers for resources
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
 * try (DeploymentClient deploymentClient = DeploymentClient.create()) {
 *   FrameworkDeploymentName name =
 *       FrameworkDeploymentName.of("[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK_DEPLOYMENT]");
 *   FrameworkDeployment response = deploymentClient.getFrameworkDeployment(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the DeploymentClient object to clean up resources such as
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
 *      <td><p> CreateFrameworkDeployment</td>
 *      <td><p> Creates a new FrameworkDeployment in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createFrameworkDeploymentAsync(CreateFrameworkDeploymentRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createFrameworkDeploymentAsync(OrganizationLocationName parent, FrameworkDeployment frameworkDeployment, String frameworkDeploymentId)
 *           <li><p> createFrameworkDeploymentAsync(String parent, FrameworkDeployment frameworkDeployment, String frameworkDeploymentId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createFrameworkDeploymentOperationCallable()
 *           <li><p> createFrameworkDeploymentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteFrameworkDeployment</td>
 *      <td><p> Deletes a single FrameworkDeployment.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteFrameworkDeploymentAsync(DeleteFrameworkDeploymentRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteFrameworkDeploymentAsync(FrameworkDeploymentName name)
 *           <li><p> deleteFrameworkDeploymentAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteFrameworkDeploymentOperationCallable()
 *           <li><p> deleteFrameworkDeploymentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetFrameworkDeployment</td>
 *      <td><p> Gets details of a single FrameworkDeployment.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getFrameworkDeployment(GetFrameworkDeploymentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getFrameworkDeployment(FrameworkDeploymentName name)
 *           <li><p> getFrameworkDeployment(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getFrameworkDeploymentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListFrameworkDeployments</td>
 *      <td><p> Lists FrameworkDeployments in a given parent and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listFrameworkDeployments(ListFrameworkDeploymentsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listFrameworkDeployments(OrganizationLocationName parent)
 *           <li><p> listFrameworkDeployments(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listFrameworkDeploymentsPagedCallable()
 *           <li><p> listFrameworkDeploymentsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetCloudControlDeployment</td>
 *      <td><p> Gets details of a single CloudControlDeployment.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getCloudControlDeployment(GetCloudControlDeploymentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getCloudControlDeployment(CloudControlDeploymentName name)
 *           <li><p> getCloudControlDeployment(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCloudControlDeploymentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListCloudControlDeployments</td>
 *      <td><p> Lists CloudControlDeployments under a given parent.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listCloudControlDeployments(ListCloudControlDeploymentsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listCloudControlDeployments(OrganizationLocationName parent)
 *           <li><p> listCloudControlDeployments(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listCloudControlDeploymentsPagedCallable()
 *           <li><p> listCloudControlDeploymentsCallable()
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
 * <p>This class can be customized by passing in a custom instance of DeploymentSettings to
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
 * DeploymentSettings deploymentSettings =
 *     DeploymentSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DeploymentClient deploymentClient = DeploymentClient.create(deploymentSettings);
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
 * DeploymentSettings deploymentSettings =
 *     DeploymentSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DeploymentClient deploymentClient = DeploymentClient.create(deploymentSettings);
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
 * DeploymentSettings deploymentSettings = DeploymentSettings.newHttpJsonBuilder().build();
 * DeploymentClient deploymentClient = DeploymentClient.create(deploymentSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class DeploymentClient implements BackgroundResource {
  private final DeploymentSettings settings;
  private final DeploymentStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of DeploymentClient with default settings. */
  public static final DeploymentClient create() throws IOException {
    return create(DeploymentSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of DeploymentClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final DeploymentClient create(DeploymentSettings settings) throws IOException {
    return new DeploymentClient(settings);
  }

  /**
   * Constructs an instance of DeploymentClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(DeploymentSettings).
   */
  public static final DeploymentClient create(DeploymentStub stub) {
    return new DeploymentClient(stub);
  }

  /**
   * Constructs an instance of DeploymentClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected DeploymentClient(DeploymentSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((DeploymentStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected DeploymentClient(DeploymentStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final DeploymentSettings getSettings() {
    return settings;
  }

  public DeploymentStub getStub() {
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
   * Creates a new FrameworkDeployment in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeploymentClient deploymentClient = DeploymentClient.create()) {
   *   OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
   *   FrameworkDeployment frameworkDeployment = FrameworkDeployment.newBuilder().build();
   *   String frameworkDeploymentId = "frameworkDeploymentId-1244700706";
   *   FrameworkDeployment response =
   *       deploymentClient
   *           .createFrameworkDeploymentAsync(parent, frameworkDeployment, frameworkDeploymentId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent. Supported formats:
   *     organizations/{organization}/locations/{location} Only global location is supported.
   * @param frameworkDeployment Required. The resource being created.
   * @param frameworkDeploymentId Optional. User provided identifier. It should be unique in scope
   *     of a parent Please note that this is optional and if not provided, a random UUID will be
   *     generated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<FrameworkDeployment, OperationMetadata>
      createFrameworkDeploymentAsync(
          OrganizationLocationName parent,
          FrameworkDeployment frameworkDeployment,
          String frameworkDeploymentId) {
    CreateFrameworkDeploymentRequest request =
        CreateFrameworkDeploymentRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setFrameworkDeployment(frameworkDeployment)
            .setFrameworkDeploymentId(frameworkDeploymentId)
            .build();
    return createFrameworkDeploymentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new FrameworkDeployment in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeploymentClient deploymentClient = DeploymentClient.create()) {
   *   String parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString();
   *   FrameworkDeployment frameworkDeployment = FrameworkDeployment.newBuilder().build();
   *   String frameworkDeploymentId = "frameworkDeploymentId-1244700706";
   *   FrameworkDeployment response =
   *       deploymentClient
   *           .createFrameworkDeploymentAsync(parent, frameworkDeployment, frameworkDeploymentId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent. Supported formats:
   *     organizations/{organization}/locations/{location} Only global location is supported.
   * @param frameworkDeployment Required. The resource being created.
   * @param frameworkDeploymentId Optional. User provided identifier. It should be unique in scope
   *     of a parent Please note that this is optional and if not provided, a random UUID will be
   *     generated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<FrameworkDeployment, OperationMetadata>
      createFrameworkDeploymentAsync(
          String parent, FrameworkDeployment frameworkDeployment, String frameworkDeploymentId) {
    CreateFrameworkDeploymentRequest request =
        CreateFrameworkDeploymentRequest.newBuilder()
            .setParent(parent)
            .setFrameworkDeployment(frameworkDeployment)
            .setFrameworkDeploymentId(frameworkDeploymentId)
            .build();
    return createFrameworkDeploymentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new FrameworkDeployment in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeploymentClient deploymentClient = DeploymentClient.create()) {
   *   CreateFrameworkDeploymentRequest request =
   *       CreateFrameworkDeploymentRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setFrameworkDeploymentId("frameworkDeploymentId-1244700706")
   *           .setFrameworkDeployment(FrameworkDeployment.newBuilder().build())
   *           .build();
   *   FrameworkDeployment response = deploymentClient.createFrameworkDeploymentAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<FrameworkDeployment, OperationMetadata>
      createFrameworkDeploymentAsync(CreateFrameworkDeploymentRequest request) {
    return createFrameworkDeploymentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new FrameworkDeployment in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeploymentClient deploymentClient = DeploymentClient.create()) {
   *   CreateFrameworkDeploymentRequest request =
   *       CreateFrameworkDeploymentRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setFrameworkDeploymentId("frameworkDeploymentId-1244700706")
   *           .setFrameworkDeployment(FrameworkDeployment.newBuilder().build())
   *           .build();
   *   OperationFuture<FrameworkDeployment, OperationMetadata> future =
   *       deploymentClient.createFrameworkDeploymentOperationCallable().futureCall(request);
   *   // Do something.
   *   FrameworkDeployment response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateFrameworkDeploymentRequest, FrameworkDeployment, OperationMetadata>
      createFrameworkDeploymentOperationCallable() {
    return stub.createFrameworkDeploymentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new FrameworkDeployment in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeploymentClient deploymentClient = DeploymentClient.create()) {
   *   CreateFrameworkDeploymentRequest request =
   *       CreateFrameworkDeploymentRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setFrameworkDeploymentId("frameworkDeploymentId-1244700706")
   *           .setFrameworkDeployment(FrameworkDeployment.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       deploymentClient.createFrameworkDeploymentCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateFrameworkDeploymentRequest, Operation>
      createFrameworkDeploymentCallable() {
    return stub.createFrameworkDeploymentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single FrameworkDeployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeploymentClient deploymentClient = DeploymentClient.create()) {
   *   FrameworkDeploymentName name =
   *       FrameworkDeploymentName.of("[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK_DEPLOYMENT]");
   *   deploymentClient.deleteFrameworkDeploymentAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the framework deployment to be deleted FrameworkDeployment name
   *     in either of the following formats:
   *     organizations/{organization}/locations/{location}/frameworkDeployments/{framework_deployment_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteFrameworkDeploymentAsync(
      FrameworkDeploymentName name) {
    DeleteFrameworkDeploymentRequest request =
        DeleteFrameworkDeploymentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteFrameworkDeploymentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single FrameworkDeployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeploymentClient deploymentClient = DeploymentClient.create()) {
   *   String name =
   *       FrameworkDeploymentName.of("[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK_DEPLOYMENT]")
   *           .toString();
   *   deploymentClient.deleteFrameworkDeploymentAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the framework deployment to be deleted FrameworkDeployment name
   *     in either of the following formats:
   *     organizations/{organization}/locations/{location}/frameworkDeployments/{framework_deployment_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteFrameworkDeploymentAsync(
      String name) {
    DeleteFrameworkDeploymentRequest request =
        DeleteFrameworkDeploymentRequest.newBuilder().setName(name).build();
    return deleteFrameworkDeploymentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single FrameworkDeployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeploymentClient deploymentClient = DeploymentClient.create()) {
   *   DeleteFrameworkDeploymentRequest request =
   *       DeleteFrameworkDeploymentRequest.newBuilder()
   *           .setName(
   *               FrameworkDeploymentName.of(
   *                       "[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK_DEPLOYMENT]")
   *                   .toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   deploymentClient.deleteFrameworkDeploymentAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteFrameworkDeploymentAsync(
      DeleteFrameworkDeploymentRequest request) {
    return deleteFrameworkDeploymentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single FrameworkDeployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeploymentClient deploymentClient = DeploymentClient.create()) {
   *   DeleteFrameworkDeploymentRequest request =
   *       DeleteFrameworkDeploymentRequest.newBuilder()
   *           .setName(
   *               FrameworkDeploymentName.of(
   *                       "[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK_DEPLOYMENT]")
   *                   .toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       deploymentClient.deleteFrameworkDeploymentOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteFrameworkDeploymentRequest, Empty, OperationMetadata>
      deleteFrameworkDeploymentOperationCallable() {
    return stub.deleteFrameworkDeploymentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single FrameworkDeployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeploymentClient deploymentClient = DeploymentClient.create()) {
   *   DeleteFrameworkDeploymentRequest request =
   *       DeleteFrameworkDeploymentRequest.newBuilder()
   *           .setName(
   *               FrameworkDeploymentName.of(
   *                       "[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK_DEPLOYMENT]")
   *                   .toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Operation> future =
   *       deploymentClient.deleteFrameworkDeploymentCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteFrameworkDeploymentRequest, Operation>
      deleteFrameworkDeploymentCallable() {
    return stub.deleteFrameworkDeploymentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single FrameworkDeployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeploymentClient deploymentClient = DeploymentClient.create()) {
   *   FrameworkDeploymentName name =
   *       FrameworkDeploymentName.of("[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK_DEPLOYMENT]");
   *   FrameworkDeployment response = deploymentClient.getFrameworkDeployment(name);
   * }
   * }</pre>
   *
   * @param name Required. FrameworkDeployment name in either of the following formats:
   *     organizations/{organization}/locations/{location}/frameworkDeployments/{framework_deployment_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FrameworkDeployment getFrameworkDeployment(FrameworkDeploymentName name) {
    GetFrameworkDeploymentRequest request =
        GetFrameworkDeploymentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getFrameworkDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single FrameworkDeployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeploymentClient deploymentClient = DeploymentClient.create()) {
   *   String name =
   *       FrameworkDeploymentName.of("[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK_DEPLOYMENT]")
   *           .toString();
   *   FrameworkDeployment response = deploymentClient.getFrameworkDeployment(name);
   * }
   * }</pre>
   *
   * @param name Required. FrameworkDeployment name in either of the following formats:
   *     organizations/{organization}/locations/{location}/frameworkDeployments/{framework_deployment_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FrameworkDeployment getFrameworkDeployment(String name) {
    GetFrameworkDeploymentRequest request =
        GetFrameworkDeploymentRequest.newBuilder().setName(name).build();
    return getFrameworkDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single FrameworkDeployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeploymentClient deploymentClient = DeploymentClient.create()) {
   *   GetFrameworkDeploymentRequest request =
   *       GetFrameworkDeploymentRequest.newBuilder()
   *           .setName(
   *               FrameworkDeploymentName.of(
   *                       "[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK_DEPLOYMENT]")
   *                   .toString())
   *           .build();
   *   FrameworkDeployment response = deploymentClient.getFrameworkDeployment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FrameworkDeployment getFrameworkDeployment(GetFrameworkDeploymentRequest request) {
    return getFrameworkDeploymentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single FrameworkDeployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeploymentClient deploymentClient = DeploymentClient.create()) {
   *   GetFrameworkDeploymentRequest request =
   *       GetFrameworkDeploymentRequest.newBuilder()
   *           .setName(
   *               FrameworkDeploymentName.of(
   *                       "[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK_DEPLOYMENT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<FrameworkDeployment> future =
   *       deploymentClient.getFrameworkDeploymentCallable().futureCall(request);
   *   // Do something.
   *   FrameworkDeployment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetFrameworkDeploymentRequest, FrameworkDeployment>
      getFrameworkDeploymentCallable() {
    return stub.getFrameworkDeploymentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists FrameworkDeployments in a given parent and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeploymentClient deploymentClient = DeploymentClient.create()) {
   *   OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
   *   for (FrameworkDeployment element :
   *       deploymentClient.listFrameworkDeployments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListFrameworkDeploymentsRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFrameworkDeploymentsPagedResponse listFrameworkDeployments(
      OrganizationLocationName parent) {
    ListFrameworkDeploymentsRequest request =
        ListFrameworkDeploymentsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listFrameworkDeployments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists FrameworkDeployments in a given parent and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeploymentClient deploymentClient = DeploymentClient.create()) {
   *   String parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString();
   *   for (FrameworkDeployment element :
   *       deploymentClient.listFrameworkDeployments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListFrameworkDeploymentsRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFrameworkDeploymentsPagedResponse listFrameworkDeployments(String parent) {
    ListFrameworkDeploymentsRequest request =
        ListFrameworkDeploymentsRequest.newBuilder().setParent(parent).build();
    return listFrameworkDeployments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists FrameworkDeployments in a given parent and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeploymentClient deploymentClient = DeploymentClient.create()) {
   *   ListFrameworkDeploymentsRequest request =
   *       ListFrameworkDeploymentsRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (FrameworkDeployment element :
   *       deploymentClient.listFrameworkDeployments(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFrameworkDeploymentsPagedResponse listFrameworkDeployments(
      ListFrameworkDeploymentsRequest request) {
    return listFrameworkDeploymentsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists FrameworkDeployments in a given parent and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeploymentClient deploymentClient = DeploymentClient.create()) {
   *   ListFrameworkDeploymentsRequest request =
   *       ListFrameworkDeploymentsRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<FrameworkDeployment> future =
   *       deploymentClient.listFrameworkDeploymentsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (FrameworkDeployment element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListFrameworkDeploymentsRequest, ListFrameworkDeploymentsPagedResponse>
      listFrameworkDeploymentsPagedCallable() {
    return stub.listFrameworkDeploymentsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists FrameworkDeployments in a given parent and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeploymentClient deploymentClient = DeploymentClient.create()) {
   *   ListFrameworkDeploymentsRequest request =
   *       ListFrameworkDeploymentsRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListFrameworkDeploymentsResponse response =
   *         deploymentClient.listFrameworkDeploymentsCallable().call(request);
   *     for (FrameworkDeployment element : response.getFrameworkDeploymentsList()) {
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
  public final UnaryCallable<ListFrameworkDeploymentsRequest, ListFrameworkDeploymentsResponse>
      listFrameworkDeploymentsCallable() {
    return stub.listFrameworkDeploymentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single CloudControlDeployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeploymentClient deploymentClient = DeploymentClient.create()) {
   *   CloudControlDeploymentName name =
   *       CloudControlDeploymentName.of(
   *           "[ORGANIZATION]", "[LOCATION]", "[CLOUD_CONTROL_DEPLOYMENT]");
   *   CloudControlDeployment response = deploymentClient.getCloudControlDeployment(name);
   * }
   * }</pre>
   *
   * @param name Required. CloudControlDeployment name in either of the following formats:
   *     organizations/{organization}/locations/{location}/cloudControlDeployments/{cloud_control_deployment_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CloudControlDeployment getCloudControlDeployment(CloudControlDeploymentName name) {
    GetCloudControlDeploymentRequest request =
        GetCloudControlDeploymentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getCloudControlDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single CloudControlDeployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeploymentClient deploymentClient = DeploymentClient.create()) {
   *   String name =
   *       CloudControlDeploymentName.of(
   *               "[ORGANIZATION]", "[LOCATION]", "[CLOUD_CONTROL_DEPLOYMENT]")
   *           .toString();
   *   CloudControlDeployment response = deploymentClient.getCloudControlDeployment(name);
   * }
   * }</pre>
   *
   * @param name Required. CloudControlDeployment name in either of the following formats:
   *     organizations/{organization}/locations/{location}/cloudControlDeployments/{cloud_control_deployment_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CloudControlDeployment getCloudControlDeployment(String name) {
    GetCloudControlDeploymentRequest request =
        GetCloudControlDeploymentRequest.newBuilder().setName(name).build();
    return getCloudControlDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single CloudControlDeployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeploymentClient deploymentClient = DeploymentClient.create()) {
   *   GetCloudControlDeploymentRequest request =
   *       GetCloudControlDeploymentRequest.newBuilder()
   *           .setName(
   *               CloudControlDeploymentName.of(
   *                       "[ORGANIZATION]", "[LOCATION]", "[CLOUD_CONTROL_DEPLOYMENT]")
   *                   .toString())
   *           .build();
   *   CloudControlDeployment response = deploymentClient.getCloudControlDeployment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CloudControlDeployment getCloudControlDeployment(
      GetCloudControlDeploymentRequest request) {
    return getCloudControlDeploymentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single CloudControlDeployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeploymentClient deploymentClient = DeploymentClient.create()) {
   *   GetCloudControlDeploymentRequest request =
   *       GetCloudControlDeploymentRequest.newBuilder()
   *           .setName(
   *               CloudControlDeploymentName.of(
   *                       "[ORGANIZATION]", "[LOCATION]", "[CLOUD_CONTROL_DEPLOYMENT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<CloudControlDeployment> future =
   *       deploymentClient.getCloudControlDeploymentCallable().futureCall(request);
   *   // Do something.
   *   CloudControlDeployment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetCloudControlDeploymentRequest, CloudControlDeployment>
      getCloudControlDeploymentCallable() {
    return stub.getCloudControlDeploymentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists CloudControlDeployments under a given parent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeploymentClient deploymentClient = DeploymentClient.create()) {
   *   OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
   *   for (CloudControlDeployment element :
   *       deploymentClient.listCloudControlDeployments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListCloudControlDeploymentsRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCloudControlDeploymentsPagedResponse listCloudControlDeployments(
      OrganizationLocationName parent) {
    ListCloudControlDeploymentsRequest request =
        ListCloudControlDeploymentsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listCloudControlDeployments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists CloudControlDeployments under a given parent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeploymentClient deploymentClient = DeploymentClient.create()) {
   *   String parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString();
   *   for (CloudControlDeployment element :
   *       deploymentClient.listCloudControlDeployments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListCloudControlDeploymentsRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCloudControlDeploymentsPagedResponse listCloudControlDeployments(String parent) {
    ListCloudControlDeploymentsRequest request =
        ListCloudControlDeploymentsRequest.newBuilder().setParent(parent).build();
    return listCloudControlDeployments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists CloudControlDeployments under a given parent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeploymentClient deploymentClient = DeploymentClient.create()) {
   *   ListCloudControlDeploymentsRequest request =
   *       ListCloudControlDeploymentsRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (CloudControlDeployment element :
   *       deploymentClient.listCloudControlDeployments(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCloudControlDeploymentsPagedResponse listCloudControlDeployments(
      ListCloudControlDeploymentsRequest request) {
    return listCloudControlDeploymentsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists CloudControlDeployments under a given parent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeploymentClient deploymentClient = DeploymentClient.create()) {
   *   ListCloudControlDeploymentsRequest request =
   *       ListCloudControlDeploymentsRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<CloudControlDeployment> future =
   *       deploymentClient.listCloudControlDeploymentsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (CloudControlDeployment element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListCloudControlDeploymentsRequest, ListCloudControlDeploymentsPagedResponse>
      listCloudControlDeploymentsPagedCallable() {
    return stub.listCloudControlDeploymentsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists CloudControlDeployments under a given parent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeploymentClient deploymentClient = DeploymentClient.create()) {
   *   ListCloudControlDeploymentsRequest request =
   *       ListCloudControlDeploymentsRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListCloudControlDeploymentsResponse response =
   *         deploymentClient.listCloudControlDeploymentsCallable().call(request);
   *     for (CloudControlDeployment element : response.getCloudControlDeploymentsList()) {
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
          ListCloudControlDeploymentsRequest, ListCloudControlDeploymentsResponse>
      listCloudControlDeploymentsCallable() {
    return stub.listCloudControlDeploymentsCallable();
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
   * try (DeploymentClient deploymentClient = DeploymentClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : deploymentClient.listLocations(request).iterateAll()) {
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
   * try (DeploymentClient deploymentClient = DeploymentClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       deploymentClient.listLocationsPagedCallable().futureCall(request);
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
   * try (DeploymentClient deploymentClient = DeploymentClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = deploymentClient.listLocationsCallable().call(request);
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
   * try (DeploymentClient deploymentClient = DeploymentClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = deploymentClient.getLocation(request);
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
   * try (DeploymentClient deploymentClient = DeploymentClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = deploymentClient.getLocationCallable().futureCall(request);
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

  public static class ListFrameworkDeploymentsPagedResponse
      extends AbstractPagedListResponse<
          ListFrameworkDeploymentsRequest,
          ListFrameworkDeploymentsResponse,
          FrameworkDeployment,
          ListFrameworkDeploymentsPage,
          ListFrameworkDeploymentsFixedSizeCollection> {

    public static ApiFuture<ListFrameworkDeploymentsPagedResponse> createAsync(
        PageContext<
                ListFrameworkDeploymentsRequest,
                ListFrameworkDeploymentsResponse,
                FrameworkDeployment>
            context,
        ApiFuture<ListFrameworkDeploymentsResponse> futureResponse) {
      ApiFuture<ListFrameworkDeploymentsPage> futurePage =
          ListFrameworkDeploymentsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListFrameworkDeploymentsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListFrameworkDeploymentsPagedResponse(ListFrameworkDeploymentsPage page) {
      super(page, ListFrameworkDeploymentsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListFrameworkDeploymentsPage
      extends AbstractPage<
          ListFrameworkDeploymentsRequest,
          ListFrameworkDeploymentsResponse,
          FrameworkDeployment,
          ListFrameworkDeploymentsPage> {

    private ListFrameworkDeploymentsPage(
        PageContext<
                ListFrameworkDeploymentsRequest,
                ListFrameworkDeploymentsResponse,
                FrameworkDeployment>
            context,
        ListFrameworkDeploymentsResponse response) {
      super(context, response);
    }

    private static ListFrameworkDeploymentsPage createEmptyPage() {
      return new ListFrameworkDeploymentsPage(null, null);
    }

    @Override
    protected ListFrameworkDeploymentsPage createPage(
        PageContext<
                ListFrameworkDeploymentsRequest,
                ListFrameworkDeploymentsResponse,
                FrameworkDeployment>
            context,
        ListFrameworkDeploymentsResponse response) {
      return new ListFrameworkDeploymentsPage(context, response);
    }

    @Override
    public ApiFuture<ListFrameworkDeploymentsPage> createPageAsync(
        PageContext<
                ListFrameworkDeploymentsRequest,
                ListFrameworkDeploymentsResponse,
                FrameworkDeployment>
            context,
        ApiFuture<ListFrameworkDeploymentsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFrameworkDeploymentsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListFrameworkDeploymentsRequest,
          ListFrameworkDeploymentsResponse,
          FrameworkDeployment,
          ListFrameworkDeploymentsPage,
          ListFrameworkDeploymentsFixedSizeCollection> {

    private ListFrameworkDeploymentsFixedSizeCollection(
        List<ListFrameworkDeploymentsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListFrameworkDeploymentsFixedSizeCollection createEmptyCollection() {
      return new ListFrameworkDeploymentsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListFrameworkDeploymentsFixedSizeCollection createCollection(
        List<ListFrameworkDeploymentsPage> pages, int collectionSize) {
      return new ListFrameworkDeploymentsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListCloudControlDeploymentsPagedResponse
      extends AbstractPagedListResponse<
          ListCloudControlDeploymentsRequest,
          ListCloudControlDeploymentsResponse,
          CloudControlDeployment,
          ListCloudControlDeploymentsPage,
          ListCloudControlDeploymentsFixedSizeCollection> {

    public static ApiFuture<ListCloudControlDeploymentsPagedResponse> createAsync(
        PageContext<
                ListCloudControlDeploymentsRequest,
                ListCloudControlDeploymentsResponse,
                CloudControlDeployment>
            context,
        ApiFuture<ListCloudControlDeploymentsResponse> futureResponse) {
      ApiFuture<ListCloudControlDeploymentsPage> futurePage =
          ListCloudControlDeploymentsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListCloudControlDeploymentsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListCloudControlDeploymentsPagedResponse(ListCloudControlDeploymentsPage page) {
      super(page, ListCloudControlDeploymentsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListCloudControlDeploymentsPage
      extends AbstractPage<
          ListCloudControlDeploymentsRequest,
          ListCloudControlDeploymentsResponse,
          CloudControlDeployment,
          ListCloudControlDeploymentsPage> {

    private ListCloudControlDeploymentsPage(
        PageContext<
                ListCloudControlDeploymentsRequest,
                ListCloudControlDeploymentsResponse,
                CloudControlDeployment>
            context,
        ListCloudControlDeploymentsResponse response) {
      super(context, response);
    }

    private static ListCloudControlDeploymentsPage createEmptyPage() {
      return new ListCloudControlDeploymentsPage(null, null);
    }

    @Override
    protected ListCloudControlDeploymentsPage createPage(
        PageContext<
                ListCloudControlDeploymentsRequest,
                ListCloudControlDeploymentsResponse,
                CloudControlDeployment>
            context,
        ListCloudControlDeploymentsResponse response) {
      return new ListCloudControlDeploymentsPage(context, response);
    }

    @Override
    public ApiFuture<ListCloudControlDeploymentsPage> createPageAsync(
        PageContext<
                ListCloudControlDeploymentsRequest,
                ListCloudControlDeploymentsResponse,
                CloudControlDeployment>
            context,
        ApiFuture<ListCloudControlDeploymentsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListCloudControlDeploymentsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListCloudControlDeploymentsRequest,
          ListCloudControlDeploymentsResponse,
          CloudControlDeployment,
          ListCloudControlDeploymentsPage,
          ListCloudControlDeploymentsFixedSizeCollection> {

    private ListCloudControlDeploymentsFixedSizeCollection(
        List<ListCloudControlDeploymentsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListCloudControlDeploymentsFixedSizeCollection createEmptyCollection() {
      return new ListCloudControlDeploymentsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListCloudControlDeploymentsFixedSizeCollection createCollection(
        List<ListCloudControlDeploymentsPage> pages, int collectionSize) {
      return new ListCloudControlDeploymentsFixedSizeCollection(pages, collectionSize);
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
