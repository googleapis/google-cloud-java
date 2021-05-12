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

package com.google.cloud.aiplatform.v1beta1;

import static com.google.cloud.aiplatform.v1beta1.IndexEndpointServiceClient.ListIndexEndpointsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.aiplatform.v1beta1.stub.IndexEndpointServiceStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link IndexEndpointServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (aiplatform.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getIndexEndpoint to 30 seconds:
 *
 * <pre>{@code
 * IndexEndpointServiceSettings.Builder indexEndpointServiceSettingsBuilder =
 *     IndexEndpointServiceSettings.newBuilder();
 * indexEndpointServiceSettingsBuilder
 *     .getIndexEndpointSettings()
 *     .setRetrySettings(
 *         indexEndpointServiceSettingsBuilder
 *             .getIndexEndpointSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * IndexEndpointServiceSettings indexEndpointServiceSettings =
 *     indexEndpointServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class IndexEndpointServiceSettings extends ClientSettings<IndexEndpointServiceSettings> {

  /** Returns the object with the settings used for calls to createIndexEndpoint. */
  public UnaryCallSettings<CreateIndexEndpointRequest, Operation> createIndexEndpointSettings() {
    return ((IndexEndpointServiceStubSettings) getStubSettings()).createIndexEndpointSettings();
  }

  /** Returns the object with the settings used for calls to createIndexEndpoint. */
  public OperationCallSettings<
          CreateIndexEndpointRequest, IndexEndpoint, CreateIndexEndpointOperationMetadata>
      createIndexEndpointOperationSettings() {
    return ((IndexEndpointServiceStubSettings) getStubSettings())
        .createIndexEndpointOperationSettings();
  }

  /** Returns the object with the settings used for calls to getIndexEndpoint. */
  public UnaryCallSettings<GetIndexEndpointRequest, IndexEndpoint> getIndexEndpointSettings() {
    return ((IndexEndpointServiceStubSettings) getStubSettings()).getIndexEndpointSettings();
  }

  /** Returns the object with the settings used for calls to listIndexEndpoints. */
  public PagedCallSettings<
          ListIndexEndpointsRequest, ListIndexEndpointsResponse, ListIndexEndpointsPagedResponse>
      listIndexEndpointsSettings() {
    return ((IndexEndpointServiceStubSettings) getStubSettings()).listIndexEndpointsSettings();
  }

  /** Returns the object with the settings used for calls to updateIndexEndpoint. */
  public UnaryCallSettings<UpdateIndexEndpointRequest, IndexEndpoint>
      updateIndexEndpointSettings() {
    return ((IndexEndpointServiceStubSettings) getStubSettings()).updateIndexEndpointSettings();
  }

  /** Returns the object with the settings used for calls to deleteIndexEndpoint. */
  public UnaryCallSettings<DeleteIndexEndpointRequest, Operation> deleteIndexEndpointSettings() {
    return ((IndexEndpointServiceStubSettings) getStubSettings()).deleteIndexEndpointSettings();
  }

  /** Returns the object with the settings used for calls to deleteIndexEndpoint. */
  public OperationCallSettings<DeleteIndexEndpointRequest, Empty, DeleteOperationMetadata>
      deleteIndexEndpointOperationSettings() {
    return ((IndexEndpointServiceStubSettings) getStubSettings())
        .deleteIndexEndpointOperationSettings();
  }

  /** Returns the object with the settings used for calls to deployIndex. */
  public UnaryCallSettings<DeployIndexRequest, Operation> deployIndexSettings() {
    return ((IndexEndpointServiceStubSettings) getStubSettings()).deployIndexSettings();
  }

  /** Returns the object with the settings used for calls to deployIndex. */
  public OperationCallSettings<
          DeployIndexRequest, DeployIndexResponse, DeployIndexOperationMetadata>
      deployIndexOperationSettings() {
    return ((IndexEndpointServiceStubSettings) getStubSettings()).deployIndexOperationSettings();
  }

  /** Returns the object with the settings used for calls to undeployIndex. */
  public UnaryCallSettings<UndeployIndexRequest, Operation> undeployIndexSettings() {
    return ((IndexEndpointServiceStubSettings) getStubSettings()).undeployIndexSettings();
  }

  /** Returns the object with the settings used for calls to undeployIndex. */
  public OperationCallSettings<
          UndeployIndexRequest, UndeployIndexResponse, UndeployIndexOperationMetadata>
      undeployIndexOperationSettings() {
    return ((IndexEndpointServiceStubSettings) getStubSettings()).undeployIndexOperationSettings();
  }

  public static final IndexEndpointServiceSettings create(IndexEndpointServiceStubSettings stub)
      throws IOException {
    return new IndexEndpointServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return IndexEndpointServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return IndexEndpointServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return IndexEndpointServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return IndexEndpointServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return IndexEndpointServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return IndexEndpointServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return IndexEndpointServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected IndexEndpointServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for IndexEndpointServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<IndexEndpointServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(IndexEndpointServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(IndexEndpointServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(IndexEndpointServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(IndexEndpointServiceStubSettings.newBuilder());
    }

    public IndexEndpointServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((IndexEndpointServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createIndexEndpoint. */
    public UnaryCallSettings.Builder<CreateIndexEndpointRequest, Operation>
        createIndexEndpointSettings() {
      return getStubSettingsBuilder().createIndexEndpointSettings();
    }

    /** Returns the builder for the settings used for calls to createIndexEndpoint. */
    public OperationCallSettings.Builder<
            CreateIndexEndpointRequest, IndexEndpoint, CreateIndexEndpointOperationMetadata>
        createIndexEndpointOperationSettings() {
      return getStubSettingsBuilder().createIndexEndpointOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getIndexEndpoint. */
    public UnaryCallSettings.Builder<GetIndexEndpointRequest, IndexEndpoint>
        getIndexEndpointSettings() {
      return getStubSettingsBuilder().getIndexEndpointSettings();
    }

    /** Returns the builder for the settings used for calls to listIndexEndpoints. */
    public PagedCallSettings.Builder<
            ListIndexEndpointsRequest, ListIndexEndpointsResponse, ListIndexEndpointsPagedResponse>
        listIndexEndpointsSettings() {
      return getStubSettingsBuilder().listIndexEndpointsSettings();
    }

    /** Returns the builder for the settings used for calls to updateIndexEndpoint. */
    public UnaryCallSettings.Builder<UpdateIndexEndpointRequest, IndexEndpoint>
        updateIndexEndpointSettings() {
      return getStubSettingsBuilder().updateIndexEndpointSettings();
    }

    /** Returns the builder for the settings used for calls to deleteIndexEndpoint. */
    public UnaryCallSettings.Builder<DeleteIndexEndpointRequest, Operation>
        deleteIndexEndpointSettings() {
      return getStubSettingsBuilder().deleteIndexEndpointSettings();
    }

    /** Returns the builder for the settings used for calls to deleteIndexEndpoint. */
    public OperationCallSettings.Builder<DeleteIndexEndpointRequest, Empty, DeleteOperationMetadata>
        deleteIndexEndpointOperationSettings() {
      return getStubSettingsBuilder().deleteIndexEndpointOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deployIndex. */
    public UnaryCallSettings.Builder<DeployIndexRequest, Operation> deployIndexSettings() {
      return getStubSettingsBuilder().deployIndexSettings();
    }

    /** Returns the builder for the settings used for calls to deployIndex. */
    public OperationCallSettings.Builder<
            DeployIndexRequest, DeployIndexResponse, DeployIndexOperationMetadata>
        deployIndexOperationSettings() {
      return getStubSettingsBuilder().deployIndexOperationSettings();
    }

    /** Returns the builder for the settings used for calls to undeployIndex. */
    public UnaryCallSettings.Builder<UndeployIndexRequest, Operation> undeployIndexSettings() {
      return getStubSettingsBuilder().undeployIndexSettings();
    }

    /** Returns the builder for the settings used for calls to undeployIndex. */
    public OperationCallSettings.Builder<
            UndeployIndexRequest, UndeployIndexResponse, UndeployIndexOperationMetadata>
        undeployIndexOperationSettings() {
      return getStubSettingsBuilder().undeployIndexOperationSettings();
    }

    @Override
    public IndexEndpointServiceSettings build() throws IOException {
      return new IndexEndpointServiceSettings(this);
    }
  }
}
