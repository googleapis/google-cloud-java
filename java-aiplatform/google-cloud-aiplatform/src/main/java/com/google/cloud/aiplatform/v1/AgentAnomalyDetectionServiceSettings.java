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

package com.google.cloud.aiplatform.v1;

import static com.google.cloud.aiplatform.v1.AgentAnomalyDetectionServiceClient.AggregateAnalyzedSessionsPagedResponse;
import static com.google.cloud.aiplatform.v1.AgentAnomalyDetectionServiceClient.ListAgentAnomalyDetectionScopesPagedResponse;
import static com.google.cloud.aiplatform.v1.AgentAnomalyDetectionServiceClient.ListAnalyzedInvocationsPagedResponse;
import static com.google.cloud.aiplatform.v1.AgentAnomalyDetectionServiceClient.ListAnalyzedSessionsPagedResponse;
import static com.google.cloud.aiplatform.v1.AgentAnomalyDetectionServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1.AgentAnomalyDetectionServiceClient.ListMonitoredAgentsPagedResponse;

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
import com.google.cloud.aiplatform.v1.stub.AgentAnomalyDetectionServiceStubSettings;
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
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link AgentAnomalyDetectionServiceClient}.
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
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getAgentAnomalyDetectionScope:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AgentAnomalyDetectionServiceSettings.Builder agentAnomalyDetectionServiceSettingsBuilder =
 *     AgentAnomalyDetectionServiceSettings.newBuilder();
 * agentAnomalyDetectionServiceSettingsBuilder
 *     .getAgentAnomalyDetectionScopeSettings()
 *     .setRetrySettings(
 *         agentAnomalyDetectionServiceSettingsBuilder
 *             .getAgentAnomalyDetectionScopeSettings()
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
 * AgentAnomalyDetectionServiceSettings agentAnomalyDetectionServiceSettings =
 *     agentAnomalyDetectionServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for enableMonitoredAgent:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AgentAnomalyDetectionServiceSettings.Builder agentAnomalyDetectionServiceSettingsBuilder =
 *     AgentAnomalyDetectionServiceSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * agentAnomalyDetectionServiceSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@NullMarked
@Generated("by gapic-generator-java")
public class AgentAnomalyDetectionServiceSettings
    extends ClientSettings<AgentAnomalyDetectionServiceSettings> {

  /** Returns the object with the settings used for calls to getAgentAnomalyDetectionScope. */
  public UnaryCallSettings<GetAgentAnomalyDetectionScopeRequest, AgentAnomalyDetectionScope>
      getAgentAnomalyDetectionScopeSettings() {
    return ((AgentAnomalyDetectionServiceStubSettings) getStubSettings())
        .getAgentAnomalyDetectionScopeSettings();
  }

  /** Returns the object with the settings used for calls to getMonitoredAgent. */
  public UnaryCallSettings<GetMonitoredAgentRequest, MonitoredAgent> getMonitoredAgentSettings() {
    return ((AgentAnomalyDetectionServiceStubSettings) getStubSettings())
        .getMonitoredAgentSettings();
  }

  /** Returns the object with the settings used for calls to listMonitoredAgents. */
  public PagedCallSettings<
          ListMonitoredAgentsRequest, ListMonitoredAgentsResponse, ListMonitoredAgentsPagedResponse>
      listMonitoredAgentsSettings() {
    return ((AgentAnomalyDetectionServiceStubSettings) getStubSettings())
        .listMonitoredAgentsSettings();
  }

  /** Returns the object with the settings used for calls to enableMonitoredAgent. */
  public UnaryCallSettings<EnableMonitoredAgentRequest, Operation> enableMonitoredAgentSettings() {
    return ((AgentAnomalyDetectionServiceStubSettings) getStubSettings())
        .enableMonitoredAgentSettings();
  }

  /** Returns the object with the settings used for calls to enableMonitoredAgent. */
  public OperationCallSettings<
          EnableMonitoredAgentRequest, MonitoredAgent, EnableMonitoredAgentOperationMetadata>
      enableMonitoredAgentOperationSettings() {
    return ((AgentAnomalyDetectionServiceStubSettings) getStubSettings())
        .enableMonitoredAgentOperationSettings();
  }

  /** Returns the object with the settings used for calls to disableMonitoredAgent. */
  public UnaryCallSettings<DisableMonitoredAgentRequest, Operation>
      disableMonitoredAgentSettings() {
    return ((AgentAnomalyDetectionServiceStubSettings) getStubSettings())
        .disableMonitoredAgentSettings();
  }

  /** Returns the object with the settings used for calls to disableMonitoredAgent. */
  public OperationCallSettings<
          DisableMonitoredAgentRequest, MonitoredAgent, DisableMonitoredAgentOperationMetadata>
      disableMonitoredAgentOperationSettings() {
    return ((AgentAnomalyDetectionServiceStubSettings) getStubSettings())
        .disableMonitoredAgentOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteAgentAnomalyDetectionScope. */
  public UnaryCallSettings<DeleteAgentAnomalyDetectionScopeRequest, Operation>
      deleteAgentAnomalyDetectionScopeSettings() {
    return ((AgentAnomalyDetectionServiceStubSettings) getStubSettings())
        .deleteAgentAnomalyDetectionScopeSettings();
  }

  /** Returns the object with the settings used for calls to deleteAgentAnomalyDetectionScope. */
  public OperationCallSettings<
          DeleteAgentAnomalyDetectionScopeRequest,
          Empty,
          DeleteAgentAnomalyDetectionScopeOperationMetadata>
      deleteAgentAnomalyDetectionScopeOperationSettings() {
    return ((AgentAnomalyDetectionServiceStubSettings) getStubSettings())
        .deleteAgentAnomalyDetectionScopeOperationSettings();
  }

  /** Returns the object with the settings used for calls to createAgentAnomalyDetectionScope. */
  public UnaryCallSettings<CreateAgentAnomalyDetectionScopeRequest, Operation>
      createAgentAnomalyDetectionScopeSettings() {
    return ((AgentAnomalyDetectionServiceStubSettings) getStubSettings())
        .createAgentAnomalyDetectionScopeSettings();
  }

  /** Returns the object with the settings used for calls to createAgentAnomalyDetectionScope. */
  public OperationCallSettings<
          CreateAgentAnomalyDetectionScopeRequest,
          AgentAnomalyDetectionScope,
          CreateAgentAnomalyDetectionScopeOperationMetadata>
      createAgentAnomalyDetectionScopeOperationSettings() {
    return ((AgentAnomalyDetectionServiceStubSettings) getStubSettings())
        .createAgentAnomalyDetectionScopeOperationSettings();
  }

  /** Returns the object with the settings used for calls to listAgentAnomalyDetectionScopes. */
  public PagedCallSettings<
          ListAgentAnomalyDetectionScopesRequest,
          ListAgentAnomalyDetectionScopesResponse,
          ListAgentAnomalyDetectionScopesPagedResponse>
      listAgentAnomalyDetectionScopesSettings() {
    return ((AgentAnomalyDetectionServiceStubSettings) getStubSettings())
        .listAgentAnomalyDetectionScopesSettings();
  }

  /** Returns the object with the settings used for calls to listAnalyzedSessions. */
  public PagedCallSettings<
          ListAnalyzedSessionsRequest,
          ListAnalyzedSessionsResponse,
          ListAnalyzedSessionsPagedResponse>
      listAnalyzedSessionsSettings() {
    return ((AgentAnomalyDetectionServiceStubSettings) getStubSettings())
        .listAnalyzedSessionsSettings();
  }

  /** Returns the object with the settings used for calls to getAnalyzedSession. */
  public UnaryCallSettings<GetAnalyzedSessionRequest, AnalyzedSession>
      getAnalyzedSessionSettings() {
    return ((AgentAnomalyDetectionServiceStubSettings) getStubSettings())
        .getAnalyzedSessionSettings();
  }

  /** Returns the object with the settings used for calls to listAnalyzedInvocations. */
  public PagedCallSettings<
          ListAnalyzedInvocationsRequest,
          ListAnalyzedInvocationsResponse,
          ListAnalyzedInvocationsPagedResponse>
      listAnalyzedInvocationsSettings() {
    return ((AgentAnomalyDetectionServiceStubSettings) getStubSettings())
        .listAnalyzedInvocationsSettings();
  }

  /** Returns the object with the settings used for calls to getAnalyzedInvocation. */
  public UnaryCallSettings<GetAnalyzedInvocationRequest, AnalyzedInvocation>
      getAnalyzedInvocationSettings() {
    return ((AgentAnomalyDetectionServiceStubSettings) getStubSettings())
        .getAnalyzedInvocationSettings();
  }

  /** Returns the object with the settings used for calls to aggregateAnalyzedSessions. */
  public PagedCallSettings<
          AggregateAnalyzedSessionsRequest,
          AggregateAnalyzedSessionsResponse,
          AggregateAnalyzedSessionsPagedResponse>
      aggregateAnalyzedSessionsSettings() {
    return ((AgentAnomalyDetectionServiceStubSettings) getStubSettings())
        .aggregateAnalyzedSessionsSettings();
  }

  /** Returns the object with the settings used for calls to clearTrainingData. */
  public UnaryCallSettings<ClearTrainingDataRequest, Operation> clearTrainingDataSettings() {
    return ((AgentAnomalyDetectionServiceStubSettings) getStubSettings())
        .clearTrainingDataSettings();
  }

  /** Returns the object with the settings used for calls to clearTrainingData. */
  public OperationCallSettings<
          ClearTrainingDataRequest, ClearTrainingDataResponse, ClearTrainingDataOperationMetadata>
      clearTrainingDataOperationSettings() {
    return ((AgentAnomalyDetectionServiceStubSettings) getStubSettings())
        .clearTrainingDataOperationSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((AgentAnomalyDetectionServiceStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((AgentAnomalyDetectionServiceStubSettings) getStubSettings()).getLocationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((AgentAnomalyDetectionServiceStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((AgentAnomalyDetectionServiceStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((AgentAnomalyDetectionServiceStubSettings) getStubSettings())
        .testIamPermissionsSettings();
  }

  public static final AgentAnomalyDetectionServiceSettings create(
      AgentAnomalyDetectionServiceStubSettings stub) throws IOException {
    return new AgentAnomalyDetectionServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return AgentAnomalyDetectionServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return AgentAnomalyDetectionServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return AgentAnomalyDetectionServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return AgentAnomalyDetectionServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return AgentAnomalyDetectionServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return AgentAnomalyDetectionServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return AgentAnomalyDetectionServiceStubSettings.defaultApiClientHeaderProviderBuilder();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(@Nullable ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected AgentAnomalyDetectionServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for AgentAnomalyDetectionServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<AgentAnomalyDetectionServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(@Nullable ClientContext clientContext) {
      super(AgentAnomalyDetectionServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(AgentAnomalyDetectionServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(AgentAnomalyDetectionServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(AgentAnomalyDetectionServiceStubSettings.newBuilder());
    }

    public AgentAnomalyDetectionServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((AgentAnomalyDetectionServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to getAgentAnomalyDetectionScope. */
    public UnaryCallSettings.Builder<
            GetAgentAnomalyDetectionScopeRequest, AgentAnomalyDetectionScope>
        getAgentAnomalyDetectionScopeSettings() {
      return getStubSettingsBuilder().getAgentAnomalyDetectionScopeSettings();
    }

    /** Returns the builder for the settings used for calls to getMonitoredAgent. */
    public UnaryCallSettings.Builder<GetMonitoredAgentRequest, MonitoredAgent>
        getMonitoredAgentSettings() {
      return getStubSettingsBuilder().getMonitoredAgentSettings();
    }

    /** Returns the builder for the settings used for calls to listMonitoredAgents. */
    public PagedCallSettings.Builder<
            ListMonitoredAgentsRequest,
            ListMonitoredAgentsResponse,
            ListMonitoredAgentsPagedResponse>
        listMonitoredAgentsSettings() {
      return getStubSettingsBuilder().listMonitoredAgentsSettings();
    }

    /** Returns the builder for the settings used for calls to enableMonitoredAgent. */
    public UnaryCallSettings.Builder<EnableMonitoredAgentRequest, Operation>
        enableMonitoredAgentSettings() {
      return getStubSettingsBuilder().enableMonitoredAgentSettings();
    }

    /** Returns the builder for the settings used for calls to enableMonitoredAgent. */
    public OperationCallSettings.Builder<
            EnableMonitoredAgentRequest, MonitoredAgent, EnableMonitoredAgentOperationMetadata>
        enableMonitoredAgentOperationSettings() {
      return getStubSettingsBuilder().enableMonitoredAgentOperationSettings();
    }

    /** Returns the builder for the settings used for calls to disableMonitoredAgent. */
    public UnaryCallSettings.Builder<DisableMonitoredAgentRequest, Operation>
        disableMonitoredAgentSettings() {
      return getStubSettingsBuilder().disableMonitoredAgentSettings();
    }

    /** Returns the builder for the settings used for calls to disableMonitoredAgent. */
    public OperationCallSettings.Builder<
            DisableMonitoredAgentRequest, MonitoredAgent, DisableMonitoredAgentOperationMetadata>
        disableMonitoredAgentOperationSettings() {
      return getStubSettingsBuilder().disableMonitoredAgentOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAgentAnomalyDetectionScope. */
    public UnaryCallSettings.Builder<DeleteAgentAnomalyDetectionScopeRequest, Operation>
        deleteAgentAnomalyDetectionScopeSettings() {
      return getStubSettingsBuilder().deleteAgentAnomalyDetectionScopeSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAgentAnomalyDetectionScope. */
    public OperationCallSettings.Builder<
            DeleteAgentAnomalyDetectionScopeRequest,
            Empty,
            DeleteAgentAnomalyDetectionScopeOperationMetadata>
        deleteAgentAnomalyDetectionScopeOperationSettings() {
      return getStubSettingsBuilder().deleteAgentAnomalyDetectionScopeOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createAgentAnomalyDetectionScope. */
    public UnaryCallSettings.Builder<CreateAgentAnomalyDetectionScopeRequest, Operation>
        createAgentAnomalyDetectionScopeSettings() {
      return getStubSettingsBuilder().createAgentAnomalyDetectionScopeSettings();
    }

    /** Returns the builder for the settings used for calls to createAgentAnomalyDetectionScope. */
    public OperationCallSettings.Builder<
            CreateAgentAnomalyDetectionScopeRequest,
            AgentAnomalyDetectionScope,
            CreateAgentAnomalyDetectionScopeOperationMetadata>
        createAgentAnomalyDetectionScopeOperationSettings() {
      return getStubSettingsBuilder().createAgentAnomalyDetectionScopeOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listAgentAnomalyDetectionScopes. */
    public PagedCallSettings.Builder<
            ListAgentAnomalyDetectionScopesRequest,
            ListAgentAnomalyDetectionScopesResponse,
            ListAgentAnomalyDetectionScopesPagedResponse>
        listAgentAnomalyDetectionScopesSettings() {
      return getStubSettingsBuilder().listAgentAnomalyDetectionScopesSettings();
    }

    /** Returns the builder for the settings used for calls to listAnalyzedSessions. */
    public PagedCallSettings.Builder<
            ListAnalyzedSessionsRequest,
            ListAnalyzedSessionsResponse,
            ListAnalyzedSessionsPagedResponse>
        listAnalyzedSessionsSettings() {
      return getStubSettingsBuilder().listAnalyzedSessionsSettings();
    }

    /** Returns the builder for the settings used for calls to getAnalyzedSession. */
    public UnaryCallSettings.Builder<GetAnalyzedSessionRequest, AnalyzedSession>
        getAnalyzedSessionSettings() {
      return getStubSettingsBuilder().getAnalyzedSessionSettings();
    }

    /** Returns the builder for the settings used for calls to listAnalyzedInvocations. */
    public PagedCallSettings.Builder<
            ListAnalyzedInvocationsRequest,
            ListAnalyzedInvocationsResponse,
            ListAnalyzedInvocationsPagedResponse>
        listAnalyzedInvocationsSettings() {
      return getStubSettingsBuilder().listAnalyzedInvocationsSettings();
    }

    /** Returns the builder for the settings used for calls to getAnalyzedInvocation. */
    public UnaryCallSettings.Builder<GetAnalyzedInvocationRequest, AnalyzedInvocation>
        getAnalyzedInvocationSettings() {
      return getStubSettingsBuilder().getAnalyzedInvocationSettings();
    }

    /** Returns the builder for the settings used for calls to aggregateAnalyzedSessions. */
    public PagedCallSettings.Builder<
            AggregateAnalyzedSessionsRequest,
            AggregateAnalyzedSessionsResponse,
            AggregateAnalyzedSessionsPagedResponse>
        aggregateAnalyzedSessionsSettings() {
      return getStubSettingsBuilder().aggregateAnalyzedSessionsSettings();
    }

    /** Returns the builder for the settings used for calls to clearTrainingData. */
    public UnaryCallSettings.Builder<ClearTrainingDataRequest, Operation>
        clearTrainingDataSettings() {
      return getStubSettingsBuilder().clearTrainingDataSettings();
    }

    /** Returns the builder for the settings used for calls to clearTrainingData. */
    public OperationCallSettings.Builder<
            ClearTrainingDataRequest, ClearTrainingDataResponse, ClearTrainingDataOperationMetadata>
        clearTrainingDataOperationSettings() {
      return getStubSettingsBuilder().clearTrainingDataOperationSettings();
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
    public AgentAnomalyDetectionServiceSettings build() throws IOException {
      return new AgentAnomalyDetectionServiceSettings(this);
    }
  }
}
