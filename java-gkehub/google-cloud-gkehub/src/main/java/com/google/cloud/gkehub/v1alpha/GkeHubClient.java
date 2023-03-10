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

package com.google.cloud.gkehub.v1alpha;

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
import com.google.cloud.gkehub.v1alpha.stub.GkeHubStub;
import com.google.cloud.gkehub.v1alpha.stub.GkeHubStubSettings;
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
 *   <li>[Membership][google.cloud.gkehub.v1alpha.Membership]
 *   <li>[Feature][google.cloud.gkehub.v1alpha.Feature]
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
 *   String name = "name3373707";
 *   Feature response = gkeHubClient.getFeature(name);
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
@BetaApi
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
   *   String parent = "parent-995424086";
   *   for (Feature element : gkeHubClient.listFeatures(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent The parent (project and location) where the Features will be listed. Specified in
   *     the format `projects/&#42;/locations/&#42;`.
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
   *           .setParent("parent-995424086")
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
   *           .setParent("parent-995424086")
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
   *           .setParent("parent-995424086")
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
   *   String name = "name3373707";
   *   Feature response = gkeHubClient.getFeature(name);
   * }
   * }</pre>
   *
   * @param name The Feature resource name in the format
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
   *   GetFeatureRequest request = GetFeatureRequest.newBuilder().setName("name3373707").build();
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
   *   GetFeatureRequest request = GetFeatureRequest.newBuilder().setName("name3373707").build();
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
   *   String parent = "parent-995424086";
   *   Feature resource = Feature.newBuilder().build();
   *   String featureId = "featureId-420503887";
   *   Feature response = gkeHubClient.createFeatureAsync(parent, resource, featureId).get();
   * }
   * }</pre>
   *
   * @param parent The parent (project and location) where the Feature will be created. Specified in
   *     the format `projects/&#42;/locations/&#42;`.
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
   *           .setParent("parent-995424086")
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
   *           .setParent("parent-995424086")
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
   *           .setParent("parent-995424086")
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
   *   String name = "name3373707";
   *   gkeHubClient.deleteFeatureAsync(name).get();
   * }
   * }</pre>
   *
   * @param name The Feature resource name in the format
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
   *           .setName("name3373707")
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
   *           .setName("name3373707")
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
   *           .setName("name3373707")
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
   *   String name = "name3373707";
   *   Feature resource = Feature.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Feature response = gkeHubClient.updateFeatureAsync(name, resource, updateMask).get();
   * }
   * }</pre>
   *
   * @param name The Feature resource name in the format
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
   *           .setName("name3373707")
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
   *           .setName("name3373707")
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
   *           .setName("name3373707")
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
