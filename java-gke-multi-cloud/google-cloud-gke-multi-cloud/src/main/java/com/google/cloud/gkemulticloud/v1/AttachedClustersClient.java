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

package com.google.cloud.gkemulticloud.v1;

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
import com.google.cloud.gkemulticloud.v1.stub.AttachedClustersStub;
import com.google.cloud.gkemulticloud.v1.stub.AttachedClustersStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The AttachedClusters API provides a single centrally managed service to
 * register and manage Anthos attached clusters that run on customer's owned infrastructure.
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
 * try (AttachedClustersClient attachedClustersClient = AttachedClustersClient.create()) {
 *   AttachedClusterName name =
 *       AttachedClusterName.of("[PROJECT]", "[LOCATION]", "[ATTACHED_CLUSTER]");
 *   AttachedCluster response = attachedClustersClient.getAttachedCluster(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the AttachedClustersClient object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
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
 * <p>This class can be customized by passing in a custom instance of AttachedClustersSettings to
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
 * AttachedClustersSettings attachedClustersSettings =
 *     AttachedClustersSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * AttachedClustersClient attachedClustersClient =
 *     AttachedClustersClient.create(attachedClustersSettings);
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
 * AttachedClustersSettings attachedClustersSettings =
 *     AttachedClustersSettings.newBuilder().setEndpoint(myEndpoint).build();
 * AttachedClustersClient attachedClustersClient =
 *     AttachedClustersClient.create(attachedClustersSettings);
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
 * AttachedClustersSettings attachedClustersSettings =
 *     AttachedClustersSettings.newHttpJsonBuilder().build();
 * AttachedClustersClient attachedClustersClient =
 *     AttachedClustersClient.create(attachedClustersSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class AttachedClustersClient implements BackgroundResource {
  private final AttachedClustersSettings settings;
  private final AttachedClustersStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of AttachedClustersClient with default settings. */
  public static final AttachedClustersClient create() throws IOException {
    return create(AttachedClustersSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of AttachedClustersClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final AttachedClustersClient create(AttachedClustersSettings settings)
      throws IOException {
    return new AttachedClustersClient(settings);
  }

  /**
   * Constructs an instance of AttachedClustersClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(AttachedClustersSettings).
   */
  public static final AttachedClustersClient create(AttachedClustersStub stub) {
    return new AttachedClustersClient(stub);
  }

  /**
   * Constructs an instance of AttachedClustersClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected AttachedClustersClient(AttachedClustersSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((AttachedClustersStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected AttachedClustersClient(AttachedClustersStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final AttachedClustersSettings getSettings() {
    return settings;
  }

  public AttachedClustersStub getStub() {
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
   * Creates a new [AttachedCluster][google.cloud.gkemulticloud.v1.AttachedCluster] resource on a
   * given GCP project and region.
   *
   * <p>If successful, the response contains a newly created
   * [Operation][google.longrunning.Operation] resource that can be described to track the status of
   * the operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AttachedClustersClient attachedClustersClient = AttachedClustersClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   AttachedCluster attachedCluster = AttachedCluster.newBuilder().build();
   *   String attachedClusterId = "attachedClusterId865943409";
   *   AttachedCluster response =
   *       attachedClustersClient
   *           .createAttachedClusterAsync(parent, attachedCluster, attachedClusterId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent location where this
   *     [AttachedCluster][google.cloud.gkemulticloud.v1.AttachedCluster] resource will be created.
   *     <p>Location names are formatted as `projects/&lt;project-id&gt;/locations/&lt;region&gt;`.
   *     <p>See [Resource Names](https://cloud.google.com/apis/design/resource_names) for more
   *     details on Google Cloud resource names.
   * @param attachedCluster Required. The specification of the
   *     [AttachedCluster][google.cloud.gkemulticloud.v1.AttachedCluster] to create.
   * @param attachedClusterId Required. A client provided ID the resource. Must be unique within the
   *     parent resource.
   *     <p>The provided ID will be part of the
   *     [AttachedCluster][google.cloud.gkemulticloud.v1.AttachedCluster] resource name formatted as
   *     `projects/&lt;project-id&gt;/locations/&lt;region&gt;/attachedClusters/&lt;cluster-id&gt;`.
   *     <p>Valid characters are `/[a-z][0-9]-/`. Cannot be longer than 63 characters.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AttachedCluster, OperationMetadata> createAttachedClusterAsync(
      LocationName parent, AttachedCluster attachedCluster, String attachedClusterId) {
    CreateAttachedClusterRequest request =
        CreateAttachedClusterRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setAttachedCluster(attachedCluster)
            .setAttachedClusterId(attachedClusterId)
            .build();
    return createAttachedClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new [AttachedCluster][google.cloud.gkemulticloud.v1.AttachedCluster] resource on a
   * given GCP project and region.
   *
   * <p>If successful, the response contains a newly created
   * [Operation][google.longrunning.Operation] resource that can be described to track the status of
   * the operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AttachedClustersClient attachedClustersClient = AttachedClustersClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   AttachedCluster attachedCluster = AttachedCluster.newBuilder().build();
   *   String attachedClusterId = "attachedClusterId865943409";
   *   AttachedCluster response =
   *       attachedClustersClient
   *           .createAttachedClusterAsync(parent, attachedCluster, attachedClusterId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent location where this
   *     [AttachedCluster][google.cloud.gkemulticloud.v1.AttachedCluster] resource will be created.
   *     <p>Location names are formatted as `projects/&lt;project-id&gt;/locations/&lt;region&gt;`.
   *     <p>See [Resource Names](https://cloud.google.com/apis/design/resource_names) for more
   *     details on Google Cloud resource names.
   * @param attachedCluster Required. The specification of the
   *     [AttachedCluster][google.cloud.gkemulticloud.v1.AttachedCluster] to create.
   * @param attachedClusterId Required. A client provided ID the resource. Must be unique within the
   *     parent resource.
   *     <p>The provided ID will be part of the
   *     [AttachedCluster][google.cloud.gkemulticloud.v1.AttachedCluster] resource name formatted as
   *     `projects/&lt;project-id&gt;/locations/&lt;region&gt;/attachedClusters/&lt;cluster-id&gt;`.
   *     <p>Valid characters are `/[a-z][0-9]-/`. Cannot be longer than 63 characters.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AttachedCluster, OperationMetadata> createAttachedClusterAsync(
      String parent, AttachedCluster attachedCluster, String attachedClusterId) {
    CreateAttachedClusterRequest request =
        CreateAttachedClusterRequest.newBuilder()
            .setParent(parent)
            .setAttachedCluster(attachedCluster)
            .setAttachedClusterId(attachedClusterId)
            .build();
    return createAttachedClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new [AttachedCluster][google.cloud.gkemulticloud.v1.AttachedCluster] resource on a
   * given GCP project and region.
   *
   * <p>If successful, the response contains a newly created
   * [Operation][google.longrunning.Operation] resource that can be described to track the status of
   * the operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AttachedClustersClient attachedClustersClient = AttachedClustersClient.create()) {
   *   CreateAttachedClusterRequest request =
   *       CreateAttachedClusterRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setAttachedCluster(AttachedCluster.newBuilder().build())
   *           .setAttachedClusterId("attachedClusterId865943409")
   *           .setValidateOnly(true)
   *           .build();
   *   AttachedCluster response = attachedClustersClient.createAttachedClusterAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AttachedCluster, OperationMetadata> createAttachedClusterAsync(
      CreateAttachedClusterRequest request) {
    return createAttachedClusterOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new [AttachedCluster][google.cloud.gkemulticloud.v1.AttachedCluster] resource on a
   * given GCP project and region.
   *
   * <p>If successful, the response contains a newly created
   * [Operation][google.longrunning.Operation] resource that can be described to track the status of
   * the operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AttachedClustersClient attachedClustersClient = AttachedClustersClient.create()) {
   *   CreateAttachedClusterRequest request =
   *       CreateAttachedClusterRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setAttachedCluster(AttachedCluster.newBuilder().build())
   *           .setAttachedClusterId("attachedClusterId865943409")
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<AttachedCluster, OperationMetadata> future =
   *       attachedClustersClient.createAttachedClusterOperationCallable().futureCall(request);
   *   // Do something.
   *   AttachedCluster response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateAttachedClusterRequest, AttachedCluster, OperationMetadata>
      createAttachedClusterOperationCallable() {
    return stub.createAttachedClusterOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new [AttachedCluster][google.cloud.gkemulticloud.v1.AttachedCluster] resource on a
   * given GCP project and region.
   *
   * <p>If successful, the response contains a newly created
   * [Operation][google.longrunning.Operation] resource that can be described to track the status of
   * the operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AttachedClustersClient attachedClustersClient = AttachedClustersClient.create()) {
   *   CreateAttachedClusterRequest request =
   *       CreateAttachedClusterRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setAttachedCluster(AttachedCluster.newBuilder().build())
   *           .setAttachedClusterId("attachedClusterId865943409")
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       attachedClustersClient.createAttachedClusterCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateAttachedClusterRequest, Operation>
      createAttachedClusterCallable() {
    return stub.createAttachedClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an [AttachedCluster][google.cloud.gkemulticloud.v1.AttachedCluster].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AttachedClustersClient attachedClustersClient = AttachedClustersClient.create()) {
   *   AttachedCluster attachedCluster = AttachedCluster.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   AttachedCluster response =
   *       attachedClustersClient.updateAttachedClusterAsync(attachedCluster, updateMask).get();
   * }
   * }</pre>
   *
   * @param attachedCluster Required. The
   *     [AttachedCluster][google.cloud.gkemulticloud.v1.AttachedCluster] resource to update.
   * @param updateMask Required. Mask of fields to update. At least one path must be supplied in
   *     this field. The elements of the repeated paths field can only include these fields from
   *     [AttachedCluster][google.cloud.gkemulticloud.v1.AttachedCluster]:
   *     <p>&#42; `description`. &#42; `annotations`. &#42; `platform_version`. &#42;
   *     `authorization.admin_users`. &#42; `logging_config.component_config.enable_components`.
   *     &#42; `monitoring_config.managed_prometheus_config.enabled`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AttachedCluster, OperationMetadata> updateAttachedClusterAsync(
      AttachedCluster attachedCluster, FieldMask updateMask) {
    UpdateAttachedClusterRequest request =
        UpdateAttachedClusterRequest.newBuilder()
            .setAttachedCluster(attachedCluster)
            .setUpdateMask(updateMask)
            .build();
    return updateAttachedClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an [AttachedCluster][google.cloud.gkemulticloud.v1.AttachedCluster].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AttachedClustersClient attachedClustersClient = AttachedClustersClient.create()) {
   *   UpdateAttachedClusterRequest request =
   *       UpdateAttachedClusterRequest.newBuilder()
   *           .setAttachedCluster(AttachedCluster.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   AttachedCluster response = attachedClustersClient.updateAttachedClusterAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AttachedCluster, OperationMetadata> updateAttachedClusterAsync(
      UpdateAttachedClusterRequest request) {
    return updateAttachedClusterOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an [AttachedCluster][google.cloud.gkemulticloud.v1.AttachedCluster].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AttachedClustersClient attachedClustersClient = AttachedClustersClient.create()) {
   *   UpdateAttachedClusterRequest request =
   *       UpdateAttachedClusterRequest.newBuilder()
   *           .setAttachedCluster(AttachedCluster.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<AttachedCluster, OperationMetadata> future =
   *       attachedClustersClient.updateAttachedClusterOperationCallable().futureCall(request);
   *   // Do something.
   *   AttachedCluster response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateAttachedClusterRequest, AttachedCluster, OperationMetadata>
      updateAttachedClusterOperationCallable() {
    return stub.updateAttachedClusterOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an [AttachedCluster][google.cloud.gkemulticloud.v1.AttachedCluster].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AttachedClustersClient attachedClustersClient = AttachedClustersClient.create()) {
   *   UpdateAttachedClusterRequest request =
   *       UpdateAttachedClusterRequest.newBuilder()
   *           .setAttachedCluster(AttachedCluster.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       attachedClustersClient.updateAttachedClusterCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateAttachedClusterRequest, Operation>
      updateAttachedClusterCallable() {
    return stub.updateAttachedClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports creates a new [AttachedCluster][google.cloud.gkemulticloud.v1.AttachedCluster] resource
   * by importing an existing Fleet Membership resource.
   *
   * <p>Attached Clusters created before the introduction of the Anthos Multi-Cloud API can be
   * imported through this method.
   *
   * <p>If successful, the response contains a newly created
   * [Operation][google.longrunning.Operation] resource that can be described to track the status of
   * the operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AttachedClustersClient attachedClustersClient = AttachedClustersClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   String fleetMembership = "fleetMembership-665479228";
   *   AttachedCluster response =
   *       attachedClustersClient.importAttachedClusterAsync(parent, fleetMembership).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent location where this
   *     [AttachedCluster][google.cloud.gkemulticloud.v1.AttachedCluster] resource will be created.
   *     <p>Location names are formatted as `projects/&lt;project-id&gt;/locations/&lt;region&gt;`.
   *     <p>See [Resource Names](https://cloud.google.com/apis/design/resource_names) for more
   *     details on Google Cloud resource names.
   * @param fleetMembership Required. The name of the fleet membership resource to import.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AttachedCluster, OperationMetadata> importAttachedClusterAsync(
      LocationName parent, String fleetMembership) {
    ImportAttachedClusterRequest request =
        ImportAttachedClusterRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setFleetMembership(fleetMembership)
            .build();
    return importAttachedClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports creates a new [AttachedCluster][google.cloud.gkemulticloud.v1.AttachedCluster] resource
   * by importing an existing Fleet Membership resource.
   *
   * <p>Attached Clusters created before the introduction of the Anthos Multi-Cloud API can be
   * imported through this method.
   *
   * <p>If successful, the response contains a newly created
   * [Operation][google.longrunning.Operation] resource that can be described to track the status of
   * the operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AttachedClustersClient attachedClustersClient = AttachedClustersClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   String fleetMembership = "fleetMembership-665479228";
   *   AttachedCluster response =
   *       attachedClustersClient.importAttachedClusterAsync(parent, fleetMembership).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent location where this
   *     [AttachedCluster][google.cloud.gkemulticloud.v1.AttachedCluster] resource will be created.
   *     <p>Location names are formatted as `projects/&lt;project-id&gt;/locations/&lt;region&gt;`.
   *     <p>See [Resource Names](https://cloud.google.com/apis/design/resource_names) for more
   *     details on Google Cloud resource names.
   * @param fleetMembership Required. The name of the fleet membership resource to import.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AttachedCluster, OperationMetadata> importAttachedClusterAsync(
      String parent, String fleetMembership) {
    ImportAttachedClusterRequest request =
        ImportAttachedClusterRequest.newBuilder()
            .setParent(parent)
            .setFleetMembership(fleetMembership)
            .build();
    return importAttachedClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports creates a new [AttachedCluster][google.cloud.gkemulticloud.v1.AttachedCluster] resource
   * by importing an existing Fleet Membership resource.
   *
   * <p>Attached Clusters created before the introduction of the Anthos Multi-Cloud API can be
   * imported through this method.
   *
   * <p>If successful, the response contains a newly created
   * [Operation][google.longrunning.Operation] resource that can be described to track the status of
   * the operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AttachedClustersClient attachedClustersClient = AttachedClustersClient.create()) {
   *   ImportAttachedClusterRequest request =
   *       ImportAttachedClusterRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setValidateOnly(true)
   *           .setFleetMembership("fleetMembership-665479228")
   *           .setPlatformVersion("platformVersion1848800485")
   *           .setDistribution("distribution-1580708220")
   *           .build();
   *   AttachedCluster response = attachedClustersClient.importAttachedClusterAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AttachedCluster, OperationMetadata> importAttachedClusterAsync(
      ImportAttachedClusterRequest request) {
    return importAttachedClusterOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports creates a new [AttachedCluster][google.cloud.gkemulticloud.v1.AttachedCluster] resource
   * by importing an existing Fleet Membership resource.
   *
   * <p>Attached Clusters created before the introduction of the Anthos Multi-Cloud API can be
   * imported through this method.
   *
   * <p>If successful, the response contains a newly created
   * [Operation][google.longrunning.Operation] resource that can be described to track the status of
   * the operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AttachedClustersClient attachedClustersClient = AttachedClustersClient.create()) {
   *   ImportAttachedClusterRequest request =
   *       ImportAttachedClusterRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setValidateOnly(true)
   *           .setFleetMembership("fleetMembership-665479228")
   *           .setPlatformVersion("platformVersion1848800485")
   *           .setDistribution("distribution-1580708220")
   *           .build();
   *   OperationFuture<AttachedCluster, OperationMetadata> future =
   *       attachedClustersClient.importAttachedClusterOperationCallable().futureCall(request);
   *   // Do something.
   *   AttachedCluster response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<ImportAttachedClusterRequest, AttachedCluster, OperationMetadata>
      importAttachedClusterOperationCallable() {
    return stub.importAttachedClusterOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports creates a new [AttachedCluster][google.cloud.gkemulticloud.v1.AttachedCluster] resource
   * by importing an existing Fleet Membership resource.
   *
   * <p>Attached Clusters created before the introduction of the Anthos Multi-Cloud API can be
   * imported through this method.
   *
   * <p>If successful, the response contains a newly created
   * [Operation][google.longrunning.Operation] resource that can be described to track the status of
   * the operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AttachedClustersClient attachedClustersClient = AttachedClustersClient.create()) {
   *   ImportAttachedClusterRequest request =
   *       ImportAttachedClusterRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setValidateOnly(true)
   *           .setFleetMembership("fleetMembership-665479228")
   *           .setPlatformVersion("platformVersion1848800485")
   *           .setDistribution("distribution-1580708220")
   *           .build();
   *   ApiFuture<Operation> future =
   *       attachedClustersClient.importAttachedClusterCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ImportAttachedClusterRequest, Operation>
      importAttachedClusterCallable() {
    return stub.importAttachedClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Describes a specific [AttachedCluster][google.cloud.gkemulticloud.v1.AttachedCluster] resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AttachedClustersClient attachedClustersClient = AttachedClustersClient.create()) {
   *   AttachedClusterName name =
   *       AttachedClusterName.of("[PROJECT]", "[LOCATION]", "[ATTACHED_CLUSTER]");
   *   AttachedCluster response = attachedClustersClient.getAttachedCluster(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the
   *     [AttachedCluster][google.cloud.gkemulticloud.v1.AttachedCluster] resource to describe.
   *     <p>`AttachedCluster` names are formatted as
   *     `projects/&lt;project-id&gt;/locations/&lt;region&gt;/attachedClusters/&lt;cluster-id&gt;`.
   *     <p>See [Resource Names](https://cloud.google.com/apis/design/resource_names) for more
   *     details on GCP resource names.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AttachedCluster getAttachedCluster(AttachedClusterName name) {
    GetAttachedClusterRequest request =
        GetAttachedClusterRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getAttachedCluster(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Describes a specific [AttachedCluster][google.cloud.gkemulticloud.v1.AttachedCluster] resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AttachedClustersClient attachedClustersClient = AttachedClustersClient.create()) {
   *   String name =
   *       AttachedClusterName.of("[PROJECT]", "[LOCATION]", "[ATTACHED_CLUSTER]").toString();
   *   AttachedCluster response = attachedClustersClient.getAttachedCluster(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the
   *     [AttachedCluster][google.cloud.gkemulticloud.v1.AttachedCluster] resource to describe.
   *     <p>`AttachedCluster` names are formatted as
   *     `projects/&lt;project-id&gt;/locations/&lt;region&gt;/attachedClusters/&lt;cluster-id&gt;`.
   *     <p>See [Resource Names](https://cloud.google.com/apis/design/resource_names) for more
   *     details on GCP resource names.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AttachedCluster getAttachedCluster(String name) {
    GetAttachedClusterRequest request =
        GetAttachedClusterRequest.newBuilder().setName(name).build();
    return getAttachedCluster(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Describes a specific [AttachedCluster][google.cloud.gkemulticloud.v1.AttachedCluster] resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AttachedClustersClient attachedClustersClient = AttachedClustersClient.create()) {
   *   GetAttachedClusterRequest request =
   *       GetAttachedClusterRequest.newBuilder()
   *           .setName(
   *               AttachedClusterName.of("[PROJECT]", "[LOCATION]", "[ATTACHED_CLUSTER]")
   *                   .toString())
   *           .build();
   *   AttachedCluster response = attachedClustersClient.getAttachedCluster(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AttachedCluster getAttachedCluster(GetAttachedClusterRequest request) {
    return getAttachedClusterCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Describes a specific [AttachedCluster][google.cloud.gkemulticloud.v1.AttachedCluster] resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AttachedClustersClient attachedClustersClient = AttachedClustersClient.create()) {
   *   GetAttachedClusterRequest request =
   *       GetAttachedClusterRequest.newBuilder()
   *           .setName(
   *               AttachedClusterName.of("[PROJECT]", "[LOCATION]", "[ATTACHED_CLUSTER]")
   *                   .toString())
   *           .build();
   *   ApiFuture<AttachedCluster> future =
   *       attachedClustersClient.getAttachedClusterCallable().futureCall(request);
   *   // Do something.
   *   AttachedCluster response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAttachedClusterRequest, AttachedCluster>
      getAttachedClusterCallable() {
    return stub.getAttachedClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all [AttachedCluster][google.cloud.gkemulticloud.v1.AttachedCluster] resources on a given
   * Google Cloud project and region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AttachedClustersClient attachedClustersClient = AttachedClustersClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (AttachedCluster element :
   *       attachedClustersClient.listAttachedClusters(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent location which owns this collection of
   *     [AttachedCluster][google.cloud.gkemulticloud.v1.AttachedCluster] resources.
   *     <p>Location names are formatted as `projects/&lt;project-id&gt;/locations/&lt;region&gt;`.
   *     <p>See [Resource Names](https://cloud.google.com/apis/design/resource_names) for more
   *     details on GCP resource names.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAttachedClustersPagedResponse listAttachedClusters(LocationName parent) {
    ListAttachedClustersRequest request =
        ListAttachedClustersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAttachedClusters(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all [AttachedCluster][google.cloud.gkemulticloud.v1.AttachedCluster] resources on a given
   * Google Cloud project and region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AttachedClustersClient attachedClustersClient = AttachedClustersClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (AttachedCluster element :
   *       attachedClustersClient.listAttachedClusters(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent location which owns this collection of
   *     [AttachedCluster][google.cloud.gkemulticloud.v1.AttachedCluster] resources.
   *     <p>Location names are formatted as `projects/&lt;project-id&gt;/locations/&lt;region&gt;`.
   *     <p>See [Resource Names](https://cloud.google.com/apis/design/resource_names) for more
   *     details on GCP resource names.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAttachedClustersPagedResponse listAttachedClusters(String parent) {
    ListAttachedClustersRequest request =
        ListAttachedClustersRequest.newBuilder().setParent(parent).build();
    return listAttachedClusters(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all [AttachedCluster][google.cloud.gkemulticloud.v1.AttachedCluster] resources on a given
   * Google Cloud project and region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AttachedClustersClient attachedClustersClient = AttachedClustersClient.create()) {
   *   ListAttachedClustersRequest request =
   *       ListAttachedClustersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (AttachedCluster element :
   *       attachedClustersClient.listAttachedClusters(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAttachedClustersPagedResponse listAttachedClusters(
      ListAttachedClustersRequest request) {
    return listAttachedClustersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all [AttachedCluster][google.cloud.gkemulticloud.v1.AttachedCluster] resources on a given
   * Google Cloud project and region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AttachedClustersClient attachedClustersClient = AttachedClustersClient.create()) {
   *   ListAttachedClustersRequest request =
   *       ListAttachedClustersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<AttachedCluster> future =
   *       attachedClustersClient.listAttachedClustersPagedCallable().futureCall(request);
   *   // Do something.
   *   for (AttachedCluster element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAttachedClustersRequest, ListAttachedClustersPagedResponse>
      listAttachedClustersPagedCallable() {
    return stub.listAttachedClustersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all [AttachedCluster][google.cloud.gkemulticloud.v1.AttachedCluster] resources on a given
   * Google Cloud project and region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AttachedClustersClient attachedClustersClient = AttachedClustersClient.create()) {
   *   ListAttachedClustersRequest request =
   *       ListAttachedClustersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListAttachedClustersResponse response =
   *         attachedClustersClient.listAttachedClustersCallable().call(request);
   *     for (AttachedCluster element : response.getAttachedClustersList()) {
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
  public final UnaryCallable<ListAttachedClustersRequest, ListAttachedClustersResponse>
      listAttachedClustersCallable() {
    return stub.listAttachedClustersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific [AttachedCluster][google.cloud.gkemulticloud.v1.AttachedCluster] resource.
   *
   * <p>If successful, the response contains a newly created
   * [Operation][google.longrunning.Operation] resource that can be described to track the status of
   * the operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AttachedClustersClient attachedClustersClient = AttachedClustersClient.create()) {
   *   AttachedClusterName name =
   *       AttachedClusterName.of("[PROJECT]", "[LOCATION]", "[ATTACHED_CLUSTER]");
   *   attachedClustersClient.deleteAttachedClusterAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name the
   *     [AttachedCluster][google.cloud.gkemulticloud.v1.AttachedCluster] to delete.
   *     <p>`AttachedCluster` names are formatted as
   *     `projects/&lt;project-id&gt;/locations/&lt;region&gt;/attachedClusters/&lt;cluster-id&gt;`.
   *     <p>See [Resource Names](https://cloud.google.com/apis/design/resource_names) for more
   *     details on GCP resource names.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteAttachedClusterAsync(
      AttachedClusterName name) {
    DeleteAttachedClusterRequest request =
        DeleteAttachedClusterRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteAttachedClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific [AttachedCluster][google.cloud.gkemulticloud.v1.AttachedCluster] resource.
   *
   * <p>If successful, the response contains a newly created
   * [Operation][google.longrunning.Operation] resource that can be described to track the status of
   * the operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AttachedClustersClient attachedClustersClient = AttachedClustersClient.create()) {
   *   String name =
   *       AttachedClusterName.of("[PROJECT]", "[LOCATION]", "[ATTACHED_CLUSTER]").toString();
   *   attachedClustersClient.deleteAttachedClusterAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name the
   *     [AttachedCluster][google.cloud.gkemulticloud.v1.AttachedCluster] to delete.
   *     <p>`AttachedCluster` names are formatted as
   *     `projects/&lt;project-id&gt;/locations/&lt;region&gt;/attachedClusters/&lt;cluster-id&gt;`.
   *     <p>See [Resource Names](https://cloud.google.com/apis/design/resource_names) for more
   *     details on GCP resource names.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteAttachedClusterAsync(String name) {
    DeleteAttachedClusterRequest request =
        DeleteAttachedClusterRequest.newBuilder().setName(name).build();
    return deleteAttachedClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific [AttachedCluster][google.cloud.gkemulticloud.v1.AttachedCluster] resource.
   *
   * <p>If successful, the response contains a newly created
   * [Operation][google.longrunning.Operation] resource that can be described to track the status of
   * the operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AttachedClustersClient attachedClustersClient = AttachedClustersClient.create()) {
   *   DeleteAttachedClusterRequest request =
   *       DeleteAttachedClusterRequest.newBuilder()
   *           .setName(
   *               AttachedClusterName.of("[PROJECT]", "[LOCATION]", "[ATTACHED_CLUSTER]")
   *                   .toString())
   *           .setValidateOnly(true)
   *           .setAllowMissing(true)
   *           .setIgnoreErrors(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   attachedClustersClient.deleteAttachedClusterAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteAttachedClusterAsync(
      DeleteAttachedClusterRequest request) {
    return deleteAttachedClusterOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific [AttachedCluster][google.cloud.gkemulticloud.v1.AttachedCluster] resource.
   *
   * <p>If successful, the response contains a newly created
   * [Operation][google.longrunning.Operation] resource that can be described to track the status of
   * the operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AttachedClustersClient attachedClustersClient = AttachedClustersClient.create()) {
   *   DeleteAttachedClusterRequest request =
   *       DeleteAttachedClusterRequest.newBuilder()
   *           .setName(
   *               AttachedClusterName.of("[PROJECT]", "[LOCATION]", "[ATTACHED_CLUSTER]")
   *                   .toString())
   *           .setValidateOnly(true)
   *           .setAllowMissing(true)
   *           .setIgnoreErrors(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       attachedClustersClient.deleteAttachedClusterOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteAttachedClusterRequest, Empty, OperationMetadata>
      deleteAttachedClusterOperationCallable() {
    return stub.deleteAttachedClusterOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific [AttachedCluster][google.cloud.gkemulticloud.v1.AttachedCluster] resource.
   *
   * <p>If successful, the response contains a newly created
   * [Operation][google.longrunning.Operation] resource that can be described to track the status of
   * the operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AttachedClustersClient attachedClustersClient = AttachedClustersClient.create()) {
   *   DeleteAttachedClusterRequest request =
   *       DeleteAttachedClusterRequest.newBuilder()
   *           .setName(
   *               AttachedClusterName.of("[PROJECT]", "[LOCATION]", "[ATTACHED_CLUSTER]")
   *                   .toString())
   *           .setValidateOnly(true)
   *           .setAllowMissing(true)
   *           .setIgnoreErrors(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Operation> future =
   *       attachedClustersClient.deleteAttachedClusterCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteAttachedClusterRequest, Operation>
      deleteAttachedClusterCallable() {
    return stub.deleteAttachedClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns information, such as supported Kubernetes versions, on a given Google Cloud location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AttachedClustersClient attachedClustersClient = AttachedClustersClient.create()) {
   *   AttachedServerConfigName name = AttachedServerConfigName.of("[PROJECT]", "[LOCATION]");
   *   AttachedServerConfig response = attachedClustersClient.getAttachedServerConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the
   *     [AttachedServerConfig][google.cloud.gkemulticloud.v1.AttachedServerConfig] resource to
   *     describe.
   *     <p>`AttachedServerConfig` names are formatted as
   *     `projects/&lt;project-id&gt;/locations/&lt;region&gt;/attachedServerConfig`.
   *     <p>See [Resource Names](https://cloud.google.com/apis/design/resource_names) for more
   *     details on Google Cloud resource names.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AttachedServerConfig getAttachedServerConfig(AttachedServerConfigName name) {
    GetAttachedServerConfigRequest request =
        GetAttachedServerConfigRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getAttachedServerConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns information, such as supported Kubernetes versions, on a given Google Cloud location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AttachedClustersClient attachedClustersClient = AttachedClustersClient.create()) {
   *   String name = AttachedServerConfigName.of("[PROJECT]", "[LOCATION]").toString();
   *   AttachedServerConfig response = attachedClustersClient.getAttachedServerConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the
   *     [AttachedServerConfig][google.cloud.gkemulticloud.v1.AttachedServerConfig] resource to
   *     describe.
   *     <p>`AttachedServerConfig` names are formatted as
   *     `projects/&lt;project-id&gt;/locations/&lt;region&gt;/attachedServerConfig`.
   *     <p>See [Resource Names](https://cloud.google.com/apis/design/resource_names) for more
   *     details on Google Cloud resource names.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AttachedServerConfig getAttachedServerConfig(String name) {
    GetAttachedServerConfigRequest request =
        GetAttachedServerConfigRequest.newBuilder().setName(name).build();
    return getAttachedServerConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns information, such as supported Kubernetes versions, on a given Google Cloud location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AttachedClustersClient attachedClustersClient = AttachedClustersClient.create()) {
   *   GetAttachedServerConfigRequest request =
   *       GetAttachedServerConfigRequest.newBuilder()
   *           .setName(AttachedServerConfigName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   AttachedServerConfig response = attachedClustersClient.getAttachedServerConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AttachedServerConfig getAttachedServerConfig(
      GetAttachedServerConfigRequest request) {
    return getAttachedServerConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns information, such as supported Kubernetes versions, on a given Google Cloud location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AttachedClustersClient attachedClustersClient = AttachedClustersClient.create()) {
   *   GetAttachedServerConfigRequest request =
   *       GetAttachedServerConfigRequest.newBuilder()
   *           .setName(AttachedServerConfigName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   ApiFuture<AttachedServerConfig> future =
   *       attachedClustersClient.getAttachedServerConfigCallable().futureCall(request);
   *   // Do something.
   *   AttachedServerConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAttachedServerConfigRequest, AttachedServerConfig>
      getAttachedServerConfigCallable() {
    return stub.getAttachedServerConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates the install manifest to be installed on the target cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AttachedClustersClient attachedClustersClient = AttachedClustersClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   String attachedClusterId = "attachedClusterId865943409";
   *   GenerateAttachedClusterInstallManifestResponse response =
   *       attachedClustersClient.generateAttachedClusterInstallManifest(parent, attachedClusterId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent location where this
   *     [AttachedCluster][google.cloud.gkemulticloud.v1.AttachedCluster] resource will be created.
   *     <p>Location names are formatted as `projects/&lt;project-id&gt;/locations/&lt;region&gt;`.
   *     <p>See [Resource Names](https://cloud.google.com/apis/design/resource_names) for more
   *     details on Google Cloud resource names.
   * @param attachedClusterId Required. A client provided ID the resource. Must be unique within the
   *     parent resource.
   *     <p>The provided ID will be part of the
   *     [AttachedCluster][google.cloud.gkemulticloud.v1.AttachedCluster] resource name formatted as
   *     `projects/&lt;project-id&gt;/locations/&lt;region&gt;/attachedClusters/&lt;cluster-id&gt;`.
   *     <p>Valid characters are `/[a-z][0-9]-/`. Cannot be longer than 63 characters.
   *     <p>When generating an install manifest for importing an existing Membership resource, the
   *     attached_cluster_id field must be the Membership id.
   *     <p>Membership names are formatted as `resource name formatted as
   *     `projects/&lt;project-id&gt;/locations/&lt;region&gt;/memberships/&lt;membership-id&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerateAttachedClusterInstallManifestResponse
      generateAttachedClusterInstallManifest(LocationName parent, String attachedClusterId) {
    GenerateAttachedClusterInstallManifestRequest request =
        GenerateAttachedClusterInstallManifestRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setAttachedClusterId(attachedClusterId)
            .build();
    return generateAttachedClusterInstallManifest(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates the install manifest to be installed on the target cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AttachedClustersClient attachedClustersClient = AttachedClustersClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   String attachedClusterId = "attachedClusterId865943409";
   *   GenerateAttachedClusterInstallManifestResponse response =
   *       attachedClustersClient.generateAttachedClusterInstallManifest(parent, attachedClusterId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent location where this
   *     [AttachedCluster][google.cloud.gkemulticloud.v1.AttachedCluster] resource will be created.
   *     <p>Location names are formatted as `projects/&lt;project-id&gt;/locations/&lt;region&gt;`.
   *     <p>See [Resource Names](https://cloud.google.com/apis/design/resource_names) for more
   *     details on Google Cloud resource names.
   * @param attachedClusterId Required. A client provided ID the resource. Must be unique within the
   *     parent resource.
   *     <p>The provided ID will be part of the
   *     [AttachedCluster][google.cloud.gkemulticloud.v1.AttachedCluster] resource name formatted as
   *     `projects/&lt;project-id&gt;/locations/&lt;region&gt;/attachedClusters/&lt;cluster-id&gt;`.
   *     <p>Valid characters are `/[a-z][0-9]-/`. Cannot be longer than 63 characters.
   *     <p>When generating an install manifest for importing an existing Membership resource, the
   *     attached_cluster_id field must be the Membership id.
   *     <p>Membership names are formatted as `resource name formatted as
   *     `projects/&lt;project-id&gt;/locations/&lt;region&gt;/memberships/&lt;membership-id&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerateAttachedClusterInstallManifestResponse
      generateAttachedClusterInstallManifest(String parent, String attachedClusterId) {
    GenerateAttachedClusterInstallManifestRequest request =
        GenerateAttachedClusterInstallManifestRequest.newBuilder()
            .setParent(parent)
            .setAttachedClusterId(attachedClusterId)
            .build();
    return generateAttachedClusterInstallManifest(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates the install manifest to be installed on the target cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AttachedClustersClient attachedClustersClient = AttachedClustersClient.create()) {
   *   GenerateAttachedClusterInstallManifestRequest request =
   *       GenerateAttachedClusterInstallManifestRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setAttachedClusterId("attachedClusterId865943409")
   *           .setPlatformVersion("platformVersion1848800485")
   *           .build();
   *   GenerateAttachedClusterInstallManifestResponse response =
   *       attachedClustersClient.generateAttachedClusterInstallManifest(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerateAttachedClusterInstallManifestResponse
      generateAttachedClusterInstallManifest(
          GenerateAttachedClusterInstallManifestRequest request) {
    return generateAttachedClusterInstallManifestCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates the install manifest to be installed on the target cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AttachedClustersClient attachedClustersClient = AttachedClustersClient.create()) {
   *   GenerateAttachedClusterInstallManifestRequest request =
   *       GenerateAttachedClusterInstallManifestRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setAttachedClusterId("attachedClusterId865943409")
   *           .setPlatformVersion("platformVersion1848800485")
   *           .build();
   *   ApiFuture<GenerateAttachedClusterInstallManifestResponse> future =
   *       attachedClustersClient
   *           .generateAttachedClusterInstallManifestCallable()
   *           .futureCall(request);
   *   // Do something.
   *   GenerateAttachedClusterInstallManifestResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          GenerateAttachedClusterInstallManifestRequest,
          GenerateAttachedClusterInstallManifestResponse>
      generateAttachedClusterInstallManifestCallable() {
    return stub.generateAttachedClusterInstallManifestCallable();
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

  public static class ListAttachedClustersPagedResponse
      extends AbstractPagedListResponse<
          ListAttachedClustersRequest,
          ListAttachedClustersResponse,
          AttachedCluster,
          ListAttachedClustersPage,
          ListAttachedClustersFixedSizeCollection> {

    public static ApiFuture<ListAttachedClustersPagedResponse> createAsync(
        PageContext<ListAttachedClustersRequest, ListAttachedClustersResponse, AttachedCluster>
            context,
        ApiFuture<ListAttachedClustersResponse> futureResponse) {
      ApiFuture<ListAttachedClustersPage> futurePage =
          ListAttachedClustersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAttachedClustersPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAttachedClustersPagedResponse(ListAttachedClustersPage page) {
      super(page, ListAttachedClustersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAttachedClustersPage
      extends AbstractPage<
          ListAttachedClustersRequest,
          ListAttachedClustersResponse,
          AttachedCluster,
          ListAttachedClustersPage> {

    private ListAttachedClustersPage(
        PageContext<ListAttachedClustersRequest, ListAttachedClustersResponse, AttachedCluster>
            context,
        ListAttachedClustersResponse response) {
      super(context, response);
    }

    private static ListAttachedClustersPage createEmptyPage() {
      return new ListAttachedClustersPage(null, null);
    }

    @Override
    protected ListAttachedClustersPage createPage(
        PageContext<ListAttachedClustersRequest, ListAttachedClustersResponse, AttachedCluster>
            context,
        ListAttachedClustersResponse response) {
      return new ListAttachedClustersPage(context, response);
    }

    @Override
    public ApiFuture<ListAttachedClustersPage> createPageAsync(
        PageContext<ListAttachedClustersRequest, ListAttachedClustersResponse, AttachedCluster>
            context,
        ApiFuture<ListAttachedClustersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAttachedClustersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAttachedClustersRequest,
          ListAttachedClustersResponse,
          AttachedCluster,
          ListAttachedClustersPage,
          ListAttachedClustersFixedSizeCollection> {

    private ListAttachedClustersFixedSizeCollection(
        List<ListAttachedClustersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAttachedClustersFixedSizeCollection createEmptyCollection() {
      return new ListAttachedClustersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAttachedClustersFixedSizeCollection createCollection(
        List<ListAttachedClustersPage> pages, int collectionSize) {
      return new ListAttachedClustersFixedSizeCollection(pages, collectionSize);
    }
  }
}
