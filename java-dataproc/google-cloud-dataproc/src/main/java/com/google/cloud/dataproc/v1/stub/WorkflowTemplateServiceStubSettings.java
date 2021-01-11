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

package com.google.cloud.dataproc.v1.stub;

import static com.google.cloud.dataproc.v1.WorkflowTemplateServiceClient.ListWorkflowTemplatesPagedResponse;

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
import com.google.cloud.dataproc.v1.CreateWorkflowTemplateRequest;
import com.google.cloud.dataproc.v1.DeleteWorkflowTemplateRequest;
import com.google.cloud.dataproc.v1.GetWorkflowTemplateRequest;
import com.google.cloud.dataproc.v1.InstantiateInlineWorkflowTemplateRequest;
import com.google.cloud.dataproc.v1.InstantiateWorkflowTemplateRequest;
import com.google.cloud.dataproc.v1.ListWorkflowTemplatesRequest;
import com.google.cloud.dataproc.v1.ListWorkflowTemplatesResponse;
import com.google.cloud.dataproc.v1.UpdateWorkflowTemplateRequest;
import com.google.cloud.dataproc.v1.WorkflowMetadata;
import com.google.cloud.dataproc.v1.WorkflowTemplate;
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
 * Settings class to configure an instance of {@link WorkflowTemplateServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (dataproc.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createWorkflowTemplate to 30 seconds:
 *
 * <pre>{@code
 * WorkflowTemplateServiceStubSettings.Builder workflowTemplateServiceSettingsBuilder =
 *     WorkflowTemplateServiceStubSettings.newBuilder();
 * workflowTemplateServiceSettingsBuilder
 *     .createWorkflowTemplateSettings()
 *     .setRetrySettings(
 *         workflowTemplateServiceSettingsBuilder
 *             .createWorkflowTemplateSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * WorkflowTemplateServiceStubSettings workflowTemplateServiceSettings =
 *     workflowTemplateServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class WorkflowTemplateServiceStubSettings
    extends StubSettings<WorkflowTemplateServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateWorkflowTemplateRequest, WorkflowTemplate>
      createWorkflowTemplateSettings;
  private final UnaryCallSettings<GetWorkflowTemplateRequest, WorkflowTemplate>
      getWorkflowTemplateSettings;
  private final UnaryCallSettings<InstantiateWorkflowTemplateRequest, Operation>
      instantiateWorkflowTemplateSettings;
  private final OperationCallSettings<InstantiateWorkflowTemplateRequest, Empty, WorkflowMetadata>
      instantiateWorkflowTemplateOperationSettings;
  private final UnaryCallSettings<InstantiateInlineWorkflowTemplateRequest, Operation>
      instantiateInlineWorkflowTemplateSettings;
  private final OperationCallSettings<
          InstantiateInlineWorkflowTemplateRequest, Empty, WorkflowMetadata>
      instantiateInlineWorkflowTemplateOperationSettings;
  private final UnaryCallSettings<UpdateWorkflowTemplateRequest, WorkflowTemplate>
      updateWorkflowTemplateSettings;
  private final PagedCallSettings<
          ListWorkflowTemplatesRequest,
          ListWorkflowTemplatesResponse,
          ListWorkflowTemplatesPagedResponse>
      listWorkflowTemplatesSettings;
  private final UnaryCallSettings<DeleteWorkflowTemplateRequest, Empty>
      deleteWorkflowTemplateSettings;

  private static final PagedListDescriptor<
          ListWorkflowTemplatesRequest, ListWorkflowTemplatesResponse, WorkflowTemplate>
      LIST_WORKFLOW_TEMPLATES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListWorkflowTemplatesRequest, ListWorkflowTemplatesResponse, WorkflowTemplate>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListWorkflowTemplatesRequest injectToken(
                ListWorkflowTemplatesRequest payload, String token) {
              return ListWorkflowTemplatesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListWorkflowTemplatesRequest injectPageSize(
                ListWorkflowTemplatesRequest payload, int pageSize) {
              return ListWorkflowTemplatesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListWorkflowTemplatesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListWorkflowTemplatesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<WorkflowTemplate> extractResources(
                ListWorkflowTemplatesResponse payload) {
              return payload.getTemplatesList() == null
                  ? ImmutableList.<WorkflowTemplate>of()
                  : payload.getTemplatesList();
            }
          };

  private static final PagedListResponseFactory<
          ListWorkflowTemplatesRequest,
          ListWorkflowTemplatesResponse,
          ListWorkflowTemplatesPagedResponse>
      LIST_WORKFLOW_TEMPLATES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListWorkflowTemplatesRequest,
              ListWorkflowTemplatesResponse,
              ListWorkflowTemplatesPagedResponse>() {
            @Override
            public ApiFuture<ListWorkflowTemplatesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListWorkflowTemplatesRequest, ListWorkflowTemplatesResponse> callable,
                ListWorkflowTemplatesRequest request,
                ApiCallContext context,
                ApiFuture<ListWorkflowTemplatesResponse> futureResponse) {
              PageContext<
                      ListWorkflowTemplatesRequest, ListWorkflowTemplatesResponse, WorkflowTemplate>
                  pageContext =
                      PageContext.create(
                          callable, LIST_WORKFLOW_TEMPLATES_PAGE_STR_DESC, request, context);
              return ListWorkflowTemplatesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createWorkflowTemplate. */
  public UnaryCallSettings<CreateWorkflowTemplateRequest, WorkflowTemplate>
      createWorkflowTemplateSettings() {
    return createWorkflowTemplateSettings;
  }

  /** Returns the object with the settings used for calls to getWorkflowTemplate. */
  public UnaryCallSettings<GetWorkflowTemplateRequest, WorkflowTemplate>
      getWorkflowTemplateSettings() {
    return getWorkflowTemplateSettings;
  }

  /** Returns the object with the settings used for calls to instantiateWorkflowTemplate. */
  public UnaryCallSettings<InstantiateWorkflowTemplateRequest, Operation>
      instantiateWorkflowTemplateSettings() {
    return instantiateWorkflowTemplateSettings;
  }

  /** Returns the object with the settings used for calls to instantiateWorkflowTemplate. */
  public OperationCallSettings<InstantiateWorkflowTemplateRequest, Empty, WorkflowMetadata>
      instantiateWorkflowTemplateOperationSettings() {
    return instantiateWorkflowTemplateOperationSettings;
  }

  /** Returns the object with the settings used for calls to instantiateInlineWorkflowTemplate. */
  public UnaryCallSettings<InstantiateInlineWorkflowTemplateRequest, Operation>
      instantiateInlineWorkflowTemplateSettings() {
    return instantiateInlineWorkflowTemplateSettings;
  }

  /** Returns the object with the settings used for calls to instantiateInlineWorkflowTemplate. */
  public OperationCallSettings<InstantiateInlineWorkflowTemplateRequest, Empty, WorkflowMetadata>
      instantiateInlineWorkflowTemplateOperationSettings() {
    return instantiateInlineWorkflowTemplateOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateWorkflowTemplate. */
  public UnaryCallSettings<UpdateWorkflowTemplateRequest, WorkflowTemplate>
      updateWorkflowTemplateSettings() {
    return updateWorkflowTemplateSettings;
  }

  /** Returns the object with the settings used for calls to listWorkflowTemplates. */
  public PagedCallSettings<
          ListWorkflowTemplatesRequest,
          ListWorkflowTemplatesResponse,
          ListWorkflowTemplatesPagedResponse>
      listWorkflowTemplatesSettings() {
    return listWorkflowTemplatesSettings;
  }

  /** Returns the object with the settings used for calls to deleteWorkflowTemplate. */
  public UnaryCallSettings<DeleteWorkflowTemplateRequest, Empty> deleteWorkflowTemplateSettings() {
    return deleteWorkflowTemplateSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public WorkflowTemplateServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcWorkflowTemplateServiceStub.create(this);
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
    return "dataproc.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(WorkflowTemplateServiceStubSettings.class))
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

  protected WorkflowTemplateServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createWorkflowTemplateSettings = settingsBuilder.createWorkflowTemplateSettings().build();
    getWorkflowTemplateSettings = settingsBuilder.getWorkflowTemplateSettings().build();
    instantiateWorkflowTemplateSettings =
        settingsBuilder.instantiateWorkflowTemplateSettings().build();
    instantiateWorkflowTemplateOperationSettings =
        settingsBuilder.instantiateWorkflowTemplateOperationSettings().build();
    instantiateInlineWorkflowTemplateSettings =
        settingsBuilder.instantiateInlineWorkflowTemplateSettings().build();
    instantiateInlineWorkflowTemplateOperationSettings =
        settingsBuilder.instantiateInlineWorkflowTemplateOperationSettings().build();
    updateWorkflowTemplateSettings = settingsBuilder.updateWorkflowTemplateSettings().build();
    listWorkflowTemplatesSettings = settingsBuilder.listWorkflowTemplatesSettings().build();
    deleteWorkflowTemplateSettings = settingsBuilder.deleteWorkflowTemplateSettings().build();
  }

  /** Builder for WorkflowTemplateServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<WorkflowTemplateServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateWorkflowTemplateRequest, WorkflowTemplate>
        createWorkflowTemplateSettings;
    private final UnaryCallSettings.Builder<GetWorkflowTemplateRequest, WorkflowTemplate>
        getWorkflowTemplateSettings;
    private final UnaryCallSettings.Builder<InstantiateWorkflowTemplateRequest, Operation>
        instantiateWorkflowTemplateSettings;
    private final OperationCallSettings.Builder<
            InstantiateWorkflowTemplateRequest, Empty, WorkflowMetadata>
        instantiateWorkflowTemplateOperationSettings;
    private final UnaryCallSettings.Builder<InstantiateInlineWorkflowTemplateRequest, Operation>
        instantiateInlineWorkflowTemplateSettings;
    private final OperationCallSettings.Builder<
            InstantiateInlineWorkflowTemplateRequest, Empty, WorkflowMetadata>
        instantiateInlineWorkflowTemplateOperationSettings;
    private final UnaryCallSettings.Builder<UpdateWorkflowTemplateRequest, WorkflowTemplate>
        updateWorkflowTemplateSettings;
    private final PagedCallSettings.Builder<
            ListWorkflowTemplatesRequest,
            ListWorkflowTemplatesResponse,
            ListWorkflowTemplatesPagedResponse>
        listWorkflowTemplatesSettings;
    private final UnaryCallSettings.Builder<DeleteWorkflowTemplateRequest, Empty>
        deleteWorkflowTemplateSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_3_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      definitions.put(
          "retry_policy_4_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED,
                  StatusCode.Code.INTERNAL,
                  StatusCode.Code.UNAVAILABLE)));
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
              .setInitialRpcTimeout(Duration.ofMillis(600000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(600000L))
              .setTotalTimeout(Duration.ofMillis(600000L))
              .build();
      definitions.put("retry_policy_3_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(600000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(600000L))
              .setTotalTimeout(Duration.ofMillis(600000L))
              .build();
      definitions.put("retry_policy_4_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createWorkflowTemplateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getWorkflowTemplateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      instantiateWorkflowTemplateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      instantiateWorkflowTemplateOperationSettings = OperationCallSettings.newBuilder();
      instantiateInlineWorkflowTemplateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      instantiateInlineWorkflowTemplateOperationSettings = OperationCallSettings.newBuilder();
      updateWorkflowTemplateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listWorkflowTemplatesSettings =
          PagedCallSettings.newBuilder(LIST_WORKFLOW_TEMPLATES_PAGE_STR_FACT);
      deleteWorkflowTemplateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createWorkflowTemplateSettings,
              getWorkflowTemplateSettings,
              instantiateWorkflowTemplateSettings,
              instantiateInlineWorkflowTemplateSettings,
              updateWorkflowTemplateSettings,
              listWorkflowTemplatesSettings,
              deleteWorkflowTemplateSettings);
      initDefaults(this);
    }

    protected Builder(WorkflowTemplateServiceStubSettings settings) {
      super(settings);

      createWorkflowTemplateSettings = settings.createWorkflowTemplateSettings.toBuilder();
      getWorkflowTemplateSettings = settings.getWorkflowTemplateSettings.toBuilder();
      instantiateWorkflowTemplateSettings =
          settings.instantiateWorkflowTemplateSettings.toBuilder();
      instantiateWorkflowTemplateOperationSettings =
          settings.instantiateWorkflowTemplateOperationSettings.toBuilder();
      instantiateInlineWorkflowTemplateSettings =
          settings.instantiateInlineWorkflowTemplateSettings.toBuilder();
      instantiateInlineWorkflowTemplateOperationSettings =
          settings.instantiateInlineWorkflowTemplateOperationSettings.toBuilder();
      updateWorkflowTemplateSettings = settings.updateWorkflowTemplateSettings.toBuilder();
      listWorkflowTemplatesSettings = settings.listWorkflowTemplatesSettings.toBuilder();
      deleteWorkflowTemplateSettings = settings.deleteWorkflowTemplateSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createWorkflowTemplateSettings,
              getWorkflowTemplateSettings,
              instantiateWorkflowTemplateSettings,
              instantiateInlineWorkflowTemplateSettings,
              updateWorkflowTemplateSettings,
              listWorkflowTemplatesSettings,
              deleteWorkflowTemplateSettings);
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
          .createWorkflowTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_3_params"));

      builder
          .getWorkflowTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_4_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_4_params"));

      builder
          .instantiateWorkflowTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_3_params"));

      builder
          .instantiateInlineWorkflowTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_3_params"));

      builder
          .updateWorkflowTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_3_params"));

      builder
          .listWorkflowTemplatesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_4_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_4_params"));

      builder
          .deleteWorkflowTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_3_params"));

      builder
          .instantiateWorkflowTemplateOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<InstantiateWorkflowTemplateRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_3_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_3_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(WorkflowMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(1000L))
                      .setRetryDelayMultiplier(2.0)
                      .setMaxRetryDelay(Duration.ofMillis(10000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(43200000L))
                      .build()));

      builder
          .instantiateInlineWorkflowTemplateOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<InstantiateInlineWorkflowTemplateRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_3_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_3_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(WorkflowMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(1000L))
                      .setRetryDelayMultiplier(2.0)
                      .setMaxRetryDelay(Duration.ofMillis(10000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(43200000L))
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

    /** Returns the builder for the settings used for calls to createWorkflowTemplate. */
    public UnaryCallSettings.Builder<CreateWorkflowTemplateRequest, WorkflowTemplate>
        createWorkflowTemplateSettings() {
      return createWorkflowTemplateSettings;
    }

    /** Returns the builder for the settings used for calls to getWorkflowTemplate. */
    public UnaryCallSettings.Builder<GetWorkflowTemplateRequest, WorkflowTemplate>
        getWorkflowTemplateSettings() {
      return getWorkflowTemplateSettings;
    }

    /** Returns the builder for the settings used for calls to instantiateWorkflowTemplate. */
    public UnaryCallSettings.Builder<InstantiateWorkflowTemplateRequest, Operation>
        instantiateWorkflowTemplateSettings() {
      return instantiateWorkflowTemplateSettings;
    }

    /** Returns the builder for the settings used for calls to instantiateWorkflowTemplate. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            InstantiateWorkflowTemplateRequest, Empty, WorkflowMetadata>
        instantiateWorkflowTemplateOperationSettings() {
      return instantiateWorkflowTemplateOperationSettings;
    }

    /** Returns the builder for the settings used for calls to instantiateInlineWorkflowTemplate. */
    public UnaryCallSettings.Builder<InstantiateInlineWorkflowTemplateRequest, Operation>
        instantiateInlineWorkflowTemplateSettings() {
      return instantiateInlineWorkflowTemplateSettings;
    }

    /** Returns the builder for the settings used for calls to instantiateInlineWorkflowTemplate. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            InstantiateInlineWorkflowTemplateRequest, Empty, WorkflowMetadata>
        instantiateInlineWorkflowTemplateOperationSettings() {
      return instantiateInlineWorkflowTemplateOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateWorkflowTemplate. */
    public UnaryCallSettings.Builder<UpdateWorkflowTemplateRequest, WorkflowTemplate>
        updateWorkflowTemplateSettings() {
      return updateWorkflowTemplateSettings;
    }

    /** Returns the builder for the settings used for calls to listWorkflowTemplates. */
    public PagedCallSettings.Builder<
            ListWorkflowTemplatesRequest,
            ListWorkflowTemplatesResponse,
            ListWorkflowTemplatesPagedResponse>
        listWorkflowTemplatesSettings() {
      return listWorkflowTemplatesSettings;
    }

    /** Returns the builder for the settings used for calls to deleteWorkflowTemplate. */
    public UnaryCallSettings.Builder<DeleteWorkflowTemplateRequest, Empty>
        deleteWorkflowTemplateSettings() {
      return deleteWorkflowTemplateSettings;
    }

    @Override
    public WorkflowTemplateServiceStubSettings build() throws IOException {
      return new WorkflowTemplateServiceStubSettings(this);
    }
  }
}
