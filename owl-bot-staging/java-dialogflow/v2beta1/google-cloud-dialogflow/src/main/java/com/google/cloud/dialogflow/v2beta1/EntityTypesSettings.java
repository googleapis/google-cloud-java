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

package com.google.cloud.dialogflow.v2beta1;

import static com.google.cloud.dialogflow.v2beta1.EntityTypesClient.ListEntityTypesPagedResponse;
import static com.google.cloud.dialogflow.v2beta1.EntityTypesClient.ListLocationsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.dialogflow.v2beta1.stub.EntityTypesStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.Struct;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link EntityTypesClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (dialogflow.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getEntityType to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * EntityTypesSettings.Builder entityTypesSettingsBuilder = EntityTypesSettings.newBuilder();
 * entityTypesSettingsBuilder
 *     .getEntityTypeSettings()
 *     .setRetrySettings(
 *         entityTypesSettingsBuilder
 *             .getEntityTypeSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * EntityTypesSettings entityTypesSettings = entityTypesSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class EntityTypesSettings extends ClientSettings<EntityTypesSettings> {

  /** Returns the object with the settings used for calls to listEntityTypes. */
  public PagedCallSettings<
          ListEntityTypesRequest, ListEntityTypesResponse, ListEntityTypesPagedResponse>
      listEntityTypesSettings() {
    return ((EntityTypesStubSettings) getStubSettings()).listEntityTypesSettings();
  }

  /** Returns the object with the settings used for calls to getEntityType. */
  public UnaryCallSettings<GetEntityTypeRequest, EntityType> getEntityTypeSettings() {
    return ((EntityTypesStubSettings) getStubSettings()).getEntityTypeSettings();
  }

  /** Returns the object with the settings used for calls to createEntityType. */
  public UnaryCallSettings<CreateEntityTypeRequest, EntityType> createEntityTypeSettings() {
    return ((EntityTypesStubSettings) getStubSettings()).createEntityTypeSettings();
  }

  /** Returns the object with the settings used for calls to updateEntityType. */
  public UnaryCallSettings<UpdateEntityTypeRequest, EntityType> updateEntityTypeSettings() {
    return ((EntityTypesStubSettings) getStubSettings()).updateEntityTypeSettings();
  }

  /** Returns the object with the settings used for calls to deleteEntityType. */
  public UnaryCallSettings<DeleteEntityTypeRequest, Empty> deleteEntityTypeSettings() {
    return ((EntityTypesStubSettings) getStubSettings()).deleteEntityTypeSettings();
  }

  /** Returns the object with the settings used for calls to batchUpdateEntityTypes. */
  public UnaryCallSettings<BatchUpdateEntityTypesRequest, Operation>
      batchUpdateEntityTypesSettings() {
    return ((EntityTypesStubSettings) getStubSettings()).batchUpdateEntityTypesSettings();
  }

  /** Returns the object with the settings used for calls to batchUpdateEntityTypes. */
  public OperationCallSettings<
          BatchUpdateEntityTypesRequest, BatchUpdateEntityTypesResponse, Struct>
      batchUpdateEntityTypesOperationSettings() {
    return ((EntityTypesStubSettings) getStubSettings()).batchUpdateEntityTypesOperationSettings();
  }

  /** Returns the object with the settings used for calls to batchDeleteEntityTypes. */
  public UnaryCallSettings<BatchDeleteEntityTypesRequest, Operation>
      batchDeleteEntityTypesSettings() {
    return ((EntityTypesStubSettings) getStubSettings()).batchDeleteEntityTypesSettings();
  }

  /** Returns the object with the settings used for calls to batchDeleteEntityTypes. */
  public OperationCallSettings<BatchDeleteEntityTypesRequest, Empty, Struct>
      batchDeleteEntityTypesOperationSettings() {
    return ((EntityTypesStubSettings) getStubSettings()).batchDeleteEntityTypesOperationSettings();
  }

  /** Returns the object with the settings used for calls to batchCreateEntities. */
  public UnaryCallSettings<BatchCreateEntitiesRequest, Operation> batchCreateEntitiesSettings() {
    return ((EntityTypesStubSettings) getStubSettings()).batchCreateEntitiesSettings();
  }

  /** Returns the object with the settings used for calls to batchCreateEntities. */
  public OperationCallSettings<BatchCreateEntitiesRequest, Empty, Struct>
      batchCreateEntitiesOperationSettings() {
    return ((EntityTypesStubSettings) getStubSettings()).batchCreateEntitiesOperationSettings();
  }

  /** Returns the object with the settings used for calls to batchUpdateEntities. */
  public UnaryCallSettings<BatchUpdateEntitiesRequest, Operation> batchUpdateEntitiesSettings() {
    return ((EntityTypesStubSettings) getStubSettings()).batchUpdateEntitiesSettings();
  }

  /** Returns the object with the settings used for calls to batchUpdateEntities. */
  public OperationCallSettings<BatchUpdateEntitiesRequest, Empty, Struct>
      batchUpdateEntitiesOperationSettings() {
    return ((EntityTypesStubSettings) getStubSettings()).batchUpdateEntitiesOperationSettings();
  }

  /** Returns the object with the settings used for calls to batchDeleteEntities. */
  public UnaryCallSettings<BatchDeleteEntitiesRequest, Operation> batchDeleteEntitiesSettings() {
    return ((EntityTypesStubSettings) getStubSettings()).batchDeleteEntitiesSettings();
  }

  /** Returns the object with the settings used for calls to batchDeleteEntities. */
  public OperationCallSettings<BatchDeleteEntitiesRequest, Empty, Struct>
      batchDeleteEntitiesOperationSettings() {
    return ((EntityTypesStubSettings) getStubSettings()).batchDeleteEntitiesOperationSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((EntityTypesStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((EntityTypesStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final EntityTypesSettings create(EntityTypesStubSettings stub) throws IOException {
    return new EntityTypesSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return EntityTypesStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return EntityTypesStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return EntityTypesStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return EntityTypesStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return EntityTypesStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return EntityTypesStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return EntityTypesStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return EntityTypesStubSettings.defaultApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
  @BetaApi
  public static Builder newHttpJsonBuilder() {
    return Builder.createHttpJsonDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected EntityTypesSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for EntityTypesSettings. */
  public static class Builder extends ClientSettings.Builder<EntityTypesSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(EntityTypesStubSettings.newBuilder(clientContext));
    }

    protected Builder(EntityTypesSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(EntityTypesStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(EntityTypesStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(EntityTypesStubSettings.newHttpJsonBuilder());
    }

    public EntityTypesStubSettings.Builder getStubSettingsBuilder() {
      return ((EntityTypesStubSettings.Builder) getStubSettings());
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(
          getStubSettingsBuilder().unaryMethodSettingsBuilders(), settingsUpdater);
      return this;
    }

    /** Returns the builder for the settings used for calls to listEntityTypes. */
    public PagedCallSettings.Builder<
            ListEntityTypesRequest, ListEntityTypesResponse, ListEntityTypesPagedResponse>
        listEntityTypesSettings() {
      return getStubSettingsBuilder().listEntityTypesSettings();
    }

    /** Returns the builder for the settings used for calls to getEntityType. */
    public UnaryCallSettings.Builder<GetEntityTypeRequest, EntityType> getEntityTypeSettings() {
      return getStubSettingsBuilder().getEntityTypeSettings();
    }

    /** Returns the builder for the settings used for calls to createEntityType. */
    public UnaryCallSettings.Builder<CreateEntityTypeRequest, EntityType>
        createEntityTypeSettings() {
      return getStubSettingsBuilder().createEntityTypeSettings();
    }

    /** Returns the builder for the settings used for calls to updateEntityType. */
    public UnaryCallSettings.Builder<UpdateEntityTypeRequest, EntityType>
        updateEntityTypeSettings() {
      return getStubSettingsBuilder().updateEntityTypeSettings();
    }

    /** Returns the builder for the settings used for calls to deleteEntityType. */
    public UnaryCallSettings.Builder<DeleteEntityTypeRequest, Empty> deleteEntityTypeSettings() {
      return getStubSettingsBuilder().deleteEntityTypeSettings();
    }

    /** Returns the builder for the settings used for calls to batchUpdateEntityTypes. */
    public UnaryCallSettings.Builder<BatchUpdateEntityTypesRequest, Operation>
        batchUpdateEntityTypesSettings() {
      return getStubSettingsBuilder().batchUpdateEntityTypesSettings();
    }

    /** Returns the builder for the settings used for calls to batchUpdateEntityTypes. */
    public OperationCallSettings.Builder<
            BatchUpdateEntityTypesRequest, BatchUpdateEntityTypesResponse, Struct>
        batchUpdateEntityTypesOperationSettings() {
      return getStubSettingsBuilder().batchUpdateEntityTypesOperationSettings();
    }

    /** Returns the builder for the settings used for calls to batchDeleteEntityTypes. */
    public UnaryCallSettings.Builder<BatchDeleteEntityTypesRequest, Operation>
        batchDeleteEntityTypesSettings() {
      return getStubSettingsBuilder().batchDeleteEntityTypesSettings();
    }

    /** Returns the builder for the settings used for calls to batchDeleteEntityTypes. */
    public OperationCallSettings.Builder<BatchDeleteEntityTypesRequest, Empty, Struct>
        batchDeleteEntityTypesOperationSettings() {
      return getStubSettingsBuilder().batchDeleteEntityTypesOperationSettings();
    }

    /** Returns the builder for the settings used for calls to batchCreateEntities. */
    public UnaryCallSettings.Builder<BatchCreateEntitiesRequest, Operation>
        batchCreateEntitiesSettings() {
      return getStubSettingsBuilder().batchCreateEntitiesSettings();
    }

    /** Returns the builder for the settings used for calls to batchCreateEntities. */
    public OperationCallSettings.Builder<BatchCreateEntitiesRequest, Empty, Struct>
        batchCreateEntitiesOperationSettings() {
      return getStubSettingsBuilder().batchCreateEntitiesOperationSettings();
    }

    /** Returns the builder for the settings used for calls to batchUpdateEntities. */
    public UnaryCallSettings.Builder<BatchUpdateEntitiesRequest, Operation>
        batchUpdateEntitiesSettings() {
      return getStubSettingsBuilder().batchUpdateEntitiesSettings();
    }

    /** Returns the builder for the settings used for calls to batchUpdateEntities. */
    public OperationCallSettings.Builder<BatchUpdateEntitiesRequest, Empty, Struct>
        batchUpdateEntitiesOperationSettings() {
      return getStubSettingsBuilder().batchUpdateEntitiesOperationSettings();
    }

    /** Returns the builder for the settings used for calls to batchDeleteEntities. */
    public UnaryCallSettings.Builder<BatchDeleteEntitiesRequest, Operation>
        batchDeleteEntitiesSettings() {
      return getStubSettingsBuilder().batchDeleteEntitiesSettings();
    }

    /** Returns the builder for the settings used for calls to batchDeleteEntities. */
    public OperationCallSettings.Builder<BatchDeleteEntitiesRequest, Empty, Struct>
        batchDeleteEntitiesOperationSettings() {
      return getStubSettingsBuilder().batchDeleteEntitiesOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listLocations. */
    public PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings() {
      return getStubSettingsBuilder().listLocationsSettings();
    }

    /** Returns the builder for the settings used for calls to getLocation. */
    public UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings() {
      return getStubSettingsBuilder().getLocationSettings();
    }

    @Override
    public EntityTypesSettings build() throws IOException {
      return new EntityTypesSettings(this);
    }
  }
}
