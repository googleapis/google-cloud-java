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

package com.google.cloud.kms.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.kms.v1.stub.EkmServiceStub;
import com.google.cloud.kms.v1.stub.EkmServiceStubSettings;
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
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Google Cloud Key Management EKM Service
 *
 * <p>Manages external cryptographic keys and operations using those keys. Implements a REST model
 * with the following objects:
 *
 * <ul>
 *   <li>[EkmConnection][google.cloud.kms.v1.EkmConnection]
 * </ul>
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
 * try (EkmServiceClient ekmServiceClient = EkmServiceClient.create()) {
 *   EkmConnectionName name = EkmConnectionName.of("[PROJECT]", "[LOCATION]", "[EKM_CONNECTION]");
 *   EkmConnection response = ekmServiceClient.getEkmConnection(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the EkmServiceClient object to clean up resources such as
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
 * <p>This class can be customized by passing in a custom instance of EkmServiceSettings to
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
 * EkmServiceSettings ekmServiceSettings =
 *     EkmServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * EkmServiceClient ekmServiceClient = EkmServiceClient.create(ekmServiceSettings);
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
 * EkmServiceSettings ekmServiceSettings =
 *     EkmServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * EkmServiceClient ekmServiceClient = EkmServiceClient.create(ekmServiceSettings);
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
 * EkmServiceSettings ekmServiceSettings = EkmServiceSettings.newHttpJsonBuilder().build();
 * EkmServiceClient ekmServiceClient = EkmServiceClient.create(ekmServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class EkmServiceClient implements BackgroundResource {
  private final EkmServiceSettings settings;
  private final EkmServiceStub stub;

  /** Constructs an instance of EkmServiceClient with default settings. */
  public static final EkmServiceClient create() throws IOException {
    return create(EkmServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of EkmServiceClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final EkmServiceClient create(EkmServiceSettings settings) throws IOException {
    return new EkmServiceClient(settings);
  }

  /**
   * Constructs an instance of EkmServiceClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(EkmServiceSettings).
   */
  public static final EkmServiceClient create(EkmServiceStub stub) {
    return new EkmServiceClient(stub);
  }

  /**
   * Constructs an instance of EkmServiceClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected EkmServiceClient(EkmServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((EkmServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected EkmServiceClient(EkmServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final EkmServiceSettings getSettings() {
    return settings;
  }

  public EkmServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [EkmConnections][google.cloud.kms.v1.EkmConnection].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EkmServiceClient ekmServiceClient = EkmServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (EkmConnection element : ekmServiceClient.listEkmConnections(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location associated with the
   *     [EkmConnections][google.cloud.kms.v1.EkmConnection] to list, in the format
   *     `projects/&#42;/locations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEkmConnectionsPagedResponse listEkmConnections(LocationName parent) {
    ListEkmConnectionsRequest request =
        ListEkmConnectionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listEkmConnections(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [EkmConnections][google.cloud.kms.v1.EkmConnection].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EkmServiceClient ekmServiceClient = EkmServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (EkmConnection element : ekmServiceClient.listEkmConnections(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location associated with the
   *     [EkmConnections][google.cloud.kms.v1.EkmConnection] to list, in the format
   *     `projects/&#42;/locations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEkmConnectionsPagedResponse listEkmConnections(String parent) {
    ListEkmConnectionsRequest request =
        ListEkmConnectionsRequest.newBuilder().setParent(parent).build();
    return listEkmConnections(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [EkmConnections][google.cloud.kms.v1.EkmConnection].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EkmServiceClient ekmServiceClient = EkmServiceClient.create()) {
   *   ListEkmConnectionsRequest request =
   *       ListEkmConnectionsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (EkmConnection element : ekmServiceClient.listEkmConnections(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEkmConnectionsPagedResponse listEkmConnections(
      ListEkmConnectionsRequest request) {
    return listEkmConnectionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [EkmConnections][google.cloud.kms.v1.EkmConnection].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EkmServiceClient ekmServiceClient = EkmServiceClient.create()) {
   *   ListEkmConnectionsRequest request =
   *       ListEkmConnectionsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<EkmConnection> future =
   *       ekmServiceClient.listEkmConnectionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (EkmConnection element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListEkmConnectionsRequest, ListEkmConnectionsPagedResponse>
      listEkmConnectionsPagedCallable() {
    return stub.listEkmConnectionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [EkmConnections][google.cloud.kms.v1.EkmConnection].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EkmServiceClient ekmServiceClient = EkmServiceClient.create()) {
   *   ListEkmConnectionsRequest request =
   *       ListEkmConnectionsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListEkmConnectionsResponse response =
   *         ekmServiceClient.listEkmConnectionsCallable().call(request);
   *     for (EkmConnection element : response.getEkmConnectionsList()) {
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
  public final UnaryCallable<ListEkmConnectionsRequest, ListEkmConnectionsResponse>
      listEkmConnectionsCallable() {
    return stub.listEkmConnectionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns metadata for a given [EkmConnection][google.cloud.kms.v1.EkmConnection].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EkmServiceClient ekmServiceClient = EkmServiceClient.create()) {
   *   EkmConnectionName name = EkmConnectionName.of("[PROJECT]", "[LOCATION]", "[EKM_CONNECTION]");
   *   EkmConnection response = ekmServiceClient.getEkmConnection(name);
   * }
   * }</pre>
   *
   * @param name Required. The [name][google.cloud.kms.v1.EkmConnection.name] of the
   *     [EkmConnection][google.cloud.kms.v1.EkmConnection] to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EkmConnection getEkmConnection(EkmConnectionName name) {
    GetEkmConnectionRequest request =
        GetEkmConnectionRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getEkmConnection(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns metadata for a given [EkmConnection][google.cloud.kms.v1.EkmConnection].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EkmServiceClient ekmServiceClient = EkmServiceClient.create()) {
   *   String name = EkmConnectionName.of("[PROJECT]", "[LOCATION]", "[EKM_CONNECTION]").toString();
   *   EkmConnection response = ekmServiceClient.getEkmConnection(name);
   * }
   * }</pre>
   *
   * @param name Required. The [name][google.cloud.kms.v1.EkmConnection.name] of the
   *     [EkmConnection][google.cloud.kms.v1.EkmConnection] to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EkmConnection getEkmConnection(String name) {
    GetEkmConnectionRequest request = GetEkmConnectionRequest.newBuilder().setName(name).build();
    return getEkmConnection(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns metadata for a given [EkmConnection][google.cloud.kms.v1.EkmConnection].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EkmServiceClient ekmServiceClient = EkmServiceClient.create()) {
   *   GetEkmConnectionRequest request =
   *       GetEkmConnectionRequest.newBuilder()
   *           .setName(
   *               EkmConnectionName.of("[PROJECT]", "[LOCATION]", "[EKM_CONNECTION]").toString())
   *           .build();
   *   EkmConnection response = ekmServiceClient.getEkmConnection(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EkmConnection getEkmConnection(GetEkmConnectionRequest request) {
    return getEkmConnectionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns metadata for a given [EkmConnection][google.cloud.kms.v1.EkmConnection].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EkmServiceClient ekmServiceClient = EkmServiceClient.create()) {
   *   GetEkmConnectionRequest request =
   *       GetEkmConnectionRequest.newBuilder()
   *           .setName(
   *               EkmConnectionName.of("[PROJECT]", "[LOCATION]", "[EKM_CONNECTION]").toString())
   *           .build();
   *   ApiFuture<EkmConnection> future =
   *       ekmServiceClient.getEkmConnectionCallable().futureCall(request);
   *   // Do something.
   *   EkmConnection response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetEkmConnectionRequest, EkmConnection> getEkmConnectionCallable() {
    return stub.getEkmConnectionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new [EkmConnection][google.cloud.kms.v1.EkmConnection] in a given Project and
   * Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EkmServiceClient ekmServiceClient = EkmServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   String ekmConnectionId = "ekmConnectionId-445017408";
   *   EkmConnection ekmConnection = EkmConnection.newBuilder().build();
   *   EkmConnection response =
   *       ekmServiceClient.createEkmConnection(parent, ekmConnectionId, ekmConnection);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location associated with the
   *     [EkmConnection][google.cloud.kms.v1.EkmConnection], in the format
   *     `projects/&#42;/locations/&#42;`.
   * @param ekmConnectionId Required. It must be unique within a location and match the regular
   *     expression `[a-zA-Z0-9_-]{1,63}`.
   * @param ekmConnection Required. An [EkmConnection][google.cloud.kms.v1.EkmConnection] with
   *     initial field values.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EkmConnection createEkmConnection(
      LocationName parent, String ekmConnectionId, EkmConnection ekmConnection) {
    CreateEkmConnectionRequest request =
        CreateEkmConnectionRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setEkmConnectionId(ekmConnectionId)
            .setEkmConnection(ekmConnection)
            .build();
    return createEkmConnection(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new [EkmConnection][google.cloud.kms.v1.EkmConnection] in a given Project and
   * Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EkmServiceClient ekmServiceClient = EkmServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   String ekmConnectionId = "ekmConnectionId-445017408";
   *   EkmConnection ekmConnection = EkmConnection.newBuilder().build();
   *   EkmConnection response =
   *       ekmServiceClient.createEkmConnection(parent, ekmConnectionId, ekmConnection);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location associated with the
   *     [EkmConnection][google.cloud.kms.v1.EkmConnection], in the format
   *     `projects/&#42;/locations/&#42;`.
   * @param ekmConnectionId Required. It must be unique within a location and match the regular
   *     expression `[a-zA-Z0-9_-]{1,63}`.
   * @param ekmConnection Required. An [EkmConnection][google.cloud.kms.v1.EkmConnection] with
   *     initial field values.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EkmConnection createEkmConnection(
      String parent, String ekmConnectionId, EkmConnection ekmConnection) {
    CreateEkmConnectionRequest request =
        CreateEkmConnectionRequest.newBuilder()
            .setParent(parent)
            .setEkmConnectionId(ekmConnectionId)
            .setEkmConnection(ekmConnection)
            .build();
    return createEkmConnection(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new [EkmConnection][google.cloud.kms.v1.EkmConnection] in a given Project and
   * Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EkmServiceClient ekmServiceClient = EkmServiceClient.create()) {
   *   CreateEkmConnectionRequest request =
   *       CreateEkmConnectionRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setEkmConnectionId("ekmConnectionId-445017408")
   *           .setEkmConnection(EkmConnection.newBuilder().build())
   *           .build();
   *   EkmConnection response = ekmServiceClient.createEkmConnection(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EkmConnection createEkmConnection(CreateEkmConnectionRequest request) {
    return createEkmConnectionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new [EkmConnection][google.cloud.kms.v1.EkmConnection] in a given Project and
   * Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EkmServiceClient ekmServiceClient = EkmServiceClient.create()) {
   *   CreateEkmConnectionRequest request =
   *       CreateEkmConnectionRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setEkmConnectionId("ekmConnectionId-445017408")
   *           .setEkmConnection(EkmConnection.newBuilder().build())
   *           .build();
   *   ApiFuture<EkmConnection> future =
   *       ekmServiceClient.createEkmConnectionCallable().futureCall(request);
   *   // Do something.
   *   EkmConnection response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateEkmConnectionRequest, EkmConnection>
      createEkmConnectionCallable() {
    return stub.createEkmConnectionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an [EkmConnection][google.cloud.kms.v1.EkmConnection]'s metadata.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EkmServiceClient ekmServiceClient = EkmServiceClient.create()) {
   *   EkmConnection ekmConnection = EkmConnection.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   EkmConnection response = ekmServiceClient.updateEkmConnection(ekmConnection, updateMask);
   * }
   * }</pre>
   *
   * @param ekmConnection Required. [EkmConnection][google.cloud.kms.v1.EkmConnection] with updated
   *     values.
   * @param updateMask Required. List of fields to be updated in this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EkmConnection updateEkmConnection(
      EkmConnection ekmConnection, FieldMask updateMask) {
    UpdateEkmConnectionRequest request =
        UpdateEkmConnectionRequest.newBuilder()
            .setEkmConnection(ekmConnection)
            .setUpdateMask(updateMask)
            .build();
    return updateEkmConnection(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an [EkmConnection][google.cloud.kms.v1.EkmConnection]'s metadata.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EkmServiceClient ekmServiceClient = EkmServiceClient.create()) {
   *   UpdateEkmConnectionRequest request =
   *       UpdateEkmConnectionRequest.newBuilder()
   *           .setEkmConnection(EkmConnection.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   EkmConnection response = ekmServiceClient.updateEkmConnection(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EkmConnection updateEkmConnection(UpdateEkmConnectionRequest request) {
    return updateEkmConnectionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an [EkmConnection][google.cloud.kms.v1.EkmConnection]'s metadata.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EkmServiceClient ekmServiceClient = EkmServiceClient.create()) {
   *   UpdateEkmConnectionRequest request =
   *       UpdateEkmConnectionRequest.newBuilder()
   *           .setEkmConnection(EkmConnection.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<EkmConnection> future =
   *       ekmServiceClient.updateEkmConnectionCallable().futureCall(request);
   *   // Do something.
   *   EkmConnection response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateEkmConnectionRequest, EkmConnection>
      updateEkmConnectionCallable() {
    return stub.updateEkmConnectionCallable();
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
   * try (EkmServiceClient ekmServiceClient = EkmServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : ekmServiceClient.listLocations(request).iterateAll()) {
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
   * try (EkmServiceClient ekmServiceClient = EkmServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       ekmServiceClient.listLocationsPagedCallable().futureCall(request);
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
   * try (EkmServiceClient ekmServiceClient = EkmServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = ekmServiceClient.listLocationsCallable().call(request);
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
   * try (EkmServiceClient ekmServiceClient = EkmServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = ekmServiceClient.getLocation(request);
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
   * try (EkmServiceClient ekmServiceClient = EkmServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = ekmServiceClient.getLocationCallable().futureCall(request);
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
   * try (EkmServiceClient ekmServiceClient = EkmServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = ekmServiceClient.setIamPolicy(request);
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
   * try (EkmServiceClient ekmServiceClient = EkmServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = ekmServiceClient.setIamPolicyCallable().futureCall(request);
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
   * try (EkmServiceClient ekmServiceClient = EkmServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = ekmServiceClient.getIamPolicy(request);
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
   * try (EkmServiceClient ekmServiceClient = EkmServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = ekmServiceClient.getIamPolicyCallable().futureCall(request);
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
   * try (EkmServiceClient ekmServiceClient = EkmServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = ekmServiceClient.testIamPermissions(request);
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
   * try (EkmServiceClient ekmServiceClient = EkmServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       ekmServiceClient.testIamPermissionsCallable().futureCall(request);
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

  public static class ListEkmConnectionsPagedResponse
      extends AbstractPagedListResponse<
          ListEkmConnectionsRequest,
          ListEkmConnectionsResponse,
          EkmConnection,
          ListEkmConnectionsPage,
          ListEkmConnectionsFixedSizeCollection> {

    public static ApiFuture<ListEkmConnectionsPagedResponse> createAsync(
        PageContext<ListEkmConnectionsRequest, ListEkmConnectionsResponse, EkmConnection> context,
        ApiFuture<ListEkmConnectionsResponse> futureResponse) {
      ApiFuture<ListEkmConnectionsPage> futurePage =
          ListEkmConnectionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListEkmConnectionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListEkmConnectionsPagedResponse(ListEkmConnectionsPage page) {
      super(page, ListEkmConnectionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListEkmConnectionsPage
      extends AbstractPage<
          ListEkmConnectionsRequest,
          ListEkmConnectionsResponse,
          EkmConnection,
          ListEkmConnectionsPage> {

    private ListEkmConnectionsPage(
        PageContext<ListEkmConnectionsRequest, ListEkmConnectionsResponse, EkmConnection> context,
        ListEkmConnectionsResponse response) {
      super(context, response);
    }

    private static ListEkmConnectionsPage createEmptyPage() {
      return new ListEkmConnectionsPage(null, null);
    }

    @Override
    protected ListEkmConnectionsPage createPage(
        PageContext<ListEkmConnectionsRequest, ListEkmConnectionsResponse, EkmConnection> context,
        ListEkmConnectionsResponse response) {
      return new ListEkmConnectionsPage(context, response);
    }

    @Override
    public ApiFuture<ListEkmConnectionsPage> createPageAsync(
        PageContext<ListEkmConnectionsRequest, ListEkmConnectionsResponse, EkmConnection> context,
        ApiFuture<ListEkmConnectionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListEkmConnectionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListEkmConnectionsRequest,
          ListEkmConnectionsResponse,
          EkmConnection,
          ListEkmConnectionsPage,
          ListEkmConnectionsFixedSizeCollection> {

    private ListEkmConnectionsFixedSizeCollection(
        List<ListEkmConnectionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListEkmConnectionsFixedSizeCollection createEmptyCollection() {
      return new ListEkmConnectionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListEkmConnectionsFixedSizeCollection createCollection(
        List<ListEkmConnectionsPage> pages, int collectionSize) {
      return new ListEkmConnectionsFixedSizeCollection(pages, collectionSize);
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
