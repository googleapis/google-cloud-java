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

package com.google.cloud.discoveryengine.v1beta;

import static com.google.cloud.discoveryengine.v1beta.EngineServiceClient.ListEnginesPagedResponse;

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
import com.google.cloud.discoveryengine.v1beta.stub.EngineServiceStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link EngineServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (discoveryengine.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of updateEngine to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * EngineServiceSettings.Builder engineServiceSettingsBuilder = EngineServiceSettings.newBuilder();
 * engineServiceSettingsBuilder
 *     .updateEngineSettings()
 *     .setRetrySettings(
 *         engineServiceSettingsBuilder
 *             .updateEngineSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * EngineServiceSettings engineServiceSettings = engineServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class EngineServiceSettings extends ClientSettings<EngineServiceSettings> {

  /** Returns the object with the settings used for calls to createEngine. */
  public UnaryCallSettings<CreateEngineRequest, Operation> createEngineSettings() {
    return ((EngineServiceStubSettings) getStubSettings()).createEngineSettings();
  }

  /** Returns the object with the settings used for calls to createEngine. */
  public OperationCallSettings<CreateEngineRequest, Engine, CreateEngineMetadata>
      createEngineOperationSettings() {
    return ((EngineServiceStubSettings) getStubSettings()).createEngineOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteEngine. */
  public UnaryCallSettings<DeleteEngineRequest, Operation> deleteEngineSettings() {
    return ((EngineServiceStubSettings) getStubSettings()).deleteEngineSettings();
  }

  /** Returns the object with the settings used for calls to deleteEngine. */
  public OperationCallSettings<DeleteEngineRequest, Empty, DeleteEngineMetadata>
      deleteEngineOperationSettings() {
    return ((EngineServiceStubSettings) getStubSettings()).deleteEngineOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateEngine. */
  public UnaryCallSettings<UpdateEngineRequest, Engine> updateEngineSettings() {
    return ((EngineServiceStubSettings) getStubSettings()).updateEngineSettings();
  }

  /** Returns the object with the settings used for calls to getEngine. */
  public UnaryCallSettings<GetEngineRequest, Engine> getEngineSettings() {
    return ((EngineServiceStubSettings) getStubSettings()).getEngineSettings();
  }

  /** Returns the object with the settings used for calls to listEngines. */
  public PagedCallSettings<ListEnginesRequest, ListEnginesResponse, ListEnginesPagedResponse>
      listEnginesSettings() {
    return ((EngineServiceStubSettings) getStubSettings()).listEnginesSettings();
  }

  /** Returns the object with the settings used for calls to pauseEngine. */
  public UnaryCallSettings<PauseEngineRequest, Engine> pauseEngineSettings() {
    return ((EngineServiceStubSettings) getStubSettings()).pauseEngineSettings();
  }

  /** Returns the object with the settings used for calls to resumeEngine. */
  public UnaryCallSettings<ResumeEngineRequest, Engine> resumeEngineSettings() {
    return ((EngineServiceStubSettings) getStubSettings()).resumeEngineSettings();
  }

  /** Returns the object with the settings used for calls to tuneEngine. */
  public UnaryCallSettings<TuneEngineRequest, Operation> tuneEngineSettings() {
    return ((EngineServiceStubSettings) getStubSettings()).tuneEngineSettings();
  }

  /** Returns the object with the settings used for calls to tuneEngine. */
  public OperationCallSettings<TuneEngineRequest, TuneEngineResponse, TuneEngineMetadata>
      tuneEngineOperationSettings() {
    return ((EngineServiceStubSettings) getStubSettings()).tuneEngineOperationSettings();
  }

  public static final EngineServiceSettings create(EngineServiceStubSettings stub)
      throws IOException {
    return new EngineServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return EngineServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return EngineServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return EngineServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return EngineServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return EngineServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return EngineServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return EngineServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return EngineServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected EngineServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for EngineServiceSettings. */
  public static class Builder extends ClientSettings.Builder<EngineServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(EngineServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(EngineServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(EngineServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(EngineServiceStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(EngineServiceStubSettings.newHttpJsonBuilder());
    }

    public EngineServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((EngineServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createEngine. */
    public UnaryCallSettings.Builder<CreateEngineRequest, Operation> createEngineSettings() {
      return getStubSettingsBuilder().createEngineSettings();
    }

    /** Returns the builder for the settings used for calls to createEngine. */
    public OperationCallSettings.Builder<CreateEngineRequest, Engine, CreateEngineMetadata>
        createEngineOperationSettings() {
      return getStubSettingsBuilder().createEngineOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteEngine. */
    public UnaryCallSettings.Builder<DeleteEngineRequest, Operation> deleteEngineSettings() {
      return getStubSettingsBuilder().deleteEngineSettings();
    }

    /** Returns the builder for the settings used for calls to deleteEngine. */
    public OperationCallSettings.Builder<DeleteEngineRequest, Empty, DeleteEngineMetadata>
        deleteEngineOperationSettings() {
      return getStubSettingsBuilder().deleteEngineOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateEngine. */
    public UnaryCallSettings.Builder<UpdateEngineRequest, Engine> updateEngineSettings() {
      return getStubSettingsBuilder().updateEngineSettings();
    }

    /** Returns the builder for the settings used for calls to getEngine. */
    public UnaryCallSettings.Builder<GetEngineRequest, Engine> getEngineSettings() {
      return getStubSettingsBuilder().getEngineSettings();
    }

    /** Returns the builder for the settings used for calls to listEngines. */
    public PagedCallSettings.Builder<
            ListEnginesRequest, ListEnginesResponse, ListEnginesPagedResponse>
        listEnginesSettings() {
      return getStubSettingsBuilder().listEnginesSettings();
    }

    /** Returns the builder for the settings used for calls to pauseEngine. */
    public UnaryCallSettings.Builder<PauseEngineRequest, Engine> pauseEngineSettings() {
      return getStubSettingsBuilder().pauseEngineSettings();
    }

    /** Returns the builder for the settings used for calls to resumeEngine. */
    public UnaryCallSettings.Builder<ResumeEngineRequest, Engine> resumeEngineSettings() {
      return getStubSettingsBuilder().resumeEngineSettings();
    }

    /** Returns the builder for the settings used for calls to tuneEngine. */
    public UnaryCallSettings.Builder<TuneEngineRequest, Operation> tuneEngineSettings() {
      return getStubSettingsBuilder().tuneEngineSettings();
    }

    /** Returns the builder for the settings used for calls to tuneEngine. */
    public OperationCallSettings.Builder<TuneEngineRequest, TuneEngineResponse, TuneEngineMetadata>
        tuneEngineOperationSettings() {
      return getStubSettingsBuilder().tuneEngineOperationSettings();
    }

    @Override
    public EngineServiceSettings build() throws IOException {
      return new EngineServiceSettings(this);
    }
  }
}
