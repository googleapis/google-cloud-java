/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.auditmanager.v1.stub;

import static com.google.cloud.auditmanager.v1.AuditManagerClient.ListAuditReportsPagedResponse;
import static com.google.cloud.auditmanager.v1.AuditManagerClient.ListControlsPagedResponse;
import static com.google.cloud.auditmanager.v1.AuditManagerClient.ListLocationsPagedResponse;
import static com.google.cloud.auditmanager.v1.AuditManagerClient.ListResourceEnrollmentStatusesPagedResponse;

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
import com.google.cloud.auditmanager.v1.AuditReport;
import com.google.cloud.auditmanager.v1.AuditScopeReport;
import com.google.cloud.auditmanager.v1.Control;
import com.google.cloud.auditmanager.v1.EnrollResourceRequest;
import com.google.cloud.auditmanager.v1.Enrollment;
import com.google.cloud.auditmanager.v1.GenerateAuditReportRequest;
import com.google.cloud.auditmanager.v1.GenerateAuditScopeReportRequest;
import com.google.cloud.auditmanager.v1.GetAuditReportRequest;
import com.google.cloud.auditmanager.v1.GetResourceEnrollmentStatusRequest;
import com.google.cloud.auditmanager.v1.ListAuditReportsRequest;
import com.google.cloud.auditmanager.v1.ListAuditReportsResponse;
import com.google.cloud.auditmanager.v1.ListControlsRequest;
import com.google.cloud.auditmanager.v1.ListControlsResponse;
import com.google.cloud.auditmanager.v1.ListResourceEnrollmentStatusesRequest;
import com.google.cloud.auditmanager.v1.ListResourceEnrollmentStatusesResponse;
import com.google.cloud.auditmanager.v1.OperationMetadata;
import com.google.cloud.auditmanager.v1.ResourceEnrollmentStatus;
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
 * Settings class to configure an instance of {@link AuditManagerStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (auditmanager.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of enrollResource:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AuditManagerStubSettings.Builder auditManagerSettingsBuilder =
 *     AuditManagerStubSettings.newBuilder();
 * auditManagerSettingsBuilder
 *     .enrollResourceSettings()
 *     .setRetrySettings(
 *         auditManagerSettingsBuilder
 *             .enrollResourceSettings()
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
 * AuditManagerStubSettings auditManagerSettings = auditManagerSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for generateAuditReport:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AuditManagerStubSettings.Builder auditManagerSettingsBuilder =
 *     AuditManagerStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * auditManagerSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class AuditManagerStubSettings extends StubSettings<AuditManagerStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<EnrollResourceRequest, Enrollment> enrollResourceSettings;
  private final UnaryCallSettings<GenerateAuditScopeReportRequest, AuditScopeReport>
      generateAuditScopeReportSettings;
  private final UnaryCallSettings<GenerateAuditReportRequest, Operation>
      generateAuditReportSettings;
  private final OperationCallSettings<GenerateAuditReportRequest, AuditReport, OperationMetadata>
      generateAuditReportOperationSettings;
  private final PagedCallSettings<
          ListAuditReportsRequest, ListAuditReportsResponse, ListAuditReportsPagedResponse>
      listAuditReportsSettings;
  private final UnaryCallSettings<GetAuditReportRequest, AuditReport> getAuditReportSettings;
  private final UnaryCallSettings<GetResourceEnrollmentStatusRequest, ResourceEnrollmentStatus>
      getResourceEnrollmentStatusSettings;
  private final PagedCallSettings<
          ListResourceEnrollmentStatusesRequest,
          ListResourceEnrollmentStatusesResponse,
          ListResourceEnrollmentStatusesPagedResponse>
      listResourceEnrollmentStatusesSettings;
  private final PagedCallSettings<
          ListControlsRequest, ListControlsResponse, ListControlsPagedResponse>
      listControlsSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;

  private static final PagedListDescriptor<
          ListAuditReportsRequest, ListAuditReportsResponse, AuditReport>
      LIST_AUDIT_REPORTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListAuditReportsRequest, ListAuditReportsResponse, AuditReport>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAuditReportsRequest injectToken(
                ListAuditReportsRequest payload, String token) {
              return ListAuditReportsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAuditReportsRequest injectPageSize(
                ListAuditReportsRequest payload, int pageSize) {
              return ListAuditReportsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListAuditReportsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAuditReportsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<AuditReport> extractResources(ListAuditReportsResponse payload) {
              return payload.getAuditReportsList();
            }
          };

  private static final PagedListDescriptor<
          ListResourceEnrollmentStatusesRequest,
          ListResourceEnrollmentStatusesResponse,
          ResourceEnrollmentStatus>
      LIST_RESOURCE_ENROLLMENT_STATUSES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListResourceEnrollmentStatusesRequest,
              ListResourceEnrollmentStatusesResponse,
              ResourceEnrollmentStatus>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListResourceEnrollmentStatusesRequest injectToken(
                ListResourceEnrollmentStatusesRequest payload, String token) {
              return ListResourceEnrollmentStatusesRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListResourceEnrollmentStatusesRequest injectPageSize(
                ListResourceEnrollmentStatusesRequest payload, int pageSize) {
              return ListResourceEnrollmentStatusesRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListResourceEnrollmentStatusesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListResourceEnrollmentStatusesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ResourceEnrollmentStatus> extractResources(
                ListResourceEnrollmentStatusesResponse payload) {
              return payload.getResourceEnrollmentStatusesList();
            }
          };

  private static final PagedListDescriptor<ListControlsRequest, ListControlsResponse, Control>
      LIST_CONTROLS_PAGE_STR_DESC =
          new PagedListDescriptor<ListControlsRequest, ListControlsResponse, Control>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListControlsRequest injectToken(ListControlsRequest payload, String token) {
              return ListControlsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListControlsRequest injectPageSize(ListControlsRequest payload, int pageSize) {
              return ListControlsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListControlsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListControlsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Control> extractResources(ListControlsResponse payload) {
              return payload.getControlsList();
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
          ListAuditReportsRequest, ListAuditReportsResponse, ListAuditReportsPagedResponse>
      LIST_AUDIT_REPORTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAuditReportsRequest, ListAuditReportsResponse, ListAuditReportsPagedResponse>() {
            @Override
            public ApiFuture<ListAuditReportsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAuditReportsRequest, ListAuditReportsResponse> callable,
                ListAuditReportsRequest request,
                ApiCallContext context,
                ApiFuture<ListAuditReportsResponse> futureResponse) {
              PageContext<ListAuditReportsRequest, ListAuditReportsResponse, AuditReport>
                  pageContext =
                      PageContext.create(
                          callable, LIST_AUDIT_REPORTS_PAGE_STR_DESC, request, context);
              return ListAuditReportsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListResourceEnrollmentStatusesRequest,
          ListResourceEnrollmentStatusesResponse,
          ListResourceEnrollmentStatusesPagedResponse>
      LIST_RESOURCE_ENROLLMENT_STATUSES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListResourceEnrollmentStatusesRequest,
              ListResourceEnrollmentStatusesResponse,
              ListResourceEnrollmentStatusesPagedResponse>() {
            @Override
            public ApiFuture<ListResourceEnrollmentStatusesPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        ListResourceEnrollmentStatusesRequest,
                        ListResourceEnrollmentStatusesResponse>
                    callable,
                ListResourceEnrollmentStatusesRequest request,
                ApiCallContext context,
                ApiFuture<ListResourceEnrollmentStatusesResponse> futureResponse) {
              PageContext<
                      ListResourceEnrollmentStatusesRequest,
                      ListResourceEnrollmentStatusesResponse,
                      ResourceEnrollmentStatus>
                  pageContext =
                      PageContext.create(
                          callable,
                          LIST_RESOURCE_ENROLLMENT_STATUSES_PAGE_STR_DESC,
                          request,
                          context);
              return ListResourceEnrollmentStatusesPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListControlsRequest, ListControlsResponse, ListControlsPagedResponse>
      LIST_CONTROLS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListControlsRequest, ListControlsResponse, ListControlsPagedResponse>() {
            @Override
            public ApiFuture<ListControlsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListControlsRequest, ListControlsResponse> callable,
                ListControlsRequest request,
                ApiCallContext context,
                ApiFuture<ListControlsResponse> futureResponse) {
              PageContext<ListControlsRequest, ListControlsResponse, Control> pageContext =
                  PageContext.create(callable, LIST_CONTROLS_PAGE_STR_DESC, request, context);
              return ListControlsPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to enrollResource. */
  public UnaryCallSettings<EnrollResourceRequest, Enrollment> enrollResourceSettings() {
    return enrollResourceSettings;
  }

  /** Returns the object with the settings used for calls to generateAuditScopeReport. */
  public UnaryCallSettings<GenerateAuditScopeReportRequest, AuditScopeReport>
      generateAuditScopeReportSettings() {
    return generateAuditScopeReportSettings;
  }

  /** Returns the object with the settings used for calls to generateAuditReport. */
  public UnaryCallSettings<GenerateAuditReportRequest, Operation> generateAuditReportSettings() {
    return generateAuditReportSettings;
  }

  /** Returns the object with the settings used for calls to generateAuditReport. */
  public OperationCallSettings<GenerateAuditReportRequest, AuditReport, OperationMetadata>
      generateAuditReportOperationSettings() {
    return generateAuditReportOperationSettings;
  }

  /** Returns the object with the settings used for calls to listAuditReports. */
  public PagedCallSettings<
          ListAuditReportsRequest, ListAuditReportsResponse, ListAuditReportsPagedResponse>
      listAuditReportsSettings() {
    return listAuditReportsSettings;
  }

  /** Returns the object with the settings used for calls to getAuditReport. */
  public UnaryCallSettings<GetAuditReportRequest, AuditReport> getAuditReportSettings() {
    return getAuditReportSettings;
  }

  /** Returns the object with the settings used for calls to getResourceEnrollmentStatus. */
  public UnaryCallSettings<GetResourceEnrollmentStatusRequest, ResourceEnrollmentStatus>
      getResourceEnrollmentStatusSettings() {
    return getResourceEnrollmentStatusSettings;
  }

  /** Returns the object with the settings used for calls to listResourceEnrollmentStatuses. */
  public PagedCallSettings<
          ListResourceEnrollmentStatusesRequest,
          ListResourceEnrollmentStatusesResponse,
          ListResourceEnrollmentStatusesPagedResponse>
      listResourceEnrollmentStatusesSettings() {
    return listResourceEnrollmentStatusesSettings;
  }

  /** Returns the object with the settings used for calls to listControls. */
  public PagedCallSettings<ListControlsRequest, ListControlsResponse, ListControlsPagedResponse>
      listControlsSettings() {
    return listControlsSettings;
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

  public AuditManagerStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcAuditManagerStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonAuditManagerStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "auditmanager";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "auditmanager.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "auditmanager.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(AuditManagerStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(AuditManagerStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return AuditManagerStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected AuditManagerStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    enrollResourceSettings = settingsBuilder.enrollResourceSettings().build();
    generateAuditScopeReportSettings = settingsBuilder.generateAuditScopeReportSettings().build();
    generateAuditReportSettings = settingsBuilder.generateAuditReportSettings().build();
    generateAuditReportOperationSettings =
        settingsBuilder.generateAuditReportOperationSettings().build();
    listAuditReportsSettings = settingsBuilder.listAuditReportsSettings().build();
    getAuditReportSettings = settingsBuilder.getAuditReportSettings().build();
    getResourceEnrollmentStatusSettings =
        settingsBuilder.getResourceEnrollmentStatusSettings().build();
    listResourceEnrollmentStatusesSettings =
        settingsBuilder.listResourceEnrollmentStatusesSettings().build();
    listControlsSettings = settingsBuilder.listControlsSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
  }

  /** Builder for AuditManagerStubSettings. */
  public static class Builder extends StubSettings.Builder<AuditManagerStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<EnrollResourceRequest, Enrollment>
        enrollResourceSettings;
    private final UnaryCallSettings.Builder<GenerateAuditScopeReportRequest, AuditScopeReport>
        generateAuditScopeReportSettings;
    private final UnaryCallSettings.Builder<GenerateAuditReportRequest, Operation>
        generateAuditReportSettings;
    private final OperationCallSettings.Builder<
            GenerateAuditReportRequest, AuditReport, OperationMetadata>
        generateAuditReportOperationSettings;
    private final PagedCallSettings.Builder<
            ListAuditReportsRequest, ListAuditReportsResponse, ListAuditReportsPagedResponse>
        listAuditReportsSettings;
    private final UnaryCallSettings.Builder<GetAuditReportRequest, AuditReport>
        getAuditReportSettings;
    private final UnaryCallSettings.Builder<
            GetResourceEnrollmentStatusRequest, ResourceEnrollmentStatus>
        getResourceEnrollmentStatusSettings;
    private final PagedCallSettings.Builder<
            ListResourceEnrollmentStatusesRequest,
            ListResourceEnrollmentStatusesResponse,
            ListResourceEnrollmentStatusesPagedResponse>
        listResourceEnrollmentStatusesSettings;
    private final PagedCallSettings.Builder<
            ListControlsRequest, ListControlsResponse, ListControlsPagedResponse>
        listControlsSettings;
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
              .setInitialRetryDelayDuration(Duration.ofMillis(100L))
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

      enrollResourceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      generateAuditScopeReportSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      generateAuditReportSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      generateAuditReportOperationSettings = OperationCallSettings.newBuilder();
      listAuditReportsSettings = PagedCallSettings.newBuilder(LIST_AUDIT_REPORTS_PAGE_STR_FACT);
      getAuditReportSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getResourceEnrollmentStatusSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listResourceEnrollmentStatusesSettings =
          PagedCallSettings.newBuilder(LIST_RESOURCE_ENROLLMENT_STATUSES_PAGE_STR_FACT);
      listControlsSettings = PagedCallSettings.newBuilder(LIST_CONTROLS_PAGE_STR_FACT);
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              enrollResourceSettings,
              generateAuditScopeReportSettings,
              generateAuditReportSettings,
              listAuditReportsSettings,
              getAuditReportSettings,
              getResourceEnrollmentStatusSettings,
              listResourceEnrollmentStatusesSettings,
              listControlsSettings,
              listLocationsSettings,
              getLocationSettings);
      initDefaults(this);
    }

    protected Builder(AuditManagerStubSettings settings) {
      super(settings);

      enrollResourceSettings = settings.enrollResourceSettings.toBuilder();
      generateAuditScopeReportSettings = settings.generateAuditScopeReportSettings.toBuilder();
      generateAuditReportSettings = settings.generateAuditReportSettings.toBuilder();
      generateAuditReportOperationSettings =
          settings.generateAuditReportOperationSettings.toBuilder();
      listAuditReportsSettings = settings.listAuditReportsSettings.toBuilder();
      getAuditReportSettings = settings.getAuditReportSettings.toBuilder();
      getResourceEnrollmentStatusSettings =
          settings.getResourceEnrollmentStatusSettings.toBuilder();
      listResourceEnrollmentStatusesSettings =
          settings.listResourceEnrollmentStatusesSettings.toBuilder();
      listControlsSettings = settings.listControlsSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              enrollResourceSettings,
              generateAuditScopeReportSettings,
              generateAuditReportSettings,
              listAuditReportsSettings,
              getAuditReportSettings,
              getResourceEnrollmentStatusSettings,
              listResourceEnrollmentStatusesSettings,
              listControlsSettings,
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
          .enrollResourceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .generateAuditScopeReportSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .generateAuditReportSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listAuditReportsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getAuditReportSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getResourceEnrollmentStatusSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listResourceEnrollmentStatusesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listControlsSettings()
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
          .generateAuditReportOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<GenerateAuditReportRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(AuditReport.class))
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

    /** Returns the builder for the settings used for calls to enrollResource. */
    public UnaryCallSettings.Builder<EnrollResourceRequest, Enrollment> enrollResourceSettings() {
      return enrollResourceSettings;
    }

    /** Returns the builder for the settings used for calls to generateAuditScopeReport. */
    public UnaryCallSettings.Builder<GenerateAuditScopeReportRequest, AuditScopeReport>
        generateAuditScopeReportSettings() {
      return generateAuditScopeReportSettings;
    }

    /** Returns the builder for the settings used for calls to generateAuditReport. */
    public UnaryCallSettings.Builder<GenerateAuditReportRequest, Operation>
        generateAuditReportSettings() {
      return generateAuditReportSettings;
    }

    /** Returns the builder for the settings used for calls to generateAuditReport. */
    public OperationCallSettings.Builder<GenerateAuditReportRequest, AuditReport, OperationMetadata>
        generateAuditReportOperationSettings() {
      return generateAuditReportOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listAuditReports. */
    public PagedCallSettings.Builder<
            ListAuditReportsRequest, ListAuditReportsResponse, ListAuditReportsPagedResponse>
        listAuditReportsSettings() {
      return listAuditReportsSettings;
    }

    /** Returns the builder for the settings used for calls to getAuditReport. */
    public UnaryCallSettings.Builder<GetAuditReportRequest, AuditReport> getAuditReportSettings() {
      return getAuditReportSettings;
    }

    /** Returns the builder for the settings used for calls to getResourceEnrollmentStatus. */
    public UnaryCallSettings.Builder<GetResourceEnrollmentStatusRequest, ResourceEnrollmentStatus>
        getResourceEnrollmentStatusSettings() {
      return getResourceEnrollmentStatusSettings;
    }

    /** Returns the builder for the settings used for calls to listResourceEnrollmentStatuses. */
    public PagedCallSettings.Builder<
            ListResourceEnrollmentStatusesRequest,
            ListResourceEnrollmentStatusesResponse,
            ListResourceEnrollmentStatusesPagedResponse>
        listResourceEnrollmentStatusesSettings() {
      return listResourceEnrollmentStatusesSettings;
    }

    /** Returns the builder for the settings used for calls to listControls. */
    public PagedCallSettings.Builder<
            ListControlsRequest, ListControlsResponse, ListControlsPagedResponse>
        listControlsSettings() {
      return listControlsSettings;
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
    public AuditManagerStubSettings build() throws IOException {
      return new AuditManagerStubSettings(this);
    }
  }
}
