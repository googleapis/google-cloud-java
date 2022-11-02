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

package com.google.storagetransfer.v1.proto;

import static com.google.storagetransfer.v1.proto.StorageTransferServiceClient.ListAgentPoolsPagedResponse;
import static com.google.storagetransfer.v1.proto.StorageTransferServiceClient.ListTransferJobsPagedResponse;

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
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.storagetransfer.v1.proto.stub.StorageTransferServiceStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link StorageTransferServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (storagetransfer.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getGoogleServiceAccount to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * StorageTransferServiceSettings.Builder storageTransferServiceSettingsBuilder =
 *     StorageTransferServiceSettings.newBuilder();
 * storageTransferServiceSettingsBuilder
 *     .getGoogleServiceAccountSettings()
 *     .setRetrySettings(
 *         storageTransferServiceSettingsBuilder
 *             .getGoogleServiceAccountSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * StorageTransferServiceSettings storageTransferServiceSettings =
 *     storageTransferServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class StorageTransferServiceSettings extends ClientSettings<StorageTransferServiceSettings> {

  /** Returns the object with the settings used for calls to getGoogleServiceAccount. */
  public UnaryCallSettings<
          TransferProto.GetGoogleServiceAccountRequest, TransferTypes.GoogleServiceAccount>
      getGoogleServiceAccountSettings() {
    return ((StorageTransferServiceStubSettings) getStubSettings())
        .getGoogleServiceAccountSettings();
  }

  /** Returns the object with the settings used for calls to createTransferJob. */
  public UnaryCallSettings<TransferProto.CreateTransferJobRequest, TransferTypes.TransferJob>
      createTransferJobSettings() {
    return ((StorageTransferServiceStubSettings) getStubSettings()).createTransferJobSettings();
  }

  /** Returns the object with the settings used for calls to updateTransferJob. */
  public UnaryCallSettings<TransferProto.UpdateTransferJobRequest, TransferTypes.TransferJob>
      updateTransferJobSettings() {
    return ((StorageTransferServiceStubSettings) getStubSettings()).updateTransferJobSettings();
  }

  /** Returns the object with the settings used for calls to getTransferJob. */
  public UnaryCallSettings<TransferProto.GetTransferJobRequest, TransferTypes.TransferJob>
      getTransferJobSettings() {
    return ((StorageTransferServiceStubSettings) getStubSettings()).getTransferJobSettings();
  }

  /** Returns the object with the settings used for calls to listTransferJobs. */
  public PagedCallSettings<
          TransferProto.ListTransferJobsRequest,
          TransferProto.ListTransferJobsResponse,
          ListTransferJobsPagedResponse>
      listTransferJobsSettings() {
    return ((StorageTransferServiceStubSettings) getStubSettings()).listTransferJobsSettings();
  }

  /** Returns the object with the settings used for calls to pauseTransfer. */
  public UnaryCallSettings<TransferProto.PauseTransferOperationRequest, Empty>
      pauseTransferOperationSettings() {
    return ((StorageTransferServiceStubSettings) getStubSettings())
        .pauseTransferOperationSettings();
  }

  /** Returns the object with the settings used for calls to resumeTransfer. */
  public UnaryCallSettings<TransferProto.ResumeTransferOperationRequest, Empty>
      resumeTransferOperationSettings() {
    return ((StorageTransferServiceStubSettings) getStubSettings())
        .resumeTransferOperationSettings();
  }

  /** Returns the object with the settings used for calls to runTransferJob. */
  public UnaryCallSettings<TransferProto.RunTransferJobRequest, Operation>
      runTransferJobSettings() {
    return ((StorageTransferServiceStubSettings) getStubSettings()).runTransferJobSettings();
  }

  /** Returns the object with the settings used for calls to runTransferJob. */
  public OperationCallSettings<
          TransferProto.RunTransferJobRequest, Empty, TransferTypes.TransferOperation>
      runTransferJobOperationSettings() {
    return ((StorageTransferServiceStubSettings) getStubSettings())
        .runTransferJobOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteTransferJob. */
  public UnaryCallSettings<TransferProto.DeleteTransferJobRequest, Empty>
      deleteTransferJobSettings() {
    return ((StorageTransferServiceStubSettings) getStubSettings()).deleteTransferJobSettings();
  }

  /** Returns the object with the settings used for calls to createAgentPool. */
  public UnaryCallSettings<TransferProto.CreateAgentPoolRequest, TransferTypes.AgentPool>
      createAgentPoolSettings() {
    return ((StorageTransferServiceStubSettings) getStubSettings()).createAgentPoolSettings();
  }

  /** Returns the object with the settings used for calls to updateAgentPool. */
  public UnaryCallSettings<TransferProto.UpdateAgentPoolRequest, TransferTypes.AgentPool>
      updateAgentPoolSettings() {
    return ((StorageTransferServiceStubSettings) getStubSettings()).updateAgentPoolSettings();
  }

  /** Returns the object with the settings used for calls to getAgentPool. */
  public UnaryCallSettings<TransferProto.GetAgentPoolRequest, TransferTypes.AgentPool>
      getAgentPoolSettings() {
    return ((StorageTransferServiceStubSettings) getStubSettings()).getAgentPoolSettings();
  }

  /** Returns the object with the settings used for calls to listAgentPools. */
  public PagedCallSettings<
          TransferProto.ListAgentPoolsRequest,
          TransferProto.ListAgentPoolsResponse,
          ListAgentPoolsPagedResponse>
      listAgentPoolsSettings() {
    return ((StorageTransferServiceStubSettings) getStubSettings()).listAgentPoolsSettings();
  }

  /** Returns the object with the settings used for calls to deleteAgentPool. */
  public UnaryCallSettings<TransferProto.DeleteAgentPoolRequest, Empty> deleteAgentPoolSettings() {
    return ((StorageTransferServiceStubSettings) getStubSettings()).deleteAgentPoolSettings();
  }

  public static final StorageTransferServiceSettings create(StorageTransferServiceStubSettings stub)
      throws IOException {
    return new StorageTransferServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return StorageTransferServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return StorageTransferServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return StorageTransferServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return StorageTransferServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return StorageTransferServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return StorageTransferServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return StorageTransferServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return StorageTransferServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected StorageTransferServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for StorageTransferServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<StorageTransferServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(StorageTransferServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(StorageTransferServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(StorageTransferServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(StorageTransferServiceStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(StorageTransferServiceStubSettings.newHttpJsonBuilder());
    }

    public StorageTransferServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((StorageTransferServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to getGoogleServiceAccount. */
    public UnaryCallSettings.Builder<
            TransferProto.GetGoogleServiceAccountRequest, TransferTypes.GoogleServiceAccount>
        getGoogleServiceAccountSettings() {
      return getStubSettingsBuilder().getGoogleServiceAccountSettings();
    }

    /** Returns the builder for the settings used for calls to createTransferJob. */
    public UnaryCallSettings.Builder<
            TransferProto.CreateTransferJobRequest, TransferTypes.TransferJob>
        createTransferJobSettings() {
      return getStubSettingsBuilder().createTransferJobSettings();
    }

    /** Returns the builder for the settings used for calls to updateTransferJob. */
    public UnaryCallSettings.Builder<
            TransferProto.UpdateTransferJobRequest, TransferTypes.TransferJob>
        updateTransferJobSettings() {
      return getStubSettingsBuilder().updateTransferJobSettings();
    }

    /** Returns the builder for the settings used for calls to getTransferJob. */
    public UnaryCallSettings.Builder<TransferProto.GetTransferJobRequest, TransferTypes.TransferJob>
        getTransferJobSettings() {
      return getStubSettingsBuilder().getTransferJobSettings();
    }

    /** Returns the builder for the settings used for calls to listTransferJobs. */
    public PagedCallSettings.Builder<
            TransferProto.ListTransferJobsRequest,
            TransferProto.ListTransferJobsResponse,
            ListTransferJobsPagedResponse>
        listTransferJobsSettings() {
      return getStubSettingsBuilder().listTransferJobsSettings();
    }

    /** Returns the builder for the settings used for calls to pauseTransfer. */
    public UnaryCallSettings.Builder<TransferProto.PauseTransferOperationRequest, Empty>
        pauseTransferOperationSettings() {
      return getStubSettingsBuilder().pauseTransferOperationSettings();
    }

    /** Returns the builder for the settings used for calls to resumeTransfer. */
    public UnaryCallSettings.Builder<TransferProto.ResumeTransferOperationRequest, Empty>
        resumeTransferOperationSettings() {
      return getStubSettingsBuilder().resumeTransferOperationSettings();
    }

    /** Returns the builder for the settings used for calls to runTransferJob. */
    public UnaryCallSettings.Builder<TransferProto.RunTransferJobRequest, Operation>
        runTransferJobSettings() {
      return getStubSettingsBuilder().runTransferJobSettings();
    }

    /** Returns the builder for the settings used for calls to runTransferJob. */
    public OperationCallSettings.Builder<
            TransferProto.RunTransferJobRequest, Empty, TransferTypes.TransferOperation>
        runTransferJobOperationSettings() {
      return getStubSettingsBuilder().runTransferJobOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteTransferJob. */
    public UnaryCallSettings.Builder<TransferProto.DeleteTransferJobRequest, Empty>
        deleteTransferJobSettings() {
      return getStubSettingsBuilder().deleteTransferJobSettings();
    }

    /** Returns the builder for the settings used for calls to createAgentPool. */
    public UnaryCallSettings.Builder<TransferProto.CreateAgentPoolRequest, TransferTypes.AgentPool>
        createAgentPoolSettings() {
      return getStubSettingsBuilder().createAgentPoolSettings();
    }

    /** Returns the builder for the settings used for calls to updateAgentPool. */
    public UnaryCallSettings.Builder<TransferProto.UpdateAgentPoolRequest, TransferTypes.AgentPool>
        updateAgentPoolSettings() {
      return getStubSettingsBuilder().updateAgentPoolSettings();
    }

    /** Returns the builder for the settings used for calls to getAgentPool. */
    public UnaryCallSettings.Builder<TransferProto.GetAgentPoolRequest, TransferTypes.AgentPool>
        getAgentPoolSettings() {
      return getStubSettingsBuilder().getAgentPoolSettings();
    }

    /** Returns the builder for the settings used for calls to listAgentPools. */
    public PagedCallSettings.Builder<
            TransferProto.ListAgentPoolsRequest,
            TransferProto.ListAgentPoolsResponse,
            ListAgentPoolsPagedResponse>
        listAgentPoolsSettings() {
      return getStubSettingsBuilder().listAgentPoolsSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAgentPool. */
    public UnaryCallSettings.Builder<TransferProto.DeleteAgentPoolRequest, Empty>
        deleteAgentPoolSettings() {
      return getStubSettingsBuilder().deleteAgentPoolSettings();
    }

    @Override
    public StorageTransferServiceSettings build() throws IOException {
      return new StorageTransferServiceSettings(this);
    }
  }
}
