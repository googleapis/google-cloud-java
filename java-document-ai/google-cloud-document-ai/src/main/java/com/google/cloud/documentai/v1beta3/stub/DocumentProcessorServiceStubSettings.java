/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.documentai.v1beta3.stub;

import static com.google.cloud.documentai.v1beta3.DocumentProcessorServiceClient.ListProcessorsPagedResponse;

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
import com.google.cloud.documentai.v1beta3.BatchProcessMetadata;
import com.google.cloud.documentai.v1beta3.BatchProcessRequest;
import com.google.cloud.documentai.v1beta3.BatchProcessResponse;
import com.google.cloud.documentai.v1beta3.CreateProcessorRequest;
import com.google.cloud.documentai.v1beta3.DeleteProcessorMetadata;
import com.google.cloud.documentai.v1beta3.DeleteProcessorRequest;
import com.google.cloud.documentai.v1beta3.DisableProcessorMetadata;
import com.google.cloud.documentai.v1beta3.DisableProcessorRequest;
import com.google.cloud.documentai.v1beta3.DisableProcessorResponse;
import com.google.cloud.documentai.v1beta3.EnableProcessorMetadata;
import com.google.cloud.documentai.v1beta3.EnableProcessorRequest;
import com.google.cloud.documentai.v1beta3.EnableProcessorResponse;
import com.google.cloud.documentai.v1beta3.FetchProcessorTypesRequest;
import com.google.cloud.documentai.v1beta3.FetchProcessorTypesResponse;
import com.google.cloud.documentai.v1beta3.ListProcessorsRequest;
import com.google.cloud.documentai.v1beta3.ListProcessorsResponse;
import com.google.cloud.documentai.v1beta3.ProcessRequest;
import com.google.cloud.documentai.v1beta3.ProcessResponse;
import com.google.cloud.documentai.v1beta3.Processor;
import com.google.cloud.documentai.v1beta3.ReviewDocumentOperationMetadata;
import com.google.cloud.documentai.v1beta3.ReviewDocumentRequest;
import com.google.cloud.documentai.v1beta3.ReviewDocumentResponse;
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
 * Settings class to configure an instance of {@link DocumentProcessorServiceStub}.
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
 * DocumentProcessorServiceStubSettings.Builder documentProcessorServiceSettingsBuilder =
 *     DocumentProcessorServiceStubSettings.newBuilder();
 * documentProcessorServiceSettingsBuilder
 *     .processDocumentSettings()
 *     .setRetrySettings(
 *         documentProcessorServiceSettingsBuilder
 *             .processDocumentSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * DocumentProcessorServiceStubSettings documentProcessorServiceSettings =
 *     documentProcessorServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class DocumentProcessorServiceStubSettings
    extends StubSettings<DocumentProcessorServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<ProcessRequest, ProcessResponse> processDocumentSettings;
  private final UnaryCallSettings<BatchProcessRequest, Operation> batchProcessDocumentsSettings;
  private final OperationCallSettings<
          BatchProcessRequest, BatchProcessResponse, BatchProcessMetadata>
      batchProcessDocumentsOperationSettings;
  private final UnaryCallSettings<FetchProcessorTypesRequest, FetchProcessorTypesResponse>
      fetchProcessorTypesSettings;
  private final PagedCallSettings<
          ListProcessorsRequest, ListProcessorsResponse, ListProcessorsPagedResponse>
      listProcessorsSettings;
  private final UnaryCallSettings<CreateProcessorRequest, Processor> createProcessorSettings;
  private final UnaryCallSettings<DeleteProcessorRequest, Operation> deleteProcessorSettings;
  private final OperationCallSettings<DeleteProcessorRequest, Empty, DeleteProcessorMetadata>
      deleteProcessorOperationSettings;
  private final UnaryCallSettings<EnableProcessorRequest, Operation> enableProcessorSettings;
  private final OperationCallSettings<
          EnableProcessorRequest, EnableProcessorResponse, EnableProcessorMetadata>
      enableProcessorOperationSettings;
  private final UnaryCallSettings<DisableProcessorRequest, Operation> disableProcessorSettings;
  private final OperationCallSettings<
          DisableProcessorRequest, DisableProcessorResponse, DisableProcessorMetadata>
      disableProcessorOperationSettings;
  private final UnaryCallSettings<ReviewDocumentRequest, Operation> reviewDocumentSettings;
  private final OperationCallSettings<
          ReviewDocumentRequest, ReviewDocumentResponse, ReviewDocumentOperationMetadata>
      reviewDocumentOperationSettings;

  private static final PagedListDescriptor<ListProcessorsRequest, ListProcessorsResponse, Processor>
      LIST_PROCESSORS_PAGE_STR_DESC =
          new PagedListDescriptor<ListProcessorsRequest, ListProcessorsResponse, Processor>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListProcessorsRequest injectToken(ListProcessorsRequest payload, String token) {
              return ListProcessorsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListProcessorsRequest injectPageSize(
                ListProcessorsRequest payload, int pageSize) {
              return ListProcessorsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListProcessorsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListProcessorsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Processor> extractResources(ListProcessorsResponse payload) {
              return payload.getProcessorsList() == null
                  ? ImmutableList.<Processor>of()
                  : payload.getProcessorsList();
            }
          };

  private static final PagedListResponseFactory<
          ListProcessorsRequest, ListProcessorsResponse, ListProcessorsPagedResponse>
      LIST_PROCESSORS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListProcessorsRequest, ListProcessorsResponse, ListProcessorsPagedResponse>() {
            @Override
            public ApiFuture<ListProcessorsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListProcessorsRequest, ListProcessorsResponse> callable,
                ListProcessorsRequest request,
                ApiCallContext context,
                ApiFuture<ListProcessorsResponse> futureResponse) {
              PageContext<ListProcessorsRequest, ListProcessorsResponse, Processor> pageContext =
                  PageContext.create(callable, LIST_PROCESSORS_PAGE_STR_DESC, request, context);
              return ListProcessorsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to processDocument. */
  public UnaryCallSettings<ProcessRequest, ProcessResponse> processDocumentSettings() {
    return processDocumentSettings;
  }

  /** Returns the object with the settings used for calls to batchProcessDocuments. */
  public UnaryCallSettings<BatchProcessRequest, Operation> batchProcessDocumentsSettings() {
    return batchProcessDocumentsSettings;
  }

  /** Returns the object with the settings used for calls to batchProcessDocuments. */
  public OperationCallSettings<BatchProcessRequest, BatchProcessResponse, BatchProcessMetadata>
      batchProcessDocumentsOperationSettings() {
    return batchProcessDocumentsOperationSettings;
  }

  /** Returns the object with the settings used for calls to fetchProcessorTypes. */
  public UnaryCallSettings<FetchProcessorTypesRequest, FetchProcessorTypesResponse>
      fetchProcessorTypesSettings() {
    return fetchProcessorTypesSettings;
  }

  /** Returns the object with the settings used for calls to listProcessors. */
  public PagedCallSettings<
          ListProcessorsRequest, ListProcessorsResponse, ListProcessorsPagedResponse>
      listProcessorsSettings() {
    return listProcessorsSettings;
  }

  /** Returns the object with the settings used for calls to createProcessor. */
  public UnaryCallSettings<CreateProcessorRequest, Processor> createProcessorSettings() {
    return createProcessorSettings;
  }

  /** Returns the object with the settings used for calls to deleteProcessor. */
  public UnaryCallSettings<DeleteProcessorRequest, Operation> deleteProcessorSettings() {
    return deleteProcessorSettings;
  }

  /** Returns the object with the settings used for calls to deleteProcessor. */
  public OperationCallSettings<DeleteProcessorRequest, Empty, DeleteProcessorMetadata>
      deleteProcessorOperationSettings() {
    return deleteProcessorOperationSettings;
  }

  /** Returns the object with the settings used for calls to enableProcessor. */
  public UnaryCallSettings<EnableProcessorRequest, Operation> enableProcessorSettings() {
    return enableProcessorSettings;
  }

  /** Returns the object with the settings used for calls to enableProcessor. */
  public OperationCallSettings<
          EnableProcessorRequest, EnableProcessorResponse, EnableProcessorMetadata>
      enableProcessorOperationSettings() {
    return enableProcessorOperationSettings;
  }

  /** Returns the object with the settings used for calls to disableProcessor. */
  public UnaryCallSettings<DisableProcessorRequest, Operation> disableProcessorSettings() {
    return disableProcessorSettings;
  }

  /** Returns the object with the settings used for calls to disableProcessor. */
  public OperationCallSettings<
          DisableProcessorRequest, DisableProcessorResponse, DisableProcessorMetadata>
      disableProcessorOperationSettings() {
    return disableProcessorOperationSettings;
  }

  /** Returns the object with the settings used for calls to reviewDocument. */
  public UnaryCallSettings<ReviewDocumentRequest, Operation> reviewDocumentSettings() {
    return reviewDocumentSettings;
  }

  /** Returns the object with the settings used for calls to reviewDocument. */
  public OperationCallSettings<
          ReviewDocumentRequest, ReviewDocumentResponse, ReviewDocumentOperationMetadata>
      reviewDocumentOperationSettings() {
    return reviewDocumentOperationSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public DocumentProcessorServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcDocumentProcessorServiceStub.create(this);
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
    return "documentai.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "documentai.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(DocumentProcessorServiceStubSettings.class))
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

  protected DocumentProcessorServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    processDocumentSettings = settingsBuilder.processDocumentSettings().build();
    batchProcessDocumentsSettings = settingsBuilder.batchProcessDocumentsSettings().build();
    batchProcessDocumentsOperationSettings =
        settingsBuilder.batchProcessDocumentsOperationSettings().build();
    fetchProcessorTypesSettings = settingsBuilder.fetchProcessorTypesSettings().build();
    listProcessorsSettings = settingsBuilder.listProcessorsSettings().build();
    createProcessorSettings = settingsBuilder.createProcessorSettings().build();
    deleteProcessorSettings = settingsBuilder.deleteProcessorSettings().build();
    deleteProcessorOperationSettings = settingsBuilder.deleteProcessorOperationSettings().build();
    enableProcessorSettings = settingsBuilder.enableProcessorSettings().build();
    enableProcessorOperationSettings = settingsBuilder.enableProcessorOperationSettings().build();
    disableProcessorSettings = settingsBuilder.disableProcessorSettings().build();
    disableProcessorOperationSettings = settingsBuilder.disableProcessorOperationSettings().build();
    reviewDocumentSettings = settingsBuilder.reviewDocumentSettings().build();
    reviewDocumentOperationSettings = settingsBuilder.reviewDocumentOperationSettings().build();
  }

  /** Builder for DocumentProcessorServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<DocumentProcessorServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<ProcessRequest, ProcessResponse>
        processDocumentSettings;
    private final UnaryCallSettings.Builder<BatchProcessRequest, Operation>
        batchProcessDocumentsSettings;
    private final OperationCallSettings.Builder<
            BatchProcessRequest, BatchProcessResponse, BatchProcessMetadata>
        batchProcessDocumentsOperationSettings;
    private final UnaryCallSettings.Builder<FetchProcessorTypesRequest, FetchProcessorTypesResponse>
        fetchProcessorTypesSettings;
    private final PagedCallSettings.Builder<
            ListProcessorsRequest, ListProcessorsResponse, ListProcessorsPagedResponse>
        listProcessorsSettings;
    private final UnaryCallSettings.Builder<CreateProcessorRequest, Processor>
        createProcessorSettings;
    private final UnaryCallSettings.Builder<DeleteProcessorRequest, Operation>
        deleteProcessorSettings;
    private final OperationCallSettings.Builder<
            DeleteProcessorRequest, Empty, DeleteProcessorMetadata>
        deleteProcessorOperationSettings;
    private final UnaryCallSettings.Builder<EnableProcessorRequest, Operation>
        enableProcessorSettings;
    private final OperationCallSettings.Builder<
            EnableProcessorRequest, EnableProcessorResponse, EnableProcessorMetadata>
        enableProcessorOperationSettings;
    private final UnaryCallSettings.Builder<DisableProcessorRequest, Operation>
        disableProcessorSettings;
    private final OperationCallSettings.Builder<
            DisableProcessorRequest, DisableProcessorResponse, DisableProcessorMetadata>
        disableProcessorOperationSettings;
    private final UnaryCallSettings.Builder<ReviewDocumentRequest, Operation>
        reviewDocumentSettings;
    private final OperationCallSettings.Builder<
            ReviewDocumentRequest, ReviewDocumentResponse, ReviewDocumentOperationMetadata>
        reviewDocumentOperationSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(120000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(120000L))
              .setTotalTimeout(Duration.ofMillis(120000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      processDocumentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchProcessDocumentsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchProcessDocumentsOperationSettings = OperationCallSettings.newBuilder();
      fetchProcessorTypesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listProcessorsSettings = PagedCallSettings.newBuilder(LIST_PROCESSORS_PAGE_STR_FACT);
      createProcessorSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteProcessorSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteProcessorOperationSettings = OperationCallSettings.newBuilder();
      enableProcessorSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      enableProcessorOperationSettings = OperationCallSettings.newBuilder();
      disableProcessorSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      disableProcessorOperationSettings = OperationCallSettings.newBuilder();
      reviewDocumentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      reviewDocumentOperationSettings = OperationCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              processDocumentSettings,
              batchProcessDocumentsSettings,
              fetchProcessorTypesSettings,
              listProcessorsSettings,
              createProcessorSettings,
              deleteProcessorSettings,
              enableProcessorSettings,
              disableProcessorSettings,
              reviewDocumentSettings);
      initDefaults(this);
    }

    protected Builder(DocumentProcessorServiceStubSettings settings) {
      super(settings);

      processDocumentSettings = settings.processDocumentSettings.toBuilder();
      batchProcessDocumentsSettings = settings.batchProcessDocumentsSettings.toBuilder();
      batchProcessDocumentsOperationSettings =
          settings.batchProcessDocumentsOperationSettings.toBuilder();
      fetchProcessorTypesSettings = settings.fetchProcessorTypesSettings.toBuilder();
      listProcessorsSettings = settings.listProcessorsSettings.toBuilder();
      createProcessorSettings = settings.createProcessorSettings.toBuilder();
      deleteProcessorSettings = settings.deleteProcessorSettings.toBuilder();
      deleteProcessorOperationSettings = settings.deleteProcessorOperationSettings.toBuilder();
      enableProcessorSettings = settings.enableProcessorSettings.toBuilder();
      enableProcessorOperationSettings = settings.enableProcessorOperationSettings.toBuilder();
      disableProcessorSettings = settings.disableProcessorSettings.toBuilder();
      disableProcessorOperationSettings = settings.disableProcessorOperationSettings.toBuilder();
      reviewDocumentSettings = settings.reviewDocumentSettings.toBuilder();
      reviewDocumentOperationSettings = settings.reviewDocumentOperationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              processDocumentSettings,
              batchProcessDocumentsSettings,
              fetchProcessorTypesSettings,
              listProcessorsSettings,
              createProcessorSettings,
              deleteProcessorSettings,
              enableProcessorSettings,
              disableProcessorSettings,
              reviewDocumentSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .processDocumentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .batchProcessDocumentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .fetchProcessorTypesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listProcessorsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createProcessorSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteProcessorSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .enableProcessorSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .disableProcessorSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .reviewDocumentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .batchProcessDocumentsOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<BatchProcessRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(BatchProcessResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(BatchProcessMetadata.class))
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
          .deleteProcessorOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteProcessorRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(DeleteProcessorMetadata.class))
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
          .enableProcessorOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<EnableProcessorRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(EnableProcessorResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(EnableProcessorMetadata.class))
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
          .disableProcessorOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DisableProcessorRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(DisableProcessorResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(DisableProcessorMetadata.class))
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
          .reviewDocumentOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ReviewDocumentRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ReviewDocumentResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  ReviewDocumentOperationMetadata.class))
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

    /** Returns the builder for the settings used for calls to processDocument. */
    public UnaryCallSettings.Builder<ProcessRequest, ProcessResponse> processDocumentSettings() {
      return processDocumentSettings;
    }

    /** Returns the builder for the settings used for calls to batchProcessDocuments. */
    public UnaryCallSettings.Builder<BatchProcessRequest, Operation>
        batchProcessDocumentsSettings() {
      return batchProcessDocumentsSettings;
    }

    /** Returns the builder for the settings used for calls to batchProcessDocuments. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            BatchProcessRequest, BatchProcessResponse, BatchProcessMetadata>
        batchProcessDocumentsOperationSettings() {
      return batchProcessDocumentsOperationSettings;
    }

    /** Returns the builder for the settings used for calls to fetchProcessorTypes. */
    public UnaryCallSettings.Builder<FetchProcessorTypesRequest, FetchProcessorTypesResponse>
        fetchProcessorTypesSettings() {
      return fetchProcessorTypesSettings;
    }

    /** Returns the builder for the settings used for calls to listProcessors. */
    public PagedCallSettings.Builder<
            ListProcessorsRequest, ListProcessorsResponse, ListProcessorsPagedResponse>
        listProcessorsSettings() {
      return listProcessorsSettings;
    }

    /** Returns the builder for the settings used for calls to createProcessor. */
    public UnaryCallSettings.Builder<CreateProcessorRequest, Processor> createProcessorSettings() {
      return createProcessorSettings;
    }

    /** Returns the builder for the settings used for calls to deleteProcessor. */
    public UnaryCallSettings.Builder<DeleteProcessorRequest, Operation> deleteProcessorSettings() {
      return deleteProcessorSettings;
    }

    /** Returns the builder for the settings used for calls to deleteProcessor. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteProcessorRequest, Empty, DeleteProcessorMetadata>
        deleteProcessorOperationSettings() {
      return deleteProcessorOperationSettings;
    }

    /** Returns the builder for the settings used for calls to enableProcessor. */
    public UnaryCallSettings.Builder<EnableProcessorRequest, Operation> enableProcessorSettings() {
      return enableProcessorSettings;
    }

    /** Returns the builder for the settings used for calls to enableProcessor. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            EnableProcessorRequest, EnableProcessorResponse, EnableProcessorMetadata>
        enableProcessorOperationSettings() {
      return enableProcessorOperationSettings;
    }

    /** Returns the builder for the settings used for calls to disableProcessor. */
    public UnaryCallSettings.Builder<DisableProcessorRequest, Operation>
        disableProcessorSettings() {
      return disableProcessorSettings;
    }

    /** Returns the builder for the settings used for calls to disableProcessor. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            DisableProcessorRequest, DisableProcessorResponse, DisableProcessorMetadata>
        disableProcessorOperationSettings() {
      return disableProcessorOperationSettings;
    }

    /** Returns the builder for the settings used for calls to reviewDocument. */
    public UnaryCallSettings.Builder<ReviewDocumentRequest, Operation> reviewDocumentSettings() {
      return reviewDocumentSettings;
    }

    /** Returns the builder for the settings used for calls to reviewDocument. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            ReviewDocumentRequest, ReviewDocumentResponse, ReviewDocumentOperationMetadata>
        reviewDocumentOperationSettings() {
      return reviewDocumentOperationSettings;
    }

    @Override
    public DocumentProcessorServiceStubSettings build() throws IOException {
      return new DocumentProcessorServiceStubSettings(this);
    }
  }
}
