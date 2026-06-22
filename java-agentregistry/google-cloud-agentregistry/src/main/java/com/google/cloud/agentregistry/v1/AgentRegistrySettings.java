/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.agentregistry.v1;

import static com.google.cloud.agentregistry.v1.AgentRegistryClient.FetchAvailableBindingsPagedResponse;
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.ListAgentsPagedResponse;
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.ListBindingsPagedResponse;
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.ListEndpointsPagedResponse;
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.ListLocationsPagedResponse;
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.ListMcpServersPagedResponse;
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.ListServicesPagedResponse;
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.SearchAgentsPagedResponse;
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.SearchMcpServersPagedResponse;

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
import com.google.cloud.agentregistry.v1.stub.AgentRegistryStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link AgentRegistryClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (agentregistry.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getAgent:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AgentRegistrySettings.Builder agentRegistrySettingsBuilder = AgentRegistrySettings.newBuilder();
 * agentRegistrySettingsBuilder
 *     .getAgentSettings()
 *     .setRetrySettings(
 *         agentRegistrySettingsBuilder
 *             .getAgentSettings()
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
 * AgentRegistrySettings agentRegistrySettings = agentRegistrySettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createService:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AgentRegistrySettings.Builder agentRegistrySettingsBuilder = AgentRegistrySettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * agentRegistrySettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class AgentRegistrySettings extends ClientSettings<AgentRegistrySettings> {

  /** Returns the object with the settings used for calls to listAgents. */
  public PagedCallSettings<ListAgentsRequest, ListAgentsResponse, ListAgentsPagedResponse>
      listAgentsSettings() {
    return ((AgentRegistryStubSettings) getStubSettings()).listAgentsSettings();
  }

  /** Returns the object with the settings used for calls to searchAgents. */
  public PagedCallSettings<SearchAgentsRequest, SearchAgentsResponse, SearchAgentsPagedResponse>
      searchAgentsSettings() {
    return ((AgentRegistryStubSettings) getStubSettings()).searchAgentsSettings();
  }

  /** Returns the object with the settings used for calls to getAgent. */
  public UnaryCallSettings<GetAgentRequest, Agent> getAgentSettings() {
    return ((AgentRegistryStubSettings) getStubSettings()).getAgentSettings();
  }

  /** Returns the object with the settings used for calls to listEndpoints. */
  public PagedCallSettings<ListEndpointsRequest, ListEndpointsResponse, ListEndpointsPagedResponse>
      listEndpointsSettings() {
    return ((AgentRegistryStubSettings) getStubSettings()).listEndpointsSettings();
  }

  /** Returns the object with the settings used for calls to getEndpoint. */
  public UnaryCallSettings<GetEndpointRequest, Endpoint> getEndpointSettings() {
    return ((AgentRegistryStubSettings) getStubSettings()).getEndpointSettings();
  }

  /** Returns the object with the settings used for calls to listMcpServers. */
  public PagedCallSettings<
          ListMcpServersRequest, ListMcpServersResponse, ListMcpServersPagedResponse>
      listMcpServersSettings() {
    return ((AgentRegistryStubSettings) getStubSettings()).listMcpServersSettings();
  }

  /** Returns the object with the settings used for calls to searchMcpServers. */
  public PagedCallSettings<
          SearchMcpServersRequest, SearchMcpServersResponse, SearchMcpServersPagedResponse>
      searchMcpServersSettings() {
    return ((AgentRegistryStubSettings) getStubSettings()).searchMcpServersSettings();
  }

  /** Returns the object with the settings used for calls to getMcpServer. */
  public UnaryCallSettings<GetMcpServerRequest, McpServer> getMcpServerSettings() {
    return ((AgentRegistryStubSettings) getStubSettings()).getMcpServerSettings();
  }

  /** Returns the object with the settings used for calls to listServices. */
  public PagedCallSettings<ListServicesRequest, ListServicesResponse, ListServicesPagedResponse>
      listServicesSettings() {
    return ((AgentRegistryStubSettings) getStubSettings()).listServicesSettings();
  }

  /** Returns the object with the settings used for calls to getService. */
  public UnaryCallSettings<GetServiceRequest, Service> getServiceSettings() {
    return ((AgentRegistryStubSettings) getStubSettings()).getServiceSettings();
  }

  /** Returns the object with the settings used for calls to createService. */
  public UnaryCallSettings<CreateServiceRequest, Operation> createServiceSettings() {
    return ((AgentRegistryStubSettings) getStubSettings()).createServiceSettings();
  }

  /** Returns the object with the settings used for calls to createService. */
  public OperationCallSettings<CreateServiceRequest, Service, OperationMetadata>
      createServiceOperationSettings() {
    return ((AgentRegistryStubSettings) getStubSettings()).createServiceOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateService. */
  public UnaryCallSettings<UpdateServiceRequest, Operation> updateServiceSettings() {
    return ((AgentRegistryStubSettings) getStubSettings()).updateServiceSettings();
  }

  /** Returns the object with the settings used for calls to updateService. */
  public OperationCallSettings<UpdateServiceRequest, Service, OperationMetadata>
      updateServiceOperationSettings() {
    return ((AgentRegistryStubSettings) getStubSettings()).updateServiceOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteService. */
  public UnaryCallSettings<DeleteServiceRequest, Operation> deleteServiceSettings() {
    return ((AgentRegistryStubSettings) getStubSettings()).deleteServiceSettings();
  }

  /** Returns the object with the settings used for calls to deleteService. */
  public OperationCallSettings<DeleteServiceRequest, Empty, OperationMetadata>
      deleteServiceOperationSettings() {
    return ((AgentRegistryStubSettings) getStubSettings()).deleteServiceOperationSettings();
  }

  /** Returns the object with the settings used for calls to listBindings. */
  public PagedCallSettings<ListBindingsRequest, ListBindingsResponse, ListBindingsPagedResponse>
      listBindingsSettings() {
    return ((AgentRegistryStubSettings) getStubSettings()).listBindingsSettings();
  }

  /** Returns the object with the settings used for calls to getBinding. */
  public UnaryCallSettings<GetBindingRequest, Binding> getBindingSettings() {
    return ((AgentRegistryStubSettings) getStubSettings()).getBindingSettings();
  }

  /** Returns the object with the settings used for calls to createBinding. */
  public UnaryCallSettings<CreateBindingRequest, Operation> createBindingSettings() {
    return ((AgentRegistryStubSettings) getStubSettings()).createBindingSettings();
  }

  /** Returns the object with the settings used for calls to createBinding. */
  public OperationCallSettings<CreateBindingRequest, Binding, OperationMetadata>
      createBindingOperationSettings() {
    return ((AgentRegistryStubSettings) getStubSettings()).createBindingOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateBinding. */
  public UnaryCallSettings<UpdateBindingRequest, Operation> updateBindingSettings() {
    return ((AgentRegistryStubSettings) getStubSettings()).updateBindingSettings();
  }

  /** Returns the object with the settings used for calls to updateBinding. */
  public OperationCallSettings<UpdateBindingRequest, Binding, OperationMetadata>
      updateBindingOperationSettings() {
    return ((AgentRegistryStubSettings) getStubSettings()).updateBindingOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteBinding. */
  public UnaryCallSettings<DeleteBindingRequest, Operation> deleteBindingSettings() {
    return ((AgentRegistryStubSettings) getStubSettings()).deleteBindingSettings();
  }

  /** Returns the object with the settings used for calls to deleteBinding. */
  public OperationCallSettings<DeleteBindingRequest, Empty, OperationMetadata>
      deleteBindingOperationSettings() {
    return ((AgentRegistryStubSettings) getStubSettings()).deleteBindingOperationSettings();
  }

  /** Returns the object with the settings used for calls to fetchAvailableBindings. */
  public PagedCallSettings<
          FetchAvailableBindingsRequest,
          FetchAvailableBindingsResponse,
          FetchAvailableBindingsPagedResponse>
      fetchAvailableBindingsSettings() {
    return ((AgentRegistryStubSettings) getStubSettings()).fetchAvailableBindingsSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((AgentRegistryStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((AgentRegistryStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final AgentRegistrySettings create(AgentRegistryStubSettings stub)
      throws IOException {
    return new AgentRegistrySettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return AgentRegistryStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return AgentRegistryStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return AgentRegistryStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return AgentRegistryStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return AgentRegistryStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return AgentRegistryStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return AgentRegistryStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return AgentRegistryStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected AgentRegistrySettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for AgentRegistrySettings. */
  public static class Builder extends ClientSettings.Builder<AgentRegistrySettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(AgentRegistryStubSettings.newBuilder(clientContext));
    }

    protected Builder(AgentRegistrySettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(AgentRegistryStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(AgentRegistryStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(AgentRegistryStubSettings.newHttpJsonBuilder());
    }

    public AgentRegistryStubSettings.Builder getStubSettingsBuilder() {
      return ((AgentRegistryStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listAgents. */
    public PagedCallSettings.Builder<ListAgentsRequest, ListAgentsResponse, ListAgentsPagedResponse>
        listAgentsSettings() {
      return getStubSettingsBuilder().listAgentsSettings();
    }

    /** Returns the builder for the settings used for calls to searchAgents. */
    public PagedCallSettings.Builder<
            SearchAgentsRequest, SearchAgentsResponse, SearchAgentsPagedResponse>
        searchAgentsSettings() {
      return getStubSettingsBuilder().searchAgentsSettings();
    }

    /** Returns the builder for the settings used for calls to getAgent. */
    public UnaryCallSettings.Builder<GetAgentRequest, Agent> getAgentSettings() {
      return getStubSettingsBuilder().getAgentSettings();
    }

    /** Returns the builder for the settings used for calls to listEndpoints. */
    public PagedCallSettings.Builder<
            ListEndpointsRequest, ListEndpointsResponse, ListEndpointsPagedResponse>
        listEndpointsSettings() {
      return getStubSettingsBuilder().listEndpointsSettings();
    }

    /** Returns the builder for the settings used for calls to getEndpoint. */
    public UnaryCallSettings.Builder<GetEndpointRequest, Endpoint> getEndpointSettings() {
      return getStubSettingsBuilder().getEndpointSettings();
    }

    /** Returns the builder for the settings used for calls to listMcpServers. */
    public PagedCallSettings.Builder<
            ListMcpServersRequest, ListMcpServersResponse, ListMcpServersPagedResponse>
        listMcpServersSettings() {
      return getStubSettingsBuilder().listMcpServersSettings();
    }

    /** Returns the builder for the settings used for calls to searchMcpServers. */
    public PagedCallSettings.Builder<
            SearchMcpServersRequest, SearchMcpServersResponse, SearchMcpServersPagedResponse>
        searchMcpServersSettings() {
      return getStubSettingsBuilder().searchMcpServersSettings();
    }

    /** Returns the builder for the settings used for calls to getMcpServer. */
    public UnaryCallSettings.Builder<GetMcpServerRequest, McpServer> getMcpServerSettings() {
      return getStubSettingsBuilder().getMcpServerSettings();
    }

    /** Returns the builder for the settings used for calls to listServices. */
    public PagedCallSettings.Builder<
            ListServicesRequest, ListServicesResponse, ListServicesPagedResponse>
        listServicesSettings() {
      return getStubSettingsBuilder().listServicesSettings();
    }

    /** Returns the builder for the settings used for calls to getService. */
    public UnaryCallSettings.Builder<GetServiceRequest, Service> getServiceSettings() {
      return getStubSettingsBuilder().getServiceSettings();
    }

    /** Returns the builder for the settings used for calls to createService. */
    public UnaryCallSettings.Builder<CreateServiceRequest, Operation> createServiceSettings() {
      return getStubSettingsBuilder().createServiceSettings();
    }

    /** Returns the builder for the settings used for calls to createService. */
    public OperationCallSettings.Builder<CreateServiceRequest, Service, OperationMetadata>
        createServiceOperationSettings() {
      return getStubSettingsBuilder().createServiceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateService. */
    public UnaryCallSettings.Builder<UpdateServiceRequest, Operation> updateServiceSettings() {
      return getStubSettingsBuilder().updateServiceSettings();
    }

    /** Returns the builder for the settings used for calls to updateService. */
    public OperationCallSettings.Builder<UpdateServiceRequest, Service, OperationMetadata>
        updateServiceOperationSettings() {
      return getStubSettingsBuilder().updateServiceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteService. */
    public UnaryCallSettings.Builder<DeleteServiceRequest, Operation> deleteServiceSettings() {
      return getStubSettingsBuilder().deleteServiceSettings();
    }

    /** Returns the builder for the settings used for calls to deleteService. */
    public OperationCallSettings.Builder<DeleteServiceRequest, Empty, OperationMetadata>
        deleteServiceOperationSettings() {
      return getStubSettingsBuilder().deleteServiceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listBindings. */
    public PagedCallSettings.Builder<
            ListBindingsRequest, ListBindingsResponse, ListBindingsPagedResponse>
        listBindingsSettings() {
      return getStubSettingsBuilder().listBindingsSettings();
    }

    /** Returns the builder for the settings used for calls to getBinding. */
    public UnaryCallSettings.Builder<GetBindingRequest, Binding> getBindingSettings() {
      return getStubSettingsBuilder().getBindingSettings();
    }

    /** Returns the builder for the settings used for calls to createBinding. */
    public UnaryCallSettings.Builder<CreateBindingRequest, Operation> createBindingSettings() {
      return getStubSettingsBuilder().createBindingSettings();
    }

    /** Returns the builder for the settings used for calls to createBinding. */
    public OperationCallSettings.Builder<CreateBindingRequest, Binding, OperationMetadata>
        createBindingOperationSettings() {
      return getStubSettingsBuilder().createBindingOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateBinding. */
    public UnaryCallSettings.Builder<UpdateBindingRequest, Operation> updateBindingSettings() {
      return getStubSettingsBuilder().updateBindingSettings();
    }

    /** Returns the builder for the settings used for calls to updateBinding. */
    public OperationCallSettings.Builder<UpdateBindingRequest, Binding, OperationMetadata>
        updateBindingOperationSettings() {
      return getStubSettingsBuilder().updateBindingOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteBinding. */
    public UnaryCallSettings.Builder<DeleteBindingRequest, Operation> deleteBindingSettings() {
      return getStubSettingsBuilder().deleteBindingSettings();
    }

    /** Returns the builder for the settings used for calls to deleteBinding. */
    public OperationCallSettings.Builder<DeleteBindingRequest, Empty, OperationMetadata>
        deleteBindingOperationSettings() {
      return getStubSettingsBuilder().deleteBindingOperationSettings();
    }

    /** Returns the builder for the settings used for calls to fetchAvailableBindings. */
    public PagedCallSettings.Builder<
            FetchAvailableBindingsRequest,
            FetchAvailableBindingsResponse,
            FetchAvailableBindingsPagedResponse>
        fetchAvailableBindingsSettings() {
      return getStubSettingsBuilder().fetchAvailableBindingsSettings();
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
    public AgentRegistrySettings build() throws IOException {
      return new AgentRegistrySettings(this);
    }
  }
}
