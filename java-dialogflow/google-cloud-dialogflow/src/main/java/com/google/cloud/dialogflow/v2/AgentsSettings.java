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

package com.google.cloud.dialogflow.v2;

import static com.google.cloud.dialogflow.v2.AgentsClient.ListLocationsPagedResponse;
import static com.google.cloud.dialogflow.v2.AgentsClient.SearchAgentsPagedResponse;

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
import com.google.cloud.dialogflow.v2.stub.AgentsStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.Struct;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link AgentsClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (dialogflow.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getAgent to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AgentsSettings.Builder agentsSettingsBuilder = AgentsSettings.newBuilder();
 * agentsSettingsBuilder
 *     .getAgentSettings()
 *     .setRetrySettings(
 *         agentsSettingsBuilder.getAgentSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * AgentsSettings agentsSettings = agentsSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class AgentsSettings extends ClientSettings<AgentsSettings> {

  /** Returns the object with the settings used for calls to getAgent. */
  public UnaryCallSettings<GetAgentRequest, Agent> getAgentSettings() {
    return ((AgentsStubSettings) getStubSettings()).getAgentSettings();
  }

  /** Returns the object with the settings used for calls to setAgent. */
  public UnaryCallSettings<SetAgentRequest, Agent> setAgentSettings() {
    return ((AgentsStubSettings) getStubSettings()).setAgentSettings();
  }

  /** Returns the object with the settings used for calls to deleteAgent. */
  public UnaryCallSettings<DeleteAgentRequest, Empty> deleteAgentSettings() {
    return ((AgentsStubSettings) getStubSettings()).deleteAgentSettings();
  }

  /** Returns the object with the settings used for calls to searchAgents. */
  public PagedCallSettings<SearchAgentsRequest, SearchAgentsResponse, SearchAgentsPagedResponse>
      searchAgentsSettings() {
    return ((AgentsStubSettings) getStubSettings()).searchAgentsSettings();
  }

  /** Returns the object with the settings used for calls to trainAgent. */
  public UnaryCallSettings<TrainAgentRequest, Operation> trainAgentSettings() {
    return ((AgentsStubSettings) getStubSettings()).trainAgentSettings();
  }

  /** Returns the object with the settings used for calls to trainAgent. */
  public OperationCallSettings<TrainAgentRequest, Empty, Struct> trainAgentOperationSettings() {
    return ((AgentsStubSettings) getStubSettings()).trainAgentOperationSettings();
  }

  /** Returns the object with the settings used for calls to exportAgent. */
  public UnaryCallSettings<ExportAgentRequest, Operation> exportAgentSettings() {
    return ((AgentsStubSettings) getStubSettings()).exportAgentSettings();
  }

  /** Returns the object with the settings used for calls to exportAgent. */
  public OperationCallSettings<ExportAgentRequest, ExportAgentResponse, Struct>
      exportAgentOperationSettings() {
    return ((AgentsStubSettings) getStubSettings()).exportAgentOperationSettings();
  }

  /** Returns the object with the settings used for calls to importAgent. */
  public UnaryCallSettings<ImportAgentRequest, Operation> importAgentSettings() {
    return ((AgentsStubSettings) getStubSettings()).importAgentSettings();
  }

  /** Returns the object with the settings used for calls to importAgent. */
  public OperationCallSettings<ImportAgentRequest, Empty, Struct> importAgentOperationSettings() {
    return ((AgentsStubSettings) getStubSettings()).importAgentOperationSettings();
  }

  /** Returns the object with the settings used for calls to restoreAgent. */
  public UnaryCallSettings<RestoreAgentRequest, Operation> restoreAgentSettings() {
    return ((AgentsStubSettings) getStubSettings()).restoreAgentSettings();
  }

  /** Returns the object with the settings used for calls to restoreAgent. */
  public OperationCallSettings<RestoreAgentRequest, Empty, Struct> restoreAgentOperationSettings() {
    return ((AgentsStubSettings) getStubSettings()).restoreAgentOperationSettings();
  }

  /** Returns the object with the settings used for calls to getValidationResult. */
  public UnaryCallSettings<GetValidationResultRequest, ValidationResult>
      getValidationResultSettings() {
    return ((AgentsStubSettings) getStubSettings()).getValidationResultSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((AgentsStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((AgentsStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final AgentsSettings create(AgentsStubSettings stub) throws IOException {
    return new AgentsSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return AgentsStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return AgentsStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return AgentsStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return AgentsStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return AgentsStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return AgentsStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return AgentsStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return AgentsStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected AgentsSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for AgentsSettings. */
  public static class Builder extends ClientSettings.Builder<AgentsSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(AgentsStubSettings.newBuilder(clientContext));
    }

    protected Builder(AgentsSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(AgentsStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(AgentsStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(AgentsStubSettings.newHttpJsonBuilder());
    }

    public AgentsStubSettings.Builder getStubSettingsBuilder() {
      return ((AgentsStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to getAgent. */
    public UnaryCallSettings.Builder<GetAgentRequest, Agent> getAgentSettings() {
      return getStubSettingsBuilder().getAgentSettings();
    }

    /** Returns the builder for the settings used for calls to setAgent. */
    public UnaryCallSettings.Builder<SetAgentRequest, Agent> setAgentSettings() {
      return getStubSettingsBuilder().setAgentSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAgent. */
    public UnaryCallSettings.Builder<DeleteAgentRequest, Empty> deleteAgentSettings() {
      return getStubSettingsBuilder().deleteAgentSettings();
    }

    /** Returns the builder for the settings used for calls to searchAgents. */
    public PagedCallSettings.Builder<
            SearchAgentsRequest, SearchAgentsResponse, SearchAgentsPagedResponse>
        searchAgentsSettings() {
      return getStubSettingsBuilder().searchAgentsSettings();
    }

    /** Returns the builder for the settings used for calls to trainAgent. */
    public UnaryCallSettings.Builder<TrainAgentRequest, Operation> trainAgentSettings() {
      return getStubSettingsBuilder().trainAgentSettings();
    }

    /** Returns the builder for the settings used for calls to trainAgent. */
    public OperationCallSettings.Builder<TrainAgentRequest, Empty, Struct>
        trainAgentOperationSettings() {
      return getStubSettingsBuilder().trainAgentOperationSettings();
    }

    /** Returns the builder for the settings used for calls to exportAgent. */
    public UnaryCallSettings.Builder<ExportAgentRequest, Operation> exportAgentSettings() {
      return getStubSettingsBuilder().exportAgentSettings();
    }

    /** Returns the builder for the settings used for calls to exportAgent. */
    public OperationCallSettings.Builder<ExportAgentRequest, ExportAgentResponse, Struct>
        exportAgentOperationSettings() {
      return getStubSettingsBuilder().exportAgentOperationSettings();
    }

    /** Returns the builder for the settings used for calls to importAgent. */
    public UnaryCallSettings.Builder<ImportAgentRequest, Operation> importAgentSettings() {
      return getStubSettingsBuilder().importAgentSettings();
    }

    /** Returns the builder for the settings used for calls to importAgent. */
    public OperationCallSettings.Builder<ImportAgentRequest, Empty, Struct>
        importAgentOperationSettings() {
      return getStubSettingsBuilder().importAgentOperationSettings();
    }

    /** Returns the builder for the settings used for calls to restoreAgent. */
    public UnaryCallSettings.Builder<RestoreAgentRequest, Operation> restoreAgentSettings() {
      return getStubSettingsBuilder().restoreAgentSettings();
    }

    /** Returns the builder for the settings used for calls to restoreAgent. */
    public OperationCallSettings.Builder<RestoreAgentRequest, Empty, Struct>
        restoreAgentOperationSettings() {
      return getStubSettingsBuilder().restoreAgentOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getValidationResult. */
    public UnaryCallSettings.Builder<GetValidationResultRequest, ValidationResult>
        getValidationResultSettings() {
      return getStubSettingsBuilder().getValidationResultSettings();
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
    public AgentsSettings build() throws IOException {
      return new AgentsSettings(this);
    }
  }
}
