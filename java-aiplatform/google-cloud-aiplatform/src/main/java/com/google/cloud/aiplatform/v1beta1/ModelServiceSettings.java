/*
 * Copyright 2020 Google LLC
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

import static com.google.cloud.aiplatform.v1beta1.ModelServiceClient.ListModelEvaluationSlicesPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.ModelServiceClient.ListModelEvaluationsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.ModelServiceClient.ListModelsPagedResponse;

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
import com.google.cloud.aiplatform.v1beta1.stub.ModelServiceStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ModelServiceClient}.
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
 * <p>For example, to set the total timeout of getModel to 30 seconds:
 *
 * <pre>{@code
 * ModelServiceSettings.Builder modelServiceSettingsBuilder = ModelServiceSettings.newBuilder();
 * modelServiceSettingsBuilder
 *     .getModelSettings()
 *     .setRetrySettings(
 *         modelServiceSettingsBuilder
 *             .getModelSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ModelServiceSettings modelServiceSettings = modelServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class ModelServiceSettings extends ClientSettings<ModelServiceSettings> {

  /** Returns the object with the settings used for calls to uploadModel. */
  public UnaryCallSettings<UploadModelRequest, Operation> uploadModelSettings() {
    return ((ModelServiceStubSettings) getStubSettings()).uploadModelSettings();
  }

  /** Returns the object with the settings used for calls to uploadModel. */
  public OperationCallSettings<
          UploadModelRequest, UploadModelResponse, UploadModelOperationMetadata>
      uploadModelOperationSettings() {
    return ((ModelServiceStubSettings) getStubSettings()).uploadModelOperationSettings();
  }

  /** Returns the object with the settings used for calls to getModel. */
  public UnaryCallSettings<GetModelRequest, Model> getModelSettings() {
    return ((ModelServiceStubSettings) getStubSettings()).getModelSettings();
  }

  /** Returns the object with the settings used for calls to listModels. */
  public PagedCallSettings<ListModelsRequest, ListModelsResponse, ListModelsPagedResponse>
      listModelsSettings() {
    return ((ModelServiceStubSettings) getStubSettings()).listModelsSettings();
  }

  /** Returns the object with the settings used for calls to updateModel. */
  public UnaryCallSettings<UpdateModelRequest, Model> updateModelSettings() {
    return ((ModelServiceStubSettings) getStubSettings()).updateModelSettings();
  }

  /** Returns the object with the settings used for calls to deleteModel. */
  public UnaryCallSettings<DeleteModelRequest, Operation> deleteModelSettings() {
    return ((ModelServiceStubSettings) getStubSettings()).deleteModelSettings();
  }

  /** Returns the object with the settings used for calls to deleteModel. */
  public OperationCallSettings<DeleteModelRequest, Empty, DeleteOperationMetadata>
      deleteModelOperationSettings() {
    return ((ModelServiceStubSettings) getStubSettings()).deleteModelOperationSettings();
  }

  /** Returns the object with the settings used for calls to exportModel. */
  public UnaryCallSettings<ExportModelRequest, Operation> exportModelSettings() {
    return ((ModelServiceStubSettings) getStubSettings()).exportModelSettings();
  }

  /** Returns the object with the settings used for calls to exportModel. */
  public OperationCallSettings<
          ExportModelRequest, ExportModelResponse, ExportModelOperationMetadata>
      exportModelOperationSettings() {
    return ((ModelServiceStubSettings) getStubSettings()).exportModelOperationSettings();
  }

  /** Returns the object with the settings used for calls to getModelEvaluation. */
  public UnaryCallSettings<GetModelEvaluationRequest, ModelEvaluation>
      getModelEvaluationSettings() {
    return ((ModelServiceStubSettings) getStubSettings()).getModelEvaluationSettings();
  }

  /** Returns the object with the settings used for calls to listModelEvaluations. */
  public PagedCallSettings<
          ListModelEvaluationsRequest,
          ListModelEvaluationsResponse,
          ListModelEvaluationsPagedResponse>
      listModelEvaluationsSettings() {
    return ((ModelServiceStubSettings) getStubSettings()).listModelEvaluationsSettings();
  }

  /** Returns the object with the settings used for calls to getModelEvaluationSlice. */
  public UnaryCallSettings<GetModelEvaluationSliceRequest, ModelEvaluationSlice>
      getModelEvaluationSliceSettings() {
    return ((ModelServiceStubSettings) getStubSettings()).getModelEvaluationSliceSettings();
  }

  /** Returns the object with the settings used for calls to listModelEvaluationSlices. */
  public PagedCallSettings<
          ListModelEvaluationSlicesRequest,
          ListModelEvaluationSlicesResponse,
          ListModelEvaluationSlicesPagedResponse>
      listModelEvaluationSlicesSettings() {
    return ((ModelServiceStubSettings) getStubSettings()).listModelEvaluationSlicesSettings();
  }

  public static final ModelServiceSettings create(ModelServiceStubSettings stub)
      throws IOException {
    return new ModelServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return ModelServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return ModelServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return ModelServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return ModelServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return ModelServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return ModelServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ModelServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected ModelServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for ModelServiceSettings. */
  public static class Builder extends ClientSettings.Builder<ModelServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(ModelServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(ModelServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(ModelServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(ModelServiceStubSettings.newBuilder());
    }

    public ModelServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((ModelServiceStubSettings.Builder) getStubSettings());
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'.
    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) throws Exception {
      super.applyToAllUnaryMethods(
          getStubSettingsBuilder().unaryMethodSettingsBuilders(), settingsUpdater);
      return this;
    }

    /** Returns the builder for the settings used for calls to uploadModel. */
    public UnaryCallSettings.Builder<UploadModelRequest, Operation> uploadModelSettings() {
      return getStubSettingsBuilder().uploadModelSettings();
    }

    /** Returns the builder for the settings used for calls to uploadModel. */
    public OperationCallSettings.Builder<
            UploadModelRequest, UploadModelResponse, UploadModelOperationMetadata>
        uploadModelOperationSettings() {
      return getStubSettingsBuilder().uploadModelOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getModel. */
    public UnaryCallSettings.Builder<GetModelRequest, Model> getModelSettings() {
      return getStubSettingsBuilder().getModelSettings();
    }

    /** Returns the builder for the settings used for calls to listModels. */
    public PagedCallSettings.Builder<ListModelsRequest, ListModelsResponse, ListModelsPagedResponse>
        listModelsSettings() {
      return getStubSettingsBuilder().listModelsSettings();
    }

    /** Returns the builder for the settings used for calls to updateModel. */
    public UnaryCallSettings.Builder<UpdateModelRequest, Model> updateModelSettings() {
      return getStubSettingsBuilder().updateModelSettings();
    }

    /** Returns the builder for the settings used for calls to deleteModel. */
    public UnaryCallSettings.Builder<DeleteModelRequest, Operation> deleteModelSettings() {
      return getStubSettingsBuilder().deleteModelSettings();
    }

    /** Returns the builder for the settings used for calls to deleteModel. */
    public OperationCallSettings.Builder<DeleteModelRequest, Empty, DeleteOperationMetadata>
        deleteModelOperationSettings() {
      return getStubSettingsBuilder().deleteModelOperationSettings();
    }

    /** Returns the builder for the settings used for calls to exportModel. */
    public UnaryCallSettings.Builder<ExportModelRequest, Operation> exportModelSettings() {
      return getStubSettingsBuilder().exportModelSettings();
    }

    /** Returns the builder for the settings used for calls to exportModel. */
    public OperationCallSettings.Builder<
            ExportModelRequest, ExportModelResponse, ExportModelOperationMetadata>
        exportModelOperationSettings() {
      return getStubSettingsBuilder().exportModelOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getModelEvaluation. */
    public UnaryCallSettings.Builder<GetModelEvaluationRequest, ModelEvaluation>
        getModelEvaluationSettings() {
      return getStubSettingsBuilder().getModelEvaluationSettings();
    }

    /** Returns the builder for the settings used for calls to listModelEvaluations. */
    public PagedCallSettings.Builder<
            ListModelEvaluationsRequest,
            ListModelEvaluationsResponse,
            ListModelEvaluationsPagedResponse>
        listModelEvaluationsSettings() {
      return getStubSettingsBuilder().listModelEvaluationsSettings();
    }

    /** Returns the builder for the settings used for calls to getModelEvaluationSlice. */
    public UnaryCallSettings.Builder<GetModelEvaluationSliceRequest, ModelEvaluationSlice>
        getModelEvaluationSliceSettings() {
      return getStubSettingsBuilder().getModelEvaluationSliceSettings();
    }

    /** Returns the builder for the settings used for calls to listModelEvaluationSlices. */
    public PagedCallSettings.Builder<
            ListModelEvaluationSlicesRequest,
            ListModelEvaluationSlicesResponse,
            ListModelEvaluationSlicesPagedResponse>
        listModelEvaluationSlicesSettings() {
      return getStubSettingsBuilder().listModelEvaluationSlicesSettings();
    }

    @Override
    public ModelServiceSettings build() throws IOException {
      return new ModelServiceSettings(this);
    }
  }
}
