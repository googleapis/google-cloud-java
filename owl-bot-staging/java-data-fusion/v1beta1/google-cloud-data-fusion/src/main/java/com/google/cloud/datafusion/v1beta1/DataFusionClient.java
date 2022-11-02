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

package com.google.cloud.datafusion.v1beta1;

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
import com.google.cloud.datafusion.v1beta1.stub.DataFusionStub;
import com.google.cloud.datafusion.v1beta1.stub.DataFusionStubSettings;
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
 * Service Description: Service for creating and managing Data Fusion instances. Data Fusion enables
 * ETL developers to build code-free, data integration pipelines via a point-and-click UI.
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
 * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
 *   GetInstanceRequest request =
 *       GetInstanceRequest.newBuilder()
 *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
 *           .build();
 *   Instance response = dataFusionClient.getInstance(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the DataFusionClient object to clean up resources such as
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
 * <p>This class can be customized by passing in a custom instance of DataFusionSettings to
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
 * DataFusionSettings dataFusionSettings =
 *     DataFusionSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DataFusionClient dataFusionClient = DataFusionClient.create(dataFusionSettings);
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
 * DataFusionSettings dataFusionSettings =
 *     DataFusionSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DataFusionClient dataFusionClient = DataFusionClient.create(dataFusionSettings);
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
 * DataFusionSettings dataFusionSettings = DataFusionSettings.newHttpJsonBuilder().build();
 * DataFusionClient dataFusionClient = DataFusionClient.create(dataFusionSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class DataFusionClient implements BackgroundResource {
  private final DataFusionSettings settings;
  private final DataFusionStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of DataFusionClient with default settings. */
  public static final DataFusionClient create() throws IOException {
    return create(DataFusionSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of DataFusionClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final DataFusionClient create(DataFusionSettings settings) throws IOException {
    return new DataFusionClient(settings);
  }

  /**
   * Constructs an instance of DataFusionClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(DataFusionSettings).
   */
  public static final DataFusionClient create(DataFusionStub stub) {
    return new DataFusionClient(stub);
  }

  /**
   * Constructs an instance of DataFusionClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected DataFusionClient(DataFusionSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((DataFusionStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected DataFusionClient(DataFusionStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final DataFusionSettings getSettings() {
    return settings;
  }

  public DataFusionStub getStub() {
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
   * Lists possible versions for Data Fusion instances in the specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Version element : dataFusionClient.listAvailableVersions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location for which to retrieve instance information in
   *     the format projects/{project}/locations/{location}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAvailableVersionsPagedResponse listAvailableVersions(LocationName parent) {
    ListAvailableVersionsRequest request =
        ListAvailableVersionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAvailableVersions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists possible versions for Data Fusion instances in the specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Version element : dataFusionClient.listAvailableVersions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location for which to retrieve instance information in
   *     the format projects/{project}/locations/{location}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAvailableVersionsPagedResponse listAvailableVersions(String parent) {
    ListAvailableVersionsRequest request =
        ListAvailableVersionsRequest.newBuilder().setParent(parent).build();
    return listAvailableVersions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists possible versions for Data Fusion instances in the specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   ListAvailableVersionsRequest request =
   *       ListAvailableVersionsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setLatestPatchOnly(true)
   *           .build();
   *   for (Version element : dataFusionClient.listAvailableVersions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAvailableVersionsPagedResponse listAvailableVersions(
      ListAvailableVersionsRequest request) {
    return listAvailableVersionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists possible versions for Data Fusion instances in the specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   ListAvailableVersionsRequest request =
   *       ListAvailableVersionsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setLatestPatchOnly(true)
   *           .build();
   *   ApiFuture<Version> future =
   *       dataFusionClient.listAvailableVersionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Version element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAvailableVersionsRequest, ListAvailableVersionsPagedResponse>
      listAvailableVersionsPagedCallable() {
    return stub.listAvailableVersionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists possible versions for Data Fusion instances in the specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   ListAvailableVersionsRequest request =
   *       ListAvailableVersionsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setLatestPatchOnly(true)
   *           .build();
   *   while (true) {
   *     ListAvailableVersionsResponse response =
   *         dataFusionClient.listAvailableVersionsCallable().call(request);
   *     for (Version element : response.getAvailableVersionsList()) {
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
  public final UnaryCallable<ListAvailableVersionsRequest, ListAvailableVersionsResponse>
      listAvailableVersionsCallable() {
    return stub.listAvailableVersionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Data Fusion instances in the specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   ListInstancesRequest request =
   *       ListInstancesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Instance element : dataFusionClient.listInstances(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInstancesPagedResponse listInstances(ListInstancesRequest request) {
    return listInstancesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Data Fusion instances in the specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   ListInstancesRequest request =
   *       ListInstancesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Instance> future =
   *       dataFusionClient.listInstancesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Instance element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListInstancesRequest, ListInstancesPagedResponse>
      listInstancesPagedCallable() {
    return stub.listInstancesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Data Fusion instances in the specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   ListInstancesRequest request =
   *       ListInstancesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListInstancesResponse response = dataFusionClient.listInstancesCallable().call(request);
   *     for (Instance element : response.getInstancesList()) {
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
  public final UnaryCallable<ListInstancesRequest, ListInstancesResponse> listInstancesCallable() {
    return stub.listInstancesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Data Fusion instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   GetInstanceRequest request =
   *       GetInstanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   Instance response = dataFusionClient.getInstance(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Instance getInstance(GetInstanceRequest request) {
    return getInstanceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Data Fusion instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   GetInstanceRequest request =
   *       GetInstanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   ApiFuture<Instance> future = dataFusionClient.getInstanceCallable().futureCall(request);
   *   // Do something.
   *   Instance response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetInstanceRequest, Instance> getInstanceCallable() {
    return stub.getInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Data Fusion instance in the specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Instance instance = Instance.newBuilder().build();
   *   String instanceId = "instanceId902024336";
   *   Instance response = dataFusionClient.createInstanceAsync(parent, instance, instanceId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The instance's project and location in the format
   *     projects/{project}/locations/{location}.
   * @param instance An instance resource.
   * @param instanceId Required. The name of the instance to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> createInstanceAsync(
      LocationName parent, Instance instance, String instanceId) {
    CreateInstanceRequest request =
        CreateInstanceRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setInstance(instance)
            .setInstanceId(instanceId)
            .build();
    return createInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Data Fusion instance in the specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Instance instance = Instance.newBuilder().build();
   *   String instanceId = "instanceId902024336";
   *   Instance response = dataFusionClient.createInstanceAsync(parent, instance, instanceId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The instance's project and location in the format
   *     projects/{project}/locations/{location}.
   * @param instance An instance resource.
   * @param instanceId Required. The name of the instance to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> createInstanceAsync(
      String parent, Instance instance, String instanceId) {
    CreateInstanceRequest request =
        CreateInstanceRequest.newBuilder()
            .setParent(parent)
            .setInstance(instance)
            .setInstanceId(instanceId)
            .build();
    return createInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Data Fusion instance in the specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   CreateInstanceRequest request =
   *       CreateInstanceRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setInstanceId("instanceId902024336")
   *           .setInstance(Instance.newBuilder().build())
   *           .build();
   *   Instance response = dataFusionClient.createInstanceAsync(request).get();
   * }
   * }</pre>
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
   * Creates a new Data Fusion instance in the specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   CreateInstanceRequest request =
   *       CreateInstanceRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setInstanceId("instanceId902024336")
   *           .setInstance(Instance.newBuilder().build())
   *           .build();
   *   OperationFuture<Instance, OperationMetadata> future =
   *       dataFusionClient.createInstanceOperationCallable().futureCall(request);
   *   // Do something.
   *   Instance response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateInstanceRequest, Instance, OperationMetadata>
      createInstanceOperationCallable() {
    return stub.createInstanceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Data Fusion instance in the specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   CreateInstanceRequest request =
   *       CreateInstanceRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setInstanceId("instanceId902024336")
   *           .setInstance(Instance.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = dataFusionClient.createInstanceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateInstanceRequest, Operation> createInstanceCallable() {
    return stub.createInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Data Fusion instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   dataFusionClient.deleteInstanceAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The instance resource name in the format
   *     projects/{project}/locations/{location}/instances/{instance}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteInstanceAsync(InstanceName name) {
    DeleteInstanceRequest request =
        DeleteInstanceRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Data Fusion instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   String name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   dataFusionClient.deleteInstanceAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The instance resource name in the format
   *     projects/{project}/locations/{location}/instances/{instance}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteInstanceAsync(String name) {
    DeleteInstanceRequest request = DeleteInstanceRequest.newBuilder().setName(name).build();
    return deleteInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Data Fusion instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   DeleteInstanceRequest request =
   *       DeleteInstanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   dataFusionClient.deleteInstanceAsync(request).get();
   * }
   * }</pre>
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
   * Deletes a single Data Fusion instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   DeleteInstanceRequest request =
   *       DeleteInstanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       dataFusionClient.deleteInstanceOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteInstanceRequest, Empty, OperationMetadata>
      deleteInstanceOperationCallable() {
    return stub.deleteInstanceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Data Fusion instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   DeleteInstanceRequest request =
   *       DeleteInstanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   ApiFuture<Operation> future = dataFusionClient.deleteInstanceCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteInstanceRequest, Operation> deleteInstanceCallable() {
    return stub.deleteInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a single Data Fusion instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   Instance instance = Instance.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Instance response = dataFusionClient.updateInstanceAsync(instance, updateMask).get();
   * }
   * }</pre>
   *
   * @param instance Required. The instance resource that replaces the resource on the server.
   *     Currently, Data Fusion only allows replacing labels, options, and stack driver settings.
   *     All other fields will be ignored.
   * @param updateMask Field mask is used to specify the fields that the update will overwrite in an
   *     instance resource. The fields specified in the update_mask are relative to the resource,
   *     not the full request. A field will be overwritten if it is in the mask. If the user does
   *     not provide a mask, all the supported fields (labels and options currently) will be
   *     overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> updateInstanceAsync(
      Instance instance, FieldMask updateMask) {
    UpdateInstanceRequest request =
        UpdateInstanceRequest.newBuilder().setInstance(instance).setUpdateMask(updateMask).build();
    return updateInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a single Data Fusion instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   UpdateInstanceRequest request =
   *       UpdateInstanceRequest.newBuilder()
   *           .setInstance(Instance.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Instance response = dataFusionClient.updateInstanceAsync(request).get();
   * }
   * }</pre>
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
   * Updates a single Data Fusion instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   UpdateInstanceRequest request =
   *       UpdateInstanceRequest.newBuilder()
   *           .setInstance(Instance.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<Instance, OperationMetadata> future =
   *       dataFusionClient.updateInstanceOperationCallable().futureCall(request);
   *   // Do something.
   *   Instance response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateInstanceRequest, Instance, OperationMetadata>
      updateInstanceOperationCallable() {
    return stub.updateInstanceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a single Data Fusion instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   UpdateInstanceRequest request =
   *       UpdateInstanceRequest.newBuilder()
   *           .setInstance(Instance.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = dataFusionClient.updateInstanceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateInstanceRequest, Operation> updateInstanceCallable() {
    return stub.updateInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restart a single Data Fusion instance. At the end of an operation instance is fully restarted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   RestartInstanceRequest request =
   *       RestartInstanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   Instance response = dataFusionClient.restartInstanceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> restartInstanceAsync(
      RestartInstanceRequest request) {
    return restartInstanceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restart a single Data Fusion instance. At the end of an operation instance is fully restarted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   RestartInstanceRequest request =
   *       RestartInstanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   OperationFuture<Instance, OperationMetadata> future =
   *       dataFusionClient.restartInstanceOperationCallable().futureCall(request);
   *   // Do something.
   *   Instance response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<RestartInstanceRequest, Instance, OperationMetadata>
      restartInstanceOperationCallable() {
    return stub.restartInstanceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restart a single Data Fusion instance. At the end of an operation instance is fully restarted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   RestartInstanceRequest request =
   *       RestartInstanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   ApiFuture<Operation> future = dataFusionClient.restartInstanceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RestartInstanceRequest, Operation> restartInstanceCallable() {
    return stub.restartInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Upgrade a single Data Fusion instance. At the end of an operation instance is fully upgraded.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   UpgradeInstanceRequest request =
   *       UpgradeInstanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   Instance response = dataFusionClient.upgradeInstanceAsync(request).get();
   * }
   * }</pre>
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
   * Upgrade a single Data Fusion instance. At the end of an operation instance is fully upgraded.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   UpgradeInstanceRequest request =
   *       UpgradeInstanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   OperationFuture<Instance, OperationMetadata> future =
   *       dataFusionClient.upgradeInstanceOperationCallable().futureCall(request);
   *   // Do something.
   *   Instance response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpgradeInstanceRequest, Instance, OperationMetadata>
      upgradeInstanceOperationCallable() {
    return stub.upgradeInstanceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Upgrade a single Data Fusion instance. At the end of an operation instance is fully upgraded.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   UpgradeInstanceRequest request =
   *       UpgradeInstanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   ApiFuture<Operation> future = dataFusionClient.upgradeInstanceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpgradeInstanceRequest, Operation> upgradeInstanceCallable() {
    return stub.upgradeInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Remove IAM policy that is currently set on the given resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   RemoveIamPolicyRequest request =
   *       RemoveIamPolicyRequest.newBuilder().setResource("resource-341064690").build();
   *   RemoveIamPolicyResponse response = dataFusionClient.removeIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RemoveIamPolicyResponse removeIamPolicy(RemoveIamPolicyRequest request) {
    return removeIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Remove IAM policy that is currently set on the given resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   RemoveIamPolicyRequest request =
   *       RemoveIamPolicyRequest.newBuilder().setResource("resource-341064690").build();
   *   ApiFuture<RemoveIamPolicyResponse> future =
   *       dataFusionClient.removeIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   RemoveIamPolicyResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RemoveIamPolicyRequest, RemoveIamPolicyResponse>
      removeIamPolicyCallable() {
    return stub.removeIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List namespaces in a given instance
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   for (Namespace element : dataFusionClient.listNamespaces(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The instance to list its namespaces.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNamespacesPagedResponse listNamespaces(InstanceName parent) {
    ListNamespacesRequest request =
        ListNamespacesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listNamespaces(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List namespaces in a given instance
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   String parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   for (Namespace element : dataFusionClient.listNamespaces(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The instance to list its namespaces.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNamespacesPagedResponse listNamespaces(String parent) {
    ListNamespacesRequest request = ListNamespacesRequest.newBuilder().setParent(parent).build();
    return listNamespaces(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List namespaces in a given instance
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   ListNamespacesRequest request =
   *       ListNamespacesRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setView(NamespaceView.forNumber(0))
   *           .build();
   *   for (Namespace element : dataFusionClient.listNamespaces(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNamespacesPagedResponse listNamespaces(ListNamespacesRequest request) {
    return listNamespacesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List namespaces in a given instance
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   ListNamespacesRequest request =
   *       ListNamespacesRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setView(NamespaceView.forNumber(0))
   *           .build();
   *   ApiFuture<Namespace> future =
   *       dataFusionClient.listNamespacesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Namespace element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListNamespacesRequest, ListNamespacesPagedResponse>
      listNamespacesPagedCallable() {
    return stub.listNamespacesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List namespaces in a given instance
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   ListNamespacesRequest request =
   *       ListNamespacesRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setView(NamespaceView.forNumber(0))
   *           .build();
   *   while (true) {
   *     ListNamespacesResponse response = dataFusionClient.listNamespacesCallable().call(request);
   *     for (Namespace element : response.getNamespacesList()) {
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
  public final UnaryCallable<ListNamespacesRequest, ListNamespacesResponse>
      listNamespacesCallable() {
    return stub.listNamespacesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Add DNS peering on the given resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   AddDnsPeeringResponse response = dataFusionClient.addDnsPeering(parent);
   * }
   * }</pre>
   *
   * @param parent Required. The resource on which DNS peering will be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AddDnsPeeringResponse addDnsPeering(InstanceName parent) {
    AddDnsPeeringRequest request =
        AddDnsPeeringRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return addDnsPeering(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Add DNS peering on the given resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   String parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   AddDnsPeeringResponse response = dataFusionClient.addDnsPeering(parent);
   * }
   * }</pre>
   *
   * @param parent Required. The resource on which DNS peering will be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AddDnsPeeringResponse addDnsPeering(String parent) {
    AddDnsPeeringRequest request = AddDnsPeeringRequest.newBuilder().setParent(parent).build();
    return addDnsPeering(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Add DNS peering on the given resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   AddDnsPeeringRequest request =
   *       AddDnsPeeringRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setDnsPeering(DnsPeering.newBuilder().build())
   *           .build();
   *   AddDnsPeeringResponse response = dataFusionClient.addDnsPeering(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AddDnsPeeringResponse addDnsPeering(AddDnsPeeringRequest request) {
    return addDnsPeeringCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Add DNS peering on the given resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   AddDnsPeeringRequest request =
   *       AddDnsPeeringRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setDnsPeering(DnsPeering.newBuilder().build())
   *           .build();
   *   ApiFuture<AddDnsPeeringResponse> future =
   *       dataFusionClient.addDnsPeeringCallable().futureCall(request);
   *   // Do something.
   *   AddDnsPeeringResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AddDnsPeeringRequest, AddDnsPeeringResponse> addDnsPeeringCallable() {
    return stub.addDnsPeeringCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Remove DNS peering on the given resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   RemoveDnsPeeringResponse response = dataFusionClient.removeDnsPeering(parent);
   * }
   * }</pre>
   *
   * @param parent Required. The resource on which DNS peering will be removed.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RemoveDnsPeeringResponse removeDnsPeering(InstanceName parent) {
    RemoveDnsPeeringRequest request =
        RemoveDnsPeeringRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return removeDnsPeering(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Remove DNS peering on the given resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   String parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   RemoveDnsPeeringResponse response = dataFusionClient.removeDnsPeering(parent);
   * }
   * }</pre>
   *
   * @param parent Required. The resource on which DNS peering will be removed.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RemoveDnsPeeringResponse removeDnsPeering(String parent) {
    RemoveDnsPeeringRequest request =
        RemoveDnsPeeringRequest.newBuilder().setParent(parent).build();
    return removeDnsPeering(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Remove DNS peering on the given resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   RemoveDnsPeeringRequest request =
   *       RemoveDnsPeeringRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setZone("zone3744684")
   *           .build();
   *   RemoveDnsPeeringResponse response = dataFusionClient.removeDnsPeering(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RemoveDnsPeeringResponse removeDnsPeering(RemoveDnsPeeringRequest request) {
    return removeDnsPeeringCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Remove DNS peering on the given resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   RemoveDnsPeeringRequest request =
   *       RemoveDnsPeeringRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<RemoveDnsPeeringResponse> future =
   *       dataFusionClient.removeDnsPeeringCallable().futureCall(request);
   *   // Do something.
   *   RemoveDnsPeeringResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RemoveDnsPeeringRequest, RemoveDnsPeeringResponse>
      removeDnsPeeringCallable() {
    return stub.removeDnsPeeringCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List DNS peering for a given resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   for (DnsPeering element : dataFusionClient.listDnsPeerings(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource on which dns peering will be listed.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDnsPeeringsPagedResponse listDnsPeerings(InstanceName parent) {
    ListDnsPeeringsRequest request =
        ListDnsPeeringsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDnsPeerings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List DNS peering for a given resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   String parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   for (DnsPeering element : dataFusionClient.listDnsPeerings(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource on which dns peering will be listed.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDnsPeeringsPagedResponse listDnsPeerings(String parent) {
    ListDnsPeeringsRequest request = ListDnsPeeringsRequest.newBuilder().setParent(parent).build();
    return listDnsPeerings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List DNS peering for a given resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   ListDnsPeeringsRequest request =
   *       ListDnsPeeringsRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (DnsPeering element : dataFusionClient.listDnsPeerings(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDnsPeeringsPagedResponse listDnsPeerings(ListDnsPeeringsRequest request) {
    return listDnsPeeringsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List DNS peering for a given resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   ListDnsPeeringsRequest request =
   *       ListDnsPeeringsRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<DnsPeering> future =
   *       dataFusionClient.listDnsPeeringsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (DnsPeering element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDnsPeeringsRequest, ListDnsPeeringsPagedResponse>
      listDnsPeeringsPagedCallable() {
    return stub.listDnsPeeringsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List DNS peering for a given resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   ListDnsPeeringsRequest request =
   *       ListDnsPeeringsRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListDnsPeeringsResponse response = dataFusionClient.listDnsPeeringsCallable().call(request);
   *     for (DnsPeering element : response.getDnsPeeringsList()) {
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
  public final UnaryCallable<ListDnsPeeringsRequest, ListDnsPeeringsResponse>
      listDnsPeeringsCallable() {
    return stub.listDnsPeeringsCallable();
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

  public static class ListAvailableVersionsPagedResponse
      extends AbstractPagedListResponse<
          ListAvailableVersionsRequest,
          ListAvailableVersionsResponse,
          Version,
          ListAvailableVersionsPage,
          ListAvailableVersionsFixedSizeCollection> {

    public static ApiFuture<ListAvailableVersionsPagedResponse> createAsync(
        PageContext<ListAvailableVersionsRequest, ListAvailableVersionsResponse, Version> context,
        ApiFuture<ListAvailableVersionsResponse> futureResponse) {
      ApiFuture<ListAvailableVersionsPage> futurePage =
          ListAvailableVersionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAvailableVersionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAvailableVersionsPagedResponse(ListAvailableVersionsPage page) {
      super(page, ListAvailableVersionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAvailableVersionsPage
      extends AbstractPage<
          ListAvailableVersionsRequest,
          ListAvailableVersionsResponse,
          Version,
          ListAvailableVersionsPage> {

    private ListAvailableVersionsPage(
        PageContext<ListAvailableVersionsRequest, ListAvailableVersionsResponse, Version> context,
        ListAvailableVersionsResponse response) {
      super(context, response);
    }

    private static ListAvailableVersionsPage createEmptyPage() {
      return new ListAvailableVersionsPage(null, null);
    }

    @Override
    protected ListAvailableVersionsPage createPage(
        PageContext<ListAvailableVersionsRequest, ListAvailableVersionsResponse, Version> context,
        ListAvailableVersionsResponse response) {
      return new ListAvailableVersionsPage(context, response);
    }

    @Override
    public ApiFuture<ListAvailableVersionsPage> createPageAsync(
        PageContext<ListAvailableVersionsRequest, ListAvailableVersionsResponse, Version> context,
        ApiFuture<ListAvailableVersionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAvailableVersionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAvailableVersionsRequest,
          ListAvailableVersionsResponse,
          Version,
          ListAvailableVersionsPage,
          ListAvailableVersionsFixedSizeCollection> {

    private ListAvailableVersionsFixedSizeCollection(
        List<ListAvailableVersionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAvailableVersionsFixedSizeCollection createEmptyCollection() {
      return new ListAvailableVersionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAvailableVersionsFixedSizeCollection createCollection(
        List<ListAvailableVersionsPage> pages, int collectionSize) {
      return new ListAvailableVersionsFixedSizeCollection(pages, collectionSize);
    }
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
          input -> new ListInstancesPagedResponse(input),
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

  public static class ListNamespacesPagedResponse
      extends AbstractPagedListResponse<
          ListNamespacesRequest,
          ListNamespacesResponse,
          Namespace,
          ListNamespacesPage,
          ListNamespacesFixedSizeCollection> {

    public static ApiFuture<ListNamespacesPagedResponse> createAsync(
        PageContext<ListNamespacesRequest, ListNamespacesResponse, Namespace> context,
        ApiFuture<ListNamespacesResponse> futureResponse) {
      ApiFuture<ListNamespacesPage> futurePage =
          ListNamespacesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListNamespacesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListNamespacesPagedResponse(ListNamespacesPage page) {
      super(page, ListNamespacesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListNamespacesPage
      extends AbstractPage<
          ListNamespacesRequest, ListNamespacesResponse, Namespace, ListNamespacesPage> {

    private ListNamespacesPage(
        PageContext<ListNamespacesRequest, ListNamespacesResponse, Namespace> context,
        ListNamespacesResponse response) {
      super(context, response);
    }

    private static ListNamespacesPage createEmptyPage() {
      return new ListNamespacesPage(null, null);
    }

    @Override
    protected ListNamespacesPage createPage(
        PageContext<ListNamespacesRequest, ListNamespacesResponse, Namespace> context,
        ListNamespacesResponse response) {
      return new ListNamespacesPage(context, response);
    }

    @Override
    public ApiFuture<ListNamespacesPage> createPageAsync(
        PageContext<ListNamespacesRequest, ListNamespacesResponse, Namespace> context,
        ApiFuture<ListNamespacesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListNamespacesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListNamespacesRequest,
          ListNamespacesResponse,
          Namespace,
          ListNamespacesPage,
          ListNamespacesFixedSizeCollection> {

    private ListNamespacesFixedSizeCollection(List<ListNamespacesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListNamespacesFixedSizeCollection createEmptyCollection() {
      return new ListNamespacesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListNamespacesFixedSizeCollection createCollection(
        List<ListNamespacesPage> pages, int collectionSize) {
      return new ListNamespacesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListDnsPeeringsPagedResponse
      extends AbstractPagedListResponse<
          ListDnsPeeringsRequest,
          ListDnsPeeringsResponse,
          DnsPeering,
          ListDnsPeeringsPage,
          ListDnsPeeringsFixedSizeCollection> {

    public static ApiFuture<ListDnsPeeringsPagedResponse> createAsync(
        PageContext<ListDnsPeeringsRequest, ListDnsPeeringsResponse, DnsPeering> context,
        ApiFuture<ListDnsPeeringsResponse> futureResponse) {
      ApiFuture<ListDnsPeeringsPage> futurePage =
          ListDnsPeeringsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDnsPeeringsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDnsPeeringsPagedResponse(ListDnsPeeringsPage page) {
      super(page, ListDnsPeeringsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDnsPeeringsPage
      extends AbstractPage<
          ListDnsPeeringsRequest, ListDnsPeeringsResponse, DnsPeering, ListDnsPeeringsPage> {

    private ListDnsPeeringsPage(
        PageContext<ListDnsPeeringsRequest, ListDnsPeeringsResponse, DnsPeering> context,
        ListDnsPeeringsResponse response) {
      super(context, response);
    }

    private static ListDnsPeeringsPage createEmptyPage() {
      return new ListDnsPeeringsPage(null, null);
    }

    @Override
    protected ListDnsPeeringsPage createPage(
        PageContext<ListDnsPeeringsRequest, ListDnsPeeringsResponse, DnsPeering> context,
        ListDnsPeeringsResponse response) {
      return new ListDnsPeeringsPage(context, response);
    }

    @Override
    public ApiFuture<ListDnsPeeringsPage> createPageAsync(
        PageContext<ListDnsPeeringsRequest, ListDnsPeeringsResponse, DnsPeering> context,
        ApiFuture<ListDnsPeeringsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDnsPeeringsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDnsPeeringsRequest,
          ListDnsPeeringsResponse,
          DnsPeering,
          ListDnsPeeringsPage,
          ListDnsPeeringsFixedSizeCollection> {

    private ListDnsPeeringsFixedSizeCollection(
        List<ListDnsPeeringsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDnsPeeringsFixedSizeCollection createEmptyCollection() {
      return new ListDnsPeeringsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDnsPeeringsFixedSizeCollection createCollection(
        List<ListDnsPeeringsPage> pages, int collectionSize) {
      return new ListDnsPeeringsFixedSizeCollection(pages, collectionSize);
    }
  }
}
