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

package com.google.cloud.assuredworkloads.v1;

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
import com.google.cloud.assuredworkloads.v1.stub.AssuredWorkloadsServiceStub;
import com.google.cloud.assuredworkloads.v1.stub.AssuredWorkloadsServiceStubSettings;
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
 * Service Description: Service to manage AssuredWorkloads.
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
 * try (AssuredWorkloadsServiceClient assuredWorkloadsServiceClient =
 *     AssuredWorkloadsServiceClient.create()) {
 *   Workload workload = Workload.newBuilder().build();
 *   FieldMask updateMask = FieldMask.newBuilder().build();
 *   Workload response = assuredWorkloadsServiceClient.updateWorkload(workload, updateMask);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the AssuredWorkloadsServiceClient object to clean up
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
 * AssuredWorkloadsServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AssuredWorkloadsServiceSettings assuredWorkloadsServiceSettings =
 *     AssuredWorkloadsServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * AssuredWorkloadsServiceClient assuredWorkloadsServiceClient =
 *     AssuredWorkloadsServiceClient.create(assuredWorkloadsServiceSettings);
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
 * AssuredWorkloadsServiceSettings assuredWorkloadsServiceSettings =
 *     AssuredWorkloadsServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * AssuredWorkloadsServiceClient assuredWorkloadsServiceClient =
 *     AssuredWorkloadsServiceClient.create(assuredWorkloadsServiceSettings);
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
 * AssuredWorkloadsServiceSettings assuredWorkloadsServiceSettings =
 *     AssuredWorkloadsServiceSettings.newBuilder()
 *         .setTransportChannelProvider(
 *             AssuredWorkloadsServiceSettings.defaultHttpJsonTransportProviderBuilder().build())
 *         .build();
 * AssuredWorkloadsServiceClient assuredWorkloadsServiceClient =
 *     AssuredWorkloadsServiceClient.create(assuredWorkloadsServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class AssuredWorkloadsServiceClient implements BackgroundResource {
  private final AssuredWorkloadsServiceSettings settings;
  private final AssuredWorkloadsServiceStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of AssuredWorkloadsServiceClient with default settings. */
  public static final AssuredWorkloadsServiceClient create() throws IOException {
    return create(AssuredWorkloadsServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of AssuredWorkloadsServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final AssuredWorkloadsServiceClient create(AssuredWorkloadsServiceSettings settings)
      throws IOException {
    return new AssuredWorkloadsServiceClient(settings);
  }

  /**
   * Constructs an instance of AssuredWorkloadsServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(AssuredWorkloadsServiceSettings).
   */
  public static final AssuredWorkloadsServiceClient create(AssuredWorkloadsServiceStub stub) {
    return new AssuredWorkloadsServiceClient(stub);
  }

  /**
   * Constructs an instance of AssuredWorkloadsServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected AssuredWorkloadsServiceClient(AssuredWorkloadsServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((AssuredWorkloadsServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected AssuredWorkloadsServiceClient(AssuredWorkloadsServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final AssuredWorkloadsServiceSettings getSettings() {
    return settings;
  }

  public AssuredWorkloadsServiceStub getStub() {
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
   * Creates Assured Workload.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AssuredWorkloadsServiceClient assuredWorkloadsServiceClient =
   *     AssuredWorkloadsServiceClient.create()) {
   *   LocationName parent = LocationName.of("[ORGANIZATION]", "[LOCATION]");
   *   Workload workload = Workload.newBuilder().build();
   *   Workload response = assuredWorkloadsServiceClient.createWorkloadAsync(parent, workload).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the new Workload's parent. Must be of the form
   *     `organizations/{org_id}/locations/{location_id}`.
   * @param workload Required. Assured Workload to create
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Workload, CreateWorkloadOperationMetadata> createWorkloadAsync(
      LocationName parent, Workload workload) {
    CreateWorkloadRequest request =
        CreateWorkloadRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setWorkload(workload)
            .build();
    return createWorkloadAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates Assured Workload.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AssuredWorkloadsServiceClient assuredWorkloadsServiceClient =
   *     AssuredWorkloadsServiceClient.create()) {
   *   String parent = LocationName.of("[ORGANIZATION]", "[LOCATION]").toString();
   *   Workload workload = Workload.newBuilder().build();
   *   Workload response = assuredWorkloadsServiceClient.createWorkloadAsync(parent, workload).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the new Workload's parent. Must be of the form
   *     `organizations/{org_id}/locations/{location_id}`.
   * @param workload Required. Assured Workload to create
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Workload, CreateWorkloadOperationMetadata> createWorkloadAsync(
      String parent, Workload workload) {
    CreateWorkloadRequest request =
        CreateWorkloadRequest.newBuilder().setParent(parent).setWorkload(workload).build();
    return createWorkloadAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates Assured Workload.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AssuredWorkloadsServiceClient assuredWorkloadsServiceClient =
   *     AssuredWorkloadsServiceClient.create()) {
   *   CreateWorkloadRequest request =
   *       CreateWorkloadRequest.newBuilder()
   *           .setParent(LocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setWorkload(Workload.newBuilder().build())
   *           .setExternalId("externalId-1699764666")
   *           .build();
   *   Workload response = assuredWorkloadsServiceClient.createWorkloadAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Workload, CreateWorkloadOperationMetadata> createWorkloadAsync(
      CreateWorkloadRequest request) {
    return createWorkloadOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates Assured Workload.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AssuredWorkloadsServiceClient assuredWorkloadsServiceClient =
   *     AssuredWorkloadsServiceClient.create()) {
   *   CreateWorkloadRequest request =
   *       CreateWorkloadRequest.newBuilder()
   *           .setParent(LocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setWorkload(Workload.newBuilder().build())
   *           .setExternalId("externalId-1699764666")
   *           .build();
   *   OperationFuture<Workload, CreateWorkloadOperationMetadata> future =
   *       assuredWorkloadsServiceClient.createWorkloadOperationCallable().futureCall(request);
   *   // Do something.
   *   Workload response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateWorkloadRequest, Workload, CreateWorkloadOperationMetadata>
      createWorkloadOperationCallable() {
    return stub.createWorkloadOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates Assured Workload.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AssuredWorkloadsServiceClient assuredWorkloadsServiceClient =
   *     AssuredWorkloadsServiceClient.create()) {
   *   CreateWorkloadRequest request =
   *       CreateWorkloadRequest.newBuilder()
   *           .setParent(LocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setWorkload(Workload.newBuilder().build())
   *           .setExternalId("externalId-1699764666")
   *           .build();
   *   ApiFuture<Operation> future =
   *       assuredWorkloadsServiceClient.createWorkloadCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateWorkloadRequest, Operation> createWorkloadCallable() {
    return stub.createWorkloadCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing workload. Currently allows updating of workload display_name and labels.
   * For force updates don't set etag field in the Workload. Only one update operation per workload
   * can be in progress.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AssuredWorkloadsServiceClient assuredWorkloadsServiceClient =
   *     AssuredWorkloadsServiceClient.create()) {
   *   Workload workload = Workload.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Workload response = assuredWorkloadsServiceClient.updateWorkload(workload, updateMask);
   * }
   * }</pre>
   *
   * @param workload Required. The workload to update. The workload’s `name` field is used to
   *     identify the workload to be updated. Format:
   *     organizations/{org_id}/locations/{location_id}/workloads/{workload_id}
   * @param updateMask Required. The list of fields to be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Workload updateWorkload(Workload workload, FieldMask updateMask) {
    UpdateWorkloadRequest request =
        UpdateWorkloadRequest.newBuilder().setWorkload(workload).setUpdateMask(updateMask).build();
    return updateWorkload(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing workload. Currently allows updating of workload display_name and labels.
   * For force updates don't set etag field in the Workload. Only one update operation per workload
   * can be in progress.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AssuredWorkloadsServiceClient assuredWorkloadsServiceClient =
   *     AssuredWorkloadsServiceClient.create()) {
   *   UpdateWorkloadRequest request =
   *       UpdateWorkloadRequest.newBuilder()
   *           .setWorkload(Workload.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Workload response = assuredWorkloadsServiceClient.updateWorkload(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Workload updateWorkload(UpdateWorkloadRequest request) {
    return updateWorkloadCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing workload. Currently allows updating of workload display_name and labels.
   * For force updates don't set etag field in the Workload. Only one update operation per workload
   * can be in progress.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AssuredWorkloadsServiceClient assuredWorkloadsServiceClient =
   *     AssuredWorkloadsServiceClient.create()) {
   *   UpdateWorkloadRequest request =
   *       UpdateWorkloadRequest.newBuilder()
   *           .setWorkload(Workload.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Workload> future =
   *       assuredWorkloadsServiceClient.updateWorkloadCallable().futureCall(request);
   *   // Do something.
   *   Workload response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateWorkloadRequest, Workload> updateWorkloadCallable() {
    return stub.updateWorkloadCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the workload. Make sure that workload's direct children are already in a deleted state,
   * otherwise the request will fail with a FAILED_PRECONDITION error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AssuredWorkloadsServiceClient assuredWorkloadsServiceClient =
   *     AssuredWorkloadsServiceClient.create()) {
   *   WorkloadName name = WorkloadName.of("[ORGANIZATION]", "[LOCATION]", "[WORKLOAD]");
   *   assuredWorkloadsServiceClient.deleteWorkload(name);
   * }
   * }</pre>
   *
   * @param name Required. The `name` field is used to identify the workload. Format:
   *     organizations/{org_id}/locations/{location_id}/workloads/{workload_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteWorkload(WorkloadName name) {
    DeleteWorkloadRequest request =
        DeleteWorkloadRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteWorkload(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the workload. Make sure that workload's direct children are already in a deleted state,
   * otherwise the request will fail with a FAILED_PRECONDITION error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AssuredWorkloadsServiceClient assuredWorkloadsServiceClient =
   *     AssuredWorkloadsServiceClient.create()) {
   *   String name = WorkloadName.of("[ORGANIZATION]", "[LOCATION]", "[WORKLOAD]").toString();
   *   assuredWorkloadsServiceClient.deleteWorkload(name);
   * }
   * }</pre>
   *
   * @param name Required. The `name` field is used to identify the workload. Format:
   *     organizations/{org_id}/locations/{location_id}/workloads/{workload_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteWorkload(String name) {
    DeleteWorkloadRequest request = DeleteWorkloadRequest.newBuilder().setName(name).build();
    deleteWorkload(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the workload. Make sure that workload's direct children are already in a deleted state,
   * otherwise the request will fail with a FAILED_PRECONDITION error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AssuredWorkloadsServiceClient assuredWorkloadsServiceClient =
   *     AssuredWorkloadsServiceClient.create()) {
   *   DeleteWorkloadRequest request =
   *       DeleteWorkloadRequest.newBuilder()
   *           .setName(WorkloadName.of("[ORGANIZATION]", "[LOCATION]", "[WORKLOAD]").toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   assuredWorkloadsServiceClient.deleteWorkload(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteWorkload(DeleteWorkloadRequest request) {
    deleteWorkloadCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the workload. Make sure that workload's direct children are already in a deleted state,
   * otherwise the request will fail with a FAILED_PRECONDITION error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AssuredWorkloadsServiceClient assuredWorkloadsServiceClient =
   *     AssuredWorkloadsServiceClient.create()) {
   *   DeleteWorkloadRequest request =
   *       DeleteWorkloadRequest.newBuilder()
   *           .setName(WorkloadName.of("[ORGANIZATION]", "[LOCATION]", "[WORKLOAD]").toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Empty> future =
   *       assuredWorkloadsServiceClient.deleteWorkloadCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteWorkloadRequest, Empty> deleteWorkloadCallable() {
    return stub.deleteWorkloadCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets Assured Workload associated with a CRM Node
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AssuredWorkloadsServiceClient assuredWorkloadsServiceClient =
   *     AssuredWorkloadsServiceClient.create()) {
   *   WorkloadName name = WorkloadName.of("[ORGANIZATION]", "[LOCATION]", "[WORKLOAD]");
   *   Workload response = assuredWorkloadsServiceClient.getWorkload(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Workload to fetch. This is the workloads's
   *     relative path in the API, formatted as
   *     "organizations/{organization_id}/locations/{location_id}/workloads/{workload_id}". For
   *     example, "organizations/123/locations/us-east1/workloads/assured-workload-1".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Workload getWorkload(WorkloadName name) {
    GetWorkloadRequest request =
        GetWorkloadRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getWorkload(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets Assured Workload associated with a CRM Node
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AssuredWorkloadsServiceClient assuredWorkloadsServiceClient =
   *     AssuredWorkloadsServiceClient.create()) {
   *   String name = WorkloadName.of("[ORGANIZATION]", "[LOCATION]", "[WORKLOAD]").toString();
   *   Workload response = assuredWorkloadsServiceClient.getWorkload(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Workload to fetch. This is the workloads's
   *     relative path in the API, formatted as
   *     "organizations/{organization_id}/locations/{location_id}/workloads/{workload_id}". For
   *     example, "organizations/123/locations/us-east1/workloads/assured-workload-1".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Workload getWorkload(String name) {
    GetWorkloadRequest request = GetWorkloadRequest.newBuilder().setName(name).build();
    return getWorkload(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets Assured Workload associated with a CRM Node
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AssuredWorkloadsServiceClient assuredWorkloadsServiceClient =
   *     AssuredWorkloadsServiceClient.create()) {
   *   GetWorkloadRequest request =
   *       GetWorkloadRequest.newBuilder()
   *           .setName(WorkloadName.of("[ORGANIZATION]", "[LOCATION]", "[WORKLOAD]").toString())
   *           .build();
   *   Workload response = assuredWorkloadsServiceClient.getWorkload(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Workload getWorkload(GetWorkloadRequest request) {
    return getWorkloadCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets Assured Workload associated with a CRM Node
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AssuredWorkloadsServiceClient assuredWorkloadsServiceClient =
   *     AssuredWorkloadsServiceClient.create()) {
   *   GetWorkloadRequest request =
   *       GetWorkloadRequest.newBuilder()
   *           .setName(WorkloadName.of("[ORGANIZATION]", "[LOCATION]", "[WORKLOAD]").toString())
   *           .build();
   *   ApiFuture<Workload> future =
   *       assuredWorkloadsServiceClient.getWorkloadCallable().futureCall(request);
   *   // Do something.
   *   Workload response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetWorkloadRequest, Workload> getWorkloadCallable() {
    return stub.getWorkloadCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Assured Workloads under a CRM Node.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AssuredWorkloadsServiceClient assuredWorkloadsServiceClient =
   *     AssuredWorkloadsServiceClient.create()) {
   *   LocationName parent = LocationName.of("[ORGANIZATION]", "[LOCATION]");
   *   for (Workload element : assuredWorkloadsServiceClient.listWorkloads(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent Resource to list workloads from. Must be of the form
   *     `organizations/{org_id}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListWorkloadsPagedResponse listWorkloads(LocationName parent) {
    ListWorkloadsRequest request =
        ListWorkloadsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listWorkloads(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Assured Workloads under a CRM Node.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AssuredWorkloadsServiceClient assuredWorkloadsServiceClient =
   *     AssuredWorkloadsServiceClient.create()) {
   *   String parent = LocationName.of("[ORGANIZATION]", "[LOCATION]").toString();
   *   for (Workload element : assuredWorkloadsServiceClient.listWorkloads(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent Resource to list workloads from. Must be of the form
   *     `organizations/{org_id}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListWorkloadsPagedResponse listWorkloads(String parent) {
    ListWorkloadsRequest request = ListWorkloadsRequest.newBuilder().setParent(parent).build();
    return listWorkloads(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Assured Workloads under a CRM Node.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AssuredWorkloadsServiceClient assuredWorkloadsServiceClient =
   *     AssuredWorkloadsServiceClient.create()) {
   *   ListWorkloadsRequest request =
   *       ListWorkloadsRequest.newBuilder()
   *           .setParent(LocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (Workload element : assuredWorkloadsServiceClient.listWorkloads(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListWorkloadsPagedResponse listWorkloads(ListWorkloadsRequest request) {
    return listWorkloadsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Assured Workloads under a CRM Node.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AssuredWorkloadsServiceClient assuredWorkloadsServiceClient =
   *     AssuredWorkloadsServiceClient.create()) {
   *   ListWorkloadsRequest request =
   *       ListWorkloadsRequest.newBuilder()
   *           .setParent(LocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<Workload> future =
   *       assuredWorkloadsServiceClient.listWorkloadsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Workload element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListWorkloadsRequest, ListWorkloadsPagedResponse>
      listWorkloadsPagedCallable() {
    return stub.listWorkloadsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Assured Workloads under a CRM Node.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AssuredWorkloadsServiceClient assuredWorkloadsServiceClient =
   *     AssuredWorkloadsServiceClient.create()) {
   *   ListWorkloadsRequest request =
   *       ListWorkloadsRequest.newBuilder()
   *           .setParent(LocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListWorkloadsResponse response =
   *         assuredWorkloadsServiceClient.listWorkloadsCallable().call(request);
   *     for (Workload element : response.getWorkloadsList()) {
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
  public final UnaryCallable<ListWorkloadsRequest, ListWorkloadsResponse> listWorkloadsCallable() {
    return stub.listWorkloadsCallable();
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

  public static class ListWorkloadsPagedResponse
      extends AbstractPagedListResponse<
          ListWorkloadsRequest,
          ListWorkloadsResponse,
          Workload,
          ListWorkloadsPage,
          ListWorkloadsFixedSizeCollection> {

    public static ApiFuture<ListWorkloadsPagedResponse> createAsync(
        PageContext<ListWorkloadsRequest, ListWorkloadsResponse, Workload> context,
        ApiFuture<ListWorkloadsResponse> futureResponse) {
      ApiFuture<ListWorkloadsPage> futurePage =
          ListWorkloadsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListWorkloadsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListWorkloadsPagedResponse(ListWorkloadsPage page) {
      super(page, ListWorkloadsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListWorkloadsPage
      extends AbstractPage<
          ListWorkloadsRequest, ListWorkloadsResponse, Workload, ListWorkloadsPage> {

    private ListWorkloadsPage(
        PageContext<ListWorkloadsRequest, ListWorkloadsResponse, Workload> context,
        ListWorkloadsResponse response) {
      super(context, response);
    }

    private static ListWorkloadsPage createEmptyPage() {
      return new ListWorkloadsPage(null, null);
    }

    @Override
    protected ListWorkloadsPage createPage(
        PageContext<ListWorkloadsRequest, ListWorkloadsResponse, Workload> context,
        ListWorkloadsResponse response) {
      return new ListWorkloadsPage(context, response);
    }

    @Override
    public ApiFuture<ListWorkloadsPage> createPageAsync(
        PageContext<ListWorkloadsRequest, ListWorkloadsResponse, Workload> context,
        ApiFuture<ListWorkloadsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListWorkloadsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListWorkloadsRequest,
          ListWorkloadsResponse,
          Workload,
          ListWorkloadsPage,
          ListWorkloadsFixedSizeCollection> {

    private ListWorkloadsFixedSizeCollection(List<ListWorkloadsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListWorkloadsFixedSizeCollection createEmptyCollection() {
      return new ListWorkloadsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListWorkloadsFixedSizeCollection createCollection(
        List<ListWorkloadsPage> pages, int collectionSize) {
      return new ListWorkloadsFixedSizeCollection(pages, collectionSize);
    }
  }
}
