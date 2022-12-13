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

package com.google.cloud.documentai.v1beta3;

import static com.google.cloud.documentai.v1beta3.DocumentProcessorServiceClient.ListEvaluationsPagedResponse;
import static com.google.cloud.documentai.v1beta3.DocumentProcessorServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.documentai.v1beta3.DocumentProcessorServiceClient.ListProcessorTypesPagedResponse;
import static com.google.cloud.documentai.v1beta3.DocumentProcessorServiceClient.ListProcessorVersionsPagedResponse;
import static com.google.cloud.documentai.v1beta3.DocumentProcessorServiceClient.ListProcessorsPagedResponse;

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
import com.google.cloud.documentai.v1beta3.stub.DocumentProcessorServiceStubSettings;
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
 * Settings class to configure an instance of {@link DocumentProcessorServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (documentai.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of processDocument to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DocumentProcessorServiceSettings.Builder documentProcessorServiceSettingsBuilder =
 *     DocumentProcessorServiceSettings.newBuilder();
 * documentProcessorServiceSettingsBuilder
 *     .processDocumentSettings()
 *     .setRetrySettings(
 *         documentProcessorServiceSettingsBuilder
 *             .processDocumentSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * DocumentProcessorServiceSettings documentProcessorServiceSettings =
 *     documentProcessorServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class DocumentProcessorServiceSettings
    extends ClientSettings<DocumentProcessorServiceSettings> {

  /** Returns the object with the settings used for calls to processDocument. */
  public UnaryCallSettings<ProcessRequest, ProcessResponse> processDocumentSettings() {
    return ((DocumentProcessorServiceStubSettings) getStubSettings()).processDocumentSettings();
  }

  /** Returns the object with the settings used for calls to batchProcessDocuments. */
  public UnaryCallSettings<BatchProcessRequest, Operation> batchProcessDocumentsSettings() {
    return ((DocumentProcessorServiceStubSettings) getStubSettings())
        .batchProcessDocumentsSettings();
  }

  /** Returns the object with the settings used for calls to batchProcessDocuments. */
  public OperationCallSettings<BatchProcessRequest, BatchProcessResponse, BatchProcessMetadata>
      batchProcessDocumentsOperationSettings() {
    return ((DocumentProcessorServiceStubSettings) getStubSettings())
        .batchProcessDocumentsOperationSettings();
  }

  /** Returns the object with the settings used for calls to fetchProcessorTypes. */
  public UnaryCallSettings<FetchProcessorTypesRequest, FetchProcessorTypesResponse>
      fetchProcessorTypesSettings() {
    return ((DocumentProcessorServiceStubSettings) getStubSettings()).fetchProcessorTypesSettings();
  }

  /** Returns the object with the settings used for calls to listProcessorTypes. */
  public PagedCallSettings<
          ListProcessorTypesRequest, ListProcessorTypesResponse, ListProcessorTypesPagedResponse>
      listProcessorTypesSettings() {
    return ((DocumentProcessorServiceStubSettings) getStubSettings()).listProcessorTypesSettings();
  }

  /** Returns the object with the settings used for calls to listProcessors. */
  public PagedCallSettings<
          ListProcessorsRequest, ListProcessorsResponse, ListProcessorsPagedResponse>
      listProcessorsSettings() {
    return ((DocumentProcessorServiceStubSettings) getStubSettings()).listProcessorsSettings();
  }

  /** Returns the object with the settings used for calls to getProcessor. */
  public UnaryCallSettings<GetProcessorRequest, Processor> getProcessorSettings() {
    return ((DocumentProcessorServiceStubSettings) getStubSettings()).getProcessorSettings();
  }

  /** Returns the object with the settings used for calls to trainProcessorVersion. */
  public UnaryCallSettings<TrainProcessorVersionRequest, Operation>
      trainProcessorVersionSettings() {
    return ((DocumentProcessorServiceStubSettings) getStubSettings())
        .trainProcessorVersionSettings();
  }

  /** Returns the object with the settings used for calls to trainProcessorVersion. */
  public OperationCallSettings<
          TrainProcessorVersionRequest,
          TrainProcessorVersionResponse,
          TrainProcessorVersionMetadata>
      trainProcessorVersionOperationSettings() {
    return ((DocumentProcessorServiceStubSettings) getStubSettings())
        .trainProcessorVersionOperationSettings();
  }

  /** Returns the object with the settings used for calls to getProcessorVersion. */
  public UnaryCallSettings<GetProcessorVersionRequest, ProcessorVersion>
      getProcessorVersionSettings() {
    return ((DocumentProcessorServiceStubSettings) getStubSettings()).getProcessorVersionSettings();
  }

  /** Returns the object with the settings used for calls to listProcessorVersions. */
  public PagedCallSettings<
          ListProcessorVersionsRequest,
          ListProcessorVersionsResponse,
          ListProcessorVersionsPagedResponse>
      listProcessorVersionsSettings() {
    return ((DocumentProcessorServiceStubSettings) getStubSettings())
        .listProcessorVersionsSettings();
  }

  /** Returns the object with the settings used for calls to deleteProcessorVersion. */
  public UnaryCallSettings<DeleteProcessorVersionRequest, Operation>
      deleteProcessorVersionSettings() {
    return ((DocumentProcessorServiceStubSettings) getStubSettings())
        .deleteProcessorVersionSettings();
  }

  /** Returns the object with the settings used for calls to deleteProcessorVersion. */
  public OperationCallSettings<DeleteProcessorVersionRequest, Empty, DeleteProcessorVersionMetadata>
      deleteProcessorVersionOperationSettings() {
    return ((DocumentProcessorServiceStubSettings) getStubSettings())
        .deleteProcessorVersionOperationSettings();
  }

  /** Returns the object with the settings used for calls to deployProcessorVersion. */
  public UnaryCallSettings<DeployProcessorVersionRequest, Operation>
      deployProcessorVersionSettings() {
    return ((DocumentProcessorServiceStubSettings) getStubSettings())
        .deployProcessorVersionSettings();
  }

  /** Returns the object with the settings used for calls to deployProcessorVersion. */
  public OperationCallSettings<
          DeployProcessorVersionRequest,
          DeployProcessorVersionResponse,
          DeployProcessorVersionMetadata>
      deployProcessorVersionOperationSettings() {
    return ((DocumentProcessorServiceStubSettings) getStubSettings())
        .deployProcessorVersionOperationSettings();
  }

  /** Returns the object with the settings used for calls to undeployProcessorVersion. */
  public UnaryCallSettings<UndeployProcessorVersionRequest, Operation>
      undeployProcessorVersionSettings() {
    return ((DocumentProcessorServiceStubSettings) getStubSettings())
        .undeployProcessorVersionSettings();
  }

  /** Returns the object with the settings used for calls to undeployProcessorVersion. */
  public OperationCallSettings<
          UndeployProcessorVersionRequest,
          UndeployProcessorVersionResponse,
          UndeployProcessorVersionMetadata>
      undeployProcessorVersionOperationSettings() {
    return ((DocumentProcessorServiceStubSettings) getStubSettings())
        .undeployProcessorVersionOperationSettings();
  }

  /** Returns the object with the settings used for calls to createProcessor. */
  public UnaryCallSettings<CreateProcessorRequest, Processor> createProcessorSettings() {
    return ((DocumentProcessorServiceStubSettings) getStubSettings()).createProcessorSettings();
  }

  /** Returns the object with the settings used for calls to deleteProcessor. */
  public UnaryCallSettings<DeleteProcessorRequest, Operation> deleteProcessorSettings() {
    return ((DocumentProcessorServiceStubSettings) getStubSettings()).deleteProcessorSettings();
  }

  /** Returns the object with the settings used for calls to deleteProcessor. */
  public OperationCallSettings<DeleteProcessorRequest, Empty, DeleteProcessorMetadata>
      deleteProcessorOperationSettings() {
    return ((DocumentProcessorServiceStubSettings) getStubSettings())
        .deleteProcessorOperationSettings();
  }

  /** Returns the object with the settings used for calls to enableProcessor. */
  public UnaryCallSettings<EnableProcessorRequest, Operation> enableProcessorSettings() {
    return ((DocumentProcessorServiceStubSettings) getStubSettings()).enableProcessorSettings();
  }

  /** Returns the object with the settings used for calls to enableProcessor. */
  public OperationCallSettings<
          EnableProcessorRequest, EnableProcessorResponse, EnableProcessorMetadata>
      enableProcessorOperationSettings() {
    return ((DocumentProcessorServiceStubSettings) getStubSettings())
        .enableProcessorOperationSettings();
  }

  /** Returns the object with the settings used for calls to disableProcessor. */
  public UnaryCallSettings<DisableProcessorRequest, Operation> disableProcessorSettings() {
    return ((DocumentProcessorServiceStubSettings) getStubSettings()).disableProcessorSettings();
  }

  /** Returns the object with the settings used for calls to disableProcessor. */
  public OperationCallSettings<
          DisableProcessorRequest, DisableProcessorResponse, DisableProcessorMetadata>
      disableProcessorOperationSettings() {
    return ((DocumentProcessorServiceStubSettings) getStubSettings())
        .disableProcessorOperationSettings();
  }

  /** Returns the object with the settings used for calls to setDefaultProcessorVersion. */
  public UnaryCallSettings<SetDefaultProcessorVersionRequest, Operation>
      setDefaultProcessorVersionSettings() {
    return ((DocumentProcessorServiceStubSettings) getStubSettings())
        .setDefaultProcessorVersionSettings();
  }

  /** Returns the object with the settings used for calls to setDefaultProcessorVersion. */
  public OperationCallSettings<
          SetDefaultProcessorVersionRequest,
          SetDefaultProcessorVersionResponse,
          SetDefaultProcessorVersionMetadata>
      setDefaultProcessorVersionOperationSettings() {
    return ((DocumentProcessorServiceStubSettings) getStubSettings())
        .setDefaultProcessorVersionOperationSettings();
  }

  /** Returns the object with the settings used for calls to reviewDocument. */
  public UnaryCallSettings<ReviewDocumentRequest, Operation> reviewDocumentSettings() {
    return ((DocumentProcessorServiceStubSettings) getStubSettings()).reviewDocumentSettings();
  }

  /** Returns the object with the settings used for calls to reviewDocument. */
  public OperationCallSettings<
          ReviewDocumentRequest, ReviewDocumentResponse, ReviewDocumentOperationMetadata>
      reviewDocumentOperationSettings() {
    return ((DocumentProcessorServiceStubSettings) getStubSettings())
        .reviewDocumentOperationSettings();
  }

  /** Returns the object with the settings used for calls to evaluateProcessorVersion. */
  public UnaryCallSettings<EvaluateProcessorVersionRequest, Operation>
      evaluateProcessorVersionSettings() {
    return ((DocumentProcessorServiceStubSettings) getStubSettings())
        .evaluateProcessorVersionSettings();
  }

  /** Returns the object with the settings used for calls to evaluateProcessorVersion. */
  public OperationCallSettings<
          EvaluateProcessorVersionRequest,
          EvaluateProcessorVersionResponse,
          EvaluateProcessorVersionMetadata>
      evaluateProcessorVersionOperationSettings() {
    return ((DocumentProcessorServiceStubSettings) getStubSettings())
        .evaluateProcessorVersionOperationSettings();
  }

  /** Returns the object with the settings used for calls to getEvaluation. */
  public UnaryCallSettings<GetEvaluationRequest, Evaluation> getEvaluationSettings() {
    return ((DocumentProcessorServiceStubSettings) getStubSettings()).getEvaluationSettings();
  }

  /** Returns the object with the settings used for calls to listEvaluations. */
  public PagedCallSettings<
          ListEvaluationsRequest, ListEvaluationsResponse, ListEvaluationsPagedResponse>
      listEvaluationsSettings() {
    return ((DocumentProcessorServiceStubSettings) getStubSettings()).listEvaluationsSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((DocumentProcessorServiceStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((DocumentProcessorServiceStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final DocumentProcessorServiceSettings create(
      DocumentProcessorServiceStubSettings stub) throws IOException {
    return new DocumentProcessorServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return DocumentProcessorServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return DocumentProcessorServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DocumentProcessorServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return DocumentProcessorServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return DocumentProcessorServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return DocumentProcessorServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return DocumentProcessorServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DocumentProcessorServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected DocumentProcessorServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for DocumentProcessorServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<DocumentProcessorServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(DocumentProcessorServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(DocumentProcessorServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(DocumentProcessorServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(DocumentProcessorServiceStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(DocumentProcessorServiceStubSettings.newHttpJsonBuilder());
    }

    public DocumentProcessorServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((DocumentProcessorServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to processDocument. */
    public UnaryCallSettings.Builder<ProcessRequest, ProcessResponse> processDocumentSettings() {
      return getStubSettingsBuilder().processDocumentSettings();
    }

    /** Returns the builder for the settings used for calls to batchProcessDocuments. */
    public UnaryCallSettings.Builder<BatchProcessRequest, Operation>
        batchProcessDocumentsSettings() {
      return getStubSettingsBuilder().batchProcessDocumentsSettings();
    }

    /** Returns the builder for the settings used for calls to batchProcessDocuments. */
    public OperationCallSettings.Builder<
            BatchProcessRequest, BatchProcessResponse, BatchProcessMetadata>
        batchProcessDocumentsOperationSettings() {
      return getStubSettingsBuilder().batchProcessDocumentsOperationSettings();
    }

    /** Returns the builder for the settings used for calls to fetchProcessorTypes. */
    public UnaryCallSettings.Builder<FetchProcessorTypesRequest, FetchProcessorTypesResponse>
        fetchProcessorTypesSettings() {
      return getStubSettingsBuilder().fetchProcessorTypesSettings();
    }

    /** Returns the builder for the settings used for calls to listProcessorTypes. */
    public PagedCallSettings.Builder<
            ListProcessorTypesRequest, ListProcessorTypesResponse, ListProcessorTypesPagedResponse>
        listProcessorTypesSettings() {
      return getStubSettingsBuilder().listProcessorTypesSettings();
    }

    /** Returns the builder for the settings used for calls to listProcessors. */
    public PagedCallSettings.Builder<
            ListProcessorsRequest, ListProcessorsResponse, ListProcessorsPagedResponse>
        listProcessorsSettings() {
      return getStubSettingsBuilder().listProcessorsSettings();
    }

    /** Returns the builder for the settings used for calls to getProcessor. */
    public UnaryCallSettings.Builder<GetProcessorRequest, Processor> getProcessorSettings() {
      return getStubSettingsBuilder().getProcessorSettings();
    }

    /** Returns the builder for the settings used for calls to trainProcessorVersion. */
    public UnaryCallSettings.Builder<TrainProcessorVersionRequest, Operation>
        trainProcessorVersionSettings() {
      return getStubSettingsBuilder().trainProcessorVersionSettings();
    }

    /** Returns the builder for the settings used for calls to trainProcessorVersion. */
    public OperationCallSettings.Builder<
            TrainProcessorVersionRequest,
            TrainProcessorVersionResponse,
            TrainProcessorVersionMetadata>
        trainProcessorVersionOperationSettings() {
      return getStubSettingsBuilder().trainProcessorVersionOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getProcessorVersion. */
    public UnaryCallSettings.Builder<GetProcessorVersionRequest, ProcessorVersion>
        getProcessorVersionSettings() {
      return getStubSettingsBuilder().getProcessorVersionSettings();
    }

    /** Returns the builder for the settings used for calls to listProcessorVersions. */
    public PagedCallSettings.Builder<
            ListProcessorVersionsRequest,
            ListProcessorVersionsResponse,
            ListProcessorVersionsPagedResponse>
        listProcessorVersionsSettings() {
      return getStubSettingsBuilder().listProcessorVersionsSettings();
    }

    /** Returns the builder for the settings used for calls to deleteProcessorVersion. */
    public UnaryCallSettings.Builder<DeleteProcessorVersionRequest, Operation>
        deleteProcessorVersionSettings() {
      return getStubSettingsBuilder().deleteProcessorVersionSettings();
    }

    /** Returns the builder for the settings used for calls to deleteProcessorVersion. */
    public OperationCallSettings.Builder<
            DeleteProcessorVersionRequest, Empty, DeleteProcessorVersionMetadata>
        deleteProcessorVersionOperationSettings() {
      return getStubSettingsBuilder().deleteProcessorVersionOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deployProcessorVersion. */
    public UnaryCallSettings.Builder<DeployProcessorVersionRequest, Operation>
        deployProcessorVersionSettings() {
      return getStubSettingsBuilder().deployProcessorVersionSettings();
    }

    /** Returns the builder for the settings used for calls to deployProcessorVersion. */
    public OperationCallSettings.Builder<
            DeployProcessorVersionRequest,
            DeployProcessorVersionResponse,
            DeployProcessorVersionMetadata>
        deployProcessorVersionOperationSettings() {
      return getStubSettingsBuilder().deployProcessorVersionOperationSettings();
    }

    /** Returns the builder for the settings used for calls to undeployProcessorVersion. */
    public UnaryCallSettings.Builder<UndeployProcessorVersionRequest, Operation>
        undeployProcessorVersionSettings() {
      return getStubSettingsBuilder().undeployProcessorVersionSettings();
    }

    /** Returns the builder for the settings used for calls to undeployProcessorVersion. */
    public OperationCallSettings.Builder<
            UndeployProcessorVersionRequest,
            UndeployProcessorVersionResponse,
            UndeployProcessorVersionMetadata>
        undeployProcessorVersionOperationSettings() {
      return getStubSettingsBuilder().undeployProcessorVersionOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createProcessor. */
    public UnaryCallSettings.Builder<CreateProcessorRequest, Processor> createProcessorSettings() {
      return getStubSettingsBuilder().createProcessorSettings();
    }

    /** Returns the builder for the settings used for calls to deleteProcessor. */
    public UnaryCallSettings.Builder<DeleteProcessorRequest, Operation> deleteProcessorSettings() {
      return getStubSettingsBuilder().deleteProcessorSettings();
    }

    /** Returns the builder for the settings used for calls to deleteProcessor. */
    public OperationCallSettings.Builder<DeleteProcessorRequest, Empty, DeleteProcessorMetadata>
        deleteProcessorOperationSettings() {
      return getStubSettingsBuilder().deleteProcessorOperationSettings();
    }

    /** Returns the builder for the settings used for calls to enableProcessor. */
    public UnaryCallSettings.Builder<EnableProcessorRequest, Operation> enableProcessorSettings() {
      return getStubSettingsBuilder().enableProcessorSettings();
    }

    /** Returns the builder for the settings used for calls to enableProcessor. */
    public OperationCallSettings.Builder<
            EnableProcessorRequest, EnableProcessorResponse, EnableProcessorMetadata>
        enableProcessorOperationSettings() {
      return getStubSettingsBuilder().enableProcessorOperationSettings();
    }

    /** Returns the builder for the settings used for calls to disableProcessor. */
    public UnaryCallSettings.Builder<DisableProcessorRequest, Operation>
        disableProcessorSettings() {
      return getStubSettingsBuilder().disableProcessorSettings();
    }

    /** Returns the builder for the settings used for calls to disableProcessor. */
    public OperationCallSettings.Builder<
            DisableProcessorRequest, DisableProcessorResponse, DisableProcessorMetadata>
        disableProcessorOperationSettings() {
      return getStubSettingsBuilder().disableProcessorOperationSettings();
    }

    /** Returns the builder for the settings used for calls to setDefaultProcessorVersion. */
    public UnaryCallSettings.Builder<SetDefaultProcessorVersionRequest, Operation>
        setDefaultProcessorVersionSettings() {
      return getStubSettingsBuilder().setDefaultProcessorVersionSettings();
    }

    /** Returns the builder for the settings used for calls to setDefaultProcessorVersion. */
    public OperationCallSettings.Builder<
            SetDefaultProcessorVersionRequest,
            SetDefaultProcessorVersionResponse,
            SetDefaultProcessorVersionMetadata>
        setDefaultProcessorVersionOperationSettings() {
      return getStubSettingsBuilder().setDefaultProcessorVersionOperationSettings();
    }

    /** Returns the builder for the settings used for calls to reviewDocument. */
    public UnaryCallSettings.Builder<ReviewDocumentRequest, Operation> reviewDocumentSettings() {
      return getStubSettingsBuilder().reviewDocumentSettings();
    }

    /** Returns the builder for the settings used for calls to reviewDocument. */
    public OperationCallSettings.Builder<
            ReviewDocumentRequest, ReviewDocumentResponse, ReviewDocumentOperationMetadata>
        reviewDocumentOperationSettings() {
      return getStubSettingsBuilder().reviewDocumentOperationSettings();
    }

    /** Returns the builder for the settings used for calls to evaluateProcessorVersion. */
    public UnaryCallSettings.Builder<EvaluateProcessorVersionRequest, Operation>
        evaluateProcessorVersionSettings() {
      return getStubSettingsBuilder().evaluateProcessorVersionSettings();
    }

    /** Returns the builder for the settings used for calls to evaluateProcessorVersion. */
    public OperationCallSettings.Builder<
            EvaluateProcessorVersionRequest,
            EvaluateProcessorVersionResponse,
            EvaluateProcessorVersionMetadata>
        evaluateProcessorVersionOperationSettings() {
      return getStubSettingsBuilder().evaluateProcessorVersionOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getEvaluation. */
    public UnaryCallSettings.Builder<GetEvaluationRequest, Evaluation> getEvaluationSettings() {
      return getStubSettingsBuilder().getEvaluationSettings();
    }

    /** Returns the builder for the settings used for calls to listEvaluations. */
    public PagedCallSettings.Builder<
            ListEvaluationsRequest, ListEvaluationsResponse, ListEvaluationsPagedResponse>
        listEvaluationsSettings() {
      return getStubSettingsBuilder().listEvaluationsSettings();
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
    public DocumentProcessorServiceSettings build() throws IOException {
      return new DocumentProcessorServiceSettings(this);
    }
  }
}
