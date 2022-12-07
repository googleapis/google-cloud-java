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

package com.google.devtools.clouderrorreporting.v1beta1.stub;

import static com.google.devtools.clouderrorreporting.v1beta1.ErrorStatsServiceClient.ListEventsPagedResponse;
import static com.google.devtools.clouderrorreporting.v1beta1.ErrorStatsServiceClient.ListGroupStatsPagedResponse;

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
import com.google.devtools.clouderrorreporting.v1beta1.DeleteEventsRequest;
import com.google.devtools.clouderrorreporting.v1beta1.DeleteEventsResponse;
import com.google.devtools.clouderrorreporting.v1beta1.ErrorEvent;
import com.google.devtools.clouderrorreporting.v1beta1.ErrorGroupStats;
import com.google.devtools.clouderrorreporting.v1beta1.ListEventsRequest;
import com.google.devtools.clouderrorreporting.v1beta1.ListEventsResponse;
import com.google.devtools.clouderrorreporting.v1beta1.ListGroupStatsRequest;
import com.google.devtools.clouderrorreporting.v1beta1.ListGroupStatsResponse;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ErrorStatsServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (clouderrorreporting.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of deleteEvents to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ErrorStatsServiceStubSettings.Builder errorStatsServiceSettingsBuilder =
 *     ErrorStatsServiceStubSettings.newBuilder();
 * errorStatsServiceSettingsBuilder
 *     .deleteEventsSettings()
 *     .setRetrySettings(
 *         errorStatsServiceSettingsBuilder.deleteEventsSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ErrorStatsServiceStubSettings errorStatsServiceSettings =
 *     errorStatsServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ErrorStatsServiceStubSettings extends StubSettings<ErrorStatsServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListGroupStatsRequest, ListGroupStatsResponse, ListGroupStatsPagedResponse>
      listGroupStatsSettings;
  private final PagedCallSettings<ListEventsRequest, ListEventsResponse, ListEventsPagedResponse>
      listEventsSettings;
  private final UnaryCallSettings<DeleteEventsRequest, DeleteEventsResponse> deleteEventsSettings;

  private static final PagedListDescriptor<
          ListGroupStatsRequest, ListGroupStatsResponse, ErrorGroupStats>
      LIST_GROUP_STATS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListGroupStatsRequest, ListGroupStatsResponse, ErrorGroupStats>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListGroupStatsRequest injectToken(ListGroupStatsRequest payload, String token) {
              return ListGroupStatsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListGroupStatsRequest injectPageSize(
                ListGroupStatsRequest payload, int pageSize) {
              return ListGroupStatsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListGroupStatsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListGroupStatsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ErrorGroupStats> extractResources(ListGroupStatsResponse payload) {
              return payload.getErrorGroupStatsList() == null
                  ? ImmutableList.<ErrorGroupStats>of()
                  : payload.getErrorGroupStatsList();
            }
          };

  private static final PagedListDescriptor<ListEventsRequest, ListEventsResponse, ErrorEvent>
      LIST_EVENTS_PAGE_STR_DESC =
          new PagedListDescriptor<ListEventsRequest, ListEventsResponse, ErrorEvent>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListEventsRequest injectToken(ListEventsRequest payload, String token) {
              return ListEventsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListEventsRequest injectPageSize(ListEventsRequest payload, int pageSize) {
              return ListEventsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListEventsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListEventsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ErrorEvent> extractResources(ListEventsResponse payload) {
              return payload.getErrorEventsList() == null
                  ? ImmutableList.<ErrorEvent>of()
                  : payload.getErrorEventsList();
            }
          };

  private static final PagedListResponseFactory<
          ListGroupStatsRequest, ListGroupStatsResponse, ListGroupStatsPagedResponse>
      LIST_GROUP_STATS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListGroupStatsRequest, ListGroupStatsResponse, ListGroupStatsPagedResponse>() {
            @Override
            public ApiFuture<ListGroupStatsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListGroupStatsRequest, ListGroupStatsResponse> callable,
                ListGroupStatsRequest request,
                ApiCallContext context,
                ApiFuture<ListGroupStatsResponse> futureResponse) {
              PageContext<ListGroupStatsRequest, ListGroupStatsResponse, ErrorGroupStats>
                  pageContext =
                      PageContext.create(
                          callable, LIST_GROUP_STATS_PAGE_STR_DESC, request, context);
              return ListGroupStatsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListEventsRequest, ListEventsResponse, ListEventsPagedResponse>
      LIST_EVENTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListEventsRequest, ListEventsResponse, ListEventsPagedResponse>() {
            @Override
            public ApiFuture<ListEventsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListEventsRequest, ListEventsResponse> callable,
                ListEventsRequest request,
                ApiCallContext context,
                ApiFuture<ListEventsResponse> futureResponse) {
              PageContext<ListEventsRequest, ListEventsResponse, ErrorEvent> pageContext =
                  PageContext.create(callable, LIST_EVENTS_PAGE_STR_DESC, request, context);
              return ListEventsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listGroupStats. */
  public PagedCallSettings<
          ListGroupStatsRequest, ListGroupStatsResponse, ListGroupStatsPagedResponse>
      listGroupStatsSettings() {
    return listGroupStatsSettings;
  }

  /** Returns the object with the settings used for calls to listEvents. */
  public PagedCallSettings<ListEventsRequest, ListEventsResponse, ListEventsPagedResponse>
      listEventsSettings() {
    return listEventsSettings;
  }

  /** Returns the object with the settings used for calls to deleteEvents. */
  public UnaryCallSettings<DeleteEventsRequest, DeleteEventsResponse> deleteEventsSettings() {
    return deleteEventsSettings;
  }

  public ErrorStatsServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcErrorStatsServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonErrorStatsServiceStub.create(this);
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
    return "clouderrorreporting.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "clouderrorreporting.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(ErrorStatsServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(ErrorStatsServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ErrorStatsServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected ErrorStatsServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listGroupStatsSettings = settingsBuilder.listGroupStatsSettings().build();
    listEventsSettings = settingsBuilder.listEventsSettings().build();
    deleteEventsSettings = settingsBuilder.deleteEventsSettings().build();
  }

  /** Builder for ErrorStatsServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<ErrorStatsServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListGroupStatsRequest, ListGroupStatsResponse, ListGroupStatsPagedResponse>
        listGroupStatsSettings;
    private final PagedCallSettings.Builder<
            ListEventsRequest, ListEventsResponse, ListEventsPagedResponse>
        listEventsSettings;
    private final UnaryCallSettings.Builder<DeleteEventsRequest, DeleteEventsResponse>
        deleteEventsSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.UNAVAILABLE, StatusCode.Code.DEADLINE_EXCEEDED)));
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
      definitions.put("retry_policy_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listGroupStatsSettings = PagedCallSettings.newBuilder(LIST_GROUP_STATS_PAGE_STR_FACT);
      listEventsSettings = PagedCallSettings.newBuilder(LIST_EVENTS_PAGE_STR_FACT);
      deleteEventsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listGroupStatsSettings, listEventsSettings, deleteEventsSettings);
      initDefaults(this);
    }

    protected Builder(ErrorStatsServiceStubSettings settings) {
      super(settings);

      listGroupStatsSettings = settings.listGroupStatsSettings.toBuilder();
      listEventsSettings = settings.listEventsSettings.toBuilder();
      deleteEventsSettings = settings.deleteEventsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listGroupStatsSettings, listEventsSettings, deleteEventsSettings);
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
          .listGroupStatsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listEventsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteEventsSettings()
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

    /** Returns the builder for the settings used for calls to listGroupStats. */
    public PagedCallSettings.Builder<
            ListGroupStatsRequest, ListGroupStatsResponse, ListGroupStatsPagedResponse>
        listGroupStatsSettings() {
      return listGroupStatsSettings;
    }

    /** Returns the builder for the settings used for calls to listEvents. */
    public PagedCallSettings.Builder<ListEventsRequest, ListEventsResponse, ListEventsPagedResponse>
        listEventsSettings() {
      return listEventsSettings;
    }

    /** Returns the builder for the settings used for calls to deleteEvents. */
    public UnaryCallSettings.Builder<DeleteEventsRequest, DeleteEventsResponse>
        deleteEventsSettings() {
      return deleteEventsSettings;
    }

    @Override
    public ErrorStatsServiceStubSettings build() throws IOException {
      return new ErrorStatsServiceStubSettings(this);
    }
  }
}
