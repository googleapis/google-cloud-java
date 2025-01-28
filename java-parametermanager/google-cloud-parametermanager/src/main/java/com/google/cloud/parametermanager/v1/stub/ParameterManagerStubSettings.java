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

package com.google.cloud.parametermanager.v1.stub;

import static com.google.cloud.parametermanager.v1.ParameterManagerClient.ListLocationsPagedResponse;
import static com.google.cloud.parametermanager.v1.ParameterManagerClient.ListParameterVersionsPagedResponse;
import static com.google.cloud.parametermanager.v1.ParameterManagerClient.ListParametersPagedResponse;

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
import com.google.cloud.parametermanager.v1.CreateParameterRequest;
import com.google.cloud.parametermanager.v1.CreateParameterVersionRequest;
import com.google.cloud.parametermanager.v1.DeleteParameterRequest;
import com.google.cloud.parametermanager.v1.DeleteParameterVersionRequest;
import com.google.cloud.parametermanager.v1.GetParameterRequest;
import com.google.cloud.parametermanager.v1.GetParameterVersionRequest;
import com.google.cloud.parametermanager.v1.ListParameterVersionsRequest;
import com.google.cloud.parametermanager.v1.ListParameterVersionsResponse;
import com.google.cloud.parametermanager.v1.ListParametersRequest;
import com.google.cloud.parametermanager.v1.ListParametersResponse;
import com.google.cloud.parametermanager.v1.Parameter;
import com.google.cloud.parametermanager.v1.ParameterVersion;
import com.google.cloud.parametermanager.v1.RenderParameterVersionRequest;
import com.google.cloud.parametermanager.v1.RenderParameterVersionResponse;
import com.google.cloud.parametermanager.v1.UpdateParameterRequest;
import com.google.cloud.parametermanager.v1.UpdateParameterVersionRequest;
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
 * Settings class to configure an instance of {@link ParameterManagerStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (parametermanager.googleapis.com) and default port (443) are
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
 * of getParameter:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ParameterManagerStubSettings.Builder parameterManagerSettingsBuilder =
 *     ParameterManagerStubSettings.newBuilder();
 * parameterManagerSettingsBuilder
 *     .getParameterSettings()
 *     .setRetrySettings(
 *         parameterManagerSettingsBuilder
 *             .getParameterSettings()
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
 * ParameterManagerStubSettings parameterManagerSettings = parameterManagerSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 */
@Generated("by gapic-generator-java")
public class ParameterManagerStubSettings extends StubSettings<ParameterManagerStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListParametersRequest, ListParametersResponse, ListParametersPagedResponse>
      listParametersSettings;
  private final UnaryCallSettings<GetParameterRequest, Parameter> getParameterSettings;
  private final UnaryCallSettings<CreateParameterRequest, Parameter> createParameterSettings;
  private final UnaryCallSettings<UpdateParameterRequest, Parameter> updateParameterSettings;
  private final UnaryCallSettings<DeleteParameterRequest, Empty> deleteParameterSettings;
  private final PagedCallSettings<
          ListParameterVersionsRequest,
          ListParameterVersionsResponse,
          ListParameterVersionsPagedResponse>
      listParameterVersionsSettings;
  private final UnaryCallSettings<GetParameterVersionRequest, ParameterVersion>
      getParameterVersionSettings;
  private final UnaryCallSettings<RenderParameterVersionRequest, RenderParameterVersionResponse>
      renderParameterVersionSettings;
  private final UnaryCallSettings<CreateParameterVersionRequest, ParameterVersion>
      createParameterVersionSettings;
  private final UnaryCallSettings<UpdateParameterVersionRequest, ParameterVersion>
      updateParameterVersionSettings;
  private final UnaryCallSettings<DeleteParameterVersionRequest, Empty>
      deleteParameterVersionSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;

  private static final PagedListDescriptor<ListParametersRequest, ListParametersResponse, Parameter>
      LIST_PARAMETERS_PAGE_STR_DESC =
          new PagedListDescriptor<ListParametersRequest, ListParametersResponse, Parameter>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListParametersRequest injectToken(ListParametersRequest payload, String token) {
              return ListParametersRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListParametersRequest injectPageSize(
                ListParametersRequest payload, int pageSize) {
              return ListParametersRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListParametersRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListParametersResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Parameter> extractResources(ListParametersResponse payload) {
              return payload.getParametersList();
            }
          };

  private static final PagedListDescriptor<
          ListParameterVersionsRequest, ListParameterVersionsResponse, ParameterVersion>
      LIST_PARAMETER_VERSIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListParameterVersionsRequest, ListParameterVersionsResponse, ParameterVersion>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListParameterVersionsRequest injectToken(
                ListParameterVersionsRequest payload, String token) {
              return ListParameterVersionsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListParameterVersionsRequest injectPageSize(
                ListParameterVersionsRequest payload, int pageSize) {
              return ListParameterVersionsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListParameterVersionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListParameterVersionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ParameterVersion> extractResources(
                ListParameterVersionsResponse payload) {
              return payload.getParameterVersionsList();
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
          ListParametersRequest, ListParametersResponse, ListParametersPagedResponse>
      LIST_PARAMETERS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListParametersRequest, ListParametersResponse, ListParametersPagedResponse>() {
            @Override
            public ApiFuture<ListParametersPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListParametersRequest, ListParametersResponse> callable,
                ListParametersRequest request,
                ApiCallContext context,
                ApiFuture<ListParametersResponse> futureResponse) {
              PageContext<ListParametersRequest, ListParametersResponse, Parameter> pageContext =
                  PageContext.create(callable, LIST_PARAMETERS_PAGE_STR_DESC, request, context);
              return ListParametersPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListParameterVersionsRequest,
          ListParameterVersionsResponse,
          ListParameterVersionsPagedResponse>
      LIST_PARAMETER_VERSIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListParameterVersionsRequest,
              ListParameterVersionsResponse,
              ListParameterVersionsPagedResponse>() {
            @Override
            public ApiFuture<ListParameterVersionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListParameterVersionsRequest, ListParameterVersionsResponse> callable,
                ListParameterVersionsRequest request,
                ApiCallContext context,
                ApiFuture<ListParameterVersionsResponse> futureResponse) {
              PageContext<
                      ListParameterVersionsRequest, ListParameterVersionsResponse, ParameterVersion>
                  pageContext =
                      PageContext.create(
                          callable, LIST_PARAMETER_VERSIONS_PAGE_STR_DESC, request, context);
              return ListParameterVersionsPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to listParameters. */
  public PagedCallSettings<
          ListParametersRequest, ListParametersResponse, ListParametersPagedResponse>
      listParametersSettings() {
    return listParametersSettings;
  }

  /** Returns the object with the settings used for calls to getParameter. */
  public UnaryCallSettings<GetParameterRequest, Parameter> getParameterSettings() {
    return getParameterSettings;
  }

  /** Returns the object with the settings used for calls to createParameter. */
  public UnaryCallSettings<CreateParameterRequest, Parameter> createParameterSettings() {
    return createParameterSettings;
  }

  /** Returns the object with the settings used for calls to updateParameter. */
  public UnaryCallSettings<UpdateParameterRequest, Parameter> updateParameterSettings() {
    return updateParameterSettings;
  }

  /** Returns the object with the settings used for calls to deleteParameter. */
  public UnaryCallSettings<DeleteParameterRequest, Empty> deleteParameterSettings() {
    return deleteParameterSettings;
  }

  /** Returns the object with the settings used for calls to listParameterVersions. */
  public PagedCallSettings<
          ListParameterVersionsRequest,
          ListParameterVersionsResponse,
          ListParameterVersionsPagedResponse>
      listParameterVersionsSettings() {
    return listParameterVersionsSettings;
  }

  /** Returns the object with the settings used for calls to getParameterVersion. */
  public UnaryCallSettings<GetParameterVersionRequest, ParameterVersion>
      getParameterVersionSettings() {
    return getParameterVersionSettings;
  }

  /** Returns the object with the settings used for calls to renderParameterVersion. */
  public UnaryCallSettings<RenderParameterVersionRequest, RenderParameterVersionResponse>
      renderParameterVersionSettings() {
    return renderParameterVersionSettings;
  }

  /** Returns the object with the settings used for calls to createParameterVersion. */
  public UnaryCallSettings<CreateParameterVersionRequest, ParameterVersion>
      createParameterVersionSettings() {
    return createParameterVersionSettings;
  }

  /** Returns the object with the settings used for calls to updateParameterVersion. */
  public UnaryCallSettings<UpdateParameterVersionRequest, ParameterVersion>
      updateParameterVersionSettings() {
    return updateParameterVersionSettings;
  }

  /** Returns the object with the settings used for calls to deleteParameterVersion. */
  public UnaryCallSettings<DeleteParameterVersionRequest, Empty> deleteParameterVersionSettings() {
    return deleteParameterVersionSettings;
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

  public ParameterManagerStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcParameterManagerStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonParameterManagerStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "parametermanager";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "parametermanager.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "parametermanager.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(ParameterManagerStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(ParameterManagerStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ParameterManagerStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected ParameterManagerStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listParametersSettings = settingsBuilder.listParametersSettings().build();
    getParameterSettings = settingsBuilder.getParameterSettings().build();
    createParameterSettings = settingsBuilder.createParameterSettings().build();
    updateParameterSettings = settingsBuilder.updateParameterSettings().build();
    deleteParameterSettings = settingsBuilder.deleteParameterSettings().build();
    listParameterVersionsSettings = settingsBuilder.listParameterVersionsSettings().build();
    getParameterVersionSettings = settingsBuilder.getParameterVersionSettings().build();
    renderParameterVersionSettings = settingsBuilder.renderParameterVersionSettings().build();
    createParameterVersionSettings = settingsBuilder.createParameterVersionSettings().build();
    updateParameterVersionSettings = settingsBuilder.updateParameterVersionSettings().build();
    deleteParameterVersionSettings = settingsBuilder.deleteParameterVersionSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
  }

  /** Builder for ParameterManagerStubSettings. */
  public static class Builder extends StubSettings.Builder<ParameterManagerStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListParametersRequest, ListParametersResponse, ListParametersPagedResponse>
        listParametersSettings;
    private final UnaryCallSettings.Builder<GetParameterRequest, Parameter> getParameterSettings;
    private final UnaryCallSettings.Builder<CreateParameterRequest, Parameter>
        createParameterSettings;
    private final UnaryCallSettings.Builder<UpdateParameterRequest, Parameter>
        updateParameterSettings;
    private final UnaryCallSettings.Builder<DeleteParameterRequest, Empty> deleteParameterSettings;
    private final PagedCallSettings.Builder<
            ListParameterVersionsRequest,
            ListParameterVersionsResponse,
            ListParameterVersionsPagedResponse>
        listParameterVersionsSettings;
    private final UnaryCallSettings.Builder<GetParameterVersionRequest, ParameterVersion>
        getParameterVersionSettings;
    private final UnaryCallSettings.Builder<
            RenderParameterVersionRequest, RenderParameterVersionResponse>
        renderParameterVersionSettings;
    private final UnaryCallSettings.Builder<CreateParameterVersionRequest, ParameterVersion>
        createParameterVersionSettings;
    private final UnaryCallSettings.Builder<UpdateParameterVersionRequest, ParameterVersion>
        updateParameterVersionSettings;
    private final UnaryCallSettings.Builder<DeleteParameterVersionRequest, Empty>
        deleteParameterVersionSettings;
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

      listParametersSettings = PagedCallSettings.newBuilder(LIST_PARAMETERS_PAGE_STR_FACT);
      getParameterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createParameterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateParameterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteParameterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listParameterVersionsSettings =
          PagedCallSettings.newBuilder(LIST_PARAMETER_VERSIONS_PAGE_STR_FACT);
      getParameterVersionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      renderParameterVersionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createParameterVersionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateParameterVersionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteParameterVersionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listParametersSettings,
              getParameterSettings,
              createParameterSettings,
              updateParameterSettings,
              deleteParameterSettings,
              listParameterVersionsSettings,
              getParameterVersionSettings,
              renderParameterVersionSettings,
              createParameterVersionSettings,
              updateParameterVersionSettings,
              deleteParameterVersionSettings,
              listLocationsSettings,
              getLocationSettings);
      initDefaults(this);
    }

    protected Builder(ParameterManagerStubSettings settings) {
      super(settings);

      listParametersSettings = settings.listParametersSettings.toBuilder();
      getParameterSettings = settings.getParameterSettings.toBuilder();
      createParameterSettings = settings.createParameterSettings.toBuilder();
      updateParameterSettings = settings.updateParameterSettings.toBuilder();
      deleteParameterSettings = settings.deleteParameterSettings.toBuilder();
      listParameterVersionsSettings = settings.listParameterVersionsSettings.toBuilder();
      getParameterVersionSettings = settings.getParameterVersionSettings.toBuilder();
      renderParameterVersionSettings = settings.renderParameterVersionSettings.toBuilder();
      createParameterVersionSettings = settings.createParameterVersionSettings.toBuilder();
      updateParameterVersionSettings = settings.updateParameterVersionSettings.toBuilder();
      deleteParameterVersionSettings = settings.deleteParameterVersionSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listParametersSettings,
              getParameterSettings,
              createParameterSettings,
              updateParameterSettings,
              deleteParameterSettings,
              listParameterVersionsSettings,
              getParameterVersionSettings,
              renderParameterVersionSettings,
              createParameterVersionSettings,
              updateParameterVersionSettings,
              deleteParameterVersionSettings,
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
          .listParametersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getParameterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createParameterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateParameterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteParameterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listParameterVersionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getParameterVersionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .renderParameterVersionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createParameterVersionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateParameterVersionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteParameterVersionSettings()
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

    /** Returns the builder for the settings used for calls to listParameters. */
    public PagedCallSettings.Builder<
            ListParametersRequest, ListParametersResponse, ListParametersPagedResponse>
        listParametersSettings() {
      return listParametersSettings;
    }

    /** Returns the builder for the settings used for calls to getParameter. */
    public UnaryCallSettings.Builder<GetParameterRequest, Parameter> getParameterSettings() {
      return getParameterSettings;
    }

    /** Returns the builder for the settings used for calls to createParameter. */
    public UnaryCallSettings.Builder<CreateParameterRequest, Parameter> createParameterSettings() {
      return createParameterSettings;
    }

    /** Returns the builder for the settings used for calls to updateParameter. */
    public UnaryCallSettings.Builder<UpdateParameterRequest, Parameter> updateParameterSettings() {
      return updateParameterSettings;
    }

    /** Returns the builder for the settings used for calls to deleteParameter. */
    public UnaryCallSettings.Builder<DeleteParameterRequest, Empty> deleteParameterSettings() {
      return deleteParameterSettings;
    }

    /** Returns the builder for the settings used for calls to listParameterVersions. */
    public PagedCallSettings.Builder<
            ListParameterVersionsRequest,
            ListParameterVersionsResponse,
            ListParameterVersionsPagedResponse>
        listParameterVersionsSettings() {
      return listParameterVersionsSettings;
    }

    /** Returns the builder for the settings used for calls to getParameterVersion. */
    public UnaryCallSettings.Builder<GetParameterVersionRequest, ParameterVersion>
        getParameterVersionSettings() {
      return getParameterVersionSettings;
    }

    /** Returns the builder for the settings used for calls to renderParameterVersion. */
    public UnaryCallSettings.Builder<RenderParameterVersionRequest, RenderParameterVersionResponse>
        renderParameterVersionSettings() {
      return renderParameterVersionSettings;
    }

    /** Returns the builder for the settings used for calls to createParameterVersion. */
    public UnaryCallSettings.Builder<CreateParameterVersionRequest, ParameterVersion>
        createParameterVersionSettings() {
      return createParameterVersionSettings;
    }

    /** Returns the builder for the settings used for calls to updateParameterVersion. */
    public UnaryCallSettings.Builder<UpdateParameterVersionRequest, ParameterVersion>
        updateParameterVersionSettings() {
      return updateParameterVersionSettings;
    }

    /** Returns the builder for the settings used for calls to deleteParameterVersion. */
    public UnaryCallSettings.Builder<DeleteParameterVersionRequest, Empty>
        deleteParameterVersionSettings() {
      return deleteParameterVersionSettings;
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
    public ParameterManagerStubSettings build() throws IOException {
      return new ParameterManagerStubSettings(this);
    }
  }
}
