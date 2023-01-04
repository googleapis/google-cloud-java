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

package com.google.cloud.notebooks.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.notebooks.v1.stub.ManagedNotebookServiceStub;
import com.google.cloud.notebooks.v1.stub.ManagedNotebookServiceStubSettings;
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
 * Service Description: API v1 service for Managed Notebooks.
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
 * try (ManagedNotebookServiceClient managedNotebookServiceClient =
 *     ManagedNotebookServiceClient.create()) {
 *   RuntimeName name = RuntimeName.of("[PROJECT]", "[LOCATION]", "[RUNTIME]");
 *   Runtime response = managedNotebookServiceClient.getRuntime(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ManagedNotebookServiceClient object to clean up
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
 * <p>This class can be customized by passing in a custom instance of ManagedNotebookServiceSettings
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
 * ManagedNotebookServiceSettings managedNotebookServiceSettings =
 *     ManagedNotebookServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ManagedNotebookServiceClient managedNotebookServiceClient =
 *     ManagedNotebookServiceClient.create(managedNotebookServiceSettings);
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
 * ManagedNotebookServiceSettings managedNotebookServiceSettings =
 *     ManagedNotebookServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ManagedNotebookServiceClient managedNotebookServiceClient =
 *     ManagedNotebookServiceClient.create(managedNotebookServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class ManagedNotebookServiceClient implements BackgroundResource {
  private final ManagedNotebookServiceSettings settings;
  private final ManagedNotebookServiceStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of ManagedNotebookServiceClient with default settings. */
  public static final ManagedNotebookServiceClient create() throws IOException {
    return create(ManagedNotebookServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ManagedNotebookServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ManagedNotebookServiceClient create(ManagedNotebookServiceSettings settings)
      throws IOException {
    return new ManagedNotebookServiceClient(settings);
  }

  /**
   * Constructs an instance of ManagedNotebookServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(ManagedNotebookServiceSettings).
   */
  public static final ManagedNotebookServiceClient create(ManagedNotebookServiceStub stub) {
    return new ManagedNotebookServiceClient(stub);
  }

  /**
   * Constructs an instance of ManagedNotebookServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected ManagedNotebookServiceClient(ManagedNotebookServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((ManagedNotebookServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  protected ManagedNotebookServiceClient(ManagedNotebookServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final ManagedNotebookServiceSettings getSettings() {
    return settings;
  }

  public ManagedNotebookServiceStub getStub() {
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
   * Lists Runtimes in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedNotebookServiceClient managedNotebookServiceClient =
   *     ManagedNotebookServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Runtime element : managedNotebookServiceClient.listRuntimes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Format: `parent=projects/{project_id}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRuntimesPagedResponse listRuntimes(LocationName parent) {
    ListRuntimesRequest request =
        ListRuntimesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listRuntimes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Runtimes in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedNotebookServiceClient managedNotebookServiceClient =
   *     ManagedNotebookServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Runtime element : managedNotebookServiceClient.listRuntimes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Format: `parent=projects/{project_id}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRuntimesPagedResponse listRuntimes(String parent) {
    ListRuntimesRequest request = ListRuntimesRequest.newBuilder().setParent(parent).build();
    return listRuntimes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Runtimes in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedNotebookServiceClient managedNotebookServiceClient =
   *     ManagedNotebookServiceClient.create()) {
   *   ListRuntimesRequest request =
   *       ListRuntimesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Runtime element : managedNotebookServiceClient.listRuntimes(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRuntimesPagedResponse listRuntimes(ListRuntimesRequest request) {
    return listRuntimesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Runtimes in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedNotebookServiceClient managedNotebookServiceClient =
   *     ManagedNotebookServiceClient.create()) {
   *   ListRuntimesRequest request =
   *       ListRuntimesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Runtime> future =
   *       managedNotebookServiceClient.listRuntimesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Runtime element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListRuntimesRequest, ListRuntimesPagedResponse>
      listRuntimesPagedCallable() {
    return stub.listRuntimesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Runtimes in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedNotebookServiceClient managedNotebookServiceClient =
   *     ManagedNotebookServiceClient.create()) {
   *   ListRuntimesRequest request =
   *       ListRuntimesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListRuntimesResponse response =
   *         managedNotebookServiceClient.listRuntimesCallable().call(request);
   *     for (Runtime element : response.getRuntimesList()) {
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
  public final UnaryCallable<ListRuntimesRequest, ListRuntimesResponse> listRuntimesCallable() {
    return stub.listRuntimesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Runtime. The location must be a regional endpoint rather than zonal.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedNotebookServiceClient managedNotebookServiceClient =
   *     ManagedNotebookServiceClient.create()) {
   *   RuntimeName name = RuntimeName.of("[PROJECT]", "[LOCATION]", "[RUNTIME]");
   *   Runtime response = managedNotebookServiceClient.getRuntime(name);
   * }
   * }</pre>
   *
   * @param name Required. Format:
   *     `projects/{project_id}/locations/{location}/runtimes/{runtime_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Runtime getRuntime(RuntimeName name) {
    GetRuntimeRequest request =
        GetRuntimeRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getRuntime(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Runtime. The location must be a regional endpoint rather than zonal.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedNotebookServiceClient managedNotebookServiceClient =
   *     ManagedNotebookServiceClient.create()) {
   *   String name = RuntimeName.of("[PROJECT]", "[LOCATION]", "[RUNTIME]").toString();
   *   Runtime response = managedNotebookServiceClient.getRuntime(name);
   * }
   * }</pre>
   *
   * @param name Required. Format:
   *     `projects/{project_id}/locations/{location}/runtimes/{runtime_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Runtime getRuntime(String name) {
    GetRuntimeRequest request = GetRuntimeRequest.newBuilder().setName(name).build();
    return getRuntime(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Runtime. The location must be a regional endpoint rather than zonal.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedNotebookServiceClient managedNotebookServiceClient =
   *     ManagedNotebookServiceClient.create()) {
   *   GetRuntimeRequest request =
   *       GetRuntimeRequest.newBuilder()
   *           .setName(RuntimeName.of("[PROJECT]", "[LOCATION]", "[RUNTIME]").toString())
   *           .build();
   *   Runtime response = managedNotebookServiceClient.getRuntime(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Runtime getRuntime(GetRuntimeRequest request) {
    return getRuntimeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Runtime. The location must be a regional endpoint rather than zonal.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedNotebookServiceClient managedNotebookServiceClient =
   *     ManagedNotebookServiceClient.create()) {
   *   GetRuntimeRequest request =
   *       GetRuntimeRequest.newBuilder()
   *           .setName(RuntimeName.of("[PROJECT]", "[LOCATION]", "[RUNTIME]").toString())
   *           .build();
   *   ApiFuture<Runtime> future =
   *       managedNotebookServiceClient.getRuntimeCallable().futureCall(request);
   *   // Do something.
   *   Runtime response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRuntimeRequest, Runtime> getRuntimeCallable() {
    return stub.getRuntimeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Runtime in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedNotebookServiceClient managedNotebookServiceClient =
   *     ManagedNotebookServiceClient.create()) {
   *   RuntimeName parent = RuntimeName.of("[PROJECT]", "[LOCATION]", "[RUNTIME]");
   *   String runtimeId = "runtimeId121455379";
   *   Runtime runtime = Runtime.newBuilder().build();
   *   Runtime response =
   *       managedNotebookServiceClient.createRuntimeAsync(parent, runtimeId, runtime).get();
   * }
   * }</pre>
   *
   * @param parent Required. Format: `parent=projects/{project_id}/locations/{location}`
   * @param runtimeId Required. User-defined unique ID of this Runtime.
   * @param runtime Required. The Runtime to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Runtime, OperationMetadata> createRuntimeAsync(
      RuntimeName parent, String runtimeId, Runtime runtime) {
    CreateRuntimeRequest request =
        CreateRuntimeRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setRuntimeId(runtimeId)
            .setRuntime(runtime)
            .build();
    return createRuntimeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Runtime in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedNotebookServiceClient managedNotebookServiceClient =
   *     ManagedNotebookServiceClient.create()) {
   *   String parent = RuntimeName.of("[PROJECT]", "[LOCATION]", "[RUNTIME]").toString();
   *   String runtimeId = "runtimeId121455379";
   *   Runtime runtime = Runtime.newBuilder().build();
   *   Runtime response =
   *       managedNotebookServiceClient.createRuntimeAsync(parent, runtimeId, runtime).get();
   * }
   * }</pre>
   *
   * @param parent Required. Format: `parent=projects/{project_id}/locations/{location}`
   * @param runtimeId Required. User-defined unique ID of this Runtime.
   * @param runtime Required. The Runtime to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Runtime, OperationMetadata> createRuntimeAsync(
      String parent, String runtimeId, Runtime runtime) {
    CreateRuntimeRequest request =
        CreateRuntimeRequest.newBuilder()
            .setParent(parent)
            .setRuntimeId(runtimeId)
            .setRuntime(runtime)
            .build();
    return createRuntimeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Runtime in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedNotebookServiceClient managedNotebookServiceClient =
   *     ManagedNotebookServiceClient.create()) {
   *   CreateRuntimeRequest request =
   *       CreateRuntimeRequest.newBuilder()
   *           .setParent(RuntimeName.of("[PROJECT]", "[LOCATION]", "[RUNTIME]").toString())
   *           .setRuntimeId("runtimeId121455379")
   *           .setRuntime(Runtime.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Runtime response = managedNotebookServiceClient.createRuntimeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Runtime, OperationMetadata> createRuntimeAsync(
      CreateRuntimeRequest request) {
    return createRuntimeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Runtime in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedNotebookServiceClient managedNotebookServiceClient =
   *     ManagedNotebookServiceClient.create()) {
   *   CreateRuntimeRequest request =
   *       CreateRuntimeRequest.newBuilder()
   *           .setParent(RuntimeName.of("[PROJECT]", "[LOCATION]", "[RUNTIME]").toString())
   *           .setRuntimeId("runtimeId121455379")
   *           .setRuntime(Runtime.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Runtime, OperationMetadata> future =
   *       managedNotebookServiceClient.createRuntimeOperationCallable().futureCall(request);
   *   // Do something.
   *   Runtime response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateRuntimeRequest, Runtime, OperationMetadata>
      createRuntimeOperationCallable() {
    return stub.createRuntimeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Runtime in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedNotebookServiceClient managedNotebookServiceClient =
   *     ManagedNotebookServiceClient.create()) {
   *   CreateRuntimeRequest request =
   *       CreateRuntimeRequest.newBuilder()
   *           .setParent(RuntimeName.of("[PROJECT]", "[LOCATION]", "[RUNTIME]").toString())
   *           .setRuntimeId("runtimeId121455379")
   *           .setRuntime(Runtime.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       managedNotebookServiceClient.createRuntimeCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateRuntimeRequest, Operation> createRuntimeCallable() {
    return stub.createRuntimeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update Notebook Runtime configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedNotebookServiceClient managedNotebookServiceClient =
   *     ManagedNotebookServiceClient.create()) {
   *   Runtime runtime = Runtime.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Runtime response = managedNotebookServiceClient.updateRuntimeAsync(runtime, updateMask).get();
   * }
   * }</pre>
   *
   * @param runtime Required. The Runtime to be updated.
   * @param updateMask Required. Specifies the path, relative to `Runtime`, of the field to update.
   *     For example, to change the software configuration kernels, the `update_mask` parameter
   *     would be specified as `software_config.kernels`, and the `PATCH` request body would specify
   *     the new value, as follows:
   *     <p>{ "software_config":{ "kernels": [{ 'repository':
   *     'gcr.io/deeplearning-platform-release/pytorch-gpu', 'tag': 'latest' }], } }
   *     <p>Currently, only the following fields can be updated: - `software_config.kernels` -
   *     `software_config.post_startup_script` - `software_config.custom_gpu_driver_path` -
   *     `software_config.idle_shutdown` - `software_config.idle_shutdown_timeout` -
   *     `software_config.disable_terminal`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Runtime, OperationMetadata> updateRuntimeAsync(
      Runtime runtime, FieldMask updateMask) {
    UpdateRuntimeRequest request =
        UpdateRuntimeRequest.newBuilder().setRuntime(runtime).setUpdateMask(updateMask).build();
    return updateRuntimeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update Notebook Runtime configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedNotebookServiceClient managedNotebookServiceClient =
   *     ManagedNotebookServiceClient.create()) {
   *   UpdateRuntimeRequest request =
   *       UpdateRuntimeRequest.newBuilder()
   *           .setRuntime(Runtime.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Runtime response = managedNotebookServiceClient.updateRuntimeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Runtime, OperationMetadata> updateRuntimeAsync(
      UpdateRuntimeRequest request) {
    return updateRuntimeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update Notebook Runtime configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedNotebookServiceClient managedNotebookServiceClient =
   *     ManagedNotebookServiceClient.create()) {
   *   UpdateRuntimeRequest request =
   *       UpdateRuntimeRequest.newBuilder()
   *           .setRuntime(Runtime.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Runtime, OperationMetadata> future =
   *       managedNotebookServiceClient.updateRuntimeOperationCallable().futureCall(request);
   *   // Do something.
   *   Runtime response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateRuntimeRequest, Runtime, OperationMetadata>
      updateRuntimeOperationCallable() {
    return stub.updateRuntimeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update Notebook Runtime configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedNotebookServiceClient managedNotebookServiceClient =
   *     ManagedNotebookServiceClient.create()) {
   *   UpdateRuntimeRequest request =
   *       UpdateRuntimeRequest.newBuilder()
   *           .setRuntime(Runtime.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       managedNotebookServiceClient.updateRuntimeCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateRuntimeRequest, Operation> updateRuntimeCallable() {
    return stub.updateRuntimeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Runtime.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedNotebookServiceClient managedNotebookServiceClient =
   *     ManagedNotebookServiceClient.create()) {
   *   RuntimeName name = RuntimeName.of("[PROJECT]", "[LOCATION]", "[RUNTIME]");
   *   managedNotebookServiceClient.deleteRuntimeAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Format:
   *     `projects/{project_id}/locations/{location}/runtimes/{runtime_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteRuntimeAsync(RuntimeName name) {
    DeleteRuntimeRequest request =
        DeleteRuntimeRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteRuntimeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Runtime.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedNotebookServiceClient managedNotebookServiceClient =
   *     ManagedNotebookServiceClient.create()) {
   *   String name = RuntimeName.of("[PROJECT]", "[LOCATION]", "[RUNTIME]").toString();
   *   managedNotebookServiceClient.deleteRuntimeAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Format:
   *     `projects/{project_id}/locations/{location}/runtimes/{runtime_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteRuntimeAsync(String name) {
    DeleteRuntimeRequest request = DeleteRuntimeRequest.newBuilder().setName(name).build();
    return deleteRuntimeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Runtime.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedNotebookServiceClient managedNotebookServiceClient =
   *     ManagedNotebookServiceClient.create()) {
   *   DeleteRuntimeRequest request =
   *       DeleteRuntimeRequest.newBuilder()
   *           .setName(RuntimeName.of("[PROJECT]", "[LOCATION]", "[RUNTIME]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   managedNotebookServiceClient.deleteRuntimeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteRuntimeAsync(
      DeleteRuntimeRequest request) {
    return deleteRuntimeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Runtime.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedNotebookServiceClient managedNotebookServiceClient =
   *     ManagedNotebookServiceClient.create()) {
   *   DeleteRuntimeRequest request =
   *       DeleteRuntimeRequest.newBuilder()
   *           .setName(RuntimeName.of("[PROJECT]", "[LOCATION]", "[RUNTIME]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       managedNotebookServiceClient.deleteRuntimeOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteRuntimeRequest, Empty, OperationMetadata>
      deleteRuntimeOperationCallable() {
    return stub.deleteRuntimeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Runtime.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedNotebookServiceClient managedNotebookServiceClient =
   *     ManagedNotebookServiceClient.create()) {
   *   DeleteRuntimeRequest request =
   *       DeleteRuntimeRequest.newBuilder()
   *           .setName(RuntimeName.of("[PROJECT]", "[LOCATION]", "[RUNTIME]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       managedNotebookServiceClient.deleteRuntimeCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteRuntimeRequest, Operation> deleteRuntimeCallable() {
    return stub.deleteRuntimeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts a Managed Notebook Runtime. Perform "Start" on GPU instances; "Resume" on CPU instances
   * See: https://cloud.google.com/compute/docs/instances/stop-start-instance
   * https://cloud.google.com/compute/docs/instances/suspend-resume-instance
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedNotebookServiceClient managedNotebookServiceClient =
   *     ManagedNotebookServiceClient.create()) {
   *   String name = "name3373707";
   *   Runtime response = managedNotebookServiceClient.startRuntimeAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Format:
   *     `projects/{project_id}/locations/{location}/runtimes/{runtime_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Runtime, OperationMetadata> startRuntimeAsync(String name) {
    StartRuntimeRequest request = StartRuntimeRequest.newBuilder().setName(name).build();
    return startRuntimeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts a Managed Notebook Runtime. Perform "Start" on GPU instances; "Resume" on CPU instances
   * See: https://cloud.google.com/compute/docs/instances/stop-start-instance
   * https://cloud.google.com/compute/docs/instances/suspend-resume-instance
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedNotebookServiceClient managedNotebookServiceClient =
   *     ManagedNotebookServiceClient.create()) {
   *   StartRuntimeRequest request =
   *       StartRuntimeRequest.newBuilder()
   *           .setName("name3373707")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Runtime response = managedNotebookServiceClient.startRuntimeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Runtime, OperationMetadata> startRuntimeAsync(
      StartRuntimeRequest request) {
    return startRuntimeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts a Managed Notebook Runtime. Perform "Start" on GPU instances; "Resume" on CPU instances
   * See: https://cloud.google.com/compute/docs/instances/stop-start-instance
   * https://cloud.google.com/compute/docs/instances/suspend-resume-instance
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedNotebookServiceClient managedNotebookServiceClient =
   *     ManagedNotebookServiceClient.create()) {
   *   StartRuntimeRequest request =
   *       StartRuntimeRequest.newBuilder()
   *           .setName("name3373707")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Runtime, OperationMetadata> future =
   *       managedNotebookServiceClient.startRuntimeOperationCallable().futureCall(request);
   *   // Do something.
   *   Runtime response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<StartRuntimeRequest, Runtime, OperationMetadata>
      startRuntimeOperationCallable() {
    return stub.startRuntimeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts a Managed Notebook Runtime. Perform "Start" on GPU instances; "Resume" on CPU instances
   * See: https://cloud.google.com/compute/docs/instances/stop-start-instance
   * https://cloud.google.com/compute/docs/instances/suspend-resume-instance
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedNotebookServiceClient managedNotebookServiceClient =
   *     ManagedNotebookServiceClient.create()) {
   *   StartRuntimeRequest request =
   *       StartRuntimeRequest.newBuilder()
   *           .setName("name3373707")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       managedNotebookServiceClient.startRuntimeCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<StartRuntimeRequest, Operation> startRuntimeCallable() {
    return stub.startRuntimeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stops a Managed Notebook Runtime. Perform "Stop" on GPU instances; "Suspend" on CPU instances
   * See: https://cloud.google.com/compute/docs/instances/stop-start-instance
   * https://cloud.google.com/compute/docs/instances/suspend-resume-instance
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedNotebookServiceClient managedNotebookServiceClient =
   *     ManagedNotebookServiceClient.create()) {
   *   String name = "name3373707";
   *   Runtime response = managedNotebookServiceClient.stopRuntimeAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Format:
   *     `projects/{project_id}/locations/{location}/runtimes/{runtime_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Runtime, OperationMetadata> stopRuntimeAsync(String name) {
    StopRuntimeRequest request = StopRuntimeRequest.newBuilder().setName(name).build();
    return stopRuntimeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stops a Managed Notebook Runtime. Perform "Stop" on GPU instances; "Suspend" on CPU instances
   * See: https://cloud.google.com/compute/docs/instances/stop-start-instance
   * https://cloud.google.com/compute/docs/instances/suspend-resume-instance
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedNotebookServiceClient managedNotebookServiceClient =
   *     ManagedNotebookServiceClient.create()) {
   *   StopRuntimeRequest request =
   *       StopRuntimeRequest.newBuilder()
   *           .setName("name3373707")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Runtime response = managedNotebookServiceClient.stopRuntimeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Runtime, OperationMetadata> stopRuntimeAsync(
      StopRuntimeRequest request) {
    return stopRuntimeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stops a Managed Notebook Runtime. Perform "Stop" on GPU instances; "Suspend" on CPU instances
   * See: https://cloud.google.com/compute/docs/instances/stop-start-instance
   * https://cloud.google.com/compute/docs/instances/suspend-resume-instance
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedNotebookServiceClient managedNotebookServiceClient =
   *     ManagedNotebookServiceClient.create()) {
   *   StopRuntimeRequest request =
   *       StopRuntimeRequest.newBuilder()
   *           .setName("name3373707")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Runtime, OperationMetadata> future =
   *       managedNotebookServiceClient.stopRuntimeOperationCallable().futureCall(request);
   *   // Do something.
   *   Runtime response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<StopRuntimeRequest, Runtime, OperationMetadata>
      stopRuntimeOperationCallable() {
    return stub.stopRuntimeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stops a Managed Notebook Runtime. Perform "Stop" on GPU instances; "Suspend" on CPU instances
   * See: https://cloud.google.com/compute/docs/instances/stop-start-instance
   * https://cloud.google.com/compute/docs/instances/suspend-resume-instance
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedNotebookServiceClient managedNotebookServiceClient =
   *     ManagedNotebookServiceClient.create()) {
   *   StopRuntimeRequest request =
   *       StopRuntimeRequest.newBuilder()
   *           .setName("name3373707")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       managedNotebookServiceClient.stopRuntimeCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<StopRuntimeRequest, Operation> stopRuntimeCallable() {
    return stub.stopRuntimeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Switch a Managed Notebook Runtime.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedNotebookServiceClient managedNotebookServiceClient =
   *     ManagedNotebookServiceClient.create()) {
   *   String name = "name3373707";
   *   Runtime response = managedNotebookServiceClient.switchRuntimeAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Format:
   *     `projects/{project_id}/locations/{location}/runtimes/{runtime_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Runtime, OperationMetadata> switchRuntimeAsync(String name) {
    SwitchRuntimeRequest request = SwitchRuntimeRequest.newBuilder().setName(name).build();
    return switchRuntimeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Switch a Managed Notebook Runtime.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedNotebookServiceClient managedNotebookServiceClient =
   *     ManagedNotebookServiceClient.create()) {
   *   SwitchRuntimeRequest request =
   *       SwitchRuntimeRequest.newBuilder()
   *           .setName("name3373707")
   *           .setMachineType("machineType-218117087")
   *           .setAcceleratorConfig(RuntimeAcceleratorConfig.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Runtime response = managedNotebookServiceClient.switchRuntimeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Runtime, OperationMetadata> switchRuntimeAsync(
      SwitchRuntimeRequest request) {
    return switchRuntimeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Switch a Managed Notebook Runtime.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedNotebookServiceClient managedNotebookServiceClient =
   *     ManagedNotebookServiceClient.create()) {
   *   SwitchRuntimeRequest request =
   *       SwitchRuntimeRequest.newBuilder()
   *           .setName("name3373707")
   *           .setMachineType("machineType-218117087")
   *           .setAcceleratorConfig(RuntimeAcceleratorConfig.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Runtime, OperationMetadata> future =
   *       managedNotebookServiceClient.switchRuntimeOperationCallable().futureCall(request);
   *   // Do something.
   *   Runtime response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<SwitchRuntimeRequest, Runtime, OperationMetadata>
      switchRuntimeOperationCallable() {
    return stub.switchRuntimeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Switch a Managed Notebook Runtime.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedNotebookServiceClient managedNotebookServiceClient =
   *     ManagedNotebookServiceClient.create()) {
   *   SwitchRuntimeRequest request =
   *       SwitchRuntimeRequest.newBuilder()
   *           .setName("name3373707")
   *           .setMachineType("machineType-218117087")
   *           .setAcceleratorConfig(RuntimeAcceleratorConfig.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       managedNotebookServiceClient.switchRuntimeCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SwitchRuntimeRequest, Operation> switchRuntimeCallable() {
    return stub.switchRuntimeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resets a Managed Notebook Runtime.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedNotebookServiceClient managedNotebookServiceClient =
   *     ManagedNotebookServiceClient.create()) {
   *   String name = "name3373707";
   *   Runtime response = managedNotebookServiceClient.resetRuntimeAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Format:
   *     `projects/{project_id}/locations/{location}/runtimes/{runtime_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Runtime, OperationMetadata> resetRuntimeAsync(String name) {
    ResetRuntimeRequest request = ResetRuntimeRequest.newBuilder().setName(name).build();
    return resetRuntimeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resets a Managed Notebook Runtime.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedNotebookServiceClient managedNotebookServiceClient =
   *     ManagedNotebookServiceClient.create()) {
   *   ResetRuntimeRequest request =
   *       ResetRuntimeRequest.newBuilder()
   *           .setName("name3373707")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Runtime response = managedNotebookServiceClient.resetRuntimeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Runtime, OperationMetadata> resetRuntimeAsync(
      ResetRuntimeRequest request) {
    return resetRuntimeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resets a Managed Notebook Runtime.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedNotebookServiceClient managedNotebookServiceClient =
   *     ManagedNotebookServiceClient.create()) {
   *   ResetRuntimeRequest request =
   *       ResetRuntimeRequest.newBuilder()
   *           .setName("name3373707")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Runtime, OperationMetadata> future =
   *       managedNotebookServiceClient.resetRuntimeOperationCallable().futureCall(request);
   *   // Do something.
   *   Runtime response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<ResetRuntimeRequest, Runtime, OperationMetadata>
      resetRuntimeOperationCallable() {
    return stub.resetRuntimeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resets a Managed Notebook Runtime.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedNotebookServiceClient managedNotebookServiceClient =
   *     ManagedNotebookServiceClient.create()) {
   *   ResetRuntimeRequest request =
   *       ResetRuntimeRequest.newBuilder()
   *           .setName("name3373707")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       managedNotebookServiceClient.resetRuntimeCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ResetRuntimeRequest, Operation> resetRuntimeCallable() {
    return stub.resetRuntimeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Upgrades a Managed Notebook Runtime to the latest version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedNotebookServiceClient managedNotebookServiceClient =
   *     ManagedNotebookServiceClient.create()) {
   *   String name = "name3373707";
   *   Runtime response = managedNotebookServiceClient.upgradeRuntimeAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Format:
   *     `projects/{project_id}/locations/{location}/runtimes/{runtime_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Runtime, OperationMetadata> upgradeRuntimeAsync(String name) {
    UpgradeRuntimeRequest request = UpgradeRuntimeRequest.newBuilder().setName(name).build();
    return upgradeRuntimeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Upgrades a Managed Notebook Runtime to the latest version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedNotebookServiceClient managedNotebookServiceClient =
   *     ManagedNotebookServiceClient.create()) {
   *   UpgradeRuntimeRequest request =
   *       UpgradeRuntimeRequest.newBuilder()
   *           .setName("name3373707")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Runtime response = managedNotebookServiceClient.upgradeRuntimeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Runtime, OperationMetadata> upgradeRuntimeAsync(
      UpgradeRuntimeRequest request) {
    return upgradeRuntimeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Upgrades a Managed Notebook Runtime to the latest version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedNotebookServiceClient managedNotebookServiceClient =
   *     ManagedNotebookServiceClient.create()) {
   *   UpgradeRuntimeRequest request =
   *       UpgradeRuntimeRequest.newBuilder()
   *           .setName("name3373707")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Runtime, OperationMetadata> future =
   *       managedNotebookServiceClient.upgradeRuntimeOperationCallable().futureCall(request);
   *   // Do something.
   *   Runtime response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpgradeRuntimeRequest, Runtime, OperationMetadata>
      upgradeRuntimeOperationCallable() {
    return stub.upgradeRuntimeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Upgrades a Managed Notebook Runtime to the latest version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedNotebookServiceClient managedNotebookServiceClient =
   *     ManagedNotebookServiceClient.create()) {
   *   UpgradeRuntimeRequest request =
   *       UpgradeRuntimeRequest.newBuilder()
   *           .setName("name3373707")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       managedNotebookServiceClient.upgradeRuntimeCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpgradeRuntimeRequest, Operation> upgradeRuntimeCallable() {
    return stub.upgradeRuntimeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Report and process a runtime event.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedNotebookServiceClient managedNotebookServiceClient =
   *     ManagedNotebookServiceClient.create()) {
   *   RuntimeName name = RuntimeName.of("[PROJECT]", "[LOCATION]", "[RUNTIME]");
   *   Runtime response = managedNotebookServiceClient.reportRuntimeEventAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Format:
   *     `projects/{project_id}/locations/{location}/runtimes/{runtime_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Runtime, OperationMetadata> reportRuntimeEventAsync(
      RuntimeName name) {
    ReportRuntimeEventRequest request =
        ReportRuntimeEventRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return reportRuntimeEventAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Report and process a runtime event.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedNotebookServiceClient managedNotebookServiceClient =
   *     ManagedNotebookServiceClient.create()) {
   *   String name = RuntimeName.of("[PROJECT]", "[LOCATION]", "[RUNTIME]").toString();
   *   Runtime response = managedNotebookServiceClient.reportRuntimeEventAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Format:
   *     `projects/{project_id}/locations/{location}/runtimes/{runtime_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Runtime, OperationMetadata> reportRuntimeEventAsync(String name) {
    ReportRuntimeEventRequest request =
        ReportRuntimeEventRequest.newBuilder().setName(name).build();
    return reportRuntimeEventAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Report and process a runtime event.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedNotebookServiceClient managedNotebookServiceClient =
   *     ManagedNotebookServiceClient.create()) {
   *   ReportRuntimeEventRequest request =
   *       ReportRuntimeEventRequest.newBuilder()
   *           .setName(RuntimeName.of("[PROJECT]", "[LOCATION]", "[RUNTIME]").toString())
   *           .setVmId("vmId3622450")
   *           .setEvent(Event.newBuilder().build())
   *           .build();
   *   Runtime response = managedNotebookServiceClient.reportRuntimeEventAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Runtime, OperationMetadata> reportRuntimeEventAsync(
      ReportRuntimeEventRequest request) {
    return reportRuntimeEventOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Report and process a runtime event.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedNotebookServiceClient managedNotebookServiceClient =
   *     ManagedNotebookServiceClient.create()) {
   *   ReportRuntimeEventRequest request =
   *       ReportRuntimeEventRequest.newBuilder()
   *           .setName(RuntimeName.of("[PROJECT]", "[LOCATION]", "[RUNTIME]").toString())
   *           .setVmId("vmId3622450")
   *           .setEvent(Event.newBuilder().build())
   *           .build();
   *   OperationFuture<Runtime, OperationMetadata> future =
   *       managedNotebookServiceClient.reportRuntimeEventOperationCallable().futureCall(request);
   *   // Do something.
   *   Runtime response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<ReportRuntimeEventRequest, Runtime, OperationMetadata>
      reportRuntimeEventOperationCallable() {
    return stub.reportRuntimeEventOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Report and process a runtime event.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedNotebookServiceClient managedNotebookServiceClient =
   *     ManagedNotebookServiceClient.create()) {
   *   ReportRuntimeEventRequest request =
   *       ReportRuntimeEventRequest.newBuilder()
   *           .setName(RuntimeName.of("[PROJECT]", "[LOCATION]", "[RUNTIME]").toString())
   *           .setVmId("vmId3622450")
   *           .setEvent(Event.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       managedNotebookServiceClient.reportRuntimeEventCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ReportRuntimeEventRequest, Operation> reportRuntimeEventCallable() {
    return stub.reportRuntimeEventCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an access token for the consumer service account that the customer attached to the
   * runtime. Only accessible from the tenant instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedNotebookServiceClient managedNotebookServiceClient =
   *     ManagedNotebookServiceClient.create()) {
   *   RuntimeName name = RuntimeName.of("[PROJECT]", "[LOCATION]", "[RUNTIME]");
   *   String vmId = "vmId3622450";
   *   RefreshRuntimeTokenInternalResponse response =
   *       managedNotebookServiceClient.refreshRuntimeTokenInternal(name, vmId);
   * }
   * }</pre>
   *
   * @param name Required. Format:
   *     `projects/{project_id}/locations/{location}/runtimes/{runtime_id}`
   * @param vmId Required. The VM hardware token for authenticating the VM.
   *     https://cloud.google.com/compute/docs/instances/verifying-instance-identity
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RefreshRuntimeTokenInternalResponse refreshRuntimeTokenInternal(
      RuntimeName name, String vmId) {
    RefreshRuntimeTokenInternalRequest request =
        RefreshRuntimeTokenInternalRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setVmId(vmId)
            .build();
    return refreshRuntimeTokenInternal(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an access token for the consumer service account that the customer attached to the
   * runtime. Only accessible from the tenant instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedNotebookServiceClient managedNotebookServiceClient =
   *     ManagedNotebookServiceClient.create()) {
   *   String name = RuntimeName.of("[PROJECT]", "[LOCATION]", "[RUNTIME]").toString();
   *   String vmId = "vmId3622450";
   *   RefreshRuntimeTokenInternalResponse response =
   *       managedNotebookServiceClient.refreshRuntimeTokenInternal(name, vmId);
   * }
   * }</pre>
   *
   * @param name Required. Format:
   *     `projects/{project_id}/locations/{location}/runtimes/{runtime_id}`
   * @param vmId Required. The VM hardware token for authenticating the VM.
   *     https://cloud.google.com/compute/docs/instances/verifying-instance-identity
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RefreshRuntimeTokenInternalResponse refreshRuntimeTokenInternal(
      String name, String vmId) {
    RefreshRuntimeTokenInternalRequest request =
        RefreshRuntimeTokenInternalRequest.newBuilder().setName(name).setVmId(vmId).build();
    return refreshRuntimeTokenInternal(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an access token for the consumer service account that the customer attached to the
   * runtime. Only accessible from the tenant instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedNotebookServiceClient managedNotebookServiceClient =
   *     ManagedNotebookServiceClient.create()) {
   *   RefreshRuntimeTokenInternalRequest request =
   *       RefreshRuntimeTokenInternalRequest.newBuilder()
   *           .setName(RuntimeName.of("[PROJECT]", "[LOCATION]", "[RUNTIME]").toString())
   *           .setVmId("vmId3622450")
   *           .build();
   *   RefreshRuntimeTokenInternalResponse response =
   *       managedNotebookServiceClient.refreshRuntimeTokenInternal(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RefreshRuntimeTokenInternalResponse refreshRuntimeTokenInternal(
      RefreshRuntimeTokenInternalRequest request) {
    return refreshRuntimeTokenInternalCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an access token for the consumer service account that the customer attached to the
   * runtime. Only accessible from the tenant instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedNotebookServiceClient managedNotebookServiceClient =
   *     ManagedNotebookServiceClient.create()) {
   *   RefreshRuntimeTokenInternalRequest request =
   *       RefreshRuntimeTokenInternalRequest.newBuilder()
   *           .setName(RuntimeName.of("[PROJECT]", "[LOCATION]", "[RUNTIME]").toString())
   *           .setVmId("vmId3622450")
   *           .build();
   *   ApiFuture<RefreshRuntimeTokenInternalResponse> future =
   *       managedNotebookServiceClient.refreshRuntimeTokenInternalCallable().futureCall(request);
   *   // Do something.
   *   RefreshRuntimeTokenInternalResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          RefreshRuntimeTokenInternalRequest, RefreshRuntimeTokenInternalResponse>
      refreshRuntimeTokenInternalCallable() {
    return stub.refreshRuntimeTokenInternalCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Diagnostic File and runs Diagnostic Tool given a Runtime.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedNotebookServiceClient managedNotebookServiceClient =
   *     ManagedNotebookServiceClient.create()) {
   *   RuntimeName name = RuntimeName.of("[PROJECT]", "[LOCATION]", "[RUNTIME]");
   *   DiagnosticConfig diagnosticConfig = DiagnosticConfig.newBuilder().build();
   *   Runtime response =
   *       managedNotebookServiceClient.diagnoseRuntimeAsync(name, diagnosticConfig).get();
   * }
   * }</pre>
   *
   * @param name Required. Format:
   *     `projects/{project_id}/locations/{location}/runtimes/{runtimes_id}`
   * @param diagnosticConfig Required. Defines flags that are used to run the diagnostic tool
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Runtime, OperationMetadata> diagnoseRuntimeAsync(
      RuntimeName name, DiagnosticConfig diagnosticConfig) {
    DiagnoseRuntimeRequest request =
        DiagnoseRuntimeRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setDiagnosticConfig(diagnosticConfig)
            .build();
    return diagnoseRuntimeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Diagnostic File and runs Diagnostic Tool given a Runtime.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedNotebookServiceClient managedNotebookServiceClient =
   *     ManagedNotebookServiceClient.create()) {
   *   String name = RuntimeName.of("[PROJECT]", "[LOCATION]", "[RUNTIME]").toString();
   *   DiagnosticConfig diagnosticConfig = DiagnosticConfig.newBuilder().build();
   *   Runtime response =
   *       managedNotebookServiceClient.diagnoseRuntimeAsync(name, diagnosticConfig).get();
   * }
   * }</pre>
   *
   * @param name Required. Format:
   *     `projects/{project_id}/locations/{location}/runtimes/{runtimes_id}`
   * @param diagnosticConfig Required. Defines flags that are used to run the diagnostic tool
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Runtime, OperationMetadata> diagnoseRuntimeAsync(
      String name, DiagnosticConfig diagnosticConfig) {
    DiagnoseRuntimeRequest request =
        DiagnoseRuntimeRequest.newBuilder()
            .setName(name)
            .setDiagnosticConfig(diagnosticConfig)
            .build();
    return diagnoseRuntimeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Diagnostic File and runs Diagnostic Tool given a Runtime.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedNotebookServiceClient managedNotebookServiceClient =
   *     ManagedNotebookServiceClient.create()) {
   *   DiagnoseRuntimeRequest request =
   *       DiagnoseRuntimeRequest.newBuilder()
   *           .setName(RuntimeName.of("[PROJECT]", "[LOCATION]", "[RUNTIME]").toString())
   *           .setDiagnosticConfig(DiagnosticConfig.newBuilder().build())
   *           .build();
   *   Runtime response = managedNotebookServiceClient.diagnoseRuntimeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Runtime, OperationMetadata> diagnoseRuntimeAsync(
      DiagnoseRuntimeRequest request) {
    return diagnoseRuntimeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Diagnostic File and runs Diagnostic Tool given a Runtime.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedNotebookServiceClient managedNotebookServiceClient =
   *     ManagedNotebookServiceClient.create()) {
   *   DiagnoseRuntimeRequest request =
   *       DiagnoseRuntimeRequest.newBuilder()
   *           .setName(RuntimeName.of("[PROJECT]", "[LOCATION]", "[RUNTIME]").toString())
   *           .setDiagnosticConfig(DiagnosticConfig.newBuilder().build())
   *           .build();
   *   OperationFuture<Runtime, OperationMetadata> future =
   *       managedNotebookServiceClient.diagnoseRuntimeOperationCallable().futureCall(request);
   *   // Do something.
   *   Runtime response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DiagnoseRuntimeRequest, Runtime, OperationMetadata>
      diagnoseRuntimeOperationCallable() {
    return stub.diagnoseRuntimeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Diagnostic File and runs Diagnostic Tool given a Runtime.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedNotebookServiceClient managedNotebookServiceClient =
   *     ManagedNotebookServiceClient.create()) {
   *   DiagnoseRuntimeRequest request =
   *       DiagnoseRuntimeRequest.newBuilder()
   *           .setName(RuntimeName.of("[PROJECT]", "[LOCATION]", "[RUNTIME]").toString())
   *           .setDiagnosticConfig(DiagnosticConfig.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       managedNotebookServiceClient.diagnoseRuntimeCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DiagnoseRuntimeRequest, Operation> diagnoseRuntimeCallable() {
    return stub.diagnoseRuntimeCallable();
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
   * try (ManagedNotebookServiceClient managedNotebookServiceClient =
   *     ManagedNotebookServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : managedNotebookServiceClient.listLocations(request).iterateAll()) {
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
   * try (ManagedNotebookServiceClient managedNotebookServiceClient =
   *     ManagedNotebookServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       managedNotebookServiceClient.listLocationsPagedCallable().futureCall(request);
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
   * try (ManagedNotebookServiceClient managedNotebookServiceClient =
   *     ManagedNotebookServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         managedNotebookServiceClient.listLocationsCallable().call(request);
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
   * try (ManagedNotebookServiceClient managedNotebookServiceClient =
   *     ManagedNotebookServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = managedNotebookServiceClient.getLocation(request);
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
   * try (ManagedNotebookServiceClient managedNotebookServiceClient =
   *     ManagedNotebookServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future =
   *       managedNotebookServiceClient.getLocationCallable().futureCall(request);
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
   * try (ManagedNotebookServiceClient managedNotebookServiceClient =
   *     ManagedNotebookServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(RuntimeName.of("[PROJECT]", "[LOCATION]", "[RUNTIME]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = managedNotebookServiceClient.setIamPolicy(request);
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
   * try (ManagedNotebookServiceClient managedNotebookServiceClient =
   *     ManagedNotebookServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(RuntimeName.of("[PROJECT]", "[LOCATION]", "[RUNTIME]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       managedNotebookServiceClient.setIamPolicyCallable().futureCall(request);
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
   * try (ManagedNotebookServiceClient managedNotebookServiceClient =
   *     ManagedNotebookServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(RuntimeName.of("[PROJECT]", "[LOCATION]", "[RUNTIME]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = managedNotebookServiceClient.getIamPolicy(request);
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
   * try (ManagedNotebookServiceClient managedNotebookServiceClient =
   *     ManagedNotebookServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(RuntimeName.of("[PROJECT]", "[LOCATION]", "[RUNTIME]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       managedNotebookServiceClient.getIamPolicyCallable().futureCall(request);
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
   * try (ManagedNotebookServiceClient managedNotebookServiceClient =
   *     ManagedNotebookServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(RuntimeName.of("[PROJECT]", "[LOCATION]", "[RUNTIME]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response =
   *       managedNotebookServiceClient.testIamPermissions(request);
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
   * try (ManagedNotebookServiceClient managedNotebookServiceClient =
   *     ManagedNotebookServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(RuntimeName.of("[PROJECT]", "[LOCATION]", "[RUNTIME]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       managedNotebookServiceClient.testIamPermissionsCallable().futureCall(request);
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

  public static class ListRuntimesPagedResponse
      extends AbstractPagedListResponse<
          ListRuntimesRequest,
          ListRuntimesResponse,
          Runtime,
          ListRuntimesPage,
          ListRuntimesFixedSizeCollection> {

    public static ApiFuture<ListRuntimesPagedResponse> createAsync(
        PageContext<ListRuntimesRequest, ListRuntimesResponse, Runtime> context,
        ApiFuture<ListRuntimesResponse> futureResponse) {
      ApiFuture<ListRuntimesPage> futurePage =
          ListRuntimesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListRuntimesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListRuntimesPagedResponse(ListRuntimesPage page) {
      super(page, ListRuntimesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListRuntimesPage
      extends AbstractPage<ListRuntimesRequest, ListRuntimesResponse, Runtime, ListRuntimesPage> {

    private ListRuntimesPage(
        PageContext<ListRuntimesRequest, ListRuntimesResponse, Runtime> context,
        ListRuntimesResponse response) {
      super(context, response);
    }

    private static ListRuntimesPage createEmptyPage() {
      return new ListRuntimesPage(null, null);
    }

    @Override
    protected ListRuntimesPage createPage(
        PageContext<ListRuntimesRequest, ListRuntimesResponse, Runtime> context,
        ListRuntimesResponse response) {
      return new ListRuntimesPage(context, response);
    }

    @Override
    public ApiFuture<ListRuntimesPage> createPageAsync(
        PageContext<ListRuntimesRequest, ListRuntimesResponse, Runtime> context,
        ApiFuture<ListRuntimesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListRuntimesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRuntimesRequest,
          ListRuntimesResponse,
          Runtime,
          ListRuntimesPage,
          ListRuntimesFixedSizeCollection> {

    private ListRuntimesFixedSizeCollection(List<ListRuntimesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListRuntimesFixedSizeCollection createEmptyCollection() {
      return new ListRuntimesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListRuntimesFixedSizeCollection createCollection(
        List<ListRuntimesPage> pages, int collectionSize) {
      return new ListRuntimesFixedSizeCollection(pages, collectionSize);
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
