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

package com.google.cloud.deploy.v1;

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
import com.google.cloud.deploy.v1.stub.CloudDeployStub;
import com.google.cloud.deploy.v1.stub.CloudDeployStubSettings;
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
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: CloudDeploy service creates and manages Continuous Delivery operations on
 * Google Cloud Platform via Skaffold (https://skaffold.dev).
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
 * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
 *   DeliveryPipelineName name =
 *       DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]");
 *   DeliveryPipeline response = cloudDeployClient.getDeliveryPipeline(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the CloudDeployClient object to clean up resources such as
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
 * <p>This class can be customized by passing in a custom instance of CloudDeploySettings to
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
 * CloudDeploySettings cloudDeploySettings =
 *     CloudDeploySettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * CloudDeployClient cloudDeployClient = CloudDeployClient.create(cloudDeploySettings);
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
 * CloudDeploySettings cloudDeploySettings =
 *     CloudDeploySettings.newBuilder().setEndpoint(myEndpoint).build();
 * CloudDeployClient cloudDeployClient = CloudDeployClient.create(cloudDeploySettings);
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
 * CloudDeploySettings cloudDeploySettings = CloudDeploySettings.newHttpJsonBuilder().build();
 * CloudDeployClient cloudDeployClient = CloudDeployClient.create(cloudDeploySettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class CloudDeployClient implements BackgroundResource {
  private final CloudDeploySettings settings;
  private final CloudDeployStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of CloudDeployClient with default settings. */
  public static final CloudDeployClient create() throws IOException {
    return create(CloudDeploySettings.newBuilder().build());
  }

  /**
   * Constructs an instance of CloudDeployClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final CloudDeployClient create(CloudDeploySettings settings) throws IOException {
    return new CloudDeployClient(settings);
  }

  /**
   * Constructs an instance of CloudDeployClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(CloudDeploySettings).
   */
  public static final CloudDeployClient create(CloudDeployStub stub) {
    return new CloudDeployClient(stub);
  }

  /**
   * Constructs an instance of CloudDeployClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected CloudDeployClient(CloudDeploySettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((CloudDeployStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected CloudDeployClient(CloudDeployStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final CloudDeploySettings getSettings() {
    return settings;
  }

  public CloudDeployStub getStub() {
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
   * Lists DeliveryPipelines in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (DeliveryPipeline element :
   *       cloudDeployClient.listDeliveryPipelines(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of pipelines. Format must be
   *     projects/{project_id}/locations/{location_name}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDeliveryPipelinesPagedResponse listDeliveryPipelines(LocationName parent) {
    ListDeliveryPipelinesRequest request =
        ListDeliveryPipelinesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDeliveryPipelines(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DeliveryPipelines in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (DeliveryPipeline element :
   *       cloudDeployClient.listDeliveryPipelines(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of pipelines. Format must be
   *     projects/{project_id}/locations/{location_name}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDeliveryPipelinesPagedResponse listDeliveryPipelines(String parent) {
    ListDeliveryPipelinesRequest request =
        ListDeliveryPipelinesRequest.newBuilder().setParent(parent).build();
    return listDeliveryPipelines(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DeliveryPipelines in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   ListDeliveryPipelinesRequest request =
   *       ListDeliveryPipelinesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (DeliveryPipeline element :
   *       cloudDeployClient.listDeliveryPipelines(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDeliveryPipelinesPagedResponse listDeliveryPipelines(
      ListDeliveryPipelinesRequest request) {
    return listDeliveryPipelinesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DeliveryPipelines in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   ListDeliveryPipelinesRequest request =
   *       ListDeliveryPipelinesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<DeliveryPipeline> future =
   *       cloudDeployClient.listDeliveryPipelinesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (DeliveryPipeline element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDeliveryPipelinesRequest, ListDeliveryPipelinesPagedResponse>
      listDeliveryPipelinesPagedCallable() {
    return stub.listDeliveryPipelinesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DeliveryPipelines in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   ListDeliveryPipelinesRequest request =
   *       ListDeliveryPipelinesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListDeliveryPipelinesResponse response =
   *         cloudDeployClient.listDeliveryPipelinesCallable().call(request);
   *     for (DeliveryPipeline element : response.getDeliveryPipelinesList()) {
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
  public final UnaryCallable<ListDeliveryPipelinesRequest, ListDeliveryPipelinesResponse>
      listDeliveryPipelinesCallable() {
    return stub.listDeliveryPipelinesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single DeliveryPipeline.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   DeliveryPipelineName name =
   *       DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]");
   *   DeliveryPipeline response = cloudDeployClient.getDeliveryPipeline(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the `DeliveryPipeline`. Format must be
   *     projects/{project_id}/locations/{location_name}/deliveryPipelines/{pipeline_name}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeliveryPipeline getDeliveryPipeline(DeliveryPipelineName name) {
    GetDeliveryPipelineRequest request =
        GetDeliveryPipelineRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getDeliveryPipeline(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single DeliveryPipeline.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   String name =
   *       DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]").toString();
   *   DeliveryPipeline response = cloudDeployClient.getDeliveryPipeline(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the `DeliveryPipeline`. Format must be
   *     projects/{project_id}/locations/{location_name}/deliveryPipelines/{pipeline_name}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeliveryPipeline getDeliveryPipeline(String name) {
    GetDeliveryPipelineRequest request =
        GetDeliveryPipelineRequest.newBuilder().setName(name).build();
    return getDeliveryPipeline(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single DeliveryPipeline.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   GetDeliveryPipelineRequest request =
   *       GetDeliveryPipelineRequest.newBuilder()
   *           .setName(
   *               DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]")
   *                   .toString())
   *           .build();
   *   DeliveryPipeline response = cloudDeployClient.getDeliveryPipeline(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeliveryPipeline getDeliveryPipeline(GetDeliveryPipelineRequest request) {
    return getDeliveryPipelineCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single DeliveryPipeline.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   GetDeliveryPipelineRequest request =
   *       GetDeliveryPipelineRequest.newBuilder()
   *           .setName(
   *               DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<DeliveryPipeline> future =
   *       cloudDeployClient.getDeliveryPipelineCallable().futureCall(request);
   *   // Do something.
   *   DeliveryPipeline response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDeliveryPipelineRequest, DeliveryPipeline>
      getDeliveryPipelineCallable() {
    return stub.getDeliveryPipelineCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new DeliveryPipeline in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   DeliveryPipeline deliveryPipeline = DeliveryPipeline.newBuilder().build();
   *   String deliveryPipelineId = "deliveryPipelineId-632411535";
   *   DeliveryPipeline response =
   *       cloudDeployClient
   *           .createDeliveryPipelineAsync(parent, deliveryPipeline, deliveryPipelineId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent collection in which the `DeliveryPipeline` should be
   *     created. Format should be projects/{project_id}/locations/{location_name}.
   * @param deliveryPipeline Required. The `DeliveryPipeline` to create.
   * @param deliveryPipelineId Required. ID of the `DeliveryPipeline`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DeliveryPipeline, OperationMetadata> createDeliveryPipelineAsync(
      LocationName parent, DeliveryPipeline deliveryPipeline, String deliveryPipelineId) {
    CreateDeliveryPipelineRequest request =
        CreateDeliveryPipelineRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setDeliveryPipeline(deliveryPipeline)
            .setDeliveryPipelineId(deliveryPipelineId)
            .build();
    return createDeliveryPipelineAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new DeliveryPipeline in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   DeliveryPipeline deliveryPipeline = DeliveryPipeline.newBuilder().build();
   *   String deliveryPipelineId = "deliveryPipelineId-632411535";
   *   DeliveryPipeline response =
   *       cloudDeployClient
   *           .createDeliveryPipelineAsync(parent, deliveryPipeline, deliveryPipelineId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent collection in which the `DeliveryPipeline` should be
   *     created. Format should be projects/{project_id}/locations/{location_name}.
   * @param deliveryPipeline Required. The `DeliveryPipeline` to create.
   * @param deliveryPipelineId Required. ID of the `DeliveryPipeline`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DeliveryPipeline, OperationMetadata> createDeliveryPipelineAsync(
      String parent, DeliveryPipeline deliveryPipeline, String deliveryPipelineId) {
    CreateDeliveryPipelineRequest request =
        CreateDeliveryPipelineRequest.newBuilder()
            .setParent(parent)
            .setDeliveryPipeline(deliveryPipeline)
            .setDeliveryPipelineId(deliveryPipelineId)
            .build();
    return createDeliveryPipelineAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new DeliveryPipeline in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   CreateDeliveryPipelineRequest request =
   *       CreateDeliveryPipelineRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDeliveryPipelineId("deliveryPipelineId-632411535")
   *           .setDeliveryPipeline(DeliveryPipeline.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   DeliveryPipeline response = cloudDeployClient.createDeliveryPipelineAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DeliveryPipeline, OperationMetadata> createDeliveryPipelineAsync(
      CreateDeliveryPipelineRequest request) {
    return createDeliveryPipelineOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new DeliveryPipeline in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   CreateDeliveryPipelineRequest request =
   *       CreateDeliveryPipelineRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDeliveryPipelineId("deliveryPipelineId-632411535")
   *           .setDeliveryPipeline(DeliveryPipeline.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<DeliveryPipeline, OperationMetadata> future =
   *       cloudDeployClient.createDeliveryPipelineOperationCallable().futureCall(request);
   *   // Do something.
   *   DeliveryPipeline response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateDeliveryPipelineRequest, DeliveryPipeline, OperationMetadata>
      createDeliveryPipelineOperationCallable() {
    return stub.createDeliveryPipelineOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new DeliveryPipeline in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   CreateDeliveryPipelineRequest request =
   *       CreateDeliveryPipelineRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDeliveryPipelineId("deliveryPipelineId-632411535")
   *           .setDeliveryPipeline(DeliveryPipeline.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       cloudDeployClient.createDeliveryPipelineCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateDeliveryPipelineRequest, Operation>
      createDeliveryPipelineCallable() {
    return stub.createDeliveryPipelineCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single DeliveryPipeline.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   DeliveryPipeline deliveryPipeline = DeliveryPipeline.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   DeliveryPipeline response =
   *       cloudDeployClient.updateDeliveryPipelineAsync(deliveryPipeline, updateMask).get();
   * }
   * }</pre>
   *
   * @param deliveryPipeline Required. The `DeliveryPipeline` to update.
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     `DeliveryPipeline` resource by the update. The fields specified in the update_mask are
   *     relative to the resource, not the full request. A field will be overwritten if it is in the
   *     mask. If the user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DeliveryPipeline, OperationMetadata> updateDeliveryPipelineAsync(
      DeliveryPipeline deliveryPipeline, FieldMask updateMask) {
    UpdateDeliveryPipelineRequest request =
        UpdateDeliveryPipelineRequest.newBuilder()
            .setDeliveryPipeline(deliveryPipeline)
            .setUpdateMask(updateMask)
            .build();
    return updateDeliveryPipelineAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single DeliveryPipeline.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   UpdateDeliveryPipelineRequest request =
   *       UpdateDeliveryPipelineRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setDeliveryPipeline(DeliveryPipeline.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .build();
   *   DeliveryPipeline response = cloudDeployClient.updateDeliveryPipelineAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DeliveryPipeline, OperationMetadata> updateDeliveryPipelineAsync(
      UpdateDeliveryPipelineRequest request) {
    return updateDeliveryPipelineOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single DeliveryPipeline.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   UpdateDeliveryPipelineRequest request =
   *       UpdateDeliveryPipelineRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setDeliveryPipeline(DeliveryPipeline.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<DeliveryPipeline, OperationMetadata> future =
   *       cloudDeployClient.updateDeliveryPipelineOperationCallable().futureCall(request);
   *   // Do something.
   *   DeliveryPipeline response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateDeliveryPipelineRequest, DeliveryPipeline, OperationMetadata>
      updateDeliveryPipelineOperationCallable() {
    return stub.updateDeliveryPipelineOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single DeliveryPipeline.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   UpdateDeliveryPipelineRequest request =
   *       UpdateDeliveryPipelineRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setDeliveryPipeline(DeliveryPipeline.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       cloudDeployClient.updateDeliveryPipelineCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateDeliveryPipelineRequest, Operation>
      updateDeliveryPipelineCallable() {
    return stub.updateDeliveryPipelineCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single DeliveryPipeline.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   DeliveryPipelineName name =
   *       DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]");
   *   cloudDeployClient.deleteDeliveryPipelineAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the `DeliveryPipeline` to delete. Format should be
   *     projects/{project_id}/locations/{location_name}/deliveryPipelines/{pipeline_name}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteDeliveryPipelineAsync(
      DeliveryPipelineName name) {
    DeleteDeliveryPipelineRequest request =
        DeleteDeliveryPipelineRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteDeliveryPipelineAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single DeliveryPipeline.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   String name =
   *       DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]").toString();
   *   cloudDeployClient.deleteDeliveryPipelineAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the `DeliveryPipeline` to delete. Format should be
   *     projects/{project_id}/locations/{location_name}/deliveryPipelines/{pipeline_name}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteDeliveryPipelineAsync(String name) {
    DeleteDeliveryPipelineRequest request =
        DeleteDeliveryPipelineRequest.newBuilder().setName(name).build();
    return deleteDeliveryPipelineAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single DeliveryPipeline.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   DeleteDeliveryPipelineRequest request =
   *       DeleteDeliveryPipelineRequest.newBuilder()
   *           .setName(
   *               DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .setForce(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   cloudDeployClient.deleteDeliveryPipelineAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteDeliveryPipelineAsync(
      DeleteDeliveryPipelineRequest request) {
    return deleteDeliveryPipelineOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single DeliveryPipeline.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   DeleteDeliveryPipelineRequest request =
   *       DeleteDeliveryPipelineRequest.newBuilder()
   *           .setName(
   *               DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .setForce(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       cloudDeployClient.deleteDeliveryPipelineOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteDeliveryPipelineRequest, Empty, OperationMetadata>
      deleteDeliveryPipelineOperationCallable() {
    return stub.deleteDeliveryPipelineOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single DeliveryPipeline.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   DeleteDeliveryPipelineRequest request =
   *       DeleteDeliveryPipelineRequest.newBuilder()
   *           .setName(
   *               DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .setForce(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Operation> future =
   *       cloudDeployClient.deleteDeliveryPipelineCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteDeliveryPipelineRequest, Operation>
      deleteDeliveryPipelineCallable() {
    return stub.deleteDeliveryPipelineCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Targets in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Target element : cloudDeployClient.listTargets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of targets. Format must be
   *     projects/{project_id}/locations/{location_name}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTargetsPagedResponse listTargets(LocationName parent) {
    ListTargetsRequest request =
        ListTargetsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listTargets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Targets in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Target element : cloudDeployClient.listTargets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of targets. Format must be
   *     projects/{project_id}/locations/{location_name}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTargetsPagedResponse listTargets(String parent) {
    ListTargetsRequest request = ListTargetsRequest.newBuilder().setParent(parent).build();
    return listTargets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Targets in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   ListTargetsRequest request =
   *       ListTargetsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Target element : cloudDeployClient.listTargets(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTargetsPagedResponse listTargets(ListTargetsRequest request) {
    return listTargetsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Targets in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   ListTargetsRequest request =
   *       ListTargetsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Target> future = cloudDeployClient.listTargetsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Target element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListTargetsRequest, ListTargetsPagedResponse>
      listTargetsPagedCallable() {
    return stub.listTargetsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Targets in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   ListTargetsRequest request =
   *       ListTargetsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListTargetsResponse response = cloudDeployClient.listTargetsCallable().call(request);
   *     for (Target element : response.getTargetsList()) {
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
  public final UnaryCallable<ListTargetsRequest, ListTargetsResponse> listTargetsCallable() {
    return stub.listTargetsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Target.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   TargetName name = TargetName.of("[PROJECT]", "[LOCATION]", "[TARGET]");
   *   Target response = cloudDeployClient.getTarget(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the `Target`. Format must be
   *     projects/{project_id}/locations/{location_name}/targets/{target_name}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Target getTarget(TargetName name) {
    GetTargetRequest request =
        GetTargetRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getTarget(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Target.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   String name = TargetName.of("[PROJECT]", "[LOCATION]", "[TARGET]").toString();
   *   Target response = cloudDeployClient.getTarget(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the `Target`. Format must be
   *     projects/{project_id}/locations/{location_name}/targets/{target_name}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Target getTarget(String name) {
    GetTargetRequest request = GetTargetRequest.newBuilder().setName(name).build();
    return getTarget(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Target.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   GetTargetRequest request =
   *       GetTargetRequest.newBuilder()
   *           .setName(TargetName.of("[PROJECT]", "[LOCATION]", "[TARGET]").toString())
   *           .build();
   *   Target response = cloudDeployClient.getTarget(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Target getTarget(GetTargetRequest request) {
    return getTargetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Target.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   GetTargetRequest request =
   *       GetTargetRequest.newBuilder()
   *           .setName(TargetName.of("[PROJECT]", "[LOCATION]", "[TARGET]").toString())
   *           .build();
   *   ApiFuture<Target> future = cloudDeployClient.getTargetCallable().futureCall(request);
   *   // Do something.
   *   Target response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetTargetRequest, Target> getTargetCallable() {
    return stub.getTargetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Target in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Target target = Target.newBuilder().build();
   *   String targetId = "targetId-441951604";
   *   Target response = cloudDeployClient.createTargetAsync(parent, target, targetId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent collection in which the `Target` should be created. Format
   *     should be projects/{project_id}/locations/{location_name}.
   * @param target Required. The `Target` to create.
   * @param targetId Required. ID of the `Target`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Target, OperationMetadata> createTargetAsync(
      LocationName parent, Target target, String targetId) {
    CreateTargetRequest request =
        CreateTargetRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setTarget(target)
            .setTargetId(targetId)
            .build();
    return createTargetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Target in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Target target = Target.newBuilder().build();
   *   String targetId = "targetId-441951604";
   *   Target response = cloudDeployClient.createTargetAsync(parent, target, targetId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent collection in which the `Target` should be created. Format
   *     should be projects/{project_id}/locations/{location_name}.
   * @param target Required. The `Target` to create.
   * @param targetId Required. ID of the `Target`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Target, OperationMetadata> createTargetAsync(
      String parent, Target target, String targetId) {
    CreateTargetRequest request =
        CreateTargetRequest.newBuilder()
            .setParent(parent)
            .setTarget(target)
            .setTargetId(targetId)
            .build();
    return createTargetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Target in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   CreateTargetRequest request =
   *       CreateTargetRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setTargetId("targetId-441951604")
   *           .setTarget(Target.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   Target response = cloudDeployClient.createTargetAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Target, OperationMetadata> createTargetAsync(
      CreateTargetRequest request) {
    return createTargetOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Target in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   CreateTargetRequest request =
   *       CreateTargetRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setTargetId("targetId-441951604")
   *           .setTarget(Target.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Target, OperationMetadata> future =
   *       cloudDeployClient.createTargetOperationCallable().futureCall(request);
   *   // Do something.
   *   Target response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateTargetRequest, Target, OperationMetadata>
      createTargetOperationCallable() {
    return stub.createTargetOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Target in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   CreateTargetRequest request =
   *       CreateTargetRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setTargetId("targetId-441951604")
   *           .setTarget(Target.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future = cloudDeployClient.createTargetCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateTargetRequest, Operation> createTargetCallable() {
    return stub.createTargetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Target.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   Target target = Target.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Target response = cloudDeployClient.updateTargetAsync(target, updateMask).get();
   * }
   * }</pre>
   *
   * @param target Required. The `Target` to update.
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     Target resource by the update. The fields specified in the update_mask are relative to the
   *     resource, not the full request. A field will be overwritten if it is in the mask. If the
   *     user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Target, OperationMetadata> updateTargetAsync(
      Target target, FieldMask updateMask) {
    UpdateTargetRequest request =
        UpdateTargetRequest.newBuilder().setTarget(target).setUpdateMask(updateMask).build();
    return updateTargetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Target.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   UpdateTargetRequest request =
   *       UpdateTargetRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setTarget(Target.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .build();
   *   Target response = cloudDeployClient.updateTargetAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Target, OperationMetadata> updateTargetAsync(
      UpdateTargetRequest request) {
    return updateTargetOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Target.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   UpdateTargetRequest request =
   *       UpdateTargetRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setTarget(Target.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Target, OperationMetadata> future =
   *       cloudDeployClient.updateTargetOperationCallable().futureCall(request);
   *   // Do something.
   *   Target response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateTargetRequest, Target, OperationMetadata>
      updateTargetOperationCallable() {
    return stub.updateTargetOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Target.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   UpdateTargetRequest request =
   *       UpdateTargetRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setTarget(Target.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future = cloudDeployClient.updateTargetCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateTargetRequest, Operation> updateTargetCallable() {
    return stub.updateTargetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Target.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   TargetName name = TargetName.of("[PROJECT]", "[LOCATION]", "[TARGET]");
   *   cloudDeployClient.deleteTargetAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the `Target` to delete. Format should be
   *     projects/{project_id}/locations/{location_name}/targets/{target_name}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteTargetAsync(TargetName name) {
    DeleteTargetRequest request =
        DeleteTargetRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteTargetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Target.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   String name = TargetName.of("[PROJECT]", "[LOCATION]", "[TARGET]").toString();
   *   cloudDeployClient.deleteTargetAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the `Target` to delete. Format should be
   *     projects/{project_id}/locations/{location_name}/targets/{target_name}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteTargetAsync(String name) {
    DeleteTargetRequest request = DeleteTargetRequest.newBuilder().setName(name).build();
    return deleteTargetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Target.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   DeleteTargetRequest request =
   *       DeleteTargetRequest.newBuilder()
   *           .setName(TargetName.of("[PROJECT]", "[LOCATION]", "[TARGET]").toString())
   *           .setRequestId("requestId693933066")
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   cloudDeployClient.deleteTargetAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteTargetAsync(
      DeleteTargetRequest request) {
    return deleteTargetOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Target.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   DeleteTargetRequest request =
   *       DeleteTargetRequest.newBuilder()
   *           .setName(TargetName.of("[PROJECT]", "[LOCATION]", "[TARGET]").toString())
   *           .setRequestId("requestId693933066")
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       cloudDeployClient.deleteTargetOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteTargetRequest, Empty, OperationMetadata>
      deleteTargetOperationCallable() {
    return stub.deleteTargetOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Target.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   DeleteTargetRequest request =
   *       DeleteTargetRequest.newBuilder()
   *           .setName(TargetName.of("[PROJECT]", "[LOCATION]", "[TARGET]").toString())
   *           .setRequestId("requestId693933066")
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Operation> future = cloudDeployClient.deleteTargetCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteTargetRequest, Operation> deleteTargetCallable() {
    return stub.deleteTargetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Releases in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   DeliveryPipelineName parent =
   *       DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]");
   *   for (Release element : cloudDeployClient.listReleases(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The `DeliveryPipeline` which owns this collection of `Release` objects.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReleasesPagedResponse listReleases(DeliveryPipelineName parent) {
    ListReleasesRequest request =
        ListReleasesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listReleases(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Releases in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   String parent =
   *       DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]").toString();
   *   for (Release element : cloudDeployClient.listReleases(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The `DeliveryPipeline` which owns this collection of `Release` objects.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReleasesPagedResponse listReleases(String parent) {
    ListReleasesRequest request = ListReleasesRequest.newBuilder().setParent(parent).build();
    return listReleases(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Releases in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   ListReleasesRequest request =
   *       ListReleasesRequest.newBuilder()
   *           .setParent(
   *               DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Release element : cloudDeployClient.listReleases(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReleasesPagedResponse listReleases(ListReleasesRequest request) {
    return listReleasesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Releases in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   ListReleasesRequest request =
   *       ListReleasesRequest.newBuilder()
   *           .setParent(
   *               DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Release> future = cloudDeployClient.listReleasesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Release element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListReleasesRequest, ListReleasesPagedResponse>
      listReleasesPagedCallable() {
    return stub.listReleasesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Releases in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   ListReleasesRequest request =
   *       ListReleasesRequest.newBuilder()
   *           .setParent(
   *               DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListReleasesResponse response = cloudDeployClient.listReleasesCallable().call(request);
   *     for (Release element : response.getReleasesList()) {
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
  public final UnaryCallable<ListReleasesRequest, ListReleasesResponse> listReleasesCallable() {
    return stub.listReleasesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Release.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   ReleaseName name =
   *       ReleaseName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]");
   *   Release response = cloudDeployClient.getRelease(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the `Release`. Format must be
   *     projects/{project_id}/locations/{location_name}/deliveryPipelines/{pipeline_name}/releases/{release_name}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Release getRelease(ReleaseName name) {
    GetReleaseRequest request =
        GetReleaseRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getRelease(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Release.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   String name =
   *       ReleaseName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]").toString();
   *   Release response = cloudDeployClient.getRelease(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the `Release`. Format must be
   *     projects/{project_id}/locations/{location_name}/deliveryPipelines/{pipeline_name}/releases/{release_name}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Release getRelease(String name) {
    GetReleaseRequest request = GetReleaseRequest.newBuilder().setName(name).build();
    return getRelease(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Release.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   GetReleaseRequest request =
   *       GetReleaseRequest.newBuilder()
   *           .setName(
   *               ReleaseName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]")
   *                   .toString())
   *           .build();
   *   Release response = cloudDeployClient.getRelease(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Release getRelease(GetReleaseRequest request) {
    return getReleaseCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Release.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   GetReleaseRequest request =
   *       GetReleaseRequest.newBuilder()
   *           .setName(
   *               ReleaseName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Release> future = cloudDeployClient.getReleaseCallable().futureCall(request);
   *   // Do something.
   *   Release response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetReleaseRequest, Release> getReleaseCallable() {
    return stub.getReleaseCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Release in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   DeliveryPipelineName parent =
   *       DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]");
   *   Release release = Release.newBuilder().build();
   *   String releaseId = "releaseId89607042";
   *   Release response = cloudDeployClient.createReleaseAsync(parent, release, releaseId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent collection in which the `Release` should be created. Format
   *     should be
   *     projects/{project_id}/locations/{location_name}/deliveryPipelines/{pipeline_name}.
   * @param release Required. The `Release` to create.
   * @param releaseId Required. ID of the `Release`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Release, OperationMetadata> createReleaseAsync(
      DeliveryPipelineName parent, Release release, String releaseId) {
    CreateReleaseRequest request =
        CreateReleaseRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setRelease(release)
            .setReleaseId(releaseId)
            .build();
    return createReleaseAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Release in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   String parent =
   *       DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]").toString();
   *   Release release = Release.newBuilder().build();
   *   String releaseId = "releaseId89607042";
   *   Release response = cloudDeployClient.createReleaseAsync(parent, release, releaseId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent collection in which the `Release` should be created. Format
   *     should be
   *     projects/{project_id}/locations/{location_name}/deliveryPipelines/{pipeline_name}.
   * @param release Required. The `Release` to create.
   * @param releaseId Required. ID of the `Release`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Release, OperationMetadata> createReleaseAsync(
      String parent, Release release, String releaseId) {
    CreateReleaseRequest request =
        CreateReleaseRequest.newBuilder()
            .setParent(parent)
            .setRelease(release)
            .setReleaseId(releaseId)
            .build();
    return createReleaseAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Release in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   CreateReleaseRequest request =
   *       CreateReleaseRequest.newBuilder()
   *           .setParent(
   *               DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]")
   *                   .toString())
   *           .setReleaseId("releaseId89607042")
   *           .setRelease(Release.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   Release response = cloudDeployClient.createReleaseAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Release, OperationMetadata> createReleaseAsync(
      CreateReleaseRequest request) {
    return createReleaseOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Release in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   CreateReleaseRequest request =
   *       CreateReleaseRequest.newBuilder()
   *           .setParent(
   *               DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]")
   *                   .toString())
   *           .setReleaseId("releaseId89607042")
   *           .setRelease(Release.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Release, OperationMetadata> future =
   *       cloudDeployClient.createReleaseOperationCallable().futureCall(request);
   *   // Do something.
   *   Release response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateReleaseRequest, Release, OperationMetadata>
      createReleaseOperationCallable() {
    return stub.createReleaseOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Release in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   CreateReleaseRequest request =
   *       CreateReleaseRequest.newBuilder()
   *           .setParent(
   *               DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]")
   *                   .toString())
   *           .setReleaseId("releaseId89607042")
   *           .setRelease(Release.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future = cloudDeployClient.createReleaseCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateReleaseRequest, Operation> createReleaseCallable() {
    return stub.createReleaseCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Abandons a Release in the Delivery Pipeline.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   ReleaseName name =
   *       ReleaseName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]");
   *   AbandonReleaseResponse response = cloudDeployClient.abandonRelease(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the Release. Format is
   *     projects/{project}/locations/{location}/deliveryPipelines/{deliveryPipeline}/
   *     releases/{release}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AbandonReleaseResponse abandonRelease(ReleaseName name) {
    AbandonReleaseRequest request =
        AbandonReleaseRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return abandonRelease(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Abandons a Release in the Delivery Pipeline.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   String name =
   *       ReleaseName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]").toString();
   *   AbandonReleaseResponse response = cloudDeployClient.abandonRelease(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the Release. Format is
   *     projects/{project}/locations/{location}/deliveryPipelines/{deliveryPipeline}/
   *     releases/{release}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AbandonReleaseResponse abandonRelease(String name) {
    AbandonReleaseRequest request = AbandonReleaseRequest.newBuilder().setName(name).build();
    return abandonRelease(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Abandons a Release in the Delivery Pipeline.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   AbandonReleaseRequest request =
   *       AbandonReleaseRequest.newBuilder()
   *           .setName(
   *               ReleaseName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]")
   *                   .toString())
   *           .build();
   *   AbandonReleaseResponse response = cloudDeployClient.abandonRelease(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AbandonReleaseResponse abandonRelease(AbandonReleaseRequest request) {
    return abandonReleaseCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Abandons a Release in the Delivery Pipeline.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   AbandonReleaseRequest request =
   *       AbandonReleaseRequest.newBuilder()
   *           .setName(
   *               ReleaseName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<AbandonReleaseResponse> future =
   *       cloudDeployClient.abandonReleaseCallable().futureCall(request);
   *   // Do something.
   *   AbandonReleaseResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AbandonReleaseRequest, AbandonReleaseResponse>
      abandonReleaseCallable() {
    return stub.abandonReleaseCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Approves a Rollout.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   RolloutName name =
   *       RolloutName.of(
   *           "[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]", "[ROLLOUT]");
   *   ApproveRolloutResponse response = cloudDeployClient.approveRollout(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the Rollout. Format is
   *     projects/{project}/locations/{location}/deliveryPipelines/{deliveryPipeline}/
   *     releases/{release}/rollouts/{rollout}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApproveRolloutResponse approveRollout(RolloutName name) {
    ApproveRolloutRequest request =
        ApproveRolloutRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return approveRollout(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Approves a Rollout.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   String name =
   *       RolloutName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]", "[ROLLOUT]")
   *           .toString();
   *   ApproveRolloutResponse response = cloudDeployClient.approveRollout(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the Rollout. Format is
   *     projects/{project}/locations/{location}/deliveryPipelines/{deliveryPipeline}/
   *     releases/{release}/rollouts/{rollout}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApproveRolloutResponse approveRollout(String name) {
    ApproveRolloutRequest request = ApproveRolloutRequest.newBuilder().setName(name).build();
    return approveRollout(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Approves a Rollout.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   ApproveRolloutRequest request =
   *       ApproveRolloutRequest.newBuilder()
   *           .setName(
   *               RolloutName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[DELIVERY_PIPELINE]",
   *                       "[RELEASE]",
   *                       "[ROLLOUT]")
   *                   .toString())
   *           .setApproved(true)
   *           .build();
   *   ApproveRolloutResponse response = cloudDeployClient.approveRollout(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApproveRolloutResponse approveRollout(ApproveRolloutRequest request) {
    return approveRolloutCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Approves a Rollout.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   ApproveRolloutRequest request =
   *       ApproveRolloutRequest.newBuilder()
   *           .setName(
   *               RolloutName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[DELIVERY_PIPELINE]",
   *                       "[RELEASE]",
   *                       "[ROLLOUT]")
   *                   .toString())
   *           .setApproved(true)
   *           .build();
   *   ApiFuture<ApproveRolloutResponse> future =
   *       cloudDeployClient.approveRolloutCallable().futureCall(request);
   *   // Do something.
   *   ApproveRolloutResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ApproveRolloutRequest, ApproveRolloutResponse>
      approveRolloutCallable() {
    return stub.approveRolloutCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Rollouts in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   ReleaseName parent =
   *       ReleaseName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]");
   *   for (Rollout element : cloudDeployClient.listRollouts(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The `Release` which owns this collection of `Rollout` objects.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRolloutsPagedResponse listRollouts(ReleaseName parent) {
    ListRolloutsRequest request =
        ListRolloutsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listRollouts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Rollouts in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   String parent =
   *       ReleaseName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]").toString();
   *   for (Rollout element : cloudDeployClient.listRollouts(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The `Release` which owns this collection of `Rollout` objects.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRolloutsPagedResponse listRollouts(String parent) {
    ListRolloutsRequest request = ListRolloutsRequest.newBuilder().setParent(parent).build();
    return listRollouts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Rollouts in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   ListRolloutsRequest request =
   *       ListRolloutsRequest.newBuilder()
   *           .setParent(
   *               ReleaseName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Rollout element : cloudDeployClient.listRollouts(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRolloutsPagedResponse listRollouts(ListRolloutsRequest request) {
    return listRolloutsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Rollouts in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   ListRolloutsRequest request =
   *       ListRolloutsRequest.newBuilder()
   *           .setParent(
   *               ReleaseName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Rollout> future = cloudDeployClient.listRolloutsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Rollout element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListRolloutsRequest, ListRolloutsPagedResponse>
      listRolloutsPagedCallable() {
    return stub.listRolloutsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Rollouts in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   ListRolloutsRequest request =
   *       ListRolloutsRequest.newBuilder()
   *           .setParent(
   *               ReleaseName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListRolloutsResponse response = cloudDeployClient.listRolloutsCallable().call(request);
   *     for (Rollout element : response.getRolloutsList()) {
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
  public final UnaryCallable<ListRolloutsRequest, ListRolloutsResponse> listRolloutsCallable() {
    return stub.listRolloutsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Rollout.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   RolloutName name =
   *       RolloutName.of(
   *           "[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]", "[ROLLOUT]");
   *   Rollout response = cloudDeployClient.getRollout(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the `Rollout`. Format must be
   *     projects/{project_id}/locations/{location_name}/deliveryPipelines/{pipeline_name}/releases/{release_name}/rollouts/{rollout_name}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Rollout getRollout(RolloutName name) {
    GetRolloutRequest request =
        GetRolloutRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getRollout(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Rollout.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   String name =
   *       RolloutName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]", "[ROLLOUT]")
   *           .toString();
   *   Rollout response = cloudDeployClient.getRollout(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the `Rollout`. Format must be
   *     projects/{project_id}/locations/{location_name}/deliveryPipelines/{pipeline_name}/releases/{release_name}/rollouts/{rollout_name}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Rollout getRollout(String name) {
    GetRolloutRequest request = GetRolloutRequest.newBuilder().setName(name).build();
    return getRollout(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Rollout.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   GetRolloutRequest request =
   *       GetRolloutRequest.newBuilder()
   *           .setName(
   *               RolloutName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[DELIVERY_PIPELINE]",
   *                       "[RELEASE]",
   *                       "[ROLLOUT]")
   *                   .toString())
   *           .build();
   *   Rollout response = cloudDeployClient.getRollout(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Rollout getRollout(GetRolloutRequest request) {
    return getRolloutCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Rollout.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   GetRolloutRequest request =
   *       GetRolloutRequest.newBuilder()
   *           .setName(
   *               RolloutName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[DELIVERY_PIPELINE]",
   *                       "[RELEASE]",
   *                       "[ROLLOUT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Rollout> future = cloudDeployClient.getRolloutCallable().futureCall(request);
   *   // Do something.
   *   Rollout response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRolloutRequest, Rollout> getRolloutCallable() {
    return stub.getRolloutCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Rollout in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   ReleaseName parent =
   *       ReleaseName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]");
   *   Rollout rollout = Rollout.newBuilder().build();
   *   String rolloutId = "rolloutId551248556";
   *   Rollout response = cloudDeployClient.createRolloutAsync(parent, rollout, rolloutId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent collection in which the `Rollout` should be created. Format
   *     should be
   *     projects/{project_id}/locations/{location_name}/deliveryPipelines/{pipeline_name}/releases/{release_name}.
   * @param rollout Required. The `Rollout` to create.
   * @param rolloutId Required. ID of the `Rollout`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Rollout, OperationMetadata> createRolloutAsync(
      ReleaseName parent, Rollout rollout, String rolloutId) {
    CreateRolloutRequest request =
        CreateRolloutRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setRollout(rollout)
            .setRolloutId(rolloutId)
            .build();
    return createRolloutAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Rollout in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   String parent =
   *       ReleaseName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]").toString();
   *   Rollout rollout = Rollout.newBuilder().build();
   *   String rolloutId = "rolloutId551248556";
   *   Rollout response = cloudDeployClient.createRolloutAsync(parent, rollout, rolloutId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent collection in which the `Rollout` should be created. Format
   *     should be
   *     projects/{project_id}/locations/{location_name}/deliveryPipelines/{pipeline_name}/releases/{release_name}.
   * @param rollout Required. The `Rollout` to create.
   * @param rolloutId Required. ID of the `Rollout`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Rollout, OperationMetadata> createRolloutAsync(
      String parent, Rollout rollout, String rolloutId) {
    CreateRolloutRequest request =
        CreateRolloutRequest.newBuilder()
            .setParent(parent)
            .setRollout(rollout)
            .setRolloutId(rolloutId)
            .build();
    return createRolloutAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Rollout in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   CreateRolloutRequest request =
   *       CreateRolloutRequest.newBuilder()
   *           .setParent(
   *               ReleaseName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]")
   *                   .toString())
   *           .setRolloutId("rolloutId551248556")
   *           .setRollout(Rollout.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   Rollout response = cloudDeployClient.createRolloutAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Rollout, OperationMetadata> createRolloutAsync(
      CreateRolloutRequest request) {
    return createRolloutOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Rollout in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   CreateRolloutRequest request =
   *       CreateRolloutRequest.newBuilder()
   *           .setParent(
   *               ReleaseName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]")
   *                   .toString())
   *           .setRolloutId("rolloutId551248556")
   *           .setRollout(Rollout.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Rollout, OperationMetadata> future =
   *       cloudDeployClient.createRolloutOperationCallable().futureCall(request);
   *   // Do something.
   *   Rollout response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateRolloutRequest, Rollout, OperationMetadata>
      createRolloutOperationCallable() {
    return stub.createRolloutOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Rollout in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   CreateRolloutRequest request =
   *       CreateRolloutRequest.newBuilder()
   *           .setParent(
   *               ReleaseName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]")
   *                   .toString())
   *           .setRolloutId("rolloutId551248556")
   *           .setRollout(Rollout.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future = cloudDeployClient.createRolloutCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateRolloutRequest, Operation> createRolloutCallable() {
    return stub.createRolloutCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retries the specified Job in a Rollout.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   RolloutName rollout =
   *       RolloutName.of(
   *           "[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]", "[ROLLOUT]");
   *   String phaseId = "phaseId-608264202";
   *   String jobId = "jobId101296568";
   *   RetryJobResponse response = cloudDeployClient.retryJob(rollout, phaseId, jobId);
   * }
   * }</pre>
   *
   * @param rollout Required. Name of the Rollout. Format is
   *     projects/{project}/locations/{location}/deliveryPipelines/{deliveryPipeline}/
   *     releases/{release}/rollouts/{rollout}.
   * @param phaseId Required. The phase ID the Job to retry belongs to.
   * @param jobId Required. The job ID for the Job to retry.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RetryJobResponse retryJob(RolloutName rollout, String phaseId, String jobId) {
    RetryJobRequest request =
        RetryJobRequest.newBuilder()
            .setRollout(rollout == null ? null : rollout.toString())
            .setPhaseId(phaseId)
            .setJobId(jobId)
            .build();
    return retryJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retries the specified Job in a Rollout.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   String rollout =
   *       RolloutName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]", "[ROLLOUT]")
   *           .toString();
   *   String phaseId = "phaseId-608264202";
   *   String jobId = "jobId101296568";
   *   RetryJobResponse response = cloudDeployClient.retryJob(rollout, phaseId, jobId);
   * }
   * }</pre>
   *
   * @param rollout Required. Name of the Rollout. Format is
   *     projects/{project}/locations/{location}/deliveryPipelines/{deliveryPipeline}/
   *     releases/{release}/rollouts/{rollout}.
   * @param phaseId Required. The phase ID the Job to retry belongs to.
   * @param jobId Required. The job ID for the Job to retry.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RetryJobResponse retryJob(String rollout, String phaseId, String jobId) {
    RetryJobRequest request =
        RetryJobRequest.newBuilder()
            .setRollout(rollout)
            .setPhaseId(phaseId)
            .setJobId(jobId)
            .build();
    return retryJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retries the specified Job in a Rollout.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   RetryJobRequest request =
   *       RetryJobRequest.newBuilder()
   *           .setRollout(
   *               RolloutName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[DELIVERY_PIPELINE]",
   *                       "[RELEASE]",
   *                       "[ROLLOUT]")
   *                   .toString())
   *           .setPhaseId("phaseId-608264202")
   *           .setJobId("jobId101296568")
   *           .build();
   *   RetryJobResponse response = cloudDeployClient.retryJob(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RetryJobResponse retryJob(RetryJobRequest request) {
    return retryJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retries the specified Job in a Rollout.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   RetryJobRequest request =
   *       RetryJobRequest.newBuilder()
   *           .setRollout(
   *               RolloutName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[DELIVERY_PIPELINE]",
   *                       "[RELEASE]",
   *                       "[ROLLOUT]")
   *                   .toString())
   *           .setPhaseId("phaseId-608264202")
   *           .setJobId("jobId101296568")
   *           .build();
   *   ApiFuture<RetryJobResponse> future = cloudDeployClient.retryJobCallable().futureCall(request);
   *   // Do something.
   *   RetryJobResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RetryJobRequest, RetryJobResponse> retryJobCallable() {
    return stub.retryJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists JobRuns in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   RolloutName parent =
   *       RolloutName.of(
   *           "[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]", "[ROLLOUT]");
   *   for (JobRun element : cloudDeployClient.listJobRuns(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The `Rollout` which owns this collection of `JobRun` objects.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListJobRunsPagedResponse listJobRuns(RolloutName parent) {
    ListJobRunsRequest request =
        ListJobRunsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listJobRuns(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists JobRuns in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   String parent =
   *       RolloutName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]", "[ROLLOUT]")
   *           .toString();
   *   for (JobRun element : cloudDeployClient.listJobRuns(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The `Rollout` which owns this collection of `JobRun` objects.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListJobRunsPagedResponse listJobRuns(String parent) {
    ListJobRunsRequest request = ListJobRunsRequest.newBuilder().setParent(parent).build();
    return listJobRuns(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists JobRuns in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   ListJobRunsRequest request =
   *       ListJobRunsRequest.newBuilder()
   *           .setParent(
   *               RolloutName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[DELIVERY_PIPELINE]",
   *                       "[RELEASE]",
   *                       "[ROLLOUT]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (JobRun element : cloudDeployClient.listJobRuns(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListJobRunsPagedResponse listJobRuns(ListJobRunsRequest request) {
    return listJobRunsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists JobRuns in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   ListJobRunsRequest request =
   *       ListJobRunsRequest.newBuilder()
   *           .setParent(
   *               RolloutName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[DELIVERY_PIPELINE]",
   *                       "[RELEASE]",
   *                       "[ROLLOUT]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<JobRun> future = cloudDeployClient.listJobRunsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (JobRun element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListJobRunsRequest, ListJobRunsPagedResponse>
      listJobRunsPagedCallable() {
    return stub.listJobRunsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists JobRuns in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   ListJobRunsRequest request =
   *       ListJobRunsRequest.newBuilder()
   *           .setParent(
   *               RolloutName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[DELIVERY_PIPELINE]",
   *                       "[RELEASE]",
   *                       "[ROLLOUT]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListJobRunsResponse response = cloudDeployClient.listJobRunsCallable().call(request);
   *     for (JobRun element : response.getJobRunsList()) {
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
  public final UnaryCallable<ListJobRunsRequest, ListJobRunsResponse> listJobRunsCallable() {
    return stub.listJobRunsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single JobRun.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   JobRunName name =
   *       JobRunName.of(
   *           "[PROJECT]",
   *           "[LOCATION]",
   *           "[DELIVERY_PIPELINE]",
   *           "[RELEASE]",
   *           "[ROLLOUT]",
   *           "[JOB_RUN]");
   *   JobRun response = cloudDeployClient.getJobRun(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the `JobRun`. Format must be
   *     projects/{project_id}/locations/{location_name}/deliveryPipelines/{pipeline_name}/releases/{release_name}/rollouts/{rollout_name}/jobRuns/{job_run_name}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final JobRun getJobRun(JobRunName name) {
    GetJobRunRequest request =
        GetJobRunRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getJobRun(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single JobRun.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   String name =
   *       JobRunName.of(
   *               "[PROJECT]",
   *               "[LOCATION]",
   *               "[DELIVERY_PIPELINE]",
   *               "[RELEASE]",
   *               "[ROLLOUT]",
   *               "[JOB_RUN]")
   *           .toString();
   *   JobRun response = cloudDeployClient.getJobRun(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the `JobRun`. Format must be
   *     projects/{project_id}/locations/{location_name}/deliveryPipelines/{pipeline_name}/releases/{release_name}/rollouts/{rollout_name}/jobRuns/{job_run_name}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final JobRun getJobRun(String name) {
    GetJobRunRequest request = GetJobRunRequest.newBuilder().setName(name).build();
    return getJobRun(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single JobRun.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   GetJobRunRequest request =
   *       GetJobRunRequest.newBuilder()
   *           .setName(
   *               JobRunName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[DELIVERY_PIPELINE]",
   *                       "[RELEASE]",
   *                       "[ROLLOUT]",
   *                       "[JOB_RUN]")
   *                   .toString())
   *           .build();
   *   JobRun response = cloudDeployClient.getJobRun(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final JobRun getJobRun(GetJobRunRequest request) {
    return getJobRunCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single JobRun.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   GetJobRunRequest request =
   *       GetJobRunRequest.newBuilder()
   *           .setName(
   *               JobRunName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[DELIVERY_PIPELINE]",
   *                       "[RELEASE]",
   *                       "[ROLLOUT]",
   *                       "[JOB_RUN]")
   *                   .toString())
   *           .build();
   *   ApiFuture<JobRun> future = cloudDeployClient.getJobRunCallable().futureCall(request);
   *   // Do something.
   *   JobRun response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetJobRunRequest, JobRun> getJobRunCallable() {
    return stub.getJobRunCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the configuration for a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   ConfigName name = ConfigName.of("[PROJECT]", "[LOCATION]");
   *   Config response = cloudDeployClient.getConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of requested configuration.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Config getConfig(ConfigName name) {
    GetConfigRequest request =
        GetConfigRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the configuration for a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   String name = ConfigName.of("[PROJECT]", "[LOCATION]").toString();
   *   Config response = cloudDeployClient.getConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of requested configuration.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Config getConfig(String name) {
    GetConfigRequest request = GetConfigRequest.newBuilder().setName(name).build();
    return getConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the configuration for a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   GetConfigRequest request =
   *       GetConfigRequest.newBuilder()
   *           .setName(ConfigName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   Config response = cloudDeployClient.getConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Config getConfig(GetConfigRequest request) {
    return getConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the configuration for a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   GetConfigRequest request =
   *       GetConfigRequest.newBuilder()
   *           .setName(ConfigName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   ApiFuture<Config> future = cloudDeployClient.getConfigCallable().futureCall(request);
   *   // Do something.
   *   Config response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetConfigRequest, Config> getConfigCallable() {
    return stub.getConfigCallable();
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
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : cloudDeployClient.listLocations(request).iterateAll()) {
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
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       cloudDeployClient.listLocationsPagedCallable().futureCall(request);
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
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = cloudDeployClient.listLocationsCallable().call(request);
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
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = cloudDeployClient.getLocation(request);
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
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = cloudDeployClient.getLocationCallable().futureCall(request);
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
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = cloudDeployClient.setIamPolicy(request);
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
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = cloudDeployClient.setIamPolicyCallable().futureCall(request);
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
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = cloudDeployClient.getIamPolicy(request);
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
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = cloudDeployClient.getIamPolicyCallable().futureCall(request);
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
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = cloudDeployClient.testIamPermissions(request);
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
   * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       cloudDeployClient.testIamPermissionsCallable().futureCall(request);
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

  public static class ListDeliveryPipelinesPagedResponse
      extends AbstractPagedListResponse<
          ListDeliveryPipelinesRequest,
          ListDeliveryPipelinesResponse,
          DeliveryPipeline,
          ListDeliveryPipelinesPage,
          ListDeliveryPipelinesFixedSizeCollection> {

    public static ApiFuture<ListDeliveryPipelinesPagedResponse> createAsync(
        PageContext<ListDeliveryPipelinesRequest, ListDeliveryPipelinesResponse, DeliveryPipeline>
            context,
        ApiFuture<ListDeliveryPipelinesResponse> futureResponse) {
      ApiFuture<ListDeliveryPipelinesPage> futurePage =
          ListDeliveryPipelinesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDeliveryPipelinesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDeliveryPipelinesPagedResponse(ListDeliveryPipelinesPage page) {
      super(page, ListDeliveryPipelinesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDeliveryPipelinesPage
      extends AbstractPage<
          ListDeliveryPipelinesRequest,
          ListDeliveryPipelinesResponse,
          DeliveryPipeline,
          ListDeliveryPipelinesPage> {

    private ListDeliveryPipelinesPage(
        PageContext<ListDeliveryPipelinesRequest, ListDeliveryPipelinesResponse, DeliveryPipeline>
            context,
        ListDeliveryPipelinesResponse response) {
      super(context, response);
    }

    private static ListDeliveryPipelinesPage createEmptyPage() {
      return new ListDeliveryPipelinesPage(null, null);
    }

    @Override
    protected ListDeliveryPipelinesPage createPage(
        PageContext<ListDeliveryPipelinesRequest, ListDeliveryPipelinesResponse, DeliveryPipeline>
            context,
        ListDeliveryPipelinesResponse response) {
      return new ListDeliveryPipelinesPage(context, response);
    }

    @Override
    public ApiFuture<ListDeliveryPipelinesPage> createPageAsync(
        PageContext<ListDeliveryPipelinesRequest, ListDeliveryPipelinesResponse, DeliveryPipeline>
            context,
        ApiFuture<ListDeliveryPipelinesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDeliveryPipelinesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDeliveryPipelinesRequest,
          ListDeliveryPipelinesResponse,
          DeliveryPipeline,
          ListDeliveryPipelinesPage,
          ListDeliveryPipelinesFixedSizeCollection> {

    private ListDeliveryPipelinesFixedSizeCollection(
        List<ListDeliveryPipelinesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDeliveryPipelinesFixedSizeCollection createEmptyCollection() {
      return new ListDeliveryPipelinesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDeliveryPipelinesFixedSizeCollection createCollection(
        List<ListDeliveryPipelinesPage> pages, int collectionSize) {
      return new ListDeliveryPipelinesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListTargetsPagedResponse
      extends AbstractPagedListResponse<
          ListTargetsRequest,
          ListTargetsResponse,
          Target,
          ListTargetsPage,
          ListTargetsFixedSizeCollection> {

    public static ApiFuture<ListTargetsPagedResponse> createAsync(
        PageContext<ListTargetsRequest, ListTargetsResponse, Target> context,
        ApiFuture<ListTargetsResponse> futureResponse) {
      ApiFuture<ListTargetsPage> futurePage =
          ListTargetsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListTargetsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListTargetsPagedResponse(ListTargetsPage page) {
      super(page, ListTargetsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListTargetsPage
      extends AbstractPage<ListTargetsRequest, ListTargetsResponse, Target, ListTargetsPage> {

    private ListTargetsPage(
        PageContext<ListTargetsRequest, ListTargetsResponse, Target> context,
        ListTargetsResponse response) {
      super(context, response);
    }

    private static ListTargetsPage createEmptyPage() {
      return new ListTargetsPage(null, null);
    }

    @Override
    protected ListTargetsPage createPage(
        PageContext<ListTargetsRequest, ListTargetsResponse, Target> context,
        ListTargetsResponse response) {
      return new ListTargetsPage(context, response);
    }

    @Override
    public ApiFuture<ListTargetsPage> createPageAsync(
        PageContext<ListTargetsRequest, ListTargetsResponse, Target> context,
        ApiFuture<ListTargetsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListTargetsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTargetsRequest,
          ListTargetsResponse,
          Target,
          ListTargetsPage,
          ListTargetsFixedSizeCollection> {

    private ListTargetsFixedSizeCollection(List<ListTargetsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTargetsFixedSizeCollection createEmptyCollection() {
      return new ListTargetsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTargetsFixedSizeCollection createCollection(
        List<ListTargetsPage> pages, int collectionSize) {
      return new ListTargetsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListReleasesPagedResponse
      extends AbstractPagedListResponse<
          ListReleasesRequest,
          ListReleasesResponse,
          Release,
          ListReleasesPage,
          ListReleasesFixedSizeCollection> {

    public static ApiFuture<ListReleasesPagedResponse> createAsync(
        PageContext<ListReleasesRequest, ListReleasesResponse, Release> context,
        ApiFuture<ListReleasesResponse> futureResponse) {
      ApiFuture<ListReleasesPage> futurePage =
          ListReleasesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListReleasesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListReleasesPagedResponse(ListReleasesPage page) {
      super(page, ListReleasesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListReleasesPage
      extends AbstractPage<ListReleasesRequest, ListReleasesResponse, Release, ListReleasesPage> {

    private ListReleasesPage(
        PageContext<ListReleasesRequest, ListReleasesResponse, Release> context,
        ListReleasesResponse response) {
      super(context, response);
    }

    private static ListReleasesPage createEmptyPage() {
      return new ListReleasesPage(null, null);
    }

    @Override
    protected ListReleasesPage createPage(
        PageContext<ListReleasesRequest, ListReleasesResponse, Release> context,
        ListReleasesResponse response) {
      return new ListReleasesPage(context, response);
    }

    @Override
    public ApiFuture<ListReleasesPage> createPageAsync(
        PageContext<ListReleasesRequest, ListReleasesResponse, Release> context,
        ApiFuture<ListReleasesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListReleasesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListReleasesRequest,
          ListReleasesResponse,
          Release,
          ListReleasesPage,
          ListReleasesFixedSizeCollection> {

    private ListReleasesFixedSizeCollection(List<ListReleasesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListReleasesFixedSizeCollection createEmptyCollection() {
      return new ListReleasesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListReleasesFixedSizeCollection createCollection(
        List<ListReleasesPage> pages, int collectionSize) {
      return new ListReleasesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListRolloutsPagedResponse
      extends AbstractPagedListResponse<
          ListRolloutsRequest,
          ListRolloutsResponse,
          Rollout,
          ListRolloutsPage,
          ListRolloutsFixedSizeCollection> {

    public static ApiFuture<ListRolloutsPagedResponse> createAsync(
        PageContext<ListRolloutsRequest, ListRolloutsResponse, Rollout> context,
        ApiFuture<ListRolloutsResponse> futureResponse) {
      ApiFuture<ListRolloutsPage> futurePage =
          ListRolloutsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListRolloutsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListRolloutsPagedResponse(ListRolloutsPage page) {
      super(page, ListRolloutsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListRolloutsPage
      extends AbstractPage<ListRolloutsRequest, ListRolloutsResponse, Rollout, ListRolloutsPage> {

    private ListRolloutsPage(
        PageContext<ListRolloutsRequest, ListRolloutsResponse, Rollout> context,
        ListRolloutsResponse response) {
      super(context, response);
    }

    private static ListRolloutsPage createEmptyPage() {
      return new ListRolloutsPage(null, null);
    }

    @Override
    protected ListRolloutsPage createPage(
        PageContext<ListRolloutsRequest, ListRolloutsResponse, Rollout> context,
        ListRolloutsResponse response) {
      return new ListRolloutsPage(context, response);
    }

    @Override
    public ApiFuture<ListRolloutsPage> createPageAsync(
        PageContext<ListRolloutsRequest, ListRolloutsResponse, Rollout> context,
        ApiFuture<ListRolloutsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListRolloutsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRolloutsRequest,
          ListRolloutsResponse,
          Rollout,
          ListRolloutsPage,
          ListRolloutsFixedSizeCollection> {

    private ListRolloutsFixedSizeCollection(List<ListRolloutsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListRolloutsFixedSizeCollection createEmptyCollection() {
      return new ListRolloutsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListRolloutsFixedSizeCollection createCollection(
        List<ListRolloutsPage> pages, int collectionSize) {
      return new ListRolloutsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListJobRunsPagedResponse
      extends AbstractPagedListResponse<
          ListJobRunsRequest,
          ListJobRunsResponse,
          JobRun,
          ListJobRunsPage,
          ListJobRunsFixedSizeCollection> {

    public static ApiFuture<ListJobRunsPagedResponse> createAsync(
        PageContext<ListJobRunsRequest, ListJobRunsResponse, JobRun> context,
        ApiFuture<ListJobRunsResponse> futureResponse) {
      ApiFuture<ListJobRunsPage> futurePage =
          ListJobRunsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListJobRunsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListJobRunsPagedResponse(ListJobRunsPage page) {
      super(page, ListJobRunsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListJobRunsPage
      extends AbstractPage<ListJobRunsRequest, ListJobRunsResponse, JobRun, ListJobRunsPage> {

    private ListJobRunsPage(
        PageContext<ListJobRunsRequest, ListJobRunsResponse, JobRun> context,
        ListJobRunsResponse response) {
      super(context, response);
    }

    private static ListJobRunsPage createEmptyPage() {
      return new ListJobRunsPage(null, null);
    }

    @Override
    protected ListJobRunsPage createPage(
        PageContext<ListJobRunsRequest, ListJobRunsResponse, JobRun> context,
        ListJobRunsResponse response) {
      return new ListJobRunsPage(context, response);
    }

    @Override
    public ApiFuture<ListJobRunsPage> createPageAsync(
        PageContext<ListJobRunsRequest, ListJobRunsResponse, JobRun> context,
        ApiFuture<ListJobRunsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListJobRunsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListJobRunsRequest,
          ListJobRunsResponse,
          JobRun,
          ListJobRunsPage,
          ListJobRunsFixedSizeCollection> {

    private ListJobRunsFixedSizeCollection(List<ListJobRunsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListJobRunsFixedSizeCollection createEmptyCollection() {
      return new ListJobRunsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListJobRunsFixedSizeCollection createCollection(
        List<ListJobRunsPage> pages, int collectionSize) {
      return new ListJobRunsFixedSizeCollection(pages, collectionSize);
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
