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

package com.google.cloud.osconfig.v1alpha;

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
import com.google.cloud.osconfig.v1alpha.stub.OsConfigZonalServiceStub;
import com.google.cloud.osconfig.v1alpha.stub.OsConfigZonalServiceStubSettings;
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
 * Service Description: Zonal OS Config API
 *
 * <p>The OS Config service is the server-side component that allows users to manage package
 * installations and patch jobs for Compute Engine VM instances.
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
 * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
 *     OsConfigZonalServiceClient.create()) {
 *   OSPolicyAssignmentName name =
 *       OSPolicyAssignmentName.of("[PROJECT]", "[LOCATION]", "[OS_POLICY_ASSIGNMENT]");
 *   OSPolicyAssignment response = osConfigZonalServiceClient.getOSPolicyAssignment(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the OsConfigZonalServiceClient object to clean up
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
 * <p>This class can be customized by passing in a custom instance of OsConfigZonalServiceSettings
 * to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * OsConfigZonalServiceSettings osConfigZonalServiceSettings =
 *     OsConfigZonalServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * OsConfigZonalServiceClient osConfigZonalServiceClient =
 *     OsConfigZonalServiceClient.create(osConfigZonalServiceSettings);
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
 * OsConfigZonalServiceSettings osConfigZonalServiceSettings =
 *     OsConfigZonalServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * OsConfigZonalServiceClient osConfigZonalServiceClient =
 *     OsConfigZonalServiceClient.create(osConfigZonalServiceSettings);
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
 * OsConfigZonalServiceSettings osConfigZonalServiceSettings =
 *     OsConfigZonalServiceSettings.newBuilder()
 *         .setTransportChannelProvider(
 *             OsConfigZonalServiceSettings.defaultHttpJsonTransportProviderBuilder().build())
 *         .build();
 * OsConfigZonalServiceClient osConfigZonalServiceClient =
 *     OsConfigZonalServiceClient.create(osConfigZonalServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class OsConfigZonalServiceClient implements BackgroundResource {
  private final OsConfigZonalServiceSettings settings;
  private final OsConfigZonalServiceStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of OsConfigZonalServiceClient with default settings. */
  public static final OsConfigZonalServiceClient create() throws IOException {
    return create(OsConfigZonalServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of OsConfigZonalServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final OsConfigZonalServiceClient create(OsConfigZonalServiceSettings settings)
      throws IOException {
    return new OsConfigZonalServiceClient(settings);
  }

  /**
   * Constructs an instance of OsConfigZonalServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(OsConfigZonalServiceSettings).
   */
  public static final OsConfigZonalServiceClient create(OsConfigZonalServiceStub stub) {
    return new OsConfigZonalServiceClient(stub);
  }

  /**
   * Constructs an instance of OsConfigZonalServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected OsConfigZonalServiceClient(OsConfigZonalServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((OsConfigZonalServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected OsConfigZonalServiceClient(OsConfigZonalServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final OsConfigZonalServiceSettings getSettings() {
    return settings;
  }

  public OsConfigZonalServiceStub getStub() {
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
   * Create an OS policy assignment.
   *
   * <p>This method also creates the first revision of the OS policy assignment.
   *
   * <p>This method returns a long running operation (LRO) that contains the rollout details. The
   * rollout can be cancelled by cancelling the LRO.
   *
   * <p>For more information, see [Method:
   * projects.locations.osPolicyAssignments.operations.cancel](https://cloud.google.com/compute/docs/osconfig/rest/v1alpha/projects.locations.osPolicyAssignments.operations/cancel).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   OSPolicyAssignment osPolicyAssignment = OSPolicyAssignment.newBuilder().build();
   *   String osPolicyAssignmentId = "osPolicyAssignmentId-44079074";
   *   OSPolicyAssignment response =
   *       osConfigZonalServiceClient
   *           .createOSPolicyAssignmentAsync(parent, osPolicyAssignment, osPolicyAssignmentId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name in the form:
   *     projects/{project}/locations/{location}
   * @param osPolicyAssignment Required. The OS policy assignment to be created.
   * @param osPolicyAssignmentId Required. The logical name of the OS policy assignment in the
   *     project with the following restrictions:
   *     <ul>
   *       <li>Must contain only lowercase letters, numbers, and hyphens.
   *       <li>Must start with a letter.
   *       <li>Must be between 1-63 characters.
   *       <li>Must end with a number or a letter.
   *       <li>Must be unique within the project.
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<OSPolicyAssignment, OSPolicyAssignmentOperationMetadata>
      createOSPolicyAssignmentAsync(
          LocationName parent, OSPolicyAssignment osPolicyAssignment, String osPolicyAssignmentId) {
    CreateOSPolicyAssignmentRequest request =
        CreateOSPolicyAssignmentRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setOsPolicyAssignment(osPolicyAssignment)
            .setOsPolicyAssignmentId(osPolicyAssignmentId)
            .build();
    return createOSPolicyAssignmentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create an OS policy assignment.
   *
   * <p>This method also creates the first revision of the OS policy assignment.
   *
   * <p>This method returns a long running operation (LRO) that contains the rollout details. The
   * rollout can be cancelled by cancelling the LRO.
   *
   * <p>For more information, see [Method:
   * projects.locations.osPolicyAssignments.operations.cancel](https://cloud.google.com/compute/docs/osconfig/rest/v1alpha/projects.locations.osPolicyAssignments.operations/cancel).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   OSPolicyAssignment osPolicyAssignment = OSPolicyAssignment.newBuilder().build();
   *   String osPolicyAssignmentId = "osPolicyAssignmentId-44079074";
   *   OSPolicyAssignment response =
   *       osConfigZonalServiceClient
   *           .createOSPolicyAssignmentAsync(parent, osPolicyAssignment, osPolicyAssignmentId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name in the form:
   *     projects/{project}/locations/{location}
   * @param osPolicyAssignment Required. The OS policy assignment to be created.
   * @param osPolicyAssignmentId Required. The logical name of the OS policy assignment in the
   *     project with the following restrictions:
   *     <ul>
   *       <li>Must contain only lowercase letters, numbers, and hyphens.
   *       <li>Must start with a letter.
   *       <li>Must be between 1-63 characters.
   *       <li>Must end with a number or a letter.
   *       <li>Must be unique within the project.
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<OSPolicyAssignment, OSPolicyAssignmentOperationMetadata>
      createOSPolicyAssignmentAsync(
          String parent, OSPolicyAssignment osPolicyAssignment, String osPolicyAssignmentId) {
    CreateOSPolicyAssignmentRequest request =
        CreateOSPolicyAssignmentRequest.newBuilder()
            .setParent(parent)
            .setOsPolicyAssignment(osPolicyAssignment)
            .setOsPolicyAssignmentId(osPolicyAssignmentId)
            .build();
    return createOSPolicyAssignmentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create an OS policy assignment.
   *
   * <p>This method also creates the first revision of the OS policy assignment.
   *
   * <p>This method returns a long running operation (LRO) that contains the rollout details. The
   * rollout can be cancelled by cancelling the LRO.
   *
   * <p>For more information, see [Method:
   * projects.locations.osPolicyAssignments.operations.cancel](https://cloud.google.com/compute/docs/osconfig/rest/v1alpha/projects.locations.osPolicyAssignments.operations/cancel).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   CreateOSPolicyAssignmentRequest request =
   *       CreateOSPolicyAssignmentRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setOsPolicyAssignment(OSPolicyAssignment.newBuilder().build())
   *           .setOsPolicyAssignmentId("osPolicyAssignmentId-44079074")
   *           .build();
   *   OSPolicyAssignment response =
   *       osConfigZonalServiceClient.createOSPolicyAssignmentAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<OSPolicyAssignment, OSPolicyAssignmentOperationMetadata>
      createOSPolicyAssignmentAsync(CreateOSPolicyAssignmentRequest request) {
    return createOSPolicyAssignmentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create an OS policy assignment.
   *
   * <p>This method also creates the first revision of the OS policy assignment.
   *
   * <p>This method returns a long running operation (LRO) that contains the rollout details. The
   * rollout can be cancelled by cancelling the LRO.
   *
   * <p>For more information, see [Method:
   * projects.locations.osPolicyAssignments.operations.cancel](https://cloud.google.com/compute/docs/osconfig/rest/v1alpha/projects.locations.osPolicyAssignments.operations/cancel).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   CreateOSPolicyAssignmentRequest request =
   *       CreateOSPolicyAssignmentRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setOsPolicyAssignment(OSPolicyAssignment.newBuilder().build())
   *           .setOsPolicyAssignmentId("osPolicyAssignmentId-44079074")
   *           .build();
   *   OperationFuture<OSPolicyAssignment, OSPolicyAssignmentOperationMetadata> future =
   *       osConfigZonalServiceClient
   *           .createOSPolicyAssignmentOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   OSPolicyAssignment response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateOSPolicyAssignmentRequest, OSPolicyAssignment, OSPolicyAssignmentOperationMetadata>
      createOSPolicyAssignmentOperationCallable() {
    return stub.createOSPolicyAssignmentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create an OS policy assignment.
   *
   * <p>This method also creates the first revision of the OS policy assignment.
   *
   * <p>This method returns a long running operation (LRO) that contains the rollout details. The
   * rollout can be cancelled by cancelling the LRO.
   *
   * <p>For more information, see [Method:
   * projects.locations.osPolicyAssignments.operations.cancel](https://cloud.google.com/compute/docs/osconfig/rest/v1alpha/projects.locations.osPolicyAssignments.operations/cancel).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   CreateOSPolicyAssignmentRequest request =
   *       CreateOSPolicyAssignmentRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setOsPolicyAssignment(OSPolicyAssignment.newBuilder().build())
   *           .setOsPolicyAssignmentId("osPolicyAssignmentId-44079074")
   *           .build();
   *   ApiFuture<Operation> future =
   *       osConfigZonalServiceClient.createOSPolicyAssignmentCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateOSPolicyAssignmentRequest, Operation>
      createOSPolicyAssignmentCallable() {
    return stub.createOSPolicyAssignmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update an existing OS policy assignment.
   *
   * <p>This method creates a new revision of the OS policy assignment.
   *
   * <p>This method returns a long running operation (LRO) that contains the rollout details. The
   * rollout can be cancelled by cancelling the LRO.
   *
   * <p>For more information, see [Method:
   * projects.locations.osPolicyAssignments.operations.cancel](https://cloud.google.com/compute/docs/osconfig/rest/v1alpha/projects.locations.osPolicyAssignments.operations/cancel).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   OSPolicyAssignment osPolicyAssignment = OSPolicyAssignment.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   OSPolicyAssignment response =
   *       osConfigZonalServiceClient
   *           .updateOSPolicyAssignmentAsync(osPolicyAssignment, updateMask)
   *           .get();
   * }
   * }</pre>
   *
   * @param osPolicyAssignment Required. The updated OS policy assignment.
   * @param updateMask Optional. Field mask that controls which fields of the assignment should be
   *     updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<OSPolicyAssignment, OSPolicyAssignmentOperationMetadata>
      updateOSPolicyAssignmentAsync(OSPolicyAssignment osPolicyAssignment, FieldMask updateMask) {
    UpdateOSPolicyAssignmentRequest request =
        UpdateOSPolicyAssignmentRequest.newBuilder()
            .setOsPolicyAssignment(osPolicyAssignment)
            .setUpdateMask(updateMask)
            .build();
    return updateOSPolicyAssignmentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update an existing OS policy assignment.
   *
   * <p>This method creates a new revision of the OS policy assignment.
   *
   * <p>This method returns a long running operation (LRO) that contains the rollout details. The
   * rollout can be cancelled by cancelling the LRO.
   *
   * <p>For more information, see [Method:
   * projects.locations.osPolicyAssignments.operations.cancel](https://cloud.google.com/compute/docs/osconfig/rest/v1alpha/projects.locations.osPolicyAssignments.operations/cancel).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   UpdateOSPolicyAssignmentRequest request =
   *       UpdateOSPolicyAssignmentRequest.newBuilder()
   *           .setOsPolicyAssignment(OSPolicyAssignment.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OSPolicyAssignment response =
   *       osConfigZonalServiceClient.updateOSPolicyAssignmentAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<OSPolicyAssignment, OSPolicyAssignmentOperationMetadata>
      updateOSPolicyAssignmentAsync(UpdateOSPolicyAssignmentRequest request) {
    return updateOSPolicyAssignmentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update an existing OS policy assignment.
   *
   * <p>This method creates a new revision of the OS policy assignment.
   *
   * <p>This method returns a long running operation (LRO) that contains the rollout details. The
   * rollout can be cancelled by cancelling the LRO.
   *
   * <p>For more information, see [Method:
   * projects.locations.osPolicyAssignments.operations.cancel](https://cloud.google.com/compute/docs/osconfig/rest/v1alpha/projects.locations.osPolicyAssignments.operations/cancel).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   UpdateOSPolicyAssignmentRequest request =
   *       UpdateOSPolicyAssignmentRequest.newBuilder()
   *           .setOsPolicyAssignment(OSPolicyAssignment.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<OSPolicyAssignment, OSPolicyAssignmentOperationMetadata> future =
   *       osConfigZonalServiceClient
   *           .updateOSPolicyAssignmentOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   OSPolicyAssignment response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UpdateOSPolicyAssignmentRequest, OSPolicyAssignment, OSPolicyAssignmentOperationMetadata>
      updateOSPolicyAssignmentOperationCallable() {
    return stub.updateOSPolicyAssignmentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update an existing OS policy assignment.
   *
   * <p>This method creates a new revision of the OS policy assignment.
   *
   * <p>This method returns a long running operation (LRO) that contains the rollout details. The
   * rollout can be cancelled by cancelling the LRO.
   *
   * <p>For more information, see [Method:
   * projects.locations.osPolicyAssignments.operations.cancel](https://cloud.google.com/compute/docs/osconfig/rest/v1alpha/projects.locations.osPolicyAssignments.operations/cancel).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   UpdateOSPolicyAssignmentRequest request =
   *       UpdateOSPolicyAssignmentRequest.newBuilder()
   *           .setOsPolicyAssignment(OSPolicyAssignment.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       osConfigZonalServiceClient.updateOSPolicyAssignmentCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateOSPolicyAssignmentRequest, Operation>
      updateOSPolicyAssignmentCallable() {
    return stub.updateOSPolicyAssignmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve an existing OS policy assignment.
   *
   * <p>This method always returns the latest revision. In order to retrieve a previous revision of
   * the assignment, also provide the revision ID in the `name` parameter.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   OSPolicyAssignmentName name =
   *       OSPolicyAssignmentName.of("[PROJECT]", "[LOCATION]", "[OS_POLICY_ASSIGNMENT]");
   *   OSPolicyAssignment response = osConfigZonalServiceClient.getOSPolicyAssignment(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of OS policy assignment.
   *     <p>Format:
   *     `projects/{project}/locations/{location}/osPolicyAssignments/{os_policy_assignment}{@literal @}{revisionId}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OSPolicyAssignment getOSPolicyAssignment(OSPolicyAssignmentName name) {
    GetOSPolicyAssignmentRequest request =
        GetOSPolicyAssignmentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getOSPolicyAssignment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve an existing OS policy assignment.
   *
   * <p>This method always returns the latest revision. In order to retrieve a previous revision of
   * the assignment, also provide the revision ID in the `name` parameter.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   String name =
   *       OSPolicyAssignmentName.of("[PROJECT]", "[LOCATION]", "[OS_POLICY_ASSIGNMENT]").toString();
   *   OSPolicyAssignment response = osConfigZonalServiceClient.getOSPolicyAssignment(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of OS policy assignment.
   *     <p>Format:
   *     `projects/{project}/locations/{location}/osPolicyAssignments/{os_policy_assignment}{@literal @}{revisionId}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OSPolicyAssignment getOSPolicyAssignment(String name) {
    GetOSPolicyAssignmentRequest request =
        GetOSPolicyAssignmentRequest.newBuilder().setName(name).build();
    return getOSPolicyAssignment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve an existing OS policy assignment.
   *
   * <p>This method always returns the latest revision. In order to retrieve a previous revision of
   * the assignment, also provide the revision ID in the `name` parameter.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   GetOSPolicyAssignmentRequest request =
   *       GetOSPolicyAssignmentRequest.newBuilder()
   *           .setName(
   *               OSPolicyAssignmentName.of("[PROJECT]", "[LOCATION]", "[OS_POLICY_ASSIGNMENT]")
   *                   .toString())
   *           .build();
   *   OSPolicyAssignment response = osConfigZonalServiceClient.getOSPolicyAssignment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OSPolicyAssignment getOSPolicyAssignment(GetOSPolicyAssignmentRequest request) {
    return getOSPolicyAssignmentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve an existing OS policy assignment.
   *
   * <p>This method always returns the latest revision. In order to retrieve a previous revision of
   * the assignment, also provide the revision ID in the `name` parameter.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   GetOSPolicyAssignmentRequest request =
   *       GetOSPolicyAssignmentRequest.newBuilder()
   *           .setName(
   *               OSPolicyAssignmentName.of("[PROJECT]", "[LOCATION]", "[OS_POLICY_ASSIGNMENT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<OSPolicyAssignment> future =
   *       osConfigZonalServiceClient.getOSPolicyAssignmentCallable().futureCall(request);
   *   // Do something.
   *   OSPolicyAssignment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetOSPolicyAssignmentRequest, OSPolicyAssignment>
      getOSPolicyAssignmentCallable() {
    return stub.getOSPolicyAssignmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List the OS policy assignments under the parent resource.
   *
   * <p>For each OS policy assignment, the latest revision is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (OSPolicyAssignment element :
   *       osConfigZonalServiceClient.listOSPolicyAssignments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOSPolicyAssignmentsPagedResponse listOSPolicyAssignments(LocationName parent) {
    ListOSPolicyAssignmentsRequest request =
        ListOSPolicyAssignmentsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listOSPolicyAssignments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List the OS policy assignments under the parent resource.
   *
   * <p>For each OS policy assignment, the latest revision is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (OSPolicyAssignment element :
   *       osConfigZonalServiceClient.listOSPolicyAssignments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOSPolicyAssignmentsPagedResponse listOSPolicyAssignments(String parent) {
    ListOSPolicyAssignmentsRequest request =
        ListOSPolicyAssignmentsRequest.newBuilder().setParent(parent).build();
    return listOSPolicyAssignments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List the OS policy assignments under the parent resource.
   *
   * <p>For each OS policy assignment, the latest revision is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   ListOSPolicyAssignmentsRequest request =
   *       ListOSPolicyAssignmentsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (OSPolicyAssignment element :
   *       osConfigZonalServiceClient.listOSPolicyAssignments(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOSPolicyAssignmentsPagedResponse listOSPolicyAssignments(
      ListOSPolicyAssignmentsRequest request) {
    return listOSPolicyAssignmentsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List the OS policy assignments under the parent resource.
   *
   * <p>For each OS policy assignment, the latest revision is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   ListOSPolicyAssignmentsRequest request =
   *       ListOSPolicyAssignmentsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<OSPolicyAssignment> future =
   *       osConfigZonalServiceClient.listOSPolicyAssignmentsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (OSPolicyAssignment element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListOSPolicyAssignmentsRequest, ListOSPolicyAssignmentsPagedResponse>
      listOSPolicyAssignmentsPagedCallable() {
    return stub.listOSPolicyAssignmentsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List the OS policy assignments under the parent resource.
   *
   * <p>For each OS policy assignment, the latest revision is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   ListOSPolicyAssignmentsRequest request =
   *       ListOSPolicyAssignmentsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListOSPolicyAssignmentsResponse response =
   *         osConfigZonalServiceClient.listOSPolicyAssignmentsCallable().call(request);
   *     for (OSPolicyAssignment element : response.getOsPolicyAssignmentsList()) {
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
  public final UnaryCallable<ListOSPolicyAssignmentsRequest, ListOSPolicyAssignmentsResponse>
      listOSPolicyAssignmentsCallable() {
    return stub.listOSPolicyAssignmentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List the OS policy assignment revisions for a given OS policy assignment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   OSPolicyAssignmentName name =
   *       OSPolicyAssignmentName.of("[PROJECT]", "[LOCATION]", "[OS_POLICY_ASSIGNMENT]");
   *   for (OSPolicyAssignment element :
   *       osConfigZonalServiceClient.listOSPolicyAssignmentRevisions(name).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param name Required. The name of the OS policy assignment to list revisions for.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOSPolicyAssignmentRevisionsPagedResponse listOSPolicyAssignmentRevisions(
      OSPolicyAssignmentName name) {
    ListOSPolicyAssignmentRevisionsRequest request =
        ListOSPolicyAssignmentRevisionsRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return listOSPolicyAssignmentRevisions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List the OS policy assignment revisions for a given OS policy assignment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   String name =
   *       OSPolicyAssignmentName.of("[PROJECT]", "[LOCATION]", "[OS_POLICY_ASSIGNMENT]").toString();
   *   for (OSPolicyAssignment element :
   *       osConfigZonalServiceClient.listOSPolicyAssignmentRevisions(name).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param name Required. The name of the OS policy assignment to list revisions for.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOSPolicyAssignmentRevisionsPagedResponse listOSPolicyAssignmentRevisions(
      String name) {
    ListOSPolicyAssignmentRevisionsRequest request =
        ListOSPolicyAssignmentRevisionsRequest.newBuilder().setName(name).build();
    return listOSPolicyAssignmentRevisions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List the OS policy assignment revisions for a given OS policy assignment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   ListOSPolicyAssignmentRevisionsRequest request =
   *       ListOSPolicyAssignmentRevisionsRequest.newBuilder()
   *           .setName(
   *               OSPolicyAssignmentName.of("[PROJECT]", "[LOCATION]", "[OS_POLICY_ASSIGNMENT]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (OSPolicyAssignment element :
   *       osConfigZonalServiceClient.listOSPolicyAssignmentRevisions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOSPolicyAssignmentRevisionsPagedResponse listOSPolicyAssignmentRevisions(
      ListOSPolicyAssignmentRevisionsRequest request) {
    return listOSPolicyAssignmentRevisionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List the OS policy assignment revisions for a given OS policy assignment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   ListOSPolicyAssignmentRevisionsRequest request =
   *       ListOSPolicyAssignmentRevisionsRequest.newBuilder()
   *           .setName(
   *               OSPolicyAssignmentName.of("[PROJECT]", "[LOCATION]", "[OS_POLICY_ASSIGNMENT]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<OSPolicyAssignment> future =
   *       osConfigZonalServiceClient
   *           .listOSPolicyAssignmentRevisionsPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (OSPolicyAssignment element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListOSPolicyAssignmentRevisionsRequest, ListOSPolicyAssignmentRevisionsPagedResponse>
      listOSPolicyAssignmentRevisionsPagedCallable() {
    return stub.listOSPolicyAssignmentRevisionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List the OS policy assignment revisions for a given OS policy assignment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   ListOSPolicyAssignmentRevisionsRequest request =
   *       ListOSPolicyAssignmentRevisionsRequest.newBuilder()
   *           .setName(
   *               OSPolicyAssignmentName.of("[PROJECT]", "[LOCATION]", "[OS_POLICY_ASSIGNMENT]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListOSPolicyAssignmentRevisionsResponse response =
   *         osConfigZonalServiceClient.listOSPolicyAssignmentRevisionsCallable().call(request);
   *     for (OSPolicyAssignment element : response.getOsPolicyAssignmentsList()) {
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
          ListOSPolicyAssignmentRevisionsRequest, ListOSPolicyAssignmentRevisionsResponse>
      listOSPolicyAssignmentRevisionsCallable() {
    return stub.listOSPolicyAssignmentRevisionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete the OS policy assignment.
   *
   * <p>This method creates a new revision of the OS policy assignment.
   *
   * <p>This method returns a long running operation (LRO) that contains the rollout details. The
   * rollout can be cancelled by cancelling the LRO.
   *
   * <p>If the LRO completes and is not cancelled, all revisions associated with the OS policy
   * assignment are deleted.
   *
   * <p>For more information, see [Method:
   * projects.locations.osPolicyAssignments.operations.cancel](https://cloud.google.com/compute/docs/osconfig/rest/v1alpha/projects.locations.osPolicyAssignments.operations/cancel).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   OSPolicyAssignmentName name =
   *       OSPolicyAssignmentName.of("[PROJECT]", "[LOCATION]", "[OS_POLICY_ASSIGNMENT]");
   *   osConfigZonalServiceClient.deleteOSPolicyAssignmentAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the OS policy assignment to be deleted
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OSPolicyAssignmentOperationMetadata>
      deleteOSPolicyAssignmentAsync(OSPolicyAssignmentName name) {
    DeleteOSPolicyAssignmentRequest request =
        DeleteOSPolicyAssignmentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteOSPolicyAssignmentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete the OS policy assignment.
   *
   * <p>This method creates a new revision of the OS policy assignment.
   *
   * <p>This method returns a long running operation (LRO) that contains the rollout details. The
   * rollout can be cancelled by cancelling the LRO.
   *
   * <p>If the LRO completes and is not cancelled, all revisions associated with the OS policy
   * assignment are deleted.
   *
   * <p>For more information, see [Method:
   * projects.locations.osPolicyAssignments.operations.cancel](https://cloud.google.com/compute/docs/osconfig/rest/v1alpha/projects.locations.osPolicyAssignments.operations/cancel).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   String name =
   *       OSPolicyAssignmentName.of("[PROJECT]", "[LOCATION]", "[OS_POLICY_ASSIGNMENT]").toString();
   *   osConfigZonalServiceClient.deleteOSPolicyAssignmentAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the OS policy assignment to be deleted
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OSPolicyAssignmentOperationMetadata>
      deleteOSPolicyAssignmentAsync(String name) {
    DeleteOSPolicyAssignmentRequest request =
        DeleteOSPolicyAssignmentRequest.newBuilder().setName(name).build();
    return deleteOSPolicyAssignmentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete the OS policy assignment.
   *
   * <p>This method creates a new revision of the OS policy assignment.
   *
   * <p>This method returns a long running operation (LRO) that contains the rollout details. The
   * rollout can be cancelled by cancelling the LRO.
   *
   * <p>If the LRO completes and is not cancelled, all revisions associated with the OS policy
   * assignment are deleted.
   *
   * <p>For more information, see [Method:
   * projects.locations.osPolicyAssignments.operations.cancel](https://cloud.google.com/compute/docs/osconfig/rest/v1alpha/projects.locations.osPolicyAssignments.operations/cancel).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   DeleteOSPolicyAssignmentRequest request =
   *       DeleteOSPolicyAssignmentRequest.newBuilder()
   *           .setName(
   *               OSPolicyAssignmentName.of("[PROJECT]", "[LOCATION]", "[OS_POLICY_ASSIGNMENT]")
   *                   .toString())
   *           .build();
   *   osConfigZonalServiceClient.deleteOSPolicyAssignmentAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OSPolicyAssignmentOperationMetadata>
      deleteOSPolicyAssignmentAsync(DeleteOSPolicyAssignmentRequest request) {
    return deleteOSPolicyAssignmentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete the OS policy assignment.
   *
   * <p>This method creates a new revision of the OS policy assignment.
   *
   * <p>This method returns a long running operation (LRO) that contains the rollout details. The
   * rollout can be cancelled by cancelling the LRO.
   *
   * <p>If the LRO completes and is not cancelled, all revisions associated with the OS policy
   * assignment are deleted.
   *
   * <p>For more information, see [Method:
   * projects.locations.osPolicyAssignments.operations.cancel](https://cloud.google.com/compute/docs/osconfig/rest/v1alpha/projects.locations.osPolicyAssignments.operations/cancel).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   DeleteOSPolicyAssignmentRequest request =
   *       DeleteOSPolicyAssignmentRequest.newBuilder()
   *           .setName(
   *               OSPolicyAssignmentName.of("[PROJECT]", "[LOCATION]", "[OS_POLICY_ASSIGNMENT]")
   *                   .toString())
   *           .build();
   *   OperationFuture<Empty, OSPolicyAssignmentOperationMetadata> future =
   *       osConfigZonalServiceClient
   *           .deleteOSPolicyAssignmentOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          DeleteOSPolicyAssignmentRequest, Empty, OSPolicyAssignmentOperationMetadata>
      deleteOSPolicyAssignmentOperationCallable() {
    return stub.deleteOSPolicyAssignmentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete the OS policy assignment.
   *
   * <p>This method creates a new revision of the OS policy assignment.
   *
   * <p>This method returns a long running operation (LRO) that contains the rollout details. The
   * rollout can be cancelled by cancelling the LRO.
   *
   * <p>If the LRO completes and is not cancelled, all revisions associated with the OS policy
   * assignment are deleted.
   *
   * <p>For more information, see [Method:
   * projects.locations.osPolicyAssignments.operations.cancel](https://cloud.google.com/compute/docs/osconfig/rest/v1alpha/projects.locations.osPolicyAssignments.operations/cancel).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   DeleteOSPolicyAssignmentRequest request =
   *       DeleteOSPolicyAssignmentRequest.newBuilder()
   *           .setName(
   *               OSPolicyAssignmentName.of("[PROJECT]", "[LOCATION]", "[OS_POLICY_ASSIGNMENT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       osConfigZonalServiceClient.deleteOSPolicyAssignmentCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteOSPolicyAssignmentRequest, Operation>
      deleteOSPolicyAssignmentCallable() {
    return stub.deleteOSPolicyAssignmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get OS policies compliance data for the specified Compute Engine VM instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   InstanceOSPoliciesComplianceName name =
   *       InstanceOSPoliciesComplianceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   InstanceOSPoliciesCompliance response =
   *       osConfigZonalServiceClient.getInstanceOSPoliciesCompliance(name);
   * }
   * }</pre>
   *
   * @param name Required. API resource name for instance OS policies compliance resource.
   *     <p>Format:
   *     `projects/{project}/locations/{location}/instanceOSPoliciesCompliances/{instance}`
   *     <p>For `{project}`, either Compute Engine project-number or project-id can be provided. For
   *     `{instance}`, either Compute Engine VM instance-id or instance-name can be provided.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final InstanceOSPoliciesCompliance getInstanceOSPoliciesCompliance(
      InstanceOSPoliciesComplianceName name) {
    GetInstanceOSPoliciesComplianceRequest request =
        GetInstanceOSPoliciesComplianceRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getInstanceOSPoliciesCompliance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get OS policies compliance data for the specified Compute Engine VM instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   String name =
   *       InstanceOSPoliciesComplianceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   InstanceOSPoliciesCompliance response =
   *       osConfigZonalServiceClient.getInstanceOSPoliciesCompliance(name);
   * }
   * }</pre>
   *
   * @param name Required. API resource name for instance OS policies compliance resource.
   *     <p>Format:
   *     `projects/{project}/locations/{location}/instanceOSPoliciesCompliances/{instance}`
   *     <p>For `{project}`, either Compute Engine project-number or project-id can be provided. For
   *     `{instance}`, either Compute Engine VM instance-id or instance-name can be provided.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final InstanceOSPoliciesCompliance getInstanceOSPoliciesCompliance(String name) {
    GetInstanceOSPoliciesComplianceRequest request =
        GetInstanceOSPoliciesComplianceRequest.newBuilder().setName(name).build();
    return getInstanceOSPoliciesCompliance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get OS policies compliance data for the specified Compute Engine VM instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   GetInstanceOSPoliciesComplianceRequest request =
   *       GetInstanceOSPoliciesComplianceRequest.newBuilder()
   *           .setName(
   *               InstanceOSPoliciesComplianceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]")
   *                   .toString())
   *           .build();
   *   InstanceOSPoliciesCompliance response =
   *       osConfigZonalServiceClient.getInstanceOSPoliciesCompliance(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final InstanceOSPoliciesCompliance getInstanceOSPoliciesCompliance(
      GetInstanceOSPoliciesComplianceRequest request) {
    return getInstanceOSPoliciesComplianceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get OS policies compliance data for the specified Compute Engine VM instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   GetInstanceOSPoliciesComplianceRequest request =
   *       GetInstanceOSPoliciesComplianceRequest.newBuilder()
   *           .setName(
   *               InstanceOSPoliciesComplianceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<InstanceOSPoliciesCompliance> future =
   *       osConfigZonalServiceClient.getInstanceOSPoliciesComplianceCallable().futureCall(request);
   *   // Do something.
   *   InstanceOSPoliciesCompliance response = future.get();
   * }
   * }</pre>
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final UnaryCallable<GetInstanceOSPoliciesComplianceRequest, InstanceOSPoliciesCompliance>
      getInstanceOSPoliciesComplianceCallable() {
    return stub.getInstanceOSPoliciesComplianceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List OS policies compliance data for all Compute Engine VM instances in the specified zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (InstanceOSPoliciesCompliance element :
   *       osConfigZonalServiceClient.listInstanceOSPoliciesCompliances(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name.
   *     <p>Format: `projects/{project}/locations/{location}`
   *     <p>For `{project}`, either Compute Engine project-number or project-id can be provided.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final ListInstanceOSPoliciesCompliancesPagedResponse listInstanceOSPoliciesCompliances(
      LocationName parent) {
    ListInstanceOSPoliciesCompliancesRequest request =
        ListInstanceOSPoliciesCompliancesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listInstanceOSPoliciesCompliances(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List OS policies compliance data for all Compute Engine VM instances in the specified zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (InstanceOSPoliciesCompliance element :
   *       osConfigZonalServiceClient.listInstanceOSPoliciesCompliances(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name.
   *     <p>Format: `projects/{project}/locations/{location}`
   *     <p>For `{project}`, either Compute Engine project-number or project-id can be provided.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final ListInstanceOSPoliciesCompliancesPagedResponse listInstanceOSPoliciesCompliances(
      String parent) {
    ListInstanceOSPoliciesCompliancesRequest request =
        ListInstanceOSPoliciesCompliancesRequest.newBuilder().setParent(parent).build();
    return listInstanceOSPoliciesCompliances(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List OS policies compliance data for all Compute Engine VM instances in the specified zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   ListInstanceOSPoliciesCompliancesRequest request =
   *       ListInstanceOSPoliciesCompliancesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (InstanceOSPoliciesCompliance element :
   *       osConfigZonalServiceClient.listInstanceOSPoliciesCompliances(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final ListInstanceOSPoliciesCompliancesPagedResponse listInstanceOSPoliciesCompliances(
      ListInstanceOSPoliciesCompliancesRequest request) {
    return listInstanceOSPoliciesCompliancesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List OS policies compliance data for all Compute Engine VM instances in the specified zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   ListInstanceOSPoliciesCompliancesRequest request =
   *       ListInstanceOSPoliciesCompliancesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<InstanceOSPoliciesCompliance> future =
   *       osConfigZonalServiceClient
   *           .listInstanceOSPoliciesCompliancesPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (InstanceOSPoliciesCompliance element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final UnaryCallable<
          ListInstanceOSPoliciesCompliancesRequest, ListInstanceOSPoliciesCompliancesPagedResponse>
      listInstanceOSPoliciesCompliancesPagedCallable() {
    return stub.listInstanceOSPoliciesCompliancesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List OS policies compliance data for all Compute Engine VM instances in the specified zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   ListInstanceOSPoliciesCompliancesRequest request =
   *       ListInstanceOSPoliciesCompliancesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListInstanceOSPoliciesCompliancesResponse response =
   *         osConfigZonalServiceClient.listInstanceOSPoliciesCompliancesCallable().call(request);
   *     for (InstanceOSPoliciesCompliance element :
   *         response.getInstanceOsPoliciesCompliancesList()) {
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
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final UnaryCallable<
          ListInstanceOSPoliciesCompliancesRequest, ListInstanceOSPoliciesCompliancesResponse>
      listInstanceOSPoliciesCompliancesCallable() {
    return stub.listInstanceOSPoliciesCompliancesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the OS policy asssignment report for the specified Compute Engine VM instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   OSPolicyAssignmentReportName name =
   *       OSPolicyAssignmentReportName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[ASSIGNMENT]");
   *   OSPolicyAssignmentReport response =
   *       osConfigZonalServiceClient.getOSPolicyAssignmentReport(name);
   * }
   * }</pre>
   *
   * @param name Required. API resource name for OS policy assignment report.
   *     <p>Format:
   *     `/projects/{project}/locations/{location}/instances/{instance}/osPolicyAssignments/{assignment}/report`
   *     <p>For `{project}`, either `project-number` or `project-id` can be provided. For
   *     `{instance_id}`, either Compute Engine `instance-id` or `instance-name` can be provided.
   *     For `{assignment_id}`, the OSPolicyAssignment id must be provided.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OSPolicyAssignmentReport getOSPolicyAssignmentReport(
      OSPolicyAssignmentReportName name) {
    GetOSPolicyAssignmentReportRequest request =
        GetOSPolicyAssignmentReportRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getOSPolicyAssignmentReport(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the OS policy asssignment report for the specified Compute Engine VM instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   String name =
   *       OSPolicyAssignmentReportName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[ASSIGNMENT]")
   *           .toString();
   *   OSPolicyAssignmentReport response =
   *       osConfigZonalServiceClient.getOSPolicyAssignmentReport(name);
   * }
   * }</pre>
   *
   * @param name Required. API resource name for OS policy assignment report.
   *     <p>Format:
   *     `/projects/{project}/locations/{location}/instances/{instance}/osPolicyAssignments/{assignment}/report`
   *     <p>For `{project}`, either `project-number` or `project-id` can be provided. For
   *     `{instance_id}`, either Compute Engine `instance-id` or `instance-name` can be provided.
   *     For `{assignment_id}`, the OSPolicyAssignment id must be provided.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OSPolicyAssignmentReport getOSPolicyAssignmentReport(String name) {
    GetOSPolicyAssignmentReportRequest request =
        GetOSPolicyAssignmentReportRequest.newBuilder().setName(name).build();
    return getOSPolicyAssignmentReport(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the OS policy asssignment report for the specified Compute Engine VM instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   GetOSPolicyAssignmentReportRequest request =
   *       GetOSPolicyAssignmentReportRequest.newBuilder()
   *           .setName(
   *               OSPolicyAssignmentReportName.of(
   *                       "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[ASSIGNMENT]")
   *                   .toString())
   *           .build();
   *   OSPolicyAssignmentReport response =
   *       osConfigZonalServiceClient.getOSPolicyAssignmentReport(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OSPolicyAssignmentReport getOSPolicyAssignmentReport(
      GetOSPolicyAssignmentReportRequest request) {
    return getOSPolicyAssignmentReportCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the OS policy asssignment report for the specified Compute Engine VM instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   GetOSPolicyAssignmentReportRequest request =
   *       GetOSPolicyAssignmentReportRequest.newBuilder()
   *           .setName(
   *               OSPolicyAssignmentReportName.of(
   *                       "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[ASSIGNMENT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<OSPolicyAssignmentReport> future =
   *       osConfigZonalServiceClient.getOSPolicyAssignmentReportCallable().futureCall(request);
   *   // Do something.
   *   OSPolicyAssignmentReport response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetOSPolicyAssignmentReportRequest, OSPolicyAssignmentReport>
      getOSPolicyAssignmentReportCallable() {
    return stub.getOSPolicyAssignmentReportCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List OS policy asssignment reports for all Compute Engine VM instances in the specified zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   InstanceOSPolicyAssignmentName parent =
   *       InstanceOSPolicyAssignmentName.of(
   *           "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[ASSIGNMENT]");
   *   for (OSPolicyAssignmentReport element :
   *       osConfigZonalServiceClient.listOSPolicyAssignmentReports(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name.
   *     <p>Format:
   *     `projects/{project}/locations/{location}/instances/{instance}/osPolicyAssignments/{assignment}/reports`
   *     <p>For `{project}`, either `project-number` or `project-id` can be provided. For
   *     `{instance}`, either `instance-name`, `instance-id`, or `-` can be provided. If '-' is
   *     provided, the response will include OSPolicyAssignmentReports for all instances in the
   *     project/location. For `{assignment}`, either `assignment-id` or `-` can be provided. If '-'
   *     is provided, the response will include OSPolicyAssignmentReports for all
   *     OSPolicyAssignments in the project/location. Either {instance} or {assignment} must be `-`.
   *     <p>For example:
   *     `projects/{project}/locations/{location}/instances/{instance}/osPolicyAssignments/-/reports`
   *     returns all reports for the instance
   *     `projects/{project}/locations/{location}/instances/-/osPolicyAssignments/{assignment-id}/reports`
   *     returns all the reports for the given assignment across all instances.
   *     `projects/{project}/locations/{location}/instances/-/osPolicyAssignments/-/reports` returns
   *     all the reports for all assignments across all instances.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOSPolicyAssignmentReportsPagedResponse listOSPolicyAssignmentReports(
      InstanceOSPolicyAssignmentName parent) {
    ListOSPolicyAssignmentReportsRequest request =
        ListOSPolicyAssignmentReportsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listOSPolicyAssignmentReports(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List OS policy asssignment reports for all Compute Engine VM instances in the specified zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   String parent =
   *       InstanceOSPolicyAssignmentName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[ASSIGNMENT]")
   *           .toString();
   *   for (OSPolicyAssignmentReport element :
   *       osConfigZonalServiceClient.listOSPolicyAssignmentReports(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name.
   *     <p>Format:
   *     `projects/{project}/locations/{location}/instances/{instance}/osPolicyAssignments/{assignment}/reports`
   *     <p>For `{project}`, either `project-number` or `project-id` can be provided. For
   *     `{instance}`, either `instance-name`, `instance-id`, or `-` can be provided. If '-' is
   *     provided, the response will include OSPolicyAssignmentReports for all instances in the
   *     project/location. For `{assignment}`, either `assignment-id` or `-` can be provided. If '-'
   *     is provided, the response will include OSPolicyAssignmentReports for all
   *     OSPolicyAssignments in the project/location. Either {instance} or {assignment} must be `-`.
   *     <p>For example:
   *     `projects/{project}/locations/{location}/instances/{instance}/osPolicyAssignments/-/reports`
   *     returns all reports for the instance
   *     `projects/{project}/locations/{location}/instances/-/osPolicyAssignments/{assignment-id}/reports`
   *     returns all the reports for the given assignment across all instances.
   *     `projects/{project}/locations/{location}/instances/-/osPolicyAssignments/-/reports` returns
   *     all the reports for all assignments across all instances.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOSPolicyAssignmentReportsPagedResponse listOSPolicyAssignmentReports(
      String parent) {
    ListOSPolicyAssignmentReportsRequest request =
        ListOSPolicyAssignmentReportsRequest.newBuilder().setParent(parent).build();
    return listOSPolicyAssignmentReports(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List OS policy asssignment reports for all Compute Engine VM instances in the specified zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   ListOSPolicyAssignmentReportsRequest request =
   *       ListOSPolicyAssignmentReportsRequest.newBuilder()
   *           .setParent(
   *               InstanceOSPolicyAssignmentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[ASSIGNMENT]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setFilter("filter-1274492040")
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (OSPolicyAssignmentReport element :
   *       osConfigZonalServiceClient.listOSPolicyAssignmentReports(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOSPolicyAssignmentReportsPagedResponse listOSPolicyAssignmentReports(
      ListOSPolicyAssignmentReportsRequest request) {
    return listOSPolicyAssignmentReportsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List OS policy asssignment reports for all Compute Engine VM instances in the specified zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   ListOSPolicyAssignmentReportsRequest request =
   *       ListOSPolicyAssignmentReportsRequest.newBuilder()
   *           .setParent(
   *               InstanceOSPolicyAssignmentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[ASSIGNMENT]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setFilter("filter-1274492040")
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<OSPolicyAssignmentReport> future =
   *       osConfigZonalServiceClient
   *           .listOSPolicyAssignmentReportsPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (OSPolicyAssignmentReport element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListOSPolicyAssignmentReportsRequest, ListOSPolicyAssignmentReportsPagedResponse>
      listOSPolicyAssignmentReportsPagedCallable() {
    return stub.listOSPolicyAssignmentReportsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List OS policy asssignment reports for all Compute Engine VM instances in the specified zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   ListOSPolicyAssignmentReportsRequest request =
   *       ListOSPolicyAssignmentReportsRequest.newBuilder()
   *           .setParent(
   *               InstanceOSPolicyAssignmentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[ASSIGNMENT]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setFilter("filter-1274492040")
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListOSPolicyAssignmentReportsResponse response =
   *         osConfigZonalServiceClient.listOSPolicyAssignmentReportsCallable().call(request);
   *     for (OSPolicyAssignmentReport element : response.getOsPolicyAssignmentReportsList()) {
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
          ListOSPolicyAssignmentReportsRequest, ListOSPolicyAssignmentReportsResponse>
      listOSPolicyAssignmentReportsCallable() {
    return stub.listOSPolicyAssignmentReportsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get inventory data for the specified VM instance. If the VM has no associated inventory, the
   * message `NOT_FOUND` is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   InventoryName name = InventoryName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   Inventory response = osConfigZonalServiceClient.getInventory(name);
   * }
   * }</pre>
   *
   * @param name Required. API resource name for inventory resource.
   *     <p>Format: `projects/{project}/locations/{location}/instances/{instance}/inventory`
   *     <p>For `{project}`, either `project-number` or `project-id` can be provided. For
   *     `{instance}`, either Compute Engine `instance-id` or `instance-name` can be provided.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Inventory getInventory(InventoryName name) {
    GetInventoryRequest request =
        GetInventoryRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getInventory(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get inventory data for the specified VM instance. If the VM has no associated inventory, the
   * message `NOT_FOUND` is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   String name = InventoryName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   Inventory response = osConfigZonalServiceClient.getInventory(name);
   * }
   * }</pre>
   *
   * @param name Required. API resource name for inventory resource.
   *     <p>Format: `projects/{project}/locations/{location}/instances/{instance}/inventory`
   *     <p>For `{project}`, either `project-number` or `project-id` can be provided. For
   *     `{instance}`, either Compute Engine `instance-id` or `instance-name` can be provided.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Inventory getInventory(String name) {
    GetInventoryRequest request = GetInventoryRequest.newBuilder().setName(name).build();
    return getInventory(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get inventory data for the specified VM instance. If the VM has no associated inventory, the
   * message `NOT_FOUND` is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   GetInventoryRequest request =
   *       GetInventoryRequest.newBuilder()
   *           .setName(InventoryName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setView(InventoryView.forNumber(0))
   *           .build();
   *   Inventory response = osConfigZonalServiceClient.getInventory(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Inventory getInventory(GetInventoryRequest request) {
    return getInventoryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get inventory data for the specified VM instance. If the VM has no associated inventory, the
   * message `NOT_FOUND` is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   GetInventoryRequest request =
   *       GetInventoryRequest.newBuilder()
   *           .setName(InventoryName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setView(InventoryView.forNumber(0))
   *           .build();
   *   ApiFuture<Inventory> future =
   *       osConfigZonalServiceClient.getInventoryCallable().futureCall(request);
   *   // Do something.
   *   Inventory response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetInventoryRequest, Inventory> getInventoryCallable() {
    return stub.getInventoryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List inventory data for all VM instances in the specified zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   for (Inventory element : osConfigZonalServiceClient.listInventories(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name.
   *     <p>Format: `projects/{project}/locations/{location}/instances/-`
   *     <p>For `{project}`, either `project-number` or `project-id` can be provided.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInventoriesPagedResponse listInventories(InstanceName parent) {
    ListInventoriesRequest request =
        ListInventoriesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listInventories(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List inventory data for all VM instances in the specified zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   String parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   for (Inventory element : osConfigZonalServiceClient.listInventories(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name.
   *     <p>Format: `projects/{project}/locations/{location}/instances/-`
   *     <p>For `{project}`, either `project-number` or `project-id` can be provided.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInventoriesPagedResponse listInventories(String parent) {
    ListInventoriesRequest request = ListInventoriesRequest.newBuilder().setParent(parent).build();
    return listInventories(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List inventory data for all VM instances in the specified zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   ListInventoriesRequest request =
   *       ListInventoriesRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setView(InventoryView.forNumber(0))
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (Inventory element : osConfigZonalServiceClient.listInventories(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInventoriesPagedResponse listInventories(ListInventoriesRequest request) {
    return listInventoriesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List inventory data for all VM instances in the specified zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   ListInventoriesRequest request =
   *       ListInventoriesRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setView(InventoryView.forNumber(0))
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<Inventory> future =
   *       osConfigZonalServiceClient.listInventoriesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Inventory element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListInventoriesRequest, ListInventoriesPagedResponse>
      listInventoriesPagedCallable() {
    return stub.listInventoriesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List inventory data for all VM instances in the specified zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   ListInventoriesRequest request =
   *       ListInventoriesRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setView(InventoryView.forNumber(0))
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListInventoriesResponse response =
   *         osConfigZonalServiceClient.listInventoriesCallable().call(request);
   *     for (Inventory element : response.getInventoriesList()) {
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
  public final UnaryCallable<ListInventoriesRequest, ListInventoriesResponse>
      listInventoriesCallable() {
    return stub.listInventoriesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the vulnerability report for the specified VM instance. Only VMs with inventory data have
   * vulnerability reports associated with them.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   VulnerabilityReportName name =
   *       VulnerabilityReportName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   VulnerabilityReport response = osConfigZonalServiceClient.getVulnerabilityReport(name);
   * }
   * }</pre>
   *
   * @param name Required. API resource name for vulnerability resource.
   *     <p>Format:
   *     `projects/{project}/locations/{location}/instances/{instance}/vulnerabilityReport`
   *     <p>For `{project}`, either `project-number` or `project-id` can be provided. For
   *     `{instance}`, either Compute Engine `instance-id` or `instance-name` can be provided.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VulnerabilityReport getVulnerabilityReport(VulnerabilityReportName name) {
    GetVulnerabilityReportRequest request =
        GetVulnerabilityReportRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getVulnerabilityReport(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the vulnerability report for the specified VM instance. Only VMs with inventory data have
   * vulnerability reports associated with them.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   String name = VulnerabilityReportName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   VulnerabilityReport response = osConfigZonalServiceClient.getVulnerabilityReport(name);
   * }
   * }</pre>
   *
   * @param name Required. API resource name for vulnerability resource.
   *     <p>Format:
   *     `projects/{project}/locations/{location}/instances/{instance}/vulnerabilityReport`
   *     <p>For `{project}`, either `project-number` or `project-id` can be provided. For
   *     `{instance}`, either Compute Engine `instance-id` or `instance-name` can be provided.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VulnerabilityReport getVulnerabilityReport(String name) {
    GetVulnerabilityReportRequest request =
        GetVulnerabilityReportRequest.newBuilder().setName(name).build();
    return getVulnerabilityReport(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the vulnerability report for the specified VM instance. Only VMs with inventory data have
   * vulnerability reports associated with them.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   GetVulnerabilityReportRequest request =
   *       GetVulnerabilityReportRequest.newBuilder()
   *           .setName(
   *               VulnerabilityReportName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   VulnerabilityReport response = osConfigZonalServiceClient.getVulnerabilityReport(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VulnerabilityReport getVulnerabilityReport(GetVulnerabilityReportRequest request) {
    return getVulnerabilityReportCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the vulnerability report for the specified VM instance. Only VMs with inventory data have
   * vulnerability reports associated with them.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   GetVulnerabilityReportRequest request =
   *       GetVulnerabilityReportRequest.newBuilder()
   *           .setName(
   *               VulnerabilityReportName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   ApiFuture<VulnerabilityReport> future =
   *       osConfigZonalServiceClient.getVulnerabilityReportCallable().futureCall(request);
   *   // Do something.
   *   VulnerabilityReport response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetVulnerabilityReportRequest, VulnerabilityReport>
      getVulnerabilityReportCallable() {
    return stub.getVulnerabilityReportCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List vulnerability reports for all VM instances in the specified zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   for (VulnerabilityReport element :
   *       osConfigZonalServiceClient.listVulnerabilityReports(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name.
   *     <p>Format: `projects/{project}/locations/{location}/instances/-`
   *     <p>For `{project}`, either `project-number` or `project-id` can be provided.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListVulnerabilityReportsPagedResponse listVulnerabilityReports(InstanceName parent) {
    ListVulnerabilityReportsRequest request =
        ListVulnerabilityReportsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listVulnerabilityReports(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List vulnerability reports for all VM instances in the specified zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   String parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   for (VulnerabilityReport element :
   *       osConfigZonalServiceClient.listVulnerabilityReports(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name.
   *     <p>Format: `projects/{project}/locations/{location}/instances/-`
   *     <p>For `{project}`, either `project-number` or `project-id` can be provided.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListVulnerabilityReportsPagedResponse listVulnerabilityReports(String parent) {
    ListVulnerabilityReportsRequest request =
        ListVulnerabilityReportsRequest.newBuilder().setParent(parent).build();
    return listVulnerabilityReports(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List vulnerability reports for all VM instances in the specified zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   ListVulnerabilityReportsRequest request =
   *       ListVulnerabilityReportsRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (VulnerabilityReport element :
   *       osConfigZonalServiceClient.listVulnerabilityReports(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListVulnerabilityReportsPagedResponse listVulnerabilityReports(
      ListVulnerabilityReportsRequest request) {
    return listVulnerabilityReportsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List vulnerability reports for all VM instances in the specified zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   ListVulnerabilityReportsRequest request =
   *       ListVulnerabilityReportsRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<VulnerabilityReport> future =
   *       osConfigZonalServiceClient.listVulnerabilityReportsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (VulnerabilityReport element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListVulnerabilityReportsRequest, ListVulnerabilityReportsPagedResponse>
      listVulnerabilityReportsPagedCallable() {
    return stub.listVulnerabilityReportsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List vulnerability reports for all VM instances in the specified zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   ListVulnerabilityReportsRequest request =
   *       ListVulnerabilityReportsRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListVulnerabilityReportsResponse response =
   *         osConfigZonalServiceClient.listVulnerabilityReportsCallable().call(request);
   *     for (VulnerabilityReport element : response.getVulnerabilityReportsList()) {
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
  public final UnaryCallable<ListVulnerabilityReportsRequest, ListVulnerabilityReportsResponse>
      listVulnerabilityReportsCallable() {
    return stub.listVulnerabilityReportsCallable();
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

  public static class ListOSPolicyAssignmentsPagedResponse
      extends AbstractPagedListResponse<
          ListOSPolicyAssignmentsRequest,
          ListOSPolicyAssignmentsResponse,
          OSPolicyAssignment,
          ListOSPolicyAssignmentsPage,
          ListOSPolicyAssignmentsFixedSizeCollection> {

    public static ApiFuture<ListOSPolicyAssignmentsPagedResponse> createAsync(
        PageContext<
                ListOSPolicyAssignmentsRequest, ListOSPolicyAssignmentsResponse, OSPolicyAssignment>
            context,
        ApiFuture<ListOSPolicyAssignmentsResponse> futureResponse) {
      ApiFuture<ListOSPolicyAssignmentsPage> futurePage =
          ListOSPolicyAssignmentsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListOSPolicyAssignmentsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListOSPolicyAssignmentsPagedResponse(ListOSPolicyAssignmentsPage page) {
      super(page, ListOSPolicyAssignmentsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListOSPolicyAssignmentsPage
      extends AbstractPage<
          ListOSPolicyAssignmentsRequest,
          ListOSPolicyAssignmentsResponse,
          OSPolicyAssignment,
          ListOSPolicyAssignmentsPage> {

    private ListOSPolicyAssignmentsPage(
        PageContext<
                ListOSPolicyAssignmentsRequest, ListOSPolicyAssignmentsResponse, OSPolicyAssignment>
            context,
        ListOSPolicyAssignmentsResponse response) {
      super(context, response);
    }

    private static ListOSPolicyAssignmentsPage createEmptyPage() {
      return new ListOSPolicyAssignmentsPage(null, null);
    }

    @Override
    protected ListOSPolicyAssignmentsPage createPage(
        PageContext<
                ListOSPolicyAssignmentsRequest, ListOSPolicyAssignmentsResponse, OSPolicyAssignment>
            context,
        ListOSPolicyAssignmentsResponse response) {
      return new ListOSPolicyAssignmentsPage(context, response);
    }

    @Override
    public ApiFuture<ListOSPolicyAssignmentsPage> createPageAsync(
        PageContext<
                ListOSPolicyAssignmentsRequest, ListOSPolicyAssignmentsResponse, OSPolicyAssignment>
            context,
        ApiFuture<ListOSPolicyAssignmentsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListOSPolicyAssignmentsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListOSPolicyAssignmentsRequest,
          ListOSPolicyAssignmentsResponse,
          OSPolicyAssignment,
          ListOSPolicyAssignmentsPage,
          ListOSPolicyAssignmentsFixedSizeCollection> {

    private ListOSPolicyAssignmentsFixedSizeCollection(
        List<ListOSPolicyAssignmentsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListOSPolicyAssignmentsFixedSizeCollection createEmptyCollection() {
      return new ListOSPolicyAssignmentsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListOSPolicyAssignmentsFixedSizeCollection createCollection(
        List<ListOSPolicyAssignmentsPage> pages, int collectionSize) {
      return new ListOSPolicyAssignmentsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListOSPolicyAssignmentRevisionsPagedResponse
      extends AbstractPagedListResponse<
          ListOSPolicyAssignmentRevisionsRequest,
          ListOSPolicyAssignmentRevisionsResponse,
          OSPolicyAssignment,
          ListOSPolicyAssignmentRevisionsPage,
          ListOSPolicyAssignmentRevisionsFixedSizeCollection> {

    public static ApiFuture<ListOSPolicyAssignmentRevisionsPagedResponse> createAsync(
        PageContext<
                ListOSPolicyAssignmentRevisionsRequest,
                ListOSPolicyAssignmentRevisionsResponse,
                OSPolicyAssignment>
            context,
        ApiFuture<ListOSPolicyAssignmentRevisionsResponse> futureResponse) {
      ApiFuture<ListOSPolicyAssignmentRevisionsPage> futurePage =
          ListOSPolicyAssignmentRevisionsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListOSPolicyAssignmentRevisionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListOSPolicyAssignmentRevisionsPagedResponse(ListOSPolicyAssignmentRevisionsPage page) {
      super(page, ListOSPolicyAssignmentRevisionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListOSPolicyAssignmentRevisionsPage
      extends AbstractPage<
          ListOSPolicyAssignmentRevisionsRequest,
          ListOSPolicyAssignmentRevisionsResponse,
          OSPolicyAssignment,
          ListOSPolicyAssignmentRevisionsPage> {

    private ListOSPolicyAssignmentRevisionsPage(
        PageContext<
                ListOSPolicyAssignmentRevisionsRequest,
                ListOSPolicyAssignmentRevisionsResponse,
                OSPolicyAssignment>
            context,
        ListOSPolicyAssignmentRevisionsResponse response) {
      super(context, response);
    }

    private static ListOSPolicyAssignmentRevisionsPage createEmptyPage() {
      return new ListOSPolicyAssignmentRevisionsPage(null, null);
    }

    @Override
    protected ListOSPolicyAssignmentRevisionsPage createPage(
        PageContext<
                ListOSPolicyAssignmentRevisionsRequest,
                ListOSPolicyAssignmentRevisionsResponse,
                OSPolicyAssignment>
            context,
        ListOSPolicyAssignmentRevisionsResponse response) {
      return new ListOSPolicyAssignmentRevisionsPage(context, response);
    }

    @Override
    public ApiFuture<ListOSPolicyAssignmentRevisionsPage> createPageAsync(
        PageContext<
                ListOSPolicyAssignmentRevisionsRequest,
                ListOSPolicyAssignmentRevisionsResponse,
                OSPolicyAssignment>
            context,
        ApiFuture<ListOSPolicyAssignmentRevisionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListOSPolicyAssignmentRevisionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListOSPolicyAssignmentRevisionsRequest,
          ListOSPolicyAssignmentRevisionsResponse,
          OSPolicyAssignment,
          ListOSPolicyAssignmentRevisionsPage,
          ListOSPolicyAssignmentRevisionsFixedSizeCollection> {

    private ListOSPolicyAssignmentRevisionsFixedSizeCollection(
        List<ListOSPolicyAssignmentRevisionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListOSPolicyAssignmentRevisionsFixedSizeCollection createEmptyCollection() {
      return new ListOSPolicyAssignmentRevisionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListOSPolicyAssignmentRevisionsFixedSizeCollection createCollection(
        List<ListOSPolicyAssignmentRevisionsPage> pages, int collectionSize) {
      return new ListOSPolicyAssignmentRevisionsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListInstanceOSPoliciesCompliancesPagedResponse
      extends AbstractPagedListResponse<
          ListInstanceOSPoliciesCompliancesRequest,
          ListInstanceOSPoliciesCompliancesResponse,
          InstanceOSPoliciesCompliance,
          ListInstanceOSPoliciesCompliancesPage,
          ListInstanceOSPoliciesCompliancesFixedSizeCollection> {

    public static ApiFuture<ListInstanceOSPoliciesCompliancesPagedResponse> createAsync(
        PageContext<
                ListInstanceOSPoliciesCompliancesRequest,
                ListInstanceOSPoliciesCompliancesResponse,
                InstanceOSPoliciesCompliance>
            context,
        ApiFuture<ListInstanceOSPoliciesCompliancesResponse> futureResponse) {
      ApiFuture<ListInstanceOSPoliciesCompliancesPage> futurePage =
          ListInstanceOSPoliciesCompliancesPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListInstanceOSPoliciesCompliancesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListInstanceOSPoliciesCompliancesPagedResponse(
        ListInstanceOSPoliciesCompliancesPage page) {
      super(page, ListInstanceOSPoliciesCompliancesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListInstanceOSPoliciesCompliancesPage
      extends AbstractPage<
          ListInstanceOSPoliciesCompliancesRequest,
          ListInstanceOSPoliciesCompliancesResponse,
          InstanceOSPoliciesCompliance,
          ListInstanceOSPoliciesCompliancesPage> {

    private ListInstanceOSPoliciesCompliancesPage(
        PageContext<
                ListInstanceOSPoliciesCompliancesRequest,
                ListInstanceOSPoliciesCompliancesResponse,
                InstanceOSPoliciesCompliance>
            context,
        ListInstanceOSPoliciesCompliancesResponse response) {
      super(context, response);
    }

    private static ListInstanceOSPoliciesCompliancesPage createEmptyPage() {
      return new ListInstanceOSPoliciesCompliancesPage(null, null);
    }

    @Override
    protected ListInstanceOSPoliciesCompliancesPage createPage(
        PageContext<
                ListInstanceOSPoliciesCompliancesRequest,
                ListInstanceOSPoliciesCompliancesResponse,
                InstanceOSPoliciesCompliance>
            context,
        ListInstanceOSPoliciesCompliancesResponse response) {
      return new ListInstanceOSPoliciesCompliancesPage(context, response);
    }

    @Override
    public ApiFuture<ListInstanceOSPoliciesCompliancesPage> createPageAsync(
        PageContext<
                ListInstanceOSPoliciesCompliancesRequest,
                ListInstanceOSPoliciesCompliancesResponse,
                InstanceOSPoliciesCompliance>
            context,
        ApiFuture<ListInstanceOSPoliciesCompliancesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListInstanceOSPoliciesCompliancesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListInstanceOSPoliciesCompliancesRequest,
          ListInstanceOSPoliciesCompliancesResponse,
          InstanceOSPoliciesCompliance,
          ListInstanceOSPoliciesCompliancesPage,
          ListInstanceOSPoliciesCompliancesFixedSizeCollection> {

    private ListInstanceOSPoliciesCompliancesFixedSizeCollection(
        List<ListInstanceOSPoliciesCompliancesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListInstanceOSPoliciesCompliancesFixedSizeCollection createEmptyCollection() {
      return new ListInstanceOSPoliciesCompliancesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListInstanceOSPoliciesCompliancesFixedSizeCollection createCollection(
        List<ListInstanceOSPoliciesCompliancesPage> pages, int collectionSize) {
      return new ListInstanceOSPoliciesCompliancesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListOSPolicyAssignmentReportsPagedResponse
      extends AbstractPagedListResponse<
          ListOSPolicyAssignmentReportsRequest,
          ListOSPolicyAssignmentReportsResponse,
          OSPolicyAssignmentReport,
          ListOSPolicyAssignmentReportsPage,
          ListOSPolicyAssignmentReportsFixedSizeCollection> {

    public static ApiFuture<ListOSPolicyAssignmentReportsPagedResponse> createAsync(
        PageContext<
                ListOSPolicyAssignmentReportsRequest,
                ListOSPolicyAssignmentReportsResponse,
                OSPolicyAssignmentReport>
            context,
        ApiFuture<ListOSPolicyAssignmentReportsResponse> futureResponse) {
      ApiFuture<ListOSPolicyAssignmentReportsPage> futurePage =
          ListOSPolicyAssignmentReportsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListOSPolicyAssignmentReportsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListOSPolicyAssignmentReportsPagedResponse(ListOSPolicyAssignmentReportsPage page) {
      super(page, ListOSPolicyAssignmentReportsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListOSPolicyAssignmentReportsPage
      extends AbstractPage<
          ListOSPolicyAssignmentReportsRequest,
          ListOSPolicyAssignmentReportsResponse,
          OSPolicyAssignmentReport,
          ListOSPolicyAssignmentReportsPage> {

    private ListOSPolicyAssignmentReportsPage(
        PageContext<
                ListOSPolicyAssignmentReportsRequest,
                ListOSPolicyAssignmentReportsResponse,
                OSPolicyAssignmentReport>
            context,
        ListOSPolicyAssignmentReportsResponse response) {
      super(context, response);
    }

    private static ListOSPolicyAssignmentReportsPage createEmptyPage() {
      return new ListOSPolicyAssignmentReportsPage(null, null);
    }

    @Override
    protected ListOSPolicyAssignmentReportsPage createPage(
        PageContext<
                ListOSPolicyAssignmentReportsRequest,
                ListOSPolicyAssignmentReportsResponse,
                OSPolicyAssignmentReport>
            context,
        ListOSPolicyAssignmentReportsResponse response) {
      return new ListOSPolicyAssignmentReportsPage(context, response);
    }

    @Override
    public ApiFuture<ListOSPolicyAssignmentReportsPage> createPageAsync(
        PageContext<
                ListOSPolicyAssignmentReportsRequest,
                ListOSPolicyAssignmentReportsResponse,
                OSPolicyAssignmentReport>
            context,
        ApiFuture<ListOSPolicyAssignmentReportsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListOSPolicyAssignmentReportsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListOSPolicyAssignmentReportsRequest,
          ListOSPolicyAssignmentReportsResponse,
          OSPolicyAssignmentReport,
          ListOSPolicyAssignmentReportsPage,
          ListOSPolicyAssignmentReportsFixedSizeCollection> {

    private ListOSPolicyAssignmentReportsFixedSizeCollection(
        List<ListOSPolicyAssignmentReportsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListOSPolicyAssignmentReportsFixedSizeCollection createEmptyCollection() {
      return new ListOSPolicyAssignmentReportsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListOSPolicyAssignmentReportsFixedSizeCollection createCollection(
        List<ListOSPolicyAssignmentReportsPage> pages, int collectionSize) {
      return new ListOSPolicyAssignmentReportsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListInventoriesPagedResponse
      extends AbstractPagedListResponse<
          ListInventoriesRequest,
          ListInventoriesResponse,
          Inventory,
          ListInventoriesPage,
          ListInventoriesFixedSizeCollection> {

    public static ApiFuture<ListInventoriesPagedResponse> createAsync(
        PageContext<ListInventoriesRequest, ListInventoriesResponse, Inventory> context,
        ApiFuture<ListInventoriesResponse> futureResponse) {
      ApiFuture<ListInventoriesPage> futurePage =
          ListInventoriesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListInventoriesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListInventoriesPagedResponse(ListInventoriesPage page) {
      super(page, ListInventoriesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListInventoriesPage
      extends AbstractPage<
          ListInventoriesRequest, ListInventoriesResponse, Inventory, ListInventoriesPage> {

    private ListInventoriesPage(
        PageContext<ListInventoriesRequest, ListInventoriesResponse, Inventory> context,
        ListInventoriesResponse response) {
      super(context, response);
    }

    private static ListInventoriesPage createEmptyPage() {
      return new ListInventoriesPage(null, null);
    }

    @Override
    protected ListInventoriesPage createPage(
        PageContext<ListInventoriesRequest, ListInventoriesResponse, Inventory> context,
        ListInventoriesResponse response) {
      return new ListInventoriesPage(context, response);
    }

    @Override
    public ApiFuture<ListInventoriesPage> createPageAsync(
        PageContext<ListInventoriesRequest, ListInventoriesResponse, Inventory> context,
        ApiFuture<ListInventoriesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListInventoriesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListInventoriesRequest,
          ListInventoriesResponse,
          Inventory,
          ListInventoriesPage,
          ListInventoriesFixedSizeCollection> {

    private ListInventoriesFixedSizeCollection(
        List<ListInventoriesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListInventoriesFixedSizeCollection createEmptyCollection() {
      return new ListInventoriesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListInventoriesFixedSizeCollection createCollection(
        List<ListInventoriesPage> pages, int collectionSize) {
      return new ListInventoriesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListVulnerabilityReportsPagedResponse
      extends AbstractPagedListResponse<
          ListVulnerabilityReportsRequest,
          ListVulnerabilityReportsResponse,
          VulnerabilityReport,
          ListVulnerabilityReportsPage,
          ListVulnerabilityReportsFixedSizeCollection> {

    public static ApiFuture<ListVulnerabilityReportsPagedResponse> createAsync(
        PageContext<
                ListVulnerabilityReportsRequest,
                ListVulnerabilityReportsResponse,
                VulnerabilityReport>
            context,
        ApiFuture<ListVulnerabilityReportsResponse> futureResponse) {
      ApiFuture<ListVulnerabilityReportsPage> futurePage =
          ListVulnerabilityReportsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListVulnerabilityReportsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListVulnerabilityReportsPagedResponse(ListVulnerabilityReportsPage page) {
      super(page, ListVulnerabilityReportsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListVulnerabilityReportsPage
      extends AbstractPage<
          ListVulnerabilityReportsRequest,
          ListVulnerabilityReportsResponse,
          VulnerabilityReport,
          ListVulnerabilityReportsPage> {

    private ListVulnerabilityReportsPage(
        PageContext<
                ListVulnerabilityReportsRequest,
                ListVulnerabilityReportsResponse,
                VulnerabilityReport>
            context,
        ListVulnerabilityReportsResponse response) {
      super(context, response);
    }

    private static ListVulnerabilityReportsPage createEmptyPage() {
      return new ListVulnerabilityReportsPage(null, null);
    }

    @Override
    protected ListVulnerabilityReportsPage createPage(
        PageContext<
                ListVulnerabilityReportsRequest,
                ListVulnerabilityReportsResponse,
                VulnerabilityReport>
            context,
        ListVulnerabilityReportsResponse response) {
      return new ListVulnerabilityReportsPage(context, response);
    }

    @Override
    public ApiFuture<ListVulnerabilityReportsPage> createPageAsync(
        PageContext<
                ListVulnerabilityReportsRequest,
                ListVulnerabilityReportsResponse,
                VulnerabilityReport>
            context,
        ApiFuture<ListVulnerabilityReportsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListVulnerabilityReportsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListVulnerabilityReportsRequest,
          ListVulnerabilityReportsResponse,
          VulnerabilityReport,
          ListVulnerabilityReportsPage,
          ListVulnerabilityReportsFixedSizeCollection> {

    private ListVulnerabilityReportsFixedSizeCollection(
        List<ListVulnerabilityReportsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListVulnerabilityReportsFixedSizeCollection createEmptyCollection() {
      return new ListVulnerabilityReportsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListVulnerabilityReportsFixedSizeCollection createCollection(
        List<ListVulnerabilityReportsPage> pages, int collectionSize) {
      return new ListVulnerabilityReportsFixedSizeCollection(pages, collectionSize);
    }
  }
}
