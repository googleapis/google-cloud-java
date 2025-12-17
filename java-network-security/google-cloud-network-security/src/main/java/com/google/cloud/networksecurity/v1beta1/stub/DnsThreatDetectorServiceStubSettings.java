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

package com.google.cloud.networksecurity.v1beta1.stub;

import static com.google.cloud.networksecurity.v1beta1.DnsThreatDetectorServiceClient.ListDnsThreatDetectorsPagedResponse;
import static com.google.cloud.networksecurity.v1beta1.DnsThreatDetectorServiceClient.ListLocationsPagedResponse;

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
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.networksecurity.v1beta1.CreateDnsThreatDetectorRequest;
import com.google.cloud.networksecurity.v1beta1.DeleteDnsThreatDetectorRequest;
import com.google.cloud.networksecurity.v1beta1.DnsThreatDetector;
import com.google.cloud.networksecurity.v1beta1.GetDnsThreatDetectorRequest;
import com.google.cloud.networksecurity.v1beta1.ListDnsThreatDetectorsRequest;
import com.google.cloud.networksecurity.v1beta1.ListDnsThreatDetectorsResponse;
import com.google.cloud.networksecurity.v1beta1.UpdateDnsThreatDetectorRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link DnsThreatDetectorServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (networksecurity.googleapis.com) and default port (443) are
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
 * of getDnsThreatDetector:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DnsThreatDetectorServiceStubSettings.Builder dnsThreatDetectorServiceSettingsBuilder =
 *     DnsThreatDetectorServiceStubSettings.newBuilder();
 * dnsThreatDetectorServiceSettingsBuilder
 *     .getDnsThreatDetectorSettings()
 *     .setRetrySettings(
 *         dnsThreatDetectorServiceSettingsBuilder
 *             .getDnsThreatDetectorSettings()
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
 * DnsThreatDetectorServiceStubSettings dnsThreatDetectorServiceSettings =
 *     dnsThreatDetectorServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class DnsThreatDetectorServiceStubSettings
    extends StubSettings<DnsThreatDetectorServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListDnsThreatDetectorsRequest,
          ListDnsThreatDetectorsResponse,
          ListDnsThreatDetectorsPagedResponse>
      listDnsThreatDetectorsSettings;
  private final UnaryCallSettings<GetDnsThreatDetectorRequest, DnsThreatDetector>
      getDnsThreatDetectorSettings;
  private final UnaryCallSettings<CreateDnsThreatDetectorRequest, DnsThreatDetector>
      createDnsThreatDetectorSettings;
  private final UnaryCallSettings<UpdateDnsThreatDetectorRequest, DnsThreatDetector>
      updateDnsThreatDetectorSettings;
  private final UnaryCallSettings<DeleteDnsThreatDetectorRequest, Empty>
      deleteDnsThreatDetectorSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<
          ListDnsThreatDetectorsRequest, ListDnsThreatDetectorsResponse, DnsThreatDetector>
      LIST_DNS_THREAT_DETECTORS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListDnsThreatDetectorsRequest, ListDnsThreatDetectorsResponse, DnsThreatDetector>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDnsThreatDetectorsRequest injectToken(
                ListDnsThreatDetectorsRequest payload, String token) {
              return ListDnsThreatDetectorsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListDnsThreatDetectorsRequest injectPageSize(
                ListDnsThreatDetectorsRequest payload, int pageSize) {
              return ListDnsThreatDetectorsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListDnsThreatDetectorsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDnsThreatDetectorsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<DnsThreatDetector> extractResources(
                ListDnsThreatDetectorsResponse payload) {
              return payload.getDnsThreatDetectorsList();
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
          ListDnsThreatDetectorsRequest,
          ListDnsThreatDetectorsResponse,
          ListDnsThreatDetectorsPagedResponse>
      LIST_DNS_THREAT_DETECTORS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDnsThreatDetectorsRequest,
              ListDnsThreatDetectorsResponse,
              ListDnsThreatDetectorsPagedResponse>() {
            @Override
            public ApiFuture<ListDnsThreatDetectorsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDnsThreatDetectorsRequest, ListDnsThreatDetectorsResponse>
                    callable,
                ListDnsThreatDetectorsRequest request,
                ApiCallContext context,
                ApiFuture<ListDnsThreatDetectorsResponse> futureResponse) {
              PageContext<
                      ListDnsThreatDetectorsRequest,
                      ListDnsThreatDetectorsResponse,
                      DnsThreatDetector>
                  pageContext =
                      PageContext.create(
                          callable, LIST_DNS_THREAT_DETECTORS_PAGE_STR_DESC, request, context);
              return ListDnsThreatDetectorsPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to listDnsThreatDetectors. */
  public PagedCallSettings<
          ListDnsThreatDetectorsRequest,
          ListDnsThreatDetectorsResponse,
          ListDnsThreatDetectorsPagedResponse>
      listDnsThreatDetectorsSettings() {
    return listDnsThreatDetectorsSettings;
  }

  /** Returns the object with the settings used for calls to getDnsThreatDetector. */
  public UnaryCallSettings<GetDnsThreatDetectorRequest, DnsThreatDetector>
      getDnsThreatDetectorSettings() {
    return getDnsThreatDetectorSettings;
  }

  /** Returns the object with the settings used for calls to createDnsThreatDetector. */
  public UnaryCallSettings<CreateDnsThreatDetectorRequest, DnsThreatDetector>
      createDnsThreatDetectorSettings() {
    return createDnsThreatDetectorSettings;
  }

  /** Returns the object with the settings used for calls to updateDnsThreatDetector. */
  public UnaryCallSettings<UpdateDnsThreatDetectorRequest, DnsThreatDetector>
      updateDnsThreatDetectorSettings() {
    return updateDnsThreatDetectorSettings;
  }

  /** Returns the object with the settings used for calls to deleteDnsThreatDetector. */
  public UnaryCallSettings<DeleteDnsThreatDetectorRequest, Empty>
      deleteDnsThreatDetectorSettings() {
    return deleteDnsThreatDetectorSettings;
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

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return setIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return getIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return testIamPermissionsSettings;
  }

  public DnsThreatDetectorServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcDnsThreatDetectorServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonDnsThreatDetectorServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "networksecurity";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "networksecurity.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "networksecurity.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(DnsThreatDetectorServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(DnsThreatDetectorServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DnsThreatDetectorServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected DnsThreatDetectorServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listDnsThreatDetectorsSettings = settingsBuilder.listDnsThreatDetectorsSettings().build();
    getDnsThreatDetectorSettings = settingsBuilder.getDnsThreatDetectorSettings().build();
    createDnsThreatDetectorSettings = settingsBuilder.createDnsThreatDetectorSettings().build();
    updateDnsThreatDetectorSettings = settingsBuilder.updateDnsThreatDetectorSettings().build();
    deleteDnsThreatDetectorSettings = settingsBuilder.deleteDnsThreatDetectorSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  /** Builder for DnsThreatDetectorServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<DnsThreatDetectorServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListDnsThreatDetectorsRequest,
            ListDnsThreatDetectorsResponse,
            ListDnsThreatDetectorsPagedResponse>
        listDnsThreatDetectorsSettings;
    private final UnaryCallSettings.Builder<GetDnsThreatDetectorRequest, DnsThreatDetector>
        getDnsThreatDetectorSettings;
    private final UnaryCallSettings.Builder<CreateDnsThreatDetectorRequest, DnsThreatDetector>
        createDnsThreatDetectorSettings;
    private final UnaryCallSettings.Builder<UpdateDnsThreatDetectorRequest, DnsThreatDetector>
        updateDnsThreatDetectorSettings;
    private final UnaryCallSettings.Builder<DeleteDnsThreatDetectorRequest, Empty>
        deleteDnsThreatDetectorSettings;
    private final PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings;
    private final UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings;
    private final UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings;
    private final UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings;
    private final UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings;
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

      listDnsThreatDetectorsSettings =
          PagedCallSettings.newBuilder(LIST_DNS_THREAT_DETECTORS_PAGE_STR_FACT);
      getDnsThreatDetectorSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createDnsThreatDetectorSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateDnsThreatDetectorSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteDnsThreatDetectorSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listDnsThreatDetectorsSettings,
              getDnsThreatDetectorSettings,
              createDnsThreatDetectorSettings,
              updateDnsThreatDetectorSettings,
              deleteDnsThreatDetectorSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(DnsThreatDetectorServiceStubSettings settings) {
      super(settings);

      listDnsThreatDetectorsSettings = settings.listDnsThreatDetectorsSettings.toBuilder();
      getDnsThreatDetectorSettings = settings.getDnsThreatDetectorSettings.toBuilder();
      createDnsThreatDetectorSettings = settings.createDnsThreatDetectorSettings.toBuilder();
      updateDnsThreatDetectorSettings = settings.updateDnsThreatDetectorSettings.toBuilder();
      deleteDnsThreatDetectorSettings = settings.deleteDnsThreatDetectorSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listDnsThreatDetectorsSettings,
              getDnsThreatDetectorSettings,
              createDnsThreatDetectorSettings,
              updateDnsThreatDetectorSettings,
              deleteDnsThreatDetectorSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
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
          .listDnsThreatDetectorsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getDnsThreatDetectorSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createDnsThreatDetectorSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateDnsThreatDetectorSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteDnsThreatDetectorSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listLocationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getLocationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .setIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .testIamPermissionsSettings()
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

    /** Returns the builder for the settings used for calls to listDnsThreatDetectors. */
    public PagedCallSettings.Builder<
            ListDnsThreatDetectorsRequest,
            ListDnsThreatDetectorsResponse,
            ListDnsThreatDetectorsPagedResponse>
        listDnsThreatDetectorsSettings() {
      return listDnsThreatDetectorsSettings;
    }

    /** Returns the builder for the settings used for calls to getDnsThreatDetector. */
    public UnaryCallSettings.Builder<GetDnsThreatDetectorRequest, DnsThreatDetector>
        getDnsThreatDetectorSettings() {
      return getDnsThreatDetectorSettings;
    }

    /** Returns the builder for the settings used for calls to createDnsThreatDetector. */
    public UnaryCallSettings.Builder<CreateDnsThreatDetectorRequest, DnsThreatDetector>
        createDnsThreatDetectorSettings() {
      return createDnsThreatDetectorSettings;
    }

    /** Returns the builder for the settings used for calls to updateDnsThreatDetector. */
    public UnaryCallSettings.Builder<UpdateDnsThreatDetectorRequest, DnsThreatDetector>
        updateDnsThreatDetectorSettings() {
      return updateDnsThreatDetectorSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDnsThreatDetector. */
    public UnaryCallSettings.Builder<DeleteDnsThreatDetectorRequest, Empty>
        deleteDnsThreatDetectorSettings() {
      return deleteDnsThreatDetectorSettings;
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

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return setIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return testIamPermissionsSettings;
    }

    @Override
    public DnsThreatDetectorServiceStubSettings build() throws IOException {
      return new DnsThreatDetectorServiceStubSettings(this);
    }
  }
}
