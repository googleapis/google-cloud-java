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

package com.google.cloud.dialogflow.cx.v3beta1;

import static com.google.cloud.dialogflow.cx.v3beta1.EntityTypesClient.ListEntityTypesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.dialogflow.cx.v3beta1.stub.EntityTypesStubSettings;
import com.google.protobuf.Empty;
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

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return EntityTypesStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return EntityTypesStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return EntityTypesStubSettings.defaultApiClientHeaderProviderBuilder();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
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

    public EntityTypesStubSettings.Builder getStubSettingsBuilder() {
      return ((EntityTypesStubSettings.Builder) getStubSettings());
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'.
    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) throws Exception {
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

    @Override
    public EntityTypesSettings build() throws IOException {
      return new EntityTypesSettings(this);
    }
  }
}
