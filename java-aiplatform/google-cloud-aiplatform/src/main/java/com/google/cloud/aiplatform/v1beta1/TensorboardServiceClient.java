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
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1beta1.stub.TensorboardServiceStub;
import com.google.cloud.aiplatform.v1beta1.stub.TensorboardServiceStubSettings;
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
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: TensorboardService
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
 * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
 *   TensorboardName name = TensorboardName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]");
 *   Tensorboard response = tensorboardServiceClient.getTensorboard(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the TensorboardServiceClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of TensorboardServiceSettings to
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
 * TensorboardServiceSettings tensorboardServiceSettings =
 *     TensorboardServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * TensorboardServiceClient tensorboardServiceClient =
 *     TensorboardServiceClient.create(tensorboardServiceSettings);
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
 * TensorboardServiceSettings tensorboardServiceSettings =
 *     TensorboardServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * TensorboardServiceClient tensorboardServiceClient =
 *     TensorboardServiceClient.create(tensorboardServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class TensorboardServiceClient implements BackgroundResource {
  private final TensorboardServiceSettings settings;
  private final TensorboardServiceStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of TensorboardServiceClient with default settings. */
  public static final TensorboardServiceClient create() throws IOException {
    return create(TensorboardServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of TensorboardServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final TensorboardServiceClient create(TensorboardServiceSettings settings)
      throws IOException {
    return new TensorboardServiceClient(settings);
  }

  /**
   * Constructs an instance of TensorboardServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(TensorboardServiceSettings).
   */
  public static final TensorboardServiceClient create(TensorboardServiceStub stub) {
    return new TensorboardServiceClient(stub);
  }

  /**
   * Constructs an instance of TensorboardServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected TensorboardServiceClient(TensorboardServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((TensorboardServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  protected TensorboardServiceClient(TensorboardServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final TensorboardServiceSettings getSettings() {
    return settings;
  }

  public TensorboardServiceStub getStub() {
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
   * Creates a Tensorboard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   TensorboardName parent = TensorboardName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]");
   *   Tensorboard tensorboard = Tensorboard.newBuilder().build();
   *   Tensorboard response =
   *       tensorboardServiceClient.createTensorboardAsync(parent, tensorboard).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to create the Tensorboard in. Format:
   *     `projects/{project}/locations/{location}`
   * @param tensorboard Required. The Tensorboard to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Tensorboard, CreateTensorboardOperationMetadata>
      createTensorboardAsync(TensorboardName parent, Tensorboard tensorboard) {
    CreateTensorboardRequest request =
        CreateTensorboardRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setTensorboard(tensorboard)
            .build();
    return createTensorboardAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Tensorboard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   String parent = TensorboardName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]").toString();
   *   Tensorboard tensorboard = Tensorboard.newBuilder().build();
   *   Tensorboard response =
   *       tensorboardServiceClient.createTensorboardAsync(parent, tensorboard).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to create the Tensorboard in. Format:
   *     `projects/{project}/locations/{location}`
   * @param tensorboard Required. The Tensorboard to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Tensorboard, CreateTensorboardOperationMetadata>
      createTensorboardAsync(String parent, Tensorboard tensorboard) {
    CreateTensorboardRequest request =
        CreateTensorboardRequest.newBuilder().setParent(parent).setTensorboard(tensorboard).build();
    return createTensorboardAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Tensorboard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   CreateTensorboardRequest request =
   *       CreateTensorboardRequest.newBuilder()
   *           .setParent(TensorboardName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]").toString())
   *           .setTensorboard(Tensorboard.newBuilder().build())
   *           .build();
   *   Tensorboard response = tensorboardServiceClient.createTensorboardAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Tensorboard, CreateTensorboardOperationMetadata>
      createTensorboardAsync(CreateTensorboardRequest request) {
    return createTensorboardOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Tensorboard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   CreateTensorboardRequest request =
   *       CreateTensorboardRequest.newBuilder()
   *           .setParent(TensorboardName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]").toString())
   *           .setTensorboard(Tensorboard.newBuilder().build())
   *           .build();
   *   OperationFuture<Tensorboard, CreateTensorboardOperationMetadata> future =
   *       tensorboardServiceClient.createTensorboardOperationCallable().futureCall(request);
   *   // Do something.
   *   Tensorboard response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateTensorboardRequest, Tensorboard, CreateTensorboardOperationMetadata>
      createTensorboardOperationCallable() {
    return stub.createTensorboardOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Tensorboard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   CreateTensorboardRequest request =
   *       CreateTensorboardRequest.newBuilder()
   *           .setParent(TensorboardName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]").toString())
   *           .setTensorboard(Tensorboard.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       tensorboardServiceClient.createTensorboardCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateTensorboardRequest, Operation> createTensorboardCallable() {
    return stub.createTensorboardCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Tensorboard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   TensorboardName name = TensorboardName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]");
   *   Tensorboard response = tensorboardServiceClient.getTensorboard(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Tensorboard resource. Format:
   *     `projects/{project}/locations/{location}/tensorboards/{tensorboard}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Tensorboard getTensorboard(TensorboardName name) {
    GetTensorboardRequest request =
        GetTensorboardRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getTensorboard(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Tensorboard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   String name = TensorboardName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]").toString();
   *   Tensorboard response = tensorboardServiceClient.getTensorboard(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Tensorboard resource. Format:
   *     `projects/{project}/locations/{location}/tensorboards/{tensorboard}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Tensorboard getTensorboard(String name) {
    GetTensorboardRequest request = GetTensorboardRequest.newBuilder().setName(name).build();
    return getTensorboard(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Tensorboard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   GetTensorboardRequest request =
   *       GetTensorboardRequest.newBuilder()
   *           .setName(TensorboardName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]").toString())
   *           .build();
   *   Tensorboard response = tensorboardServiceClient.getTensorboard(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Tensorboard getTensorboard(GetTensorboardRequest request) {
    return getTensorboardCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Tensorboard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   GetTensorboardRequest request =
   *       GetTensorboardRequest.newBuilder()
   *           .setName(TensorboardName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]").toString())
   *           .build();
   *   ApiFuture<Tensorboard> future =
   *       tensorboardServiceClient.getTensorboardCallable().futureCall(request);
   *   // Do something.
   *   Tensorboard response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetTensorboardRequest, Tensorboard> getTensorboardCallable() {
    return stub.getTensorboardCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of monthly active users for a given TensorBoard instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   TensorboardName tensorboard = TensorboardName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]");
   *   ReadTensorboardUsageResponse response =
   *       tensorboardServiceClient.readTensorboardUsage(tensorboard);
   * }
   * }</pre>
   *
   * @param tensorboard Required. The name of the Tensorboard resource. Format:
   *     `projects/{project}/locations/{location}/tensorboards/{tensorboard}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReadTensorboardUsageResponse readTensorboardUsage(TensorboardName tensorboard) {
    ReadTensorboardUsageRequest request =
        ReadTensorboardUsageRequest.newBuilder()
            .setTensorboard(tensorboard == null ? null : tensorboard.toString())
            .build();
    return readTensorboardUsage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of monthly active users for a given TensorBoard instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   String tensorboard =
   *       TensorboardName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]").toString();
   *   ReadTensorboardUsageResponse response =
   *       tensorboardServiceClient.readTensorboardUsage(tensorboard);
   * }
   * }</pre>
   *
   * @param tensorboard Required. The name of the Tensorboard resource. Format:
   *     `projects/{project}/locations/{location}/tensorboards/{tensorboard}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReadTensorboardUsageResponse readTensorboardUsage(String tensorboard) {
    ReadTensorboardUsageRequest request =
        ReadTensorboardUsageRequest.newBuilder().setTensorboard(tensorboard).build();
    return readTensorboardUsage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of monthly active users for a given TensorBoard instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   ReadTensorboardUsageRequest request =
   *       ReadTensorboardUsageRequest.newBuilder()
   *           .setTensorboard(
   *               TensorboardName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]").toString())
   *           .build();
   *   ReadTensorboardUsageResponse response =
   *       tensorboardServiceClient.readTensorboardUsage(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReadTensorboardUsageResponse readTensorboardUsage(
      ReadTensorboardUsageRequest request) {
    return readTensorboardUsageCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of monthly active users for a given TensorBoard instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   ReadTensorboardUsageRequest request =
   *       ReadTensorboardUsageRequest.newBuilder()
   *           .setTensorboard(
   *               TensorboardName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]").toString())
   *           .build();
   *   ApiFuture<ReadTensorboardUsageResponse> future =
   *       tensorboardServiceClient.readTensorboardUsageCallable().futureCall(request);
   *   // Do something.
   *   ReadTensorboardUsageResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ReadTensorboardUsageRequest, ReadTensorboardUsageResponse>
      readTensorboardUsageCallable() {
    return stub.readTensorboardUsageCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a Tensorboard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   Tensorboard tensorboard = Tensorboard.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Tensorboard response =
   *       tensorboardServiceClient.updateTensorboardAsync(tensorboard, updateMask).get();
   * }
   * }</pre>
   *
   * @param tensorboard Required. The Tensorboard's `name` field is used to identify the Tensorboard
   *     to be updated. Format: `projects/{project}/locations/{location}/tensorboards/{tensorboard}`
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     Tensorboard resource by the update. The fields specified in the update_mask are relative to
   *     the resource, not the full request. A field is overwritten if it's in the mask. If the user
   *     does not provide a mask then all fields are overwritten if new values are specified.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Tensorboard, UpdateTensorboardOperationMetadata>
      updateTensorboardAsync(Tensorboard tensorboard, FieldMask updateMask) {
    UpdateTensorboardRequest request =
        UpdateTensorboardRequest.newBuilder()
            .setTensorboard(tensorboard)
            .setUpdateMask(updateMask)
            .build();
    return updateTensorboardAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a Tensorboard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   UpdateTensorboardRequest request =
   *       UpdateTensorboardRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setTensorboard(Tensorboard.newBuilder().build())
   *           .build();
   *   Tensorboard response = tensorboardServiceClient.updateTensorboardAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Tensorboard, UpdateTensorboardOperationMetadata>
      updateTensorboardAsync(UpdateTensorboardRequest request) {
    return updateTensorboardOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a Tensorboard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   UpdateTensorboardRequest request =
   *       UpdateTensorboardRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setTensorboard(Tensorboard.newBuilder().build())
   *           .build();
   *   OperationFuture<Tensorboard, UpdateTensorboardOperationMetadata> future =
   *       tensorboardServiceClient.updateTensorboardOperationCallable().futureCall(request);
   *   // Do something.
   *   Tensorboard response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UpdateTensorboardRequest, Tensorboard, UpdateTensorboardOperationMetadata>
      updateTensorboardOperationCallable() {
    return stub.updateTensorboardOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a Tensorboard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   UpdateTensorboardRequest request =
   *       UpdateTensorboardRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setTensorboard(Tensorboard.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       tensorboardServiceClient.updateTensorboardCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateTensorboardRequest, Operation> updateTensorboardCallable() {
    return stub.updateTensorboardCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Tensorboards in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Tensorboard element : tensorboardServiceClient.listTensorboards(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to list Tensorboards. Format:
   *     `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTensorboardsPagedResponse listTensorboards(LocationName parent) {
    ListTensorboardsRequest request =
        ListTensorboardsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listTensorboards(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Tensorboards in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Tensorboard element : tensorboardServiceClient.listTensorboards(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to list Tensorboards. Format:
   *     `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTensorboardsPagedResponse listTensorboards(String parent) {
    ListTensorboardsRequest request =
        ListTensorboardsRequest.newBuilder().setParent(parent).build();
    return listTensorboards(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Tensorboards in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   ListTensorboardsRequest request =
   *       ListTensorboardsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   for (Tensorboard element : tensorboardServiceClient.listTensorboards(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTensorboardsPagedResponse listTensorboards(ListTensorboardsRequest request) {
    return listTensorboardsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Tensorboards in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   ListTensorboardsRequest request =
   *       ListTensorboardsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Tensorboard> future =
   *       tensorboardServiceClient.listTensorboardsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Tensorboard element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListTensorboardsRequest, ListTensorboardsPagedResponse>
      listTensorboardsPagedCallable() {
    return stub.listTensorboardsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Tensorboards in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   ListTensorboardsRequest request =
   *       ListTensorboardsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   while (true) {
   *     ListTensorboardsResponse response =
   *         tensorboardServiceClient.listTensorboardsCallable().call(request);
   *     for (Tensorboard element : response.getTensorboardsList()) {
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
  public final UnaryCallable<ListTensorboardsRequest, ListTensorboardsResponse>
      listTensorboardsCallable() {
    return stub.listTensorboardsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Tensorboard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   TensorboardName name = TensorboardName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]");
   *   tensorboardServiceClient.deleteTensorboardAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the Tensorboard to be deleted. Format:
   *     `projects/{project}/locations/{location}/tensorboards/{tensorboard}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteTensorboardAsync(
      TensorboardName name) {
    DeleteTensorboardRequest request =
        DeleteTensorboardRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteTensorboardAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Tensorboard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   String name = TensorboardName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]").toString();
   *   tensorboardServiceClient.deleteTensorboardAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the Tensorboard to be deleted. Format:
   *     `projects/{project}/locations/{location}/tensorboards/{tensorboard}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteTensorboardAsync(String name) {
    DeleteTensorboardRequest request = DeleteTensorboardRequest.newBuilder().setName(name).build();
    return deleteTensorboardAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Tensorboard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   DeleteTensorboardRequest request =
   *       DeleteTensorboardRequest.newBuilder()
   *           .setName(TensorboardName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]").toString())
   *           .build();
   *   tensorboardServiceClient.deleteTensorboardAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteTensorboardAsync(
      DeleteTensorboardRequest request) {
    return deleteTensorboardOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Tensorboard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   DeleteTensorboardRequest request =
   *       DeleteTensorboardRequest.newBuilder()
   *           .setName(TensorboardName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]").toString())
   *           .build();
   *   OperationFuture<Empty, DeleteOperationMetadata> future =
   *       tensorboardServiceClient.deleteTensorboardOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteTensorboardRequest, Empty, DeleteOperationMetadata>
      deleteTensorboardOperationCallable() {
    return stub.deleteTensorboardOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Tensorboard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   DeleteTensorboardRequest request =
   *       DeleteTensorboardRequest.newBuilder()
   *           .setName(TensorboardName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       tensorboardServiceClient.deleteTensorboardCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteTensorboardRequest, Operation> deleteTensorboardCallable() {
    return stub.deleteTensorboardCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a TensorboardExperiment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   TensorboardExperimentName parent =
   *       TensorboardExperimentName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]");
   *   TensorboardExperiment tensorboardExperiment = TensorboardExperiment.newBuilder().build();
   *   String tensorboardExperimentId = "tensorboardExperimentId1267328197";
   *   TensorboardExperiment response =
   *       tensorboardServiceClient.createTensorboardExperiment(
   *           parent, tensorboardExperiment, tensorboardExperimentId);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Tensorboard to create the
   *     TensorboardExperiment in. Format:
   *     `projects/{project}/locations/{location}/tensorboards/{tensorboard}`
   * @param tensorboardExperiment The TensorboardExperiment to create.
   * @param tensorboardExperimentId Required. The ID to use for the Tensorboard experiment, which
   *     becomes the final component of the Tensorboard experiment's resource name.
   *     <p>This value should be 1-128 characters, and valid characters are /[a-z][0-9]-/.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TensorboardExperiment createTensorboardExperiment(
      TensorboardExperimentName parent,
      TensorboardExperiment tensorboardExperiment,
      String tensorboardExperimentId) {
    CreateTensorboardExperimentRequest request =
        CreateTensorboardExperimentRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setTensorboardExperiment(tensorboardExperiment)
            .setTensorboardExperimentId(tensorboardExperimentId)
            .build();
    return createTensorboardExperiment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a TensorboardExperiment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   String parent =
   *       TensorboardExperimentName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]")
   *           .toString();
   *   TensorboardExperiment tensorboardExperiment = TensorboardExperiment.newBuilder().build();
   *   String tensorboardExperimentId = "tensorboardExperimentId1267328197";
   *   TensorboardExperiment response =
   *       tensorboardServiceClient.createTensorboardExperiment(
   *           parent, tensorboardExperiment, tensorboardExperimentId);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Tensorboard to create the
   *     TensorboardExperiment in. Format:
   *     `projects/{project}/locations/{location}/tensorboards/{tensorboard}`
   * @param tensorboardExperiment The TensorboardExperiment to create.
   * @param tensorboardExperimentId Required. The ID to use for the Tensorboard experiment, which
   *     becomes the final component of the Tensorboard experiment's resource name.
   *     <p>This value should be 1-128 characters, and valid characters are /[a-z][0-9]-/.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TensorboardExperiment createTensorboardExperiment(
      String parent, TensorboardExperiment tensorboardExperiment, String tensorboardExperimentId) {
    CreateTensorboardExperimentRequest request =
        CreateTensorboardExperimentRequest.newBuilder()
            .setParent(parent)
            .setTensorboardExperiment(tensorboardExperiment)
            .setTensorboardExperimentId(tensorboardExperimentId)
            .build();
    return createTensorboardExperiment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a TensorboardExperiment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   CreateTensorboardExperimentRequest request =
   *       CreateTensorboardExperimentRequest.newBuilder()
   *           .setParent(
   *               TensorboardExperimentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]")
   *                   .toString())
   *           .setTensorboardExperiment(TensorboardExperiment.newBuilder().build())
   *           .setTensorboardExperimentId("tensorboardExperimentId1267328197")
   *           .build();
   *   TensorboardExperiment response =
   *       tensorboardServiceClient.createTensorboardExperiment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TensorboardExperiment createTensorboardExperiment(
      CreateTensorboardExperimentRequest request) {
    return createTensorboardExperimentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a TensorboardExperiment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   CreateTensorboardExperimentRequest request =
   *       CreateTensorboardExperimentRequest.newBuilder()
   *           .setParent(
   *               TensorboardExperimentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]")
   *                   .toString())
   *           .setTensorboardExperiment(TensorboardExperiment.newBuilder().build())
   *           .setTensorboardExperimentId("tensorboardExperimentId1267328197")
   *           .build();
   *   ApiFuture<TensorboardExperiment> future =
   *       tensorboardServiceClient.createTensorboardExperimentCallable().futureCall(request);
   *   // Do something.
   *   TensorboardExperiment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateTensorboardExperimentRequest, TensorboardExperiment>
      createTensorboardExperimentCallable() {
    return stub.createTensorboardExperimentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a TensorboardExperiment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   TensorboardExperimentName name =
   *       TensorboardExperimentName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]");
   *   TensorboardExperiment response = tensorboardServiceClient.getTensorboardExperiment(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the TensorboardExperiment resource. Format:
   *     `projects/{project}/locations/{location}/tensorboards/{tensorboard}/experiments/{experiment}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TensorboardExperiment getTensorboardExperiment(TensorboardExperimentName name) {
    GetTensorboardExperimentRequest request =
        GetTensorboardExperimentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getTensorboardExperiment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a TensorboardExperiment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   String name =
   *       TensorboardExperimentName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]")
   *           .toString();
   *   TensorboardExperiment response = tensorboardServiceClient.getTensorboardExperiment(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the TensorboardExperiment resource. Format:
   *     `projects/{project}/locations/{location}/tensorboards/{tensorboard}/experiments/{experiment}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TensorboardExperiment getTensorboardExperiment(String name) {
    GetTensorboardExperimentRequest request =
        GetTensorboardExperimentRequest.newBuilder().setName(name).build();
    return getTensorboardExperiment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a TensorboardExperiment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   GetTensorboardExperimentRequest request =
   *       GetTensorboardExperimentRequest.newBuilder()
   *           .setName(
   *               TensorboardExperimentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]")
   *                   .toString())
   *           .build();
   *   TensorboardExperiment response = tensorboardServiceClient.getTensorboardExperiment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TensorboardExperiment getTensorboardExperiment(
      GetTensorboardExperimentRequest request) {
    return getTensorboardExperimentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a TensorboardExperiment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   GetTensorboardExperimentRequest request =
   *       GetTensorboardExperimentRequest.newBuilder()
   *           .setName(
   *               TensorboardExperimentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<TensorboardExperiment> future =
   *       tensorboardServiceClient.getTensorboardExperimentCallable().futureCall(request);
   *   // Do something.
   *   TensorboardExperiment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetTensorboardExperimentRequest, TensorboardExperiment>
      getTensorboardExperimentCallable() {
    return stub.getTensorboardExperimentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a TensorboardExperiment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   TensorboardExperiment tensorboardExperiment = TensorboardExperiment.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   TensorboardExperiment response =
   *       tensorboardServiceClient.updateTensorboardExperiment(tensorboardExperiment, updateMask);
   * }
   * }</pre>
   *
   * @param tensorboardExperiment Required. The TensorboardExperiment's `name` field is used to
   *     identify the TensorboardExperiment to be updated. Format:
   *     `projects/{project}/locations/{location}/tensorboards/{tensorboard}/experiments/{experiment}`
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     TensorboardExperiment resource by the update. The fields specified in the update_mask are
   *     relative to the resource, not the full request. A field is overwritten if it's in the mask.
   *     If the user does not provide a mask then all fields are overwritten if new values are
   *     specified.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TensorboardExperiment updateTensorboardExperiment(
      TensorboardExperiment tensorboardExperiment, FieldMask updateMask) {
    UpdateTensorboardExperimentRequest request =
        UpdateTensorboardExperimentRequest.newBuilder()
            .setTensorboardExperiment(tensorboardExperiment)
            .setUpdateMask(updateMask)
            .build();
    return updateTensorboardExperiment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a TensorboardExperiment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   UpdateTensorboardExperimentRequest request =
   *       UpdateTensorboardExperimentRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setTensorboardExperiment(TensorboardExperiment.newBuilder().build())
   *           .build();
   *   TensorboardExperiment response =
   *       tensorboardServiceClient.updateTensorboardExperiment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TensorboardExperiment updateTensorboardExperiment(
      UpdateTensorboardExperimentRequest request) {
    return updateTensorboardExperimentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a TensorboardExperiment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   UpdateTensorboardExperimentRequest request =
   *       UpdateTensorboardExperimentRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setTensorboardExperiment(TensorboardExperiment.newBuilder().build())
   *           .build();
   *   ApiFuture<TensorboardExperiment> future =
   *       tensorboardServiceClient.updateTensorboardExperimentCallable().futureCall(request);
   *   // Do something.
   *   TensorboardExperiment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateTensorboardExperimentRequest, TensorboardExperiment>
      updateTensorboardExperimentCallable() {
    return stub.updateTensorboardExperimentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists TensorboardExperiments in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   TensorboardName parent = TensorboardName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]");
   *   for (TensorboardExperiment element :
   *       tensorboardServiceClient.listTensorboardExperiments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Tensorboard to list TensorboardExperiments.
   *     Format: `projects/{project}/locations/{location}/tensorboards/{tensorboard}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTensorboardExperimentsPagedResponse listTensorboardExperiments(
      TensorboardName parent) {
    ListTensorboardExperimentsRequest request =
        ListTensorboardExperimentsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listTensorboardExperiments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists TensorboardExperiments in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   String parent = TensorboardName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]").toString();
   *   for (TensorboardExperiment element :
   *       tensorboardServiceClient.listTensorboardExperiments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Tensorboard to list TensorboardExperiments.
   *     Format: `projects/{project}/locations/{location}/tensorboards/{tensorboard}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTensorboardExperimentsPagedResponse listTensorboardExperiments(String parent) {
    ListTensorboardExperimentsRequest request =
        ListTensorboardExperimentsRequest.newBuilder().setParent(parent).build();
    return listTensorboardExperiments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists TensorboardExperiments in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   ListTensorboardExperimentsRequest request =
   *       ListTensorboardExperimentsRequest.newBuilder()
   *           .setParent(TensorboardName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   for (TensorboardExperiment element :
   *       tensorboardServiceClient.listTensorboardExperiments(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTensorboardExperimentsPagedResponse listTensorboardExperiments(
      ListTensorboardExperimentsRequest request) {
    return listTensorboardExperimentsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists TensorboardExperiments in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   ListTensorboardExperimentsRequest request =
   *       ListTensorboardExperimentsRequest.newBuilder()
   *           .setParent(TensorboardName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<TensorboardExperiment> future =
   *       tensorboardServiceClient.listTensorboardExperimentsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (TensorboardExperiment element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListTensorboardExperimentsRequest, ListTensorboardExperimentsPagedResponse>
      listTensorboardExperimentsPagedCallable() {
    return stub.listTensorboardExperimentsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists TensorboardExperiments in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   ListTensorboardExperimentsRequest request =
   *       ListTensorboardExperimentsRequest.newBuilder()
   *           .setParent(TensorboardName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   while (true) {
   *     ListTensorboardExperimentsResponse response =
   *         tensorboardServiceClient.listTensorboardExperimentsCallable().call(request);
   *     for (TensorboardExperiment element : response.getTensorboardExperimentsList()) {
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
  public final UnaryCallable<ListTensorboardExperimentsRequest, ListTensorboardExperimentsResponse>
      listTensorboardExperimentsCallable() {
    return stub.listTensorboardExperimentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a TensorboardExperiment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   TensorboardExperimentName name =
   *       TensorboardExperimentName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]");
   *   tensorboardServiceClient.deleteTensorboardExperimentAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the TensorboardExperiment to be deleted. Format:
   *     `projects/{project}/locations/{location}/tensorboards/{tensorboard}/experiments/{experiment}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteTensorboardExperimentAsync(
      TensorboardExperimentName name) {
    DeleteTensorboardExperimentRequest request =
        DeleteTensorboardExperimentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteTensorboardExperimentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a TensorboardExperiment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   String name =
   *       TensorboardExperimentName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]")
   *           .toString();
   *   tensorboardServiceClient.deleteTensorboardExperimentAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the TensorboardExperiment to be deleted. Format:
   *     `projects/{project}/locations/{location}/tensorboards/{tensorboard}/experiments/{experiment}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteTensorboardExperimentAsync(
      String name) {
    DeleteTensorboardExperimentRequest request =
        DeleteTensorboardExperimentRequest.newBuilder().setName(name).build();
    return deleteTensorboardExperimentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a TensorboardExperiment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   DeleteTensorboardExperimentRequest request =
   *       DeleteTensorboardExperimentRequest.newBuilder()
   *           .setName(
   *               TensorboardExperimentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]")
   *                   .toString())
   *           .build();
   *   tensorboardServiceClient.deleteTensorboardExperimentAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteTensorboardExperimentAsync(
      DeleteTensorboardExperimentRequest request) {
    return deleteTensorboardExperimentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a TensorboardExperiment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   DeleteTensorboardExperimentRequest request =
   *       DeleteTensorboardExperimentRequest.newBuilder()
   *           .setName(
   *               TensorboardExperimentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]")
   *                   .toString())
   *           .build();
   *   OperationFuture<Empty, DeleteOperationMetadata> future =
   *       tensorboardServiceClient
   *           .deleteTensorboardExperimentOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteTensorboardExperimentRequest, Empty, DeleteOperationMetadata>
      deleteTensorboardExperimentOperationCallable() {
    return stub.deleteTensorboardExperimentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a TensorboardExperiment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   DeleteTensorboardExperimentRequest request =
   *       DeleteTensorboardExperimentRequest.newBuilder()
   *           .setName(
   *               TensorboardExperimentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       tensorboardServiceClient.deleteTensorboardExperimentCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteTensorboardExperimentRequest, Operation>
      deleteTensorboardExperimentCallable() {
    return stub.deleteTensorboardExperimentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a TensorboardRun.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   TensorboardRunName parent =
   *       TensorboardRunName.of(
   *           "[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]", "[RUN]");
   *   TensorboardRun tensorboardRun = TensorboardRun.newBuilder().build();
   *   String tensorboardRunId = "tensorboardRunId-407822631";
   *   TensorboardRun response =
   *       tensorboardServiceClient.createTensorboardRun(parent, tensorboardRun, tensorboardRunId);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the TensorboardExperiment to create the
   *     TensorboardRun in. Format:
   *     `projects/{project}/locations/{location}/tensorboards/{tensorboard}/experiments/{experiment}`
   * @param tensorboardRun Required. The TensorboardRun to create.
   * @param tensorboardRunId Required. The ID to use for the Tensorboard run, which becomes the
   *     final component of the Tensorboard run's resource name.
   *     <p>This value should be 1-128 characters, and valid characters are /[a-z][0-9]-/.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TensorboardRun createTensorboardRun(
      TensorboardRunName parent, TensorboardRun tensorboardRun, String tensorboardRunId) {
    CreateTensorboardRunRequest request =
        CreateTensorboardRunRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setTensorboardRun(tensorboardRun)
            .setTensorboardRunId(tensorboardRunId)
            .build();
    return createTensorboardRun(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a TensorboardRun.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   String parent =
   *       TensorboardRunName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]", "[RUN]")
   *           .toString();
   *   TensorboardRun tensorboardRun = TensorboardRun.newBuilder().build();
   *   String tensorboardRunId = "tensorboardRunId-407822631";
   *   TensorboardRun response =
   *       tensorboardServiceClient.createTensorboardRun(parent, tensorboardRun, tensorboardRunId);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the TensorboardExperiment to create the
   *     TensorboardRun in. Format:
   *     `projects/{project}/locations/{location}/tensorboards/{tensorboard}/experiments/{experiment}`
   * @param tensorboardRun Required. The TensorboardRun to create.
   * @param tensorboardRunId Required. The ID to use for the Tensorboard run, which becomes the
   *     final component of the Tensorboard run's resource name.
   *     <p>This value should be 1-128 characters, and valid characters are /[a-z][0-9]-/.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TensorboardRun createTensorboardRun(
      String parent, TensorboardRun tensorboardRun, String tensorboardRunId) {
    CreateTensorboardRunRequest request =
        CreateTensorboardRunRequest.newBuilder()
            .setParent(parent)
            .setTensorboardRun(tensorboardRun)
            .setTensorboardRunId(tensorboardRunId)
            .build();
    return createTensorboardRun(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a TensorboardRun.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   CreateTensorboardRunRequest request =
   *       CreateTensorboardRunRequest.newBuilder()
   *           .setParent(
   *               TensorboardRunName.of(
   *                       "[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]", "[RUN]")
   *                   .toString())
   *           .setTensorboardRun(TensorboardRun.newBuilder().build())
   *           .setTensorboardRunId("tensorboardRunId-407822631")
   *           .build();
   *   TensorboardRun response = tensorboardServiceClient.createTensorboardRun(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TensorboardRun createTensorboardRun(CreateTensorboardRunRequest request) {
    return createTensorboardRunCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a TensorboardRun.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   CreateTensorboardRunRequest request =
   *       CreateTensorboardRunRequest.newBuilder()
   *           .setParent(
   *               TensorboardRunName.of(
   *                       "[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]", "[RUN]")
   *                   .toString())
   *           .setTensorboardRun(TensorboardRun.newBuilder().build())
   *           .setTensorboardRunId("tensorboardRunId-407822631")
   *           .build();
   *   ApiFuture<TensorboardRun> future =
   *       tensorboardServiceClient.createTensorboardRunCallable().futureCall(request);
   *   // Do something.
   *   TensorboardRun response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateTensorboardRunRequest, TensorboardRun>
      createTensorboardRunCallable() {
    return stub.createTensorboardRunCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch create TensorboardRuns.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   TensorboardExperimentName parent =
   *       TensorboardExperimentName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]");
   *   List<CreateTensorboardRunRequest> requests = new ArrayList<>();
   *   BatchCreateTensorboardRunsResponse response =
   *       tensorboardServiceClient.batchCreateTensorboardRuns(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the TensorboardExperiment to create the
   *     TensorboardRuns in. Format:
   *     `projects/{project}/locations/{location}/tensorboards/{tensorboard}/experiments/{experiment}`
   *     The parent field in the CreateTensorboardRunRequest messages must match this field.
   * @param requests Required. The request message specifying the TensorboardRuns to create. A
   *     maximum of 1000 TensorboardRuns can be created in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateTensorboardRunsResponse batchCreateTensorboardRuns(
      TensorboardExperimentName parent, List<CreateTensorboardRunRequest> requests) {
    BatchCreateTensorboardRunsRequest request =
        BatchCreateTensorboardRunsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return batchCreateTensorboardRuns(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch create TensorboardRuns.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   String parent =
   *       TensorboardExperimentName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]")
   *           .toString();
   *   List<CreateTensorboardRunRequest> requests = new ArrayList<>();
   *   BatchCreateTensorboardRunsResponse response =
   *       tensorboardServiceClient.batchCreateTensorboardRuns(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the TensorboardExperiment to create the
   *     TensorboardRuns in. Format:
   *     `projects/{project}/locations/{location}/tensorboards/{tensorboard}/experiments/{experiment}`
   *     The parent field in the CreateTensorboardRunRequest messages must match this field.
   * @param requests Required. The request message specifying the TensorboardRuns to create. A
   *     maximum of 1000 TensorboardRuns can be created in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateTensorboardRunsResponse batchCreateTensorboardRuns(
      String parent, List<CreateTensorboardRunRequest> requests) {
    BatchCreateTensorboardRunsRequest request =
        BatchCreateTensorboardRunsRequest.newBuilder()
            .setParent(parent)
            .addAllRequests(requests)
            .build();
    return batchCreateTensorboardRuns(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch create TensorboardRuns.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   BatchCreateTensorboardRunsRequest request =
   *       BatchCreateTensorboardRunsRequest.newBuilder()
   *           .setParent(
   *               TensorboardExperimentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]")
   *                   .toString())
   *           .addAllRequests(new ArrayList<CreateTensorboardRunRequest>())
   *           .build();
   *   BatchCreateTensorboardRunsResponse response =
   *       tensorboardServiceClient.batchCreateTensorboardRuns(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateTensorboardRunsResponse batchCreateTensorboardRuns(
      BatchCreateTensorboardRunsRequest request) {
    return batchCreateTensorboardRunsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch create TensorboardRuns.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   BatchCreateTensorboardRunsRequest request =
   *       BatchCreateTensorboardRunsRequest.newBuilder()
   *           .setParent(
   *               TensorboardExperimentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]")
   *                   .toString())
   *           .addAllRequests(new ArrayList<CreateTensorboardRunRequest>())
   *           .build();
   *   ApiFuture<BatchCreateTensorboardRunsResponse> future =
   *       tensorboardServiceClient.batchCreateTensorboardRunsCallable().futureCall(request);
   *   // Do something.
   *   BatchCreateTensorboardRunsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchCreateTensorboardRunsRequest, BatchCreateTensorboardRunsResponse>
      batchCreateTensorboardRunsCallable() {
    return stub.batchCreateTensorboardRunsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a TensorboardRun.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   TensorboardRunName name =
   *       TensorboardRunName.of(
   *           "[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]", "[RUN]");
   *   TensorboardRun response = tensorboardServiceClient.getTensorboardRun(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the TensorboardRun resource. Format:
   *     `projects/{project}/locations/{location}/tensorboards/{tensorboard}/experiments/{experiment}/runs/{run}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TensorboardRun getTensorboardRun(TensorboardRunName name) {
    GetTensorboardRunRequest request =
        GetTensorboardRunRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getTensorboardRun(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a TensorboardRun.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   String name =
   *       TensorboardRunName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]", "[RUN]")
   *           .toString();
   *   TensorboardRun response = tensorboardServiceClient.getTensorboardRun(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the TensorboardRun resource. Format:
   *     `projects/{project}/locations/{location}/tensorboards/{tensorboard}/experiments/{experiment}/runs/{run}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TensorboardRun getTensorboardRun(String name) {
    GetTensorboardRunRequest request = GetTensorboardRunRequest.newBuilder().setName(name).build();
    return getTensorboardRun(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a TensorboardRun.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   GetTensorboardRunRequest request =
   *       GetTensorboardRunRequest.newBuilder()
   *           .setName(
   *               TensorboardRunName.of(
   *                       "[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]", "[RUN]")
   *                   .toString())
   *           .build();
   *   TensorboardRun response = tensorboardServiceClient.getTensorboardRun(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TensorboardRun getTensorboardRun(GetTensorboardRunRequest request) {
    return getTensorboardRunCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a TensorboardRun.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   GetTensorboardRunRequest request =
   *       GetTensorboardRunRequest.newBuilder()
   *           .setName(
   *               TensorboardRunName.of(
   *                       "[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]", "[RUN]")
   *                   .toString())
   *           .build();
   *   ApiFuture<TensorboardRun> future =
   *       tensorboardServiceClient.getTensorboardRunCallable().futureCall(request);
   *   // Do something.
   *   TensorboardRun response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetTensorboardRunRequest, TensorboardRun> getTensorboardRunCallable() {
    return stub.getTensorboardRunCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a TensorboardRun.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   TensorboardRun tensorboardRun = TensorboardRun.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   TensorboardRun response =
   *       tensorboardServiceClient.updateTensorboardRun(tensorboardRun, updateMask);
   * }
   * }</pre>
   *
   * @param tensorboardRun Required. The TensorboardRun's `name` field is used to identify the
   *     TensorboardRun to be updated. Format:
   *     `projects/{project}/locations/{location}/tensorboards/{tensorboard}/experiments/{experiment}/runs/{run}`
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     TensorboardRun resource by the update. The fields specified in the update_mask are relative
   *     to the resource, not the full request. A field is overwritten if it's in the mask. If the
   *     user does not provide a mask then all fields are overwritten if new values are specified.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TensorboardRun updateTensorboardRun(
      TensorboardRun tensorboardRun, FieldMask updateMask) {
    UpdateTensorboardRunRequest request =
        UpdateTensorboardRunRequest.newBuilder()
            .setTensorboardRun(tensorboardRun)
            .setUpdateMask(updateMask)
            .build();
    return updateTensorboardRun(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a TensorboardRun.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   UpdateTensorboardRunRequest request =
   *       UpdateTensorboardRunRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setTensorboardRun(TensorboardRun.newBuilder().build())
   *           .build();
   *   TensorboardRun response = tensorboardServiceClient.updateTensorboardRun(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TensorboardRun updateTensorboardRun(UpdateTensorboardRunRequest request) {
    return updateTensorboardRunCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a TensorboardRun.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   UpdateTensorboardRunRequest request =
   *       UpdateTensorboardRunRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setTensorboardRun(TensorboardRun.newBuilder().build())
   *           .build();
   *   ApiFuture<TensorboardRun> future =
   *       tensorboardServiceClient.updateTensorboardRunCallable().futureCall(request);
   *   // Do something.
   *   TensorboardRun response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateTensorboardRunRequest, TensorboardRun>
      updateTensorboardRunCallable() {
    return stub.updateTensorboardRunCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists TensorboardRuns in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   TensorboardExperimentName parent =
   *       TensorboardExperimentName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]");
   *   for (TensorboardRun element :
   *       tensorboardServiceClient.listTensorboardRuns(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the TensorboardExperiment to list TensorboardRuns.
   *     Format:
   *     `projects/{project}/locations/{location}/tensorboards/{tensorboard}/experiments/{experiment}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTensorboardRunsPagedResponse listTensorboardRuns(
      TensorboardExperimentName parent) {
    ListTensorboardRunsRequest request =
        ListTensorboardRunsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listTensorboardRuns(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists TensorboardRuns in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   String parent =
   *       TensorboardExperimentName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]")
   *           .toString();
   *   for (TensorboardRun element :
   *       tensorboardServiceClient.listTensorboardRuns(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the TensorboardExperiment to list TensorboardRuns.
   *     Format:
   *     `projects/{project}/locations/{location}/tensorboards/{tensorboard}/experiments/{experiment}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTensorboardRunsPagedResponse listTensorboardRuns(String parent) {
    ListTensorboardRunsRequest request =
        ListTensorboardRunsRequest.newBuilder().setParent(parent).build();
    return listTensorboardRuns(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists TensorboardRuns in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   ListTensorboardRunsRequest request =
   *       ListTensorboardRunsRequest.newBuilder()
   *           .setParent(
   *               TensorboardExperimentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]")
   *                   .toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   for (TensorboardRun element :
   *       tensorboardServiceClient.listTensorboardRuns(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTensorboardRunsPagedResponse listTensorboardRuns(
      ListTensorboardRunsRequest request) {
    return listTensorboardRunsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists TensorboardRuns in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   ListTensorboardRunsRequest request =
   *       ListTensorboardRunsRequest.newBuilder()
   *           .setParent(
   *               TensorboardExperimentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]")
   *                   .toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<TensorboardRun> future =
   *       tensorboardServiceClient.listTensorboardRunsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (TensorboardRun element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListTensorboardRunsRequest, ListTensorboardRunsPagedResponse>
      listTensorboardRunsPagedCallable() {
    return stub.listTensorboardRunsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists TensorboardRuns in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   ListTensorboardRunsRequest request =
   *       ListTensorboardRunsRequest.newBuilder()
   *           .setParent(
   *               TensorboardExperimentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]")
   *                   .toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   while (true) {
   *     ListTensorboardRunsResponse response =
   *         tensorboardServiceClient.listTensorboardRunsCallable().call(request);
   *     for (TensorboardRun element : response.getTensorboardRunsList()) {
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
  public final UnaryCallable<ListTensorboardRunsRequest, ListTensorboardRunsResponse>
      listTensorboardRunsCallable() {
    return stub.listTensorboardRunsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a TensorboardRun.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   TensorboardRunName name =
   *       TensorboardRunName.of(
   *           "[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]", "[RUN]");
   *   tensorboardServiceClient.deleteTensorboardRunAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the TensorboardRun to be deleted. Format:
   *     `projects/{project}/locations/{location}/tensorboards/{tensorboard}/experiments/{experiment}/runs/{run}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteTensorboardRunAsync(
      TensorboardRunName name) {
    DeleteTensorboardRunRequest request =
        DeleteTensorboardRunRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteTensorboardRunAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a TensorboardRun.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   String name =
   *       TensorboardRunName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]", "[RUN]")
   *           .toString();
   *   tensorboardServiceClient.deleteTensorboardRunAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the TensorboardRun to be deleted. Format:
   *     `projects/{project}/locations/{location}/tensorboards/{tensorboard}/experiments/{experiment}/runs/{run}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteTensorboardRunAsync(
      String name) {
    DeleteTensorboardRunRequest request =
        DeleteTensorboardRunRequest.newBuilder().setName(name).build();
    return deleteTensorboardRunAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a TensorboardRun.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   DeleteTensorboardRunRequest request =
   *       DeleteTensorboardRunRequest.newBuilder()
   *           .setName(
   *               TensorboardRunName.of(
   *                       "[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]", "[RUN]")
   *                   .toString())
   *           .build();
   *   tensorboardServiceClient.deleteTensorboardRunAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteTensorboardRunAsync(
      DeleteTensorboardRunRequest request) {
    return deleteTensorboardRunOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a TensorboardRun.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   DeleteTensorboardRunRequest request =
   *       DeleteTensorboardRunRequest.newBuilder()
   *           .setName(
   *               TensorboardRunName.of(
   *                       "[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]", "[RUN]")
   *                   .toString())
   *           .build();
   *   OperationFuture<Empty, DeleteOperationMetadata> future =
   *       tensorboardServiceClient.deleteTensorboardRunOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteTensorboardRunRequest, Empty, DeleteOperationMetadata>
      deleteTensorboardRunOperationCallable() {
    return stub.deleteTensorboardRunOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a TensorboardRun.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   DeleteTensorboardRunRequest request =
   *       DeleteTensorboardRunRequest.newBuilder()
   *           .setName(
   *               TensorboardRunName.of(
   *                       "[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]", "[RUN]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       tensorboardServiceClient.deleteTensorboardRunCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteTensorboardRunRequest, Operation>
      deleteTensorboardRunCallable() {
    return stub.deleteTensorboardRunCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch create TensorboardTimeSeries that belong to a TensorboardExperiment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   TensorboardExperimentName parent =
   *       TensorboardExperimentName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]");
   *   List<CreateTensorboardTimeSeriesRequest> requests = new ArrayList<>();
   *   BatchCreateTensorboardTimeSeriesResponse response =
   *       tensorboardServiceClient.batchCreateTensorboardTimeSeries(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the TensorboardExperiment to create the
   *     TensorboardTimeSeries in. Format:
   *     `projects/{project}/locations/{location}/tensorboards/{tensorboard}/experiments/{experiment}`
   *     The TensorboardRuns referenced by the parent fields in the
   *     CreateTensorboardTimeSeriesRequest messages must be sub resources of this
   *     TensorboardExperiment.
   * @param requests Required. The request message specifying the TensorboardTimeSeries to create. A
   *     maximum of 1000 TensorboardTimeSeries can be created in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateTensorboardTimeSeriesResponse batchCreateTensorboardTimeSeries(
      TensorboardExperimentName parent, List<CreateTensorboardTimeSeriesRequest> requests) {
    BatchCreateTensorboardTimeSeriesRequest request =
        BatchCreateTensorboardTimeSeriesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return batchCreateTensorboardTimeSeries(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch create TensorboardTimeSeries that belong to a TensorboardExperiment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   String parent =
   *       TensorboardExperimentName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]")
   *           .toString();
   *   List<CreateTensorboardTimeSeriesRequest> requests = new ArrayList<>();
   *   BatchCreateTensorboardTimeSeriesResponse response =
   *       tensorboardServiceClient.batchCreateTensorboardTimeSeries(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the TensorboardExperiment to create the
   *     TensorboardTimeSeries in. Format:
   *     `projects/{project}/locations/{location}/tensorboards/{tensorboard}/experiments/{experiment}`
   *     The TensorboardRuns referenced by the parent fields in the
   *     CreateTensorboardTimeSeriesRequest messages must be sub resources of this
   *     TensorboardExperiment.
   * @param requests Required. The request message specifying the TensorboardTimeSeries to create. A
   *     maximum of 1000 TensorboardTimeSeries can be created in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateTensorboardTimeSeriesResponse batchCreateTensorboardTimeSeries(
      String parent, List<CreateTensorboardTimeSeriesRequest> requests) {
    BatchCreateTensorboardTimeSeriesRequest request =
        BatchCreateTensorboardTimeSeriesRequest.newBuilder()
            .setParent(parent)
            .addAllRequests(requests)
            .build();
    return batchCreateTensorboardTimeSeries(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch create TensorboardTimeSeries that belong to a TensorboardExperiment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   BatchCreateTensorboardTimeSeriesRequest request =
   *       BatchCreateTensorboardTimeSeriesRequest.newBuilder()
   *           .setParent(
   *               TensorboardExperimentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]")
   *                   .toString())
   *           .addAllRequests(new ArrayList<CreateTensorboardTimeSeriesRequest>())
   *           .build();
   *   BatchCreateTensorboardTimeSeriesResponse response =
   *       tensorboardServiceClient.batchCreateTensorboardTimeSeries(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateTensorboardTimeSeriesResponse batchCreateTensorboardTimeSeries(
      BatchCreateTensorboardTimeSeriesRequest request) {
    return batchCreateTensorboardTimeSeriesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch create TensorboardTimeSeries that belong to a TensorboardExperiment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   BatchCreateTensorboardTimeSeriesRequest request =
   *       BatchCreateTensorboardTimeSeriesRequest.newBuilder()
   *           .setParent(
   *               TensorboardExperimentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]")
   *                   .toString())
   *           .addAllRequests(new ArrayList<CreateTensorboardTimeSeriesRequest>())
   *           .build();
   *   ApiFuture<BatchCreateTensorboardTimeSeriesResponse> future =
   *       tensorboardServiceClient.batchCreateTensorboardTimeSeriesCallable().futureCall(request);
   *   // Do something.
   *   BatchCreateTensorboardTimeSeriesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          BatchCreateTensorboardTimeSeriesRequest, BatchCreateTensorboardTimeSeriesResponse>
      batchCreateTensorboardTimeSeriesCallable() {
    return stub.batchCreateTensorboardTimeSeriesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a TensorboardTimeSeries.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   TensorboardTimeSeriesName parent =
   *       TensorboardTimeSeriesName.of(
   *           "[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]", "[RUN]", "[TIME_SERIES]");
   *   TensorboardTimeSeries tensorboardTimeSeries = TensorboardTimeSeries.newBuilder().build();
   *   TensorboardTimeSeries response =
   *       tensorboardServiceClient.createTensorboardTimeSeries(parent, tensorboardTimeSeries);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the TensorboardRun to create the
   *     TensorboardTimeSeries in. Format:
   *     `projects/{project}/locations/{location}/tensorboards/{tensorboard}/experiments/{experiment}/runs/{run}`
   * @param tensorboardTimeSeries Required. The TensorboardTimeSeries to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TensorboardTimeSeries createTensorboardTimeSeries(
      TensorboardTimeSeriesName parent, TensorboardTimeSeries tensorboardTimeSeries) {
    CreateTensorboardTimeSeriesRequest request =
        CreateTensorboardTimeSeriesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setTensorboardTimeSeries(tensorboardTimeSeries)
            .build();
    return createTensorboardTimeSeries(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a TensorboardTimeSeries.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   String parent =
   *       TensorboardTimeSeriesName.of(
   *               "[PROJECT]",
   *               "[LOCATION]",
   *               "[TENSORBOARD]",
   *               "[EXPERIMENT]",
   *               "[RUN]",
   *               "[TIME_SERIES]")
   *           .toString();
   *   TensorboardTimeSeries tensorboardTimeSeries = TensorboardTimeSeries.newBuilder().build();
   *   TensorboardTimeSeries response =
   *       tensorboardServiceClient.createTensorboardTimeSeries(parent, tensorboardTimeSeries);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the TensorboardRun to create the
   *     TensorboardTimeSeries in. Format:
   *     `projects/{project}/locations/{location}/tensorboards/{tensorboard}/experiments/{experiment}/runs/{run}`
   * @param tensorboardTimeSeries Required. The TensorboardTimeSeries to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TensorboardTimeSeries createTensorboardTimeSeries(
      String parent, TensorboardTimeSeries tensorboardTimeSeries) {
    CreateTensorboardTimeSeriesRequest request =
        CreateTensorboardTimeSeriesRequest.newBuilder()
            .setParent(parent)
            .setTensorboardTimeSeries(tensorboardTimeSeries)
            .build();
    return createTensorboardTimeSeries(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a TensorboardTimeSeries.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   CreateTensorboardTimeSeriesRequest request =
   *       CreateTensorboardTimeSeriesRequest.newBuilder()
   *           .setParent(
   *               TensorboardTimeSeriesName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[TENSORBOARD]",
   *                       "[EXPERIMENT]",
   *                       "[RUN]",
   *                       "[TIME_SERIES]")
   *                   .toString())
   *           .setTensorboardTimeSeriesId("tensorboardTimeSeriesId-913380692")
   *           .setTensorboardTimeSeries(TensorboardTimeSeries.newBuilder().build())
   *           .build();
   *   TensorboardTimeSeries response =
   *       tensorboardServiceClient.createTensorboardTimeSeries(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TensorboardTimeSeries createTensorboardTimeSeries(
      CreateTensorboardTimeSeriesRequest request) {
    return createTensorboardTimeSeriesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a TensorboardTimeSeries.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   CreateTensorboardTimeSeriesRequest request =
   *       CreateTensorboardTimeSeriesRequest.newBuilder()
   *           .setParent(
   *               TensorboardTimeSeriesName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[TENSORBOARD]",
   *                       "[EXPERIMENT]",
   *                       "[RUN]",
   *                       "[TIME_SERIES]")
   *                   .toString())
   *           .setTensorboardTimeSeriesId("tensorboardTimeSeriesId-913380692")
   *           .setTensorboardTimeSeries(TensorboardTimeSeries.newBuilder().build())
   *           .build();
   *   ApiFuture<TensorboardTimeSeries> future =
   *       tensorboardServiceClient.createTensorboardTimeSeriesCallable().futureCall(request);
   *   // Do something.
   *   TensorboardTimeSeries response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateTensorboardTimeSeriesRequest, TensorboardTimeSeries>
      createTensorboardTimeSeriesCallable() {
    return stub.createTensorboardTimeSeriesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a TensorboardTimeSeries.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   TensorboardTimeSeriesName name =
   *       TensorboardTimeSeriesName.of(
   *           "[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]", "[RUN]", "[TIME_SERIES]");
   *   TensorboardTimeSeries response = tensorboardServiceClient.getTensorboardTimeSeries(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the TensorboardTimeSeries resource. Format:
   *     `projects/{project}/locations/{location}/tensorboards/{tensorboard}/experiments/{experiment}/runs/{run}/timeSeries/{time_series}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TensorboardTimeSeries getTensorboardTimeSeries(TensorboardTimeSeriesName name) {
    GetTensorboardTimeSeriesRequest request =
        GetTensorboardTimeSeriesRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getTensorboardTimeSeries(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a TensorboardTimeSeries.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   String name =
   *       TensorboardTimeSeriesName.of(
   *               "[PROJECT]",
   *               "[LOCATION]",
   *               "[TENSORBOARD]",
   *               "[EXPERIMENT]",
   *               "[RUN]",
   *               "[TIME_SERIES]")
   *           .toString();
   *   TensorboardTimeSeries response = tensorboardServiceClient.getTensorboardTimeSeries(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the TensorboardTimeSeries resource. Format:
   *     `projects/{project}/locations/{location}/tensorboards/{tensorboard}/experiments/{experiment}/runs/{run}/timeSeries/{time_series}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TensorboardTimeSeries getTensorboardTimeSeries(String name) {
    GetTensorboardTimeSeriesRequest request =
        GetTensorboardTimeSeriesRequest.newBuilder().setName(name).build();
    return getTensorboardTimeSeries(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a TensorboardTimeSeries.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   GetTensorboardTimeSeriesRequest request =
   *       GetTensorboardTimeSeriesRequest.newBuilder()
   *           .setName(
   *               TensorboardTimeSeriesName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[TENSORBOARD]",
   *                       "[EXPERIMENT]",
   *                       "[RUN]",
   *                       "[TIME_SERIES]")
   *                   .toString())
   *           .build();
   *   TensorboardTimeSeries response = tensorboardServiceClient.getTensorboardTimeSeries(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TensorboardTimeSeries getTensorboardTimeSeries(
      GetTensorboardTimeSeriesRequest request) {
    return getTensorboardTimeSeriesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a TensorboardTimeSeries.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   GetTensorboardTimeSeriesRequest request =
   *       GetTensorboardTimeSeriesRequest.newBuilder()
   *           .setName(
   *               TensorboardTimeSeriesName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[TENSORBOARD]",
   *                       "[EXPERIMENT]",
   *                       "[RUN]",
   *                       "[TIME_SERIES]")
   *                   .toString())
   *           .build();
   *   ApiFuture<TensorboardTimeSeries> future =
   *       tensorboardServiceClient.getTensorboardTimeSeriesCallable().futureCall(request);
   *   // Do something.
   *   TensorboardTimeSeries response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetTensorboardTimeSeriesRequest, TensorboardTimeSeries>
      getTensorboardTimeSeriesCallable() {
    return stub.getTensorboardTimeSeriesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a TensorboardTimeSeries.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   TensorboardTimeSeries tensorboardTimeSeries = TensorboardTimeSeries.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   TensorboardTimeSeries response =
   *       tensorboardServiceClient.updateTensorboardTimeSeries(tensorboardTimeSeries, updateMask);
   * }
   * }</pre>
   *
   * @param tensorboardTimeSeries Required. The TensorboardTimeSeries' `name` field is used to
   *     identify the TensorboardTimeSeries to be updated. Format:
   *     `projects/{project}/locations/{location}/tensorboards/{tensorboard}/experiments/{experiment}/runs/{run}/timeSeries/{time_series}`
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     TensorboardTimeSeries resource by the update. The fields specified in the update_mask are
   *     relative to the resource, not the full request. A field is overwritten if it's in the mask.
   *     If the user does not provide a mask then all fields are overwritten if new values are
   *     specified.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TensorboardTimeSeries updateTensorboardTimeSeries(
      TensorboardTimeSeries tensorboardTimeSeries, FieldMask updateMask) {
    UpdateTensorboardTimeSeriesRequest request =
        UpdateTensorboardTimeSeriesRequest.newBuilder()
            .setTensorboardTimeSeries(tensorboardTimeSeries)
            .setUpdateMask(updateMask)
            .build();
    return updateTensorboardTimeSeries(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a TensorboardTimeSeries.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   UpdateTensorboardTimeSeriesRequest request =
   *       UpdateTensorboardTimeSeriesRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setTensorboardTimeSeries(TensorboardTimeSeries.newBuilder().build())
   *           .build();
   *   TensorboardTimeSeries response =
   *       tensorboardServiceClient.updateTensorboardTimeSeries(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TensorboardTimeSeries updateTensorboardTimeSeries(
      UpdateTensorboardTimeSeriesRequest request) {
    return updateTensorboardTimeSeriesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a TensorboardTimeSeries.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   UpdateTensorboardTimeSeriesRequest request =
   *       UpdateTensorboardTimeSeriesRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setTensorboardTimeSeries(TensorboardTimeSeries.newBuilder().build())
   *           .build();
   *   ApiFuture<TensorboardTimeSeries> future =
   *       tensorboardServiceClient.updateTensorboardTimeSeriesCallable().futureCall(request);
   *   // Do something.
   *   TensorboardTimeSeries response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateTensorboardTimeSeriesRequest, TensorboardTimeSeries>
      updateTensorboardTimeSeriesCallable() {
    return stub.updateTensorboardTimeSeriesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists TensorboardTimeSeries in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   TensorboardRunName parent =
   *       TensorboardRunName.of(
   *           "[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]", "[RUN]");
   *   for (TensorboardTimeSeries element :
   *       tensorboardServiceClient.listTensorboardTimeSeries(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the TensorboardRun to list TensorboardTimeSeries.
   *     Format:
   *     `projects/{project}/locations/{location}/tensorboards/{tensorboard}/experiments/{experiment}/runs/{run}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTensorboardTimeSeriesPagedResponse listTensorboardTimeSeries(
      TensorboardRunName parent) {
    ListTensorboardTimeSeriesRequest request =
        ListTensorboardTimeSeriesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listTensorboardTimeSeries(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists TensorboardTimeSeries in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   String parent =
   *       TensorboardRunName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]", "[RUN]")
   *           .toString();
   *   for (TensorboardTimeSeries element :
   *       tensorboardServiceClient.listTensorboardTimeSeries(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the TensorboardRun to list TensorboardTimeSeries.
   *     Format:
   *     `projects/{project}/locations/{location}/tensorboards/{tensorboard}/experiments/{experiment}/runs/{run}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTensorboardTimeSeriesPagedResponse listTensorboardTimeSeries(String parent) {
    ListTensorboardTimeSeriesRequest request =
        ListTensorboardTimeSeriesRequest.newBuilder().setParent(parent).build();
    return listTensorboardTimeSeries(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists TensorboardTimeSeries in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   ListTensorboardTimeSeriesRequest request =
   *       ListTensorboardTimeSeriesRequest.newBuilder()
   *           .setParent(
   *               TensorboardRunName.of(
   *                       "[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]", "[RUN]")
   *                   .toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   for (TensorboardTimeSeries element :
   *       tensorboardServiceClient.listTensorboardTimeSeries(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTensorboardTimeSeriesPagedResponse listTensorboardTimeSeries(
      ListTensorboardTimeSeriesRequest request) {
    return listTensorboardTimeSeriesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists TensorboardTimeSeries in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   ListTensorboardTimeSeriesRequest request =
   *       ListTensorboardTimeSeriesRequest.newBuilder()
   *           .setParent(
   *               TensorboardRunName.of(
   *                       "[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]", "[RUN]")
   *                   .toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<TensorboardTimeSeries> future =
   *       tensorboardServiceClient.listTensorboardTimeSeriesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (TensorboardTimeSeries element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListTensorboardTimeSeriesRequest, ListTensorboardTimeSeriesPagedResponse>
      listTensorboardTimeSeriesPagedCallable() {
    return stub.listTensorboardTimeSeriesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists TensorboardTimeSeries in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   ListTensorboardTimeSeriesRequest request =
   *       ListTensorboardTimeSeriesRequest.newBuilder()
   *           .setParent(
   *               TensorboardRunName.of(
   *                       "[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]", "[RUN]")
   *                   .toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   while (true) {
   *     ListTensorboardTimeSeriesResponse response =
   *         tensorboardServiceClient.listTensorboardTimeSeriesCallable().call(request);
   *     for (TensorboardTimeSeries element : response.getTensorboardTimeSeriesList()) {
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
  public final UnaryCallable<ListTensorboardTimeSeriesRequest, ListTensorboardTimeSeriesResponse>
      listTensorboardTimeSeriesCallable() {
    return stub.listTensorboardTimeSeriesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a TensorboardTimeSeries.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   TensorboardTimeSeriesName name =
   *       TensorboardTimeSeriesName.of(
   *           "[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]", "[RUN]", "[TIME_SERIES]");
   *   tensorboardServiceClient.deleteTensorboardTimeSeriesAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the TensorboardTimeSeries to be deleted. Format:
   *     `projects/{project}/locations/{location}/tensorboards/{tensorboard}/experiments/{experiment}/runs/{run}/timeSeries/{time_series}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteTensorboardTimeSeriesAsync(
      TensorboardTimeSeriesName name) {
    DeleteTensorboardTimeSeriesRequest request =
        DeleteTensorboardTimeSeriesRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteTensorboardTimeSeriesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a TensorboardTimeSeries.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   String name =
   *       TensorboardTimeSeriesName.of(
   *               "[PROJECT]",
   *               "[LOCATION]",
   *               "[TENSORBOARD]",
   *               "[EXPERIMENT]",
   *               "[RUN]",
   *               "[TIME_SERIES]")
   *           .toString();
   *   tensorboardServiceClient.deleteTensorboardTimeSeriesAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the TensorboardTimeSeries to be deleted. Format:
   *     `projects/{project}/locations/{location}/tensorboards/{tensorboard}/experiments/{experiment}/runs/{run}/timeSeries/{time_series}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteTensorboardTimeSeriesAsync(
      String name) {
    DeleteTensorboardTimeSeriesRequest request =
        DeleteTensorboardTimeSeriesRequest.newBuilder().setName(name).build();
    return deleteTensorboardTimeSeriesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a TensorboardTimeSeries.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   DeleteTensorboardTimeSeriesRequest request =
   *       DeleteTensorboardTimeSeriesRequest.newBuilder()
   *           .setName(
   *               TensorboardTimeSeriesName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[TENSORBOARD]",
   *                       "[EXPERIMENT]",
   *                       "[RUN]",
   *                       "[TIME_SERIES]")
   *                   .toString())
   *           .build();
   *   tensorboardServiceClient.deleteTensorboardTimeSeriesAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteTensorboardTimeSeriesAsync(
      DeleteTensorboardTimeSeriesRequest request) {
    return deleteTensorboardTimeSeriesOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a TensorboardTimeSeries.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   DeleteTensorboardTimeSeriesRequest request =
   *       DeleteTensorboardTimeSeriesRequest.newBuilder()
   *           .setName(
   *               TensorboardTimeSeriesName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[TENSORBOARD]",
   *                       "[EXPERIMENT]",
   *                       "[RUN]",
   *                       "[TIME_SERIES]")
   *                   .toString())
   *           .build();
   *   OperationFuture<Empty, DeleteOperationMetadata> future =
   *       tensorboardServiceClient
   *           .deleteTensorboardTimeSeriesOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteTensorboardTimeSeriesRequest, Empty, DeleteOperationMetadata>
      deleteTensorboardTimeSeriesOperationCallable() {
    return stub.deleteTensorboardTimeSeriesOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a TensorboardTimeSeries.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   DeleteTensorboardTimeSeriesRequest request =
   *       DeleteTensorboardTimeSeriesRequest.newBuilder()
   *           .setName(
   *               TensorboardTimeSeriesName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[TENSORBOARD]",
   *                       "[EXPERIMENT]",
   *                       "[RUN]",
   *                       "[TIME_SERIES]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       tensorboardServiceClient.deleteTensorboardTimeSeriesCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteTensorboardTimeSeriesRequest, Operation>
      deleteTensorboardTimeSeriesCallable() {
    return stub.deleteTensorboardTimeSeriesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reads multiple TensorboardTimeSeries' data. The data point number limit is 1000 for scalars,
   * 100 for tensors and blob references. If the number of data points stored is less than the
   * limit, all data is returned. Otherwise, the number limit of data points is randomly selected
   * from this time series and returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   TensorboardName tensorboard = TensorboardName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]");
   *   BatchReadTensorboardTimeSeriesDataResponse response =
   *       tensorboardServiceClient.batchReadTensorboardTimeSeriesData(tensorboard);
   * }
   * }</pre>
   *
   * @param tensorboard Required. The resource name of the Tensorboard containing
   *     TensorboardTimeSeries to read data from. Format:
   *     `projects/{project}/locations/{location}/tensorboards/{tensorboard}`. The
   *     TensorboardTimeSeries referenced by
   *     [time_series][google.cloud.aiplatform.v1beta1.BatchReadTensorboardTimeSeriesDataRequest.time_series]
   *     must be sub resources of this Tensorboard.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchReadTensorboardTimeSeriesDataResponse batchReadTensorboardTimeSeriesData(
      TensorboardName tensorboard) {
    BatchReadTensorboardTimeSeriesDataRequest request =
        BatchReadTensorboardTimeSeriesDataRequest.newBuilder()
            .setTensorboard(tensorboard == null ? null : tensorboard.toString())
            .build();
    return batchReadTensorboardTimeSeriesData(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reads multiple TensorboardTimeSeries' data. The data point number limit is 1000 for scalars,
   * 100 for tensors and blob references. If the number of data points stored is less than the
   * limit, all data is returned. Otherwise, the number limit of data points is randomly selected
   * from this time series and returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   String tensorboard =
   *       TensorboardName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]").toString();
   *   BatchReadTensorboardTimeSeriesDataResponse response =
   *       tensorboardServiceClient.batchReadTensorboardTimeSeriesData(tensorboard);
   * }
   * }</pre>
   *
   * @param tensorboard Required. The resource name of the Tensorboard containing
   *     TensorboardTimeSeries to read data from. Format:
   *     `projects/{project}/locations/{location}/tensorboards/{tensorboard}`. The
   *     TensorboardTimeSeries referenced by
   *     [time_series][google.cloud.aiplatform.v1beta1.BatchReadTensorboardTimeSeriesDataRequest.time_series]
   *     must be sub resources of this Tensorboard.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchReadTensorboardTimeSeriesDataResponse batchReadTensorboardTimeSeriesData(
      String tensorboard) {
    BatchReadTensorboardTimeSeriesDataRequest request =
        BatchReadTensorboardTimeSeriesDataRequest.newBuilder().setTensorboard(tensorboard).build();
    return batchReadTensorboardTimeSeriesData(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reads multiple TensorboardTimeSeries' data. The data point number limit is 1000 for scalars,
   * 100 for tensors and blob references. If the number of data points stored is less than the
   * limit, all data is returned. Otherwise, the number limit of data points is randomly selected
   * from this time series and returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   BatchReadTensorboardTimeSeriesDataRequest request =
   *       BatchReadTensorboardTimeSeriesDataRequest.newBuilder()
   *           .setTensorboard(
   *               TensorboardName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]").toString())
   *           .addAllTimeSeries(new ArrayList<String>())
   *           .build();
   *   BatchReadTensorboardTimeSeriesDataResponse response =
   *       tensorboardServiceClient.batchReadTensorboardTimeSeriesData(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchReadTensorboardTimeSeriesDataResponse batchReadTensorboardTimeSeriesData(
      BatchReadTensorboardTimeSeriesDataRequest request) {
    return batchReadTensorboardTimeSeriesDataCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reads multiple TensorboardTimeSeries' data. The data point number limit is 1000 for scalars,
   * 100 for tensors and blob references. If the number of data points stored is less than the
   * limit, all data is returned. Otherwise, the number limit of data points is randomly selected
   * from this time series and returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   BatchReadTensorboardTimeSeriesDataRequest request =
   *       BatchReadTensorboardTimeSeriesDataRequest.newBuilder()
   *           .setTensorboard(
   *               TensorboardName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]").toString())
   *           .addAllTimeSeries(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchReadTensorboardTimeSeriesDataResponse> future =
   *       tensorboardServiceClient.batchReadTensorboardTimeSeriesDataCallable().futureCall(request);
   *   // Do something.
   *   BatchReadTensorboardTimeSeriesDataResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          BatchReadTensorboardTimeSeriesDataRequest, BatchReadTensorboardTimeSeriesDataResponse>
      batchReadTensorboardTimeSeriesDataCallable() {
    return stub.batchReadTensorboardTimeSeriesDataCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reads a TensorboardTimeSeries' data. By default, if the number of data points stored is less
   * than 1000, all data is returned. Otherwise, 1000 data points is randomly selected from this
   * time series and returned. This value can be changed by changing max_data_points, which can't be
   * greater than 10k.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   TensorboardTimeSeriesName tensorboardTimeSeries =
   *       TensorboardTimeSeriesName.of(
   *           "[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]", "[RUN]", "[TIME_SERIES]");
   *   ReadTensorboardTimeSeriesDataResponse response =
   *       tensorboardServiceClient.readTensorboardTimeSeriesData(tensorboardTimeSeries);
   * }
   * }</pre>
   *
   * @param tensorboardTimeSeries Required. The resource name of the TensorboardTimeSeries to read
   *     data from. Format:
   *     `projects/{project}/locations/{location}/tensorboards/{tensorboard}/experiments/{experiment}/runs/{run}/timeSeries/{time_series}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReadTensorboardTimeSeriesDataResponse readTensorboardTimeSeriesData(
      TensorboardTimeSeriesName tensorboardTimeSeries) {
    ReadTensorboardTimeSeriesDataRequest request =
        ReadTensorboardTimeSeriesDataRequest.newBuilder()
            .setTensorboardTimeSeries(
                tensorboardTimeSeries == null ? null : tensorboardTimeSeries.toString())
            .build();
    return readTensorboardTimeSeriesData(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reads a TensorboardTimeSeries' data. By default, if the number of data points stored is less
   * than 1000, all data is returned. Otherwise, 1000 data points is randomly selected from this
   * time series and returned. This value can be changed by changing max_data_points, which can't be
   * greater than 10k.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   String tensorboardTimeSeries =
   *       TensorboardTimeSeriesName.of(
   *               "[PROJECT]",
   *               "[LOCATION]",
   *               "[TENSORBOARD]",
   *               "[EXPERIMENT]",
   *               "[RUN]",
   *               "[TIME_SERIES]")
   *           .toString();
   *   ReadTensorboardTimeSeriesDataResponse response =
   *       tensorboardServiceClient.readTensorboardTimeSeriesData(tensorboardTimeSeries);
   * }
   * }</pre>
   *
   * @param tensorboardTimeSeries Required. The resource name of the TensorboardTimeSeries to read
   *     data from. Format:
   *     `projects/{project}/locations/{location}/tensorboards/{tensorboard}/experiments/{experiment}/runs/{run}/timeSeries/{time_series}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReadTensorboardTimeSeriesDataResponse readTensorboardTimeSeriesData(
      String tensorboardTimeSeries) {
    ReadTensorboardTimeSeriesDataRequest request =
        ReadTensorboardTimeSeriesDataRequest.newBuilder()
            .setTensorboardTimeSeries(tensorboardTimeSeries)
            .build();
    return readTensorboardTimeSeriesData(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reads a TensorboardTimeSeries' data. By default, if the number of data points stored is less
   * than 1000, all data is returned. Otherwise, 1000 data points is randomly selected from this
   * time series and returned. This value can be changed by changing max_data_points, which can't be
   * greater than 10k.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   ReadTensorboardTimeSeriesDataRequest request =
   *       ReadTensorboardTimeSeriesDataRequest.newBuilder()
   *           .setTensorboardTimeSeries(
   *               TensorboardTimeSeriesName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[TENSORBOARD]",
   *                       "[EXPERIMENT]",
   *                       "[RUN]",
   *                       "[TIME_SERIES]")
   *                   .toString())
   *           .setMaxDataPoints(724001981)
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ReadTensorboardTimeSeriesDataResponse response =
   *       tensorboardServiceClient.readTensorboardTimeSeriesData(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReadTensorboardTimeSeriesDataResponse readTensorboardTimeSeriesData(
      ReadTensorboardTimeSeriesDataRequest request) {
    return readTensorboardTimeSeriesDataCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reads a TensorboardTimeSeries' data. By default, if the number of data points stored is less
   * than 1000, all data is returned. Otherwise, 1000 data points is randomly selected from this
   * time series and returned. This value can be changed by changing max_data_points, which can't be
   * greater than 10k.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   ReadTensorboardTimeSeriesDataRequest request =
   *       ReadTensorboardTimeSeriesDataRequest.newBuilder()
   *           .setTensorboardTimeSeries(
   *               TensorboardTimeSeriesName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[TENSORBOARD]",
   *                       "[EXPERIMENT]",
   *                       "[RUN]",
   *                       "[TIME_SERIES]")
   *                   .toString())
   *           .setMaxDataPoints(724001981)
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<ReadTensorboardTimeSeriesDataResponse> future =
   *       tensorboardServiceClient.readTensorboardTimeSeriesDataCallable().futureCall(request);
   *   // Do something.
   *   ReadTensorboardTimeSeriesDataResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ReadTensorboardTimeSeriesDataRequest, ReadTensorboardTimeSeriesDataResponse>
      readTensorboardTimeSeriesDataCallable() {
    return stub.readTensorboardTimeSeriesDataCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets bytes of TensorboardBlobs. This is to allow reading blob data stored in consumer project's
   * Cloud Storage bucket without users having to obtain Cloud Storage access permission.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   ReadTensorboardBlobDataRequest request =
   *       ReadTensorboardBlobDataRequest.newBuilder()
   *           .setTimeSeries(
   *               TensorboardTimeSeriesName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[TENSORBOARD]",
   *                       "[EXPERIMENT]",
   *                       "[RUN]",
   *                       "[TIME_SERIES]")
   *                   .toString())
   *           .addAllBlobIds(new ArrayList<String>())
   *           .build();
   *   ServerStream<ReadTensorboardBlobDataResponse> stream =
   *       tensorboardServiceClient.readTensorboardBlobDataCallable().call(request);
   *   for (ReadTensorboardBlobDataResponse response : stream) {
   *     // Do something when a response is received.
   *   }
   * }
   * }</pre>
   */
  public final ServerStreamingCallable<
          ReadTensorboardBlobDataRequest, ReadTensorboardBlobDataResponse>
      readTensorboardBlobDataCallable() {
    return stub.readTensorboardBlobDataCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Write time series data points of multiple TensorboardTimeSeries in multiple TensorboardRun's.
   * If any data fail to be ingested, an error is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   TensorboardExperimentName tensorboardExperiment =
   *       TensorboardExperimentName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]");
   *   List<WriteTensorboardRunDataRequest> writeRunDataRequests = new ArrayList<>();
   *   WriteTensorboardExperimentDataResponse response =
   *       tensorboardServiceClient.writeTensorboardExperimentData(
   *           tensorboardExperiment, writeRunDataRequests);
   * }
   * }</pre>
   *
   * @param tensorboardExperiment Required. The resource name of the TensorboardExperiment to write
   *     data to. Format:
   *     `projects/{project}/locations/{location}/tensorboards/{tensorboard}/experiments/{experiment}`
   * @param writeRunDataRequests Required. Requests containing per-run TensorboardTimeSeries data to
   *     write.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final WriteTensorboardExperimentDataResponse writeTensorboardExperimentData(
      TensorboardExperimentName tensorboardExperiment,
      List<WriteTensorboardRunDataRequest> writeRunDataRequests) {
    WriteTensorboardExperimentDataRequest request =
        WriteTensorboardExperimentDataRequest.newBuilder()
            .setTensorboardExperiment(
                tensorboardExperiment == null ? null : tensorboardExperiment.toString())
            .addAllWriteRunDataRequests(writeRunDataRequests)
            .build();
    return writeTensorboardExperimentData(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Write time series data points of multiple TensorboardTimeSeries in multiple TensorboardRun's.
   * If any data fail to be ingested, an error is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   String tensorboardExperiment =
   *       TensorboardExperimentName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]")
   *           .toString();
   *   List<WriteTensorboardRunDataRequest> writeRunDataRequests = new ArrayList<>();
   *   WriteTensorboardExperimentDataResponse response =
   *       tensorboardServiceClient.writeTensorboardExperimentData(
   *           tensorboardExperiment, writeRunDataRequests);
   * }
   * }</pre>
   *
   * @param tensorboardExperiment Required. The resource name of the TensorboardExperiment to write
   *     data to. Format:
   *     `projects/{project}/locations/{location}/tensorboards/{tensorboard}/experiments/{experiment}`
   * @param writeRunDataRequests Required. Requests containing per-run TensorboardTimeSeries data to
   *     write.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final WriteTensorboardExperimentDataResponse writeTensorboardExperimentData(
      String tensorboardExperiment, List<WriteTensorboardRunDataRequest> writeRunDataRequests) {
    WriteTensorboardExperimentDataRequest request =
        WriteTensorboardExperimentDataRequest.newBuilder()
            .setTensorboardExperiment(tensorboardExperiment)
            .addAllWriteRunDataRequests(writeRunDataRequests)
            .build();
    return writeTensorboardExperimentData(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Write time series data points of multiple TensorboardTimeSeries in multiple TensorboardRun's.
   * If any data fail to be ingested, an error is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   WriteTensorboardExperimentDataRequest request =
   *       WriteTensorboardExperimentDataRequest.newBuilder()
   *           .setTensorboardExperiment(
   *               TensorboardExperimentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]")
   *                   .toString())
   *           .addAllWriteRunDataRequests(new ArrayList<WriteTensorboardRunDataRequest>())
   *           .build();
   *   WriteTensorboardExperimentDataResponse response =
   *       tensorboardServiceClient.writeTensorboardExperimentData(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final WriteTensorboardExperimentDataResponse writeTensorboardExperimentData(
      WriteTensorboardExperimentDataRequest request) {
    return writeTensorboardExperimentDataCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Write time series data points of multiple TensorboardTimeSeries in multiple TensorboardRun's.
   * If any data fail to be ingested, an error is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   WriteTensorboardExperimentDataRequest request =
   *       WriteTensorboardExperimentDataRequest.newBuilder()
   *           .setTensorboardExperiment(
   *               TensorboardExperimentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]")
   *                   .toString())
   *           .addAllWriteRunDataRequests(new ArrayList<WriteTensorboardRunDataRequest>())
   *           .build();
   *   ApiFuture<WriteTensorboardExperimentDataResponse> future =
   *       tensorboardServiceClient.writeTensorboardExperimentDataCallable().futureCall(request);
   *   // Do something.
   *   WriteTensorboardExperimentDataResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          WriteTensorboardExperimentDataRequest, WriteTensorboardExperimentDataResponse>
      writeTensorboardExperimentDataCallable() {
    return stub.writeTensorboardExperimentDataCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Write time series data points into multiple TensorboardTimeSeries under a TensorboardRun. If
   * any data fail to be ingested, an error is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   TensorboardRunName tensorboardRun =
   *       TensorboardRunName.of(
   *           "[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]", "[RUN]");
   *   List<TimeSeriesData> timeSeriesData = new ArrayList<>();
   *   WriteTensorboardRunDataResponse response =
   *       tensorboardServiceClient.writeTensorboardRunData(tensorboardRun, timeSeriesData);
   * }
   * }</pre>
   *
   * @param tensorboardRun Required. The resource name of the TensorboardRun to write data to.
   *     Format:
   *     `projects/{project}/locations/{location}/tensorboards/{tensorboard}/experiments/{experiment}/runs/{run}`
   * @param timeSeriesData Required. The TensorboardTimeSeries data to write. Values with in a time
   *     series are indexed by their step value. Repeated writes to the same step will overwrite the
   *     existing value for that step. The upper limit of data points per write request is 5000.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final WriteTensorboardRunDataResponse writeTensorboardRunData(
      TensorboardRunName tensorboardRun, List<TimeSeriesData> timeSeriesData) {
    WriteTensorboardRunDataRequest request =
        WriteTensorboardRunDataRequest.newBuilder()
            .setTensorboardRun(tensorboardRun == null ? null : tensorboardRun.toString())
            .addAllTimeSeriesData(timeSeriesData)
            .build();
    return writeTensorboardRunData(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Write time series data points into multiple TensorboardTimeSeries under a TensorboardRun. If
   * any data fail to be ingested, an error is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   String tensorboardRun =
   *       TensorboardRunName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]", "[RUN]")
   *           .toString();
   *   List<TimeSeriesData> timeSeriesData = new ArrayList<>();
   *   WriteTensorboardRunDataResponse response =
   *       tensorboardServiceClient.writeTensorboardRunData(tensorboardRun, timeSeriesData);
   * }
   * }</pre>
   *
   * @param tensorboardRun Required. The resource name of the TensorboardRun to write data to.
   *     Format:
   *     `projects/{project}/locations/{location}/tensorboards/{tensorboard}/experiments/{experiment}/runs/{run}`
   * @param timeSeriesData Required. The TensorboardTimeSeries data to write. Values with in a time
   *     series are indexed by their step value. Repeated writes to the same step will overwrite the
   *     existing value for that step. The upper limit of data points per write request is 5000.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final WriteTensorboardRunDataResponse writeTensorboardRunData(
      String tensorboardRun, List<TimeSeriesData> timeSeriesData) {
    WriteTensorboardRunDataRequest request =
        WriteTensorboardRunDataRequest.newBuilder()
            .setTensorboardRun(tensorboardRun)
            .addAllTimeSeriesData(timeSeriesData)
            .build();
    return writeTensorboardRunData(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Write time series data points into multiple TensorboardTimeSeries under a TensorboardRun. If
   * any data fail to be ingested, an error is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   WriteTensorboardRunDataRequest request =
   *       WriteTensorboardRunDataRequest.newBuilder()
   *           .setTensorboardRun(
   *               TensorboardRunName.of(
   *                       "[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]", "[RUN]")
   *                   .toString())
   *           .addAllTimeSeriesData(new ArrayList<TimeSeriesData>())
   *           .build();
   *   WriteTensorboardRunDataResponse response =
   *       tensorboardServiceClient.writeTensorboardRunData(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final WriteTensorboardRunDataResponse writeTensorboardRunData(
      WriteTensorboardRunDataRequest request) {
    return writeTensorboardRunDataCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Write time series data points into multiple TensorboardTimeSeries under a TensorboardRun. If
   * any data fail to be ingested, an error is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   WriteTensorboardRunDataRequest request =
   *       WriteTensorboardRunDataRequest.newBuilder()
   *           .setTensorboardRun(
   *               TensorboardRunName.of(
   *                       "[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]", "[RUN]")
   *                   .toString())
   *           .addAllTimeSeriesData(new ArrayList<TimeSeriesData>())
   *           .build();
   *   ApiFuture<WriteTensorboardRunDataResponse> future =
   *       tensorboardServiceClient.writeTensorboardRunDataCallable().futureCall(request);
   *   // Do something.
   *   WriteTensorboardRunDataResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<WriteTensorboardRunDataRequest, WriteTensorboardRunDataResponse>
      writeTensorboardRunDataCallable() {
    return stub.writeTensorboardRunDataCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports a TensorboardTimeSeries' data. Data is returned in paginated responses.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   TensorboardTimeSeriesName tensorboardTimeSeries =
   *       TensorboardTimeSeriesName.of(
   *           "[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]", "[RUN]", "[TIME_SERIES]");
   *   for (TimeSeriesDataPoint element :
   *       tensorboardServiceClient
   *           .exportTensorboardTimeSeriesData(tensorboardTimeSeries)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param tensorboardTimeSeries Required. The resource name of the TensorboardTimeSeries to export
   *     data from. Format:
   *     `projects/{project}/locations/{location}/tensorboards/{tensorboard}/experiments/{experiment}/runs/{run}/timeSeries/{time_series}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ExportTensorboardTimeSeriesDataPagedResponse exportTensorboardTimeSeriesData(
      TensorboardTimeSeriesName tensorboardTimeSeries) {
    ExportTensorboardTimeSeriesDataRequest request =
        ExportTensorboardTimeSeriesDataRequest.newBuilder()
            .setTensorboardTimeSeries(
                tensorboardTimeSeries == null ? null : tensorboardTimeSeries.toString())
            .build();
    return exportTensorboardTimeSeriesData(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports a TensorboardTimeSeries' data. Data is returned in paginated responses.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   String tensorboardTimeSeries =
   *       TensorboardTimeSeriesName.of(
   *               "[PROJECT]",
   *               "[LOCATION]",
   *               "[TENSORBOARD]",
   *               "[EXPERIMENT]",
   *               "[RUN]",
   *               "[TIME_SERIES]")
   *           .toString();
   *   for (TimeSeriesDataPoint element :
   *       tensorboardServiceClient
   *           .exportTensorboardTimeSeriesData(tensorboardTimeSeries)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param tensorboardTimeSeries Required. The resource name of the TensorboardTimeSeries to export
   *     data from. Format:
   *     `projects/{project}/locations/{location}/tensorboards/{tensorboard}/experiments/{experiment}/runs/{run}/timeSeries/{time_series}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ExportTensorboardTimeSeriesDataPagedResponse exportTensorboardTimeSeriesData(
      String tensorboardTimeSeries) {
    ExportTensorboardTimeSeriesDataRequest request =
        ExportTensorboardTimeSeriesDataRequest.newBuilder()
            .setTensorboardTimeSeries(tensorboardTimeSeries)
            .build();
    return exportTensorboardTimeSeriesData(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports a TensorboardTimeSeries' data. Data is returned in paginated responses.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   ExportTensorboardTimeSeriesDataRequest request =
   *       ExportTensorboardTimeSeriesDataRequest.newBuilder()
   *           .setTensorboardTimeSeries(
   *               TensorboardTimeSeriesName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[TENSORBOARD]",
   *                       "[EXPERIMENT]",
   *                       "[RUN]",
   *                       "[TIME_SERIES]")
   *                   .toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (TimeSeriesDataPoint element :
   *       tensorboardServiceClient.exportTensorboardTimeSeriesData(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ExportTensorboardTimeSeriesDataPagedResponse exportTensorboardTimeSeriesData(
      ExportTensorboardTimeSeriesDataRequest request) {
    return exportTensorboardTimeSeriesDataPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports a TensorboardTimeSeries' data. Data is returned in paginated responses.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   ExportTensorboardTimeSeriesDataRequest request =
   *       ExportTensorboardTimeSeriesDataRequest.newBuilder()
   *           .setTensorboardTimeSeries(
   *               TensorboardTimeSeriesName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[TENSORBOARD]",
   *                       "[EXPERIMENT]",
   *                       "[RUN]",
   *                       "[TIME_SERIES]")
   *                   .toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<TimeSeriesDataPoint> future =
   *       tensorboardServiceClient
   *           .exportTensorboardTimeSeriesDataPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (TimeSeriesDataPoint element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ExportTensorboardTimeSeriesDataRequest, ExportTensorboardTimeSeriesDataPagedResponse>
      exportTensorboardTimeSeriesDataPagedCallable() {
    return stub.exportTensorboardTimeSeriesDataPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports a TensorboardTimeSeries' data. Data is returned in paginated responses.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   ExportTensorboardTimeSeriesDataRequest request =
   *       ExportTensorboardTimeSeriesDataRequest.newBuilder()
   *           .setTensorboardTimeSeries(
   *               TensorboardTimeSeriesName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[TENSORBOARD]",
   *                       "[EXPERIMENT]",
   *                       "[RUN]",
   *                       "[TIME_SERIES]")
   *                   .toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ExportTensorboardTimeSeriesDataResponse response =
   *         tensorboardServiceClient.exportTensorboardTimeSeriesDataCallable().call(request);
   *     for (TimeSeriesDataPoint element : response.getTimeSeriesDataPointsList()) {
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
          ExportTensorboardTimeSeriesDataRequest, ExportTensorboardTimeSeriesDataResponse>
      exportTensorboardTimeSeriesDataCallable() {
    return stub.exportTensorboardTimeSeriesDataCallable();
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
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : tensorboardServiceClient.listLocations(request).iterateAll()) {
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
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       tensorboardServiceClient.listLocationsPagedCallable().futureCall(request);
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
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         tensorboardServiceClient.listLocationsCallable().call(request);
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
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = tensorboardServiceClient.getLocation(request);
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
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future =
   *       tensorboardServiceClient.getLocationCallable().futureCall(request);
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
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = tensorboardServiceClient.setIamPolicy(request);
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
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       tensorboardServiceClient.setIamPolicyCallable().futureCall(request);
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
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = tensorboardServiceClient.getIamPolicy(request);
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
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       tensorboardServiceClient.getIamPolicyCallable().futureCall(request);
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
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = tensorboardServiceClient.testIamPermissions(request);
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
   * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       tensorboardServiceClient.testIamPermissionsCallable().futureCall(request);
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

  public static class ListTensorboardsPagedResponse
      extends AbstractPagedListResponse<
          ListTensorboardsRequest,
          ListTensorboardsResponse,
          Tensorboard,
          ListTensorboardsPage,
          ListTensorboardsFixedSizeCollection> {

    public static ApiFuture<ListTensorboardsPagedResponse> createAsync(
        PageContext<ListTensorboardsRequest, ListTensorboardsResponse, Tensorboard> context,
        ApiFuture<ListTensorboardsResponse> futureResponse) {
      ApiFuture<ListTensorboardsPage> futurePage =
          ListTensorboardsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListTensorboardsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListTensorboardsPagedResponse(ListTensorboardsPage page) {
      super(page, ListTensorboardsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListTensorboardsPage
      extends AbstractPage<
          ListTensorboardsRequest, ListTensorboardsResponse, Tensorboard, ListTensorboardsPage> {

    private ListTensorboardsPage(
        PageContext<ListTensorboardsRequest, ListTensorboardsResponse, Tensorboard> context,
        ListTensorboardsResponse response) {
      super(context, response);
    }

    private static ListTensorboardsPage createEmptyPage() {
      return new ListTensorboardsPage(null, null);
    }

    @Override
    protected ListTensorboardsPage createPage(
        PageContext<ListTensorboardsRequest, ListTensorboardsResponse, Tensorboard> context,
        ListTensorboardsResponse response) {
      return new ListTensorboardsPage(context, response);
    }

    @Override
    public ApiFuture<ListTensorboardsPage> createPageAsync(
        PageContext<ListTensorboardsRequest, ListTensorboardsResponse, Tensorboard> context,
        ApiFuture<ListTensorboardsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListTensorboardsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTensorboardsRequest,
          ListTensorboardsResponse,
          Tensorboard,
          ListTensorboardsPage,
          ListTensorboardsFixedSizeCollection> {

    private ListTensorboardsFixedSizeCollection(
        List<ListTensorboardsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTensorboardsFixedSizeCollection createEmptyCollection() {
      return new ListTensorboardsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTensorboardsFixedSizeCollection createCollection(
        List<ListTensorboardsPage> pages, int collectionSize) {
      return new ListTensorboardsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListTensorboardExperimentsPagedResponse
      extends AbstractPagedListResponse<
          ListTensorboardExperimentsRequest,
          ListTensorboardExperimentsResponse,
          TensorboardExperiment,
          ListTensorboardExperimentsPage,
          ListTensorboardExperimentsFixedSizeCollection> {

    public static ApiFuture<ListTensorboardExperimentsPagedResponse> createAsync(
        PageContext<
                ListTensorboardExperimentsRequest,
                ListTensorboardExperimentsResponse,
                TensorboardExperiment>
            context,
        ApiFuture<ListTensorboardExperimentsResponse> futureResponse) {
      ApiFuture<ListTensorboardExperimentsPage> futurePage =
          ListTensorboardExperimentsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListTensorboardExperimentsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListTensorboardExperimentsPagedResponse(ListTensorboardExperimentsPage page) {
      super(page, ListTensorboardExperimentsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListTensorboardExperimentsPage
      extends AbstractPage<
          ListTensorboardExperimentsRequest,
          ListTensorboardExperimentsResponse,
          TensorboardExperiment,
          ListTensorboardExperimentsPage> {

    private ListTensorboardExperimentsPage(
        PageContext<
                ListTensorboardExperimentsRequest,
                ListTensorboardExperimentsResponse,
                TensorboardExperiment>
            context,
        ListTensorboardExperimentsResponse response) {
      super(context, response);
    }

    private static ListTensorboardExperimentsPage createEmptyPage() {
      return new ListTensorboardExperimentsPage(null, null);
    }

    @Override
    protected ListTensorboardExperimentsPage createPage(
        PageContext<
                ListTensorboardExperimentsRequest,
                ListTensorboardExperimentsResponse,
                TensorboardExperiment>
            context,
        ListTensorboardExperimentsResponse response) {
      return new ListTensorboardExperimentsPage(context, response);
    }

    @Override
    public ApiFuture<ListTensorboardExperimentsPage> createPageAsync(
        PageContext<
                ListTensorboardExperimentsRequest,
                ListTensorboardExperimentsResponse,
                TensorboardExperiment>
            context,
        ApiFuture<ListTensorboardExperimentsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListTensorboardExperimentsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTensorboardExperimentsRequest,
          ListTensorboardExperimentsResponse,
          TensorboardExperiment,
          ListTensorboardExperimentsPage,
          ListTensorboardExperimentsFixedSizeCollection> {

    private ListTensorboardExperimentsFixedSizeCollection(
        List<ListTensorboardExperimentsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTensorboardExperimentsFixedSizeCollection createEmptyCollection() {
      return new ListTensorboardExperimentsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTensorboardExperimentsFixedSizeCollection createCollection(
        List<ListTensorboardExperimentsPage> pages, int collectionSize) {
      return new ListTensorboardExperimentsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListTensorboardRunsPagedResponse
      extends AbstractPagedListResponse<
          ListTensorboardRunsRequest,
          ListTensorboardRunsResponse,
          TensorboardRun,
          ListTensorboardRunsPage,
          ListTensorboardRunsFixedSizeCollection> {

    public static ApiFuture<ListTensorboardRunsPagedResponse> createAsync(
        PageContext<ListTensorboardRunsRequest, ListTensorboardRunsResponse, TensorboardRun>
            context,
        ApiFuture<ListTensorboardRunsResponse> futureResponse) {
      ApiFuture<ListTensorboardRunsPage> futurePage =
          ListTensorboardRunsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListTensorboardRunsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListTensorboardRunsPagedResponse(ListTensorboardRunsPage page) {
      super(page, ListTensorboardRunsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListTensorboardRunsPage
      extends AbstractPage<
          ListTensorboardRunsRequest,
          ListTensorboardRunsResponse,
          TensorboardRun,
          ListTensorboardRunsPage> {

    private ListTensorboardRunsPage(
        PageContext<ListTensorboardRunsRequest, ListTensorboardRunsResponse, TensorboardRun>
            context,
        ListTensorboardRunsResponse response) {
      super(context, response);
    }

    private static ListTensorboardRunsPage createEmptyPage() {
      return new ListTensorboardRunsPage(null, null);
    }

    @Override
    protected ListTensorboardRunsPage createPage(
        PageContext<ListTensorboardRunsRequest, ListTensorboardRunsResponse, TensorboardRun>
            context,
        ListTensorboardRunsResponse response) {
      return new ListTensorboardRunsPage(context, response);
    }

    @Override
    public ApiFuture<ListTensorboardRunsPage> createPageAsync(
        PageContext<ListTensorboardRunsRequest, ListTensorboardRunsResponse, TensorboardRun>
            context,
        ApiFuture<ListTensorboardRunsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListTensorboardRunsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTensorboardRunsRequest,
          ListTensorboardRunsResponse,
          TensorboardRun,
          ListTensorboardRunsPage,
          ListTensorboardRunsFixedSizeCollection> {

    private ListTensorboardRunsFixedSizeCollection(
        List<ListTensorboardRunsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTensorboardRunsFixedSizeCollection createEmptyCollection() {
      return new ListTensorboardRunsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTensorboardRunsFixedSizeCollection createCollection(
        List<ListTensorboardRunsPage> pages, int collectionSize) {
      return new ListTensorboardRunsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListTensorboardTimeSeriesPagedResponse
      extends AbstractPagedListResponse<
          ListTensorboardTimeSeriesRequest,
          ListTensorboardTimeSeriesResponse,
          TensorboardTimeSeries,
          ListTensorboardTimeSeriesPage,
          ListTensorboardTimeSeriesFixedSizeCollection> {

    public static ApiFuture<ListTensorboardTimeSeriesPagedResponse> createAsync(
        PageContext<
                ListTensorboardTimeSeriesRequest,
                ListTensorboardTimeSeriesResponse,
                TensorboardTimeSeries>
            context,
        ApiFuture<ListTensorboardTimeSeriesResponse> futureResponse) {
      ApiFuture<ListTensorboardTimeSeriesPage> futurePage =
          ListTensorboardTimeSeriesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListTensorboardTimeSeriesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListTensorboardTimeSeriesPagedResponse(ListTensorboardTimeSeriesPage page) {
      super(page, ListTensorboardTimeSeriesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListTensorboardTimeSeriesPage
      extends AbstractPage<
          ListTensorboardTimeSeriesRequest,
          ListTensorboardTimeSeriesResponse,
          TensorboardTimeSeries,
          ListTensorboardTimeSeriesPage> {

    private ListTensorboardTimeSeriesPage(
        PageContext<
                ListTensorboardTimeSeriesRequest,
                ListTensorboardTimeSeriesResponse,
                TensorboardTimeSeries>
            context,
        ListTensorboardTimeSeriesResponse response) {
      super(context, response);
    }

    private static ListTensorboardTimeSeriesPage createEmptyPage() {
      return new ListTensorboardTimeSeriesPage(null, null);
    }

    @Override
    protected ListTensorboardTimeSeriesPage createPage(
        PageContext<
                ListTensorboardTimeSeriesRequest,
                ListTensorboardTimeSeriesResponse,
                TensorboardTimeSeries>
            context,
        ListTensorboardTimeSeriesResponse response) {
      return new ListTensorboardTimeSeriesPage(context, response);
    }

    @Override
    public ApiFuture<ListTensorboardTimeSeriesPage> createPageAsync(
        PageContext<
                ListTensorboardTimeSeriesRequest,
                ListTensorboardTimeSeriesResponse,
                TensorboardTimeSeries>
            context,
        ApiFuture<ListTensorboardTimeSeriesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListTensorboardTimeSeriesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTensorboardTimeSeriesRequest,
          ListTensorboardTimeSeriesResponse,
          TensorboardTimeSeries,
          ListTensorboardTimeSeriesPage,
          ListTensorboardTimeSeriesFixedSizeCollection> {

    private ListTensorboardTimeSeriesFixedSizeCollection(
        List<ListTensorboardTimeSeriesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTensorboardTimeSeriesFixedSizeCollection createEmptyCollection() {
      return new ListTensorboardTimeSeriesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTensorboardTimeSeriesFixedSizeCollection createCollection(
        List<ListTensorboardTimeSeriesPage> pages, int collectionSize) {
      return new ListTensorboardTimeSeriesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ExportTensorboardTimeSeriesDataPagedResponse
      extends AbstractPagedListResponse<
          ExportTensorboardTimeSeriesDataRequest,
          ExportTensorboardTimeSeriesDataResponse,
          TimeSeriesDataPoint,
          ExportTensorboardTimeSeriesDataPage,
          ExportTensorboardTimeSeriesDataFixedSizeCollection> {

    public static ApiFuture<ExportTensorboardTimeSeriesDataPagedResponse> createAsync(
        PageContext<
                ExportTensorboardTimeSeriesDataRequest,
                ExportTensorboardTimeSeriesDataResponse,
                TimeSeriesDataPoint>
            context,
        ApiFuture<ExportTensorboardTimeSeriesDataResponse> futureResponse) {
      ApiFuture<ExportTensorboardTimeSeriesDataPage> futurePage =
          ExportTensorboardTimeSeriesDataPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ExportTensorboardTimeSeriesDataPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ExportTensorboardTimeSeriesDataPagedResponse(ExportTensorboardTimeSeriesDataPage page) {
      super(page, ExportTensorboardTimeSeriesDataFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ExportTensorboardTimeSeriesDataPage
      extends AbstractPage<
          ExportTensorboardTimeSeriesDataRequest,
          ExportTensorboardTimeSeriesDataResponse,
          TimeSeriesDataPoint,
          ExportTensorboardTimeSeriesDataPage> {

    private ExportTensorboardTimeSeriesDataPage(
        PageContext<
                ExportTensorboardTimeSeriesDataRequest,
                ExportTensorboardTimeSeriesDataResponse,
                TimeSeriesDataPoint>
            context,
        ExportTensorboardTimeSeriesDataResponse response) {
      super(context, response);
    }

    private static ExportTensorboardTimeSeriesDataPage createEmptyPage() {
      return new ExportTensorboardTimeSeriesDataPage(null, null);
    }

    @Override
    protected ExportTensorboardTimeSeriesDataPage createPage(
        PageContext<
                ExportTensorboardTimeSeriesDataRequest,
                ExportTensorboardTimeSeriesDataResponse,
                TimeSeriesDataPoint>
            context,
        ExportTensorboardTimeSeriesDataResponse response) {
      return new ExportTensorboardTimeSeriesDataPage(context, response);
    }

    @Override
    public ApiFuture<ExportTensorboardTimeSeriesDataPage> createPageAsync(
        PageContext<
                ExportTensorboardTimeSeriesDataRequest,
                ExportTensorboardTimeSeriesDataResponse,
                TimeSeriesDataPoint>
            context,
        ApiFuture<ExportTensorboardTimeSeriesDataResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ExportTensorboardTimeSeriesDataFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ExportTensorboardTimeSeriesDataRequest,
          ExportTensorboardTimeSeriesDataResponse,
          TimeSeriesDataPoint,
          ExportTensorboardTimeSeriesDataPage,
          ExportTensorboardTimeSeriesDataFixedSizeCollection> {

    private ExportTensorboardTimeSeriesDataFixedSizeCollection(
        List<ExportTensorboardTimeSeriesDataPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ExportTensorboardTimeSeriesDataFixedSizeCollection createEmptyCollection() {
      return new ExportTensorboardTimeSeriesDataFixedSizeCollection(null, 0);
    }

    @Override
    protected ExportTensorboardTimeSeriesDataFixedSizeCollection createCollection(
        List<ExportTensorboardTimeSeriesDataPage> pages, int collectionSize) {
      return new ExportTensorboardTimeSeriesDataFixedSizeCollection(pages, collectionSize);
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
