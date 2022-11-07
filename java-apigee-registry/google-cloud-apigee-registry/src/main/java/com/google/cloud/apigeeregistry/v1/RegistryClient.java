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

package com.google.cloud.apigeeregistry.v1;

import com.google.api.HttpBody;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.apigeeregistry.v1.stub.RegistryStub;
import com.google.cloud.apigeeregistry.v1.stub.RegistryStubSettings;
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
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The Registry service allows teams to manage descriptions of APIs.
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
 * try (RegistryClient registryClient = RegistryClient.create()) {
 *   ApiName name = ApiName.of("[PROJECT]", "[LOCATION]", "[API]");
 *   Api response = registryClient.getApi(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the RegistryClient object to clean up resources such as
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
 * <p>This class can be customized by passing in a custom instance of RegistrySettings to create().
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
 * RegistrySettings registrySettings =
 *     RegistrySettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * RegistryClient registryClient = RegistryClient.create(registrySettings);
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
 * RegistrySettings registrySettings =
 *     RegistrySettings.newBuilder().setEndpoint(myEndpoint).build();
 * RegistryClient registryClient = RegistryClient.create(registrySettings);
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
 * RegistrySettings registrySettings = RegistrySettings.newHttpJsonBuilder().build();
 * RegistryClient registryClient = RegistryClient.create(registrySettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class RegistryClient implements BackgroundResource {
  private final RegistrySettings settings;
  private final RegistryStub stub;

  /** Constructs an instance of RegistryClient with default settings. */
  public static final RegistryClient create() throws IOException {
    return create(RegistrySettings.newBuilder().build());
  }

  /**
   * Constructs an instance of RegistryClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final RegistryClient create(RegistrySettings settings) throws IOException {
    return new RegistryClient(settings);
  }

  /**
   * Constructs an instance of RegistryClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(RegistrySettings).
   */
  public static final RegistryClient create(RegistryStub stub) {
    return new RegistryClient(stub);
  }

  /**
   * Constructs an instance of RegistryClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected RegistryClient(RegistrySettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((RegistryStubSettings) settings.getStubSettings()).createStub();
  }

  protected RegistryClient(RegistryStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final RegistrySettings getSettings() {
    return settings;
  }

  public RegistryStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns matching APIs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Api element : registryClient.listApis(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of APIs. Format:
   *     `projects/&#42;/locations/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListApisPagedResponse listApis(LocationName parent) {
    ListApisRequest request =
        ListApisRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listApis(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns matching APIs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Api element : registryClient.listApis(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of APIs. Format:
   *     `projects/&#42;/locations/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListApisPagedResponse listApis(String parent) {
    ListApisRequest request = ListApisRequest.newBuilder().setParent(parent).build();
    return listApis(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns matching APIs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   ListApisRequest request =
   *       ListApisRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (Api element : registryClient.listApis(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListApisPagedResponse listApis(ListApisRequest request) {
    return listApisPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns matching APIs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   ListApisRequest request =
   *       ListApisRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<Api> future = registryClient.listApisPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Api element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListApisRequest, ListApisPagedResponse> listApisPagedCallable() {
    return stub.listApisPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns matching APIs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   ListApisRequest request =
   *       ListApisRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListApisResponse response = registryClient.listApisCallable().call(request);
   *     for (Api element : response.getApisList()) {
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
  public final UnaryCallable<ListApisRequest, ListApisResponse> listApisCallable() {
    return stub.listApisCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a specified API.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   ApiName name = ApiName.of("[PROJECT]", "[LOCATION]", "[API]");
   *   Api response = registryClient.getApi(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the API to retrieve. Format:
   *     `projects/&#42;/locations/&#42;/apis/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Api getApi(ApiName name) {
    GetApiRequest request =
        GetApiRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getApi(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a specified API.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   String name = ApiName.of("[PROJECT]", "[LOCATION]", "[API]").toString();
   *   Api response = registryClient.getApi(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the API to retrieve. Format:
   *     `projects/&#42;/locations/&#42;/apis/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Api getApi(String name) {
    GetApiRequest request = GetApiRequest.newBuilder().setName(name).build();
    return getApi(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a specified API.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   GetApiRequest request =
   *       GetApiRequest.newBuilder()
   *           .setName(ApiName.of("[PROJECT]", "[LOCATION]", "[API]").toString())
   *           .build();
   *   Api response = registryClient.getApi(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Api getApi(GetApiRequest request) {
    return getApiCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a specified API.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   GetApiRequest request =
   *       GetApiRequest.newBuilder()
   *           .setName(ApiName.of("[PROJECT]", "[LOCATION]", "[API]").toString())
   *           .build();
   *   ApiFuture<Api> future = registryClient.getApiCallable().futureCall(request);
   *   // Do something.
   *   Api response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetApiRequest, Api> getApiCallable() {
    return stub.getApiCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a specified API.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Api api = Api.newBuilder().build();
   *   String apiId = "apiId93021397";
   *   Api response = registryClient.createApi(parent, api, apiId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of APIs. Format:
   *     `projects/&#42;/locations/&#42;`
   * @param api Required. The API to create.
   * @param apiId Required. The ID to use for the API, which will become the final component of the
   *     API's resource name.
   *     <p>This value should be 4-63 characters, and valid characters are /[a-z][0-9]-/.
   *     <p>Following AIP-162, IDs must not have the form of a UUID.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Api createApi(LocationName parent, Api api, String apiId) {
    CreateApiRequest request =
        CreateApiRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setApi(api)
            .setApiId(apiId)
            .build();
    return createApi(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a specified API.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Api api = Api.newBuilder().build();
   *   String apiId = "apiId93021397";
   *   Api response = registryClient.createApi(parent, api, apiId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of APIs. Format:
   *     `projects/&#42;/locations/&#42;`
   * @param api Required. The API to create.
   * @param apiId Required. The ID to use for the API, which will become the final component of the
   *     API's resource name.
   *     <p>This value should be 4-63 characters, and valid characters are /[a-z][0-9]-/.
   *     <p>Following AIP-162, IDs must not have the form of a UUID.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Api createApi(String parent, Api api, String apiId) {
    CreateApiRequest request =
        CreateApiRequest.newBuilder().setParent(parent).setApi(api).setApiId(apiId).build();
    return createApi(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a specified API.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   CreateApiRequest request =
   *       CreateApiRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setApi(Api.newBuilder().build())
   *           .setApiId("apiId93021397")
   *           .build();
   *   Api response = registryClient.createApi(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Api createApi(CreateApiRequest request) {
    return createApiCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a specified API.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   CreateApiRequest request =
   *       CreateApiRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setApi(Api.newBuilder().build())
   *           .setApiId("apiId93021397")
   *           .build();
   *   ApiFuture<Api> future = registryClient.createApiCallable().futureCall(request);
   *   // Do something.
   *   Api response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateApiRequest, Api> createApiCallable() {
    return stub.createApiCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Used to modify a specified API.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   Api api = Api.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Api response = registryClient.updateApi(api, updateMask);
   * }
   * }</pre>
   *
   * @param api Required. The API to update.
   *     <p>The `name` field is used to identify the API to update. Format:
   *     `projects/&#42;/locations/&#42;/apis/&#42;`
   * @param updateMask The list of fields to be updated. If omitted, all fields are updated that are
   *     set in the request message (fields set to default values are ignored). If an asterisk
   *     "&#42;" is specified, all fields are updated, including fields that are unspecified/default
   *     in the request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Api updateApi(Api api, FieldMask updateMask) {
    UpdateApiRequest request =
        UpdateApiRequest.newBuilder().setApi(api).setUpdateMask(updateMask).build();
    return updateApi(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Used to modify a specified API.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   UpdateApiRequest request =
   *       UpdateApiRequest.newBuilder()
   *           .setApi(Api.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAllowMissing(true)
   *           .build();
   *   Api response = registryClient.updateApi(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Api updateApi(UpdateApiRequest request) {
    return updateApiCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Used to modify a specified API.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   UpdateApiRequest request =
   *       UpdateApiRequest.newBuilder()
   *           .setApi(Api.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAllowMissing(true)
   *           .build();
   *   ApiFuture<Api> future = registryClient.updateApiCallable().futureCall(request);
   *   // Do something.
   *   Api response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateApiRequest, Api> updateApiCallable() {
    return stub.updateApiCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes a specified API and all of the resources that it owns.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   ApiName name = ApiName.of("[PROJECT]", "[LOCATION]", "[API]");
   *   registryClient.deleteApi(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the API to delete. Format:
   *     `projects/&#42;/locations/&#42;/apis/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteApi(ApiName name) {
    DeleteApiRequest request =
        DeleteApiRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteApi(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes a specified API and all of the resources that it owns.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   String name = ApiName.of("[PROJECT]", "[LOCATION]", "[API]").toString();
   *   registryClient.deleteApi(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the API to delete. Format:
   *     `projects/&#42;/locations/&#42;/apis/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteApi(String name) {
    DeleteApiRequest request = DeleteApiRequest.newBuilder().setName(name).build();
    deleteApi(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes a specified API and all of the resources that it owns.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   DeleteApiRequest request =
   *       DeleteApiRequest.newBuilder()
   *           .setName(ApiName.of("[PROJECT]", "[LOCATION]", "[API]").toString())
   *           .setForce(true)
   *           .build();
   *   registryClient.deleteApi(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteApi(DeleteApiRequest request) {
    deleteApiCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes a specified API and all of the resources that it owns.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   DeleteApiRequest request =
   *       DeleteApiRequest.newBuilder()
   *           .setName(ApiName.of("[PROJECT]", "[LOCATION]", "[API]").toString())
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Empty> future = registryClient.deleteApiCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteApiRequest, Empty> deleteApiCallable() {
    return stub.deleteApiCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns matching versions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   ApiName parent = ApiName.of("[PROJECT]", "[LOCATION]", "[API]");
   *   for (ApiVersion element : registryClient.listApiVersions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of versions. Format:
   *     `projects/&#42;/locations/&#42;/apis/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListApiVersionsPagedResponse listApiVersions(ApiName parent) {
    ListApiVersionsRequest request =
        ListApiVersionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listApiVersions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns matching versions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   String parent = ApiName.of("[PROJECT]", "[LOCATION]", "[API]").toString();
   *   for (ApiVersion element : registryClient.listApiVersions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of versions. Format:
   *     `projects/&#42;/locations/&#42;/apis/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListApiVersionsPagedResponse listApiVersions(String parent) {
    ListApiVersionsRequest request = ListApiVersionsRequest.newBuilder().setParent(parent).build();
    return listApiVersions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns matching versions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   ListApiVersionsRequest request =
   *       ListApiVersionsRequest.newBuilder()
   *           .setParent(ApiName.of("[PROJECT]", "[LOCATION]", "[API]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (ApiVersion element : registryClient.listApiVersions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListApiVersionsPagedResponse listApiVersions(ListApiVersionsRequest request) {
    return listApiVersionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns matching versions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   ListApiVersionsRequest request =
   *       ListApiVersionsRequest.newBuilder()
   *           .setParent(ApiName.of("[PROJECT]", "[LOCATION]", "[API]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<ApiVersion> future =
   *       registryClient.listApiVersionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ApiVersion element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListApiVersionsRequest, ListApiVersionsPagedResponse>
      listApiVersionsPagedCallable() {
    return stub.listApiVersionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns matching versions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   ListApiVersionsRequest request =
   *       ListApiVersionsRequest.newBuilder()
   *           .setParent(ApiName.of("[PROJECT]", "[LOCATION]", "[API]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListApiVersionsResponse response = registryClient.listApiVersionsCallable().call(request);
   *     for (ApiVersion element : response.getApiVersionsList()) {
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
  public final UnaryCallable<ListApiVersionsRequest, ListApiVersionsResponse>
      listApiVersionsCallable() {
    return stub.listApiVersionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a specified version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   ApiVersionName name = ApiVersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]");
   *   ApiVersion response = registryClient.getApiVersion(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the version to retrieve. Format:
   *     `projects/&#42;/locations/&#42;/apis/&#42;/versions/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApiVersion getApiVersion(ApiVersionName name) {
    GetApiVersionRequest request =
        GetApiVersionRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getApiVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a specified version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   String name = ApiVersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]").toString();
   *   ApiVersion response = registryClient.getApiVersion(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the version to retrieve. Format:
   *     `projects/&#42;/locations/&#42;/apis/&#42;/versions/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApiVersion getApiVersion(String name) {
    GetApiVersionRequest request = GetApiVersionRequest.newBuilder().setName(name).build();
    return getApiVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a specified version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   GetApiVersionRequest request =
   *       GetApiVersionRequest.newBuilder()
   *           .setName(
   *               ApiVersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]").toString())
   *           .build();
   *   ApiVersion response = registryClient.getApiVersion(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApiVersion getApiVersion(GetApiVersionRequest request) {
    return getApiVersionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a specified version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   GetApiVersionRequest request =
   *       GetApiVersionRequest.newBuilder()
   *           .setName(
   *               ApiVersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]").toString())
   *           .build();
   *   ApiFuture<ApiVersion> future = registryClient.getApiVersionCallable().futureCall(request);
   *   // Do something.
   *   ApiVersion response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetApiVersionRequest, ApiVersion> getApiVersionCallable() {
    return stub.getApiVersionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a specified version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   ApiName parent = ApiName.of("[PROJECT]", "[LOCATION]", "[API]");
   *   ApiVersion apiVersion = ApiVersion.newBuilder().build();
   *   String apiVersionId = "apiVersionId1678816025";
   *   ApiVersion response = registryClient.createApiVersion(parent, apiVersion, apiVersionId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of versions. Format:
   *     `projects/&#42;/locations/&#42;/apis/&#42;`
   * @param apiVersion Required. The version to create.
   * @param apiVersionId Required. The ID to use for the version, which will become the final
   *     component of the version's resource name.
   *     <p>This value should be 1-63 characters, and valid characters are /[a-z][0-9]-/.
   *     <p>Following AIP-162, IDs must not have the form of a UUID.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApiVersion createApiVersion(
      ApiName parent, ApiVersion apiVersion, String apiVersionId) {
    CreateApiVersionRequest request =
        CreateApiVersionRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setApiVersion(apiVersion)
            .setApiVersionId(apiVersionId)
            .build();
    return createApiVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a specified version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   String parent = ApiName.of("[PROJECT]", "[LOCATION]", "[API]").toString();
   *   ApiVersion apiVersion = ApiVersion.newBuilder().build();
   *   String apiVersionId = "apiVersionId1678816025";
   *   ApiVersion response = registryClient.createApiVersion(parent, apiVersion, apiVersionId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of versions. Format:
   *     `projects/&#42;/locations/&#42;/apis/&#42;`
   * @param apiVersion Required. The version to create.
   * @param apiVersionId Required. The ID to use for the version, which will become the final
   *     component of the version's resource name.
   *     <p>This value should be 1-63 characters, and valid characters are /[a-z][0-9]-/.
   *     <p>Following AIP-162, IDs must not have the form of a UUID.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApiVersion createApiVersion(
      String parent, ApiVersion apiVersion, String apiVersionId) {
    CreateApiVersionRequest request =
        CreateApiVersionRequest.newBuilder()
            .setParent(parent)
            .setApiVersion(apiVersion)
            .setApiVersionId(apiVersionId)
            .build();
    return createApiVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a specified version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   CreateApiVersionRequest request =
   *       CreateApiVersionRequest.newBuilder()
   *           .setParent(ApiName.of("[PROJECT]", "[LOCATION]", "[API]").toString())
   *           .setApiVersion(ApiVersion.newBuilder().build())
   *           .setApiVersionId("apiVersionId1678816025")
   *           .build();
   *   ApiVersion response = registryClient.createApiVersion(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApiVersion createApiVersion(CreateApiVersionRequest request) {
    return createApiVersionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a specified version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   CreateApiVersionRequest request =
   *       CreateApiVersionRequest.newBuilder()
   *           .setParent(ApiName.of("[PROJECT]", "[LOCATION]", "[API]").toString())
   *           .setApiVersion(ApiVersion.newBuilder().build())
   *           .setApiVersionId("apiVersionId1678816025")
   *           .build();
   *   ApiFuture<ApiVersion> future = registryClient.createApiVersionCallable().futureCall(request);
   *   // Do something.
   *   ApiVersion response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateApiVersionRequest, ApiVersion> createApiVersionCallable() {
    return stub.createApiVersionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Used to modify a specified version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   ApiVersion apiVersion = ApiVersion.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   ApiVersion response = registryClient.updateApiVersion(apiVersion, updateMask);
   * }
   * }</pre>
   *
   * @param apiVersion Required. The version to update.
   *     <p>The `name` field is used to identify the version to update. Format:
   *     `projects/&#42;/locations/&#42;/apis/&#42;/versions/&#42;`
   * @param updateMask The list of fields to be updated. If omitted, all fields are updated that are
   *     set in the request message (fields set to default values are ignored). If an asterisk
   *     "&#42;" is specified, all fields are updated, including fields that are unspecified/default
   *     in the request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApiVersion updateApiVersion(ApiVersion apiVersion, FieldMask updateMask) {
    UpdateApiVersionRequest request =
        UpdateApiVersionRequest.newBuilder()
            .setApiVersion(apiVersion)
            .setUpdateMask(updateMask)
            .build();
    return updateApiVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Used to modify a specified version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   UpdateApiVersionRequest request =
   *       UpdateApiVersionRequest.newBuilder()
   *           .setApiVersion(ApiVersion.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAllowMissing(true)
   *           .build();
   *   ApiVersion response = registryClient.updateApiVersion(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApiVersion updateApiVersion(UpdateApiVersionRequest request) {
    return updateApiVersionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Used to modify a specified version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   UpdateApiVersionRequest request =
   *       UpdateApiVersionRequest.newBuilder()
   *           .setApiVersion(ApiVersion.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAllowMissing(true)
   *           .build();
   *   ApiFuture<ApiVersion> future = registryClient.updateApiVersionCallable().futureCall(request);
   *   // Do something.
   *   ApiVersion response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateApiVersionRequest, ApiVersion> updateApiVersionCallable() {
    return stub.updateApiVersionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes a specified version and all of the resources that it owns.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   ApiVersionName name = ApiVersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]");
   *   registryClient.deleteApiVersion(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the version to delete. Format:
   *     `projects/&#42;/locations/&#42;/apis/&#42;/versions/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteApiVersion(ApiVersionName name) {
    DeleteApiVersionRequest request =
        DeleteApiVersionRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteApiVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes a specified version and all of the resources that it owns.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   String name = ApiVersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]").toString();
   *   registryClient.deleteApiVersion(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the version to delete. Format:
   *     `projects/&#42;/locations/&#42;/apis/&#42;/versions/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteApiVersion(String name) {
    DeleteApiVersionRequest request = DeleteApiVersionRequest.newBuilder().setName(name).build();
    deleteApiVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes a specified version and all of the resources that it owns.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   DeleteApiVersionRequest request =
   *       DeleteApiVersionRequest.newBuilder()
   *           .setName(
   *               ApiVersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]").toString())
   *           .setForce(true)
   *           .build();
   *   registryClient.deleteApiVersion(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteApiVersion(DeleteApiVersionRequest request) {
    deleteApiVersionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes a specified version and all of the resources that it owns.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   DeleteApiVersionRequest request =
   *       DeleteApiVersionRequest.newBuilder()
   *           .setName(
   *               ApiVersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]").toString())
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Empty> future = registryClient.deleteApiVersionCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteApiVersionRequest, Empty> deleteApiVersionCallable() {
    return stub.deleteApiVersionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns matching specs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   ApiVersionName parent = ApiVersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]");
   *   for (ApiSpec element : registryClient.listApiSpecs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of specs. Format:
   *     `projects/&#42;/locations/&#42;/apis/&#42;/versions/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListApiSpecsPagedResponse listApiSpecs(ApiVersionName parent) {
    ListApiSpecsRequest request =
        ListApiSpecsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listApiSpecs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns matching specs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   String parent = ApiVersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]").toString();
   *   for (ApiSpec element : registryClient.listApiSpecs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of specs. Format:
   *     `projects/&#42;/locations/&#42;/apis/&#42;/versions/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListApiSpecsPagedResponse listApiSpecs(String parent) {
    ListApiSpecsRequest request = ListApiSpecsRequest.newBuilder().setParent(parent).build();
    return listApiSpecs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns matching specs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   ListApiSpecsRequest request =
   *       ListApiSpecsRequest.newBuilder()
   *           .setParent(
   *               ApiVersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (ApiSpec element : registryClient.listApiSpecs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListApiSpecsPagedResponse listApiSpecs(ListApiSpecsRequest request) {
    return listApiSpecsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns matching specs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   ListApiSpecsRequest request =
   *       ListApiSpecsRequest.newBuilder()
   *           .setParent(
   *               ApiVersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<ApiSpec> future = registryClient.listApiSpecsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ApiSpec element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListApiSpecsRequest, ListApiSpecsPagedResponse>
      listApiSpecsPagedCallable() {
    return stub.listApiSpecsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns matching specs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   ListApiSpecsRequest request =
   *       ListApiSpecsRequest.newBuilder()
   *           .setParent(
   *               ApiVersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListApiSpecsResponse response = registryClient.listApiSpecsCallable().call(request);
   *     for (ApiSpec element : response.getApiSpecsList()) {
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
  public final UnaryCallable<ListApiSpecsRequest, ListApiSpecsResponse> listApiSpecsCallable() {
    return stub.listApiSpecsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a specified spec.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   ApiSpecName name = ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]");
   *   ApiSpec response = registryClient.getApiSpec(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the spec to retrieve. Format:
   *     `projects/&#42;/locations/&#42;/apis/&#42;/versions/&#42;/specs/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApiSpec getApiSpec(ApiSpecName name) {
    GetApiSpecRequest request =
        GetApiSpecRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getApiSpec(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a specified spec.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   String name =
   *       ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]").toString();
   *   ApiSpec response = registryClient.getApiSpec(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the spec to retrieve. Format:
   *     `projects/&#42;/locations/&#42;/apis/&#42;/versions/&#42;/specs/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApiSpec getApiSpec(String name) {
    GetApiSpecRequest request = GetApiSpecRequest.newBuilder().setName(name).build();
    return getApiSpec(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a specified spec.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   GetApiSpecRequest request =
   *       GetApiSpecRequest.newBuilder()
   *           .setName(
   *               ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]")
   *                   .toString())
   *           .build();
   *   ApiSpec response = registryClient.getApiSpec(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApiSpec getApiSpec(GetApiSpecRequest request) {
    return getApiSpecCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a specified spec.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   GetApiSpecRequest request =
   *       GetApiSpecRequest.newBuilder()
   *           .setName(
   *               ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]")
   *                   .toString())
   *           .build();
   *   ApiFuture<ApiSpec> future = registryClient.getApiSpecCallable().futureCall(request);
   *   // Do something.
   *   ApiSpec response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetApiSpecRequest, ApiSpec> getApiSpecCallable() {
    return stub.getApiSpecCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the contents of a specified spec. If specs are stored with GZip compression, the
   * default behavior is to return the spec uncompressed (the mime_type response field indicates the
   * exact format returned).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   ApiSpecName name = ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]");
   *   HttpBody response = registryClient.getApiSpecContents(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the spec whose contents should be retrieved. Format:
   *     `projects/&#42;/locations/&#42;/apis/&#42;/versions/&#42;/specs/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HttpBody getApiSpecContents(ApiSpecName name) {
    GetApiSpecContentsRequest request =
        GetApiSpecContentsRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getApiSpecContents(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the contents of a specified spec. If specs are stored with GZip compression, the
   * default behavior is to return the spec uncompressed (the mime_type response field indicates the
   * exact format returned).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   String name =
   *       ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]").toString();
   *   HttpBody response = registryClient.getApiSpecContents(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the spec whose contents should be retrieved. Format:
   *     `projects/&#42;/locations/&#42;/apis/&#42;/versions/&#42;/specs/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HttpBody getApiSpecContents(String name) {
    GetApiSpecContentsRequest request =
        GetApiSpecContentsRequest.newBuilder().setName(name).build();
    return getApiSpecContents(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the contents of a specified spec. If specs are stored with GZip compression, the
   * default behavior is to return the spec uncompressed (the mime_type response field indicates the
   * exact format returned).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   GetApiSpecContentsRequest request =
   *       GetApiSpecContentsRequest.newBuilder()
   *           .setName(
   *               ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]")
   *                   .toString())
   *           .build();
   *   HttpBody response = registryClient.getApiSpecContents(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HttpBody getApiSpecContents(GetApiSpecContentsRequest request) {
    return getApiSpecContentsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the contents of a specified spec. If specs are stored with GZip compression, the
   * default behavior is to return the spec uncompressed (the mime_type response field indicates the
   * exact format returned).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   GetApiSpecContentsRequest request =
   *       GetApiSpecContentsRequest.newBuilder()
   *           .setName(
   *               ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]")
   *                   .toString())
   *           .build();
   *   ApiFuture<HttpBody> future = registryClient.getApiSpecContentsCallable().futureCall(request);
   *   // Do something.
   *   HttpBody response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetApiSpecContentsRequest, HttpBody> getApiSpecContentsCallable() {
    return stub.getApiSpecContentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a specified spec.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   ApiVersionName parent = ApiVersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]");
   *   ApiSpec apiSpec = ApiSpec.newBuilder().build();
   *   String apiSpecId = "apiSpecId-421795600";
   *   ApiSpec response = registryClient.createApiSpec(parent, apiSpec, apiSpecId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of specs. Format:
   *     `projects/&#42;/locations/&#42;/apis/&#42;/versions/&#42;`
   * @param apiSpec Required. The spec to create.
   * @param apiSpecId Required. The ID to use for the spec, which will become the final component of
   *     the spec's resource name.
   *     <p>This value should be 4-63 characters, and valid characters are /[a-z][0-9]-/.
   *     <p>Following AIP-162, IDs must not have the form of a UUID.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApiSpec createApiSpec(ApiVersionName parent, ApiSpec apiSpec, String apiSpecId) {
    CreateApiSpecRequest request =
        CreateApiSpecRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setApiSpec(apiSpec)
            .setApiSpecId(apiSpecId)
            .build();
    return createApiSpec(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a specified spec.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   String parent = ApiVersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]").toString();
   *   ApiSpec apiSpec = ApiSpec.newBuilder().build();
   *   String apiSpecId = "apiSpecId-421795600";
   *   ApiSpec response = registryClient.createApiSpec(parent, apiSpec, apiSpecId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of specs. Format:
   *     `projects/&#42;/locations/&#42;/apis/&#42;/versions/&#42;`
   * @param apiSpec Required. The spec to create.
   * @param apiSpecId Required. The ID to use for the spec, which will become the final component of
   *     the spec's resource name.
   *     <p>This value should be 4-63 characters, and valid characters are /[a-z][0-9]-/.
   *     <p>Following AIP-162, IDs must not have the form of a UUID.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApiSpec createApiSpec(String parent, ApiSpec apiSpec, String apiSpecId) {
    CreateApiSpecRequest request =
        CreateApiSpecRequest.newBuilder()
            .setParent(parent)
            .setApiSpec(apiSpec)
            .setApiSpecId(apiSpecId)
            .build();
    return createApiSpec(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a specified spec.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   CreateApiSpecRequest request =
   *       CreateApiSpecRequest.newBuilder()
   *           .setParent(
   *               ApiVersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]").toString())
   *           .setApiSpec(ApiSpec.newBuilder().build())
   *           .setApiSpecId("apiSpecId-421795600")
   *           .build();
   *   ApiSpec response = registryClient.createApiSpec(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApiSpec createApiSpec(CreateApiSpecRequest request) {
    return createApiSpecCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a specified spec.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   CreateApiSpecRequest request =
   *       CreateApiSpecRequest.newBuilder()
   *           .setParent(
   *               ApiVersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]").toString())
   *           .setApiSpec(ApiSpec.newBuilder().build())
   *           .setApiSpecId("apiSpecId-421795600")
   *           .build();
   *   ApiFuture<ApiSpec> future = registryClient.createApiSpecCallable().futureCall(request);
   *   // Do something.
   *   ApiSpec response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateApiSpecRequest, ApiSpec> createApiSpecCallable() {
    return stub.createApiSpecCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Used to modify a specified spec.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   ApiSpec apiSpec = ApiSpec.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   ApiSpec response = registryClient.updateApiSpec(apiSpec, updateMask);
   * }
   * }</pre>
   *
   * @param apiSpec Required. The spec to update.
   *     <p>The `name` field is used to identify the spec to update. Format:
   *     `projects/&#42;/locations/&#42;/apis/&#42;/versions/&#42;/specs/&#42;`
   * @param updateMask The list of fields to be updated. If omitted, all fields are updated that are
   *     set in the request message (fields set to default values are ignored). If an asterisk
   *     "&#42;" is specified, all fields are updated, including fields that are unspecified/default
   *     in the request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApiSpec updateApiSpec(ApiSpec apiSpec, FieldMask updateMask) {
    UpdateApiSpecRequest request =
        UpdateApiSpecRequest.newBuilder().setApiSpec(apiSpec).setUpdateMask(updateMask).build();
    return updateApiSpec(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Used to modify a specified spec.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   UpdateApiSpecRequest request =
   *       UpdateApiSpecRequest.newBuilder()
   *           .setApiSpec(ApiSpec.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAllowMissing(true)
   *           .build();
   *   ApiSpec response = registryClient.updateApiSpec(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApiSpec updateApiSpec(UpdateApiSpecRequest request) {
    return updateApiSpecCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Used to modify a specified spec.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   UpdateApiSpecRequest request =
   *       UpdateApiSpecRequest.newBuilder()
   *           .setApiSpec(ApiSpec.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAllowMissing(true)
   *           .build();
   *   ApiFuture<ApiSpec> future = registryClient.updateApiSpecCallable().futureCall(request);
   *   // Do something.
   *   ApiSpec response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateApiSpecRequest, ApiSpec> updateApiSpecCallable() {
    return stub.updateApiSpecCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes a specified spec, all revisions, and all child resources (e.g., artifacts).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   ApiSpecName name = ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]");
   *   registryClient.deleteApiSpec(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the spec to delete. Format:
   *     `projects/&#42;/locations/&#42;/apis/&#42;/versions/&#42;/specs/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteApiSpec(ApiSpecName name) {
    DeleteApiSpecRequest request =
        DeleteApiSpecRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteApiSpec(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes a specified spec, all revisions, and all child resources (e.g., artifacts).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   String name =
   *       ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]").toString();
   *   registryClient.deleteApiSpec(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the spec to delete. Format:
   *     `projects/&#42;/locations/&#42;/apis/&#42;/versions/&#42;/specs/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteApiSpec(String name) {
    DeleteApiSpecRequest request = DeleteApiSpecRequest.newBuilder().setName(name).build();
    deleteApiSpec(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes a specified spec, all revisions, and all child resources (e.g., artifacts).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   DeleteApiSpecRequest request =
   *       DeleteApiSpecRequest.newBuilder()
   *           .setName(
   *               ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]")
   *                   .toString())
   *           .setForce(true)
   *           .build();
   *   registryClient.deleteApiSpec(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteApiSpec(DeleteApiSpecRequest request) {
    deleteApiSpecCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes a specified spec, all revisions, and all child resources (e.g., artifacts).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   DeleteApiSpecRequest request =
   *       DeleteApiSpecRequest.newBuilder()
   *           .setName(
   *               ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]")
   *                   .toString())
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Empty> future = registryClient.deleteApiSpecCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteApiSpecRequest, Empty> deleteApiSpecCallable() {
    return stub.deleteApiSpecCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a tag to a specified revision of a spec.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   TagApiSpecRevisionRequest request =
   *       TagApiSpecRevisionRequest.newBuilder()
   *           .setName(
   *               ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]")
   *                   .toString())
   *           .setTag("tag114586")
   *           .build();
   *   ApiSpec response = registryClient.tagApiSpecRevision(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApiSpec tagApiSpecRevision(TagApiSpecRevisionRequest request) {
    return tagApiSpecRevisionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a tag to a specified revision of a spec.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   TagApiSpecRevisionRequest request =
   *       TagApiSpecRevisionRequest.newBuilder()
   *           .setName(
   *               ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]")
   *                   .toString())
   *           .setTag("tag114586")
   *           .build();
   *   ApiFuture<ApiSpec> future = registryClient.tagApiSpecRevisionCallable().futureCall(request);
   *   // Do something.
   *   ApiSpec response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TagApiSpecRevisionRequest, ApiSpec> tagApiSpecRevisionCallable() {
    return stub.tagApiSpecRevisionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all revisions of a spec. Revisions are returned in descending order of revision creation
   * time.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   ListApiSpecRevisionsRequest request =
   *       ListApiSpecRevisionsRequest.newBuilder()
   *           .setName(
   *               ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (ApiSpec element : registryClient.listApiSpecRevisions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListApiSpecRevisionsPagedResponse listApiSpecRevisions(
      ListApiSpecRevisionsRequest request) {
    return listApiSpecRevisionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all revisions of a spec. Revisions are returned in descending order of revision creation
   * time.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   ListApiSpecRevisionsRequest request =
   *       ListApiSpecRevisionsRequest.newBuilder()
   *           .setName(
   *               ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<ApiSpec> future =
   *       registryClient.listApiSpecRevisionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ApiSpec element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListApiSpecRevisionsRequest, ListApiSpecRevisionsPagedResponse>
      listApiSpecRevisionsPagedCallable() {
    return stub.listApiSpecRevisionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all revisions of a spec. Revisions are returned in descending order of revision creation
   * time.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   ListApiSpecRevisionsRequest request =
   *       ListApiSpecRevisionsRequest.newBuilder()
   *           .setName(
   *               ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListApiSpecRevisionsResponse response =
   *         registryClient.listApiSpecRevisionsCallable().call(request);
   *     for (ApiSpec element : response.getApiSpecsList()) {
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
  public final UnaryCallable<ListApiSpecRevisionsRequest, ListApiSpecRevisionsResponse>
      listApiSpecRevisionsCallable() {
    return stub.listApiSpecRevisionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the current revision to a specified prior revision. Note that this creates a new revision
   * with a new revision ID.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   RollbackApiSpecRequest request =
   *       RollbackApiSpecRequest.newBuilder()
   *           .setName(
   *               ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]")
   *                   .toString())
   *           .setRevisionId("revisionId-1507445162")
   *           .build();
   *   ApiSpec response = registryClient.rollbackApiSpec(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApiSpec rollbackApiSpec(RollbackApiSpecRequest request) {
    return rollbackApiSpecCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the current revision to a specified prior revision. Note that this creates a new revision
   * with a new revision ID.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   RollbackApiSpecRequest request =
   *       RollbackApiSpecRequest.newBuilder()
   *           .setName(
   *               ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]")
   *                   .toString())
   *           .setRevisionId("revisionId-1507445162")
   *           .build();
   *   ApiFuture<ApiSpec> future = registryClient.rollbackApiSpecCallable().futureCall(request);
   *   // Do something.
   *   ApiSpec response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RollbackApiSpecRequest, ApiSpec> rollbackApiSpecCallable() {
    return stub.rollbackApiSpecCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a revision of a spec.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   ApiSpecName name = ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]");
   *   ApiSpec response = registryClient.deleteApiSpecRevision(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the spec revision to be deleted, with a revision ID
   *     explicitly included.
   *     <p>Example:
   *     `projects/sample/locations/global/apis/petstore/versions/1.0.0/specs/openapi.yaml{@literal @}c7cfa2a8`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApiSpec deleteApiSpecRevision(ApiSpecName name) {
    DeleteApiSpecRevisionRequest request =
        DeleteApiSpecRevisionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteApiSpecRevision(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a revision of a spec.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   String name =
   *       ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]").toString();
   *   ApiSpec response = registryClient.deleteApiSpecRevision(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the spec revision to be deleted, with a revision ID
   *     explicitly included.
   *     <p>Example:
   *     `projects/sample/locations/global/apis/petstore/versions/1.0.0/specs/openapi.yaml{@literal @}c7cfa2a8`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApiSpec deleteApiSpecRevision(String name) {
    DeleteApiSpecRevisionRequest request =
        DeleteApiSpecRevisionRequest.newBuilder().setName(name).build();
    return deleteApiSpecRevision(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a revision of a spec.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   DeleteApiSpecRevisionRequest request =
   *       DeleteApiSpecRevisionRequest.newBuilder()
   *           .setName(
   *               ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]")
   *                   .toString())
   *           .build();
   *   ApiSpec response = registryClient.deleteApiSpecRevision(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApiSpec deleteApiSpecRevision(DeleteApiSpecRevisionRequest request) {
    return deleteApiSpecRevisionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a revision of a spec.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   DeleteApiSpecRevisionRequest request =
   *       DeleteApiSpecRevisionRequest.newBuilder()
   *           .setName(
   *               ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]")
   *                   .toString())
   *           .build();
   *   ApiFuture<ApiSpec> future =
   *       registryClient.deleteApiSpecRevisionCallable().futureCall(request);
   *   // Do something.
   *   ApiSpec response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteApiSpecRevisionRequest, ApiSpec>
      deleteApiSpecRevisionCallable() {
    return stub.deleteApiSpecRevisionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns matching deployments.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   ApiName parent = ApiName.of("[PROJECT]", "[LOCATION]", "[API]");
   *   for (ApiDeployment element : registryClient.listApiDeployments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of deployments. Format:
   *     `projects/&#42;/locations/&#42;/apis/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListApiDeploymentsPagedResponse listApiDeployments(ApiName parent) {
    ListApiDeploymentsRequest request =
        ListApiDeploymentsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listApiDeployments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns matching deployments.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   String parent = ApiName.of("[PROJECT]", "[LOCATION]", "[API]").toString();
   *   for (ApiDeployment element : registryClient.listApiDeployments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of deployments. Format:
   *     `projects/&#42;/locations/&#42;/apis/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListApiDeploymentsPagedResponse listApiDeployments(String parent) {
    ListApiDeploymentsRequest request =
        ListApiDeploymentsRequest.newBuilder().setParent(parent).build();
    return listApiDeployments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns matching deployments.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   ListApiDeploymentsRequest request =
   *       ListApiDeploymentsRequest.newBuilder()
   *           .setParent(ApiName.of("[PROJECT]", "[LOCATION]", "[API]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (ApiDeployment element : registryClient.listApiDeployments(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListApiDeploymentsPagedResponse listApiDeployments(
      ListApiDeploymentsRequest request) {
    return listApiDeploymentsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns matching deployments.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   ListApiDeploymentsRequest request =
   *       ListApiDeploymentsRequest.newBuilder()
   *           .setParent(ApiName.of("[PROJECT]", "[LOCATION]", "[API]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<ApiDeployment> future =
   *       registryClient.listApiDeploymentsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ApiDeployment element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListApiDeploymentsRequest, ListApiDeploymentsPagedResponse>
      listApiDeploymentsPagedCallable() {
    return stub.listApiDeploymentsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns matching deployments.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   ListApiDeploymentsRequest request =
   *       ListApiDeploymentsRequest.newBuilder()
   *           .setParent(ApiName.of("[PROJECT]", "[LOCATION]", "[API]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListApiDeploymentsResponse response =
   *         registryClient.listApiDeploymentsCallable().call(request);
   *     for (ApiDeployment element : response.getApiDeploymentsList()) {
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
  public final UnaryCallable<ListApiDeploymentsRequest, ListApiDeploymentsResponse>
      listApiDeploymentsCallable() {
    return stub.listApiDeploymentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a specified deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   ApiDeploymentName name =
   *       ApiDeploymentName.of("[PROJECT]", "[LOCATION]", "[API]", "[DEPLOYMENT]");
   *   ApiDeployment response = registryClient.getApiDeployment(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the deployment to retrieve. Format:
   *     `projects/&#42;/locations/&#42;/apis/&#42;/deployments/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApiDeployment getApiDeployment(ApiDeploymentName name) {
    GetApiDeploymentRequest request =
        GetApiDeploymentRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getApiDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a specified deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   String name =
   *       ApiDeploymentName.of("[PROJECT]", "[LOCATION]", "[API]", "[DEPLOYMENT]").toString();
   *   ApiDeployment response = registryClient.getApiDeployment(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the deployment to retrieve. Format:
   *     `projects/&#42;/locations/&#42;/apis/&#42;/deployments/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApiDeployment getApiDeployment(String name) {
    GetApiDeploymentRequest request = GetApiDeploymentRequest.newBuilder().setName(name).build();
    return getApiDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a specified deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   GetApiDeploymentRequest request =
   *       GetApiDeploymentRequest.newBuilder()
   *           .setName(
   *               ApiDeploymentName.of("[PROJECT]", "[LOCATION]", "[API]", "[DEPLOYMENT]")
   *                   .toString())
   *           .build();
   *   ApiDeployment response = registryClient.getApiDeployment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApiDeployment getApiDeployment(GetApiDeploymentRequest request) {
    return getApiDeploymentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a specified deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   GetApiDeploymentRequest request =
   *       GetApiDeploymentRequest.newBuilder()
   *           .setName(
   *               ApiDeploymentName.of("[PROJECT]", "[LOCATION]", "[API]", "[DEPLOYMENT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<ApiDeployment> future =
   *       registryClient.getApiDeploymentCallable().futureCall(request);
   *   // Do something.
   *   ApiDeployment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetApiDeploymentRequest, ApiDeployment> getApiDeploymentCallable() {
    return stub.getApiDeploymentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a specified deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   ApiName parent = ApiName.of("[PROJECT]", "[LOCATION]", "[API]");
   *   ApiDeployment apiDeployment = ApiDeployment.newBuilder().build();
   *   String apiDeploymentId = "apiDeploymentId-1299472902";
   *   ApiDeployment response =
   *       registryClient.createApiDeployment(parent, apiDeployment, apiDeploymentId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of deployments. Format:
   *     `projects/&#42;/locations/&#42;/apis/&#42;`
   * @param apiDeployment Required. The deployment to create.
   * @param apiDeploymentId Required. The ID to use for the deployment, which will become the final
   *     component of the deployment's resource name.
   *     <p>This value should be 4-63 characters, and valid characters are /[a-z][0-9]-/.
   *     <p>Following AIP-162, IDs must not have the form of a UUID.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApiDeployment createApiDeployment(
      ApiName parent, ApiDeployment apiDeployment, String apiDeploymentId) {
    CreateApiDeploymentRequest request =
        CreateApiDeploymentRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setApiDeployment(apiDeployment)
            .setApiDeploymentId(apiDeploymentId)
            .build();
    return createApiDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a specified deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   String parent = ApiName.of("[PROJECT]", "[LOCATION]", "[API]").toString();
   *   ApiDeployment apiDeployment = ApiDeployment.newBuilder().build();
   *   String apiDeploymentId = "apiDeploymentId-1299472902";
   *   ApiDeployment response =
   *       registryClient.createApiDeployment(parent, apiDeployment, apiDeploymentId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of deployments. Format:
   *     `projects/&#42;/locations/&#42;/apis/&#42;`
   * @param apiDeployment Required. The deployment to create.
   * @param apiDeploymentId Required. The ID to use for the deployment, which will become the final
   *     component of the deployment's resource name.
   *     <p>This value should be 4-63 characters, and valid characters are /[a-z][0-9]-/.
   *     <p>Following AIP-162, IDs must not have the form of a UUID.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApiDeployment createApiDeployment(
      String parent, ApiDeployment apiDeployment, String apiDeploymentId) {
    CreateApiDeploymentRequest request =
        CreateApiDeploymentRequest.newBuilder()
            .setParent(parent)
            .setApiDeployment(apiDeployment)
            .setApiDeploymentId(apiDeploymentId)
            .build();
    return createApiDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a specified deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   CreateApiDeploymentRequest request =
   *       CreateApiDeploymentRequest.newBuilder()
   *           .setParent(ApiName.of("[PROJECT]", "[LOCATION]", "[API]").toString())
   *           .setApiDeployment(ApiDeployment.newBuilder().build())
   *           .setApiDeploymentId("apiDeploymentId-1299472902")
   *           .build();
   *   ApiDeployment response = registryClient.createApiDeployment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApiDeployment createApiDeployment(CreateApiDeploymentRequest request) {
    return createApiDeploymentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a specified deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   CreateApiDeploymentRequest request =
   *       CreateApiDeploymentRequest.newBuilder()
   *           .setParent(ApiName.of("[PROJECT]", "[LOCATION]", "[API]").toString())
   *           .setApiDeployment(ApiDeployment.newBuilder().build())
   *           .setApiDeploymentId("apiDeploymentId-1299472902")
   *           .build();
   *   ApiFuture<ApiDeployment> future =
   *       registryClient.createApiDeploymentCallable().futureCall(request);
   *   // Do something.
   *   ApiDeployment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateApiDeploymentRequest, ApiDeployment>
      createApiDeploymentCallable() {
    return stub.createApiDeploymentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Used to modify a specified deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   ApiDeployment apiDeployment = ApiDeployment.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   ApiDeployment response = registryClient.updateApiDeployment(apiDeployment, updateMask);
   * }
   * }</pre>
   *
   * @param apiDeployment Required. The deployment to update.
   *     <p>The `name` field is used to identify the deployment to update. Format:
   *     `projects/&#42;/locations/&#42;/apis/&#42;/deployments/&#42;`
   * @param updateMask The list of fields to be updated. If omitted, all fields are updated that are
   *     set in the request message (fields set to default values are ignored). If an asterisk
   *     "&#42;" is specified, all fields are updated, including fields that are unspecified/default
   *     in the request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApiDeployment updateApiDeployment(
      ApiDeployment apiDeployment, FieldMask updateMask) {
    UpdateApiDeploymentRequest request =
        UpdateApiDeploymentRequest.newBuilder()
            .setApiDeployment(apiDeployment)
            .setUpdateMask(updateMask)
            .build();
    return updateApiDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Used to modify a specified deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   UpdateApiDeploymentRequest request =
   *       UpdateApiDeploymentRequest.newBuilder()
   *           .setApiDeployment(ApiDeployment.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAllowMissing(true)
   *           .build();
   *   ApiDeployment response = registryClient.updateApiDeployment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApiDeployment updateApiDeployment(UpdateApiDeploymentRequest request) {
    return updateApiDeploymentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Used to modify a specified deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   UpdateApiDeploymentRequest request =
   *       UpdateApiDeploymentRequest.newBuilder()
   *           .setApiDeployment(ApiDeployment.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAllowMissing(true)
   *           .build();
   *   ApiFuture<ApiDeployment> future =
   *       registryClient.updateApiDeploymentCallable().futureCall(request);
   *   // Do something.
   *   ApiDeployment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateApiDeploymentRequest, ApiDeployment>
      updateApiDeploymentCallable() {
    return stub.updateApiDeploymentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes a specified deployment, all revisions, and all child resources (e.g., artifacts).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   ApiDeploymentName name =
   *       ApiDeploymentName.of("[PROJECT]", "[LOCATION]", "[API]", "[DEPLOYMENT]");
   *   registryClient.deleteApiDeployment(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the deployment to delete. Format:
   *     `projects/&#42;/locations/&#42;/apis/&#42;/deployments/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteApiDeployment(ApiDeploymentName name) {
    DeleteApiDeploymentRequest request =
        DeleteApiDeploymentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteApiDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes a specified deployment, all revisions, and all child resources (e.g., artifacts).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   String name =
   *       ApiDeploymentName.of("[PROJECT]", "[LOCATION]", "[API]", "[DEPLOYMENT]").toString();
   *   registryClient.deleteApiDeployment(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the deployment to delete. Format:
   *     `projects/&#42;/locations/&#42;/apis/&#42;/deployments/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteApiDeployment(String name) {
    DeleteApiDeploymentRequest request =
        DeleteApiDeploymentRequest.newBuilder().setName(name).build();
    deleteApiDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes a specified deployment, all revisions, and all child resources (e.g., artifacts).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   DeleteApiDeploymentRequest request =
   *       DeleteApiDeploymentRequest.newBuilder()
   *           .setName(
   *               ApiDeploymentName.of("[PROJECT]", "[LOCATION]", "[API]", "[DEPLOYMENT]")
   *                   .toString())
   *           .setForce(true)
   *           .build();
   *   registryClient.deleteApiDeployment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteApiDeployment(DeleteApiDeploymentRequest request) {
    deleteApiDeploymentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes a specified deployment, all revisions, and all child resources (e.g., artifacts).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   DeleteApiDeploymentRequest request =
   *       DeleteApiDeploymentRequest.newBuilder()
   *           .setName(
   *               ApiDeploymentName.of("[PROJECT]", "[LOCATION]", "[API]", "[DEPLOYMENT]")
   *                   .toString())
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Empty> future = registryClient.deleteApiDeploymentCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteApiDeploymentRequest, Empty> deleteApiDeploymentCallable() {
    return stub.deleteApiDeploymentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a tag to a specified revision of a deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   TagApiDeploymentRevisionRequest request =
   *       TagApiDeploymentRevisionRequest.newBuilder()
   *           .setName(
   *               ApiDeploymentName.of("[PROJECT]", "[LOCATION]", "[API]", "[DEPLOYMENT]")
   *                   .toString())
   *           .setTag("tag114586")
   *           .build();
   *   ApiDeployment response = registryClient.tagApiDeploymentRevision(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApiDeployment tagApiDeploymentRevision(TagApiDeploymentRevisionRequest request) {
    return tagApiDeploymentRevisionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a tag to a specified revision of a deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   TagApiDeploymentRevisionRequest request =
   *       TagApiDeploymentRevisionRequest.newBuilder()
   *           .setName(
   *               ApiDeploymentName.of("[PROJECT]", "[LOCATION]", "[API]", "[DEPLOYMENT]")
   *                   .toString())
   *           .setTag("tag114586")
   *           .build();
   *   ApiFuture<ApiDeployment> future =
   *       registryClient.tagApiDeploymentRevisionCallable().futureCall(request);
   *   // Do something.
   *   ApiDeployment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TagApiDeploymentRevisionRequest, ApiDeployment>
      tagApiDeploymentRevisionCallable() {
    return stub.tagApiDeploymentRevisionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all revisions of a deployment. Revisions are returned in descending order of revision
   * creation time.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   ListApiDeploymentRevisionsRequest request =
   *       ListApiDeploymentRevisionsRequest.newBuilder()
   *           .setName(
   *               ApiDeploymentName.of("[PROJECT]", "[LOCATION]", "[API]", "[DEPLOYMENT]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (ApiDeployment element :
   *       registryClient.listApiDeploymentRevisions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListApiDeploymentRevisionsPagedResponse listApiDeploymentRevisions(
      ListApiDeploymentRevisionsRequest request) {
    return listApiDeploymentRevisionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all revisions of a deployment. Revisions are returned in descending order of revision
   * creation time.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   ListApiDeploymentRevisionsRequest request =
   *       ListApiDeploymentRevisionsRequest.newBuilder()
   *           .setName(
   *               ApiDeploymentName.of("[PROJECT]", "[LOCATION]", "[API]", "[DEPLOYMENT]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<ApiDeployment> future =
   *       registryClient.listApiDeploymentRevisionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ApiDeployment element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListApiDeploymentRevisionsRequest, ListApiDeploymentRevisionsPagedResponse>
      listApiDeploymentRevisionsPagedCallable() {
    return stub.listApiDeploymentRevisionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all revisions of a deployment. Revisions are returned in descending order of revision
   * creation time.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   ListApiDeploymentRevisionsRequest request =
   *       ListApiDeploymentRevisionsRequest.newBuilder()
   *           .setName(
   *               ApiDeploymentName.of("[PROJECT]", "[LOCATION]", "[API]", "[DEPLOYMENT]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListApiDeploymentRevisionsResponse response =
   *         registryClient.listApiDeploymentRevisionsCallable().call(request);
   *     for (ApiDeployment element : response.getApiDeploymentsList()) {
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
  public final UnaryCallable<ListApiDeploymentRevisionsRequest, ListApiDeploymentRevisionsResponse>
      listApiDeploymentRevisionsCallable() {
    return stub.listApiDeploymentRevisionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the current revision to a specified prior revision. Note that this creates a new revision
   * with a new revision ID.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   RollbackApiDeploymentRequest request =
   *       RollbackApiDeploymentRequest.newBuilder()
   *           .setName(
   *               ApiDeploymentName.of("[PROJECT]", "[LOCATION]", "[API]", "[DEPLOYMENT]")
   *                   .toString())
   *           .setRevisionId("revisionId-1507445162")
   *           .build();
   *   ApiDeployment response = registryClient.rollbackApiDeployment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApiDeployment rollbackApiDeployment(RollbackApiDeploymentRequest request) {
    return rollbackApiDeploymentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the current revision to a specified prior revision. Note that this creates a new revision
   * with a new revision ID.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   RollbackApiDeploymentRequest request =
   *       RollbackApiDeploymentRequest.newBuilder()
   *           .setName(
   *               ApiDeploymentName.of("[PROJECT]", "[LOCATION]", "[API]", "[DEPLOYMENT]")
   *                   .toString())
   *           .setRevisionId("revisionId-1507445162")
   *           .build();
   *   ApiFuture<ApiDeployment> future =
   *       registryClient.rollbackApiDeploymentCallable().futureCall(request);
   *   // Do something.
   *   ApiDeployment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RollbackApiDeploymentRequest, ApiDeployment>
      rollbackApiDeploymentCallable() {
    return stub.rollbackApiDeploymentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a revision of a deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   ApiDeploymentName name =
   *       ApiDeploymentName.of("[PROJECT]", "[LOCATION]", "[API]", "[DEPLOYMENT]");
   *   ApiDeployment response = registryClient.deleteApiDeploymentRevision(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the deployment revision to be deleted, with a revision ID
   *     explicitly included.
   *     <p>Example:
   *     `projects/sample/locations/global/apis/petstore/deployments/prod{@literal @}c7cfa2a8`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApiDeployment deleteApiDeploymentRevision(ApiDeploymentName name) {
    DeleteApiDeploymentRevisionRequest request =
        DeleteApiDeploymentRevisionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteApiDeploymentRevision(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a revision of a deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   String name =
   *       ApiDeploymentName.of("[PROJECT]", "[LOCATION]", "[API]", "[DEPLOYMENT]").toString();
   *   ApiDeployment response = registryClient.deleteApiDeploymentRevision(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the deployment revision to be deleted, with a revision ID
   *     explicitly included.
   *     <p>Example:
   *     `projects/sample/locations/global/apis/petstore/deployments/prod{@literal @}c7cfa2a8`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApiDeployment deleteApiDeploymentRevision(String name) {
    DeleteApiDeploymentRevisionRequest request =
        DeleteApiDeploymentRevisionRequest.newBuilder().setName(name).build();
    return deleteApiDeploymentRevision(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a revision of a deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   DeleteApiDeploymentRevisionRequest request =
   *       DeleteApiDeploymentRevisionRequest.newBuilder()
   *           .setName(
   *               ApiDeploymentName.of("[PROJECT]", "[LOCATION]", "[API]", "[DEPLOYMENT]")
   *                   .toString())
   *           .build();
   *   ApiDeployment response = registryClient.deleteApiDeploymentRevision(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApiDeployment deleteApiDeploymentRevision(
      DeleteApiDeploymentRevisionRequest request) {
    return deleteApiDeploymentRevisionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a revision of a deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   DeleteApiDeploymentRevisionRequest request =
   *       DeleteApiDeploymentRevisionRequest.newBuilder()
   *           .setName(
   *               ApiDeploymentName.of("[PROJECT]", "[LOCATION]", "[API]", "[DEPLOYMENT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<ApiDeployment> future =
   *       registryClient.deleteApiDeploymentRevisionCallable().futureCall(request);
   *   // Do something.
   *   ApiDeployment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteApiDeploymentRevisionRequest, ApiDeployment>
      deleteApiDeploymentRevisionCallable() {
    return stub.deleteApiDeploymentRevisionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns matching artifacts.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   ApiDeploymentName parent =
   *       ApiDeploymentName.of("[PROJECT]", "[LOCATION]", "[API]", "[DEPLOYMENT]");
   *   for (Artifact element : registryClient.listArtifacts(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of artifacts. Format: `{parent}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListArtifactsPagedResponse listArtifacts(ApiDeploymentName parent) {
    ListArtifactsRequest request =
        ListArtifactsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listArtifacts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns matching artifacts.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   ApiName parent = ApiName.of("[PROJECT]", "[LOCATION]", "[API]");
   *   for (Artifact element : registryClient.listArtifacts(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of artifacts. Format: `{parent}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListArtifactsPagedResponse listArtifacts(ApiName parent) {
    ListArtifactsRequest request =
        ListArtifactsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listArtifacts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns matching artifacts.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   ApiSpecName parent =
   *       ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]");
   *   for (Artifact element : registryClient.listArtifacts(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of artifacts. Format: `{parent}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListArtifactsPagedResponse listArtifacts(ApiSpecName parent) {
    ListArtifactsRequest request =
        ListArtifactsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listArtifacts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns matching artifacts.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   ApiVersionName parent = ApiVersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]");
   *   for (Artifact element : registryClient.listArtifacts(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of artifacts. Format: `{parent}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListArtifactsPagedResponse listArtifacts(ApiVersionName parent) {
    ListArtifactsRequest request =
        ListArtifactsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listArtifacts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns matching artifacts.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Artifact element : registryClient.listArtifacts(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of artifacts. Format: `{parent}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListArtifactsPagedResponse listArtifacts(LocationName parent) {
    ListArtifactsRequest request =
        ListArtifactsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listArtifacts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns matching artifacts.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Artifact element : registryClient.listArtifacts(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of artifacts. Format: `{parent}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListArtifactsPagedResponse listArtifacts(String parent) {
    ListArtifactsRequest request = ListArtifactsRequest.newBuilder().setParent(parent).build();
    return listArtifacts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns matching artifacts.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   ListArtifactsRequest request =
   *       ListArtifactsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (Artifact element : registryClient.listArtifacts(request).iterateAll()) {
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
   * Returns matching artifacts.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   ListArtifactsRequest request =
   *       ListArtifactsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<Artifact> future = registryClient.listArtifactsPagedCallable().futureCall(request);
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
   * Returns matching artifacts.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   ListArtifactsRequest request =
   *       ListArtifactsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListArtifactsResponse response = registryClient.listArtifactsCallable().call(request);
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
   * Returns a specified artifact.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   ArtifactName name =
   *       ArtifactName.ofProjectLocationArtifactName("[PROJECT]", "[LOCATION]", "[ARTIFACT]");
   *   Artifact response = registryClient.getArtifact(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the artifact to retrieve. Format: `{parent}/artifacts/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Artifact getArtifact(ArtifactName name) {
    GetArtifactRequest request =
        GetArtifactRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getArtifact(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a specified artifact.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   String name =
   *       ArtifactName.ofProjectLocationArtifactName("[PROJECT]", "[LOCATION]", "[ARTIFACT]")
   *           .toString();
   *   Artifact response = registryClient.getArtifact(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the artifact to retrieve. Format: `{parent}/artifacts/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Artifact getArtifact(String name) {
    GetArtifactRequest request = GetArtifactRequest.newBuilder().setName(name).build();
    return getArtifact(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a specified artifact.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   GetArtifactRequest request =
   *       GetArtifactRequest.newBuilder()
   *           .setName(
   *               ArtifactName.ofProjectLocationArtifactName(
   *                       "[PROJECT]", "[LOCATION]", "[ARTIFACT]")
   *                   .toString())
   *           .build();
   *   Artifact response = registryClient.getArtifact(request);
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
   * Returns a specified artifact.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   GetArtifactRequest request =
   *       GetArtifactRequest.newBuilder()
   *           .setName(
   *               ArtifactName.ofProjectLocationArtifactName(
   *                       "[PROJECT]", "[LOCATION]", "[ARTIFACT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Artifact> future = registryClient.getArtifactCallable().futureCall(request);
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
   * Returns the contents of a specified artifact. If artifacts are stored with GZip compression,
   * the default behavior is to return the artifact uncompressed (the mime_type response field
   * indicates the exact format returned).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   ArtifactName name =
   *       ArtifactName.ofProjectLocationArtifactName("[PROJECT]", "[LOCATION]", "[ARTIFACT]");
   *   HttpBody response = registryClient.getArtifactContents(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the artifact whose contents should be retrieved. Format:
   *     `{parent}/artifacts/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HttpBody getArtifactContents(ArtifactName name) {
    GetArtifactContentsRequest request =
        GetArtifactContentsRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getArtifactContents(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the contents of a specified artifact. If artifacts are stored with GZip compression,
   * the default behavior is to return the artifact uncompressed (the mime_type response field
   * indicates the exact format returned).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   String name =
   *       ArtifactName.ofProjectLocationArtifactName("[PROJECT]", "[LOCATION]", "[ARTIFACT]")
   *           .toString();
   *   HttpBody response = registryClient.getArtifactContents(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the artifact whose contents should be retrieved. Format:
   *     `{parent}/artifacts/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HttpBody getArtifactContents(String name) {
    GetArtifactContentsRequest request =
        GetArtifactContentsRequest.newBuilder().setName(name).build();
    return getArtifactContents(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the contents of a specified artifact. If artifacts are stored with GZip compression,
   * the default behavior is to return the artifact uncompressed (the mime_type response field
   * indicates the exact format returned).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   GetArtifactContentsRequest request =
   *       GetArtifactContentsRequest.newBuilder()
   *           .setName(
   *               ArtifactName.ofProjectLocationArtifactName(
   *                       "[PROJECT]", "[LOCATION]", "[ARTIFACT]")
   *                   .toString())
   *           .build();
   *   HttpBody response = registryClient.getArtifactContents(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HttpBody getArtifactContents(GetArtifactContentsRequest request) {
    return getArtifactContentsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the contents of a specified artifact. If artifacts are stored with GZip compression,
   * the default behavior is to return the artifact uncompressed (the mime_type response field
   * indicates the exact format returned).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   GetArtifactContentsRequest request =
   *       GetArtifactContentsRequest.newBuilder()
   *           .setName(
   *               ArtifactName.ofProjectLocationArtifactName(
   *                       "[PROJECT]", "[LOCATION]", "[ARTIFACT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<HttpBody> future = registryClient.getArtifactContentsCallable().futureCall(request);
   *   // Do something.
   *   HttpBody response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetArtifactContentsRequest, HttpBody> getArtifactContentsCallable() {
    return stub.getArtifactContentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a specified artifact.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   ApiDeploymentName parent =
   *       ApiDeploymentName.of("[PROJECT]", "[LOCATION]", "[API]", "[DEPLOYMENT]");
   *   Artifact artifact = Artifact.newBuilder().build();
   *   String artifactId = "artifactId240640653";
   *   Artifact response = registryClient.createArtifact(parent, artifact, artifactId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of artifacts. Format: `{parent}`
   * @param artifact Required. The artifact to create.
   * @param artifactId Required. The ID to use for the artifact, which will become the final
   *     component of the artifact's resource name.
   *     <p>This value should be 4-63 characters, and valid characters are /[a-z][0-9]-/.
   *     <p>Following AIP-162, IDs must not have the form of a UUID.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Artifact createArtifact(
      ApiDeploymentName parent, Artifact artifact, String artifactId) {
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
   * Creates a specified artifact.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   ApiName parent = ApiName.of("[PROJECT]", "[LOCATION]", "[API]");
   *   Artifact artifact = Artifact.newBuilder().build();
   *   String artifactId = "artifactId240640653";
   *   Artifact response = registryClient.createArtifact(parent, artifact, artifactId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of artifacts. Format: `{parent}`
   * @param artifact Required. The artifact to create.
   * @param artifactId Required. The ID to use for the artifact, which will become the final
   *     component of the artifact's resource name.
   *     <p>This value should be 4-63 characters, and valid characters are /[a-z][0-9]-/.
   *     <p>Following AIP-162, IDs must not have the form of a UUID.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Artifact createArtifact(ApiName parent, Artifact artifact, String artifactId) {
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
   * Creates a specified artifact.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   ApiSpecName parent =
   *       ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]");
   *   Artifact artifact = Artifact.newBuilder().build();
   *   String artifactId = "artifactId240640653";
   *   Artifact response = registryClient.createArtifact(parent, artifact, artifactId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of artifacts. Format: `{parent}`
   * @param artifact Required. The artifact to create.
   * @param artifactId Required. The ID to use for the artifact, which will become the final
   *     component of the artifact's resource name.
   *     <p>This value should be 4-63 characters, and valid characters are /[a-z][0-9]-/.
   *     <p>Following AIP-162, IDs must not have the form of a UUID.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Artifact createArtifact(ApiSpecName parent, Artifact artifact, String artifactId) {
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
   * Creates a specified artifact.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   ApiVersionName parent = ApiVersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]");
   *   Artifact artifact = Artifact.newBuilder().build();
   *   String artifactId = "artifactId240640653";
   *   Artifact response = registryClient.createArtifact(parent, artifact, artifactId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of artifacts. Format: `{parent}`
   * @param artifact Required. The artifact to create.
   * @param artifactId Required. The ID to use for the artifact, which will become the final
   *     component of the artifact's resource name.
   *     <p>This value should be 4-63 characters, and valid characters are /[a-z][0-9]-/.
   *     <p>Following AIP-162, IDs must not have the form of a UUID.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Artifact createArtifact(
      ApiVersionName parent, Artifact artifact, String artifactId) {
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
   * Creates a specified artifact.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Artifact artifact = Artifact.newBuilder().build();
   *   String artifactId = "artifactId240640653";
   *   Artifact response = registryClient.createArtifact(parent, artifact, artifactId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of artifacts. Format: `{parent}`
   * @param artifact Required. The artifact to create.
   * @param artifactId Required. The ID to use for the artifact, which will become the final
   *     component of the artifact's resource name.
   *     <p>This value should be 4-63 characters, and valid characters are /[a-z][0-9]-/.
   *     <p>Following AIP-162, IDs must not have the form of a UUID.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Artifact createArtifact(LocationName parent, Artifact artifact, String artifactId) {
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
   * Creates a specified artifact.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Artifact artifact = Artifact.newBuilder().build();
   *   String artifactId = "artifactId240640653";
   *   Artifact response = registryClient.createArtifact(parent, artifact, artifactId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of artifacts. Format: `{parent}`
   * @param artifact Required. The artifact to create.
   * @param artifactId Required. The ID to use for the artifact, which will become the final
   *     component of the artifact's resource name.
   *     <p>This value should be 4-63 characters, and valid characters are /[a-z][0-9]-/.
   *     <p>Following AIP-162, IDs must not have the form of a UUID.
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
   * Creates a specified artifact.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   CreateArtifactRequest request =
   *       CreateArtifactRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setArtifact(Artifact.newBuilder().build())
   *           .setArtifactId("artifactId240640653")
   *           .build();
   *   Artifact response = registryClient.createArtifact(request);
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
   * Creates a specified artifact.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   CreateArtifactRequest request =
   *       CreateArtifactRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setArtifact(Artifact.newBuilder().build())
   *           .setArtifactId("artifactId240640653")
   *           .build();
   *   ApiFuture<Artifact> future = registryClient.createArtifactCallable().futureCall(request);
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
   * Used to replace a specified artifact.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   Artifact artifact = Artifact.newBuilder().build();
   *   Artifact response = registryClient.replaceArtifact(artifact);
   * }
   * }</pre>
   *
   * @param artifact Required. The artifact to replace.
   *     <p>The `name` field is used to identify the artifact to replace. Format:
   *     `{parent}/artifacts/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Artifact replaceArtifact(Artifact artifact) {
    ReplaceArtifactRequest request =
        ReplaceArtifactRequest.newBuilder().setArtifact(artifact).build();
    return replaceArtifact(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Used to replace a specified artifact.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   ReplaceArtifactRequest request =
   *       ReplaceArtifactRequest.newBuilder().setArtifact(Artifact.newBuilder().build()).build();
   *   Artifact response = registryClient.replaceArtifact(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Artifact replaceArtifact(ReplaceArtifactRequest request) {
    return replaceArtifactCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Used to replace a specified artifact.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   ReplaceArtifactRequest request =
   *       ReplaceArtifactRequest.newBuilder().setArtifact(Artifact.newBuilder().build()).build();
   *   ApiFuture<Artifact> future = registryClient.replaceArtifactCallable().futureCall(request);
   *   // Do something.
   *   Artifact response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ReplaceArtifactRequest, Artifact> replaceArtifactCallable() {
    return stub.replaceArtifactCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes a specified artifact.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   ArtifactName name =
   *       ArtifactName.ofProjectLocationArtifactName("[PROJECT]", "[LOCATION]", "[ARTIFACT]");
   *   registryClient.deleteArtifact(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the artifact to delete. Format: `{parent}/artifacts/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteArtifact(ArtifactName name) {
    DeleteArtifactRequest request =
        DeleteArtifactRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteArtifact(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes a specified artifact.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   String name =
   *       ArtifactName.ofProjectLocationArtifactName("[PROJECT]", "[LOCATION]", "[ARTIFACT]")
   *           .toString();
   *   registryClient.deleteArtifact(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the artifact to delete. Format: `{parent}/artifacts/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteArtifact(String name) {
    DeleteArtifactRequest request = DeleteArtifactRequest.newBuilder().setName(name).build();
    deleteArtifact(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes a specified artifact.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   DeleteArtifactRequest request =
   *       DeleteArtifactRequest.newBuilder()
   *           .setName(
   *               ArtifactName.ofProjectLocationArtifactName(
   *                       "[PROJECT]", "[LOCATION]", "[ARTIFACT]")
   *                   .toString())
   *           .build();
   *   registryClient.deleteArtifact(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteArtifact(DeleteArtifactRequest request) {
    deleteArtifactCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes a specified artifact.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   DeleteArtifactRequest request =
   *       DeleteArtifactRequest.newBuilder()
   *           .setName(
   *               ArtifactName.ofProjectLocationArtifactName(
   *                       "[PROJECT]", "[LOCATION]", "[ARTIFACT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future = registryClient.deleteArtifactCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteArtifactRequest, Empty> deleteArtifactCallable() {
    return stub.deleteArtifactCallable();
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
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : registryClient.listLocations(request).iterateAll()) {
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
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future = registryClient.listLocationsPagedCallable().futureCall(request);
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
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = registryClient.listLocationsCallable().call(request);
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
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = registryClient.getLocation(request);
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
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = registryClient.getLocationCallable().futureCall(request);
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
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(ApiName.of("[PROJECT]", "[LOCATION]", "[API]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = registryClient.setIamPolicy(request);
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
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(ApiName.of("[PROJECT]", "[LOCATION]", "[API]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = registryClient.setIamPolicyCallable().futureCall(request);
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
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(ApiName.of("[PROJECT]", "[LOCATION]", "[API]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = registryClient.getIamPolicy(request);
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
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(ApiName.of("[PROJECT]", "[LOCATION]", "[API]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = registryClient.getIamPolicyCallable().futureCall(request);
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
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(ApiName.of("[PROJECT]", "[LOCATION]", "[API]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = registryClient.testIamPermissions(request);
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
   * try (RegistryClient registryClient = RegistryClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(ApiName.of("[PROJECT]", "[LOCATION]", "[API]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       registryClient.testIamPermissionsCallable().futureCall(request);
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

  public static class ListApisPagedResponse
      extends AbstractPagedListResponse<
          ListApisRequest, ListApisResponse, Api, ListApisPage, ListApisFixedSizeCollection> {

    public static ApiFuture<ListApisPagedResponse> createAsync(
        PageContext<ListApisRequest, ListApisResponse, Api> context,
        ApiFuture<ListApisResponse> futureResponse) {
      ApiFuture<ListApisPage> futurePage =
          ListApisPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListApisPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListApisPagedResponse(ListApisPage page) {
      super(page, ListApisFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListApisPage
      extends AbstractPage<ListApisRequest, ListApisResponse, Api, ListApisPage> {

    private ListApisPage(
        PageContext<ListApisRequest, ListApisResponse, Api> context, ListApisResponse response) {
      super(context, response);
    }

    private static ListApisPage createEmptyPage() {
      return new ListApisPage(null, null);
    }

    @Override
    protected ListApisPage createPage(
        PageContext<ListApisRequest, ListApisResponse, Api> context, ListApisResponse response) {
      return new ListApisPage(context, response);
    }

    @Override
    public ApiFuture<ListApisPage> createPageAsync(
        PageContext<ListApisRequest, ListApisResponse, Api> context,
        ApiFuture<ListApisResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListApisFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListApisRequest, ListApisResponse, Api, ListApisPage, ListApisFixedSizeCollection> {

    private ListApisFixedSizeCollection(List<ListApisPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListApisFixedSizeCollection createEmptyCollection() {
      return new ListApisFixedSizeCollection(null, 0);
    }

    @Override
    protected ListApisFixedSizeCollection createCollection(
        List<ListApisPage> pages, int collectionSize) {
      return new ListApisFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListApiVersionsPagedResponse
      extends AbstractPagedListResponse<
          ListApiVersionsRequest,
          ListApiVersionsResponse,
          ApiVersion,
          ListApiVersionsPage,
          ListApiVersionsFixedSizeCollection> {

    public static ApiFuture<ListApiVersionsPagedResponse> createAsync(
        PageContext<ListApiVersionsRequest, ListApiVersionsResponse, ApiVersion> context,
        ApiFuture<ListApiVersionsResponse> futureResponse) {
      ApiFuture<ListApiVersionsPage> futurePage =
          ListApiVersionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListApiVersionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListApiVersionsPagedResponse(ListApiVersionsPage page) {
      super(page, ListApiVersionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListApiVersionsPage
      extends AbstractPage<
          ListApiVersionsRequest, ListApiVersionsResponse, ApiVersion, ListApiVersionsPage> {

    private ListApiVersionsPage(
        PageContext<ListApiVersionsRequest, ListApiVersionsResponse, ApiVersion> context,
        ListApiVersionsResponse response) {
      super(context, response);
    }

    private static ListApiVersionsPage createEmptyPage() {
      return new ListApiVersionsPage(null, null);
    }

    @Override
    protected ListApiVersionsPage createPage(
        PageContext<ListApiVersionsRequest, ListApiVersionsResponse, ApiVersion> context,
        ListApiVersionsResponse response) {
      return new ListApiVersionsPage(context, response);
    }

    @Override
    public ApiFuture<ListApiVersionsPage> createPageAsync(
        PageContext<ListApiVersionsRequest, ListApiVersionsResponse, ApiVersion> context,
        ApiFuture<ListApiVersionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListApiVersionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListApiVersionsRequest,
          ListApiVersionsResponse,
          ApiVersion,
          ListApiVersionsPage,
          ListApiVersionsFixedSizeCollection> {

    private ListApiVersionsFixedSizeCollection(
        List<ListApiVersionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListApiVersionsFixedSizeCollection createEmptyCollection() {
      return new ListApiVersionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListApiVersionsFixedSizeCollection createCollection(
        List<ListApiVersionsPage> pages, int collectionSize) {
      return new ListApiVersionsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListApiSpecsPagedResponse
      extends AbstractPagedListResponse<
          ListApiSpecsRequest,
          ListApiSpecsResponse,
          ApiSpec,
          ListApiSpecsPage,
          ListApiSpecsFixedSizeCollection> {

    public static ApiFuture<ListApiSpecsPagedResponse> createAsync(
        PageContext<ListApiSpecsRequest, ListApiSpecsResponse, ApiSpec> context,
        ApiFuture<ListApiSpecsResponse> futureResponse) {
      ApiFuture<ListApiSpecsPage> futurePage =
          ListApiSpecsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListApiSpecsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListApiSpecsPagedResponse(ListApiSpecsPage page) {
      super(page, ListApiSpecsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListApiSpecsPage
      extends AbstractPage<ListApiSpecsRequest, ListApiSpecsResponse, ApiSpec, ListApiSpecsPage> {

    private ListApiSpecsPage(
        PageContext<ListApiSpecsRequest, ListApiSpecsResponse, ApiSpec> context,
        ListApiSpecsResponse response) {
      super(context, response);
    }

    private static ListApiSpecsPage createEmptyPage() {
      return new ListApiSpecsPage(null, null);
    }

    @Override
    protected ListApiSpecsPage createPage(
        PageContext<ListApiSpecsRequest, ListApiSpecsResponse, ApiSpec> context,
        ListApiSpecsResponse response) {
      return new ListApiSpecsPage(context, response);
    }

    @Override
    public ApiFuture<ListApiSpecsPage> createPageAsync(
        PageContext<ListApiSpecsRequest, ListApiSpecsResponse, ApiSpec> context,
        ApiFuture<ListApiSpecsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListApiSpecsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListApiSpecsRequest,
          ListApiSpecsResponse,
          ApiSpec,
          ListApiSpecsPage,
          ListApiSpecsFixedSizeCollection> {

    private ListApiSpecsFixedSizeCollection(List<ListApiSpecsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListApiSpecsFixedSizeCollection createEmptyCollection() {
      return new ListApiSpecsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListApiSpecsFixedSizeCollection createCollection(
        List<ListApiSpecsPage> pages, int collectionSize) {
      return new ListApiSpecsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListApiSpecRevisionsPagedResponse
      extends AbstractPagedListResponse<
          ListApiSpecRevisionsRequest,
          ListApiSpecRevisionsResponse,
          ApiSpec,
          ListApiSpecRevisionsPage,
          ListApiSpecRevisionsFixedSizeCollection> {

    public static ApiFuture<ListApiSpecRevisionsPagedResponse> createAsync(
        PageContext<ListApiSpecRevisionsRequest, ListApiSpecRevisionsResponse, ApiSpec> context,
        ApiFuture<ListApiSpecRevisionsResponse> futureResponse) {
      ApiFuture<ListApiSpecRevisionsPage> futurePage =
          ListApiSpecRevisionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListApiSpecRevisionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListApiSpecRevisionsPagedResponse(ListApiSpecRevisionsPage page) {
      super(page, ListApiSpecRevisionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListApiSpecRevisionsPage
      extends AbstractPage<
          ListApiSpecRevisionsRequest,
          ListApiSpecRevisionsResponse,
          ApiSpec,
          ListApiSpecRevisionsPage> {

    private ListApiSpecRevisionsPage(
        PageContext<ListApiSpecRevisionsRequest, ListApiSpecRevisionsResponse, ApiSpec> context,
        ListApiSpecRevisionsResponse response) {
      super(context, response);
    }

    private static ListApiSpecRevisionsPage createEmptyPage() {
      return new ListApiSpecRevisionsPage(null, null);
    }

    @Override
    protected ListApiSpecRevisionsPage createPage(
        PageContext<ListApiSpecRevisionsRequest, ListApiSpecRevisionsResponse, ApiSpec> context,
        ListApiSpecRevisionsResponse response) {
      return new ListApiSpecRevisionsPage(context, response);
    }

    @Override
    public ApiFuture<ListApiSpecRevisionsPage> createPageAsync(
        PageContext<ListApiSpecRevisionsRequest, ListApiSpecRevisionsResponse, ApiSpec> context,
        ApiFuture<ListApiSpecRevisionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListApiSpecRevisionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListApiSpecRevisionsRequest,
          ListApiSpecRevisionsResponse,
          ApiSpec,
          ListApiSpecRevisionsPage,
          ListApiSpecRevisionsFixedSizeCollection> {

    private ListApiSpecRevisionsFixedSizeCollection(
        List<ListApiSpecRevisionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListApiSpecRevisionsFixedSizeCollection createEmptyCollection() {
      return new ListApiSpecRevisionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListApiSpecRevisionsFixedSizeCollection createCollection(
        List<ListApiSpecRevisionsPage> pages, int collectionSize) {
      return new ListApiSpecRevisionsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListApiDeploymentsPagedResponse
      extends AbstractPagedListResponse<
          ListApiDeploymentsRequest,
          ListApiDeploymentsResponse,
          ApiDeployment,
          ListApiDeploymentsPage,
          ListApiDeploymentsFixedSizeCollection> {

    public static ApiFuture<ListApiDeploymentsPagedResponse> createAsync(
        PageContext<ListApiDeploymentsRequest, ListApiDeploymentsResponse, ApiDeployment> context,
        ApiFuture<ListApiDeploymentsResponse> futureResponse) {
      ApiFuture<ListApiDeploymentsPage> futurePage =
          ListApiDeploymentsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListApiDeploymentsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListApiDeploymentsPagedResponse(ListApiDeploymentsPage page) {
      super(page, ListApiDeploymentsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListApiDeploymentsPage
      extends AbstractPage<
          ListApiDeploymentsRequest,
          ListApiDeploymentsResponse,
          ApiDeployment,
          ListApiDeploymentsPage> {

    private ListApiDeploymentsPage(
        PageContext<ListApiDeploymentsRequest, ListApiDeploymentsResponse, ApiDeployment> context,
        ListApiDeploymentsResponse response) {
      super(context, response);
    }

    private static ListApiDeploymentsPage createEmptyPage() {
      return new ListApiDeploymentsPage(null, null);
    }

    @Override
    protected ListApiDeploymentsPage createPage(
        PageContext<ListApiDeploymentsRequest, ListApiDeploymentsResponse, ApiDeployment> context,
        ListApiDeploymentsResponse response) {
      return new ListApiDeploymentsPage(context, response);
    }

    @Override
    public ApiFuture<ListApiDeploymentsPage> createPageAsync(
        PageContext<ListApiDeploymentsRequest, ListApiDeploymentsResponse, ApiDeployment> context,
        ApiFuture<ListApiDeploymentsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListApiDeploymentsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListApiDeploymentsRequest,
          ListApiDeploymentsResponse,
          ApiDeployment,
          ListApiDeploymentsPage,
          ListApiDeploymentsFixedSizeCollection> {

    private ListApiDeploymentsFixedSizeCollection(
        List<ListApiDeploymentsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListApiDeploymentsFixedSizeCollection createEmptyCollection() {
      return new ListApiDeploymentsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListApiDeploymentsFixedSizeCollection createCollection(
        List<ListApiDeploymentsPage> pages, int collectionSize) {
      return new ListApiDeploymentsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListApiDeploymentRevisionsPagedResponse
      extends AbstractPagedListResponse<
          ListApiDeploymentRevisionsRequest,
          ListApiDeploymentRevisionsResponse,
          ApiDeployment,
          ListApiDeploymentRevisionsPage,
          ListApiDeploymentRevisionsFixedSizeCollection> {

    public static ApiFuture<ListApiDeploymentRevisionsPagedResponse> createAsync(
        PageContext<
                ListApiDeploymentRevisionsRequest,
                ListApiDeploymentRevisionsResponse,
                ApiDeployment>
            context,
        ApiFuture<ListApiDeploymentRevisionsResponse> futureResponse) {
      ApiFuture<ListApiDeploymentRevisionsPage> futurePage =
          ListApiDeploymentRevisionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListApiDeploymentRevisionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListApiDeploymentRevisionsPagedResponse(ListApiDeploymentRevisionsPage page) {
      super(page, ListApiDeploymentRevisionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListApiDeploymentRevisionsPage
      extends AbstractPage<
          ListApiDeploymentRevisionsRequest,
          ListApiDeploymentRevisionsResponse,
          ApiDeployment,
          ListApiDeploymentRevisionsPage> {

    private ListApiDeploymentRevisionsPage(
        PageContext<
                ListApiDeploymentRevisionsRequest,
                ListApiDeploymentRevisionsResponse,
                ApiDeployment>
            context,
        ListApiDeploymentRevisionsResponse response) {
      super(context, response);
    }

    private static ListApiDeploymentRevisionsPage createEmptyPage() {
      return new ListApiDeploymentRevisionsPage(null, null);
    }

    @Override
    protected ListApiDeploymentRevisionsPage createPage(
        PageContext<
                ListApiDeploymentRevisionsRequest,
                ListApiDeploymentRevisionsResponse,
                ApiDeployment>
            context,
        ListApiDeploymentRevisionsResponse response) {
      return new ListApiDeploymentRevisionsPage(context, response);
    }

    @Override
    public ApiFuture<ListApiDeploymentRevisionsPage> createPageAsync(
        PageContext<
                ListApiDeploymentRevisionsRequest,
                ListApiDeploymentRevisionsResponse,
                ApiDeployment>
            context,
        ApiFuture<ListApiDeploymentRevisionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListApiDeploymentRevisionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListApiDeploymentRevisionsRequest,
          ListApiDeploymentRevisionsResponse,
          ApiDeployment,
          ListApiDeploymentRevisionsPage,
          ListApiDeploymentRevisionsFixedSizeCollection> {

    private ListApiDeploymentRevisionsFixedSizeCollection(
        List<ListApiDeploymentRevisionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListApiDeploymentRevisionsFixedSizeCollection createEmptyCollection() {
      return new ListApiDeploymentRevisionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListApiDeploymentRevisionsFixedSizeCollection createCollection(
        List<ListApiDeploymentRevisionsPage> pages, int collectionSize) {
      return new ListApiDeploymentRevisionsFixedSizeCollection(pages, collectionSize);
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
