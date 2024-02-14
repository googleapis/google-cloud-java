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

package com.google.cloud.policysimulator.v1;

import static com.google.cloud.policysimulator.v1.SimulatorClient.ListReplayResultsPagedResponse;

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
import com.google.cloud.policysimulator.v1.stub.SimulatorStubSettings;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link SimulatorClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (policysimulator.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getReplay to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SimulatorSettings.Builder simulatorSettingsBuilder = SimulatorSettings.newBuilder();
 * simulatorSettingsBuilder
 *     .getReplaySettings()
 *     .setRetrySettings(
 *         simulatorSettingsBuilder
 *             .getReplaySettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * SimulatorSettings simulatorSettings = simulatorSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class SimulatorSettings extends ClientSettings<SimulatorSettings> {

  /** Returns the object with the settings used for calls to getReplay. */
  public UnaryCallSettings<GetReplayRequest, Replay> getReplaySettings() {
    return ((SimulatorStubSettings) getStubSettings()).getReplaySettings();
  }

  /** Returns the object with the settings used for calls to createReplay. */
  public UnaryCallSettings<CreateReplayRequest, Operation> createReplaySettings() {
    return ((SimulatorStubSettings) getStubSettings()).createReplaySettings();
  }

  /** Returns the object with the settings used for calls to createReplay. */
  public OperationCallSettings<CreateReplayRequest, Replay, ReplayOperationMetadata>
      createReplayOperationSettings() {
    return ((SimulatorStubSettings) getStubSettings()).createReplayOperationSettings();
  }

  /** Returns the object with the settings used for calls to listReplayResults. */
  public PagedCallSettings<
          ListReplayResultsRequest, ListReplayResultsResponse, ListReplayResultsPagedResponse>
      listReplayResultsSettings() {
    return ((SimulatorStubSettings) getStubSettings()).listReplayResultsSettings();
  }

  public static final SimulatorSettings create(SimulatorStubSettings stub) throws IOException {
    return new SimulatorSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return SimulatorStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return SimulatorStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return SimulatorStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return SimulatorStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return SimulatorStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return SimulatorStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return SimulatorStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return SimulatorStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected SimulatorSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for SimulatorSettings. */
  public static class Builder extends ClientSettings.Builder<SimulatorSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(SimulatorStubSettings.newBuilder(clientContext));
    }

    protected Builder(SimulatorSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(SimulatorStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(SimulatorStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(SimulatorStubSettings.newHttpJsonBuilder());
    }

    public SimulatorStubSettings.Builder getStubSettingsBuilder() {
      return ((SimulatorStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to getReplay. */
    public UnaryCallSettings.Builder<GetReplayRequest, Replay> getReplaySettings() {
      return getStubSettingsBuilder().getReplaySettings();
    }

    /** Returns the builder for the settings used for calls to createReplay. */
    public UnaryCallSettings.Builder<CreateReplayRequest, Operation> createReplaySettings() {
      return getStubSettingsBuilder().createReplaySettings();
    }

    /** Returns the builder for the settings used for calls to createReplay. */
    public OperationCallSettings.Builder<CreateReplayRequest, Replay, ReplayOperationMetadata>
        createReplayOperationSettings() {
      return getStubSettingsBuilder().createReplayOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listReplayResults. */
    public PagedCallSettings.Builder<
            ListReplayResultsRequest, ListReplayResultsResponse, ListReplayResultsPagedResponse>
        listReplayResultsSettings() {
      return getStubSettingsBuilder().listReplayResultsSettings();
    }

    @Override
    public SimulatorSettings build() throws IOException {
      return new SimulatorSettings(this);
    }
  }
}
