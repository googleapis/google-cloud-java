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

package com.google.cloud.redis.v1beta1;

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
import com.google.cloud.redis.v1beta1.stub.CloudRedisStub;
import com.google.cloud.redis.v1beta1.stub.CloudRedisStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Configures and manages Cloud Memorystore for Redis instances
 *
 * <p>Google Cloud Memorystore for Redis v1beta1
 *
 * <p>The `redis.googleapis.com` service implements the Google Cloud Memorystore for Redis API and
 * defines the following resource model for managing Redis instances:
 *
 * <ul>
 *   <li>The service works with a collection of cloud projects, named: `/projects/&#42;`
 *   <li>Each project has a collection of available locations, named: `/locations/&#42;`
 *   <li>Each location has a collection of Redis instances, named: `/instances/&#42;`
 *   <li>As such, Redis instances are resources of the form:
 *       `/projects/{project_id}/locations/{location_id}/instances/{instance_id}`
 * </ul>
 *
 * <p>Note that location_id must be referring to a GCP `region`; for example:
 *
 * <ul>
 *   <li>`projects/redpepper-1290/locations/us-central1/instances/my-redis`
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
 * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
 *   InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
 *   Instance response = cloudRedisClient.getInstance(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the CloudRedisClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
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
 * <p>This class can be customized by passing in a custom instance of CloudRedisSettings to
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
 * CloudRedisSettings cloudRedisSettings =
 *     CloudRedisSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * CloudRedisClient cloudRedisClient = CloudRedisClient.create(cloudRedisSettings);
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
 * CloudRedisSettings cloudRedisSettings =
 *     CloudRedisSettings.newBuilder().setEndpoint(myEndpoint).build();
 * CloudRedisClient cloudRedisClient = CloudRedisClient.create(cloudRedisSettings);
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
 * CloudRedisSettings cloudRedisSettings =
 *     CloudRedisSettings.newBuilder()
 *         .setTransportChannelProvider(
 *             CloudRedisSettings.defaultHttpJsonTransportProviderBuilder().build())
 *         .build();
 * CloudRedisClient cloudRedisClient = CloudRedisClient.create(cloudRedisSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class CloudRedisClient implements BackgroundResource {
  private final CloudRedisSettings settings;
  private final CloudRedisStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of CloudRedisClient with default settings. */
  public static final CloudRedisClient create() throws IOException {
    return create(CloudRedisSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of CloudRedisClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final CloudRedisClient create(CloudRedisSettings settings) throws IOException {
    return new CloudRedisClient(settings);
  }

  /**
   * Constructs an instance of CloudRedisClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(CloudRedisSettings).
   */
  public static final CloudRedisClient create(CloudRedisStub stub) {
    return new CloudRedisClient(stub);
  }

  /**
   * Constructs an instance of CloudRedisClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected CloudRedisClient(CloudRedisSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((CloudRedisStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected CloudRedisClient(CloudRedisStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final CloudRedisSettings getSettings() {
    return settings;
  }

  public CloudRedisStub getStub() {
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
   * Lists all Redis instances owned by a project in either the specified location (region) or all
   * locations.
   *
   * <p>The location should have the following format:
   *
   * <ul>
   *   <li>`projects/{project_id}/locations/{location_id}`
   * </ul>
   *
   * <p>If `location_id` is specified as `-` (wildcard), then all regions available to the project
   * are queried, and the results are aggregated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Instance element : cloudRedisClient.listInstances(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the instance location using the form:
   *     `projects/{project_id}/locations/{location_id}` where `location_id` refers to a GCP region.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInstancesPagedResponse listInstances(LocationName parent) {
    ListInstancesRequest request =
        ListInstancesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listInstances(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all Redis instances owned by a project in either the specified location (region) or all
   * locations.
   *
   * <p>The location should have the following format:
   *
   * <ul>
   *   <li>`projects/{project_id}/locations/{location_id}`
   * </ul>
   *
   * <p>If `location_id` is specified as `-` (wildcard), then all regions available to the project
   * are queried, and the results are aggregated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Instance element : cloudRedisClient.listInstances(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the instance location using the form:
   *     `projects/{project_id}/locations/{location_id}` where `location_id` refers to a GCP region.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInstancesPagedResponse listInstances(String parent) {
    ListInstancesRequest request = ListInstancesRequest.newBuilder().setParent(parent).build();
    return listInstances(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all Redis instances owned by a project in either the specified location (region) or all
   * locations.
   *
   * <p>The location should have the following format:
   *
   * <ul>
   *   <li>`projects/{project_id}/locations/{location_id}`
   * </ul>
   *
   * <p>If `location_id` is specified as `-` (wildcard), then all regions available to the project
   * are queried, and the results are aggregated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   ListInstancesRequest request =
   *       ListInstancesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Instance element : cloudRedisClient.listInstances(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInstancesPagedResponse listInstances(ListInstancesRequest request) {
    return listInstancesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all Redis instances owned by a project in either the specified location (region) or all
   * locations.
   *
   * <p>The location should have the following format:
   *
   * <ul>
   *   <li>`projects/{project_id}/locations/{location_id}`
   * </ul>
   *
   * <p>If `location_id` is specified as `-` (wildcard), then all regions available to the project
   * are queried, and the results are aggregated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   ListInstancesRequest request =
   *       ListInstancesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Instance> future =
   *       cloudRedisClient.listInstancesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Instance element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListInstancesRequest, ListInstancesPagedResponse>
      listInstancesPagedCallable() {
    return stub.listInstancesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all Redis instances owned by a project in either the specified location (region) or all
   * locations.
   *
   * <p>The location should have the following format:
   *
   * <ul>
   *   <li>`projects/{project_id}/locations/{location_id}`
   * </ul>
   *
   * <p>If `location_id` is specified as `-` (wildcard), then all regions available to the project
   * are queried, and the results are aggregated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   ListInstancesRequest request =
   *       ListInstancesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListInstancesResponse response = cloudRedisClient.listInstancesCallable().call(request);
   *     for (Instance element : response.getInstancesList()) {
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
  public final UnaryCallable<ListInstancesRequest, ListInstancesResponse> listInstancesCallable() {
    return stub.listInstancesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a specific Redis instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   Instance response = cloudRedisClient.getInstance(name);
   * }
   * }</pre>
   *
   * @param name Required. Redis instance resource name using the form:
   *     `projects/{project_id}/locations/{location_id}/instances/{instance_id}` where `location_id`
   *     refers to a GCP region.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Instance getInstance(InstanceName name) {
    GetInstanceRequest request =
        GetInstanceRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a specific Redis instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   String name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   Instance response = cloudRedisClient.getInstance(name);
   * }
   * }</pre>
   *
   * @param name Required. Redis instance resource name using the form:
   *     `projects/{project_id}/locations/{location_id}/instances/{instance_id}` where `location_id`
   *     refers to a GCP region.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Instance getInstance(String name) {
    GetInstanceRequest request = GetInstanceRequest.newBuilder().setName(name).build();
    return getInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a specific Redis instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   GetInstanceRequest request =
   *       GetInstanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   Instance response = cloudRedisClient.getInstance(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Instance getInstance(GetInstanceRequest request) {
    return getInstanceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a specific Redis instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   GetInstanceRequest request =
   *       GetInstanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   ApiFuture<Instance> future = cloudRedisClient.getInstanceCallable().futureCall(request);
   *   // Do something.
   *   Instance response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetInstanceRequest, Instance> getInstanceCallable() {
    return stub.getInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the AUTH string for a Redis instance. If AUTH is not enabled for the instance the response
   * will be empty. This information is not included in the details returned to GetInstance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   InstanceAuthString response = cloudRedisClient.getInstanceAuthString(name);
   * }
   * }</pre>
   *
   * @param name Required. Redis instance resource name using the form:
   *     `projects/{project_id}/locations/{location_id}/instances/{instance_id}` where `location_id`
   *     refers to a GCP region.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InstanceAuthString getInstanceAuthString(InstanceName name) {
    GetInstanceAuthStringRequest request =
        GetInstanceAuthStringRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getInstanceAuthString(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the AUTH string for a Redis instance. If AUTH is not enabled for the instance the response
   * will be empty. This information is not included in the details returned to GetInstance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   String name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   InstanceAuthString response = cloudRedisClient.getInstanceAuthString(name);
   * }
   * }</pre>
   *
   * @param name Required. Redis instance resource name using the form:
   *     `projects/{project_id}/locations/{location_id}/instances/{instance_id}` where `location_id`
   *     refers to a GCP region.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InstanceAuthString getInstanceAuthString(String name) {
    GetInstanceAuthStringRequest request =
        GetInstanceAuthStringRequest.newBuilder().setName(name).build();
    return getInstanceAuthString(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the AUTH string for a Redis instance. If AUTH is not enabled for the instance the response
   * will be empty. This information is not included in the details returned to GetInstance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   GetInstanceAuthStringRequest request =
   *       GetInstanceAuthStringRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   InstanceAuthString response = cloudRedisClient.getInstanceAuthString(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InstanceAuthString getInstanceAuthString(GetInstanceAuthStringRequest request) {
    return getInstanceAuthStringCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the AUTH string for a Redis instance. If AUTH is not enabled for the instance the response
   * will be empty. This information is not included in the details returned to GetInstance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   GetInstanceAuthStringRequest request =
   *       GetInstanceAuthStringRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   ApiFuture<InstanceAuthString> future =
   *       cloudRedisClient.getInstanceAuthStringCallable().futureCall(request);
   *   // Do something.
   *   InstanceAuthString response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetInstanceAuthStringRequest, InstanceAuthString>
      getInstanceAuthStringCallable() {
    return stub.getInstanceAuthStringCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Redis instance based on the specified tier and memory size.
   *
   * <p>By default, the instance is accessible from the project's [default
   * network](https://cloud.google.com/vpc/docs/vpc).
   *
   * <p>The creation is executed asynchronously and callers may check the returned operation to
   * track its progress. Once the operation is completed the Redis instance will be fully
   * functional. The completed longrunning.Operation will contain the new instance object in the
   * response field.
   *
   * <p>The returned operation is automatically deleted after a few hours, so there is no need to
   * call DeleteOperation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   String instanceId = "instanceId902024336";
   *   Instance instance = Instance.newBuilder().build();
   *   Instance response = cloudRedisClient.createInstanceAsync(parent, instanceId, instance).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the instance location using the form:
   *     `projects/{project_id}/locations/{location_id}` where `location_id` refers to a GCP region.
   * @param instanceId Required. The logical name of the Redis instance in the customer project with
   *     the following restrictions:
   *     <ul>
   *       <li>Must contain only lowercase letters, numbers, and hyphens.
   *       <li>Must start with a letter.
   *       <li>Must be between 1-40 characters.
   *       <li>Must end with a number or a letter.
   *       <li>Must be unique within the customer project / location
   *     </ul>
   *
   * @param instance Required. A Redis [Instance] resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, Any> createInstanceAsync(
      LocationName parent, String instanceId, Instance instance) {
    CreateInstanceRequest request =
        CreateInstanceRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setInstanceId(instanceId)
            .setInstance(instance)
            .build();
    return createInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Redis instance based on the specified tier and memory size.
   *
   * <p>By default, the instance is accessible from the project's [default
   * network](https://cloud.google.com/vpc/docs/vpc).
   *
   * <p>The creation is executed asynchronously and callers may check the returned operation to
   * track its progress. Once the operation is completed the Redis instance will be fully
   * functional. The completed longrunning.Operation will contain the new instance object in the
   * response field.
   *
   * <p>The returned operation is automatically deleted after a few hours, so there is no need to
   * call DeleteOperation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   String instanceId = "instanceId902024336";
   *   Instance instance = Instance.newBuilder().build();
   *   Instance response = cloudRedisClient.createInstanceAsync(parent, instanceId, instance).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the instance location using the form:
   *     `projects/{project_id}/locations/{location_id}` where `location_id` refers to a GCP region.
   * @param instanceId Required. The logical name of the Redis instance in the customer project with
   *     the following restrictions:
   *     <ul>
   *       <li>Must contain only lowercase letters, numbers, and hyphens.
   *       <li>Must start with a letter.
   *       <li>Must be between 1-40 characters.
   *       <li>Must end with a number or a letter.
   *       <li>Must be unique within the customer project / location
   *     </ul>
   *
   * @param instance Required. A Redis [Instance] resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, Any> createInstanceAsync(
      String parent, String instanceId, Instance instance) {
    CreateInstanceRequest request =
        CreateInstanceRequest.newBuilder()
            .setParent(parent)
            .setInstanceId(instanceId)
            .setInstance(instance)
            .build();
    return createInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Redis instance based on the specified tier and memory size.
   *
   * <p>By default, the instance is accessible from the project's [default
   * network](https://cloud.google.com/vpc/docs/vpc).
   *
   * <p>The creation is executed asynchronously and callers may check the returned operation to
   * track its progress. Once the operation is completed the Redis instance will be fully
   * functional. The completed longrunning.Operation will contain the new instance object in the
   * response field.
   *
   * <p>The returned operation is automatically deleted after a few hours, so there is no need to
   * call DeleteOperation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   CreateInstanceRequest request =
   *       CreateInstanceRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setInstanceId("instanceId902024336")
   *           .setInstance(Instance.newBuilder().build())
   *           .build();
   *   Instance response = cloudRedisClient.createInstanceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, Any> createInstanceAsync(CreateInstanceRequest request) {
    return createInstanceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Redis instance based on the specified tier and memory size.
   *
   * <p>By default, the instance is accessible from the project's [default
   * network](https://cloud.google.com/vpc/docs/vpc).
   *
   * <p>The creation is executed asynchronously and callers may check the returned operation to
   * track its progress. Once the operation is completed the Redis instance will be fully
   * functional. The completed longrunning.Operation will contain the new instance object in the
   * response field.
   *
   * <p>The returned operation is automatically deleted after a few hours, so there is no need to
   * call DeleteOperation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   CreateInstanceRequest request =
   *       CreateInstanceRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setInstanceId("instanceId902024336")
   *           .setInstance(Instance.newBuilder().build())
   *           .build();
   *   OperationFuture<Instance, Any> future =
   *       cloudRedisClient.createInstanceOperationCallable().futureCall(request);
   *   // Do something.
   *   Instance response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateInstanceRequest, Instance, Any>
      createInstanceOperationCallable() {
    return stub.createInstanceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Redis instance based on the specified tier and memory size.
   *
   * <p>By default, the instance is accessible from the project's [default
   * network](https://cloud.google.com/vpc/docs/vpc).
   *
   * <p>The creation is executed asynchronously and callers may check the returned operation to
   * track its progress. Once the operation is completed the Redis instance will be fully
   * functional. The completed longrunning.Operation will contain the new instance object in the
   * response field.
   *
   * <p>The returned operation is automatically deleted after a few hours, so there is no need to
   * call DeleteOperation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   CreateInstanceRequest request =
   *       CreateInstanceRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setInstanceId("instanceId902024336")
   *           .setInstance(Instance.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = cloudRedisClient.createInstanceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateInstanceRequest, Operation> createInstanceCallable() {
    return stub.createInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the metadata and configuration of a specific Redis instance.
   *
   * <p>Completed longrunning.Operation will contain the new instance object in the response field.
   * The returned operation is automatically deleted after a few hours, so there is no need to call
   * DeleteOperation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Instance instance = Instance.newBuilder().build();
   *   Instance response = cloudRedisClient.updateInstanceAsync(updateMask, instance).get();
   * }
   * }</pre>
   *
   * @param updateMask Required. Mask of fields to update. At least one path must be supplied in
   *     this field. The elements of the repeated paths field may only include these fields from
   *     [Instance][google.cloud.redis.v1beta1.Instance]:
   *     <p>&#42; `displayName` &#42; `labels` &#42; `memorySizeGb` &#42; `redisConfig` &#42;
   *     `replica_count`
   * @param instance Required. Update description. Only fields specified in update_mask are updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, Any> updateInstanceAsync(
      FieldMask updateMask, Instance instance) {
    UpdateInstanceRequest request =
        UpdateInstanceRequest.newBuilder().setUpdateMask(updateMask).setInstance(instance).build();
    return updateInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the metadata and configuration of a specific Redis instance.
   *
   * <p>Completed longrunning.Operation will contain the new instance object in the response field.
   * The returned operation is automatically deleted after a few hours, so there is no need to call
   * DeleteOperation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   UpdateInstanceRequest request =
   *       UpdateInstanceRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setInstance(Instance.newBuilder().build())
   *           .build();
   *   Instance response = cloudRedisClient.updateInstanceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, Any> updateInstanceAsync(UpdateInstanceRequest request) {
    return updateInstanceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the metadata and configuration of a specific Redis instance.
   *
   * <p>Completed longrunning.Operation will contain the new instance object in the response field.
   * The returned operation is automatically deleted after a few hours, so there is no need to call
   * DeleteOperation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   UpdateInstanceRequest request =
   *       UpdateInstanceRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setInstance(Instance.newBuilder().build())
   *           .build();
   *   OperationFuture<Instance, Any> future =
   *       cloudRedisClient.updateInstanceOperationCallable().futureCall(request);
   *   // Do something.
   *   Instance response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateInstanceRequest, Instance, Any>
      updateInstanceOperationCallable() {
    return stub.updateInstanceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the metadata and configuration of a specific Redis instance.
   *
   * <p>Completed longrunning.Operation will contain the new instance object in the response field.
   * The returned operation is automatically deleted after a few hours, so there is no need to call
   * DeleteOperation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   UpdateInstanceRequest request =
   *       UpdateInstanceRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setInstance(Instance.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = cloudRedisClient.updateInstanceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateInstanceRequest, Operation> updateInstanceCallable() {
    return stub.updateInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Upgrades Redis instance to the newer Redis version specified in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   String redisVersion = "redisVersion-1972584739";
   *   Instance response = cloudRedisClient.upgradeInstanceAsync(name, redisVersion).get();
   * }
   * }</pre>
   *
   * @param name Required. Redis instance resource name using the form:
   *     `projects/{project_id}/locations/{location_id}/instances/{instance_id}` where `location_id`
   *     refers to a GCP region.
   * @param redisVersion Required. Specifies the target version of Redis software to upgrade to.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, Any> upgradeInstanceAsync(
      InstanceName name, String redisVersion) {
    UpgradeInstanceRequest request =
        UpgradeInstanceRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setRedisVersion(redisVersion)
            .build();
    return upgradeInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Upgrades Redis instance to the newer Redis version specified in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   String name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   String redisVersion = "redisVersion-1972584739";
   *   Instance response = cloudRedisClient.upgradeInstanceAsync(name, redisVersion).get();
   * }
   * }</pre>
   *
   * @param name Required. Redis instance resource name using the form:
   *     `projects/{project_id}/locations/{location_id}/instances/{instance_id}` where `location_id`
   *     refers to a GCP region.
   * @param redisVersion Required. Specifies the target version of Redis software to upgrade to.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, Any> upgradeInstanceAsync(
      String name, String redisVersion) {
    UpgradeInstanceRequest request =
        UpgradeInstanceRequest.newBuilder().setName(name).setRedisVersion(redisVersion).build();
    return upgradeInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Upgrades Redis instance to the newer Redis version specified in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   UpgradeInstanceRequest request =
   *       UpgradeInstanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setRedisVersion("redisVersion-1972584739")
   *           .build();
   *   Instance response = cloudRedisClient.upgradeInstanceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, Any> upgradeInstanceAsync(UpgradeInstanceRequest request) {
    return upgradeInstanceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Upgrades Redis instance to the newer Redis version specified in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   UpgradeInstanceRequest request =
   *       UpgradeInstanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setRedisVersion("redisVersion-1972584739")
   *           .build();
   *   OperationFuture<Instance, Any> future =
   *       cloudRedisClient.upgradeInstanceOperationCallable().futureCall(request);
   *   // Do something.
   *   Instance response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpgradeInstanceRequest, Instance, Any>
      upgradeInstanceOperationCallable() {
    return stub.upgradeInstanceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Upgrades Redis instance to the newer Redis version specified in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   UpgradeInstanceRequest request =
   *       UpgradeInstanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setRedisVersion("redisVersion-1972584739")
   *           .build();
   *   ApiFuture<Operation> future = cloudRedisClient.upgradeInstanceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpgradeInstanceRequest, Operation> upgradeInstanceCallable() {
    return stub.upgradeInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Import a Redis RDB snapshot file from Cloud Storage into a Redis instance.
   *
   * <p>Redis may stop serving during this operation. Instance state will be IMPORTING for entire
   * operation. When complete, the instance will contain only data from the imported file.
   *
   * <p>The returned operation is automatically deleted after a few hours, so there is no need to
   * call DeleteOperation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   String name = "name3373707";
   *   InputConfig inputConfig = InputConfig.newBuilder().build();
   *   Instance response = cloudRedisClient.importInstanceAsync(name, inputConfig).get();
   * }
   * }</pre>
   *
   * @param name Required. Redis instance resource name using the form:
   *     `projects/{project_id}/locations/{location_id}/instances/{instance_id}` where `location_id`
   *     refers to a GCP region.
   * @param inputConfig Required. Specify data to be imported.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, Any> importInstanceAsync(
      String name, InputConfig inputConfig) {
    ImportInstanceRequest request =
        ImportInstanceRequest.newBuilder().setName(name).setInputConfig(inputConfig).build();
    return importInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Import a Redis RDB snapshot file from Cloud Storage into a Redis instance.
   *
   * <p>Redis may stop serving during this operation. Instance state will be IMPORTING for entire
   * operation. When complete, the instance will contain only data from the imported file.
   *
   * <p>The returned operation is automatically deleted after a few hours, so there is no need to
   * call DeleteOperation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   ImportInstanceRequest request =
   *       ImportInstanceRequest.newBuilder()
   *           .setName("name3373707")
   *           .setInputConfig(InputConfig.newBuilder().build())
   *           .build();
   *   Instance response = cloudRedisClient.importInstanceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, Any> importInstanceAsync(ImportInstanceRequest request) {
    return importInstanceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Import a Redis RDB snapshot file from Cloud Storage into a Redis instance.
   *
   * <p>Redis may stop serving during this operation. Instance state will be IMPORTING for entire
   * operation. When complete, the instance will contain only data from the imported file.
   *
   * <p>The returned operation is automatically deleted after a few hours, so there is no need to
   * call DeleteOperation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   ImportInstanceRequest request =
   *       ImportInstanceRequest.newBuilder()
   *           .setName("name3373707")
   *           .setInputConfig(InputConfig.newBuilder().build())
   *           .build();
   *   OperationFuture<Instance, Any> future =
   *       cloudRedisClient.importInstanceOperationCallable().futureCall(request);
   *   // Do something.
   *   Instance response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<ImportInstanceRequest, Instance, Any>
      importInstanceOperationCallable() {
    return stub.importInstanceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Import a Redis RDB snapshot file from Cloud Storage into a Redis instance.
   *
   * <p>Redis may stop serving during this operation. Instance state will be IMPORTING for entire
   * operation. When complete, the instance will contain only data from the imported file.
   *
   * <p>The returned operation is automatically deleted after a few hours, so there is no need to
   * call DeleteOperation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   ImportInstanceRequest request =
   *       ImportInstanceRequest.newBuilder()
   *           .setName("name3373707")
   *           .setInputConfig(InputConfig.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = cloudRedisClient.importInstanceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ImportInstanceRequest, Operation> importInstanceCallable() {
    return stub.importInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Export Redis instance data into a Redis RDB format file in Cloud Storage.
   *
   * <p>Redis will continue serving during this operation.
   *
   * <p>The returned operation is automatically deleted after a few hours, so there is no need to
   * call DeleteOperation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   String name = "name3373707";
   *   OutputConfig outputConfig = OutputConfig.newBuilder().build();
   *   Instance response = cloudRedisClient.exportInstanceAsync(name, outputConfig).get();
   * }
   * }</pre>
   *
   * @param name Required. Redis instance resource name using the form:
   *     `projects/{project_id}/locations/{location_id}/instances/{instance_id}` where `location_id`
   *     refers to a GCP region.
   * @param outputConfig Required. Specify data to be exported.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, Any> exportInstanceAsync(
      String name, OutputConfig outputConfig) {
    ExportInstanceRequest request =
        ExportInstanceRequest.newBuilder().setName(name).setOutputConfig(outputConfig).build();
    return exportInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Export Redis instance data into a Redis RDB format file in Cloud Storage.
   *
   * <p>Redis will continue serving during this operation.
   *
   * <p>The returned operation is automatically deleted after a few hours, so there is no need to
   * call DeleteOperation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   ExportInstanceRequest request =
   *       ExportInstanceRequest.newBuilder()
   *           .setName("name3373707")
   *           .setOutputConfig(OutputConfig.newBuilder().build())
   *           .build();
   *   Instance response = cloudRedisClient.exportInstanceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, Any> exportInstanceAsync(ExportInstanceRequest request) {
    return exportInstanceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Export Redis instance data into a Redis RDB format file in Cloud Storage.
   *
   * <p>Redis will continue serving during this operation.
   *
   * <p>The returned operation is automatically deleted after a few hours, so there is no need to
   * call DeleteOperation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   ExportInstanceRequest request =
   *       ExportInstanceRequest.newBuilder()
   *           .setName("name3373707")
   *           .setOutputConfig(OutputConfig.newBuilder().build())
   *           .build();
   *   OperationFuture<Instance, Any> future =
   *       cloudRedisClient.exportInstanceOperationCallable().futureCall(request);
   *   // Do something.
   *   Instance response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<ExportInstanceRequest, Instance, Any>
      exportInstanceOperationCallable() {
    return stub.exportInstanceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Export Redis instance data into a Redis RDB format file in Cloud Storage.
   *
   * <p>Redis will continue serving during this operation.
   *
   * <p>The returned operation is automatically deleted after a few hours, so there is no need to
   * call DeleteOperation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   ExportInstanceRequest request =
   *       ExportInstanceRequest.newBuilder()
   *           .setName("name3373707")
   *           .setOutputConfig(OutputConfig.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = cloudRedisClient.exportInstanceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ExportInstanceRequest, Operation> exportInstanceCallable() {
    return stub.exportInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates a failover of the primary node to current replica node for a specific STANDARD tier
   * Cloud Memorystore for Redis instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   FailoverInstanceRequest.DataProtectionMode dataProtectionMode =
   *       FailoverInstanceRequest.DataProtectionMode.forNumber(0);
   *   Instance response = cloudRedisClient.failoverInstanceAsync(name, dataProtectionMode).get();
   * }
   * }</pre>
   *
   * @param name Required. Redis instance resource name using the form:
   *     `projects/{project_id}/locations/{location_id}/instances/{instance_id}` where `location_id`
   *     refers to a GCP region.
   * @param dataProtectionMode Optional. Available data protection modes that the user can choose.
   *     If it's unspecified, data protection mode will be LIMITED_DATA_LOSS by default.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, Any> failoverInstanceAsync(
      InstanceName name, FailoverInstanceRequest.DataProtectionMode dataProtectionMode) {
    FailoverInstanceRequest request =
        FailoverInstanceRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setDataProtectionMode(dataProtectionMode)
            .build();
    return failoverInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates a failover of the primary node to current replica node for a specific STANDARD tier
   * Cloud Memorystore for Redis instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   String name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   FailoverInstanceRequest.DataProtectionMode dataProtectionMode =
   *       FailoverInstanceRequest.DataProtectionMode.forNumber(0);
   *   Instance response = cloudRedisClient.failoverInstanceAsync(name, dataProtectionMode).get();
   * }
   * }</pre>
   *
   * @param name Required. Redis instance resource name using the form:
   *     `projects/{project_id}/locations/{location_id}/instances/{instance_id}` where `location_id`
   *     refers to a GCP region.
   * @param dataProtectionMode Optional. Available data protection modes that the user can choose.
   *     If it's unspecified, data protection mode will be LIMITED_DATA_LOSS by default.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, Any> failoverInstanceAsync(
      String name, FailoverInstanceRequest.DataProtectionMode dataProtectionMode) {
    FailoverInstanceRequest request =
        FailoverInstanceRequest.newBuilder()
            .setName(name)
            .setDataProtectionMode(dataProtectionMode)
            .build();
    return failoverInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates a failover of the primary node to current replica node for a specific STANDARD tier
   * Cloud Memorystore for Redis instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   FailoverInstanceRequest request =
   *       FailoverInstanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   Instance response = cloudRedisClient.failoverInstanceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, Any> failoverInstanceAsync(
      FailoverInstanceRequest request) {
    return failoverInstanceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates a failover of the primary node to current replica node for a specific STANDARD tier
   * Cloud Memorystore for Redis instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   FailoverInstanceRequest request =
   *       FailoverInstanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   OperationFuture<Instance, Any> future =
   *       cloudRedisClient.failoverInstanceOperationCallable().futureCall(request);
   *   // Do something.
   *   Instance response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<FailoverInstanceRequest, Instance, Any>
      failoverInstanceOperationCallable() {
    return stub.failoverInstanceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates a failover of the primary node to current replica node for a specific STANDARD tier
   * Cloud Memorystore for Redis instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   FailoverInstanceRequest request =
   *       FailoverInstanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   ApiFuture<Operation> future = cloudRedisClient.failoverInstanceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<FailoverInstanceRequest, Operation> failoverInstanceCallable() {
    return stub.failoverInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific Redis instance. Instance stops serving and data is deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   cloudRedisClient.deleteInstanceAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Redis instance resource name using the form:
   *     `projects/{project_id}/locations/{location_id}/instances/{instance_id}` where `location_id`
   *     refers to a GCP region.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, Any> deleteInstanceAsync(InstanceName name) {
    DeleteInstanceRequest request =
        DeleteInstanceRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific Redis instance. Instance stops serving and data is deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   String name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   cloudRedisClient.deleteInstanceAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Redis instance resource name using the form:
   *     `projects/{project_id}/locations/{location_id}/instances/{instance_id}` where `location_id`
   *     refers to a GCP region.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, Any> deleteInstanceAsync(String name) {
    DeleteInstanceRequest request = DeleteInstanceRequest.newBuilder().setName(name).build();
    return deleteInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific Redis instance. Instance stops serving and data is deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   DeleteInstanceRequest request =
   *       DeleteInstanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   cloudRedisClient.deleteInstanceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, Any> deleteInstanceAsync(DeleteInstanceRequest request) {
    return deleteInstanceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific Redis instance. Instance stops serving and data is deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   DeleteInstanceRequest request =
   *       DeleteInstanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   OperationFuture<Empty, Any> future =
   *       cloudRedisClient.deleteInstanceOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteInstanceRequest, Empty, Any>
      deleteInstanceOperationCallable() {
    return stub.deleteInstanceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific Redis instance. Instance stops serving and data is deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   DeleteInstanceRequest request =
   *       DeleteInstanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   ApiFuture<Operation> future = cloudRedisClient.deleteInstanceCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteInstanceRequest, Operation> deleteInstanceCallable() {
    return stub.deleteInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reschedule maintenance for a given instance in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   RescheduleMaintenanceRequest.RescheduleType rescheduleType =
   *       RescheduleMaintenanceRequest.RescheduleType.forNumber(0);
   *   Timestamp scheduleTime = Timestamp.newBuilder().build();
   *   Instance response =
   *       cloudRedisClient.rescheduleMaintenanceAsync(name, rescheduleType, scheduleTime).get();
   * }
   * }</pre>
   *
   * @param name Required. Redis instance resource name using the form:
   *     `projects/{project_id}/locations/{location_id}/instances/{instance_id}` where `location_id`
   *     refers to a GCP region.
   * @param rescheduleType Required. If reschedule type is SPECIFIC_TIME, must set up schedule_time
   *     as well.
   * @param scheduleTime Optional. Timestamp when the maintenance shall be rescheduled to if
   *     reschedule_type=SPECIFIC_TIME, in RFC 3339 format, for example `2012-11-15T16:19:00.094Z`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, Any> rescheduleMaintenanceAsync(
      InstanceName name,
      RescheduleMaintenanceRequest.RescheduleType rescheduleType,
      Timestamp scheduleTime) {
    RescheduleMaintenanceRequest request =
        RescheduleMaintenanceRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setRescheduleType(rescheduleType)
            .setScheduleTime(scheduleTime)
            .build();
    return rescheduleMaintenanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reschedule maintenance for a given instance in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   String name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   RescheduleMaintenanceRequest.RescheduleType rescheduleType =
   *       RescheduleMaintenanceRequest.RescheduleType.forNumber(0);
   *   Timestamp scheduleTime = Timestamp.newBuilder().build();
   *   Instance response =
   *       cloudRedisClient.rescheduleMaintenanceAsync(name, rescheduleType, scheduleTime).get();
   * }
   * }</pre>
   *
   * @param name Required. Redis instance resource name using the form:
   *     `projects/{project_id}/locations/{location_id}/instances/{instance_id}` where `location_id`
   *     refers to a GCP region.
   * @param rescheduleType Required. If reschedule type is SPECIFIC_TIME, must set up schedule_time
   *     as well.
   * @param scheduleTime Optional. Timestamp when the maintenance shall be rescheduled to if
   *     reschedule_type=SPECIFIC_TIME, in RFC 3339 format, for example `2012-11-15T16:19:00.094Z`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, Any> rescheduleMaintenanceAsync(
      String name,
      RescheduleMaintenanceRequest.RescheduleType rescheduleType,
      Timestamp scheduleTime) {
    RescheduleMaintenanceRequest request =
        RescheduleMaintenanceRequest.newBuilder()
            .setName(name)
            .setRescheduleType(rescheduleType)
            .setScheduleTime(scheduleTime)
            .build();
    return rescheduleMaintenanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reschedule maintenance for a given instance in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   RescheduleMaintenanceRequest request =
   *       RescheduleMaintenanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setScheduleTime(Timestamp.newBuilder().build())
   *           .build();
   *   Instance response = cloudRedisClient.rescheduleMaintenanceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, Any> rescheduleMaintenanceAsync(
      RescheduleMaintenanceRequest request) {
    return rescheduleMaintenanceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reschedule maintenance for a given instance in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   RescheduleMaintenanceRequest request =
   *       RescheduleMaintenanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setScheduleTime(Timestamp.newBuilder().build())
   *           .build();
   *   OperationFuture<Instance, Any> future =
   *       cloudRedisClient.rescheduleMaintenanceOperationCallable().futureCall(request);
   *   // Do something.
   *   Instance response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<RescheduleMaintenanceRequest, Instance, Any>
      rescheduleMaintenanceOperationCallable() {
    return stub.rescheduleMaintenanceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reschedule maintenance for a given instance in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   RescheduleMaintenanceRequest request =
   *       RescheduleMaintenanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setScheduleTime(Timestamp.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       cloudRedisClient.rescheduleMaintenanceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RescheduleMaintenanceRequest, Operation>
      rescheduleMaintenanceCallable() {
    return stub.rescheduleMaintenanceCallable();
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

  public static class ListInstancesPagedResponse
      extends AbstractPagedListResponse<
          ListInstancesRequest,
          ListInstancesResponse,
          Instance,
          ListInstancesPage,
          ListInstancesFixedSizeCollection> {

    public static ApiFuture<ListInstancesPagedResponse> createAsync(
        PageContext<ListInstancesRequest, ListInstancesResponse, Instance> context,
        ApiFuture<ListInstancesResponse> futureResponse) {
      ApiFuture<ListInstancesPage> futurePage =
          ListInstancesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListInstancesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListInstancesPagedResponse(ListInstancesPage page) {
      super(page, ListInstancesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListInstancesPage
      extends AbstractPage<
          ListInstancesRequest, ListInstancesResponse, Instance, ListInstancesPage> {

    private ListInstancesPage(
        PageContext<ListInstancesRequest, ListInstancesResponse, Instance> context,
        ListInstancesResponse response) {
      super(context, response);
    }

    private static ListInstancesPage createEmptyPage() {
      return new ListInstancesPage(null, null);
    }

    @Override
    protected ListInstancesPage createPage(
        PageContext<ListInstancesRequest, ListInstancesResponse, Instance> context,
        ListInstancesResponse response) {
      return new ListInstancesPage(context, response);
    }

    @Override
    public ApiFuture<ListInstancesPage> createPageAsync(
        PageContext<ListInstancesRequest, ListInstancesResponse, Instance> context,
        ApiFuture<ListInstancesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListInstancesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListInstancesRequest,
          ListInstancesResponse,
          Instance,
          ListInstancesPage,
          ListInstancesFixedSizeCollection> {

    private ListInstancesFixedSizeCollection(List<ListInstancesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListInstancesFixedSizeCollection createEmptyCollection() {
      return new ListInstancesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListInstancesFixedSizeCollection createCollection(
        List<ListInstancesPage> pages, int collectionSize) {
      return new ListInstancesFixedSizeCollection(pages, collectionSize);
    }
  }
}
