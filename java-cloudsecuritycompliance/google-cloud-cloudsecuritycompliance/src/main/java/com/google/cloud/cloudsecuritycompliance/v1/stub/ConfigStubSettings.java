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

import static com.google.cloud.cloudsecuritycompliance.v1.ConfigClient.ListCloudControlsPagedResponse;
import static com.google.cloud.cloudsecuritycompliance.v1.ConfigClient.ListFrameworksPagedResponse;
import static com.google.cloud.cloudsecuritycompliance.v1.ConfigClient.ListLocationsPagedResponse;

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
import com.google.cloud.cloudsecuritycompliance.v1.CloudControl;
import com.google.cloud.cloudsecuritycompliance.v1.CreateCloudControlRequest;
import com.google.cloud.cloudsecuritycompliance.v1.CreateFrameworkRequest;
import com.google.cloud.cloudsecuritycompliance.v1.DeleteCloudControlRequest;
import com.google.cloud.cloudsecuritycompliance.v1.DeleteFrameworkRequest;
import com.google.cloud.cloudsecuritycompliance.v1.Framework;
import com.google.cloud.cloudsecuritycompliance.v1.GetCloudControlRequest;
import com.google.cloud.cloudsecuritycompliance.v1.GetFrameworkRequest;
import com.google.cloud.cloudsecuritycompliance.v1.ListCloudControlsRequest;
import com.google.cloud.cloudsecuritycompliance.v1.ListCloudControlsResponse;
import com.google.cloud.cloudsecuritycompliance.v1.ListFrameworksRequest;
import com.google.cloud.cloudsecuritycompliance.v1.ListFrameworksResponse;
import com.google.cloud.cloudsecuritycompliance.v1.UpdateCloudControlRequest;
import com.google.cloud.cloudsecuritycompliance.v1.UpdateFrameworkRequest;
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
 * Settings class to configure an instance of {@link ConfigStub}.
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
 * of getFramework:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ConfigStubSettings.Builder configSettingsBuilder = ConfigStubSettings.newBuilder();
 * configSettingsBuilder
 *     .getFrameworkSettings()
 *     .setRetrySettings(
 *         configSettingsBuilder
 *             .getFrameworkSettings()
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
 * ConfigStubSettings configSettings = configSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 */
@Generated("by gapic-generator-java")
public class ConfigStubSettings extends StubSettings<ConfigStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListFrameworksRequest, ListFrameworksResponse, ListFrameworksPagedResponse>
      listFrameworksSettings;
  private final UnaryCallSettings<GetFrameworkRequest, Framework> getFrameworkSettings;
  private final UnaryCallSettings<CreateFrameworkRequest, Framework> createFrameworkSettings;
  private final UnaryCallSettings<UpdateFrameworkRequest, Framework> updateFrameworkSettings;
  private final UnaryCallSettings<DeleteFrameworkRequest, Empty> deleteFrameworkSettings;
  private final PagedCallSettings<
          ListCloudControlsRequest, ListCloudControlsResponse, ListCloudControlsPagedResponse>
      listCloudControlsSettings;
  private final UnaryCallSettings<GetCloudControlRequest, CloudControl> getCloudControlSettings;
  private final UnaryCallSettings<CreateCloudControlRequest, CloudControl>
      createCloudControlSettings;
  private final UnaryCallSettings<UpdateCloudControlRequest, CloudControl>
      updateCloudControlSettings;
  private final UnaryCallSettings<DeleteCloudControlRequest, Empty> deleteCloudControlSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;

  private static final PagedListDescriptor<ListFrameworksRequest, ListFrameworksResponse, Framework>
      LIST_FRAMEWORKS_PAGE_STR_DESC =
          new PagedListDescriptor<ListFrameworksRequest, ListFrameworksResponse, Framework>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListFrameworksRequest injectToken(ListFrameworksRequest payload, String token) {
              return ListFrameworksRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListFrameworksRequest injectPageSize(
                ListFrameworksRequest payload, int pageSize) {
              return ListFrameworksRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListFrameworksRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListFrameworksResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Framework> extractResources(ListFrameworksResponse payload) {
              return payload.getFrameworksList();
            }
          };

  private static final PagedListDescriptor<
          ListCloudControlsRequest, ListCloudControlsResponse, CloudControl>
      LIST_CLOUD_CONTROLS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListCloudControlsRequest, ListCloudControlsResponse, CloudControl>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListCloudControlsRequest injectToken(
                ListCloudControlsRequest payload, String token) {
              return ListCloudControlsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListCloudControlsRequest injectPageSize(
                ListCloudControlsRequest payload, int pageSize) {
              return ListCloudControlsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListCloudControlsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListCloudControlsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<CloudControl> extractResources(ListCloudControlsResponse payload) {
              return payload.getCloudControlsList();
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
          ListFrameworksRequest, ListFrameworksResponse, ListFrameworksPagedResponse>
      LIST_FRAMEWORKS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListFrameworksRequest, ListFrameworksResponse, ListFrameworksPagedResponse>() {
            @Override
            public ApiFuture<ListFrameworksPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListFrameworksRequest, ListFrameworksResponse> callable,
                ListFrameworksRequest request,
                ApiCallContext context,
                ApiFuture<ListFrameworksResponse> futureResponse) {
              PageContext<ListFrameworksRequest, ListFrameworksResponse, Framework> pageContext =
                  PageContext.create(callable, LIST_FRAMEWORKS_PAGE_STR_DESC, request, context);
              return ListFrameworksPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListCloudControlsRequest, ListCloudControlsResponse, ListCloudControlsPagedResponse>
      LIST_CLOUD_CONTROLS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListCloudControlsRequest,
              ListCloudControlsResponse,
              ListCloudControlsPagedResponse>() {
            @Override
            public ApiFuture<ListCloudControlsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListCloudControlsRequest, ListCloudControlsResponse> callable,
                ListCloudControlsRequest request,
                ApiCallContext context,
                ApiFuture<ListCloudControlsResponse> futureResponse) {
              PageContext<ListCloudControlsRequest, ListCloudControlsResponse, CloudControl>
                  pageContext =
                      PageContext.create(
                          callable, LIST_CLOUD_CONTROLS_PAGE_STR_DESC, request, context);
              return ListCloudControlsPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to listFrameworks. */
  public PagedCallSettings<
          ListFrameworksRequest, ListFrameworksResponse, ListFrameworksPagedResponse>
      listFrameworksSettings() {
    return listFrameworksSettings;
  }

  /** Returns the object with the settings used for calls to getFramework. */
  public UnaryCallSettings<GetFrameworkRequest, Framework> getFrameworkSettings() {
    return getFrameworkSettings;
  }

  /** Returns the object with the settings used for calls to createFramework. */
  public UnaryCallSettings<CreateFrameworkRequest, Framework> createFrameworkSettings() {
    return createFrameworkSettings;
  }

  /** Returns the object with the settings used for calls to updateFramework. */
  public UnaryCallSettings<UpdateFrameworkRequest, Framework> updateFrameworkSettings() {
    return updateFrameworkSettings;
  }

  /** Returns the object with the settings used for calls to deleteFramework. */
  public UnaryCallSettings<DeleteFrameworkRequest, Empty> deleteFrameworkSettings() {
    return deleteFrameworkSettings;
  }

  /** Returns the object with the settings used for calls to listCloudControls. */
  public PagedCallSettings<
          ListCloudControlsRequest, ListCloudControlsResponse, ListCloudControlsPagedResponse>
      listCloudControlsSettings() {
    return listCloudControlsSettings;
  }

  /** Returns the object with the settings used for calls to getCloudControl. */
  public UnaryCallSettings<GetCloudControlRequest, CloudControl> getCloudControlSettings() {
    return getCloudControlSettings;
  }

  /** Returns the object with the settings used for calls to createCloudControl. */
  public UnaryCallSettings<CreateCloudControlRequest, CloudControl> createCloudControlSettings() {
    return createCloudControlSettings;
  }

  /** Returns the object with the settings used for calls to updateCloudControl. */
  public UnaryCallSettings<UpdateCloudControlRequest, CloudControl> updateCloudControlSettings() {
    return updateCloudControlSettings;
  }

  /** Returns the object with the settings used for calls to deleteCloudControl. */
  public UnaryCallSettings<DeleteCloudControlRequest, Empty> deleteCloudControlSettings() {
    return deleteCloudControlSettings;
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

  public ConfigStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcConfigStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonConfigStub.create(this);
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
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(ConfigStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(ConfigStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ConfigStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected ConfigStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listFrameworksSettings = settingsBuilder.listFrameworksSettings().build();
    getFrameworkSettings = settingsBuilder.getFrameworkSettings().build();
    createFrameworkSettings = settingsBuilder.createFrameworkSettings().build();
    updateFrameworkSettings = settingsBuilder.updateFrameworkSettings().build();
    deleteFrameworkSettings = settingsBuilder.deleteFrameworkSettings().build();
    listCloudControlsSettings = settingsBuilder.listCloudControlsSettings().build();
    getCloudControlSettings = settingsBuilder.getCloudControlSettings().build();
    createCloudControlSettings = settingsBuilder.createCloudControlSettings().build();
    updateCloudControlSettings = settingsBuilder.updateCloudControlSettings().build();
    deleteCloudControlSettings = settingsBuilder.deleteCloudControlSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
  }

  /** Builder for ConfigStubSettings. */
  public static class Builder extends StubSettings.Builder<ConfigStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListFrameworksRequest, ListFrameworksResponse, ListFrameworksPagedResponse>
        listFrameworksSettings;
    private final UnaryCallSettings.Builder<GetFrameworkRequest, Framework> getFrameworkSettings;
    private final UnaryCallSettings.Builder<CreateFrameworkRequest, Framework>
        createFrameworkSettings;
    private final UnaryCallSettings.Builder<UpdateFrameworkRequest, Framework>
        updateFrameworkSettings;
    private final UnaryCallSettings.Builder<DeleteFrameworkRequest, Empty> deleteFrameworkSettings;
    private final PagedCallSettings.Builder<
            ListCloudControlsRequest, ListCloudControlsResponse, ListCloudControlsPagedResponse>
        listCloudControlsSettings;
    private final UnaryCallSettings.Builder<GetCloudControlRequest, CloudControl>
        getCloudControlSettings;
    private final UnaryCallSettings.Builder<CreateCloudControlRequest, CloudControl>
        createCloudControlSettings;
    private final UnaryCallSettings.Builder<UpdateCloudControlRequest, CloudControl>
        updateCloudControlSettings;
    private final UnaryCallSettings.Builder<DeleteCloudControlRequest, Empty>
        deleteCloudControlSettings;
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
      definitions.put(
          "no_retry_1_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
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
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_1_params", settings);
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listFrameworksSettings = PagedCallSettings.newBuilder(LIST_FRAMEWORKS_PAGE_STR_FACT);
      getFrameworkSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createFrameworkSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateFrameworkSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteFrameworkSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listCloudControlsSettings = PagedCallSettings.newBuilder(LIST_CLOUD_CONTROLS_PAGE_STR_FACT);
      getCloudControlSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createCloudControlSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateCloudControlSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteCloudControlSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listFrameworksSettings,
              getFrameworkSettings,
              createFrameworkSettings,
              updateFrameworkSettings,
              deleteFrameworkSettings,
              listCloudControlsSettings,
              getCloudControlSettings,
              createCloudControlSettings,
              updateCloudControlSettings,
              deleteCloudControlSettings,
              listLocationsSettings,
              getLocationSettings);
      initDefaults(this);
    }

    protected Builder(ConfigStubSettings settings) {
      super(settings);

      listFrameworksSettings = settings.listFrameworksSettings.toBuilder();
      getFrameworkSettings = settings.getFrameworkSettings.toBuilder();
      createFrameworkSettings = settings.createFrameworkSettings.toBuilder();
      updateFrameworkSettings = settings.updateFrameworkSettings.toBuilder();
      deleteFrameworkSettings = settings.deleteFrameworkSettings.toBuilder();
      listCloudControlsSettings = settings.listCloudControlsSettings.toBuilder();
      getCloudControlSettings = settings.getCloudControlSettings.toBuilder();
      createCloudControlSettings = settings.createCloudControlSettings.toBuilder();
      updateCloudControlSettings = settings.updateCloudControlSettings.toBuilder();
      deleteCloudControlSettings = settings.deleteCloudControlSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listFrameworksSettings,
              getFrameworkSettings,
              createFrameworkSettings,
              updateFrameworkSettings,
              deleteFrameworkSettings,
              listCloudControlsSettings,
              getCloudControlSettings,
              createCloudControlSettings,
              updateCloudControlSettings,
              deleteCloudControlSettings,
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
          .listFrameworksSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getFrameworkSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createFrameworkSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateFrameworkSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteFrameworkSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listCloudControlsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getCloudControlSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createCloudControlSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateCloudControlSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteCloudControlSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

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

    /** Returns the builder for the settings used for calls to listFrameworks. */
    public PagedCallSettings.Builder<
            ListFrameworksRequest, ListFrameworksResponse, ListFrameworksPagedResponse>
        listFrameworksSettings() {
      return listFrameworksSettings;
    }

    /** Returns the builder for the settings used for calls to getFramework. */
    public UnaryCallSettings.Builder<GetFrameworkRequest, Framework> getFrameworkSettings() {
      return getFrameworkSettings;
    }

    /** Returns the builder for the settings used for calls to createFramework. */
    public UnaryCallSettings.Builder<CreateFrameworkRequest, Framework> createFrameworkSettings() {
      return createFrameworkSettings;
    }

    /** Returns the builder for the settings used for calls to updateFramework. */
    public UnaryCallSettings.Builder<UpdateFrameworkRequest, Framework> updateFrameworkSettings() {
      return updateFrameworkSettings;
    }

    /** Returns the builder for the settings used for calls to deleteFramework. */
    public UnaryCallSettings.Builder<DeleteFrameworkRequest, Empty> deleteFrameworkSettings() {
      return deleteFrameworkSettings;
    }

    /** Returns the builder for the settings used for calls to listCloudControls. */
    public PagedCallSettings.Builder<
            ListCloudControlsRequest, ListCloudControlsResponse, ListCloudControlsPagedResponse>
        listCloudControlsSettings() {
      return listCloudControlsSettings;
    }

    /** Returns the builder for the settings used for calls to getCloudControl. */
    public UnaryCallSettings.Builder<GetCloudControlRequest, CloudControl>
        getCloudControlSettings() {
      return getCloudControlSettings;
    }

    /** Returns the builder for the settings used for calls to createCloudControl. */
    public UnaryCallSettings.Builder<CreateCloudControlRequest, CloudControl>
        createCloudControlSettings() {
      return createCloudControlSettings;
    }

    /** Returns the builder for the settings used for calls to updateCloudControl. */
    public UnaryCallSettings.Builder<UpdateCloudControlRequest, CloudControl>
        updateCloudControlSettings() {
      return updateCloudControlSettings;
    }

    /** Returns the builder for the settings used for calls to deleteCloudControl. */
    public UnaryCallSettings.Builder<DeleteCloudControlRequest, Empty>
        deleteCloudControlSettings() {
      return deleteCloudControlSettings;
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
    public ConfigStubSettings build() throws IOException {
      return new ConfigStubSettings(this);
    }
  }
}
