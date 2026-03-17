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

package com.google.cloud.aiplatform.v1beta1;

import static com.google.cloud.aiplatform.v1beta1.VertexRagDataServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.VertexRagDataServiceClient.ListRagCorporaPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.VertexRagDataServiceClient.ListRagDataSchemasPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.VertexRagDataServiceClient.ListRagFilesPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.VertexRagDataServiceClient.ListRagMetadataPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
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
import com.google.cloud.aiplatform.v1beta1.stub.VertexRagDataServiceStubSettings;
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

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link VertexRagDataServiceClient}.
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
 * of getRagCorpus:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * VertexRagDataServiceSettings.Builder vertexRagDataServiceSettingsBuilder =
 *     VertexRagDataServiceSettings.newBuilder();
 * vertexRagDataServiceSettingsBuilder
 *     .getRagCorpusSettings()
 *     .setRetrySettings(
 *         vertexRagDataServiceSettingsBuilder
 *             .getRagCorpusSettings()
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
 * VertexRagDataServiceSettings vertexRagDataServiceSettings =
 *     vertexRagDataServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createRagCorpus:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * VertexRagDataServiceSettings.Builder vertexRagDataServiceSettingsBuilder =
 *     VertexRagDataServiceSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * vertexRagDataServiceSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class VertexRagDataServiceSettings extends ClientSettings<VertexRagDataServiceSettings> {

  /** Returns the object with the settings used for calls to createRagCorpus. */
  public UnaryCallSettings<CreateRagCorpusRequest, Operation> createRagCorpusSettings() {
    return ((VertexRagDataServiceStubSettings) getStubSettings()).createRagCorpusSettings();
  }

  /** Returns the object with the settings used for calls to createRagCorpus. */
  public OperationCallSettings<CreateRagCorpusRequest, RagCorpus, CreateRagCorpusOperationMetadata>
      createRagCorpusOperationSettings() {
    return ((VertexRagDataServiceStubSettings) getStubSettings())
        .createRagCorpusOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateRagCorpus. */
  public UnaryCallSettings<UpdateRagCorpusRequest, Operation> updateRagCorpusSettings() {
    return ((VertexRagDataServiceStubSettings) getStubSettings()).updateRagCorpusSettings();
  }

  /** Returns the object with the settings used for calls to updateRagCorpus. */
  public OperationCallSettings<UpdateRagCorpusRequest, RagCorpus, UpdateRagCorpusOperationMetadata>
      updateRagCorpusOperationSettings() {
    return ((VertexRagDataServiceStubSettings) getStubSettings())
        .updateRagCorpusOperationSettings();
  }

  /** Returns the object with the settings used for calls to getRagCorpus. */
  public UnaryCallSettings<GetRagCorpusRequest, RagCorpus> getRagCorpusSettings() {
    return ((VertexRagDataServiceStubSettings) getStubSettings()).getRagCorpusSettings();
  }

  /** Returns the object with the settings used for calls to listRagCorpora. */
  public PagedCallSettings<
          ListRagCorporaRequest, ListRagCorporaResponse, ListRagCorporaPagedResponse>
      listRagCorporaSettings() {
    return ((VertexRagDataServiceStubSettings) getStubSettings()).listRagCorporaSettings();
  }

  /** Returns the object with the settings used for calls to deleteRagCorpus. */
  public UnaryCallSettings<DeleteRagCorpusRequest, Operation> deleteRagCorpusSettings() {
    return ((VertexRagDataServiceStubSettings) getStubSettings()).deleteRagCorpusSettings();
  }

  /** Returns the object with the settings used for calls to deleteRagCorpus. */
  public OperationCallSettings<DeleteRagCorpusRequest, Empty, DeleteOperationMetadata>
      deleteRagCorpusOperationSettings() {
    return ((VertexRagDataServiceStubSettings) getStubSettings())
        .deleteRagCorpusOperationSettings();
  }

  /** Returns the object with the settings used for calls to uploadRagFile. */
  public UnaryCallSettings<UploadRagFileRequest, UploadRagFileResponse> uploadRagFileSettings() {
    return ((VertexRagDataServiceStubSettings) getStubSettings()).uploadRagFileSettings();
  }

  /** Returns the object with the settings used for calls to importRagFiles. */
  public UnaryCallSettings<ImportRagFilesRequest, Operation> importRagFilesSettings() {
    return ((VertexRagDataServiceStubSettings) getStubSettings()).importRagFilesSettings();
  }

  /** Returns the object with the settings used for calls to importRagFiles. */
  public OperationCallSettings<
          ImportRagFilesRequest, ImportRagFilesResponse, ImportRagFilesOperationMetadata>
      importRagFilesOperationSettings() {
    return ((VertexRagDataServiceStubSettings) getStubSettings()).importRagFilesOperationSettings();
  }

  /** Returns the object with the settings used for calls to getRagFile. */
  public UnaryCallSettings<GetRagFileRequest, RagFile> getRagFileSettings() {
    return ((VertexRagDataServiceStubSettings) getStubSettings()).getRagFileSettings();
  }

  /** Returns the object with the settings used for calls to listRagFiles. */
  public PagedCallSettings<ListRagFilesRequest, ListRagFilesResponse, ListRagFilesPagedResponse>
      listRagFilesSettings() {
    return ((VertexRagDataServiceStubSettings) getStubSettings()).listRagFilesSettings();
  }

  /** Returns the object with the settings used for calls to deleteRagFile. */
  public UnaryCallSettings<DeleteRagFileRequest, Operation> deleteRagFileSettings() {
    return ((VertexRagDataServiceStubSettings) getStubSettings()).deleteRagFileSettings();
  }

  /** Returns the object with the settings used for calls to deleteRagFile. */
  public OperationCallSettings<DeleteRagFileRequest, Empty, DeleteOperationMetadata>
      deleteRagFileOperationSettings() {
    return ((VertexRagDataServiceStubSettings) getStubSettings()).deleteRagFileOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateRagEngineConfig. */
  public UnaryCallSettings<UpdateRagEngineConfigRequest, Operation>
      updateRagEngineConfigSettings() {
    return ((VertexRagDataServiceStubSettings) getStubSettings()).updateRagEngineConfigSettings();
  }

  /** Returns the object with the settings used for calls to updateRagEngineConfig. */
  public OperationCallSettings<
          UpdateRagEngineConfigRequest, RagEngineConfig, UpdateRagEngineConfigOperationMetadata>
      updateRagEngineConfigOperationSettings() {
    return ((VertexRagDataServiceStubSettings) getStubSettings())
        .updateRagEngineConfigOperationSettings();
  }

  /** Returns the object with the settings used for calls to getRagEngineConfig. */
  public UnaryCallSettings<GetRagEngineConfigRequest, RagEngineConfig>
      getRagEngineConfigSettings() {
    return ((VertexRagDataServiceStubSettings) getStubSettings()).getRagEngineConfigSettings();
  }

  /** Returns the object with the settings used for calls to createRagDataSchema. */
  public UnaryCallSettings<CreateRagDataSchemaRequest, RagDataSchema>
      createRagDataSchemaSettings() {
    return ((VertexRagDataServiceStubSettings) getStubSettings()).createRagDataSchemaSettings();
  }

  /** Returns the object with the settings used for calls to batchCreateRagDataSchemas. */
  public UnaryCallSettings<BatchCreateRagDataSchemasRequest, Operation>
      batchCreateRagDataSchemasSettings() {
    return ((VertexRagDataServiceStubSettings) getStubSettings())
        .batchCreateRagDataSchemasSettings();
  }

  /** Returns the object with the settings used for calls to batchCreateRagDataSchemas. */
  public OperationCallSettings<
          BatchCreateRagDataSchemasRequest,
          BatchCreateRagDataSchemasResponse,
          BatchCreateRagDataSchemasOperationMetadata>
      batchCreateRagDataSchemasOperationSettings() {
    return ((VertexRagDataServiceStubSettings) getStubSettings())
        .batchCreateRagDataSchemasOperationSettings();
  }

  /** Returns the object with the settings used for calls to getRagDataSchema. */
  public UnaryCallSettings<GetRagDataSchemaRequest, RagDataSchema> getRagDataSchemaSettings() {
    return ((VertexRagDataServiceStubSettings) getStubSettings()).getRagDataSchemaSettings();
  }

  /** Returns the object with the settings used for calls to listRagDataSchemas. */
  public PagedCallSettings<
          ListRagDataSchemasRequest, ListRagDataSchemasResponse, ListRagDataSchemasPagedResponse>
      listRagDataSchemasSettings() {
    return ((VertexRagDataServiceStubSettings) getStubSettings()).listRagDataSchemasSettings();
  }

  /** Returns the object with the settings used for calls to deleteRagDataSchema. */
  public UnaryCallSettings<DeleteRagDataSchemaRequest, Empty> deleteRagDataSchemaSettings() {
    return ((VertexRagDataServiceStubSettings) getStubSettings()).deleteRagDataSchemaSettings();
  }

  /** Returns the object with the settings used for calls to batchDeleteRagDataSchemas. */
  public UnaryCallSettings<BatchDeleteRagDataSchemasRequest, Operation>
      batchDeleteRagDataSchemasSettings() {
    return ((VertexRagDataServiceStubSettings) getStubSettings())
        .batchDeleteRagDataSchemasSettings();
  }

  /** Returns the object with the settings used for calls to batchDeleteRagDataSchemas. */
  public OperationCallSettings<BatchDeleteRagDataSchemasRequest, Empty, DeleteOperationMetadata>
      batchDeleteRagDataSchemasOperationSettings() {
    return ((VertexRagDataServiceStubSettings) getStubSettings())
        .batchDeleteRagDataSchemasOperationSettings();
  }

  /** Returns the object with the settings used for calls to createRagMetadata. */
  public UnaryCallSettings<CreateRagMetadataRequest, RagMetadata> createRagMetadataSettings() {
    return ((VertexRagDataServiceStubSettings) getStubSettings()).createRagMetadataSettings();
  }

  /** Returns the object with the settings used for calls to batchCreateRagMetadata. */
  public UnaryCallSettings<BatchCreateRagMetadataRequest, Operation>
      batchCreateRagMetadataSettings() {
    return ((VertexRagDataServiceStubSettings) getStubSettings()).batchCreateRagMetadataSettings();
  }

  /** Returns the object with the settings used for calls to batchCreateRagMetadata. */
  public OperationCallSettings<
          BatchCreateRagMetadataRequest,
          BatchCreateRagMetadataResponse,
          BatchCreateRagMetadataOperationMetadata>
      batchCreateRagMetadataOperationSettings() {
    return ((VertexRagDataServiceStubSettings) getStubSettings())
        .batchCreateRagMetadataOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateRagMetadata. */
  public UnaryCallSettings<UpdateRagMetadataRequest, RagMetadata> updateRagMetadataSettings() {
    return ((VertexRagDataServiceStubSettings) getStubSettings()).updateRagMetadataSettings();
  }

  /** Returns the object with the settings used for calls to getRagMetadata. */
  public UnaryCallSettings<GetRagMetadataRequest, RagMetadata> getRagMetadataSettings() {
    return ((VertexRagDataServiceStubSettings) getStubSettings()).getRagMetadataSettings();
  }

  /** Returns the object with the settings used for calls to listRagMetadata. */
  public PagedCallSettings<
          ListRagMetadataRequest, ListRagMetadataResponse, ListRagMetadataPagedResponse>
      listRagMetadataSettings() {
    return ((VertexRagDataServiceStubSettings) getStubSettings()).listRagMetadataSettings();
  }

  /** Returns the object with the settings used for calls to deleteRagMetadata. */
  public UnaryCallSettings<DeleteRagMetadataRequest, Empty> deleteRagMetadataSettings() {
    return ((VertexRagDataServiceStubSettings) getStubSettings()).deleteRagMetadataSettings();
  }

  /** Returns the object with the settings used for calls to batchDeleteRagMetadata. */
  public UnaryCallSettings<BatchDeleteRagMetadataRequest, Operation>
      batchDeleteRagMetadataSettings() {
    return ((VertexRagDataServiceStubSettings) getStubSettings()).batchDeleteRagMetadataSettings();
  }

  /** Returns the object with the settings used for calls to batchDeleteRagMetadata. */
  public OperationCallSettings<BatchDeleteRagMetadataRequest, Empty, DeleteOperationMetadata>
      batchDeleteRagMetadataOperationSettings() {
    return ((VertexRagDataServiceStubSettings) getStubSettings())
        .batchDeleteRagMetadataOperationSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((VertexRagDataServiceStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((VertexRagDataServiceStubSettings) getStubSettings()).getLocationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((VertexRagDataServiceStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((VertexRagDataServiceStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((VertexRagDataServiceStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final VertexRagDataServiceSettings create(VertexRagDataServiceStubSettings stub)
      throws IOException {
    return new VertexRagDataServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return VertexRagDataServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return VertexRagDataServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return VertexRagDataServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return VertexRagDataServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return VertexRagDataServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return VertexRagDataServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return VertexRagDataServiceStubSettings.defaultApiClientHeaderProviderBuilder();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected VertexRagDataServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for VertexRagDataServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<VertexRagDataServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(VertexRagDataServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(VertexRagDataServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(VertexRagDataServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(VertexRagDataServiceStubSettings.newBuilder());
    }

    public VertexRagDataServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((VertexRagDataServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createRagCorpus. */
    public UnaryCallSettings.Builder<CreateRagCorpusRequest, Operation> createRagCorpusSettings() {
      return getStubSettingsBuilder().createRagCorpusSettings();
    }

    /** Returns the builder for the settings used for calls to createRagCorpus. */
    public OperationCallSettings.Builder<
            CreateRagCorpusRequest, RagCorpus, CreateRagCorpusOperationMetadata>
        createRagCorpusOperationSettings() {
      return getStubSettingsBuilder().createRagCorpusOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateRagCorpus. */
    public UnaryCallSettings.Builder<UpdateRagCorpusRequest, Operation> updateRagCorpusSettings() {
      return getStubSettingsBuilder().updateRagCorpusSettings();
    }

    /** Returns the builder for the settings used for calls to updateRagCorpus. */
    public OperationCallSettings.Builder<
            UpdateRagCorpusRequest, RagCorpus, UpdateRagCorpusOperationMetadata>
        updateRagCorpusOperationSettings() {
      return getStubSettingsBuilder().updateRagCorpusOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getRagCorpus. */
    public UnaryCallSettings.Builder<GetRagCorpusRequest, RagCorpus> getRagCorpusSettings() {
      return getStubSettingsBuilder().getRagCorpusSettings();
    }

    /** Returns the builder for the settings used for calls to listRagCorpora. */
    public PagedCallSettings.Builder<
            ListRagCorporaRequest, ListRagCorporaResponse, ListRagCorporaPagedResponse>
        listRagCorporaSettings() {
      return getStubSettingsBuilder().listRagCorporaSettings();
    }

    /** Returns the builder for the settings used for calls to deleteRagCorpus. */
    public UnaryCallSettings.Builder<DeleteRagCorpusRequest, Operation> deleteRagCorpusSettings() {
      return getStubSettingsBuilder().deleteRagCorpusSettings();
    }

    /** Returns the builder for the settings used for calls to deleteRagCorpus. */
    public OperationCallSettings.Builder<DeleteRagCorpusRequest, Empty, DeleteOperationMetadata>
        deleteRagCorpusOperationSettings() {
      return getStubSettingsBuilder().deleteRagCorpusOperationSettings();
    }

    /** Returns the builder for the settings used for calls to uploadRagFile. */
    public UnaryCallSettings.Builder<UploadRagFileRequest, UploadRagFileResponse>
        uploadRagFileSettings() {
      return getStubSettingsBuilder().uploadRagFileSettings();
    }

    /** Returns the builder for the settings used for calls to importRagFiles. */
    public UnaryCallSettings.Builder<ImportRagFilesRequest, Operation> importRagFilesSettings() {
      return getStubSettingsBuilder().importRagFilesSettings();
    }

    /** Returns the builder for the settings used for calls to importRagFiles. */
    public OperationCallSettings.Builder<
            ImportRagFilesRequest, ImportRagFilesResponse, ImportRagFilesOperationMetadata>
        importRagFilesOperationSettings() {
      return getStubSettingsBuilder().importRagFilesOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getRagFile. */
    public UnaryCallSettings.Builder<GetRagFileRequest, RagFile> getRagFileSettings() {
      return getStubSettingsBuilder().getRagFileSettings();
    }

    /** Returns the builder for the settings used for calls to listRagFiles. */
    public PagedCallSettings.Builder<
            ListRagFilesRequest, ListRagFilesResponse, ListRagFilesPagedResponse>
        listRagFilesSettings() {
      return getStubSettingsBuilder().listRagFilesSettings();
    }

    /** Returns the builder for the settings used for calls to deleteRagFile. */
    public UnaryCallSettings.Builder<DeleteRagFileRequest, Operation> deleteRagFileSettings() {
      return getStubSettingsBuilder().deleteRagFileSettings();
    }

    /** Returns the builder for the settings used for calls to deleteRagFile. */
    public OperationCallSettings.Builder<DeleteRagFileRequest, Empty, DeleteOperationMetadata>
        deleteRagFileOperationSettings() {
      return getStubSettingsBuilder().deleteRagFileOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateRagEngineConfig. */
    public UnaryCallSettings.Builder<UpdateRagEngineConfigRequest, Operation>
        updateRagEngineConfigSettings() {
      return getStubSettingsBuilder().updateRagEngineConfigSettings();
    }

    /** Returns the builder for the settings used for calls to updateRagEngineConfig. */
    public OperationCallSettings.Builder<
            UpdateRagEngineConfigRequest, RagEngineConfig, UpdateRagEngineConfigOperationMetadata>
        updateRagEngineConfigOperationSettings() {
      return getStubSettingsBuilder().updateRagEngineConfigOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getRagEngineConfig. */
    public UnaryCallSettings.Builder<GetRagEngineConfigRequest, RagEngineConfig>
        getRagEngineConfigSettings() {
      return getStubSettingsBuilder().getRagEngineConfigSettings();
    }

    /** Returns the builder for the settings used for calls to createRagDataSchema. */
    public UnaryCallSettings.Builder<CreateRagDataSchemaRequest, RagDataSchema>
        createRagDataSchemaSettings() {
      return getStubSettingsBuilder().createRagDataSchemaSettings();
    }

    /** Returns the builder for the settings used for calls to batchCreateRagDataSchemas. */
    public UnaryCallSettings.Builder<BatchCreateRagDataSchemasRequest, Operation>
        batchCreateRagDataSchemasSettings() {
      return getStubSettingsBuilder().batchCreateRagDataSchemasSettings();
    }

    /** Returns the builder for the settings used for calls to batchCreateRagDataSchemas. */
    public OperationCallSettings.Builder<
            BatchCreateRagDataSchemasRequest,
            BatchCreateRagDataSchemasResponse,
            BatchCreateRagDataSchemasOperationMetadata>
        batchCreateRagDataSchemasOperationSettings() {
      return getStubSettingsBuilder().batchCreateRagDataSchemasOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getRagDataSchema. */
    public UnaryCallSettings.Builder<GetRagDataSchemaRequest, RagDataSchema>
        getRagDataSchemaSettings() {
      return getStubSettingsBuilder().getRagDataSchemaSettings();
    }

    /** Returns the builder for the settings used for calls to listRagDataSchemas. */
    public PagedCallSettings.Builder<
            ListRagDataSchemasRequest, ListRagDataSchemasResponse, ListRagDataSchemasPagedResponse>
        listRagDataSchemasSettings() {
      return getStubSettingsBuilder().listRagDataSchemasSettings();
    }

    /** Returns the builder for the settings used for calls to deleteRagDataSchema. */
    public UnaryCallSettings.Builder<DeleteRagDataSchemaRequest, Empty>
        deleteRagDataSchemaSettings() {
      return getStubSettingsBuilder().deleteRagDataSchemaSettings();
    }

    /** Returns the builder for the settings used for calls to batchDeleteRagDataSchemas. */
    public UnaryCallSettings.Builder<BatchDeleteRagDataSchemasRequest, Operation>
        batchDeleteRagDataSchemasSettings() {
      return getStubSettingsBuilder().batchDeleteRagDataSchemasSettings();
    }

    /** Returns the builder for the settings used for calls to batchDeleteRagDataSchemas. */
    public OperationCallSettings.Builder<
            BatchDeleteRagDataSchemasRequest, Empty, DeleteOperationMetadata>
        batchDeleteRagDataSchemasOperationSettings() {
      return getStubSettingsBuilder().batchDeleteRagDataSchemasOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createRagMetadata. */
    public UnaryCallSettings.Builder<CreateRagMetadataRequest, RagMetadata>
        createRagMetadataSettings() {
      return getStubSettingsBuilder().createRagMetadataSettings();
    }

    /** Returns the builder for the settings used for calls to batchCreateRagMetadata. */
    public UnaryCallSettings.Builder<BatchCreateRagMetadataRequest, Operation>
        batchCreateRagMetadataSettings() {
      return getStubSettingsBuilder().batchCreateRagMetadataSettings();
    }

    /** Returns the builder for the settings used for calls to batchCreateRagMetadata. */
    public OperationCallSettings.Builder<
            BatchCreateRagMetadataRequest,
            BatchCreateRagMetadataResponse,
            BatchCreateRagMetadataOperationMetadata>
        batchCreateRagMetadataOperationSettings() {
      return getStubSettingsBuilder().batchCreateRagMetadataOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateRagMetadata. */
    public UnaryCallSettings.Builder<UpdateRagMetadataRequest, RagMetadata>
        updateRagMetadataSettings() {
      return getStubSettingsBuilder().updateRagMetadataSettings();
    }

    /** Returns the builder for the settings used for calls to getRagMetadata. */
    public UnaryCallSettings.Builder<GetRagMetadataRequest, RagMetadata> getRagMetadataSettings() {
      return getStubSettingsBuilder().getRagMetadataSettings();
    }

    /** Returns the builder for the settings used for calls to listRagMetadata. */
    public PagedCallSettings.Builder<
            ListRagMetadataRequest, ListRagMetadataResponse, ListRagMetadataPagedResponse>
        listRagMetadataSettings() {
      return getStubSettingsBuilder().listRagMetadataSettings();
    }

    /** Returns the builder for the settings used for calls to deleteRagMetadata. */
    public UnaryCallSettings.Builder<DeleteRagMetadataRequest, Empty> deleteRagMetadataSettings() {
      return getStubSettingsBuilder().deleteRagMetadataSettings();
    }

    /** Returns the builder for the settings used for calls to batchDeleteRagMetadata. */
    public UnaryCallSettings.Builder<BatchDeleteRagMetadataRequest, Operation>
        batchDeleteRagMetadataSettings() {
      return getStubSettingsBuilder().batchDeleteRagMetadataSettings();
    }

    /** Returns the builder for the settings used for calls to batchDeleteRagMetadata. */
    public OperationCallSettings.Builder<
            BatchDeleteRagMetadataRequest, Empty, DeleteOperationMetadata>
        batchDeleteRagMetadataOperationSettings() {
      return getStubSettingsBuilder().batchDeleteRagMetadataOperationSettings();
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
    public VertexRagDataServiceSettings build() throws IOException {
      return new VertexRagDataServiceSettings(this);
    }
  }
}
