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

package com.google.cloud.discoveryengine.v1.stub;

import static com.google.cloud.discoveryengine.v1.UserLicenseServiceClient.ListUserLicensesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.core.ObsoleteApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.grpc.ProtoOperationTransformers;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.longrunning.OperationTimedPollAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1.BatchUpdateUserLicensesMetadata;
import com.google.cloud.discoveryengine.v1.BatchUpdateUserLicensesRequest;
import com.google.cloud.discoveryengine.v1.BatchUpdateUserLicensesResponse;
import com.google.cloud.discoveryengine.v1.ListUserLicensesRequest;
import com.google.cloud.discoveryengine.v1.ListUserLicensesResponse;
import com.google.cloud.discoveryengine.v1.UserLicense;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link UserLicenseServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (discoveryengine.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of listUserLicenses:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * UserLicenseServiceStubSettings.Builder userLicenseServiceSettingsBuilder =
 *     UserLicenseServiceStubSettings.newBuilder();
 * userLicenseServiceSettingsBuilder
 *     .listUserLicensesSettings()
 *     .setRetrySettings(
 *         userLicenseServiceSettingsBuilder
 *             .listUserLicensesSettings()
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
 * UserLicenseServiceStubSettings userLicenseServiceSettings =
 *     userLicenseServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for batchUpdateUserLicenses:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * UserLicenseServiceStubSettings.Builder userLicenseServiceSettingsBuilder =
 *     UserLicenseServiceStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * userLicenseServiceSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class UserLicenseServiceStubSettings extends StubSettings<UserLicenseServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListUserLicensesRequest, ListUserLicensesResponse, ListUserLicensesPagedResponse>
      listUserLicensesSettings;
  private final UnaryCallSettings<BatchUpdateUserLicensesRequest, Operation>
      batchUpdateUserLicensesSettings;
  private final OperationCallSettings<
          BatchUpdateUserLicensesRequest,
          BatchUpdateUserLicensesResponse,
          BatchUpdateUserLicensesMetadata>
      batchUpdateUserLicensesOperationSettings;

  private static final PagedListDescriptor<
          ListUserLicensesRequest, ListUserLicensesResponse, UserLicense>
      LIST_USER_LICENSES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListUserLicensesRequest, ListUserLicensesResponse, UserLicense>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListUserLicensesRequest injectToken(
                ListUserLicensesRequest payload, String token) {
              return ListUserLicensesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListUserLicensesRequest injectPageSize(
                ListUserLicensesRequest payload, int pageSize) {
              return ListUserLicensesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListUserLicensesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListUserLicensesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<UserLicense> extractResources(ListUserLicensesResponse payload) {
              return payload.getUserLicensesList();
            }
          };

  private static final PagedListResponseFactory<
          ListUserLicensesRequest, ListUserLicensesResponse, ListUserLicensesPagedResponse>
      LIST_USER_LICENSES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListUserLicensesRequest, ListUserLicensesResponse, ListUserLicensesPagedResponse>() {
            @Override
            public ApiFuture<ListUserLicensesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListUserLicensesRequest, ListUserLicensesResponse> callable,
                ListUserLicensesRequest request,
                ApiCallContext context,
                ApiFuture<ListUserLicensesResponse> futureResponse) {
              PageContext<ListUserLicensesRequest, ListUserLicensesResponse, UserLicense>
                  pageContext =
                      PageContext.create(
                          callable, LIST_USER_LICENSES_PAGE_STR_DESC, request, context);
              return ListUserLicensesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listUserLicenses. */
  public PagedCallSettings<
          ListUserLicensesRequest, ListUserLicensesResponse, ListUserLicensesPagedResponse>
      listUserLicensesSettings() {
    return listUserLicensesSettings;
  }

  /** Returns the object with the settings used for calls to batchUpdateUserLicenses. */
  public UnaryCallSettings<BatchUpdateUserLicensesRequest, Operation>
      batchUpdateUserLicensesSettings() {
    return batchUpdateUserLicensesSettings;
  }

  /** Returns the object with the settings used for calls to batchUpdateUserLicenses. */
  public OperationCallSettings<
          BatchUpdateUserLicensesRequest,
          BatchUpdateUserLicensesResponse,
          BatchUpdateUserLicensesMetadata>
      batchUpdateUserLicensesOperationSettings() {
    return batchUpdateUserLicensesOperationSettings;
  }

  public UserLicenseServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcUserLicenseServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonUserLicenseServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "discoveryengine";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "discoveryengine.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "discoveryengine.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(UserLicenseServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(UserLicenseServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return UserLicenseServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected UserLicenseServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listUserLicensesSettings = settingsBuilder.listUserLicensesSettings().build();
    batchUpdateUserLicensesSettings = settingsBuilder.batchUpdateUserLicensesSettings().build();
    batchUpdateUserLicensesOperationSettings =
        settingsBuilder.batchUpdateUserLicensesOperationSettings().build();
  }

  /** Builder for UserLicenseServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<UserLicenseServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListUserLicensesRequest, ListUserLicensesResponse, ListUserLicensesPagedResponse>
        listUserLicensesSettings;
    private final UnaryCallSettings.Builder<BatchUpdateUserLicensesRequest, Operation>
        batchUpdateUserLicensesSettings;
    private final OperationCallSettings.Builder<
            BatchUpdateUserLicensesRequest,
            BatchUpdateUserLicensesResponse,
            BatchUpdateUserLicensesMetadata>
        batchUpdateUserLicensesOperationSettings;
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

      listUserLicensesSettings = PagedCallSettings.newBuilder(LIST_USER_LICENSES_PAGE_STR_FACT);
      batchUpdateUserLicensesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchUpdateUserLicensesOperationSettings = OperationCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listUserLicensesSettings, batchUpdateUserLicensesSettings);
      initDefaults(this);
    }

    protected Builder(UserLicenseServiceStubSettings settings) {
      super(settings);

      listUserLicensesSettings = settings.listUserLicensesSettings.toBuilder();
      batchUpdateUserLicensesSettings = settings.batchUpdateUserLicensesSettings.toBuilder();
      batchUpdateUserLicensesOperationSettings =
          settings.batchUpdateUserLicensesOperationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listUserLicensesSettings, batchUpdateUserLicensesSettings);
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
          .listUserLicensesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchUpdateUserLicensesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchUpdateUserLicensesOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<BatchUpdateUserLicensesRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  BatchUpdateUserLicensesResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  BatchUpdateUserLicensesMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

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

    /** Returns the builder for the settings used for calls to listUserLicenses. */
    public PagedCallSettings.Builder<
            ListUserLicensesRequest, ListUserLicensesResponse, ListUserLicensesPagedResponse>
        listUserLicensesSettings() {
      return listUserLicensesSettings;
    }

    /** Returns the builder for the settings used for calls to batchUpdateUserLicenses. */
    public UnaryCallSettings.Builder<BatchUpdateUserLicensesRequest, Operation>
        batchUpdateUserLicensesSettings() {
      return batchUpdateUserLicensesSettings;
    }

    /** Returns the builder for the settings used for calls to batchUpdateUserLicenses. */
    public OperationCallSettings.Builder<
            BatchUpdateUserLicensesRequest,
            BatchUpdateUserLicensesResponse,
            BatchUpdateUserLicensesMetadata>
        batchUpdateUserLicensesOperationSettings() {
      return batchUpdateUserLicensesOperationSettings;
    }

    @Override
    public UserLicenseServiceStubSettings build() throws IOException {
      return new UserLicenseServiceStubSettings(this);
    }
  }
}
