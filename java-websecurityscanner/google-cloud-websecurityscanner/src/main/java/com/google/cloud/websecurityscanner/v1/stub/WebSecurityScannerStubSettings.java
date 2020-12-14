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

package com.google.cloud.websecurityscanner.v1.stub;

import static com.google.cloud.websecurityscanner.v1.WebSecurityScannerClient.ListCrawledUrlsPagedResponse;
import static com.google.cloud.websecurityscanner.v1.WebSecurityScannerClient.ListFindingsPagedResponse;
import static com.google.cloud.websecurityscanner.v1.WebSecurityScannerClient.ListScanConfigsPagedResponse;
import static com.google.cloud.websecurityscanner.v1.WebSecurityScannerClient.ListScanRunsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
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
import com.google.cloud.websecurityscanner.v1.CrawledUrl;
import com.google.cloud.websecurityscanner.v1.CreateScanConfigRequest;
import com.google.cloud.websecurityscanner.v1.DeleteScanConfigRequest;
import com.google.cloud.websecurityscanner.v1.Finding;
import com.google.cloud.websecurityscanner.v1.GetFindingRequest;
import com.google.cloud.websecurityscanner.v1.GetScanConfigRequest;
import com.google.cloud.websecurityscanner.v1.GetScanRunRequest;
import com.google.cloud.websecurityscanner.v1.ListCrawledUrlsRequest;
import com.google.cloud.websecurityscanner.v1.ListCrawledUrlsResponse;
import com.google.cloud.websecurityscanner.v1.ListFindingTypeStatsRequest;
import com.google.cloud.websecurityscanner.v1.ListFindingTypeStatsResponse;
import com.google.cloud.websecurityscanner.v1.ListFindingsRequest;
import com.google.cloud.websecurityscanner.v1.ListFindingsResponse;
import com.google.cloud.websecurityscanner.v1.ListScanConfigsRequest;
import com.google.cloud.websecurityscanner.v1.ListScanConfigsResponse;
import com.google.cloud.websecurityscanner.v1.ListScanRunsRequest;
import com.google.cloud.websecurityscanner.v1.ListScanRunsResponse;
import com.google.cloud.websecurityscanner.v1.ScanConfig;
import com.google.cloud.websecurityscanner.v1.ScanRun;
import com.google.cloud.websecurityscanner.v1.StartScanRunRequest;
import com.google.cloud.websecurityscanner.v1.StopScanRunRequest;
import com.google.cloud.websecurityscanner.v1.UpdateScanConfigRequest;
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
 * Settings class to configure an instance of {@link WebSecurityScannerStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (websecurityscanner.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createScanConfig to 30 seconds:
 *
 * <pre>{@code
 * WebSecurityScannerStubSettings.Builder webSecurityScannerSettingsBuilder =
 *     WebSecurityScannerStubSettings.newBuilder();
 * webSecurityScannerSettingsBuilder
 *     .createScanConfigSettings()
 *     .setRetrySettings(
 *         webSecurityScannerSettingsBuilder
 *             .createScanConfigSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * WebSecurityScannerStubSettings webSecurityScannerSettings =
 *     webSecurityScannerSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class WebSecurityScannerStubSettings extends StubSettings<WebSecurityScannerStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateScanConfigRequest, ScanConfig> createScanConfigSettings;
  private final UnaryCallSettings<DeleteScanConfigRequest, Empty> deleteScanConfigSettings;
  private final UnaryCallSettings<GetScanConfigRequest, ScanConfig> getScanConfigSettings;
  private final PagedCallSettings<
          ListScanConfigsRequest, ListScanConfigsResponse, ListScanConfigsPagedResponse>
      listScanConfigsSettings;
  private final UnaryCallSettings<UpdateScanConfigRequest, ScanConfig> updateScanConfigSettings;
  private final UnaryCallSettings<StartScanRunRequest, ScanRun> startScanRunSettings;
  private final UnaryCallSettings<GetScanRunRequest, ScanRun> getScanRunSettings;
  private final PagedCallSettings<
          ListScanRunsRequest, ListScanRunsResponse, ListScanRunsPagedResponse>
      listScanRunsSettings;
  private final UnaryCallSettings<StopScanRunRequest, ScanRun> stopScanRunSettings;
  private final PagedCallSettings<
          ListCrawledUrlsRequest, ListCrawledUrlsResponse, ListCrawledUrlsPagedResponse>
      listCrawledUrlsSettings;
  private final UnaryCallSettings<GetFindingRequest, Finding> getFindingSettings;
  private final PagedCallSettings<
          ListFindingsRequest, ListFindingsResponse, ListFindingsPagedResponse>
      listFindingsSettings;
  private final UnaryCallSettings<ListFindingTypeStatsRequest, ListFindingTypeStatsResponse>
      listFindingTypeStatsSettings;

  private static final PagedListDescriptor<
          ListScanConfigsRequest, ListScanConfigsResponse, ScanConfig>
      LIST_SCAN_CONFIGS_PAGE_STR_DESC =
          new PagedListDescriptor<ListScanConfigsRequest, ListScanConfigsResponse, ScanConfig>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListScanConfigsRequest injectToken(
                ListScanConfigsRequest payload, String token) {
              return ListScanConfigsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListScanConfigsRequest injectPageSize(
                ListScanConfigsRequest payload, int pageSize) {
              return ListScanConfigsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListScanConfigsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListScanConfigsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ScanConfig> extractResources(ListScanConfigsResponse payload) {
              return payload.getScanConfigsList() == null
                  ? ImmutableList.<ScanConfig>of()
                  : payload.getScanConfigsList();
            }
          };

  private static final PagedListDescriptor<ListScanRunsRequest, ListScanRunsResponse, ScanRun>
      LIST_SCAN_RUNS_PAGE_STR_DESC =
          new PagedListDescriptor<ListScanRunsRequest, ListScanRunsResponse, ScanRun>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListScanRunsRequest injectToken(ListScanRunsRequest payload, String token) {
              return ListScanRunsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListScanRunsRequest injectPageSize(ListScanRunsRequest payload, int pageSize) {
              return ListScanRunsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListScanRunsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListScanRunsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ScanRun> extractResources(ListScanRunsResponse payload) {
              return payload.getScanRunsList() == null
                  ? ImmutableList.<ScanRun>of()
                  : payload.getScanRunsList();
            }
          };

  private static final PagedListDescriptor<
          ListCrawledUrlsRequest, ListCrawledUrlsResponse, CrawledUrl>
      LIST_CRAWLED_URLS_PAGE_STR_DESC =
          new PagedListDescriptor<ListCrawledUrlsRequest, ListCrawledUrlsResponse, CrawledUrl>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListCrawledUrlsRequest injectToken(
                ListCrawledUrlsRequest payload, String token) {
              return ListCrawledUrlsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListCrawledUrlsRequest injectPageSize(
                ListCrawledUrlsRequest payload, int pageSize) {
              return ListCrawledUrlsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListCrawledUrlsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListCrawledUrlsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<CrawledUrl> extractResources(ListCrawledUrlsResponse payload) {
              return payload.getCrawledUrlsList() == null
                  ? ImmutableList.<CrawledUrl>of()
                  : payload.getCrawledUrlsList();
            }
          };

  private static final PagedListDescriptor<ListFindingsRequest, ListFindingsResponse, Finding>
      LIST_FINDINGS_PAGE_STR_DESC =
          new PagedListDescriptor<ListFindingsRequest, ListFindingsResponse, Finding>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListFindingsRequest injectToken(ListFindingsRequest payload, String token) {
              return ListFindingsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListFindingsRequest injectPageSize(ListFindingsRequest payload, int pageSize) {
              return ListFindingsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListFindingsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListFindingsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Finding> extractResources(ListFindingsResponse payload) {
              return payload.getFindingsList() == null
                  ? ImmutableList.<Finding>of()
                  : payload.getFindingsList();
            }
          };

  private static final PagedListResponseFactory<
          ListScanConfigsRequest, ListScanConfigsResponse, ListScanConfigsPagedResponse>
      LIST_SCAN_CONFIGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListScanConfigsRequest, ListScanConfigsResponse, ListScanConfigsPagedResponse>() {
            @Override
            public ApiFuture<ListScanConfigsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListScanConfigsRequest, ListScanConfigsResponse> callable,
                ListScanConfigsRequest request,
                ApiCallContext context,
                ApiFuture<ListScanConfigsResponse> futureResponse) {
              PageContext<ListScanConfigsRequest, ListScanConfigsResponse, ScanConfig> pageContext =
                  PageContext.create(callable, LIST_SCAN_CONFIGS_PAGE_STR_DESC, request, context);
              return ListScanConfigsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListScanRunsRequest, ListScanRunsResponse, ListScanRunsPagedResponse>
      LIST_SCAN_RUNS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListScanRunsRequest, ListScanRunsResponse, ListScanRunsPagedResponse>() {
            @Override
            public ApiFuture<ListScanRunsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListScanRunsRequest, ListScanRunsResponse> callable,
                ListScanRunsRequest request,
                ApiCallContext context,
                ApiFuture<ListScanRunsResponse> futureResponse) {
              PageContext<ListScanRunsRequest, ListScanRunsResponse, ScanRun> pageContext =
                  PageContext.create(callable, LIST_SCAN_RUNS_PAGE_STR_DESC, request, context);
              return ListScanRunsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListCrawledUrlsRequest, ListCrawledUrlsResponse, ListCrawledUrlsPagedResponse>
      LIST_CRAWLED_URLS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListCrawledUrlsRequest, ListCrawledUrlsResponse, ListCrawledUrlsPagedResponse>() {
            @Override
            public ApiFuture<ListCrawledUrlsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListCrawledUrlsRequest, ListCrawledUrlsResponse> callable,
                ListCrawledUrlsRequest request,
                ApiCallContext context,
                ApiFuture<ListCrawledUrlsResponse> futureResponse) {
              PageContext<ListCrawledUrlsRequest, ListCrawledUrlsResponse, CrawledUrl> pageContext =
                  PageContext.create(callable, LIST_CRAWLED_URLS_PAGE_STR_DESC, request, context);
              return ListCrawledUrlsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListFindingsRequest, ListFindingsResponse, ListFindingsPagedResponse>
      LIST_FINDINGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListFindingsRequest, ListFindingsResponse, ListFindingsPagedResponse>() {
            @Override
            public ApiFuture<ListFindingsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListFindingsRequest, ListFindingsResponse> callable,
                ListFindingsRequest request,
                ApiCallContext context,
                ApiFuture<ListFindingsResponse> futureResponse) {
              PageContext<ListFindingsRequest, ListFindingsResponse, Finding> pageContext =
                  PageContext.create(callable, LIST_FINDINGS_PAGE_STR_DESC, request, context);
              return ListFindingsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createScanConfig. */
  public UnaryCallSettings<CreateScanConfigRequest, ScanConfig> createScanConfigSettings() {
    return createScanConfigSettings;
  }

  /** Returns the object with the settings used for calls to deleteScanConfig. */
  public UnaryCallSettings<DeleteScanConfigRequest, Empty> deleteScanConfigSettings() {
    return deleteScanConfigSettings;
  }

  /** Returns the object with the settings used for calls to getScanConfig. */
  public UnaryCallSettings<GetScanConfigRequest, ScanConfig> getScanConfigSettings() {
    return getScanConfigSettings;
  }

  /** Returns the object with the settings used for calls to listScanConfigs. */
  public PagedCallSettings<
          ListScanConfigsRequest, ListScanConfigsResponse, ListScanConfigsPagedResponse>
      listScanConfigsSettings() {
    return listScanConfigsSettings;
  }

  /** Returns the object with the settings used for calls to updateScanConfig. */
  public UnaryCallSettings<UpdateScanConfigRequest, ScanConfig> updateScanConfigSettings() {
    return updateScanConfigSettings;
  }

  /** Returns the object with the settings used for calls to startScanRun. */
  public UnaryCallSettings<StartScanRunRequest, ScanRun> startScanRunSettings() {
    return startScanRunSettings;
  }

  /** Returns the object with the settings used for calls to getScanRun. */
  public UnaryCallSettings<GetScanRunRequest, ScanRun> getScanRunSettings() {
    return getScanRunSettings;
  }

  /** Returns the object with the settings used for calls to listScanRuns. */
  public PagedCallSettings<ListScanRunsRequest, ListScanRunsResponse, ListScanRunsPagedResponse>
      listScanRunsSettings() {
    return listScanRunsSettings;
  }

  /** Returns the object with the settings used for calls to stopScanRun. */
  public UnaryCallSettings<StopScanRunRequest, ScanRun> stopScanRunSettings() {
    return stopScanRunSettings;
  }

  /** Returns the object with the settings used for calls to listCrawledUrls. */
  public PagedCallSettings<
          ListCrawledUrlsRequest, ListCrawledUrlsResponse, ListCrawledUrlsPagedResponse>
      listCrawledUrlsSettings() {
    return listCrawledUrlsSettings;
  }

  /** Returns the object with the settings used for calls to getFinding. */
  public UnaryCallSettings<GetFindingRequest, Finding> getFindingSettings() {
    return getFindingSettings;
  }

  /** Returns the object with the settings used for calls to listFindings. */
  public PagedCallSettings<ListFindingsRequest, ListFindingsResponse, ListFindingsPagedResponse>
      listFindingsSettings() {
    return listFindingsSettings;
  }

  /** Returns the object with the settings used for calls to listFindingTypeStats. */
  public UnaryCallSettings<ListFindingTypeStatsRequest, ListFindingTypeStatsResponse>
      listFindingTypeStatsSettings() {
    return listFindingTypeStatsSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public WebSecurityScannerStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcWebSecurityScannerStub.create(this);
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
    return "websecurityscanner.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(WebSecurityScannerStubSettings.class))
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

  protected WebSecurityScannerStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createScanConfigSettings = settingsBuilder.createScanConfigSettings().build();
    deleteScanConfigSettings = settingsBuilder.deleteScanConfigSettings().build();
    getScanConfigSettings = settingsBuilder.getScanConfigSettings().build();
    listScanConfigsSettings = settingsBuilder.listScanConfigsSettings().build();
    updateScanConfigSettings = settingsBuilder.updateScanConfigSettings().build();
    startScanRunSettings = settingsBuilder.startScanRunSettings().build();
    getScanRunSettings = settingsBuilder.getScanRunSettings().build();
    listScanRunsSettings = settingsBuilder.listScanRunsSettings().build();
    stopScanRunSettings = settingsBuilder.stopScanRunSettings().build();
    listCrawledUrlsSettings = settingsBuilder.listCrawledUrlsSettings().build();
    getFindingSettings = settingsBuilder.getFindingSettings().build();
    listFindingsSettings = settingsBuilder.listFindingsSettings().build();
    listFindingTypeStatsSettings = settingsBuilder.listFindingTypeStatsSettings().build();
  }

  /** Builder for WebSecurityScannerStubSettings. */
  public static class Builder
      extends StubSettings.Builder<WebSecurityScannerStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateScanConfigRequest, ScanConfig>
        createScanConfigSettings;
    private final UnaryCallSettings.Builder<DeleteScanConfigRequest, Empty>
        deleteScanConfigSettings;
    private final UnaryCallSettings.Builder<GetScanConfigRequest, ScanConfig> getScanConfigSettings;
    private final PagedCallSettings.Builder<
            ListScanConfigsRequest, ListScanConfigsResponse, ListScanConfigsPagedResponse>
        listScanConfigsSettings;
    private final UnaryCallSettings.Builder<UpdateScanConfigRequest, ScanConfig>
        updateScanConfigSettings;
    private final UnaryCallSettings.Builder<StartScanRunRequest, ScanRun> startScanRunSettings;
    private final UnaryCallSettings.Builder<GetScanRunRequest, ScanRun> getScanRunSettings;
    private final PagedCallSettings.Builder<
            ListScanRunsRequest, ListScanRunsResponse, ListScanRunsPagedResponse>
        listScanRunsSettings;
    private final UnaryCallSettings.Builder<StopScanRunRequest, ScanRun> stopScanRunSettings;
    private final PagedCallSettings.Builder<
            ListCrawledUrlsRequest, ListCrawledUrlsResponse, ListCrawledUrlsPagedResponse>
        listCrawledUrlsSettings;
    private final UnaryCallSettings.Builder<GetFindingRequest, Finding> getFindingSettings;
    private final PagedCallSettings.Builder<
            ListFindingsRequest, ListFindingsResponse, ListFindingsPagedResponse>
        listFindingsSettings;
    private final UnaryCallSettings.Builder<
            ListFindingTypeStatsRequest, ListFindingTypeStatsResponse>
        listFindingTypeStatsSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "no_retry_0_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "retry_policy_1_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(600000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(600000L))
              .setTotalTimeout(Duration.ofMillis(600000L))
              .build();
      definitions.put("no_retry_0_params", settings);
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
      definitions.put("retry_policy_1_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createScanConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteScanConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getScanConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listScanConfigsSettings = PagedCallSettings.newBuilder(LIST_SCAN_CONFIGS_PAGE_STR_FACT);
      updateScanConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      startScanRunSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getScanRunSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listScanRunsSettings = PagedCallSettings.newBuilder(LIST_SCAN_RUNS_PAGE_STR_FACT);
      stopScanRunSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listCrawledUrlsSettings = PagedCallSettings.newBuilder(LIST_CRAWLED_URLS_PAGE_STR_FACT);
      getFindingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listFindingsSettings = PagedCallSettings.newBuilder(LIST_FINDINGS_PAGE_STR_FACT);
      listFindingTypeStatsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createScanConfigSettings,
              deleteScanConfigSettings,
              getScanConfigSettings,
              listScanConfigsSettings,
              updateScanConfigSettings,
              startScanRunSettings,
              getScanRunSettings,
              listScanRunsSettings,
              stopScanRunSettings,
              listCrawledUrlsSettings,
              getFindingSettings,
              listFindingsSettings,
              listFindingTypeStatsSettings);
      initDefaults(this);
    }

    protected Builder(WebSecurityScannerStubSettings settings) {
      super(settings);

      createScanConfigSettings = settings.createScanConfigSettings.toBuilder();
      deleteScanConfigSettings = settings.deleteScanConfigSettings.toBuilder();
      getScanConfigSettings = settings.getScanConfigSettings.toBuilder();
      listScanConfigsSettings = settings.listScanConfigsSettings.toBuilder();
      updateScanConfigSettings = settings.updateScanConfigSettings.toBuilder();
      startScanRunSettings = settings.startScanRunSettings.toBuilder();
      getScanRunSettings = settings.getScanRunSettings.toBuilder();
      listScanRunsSettings = settings.listScanRunsSettings.toBuilder();
      stopScanRunSettings = settings.stopScanRunSettings.toBuilder();
      listCrawledUrlsSettings = settings.listCrawledUrlsSettings.toBuilder();
      getFindingSettings = settings.getFindingSettings.toBuilder();
      listFindingsSettings = settings.listFindingsSettings.toBuilder();
      listFindingTypeStatsSettings = settings.listFindingTypeStatsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createScanConfigSettings,
              deleteScanConfigSettings,
              getScanConfigSettings,
              listScanConfigsSettings,
              updateScanConfigSettings,
              startScanRunSettings,
              getScanRunSettings,
              listScanRunsSettings,
              stopScanRunSettings,
              listCrawledUrlsSettings,
              getFindingSettings,
              listFindingsSettings,
              listFindingTypeStatsSettings);
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
          .createScanConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteScanConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .getScanConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .listScanConfigsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .updateScanConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .startScanRunSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getScanRunSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .listScanRunsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .stopScanRunSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listCrawledUrlsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .getFindingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .listFindingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .listFindingTypeStatsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

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

    /** Returns the builder for the settings used for calls to createScanConfig. */
    public UnaryCallSettings.Builder<CreateScanConfigRequest, ScanConfig>
        createScanConfigSettings() {
      return createScanConfigSettings;
    }

    /** Returns the builder for the settings used for calls to deleteScanConfig. */
    public UnaryCallSettings.Builder<DeleteScanConfigRequest, Empty> deleteScanConfigSettings() {
      return deleteScanConfigSettings;
    }

    /** Returns the builder for the settings used for calls to getScanConfig. */
    public UnaryCallSettings.Builder<GetScanConfigRequest, ScanConfig> getScanConfigSettings() {
      return getScanConfigSettings;
    }

    /** Returns the builder for the settings used for calls to listScanConfigs. */
    public PagedCallSettings.Builder<
            ListScanConfigsRequest, ListScanConfigsResponse, ListScanConfigsPagedResponse>
        listScanConfigsSettings() {
      return listScanConfigsSettings;
    }

    /** Returns the builder for the settings used for calls to updateScanConfig. */
    public UnaryCallSettings.Builder<UpdateScanConfigRequest, ScanConfig>
        updateScanConfigSettings() {
      return updateScanConfigSettings;
    }

    /** Returns the builder for the settings used for calls to startScanRun. */
    public UnaryCallSettings.Builder<StartScanRunRequest, ScanRun> startScanRunSettings() {
      return startScanRunSettings;
    }

    /** Returns the builder for the settings used for calls to getScanRun. */
    public UnaryCallSettings.Builder<GetScanRunRequest, ScanRun> getScanRunSettings() {
      return getScanRunSettings;
    }

    /** Returns the builder for the settings used for calls to listScanRuns. */
    public PagedCallSettings.Builder<
            ListScanRunsRequest, ListScanRunsResponse, ListScanRunsPagedResponse>
        listScanRunsSettings() {
      return listScanRunsSettings;
    }

    /** Returns the builder for the settings used for calls to stopScanRun. */
    public UnaryCallSettings.Builder<StopScanRunRequest, ScanRun> stopScanRunSettings() {
      return stopScanRunSettings;
    }

    /** Returns the builder for the settings used for calls to listCrawledUrls. */
    public PagedCallSettings.Builder<
            ListCrawledUrlsRequest, ListCrawledUrlsResponse, ListCrawledUrlsPagedResponse>
        listCrawledUrlsSettings() {
      return listCrawledUrlsSettings;
    }

    /** Returns the builder for the settings used for calls to getFinding. */
    public UnaryCallSettings.Builder<GetFindingRequest, Finding> getFindingSettings() {
      return getFindingSettings;
    }

    /** Returns the builder for the settings used for calls to listFindings. */
    public PagedCallSettings.Builder<
            ListFindingsRequest, ListFindingsResponse, ListFindingsPagedResponse>
        listFindingsSettings() {
      return listFindingsSettings;
    }

    /** Returns the builder for the settings used for calls to listFindingTypeStats. */
    public UnaryCallSettings.Builder<ListFindingTypeStatsRequest, ListFindingTypeStatsResponse>
        listFindingTypeStatsSettings() {
      return listFindingTypeStatsSettings;
    }

    @Override
    public WebSecurityScannerStubSettings build() throws IOException {
      return new WebSecurityScannerStubSettings(this);
    }
  }
}
