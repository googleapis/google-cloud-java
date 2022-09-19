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

package com.google.cloud.bigquery.migration.v2alpha.stub;

import static com.google.cloud.bigquery.migration.v2alpha.MigrationServiceClient.ListMigrationSubtasksPagedResponse;
import static com.google.cloud.bigquery.migration.v2alpha.MigrationServiceClient.ListMigrationWorkflowsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.bigquery.migration.v2alpha.CreateMigrationWorkflowRequest;
import com.google.cloud.bigquery.migration.v2alpha.DeleteMigrationWorkflowRequest;
import com.google.cloud.bigquery.migration.v2alpha.GetMigrationSubtaskRequest;
import com.google.cloud.bigquery.migration.v2alpha.GetMigrationWorkflowRequest;
import com.google.cloud.bigquery.migration.v2alpha.ListMigrationSubtasksRequest;
import com.google.cloud.bigquery.migration.v2alpha.ListMigrationSubtasksResponse;
import com.google.cloud.bigquery.migration.v2alpha.ListMigrationWorkflowsRequest;
import com.google.cloud.bigquery.migration.v2alpha.ListMigrationWorkflowsResponse;
import com.google.cloud.bigquery.migration.v2alpha.MigrationSubtask;
import com.google.cloud.bigquery.migration.v2alpha.MigrationWorkflow;
import com.google.cloud.bigquery.migration.v2alpha.StartMigrationWorkflowRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link MigrationServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (bigquerymigration.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createMigrationWorkflow to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * MigrationServiceStubSettings.Builder migrationServiceSettingsBuilder =
 *     MigrationServiceStubSettings.newBuilder();
 * migrationServiceSettingsBuilder
 *     .createMigrationWorkflowSettings()
 *     .setRetrySettings(
 *         migrationServiceSettingsBuilder
 *             .createMigrationWorkflowSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * MigrationServiceStubSettings migrationServiceSettings = migrationServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class MigrationServiceStubSettings extends StubSettings<MigrationServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateMigrationWorkflowRequest, MigrationWorkflow>
      createMigrationWorkflowSettings;
  private final UnaryCallSettings<GetMigrationWorkflowRequest, MigrationWorkflow>
      getMigrationWorkflowSettings;
  private final PagedCallSettings<
          ListMigrationWorkflowsRequest,
          ListMigrationWorkflowsResponse,
          ListMigrationWorkflowsPagedResponse>
      listMigrationWorkflowsSettings;
  private final UnaryCallSettings<DeleteMigrationWorkflowRequest, Empty>
      deleteMigrationWorkflowSettings;
  private final UnaryCallSettings<StartMigrationWorkflowRequest, Empty>
      startMigrationWorkflowSettings;
  private final UnaryCallSettings<GetMigrationSubtaskRequest, MigrationSubtask>
      getMigrationSubtaskSettings;
  private final PagedCallSettings<
          ListMigrationSubtasksRequest,
          ListMigrationSubtasksResponse,
          ListMigrationSubtasksPagedResponse>
      listMigrationSubtasksSettings;

  private static final PagedListDescriptor<
          ListMigrationWorkflowsRequest, ListMigrationWorkflowsResponse, MigrationWorkflow>
      LIST_MIGRATION_WORKFLOWS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListMigrationWorkflowsRequest, ListMigrationWorkflowsResponse, MigrationWorkflow>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListMigrationWorkflowsRequest injectToken(
                ListMigrationWorkflowsRequest payload, String token) {
              return ListMigrationWorkflowsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListMigrationWorkflowsRequest injectPageSize(
                ListMigrationWorkflowsRequest payload, int pageSize) {
              return ListMigrationWorkflowsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListMigrationWorkflowsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListMigrationWorkflowsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<MigrationWorkflow> extractResources(
                ListMigrationWorkflowsResponse payload) {
              return payload.getMigrationWorkflowsList() == null
                  ? ImmutableList.<MigrationWorkflow>of()
                  : payload.getMigrationWorkflowsList();
            }
          };

  private static final PagedListDescriptor<
          ListMigrationSubtasksRequest, ListMigrationSubtasksResponse, MigrationSubtask>
      LIST_MIGRATION_SUBTASKS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListMigrationSubtasksRequest, ListMigrationSubtasksResponse, MigrationSubtask>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListMigrationSubtasksRequest injectToken(
                ListMigrationSubtasksRequest payload, String token) {
              return ListMigrationSubtasksRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListMigrationSubtasksRequest injectPageSize(
                ListMigrationSubtasksRequest payload, int pageSize) {
              return ListMigrationSubtasksRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListMigrationSubtasksRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListMigrationSubtasksResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<MigrationSubtask> extractResources(
                ListMigrationSubtasksResponse payload) {
              return payload.getMigrationSubtasksList() == null
                  ? ImmutableList.<MigrationSubtask>of()
                  : payload.getMigrationSubtasksList();
            }
          };

  private static final PagedListResponseFactory<
          ListMigrationWorkflowsRequest,
          ListMigrationWorkflowsResponse,
          ListMigrationWorkflowsPagedResponse>
      LIST_MIGRATION_WORKFLOWS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListMigrationWorkflowsRequest,
              ListMigrationWorkflowsResponse,
              ListMigrationWorkflowsPagedResponse>() {
            @Override
            public ApiFuture<ListMigrationWorkflowsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListMigrationWorkflowsRequest, ListMigrationWorkflowsResponse>
                    callable,
                ListMigrationWorkflowsRequest request,
                ApiCallContext context,
                ApiFuture<ListMigrationWorkflowsResponse> futureResponse) {
              PageContext<
                      ListMigrationWorkflowsRequest,
                      ListMigrationWorkflowsResponse,
                      MigrationWorkflow>
                  pageContext =
                      PageContext.create(
                          callable, LIST_MIGRATION_WORKFLOWS_PAGE_STR_DESC, request, context);
              return ListMigrationWorkflowsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListMigrationSubtasksRequest,
          ListMigrationSubtasksResponse,
          ListMigrationSubtasksPagedResponse>
      LIST_MIGRATION_SUBTASKS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListMigrationSubtasksRequest,
              ListMigrationSubtasksResponse,
              ListMigrationSubtasksPagedResponse>() {
            @Override
            public ApiFuture<ListMigrationSubtasksPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListMigrationSubtasksRequest, ListMigrationSubtasksResponse> callable,
                ListMigrationSubtasksRequest request,
                ApiCallContext context,
                ApiFuture<ListMigrationSubtasksResponse> futureResponse) {
              PageContext<
                      ListMigrationSubtasksRequest, ListMigrationSubtasksResponse, MigrationSubtask>
                  pageContext =
                      PageContext.create(
                          callable, LIST_MIGRATION_SUBTASKS_PAGE_STR_DESC, request, context);
              return ListMigrationSubtasksPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createMigrationWorkflow. */
  public UnaryCallSettings<CreateMigrationWorkflowRequest, MigrationWorkflow>
      createMigrationWorkflowSettings() {
    return createMigrationWorkflowSettings;
  }

  /** Returns the object with the settings used for calls to getMigrationWorkflow. */
  public UnaryCallSettings<GetMigrationWorkflowRequest, MigrationWorkflow>
      getMigrationWorkflowSettings() {
    return getMigrationWorkflowSettings;
  }

  /** Returns the object with the settings used for calls to listMigrationWorkflows. */
  public PagedCallSettings<
          ListMigrationWorkflowsRequest,
          ListMigrationWorkflowsResponse,
          ListMigrationWorkflowsPagedResponse>
      listMigrationWorkflowsSettings() {
    return listMigrationWorkflowsSettings;
  }

  /** Returns the object with the settings used for calls to deleteMigrationWorkflow. */
  public UnaryCallSettings<DeleteMigrationWorkflowRequest, Empty>
      deleteMigrationWorkflowSettings() {
    return deleteMigrationWorkflowSettings;
  }

  /** Returns the object with the settings used for calls to startMigrationWorkflow. */
  public UnaryCallSettings<StartMigrationWorkflowRequest, Empty> startMigrationWorkflowSettings() {
    return startMigrationWorkflowSettings;
  }

  /** Returns the object with the settings used for calls to getMigrationSubtask. */
  public UnaryCallSettings<GetMigrationSubtaskRequest, MigrationSubtask>
      getMigrationSubtaskSettings() {
    return getMigrationSubtaskSettings;
  }

  /** Returns the object with the settings used for calls to listMigrationSubtasks. */
  public PagedCallSettings<
          ListMigrationSubtasksRequest,
          ListMigrationSubtasksResponse,
          ListMigrationSubtasksPagedResponse>
      listMigrationSubtasksSettings() {
    return listMigrationSubtasksSettings;
  }

  public MigrationServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcMigrationServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonMigrationServiceStub.create(this);
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
    return "bigquerymigration.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "bigquerymigration.mtls.googleapis.com:443";
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder()
        .setScopesToApply(DEFAULT_SERVICE_SCOPES)
        .setUseJwtAccessWithScope(true);
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstantiatingHttpJsonChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultGrpcApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(MigrationServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(MigrationServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return MigrationServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected MigrationServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createMigrationWorkflowSettings = settingsBuilder.createMigrationWorkflowSettings().build();
    getMigrationWorkflowSettings = settingsBuilder.getMigrationWorkflowSettings().build();
    listMigrationWorkflowsSettings = settingsBuilder.listMigrationWorkflowsSettings().build();
    deleteMigrationWorkflowSettings = settingsBuilder.deleteMigrationWorkflowSettings().build();
    startMigrationWorkflowSettings = settingsBuilder.startMigrationWorkflowSettings().build();
    getMigrationSubtaskSettings = settingsBuilder.getMigrationSubtaskSettings().build();
    listMigrationSubtasksSettings = settingsBuilder.listMigrationSubtasksSettings().build();
  }

  /** Builder for MigrationServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<MigrationServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateMigrationWorkflowRequest, MigrationWorkflow>
        createMigrationWorkflowSettings;
    private final UnaryCallSettings.Builder<GetMigrationWorkflowRequest, MigrationWorkflow>
        getMigrationWorkflowSettings;
    private final PagedCallSettings.Builder<
            ListMigrationWorkflowsRequest,
            ListMigrationWorkflowsResponse,
            ListMigrationWorkflowsPagedResponse>
        listMigrationWorkflowsSettings;
    private final UnaryCallSettings.Builder<DeleteMigrationWorkflowRequest, Empty>
        deleteMigrationWorkflowSettings;
    private final UnaryCallSettings.Builder<StartMigrationWorkflowRequest, Empty>
        startMigrationWorkflowSettings;
    private final UnaryCallSettings.Builder<GetMigrationSubtaskRequest, MigrationSubtask>
        getMigrationSubtaskSettings;
    private final PagedCallSettings.Builder<
            ListMigrationSubtasksRequest,
            ListMigrationSubtasksResponse,
            ListMigrationSubtasksPagedResponse>
        listMigrationSubtasksSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "no_retry_1_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_1_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(10000L))
              .setInitialRpcTimeout(Duration.ofMillis(120000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(120000L))
              .setTotalTimeout(Duration.ofMillis(120000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createMigrationWorkflowSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getMigrationWorkflowSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listMigrationWorkflowsSettings =
          PagedCallSettings.newBuilder(LIST_MIGRATION_WORKFLOWS_PAGE_STR_FACT);
      deleteMigrationWorkflowSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      startMigrationWorkflowSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getMigrationSubtaskSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listMigrationSubtasksSettings =
          PagedCallSettings.newBuilder(LIST_MIGRATION_SUBTASKS_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createMigrationWorkflowSettings,
              getMigrationWorkflowSettings,
              listMigrationWorkflowsSettings,
              deleteMigrationWorkflowSettings,
              startMigrationWorkflowSettings,
              getMigrationSubtaskSettings,
              listMigrationSubtasksSettings);
      initDefaults(this);
    }

    protected Builder(MigrationServiceStubSettings settings) {
      super(settings);

      createMigrationWorkflowSettings = settings.createMigrationWorkflowSettings.toBuilder();
      getMigrationWorkflowSettings = settings.getMigrationWorkflowSettings.toBuilder();
      listMigrationWorkflowsSettings = settings.listMigrationWorkflowsSettings.toBuilder();
      deleteMigrationWorkflowSettings = settings.deleteMigrationWorkflowSettings.toBuilder();
      startMigrationWorkflowSettings = settings.startMigrationWorkflowSettings.toBuilder();
      getMigrationSubtaskSettings = settings.getMigrationSubtaskSettings.toBuilder();
      listMigrationSubtasksSettings = settings.listMigrationSubtasksSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createMigrationWorkflowSettings,
              getMigrationWorkflowSettings,
              listMigrationWorkflowsSettings,
              deleteMigrationWorkflowSettings,
              startMigrationWorkflowSettings,
              getMigrationSubtaskSettings,
              listMigrationSubtasksSettings);
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

    private static Builder createHttpJsonDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultHttpJsonTransportProviderBuilder().build());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultHttpJsonApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .createMigrationWorkflowSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getMigrationWorkflowSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listMigrationWorkflowsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteMigrationWorkflowSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .startMigrationWorkflowSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getMigrationSubtaskSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listMigrationSubtasksSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      return builder;
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, settingsUpdater);
      return this;
    }

    public ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders() {
      return unaryMethodSettingsBuilders;
    }

    /** Returns the builder for the settings used for calls to createMigrationWorkflow. */
    public UnaryCallSettings.Builder<CreateMigrationWorkflowRequest, MigrationWorkflow>
        createMigrationWorkflowSettings() {
      return createMigrationWorkflowSettings;
    }

    /** Returns the builder for the settings used for calls to getMigrationWorkflow. */
    public UnaryCallSettings.Builder<GetMigrationWorkflowRequest, MigrationWorkflow>
        getMigrationWorkflowSettings() {
      return getMigrationWorkflowSettings;
    }

    /** Returns the builder for the settings used for calls to listMigrationWorkflows. */
    public PagedCallSettings.Builder<
            ListMigrationWorkflowsRequest,
            ListMigrationWorkflowsResponse,
            ListMigrationWorkflowsPagedResponse>
        listMigrationWorkflowsSettings() {
      return listMigrationWorkflowsSettings;
    }

    /** Returns the builder for the settings used for calls to deleteMigrationWorkflow. */
    public UnaryCallSettings.Builder<DeleteMigrationWorkflowRequest, Empty>
        deleteMigrationWorkflowSettings() {
      return deleteMigrationWorkflowSettings;
    }

    /** Returns the builder for the settings used for calls to startMigrationWorkflow. */
    public UnaryCallSettings.Builder<StartMigrationWorkflowRequest, Empty>
        startMigrationWorkflowSettings() {
      return startMigrationWorkflowSettings;
    }

    /** Returns the builder for the settings used for calls to getMigrationSubtask. */
    public UnaryCallSettings.Builder<GetMigrationSubtaskRequest, MigrationSubtask>
        getMigrationSubtaskSettings() {
      return getMigrationSubtaskSettings;
    }

    /** Returns the builder for the settings used for calls to listMigrationSubtasks. */
    public PagedCallSettings.Builder<
            ListMigrationSubtasksRequest,
            ListMigrationSubtasksResponse,
            ListMigrationSubtasksPagedResponse>
        listMigrationSubtasksSettings() {
      return listMigrationSubtasksSettings;
    }

    @Override
    public MigrationServiceStubSettings build() throws IOException {
      return new MigrationServiceStubSettings(this);
    }
  }
}
