/*
 * Copyright 2024 Google LLC
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

package com.google.shopping.merchant.datasources.v1beta.stub;

import static com.google.shopping.merchant.datasources.v1beta.DataSourcesServiceClient.ListDataSourcesPagedResponse;

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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import com.google.shopping.merchant.datasources.v1beta.CreateDataSourceRequest;
import com.google.shopping.merchant.datasources.v1beta.DataSource;
import com.google.shopping.merchant.datasources.v1beta.DeleteDataSourceRequest;
import com.google.shopping.merchant.datasources.v1beta.FetchDataSourceRequest;
import com.google.shopping.merchant.datasources.v1beta.GetDataSourceRequest;
import com.google.shopping.merchant.datasources.v1beta.ListDataSourcesRequest;
import com.google.shopping.merchant.datasources.v1beta.ListDataSourcesResponse;
import com.google.shopping.merchant.datasources.v1beta.UpdateDataSourceRequest;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link DataSourcesServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (merchantapi.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getDataSource to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DataSourcesServiceStubSettings.Builder dataSourcesServiceSettingsBuilder =
 *     DataSourcesServiceStubSettings.newBuilder();
 * dataSourcesServiceSettingsBuilder
 *     .getDataSourceSettings()
 *     .setRetrySettings(
 *         dataSourcesServiceSettingsBuilder
 *             .getDataSourceSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * DataSourcesServiceStubSettings dataSourcesServiceSettings =
 *     dataSourcesServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class DataSourcesServiceStubSettings extends StubSettings<DataSourcesServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/content").build();

  private final UnaryCallSettings<GetDataSourceRequest, DataSource> getDataSourceSettings;
  private final PagedCallSettings<
          ListDataSourcesRequest, ListDataSourcesResponse, ListDataSourcesPagedResponse>
      listDataSourcesSettings;
  private final UnaryCallSettings<CreateDataSourceRequest, DataSource> createDataSourceSettings;
  private final UnaryCallSettings<UpdateDataSourceRequest, DataSource> updateDataSourceSettings;
  private final UnaryCallSettings<DeleteDataSourceRequest, Empty> deleteDataSourceSettings;
  private final UnaryCallSettings<FetchDataSourceRequest, Empty> fetchDataSourceSettings;

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
              return payload.getDataSourcesList() == null
                  ? ImmutableList.<DataSource>of()
                  : payload.getDataSourcesList();
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

  /** Returns the object with the settings used for calls to createDataSource. */
  public UnaryCallSettings<CreateDataSourceRequest, DataSource> createDataSourceSettings() {
    return createDataSourceSettings;
  }

  /** Returns the object with the settings used for calls to updateDataSource. */
  public UnaryCallSettings<UpdateDataSourceRequest, DataSource> updateDataSourceSettings() {
    return updateDataSourceSettings;
  }

  /** Returns the object with the settings used for calls to deleteDataSource. */
  public UnaryCallSettings<DeleteDataSourceRequest, Empty> deleteDataSourceSettings() {
    return deleteDataSourceSettings;
  }

  /** Returns the object with the settings used for calls to fetchDataSource. */
  public UnaryCallSettings<FetchDataSourceRequest, Empty> fetchDataSourceSettings() {
    return fetchDataSourceSettings;
  }

  public DataSourcesServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcDataSourcesServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonDataSourcesServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "merchantapi";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "merchantapi.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "merchantapi.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(DataSourcesServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(DataSourcesServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DataSourcesServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected DataSourcesServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getDataSourceSettings = settingsBuilder.getDataSourceSettings().build();
    listDataSourcesSettings = settingsBuilder.listDataSourcesSettings().build();
    createDataSourceSettings = settingsBuilder.createDataSourceSettings().build();
    updateDataSourceSettings = settingsBuilder.updateDataSourceSettings().build();
    deleteDataSourceSettings = settingsBuilder.deleteDataSourceSettings().build();
    fetchDataSourceSettings = settingsBuilder.fetchDataSourceSettings().build();
  }

  /** Builder for DataSourcesServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<DataSourcesServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetDataSourceRequest, DataSource> getDataSourceSettings;
    private final PagedCallSettings.Builder<
            ListDataSourcesRequest, ListDataSourcesResponse, ListDataSourcesPagedResponse>
        listDataSourcesSettings;
    private final UnaryCallSettings.Builder<CreateDataSourceRequest, DataSource>
        createDataSourceSettings;
    private final UnaryCallSettings.Builder<UpdateDataSourceRequest, DataSource>
        updateDataSourceSettings;
    private final UnaryCallSettings.Builder<DeleteDataSourceRequest, Empty>
        deleteDataSourceSettings;
    private final UnaryCallSettings.Builder<FetchDataSourceRequest, Empty> fetchDataSourceSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
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
              .setInitialRetryDelay(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(10000L))
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      getDataSourceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listDataSourcesSettings = PagedCallSettings.newBuilder(LIST_DATA_SOURCES_PAGE_STR_FACT);
      createDataSourceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateDataSourceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteDataSourceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      fetchDataSourceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getDataSourceSettings,
              listDataSourcesSettings,
              createDataSourceSettings,
              updateDataSourceSettings,
              deleteDataSourceSettings,
              fetchDataSourceSettings);
      initDefaults(this);
    }

    protected Builder(DataSourcesServiceStubSettings settings) {
      super(settings);

      getDataSourceSettings = settings.getDataSourceSettings.toBuilder();
      listDataSourcesSettings = settings.listDataSourcesSettings.toBuilder();
      createDataSourceSettings = settings.createDataSourceSettings.toBuilder();
      updateDataSourceSettings = settings.updateDataSourceSettings.toBuilder();
      deleteDataSourceSettings = settings.deleteDataSourceSettings.toBuilder();
      fetchDataSourceSettings = settings.fetchDataSourceSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getDataSourceSettings,
              listDataSourcesSettings,
              createDataSourceSettings,
              updateDataSourceSettings,
              deleteDataSourceSettings,
              fetchDataSourceSettings);
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
          .getDataSourceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listDataSourcesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createDataSourceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateDataSourceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteDataSourceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .fetchDataSourceSettings()
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

    /** Returns the builder for the settings used for calls to createDataSource. */
    public UnaryCallSettings.Builder<CreateDataSourceRequest, DataSource>
        createDataSourceSettings() {
      return createDataSourceSettings;
    }

    /** Returns the builder for the settings used for calls to updateDataSource. */
    public UnaryCallSettings.Builder<UpdateDataSourceRequest, DataSource>
        updateDataSourceSettings() {
      return updateDataSourceSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDataSource. */
    public UnaryCallSettings.Builder<DeleteDataSourceRequest, Empty> deleteDataSourceSettings() {
      return deleteDataSourceSettings;
    }

    /** Returns the builder for the settings used for calls to fetchDataSource. */
    public UnaryCallSettings.Builder<FetchDataSourceRequest, Empty> fetchDataSourceSettings() {
      return fetchDataSourceSettings;
    }

    @Override
    public DataSourcesServiceStubSettings build() throws IOException {
      return new DataSourcesServiceStubSettings(this);
    }
  }
}
