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

package com.google.cloud.datastream.v1;

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
import com.google.cloud.datastream.v1.stub.DatastreamStub;
import com.google.cloud.datastream.v1.stub.DatastreamStubSettings;
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
 * Service Description: Datastream service
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
 * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
 *   ConnectionProfileName name =
 *       ConnectionProfileName.of("[PROJECT]", "[LOCATION]", "[CONNECTION_PROFILE]");
 *   ConnectionProfile response = datastreamClient.getConnectionProfile(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the DatastreamClient object to clean up resources such as
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
 * <p>This class can be customized by passing in a custom instance of DatastreamSettings to
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
 * DatastreamSettings datastreamSettings =
 *     DatastreamSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DatastreamClient datastreamClient = DatastreamClient.create(datastreamSettings);
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
 * DatastreamSettings datastreamSettings =
 *     DatastreamSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DatastreamClient datastreamClient = DatastreamClient.create(datastreamSettings);
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
 * DatastreamSettings datastreamSettings =
 *     DatastreamSettings.newBuilder()
 *         .setTransportChannelProvider(
 *             DatastreamSettings.defaultHttpJsonTransportProviderBuilder().build())
 *         .build();
 * DatastreamClient datastreamClient = DatastreamClient.create(datastreamSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class DatastreamClient implements BackgroundResource {
  private final DatastreamSettings settings;
  private final DatastreamStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of DatastreamClient with default settings. */
  public static final DatastreamClient create() throws IOException {
    return create(DatastreamSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of DatastreamClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final DatastreamClient create(DatastreamSettings settings) throws IOException {
    return new DatastreamClient(settings);
  }

  /**
   * Constructs an instance of DatastreamClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(DatastreamSettings).
   */
  public static final DatastreamClient create(DatastreamStub stub) {
    return new DatastreamClient(stub);
  }

  /**
   * Constructs an instance of DatastreamClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected DatastreamClient(DatastreamSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((DatastreamStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected DatastreamClient(DatastreamStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final DatastreamSettings getSettings() {
    return settings;
  }

  public DatastreamStub getStub() {
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
   * Use this method to list connection profiles created in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (ConnectionProfile element :
   *       datastreamClient.listConnectionProfiles(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent that owns the collection of connection profiles.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListConnectionProfilesPagedResponse listConnectionProfiles(LocationName parent) {
    ListConnectionProfilesRequest request =
        ListConnectionProfilesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listConnectionProfiles(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to list connection profiles created in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (ConnectionProfile element :
   *       datastreamClient.listConnectionProfiles(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent that owns the collection of connection profiles.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListConnectionProfilesPagedResponse listConnectionProfiles(String parent) {
    ListConnectionProfilesRequest request =
        ListConnectionProfilesRequest.newBuilder().setParent(parent).build();
    return listConnectionProfiles(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to list connection profiles created in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   ListConnectionProfilesRequest request =
   *       ListConnectionProfilesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (ConnectionProfile element :
   *       datastreamClient.listConnectionProfiles(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListConnectionProfilesPagedResponse listConnectionProfiles(
      ListConnectionProfilesRequest request) {
    return listConnectionProfilesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to list connection profiles created in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   ListConnectionProfilesRequest request =
   *       ListConnectionProfilesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<ConnectionProfile> future =
   *       datastreamClient.listConnectionProfilesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ConnectionProfile element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListConnectionProfilesRequest, ListConnectionProfilesPagedResponse>
      listConnectionProfilesPagedCallable() {
    return stub.listConnectionProfilesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to list connection profiles created in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   ListConnectionProfilesRequest request =
   *       ListConnectionProfilesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListConnectionProfilesResponse response =
   *         datastreamClient.listConnectionProfilesCallable().call(request);
   *     for (ConnectionProfile element : response.getConnectionProfilesList()) {
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
  public final UnaryCallable<ListConnectionProfilesRequest, ListConnectionProfilesResponse>
      listConnectionProfilesCallable() {
    return stub.listConnectionProfilesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to get details about a connection profile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   ConnectionProfileName name =
   *       ConnectionProfileName.of("[PROJECT]", "[LOCATION]", "[CONNECTION_PROFILE]");
   *   ConnectionProfile response = datastreamClient.getConnectionProfile(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the connection profile resource to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ConnectionProfile getConnectionProfile(ConnectionProfileName name) {
    GetConnectionProfileRequest request =
        GetConnectionProfileRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getConnectionProfile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to get details about a connection profile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   String name =
   *       ConnectionProfileName.of("[PROJECT]", "[LOCATION]", "[CONNECTION_PROFILE]").toString();
   *   ConnectionProfile response = datastreamClient.getConnectionProfile(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the connection profile resource to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ConnectionProfile getConnectionProfile(String name) {
    GetConnectionProfileRequest request =
        GetConnectionProfileRequest.newBuilder().setName(name).build();
    return getConnectionProfile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to get details about a connection profile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   GetConnectionProfileRequest request =
   *       GetConnectionProfileRequest.newBuilder()
   *           .setName(
   *               ConnectionProfileName.of("[PROJECT]", "[LOCATION]", "[CONNECTION_PROFILE]")
   *                   .toString())
   *           .build();
   *   ConnectionProfile response = datastreamClient.getConnectionProfile(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ConnectionProfile getConnectionProfile(GetConnectionProfileRequest request) {
    return getConnectionProfileCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to get details about a connection profile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   GetConnectionProfileRequest request =
   *       GetConnectionProfileRequest.newBuilder()
   *           .setName(
   *               ConnectionProfileName.of("[PROJECT]", "[LOCATION]", "[CONNECTION_PROFILE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<ConnectionProfile> future =
   *       datastreamClient.getConnectionProfileCallable().futureCall(request);
   *   // Do something.
   *   ConnectionProfile response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetConnectionProfileRequest, ConnectionProfile>
      getConnectionProfileCallable() {
    return stub.getConnectionProfileCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to create a connection profile in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ConnectionProfile connectionProfile = ConnectionProfile.newBuilder().build();
   *   String connectionProfileId = "connectionProfileId597575526";
   *   ConnectionProfile response =
   *       datastreamClient
   *           .createConnectionProfileAsync(parent, connectionProfile, connectionProfileId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent that owns the collection of ConnectionProfiles.
   * @param connectionProfile Required. The connection profile resource to create.
   * @param connectionProfileId Required. The connection profile identifier.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ConnectionProfile, OperationMetadata> createConnectionProfileAsync(
      LocationName parent, ConnectionProfile connectionProfile, String connectionProfileId) {
    CreateConnectionProfileRequest request =
        CreateConnectionProfileRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setConnectionProfile(connectionProfile)
            .setConnectionProfileId(connectionProfileId)
            .build();
    return createConnectionProfileAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to create a connection profile in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   ConnectionProfile connectionProfile = ConnectionProfile.newBuilder().build();
   *   String connectionProfileId = "connectionProfileId597575526";
   *   ConnectionProfile response =
   *       datastreamClient
   *           .createConnectionProfileAsync(parent, connectionProfile, connectionProfileId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent that owns the collection of ConnectionProfiles.
   * @param connectionProfile Required. The connection profile resource to create.
   * @param connectionProfileId Required. The connection profile identifier.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ConnectionProfile, OperationMetadata> createConnectionProfileAsync(
      String parent, ConnectionProfile connectionProfile, String connectionProfileId) {
    CreateConnectionProfileRequest request =
        CreateConnectionProfileRequest.newBuilder()
            .setParent(parent)
            .setConnectionProfile(connectionProfile)
            .setConnectionProfileId(connectionProfileId)
            .build();
    return createConnectionProfileAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to create a connection profile in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   CreateConnectionProfileRequest request =
   *       CreateConnectionProfileRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setConnectionProfileId("connectionProfileId597575526")
   *           .setConnectionProfile(ConnectionProfile.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .setForce(true)
   *           .build();
   *   ConnectionProfile response = datastreamClient.createConnectionProfileAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ConnectionProfile, OperationMetadata> createConnectionProfileAsync(
      CreateConnectionProfileRequest request) {
    return createConnectionProfileOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to create a connection profile in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   CreateConnectionProfileRequest request =
   *       CreateConnectionProfileRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setConnectionProfileId("connectionProfileId597575526")
   *           .setConnectionProfile(ConnectionProfile.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .setForce(true)
   *           .build();
   *   OperationFuture<ConnectionProfile, OperationMetadata> future =
   *       datastreamClient.createConnectionProfileOperationCallable().futureCall(request);
   *   // Do something.
   *   ConnectionProfile response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateConnectionProfileRequest, ConnectionProfile, OperationMetadata>
      createConnectionProfileOperationCallable() {
    return stub.createConnectionProfileOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to create a connection profile in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   CreateConnectionProfileRequest request =
   *       CreateConnectionProfileRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setConnectionProfileId("connectionProfileId597575526")
   *           .setConnectionProfile(ConnectionProfile.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       datastreamClient.createConnectionProfileCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateConnectionProfileRequest, Operation>
      createConnectionProfileCallable() {
    return stub.createConnectionProfileCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to update the parameters of a connection profile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   ConnectionProfile connectionProfile = ConnectionProfile.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   ConnectionProfile response =
   *       datastreamClient.updateConnectionProfileAsync(connectionProfile, updateMask).get();
   * }
   * }</pre>
   *
   * @param connectionProfile Required. The connection profile to update.
   * @param updateMask Optional. Field mask is used to specify the fields to be overwritten in the
   *     ConnectionProfile resource by the update. The fields specified in the update_mask are
   *     relative to the resource, not the full request. A field will be overwritten if it is in the
   *     mask. If the user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ConnectionProfile, OperationMetadata> updateConnectionProfileAsync(
      ConnectionProfile connectionProfile, FieldMask updateMask) {
    UpdateConnectionProfileRequest request =
        UpdateConnectionProfileRequest.newBuilder()
            .setConnectionProfile(connectionProfile)
            .setUpdateMask(updateMask)
            .build();
    return updateConnectionProfileAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to update the parameters of a connection profile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   UpdateConnectionProfileRequest request =
   *       UpdateConnectionProfileRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setConnectionProfile(ConnectionProfile.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .setForce(true)
   *           .build();
   *   ConnectionProfile response = datastreamClient.updateConnectionProfileAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ConnectionProfile, OperationMetadata> updateConnectionProfileAsync(
      UpdateConnectionProfileRequest request) {
    return updateConnectionProfileOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to update the parameters of a connection profile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   UpdateConnectionProfileRequest request =
   *       UpdateConnectionProfileRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setConnectionProfile(ConnectionProfile.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .setForce(true)
   *           .build();
   *   OperationFuture<ConnectionProfile, OperationMetadata> future =
   *       datastreamClient.updateConnectionProfileOperationCallable().futureCall(request);
   *   // Do something.
   *   ConnectionProfile response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UpdateConnectionProfileRequest, ConnectionProfile, OperationMetadata>
      updateConnectionProfileOperationCallable() {
    return stub.updateConnectionProfileOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to update the parameters of a connection profile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   UpdateConnectionProfileRequest request =
   *       UpdateConnectionProfileRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setConnectionProfile(ConnectionProfile.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       datastreamClient.updateConnectionProfileCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateConnectionProfileRequest, Operation>
      updateConnectionProfileCallable() {
    return stub.updateConnectionProfileCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to delete a connection profile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   ConnectionProfileName name =
   *       ConnectionProfileName.of("[PROJECT]", "[LOCATION]", "[CONNECTION_PROFILE]");
   *   datastreamClient.deleteConnectionProfileAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the connection profile resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteConnectionProfileAsync(
      ConnectionProfileName name) {
    DeleteConnectionProfileRequest request =
        DeleteConnectionProfileRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteConnectionProfileAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to delete a connection profile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   String name =
   *       ConnectionProfileName.of("[PROJECT]", "[LOCATION]", "[CONNECTION_PROFILE]").toString();
   *   datastreamClient.deleteConnectionProfileAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the connection profile resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteConnectionProfileAsync(String name) {
    DeleteConnectionProfileRequest request =
        DeleteConnectionProfileRequest.newBuilder().setName(name).build();
    return deleteConnectionProfileAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to delete a connection profile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   DeleteConnectionProfileRequest request =
   *       DeleteConnectionProfileRequest.newBuilder()
   *           .setName(
   *               ConnectionProfileName.of("[PROJECT]", "[LOCATION]", "[CONNECTION_PROFILE]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   datastreamClient.deleteConnectionProfileAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteConnectionProfileAsync(
      DeleteConnectionProfileRequest request) {
    return deleteConnectionProfileOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to delete a connection profile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   DeleteConnectionProfileRequest request =
   *       DeleteConnectionProfileRequest.newBuilder()
   *           .setName(
   *               ConnectionProfileName.of("[PROJECT]", "[LOCATION]", "[CONNECTION_PROFILE]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       datastreamClient.deleteConnectionProfileOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteConnectionProfileRequest, Empty, OperationMetadata>
      deleteConnectionProfileOperationCallable() {
    return stub.deleteConnectionProfileOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to delete a connection profile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   DeleteConnectionProfileRequest request =
   *       DeleteConnectionProfileRequest.newBuilder()
   *           .setName(
   *               ConnectionProfileName.of("[PROJECT]", "[LOCATION]", "[CONNECTION_PROFILE]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       datastreamClient.deleteConnectionProfileCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteConnectionProfileRequest, Operation>
      deleteConnectionProfileCallable() {
    return stub.deleteConnectionProfileCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to discover a connection profile. The discover API call exposes the data
   * objects and metadata belonging to the profile. Typically, a request returns children data
   * objects of a parent data object that's optionally supplied in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   DiscoverConnectionProfileRequest request =
   *       DiscoverConnectionProfileRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   DiscoverConnectionProfileResponse response =
   *       datastreamClient.discoverConnectionProfile(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DiscoverConnectionProfileResponse discoverConnectionProfile(
      DiscoverConnectionProfileRequest request) {
    return discoverConnectionProfileCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to discover a connection profile. The discover API call exposes the data
   * objects and metadata belonging to the profile. Typically, a request returns children data
   * objects of a parent data object that's optionally supplied in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   DiscoverConnectionProfileRequest request =
   *       DiscoverConnectionProfileRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   ApiFuture<DiscoverConnectionProfileResponse> future =
   *       datastreamClient.discoverConnectionProfileCallable().futureCall(request);
   *   // Do something.
   *   DiscoverConnectionProfileResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DiscoverConnectionProfileRequest, DiscoverConnectionProfileResponse>
      discoverConnectionProfileCallable() {
    return stub.discoverConnectionProfileCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to list streams in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Stream element : datastreamClient.listStreams(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent that owns the collection of streams.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListStreamsPagedResponse listStreams(LocationName parent) {
    ListStreamsRequest request =
        ListStreamsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listStreams(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to list streams in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Stream element : datastreamClient.listStreams(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent that owns the collection of streams.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListStreamsPagedResponse listStreams(String parent) {
    ListStreamsRequest request = ListStreamsRequest.newBuilder().setParent(parent).build();
    return listStreams(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to list streams in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   ListStreamsRequest request =
   *       ListStreamsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Stream element : datastreamClient.listStreams(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListStreamsPagedResponse listStreams(ListStreamsRequest request) {
    return listStreamsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to list streams in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   ListStreamsRequest request =
   *       ListStreamsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Stream> future = datastreamClient.listStreamsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Stream element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListStreamsRequest, ListStreamsPagedResponse>
      listStreamsPagedCallable() {
    return stub.listStreamsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to list streams in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   ListStreamsRequest request =
   *       ListStreamsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListStreamsResponse response = datastreamClient.listStreamsCallable().call(request);
   *     for (Stream element : response.getStreamsList()) {
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
  public final UnaryCallable<ListStreamsRequest, ListStreamsResponse> listStreamsCallable() {
    return stub.listStreamsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to get details about a stream.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   StreamName name = StreamName.of("[PROJECT]", "[LOCATION]", "[STREAM]");
   *   Stream response = datastreamClient.getStream(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the stream resource to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Stream getStream(StreamName name) {
    GetStreamRequest request =
        GetStreamRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getStream(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to get details about a stream.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   String name = StreamName.of("[PROJECT]", "[LOCATION]", "[STREAM]").toString();
   *   Stream response = datastreamClient.getStream(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the stream resource to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Stream getStream(String name) {
    GetStreamRequest request = GetStreamRequest.newBuilder().setName(name).build();
    return getStream(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to get details about a stream.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   GetStreamRequest request =
   *       GetStreamRequest.newBuilder()
   *           .setName(StreamName.of("[PROJECT]", "[LOCATION]", "[STREAM]").toString())
   *           .build();
   *   Stream response = datastreamClient.getStream(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Stream getStream(GetStreamRequest request) {
    return getStreamCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to get details about a stream.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   GetStreamRequest request =
   *       GetStreamRequest.newBuilder()
   *           .setName(StreamName.of("[PROJECT]", "[LOCATION]", "[STREAM]").toString())
   *           .build();
   *   ApiFuture<Stream> future = datastreamClient.getStreamCallable().futureCall(request);
   *   // Do something.
   *   Stream response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetStreamRequest, Stream> getStreamCallable() {
    return stub.getStreamCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to create a stream.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Stream stream = Stream.newBuilder().build();
   *   String streamId = "streamId1790933179";
   *   Stream response = datastreamClient.createStreamAsync(parent, stream, streamId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent that owns the collection of streams.
   * @param stream Required. The stream resource to create.
   * @param streamId Required. The stream identifier.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Stream, OperationMetadata> createStreamAsync(
      LocationName parent, Stream stream, String streamId) {
    CreateStreamRequest request =
        CreateStreamRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setStream(stream)
            .setStreamId(streamId)
            .build();
    return createStreamAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to create a stream.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Stream stream = Stream.newBuilder().build();
   *   String streamId = "streamId1790933179";
   *   Stream response = datastreamClient.createStreamAsync(parent, stream, streamId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent that owns the collection of streams.
   * @param stream Required. The stream resource to create.
   * @param streamId Required. The stream identifier.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Stream, OperationMetadata> createStreamAsync(
      String parent, Stream stream, String streamId) {
    CreateStreamRequest request =
        CreateStreamRequest.newBuilder()
            .setParent(parent)
            .setStream(stream)
            .setStreamId(streamId)
            .build();
    return createStreamAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to create a stream.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   CreateStreamRequest request =
   *       CreateStreamRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setStreamId("streamId1790933179")
   *           .setStream(Stream.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .setForce(true)
   *           .build();
   *   Stream response = datastreamClient.createStreamAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Stream, OperationMetadata> createStreamAsync(
      CreateStreamRequest request) {
    return createStreamOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to create a stream.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   CreateStreamRequest request =
   *       CreateStreamRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setStreamId("streamId1790933179")
   *           .setStream(Stream.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .setForce(true)
   *           .build();
   *   OperationFuture<Stream, OperationMetadata> future =
   *       datastreamClient.createStreamOperationCallable().futureCall(request);
   *   // Do something.
   *   Stream response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateStreamRequest, Stream, OperationMetadata>
      createStreamOperationCallable() {
    return stub.createStreamOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to create a stream.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   CreateStreamRequest request =
   *       CreateStreamRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setStreamId("streamId1790933179")
   *           .setStream(Stream.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Operation> future = datastreamClient.createStreamCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateStreamRequest, Operation> createStreamCallable() {
    return stub.createStreamCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to update the configuration of a stream.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   Stream stream = Stream.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Stream response = datastreamClient.updateStreamAsync(stream, updateMask).get();
   * }
   * }</pre>
   *
   * @param stream Required. The stream resource to update.
   * @param updateMask Optional. Field mask is used to specify the fields to be overwritten in the
   *     stream resource by the update. The fields specified in the update_mask are relative to the
   *     resource, not the full request. A field will be overwritten if it is in the mask. If the
   *     user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Stream, OperationMetadata> updateStreamAsync(
      Stream stream, FieldMask updateMask) {
    UpdateStreamRequest request =
        UpdateStreamRequest.newBuilder().setStream(stream).setUpdateMask(updateMask).build();
    return updateStreamAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to update the configuration of a stream.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   UpdateStreamRequest request =
   *       UpdateStreamRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setStream(Stream.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .setForce(true)
   *           .build();
   *   Stream response = datastreamClient.updateStreamAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Stream, OperationMetadata> updateStreamAsync(
      UpdateStreamRequest request) {
    return updateStreamOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to update the configuration of a stream.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   UpdateStreamRequest request =
   *       UpdateStreamRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setStream(Stream.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .setForce(true)
   *           .build();
   *   OperationFuture<Stream, OperationMetadata> future =
   *       datastreamClient.updateStreamOperationCallable().futureCall(request);
   *   // Do something.
   *   Stream response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateStreamRequest, Stream, OperationMetadata>
      updateStreamOperationCallable() {
    return stub.updateStreamOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to update the configuration of a stream.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   UpdateStreamRequest request =
   *       UpdateStreamRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setStream(Stream.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Operation> future = datastreamClient.updateStreamCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateStreamRequest, Operation> updateStreamCallable() {
    return stub.updateStreamCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to delete a stream.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   StreamName name = StreamName.of("[PROJECT]", "[LOCATION]", "[STREAM]");
   *   datastreamClient.deleteStreamAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the stream resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteStreamAsync(StreamName name) {
    DeleteStreamRequest request =
        DeleteStreamRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteStreamAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to delete a stream.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   String name = StreamName.of("[PROJECT]", "[LOCATION]", "[STREAM]").toString();
   *   datastreamClient.deleteStreamAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the stream resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteStreamAsync(String name) {
    DeleteStreamRequest request = DeleteStreamRequest.newBuilder().setName(name).build();
    return deleteStreamAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to delete a stream.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   DeleteStreamRequest request =
   *       DeleteStreamRequest.newBuilder()
   *           .setName(StreamName.of("[PROJECT]", "[LOCATION]", "[STREAM]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   datastreamClient.deleteStreamAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteStreamAsync(
      DeleteStreamRequest request) {
    return deleteStreamOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to delete a stream.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   DeleteStreamRequest request =
   *       DeleteStreamRequest.newBuilder()
   *           .setName(StreamName.of("[PROJECT]", "[LOCATION]", "[STREAM]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       datastreamClient.deleteStreamOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteStreamRequest, Empty, OperationMetadata>
      deleteStreamOperationCallable() {
    return stub.deleteStreamOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to delete a stream.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   DeleteStreamRequest request =
   *       DeleteStreamRequest.newBuilder()
   *           .setName(StreamName.of("[PROJECT]", "[LOCATION]", "[STREAM]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = datastreamClient.deleteStreamCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteStreamRequest, Operation> deleteStreamCallable() {
    return stub.deleteStreamCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to get details about a stream object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   StreamObjectName name =
   *       StreamObjectName.of("[PROJECT]", "[LOCATION]", "[STREAM]", "[OBJECT]");
   *   StreamObject response = datastreamClient.getStreamObject(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the stream object resource to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final StreamObject getStreamObject(StreamObjectName name) {
    GetStreamObjectRequest request =
        GetStreamObjectRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getStreamObject(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to get details about a stream object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   String name =
   *       StreamObjectName.of("[PROJECT]", "[LOCATION]", "[STREAM]", "[OBJECT]").toString();
   *   StreamObject response = datastreamClient.getStreamObject(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the stream object resource to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final StreamObject getStreamObject(String name) {
    GetStreamObjectRequest request = GetStreamObjectRequest.newBuilder().setName(name).build();
    return getStreamObject(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to get details about a stream object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   GetStreamObjectRequest request =
   *       GetStreamObjectRequest.newBuilder()
   *           .setName(
   *               StreamObjectName.of("[PROJECT]", "[LOCATION]", "[STREAM]", "[OBJECT]").toString())
   *           .build();
   *   StreamObject response = datastreamClient.getStreamObject(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final StreamObject getStreamObject(GetStreamObjectRequest request) {
    return getStreamObjectCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to get details about a stream object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   GetStreamObjectRequest request =
   *       GetStreamObjectRequest.newBuilder()
   *           .setName(
   *               StreamObjectName.of("[PROJECT]", "[LOCATION]", "[STREAM]", "[OBJECT]").toString())
   *           .build();
   *   ApiFuture<StreamObject> future =
   *       datastreamClient.getStreamObjectCallable().futureCall(request);
   *   // Do something.
   *   StreamObject response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetStreamObjectRequest, StreamObject> getStreamObjectCallable() {
    return stub.getStreamObjectCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to look up a stream object by its source object identifier.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   LookupStreamObjectRequest request =
   *       LookupStreamObjectRequest.newBuilder()
   *           .setParent(StreamName.of("[PROJECT]", "[LOCATION]", "[STREAM]").toString())
   *           .setSourceObjectIdentifier(SourceObjectIdentifier.newBuilder().build())
   *           .build();
   *   StreamObject response = datastreamClient.lookupStreamObject(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final StreamObject lookupStreamObject(LookupStreamObjectRequest request) {
    return lookupStreamObjectCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to look up a stream object by its source object identifier.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   LookupStreamObjectRequest request =
   *       LookupStreamObjectRequest.newBuilder()
   *           .setParent(StreamName.of("[PROJECT]", "[LOCATION]", "[STREAM]").toString())
   *           .setSourceObjectIdentifier(SourceObjectIdentifier.newBuilder().build())
   *           .build();
   *   ApiFuture<StreamObject> future =
   *       datastreamClient.lookupStreamObjectCallable().futureCall(request);
   *   // Do something.
   *   StreamObject response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<LookupStreamObjectRequest, StreamObject> lookupStreamObjectCallable() {
    return stub.lookupStreamObjectCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to list the objects of a specific stream.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   StreamName parent = StreamName.of("[PROJECT]", "[LOCATION]", "[STREAM]");
   *   for (StreamObject element : datastreamClient.listStreamObjects(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent stream that owns the collection of objects.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListStreamObjectsPagedResponse listStreamObjects(StreamName parent) {
    ListStreamObjectsRequest request =
        ListStreamObjectsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listStreamObjects(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to list the objects of a specific stream.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   String parent = StreamName.of("[PROJECT]", "[LOCATION]", "[STREAM]").toString();
   *   for (StreamObject element : datastreamClient.listStreamObjects(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent stream that owns the collection of objects.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListStreamObjectsPagedResponse listStreamObjects(String parent) {
    ListStreamObjectsRequest request =
        ListStreamObjectsRequest.newBuilder().setParent(parent).build();
    return listStreamObjects(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to list the objects of a specific stream.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   ListStreamObjectsRequest request =
   *       ListStreamObjectsRequest.newBuilder()
   *           .setParent(StreamName.of("[PROJECT]", "[LOCATION]", "[STREAM]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (StreamObject element : datastreamClient.listStreamObjects(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListStreamObjectsPagedResponse listStreamObjects(ListStreamObjectsRequest request) {
    return listStreamObjectsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to list the objects of a specific stream.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   ListStreamObjectsRequest request =
   *       ListStreamObjectsRequest.newBuilder()
   *           .setParent(StreamName.of("[PROJECT]", "[LOCATION]", "[STREAM]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<StreamObject> future =
   *       datastreamClient.listStreamObjectsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (StreamObject element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListStreamObjectsRequest, ListStreamObjectsPagedResponse>
      listStreamObjectsPagedCallable() {
    return stub.listStreamObjectsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to list the objects of a specific stream.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   ListStreamObjectsRequest request =
   *       ListStreamObjectsRequest.newBuilder()
   *           .setParent(StreamName.of("[PROJECT]", "[LOCATION]", "[STREAM]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListStreamObjectsResponse response =
   *         datastreamClient.listStreamObjectsCallable().call(request);
   *     for (StreamObject element : response.getStreamObjectsList()) {
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
  public final UnaryCallable<ListStreamObjectsRequest, ListStreamObjectsResponse>
      listStreamObjectsCallable() {
    return stub.listStreamObjectsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to start a backfill job for the specified stream object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   StreamObjectName object =
   *       StreamObjectName.of("[PROJECT]", "[LOCATION]", "[STREAM]", "[OBJECT]");
   *   StartBackfillJobResponse response = datastreamClient.startBackfillJob(object);
   * }
   * }</pre>
   *
   * @param object Required. The name of the stream object resource to start a backfill job for.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final StartBackfillJobResponse startBackfillJob(StreamObjectName object) {
    StartBackfillJobRequest request =
        StartBackfillJobRequest.newBuilder()
            .setObject(object == null ? null : object.toString())
            .build();
    return startBackfillJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to start a backfill job for the specified stream object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   String object =
   *       StreamObjectName.of("[PROJECT]", "[LOCATION]", "[STREAM]", "[OBJECT]").toString();
   *   StartBackfillJobResponse response = datastreamClient.startBackfillJob(object);
   * }
   * }</pre>
   *
   * @param object Required. The name of the stream object resource to start a backfill job for.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final StartBackfillJobResponse startBackfillJob(String object) {
    StartBackfillJobRequest request =
        StartBackfillJobRequest.newBuilder().setObject(object).build();
    return startBackfillJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to start a backfill job for the specified stream object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   StartBackfillJobRequest request =
   *       StartBackfillJobRequest.newBuilder()
   *           .setObject(
   *               StreamObjectName.of("[PROJECT]", "[LOCATION]", "[STREAM]", "[OBJECT]").toString())
   *           .build();
   *   StartBackfillJobResponse response = datastreamClient.startBackfillJob(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final StartBackfillJobResponse startBackfillJob(StartBackfillJobRequest request) {
    return startBackfillJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to start a backfill job for the specified stream object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   StartBackfillJobRequest request =
   *       StartBackfillJobRequest.newBuilder()
   *           .setObject(
   *               StreamObjectName.of("[PROJECT]", "[LOCATION]", "[STREAM]", "[OBJECT]").toString())
   *           .build();
   *   ApiFuture<StartBackfillJobResponse> future =
   *       datastreamClient.startBackfillJobCallable().futureCall(request);
   *   // Do something.
   *   StartBackfillJobResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<StartBackfillJobRequest, StartBackfillJobResponse>
      startBackfillJobCallable() {
    return stub.startBackfillJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to stop a backfill job for the specified stream object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   StreamObjectName object =
   *       StreamObjectName.of("[PROJECT]", "[LOCATION]", "[STREAM]", "[OBJECT]");
   *   StopBackfillJobResponse response = datastreamClient.stopBackfillJob(object);
   * }
   * }</pre>
   *
   * @param object Required. The name of the stream object resource to stop the backfill job for.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final StopBackfillJobResponse stopBackfillJob(StreamObjectName object) {
    StopBackfillJobRequest request =
        StopBackfillJobRequest.newBuilder()
            .setObject(object == null ? null : object.toString())
            .build();
    return stopBackfillJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to stop a backfill job for the specified stream object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   String object =
   *       StreamObjectName.of("[PROJECT]", "[LOCATION]", "[STREAM]", "[OBJECT]").toString();
   *   StopBackfillJobResponse response = datastreamClient.stopBackfillJob(object);
   * }
   * }</pre>
   *
   * @param object Required. The name of the stream object resource to stop the backfill job for.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final StopBackfillJobResponse stopBackfillJob(String object) {
    StopBackfillJobRequest request = StopBackfillJobRequest.newBuilder().setObject(object).build();
    return stopBackfillJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to stop a backfill job for the specified stream object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   StopBackfillJobRequest request =
   *       StopBackfillJobRequest.newBuilder()
   *           .setObject(
   *               StreamObjectName.of("[PROJECT]", "[LOCATION]", "[STREAM]", "[OBJECT]").toString())
   *           .build();
   *   StopBackfillJobResponse response = datastreamClient.stopBackfillJob(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final StopBackfillJobResponse stopBackfillJob(StopBackfillJobRequest request) {
    return stopBackfillJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to stop a backfill job for the specified stream object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   StopBackfillJobRequest request =
   *       StopBackfillJobRequest.newBuilder()
   *           .setObject(
   *               StreamObjectName.of("[PROJECT]", "[LOCATION]", "[STREAM]", "[OBJECT]").toString())
   *           .build();
   *   ApiFuture<StopBackfillJobResponse> future =
   *       datastreamClient.stopBackfillJobCallable().futureCall(request);
   *   // Do something.
   *   StopBackfillJobResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<StopBackfillJobRequest, StopBackfillJobResponse>
      stopBackfillJobCallable() {
    return stub.stopBackfillJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * The FetchStaticIps API call exposes the static IP addresses used by Datastream.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   LocationName name = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (String element : datastreamClient.fetchStaticIps(name).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param name Required. The resource name for the location for which static IPs should be
   *     returned. Must be in the format `projects/&#42;/locations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchStaticIpsPagedResponse fetchStaticIps(LocationName name) {
    FetchStaticIpsRequest request =
        FetchStaticIpsRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return fetchStaticIps(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * The FetchStaticIps API call exposes the static IP addresses used by Datastream.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   String name = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (String element : datastreamClient.fetchStaticIps(name).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param name Required. The resource name for the location for which static IPs should be
   *     returned. Must be in the format `projects/&#42;/locations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchStaticIpsPagedResponse fetchStaticIps(String name) {
    FetchStaticIpsRequest request = FetchStaticIpsRequest.newBuilder().setName(name).build();
    return fetchStaticIps(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * The FetchStaticIps API call exposes the static IP addresses used by Datastream.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   FetchStaticIpsRequest request =
   *       FetchStaticIpsRequest.newBuilder()
   *           .setName(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (String element : datastreamClient.fetchStaticIps(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchStaticIpsPagedResponse fetchStaticIps(FetchStaticIpsRequest request) {
    return fetchStaticIpsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * The FetchStaticIps API call exposes the static IP addresses used by Datastream.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   FetchStaticIpsRequest request =
   *       FetchStaticIpsRequest.newBuilder()
   *           .setName(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<String> future = datastreamClient.fetchStaticIpsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (String element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<FetchStaticIpsRequest, FetchStaticIpsPagedResponse>
      fetchStaticIpsPagedCallable() {
    return stub.fetchStaticIpsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * The FetchStaticIps API call exposes the static IP addresses used by Datastream.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   FetchStaticIpsRequest request =
   *       FetchStaticIpsRequest.newBuilder()
   *           .setName(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     FetchStaticIpsResponse response = datastreamClient.fetchStaticIpsCallable().call(request);
   *     for (String element : response.getStaticIpsList()) {
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
  public final UnaryCallable<FetchStaticIpsRequest, FetchStaticIpsResponse>
      fetchStaticIpsCallable() {
    return stub.fetchStaticIpsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to create a private connectivity configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   PrivateConnection privateConnection = PrivateConnection.newBuilder().build();
   *   String privateConnectionId = "privateConnectionId-1926654532";
   *   PrivateConnection response =
   *       datastreamClient
   *           .createPrivateConnectionAsync(parent, privateConnection, privateConnectionId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent that owns the collection of PrivateConnections.
   * @param privateConnection Required. The Private Connectivity resource to create.
   * @param privateConnectionId Required. The private connectivity identifier.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PrivateConnection, OperationMetadata> createPrivateConnectionAsync(
      LocationName parent, PrivateConnection privateConnection, String privateConnectionId) {
    CreatePrivateConnectionRequest request =
        CreatePrivateConnectionRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setPrivateConnection(privateConnection)
            .setPrivateConnectionId(privateConnectionId)
            .build();
    return createPrivateConnectionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to create a private connectivity configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   PrivateConnection privateConnection = PrivateConnection.newBuilder().build();
   *   String privateConnectionId = "privateConnectionId-1926654532";
   *   PrivateConnection response =
   *       datastreamClient
   *           .createPrivateConnectionAsync(parent, privateConnection, privateConnectionId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent that owns the collection of PrivateConnections.
   * @param privateConnection Required. The Private Connectivity resource to create.
   * @param privateConnectionId Required. The private connectivity identifier.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PrivateConnection, OperationMetadata> createPrivateConnectionAsync(
      String parent, PrivateConnection privateConnection, String privateConnectionId) {
    CreatePrivateConnectionRequest request =
        CreatePrivateConnectionRequest.newBuilder()
            .setParent(parent)
            .setPrivateConnection(privateConnection)
            .setPrivateConnectionId(privateConnectionId)
            .build();
    return createPrivateConnectionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to create a private connectivity configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   CreatePrivateConnectionRequest request =
   *       CreatePrivateConnectionRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPrivateConnectionId("privateConnectionId-1926654532")
   *           .setPrivateConnection(PrivateConnection.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   PrivateConnection response = datastreamClient.createPrivateConnectionAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PrivateConnection, OperationMetadata> createPrivateConnectionAsync(
      CreatePrivateConnectionRequest request) {
    return createPrivateConnectionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to create a private connectivity configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   CreatePrivateConnectionRequest request =
   *       CreatePrivateConnectionRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPrivateConnectionId("privateConnectionId-1926654532")
   *           .setPrivateConnection(PrivateConnection.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<PrivateConnection, OperationMetadata> future =
   *       datastreamClient.createPrivateConnectionOperationCallable().futureCall(request);
   *   // Do something.
   *   PrivateConnection response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreatePrivateConnectionRequest, PrivateConnection, OperationMetadata>
      createPrivateConnectionOperationCallable() {
    return stub.createPrivateConnectionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to create a private connectivity configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   CreatePrivateConnectionRequest request =
   *       CreatePrivateConnectionRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPrivateConnectionId("privateConnectionId-1926654532")
   *           .setPrivateConnection(PrivateConnection.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       datastreamClient.createPrivateConnectionCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreatePrivateConnectionRequest, Operation>
      createPrivateConnectionCallable() {
    return stub.createPrivateConnectionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to get details about a private connectivity configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   PrivateConnectionName name =
   *       PrivateConnectionName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]");
   *   PrivateConnection response = datastreamClient.getPrivateConnection(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the private connectivity configuration to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PrivateConnection getPrivateConnection(PrivateConnectionName name) {
    GetPrivateConnectionRequest request =
        GetPrivateConnectionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getPrivateConnection(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to get details about a private connectivity configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   String name =
   *       PrivateConnectionName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]").toString();
   *   PrivateConnection response = datastreamClient.getPrivateConnection(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the private connectivity configuration to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PrivateConnection getPrivateConnection(String name) {
    GetPrivateConnectionRequest request =
        GetPrivateConnectionRequest.newBuilder().setName(name).build();
    return getPrivateConnection(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to get details about a private connectivity configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   GetPrivateConnectionRequest request =
   *       GetPrivateConnectionRequest.newBuilder()
   *           .setName(
   *               PrivateConnectionName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]")
   *                   .toString())
   *           .build();
   *   PrivateConnection response = datastreamClient.getPrivateConnection(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PrivateConnection getPrivateConnection(GetPrivateConnectionRequest request) {
    return getPrivateConnectionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to get details about a private connectivity configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   GetPrivateConnectionRequest request =
   *       GetPrivateConnectionRequest.newBuilder()
   *           .setName(
   *               PrivateConnectionName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<PrivateConnection> future =
   *       datastreamClient.getPrivateConnectionCallable().futureCall(request);
   *   // Do something.
   *   PrivateConnection response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetPrivateConnectionRequest, PrivateConnection>
      getPrivateConnectionCallable() {
    return stub.getPrivateConnectionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to list private connectivity configurations in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (PrivateConnection element :
   *       datastreamClient.listPrivateConnections(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent that owns the collection of private connectivity
   *     configurations.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPrivateConnectionsPagedResponse listPrivateConnections(LocationName parent) {
    ListPrivateConnectionsRequest request =
        ListPrivateConnectionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listPrivateConnections(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to list private connectivity configurations in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (PrivateConnection element :
   *       datastreamClient.listPrivateConnections(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent that owns the collection of private connectivity
   *     configurations.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPrivateConnectionsPagedResponse listPrivateConnections(String parent) {
    ListPrivateConnectionsRequest request =
        ListPrivateConnectionsRequest.newBuilder().setParent(parent).build();
    return listPrivateConnections(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to list private connectivity configurations in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   ListPrivateConnectionsRequest request =
   *       ListPrivateConnectionsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (PrivateConnection element :
   *       datastreamClient.listPrivateConnections(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPrivateConnectionsPagedResponse listPrivateConnections(
      ListPrivateConnectionsRequest request) {
    return listPrivateConnectionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to list private connectivity configurations in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   ListPrivateConnectionsRequest request =
   *       ListPrivateConnectionsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<PrivateConnection> future =
   *       datastreamClient.listPrivateConnectionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (PrivateConnection element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListPrivateConnectionsRequest, ListPrivateConnectionsPagedResponse>
      listPrivateConnectionsPagedCallable() {
    return stub.listPrivateConnectionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to list private connectivity configurations in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   ListPrivateConnectionsRequest request =
   *       ListPrivateConnectionsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListPrivateConnectionsResponse response =
   *         datastreamClient.listPrivateConnectionsCallable().call(request);
   *     for (PrivateConnection element : response.getPrivateConnectionsList()) {
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
  public final UnaryCallable<ListPrivateConnectionsRequest, ListPrivateConnectionsResponse>
      listPrivateConnectionsCallable() {
    return stub.listPrivateConnectionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to delete a private connectivity configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   PrivateConnectionName name =
   *       PrivateConnectionName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]");
   *   datastreamClient.deletePrivateConnectionAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the private connectivity configuration to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deletePrivateConnectionAsync(
      PrivateConnectionName name) {
    DeletePrivateConnectionRequest request =
        DeletePrivateConnectionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deletePrivateConnectionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to delete a private connectivity configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   String name =
   *       PrivateConnectionName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]").toString();
   *   datastreamClient.deletePrivateConnectionAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the private connectivity configuration to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deletePrivateConnectionAsync(String name) {
    DeletePrivateConnectionRequest request =
        DeletePrivateConnectionRequest.newBuilder().setName(name).build();
    return deletePrivateConnectionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to delete a private connectivity configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   DeletePrivateConnectionRequest request =
   *       DeletePrivateConnectionRequest.newBuilder()
   *           .setName(
   *               PrivateConnectionName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .build();
   *   datastreamClient.deletePrivateConnectionAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deletePrivateConnectionAsync(
      DeletePrivateConnectionRequest request) {
    return deletePrivateConnectionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to delete a private connectivity configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   DeletePrivateConnectionRequest request =
   *       DeletePrivateConnectionRequest.newBuilder()
   *           .setName(
   *               PrivateConnectionName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       datastreamClient.deletePrivateConnectionOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeletePrivateConnectionRequest, Empty, OperationMetadata>
      deletePrivateConnectionOperationCallable() {
    return stub.deletePrivateConnectionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to delete a private connectivity configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   DeletePrivateConnectionRequest request =
   *       DeletePrivateConnectionRequest.newBuilder()
   *           .setName(
   *               PrivateConnectionName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       datastreamClient.deletePrivateConnectionCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeletePrivateConnectionRequest, Operation>
      deletePrivateConnectionCallable() {
    return stub.deletePrivateConnectionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to create a route for a private connectivity configuration in a project and
   * location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   PrivateConnectionName parent =
   *       PrivateConnectionName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]");
   *   Route route = Route.newBuilder().build();
   *   String routeId = "routeId1385647428";
   *   Route response = datastreamClient.createRouteAsync(parent, route, routeId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent that owns the collection of Routes.
   * @param route Required. The Route resource to create.
   * @param routeId Required. The Route identifier.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Route, OperationMetadata> createRouteAsync(
      PrivateConnectionName parent, Route route, String routeId) {
    CreateRouteRequest request =
        CreateRouteRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setRoute(route)
            .setRouteId(routeId)
            .build();
    return createRouteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to create a route for a private connectivity configuration in a project and
   * location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   String parent =
   *       PrivateConnectionName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]").toString();
   *   Route route = Route.newBuilder().build();
   *   String routeId = "routeId1385647428";
   *   Route response = datastreamClient.createRouteAsync(parent, route, routeId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent that owns the collection of Routes.
   * @param route Required. The Route resource to create.
   * @param routeId Required. The Route identifier.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Route, OperationMetadata> createRouteAsync(
      String parent, Route route, String routeId) {
    CreateRouteRequest request =
        CreateRouteRequest.newBuilder()
            .setParent(parent)
            .setRoute(route)
            .setRouteId(routeId)
            .build();
    return createRouteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to create a route for a private connectivity configuration in a project and
   * location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   CreateRouteRequest request =
   *       CreateRouteRequest.newBuilder()
   *           .setParent(
   *               PrivateConnectionName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]")
   *                   .toString())
   *           .setRouteId("routeId1385647428")
   *           .setRoute(Route.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Route response = datastreamClient.createRouteAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Route, OperationMetadata> createRouteAsync(
      CreateRouteRequest request) {
    return createRouteOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to create a route for a private connectivity configuration in a project and
   * location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   CreateRouteRequest request =
   *       CreateRouteRequest.newBuilder()
   *           .setParent(
   *               PrivateConnectionName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]")
   *                   .toString())
   *           .setRouteId("routeId1385647428")
   *           .setRoute(Route.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Route, OperationMetadata> future =
   *       datastreamClient.createRouteOperationCallable().futureCall(request);
   *   // Do something.
   *   Route response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateRouteRequest, Route, OperationMetadata>
      createRouteOperationCallable() {
    return stub.createRouteOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to create a route for a private connectivity configuration in a project and
   * location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   CreateRouteRequest request =
   *       CreateRouteRequest.newBuilder()
   *           .setParent(
   *               PrivateConnectionName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]")
   *                   .toString())
   *           .setRouteId("routeId1385647428")
   *           .setRoute(Route.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = datastreamClient.createRouteCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateRouteRequest, Operation> createRouteCallable() {
    return stub.createRouteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to get details about a route.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   RouteName name = RouteName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]", "[ROUTE]");
   *   Route response = datastreamClient.getRoute(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Route resource to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Route getRoute(RouteName name) {
    GetRouteRequest request =
        GetRouteRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getRoute(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to get details about a route.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   String name =
   *       RouteName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]", "[ROUTE]").toString();
   *   Route response = datastreamClient.getRoute(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Route resource to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Route getRoute(String name) {
    GetRouteRequest request = GetRouteRequest.newBuilder().setName(name).build();
    return getRoute(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to get details about a route.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   GetRouteRequest request =
   *       GetRouteRequest.newBuilder()
   *           .setName(
   *               RouteName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]", "[ROUTE]")
   *                   .toString())
   *           .build();
   *   Route response = datastreamClient.getRoute(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Route getRoute(GetRouteRequest request) {
    return getRouteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to get details about a route.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   GetRouteRequest request =
   *       GetRouteRequest.newBuilder()
   *           .setName(
   *               RouteName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]", "[ROUTE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Route> future = datastreamClient.getRouteCallable().futureCall(request);
   *   // Do something.
   *   Route response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRouteRequest, Route> getRouteCallable() {
    return stub.getRouteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to list routes created for a private connectivity configuration in a project
   * and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   PrivateConnectionName parent =
   *       PrivateConnectionName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]");
   *   for (Route element : datastreamClient.listRoutes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent that owns the collection of Routess.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRoutesPagedResponse listRoutes(PrivateConnectionName parent) {
    ListRoutesRequest request =
        ListRoutesRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listRoutes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to list routes created for a private connectivity configuration in a project
   * and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   String parent =
   *       PrivateConnectionName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]").toString();
   *   for (Route element : datastreamClient.listRoutes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent that owns the collection of Routess.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRoutesPagedResponse listRoutes(String parent) {
    ListRoutesRequest request = ListRoutesRequest.newBuilder().setParent(parent).build();
    return listRoutes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to list routes created for a private connectivity configuration in a project
   * and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   ListRoutesRequest request =
   *       ListRoutesRequest.newBuilder()
   *           .setParent(
   *               PrivateConnectionName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Route element : datastreamClient.listRoutes(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRoutesPagedResponse listRoutes(ListRoutesRequest request) {
    return listRoutesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to list routes created for a private connectivity configuration in a project
   * and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   ListRoutesRequest request =
   *       ListRoutesRequest.newBuilder()
   *           .setParent(
   *               PrivateConnectionName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Route> future = datastreamClient.listRoutesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Route element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListRoutesRequest, ListRoutesPagedResponse> listRoutesPagedCallable() {
    return stub.listRoutesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to list routes created for a private connectivity configuration in a project
   * and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   ListRoutesRequest request =
   *       ListRoutesRequest.newBuilder()
   *           .setParent(
   *               PrivateConnectionName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListRoutesResponse response = datastreamClient.listRoutesCallable().call(request);
   *     for (Route element : response.getRoutesList()) {
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
  public final UnaryCallable<ListRoutesRequest, ListRoutesResponse> listRoutesCallable() {
    return stub.listRoutesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to delete a route.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   RouteName name = RouteName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]", "[ROUTE]");
   *   datastreamClient.deleteRouteAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the Route resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteRouteAsync(RouteName name) {
    DeleteRouteRequest request =
        DeleteRouteRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteRouteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to delete a route.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   String name =
   *       RouteName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]", "[ROUTE]").toString();
   *   datastreamClient.deleteRouteAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the Route resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteRouteAsync(String name) {
    DeleteRouteRequest request = DeleteRouteRequest.newBuilder().setName(name).build();
    return deleteRouteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to delete a route.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   DeleteRouteRequest request =
   *       DeleteRouteRequest.newBuilder()
   *           .setName(
   *               RouteName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]", "[ROUTE]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   datastreamClient.deleteRouteAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteRouteAsync(
      DeleteRouteRequest request) {
    return deleteRouteOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to delete a route.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   DeleteRouteRequest request =
   *       DeleteRouteRequest.newBuilder()
   *           .setName(
   *               RouteName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]", "[ROUTE]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       datastreamClient.deleteRouteOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteRouteRequest, Empty, OperationMetadata>
      deleteRouteOperationCallable() {
    return stub.deleteRouteOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Use this method to delete a route.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   DeleteRouteRequest request =
   *       DeleteRouteRequest.newBuilder()
   *           .setName(
   *               RouteName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]", "[ROUTE]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = datastreamClient.deleteRouteCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteRouteRequest, Operation> deleteRouteCallable() {
    return stub.deleteRouteCallable();
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
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : datastreamClient.listLocations(request).iterateAll()) {
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
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       datastreamClient.listLocationsPagedCallable().futureCall(request);
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
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = datastreamClient.listLocationsCallable().call(request);
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
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = datastreamClient.getLocation(request);
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
   * try (DatastreamClient datastreamClient = DatastreamClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = datastreamClient.getLocationCallable().futureCall(request);
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

  public static class ListConnectionProfilesPagedResponse
      extends AbstractPagedListResponse<
          ListConnectionProfilesRequest,
          ListConnectionProfilesResponse,
          ConnectionProfile,
          ListConnectionProfilesPage,
          ListConnectionProfilesFixedSizeCollection> {

    public static ApiFuture<ListConnectionProfilesPagedResponse> createAsync(
        PageContext<
                ListConnectionProfilesRequest, ListConnectionProfilesResponse, ConnectionProfile>
            context,
        ApiFuture<ListConnectionProfilesResponse> futureResponse) {
      ApiFuture<ListConnectionProfilesPage> futurePage =
          ListConnectionProfilesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListConnectionProfilesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListConnectionProfilesPagedResponse(ListConnectionProfilesPage page) {
      super(page, ListConnectionProfilesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListConnectionProfilesPage
      extends AbstractPage<
          ListConnectionProfilesRequest,
          ListConnectionProfilesResponse,
          ConnectionProfile,
          ListConnectionProfilesPage> {

    private ListConnectionProfilesPage(
        PageContext<
                ListConnectionProfilesRequest, ListConnectionProfilesResponse, ConnectionProfile>
            context,
        ListConnectionProfilesResponse response) {
      super(context, response);
    }

    private static ListConnectionProfilesPage createEmptyPage() {
      return new ListConnectionProfilesPage(null, null);
    }

    @Override
    protected ListConnectionProfilesPage createPage(
        PageContext<
                ListConnectionProfilesRequest, ListConnectionProfilesResponse, ConnectionProfile>
            context,
        ListConnectionProfilesResponse response) {
      return new ListConnectionProfilesPage(context, response);
    }

    @Override
    public ApiFuture<ListConnectionProfilesPage> createPageAsync(
        PageContext<
                ListConnectionProfilesRequest, ListConnectionProfilesResponse, ConnectionProfile>
            context,
        ApiFuture<ListConnectionProfilesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListConnectionProfilesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListConnectionProfilesRequest,
          ListConnectionProfilesResponse,
          ConnectionProfile,
          ListConnectionProfilesPage,
          ListConnectionProfilesFixedSizeCollection> {

    private ListConnectionProfilesFixedSizeCollection(
        List<ListConnectionProfilesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListConnectionProfilesFixedSizeCollection createEmptyCollection() {
      return new ListConnectionProfilesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListConnectionProfilesFixedSizeCollection createCollection(
        List<ListConnectionProfilesPage> pages, int collectionSize) {
      return new ListConnectionProfilesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListStreamsPagedResponse
      extends AbstractPagedListResponse<
          ListStreamsRequest,
          ListStreamsResponse,
          Stream,
          ListStreamsPage,
          ListStreamsFixedSizeCollection> {

    public static ApiFuture<ListStreamsPagedResponse> createAsync(
        PageContext<ListStreamsRequest, ListStreamsResponse, Stream> context,
        ApiFuture<ListStreamsResponse> futureResponse) {
      ApiFuture<ListStreamsPage> futurePage =
          ListStreamsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListStreamsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListStreamsPagedResponse(ListStreamsPage page) {
      super(page, ListStreamsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListStreamsPage
      extends AbstractPage<ListStreamsRequest, ListStreamsResponse, Stream, ListStreamsPage> {

    private ListStreamsPage(
        PageContext<ListStreamsRequest, ListStreamsResponse, Stream> context,
        ListStreamsResponse response) {
      super(context, response);
    }

    private static ListStreamsPage createEmptyPage() {
      return new ListStreamsPage(null, null);
    }

    @Override
    protected ListStreamsPage createPage(
        PageContext<ListStreamsRequest, ListStreamsResponse, Stream> context,
        ListStreamsResponse response) {
      return new ListStreamsPage(context, response);
    }

    @Override
    public ApiFuture<ListStreamsPage> createPageAsync(
        PageContext<ListStreamsRequest, ListStreamsResponse, Stream> context,
        ApiFuture<ListStreamsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListStreamsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListStreamsRequest,
          ListStreamsResponse,
          Stream,
          ListStreamsPage,
          ListStreamsFixedSizeCollection> {

    private ListStreamsFixedSizeCollection(List<ListStreamsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListStreamsFixedSizeCollection createEmptyCollection() {
      return new ListStreamsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListStreamsFixedSizeCollection createCollection(
        List<ListStreamsPage> pages, int collectionSize) {
      return new ListStreamsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListStreamObjectsPagedResponse
      extends AbstractPagedListResponse<
          ListStreamObjectsRequest,
          ListStreamObjectsResponse,
          StreamObject,
          ListStreamObjectsPage,
          ListStreamObjectsFixedSizeCollection> {

    public static ApiFuture<ListStreamObjectsPagedResponse> createAsync(
        PageContext<ListStreamObjectsRequest, ListStreamObjectsResponse, StreamObject> context,
        ApiFuture<ListStreamObjectsResponse> futureResponse) {
      ApiFuture<ListStreamObjectsPage> futurePage =
          ListStreamObjectsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListStreamObjectsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListStreamObjectsPagedResponse(ListStreamObjectsPage page) {
      super(page, ListStreamObjectsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListStreamObjectsPage
      extends AbstractPage<
          ListStreamObjectsRequest,
          ListStreamObjectsResponse,
          StreamObject,
          ListStreamObjectsPage> {

    private ListStreamObjectsPage(
        PageContext<ListStreamObjectsRequest, ListStreamObjectsResponse, StreamObject> context,
        ListStreamObjectsResponse response) {
      super(context, response);
    }

    private static ListStreamObjectsPage createEmptyPage() {
      return new ListStreamObjectsPage(null, null);
    }

    @Override
    protected ListStreamObjectsPage createPage(
        PageContext<ListStreamObjectsRequest, ListStreamObjectsResponse, StreamObject> context,
        ListStreamObjectsResponse response) {
      return new ListStreamObjectsPage(context, response);
    }

    @Override
    public ApiFuture<ListStreamObjectsPage> createPageAsync(
        PageContext<ListStreamObjectsRequest, ListStreamObjectsResponse, StreamObject> context,
        ApiFuture<ListStreamObjectsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListStreamObjectsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListStreamObjectsRequest,
          ListStreamObjectsResponse,
          StreamObject,
          ListStreamObjectsPage,
          ListStreamObjectsFixedSizeCollection> {

    private ListStreamObjectsFixedSizeCollection(
        List<ListStreamObjectsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListStreamObjectsFixedSizeCollection createEmptyCollection() {
      return new ListStreamObjectsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListStreamObjectsFixedSizeCollection createCollection(
        List<ListStreamObjectsPage> pages, int collectionSize) {
      return new ListStreamObjectsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class FetchStaticIpsPagedResponse
      extends AbstractPagedListResponse<
          FetchStaticIpsRequest,
          FetchStaticIpsResponse,
          String,
          FetchStaticIpsPage,
          FetchStaticIpsFixedSizeCollection> {

    public static ApiFuture<FetchStaticIpsPagedResponse> createAsync(
        PageContext<FetchStaticIpsRequest, FetchStaticIpsResponse, String> context,
        ApiFuture<FetchStaticIpsResponse> futureResponse) {
      ApiFuture<FetchStaticIpsPage> futurePage =
          FetchStaticIpsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new FetchStaticIpsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private FetchStaticIpsPagedResponse(FetchStaticIpsPage page) {
      super(page, FetchStaticIpsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class FetchStaticIpsPage
      extends AbstractPage<
          FetchStaticIpsRequest, FetchStaticIpsResponse, String, FetchStaticIpsPage> {

    private FetchStaticIpsPage(
        PageContext<FetchStaticIpsRequest, FetchStaticIpsResponse, String> context,
        FetchStaticIpsResponse response) {
      super(context, response);
    }

    private static FetchStaticIpsPage createEmptyPage() {
      return new FetchStaticIpsPage(null, null);
    }

    @Override
    protected FetchStaticIpsPage createPage(
        PageContext<FetchStaticIpsRequest, FetchStaticIpsResponse, String> context,
        FetchStaticIpsResponse response) {
      return new FetchStaticIpsPage(context, response);
    }

    @Override
    public ApiFuture<FetchStaticIpsPage> createPageAsync(
        PageContext<FetchStaticIpsRequest, FetchStaticIpsResponse, String> context,
        ApiFuture<FetchStaticIpsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class FetchStaticIpsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          FetchStaticIpsRequest,
          FetchStaticIpsResponse,
          String,
          FetchStaticIpsPage,
          FetchStaticIpsFixedSizeCollection> {

    private FetchStaticIpsFixedSizeCollection(List<FetchStaticIpsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static FetchStaticIpsFixedSizeCollection createEmptyCollection() {
      return new FetchStaticIpsFixedSizeCollection(null, 0);
    }

    @Override
    protected FetchStaticIpsFixedSizeCollection createCollection(
        List<FetchStaticIpsPage> pages, int collectionSize) {
      return new FetchStaticIpsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListPrivateConnectionsPagedResponse
      extends AbstractPagedListResponse<
          ListPrivateConnectionsRequest,
          ListPrivateConnectionsResponse,
          PrivateConnection,
          ListPrivateConnectionsPage,
          ListPrivateConnectionsFixedSizeCollection> {

    public static ApiFuture<ListPrivateConnectionsPagedResponse> createAsync(
        PageContext<
                ListPrivateConnectionsRequest, ListPrivateConnectionsResponse, PrivateConnection>
            context,
        ApiFuture<ListPrivateConnectionsResponse> futureResponse) {
      ApiFuture<ListPrivateConnectionsPage> futurePage =
          ListPrivateConnectionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListPrivateConnectionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListPrivateConnectionsPagedResponse(ListPrivateConnectionsPage page) {
      super(page, ListPrivateConnectionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPrivateConnectionsPage
      extends AbstractPage<
          ListPrivateConnectionsRequest,
          ListPrivateConnectionsResponse,
          PrivateConnection,
          ListPrivateConnectionsPage> {

    private ListPrivateConnectionsPage(
        PageContext<
                ListPrivateConnectionsRequest, ListPrivateConnectionsResponse, PrivateConnection>
            context,
        ListPrivateConnectionsResponse response) {
      super(context, response);
    }

    private static ListPrivateConnectionsPage createEmptyPage() {
      return new ListPrivateConnectionsPage(null, null);
    }

    @Override
    protected ListPrivateConnectionsPage createPage(
        PageContext<
                ListPrivateConnectionsRequest, ListPrivateConnectionsResponse, PrivateConnection>
            context,
        ListPrivateConnectionsResponse response) {
      return new ListPrivateConnectionsPage(context, response);
    }

    @Override
    public ApiFuture<ListPrivateConnectionsPage> createPageAsync(
        PageContext<
                ListPrivateConnectionsRequest, ListPrivateConnectionsResponse, PrivateConnection>
            context,
        ApiFuture<ListPrivateConnectionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListPrivateConnectionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListPrivateConnectionsRequest,
          ListPrivateConnectionsResponse,
          PrivateConnection,
          ListPrivateConnectionsPage,
          ListPrivateConnectionsFixedSizeCollection> {

    private ListPrivateConnectionsFixedSizeCollection(
        List<ListPrivateConnectionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListPrivateConnectionsFixedSizeCollection createEmptyCollection() {
      return new ListPrivateConnectionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListPrivateConnectionsFixedSizeCollection createCollection(
        List<ListPrivateConnectionsPage> pages, int collectionSize) {
      return new ListPrivateConnectionsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListRoutesPagedResponse
      extends AbstractPagedListResponse<
          ListRoutesRequest,
          ListRoutesResponse,
          Route,
          ListRoutesPage,
          ListRoutesFixedSizeCollection> {

    public static ApiFuture<ListRoutesPagedResponse> createAsync(
        PageContext<ListRoutesRequest, ListRoutesResponse, Route> context,
        ApiFuture<ListRoutesResponse> futureResponse) {
      ApiFuture<ListRoutesPage> futurePage =
          ListRoutesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListRoutesPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListRoutesPagedResponse(ListRoutesPage page) {
      super(page, ListRoutesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListRoutesPage
      extends AbstractPage<ListRoutesRequest, ListRoutesResponse, Route, ListRoutesPage> {

    private ListRoutesPage(
        PageContext<ListRoutesRequest, ListRoutesResponse, Route> context,
        ListRoutesResponse response) {
      super(context, response);
    }

    private static ListRoutesPage createEmptyPage() {
      return new ListRoutesPage(null, null);
    }

    @Override
    protected ListRoutesPage createPage(
        PageContext<ListRoutesRequest, ListRoutesResponse, Route> context,
        ListRoutesResponse response) {
      return new ListRoutesPage(context, response);
    }

    @Override
    public ApiFuture<ListRoutesPage> createPageAsync(
        PageContext<ListRoutesRequest, ListRoutesResponse, Route> context,
        ApiFuture<ListRoutesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListRoutesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRoutesRequest,
          ListRoutesResponse,
          Route,
          ListRoutesPage,
          ListRoutesFixedSizeCollection> {

    private ListRoutesFixedSizeCollection(List<ListRoutesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListRoutesFixedSizeCollection createEmptyCollection() {
      return new ListRoutesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListRoutesFixedSizeCollection createCollection(
        List<ListRoutesPage> pages, int collectionSize) {
      return new ListRoutesFixedSizeCollection(pages, collectionSize);
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
