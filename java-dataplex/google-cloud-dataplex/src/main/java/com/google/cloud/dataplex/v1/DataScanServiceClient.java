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
import com.google.cloud.dataplex.v1.stub.DataScanServiceStub;
import com.google.cloud.dataplex.v1.stub.DataScanServiceStubSettings;
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
 * This class provides the ability to make remote calls to the backing service through method calls
 * that map to API methods. Sample code to get started:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (DataScanServiceClient dataScanServiceClient = DataScanServiceClient.create()) {
 *   DataScanName name = DataScanName.of("[PROJECT]", "[LOCATION]", "[DATASCAN]");
 *   DataScan response = dataScanServiceClient.getDataScan(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the DataScanServiceClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of DataScanServiceSettings to
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
 * DataScanServiceSettings dataScanServiceSettings =
 *     DataScanServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DataScanServiceClient dataScanServiceClient =
 *     DataScanServiceClient.create(dataScanServiceSettings);
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
 * DataScanServiceSettings dataScanServiceSettings =
 *     DataScanServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DataScanServiceClient dataScanServiceClient =
 *     DataScanServiceClient.create(dataScanServiceSettings);
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
 * DataScanServiceSettings dataScanServiceSettings =
 *     DataScanServiceSettings.newHttpJsonBuilder().build();
 * DataScanServiceClient dataScanServiceClient =
 *     DataScanServiceClient.create(dataScanServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class DataScanServiceClient implements BackgroundResource {
  private final DataScanServiceSettings settings;
  private final DataScanServiceStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of DataScanServiceClient with default settings. */
  public static final DataScanServiceClient create() throws IOException {
    return create(DataScanServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of DataScanServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final DataScanServiceClient create(DataScanServiceSettings settings)
      throws IOException {
    return new DataScanServiceClient(settings);
  }

  /**
   * Constructs an instance of DataScanServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(DataScanServiceSettings).
   */
  public static final DataScanServiceClient create(DataScanServiceStub stub) {
    return new DataScanServiceClient(stub);
  }

  /**
   * Constructs an instance of DataScanServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected DataScanServiceClient(DataScanServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((DataScanServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected DataScanServiceClient(DataScanServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final DataScanServiceSettings getSettings() {
    return settings;
  }

  public DataScanServiceStub getStub() {
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
   * Creates a dataScan resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataScanServiceClient dataScanServiceClient = DataScanServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   DataScan dataScan = DataScan.newBuilder().build();
   *   String dataScanId = "dataScanId1260787906";
   *   DataScan response =
   *       dataScanServiceClient.createDataScanAsync(parent, dataScan, dataScanId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the parent location:
   *     projects/{project}/locations/{location_id} where `{project}` refers to a project_id or
   *     project_number and `location_id` refers to a GCP region.
   * @param dataScan Required. DataScan resource.
   * @param dataScanId Required. DataScan identifier.
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
  public final OperationFuture<DataScan, OperationMetadata> createDataScanAsync(
      LocationName parent, DataScan dataScan, String dataScanId) {
    CreateDataScanRequest request =
        CreateDataScanRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setDataScan(dataScan)
            .setDataScanId(dataScanId)
            .build();
    return createDataScanAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a dataScan resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataScanServiceClient dataScanServiceClient = DataScanServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   DataScan dataScan = DataScan.newBuilder().build();
   *   String dataScanId = "dataScanId1260787906";
   *   DataScan response =
   *       dataScanServiceClient.createDataScanAsync(parent, dataScan, dataScanId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the parent location:
   *     projects/{project}/locations/{location_id} where `{project}` refers to a project_id or
   *     project_number and `location_id` refers to a GCP region.
   * @param dataScan Required. DataScan resource.
   * @param dataScanId Required. DataScan identifier.
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
  public final OperationFuture<DataScan, OperationMetadata> createDataScanAsync(
      String parent, DataScan dataScan, String dataScanId) {
    CreateDataScanRequest request =
        CreateDataScanRequest.newBuilder()
            .setParent(parent)
            .setDataScan(dataScan)
            .setDataScanId(dataScanId)
            .build();
    return createDataScanAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a dataScan resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataScanServiceClient dataScanServiceClient = DataScanServiceClient.create()) {
   *   CreateDataScanRequest request =
   *       CreateDataScanRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDataScan(DataScan.newBuilder().build())
   *           .setDataScanId("dataScanId1260787906")
   *           .build();
   *   DataScan response = dataScanServiceClient.createDataScanAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DataScan, OperationMetadata> createDataScanAsync(
      CreateDataScanRequest request) {
    return createDataScanOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a dataScan resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataScanServiceClient dataScanServiceClient = DataScanServiceClient.create()) {
   *   CreateDataScanRequest request =
   *       CreateDataScanRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDataScan(DataScan.newBuilder().build())
   *           .setDataScanId("dataScanId1260787906")
   *           .build();
   *   OperationFuture<DataScan, OperationMetadata> future =
   *       dataScanServiceClient.createDataScanOperationCallable().futureCall(request);
   *   // Do something.
   *   DataScan response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateDataScanRequest, DataScan, OperationMetadata>
      createDataScanOperationCallable() {
    return stub.createDataScanOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a dataScan resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataScanServiceClient dataScanServiceClient = DataScanServiceClient.create()) {
   *   CreateDataScanRequest request =
   *       CreateDataScanRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDataScan(DataScan.newBuilder().build())
   *           .setDataScanId("dataScanId1260787906")
   *           .build();
   *   ApiFuture<Operation> future =
   *       dataScanServiceClient.createDataScanCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateDataScanRequest, Operation> createDataScanCallable() {
    return stub.createDataScanCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update the dataScan resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataScanServiceClient dataScanServiceClient = DataScanServiceClient.create()) {
   *   DataScan dataScan = DataScan.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   DataScan response = dataScanServiceClient.updateDataScanAsync(dataScan, updateMask).get();
   * }
   * }</pre>
   *
   * @param dataScan Required. Update description. Only fields specified in `update_mask` are
   *     updated.
   * @param updateMask Required. Mask of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DataScan, OperationMetadata> updateDataScanAsync(
      DataScan dataScan, FieldMask updateMask) {
    UpdateDataScanRequest request =
        UpdateDataScanRequest.newBuilder().setDataScan(dataScan).setUpdateMask(updateMask).build();
    return updateDataScanAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update the dataScan resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataScanServiceClient dataScanServiceClient = DataScanServiceClient.create()) {
   *   UpdateDataScanRequest request =
   *       UpdateDataScanRequest.newBuilder()
   *           .setDataScan(DataScan.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   DataScan response = dataScanServiceClient.updateDataScanAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DataScan, OperationMetadata> updateDataScanAsync(
      UpdateDataScanRequest request) {
    return updateDataScanOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update the dataScan resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataScanServiceClient dataScanServiceClient = DataScanServiceClient.create()) {
   *   UpdateDataScanRequest request =
   *       UpdateDataScanRequest.newBuilder()
   *           .setDataScan(DataScan.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<DataScan, OperationMetadata> future =
   *       dataScanServiceClient.updateDataScanOperationCallable().futureCall(request);
   *   // Do something.
   *   DataScan response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateDataScanRequest, DataScan, OperationMetadata>
      updateDataScanOperationCallable() {
    return stub.updateDataScanOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update the dataScan resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataScanServiceClient dataScanServiceClient = DataScanServiceClient.create()) {
   *   UpdateDataScanRequest request =
   *       UpdateDataScanRequest.newBuilder()
   *           .setDataScan(DataScan.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       dataScanServiceClient.updateDataScanCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateDataScanRequest, Operation> updateDataScanCallable() {
    return stub.updateDataScanCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete the dataScan resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataScanServiceClient dataScanServiceClient = DataScanServiceClient.create()) {
   *   DataScanName name = DataScanName.of("[PROJECT]", "[LOCATION]", "[DATASCAN]");
   *   dataScanServiceClient.deleteDataScanAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the dataScan:
   *     projects/{project}/locations/{location_id}/dataScans/{data_scan_id} where `{project}`
   *     refers to a project_id or project_number and `location_id` refers to a GCP region.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteDataScanAsync(DataScanName name) {
    DeleteDataScanRequest request =
        DeleteDataScanRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteDataScanAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete the dataScan resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataScanServiceClient dataScanServiceClient = DataScanServiceClient.create()) {
   *   String name = DataScanName.of("[PROJECT]", "[LOCATION]", "[DATASCAN]").toString();
   *   dataScanServiceClient.deleteDataScanAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the dataScan:
   *     projects/{project}/locations/{location_id}/dataScans/{data_scan_id} where `{project}`
   *     refers to a project_id or project_number and `location_id` refers to a GCP region.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteDataScanAsync(String name) {
    DeleteDataScanRequest request = DeleteDataScanRequest.newBuilder().setName(name).build();
    return deleteDataScanAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete the dataScan resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataScanServiceClient dataScanServiceClient = DataScanServiceClient.create()) {
   *   DeleteDataScanRequest request =
   *       DeleteDataScanRequest.newBuilder()
   *           .setName(DataScanName.of("[PROJECT]", "[LOCATION]", "[DATASCAN]").toString())
   *           .build();
   *   dataScanServiceClient.deleteDataScanAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteDataScanAsync(
      DeleteDataScanRequest request) {
    return deleteDataScanOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete the dataScan resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataScanServiceClient dataScanServiceClient = DataScanServiceClient.create()) {
   *   DeleteDataScanRequest request =
   *       DeleteDataScanRequest.newBuilder()
   *           .setName(DataScanName.of("[PROJECT]", "[LOCATION]", "[DATASCAN]").toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       dataScanServiceClient.deleteDataScanOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteDataScanRequest, Empty, OperationMetadata>
      deleteDataScanOperationCallable() {
    return stub.deleteDataScanOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete the dataScan resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataScanServiceClient dataScanServiceClient = DataScanServiceClient.create()) {
   *   DeleteDataScanRequest request =
   *       DeleteDataScanRequest.newBuilder()
   *           .setName(DataScanName.of("[PROJECT]", "[LOCATION]", "[DATASCAN]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       dataScanServiceClient.deleteDataScanCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteDataScanRequest, Operation> deleteDataScanCallable() {
    return stub.deleteDataScanCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get dataScan resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataScanServiceClient dataScanServiceClient = DataScanServiceClient.create()) {
   *   DataScanName name = DataScanName.of("[PROJECT]", "[LOCATION]", "[DATASCAN]");
   *   DataScan response = dataScanServiceClient.getDataScan(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the dataScan:
   *     projects/{project}/locations/{location_id}/dataScans/{data_scan_id} where `{project}`
   *     refers to a project_id or project_number and `location_id` refers to a GCP region.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataScan getDataScan(DataScanName name) {
    GetDataScanRequest request =
        GetDataScanRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getDataScan(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get dataScan resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataScanServiceClient dataScanServiceClient = DataScanServiceClient.create()) {
   *   String name = DataScanName.of("[PROJECT]", "[LOCATION]", "[DATASCAN]").toString();
   *   DataScan response = dataScanServiceClient.getDataScan(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the dataScan:
   *     projects/{project}/locations/{location_id}/dataScans/{data_scan_id} where `{project}`
   *     refers to a project_id or project_number and `location_id` refers to a GCP region.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataScan getDataScan(String name) {
    GetDataScanRequest request = GetDataScanRequest.newBuilder().setName(name).build();
    return getDataScan(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get dataScan resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataScanServiceClient dataScanServiceClient = DataScanServiceClient.create()) {
   *   GetDataScanRequest request =
   *       GetDataScanRequest.newBuilder()
   *           .setName(DataScanName.of("[PROJECT]", "[LOCATION]", "[DATASCAN]").toString())
   *           .build();
   *   DataScan response = dataScanServiceClient.getDataScan(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataScan getDataScan(GetDataScanRequest request) {
    return getDataScanCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get dataScan resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataScanServiceClient dataScanServiceClient = DataScanServiceClient.create()) {
   *   GetDataScanRequest request =
   *       GetDataScanRequest.newBuilder()
   *           .setName(DataScanName.of("[PROJECT]", "[LOCATION]", "[DATASCAN]").toString())
   *           .build();
   *   ApiFuture<DataScan> future = dataScanServiceClient.getDataScanCallable().futureCall(request);
   *   // Do something.
   *   DataScan response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDataScanRequest, DataScan> getDataScanCallable() {
    return stub.getDataScanCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists dataScans.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataScanServiceClient dataScanServiceClient = DataScanServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (DataScan element : dataScanServiceClient.listDataScans(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. projects/{project}/locations/{location_id} where `{project}` refers to
   *     a project_id or project_number and `location_id` refers to a GCP region.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataScansPagedResponse listDataScans(LocationName parent) {
    ListDataScansRequest request =
        ListDataScansRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDataScans(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists dataScans.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataScanServiceClient dataScanServiceClient = DataScanServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (DataScan element : dataScanServiceClient.listDataScans(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. projects/{project}/locations/{location_id} where `{project}` refers to
   *     a project_id or project_number and `location_id` refers to a GCP region.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataScansPagedResponse listDataScans(String parent) {
    ListDataScansRequest request = ListDataScansRequest.newBuilder().setParent(parent).build();
    return listDataScans(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists dataScans.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataScanServiceClient dataScanServiceClient = DataScanServiceClient.create()) {
   *   ListDataScansRequest request =
   *       ListDataScansRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (DataScan element : dataScanServiceClient.listDataScans(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataScansPagedResponse listDataScans(ListDataScansRequest request) {
    return listDataScansPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists dataScans.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataScanServiceClient dataScanServiceClient = DataScanServiceClient.create()) {
   *   ListDataScansRequest request =
   *       ListDataScansRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<DataScan> future =
   *       dataScanServiceClient.listDataScansPagedCallable().futureCall(request);
   *   // Do something.
   *   for (DataScan element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDataScansRequest, ListDataScansPagedResponse>
      listDataScansPagedCallable() {
    return stub.listDataScansPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists dataScans.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataScanServiceClient dataScanServiceClient = DataScanServiceClient.create()) {
   *   ListDataScansRequest request =
   *       ListDataScansRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListDataScansResponse response =
   *         dataScanServiceClient.listDataScansCallable().call(request);
   *     for (DataScan element : response.getDataScansList()) {
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
  public final UnaryCallable<ListDataScansRequest, ListDataScansResponse> listDataScansCallable() {
    return stub.listDataScansCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Run an on demand execution of a DataScan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataScanServiceClient dataScanServiceClient = DataScanServiceClient.create()) {
   *   DataScanName name = DataScanName.of("[PROJECT]", "[LOCATION]", "[DATASCAN]");
   *   RunDataScanResponse response = dataScanServiceClient.runDataScan(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the DataScan:
   *     projects/{project}/locations/{location_id}/dataScans/{data_scan_id}. where `{project}`
   *     refers to a project_id or project_number and `location_id` refers to a GCP region. Only
   *     on-demand DataScans are allowed.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RunDataScanResponse runDataScan(DataScanName name) {
    RunDataScanRequest request =
        RunDataScanRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return runDataScan(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Run an on demand execution of a DataScan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataScanServiceClient dataScanServiceClient = DataScanServiceClient.create()) {
   *   String name = DataScanName.of("[PROJECT]", "[LOCATION]", "[DATASCAN]").toString();
   *   RunDataScanResponse response = dataScanServiceClient.runDataScan(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the DataScan:
   *     projects/{project}/locations/{location_id}/dataScans/{data_scan_id}. where `{project}`
   *     refers to a project_id or project_number and `location_id` refers to a GCP region. Only
   *     on-demand DataScans are allowed.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RunDataScanResponse runDataScan(String name) {
    RunDataScanRequest request = RunDataScanRequest.newBuilder().setName(name).build();
    return runDataScan(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Run an on demand execution of a DataScan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataScanServiceClient dataScanServiceClient = DataScanServiceClient.create()) {
   *   RunDataScanRequest request =
   *       RunDataScanRequest.newBuilder()
   *           .setName(DataScanName.of("[PROJECT]", "[LOCATION]", "[DATASCAN]").toString())
   *           .build();
   *   RunDataScanResponse response = dataScanServiceClient.runDataScan(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RunDataScanResponse runDataScan(RunDataScanRequest request) {
    return runDataScanCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Run an on demand execution of a DataScan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataScanServiceClient dataScanServiceClient = DataScanServiceClient.create()) {
   *   RunDataScanRequest request =
   *       RunDataScanRequest.newBuilder()
   *           .setName(DataScanName.of("[PROJECT]", "[LOCATION]", "[DATASCAN]").toString())
   *           .build();
   *   ApiFuture<RunDataScanResponse> future =
   *       dataScanServiceClient.runDataScanCallable().futureCall(request);
   *   // Do something.
   *   RunDataScanResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RunDataScanRequest, RunDataScanResponse> runDataScanCallable() {
    return stub.runDataScanCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get DataScanJob resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataScanServiceClient dataScanServiceClient = DataScanServiceClient.create()) {
   *   DataScanJobName name = DataScanJobName.of("[PROJECT]", "[LOCATION]", "[DATASCAN]", "[JOB]");
   *   DataScanJob response = dataScanServiceClient.getDataScanJob(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the DataScanJob:
   *     projects/{project}/locations/{location_id}/dataScans/{data_scan_id}/dataScanJobs/{data_scan_job_id}
   *     where `{project}` refers to a project_id or project_number and `location_id` refers to a
   *     GCP region.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataScanJob getDataScanJob(DataScanJobName name) {
    GetDataScanJobRequest request =
        GetDataScanJobRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getDataScanJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get DataScanJob resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataScanServiceClient dataScanServiceClient = DataScanServiceClient.create()) {
   *   String name = DataScanJobName.of("[PROJECT]", "[LOCATION]", "[DATASCAN]", "[JOB]").toString();
   *   DataScanJob response = dataScanServiceClient.getDataScanJob(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the DataScanJob:
   *     projects/{project}/locations/{location_id}/dataScans/{data_scan_id}/dataScanJobs/{data_scan_job_id}
   *     where `{project}` refers to a project_id or project_number and `location_id` refers to a
   *     GCP region.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataScanJob getDataScanJob(String name) {
    GetDataScanJobRequest request = GetDataScanJobRequest.newBuilder().setName(name).build();
    return getDataScanJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get DataScanJob resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataScanServiceClient dataScanServiceClient = DataScanServiceClient.create()) {
   *   GetDataScanJobRequest request =
   *       GetDataScanJobRequest.newBuilder()
   *           .setName(
   *               DataScanJobName.of("[PROJECT]", "[LOCATION]", "[DATASCAN]", "[JOB]").toString())
   *           .build();
   *   DataScanJob response = dataScanServiceClient.getDataScanJob(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataScanJob getDataScanJob(GetDataScanJobRequest request) {
    return getDataScanJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get DataScanJob resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataScanServiceClient dataScanServiceClient = DataScanServiceClient.create()) {
   *   GetDataScanJobRequest request =
   *       GetDataScanJobRequest.newBuilder()
   *           .setName(
   *               DataScanJobName.of("[PROJECT]", "[LOCATION]", "[DATASCAN]", "[JOB]").toString())
   *           .build();
   *   ApiFuture<DataScanJob> future =
   *       dataScanServiceClient.getDataScanJobCallable().futureCall(request);
   *   // Do something.
   *   DataScanJob response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDataScanJobRequest, DataScanJob> getDataScanJobCallable() {
    return stub.getDataScanJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DataScanJobs under the given dataScan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataScanServiceClient dataScanServiceClient = DataScanServiceClient.create()) {
   *   DataScanName parent = DataScanName.of("[PROJECT]", "[LOCATION]", "[DATASCAN]");
   *   for (DataScanJob element : dataScanServiceClient.listDataScanJobs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the parent environment:
   *     projects/{project}/locations/{location_id}/dataScans/{data_scan_id} where `{project}`
   *     refers to a project_id or project_number and `location_id` refers to a GCP region.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataScanJobsPagedResponse listDataScanJobs(DataScanName parent) {
    ListDataScanJobsRequest request =
        ListDataScanJobsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDataScanJobs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DataScanJobs under the given dataScan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataScanServiceClient dataScanServiceClient = DataScanServiceClient.create()) {
   *   String parent = DataScanName.of("[PROJECT]", "[LOCATION]", "[DATASCAN]").toString();
   *   for (DataScanJob element : dataScanServiceClient.listDataScanJobs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the parent environment:
   *     projects/{project}/locations/{location_id}/dataScans/{data_scan_id} where `{project}`
   *     refers to a project_id or project_number and `location_id` refers to a GCP region.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataScanJobsPagedResponse listDataScanJobs(String parent) {
    ListDataScanJobsRequest request =
        ListDataScanJobsRequest.newBuilder().setParent(parent).build();
    return listDataScanJobs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DataScanJobs under the given dataScan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataScanServiceClient dataScanServiceClient = DataScanServiceClient.create()) {
   *   ListDataScanJobsRequest request =
   *       ListDataScanJobsRequest.newBuilder()
   *           .setParent(DataScanName.of("[PROJECT]", "[LOCATION]", "[DATASCAN]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (DataScanJob element : dataScanServiceClient.listDataScanJobs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataScanJobsPagedResponse listDataScanJobs(ListDataScanJobsRequest request) {
    return listDataScanJobsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DataScanJobs under the given dataScan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataScanServiceClient dataScanServiceClient = DataScanServiceClient.create()) {
   *   ListDataScanJobsRequest request =
   *       ListDataScanJobsRequest.newBuilder()
   *           .setParent(DataScanName.of("[PROJECT]", "[LOCATION]", "[DATASCAN]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<DataScanJob> future =
   *       dataScanServiceClient.listDataScanJobsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (DataScanJob element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDataScanJobsRequest, ListDataScanJobsPagedResponse>
      listDataScanJobsPagedCallable() {
    return stub.listDataScanJobsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DataScanJobs under the given dataScan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataScanServiceClient dataScanServiceClient = DataScanServiceClient.create()) {
   *   ListDataScanJobsRequest request =
   *       ListDataScanJobsRequest.newBuilder()
   *           .setParent(DataScanName.of("[PROJECT]", "[LOCATION]", "[DATASCAN]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListDataScanJobsResponse response =
   *         dataScanServiceClient.listDataScanJobsCallable().call(request);
   *     for (DataScanJob element : response.getDataScanJobsList()) {
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
  public final UnaryCallable<ListDataScanJobsRequest, ListDataScanJobsResponse>
      listDataScanJobsCallable() {
    return stub.listDataScanJobsCallable();
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
   * try (DataScanServiceClient dataScanServiceClient = DataScanServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : dataScanServiceClient.listLocations(request).iterateAll()) {
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
   * try (DataScanServiceClient dataScanServiceClient = DataScanServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       dataScanServiceClient.listLocationsPagedCallable().futureCall(request);
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
   * try (DataScanServiceClient dataScanServiceClient = DataScanServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         dataScanServiceClient.listLocationsCallable().call(request);
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
   * try (DataScanServiceClient dataScanServiceClient = DataScanServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = dataScanServiceClient.getLocation(request);
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
   * try (DataScanServiceClient dataScanServiceClient = DataScanServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = dataScanServiceClient.getLocationCallable().futureCall(request);
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

  public static class ListDataScansPagedResponse
      extends AbstractPagedListResponse<
          ListDataScansRequest,
          ListDataScansResponse,
          DataScan,
          ListDataScansPage,
          ListDataScansFixedSizeCollection> {

    public static ApiFuture<ListDataScansPagedResponse> createAsync(
        PageContext<ListDataScansRequest, ListDataScansResponse, DataScan> context,
        ApiFuture<ListDataScansResponse> futureResponse) {
      ApiFuture<ListDataScansPage> futurePage =
          ListDataScansPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDataScansPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDataScansPagedResponse(ListDataScansPage page) {
      super(page, ListDataScansFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDataScansPage
      extends AbstractPage<
          ListDataScansRequest, ListDataScansResponse, DataScan, ListDataScansPage> {

    private ListDataScansPage(
        PageContext<ListDataScansRequest, ListDataScansResponse, DataScan> context,
        ListDataScansResponse response) {
      super(context, response);
    }

    private static ListDataScansPage createEmptyPage() {
      return new ListDataScansPage(null, null);
    }

    @Override
    protected ListDataScansPage createPage(
        PageContext<ListDataScansRequest, ListDataScansResponse, DataScan> context,
        ListDataScansResponse response) {
      return new ListDataScansPage(context, response);
    }

    @Override
    public ApiFuture<ListDataScansPage> createPageAsync(
        PageContext<ListDataScansRequest, ListDataScansResponse, DataScan> context,
        ApiFuture<ListDataScansResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDataScansFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDataScansRequest,
          ListDataScansResponse,
          DataScan,
          ListDataScansPage,
          ListDataScansFixedSizeCollection> {

    private ListDataScansFixedSizeCollection(List<ListDataScansPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDataScansFixedSizeCollection createEmptyCollection() {
      return new ListDataScansFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDataScansFixedSizeCollection createCollection(
        List<ListDataScansPage> pages, int collectionSize) {
      return new ListDataScansFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListDataScanJobsPagedResponse
      extends AbstractPagedListResponse<
          ListDataScanJobsRequest,
          ListDataScanJobsResponse,
          DataScanJob,
          ListDataScanJobsPage,
          ListDataScanJobsFixedSizeCollection> {

    public static ApiFuture<ListDataScanJobsPagedResponse> createAsync(
        PageContext<ListDataScanJobsRequest, ListDataScanJobsResponse, DataScanJob> context,
        ApiFuture<ListDataScanJobsResponse> futureResponse) {
      ApiFuture<ListDataScanJobsPage> futurePage =
          ListDataScanJobsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDataScanJobsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDataScanJobsPagedResponse(ListDataScanJobsPage page) {
      super(page, ListDataScanJobsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDataScanJobsPage
      extends AbstractPage<
          ListDataScanJobsRequest, ListDataScanJobsResponse, DataScanJob, ListDataScanJobsPage> {

    private ListDataScanJobsPage(
        PageContext<ListDataScanJobsRequest, ListDataScanJobsResponse, DataScanJob> context,
        ListDataScanJobsResponse response) {
      super(context, response);
    }

    private static ListDataScanJobsPage createEmptyPage() {
      return new ListDataScanJobsPage(null, null);
    }

    @Override
    protected ListDataScanJobsPage createPage(
        PageContext<ListDataScanJobsRequest, ListDataScanJobsResponse, DataScanJob> context,
        ListDataScanJobsResponse response) {
      return new ListDataScanJobsPage(context, response);
    }

    @Override
    public ApiFuture<ListDataScanJobsPage> createPageAsync(
        PageContext<ListDataScanJobsRequest, ListDataScanJobsResponse, DataScanJob> context,
        ApiFuture<ListDataScanJobsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDataScanJobsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDataScanJobsRequest,
          ListDataScanJobsResponse,
          DataScanJob,
          ListDataScanJobsPage,
          ListDataScanJobsFixedSizeCollection> {

    private ListDataScanJobsFixedSizeCollection(
        List<ListDataScanJobsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDataScanJobsFixedSizeCollection createEmptyCollection() {
      return new ListDataScanJobsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDataScanJobsFixedSizeCollection createCollection(
        List<ListDataScanJobsPage> pages, int collectionSize) {
      return new ListDataScanJobsFixedSizeCollection(pages, collectionSize);
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
