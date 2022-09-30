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

package com.google.cloud.dataplex.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dataplex.v1.stub.MetadataServiceStub;
import com.google.cloud.dataplex.v1.stub.MetadataServiceStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Metadata service manages metadata resources such as tables, filesets and
 * partitions.
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
 *   ZoneName parent = ZoneName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]");
 *   Entity entity = Entity.newBuilder().build();
 *   Entity response = metadataServiceClient.createEntity(parent, entity);
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
 * <p>To use REST (HTTP1.1/JSON) transport (instead of gRPC) for sending and receiving requests over
 * the wire:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * MetadataServiceSettings metadataServiceSettings =
 *     MetadataServiceSettings.newBuilder()
 *         .setTransportChannelProvider(
 *             MetadataServiceSettings.defaultHttpJsonTransportProviderBuilder().build())
 *         .build();
 * MetadataServiceClient metadataServiceClient =
 *     MetadataServiceClient.create(metadataServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class MetadataServiceClient implements BackgroundResource {
  private final MetadataServiceSettings settings;
  private final MetadataServiceStub stub;

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
  }

  protected MetadataServiceClient(MetadataServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final MetadataServiceSettings getSettings() {
    return settings;
  }

  public MetadataServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a metadata entity.
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
   *   ZoneName parent = ZoneName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]");
   *   Entity entity = Entity.newBuilder().build();
   *   Entity response = metadataServiceClient.createEntity(parent, entity);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the parent zone:
   *     `projects/{project_number}/locations/{location_id}/lakes/{lake_id}/zones/{zone_id}`.
   * @param entity Required. Entity resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Entity createEntity(ZoneName parent, Entity entity) {
    CreateEntityRequest request =
        CreateEntityRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setEntity(entity)
            .build();
    return createEntity(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a metadata entity.
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
   *   String parent = ZoneName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]").toString();
   *   Entity entity = Entity.newBuilder().build();
   *   Entity response = metadataServiceClient.createEntity(parent, entity);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the parent zone:
   *     `projects/{project_number}/locations/{location_id}/lakes/{lake_id}/zones/{zone_id}`.
   * @param entity Required. Entity resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Entity createEntity(String parent, Entity entity) {
    CreateEntityRequest request =
        CreateEntityRequest.newBuilder().setParent(parent).setEntity(entity).build();
    return createEntity(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a metadata entity.
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
   *   CreateEntityRequest request =
   *       CreateEntityRequest.newBuilder()
   *           .setParent(ZoneName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]").toString())
   *           .setEntity(Entity.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   Entity response = metadataServiceClient.createEntity(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Entity createEntity(CreateEntityRequest request) {
    return createEntityCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a metadata entity.
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
   *   CreateEntityRequest request =
   *       CreateEntityRequest.newBuilder()
   *           .setParent(ZoneName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]").toString())
   *           .setEntity(Entity.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Entity> future = metadataServiceClient.createEntityCallable().futureCall(request);
   *   // Do something.
   *   Entity response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateEntityRequest, Entity> createEntityCallable() {
    return stub.createEntityCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a metadata entity. Only supports full resource update.
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
   *   UpdateEntityRequest request =
   *       UpdateEntityRequest.newBuilder()
   *           .setEntity(Entity.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   Entity response = metadataServiceClient.updateEntity(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Entity updateEntity(UpdateEntityRequest request) {
    return updateEntityCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a metadata entity. Only supports full resource update.
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
   *   UpdateEntityRequest request =
   *       UpdateEntityRequest.newBuilder()
   *           .setEntity(Entity.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Entity> future = metadataServiceClient.updateEntityCallable().futureCall(request);
   *   // Do something.
   *   Entity response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateEntityRequest, Entity> updateEntityCallable() {
    return stub.updateEntityCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a metadata entity.
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
   *   EntityName name = EntityName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ENTITY]");
   *   metadataServiceClient.deleteEntity(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the entity:
   *     `projects/{project_number}/locations/{location_id}/lakes/{lake_id}/zones/{zone_id}/entities/{entity_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteEntity(EntityName name) {
    DeleteEntityRequest request =
        DeleteEntityRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteEntity(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a metadata entity.
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
   *       EntityName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ENTITY]").toString();
   *   metadataServiceClient.deleteEntity(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the entity:
   *     `projects/{project_number}/locations/{location_id}/lakes/{lake_id}/zones/{zone_id}/entities/{entity_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteEntity(String name) {
    DeleteEntityRequest request = DeleteEntityRequest.newBuilder().setName(name).build();
    deleteEntity(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a metadata entity.
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
   *   DeleteEntityRequest request =
   *       DeleteEntityRequest.newBuilder()
   *           .setName(
   *               EntityName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ENTITY]")
   *                   .toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   metadataServiceClient.deleteEntity(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteEntity(DeleteEntityRequest request) {
    deleteEntityCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a metadata entity.
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
   *   DeleteEntityRequest request =
   *       DeleteEntityRequest.newBuilder()
   *           .setName(
   *               EntityName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ENTITY]")
   *                   .toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Empty> future = metadataServiceClient.deleteEntityCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteEntityRequest, Empty> deleteEntityCallable() {
    return stub.deleteEntityCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a metadata entity.
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
   *   EntityName name = EntityName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ENTITY]");
   *   Entity response = metadataServiceClient.getEntity(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the entity:
   *     `projects/{project_number}/locations/{location_id}/lakes/{lake_id}/zones/{zone_id}/entities/{entity_id}.`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Entity getEntity(EntityName name) {
    GetEntityRequest request =
        GetEntityRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getEntity(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a metadata entity.
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
   *       EntityName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ENTITY]").toString();
   *   Entity response = metadataServiceClient.getEntity(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the entity:
   *     `projects/{project_number}/locations/{location_id}/lakes/{lake_id}/zones/{zone_id}/entities/{entity_id}.`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Entity getEntity(String name) {
    GetEntityRequest request = GetEntityRequest.newBuilder().setName(name).build();
    return getEntity(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a metadata entity.
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
   *   GetEntityRequest request =
   *       GetEntityRequest.newBuilder()
   *           .setName(
   *               EntityName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ENTITY]")
   *                   .toString())
   *           .build();
   *   Entity response = metadataServiceClient.getEntity(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Entity getEntity(GetEntityRequest request) {
    return getEntityCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a metadata entity.
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
   *   GetEntityRequest request =
   *       GetEntityRequest.newBuilder()
   *           .setName(
   *               EntityName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ENTITY]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Entity> future = metadataServiceClient.getEntityCallable().futureCall(request);
   *   // Do something.
   *   Entity response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetEntityRequest, Entity> getEntityCallable() {
    return stub.getEntityCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List metadata entities in a zone.
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
   *   ZoneName parent = ZoneName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]");
   *   for (Entity element : metadataServiceClient.listEntities(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the parent zone:
   *     `projects/{project_number}/locations/{location_id}/lakes/{lake_id}/zones/{zone_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEntitiesPagedResponse listEntities(ZoneName parent) {
    ListEntitiesRequest request =
        ListEntitiesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listEntities(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List metadata entities in a zone.
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
   *   String parent = ZoneName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]").toString();
   *   for (Entity element : metadataServiceClient.listEntities(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the parent zone:
   *     `projects/{project_number}/locations/{location_id}/lakes/{lake_id}/zones/{zone_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEntitiesPagedResponse listEntities(String parent) {
    ListEntitiesRequest request = ListEntitiesRequest.newBuilder().setParent(parent).build();
    return listEntities(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List metadata entities in a zone.
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
   *   ListEntitiesRequest request =
   *       ListEntitiesRequest.newBuilder()
   *           .setParent(ZoneName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (Entity element : metadataServiceClient.listEntities(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEntitiesPagedResponse listEntities(ListEntitiesRequest request) {
    return listEntitiesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List metadata entities in a zone.
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
   *   ListEntitiesRequest request =
   *       ListEntitiesRequest.newBuilder()
   *           .setParent(ZoneName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<Entity> future =
   *       metadataServiceClient.listEntitiesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Entity element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListEntitiesRequest, ListEntitiesPagedResponse>
      listEntitiesPagedCallable() {
    return stub.listEntitiesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List metadata entities in a zone.
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
   *   ListEntitiesRequest request =
   *       ListEntitiesRequest.newBuilder()
   *           .setParent(ZoneName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListEntitiesResponse response = metadataServiceClient.listEntitiesCallable().call(request);
   *     for (Entity element : response.getEntitiesList()) {
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
  public final UnaryCallable<ListEntitiesRequest, ListEntitiesResponse> listEntitiesCallable() {
    return stub.listEntitiesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a metadata partition.
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
   *   EntityName parent = EntityName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ENTITY]");
   *   Partition partition = Partition.newBuilder().build();
   *   Partition response = metadataServiceClient.createPartition(parent, partition);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the parent zone:
   *     `projects/{project_number}/locations/{location_id}/lakes/{lake_id}/zones/{zone_id}/entities/{entity_id}`.
   * @param partition Required. Partition resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Partition createPartition(EntityName parent, Partition partition) {
    CreatePartitionRequest request =
        CreatePartitionRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setPartition(partition)
            .build();
    return createPartition(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a metadata partition.
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
   *       EntityName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ENTITY]").toString();
   *   Partition partition = Partition.newBuilder().build();
   *   Partition response = metadataServiceClient.createPartition(parent, partition);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the parent zone:
   *     `projects/{project_number}/locations/{location_id}/lakes/{lake_id}/zones/{zone_id}/entities/{entity_id}`.
   * @param partition Required. Partition resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Partition createPartition(String parent, Partition partition) {
    CreatePartitionRequest request =
        CreatePartitionRequest.newBuilder().setParent(parent).setPartition(partition).build();
    return createPartition(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a metadata partition.
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
   *   CreatePartitionRequest request =
   *       CreatePartitionRequest.newBuilder()
   *           .setParent(
   *               EntityName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ENTITY]")
   *                   .toString())
   *           .setPartition(Partition.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   Partition response = metadataServiceClient.createPartition(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Partition createPartition(CreatePartitionRequest request) {
    return createPartitionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a metadata partition.
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
   *   CreatePartitionRequest request =
   *       CreatePartitionRequest.newBuilder()
   *           .setParent(
   *               EntityName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ENTITY]")
   *                   .toString())
   *           .setPartition(Partition.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Partition> future =
   *       metadataServiceClient.createPartitionCallable().futureCall(request);
   *   // Do something.
   *   Partition response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreatePartitionRequest, Partition> createPartitionCallable() {
    return stub.createPartitionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a metadata partition.
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
   *   PartitionName name =
   *       PartitionName.of(
   *           "[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ENTITY]", "[PARTITION]");
   *   metadataServiceClient.deletePartition(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the partition. format:
   *     `projects/{project_number}/locations/{location_id}/lakes/{lake_id}/zones/{zone_id}/entities/{entity_id}/partitions/{partition_value_path}`.
   *     The {partition_value_path} segment consists of an ordered sequence of partition values
   *     separated by "/". All values must be provided.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deletePartition(PartitionName name) {
    DeletePartitionRequest request =
        DeletePartitionRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deletePartition(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a metadata partition.
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
   *       PartitionName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ENTITY]", "[PARTITION]")
   *           .toString();
   *   metadataServiceClient.deletePartition(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the partition. format:
   *     `projects/{project_number}/locations/{location_id}/lakes/{lake_id}/zones/{zone_id}/entities/{entity_id}/partitions/{partition_value_path}`.
   *     The {partition_value_path} segment consists of an ordered sequence of partition values
   *     separated by "/". All values must be provided.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deletePartition(String name) {
    DeletePartitionRequest request = DeletePartitionRequest.newBuilder().setName(name).build();
    deletePartition(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a metadata partition.
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
   *   DeletePartitionRequest request =
   *       DeletePartitionRequest.newBuilder()
   *           .setName(
   *               PartitionName.of(
   *                       "[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ENTITY]", "[PARTITION]")
   *                   .toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   metadataServiceClient.deletePartition(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deletePartition(DeletePartitionRequest request) {
    deletePartitionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a metadata partition.
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
   *   DeletePartitionRequest request =
   *       DeletePartitionRequest.newBuilder()
   *           .setName(
   *               PartitionName.of(
   *                       "[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ENTITY]", "[PARTITION]")
   *                   .toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Empty> future = metadataServiceClient.deletePartitionCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeletePartitionRequest, Empty> deletePartitionCallable() {
    return stub.deletePartitionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a metadata partition of an entity.
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
   *   PartitionName name =
   *       PartitionName.of(
   *           "[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ENTITY]", "[PARTITION]");
   *   Partition response = metadataServiceClient.getPartition(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the partition:
   *     `projects/{project_number}/locations/{location_id}/lakes/{lake_id}/zones/{zone_id}/entities/{entity_id}/partitions/{partition_value_path}`.
   *     The {partition_value_path} segment consists of an ordered sequence of partition values
   *     separated by "/". All values must be provided.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Partition getPartition(PartitionName name) {
    GetPartitionRequest request =
        GetPartitionRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getPartition(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a metadata partition of an entity.
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
   *       PartitionName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ENTITY]", "[PARTITION]")
   *           .toString();
   *   Partition response = metadataServiceClient.getPartition(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the partition:
   *     `projects/{project_number}/locations/{location_id}/lakes/{lake_id}/zones/{zone_id}/entities/{entity_id}/partitions/{partition_value_path}`.
   *     The {partition_value_path} segment consists of an ordered sequence of partition values
   *     separated by "/". All values must be provided.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Partition getPartition(String name) {
    GetPartitionRequest request = GetPartitionRequest.newBuilder().setName(name).build();
    return getPartition(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a metadata partition of an entity.
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
   *   GetPartitionRequest request =
   *       GetPartitionRequest.newBuilder()
   *           .setName(
   *               PartitionName.of(
   *                       "[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ENTITY]", "[PARTITION]")
   *                   .toString())
   *           .build();
   *   Partition response = metadataServiceClient.getPartition(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Partition getPartition(GetPartitionRequest request) {
    return getPartitionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a metadata partition of an entity.
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
   *   GetPartitionRequest request =
   *       GetPartitionRequest.newBuilder()
   *           .setName(
   *               PartitionName.of(
   *                       "[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ENTITY]", "[PARTITION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Partition> future =
   *       metadataServiceClient.getPartitionCallable().futureCall(request);
   *   // Do something.
   *   Partition response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetPartitionRequest, Partition> getPartitionCallable() {
    return stub.getPartitionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List metadata partitions of an entity.
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
   *   EntityName parent = EntityName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ENTITY]");
   *   for (Partition element : metadataServiceClient.listPartitions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the parent entity:
   *     `projects/{project_number}/locations/{location_id}/lakes/{lake_id}/zones/{zone_id}/entities/{entity_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPartitionsPagedResponse listPartitions(EntityName parent) {
    ListPartitionsRequest request =
        ListPartitionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listPartitions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List metadata partitions of an entity.
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
   *       EntityName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ENTITY]").toString();
   *   for (Partition element : metadataServiceClient.listPartitions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the parent entity:
   *     `projects/{project_number}/locations/{location_id}/lakes/{lake_id}/zones/{zone_id}/entities/{entity_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPartitionsPagedResponse listPartitions(String parent) {
    ListPartitionsRequest request = ListPartitionsRequest.newBuilder().setParent(parent).build();
    return listPartitions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List metadata partitions of an entity.
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
   *   ListPartitionsRequest request =
   *       ListPartitionsRequest.newBuilder()
   *           .setParent(
   *               EntityName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ENTITY]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (Partition element : metadataServiceClient.listPartitions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPartitionsPagedResponse listPartitions(ListPartitionsRequest request) {
    return listPartitionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List metadata partitions of an entity.
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
   *   ListPartitionsRequest request =
   *       ListPartitionsRequest.newBuilder()
   *           .setParent(
   *               EntityName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ENTITY]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<Partition> future =
   *       metadataServiceClient.listPartitionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Partition element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListPartitionsRequest, ListPartitionsPagedResponse>
      listPartitionsPagedCallable() {
    return stub.listPartitionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List metadata partitions of an entity.
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
   *   ListPartitionsRequest request =
   *       ListPartitionsRequest.newBuilder()
   *           .setParent(
   *               EntityName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ENTITY]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListPartitionsResponse response =
   *         metadataServiceClient.listPartitionsCallable().call(request);
   *     for (Partition element : response.getPartitionsList()) {
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
  public final UnaryCallable<ListPartitionsRequest, ListPartitionsResponse>
      listPartitionsCallable() {
    return stub.listPartitionsCallable();
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

  public static class ListEntitiesPagedResponse
      extends AbstractPagedListResponse<
          ListEntitiesRequest,
          ListEntitiesResponse,
          Entity,
          ListEntitiesPage,
          ListEntitiesFixedSizeCollection> {

    public static ApiFuture<ListEntitiesPagedResponse> createAsync(
        PageContext<ListEntitiesRequest, ListEntitiesResponse, Entity> context,
        ApiFuture<ListEntitiesResponse> futureResponse) {
      ApiFuture<ListEntitiesPage> futurePage =
          ListEntitiesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListEntitiesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListEntitiesPagedResponse(ListEntitiesPage page) {
      super(page, ListEntitiesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListEntitiesPage
      extends AbstractPage<ListEntitiesRequest, ListEntitiesResponse, Entity, ListEntitiesPage> {

    private ListEntitiesPage(
        PageContext<ListEntitiesRequest, ListEntitiesResponse, Entity> context,
        ListEntitiesResponse response) {
      super(context, response);
    }

    private static ListEntitiesPage createEmptyPage() {
      return new ListEntitiesPage(null, null);
    }

    @Override
    protected ListEntitiesPage createPage(
        PageContext<ListEntitiesRequest, ListEntitiesResponse, Entity> context,
        ListEntitiesResponse response) {
      return new ListEntitiesPage(context, response);
    }

    @Override
    public ApiFuture<ListEntitiesPage> createPageAsync(
        PageContext<ListEntitiesRequest, ListEntitiesResponse, Entity> context,
        ApiFuture<ListEntitiesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListEntitiesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListEntitiesRequest,
          ListEntitiesResponse,
          Entity,
          ListEntitiesPage,
          ListEntitiesFixedSizeCollection> {

    private ListEntitiesFixedSizeCollection(List<ListEntitiesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListEntitiesFixedSizeCollection createEmptyCollection() {
      return new ListEntitiesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListEntitiesFixedSizeCollection createCollection(
        List<ListEntitiesPage> pages, int collectionSize) {
      return new ListEntitiesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListPartitionsPagedResponse
      extends AbstractPagedListResponse<
          ListPartitionsRequest,
          ListPartitionsResponse,
          Partition,
          ListPartitionsPage,
          ListPartitionsFixedSizeCollection> {

    public static ApiFuture<ListPartitionsPagedResponse> createAsync(
        PageContext<ListPartitionsRequest, ListPartitionsResponse, Partition> context,
        ApiFuture<ListPartitionsResponse> futureResponse) {
      ApiFuture<ListPartitionsPage> futurePage =
          ListPartitionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListPartitionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListPartitionsPagedResponse(ListPartitionsPage page) {
      super(page, ListPartitionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPartitionsPage
      extends AbstractPage<
          ListPartitionsRequest, ListPartitionsResponse, Partition, ListPartitionsPage> {

    private ListPartitionsPage(
        PageContext<ListPartitionsRequest, ListPartitionsResponse, Partition> context,
        ListPartitionsResponse response) {
      super(context, response);
    }

    private static ListPartitionsPage createEmptyPage() {
      return new ListPartitionsPage(null, null);
    }

    @Override
    protected ListPartitionsPage createPage(
        PageContext<ListPartitionsRequest, ListPartitionsResponse, Partition> context,
        ListPartitionsResponse response) {
      return new ListPartitionsPage(context, response);
    }

    @Override
    public ApiFuture<ListPartitionsPage> createPageAsync(
        PageContext<ListPartitionsRequest, ListPartitionsResponse, Partition> context,
        ApiFuture<ListPartitionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListPartitionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListPartitionsRequest,
          ListPartitionsResponse,
          Partition,
          ListPartitionsPage,
          ListPartitionsFixedSizeCollection> {

    private ListPartitionsFixedSizeCollection(List<ListPartitionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListPartitionsFixedSizeCollection createEmptyCollection() {
      return new ListPartitionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListPartitionsFixedSizeCollection createCollection(
        List<ListPartitionsPage> pages, int collectionSize) {
      return new ListPartitionsFixedSizeCollection(pages, collectionSize);
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
