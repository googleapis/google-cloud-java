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

package com.google.cloud.networkconnectivity.v1;

import static com.google.cloud.networkconnectivity.v1.HubServiceClient.ListGroupsPagedResponse;
import static com.google.cloud.networkconnectivity.v1.HubServiceClient.ListHubSpokesPagedResponse;
import static com.google.cloud.networkconnectivity.v1.HubServiceClient.ListHubsPagedResponse;
import static com.google.cloud.networkconnectivity.v1.HubServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.networkconnectivity.v1.HubServiceClient.ListRouteTablesPagedResponse;
import static com.google.cloud.networkconnectivity.v1.HubServiceClient.ListRoutesPagedResponse;
import static com.google.cloud.networkconnectivity.v1.HubServiceClient.ListSpokesPagedResponse;
import static com.google.cloud.networkconnectivity.v1.HubServiceClient.QueryHubStatusPagedResponse;

import com.google.api.core.ApiFunction;
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
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.networkconnectivity.v1.stub.HubServiceStubSettings;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
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
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getHub:
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
 *         hubServiceSettingsBuilder
 *             .getHubSettings()
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
 * HubServiceSettings hubServiceSettings = hubServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createHub:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * HubServiceSettings.Builder hubServiceSettingsBuilder = HubServiceSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * hubServiceSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
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

  /** Returns the object with the settings used for calls to listHubSpokes. */
  public PagedCallSettings<ListHubSpokesRequest, ListHubSpokesResponse, ListHubSpokesPagedResponse>
      listHubSpokesSettings() {
    return ((HubServiceStubSettings) getStubSettings()).listHubSpokesSettings();
  }

  /** Returns the object with the settings used for calls to queryHubStatus. */
  public PagedCallSettings<
          QueryHubStatusRequest, QueryHubStatusResponse, QueryHubStatusPagedResponse>
      queryHubStatusSettings() {
    return ((HubServiceStubSettings) getStubSettings()).queryHubStatusSettings();
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

  /** Returns the object with the settings used for calls to rejectHubSpoke. */
  public UnaryCallSettings<RejectHubSpokeRequest, Operation> rejectHubSpokeSettings() {
    return ((HubServiceStubSettings) getStubSettings()).rejectHubSpokeSettings();
  }

  /** Returns the object with the settings used for calls to rejectHubSpoke. */
  public OperationCallSettings<RejectHubSpokeRequest, RejectHubSpokeResponse, OperationMetadata>
      rejectHubSpokeOperationSettings() {
    return ((HubServiceStubSettings) getStubSettings()).rejectHubSpokeOperationSettings();
  }

  /** Returns the object with the settings used for calls to acceptHubSpoke. */
  public UnaryCallSettings<AcceptHubSpokeRequest, Operation> acceptHubSpokeSettings() {
    return ((HubServiceStubSettings) getStubSettings()).acceptHubSpokeSettings();
  }

  /** Returns the object with the settings used for calls to acceptHubSpoke. */
  public OperationCallSettings<AcceptHubSpokeRequest, AcceptHubSpokeResponse, OperationMetadata>
      acceptHubSpokeOperationSettings() {
    return ((HubServiceStubSettings) getStubSettings()).acceptHubSpokeOperationSettings();
  }

  /** Returns the object with the settings used for calls to acceptSpokeUpdate. */
  public UnaryCallSettings<AcceptSpokeUpdateRequest, Operation> acceptSpokeUpdateSettings() {
    return ((HubServiceStubSettings) getStubSettings()).acceptSpokeUpdateSettings();
  }

  /** Returns the object with the settings used for calls to acceptSpokeUpdate. */
  public OperationCallSettings<
          AcceptSpokeUpdateRequest, AcceptSpokeUpdateResponse, OperationMetadata>
      acceptSpokeUpdateOperationSettings() {
    return ((HubServiceStubSettings) getStubSettings()).acceptSpokeUpdateOperationSettings();
  }

  /** Returns the object with the settings used for calls to rejectSpokeUpdate. */
  public UnaryCallSettings<RejectSpokeUpdateRequest, Operation> rejectSpokeUpdateSettings() {
    return ((HubServiceStubSettings) getStubSettings()).rejectSpokeUpdateSettings();
  }

  /** Returns the object with the settings used for calls to rejectSpokeUpdate. */
  public OperationCallSettings<
          RejectSpokeUpdateRequest, RejectSpokeUpdateResponse, OperationMetadata>
      rejectSpokeUpdateOperationSettings() {
    return ((HubServiceStubSettings) getStubSettings()).rejectSpokeUpdateOperationSettings();
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

  /** Returns the object with the settings used for calls to getRouteTable. */
  public UnaryCallSettings<GetRouteTableRequest, RouteTable> getRouteTableSettings() {
    return ((HubServiceStubSettings) getStubSettings()).getRouteTableSettings();
  }

  /** Returns the object with the settings used for calls to getRoute. */
  public UnaryCallSettings<GetRouteRequest, Route> getRouteSettings() {
    return ((HubServiceStubSettings) getStubSettings()).getRouteSettings();
  }

  /** Returns the object with the settings used for calls to listRoutes. */
  public PagedCallSettings<ListRoutesRequest, ListRoutesResponse, ListRoutesPagedResponse>
      listRoutesSettings() {
    return ((HubServiceStubSettings) getStubSettings()).listRoutesSettings();
  }

  /** Returns the object with the settings used for calls to listRouteTables. */
  public PagedCallSettings<
          ListRouteTablesRequest, ListRouteTablesResponse, ListRouteTablesPagedResponse>
      listRouteTablesSettings() {
    return ((HubServiceStubSettings) getStubSettings()).listRouteTablesSettings();
  }

  /** Returns the object with the settings used for calls to getGroup. */
  public UnaryCallSettings<GetGroupRequest, Group> getGroupSettings() {
    return ((HubServiceStubSettings) getStubSettings()).getGroupSettings();
  }

  /** Returns the object with the settings used for calls to listGroups. */
  public PagedCallSettings<ListGroupsRequest, ListGroupsResponse, ListGroupsPagedResponse>
      listGroupsSettings() {
    return ((HubServiceStubSettings) getStubSettings()).listGroupsSettings();
  }

  /** Returns the object with the settings used for calls to updateGroup. */
  public UnaryCallSettings<UpdateGroupRequest, Operation> updateGroupSettings() {
    return ((HubServiceStubSettings) getStubSettings()).updateGroupSettings();
  }

  /** Returns the object with the settings used for calls to updateGroup. */
  public OperationCallSettings<UpdateGroupRequest, Group, OperationMetadata>
      updateGroupOperationSettings() {
    return ((HubServiceStubSettings) getStubSettings()).updateGroupOperationSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((HubServiceStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((HubServiceStubSettings) getStubSettings()).getLocationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((HubServiceStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((HubServiceStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((HubServiceStubSettings) getStubSettings()).testIamPermissionsSettings();
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

    /** Returns the builder for the settings used for calls to listHubSpokes. */
    public PagedCallSettings.Builder<
            ListHubSpokesRequest, ListHubSpokesResponse, ListHubSpokesPagedResponse>
        listHubSpokesSettings() {
      return getStubSettingsBuilder().listHubSpokesSettings();
    }

    /** Returns the builder for the settings used for calls to queryHubStatus. */
    public PagedCallSettings.Builder<
            QueryHubStatusRequest, QueryHubStatusResponse, QueryHubStatusPagedResponse>
        queryHubStatusSettings() {
      return getStubSettingsBuilder().queryHubStatusSettings();
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

    /** Returns the builder for the settings used for calls to rejectHubSpoke. */
    public UnaryCallSettings.Builder<RejectHubSpokeRequest, Operation> rejectHubSpokeSettings() {
      return getStubSettingsBuilder().rejectHubSpokeSettings();
    }

    /** Returns the builder for the settings used for calls to rejectHubSpoke. */
    public OperationCallSettings.Builder<
            RejectHubSpokeRequest, RejectHubSpokeResponse, OperationMetadata>
        rejectHubSpokeOperationSettings() {
      return getStubSettingsBuilder().rejectHubSpokeOperationSettings();
    }

    /** Returns the builder for the settings used for calls to acceptHubSpoke. */
    public UnaryCallSettings.Builder<AcceptHubSpokeRequest, Operation> acceptHubSpokeSettings() {
      return getStubSettingsBuilder().acceptHubSpokeSettings();
    }

    /** Returns the builder for the settings used for calls to acceptHubSpoke. */
    public OperationCallSettings.Builder<
            AcceptHubSpokeRequest, AcceptHubSpokeResponse, OperationMetadata>
        acceptHubSpokeOperationSettings() {
      return getStubSettingsBuilder().acceptHubSpokeOperationSettings();
    }

    /** Returns the builder for the settings used for calls to acceptSpokeUpdate. */
    public UnaryCallSettings.Builder<AcceptSpokeUpdateRequest, Operation>
        acceptSpokeUpdateSettings() {
      return getStubSettingsBuilder().acceptSpokeUpdateSettings();
    }

    /** Returns the builder for the settings used for calls to acceptSpokeUpdate. */
    public OperationCallSettings.Builder<
            AcceptSpokeUpdateRequest, AcceptSpokeUpdateResponse, OperationMetadata>
        acceptSpokeUpdateOperationSettings() {
      return getStubSettingsBuilder().acceptSpokeUpdateOperationSettings();
    }

    /** Returns the builder for the settings used for calls to rejectSpokeUpdate. */
    public UnaryCallSettings.Builder<RejectSpokeUpdateRequest, Operation>
        rejectSpokeUpdateSettings() {
      return getStubSettingsBuilder().rejectSpokeUpdateSettings();
    }

    /** Returns the builder for the settings used for calls to rejectSpokeUpdate. */
    public OperationCallSettings.Builder<
            RejectSpokeUpdateRequest, RejectSpokeUpdateResponse, OperationMetadata>
        rejectSpokeUpdateOperationSettings() {
      return getStubSettingsBuilder().rejectSpokeUpdateOperationSettings();
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

    /** Returns the builder for the settings used for calls to getRouteTable. */
    public UnaryCallSettings.Builder<GetRouteTableRequest, RouteTable> getRouteTableSettings() {
      return getStubSettingsBuilder().getRouteTableSettings();
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

    /** Returns the builder for the settings used for calls to listRouteTables. */
    public PagedCallSettings.Builder<
            ListRouteTablesRequest, ListRouteTablesResponse, ListRouteTablesPagedResponse>
        listRouteTablesSettings() {
      return getStubSettingsBuilder().listRouteTablesSettings();
    }

    /** Returns the builder for the settings used for calls to getGroup. */
    public UnaryCallSettings.Builder<GetGroupRequest, Group> getGroupSettings() {
      return getStubSettingsBuilder().getGroupSettings();
    }

    /** Returns the builder for the settings used for calls to listGroups. */
    public PagedCallSettings.Builder<ListGroupsRequest, ListGroupsResponse, ListGroupsPagedResponse>
        listGroupsSettings() {
      return getStubSettingsBuilder().listGroupsSettings();
    }

    /** Returns the builder for the settings used for calls to updateGroup. */
    public UnaryCallSettings.Builder<UpdateGroupRequest, Operation> updateGroupSettings() {
      return getStubSettingsBuilder().updateGroupSettings();
    }

    /** Returns the builder for the settings used for calls to updateGroup. */
    public OperationCallSettings.Builder<UpdateGroupRequest, Group, OperationMetadata>
        updateGroupOperationSettings() {
      return getStubSettingsBuilder().updateGroupOperationSettings();
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
    public HubServiceSettings build() throws IOException {
      return new HubServiceSettings(this);
    }
  }
}
