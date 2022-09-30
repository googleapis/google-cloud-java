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

package com.google.cloud.monitoring.v3.stub;

import static com.google.cloud.monitoring.v3.QueryServiceClient.QueryTimeSeriesPagedResponse;

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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.monitoring.v3.QueryTimeSeriesRequest;
import com.google.monitoring.v3.QueryTimeSeriesResponse;
import com.google.monitoring.v3.TimeSeriesData;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link QueryServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (monitoring.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of queryTimeSeries to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * QueryServiceStubSettings.Builder queryServiceSettingsBuilder =
 *     QueryServiceStubSettings.newBuilder();
 * queryServiceSettingsBuilder
 *     .queryTimeSeriesSettings()
 *     .setRetrySettings(
 *         queryServiceSettingsBuilder.queryTimeSeriesSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * QueryServiceStubSettings queryServiceSettings = queryServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class QueryServiceStubSettings extends StubSettings<QueryServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/monitoring")
          .add("https://www.googleapis.com/auth/monitoring.read")
          .build();

  private final PagedCallSettings<
          QueryTimeSeriesRequest, QueryTimeSeriesResponse, QueryTimeSeriesPagedResponse>
      queryTimeSeriesSettings;

  private static final PagedListDescriptor<
          QueryTimeSeriesRequest, QueryTimeSeriesResponse, TimeSeriesData>
      QUERY_TIME_SERIES_PAGE_STR_DESC =
          new PagedListDescriptor<
              QueryTimeSeriesRequest, QueryTimeSeriesResponse, TimeSeriesData>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public QueryTimeSeriesRequest injectToken(
                QueryTimeSeriesRequest payload, String token) {
              return QueryTimeSeriesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public QueryTimeSeriesRequest injectPageSize(
                QueryTimeSeriesRequest payload, int pageSize) {
              return QueryTimeSeriesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(QueryTimeSeriesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(QueryTimeSeriesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<TimeSeriesData> extractResources(QueryTimeSeriesResponse payload) {
              return payload.getTimeSeriesDataList() == null
                  ? ImmutableList.<TimeSeriesData>of()
                  : payload.getTimeSeriesDataList();
            }
          };

  private static final PagedListResponseFactory<
          QueryTimeSeriesRequest, QueryTimeSeriesResponse, QueryTimeSeriesPagedResponse>
      QUERY_TIME_SERIES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              QueryTimeSeriesRequest, QueryTimeSeriesResponse, QueryTimeSeriesPagedResponse>() {
            @Override
            public ApiFuture<QueryTimeSeriesPagedResponse> getFuturePagedResponse(
                UnaryCallable<QueryTimeSeriesRequest, QueryTimeSeriesResponse> callable,
                QueryTimeSeriesRequest request,
                ApiCallContext context,
                ApiFuture<QueryTimeSeriesResponse> futureResponse) {
              PageContext<QueryTimeSeriesRequest, QueryTimeSeriesResponse, TimeSeriesData>
                  pageContext =
                      PageContext.create(
                          callable, QUERY_TIME_SERIES_PAGE_STR_DESC, request, context);
              return QueryTimeSeriesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to queryTimeSeries. */
  public PagedCallSettings<
          QueryTimeSeriesRequest, QueryTimeSeriesResponse, QueryTimeSeriesPagedResponse>
      queryTimeSeriesSettings() {
    return queryTimeSeriesSettings;
  }

  public QueryServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcQueryServiceStub.create(this);
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
    return "monitoring.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "monitoring.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(QueryServiceStubSettings.class))
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

  protected QueryServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    queryTimeSeriesSettings = settingsBuilder.queryTimeSeriesSettings().build();
  }

  /** Builder for QueryServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<QueryServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            QueryTimeSeriesRequest, QueryTimeSeriesResponse, QueryTimeSeriesPagedResponse>
        queryTimeSeriesSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      queryTimeSeriesSettings = PagedCallSettings.newBuilder(QUERY_TIME_SERIES_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(queryTimeSeriesSettings);
      initDefaults(this);
    }

    protected Builder(QueryServiceStubSettings settings) {
      super(settings);

      queryTimeSeriesSettings = settings.queryTimeSeriesSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(queryTimeSeriesSettings);
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
          .queryTimeSeriesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

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

    /** Returns the builder for the settings used for calls to queryTimeSeries. */
    public PagedCallSettings.Builder<
            QueryTimeSeriesRequest, QueryTimeSeriesResponse, QueryTimeSeriesPagedResponse>
        queryTimeSeriesSettings() {
      return queryTimeSeriesSettings;
    }

    @Override
    public QueryServiceStubSettings build() throws IOException {
      return new QueryServiceStubSettings(this);
    }
  }
}
