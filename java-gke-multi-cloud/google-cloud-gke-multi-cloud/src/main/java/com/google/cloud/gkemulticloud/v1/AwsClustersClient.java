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
import com.google.cloud.gkemulticloud.v1.stub.AwsClustersStub;
import com.google.cloud.gkemulticloud.v1.stub.AwsClustersStubSettings;
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
 * Service Description: The AwsClusters API provides a single centrally managed service to create
 * and manage Anthos clusters that run on AWS infrastructure.
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
 * try (AwsClustersClient awsClustersClient = AwsClustersClient.create()) {
 *   AwsClusterName name = AwsClusterName.of("[PROJECT]", "[LOCATION]", "[AWS_CLUSTER]");
 *   AwsCluster response = awsClustersClient.getAwsCluster(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the AwsClustersClient object to clean up resources such as
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
 * <p>This class can be customized by passing in a custom instance of AwsClustersSettings to
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
 * AwsClustersSettings awsClustersSettings =
 *     AwsClustersSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * AwsClustersClient awsClustersClient = AwsClustersClient.create(awsClustersSettings);
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
 * AwsClustersSettings awsClustersSettings =
 *     AwsClustersSettings.newBuilder().setEndpoint(myEndpoint).build();
 * AwsClustersClient awsClustersClient = AwsClustersClient.create(awsClustersSettings);
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
 * AwsClustersSettings awsClustersSettings = AwsClustersSettings.newHttpJsonBuilder().build();
 * AwsClustersClient awsClustersClient = AwsClustersClient.create(awsClustersSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class AwsClustersClient implements BackgroundResource {
  private final AwsClustersSettings settings;
  private final AwsClustersStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of AwsClustersClient with default settings. */
  public static final AwsClustersClient create() throws IOException {
    return create(AwsClustersSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of AwsClustersClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final AwsClustersClient create(AwsClustersSettings settings) throws IOException {
    return new AwsClustersClient(settings);
  }

  /**
   * Constructs an instance of AwsClustersClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(AwsClustersSettings).
   */
  public static final AwsClustersClient create(AwsClustersStub stub) {
    return new AwsClustersClient(stub);
  }

  /**
   * Constructs an instance of AwsClustersClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected AwsClustersClient(AwsClustersSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((AwsClustersStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected AwsClustersClient(AwsClustersStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final AwsClustersSettings getSettings() {
    return settings;
  }

  public AwsClustersStub getStub() {
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
   * Creates a new [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster] resource on a given GCP
   * project and region.
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
   * try (AwsClustersClient awsClustersClient = AwsClustersClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   AwsCluster awsCluster = AwsCluster.newBuilder().build();
   *   String awsClusterId = "awsClusterId1988965944";
   *   AwsCluster response =
   *       awsClustersClient.createAwsClusterAsync(parent, awsCluster, awsClusterId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent location where this
   *     [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster] resource will be created.
   *     <p>Location names are formatted as `projects/&lt;project-id&gt;/locations/&lt;region&gt;`.
   *     <p>See [Resource Names](https://cloud.google.com/apis/design/resource_names) for more
   *     details on Google Cloud resource names.
   * @param awsCluster Required. The specification of the
   *     [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster] to create.
   * @param awsClusterId Required. A client provided ID the resource. Must be unique within the
   *     parent resource.
   *     <p>The provided ID will be part of the
   *     [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster] resource name formatted as
   *     `projects/&lt;project-id&gt;/locations/&lt;region&gt;/awsClusters/&lt;cluster-id&gt;`.
   *     <p>Valid characters are `/[a-z][0-9]-/`. Cannot be longer than 40 characters.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AwsCluster, OperationMetadata> createAwsClusterAsync(
      LocationName parent, AwsCluster awsCluster, String awsClusterId) {
    CreateAwsClusterRequest request =
        CreateAwsClusterRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setAwsCluster(awsCluster)
            .setAwsClusterId(awsClusterId)
            .build();
    return createAwsClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster] resource on a given GCP
   * project and region.
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
   * try (AwsClustersClient awsClustersClient = AwsClustersClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   AwsCluster awsCluster = AwsCluster.newBuilder().build();
   *   String awsClusterId = "awsClusterId1988965944";
   *   AwsCluster response =
   *       awsClustersClient.createAwsClusterAsync(parent, awsCluster, awsClusterId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent location where this
   *     [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster] resource will be created.
   *     <p>Location names are formatted as `projects/&lt;project-id&gt;/locations/&lt;region&gt;`.
   *     <p>See [Resource Names](https://cloud.google.com/apis/design/resource_names) for more
   *     details on Google Cloud resource names.
   * @param awsCluster Required. The specification of the
   *     [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster] to create.
   * @param awsClusterId Required. A client provided ID the resource. Must be unique within the
   *     parent resource.
   *     <p>The provided ID will be part of the
   *     [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster] resource name formatted as
   *     `projects/&lt;project-id&gt;/locations/&lt;region&gt;/awsClusters/&lt;cluster-id&gt;`.
   *     <p>Valid characters are `/[a-z][0-9]-/`. Cannot be longer than 40 characters.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AwsCluster, OperationMetadata> createAwsClusterAsync(
      String parent, AwsCluster awsCluster, String awsClusterId) {
    CreateAwsClusterRequest request =
        CreateAwsClusterRequest.newBuilder()
            .setParent(parent)
            .setAwsCluster(awsCluster)
            .setAwsClusterId(awsClusterId)
            .build();
    return createAwsClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster] resource on a given GCP
   * project and region.
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
   * try (AwsClustersClient awsClustersClient = AwsClustersClient.create()) {
   *   CreateAwsClusterRequest request =
   *       CreateAwsClusterRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setAwsCluster(AwsCluster.newBuilder().build())
   *           .setAwsClusterId("awsClusterId1988965944")
   *           .setValidateOnly(true)
   *           .build();
   *   AwsCluster response = awsClustersClient.createAwsClusterAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AwsCluster, OperationMetadata> createAwsClusterAsync(
      CreateAwsClusterRequest request) {
    return createAwsClusterOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster] resource on a given GCP
   * project and region.
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
   * try (AwsClustersClient awsClustersClient = AwsClustersClient.create()) {
   *   CreateAwsClusterRequest request =
   *       CreateAwsClusterRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setAwsCluster(AwsCluster.newBuilder().build())
   *           .setAwsClusterId("awsClusterId1988965944")
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<AwsCluster, OperationMetadata> future =
   *       awsClustersClient.createAwsClusterOperationCallable().futureCall(request);
   *   // Do something.
   *   AwsCluster response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateAwsClusterRequest, AwsCluster, OperationMetadata>
      createAwsClusterOperationCallable() {
    return stub.createAwsClusterOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster] resource on a given GCP
   * project and region.
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
   * try (AwsClustersClient awsClustersClient = AwsClustersClient.create()) {
   *   CreateAwsClusterRequest request =
   *       CreateAwsClusterRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setAwsCluster(AwsCluster.newBuilder().build())
   *           .setAwsClusterId("awsClusterId1988965944")
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       awsClustersClient.createAwsClusterCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateAwsClusterRequest, Operation> createAwsClusterCallable() {
    return stub.createAwsClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AwsClustersClient awsClustersClient = AwsClustersClient.create()) {
   *   AwsCluster awsCluster = AwsCluster.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   AwsCluster response = awsClustersClient.updateAwsClusterAsync(awsCluster, updateMask).get();
   * }
   * }</pre>
   *
   * @param awsCluster Required. The [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster] resource
   *     to update.
   * @param updateMask Required. Mask of fields to update. At least one path must be supplied in
   *     this field. The elements of the repeated paths field can only include these fields from
   *     [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster]:
   *     <p>&#42; `description`. &#42; `annotations`. &#42; `control_plane.version`. &#42;
   *     `authorization.admin_users`. &#42; `control_plane.aws_services_authentication.role_arn`.
   *     &#42; `control_plane.aws_services_authentication.role_session_name`. &#42;
   *     `control_plane.config_encryption.kms_key_arn`. &#42; `control_plane.instance_type`. &#42;
   *     `control_plane.security_group_ids`. &#42; `control_plane.proxy_config`. &#42;
   *     `control_plane.proxy_config.secret_arn`. &#42; `control_plane.proxy_config.secret_version`.
   *     &#42; `control_plane.root_volume.iops`. &#42; `control_plane.root_volume.kms_key_arn`.
   *     &#42; `control_plane.root_volume.volume_type`. &#42; `control_plane.root_volume.size_gib`.
   *     &#42; `control_plane.ssh_config`. &#42; `control_plane.ssh_config.ec2_key_pair`. &#42;
   *     `control_plane.instance_placement.tenancy`. &#42; `logging_config`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AwsCluster, OperationMetadata> updateAwsClusterAsync(
      AwsCluster awsCluster, FieldMask updateMask) {
    UpdateAwsClusterRequest request =
        UpdateAwsClusterRequest.newBuilder()
            .setAwsCluster(awsCluster)
            .setUpdateMask(updateMask)
            .build();
    return updateAwsClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AwsClustersClient awsClustersClient = AwsClustersClient.create()) {
   *   UpdateAwsClusterRequest request =
   *       UpdateAwsClusterRequest.newBuilder()
   *           .setAwsCluster(AwsCluster.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   AwsCluster response = awsClustersClient.updateAwsClusterAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AwsCluster, OperationMetadata> updateAwsClusterAsync(
      UpdateAwsClusterRequest request) {
    return updateAwsClusterOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AwsClustersClient awsClustersClient = AwsClustersClient.create()) {
   *   UpdateAwsClusterRequest request =
   *       UpdateAwsClusterRequest.newBuilder()
   *           .setAwsCluster(AwsCluster.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<AwsCluster, OperationMetadata> future =
   *       awsClustersClient.updateAwsClusterOperationCallable().futureCall(request);
   *   // Do something.
   *   AwsCluster response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateAwsClusterRequest, AwsCluster, OperationMetadata>
      updateAwsClusterOperationCallable() {
    return stub.updateAwsClusterOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AwsClustersClient awsClustersClient = AwsClustersClient.create()) {
   *   UpdateAwsClusterRequest request =
   *       UpdateAwsClusterRequest.newBuilder()
   *           .setAwsCluster(AwsCluster.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       awsClustersClient.updateAwsClusterCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateAwsClusterRequest, Operation> updateAwsClusterCallable() {
    return stub.updateAwsClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Describes a specific [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster] resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AwsClustersClient awsClustersClient = AwsClustersClient.create()) {
   *   AwsClusterName name = AwsClusterName.of("[PROJECT]", "[LOCATION]", "[AWS_CLUSTER]");
   *   AwsCluster response = awsClustersClient.getAwsCluster(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster]
   *     resource to describe.
   *     <p>`AwsCluster` names are formatted as
   *     `projects/&lt;project-id&gt;/locations/&lt;region&gt;/awsClusters/&lt;cluster-id&gt;`.
   *     <p>See [Resource Names](https://cloud.google.com/apis/design/resource_names) for more
   *     details on GCP resource names.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AwsCluster getAwsCluster(AwsClusterName name) {
    GetAwsClusterRequest request =
        GetAwsClusterRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getAwsCluster(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Describes a specific [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster] resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AwsClustersClient awsClustersClient = AwsClustersClient.create()) {
   *   String name = AwsClusterName.of("[PROJECT]", "[LOCATION]", "[AWS_CLUSTER]").toString();
   *   AwsCluster response = awsClustersClient.getAwsCluster(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster]
   *     resource to describe.
   *     <p>`AwsCluster` names are formatted as
   *     `projects/&lt;project-id&gt;/locations/&lt;region&gt;/awsClusters/&lt;cluster-id&gt;`.
   *     <p>See [Resource Names](https://cloud.google.com/apis/design/resource_names) for more
   *     details on GCP resource names.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AwsCluster getAwsCluster(String name) {
    GetAwsClusterRequest request = GetAwsClusterRequest.newBuilder().setName(name).build();
    return getAwsCluster(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Describes a specific [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster] resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AwsClustersClient awsClustersClient = AwsClustersClient.create()) {
   *   GetAwsClusterRequest request =
   *       GetAwsClusterRequest.newBuilder()
   *           .setName(AwsClusterName.of("[PROJECT]", "[LOCATION]", "[AWS_CLUSTER]").toString())
   *           .build();
   *   AwsCluster response = awsClustersClient.getAwsCluster(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AwsCluster getAwsCluster(GetAwsClusterRequest request) {
    return getAwsClusterCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Describes a specific [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster] resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AwsClustersClient awsClustersClient = AwsClustersClient.create()) {
   *   GetAwsClusterRequest request =
   *       GetAwsClusterRequest.newBuilder()
   *           .setName(AwsClusterName.of("[PROJECT]", "[LOCATION]", "[AWS_CLUSTER]").toString())
   *           .build();
   *   ApiFuture<AwsCluster> future = awsClustersClient.getAwsClusterCallable().futureCall(request);
   *   // Do something.
   *   AwsCluster response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAwsClusterRequest, AwsCluster> getAwsClusterCallable() {
    return stub.getAwsClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster] resources on a given Google
   * Cloud project and region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AwsClustersClient awsClustersClient = AwsClustersClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (AwsCluster element : awsClustersClient.listAwsClusters(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent location which owns this collection of
   *     [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster] resources.
   *     <p>Location names are formatted as `projects/&lt;project-id&gt;/locations/&lt;region&gt;`.
   *     <p>See [Resource Names](https://cloud.google.com/apis/design/resource_names) for more
   *     details on GCP resource names.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAwsClustersPagedResponse listAwsClusters(LocationName parent) {
    ListAwsClustersRequest request =
        ListAwsClustersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAwsClusters(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster] resources on a given Google
   * Cloud project and region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AwsClustersClient awsClustersClient = AwsClustersClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (AwsCluster element : awsClustersClient.listAwsClusters(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent location which owns this collection of
   *     [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster] resources.
   *     <p>Location names are formatted as `projects/&lt;project-id&gt;/locations/&lt;region&gt;`.
   *     <p>See [Resource Names](https://cloud.google.com/apis/design/resource_names) for more
   *     details on GCP resource names.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAwsClustersPagedResponse listAwsClusters(String parent) {
    ListAwsClustersRequest request = ListAwsClustersRequest.newBuilder().setParent(parent).build();
    return listAwsClusters(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster] resources on a given Google
   * Cloud project and region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AwsClustersClient awsClustersClient = AwsClustersClient.create()) {
   *   ListAwsClustersRequest request =
   *       ListAwsClustersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (AwsCluster element : awsClustersClient.listAwsClusters(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAwsClustersPagedResponse listAwsClusters(ListAwsClustersRequest request) {
    return listAwsClustersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster] resources on a given Google
   * Cloud project and region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AwsClustersClient awsClustersClient = AwsClustersClient.create()) {
   *   ListAwsClustersRequest request =
   *       ListAwsClustersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<AwsCluster> future =
   *       awsClustersClient.listAwsClustersPagedCallable().futureCall(request);
   *   // Do something.
   *   for (AwsCluster element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAwsClustersRequest, ListAwsClustersPagedResponse>
      listAwsClustersPagedCallable() {
    return stub.listAwsClustersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster] resources on a given Google
   * Cloud project and region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AwsClustersClient awsClustersClient = AwsClustersClient.create()) {
   *   ListAwsClustersRequest request =
   *       ListAwsClustersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListAwsClustersResponse response =
   *         awsClustersClient.listAwsClustersCallable().call(request);
   *     for (AwsCluster element : response.getAwsClustersList()) {
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
  public final UnaryCallable<ListAwsClustersRequest, ListAwsClustersResponse>
      listAwsClustersCallable() {
    return stub.listAwsClustersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster] resource.
   *
   * <p>Fails if the cluster has one or more associated
   * [AwsNodePool][google.cloud.gkemulticloud.v1.AwsNodePool] resources.
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
   * try (AwsClustersClient awsClustersClient = AwsClustersClient.create()) {
   *   AwsClusterName name = AwsClusterName.of("[PROJECT]", "[LOCATION]", "[AWS_CLUSTER]");
   *   awsClustersClient.deleteAwsClusterAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name the
   *     [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster] to delete.
   *     <p>`AwsCluster` names are formatted as
   *     `projects/&lt;project-id&gt;/locations/&lt;region&gt;/awsClusters/&lt;cluster-id&gt;`.
   *     <p>See [Resource Names](https://cloud.google.com/apis/design/resource_names) for more
   *     details on GCP resource names.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteAwsClusterAsync(
      AwsClusterName name) {
    DeleteAwsClusterRequest request =
        DeleteAwsClusterRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteAwsClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster] resource.
   *
   * <p>Fails if the cluster has one or more associated
   * [AwsNodePool][google.cloud.gkemulticloud.v1.AwsNodePool] resources.
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
   * try (AwsClustersClient awsClustersClient = AwsClustersClient.create()) {
   *   String name = AwsClusterName.of("[PROJECT]", "[LOCATION]", "[AWS_CLUSTER]").toString();
   *   awsClustersClient.deleteAwsClusterAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name the
   *     [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster] to delete.
   *     <p>`AwsCluster` names are formatted as
   *     `projects/&lt;project-id&gt;/locations/&lt;region&gt;/awsClusters/&lt;cluster-id&gt;`.
   *     <p>See [Resource Names](https://cloud.google.com/apis/design/resource_names) for more
   *     details on GCP resource names.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteAwsClusterAsync(String name) {
    DeleteAwsClusterRequest request = DeleteAwsClusterRequest.newBuilder().setName(name).build();
    return deleteAwsClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster] resource.
   *
   * <p>Fails if the cluster has one or more associated
   * [AwsNodePool][google.cloud.gkemulticloud.v1.AwsNodePool] resources.
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
   * try (AwsClustersClient awsClustersClient = AwsClustersClient.create()) {
   *   DeleteAwsClusterRequest request =
   *       DeleteAwsClusterRequest.newBuilder()
   *           .setName(AwsClusterName.of("[PROJECT]", "[LOCATION]", "[AWS_CLUSTER]").toString())
   *           .setValidateOnly(true)
   *           .setAllowMissing(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   awsClustersClient.deleteAwsClusterAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteAwsClusterAsync(
      DeleteAwsClusterRequest request) {
    return deleteAwsClusterOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster] resource.
   *
   * <p>Fails if the cluster has one or more associated
   * [AwsNodePool][google.cloud.gkemulticloud.v1.AwsNodePool] resources.
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
   * try (AwsClustersClient awsClustersClient = AwsClustersClient.create()) {
   *   DeleteAwsClusterRequest request =
   *       DeleteAwsClusterRequest.newBuilder()
   *           .setName(AwsClusterName.of("[PROJECT]", "[LOCATION]", "[AWS_CLUSTER]").toString())
   *           .setValidateOnly(true)
   *           .setAllowMissing(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       awsClustersClient.deleteAwsClusterOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteAwsClusterRequest, Empty, OperationMetadata>
      deleteAwsClusterOperationCallable() {
    return stub.deleteAwsClusterOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster] resource.
   *
   * <p>Fails if the cluster has one or more associated
   * [AwsNodePool][google.cloud.gkemulticloud.v1.AwsNodePool] resources.
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
   * try (AwsClustersClient awsClustersClient = AwsClustersClient.create()) {
   *   DeleteAwsClusterRequest request =
   *       DeleteAwsClusterRequest.newBuilder()
   *           .setName(AwsClusterName.of("[PROJECT]", "[LOCATION]", "[AWS_CLUSTER]").toString())
   *           .setValidateOnly(true)
   *           .setAllowMissing(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Operation> future =
   *       awsClustersClient.deleteAwsClusterCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteAwsClusterRequest, Operation> deleteAwsClusterCallable() {
    return stub.deleteAwsClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates a short-lived access token to authenticate to a given
   * [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster] resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AwsClustersClient awsClustersClient = AwsClustersClient.create()) {
   *   GenerateAwsAccessTokenRequest request =
   *       GenerateAwsAccessTokenRequest.newBuilder()
   *           .setAwsCluster(
   *               AwsClusterName.of("[PROJECT]", "[LOCATION]", "[AWS_CLUSTER]").toString())
   *           .build();
   *   GenerateAwsAccessTokenResponse response = awsClustersClient.generateAwsAccessToken(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerateAwsAccessTokenResponse generateAwsAccessToken(
      GenerateAwsAccessTokenRequest request) {
    return generateAwsAccessTokenCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates a short-lived access token to authenticate to a given
   * [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster] resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AwsClustersClient awsClustersClient = AwsClustersClient.create()) {
   *   GenerateAwsAccessTokenRequest request =
   *       GenerateAwsAccessTokenRequest.newBuilder()
   *           .setAwsCluster(
   *               AwsClusterName.of("[PROJECT]", "[LOCATION]", "[AWS_CLUSTER]").toString())
   *           .build();
   *   ApiFuture<GenerateAwsAccessTokenResponse> future =
   *       awsClustersClient.generateAwsAccessTokenCallable().futureCall(request);
   *   // Do something.
   *   GenerateAwsAccessTokenResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GenerateAwsAccessTokenRequest, GenerateAwsAccessTokenResponse>
      generateAwsAccessTokenCallable() {
    return stub.generateAwsAccessTokenCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new [AwsNodePool][google.cloud.gkemulticloud.v1.AwsNodePool], attached to a given
   * [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster].
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
   * try (AwsClustersClient awsClustersClient = AwsClustersClient.create()) {
   *   AwsClusterName parent = AwsClusterName.of("[PROJECT]", "[LOCATION]", "[AWS_CLUSTER]");
   *   AwsNodePool awsNodePool = AwsNodePool.newBuilder().build();
   *   String awsNodePoolId = "awsNodePoolId-1885267498";
   *   AwsNodePool response =
   *       awsClustersClient.createAwsNodePoolAsync(parent, awsNodePool, awsNodePoolId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster] resource
   *     where this node pool will be created.
   *     <p>`AwsCluster` names are formatted as
   *     `projects/&lt;project-id&gt;/locations/&lt;region&gt;/awsClusters/&lt;cluster-id&gt;`.
   *     <p>See [Resource Names](https://cloud.google.com/apis/design/resource_names) for more
   *     details on Google Cloud resource names.
   * @param awsNodePool Required. The specification of the
   *     [AwsNodePool][google.cloud.gkemulticloud.v1.AwsNodePool] to create.
   * @param awsNodePoolId Required. A client provided ID the resource. Must be unique within the
   *     parent resource.
   *     <p>The provided ID will be part of the
   *     [AwsNodePool][google.cloud.gkemulticloud.v1.AwsNodePool] resource name formatted as
   *     `projects/&lt;project-id&gt;/locations/&lt;region&gt;/awsClusters/&lt;cluster-id&gt;/awsNodePools/&lt;node-pool-id&gt;`.
   *     <p>Valid characters are `/[a-z][0-9]-/`. Cannot be longer than 40 characters.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AwsNodePool, OperationMetadata> createAwsNodePoolAsync(
      AwsClusterName parent, AwsNodePool awsNodePool, String awsNodePoolId) {
    CreateAwsNodePoolRequest request =
        CreateAwsNodePoolRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setAwsNodePool(awsNodePool)
            .setAwsNodePoolId(awsNodePoolId)
            .build();
    return createAwsNodePoolAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new [AwsNodePool][google.cloud.gkemulticloud.v1.AwsNodePool], attached to a given
   * [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster].
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
   * try (AwsClustersClient awsClustersClient = AwsClustersClient.create()) {
   *   String parent = AwsClusterName.of("[PROJECT]", "[LOCATION]", "[AWS_CLUSTER]").toString();
   *   AwsNodePool awsNodePool = AwsNodePool.newBuilder().build();
   *   String awsNodePoolId = "awsNodePoolId-1885267498";
   *   AwsNodePool response =
   *       awsClustersClient.createAwsNodePoolAsync(parent, awsNodePool, awsNodePoolId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster] resource
   *     where this node pool will be created.
   *     <p>`AwsCluster` names are formatted as
   *     `projects/&lt;project-id&gt;/locations/&lt;region&gt;/awsClusters/&lt;cluster-id&gt;`.
   *     <p>See [Resource Names](https://cloud.google.com/apis/design/resource_names) for more
   *     details on Google Cloud resource names.
   * @param awsNodePool Required. The specification of the
   *     [AwsNodePool][google.cloud.gkemulticloud.v1.AwsNodePool] to create.
   * @param awsNodePoolId Required. A client provided ID the resource. Must be unique within the
   *     parent resource.
   *     <p>The provided ID will be part of the
   *     [AwsNodePool][google.cloud.gkemulticloud.v1.AwsNodePool] resource name formatted as
   *     `projects/&lt;project-id&gt;/locations/&lt;region&gt;/awsClusters/&lt;cluster-id&gt;/awsNodePools/&lt;node-pool-id&gt;`.
   *     <p>Valid characters are `/[a-z][0-9]-/`. Cannot be longer than 40 characters.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AwsNodePool, OperationMetadata> createAwsNodePoolAsync(
      String parent, AwsNodePool awsNodePool, String awsNodePoolId) {
    CreateAwsNodePoolRequest request =
        CreateAwsNodePoolRequest.newBuilder()
            .setParent(parent)
            .setAwsNodePool(awsNodePool)
            .setAwsNodePoolId(awsNodePoolId)
            .build();
    return createAwsNodePoolAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new [AwsNodePool][google.cloud.gkemulticloud.v1.AwsNodePool], attached to a given
   * [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster].
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
   * try (AwsClustersClient awsClustersClient = AwsClustersClient.create()) {
   *   CreateAwsNodePoolRequest request =
   *       CreateAwsNodePoolRequest.newBuilder()
   *           .setParent(AwsClusterName.of("[PROJECT]", "[LOCATION]", "[AWS_CLUSTER]").toString())
   *           .setAwsNodePool(AwsNodePool.newBuilder().build())
   *           .setAwsNodePoolId("awsNodePoolId-1885267498")
   *           .setValidateOnly(true)
   *           .build();
   *   AwsNodePool response = awsClustersClient.createAwsNodePoolAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AwsNodePool, OperationMetadata> createAwsNodePoolAsync(
      CreateAwsNodePoolRequest request) {
    return createAwsNodePoolOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new [AwsNodePool][google.cloud.gkemulticloud.v1.AwsNodePool], attached to a given
   * [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster].
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
   * try (AwsClustersClient awsClustersClient = AwsClustersClient.create()) {
   *   CreateAwsNodePoolRequest request =
   *       CreateAwsNodePoolRequest.newBuilder()
   *           .setParent(AwsClusterName.of("[PROJECT]", "[LOCATION]", "[AWS_CLUSTER]").toString())
   *           .setAwsNodePool(AwsNodePool.newBuilder().build())
   *           .setAwsNodePoolId("awsNodePoolId-1885267498")
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<AwsNodePool, OperationMetadata> future =
   *       awsClustersClient.createAwsNodePoolOperationCallable().futureCall(request);
   *   // Do something.
   *   AwsNodePool response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateAwsNodePoolRequest, AwsNodePool, OperationMetadata>
      createAwsNodePoolOperationCallable() {
    return stub.createAwsNodePoolOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new [AwsNodePool][google.cloud.gkemulticloud.v1.AwsNodePool], attached to a given
   * [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster].
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
   * try (AwsClustersClient awsClustersClient = AwsClustersClient.create()) {
   *   CreateAwsNodePoolRequest request =
   *       CreateAwsNodePoolRequest.newBuilder()
   *           .setParent(AwsClusterName.of("[PROJECT]", "[LOCATION]", "[AWS_CLUSTER]").toString())
   *           .setAwsNodePool(AwsNodePool.newBuilder().build())
   *           .setAwsNodePoolId("awsNodePoolId-1885267498")
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       awsClustersClient.createAwsNodePoolCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateAwsNodePoolRequest, Operation> createAwsNodePoolCallable() {
    return stub.createAwsNodePoolCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an [AwsNodePool][google.cloud.gkemulticloud.v1.AwsNodePool].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AwsClustersClient awsClustersClient = AwsClustersClient.create()) {
   *   AwsNodePool awsNodePool = AwsNodePool.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   AwsNodePool response =
   *       awsClustersClient.updateAwsNodePoolAsync(awsNodePool, updateMask).get();
   * }
   * }</pre>
   *
   * @param awsNodePool Required. The [AwsNodePool][google.cloud.gkemulticloud.v1.AwsNodePool]
   *     resource to update.
   * @param updateMask Required. Mask of fields to update. At least one path must be supplied in
   *     this field. The elements of the repeated paths field can only include these fields from
   *     [AwsNodePool][google.cloud.gkemulticloud.v1.AwsNodePool]:
   *     <p>&#42; `annotations`. &#42; `version`. &#42; `autoscaling.min_node_count`. &#42;
   *     `autoscaling.max_node_count`. &#42; `config.config_encryption.kms_key_arn`. &#42;
   *     `config.security_group_ids`. &#42; `config.root_volume.iops`. &#42;
   *     `config.root_volume.kms_key_arn`. &#42; `config.root_volume.volume_type`. &#42;
   *     `config.root_volume.size_gib`. &#42; `config.proxy_config`. &#42;
   *     `config.proxy_config.secret_arn`. &#42; `config.proxy_config.secret_version`. &#42;
   *     `config.ssh_config`. &#42; `config.ssh_config.ec2_key_pair`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AwsNodePool, OperationMetadata> updateAwsNodePoolAsync(
      AwsNodePool awsNodePool, FieldMask updateMask) {
    UpdateAwsNodePoolRequest request =
        UpdateAwsNodePoolRequest.newBuilder()
            .setAwsNodePool(awsNodePool)
            .setUpdateMask(updateMask)
            .build();
    return updateAwsNodePoolAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an [AwsNodePool][google.cloud.gkemulticloud.v1.AwsNodePool].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AwsClustersClient awsClustersClient = AwsClustersClient.create()) {
   *   UpdateAwsNodePoolRequest request =
   *       UpdateAwsNodePoolRequest.newBuilder()
   *           .setAwsNodePool(AwsNodePool.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   AwsNodePool response = awsClustersClient.updateAwsNodePoolAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AwsNodePool, OperationMetadata> updateAwsNodePoolAsync(
      UpdateAwsNodePoolRequest request) {
    return updateAwsNodePoolOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an [AwsNodePool][google.cloud.gkemulticloud.v1.AwsNodePool].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AwsClustersClient awsClustersClient = AwsClustersClient.create()) {
   *   UpdateAwsNodePoolRequest request =
   *       UpdateAwsNodePoolRequest.newBuilder()
   *           .setAwsNodePool(AwsNodePool.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<AwsNodePool, OperationMetadata> future =
   *       awsClustersClient.updateAwsNodePoolOperationCallable().futureCall(request);
   *   // Do something.
   *   AwsNodePool response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateAwsNodePoolRequest, AwsNodePool, OperationMetadata>
      updateAwsNodePoolOperationCallable() {
    return stub.updateAwsNodePoolOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an [AwsNodePool][google.cloud.gkemulticloud.v1.AwsNodePool].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AwsClustersClient awsClustersClient = AwsClustersClient.create()) {
   *   UpdateAwsNodePoolRequest request =
   *       UpdateAwsNodePoolRequest.newBuilder()
   *           .setAwsNodePool(AwsNodePool.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       awsClustersClient.updateAwsNodePoolCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateAwsNodePoolRequest, Operation> updateAwsNodePoolCallable() {
    return stub.updateAwsNodePoolCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Describes a specific [AwsNodePool][google.cloud.gkemulticloud.v1.AwsNodePool] resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AwsClustersClient awsClustersClient = AwsClustersClient.create()) {
   *   AwsNodePoolName name =
   *       AwsNodePoolName.of("[PROJECT]", "[LOCATION]", "[AWS_CLUSTER]", "[AWS_NODE_POOL]");
   *   AwsNodePool response = awsClustersClient.getAwsNodePool(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the [AwsNodePool][google.cloud.gkemulticloud.v1.AwsNodePool]
   *     resource to describe.
   *     <p>`AwsNodePool` names are formatted as
   *     `projects/&lt;project-id&gt;/locations/&lt;region&gt;/awsClusters/&lt;cluster-id&gt;/awsNodePools/&lt;node-pool-id&gt;`.
   *     <p>See [Resource Names](https://cloud.google.com/apis/design/resource_names) for more
   *     details on Google Cloud resource names.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AwsNodePool getAwsNodePool(AwsNodePoolName name) {
    GetAwsNodePoolRequest request =
        GetAwsNodePoolRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getAwsNodePool(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Describes a specific [AwsNodePool][google.cloud.gkemulticloud.v1.AwsNodePool] resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AwsClustersClient awsClustersClient = AwsClustersClient.create()) {
   *   String name =
   *       AwsNodePoolName.of("[PROJECT]", "[LOCATION]", "[AWS_CLUSTER]", "[AWS_NODE_POOL]")
   *           .toString();
   *   AwsNodePool response = awsClustersClient.getAwsNodePool(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the [AwsNodePool][google.cloud.gkemulticloud.v1.AwsNodePool]
   *     resource to describe.
   *     <p>`AwsNodePool` names are formatted as
   *     `projects/&lt;project-id&gt;/locations/&lt;region&gt;/awsClusters/&lt;cluster-id&gt;/awsNodePools/&lt;node-pool-id&gt;`.
   *     <p>See [Resource Names](https://cloud.google.com/apis/design/resource_names) for more
   *     details on Google Cloud resource names.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AwsNodePool getAwsNodePool(String name) {
    GetAwsNodePoolRequest request = GetAwsNodePoolRequest.newBuilder().setName(name).build();
    return getAwsNodePool(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Describes a specific [AwsNodePool][google.cloud.gkemulticloud.v1.AwsNodePool] resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AwsClustersClient awsClustersClient = AwsClustersClient.create()) {
   *   GetAwsNodePoolRequest request =
   *       GetAwsNodePoolRequest.newBuilder()
   *           .setName(
   *               AwsNodePoolName.of("[PROJECT]", "[LOCATION]", "[AWS_CLUSTER]", "[AWS_NODE_POOL]")
   *                   .toString())
   *           .build();
   *   AwsNodePool response = awsClustersClient.getAwsNodePool(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AwsNodePool getAwsNodePool(GetAwsNodePoolRequest request) {
    return getAwsNodePoolCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Describes a specific [AwsNodePool][google.cloud.gkemulticloud.v1.AwsNodePool] resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AwsClustersClient awsClustersClient = AwsClustersClient.create()) {
   *   GetAwsNodePoolRequest request =
   *       GetAwsNodePoolRequest.newBuilder()
   *           .setName(
   *               AwsNodePoolName.of("[PROJECT]", "[LOCATION]", "[AWS_CLUSTER]", "[AWS_NODE_POOL]")
   *                   .toString())
   *           .build();
   *   ApiFuture<AwsNodePool> future =
   *       awsClustersClient.getAwsNodePoolCallable().futureCall(request);
   *   // Do something.
   *   AwsNodePool response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAwsNodePoolRequest, AwsNodePool> getAwsNodePoolCallable() {
    return stub.getAwsNodePoolCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all [AwsNodePool][google.cloud.gkemulticloud.v1.AwsNodePool] resources on a given
   * [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AwsClustersClient awsClustersClient = AwsClustersClient.create()) {
   *   AwsClusterName parent = AwsClusterName.of("[PROJECT]", "[LOCATION]", "[AWS_CLUSTER]");
   *   for (AwsNodePool element : awsClustersClient.listAwsNodePools(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent `AwsCluster` which owns this collection of
   *     [AwsNodePool][google.cloud.gkemulticloud.v1.AwsNodePool] resources.
   *     <p>`AwsCluster` names are formatted as
   *     `projects/&lt;project-id&gt;/locations/&lt;region&gt;/awsClusters/&lt;cluster-id&gt;`.
   *     <p>See [Resource Names](https://cloud.google.com/apis/design/resource_names) for more
   *     details on Google Cloud resource names.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAwsNodePoolsPagedResponse listAwsNodePools(AwsClusterName parent) {
    ListAwsNodePoolsRequest request =
        ListAwsNodePoolsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAwsNodePools(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all [AwsNodePool][google.cloud.gkemulticloud.v1.AwsNodePool] resources on a given
   * [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AwsClustersClient awsClustersClient = AwsClustersClient.create()) {
   *   String parent = AwsClusterName.of("[PROJECT]", "[LOCATION]", "[AWS_CLUSTER]").toString();
   *   for (AwsNodePool element : awsClustersClient.listAwsNodePools(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent `AwsCluster` which owns this collection of
   *     [AwsNodePool][google.cloud.gkemulticloud.v1.AwsNodePool] resources.
   *     <p>`AwsCluster` names are formatted as
   *     `projects/&lt;project-id&gt;/locations/&lt;region&gt;/awsClusters/&lt;cluster-id&gt;`.
   *     <p>See [Resource Names](https://cloud.google.com/apis/design/resource_names) for more
   *     details on Google Cloud resource names.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAwsNodePoolsPagedResponse listAwsNodePools(String parent) {
    ListAwsNodePoolsRequest request =
        ListAwsNodePoolsRequest.newBuilder().setParent(parent).build();
    return listAwsNodePools(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all [AwsNodePool][google.cloud.gkemulticloud.v1.AwsNodePool] resources on a given
   * [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AwsClustersClient awsClustersClient = AwsClustersClient.create()) {
   *   ListAwsNodePoolsRequest request =
   *       ListAwsNodePoolsRequest.newBuilder()
   *           .setParent(AwsClusterName.of("[PROJECT]", "[LOCATION]", "[AWS_CLUSTER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (AwsNodePool element : awsClustersClient.listAwsNodePools(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAwsNodePoolsPagedResponse listAwsNodePools(ListAwsNodePoolsRequest request) {
    return listAwsNodePoolsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all [AwsNodePool][google.cloud.gkemulticloud.v1.AwsNodePool] resources on a given
   * [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AwsClustersClient awsClustersClient = AwsClustersClient.create()) {
   *   ListAwsNodePoolsRequest request =
   *       ListAwsNodePoolsRequest.newBuilder()
   *           .setParent(AwsClusterName.of("[PROJECT]", "[LOCATION]", "[AWS_CLUSTER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<AwsNodePool> future =
   *       awsClustersClient.listAwsNodePoolsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (AwsNodePool element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAwsNodePoolsRequest, ListAwsNodePoolsPagedResponse>
      listAwsNodePoolsPagedCallable() {
    return stub.listAwsNodePoolsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all [AwsNodePool][google.cloud.gkemulticloud.v1.AwsNodePool] resources on a given
   * [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AwsClustersClient awsClustersClient = AwsClustersClient.create()) {
   *   ListAwsNodePoolsRequest request =
   *       ListAwsNodePoolsRequest.newBuilder()
   *           .setParent(AwsClusterName.of("[PROJECT]", "[LOCATION]", "[AWS_CLUSTER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListAwsNodePoolsResponse response =
   *         awsClustersClient.listAwsNodePoolsCallable().call(request);
   *     for (AwsNodePool element : response.getAwsNodePoolsList()) {
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
  public final UnaryCallable<ListAwsNodePoolsRequest, ListAwsNodePoolsResponse>
      listAwsNodePoolsCallable() {
    return stub.listAwsNodePoolsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific [AwsNodePool][google.cloud.gkemulticloud.v1.AwsNodePool] resource.
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
   * try (AwsClustersClient awsClustersClient = AwsClustersClient.create()) {
   *   AwsNodePoolName name =
   *       AwsNodePoolName.of("[PROJECT]", "[LOCATION]", "[AWS_CLUSTER]", "[AWS_NODE_POOL]");
   *   awsClustersClient.deleteAwsNodePoolAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name the
   *     [AwsNodePool][google.cloud.gkemulticloud.v1.AwsNodePool] to delete.
   *     <p>`AwsNodePool` names are formatted as
   *     `projects/&lt;project-id&gt;/locations/&lt;region&gt;/awsClusters/&lt;cluster-id&gt;/awsNodePools/&lt;node-pool-id&gt;`.
   *     <p>See [Resource Names](https://cloud.google.com/apis/design/resource_names) for more
   *     details on Google Cloud resource names.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteAwsNodePoolAsync(
      AwsNodePoolName name) {
    DeleteAwsNodePoolRequest request =
        DeleteAwsNodePoolRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteAwsNodePoolAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific [AwsNodePool][google.cloud.gkemulticloud.v1.AwsNodePool] resource.
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
   * try (AwsClustersClient awsClustersClient = AwsClustersClient.create()) {
   *   String name =
   *       AwsNodePoolName.of("[PROJECT]", "[LOCATION]", "[AWS_CLUSTER]", "[AWS_NODE_POOL]")
   *           .toString();
   *   awsClustersClient.deleteAwsNodePoolAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name the
   *     [AwsNodePool][google.cloud.gkemulticloud.v1.AwsNodePool] to delete.
   *     <p>`AwsNodePool` names are formatted as
   *     `projects/&lt;project-id&gt;/locations/&lt;region&gt;/awsClusters/&lt;cluster-id&gt;/awsNodePools/&lt;node-pool-id&gt;`.
   *     <p>See [Resource Names](https://cloud.google.com/apis/design/resource_names) for more
   *     details on Google Cloud resource names.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteAwsNodePoolAsync(String name) {
    DeleteAwsNodePoolRequest request = DeleteAwsNodePoolRequest.newBuilder().setName(name).build();
    return deleteAwsNodePoolAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific [AwsNodePool][google.cloud.gkemulticloud.v1.AwsNodePool] resource.
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
   * try (AwsClustersClient awsClustersClient = AwsClustersClient.create()) {
   *   DeleteAwsNodePoolRequest request =
   *       DeleteAwsNodePoolRequest.newBuilder()
   *           .setName(
   *               AwsNodePoolName.of("[PROJECT]", "[LOCATION]", "[AWS_CLUSTER]", "[AWS_NODE_POOL]")
   *                   .toString())
   *           .setValidateOnly(true)
   *           .setAllowMissing(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   awsClustersClient.deleteAwsNodePoolAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteAwsNodePoolAsync(
      DeleteAwsNodePoolRequest request) {
    return deleteAwsNodePoolOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific [AwsNodePool][google.cloud.gkemulticloud.v1.AwsNodePool] resource.
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
   * try (AwsClustersClient awsClustersClient = AwsClustersClient.create()) {
   *   DeleteAwsNodePoolRequest request =
   *       DeleteAwsNodePoolRequest.newBuilder()
   *           .setName(
   *               AwsNodePoolName.of("[PROJECT]", "[LOCATION]", "[AWS_CLUSTER]", "[AWS_NODE_POOL]")
   *                   .toString())
   *           .setValidateOnly(true)
   *           .setAllowMissing(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       awsClustersClient.deleteAwsNodePoolOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteAwsNodePoolRequest, Empty, OperationMetadata>
      deleteAwsNodePoolOperationCallable() {
    return stub.deleteAwsNodePoolOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific [AwsNodePool][google.cloud.gkemulticloud.v1.AwsNodePool] resource.
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
   * try (AwsClustersClient awsClustersClient = AwsClustersClient.create()) {
   *   DeleteAwsNodePoolRequest request =
   *       DeleteAwsNodePoolRequest.newBuilder()
   *           .setName(
   *               AwsNodePoolName.of("[PROJECT]", "[LOCATION]", "[AWS_CLUSTER]", "[AWS_NODE_POOL]")
   *                   .toString())
   *           .setValidateOnly(true)
   *           .setAllowMissing(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Operation> future =
   *       awsClustersClient.deleteAwsNodePoolCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteAwsNodePoolRequest, Operation> deleteAwsNodePoolCallable() {
    return stub.deleteAwsNodePoolCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns information, such as supported AWS regions and Kubernetes versions, on a given Google
   * Cloud location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AwsClustersClient awsClustersClient = AwsClustersClient.create()) {
   *   AwsServerConfigName name = AwsServerConfigName.of("[PROJECT]", "[LOCATION]");
   *   AwsServerConfig response = awsClustersClient.getAwsServerConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the
   *     [AwsServerConfig][google.cloud.gkemulticloud.v1.AwsServerConfig] resource to describe.
   *     <p>`AwsServerConfig` names are formatted as
   *     `projects/&lt;project-id&gt;/locations/&lt;region&gt;/awsServerConfig`.
   *     <p>See [Resource Names](https://cloud.google.com/apis/design/resource_names) for more
   *     details on Google Cloud resource names.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AwsServerConfig getAwsServerConfig(AwsServerConfigName name) {
    GetAwsServerConfigRequest request =
        GetAwsServerConfigRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getAwsServerConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns information, such as supported AWS regions and Kubernetes versions, on a given Google
   * Cloud location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AwsClustersClient awsClustersClient = AwsClustersClient.create()) {
   *   String name = AwsServerConfigName.of("[PROJECT]", "[LOCATION]").toString();
   *   AwsServerConfig response = awsClustersClient.getAwsServerConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the
   *     [AwsServerConfig][google.cloud.gkemulticloud.v1.AwsServerConfig] resource to describe.
   *     <p>`AwsServerConfig` names are formatted as
   *     `projects/&lt;project-id&gt;/locations/&lt;region&gt;/awsServerConfig`.
   *     <p>See [Resource Names](https://cloud.google.com/apis/design/resource_names) for more
   *     details on Google Cloud resource names.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AwsServerConfig getAwsServerConfig(String name) {
    GetAwsServerConfigRequest request =
        GetAwsServerConfigRequest.newBuilder().setName(name).build();
    return getAwsServerConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns information, such as supported AWS regions and Kubernetes versions, on a given Google
   * Cloud location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AwsClustersClient awsClustersClient = AwsClustersClient.create()) {
   *   GetAwsServerConfigRequest request =
   *       GetAwsServerConfigRequest.newBuilder()
   *           .setName(AwsServerConfigName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   AwsServerConfig response = awsClustersClient.getAwsServerConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AwsServerConfig getAwsServerConfig(GetAwsServerConfigRequest request) {
    return getAwsServerConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns information, such as supported AWS regions and Kubernetes versions, on a given Google
   * Cloud location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AwsClustersClient awsClustersClient = AwsClustersClient.create()) {
   *   GetAwsServerConfigRequest request =
   *       GetAwsServerConfigRequest.newBuilder()
   *           .setName(AwsServerConfigName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   ApiFuture<AwsServerConfig> future =
   *       awsClustersClient.getAwsServerConfigCallable().futureCall(request);
   *   // Do something.
   *   AwsServerConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAwsServerConfigRequest, AwsServerConfig>
      getAwsServerConfigCallable() {
    return stub.getAwsServerConfigCallable();
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

  public static class ListAwsClustersPagedResponse
      extends AbstractPagedListResponse<
          ListAwsClustersRequest,
          ListAwsClustersResponse,
          AwsCluster,
          ListAwsClustersPage,
          ListAwsClustersFixedSizeCollection> {

    public static ApiFuture<ListAwsClustersPagedResponse> createAsync(
        PageContext<ListAwsClustersRequest, ListAwsClustersResponse, AwsCluster> context,
        ApiFuture<ListAwsClustersResponse> futureResponse) {
      ApiFuture<ListAwsClustersPage> futurePage =
          ListAwsClustersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAwsClustersPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAwsClustersPagedResponse(ListAwsClustersPage page) {
      super(page, ListAwsClustersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAwsClustersPage
      extends AbstractPage<
          ListAwsClustersRequest, ListAwsClustersResponse, AwsCluster, ListAwsClustersPage> {

    private ListAwsClustersPage(
        PageContext<ListAwsClustersRequest, ListAwsClustersResponse, AwsCluster> context,
        ListAwsClustersResponse response) {
      super(context, response);
    }

    private static ListAwsClustersPage createEmptyPage() {
      return new ListAwsClustersPage(null, null);
    }

    @Override
    protected ListAwsClustersPage createPage(
        PageContext<ListAwsClustersRequest, ListAwsClustersResponse, AwsCluster> context,
        ListAwsClustersResponse response) {
      return new ListAwsClustersPage(context, response);
    }

    @Override
    public ApiFuture<ListAwsClustersPage> createPageAsync(
        PageContext<ListAwsClustersRequest, ListAwsClustersResponse, AwsCluster> context,
        ApiFuture<ListAwsClustersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAwsClustersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAwsClustersRequest,
          ListAwsClustersResponse,
          AwsCluster,
          ListAwsClustersPage,
          ListAwsClustersFixedSizeCollection> {

    private ListAwsClustersFixedSizeCollection(
        List<ListAwsClustersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAwsClustersFixedSizeCollection createEmptyCollection() {
      return new ListAwsClustersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAwsClustersFixedSizeCollection createCollection(
        List<ListAwsClustersPage> pages, int collectionSize) {
      return new ListAwsClustersFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListAwsNodePoolsPagedResponse
      extends AbstractPagedListResponse<
          ListAwsNodePoolsRequest,
          ListAwsNodePoolsResponse,
          AwsNodePool,
          ListAwsNodePoolsPage,
          ListAwsNodePoolsFixedSizeCollection> {

    public static ApiFuture<ListAwsNodePoolsPagedResponse> createAsync(
        PageContext<ListAwsNodePoolsRequest, ListAwsNodePoolsResponse, AwsNodePool> context,
        ApiFuture<ListAwsNodePoolsResponse> futureResponse) {
      ApiFuture<ListAwsNodePoolsPage> futurePage =
          ListAwsNodePoolsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAwsNodePoolsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAwsNodePoolsPagedResponse(ListAwsNodePoolsPage page) {
      super(page, ListAwsNodePoolsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAwsNodePoolsPage
      extends AbstractPage<
          ListAwsNodePoolsRequest, ListAwsNodePoolsResponse, AwsNodePool, ListAwsNodePoolsPage> {

    private ListAwsNodePoolsPage(
        PageContext<ListAwsNodePoolsRequest, ListAwsNodePoolsResponse, AwsNodePool> context,
        ListAwsNodePoolsResponse response) {
      super(context, response);
    }

    private static ListAwsNodePoolsPage createEmptyPage() {
      return new ListAwsNodePoolsPage(null, null);
    }

    @Override
    protected ListAwsNodePoolsPage createPage(
        PageContext<ListAwsNodePoolsRequest, ListAwsNodePoolsResponse, AwsNodePool> context,
        ListAwsNodePoolsResponse response) {
      return new ListAwsNodePoolsPage(context, response);
    }

    @Override
    public ApiFuture<ListAwsNodePoolsPage> createPageAsync(
        PageContext<ListAwsNodePoolsRequest, ListAwsNodePoolsResponse, AwsNodePool> context,
        ApiFuture<ListAwsNodePoolsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAwsNodePoolsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAwsNodePoolsRequest,
          ListAwsNodePoolsResponse,
          AwsNodePool,
          ListAwsNodePoolsPage,
          ListAwsNodePoolsFixedSizeCollection> {

    private ListAwsNodePoolsFixedSizeCollection(
        List<ListAwsNodePoolsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAwsNodePoolsFixedSizeCollection createEmptyCollection() {
      return new ListAwsNodePoolsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAwsNodePoolsFixedSizeCollection createCollection(
        List<ListAwsNodePoolsPage> pages, int collectionSize) {
      return new ListAwsNodePoolsFixedSizeCollection(pages, collectionSize);
    }
  }
}
