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

import static com.google.cloud.apihub.v1.ApiHubCurateClient.ListCurationsPagedResponse;
import static com.google.cloud.apihub.v1.ApiHubCurateClient.ListLocationsPagedResponse;

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
import com.google.cloud.apihub.v1.CreateCurationRequest;
import com.google.cloud.apihub.v1.Curation;
import com.google.cloud.apihub.v1.DeleteCurationRequest;
import com.google.cloud.apihub.v1.GetCurationRequest;
import com.google.cloud.apihub.v1.ListCurationsRequest;
import com.google.cloud.apihub.v1.ListCurationsResponse;
import com.google.cloud.apihub.v1.UpdateCurationRequest;
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
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ApiHubCurateStub}.
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
 * of createCuration:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ApiHubCurateStubSettings.Builder apiHubCurateSettingsBuilder =
 *     ApiHubCurateStubSettings.newBuilder();
 * apiHubCurateSettingsBuilder
 *     .createCurationSettings()
 *     .setRetrySettings(
 *         apiHubCurateSettingsBuilder
 *             .createCurationSettings()
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
 * ApiHubCurateStubSettings apiHubCurateSettings = apiHubCurateSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 */
@Generated("by gapic-generator-java")
public class ApiHubCurateStubSettings extends StubSettings<ApiHubCurateStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateCurationRequest, Curation> createCurationSettings;
  private final UnaryCallSettings<GetCurationRequest, Curation> getCurationSettings;
  private final PagedCallSettings<
          ListCurationsRequest, ListCurationsResponse, ListCurationsPagedResponse>
      listCurationsSettings;
  private final UnaryCallSettings<UpdateCurationRequest, Curation> updateCurationSettings;
  private final UnaryCallSettings<DeleteCurationRequest, Empty> deleteCurationSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;

  private static final PagedListDescriptor<ListCurationsRequest, ListCurationsResponse, Curation>
      LIST_CURATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<ListCurationsRequest, ListCurationsResponse, Curation>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListCurationsRequest injectToken(ListCurationsRequest payload, String token) {
              return ListCurationsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListCurationsRequest injectPageSize(ListCurationsRequest payload, int pageSize) {
              return ListCurationsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListCurationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListCurationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Curation> extractResources(ListCurationsResponse payload) {
              return payload.getCurationsList();
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
          ListCurationsRequest, ListCurationsResponse, ListCurationsPagedResponse>
      LIST_CURATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListCurationsRequest, ListCurationsResponse, ListCurationsPagedResponse>() {
            @Override
            public ApiFuture<ListCurationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListCurationsRequest, ListCurationsResponse> callable,
                ListCurationsRequest request,
                ApiCallContext context,
                ApiFuture<ListCurationsResponse> futureResponse) {
              PageContext<ListCurationsRequest, ListCurationsResponse, Curation> pageContext =
                  PageContext.create(callable, LIST_CURATIONS_PAGE_STR_DESC, request, context);
              return ListCurationsPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to createCuration. */
  public UnaryCallSettings<CreateCurationRequest, Curation> createCurationSettings() {
    return createCurationSettings;
  }

  /** Returns the object with the settings used for calls to getCuration. */
  public UnaryCallSettings<GetCurationRequest, Curation> getCurationSettings() {
    return getCurationSettings;
  }

  /** Returns the object with the settings used for calls to listCurations. */
  public PagedCallSettings<ListCurationsRequest, ListCurationsResponse, ListCurationsPagedResponse>
      listCurationsSettings() {
    return listCurationsSettings;
  }

  /** Returns the object with the settings used for calls to updateCuration. */
  public UnaryCallSettings<UpdateCurationRequest, Curation> updateCurationSettings() {
    return updateCurationSettings;
  }

  /** Returns the object with the settings used for calls to deleteCuration. */
  public UnaryCallSettings<DeleteCurationRequest, Empty> deleteCurationSettings() {
    return deleteCurationSettings;
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

  public ApiHubCurateStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonApiHubCurateStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(ApiHubCurateStubSettings.class))
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

  protected ApiHubCurateStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createCurationSettings = settingsBuilder.createCurationSettings().build();
    getCurationSettings = settingsBuilder.getCurationSettings().build();
    listCurationsSettings = settingsBuilder.listCurationsSettings().build();
    updateCurationSettings = settingsBuilder.updateCurationSettings().build();
    deleteCurationSettings = settingsBuilder.deleteCurationSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
  }

  /** Builder for ApiHubCurateStubSettings. */
  public static class Builder extends StubSettings.Builder<ApiHubCurateStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateCurationRequest, Curation> createCurationSettings;
    private final UnaryCallSettings.Builder<GetCurationRequest, Curation> getCurationSettings;
    private final PagedCallSettings.Builder<
            ListCurationsRequest, ListCurationsResponse, ListCurationsPagedResponse>
        listCurationsSettings;
    private final UnaryCallSettings.Builder<UpdateCurationRequest, Curation> updateCurationSettings;
    private final UnaryCallSettings.Builder<DeleteCurationRequest, Empty> deleteCurationSettings;
    private final PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings;
    private final UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings;
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

      createCurationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getCurationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listCurationsSettings = PagedCallSettings.newBuilder(LIST_CURATIONS_PAGE_STR_FACT);
      updateCurationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteCurationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createCurationSettings,
              getCurationSettings,
              listCurationsSettings,
              updateCurationSettings,
              deleteCurationSettings,
              listLocationsSettings,
              getLocationSettings);
      initDefaults(this);
    }

    protected Builder(ApiHubCurateStubSettings settings) {
      super(settings);

      createCurationSettings = settings.createCurationSettings.toBuilder();
      getCurationSettings = settings.getCurationSettings.toBuilder();
      listCurationsSettings = settings.listCurationsSettings.toBuilder();
      updateCurationSettings = settings.updateCurationSettings.toBuilder();
      deleteCurationSettings = settings.deleteCurationSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createCurationSettings,
              getCurationSettings,
              listCurationsSettings,
              updateCurationSettings,
              deleteCurationSettings,
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
          .createCurationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getCurationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listCurationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateCurationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteCurationSettings()
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

    /** Returns the builder for the settings used for calls to createCuration. */
    public UnaryCallSettings.Builder<CreateCurationRequest, Curation> createCurationSettings() {
      return createCurationSettings;
    }

    /** Returns the builder for the settings used for calls to getCuration. */
    public UnaryCallSettings.Builder<GetCurationRequest, Curation> getCurationSettings() {
      return getCurationSettings;
    }

    /** Returns the builder for the settings used for calls to listCurations. */
    public PagedCallSettings.Builder<
            ListCurationsRequest, ListCurationsResponse, ListCurationsPagedResponse>
        listCurationsSettings() {
      return listCurationsSettings;
    }

    /** Returns the builder for the settings used for calls to updateCuration. */
    public UnaryCallSettings.Builder<UpdateCurationRequest, Curation> updateCurationSettings() {
      return updateCurationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteCuration. */
    public UnaryCallSettings.Builder<DeleteCurationRequest, Empty> deleteCurationSettings() {
      return deleteCurationSettings;
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
    public ApiHubCurateStubSettings build() throws IOException {
      return new ApiHubCurateStubSettings(this);
    }
  }
}
