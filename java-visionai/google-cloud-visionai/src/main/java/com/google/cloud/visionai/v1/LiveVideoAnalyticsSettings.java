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

package com.google.cloud.visionai.v1;

import static com.google.cloud.visionai.v1.LiveVideoAnalyticsClient.ListAnalysesPagedResponse;
import static com.google.cloud.visionai.v1.LiveVideoAnalyticsClient.ListOperatorsPagedResponse;
import static com.google.cloud.visionai.v1.LiveVideoAnalyticsClient.ListProcessesPagedResponse;
import static com.google.cloud.visionai.v1.LiveVideoAnalyticsClient.ListPublicOperatorsPagedResponse;

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
import com.google.cloud.visionai.v1.stub.LiveVideoAnalyticsStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link LiveVideoAnalyticsClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (visionai.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of resolveOperatorInfo to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * LiveVideoAnalyticsSettings.Builder liveVideoAnalyticsSettingsBuilder =
 *     LiveVideoAnalyticsSettings.newBuilder();
 * liveVideoAnalyticsSettingsBuilder
 *     .resolveOperatorInfoSettings()
 *     .setRetrySettings(
 *         liveVideoAnalyticsSettingsBuilder
 *             .resolveOperatorInfoSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * LiveVideoAnalyticsSettings liveVideoAnalyticsSettings =
 *     liveVideoAnalyticsSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class LiveVideoAnalyticsSettings extends ClientSettings<LiveVideoAnalyticsSettings> {

  /** Returns the object with the settings used for calls to listPublicOperators. */
  public PagedCallSettings<
          ListPublicOperatorsRequest, ListPublicOperatorsResponse, ListPublicOperatorsPagedResponse>
      listPublicOperatorsSettings() {
    return ((LiveVideoAnalyticsStubSettings) getStubSettings()).listPublicOperatorsSettings();
  }

  /** Returns the object with the settings used for calls to resolveOperatorInfo. */
  public UnaryCallSettings<ResolveOperatorInfoRequest, ResolveOperatorInfoResponse>
      resolveOperatorInfoSettings() {
    return ((LiveVideoAnalyticsStubSettings) getStubSettings()).resolveOperatorInfoSettings();
  }

  /** Returns the object with the settings used for calls to listOperators. */
  public PagedCallSettings<ListOperatorsRequest, ListOperatorsResponse, ListOperatorsPagedResponse>
      listOperatorsSettings() {
    return ((LiveVideoAnalyticsStubSettings) getStubSettings()).listOperatorsSettings();
  }

  /** Returns the object with the settings used for calls to getOperator. */
  public UnaryCallSettings<GetOperatorRequest, Operator> getOperatorSettings() {
    return ((LiveVideoAnalyticsStubSettings) getStubSettings()).getOperatorSettings();
  }

  /** Returns the object with the settings used for calls to createOperator. */
  public UnaryCallSettings<CreateOperatorRequest, Operation> createOperatorSettings() {
    return ((LiveVideoAnalyticsStubSettings) getStubSettings()).createOperatorSettings();
  }

  /** Returns the object with the settings used for calls to createOperator. */
  public OperationCallSettings<CreateOperatorRequest, Operator, OperationMetadata>
      createOperatorOperationSettings() {
    return ((LiveVideoAnalyticsStubSettings) getStubSettings()).createOperatorOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateOperator. */
  public UnaryCallSettings<UpdateOperatorRequest, Operation> updateOperatorSettings() {
    return ((LiveVideoAnalyticsStubSettings) getStubSettings()).updateOperatorSettings();
  }

  /** Returns the object with the settings used for calls to updateOperator. */
  public OperationCallSettings<UpdateOperatorRequest, Operator, OperationMetadata>
      updateOperatorOperationSettings() {
    return ((LiveVideoAnalyticsStubSettings) getStubSettings()).updateOperatorOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteOperator. */
  public UnaryCallSettings<DeleteOperatorRequest, Operation> deleteOperatorSettings() {
    return ((LiveVideoAnalyticsStubSettings) getStubSettings()).deleteOperatorSettings();
  }

  /** Returns the object with the settings used for calls to deleteOperator. */
  public OperationCallSettings<DeleteOperatorRequest, Empty, OperationMetadata>
      deleteOperatorOperationSettings() {
    return ((LiveVideoAnalyticsStubSettings) getStubSettings()).deleteOperatorOperationSettings();
  }

  /** Returns the object with the settings used for calls to listAnalyses. */
  public PagedCallSettings<ListAnalysesRequest, ListAnalysesResponse, ListAnalysesPagedResponse>
      listAnalysesSettings() {
    return ((LiveVideoAnalyticsStubSettings) getStubSettings()).listAnalysesSettings();
  }

  /** Returns the object with the settings used for calls to getAnalysis. */
  public UnaryCallSettings<GetAnalysisRequest, Analysis> getAnalysisSettings() {
    return ((LiveVideoAnalyticsStubSettings) getStubSettings()).getAnalysisSettings();
  }

  /** Returns the object with the settings used for calls to createAnalysis. */
  public UnaryCallSettings<CreateAnalysisRequest, Operation> createAnalysisSettings() {
    return ((LiveVideoAnalyticsStubSettings) getStubSettings()).createAnalysisSettings();
  }

  /** Returns the object with the settings used for calls to createAnalysis. */
  public OperationCallSettings<CreateAnalysisRequest, Analysis, OperationMetadata>
      createAnalysisOperationSettings() {
    return ((LiveVideoAnalyticsStubSettings) getStubSettings()).createAnalysisOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateAnalysis. */
  public UnaryCallSettings<UpdateAnalysisRequest, Operation> updateAnalysisSettings() {
    return ((LiveVideoAnalyticsStubSettings) getStubSettings()).updateAnalysisSettings();
  }

  /** Returns the object with the settings used for calls to updateAnalysis. */
  public OperationCallSettings<UpdateAnalysisRequest, Analysis, OperationMetadata>
      updateAnalysisOperationSettings() {
    return ((LiveVideoAnalyticsStubSettings) getStubSettings()).updateAnalysisOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteAnalysis. */
  public UnaryCallSettings<DeleteAnalysisRequest, Operation> deleteAnalysisSettings() {
    return ((LiveVideoAnalyticsStubSettings) getStubSettings()).deleteAnalysisSettings();
  }

  /** Returns the object with the settings used for calls to deleteAnalysis. */
  public OperationCallSettings<DeleteAnalysisRequest, Empty, OperationMetadata>
      deleteAnalysisOperationSettings() {
    return ((LiveVideoAnalyticsStubSettings) getStubSettings()).deleteAnalysisOperationSettings();
  }

  /** Returns the object with the settings used for calls to listProcesses. */
  public PagedCallSettings<ListProcessesRequest, ListProcessesResponse, ListProcessesPagedResponse>
      listProcessesSettings() {
    return ((LiveVideoAnalyticsStubSettings) getStubSettings()).listProcessesSettings();
  }

  /** Returns the object with the settings used for calls to getProcess. */
  public UnaryCallSettings<GetProcessRequest, Process> getProcessSettings() {
    return ((LiveVideoAnalyticsStubSettings) getStubSettings()).getProcessSettings();
  }

  /** Returns the object with the settings used for calls to createProcess. */
  public UnaryCallSettings<CreateProcessRequest, Operation> createProcessSettings() {
    return ((LiveVideoAnalyticsStubSettings) getStubSettings()).createProcessSettings();
  }

  /** Returns the object with the settings used for calls to createProcess. */
  public OperationCallSettings<CreateProcessRequest, Process, OperationMetadata>
      createProcessOperationSettings() {
    return ((LiveVideoAnalyticsStubSettings) getStubSettings()).createProcessOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateProcess. */
  public UnaryCallSettings<UpdateProcessRequest, Operation> updateProcessSettings() {
    return ((LiveVideoAnalyticsStubSettings) getStubSettings()).updateProcessSettings();
  }

  /** Returns the object with the settings used for calls to updateProcess. */
  public OperationCallSettings<UpdateProcessRequest, Process, OperationMetadata>
      updateProcessOperationSettings() {
    return ((LiveVideoAnalyticsStubSettings) getStubSettings()).updateProcessOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteProcess. */
  public UnaryCallSettings<DeleteProcessRequest, Operation> deleteProcessSettings() {
    return ((LiveVideoAnalyticsStubSettings) getStubSettings()).deleteProcessSettings();
  }

  /** Returns the object with the settings used for calls to deleteProcess. */
  public OperationCallSettings<DeleteProcessRequest, Empty, OperationMetadata>
      deleteProcessOperationSettings() {
    return ((LiveVideoAnalyticsStubSettings) getStubSettings()).deleteProcessOperationSettings();
  }

  /** Returns the object with the settings used for calls to batchRunProcess. */
  public UnaryCallSettings<BatchRunProcessRequest, Operation> batchRunProcessSettings() {
    return ((LiveVideoAnalyticsStubSettings) getStubSettings()).batchRunProcessSettings();
  }

  /** Returns the object with the settings used for calls to batchRunProcess. */
  public OperationCallSettings<BatchRunProcessRequest, BatchRunProcessResponse, OperationMetadata>
      batchRunProcessOperationSettings() {
    return ((LiveVideoAnalyticsStubSettings) getStubSettings()).batchRunProcessOperationSettings();
  }

  public static final LiveVideoAnalyticsSettings create(LiveVideoAnalyticsStubSettings stub)
      throws IOException {
    return new LiveVideoAnalyticsSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return LiveVideoAnalyticsStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return LiveVideoAnalyticsStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return LiveVideoAnalyticsStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return LiveVideoAnalyticsStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return LiveVideoAnalyticsStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return LiveVideoAnalyticsStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return LiveVideoAnalyticsStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return LiveVideoAnalyticsStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected LiveVideoAnalyticsSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for LiveVideoAnalyticsSettings. */
  public static class Builder extends ClientSettings.Builder<LiveVideoAnalyticsSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(LiveVideoAnalyticsStubSettings.newBuilder(clientContext));
    }

    protected Builder(LiveVideoAnalyticsSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(LiveVideoAnalyticsStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(LiveVideoAnalyticsStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(LiveVideoAnalyticsStubSettings.newHttpJsonBuilder());
    }

    public LiveVideoAnalyticsStubSettings.Builder getStubSettingsBuilder() {
      return ((LiveVideoAnalyticsStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listPublicOperators. */
    public PagedCallSettings.Builder<
            ListPublicOperatorsRequest,
            ListPublicOperatorsResponse,
            ListPublicOperatorsPagedResponse>
        listPublicOperatorsSettings() {
      return getStubSettingsBuilder().listPublicOperatorsSettings();
    }

    /** Returns the builder for the settings used for calls to resolveOperatorInfo. */
    public UnaryCallSettings.Builder<ResolveOperatorInfoRequest, ResolveOperatorInfoResponse>
        resolveOperatorInfoSettings() {
      return getStubSettingsBuilder().resolveOperatorInfoSettings();
    }

    /** Returns the builder for the settings used for calls to listOperators. */
    public PagedCallSettings.Builder<
            ListOperatorsRequest, ListOperatorsResponse, ListOperatorsPagedResponse>
        listOperatorsSettings() {
      return getStubSettingsBuilder().listOperatorsSettings();
    }

    /** Returns the builder for the settings used for calls to getOperator. */
    public UnaryCallSettings.Builder<GetOperatorRequest, Operator> getOperatorSettings() {
      return getStubSettingsBuilder().getOperatorSettings();
    }

    /** Returns the builder for the settings used for calls to createOperator. */
    public UnaryCallSettings.Builder<CreateOperatorRequest, Operation> createOperatorSettings() {
      return getStubSettingsBuilder().createOperatorSettings();
    }

    /** Returns the builder for the settings used for calls to createOperator. */
    public OperationCallSettings.Builder<CreateOperatorRequest, Operator, OperationMetadata>
        createOperatorOperationSettings() {
      return getStubSettingsBuilder().createOperatorOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateOperator. */
    public UnaryCallSettings.Builder<UpdateOperatorRequest, Operation> updateOperatorSettings() {
      return getStubSettingsBuilder().updateOperatorSettings();
    }

    /** Returns the builder for the settings used for calls to updateOperator. */
    public OperationCallSettings.Builder<UpdateOperatorRequest, Operator, OperationMetadata>
        updateOperatorOperationSettings() {
      return getStubSettingsBuilder().updateOperatorOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteOperator. */
    public UnaryCallSettings.Builder<DeleteOperatorRequest, Operation> deleteOperatorSettings() {
      return getStubSettingsBuilder().deleteOperatorSettings();
    }

    /** Returns the builder for the settings used for calls to deleteOperator. */
    public OperationCallSettings.Builder<DeleteOperatorRequest, Empty, OperationMetadata>
        deleteOperatorOperationSettings() {
      return getStubSettingsBuilder().deleteOperatorOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listAnalyses. */
    public PagedCallSettings.Builder<
            ListAnalysesRequest, ListAnalysesResponse, ListAnalysesPagedResponse>
        listAnalysesSettings() {
      return getStubSettingsBuilder().listAnalysesSettings();
    }

    /** Returns the builder for the settings used for calls to getAnalysis. */
    public UnaryCallSettings.Builder<GetAnalysisRequest, Analysis> getAnalysisSettings() {
      return getStubSettingsBuilder().getAnalysisSettings();
    }

    /** Returns the builder for the settings used for calls to createAnalysis. */
    public UnaryCallSettings.Builder<CreateAnalysisRequest, Operation> createAnalysisSettings() {
      return getStubSettingsBuilder().createAnalysisSettings();
    }

    /** Returns the builder for the settings used for calls to createAnalysis. */
    public OperationCallSettings.Builder<CreateAnalysisRequest, Analysis, OperationMetadata>
        createAnalysisOperationSettings() {
      return getStubSettingsBuilder().createAnalysisOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateAnalysis. */
    public UnaryCallSettings.Builder<UpdateAnalysisRequest, Operation> updateAnalysisSettings() {
      return getStubSettingsBuilder().updateAnalysisSettings();
    }

    /** Returns the builder for the settings used for calls to updateAnalysis. */
    public OperationCallSettings.Builder<UpdateAnalysisRequest, Analysis, OperationMetadata>
        updateAnalysisOperationSettings() {
      return getStubSettingsBuilder().updateAnalysisOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAnalysis. */
    public UnaryCallSettings.Builder<DeleteAnalysisRequest, Operation> deleteAnalysisSettings() {
      return getStubSettingsBuilder().deleteAnalysisSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAnalysis. */
    public OperationCallSettings.Builder<DeleteAnalysisRequest, Empty, OperationMetadata>
        deleteAnalysisOperationSettings() {
      return getStubSettingsBuilder().deleteAnalysisOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listProcesses. */
    public PagedCallSettings.Builder<
            ListProcessesRequest, ListProcessesResponse, ListProcessesPagedResponse>
        listProcessesSettings() {
      return getStubSettingsBuilder().listProcessesSettings();
    }

    /** Returns the builder for the settings used for calls to getProcess. */
    public UnaryCallSettings.Builder<GetProcessRequest, Process> getProcessSettings() {
      return getStubSettingsBuilder().getProcessSettings();
    }

    /** Returns the builder for the settings used for calls to createProcess. */
    public UnaryCallSettings.Builder<CreateProcessRequest, Operation> createProcessSettings() {
      return getStubSettingsBuilder().createProcessSettings();
    }

    /** Returns the builder for the settings used for calls to createProcess. */
    public OperationCallSettings.Builder<CreateProcessRequest, Process, OperationMetadata>
        createProcessOperationSettings() {
      return getStubSettingsBuilder().createProcessOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateProcess. */
    public UnaryCallSettings.Builder<UpdateProcessRequest, Operation> updateProcessSettings() {
      return getStubSettingsBuilder().updateProcessSettings();
    }

    /** Returns the builder for the settings used for calls to updateProcess. */
    public OperationCallSettings.Builder<UpdateProcessRequest, Process, OperationMetadata>
        updateProcessOperationSettings() {
      return getStubSettingsBuilder().updateProcessOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteProcess. */
    public UnaryCallSettings.Builder<DeleteProcessRequest, Operation> deleteProcessSettings() {
      return getStubSettingsBuilder().deleteProcessSettings();
    }

    /** Returns the builder for the settings used for calls to deleteProcess. */
    public OperationCallSettings.Builder<DeleteProcessRequest, Empty, OperationMetadata>
        deleteProcessOperationSettings() {
      return getStubSettingsBuilder().deleteProcessOperationSettings();
    }

    /** Returns the builder for the settings used for calls to batchRunProcess. */
    public UnaryCallSettings.Builder<BatchRunProcessRequest, Operation> batchRunProcessSettings() {
      return getStubSettingsBuilder().batchRunProcessSettings();
    }

    /** Returns the builder for the settings used for calls to batchRunProcess. */
    public OperationCallSettings.Builder<
            BatchRunProcessRequest, BatchRunProcessResponse, OperationMetadata>
        batchRunProcessOperationSettings() {
      return getStubSettingsBuilder().batchRunProcessOperationSettings();
    }

    @Override
    public LiveVideoAnalyticsSettings build() throws IOException {
      return new LiveVideoAnalyticsSettings(this);
    }
  }
}
