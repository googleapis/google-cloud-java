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

package com.google.cloud.cloudsecuritycompliance.v1.stub;

import static com.google.cloud.cloudsecuritycompliance.v1.AuditClient.ListFrameworkAuditsPagedResponse;
import static com.google.cloud.cloudsecuritycompliance.v1.AuditClient.ListLocationsPagedResponse;

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
import com.google.cloud.cloudsecuritycompliance.v1.CreateFrameworkAuditRequest;
import com.google.cloud.cloudsecuritycompliance.v1.FrameworkAudit;
import com.google.cloud.cloudsecuritycompliance.v1.GenerateFrameworkAuditScopeReportRequest;
import com.google.cloud.cloudsecuritycompliance.v1.GenerateFrameworkAuditScopeReportResponse;
import com.google.cloud.cloudsecuritycompliance.v1.GetFrameworkAuditRequest;
import com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkAuditsRequest;
import com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkAuditsResponse;
import com.google.cloud.cloudsecuritycompliance.v1.OperationMetadata;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
 * Settings class to configure an instance of {@link AuditStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (cloudsecuritycompliance.googleapis.com) and default port (443)
 *       are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of generateFrameworkAuditScopeReport:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AuditStubSettings.Builder auditSettingsBuilder = AuditStubSettings.newBuilder();
 * auditSettingsBuilder
 *     .generateFrameworkAuditScopeReportSettings()
 *     .setRetrySettings(
 *         auditSettingsBuilder
 *             .generateFrameworkAuditScopeReportSettings()
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
 * AuditStubSettings auditSettings = auditSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createFrameworkAudit:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AuditStubSettings.Builder auditSettingsBuilder = AuditStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * auditSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class AuditStubSettings extends StubSettings<AuditStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<
          GenerateFrameworkAuditScopeReportRequest, GenerateFrameworkAuditScopeReportResponse>
      generateFrameworkAuditScopeReportSettings;
  private final UnaryCallSettings<CreateFrameworkAuditRequest, Operation>
      createFrameworkAuditSettings;
  private final OperationCallSettings<
          CreateFrameworkAuditRequest, FrameworkAudit, OperationMetadata>
      createFrameworkAuditOperationSettings;
  private final PagedCallSettings<
          ListFrameworkAuditsRequest, ListFrameworkAuditsResponse, ListFrameworkAuditsPagedResponse>
      listFrameworkAuditsSettings;
  private final UnaryCallSettings<GetFrameworkAuditRequest, FrameworkAudit>
      getFrameworkAuditSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;

  private static final PagedListDescriptor<
          ListFrameworkAuditsRequest, ListFrameworkAuditsResponse, FrameworkAudit>
      LIST_FRAMEWORK_AUDITS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListFrameworkAuditsRequest, ListFrameworkAuditsResponse, FrameworkAudit>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListFrameworkAuditsRequest injectToken(
                ListFrameworkAuditsRequest payload, String token) {
              return ListFrameworkAuditsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListFrameworkAuditsRequest injectPageSize(
                ListFrameworkAuditsRequest payload, int pageSize) {
              return ListFrameworkAuditsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListFrameworkAuditsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListFrameworkAuditsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<FrameworkAudit> extractResources(ListFrameworkAuditsResponse payload) {
              return payload.getFrameworkAuditsList();
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
          ListFrameworkAuditsRequest, ListFrameworkAuditsResponse, ListFrameworkAuditsPagedResponse>
      LIST_FRAMEWORK_AUDITS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListFrameworkAuditsRequest,
              ListFrameworkAuditsResponse,
              ListFrameworkAuditsPagedResponse>() {
            @Override
            public ApiFuture<ListFrameworkAuditsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListFrameworkAuditsRequest, ListFrameworkAuditsResponse> callable,
                ListFrameworkAuditsRequest request,
                ApiCallContext context,
                ApiFuture<ListFrameworkAuditsResponse> futureResponse) {
              PageContext<ListFrameworkAuditsRequest, ListFrameworkAuditsResponse, FrameworkAudit>
                  pageContext =
                      PageContext.create(
                          callable, LIST_FRAMEWORK_AUDITS_PAGE_STR_DESC, request, context);
              return ListFrameworkAuditsPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to generateFrameworkAuditScopeReport. */
  public UnaryCallSettings<
          GenerateFrameworkAuditScopeReportRequest, GenerateFrameworkAuditScopeReportResponse>
      generateFrameworkAuditScopeReportSettings() {
    return generateFrameworkAuditScopeReportSettings;
  }

  /** Returns the object with the settings used for calls to createFrameworkAudit. */
  public UnaryCallSettings<CreateFrameworkAuditRequest, Operation> createFrameworkAuditSettings() {
    return createFrameworkAuditSettings;
  }

  /** Returns the object with the settings used for calls to createFrameworkAudit. */
  public OperationCallSettings<CreateFrameworkAuditRequest, FrameworkAudit, OperationMetadata>
      createFrameworkAuditOperationSettings() {
    return createFrameworkAuditOperationSettings;
  }

  /** Returns the object with the settings used for calls to listFrameworkAudits. */
  public PagedCallSettings<
          ListFrameworkAuditsRequest, ListFrameworkAuditsResponse, ListFrameworkAuditsPagedResponse>
      listFrameworkAuditsSettings() {
    return listFrameworkAuditsSettings;
  }

  /** Returns the object with the settings used for calls to getFrameworkAudit. */
  public UnaryCallSettings<GetFrameworkAuditRequest, FrameworkAudit> getFrameworkAuditSettings() {
    return getFrameworkAuditSettings;
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

  public AuditStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcAuditStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonAuditStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "cloudsecuritycompliance";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "cloudsecuritycompliance.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "cloudsecuritycompliance.mtls.googleapis.com:443";
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
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(AuditStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(AuditStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return AuditStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected AuditStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    generateFrameworkAuditScopeReportSettings =
        settingsBuilder.generateFrameworkAuditScopeReportSettings().build();
    createFrameworkAuditSettings = settingsBuilder.createFrameworkAuditSettings().build();
    createFrameworkAuditOperationSettings =
        settingsBuilder.createFrameworkAuditOperationSettings().build();
    listFrameworkAuditsSettings = settingsBuilder.listFrameworkAuditsSettings().build();
    getFrameworkAuditSettings = settingsBuilder.getFrameworkAuditSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
  }

  /** Builder for AuditStubSettings. */
  public static class Builder extends StubSettings.Builder<AuditStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<
            GenerateFrameworkAuditScopeReportRequest, GenerateFrameworkAuditScopeReportResponse>
        generateFrameworkAuditScopeReportSettings;
    private final UnaryCallSettings.Builder<CreateFrameworkAuditRequest, Operation>
        createFrameworkAuditSettings;
    private final OperationCallSettings.Builder<
            CreateFrameworkAuditRequest, FrameworkAudit, OperationMetadata>
        createFrameworkAuditOperationSettings;
    private final PagedCallSettings.Builder<
            ListFrameworkAuditsRequest,
            ListFrameworkAuditsResponse,
            ListFrameworkAuditsPagedResponse>
        listFrameworkAuditsSettings;
    private final UnaryCallSettings.Builder<GetFrameworkAuditRequest, FrameworkAudit>
        getFrameworkAuditSettings;
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

      generateFrameworkAuditScopeReportSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createFrameworkAuditSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createFrameworkAuditOperationSettings = OperationCallSettings.newBuilder();
      listFrameworkAuditsSettings =
          PagedCallSettings.newBuilder(LIST_FRAMEWORK_AUDITS_PAGE_STR_FACT);
      getFrameworkAuditSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              generateFrameworkAuditScopeReportSettings,
              createFrameworkAuditSettings,
              listFrameworkAuditsSettings,
              getFrameworkAuditSettings,
              listLocationsSettings,
              getLocationSettings);
      initDefaults(this);
    }

    protected Builder(AuditStubSettings settings) {
      super(settings);

      generateFrameworkAuditScopeReportSettings =
          settings.generateFrameworkAuditScopeReportSettings.toBuilder();
      createFrameworkAuditSettings = settings.createFrameworkAuditSettings.toBuilder();
      createFrameworkAuditOperationSettings =
          settings.createFrameworkAuditOperationSettings.toBuilder();
      listFrameworkAuditsSettings = settings.listFrameworkAuditsSettings.toBuilder();
      getFrameworkAuditSettings = settings.getFrameworkAuditSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              generateFrameworkAuditScopeReportSettings,
              createFrameworkAuditSettings,
              listFrameworkAuditsSettings,
              getFrameworkAuditSettings,
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
          .generateFrameworkAuditScopeReportSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .createFrameworkAuditSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listFrameworkAuditsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getFrameworkAuditSettings()
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

      builder
          .createFrameworkAuditOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateFrameworkAuditRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(FrameworkAudit.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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

    /** Returns the builder for the settings used for calls to generateFrameworkAuditScopeReport. */
    public UnaryCallSettings.Builder<
            GenerateFrameworkAuditScopeReportRequest, GenerateFrameworkAuditScopeReportResponse>
        generateFrameworkAuditScopeReportSettings() {
      return generateFrameworkAuditScopeReportSettings;
    }

    /** Returns the builder for the settings used for calls to createFrameworkAudit. */
    public UnaryCallSettings.Builder<CreateFrameworkAuditRequest, Operation>
        createFrameworkAuditSettings() {
      return createFrameworkAuditSettings;
    }

    /** Returns the builder for the settings used for calls to createFrameworkAudit. */
    public OperationCallSettings.Builder<
            CreateFrameworkAuditRequest, FrameworkAudit, OperationMetadata>
        createFrameworkAuditOperationSettings() {
      return createFrameworkAuditOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listFrameworkAudits. */
    public PagedCallSettings.Builder<
            ListFrameworkAuditsRequest,
            ListFrameworkAuditsResponse,
            ListFrameworkAuditsPagedResponse>
        listFrameworkAuditsSettings() {
      return listFrameworkAuditsSettings;
    }

    /** Returns the builder for the settings used for calls to getFrameworkAudit. */
    public UnaryCallSettings.Builder<GetFrameworkAuditRequest, FrameworkAudit>
        getFrameworkAuditSettings() {
      return getFrameworkAuditSettings;
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
    public AuditStubSettings build() throws IOException {
      return new AuditStubSettings(this);
    }
  }
}
