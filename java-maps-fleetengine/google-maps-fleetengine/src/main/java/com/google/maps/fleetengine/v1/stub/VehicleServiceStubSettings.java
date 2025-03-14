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

package com.google.maps.fleetengine.v1.stub;

import static com.google.maps.fleetengine.v1.VehicleServiceClient.ListVehiclesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ObsoleteApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.maps.fleetengine.v1.CreateVehicleRequest;
import com.google.maps.fleetengine.v1.DeleteVehicleRequest;
import com.google.maps.fleetengine.v1.GetVehicleRequest;
import com.google.maps.fleetengine.v1.ListVehiclesRequest;
import com.google.maps.fleetengine.v1.ListVehiclesResponse;
import com.google.maps.fleetengine.v1.SearchVehiclesRequest;
import com.google.maps.fleetengine.v1.SearchVehiclesResponse;
import com.google.maps.fleetengine.v1.UpdateVehicleAttributesRequest;
import com.google.maps.fleetengine.v1.UpdateVehicleAttributesResponse;
import com.google.maps.fleetengine.v1.UpdateVehicleRequest;
import com.google.maps.fleetengine.v1.Vehicle;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link VehicleServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (fleetengine.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of createVehicle:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * VehicleServiceStubSettings.Builder vehicleServiceSettingsBuilder =
 *     VehicleServiceStubSettings.newBuilder();
 * vehicleServiceSettingsBuilder
 *     .createVehicleSettings()
 *     .setRetrySettings(
 *         vehicleServiceSettingsBuilder
 *             .createVehicleSettings()
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
 * VehicleServiceStubSettings vehicleServiceSettings = vehicleServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 */
@Generated("by gapic-generator-java")
public class VehicleServiceStubSettings extends StubSettings<VehicleServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateVehicleRequest, Vehicle> createVehicleSettings;
  private final UnaryCallSettings<GetVehicleRequest, Vehicle> getVehicleSettings;
  private final UnaryCallSettings<DeleteVehicleRequest, Empty> deleteVehicleSettings;
  private final UnaryCallSettings<UpdateVehicleRequest, Vehicle> updateVehicleSettings;
  private final UnaryCallSettings<UpdateVehicleAttributesRequest, UpdateVehicleAttributesResponse>
      updateVehicleAttributesSettings;
  private final PagedCallSettings<
          ListVehiclesRequest, ListVehiclesResponse, ListVehiclesPagedResponse>
      listVehiclesSettings;
  private final UnaryCallSettings<SearchVehiclesRequest, SearchVehiclesResponse>
      searchVehiclesSettings;

  private static final PagedListDescriptor<ListVehiclesRequest, ListVehiclesResponse, Vehicle>
      LIST_VEHICLES_PAGE_STR_DESC =
          new PagedListDescriptor<ListVehiclesRequest, ListVehiclesResponse, Vehicle>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListVehiclesRequest injectToken(ListVehiclesRequest payload, String token) {
              return ListVehiclesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListVehiclesRequest injectPageSize(ListVehiclesRequest payload, int pageSize) {
              return ListVehiclesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListVehiclesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListVehiclesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Vehicle> extractResources(ListVehiclesResponse payload) {
              return payload.getVehiclesList();
            }
          };

  private static final PagedListResponseFactory<
          ListVehiclesRequest, ListVehiclesResponse, ListVehiclesPagedResponse>
      LIST_VEHICLES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListVehiclesRequest, ListVehiclesResponse, ListVehiclesPagedResponse>() {
            @Override
            public ApiFuture<ListVehiclesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListVehiclesRequest, ListVehiclesResponse> callable,
                ListVehiclesRequest request,
                ApiCallContext context,
                ApiFuture<ListVehiclesResponse> futureResponse) {
              PageContext<ListVehiclesRequest, ListVehiclesResponse, Vehicle> pageContext =
                  PageContext.create(callable, LIST_VEHICLES_PAGE_STR_DESC, request, context);
              return ListVehiclesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createVehicle. */
  public UnaryCallSettings<CreateVehicleRequest, Vehicle> createVehicleSettings() {
    return createVehicleSettings;
  }

  /** Returns the object with the settings used for calls to getVehicle. */
  public UnaryCallSettings<GetVehicleRequest, Vehicle> getVehicleSettings() {
    return getVehicleSettings;
  }

  /** Returns the object with the settings used for calls to deleteVehicle. */
  public UnaryCallSettings<DeleteVehicleRequest, Empty> deleteVehicleSettings() {
    return deleteVehicleSettings;
  }

  /** Returns the object with the settings used for calls to updateVehicle. */
  public UnaryCallSettings<UpdateVehicleRequest, Vehicle> updateVehicleSettings() {
    return updateVehicleSettings;
  }

  /** Returns the object with the settings used for calls to updateVehicleAttributes. */
  public UnaryCallSettings<UpdateVehicleAttributesRequest, UpdateVehicleAttributesResponse>
      updateVehicleAttributesSettings() {
    return updateVehicleAttributesSettings;
  }

  /** Returns the object with the settings used for calls to listVehicles. */
  public PagedCallSettings<ListVehiclesRequest, ListVehiclesResponse, ListVehiclesPagedResponse>
      listVehiclesSettings() {
    return listVehiclesSettings;
  }

  /** Returns the object with the settings used for calls to searchVehicles. */
  public UnaryCallSettings<SearchVehiclesRequest, SearchVehiclesResponse> searchVehiclesSettings() {
    return searchVehiclesSettings;
  }

  public VehicleServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcVehicleServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "fleetengine";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "fleetengine.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "fleetengine.mtls.googleapis.com:443";
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
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(VehicleServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
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

  protected VehicleServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createVehicleSettings = settingsBuilder.createVehicleSettings().build();
    getVehicleSettings = settingsBuilder.getVehicleSettings().build();
    deleteVehicleSettings = settingsBuilder.deleteVehicleSettings().build();
    updateVehicleSettings = settingsBuilder.updateVehicleSettings().build();
    updateVehicleAttributesSettings = settingsBuilder.updateVehicleAttributesSettings().build();
    listVehiclesSettings = settingsBuilder.listVehiclesSettings().build();
    searchVehiclesSettings = settingsBuilder.searchVehiclesSettings().build();
  }

  /** Builder for VehicleServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<VehicleServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateVehicleRequest, Vehicle> createVehicleSettings;
    private final UnaryCallSettings.Builder<GetVehicleRequest, Vehicle> getVehicleSettings;
    private final UnaryCallSettings.Builder<DeleteVehicleRequest, Empty> deleteVehicleSettings;
    private final UnaryCallSettings.Builder<UpdateVehicleRequest, Vehicle> updateVehicleSettings;
    private final UnaryCallSettings.Builder<
            UpdateVehicleAttributesRequest, UpdateVehicleAttributesResponse>
        updateVehicleAttributesSettings;
    private final PagedCallSettings.Builder<
            ListVehiclesRequest, ListVehiclesResponse, ListVehiclesPagedResponse>
        listVehiclesSettings;
    private final UnaryCallSettings.Builder<SearchVehiclesRequest, SearchVehiclesResponse>
        searchVehiclesSettings;
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
              .setInitialRpcTimeoutDuration(Duration.ofMillis(15000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(15000L))
              .setTotalTimeoutDuration(Duration.ofMillis(15000L))
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

      createVehicleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getVehicleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteVehicleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateVehicleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateVehicleAttributesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listVehiclesSettings = PagedCallSettings.newBuilder(LIST_VEHICLES_PAGE_STR_FACT);
      searchVehiclesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createVehicleSettings,
              getVehicleSettings,
              deleteVehicleSettings,
              updateVehicleSettings,
              updateVehicleAttributesSettings,
              listVehiclesSettings,
              searchVehiclesSettings);
      initDefaults(this);
    }

    protected Builder(VehicleServiceStubSettings settings) {
      super(settings);

      createVehicleSettings = settings.createVehicleSettings.toBuilder();
      getVehicleSettings = settings.getVehicleSettings.toBuilder();
      deleteVehicleSettings = settings.deleteVehicleSettings.toBuilder();
      updateVehicleSettings = settings.updateVehicleSettings.toBuilder();
      updateVehicleAttributesSettings = settings.updateVehicleAttributesSettings.toBuilder();
      listVehiclesSettings = settings.listVehiclesSettings.toBuilder();
      searchVehiclesSettings = settings.searchVehiclesSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createVehicleSettings,
              getVehicleSettings,
              deleteVehicleSettings,
              updateVehicleSettings,
              updateVehicleAttributesSettings,
              listVehiclesSettings,
              searchVehiclesSettings);
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
          .createVehicleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getVehicleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteVehicleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateVehicleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateVehicleAttributesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listVehiclesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .searchVehiclesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

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

    /** Returns the builder for the settings used for calls to createVehicle. */
    public UnaryCallSettings.Builder<CreateVehicleRequest, Vehicle> createVehicleSettings() {
      return createVehicleSettings;
    }

    /** Returns the builder for the settings used for calls to getVehicle. */
    public UnaryCallSettings.Builder<GetVehicleRequest, Vehicle> getVehicleSettings() {
      return getVehicleSettings;
    }

    /** Returns the builder for the settings used for calls to deleteVehicle. */
    public UnaryCallSettings.Builder<DeleteVehicleRequest, Empty> deleteVehicleSettings() {
      return deleteVehicleSettings;
    }

    /** Returns the builder for the settings used for calls to updateVehicle. */
    public UnaryCallSettings.Builder<UpdateVehicleRequest, Vehicle> updateVehicleSettings() {
      return updateVehicleSettings;
    }

    /** Returns the builder for the settings used for calls to updateVehicleAttributes. */
    public UnaryCallSettings.Builder<
            UpdateVehicleAttributesRequest, UpdateVehicleAttributesResponse>
        updateVehicleAttributesSettings() {
      return updateVehicleAttributesSettings;
    }

    /** Returns the builder for the settings used for calls to listVehicles. */
    public PagedCallSettings.Builder<
            ListVehiclesRequest, ListVehiclesResponse, ListVehiclesPagedResponse>
        listVehiclesSettings() {
      return listVehiclesSettings;
    }

    /** Returns the builder for the settings used for calls to searchVehicles. */
    public UnaryCallSettings.Builder<SearchVehiclesRequest, SearchVehiclesResponse>
        searchVehiclesSettings() {
      return searchVehiclesSettings;
    }

    @Override
    public VehicleServiceStubSettings build() throws IOException {
      return new VehicleServiceStubSettings(this);
    }
  }
}
