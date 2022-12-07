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

package com.google.cloud.datastream.v1alpha1;

import static com.google.cloud.datastream.v1alpha1.DatastreamClient.FetchStaticIpsPagedResponse;
import static com.google.cloud.datastream.v1alpha1.DatastreamClient.ListConnectionProfilesPagedResponse;
import static com.google.cloud.datastream.v1alpha1.DatastreamClient.ListPrivateConnectionsPagedResponse;
import static com.google.cloud.datastream.v1alpha1.DatastreamClient.ListRoutesPagedResponse;
import static com.google.cloud.datastream.v1alpha1.DatastreamClient.ListStreamsPagedResponse;

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
import com.google.cloud.datastream.v1alpha1.stub.DatastreamStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link DatastreamClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (datastream.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getConnectionProfile to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DatastreamSettings.Builder datastreamSettingsBuilder = DatastreamSettings.newBuilder();
 * datastreamSettingsBuilder
 *     .getConnectionProfileSettings()
 *     .setRetrySettings(
 *         datastreamSettingsBuilder.getConnectionProfileSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * DatastreamSettings datastreamSettings = datastreamSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class DatastreamSettings extends ClientSettings<DatastreamSettings> {

  /** Returns the object with the settings used for calls to listConnectionProfiles. */
  public PagedCallSettings<
          ListConnectionProfilesRequest,
          ListConnectionProfilesResponse,
          ListConnectionProfilesPagedResponse>
      listConnectionProfilesSettings() {
    return ((DatastreamStubSettings) getStubSettings()).listConnectionProfilesSettings();
  }

  /** Returns the object with the settings used for calls to getConnectionProfile. */
  public UnaryCallSettings<GetConnectionProfileRequest, ConnectionProfile>
      getConnectionProfileSettings() {
    return ((DatastreamStubSettings) getStubSettings()).getConnectionProfileSettings();
  }

  /** Returns the object with the settings used for calls to createConnectionProfile. */
  public UnaryCallSettings<CreateConnectionProfileRequest, Operation>
      createConnectionProfileSettings() {
    return ((DatastreamStubSettings) getStubSettings()).createConnectionProfileSettings();
  }

  /** Returns the object with the settings used for calls to createConnectionProfile. */
  public OperationCallSettings<CreateConnectionProfileRequest, ConnectionProfile, OperationMetadata>
      createConnectionProfileOperationSettings() {
    return ((DatastreamStubSettings) getStubSettings()).createConnectionProfileOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateConnectionProfile. */
  public UnaryCallSettings<UpdateConnectionProfileRequest, Operation>
      updateConnectionProfileSettings() {
    return ((DatastreamStubSettings) getStubSettings()).updateConnectionProfileSettings();
  }

  /** Returns the object with the settings used for calls to updateConnectionProfile. */
  public OperationCallSettings<UpdateConnectionProfileRequest, ConnectionProfile, OperationMetadata>
      updateConnectionProfileOperationSettings() {
    return ((DatastreamStubSettings) getStubSettings()).updateConnectionProfileOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteConnectionProfile. */
  public UnaryCallSettings<DeleteConnectionProfileRequest, Operation>
      deleteConnectionProfileSettings() {
    return ((DatastreamStubSettings) getStubSettings()).deleteConnectionProfileSettings();
  }

  /** Returns the object with the settings used for calls to deleteConnectionProfile. */
  public OperationCallSettings<DeleteConnectionProfileRequest, Empty, OperationMetadata>
      deleteConnectionProfileOperationSettings() {
    return ((DatastreamStubSettings) getStubSettings()).deleteConnectionProfileOperationSettings();
  }

  /** Returns the object with the settings used for calls to discoverConnectionProfile. */
  public UnaryCallSettings<DiscoverConnectionProfileRequest, DiscoverConnectionProfileResponse>
      discoverConnectionProfileSettings() {
    return ((DatastreamStubSettings) getStubSettings()).discoverConnectionProfileSettings();
  }

  /** Returns the object with the settings used for calls to listStreams. */
  public PagedCallSettings<ListStreamsRequest, ListStreamsResponse, ListStreamsPagedResponse>
      listStreamsSettings() {
    return ((DatastreamStubSettings) getStubSettings()).listStreamsSettings();
  }

  /** Returns the object with the settings used for calls to getStream. */
  public UnaryCallSettings<GetStreamRequest, Stream> getStreamSettings() {
    return ((DatastreamStubSettings) getStubSettings()).getStreamSettings();
  }

  /** Returns the object with the settings used for calls to createStream. */
  public UnaryCallSettings<CreateStreamRequest, Operation> createStreamSettings() {
    return ((DatastreamStubSettings) getStubSettings()).createStreamSettings();
  }

  /** Returns the object with the settings used for calls to createStream. */
  public OperationCallSettings<CreateStreamRequest, Stream, OperationMetadata>
      createStreamOperationSettings() {
    return ((DatastreamStubSettings) getStubSettings()).createStreamOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateStream. */
  public UnaryCallSettings<UpdateStreamRequest, Operation> updateStreamSettings() {
    return ((DatastreamStubSettings) getStubSettings()).updateStreamSettings();
  }

  /** Returns the object with the settings used for calls to updateStream. */
  public OperationCallSettings<UpdateStreamRequest, Stream, OperationMetadata>
      updateStreamOperationSettings() {
    return ((DatastreamStubSettings) getStubSettings()).updateStreamOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteStream. */
  public UnaryCallSettings<DeleteStreamRequest, Operation> deleteStreamSettings() {
    return ((DatastreamStubSettings) getStubSettings()).deleteStreamSettings();
  }

  /** Returns the object with the settings used for calls to deleteStream. */
  public OperationCallSettings<DeleteStreamRequest, Empty, OperationMetadata>
      deleteStreamOperationSettings() {
    return ((DatastreamStubSettings) getStubSettings()).deleteStreamOperationSettings();
  }

  /** Returns the object with the settings used for calls to fetchErrors. */
  public UnaryCallSettings<FetchErrorsRequest, Operation> fetchErrorsSettings() {
    return ((DatastreamStubSettings) getStubSettings()).fetchErrorsSettings();
  }

  /** Returns the object with the settings used for calls to fetchErrors. */
  public OperationCallSettings<FetchErrorsRequest, FetchErrorsResponse, OperationMetadata>
      fetchErrorsOperationSettings() {
    return ((DatastreamStubSettings) getStubSettings()).fetchErrorsOperationSettings();
  }

  /** Returns the object with the settings used for calls to fetchStaticIps. */
  public PagedCallSettings<
          FetchStaticIpsRequest, FetchStaticIpsResponse, FetchStaticIpsPagedResponse>
      fetchStaticIpsSettings() {
    return ((DatastreamStubSettings) getStubSettings()).fetchStaticIpsSettings();
  }

  /** Returns the object with the settings used for calls to createPrivateConnection. */
  public UnaryCallSettings<CreatePrivateConnectionRequest, Operation>
      createPrivateConnectionSettings() {
    return ((DatastreamStubSettings) getStubSettings()).createPrivateConnectionSettings();
  }

  /** Returns the object with the settings used for calls to createPrivateConnection. */
  public OperationCallSettings<CreatePrivateConnectionRequest, PrivateConnection, OperationMetadata>
      createPrivateConnectionOperationSettings() {
    return ((DatastreamStubSettings) getStubSettings()).createPrivateConnectionOperationSettings();
  }

  /** Returns the object with the settings used for calls to getPrivateConnection. */
  public UnaryCallSettings<GetPrivateConnectionRequest, PrivateConnection>
      getPrivateConnectionSettings() {
    return ((DatastreamStubSettings) getStubSettings()).getPrivateConnectionSettings();
  }

  /** Returns the object with the settings used for calls to listPrivateConnections. */
  public PagedCallSettings<
          ListPrivateConnectionsRequest,
          ListPrivateConnectionsResponse,
          ListPrivateConnectionsPagedResponse>
      listPrivateConnectionsSettings() {
    return ((DatastreamStubSettings) getStubSettings()).listPrivateConnectionsSettings();
  }

  /** Returns the object with the settings used for calls to deletePrivateConnection. */
  public UnaryCallSettings<DeletePrivateConnectionRequest, Operation>
      deletePrivateConnectionSettings() {
    return ((DatastreamStubSettings) getStubSettings()).deletePrivateConnectionSettings();
  }

  /** Returns the object with the settings used for calls to deletePrivateConnection. */
  public OperationCallSettings<DeletePrivateConnectionRequest, Empty, OperationMetadata>
      deletePrivateConnectionOperationSettings() {
    return ((DatastreamStubSettings) getStubSettings()).deletePrivateConnectionOperationSettings();
  }

  /** Returns the object with the settings used for calls to createRoute. */
  public UnaryCallSettings<CreateRouteRequest, Operation> createRouteSettings() {
    return ((DatastreamStubSettings) getStubSettings()).createRouteSettings();
  }

  /** Returns the object with the settings used for calls to createRoute. */
  public OperationCallSettings<CreateRouteRequest, Route, OperationMetadata>
      createRouteOperationSettings() {
    return ((DatastreamStubSettings) getStubSettings()).createRouteOperationSettings();
  }

  /** Returns the object with the settings used for calls to getRoute. */
  public UnaryCallSettings<GetRouteRequest, Route> getRouteSettings() {
    return ((DatastreamStubSettings) getStubSettings()).getRouteSettings();
  }

  /** Returns the object with the settings used for calls to listRoutes. */
  public PagedCallSettings<ListRoutesRequest, ListRoutesResponse, ListRoutesPagedResponse>
      listRoutesSettings() {
    return ((DatastreamStubSettings) getStubSettings()).listRoutesSettings();
  }

  /** Returns the object with the settings used for calls to deleteRoute. */
  public UnaryCallSettings<DeleteRouteRequest, Operation> deleteRouteSettings() {
    return ((DatastreamStubSettings) getStubSettings()).deleteRouteSettings();
  }

  /** Returns the object with the settings used for calls to deleteRoute. */
  public OperationCallSettings<DeleteRouteRequest, Empty, OperationMetadata>
      deleteRouteOperationSettings() {
    return ((DatastreamStubSettings) getStubSettings()).deleteRouteOperationSettings();
  }

  public static final DatastreamSettings create(DatastreamStubSettings stub) throws IOException {
    return new DatastreamSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return DatastreamStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return DatastreamStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DatastreamStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return DatastreamStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return DatastreamStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return DatastreamStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return DatastreamStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DatastreamStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected DatastreamSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for DatastreamSettings. */
  public static class Builder extends ClientSettings.Builder<DatastreamSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(DatastreamStubSettings.newBuilder(clientContext));
    }

    protected Builder(DatastreamSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(DatastreamStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(DatastreamStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(DatastreamStubSettings.newHttpJsonBuilder());
    }

    public DatastreamStubSettings.Builder getStubSettingsBuilder() {
      return ((DatastreamStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listConnectionProfiles. */
    public PagedCallSettings.Builder<
            ListConnectionProfilesRequest,
            ListConnectionProfilesResponse,
            ListConnectionProfilesPagedResponse>
        listConnectionProfilesSettings() {
      return getStubSettingsBuilder().listConnectionProfilesSettings();
    }

    /** Returns the builder for the settings used for calls to getConnectionProfile. */
    public UnaryCallSettings.Builder<GetConnectionProfileRequest, ConnectionProfile>
        getConnectionProfileSettings() {
      return getStubSettingsBuilder().getConnectionProfileSettings();
    }

    /** Returns the builder for the settings used for calls to createConnectionProfile. */
    public UnaryCallSettings.Builder<CreateConnectionProfileRequest, Operation>
        createConnectionProfileSettings() {
      return getStubSettingsBuilder().createConnectionProfileSettings();
    }

    /** Returns the builder for the settings used for calls to createConnectionProfile. */
    public OperationCallSettings.Builder<
            CreateConnectionProfileRequest, ConnectionProfile, OperationMetadata>
        createConnectionProfileOperationSettings() {
      return getStubSettingsBuilder().createConnectionProfileOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateConnectionProfile. */
    public UnaryCallSettings.Builder<UpdateConnectionProfileRequest, Operation>
        updateConnectionProfileSettings() {
      return getStubSettingsBuilder().updateConnectionProfileSettings();
    }

    /** Returns the builder for the settings used for calls to updateConnectionProfile. */
    public OperationCallSettings.Builder<
            UpdateConnectionProfileRequest, ConnectionProfile, OperationMetadata>
        updateConnectionProfileOperationSettings() {
      return getStubSettingsBuilder().updateConnectionProfileOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteConnectionProfile. */
    public UnaryCallSettings.Builder<DeleteConnectionProfileRequest, Operation>
        deleteConnectionProfileSettings() {
      return getStubSettingsBuilder().deleteConnectionProfileSettings();
    }

    /** Returns the builder for the settings used for calls to deleteConnectionProfile. */
    public OperationCallSettings.Builder<DeleteConnectionProfileRequest, Empty, OperationMetadata>
        deleteConnectionProfileOperationSettings() {
      return getStubSettingsBuilder().deleteConnectionProfileOperationSettings();
    }

    /** Returns the builder for the settings used for calls to discoverConnectionProfile. */
    public UnaryCallSettings.Builder<
            DiscoverConnectionProfileRequest, DiscoverConnectionProfileResponse>
        discoverConnectionProfileSettings() {
      return getStubSettingsBuilder().discoverConnectionProfileSettings();
    }

    /** Returns the builder for the settings used for calls to listStreams. */
    public PagedCallSettings.Builder<
            ListStreamsRequest, ListStreamsResponse, ListStreamsPagedResponse>
        listStreamsSettings() {
      return getStubSettingsBuilder().listStreamsSettings();
    }

    /** Returns the builder for the settings used for calls to getStream. */
    public UnaryCallSettings.Builder<GetStreamRequest, Stream> getStreamSettings() {
      return getStubSettingsBuilder().getStreamSettings();
    }

    /** Returns the builder for the settings used for calls to createStream. */
    public UnaryCallSettings.Builder<CreateStreamRequest, Operation> createStreamSettings() {
      return getStubSettingsBuilder().createStreamSettings();
    }

    /** Returns the builder for the settings used for calls to createStream. */
    public OperationCallSettings.Builder<CreateStreamRequest, Stream, OperationMetadata>
        createStreamOperationSettings() {
      return getStubSettingsBuilder().createStreamOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateStream. */
    public UnaryCallSettings.Builder<UpdateStreamRequest, Operation> updateStreamSettings() {
      return getStubSettingsBuilder().updateStreamSettings();
    }

    /** Returns the builder for the settings used for calls to updateStream. */
    public OperationCallSettings.Builder<UpdateStreamRequest, Stream, OperationMetadata>
        updateStreamOperationSettings() {
      return getStubSettingsBuilder().updateStreamOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteStream. */
    public UnaryCallSettings.Builder<DeleteStreamRequest, Operation> deleteStreamSettings() {
      return getStubSettingsBuilder().deleteStreamSettings();
    }

    /** Returns the builder for the settings used for calls to deleteStream. */
    public OperationCallSettings.Builder<DeleteStreamRequest, Empty, OperationMetadata>
        deleteStreamOperationSettings() {
      return getStubSettingsBuilder().deleteStreamOperationSettings();
    }

    /** Returns the builder for the settings used for calls to fetchErrors. */
    public UnaryCallSettings.Builder<FetchErrorsRequest, Operation> fetchErrorsSettings() {
      return getStubSettingsBuilder().fetchErrorsSettings();
    }

    /** Returns the builder for the settings used for calls to fetchErrors. */
    public OperationCallSettings.Builder<FetchErrorsRequest, FetchErrorsResponse, OperationMetadata>
        fetchErrorsOperationSettings() {
      return getStubSettingsBuilder().fetchErrorsOperationSettings();
    }

    /** Returns the builder for the settings used for calls to fetchStaticIps. */
    public PagedCallSettings.Builder<
            FetchStaticIpsRequest, FetchStaticIpsResponse, FetchStaticIpsPagedResponse>
        fetchStaticIpsSettings() {
      return getStubSettingsBuilder().fetchStaticIpsSettings();
    }

    /** Returns the builder for the settings used for calls to createPrivateConnection. */
    public UnaryCallSettings.Builder<CreatePrivateConnectionRequest, Operation>
        createPrivateConnectionSettings() {
      return getStubSettingsBuilder().createPrivateConnectionSettings();
    }

    /** Returns the builder for the settings used for calls to createPrivateConnection. */
    public OperationCallSettings.Builder<
            CreatePrivateConnectionRequest, PrivateConnection, OperationMetadata>
        createPrivateConnectionOperationSettings() {
      return getStubSettingsBuilder().createPrivateConnectionOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getPrivateConnection. */
    public UnaryCallSettings.Builder<GetPrivateConnectionRequest, PrivateConnection>
        getPrivateConnectionSettings() {
      return getStubSettingsBuilder().getPrivateConnectionSettings();
    }

    /** Returns the builder for the settings used for calls to listPrivateConnections. */
    public PagedCallSettings.Builder<
            ListPrivateConnectionsRequest,
            ListPrivateConnectionsResponse,
            ListPrivateConnectionsPagedResponse>
        listPrivateConnectionsSettings() {
      return getStubSettingsBuilder().listPrivateConnectionsSettings();
    }

    /** Returns the builder for the settings used for calls to deletePrivateConnection. */
    public UnaryCallSettings.Builder<DeletePrivateConnectionRequest, Operation>
        deletePrivateConnectionSettings() {
      return getStubSettingsBuilder().deletePrivateConnectionSettings();
    }

    /** Returns the builder for the settings used for calls to deletePrivateConnection. */
    public OperationCallSettings.Builder<DeletePrivateConnectionRequest, Empty, OperationMetadata>
        deletePrivateConnectionOperationSettings() {
      return getStubSettingsBuilder().deletePrivateConnectionOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createRoute. */
    public UnaryCallSettings.Builder<CreateRouteRequest, Operation> createRouteSettings() {
      return getStubSettingsBuilder().createRouteSettings();
    }

    /** Returns the builder for the settings used for calls to createRoute. */
    public OperationCallSettings.Builder<CreateRouteRequest, Route, OperationMetadata>
        createRouteOperationSettings() {
      return getStubSettingsBuilder().createRouteOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getRoute. */
    public UnaryCallSettings.Builder<GetRouteRequest, Route> getRouteSettings() {
      return getStubSettingsBuilder().getRouteSettings();
    }

    /** Returns the builder for the settings used for calls to listRoutes. */
    public PagedCallSettings.Builder<ListRoutesRequest, ListRoutesResponse, ListRoutesPagedResponse>
        listRoutesSettings() {
      return getStubSettingsBuilder().listRoutesSettings();
    }

    /** Returns the builder for the settings used for calls to deleteRoute. */
    public UnaryCallSettings.Builder<DeleteRouteRequest, Operation> deleteRouteSettings() {
      return getStubSettingsBuilder().deleteRouteSettings();
    }

    /** Returns the builder for the settings used for calls to deleteRoute. */
    public OperationCallSettings.Builder<DeleteRouteRequest, Empty, OperationMetadata>
        deleteRouteOperationSettings() {
      return getStubSettingsBuilder().deleteRouteOperationSettings();
    }

    @Override
    public DatastreamSettings build() throws IOException {
      return new DatastreamSettings(this);
    }
  }
}
