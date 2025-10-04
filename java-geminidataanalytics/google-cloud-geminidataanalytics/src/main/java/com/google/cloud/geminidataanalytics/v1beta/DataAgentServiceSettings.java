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

package com.google.cloud.geminidataanalytics.v1beta;

import static com.google.cloud.geminidataanalytics.v1beta.DataAgentServiceClient.ListAccessibleDataAgentsPagedResponse;
import static com.google.cloud.geminidataanalytics.v1beta.DataAgentServiceClient.ListDataAgentsPagedResponse;
import static com.google.cloud.geminidataanalytics.v1beta.DataAgentServiceClient.ListLocationsPagedResponse;

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
import com.google.cloud.geminidataanalytics.v1beta.stub.DataAgentServiceStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link DataAgentServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (geminidataanalytics.googleapis.com) and default port (443) are
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
 * of getDataAgent:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DataAgentServiceSettings.Builder dataAgentServiceSettingsBuilder =
 *     DataAgentServiceSettings.newBuilder();
 * dataAgentServiceSettingsBuilder
 *     .getDataAgentSettings()
 *     .setRetrySettings(
 *         dataAgentServiceSettingsBuilder
 *             .getDataAgentSettings()
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
 * DataAgentServiceSettings dataAgentServiceSettings = dataAgentServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createDataAgent:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DataAgentServiceSettings.Builder dataAgentServiceSettingsBuilder =
 *     DataAgentServiceSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * dataAgentServiceSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class DataAgentServiceSettings extends ClientSettings<DataAgentServiceSettings> {

  /** Returns the object with the settings used for calls to listDataAgents. */
  public PagedCallSettings<
          ListDataAgentsRequest, ListDataAgentsResponse, ListDataAgentsPagedResponse>
      listDataAgentsSettings() {
    return ((DataAgentServiceStubSettings) getStubSettings()).listDataAgentsSettings();
  }

  /** Returns the object with the settings used for calls to listAccessibleDataAgents. */
  public PagedCallSettings<
          ListAccessibleDataAgentsRequest,
          ListAccessibleDataAgentsResponse,
          ListAccessibleDataAgentsPagedResponse>
      listAccessibleDataAgentsSettings() {
    return ((DataAgentServiceStubSettings) getStubSettings()).listAccessibleDataAgentsSettings();
  }

  /** Returns the object with the settings used for calls to getDataAgent. */
  public UnaryCallSettings<GetDataAgentRequest, DataAgent> getDataAgentSettings() {
    return ((DataAgentServiceStubSettings) getStubSettings()).getDataAgentSettings();
  }

  /** Returns the object with the settings used for calls to createDataAgent. */
  public UnaryCallSettings<CreateDataAgentRequest, Operation> createDataAgentSettings() {
    return ((DataAgentServiceStubSettings) getStubSettings()).createDataAgentSettings();
  }

  /** Returns the object with the settings used for calls to createDataAgent. */
  public OperationCallSettings<CreateDataAgentRequest, DataAgent, OperationMetadata>
      createDataAgentOperationSettings() {
    return ((DataAgentServiceStubSettings) getStubSettings()).createDataAgentOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateDataAgent. */
  public UnaryCallSettings<UpdateDataAgentRequest, Operation> updateDataAgentSettings() {
    return ((DataAgentServiceStubSettings) getStubSettings()).updateDataAgentSettings();
  }

  /** Returns the object with the settings used for calls to updateDataAgent. */
  public OperationCallSettings<UpdateDataAgentRequest, DataAgent, OperationMetadata>
      updateDataAgentOperationSettings() {
    return ((DataAgentServiceStubSettings) getStubSettings()).updateDataAgentOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteDataAgent. */
  public UnaryCallSettings<DeleteDataAgentRequest, Operation> deleteDataAgentSettings() {
    return ((DataAgentServiceStubSettings) getStubSettings()).deleteDataAgentSettings();
  }

  /** Returns the object with the settings used for calls to deleteDataAgent. */
  public OperationCallSettings<DeleteDataAgentRequest, Empty, OperationMetadata>
      deleteDataAgentOperationSettings() {
    return ((DataAgentServiceStubSettings) getStubSettings()).deleteDataAgentOperationSettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((DataAgentServiceStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((DataAgentServiceStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((DataAgentServiceStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((DataAgentServiceStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final DataAgentServiceSettings create(DataAgentServiceStubSettings stub)
      throws IOException {
    return new DataAgentServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return DataAgentServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return DataAgentServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DataAgentServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return DataAgentServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return DataAgentServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return DataAgentServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return DataAgentServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DataAgentServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected DataAgentServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for DataAgentServiceSettings. */
  public static class Builder extends ClientSettings.Builder<DataAgentServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(DataAgentServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(DataAgentServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(DataAgentServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(DataAgentServiceStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(DataAgentServiceStubSettings.newHttpJsonBuilder());
    }

    public DataAgentServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((DataAgentServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listDataAgents. */
    public PagedCallSettings.Builder<
            ListDataAgentsRequest, ListDataAgentsResponse, ListDataAgentsPagedResponse>
        listDataAgentsSettings() {
      return getStubSettingsBuilder().listDataAgentsSettings();
    }

    /** Returns the builder for the settings used for calls to listAccessibleDataAgents. */
    public PagedCallSettings.Builder<
            ListAccessibleDataAgentsRequest,
            ListAccessibleDataAgentsResponse,
            ListAccessibleDataAgentsPagedResponse>
        listAccessibleDataAgentsSettings() {
      return getStubSettingsBuilder().listAccessibleDataAgentsSettings();
    }

    /** Returns the builder for the settings used for calls to getDataAgent. */
    public UnaryCallSettings.Builder<GetDataAgentRequest, DataAgent> getDataAgentSettings() {
      return getStubSettingsBuilder().getDataAgentSettings();
    }

    /** Returns the builder for the settings used for calls to createDataAgent. */
    public UnaryCallSettings.Builder<CreateDataAgentRequest, Operation> createDataAgentSettings() {
      return getStubSettingsBuilder().createDataAgentSettings();
    }

    /** Returns the builder for the settings used for calls to createDataAgent. */
    public OperationCallSettings.Builder<CreateDataAgentRequest, DataAgent, OperationMetadata>
        createDataAgentOperationSettings() {
      return getStubSettingsBuilder().createDataAgentOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateDataAgent. */
    public UnaryCallSettings.Builder<UpdateDataAgentRequest, Operation> updateDataAgentSettings() {
      return getStubSettingsBuilder().updateDataAgentSettings();
    }

    /** Returns the builder for the settings used for calls to updateDataAgent. */
    public OperationCallSettings.Builder<UpdateDataAgentRequest, DataAgent, OperationMetadata>
        updateDataAgentOperationSettings() {
      return getStubSettingsBuilder().updateDataAgentOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteDataAgent. */
    public UnaryCallSettings.Builder<DeleteDataAgentRequest, Operation> deleteDataAgentSettings() {
      return getStubSettingsBuilder().deleteDataAgentSettings();
    }

    /** Returns the builder for the settings used for calls to deleteDataAgent. */
    public OperationCallSettings.Builder<DeleteDataAgentRequest, Empty, OperationMetadata>
        deleteDataAgentOperationSettings() {
      return getStubSettingsBuilder().deleteDataAgentOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getStubSettingsBuilder().getIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return getStubSettingsBuilder().setIamPolicySettings();
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
    public DataAgentServiceSettings build() throws IOException {
      return new DataAgentServiceSettings(this);
    }
  }
}
