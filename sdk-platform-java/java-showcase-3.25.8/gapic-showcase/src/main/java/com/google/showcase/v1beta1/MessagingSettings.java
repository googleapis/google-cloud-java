/*
 * Copyright 2025 Google LLC
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

package com.google.showcase.v1beta1;

import static com.google.showcase.v1beta1.MessagingClient.ListBlurbsPagedResponse;
import static com.google.showcase.v1beta1.MessagingClient.ListLocationsPagedResponse;
import static com.google.showcase.v1beta1.MessagingClient.ListRoomsPagedResponse;

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
import com.google.api.gax.rpc.ServerStreamingCallSettings;
import com.google.api.gax.rpc.StreamingCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
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
import com.google.protobuf.Empty;
import com.google.showcase.v1beta1.stub.MessagingStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link MessagingClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (localhost) and default port (7469) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of createRoom:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * MessagingSettings.Builder messagingSettingsBuilder = MessagingSettings.newBuilder();
 * messagingSettingsBuilder
 *     .createRoomSettings()
 *     .setRetrySettings(
 *         messagingSettingsBuilder
 *             .createRoomSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofSeconds(1))
 *             .setInitialRpcTimeoutDuration(Duration.ofSeconds(5))
 *             .setMaxAttempts(5)
 *             .setMaxRetryDelayDuration(Duration.ofSeconds(30))
 *             .setMaxRpcTimeoutDuration(Duration.ofSeconds(60))
 *             .setRetryDelayMultiplier(1.3)
 *             .setRpcTimeoutMultiplier(1.5)
 *             .setTotalTimeoutDuration(Duration.ofSeconds(300))
 *             .build());
 * MessagingSettings messagingSettings = messagingSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for searchBlurbs:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * MessagingSettings.Builder messagingSettingsBuilder = MessagingSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * messagingSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class MessagingSettings extends ClientSettings<MessagingSettings> {

  /** Returns the object with the settings used for calls to createRoom. */
  public UnaryCallSettings<CreateRoomRequest, Room> createRoomSettings() {
    return ((MessagingStubSettings) getStubSettings()).createRoomSettings();
  }

  /** Returns the object with the settings used for calls to getRoom. */
  public UnaryCallSettings<GetRoomRequest, Room> getRoomSettings() {
    return ((MessagingStubSettings) getStubSettings()).getRoomSettings();
  }

  /** Returns the object with the settings used for calls to updateRoom. */
  public UnaryCallSettings<UpdateRoomRequest, Room> updateRoomSettings() {
    return ((MessagingStubSettings) getStubSettings()).updateRoomSettings();
  }

  /** Returns the object with the settings used for calls to deleteRoom. */
  public UnaryCallSettings<DeleteRoomRequest, Empty> deleteRoomSettings() {
    return ((MessagingStubSettings) getStubSettings()).deleteRoomSettings();
  }

  /** Returns the object with the settings used for calls to listRooms. */
  public PagedCallSettings<ListRoomsRequest, ListRoomsResponse, ListRoomsPagedResponse>
      listRoomsSettings() {
    return ((MessagingStubSettings) getStubSettings()).listRoomsSettings();
  }

  /** Returns the object with the settings used for calls to createBlurb. */
  public UnaryCallSettings<CreateBlurbRequest, Blurb> createBlurbSettings() {
    return ((MessagingStubSettings) getStubSettings()).createBlurbSettings();
  }

  /** Returns the object with the settings used for calls to getBlurb. */
  public UnaryCallSettings<GetBlurbRequest, Blurb> getBlurbSettings() {
    return ((MessagingStubSettings) getStubSettings()).getBlurbSettings();
  }

  /** Returns the object with the settings used for calls to updateBlurb. */
  public UnaryCallSettings<UpdateBlurbRequest, Blurb> updateBlurbSettings() {
    return ((MessagingStubSettings) getStubSettings()).updateBlurbSettings();
  }

  /** Returns the object with the settings used for calls to deleteBlurb. */
  public UnaryCallSettings<DeleteBlurbRequest, Empty> deleteBlurbSettings() {
    return ((MessagingStubSettings) getStubSettings()).deleteBlurbSettings();
  }

  /** Returns the object with the settings used for calls to listBlurbs. */
  public PagedCallSettings<ListBlurbsRequest, ListBlurbsResponse, ListBlurbsPagedResponse>
      listBlurbsSettings() {
    return ((MessagingStubSettings) getStubSettings()).listBlurbsSettings();
  }

  /** Returns the object with the settings used for calls to searchBlurbs. */
  public UnaryCallSettings<SearchBlurbsRequest, Operation> searchBlurbsSettings() {
    return ((MessagingStubSettings) getStubSettings()).searchBlurbsSettings();
  }

  /** Returns the object with the settings used for calls to searchBlurbs. */
  public OperationCallSettings<SearchBlurbsRequest, SearchBlurbsResponse, SearchBlurbsMetadata>
      searchBlurbsOperationSettings() {
    return ((MessagingStubSettings) getStubSettings()).searchBlurbsOperationSettings();
  }

  /** Returns the object with the settings used for calls to streamBlurbs. */
  public ServerStreamingCallSettings<StreamBlurbsRequest, StreamBlurbsResponse>
      streamBlurbsSettings() {
    return ((MessagingStubSettings) getStubSettings()).streamBlurbsSettings();
  }

  /** Returns the object with the settings used for calls to sendBlurbs. */
  public StreamingCallSettings<CreateBlurbRequest, SendBlurbsResponse> sendBlurbsSettings() {
    return ((MessagingStubSettings) getStubSettings()).sendBlurbsSettings();
  }

  /** Returns the object with the settings used for calls to connect. */
  public StreamingCallSettings<ConnectRequest, StreamBlurbsResponse> connectSettings() {
    return ((MessagingStubSettings) getStubSettings()).connectSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((MessagingStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((MessagingStubSettings) getStubSettings()).getLocationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((MessagingStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((MessagingStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((MessagingStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final MessagingSettings create(MessagingStubSettings stub) throws IOException {
    return new MessagingSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return MessagingStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return MessagingStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return MessagingStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return MessagingStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return MessagingStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return MessagingStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return MessagingStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return MessagingStubSettings.defaultApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
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

  protected MessagingSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for MessagingSettings. */
  public static class Builder extends ClientSettings.Builder<MessagingSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(MessagingStubSettings.newBuilder(clientContext));
    }

    protected Builder(MessagingSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(MessagingStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(MessagingStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(MessagingStubSettings.newHttpJsonBuilder());
    }

    public MessagingStubSettings.Builder getStubSettingsBuilder() {
      return ((MessagingStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createRoom. */
    public UnaryCallSettings.Builder<CreateRoomRequest, Room> createRoomSettings() {
      return getStubSettingsBuilder().createRoomSettings();
    }

    /** Returns the builder for the settings used for calls to getRoom. */
    public UnaryCallSettings.Builder<GetRoomRequest, Room> getRoomSettings() {
      return getStubSettingsBuilder().getRoomSettings();
    }

    /** Returns the builder for the settings used for calls to updateRoom. */
    public UnaryCallSettings.Builder<UpdateRoomRequest, Room> updateRoomSettings() {
      return getStubSettingsBuilder().updateRoomSettings();
    }

    /** Returns the builder for the settings used for calls to deleteRoom. */
    public UnaryCallSettings.Builder<DeleteRoomRequest, Empty> deleteRoomSettings() {
      return getStubSettingsBuilder().deleteRoomSettings();
    }

    /** Returns the builder for the settings used for calls to listRooms. */
    public PagedCallSettings.Builder<ListRoomsRequest, ListRoomsResponse, ListRoomsPagedResponse>
        listRoomsSettings() {
      return getStubSettingsBuilder().listRoomsSettings();
    }

    /** Returns the builder for the settings used for calls to createBlurb. */
    public UnaryCallSettings.Builder<CreateBlurbRequest, Blurb> createBlurbSettings() {
      return getStubSettingsBuilder().createBlurbSettings();
    }

    /** Returns the builder for the settings used for calls to getBlurb. */
    public UnaryCallSettings.Builder<GetBlurbRequest, Blurb> getBlurbSettings() {
      return getStubSettingsBuilder().getBlurbSettings();
    }

    /** Returns the builder for the settings used for calls to updateBlurb. */
    public UnaryCallSettings.Builder<UpdateBlurbRequest, Blurb> updateBlurbSettings() {
      return getStubSettingsBuilder().updateBlurbSettings();
    }

    /** Returns the builder for the settings used for calls to deleteBlurb. */
    public UnaryCallSettings.Builder<DeleteBlurbRequest, Empty> deleteBlurbSettings() {
      return getStubSettingsBuilder().deleteBlurbSettings();
    }

    /** Returns the builder for the settings used for calls to listBlurbs. */
    public PagedCallSettings.Builder<ListBlurbsRequest, ListBlurbsResponse, ListBlurbsPagedResponse>
        listBlurbsSettings() {
      return getStubSettingsBuilder().listBlurbsSettings();
    }

    /** Returns the builder for the settings used for calls to searchBlurbs. */
    public UnaryCallSettings.Builder<SearchBlurbsRequest, Operation> searchBlurbsSettings() {
      return getStubSettingsBuilder().searchBlurbsSettings();
    }

    /** Returns the builder for the settings used for calls to searchBlurbs. */
    public OperationCallSettings.Builder<
            SearchBlurbsRequest, SearchBlurbsResponse, SearchBlurbsMetadata>
        searchBlurbsOperationSettings() {
      return getStubSettingsBuilder().searchBlurbsOperationSettings();
    }

    /** Returns the builder for the settings used for calls to streamBlurbs. */
    public ServerStreamingCallSettings.Builder<StreamBlurbsRequest, StreamBlurbsResponse>
        streamBlurbsSettings() {
      return getStubSettingsBuilder().streamBlurbsSettings();
    }

    /** Returns the builder for the settings used for calls to sendBlurbs. */
    public StreamingCallSettings.Builder<CreateBlurbRequest, SendBlurbsResponse>
        sendBlurbsSettings() {
      return getStubSettingsBuilder().sendBlurbsSettings();
    }

    /** Returns the builder for the settings used for calls to connect. */
    public StreamingCallSettings.Builder<ConnectRequest, StreamBlurbsResponse> connectSettings() {
      return getStubSettingsBuilder().connectSettings();
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
    public MessagingSettings build() throws IOException {
      return new MessagingSettings(this);
    }
  }
}
