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

package com.google.cloud.ces.v1;

import static com.google.cloud.ces.v1.AgentServiceClient.ListAgentsPagedResponse;
import static com.google.cloud.ces.v1.AgentServiceClient.ListAppVersionsPagedResponse;
import static com.google.cloud.ces.v1.AgentServiceClient.ListAppsPagedResponse;
import static com.google.cloud.ces.v1.AgentServiceClient.ListChangelogsPagedResponse;
import static com.google.cloud.ces.v1.AgentServiceClient.ListConversationsPagedResponse;
import static com.google.cloud.ces.v1.AgentServiceClient.ListDeploymentsPagedResponse;
import static com.google.cloud.ces.v1.AgentServiceClient.ListExamplesPagedResponse;
import static com.google.cloud.ces.v1.AgentServiceClient.ListGuardrailsPagedResponse;
import static com.google.cloud.ces.v1.AgentServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.ces.v1.AgentServiceClient.ListToolsPagedResponse;
import static com.google.cloud.ces.v1.AgentServiceClient.ListToolsetsPagedResponse;

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
import com.google.cloud.ces.v1.stub.AgentServiceStubSettings;
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
 * Settings class to configure an instance of {@link AgentServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (ces.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getApp:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AgentServiceSettings.Builder agentServiceSettingsBuilder = AgentServiceSettings.newBuilder();
 * agentServiceSettingsBuilder
 *     .getAppSettings()
 *     .setRetrySettings(
 *         agentServiceSettingsBuilder
 *             .getAppSettings()
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
 * AgentServiceSettings agentServiceSettings = agentServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createApp:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AgentServiceSettings.Builder agentServiceSettingsBuilder = AgentServiceSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * agentServiceSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class AgentServiceSettings extends ClientSettings<AgentServiceSettings> {

  /** Returns the object with the settings used for calls to listApps. */
  public PagedCallSettings<ListAppsRequest, ListAppsResponse, ListAppsPagedResponse>
      listAppsSettings() {
    return ((AgentServiceStubSettings) getStubSettings()).listAppsSettings();
  }

  /** Returns the object with the settings used for calls to getApp. */
  public UnaryCallSettings<GetAppRequest, App> getAppSettings() {
    return ((AgentServiceStubSettings) getStubSettings()).getAppSettings();
  }

  /** Returns the object with the settings used for calls to createApp. */
  public UnaryCallSettings<CreateAppRequest, Operation> createAppSettings() {
    return ((AgentServiceStubSettings) getStubSettings()).createAppSettings();
  }

  /** Returns the object with the settings used for calls to createApp. */
  public OperationCallSettings<CreateAppRequest, App, OperationMetadata>
      createAppOperationSettings() {
    return ((AgentServiceStubSettings) getStubSettings()).createAppOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateApp. */
  public UnaryCallSettings<UpdateAppRequest, App> updateAppSettings() {
    return ((AgentServiceStubSettings) getStubSettings()).updateAppSettings();
  }

  /** Returns the object with the settings used for calls to deleteApp. */
  public UnaryCallSettings<DeleteAppRequest, Operation> deleteAppSettings() {
    return ((AgentServiceStubSettings) getStubSettings()).deleteAppSettings();
  }

  /** Returns the object with the settings used for calls to deleteApp. */
  public OperationCallSettings<DeleteAppRequest, Empty, OperationMetadata>
      deleteAppOperationSettings() {
    return ((AgentServiceStubSettings) getStubSettings()).deleteAppOperationSettings();
  }

  /** Returns the object with the settings used for calls to exportApp. */
  public UnaryCallSettings<ExportAppRequest, Operation> exportAppSettings() {
    return ((AgentServiceStubSettings) getStubSettings()).exportAppSettings();
  }

  /** Returns the object with the settings used for calls to exportApp. */
  public OperationCallSettings<ExportAppRequest, ExportAppResponse, OperationMetadata>
      exportAppOperationSettings() {
    return ((AgentServiceStubSettings) getStubSettings()).exportAppOperationSettings();
  }

  /** Returns the object with the settings used for calls to importApp. */
  public UnaryCallSettings<ImportAppRequest, Operation> importAppSettings() {
    return ((AgentServiceStubSettings) getStubSettings()).importAppSettings();
  }

  /** Returns the object with the settings used for calls to importApp. */
  public OperationCallSettings<ImportAppRequest, ImportAppResponse, OperationMetadata>
      importAppOperationSettings() {
    return ((AgentServiceStubSettings) getStubSettings()).importAppOperationSettings();
  }

  /** Returns the object with the settings used for calls to listAgents. */
  public PagedCallSettings<ListAgentsRequest, ListAgentsResponse, ListAgentsPagedResponse>
      listAgentsSettings() {
    return ((AgentServiceStubSettings) getStubSettings()).listAgentsSettings();
  }

  /** Returns the object with the settings used for calls to getAgent. */
  public UnaryCallSettings<GetAgentRequest, Agent> getAgentSettings() {
    return ((AgentServiceStubSettings) getStubSettings()).getAgentSettings();
  }

  /** Returns the object with the settings used for calls to createAgent. */
  public UnaryCallSettings<CreateAgentRequest, Agent> createAgentSettings() {
    return ((AgentServiceStubSettings) getStubSettings()).createAgentSettings();
  }

  /** Returns the object with the settings used for calls to updateAgent. */
  public UnaryCallSettings<UpdateAgentRequest, Agent> updateAgentSettings() {
    return ((AgentServiceStubSettings) getStubSettings()).updateAgentSettings();
  }

  /** Returns the object with the settings used for calls to deleteAgent. */
  public UnaryCallSettings<DeleteAgentRequest, Empty> deleteAgentSettings() {
    return ((AgentServiceStubSettings) getStubSettings()).deleteAgentSettings();
  }

  /** Returns the object with the settings used for calls to listExamples. */
  public PagedCallSettings<ListExamplesRequest, ListExamplesResponse, ListExamplesPagedResponse>
      listExamplesSettings() {
    return ((AgentServiceStubSettings) getStubSettings()).listExamplesSettings();
  }

  /** Returns the object with the settings used for calls to getExample. */
  public UnaryCallSettings<GetExampleRequest, Example> getExampleSettings() {
    return ((AgentServiceStubSettings) getStubSettings()).getExampleSettings();
  }

  /** Returns the object with the settings used for calls to createExample. */
  public UnaryCallSettings<CreateExampleRequest, Example> createExampleSettings() {
    return ((AgentServiceStubSettings) getStubSettings()).createExampleSettings();
  }

  /** Returns the object with the settings used for calls to updateExample. */
  public UnaryCallSettings<UpdateExampleRequest, Example> updateExampleSettings() {
    return ((AgentServiceStubSettings) getStubSettings()).updateExampleSettings();
  }

  /** Returns the object with the settings used for calls to deleteExample. */
  public UnaryCallSettings<DeleteExampleRequest, Empty> deleteExampleSettings() {
    return ((AgentServiceStubSettings) getStubSettings()).deleteExampleSettings();
  }

  /** Returns the object with the settings used for calls to listTools. */
  public PagedCallSettings<ListToolsRequest, ListToolsResponse, ListToolsPagedResponse>
      listToolsSettings() {
    return ((AgentServiceStubSettings) getStubSettings()).listToolsSettings();
  }

  /** Returns the object with the settings used for calls to getTool. */
  public UnaryCallSettings<GetToolRequest, Tool> getToolSettings() {
    return ((AgentServiceStubSettings) getStubSettings()).getToolSettings();
  }

  /** Returns the object with the settings used for calls to listConversations. */
  public PagedCallSettings<
          ListConversationsRequest, ListConversationsResponse, ListConversationsPagedResponse>
      listConversationsSettings() {
    return ((AgentServiceStubSettings) getStubSettings()).listConversationsSettings();
  }

  /** Returns the object with the settings used for calls to getConversation. */
  public UnaryCallSettings<GetConversationRequest, Conversation> getConversationSettings() {
    return ((AgentServiceStubSettings) getStubSettings()).getConversationSettings();
  }

  /** Returns the object with the settings used for calls to deleteConversation. */
  public UnaryCallSettings<DeleteConversationRequest, Empty> deleteConversationSettings() {
    return ((AgentServiceStubSettings) getStubSettings()).deleteConversationSettings();
  }

  /** Returns the object with the settings used for calls to batchDeleteConversations. */
  public UnaryCallSettings<BatchDeleteConversationsRequest, Operation>
      batchDeleteConversationsSettings() {
    return ((AgentServiceStubSettings) getStubSettings()).batchDeleteConversationsSettings();
  }

  /** Returns the object with the settings used for calls to batchDeleteConversations. */
  public OperationCallSettings<
          BatchDeleteConversationsRequest, BatchDeleteConversationsResponse, OperationMetadata>
      batchDeleteConversationsOperationSettings() {
    return ((AgentServiceStubSettings) getStubSettings())
        .batchDeleteConversationsOperationSettings();
  }

  /** Returns the object with the settings used for calls to createTool. */
  public UnaryCallSettings<CreateToolRequest, Tool> createToolSettings() {
    return ((AgentServiceStubSettings) getStubSettings()).createToolSettings();
  }

  /** Returns the object with the settings used for calls to updateTool. */
  public UnaryCallSettings<UpdateToolRequest, Tool> updateToolSettings() {
    return ((AgentServiceStubSettings) getStubSettings()).updateToolSettings();
  }

  /** Returns the object with the settings used for calls to deleteTool. */
  public UnaryCallSettings<DeleteToolRequest, Empty> deleteToolSettings() {
    return ((AgentServiceStubSettings) getStubSettings()).deleteToolSettings();
  }

  /** Returns the object with the settings used for calls to listGuardrails. */
  public PagedCallSettings<
          ListGuardrailsRequest, ListGuardrailsResponse, ListGuardrailsPagedResponse>
      listGuardrailsSettings() {
    return ((AgentServiceStubSettings) getStubSettings()).listGuardrailsSettings();
  }

  /** Returns the object with the settings used for calls to getGuardrail. */
  public UnaryCallSettings<GetGuardrailRequest, Guardrail> getGuardrailSettings() {
    return ((AgentServiceStubSettings) getStubSettings()).getGuardrailSettings();
  }

  /** Returns the object with the settings used for calls to createGuardrail. */
  public UnaryCallSettings<CreateGuardrailRequest, Guardrail> createGuardrailSettings() {
    return ((AgentServiceStubSettings) getStubSettings()).createGuardrailSettings();
  }

  /** Returns the object with the settings used for calls to updateGuardrail. */
  public UnaryCallSettings<UpdateGuardrailRequest, Guardrail> updateGuardrailSettings() {
    return ((AgentServiceStubSettings) getStubSettings()).updateGuardrailSettings();
  }

  /** Returns the object with the settings used for calls to deleteGuardrail. */
  public UnaryCallSettings<DeleteGuardrailRequest, Empty> deleteGuardrailSettings() {
    return ((AgentServiceStubSettings) getStubSettings()).deleteGuardrailSettings();
  }

  /** Returns the object with the settings used for calls to listDeployments. */
  public PagedCallSettings<
          ListDeploymentsRequest, ListDeploymentsResponse, ListDeploymentsPagedResponse>
      listDeploymentsSettings() {
    return ((AgentServiceStubSettings) getStubSettings()).listDeploymentsSettings();
  }

  /** Returns the object with the settings used for calls to getDeployment. */
  public UnaryCallSettings<GetDeploymentRequest, Deployment> getDeploymentSettings() {
    return ((AgentServiceStubSettings) getStubSettings()).getDeploymentSettings();
  }

  /** Returns the object with the settings used for calls to createDeployment. */
  public UnaryCallSettings<CreateDeploymentRequest, Deployment> createDeploymentSettings() {
    return ((AgentServiceStubSettings) getStubSettings()).createDeploymentSettings();
  }

  /** Returns the object with the settings used for calls to updateDeployment. */
  public UnaryCallSettings<UpdateDeploymentRequest, Deployment> updateDeploymentSettings() {
    return ((AgentServiceStubSettings) getStubSettings()).updateDeploymentSettings();
  }

  /** Returns the object with the settings used for calls to deleteDeployment. */
  public UnaryCallSettings<DeleteDeploymentRequest, Empty> deleteDeploymentSettings() {
    return ((AgentServiceStubSettings) getStubSettings()).deleteDeploymentSettings();
  }

  /** Returns the object with the settings used for calls to listToolsets. */
  public PagedCallSettings<ListToolsetsRequest, ListToolsetsResponse, ListToolsetsPagedResponse>
      listToolsetsSettings() {
    return ((AgentServiceStubSettings) getStubSettings()).listToolsetsSettings();
  }

  /** Returns the object with the settings used for calls to getToolset. */
  public UnaryCallSettings<GetToolsetRequest, Toolset> getToolsetSettings() {
    return ((AgentServiceStubSettings) getStubSettings()).getToolsetSettings();
  }

  /** Returns the object with the settings used for calls to createToolset. */
  public UnaryCallSettings<CreateToolsetRequest, Toolset> createToolsetSettings() {
    return ((AgentServiceStubSettings) getStubSettings()).createToolsetSettings();
  }

  /** Returns the object with the settings used for calls to updateToolset. */
  public UnaryCallSettings<UpdateToolsetRequest, Toolset> updateToolsetSettings() {
    return ((AgentServiceStubSettings) getStubSettings()).updateToolsetSettings();
  }

  /** Returns the object with the settings used for calls to deleteToolset. */
  public UnaryCallSettings<DeleteToolsetRequest, Empty> deleteToolsetSettings() {
    return ((AgentServiceStubSettings) getStubSettings()).deleteToolsetSettings();
  }

  /** Returns the object with the settings used for calls to listAppVersions. */
  public PagedCallSettings<
          ListAppVersionsRequest, ListAppVersionsResponse, ListAppVersionsPagedResponse>
      listAppVersionsSettings() {
    return ((AgentServiceStubSettings) getStubSettings()).listAppVersionsSettings();
  }

  /** Returns the object with the settings used for calls to getAppVersion. */
  public UnaryCallSettings<GetAppVersionRequest, AppVersion> getAppVersionSettings() {
    return ((AgentServiceStubSettings) getStubSettings()).getAppVersionSettings();
  }

  /** Returns the object with the settings used for calls to createAppVersion. */
  public UnaryCallSettings<CreateAppVersionRequest, AppVersion> createAppVersionSettings() {
    return ((AgentServiceStubSettings) getStubSettings()).createAppVersionSettings();
  }

  /** Returns the object with the settings used for calls to deleteAppVersion. */
  public UnaryCallSettings<DeleteAppVersionRequest, Empty> deleteAppVersionSettings() {
    return ((AgentServiceStubSettings) getStubSettings()).deleteAppVersionSettings();
  }

  /** Returns the object with the settings used for calls to restoreAppVersion. */
  public UnaryCallSettings<RestoreAppVersionRequest, Operation> restoreAppVersionSettings() {
    return ((AgentServiceStubSettings) getStubSettings()).restoreAppVersionSettings();
  }

  /** Returns the object with the settings used for calls to restoreAppVersion. */
  public OperationCallSettings<
          RestoreAppVersionRequest, RestoreAppVersionResponse, OperationMetadata>
      restoreAppVersionOperationSettings() {
    return ((AgentServiceStubSettings) getStubSettings()).restoreAppVersionOperationSettings();
  }

  /** Returns the object with the settings used for calls to listChangelogs. */
  public PagedCallSettings<
          ListChangelogsRequest, ListChangelogsResponse, ListChangelogsPagedResponse>
      listChangelogsSettings() {
    return ((AgentServiceStubSettings) getStubSettings()).listChangelogsSettings();
  }

  /** Returns the object with the settings used for calls to getChangelog. */
  public UnaryCallSettings<GetChangelogRequest, Changelog> getChangelogSettings() {
    return ((AgentServiceStubSettings) getStubSettings()).getChangelogSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((AgentServiceStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((AgentServiceStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final AgentServiceSettings create(AgentServiceStubSettings stub)
      throws IOException {
    return new AgentServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return AgentServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return AgentServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return AgentServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return AgentServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return AgentServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return AgentServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return AgentServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return AgentServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected AgentServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for AgentServiceSettings. */
  public static class Builder extends ClientSettings.Builder<AgentServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(AgentServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(AgentServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(AgentServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(AgentServiceStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(AgentServiceStubSettings.newHttpJsonBuilder());
    }

    public AgentServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((AgentServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listApps. */
    public PagedCallSettings.Builder<ListAppsRequest, ListAppsResponse, ListAppsPagedResponse>
        listAppsSettings() {
      return getStubSettingsBuilder().listAppsSettings();
    }

    /** Returns the builder for the settings used for calls to getApp. */
    public UnaryCallSettings.Builder<GetAppRequest, App> getAppSettings() {
      return getStubSettingsBuilder().getAppSettings();
    }

    /** Returns the builder for the settings used for calls to createApp. */
    public UnaryCallSettings.Builder<CreateAppRequest, Operation> createAppSettings() {
      return getStubSettingsBuilder().createAppSettings();
    }

    /** Returns the builder for the settings used for calls to createApp. */
    public OperationCallSettings.Builder<CreateAppRequest, App, OperationMetadata>
        createAppOperationSettings() {
      return getStubSettingsBuilder().createAppOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateApp. */
    public UnaryCallSettings.Builder<UpdateAppRequest, App> updateAppSettings() {
      return getStubSettingsBuilder().updateAppSettings();
    }

    /** Returns the builder for the settings used for calls to deleteApp. */
    public UnaryCallSettings.Builder<DeleteAppRequest, Operation> deleteAppSettings() {
      return getStubSettingsBuilder().deleteAppSettings();
    }

    /** Returns the builder for the settings used for calls to deleteApp. */
    public OperationCallSettings.Builder<DeleteAppRequest, Empty, OperationMetadata>
        deleteAppOperationSettings() {
      return getStubSettingsBuilder().deleteAppOperationSettings();
    }

    /** Returns the builder for the settings used for calls to exportApp. */
    public UnaryCallSettings.Builder<ExportAppRequest, Operation> exportAppSettings() {
      return getStubSettingsBuilder().exportAppSettings();
    }

    /** Returns the builder for the settings used for calls to exportApp. */
    public OperationCallSettings.Builder<ExportAppRequest, ExportAppResponse, OperationMetadata>
        exportAppOperationSettings() {
      return getStubSettingsBuilder().exportAppOperationSettings();
    }

    /** Returns the builder for the settings used for calls to importApp. */
    public UnaryCallSettings.Builder<ImportAppRequest, Operation> importAppSettings() {
      return getStubSettingsBuilder().importAppSettings();
    }

    /** Returns the builder for the settings used for calls to importApp. */
    public OperationCallSettings.Builder<ImportAppRequest, ImportAppResponse, OperationMetadata>
        importAppOperationSettings() {
      return getStubSettingsBuilder().importAppOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listAgents. */
    public PagedCallSettings.Builder<ListAgentsRequest, ListAgentsResponse, ListAgentsPagedResponse>
        listAgentsSettings() {
      return getStubSettingsBuilder().listAgentsSettings();
    }

    /** Returns the builder for the settings used for calls to getAgent. */
    public UnaryCallSettings.Builder<GetAgentRequest, Agent> getAgentSettings() {
      return getStubSettingsBuilder().getAgentSettings();
    }

    /** Returns the builder for the settings used for calls to createAgent. */
    public UnaryCallSettings.Builder<CreateAgentRequest, Agent> createAgentSettings() {
      return getStubSettingsBuilder().createAgentSettings();
    }

    /** Returns the builder for the settings used for calls to updateAgent. */
    public UnaryCallSettings.Builder<UpdateAgentRequest, Agent> updateAgentSettings() {
      return getStubSettingsBuilder().updateAgentSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAgent. */
    public UnaryCallSettings.Builder<DeleteAgentRequest, Empty> deleteAgentSettings() {
      return getStubSettingsBuilder().deleteAgentSettings();
    }

    /** Returns the builder for the settings used for calls to listExamples. */
    public PagedCallSettings.Builder<
            ListExamplesRequest, ListExamplesResponse, ListExamplesPagedResponse>
        listExamplesSettings() {
      return getStubSettingsBuilder().listExamplesSettings();
    }

    /** Returns the builder for the settings used for calls to getExample. */
    public UnaryCallSettings.Builder<GetExampleRequest, Example> getExampleSettings() {
      return getStubSettingsBuilder().getExampleSettings();
    }

    /** Returns the builder for the settings used for calls to createExample. */
    public UnaryCallSettings.Builder<CreateExampleRequest, Example> createExampleSettings() {
      return getStubSettingsBuilder().createExampleSettings();
    }

    /** Returns the builder for the settings used for calls to updateExample. */
    public UnaryCallSettings.Builder<UpdateExampleRequest, Example> updateExampleSettings() {
      return getStubSettingsBuilder().updateExampleSettings();
    }

    /** Returns the builder for the settings used for calls to deleteExample. */
    public UnaryCallSettings.Builder<DeleteExampleRequest, Empty> deleteExampleSettings() {
      return getStubSettingsBuilder().deleteExampleSettings();
    }

    /** Returns the builder for the settings used for calls to listTools. */
    public PagedCallSettings.Builder<ListToolsRequest, ListToolsResponse, ListToolsPagedResponse>
        listToolsSettings() {
      return getStubSettingsBuilder().listToolsSettings();
    }

    /** Returns the builder for the settings used for calls to getTool. */
    public UnaryCallSettings.Builder<GetToolRequest, Tool> getToolSettings() {
      return getStubSettingsBuilder().getToolSettings();
    }

    /** Returns the builder for the settings used for calls to listConversations. */
    public PagedCallSettings.Builder<
            ListConversationsRequest, ListConversationsResponse, ListConversationsPagedResponse>
        listConversationsSettings() {
      return getStubSettingsBuilder().listConversationsSettings();
    }

    /** Returns the builder for the settings used for calls to getConversation. */
    public UnaryCallSettings.Builder<GetConversationRequest, Conversation>
        getConversationSettings() {
      return getStubSettingsBuilder().getConversationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteConversation. */
    public UnaryCallSettings.Builder<DeleteConversationRequest, Empty>
        deleteConversationSettings() {
      return getStubSettingsBuilder().deleteConversationSettings();
    }

    /** Returns the builder for the settings used for calls to batchDeleteConversations. */
    public UnaryCallSettings.Builder<BatchDeleteConversationsRequest, Operation>
        batchDeleteConversationsSettings() {
      return getStubSettingsBuilder().batchDeleteConversationsSettings();
    }

    /** Returns the builder for the settings used for calls to batchDeleteConversations. */
    public OperationCallSettings.Builder<
            BatchDeleteConversationsRequest, BatchDeleteConversationsResponse, OperationMetadata>
        batchDeleteConversationsOperationSettings() {
      return getStubSettingsBuilder().batchDeleteConversationsOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createTool. */
    public UnaryCallSettings.Builder<CreateToolRequest, Tool> createToolSettings() {
      return getStubSettingsBuilder().createToolSettings();
    }

    /** Returns the builder for the settings used for calls to updateTool. */
    public UnaryCallSettings.Builder<UpdateToolRequest, Tool> updateToolSettings() {
      return getStubSettingsBuilder().updateToolSettings();
    }

    /** Returns the builder for the settings used for calls to deleteTool. */
    public UnaryCallSettings.Builder<DeleteToolRequest, Empty> deleteToolSettings() {
      return getStubSettingsBuilder().deleteToolSettings();
    }

    /** Returns the builder for the settings used for calls to listGuardrails. */
    public PagedCallSettings.Builder<
            ListGuardrailsRequest, ListGuardrailsResponse, ListGuardrailsPagedResponse>
        listGuardrailsSettings() {
      return getStubSettingsBuilder().listGuardrailsSettings();
    }

    /** Returns the builder for the settings used for calls to getGuardrail. */
    public UnaryCallSettings.Builder<GetGuardrailRequest, Guardrail> getGuardrailSettings() {
      return getStubSettingsBuilder().getGuardrailSettings();
    }

    /** Returns the builder for the settings used for calls to createGuardrail. */
    public UnaryCallSettings.Builder<CreateGuardrailRequest, Guardrail> createGuardrailSettings() {
      return getStubSettingsBuilder().createGuardrailSettings();
    }

    /** Returns the builder for the settings used for calls to updateGuardrail. */
    public UnaryCallSettings.Builder<UpdateGuardrailRequest, Guardrail> updateGuardrailSettings() {
      return getStubSettingsBuilder().updateGuardrailSettings();
    }

    /** Returns the builder for the settings used for calls to deleteGuardrail. */
    public UnaryCallSettings.Builder<DeleteGuardrailRequest, Empty> deleteGuardrailSettings() {
      return getStubSettingsBuilder().deleteGuardrailSettings();
    }

    /** Returns the builder for the settings used for calls to listDeployments. */
    public PagedCallSettings.Builder<
            ListDeploymentsRequest, ListDeploymentsResponse, ListDeploymentsPagedResponse>
        listDeploymentsSettings() {
      return getStubSettingsBuilder().listDeploymentsSettings();
    }

    /** Returns the builder for the settings used for calls to getDeployment. */
    public UnaryCallSettings.Builder<GetDeploymentRequest, Deployment> getDeploymentSettings() {
      return getStubSettingsBuilder().getDeploymentSettings();
    }

    /** Returns the builder for the settings used for calls to createDeployment. */
    public UnaryCallSettings.Builder<CreateDeploymentRequest, Deployment>
        createDeploymentSettings() {
      return getStubSettingsBuilder().createDeploymentSettings();
    }

    /** Returns the builder for the settings used for calls to updateDeployment. */
    public UnaryCallSettings.Builder<UpdateDeploymentRequest, Deployment>
        updateDeploymentSettings() {
      return getStubSettingsBuilder().updateDeploymentSettings();
    }

    /** Returns the builder for the settings used for calls to deleteDeployment. */
    public UnaryCallSettings.Builder<DeleteDeploymentRequest, Empty> deleteDeploymentSettings() {
      return getStubSettingsBuilder().deleteDeploymentSettings();
    }

    /** Returns the builder for the settings used for calls to listToolsets. */
    public PagedCallSettings.Builder<
            ListToolsetsRequest, ListToolsetsResponse, ListToolsetsPagedResponse>
        listToolsetsSettings() {
      return getStubSettingsBuilder().listToolsetsSettings();
    }

    /** Returns the builder for the settings used for calls to getToolset. */
    public UnaryCallSettings.Builder<GetToolsetRequest, Toolset> getToolsetSettings() {
      return getStubSettingsBuilder().getToolsetSettings();
    }

    /** Returns the builder for the settings used for calls to createToolset. */
    public UnaryCallSettings.Builder<CreateToolsetRequest, Toolset> createToolsetSettings() {
      return getStubSettingsBuilder().createToolsetSettings();
    }

    /** Returns the builder for the settings used for calls to updateToolset. */
    public UnaryCallSettings.Builder<UpdateToolsetRequest, Toolset> updateToolsetSettings() {
      return getStubSettingsBuilder().updateToolsetSettings();
    }

    /** Returns the builder for the settings used for calls to deleteToolset. */
    public UnaryCallSettings.Builder<DeleteToolsetRequest, Empty> deleteToolsetSettings() {
      return getStubSettingsBuilder().deleteToolsetSettings();
    }

    /** Returns the builder for the settings used for calls to listAppVersions. */
    public PagedCallSettings.Builder<
            ListAppVersionsRequest, ListAppVersionsResponse, ListAppVersionsPagedResponse>
        listAppVersionsSettings() {
      return getStubSettingsBuilder().listAppVersionsSettings();
    }

    /** Returns the builder for the settings used for calls to getAppVersion. */
    public UnaryCallSettings.Builder<GetAppVersionRequest, AppVersion> getAppVersionSettings() {
      return getStubSettingsBuilder().getAppVersionSettings();
    }

    /** Returns the builder for the settings used for calls to createAppVersion. */
    public UnaryCallSettings.Builder<CreateAppVersionRequest, AppVersion>
        createAppVersionSettings() {
      return getStubSettingsBuilder().createAppVersionSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAppVersion. */
    public UnaryCallSettings.Builder<DeleteAppVersionRequest, Empty> deleteAppVersionSettings() {
      return getStubSettingsBuilder().deleteAppVersionSettings();
    }

    /** Returns the builder for the settings used for calls to restoreAppVersion. */
    public UnaryCallSettings.Builder<RestoreAppVersionRequest, Operation>
        restoreAppVersionSettings() {
      return getStubSettingsBuilder().restoreAppVersionSettings();
    }

    /** Returns the builder for the settings used for calls to restoreAppVersion. */
    public OperationCallSettings.Builder<
            RestoreAppVersionRequest, RestoreAppVersionResponse, OperationMetadata>
        restoreAppVersionOperationSettings() {
      return getStubSettingsBuilder().restoreAppVersionOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listChangelogs. */
    public PagedCallSettings.Builder<
            ListChangelogsRequest, ListChangelogsResponse, ListChangelogsPagedResponse>
        listChangelogsSettings() {
      return getStubSettingsBuilder().listChangelogsSettings();
    }

    /** Returns the builder for the settings used for calls to getChangelog. */
    public UnaryCallSettings.Builder<GetChangelogRequest, Changelog> getChangelogSettings() {
      return getStubSettingsBuilder().getChangelogSettings();
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
    public AgentServiceSettings build() throws IOException {
      return new AgentServiceSettings(this);
    }
  }
}
