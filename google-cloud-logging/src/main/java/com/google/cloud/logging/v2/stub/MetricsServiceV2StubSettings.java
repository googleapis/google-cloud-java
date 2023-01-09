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

package com.google.cloud.logging.v2.stub;

import static com.google.cloud.logging.v2.MetricsClient.ListLogMetricsPagedResponse;

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
import com.google.logging.v2.CreateLogMetricRequest;
import com.google.logging.v2.DeleteLogMetricRequest;
import com.google.logging.v2.GetLogMetricRequest;
import com.google.logging.v2.ListLogMetricsRequest;
import com.google.logging.v2.ListLogMetricsResponse;
import com.google.logging.v2.LogMetric;
import com.google.logging.v2.UpdateLogMetricRequest;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link MetricsServiceV2Stub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (logging.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getLogMetric to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * MetricsServiceV2StubSettings.Builder metricsSettingsBuilder =
 *     MetricsServiceV2StubSettings.newBuilder();
 * metricsSettingsBuilder
 *     .getLogMetricSettings()
 *     .setRetrySettings(
 *         metricsSettingsBuilder
 *             .getLogMetricSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * MetricsServiceV2StubSettings metricsSettings = metricsSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class MetricsServiceV2StubSettings extends StubSettings<MetricsServiceV2StubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/cloud-platform.read-only")
          .add("https://www.googleapis.com/auth/logging.admin")
          .add("https://www.googleapis.com/auth/logging.read")
          .add("https://www.googleapis.com/auth/logging.write")
          .build();

  private final PagedCallSettings<
          ListLogMetricsRequest, ListLogMetricsResponse, ListLogMetricsPagedResponse>
      listLogMetricsSettings;
  private final UnaryCallSettings<GetLogMetricRequest, LogMetric> getLogMetricSettings;
  private final UnaryCallSettings<CreateLogMetricRequest, LogMetric> createLogMetricSettings;
  private final UnaryCallSettings<UpdateLogMetricRequest, LogMetric> updateLogMetricSettings;
  private final UnaryCallSettings<DeleteLogMetricRequest, Empty> deleteLogMetricSettings;

  private static final PagedListDescriptor<ListLogMetricsRequest, ListLogMetricsResponse, LogMetric>
      LIST_LOG_METRICS_PAGE_STR_DESC =
          new PagedListDescriptor<ListLogMetricsRequest, ListLogMetricsResponse, LogMetric>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListLogMetricsRequest injectToken(ListLogMetricsRequest payload, String token) {
              return ListLogMetricsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListLogMetricsRequest injectPageSize(
                ListLogMetricsRequest payload, int pageSize) {
              return ListLogMetricsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListLogMetricsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListLogMetricsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<LogMetric> extractResources(ListLogMetricsResponse payload) {
              return payload.getMetricsList() == null
                  ? ImmutableList.<LogMetric>of()
                  : payload.getMetricsList();
            }
          };

  private static final PagedListResponseFactory<
          ListLogMetricsRequest, ListLogMetricsResponse, ListLogMetricsPagedResponse>
      LIST_LOG_METRICS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListLogMetricsRequest, ListLogMetricsResponse, ListLogMetricsPagedResponse>() {
            @Override
            public ApiFuture<ListLogMetricsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListLogMetricsRequest, ListLogMetricsResponse> callable,
                ListLogMetricsRequest request,
                ApiCallContext context,
                ApiFuture<ListLogMetricsResponse> futureResponse) {
              PageContext<ListLogMetricsRequest, ListLogMetricsResponse, LogMetric> pageContext =
                  PageContext.create(callable, LIST_LOG_METRICS_PAGE_STR_DESC, request, context);
              return ListLogMetricsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listLogMetrics. */
  public PagedCallSettings<
          ListLogMetricsRequest, ListLogMetricsResponse, ListLogMetricsPagedResponse>
      listLogMetricsSettings() {
    return listLogMetricsSettings;
  }

  /** Returns the object with the settings used for calls to getLogMetric. */
  public UnaryCallSettings<GetLogMetricRequest, LogMetric> getLogMetricSettings() {
    return getLogMetricSettings;
  }

  /** Returns the object with the settings used for calls to createLogMetric. */
  public UnaryCallSettings<CreateLogMetricRequest, LogMetric> createLogMetricSettings() {
    return createLogMetricSettings;
  }

  /** Returns the object with the settings used for calls to updateLogMetric. */
  public UnaryCallSettings<UpdateLogMetricRequest, LogMetric> updateLogMetricSettings() {
    return updateLogMetricSettings;
  }

  /** Returns the object with the settings used for calls to deleteLogMetric. */
  public UnaryCallSettings<DeleteLogMetricRequest, Empty> deleteLogMetricSettings() {
    return deleteLogMetricSettings;
  }

  public MetricsServiceV2Stub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcMetricsServiceV2Stub.create(this);
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
    return "logging.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "logging.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(MetricsServiceV2StubSettings.class))
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

  protected MetricsServiceV2StubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listLogMetricsSettings = settingsBuilder.listLogMetricsSettings().build();
    getLogMetricSettings = settingsBuilder.getLogMetricSettings().build();
    createLogMetricSettings = settingsBuilder.createLogMetricSettings().build();
    updateLogMetricSettings = settingsBuilder.updateLogMetricSettings().build();
    deleteLogMetricSettings = settingsBuilder.deleteLogMetricSettings().build();
  }

  /** Builder for MetricsServiceV2StubSettings. */
  public static class Builder extends StubSettings.Builder<MetricsServiceV2StubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListLogMetricsRequest, ListLogMetricsResponse, ListLogMetricsPagedResponse>
        listLogMetricsSettings;
    private final UnaryCallSettings.Builder<GetLogMetricRequest, LogMetric> getLogMetricSettings;
    private final UnaryCallSettings.Builder<CreateLogMetricRequest, LogMetric>
        createLogMetricSettings;
    private final UnaryCallSettings.Builder<UpdateLogMetricRequest, LogMetric>
        updateLogMetricSettings;
    private final UnaryCallSettings.Builder<DeleteLogMetricRequest, Empty> deleteLogMetricSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_5_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED,
                  StatusCode.Code.INTERNAL,
                  StatusCode.Code.UNAVAILABLE)));
      definitions.put(
          "no_retry_0_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
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
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_5_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listLogMetricsSettings = PagedCallSettings.newBuilder(LIST_LOG_METRICS_PAGE_STR_FACT);
      getLogMetricSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createLogMetricSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateLogMetricSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteLogMetricSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listLogMetricsSettings,
              getLogMetricSettings,
              createLogMetricSettings,
              updateLogMetricSettings,
              deleteLogMetricSettings);
      initDefaults(this);
    }

    protected Builder(MetricsServiceV2StubSettings settings) {
      super(settings);

      listLogMetricsSettings = settings.listLogMetricsSettings.toBuilder();
      getLogMetricSettings = settings.getLogMetricSettings.toBuilder();
      createLogMetricSettings = settings.createLogMetricSettings.toBuilder();
      updateLogMetricSettings = settings.updateLogMetricSettings.toBuilder();
      deleteLogMetricSettings = settings.deleteLogMetricSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listLogMetricsSettings,
              getLogMetricSettings,
              createLogMetricSettings,
              updateLogMetricSettings,
              deleteLogMetricSettings);
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
          .listLogMetricsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_5_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_5_params"));

      builder
          .getLogMetricSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_5_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_5_params"));

      builder
          .createLogMetricSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateLogMetricSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_5_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_5_params"));

      builder
          .deleteLogMetricSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_5_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_5_params"));

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

    /** Returns the builder for the settings used for calls to listLogMetrics. */
    public PagedCallSettings.Builder<
            ListLogMetricsRequest, ListLogMetricsResponse, ListLogMetricsPagedResponse>
        listLogMetricsSettings() {
      return listLogMetricsSettings;
    }

    /** Returns the builder for the settings used for calls to getLogMetric. */
    public UnaryCallSettings.Builder<GetLogMetricRequest, LogMetric> getLogMetricSettings() {
      return getLogMetricSettings;
    }

    /** Returns the builder for the settings used for calls to createLogMetric. */
    public UnaryCallSettings.Builder<CreateLogMetricRequest, LogMetric> createLogMetricSettings() {
      return createLogMetricSettings;
    }

    /** Returns the builder for the settings used for calls to updateLogMetric. */
    public UnaryCallSettings.Builder<UpdateLogMetricRequest, LogMetric> updateLogMetricSettings() {
      return updateLogMetricSettings;
    }

    /** Returns the builder for the settings used for calls to deleteLogMetric. */
    public UnaryCallSettings.Builder<DeleteLogMetricRequest, Empty> deleteLogMetricSettings() {
      return deleteLogMetricSettings;
    }

    @Override
    public MetricsServiceV2StubSettings build() throws IOException {
      return new MetricsServiceV2StubSettings(this);
    }
  }
}
