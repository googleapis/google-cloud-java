/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.chronicle.v1.stub;

import static com.google.cloud.chronicle.v1.DataAccessControlServiceClient.ListDataAccessLabelsPagedResponse;
import static com.google.cloud.chronicle.v1.DataAccessControlServiceClient.ListDataAccessScopesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.core.ObsoleteApi;
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
import com.google.cloud.chronicle.v1.CreateDataAccessLabelRequest;
import com.google.cloud.chronicle.v1.CreateDataAccessScopeRequest;
import com.google.cloud.chronicle.v1.DataAccessLabel;
import com.google.cloud.chronicle.v1.DataAccessScope;
import com.google.cloud.chronicle.v1.DeleteDataAccessLabelRequest;
import com.google.cloud.chronicle.v1.DeleteDataAccessScopeRequest;
import com.google.cloud.chronicle.v1.GetDataAccessLabelRequest;
import com.google.cloud.chronicle.v1.GetDataAccessScopeRequest;
import com.google.cloud.chronicle.v1.ListDataAccessLabelsRequest;
import com.google.cloud.chronicle.v1.ListDataAccessLabelsResponse;
import com.google.cloud.chronicle.v1.ListDataAccessScopesRequest;
import com.google.cloud.chronicle.v1.ListDataAccessScopesResponse;
import com.google.cloud.chronicle.v1.UpdateDataAccessLabelRequest;
import com.google.cloud.chronicle.v1.UpdateDataAccessScopeRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link DataAccessControlServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (chronicle.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of createDataAccessLabel:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DataAccessControlServiceStubSettings.Builder dataAccessControlServiceSettingsBuilder =
 *     DataAccessControlServiceStubSettings.newBuilder();
 * dataAccessControlServiceSettingsBuilder
 *     .createDataAccessLabelSettings()
 *     .setRetrySettings(
 *         dataAccessControlServiceSettingsBuilder
 *             .createDataAccessLabelSettings()
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
 * DataAccessControlServiceStubSettings dataAccessControlServiceSettings =
 *     dataAccessControlServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 */
@Generated("by gapic-generator-java")
public class DataAccessControlServiceStubSettings
    extends StubSettings<DataAccessControlServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateDataAccessLabelRequest, DataAccessLabel>
      createDataAccessLabelSettings;
  private final UnaryCallSettings<GetDataAccessLabelRequest, DataAccessLabel>
      getDataAccessLabelSettings;
  private final PagedCallSettings<
          ListDataAccessLabelsRequest,
          ListDataAccessLabelsResponse,
          ListDataAccessLabelsPagedResponse>
      listDataAccessLabelsSettings;
  private final UnaryCallSettings<UpdateDataAccessLabelRequest, DataAccessLabel>
      updateDataAccessLabelSettings;
  private final UnaryCallSettings<DeleteDataAccessLabelRequest, Empty>
      deleteDataAccessLabelSettings;
  private final UnaryCallSettings<CreateDataAccessScopeRequest, DataAccessScope>
      createDataAccessScopeSettings;
  private final UnaryCallSettings<GetDataAccessScopeRequest, DataAccessScope>
      getDataAccessScopeSettings;
  private final PagedCallSettings<
          ListDataAccessScopesRequest,
          ListDataAccessScopesResponse,
          ListDataAccessScopesPagedResponse>
      listDataAccessScopesSettings;
  private final UnaryCallSettings<UpdateDataAccessScopeRequest, DataAccessScope>
      updateDataAccessScopeSettings;
  private final UnaryCallSettings<DeleteDataAccessScopeRequest, Empty>
      deleteDataAccessScopeSettings;

  private static final PagedListDescriptor<
          ListDataAccessLabelsRequest, ListDataAccessLabelsResponse, DataAccessLabel>
      LIST_DATA_ACCESS_LABELS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListDataAccessLabelsRequest, ListDataAccessLabelsResponse, DataAccessLabel>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDataAccessLabelsRequest injectToken(
                ListDataAccessLabelsRequest payload, String token) {
              return ListDataAccessLabelsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListDataAccessLabelsRequest injectPageSize(
                ListDataAccessLabelsRequest payload, int pageSize) {
              return ListDataAccessLabelsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListDataAccessLabelsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDataAccessLabelsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<DataAccessLabel> extractResources(
                ListDataAccessLabelsResponse payload) {
              return payload.getDataAccessLabelsList();
            }
          };

  private static final PagedListDescriptor<
          ListDataAccessScopesRequest, ListDataAccessScopesResponse, DataAccessScope>
      LIST_DATA_ACCESS_SCOPES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListDataAccessScopesRequest, ListDataAccessScopesResponse, DataAccessScope>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDataAccessScopesRequest injectToken(
                ListDataAccessScopesRequest payload, String token) {
              return ListDataAccessScopesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListDataAccessScopesRequest injectPageSize(
                ListDataAccessScopesRequest payload, int pageSize) {
              return ListDataAccessScopesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListDataAccessScopesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDataAccessScopesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<DataAccessScope> extractResources(
                ListDataAccessScopesResponse payload) {
              return payload.getDataAccessScopesList();
            }
          };

  private static final PagedListResponseFactory<
          ListDataAccessLabelsRequest,
          ListDataAccessLabelsResponse,
          ListDataAccessLabelsPagedResponse>
      LIST_DATA_ACCESS_LABELS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDataAccessLabelsRequest,
              ListDataAccessLabelsResponse,
              ListDataAccessLabelsPagedResponse>() {
            @Override
            public ApiFuture<ListDataAccessLabelsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDataAccessLabelsRequest, ListDataAccessLabelsResponse> callable,
                ListDataAccessLabelsRequest request,
                ApiCallContext context,
                ApiFuture<ListDataAccessLabelsResponse> futureResponse) {
              PageContext<
                      ListDataAccessLabelsRequest, ListDataAccessLabelsResponse, DataAccessLabel>
                  pageContext =
                      PageContext.create(
                          callable, LIST_DATA_ACCESS_LABELS_PAGE_STR_DESC, request, context);
              return ListDataAccessLabelsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListDataAccessScopesRequest,
          ListDataAccessScopesResponse,
          ListDataAccessScopesPagedResponse>
      LIST_DATA_ACCESS_SCOPES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDataAccessScopesRequest,
              ListDataAccessScopesResponse,
              ListDataAccessScopesPagedResponse>() {
            @Override
            public ApiFuture<ListDataAccessScopesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDataAccessScopesRequest, ListDataAccessScopesResponse> callable,
                ListDataAccessScopesRequest request,
                ApiCallContext context,
                ApiFuture<ListDataAccessScopesResponse> futureResponse) {
              PageContext<
                      ListDataAccessScopesRequest, ListDataAccessScopesResponse, DataAccessScope>
                  pageContext =
                      PageContext.create(
                          callable, LIST_DATA_ACCESS_SCOPES_PAGE_STR_DESC, request, context);
              return ListDataAccessScopesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createDataAccessLabel. */
  public UnaryCallSettings<CreateDataAccessLabelRequest, DataAccessLabel>
      createDataAccessLabelSettings() {
    return createDataAccessLabelSettings;
  }

  /** Returns the object with the settings used for calls to getDataAccessLabel. */
  public UnaryCallSettings<GetDataAccessLabelRequest, DataAccessLabel>
      getDataAccessLabelSettings() {
    return getDataAccessLabelSettings;
  }

  /** Returns the object with the settings used for calls to listDataAccessLabels. */
  public PagedCallSettings<
          ListDataAccessLabelsRequest,
          ListDataAccessLabelsResponse,
          ListDataAccessLabelsPagedResponse>
      listDataAccessLabelsSettings() {
    return listDataAccessLabelsSettings;
  }

  /** Returns the object with the settings used for calls to updateDataAccessLabel. */
  public UnaryCallSettings<UpdateDataAccessLabelRequest, DataAccessLabel>
      updateDataAccessLabelSettings() {
    return updateDataAccessLabelSettings;
  }

  /** Returns the object with the settings used for calls to deleteDataAccessLabel. */
  public UnaryCallSettings<DeleteDataAccessLabelRequest, Empty> deleteDataAccessLabelSettings() {
    return deleteDataAccessLabelSettings;
  }

  /** Returns the object with the settings used for calls to createDataAccessScope. */
  public UnaryCallSettings<CreateDataAccessScopeRequest, DataAccessScope>
      createDataAccessScopeSettings() {
    return createDataAccessScopeSettings;
  }

  /** Returns the object with the settings used for calls to getDataAccessScope. */
  public UnaryCallSettings<GetDataAccessScopeRequest, DataAccessScope>
      getDataAccessScopeSettings() {
    return getDataAccessScopeSettings;
  }

  /** Returns the object with the settings used for calls to listDataAccessScopes. */
  public PagedCallSettings<
          ListDataAccessScopesRequest,
          ListDataAccessScopesResponse,
          ListDataAccessScopesPagedResponse>
      listDataAccessScopesSettings() {
    return listDataAccessScopesSettings;
  }

  /** Returns the object with the settings used for calls to updateDataAccessScope. */
  public UnaryCallSettings<UpdateDataAccessScopeRequest, DataAccessScope>
      updateDataAccessScopeSettings() {
    return updateDataAccessScopeSettings;
  }

  /** Returns the object with the settings used for calls to deleteDataAccessScope. */
  public UnaryCallSettings<DeleteDataAccessScopeRequest, Empty> deleteDataAccessScopeSettings() {
    return deleteDataAccessScopeSettings;
  }

  public DataAccessControlServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcDataAccessControlServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonDataAccessControlServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "chronicle";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "chronicle.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "chronicle.mtls.googleapis.com:443";
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

  public static ApiClientHeaderProvider.Builder defaultGrpcApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(DataAccessControlServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(DataAccessControlServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DataAccessControlServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected DataAccessControlServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createDataAccessLabelSettings = settingsBuilder.createDataAccessLabelSettings().build();
    getDataAccessLabelSettings = settingsBuilder.getDataAccessLabelSettings().build();
    listDataAccessLabelsSettings = settingsBuilder.listDataAccessLabelsSettings().build();
    updateDataAccessLabelSettings = settingsBuilder.updateDataAccessLabelSettings().build();
    deleteDataAccessLabelSettings = settingsBuilder.deleteDataAccessLabelSettings().build();
    createDataAccessScopeSettings = settingsBuilder.createDataAccessScopeSettings().build();
    getDataAccessScopeSettings = settingsBuilder.getDataAccessScopeSettings().build();
    listDataAccessScopesSettings = settingsBuilder.listDataAccessScopesSettings().build();
    updateDataAccessScopeSettings = settingsBuilder.updateDataAccessScopeSettings().build();
    deleteDataAccessScopeSettings = settingsBuilder.deleteDataAccessScopeSettings().build();
  }

  /** Builder for DataAccessControlServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<DataAccessControlServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateDataAccessLabelRequest, DataAccessLabel>
        createDataAccessLabelSettings;
    private final UnaryCallSettings.Builder<GetDataAccessLabelRequest, DataAccessLabel>
        getDataAccessLabelSettings;
    private final PagedCallSettings.Builder<
            ListDataAccessLabelsRequest,
            ListDataAccessLabelsResponse,
            ListDataAccessLabelsPagedResponse>
        listDataAccessLabelsSettings;
    private final UnaryCallSettings.Builder<UpdateDataAccessLabelRequest, DataAccessLabel>
        updateDataAccessLabelSettings;
    private final UnaryCallSettings.Builder<DeleteDataAccessLabelRequest, Empty>
        deleteDataAccessLabelSettings;
    private final UnaryCallSettings.Builder<CreateDataAccessScopeRequest, DataAccessScope>
        createDataAccessScopeSettings;
    private final UnaryCallSettings.Builder<GetDataAccessScopeRequest, DataAccessScope>
        getDataAccessScopeSettings;
    private final PagedCallSettings.Builder<
            ListDataAccessScopesRequest,
            ListDataAccessScopesResponse,
            ListDataAccessScopesPagedResponse>
        listDataAccessScopesSettings;
    private final UnaryCallSettings.Builder<UpdateDataAccessScopeRequest, DataAccessScope>
        updateDataAccessScopeSettings;
    private final UnaryCallSettings.Builder<DeleteDataAccessScopeRequest, Empty>
        deleteDataAccessScopeSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "no_retry_3_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
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
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_3_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelayDuration(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelayDuration(Duration.ofMillis(60000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createDataAccessLabelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getDataAccessLabelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listDataAccessLabelsSettings =
          PagedCallSettings.newBuilder(LIST_DATA_ACCESS_LABELS_PAGE_STR_FACT);
      updateDataAccessLabelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteDataAccessLabelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createDataAccessScopeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getDataAccessScopeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listDataAccessScopesSettings =
          PagedCallSettings.newBuilder(LIST_DATA_ACCESS_SCOPES_PAGE_STR_FACT);
      updateDataAccessScopeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteDataAccessScopeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createDataAccessLabelSettings,
              getDataAccessLabelSettings,
              listDataAccessLabelsSettings,
              updateDataAccessLabelSettings,
              deleteDataAccessLabelSettings,
              createDataAccessScopeSettings,
              getDataAccessScopeSettings,
              listDataAccessScopesSettings,
              updateDataAccessScopeSettings,
              deleteDataAccessScopeSettings);
      initDefaults(this);
    }

    protected Builder(DataAccessControlServiceStubSettings settings) {
      super(settings);

      createDataAccessLabelSettings = settings.createDataAccessLabelSettings.toBuilder();
      getDataAccessLabelSettings = settings.getDataAccessLabelSettings.toBuilder();
      listDataAccessLabelsSettings = settings.listDataAccessLabelsSettings.toBuilder();
      updateDataAccessLabelSettings = settings.updateDataAccessLabelSettings.toBuilder();
      deleteDataAccessLabelSettings = settings.deleteDataAccessLabelSettings.toBuilder();
      createDataAccessScopeSettings = settings.createDataAccessScopeSettings.toBuilder();
      getDataAccessScopeSettings = settings.getDataAccessScopeSettings.toBuilder();
      listDataAccessScopesSettings = settings.listDataAccessScopesSettings.toBuilder();
      updateDataAccessScopeSettings = settings.updateDataAccessScopeSettings.toBuilder();
      deleteDataAccessScopeSettings = settings.deleteDataAccessScopeSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createDataAccessLabelSettings,
              getDataAccessLabelSettings,
              listDataAccessLabelsSettings,
              updateDataAccessLabelSettings,
              deleteDataAccessLabelSettings,
              createDataAccessScopeSettings,
              getDataAccessScopeSettings,
              listDataAccessScopesSettings,
              updateDataAccessScopeSettings,
              deleteDataAccessScopeSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder createHttpJsonDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultHttpJsonTransportProviderBuilder().build());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultHttpJsonApiClientHeaderProviderBuilder().build());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .createDataAccessLabelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_3_params"));

      builder
          .getDataAccessLabelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listDataAccessLabelsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateDataAccessLabelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_3_params"));

      builder
          .deleteDataAccessLabelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_3_params"));

      builder
          .createDataAccessScopeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_3_params"));

      builder
          .getDataAccessScopeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listDataAccessScopesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateDataAccessScopeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_3_params"));

      builder
          .deleteDataAccessScopeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_3_params"));

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

    /** Returns the builder for the settings used for calls to createDataAccessLabel. */
    public UnaryCallSettings.Builder<CreateDataAccessLabelRequest, DataAccessLabel>
        createDataAccessLabelSettings() {
      return createDataAccessLabelSettings;
    }

    /** Returns the builder for the settings used for calls to getDataAccessLabel. */
    public UnaryCallSettings.Builder<GetDataAccessLabelRequest, DataAccessLabel>
        getDataAccessLabelSettings() {
      return getDataAccessLabelSettings;
    }

    /** Returns the builder for the settings used for calls to listDataAccessLabels. */
    public PagedCallSettings.Builder<
            ListDataAccessLabelsRequest,
            ListDataAccessLabelsResponse,
            ListDataAccessLabelsPagedResponse>
        listDataAccessLabelsSettings() {
      return listDataAccessLabelsSettings;
    }

    /** Returns the builder for the settings used for calls to updateDataAccessLabel. */
    public UnaryCallSettings.Builder<UpdateDataAccessLabelRequest, DataAccessLabel>
        updateDataAccessLabelSettings() {
      return updateDataAccessLabelSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDataAccessLabel. */
    public UnaryCallSettings.Builder<DeleteDataAccessLabelRequest, Empty>
        deleteDataAccessLabelSettings() {
      return deleteDataAccessLabelSettings;
    }

    /** Returns the builder for the settings used for calls to createDataAccessScope. */
    public UnaryCallSettings.Builder<CreateDataAccessScopeRequest, DataAccessScope>
        createDataAccessScopeSettings() {
      return createDataAccessScopeSettings;
    }

    /** Returns the builder for the settings used for calls to getDataAccessScope. */
    public UnaryCallSettings.Builder<GetDataAccessScopeRequest, DataAccessScope>
        getDataAccessScopeSettings() {
      return getDataAccessScopeSettings;
    }

    /** Returns the builder for the settings used for calls to listDataAccessScopes. */
    public PagedCallSettings.Builder<
            ListDataAccessScopesRequest,
            ListDataAccessScopesResponse,
            ListDataAccessScopesPagedResponse>
        listDataAccessScopesSettings() {
      return listDataAccessScopesSettings;
    }

    /** Returns the builder for the settings used for calls to updateDataAccessScope. */
    public UnaryCallSettings.Builder<UpdateDataAccessScopeRequest, DataAccessScope>
        updateDataAccessScopeSettings() {
      return updateDataAccessScopeSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDataAccessScope. */
    public UnaryCallSettings.Builder<DeleteDataAccessScopeRequest, Empty>
        deleteDataAccessScopeSettings() {
      return deleteDataAccessScopeSettings;
    }

    @Override
    public DataAccessControlServiceStubSettings build() throws IOException {
      return new DataAccessControlServiceStubSettings(this);
    }
  }
}
