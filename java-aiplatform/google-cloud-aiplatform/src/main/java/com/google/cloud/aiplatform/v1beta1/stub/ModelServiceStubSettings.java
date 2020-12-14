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

package com.google.cloud.aiplatform.v1beta1.stub;

import static com.google.cloud.aiplatform.v1beta1.ModelServiceClient.ListModelEvaluationSlicesPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.ModelServiceClient.ListModelEvaluationsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.ModelServiceClient.ListModelsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.grpc.ProtoOperationTransformers;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.longrunning.OperationTimedPollAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1beta1.DeleteModelRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.ExportModelOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.ExportModelRequest;
import com.google.cloud.aiplatform.v1beta1.ExportModelResponse;
import com.google.cloud.aiplatform.v1beta1.GetModelEvaluationRequest;
import com.google.cloud.aiplatform.v1beta1.GetModelEvaluationSliceRequest;
import com.google.cloud.aiplatform.v1beta1.GetModelRequest;
import com.google.cloud.aiplatform.v1beta1.ListModelEvaluationSlicesRequest;
import com.google.cloud.aiplatform.v1beta1.ListModelEvaluationSlicesResponse;
import com.google.cloud.aiplatform.v1beta1.ListModelEvaluationsRequest;
import com.google.cloud.aiplatform.v1beta1.ListModelEvaluationsResponse;
import com.google.cloud.aiplatform.v1beta1.ListModelsRequest;
import com.google.cloud.aiplatform.v1beta1.ListModelsResponse;
import com.google.cloud.aiplatform.v1beta1.Model;
import com.google.cloud.aiplatform.v1beta1.ModelEvaluation;
import com.google.cloud.aiplatform.v1beta1.ModelEvaluationSlice;
import com.google.cloud.aiplatform.v1beta1.UpdateModelRequest;
import com.google.cloud.aiplatform.v1beta1.UploadModelOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.UploadModelRequest;
import com.google.cloud.aiplatform.v1beta1.UploadModelResponse;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ModelServiceStub}.
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
 * ModelServiceStubSettings.Builder modelServiceSettingsBuilder =
 *     ModelServiceStubSettings.newBuilder();
 * modelServiceSettingsBuilder
 *     .getModelSettings()
 *     .setRetrySettings(
 *         modelServiceSettingsBuilder
 *             .getModelSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ModelServiceStubSettings modelServiceSettings = modelServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ModelServiceStubSettings extends StubSettings<ModelServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<UploadModelRequest, Operation> uploadModelSettings;
  private final OperationCallSettings<
          UploadModelRequest, UploadModelResponse, UploadModelOperationMetadata>
      uploadModelOperationSettings;
  private final UnaryCallSettings<GetModelRequest, Model> getModelSettings;
  private final PagedCallSettings<ListModelsRequest, ListModelsResponse, ListModelsPagedResponse>
      listModelsSettings;
  private final UnaryCallSettings<UpdateModelRequest, Model> updateModelSettings;
  private final UnaryCallSettings<DeleteModelRequest, Operation> deleteModelSettings;
  private final OperationCallSettings<DeleteModelRequest, Empty, DeleteOperationMetadata>
      deleteModelOperationSettings;
  private final UnaryCallSettings<ExportModelRequest, Operation> exportModelSettings;
  private final OperationCallSettings<
          ExportModelRequest, ExportModelResponse, ExportModelOperationMetadata>
      exportModelOperationSettings;
  private final UnaryCallSettings<GetModelEvaluationRequest, ModelEvaluation>
      getModelEvaluationSettings;
  private final PagedCallSettings<
          ListModelEvaluationsRequest,
          ListModelEvaluationsResponse,
          ListModelEvaluationsPagedResponse>
      listModelEvaluationsSettings;
  private final UnaryCallSettings<GetModelEvaluationSliceRequest, ModelEvaluationSlice>
      getModelEvaluationSliceSettings;
  private final PagedCallSettings<
          ListModelEvaluationSlicesRequest,
          ListModelEvaluationSlicesResponse,
          ListModelEvaluationSlicesPagedResponse>
      listModelEvaluationSlicesSettings;

  private static final PagedListDescriptor<ListModelsRequest, ListModelsResponse, Model>
      LIST_MODELS_PAGE_STR_DESC =
          new PagedListDescriptor<ListModelsRequest, ListModelsResponse, Model>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListModelsRequest injectToken(ListModelsRequest payload, String token) {
              return ListModelsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListModelsRequest injectPageSize(ListModelsRequest payload, int pageSize) {
              return ListModelsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListModelsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListModelsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Model> extractResources(ListModelsResponse payload) {
              return payload.getModelsList() == null
                  ? ImmutableList.<Model>of()
                  : payload.getModelsList();
            }
          };

  private static final PagedListDescriptor<
          ListModelEvaluationsRequest, ListModelEvaluationsResponse, ModelEvaluation>
      LIST_MODEL_EVALUATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListModelEvaluationsRequest, ListModelEvaluationsResponse, ModelEvaluation>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListModelEvaluationsRequest injectToken(
                ListModelEvaluationsRequest payload, String token) {
              return ListModelEvaluationsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListModelEvaluationsRequest injectPageSize(
                ListModelEvaluationsRequest payload, int pageSize) {
              return ListModelEvaluationsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListModelEvaluationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListModelEvaluationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ModelEvaluation> extractResources(
                ListModelEvaluationsResponse payload) {
              return payload.getModelEvaluationsList() == null
                  ? ImmutableList.<ModelEvaluation>of()
                  : payload.getModelEvaluationsList();
            }
          };

  private static final PagedListDescriptor<
          ListModelEvaluationSlicesRequest, ListModelEvaluationSlicesResponse, ModelEvaluationSlice>
      LIST_MODEL_EVALUATION_SLICES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListModelEvaluationSlicesRequest,
              ListModelEvaluationSlicesResponse,
              ModelEvaluationSlice>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListModelEvaluationSlicesRequest injectToken(
                ListModelEvaluationSlicesRequest payload, String token) {
              return ListModelEvaluationSlicesRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListModelEvaluationSlicesRequest injectPageSize(
                ListModelEvaluationSlicesRequest payload, int pageSize) {
              return ListModelEvaluationSlicesRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListModelEvaluationSlicesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListModelEvaluationSlicesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ModelEvaluationSlice> extractResources(
                ListModelEvaluationSlicesResponse payload) {
              return payload.getModelEvaluationSlicesList() == null
                  ? ImmutableList.<ModelEvaluationSlice>of()
                  : payload.getModelEvaluationSlicesList();
            }
          };

  private static final PagedListResponseFactory<
          ListModelsRequest, ListModelsResponse, ListModelsPagedResponse>
      LIST_MODELS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListModelsRequest, ListModelsResponse, ListModelsPagedResponse>() {
            @Override
            public ApiFuture<ListModelsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListModelsRequest, ListModelsResponse> callable,
                ListModelsRequest request,
                ApiCallContext context,
                ApiFuture<ListModelsResponse> futureResponse) {
              PageContext<ListModelsRequest, ListModelsResponse, Model> pageContext =
                  PageContext.create(callable, LIST_MODELS_PAGE_STR_DESC, request, context);
              return ListModelsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListModelEvaluationsRequest,
          ListModelEvaluationsResponse,
          ListModelEvaluationsPagedResponse>
      LIST_MODEL_EVALUATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListModelEvaluationsRequest,
              ListModelEvaluationsResponse,
              ListModelEvaluationsPagedResponse>() {
            @Override
            public ApiFuture<ListModelEvaluationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListModelEvaluationsRequest, ListModelEvaluationsResponse> callable,
                ListModelEvaluationsRequest request,
                ApiCallContext context,
                ApiFuture<ListModelEvaluationsResponse> futureResponse) {
              PageContext<
                      ListModelEvaluationsRequest, ListModelEvaluationsResponse, ModelEvaluation>
                  pageContext =
                      PageContext.create(
                          callable, LIST_MODEL_EVALUATIONS_PAGE_STR_DESC, request, context);
              return ListModelEvaluationsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListModelEvaluationSlicesRequest,
          ListModelEvaluationSlicesResponse,
          ListModelEvaluationSlicesPagedResponse>
      LIST_MODEL_EVALUATION_SLICES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListModelEvaluationSlicesRequest,
              ListModelEvaluationSlicesResponse,
              ListModelEvaluationSlicesPagedResponse>() {
            @Override
            public ApiFuture<ListModelEvaluationSlicesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListModelEvaluationSlicesRequest, ListModelEvaluationSlicesResponse>
                    callable,
                ListModelEvaluationSlicesRequest request,
                ApiCallContext context,
                ApiFuture<ListModelEvaluationSlicesResponse> futureResponse) {
              PageContext<
                      ListModelEvaluationSlicesRequest,
                      ListModelEvaluationSlicesResponse,
                      ModelEvaluationSlice>
                  pageContext =
                      PageContext.create(
                          callable, LIST_MODEL_EVALUATION_SLICES_PAGE_STR_DESC, request, context);
              return ListModelEvaluationSlicesPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to uploadModel. */
  public UnaryCallSettings<UploadModelRequest, Operation> uploadModelSettings() {
    return uploadModelSettings;
  }

  /** Returns the object with the settings used for calls to uploadModel. */
  public OperationCallSettings<
          UploadModelRequest, UploadModelResponse, UploadModelOperationMetadata>
      uploadModelOperationSettings() {
    return uploadModelOperationSettings;
  }

  /** Returns the object with the settings used for calls to getModel. */
  public UnaryCallSettings<GetModelRequest, Model> getModelSettings() {
    return getModelSettings;
  }

  /** Returns the object with the settings used for calls to listModels. */
  public PagedCallSettings<ListModelsRequest, ListModelsResponse, ListModelsPagedResponse>
      listModelsSettings() {
    return listModelsSettings;
  }

  /** Returns the object with the settings used for calls to updateModel. */
  public UnaryCallSettings<UpdateModelRequest, Model> updateModelSettings() {
    return updateModelSettings;
  }

  /** Returns the object with the settings used for calls to deleteModel. */
  public UnaryCallSettings<DeleteModelRequest, Operation> deleteModelSettings() {
    return deleteModelSettings;
  }

  /** Returns the object with the settings used for calls to deleteModel. */
  public OperationCallSettings<DeleteModelRequest, Empty, DeleteOperationMetadata>
      deleteModelOperationSettings() {
    return deleteModelOperationSettings;
  }

  /** Returns the object with the settings used for calls to exportModel. */
  public UnaryCallSettings<ExportModelRequest, Operation> exportModelSettings() {
    return exportModelSettings;
  }

  /** Returns the object with the settings used for calls to exportModel. */
  public OperationCallSettings<
          ExportModelRequest, ExportModelResponse, ExportModelOperationMetadata>
      exportModelOperationSettings() {
    return exportModelOperationSettings;
  }

  /** Returns the object with the settings used for calls to getModelEvaluation. */
  public UnaryCallSettings<GetModelEvaluationRequest, ModelEvaluation>
      getModelEvaluationSettings() {
    return getModelEvaluationSettings;
  }

  /** Returns the object with the settings used for calls to listModelEvaluations. */
  public PagedCallSettings<
          ListModelEvaluationsRequest,
          ListModelEvaluationsResponse,
          ListModelEvaluationsPagedResponse>
      listModelEvaluationsSettings() {
    return listModelEvaluationsSettings;
  }

  /** Returns the object with the settings used for calls to getModelEvaluationSlice. */
  public UnaryCallSettings<GetModelEvaluationSliceRequest, ModelEvaluationSlice>
      getModelEvaluationSliceSettings() {
    return getModelEvaluationSliceSettings;
  }

  /** Returns the object with the settings used for calls to listModelEvaluationSlices. */
  public PagedCallSettings<
          ListModelEvaluationSlicesRequest,
          ListModelEvaluationSlicesResponse,
          ListModelEvaluationSlicesPagedResponse>
      listModelEvaluationSlicesSettings() {
    return listModelEvaluationSlicesSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public ModelServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcModelServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "aiplatform.googleapis.com:443";
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder().setScopesToApply(DEFAULT_SERVICE_SCOPES);
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(ModelServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
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

  protected ModelServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    uploadModelSettings = settingsBuilder.uploadModelSettings().build();
    uploadModelOperationSettings = settingsBuilder.uploadModelOperationSettings().build();
    getModelSettings = settingsBuilder.getModelSettings().build();
    listModelsSettings = settingsBuilder.listModelsSettings().build();
    updateModelSettings = settingsBuilder.updateModelSettings().build();
    deleteModelSettings = settingsBuilder.deleteModelSettings().build();
    deleteModelOperationSettings = settingsBuilder.deleteModelOperationSettings().build();
    exportModelSettings = settingsBuilder.exportModelSettings().build();
    exportModelOperationSettings = settingsBuilder.exportModelOperationSettings().build();
    getModelEvaluationSettings = settingsBuilder.getModelEvaluationSettings().build();
    listModelEvaluationsSettings = settingsBuilder.listModelEvaluationsSettings().build();
    getModelEvaluationSliceSettings = settingsBuilder.getModelEvaluationSliceSettings().build();
    listModelEvaluationSlicesSettings = settingsBuilder.listModelEvaluationSlicesSettings().build();
  }

  /** Builder for ModelServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<ModelServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<UploadModelRequest, Operation> uploadModelSettings;
    private final OperationCallSettings.Builder<
            UploadModelRequest, UploadModelResponse, UploadModelOperationMetadata>
        uploadModelOperationSettings;
    private final UnaryCallSettings.Builder<GetModelRequest, Model> getModelSettings;
    private final PagedCallSettings.Builder<
            ListModelsRequest, ListModelsResponse, ListModelsPagedResponse>
        listModelsSettings;
    private final UnaryCallSettings.Builder<UpdateModelRequest, Model> updateModelSettings;
    private final UnaryCallSettings.Builder<DeleteModelRequest, Operation> deleteModelSettings;
    private final OperationCallSettings.Builder<DeleteModelRequest, Empty, DeleteOperationMetadata>
        deleteModelOperationSettings;
    private final UnaryCallSettings.Builder<ExportModelRequest, Operation> exportModelSettings;
    private final OperationCallSettings.Builder<
            ExportModelRequest, ExportModelResponse, ExportModelOperationMetadata>
        exportModelOperationSettings;
    private final UnaryCallSettings.Builder<GetModelEvaluationRequest, ModelEvaluation>
        getModelEvaluationSettings;
    private final PagedCallSettings.Builder<
            ListModelEvaluationsRequest,
            ListModelEvaluationsResponse,
            ListModelEvaluationsPagedResponse>
        listModelEvaluationsSettings;
    private final UnaryCallSettings.Builder<GetModelEvaluationSliceRequest, ModelEvaluationSlice>
        getModelEvaluationSliceSettings;
    private final PagedCallSettings.Builder<
            ListModelEvaluationSlicesRequest,
            ListModelEvaluationSlicesResponse,
            ListModelEvaluationSlicesPagedResponse>
        listModelEvaluationSlicesSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "no_retry_3_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(5000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(5000L))
              .setTotalTimeout(Duration.ofMillis(5000L))
              .build();
      definitions.put("no_retry_3_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      uploadModelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      uploadModelOperationSettings = OperationCallSettings.newBuilder();
      getModelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listModelsSettings = PagedCallSettings.newBuilder(LIST_MODELS_PAGE_STR_FACT);
      updateModelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteModelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteModelOperationSettings = OperationCallSettings.newBuilder();
      exportModelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      exportModelOperationSettings = OperationCallSettings.newBuilder();
      getModelEvaluationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listModelEvaluationsSettings =
          PagedCallSettings.newBuilder(LIST_MODEL_EVALUATIONS_PAGE_STR_FACT);
      getModelEvaluationSliceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listModelEvaluationSlicesSettings =
          PagedCallSettings.newBuilder(LIST_MODEL_EVALUATION_SLICES_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              uploadModelSettings,
              getModelSettings,
              listModelsSettings,
              updateModelSettings,
              deleteModelSettings,
              exportModelSettings,
              getModelEvaluationSettings,
              listModelEvaluationsSettings,
              getModelEvaluationSliceSettings,
              listModelEvaluationSlicesSettings);
      initDefaults(this);
    }

    protected Builder(ModelServiceStubSettings settings) {
      super(settings);

      uploadModelSettings = settings.uploadModelSettings.toBuilder();
      uploadModelOperationSettings = settings.uploadModelOperationSettings.toBuilder();
      getModelSettings = settings.getModelSettings.toBuilder();
      listModelsSettings = settings.listModelsSettings.toBuilder();
      updateModelSettings = settings.updateModelSettings.toBuilder();
      deleteModelSettings = settings.deleteModelSettings.toBuilder();
      deleteModelOperationSettings = settings.deleteModelOperationSettings.toBuilder();
      exportModelSettings = settings.exportModelSettings.toBuilder();
      exportModelOperationSettings = settings.exportModelOperationSettings.toBuilder();
      getModelEvaluationSettings = settings.getModelEvaluationSettings.toBuilder();
      listModelEvaluationsSettings = settings.listModelEvaluationsSettings.toBuilder();
      getModelEvaluationSliceSettings = settings.getModelEvaluationSliceSettings.toBuilder();
      listModelEvaluationSlicesSettings = settings.listModelEvaluationSlicesSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              uploadModelSettings,
              getModelSettings,
              listModelsSettings,
              updateModelSettings,
              deleteModelSettings,
              exportModelSettings,
              getModelEvaluationSettings,
              listModelEvaluationsSettings,
              getModelEvaluationSliceSettings,
              listModelEvaluationSlicesSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .uploadModelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_3_params"));

      builder
          .getModelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_3_params"));

      builder
          .listModelsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_3_params"));

      builder
          .updateModelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_3_params"));

      builder
          .deleteModelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_3_params"));

      builder
          .exportModelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_3_params"));

      builder
          .getModelEvaluationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_3_params"));

      builder
          .listModelEvaluationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_3_params"));

      builder
          .getModelEvaluationSliceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_3_params"));

      builder
          .listModelEvaluationSlicesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_3_params"));

      builder
          .uploadModelOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<UploadModelRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_3_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_3_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(UploadModelResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  UploadModelOperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteModelOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<DeleteModelRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_3_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_3_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(DeleteOperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .exportModelOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<ExportModelRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_3_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_3_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ExportModelResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  ExportModelOperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      return builder;
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'.
    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) throws Exception {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, settingsUpdater);
      return this;
    }

    public ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders() {
      return unaryMethodSettingsBuilders;
    }

    /** Returns the builder for the settings used for calls to uploadModel. */
    public UnaryCallSettings.Builder<UploadModelRequest, Operation> uploadModelSettings() {
      return uploadModelSettings;
    }

    /** Returns the builder for the settings used for calls to uploadModel. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            UploadModelRequest, UploadModelResponse, UploadModelOperationMetadata>
        uploadModelOperationSettings() {
      return uploadModelOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getModel. */
    public UnaryCallSettings.Builder<GetModelRequest, Model> getModelSettings() {
      return getModelSettings;
    }

    /** Returns the builder for the settings used for calls to listModels. */
    public PagedCallSettings.Builder<ListModelsRequest, ListModelsResponse, ListModelsPagedResponse>
        listModelsSettings() {
      return listModelsSettings;
    }

    /** Returns the builder for the settings used for calls to updateModel. */
    public UnaryCallSettings.Builder<UpdateModelRequest, Model> updateModelSettings() {
      return updateModelSettings;
    }

    /** Returns the builder for the settings used for calls to deleteModel. */
    public UnaryCallSettings.Builder<DeleteModelRequest, Operation> deleteModelSettings() {
      return deleteModelSettings;
    }

    /** Returns the builder for the settings used for calls to deleteModel. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteModelRequest, Empty, DeleteOperationMetadata>
        deleteModelOperationSettings() {
      return deleteModelOperationSettings;
    }

    /** Returns the builder for the settings used for calls to exportModel. */
    public UnaryCallSettings.Builder<ExportModelRequest, Operation> exportModelSettings() {
      return exportModelSettings;
    }

    /** Returns the builder for the settings used for calls to exportModel. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            ExportModelRequest, ExportModelResponse, ExportModelOperationMetadata>
        exportModelOperationSettings() {
      return exportModelOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getModelEvaluation. */
    public UnaryCallSettings.Builder<GetModelEvaluationRequest, ModelEvaluation>
        getModelEvaluationSettings() {
      return getModelEvaluationSettings;
    }

    /** Returns the builder for the settings used for calls to listModelEvaluations. */
    public PagedCallSettings.Builder<
            ListModelEvaluationsRequest,
            ListModelEvaluationsResponse,
            ListModelEvaluationsPagedResponse>
        listModelEvaluationsSettings() {
      return listModelEvaluationsSettings;
    }

    /** Returns the builder for the settings used for calls to getModelEvaluationSlice. */
    public UnaryCallSettings.Builder<GetModelEvaluationSliceRequest, ModelEvaluationSlice>
        getModelEvaluationSliceSettings() {
      return getModelEvaluationSliceSettings;
    }

    /** Returns the builder for the settings used for calls to listModelEvaluationSlices. */
    public PagedCallSettings.Builder<
            ListModelEvaluationSlicesRequest,
            ListModelEvaluationSlicesResponse,
            ListModelEvaluationSlicesPagedResponse>
        listModelEvaluationSlicesSettings() {
      return listModelEvaluationSlicesSettings;
    }

    @Override
    public ModelServiceStubSettings build() throws IOException {
      return new ModelServiceStubSettings(this);
    }
  }
}
