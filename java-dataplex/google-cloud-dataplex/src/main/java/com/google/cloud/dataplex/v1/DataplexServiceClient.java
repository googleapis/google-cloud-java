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

package com.google.cloud.dataplex.v1;

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
import com.google.cloud.dataplex.v1.stub.DataplexServiceStub;
import com.google.cloud.dataplex.v1.stub.DataplexServiceStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
 * Service Description: Dataplex service provides data lakes as a service. The primary resources
 * offered by this service are Lakes, Zones and Assets which collectively allow a data administrator
 * to organize, manage, secure and catalog data across their organization located across cloud
 * projects in a variety of storage systems including Cloud Storage and BigQuery.
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
 * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
 *   LakeName name = LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]");
 *   Lake response = dataplexServiceClient.getLake(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the DataplexServiceClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of DataplexServiceSettings to
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
 * DataplexServiceSettings dataplexServiceSettings =
 *     DataplexServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DataplexServiceClient dataplexServiceClient =
 *     DataplexServiceClient.create(dataplexServiceSettings);
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
 * DataplexServiceSettings dataplexServiceSettings =
 *     DataplexServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DataplexServiceClient dataplexServiceClient =
 *     DataplexServiceClient.create(dataplexServiceSettings);
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
 * DataplexServiceSettings dataplexServiceSettings =
 *     DataplexServiceSettings.newHttpJsonBuilder().build();
 * DataplexServiceClient dataplexServiceClient =
 *     DataplexServiceClient.create(dataplexServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class DataplexServiceClient implements BackgroundResource {
  private final DataplexServiceSettings settings;
  private final DataplexServiceStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of DataplexServiceClient with default settings. */
  public static final DataplexServiceClient create() throws IOException {
    return create(DataplexServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of DataplexServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final DataplexServiceClient create(DataplexServiceSettings settings)
      throws IOException {
    return new DataplexServiceClient(settings);
  }

  /**
   * Constructs an instance of DataplexServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(DataplexServiceSettings).
   */
  public static final DataplexServiceClient create(DataplexServiceStub stub) {
    return new DataplexServiceClient(stub);
  }

  /**
   * Constructs an instance of DataplexServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected DataplexServiceClient(DataplexServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((DataplexServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected DataplexServiceClient(DataplexServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final DataplexServiceSettings getSettings() {
    return settings;
  }

  public DataplexServiceStub getStub() {
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
   * Creates a lake resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Lake lake = Lake.newBuilder().build();
   *   String lakeId = "lakeId-1110150390";
   *   Lake response = dataplexServiceClient.createLakeAsync(parent, lake, lakeId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the lake location, of the form:
   *     projects/{project_number}/locations/{location_id} where `location_id` refers to a GCP
   *     region.
   * @param lake Required. Lake resource
   * @param lakeId Required. Lake identifier. This ID will be used to generate names such as
   *     database and dataset names when publishing metadata to Hive Metastore and BigQuery.
   *     <ul>
   *       <li>Must contain only lowercase letters, numbers and hyphens.
   *       <li>Must start with a letter.
   *       <li>Must end with a number or a letter.
   *       <li>Must be between 1-63 characters.
   *       <li>Must be unique within the customer project / location.
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Lake, OperationMetadata> createLakeAsync(
      LocationName parent, Lake lake, String lakeId) {
    CreateLakeRequest request =
        CreateLakeRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setLake(lake)
            .setLakeId(lakeId)
            .build();
    return createLakeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a lake resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Lake lake = Lake.newBuilder().build();
   *   String lakeId = "lakeId-1110150390";
   *   Lake response = dataplexServiceClient.createLakeAsync(parent, lake, lakeId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the lake location, of the form:
   *     projects/{project_number}/locations/{location_id} where `location_id` refers to a GCP
   *     region.
   * @param lake Required. Lake resource
   * @param lakeId Required. Lake identifier. This ID will be used to generate names such as
   *     database and dataset names when publishing metadata to Hive Metastore and BigQuery.
   *     <ul>
   *       <li>Must contain only lowercase letters, numbers and hyphens.
   *       <li>Must start with a letter.
   *       <li>Must end with a number or a letter.
   *       <li>Must be between 1-63 characters.
   *       <li>Must be unique within the customer project / location.
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Lake, OperationMetadata> createLakeAsync(
      String parent, Lake lake, String lakeId) {
    CreateLakeRequest request =
        CreateLakeRequest.newBuilder().setParent(parent).setLake(lake).setLakeId(lakeId).build();
    return createLakeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a lake resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   CreateLakeRequest request =
   *       CreateLakeRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setLakeId("lakeId-1110150390")
   *           .setLake(Lake.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   Lake response = dataplexServiceClient.createLakeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Lake, OperationMetadata> createLakeAsync(CreateLakeRequest request) {
    return createLakeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a lake resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   CreateLakeRequest request =
   *       CreateLakeRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setLakeId("lakeId-1110150390")
   *           .setLake(Lake.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Lake, OperationMetadata> future =
   *       dataplexServiceClient.createLakeOperationCallable().futureCall(request);
   *   // Do something.
   *   Lake response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateLakeRequest, Lake, OperationMetadata>
      createLakeOperationCallable() {
    return stub.createLakeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a lake resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   CreateLakeRequest request =
   *       CreateLakeRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setLakeId("lakeId-1110150390")
   *           .setLake(Lake.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future = dataplexServiceClient.createLakeCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateLakeRequest, Operation> createLakeCallable() {
    return stub.createLakeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a lake resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   Lake lake = Lake.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Lake response = dataplexServiceClient.updateLakeAsync(lake, updateMask).get();
   * }
   * }</pre>
   *
   * @param lake Required. Update description. Only fields specified in `update_mask` are updated.
   * @param updateMask Required. Mask of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Lake, OperationMetadata> updateLakeAsync(
      Lake lake, FieldMask updateMask) {
    UpdateLakeRequest request =
        UpdateLakeRequest.newBuilder().setLake(lake).setUpdateMask(updateMask).build();
    return updateLakeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a lake resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   UpdateLakeRequest request =
   *       UpdateLakeRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setLake(Lake.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   Lake response = dataplexServiceClient.updateLakeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Lake, OperationMetadata> updateLakeAsync(UpdateLakeRequest request) {
    return updateLakeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a lake resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   UpdateLakeRequest request =
   *       UpdateLakeRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setLake(Lake.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Lake, OperationMetadata> future =
   *       dataplexServiceClient.updateLakeOperationCallable().futureCall(request);
   *   // Do something.
   *   Lake response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateLakeRequest, Lake, OperationMetadata>
      updateLakeOperationCallable() {
    return stub.updateLakeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a lake resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   UpdateLakeRequest request =
   *       UpdateLakeRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setLake(Lake.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future = dataplexServiceClient.updateLakeCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateLakeRequest, Operation> updateLakeCallable() {
    return stub.updateLakeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a lake resource. All zones within the lake must be deleted before the lake can be
   * deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   LakeName name = LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]");
   *   dataplexServiceClient.deleteLakeAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the lake:
   *     `projects/{project_number}/locations/{location_id}/lakes/{lake_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteLakeAsync(LakeName name) {
    DeleteLakeRequest request =
        DeleteLakeRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteLakeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a lake resource. All zones within the lake must be deleted before the lake can be
   * deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   String name = LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]").toString();
   *   dataplexServiceClient.deleteLakeAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the lake:
   *     `projects/{project_number}/locations/{location_id}/lakes/{lake_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteLakeAsync(String name) {
    DeleteLakeRequest request = DeleteLakeRequest.newBuilder().setName(name).build();
    return deleteLakeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a lake resource. All zones within the lake must be deleted before the lake can be
   * deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   DeleteLakeRequest request =
   *       DeleteLakeRequest.newBuilder()
   *           .setName(LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]").toString())
   *           .build();
   *   dataplexServiceClient.deleteLakeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteLakeAsync(
      DeleteLakeRequest request) {
    return deleteLakeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a lake resource. All zones within the lake must be deleted before the lake can be
   * deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   DeleteLakeRequest request =
   *       DeleteLakeRequest.newBuilder()
   *           .setName(LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]").toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       dataplexServiceClient.deleteLakeOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteLakeRequest, Empty, OperationMetadata>
      deleteLakeOperationCallable() {
    return stub.deleteLakeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a lake resource. All zones within the lake must be deleted before the lake can be
   * deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   DeleteLakeRequest request =
   *       DeleteLakeRequest.newBuilder()
   *           .setName(LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]").toString())
   *           .build();
   *   ApiFuture<Operation> future = dataplexServiceClient.deleteLakeCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteLakeRequest, Operation> deleteLakeCallable() {
    return stub.deleteLakeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists lake resources in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Lake element : dataplexServiceClient.listLakes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the lake location, of the form:
   *     `projects/{project_number}/locations/{location_id}` where `location_id` refers to a GCP
   *     region.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLakesPagedResponse listLakes(LocationName parent) {
    ListLakesRequest request =
        ListLakesRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listLakes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists lake resources in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Lake element : dataplexServiceClient.listLakes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the lake location, of the form:
   *     `projects/{project_number}/locations/{location_id}` where `location_id` refers to a GCP
   *     region.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLakesPagedResponse listLakes(String parent) {
    ListLakesRequest request = ListLakesRequest.newBuilder().setParent(parent).build();
    return listLakes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists lake resources in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   ListLakesRequest request =
   *       ListLakesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Lake element : dataplexServiceClient.listLakes(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLakesPagedResponse listLakes(ListLakesRequest request) {
    return listLakesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists lake resources in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   ListLakesRequest request =
   *       ListLakesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Lake> future = dataplexServiceClient.listLakesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Lake element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListLakesRequest, ListLakesPagedResponse> listLakesPagedCallable() {
    return stub.listLakesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists lake resources in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   ListLakesRequest request =
   *       ListLakesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListLakesResponse response = dataplexServiceClient.listLakesCallable().call(request);
   *     for (Lake element : response.getLakesList()) {
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
  public final UnaryCallable<ListLakesRequest, ListLakesResponse> listLakesCallable() {
    return stub.listLakesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a lake resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   LakeName name = LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]");
   *   Lake response = dataplexServiceClient.getLake(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the lake:
   *     `projects/{project_number}/locations/{location_id}/lakes/{lake_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Lake getLake(LakeName name) {
    GetLakeRequest request =
        GetLakeRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getLake(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a lake resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   String name = LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]").toString();
   *   Lake response = dataplexServiceClient.getLake(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the lake:
   *     `projects/{project_number}/locations/{location_id}/lakes/{lake_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Lake getLake(String name) {
    GetLakeRequest request = GetLakeRequest.newBuilder().setName(name).build();
    return getLake(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a lake resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   GetLakeRequest request =
   *       GetLakeRequest.newBuilder()
   *           .setName(LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]").toString())
   *           .build();
   *   Lake response = dataplexServiceClient.getLake(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Lake getLake(GetLakeRequest request) {
    return getLakeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a lake resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   GetLakeRequest request =
   *       GetLakeRequest.newBuilder()
   *           .setName(LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]").toString())
   *           .build();
   *   ApiFuture<Lake> future = dataplexServiceClient.getLakeCallable().futureCall(request);
   *   // Do something.
   *   Lake response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLakeRequest, Lake> getLakeCallable() {
    return stub.getLakeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists action resources in a lake.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   LakeName parent = LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]");
   *   for (Action element : dataplexServiceClient.listLakeActions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the parent lake:
   *     `projects/{project_number}/locations/{location_id}/lakes/{lake_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLakeActionsPagedResponse listLakeActions(LakeName parent) {
    ListLakeActionsRequest request =
        ListLakeActionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listLakeActions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists action resources in a lake.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   String parent = LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]").toString();
   *   for (Action element : dataplexServiceClient.listLakeActions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the parent lake:
   *     `projects/{project_number}/locations/{location_id}/lakes/{lake_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLakeActionsPagedResponse listLakeActions(String parent) {
    ListLakeActionsRequest request = ListLakeActionsRequest.newBuilder().setParent(parent).build();
    return listLakeActions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists action resources in a lake.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   ListLakeActionsRequest request =
   *       ListLakeActionsRequest.newBuilder()
   *           .setParent(LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Action element : dataplexServiceClient.listLakeActions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLakeActionsPagedResponse listLakeActions(ListLakeActionsRequest request) {
    return listLakeActionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists action resources in a lake.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   ListLakeActionsRequest request =
   *       ListLakeActionsRequest.newBuilder()
   *           .setParent(LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Action> future =
   *       dataplexServiceClient.listLakeActionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Action element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListLakeActionsRequest, ListLakeActionsPagedResponse>
      listLakeActionsPagedCallable() {
    return stub.listLakeActionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists action resources in a lake.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   ListLakeActionsRequest request =
   *       ListLakeActionsRequest.newBuilder()
   *           .setParent(LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListActionsResponse response =
   *         dataplexServiceClient.listLakeActionsCallable().call(request);
   *     for (Action element : response.getActionsList()) {
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
  public final UnaryCallable<ListLakeActionsRequest, ListActionsResponse>
      listLakeActionsCallable() {
    return stub.listLakeActionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a zone resource within a lake.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   LakeName parent = LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]");
   *   Zone zone = Zone.newBuilder().build();
   *   String zoneId = "zoneId-696323609";
   *   Zone response = dataplexServiceClient.createZoneAsync(parent, zone, zoneId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the parent lake:
   *     `projects/{project_number}/locations/{location_id}/lakes/{lake_id}`.
   * @param zone Required. Zone resource.
   * @param zoneId Required. Zone identifier. This ID will be used to generate names such as
   *     database and dataset names when publishing metadata to Hive Metastore and BigQuery.
   *     <ul>
   *       <li>Must contain only lowercase letters, numbers and hyphens.
   *       <li>Must start with a letter.
   *       <li>Must end with a number or a letter.
   *       <li>Must be between 1-63 characters.
   *       <li>Must be unique across all lakes from all locations in a project.
   *       <li>Must not be one of the reserved IDs (i.e. "default", "global-temp")
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Zone, OperationMetadata> createZoneAsync(
      LakeName parent, Zone zone, String zoneId) {
    CreateZoneRequest request =
        CreateZoneRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setZone(zone)
            .setZoneId(zoneId)
            .build();
    return createZoneAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a zone resource within a lake.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   String parent = LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]").toString();
   *   Zone zone = Zone.newBuilder().build();
   *   String zoneId = "zoneId-696323609";
   *   Zone response = dataplexServiceClient.createZoneAsync(parent, zone, zoneId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the parent lake:
   *     `projects/{project_number}/locations/{location_id}/lakes/{lake_id}`.
   * @param zone Required. Zone resource.
   * @param zoneId Required. Zone identifier. This ID will be used to generate names such as
   *     database and dataset names when publishing metadata to Hive Metastore and BigQuery.
   *     <ul>
   *       <li>Must contain only lowercase letters, numbers and hyphens.
   *       <li>Must start with a letter.
   *       <li>Must end with a number or a letter.
   *       <li>Must be between 1-63 characters.
   *       <li>Must be unique across all lakes from all locations in a project.
   *       <li>Must not be one of the reserved IDs (i.e. "default", "global-temp")
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Zone, OperationMetadata> createZoneAsync(
      String parent, Zone zone, String zoneId) {
    CreateZoneRequest request =
        CreateZoneRequest.newBuilder().setParent(parent).setZone(zone).setZoneId(zoneId).build();
    return createZoneAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a zone resource within a lake.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   CreateZoneRequest request =
   *       CreateZoneRequest.newBuilder()
   *           .setParent(LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]").toString())
   *           .setZoneId("zoneId-696323609")
   *           .setZone(Zone.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   Zone response = dataplexServiceClient.createZoneAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Zone, OperationMetadata> createZoneAsync(CreateZoneRequest request) {
    return createZoneOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a zone resource within a lake.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   CreateZoneRequest request =
   *       CreateZoneRequest.newBuilder()
   *           .setParent(LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]").toString())
   *           .setZoneId("zoneId-696323609")
   *           .setZone(Zone.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Zone, OperationMetadata> future =
   *       dataplexServiceClient.createZoneOperationCallable().futureCall(request);
   *   // Do something.
   *   Zone response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateZoneRequest, Zone, OperationMetadata>
      createZoneOperationCallable() {
    return stub.createZoneOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a zone resource within a lake.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   CreateZoneRequest request =
   *       CreateZoneRequest.newBuilder()
   *           .setParent(LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]").toString())
   *           .setZoneId("zoneId-696323609")
   *           .setZone(Zone.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future = dataplexServiceClient.createZoneCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateZoneRequest, Operation> createZoneCallable() {
    return stub.createZoneCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a zone resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   Zone zone = Zone.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Zone response = dataplexServiceClient.updateZoneAsync(zone, updateMask).get();
   * }
   * }</pre>
   *
   * @param zone Required. Update description. Only fields specified in `update_mask` are updated.
   * @param updateMask Required. Mask of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Zone, OperationMetadata> updateZoneAsync(
      Zone zone, FieldMask updateMask) {
    UpdateZoneRequest request =
        UpdateZoneRequest.newBuilder().setZone(zone).setUpdateMask(updateMask).build();
    return updateZoneAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a zone resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   UpdateZoneRequest request =
   *       UpdateZoneRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setZone(Zone.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   Zone response = dataplexServiceClient.updateZoneAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Zone, OperationMetadata> updateZoneAsync(UpdateZoneRequest request) {
    return updateZoneOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a zone resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   UpdateZoneRequest request =
   *       UpdateZoneRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setZone(Zone.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Zone, OperationMetadata> future =
   *       dataplexServiceClient.updateZoneOperationCallable().futureCall(request);
   *   // Do something.
   *   Zone response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateZoneRequest, Zone, OperationMetadata>
      updateZoneOperationCallable() {
    return stub.updateZoneOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a zone resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   UpdateZoneRequest request =
   *       UpdateZoneRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setZone(Zone.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future = dataplexServiceClient.updateZoneCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateZoneRequest, Operation> updateZoneCallable() {
    return stub.updateZoneCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a zone resource. All assets within a zone must be deleted before the zone can be
   * deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   ZoneName name = ZoneName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]");
   *   dataplexServiceClient.deleteZoneAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the zone:
   *     `projects/{project_number}/locations/{location_id}/lakes/{lake_id}/zones/{zone_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteZoneAsync(ZoneName name) {
    DeleteZoneRequest request =
        DeleteZoneRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteZoneAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a zone resource. All assets within a zone must be deleted before the zone can be
   * deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   String name = ZoneName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]").toString();
   *   dataplexServiceClient.deleteZoneAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the zone:
   *     `projects/{project_number}/locations/{location_id}/lakes/{lake_id}/zones/{zone_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteZoneAsync(String name) {
    DeleteZoneRequest request = DeleteZoneRequest.newBuilder().setName(name).build();
    return deleteZoneAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a zone resource. All assets within a zone must be deleted before the zone can be
   * deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   DeleteZoneRequest request =
   *       DeleteZoneRequest.newBuilder()
   *           .setName(ZoneName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]").toString())
   *           .build();
   *   dataplexServiceClient.deleteZoneAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteZoneAsync(
      DeleteZoneRequest request) {
    return deleteZoneOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a zone resource. All assets within a zone must be deleted before the zone can be
   * deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   DeleteZoneRequest request =
   *       DeleteZoneRequest.newBuilder()
   *           .setName(ZoneName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]").toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       dataplexServiceClient.deleteZoneOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteZoneRequest, Empty, OperationMetadata>
      deleteZoneOperationCallable() {
    return stub.deleteZoneOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a zone resource. All assets within a zone must be deleted before the zone can be
   * deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   DeleteZoneRequest request =
   *       DeleteZoneRequest.newBuilder()
   *           .setName(ZoneName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]").toString())
   *           .build();
   *   ApiFuture<Operation> future = dataplexServiceClient.deleteZoneCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteZoneRequest, Operation> deleteZoneCallable() {
    return stub.deleteZoneCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists zone resources in a lake.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   LakeName parent = LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]");
   *   for (Zone element : dataplexServiceClient.listZones(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the parent lake:
   *     `projects/{project_number}/locations/{location_id}/lakes/{lake_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListZonesPagedResponse listZones(LakeName parent) {
    ListZonesRequest request =
        ListZonesRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listZones(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists zone resources in a lake.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   String parent = LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]").toString();
   *   for (Zone element : dataplexServiceClient.listZones(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the parent lake:
   *     `projects/{project_number}/locations/{location_id}/lakes/{lake_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListZonesPagedResponse listZones(String parent) {
    ListZonesRequest request = ListZonesRequest.newBuilder().setParent(parent).build();
    return listZones(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists zone resources in a lake.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   ListZonesRequest request =
   *       ListZonesRequest.newBuilder()
   *           .setParent(LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Zone element : dataplexServiceClient.listZones(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListZonesPagedResponse listZones(ListZonesRequest request) {
    return listZonesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists zone resources in a lake.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   ListZonesRequest request =
   *       ListZonesRequest.newBuilder()
   *           .setParent(LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Zone> future = dataplexServiceClient.listZonesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Zone element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListZonesRequest, ListZonesPagedResponse> listZonesPagedCallable() {
    return stub.listZonesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists zone resources in a lake.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   ListZonesRequest request =
   *       ListZonesRequest.newBuilder()
   *           .setParent(LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListZonesResponse response = dataplexServiceClient.listZonesCallable().call(request);
   *     for (Zone element : response.getZonesList()) {
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
  public final UnaryCallable<ListZonesRequest, ListZonesResponse> listZonesCallable() {
    return stub.listZonesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a zone resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   ZoneName name = ZoneName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]");
   *   Zone response = dataplexServiceClient.getZone(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the zone:
   *     `projects/{project_number}/locations/{location_id}/lakes/{lake_id}/zones/{zone_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Zone getZone(ZoneName name) {
    GetZoneRequest request =
        GetZoneRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getZone(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a zone resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   String name = ZoneName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]").toString();
   *   Zone response = dataplexServiceClient.getZone(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the zone:
   *     `projects/{project_number}/locations/{location_id}/lakes/{lake_id}/zones/{zone_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Zone getZone(String name) {
    GetZoneRequest request = GetZoneRequest.newBuilder().setName(name).build();
    return getZone(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a zone resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   GetZoneRequest request =
   *       GetZoneRequest.newBuilder()
   *           .setName(ZoneName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]").toString())
   *           .build();
   *   Zone response = dataplexServiceClient.getZone(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Zone getZone(GetZoneRequest request) {
    return getZoneCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a zone resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   GetZoneRequest request =
   *       GetZoneRequest.newBuilder()
   *           .setName(ZoneName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]").toString())
   *           .build();
   *   ApiFuture<Zone> future = dataplexServiceClient.getZoneCallable().futureCall(request);
   *   // Do something.
   *   Zone response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetZoneRequest, Zone> getZoneCallable() {
    return stub.getZoneCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists action resources in a zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   ZoneName parent = ZoneName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]");
   *   for (Action element : dataplexServiceClient.listZoneActions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the parent zone:
   *     `projects/{project_number}/locations/{location_id}/lakes/{lake_id}/zones/{zone_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListZoneActionsPagedResponse listZoneActions(ZoneName parent) {
    ListZoneActionsRequest request =
        ListZoneActionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listZoneActions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists action resources in a zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   String parent = ZoneName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]").toString();
   *   for (Action element : dataplexServiceClient.listZoneActions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the parent zone:
   *     `projects/{project_number}/locations/{location_id}/lakes/{lake_id}/zones/{zone_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListZoneActionsPagedResponse listZoneActions(String parent) {
    ListZoneActionsRequest request = ListZoneActionsRequest.newBuilder().setParent(parent).build();
    return listZoneActions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists action resources in a zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   ListZoneActionsRequest request =
   *       ListZoneActionsRequest.newBuilder()
   *           .setParent(ZoneName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Action element : dataplexServiceClient.listZoneActions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListZoneActionsPagedResponse listZoneActions(ListZoneActionsRequest request) {
    return listZoneActionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists action resources in a zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   ListZoneActionsRequest request =
   *       ListZoneActionsRequest.newBuilder()
   *           .setParent(ZoneName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Action> future =
   *       dataplexServiceClient.listZoneActionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Action element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListZoneActionsRequest, ListZoneActionsPagedResponse>
      listZoneActionsPagedCallable() {
    return stub.listZoneActionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists action resources in a zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   ListZoneActionsRequest request =
   *       ListZoneActionsRequest.newBuilder()
   *           .setParent(ZoneName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListActionsResponse response =
   *         dataplexServiceClient.listZoneActionsCallable().call(request);
   *     for (Action element : response.getActionsList()) {
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
  public final UnaryCallable<ListZoneActionsRequest, ListActionsResponse>
      listZoneActionsCallable() {
    return stub.listZoneActionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an asset resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   ZoneName parent = ZoneName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]");
   *   Asset asset = Asset.newBuilder().build();
   *   String assetId = "assetId-704776149";
   *   Asset response = dataplexServiceClient.createAssetAsync(parent, asset, assetId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the parent zone:
   *     `projects/{project_number}/locations/{location_id}/lakes/{lake_id}/zones/{zone_id}`.
   * @param asset Required. Asset resource.
   * @param assetId Required. Asset identifier. This ID will be used to generate names such as table
   *     names when publishing metadata to Hive Metastore and BigQuery.
   *     <ul>
   *       <li>Must contain only lowercase letters, numbers and hyphens.
   *       <li>Must start with a letter.
   *       <li>Must end with a number or a letter.
   *       <li>Must be between 1-63 characters.
   *       <li>Must be unique within the zone.
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Asset, OperationMetadata> createAssetAsync(
      ZoneName parent, Asset asset, String assetId) {
    CreateAssetRequest request =
        CreateAssetRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setAsset(asset)
            .setAssetId(assetId)
            .build();
    return createAssetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an asset resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   String parent = ZoneName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]").toString();
   *   Asset asset = Asset.newBuilder().build();
   *   String assetId = "assetId-704776149";
   *   Asset response = dataplexServiceClient.createAssetAsync(parent, asset, assetId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the parent zone:
   *     `projects/{project_number}/locations/{location_id}/lakes/{lake_id}/zones/{zone_id}`.
   * @param asset Required. Asset resource.
   * @param assetId Required. Asset identifier. This ID will be used to generate names such as table
   *     names when publishing metadata to Hive Metastore and BigQuery.
   *     <ul>
   *       <li>Must contain only lowercase letters, numbers and hyphens.
   *       <li>Must start with a letter.
   *       <li>Must end with a number or a letter.
   *       <li>Must be between 1-63 characters.
   *       <li>Must be unique within the zone.
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Asset, OperationMetadata> createAssetAsync(
      String parent, Asset asset, String assetId) {
    CreateAssetRequest request =
        CreateAssetRequest.newBuilder()
            .setParent(parent)
            .setAsset(asset)
            .setAssetId(assetId)
            .build();
    return createAssetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an asset resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   CreateAssetRequest request =
   *       CreateAssetRequest.newBuilder()
   *           .setParent(ZoneName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]").toString())
   *           .setAssetId("assetId-704776149")
   *           .setAsset(Asset.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   Asset response = dataplexServiceClient.createAssetAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Asset, OperationMetadata> createAssetAsync(
      CreateAssetRequest request) {
    return createAssetOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an asset resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   CreateAssetRequest request =
   *       CreateAssetRequest.newBuilder()
   *           .setParent(ZoneName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]").toString())
   *           .setAssetId("assetId-704776149")
   *           .setAsset(Asset.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Asset, OperationMetadata> future =
   *       dataplexServiceClient.createAssetOperationCallable().futureCall(request);
   *   // Do something.
   *   Asset response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateAssetRequest, Asset, OperationMetadata>
      createAssetOperationCallable() {
    return stub.createAssetOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an asset resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   CreateAssetRequest request =
   *       CreateAssetRequest.newBuilder()
   *           .setParent(ZoneName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]").toString())
   *           .setAssetId("assetId-704776149")
   *           .setAsset(Asset.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future = dataplexServiceClient.createAssetCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateAssetRequest, Operation> createAssetCallable() {
    return stub.createAssetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an asset resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   Asset asset = Asset.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Asset response = dataplexServiceClient.updateAssetAsync(asset, updateMask).get();
   * }
   * }</pre>
   *
   * @param asset Required. Update description. Only fields specified in `update_mask` are updated.
   * @param updateMask Required. Mask of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Asset, OperationMetadata> updateAssetAsync(
      Asset asset, FieldMask updateMask) {
    UpdateAssetRequest request =
        UpdateAssetRequest.newBuilder().setAsset(asset).setUpdateMask(updateMask).build();
    return updateAssetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an asset resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   UpdateAssetRequest request =
   *       UpdateAssetRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAsset(Asset.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   Asset response = dataplexServiceClient.updateAssetAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Asset, OperationMetadata> updateAssetAsync(
      UpdateAssetRequest request) {
    return updateAssetOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an asset resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   UpdateAssetRequest request =
   *       UpdateAssetRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAsset(Asset.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Asset, OperationMetadata> future =
   *       dataplexServiceClient.updateAssetOperationCallable().futureCall(request);
   *   // Do something.
   *   Asset response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateAssetRequest, Asset, OperationMetadata>
      updateAssetOperationCallable() {
    return stub.updateAssetOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an asset resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   UpdateAssetRequest request =
   *       UpdateAssetRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAsset(Asset.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future = dataplexServiceClient.updateAssetCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateAssetRequest, Operation> updateAssetCallable() {
    return stub.updateAssetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an asset resource. The referenced storage resource is detached (default) or deleted
   * based on the associated Lifecycle policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   AssetName name = AssetName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ASSET]");
   *   dataplexServiceClient.deleteAssetAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the asset:
   *     `projects/{project_number}/locations/{location_id}/lakes/{lake_id}/zones/{zone_id}/assets/{asset_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteAssetAsync(AssetName name) {
    DeleteAssetRequest request =
        DeleteAssetRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteAssetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an asset resource. The referenced storage resource is detached (default) or deleted
   * based on the associated Lifecycle policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   String name =
   *       AssetName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ASSET]").toString();
   *   dataplexServiceClient.deleteAssetAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the asset:
   *     `projects/{project_number}/locations/{location_id}/lakes/{lake_id}/zones/{zone_id}/assets/{asset_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteAssetAsync(String name) {
    DeleteAssetRequest request = DeleteAssetRequest.newBuilder().setName(name).build();
    return deleteAssetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an asset resource. The referenced storage resource is detached (default) or deleted
   * based on the associated Lifecycle policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   DeleteAssetRequest request =
   *       DeleteAssetRequest.newBuilder()
   *           .setName(
   *               AssetName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ASSET]").toString())
   *           .build();
   *   dataplexServiceClient.deleteAssetAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteAssetAsync(
      DeleteAssetRequest request) {
    return deleteAssetOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an asset resource. The referenced storage resource is detached (default) or deleted
   * based on the associated Lifecycle policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   DeleteAssetRequest request =
   *       DeleteAssetRequest.newBuilder()
   *           .setName(
   *               AssetName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ASSET]").toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       dataplexServiceClient.deleteAssetOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteAssetRequest, Empty, OperationMetadata>
      deleteAssetOperationCallable() {
    return stub.deleteAssetOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an asset resource. The referenced storage resource is detached (default) or deleted
   * based on the associated Lifecycle policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   DeleteAssetRequest request =
   *       DeleteAssetRequest.newBuilder()
   *           .setName(
   *               AssetName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ASSET]").toString())
   *           .build();
   *   ApiFuture<Operation> future = dataplexServiceClient.deleteAssetCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteAssetRequest, Operation> deleteAssetCallable() {
    return stub.deleteAssetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists asset resources in a zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   ZoneName parent = ZoneName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]");
   *   for (Asset element : dataplexServiceClient.listAssets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the parent zone:
   *     `projects/{project_number}/locations/{location_id}/lakes/{lake_id}/zones/{zone_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAssetsPagedResponse listAssets(ZoneName parent) {
    ListAssetsRequest request =
        ListAssetsRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listAssets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists asset resources in a zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   String parent = ZoneName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]").toString();
   *   for (Asset element : dataplexServiceClient.listAssets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the parent zone:
   *     `projects/{project_number}/locations/{location_id}/lakes/{lake_id}/zones/{zone_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAssetsPagedResponse listAssets(String parent) {
    ListAssetsRequest request = ListAssetsRequest.newBuilder().setParent(parent).build();
    return listAssets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists asset resources in a zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   ListAssetsRequest request =
   *       ListAssetsRequest.newBuilder()
   *           .setParent(ZoneName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Asset element : dataplexServiceClient.listAssets(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAssetsPagedResponse listAssets(ListAssetsRequest request) {
    return listAssetsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists asset resources in a zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   ListAssetsRequest request =
   *       ListAssetsRequest.newBuilder()
   *           .setParent(ZoneName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Asset> future = dataplexServiceClient.listAssetsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Asset element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAssetsRequest, ListAssetsPagedResponse> listAssetsPagedCallable() {
    return stub.listAssetsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists asset resources in a zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   ListAssetsRequest request =
   *       ListAssetsRequest.newBuilder()
   *           .setParent(ZoneName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListAssetsResponse response = dataplexServiceClient.listAssetsCallable().call(request);
   *     for (Asset element : response.getAssetsList()) {
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
  public final UnaryCallable<ListAssetsRequest, ListAssetsResponse> listAssetsCallable() {
    return stub.listAssetsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an asset resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   AssetName name = AssetName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ASSET]");
   *   Asset response = dataplexServiceClient.getAsset(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the asset:
   *     `projects/{project_number}/locations/{location_id}/lakes/{lake_id}/zones/{zone_id}/assets/{asset_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Asset getAsset(AssetName name) {
    GetAssetRequest request =
        GetAssetRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getAsset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an asset resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   String name =
   *       AssetName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ASSET]").toString();
   *   Asset response = dataplexServiceClient.getAsset(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the asset:
   *     `projects/{project_number}/locations/{location_id}/lakes/{lake_id}/zones/{zone_id}/assets/{asset_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Asset getAsset(String name) {
    GetAssetRequest request = GetAssetRequest.newBuilder().setName(name).build();
    return getAsset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an asset resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   GetAssetRequest request =
   *       GetAssetRequest.newBuilder()
   *           .setName(
   *               AssetName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ASSET]").toString())
   *           .build();
   *   Asset response = dataplexServiceClient.getAsset(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Asset getAsset(GetAssetRequest request) {
    return getAssetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an asset resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   GetAssetRequest request =
   *       GetAssetRequest.newBuilder()
   *           .setName(
   *               AssetName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ASSET]").toString())
   *           .build();
   *   ApiFuture<Asset> future = dataplexServiceClient.getAssetCallable().futureCall(request);
   *   // Do something.
   *   Asset response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAssetRequest, Asset> getAssetCallable() {
    return stub.getAssetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists action resources in an asset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   AssetName parent = AssetName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ASSET]");
   *   for (Action element : dataplexServiceClient.listAssetActions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the parent asset:
   *     `projects/{project_number}/locations/{location_id}/lakes/{lake_id}/zones/{zone_id}/assets/{asset_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAssetActionsPagedResponse listAssetActions(AssetName parent) {
    ListAssetActionsRequest request =
        ListAssetActionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAssetActions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists action resources in an asset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   String parent =
   *       AssetName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ASSET]").toString();
   *   for (Action element : dataplexServiceClient.listAssetActions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the parent asset:
   *     `projects/{project_number}/locations/{location_id}/lakes/{lake_id}/zones/{zone_id}/assets/{asset_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAssetActionsPagedResponse listAssetActions(String parent) {
    ListAssetActionsRequest request =
        ListAssetActionsRequest.newBuilder().setParent(parent).build();
    return listAssetActions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists action resources in an asset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   ListAssetActionsRequest request =
   *       ListAssetActionsRequest.newBuilder()
   *           .setParent(
   *               AssetName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ASSET]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Action element : dataplexServiceClient.listAssetActions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAssetActionsPagedResponse listAssetActions(ListAssetActionsRequest request) {
    return listAssetActionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists action resources in an asset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   ListAssetActionsRequest request =
   *       ListAssetActionsRequest.newBuilder()
   *           .setParent(
   *               AssetName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ASSET]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Action> future =
   *       dataplexServiceClient.listAssetActionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Action element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAssetActionsRequest, ListAssetActionsPagedResponse>
      listAssetActionsPagedCallable() {
    return stub.listAssetActionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists action resources in an asset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   ListAssetActionsRequest request =
   *       ListAssetActionsRequest.newBuilder()
   *           .setParent(
   *               AssetName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ASSET]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListActionsResponse response =
   *         dataplexServiceClient.listAssetActionsCallable().call(request);
   *     for (Action element : response.getActionsList()) {
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
  public final UnaryCallable<ListAssetActionsRequest, ListActionsResponse>
      listAssetActionsCallable() {
    return stub.listAssetActionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a task resource within a lake.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   LakeName parent = LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]");
   *   Task task = Task.newBuilder().build();
   *   String taskId = "taskId-880873088";
   *   Task response = dataplexServiceClient.createTaskAsync(parent, task, taskId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the parent lake:
   *     `projects/{project_number}/locations/{location_id}/lakes/{lake_id}`.
   * @param task Required. Task resource.
   * @param taskId Required. Task identifier.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Task, OperationMetadata> createTaskAsync(
      LakeName parent, Task task, String taskId) {
    CreateTaskRequest request =
        CreateTaskRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setTask(task)
            .setTaskId(taskId)
            .build();
    return createTaskAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a task resource within a lake.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   String parent = LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]").toString();
   *   Task task = Task.newBuilder().build();
   *   String taskId = "taskId-880873088";
   *   Task response = dataplexServiceClient.createTaskAsync(parent, task, taskId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the parent lake:
   *     `projects/{project_number}/locations/{location_id}/lakes/{lake_id}`.
   * @param task Required. Task resource.
   * @param taskId Required. Task identifier.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Task, OperationMetadata> createTaskAsync(
      String parent, Task task, String taskId) {
    CreateTaskRequest request =
        CreateTaskRequest.newBuilder().setParent(parent).setTask(task).setTaskId(taskId).build();
    return createTaskAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a task resource within a lake.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   CreateTaskRequest request =
   *       CreateTaskRequest.newBuilder()
   *           .setParent(LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]").toString())
   *           .setTaskId("taskId-880873088")
   *           .setTask(Task.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   Task response = dataplexServiceClient.createTaskAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Task, OperationMetadata> createTaskAsync(CreateTaskRequest request) {
    return createTaskOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a task resource within a lake.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   CreateTaskRequest request =
   *       CreateTaskRequest.newBuilder()
   *           .setParent(LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]").toString())
   *           .setTaskId("taskId-880873088")
   *           .setTask(Task.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Task, OperationMetadata> future =
   *       dataplexServiceClient.createTaskOperationCallable().futureCall(request);
   *   // Do something.
   *   Task response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateTaskRequest, Task, OperationMetadata>
      createTaskOperationCallable() {
    return stub.createTaskOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a task resource within a lake.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   CreateTaskRequest request =
   *       CreateTaskRequest.newBuilder()
   *           .setParent(LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]").toString())
   *           .setTaskId("taskId-880873088")
   *           .setTask(Task.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future = dataplexServiceClient.createTaskCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateTaskRequest, Operation> createTaskCallable() {
    return stub.createTaskCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update the task resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   Task task = Task.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Task response = dataplexServiceClient.updateTaskAsync(task, updateMask).get();
   * }
   * }</pre>
   *
   * @param task Required. Update description. Only fields specified in `update_mask` are updated.
   * @param updateMask Required. Mask of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Task, OperationMetadata> updateTaskAsync(
      Task task, FieldMask updateMask) {
    UpdateTaskRequest request =
        UpdateTaskRequest.newBuilder().setTask(task).setUpdateMask(updateMask).build();
    return updateTaskAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update the task resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   UpdateTaskRequest request =
   *       UpdateTaskRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setTask(Task.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   Task response = dataplexServiceClient.updateTaskAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Task, OperationMetadata> updateTaskAsync(UpdateTaskRequest request) {
    return updateTaskOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update the task resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   UpdateTaskRequest request =
   *       UpdateTaskRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setTask(Task.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Task, OperationMetadata> future =
   *       dataplexServiceClient.updateTaskOperationCallable().futureCall(request);
   *   // Do something.
   *   Task response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateTaskRequest, Task, OperationMetadata>
      updateTaskOperationCallable() {
    return stub.updateTaskOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update the task resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   UpdateTaskRequest request =
   *       UpdateTaskRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setTask(Task.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future = dataplexServiceClient.updateTaskCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateTaskRequest, Operation> updateTaskCallable() {
    return stub.updateTaskCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete the task resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   TaskName name = TaskName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[TASK]");
   *   dataplexServiceClient.deleteTaskAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the task:
   *     `projects/{project_number}/locations/{location_id}/lakes/{lake_id}/task/{task_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteTaskAsync(TaskName name) {
    DeleteTaskRequest request =
        DeleteTaskRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteTaskAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete the task resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   String name = TaskName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[TASK]").toString();
   *   dataplexServiceClient.deleteTaskAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the task:
   *     `projects/{project_number}/locations/{location_id}/lakes/{lake_id}/task/{task_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteTaskAsync(String name) {
    DeleteTaskRequest request = DeleteTaskRequest.newBuilder().setName(name).build();
    return deleteTaskAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete the task resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   DeleteTaskRequest request =
   *       DeleteTaskRequest.newBuilder()
   *           .setName(TaskName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[TASK]").toString())
   *           .build();
   *   dataplexServiceClient.deleteTaskAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteTaskAsync(
      DeleteTaskRequest request) {
    return deleteTaskOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete the task resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   DeleteTaskRequest request =
   *       DeleteTaskRequest.newBuilder()
   *           .setName(TaskName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[TASK]").toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       dataplexServiceClient.deleteTaskOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteTaskRequest, Empty, OperationMetadata>
      deleteTaskOperationCallable() {
    return stub.deleteTaskOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete the task resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   DeleteTaskRequest request =
   *       DeleteTaskRequest.newBuilder()
   *           .setName(TaskName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[TASK]").toString())
   *           .build();
   *   ApiFuture<Operation> future = dataplexServiceClient.deleteTaskCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteTaskRequest, Operation> deleteTaskCallable() {
    return stub.deleteTaskCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists tasks under the given lake.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   LakeName parent = LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]");
   *   for (Task element : dataplexServiceClient.listTasks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the parent lake:
   *     `projects/{project_number}/locations/{location_id}/lakes/{lake_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTasksPagedResponse listTasks(LakeName parent) {
    ListTasksRequest request =
        ListTasksRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listTasks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists tasks under the given lake.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   String parent = LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]").toString();
   *   for (Task element : dataplexServiceClient.listTasks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the parent lake:
   *     `projects/{project_number}/locations/{location_id}/lakes/{lake_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTasksPagedResponse listTasks(String parent) {
    ListTasksRequest request = ListTasksRequest.newBuilder().setParent(parent).build();
    return listTasks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists tasks under the given lake.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   ListTasksRequest request =
   *       ListTasksRequest.newBuilder()
   *           .setParent(LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Task element : dataplexServiceClient.listTasks(request).iterateAll()) {
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
   * Lists tasks under the given lake.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   ListTasksRequest request =
   *       ListTasksRequest.newBuilder()
   *           .setParent(LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Task> future = dataplexServiceClient.listTasksPagedCallable().futureCall(request);
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
   * Lists tasks under the given lake.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   ListTasksRequest request =
   *       ListTasksRequest.newBuilder()
   *           .setParent(LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListTasksResponse response = dataplexServiceClient.listTasksCallable().call(request);
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
   * Get task resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   TaskName name = TaskName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[TASK]");
   *   Task response = dataplexServiceClient.getTask(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the task:
   *     `projects/{project_number}/locations/{location_id}/lakes/{lake_id}/tasks/{tasks_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Task getTask(TaskName name) {
    GetTaskRequest request =
        GetTaskRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getTask(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get task resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   String name = TaskName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[TASK]").toString();
   *   Task response = dataplexServiceClient.getTask(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the task:
   *     `projects/{project_number}/locations/{location_id}/lakes/{lake_id}/tasks/{tasks_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Task getTask(String name) {
    GetTaskRequest request = GetTaskRequest.newBuilder().setName(name).build();
    return getTask(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get task resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   GetTaskRequest request =
   *       GetTaskRequest.newBuilder()
   *           .setName(TaskName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[TASK]").toString())
   *           .build();
   *   Task response = dataplexServiceClient.getTask(request);
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
   * Get task resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   GetTaskRequest request =
   *       GetTaskRequest.newBuilder()
   *           .setName(TaskName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[TASK]").toString())
   *           .build();
   *   ApiFuture<Task> future = dataplexServiceClient.getTaskCallable().futureCall(request);
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
   * Lists Jobs under the given task.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   TaskName parent = TaskName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[TASK]");
   *   for (Job element : dataplexServiceClient.listJobs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the parent environment:
   *     `projects/{project_number}/locations/{location_id}/lakes/{lake_id}/tasks/{task_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListJobsPagedResponse listJobs(TaskName parent) {
    ListJobsRequest request =
        ListJobsRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listJobs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Jobs under the given task.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   String parent = TaskName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[TASK]").toString();
   *   for (Job element : dataplexServiceClient.listJobs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the parent environment:
   *     `projects/{project_number}/locations/{location_id}/lakes/{lake_id}/tasks/{task_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListJobsPagedResponse listJobs(String parent) {
    ListJobsRequest request = ListJobsRequest.newBuilder().setParent(parent).build();
    return listJobs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Jobs under the given task.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   ListJobsRequest request =
   *       ListJobsRequest.newBuilder()
   *           .setParent(TaskName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[TASK]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Job element : dataplexServiceClient.listJobs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListJobsPagedResponse listJobs(ListJobsRequest request) {
    return listJobsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Jobs under the given task.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   ListJobsRequest request =
   *       ListJobsRequest.newBuilder()
   *           .setParent(TaskName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[TASK]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Job> future = dataplexServiceClient.listJobsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Job element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListJobsRequest, ListJobsPagedResponse> listJobsPagedCallable() {
    return stub.listJobsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Jobs under the given task.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   ListJobsRequest request =
   *       ListJobsRequest.newBuilder()
   *           .setParent(TaskName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[TASK]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListJobsResponse response = dataplexServiceClient.listJobsCallable().call(request);
   *     for (Job element : response.getJobsList()) {
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
  public final UnaryCallable<ListJobsRequest, ListJobsResponse> listJobsCallable() {
    return stub.listJobsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get job resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   JobName name = JobName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[TASK]", "[JOB]");
   *   Job response = dataplexServiceClient.getJob(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the job:
   *     `projects/{project_number}/locations/{location_id}/lakes/{lake_id}/tasks/{task_id}/jobs/{job_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Job getJob(JobName name) {
    GetJobRequest request =
        GetJobRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get job resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   String name = JobName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[TASK]", "[JOB]").toString();
   *   Job response = dataplexServiceClient.getJob(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the job:
   *     `projects/{project_number}/locations/{location_id}/lakes/{lake_id}/tasks/{task_id}/jobs/{job_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Job getJob(String name) {
    GetJobRequest request = GetJobRequest.newBuilder().setName(name).build();
    return getJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get job resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   GetJobRequest request =
   *       GetJobRequest.newBuilder()
   *           .setName(
   *               JobName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[TASK]", "[JOB]").toString())
   *           .build();
   *   Job response = dataplexServiceClient.getJob(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Job getJob(GetJobRequest request) {
    return getJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get job resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   GetJobRequest request =
   *       GetJobRequest.newBuilder()
   *           .setName(
   *               JobName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[TASK]", "[JOB]").toString())
   *           .build();
   *   ApiFuture<Job> future = dataplexServiceClient.getJobCallable().futureCall(request);
   *   // Do something.
   *   Job response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetJobRequest, Job> getJobCallable() {
    return stub.getJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancel jobs running for the task resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   JobName name = JobName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[TASK]", "[JOB]");
   *   dataplexServiceClient.cancelJob(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the job:
   *     `projects/{project_number}/locations/{location_id}/lakes/{lake_id}/task/{task_id}/job/{job_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void cancelJob(JobName name) {
    CancelJobRequest request =
        CancelJobRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    cancelJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancel jobs running for the task resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   String name = JobName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[TASK]", "[JOB]").toString();
   *   dataplexServiceClient.cancelJob(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the job:
   *     `projects/{project_number}/locations/{location_id}/lakes/{lake_id}/task/{task_id}/job/{job_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void cancelJob(String name) {
    CancelJobRequest request = CancelJobRequest.newBuilder().setName(name).build();
    cancelJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancel jobs running for the task resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   CancelJobRequest request =
   *       CancelJobRequest.newBuilder()
   *           .setName(
   *               JobName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[TASK]", "[JOB]").toString())
   *           .build();
   *   dataplexServiceClient.cancelJob(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void cancelJob(CancelJobRequest request) {
    cancelJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancel jobs running for the task resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   CancelJobRequest request =
   *       CancelJobRequest.newBuilder()
   *           .setName(
   *               JobName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[TASK]", "[JOB]").toString())
   *           .build();
   *   ApiFuture<Empty> future = dataplexServiceClient.cancelJobCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CancelJobRequest, Empty> cancelJobCallable() {
    return stub.cancelJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create an environment resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   LakeName parent = LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]");
   *   Environment environment = Environment.newBuilder().build();
   *   String environmentId = "environmentId-950205810";
   *   Environment response =
   *       dataplexServiceClient.createEnvironmentAsync(parent, environment, environmentId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the parent lake:
   *     `projects/{project_id}/locations/{location_id}/lakes/{lake_id}`.
   * @param environment Required. Environment resource.
   * @param environmentId Required. Environment identifier.
   *     <ul>
   *       <li>Must contain only lowercase letters, numbers and hyphens.
   *       <li>Must start with a letter.
   *       <li>Must be between 1-63 characters.
   *       <li>Must end with a number or a letter.
   *       <li>Must be unique within the lake.
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Environment, OperationMetadata> createEnvironmentAsync(
      LakeName parent, Environment environment, String environmentId) {
    CreateEnvironmentRequest request =
        CreateEnvironmentRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setEnvironment(environment)
            .setEnvironmentId(environmentId)
            .build();
    return createEnvironmentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create an environment resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   String parent = LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]").toString();
   *   Environment environment = Environment.newBuilder().build();
   *   String environmentId = "environmentId-950205810";
   *   Environment response =
   *       dataplexServiceClient.createEnvironmentAsync(parent, environment, environmentId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the parent lake:
   *     `projects/{project_id}/locations/{location_id}/lakes/{lake_id}`.
   * @param environment Required. Environment resource.
   * @param environmentId Required. Environment identifier.
   *     <ul>
   *       <li>Must contain only lowercase letters, numbers and hyphens.
   *       <li>Must start with a letter.
   *       <li>Must be between 1-63 characters.
   *       <li>Must end with a number or a letter.
   *       <li>Must be unique within the lake.
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Environment, OperationMetadata> createEnvironmentAsync(
      String parent, Environment environment, String environmentId) {
    CreateEnvironmentRequest request =
        CreateEnvironmentRequest.newBuilder()
            .setParent(parent)
            .setEnvironment(environment)
            .setEnvironmentId(environmentId)
            .build();
    return createEnvironmentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create an environment resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   CreateEnvironmentRequest request =
   *       CreateEnvironmentRequest.newBuilder()
   *           .setParent(LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]").toString())
   *           .setEnvironmentId("environmentId-950205810")
   *           .setEnvironment(Environment.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   Environment response = dataplexServiceClient.createEnvironmentAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Environment, OperationMetadata> createEnvironmentAsync(
      CreateEnvironmentRequest request) {
    return createEnvironmentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create an environment resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   CreateEnvironmentRequest request =
   *       CreateEnvironmentRequest.newBuilder()
   *           .setParent(LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]").toString())
   *           .setEnvironmentId("environmentId-950205810")
   *           .setEnvironment(Environment.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Environment, OperationMetadata> future =
   *       dataplexServiceClient.createEnvironmentOperationCallable().futureCall(request);
   *   // Do something.
   *   Environment response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateEnvironmentRequest, Environment, OperationMetadata>
      createEnvironmentOperationCallable() {
    return stub.createEnvironmentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create an environment resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   CreateEnvironmentRequest request =
   *       CreateEnvironmentRequest.newBuilder()
   *           .setParent(LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]").toString())
   *           .setEnvironmentId("environmentId-950205810")
   *           .setEnvironment(Environment.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       dataplexServiceClient.createEnvironmentCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateEnvironmentRequest, Operation> createEnvironmentCallable() {
    return stub.createEnvironmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update the environment resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   Environment environment = Environment.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Environment response =
   *       dataplexServiceClient.updateEnvironmentAsync(environment, updateMask).get();
   * }
   * }</pre>
   *
   * @param environment Required. Update description. Only fields specified in `update_mask` are
   *     updated.
   * @param updateMask Required. Mask of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Environment, OperationMetadata> updateEnvironmentAsync(
      Environment environment, FieldMask updateMask) {
    UpdateEnvironmentRequest request =
        UpdateEnvironmentRequest.newBuilder()
            .setEnvironment(environment)
            .setUpdateMask(updateMask)
            .build();
    return updateEnvironmentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update the environment resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   UpdateEnvironmentRequest request =
   *       UpdateEnvironmentRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setEnvironment(Environment.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   Environment response = dataplexServiceClient.updateEnvironmentAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Environment, OperationMetadata> updateEnvironmentAsync(
      UpdateEnvironmentRequest request) {
    return updateEnvironmentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update the environment resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   UpdateEnvironmentRequest request =
   *       UpdateEnvironmentRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setEnvironment(Environment.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Environment, OperationMetadata> future =
   *       dataplexServiceClient.updateEnvironmentOperationCallable().futureCall(request);
   *   // Do something.
   *   Environment response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateEnvironmentRequest, Environment, OperationMetadata>
      updateEnvironmentOperationCallable() {
    return stub.updateEnvironmentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update the environment resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   UpdateEnvironmentRequest request =
   *       UpdateEnvironmentRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setEnvironment(Environment.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       dataplexServiceClient.updateEnvironmentCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateEnvironmentRequest, Operation> updateEnvironmentCallable() {
    return stub.updateEnvironmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete the environment resource. All the child resources must have been deleted before
   * environment deletion can be initiated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   EnvironmentName name =
   *       EnvironmentName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ENVIRONMENT]");
   *   dataplexServiceClient.deleteEnvironmentAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the environment:
   *     `projects/{project_id}/locations/{location_id}/lakes/{lake_id}/environments/{environment_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteEnvironmentAsync(
      EnvironmentName name) {
    DeleteEnvironmentRequest request =
        DeleteEnvironmentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteEnvironmentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete the environment resource. All the child resources must have been deleted before
   * environment deletion can be initiated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   String name =
   *       EnvironmentName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ENVIRONMENT]").toString();
   *   dataplexServiceClient.deleteEnvironmentAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the environment:
   *     `projects/{project_id}/locations/{location_id}/lakes/{lake_id}/environments/{environment_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteEnvironmentAsync(String name) {
    DeleteEnvironmentRequest request = DeleteEnvironmentRequest.newBuilder().setName(name).build();
    return deleteEnvironmentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete the environment resource. All the child resources must have been deleted before
   * environment deletion can be initiated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   DeleteEnvironmentRequest request =
   *       DeleteEnvironmentRequest.newBuilder()
   *           .setName(
   *               EnvironmentName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ENVIRONMENT]")
   *                   .toString())
   *           .build();
   *   dataplexServiceClient.deleteEnvironmentAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteEnvironmentAsync(
      DeleteEnvironmentRequest request) {
    return deleteEnvironmentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete the environment resource. All the child resources must have been deleted before
   * environment deletion can be initiated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   DeleteEnvironmentRequest request =
   *       DeleteEnvironmentRequest.newBuilder()
   *           .setName(
   *               EnvironmentName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ENVIRONMENT]")
   *                   .toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       dataplexServiceClient.deleteEnvironmentOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteEnvironmentRequest, Empty, OperationMetadata>
      deleteEnvironmentOperationCallable() {
    return stub.deleteEnvironmentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete the environment resource. All the child resources must have been deleted before
   * environment deletion can be initiated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   DeleteEnvironmentRequest request =
   *       DeleteEnvironmentRequest.newBuilder()
   *           .setName(
   *               EnvironmentName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ENVIRONMENT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       dataplexServiceClient.deleteEnvironmentCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteEnvironmentRequest, Operation> deleteEnvironmentCallable() {
    return stub.deleteEnvironmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists environments under the given lake.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   LakeName parent = LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]");
   *   for (Environment element : dataplexServiceClient.listEnvironments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the parent lake:
   *     `projects/{project_id}/locations/{location_id}/lakes/{lake_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEnvironmentsPagedResponse listEnvironments(LakeName parent) {
    ListEnvironmentsRequest request =
        ListEnvironmentsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listEnvironments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists environments under the given lake.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   String parent = LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]").toString();
   *   for (Environment element : dataplexServiceClient.listEnvironments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the parent lake:
   *     `projects/{project_id}/locations/{location_id}/lakes/{lake_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEnvironmentsPagedResponse listEnvironments(String parent) {
    ListEnvironmentsRequest request =
        ListEnvironmentsRequest.newBuilder().setParent(parent).build();
    return listEnvironments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists environments under the given lake.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   ListEnvironmentsRequest request =
   *       ListEnvironmentsRequest.newBuilder()
   *           .setParent(LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Environment element : dataplexServiceClient.listEnvironments(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEnvironmentsPagedResponse listEnvironments(ListEnvironmentsRequest request) {
    return listEnvironmentsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists environments under the given lake.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   ListEnvironmentsRequest request =
   *       ListEnvironmentsRequest.newBuilder()
   *           .setParent(LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Environment> future =
   *       dataplexServiceClient.listEnvironmentsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Environment element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListEnvironmentsRequest, ListEnvironmentsPagedResponse>
      listEnvironmentsPagedCallable() {
    return stub.listEnvironmentsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists environments under the given lake.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   ListEnvironmentsRequest request =
   *       ListEnvironmentsRequest.newBuilder()
   *           .setParent(LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListEnvironmentsResponse response =
   *         dataplexServiceClient.listEnvironmentsCallable().call(request);
   *     for (Environment element : response.getEnvironmentsList()) {
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
  public final UnaryCallable<ListEnvironmentsRequest, ListEnvironmentsResponse>
      listEnvironmentsCallable() {
    return stub.listEnvironmentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get environment resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   EnvironmentName name =
   *       EnvironmentName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ENVIRONMENT]");
   *   Environment response = dataplexServiceClient.getEnvironment(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the environment:
   *     `projects/{project_id}/locations/{location_id}/lakes/{lake_id}/environments/{environment_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Environment getEnvironment(EnvironmentName name) {
    GetEnvironmentRequest request =
        GetEnvironmentRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getEnvironment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get environment resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   String name =
   *       EnvironmentName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ENVIRONMENT]").toString();
   *   Environment response = dataplexServiceClient.getEnvironment(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the environment:
   *     `projects/{project_id}/locations/{location_id}/lakes/{lake_id}/environments/{environment_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Environment getEnvironment(String name) {
    GetEnvironmentRequest request = GetEnvironmentRequest.newBuilder().setName(name).build();
    return getEnvironment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get environment resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   GetEnvironmentRequest request =
   *       GetEnvironmentRequest.newBuilder()
   *           .setName(
   *               EnvironmentName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ENVIRONMENT]")
   *                   .toString())
   *           .build();
   *   Environment response = dataplexServiceClient.getEnvironment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Environment getEnvironment(GetEnvironmentRequest request) {
    return getEnvironmentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get environment resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   GetEnvironmentRequest request =
   *       GetEnvironmentRequest.newBuilder()
   *           .setName(
   *               EnvironmentName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ENVIRONMENT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Environment> future =
   *       dataplexServiceClient.getEnvironmentCallable().futureCall(request);
   *   // Do something.
   *   Environment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetEnvironmentRequest, Environment> getEnvironmentCallable() {
    return stub.getEnvironmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists session resources in an environment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   EnvironmentName parent =
   *       EnvironmentName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ENVIRONMENT]");
   *   for (Session element : dataplexServiceClient.listSessions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the parent environment:
   *     `projects/{project_number}/locations/{location_id}/lakes/{lake_id}/environment/{environment_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSessionsPagedResponse listSessions(EnvironmentName parent) {
    ListSessionsRequest request =
        ListSessionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listSessions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists session resources in an environment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   String parent =
   *       EnvironmentName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ENVIRONMENT]").toString();
   *   for (Session element : dataplexServiceClient.listSessions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the parent environment:
   *     `projects/{project_number}/locations/{location_id}/lakes/{lake_id}/environment/{environment_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSessionsPagedResponse listSessions(String parent) {
    ListSessionsRequest request = ListSessionsRequest.newBuilder().setParent(parent).build();
    return listSessions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists session resources in an environment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   ListSessionsRequest request =
   *       ListSessionsRequest.newBuilder()
   *           .setParent(
   *               EnvironmentName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ENVIRONMENT]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (Session element : dataplexServiceClient.listSessions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSessionsPagedResponse listSessions(ListSessionsRequest request) {
    return listSessionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists session resources in an environment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   ListSessionsRequest request =
   *       ListSessionsRequest.newBuilder()
   *           .setParent(
   *               EnvironmentName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ENVIRONMENT]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<Session> future =
   *       dataplexServiceClient.listSessionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Session element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListSessionsRequest, ListSessionsPagedResponse>
      listSessionsPagedCallable() {
    return stub.listSessionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists session resources in an environment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   ListSessionsRequest request =
   *       ListSessionsRequest.newBuilder()
   *           .setParent(
   *               EnvironmentName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ENVIRONMENT]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListSessionsResponse response = dataplexServiceClient.listSessionsCallable().call(request);
   *     for (Session element : response.getSessionsList()) {
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
  public final UnaryCallable<ListSessionsRequest, ListSessionsResponse> listSessionsCallable() {
    return stub.listSessionsCallable();
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
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : dataplexServiceClient.listLocations(request).iterateAll()) {
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
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       dataplexServiceClient.listLocationsPagedCallable().futureCall(request);
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
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         dataplexServiceClient.listLocationsCallable().call(request);
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
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = dataplexServiceClient.getLocation(request);
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
   * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = dataplexServiceClient.getLocationCallable().futureCall(request);
   *   // Do something.
   *   Location response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return stub.getLocationCallable();
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

  public static class ListLakesPagedResponse
      extends AbstractPagedListResponse<
          ListLakesRequest, ListLakesResponse, Lake, ListLakesPage, ListLakesFixedSizeCollection> {

    public static ApiFuture<ListLakesPagedResponse> createAsync(
        PageContext<ListLakesRequest, ListLakesResponse, Lake> context,
        ApiFuture<ListLakesResponse> futureResponse) {
      ApiFuture<ListLakesPage> futurePage =
          ListLakesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListLakesPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListLakesPagedResponse(ListLakesPage page) {
      super(page, ListLakesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListLakesPage
      extends AbstractPage<ListLakesRequest, ListLakesResponse, Lake, ListLakesPage> {

    private ListLakesPage(
        PageContext<ListLakesRequest, ListLakesResponse, Lake> context,
        ListLakesResponse response) {
      super(context, response);
    }

    private static ListLakesPage createEmptyPage() {
      return new ListLakesPage(null, null);
    }

    @Override
    protected ListLakesPage createPage(
        PageContext<ListLakesRequest, ListLakesResponse, Lake> context,
        ListLakesResponse response) {
      return new ListLakesPage(context, response);
    }

    @Override
    public ApiFuture<ListLakesPage> createPageAsync(
        PageContext<ListLakesRequest, ListLakesResponse, Lake> context,
        ApiFuture<ListLakesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListLakesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListLakesRequest, ListLakesResponse, Lake, ListLakesPage, ListLakesFixedSizeCollection> {

    private ListLakesFixedSizeCollection(List<ListLakesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLakesFixedSizeCollection createEmptyCollection() {
      return new ListLakesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLakesFixedSizeCollection createCollection(
        List<ListLakesPage> pages, int collectionSize) {
      return new ListLakesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListLakeActionsPagedResponse
      extends AbstractPagedListResponse<
          ListLakeActionsRequest,
          ListActionsResponse,
          Action,
          ListLakeActionsPage,
          ListLakeActionsFixedSizeCollection> {

    public static ApiFuture<ListLakeActionsPagedResponse> createAsync(
        PageContext<ListLakeActionsRequest, ListActionsResponse, Action> context,
        ApiFuture<ListActionsResponse> futureResponse) {
      ApiFuture<ListLakeActionsPage> futurePage =
          ListLakeActionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListLakeActionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListLakeActionsPagedResponse(ListLakeActionsPage page) {
      super(page, ListLakeActionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListLakeActionsPage
      extends AbstractPage<
          ListLakeActionsRequest, ListActionsResponse, Action, ListLakeActionsPage> {

    private ListLakeActionsPage(
        PageContext<ListLakeActionsRequest, ListActionsResponse, Action> context,
        ListActionsResponse response) {
      super(context, response);
    }

    private static ListLakeActionsPage createEmptyPage() {
      return new ListLakeActionsPage(null, null);
    }

    @Override
    protected ListLakeActionsPage createPage(
        PageContext<ListLakeActionsRequest, ListActionsResponse, Action> context,
        ListActionsResponse response) {
      return new ListLakeActionsPage(context, response);
    }

    @Override
    public ApiFuture<ListLakeActionsPage> createPageAsync(
        PageContext<ListLakeActionsRequest, ListActionsResponse, Action> context,
        ApiFuture<ListActionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListLakeActionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListLakeActionsRequest,
          ListActionsResponse,
          Action,
          ListLakeActionsPage,
          ListLakeActionsFixedSizeCollection> {

    private ListLakeActionsFixedSizeCollection(
        List<ListLakeActionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLakeActionsFixedSizeCollection createEmptyCollection() {
      return new ListLakeActionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLakeActionsFixedSizeCollection createCollection(
        List<ListLakeActionsPage> pages, int collectionSize) {
      return new ListLakeActionsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListZonesPagedResponse
      extends AbstractPagedListResponse<
          ListZonesRequest, ListZonesResponse, Zone, ListZonesPage, ListZonesFixedSizeCollection> {

    public static ApiFuture<ListZonesPagedResponse> createAsync(
        PageContext<ListZonesRequest, ListZonesResponse, Zone> context,
        ApiFuture<ListZonesResponse> futureResponse) {
      ApiFuture<ListZonesPage> futurePage =
          ListZonesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListZonesPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListZonesPagedResponse(ListZonesPage page) {
      super(page, ListZonesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListZonesPage
      extends AbstractPage<ListZonesRequest, ListZonesResponse, Zone, ListZonesPage> {

    private ListZonesPage(
        PageContext<ListZonesRequest, ListZonesResponse, Zone> context,
        ListZonesResponse response) {
      super(context, response);
    }

    private static ListZonesPage createEmptyPage() {
      return new ListZonesPage(null, null);
    }

    @Override
    protected ListZonesPage createPage(
        PageContext<ListZonesRequest, ListZonesResponse, Zone> context,
        ListZonesResponse response) {
      return new ListZonesPage(context, response);
    }

    @Override
    public ApiFuture<ListZonesPage> createPageAsync(
        PageContext<ListZonesRequest, ListZonesResponse, Zone> context,
        ApiFuture<ListZonesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListZonesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListZonesRequest, ListZonesResponse, Zone, ListZonesPage, ListZonesFixedSizeCollection> {

    private ListZonesFixedSizeCollection(List<ListZonesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListZonesFixedSizeCollection createEmptyCollection() {
      return new ListZonesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListZonesFixedSizeCollection createCollection(
        List<ListZonesPage> pages, int collectionSize) {
      return new ListZonesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListZoneActionsPagedResponse
      extends AbstractPagedListResponse<
          ListZoneActionsRequest,
          ListActionsResponse,
          Action,
          ListZoneActionsPage,
          ListZoneActionsFixedSizeCollection> {

    public static ApiFuture<ListZoneActionsPagedResponse> createAsync(
        PageContext<ListZoneActionsRequest, ListActionsResponse, Action> context,
        ApiFuture<ListActionsResponse> futureResponse) {
      ApiFuture<ListZoneActionsPage> futurePage =
          ListZoneActionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListZoneActionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListZoneActionsPagedResponse(ListZoneActionsPage page) {
      super(page, ListZoneActionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListZoneActionsPage
      extends AbstractPage<
          ListZoneActionsRequest, ListActionsResponse, Action, ListZoneActionsPage> {

    private ListZoneActionsPage(
        PageContext<ListZoneActionsRequest, ListActionsResponse, Action> context,
        ListActionsResponse response) {
      super(context, response);
    }

    private static ListZoneActionsPage createEmptyPage() {
      return new ListZoneActionsPage(null, null);
    }

    @Override
    protected ListZoneActionsPage createPage(
        PageContext<ListZoneActionsRequest, ListActionsResponse, Action> context,
        ListActionsResponse response) {
      return new ListZoneActionsPage(context, response);
    }

    @Override
    public ApiFuture<ListZoneActionsPage> createPageAsync(
        PageContext<ListZoneActionsRequest, ListActionsResponse, Action> context,
        ApiFuture<ListActionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListZoneActionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListZoneActionsRequest,
          ListActionsResponse,
          Action,
          ListZoneActionsPage,
          ListZoneActionsFixedSizeCollection> {

    private ListZoneActionsFixedSizeCollection(
        List<ListZoneActionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListZoneActionsFixedSizeCollection createEmptyCollection() {
      return new ListZoneActionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListZoneActionsFixedSizeCollection createCollection(
        List<ListZoneActionsPage> pages, int collectionSize) {
      return new ListZoneActionsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListAssetsPagedResponse
      extends AbstractPagedListResponse<
          ListAssetsRequest,
          ListAssetsResponse,
          Asset,
          ListAssetsPage,
          ListAssetsFixedSizeCollection> {

    public static ApiFuture<ListAssetsPagedResponse> createAsync(
        PageContext<ListAssetsRequest, ListAssetsResponse, Asset> context,
        ApiFuture<ListAssetsResponse> futureResponse) {
      ApiFuture<ListAssetsPage> futurePage =
          ListAssetsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListAssetsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListAssetsPagedResponse(ListAssetsPage page) {
      super(page, ListAssetsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAssetsPage
      extends AbstractPage<ListAssetsRequest, ListAssetsResponse, Asset, ListAssetsPage> {

    private ListAssetsPage(
        PageContext<ListAssetsRequest, ListAssetsResponse, Asset> context,
        ListAssetsResponse response) {
      super(context, response);
    }

    private static ListAssetsPage createEmptyPage() {
      return new ListAssetsPage(null, null);
    }

    @Override
    protected ListAssetsPage createPage(
        PageContext<ListAssetsRequest, ListAssetsResponse, Asset> context,
        ListAssetsResponse response) {
      return new ListAssetsPage(context, response);
    }

    @Override
    public ApiFuture<ListAssetsPage> createPageAsync(
        PageContext<ListAssetsRequest, ListAssetsResponse, Asset> context,
        ApiFuture<ListAssetsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAssetsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAssetsRequest,
          ListAssetsResponse,
          Asset,
          ListAssetsPage,
          ListAssetsFixedSizeCollection> {

    private ListAssetsFixedSizeCollection(List<ListAssetsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAssetsFixedSizeCollection createEmptyCollection() {
      return new ListAssetsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAssetsFixedSizeCollection createCollection(
        List<ListAssetsPage> pages, int collectionSize) {
      return new ListAssetsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListAssetActionsPagedResponse
      extends AbstractPagedListResponse<
          ListAssetActionsRequest,
          ListActionsResponse,
          Action,
          ListAssetActionsPage,
          ListAssetActionsFixedSizeCollection> {

    public static ApiFuture<ListAssetActionsPagedResponse> createAsync(
        PageContext<ListAssetActionsRequest, ListActionsResponse, Action> context,
        ApiFuture<ListActionsResponse> futureResponse) {
      ApiFuture<ListAssetActionsPage> futurePage =
          ListAssetActionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAssetActionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAssetActionsPagedResponse(ListAssetActionsPage page) {
      super(page, ListAssetActionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAssetActionsPage
      extends AbstractPage<
          ListAssetActionsRequest, ListActionsResponse, Action, ListAssetActionsPage> {

    private ListAssetActionsPage(
        PageContext<ListAssetActionsRequest, ListActionsResponse, Action> context,
        ListActionsResponse response) {
      super(context, response);
    }

    private static ListAssetActionsPage createEmptyPage() {
      return new ListAssetActionsPage(null, null);
    }

    @Override
    protected ListAssetActionsPage createPage(
        PageContext<ListAssetActionsRequest, ListActionsResponse, Action> context,
        ListActionsResponse response) {
      return new ListAssetActionsPage(context, response);
    }

    @Override
    public ApiFuture<ListAssetActionsPage> createPageAsync(
        PageContext<ListAssetActionsRequest, ListActionsResponse, Action> context,
        ApiFuture<ListActionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAssetActionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAssetActionsRequest,
          ListActionsResponse,
          Action,
          ListAssetActionsPage,
          ListAssetActionsFixedSizeCollection> {

    private ListAssetActionsFixedSizeCollection(
        List<ListAssetActionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAssetActionsFixedSizeCollection createEmptyCollection() {
      return new ListAssetActionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAssetActionsFixedSizeCollection createCollection(
        List<ListAssetActionsPage> pages, int collectionSize) {
      return new ListAssetActionsFixedSizeCollection(pages, collectionSize);
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

  public static class ListJobsPagedResponse
      extends AbstractPagedListResponse<
          ListJobsRequest, ListJobsResponse, Job, ListJobsPage, ListJobsFixedSizeCollection> {

    public static ApiFuture<ListJobsPagedResponse> createAsync(
        PageContext<ListJobsRequest, ListJobsResponse, Job> context,
        ApiFuture<ListJobsResponse> futureResponse) {
      ApiFuture<ListJobsPage> futurePage =
          ListJobsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListJobsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListJobsPagedResponse(ListJobsPage page) {
      super(page, ListJobsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListJobsPage
      extends AbstractPage<ListJobsRequest, ListJobsResponse, Job, ListJobsPage> {

    private ListJobsPage(
        PageContext<ListJobsRequest, ListJobsResponse, Job> context, ListJobsResponse response) {
      super(context, response);
    }

    private static ListJobsPage createEmptyPage() {
      return new ListJobsPage(null, null);
    }

    @Override
    protected ListJobsPage createPage(
        PageContext<ListJobsRequest, ListJobsResponse, Job> context, ListJobsResponse response) {
      return new ListJobsPage(context, response);
    }

    @Override
    public ApiFuture<ListJobsPage> createPageAsync(
        PageContext<ListJobsRequest, ListJobsResponse, Job> context,
        ApiFuture<ListJobsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListJobsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListJobsRequest, ListJobsResponse, Job, ListJobsPage, ListJobsFixedSizeCollection> {

    private ListJobsFixedSizeCollection(List<ListJobsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListJobsFixedSizeCollection createEmptyCollection() {
      return new ListJobsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListJobsFixedSizeCollection createCollection(
        List<ListJobsPage> pages, int collectionSize) {
      return new ListJobsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListEnvironmentsPagedResponse
      extends AbstractPagedListResponse<
          ListEnvironmentsRequest,
          ListEnvironmentsResponse,
          Environment,
          ListEnvironmentsPage,
          ListEnvironmentsFixedSizeCollection> {

    public static ApiFuture<ListEnvironmentsPagedResponse> createAsync(
        PageContext<ListEnvironmentsRequest, ListEnvironmentsResponse, Environment> context,
        ApiFuture<ListEnvironmentsResponse> futureResponse) {
      ApiFuture<ListEnvironmentsPage> futurePage =
          ListEnvironmentsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListEnvironmentsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListEnvironmentsPagedResponse(ListEnvironmentsPage page) {
      super(page, ListEnvironmentsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListEnvironmentsPage
      extends AbstractPage<
          ListEnvironmentsRequest, ListEnvironmentsResponse, Environment, ListEnvironmentsPage> {

    private ListEnvironmentsPage(
        PageContext<ListEnvironmentsRequest, ListEnvironmentsResponse, Environment> context,
        ListEnvironmentsResponse response) {
      super(context, response);
    }

    private static ListEnvironmentsPage createEmptyPage() {
      return new ListEnvironmentsPage(null, null);
    }

    @Override
    protected ListEnvironmentsPage createPage(
        PageContext<ListEnvironmentsRequest, ListEnvironmentsResponse, Environment> context,
        ListEnvironmentsResponse response) {
      return new ListEnvironmentsPage(context, response);
    }

    @Override
    public ApiFuture<ListEnvironmentsPage> createPageAsync(
        PageContext<ListEnvironmentsRequest, ListEnvironmentsResponse, Environment> context,
        ApiFuture<ListEnvironmentsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListEnvironmentsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListEnvironmentsRequest,
          ListEnvironmentsResponse,
          Environment,
          ListEnvironmentsPage,
          ListEnvironmentsFixedSizeCollection> {

    private ListEnvironmentsFixedSizeCollection(
        List<ListEnvironmentsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListEnvironmentsFixedSizeCollection createEmptyCollection() {
      return new ListEnvironmentsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListEnvironmentsFixedSizeCollection createCollection(
        List<ListEnvironmentsPage> pages, int collectionSize) {
      return new ListEnvironmentsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListSessionsPagedResponse
      extends AbstractPagedListResponse<
          ListSessionsRequest,
          ListSessionsResponse,
          Session,
          ListSessionsPage,
          ListSessionsFixedSizeCollection> {

    public static ApiFuture<ListSessionsPagedResponse> createAsync(
        PageContext<ListSessionsRequest, ListSessionsResponse, Session> context,
        ApiFuture<ListSessionsResponse> futureResponse) {
      ApiFuture<ListSessionsPage> futurePage =
          ListSessionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListSessionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListSessionsPagedResponse(ListSessionsPage page) {
      super(page, ListSessionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSessionsPage
      extends AbstractPage<ListSessionsRequest, ListSessionsResponse, Session, ListSessionsPage> {

    private ListSessionsPage(
        PageContext<ListSessionsRequest, ListSessionsResponse, Session> context,
        ListSessionsResponse response) {
      super(context, response);
    }

    private static ListSessionsPage createEmptyPage() {
      return new ListSessionsPage(null, null);
    }

    @Override
    protected ListSessionsPage createPage(
        PageContext<ListSessionsRequest, ListSessionsResponse, Session> context,
        ListSessionsResponse response) {
      return new ListSessionsPage(context, response);
    }

    @Override
    public ApiFuture<ListSessionsPage> createPageAsync(
        PageContext<ListSessionsRequest, ListSessionsResponse, Session> context,
        ApiFuture<ListSessionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSessionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSessionsRequest,
          ListSessionsResponse,
          Session,
          ListSessionsPage,
          ListSessionsFixedSizeCollection> {

    private ListSessionsFixedSizeCollection(List<ListSessionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSessionsFixedSizeCollection createEmptyCollection() {
      return new ListSessionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSessionsFixedSizeCollection createCollection(
        List<ListSessionsPage> pages, int collectionSize) {
      return new ListSessionsFixedSizeCollection(pages, collectionSize);
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
