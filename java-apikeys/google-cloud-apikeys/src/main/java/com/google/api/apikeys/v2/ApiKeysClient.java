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

package com.google.api.apikeys.v2;

import com.google.api.apikeys.v2.stub.ApiKeysStub;
import com.google.api.apikeys.v2.stub.ApiKeysStubSettings;
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
 * Service Description: Manages the API keys associated with projects.
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
 * try (ApiKeysClient apiKeysClient = ApiKeysClient.create()) {
 *   KeyName name = KeyName.of("[PROJECT]", "[LOCATION]", "[KEY]");
 *   Key response = apiKeysClient.getKey(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ApiKeysClient object to clean up resources such as
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
 * <p>This class can be customized by passing in a custom instance of ApiKeysSettings to create().
 * For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ApiKeysSettings apiKeysSettings =
 *     ApiKeysSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ApiKeysClient apiKeysClient = ApiKeysClient.create(apiKeysSettings);
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
 * ApiKeysSettings apiKeysSettings = ApiKeysSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ApiKeysClient apiKeysClient = ApiKeysClient.create(apiKeysSettings);
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
 * ApiKeysSettings apiKeysSettings =
 *     ApiKeysSettings.newBuilder()
 *         .setTransportChannelProvider(
 *             ApiKeysSettings.defaultHttpJsonTransportProviderBuilder().build())
 *         .build();
 * ApiKeysClient apiKeysClient = ApiKeysClient.create(apiKeysSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class ApiKeysClient implements BackgroundResource {
  private final ApiKeysSettings settings;
  private final ApiKeysStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of ApiKeysClient with default settings. */
  public static final ApiKeysClient create() throws IOException {
    return create(ApiKeysSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ApiKeysClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ApiKeysClient create(ApiKeysSettings settings) throws IOException {
    return new ApiKeysClient(settings);
  }

  /**
   * Constructs an instance of ApiKeysClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(ApiKeysSettings).
   */
  public static final ApiKeysClient create(ApiKeysStub stub) {
    return new ApiKeysClient(stub);
  }

  /**
   * Constructs an instance of ApiKeysClient, using the given settings. This is protected so that it
   * is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected ApiKeysClient(ApiKeysSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ApiKeysStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected ApiKeysClient(ApiKeysStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final ApiKeysSettings getSettings() {
    return settings;
  }

  public ApiKeysStub getStub() {
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
   * Creates a new API key.
   *
   * <p>NOTE: Key is a global resource; hence the only supported value for location is `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiKeysClient apiKeysClient = ApiKeysClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Key key = Key.newBuilder().build();
   *   String keyId = "keyId101944282";
   *   Key response = apiKeysClient.createKeyAsync(parent, key, keyId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The project in which the API key is created.
   * @param key Required. The API key fields to set at creation time. You can configure only the
   *     `display_name`, `restrictions`, and `annotations` fields.
   * @param keyId User specified key id (optional). If specified, it will become the final component
   *     of the key resource name.
   *     <p>The id must be unique within the project, must conform with RFC-1034, is restricted to
   *     lower-cased letters, and has a maximum length of 63 characters. In another word, the id
   *     must match the regular expression: `[a-z]([a-z0-9-]{0,61}[a-z0-9])?`.
   *     <p>The id must NOT be a UUID-like string.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Key, Empty> createKeyAsync(
      LocationName parent, Key key, String keyId) {
    CreateKeyRequest request =
        CreateKeyRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setKey(key)
            .setKeyId(keyId)
            .build();
    return createKeyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new API key.
   *
   * <p>NOTE: Key is a global resource; hence the only supported value for location is `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiKeysClient apiKeysClient = ApiKeysClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Key key = Key.newBuilder().build();
   *   String keyId = "keyId101944282";
   *   Key response = apiKeysClient.createKeyAsync(parent, key, keyId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The project in which the API key is created.
   * @param key Required. The API key fields to set at creation time. You can configure only the
   *     `display_name`, `restrictions`, and `annotations` fields.
   * @param keyId User specified key id (optional). If specified, it will become the final component
   *     of the key resource name.
   *     <p>The id must be unique within the project, must conform with RFC-1034, is restricted to
   *     lower-cased letters, and has a maximum length of 63 characters. In another word, the id
   *     must match the regular expression: `[a-z]([a-z0-9-]{0,61}[a-z0-9])?`.
   *     <p>The id must NOT be a UUID-like string.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Key, Empty> createKeyAsync(String parent, Key key, String keyId) {
    CreateKeyRequest request =
        CreateKeyRequest.newBuilder().setParent(parent).setKey(key).setKeyId(keyId).build();
    return createKeyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new API key.
   *
   * <p>NOTE: Key is a global resource; hence the only supported value for location is `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiKeysClient apiKeysClient = ApiKeysClient.create()) {
   *   CreateKeyRequest request =
   *       CreateKeyRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setKey(Key.newBuilder().build())
   *           .setKeyId("keyId101944282")
   *           .build();
   *   Key response = apiKeysClient.createKeyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Key, Empty> createKeyAsync(CreateKeyRequest request) {
    return createKeyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new API key.
   *
   * <p>NOTE: Key is a global resource; hence the only supported value for location is `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiKeysClient apiKeysClient = ApiKeysClient.create()) {
   *   CreateKeyRequest request =
   *       CreateKeyRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setKey(Key.newBuilder().build())
   *           .setKeyId("keyId101944282")
   *           .build();
   *   OperationFuture<Key, Empty> future =
   *       apiKeysClient.createKeyOperationCallable().futureCall(request);
   *   // Do something.
   *   Key response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateKeyRequest, Key, Empty> createKeyOperationCallable() {
    return stub.createKeyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new API key.
   *
   * <p>NOTE: Key is a global resource; hence the only supported value for location is `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiKeysClient apiKeysClient = ApiKeysClient.create()) {
   *   CreateKeyRequest request =
   *       CreateKeyRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setKey(Key.newBuilder().build())
   *           .setKeyId("keyId101944282")
   *           .build();
   *   ApiFuture<Operation> future = apiKeysClient.createKeyCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateKeyRequest, Operation> createKeyCallable() {
    return stub.createKeyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the API keys owned by a project. The key string of the API key isn't included in the
   * response.
   *
   * <p>NOTE: Key is a global resource; hence the only supported value for location is `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiKeysClient apiKeysClient = ApiKeysClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Key element : apiKeysClient.listKeys(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Lists all API keys associated with this project.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListKeysPagedResponse listKeys(LocationName parent) {
    ListKeysRequest request =
        ListKeysRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listKeys(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the API keys owned by a project. The key string of the API key isn't included in the
   * response.
   *
   * <p>NOTE: Key is a global resource; hence the only supported value for location is `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiKeysClient apiKeysClient = ApiKeysClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Key element : apiKeysClient.listKeys(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Lists all API keys associated with this project.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListKeysPagedResponse listKeys(String parent) {
    ListKeysRequest request = ListKeysRequest.newBuilder().setParent(parent).build();
    return listKeys(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the API keys owned by a project. The key string of the API key isn't included in the
   * response.
   *
   * <p>NOTE: Key is a global resource; hence the only supported value for location is `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiKeysClient apiKeysClient = ApiKeysClient.create()) {
   *   ListKeysRequest request =
   *       ListKeysRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setShowDeleted(true)
   *           .build();
   *   for (Key element : apiKeysClient.listKeys(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListKeysPagedResponse listKeys(ListKeysRequest request) {
    return listKeysPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the API keys owned by a project. The key string of the API key isn't included in the
   * response.
   *
   * <p>NOTE: Key is a global resource; hence the only supported value for location is `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiKeysClient apiKeysClient = ApiKeysClient.create()) {
   *   ListKeysRequest request =
   *       ListKeysRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setShowDeleted(true)
   *           .build();
   *   ApiFuture<Key> future = apiKeysClient.listKeysPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Key element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListKeysRequest, ListKeysPagedResponse> listKeysPagedCallable() {
    return stub.listKeysPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the API keys owned by a project. The key string of the API key isn't included in the
   * response.
   *
   * <p>NOTE: Key is a global resource; hence the only supported value for location is `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiKeysClient apiKeysClient = ApiKeysClient.create()) {
   *   ListKeysRequest request =
   *       ListKeysRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setShowDeleted(true)
   *           .build();
   *   while (true) {
   *     ListKeysResponse response = apiKeysClient.listKeysCallable().call(request);
   *     for (Key element : response.getKeysList()) {
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
  public final UnaryCallable<ListKeysRequest, ListKeysResponse> listKeysCallable() {
    return stub.listKeysCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the metadata for an API key. The key string of the API key isn't included in the response.
   *
   * <p>NOTE: Key is a global resource; hence the only supported value for location is `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiKeysClient apiKeysClient = ApiKeysClient.create()) {
   *   KeyName name = KeyName.of("[PROJECT]", "[LOCATION]", "[KEY]");
   *   Key response = apiKeysClient.getKey(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the API key to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Key getKey(KeyName name) {
    GetKeyRequest request =
        GetKeyRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the metadata for an API key. The key string of the API key isn't included in the response.
   *
   * <p>NOTE: Key is a global resource; hence the only supported value for location is `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiKeysClient apiKeysClient = ApiKeysClient.create()) {
   *   String name = KeyName.of("[PROJECT]", "[LOCATION]", "[KEY]").toString();
   *   Key response = apiKeysClient.getKey(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the API key to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Key getKey(String name) {
    GetKeyRequest request = GetKeyRequest.newBuilder().setName(name).build();
    return getKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the metadata for an API key. The key string of the API key isn't included in the response.
   *
   * <p>NOTE: Key is a global resource; hence the only supported value for location is `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiKeysClient apiKeysClient = ApiKeysClient.create()) {
   *   GetKeyRequest request =
   *       GetKeyRequest.newBuilder()
   *           .setName(KeyName.of("[PROJECT]", "[LOCATION]", "[KEY]").toString())
   *           .build();
   *   Key response = apiKeysClient.getKey(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Key getKey(GetKeyRequest request) {
    return getKeyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the metadata for an API key. The key string of the API key isn't included in the response.
   *
   * <p>NOTE: Key is a global resource; hence the only supported value for location is `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiKeysClient apiKeysClient = ApiKeysClient.create()) {
   *   GetKeyRequest request =
   *       GetKeyRequest.newBuilder()
   *           .setName(KeyName.of("[PROJECT]", "[LOCATION]", "[KEY]").toString())
   *           .build();
   *   ApiFuture<Key> future = apiKeysClient.getKeyCallable().futureCall(request);
   *   // Do something.
   *   Key response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetKeyRequest, Key> getKeyCallable() {
    return stub.getKeyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the key string for an API key.
   *
   * <p>NOTE: Key is a global resource; hence the only supported value for location is `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiKeysClient apiKeysClient = ApiKeysClient.create()) {
   *   KeyName name = KeyName.of("[PROJECT]", "[LOCATION]", "[KEY]");
   *   GetKeyStringResponse response = apiKeysClient.getKeyString(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the API key to be retrieved.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GetKeyStringResponse getKeyString(KeyName name) {
    GetKeyStringRequest request =
        GetKeyStringRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getKeyString(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the key string for an API key.
   *
   * <p>NOTE: Key is a global resource; hence the only supported value for location is `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiKeysClient apiKeysClient = ApiKeysClient.create()) {
   *   String name = KeyName.of("[PROJECT]", "[LOCATION]", "[KEY]").toString();
   *   GetKeyStringResponse response = apiKeysClient.getKeyString(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the API key to be retrieved.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GetKeyStringResponse getKeyString(String name) {
    GetKeyStringRequest request = GetKeyStringRequest.newBuilder().setName(name).build();
    return getKeyString(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the key string for an API key.
   *
   * <p>NOTE: Key is a global resource; hence the only supported value for location is `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiKeysClient apiKeysClient = ApiKeysClient.create()) {
   *   GetKeyStringRequest request =
   *       GetKeyStringRequest.newBuilder()
   *           .setName(KeyName.of("[PROJECT]", "[LOCATION]", "[KEY]").toString())
   *           .build();
   *   GetKeyStringResponse response = apiKeysClient.getKeyString(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GetKeyStringResponse getKeyString(GetKeyStringRequest request) {
    return getKeyStringCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the key string for an API key.
   *
   * <p>NOTE: Key is a global resource; hence the only supported value for location is `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiKeysClient apiKeysClient = ApiKeysClient.create()) {
   *   GetKeyStringRequest request =
   *       GetKeyStringRequest.newBuilder()
   *           .setName(KeyName.of("[PROJECT]", "[LOCATION]", "[KEY]").toString())
   *           .build();
   *   ApiFuture<GetKeyStringResponse> future =
   *       apiKeysClient.getKeyStringCallable().futureCall(request);
   *   // Do something.
   *   GetKeyStringResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetKeyStringRequest, GetKeyStringResponse> getKeyStringCallable() {
    return stub.getKeyStringCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the modifiable fields of an API key. The key string of the API key isn't included in
   * the response.
   *
   * <p>NOTE: Key is a global resource; hence the only supported value for location is `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiKeysClient apiKeysClient = ApiKeysClient.create()) {
   *   Key key = Key.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Key response = apiKeysClient.updateKeyAsync(key, updateMask).get();
   * }
   * }</pre>
   *
   * @param key Required. Set the `name` field to the resource name of the API key to be updated.
   *     You can update only the `display_name`, `restrictions`, and `annotations` fields.
   * @param updateMask The field mask specifies which fields to be updated as part of this request.
   *     All other fields are ignored. Mutable fields are: `display_name`, `restrictions`, and
   *     `annotations`. If an update mask is not provided, the service treats it as an implied mask
   *     equivalent to all allowed fields that are set on the wire. If the field mask has a special
   *     value "&#42;", the service treats it equivalent to replace all allowed mutable fields.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Key, Empty> updateKeyAsync(Key key, FieldMask updateMask) {
    UpdateKeyRequest request =
        UpdateKeyRequest.newBuilder().setKey(key).setUpdateMask(updateMask).build();
    return updateKeyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the modifiable fields of an API key. The key string of the API key isn't included in
   * the response.
   *
   * <p>NOTE: Key is a global resource; hence the only supported value for location is `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiKeysClient apiKeysClient = ApiKeysClient.create()) {
   *   UpdateKeyRequest request =
   *       UpdateKeyRequest.newBuilder()
   *           .setKey(Key.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Key response = apiKeysClient.updateKeyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Key, Empty> updateKeyAsync(UpdateKeyRequest request) {
    return updateKeyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the modifiable fields of an API key. The key string of the API key isn't included in
   * the response.
   *
   * <p>NOTE: Key is a global resource; hence the only supported value for location is `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiKeysClient apiKeysClient = ApiKeysClient.create()) {
   *   UpdateKeyRequest request =
   *       UpdateKeyRequest.newBuilder()
   *           .setKey(Key.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<Key, Empty> future =
   *       apiKeysClient.updateKeyOperationCallable().futureCall(request);
   *   // Do something.
   *   Key response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateKeyRequest, Key, Empty> updateKeyOperationCallable() {
    return stub.updateKeyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the modifiable fields of an API key. The key string of the API key isn't included in
   * the response.
   *
   * <p>NOTE: Key is a global resource; hence the only supported value for location is `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiKeysClient apiKeysClient = ApiKeysClient.create()) {
   *   UpdateKeyRequest request =
   *       UpdateKeyRequest.newBuilder()
   *           .setKey(Key.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = apiKeysClient.updateKeyCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateKeyRequest, Operation> updateKeyCallable() {
    return stub.updateKeyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an API key. Deleted key can be retrieved within 30 days of deletion. Afterward, key
   * will be purged from the project.
   *
   * <p>NOTE: Key is a global resource; hence the only supported value for location is `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiKeysClient apiKeysClient = ApiKeysClient.create()) {
   *   KeyName name = KeyName.of("[PROJECT]", "[LOCATION]", "[KEY]");
   *   Key response = apiKeysClient.deleteKeyAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the API key to be deleted.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Key, Empty> deleteKeyAsync(KeyName name) {
    DeleteKeyRequest request =
        DeleteKeyRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteKeyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an API key. Deleted key can be retrieved within 30 days of deletion. Afterward, key
   * will be purged from the project.
   *
   * <p>NOTE: Key is a global resource; hence the only supported value for location is `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiKeysClient apiKeysClient = ApiKeysClient.create()) {
   *   String name = KeyName.of("[PROJECT]", "[LOCATION]", "[KEY]").toString();
   *   Key response = apiKeysClient.deleteKeyAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the API key to be deleted.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Key, Empty> deleteKeyAsync(String name) {
    DeleteKeyRequest request = DeleteKeyRequest.newBuilder().setName(name).build();
    return deleteKeyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an API key. Deleted key can be retrieved within 30 days of deletion. Afterward, key
   * will be purged from the project.
   *
   * <p>NOTE: Key is a global resource; hence the only supported value for location is `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiKeysClient apiKeysClient = ApiKeysClient.create()) {
   *   DeleteKeyRequest request =
   *       DeleteKeyRequest.newBuilder()
   *           .setName(KeyName.of("[PROJECT]", "[LOCATION]", "[KEY]").toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   Key response = apiKeysClient.deleteKeyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Key, Empty> deleteKeyAsync(DeleteKeyRequest request) {
    return deleteKeyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an API key. Deleted key can be retrieved within 30 days of deletion. Afterward, key
   * will be purged from the project.
   *
   * <p>NOTE: Key is a global resource; hence the only supported value for location is `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiKeysClient apiKeysClient = ApiKeysClient.create()) {
   *   DeleteKeyRequest request =
   *       DeleteKeyRequest.newBuilder()
   *           .setName(KeyName.of("[PROJECT]", "[LOCATION]", "[KEY]").toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   OperationFuture<Key, Empty> future =
   *       apiKeysClient.deleteKeyOperationCallable().futureCall(request);
   *   // Do something.
   *   Key response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteKeyRequest, Key, Empty> deleteKeyOperationCallable() {
    return stub.deleteKeyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an API key. Deleted key can be retrieved within 30 days of deletion. Afterward, key
   * will be purged from the project.
   *
   * <p>NOTE: Key is a global resource; hence the only supported value for location is `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiKeysClient apiKeysClient = ApiKeysClient.create()) {
   *   DeleteKeyRequest request =
   *       DeleteKeyRequest.newBuilder()
   *           .setName(KeyName.of("[PROJECT]", "[LOCATION]", "[KEY]").toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Operation> future = apiKeysClient.deleteKeyCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteKeyRequest, Operation> deleteKeyCallable() {
    return stub.deleteKeyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeletes an API key which was deleted within 30 days.
   *
   * <p>NOTE: Key is a global resource; hence the only supported value for location is `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiKeysClient apiKeysClient = ApiKeysClient.create()) {
   *   UndeleteKeyRequest request =
   *       UndeleteKeyRequest.newBuilder()
   *           .setName(KeyName.of("[PROJECT]", "[LOCATION]", "[KEY]").toString())
   *           .build();
   *   Key response = apiKeysClient.undeleteKeyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Key, Empty> undeleteKeyAsync(UndeleteKeyRequest request) {
    return undeleteKeyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeletes an API key which was deleted within 30 days.
   *
   * <p>NOTE: Key is a global resource; hence the only supported value for location is `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiKeysClient apiKeysClient = ApiKeysClient.create()) {
   *   UndeleteKeyRequest request =
   *       UndeleteKeyRequest.newBuilder()
   *           .setName(KeyName.of("[PROJECT]", "[LOCATION]", "[KEY]").toString())
   *           .build();
   *   OperationFuture<Key, Empty> future =
   *       apiKeysClient.undeleteKeyOperationCallable().futureCall(request);
   *   // Do something.
   *   Key response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UndeleteKeyRequest, Key, Empty> undeleteKeyOperationCallable() {
    return stub.undeleteKeyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeletes an API key which was deleted within 30 days.
   *
   * <p>NOTE: Key is a global resource; hence the only supported value for location is `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiKeysClient apiKeysClient = ApiKeysClient.create()) {
   *   UndeleteKeyRequest request =
   *       UndeleteKeyRequest.newBuilder()
   *           .setName(KeyName.of("[PROJECT]", "[LOCATION]", "[KEY]").toString())
   *           .build();
   *   ApiFuture<Operation> future = apiKeysClient.undeleteKeyCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UndeleteKeyRequest, Operation> undeleteKeyCallable() {
    return stub.undeleteKeyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Find the parent project and resource name of the API key that matches the key string in the
   * request. If the API key has been purged, resource name will not be set. The service account
   * must have the `apikeys.keys.lookup` permission on the parent project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiKeysClient apiKeysClient = ApiKeysClient.create()) {
   *   LookupKeyRequest request =
   *       LookupKeyRequest.newBuilder().setKeyString("keyString-1988270256").build();
   *   LookupKeyResponse response = apiKeysClient.lookupKey(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LookupKeyResponse lookupKey(LookupKeyRequest request) {
    return lookupKeyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Find the parent project and resource name of the API key that matches the key string in the
   * request. If the API key has been purged, resource name will not be set. The service account
   * must have the `apikeys.keys.lookup` permission on the parent project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiKeysClient apiKeysClient = ApiKeysClient.create()) {
   *   LookupKeyRequest request =
   *       LookupKeyRequest.newBuilder().setKeyString("keyString-1988270256").build();
   *   ApiFuture<LookupKeyResponse> future = apiKeysClient.lookupKeyCallable().futureCall(request);
   *   // Do something.
   *   LookupKeyResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<LookupKeyRequest, LookupKeyResponse> lookupKeyCallable() {
    return stub.lookupKeyCallable();
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

  public static class ListKeysPagedResponse
      extends AbstractPagedListResponse<
          ListKeysRequest, ListKeysResponse, Key, ListKeysPage, ListKeysFixedSizeCollection> {

    public static ApiFuture<ListKeysPagedResponse> createAsync(
        PageContext<ListKeysRequest, ListKeysResponse, Key> context,
        ApiFuture<ListKeysResponse> futureResponse) {
      ApiFuture<ListKeysPage> futurePage =
          ListKeysPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListKeysPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListKeysPagedResponse(ListKeysPage page) {
      super(page, ListKeysFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListKeysPage
      extends AbstractPage<ListKeysRequest, ListKeysResponse, Key, ListKeysPage> {

    private ListKeysPage(
        PageContext<ListKeysRequest, ListKeysResponse, Key> context, ListKeysResponse response) {
      super(context, response);
    }

    private static ListKeysPage createEmptyPage() {
      return new ListKeysPage(null, null);
    }

    @Override
    protected ListKeysPage createPage(
        PageContext<ListKeysRequest, ListKeysResponse, Key> context, ListKeysResponse response) {
      return new ListKeysPage(context, response);
    }

    @Override
    public ApiFuture<ListKeysPage> createPageAsync(
        PageContext<ListKeysRequest, ListKeysResponse, Key> context,
        ApiFuture<ListKeysResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListKeysFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListKeysRequest, ListKeysResponse, Key, ListKeysPage, ListKeysFixedSizeCollection> {

    private ListKeysFixedSizeCollection(List<ListKeysPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListKeysFixedSizeCollection createEmptyCollection() {
      return new ListKeysFixedSizeCollection(null, 0);
    }

    @Override
    protected ListKeysFixedSizeCollection createCollection(
        List<ListKeysPage> pages, int collectionSize) {
      return new ListKeysFixedSizeCollection(pages, collectionSize);
    }
  }
}
