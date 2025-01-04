/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.apihub.v1.stub;

import static com.google.cloud.apihub.v1.RuntimeProjectAttachmentServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.apihub.v1.RuntimeProjectAttachmentServiceClient.ListRuntimeProjectAttachmentsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ObsoleteApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
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
import com.google.cloud.apihub.v1.CreateRuntimeProjectAttachmentRequest;
import com.google.cloud.apihub.v1.DeleteRuntimeProjectAttachmentRequest;
import com.google.cloud.apihub.v1.GetRuntimeProjectAttachmentRequest;
import com.google.cloud.apihub.v1.ListRuntimeProjectAttachmentsRequest;
import com.google.cloud.apihub.v1.ListRuntimeProjectAttachmentsResponse;
import com.google.cloud.apihub.v1.LookupRuntimeProjectAttachmentRequest;
import com.google.cloud.apihub.v1.LookupRuntimeProjectAttachmentResponse;
import com.google.cloud.apihub.v1.RuntimeProjectAttachment;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link RuntimeProjectAttachmentServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (apihub.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of createRuntimeProjectAttachment:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * RuntimeProjectAttachmentServiceStubSettings.Builder
 *     runtimeProjectAttachmentServiceSettingsBuilder =
 *         RuntimeProjectAttachmentServiceStubSettings.newBuilder();
 * runtimeProjectAttachmentServiceSettingsBuilder
 *     .createRuntimeProjectAttachmentSettings()
 *     .setRetrySettings(
 *         runtimeProjectAttachmentServiceSettingsBuilder
 *             .createRuntimeProjectAttachmentSettings()
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
 * RuntimeProjectAttachmentServiceStubSettings runtimeProjectAttachmentServiceSettings =
 *     runtimeProjectAttachmentServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 */
@Generated("by gapic-generator-java")
public class RuntimeProjectAttachmentServiceStubSettings
    extends StubSettings<RuntimeProjectAttachmentServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateRuntimeProjectAttachmentRequest, RuntimeProjectAttachment>
      createRuntimeProjectAttachmentSettings;
  private final UnaryCallSettings<GetRuntimeProjectAttachmentRequest, RuntimeProjectAttachment>
      getRuntimeProjectAttachmentSettings;
  private final PagedCallSettings<
          ListRuntimeProjectAttachmentsRequest,
          ListRuntimeProjectAttachmentsResponse,
          ListRuntimeProjectAttachmentsPagedResponse>
      listRuntimeProjectAttachmentsSettings;
  private final UnaryCallSettings<DeleteRuntimeProjectAttachmentRequest, Empty>
      deleteRuntimeProjectAttachmentSettings;
  private final UnaryCallSettings<
          LookupRuntimeProjectAttachmentRequest, LookupRuntimeProjectAttachmentResponse>
      lookupRuntimeProjectAttachmentSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;

  private static final PagedListDescriptor<
          ListRuntimeProjectAttachmentsRequest,
          ListRuntimeProjectAttachmentsResponse,
          RuntimeProjectAttachment>
      LIST_RUNTIME_PROJECT_ATTACHMENTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListRuntimeProjectAttachmentsRequest,
              ListRuntimeProjectAttachmentsResponse,
              RuntimeProjectAttachment>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListRuntimeProjectAttachmentsRequest injectToken(
                ListRuntimeProjectAttachmentsRequest payload, String token) {
              return ListRuntimeProjectAttachmentsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListRuntimeProjectAttachmentsRequest injectPageSize(
                ListRuntimeProjectAttachmentsRequest payload, int pageSize) {
              return ListRuntimeProjectAttachmentsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListRuntimeProjectAttachmentsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListRuntimeProjectAttachmentsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<RuntimeProjectAttachment> extractResources(
                ListRuntimeProjectAttachmentsResponse payload) {
              return payload.getRuntimeProjectAttachmentsList();
            }
          };

  private static final PagedListDescriptor<ListLocationsRequest, ListLocationsResponse, Location>
      LIST_LOCATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<ListLocationsRequest, ListLocationsResponse, Location>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListLocationsRequest injectToken(ListLocationsRequest payload, String token) {
              return ListLocationsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListLocationsRequest injectPageSize(ListLocationsRequest payload, int pageSize) {
              return ListLocationsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListLocationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListLocationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Location> extractResources(ListLocationsResponse payload) {
              return payload.getLocationsList();
            }
          };

  private static final PagedListResponseFactory<
          ListRuntimeProjectAttachmentsRequest,
          ListRuntimeProjectAttachmentsResponse,
          ListRuntimeProjectAttachmentsPagedResponse>
      LIST_RUNTIME_PROJECT_ATTACHMENTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListRuntimeProjectAttachmentsRequest,
              ListRuntimeProjectAttachmentsResponse,
              ListRuntimeProjectAttachmentsPagedResponse>() {
            @Override
            public ApiFuture<ListRuntimeProjectAttachmentsPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        ListRuntimeProjectAttachmentsRequest, ListRuntimeProjectAttachmentsResponse>
                    callable,
                ListRuntimeProjectAttachmentsRequest request,
                ApiCallContext context,
                ApiFuture<ListRuntimeProjectAttachmentsResponse> futureResponse) {
              PageContext<
                      ListRuntimeProjectAttachmentsRequest,
                      ListRuntimeProjectAttachmentsResponse,
                      RuntimeProjectAttachment>
                  pageContext =
                      PageContext.create(
                          callable,
                          LIST_RUNTIME_PROJECT_ATTACHMENTS_PAGE_STR_DESC,
                          request,
                          context);
              return ListRuntimeProjectAttachmentsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      LIST_LOCATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>() {
            @Override
            public ApiFuture<ListLocationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListLocationsRequest, ListLocationsResponse> callable,
                ListLocationsRequest request,
                ApiCallContext context,
                ApiFuture<ListLocationsResponse> futureResponse) {
              PageContext<ListLocationsRequest, ListLocationsResponse, Location> pageContext =
                  PageContext.create(callable, LIST_LOCATIONS_PAGE_STR_DESC, request, context);
              return ListLocationsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createRuntimeProjectAttachment. */
  public UnaryCallSettings<CreateRuntimeProjectAttachmentRequest, RuntimeProjectAttachment>
      createRuntimeProjectAttachmentSettings() {
    return createRuntimeProjectAttachmentSettings;
  }

  /** Returns the object with the settings used for calls to getRuntimeProjectAttachment. */
  public UnaryCallSettings<GetRuntimeProjectAttachmentRequest, RuntimeProjectAttachment>
      getRuntimeProjectAttachmentSettings() {
    return getRuntimeProjectAttachmentSettings;
  }

  /** Returns the object with the settings used for calls to listRuntimeProjectAttachments. */
  public PagedCallSettings<
          ListRuntimeProjectAttachmentsRequest,
          ListRuntimeProjectAttachmentsResponse,
          ListRuntimeProjectAttachmentsPagedResponse>
      listRuntimeProjectAttachmentsSettings() {
    return listRuntimeProjectAttachmentsSettings;
  }

  /** Returns the object with the settings used for calls to deleteRuntimeProjectAttachment. */
  public UnaryCallSettings<DeleteRuntimeProjectAttachmentRequest, Empty>
      deleteRuntimeProjectAttachmentSettings() {
    return deleteRuntimeProjectAttachmentSettings;
  }

  /** Returns the object with the settings used for calls to lookupRuntimeProjectAttachment. */
  public UnaryCallSettings<
          LookupRuntimeProjectAttachmentRequest, LookupRuntimeProjectAttachmentResponse>
      lookupRuntimeProjectAttachmentSettings() {
    return lookupRuntimeProjectAttachmentSettings;
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return listLocationsSettings;
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return getLocationSettings;
  }

  public RuntimeProjectAttachmentServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonRuntimeProjectAttachmentServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "apihub";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "apihub.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "apihub.mtls.googleapis.com:443";
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
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstantiatingHttpJsonChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultHttpJsonTransportProviderBuilder().build();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic",
            GaxProperties.getLibraryVersion(RuntimeProjectAttachmentServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
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

  protected RuntimeProjectAttachmentServiceStubSettings(Builder settingsBuilder)
      throws IOException {
    super(settingsBuilder);

    createRuntimeProjectAttachmentSettings =
        settingsBuilder.createRuntimeProjectAttachmentSettings().build();
    getRuntimeProjectAttachmentSettings =
        settingsBuilder.getRuntimeProjectAttachmentSettings().build();
    listRuntimeProjectAttachmentsSettings =
        settingsBuilder.listRuntimeProjectAttachmentsSettings().build();
    deleteRuntimeProjectAttachmentSettings =
        settingsBuilder.deleteRuntimeProjectAttachmentSettings().build();
    lookupRuntimeProjectAttachmentSettings =
        settingsBuilder.lookupRuntimeProjectAttachmentSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
  }

  /** Builder for RuntimeProjectAttachmentServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<RuntimeProjectAttachmentServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<
            CreateRuntimeProjectAttachmentRequest, RuntimeProjectAttachment>
        createRuntimeProjectAttachmentSettings;
    private final UnaryCallSettings.Builder<
            GetRuntimeProjectAttachmentRequest, RuntimeProjectAttachment>
        getRuntimeProjectAttachmentSettings;
    private final PagedCallSettings.Builder<
            ListRuntimeProjectAttachmentsRequest,
            ListRuntimeProjectAttachmentsResponse,
            ListRuntimeProjectAttachmentsPagedResponse>
        listRuntimeProjectAttachmentsSettings;
    private final UnaryCallSettings.Builder<DeleteRuntimeProjectAttachmentRequest, Empty>
        deleteRuntimeProjectAttachmentSettings;
    private final UnaryCallSettings.Builder<
            LookupRuntimeProjectAttachmentRequest, LookupRuntimeProjectAttachmentResponse>
        lookupRuntimeProjectAttachmentSettings;
    private final PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings;
    private final UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "no_retry_1_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
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
      definitions.put("no_retry_1_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelayDuration(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelayDuration(Duration.ofMillis(10000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createRuntimeProjectAttachmentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getRuntimeProjectAttachmentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listRuntimeProjectAttachmentsSettings =
          PagedCallSettings.newBuilder(LIST_RUNTIME_PROJECT_ATTACHMENTS_PAGE_STR_FACT);
      deleteRuntimeProjectAttachmentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      lookupRuntimeProjectAttachmentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createRuntimeProjectAttachmentSettings,
              getRuntimeProjectAttachmentSettings,
              listRuntimeProjectAttachmentsSettings,
              deleteRuntimeProjectAttachmentSettings,
              lookupRuntimeProjectAttachmentSettings,
              listLocationsSettings,
              getLocationSettings);
      initDefaults(this);
    }

    protected Builder(RuntimeProjectAttachmentServiceStubSettings settings) {
      super(settings);

      createRuntimeProjectAttachmentSettings =
          settings.createRuntimeProjectAttachmentSettings.toBuilder();
      getRuntimeProjectAttachmentSettings =
          settings.getRuntimeProjectAttachmentSettings.toBuilder();
      listRuntimeProjectAttachmentsSettings =
          settings.listRuntimeProjectAttachmentsSettings.toBuilder();
      deleteRuntimeProjectAttachmentSettings =
          settings.deleteRuntimeProjectAttachmentSettings.toBuilder();
      lookupRuntimeProjectAttachmentSettings =
          settings.lookupRuntimeProjectAttachmentSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createRuntimeProjectAttachmentSettings,
              getRuntimeProjectAttachmentSettings,
              listRuntimeProjectAttachmentsSettings,
              deleteRuntimeProjectAttachmentSettings,
              lookupRuntimeProjectAttachmentSettings,
              listLocationsSettings,
              getLocationSettings);
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

    private static Builder initDefaults(Builder builder) {
      builder
          .createRuntimeProjectAttachmentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getRuntimeProjectAttachmentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listRuntimeProjectAttachmentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteRuntimeProjectAttachmentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .lookupRuntimeProjectAttachmentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listLocationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getLocationSettings()
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

    /** Returns the builder for the settings used for calls to createRuntimeProjectAttachment. */
    public UnaryCallSettings.Builder<
            CreateRuntimeProjectAttachmentRequest, RuntimeProjectAttachment>
        createRuntimeProjectAttachmentSettings() {
      return createRuntimeProjectAttachmentSettings;
    }

    /** Returns the builder for the settings used for calls to getRuntimeProjectAttachment. */
    public UnaryCallSettings.Builder<GetRuntimeProjectAttachmentRequest, RuntimeProjectAttachment>
        getRuntimeProjectAttachmentSettings() {
      return getRuntimeProjectAttachmentSettings;
    }

    /** Returns the builder for the settings used for calls to listRuntimeProjectAttachments. */
    public PagedCallSettings.Builder<
            ListRuntimeProjectAttachmentsRequest,
            ListRuntimeProjectAttachmentsResponse,
            ListRuntimeProjectAttachmentsPagedResponse>
        listRuntimeProjectAttachmentsSettings() {
      return listRuntimeProjectAttachmentsSettings;
    }

    /** Returns the builder for the settings used for calls to deleteRuntimeProjectAttachment. */
    public UnaryCallSettings.Builder<DeleteRuntimeProjectAttachmentRequest, Empty>
        deleteRuntimeProjectAttachmentSettings() {
      return deleteRuntimeProjectAttachmentSettings;
    }

    /** Returns the builder for the settings used for calls to lookupRuntimeProjectAttachment. */
    public UnaryCallSettings.Builder<
            LookupRuntimeProjectAttachmentRequest, LookupRuntimeProjectAttachmentResponse>
        lookupRuntimeProjectAttachmentSettings() {
      return lookupRuntimeProjectAttachmentSettings;
    }

    /** Returns the builder for the settings used for calls to listLocations. */
    public PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings() {
      return listLocationsSettings;
    }

    /** Returns the builder for the settings used for calls to getLocation. */
    public UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings() {
      return getLocationSettings;
    }

    @Override
    public RuntimeProjectAttachmentServiceStubSettings build() throws IOException {
      return new RuntimeProjectAttachmentServiceStubSettings(this);
    }
  }
}
