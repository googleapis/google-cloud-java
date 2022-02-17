/*
 * Copyright 2021 Google LLC
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

import static com.google.cloud.dataplex.v1.MetadataServiceClient.ListEntitiesPagedResponse;
import static com.google.cloud.dataplex.v1.MetadataServiceClient.ListPartitionsPagedResponse;

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
import com.google.cloud.dataplex.v1.stub.MetadataServiceStubSettings;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link MetadataServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (dataplex.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createEntity to 30 seconds:
 *
 * <pre>{@code
 * MetadataServiceSettings.Builder metadataServiceSettingsBuilder =
 *     MetadataServiceSettings.newBuilder();
 * metadataServiceSettingsBuilder
 *     .createEntitySettings()
 *     .setRetrySettings(
 *         metadataServiceSettingsBuilder
 *             .createEntitySettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * MetadataServiceSettings metadataServiceSettings = metadataServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class MetadataServiceSettings extends ClientSettings<MetadataServiceSettings> {

  /** Returns the object with the settings used for calls to createEntity. */
  public UnaryCallSettings<CreateEntityRequest, Entity> createEntitySettings() {
    return ((MetadataServiceStubSettings) getStubSettings()).createEntitySettings();
  }

  /** Returns the object with the settings used for calls to updateEntity. */
  public UnaryCallSettings<UpdateEntityRequest, Entity> updateEntitySettings() {
    return ((MetadataServiceStubSettings) getStubSettings()).updateEntitySettings();
  }

  /** Returns the object with the settings used for calls to deleteEntity. */
  public UnaryCallSettings<DeleteEntityRequest, Empty> deleteEntitySettings() {
    return ((MetadataServiceStubSettings) getStubSettings()).deleteEntitySettings();
  }

  /** Returns the object with the settings used for calls to getEntity. */
  public UnaryCallSettings<GetEntityRequest, Entity> getEntitySettings() {
    return ((MetadataServiceStubSettings) getStubSettings()).getEntitySettings();
  }

  /** Returns the object with the settings used for calls to listEntities. */
  public PagedCallSettings<ListEntitiesRequest, ListEntitiesResponse, ListEntitiesPagedResponse>
      listEntitiesSettings() {
    return ((MetadataServiceStubSettings) getStubSettings()).listEntitiesSettings();
  }

  /** Returns the object with the settings used for calls to createPartition. */
  public UnaryCallSettings<CreatePartitionRequest, Partition> createPartitionSettings() {
    return ((MetadataServiceStubSettings) getStubSettings()).createPartitionSettings();
  }

  /** Returns the object with the settings used for calls to deletePartition. */
  public UnaryCallSettings<DeletePartitionRequest, Empty> deletePartitionSettings() {
    return ((MetadataServiceStubSettings) getStubSettings()).deletePartitionSettings();
  }

  /** Returns the object with the settings used for calls to getPartition. */
  public UnaryCallSettings<GetPartitionRequest, Partition> getPartitionSettings() {
    return ((MetadataServiceStubSettings) getStubSettings()).getPartitionSettings();
  }

  /** Returns the object with the settings used for calls to listPartitions. */
  public PagedCallSettings<
          ListPartitionsRequest, ListPartitionsResponse, ListPartitionsPagedResponse>
      listPartitionsSettings() {
    return ((MetadataServiceStubSettings) getStubSettings()).listPartitionsSettings();
  }

  public static final MetadataServiceSettings create(MetadataServiceStubSettings stub)
      throws IOException {
    return new MetadataServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return MetadataServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return MetadataServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return MetadataServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return MetadataServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return MetadataServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return MetadataServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return MetadataServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected MetadataServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for MetadataServiceSettings. */
  public static class Builder extends ClientSettings.Builder<MetadataServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(MetadataServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(MetadataServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(MetadataServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(MetadataServiceStubSettings.newBuilder());
    }

    public MetadataServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((MetadataServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createEntity. */
    public UnaryCallSettings.Builder<CreateEntityRequest, Entity> createEntitySettings() {
      return getStubSettingsBuilder().createEntitySettings();
    }

    /** Returns the builder for the settings used for calls to updateEntity. */
    public UnaryCallSettings.Builder<UpdateEntityRequest, Entity> updateEntitySettings() {
      return getStubSettingsBuilder().updateEntitySettings();
    }

    /** Returns the builder for the settings used for calls to deleteEntity. */
    public UnaryCallSettings.Builder<DeleteEntityRequest, Empty> deleteEntitySettings() {
      return getStubSettingsBuilder().deleteEntitySettings();
    }

    /** Returns the builder for the settings used for calls to getEntity. */
    public UnaryCallSettings.Builder<GetEntityRequest, Entity> getEntitySettings() {
      return getStubSettingsBuilder().getEntitySettings();
    }

    /** Returns the builder for the settings used for calls to listEntities. */
    public PagedCallSettings.Builder<
            ListEntitiesRequest, ListEntitiesResponse, ListEntitiesPagedResponse>
        listEntitiesSettings() {
      return getStubSettingsBuilder().listEntitiesSettings();
    }

    /** Returns the builder for the settings used for calls to createPartition. */
    public UnaryCallSettings.Builder<CreatePartitionRequest, Partition> createPartitionSettings() {
      return getStubSettingsBuilder().createPartitionSettings();
    }

    /** Returns the builder for the settings used for calls to deletePartition. */
    public UnaryCallSettings.Builder<DeletePartitionRequest, Empty> deletePartitionSettings() {
      return getStubSettingsBuilder().deletePartitionSettings();
    }

    /** Returns the builder for the settings used for calls to getPartition. */
    public UnaryCallSettings.Builder<GetPartitionRequest, Partition> getPartitionSettings() {
      return getStubSettingsBuilder().getPartitionSettings();
    }

    /** Returns the builder for the settings used for calls to listPartitions. */
    public PagedCallSettings.Builder<
            ListPartitionsRequest, ListPartitionsResponse, ListPartitionsPagedResponse>
        listPartitionsSettings() {
      return getStubSettingsBuilder().listPartitionsSettings();
    }

    @Override
    public MetadataServiceSettings build() throws IOException {
      return new MetadataServiceSettings(this);
    }
  }
}
