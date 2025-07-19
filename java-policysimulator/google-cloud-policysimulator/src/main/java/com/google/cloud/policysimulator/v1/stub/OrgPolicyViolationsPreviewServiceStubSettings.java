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

package com.google.cloud.policysimulator.v1.stub;

import static com.google.cloud.policysimulator.v1.OrgPolicyViolationsPreviewServiceClient.ListOrgPolicyViolationsPagedResponse;
import static com.google.cloud.policysimulator.v1.OrgPolicyViolationsPreviewServiceClient.ListOrgPolicyViolationsPreviewsPagedResponse;

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
import com.google.cloud.policysimulator.v1.CreateOrgPolicyViolationsPreviewOperationMetadata;
import com.google.cloud.policysimulator.v1.CreateOrgPolicyViolationsPreviewRequest;
import com.google.cloud.policysimulator.v1.GetOrgPolicyViolationsPreviewRequest;
import com.google.cloud.policysimulator.v1.ListOrgPolicyViolationsPreviewsRequest;
import com.google.cloud.policysimulator.v1.ListOrgPolicyViolationsPreviewsResponse;
import com.google.cloud.policysimulator.v1.ListOrgPolicyViolationsRequest;
import com.google.cloud.policysimulator.v1.ListOrgPolicyViolationsResponse;
import com.google.cloud.policysimulator.v1.OrgPolicyViolation;
import com.google.cloud.policysimulator.v1.OrgPolicyViolationsPreview;
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
 * Settings class to configure an instance of {@link OrgPolicyViolationsPreviewServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (policysimulator.googleapis.com) and default port (443) are
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
 * of getOrgPolicyViolationsPreview:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * OrgPolicyViolationsPreviewServiceStubSettings.Builder
 *     orgPolicyViolationsPreviewServiceSettingsBuilder =
 *         OrgPolicyViolationsPreviewServiceStubSettings.newBuilder();
 * orgPolicyViolationsPreviewServiceSettingsBuilder
 *     .getOrgPolicyViolationsPreviewSettings()
 *     .setRetrySettings(
 *         orgPolicyViolationsPreviewServiceSettingsBuilder
 *             .getOrgPolicyViolationsPreviewSettings()
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
 * OrgPolicyViolationsPreviewServiceStubSettings orgPolicyViolationsPreviewServiceSettings =
 *     orgPolicyViolationsPreviewServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createOrgPolicyViolationsPreview:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * OrgPolicyViolationsPreviewServiceStubSettings.Builder
 *     orgPolicyViolationsPreviewServiceSettingsBuilder =
 *         OrgPolicyViolationsPreviewServiceStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * orgPolicyViolationsPreviewServiceSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class OrgPolicyViolationsPreviewServiceStubSettings
    extends StubSettings<OrgPolicyViolationsPreviewServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListOrgPolicyViolationsPreviewsRequest,
          ListOrgPolicyViolationsPreviewsResponse,
          ListOrgPolicyViolationsPreviewsPagedResponse>
      listOrgPolicyViolationsPreviewsSettings;
  private final UnaryCallSettings<GetOrgPolicyViolationsPreviewRequest, OrgPolicyViolationsPreview>
      getOrgPolicyViolationsPreviewSettings;
  private final UnaryCallSettings<CreateOrgPolicyViolationsPreviewRequest, Operation>
      createOrgPolicyViolationsPreviewSettings;
  private final OperationCallSettings<
          CreateOrgPolicyViolationsPreviewRequest,
          OrgPolicyViolationsPreview,
          CreateOrgPolicyViolationsPreviewOperationMetadata>
      createOrgPolicyViolationsPreviewOperationSettings;
  private final PagedCallSettings<
          ListOrgPolicyViolationsRequest,
          ListOrgPolicyViolationsResponse,
          ListOrgPolicyViolationsPagedResponse>
      listOrgPolicyViolationsSettings;

  private static final PagedListDescriptor<
          ListOrgPolicyViolationsPreviewsRequest,
          ListOrgPolicyViolationsPreviewsResponse,
          OrgPolicyViolationsPreview>
      LIST_ORG_POLICY_VIOLATIONS_PREVIEWS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListOrgPolicyViolationsPreviewsRequest,
              ListOrgPolicyViolationsPreviewsResponse,
              OrgPolicyViolationsPreview>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListOrgPolicyViolationsPreviewsRequest injectToken(
                ListOrgPolicyViolationsPreviewsRequest payload, String token) {
              return ListOrgPolicyViolationsPreviewsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListOrgPolicyViolationsPreviewsRequest injectPageSize(
                ListOrgPolicyViolationsPreviewsRequest payload, int pageSize) {
              return ListOrgPolicyViolationsPreviewsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListOrgPolicyViolationsPreviewsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListOrgPolicyViolationsPreviewsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<OrgPolicyViolationsPreview> extractResources(
                ListOrgPolicyViolationsPreviewsResponse payload) {
              return payload.getOrgPolicyViolationsPreviewsList();
            }
          };

  private static final PagedListDescriptor<
          ListOrgPolicyViolationsRequest, ListOrgPolicyViolationsResponse, OrgPolicyViolation>
      LIST_ORG_POLICY_VIOLATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListOrgPolicyViolationsRequest,
              ListOrgPolicyViolationsResponse,
              OrgPolicyViolation>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListOrgPolicyViolationsRequest injectToken(
                ListOrgPolicyViolationsRequest payload, String token) {
              return ListOrgPolicyViolationsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListOrgPolicyViolationsRequest injectPageSize(
                ListOrgPolicyViolationsRequest payload, int pageSize) {
              return ListOrgPolicyViolationsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListOrgPolicyViolationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListOrgPolicyViolationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<OrgPolicyViolation> extractResources(
                ListOrgPolicyViolationsResponse payload) {
              return payload.getOrgPolicyViolationsList();
            }
          };

  private static final PagedListResponseFactory<
          ListOrgPolicyViolationsPreviewsRequest,
          ListOrgPolicyViolationsPreviewsResponse,
          ListOrgPolicyViolationsPreviewsPagedResponse>
      LIST_ORG_POLICY_VIOLATIONS_PREVIEWS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListOrgPolicyViolationsPreviewsRequest,
              ListOrgPolicyViolationsPreviewsResponse,
              ListOrgPolicyViolationsPreviewsPagedResponse>() {
            @Override
            public ApiFuture<ListOrgPolicyViolationsPreviewsPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        ListOrgPolicyViolationsPreviewsRequest,
                        ListOrgPolicyViolationsPreviewsResponse>
                    callable,
                ListOrgPolicyViolationsPreviewsRequest request,
                ApiCallContext context,
                ApiFuture<ListOrgPolicyViolationsPreviewsResponse> futureResponse) {
              PageContext<
                      ListOrgPolicyViolationsPreviewsRequest,
                      ListOrgPolicyViolationsPreviewsResponse,
                      OrgPolicyViolationsPreview>
                  pageContext =
                      PageContext.create(
                          callable,
                          LIST_ORG_POLICY_VIOLATIONS_PREVIEWS_PAGE_STR_DESC,
                          request,
                          context);
              return ListOrgPolicyViolationsPreviewsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListOrgPolicyViolationsRequest,
          ListOrgPolicyViolationsResponse,
          ListOrgPolicyViolationsPagedResponse>
      LIST_ORG_POLICY_VIOLATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListOrgPolicyViolationsRequest,
              ListOrgPolicyViolationsResponse,
              ListOrgPolicyViolationsPagedResponse>() {
            @Override
            public ApiFuture<ListOrgPolicyViolationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListOrgPolicyViolationsRequest, ListOrgPolicyViolationsResponse>
                    callable,
                ListOrgPolicyViolationsRequest request,
                ApiCallContext context,
                ApiFuture<ListOrgPolicyViolationsResponse> futureResponse) {
              PageContext<
                      ListOrgPolicyViolationsRequest,
                      ListOrgPolicyViolationsResponse,
                      OrgPolicyViolation>
                  pageContext =
                      PageContext.create(
                          callable, LIST_ORG_POLICY_VIOLATIONS_PAGE_STR_DESC, request, context);
              return ListOrgPolicyViolationsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listOrgPolicyViolationsPreviews. */
  public PagedCallSettings<
          ListOrgPolicyViolationsPreviewsRequest,
          ListOrgPolicyViolationsPreviewsResponse,
          ListOrgPolicyViolationsPreviewsPagedResponse>
      listOrgPolicyViolationsPreviewsSettings() {
    return listOrgPolicyViolationsPreviewsSettings;
  }

  /** Returns the object with the settings used for calls to getOrgPolicyViolationsPreview. */
  public UnaryCallSettings<GetOrgPolicyViolationsPreviewRequest, OrgPolicyViolationsPreview>
      getOrgPolicyViolationsPreviewSettings() {
    return getOrgPolicyViolationsPreviewSettings;
  }

  /** Returns the object with the settings used for calls to createOrgPolicyViolationsPreview. */
  public UnaryCallSettings<CreateOrgPolicyViolationsPreviewRequest, Operation>
      createOrgPolicyViolationsPreviewSettings() {
    return createOrgPolicyViolationsPreviewSettings;
  }

  /** Returns the object with the settings used for calls to createOrgPolicyViolationsPreview. */
  public OperationCallSettings<
          CreateOrgPolicyViolationsPreviewRequest,
          OrgPolicyViolationsPreview,
          CreateOrgPolicyViolationsPreviewOperationMetadata>
      createOrgPolicyViolationsPreviewOperationSettings() {
    return createOrgPolicyViolationsPreviewOperationSettings;
  }

  /** Returns the object with the settings used for calls to listOrgPolicyViolations. */
  public PagedCallSettings<
          ListOrgPolicyViolationsRequest,
          ListOrgPolicyViolationsResponse,
          ListOrgPolicyViolationsPagedResponse>
      listOrgPolicyViolationsSettings() {
    return listOrgPolicyViolationsSettings;
  }

  public OrgPolicyViolationsPreviewServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcOrgPolicyViolationsPreviewServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonOrgPolicyViolationsPreviewServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "policysimulator";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "policysimulator.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "policysimulator.mtls.googleapis.com:443";
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
            "gapic",
            GaxProperties.getLibraryVersion(OrgPolicyViolationsPreviewServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic",
            GaxProperties.getLibraryVersion(OrgPolicyViolationsPreviewServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return OrgPolicyViolationsPreviewServiceStubSettings
        .defaultGrpcApiClientHeaderProviderBuilder();
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

  protected OrgPolicyViolationsPreviewServiceStubSettings(Builder settingsBuilder)
      throws IOException {
    super(settingsBuilder);

    listOrgPolicyViolationsPreviewsSettings =
        settingsBuilder.listOrgPolicyViolationsPreviewsSettings().build();
    getOrgPolicyViolationsPreviewSettings =
        settingsBuilder.getOrgPolicyViolationsPreviewSettings().build();
    createOrgPolicyViolationsPreviewSettings =
        settingsBuilder.createOrgPolicyViolationsPreviewSettings().build();
    createOrgPolicyViolationsPreviewOperationSettings =
        settingsBuilder.createOrgPolicyViolationsPreviewOperationSettings().build();
    listOrgPolicyViolationsSettings = settingsBuilder.listOrgPolicyViolationsSettings().build();
  }

  /** Builder for OrgPolicyViolationsPreviewServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<OrgPolicyViolationsPreviewServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListOrgPolicyViolationsPreviewsRequest,
            ListOrgPolicyViolationsPreviewsResponse,
            ListOrgPolicyViolationsPreviewsPagedResponse>
        listOrgPolicyViolationsPreviewsSettings;
    private final UnaryCallSettings.Builder<
            GetOrgPolicyViolationsPreviewRequest, OrgPolicyViolationsPreview>
        getOrgPolicyViolationsPreviewSettings;
    private final UnaryCallSettings.Builder<CreateOrgPolicyViolationsPreviewRequest, Operation>
        createOrgPolicyViolationsPreviewSettings;
    private final OperationCallSettings.Builder<
            CreateOrgPolicyViolationsPreviewRequest,
            OrgPolicyViolationsPreview,
            CreateOrgPolicyViolationsPreviewOperationMetadata>
        createOrgPolicyViolationsPreviewOperationSettings;
    private final PagedCallSettings.Builder<
            ListOrgPolicyViolationsRequest,
            ListOrgPolicyViolationsResponse,
            ListOrgPolicyViolationsPagedResponse>
        listOrgPolicyViolationsSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      definitions.put(
          "no_retry_1_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
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
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_1_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listOrgPolicyViolationsPreviewsSettings =
          PagedCallSettings.newBuilder(LIST_ORG_POLICY_VIOLATIONS_PREVIEWS_PAGE_STR_FACT);
      getOrgPolicyViolationsPreviewSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createOrgPolicyViolationsPreviewSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createOrgPolicyViolationsPreviewOperationSettings = OperationCallSettings.newBuilder();
      listOrgPolicyViolationsSettings =
          PagedCallSettings.newBuilder(LIST_ORG_POLICY_VIOLATIONS_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listOrgPolicyViolationsPreviewsSettings,
              getOrgPolicyViolationsPreviewSettings,
              createOrgPolicyViolationsPreviewSettings,
              listOrgPolicyViolationsSettings);
      initDefaults(this);
    }

    protected Builder(OrgPolicyViolationsPreviewServiceStubSettings settings) {
      super(settings);

      listOrgPolicyViolationsPreviewsSettings =
          settings.listOrgPolicyViolationsPreviewsSettings.toBuilder();
      getOrgPolicyViolationsPreviewSettings =
          settings.getOrgPolicyViolationsPreviewSettings.toBuilder();
      createOrgPolicyViolationsPreviewSettings =
          settings.createOrgPolicyViolationsPreviewSettings.toBuilder();
      createOrgPolicyViolationsPreviewOperationSettings =
          settings.createOrgPolicyViolationsPreviewOperationSettings.toBuilder();
      listOrgPolicyViolationsSettings = settings.listOrgPolicyViolationsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listOrgPolicyViolationsPreviewsSettings,
              getOrgPolicyViolationsPreviewSettings,
              createOrgPolicyViolationsPreviewSettings,
              listOrgPolicyViolationsSettings);
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
          .listOrgPolicyViolationsPreviewsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getOrgPolicyViolationsPreviewSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createOrgPolicyViolationsPreviewSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listOrgPolicyViolationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createOrgPolicyViolationsPreviewOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateOrgPolicyViolationsPreviewRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  OrgPolicyViolationsPreview.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  CreateOrgPolicyViolationsPreviewOperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(1000L))
                      .setRetryDelayMultiplier(2.0)
                      .setMaxRetryDelayDuration(Duration.ofMillis(10000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(900000L))
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

    /** Returns the builder for the settings used for calls to listOrgPolicyViolationsPreviews. */
    public PagedCallSettings.Builder<
            ListOrgPolicyViolationsPreviewsRequest,
            ListOrgPolicyViolationsPreviewsResponse,
            ListOrgPolicyViolationsPreviewsPagedResponse>
        listOrgPolicyViolationsPreviewsSettings() {
      return listOrgPolicyViolationsPreviewsSettings;
    }

    /** Returns the builder for the settings used for calls to getOrgPolicyViolationsPreview. */
    public UnaryCallSettings.Builder<
            GetOrgPolicyViolationsPreviewRequest, OrgPolicyViolationsPreview>
        getOrgPolicyViolationsPreviewSettings() {
      return getOrgPolicyViolationsPreviewSettings;
    }

    /** Returns the builder for the settings used for calls to createOrgPolicyViolationsPreview. */
    public UnaryCallSettings.Builder<CreateOrgPolicyViolationsPreviewRequest, Operation>
        createOrgPolicyViolationsPreviewSettings() {
      return createOrgPolicyViolationsPreviewSettings;
    }

    /** Returns the builder for the settings used for calls to createOrgPolicyViolationsPreview. */
    public OperationCallSettings.Builder<
            CreateOrgPolicyViolationsPreviewRequest,
            OrgPolicyViolationsPreview,
            CreateOrgPolicyViolationsPreviewOperationMetadata>
        createOrgPolicyViolationsPreviewOperationSettings() {
      return createOrgPolicyViolationsPreviewOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listOrgPolicyViolations. */
    public PagedCallSettings.Builder<
            ListOrgPolicyViolationsRequest,
            ListOrgPolicyViolationsResponse,
            ListOrgPolicyViolationsPagedResponse>
        listOrgPolicyViolationsSettings() {
      return listOrgPolicyViolationsSettings;
    }

    @Override
    public OrgPolicyViolationsPreviewServiceStubSettings build() throws IOException {
      return new OrgPolicyViolationsPreviewServiceStubSettings(this);
    }
  }
}
