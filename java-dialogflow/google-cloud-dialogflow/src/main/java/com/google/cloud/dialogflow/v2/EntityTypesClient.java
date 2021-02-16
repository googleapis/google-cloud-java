/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.dialogflow.v2;

import com.google.api.core.ApiFunction;
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
import com.google.cloud.dialogflow.v2.stub.EntityTypesStub;
import com.google.cloud.dialogflow.v2.stub.EntityTypesStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import com.google.protobuf.Empty;
import com.google.protobuf.Struct;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for managing [EntityTypes][google.cloud.dialogflow.v2.EntityType].
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <p>Note: close() needs to be called on the EntityTypesClient object to clean up resources such as
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
 * <p>This class can be customized by passing in a custom instance of EntityTypesSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * EntityTypesSettings entityTypesSettings =
 *     EntityTypesSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * EntityTypesClient entityTypesClient = EntityTypesClient.create(entityTypesSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * EntityTypesSettings entityTypesSettings =
 *     EntityTypesSettings.newBuilder().setEndpoint(myEndpoint).build();
 * EntityTypesClient entityTypesClient = EntityTypesClient.create(entityTypesSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator")
public class EntityTypesClient implements BackgroundResource {
  private final EntityTypesSettings settings;
  private final EntityTypesStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of EntityTypesClient with default settings. */
  public static final EntityTypesClient create() throws IOException {
    return create(EntityTypesSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of EntityTypesClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final EntityTypesClient create(EntityTypesSettings settings) throws IOException {
    return new EntityTypesClient(settings);
  }

  /**
   * Constructs an instance of EntityTypesClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(EntityTypesSettings).
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final EntityTypesClient create(EntityTypesStub stub) {
    return new EntityTypesClient(stub);
  }

  /**
   * Constructs an instance of EntityTypesClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected EntityTypesClient(EntityTypesSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((EntityTypesStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected EntityTypesClient(EntityTypesStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final EntityTypesSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public EntityTypesStub getStub() {
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
   * Returns the list of all entity types in the specified agent.
   *
   * @param parent Required. The agent to list all entity types from. Format: `projects/&lt;Project
   *     ID&gt;/agent`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEntityTypesPagedResponse listEntityTypes(AgentName parent) {
    ListEntityTypesRequest request =
        ListEntityTypesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listEntityTypes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all entity types in the specified agent.
   *
   * @param parent Required. The agent to list all entity types from. Format: `projects/&lt;Project
   *     ID&gt;/agent`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEntityTypesPagedResponse listEntityTypes(String parent) {
    ListEntityTypesRequest request = ListEntityTypesRequest.newBuilder().setParent(parent).build();
    return listEntityTypes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all entity types in the specified agent.
   *
   * @param parent Required. The agent to list all entity types from. Format: `projects/&lt;Project
   *     ID&gt;/agent`.
   * @param languageCode Optional. The language used to access language-specific data. If not
   *     specified, the agent's default language is used. For more information, see [Multilingual
   *     intent and entity
   *     data](https://cloud.google.com/dialogflow/docs/agents-multilingual#intent-entity).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEntityTypesPagedResponse listEntityTypes(AgentName parent, String languageCode) {
    ListEntityTypesRequest request =
        ListEntityTypesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setLanguageCode(languageCode)
            .build();
    return listEntityTypes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all entity types in the specified agent.
   *
   * @param parent Required. The agent to list all entity types from. Format: `projects/&lt;Project
   *     ID&gt;/agent`.
   * @param languageCode Optional. The language used to access language-specific data. If not
   *     specified, the agent's default language is used. For more information, see [Multilingual
   *     intent and entity
   *     data](https://cloud.google.com/dialogflow/docs/agents-multilingual#intent-entity).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEntityTypesPagedResponse listEntityTypes(String parent, String languageCode) {
    ListEntityTypesRequest request =
        ListEntityTypesRequest.newBuilder().setParent(parent).setLanguageCode(languageCode).build();
    return listEntityTypes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all entity types in the specified agent.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEntityTypesPagedResponse listEntityTypes(ListEntityTypesRequest request) {
    return listEntityTypesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all entity types in the specified agent.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListEntityTypesRequest, ListEntityTypesPagedResponse>
      listEntityTypesPagedCallable() {
    return stub.listEntityTypesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all entity types in the specified agent.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListEntityTypesRequest, ListEntityTypesResponse>
      listEntityTypesCallable() {
    return stub.listEntityTypesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified entity type.
   *
   * @param name Required. The name of the entity type. Format: `projects/&lt;Project
   *     ID&gt;/agent/entityTypes/&lt;EntityType ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EntityType getEntityType(EntityTypeName name) {
    GetEntityTypeRequest request =
        GetEntityTypeRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getEntityType(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified entity type.
   *
   * @param name Required. The name of the entity type. Format: `projects/&lt;Project
   *     ID&gt;/agent/entityTypes/&lt;EntityType ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EntityType getEntityType(String name) {
    GetEntityTypeRequest request = GetEntityTypeRequest.newBuilder().setName(name).build();
    return getEntityType(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified entity type.
   *
   * @param name Required. The name of the entity type. Format: `projects/&lt;Project
   *     ID&gt;/agent/entityTypes/&lt;EntityType ID&gt;`.
   * @param languageCode Optional. The language used to access language-specific data. If not
   *     specified, the agent's default language is used. For more information, see [Multilingual
   *     intent and entity
   *     data](https://cloud.google.com/dialogflow/docs/agents-multilingual#intent-entity).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EntityType getEntityType(EntityTypeName name, String languageCode) {
    GetEntityTypeRequest request =
        GetEntityTypeRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setLanguageCode(languageCode)
            .build();
    return getEntityType(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified entity type.
   *
   * @param name Required. The name of the entity type. Format: `projects/&lt;Project
   *     ID&gt;/agent/entityTypes/&lt;EntityType ID&gt;`.
   * @param languageCode Optional. The language used to access language-specific data. If not
   *     specified, the agent's default language is used. For more information, see [Multilingual
   *     intent and entity
   *     data](https://cloud.google.com/dialogflow/docs/agents-multilingual#intent-entity).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EntityType getEntityType(String name, String languageCode) {
    GetEntityTypeRequest request =
        GetEntityTypeRequest.newBuilder().setName(name).setLanguageCode(languageCode).build();
    return getEntityType(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified entity type.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EntityType getEntityType(GetEntityTypeRequest request) {
    return getEntityTypeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified entity type.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<GetEntityTypeRequest, EntityType> getEntityTypeCallable() {
    return stub.getEntityTypeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an entity type in the specified agent.
   *
   * @param parent Required. The agent to create a entity type for. Format: `projects/&lt;Project
   *     ID&gt;/agent`.
   * @param entityType Required. The entity type to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EntityType createEntityType(AgentName parent, EntityType entityType) {
    CreateEntityTypeRequest request =
        CreateEntityTypeRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setEntityType(entityType)
            .build();
    return createEntityType(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an entity type in the specified agent.
   *
   * @param parent Required. The agent to create a entity type for. Format: `projects/&lt;Project
   *     ID&gt;/agent`.
   * @param entityType Required. The entity type to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EntityType createEntityType(String parent, EntityType entityType) {
    CreateEntityTypeRequest request =
        CreateEntityTypeRequest.newBuilder().setParent(parent).setEntityType(entityType).build();
    return createEntityType(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an entity type in the specified agent.
   *
   * @param parent Required. The agent to create a entity type for. Format: `projects/&lt;Project
   *     ID&gt;/agent`.
   * @param entityType Required. The entity type to create.
   * @param languageCode Optional. The language used to access language-specific data. If not
   *     specified, the agent's default language is used. For more information, see [Multilingual
   *     intent and entity
   *     data](https://cloud.google.com/dialogflow/docs/agents-multilingual#intent-entity).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EntityType createEntityType(
      AgentName parent, EntityType entityType, String languageCode) {
    CreateEntityTypeRequest request =
        CreateEntityTypeRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setEntityType(entityType)
            .setLanguageCode(languageCode)
            .build();
    return createEntityType(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an entity type in the specified agent.
   *
   * @param parent Required. The agent to create a entity type for. Format: `projects/&lt;Project
   *     ID&gt;/agent`.
   * @param entityType Required. The entity type to create.
   * @param languageCode Optional. The language used to access language-specific data. If not
   *     specified, the agent's default language is used. For more information, see [Multilingual
   *     intent and entity
   *     data](https://cloud.google.com/dialogflow/docs/agents-multilingual#intent-entity).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EntityType createEntityType(
      String parent, EntityType entityType, String languageCode) {
    CreateEntityTypeRequest request =
        CreateEntityTypeRequest.newBuilder()
            .setParent(parent)
            .setEntityType(entityType)
            .setLanguageCode(languageCode)
            .build();
    return createEntityType(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an entity type in the specified agent.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EntityType createEntityType(CreateEntityTypeRequest request) {
    return createEntityTypeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an entity type in the specified agent.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<CreateEntityTypeRequest, EntityType> createEntityTypeCallable() {
    return stub.createEntityTypeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified entity type.
   *
   * @param entityType Required. The entity type to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EntityType updateEntityType(EntityType entityType) {
    UpdateEntityTypeRequest request =
        UpdateEntityTypeRequest.newBuilder().setEntityType(entityType).build();
    return updateEntityType(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified entity type.
   *
   * @param entityType Required. The entity type to update.
   * @param languageCode Optional. The language used to access language-specific data. If not
   *     specified, the agent's default language is used. For more information, see [Multilingual
   *     intent and entity
   *     data](https://cloud.google.com/dialogflow/docs/agents-multilingual#intent-entity).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EntityType updateEntityType(EntityType entityType, String languageCode) {
    UpdateEntityTypeRequest request =
        UpdateEntityTypeRequest.newBuilder()
            .setEntityType(entityType)
            .setLanguageCode(languageCode)
            .build();
    return updateEntityType(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified entity type.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EntityType updateEntityType(UpdateEntityTypeRequest request) {
    return updateEntityTypeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified entity type.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<UpdateEntityTypeRequest, EntityType> updateEntityTypeCallable() {
    return stub.updateEntityTypeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified entity type.
   *
   * @param name Required. The name of the entity type to delete. Format: `projects/&lt;Project
   *     ID&gt;/agent/entityTypes/&lt;EntityType ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteEntityType(EntityTypeName name) {
    DeleteEntityTypeRequest request =
        DeleteEntityTypeRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteEntityType(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified entity type.
   *
   * @param name Required. The name of the entity type to delete. Format: `projects/&lt;Project
   *     ID&gt;/agent/entityTypes/&lt;EntityType ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteEntityType(String name) {
    DeleteEntityTypeRequest request = DeleteEntityTypeRequest.newBuilder().setName(name).build();
    deleteEntityType(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified entity type.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteEntityType(DeleteEntityTypeRequest request) {
    deleteEntityTypeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified entity type.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<DeleteEntityTypeRequest, Empty> deleteEntityTypeCallable() {
    return stub.deleteEntityTypeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates/Creates multiple entity types in the specified agent.
   *
   * <p>Operation &lt;response:
   * [BatchUpdateEntityTypesResponse][google.cloud.dialogflow.v2.BatchUpdateEntityTypesResponse]&gt;
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BatchUpdateEntityTypesResponse, Struct> batchUpdateEntityTypesAsync(
      BatchUpdateEntityTypesRequest request) {
    return batchUpdateEntityTypesOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates/Creates multiple entity types in the specified agent.
   *
   * <p>Operation &lt;response:
   * [BatchUpdateEntityTypesResponse][google.cloud.dialogflow.v2.BatchUpdateEntityTypesResponse]&gt;
   *
   * <p>Sample code:
   */
  public final OperationCallable<
          BatchUpdateEntityTypesRequest, BatchUpdateEntityTypesResponse, Struct>
      batchUpdateEntityTypesOperationCallable() {
    return stub.batchUpdateEntityTypesOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates/Creates multiple entity types in the specified agent.
   *
   * <p>Operation &lt;response:
   * [BatchUpdateEntityTypesResponse][google.cloud.dialogflow.v2.BatchUpdateEntityTypesResponse]&gt;
   *
   * <p>Sample code:
   */
  public final UnaryCallable<BatchUpdateEntityTypesRequest, Operation>
      batchUpdateEntityTypesCallable() {
    return stub.batchUpdateEntityTypesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes entity types in the specified agent.
   *
   * <p>Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty]&gt;
   *
   * @param parent Required. The name of the agent to delete all entities types for. Format:
   *     `projects/&lt;Project ID&gt;/agent`.
   * @param entityTypeNames Required. The names entity types to delete. All names must point to the
   *     same agent as `parent`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, Struct> batchDeleteEntityTypesAsync(
      AgentName parent, List<String> entityTypeNames) {
    BatchDeleteEntityTypesRequest request =
        BatchDeleteEntityTypesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllEntityTypeNames(entityTypeNames)
            .build();
    return batchDeleteEntityTypesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes entity types in the specified agent.
   *
   * <p>Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty]&gt;
   *
   * @param parent Required. The name of the agent to delete all entities types for. Format:
   *     `projects/&lt;Project ID&gt;/agent`.
   * @param entityTypeNames Required. The names entity types to delete. All names must point to the
   *     same agent as `parent`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, Struct> batchDeleteEntityTypesAsync(
      String parent, List<String> entityTypeNames) {
    BatchDeleteEntityTypesRequest request =
        BatchDeleteEntityTypesRequest.newBuilder()
            .setParent(parent)
            .addAllEntityTypeNames(entityTypeNames)
            .build();
    return batchDeleteEntityTypesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes entity types in the specified agent.
   *
   * <p>Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty]&gt;
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, Struct> batchDeleteEntityTypesAsync(
      BatchDeleteEntityTypesRequest request) {
    return batchDeleteEntityTypesOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes entity types in the specified agent.
   *
   * <p>Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty]&gt;
   *
   * <p>Sample code:
   */
  public final OperationCallable<BatchDeleteEntityTypesRequest, Empty, Struct>
      batchDeleteEntityTypesOperationCallable() {
    return stub.batchDeleteEntityTypesOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes entity types in the specified agent.
   *
   * <p>Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty]&gt;
   *
   * <p>Sample code:
   */
  public final UnaryCallable<BatchDeleteEntityTypesRequest, Operation>
      batchDeleteEntityTypesCallable() {
    return stub.batchDeleteEntityTypesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates multiple new entities in the specified entity type.
   *
   * <p>Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty]&gt;
   *
   * @param parent Required. The name of the entity type to create entities in. Format:
   *     `projects/&lt;Project ID&gt;/agent/entityTypes/&lt;Entity Type ID&gt;`.
   * @param entities Required. The entities to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, Struct> batchCreateEntitiesAsync(
      EntityTypeName parent, List<EntityType.Entity> entities) {
    BatchCreateEntitiesRequest request =
        BatchCreateEntitiesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllEntities(entities)
            .build();
    return batchCreateEntitiesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates multiple new entities in the specified entity type.
   *
   * <p>Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty]&gt;
   *
   * @param parent Required. The name of the entity type to create entities in. Format:
   *     `projects/&lt;Project ID&gt;/agent/entityTypes/&lt;Entity Type ID&gt;`.
   * @param entities Required. The entities to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, Struct> batchCreateEntitiesAsync(
      String parent, List<EntityType.Entity> entities) {
    BatchCreateEntitiesRequest request =
        BatchCreateEntitiesRequest.newBuilder().setParent(parent).addAllEntities(entities).build();
    return batchCreateEntitiesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates multiple new entities in the specified entity type.
   *
   * <p>Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty]&gt;
   *
   * @param parent Required. The name of the entity type to create entities in. Format:
   *     `projects/&lt;Project ID&gt;/agent/entityTypes/&lt;Entity Type ID&gt;`.
   * @param entities Required. The entities to create.
   * @param languageCode Optional. The language used to access language-specific data. If not
   *     specified, the agent's default language is used. For more information, see [Multilingual
   *     intent and entity
   *     data](https://cloud.google.com/dialogflow/docs/agents-multilingual#intent-entity).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, Struct> batchCreateEntitiesAsync(
      EntityTypeName parent, List<EntityType.Entity> entities, String languageCode) {
    BatchCreateEntitiesRequest request =
        BatchCreateEntitiesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllEntities(entities)
            .setLanguageCode(languageCode)
            .build();
    return batchCreateEntitiesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates multiple new entities in the specified entity type.
   *
   * <p>Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty]&gt;
   *
   * @param parent Required. The name of the entity type to create entities in. Format:
   *     `projects/&lt;Project ID&gt;/agent/entityTypes/&lt;Entity Type ID&gt;`.
   * @param entities Required. The entities to create.
   * @param languageCode Optional. The language used to access language-specific data. If not
   *     specified, the agent's default language is used. For more information, see [Multilingual
   *     intent and entity
   *     data](https://cloud.google.com/dialogflow/docs/agents-multilingual#intent-entity).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, Struct> batchCreateEntitiesAsync(
      String parent, List<EntityType.Entity> entities, String languageCode) {
    BatchCreateEntitiesRequest request =
        BatchCreateEntitiesRequest.newBuilder()
            .setParent(parent)
            .addAllEntities(entities)
            .setLanguageCode(languageCode)
            .build();
    return batchCreateEntitiesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates multiple new entities in the specified entity type.
   *
   * <p>Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty]&gt;
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, Struct> batchCreateEntitiesAsync(
      BatchCreateEntitiesRequest request) {
    return batchCreateEntitiesOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates multiple new entities in the specified entity type.
   *
   * <p>Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty]&gt;
   *
   * <p>Sample code:
   */
  public final OperationCallable<BatchCreateEntitiesRequest, Empty, Struct>
      batchCreateEntitiesOperationCallable() {
    return stub.batchCreateEntitiesOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates multiple new entities in the specified entity type.
   *
   * <p>Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty]&gt;
   *
   * <p>Sample code:
   */
  public final UnaryCallable<BatchCreateEntitiesRequest, Operation> batchCreateEntitiesCallable() {
    return stub.batchCreateEntitiesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates or creates multiple entities in the specified entity type. This method does not affect
   * entities in the entity type that aren't explicitly specified in the request.
   *
   * <p>Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty]&gt;
   *
   * @param parent Required. The name of the entity type to update or create entities in. Format:
   *     `projects/&lt;Project ID&gt;/agent/entityTypes/&lt;Entity Type ID&gt;`.
   * @param entities Required. The entities to update or create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, Struct> batchUpdateEntitiesAsync(
      EntityTypeName parent, List<EntityType.Entity> entities) {
    BatchUpdateEntitiesRequest request =
        BatchUpdateEntitiesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllEntities(entities)
            .build();
    return batchUpdateEntitiesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates or creates multiple entities in the specified entity type. This method does not affect
   * entities in the entity type that aren't explicitly specified in the request.
   *
   * <p>Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty]&gt;
   *
   * @param parent Required. The name of the entity type to update or create entities in. Format:
   *     `projects/&lt;Project ID&gt;/agent/entityTypes/&lt;Entity Type ID&gt;`.
   * @param entities Required. The entities to update or create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, Struct> batchUpdateEntitiesAsync(
      String parent, List<EntityType.Entity> entities) {
    BatchUpdateEntitiesRequest request =
        BatchUpdateEntitiesRequest.newBuilder().setParent(parent).addAllEntities(entities).build();
    return batchUpdateEntitiesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates or creates multiple entities in the specified entity type. This method does not affect
   * entities in the entity type that aren't explicitly specified in the request.
   *
   * <p>Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty]&gt;
   *
   * @param parent Required. The name of the entity type to update or create entities in. Format:
   *     `projects/&lt;Project ID&gt;/agent/entityTypes/&lt;Entity Type ID&gt;`.
   * @param entities Required. The entities to update or create.
   * @param languageCode Optional. The language used to access language-specific data. If not
   *     specified, the agent's default language is used. For more information, see [Multilingual
   *     intent and entity
   *     data](https://cloud.google.com/dialogflow/docs/agents-multilingual#intent-entity).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, Struct> batchUpdateEntitiesAsync(
      EntityTypeName parent, List<EntityType.Entity> entities, String languageCode) {
    BatchUpdateEntitiesRequest request =
        BatchUpdateEntitiesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllEntities(entities)
            .setLanguageCode(languageCode)
            .build();
    return batchUpdateEntitiesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates or creates multiple entities in the specified entity type. This method does not affect
   * entities in the entity type that aren't explicitly specified in the request.
   *
   * <p>Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty]&gt;
   *
   * @param parent Required. The name of the entity type to update or create entities in. Format:
   *     `projects/&lt;Project ID&gt;/agent/entityTypes/&lt;Entity Type ID&gt;`.
   * @param entities Required. The entities to update or create.
   * @param languageCode Optional. The language used to access language-specific data. If not
   *     specified, the agent's default language is used. For more information, see [Multilingual
   *     intent and entity
   *     data](https://cloud.google.com/dialogflow/docs/agents-multilingual#intent-entity).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, Struct> batchUpdateEntitiesAsync(
      String parent, List<EntityType.Entity> entities, String languageCode) {
    BatchUpdateEntitiesRequest request =
        BatchUpdateEntitiesRequest.newBuilder()
            .setParent(parent)
            .addAllEntities(entities)
            .setLanguageCode(languageCode)
            .build();
    return batchUpdateEntitiesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates or creates multiple entities in the specified entity type. This method does not affect
   * entities in the entity type that aren't explicitly specified in the request.
   *
   * <p>Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty]&gt;
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, Struct> batchUpdateEntitiesAsync(
      BatchUpdateEntitiesRequest request) {
    return batchUpdateEntitiesOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates or creates multiple entities in the specified entity type. This method does not affect
   * entities in the entity type that aren't explicitly specified in the request.
   *
   * <p>Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty]&gt;
   *
   * <p>Sample code:
   */
  public final OperationCallable<BatchUpdateEntitiesRequest, Empty, Struct>
      batchUpdateEntitiesOperationCallable() {
    return stub.batchUpdateEntitiesOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates or creates multiple entities in the specified entity type. This method does not affect
   * entities in the entity type that aren't explicitly specified in the request.
   *
   * <p>Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty]&gt;
   *
   * <p>Sample code:
   */
  public final UnaryCallable<BatchUpdateEntitiesRequest, Operation> batchUpdateEntitiesCallable() {
    return stub.batchUpdateEntitiesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes entities in the specified entity type.
   *
   * <p>Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty]&gt;
   *
   * @param parent Required. The name of the entity type to delete entries for. Format:
   *     `projects/&lt;Project ID&gt;/agent/entityTypes/&lt;Entity Type ID&gt;`.
   * @param entityValues Required. The reference `values` of the entities to delete. Note that these
   *     are not fully-qualified names, i.e. they don't start with `projects/&lt;Project ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, Struct> batchDeleteEntitiesAsync(
      EntityTypeName parent, List<String> entityValues) {
    BatchDeleteEntitiesRequest request =
        BatchDeleteEntitiesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllEntityValues(entityValues)
            .build();
    return batchDeleteEntitiesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes entities in the specified entity type.
   *
   * <p>Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty]&gt;
   *
   * @param parent Required. The name of the entity type to delete entries for. Format:
   *     `projects/&lt;Project ID&gt;/agent/entityTypes/&lt;Entity Type ID&gt;`.
   * @param entityValues Required. The reference `values` of the entities to delete. Note that these
   *     are not fully-qualified names, i.e. they don't start with `projects/&lt;Project ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, Struct> batchDeleteEntitiesAsync(
      String parent, List<String> entityValues) {
    BatchDeleteEntitiesRequest request =
        BatchDeleteEntitiesRequest.newBuilder()
            .setParent(parent)
            .addAllEntityValues(entityValues)
            .build();
    return batchDeleteEntitiesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes entities in the specified entity type.
   *
   * <p>Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty]&gt;
   *
   * @param parent Required. The name of the entity type to delete entries for. Format:
   *     `projects/&lt;Project ID&gt;/agent/entityTypes/&lt;Entity Type ID&gt;`.
   * @param entityValues Required. The reference `values` of the entities to delete. Note that these
   *     are not fully-qualified names, i.e. they don't start with `projects/&lt;Project ID&gt;`.
   * @param languageCode Optional. The language used to access language-specific data. If not
   *     specified, the agent's default language is used. For more information, see [Multilingual
   *     intent and entity
   *     data](https://cloud.google.com/dialogflow/docs/agents-multilingual#intent-entity).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, Struct> batchDeleteEntitiesAsync(
      EntityTypeName parent, List<String> entityValues, String languageCode) {
    BatchDeleteEntitiesRequest request =
        BatchDeleteEntitiesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllEntityValues(entityValues)
            .setLanguageCode(languageCode)
            .build();
    return batchDeleteEntitiesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes entities in the specified entity type.
   *
   * <p>Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty]&gt;
   *
   * @param parent Required. The name of the entity type to delete entries for. Format:
   *     `projects/&lt;Project ID&gt;/agent/entityTypes/&lt;Entity Type ID&gt;`.
   * @param entityValues Required. The reference `values` of the entities to delete. Note that these
   *     are not fully-qualified names, i.e. they don't start with `projects/&lt;Project ID&gt;`.
   * @param languageCode Optional. The language used to access language-specific data. If not
   *     specified, the agent's default language is used. For more information, see [Multilingual
   *     intent and entity
   *     data](https://cloud.google.com/dialogflow/docs/agents-multilingual#intent-entity).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, Struct> batchDeleteEntitiesAsync(
      String parent, List<String> entityValues, String languageCode) {
    BatchDeleteEntitiesRequest request =
        BatchDeleteEntitiesRequest.newBuilder()
            .setParent(parent)
            .addAllEntityValues(entityValues)
            .setLanguageCode(languageCode)
            .build();
    return batchDeleteEntitiesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes entities in the specified entity type.
   *
   * <p>Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty]&gt;
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, Struct> batchDeleteEntitiesAsync(
      BatchDeleteEntitiesRequest request) {
    return batchDeleteEntitiesOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes entities in the specified entity type.
   *
   * <p>Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty]&gt;
   *
   * <p>Sample code:
   */
  public final OperationCallable<BatchDeleteEntitiesRequest, Empty, Struct>
      batchDeleteEntitiesOperationCallable() {
    return stub.batchDeleteEntitiesOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes entities in the specified entity type.
   *
   * <p>Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty]&gt;
   *
   * <p>Sample code:
   */
  public final UnaryCallable<BatchDeleteEntitiesRequest, Operation> batchDeleteEntitiesCallable() {
    return stub.batchDeleteEntitiesCallable();
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

  public static class ListEntityTypesPagedResponse
      extends AbstractPagedListResponse<
          ListEntityTypesRequest,
          ListEntityTypesResponse,
          EntityType,
          ListEntityTypesPage,
          ListEntityTypesFixedSizeCollection> {

    public static ApiFuture<ListEntityTypesPagedResponse> createAsync(
        PageContext<ListEntityTypesRequest, ListEntityTypesResponse, EntityType> context,
        ApiFuture<ListEntityTypesResponse> futureResponse) {
      ApiFuture<ListEntityTypesPage> futurePage =
          ListEntityTypesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListEntityTypesPage, ListEntityTypesPagedResponse>() {
            @Override
            public ListEntityTypesPagedResponse apply(ListEntityTypesPage input) {
              return new ListEntityTypesPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListEntityTypesPagedResponse(ListEntityTypesPage page) {
      super(page, ListEntityTypesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListEntityTypesPage
      extends AbstractPage<
          ListEntityTypesRequest, ListEntityTypesResponse, EntityType, ListEntityTypesPage> {

    private ListEntityTypesPage(
        PageContext<ListEntityTypesRequest, ListEntityTypesResponse, EntityType> context,
        ListEntityTypesResponse response) {
      super(context, response);
    }

    private static ListEntityTypesPage createEmptyPage() {
      return new ListEntityTypesPage(null, null);
    }

    @Override
    protected ListEntityTypesPage createPage(
        PageContext<ListEntityTypesRequest, ListEntityTypesResponse, EntityType> context,
        ListEntityTypesResponse response) {
      return new ListEntityTypesPage(context, response);
    }

    @Override
    public ApiFuture<ListEntityTypesPage> createPageAsync(
        PageContext<ListEntityTypesRequest, ListEntityTypesResponse, EntityType> context,
        ApiFuture<ListEntityTypesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListEntityTypesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListEntityTypesRequest,
          ListEntityTypesResponse,
          EntityType,
          ListEntityTypesPage,
          ListEntityTypesFixedSizeCollection> {

    private ListEntityTypesFixedSizeCollection(
        List<ListEntityTypesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListEntityTypesFixedSizeCollection createEmptyCollection() {
      return new ListEntityTypesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListEntityTypesFixedSizeCollection createCollection(
        List<ListEntityTypesPage> pages, int collectionSize) {
      return new ListEntityTypesFixedSizeCollection(pages, collectionSize);
    }
  }
}
