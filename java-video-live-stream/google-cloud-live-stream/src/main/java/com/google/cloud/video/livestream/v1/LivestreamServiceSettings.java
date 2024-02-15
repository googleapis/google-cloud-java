/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.video.livestream.v1;

import static com.google.cloud.video.livestream.v1.LivestreamServiceClient.ListAssetsPagedResponse;
import static com.google.cloud.video.livestream.v1.LivestreamServiceClient.ListChannelsPagedResponse;
import static com.google.cloud.video.livestream.v1.LivestreamServiceClient.ListEventsPagedResponse;
import static com.google.cloud.video.livestream.v1.LivestreamServiceClient.ListInputsPagedResponse;
import static com.google.cloud.video.livestream.v1.LivestreamServiceClient.ListLocationsPagedResponse;

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
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.video.livestream.v1.stub.LivestreamServiceStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link LivestreamServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (livestream.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getChannel to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * LivestreamServiceSettings.Builder livestreamServiceSettingsBuilder =
 *     LivestreamServiceSettings.newBuilder();
 * livestreamServiceSettingsBuilder
 *     .getChannelSettings()
 *     .setRetrySettings(
 *         livestreamServiceSettingsBuilder
 *             .getChannelSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * LivestreamServiceSettings livestreamServiceSettings = livestreamServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class LivestreamServiceSettings extends ClientSettings<LivestreamServiceSettings> {

  /** Returns the object with the settings used for calls to createChannel. */
  public UnaryCallSettings<CreateChannelRequest, Operation> createChannelSettings() {
    return ((LivestreamServiceStubSettings) getStubSettings()).createChannelSettings();
  }

  /** Returns the object with the settings used for calls to createChannel. */
  public OperationCallSettings<CreateChannelRequest, Channel, OperationMetadata>
      createChannelOperationSettings() {
    return ((LivestreamServiceStubSettings) getStubSettings()).createChannelOperationSettings();
  }

  /** Returns the object with the settings used for calls to listChannels. */
  public PagedCallSettings<ListChannelsRequest, ListChannelsResponse, ListChannelsPagedResponse>
      listChannelsSettings() {
    return ((LivestreamServiceStubSettings) getStubSettings()).listChannelsSettings();
  }

  /** Returns the object with the settings used for calls to getChannel. */
  public UnaryCallSettings<GetChannelRequest, Channel> getChannelSettings() {
    return ((LivestreamServiceStubSettings) getStubSettings()).getChannelSettings();
  }

  /** Returns the object with the settings used for calls to deleteChannel. */
  public UnaryCallSettings<DeleteChannelRequest, Operation> deleteChannelSettings() {
    return ((LivestreamServiceStubSettings) getStubSettings()).deleteChannelSettings();
  }

  /** Returns the object with the settings used for calls to deleteChannel. */
  public OperationCallSettings<DeleteChannelRequest, Empty, OperationMetadata>
      deleteChannelOperationSettings() {
    return ((LivestreamServiceStubSettings) getStubSettings()).deleteChannelOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateChannel. */
  public UnaryCallSettings<UpdateChannelRequest, Operation> updateChannelSettings() {
    return ((LivestreamServiceStubSettings) getStubSettings()).updateChannelSettings();
  }

  /** Returns the object with the settings used for calls to updateChannel. */
  public OperationCallSettings<UpdateChannelRequest, Channel, OperationMetadata>
      updateChannelOperationSettings() {
    return ((LivestreamServiceStubSettings) getStubSettings()).updateChannelOperationSettings();
  }

  /** Returns the object with the settings used for calls to startChannel. */
  public UnaryCallSettings<StartChannelRequest, Operation> startChannelSettings() {
    return ((LivestreamServiceStubSettings) getStubSettings()).startChannelSettings();
  }

  /** Returns the object with the settings used for calls to startChannel. */
  public OperationCallSettings<StartChannelRequest, ChannelOperationResponse, OperationMetadata>
      startChannelOperationSettings() {
    return ((LivestreamServiceStubSettings) getStubSettings()).startChannelOperationSettings();
  }

  /** Returns the object with the settings used for calls to stopChannel. */
  public UnaryCallSettings<StopChannelRequest, Operation> stopChannelSettings() {
    return ((LivestreamServiceStubSettings) getStubSettings()).stopChannelSettings();
  }

  /** Returns the object with the settings used for calls to stopChannel. */
  public OperationCallSettings<StopChannelRequest, ChannelOperationResponse, OperationMetadata>
      stopChannelOperationSettings() {
    return ((LivestreamServiceStubSettings) getStubSettings()).stopChannelOperationSettings();
  }

  /** Returns the object with the settings used for calls to createInput. */
  public UnaryCallSettings<CreateInputRequest, Operation> createInputSettings() {
    return ((LivestreamServiceStubSettings) getStubSettings()).createInputSettings();
  }

  /** Returns the object with the settings used for calls to createInput. */
  public OperationCallSettings<CreateInputRequest, Input, OperationMetadata>
      createInputOperationSettings() {
    return ((LivestreamServiceStubSettings) getStubSettings()).createInputOperationSettings();
  }

  /** Returns the object with the settings used for calls to listInputs. */
  public PagedCallSettings<ListInputsRequest, ListInputsResponse, ListInputsPagedResponse>
      listInputsSettings() {
    return ((LivestreamServiceStubSettings) getStubSettings()).listInputsSettings();
  }

  /** Returns the object with the settings used for calls to getInput. */
  public UnaryCallSettings<GetInputRequest, Input> getInputSettings() {
    return ((LivestreamServiceStubSettings) getStubSettings()).getInputSettings();
  }

  /** Returns the object with the settings used for calls to deleteInput. */
  public UnaryCallSettings<DeleteInputRequest, Operation> deleteInputSettings() {
    return ((LivestreamServiceStubSettings) getStubSettings()).deleteInputSettings();
  }

  /** Returns the object with the settings used for calls to deleteInput. */
  public OperationCallSettings<DeleteInputRequest, Empty, OperationMetadata>
      deleteInputOperationSettings() {
    return ((LivestreamServiceStubSettings) getStubSettings()).deleteInputOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateInput. */
  public UnaryCallSettings<UpdateInputRequest, Operation> updateInputSettings() {
    return ((LivestreamServiceStubSettings) getStubSettings()).updateInputSettings();
  }

  /** Returns the object with the settings used for calls to updateInput. */
  public OperationCallSettings<UpdateInputRequest, Input, OperationMetadata>
      updateInputOperationSettings() {
    return ((LivestreamServiceStubSettings) getStubSettings()).updateInputOperationSettings();
  }

  /** Returns the object with the settings used for calls to createEvent. */
  public UnaryCallSettings<CreateEventRequest, Event> createEventSettings() {
    return ((LivestreamServiceStubSettings) getStubSettings()).createEventSettings();
  }

  /** Returns the object with the settings used for calls to listEvents. */
  public PagedCallSettings<ListEventsRequest, ListEventsResponse, ListEventsPagedResponse>
      listEventsSettings() {
    return ((LivestreamServiceStubSettings) getStubSettings()).listEventsSettings();
  }

  /** Returns the object with the settings used for calls to getEvent. */
  public UnaryCallSettings<GetEventRequest, Event> getEventSettings() {
    return ((LivestreamServiceStubSettings) getStubSettings()).getEventSettings();
  }

  /** Returns the object with the settings used for calls to deleteEvent. */
  public UnaryCallSettings<DeleteEventRequest, Empty> deleteEventSettings() {
    return ((LivestreamServiceStubSettings) getStubSettings()).deleteEventSettings();
  }

  /** Returns the object with the settings used for calls to createAsset. */
  public UnaryCallSettings<CreateAssetRequest, Operation> createAssetSettings() {
    return ((LivestreamServiceStubSettings) getStubSettings()).createAssetSettings();
  }

  /** Returns the object with the settings used for calls to createAsset. */
  public OperationCallSettings<CreateAssetRequest, Asset, OperationMetadata>
      createAssetOperationSettings() {
    return ((LivestreamServiceStubSettings) getStubSettings()).createAssetOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteAsset. */
  public UnaryCallSettings<DeleteAssetRequest, Operation> deleteAssetSettings() {
    return ((LivestreamServiceStubSettings) getStubSettings()).deleteAssetSettings();
  }

  /** Returns the object with the settings used for calls to deleteAsset. */
  public OperationCallSettings<DeleteAssetRequest, Empty, OperationMetadata>
      deleteAssetOperationSettings() {
    return ((LivestreamServiceStubSettings) getStubSettings()).deleteAssetOperationSettings();
  }

  /** Returns the object with the settings used for calls to getAsset. */
  public UnaryCallSettings<GetAssetRequest, Asset> getAssetSettings() {
    return ((LivestreamServiceStubSettings) getStubSettings()).getAssetSettings();
  }

  /** Returns the object with the settings used for calls to listAssets. */
  public PagedCallSettings<ListAssetsRequest, ListAssetsResponse, ListAssetsPagedResponse>
      listAssetsSettings() {
    return ((LivestreamServiceStubSettings) getStubSettings()).listAssetsSettings();
  }

  /** Returns the object with the settings used for calls to getPool. */
  public UnaryCallSettings<GetPoolRequest, Pool> getPoolSettings() {
    return ((LivestreamServiceStubSettings) getStubSettings()).getPoolSettings();
  }

  /** Returns the object with the settings used for calls to updatePool. */
  public UnaryCallSettings<UpdatePoolRequest, Operation> updatePoolSettings() {
    return ((LivestreamServiceStubSettings) getStubSettings()).updatePoolSettings();
  }

  /** Returns the object with the settings used for calls to updatePool. */
  public OperationCallSettings<UpdatePoolRequest, Pool, OperationMetadata>
      updatePoolOperationSettings() {
    return ((LivestreamServiceStubSettings) getStubSettings()).updatePoolOperationSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((LivestreamServiceStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((LivestreamServiceStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final LivestreamServiceSettings create(LivestreamServiceStubSettings stub)
      throws IOException {
    return new LivestreamServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return LivestreamServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return LivestreamServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return LivestreamServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return LivestreamServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return LivestreamServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return LivestreamServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return LivestreamServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return LivestreamServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected LivestreamServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for LivestreamServiceSettings. */
  public static class Builder extends ClientSettings.Builder<LivestreamServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(LivestreamServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(LivestreamServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(LivestreamServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(LivestreamServiceStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(LivestreamServiceStubSettings.newHttpJsonBuilder());
    }

    public LivestreamServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((LivestreamServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createChannel. */
    public UnaryCallSettings.Builder<CreateChannelRequest, Operation> createChannelSettings() {
      return getStubSettingsBuilder().createChannelSettings();
    }

    /** Returns the builder for the settings used for calls to createChannel. */
    public OperationCallSettings.Builder<CreateChannelRequest, Channel, OperationMetadata>
        createChannelOperationSettings() {
      return getStubSettingsBuilder().createChannelOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listChannels. */
    public PagedCallSettings.Builder<
            ListChannelsRequest, ListChannelsResponse, ListChannelsPagedResponse>
        listChannelsSettings() {
      return getStubSettingsBuilder().listChannelsSettings();
    }

    /** Returns the builder for the settings used for calls to getChannel. */
    public UnaryCallSettings.Builder<GetChannelRequest, Channel> getChannelSettings() {
      return getStubSettingsBuilder().getChannelSettings();
    }

    /** Returns the builder for the settings used for calls to deleteChannel. */
    public UnaryCallSettings.Builder<DeleteChannelRequest, Operation> deleteChannelSettings() {
      return getStubSettingsBuilder().deleteChannelSettings();
    }

    /** Returns the builder for the settings used for calls to deleteChannel. */
    public OperationCallSettings.Builder<DeleteChannelRequest, Empty, OperationMetadata>
        deleteChannelOperationSettings() {
      return getStubSettingsBuilder().deleteChannelOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateChannel. */
    public UnaryCallSettings.Builder<UpdateChannelRequest, Operation> updateChannelSettings() {
      return getStubSettingsBuilder().updateChannelSettings();
    }

    /** Returns the builder for the settings used for calls to updateChannel. */
    public OperationCallSettings.Builder<UpdateChannelRequest, Channel, OperationMetadata>
        updateChannelOperationSettings() {
      return getStubSettingsBuilder().updateChannelOperationSettings();
    }

    /** Returns the builder for the settings used for calls to startChannel. */
    public UnaryCallSettings.Builder<StartChannelRequest, Operation> startChannelSettings() {
      return getStubSettingsBuilder().startChannelSettings();
    }

    /** Returns the builder for the settings used for calls to startChannel. */
    public OperationCallSettings.Builder<
            StartChannelRequest, ChannelOperationResponse, OperationMetadata>
        startChannelOperationSettings() {
      return getStubSettingsBuilder().startChannelOperationSettings();
    }

    /** Returns the builder for the settings used for calls to stopChannel. */
    public UnaryCallSettings.Builder<StopChannelRequest, Operation> stopChannelSettings() {
      return getStubSettingsBuilder().stopChannelSettings();
    }

    /** Returns the builder for the settings used for calls to stopChannel. */
    public OperationCallSettings.Builder<
            StopChannelRequest, ChannelOperationResponse, OperationMetadata>
        stopChannelOperationSettings() {
      return getStubSettingsBuilder().stopChannelOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createInput. */
    public UnaryCallSettings.Builder<CreateInputRequest, Operation> createInputSettings() {
      return getStubSettingsBuilder().createInputSettings();
    }

    /** Returns the builder for the settings used for calls to createInput. */
    public OperationCallSettings.Builder<CreateInputRequest, Input, OperationMetadata>
        createInputOperationSettings() {
      return getStubSettingsBuilder().createInputOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listInputs. */
    public PagedCallSettings.Builder<ListInputsRequest, ListInputsResponse, ListInputsPagedResponse>
        listInputsSettings() {
      return getStubSettingsBuilder().listInputsSettings();
    }

    /** Returns the builder for the settings used for calls to getInput. */
    public UnaryCallSettings.Builder<GetInputRequest, Input> getInputSettings() {
      return getStubSettingsBuilder().getInputSettings();
    }

    /** Returns the builder for the settings used for calls to deleteInput. */
    public UnaryCallSettings.Builder<DeleteInputRequest, Operation> deleteInputSettings() {
      return getStubSettingsBuilder().deleteInputSettings();
    }

    /** Returns the builder for the settings used for calls to deleteInput. */
    public OperationCallSettings.Builder<DeleteInputRequest, Empty, OperationMetadata>
        deleteInputOperationSettings() {
      return getStubSettingsBuilder().deleteInputOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateInput. */
    public UnaryCallSettings.Builder<UpdateInputRequest, Operation> updateInputSettings() {
      return getStubSettingsBuilder().updateInputSettings();
    }

    /** Returns the builder for the settings used for calls to updateInput. */
    public OperationCallSettings.Builder<UpdateInputRequest, Input, OperationMetadata>
        updateInputOperationSettings() {
      return getStubSettingsBuilder().updateInputOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createEvent. */
    public UnaryCallSettings.Builder<CreateEventRequest, Event> createEventSettings() {
      return getStubSettingsBuilder().createEventSettings();
    }

    /** Returns the builder for the settings used for calls to listEvents. */
    public PagedCallSettings.Builder<ListEventsRequest, ListEventsResponse, ListEventsPagedResponse>
        listEventsSettings() {
      return getStubSettingsBuilder().listEventsSettings();
    }

    /** Returns the builder for the settings used for calls to getEvent. */
    public UnaryCallSettings.Builder<GetEventRequest, Event> getEventSettings() {
      return getStubSettingsBuilder().getEventSettings();
    }

    /** Returns the builder for the settings used for calls to deleteEvent. */
    public UnaryCallSettings.Builder<DeleteEventRequest, Empty> deleteEventSettings() {
      return getStubSettingsBuilder().deleteEventSettings();
    }

    /** Returns the builder for the settings used for calls to createAsset. */
    public UnaryCallSettings.Builder<CreateAssetRequest, Operation> createAssetSettings() {
      return getStubSettingsBuilder().createAssetSettings();
    }

    /** Returns the builder for the settings used for calls to createAsset. */
    public OperationCallSettings.Builder<CreateAssetRequest, Asset, OperationMetadata>
        createAssetOperationSettings() {
      return getStubSettingsBuilder().createAssetOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAsset. */
    public UnaryCallSettings.Builder<DeleteAssetRequest, Operation> deleteAssetSettings() {
      return getStubSettingsBuilder().deleteAssetSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAsset. */
    public OperationCallSettings.Builder<DeleteAssetRequest, Empty, OperationMetadata>
        deleteAssetOperationSettings() {
      return getStubSettingsBuilder().deleteAssetOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getAsset. */
    public UnaryCallSettings.Builder<GetAssetRequest, Asset> getAssetSettings() {
      return getStubSettingsBuilder().getAssetSettings();
    }

    /** Returns the builder for the settings used for calls to listAssets. */
    public PagedCallSettings.Builder<ListAssetsRequest, ListAssetsResponse, ListAssetsPagedResponse>
        listAssetsSettings() {
      return getStubSettingsBuilder().listAssetsSettings();
    }

    /** Returns the builder for the settings used for calls to getPool. */
    public UnaryCallSettings.Builder<GetPoolRequest, Pool> getPoolSettings() {
      return getStubSettingsBuilder().getPoolSettings();
    }

    /** Returns the builder for the settings used for calls to updatePool. */
    public UnaryCallSettings.Builder<UpdatePoolRequest, Operation> updatePoolSettings() {
      return getStubSettingsBuilder().updatePoolSettings();
    }

    /** Returns the builder for the settings used for calls to updatePool. */
    public OperationCallSettings.Builder<UpdatePoolRequest, Pool, OperationMetadata>
        updatePoolOperationSettings() {
      return getStubSettingsBuilder().updatePoolOperationSettings();
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
    public LivestreamServiceSettings build() throws IOException {
      return new LivestreamServiceSettings(this);
    }
  }
}
