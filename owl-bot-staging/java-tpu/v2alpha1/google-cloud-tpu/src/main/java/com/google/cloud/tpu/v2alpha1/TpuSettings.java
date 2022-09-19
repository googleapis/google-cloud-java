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

package com.google.cloud.tpu.v2alpha1;

import static com.google.cloud.tpu.v2alpha1.TpuClient.ListAcceleratorTypesPagedResponse;
import static com.google.cloud.tpu.v2alpha1.TpuClient.ListNodesPagedResponse;
import static com.google.cloud.tpu.v2alpha1.TpuClient.ListRuntimeVersionsPagedResponse;

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
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.tpu.v2alpha1.stub.TpuStubSettings;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link TpuClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (tpu.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getNode to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * TpuSettings.Builder tpuSettingsBuilder = TpuSettings.newBuilder();
 * tpuSettingsBuilder
 *     .getNodeSettings()
 *     .setRetrySettings(
 *         tpuSettingsBuilder.getNodeSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * TpuSettings tpuSettings = tpuSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class TpuSettings extends ClientSettings<TpuSettings> {

  /** Returns the object with the settings used for calls to listNodes. */
  public PagedCallSettings<ListNodesRequest, ListNodesResponse, ListNodesPagedResponse>
      listNodesSettings() {
    return ((TpuStubSettings) getStubSettings()).listNodesSettings();
  }

  /** Returns the object with the settings used for calls to getNode. */
  public UnaryCallSettings<GetNodeRequest, Node> getNodeSettings() {
    return ((TpuStubSettings) getStubSettings()).getNodeSettings();
  }

  /** Returns the object with the settings used for calls to createNode. */
  public UnaryCallSettings<CreateNodeRequest, Operation> createNodeSettings() {
    return ((TpuStubSettings) getStubSettings()).createNodeSettings();
  }

  /** Returns the object with the settings used for calls to createNode. */
  public OperationCallSettings<CreateNodeRequest, Node, OperationMetadata>
      createNodeOperationSettings() {
    return ((TpuStubSettings) getStubSettings()).createNodeOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteNode. */
  public UnaryCallSettings<DeleteNodeRequest, Operation> deleteNodeSettings() {
    return ((TpuStubSettings) getStubSettings()).deleteNodeSettings();
  }

  /** Returns the object with the settings used for calls to deleteNode. */
  public OperationCallSettings<DeleteNodeRequest, Node, OperationMetadata>
      deleteNodeOperationSettings() {
    return ((TpuStubSettings) getStubSettings()).deleteNodeOperationSettings();
  }

  /** Returns the object with the settings used for calls to stopNode. */
  public UnaryCallSettings<StopNodeRequest, Operation> stopNodeSettings() {
    return ((TpuStubSettings) getStubSettings()).stopNodeSettings();
  }

  /** Returns the object with the settings used for calls to stopNode. */
  public OperationCallSettings<StopNodeRequest, Node, OperationMetadata>
      stopNodeOperationSettings() {
    return ((TpuStubSettings) getStubSettings()).stopNodeOperationSettings();
  }

  /** Returns the object with the settings used for calls to startNode. */
  public UnaryCallSettings<StartNodeRequest, Operation> startNodeSettings() {
    return ((TpuStubSettings) getStubSettings()).startNodeSettings();
  }

  /** Returns the object with the settings used for calls to startNode. */
  public OperationCallSettings<StartNodeRequest, Node, OperationMetadata>
      startNodeOperationSettings() {
    return ((TpuStubSettings) getStubSettings()).startNodeOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateNode. */
  public UnaryCallSettings<UpdateNodeRequest, Operation> updateNodeSettings() {
    return ((TpuStubSettings) getStubSettings()).updateNodeSettings();
  }

  /** Returns the object with the settings used for calls to updateNode. */
  public OperationCallSettings<UpdateNodeRequest, Node, OperationMetadata>
      updateNodeOperationSettings() {
    return ((TpuStubSettings) getStubSettings()).updateNodeOperationSettings();
  }

  /** Returns the object with the settings used for calls to generateServiceIdentity. */
  public UnaryCallSettings<GenerateServiceIdentityRequest, GenerateServiceIdentityResponse>
      generateServiceIdentitySettings() {
    return ((TpuStubSettings) getStubSettings()).generateServiceIdentitySettings();
  }

  /** Returns the object with the settings used for calls to listAcceleratorTypes. */
  public PagedCallSettings<
          ListAcceleratorTypesRequest,
          ListAcceleratorTypesResponse,
          ListAcceleratorTypesPagedResponse>
      listAcceleratorTypesSettings() {
    return ((TpuStubSettings) getStubSettings()).listAcceleratorTypesSettings();
  }

  /** Returns the object with the settings used for calls to getAcceleratorType. */
  public UnaryCallSettings<GetAcceleratorTypeRequest, AcceleratorType>
      getAcceleratorTypeSettings() {
    return ((TpuStubSettings) getStubSettings()).getAcceleratorTypeSettings();
  }

  /** Returns the object with the settings used for calls to listRuntimeVersions. */
  public PagedCallSettings<
          ListRuntimeVersionsRequest, ListRuntimeVersionsResponse, ListRuntimeVersionsPagedResponse>
      listRuntimeVersionsSettings() {
    return ((TpuStubSettings) getStubSettings()).listRuntimeVersionsSettings();
  }

  /** Returns the object with the settings used for calls to getRuntimeVersion. */
  public UnaryCallSettings<GetRuntimeVersionRequest, RuntimeVersion> getRuntimeVersionSettings() {
    return ((TpuStubSettings) getStubSettings()).getRuntimeVersionSettings();
  }

  /** Returns the object with the settings used for calls to getGuestAttributes. */
  public UnaryCallSettings<GetGuestAttributesRequest, GetGuestAttributesResponse>
      getGuestAttributesSettings() {
    return ((TpuStubSettings) getStubSettings()).getGuestAttributesSettings();
  }

  public static final TpuSettings create(TpuStubSettings stub) throws IOException {
    return new TpuSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return TpuStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return TpuStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return TpuStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return TpuStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return TpuStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return TpuStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return TpuStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected TpuSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for TpuSettings. */
  public static class Builder extends ClientSettings.Builder<TpuSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(TpuStubSettings.newBuilder(clientContext));
    }

    protected Builder(TpuSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(TpuStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(TpuStubSettings.newBuilder());
    }

    public TpuStubSettings.Builder getStubSettingsBuilder() {
      return ((TpuStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listNodes. */
    public PagedCallSettings.Builder<ListNodesRequest, ListNodesResponse, ListNodesPagedResponse>
        listNodesSettings() {
      return getStubSettingsBuilder().listNodesSettings();
    }

    /** Returns the builder for the settings used for calls to getNode. */
    public UnaryCallSettings.Builder<GetNodeRequest, Node> getNodeSettings() {
      return getStubSettingsBuilder().getNodeSettings();
    }

    /** Returns the builder for the settings used for calls to createNode. */
    public UnaryCallSettings.Builder<CreateNodeRequest, Operation> createNodeSettings() {
      return getStubSettingsBuilder().createNodeSettings();
    }

    /** Returns the builder for the settings used for calls to createNode. */
    public OperationCallSettings.Builder<CreateNodeRequest, Node, OperationMetadata>
        createNodeOperationSettings() {
      return getStubSettingsBuilder().createNodeOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteNode. */
    public UnaryCallSettings.Builder<DeleteNodeRequest, Operation> deleteNodeSettings() {
      return getStubSettingsBuilder().deleteNodeSettings();
    }

    /** Returns the builder for the settings used for calls to deleteNode. */
    public OperationCallSettings.Builder<DeleteNodeRequest, Node, OperationMetadata>
        deleteNodeOperationSettings() {
      return getStubSettingsBuilder().deleteNodeOperationSettings();
    }

    /** Returns the builder for the settings used for calls to stopNode. */
    public UnaryCallSettings.Builder<StopNodeRequest, Operation> stopNodeSettings() {
      return getStubSettingsBuilder().stopNodeSettings();
    }

    /** Returns the builder for the settings used for calls to stopNode. */
    public OperationCallSettings.Builder<StopNodeRequest, Node, OperationMetadata>
        stopNodeOperationSettings() {
      return getStubSettingsBuilder().stopNodeOperationSettings();
    }

    /** Returns the builder for the settings used for calls to startNode. */
    public UnaryCallSettings.Builder<StartNodeRequest, Operation> startNodeSettings() {
      return getStubSettingsBuilder().startNodeSettings();
    }

    /** Returns the builder for the settings used for calls to startNode. */
    public OperationCallSettings.Builder<StartNodeRequest, Node, OperationMetadata>
        startNodeOperationSettings() {
      return getStubSettingsBuilder().startNodeOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateNode. */
    public UnaryCallSettings.Builder<UpdateNodeRequest, Operation> updateNodeSettings() {
      return getStubSettingsBuilder().updateNodeSettings();
    }

    /** Returns the builder for the settings used for calls to updateNode. */
    public OperationCallSettings.Builder<UpdateNodeRequest, Node, OperationMetadata>
        updateNodeOperationSettings() {
      return getStubSettingsBuilder().updateNodeOperationSettings();
    }

    /** Returns the builder for the settings used for calls to generateServiceIdentity. */
    public UnaryCallSettings.Builder<
            GenerateServiceIdentityRequest, GenerateServiceIdentityResponse>
        generateServiceIdentitySettings() {
      return getStubSettingsBuilder().generateServiceIdentitySettings();
    }

    /** Returns the builder for the settings used for calls to listAcceleratorTypes. */
    public PagedCallSettings.Builder<
            ListAcceleratorTypesRequest,
            ListAcceleratorTypesResponse,
            ListAcceleratorTypesPagedResponse>
        listAcceleratorTypesSettings() {
      return getStubSettingsBuilder().listAcceleratorTypesSettings();
    }

    /** Returns the builder for the settings used for calls to getAcceleratorType. */
    public UnaryCallSettings.Builder<GetAcceleratorTypeRequest, AcceleratorType>
        getAcceleratorTypeSettings() {
      return getStubSettingsBuilder().getAcceleratorTypeSettings();
    }

    /** Returns the builder for the settings used for calls to listRuntimeVersions. */
    public PagedCallSettings.Builder<
            ListRuntimeVersionsRequest,
            ListRuntimeVersionsResponse,
            ListRuntimeVersionsPagedResponse>
        listRuntimeVersionsSettings() {
      return getStubSettingsBuilder().listRuntimeVersionsSettings();
    }

    /** Returns the builder for the settings used for calls to getRuntimeVersion. */
    public UnaryCallSettings.Builder<GetRuntimeVersionRequest, RuntimeVersion>
        getRuntimeVersionSettings() {
      return getStubSettingsBuilder().getRuntimeVersionSettings();
    }

    /** Returns the builder for the settings used for calls to getGuestAttributes. */
    public UnaryCallSettings.Builder<GetGuestAttributesRequest, GetGuestAttributesResponse>
        getGuestAttributesSettings() {
      return getStubSettingsBuilder().getGuestAttributesSettings();
    }

    @Override
    public TpuSettings build() throws IOException {
      return new TpuSettings(this);
    }
  }
}
