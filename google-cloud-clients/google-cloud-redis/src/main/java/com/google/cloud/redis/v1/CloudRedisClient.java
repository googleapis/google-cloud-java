/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.redis.v1;

import com.google.api.core.ApiFunction;
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
import com.google.cloud.redis.v1.stub.CloudRedisStub;
import com.google.cloud.redis.v1.stub.CloudRedisStubSettings;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: Configures and manages Cloud Memorystore for Redis instances
 *
 * <p>Google Cloud Memorystore for Redis v1
 *
 * <p>The `redis.googleapis.com` service implements the Google Cloud Memorystore for Redis API and
 * defines the following resource model for managing Redis instances: &#42; The service works with a
 * collection of cloud projects, named: `/projects/&#42;` &#42; Each project has a collection of
 * available locations, named: `/locations/&#42;` &#42; Each location has a collection of Redis
 * instances, named: `/instances/&#42;` &#42; As such, Redis instances are resources of the form:
 * `/projects/{project_id}/locations/{location_id}/instances/{instance_id}`
 *
 * <p>Note that location_id must be refering to a GCP `region`; for example: &#42;
 * `projects/redpepper-1290/locations/us-central1/instances/my-redis`
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
 *   InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
 *   Instance response = cloudRedisClient.getInstance(name);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the cloudRedisClient object to clean up resources such as
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
 * <pre>
 * <code>
 * CloudRedisSettings cloudRedisSettings =
 *     CloudRedisSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * CloudRedisClient cloudRedisClient =
 *     CloudRedisClient.create(cloudRedisSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * CloudRedisSettings cloudRedisSettings =
 *     CloudRedisSettings.newBuilder().setEndpoint(myEndpoint).build();
 * CloudRedisClient cloudRedisClient =
 *     CloudRedisClient.create(cloudRedisSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class CloudRedisClient implements BackgroundResource {
  private final CloudRedisSettings settings;
  private final CloudRedisStub stub;
  private final OperationsClient operationsClient;

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
   * advanced usage - prefer to use CloudRedisSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
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
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected CloudRedisClient(CloudRedisStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final CloudRedisSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public CloudRedisStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationsClient getOperationsClient() {
    return operationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all Redis instances owned by a project in either the specified location (region) or all
   * locations.
   *
   * <p>The location should have the following format: &#42;
   * `projects/{project_id}/locations/{location_id}`
   *
   * <p>If `location_id` is specified as `-` (wildcard), then all regions available to the project
   * are queried, and the results are aggregated.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Instance element : cloudRedisClient.listInstances(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent Required. The resource name of the instance location using the form:
   *     `projects/{project_id}/locations/{location_id}` where `location_id` refers to a GCP region
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInstancesPagedResponse listInstances(LocationName parent) {
    ListInstancesRequest request =
        ListInstancesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listInstances(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all Redis instances owned by a project in either the specified location (region) or all
   * locations.
   *
   * <p>The location should have the following format: &#42;
   * `projects/{project_id}/locations/{location_id}`
   *
   * <p>If `location_id` is specified as `-` (wildcard), then all regions available to the project
   * are queried, and the results are aggregated.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Instance element : cloudRedisClient.listInstances(parent.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent Required. The resource name of the instance location using the form:
   *     `projects/{project_id}/locations/{location_id}` where `location_id` refers to a GCP region
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInstancesPagedResponse listInstances(String parent) {
    ListInstancesRequest request = ListInstancesRequest.newBuilder().setParent(parent).build();
    return listInstances(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all Redis instances owned by a project in either the specified location (region) or all
   * locations.
   *
   * <p>The location should have the following format: &#42;
   * `projects/{project_id}/locations/{location_id}`
   *
   * <p>If `location_id` is specified as `-` (wildcard), then all regions available to the project
   * are queried, and the results are aggregated.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ListInstancesRequest request = ListInstancesRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   for (Instance element : cloudRedisClient.listInstances(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInstancesPagedResponse listInstances(ListInstancesRequest request) {
    return listInstancesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all Redis instances owned by a project in either the specified location (region) or all
   * locations.
   *
   * <p>The location should have the following format: &#42;
   * `projects/{project_id}/locations/{location_id}`
   *
   * <p>If `location_id` is specified as `-` (wildcard), then all regions available to the project
   * are queried, and the results are aggregated.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ListInstancesRequest request = ListInstancesRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   ApiFuture&lt;ListInstancesPagedResponse&gt; future = cloudRedisClient.listInstancesPagedCallable().futureCall(request);
   *   // Do something
   *   for (Instance element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListInstancesRequest, ListInstancesPagedResponse>
      listInstancesPagedCallable() {
    return stub.listInstancesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all Redis instances owned by a project in either the specified location (region) or all
   * locations.
   *
   * <p>The location should have the following format: &#42;
   * `projects/{project_id}/locations/{location_id}`
   *
   * <p>If `location_id` is specified as `-` (wildcard), then all regions available to the project
   * are queried, and the results are aggregated.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ListInstancesRequest request = ListInstancesRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
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
   * </code></pre>
   */
  public final UnaryCallable<ListInstancesRequest, ListInstancesResponse> listInstancesCallable() {
    return stub.listInstancesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the details of a specific Redis instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   Instance response = cloudRedisClient.getInstance(name);
   * }
   * </code></pre>
   *
   * @param name Required. Redis instance resource name using the form:
   *     `projects/{project_id}/locations/{location_id}/instances/{instance_id}` where `location_id`
   *     refers to a GCP region
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Instance getInstance(InstanceName name) {

    GetInstanceRequest request =
        GetInstanceRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the details of a specific Redis instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   Instance response = cloudRedisClient.getInstance(name.toString());
   * }
   * </code></pre>
   *
   * @param name Required. Redis instance resource name using the form:
   *     `projects/{project_id}/locations/{location_id}/instances/{instance_id}` where `location_id`
   *     refers to a GCP region
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Instance getInstance(String name) {

    GetInstanceRequest request = GetInstanceRequest.newBuilder().setName(name).build();
    return getInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the details of a specific Redis instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   GetInstanceRequest request = GetInstanceRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   Instance response = cloudRedisClient.getInstance(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Instance getInstance(GetInstanceRequest request) {
    return getInstanceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the details of a specific Redis instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   GetInstanceRequest request = GetInstanceRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;Instance&gt; future = cloudRedisClient.getInstanceCallable().futureCall(request);
   *   // Do something
   *   Instance response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetInstanceRequest, Instance> getInstanceCallable() {
    return stub.getInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a Redis instance based on the specified tier and memory size.
   *
   * <p>By default, the instance is accessible from the project's [default
   * network](/compute/docs/networks-and-firewalls#networks).
   *
   * <p>The creation is executed asynchronously and callers may check the returned operation to
   * track its progress. Once the operation is completed the Redis instance will be fully
   * functional. Completed longrunning.Operation will contain the new instance object in the
   * response field.
   *
   * <p>The returned operation is automatically deleted after a few hours, so there is no need to
   * call DeleteOperation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   String instanceId = "test_instance";
   *   Instance.Tier tier = Instance.Tier.BASIC;
   *   int memorySizeGb = 1;
   *   Instance instance = Instance.newBuilder()
   *     .setTier(tier)
   *     .setMemorySizeGb(memorySizeGb)
   *     .build();
   *   Instance response = cloudRedisClient.createInstanceAsync(parent, instanceId, instance).get();
   * }
   * </code></pre>
   *
   * @param parent Required. The resource name of the instance location using the form:
   *     `projects/{project_id}/locations/{location_id}` where `location_id` refers to a GCP region
   * @param instanceId Required. The logical name of the Redis instance in the customer project with
   *     the following restrictions:
   *     <p>&#42; Must contain only lowercase letters, numbers, and hyphens. &#42; Must start with a
   *     letter. &#42; Must be between 1-40 characters. &#42; Must end with a number or a letter.
   *     &#42; Must be unique within the customer project / location
   * @param instance Required. A Redis [Instance] resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Instance, OperationMetadata> createInstanceAsync(
      LocationName parent, String instanceId, Instance instance) {

    CreateInstanceRequest request =
        CreateInstanceRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setInstanceId(instanceId)
            .setInstance(instance)
            .build();
    return createInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a Redis instance based on the specified tier and memory size.
   *
   * <p>By default, the instance is accessible from the project's [default
   * network](/compute/docs/networks-and-firewalls#networks).
   *
   * <p>The creation is executed asynchronously and callers may check the returned operation to
   * track its progress. Once the operation is completed the Redis instance will be fully
   * functional. Completed longrunning.Operation will contain the new instance object in the
   * response field.
   *
   * <p>The returned operation is automatically deleted after a few hours, so there is no need to
   * call DeleteOperation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   String instanceId = "test_instance";
   *   Instance.Tier tier = Instance.Tier.BASIC;
   *   int memorySizeGb = 1;
   *   Instance instance = Instance.newBuilder()
   *     .setTier(tier)
   *     .setMemorySizeGb(memorySizeGb)
   *     .build();
   *   Instance response = cloudRedisClient.createInstanceAsync(parent.toString(), instanceId, instance).get();
   * }
   * </code></pre>
   *
   * @param parent Required. The resource name of the instance location using the form:
   *     `projects/{project_id}/locations/{location_id}` where `location_id` refers to a GCP region
   * @param instanceId Required. The logical name of the Redis instance in the customer project with
   *     the following restrictions:
   *     <p>&#42; Must contain only lowercase letters, numbers, and hyphens. &#42; Must start with a
   *     letter. &#42; Must be between 1-40 characters. &#42; Must end with a number or a letter.
   *     &#42; Must be unique within the customer project / location
   * @param instance Required. A Redis [Instance] resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Instance, OperationMetadata> createInstanceAsync(
      String parent, String instanceId, Instance instance) {

    CreateInstanceRequest request =
        CreateInstanceRequest.newBuilder()
            .setParent(parent)
            .setInstanceId(instanceId)
            .setInstance(instance)
            .build();
    return createInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a Redis instance based on the specified tier and memory size.
   *
   * <p>By default, the instance is accessible from the project's [default
   * network](/compute/docs/networks-and-firewalls#networks).
   *
   * <p>The creation is executed asynchronously and callers may check the returned operation to
   * track its progress. Once the operation is completed the Redis instance will be fully
   * functional. Completed longrunning.Operation will contain the new instance object in the
   * response field.
   *
   * <p>The returned operation is automatically deleted after a few hours, so there is no need to
   * call DeleteOperation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   String instanceId = "test_instance";
   *   Instance.Tier tier = Instance.Tier.BASIC;
   *   int memorySizeGb = 1;
   *   Instance instance = Instance.newBuilder()
   *     .setTier(tier)
   *     .setMemorySizeGb(memorySizeGb)
   *     .build();
   *   CreateInstanceRequest request = CreateInstanceRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setInstanceId(instanceId)
   *     .setInstance(instance)
   *     .build();
   *   Instance response = cloudRedisClient.createInstanceAsync(request).get();
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Instance, OperationMetadata> createInstanceAsync(
      CreateInstanceRequest request) {
    return createInstanceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a Redis instance based on the specified tier and memory size.
   *
   * <p>By default, the instance is accessible from the project's [default
   * network](/compute/docs/networks-and-firewalls#networks).
   *
   * <p>The creation is executed asynchronously and callers may check the returned operation to
   * track its progress. Once the operation is completed the Redis instance will be fully
   * functional. Completed longrunning.Operation will contain the new instance object in the
   * response field.
   *
   * <p>The returned operation is automatically deleted after a few hours, so there is no need to
   * call DeleteOperation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   String instanceId = "test_instance";
   *   Instance.Tier tier = Instance.Tier.BASIC;
   *   int memorySizeGb = 1;
   *   Instance instance = Instance.newBuilder()
   *     .setTier(tier)
   *     .setMemorySizeGb(memorySizeGb)
   *     .build();
   *   CreateInstanceRequest request = CreateInstanceRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setInstanceId(instanceId)
   *     .setInstance(instance)
   *     .build();
   *   OperationFuture&lt;Operation&gt; future = cloudRedisClient.createInstanceOperationCallable().futureCall(request);
   *   // Do something
   *   Instance response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public final OperationCallable<CreateInstanceRequest, Instance, OperationMetadata>
      createInstanceOperationCallable() {
    return stub.createInstanceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a Redis instance based on the specified tier and memory size.
   *
   * <p>By default, the instance is accessible from the project's [default
   * network](/compute/docs/networks-and-firewalls#networks).
   *
   * <p>The creation is executed asynchronously and callers may check the returned operation to
   * track its progress. Once the operation is completed the Redis instance will be fully
   * functional. Completed longrunning.Operation will contain the new instance object in the
   * response field.
   *
   * <p>The returned operation is automatically deleted after a few hours, so there is no need to
   * call DeleteOperation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   String instanceId = "test_instance";
   *   Instance.Tier tier = Instance.Tier.BASIC;
   *   int memorySizeGb = 1;
   *   Instance instance = Instance.newBuilder()
   *     .setTier(tier)
   *     .setMemorySizeGb(memorySizeGb)
   *     .build();
   *   CreateInstanceRequest request = CreateInstanceRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setInstanceId(instanceId)
   *     .setInstance(instance)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = cloudRedisClient.createInstanceCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CreateInstanceRequest, Operation> createInstanceCallable() {
    return stub.createInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the metadata and configuration of a specific Redis instance.
   *
   * <p>Completed longrunning.Operation will contain the new instance object in the response field.
   * The returned operation is automatically deleted after a few hours, so there is no need to call
   * DeleteOperation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   String pathsElement = "display_name";
   *   String pathsElement2 = "memory_size_gb";
   *   List&lt;String&gt; paths = Arrays.asList(pathsElement, pathsElement2);
   *   FieldMask updateMask = FieldMask.newBuilder()
   *     .addAllPaths(paths)
   *     .build();
   *   String displayName = "UpdatedDisplayName";
   *   int memorySizeGb = 4;
   *   Instance instance = Instance.newBuilder()
   *     .setDisplayName(displayName)
   *     .setMemorySizeGb(memorySizeGb)
   *     .build();
   *   Instance response = cloudRedisClient.updateInstanceAsync(updateMask, instance).get();
   * }
   * </code></pre>
   *
   * @param updateMask Required. Mask of fields to update. At least one path must be supplied in
   *     this field. The elements of the repeated paths field may only include these fields from
   *     [Instance][CloudRedis.Instance]:
   *     <p>&#42; `displayName` &#42; `labels` &#42; `memorySizeGb` &#42; `redisConfig`
   * @param instance Required. Update description. Only fields specified in update_mask are updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Instance, OperationMetadata> updateInstanceAsync(
      FieldMask updateMask, Instance instance) {

    UpdateInstanceRequest request =
        UpdateInstanceRequest.newBuilder().setUpdateMask(updateMask).setInstance(instance).build();
    return updateInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the metadata and configuration of a specific Redis instance.
   *
   * <p>Completed longrunning.Operation will contain the new instance object in the response field.
   * The returned operation is automatically deleted after a few hours, so there is no need to call
   * DeleteOperation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   String pathsElement = "display_name";
   *   String pathsElement2 = "memory_size_gb";
   *   List&lt;String&gt; paths = Arrays.asList(pathsElement, pathsElement2);
   *   FieldMask updateMask = FieldMask.newBuilder()
   *     .addAllPaths(paths)
   *     .build();
   *   String displayName = "UpdatedDisplayName";
   *   int memorySizeGb = 4;
   *   Instance instance = Instance.newBuilder()
   *     .setDisplayName(displayName)
   *     .setMemorySizeGb(memorySizeGb)
   *     .build();
   *   UpdateInstanceRequest request = UpdateInstanceRequest.newBuilder()
   *     .setUpdateMask(updateMask)
   *     .setInstance(instance)
   *     .build();
   *   Instance response = cloudRedisClient.updateInstanceAsync(request).get();
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Instance, OperationMetadata> updateInstanceAsync(
      UpdateInstanceRequest request) {
    return updateInstanceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the metadata and configuration of a specific Redis instance.
   *
   * <p>Completed longrunning.Operation will contain the new instance object in the response field.
   * The returned operation is automatically deleted after a few hours, so there is no need to call
   * DeleteOperation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   String pathsElement = "display_name";
   *   String pathsElement2 = "memory_size_gb";
   *   List&lt;String&gt; paths = Arrays.asList(pathsElement, pathsElement2);
   *   FieldMask updateMask = FieldMask.newBuilder()
   *     .addAllPaths(paths)
   *     .build();
   *   String displayName = "UpdatedDisplayName";
   *   int memorySizeGb = 4;
   *   Instance instance = Instance.newBuilder()
   *     .setDisplayName(displayName)
   *     .setMemorySizeGb(memorySizeGb)
   *     .build();
   *   UpdateInstanceRequest request = UpdateInstanceRequest.newBuilder()
   *     .setUpdateMask(updateMask)
   *     .setInstance(instance)
   *     .build();
   *   OperationFuture&lt;Operation&gt; future = cloudRedisClient.updateInstanceOperationCallable().futureCall(request);
   *   // Do something
   *   Instance response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public final OperationCallable<UpdateInstanceRequest, Instance, OperationMetadata>
      updateInstanceOperationCallable() {
    return stub.updateInstanceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the metadata and configuration of a specific Redis instance.
   *
   * <p>Completed longrunning.Operation will contain the new instance object in the response field.
   * The returned operation is automatically deleted after a few hours, so there is no need to call
   * DeleteOperation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   String pathsElement = "display_name";
   *   String pathsElement2 = "memory_size_gb";
   *   List&lt;String&gt; paths = Arrays.asList(pathsElement, pathsElement2);
   *   FieldMask updateMask = FieldMask.newBuilder()
   *     .addAllPaths(paths)
   *     .build();
   *   String displayName = "UpdatedDisplayName";
   *   int memorySizeGb = 4;
   *   Instance instance = Instance.newBuilder()
   *     .setDisplayName(displayName)
   *     .setMemorySizeGb(memorySizeGb)
   *     .build();
   *   UpdateInstanceRequest request = UpdateInstanceRequest.newBuilder()
   *     .setUpdateMask(updateMask)
   *     .setInstance(instance)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = cloudRedisClient.updateInstanceCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<UpdateInstanceRequest, Operation> updateInstanceCallable() {
    return stub.updateInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a specific Redis instance. Instance stops serving and data is deleted.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   Empty response = cloudRedisClient.deleteInstanceAsync(name).get();
   * }
   * </code></pre>
   *
   * @param name Required. Redis instance resource name using the form:
   *     `projects/{project_id}/locations/{location_id}/instances/{instance_id}` where `location_id`
   *     refers to a GCP region
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Empty, OperationMetadata> deleteInstanceAsync(InstanceName name) {

    DeleteInstanceRequest request =
        DeleteInstanceRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a specific Redis instance. Instance stops serving and data is deleted.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   Empty response = cloudRedisClient.deleteInstanceAsync(name.toString()).get();
   * }
   * </code></pre>
   *
   * @param name Required. Redis instance resource name using the form:
   *     `projects/{project_id}/locations/{location_id}/instances/{instance_id}` where `location_id`
   *     refers to a GCP region
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Empty, OperationMetadata> deleteInstanceAsync(String name) {

    DeleteInstanceRequest request = DeleteInstanceRequest.newBuilder().setName(name).build();
    return deleteInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a specific Redis instance. Instance stops serving and data is deleted.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   DeleteInstanceRequest request = DeleteInstanceRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   Empty response = cloudRedisClient.deleteInstanceAsync(request).get();
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Empty, OperationMetadata> deleteInstanceAsync(
      DeleteInstanceRequest request) {
    return deleteInstanceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a specific Redis instance. Instance stops serving and data is deleted.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   DeleteInstanceRequest request = DeleteInstanceRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   OperationFuture&lt;Operation&gt; future = cloudRedisClient.deleteInstanceOperationCallable().futureCall(request);
   *   // Do something
   *   Empty response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public final OperationCallable<DeleteInstanceRequest, Empty, OperationMetadata>
      deleteInstanceOperationCallable() {
    return stub.deleteInstanceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a specific Redis instance. Instance stops serving and data is deleted.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudRedisClient cloudRedisClient = CloudRedisClient.create()) {
   *   InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   DeleteInstanceRequest request = DeleteInstanceRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = cloudRedisClient.deleteInstanceCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteInstanceRequest, Operation> deleteInstanceCallable() {
    return stub.deleteInstanceCallable();
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
          new ApiFunction<ListInstancesPage, ListInstancesPagedResponse>() {
            @Override
            public ListInstancesPagedResponse apply(ListInstancesPage input) {
              return new ListInstancesPagedResponse(input);
            }
          });
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
