/*
 * Copyright 2019 Google LLC
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
package com.google.cloud.trace.v1.stub;

import static com.google.cloud.trace.v1.TraceServiceClient.ListTracesPagedResponse;

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
import com.google.devtools.cloudtrace.v1.GetTraceRequest;
import com.google.devtools.cloudtrace.v1.ListTracesRequest;
import com.google.devtools.cloudtrace.v1.ListTracesResponse;
import com.google.devtools.cloudtrace.v1.PatchTracesRequest;
import com.google.devtools.cloudtrace.v1.Trace;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link TraceServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (cloudtrace.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of patchTraces to 30 seconds:
 *
 * <pre>
 * <code>
 * TraceServiceStubSettings.Builder traceServiceSettingsBuilder =
 *     TraceServiceStubSettings.newBuilder();
 * traceServiceSettingsBuilder.patchTracesSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * TraceServiceStubSettings traceServiceSettings = traceServiceSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class TraceServiceStubSettings extends StubSettings<TraceServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/trace.append")
          .add("https://www.googleapis.com/auth/trace.readonly")
          .build();

  private final UnaryCallSettings<PatchTracesRequest, Empty> patchTracesSettings;
  private final UnaryCallSettings<GetTraceRequest, Trace> getTraceSettings;
  private final PagedCallSettings<ListTracesRequest, ListTracesResponse, ListTracesPagedResponse>
      listTracesSettings;

  /** Returns the object with the settings used for calls to patchTraces. */
  public UnaryCallSettings<PatchTracesRequest, Empty> patchTracesSettings() {
    return patchTracesSettings;
  }

  /** Returns the object with the settings used for calls to getTrace. */
  public UnaryCallSettings<GetTraceRequest, Trace> getTraceSettings() {
    return getTraceSettings;
  }

  /** Returns the object with the settings used for calls to listTraces. */
  public PagedCallSettings<ListTracesRequest, ListTracesResponse, ListTracesPagedResponse>
      listTracesSettings() {
    return listTracesSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public TraceServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcTraceServiceStub.create(this);
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
    return "cloudtrace.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(TraceServiceStubSettings.class))
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

  protected TraceServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    patchTracesSettings = settingsBuilder.patchTracesSettings().build();
    getTraceSettings = settingsBuilder.getTraceSettings().build();
    listTracesSettings = settingsBuilder.listTracesSettings().build();
  }

  private static final PagedListDescriptor<ListTracesRequest, ListTracesResponse, Trace>
      LIST_TRACES_PAGE_STR_DESC =
          new PagedListDescriptor<ListTracesRequest, ListTracesResponse, Trace>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListTracesRequest injectToken(ListTracesRequest payload, String token) {
              return ListTracesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListTracesRequest injectPageSize(ListTracesRequest payload, int pageSize) {
              return ListTracesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListTracesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListTracesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Trace> extractResources(ListTracesResponse payload) {
              return payload.getTracesList() != null
                  ? payload.getTracesList()
                  : ImmutableList.<Trace>of();
            }
          };

  private static final PagedListResponseFactory<
          ListTracesRequest, ListTracesResponse, ListTracesPagedResponse>
      LIST_TRACES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListTracesRequest, ListTracesResponse, ListTracesPagedResponse>() {
            @Override
            public ApiFuture<ListTracesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListTracesRequest, ListTracesResponse> callable,
                ListTracesRequest request,
                ApiCallContext context,
                ApiFuture<ListTracesResponse> futureResponse) {
              PageContext<ListTracesRequest, ListTracesResponse, Trace> pageContext =
                  PageContext.create(callable, LIST_TRACES_PAGE_STR_DESC, request, context);
              return ListTracesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Builder for TraceServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<TraceServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;

    private final UnaryCallSettings.Builder<PatchTracesRequest, Empty> patchTracesSettings;
    private final UnaryCallSettings.Builder<GetTraceRequest, Trace> getTraceSettings;
    private final PagedCallSettings.Builder<
            ListTracesRequest, ListTracesResponse, ListTracesPagedResponse>
        listTracesSettings;

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
              .setRetryDelayMultiplier(1.2)
              .setMaxRetryDelay(Duration.ofMillis(1000L))
              .setInitialRpcTimeout(Duration.ofMillis(20000L))
              .setRpcTimeoutMultiplier(1.5)
              .setMaxRpcTimeout(Duration.ofMillis(30000L))
              .setTotalTimeout(Duration.ofMillis(45000L))
              .build();
      definitions.put("default", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      patchTracesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getTraceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listTracesSettings = PagedCallSettings.newBuilder(LIST_TRACES_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              patchTracesSettings, getTraceSettings, listTracesSettings);

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
          .patchTracesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getTraceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listTracesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      return builder;
    }

    protected Builder(TraceServiceStubSettings settings) {
      super(settings);

      patchTracesSettings = settings.patchTracesSettings.toBuilder();
      getTraceSettings = settings.getTraceSettings.toBuilder();
      listTracesSettings = settings.listTracesSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              patchTracesSettings, getTraceSettings, listTracesSettings);
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

    /** Returns the builder for the settings used for calls to patchTraces. */
    public UnaryCallSettings.Builder<PatchTracesRequest, Empty> patchTracesSettings() {
      return patchTracesSettings;
    }

    /** Returns the builder for the settings used for calls to getTrace. */
    public UnaryCallSettings.Builder<GetTraceRequest, Trace> getTraceSettings() {
      return getTraceSettings;
    }

    /** Returns the builder for the settings used for calls to listTraces. */
    public PagedCallSettings.Builder<ListTracesRequest, ListTracesResponse, ListTracesPagedResponse>
        listTracesSettings() {
      return listTracesSettings;
    }

    @Override
    public TraceServiceStubSettings build() throws IOException {
      return new TraceServiceStubSettings(this);
    }
  }
}
