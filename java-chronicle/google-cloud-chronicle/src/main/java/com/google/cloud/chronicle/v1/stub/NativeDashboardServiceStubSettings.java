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

package com.google.cloud.chronicle.v1.stub;

import static com.google.cloud.chronicle.v1.NativeDashboardServiceClient.ListNativeDashboardsPagedResponse;

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
import com.google.api.gax.rpc.LibraryMetadata;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.chronicle.v1.AddChartRequest;
import com.google.cloud.chronicle.v1.AddChartResponse;
import com.google.cloud.chronicle.v1.CreateNativeDashboardRequest;
import com.google.cloud.chronicle.v1.DeleteNativeDashboardRequest;
import com.google.cloud.chronicle.v1.DuplicateChartRequest;
import com.google.cloud.chronicle.v1.DuplicateChartResponse;
import com.google.cloud.chronicle.v1.DuplicateNativeDashboardRequest;
import com.google.cloud.chronicle.v1.EditChartRequest;
import com.google.cloud.chronicle.v1.EditChartResponse;
import com.google.cloud.chronicle.v1.ExportNativeDashboardsRequest;
import com.google.cloud.chronicle.v1.ExportNativeDashboardsResponse;
import com.google.cloud.chronicle.v1.GetNativeDashboardRequest;
import com.google.cloud.chronicle.v1.ImportNativeDashboardsRequest;
import com.google.cloud.chronicle.v1.ImportNativeDashboardsResponse;
import com.google.cloud.chronicle.v1.ListNativeDashboardsRequest;
import com.google.cloud.chronicle.v1.ListNativeDashboardsResponse;
import com.google.cloud.chronicle.v1.NativeDashboard;
import com.google.cloud.chronicle.v1.RemoveChartRequest;
import com.google.cloud.chronicle.v1.UpdateNativeDashboardRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link NativeDashboardServiceStub}.
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
 * of createNativeDashboard:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * NativeDashboardServiceStubSettings.Builder nativeDashboardServiceSettingsBuilder =
 *     NativeDashboardServiceStubSettings.newBuilder();
 * nativeDashboardServiceSettingsBuilder
 *     .createNativeDashboardSettings()
 *     .setRetrySettings(
 *         nativeDashboardServiceSettingsBuilder
 *             .createNativeDashboardSettings()
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
 * NativeDashboardServiceStubSettings nativeDashboardServiceSettings =
 *     nativeDashboardServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@NullMarked
@Generated("by gapic-generator-java")
@SuppressWarnings("CanonicalDuration")
public class NativeDashboardServiceStubSettings
    extends StubSettings<NativeDashboardServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/chronicle")
          .add("https://www.googleapis.com/auth/chronicle.readonly")
          .add("https://www.googleapis.com/auth/cloud-platform")
          .build();

  private final UnaryCallSettings<CreateNativeDashboardRequest, NativeDashboard>
      createNativeDashboardSettings;
  private final UnaryCallSettings<GetNativeDashboardRequest, NativeDashboard>
      getNativeDashboardSettings;
  private final PagedCallSettings<
          ListNativeDashboardsRequest,
          ListNativeDashboardsResponse,
          ListNativeDashboardsPagedResponse>
      listNativeDashboardsSettings;
  private final UnaryCallSettings<UpdateNativeDashboardRequest, NativeDashboard>
      updateNativeDashboardSettings;
  private final UnaryCallSettings<DuplicateNativeDashboardRequest, NativeDashboard>
      duplicateNativeDashboardSettings;
  private final UnaryCallSettings<DeleteNativeDashboardRequest, Empty>
      deleteNativeDashboardSettings;
  private final UnaryCallSettings<AddChartRequest, AddChartResponse> addChartSettings;
  private final UnaryCallSettings<RemoveChartRequest, NativeDashboard> removeChartSettings;
  private final UnaryCallSettings<EditChartRequest, EditChartResponse> editChartSettings;
  private final UnaryCallSettings<DuplicateChartRequest, DuplicateChartResponse>
      duplicateChartSettings;
  private final UnaryCallSettings<ExportNativeDashboardsRequest, ExportNativeDashboardsResponse>
      exportNativeDashboardsSettings;
  private final UnaryCallSettings<ImportNativeDashboardsRequest, ImportNativeDashboardsResponse>
      importNativeDashboardsSettings;

  private static final PagedListDescriptor<
          ListNativeDashboardsRequest, ListNativeDashboardsResponse, NativeDashboard>
      LIST_NATIVE_DASHBOARDS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListNativeDashboardsRequest, ListNativeDashboardsResponse, NativeDashboard>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListNativeDashboardsRequest injectToken(
                ListNativeDashboardsRequest payload, String token) {
              return ListNativeDashboardsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListNativeDashboardsRequest injectPageSize(
                ListNativeDashboardsRequest payload, int pageSize) {
              return ListNativeDashboardsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListNativeDashboardsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListNativeDashboardsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<NativeDashboard> extractResources(
                ListNativeDashboardsResponse payload) {
              return payload.getNativeDashboardsList();
            }
          };

  private static final PagedListResponseFactory<
          ListNativeDashboardsRequest,
          ListNativeDashboardsResponse,
          ListNativeDashboardsPagedResponse>
      LIST_NATIVE_DASHBOARDS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListNativeDashboardsRequest,
              ListNativeDashboardsResponse,
              ListNativeDashboardsPagedResponse>() {
            @Override
            public ApiFuture<ListNativeDashboardsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListNativeDashboardsRequest, ListNativeDashboardsResponse> callable,
                ListNativeDashboardsRequest request,
                ApiCallContext context,
                ApiFuture<ListNativeDashboardsResponse> futureResponse) {
              PageContext<
                      ListNativeDashboardsRequest, ListNativeDashboardsResponse, NativeDashboard>
                  pageContext =
                      PageContext.create(
                          callable, LIST_NATIVE_DASHBOARDS_PAGE_STR_DESC, request, context);
              return ListNativeDashboardsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createNativeDashboard. */
  public UnaryCallSettings<CreateNativeDashboardRequest, NativeDashboard>
      createNativeDashboardSettings() {
    return createNativeDashboardSettings;
  }

  /** Returns the object with the settings used for calls to getNativeDashboard. */
  public UnaryCallSettings<GetNativeDashboardRequest, NativeDashboard>
      getNativeDashboardSettings() {
    return getNativeDashboardSettings;
  }

  /** Returns the object with the settings used for calls to listNativeDashboards. */
  public PagedCallSettings<
          ListNativeDashboardsRequest,
          ListNativeDashboardsResponse,
          ListNativeDashboardsPagedResponse>
      listNativeDashboardsSettings() {
    return listNativeDashboardsSettings;
  }

  /** Returns the object with the settings used for calls to updateNativeDashboard. */
  public UnaryCallSettings<UpdateNativeDashboardRequest, NativeDashboard>
      updateNativeDashboardSettings() {
    return updateNativeDashboardSettings;
  }

  /** Returns the object with the settings used for calls to duplicateNativeDashboard. */
  public UnaryCallSettings<DuplicateNativeDashboardRequest, NativeDashboard>
      duplicateNativeDashboardSettings() {
    return duplicateNativeDashboardSettings;
  }

  /** Returns the object with the settings used for calls to deleteNativeDashboard. */
  public UnaryCallSettings<DeleteNativeDashboardRequest, Empty> deleteNativeDashboardSettings() {
    return deleteNativeDashboardSettings;
  }

  /** Returns the object with the settings used for calls to addChart. */
  public UnaryCallSettings<AddChartRequest, AddChartResponse> addChartSettings() {
    return addChartSettings;
  }

  /** Returns the object with the settings used for calls to removeChart. */
  public UnaryCallSettings<RemoveChartRequest, NativeDashboard> removeChartSettings() {
    return removeChartSettings;
  }

  /** Returns the object with the settings used for calls to editChart. */
  public UnaryCallSettings<EditChartRequest, EditChartResponse> editChartSettings() {
    return editChartSettings;
  }

  /** Returns the object with the settings used for calls to duplicateChart. */
  public UnaryCallSettings<DuplicateChartRequest, DuplicateChartResponse> duplicateChartSettings() {
    return duplicateChartSettings;
  }

  /** Returns the object with the settings used for calls to exportNativeDashboards. */
  public UnaryCallSettings<ExportNativeDashboardsRequest, ExportNativeDashboardsResponse>
      exportNativeDashboardsSettings() {
    return exportNativeDashboardsSettings;
  }

  /** Returns the object with the settings used for calls to importNativeDashboards. */
  public UnaryCallSettings<ImportNativeDashboardsRequest, ImportNativeDashboardsResponse>
      importNativeDashboardsSettings() {
    return importNativeDashboardsSettings;
  }

  public NativeDashboardServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcNativeDashboardServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonNativeDashboardServiceStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(NativeDashboardServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(NativeDashboardServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return NativeDashboardServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected NativeDashboardServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createNativeDashboardSettings = settingsBuilder.createNativeDashboardSettings().build();
    getNativeDashboardSettings = settingsBuilder.getNativeDashboardSettings().build();
    listNativeDashboardsSettings = settingsBuilder.listNativeDashboardsSettings().build();
    updateNativeDashboardSettings = settingsBuilder.updateNativeDashboardSettings().build();
    duplicateNativeDashboardSettings = settingsBuilder.duplicateNativeDashboardSettings().build();
    deleteNativeDashboardSettings = settingsBuilder.deleteNativeDashboardSettings().build();
    addChartSettings = settingsBuilder.addChartSettings().build();
    removeChartSettings = settingsBuilder.removeChartSettings().build();
    editChartSettings = settingsBuilder.editChartSettings().build();
    duplicateChartSettings = settingsBuilder.duplicateChartSettings().build();
    exportNativeDashboardsSettings = settingsBuilder.exportNativeDashboardsSettings().build();
    importNativeDashboardsSettings = settingsBuilder.importNativeDashboardsSettings().build();
  }

  @Override
  protected LibraryMetadata getLibraryMetadata() {
    return LibraryMetadata.newBuilder()
        .setArtifactName("com.google.cloud:google-cloud-chronicle")
        .setRepository("googleapis/google-cloud-java")
        .setVersion(Version.VERSION)
        .build();
  }

  /** Builder for NativeDashboardServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<NativeDashboardServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateNativeDashboardRequest, NativeDashboard>
        createNativeDashboardSettings;
    private final UnaryCallSettings.Builder<GetNativeDashboardRequest, NativeDashboard>
        getNativeDashboardSettings;
    private final PagedCallSettings.Builder<
            ListNativeDashboardsRequest,
            ListNativeDashboardsResponse,
            ListNativeDashboardsPagedResponse>
        listNativeDashboardsSettings;
    private final UnaryCallSettings.Builder<UpdateNativeDashboardRequest, NativeDashboard>
        updateNativeDashboardSettings;
    private final UnaryCallSettings.Builder<DuplicateNativeDashboardRequest, NativeDashboard>
        duplicateNativeDashboardSettings;
    private final UnaryCallSettings.Builder<DeleteNativeDashboardRequest, Empty>
        deleteNativeDashboardSettings;
    private final UnaryCallSettings.Builder<AddChartRequest, AddChartResponse> addChartSettings;
    private final UnaryCallSettings.Builder<RemoveChartRequest, NativeDashboard>
        removeChartSettings;
    private final UnaryCallSettings.Builder<EditChartRequest, EditChartResponse> editChartSettings;
    private final UnaryCallSettings.Builder<DuplicateChartRequest, DuplicateChartResponse>
        duplicateChartSettings;
    private final UnaryCallSettings.Builder<
            ExportNativeDashboardsRequest, ExportNativeDashboardsResponse>
        exportNativeDashboardsSettings;
    private final UnaryCallSettings.Builder<
            ImportNativeDashboardsRequest, ImportNativeDashboardsResponse>
        importNativeDashboardsSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "no_retry_5_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
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
      definitions.put("no_retry_5_params", settings);
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

      createNativeDashboardSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getNativeDashboardSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listNativeDashboardsSettings =
          PagedCallSettings.newBuilder(LIST_NATIVE_DASHBOARDS_PAGE_STR_FACT);
      updateNativeDashboardSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      duplicateNativeDashboardSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteNativeDashboardSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      addChartSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      removeChartSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      editChartSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      duplicateChartSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      exportNativeDashboardsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      importNativeDashboardsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createNativeDashboardSettings,
              getNativeDashboardSettings,
              listNativeDashboardsSettings,
              updateNativeDashboardSettings,
              duplicateNativeDashboardSettings,
              deleteNativeDashboardSettings,
              addChartSettings,
              removeChartSettings,
              editChartSettings,
              duplicateChartSettings,
              exportNativeDashboardsSettings,
              importNativeDashboardsSettings);
      initDefaults(this);
    }

    protected Builder(NativeDashboardServiceStubSettings settings) {
      super(settings);

      createNativeDashboardSettings = settings.createNativeDashboardSettings.toBuilder();
      getNativeDashboardSettings = settings.getNativeDashboardSettings.toBuilder();
      listNativeDashboardsSettings = settings.listNativeDashboardsSettings.toBuilder();
      updateNativeDashboardSettings = settings.updateNativeDashboardSettings.toBuilder();
      duplicateNativeDashboardSettings = settings.duplicateNativeDashboardSettings.toBuilder();
      deleteNativeDashboardSettings = settings.deleteNativeDashboardSettings.toBuilder();
      addChartSettings = settings.addChartSettings.toBuilder();
      removeChartSettings = settings.removeChartSettings.toBuilder();
      editChartSettings = settings.editChartSettings.toBuilder();
      duplicateChartSettings = settings.duplicateChartSettings.toBuilder();
      exportNativeDashboardsSettings = settings.exportNativeDashboardsSettings.toBuilder();
      importNativeDashboardsSettings = settings.importNativeDashboardsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createNativeDashboardSettings,
              getNativeDashboardSettings,
              listNativeDashboardsSettings,
              updateNativeDashboardSettings,
              duplicateNativeDashboardSettings,
              deleteNativeDashboardSettings,
              addChartSettings,
              removeChartSettings,
              editChartSettings,
              duplicateChartSettings,
              exportNativeDashboardsSettings,
              importNativeDashboardsSettings);
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
          .createNativeDashboardSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_5_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_5_params"));

      builder
          .getNativeDashboardSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listNativeDashboardsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateNativeDashboardSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_5_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_5_params"));

      builder
          .duplicateNativeDashboardSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_5_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_5_params"));

      builder
          .deleteNativeDashboardSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_5_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_5_params"));

      builder
          .addChartSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_5_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_5_params"));

      builder
          .removeChartSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_5_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_5_params"));

      builder
          .editChartSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_5_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_5_params"));

      builder
          .duplicateChartSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_5_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_5_params"));

      builder
          .exportNativeDashboardsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .importNativeDashboardsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_5_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_5_params"));

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

    /** Returns the builder for the settings used for calls to createNativeDashboard. */
    public UnaryCallSettings.Builder<CreateNativeDashboardRequest, NativeDashboard>
        createNativeDashboardSettings() {
      return createNativeDashboardSettings;
    }

    /** Returns the builder for the settings used for calls to getNativeDashboard. */
    public UnaryCallSettings.Builder<GetNativeDashboardRequest, NativeDashboard>
        getNativeDashboardSettings() {
      return getNativeDashboardSettings;
    }

    /** Returns the builder for the settings used for calls to listNativeDashboards. */
    public PagedCallSettings.Builder<
            ListNativeDashboardsRequest,
            ListNativeDashboardsResponse,
            ListNativeDashboardsPagedResponse>
        listNativeDashboardsSettings() {
      return listNativeDashboardsSettings;
    }

    /** Returns the builder for the settings used for calls to updateNativeDashboard. */
    public UnaryCallSettings.Builder<UpdateNativeDashboardRequest, NativeDashboard>
        updateNativeDashboardSettings() {
      return updateNativeDashboardSettings;
    }

    /** Returns the builder for the settings used for calls to duplicateNativeDashboard. */
    public UnaryCallSettings.Builder<DuplicateNativeDashboardRequest, NativeDashboard>
        duplicateNativeDashboardSettings() {
      return duplicateNativeDashboardSettings;
    }

    /** Returns the builder for the settings used for calls to deleteNativeDashboard. */
    public UnaryCallSettings.Builder<DeleteNativeDashboardRequest, Empty>
        deleteNativeDashboardSettings() {
      return deleteNativeDashboardSettings;
    }

    /** Returns the builder for the settings used for calls to addChart. */
    public UnaryCallSettings.Builder<AddChartRequest, AddChartResponse> addChartSettings() {
      return addChartSettings;
    }

    /** Returns the builder for the settings used for calls to removeChart. */
    public UnaryCallSettings.Builder<RemoveChartRequest, NativeDashboard> removeChartSettings() {
      return removeChartSettings;
    }

    /** Returns the builder for the settings used for calls to editChart. */
    public UnaryCallSettings.Builder<EditChartRequest, EditChartResponse> editChartSettings() {
      return editChartSettings;
    }

    /** Returns the builder for the settings used for calls to duplicateChart. */
    public UnaryCallSettings.Builder<DuplicateChartRequest, DuplicateChartResponse>
        duplicateChartSettings() {
      return duplicateChartSettings;
    }

    /** Returns the builder for the settings used for calls to exportNativeDashboards. */
    public UnaryCallSettings.Builder<ExportNativeDashboardsRequest, ExportNativeDashboardsResponse>
        exportNativeDashboardsSettings() {
      return exportNativeDashboardsSettings;
    }

    /** Returns the builder for the settings used for calls to importNativeDashboards. */
    public UnaryCallSettings.Builder<ImportNativeDashboardsRequest, ImportNativeDashboardsResponse>
        importNativeDashboardsSettings() {
      return importNativeDashboardsSettings;
    }

    @Override
    public NativeDashboardServiceStubSettings build() throws IOException {
      return new NativeDashboardServiceStubSettings(this);
    }
  }
}
