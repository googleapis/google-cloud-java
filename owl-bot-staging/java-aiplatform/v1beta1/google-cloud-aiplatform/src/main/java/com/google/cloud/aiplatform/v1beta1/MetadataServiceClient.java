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
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1beta1.stub.MetadataServiceStub;
import com.google.cloud.aiplatform.v1beta1.stub.MetadataServiceStubSettings;
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
 * Service Description: Service for reading and writing metadata entries.
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
 * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
 *   MetadataStoreName name = MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]");
 *   MetadataStore response = metadataServiceClient.getMetadataStore(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the MetadataServiceClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of MetadataServiceSettings to
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
 * MetadataServiceSettings metadataServiceSettings =
 *     MetadataServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * MetadataServiceClient metadataServiceClient =
 *     MetadataServiceClient.create(metadataServiceSettings);
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
 * MetadataServiceSettings metadataServiceSettings =
 *     MetadataServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * MetadataServiceClient metadataServiceClient =
 *     MetadataServiceClient.create(metadataServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class MetadataServiceClient implements BackgroundResource {
  private final MetadataServiceSettings settings;
  private final MetadataServiceStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of MetadataServiceClient with default settings. */
  public static final MetadataServiceClient create() throws IOException {
    return create(MetadataServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of MetadataServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final MetadataServiceClient create(MetadataServiceSettings settings)
      throws IOException {
    return new MetadataServiceClient(settings);
  }

  /**
   * Constructs an instance of MetadataServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(MetadataServiceSettings).
   */
  public static final MetadataServiceClient create(MetadataServiceStub stub) {
    return new MetadataServiceClient(stub);
  }

  /**
   * Constructs an instance of MetadataServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected MetadataServiceClient(MetadataServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((MetadataServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  protected MetadataServiceClient(MetadataServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final MetadataServiceSettings getSettings() {
    return settings;
  }

  public MetadataServiceStub getStub() {
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
   * Initializes a MetadataStore, including allocation of resources.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   MetadataStore metadataStore = MetadataStore.newBuilder().build();
   *   String metadataStoreId = "metadataStoreId-1811789907";
   *   MetadataStore response =
   *       metadataServiceClient
   *           .createMetadataStoreAsync(parent, metadataStore, metadataStoreId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location where the MetadataStore should be
   *     created. Format: `projects/{project}/locations/{location}/`
   * @param metadataStore Required. The MetadataStore to create.
   * @param metadataStoreId The {metadatastore} portion of the resource name with the format:
   *     `projects/{project}/locations/{location}/metadataStores/{metadatastore}` If not provided,
   *     the MetadataStore's ID will be a UUID generated by the service. Must be 4-128 characters in
   *     length. Valid characters are `/[a-z][0-9]-/`. Must be unique across all MetadataStores in
   *     the parent Location. (Otherwise the request will fail with ALREADY_EXISTS, or
   *     PERMISSION_DENIED if the caller can't view the preexisting MetadataStore.)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MetadataStore, CreateMetadataStoreOperationMetadata>
      createMetadataStoreAsync(
          LocationName parent, MetadataStore metadataStore, String metadataStoreId) {
    CreateMetadataStoreRequest request =
        CreateMetadataStoreRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setMetadataStore(metadataStore)
            .setMetadataStoreId(metadataStoreId)
            .build();
    return createMetadataStoreAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initializes a MetadataStore, including allocation of resources.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   MetadataStore metadataStore = MetadataStore.newBuilder().build();
   *   String metadataStoreId = "metadataStoreId-1811789907";
   *   MetadataStore response =
   *       metadataServiceClient
   *           .createMetadataStoreAsync(parent, metadataStore, metadataStoreId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location where the MetadataStore should be
   *     created. Format: `projects/{project}/locations/{location}/`
   * @param metadataStore Required. The MetadataStore to create.
   * @param metadataStoreId The {metadatastore} portion of the resource name with the format:
   *     `projects/{project}/locations/{location}/metadataStores/{metadatastore}` If not provided,
   *     the MetadataStore's ID will be a UUID generated by the service. Must be 4-128 characters in
   *     length. Valid characters are `/[a-z][0-9]-/`. Must be unique across all MetadataStores in
   *     the parent Location. (Otherwise the request will fail with ALREADY_EXISTS, or
   *     PERMISSION_DENIED if the caller can't view the preexisting MetadataStore.)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MetadataStore, CreateMetadataStoreOperationMetadata>
      createMetadataStoreAsync(String parent, MetadataStore metadataStore, String metadataStoreId) {
    CreateMetadataStoreRequest request =
        CreateMetadataStoreRequest.newBuilder()
            .setParent(parent)
            .setMetadataStore(metadataStore)
            .setMetadataStoreId(metadataStoreId)
            .build();
    return createMetadataStoreAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initializes a MetadataStore, including allocation of resources.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   CreateMetadataStoreRequest request =
   *       CreateMetadataStoreRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setMetadataStore(MetadataStore.newBuilder().build())
   *           .setMetadataStoreId("metadataStoreId-1811789907")
   *           .build();
   *   MetadataStore response = metadataServiceClient.createMetadataStoreAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MetadataStore, CreateMetadataStoreOperationMetadata>
      createMetadataStoreAsync(CreateMetadataStoreRequest request) {
    return createMetadataStoreOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initializes a MetadataStore, including allocation of resources.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   CreateMetadataStoreRequest request =
   *       CreateMetadataStoreRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setMetadataStore(MetadataStore.newBuilder().build())
   *           .setMetadataStoreId("metadataStoreId-1811789907")
   *           .build();
   *   OperationFuture<MetadataStore, CreateMetadataStoreOperationMetadata> future =
   *       metadataServiceClient.createMetadataStoreOperationCallable().futureCall(request);
   *   // Do something.
   *   MetadataStore response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateMetadataStoreRequest, MetadataStore, CreateMetadataStoreOperationMetadata>
      createMetadataStoreOperationCallable() {
    return stub.createMetadataStoreOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initializes a MetadataStore, including allocation of resources.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   CreateMetadataStoreRequest request =
   *       CreateMetadataStoreRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setMetadataStore(MetadataStore.newBuilder().build())
   *           .setMetadataStoreId("metadataStoreId-1811789907")
   *           .build();
   *   ApiFuture<Operation> future =
   *       metadataServiceClient.createMetadataStoreCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateMetadataStoreRequest, Operation> createMetadataStoreCallable() {
    return stub.createMetadataStoreCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a specific MetadataStore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   MetadataStoreName name = MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]");
   *   MetadataStore response = metadataServiceClient.getMetadataStore(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the MetadataStore to retrieve. Format:
   *     `projects/{project}/locations/{location}/metadataStores/{metadatastore}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MetadataStore getMetadataStore(MetadataStoreName name) {
    GetMetadataStoreRequest request =
        GetMetadataStoreRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getMetadataStore(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a specific MetadataStore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   String name = MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]").toString();
   *   MetadataStore response = metadataServiceClient.getMetadataStore(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the MetadataStore to retrieve. Format:
   *     `projects/{project}/locations/{location}/metadataStores/{metadatastore}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MetadataStore getMetadataStore(String name) {
    GetMetadataStoreRequest request = GetMetadataStoreRequest.newBuilder().setName(name).build();
    return getMetadataStore(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a specific MetadataStore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   GetMetadataStoreRequest request =
   *       GetMetadataStoreRequest.newBuilder()
   *           .setName(
   *               MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]").toString())
   *           .build();
   *   MetadataStore response = metadataServiceClient.getMetadataStore(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MetadataStore getMetadataStore(GetMetadataStoreRequest request) {
    return getMetadataStoreCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a specific MetadataStore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   GetMetadataStoreRequest request =
   *       GetMetadataStoreRequest.newBuilder()
   *           .setName(
   *               MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]").toString())
   *           .build();
   *   ApiFuture<MetadataStore> future =
   *       metadataServiceClient.getMetadataStoreCallable().futureCall(request);
   *   // Do something.
   *   MetadataStore response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetMetadataStoreRequest, MetadataStore> getMetadataStoreCallable() {
    return stub.getMetadataStoreCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists MetadataStores for a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (MetadataStore element : metadataServiceClient.listMetadataStores(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The Location whose MetadataStores should be listed. Format:
   *     `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMetadataStoresPagedResponse listMetadataStores(LocationName parent) {
    ListMetadataStoresRequest request =
        ListMetadataStoresRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listMetadataStores(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists MetadataStores for a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (MetadataStore element : metadataServiceClient.listMetadataStores(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The Location whose MetadataStores should be listed. Format:
   *     `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMetadataStoresPagedResponse listMetadataStores(String parent) {
    ListMetadataStoresRequest request =
        ListMetadataStoresRequest.newBuilder().setParent(parent).build();
    return listMetadataStores(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists MetadataStores for a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   ListMetadataStoresRequest request =
   *       ListMetadataStoresRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (MetadataStore element : metadataServiceClient.listMetadataStores(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMetadataStoresPagedResponse listMetadataStores(
      ListMetadataStoresRequest request) {
    return listMetadataStoresPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists MetadataStores for a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   ListMetadataStoresRequest request =
   *       ListMetadataStoresRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<MetadataStore> future =
   *       metadataServiceClient.listMetadataStoresPagedCallable().futureCall(request);
   *   // Do something.
   *   for (MetadataStore element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListMetadataStoresRequest, ListMetadataStoresPagedResponse>
      listMetadataStoresPagedCallable() {
    return stub.listMetadataStoresPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists MetadataStores for a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   ListMetadataStoresRequest request =
   *       ListMetadataStoresRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListMetadataStoresResponse response =
   *         metadataServiceClient.listMetadataStoresCallable().call(request);
   *     for (MetadataStore element : response.getMetadataStoresList()) {
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
  public final UnaryCallable<ListMetadataStoresRequest, ListMetadataStoresResponse>
      listMetadataStoresCallable() {
    return stub.listMetadataStoresCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single MetadataStore and all its child resources (Artifacts, Executions, and
   * Contexts).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   MetadataStoreName name = MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]");
   *   metadataServiceClient.deleteMetadataStoreAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the MetadataStore to delete. Format:
   *     `projects/{project}/locations/{location}/metadataStores/{metadatastore}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteMetadataStoreOperationMetadata>
      deleteMetadataStoreAsync(MetadataStoreName name) {
    DeleteMetadataStoreRequest request =
        DeleteMetadataStoreRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteMetadataStoreAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single MetadataStore and all its child resources (Artifacts, Executions, and
   * Contexts).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   String name = MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]").toString();
   *   metadataServiceClient.deleteMetadataStoreAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the MetadataStore to delete. Format:
   *     `projects/{project}/locations/{location}/metadataStores/{metadatastore}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteMetadataStoreOperationMetadata>
      deleteMetadataStoreAsync(String name) {
    DeleteMetadataStoreRequest request =
        DeleteMetadataStoreRequest.newBuilder().setName(name).build();
    return deleteMetadataStoreAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single MetadataStore and all its child resources (Artifacts, Executions, and
   * Contexts).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   DeleteMetadataStoreRequest request =
   *       DeleteMetadataStoreRequest.newBuilder()
   *           .setName(
   *               MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]").toString())
   *           .setForce(true)
   *           .build();
   *   metadataServiceClient.deleteMetadataStoreAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteMetadataStoreOperationMetadata>
      deleteMetadataStoreAsync(DeleteMetadataStoreRequest request) {
    return deleteMetadataStoreOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single MetadataStore and all its child resources (Artifacts, Executions, and
   * Contexts).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   DeleteMetadataStoreRequest request =
   *       DeleteMetadataStoreRequest.newBuilder()
   *           .setName(
   *               MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]").toString())
   *           .setForce(true)
   *           .build();
   *   OperationFuture<Empty, DeleteMetadataStoreOperationMetadata> future =
   *       metadataServiceClient.deleteMetadataStoreOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          DeleteMetadataStoreRequest, Empty, DeleteMetadataStoreOperationMetadata>
      deleteMetadataStoreOperationCallable() {
    return stub.deleteMetadataStoreOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single MetadataStore and all its child resources (Artifacts, Executions, and
   * Contexts).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   DeleteMetadataStoreRequest request =
   *       DeleteMetadataStoreRequest.newBuilder()
   *           .setName(
   *               MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]").toString())
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       metadataServiceClient.deleteMetadataStoreCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteMetadataStoreRequest, Operation> deleteMetadataStoreCallable() {
    return stub.deleteMetadataStoreCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an Artifact associated with a MetadataStore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   MetadataStoreName parent =
   *       MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]");
   *   Artifact artifact = Artifact.newBuilder().build();
   *   String artifactId = "artifactId240640653";
   *   Artifact response = metadataServiceClient.createArtifact(parent, artifact, artifactId);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the MetadataStore where the Artifact should be
   *     created. Format: `projects/{project}/locations/{location}/metadataStores/{metadatastore}`
   * @param artifact Required. The Artifact to create.
   * @param artifactId The {artifact} portion of the resource name with the format:
   *     `projects/{project}/locations/{location}/metadataStores/{metadatastore}/artifacts/{artifact}`
   *     If not provided, the Artifact's ID will be a UUID generated by the service. Must be 4-128
   *     characters in length. Valid characters are `/[a-z][0-9]-/`. Must be unique across all
   *     Artifacts in the parent MetadataStore. (Otherwise the request will fail with
   *     ALREADY_EXISTS, or PERMISSION_DENIED if the caller can't view the preexisting Artifact.)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Artifact createArtifact(
      MetadataStoreName parent, Artifact artifact, String artifactId) {
    CreateArtifactRequest request =
        CreateArtifactRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setArtifact(artifact)
            .setArtifactId(artifactId)
            .build();
    return createArtifact(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an Artifact associated with a MetadataStore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   String parent =
   *       MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]").toString();
   *   Artifact artifact = Artifact.newBuilder().build();
   *   String artifactId = "artifactId240640653";
   *   Artifact response = metadataServiceClient.createArtifact(parent, artifact, artifactId);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the MetadataStore where the Artifact should be
   *     created. Format: `projects/{project}/locations/{location}/metadataStores/{metadatastore}`
   * @param artifact Required. The Artifact to create.
   * @param artifactId The {artifact} portion of the resource name with the format:
   *     `projects/{project}/locations/{location}/metadataStores/{metadatastore}/artifacts/{artifact}`
   *     If not provided, the Artifact's ID will be a UUID generated by the service. Must be 4-128
   *     characters in length. Valid characters are `/[a-z][0-9]-/`. Must be unique across all
   *     Artifacts in the parent MetadataStore. (Otherwise the request will fail with
   *     ALREADY_EXISTS, or PERMISSION_DENIED if the caller can't view the preexisting Artifact.)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Artifact createArtifact(String parent, Artifact artifact, String artifactId) {
    CreateArtifactRequest request =
        CreateArtifactRequest.newBuilder()
            .setParent(parent)
            .setArtifact(artifact)
            .setArtifactId(artifactId)
            .build();
    return createArtifact(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an Artifact associated with a MetadataStore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   CreateArtifactRequest request =
   *       CreateArtifactRequest.newBuilder()
   *           .setParent(
   *               MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]").toString())
   *           .setArtifact(Artifact.newBuilder().build())
   *           .setArtifactId("artifactId240640653")
   *           .build();
   *   Artifact response = metadataServiceClient.createArtifact(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Artifact createArtifact(CreateArtifactRequest request) {
    return createArtifactCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an Artifact associated with a MetadataStore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   CreateArtifactRequest request =
   *       CreateArtifactRequest.newBuilder()
   *           .setParent(
   *               MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]").toString())
   *           .setArtifact(Artifact.newBuilder().build())
   *           .setArtifactId("artifactId240640653")
   *           .build();
   *   ApiFuture<Artifact> future =
   *       metadataServiceClient.createArtifactCallable().futureCall(request);
   *   // Do something.
   *   Artifact response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateArtifactRequest, Artifact> createArtifactCallable() {
    return stub.createArtifactCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a specific Artifact.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   ArtifactName name =
   *       ArtifactName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[ARTIFACT]");
   *   Artifact response = metadataServiceClient.getArtifact(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Artifact to retrieve. Format:
   *     `projects/{project}/locations/{location}/metadataStores/{metadatastore}/artifacts/{artifact}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Artifact getArtifact(ArtifactName name) {
    GetArtifactRequest request =
        GetArtifactRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getArtifact(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a specific Artifact.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   String name =
   *       ArtifactName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[ARTIFACT]").toString();
   *   Artifact response = metadataServiceClient.getArtifact(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Artifact to retrieve. Format:
   *     `projects/{project}/locations/{location}/metadataStores/{metadatastore}/artifacts/{artifact}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Artifact getArtifact(String name) {
    GetArtifactRequest request = GetArtifactRequest.newBuilder().setName(name).build();
    return getArtifact(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a specific Artifact.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   GetArtifactRequest request =
   *       GetArtifactRequest.newBuilder()
   *           .setName(
   *               ArtifactName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[ARTIFACT]")
   *                   .toString())
   *           .build();
   *   Artifact response = metadataServiceClient.getArtifact(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Artifact getArtifact(GetArtifactRequest request) {
    return getArtifactCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a specific Artifact.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   GetArtifactRequest request =
   *       GetArtifactRequest.newBuilder()
   *           .setName(
   *               ArtifactName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[ARTIFACT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Artifact> future = metadataServiceClient.getArtifactCallable().futureCall(request);
   *   // Do something.
   *   Artifact response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetArtifactRequest, Artifact> getArtifactCallable() {
    return stub.getArtifactCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Artifacts in the MetadataStore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   MetadataStoreName parent =
   *       MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]");
   *   for (Artifact element : metadataServiceClient.listArtifacts(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The MetadataStore whose Artifacts should be listed. Format:
   *     `projects/{project}/locations/{location}/metadataStores/{metadatastore}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListArtifactsPagedResponse listArtifacts(MetadataStoreName parent) {
    ListArtifactsRequest request =
        ListArtifactsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listArtifacts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Artifacts in the MetadataStore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   String parent =
   *       MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]").toString();
   *   for (Artifact element : metadataServiceClient.listArtifacts(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The MetadataStore whose Artifacts should be listed. Format:
   *     `projects/{project}/locations/{location}/metadataStores/{metadatastore}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListArtifactsPagedResponse listArtifacts(String parent) {
    ListArtifactsRequest request = ListArtifactsRequest.newBuilder().setParent(parent).build();
    return listArtifacts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Artifacts in the MetadataStore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   ListArtifactsRequest request =
   *       ListArtifactsRequest.newBuilder()
   *           .setParent(
   *               MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Artifact element : metadataServiceClient.listArtifacts(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListArtifactsPagedResponse listArtifacts(ListArtifactsRequest request) {
    return listArtifactsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Artifacts in the MetadataStore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   ListArtifactsRequest request =
   *       ListArtifactsRequest.newBuilder()
   *           .setParent(
   *               MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Artifact> future =
   *       metadataServiceClient.listArtifactsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Artifact element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListArtifactsRequest, ListArtifactsPagedResponse>
      listArtifactsPagedCallable() {
    return stub.listArtifactsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Artifacts in the MetadataStore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   ListArtifactsRequest request =
   *       ListArtifactsRequest.newBuilder()
   *           .setParent(
   *               MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListArtifactsResponse response =
   *         metadataServiceClient.listArtifactsCallable().call(request);
   *     for (Artifact element : response.getArtifactsList()) {
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
  public final UnaryCallable<ListArtifactsRequest, ListArtifactsResponse> listArtifactsCallable() {
    return stub.listArtifactsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a stored Artifact.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   Artifact artifact = Artifact.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Artifact response = metadataServiceClient.updateArtifact(artifact, updateMask);
   * }
   * }</pre>
   *
   * @param artifact Required. The Artifact containing updates. The Artifact's
   *     [Artifact.name][google.cloud.aiplatform.v1beta1.Artifact.name] field is used to identify
   *     the Artifact to be updated. Format:
   *     `projects/{project}/locations/{location}/metadataStores/{metadatastore}/artifacts/{artifact}`
   * @param updateMask Optional. A FieldMask indicating which fields should be updated.
   *     Functionality of this field is not yet supported.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Artifact updateArtifact(Artifact artifact, FieldMask updateMask) {
    UpdateArtifactRequest request =
        UpdateArtifactRequest.newBuilder().setArtifact(artifact).setUpdateMask(updateMask).build();
    return updateArtifact(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a stored Artifact.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   UpdateArtifactRequest request =
   *       UpdateArtifactRequest.newBuilder()
   *           .setArtifact(Artifact.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAllowMissing(true)
   *           .build();
   *   Artifact response = metadataServiceClient.updateArtifact(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Artifact updateArtifact(UpdateArtifactRequest request) {
    return updateArtifactCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a stored Artifact.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   UpdateArtifactRequest request =
   *       UpdateArtifactRequest.newBuilder()
   *           .setArtifact(Artifact.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAllowMissing(true)
   *           .build();
   *   ApiFuture<Artifact> future =
   *       metadataServiceClient.updateArtifactCallable().futureCall(request);
   *   // Do something.
   *   Artifact response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateArtifactRequest, Artifact> updateArtifactCallable() {
    return stub.updateArtifactCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an Artifact.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   ArtifactName name =
   *       ArtifactName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[ARTIFACT]");
   *   metadataServiceClient.deleteArtifactAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Artifact to delete. Format:
   *     `projects/{project}/locations/{location}/metadataStores/{metadatastore}/artifacts/{artifact}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteArtifactAsync(
      ArtifactName name) {
    DeleteArtifactRequest request =
        DeleteArtifactRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteArtifactAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an Artifact.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   String name =
   *       ArtifactName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[ARTIFACT]").toString();
   *   metadataServiceClient.deleteArtifactAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Artifact to delete. Format:
   *     `projects/{project}/locations/{location}/metadataStores/{metadatastore}/artifacts/{artifact}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteArtifactAsync(String name) {
    DeleteArtifactRequest request = DeleteArtifactRequest.newBuilder().setName(name).build();
    return deleteArtifactAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an Artifact.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   DeleteArtifactRequest request =
   *       DeleteArtifactRequest.newBuilder()
   *           .setName(
   *               ArtifactName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[ARTIFACT]")
   *                   .toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   metadataServiceClient.deleteArtifactAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteArtifactAsync(
      DeleteArtifactRequest request) {
    return deleteArtifactOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an Artifact.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   DeleteArtifactRequest request =
   *       DeleteArtifactRequest.newBuilder()
   *           .setName(
   *               ArtifactName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[ARTIFACT]")
   *                   .toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   OperationFuture<Empty, DeleteOperationMetadata> future =
   *       metadataServiceClient.deleteArtifactOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteArtifactRequest, Empty, DeleteOperationMetadata>
      deleteArtifactOperationCallable() {
    return stub.deleteArtifactOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an Artifact.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   DeleteArtifactRequest request =
   *       DeleteArtifactRequest.newBuilder()
   *           .setName(
   *               ArtifactName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[ARTIFACT]")
   *                   .toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Operation> future =
   *       metadataServiceClient.deleteArtifactCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteArtifactRequest, Operation> deleteArtifactCallable() {
    return stub.deleteArtifactCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Purges Artifacts.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   MetadataStoreName parent =
   *       MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]");
   *   PurgeArtifactsResponse response = metadataServiceClient.purgeArtifactsAsync(parent).get();
   * }
   * }</pre>
   *
   * @param parent Required. The metadata store to purge Artifacts from. Format:
   *     `projects/{project}/locations/{location}/metadataStores/{metadatastore}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PurgeArtifactsResponse, PurgeArtifactsMetadata> purgeArtifactsAsync(
      MetadataStoreName parent) {
    PurgeArtifactsRequest request =
        PurgeArtifactsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return purgeArtifactsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Purges Artifacts.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   String parent =
   *       MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]").toString();
   *   PurgeArtifactsResponse response = metadataServiceClient.purgeArtifactsAsync(parent).get();
   * }
   * }</pre>
   *
   * @param parent Required. The metadata store to purge Artifacts from. Format:
   *     `projects/{project}/locations/{location}/metadataStores/{metadatastore}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PurgeArtifactsResponse, PurgeArtifactsMetadata> purgeArtifactsAsync(
      String parent) {
    PurgeArtifactsRequest request = PurgeArtifactsRequest.newBuilder().setParent(parent).build();
    return purgeArtifactsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Purges Artifacts.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   PurgeArtifactsRequest request =
   *       PurgeArtifactsRequest.newBuilder()
   *           .setParent(
   *               MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]").toString())
   *           .setFilter("filter-1274492040")
   *           .setForce(true)
   *           .build();
   *   PurgeArtifactsResponse response = metadataServiceClient.purgeArtifactsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PurgeArtifactsResponse, PurgeArtifactsMetadata> purgeArtifactsAsync(
      PurgeArtifactsRequest request) {
    return purgeArtifactsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Purges Artifacts.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   PurgeArtifactsRequest request =
   *       PurgeArtifactsRequest.newBuilder()
   *           .setParent(
   *               MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]").toString())
   *           .setFilter("filter-1274492040")
   *           .setForce(true)
   *           .build();
   *   OperationFuture<PurgeArtifactsResponse, PurgeArtifactsMetadata> future =
   *       metadataServiceClient.purgeArtifactsOperationCallable().futureCall(request);
   *   // Do something.
   *   PurgeArtifactsResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          PurgeArtifactsRequest, PurgeArtifactsResponse, PurgeArtifactsMetadata>
      purgeArtifactsOperationCallable() {
    return stub.purgeArtifactsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Purges Artifacts.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   PurgeArtifactsRequest request =
   *       PurgeArtifactsRequest.newBuilder()
   *           .setParent(
   *               MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]").toString())
   *           .setFilter("filter-1274492040")
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       metadataServiceClient.purgeArtifactsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PurgeArtifactsRequest, Operation> purgeArtifactsCallable() {
    return stub.purgeArtifactsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Context associated with a MetadataStore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   MetadataStoreName parent =
   *       MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]");
   *   Context context = Context.newBuilder().build();
   *   String contextId = "contextId-406810838";
   *   Context response = metadataServiceClient.createContext(parent, context, contextId);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the MetadataStore where the Context should be
   *     created. Format: `projects/{project}/locations/{location}/metadataStores/{metadatastore}`
   * @param context Required. The Context to create.
   * @param contextId The {context} portion of the resource name with the format:
   *     `projects/{project}/locations/{location}/metadataStores/{metadatastore}/contexts/{context}`.
   *     If not provided, the Context's ID will be a UUID generated by the service. Must be 4-128
   *     characters in length. Valid characters are `/[a-z][0-9]-/`. Must be unique across all
   *     Contexts in the parent MetadataStore. (Otherwise the request will fail with ALREADY_EXISTS,
   *     or PERMISSION_DENIED if the caller can't view the preexisting Context.)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Context createContext(MetadataStoreName parent, Context context, String contextId) {
    CreateContextRequest request =
        CreateContextRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setContext(context)
            .setContextId(contextId)
            .build();
    return createContext(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Context associated with a MetadataStore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   String parent =
   *       MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]").toString();
   *   Context context = Context.newBuilder().build();
   *   String contextId = "contextId-406810838";
   *   Context response = metadataServiceClient.createContext(parent, context, contextId);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the MetadataStore where the Context should be
   *     created. Format: `projects/{project}/locations/{location}/metadataStores/{metadatastore}`
   * @param context Required. The Context to create.
   * @param contextId The {context} portion of the resource name with the format:
   *     `projects/{project}/locations/{location}/metadataStores/{metadatastore}/contexts/{context}`.
   *     If not provided, the Context's ID will be a UUID generated by the service. Must be 4-128
   *     characters in length. Valid characters are `/[a-z][0-9]-/`. Must be unique across all
   *     Contexts in the parent MetadataStore. (Otherwise the request will fail with ALREADY_EXISTS,
   *     or PERMISSION_DENIED if the caller can't view the preexisting Context.)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Context createContext(String parent, Context context, String contextId) {
    CreateContextRequest request =
        CreateContextRequest.newBuilder()
            .setParent(parent)
            .setContext(context)
            .setContextId(contextId)
            .build();
    return createContext(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Context associated with a MetadataStore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   CreateContextRequest request =
   *       CreateContextRequest.newBuilder()
   *           .setParent(
   *               MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]").toString())
   *           .setContext(Context.newBuilder().build())
   *           .setContextId("contextId-406810838")
   *           .build();
   *   Context response = metadataServiceClient.createContext(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Context createContext(CreateContextRequest request) {
    return createContextCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Context associated with a MetadataStore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   CreateContextRequest request =
   *       CreateContextRequest.newBuilder()
   *           .setParent(
   *               MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]").toString())
   *           .setContext(Context.newBuilder().build())
   *           .setContextId("contextId-406810838")
   *           .build();
   *   ApiFuture<Context> future = metadataServiceClient.createContextCallable().futureCall(request);
   *   // Do something.
   *   Context response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateContextRequest, Context> createContextCallable() {
    return stub.createContextCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a specific Context.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   ContextName name = ContextName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[CONTEXT]");
   *   Context response = metadataServiceClient.getContext(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Context to retrieve. Format:
   *     `projects/{project}/locations/{location}/metadataStores/{metadatastore}/contexts/{context}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Context getContext(ContextName name) {
    GetContextRequest request =
        GetContextRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getContext(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a specific Context.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   String name =
   *       ContextName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[CONTEXT]").toString();
   *   Context response = metadataServiceClient.getContext(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Context to retrieve. Format:
   *     `projects/{project}/locations/{location}/metadataStores/{metadatastore}/contexts/{context}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Context getContext(String name) {
    GetContextRequest request = GetContextRequest.newBuilder().setName(name).build();
    return getContext(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a specific Context.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   GetContextRequest request =
   *       GetContextRequest.newBuilder()
   *           .setName(
   *               ContextName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[CONTEXT]")
   *                   .toString())
   *           .build();
   *   Context response = metadataServiceClient.getContext(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Context getContext(GetContextRequest request) {
    return getContextCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a specific Context.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   GetContextRequest request =
   *       GetContextRequest.newBuilder()
   *           .setName(
   *               ContextName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[CONTEXT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Context> future = metadataServiceClient.getContextCallable().futureCall(request);
   *   // Do something.
   *   Context response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetContextRequest, Context> getContextCallable() {
    return stub.getContextCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Contexts on the MetadataStore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   MetadataStoreName parent =
   *       MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]");
   *   for (Context element : metadataServiceClient.listContexts(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The MetadataStore whose Contexts should be listed. Format:
   *     `projects/{project}/locations/{location}/metadataStores/{metadatastore}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListContextsPagedResponse listContexts(MetadataStoreName parent) {
    ListContextsRequest request =
        ListContextsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listContexts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Contexts on the MetadataStore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   String parent =
   *       MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]").toString();
   *   for (Context element : metadataServiceClient.listContexts(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The MetadataStore whose Contexts should be listed. Format:
   *     `projects/{project}/locations/{location}/metadataStores/{metadatastore}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListContextsPagedResponse listContexts(String parent) {
    ListContextsRequest request = ListContextsRequest.newBuilder().setParent(parent).build();
    return listContexts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Contexts on the MetadataStore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   ListContextsRequest request =
   *       ListContextsRequest.newBuilder()
   *           .setParent(
   *               MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Context element : metadataServiceClient.listContexts(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListContextsPagedResponse listContexts(ListContextsRequest request) {
    return listContextsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Contexts on the MetadataStore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   ListContextsRequest request =
   *       ListContextsRequest.newBuilder()
   *           .setParent(
   *               MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Context> future =
   *       metadataServiceClient.listContextsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Context element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListContextsRequest, ListContextsPagedResponse>
      listContextsPagedCallable() {
    return stub.listContextsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Contexts on the MetadataStore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   ListContextsRequest request =
   *       ListContextsRequest.newBuilder()
   *           .setParent(
   *               MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListContextsResponse response = metadataServiceClient.listContextsCallable().call(request);
   *     for (Context element : response.getContextsList()) {
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
  public final UnaryCallable<ListContextsRequest, ListContextsResponse> listContextsCallable() {
    return stub.listContextsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a stored Context.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   Context context = Context.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Context response = metadataServiceClient.updateContext(context, updateMask);
   * }
   * }</pre>
   *
   * @param context Required. The Context containing updates. The Context's
   *     [Context.name][google.cloud.aiplatform.v1beta1.Context.name] field is used to identify the
   *     Context to be updated. Format:
   *     `projects/{project}/locations/{location}/metadataStores/{metadatastore}/contexts/{context}`
   * @param updateMask Optional. A FieldMask indicating which fields should be updated.
   *     Functionality of this field is not yet supported.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Context updateContext(Context context, FieldMask updateMask) {
    UpdateContextRequest request =
        UpdateContextRequest.newBuilder().setContext(context).setUpdateMask(updateMask).build();
    return updateContext(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a stored Context.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   UpdateContextRequest request =
   *       UpdateContextRequest.newBuilder()
   *           .setContext(Context.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAllowMissing(true)
   *           .build();
   *   Context response = metadataServiceClient.updateContext(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Context updateContext(UpdateContextRequest request) {
    return updateContextCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a stored Context.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   UpdateContextRequest request =
   *       UpdateContextRequest.newBuilder()
   *           .setContext(Context.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAllowMissing(true)
   *           .build();
   *   ApiFuture<Context> future = metadataServiceClient.updateContextCallable().futureCall(request);
   *   // Do something.
   *   Context response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateContextRequest, Context> updateContextCallable() {
    return stub.updateContextCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a stored Context.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   ContextName name = ContextName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[CONTEXT]");
   *   metadataServiceClient.deleteContextAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Context to delete. Format:
   *     `projects/{project}/locations/{location}/metadataStores/{metadatastore}/contexts/{context}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteContextAsync(
      ContextName name) {
    DeleteContextRequest request =
        DeleteContextRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteContextAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a stored Context.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   String name =
   *       ContextName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[CONTEXT]").toString();
   *   metadataServiceClient.deleteContextAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Context to delete. Format:
   *     `projects/{project}/locations/{location}/metadataStores/{metadatastore}/contexts/{context}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteContextAsync(String name) {
    DeleteContextRequest request = DeleteContextRequest.newBuilder().setName(name).build();
    return deleteContextAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a stored Context.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   DeleteContextRequest request =
   *       DeleteContextRequest.newBuilder()
   *           .setName(
   *               ContextName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[CONTEXT]")
   *                   .toString())
   *           .setForce(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   metadataServiceClient.deleteContextAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteContextAsync(
      DeleteContextRequest request) {
    return deleteContextOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a stored Context.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   DeleteContextRequest request =
   *       DeleteContextRequest.newBuilder()
   *           .setName(
   *               ContextName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[CONTEXT]")
   *                   .toString())
   *           .setForce(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   OperationFuture<Empty, DeleteOperationMetadata> future =
   *       metadataServiceClient.deleteContextOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteContextRequest, Empty, DeleteOperationMetadata>
      deleteContextOperationCallable() {
    return stub.deleteContextOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a stored Context.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   DeleteContextRequest request =
   *       DeleteContextRequest.newBuilder()
   *           .setName(
   *               ContextName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[CONTEXT]")
   *                   .toString())
   *           .setForce(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Operation> future =
   *       metadataServiceClient.deleteContextCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteContextRequest, Operation> deleteContextCallable() {
    return stub.deleteContextCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Purges Contexts.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   MetadataStoreName parent =
   *       MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]");
   *   PurgeContextsResponse response = metadataServiceClient.purgeContextsAsync(parent).get();
   * }
   * }</pre>
   *
   * @param parent Required. The metadata store to purge Contexts from. Format:
   *     `projects/{project}/locations/{location}/metadataStores/{metadatastore}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PurgeContextsResponse, PurgeContextsMetadata> purgeContextsAsync(
      MetadataStoreName parent) {
    PurgeContextsRequest request =
        PurgeContextsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return purgeContextsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Purges Contexts.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   String parent =
   *       MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]").toString();
   *   PurgeContextsResponse response = metadataServiceClient.purgeContextsAsync(parent).get();
   * }
   * }</pre>
   *
   * @param parent Required. The metadata store to purge Contexts from. Format:
   *     `projects/{project}/locations/{location}/metadataStores/{metadatastore}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PurgeContextsResponse, PurgeContextsMetadata> purgeContextsAsync(
      String parent) {
    PurgeContextsRequest request = PurgeContextsRequest.newBuilder().setParent(parent).build();
    return purgeContextsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Purges Contexts.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   PurgeContextsRequest request =
   *       PurgeContextsRequest.newBuilder()
   *           .setParent(
   *               MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]").toString())
   *           .setFilter("filter-1274492040")
   *           .setForce(true)
   *           .build();
   *   PurgeContextsResponse response = metadataServiceClient.purgeContextsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PurgeContextsResponse, PurgeContextsMetadata> purgeContextsAsync(
      PurgeContextsRequest request) {
    return purgeContextsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Purges Contexts.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   PurgeContextsRequest request =
   *       PurgeContextsRequest.newBuilder()
   *           .setParent(
   *               MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]").toString())
   *           .setFilter("filter-1274492040")
   *           .setForce(true)
   *           .build();
   *   OperationFuture<PurgeContextsResponse, PurgeContextsMetadata> future =
   *       metadataServiceClient.purgeContextsOperationCallable().futureCall(request);
   *   // Do something.
   *   PurgeContextsResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<PurgeContextsRequest, PurgeContextsResponse, PurgeContextsMetadata>
      purgeContextsOperationCallable() {
    return stub.purgeContextsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Purges Contexts.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   PurgeContextsRequest request =
   *       PurgeContextsRequest.newBuilder()
   *           .setParent(
   *               MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]").toString())
   *           .setFilter("filter-1274492040")
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       metadataServiceClient.purgeContextsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PurgeContextsRequest, Operation> purgeContextsCallable() {
    return stub.purgeContextsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a set of Artifacts and Executions to a Context. If any of the Artifacts or Executions have
   * already been added to a Context, they are simply skipped.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   ContextName context =
   *       ContextName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[CONTEXT]");
   *   List<String> artifacts = new ArrayList<>();
   *   List<String> executions = new ArrayList<>();
   *   AddContextArtifactsAndExecutionsResponse response =
   *       metadataServiceClient.addContextArtifactsAndExecutions(context, artifacts, executions);
   * }
   * }</pre>
   *
   * @param context Required. The resource name of the Context that the Artifacts and Executions
   *     belong to. Format:
   *     `projects/{project}/locations/{location}/metadataStores/{metadatastore}/contexts/{context}`
   * @param artifacts The resource names of the Artifacts to attribute to the Context.
   *     <p>Format:
   *     `projects/{project}/locations/{location}/metadataStores/{metadatastore}/artifacts/{artifact}`
   * @param executions The resource names of the Executions to associate with the Context.
   *     <p>Format:
   *     `projects/{project}/locations/{location}/metadataStores/{metadatastore}/executions/{execution}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AddContextArtifactsAndExecutionsResponse addContextArtifactsAndExecutions(
      ContextName context, List<String> artifacts, List<String> executions) {
    AddContextArtifactsAndExecutionsRequest request =
        AddContextArtifactsAndExecutionsRequest.newBuilder()
            .setContext(context == null ? null : context.toString())
            .addAllArtifacts(artifacts)
            .addAllExecutions(executions)
            .build();
    return addContextArtifactsAndExecutions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a set of Artifacts and Executions to a Context. If any of the Artifacts or Executions have
   * already been added to a Context, they are simply skipped.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   String context =
   *       ContextName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[CONTEXT]").toString();
   *   List<String> artifacts = new ArrayList<>();
   *   List<String> executions = new ArrayList<>();
   *   AddContextArtifactsAndExecutionsResponse response =
   *       metadataServiceClient.addContextArtifactsAndExecutions(context, artifacts, executions);
   * }
   * }</pre>
   *
   * @param context Required. The resource name of the Context that the Artifacts and Executions
   *     belong to. Format:
   *     `projects/{project}/locations/{location}/metadataStores/{metadatastore}/contexts/{context}`
   * @param artifacts The resource names of the Artifacts to attribute to the Context.
   *     <p>Format:
   *     `projects/{project}/locations/{location}/metadataStores/{metadatastore}/artifacts/{artifact}`
   * @param executions The resource names of the Executions to associate with the Context.
   *     <p>Format:
   *     `projects/{project}/locations/{location}/metadataStores/{metadatastore}/executions/{execution}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AddContextArtifactsAndExecutionsResponse addContextArtifactsAndExecutions(
      String context, List<String> artifacts, List<String> executions) {
    AddContextArtifactsAndExecutionsRequest request =
        AddContextArtifactsAndExecutionsRequest.newBuilder()
            .setContext(context)
            .addAllArtifacts(artifacts)
            .addAllExecutions(executions)
            .build();
    return addContextArtifactsAndExecutions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a set of Artifacts and Executions to a Context. If any of the Artifacts or Executions have
   * already been added to a Context, they are simply skipped.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   AddContextArtifactsAndExecutionsRequest request =
   *       AddContextArtifactsAndExecutionsRequest.newBuilder()
   *           .setContext(
   *               ContextName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[CONTEXT]")
   *                   .toString())
   *           .addAllArtifacts(new ArrayList<String>())
   *           .addAllExecutions(new ArrayList<String>())
   *           .build();
   *   AddContextArtifactsAndExecutionsResponse response =
   *       metadataServiceClient.addContextArtifactsAndExecutions(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AddContextArtifactsAndExecutionsResponse addContextArtifactsAndExecutions(
      AddContextArtifactsAndExecutionsRequest request) {
    return addContextArtifactsAndExecutionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a set of Artifacts and Executions to a Context. If any of the Artifacts or Executions have
   * already been added to a Context, they are simply skipped.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   AddContextArtifactsAndExecutionsRequest request =
   *       AddContextArtifactsAndExecutionsRequest.newBuilder()
   *           .setContext(
   *               ContextName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[CONTEXT]")
   *                   .toString())
   *           .addAllArtifacts(new ArrayList<String>())
   *           .addAllExecutions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<AddContextArtifactsAndExecutionsResponse> future =
   *       metadataServiceClient.addContextArtifactsAndExecutionsCallable().futureCall(request);
   *   // Do something.
   *   AddContextArtifactsAndExecutionsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          AddContextArtifactsAndExecutionsRequest, AddContextArtifactsAndExecutionsResponse>
      addContextArtifactsAndExecutionsCallable() {
    return stub.addContextArtifactsAndExecutionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a set of Contexts as children to a parent Context. If any of the child Contexts have
   * already been added to the parent Context, they are simply skipped. If this call would create a
   * cycle or cause any Context to have more than 10 parents, the request will fail with an
   * INVALID_ARGUMENT error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   ContextName context =
   *       ContextName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[CONTEXT]");
   *   List<String> childContexts = new ArrayList<>();
   *   AddContextChildrenResponse response =
   *       metadataServiceClient.addContextChildren(context, childContexts);
   * }
   * }</pre>
   *
   * @param context Required. The resource name of the parent Context.
   *     <p>Format:
   *     `projects/{project}/locations/{location}/metadataStores/{metadatastore}/contexts/{context}`
   * @param childContexts The resource names of the child Contexts.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AddContextChildrenResponse addContextChildren(
      ContextName context, List<String> childContexts) {
    AddContextChildrenRequest request =
        AddContextChildrenRequest.newBuilder()
            .setContext(context == null ? null : context.toString())
            .addAllChildContexts(childContexts)
            .build();
    return addContextChildren(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a set of Contexts as children to a parent Context. If any of the child Contexts have
   * already been added to the parent Context, they are simply skipped. If this call would create a
   * cycle or cause any Context to have more than 10 parents, the request will fail with an
   * INVALID_ARGUMENT error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   String context =
   *       ContextName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[CONTEXT]").toString();
   *   List<String> childContexts = new ArrayList<>();
   *   AddContextChildrenResponse response =
   *       metadataServiceClient.addContextChildren(context, childContexts);
   * }
   * }</pre>
   *
   * @param context Required. The resource name of the parent Context.
   *     <p>Format:
   *     `projects/{project}/locations/{location}/metadataStores/{metadatastore}/contexts/{context}`
   * @param childContexts The resource names of the child Contexts.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AddContextChildrenResponse addContextChildren(
      String context, List<String> childContexts) {
    AddContextChildrenRequest request =
        AddContextChildrenRequest.newBuilder()
            .setContext(context)
            .addAllChildContexts(childContexts)
            .build();
    return addContextChildren(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a set of Contexts as children to a parent Context. If any of the child Contexts have
   * already been added to the parent Context, they are simply skipped. If this call would create a
   * cycle or cause any Context to have more than 10 parents, the request will fail with an
   * INVALID_ARGUMENT error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   AddContextChildrenRequest request =
   *       AddContextChildrenRequest.newBuilder()
   *           .setContext(
   *               ContextName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[CONTEXT]")
   *                   .toString())
   *           .addAllChildContexts(new ArrayList<String>())
   *           .build();
   *   AddContextChildrenResponse response = metadataServiceClient.addContextChildren(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AddContextChildrenResponse addContextChildren(AddContextChildrenRequest request) {
    return addContextChildrenCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a set of Contexts as children to a parent Context. If any of the child Contexts have
   * already been added to the parent Context, they are simply skipped. If this call would create a
   * cycle or cause any Context to have more than 10 parents, the request will fail with an
   * INVALID_ARGUMENT error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   AddContextChildrenRequest request =
   *       AddContextChildrenRequest.newBuilder()
   *           .setContext(
   *               ContextName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[CONTEXT]")
   *                   .toString())
   *           .addAllChildContexts(new ArrayList<String>())
   *           .build();
   *   ApiFuture<AddContextChildrenResponse> future =
   *       metadataServiceClient.addContextChildrenCallable().futureCall(request);
   *   // Do something.
   *   AddContextChildrenResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AddContextChildrenRequest, AddContextChildrenResponse>
      addContextChildrenCallable() {
    return stub.addContextChildrenCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Remove a set of children contexts from a parent Context. If any of the child Contexts were NOT
   * added to the parent Context, they are simply skipped.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   ContextName context =
   *       ContextName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[CONTEXT]");
   *   List<String> childContexts = new ArrayList<>();
   *   RemoveContextChildrenResponse response =
   *       metadataServiceClient.removeContextChildren(context, childContexts);
   * }
   * }</pre>
   *
   * @param context Required. The resource name of the parent Context.
   *     <p>Format:
   *     `projects/{project}/locations/{location}/metadataStores/{metadatastore}/contexts/{context}`
   * @param childContexts The resource names of the child Contexts.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RemoveContextChildrenResponse removeContextChildren(
      ContextName context, List<String> childContexts) {
    RemoveContextChildrenRequest request =
        RemoveContextChildrenRequest.newBuilder()
            .setContext(context == null ? null : context.toString())
            .addAllChildContexts(childContexts)
            .build();
    return removeContextChildren(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Remove a set of children contexts from a parent Context. If any of the child Contexts were NOT
   * added to the parent Context, they are simply skipped.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   String context =
   *       ContextName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[CONTEXT]").toString();
   *   List<String> childContexts = new ArrayList<>();
   *   RemoveContextChildrenResponse response =
   *       metadataServiceClient.removeContextChildren(context, childContexts);
   * }
   * }</pre>
   *
   * @param context Required. The resource name of the parent Context.
   *     <p>Format:
   *     `projects/{project}/locations/{location}/metadataStores/{metadatastore}/contexts/{context}`
   * @param childContexts The resource names of the child Contexts.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RemoveContextChildrenResponse removeContextChildren(
      String context, List<String> childContexts) {
    RemoveContextChildrenRequest request =
        RemoveContextChildrenRequest.newBuilder()
            .setContext(context)
            .addAllChildContexts(childContexts)
            .build();
    return removeContextChildren(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Remove a set of children contexts from a parent Context. If any of the child Contexts were NOT
   * added to the parent Context, they are simply skipped.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   RemoveContextChildrenRequest request =
   *       RemoveContextChildrenRequest.newBuilder()
   *           .setContext(
   *               ContextName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[CONTEXT]")
   *                   .toString())
   *           .addAllChildContexts(new ArrayList<String>())
   *           .build();
   *   RemoveContextChildrenResponse response = metadataServiceClient.removeContextChildren(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RemoveContextChildrenResponse removeContextChildren(
      RemoveContextChildrenRequest request) {
    return removeContextChildrenCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Remove a set of children contexts from a parent Context. If any of the child Contexts were NOT
   * added to the parent Context, they are simply skipped.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   RemoveContextChildrenRequest request =
   *       RemoveContextChildrenRequest.newBuilder()
   *           .setContext(
   *               ContextName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[CONTEXT]")
   *                   .toString())
   *           .addAllChildContexts(new ArrayList<String>())
   *           .build();
   *   ApiFuture<RemoveContextChildrenResponse> future =
   *       metadataServiceClient.removeContextChildrenCallable().futureCall(request);
   *   // Do something.
   *   RemoveContextChildrenResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RemoveContextChildrenRequest, RemoveContextChildrenResponse>
      removeContextChildrenCallable() {
    return stub.removeContextChildrenCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves Artifacts and Executions within the specified Context, connected by Event edges and
   * returned as a LineageSubgraph.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   ContextName context =
   *       ContextName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[CONTEXT]");
   *   LineageSubgraph response = metadataServiceClient.queryContextLineageSubgraph(context);
   * }
   * }</pre>
   *
   * @param context Required. The resource name of the Context whose Artifacts and Executions should
   *     be retrieved as a LineageSubgraph. Format:
   *     `projects/{project}/locations/{location}/metadataStores/{metadatastore}/contexts/{context}`
   *     <p>The request may error with FAILED_PRECONDITION if the number of Artifacts, the number of
   *     Executions, or the number of Events that would be returned for the Context exceeds 1000.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LineageSubgraph queryContextLineageSubgraph(ContextName context) {
    QueryContextLineageSubgraphRequest request =
        QueryContextLineageSubgraphRequest.newBuilder()
            .setContext(context == null ? null : context.toString())
            .build();
    return queryContextLineageSubgraph(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves Artifacts and Executions within the specified Context, connected by Event edges and
   * returned as a LineageSubgraph.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   String context =
   *       ContextName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[CONTEXT]").toString();
   *   LineageSubgraph response = metadataServiceClient.queryContextLineageSubgraph(context);
   * }
   * }</pre>
   *
   * @param context Required. The resource name of the Context whose Artifacts and Executions should
   *     be retrieved as a LineageSubgraph. Format:
   *     `projects/{project}/locations/{location}/metadataStores/{metadatastore}/contexts/{context}`
   *     <p>The request may error with FAILED_PRECONDITION if the number of Artifacts, the number of
   *     Executions, or the number of Events that would be returned for the Context exceeds 1000.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LineageSubgraph queryContextLineageSubgraph(String context) {
    QueryContextLineageSubgraphRequest request =
        QueryContextLineageSubgraphRequest.newBuilder().setContext(context).build();
    return queryContextLineageSubgraph(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves Artifacts and Executions within the specified Context, connected by Event edges and
   * returned as a LineageSubgraph.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   QueryContextLineageSubgraphRequest request =
   *       QueryContextLineageSubgraphRequest.newBuilder()
   *           .setContext(
   *               ContextName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[CONTEXT]")
   *                   .toString())
   *           .build();
   *   LineageSubgraph response = metadataServiceClient.queryContextLineageSubgraph(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LineageSubgraph queryContextLineageSubgraph(
      QueryContextLineageSubgraphRequest request) {
    return queryContextLineageSubgraphCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves Artifacts and Executions within the specified Context, connected by Event edges and
   * returned as a LineageSubgraph.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   QueryContextLineageSubgraphRequest request =
   *       QueryContextLineageSubgraphRequest.newBuilder()
   *           .setContext(
   *               ContextName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[CONTEXT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<LineageSubgraph> future =
   *       metadataServiceClient.queryContextLineageSubgraphCallable().futureCall(request);
   *   // Do something.
   *   LineageSubgraph response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<QueryContextLineageSubgraphRequest, LineageSubgraph>
      queryContextLineageSubgraphCallable() {
    return stub.queryContextLineageSubgraphCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an Execution associated with a MetadataStore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   MetadataStoreName parent =
   *       MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]");
   *   Execution execution = Execution.newBuilder().build();
   *   String executionId = "executionId-454906285";
   *   Execution response = metadataServiceClient.createExecution(parent, execution, executionId);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the MetadataStore where the Execution should be
   *     created. Format: `projects/{project}/locations/{location}/metadataStores/{metadatastore}`
   * @param execution Required. The Execution to create.
   * @param executionId The {execution} portion of the resource name with the format:
   *     `projects/{project}/locations/{location}/metadataStores/{metadatastore}/executions/{execution}`
   *     If not provided, the Execution's ID will be a UUID generated by the service. Must be 4-128
   *     characters in length. Valid characters are `/[a-z][0-9]-/`. Must be unique across all
   *     Executions in the parent MetadataStore. (Otherwise the request will fail with
   *     ALREADY_EXISTS, or PERMISSION_DENIED if the caller can't view the preexisting Execution.)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Execution createExecution(
      MetadataStoreName parent, Execution execution, String executionId) {
    CreateExecutionRequest request =
        CreateExecutionRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setExecution(execution)
            .setExecutionId(executionId)
            .build();
    return createExecution(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an Execution associated with a MetadataStore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   String parent =
   *       MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]").toString();
   *   Execution execution = Execution.newBuilder().build();
   *   String executionId = "executionId-454906285";
   *   Execution response = metadataServiceClient.createExecution(parent, execution, executionId);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the MetadataStore where the Execution should be
   *     created. Format: `projects/{project}/locations/{location}/metadataStores/{metadatastore}`
   * @param execution Required. The Execution to create.
   * @param executionId The {execution} portion of the resource name with the format:
   *     `projects/{project}/locations/{location}/metadataStores/{metadatastore}/executions/{execution}`
   *     If not provided, the Execution's ID will be a UUID generated by the service. Must be 4-128
   *     characters in length. Valid characters are `/[a-z][0-9]-/`. Must be unique across all
   *     Executions in the parent MetadataStore. (Otherwise the request will fail with
   *     ALREADY_EXISTS, or PERMISSION_DENIED if the caller can't view the preexisting Execution.)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Execution createExecution(String parent, Execution execution, String executionId) {
    CreateExecutionRequest request =
        CreateExecutionRequest.newBuilder()
            .setParent(parent)
            .setExecution(execution)
            .setExecutionId(executionId)
            .build();
    return createExecution(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an Execution associated with a MetadataStore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   CreateExecutionRequest request =
   *       CreateExecutionRequest.newBuilder()
   *           .setParent(
   *               MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]").toString())
   *           .setExecution(Execution.newBuilder().build())
   *           .setExecutionId("executionId-454906285")
   *           .build();
   *   Execution response = metadataServiceClient.createExecution(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Execution createExecution(CreateExecutionRequest request) {
    return createExecutionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an Execution associated with a MetadataStore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   CreateExecutionRequest request =
   *       CreateExecutionRequest.newBuilder()
   *           .setParent(
   *               MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]").toString())
   *           .setExecution(Execution.newBuilder().build())
   *           .setExecutionId("executionId-454906285")
   *           .build();
   *   ApiFuture<Execution> future =
   *       metadataServiceClient.createExecutionCallable().futureCall(request);
   *   // Do something.
   *   Execution response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateExecutionRequest, Execution> createExecutionCallable() {
    return stub.createExecutionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a specific Execution.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   ExecutionName name =
   *       ExecutionName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[EXECUTION]");
   *   Execution response = metadataServiceClient.getExecution(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Execution to retrieve. Format:
   *     `projects/{project}/locations/{location}/metadataStores/{metadatastore}/executions/{execution}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Execution getExecution(ExecutionName name) {
    GetExecutionRequest request =
        GetExecutionRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getExecution(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a specific Execution.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   String name =
   *       ExecutionName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[EXECUTION]").toString();
   *   Execution response = metadataServiceClient.getExecution(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Execution to retrieve. Format:
   *     `projects/{project}/locations/{location}/metadataStores/{metadatastore}/executions/{execution}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Execution getExecution(String name) {
    GetExecutionRequest request = GetExecutionRequest.newBuilder().setName(name).build();
    return getExecution(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a specific Execution.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   GetExecutionRequest request =
   *       GetExecutionRequest.newBuilder()
   *           .setName(
   *               ExecutionName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[EXECUTION]")
   *                   .toString())
   *           .build();
   *   Execution response = metadataServiceClient.getExecution(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Execution getExecution(GetExecutionRequest request) {
    return getExecutionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a specific Execution.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   GetExecutionRequest request =
   *       GetExecutionRequest.newBuilder()
   *           .setName(
   *               ExecutionName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[EXECUTION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Execution> future =
   *       metadataServiceClient.getExecutionCallable().futureCall(request);
   *   // Do something.
   *   Execution response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetExecutionRequest, Execution> getExecutionCallable() {
    return stub.getExecutionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Executions in the MetadataStore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   MetadataStoreName parent =
   *       MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]");
   *   for (Execution element : metadataServiceClient.listExecutions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The MetadataStore whose Executions should be listed. Format:
   *     `projects/{project}/locations/{location}/metadataStores/{metadatastore}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListExecutionsPagedResponse listExecutions(MetadataStoreName parent) {
    ListExecutionsRequest request =
        ListExecutionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listExecutions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Executions in the MetadataStore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   String parent =
   *       MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]").toString();
   *   for (Execution element : metadataServiceClient.listExecutions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The MetadataStore whose Executions should be listed. Format:
   *     `projects/{project}/locations/{location}/metadataStores/{metadatastore}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListExecutionsPagedResponse listExecutions(String parent) {
    ListExecutionsRequest request = ListExecutionsRequest.newBuilder().setParent(parent).build();
    return listExecutions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Executions in the MetadataStore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   ListExecutionsRequest request =
   *       ListExecutionsRequest.newBuilder()
   *           .setParent(
   *               MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Execution element : metadataServiceClient.listExecutions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListExecutionsPagedResponse listExecutions(ListExecutionsRequest request) {
    return listExecutionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Executions in the MetadataStore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   ListExecutionsRequest request =
   *       ListExecutionsRequest.newBuilder()
   *           .setParent(
   *               MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Execution> future =
   *       metadataServiceClient.listExecutionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Execution element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListExecutionsRequest, ListExecutionsPagedResponse>
      listExecutionsPagedCallable() {
    return stub.listExecutionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Executions in the MetadataStore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   ListExecutionsRequest request =
   *       ListExecutionsRequest.newBuilder()
   *           .setParent(
   *               MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListExecutionsResponse response =
   *         metadataServiceClient.listExecutionsCallable().call(request);
   *     for (Execution element : response.getExecutionsList()) {
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
  public final UnaryCallable<ListExecutionsRequest, ListExecutionsResponse>
      listExecutionsCallable() {
    return stub.listExecutionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a stored Execution.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   Execution execution = Execution.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Execution response = metadataServiceClient.updateExecution(execution, updateMask);
   * }
   * }</pre>
   *
   * @param execution Required. The Execution containing updates. The Execution's
   *     [Execution.name][google.cloud.aiplatform.v1beta1.Execution.name] field is used to identify
   *     the Execution to be updated. Format:
   *     `projects/{project}/locations/{location}/metadataStores/{metadatastore}/executions/{execution}`
   * @param updateMask Optional. A FieldMask indicating which fields should be updated.
   *     Functionality of this field is not yet supported.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Execution updateExecution(Execution execution, FieldMask updateMask) {
    UpdateExecutionRequest request =
        UpdateExecutionRequest.newBuilder()
            .setExecution(execution)
            .setUpdateMask(updateMask)
            .build();
    return updateExecution(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a stored Execution.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   UpdateExecutionRequest request =
   *       UpdateExecutionRequest.newBuilder()
   *           .setExecution(Execution.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAllowMissing(true)
   *           .build();
   *   Execution response = metadataServiceClient.updateExecution(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Execution updateExecution(UpdateExecutionRequest request) {
    return updateExecutionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a stored Execution.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   UpdateExecutionRequest request =
   *       UpdateExecutionRequest.newBuilder()
   *           .setExecution(Execution.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAllowMissing(true)
   *           .build();
   *   ApiFuture<Execution> future =
   *       metadataServiceClient.updateExecutionCallable().futureCall(request);
   *   // Do something.
   *   Execution response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateExecutionRequest, Execution> updateExecutionCallable() {
    return stub.updateExecutionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an Execution.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   ExecutionName name =
   *       ExecutionName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[EXECUTION]");
   *   metadataServiceClient.deleteExecutionAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Execution to delete. Format:
   *     `projects/{project}/locations/{location}/metadataStores/{metadatastore}/executions/{execution}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteExecutionAsync(
      ExecutionName name) {
    DeleteExecutionRequest request =
        DeleteExecutionRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteExecutionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an Execution.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   String name =
   *       ExecutionName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[EXECUTION]").toString();
   *   metadataServiceClient.deleteExecutionAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Execution to delete. Format:
   *     `projects/{project}/locations/{location}/metadataStores/{metadatastore}/executions/{execution}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteExecutionAsync(String name) {
    DeleteExecutionRequest request = DeleteExecutionRequest.newBuilder().setName(name).build();
    return deleteExecutionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an Execution.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   DeleteExecutionRequest request =
   *       DeleteExecutionRequest.newBuilder()
   *           .setName(
   *               ExecutionName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[EXECUTION]")
   *                   .toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   metadataServiceClient.deleteExecutionAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteExecutionAsync(
      DeleteExecutionRequest request) {
    return deleteExecutionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an Execution.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   DeleteExecutionRequest request =
   *       DeleteExecutionRequest.newBuilder()
   *           .setName(
   *               ExecutionName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[EXECUTION]")
   *                   .toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   OperationFuture<Empty, DeleteOperationMetadata> future =
   *       metadataServiceClient.deleteExecutionOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteExecutionRequest, Empty, DeleteOperationMetadata>
      deleteExecutionOperationCallable() {
    return stub.deleteExecutionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an Execution.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   DeleteExecutionRequest request =
   *       DeleteExecutionRequest.newBuilder()
   *           .setName(
   *               ExecutionName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[EXECUTION]")
   *                   .toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Operation> future =
   *       metadataServiceClient.deleteExecutionCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteExecutionRequest, Operation> deleteExecutionCallable() {
    return stub.deleteExecutionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Purges Executions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   MetadataStoreName parent =
   *       MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]");
   *   PurgeExecutionsResponse response = metadataServiceClient.purgeExecutionsAsync(parent).get();
   * }
   * }</pre>
   *
   * @param parent Required. The metadata store to purge Executions from. Format:
   *     `projects/{project}/locations/{location}/metadataStores/{metadatastore}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PurgeExecutionsResponse, PurgeExecutionsMetadata>
      purgeExecutionsAsync(MetadataStoreName parent) {
    PurgeExecutionsRequest request =
        PurgeExecutionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return purgeExecutionsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Purges Executions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   String parent =
   *       MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]").toString();
   *   PurgeExecutionsResponse response = metadataServiceClient.purgeExecutionsAsync(parent).get();
   * }
   * }</pre>
   *
   * @param parent Required. The metadata store to purge Executions from. Format:
   *     `projects/{project}/locations/{location}/metadataStores/{metadatastore}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PurgeExecutionsResponse, PurgeExecutionsMetadata>
      purgeExecutionsAsync(String parent) {
    PurgeExecutionsRequest request = PurgeExecutionsRequest.newBuilder().setParent(parent).build();
    return purgeExecutionsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Purges Executions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   PurgeExecutionsRequest request =
   *       PurgeExecutionsRequest.newBuilder()
   *           .setParent(
   *               MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]").toString())
   *           .setFilter("filter-1274492040")
   *           .setForce(true)
   *           .build();
   *   PurgeExecutionsResponse response = metadataServiceClient.purgeExecutionsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PurgeExecutionsResponse, PurgeExecutionsMetadata>
      purgeExecutionsAsync(PurgeExecutionsRequest request) {
    return purgeExecutionsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Purges Executions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   PurgeExecutionsRequest request =
   *       PurgeExecutionsRequest.newBuilder()
   *           .setParent(
   *               MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]").toString())
   *           .setFilter("filter-1274492040")
   *           .setForce(true)
   *           .build();
   *   OperationFuture<PurgeExecutionsResponse, PurgeExecutionsMetadata> future =
   *       metadataServiceClient.purgeExecutionsOperationCallable().futureCall(request);
   *   // Do something.
   *   PurgeExecutionsResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          PurgeExecutionsRequest, PurgeExecutionsResponse, PurgeExecutionsMetadata>
      purgeExecutionsOperationCallable() {
    return stub.purgeExecutionsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Purges Executions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   PurgeExecutionsRequest request =
   *       PurgeExecutionsRequest.newBuilder()
   *           .setParent(
   *               MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]").toString())
   *           .setFilter("filter-1274492040")
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       metadataServiceClient.purgeExecutionsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PurgeExecutionsRequest, Operation> purgeExecutionsCallable() {
    return stub.purgeExecutionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds Events to the specified Execution. An Event indicates whether an Artifact was used as an
   * input or output for an Execution. If an Event already exists between the Execution and the
   * Artifact, the Event is skipped.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   ExecutionName execution =
   *       ExecutionName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[EXECUTION]");
   *   List<Event> events = new ArrayList<>();
   *   AddExecutionEventsResponse response =
   *       metadataServiceClient.addExecutionEvents(execution, events);
   * }
   * }</pre>
   *
   * @param execution Required. The resource name of the Execution that the Events connect Artifacts
   *     with. Format:
   *     `projects/{project}/locations/{location}/metadataStores/{metadatastore}/executions/{execution}`
   * @param events The Events to create and add.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AddExecutionEventsResponse addExecutionEvents(
      ExecutionName execution, List<Event> events) {
    AddExecutionEventsRequest request =
        AddExecutionEventsRequest.newBuilder()
            .setExecution(execution == null ? null : execution.toString())
            .addAllEvents(events)
            .build();
    return addExecutionEvents(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds Events to the specified Execution. An Event indicates whether an Artifact was used as an
   * input or output for an Execution. If an Event already exists between the Execution and the
   * Artifact, the Event is skipped.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   String execution =
   *       ExecutionName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[EXECUTION]").toString();
   *   List<Event> events = new ArrayList<>();
   *   AddExecutionEventsResponse response =
   *       metadataServiceClient.addExecutionEvents(execution, events);
   * }
   * }</pre>
   *
   * @param execution Required. The resource name of the Execution that the Events connect Artifacts
   *     with. Format:
   *     `projects/{project}/locations/{location}/metadataStores/{metadatastore}/executions/{execution}`
   * @param events The Events to create and add.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AddExecutionEventsResponse addExecutionEvents(String execution, List<Event> events) {
    AddExecutionEventsRequest request =
        AddExecutionEventsRequest.newBuilder().setExecution(execution).addAllEvents(events).build();
    return addExecutionEvents(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds Events to the specified Execution. An Event indicates whether an Artifact was used as an
   * input or output for an Execution. If an Event already exists between the Execution and the
   * Artifact, the Event is skipped.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   AddExecutionEventsRequest request =
   *       AddExecutionEventsRequest.newBuilder()
   *           .setExecution(
   *               ExecutionName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[EXECUTION]")
   *                   .toString())
   *           .addAllEvents(new ArrayList<Event>())
   *           .build();
   *   AddExecutionEventsResponse response = metadataServiceClient.addExecutionEvents(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AddExecutionEventsResponse addExecutionEvents(AddExecutionEventsRequest request) {
    return addExecutionEventsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds Events to the specified Execution. An Event indicates whether an Artifact was used as an
   * input or output for an Execution. If an Event already exists between the Execution and the
   * Artifact, the Event is skipped.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   AddExecutionEventsRequest request =
   *       AddExecutionEventsRequest.newBuilder()
   *           .setExecution(
   *               ExecutionName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[EXECUTION]")
   *                   .toString())
   *           .addAllEvents(new ArrayList<Event>())
   *           .build();
   *   ApiFuture<AddExecutionEventsResponse> future =
   *       metadataServiceClient.addExecutionEventsCallable().futureCall(request);
   *   // Do something.
   *   AddExecutionEventsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AddExecutionEventsRequest, AddExecutionEventsResponse>
      addExecutionEventsCallable() {
    return stub.addExecutionEventsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Obtains the set of input and output Artifacts for this Execution, in the form of
   * LineageSubgraph that also contains the Execution and connecting Events.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   ExecutionName execution =
   *       ExecutionName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[EXECUTION]");
   *   LineageSubgraph response = metadataServiceClient.queryExecutionInputsAndOutputs(execution);
   * }
   * }</pre>
   *
   * @param execution Required. The resource name of the Execution whose input and output Artifacts
   *     should be retrieved as a LineageSubgraph. Format:
   *     `projects/{project}/locations/{location}/metadataStores/{metadatastore}/executions/{execution}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LineageSubgraph queryExecutionInputsAndOutputs(ExecutionName execution) {
    QueryExecutionInputsAndOutputsRequest request =
        QueryExecutionInputsAndOutputsRequest.newBuilder()
            .setExecution(execution == null ? null : execution.toString())
            .build();
    return queryExecutionInputsAndOutputs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Obtains the set of input and output Artifacts for this Execution, in the form of
   * LineageSubgraph that also contains the Execution and connecting Events.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   String execution =
   *       ExecutionName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[EXECUTION]").toString();
   *   LineageSubgraph response = metadataServiceClient.queryExecutionInputsAndOutputs(execution);
   * }
   * }</pre>
   *
   * @param execution Required. The resource name of the Execution whose input and output Artifacts
   *     should be retrieved as a LineageSubgraph. Format:
   *     `projects/{project}/locations/{location}/metadataStores/{metadatastore}/executions/{execution}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LineageSubgraph queryExecutionInputsAndOutputs(String execution) {
    QueryExecutionInputsAndOutputsRequest request =
        QueryExecutionInputsAndOutputsRequest.newBuilder().setExecution(execution).build();
    return queryExecutionInputsAndOutputs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Obtains the set of input and output Artifacts for this Execution, in the form of
   * LineageSubgraph that also contains the Execution and connecting Events.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   QueryExecutionInputsAndOutputsRequest request =
   *       QueryExecutionInputsAndOutputsRequest.newBuilder()
   *           .setExecution(
   *               ExecutionName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[EXECUTION]")
   *                   .toString())
   *           .build();
   *   LineageSubgraph response = metadataServiceClient.queryExecutionInputsAndOutputs(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LineageSubgraph queryExecutionInputsAndOutputs(
      QueryExecutionInputsAndOutputsRequest request) {
    return queryExecutionInputsAndOutputsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Obtains the set of input and output Artifacts for this Execution, in the form of
   * LineageSubgraph that also contains the Execution and connecting Events.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   QueryExecutionInputsAndOutputsRequest request =
   *       QueryExecutionInputsAndOutputsRequest.newBuilder()
   *           .setExecution(
   *               ExecutionName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[EXECUTION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<LineageSubgraph> future =
   *       metadataServiceClient.queryExecutionInputsAndOutputsCallable().futureCall(request);
   *   // Do something.
   *   LineageSubgraph response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<QueryExecutionInputsAndOutputsRequest, LineageSubgraph>
      queryExecutionInputsAndOutputsCallable() {
    return stub.queryExecutionInputsAndOutputsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a MetadataSchema.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   MetadataStoreName parent =
   *       MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]");
   *   MetadataSchema metadataSchema = MetadataSchema.newBuilder().build();
   *   String metadataSchemaId = "metadataSchemaId1549245163";
   *   MetadataSchema response =
   *       metadataServiceClient.createMetadataSchema(parent, metadataSchema, metadataSchemaId);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the MetadataStore where the MetadataSchema should
   *     be created. Format:
   *     `projects/{project}/locations/{location}/metadataStores/{metadatastore}`
   * @param metadataSchema Required. The MetadataSchema to create.
   * @param metadataSchemaId The {metadata_schema} portion of the resource name with the format:
   *     `projects/{project}/locations/{location}/metadataStores/{metadatastore}/metadataSchemas/{metadataschema}`
   *     If not provided, the MetadataStore's ID will be a UUID generated by the service. Must be
   *     4-128 characters in length. Valid characters are `/[a-z][0-9]-/`. Must be unique across all
   *     MetadataSchemas in the parent Location. (Otherwise the request will fail with
   *     ALREADY_EXISTS, or PERMISSION_DENIED if the caller can't view the preexisting
   *     MetadataSchema.)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MetadataSchema createMetadataSchema(
      MetadataStoreName parent, MetadataSchema metadataSchema, String metadataSchemaId) {
    CreateMetadataSchemaRequest request =
        CreateMetadataSchemaRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setMetadataSchema(metadataSchema)
            .setMetadataSchemaId(metadataSchemaId)
            .build();
    return createMetadataSchema(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a MetadataSchema.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   String parent =
   *       MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]").toString();
   *   MetadataSchema metadataSchema = MetadataSchema.newBuilder().build();
   *   String metadataSchemaId = "metadataSchemaId1549245163";
   *   MetadataSchema response =
   *       metadataServiceClient.createMetadataSchema(parent, metadataSchema, metadataSchemaId);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the MetadataStore where the MetadataSchema should
   *     be created. Format:
   *     `projects/{project}/locations/{location}/metadataStores/{metadatastore}`
   * @param metadataSchema Required. The MetadataSchema to create.
   * @param metadataSchemaId The {metadata_schema} portion of the resource name with the format:
   *     `projects/{project}/locations/{location}/metadataStores/{metadatastore}/metadataSchemas/{metadataschema}`
   *     If not provided, the MetadataStore's ID will be a UUID generated by the service. Must be
   *     4-128 characters in length. Valid characters are `/[a-z][0-9]-/`. Must be unique across all
   *     MetadataSchemas in the parent Location. (Otherwise the request will fail with
   *     ALREADY_EXISTS, or PERMISSION_DENIED if the caller can't view the preexisting
   *     MetadataSchema.)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MetadataSchema createMetadataSchema(
      String parent, MetadataSchema metadataSchema, String metadataSchemaId) {
    CreateMetadataSchemaRequest request =
        CreateMetadataSchemaRequest.newBuilder()
            .setParent(parent)
            .setMetadataSchema(metadataSchema)
            .setMetadataSchemaId(metadataSchemaId)
            .build();
    return createMetadataSchema(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a MetadataSchema.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   CreateMetadataSchemaRequest request =
   *       CreateMetadataSchemaRequest.newBuilder()
   *           .setParent(
   *               MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]").toString())
   *           .setMetadataSchema(MetadataSchema.newBuilder().build())
   *           .setMetadataSchemaId("metadataSchemaId1549245163")
   *           .build();
   *   MetadataSchema response = metadataServiceClient.createMetadataSchema(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MetadataSchema createMetadataSchema(CreateMetadataSchemaRequest request) {
    return createMetadataSchemaCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a MetadataSchema.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   CreateMetadataSchemaRequest request =
   *       CreateMetadataSchemaRequest.newBuilder()
   *           .setParent(
   *               MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]").toString())
   *           .setMetadataSchema(MetadataSchema.newBuilder().build())
   *           .setMetadataSchemaId("metadataSchemaId1549245163")
   *           .build();
   *   ApiFuture<MetadataSchema> future =
   *       metadataServiceClient.createMetadataSchemaCallable().futureCall(request);
   *   // Do something.
   *   MetadataSchema response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateMetadataSchemaRequest, MetadataSchema>
      createMetadataSchemaCallable() {
    return stub.createMetadataSchemaCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a specific MetadataSchema.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   MetadataSchemaName name =
   *       MetadataSchemaName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[METADATA_SCHEMA]");
   *   MetadataSchema response = metadataServiceClient.getMetadataSchema(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the MetadataSchema to retrieve. Format:
   *     `projects/{project}/locations/{location}/metadataStores/{metadatastore}/metadataSchemas/{metadataschema}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MetadataSchema getMetadataSchema(MetadataSchemaName name) {
    GetMetadataSchemaRequest request =
        GetMetadataSchemaRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getMetadataSchema(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a specific MetadataSchema.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   String name =
   *       MetadataSchemaName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[METADATA_SCHEMA]")
   *           .toString();
   *   MetadataSchema response = metadataServiceClient.getMetadataSchema(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the MetadataSchema to retrieve. Format:
   *     `projects/{project}/locations/{location}/metadataStores/{metadatastore}/metadataSchemas/{metadataschema}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MetadataSchema getMetadataSchema(String name) {
    GetMetadataSchemaRequest request = GetMetadataSchemaRequest.newBuilder().setName(name).build();
    return getMetadataSchema(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a specific MetadataSchema.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   GetMetadataSchemaRequest request =
   *       GetMetadataSchemaRequest.newBuilder()
   *           .setName(
   *               MetadataSchemaName.of(
   *                       "[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[METADATA_SCHEMA]")
   *                   .toString())
   *           .build();
   *   MetadataSchema response = metadataServiceClient.getMetadataSchema(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MetadataSchema getMetadataSchema(GetMetadataSchemaRequest request) {
    return getMetadataSchemaCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a specific MetadataSchema.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   GetMetadataSchemaRequest request =
   *       GetMetadataSchemaRequest.newBuilder()
   *           .setName(
   *               MetadataSchemaName.of(
   *                       "[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[METADATA_SCHEMA]")
   *                   .toString())
   *           .build();
   *   ApiFuture<MetadataSchema> future =
   *       metadataServiceClient.getMetadataSchemaCallable().futureCall(request);
   *   // Do something.
   *   MetadataSchema response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetMetadataSchemaRequest, MetadataSchema> getMetadataSchemaCallable() {
    return stub.getMetadataSchemaCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists MetadataSchemas.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   MetadataStoreName parent =
   *       MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]");
   *   for (MetadataSchema element :
   *       metadataServiceClient.listMetadataSchemas(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The MetadataStore whose MetadataSchemas should be listed. Format:
   *     `projects/{project}/locations/{location}/metadataStores/{metadatastore}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMetadataSchemasPagedResponse listMetadataSchemas(MetadataStoreName parent) {
    ListMetadataSchemasRequest request =
        ListMetadataSchemasRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listMetadataSchemas(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists MetadataSchemas.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   String parent =
   *       MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]").toString();
   *   for (MetadataSchema element :
   *       metadataServiceClient.listMetadataSchemas(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The MetadataStore whose MetadataSchemas should be listed. Format:
   *     `projects/{project}/locations/{location}/metadataStores/{metadatastore}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMetadataSchemasPagedResponse listMetadataSchemas(String parent) {
    ListMetadataSchemasRequest request =
        ListMetadataSchemasRequest.newBuilder().setParent(parent).build();
    return listMetadataSchemas(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists MetadataSchemas.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   ListMetadataSchemasRequest request =
   *       ListMetadataSchemasRequest.newBuilder()
   *           .setParent(
   *               MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (MetadataSchema element :
   *       metadataServiceClient.listMetadataSchemas(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMetadataSchemasPagedResponse listMetadataSchemas(
      ListMetadataSchemasRequest request) {
    return listMetadataSchemasPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists MetadataSchemas.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   ListMetadataSchemasRequest request =
   *       ListMetadataSchemasRequest.newBuilder()
   *           .setParent(
   *               MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<MetadataSchema> future =
   *       metadataServiceClient.listMetadataSchemasPagedCallable().futureCall(request);
   *   // Do something.
   *   for (MetadataSchema element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListMetadataSchemasRequest, ListMetadataSchemasPagedResponse>
      listMetadataSchemasPagedCallable() {
    return stub.listMetadataSchemasPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists MetadataSchemas.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   ListMetadataSchemasRequest request =
   *       ListMetadataSchemasRequest.newBuilder()
   *           .setParent(
   *               MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListMetadataSchemasResponse response =
   *         metadataServiceClient.listMetadataSchemasCallable().call(request);
   *     for (MetadataSchema element : response.getMetadataSchemasList()) {
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
  public final UnaryCallable<ListMetadataSchemasRequest, ListMetadataSchemasResponse>
      listMetadataSchemasCallable() {
    return stub.listMetadataSchemasCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves lineage of an Artifact represented through Artifacts and Executions connected by
   * Event edges and returned as a LineageSubgraph.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   ArtifactName artifact =
   *       ArtifactName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[ARTIFACT]");
   *   LineageSubgraph response = metadataServiceClient.queryArtifactLineageSubgraph(artifact);
   * }
   * }</pre>
   *
   * @param artifact Required. The resource name of the Artifact whose Lineage needs to be retrieved
   *     as a LineageSubgraph. Format:
   *     `projects/{project}/locations/{location}/metadataStores/{metadatastore}/artifacts/{artifact}`
   *     <p>The request may error with FAILED_PRECONDITION if the number of Artifacts, the number of
   *     Executions, or the number of Events that would be returned for the Context exceeds 1000.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LineageSubgraph queryArtifactLineageSubgraph(ArtifactName artifact) {
    QueryArtifactLineageSubgraphRequest request =
        QueryArtifactLineageSubgraphRequest.newBuilder()
            .setArtifact(artifact == null ? null : artifact.toString())
            .build();
    return queryArtifactLineageSubgraph(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves lineage of an Artifact represented through Artifacts and Executions connected by
   * Event edges and returned as a LineageSubgraph.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   String artifact =
   *       ArtifactName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[ARTIFACT]").toString();
   *   LineageSubgraph response = metadataServiceClient.queryArtifactLineageSubgraph(artifact);
   * }
   * }</pre>
   *
   * @param artifact Required. The resource name of the Artifact whose Lineage needs to be retrieved
   *     as a LineageSubgraph. Format:
   *     `projects/{project}/locations/{location}/metadataStores/{metadatastore}/artifacts/{artifact}`
   *     <p>The request may error with FAILED_PRECONDITION if the number of Artifacts, the number of
   *     Executions, or the number of Events that would be returned for the Context exceeds 1000.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LineageSubgraph queryArtifactLineageSubgraph(String artifact) {
    QueryArtifactLineageSubgraphRequest request =
        QueryArtifactLineageSubgraphRequest.newBuilder().setArtifact(artifact).build();
    return queryArtifactLineageSubgraph(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves lineage of an Artifact represented through Artifacts and Executions connected by
   * Event edges and returned as a LineageSubgraph.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   QueryArtifactLineageSubgraphRequest request =
   *       QueryArtifactLineageSubgraphRequest.newBuilder()
   *           .setArtifact(
   *               ArtifactName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[ARTIFACT]")
   *                   .toString())
   *           .setMaxHops(407750469)
   *           .setFilter("filter-1274492040")
   *           .build();
   *   LineageSubgraph response = metadataServiceClient.queryArtifactLineageSubgraph(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LineageSubgraph queryArtifactLineageSubgraph(
      QueryArtifactLineageSubgraphRequest request) {
    return queryArtifactLineageSubgraphCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves lineage of an Artifact represented through Artifacts and Executions connected by
   * Event edges and returned as a LineageSubgraph.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   QueryArtifactLineageSubgraphRequest request =
   *       QueryArtifactLineageSubgraphRequest.newBuilder()
   *           .setArtifact(
   *               ArtifactName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[ARTIFACT]")
   *                   .toString())
   *           .setMaxHops(407750469)
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<LineageSubgraph> future =
   *       metadataServiceClient.queryArtifactLineageSubgraphCallable().futureCall(request);
   *   // Do something.
   *   LineageSubgraph response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<QueryArtifactLineageSubgraphRequest, LineageSubgraph>
      queryArtifactLineageSubgraphCallable() {
    return stub.queryArtifactLineageSubgraphCallable();
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
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : metadataServiceClient.listLocations(request).iterateAll()) {
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
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       metadataServiceClient.listLocationsPagedCallable().futureCall(request);
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
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         metadataServiceClient.listLocationsCallable().call(request);
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
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = metadataServiceClient.getLocation(request);
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
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = metadataServiceClient.getLocationCallable().futureCall(request);
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
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = metadataServiceClient.setIamPolicy(request);
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
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = metadataServiceClient.setIamPolicyCallable().futureCall(request);
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
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = metadataServiceClient.getIamPolicy(request);
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
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = metadataServiceClient.getIamPolicyCallable().futureCall(request);
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
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = metadataServiceClient.testIamPermissions(request);
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
   * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       metadataServiceClient.testIamPermissionsCallable().futureCall(request);
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

  public static class ListMetadataStoresPagedResponse
      extends AbstractPagedListResponse<
          ListMetadataStoresRequest,
          ListMetadataStoresResponse,
          MetadataStore,
          ListMetadataStoresPage,
          ListMetadataStoresFixedSizeCollection> {

    public static ApiFuture<ListMetadataStoresPagedResponse> createAsync(
        PageContext<ListMetadataStoresRequest, ListMetadataStoresResponse, MetadataStore> context,
        ApiFuture<ListMetadataStoresResponse> futureResponse) {
      ApiFuture<ListMetadataStoresPage> futurePage =
          ListMetadataStoresPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListMetadataStoresPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListMetadataStoresPagedResponse(ListMetadataStoresPage page) {
      super(page, ListMetadataStoresFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListMetadataStoresPage
      extends AbstractPage<
          ListMetadataStoresRequest,
          ListMetadataStoresResponse,
          MetadataStore,
          ListMetadataStoresPage> {

    private ListMetadataStoresPage(
        PageContext<ListMetadataStoresRequest, ListMetadataStoresResponse, MetadataStore> context,
        ListMetadataStoresResponse response) {
      super(context, response);
    }

    private static ListMetadataStoresPage createEmptyPage() {
      return new ListMetadataStoresPage(null, null);
    }

    @Override
    protected ListMetadataStoresPage createPage(
        PageContext<ListMetadataStoresRequest, ListMetadataStoresResponse, MetadataStore> context,
        ListMetadataStoresResponse response) {
      return new ListMetadataStoresPage(context, response);
    }

    @Override
    public ApiFuture<ListMetadataStoresPage> createPageAsync(
        PageContext<ListMetadataStoresRequest, ListMetadataStoresResponse, MetadataStore> context,
        ApiFuture<ListMetadataStoresResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListMetadataStoresFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListMetadataStoresRequest,
          ListMetadataStoresResponse,
          MetadataStore,
          ListMetadataStoresPage,
          ListMetadataStoresFixedSizeCollection> {

    private ListMetadataStoresFixedSizeCollection(
        List<ListMetadataStoresPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListMetadataStoresFixedSizeCollection createEmptyCollection() {
      return new ListMetadataStoresFixedSizeCollection(null, 0);
    }

    @Override
    protected ListMetadataStoresFixedSizeCollection createCollection(
        List<ListMetadataStoresPage> pages, int collectionSize) {
      return new ListMetadataStoresFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListArtifactsPagedResponse
      extends AbstractPagedListResponse<
          ListArtifactsRequest,
          ListArtifactsResponse,
          Artifact,
          ListArtifactsPage,
          ListArtifactsFixedSizeCollection> {

    public static ApiFuture<ListArtifactsPagedResponse> createAsync(
        PageContext<ListArtifactsRequest, ListArtifactsResponse, Artifact> context,
        ApiFuture<ListArtifactsResponse> futureResponse) {
      ApiFuture<ListArtifactsPage> futurePage =
          ListArtifactsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListArtifactsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListArtifactsPagedResponse(ListArtifactsPage page) {
      super(page, ListArtifactsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListArtifactsPage
      extends AbstractPage<
          ListArtifactsRequest, ListArtifactsResponse, Artifact, ListArtifactsPage> {

    private ListArtifactsPage(
        PageContext<ListArtifactsRequest, ListArtifactsResponse, Artifact> context,
        ListArtifactsResponse response) {
      super(context, response);
    }

    private static ListArtifactsPage createEmptyPage() {
      return new ListArtifactsPage(null, null);
    }

    @Override
    protected ListArtifactsPage createPage(
        PageContext<ListArtifactsRequest, ListArtifactsResponse, Artifact> context,
        ListArtifactsResponse response) {
      return new ListArtifactsPage(context, response);
    }

    @Override
    public ApiFuture<ListArtifactsPage> createPageAsync(
        PageContext<ListArtifactsRequest, ListArtifactsResponse, Artifact> context,
        ApiFuture<ListArtifactsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListArtifactsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListArtifactsRequest,
          ListArtifactsResponse,
          Artifact,
          ListArtifactsPage,
          ListArtifactsFixedSizeCollection> {

    private ListArtifactsFixedSizeCollection(List<ListArtifactsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListArtifactsFixedSizeCollection createEmptyCollection() {
      return new ListArtifactsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListArtifactsFixedSizeCollection createCollection(
        List<ListArtifactsPage> pages, int collectionSize) {
      return new ListArtifactsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListContextsPagedResponse
      extends AbstractPagedListResponse<
          ListContextsRequest,
          ListContextsResponse,
          Context,
          ListContextsPage,
          ListContextsFixedSizeCollection> {

    public static ApiFuture<ListContextsPagedResponse> createAsync(
        PageContext<ListContextsRequest, ListContextsResponse, Context> context,
        ApiFuture<ListContextsResponse> futureResponse) {
      ApiFuture<ListContextsPage> futurePage =
          ListContextsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListContextsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListContextsPagedResponse(ListContextsPage page) {
      super(page, ListContextsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListContextsPage
      extends AbstractPage<ListContextsRequest, ListContextsResponse, Context, ListContextsPage> {

    private ListContextsPage(
        PageContext<ListContextsRequest, ListContextsResponse, Context> context,
        ListContextsResponse response) {
      super(context, response);
    }

    private static ListContextsPage createEmptyPage() {
      return new ListContextsPage(null, null);
    }

    @Override
    protected ListContextsPage createPage(
        PageContext<ListContextsRequest, ListContextsResponse, Context> context,
        ListContextsResponse response) {
      return new ListContextsPage(context, response);
    }

    @Override
    public ApiFuture<ListContextsPage> createPageAsync(
        PageContext<ListContextsRequest, ListContextsResponse, Context> context,
        ApiFuture<ListContextsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListContextsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListContextsRequest,
          ListContextsResponse,
          Context,
          ListContextsPage,
          ListContextsFixedSizeCollection> {

    private ListContextsFixedSizeCollection(List<ListContextsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListContextsFixedSizeCollection createEmptyCollection() {
      return new ListContextsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListContextsFixedSizeCollection createCollection(
        List<ListContextsPage> pages, int collectionSize) {
      return new ListContextsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListExecutionsPagedResponse
      extends AbstractPagedListResponse<
          ListExecutionsRequest,
          ListExecutionsResponse,
          Execution,
          ListExecutionsPage,
          ListExecutionsFixedSizeCollection> {

    public static ApiFuture<ListExecutionsPagedResponse> createAsync(
        PageContext<ListExecutionsRequest, ListExecutionsResponse, Execution> context,
        ApiFuture<ListExecutionsResponse> futureResponse) {
      ApiFuture<ListExecutionsPage> futurePage =
          ListExecutionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListExecutionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListExecutionsPagedResponse(ListExecutionsPage page) {
      super(page, ListExecutionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListExecutionsPage
      extends AbstractPage<
          ListExecutionsRequest, ListExecutionsResponse, Execution, ListExecutionsPage> {

    private ListExecutionsPage(
        PageContext<ListExecutionsRequest, ListExecutionsResponse, Execution> context,
        ListExecutionsResponse response) {
      super(context, response);
    }

    private static ListExecutionsPage createEmptyPage() {
      return new ListExecutionsPage(null, null);
    }

    @Override
    protected ListExecutionsPage createPage(
        PageContext<ListExecutionsRequest, ListExecutionsResponse, Execution> context,
        ListExecutionsResponse response) {
      return new ListExecutionsPage(context, response);
    }

    @Override
    public ApiFuture<ListExecutionsPage> createPageAsync(
        PageContext<ListExecutionsRequest, ListExecutionsResponse, Execution> context,
        ApiFuture<ListExecutionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListExecutionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListExecutionsRequest,
          ListExecutionsResponse,
          Execution,
          ListExecutionsPage,
          ListExecutionsFixedSizeCollection> {

    private ListExecutionsFixedSizeCollection(List<ListExecutionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListExecutionsFixedSizeCollection createEmptyCollection() {
      return new ListExecutionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListExecutionsFixedSizeCollection createCollection(
        List<ListExecutionsPage> pages, int collectionSize) {
      return new ListExecutionsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListMetadataSchemasPagedResponse
      extends AbstractPagedListResponse<
          ListMetadataSchemasRequest,
          ListMetadataSchemasResponse,
          MetadataSchema,
          ListMetadataSchemasPage,
          ListMetadataSchemasFixedSizeCollection> {

    public static ApiFuture<ListMetadataSchemasPagedResponse> createAsync(
        PageContext<ListMetadataSchemasRequest, ListMetadataSchemasResponse, MetadataSchema>
            context,
        ApiFuture<ListMetadataSchemasResponse> futureResponse) {
      ApiFuture<ListMetadataSchemasPage> futurePage =
          ListMetadataSchemasPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListMetadataSchemasPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListMetadataSchemasPagedResponse(ListMetadataSchemasPage page) {
      super(page, ListMetadataSchemasFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListMetadataSchemasPage
      extends AbstractPage<
          ListMetadataSchemasRequest,
          ListMetadataSchemasResponse,
          MetadataSchema,
          ListMetadataSchemasPage> {

    private ListMetadataSchemasPage(
        PageContext<ListMetadataSchemasRequest, ListMetadataSchemasResponse, MetadataSchema>
            context,
        ListMetadataSchemasResponse response) {
      super(context, response);
    }

    private static ListMetadataSchemasPage createEmptyPage() {
      return new ListMetadataSchemasPage(null, null);
    }

    @Override
    protected ListMetadataSchemasPage createPage(
        PageContext<ListMetadataSchemasRequest, ListMetadataSchemasResponse, MetadataSchema>
            context,
        ListMetadataSchemasResponse response) {
      return new ListMetadataSchemasPage(context, response);
    }

    @Override
    public ApiFuture<ListMetadataSchemasPage> createPageAsync(
        PageContext<ListMetadataSchemasRequest, ListMetadataSchemasResponse, MetadataSchema>
            context,
        ApiFuture<ListMetadataSchemasResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListMetadataSchemasFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListMetadataSchemasRequest,
          ListMetadataSchemasResponse,
          MetadataSchema,
          ListMetadataSchemasPage,
          ListMetadataSchemasFixedSizeCollection> {

    private ListMetadataSchemasFixedSizeCollection(
        List<ListMetadataSchemasPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListMetadataSchemasFixedSizeCollection createEmptyCollection() {
      return new ListMetadataSchemasFixedSizeCollection(null, 0);
    }

    @Override
    protected ListMetadataSchemasFixedSizeCollection createCollection(
        List<ListMetadataSchemasPage> pages, int collectionSize) {
      return new ListMetadataSchemasFixedSizeCollection(pages, collectionSize);
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
