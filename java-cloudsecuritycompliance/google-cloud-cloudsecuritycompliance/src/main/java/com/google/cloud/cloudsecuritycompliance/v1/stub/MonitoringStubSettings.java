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

import static com.google.cloud.cloudsecuritycompliance.v1.MonitoringClient.ListControlComplianceSummariesPagedResponse;
import static com.google.cloud.cloudsecuritycompliance.v1.MonitoringClient.ListFindingSummariesPagedResponse;
import static com.google.cloud.cloudsecuritycompliance.v1.MonitoringClient.ListFrameworkComplianceSummariesPagedResponse;
import static com.google.cloud.cloudsecuritycompliance.v1.MonitoringClient.ListLocationsPagedResponse;

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
import com.google.cloud.cloudsecuritycompliance.v1.AggregateFrameworkComplianceReportRequest;
import com.google.cloud.cloudsecuritycompliance.v1.AggregateFrameworkComplianceReportResponse;
import com.google.cloud.cloudsecuritycompliance.v1.ControlComplianceSummary;
import com.google.cloud.cloudsecuritycompliance.v1.FetchFrameworkComplianceReportRequest;
import com.google.cloud.cloudsecuritycompliance.v1.FindingSummary;
import com.google.cloud.cloudsecuritycompliance.v1.FrameworkComplianceReport;
import com.google.cloud.cloudsecuritycompliance.v1.FrameworkComplianceSummary;
import com.google.cloud.cloudsecuritycompliance.v1.ListControlComplianceSummariesRequest;
import com.google.cloud.cloudsecuritycompliance.v1.ListControlComplianceSummariesResponse;
import com.google.cloud.cloudsecuritycompliance.v1.ListFindingSummariesRequest;
import com.google.cloud.cloudsecuritycompliance.v1.ListFindingSummariesResponse;
import com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkComplianceSummariesRequest;
import com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkComplianceSummariesResponse;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link MonitoringStub}.
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
 * of fetchFrameworkComplianceReport:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * MonitoringStubSettings.Builder monitoringSettingsBuilder = MonitoringStubSettings.newBuilder();
 * monitoringSettingsBuilder
 *     .fetchFrameworkComplianceReportSettings()
 *     .setRetrySettings(
 *         monitoringSettingsBuilder
 *             .fetchFrameworkComplianceReportSettings()
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
 * MonitoringStubSettings monitoringSettings = monitoringSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 */
@Generated("by gapic-generator-java")
public class MonitoringStubSettings extends StubSettings<MonitoringStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListFrameworkComplianceSummariesRequest,
          ListFrameworkComplianceSummariesResponse,
          ListFrameworkComplianceSummariesPagedResponse>
      listFrameworkComplianceSummariesSettings;
  private final PagedCallSettings<
          ListFindingSummariesRequest,
          ListFindingSummariesResponse,
          ListFindingSummariesPagedResponse>
      listFindingSummariesSettings;
  private final UnaryCallSettings<FetchFrameworkComplianceReportRequest, FrameworkComplianceReport>
      fetchFrameworkComplianceReportSettings;
  private final PagedCallSettings<
          ListControlComplianceSummariesRequest,
          ListControlComplianceSummariesResponse,
          ListControlComplianceSummariesPagedResponse>
      listControlComplianceSummariesSettings;
  private final UnaryCallSettings<
          AggregateFrameworkComplianceReportRequest, AggregateFrameworkComplianceReportResponse>
      aggregateFrameworkComplianceReportSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;

  private static final PagedListDescriptor<
          ListFrameworkComplianceSummariesRequest,
          ListFrameworkComplianceSummariesResponse,
          FrameworkComplianceSummary>
      LIST_FRAMEWORK_COMPLIANCE_SUMMARIES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListFrameworkComplianceSummariesRequest,
              ListFrameworkComplianceSummariesResponse,
              FrameworkComplianceSummary>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListFrameworkComplianceSummariesRequest injectToken(
                ListFrameworkComplianceSummariesRequest payload, String token) {
              return ListFrameworkComplianceSummariesRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListFrameworkComplianceSummariesRequest injectPageSize(
                ListFrameworkComplianceSummariesRequest payload, int pageSize) {
              return ListFrameworkComplianceSummariesRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListFrameworkComplianceSummariesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListFrameworkComplianceSummariesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<FrameworkComplianceSummary> extractResources(
                ListFrameworkComplianceSummariesResponse payload) {
              return payload.getFrameworkComplianceSummariesList();
            }
          };

  private static final PagedListDescriptor<
          ListFindingSummariesRequest, ListFindingSummariesResponse, FindingSummary>
      LIST_FINDING_SUMMARIES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListFindingSummariesRequest, ListFindingSummariesResponse, FindingSummary>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListFindingSummariesRequest injectToken(
                ListFindingSummariesRequest payload, String token) {
              return ListFindingSummariesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListFindingSummariesRequest injectPageSize(
                ListFindingSummariesRequest payload, int pageSize) {
              return ListFindingSummariesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListFindingSummariesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListFindingSummariesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<FindingSummary> extractResources(ListFindingSummariesResponse payload) {
              return payload.getFindingSummariesList();
            }
          };

  private static final PagedListDescriptor<
          ListControlComplianceSummariesRequest,
          ListControlComplianceSummariesResponse,
          ControlComplianceSummary>
      LIST_CONTROL_COMPLIANCE_SUMMARIES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListControlComplianceSummariesRequest,
              ListControlComplianceSummariesResponse,
              ControlComplianceSummary>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListControlComplianceSummariesRequest injectToken(
                ListControlComplianceSummariesRequest payload, String token) {
              return ListControlComplianceSummariesRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListControlComplianceSummariesRequest injectPageSize(
                ListControlComplianceSummariesRequest payload, int pageSize) {
              return ListControlComplianceSummariesRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListControlComplianceSummariesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListControlComplianceSummariesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ControlComplianceSummary> extractResources(
                ListControlComplianceSummariesResponse payload) {
              return payload.getControlComplianceSummariesList();
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
          ListFrameworkComplianceSummariesRequest,
          ListFrameworkComplianceSummariesResponse,
          ListFrameworkComplianceSummariesPagedResponse>
      LIST_FRAMEWORK_COMPLIANCE_SUMMARIES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListFrameworkComplianceSummariesRequest,
              ListFrameworkComplianceSummariesResponse,
              ListFrameworkComplianceSummariesPagedResponse>() {
            @Override
            public ApiFuture<ListFrameworkComplianceSummariesPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        ListFrameworkComplianceSummariesRequest,
                        ListFrameworkComplianceSummariesResponse>
                    callable,
                ListFrameworkComplianceSummariesRequest request,
                ApiCallContext context,
                ApiFuture<ListFrameworkComplianceSummariesResponse> futureResponse) {
              PageContext<
                      ListFrameworkComplianceSummariesRequest,
                      ListFrameworkComplianceSummariesResponse,
                      FrameworkComplianceSummary>
                  pageContext =
                      PageContext.create(
                          callable,
                          LIST_FRAMEWORK_COMPLIANCE_SUMMARIES_PAGE_STR_DESC,
                          request,
                          context);
              return ListFrameworkComplianceSummariesPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListFindingSummariesRequest,
          ListFindingSummariesResponse,
          ListFindingSummariesPagedResponse>
      LIST_FINDING_SUMMARIES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListFindingSummariesRequest,
              ListFindingSummariesResponse,
              ListFindingSummariesPagedResponse>() {
            @Override
            public ApiFuture<ListFindingSummariesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListFindingSummariesRequest, ListFindingSummariesResponse> callable,
                ListFindingSummariesRequest request,
                ApiCallContext context,
                ApiFuture<ListFindingSummariesResponse> futureResponse) {
              PageContext<ListFindingSummariesRequest, ListFindingSummariesResponse, FindingSummary>
                  pageContext =
                      PageContext.create(
                          callable, LIST_FINDING_SUMMARIES_PAGE_STR_DESC, request, context);
              return ListFindingSummariesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListControlComplianceSummariesRequest,
          ListControlComplianceSummariesResponse,
          ListControlComplianceSummariesPagedResponse>
      LIST_CONTROL_COMPLIANCE_SUMMARIES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListControlComplianceSummariesRequest,
              ListControlComplianceSummariesResponse,
              ListControlComplianceSummariesPagedResponse>() {
            @Override
            public ApiFuture<ListControlComplianceSummariesPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        ListControlComplianceSummariesRequest,
                        ListControlComplianceSummariesResponse>
                    callable,
                ListControlComplianceSummariesRequest request,
                ApiCallContext context,
                ApiFuture<ListControlComplianceSummariesResponse> futureResponse) {
              PageContext<
                      ListControlComplianceSummariesRequest,
                      ListControlComplianceSummariesResponse,
                      ControlComplianceSummary>
                  pageContext =
                      PageContext.create(
                          callable,
                          LIST_CONTROL_COMPLIANCE_SUMMARIES_PAGE_STR_DESC,
                          request,
                          context);
              return ListControlComplianceSummariesPagedResponse.createAsync(
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

  /** Returns the object with the settings used for calls to listFrameworkComplianceSummaries. */
  public PagedCallSettings<
          ListFrameworkComplianceSummariesRequest,
          ListFrameworkComplianceSummariesResponse,
          ListFrameworkComplianceSummariesPagedResponse>
      listFrameworkComplianceSummariesSettings() {
    return listFrameworkComplianceSummariesSettings;
  }

  /** Returns the object with the settings used for calls to listFindingSummaries. */
  public PagedCallSettings<
          ListFindingSummariesRequest,
          ListFindingSummariesResponse,
          ListFindingSummariesPagedResponse>
      listFindingSummariesSettings() {
    return listFindingSummariesSettings;
  }

  /** Returns the object with the settings used for calls to fetchFrameworkComplianceReport. */
  public UnaryCallSettings<FetchFrameworkComplianceReportRequest, FrameworkComplianceReport>
      fetchFrameworkComplianceReportSettings() {
    return fetchFrameworkComplianceReportSettings;
  }

  /** Returns the object with the settings used for calls to listControlComplianceSummaries. */
  public PagedCallSettings<
          ListControlComplianceSummariesRequest,
          ListControlComplianceSummariesResponse,
          ListControlComplianceSummariesPagedResponse>
      listControlComplianceSummariesSettings() {
    return listControlComplianceSummariesSettings;
  }

  /** Returns the object with the settings used for calls to aggregateFrameworkComplianceReport. */
  public UnaryCallSettings<
          AggregateFrameworkComplianceReportRequest, AggregateFrameworkComplianceReportResponse>
      aggregateFrameworkComplianceReportSettings() {
    return aggregateFrameworkComplianceReportSettings;
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

  public MonitoringStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcMonitoringStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonMonitoringStub.create(this);
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
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(MonitoringStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(MonitoringStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return MonitoringStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected MonitoringStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listFrameworkComplianceSummariesSettings =
        settingsBuilder.listFrameworkComplianceSummariesSettings().build();
    listFindingSummariesSettings = settingsBuilder.listFindingSummariesSettings().build();
    fetchFrameworkComplianceReportSettings =
        settingsBuilder.fetchFrameworkComplianceReportSettings().build();
    listControlComplianceSummariesSettings =
        settingsBuilder.listControlComplianceSummariesSettings().build();
    aggregateFrameworkComplianceReportSettings =
        settingsBuilder.aggregateFrameworkComplianceReportSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
  }

  /** Builder for MonitoringStubSettings. */
  public static class Builder extends StubSettings.Builder<MonitoringStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListFrameworkComplianceSummariesRequest,
            ListFrameworkComplianceSummariesResponse,
            ListFrameworkComplianceSummariesPagedResponse>
        listFrameworkComplianceSummariesSettings;
    private final PagedCallSettings.Builder<
            ListFindingSummariesRequest,
            ListFindingSummariesResponse,
            ListFindingSummariesPagedResponse>
        listFindingSummariesSettings;
    private final UnaryCallSettings.Builder<
            FetchFrameworkComplianceReportRequest, FrameworkComplianceReport>
        fetchFrameworkComplianceReportSettings;
    private final PagedCallSettings.Builder<
            ListControlComplianceSummariesRequest,
            ListControlComplianceSummariesResponse,
            ListControlComplianceSummariesPagedResponse>
        listControlComplianceSummariesSettings;
    private final UnaryCallSettings.Builder<
            AggregateFrameworkComplianceReportRequest, AggregateFrameworkComplianceReportResponse>
        aggregateFrameworkComplianceReportSettings;
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

      listFrameworkComplianceSummariesSettings =
          PagedCallSettings.newBuilder(LIST_FRAMEWORK_COMPLIANCE_SUMMARIES_PAGE_STR_FACT);
      listFindingSummariesSettings =
          PagedCallSettings.newBuilder(LIST_FINDING_SUMMARIES_PAGE_STR_FACT);
      fetchFrameworkComplianceReportSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listControlComplianceSummariesSettings =
          PagedCallSettings.newBuilder(LIST_CONTROL_COMPLIANCE_SUMMARIES_PAGE_STR_FACT);
      aggregateFrameworkComplianceReportSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listFrameworkComplianceSummariesSettings,
              listFindingSummariesSettings,
              fetchFrameworkComplianceReportSettings,
              listControlComplianceSummariesSettings,
              aggregateFrameworkComplianceReportSettings,
              listLocationsSettings,
              getLocationSettings);
      initDefaults(this);
    }

    protected Builder(MonitoringStubSettings settings) {
      super(settings);

      listFrameworkComplianceSummariesSettings =
          settings.listFrameworkComplianceSummariesSettings.toBuilder();
      listFindingSummariesSettings = settings.listFindingSummariesSettings.toBuilder();
      fetchFrameworkComplianceReportSettings =
          settings.fetchFrameworkComplianceReportSettings.toBuilder();
      listControlComplianceSummariesSettings =
          settings.listControlComplianceSummariesSettings.toBuilder();
      aggregateFrameworkComplianceReportSettings =
          settings.aggregateFrameworkComplianceReportSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listFrameworkComplianceSummariesSettings,
              listFindingSummariesSettings,
              fetchFrameworkComplianceReportSettings,
              listControlComplianceSummariesSettings,
              aggregateFrameworkComplianceReportSettings,
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
          .listFrameworkComplianceSummariesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listFindingSummariesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .fetchFrameworkComplianceReportSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listControlComplianceSummariesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .aggregateFrameworkComplianceReportSettings()
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

    /** Returns the builder for the settings used for calls to listFrameworkComplianceSummaries. */
    public PagedCallSettings.Builder<
            ListFrameworkComplianceSummariesRequest,
            ListFrameworkComplianceSummariesResponse,
            ListFrameworkComplianceSummariesPagedResponse>
        listFrameworkComplianceSummariesSettings() {
      return listFrameworkComplianceSummariesSettings;
    }

    /** Returns the builder for the settings used for calls to listFindingSummaries. */
    public PagedCallSettings.Builder<
            ListFindingSummariesRequest,
            ListFindingSummariesResponse,
            ListFindingSummariesPagedResponse>
        listFindingSummariesSettings() {
      return listFindingSummariesSettings;
    }

    /** Returns the builder for the settings used for calls to fetchFrameworkComplianceReport. */
    public UnaryCallSettings.Builder<
            FetchFrameworkComplianceReportRequest, FrameworkComplianceReport>
        fetchFrameworkComplianceReportSettings() {
      return fetchFrameworkComplianceReportSettings;
    }

    /** Returns the builder for the settings used for calls to listControlComplianceSummaries. */
    public PagedCallSettings.Builder<
            ListControlComplianceSummariesRequest,
            ListControlComplianceSummariesResponse,
            ListControlComplianceSummariesPagedResponse>
        listControlComplianceSummariesSettings() {
      return listControlComplianceSummariesSettings;
    }

    /**
     * Returns the builder for the settings used for calls to aggregateFrameworkComplianceReport.
     */
    public UnaryCallSettings.Builder<
            AggregateFrameworkComplianceReportRequest, AggregateFrameworkComplianceReportResponse>
        aggregateFrameworkComplianceReportSettings() {
      return aggregateFrameworkComplianceReportSettings;
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
    public MonitoringStubSettings build() throws IOException {
      return new MonitoringStubSettings(this);
    }
  }
}
