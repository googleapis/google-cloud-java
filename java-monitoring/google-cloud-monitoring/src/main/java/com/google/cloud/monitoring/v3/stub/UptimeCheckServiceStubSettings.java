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

package com.google.cloud.monitoring.v3.stub;

import static com.google.cloud.monitoring.v3.UptimeCheckServiceClient.ListUptimeCheckConfigsPagedResponse;
import static com.google.cloud.monitoring.v3.UptimeCheckServiceClient.ListUptimeCheckIpsPagedResponse;

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
import com.google.monitoring.v3.CreateUptimeCheckConfigRequest;
import com.google.monitoring.v3.DeleteUptimeCheckConfigRequest;
import com.google.monitoring.v3.GetUptimeCheckConfigRequest;
import com.google.monitoring.v3.ListUptimeCheckConfigsRequest;
import com.google.monitoring.v3.ListUptimeCheckConfigsResponse;
import com.google.monitoring.v3.ListUptimeCheckIpsRequest;
import com.google.monitoring.v3.ListUptimeCheckIpsResponse;
import com.google.monitoring.v3.UpdateUptimeCheckConfigRequest;
import com.google.monitoring.v3.UptimeCheckConfig;
import com.google.monitoring.v3.UptimeCheckIp;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link UptimeCheckServiceStub}.
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
 * <p>For example, to set the total timeout of getUptimeCheckConfig to 30 seconds:
 *
 * <pre>{@code
 * UptimeCheckServiceStubSettings.Builder uptimeCheckServiceSettingsBuilder =
 *     UptimeCheckServiceStubSettings.newBuilder();
 * uptimeCheckServiceSettingsBuilder
 *     .getUptimeCheckConfigSettings()
 *     .setRetrySettings(
 *         uptimeCheckServiceSettingsBuilder
 *             .getUptimeCheckConfigSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * UptimeCheckServiceStubSettings uptimeCheckServiceSettings =
 *     uptimeCheckServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class UptimeCheckServiceStubSettings extends StubSettings<UptimeCheckServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/monitoring")
          .add("https://www.googleapis.com/auth/monitoring.read")
          .build();

  private final PagedCallSettings<
          ListUptimeCheckConfigsRequest,
          ListUptimeCheckConfigsResponse,
          ListUptimeCheckConfigsPagedResponse>
      listUptimeCheckConfigsSettings;
  private final UnaryCallSettings<GetUptimeCheckConfigRequest, UptimeCheckConfig>
      getUptimeCheckConfigSettings;
  private final UnaryCallSettings<CreateUptimeCheckConfigRequest, UptimeCheckConfig>
      createUptimeCheckConfigSettings;
  private final UnaryCallSettings<UpdateUptimeCheckConfigRequest, UptimeCheckConfig>
      updateUptimeCheckConfigSettings;
  private final UnaryCallSettings<DeleteUptimeCheckConfigRequest, Empty>
      deleteUptimeCheckConfigSettings;
  private final PagedCallSettings<
          ListUptimeCheckIpsRequest, ListUptimeCheckIpsResponse, ListUptimeCheckIpsPagedResponse>
      listUptimeCheckIpsSettings;

  private static final PagedListDescriptor<
          ListUptimeCheckConfigsRequest, ListUptimeCheckConfigsResponse, UptimeCheckConfig>
      LIST_UPTIME_CHECK_CONFIGS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListUptimeCheckConfigsRequest, ListUptimeCheckConfigsResponse, UptimeCheckConfig>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListUptimeCheckConfigsRequest injectToken(
                ListUptimeCheckConfigsRequest payload, String token) {
              return ListUptimeCheckConfigsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListUptimeCheckConfigsRequest injectPageSize(
                ListUptimeCheckConfigsRequest payload, int pageSize) {
              return ListUptimeCheckConfigsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListUptimeCheckConfigsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListUptimeCheckConfigsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<UptimeCheckConfig> extractResources(
                ListUptimeCheckConfigsResponse payload) {
              return payload.getUptimeCheckConfigsList() == null
                  ? ImmutableList.<UptimeCheckConfig>of()
                  : payload.getUptimeCheckConfigsList();
            }
          };

  private static final PagedListDescriptor<
          ListUptimeCheckIpsRequest, ListUptimeCheckIpsResponse, UptimeCheckIp>
      LIST_UPTIME_CHECK_IPS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListUptimeCheckIpsRequest, ListUptimeCheckIpsResponse, UptimeCheckIp>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListUptimeCheckIpsRequest injectToken(
                ListUptimeCheckIpsRequest payload, String token) {
              return ListUptimeCheckIpsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListUptimeCheckIpsRequest injectPageSize(
                ListUptimeCheckIpsRequest payload, int pageSize) {
              return ListUptimeCheckIpsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListUptimeCheckIpsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListUptimeCheckIpsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<UptimeCheckIp> extractResources(ListUptimeCheckIpsResponse payload) {
              return payload.getUptimeCheckIpsList() == null
                  ? ImmutableList.<UptimeCheckIp>of()
                  : payload.getUptimeCheckIpsList();
            }
          };

  private static final PagedListResponseFactory<
          ListUptimeCheckConfigsRequest,
          ListUptimeCheckConfigsResponse,
          ListUptimeCheckConfigsPagedResponse>
      LIST_UPTIME_CHECK_CONFIGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListUptimeCheckConfigsRequest,
              ListUptimeCheckConfigsResponse,
              ListUptimeCheckConfigsPagedResponse>() {
            @Override
            public ApiFuture<ListUptimeCheckConfigsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListUptimeCheckConfigsRequest, ListUptimeCheckConfigsResponse>
                    callable,
                ListUptimeCheckConfigsRequest request,
                ApiCallContext context,
                ApiFuture<ListUptimeCheckConfigsResponse> futureResponse) {
              PageContext<
                      ListUptimeCheckConfigsRequest,
                      ListUptimeCheckConfigsResponse,
                      UptimeCheckConfig>
                  pageContext =
                      PageContext.create(
                          callable, LIST_UPTIME_CHECK_CONFIGS_PAGE_STR_DESC, request, context);
              return ListUptimeCheckConfigsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListUptimeCheckIpsRequest, ListUptimeCheckIpsResponse, ListUptimeCheckIpsPagedResponse>
      LIST_UPTIME_CHECK_IPS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListUptimeCheckIpsRequest,
              ListUptimeCheckIpsResponse,
              ListUptimeCheckIpsPagedResponse>() {
            @Override
            public ApiFuture<ListUptimeCheckIpsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListUptimeCheckIpsRequest, ListUptimeCheckIpsResponse> callable,
                ListUptimeCheckIpsRequest request,
                ApiCallContext context,
                ApiFuture<ListUptimeCheckIpsResponse> futureResponse) {
              PageContext<ListUptimeCheckIpsRequest, ListUptimeCheckIpsResponse, UptimeCheckIp>
                  pageContext =
                      PageContext.create(
                          callable, LIST_UPTIME_CHECK_IPS_PAGE_STR_DESC, request, context);
              return ListUptimeCheckIpsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listUptimeCheckConfigs. */
  public PagedCallSettings<
          ListUptimeCheckConfigsRequest,
          ListUptimeCheckConfigsResponse,
          ListUptimeCheckConfigsPagedResponse>
      listUptimeCheckConfigsSettings() {
    return listUptimeCheckConfigsSettings;
  }

  /** Returns the object with the settings used for calls to getUptimeCheckConfig. */
  public UnaryCallSettings<GetUptimeCheckConfigRequest, UptimeCheckConfig>
      getUptimeCheckConfigSettings() {
    return getUptimeCheckConfigSettings;
  }

  /** Returns the object with the settings used for calls to createUptimeCheckConfig. */
  public UnaryCallSettings<CreateUptimeCheckConfigRequest, UptimeCheckConfig>
      createUptimeCheckConfigSettings() {
    return createUptimeCheckConfigSettings;
  }

  /** Returns the object with the settings used for calls to updateUptimeCheckConfig. */
  public UnaryCallSettings<UpdateUptimeCheckConfigRequest, UptimeCheckConfig>
      updateUptimeCheckConfigSettings() {
    return updateUptimeCheckConfigSettings;
  }

  /** Returns the object with the settings used for calls to deleteUptimeCheckConfig. */
  public UnaryCallSettings<DeleteUptimeCheckConfigRequest, Empty>
      deleteUptimeCheckConfigSettings() {
    return deleteUptimeCheckConfigSettings;
  }

  /** Returns the object with the settings used for calls to listUptimeCheckIps. */
  public PagedCallSettings<
          ListUptimeCheckIpsRequest, ListUptimeCheckIpsResponse, ListUptimeCheckIpsPagedResponse>
      listUptimeCheckIpsSettings() {
    return listUptimeCheckIpsSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public UptimeCheckServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcUptimeCheckServiceStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(UptimeCheckServiceStubSettings.class))
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

  protected UptimeCheckServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listUptimeCheckConfigsSettings = settingsBuilder.listUptimeCheckConfigsSettings().build();
    getUptimeCheckConfigSettings = settingsBuilder.getUptimeCheckConfigSettings().build();
    createUptimeCheckConfigSettings = settingsBuilder.createUptimeCheckConfigSettings().build();
    updateUptimeCheckConfigSettings = settingsBuilder.updateUptimeCheckConfigSettings().build();
    deleteUptimeCheckConfigSettings = settingsBuilder.deleteUptimeCheckConfigSettings().build();
    listUptimeCheckIpsSettings = settingsBuilder.listUptimeCheckIpsSettings().build();
  }

  /** Builder for UptimeCheckServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<UptimeCheckServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListUptimeCheckConfigsRequest,
            ListUptimeCheckConfigsResponse,
            ListUptimeCheckConfigsPagedResponse>
        listUptimeCheckConfigsSettings;
    private final UnaryCallSettings.Builder<GetUptimeCheckConfigRequest, UptimeCheckConfig>
        getUptimeCheckConfigSettings;
    private final UnaryCallSettings.Builder<CreateUptimeCheckConfigRequest, UptimeCheckConfig>
        createUptimeCheckConfigSettings;
    private final UnaryCallSettings.Builder<UpdateUptimeCheckConfigRequest, UptimeCheckConfig>
        updateUptimeCheckConfigSettings;
    private final UnaryCallSettings.Builder<DeleteUptimeCheckConfigRequest, Empty>
        deleteUptimeCheckConfigSettings;
    private final PagedCallSettings.Builder<
            ListUptimeCheckIpsRequest, ListUptimeCheckIpsResponse, ListUptimeCheckIpsPagedResponse>
        listUptimeCheckIpsSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_7_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
      definitions.put(
          "no_retry_11_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
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
              .setMaxRetryDelay(Duration.ofMillis(30000L))
              .setInitialRpcTimeout(Duration.ofMillis(30000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(30000L))
              .setTotalTimeout(Duration.ofMillis(30000L))
              .build();
      definitions.put("retry_policy_7_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(30000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(30000L))
              .setTotalTimeout(Duration.ofMillis(30000L))
              .build();
      definitions.put("no_retry_11_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listUptimeCheckConfigsSettings =
          PagedCallSettings.newBuilder(LIST_UPTIME_CHECK_CONFIGS_PAGE_STR_FACT);
      getUptimeCheckConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createUptimeCheckConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateUptimeCheckConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteUptimeCheckConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listUptimeCheckIpsSettings =
          PagedCallSettings.newBuilder(LIST_UPTIME_CHECK_IPS_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listUptimeCheckConfigsSettings,
              getUptimeCheckConfigSettings,
              createUptimeCheckConfigSettings,
              updateUptimeCheckConfigSettings,
              deleteUptimeCheckConfigSettings,
              listUptimeCheckIpsSettings);
      initDefaults(this);
    }

    protected Builder(UptimeCheckServiceStubSettings settings) {
      super(settings);

      listUptimeCheckConfigsSettings = settings.listUptimeCheckConfigsSettings.toBuilder();
      getUptimeCheckConfigSettings = settings.getUptimeCheckConfigSettings.toBuilder();
      createUptimeCheckConfigSettings = settings.createUptimeCheckConfigSettings.toBuilder();
      updateUptimeCheckConfigSettings = settings.updateUptimeCheckConfigSettings.toBuilder();
      deleteUptimeCheckConfigSettings = settings.deleteUptimeCheckConfigSettings.toBuilder();
      listUptimeCheckIpsSettings = settings.listUptimeCheckIpsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listUptimeCheckConfigsSettings,
              getUptimeCheckConfigSettings,
              createUptimeCheckConfigSettings,
              updateUptimeCheckConfigSettings,
              deleteUptimeCheckConfigSettings,
              listUptimeCheckIpsSettings);
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
          .listUptimeCheckConfigsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_7_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_7_params"));

      builder
          .getUptimeCheckConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_7_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_7_params"));

      builder
          .createUptimeCheckConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_11_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_11_params"));

      builder
          .updateUptimeCheckConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_11_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_11_params"));

      builder
          .deleteUptimeCheckConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_7_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_7_params"));

      builder
          .listUptimeCheckIpsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_7_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_7_params"));

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

    /** Returns the builder for the settings used for calls to listUptimeCheckConfigs. */
    public PagedCallSettings.Builder<
            ListUptimeCheckConfigsRequest,
            ListUptimeCheckConfigsResponse,
            ListUptimeCheckConfigsPagedResponse>
        listUptimeCheckConfigsSettings() {
      return listUptimeCheckConfigsSettings;
    }

    /** Returns the builder for the settings used for calls to getUptimeCheckConfig. */
    public UnaryCallSettings.Builder<GetUptimeCheckConfigRequest, UptimeCheckConfig>
        getUptimeCheckConfigSettings() {
      return getUptimeCheckConfigSettings;
    }

    /** Returns the builder for the settings used for calls to createUptimeCheckConfig. */
    public UnaryCallSettings.Builder<CreateUptimeCheckConfigRequest, UptimeCheckConfig>
        createUptimeCheckConfigSettings() {
      return createUptimeCheckConfigSettings;
    }

    /** Returns the builder for the settings used for calls to updateUptimeCheckConfig. */
    public UnaryCallSettings.Builder<UpdateUptimeCheckConfigRequest, UptimeCheckConfig>
        updateUptimeCheckConfigSettings() {
      return updateUptimeCheckConfigSettings;
    }

    /** Returns the builder for the settings used for calls to deleteUptimeCheckConfig. */
    public UnaryCallSettings.Builder<DeleteUptimeCheckConfigRequest, Empty>
        deleteUptimeCheckConfigSettings() {
      return deleteUptimeCheckConfigSettings;
    }

    /** Returns the builder for the settings used for calls to listUptimeCheckIps. */
    public PagedCallSettings.Builder<
            ListUptimeCheckIpsRequest, ListUptimeCheckIpsResponse, ListUptimeCheckIpsPagedResponse>
        listUptimeCheckIpsSettings() {
      return listUptimeCheckIpsSettings;
    }

    @Override
    public UptimeCheckServiceStubSettings build() throws IOException {
      return new UptimeCheckServiceStubSettings(this);
    }
  }
}
