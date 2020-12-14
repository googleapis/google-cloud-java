/*
 * Copyright 2020 Google LLC
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
import com.google.common.util.concurrent.MoreExecutors;
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
 * Service Description: Configures and manages Cloud Memorystore for Redis instances
 *
 * <p>Google Cloud Memorystore for Redis v1
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
 * CloudRedisSettings cloudRedisSettings =
 *     CloudRedisSettings.newBuilder().setEndpoint(myEndpoint).build();
 * CloudRedisClient cloudRedisClient = CloudRedisClient.create(cloudRedisSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator")
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
   * advanced usage - prefer using create(CloudRedisSettings).
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
  public final OperationsClient getOperationsClient() {
    return operationsClient;
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
   */
  public final UnaryCallable<ListInstancesRequest, ListInstancesResponse> listInstancesCallable() {
    return stub.listInstancesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a specific Redis instance.
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
   */
  public final UnaryCallable<GetInstanceRequest, Instance> getInstanceCallable() {
    return stub.getInstanceCallable();
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
   * functional. Completed longrunning.Operation will contain the new instance object in the
   * response field.
   *
   * <p>The returned operation is automatically deleted after a few hours, so there is no need to
   * call DeleteOperation.
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Redis instance based on the specified tier and memory size.
   *
   * <p>By default, the instance is accessible from the project's [default
   * network](https://cloud.google.com/vpc/docs/vpc).
   *
   * <p>The creation is executed asynchronously and callers may check the returned operation to
   * track its progress. Once the operation is completed the Redis instance will be fully
   * functional. Completed longrunning.Operation will contain the new instance object in the
   * response field.
   *
   * <p>The returned operation is automatically deleted after a few hours, so there is no need to
   * call DeleteOperation.
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Redis instance based on the specified tier and memory size.
   *
   * <p>By default, the instance is accessible from the project's [default
   * network](https://cloud.google.com/vpc/docs/vpc).
   *
   * <p>The creation is executed asynchronously and callers may check the returned operation to
   * track its progress. Once the operation is completed the Redis instance will be fully
   * functional. Completed longrunning.Operation will contain the new instance object in the
   * response field.
   *
   * <p>The returned operation is automatically deleted after a few hours, so there is no need to
   * call DeleteOperation.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> createInstanceAsync(
      CreateInstanceRequest request) {
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
   * functional. Completed longrunning.Operation will contain the new instance object in the
   * response field.
   *
   * <p>The returned operation is automatically deleted after a few hours, so there is no need to
   * call DeleteOperation.
   *
   * <p>Sample code:
   */
  public final OperationCallable<CreateInstanceRequest, Instance, OperationMetadata>
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
   * functional. Completed longrunning.Operation will contain the new instance object in the
   * response field.
   *
   * <p>The returned operation is automatically deleted after a few hours, so there is no need to
   * call DeleteOperation.
   *
   * <p>Sample code:
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
   * @param updateMask Required. Mask of fields to update. At least one path must be supplied in
   *     this field. The elements of the repeated paths field may only include these fields from
   *     [Instance][google.cloud.redis.v1.Instance]:
   *     <p>&#42; `displayName` &#42; `labels` &#42; `memorySizeGb` &#42; `redisConfig`
   * @param instance Required. Update description. Only fields specified in update_mask are updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> updateInstanceAsync(
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
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> updateInstanceAsync(
      UpdateInstanceRequest request) {
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
   */
  public final OperationCallable<UpdateInstanceRequest, Instance, OperationMetadata>
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
   */
  public final UnaryCallable<UpdateInstanceRequest, Operation> updateInstanceCallable() {
    return stub.updateInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Upgrades Redis instance to the newer Redis version specified in the request.
   *
   * @param name Required. Redis instance resource name using the form:
   *     `projects/{project_id}/locations/{location_id}/instances/{instance_id}` where `location_id`
   *     refers to a GCP region.
   * @param redisVersion Required. Specifies the target version of Redis software to upgrade to.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> upgradeInstanceAsync(
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
   * @param name Required. Redis instance resource name using the form:
   *     `projects/{project_id}/locations/{location_id}/instances/{instance_id}` where `location_id`
   *     refers to a GCP region.
   * @param redisVersion Required. Specifies the target version of Redis software to upgrade to.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> upgradeInstanceAsync(
      String name, String redisVersion) {
    UpgradeInstanceRequest request =
        UpgradeInstanceRequest.newBuilder().setName(name).setRedisVersion(redisVersion).build();
    return upgradeInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Upgrades Redis instance to the newer Redis version specified in the request.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> upgradeInstanceAsync(
      UpgradeInstanceRequest request) {
    return upgradeInstanceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Upgrades Redis instance to the newer Redis version specified in the request.
   *
   * <p>Sample code:
   */
  public final OperationCallable<UpgradeInstanceRequest, Instance, OperationMetadata>
      upgradeInstanceOperationCallable() {
    return stub.upgradeInstanceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Upgrades Redis instance to the newer Redis version specified in the request.
   *
   * <p>Sample code:
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
   * @param name Required. Redis instance resource name using the form:
   *     `projects/{project_id}/locations/{location_id}/instances/{instance_id}` where `location_id`
   *     refers to a GCP region.
   * @param inputConfig Required. Specify data to be imported.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> importInstanceAsync(
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
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> importInstanceAsync(
      ImportInstanceRequest request) {
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
   */
  public final OperationCallable<ImportInstanceRequest, Instance, OperationMetadata>
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
   * @param name Required. Redis instance resource name using the form:
   *     `projects/{project_id}/locations/{location_id}/instances/{instance_id}` where `location_id`
   *     refers to a GCP region.
   * @param outputConfig Required. Specify data to be exported.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> exportInstanceAsync(
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
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> exportInstanceAsync(
      ExportInstanceRequest request) {
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
   */
  public final OperationCallable<ExportInstanceRequest, Instance, OperationMetadata>
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
   */
  public final UnaryCallable<ExportInstanceRequest, Operation> exportInstanceCallable() {
    return stub.exportInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates a failover of the master node to current replica node for a specific STANDARD tier
   * Cloud Memorystore for Redis instance.
   *
   * @param name Required. Redis instance resource name using the form:
   *     `projects/{project_id}/locations/{location_id}/instances/{instance_id}` where `location_id`
   *     refers to a GCP region.
   * @param dataProtectionMode Optional. Available data protection modes that the user can choose.
   *     If it's unspecified, data protection mode will be LIMITED_DATA_LOSS by default.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> failoverInstanceAsync(
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
   * Initiates a failover of the master node to current replica node for a specific STANDARD tier
   * Cloud Memorystore for Redis instance.
   *
   * @param name Required. Redis instance resource name using the form:
   *     `projects/{project_id}/locations/{location_id}/instances/{instance_id}` where `location_id`
   *     refers to a GCP region.
   * @param dataProtectionMode Optional. Available data protection modes that the user can choose.
   *     If it's unspecified, data protection mode will be LIMITED_DATA_LOSS by default.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> failoverInstanceAsync(
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
   * Initiates a failover of the master node to current replica node for a specific STANDARD tier
   * Cloud Memorystore for Redis instance.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> failoverInstanceAsync(
      FailoverInstanceRequest request) {
    return failoverInstanceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates a failover of the master node to current replica node for a specific STANDARD tier
   * Cloud Memorystore for Redis instance.
   *
   * <p>Sample code:
   */
  public final OperationCallable<FailoverInstanceRequest, Instance, OperationMetadata>
      failoverInstanceOperationCallable() {
    return stub.failoverInstanceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates a failover of the master node to current replica node for a specific STANDARD tier
   * Cloud Memorystore for Redis instance.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<FailoverInstanceRequest, Operation> failoverInstanceCallable() {
    return stub.failoverInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific Redis instance. Instance stops serving and data is deleted.
   *
   * @param name Required. Redis instance resource name using the form:
   *     `projects/{project_id}/locations/{location_id}/instances/{instance_id}` where `location_id`
   *     refers to a GCP region.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteInstanceAsync(InstanceName name) {
    DeleteInstanceRequest request =
        DeleteInstanceRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific Redis instance. Instance stops serving and data is deleted.
   *
   * @param name Required. Redis instance resource name using the form:
   *     `projects/{project_id}/locations/{location_id}/instances/{instance_id}` where `location_id`
   *     refers to a GCP region.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteInstanceAsync(String name) {
    DeleteInstanceRequest request = DeleteInstanceRequest.newBuilder().setName(name).build();
    return deleteInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific Redis instance. Instance stops serving and data is deleted.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteInstanceAsync(
      DeleteInstanceRequest request) {
    return deleteInstanceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific Redis instance. Instance stops serving and data is deleted.
   *
   * <p>Sample code:
   */
  public final OperationCallable<DeleteInstanceRequest, Empty, OperationMetadata>
      deleteInstanceOperationCallable() {
    return stub.deleteInstanceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific Redis instance. Instance stops serving and data is deleted.
   *
   * <p>Sample code:
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
          },
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
