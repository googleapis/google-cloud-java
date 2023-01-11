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

package com.google.cloud.eventarc.v1;

import static com.google.cloud.eventarc.v1.EventarcClient.ListChannelConnectionsPagedResponse;
import static com.google.cloud.eventarc.v1.EventarcClient.ListChannelsPagedResponse;
import static com.google.cloud.eventarc.v1.EventarcClient.ListLocationsPagedResponse;
import static com.google.cloud.eventarc.v1.EventarcClient.ListProvidersPagedResponse;
import static com.google.cloud.eventarc.v1.EventarcClient.ListTriggersPagedResponse;

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
import com.google.cloud.eventarc.v1.stub.EventarcStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link EventarcClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (eventarc.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getTrigger to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * EventarcSettings.Builder eventarcSettingsBuilder = EventarcSettings.newBuilder();
 * eventarcSettingsBuilder
 *     .getTriggerSettings()
 *     .setRetrySettings(
 *         eventarcSettingsBuilder
 *             .getTriggerSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * EventarcSettings eventarcSettings = eventarcSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class EventarcSettings extends ClientSettings<EventarcSettings> {

  /** Returns the object with the settings used for calls to getTrigger. */
  public UnaryCallSettings<GetTriggerRequest, Trigger> getTriggerSettings() {
    return ((EventarcStubSettings) getStubSettings()).getTriggerSettings();
  }

  /** Returns the object with the settings used for calls to listTriggers. */
  public PagedCallSettings<ListTriggersRequest, ListTriggersResponse, ListTriggersPagedResponse>
      listTriggersSettings() {
    return ((EventarcStubSettings) getStubSettings()).listTriggersSettings();
  }

  /** Returns the object with the settings used for calls to createTrigger. */
  public UnaryCallSettings<CreateTriggerRequest, Operation> createTriggerSettings() {
    return ((EventarcStubSettings) getStubSettings()).createTriggerSettings();
  }

  /** Returns the object with the settings used for calls to createTrigger. */
  public OperationCallSettings<CreateTriggerRequest, Trigger, OperationMetadata>
      createTriggerOperationSettings() {
    return ((EventarcStubSettings) getStubSettings()).createTriggerOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateTrigger. */
  public UnaryCallSettings<UpdateTriggerRequest, Operation> updateTriggerSettings() {
    return ((EventarcStubSettings) getStubSettings()).updateTriggerSettings();
  }

  /** Returns the object with the settings used for calls to updateTrigger. */
  public OperationCallSettings<UpdateTriggerRequest, Trigger, OperationMetadata>
      updateTriggerOperationSettings() {
    return ((EventarcStubSettings) getStubSettings()).updateTriggerOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteTrigger. */
  public UnaryCallSettings<DeleteTriggerRequest, Operation> deleteTriggerSettings() {
    return ((EventarcStubSettings) getStubSettings()).deleteTriggerSettings();
  }

  /** Returns the object with the settings used for calls to deleteTrigger. */
  public OperationCallSettings<DeleteTriggerRequest, Trigger, OperationMetadata>
      deleteTriggerOperationSettings() {
    return ((EventarcStubSettings) getStubSettings()).deleteTriggerOperationSettings();
  }

  /** Returns the object with the settings used for calls to getChannel. */
  public UnaryCallSettings<GetChannelRequest, Channel> getChannelSettings() {
    return ((EventarcStubSettings) getStubSettings()).getChannelSettings();
  }

  /** Returns the object with the settings used for calls to listChannels. */
  public PagedCallSettings<ListChannelsRequest, ListChannelsResponse, ListChannelsPagedResponse>
      listChannelsSettings() {
    return ((EventarcStubSettings) getStubSettings()).listChannelsSettings();
  }

  /** Returns the object with the settings used for calls to createChannel. */
  public UnaryCallSettings<CreateChannelRequest, Operation> createChannelSettings() {
    return ((EventarcStubSettings) getStubSettings()).createChannelSettings();
  }

  /** Returns the object with the settings used for calls to createChannel. */
  public OperationCallSettings<CreateChannelRequest, Channel, OperationMetadata>
      createChannelOperationSettings() {
    return ((EventarcStubSettings) getStubSettings()).createChannelOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateChannel. */
  public UnaryCallSettings<UpdateChannelRequest, Operation> updateChannelSettings() {
    return ((EventarcStubSettings) getStubSettings()).updateChannelSettings();
  }

  /** Returns the object with the settings used for calls to updateChannel. */
  public OperationCallSettings<UpdateChannelRequest, Channel, OperationMetadata>
      updateChannelOperationSettings() {
    return ((EventarcStubSettings) getStubSettings()).updateChannelOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteChannel. */
  public UnaryCallSettings<DeleteChannelRequest, Operation> deleteChannelSettings() {
    return ((EventarcStubSettings) getStubSettings()).deleteChannelSettings();
  }

  /** Returns the object with the settings used for calls to deleteChannel. */
  public OperationCallSettings<DeleteChannelRequest, Channel, OperationMetadata>
      deleteChannelOperationSettings() {
    return ((EventarcStubSettings) getStubSettings()).deleteChannelOperationSettings();
  }

  /** Returns the object with the settings used for calls to getProvider. */
  public UnaryCallSettings<GetProviderRequest, Provider> getProviderSettings() {
    return ((EventarcStubSettings) getStubSettings()).getProviderSettings();
  }

  /** Returns the object with the settings used for calls to listProviders. */
  public PagedCallSettings<ListProvidersRequest, ListProvidersResponse, ListProvidersPagedResponse>
      listProvidersSettings() {
    return ((EventarcStubSettings) getStubSettings()).listProvidersSettings();
  }

  /** Returns the object with the settings used for calls to getChannelConnection. */
  public UnaryCallSettings<GetChannelConnectionRequest, ChannelConnection>
      getChannelConnectionSettings() {
    return ((EventarcStubSettings) getStubSettings()).getChannelConnectionSettings();
  }

  /** Returns the object with the settings used for calls to listChannelConnections. */
  public PagedCallSettings<
          ListChannelConnectionsRequest,
          ListChannelConnectionsResponse,
          ListChannelConnectionsPagedResponse>
      listChannelConnectionsSettings() {
    return ((EventarcStubSettings) getStubSettings()).listChannelConnectionsSettings();
  }

  /** Returns the object with the settings used for calls to createChannelConnection. */
  public UnaryCallSettings<CreateChannelConnectionRequest, Operation>
      createChannelConnectionSettings() {
    return ((EventarcStubSettings) getStubSettings()).createChannelConnectionSettings();
  }

  /** Returns the object with the settings used for calls to createChannelConnection. */
  public OperationCallSettings<CreateChannelConnectionRequest, ChannelConnection, OperationMetadata>
      createChannelConnectionOperationSettings() {
    return ((EventarcStubSettings) getStubSettings()).createChannelConnectionOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteChannelConnection. */
  public UnaryCallSettings<DeleteChannelConnectionRequest, Operation>
      deleteChannelConnectionSettings() {
    return ((EventarcStubSettings) getStubSettings()).deleteChannelConnectionSettings();
  }

  /** Returns the object with the settings used for calls to deleteChannelConnection. */
  public OperationCallSettings<DeleteChannelConnectionRequest, ChannelConnection, OperationMetadata>
      deleteChannelConnectionOperationSettings() {
    return ((EventarcStubSettings) getStubSettings()).deleteChannelConnectionOperationSettings();
  }

  /** Returns the object with the settings used for calls to getGoogleChannelConfig. */
  public UnaryCallSettings<GetGoogleChannelConfigRequest, GoogleChannelConfig>
      getGoogleChannelConfigSettings() {
    return ((EventarcStubSettings) getStubSettings()).getGoogleChannelConfigSettings();
  }

  /** Returns the object with the settings used for calls to updateGoogleChannelConfig. */
  public UnaryCallSettings<UpdateGoogleChannelConfigRequest, GoogleChannelConfig>
      updateGoogleChannelConfigSettings() {
    return ((EventarcStubSettings) getStubSettings()).updateGoogleChannelConfigSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((EventarcStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((EventarcStubSettings) getStubSettings()).getLocationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((EventarcStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((EventarcStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((EventarcStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final EventarcSettings create(EventarcStubSettings stub) throws IOException {
    return new EventarcSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return EventarcStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return EventarcStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return EventarcStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return EventarcStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return EventarcStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return EventarcStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return EventarcStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return EventarcStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected EventarcSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for EventarcSettings. */
  public static class Builder extends ClientSettings.Builder<EventarcSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(EventarcStubSettings.newBuilder(clientContext));
    }

    protected Builder(EventarcSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(EventarcStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(EventarcStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(EventarcStubSettings.newHttpJsonBuilder());
    }

    public EventarcStubSettings.Builder getStubSettingsBuilder() {
      return ((EventarcStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to getTrigger. */
    public UnaryCallSettings.Builder<GetTriggerRequest, Trigger> getTriggerSettings() {
      return getStubSettingsBuilder().getTriggerSettings();
    }

    /** Returns the builder for the settings used for calls to listTriggers. */
    public PagedCallSettings.Builder<
            ListTriggersRequest, ListTriggersResponse, ListTriggersPagedResponse>
        listTriggersSettings() {
      return getStubSettingsBuilder().listTriggersSettings();
    }

    /** Returns the builder for the settings used for calls to createTrigger. */
    public UnaryCallSettings.Builder<CreateTriggerRequest, Operation> createTriggerSettings() {
      return getStubSettingsBuilder().createTriggerSettings();
    }

    /** Returns the builder for the settings used for calls to createTrigger. */
    public OperationCallSettings.Builder<CreateTriggerRequest, Trigger, OperationMetadata>
        createTriggerOperationSettings() {
      return getStubSettingsBuilder().createTriggerOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateTrigger. */
    public UnaryCallSettings.Builder<UpdateTriggerRequest, Operation> updateTriggerSettings() {
      return getStubSettingsBuilder().updateTriggerSettings();
    }

    /** Returns the builder for the settings used for calls to updateTrigger. */
    public OperationCallSettings.Builder<UpdateTriggerRequest, Trigger, OperationMetadata>
        updateTriggerOperationSettings() {
      return getStubSettingsBuilder().updateTriggerOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteTrigger. */
    public UnaryCallSettings.Builder<DeleteTriggerRequest, Operation> deleteTriggerSettings() {
      return getStubSettingsBuilder().deleteTriggerSettings();
    }

    /** Returns the builder for the settings used for calls to deleteTrigger. */
    public OperationCallSettings.Builder<DeleteTriggerRequest, Trigger, OperationMetadata>
        deleteTriggerOperationSettings() {
      return getStubSettingsBuilder().deleteTriggerOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getChannel. */
    public UnaryCallSettings.Builder<GetChannelRequest, Channel> getChannelSettings() {
      return getStubSettingsBuilder().getChannelSettings();
    }

    /** Returns the builder for the settings used for calls to listChannels. */
    public PagedCallSettings.Builder<
            ListChannelsRequest, ListChannelsResponse, ListChannelsPagedResponse>
        listChannelsSettings() {
      return getStubSettingsBuilder().listChannelsSettings();
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

    /** Returns the builder for the settings used for calls to updateChannel. */
    public UnaryCallSettings.Builder<UpdateChannelRequest, Operation> updateChannelSettings() {
      return getStubSettingsBuilder().updateChannelSettings();
    }

    /** Returns the builder for the settings used for calls to updateChannel. */
    public OperationCallSettings.Builder<UpdateChannelRequest, Channel, OperationMetadata>
        updateChannelOperationSettings() {
      return getStubSettingsBuilder().updateChannelOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteChannel. */
    public UnaryCallSettings.Builder<DeleteChannelRequest, Operation> deleteChannelSettings() {
      return getStubSettingsBuilder().deleteChannelSettings();
    }

    /** Returns the builder for the settings used for calls to deleteChannel. */
    public OperationCallSettings.Builder<DeleteChannelRequest, Channel, OperationMetadata>
        deleteChannelOperationSettings() {
      return getStubSettingsBuilder().deleteChannelOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getProvider. */
    public UnaryCallSettings.Builder<GetProviderRequest, Provider> getProviderSettings() {
      return getStubSettingsBuilder().getProviderSettings();
    }

    /** Returns the builder for the settings used for calls to listProviders. */
    public PagedCallSettings.Builder<
            ListProvidersRequest, ListProvidersResponse, ListProvidersPagedResponse>
        listProvidersSettings() {
      return getStubSettingsBuilder().listProvidersSettings();
    }

    /** Returns the builder for the settings used for calls to getChannelConnection. */
    public UnaryCallSettings.Builder<GetChannelConnectionRequest, ChannelConnection>
        getChannelConnectionSettings() {
      return getStubSettingsBuilder().getChannelConnectionSettings();
    }

    /** Returns the builder for the settings used for calls to listChannelConnections. */
    public PagedCallSettings.Builder<
            ListChannelConnectionsRequest,
            ListChannelConnectionsResponse,
            ListChannelConnectionsPagedResponse>
        listChannelConnectionsSettings() {
      return getStubSettingsBuilder().listChannelConnectionsSettings();
    }

    /** Returns the builder for the settings used for calls to createChannelConnection. */
    public UnaryCallSettings.Builder<CreateChannelConnectionRequest, Operation>
        createChannelConnectionSettings() {
      return getStubSettingsBuilder().createChannelConnectionSettings();
    }

    /** Returns the builder for the settings used for calls to createChannelConnection. */
    public OperationCallSettings.Builder<
            CreateChannelConnectionRequest, ChannelConnection, OperationMetadata>
        createChannelConnectionOperationSettings() {
      return getStubSettingsBuilder().createChannelConnectionOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteChannelConnection. */
    public UnaryCallSettings.Builder<DeleteChannelConnectionRequest, Operation>
        deleteChannelConnectionSettings() {
      return getStubSettingsBuilder().deleteChannelConnectionSettings();
    }

    /** Returns the builder for the settings used for calls to deleteChannelConnection. */
    public OperationCallSettings.Builder<
            DeleteChannelConnectionRequest, ChannelConnection, OperationMetadata>
        deleteChannelConnectionOperationSettings() {
      return getStubSettingsBuilder().deleteChannelConnectionOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getGoogleChannelConfig. */
    public UnaryCallSettings.Builder<GetGoogleChannelConfigRequest, GoogleChannelConfig>
        getGoogleChannelConfigSettings() {
      return getStubSettingsBuilder().getGoogleChannelConfigSettings();
    }

    /** Returns the builder for the settings used for calls to updateGoogleChannelConfig. */
    public UnaryCallSettings.Builder<UpdateGoogleChannelConfigRequest, GoogleChannelConfig>
        updateGoogleChannelConfigSettings() {
      return getStubSettingsBuilder().updateGoogleChannelConfigSettings();
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

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return getStubSettingsBuilder().setIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getStubSettingsBuilder().getIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return getStubSettingsBuilder().testIamPermissionsSettings();
    }

    @Override
    public EventarcSettings build() throws IOException {
      return new EventarcSettings(this);
    }
  }
}
