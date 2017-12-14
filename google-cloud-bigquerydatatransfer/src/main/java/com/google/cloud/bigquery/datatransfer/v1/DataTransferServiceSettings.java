/*
 * Copyright 2017, Google LLC All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigquery.datatransfer.v1;

import static com.google.cloud.bigquery.datatransfer.v1.PagedResponseWrappers.ListDataSourcesPagedResponse;
import static com.google.cloud.bigquery.datatransfer.v1.PagedResponseWrappers.ListTransferConfigsPagedResponse;
import static com.google.cloud.bigquery.datatransfer.v1.PagedResponseWrappers.ListTransferLogsPagedResponse;
import static com.google.cloud.bigquery.datatransfer.v1.PagedResponseWrappers.ListTransferRunsPagedResponse;

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
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.bigquery.datatransfer.v1.stub.DataTransferServiceStub;
import com.google.cloud.bigquery.datatransfer.v1.stub.GrpcDataTransferServiceStub;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link DataTransferServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (bigquerydatatransfer.googleapis.com) and default port (443)
 *       are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object. For
 * example, to set the total timeout of getDataSource to 30 seconds:
 *
 * <pre>
 * <code>
 * DataTransferServiceSettings.Builder dataTransferServiceSettingsBuilder =
 *     DataTransferServiceSettings.newBuilder();
 * dataTransferServiceSettingsBuilder.getDataSourceSettings().getRetrySettingsBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * DataTransferServiceSettings dataTransferServiceSettings = dataTransferServiceSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by GAPIC v0.0.5")
@BetaApi
public class DataTransferServiceSettings extends ClientSettings<DataTransferServiceSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/bigquery")
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/cloud-platform.read-only")
          .build();

  private final UnaryCallSettings<GetDataSourceRequest, DataSource> getDataSourceSettings;
  private final PagedCallSettings<
          ListDataSourcesRequest, ListDataSourcesResponse, ListDataSourcesPagedResponse>
      listDataSourcesSettings;
  private final UnaryCallSettings<CreateTransferConfigRequest, TransferConfig>
      createTransferConfigSettings;
  private final UnaryCallSettings<UpdateTransferConfigRequest, TransferConfig>
      updateTransferConfigSettings;
  private final UnaryCallSettings<DeleteTransferConfigRequest, Empty> deleteTransferConfigSettings;
  private final UnaryCallSettings<GetTransferConfigRequest, TransferConfig>
      getTransferConfigSettings;
  private final PagedCallSettings<
          ListTransferConfigsRequest, ListTransferConfigsResponse, ListTransferConfigsPagedResponse>
      listTransferConfigsSettings;
  private final UnaryCallSettings<ScheduleTransferRunsRequest, ScheduleTransferRunsResponse>
      scheduleTransferRunsSettings;
  private final UnaryCallSettings<GetTransferRunRequest, TransferRun> getTransferRunSettings;
  private final UnaryCallSettings<DeleteTransferRunRequest, Empty> deleteTransferRunSettings;
  private final PagedCallSettings<
          ListTransferRunsRequest, ListTransferRunsResponse, ListTransferRunsPagedResponse>
      listTransferRunsSettings;
  private final PagedCallSettings<
          ListTransferLogsRequest, ListTransferLogsResponse, ListTransferLogsPagedResponse>
      listTransferLogsSettings;
  private final UnaryCallSettings<CheckValidCredsRequest, CheckValidCredsResponse>
      checkValidCredsSettings;

  /** Returns the object with the settings used for calls to getDataSource. */
  public UnaryCallSettings<GetDataSourceRequest, DataSource> getDataSourceSettings() {
    return getDataSourceSettings;
  }

  /** Returns the object with the settings used for calls to listDataSources. */
  public PagedCallSettings<
          ListDataSourcesRequest, ListDataSourcesResponse, ListDataSourcesPagedResponse>
      listDataSourcesSettings() {
    return listDataSourcesSettings;
  }

  /** Returns the object with the settings used for calls to createTransferConfig. */
  public UnaryCallSettings<CreateTransferConfigRequest, TransferConfig>
      createTransferConfigSettings() {
    return createTransferConfigSettings;
  }

  /** Returns the object with the settings used for calls to updateTransferConfig. */
  public UnaryCallSettings<UpdateTransferConfigRequest, TransferConfig>
      updateTransferConfigSettings() {
    return updateTransferConfigSettings;
  }

  /** Returns the object with the settings used for calls to deleteTransferConfig. */
  public UnaryCallSettings<DeleteTransferConfigRequest, Empty> deleteTransferConfigSettings() {
    return deleteTransferConfigSettings;
  }

  /** Returns the object with the settings used for calls to getTransferConfig. */
  public UnaryCallSettings<GetTransferConfigRequest, TransferConfig> getTransferConfigSettings() {
    return getTransferConfigSettings;
  }

  /** Returns the object with the settings used for calls to listTransferConfigs. */
  public PagedCallSettings<
          ListTransferConfigsRequest, ListTransferConfigsResponse, ListTransferConfigsPagedResponse>
      listTransferConfigsSettings() {
    return listTransferConfigsSettings;
  }

  /** Returns the object with the settings used for calls to scheduleTransferRuns. */
  public UnaryCallSettings<ScheduleTransferRunsRequest, ScheduleTransferRunsResponse>
      scheduleTransferRunsSettings() {
    return scheduleTransferRunsSettings;
  }

  /** Returns the object with the settings used for calls to getTransferRun. */
  public UnaryCallSettings<GetTransferRunRequest, TransferRun> getTransferRunSettings() {
    return getTransferRunSettings;
  }

  /** Returns the object with the settings used for calls to deleteTransferRun. */
  public UnaryCallSettings<DeleteTransferRunRequest, Empty> deleteTransferRunSettings() {
    return deleteTransferRunSettings;
  }

  /** Returns the object with the settings used for calls to listTransferRuns. */
  public PagedCallSettings<
          ListTransferRunsRequest, ListTransferRunsResponse, ListTransferRunsPagedResponse>
      listTransferRunsSettings() {
    return listTransferRunsSettings;
  }

  /** Returns the object with the settings used for calls to listTransferLogs. */
  public PagedCallSettings<
          ListTransferLogsRequest, ListTransferLogsResponse, ListTransferLogsPagedResponse>
      listTransferLogsSettings() {
    return listTransferLogsSettings;
  }

  /** Returns the object with the settings used for calls to checkValidCreds. */
  public UnaryCallSettings<CheckValidCredsRequest, CheckValidCredsResponse>
      checkValidCredsSettings() {
    return checkValidCredsSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public DataTransferServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcDataTransferServiceStub.create(this);
    } else {
      throw new UnsupportedOperationException(
          "Transport not supported: " + getTransportChannelProvider().getTransportName());
    }
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "bigquerydatatransfer.googleapis.com:443";
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
    return InstantiatingGrpcChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(DataTransferServiceSettings.class))
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

  private DataTransferServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getDataSourceSettings = settingsBuilder.getDataSourceSettings().build();
    listDataSourcesSettings = settingsBuilder.listDataSourcesSettings().build();
    createTransferConfigSettings = settingsBuilder.createTransferConfigSettings().build();
    updateTransferConfigSettings = settingsBuilder.updateTransferConfigSettings().build();
    deleteTransferConfigSettings = settingsBuilder.deleteTransferConfigSettings().build();
    getTransferConfigSettings = settingsBuilder.getTransferConfigSettings().build();
    listTransferConfigsSettings = settingsBuilder.listTransferConfigsSettings().build();
    scheduleTransferRunsSettings = settingsBuilder.scheduleTransferRunsSettings().build();
    getTransferRunSettings = settingsBuilder.getTransferRunSettings().build();
    deleteTransferRunSettings = settingsBuilder.deleteTransferRunSettings().build();
    listTransferRunsSettings = settingsBuilder.listTransferRunsSettings().build();
    listTransferLogsSettings = settingsBuilder.listTransferLogsSettings().build();
    checkValidCredsSettings = settingsBuilder.checkValidCredsSettings().build();
  }

  private static final PagedListDescriptor<
          ListDataSourcesRequest, ListDataSourcesResponse, DataSource>
      LIST_DATA_SOURCES_PAGE_STR_DESC =
          new PagedListDescriptor<ListDataSourcesRequest, ListDataSourcesResponse, DataSource>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDataSourcesRequest injectToken(
                ListDataSourcesRequest payload, String token) {
              return ListDataSourcesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListDataSourcesRequest injectPageSize(
                ListDataSourcesRequest payload, int pageSize) {
              return ListDataSourcesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListDataSourcesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDataSourcesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<DataSource> extractResources(ListDataSourcesResponse payload) {
              return payload.getDataSourcesList();
            }
          };

  private static final PagedListDescriptor<
          ListTransferConfigsRequest, ListTransferConfigsResponse, TransferConfig>
      LIST_TRANSFER_CONFIGS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListTransferConfigsRequest, ListTransferConfigsResponse, TransferConfig>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListTransferConfigsRequest injectToken(
                ListTransferConfigsRequest payload, String token) {
              return ListTransferConfigsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListTransferConfigsRequest injectPageSize(
                ListTransferConfigsRequest payload, int pageSize) {
              return ListTransferConfigsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListTransferConfigsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListTransferConfigsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<TransferConfig> extractResources(ListTransferConfigsResponse payload) {
              return payload.getTransferConfigsList();
            }
          };

  private static final PagedListDescriptor<
          ListTransferRunsRequest, ListTransferRunsResponse, TransferRun>
      LIST_TRANSFER_RUNS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListTransferRunsRequest, ListTransferRunsResponse, TransferRun>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListTransferRunsRequest injectToken(
                ListTransferRunsRequest payload, String token) {
              return ListTransferRunsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListTransferRunsRequest injectPageSize(
                ListTransferRunsRequest payload, int pageSize) {
              return ListTransferRunsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListTransferRunsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListTransferRunsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<TransferRun> extractResources(ListTransferRunsResponse payload) {
              return payload.getTransferRunsList();
            }
          };

  private static final PagedListDescriptor<
          ListTransferLogsRequest, ListTransferLogsResponse, TransferMessage>
      LIST_TRANSFER_LOGS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListTransferLogsRequest, ListTransferLogsResponse, TransferMessage>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListTransferLogsRequest injectToken(
                ListTransferLogsRequest payload, String token) {
              return ListTransferLogsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListTransferLogsRequest injectPageSize(
                ListTransferLogsRequest payload, int pageSize) {
              return ListTransferLogsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListTransferLogsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListTransferLogsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<TransferMessage> extractResources(ListTransferLogsResponse payload) {
              return payload.getTransferMessagesList();
            }
          };

  private static final PagedListResponseFactory<
          ListDataSourcesRequest, ListDataSourcesResponse, ListDataSourcesPagedResponse>
      LIST_DATA_SOURCES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDataSourcesRequest, ListDataSourcesResponse, ListDataSourcesPagedResponse>() {
            @Override
            public ApiFuture<ListDataSourcesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDataSourcesRequest, ListDataSourcesResponse> callable,
                ListDataSourcesRequest request,
                ApiCallContext context,
                ApiFuture<ListDataSourcesResponse> futureResponse) {
              PageContext<ListDataSourcesRequest, ListDataSourcesResponse, DataSource> pageContext =
                  PageContext.create(callable, LIST_DATA_SOURCES_PAGE_STR_DESC, request, context);
              return ListDataSourcesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListTransferConfigsRequest, ListTransferConfigsResponse, ListTransferConfigsPagedResponse>
      LIST_TRANSFER_CONFIGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListTransferConfigsRequest, ListTransferConfigsResponse,
              ListTransferConfigsPagedResponse>() {
            @Override
            public ApiFuture<ListTransferConfigsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListTransferConfigsRequest, ListTransferConfigsResponse> callable,
                ListTransferConfigsRequest request,
                ApiCallContext context,
                ApiFuture<ListTransferConfigsResponse> futureResponse) {
              PageContext<ListTransferConfigsRequest, ListTransferConfigsResponse, TransferConfig>
                  pageContext =
                      PageContext.create(
                          callable, LIST_TRANSFER_CONFIGS_PAGE_STR_DESC, request, context);
              return ListTransferConfigsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListTransferRunsRequest, ListTransferRunsResponse, ListTransferRunsPagedResponse>
      LIST_TRANSFER_RUNS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListTransferRunsRequest, ListTransferRunsResponse, ListTransferRunsPagedResponse>() {
            @Override
            public ApiFuture<ListTransferRunsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListTransferRunsRequest, ListTransferRunsResponse> callable,
                ListTransferRunsRequest request,
                ApiCallContext context,
                ApiFuture<ListTransferRunsResponse> futureResponse) {
              PageContext<ListTransferRunsRequest, ListTransferRunsResponse, TransferRun>
                  pageContext =
                      PageContext.create(
                          callable, LIST_TRANSFER_RUNS_PAGE_STR_DESC, request, context);
              return ListTransferRunsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListTransferLogsRequest, ListTransferLogsResponse, ListTransferLogsPagedResponse>
      LIST_TRANSFER_LOGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListTransferLogsRequest, ListTransferLogsResponse, ListTransferLogsPagedResponse>() {
            @Override
            public ApiFuture<ListTransferLogsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListTransferLogsRequest, ListTransferLogsResponse> callable,
                ListTransferLogsRequest request,
                ApiCallContext context,
                ApiFuture<ListTransferLogsResponse> futureResponse) {
              PageContext<ListTransferLogsRequest, ListTransferLogsResponse, TransferMessage>
                  pageContext =
                      PageContext.create(
                          callable, LIST_TRANSFER_LOGS_PAGE_STR_DESC, request, context);
              return ListTransferLogsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Builder for DataTransferServiceSettings. */
  public static class Builder extends ClientSettings.Builder<DataTransferServiceSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;

    private final UnaryCallSettings.Builder<GetDataSourceRequest, DataSource> getDataSourceSettings;
    private final PagedCallSettings.Builder<
            ListDataSourcesRequest, ListDataSourcesResponse, ListDataSourcesPagedResponse>
        listDataSourcesSettings;
    private final UnaryCallSettings.Builder<CreateTransferConfigRequest, TransferConfig>
        createTransferConfigSettings;
    private final UnaryCallSettings.Builder<UpdateTransferConfigRequest, TransferConfig>
        updateTransferConfigSettings;
    private final UnaryCallSettings.Builder<DeleteTransferConfigRequest, Empty>
        deleteTransferConfigSettings;
    private final UnaryCallSettings.Builder<GetTransferConfigRequest, TransferConfig>
        getTransferConfigSettings;
    private final PagedCallSettings.Builder<
            ListTransferConfigsRequest, ListTransferConfigsResponse,
            ListTransferConfigsPagedResponse>
        listTransferConfigsSettings;
    private final UnaryCallSettings.Builder<
            ScheduleTransferRunsRequest, ScheduleTransferRunsResponse>
        scheduleTransferRunsSettings;
    private final UnaryCallSettings.Builder<GetTransferRunRequest, TransferRun>
        getTransferRunSettings;
    private final UnaryCallSettings.Builder<DeleteTransferRunRequest, Empty>
        deleteTransferRunSettings;
    private final PagedCallSettings.Builder<
            ListTransferRunsRequest, ListTransferRunsResponse, ListTransferRunsPagedResponse>
        listTransferRunsSettings;
    private final PagedCallSettings.Builder<
            ListTransferLogsRequest, ListTransferLogsResponse, ListTransferLogsPagedResponse>
        listTransferLogsSettings;
    private final UnaryCallSettings.Builder<CheckValidCredsRequest, CheckValidCredsResponse>
        checkValidCredsSettings;

    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "idempotent",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
      definitions.put("non_idempotent", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
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
              .setInitialRpcTimeout(Duration.ofMillis(20000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(20000L))
              .setTotalTimeout(Duration.ofMillis(600000L))
              .build();
      definitions.put("default", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    private Builder() {
      this((ClientContext) null);
    }

    private Builder(ClientContext clientContext) {
      super(clientContext);

      getDataSourceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listDataSourcesSettings = PagedCallSettings.newBuilder(LIST_DATA_SOURCES_PAGE_STR_FACT);

      createTransferConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      updateTransferConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      deleteTransferConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getTransferConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listTransferConfigsSettings =
          PagedCallSettings.newBuilder(LIST_TRANSFER_CONFIGS_PAGE_STR_FACT);

      scheduleTransferRunsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getTransferRunSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      deleteTransferRunSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listTransferRunsSettings = PagedCallSettings.newBuilder(LIST_TRANSFER_RUNS_PAGE_STR_FACT);

      listTransferLogsSettings = PagedCallSettings.newBuilder(LIST_TRANSFER_LOGS_PAGE_STR_FACT);

      checkValidCredsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getDataSourceSettings,
              listDataSourcesSettings,
              createTransferConfigSettings,
              updateTransferConfigSettings,
              deleteTransferConfigSettings,
              getTransferConfigSettings,
              listTransferConfigsSettings,
              scheduleTransferRunsSettings,
              getTransferRunSettings,
              deleteTransferRunSettings,
              listTransferRunsSettings,
              listTransferLogsSettings,
              checkValidCredsSettings);

      initDefaults(this);
    }

    private static Builder createDefault() {
      Builder builder = new Builder((ClientContext) null);
      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {

      builder
          .getDataSourceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listDataSourcesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .createTransferConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .updateTransferConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .deleteTransferConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getTransferConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listTransferConfigsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .scheduleTransferRunsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getTransferRunSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .deleteTransferRunSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listTransferRunsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listTransferLogsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .checkValidCredsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      return builder;
    }

    private Builder(DataTransferServiceSettings settings) {
      super(settings);

      getDataSourceSettings = settings.getDataSourceSettings.toBuilder();
      listDataSourcesSettings = settings.listDataSourcesSettings.toBuilder();
      createTransferConfigSettings = settings.createTransferConfigSettings.toBuilder();
      updateTransferConfigSettings = settings.updateTransferConfigSettings.toBuilder();
      deleteTransferConfigSettings = settings.deleteTransferConfigSettings.toBuilder();
      getTransferConfigSettings = settings.getTransferConfigSettings.toBuilder();
      listTransferConfigsSettings = settings.listTransferConfigsSettings.toBuilder();
      scheduleTransferRunsSettings = settings.scheduleTransferRunsSettings.toBuilder();
      getTransferRunSettings = settings.getTransferRunSettings.toBuilder();
      deleteTransferRunSettings = settings.deleteTransferRunSettings.toBuilder();
      listTransferRunsSettings = settings.listTransferRunsSettings.toBuilder();
      listTransferLogsSettings = settings.listTransferLogsSettings.toBuilder();
      checkValidCredsSettings = settings.checkValidCredsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getDataSourceSettings,
              listDataSourcesSettings,
              createTransferConfigSettings,
              updateTransferConfigSettings,
              deleteTransferConfigSettings,
              getTransferConfigSettings,
              listTransferConfigsSettings,
              scheduleTransferRunsSettings,
              getTransferRunSettings,
              deleteTransferRunSettings,
              listTransferRunsSettings,
              listTransferLogsSettings,
              checkValidCredsSettings);
    }

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

    /** Returns the builder for the settings used for calls to getDataSource. */
    public UnaryCallSettings.Builder<GetDataSourceRequest, DataSource> getDataSourceSettings() {
      return getDataSourceSettings;
    }

    /** Returns the builder for the settings used for calls to listDataSources. */
    public PagedCallSettings.Builder<
            ListDataSourcesRequest, ListDataSourcesResponse, ListDataSourcesPagedResponse>
        listDataSourcesSettings() {
      return listDataSourcesSettings;
    }

    /** Returns the builder for the settings used for calls to createTransferConfig. */
    public UnaryCallSettings.Builder<CreateTransferConfigRequest, TransferConfig>
        createTransferConfigSettings() {
      return createTransferConfigSettings;
    }

    /** Returns the builder for the settings used for calls to updateTransferConfig. */
    public UnaryCallSettings.Builder<UpdateTransferConfigRequest, TransferConfig>
        updateTransferConfigSettings() {
      return updateTransferConfigSettings;
    }

    /** Returns the builder for the settings used for calls to deleteTransferConfig. */
    public UnaryCallSettings.Builder<DeleteTransferConfigRequest, Empty>
        deleteTransferConfigSettings() {
      return deleteTransferConfigSettings;
    }

    /** Returns the builder for the settings used for calls to getTransferConfig. */
    public UnaryCallSettings.Builder<GetTransferConfigRequest, TransferConfig>
        getTransferConfigSettings() {
      return getTransferConfigSettings;
    }

    /** Returns the builder for the settings used for calls to listTransferConfigs. */
    public PagedCallSettings.Builder<
            ListTransferConfigsRequest, ListTransferConfigsResponse,
            ListTransferConfigsPagedResponse>
        listTransferConfigsSettings() {
      return listTransferConfigsSettings;
    }

    /** Returns the builder for the settings used for calls to scheduleTransferRuns. */
    public UnaryCallSettings.Builder<ScheduleTransferRunsRequest, ScheduleTransferRunsResponse>
        scheduleTransferRunsSettings() {
      return scheduleTransferRunsSettings;
    }

    /** Returns the builder for the settings used for calls to getTransferRun. */
    public UnaryCallSettings.Builder<GetTransferRunRequest, TransferRun> getTransferRunSettings() {
      return getTransferRunSettings;
    }

    /** Returns the builder for the settings used for calls to deleteTransferRun. */
    public UnaryCallSettings.Builder<DeleteTransferRunRequest, Empty> deleteTransferRunSettings() {
      return deleteTransferRunSettings;
    }

    /** Returns the builder for the settings used for calls to listTransferRuns. */
    public PagedCallSettings.Builder<
            ListTransferRunsRequest, ListTransferRunsResponse, ListTransferRunsPagedResponse>
        listTransferRunsSettings() {
      return listTransferRunsSettings;
    }

    /** Returns the builder for the settings used for calls to listTransferLogs. */
    public PagedCallSettings.Builder<
            ListTransferLogsRequest, ListTransferLogsResponse, ListTransferLogsPagedResponse>
        listTransferLogsSettings() {
      return listTransferLogsSettings;
    }

    /** Returns the builder for the settings used for calls to checkValidCreds. */
    public UnaryCallSettings.Builder<CheckValidCredsRequest, CheckValidCredsResponse>
        checkValidCredsSettings() {
      return checkValidCredsSettings;
    }

    @Override
    public DataTransferServiceSettings build() throws IOException {
      return new DataTransferServiceSettings(this);
    }
  }
}
