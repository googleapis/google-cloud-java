/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.errorreporting.v1beta1.stub;

import static com.google.cloud.errorreporting.v1beta1.ErrorStatsServiceClient.ListEventsPagedResponse;
import static com.google.cloud.errorreporting.v1beta1.ErrorStatsServiceClient.ListGroupStatsPagedResponse;

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

// AUTO-GENERATED DOCUMENTATION AND CLASS
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
 * build() is called, the tree of builders is called to create the complete settings object. For
 * example, to set the total timeout of deleteEvents to 30 seconds:
 *
 * <pre>
 * <code>
 * ErrorStatsServiceStubSettings.Builder errorStatsServiceSettingsBuilder =
 *     ErrorStatsServiceStubSettings.newBuilder();
 * errorStatsServiceSettingsBuilder.deleteEventsSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * ErrorStatsServiceStubSettings errorStatsServiceSettings = errorStatsServiceSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
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

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public ErrorStatsServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcErrorStatsServiceStub.create(this);
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
    return "clouderrorreporting.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(ErrorStatsServiceStubSettings.class))
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

  protected ErrorStatsServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listGroupStatsSettings = settingsBuilder.listGroupStatsSettings().build();
    listEventsSettings = settingsBuilder.listEventsSettings().build();
    deleteEventsSettings = settingsBuilder.deleteEventsSettings().build();
  }

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
              return payload.getErrorGroupStatsList() != null
                  ? payload.getErrorGroupStatsList()
                  : ImmutableList.<ErrorGroupStats>of();
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
              return payload.getErrorEventsList() != null
                  ? payload.getErrorEventsList()
                  : ImmutableList.<ErrorEvent>of();
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

    protected Builder() {
      this((ClientContext) null);
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

    private static Builder createDefault() {
      Builder builder = new Builder((ClientContext) null);
      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {

      builder
          .listGroupStatsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listEventsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .deleteEventsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      return builder;
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

    // NEXT_MAJOR_VER: remove 'throws Exception'
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
