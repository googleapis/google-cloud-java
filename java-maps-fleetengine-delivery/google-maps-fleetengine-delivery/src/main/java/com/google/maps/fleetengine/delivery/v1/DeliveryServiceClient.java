/*
 * Copyright 2023 Google LLC
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

package com.google.maps.fleetengine.delivery.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.FieldMask;
import google.maps.fleetengine.delivery.v1.stub.DeliveryServiceStub;
import google.maps.fleetengine.delivery.v1.stub.DeliveryServiceStubSettings;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The Last Mile Delivery service.
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
 * try (DeliveryServiceClient deliveryServiceClient = DeliveryServiceClient.create()) {
 *   String parent = "parent-995424086";
 *   DeliveryVehicle deliveryVehicle = DeliveryVehicle.newBuilder().build();
 *   String deliveryVehicleId = "deliveryVehicleId-861424685";
 *   DeliveryVehicle response =
 *       deliveryServiceClient.createDeliveryVehicle(parent, deliveryVehicle, deliveryVehicleId);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the DeliveryServiceClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of DeliveryServiceSettings to
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
 * DeliveryServiceSettings deliveryServiceSettings =
 *     DeliveryServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DeliveryServiceClient deliveryServiceClient =
 *     DeliveryServiceClient.create(deliveryServiceSettings);
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
 * DeliveryServiceSettings deliveryServiceSettings =
 *     DeliveryServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DeliveryServiceClient deliveryServiceClient =
 *     DeliveryServiceClient.create(deliveryServiceSettings);
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
 * DeliveryServiceSettings deliveryServiceSettings =
 *     DeliveryServiceSettings.newHttpJsonBuilder().build();
 * DeliveryServiceClient deliveryServiceClient =
 *     DeliveryServiceClient.create(deliveryServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class DeliveryServiceClient implements BackgroundResource {
  private final DeliveryServiceSettings settings;
  private final DeliveryServiceStub stub;

  /** Constructs an instance of DeliveryServiceClient with default settings. */
  public static final DeliveryServiceClient create() throws IOException {
    return create(DeliveryServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of DeliveryServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final DeliveryServiceClient create(DeliveryServiceSettings settings)
      throws IOException {
    return new DeliveryServiceClient(settings);
  }

  /**
   * Constructs an instance of DeliveryServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(DeliveryServiceSettings).
   */
  public static final DeliveryServiceClient create(DeliveryServiceStub stub) {
    return new DeliveryServiceClient(stub);
  }

  /**
   * Constructs an instance of DeliveryServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected DeliveryServiceClient(DeliveryServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((DeliveryServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected DeliveryServiceClient(DeliveryServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final DeliveryServiceSettings getSettings() {
    return settings;
  }

  public DeliveryServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates and returns a new `DeliveryVehicle`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeliveryServiceClient deliveryServiceClient = DeliveryServiceClient.create()) {
   *   String parent = "parent-995424086";
   *   DeliveryVehicle deliveryVehicle = DeliveryVehicle.newBuilder().build();
   *   String deliveryVehicleId = "deliveryVehicleId-861424685";
   *   DeliveryVehicle response =
   *       deliveryServiceClient.createDeliveryVehicle(parent, deliveryVehicle, deliveryVehicleId);
   * }
   * }</pre>
   *
   * @param parent Required. Must be in the format `providers/{provider}`. The provider must be the
   *     Google Cloud Project ID. For example, `sample-cloud-project`.
   * @param deliveryVehicle Required. The `DeliveryVehicle` entity to create. When creating a new
   *     delivery vehicle, you may set the following optional fields:
   *     <ul>
   *       <li>last_location
   *       <li>attributes
   *     </ul>
   *     <p>Note: The DeliveryVehicle's `name` field is ignored. All other DeliveryVehicle fields
   *     must not be set; otherwise, an error is returned.
   * @param deliveryVehicleId Required. The Delivery Vehicle ID must be unique and subject to the
   *     following restrictions:
   *     <ul>
   *       <li>Must be a valid Unicode string.
   *       <li>Limited to a maximum length of 64 characters.
   *       <li>Normalized according to [Unicode Normalization Form C]
   *           (http://www.unicode.org/reports/tr15/).
   *       <li>May not contain any of the following ASCII characters: '/', ':', '?', ',', or '#'.
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeliveryVehicle createDeliveryVehicle(
      String parent, DeliveryVehicle deliveryVehicle, String deliveryVehicleId) {
    CreateDeliveryVehicleRequest request =
        CreateDeliveryVehicleRequest.newBuilder()
            .setParent(parent)
            .setDeliveryVehicle(deliveryVehicle)
            .setDeliveryVehicleId(deliveryVehicleId)
            .build();
    return createDeliveryVehicle(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates and returns a new `DeliveryVehicle`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeliveryServiceClient deliveryServiceClient = DeliveryServiceClient.create()) {
   *   CreateDeliveryVehicleRequest request =
   *       CreateDeliveryVehicleRequest.newBuilder()
   *           .setHeader(DeliveryRequestHeader.newBuilder().build())
   *           .setParent("parent-995424086")
   *           .setDeliveryVehicleId("deliveryVehicleId-861424685")
   *           .setDeliveryVehicle(DeliveryVehicle.newBuilder().build())
   *           .build();
   *   DeliveryVehicle response = deliveryServiceClient.createDeliveryVehicle(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeliveryVehicle createDeliveryVehicle(CreateDeliveryVehicleRequest request) {
    return createDeliveryVehicleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates and returns a new `DeliveryVehicle`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeliveryServiceClient deliveryServiceClient = DeliveryServiceClient.create()) {
   *   CreateDeliveryVehicleRequest request =
   *       CreateDeliveryVehicleRequest.newBuilder()
   *           .setHeader(DeliveryRequestHeader.newBuilder().build())
   *           .setParent("parent-995424086")
   *           .setDeliveryVehicleId("deliveryVehicleId-861424685")
   *           .setDeliveryVehicle(DeliveryVehicle.newBuilder().build())
   *           .build();
   *   ApiFuture<DeliveryVehicle> future =
   *       deliveryServiceClient.createDeliveryVehicleCallable().futureCall(request);
   *   // Do something.
   *   DeliveryVehicle response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateDeliveryVehicleRequest, DeliveryVehicle>
      createDeliveryVehicleCallable() {
    return stub.createDeliveryVehicleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified `DeliveryVehicle` instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeliveryServiceClient deliveryServiceClient = DeliveryServiceClient.create()) {
   *   DeliveryVehicleName name = DeliveryVehicleName.of("[PROVIDER]", "[VEHICLE]");
   *   DeliveryVehicle response = deliveryServiceClient.getDeliveryVehicle(name);
   * }
   * }</pre>
   *
   * @param name Required. Must be in the format
   *     `providers/{provider}/deliveryVehicles/{delivery_vehicle}`. The `provider` must be the
   *     Google Cloud Project ID. For example, `sample-cloud-project`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeliveryVehicle getDeliveryVehicle(DeliveryVehicleName name) {
    GetDeliveryVehicleRequest request =
        GetDeliveryVehicleRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getDeliveryVehicle(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified `DeliveryVehicle` instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeliveryServiceClient deliveryServiceClient = DeliveryServiceClient.create()) {
   *   String name = DeliveryVehicleName.of("[PROVIDER]", "[VEHICLE]").toString();
   *   DeliveryVehicle response = deliveryServiceClient.getDeliveryVehicle(name);
   * }
   * }</pre>
   *
   * @param name Required. Must be in the format
   *     `providers/{provider}/deliveryVehicles/{delivery_vehicle}`. The `provider` must be the
   *     Google Cloud Project ID. For example, `sample-cloud-project`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeliveryVehicle getDeliveryVehicle(String name) {
    GetDeliveryVehicleRequest request =
        GetDeliveryVehicleRequest.newBuilder().setName(name).build();
    return getDeliveryVehicle(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified `DeliveryVehicle` instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeliveryServiceClient deliveryServiceClient = DeliveryServiceClient.create()) {
   *   GetDeliveryVehicleRequest request =
   *       GetDeliveryVehicleRequest.newBuilder()
   *           .setHeader(DeliveryRequestHeader.newBuilder().build())
   *           .setName(DeliveryVehicleName.of("[PROVIDER]", "[VEHICLE]").toString())
   *           .build();
   *   DeliveryVehicle response = deliveryServiceClient.getDeliveryVehicle(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeliveryVehicle getDeliveryVehicle(GetDeliveryVehicleRequest request) {
    return getDeliveryVehicleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified `DeliveryVehicle` instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeliveryServiceClient deliveryServiceClient = DeliveryServiceClient.create()) {
   *   GetDeliveryVehicleRequest request =
   *       GetDeliveryVehicleRequest.newBuilder()
   *           .setHeader(DeliveryRequestHeader.newBuilder().build())
   *           .setName(DeliveryVehicleName.of("[PROVIDER]", "[VEHICLE]").toString())
   *           .build();
   *   ApiFuture<DeliveryVehicle> future =
   *       deliveryServiceClient.getDeliveryVehicleCallable().futureCall(request);
   *   // Do something.
   *   DeliveryVehicle response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDeliveryVehicleRequest, DeliveryVehicle>
      getDeliveryVehicleCallable() {
    return stub.getDeliveryVehicleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Writes updated `DeliveryVehicle` data to Fleet Engine, and assigns `Tasks` to the
   * `DeliveryVehicle`. You cannot update the name of the `DeliveryVehicle`. You &#42;can&#42;
   * update `remaining_vehicle_journey_segments` though, but it must contain all of the
   * `VehicleJourneySegment`s currently on the `DeliveryVehicle`. The `task_id`s are retrieved from
   * `remaining_vehicle_journey_segments`, and their corresponding `Tasks` are assigned to the
   * `DeliveryVehicle` if they have not yet been assigned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeliveryServiceClient deliveryServiceClient = DeliveryServiceClient.create()) {
   *   DeliveryVehicle deliveryVehicle = DeliveryVehicle.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   DeliveryVehicle response =
   *       deliveryServiceClient.updateDeliveryVehicle(deliveryVehicle, updateMask);
   * }
   * }</pre>
   *
   * @param deliveryVehicle Required. The `DeliveryVehicle` entity update to apply. Note: You cannot
   *     update the name of the `DeliveryVehicle`.
   * @param updateMask Required. A field mask that indicates which `DeliveryVehicle` fields to
   *     update. Note that the update_mask must contain at least one field.
   *     <p>This is a comma-separated list of fully qualified names of fields. Example:
   *     `"remaining_vehicle_journey_segments"`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeliveryVehicle updateDeliveryVehicle(
      DeliveryVehicle deliveryVehicle, FieldMask updateMask) {
    UpdateDeliveryVehicleRequest request =
        UpdateDeliveryVehicleRequest.newBuilder()
            .setDeliveryVehicle(deliveryVehicle)
            .setUpdateMask(updateMask)
            .build();
    return updateDeliveryVehicle(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Writes updated `DeliveryVehicle` data to Fleet Engine, and assigns `Tasks` to the
   * `DeliveryVehicle`. You cannot update the name of the `DeliveryVehicle`. You &#42;can&#42;
   * update `remaining_vehicle_journey_segments` though, but it must contain all of the
   * `VehicleJourneySegment`s currently on the `DeliveryVehicle`. The `task_id`s are retrieved from
   * `remaining_vehicle_journey_segments`, and their corresponding `Tasks` are assigned to the
   * `DeliveryVehicle` if they have not yet been assigned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeliveryServiceClient deliveryServiceClient = DeliveryServiceClient.create()) {
   *   UpdateDeliveryVehicleRequest request =
   *       UpdateDeliveryVehicleRequest.newBuilder()
   *           .setHeader(DeliveryRequestHeader.newBuilder().build())
   *           .setDeliveryVehicle(DeliveryVehicle.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   DeliveryVehicle response = deliveryServiceClient.updateDeliveryVehicle(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeliveryVehicle updateDeliveryVehicle(UpdateDeliveryVehicleRequest request) {
    return updateDeliveryVehicleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Writes updated `DeliveryVehicle` data to Fleet Engine, and assigns `Tasks` to the
   * `DeliveryVehicle`. You cannot update the name of the `DeliveryVehicle`. You &#42;can&#42;
   * update `remaining_vehicle_journey_segments` though, but it must contain all of the
   * `VehicleJourneySegment`s currently on the `DeliveryVehicle`. The `task_id`s are retrieved from
   * `remaining_vehicle_journey_segments`, and their corresponding `Tasks` are assigned to the
   * `DeliveryVehicle` if they have not yet been assigned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeliveryServiceClient deliveryServiceClient = DeliveryServiceClient.create()) {
   *   UpdateDeliveryVehicleRequest request =
   *       UpdateDeliveryVehicleRequest.newBuilder()
   *           .setHeader(DeliveryRequestHeader.newBuilder().build())
   *           .setDeliveryVehicle(DeliveryVehicle.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<DeliveryVehicle> future =
   *       deliveryServiceClient.updateDeliveryVehicleCallable().futureCall(request);
   *   // Do something.
   *   DeliveryVehicle response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateDeliveryVehicleRequest, DeliveryVehicle>
      updateDeliveryVehicleCallable() {
    return stub.updateDeliveryVehicleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates and returns a batch of new `Task` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeliveryServiceClient deliveryServiceClient = DeliveryServiceClient.create()) {
   *   BatchCreateTasksRequest request =
   *       BatchCreateTasksRequest.newBuilder()
   *           .setHeader(DeliveryRequestHeader.newBuilder().build())
   *           .setParent(ProviderName.of("[PROVIDER]").toString())
   *           .addAllRequests(new ArrayList<CreateTaskRequest>())
   *           .build();
   *   BatchCreateTasksResponse response = deliveryServiceClient.batchCreateTasks(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateTasksResponse batchCreateTasks(BatchCreateTasksRequest request) {
    return batchCreateTasksCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates and returns a batch of new `Task` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeliveryServiceClient deliveryServiceClient = DeliveryServiceClient.create()) {
   *   BatchCreateTasksRequest request =
   *       BatchCreateTasksRequest.newBuilder()
   *           .setHeader(DeliveryRequestHeader.newBuilder().build())
   *           .setParent(ProviderName.of("[PROVIDER]").toString())
   *           .addAllRequests(new ArrayList<CreateTaskRequest>())
   *           .build();
   *   ApiFuture<BatchCreateTasksResponse> future =
   *       deliveryServiceClient.batchCreateTasksCallable().futureCall(request);
   *   // Do something.
   *   BatchCreateTasksResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchCreateTasksRequest, BatchCreateTasksResponse>
      batchCreateTasksCallable() {
    return stub.batchCreateTasksCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates and returns a new `Task` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeliveryServiceClient deliveryServiceClient = DeliveryServiceClient.create()) {
   *   String parent = "parent-995424086";
   *   Task task = Task.newBuilder().build();
   *   String taskId = "taskId-880873088";
   *   Task response = deliveryServiceClient.createTask(parent, task, taskId);
   * }
   * }</pre>
   *
   * @param parent Required. Must be in the format `providers/{provider}`. The `provider` must be
   *     the Google Cloud Project ID. For example, `sample-cloud-project`.
   * @param task Required. The Task entity to create. When creating a Task, the following fields are
   *     required:
   *     <ul>
   *       <li>`type`
   *       <li>`state` (must be set to `OPEN`)
   *       <li>`tracking_id` (must not be set for `UNAVAILABLE` or `SCHEDULED_STOP` tasks, but
   *           required for all other task types)
   *       <li>`planned_location` (optional for `UNAVAILABLE` tasks)
   *       <li>`task_duration`
   *     </ul>
   *     <p>Note: The Task's `name` field is ignored. All other Task fields must not be set;
   *     otherwise, an error is returned.
   * @param taskId Required. The Task ID must be unique, but it should be not a shipment tracking
   *     ID. To store a shipment tracking ID, use the `tracking_id` field. Note that multiple tasks
   *     can have the same `tracking_id`. Task IDs are subject to the following restrictions:
   *     <ul>
   *       <li>Must be a valid Unicode string.
   *       <li>Limited to a maximum length of 64 characters.
   *       <li>Normalized according to [Unicode Normalization Form C]
   *           (http://www.unicode.org/reports/tr15/).
   *       <li>May not contain any of the following ASCII characters: '/', ':', '?', ',', or '#'.
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Task createTask(String parent, Task task, String taskId) {
    CreateTaskRequest request =
        CreateTaskRequest.newBuilder().setParent(parent).setTask(task).setTaskId(taskId).build();
    return createTask(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates and returns a new `Task` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeliveryServiceClient deliveryServiceClient = DeliveryServiceClient.create()) {
   *   CreateTaskRequest request =
   *       CreateTaskRequest.newBuilder()
   *           .setHeader(DeliveryRequestHeader.newBuilder().build())
   *           .setParent("parent-995424086")
   *           .setTaskId("taskId-880873088")
   *           .setTask(Task.newBuilder().build())
   *           .build();
   *   Task response = deliveryServiceClient.createTask(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Task createTask(CreateTaskRequest request) {
    return createTaskCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates and returns a new `Task` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeliveryServiceClient deliveryServiceClient = DeliveryServiceClient.create()) {
   *   CreateTaskRequest request =
   *       CreateTaskRequest.newBuilder()
   *           .setHeader(DeliveryRequestHeader.newBuilder().build())
   *           .setParent("parent-995424086")
   *           .setTaskId("taskId-880873088")
   *           .setTask(Task.newBuilder().build())
   *           .build();
   *   ApiFuture<Task> future = deliveryServiceClient.createTaskCallable().futureCall(request);
   *   // Do something.
   *   Task response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateTaskRequest, Task> createTaskCallable() {
    return stub.createTaskCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a `Task`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeliveryServiceClient deliveryServiceClient = DeliveryServiceClient.create()) {
   *   TaskName name = TaskName.of("[PROVIDER]", "[TASK]");
   *   Task response = deliveryServiceClient.getTask(name);
   * }
   * }</pre>
   *
   * @param name Required. Must be in the format `providers/{provider}/tasks/{task}`. The `provider`
   *     must be the Google Cloud Project ID. For example, `sample-cloud-project`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Task getTask(TaskName name) {
    GetTaskRequest request =
        GetTaskRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getTask(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a `Task`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeliveryServiceClient deliveryServiceClient = DeliveryServiceClient.create()) {
   *   String name = TaskName.of("[PROVIDER]", "[TASK]").toString();
   *   Task response = deliveryServiceClient.getTask(name);
   * }
   * }</pre>
   *
   * @param name Required. Must be in the format `providers/{provider}/tasks/{task}`. The `provider`
   *     must be the Google Cloud Project ID. For example, `sample-cloud-project`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Task getTask(String name) {
    GetTaskRequest request = GetTaskRequest.newBuilder().setName(name).build();
    return getTask(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a `Task`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeliveryServiceClient deliveryServiceClient = DeliveryServiceClient.create()) {
   *   GetTaskRequest request =
   *       GetTaskRequest.newBuilder()
   *           .setHeader(DeliveryRequestHeader.newBuilder().build())
   *           .setName(TaskName.of("[PROVIDER]", "[TASK]").toString())
   *           .build();
   *   Task response = deliveryServiceClient.getTask(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Task getTask(GetTaskRequest request) {
    return getTaskCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a `Task`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeliveryServiceClient deliveryServiceClient = DeliveryServiceClient.create()) {
   *   GetTaskRequest request =
   *       GetTaskRequest.newBuilder()
   *           .setHeader(DeliveryRequestHeader.newBuilder().build())
   *           .setName(TaskName.of("[PROVIDER]", "[TASK]").toString())
   *           .build();
   *   ApiFuture<Task> future = deliveryServiceClient.getTaskCallable().futureCall(request);
   *   // Do something.
   *   Task response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetTaskRequest, Task> getTaskCallable() {
    return stub.getTaskCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deprecated: Use `GetTaskTrackingInfo` instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeliveryServiceClient deliveryServiceClient = DeliveryServiceClient.create()) {
   *   String parent = "parent-995424086";
   *   for (Task element : deliveryServiceClient.searchTasks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Must be in the format `providers/{provider}`. The provider must be the
   *     Google Cloud Project ID. For example, `sample-cloud-project`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final SearchTasksPagedResponse searchTasks(String parent) {
    SearchTasksRequest request = SearchTasksRequest.newBuilder().setParent(parent).build();
    return searchTasks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deprecated: Use `GetTaskTrackingInfo` instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeliveryServiceClient deliveryServiceClient = DeliveryServiceClient.create()) {
   *   SearchTasksRequest request =
   *       SearchTasksRequest.newBuilder()
   *           .setHeader(DeliveryRequestHeader.newBuilder().build())
   *           .setParent("parent-995424086")
   *           .setTrackingId("trackingId1168987698")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Task element : deliveryServiceClient.searchTasks(request).iterateAll()) {
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
  public final SearchTasksPagedResponse searchTasks(SearchTasksRequest request) {
    return searchTasksPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deprecated: Use `GetTaskTrackingInfo` instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeliveryServiceClient deliveryServiceClient = DeliveryServiceClient.create()) {
   *   SearchTasksRequest request =
   *       SearchTasksRequest.newBuilder()
   *           .setHeader(DeliveryRequestHeader.newBuilder().build())
   *           .setParent("parent-995424086")
   *           .setTrackingId("trackingId1168987698")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Task> future = deliveryServiceClient.searchTasksPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Task element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final UnaryCallable<SearchTasksRequest, SearchTasksPagedResponse>
      searchTasksPagedCallable() {
    return stub.searchTasksPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deprecated: Use `GetTaskTrackingInfo` instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeliveryServiceClient deliveryServiceClient = DeliveryServiceClient.create()) {
   *   SearchTasksRequest request =
   *       SearchTasksRequest.newBuilder()
   *           .setHeader(DeliveryRequestHeader.newBuilder().build())
   *           .setParent("parent-995424086")
   *           .setTrackingId("trackingId1168987698")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     SearchTasksResponse response = deliveryServiceClient.searchTasksCallable().call(request);
   *     for (Task element : response.getTasksList()) {
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
  public final UnaryCallable<SearchTasksRequest, SearchTasksResponse> searchTasksCallable() {
    return stub.searchTasksCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates `Task` data.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeliveryServiceClient deliveryServiceClient = DeliveryServiceClient.create()) {
   *   Task task = Task.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Task response = deliveryServiceClient.updateTask(task, updateMask);
   * }
   * }</pre>
   *
   * @param task Required. The Task associated with the update. The following fields are maintained
   *     by Fleet Engine. Do not update them using `Task.update`.
   *     <p>&#42; `last_location`. &#42; `last_location_snappable`. &#42; `name`. &#42;
   *     `remaining_vehicle_journey_segments`. &#42; `task_outcome_location_source`.
   *     <p>Note: You cannot change the value of `task_outcome` once you set it.
   *     <p>If the Task has been assigned to a delivery vehicle, then don't set the Task state to
   *     CLOSED using `Task.update`. Instead, remove the `VehicleStop` that contains the Task from
   *     the delivery vehicle, which automatically sets the Task state to CLOSED.
   * @param updateMask Required. The field mask that indicates which Task fields to update. Note:
   *     The `update_mask` must contain at least one field.
   *     <p>This is a comma-separated list of fully qualified names of fields. Example:
   *     `"task_outcome,task_outcome_time,task_outcome_location"`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Task updateTask(Task task, FieldMask updateMask) {
    UpdateTaskRequest request =
        UpdateTaskRequest.newBuilder().setTask(task).setUpdateMask(updateMask).build();
    return updateTask(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates `Task` data.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeliveryServiceClient deliveryServiceClient = DeliveryServiceClient.create()) {
   *   UpdateTaskRequest request =
   *       UpdateTaskRequest.newBuilder()
   *           .setHeader(DeliveryRequestHeader.newBuilder().build())
   *           .setTask(Task.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Task response = deliveryServiceClient.updateTask(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Task updateTask(UpdateTaskRequest request) {
    return updateTaskCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates `Task` data.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeliveryServiceClient deliveryServiceClient = DeliveryServiceClient.create()) {
   *   UpdateTaskRequest request =
   *       UpdateTaskRequest.newBuilder()
   *           .setHeader(DeliveryRequestHeader.newBuilder().build())
   *           .setTask(Task.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Task> future = deliveryServiceClient.updateTaskCallable().futureCall(request);
   *   // Do something.
   *   Task response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateTaskRequest, Task> updateTaskCallable() {
    return stub.updateTaskCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets all `Task`s that meet the specified filtering criteria.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeliveryServiceClient deliveryServiceClient = DeliveryServiceClient.create()) {
   *   ProviderName parent = ProviderName.of("[PROVIDER]");
   *   for (Task element : deliveryServiceClient.listTasks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Must be in the format `providers/{provider}`. The `provider` must be
   *     the Google Cloud Project ID. For example, `sample-cloud-project`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTasksPagedResponse listTasks(ProviderName parent) {
    ListTasksRequest request =
        ListTasksRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listTasks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets all `Task`s that meet the specified filtering criteria.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeliveryServiceClient deliveryServiceClient = DeliveryServiceClient.create()) {
   *   String parent = ProviderName.of("[PROVIDER]").toString();
   *   for (Task element : deliveryServiceClient.listTasks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Must be in the format `providers/{provider}`. The `provider` must be
   *     the Google Cloud Project ID. For example, `sample-cloud-project`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTasksPagedResponse listTasks(String parent) {
    ListTasksRequest request = ListTasksRequest.newBuilder().setParent(parent).build();
    return listTasks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets all `Task`s that meet the specified filtering criteria.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeliveryServiceClient deliveryServiceClient = DeliveryServiceClient.create()) {
   *   ListTasksRequest request =
   *       ListTasksRequest.newBuilder()
   *           .setHeader(DeliveryRequestHeader.newBuilder().build())
   *           .setParent(ProviderName.of("[PROVIDER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (Task element : deliveryServiceClient.listTasks(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTasksPagedResponse listTasks(ListTasksRequest request) {
    return listTasksPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets all `Task`s that meet the specified filtering criteria.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeliveryServiceClient deliveryServiceClient = DeliveryServiceClient.create()) {
   *   ListTasksRequest request =
   *       ListTasksRequest.newBuilder()
   *           .setHeader(DeliveryRequestHeader.newBuilder().build())
   *           .setParent(ProviderName.of("[PROVIDER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<Task> future = deliveryServiceClient.listTasksPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Task element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListTasksRequest, ListTasksPagedResponse> listTasksPagedCallable() {
    return stub.listTasksPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets all `Task`s that meet the specified filtering criteria.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeliveryServiceClient deliveryServiceClient = DeliveryServiceClient.create()) {
   *   ListTasksRequest request =
   *       ListTasksRequest.newBuilder()
   *           .setHeader(DeliveryRequestHeader.newBuilder().build())
   *           .setParent(ProviderName.of("[PROVIDER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListTasksResponse response = deliveryServiceClient.listTasksCallable().call(request);
   *     for (Task element : response.getTasksList()) {
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
  public final UnaryCallable<ListTasksRequest, ListTasksResponse> listTasksCallable() {
    return stub.listTasksCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified `TaskTrackingInfo` instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeliveryServiceClient deliveryServiceClient = DeliveryServiceClient.create()) {
   *   TaskTrackingInfoName name = TaskTrackingInfoName.of("[PROVIDER]", "[TRACKING]");
   *   TaskTrackingInfo response = deliveryServiceClient.getTaskTrackingInfo(name);
   * }
   * }</pre>
   *
   * @param name Required. Must be in the format
   *     `providers/{provider}/taskTrackingInfo/{tracking_id}`. The `provider` must be the Google
   *     Cloud Project ID, and the `tracking_id` must be the tracking ID associated with the task.
   *     An example name can be
   *     `providers/sample-cloud-project/taskTrackingInfo/sample-tracking-id`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TaskTrackingInfo getTaskTrackingInfo(TaskTrackingInfoName name) {
    GetTaskTrackingInfoRequest request =
        GetTaskTrackingInfoRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getTaskTrackingInfo(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified `TaskTrackingInfo` instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeliveryServiceClient deliveryServiceClient = DeliveryServiceClient.create()) {
   *   String name = TaskTrackingInfoName.of("[PROVIDER]", "[TRACKING]").toString();
   *   TaskTrackingInfo response = deliveryServiceClient.getTaskTrackingInfo(name);
   * }
   * }</pre>
   *
   * @param name Required. Must be in the format
   *     `providers/{provider}/taskTrackingInfo/{tracking_id}`. The `provider` must be the Google
   *     Cloud Project ID, and the `tracking_id` must be the tracking ID associated with the task.
   *     An example name can be
   *     `providers/sample-cloud-project/taskTrackingInfo/sample-tracking-id`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TaskTrackingInfo getTaskTrackingInfo(String name) {
    GetTaskTrackingInfoRequest request =
        GetTaskTrackingInfoRequest.newBuilder().setName(name).build();
    return getTaskTrackingInfo(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified `TaskTrackingInfo` instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeliveryServiceClient deliveryServiceClient = DeliveryServiceClient.create()) {
   *   GetTaskTrackingInfoRequest request =
   *       GetTaskTrackingInfoRequest.newBuilder()
   *           .setHeader(DeliveryRequestHeader.newBuilder().build())
   *           .setName(TaskTrackingInfoName.of("[PROVIDER]", "[TRACKING]").toString())
   *           .build();
   *   TaskTrackingInfo response = deliveryServiceClient.getTaskTrackingInfo(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TaskTrackingInfo getTaskTrackingInfo(GetTaskTrackingInfoRequest request) {
    return getTaskTrackingInfoCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified `TaskTrackingInfo` instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeliveryServiceClient deliveryServiceClient = DeliveryServiceClient.create()) {
   *   GetTaskTrackingInfoRequest request =
   *       GetTaskTrackingInfoRequest.newBuilder()
   *           .setHeader(DeliveryRequestHeader.newBuilder().build())
   *           .setName(TaskTrackingInfoName.of("[PROVIDER]", "[TRACKING]").toString())
   *           .build();
   *   ApiFuture<TaskTrackingInfo> future =
   *       deliveryServiceClient.getTaskTrackingInfoCallable().futureCall(request);
   *   // Do something.
   *   TaskTrackingInfo response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetTaskTrackingInfoRequest, TaskTrackingInfo>
      getTaskTrackingInfoCallable() {
    return stub.getTaskTrackingInfoCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets all `DeliveryVehicle`s that meet the specified filtering criteria.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeliveryServiceClient deliveryServiceClient = DeliveryServiceClient.create()) {
   *   ProviderName parent = ProviderName.of("[PROVIDER]");
   *   for (DeliveryVehicle element :
   *       deliveryServiceClient.listDeliveryVehicles(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Must be in the format `providers/{provider}`. The `provider` must be
   *     the Google Cloud Project ID. For example, `sample-cloud-project`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDeliveryVehiclesPagedResponse listDeliveryVehicles(ProviderName parent) {
    ListDeliveryVehiclesRequest request =
        ListDeliveryVehiclesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDeliveryVehicles(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets all `DeliveryVehicle`s that meet the specified filtering criteria.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeliveryServiceClient deliveryServiceClient = DeliveryServiceClient.create()) {
   *   String parent = ProviderName.of("[PROVIDER]").toString();
   *   for (DeliveryVehicle element :
   *       deliveryServiceClient.listDeliveryVehicles(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Must be in the format `providers/{provider}`. The `provider` must be
   *     the Google Cloud Project ID. For example, `sample-cloud-project`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDeliveryVehiclesPagedResponse listDeliveryVehicles(String parent) {
    ListDeliveryVehiclesRequest request =
        ListDeliveryVehiclesRequest.newBuilder().setParent(parent).build();
    return listDeliveryVehicles(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets all `DeliveryVehicle`s that meet the specified filtering criteria.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeliveryServiceClient deliveryServiceClient = DeliveryServiceClient.create()) {
   *   ListDeliveryVehiclesRequest request =
   *       ListDeliveryVehiclesRequest.newBuilder()
   *           .setHeader(DeliveryRequestHeader.newBuilder().build())
   *           .setParent(ProviderName.of("[PROVIDER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setViewport(Viewport.newBuilder().build())
   *           .build();
   *   for (DeliveryVehicle element :
   *       deliveryServiceClient.listDeliveryVehicles(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDeliveryVehiclesPagedResponse listDeliveryVehicles(
      ListDeliveryVehiclesRequest request) {
    return listDeliveryVehiclesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets all `DeliveryVehicle`s that meet the specified filtering criteria.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeliveryServiceClient deliveryServiceClient = DeliveryServiceClient.create()) {
   *   ListDeliveryVehiclesRequest request =
   *       ListDeliveryVehiclesRequest.newBuilder()
   *           .setHeader(DeliveryRequestHeader.newBuilder().build())
   *           .setParent(ProviderName.of("[PROVIDER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setViewport(Viewport.newBuilder().build())
   *           .build();
   *   ApiFuture<DeliveryVehicle> future =
   *       deliveryServiceClient.listDeliveryVehiclesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (DeliveryVehicle element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDeliveryVehiclesRequest, ListDeliveryVehiclesPagedResponse>
      listDeliveryVehiclesPagedCallable() {
    return stub.listDeliveryVehiclesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets all `DeliveryVehicle`s that meet the specified filtering criteria.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeliveryServiceClient deliveryServiceClient = DeliveryServiceClient.create()) {
   *   ListDeliveryVehiclesRequest request =
   *       ListDeliveryVehiclesRequest.newBuilder()
   *           .setHeader(DeliveryRequestHeader.newBuilder().build())
   *           .setParent(ProviderName.of("[PROVIDER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setViewport(Viewport.newBuilder().build())
   *           .build();
   *   while (true) {
   *     ListDeliveryVehiclesResponse response =
   *         deliveryServiceClient.listDeliveryVehiclesCallable().call(request);
   *     for (DeliveryVehicle element : response.getDeliveryVehiclesList()) {
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
  public final UnaryCallable<ListDeliveryVehiclesRequest, ListDeliveryVehiclesResponse>
      listDeliveryVehiclesCallable() {
    return stub.listDeliveryVehiclesCallable();
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

  public static class SearchTasksPagedResponse
      extends AbstractPagedListResponse<
          SearchTasksRequest,
          SearchTasksResponse,
          Task,
          SearchTasksPage,
          SearchTasksFixedSizeCollection> {

    public static ApiFuture<SearchTasksPagedResponse> createAsync(
        PageContext<SearchTasksRequest, SearchTasksResponse, Task> context,
        ApiFuture<SearchTasksResponse> futureResponse) {
      ApiFuture<SearchTasksPage> futurePage =
          SearchTasksPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new SearchTasksPagedResponse(input), MoreExecutors.directExecutor());
    }

    private SearchTasksPagedResponse(SearchTasksPage page) {
      super(page, SearchTasksFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class SearchTasksPage
      extends AbstractPage<SearchTasksRequest, SearchTasksResponse, Task, SearchTasksPage> {

    private SearchTasksPage(
        PageContext<SearchTasksRequest, SearchTasksResponse, Task> context,
        SearchTasksResponse response) {
      super(context, response);
    }

    private static SearchTasksPage createEmptyPage() {
      return new SearchTasksPage(null, null);
    }

    @Override
    protected SearchTasksPage createPage(
        PageContext<SearchTasksRequest, SearchTasksResponse, Task> context,
        SearchTasksResponse response) {
      return new SearchTasksPage(context, response);
    }

    @Override
    public ApiFuture<SearchTasksPage> createPageAsync(
        PageContext<SearchTasksRequest, SearchTasksResponse, Task> context,
        ApiFuture<SearchTasksResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class SearchTasksFixedSizeCollection
      extends AbstractFixedSizeCollection<
          SearchTasksRequest,
          SearchTasksResponse,
          Task,
          SearchTasksPage,
          SearchTasksFixedSizeCollection> {

    private SearchTasksFixedSizeCollection(List<SearchTasksPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static SearchTasksFixedSizeCollection createEmptyCollection() {
      return new SearchTasksFixedSizeCollection(null, 0);
    }

    @Override
    protected SearchTasksFixedSizeCollection createCollection(
        List<SearchTasksPage> pages, int collectionSize) {
      return new SearchTasksFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListTasksPagedResponse
      extends AbstractPagedListResponse<
          ListTasksRequest, ListTasksResponse, Task, ListTasksPage, ListTasksFixedSizeCollection> {

    public static ApiFuture<ListTasksPagedResponse> createAsync(
        PageContext<ListTasksRequest, ListTasksResponse, Task> context,
        ApiFuture<ListTasksResponse> futureResponse) {
      ApiFuture<ListTasksPage> futurePage =
          ListTasksPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListTasksPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListTasksPagedResponse(ListTasksPage page) {
      super(page, ListTasksFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListTasksPage
      extends AbstractPage<ListTasksRequest, ListTasksResponse, Task, ListTasksPage> {

    private ListTasksPage(
        PageContext<ListTasksRequest, ListTasksResponse, Task> context,
        ListTasksResponse response) {
      super(context, response);
    }

    private static ListTasksPage createEmptyPage() {
      return new ListTasksPage(null, null);
    }

    @Override
    protected ListTasksPage createPage(
        PageContext<ListTasksRequest, ListTasksResponse, Task> context,
        ListTasksResponse response) {
      return new ListTasksPage(context, response);
    }

    @Override
    public ApiFuture<ListTasksPage> createPageAsync(
        PageContext<ListTasksRequest, ListTasksResponse, Task> context,
        ApiFuture<ListTasksResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListTasksFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTasksRequest, ListTasksResponse, Task, ListTasksPage, ListTasksFixedSizeCollection> {

    private ListTasksFixedSizeCollection(List<ListTasksPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTasksFixedSizeCollection createEmptyCollection() {
      return new ListTasksFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTasksFixedSizeCollection createCollection(
        List<ListTasksPage> pages, int collectionSize) {
      return new ListTasksFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListDeliveryVehiclesPagedResponse
      extends AbstractPagedListResponse<
          ListDeliveryVehiclesRequest,
          ListDeliveryVehiclesResponse,
          DeliveryVehicle,
          ListDeliveryVehiclesPage,
          ListDeliveryVehiclesFixedSizeCollection> {

    public static ApiFuture<ListDeliveryVehiclesPagedResponse> createAsync(
        PageContext<ListDeliveryVehiclesRequest, ListDeliveryVehiclesResponse, DeliveryVehicle>
            context,
        ApiFuture<ListDeliveryVehiclesResponse> futureResponse) {
      ApiFuture<ListDeliveryVehiclesPage> futurePage =
          ListDeliveryVehiclesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDeliveryVehiclesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDeliveryVehiclesPagedResponse(ListDeliveryVehiclesPage page) {
      super(page, ListDeliveryVehiclesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDeliveryVehiclesPage
      extends AbstractPage<
          ListDeliveryVehiclesRequest,
          ListDeliveryVehiclesResponse,
          DeliveryVehicle,
          ListDeliveryVehiclesPage> {

    private ListDeliveryVehiclesPage(
        PageContext<ListDeliveryVehiclesRequest, ListDeliveryVehiclesResponse, DeliveryVehicle>
            context,
        ListDeliveryVehiclesResponse response) {
      super(context, response);
    }

    private static ListDeliveryVehiclesPage createEmptyPage() {
      return new ListDeliveryVehiclesPage(null, null);
    }

    @Override
    protected ListDeliveryVehiclesPage createPage(
        PageContext<ListDeliveryVehiclesRequest, ListDeliveryVehiclesResponse, DeliveryVehicle>
            context,
        ListDeliveryVehiclesResponse response) {
      return new ListDeliveryVehiclesPage(context, response);
    }

    @Override
    public ApiFuture<ListDeliveryVehiclesPage> createPageAsync(
        PageContext<ListDeliveryVehiclesRequest, ListDeliveryVehiclesResponse, DeliveryVehicle>
            context,
        ApiFuture<ListDeliveryVehiclesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDeliveryVehiclesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDeliveryVehiclesRequest,
          ListDeliveryVehiclesResponse,
          DeliveryVehicle,
          ListDeliveryVehiclesPage,
          ListDeliveryVehiclesFixedSizeCollection> {

    private ListDeliveryVehiclesFixedSizeCollection(
        List<ListDeliveryVehiclesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDeliveryVehiclesFixedSizeCollection createEmptyCollection() {
      return new ListDeliveryVehiclesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDeliveryVehiclesFixedSizeCollection createCollection(
        List<ListDeliveryVehiclesPage> pages, int collectionSize) {
      return new ListDeliveryVehiclesFixedSizeCollection(pages, collectionSize);
    }
  }
}
