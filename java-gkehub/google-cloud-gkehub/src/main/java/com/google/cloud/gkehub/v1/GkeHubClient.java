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

package com.google.cloud.gkehub.v1;

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
import com.google.cloud.gkehub.v1.stub.GkeHubStub;
import com.google.cloud.gkehub.v1.stub.GkeHubStubSettings;
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
 * Service Description: The GKE Hub service handles the registration of many Kubernetes clusters to
 * Google Cloud, and the management of multi-cluster features over those clusters.
 *
 * <p>The GKE Hub service operates on the following resources:
 *
 * <ul>
 *   <li>[Membership][google.cloud.gkehub.v1.Membership]
 *   <li>[Feature][google.cloud.gkehub.v1.Feature]
 * </ul>
 *
 * <p>GKE Hub is currently only available in the global region.
 *
 * <p>&#42;&#42;Membership management may be non-trivial:&#42;&#42; it is recommended to use one of
 * the Google-provided client libraries or tools where possible when working with Membership
 * resources.
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
 * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
 *   MembershipName name = MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]");
 *   Membership response = gkeHubClient.getMembership(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the GkeHubClient object to clean up resources such as
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
 * <p>This class can be customized by passing in a custom instance of GkeHubSettings to create().
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
 * GkeHubSettings gkeHubSettings =
 *     GkeHubSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * GkeHubClient gkeHubClient = GkeHubClient.create(gkeHubSettings);
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
 * GkeHubSettings gkeHubSettings = GkeHubSettings.newBuilder().setEndpoint(myEndpoint).build();
 * GkeHubClient gkeHubClient = GkeHubClient.create(gkeHubSettings);
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
 * GkeHubSettings gkeHubSettings = GkeHubSettings.newHttpJsonBuilder().build();
 * GkeHubClient gkeHubClient = GkeHubClient.create(gkeHubSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class GkeHubClient implements BackgroundResource {
  private final GkeHubSettings settings;
  private final GkeHubStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of GkeHubClient with default settings. */
  public static final GkeHubClient create() throws IOException {
    return create(GkeHubSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of GkeHubClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final GkeHubClient create(GkeHubSettings settings) throws IOException {
    return new GkeHubClient(settings);
  }

  /**
   * Constructs an instance of GkeHubClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(GkeHubSettings).
   */
  public static final GkeHubClient create(GkeHubStub stub) {
    return new GkeHubClient(stub);
  }

  /**
   * Constructs an instance of GkeHubClient, using the given settings. This is protected so that it
   * is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GkeHubClient(GkeHubSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((GkeHubStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected GkeHubClient(GkeHubStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final GkeHubSettings getSettings() {
    return settings;
  }

  public GkeHubStub getStub() {
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
   * Lists Memberships in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Membership element : gkeHubClient.listMemberships(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent (project and location) where the Memberships will be listed.
   *     Specified in the format `projects/&#42;/locations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMembershipsPagedResponse listMemberships(LocationName parent) {
    ListMembershipsRequest request =
        ListMembershipsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listMemberships(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Memberships in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Membership element : gkeHubClient.listMemberships(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent (project and location) where the Memberships will be listed.
   *     Specified in the format `projects/&#42;/locations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMembershipsPagedResponse listMemberships(String parent) {
    ListMembershipsRequest request = ListMembershipsRequest.newBuilder().setParent(parent).build();
    return listMemberships(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Memberships in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   ListMembershipsRequest request =
   *       ListMembershipsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Membership element : gkeHubClient.listMemberships(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMembershipsPagedResponse listMemberships(ListMembershipsRequest request) {
    return listMembershipsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Memberships in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   ListMembershipsRequest request =
   *       ListMembershipsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Membership> future =
   *       gkeHubClient.listMembershipsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Membership element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListMembershipsRequest, ListMembershipsPagedResponse>
      listMembershipsPagedCallable() {
    return stub.listMembershipsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Memberships in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   ListMembershipsRequest request =
   *       ListMembershipsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListMembershipsResponse response = gkeHubClient.listMembershipsCallable().call(request);
   *     for (Membership element : response.getResourcesList()) {
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
  public final UnaryCallable<ListMembershipsRequest, ListMembershipsResponse>
      listMembershipsCallable() {
    return stub.listMembershipsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Features in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Feature element : gkeHubClient.listFeatures(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent (project and location) where the Features will be listed.
   *     Specified in the format `projects/&#42;/locations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFeaturesPagedResponse listFeatures(LocationName parent) {
    ListFeaturesRequest request =
        ListFeaturesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listFeatures(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Features in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Feature element : gkeHubClient.listFeatures(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent (project and location) where the Features will be listed.
   *     Specified in the format `projects/&#42;/locations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFeaturesPagedResponse listFeatures(String parent) {
    ListFeaturesRequest request = ListFeaturesRequest.newBuilder().setParent(parent).build();
    return listFeatures(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Features in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   ListFeaturesRequest request =
   *       ListFeaturesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Feature element : gkeHubClient.listFeatures(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFeaturesPagedResponse listFeatures(ListFeaturesRequest request) {
    return listFeaturesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Features in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   ListFeaturesRequest request =
   *       ListFeaturesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Feature> future = gkeHubClient.listFeaturesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Feature element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListFeaturesRequest, ListFeaturesPagedResponse>
      listFeaturesPagedCallable() {
    return stub.listFeaturesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Features in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   ListFeaturesRequest request =
   *       ListFeaturesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListFeaturesResponse response = gkeHubClient.listFeaturesCallable().call(request);
   *     for (Feature element : response.getResourcesList()) {
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
  public final UnaryCallable<ListFeaturesRequest, ListFeaturesResponse> listFeaturesCallable() {
    return stub.listFeaturesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a Membership.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   MembershipName name = MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]");
   *   Membership response = gkeHubClient.getMembership(name);
   * }
   * }</pre>
   *
   * @param name Required. The Membership resource name in the format
   *     `projects/&#42;/locations/&#42;/memberships/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Membership getMembership(MembershipName name) {
    GetMembershipRequest request =
        GetMembershipRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getMembership(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a Membership.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   String name = MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString();
   *   Membership response = gkeHubClient.getMembership(name);
   * }
   * }</pre>
   *
   * @param name Required. The Membership resource name in the format
   *     `projects/&#42;/locations/&#42;/memberships/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Membership getMembership(String name) {
    GetMembershipRequest request = GetMembershipRequest.newBuilder().setName(name).build();
    return getMembership(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a Membership.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   GetMembershipRequest request =
   *       GetMembershipRequest.newBuilder()
   *           .setName(MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString())
   *           .build();
   *   Membership response = gkeHubClient.getMembership(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Membership getMembership(GetMembershipRequest request) {
    return getMembershipCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a Membership.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   GetMembershipRequest request =
   *       GetMembershipRequest.newBuilder()
   *           .setName(MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString())
   *           .build();
   *   ApiFuture<Membership> future = gkeHubClient.getMembershipCallable().futureCall(request);
   *   // Do something.
   *   Membership response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetMembershipRequest, Membership> getMembershipCallable() {
    return stub.getMembershipCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Feature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   FeatureName name = FeatureName.of("[PROJECT]", "[LOCATION]", "[FEATURE]");
   *   Feature response = gkeHubClient.getFeature(name);
   * }
   * }</pre>
   *
   * @param name Required. The Feature resource name in the format
   *     `projects/&#42;/locations/&#42;/features/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Feature getFeature(FeatureName name) {
    GetFeatureRequest request =
        GetFeatureRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getFeature(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Feature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   String name = FeatureName.of("[PROJECT]", "[LOCATION]", "[FEATURE]").toString();
   *   Feature response = gkeHubClient.getFeature(name);
   * }
   * }</pre>
   *
   * @param name Required. The Feature resource name in the format
   *     `projects/&#42;/locations/&#42;/features/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Feature getFeature(String name) {
    GetFeatureRequest request = GetFeatureRequest.newBuilder().setName(name).build();
    return getFeature(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Feature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   GetFeatureRequest request =
   *       GetFeatureRequest.newBuilder()
   *           .setName(FeatureName.of("[PROJECT]", "[LOCATION]", "[FEATURE]").toString())
   *           .build();
   *   Feature response = gkeHubClient.getFeature(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Feature getFeature(GetFeatureRequest request) {
    return getFeatureCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Feature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   GetFeatureRequest request =
   *       GetFeatureRequest.newBuilder()
   *           .setName(FeatureName.of("[PROJECT]", "[LOCATION]", "[FEATURE]").toString())
   *           .build();
   *   ApiFuture<Feature> future = gkeHubClient.getFeatureCallable().futureCall(request);
   *   // Do something.
   *   Feature response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetFeatureRequest, Feature> getFeatureCallable() {
    return stub.getFeatureCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Membership.
   *
   * <p>&#42;&#42;This is currently only supported for GKE clusters on Google Cloud&#42;&#42;. To
   * register other clusters, follow the instructions at
   * https://cloud.google.com/anthos/multicluster-management/connect/registering-a-cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Membership resource = Membership.newBuilder().build();
   *   String membershipId = "membershipId517665681";
   *   Membership response =
   *       gkeHubClient.createMembershipAsync(parent, resource, membershipId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent (project and location) where the Memberships will be
   *     created. Specified in the format `projects/&#42;/locations/&#42;`.
   * @param resource Required. The membership to create.
   * @param membershipId Required. Client chosen ID for the membership. `membership_id` must be a
   *     valid RFC 1123 compliant DNS label:
   *     <p>1. At most 63 characters in length 2. It must consist of lower case alphanumeric
   *     characters or `-` 3. It must start and end with an alphanumeric character
   *     <p>Which can be expressed as the regex: `[a-z0-9]([-a-z0-9]&#42;[a-z0-9])?`, with a maximum
   *     length of 63 characters.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Membership, OperationMetadata> createMembershipAsync(
      LocationName parent, Membership resource, String membershipId) {
    CreateMembershipRequest request =
        CreateMembershipRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setResource(resource)
            .setMembershipId(membershipId)
            .build();
    return createMembershipAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Membership.
   *
   * <p>&#42;&#42;This is currently only supported for GKE clusters on Google Cloud&#42;&#42;. To
   * register other clusters, follow the instructions at
   * https://cloud.google.com/anthos/multicluster-management/connect/registering-a-cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Membership resource = Membership.newBuilder().build();
   *   String membershipId = "membershipId517665681";
   *   Membership response =
   *       gkeHubClient.createMembershipAsync(parent, resource, membershipId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent (project and location) where the Memberships will be
   *     created. Specified in the format `projects/&#42;/locations/&#42;`.
   * @param resource Required. The membership to create.
   * @param membershipId Required. Client chosen ID for the membership. `membership_id` must be a
   *     valid RFC 1123 compliant DNS label:
   *     <p>1. At most 63 characters in length 2. It must consist of lower case alphanumeric
   *     characters or `-` 3. It must start and end with an alphanumeric character
   *     <p>Which can be expressed as the regex: `[a-z0-9]([-a-z0-9]&#42;[a-z0-9])?`, with a maximum
   *     length of 63 characters.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Membership, OperationMetadata> createMembershipAsync(
      String parent, Membership resource, String membershipId) {
    CreateMembershipRequest request =
        CreateMembershipRequest.newBuilder()
            .setParent(parent)
            .setResource(resource)
            .setMembershipId(membershipId)
            .build();
    return createMembershipAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Membership.
   *
   * <p>&#42;&#42;This is currently only supported for GKE clusters on Google Cloud&#42;&#42;. To
   * register other clusters, follow the instructions at
   * https://cloud.google.com/anthos/multicluster-management/connect/registering-a-cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   CreateMembershipRequest request =
   *       CreateMembershipRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setMembershipId("membershipId517665681")
   *           .setResource(Membership.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Membership response = gkeHubClient.createMembershipAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Membership, OperationMetadata> createMembershipAsync(
      CreateMembershipRequest request) {
    return createMembershipOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Membership.
   *
   * <p>&#42;&#42;This is currently only supported for GKE clusters on Google Cloud&#42;&#42;. To
   * register other clusters, follow the instructions at
   * https://cloud.google.com/anthos/multicluster-management/connect/registering-a-cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   CreateMembershipRequest request =
   *       CreateMembershipRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setMembershipId("membershipId517665681")
   *           .setResource(Membership.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Membership, OperationMetadata> future =
   *       gkeHubClient.createMembershipOperationCallable().futureCall(request);
   *   // Do something.
   *   Membership response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateMembershipRequest, Membership, OperationMetadata>
      createMembershipOperationCallable() {
    return stub.createMembershipOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Membership.
   *
   * <p>&#42;&#42;This is currently only supported for GKE clusters on Google Cloud&#42;&#42;. To
   * register other clusters, follow the instructions at
   * https://cloud.google.com/anthos/multicluster-management/connect/registering-a-cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   CreateMembershipRequest request =
   *       CreateMembershipRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setMembershipId("membershipId517665681")
   *           .setResource(Membership.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = gkeHubClient.createMembershipCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateMembershipRequest, Operation> createMembershipCallable() {
    return stub.createMembershipCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a new Feature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Feature resource = Feature.newBuilder().build();
   *   String featureId = "featureId-420503887";
   *   Feature response = gkeHubClient.createFeatureAsync(parent, resource, featureId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent (project and location) where the Feature will be created.
   *     Specified in the format `projects/&#42;/locations/&#42;`.
   * @param resource The Feature resource to create.
   * @param featureId The ID of the feature to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Feature, OperationMetadata> createFeatureAsync(
      LocationName parent, Feature resource, String featureId) {
    CreateFeatureRequest request =
        CreateFeatureRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setResource(resource)
            .setFeatureId(featureId)
            .build();
    return createFeatureAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a new Feature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Feature resource = Feature.newBuilder().build();
   *   String featureId = "featureId-420503887";
   *   Feature response = gkeHubClient.createFeatureAsync(parent, resource, featureId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent (project and location) where the Feature will be created.
   *     Specified in the format `projects/&#42;/locations/&#42;`.
   * @param resource The Feature resource to create.
   * @param featureId The ID of the feature to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Feature, OperationMetadata> createFeatureAsync(
      String parent, Feature resource, String featureId) {
    CreateFeatureRequest request =
        CreateFeatureRequest.newBuilder()
            .setParent(parent)
            .setResource(resource)
            .setFeatureId(featureId)
            .build();
    return createFeatureAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a new Feature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   CreateFeatureRequest request =
   *       CreateFeatureRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFeatureId("featureId-420503887")
   *           .setResource(Feature.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Feature response = gkeHubClient.createFeatureAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Feature, OperationMetadata> createFeatureAsync(
      CreateFeatureRequest request) {
    return createFeatureOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a new Feature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   CreateFeatureRequest request =
   *       CreateFeatureRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFeatureId("featureId-420503887")
   *           .setResource(Feature.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Feature, OperationMetadata> future =
   *       gkeHubClient.createFeatureOperationCallable().futureCall(request);
   *   // Do something.
   *   Feature response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateFeatureRequest, Feature, OperationMetadata>
      createFeatureOperationCallable() {
    return stub.createFeatureOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a new Feature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   CreateFeatureRequest request =
   *       CreateFeatureRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFeatureId("featureId-420503887")
   *           .setResource(Feature.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = gkeHubClient.createFeatureCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateFeatureRequest, Operation> createFeatureCallable() {
    return stub.createFeatureCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes a Membership.
   *
   * <p>&#42;&#42;This is currently only supported for GKE clusters on Google Cloud&#42;&#42;. To
   * unregister other clusters, follow the instructions at
   * https://cloud.google.com/anthos/multicluster-management/connect/unregistering-a-cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   MembershipName name = MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]");
   *   gkeHubClient.deleteMembershipAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The Membership resource name in the format
   *     `projects/&#42;/locations/&#42;/memberships/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteMembershipAsync(
      MembershipName name) {
    DeleteMembershipRequest request =
        DeleteMembershipRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteMembershipAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes a Membership.
   *
   * <p>&#42;&#42;This is currently only supported for GKE clusters on Google Cloud&#42;&#42;. To
   * unregister other clusters, follow the instructions at
   * https://cloud.google.com/anthos/multicluster-management/connect/unregistering-a-cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   String name = MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString();
   *   gkeHubClient.deleteMembershipAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The Membership resource name in the format
   *     `projects/&#42;/locations/&#42;/memberships/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteMembershipAsync(String name) {
    DeleteMembershipRequest request = DeleteMembershipRequest.newBuilder().setName(name).build();
    return deleteMembershipAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes a Membership.
   *
   * <p>&#42;&#42;This is currently only supported for GKE clusters on Google Cloud&#42;&#42;. To
   * unregister other clusters, follow the instructions at
   * https://cloud.google.com/anthos/multicluster-management/connect/unregistering-a-cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   DeleteMembershipRequest request =
   *       DeleteMembershipRequest.newBuilder()
   *           .setName(MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   gkeHubClient.deleteMembershipAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteMembershipAsync(
      DeleteMembershipRequest request) {
    return deleteMembershipOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes a Membership.
   *
   * <p>&#42;&#42;This is currently only supported for GKE clusters on Google Cloud&#42;&#42;. To
   * unregister other clusters, follow the instructions at
   * https://cloud.google.com/anthos/multicluster-management/connect/unregistering-a-cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   DeleteMembershipRequest request =
   *       DeleteMembershipRequest.newBuilder()
   *           .setName(MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       gkeHubClient.deleteMembershipOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteMembershipRequest, Empty, OperationMetadata>
      deleteMembershipOperationCallable() {
    return stub.deleteMembershipOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes a Membership.
   *
   * <p>&#42;&#42;This is currently only supported for GKE clusters on Google Cloud&#42;&#42;. To
   * unregister other clusters, follow the instructions at
   * https://cloud.google.com/anthos/multicluster-management/connect/unregistering-a-cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   DeleteMembershipRequest request =
   *       DeleteMembershipRequest.newBuilder()
   *           .setName(MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = gkeHubClient.deleteMembershipCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteMembershipRequest, Operation> deleteMembershipCallable() {
    return stub.deleteMembershipCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes a Feature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   FeatureName name = FeatureName.of("[PROJECT]", "[LOCATION]", "[FEATURE]");
   *   gkeHubClient.deleteFeatureAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The Feature resource name in the format
   *     `projects/&#42;/locations/&#42;/features/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteFeatureAsync(FeatureName name) {
    DeleteFeatureRequest request =
        DeleteFeatureRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteFeatureAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes a Feature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   String name = FeatureName.of("[PROJECT]", "[LOCATION]", "[FEATURE]").toString();
   *   gkeHubClient.deleteFeatureAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The Feature resource name in the format
   *     `projects/&#42;/locations/&#42;/features/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteFeatureAsync(String name) {
    DeleteFeatureRequest request = DeleteFeatureRequest.newBuilder().setName(name).build();
    return deleteFeatureAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes a Feature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   DeleteFeatureRequest request =
   *       DeleteFeatureRequest.newBuilder()
   *           .setName(FeatureName.of("[PROJECT]", "[LOCATION]", "[FEATURE]").toString())
   *           .setForce(true)
   *           .setRequestId("requestId693933066")
   *           .build();
   *   gkeHubClient.deleteFeatureAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteFeatureAsync(
      DeleteFeatureRequest request) {
    return deleteFeatureOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes a Feature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   DeleteFeatureRequest request =
   *       DeleteFeatureRequest.newBuilder()
   *           .setName(FeatureName.of("[PROJECT]", "[LOCATION]", "[FEATURE]").toString())
   *           .setForce(true)
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       gkeHubClient.deleteFeatureOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteFeatureRequest, Empty, OperationMetadata>
      deleteFeatureOperationCallable() {
    return stub.deleteFeatureOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes a Feature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   DeleteFeatureRequest request =
   *       DeleteFeatureRequest.newBuilder()
   *           .setName(FeatureName.of("[PROJECT]", "[LOCATION]", "[FEATURE]").toString())
   *           .setForce(true)
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = gkeHubClient.deleteFeatureCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteFeatureRequest, Operation> deleteFeatureCallable() {
    return stub.deleteFeatureCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing Membership.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   MembershipName name = MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]");
   *   Membership resource = Membership.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Membership response = gkeHubClient.updateMembershipAsync(name, resource, updateMask).get();
   * }
   * }</pre>
   *
   * @param name Required. The Membership resource name in the format
   *     `projects/&#42;/locations/&#42;/memberships/&#42;`.
   * @param resource Required. Only fields specified in update_mask are updated. If you specify a
   *     field in the update_mask but don't specify its value here that field will be deleted. If
   *     you are updating a map field, set the value of a key to null or empty string to delete the
   *     key from the map. It's not possible to update a key's value to the empty string. If you
   *     specify the update_mask to be a special path "&#42;", fully replaces all user-modifiable
   *     fields to match `resource`.
   * @param updateMask Required. Mask of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Membership, OperationMetadata> updateMembershipAsync(
      MembershipName name, Membership resource, FieldMask updateMask) {
    UpdateMembershipRequest request =
        UpdateMembershipRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setResource(resource)
            .setUpdateMask(updateMask)
            .build();
    return updateMembershipAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing Membership.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   String name = MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString();
   *   Membership resource = Membership.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Membership response = gkeHubClient.updateMembershipAsync(name, resource, updateMask).get();
   * }
   * }</pre>
   *
   * @param name Required. The Membership resource name in the format
   *     `projects/&#42;/locations/&#42;/memberships/&#42;`.
   * @param resource Required. Only fields specified in update_mask are updated. If you specify a
   *     field in the update_mask but don't specify its value here that field will be deleted. If
   *     you are updating a map field, set the value of a key to null or empty string to delete the
   *     key from the map. It's not possible to update a key's value to the empty string. If you
   *     specify the update_mask to be a special path "&#42;", fully replaces all user-modifiable
   *     fields to match `resource`.
   * @param updateMask Required. Mask of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Membership, OperationMetadata> updateMembershipAsync(
      String name, Membership resource, FieldMask updateMask) {
    UpdateMembershipRequest request =
        UpdateMembershipRequest.newBuilder()
            .setName(name)
            .setResource(resource)
            .setUpdateMask(updateMask)
            .build();
    return updateMembershipAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing Membership.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   UpdateMembershipRequest request =
   *       UpdateMembershipRequest.newBuilder()
   *           .setName(MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setResource(Membership.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Membership response = gkeHubClient.updateMembershipAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Membership, OperationMetadata> updateMembershipAsync(
      UpdateMembershipRequest request) {
    return updateMembershipOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing Membership.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   UpdateMembershipRequest request =
   *       UpdateMembershipRequest.newBuilder()
   *           .setName(MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setResource(Membership.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Membership, OperationMetadata> future =
   *       gkeHubClient.updateMembershipOperationCallable().futureCall(request);
   *   // Do something.
   *   Membership response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateMembershipRequest, Membership, OperationMetadata>
      updateMembershipOperationCallable() {
    return stub.updateMembershipOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing Membership.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   UpdateMembershipRequest request =
   *       UpdateMembershipRequest.newBuilder()
   *           .setName(MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setResource(Membership.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = gkeHubClient.updateMembershipCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateMembershipRequest, Operation> updateMembershipCallable() {
    return stub.updateMembershipCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing Feature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   FeatureName name = FeatureName.of("[PROJECT]", "[LOCATION]", "[FEATURE]");
   *   Feature resource = Feature.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Feature response = gkeHubClient.updateFeatureAsync(name, resource, updateMask).get();
   * }
   * }</pre>
   *
   * @param name Required. The Feature resource name in the format
   *     `projects/&#42;/locations/&#42;/features/&#42;`.
   * @param resource Only fields specified in update_mask are updated. If you specify a field in the
   *     update_mask but don't specify its value here that field will be deleted. If you are
   *     updating a map field, set the value of a key to null or empty string to delete the key from
   *     the map. It's not possible to update a key's value to the empty string. If you specify the
   *     update_mask to be a special path "&#42;", fully replaces all user-modifiable fields to
   *     match `resource`.
   * @param updateMask Mask of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Feature, OperationMetadata> updateFeatureAsync(
      FeatureName name, Feature resource, FieldMask updateMask) {
    UpdateFeatureRequest request =
        UpdateFeatureRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setResource(resource)
            .setUpdateMask(updateMask)
            .build();
    return updateFeatureAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing Feature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   String name = FeatureName.of("[PROJECT]", "[LOCATION]", "[FEATURE]").toString();
   *   Feature resource = Feature.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Feature response = gkeHubClient.updateFeatureAsync(name, resource, updateMask).get();
   * }
   * }</pre>
   *
   * @param name Required. The Feature resource name in the format
   *     `projects/&#42;/locations/&#42;/features/&#42;`.
   * @param resource Only fields specified in update_mask are updated. If you specify a field in the
   *     update_mask but don't specify its value here that field will be deleted. If you are
   *     updating a map field, set the value of a key to null or empty string to delete the key from
   *     the map. It's not possible to update a key's value to the empty string. If you specify the
   *     update_mask to be a special path "&#42;", fully replaces all user-modifiable fields to
   *     match `resource`.
   * @param updateMask Mask of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Feature, OperationMetadata> updateFeatureAsync(
      String name, Feature resource, FieldMask updateMask) {
    UpdateFeatureRequest request =
        UpdateFeatureRequest.newBuilder()
            .setName(name)
            .setResource(resource)
            .setUpdateMask(updateMask)
            .build();
    return updateFeatureAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing Feature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   UpdateFeatureRequest request =
   *       UpdateFeatureRequest.newBuilder()
   *           .setName(FeatureName.of("[PROJECT]", "[LOCATION]", "[FEATURE]").toString())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setResource(Feature.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Feature response = gkeHubClient.updateFeatureAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Feature, OperationMetadata> updateFeatureAsync(
      UpdateFeatureRequest request) {
    return updateFeatureOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing Feature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   UpdateFeatureRequest request =
   *       UpdateFeatureRequest.newBuilder()
   *           .setName(FeatureName.of("[PROJECT]", "[LOCATION]", "[FEATURE]").toString())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setResource(Feature.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Feature, OperationMetadata> future =
   *       gkeHubClient.updateFeatureOperationCallable().futureCall(request);
   *   // Do something.
   *   Feature response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateFeatureRequest, Feature, OperationMetadata>
      updateFeatureOperationCallable() {
    return stub.updateFeatureOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing Feature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   UpdateFeatureRequest request =
   *       UpdateFeatureRequest.newBuilder()
   *           .setName(FeatureName.of("[PROJECT]", "[LOCATION]", "[FEATURE]").toString())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setResource(Feature.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = gkeHubClient.updateFeatureCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateFeatureRequest, Operation> updateFeatureCallable() {
    return stub.updateFeatureCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates the manifest for deployment of the GKE connect agent.
   *
   * <p>&#42;&#42;This method is used internally by Google-provided libraries.&#42;&#42; Most
   * clients should not need to call this method directly.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   GenerateConnectManifestRequest request =
   *       GenerateConnectManifestRequest.newBuilder()
   *           .setName(MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString())
   *           .setNamespace("namespace1252218203")
   *           .setProxy(ByteString.EMPTY)
   *           .setVersion("version351608024")
   *           .setIsUpgrade(true)
   *           .setRegistry("registry-690212803")
   *           .setImagePullSecretContent(ByteString.EMPTY)
   *           .build();
   *   GenerateConnectManifestResponse response = gkeHubClient.generateConnectManifest(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerateConnectManifestResponse generateConnectManifest(
      GenerateConnectManifestRequest request) {
    return generateConnectManifestCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates the manifest for deployment of the GKE connect agent.
   *
   * <p>&#42;&#42;This method is used internally by Google-provided libraries.&#42;&#42; Most
   * clients should not need to call this method directly.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   GenerateConnectManifestRequest request =
   *       GenerateConnectManifestRequest.newBuilder()
   *           .setName(MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString())
   *           .setNamespace("namespace1252218203")
   *           .setProxy(ByteString.EMPTY)
   *           .setVersion("version351608024")
   *           .setIsUpgrade(true)
   *           .setRegistry("registry-690212803")
   *           .setImagePullSecretContent(ByteString.EMPTY)
   *           .build();
   *   ApiFuture<GenerateConnectManifestResponse> future =
   *       gkeHubClient.generateConnectManifestCallable().futureCall(request);
   *   // Do something.
   *   GenerateConnectManifestResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GenerateConnectManifestRequest, GenerateConnectManifestResponse>
      generateConnectManifestCallable() {
    return stub.generateConnectManifestCallable();
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

  public static class ListMembershipsPagedResponse
      extends AbstractPagedListResponse<
          ListMembershipsRequest,
          ListMembershipsResponse,
          Membership,
          ListMembershipsPage,
          ListMembershipsFixedSizeCollection> {

    public static ApiFuture<ListMembershipsPagedResponse> createAsync(
        PageContext<ListMembershipsRequest, ListMembershipsResponse, Membership> context,
        ApiFuture<ListMembershipsResponse> futureResponse) {
      ApiFuture<ListMembershipsPage> futurePage =
          ListMembershipsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListMembershipsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListMembershipsPagedResponse(ListMembershipsPage page) {
      super(page, ListMembershipsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListMembershipsPage
      extends AbstractPage<
          ListMembershipsRequest, ListMembershipsResponse, Membership, ListMembershipsPage> {

    private ListMembershipsPage(
        PageContext<ListMembershipsRequest, ListMembershipsResponse, Membership> context,
        ListMembershipsResponse response) {
      super(context, response);
    }

    private static ListMembershipsPage createEmptyPage() {
      return new ListMembershipsPage(null, null);
    }

    @Override
    protected ListMembershipsPage createPage(
        PageContext<ListMembershipsRequest, ListMembershipsResponse, Membership> context,
        ListMembershipsResponse response) {
      return new ListMembershipsPage(context, response);
    }

    @Override
    public ApiFuture<ListMembershipsPage> createPageAsync(
        PageContext<ListMembershipsRequest, ListMembershipsResponse, Membership> context,
        ApiFuture<ListMembershipsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListMembershipsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListMembershipsRequest,
          ListMembershipsResponse,
          Membership,
          ListMembershipsPage,
          ListMembershipsFixedSizeCollection> {

    private ListMembershipsFixedSizeCollection(
        List<ListMembershipsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListMembershipsFixedSizeCollection createEmptyCollection() {
      return new ListMembershipsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListMembershipsFixedSizeCollection createCollection(
        List<ListMembershipsPage> pages, int collectionSize) {
      return new ListMembershipsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListFeaturesPagedResponse
      extends AbstractPagedListResponse<
          ListFeaturesRequest,
          ListFeaturesResponse,
          Feature,
          ListFeaturesPage,
          ListFeaturesFixedSizeCollection> {

    public static ApiFuture<ListFeaturesPagedResponse> createAsync(
        PageContext<ListFeaturesRequest, ListFeaturesResponse, Feature> context,
        ApiFuture<ListFeaturesResponse> futureResponse) {
      ApiFuture<ListFeaturesPage> futurePage =
          ListFeaturesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListFeaturesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListFeaturesPagedResponse(ListFeaturesPage page) {
      super(page, ListFeaturesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListFeaturesPage
      extends AbstractPage<ListFeaturesRequest, ListFeaturesResponse, Feature, ListFeaturesPage> {

    private ListFeaturesPage(
        PageContext<ListFeaturesRequest, ListFeaturesResponse, Feature> context,
        ListFeaturesResponse response) {
      super(context, response);
    }

    private static ListFeaturesPage createEmptyPage() {
      return new ListFeaturesPage(null, null);
    }

    @Override
    protected ListFeaturesPage createPage(
        PageContext<ListFeaturesRequest, ListFeaturesResponse, Feature> context,
        ListFeaturesResponse response) {
      return new ListFeaturesPage(context, response);
    }

    @Override
    public ApiFuture<ListFeaturesPage> createPageAsync(
        PageContext<ListFeaturesRequest, ListFeaturesResponse, Feature> context,
        ApiFuture<ListFeaturesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFeaturesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListFeaturesRequest,
          ListFeaturesResponse,
          Feature,
          ListFeaturesPage,
          ListFeaturesFixedSizeCollection> {

    private ListFeaturesFixedSizeCollection(List<ListFeaturesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListFeaturesFixedSizeCollection createEmptyCollection() {
      return new ListFeaturesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListFeaturesFixedSizeCollection createCollection(
        List<ListFeaturesPage> pages, int collectionSize) {
      return new ListFeaturesFixedSizeCollection(pages, collectionSize);
    }
  }
}
