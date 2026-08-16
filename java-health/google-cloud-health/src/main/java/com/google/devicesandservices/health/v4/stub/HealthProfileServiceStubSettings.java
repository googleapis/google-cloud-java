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

package com.google.devicesandservices.health.v4.stub;

import static com.google.devicesandservices.health.v4.HealthProfileServiceClient.ListPairedDevicesPagedResponse;

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
import com.google.api.gax.rpc.LibraryMetadata;
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
import com.google.devicesandservices.health.v4.GetIdentityRequest;
import com.google.devicesandservices.health.v4.GetIrnProfileRequest;
import com.google.devicesandservices.health.v4.GetPairedDeviceRequest;
import com.google.devicesandservices.health.v4.GetProfileRequest;
import com.google.devicesandservices.health.v4.GetSettingsRequest;
import com.google.devicesandservices.health.v4.Identity;
import com.google.devicesandservices.health.v4.IrnProfile;
import com.google.devicesandservices.health.v4.ListPairedDevicesRequest;
import com.google.devicesandservices.health.v4.ListPairedDevicesResponse;
import com.google.devicesandservices.health.v4.PairedDevice;
import com.google.devicesandservices.health.v4.Profile;
import com.google.devicesandservices.health.v4.Settings;
import com.google.devicesandservices.health.v4.UpdateProfileRequest;
import com.google.devicesandservices.health.v4.UpdateSettingsRequest;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link HealthProfileServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (health.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getProfile:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * HealthProfileServiceStubSettings.Builder healthProfileServiceSettingsBuilder =
 *     HealthProfileServiceStubSettings.newBuilder();
 * healthProfileServiceSettingsBuilder
 *     .getProfileSettings()
 *     .setRetrySettings(
 *         healthProfileServiceSettingsBuilder
 *             .getProfileSettings()
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
 * HealthProfileServiceStubSettings healthProfileServiceSettings =
 *     healthProfileServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@NullMarked
@Generated("by gapic-generator-java")
@SuppressWarnings("CanonicalDuration")
public class HealthProfileServiceStubSettings
    extends StubSettings<HealthProfileServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/googlehealth.activity_and_fitness.readonly")
          .add("https://www.googleapis.com/auth/googlehealth.ecg.readonly")
          .add(
              "https://www.googleapis.com/auth/googlehealth.health_metrics_and_measurements.readonly")
          .add("https://www.googleapis.com/auth/googlehealth.irn.readonly")
          .add("https://www.googleapis.com/auth/googlehealth.profile.readonly")
          .add("https://www.googleapis.com/auth/googlehealth.settings.readonly")
          .add("https://www.googleapis.com/auth/googlehealth.sleep.readonly")
          .build();

  private final UnaryCallSettings<GetProfileRequest, Profile> getProfileSettings;
  private final UnaryCallSettings<UpdateProfileRequest, Profile> updateProfileSettings;
  private final UnaryCallSettings<GetSettingsRequest, Settings> getSettingsSettings;
  private final UnaryCallSettings<UpdateSettingsRequest, Settings> updateSettingsSettings;
  private final UnaryCallSettings<GetIdentityRequest, Identity> getIdentitySettings;
  private final UnaryCallSettings<GetIrnProfileRequest, IrnProfile> getIrnProfileSettings;
  private final UnaryCallSettings<GetPairedDeviceRequest, PairedDevice> getPairedDeviceSettings;
  private final PagedCallSettings<
          ListPairedDevicesRequest, ListPairedDevicesResponse, ListPairedDevicesPagedResponse>
      listPairedDevicesSettings;

  private static final PagedListDescriptor<
          ListPairedDevicesRequest, ListPairedDevicesResponse, PairedDevice>
      LIST_PAIRED_DEVICES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListPairedDevicesRequest, ListPairedDevicesResponse, PairedDevice>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListPairedDevicesRequest injectToken(
                ListPairedDevicesRequest payload, String token) {
              return ListPairedDevicesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListPairedDevicesRequest injectPageSize(
                ListPairedDevicesRequest payload, int pageSize) {
              return ListPairedDevicesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListPairedDevicesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListPairedDevicesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<PairedDevice> extractResources(ListPairedDevicesResponse payload) {
              return payload.getPairedDevicesList();
            }
          };

  private static final PagedListResponseFactory<
          ListPairedDevicesRequest, ListPairedDevicesResponse, ListPairedDevicesPagedResponse>
      LIST_PAIRED_DEVICES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListPairedDevicesRequest,
              ListPairedDevicesResponse,
              ListPairedDevicesPagedResponse>() {
            @Override
            public ApiFuture<ListPairedDevicesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListPairedDevicesRequest, ListPairedDevicesResponse> callable,
                ListPairedDevicesRequest request,
                ApiCallContext context,
                ApiFuture<ListPairedDevicesResponse> futureResponse) {
              PageContext<ListPairedDevicesRequest, ListPairedDevicesResponse, PairedDevice>
                  pageContext =
                      PageContext.create(
                          callable, LIST_PAIRED_DEVICES_PAGE_STR_DESC, request, context);
              return ListPairedDevicesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to getProfile. */
  public UnaryCallSettings<GetProfileRequest, Profile> getProfileSettings() {
    return getProfileSettings;
  }

  /** Returns the object with the settings used for calls to updateProfile. */
  public UnaryCallSettings<UpdateProfileRequest, Profile> updateProfileSettings() {
    return updateProfileSettings;
  }

  /** Returns the object with the settings used for calls to getSettings. */
  public UnaryCallSettings<GetSettingsRequest, Settings> getSettingsSettings() {
    return getSettingsSettings;
  }

  /** Returns the object with the settings used for calls to updateSettings. */
  public UnaryCallSettings<UpdateSettingsRequest, Settings> updateSettingsSettings() {
    return updateSettingsSettings;
  }

  /** Returns the object with the settings used for calls to getIdentity. */
  public UnaryCallSettings<GetIdentityRequest, Identity> getIdentitySettings() {
    return getIdentitySettings;
  }

  /** Returns the object with the settings used for calls to getIrnProfile. */
  public UnaryCallSettings<GetIrnProfileRequest, IrnProfile> getIrnProfileSettings() {
    return getIrnProfileSettings;
  }

  /** Returns the object with the settings used for calls to getPairedDevice. */
  public UnaryCallSettings<GetPairedDeviceRequest, PairedDevice> getPairedDeviceSettings() {
    return getPairedDeviceSettings;
  }

  /** Returns the object with the settings used for calls to listPairedDevices. */
  public PagedCallSettings<
          ListPairedDevicesRequest, ListPairedDevicesResponse, ListPairedDevicesPagedResponse>
      listPairedDevicesSettings() {
    return listPairedDevicesSettings;
  }

  public HealthProfileServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcHealthProfileServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonHealthProfileServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "health";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "health.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "health.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(HealthProfileServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(HealthProfileServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return HealthProfileServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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
  public static Builder newBuilder(@Nullable ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected HealthProfileServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getProfileSettings = settingsBuilder.getProfileSettings().build();
    updateProfileSettings = settingsBuilder.updateProfileSettings().build();
    getSettingsSettings = settingsBuilder.getSettingsSettings().build();
    updateSettingsSettings = settingsBuilder.updateSettingsSettings().build();
    getIdentitySettings = settingsBuilder.getIdentitySettings().build();
    getIrnProfileSettings = settingsBuilder.getIrnProfileSettings().build();
    getPairedDeviceSettings = settingsBuilder.getPairedDeviceSettings().build();
    listPairedDevicesSettings = settingsBuilder.listPairedDevicesSettings().build();
  }

  @Override
  protected LibraryMetadata getLibraryMetadata() {
    return LibraryMetadata.newBuilder()
        .setArtifactName("com.google.cloud:google-cloud-health")
        .setRepository("googleapis/google-cloud-java")
        .setVersion(Version.VERSION)
        .build();
  }

  /** Builder for HealthProfileServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<HealthProfileServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetProfileRequest, Profile> getProfileSettings;
    private final UnaryCallSettings.Builder<UpdateProfileRequest, Profile> updateProfileSettings;
    private final UnaryCallSettings.Builder<GetSettingsRequest, Settings> getSettingsSettings;
    private final UnaryCallSettings.Builder<UpdateSettingsRequest, Settings> updateSettingsSettings;
    private final UnaryCallSettings.Builder<GetIdentityRequest, Identity> getIdentitySettings;
    private final UnaryCallSettings.Builder<GetIrnProfileRequest, IrnProfile> getIrnProfileSettings;
    private final UnaryCallSettings.Builder<GetPairedDeviceRequest, PairedDevice>
        getPairedDeviceSettings;
    private final PagedCallSettings.Builder<
            ListPairedDevicesRequest, ListPairedDevicesResponse, ListPairedDevicesPagedResponse>
        listPairedDevicesSettings;
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

    protected Builder(@Nullable ClientContext clientContext) {
      super(clientContext);

      getProfileSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateProfileSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getSettingsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateSettingsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIdentitySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIrnProfileSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getPairedDeviceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listPairedDevicesSettings = PagedCallSettings.newBuilder(LIST_PAIRED_DEVICES_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getProfileSettings,
              updateProfileSettings,
              getSettingsSettings,
              updateSettingsSettings,
              getIdentitySettings,
              getIrnProfileSettings,
              getPairedDeviceSettings,
              listPairedDevicesSettings);
      initDefaults(this);
    }

    protected Builder(HealthProfileServiceStubSettings settings) {
      super(settings);

      getProfileSettings = settings.getProfileSettings.toBuilder();
      updateProfileSettings = settings.updateProfileSettings.toBuilder();
      getSettingsSettings = settings.getSettingsSettings.toBuilder();
      updateSettingsSettings = settings.updateSettingsSettings.toBuilder();
      getIdentitySettings = settings.getIdentitySettings.toBuilder();
      getIrnProfileSettings = settings.getIrnProfileSettings.toBuilder();
      getPairedDeviceSettings = settings.getPairedDeviceSettings.toBuilder();
      listPairedDevicesSettings = settings.listPairedDevicesSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getProfileSettings,
              updateProfileSettings,
              getSettingsSettings,
              updateSettingsSettings,
              getIdentitySettings,
              getIrnProfileSettings,
              getPairedDeviceSettings,
              listPairedDevicesSettings);
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
          .getProfileSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateProfileSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getSettingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateSettingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getIdentitySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getIrnProfileSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getPairedDeviceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listPairedDevicesSettings()
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

    /** Returns the builder for the settings used for calls to getProfile. */
    public UnaryCallSettings.Builder<GetProfileRequest, Profile> getProfileSettings() {
      return getProfileSettings;
    }

    /** Returns the builder for the settings used for calls to updateProfile. */
    public UnaryCallSettings.Builder<UpdateProfileRequest, Profile> updateProfileSettings() {
      return updateProfileSettings;
    }

    /** Returns the builder for the settings used for calls to getSettings. */
    public UnaryCallSettings.Builder<GetSettingsRequest, Settings> getSettingsSettings() {
      return getSettingsSettings;
    }

    /** Returns the builder for the settings used for calls to updateSettings. */
    public UnaryCallSettings.Builder<UpdateSettingsRequest, Settings> updateSettingsSettings() {
      return updateSettingsSettings;
    }

    /** Returns the builder for the settings used for calls to getIdentity. */
    public UnaryCallSettings.Builder<GetIdentityRequest, Identity> getIdentitySettings() {
      return getIdentitySettings;
    }

    /** Returns the builder for the settings used for calls to getIrnProfile. */
    public UnaryCallSettings.Builder<GetIrnProfileRequest, IrnProfile> getIrnProfileSettings() {
      return getIrnProfileSettings;
    }

    /** Returns the builder for the settings used for calls to getPairedDevice. */
    public UnaryCallSettings.Builder<GetPairedDeviceRequest, PairedDevice>
        getPairedDeviceSettings() {
      return getPairedDeviceSettings;
    }

    /** Returns the builder for the settings used for calls to listPairedDevices. */
    public PagedCallSettings.Builder<
            ListPairedDevicesRequest, ListPairedDevicesResponse, ListPairedDevicesPagedResponse>
        listPairedDevicesSettings() {
      return listPairedDevicesSettings;
    }

    @Override
    public HealthProfileServiceStubSettings build() throws IOException {
      return new HealthProfileServiceStubSettings(this);
    }
  }
}
