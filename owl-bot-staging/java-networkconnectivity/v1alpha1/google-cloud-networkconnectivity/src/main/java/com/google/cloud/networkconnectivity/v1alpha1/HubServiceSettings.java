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

package com.google.cloud.networkconnectivity.v1alpha1;

import static com.google.cloud.networkconnectivity.v1alpha1.HubServiceClient.ListHubsPagedResponse;
import static com.google.cloud.networkconnectivity.v1alpha1.HubServiceClient.ListSpokesPagedResponse;

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
import com.google.cloud.networkconnectivity.v1alpha1.stub.HubServiceStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link HubServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (networkconnectivity.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getHub to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * HubServiceSettings.Builder hubServiceSettingsBuilder = HubServiceSettings.newBuilder();
 * hubServiceSettingsBuilder
 *     .getHubSettings()
 *     .setRetrySettings(
 *         hubServiceSettingsBuilder.getHubSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * HubServiceSettings hubServiceSettings = hubServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HubServiceSettings extends ClientSettings<HubServiceSettings> {

  /** Returns the object with the settings used for calls to listHubs. */
  public PagedCallSettings<ListHubsRequest, ListHubsResponse, ListHubsPagedResponse>
      listHubsSettings() {
    return ((HubServiceStubSettings) getStubSettings()).listHubsSettings();
  }

  /** Returns the object with the settings used for calls to getHub. */
  public UnaryCallSettings<GetHubRequest, Hub> getHubSettings() {
    return ((HubServiceStubSettings) getStubSettings()).getHubSettings();
  }

  /** Returns the object with the settings used for calls to createHub. */
  public UnaryCallSettings<CreateHubRequest, Operation> createHubSettings() {
    return ((HubServiceStubSettings) getStubSettings()).createHubSettings();
  }

  /** Returns the object with the settings used for calls to createHub. */
  public OperationCallSettings<CreateHubRequest, Hub, OperationMetadata>
      createHubOperationSettings() {
    return ((HubServiceStubSettings) getStubSettings()).createHubOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateHub. */
  public UnaryCallSettings<UpdateHubRequest, Operation> updateHubSettings() {
    return ((HubServiceStubSettings) getStubSettings()).updateHubSettings();
  }

  /** Returns the object with the settings used for calls to updateHub. */
  public OperationCallSettings<UpdateHubRequest, Hub, OperationMetadata>
      updateHubOperationSettings() {
    return ((HubServiceStubSettings) getStubSettings()).updateHubOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteHub. */
  public UnaryCallSettings<DeleteHubRequest, Operation> deleteHubSettings() {
    return ((HubServiceStubSettings) getStubSettings()).deleteHubSettings();
  }

  /** Returns the object with the settings used for calls to deleteHub. */
  public OperationCallSettings<DeleteHubRequest, Empty, OperationMetadata>
      deleteHubOperationSettings() {
    return ((HubServiceStubSettings) getStubSettings()).deleteHubOperationSettings();
  }

  /** Returns the object with the settings used for calls to listSpokes. */
  public PagedCallSettings<ListSpokesRequest, ListSpokesResponse, ListSpokesPagedResponse>
      listSpokesSettings() {
    return ((HubServiceStubSettings) getStubSettings()).listSpokesSettings();
  }

  /** Returns the object with the settings used for calls to getSpoke. */
  public UnaryCallSettings<GetSpokeRequest, Spoke> getSpokeSettings() {
    return ((HubServiceStubSettings) getStubSettings()).getSpokeSettings();
  }

  /** Returns the object with the settings used for calls to createSpoke. */
  public UnaryCallSettings<CreateSpokeRequest, Operation> createSpokeSettings() {
    return ((HubServiceStubSettings) getStubSettings()).createSpokeSettings();
  }

  /** Returns the object with the settings used for calls to createSpoke. */
  public OperationCallSettings<CreateSpokeRequest, Spoke, OperationMetadata>
      createSpokeOperationSettings() {
    return ((HubServiceStubSettings) getStubSettings()).createSpokeOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateSpoke. */
  public UnaryCallSettings<UpdateSpokeRequest, Operation> updateSpokeSettings() {
    return ((HubServiceStubSettings) getStubSettings()).updateSpokeSettings();
  }

  /** Returns the object with the settings used for calls to updateSpoke. */
  public OperationCallSettings<UpdateSpokeRequest, Spoke, OperationMetadata>
      updateSpokeOperationSettings() {
    return ((HubServiceStubSettings) getStubSettings()).updateSpokeOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteSpoke. */
  public UnaryCallSettings<DeleteSpokeRequest, Operation> deleteSpokeSettings() {
    return ((HubServiceStubSettings) getStubSettings()).deleteSpokeSettings();
  }

  /** Returns the object with the settings used for calls to deleteSpoke. */
  public OperationCallSettings<DeleteSpokeRequest, Empty, OperationMetadata>
      deleteSpokeOperationSettings() {
    return ((HubServiceStubSettings) getStubSettings()).deleteSpokeOperationSettings();
  }

  public static final HubServiceSettings create(HubServiceStubSettings stub) throws IOException {
    return new HubServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return HubServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return HubServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return HubServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return HubServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return HubServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return HubServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return HubServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected HubServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for HubServiceSettings. */
  public static class Builder extends ClientSettings.Builder<HubServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(HubServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(HubServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(HubServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(HubServiceStubSettings.newBuilder());
    }

    public HubServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((HubServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listHubs. */
    public PagedCallSettings.Builder<ListHubsRequest, ListHubsResponse, ListHubsPagedResponse>
        listHubsSettings() {
      return getStubSettingsBuilder().listHubsSettings();
    }

    /** Returns the builder for the settings used for calls to getHub. */
    public UnaryCallSettings.Builder<GetHubRequest, Hub> getHubSettings() {
      return getStubSettingsBuilder().getHubSettings();
    }

    /** Returns the builder for the settings used for calls to createHub. */
    public UnaryCallSettings.Builder<CreateHubRequest, Operation> createHubSettings() {
      return getStubSettingsBuilder().createHubSettings();
    }

    /** Returns the builder for the settings used for calls to createHub. */
    public OperationCallSettings.Builder<CreateHubRequest, Hub, OperationMetadata>
        createHubOperationSettings() {
      return getStubSettingsBuilder().createHubOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateHub. */
    public UnaryCallSettings.Builder<UpdateHubRequest, Operation> updateHubSettings() {
      return getStubSettingsBuilder().updateHubSettings();
    }

    /** Returns the builder for the settings used for calls to updateHub. */
    public OperationCallSettings.Builder<UpdateHubRequest, Hub, OperationMetadata>
        updateHubOperationSettings() {
      return getStubSettingsBuilder().updateHubOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteHub. */
    public UnaryCallSettings.Builder<DeleteHubRequest, Operation> deleteHubSettings() {
      return getStubSettingsBuilder().deleteHubSettings();
    }

    /** Returns the builder for the settings used for calls to deleteHub. */
    public OperationCallSettings.Builder<DeleteHubRequest, Empty, OperationMetadata>
        deleteHubOperationSettings() {
      return getStubSettingsBuilder().deleteHubOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listSpokes. */
    public PagedCallSettings.Builder<ListSpokesRequest, ListSpokesResponse, ListSpokesPagedResponse>
        listSpokesSettings() {
      return getStubSettingsBuilder().listSpokesSettings();
    }

    /** Returns the builder for the settings used for calls to getSpoke. */
    public UnaryCallSettings.Builder<GetSpokeRequest, Spoke> getSpokeSettings() {
      return getStubSettingsBuilder().getSpokeSettings();
    }

    /** Returns the builder for the settings used for calls to createSpoke. */
    public UnaryCallSettings.Builder<CreateSpokeRequest, Operation> createSpokeSettings() {
      return getStubSettingsBuilder().createSpokeSettings();
    }

    /** Returns the builder for the settings used for calls to createSpoke. */
    public OperationCallSettings.Builder<CreateSpokeRequest, Spoke, OperationMetadata>
        createSpokeOperationSettings() {
      return getStubSettingsBuilder().createSpokeOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateSpoke. */
    public UnaryCallSettings.Builder<UpdateSpokeRequest, Operation> updateSpokeSettings() {
      return getStubSettingsBuilder().updateSpokeSettings();
    }

    /** Returns the builder for the settings used for calls to updateSpoke. */
    public OperationCallSettings.Builder<UpdateSpokeRequest, Spoke, OperationMetadata>
        updateSpokeOperationSettings() {
      return getStubSettingsBuilder().updateSpokeOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteSpoke. */
    public UnaryCallSettings.Builder<DeleteSpokeRequest, Operation> deleteSpokeSettings() {
      return getStubSettingsBuilder().deleteSpokeSettings();
    }

    /** Returns the builder for the settings used for calls to deleteSpoke. */
    public OperationCallSettings.Builder<DeleteSpokeRequest, Empty, OperationMetadata>
        deleteSpokeOperationSettings() {
      return getStubSettingsBuilder().deleteSpokeOperationSettings();
    }

    @Override
    public HubServiceSettings build() throws IOException {
      return new HubServiceSettings(this);
    }
  }
}
