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

package com.google.cloud.gkehub.v1beta1;

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
import com.google.cloud.gkehub.v1beta1.stub.GkeHubMembershipServiceStub;
import com.google.cloud.gkehub.v1beta1.stub.GkeHubMembershipServiceStubSettings;
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
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The GKE Hub MembershipService handles the registration of many Kubernetes
 * clusters to Google Cloud, represented with the
 * [Membership][google.cloud.gkehub.v1beta1.Membership] resource.
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
 * try (GkeHubMembershipServiceClient gkeHubMembershipServiceClient =
 *     GkeHubMembershipServiceClient.create()) {
 *   MembershipName name = MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]");
 *   Membership response = gkeHubMembershipServiceClient.getMembership(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the GkeHubMembershipServiceClient object to clean up
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
 * <p>This class can be customized by passing in a custom instance of
 * GkeHubMembershipServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * GkeHubMembershipServiceSettings gkeHubMembershipServiceSettings =
 *     GkeHubMembershipServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * GkeHubMembershipServiceClient gkeHubMembershipServiceClient =
 *     GkeHubMembershipServiceClient.create(gkeHubMembershipServiceSettings);
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
 * GkeHubMembershipServiceSettings gkeHubMembershipServiceSettings =
 *     GkeHubMembershipServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * GkeHubMembershipServiceClient gkeHubMembershipServiceClient =
 *     GkeHubMembershipServiceClient.create(gkeHubMembershipServiceSettings);
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
 * GkeHubMembershipServiceSettings gkeHubMembershipServiceSettings =
 *     GkeHubMembershipServiceSettings.newBuilder()
 *         .setTransportChannelProvider(
 *             GkeHubMembershipServiceSettings.defaultHttpJsonTransportProviderBuilder().build())
 *         .build();
 * GkeHubMembershipServiceClient gkeHubMembershipServiceClient =
 *     GkeHubMembershipServiceClient.create(gkeHubMembershipServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GkeHubMembershipServiceClient implements BackgroundResource {
  private final GkeHubMembershipServiceSettings settings;
  private final GkeHubMembershipServiceStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of GkeHubMembershipServiceClient with default settings. */
  public static final GkeHubMembershipServiceClient create() throws IOException {
    return create(GkeHubMembershipServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of GkeHubMembershipServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final GkeHubMembershipServiceClient create(GkeHubMembershipServiceSettings settings)
      throws IOException {
    return new GkeHubMembershipServiceClient(settings);
  }

  /**
   * Constructs an instance of GkeHubMembershipServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(GkeHubMembershipServiceSettings).
   */
  public static final GkeHubMembershipServiceClient create(GkeHubMembershipServiceStub stub) {
    return new GkeHubMembershipServiceClient(stub);
  }

  /**
   * Constructs an instance of GkeHubMembershipServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GkeHubMembershipServiceClient(GkeHubMembershipServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((GkeHubMembershipServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected GkeHubMembershipServiceClient(GkeHubMembershipServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final GkeHubMembershipServiceSettings getSettings() {
    return settings;
  }

  public GkeHubMembershipServiceStub getStub() {
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
   * try (GkeHubMembershipServiceClient gkeHubMembershipServiceClient =
   *     GkeHubMembershipServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Membership element :
   *       gkeHubMembershipServiceClient.listMemberships(parent).iterateAll()) {
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
   * try (GkeHubMembershipServiceClient gkeHubMembershipServiceClient =
   *     GkeHubMembershipServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Membership element :
   *       gkeHubMembershipServiceClient.listMemberships(parent).iterateAll()) {
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
   * try (GkeHubMembershipServiceClient gkeHubMembershipServiceClient =
   *     GkeHubMembershipServiceClient.create()) {
   *   ListMembershipsRequest request =
   *       ListMembershipsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Membership element :
   *       gkeHubMembershipServiceClient.listMemberships(request).iterateAll()) {
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
   * try (GkeHubMembershipServiceClient gkeHubMembershipServiceClient =
   *     GkeHubMembershipServiceClient.create()) {
   *   ListMembershipsRequest request =
   *       ListMembershipsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Membership> future =
   *       gkeHubMembershipServiceClient.listMembershipsPagedCallable().futureCall(request);
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
   * try (GkeHubMembershipServiceClient gkeHubMembershipServiceClient =
   *     GkeHubMembershipServiceClient.create()) {
   *   ListMembershipsRequest request =
   *       ListMembershipsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListMembershipsResponse response =
   *         gkeHubMembershipServiceClient.listMembershipsCallable().call(request);
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
   * try (GkeHubMembershipServiceClient gkeHubMembershipServiceClient =
   *     GkeHubMembershipServiceClient.create()) {
   *   MembershipName name = MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]");
   *   Membership response = gkeHubMembershipServiceClient.getMembership(name);
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
   * try (GkeHubMembershipServiceClient gkeHubMembershipServiceClient =
   *     GkeHubMembershipServiceClient.create()) {
   *   String name = MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString();
   *   Membership response = gkeHubMembershipServiceClient.getMembership(name);
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
   * try (GkeHubMembershipServiceClient gkeHubMembershipServiceClient =
   *     GkeHubMembershipServiceClient.create()) {
   *   GetMembershipRequest request =
   *       GetMembershipRequest.newBuilder()
   *           .setName(MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString())
   *           .build();
   *   Membership response = gkeHubMembershipServiceClient.getMembership(request);
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
   * try (GkeHubMembershipServiceClient gkeHubMembershipServiceClient =
   *     GkeHubMembershipServiceClient.create()) {
   *   GetMembershipRequest request =
   *       GetMembershipRequest.newBuilder()
   *           .setName(MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString())
   *           .build();
   *   ApiFuture<Membership> future =
   *       gkeHubMembershipServiceClient.getMembershipCallable().futureCall(request);
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
   * try (GkeHubMembershipServiceClient gkeHubMembershipServiceClient =
   *     GkeHubMembershipServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Membership resource = Membership.newBuilder().build();
   *   String membershipId = "membershipId517665681";
   *   Membership response =
   *       gkeHubMembershipServiceClient.createMembershipAsync(parent, resource, membershipId).get();
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
   * try (GkeHubMembershipServiceClient gkeHubMembershipServiceClient =
   *     GkeHubMembershipServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Membership resource = Membership.newBuilder().build();
   *   String membershipId = "membershipId517665681";
   *   Membership response =
   *       gkeHubMembershipServiceClient.createMembershipAsync(parent, resource, membershipId).get();
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
   * try (GkeHubMembershipServiceClient gkeHubMembershipServiceClient =
   *     GkeHubMembershipServiceClient.create()) {
   *   CreateMembershipRequest request =
   *       CreateMembershipRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setMembershipId("membershipId517665681")
   *           .setResource(Membership.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Membership response = gkeHubMembershipServiceClient.createMembershipAsync(request).get();
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
   * try (GkeHubMembershipServiceClient gkeHubMembershipServiceClient =
   *     GkeHubMembershipServiceClient.create()) {
   *   CreateMembershipRequest request =
   *       CreateMembershipRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setMembershipId("membershipId517665681")
   *           .setResource(Membership.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Membership, OperationMetadata> future =
   *       gkeHubMembershipServiceClient.createMembershipOperationCallable().futureCall(request);
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
   * try (GkeHubMembershipServiceClient gkeHubMembershipServiceClient =
   *     GkeHubMembershipServiceClient.create()) {
   *   CreateMembershipRequest request =
   *       CreateMembershipRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setMembershipId("membershipId517665681")
   *           .setResource(Membership.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       gkeHubMembershipServiceClient.createMembershipCallable().futureCall(request);
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
   * try (GkeHubMembershipServiceClient gkeHubMembershipServiceClient =
   *     GkeHubMembershipServiceClient.create()) {
   *   MembershipName name = MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]");
   *   gkeHubMembershipServiceClient.deleteMembershipAsync(name).get();
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
   * try (GkeHubMembershipServiceClient gkeHubMembershipServiceClient =
   *     GkeHubMembershipServiceClient.create()) {
   *   String name = MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString();
   *   gkeHubMembershipServiceClient.deleteMembershipAsync(name).get();
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
   * try (GkeHubMembershipServiceClient gkeHubMembershipServiceClient =
   *     GkeHubMembershipServiceClient.create()) {
   *   DeleteMembershipRequest request =
   *       DeleteMembershipRequest.newBuilder()
   *           .setName(MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   gkeHubMembershipServiceClient.deleteMembershipAsync(request).get();
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
   * try (GkeHubMembershipServiceClient gkeHubMembershipServiceClient =
   *     GkeHubMembershipServiceClient.create()) {
   *   DeleteMembershipRequest request =
   *       DeleteMembershipRequest.newBuilder()
   *           .setName(MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       gkeHubMembershipServiceClient.deleteMembershipOperationCallable().futureCall(request);
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
   * try (GkeHubMembershipServiceClient gkeHubMembershipServiceClient =
   *     GkeHubMembershipServiceClient.create()) {
   *   DeleteMembershipRequest request =
   *       DeleteMembershipRequest.newBuilder()
   *           .setName(MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       gkeHubMembershipServiceClient.deleteMembershipCallable().futureCall(request);
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
   * try (GkeHubMembershipServiceClient gkeHubMembershipServiceClient =
   *     GkeHubMembershipServiceClient.create()) {
   *   MembershipName name = MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]");
   *   Membership resource = Membership.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Membership response =
   *       gkeHubMembershipServiceClient.updateMembershipAsync(name, resource, updateMask).get();
   * }
   * }</pre>
   *
   * @param name Required. The membership resource name in the format:
   *     `projects/[project_id]/locations/global/memberships/[membership_id]`
   * @param resource Required. Only fields specified in update_mask are updated. If you specify a
   *     field in the update_mask but don't specify its value here that field will be deleted. If
   *     you are updating a map field, set the value of a key to null or empty string to delete the
   *     key from the map. It's not possible to update a key's value to the empty string. If you
   *     specify the update_mask to be a special path "&#42;", fully replaces all user-modifiable
   *     fields to match `resource`.
   * @param updateMask Required. Mask of fields to update. At least one field path must be specified
   *     in this mask.
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
   * try (GkeHubMembershipServiceClient gkeHubMembershipServiceClient =
   *     GkeHubMembershipServiceClient.create()) {
   *   String name = MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString();
   *   Membership resource = Membership.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Membership response =
   *       gkeHubMembershipServiceClient.updateMembershipAsync(name, resource, updateMask).get();
   * }
   * }</pre>
   *
   * @param name Required. The membership resource name in the format:
   *     `projects/[project_id]/locations/global/memberships/[membership_id]`
   * @param resource Required. Only fields specified in update_mask are updated. If you specify a
   *     field in the update_mask but don't specify its value here that field will be deleted. If
   *     you are updating a map field, set the value of a key to null or empty string to delete the
   *     key from the map. It's not possible to update a key's value to the empty string. If you
   *     specify the update_mask to be a special path "&#42;", fully replaces all user-modifiable
   *     fields to match `resource`.
   * @param updateMask Required. Mask of fields to update. At least one field path must be specified
   *     in this mask.
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
   * try (GkeHubMembershipServiceClient gkeHubMembershipServiceClient =
   *     GkeHubMembershipServiceClient.create()) {
   *   UpdateMembershipRequest request =
   *       UpdateMembershipRequest.newBuilder()
   *           .setName(MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setResource(Membership.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Membership response = gkeHubMembershipServiceClient.updateMembershipAsync(request).get();
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
   * try (GkeHubMembershipServiceClient gkeHubMembershipServiceClient =
   *     GkeHubMembershipServiceClient.create()) {
   *   UpdateMembershipRequest request =
   *       UpdateMembershipRequest.newBuilder()
   *           .setName(MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setResource(Membership.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Membership, OperationMetadata> future =
   *       gkeHubMembershipServiceClient.updateMembershipOperationCallable().futureCall(request);
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
   * try (GkeHubMembershipServiceClient gkeHubMembershipServiceClient =
   *     GkeHubMembershipServiceClient.create()) {
   *   UpdateMembershipRequest request =
   *       UpdateMembershipRequest.newBuilder()
   *           .setName(MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setResource(Membership.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       gkeHubMembershipServiceClient.updateMembershipCallable().futureCall(request);
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
   * try (GkeHubMembershipServiceClient gkeHubMembershipServiceClient =
   *     GkeHubMembershipServiceClient.create()) {
   *   GenerateConnectManifestRequest request =
   *       GenerateConnectManifestRequest.newBuilder()
   *           .setName(MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString())
   *           .setConnectAgent(ConnectAgent.newBuilder().build())
   *           .setVersion("version351608024")
   *           .setIsUpgrade(true)
   *           .setRegistry("registry-690212803")
   *           .setImagePullSecretContent(ByteString.EMPTY)
   *           .build();
   *   GenerateConnectManifestResponse response =
   *       gkeHubMembershipServiceClient.generateConnectManifest(request);
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
   * try (GkeHubMembershipServiceClient gkeHubMembershipServiceClient =
   *     GkeHubMembershipServiceClient.create()) {
   *   GenerateConnectManifestRequest request =
   *       GenerateConnectManifestRequest.newBuilder()
   *           .setName(MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString())
   *           .setConnectAgent(ConnectAgent.newBuilder().build())
   *           .setVersion("version351608024")
   *           .setIsUpgrade(true)
   *           .setRegistry("registry-690212803")
   *           .setImagePullSecretContent(ByteString.EMPTY)
   *           .build();
   *   ApiFuture<GenerateConnectManifestResponse> future =
   *       gkeHubMembershipServiceClient.generateConnectManifestCallable().futureCall(request);
   *   // Do something.
   *   GenerateConnectManifestResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GenerateConnectManifestRequest, GenerateConnectManifestResponse>
      generateConnectManifestCallable() {
    return stub.generateConnectManifestCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * ValidateExclusivity validates the state of exclusivity in the cluster. The validation does not
   * depend on an existing Hub membership resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubMembershipServiceClient gkeHubMembershipServiceClient =
   *     GkeHubMembershipServiceClient.create()) {
   *   ValidateExclusivityRequest request =
   *       ValidateExclusivityRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setCrManifest("crManifest-1971077186")
   *           .setIntendedMembership("intendedMembership-2074920351")
   *           .build();
   *   ValidateExclusivityResponse response =
   *       gkeHubMembershipServiceClient.validateExclusivity(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ValidateExclusivityResponse validateExclusivity(ValidateExclusivityRequest request) {
    return validateExclusivityCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * ValidateExclusivity validates the state of exclusivity in the cluster. The validation does not
   * depend on an existing Hub membership resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubMembershipServiceClient gkeHubMembershipServiceClient =
   *     GkeHubMembershipServiceClient.create()) {
   *   ValidateExclusivityRequest request =
   *       ValidateExclusivityRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setCrManifest("crManifest-1971077186")
   *           .setIntendedMembership("intendedMembership-2074920351")
   *           .build();
   *   ApiFuture<ValidateExclusivityResponse> future =
   *       gkeHubMembershipServiceClient.validateExclusivityCallable().futureCall(request);
   *   // Do something.
   *   ValidateExclusivityResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ValidateExclusivityRequest, ValidateExclusivityResponse>
      validateExclusivityCallable() {
    return stub.validateExclusivityCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * GenerateExclusivityManifest generates the manifests to update the exclusivity artifacts in the
   * cluster if needed.
   *
   * <p>Exclusivity artifacts include the Membership custom resource definition (CRD) and the
   * singleton Membership custom resource (CR). Combined with ValidateExclusivity, exclusivity
   * artifacts guarantee that a Kubernetes cluster is only registered to a single GKE Hub.
   *
   * <p>The Membership CRD is versioned, and may require conversion when the GKE Hub API server
   * begins serving a newer version of the CRD and corresponding CR. The response will be the
   * converted CRD and CR if there are any differences between the versions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubMembershipServiceClient gkeHubMembershipServiceClient =
   *     GkeHubMembershipServiceClient.create()) {
   *   GenerateExclusivityManifestRequest request =
   *       GenerateExclusivityManifestRequest.newBuilder()
   *           .setName(MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString())
   *           .setCrdManifest("crdManifest1401188132")
   *           .setCrManifest("crManifest-1971077186")
   *           .build();
   *   GenerateExclusivityManifestResponse response =
   *       gkeHubMembershipServiceClient.generateExclusivityManifest(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerateExclusivityManifestResponse generateExclusivityManifest(
      GenerateExclusivityManifestRequest request) {
    return generateExclusivityManifestCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * GenerateExclusivityManifest generates the manifests to update the exclusivity artifacts in the
   * cluster if needed.
   *
   * <p>Exclusivity artifacts include the Membership custom resource definition (CRD) and the
   * singleton Membership custom resource (CR). Combined with ValidateExclusivity, exclusivity
   * artifacts guarantee that a Kubernetes cluster is only registered to a single GKE Hub.
   *
   * <p>The Membership CRD is versioned, and may require conversion when the GKE Hub API server
   * begins serving a newer version of the CRD and corresponding CR. The response will be the
   * converted CRD and CR if there are any differences between the versions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubMembershipServiceClient gkeHubMembershipServiceClient =
   *     GkeHubMembershipServiceClient.create()) {
   *   GenerateExclusivityManifestRequest request =
   *       GenerateExclusivityManifestRequest.newBuilder()
   *           .setName(MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString())
   *           .setCrdManifest("crdManifest1401188132")
   *           .setCrManifest("crManifest-1971077186")
   *           .build();
   *   ApiFuture<GenerateExclusivityManifestResponse> future =
   *       gkeHubMembershipServiceClient.generateExclusivityManifestCallable().futureCall(request);
   *   // Do something.
   *   GenerateExclusivityManifestResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          GenerateExclusivityManifestRequest, GenerateExclusivityManifestResponse>
      generateExclusivityManifestCallable() {
    return stub.generateExclusivityManifestCallable();
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
   * try (GkeHubMembershipServiceClient gkeHubMembershipServiceClient =
   *     GkeHubMembershipServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : gkeHubMembershipServiceClient.listLocations(request).iterateAll()) {
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
   * try (GkeHubMembershipServiceClient gkeHubMembershipServiceClient =
   *     GkeHubMembershipServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       gkeHubMembershipServiceClient.listLocationsPagedCallable().futureCall(request);
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
   * try (GkeHubMembershipServiceClient gkeHubMembershipServiceClient =
   *     GkeHubMembershipServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         gkeHubMembershipServiceClient.listLocationsCallable().call(request);
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
   * try (GkeHubMembershipServiceClient gkeHubMembershipServiceClient =
   *     GkeHubMembershipServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = gkeHubMembershipServiceClient.getLocation(request);
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
   * try (GkeHubMembershipServiceClient gkeHubMembershipServiceClient =
   *     GkeHubMembershipServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future =
   *       gkeHubMembershipServiceClient.getLocationCallable().futureCall(request);
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
   * try (GkeHubMembershipServiceClient gkeHubMembershipServiceClient =
   *     GkeHubMembershipServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = gkeHubMembershipServiceClient.setIamPolicy(request);
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
   * try (GkeHubMembershipServiceClient gkeHubMembershipServiceClient =
   *     GkeHubMembershipServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       gkeHubMembershipServiceClient.setIamPolicyCallable().futureCall(request);
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
   * try (GkeHubMembershipServiceClient gkeHubMembershipServiceClient =
   *     GkeHubMembershipServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = gkeHubMembershipServiceClient.getIamPolicy(request);
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
   * try (GkeHubMembershipServiceClient gkeHubMembershipServiceClient =
   *     GkeHubMembershipServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       gkeHubMembershipServiceClient.getIamPolicyCallable().futureCall(request);
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
   * try (GkeHubMembershipServiceClient gkeHubMembershipServiceClient =
   *     GkeHubMembershipServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response =
   *       gkeHubMembershipServiceClient.testIamPermissions(request);
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
   * try (GkeHubMembershipServiceClient gkeHubMembershipServiceClient =
   *     GkeHubMembershipServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       gkeHubMembershipServiceClient.testIamPermissionsCallable().futureCall(request);
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
