/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.aiplatform.v1beta1;

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
import com.google.cloud.aiplatform.v1beta1.stub.DeploymentResourcePoolServiceStub;
import com.google.cloud.aiplatform.v1beta1.stub.DeploymentResourcePoolServiceStubSettings;
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
import com.google.longrunning.OperationsClient;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: A service that manages the DeploymentResourcePool resource.
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
 * try (DeploymentResourcePoolServiceClient deploymentResourcePoolServiceClient =
 *     DeploymentResourcePoolServiceClient.create()) {
 *   DeploymentResourcePoolName name =
 *       DeploymentResourcePoolName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT_RESOURCE_POOL]");
 *   DeploymentResourcePool response =
 *       deploymentResourcePoolServiceClient.getDeploymentResourcePool(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the DeploymentResourcePoolServiceClient object to clean up
 * resources such as threads. In the example above, try-with-resources is used, which automatically
 * calls close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's
 * methods:
 *
 * <ol>
 *   <li>A "flattened" method. With this type of method, the fields of the request type have been
 *       converted into function parameters. It may be the case that not all fields are available as
 *       parameters, and not every API method will have a flattened method entry point.
 *   <li>A "request object" method. This type of method only takes one parameter, a request object,
 *       which must be constructed before the call. Not every API method will have a request object
 *       method.
 *   <li>A "callable" method. This type of method takes no parameters and returns an immutable API
 *       callable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of
 * DeploymentResourcePoolServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DeploymentResourcePoolServiceSettings deploymentResourcePoolServiceSettings =
 *     DeploymentResourcePoolServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DeploymentResourcePoolServiceClient deploymentResourcePoolServiceClient =
 *     DeploymentResourcePoolServiceClient.create(deploymentResourcePoolServiceSettings);
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
 * DeploymentResourcePoolServiceSettings deploymentResourcePoolServiceSettings =
 *     DeploymentResourcePoolServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DeploymentResourcePoolServiceClient deploymentResourcePoolServiceClient =
 *     DeploymentResourcePoolServiceClient.create(deploymentResourcePoolServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class DeploymentResourcePoolServiceClient implements BackgroundResource {
  private final DeploymentResourcePoolServiceSettings settings;
  private final DeploymentResourcePoolServiceStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of DeploymentResourcePoolServiceClient with default settings. */
  public static final DeploymentResourcePoolServiceClient create() throws IOException {
    return create(DeploymentResourcePoolServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of DeploymentResourcePoolServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final DeploymentResourcePoolServiceClient create(
      DeploymentResourcePoolServiceSettings settings) throws IOException {
    return new DeploymentResourcePoolServiceClient(settings);
  }

  /**
   * Constructs an instance of DeploymentResourcePoolServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(DeploymentResourcePoolServiceSettings).
   */
  public static final DeploymentResourcePoolServiceClient create(
      DeploymentResourcePoolServiceStub stub) {
    return new DeploymentResourcePoolServiceClient(stub);
  }

  /**
   * Constructs an instance of DeploymentResourcePoolServiceClient, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected DeploymentResourcePoolServiceClient(DeploymentResourcePoolServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub =
        ((DeploymentResourcePoolServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  protected DeploymentResourcePoolServiceClient(DeploymentResourcePoolServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final DeploymentResourcePoolServiceSettings getSettings() {
    return settings;
  }

  public DeploymentResourcePoolServiceStub getStub() {
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
   * Create a DeploymentResourcePool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeploymentResourcePoolServiceClient deploymentResourcePoolServiceClient =
   *     DeploymentResourcePoolServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   DeploymentResourcePool deploymentResourcePool = DeploymentResourcePool.newBuilder().build();
   *   String deploymentResourcePoolId = "deploymentResourcePoolId1805697578";
   *   DeploymentResourcePool response =
   *       deploymentResourcePoolServiceClient
   *           .createDeploymentResourcePoolAsync(
   *               parent, deploymentResourcePool, deploymentResourcePoolId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent location resource where this DeploymentResourcePool will be
   *     created. Format: projects/{project}/locations/{location}
   * @param deploymentResourcePool Required. The DeploymentResourcePool to create.
   * @param deploymentResourcePoolId Required. The ID to use for the DeploymentResourcePool, which
   *     will become the final component of the DeploymentResourcePool's resource name.
   *     <p>The maximum length is 63 characters, and valid characters are
   *     `/^[a-z]([a-z0-9-]{0,61}[a-z0-9])?$/`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<
          DeploymentResourcePool, CreateDeploymentResourcePoolOperationMetadata>
      createDeploymentResourcePoolAsync(
          LocationName parent,
          DeploymentResourcePool deploymentResourcePool,
          String deploymentResourcePoolId) {
    CreateDeploymentResourcePoolRequest request =
        CreateDeploymentResourcePoolRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setDeploymentResourcePool(deploymentResourcePool)
            .setDeploymentResourcePoolId(deploymentResourcePoolId)
            .build();
    return createDeploymentResourcePoolAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a DeploymentResourcePool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeploymentResourcePoolServiceClient deploymentResourcePoolServiceClient =
   *     DeploymentResourcePoolServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   DeploymentResourcePool deploymentResourcePool = DeploymentResourcePool.newBuilder().build();
   *   String deploymentResourcePoolId = "deploymentResourcePoolId1805697578";
   *   DeploymentResourcePool response =
   *       deploymentResourcePoolServiceClient
   *           .createDeploymentResourcePoolAsync(
   *               parent, deploymentResourcePool, deploymentResourcePoolId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent location resource where this DeploymentResourcePool will be
   *     created. Format: projects/{project}/locations/{location}
   * @param deploymentResourcePool Required. The DeploymentResourcePool to create.
   * @param deploymentResourcePoolId Required. The ID to use for the DeploymentResourcePool, which
   *     will become the final component of the DeploymentResourcePool's resource name.
   *     <p>The maximum length is 63 characters, and valid characters are
   *     `/^[a-z]([a-z0-9-]{0,61}[a-z0-9])?$/`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<
          DeploymentResourcePool, CreateDeploymentResourcePoolOperationMetadata>
      createDeploymentResourcePoolAsync(
          String parent,
          DeploymentResourcePool deploymentResourcePool,
          String deploymentResourcePoolId) {
    CreateDeploymentResourcePoolRequest request =
        CreateDeploymentResourcePoolRequest.newBuilder()
            .setParent(parent)
            .setDeploymentResourcePool(deploymentResourcePool)
            .setDeploymentResourcePoolId(deploymentResourcePoolId)
            .build();
    return createDeploymentResourcePoolAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a DeploymentResourcePool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeploymentResourcePoolServiceClient deploymentResourcePoolServiceClient =
   *     DeploymentResourcePoolServiceClient.create()) {
   *   CreateDeploymentResourcePoolRequest request =
   *       CreateDeploymentResourcePoolRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDeploymentResourcePool(DeploymentResourcePool.newBuilder().build())
   *           .setDeploymentResourcePoolId("deploymentResourcePoolId1805697578")
   *           .build();
   *   DeploymentResourcePool response =
   *       deploymentResourcePoolServiceClient.createDeploymentResourcePoolAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<
          DeploymentResourcePool, CreateDeploymentResourcePoolOperationMetadata>
      createDeploymentResourcePoolAsync(CreateDeploymentResourcePoolRequest request) {
    return createDeploymentResourcePoolOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a DeploymentResourcePool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeploymentResourcePoolServiceClient deploymentResourcePoolServiceClient =
   *     DeploymentResourcePoolServiceClient.create()) {
   *   CreateDeploymentResourcePoolRequest request =
   *       CreateDeploymentResourcePoolRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDeploymentResourcePool(DeploymentResourcePool.newBuilder().build())
   *           .setDeploymentResourcePoolId("deploymentResourcePoolId1805697578")
   *           .build();
   *   OperationFuture<DeploymentResourcePool, CreateDeploymentResourcePoolOperationMetadata>
   *       future =
   *           deploymentResourcePoolServiceClient
   *               .createDeploymentResourcePoolOperationCallable()
   *               .futureCall(request);
   *   // Do something.
   *   DeploymentResourcePool response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateDeploymentResourcePoolRequest,
          DeploymentResourcePool,
          CreateDeploymentResourcePoolOperationMetadata>
      createDeploymentResourcePoolOperationCallable() {
    return stub.createDeploymentResourcePoolOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a DeploymentResourcePool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeploymentResourcePoolServiceClient deploymentResourcePoolServiceClient =
   *     DeploymentResourcePoolServiceClient.create()) {
   *   CreateDeploymentResourcePoolRequest request =
   *       CreateDeploymentResourcePoolRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDeploymentResourcePool(DeploymentResourcePool.newBuilder().build())
   *           .setDeploymentResourcePoolId("deploymentResourcePoolId1805697578")
   *           .build();
   *   ApiFuture<Operation> future =
   *       deploymentResourcePoolServiceClient
   *           .createDeploymentResourcePoolCallable()
   *           .futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateDeploymentResourcePoolRequest, Operation>
      createDeploymentResourcePoolCallable() {
    return stub.createDeploymentResourcePoolCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a DeploymentResourcePool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeploymentResourcePoolServiceClient deploymentResourcePoolServiceClient =
   *     DeploymentResourcePoolServiceClient.create()) {
   *   DeploymentResourcePoolName name =
   *       DeploymentResourcePoolName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT_RESOURCE_POOL]");
   *   DeploymentResourcePool response =
   *       deploymentResourcePoolServiceClient.getDeploymentResourcePool(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the DeploymentResourcePool to retrieve. Format:
   *     projects/{project}/locations/{location}/deploymentResourcePools/{deployment_resource_pool}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeploymentResourcePool getDeploymentResourcePool(DeploymentResourcePoolName name) {
    GetDeploymentResourcePoolRequest request =
        GetDeploymentResourcePoolRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getDeploymentResourcePool(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a DeploymentResourcePool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeploymentResourcePoolServiceClient deploymentResourcePoolServiceClient =
   *     DeploymentResourcePoolServiceClient.create()) {
   *   String name =
   *       DeploymentResourcePoolName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT_RESOURCE_POOL]")
   *           .toString();
   *   DeploymentResourcePool response =
   *       deploymentResourcePoolServiceClient.getDeploymentResourcePool(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the DeploymentResourcePool to retrieve. Format:
   *     projects/{project}/locations/{location}/deploymentResourcePools/{deployment_resource_pool}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeploymentResourcePool getDeploymentResourcePool(String name) {
    GetDeploymentResourcePoolRequest request =
        GetDeploymentResourcePoolRequest.newBuilder().setName(name).build();
    return getDeploymentResourcePool(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a DeploymentResourcePool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeploymentResourcePoolServiceClient deploymentResourcePoolServiceClient =
   *     DeploymentResourcePoolServiceClient.create()) {
   *   GetDeploymentResourcePoolRequest request =
   *       GetDeploymentResourcePoolRequest.newBuilder()
   *           .setName(
   *               DeploymentResourcePoolName.of(
   *                       "[PROJECT]", "[LOCATION]", "[DEPLOYMENT_RESOURCE_POOL]")
   *                   .toString())
   *           .build();
   *   DeploymentResourcePool response =
   *       deploymentResourcePoolServiceClient.getDeploymentResourcePool(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeploymentResourcePool getDeploymentResourcePool(
      GetDeploymentResourcePoolRequest request) {
    return getDeploymentResourcePoolCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a DeploymentResourcePool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeploymentResourcePoolServiceClient deploymentResourcePoolServiceClient =
   *     DeploymentResourcePoolServiceClient.create()) {
   *   GetDeploymentResourcePoolRequest request =
   *       GetDeploymentResourcePoolRequest.newBuilder()
   *           .setName(
   *               DeploymentResourcePoolName.of(
   *                       "[PROJECT]", "[LOCATION]", "[DEPLOYMENT_RESOURCE_POOL]")
   *                   .toString())
   *           .build();
   *   ApiFuture<DeploymentResourcePool> future =
   *       deploymentResourcePoolServiceClient
   *           .getDeploymentResourcePoolCallable()
   *           .futureCall(request);
   *   // Do something.
   *   DeploymentResourcePool response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDeploymentResourcePoolRequest, DeploymentResourcePool>
      getDeploymentResourcePoolCallable() {
    return stub.getDeploymentResourcePoolCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List DeploymentResourcePools in a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeploymentResourcePoolServiceClient deploymentResourcePoolServiceClient =
   *     DeploymentResourcePoolServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   for (DeploymentResourcePool element :
   *       deploymentResourcePoolServiceClient.listDeploymentResourcePools(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent Location which owns this collection of
   *     DeploymentResourcePools. Format: projects/{project}/locations/{location}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDeploymentResourcePoolsPagedResponse listDeploymentResourcePools(
      ProjectName parent) {
    ListDeploymentResourcePoolsRequest request =
        ListDeploymentResourcePoolsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDeploymentResourcePools(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List DeploymentResourcePools in a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeploymentResourcePoolServiceClient deploymentResourcePoolServiceClient =
   *     DeploymentResourcePoolServiceClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   for (DeploymentResourcePool element :
   *       deploymentResourcePoolServiceClient.listDeploymentResourcePools(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent Location which owns this collection of
   *     DeploymentResourcePools. Format: projects/{project}/locations/{location}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDeploymentResourcePoolsPagedResponse listDeploymentResourcePools(String parent) {
    ListDeploymentResourcePoolsRequest request =
        ListDeploymentResourcePoolsRequest.newBuilder().setParent(parent).build();
    return listDeploymentResourcePools(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List DeploymentResourcePools in a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeploymentResourcePoolServiceClient deploymentResourcePoolServiceClient =
   *     DeploymentResourcePoolServiceClient.create()) {
   *   ListDeploymentResourcePoolsRequest request =
   *       ListDeploymentResourcePoolsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (DeploymentResourcePool element :
   *       deploymentResourcePoolServiceClient.listDeploymentResourcePools(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDeploymentResourcePoolsPagedResponse listDeploymentResourcePools(
      ListDeploymentResourcePoolsRequest request) {
    return listDeploymentResourcePoolsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List DeploymentResourcePools in a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeploymentResourcePoolServiceClient deploymentResourcePoolServiceClient =
   *     DeploymentResourcePoolServiceClient.create()) {
   *   ListDeploymentResourcePoolsRequest request =
   *       ListDeploymentResourcePoolsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<DeploymentResourcePool> future =
   *       deploymentResourcePoolServiceClient
   *           .listDeploymentResourcePoolsPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (DeploymentResourcePool element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListDeploymentResourcePoolsRequest, ListDeploymentResourcePoolsPagedResponse>
      listDeploymentResourcePoolsPagedCallable() {
    return stub.listDeploymentResourcePoolsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List DeploymentResourcePools in a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeploymentResourcePoolServiceClient deploymentResourcePoolServiceClient =
   *     DeploymentResourcePoolServiceClient.create()) {
   *   ListDeploymentResourcePoolsRequest request =
   *       ListDeploymentResourcePoolsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListDeploymentResourcePoolsResponse response =
   *         deploymentResourcePoolServiceClient.listDeploymentResourcePoolsCallable().call(request);
   *     for (DeploymentResourcePool element : response.getDeploymentResourcePoolsList()) {
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
          ListDeploymentResourcePoolsRequest, ListDeploymentResourcePoolsResponse>
      listDeploymentResourcePoolsCallable() {
    return stub.listDeploymentResourcePoolsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a DeploymentResourcePool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeploymentResourcePoolServiceClient deploymentResourcePoolServiceClient =
   *     DeploymentResourcePoolServiceClient.create()) {
   *   DeploymentResourcePoolName name =
   *       DeploymentResourcePoolName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT_RESOURCE_POOL]");
   *   deploymentResourcePoolServiceClient.deleteDeploymentResourcePoolAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the DeploymentResourcePool to delete. Format:
   *     projects/{project}/locations/{location}/deploymentResourcePools/{deployment_resource_pool}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteDeploymentResourcePoolAsync(
      DeploymentResourcePoolName name) {
    DeleteDeploymentResourcePoolRequest request =
        DeleteDeploymentResourcePoolRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteDeploymentResourcePoolAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a DeploymentResourcePool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeploymentResourcePoolServiceClient deploymentResourcePoolServiceClient =
   *     DeploymentResourcePoolServiceClient.create()) {
   *   String name =
   *       DeploymentResourcePoolName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT_RESOURCE_POOL]")
   *           .toString();
   *   deploymentResourcePoolServiceClient.deleteDeploymentResourcePoolAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the DeploymentResourcePool to delete. Format:
   *     projects/{project}/locations/{location}/deploymentResourcePools/{deployment_resource_pool}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteDeploymentResourcePoolAsync(
      String name) {
    DeleteDeploymentResourcePoolRequest request =
        DeleteDeploymentResourcePoolRequest.newBuilder().setName(name).build();
    return deleteDeploymentResourcePoolAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a DeploymentResourcePool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeploymentResourcePoolServiceClient deploymentResourcePoolServiceClient =
   *     DeploymentResourcePoolServiceClient.create()) {
   *   DeleteDeploymentResourcePoolRequest request =
   *       DeleteDeploymentResourcePoolRequest.newBuilder()
   *           .setName(
   *               DeploymentResourcePoolName.of(
   *                       "[PROJECT]", "[LOCATION]", "[DEPLOYMENT_RESOURCE_POOL]")
   *                   .toString())
   *           .build();
   *   deploymentResourcePoolServiceClient.deleteDeploymentResourcePoolAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteDeploymentResourcePoolAsync(
      DeleteDeploymentResourcePoolRequest request) {
    return deleteDeploymentResourcePoolOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a DeploymentResourcePool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeploymentResourcePoolServiceClient deploymentResourcePoolServiceClient =
   *     DeploymentResourcePoolServiceClient.create()) {
   *   DeleteDeploymentResourcePoolRequest request =
   *       DeleteDeploymentResourcePoolRequest.newBuilder()
   *           .setName(
   *               DeploymentResourcePoolName.of(
   *                       "[PROJECT]", "[LOCATION]", "[DEPLOYMENT_RESOURCE_POOL]")
   *                   .toString())
   *           .build();
   *   OperationFuture<Empty, DeleteOperationMetadata> future =
   *       deploymentResourcePoolServiceClient
   *           .deleteDeploymentResourcePoolOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          DeleteDeploymentResourcePoolRequest, Empty, DeleteOperationMetadata>
      deleteDeploymentResourcePoolOperationCallable() {
    return stub.deleteDeploymentResourcePoolOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a DeploymentResourcePool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeploymentResourcePoolServiceClient deploymentResourcePoolServiceClient =
   *     DeploymentResourcePoolServiceClient.create()) {
   *   DeleteDeploymentResourcePoolRequest request =
   *       DeleteDeploymentResourcePoolRequest.newBuilder()
   *           .setName(
   *               DeploymentResourcePoolName.of(
   *                       "[PROJECT]", "[LOCATION]", "[DEPLOYMENT_RESOURCE_POOL]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       deploymentResourcePoolServiceClient
   *           .deleteDeploymentResourcePoolCallable()
   *           .futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteDeploymentResourcePoolRequest, Operation>
      deleteDeploymentResourcePoolCallable() {
    return stub.deleteDeploymentResourcePoolCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List DeployedModels that have been deployed on this DeploymentResourcePool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeploymentResourcePoolServiceClient deploymentResourcePoolServiceClient =
   *     DeploymentResourcePoolServiceClient.create()) {
   *   String deploymentResourcePool = "deploymentResourcePool-1928845137";
   *   for (DeployedModel element :
   *       deploymentResourcePoolServiceClient
   *           .queryDeployedModels(deploymentResourcePool)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param deploymentResourcePool Required. The name of the target DeploymentResourcePool to query.
   *     Format:
   *     projects/{project}/locations/{location}/deploymentResourcePools/{deployment_resource_pool}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QueryDeployedModelsPagedResponse queryDeployedModels(String deploymentResourcePool) {
    QueryDeployedModelsRequest request =
        QueryDeployedModelsRequest.newBuilder()
            .setDeploymentResourcePool(deploymentResourcePool)
            .build();
    return queryDeployedModels(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List DeployedModels that have been deployed on this DeploymentResourcePool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeploymentResourcePoolServiceClient deploymentResourcePoolServiceClient =
   *     DeploymentResourcePoolServiceClient.create()) {
   *   QueryDeployedModelsRequest request =
   *       QueryDeployedModelsRequest.newBuilder()
   *           .setDeploymentResourcePool("deploymentResourcePool-1928845137")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (DeployedModel element :
   *       deploymentResourcePoolServiceClient.queryDeployedModels(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QueryDeployedModelsPagedResponse queryDeployedModels(
      QueryDeployedModelsRequest request) {
    return queryDeployedModelsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List DeployedModels that have been deployed on this DeploymentResourcePool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeploymentResourcePoolServiceClient deploymentResourcePoolServiceClient =
   *     DeploymentResourcePoolServiceClient.create()) {
   *   QueryDeployedModelsRequest request =
   *       QueryDeployedModelsRequest.newBuilder()
   *           .setDeploymentResourcePool("deploymentResourcePool-1928845137")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<DeployedModel> future =
   *       deploymentResourcePoolServiceClient
   *           .queryDeployedModelsPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (DeployedModel element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<QueryDeployedModelsRequest, QueryDeployedModelsPagedResponse>
      queryDeployedModelsPagedCallable() {
    return stub.queryDeployedModelsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List DeployedModels that have been deployed on this DeploymentResourcePool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeploymentResourcePoolServiceClient deploymentResourcePoolServiceClient =
   *     DeploymentResourcePoolServiceClient.create()) {
   *   QueryDeployedModelsRequest request =
   *       QueryDeployedModelsRequest.newBuilder()
   *           .setDeploymentResourcePool("deploymentResourcePool-1928845137")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     QueryDeployedModelsResponse response =
   *         deploymentResourcePoolServiceClient.queryDeployedModelsCallable().call(request);
   *     for (DeployedModel element : response.getDeployedModelsList()) {
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
  public final UnaryCallable<QueryDeployedModelsRequest, QueryDeployedModelsResponse>
      queryDeployedModelsCallable() {
    return stub.queryDeployedModelsCallable();
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
   * try (DeploymentResourcePoolServiceClient deploymentResourcePoolServiceClient =
   *     DeploymentResourcePoolServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element :
   *       deploymentResourcePoolServiceClient.listLocations(request).iterateAll()) {
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
   * try (DeploymentResourcePoolServiceClient deploymentResourcePoolServiceClient =
   *     DeploymentResourcePoolServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       deploymentResourcePoolServiceClient.listLocationsPagedCallable().futureCall(request);
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
   * try (DeploymentResourcePoolServiceClient deploymentResourcePoolServiceClient =
   *     DeploymentResourcePoolServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         deploymentResourcePoolServiceClient.listLocationsCallable().call(request);
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
   * try (DeploymentResourcePoolServiceClient deploymentResourcePoolServiceClient =
   *     DeploymentResourcePoolServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = deploymentResourcePoolServiceClient.getLocation(request);
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
   * try (DeploymentResourcePoolServiceClient deploymentResourcePoolServiceClient =
   *     DeploymentResourcePoolServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future =
   *       deploymentResourcePoolServiceClient.getLocationCallable().futureCall(request);
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
   * try (DeploymentResourcePoolServiceClient deploymentResourcePoolServiceClient =
   *     DeploymentResourcePoolServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = deploymentResourcePoolServiceClient.setIamPolicy(request);
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
   * try (DeploymentResourcePoolServiceClient deploymentResourcePoolServiceClient =
   *     DeploymentResourcePoolServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       deploymentResourcePoolServiceClient.setIamPolicyCallable().futureCall(request);
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
   * try (DeploymentResourcePoolServiceClient deploymentResourcePoolServiceClient =
   *     DeploymentResourcePoolServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = deploymentResourcePoolServiceClient.getIamPolicy(request);
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
   * try (DeploymentResourcePoolServiceClient deploymentResourcePoolServiceClient =
   *     DeploymentResourcePoolServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       deploymentResourcePoolServiceClient.getIamPolicyCallable().futureCall(request);
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
   * try (DeploymentResourcePoolServiceClient deploymentResourcePoolServiceClient =
   *     DeploymentResourcePoolServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response =
   *       deploymentResourcePoolServiceClient.testIamPermissions(request);
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
   * try (DeploymentResourcePoolServiceClient deploymentResourcePoolServiceClient =
   *     DeploymentResourcePoolServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       deploymentResourcePoolServiceClient.testIamPermissionsCallable().futureCall(request);
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

  public static class ListDeploymentResourcePoolsPagedResponse
      extends AbstractPagedListResponse<
          ListDeploymentResourcePoolsRequest,
          ListDeploymentResourcePoolsResponse,
          DeploymentResourcePool,
          ListDeploymentResourcePoolsPage,
          ListDeploymentResourcePoolsFixedSizeCollection> {

    public static ApiFuture<ListDeploymentResourcePoolsPagedResponse> createAsync(
        PageContext<
                ListDeploymentResourcePoolsRequest,
                ListDeploymentResourcePoolsResponse,
                DeploymentResourcePool>
            context,
        ApiFuture<ListDeploymentResourcePoolsResponse> futureResponse) {
      ApiFuture<ListDeploymentResourcePoolsPage> futurePage =
          ListDeploymentResourcePoolsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDeploymentResourcePoolsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDeploymentResourcePoolsPagedResponse(ListDeploymentResourcePoolsPage page) {
      super(page, ListDeploymentResourcePoolsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDeploymentResourcePoolsPage
      extends AbstractPage<
          ListDeploymentResourcePoolsRequest,
          ListDeploymentResourcePoolsResponse,
          DeploymentResourcePool,
          ListDeploymentResourcePoolsPage> {

    private ListDeploymentResourcePoolsPage(
        PageContext<
                ListDeploymentResourcePoolsRequest,
                ListDeploymentResourcePoolsResponse,
                DeploymentResourcePool>
            context,
        ListDeploymentResourcePoolsResponse response) {
      super(context, response);
    }

    private static ListDeploymentResourcePoolsPage createEmptyPage() {
      return new ListDeploymentResourcePoolsPage(null, null);
    }

    @Override
    protected ListDeploymentResourcePoolsPage createPage(
        PageContext<
                ListDeploymentResourcePoolsRequest,
                ListDeploymentResourcePoolsResponse,
                DeploymentResourcePool>
            context,
        ListDeploymentResourcePoolsResponse response) {
      return new ListDeploymentResourcePoolsPage(context, response);
    }

    @Override
    public ApiFuture<ListDeploymentResourcePoolsPage> createPageAsync(
        PageContext<
                ListDeploymentResourcePoolsRequest,
                ListDeploymentResourcePoolsResponse,
                DeploymentResourcePool>
            context,
        ApiFuture<ListDeploymentResourcePoolsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDeploymentResourcePoolsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDeploymentResourcePoolsRequest,
          ListDeploymentResourcePoolsResponse,
          DeploymentResourcePool,
          ListDeploymentResourcePoolsPage,
          ListDeploymentResourcePoolsFixedSizeCollection> {

    private ListDeploymentResourcePoolsFixedSizeCollection(
        List<ListDeploymentResourcePoolsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDeploymentResourcePoolsFixedSizeCollection createEmptyCollection() {
      return new ListDeploymentResourcePoolsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDeploymentResourcePoolsFixedSizeCollection createCollection(
        List<ListDeploymentResourcePoolsPage> pages, int collectionSize) {
      return new ListDeploymentResourcePoolsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class QueryDeployedModelsPagedResponse
      extends AbstractPagedListResponse<
          QueryDeployedModelsRequest,
          QueryDeployedModelsResponse,
          DeployedModel,
          QueryDeployedModelsPage,
          QueryDeployedModelsFixedSizeCollection> {

    public static ApiFuture<QueryDeployedModelsPagedResponse> createAsync(
        PageContext<QueryDeployedModelsRequest, QueryDeployedModelsResponse, DeployedModel> context,
        ApiFuture<QueryDeployedModelsResponse> futureResponse) {
      ApiFuture<QueryDeployedModelsPage> futurePage =
          QueryDeployedModelsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new QueryDeployedModelsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private QueryDeployedModelsPagedResponse(QueryDeployedModelsPage page) {
      super(page, QueryDeployedModelsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class QueryDeployedModelsPage
      extends AbstractPage<
          QueryDeployedModelsRequest,
          QueryDeployedModelsResponse,
          DeployedModel,
          QueryDeployedModelsPage> {

    private QueryDeployedModelsPage(
        PageContext<QueryDeployedModelsRequest, QueryDeployedModelsResponse, DeployedModel> context,
        QueryDeployedModelsResponse response) {
      super(context, response);
    }

    private static QueryDeployedModelsPage createEmptyPage() {
      return new QueryDeployedModelsPage(null, null);
    }

    @Override
    protected QueryDeployedModelsPage createPage(
        PageContext<QueryDeployedModelsRequest, QueryDeployedModelsResponse, DeployedModel> context,
        QueryDeployedModelsResponse response) {
      return new QueryDeployedModelsPage(context, response);
    }

    @Override
    public ApiFuture<QueryDeployedModelsPage> createPageAsync(
        PageContext<QueryDeployedModelsRequest, QueryDeployedModelsResponse, DeployedModel> context,
        ApiFuture<QueryDeployedModelsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class QueryDeployedModelsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          QueryDeployedModelsRequest,
          QueryDeployedModelsResponse,
          DeployedModel,
          QueryDeployedModelsPage,
          QueryDeployedModelsFixedSizeCollection> {

    private QueryDeployedModelsFixedSizeCollection(
        List<QueryDeployedModelsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static QueryDeployedModelsFixedSizeCollection createEmptyCollection() {
      return new QueryDeployedModelsFixedSizeCollection(null, 0);
    }

    @Override
    protected QueryDeployedModelsFixedSizeCollection createCollection(
        List<QueryDeployedModelsPage> pages, int collectionSize) {
      return new QueryDeployedModelsFixedSizeCollection(pages, collectionSize);
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
