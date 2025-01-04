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

package com.google.cloud.commerce.consumer.procurement.v1.stub;

import static com.google.cloud.commerce.consumer.procurement.v1.LicenseManagementServiceClient.EnumerateLicensedUsersPagedResponse;

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
import com.google.cloud.commerce.consumer.procurement.v1.AssignRequest;
import com.google.cloud.commerce.consumer.procurement.v1.AssignResponse;
import com.google.cloud.commerce.consumer.procurement.v1.EnumerateLicensedUsersRequest;
import com.google.cloud.commerce.consumer.procurement.v1.EnumerateLicensedUsersResponse;
import com.google.cloud.commerce.consumer.procurement.v1.GetLicensePoolRequest;
import com.google.cloud.commerce.consumer.procurement.v1.LicensePool;
import com.google.cloud.commerce.consumer.procurement.v1.LicensedUser;
import com.google.cloud.commerce.consumer.procurement.v1.UnassignRequest;
import com.google.cloud.commerce.consumer.procurement.v1.UnassignResponse;
import com.google.cloud.commerce.consumer.procurement.v1.UpdateLicensePoolRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link LicenseManagementServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (cloudcommerceconsumerprocurement.googleapis.com) and default
 *       port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getLicensePool:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * LicenseManagementServiceStubSettings.Builder licenseManagementServiceSettingsBuilder =
 *     LicenseManagementServiceStubSettings.newBuilder();
 * licenseManagementServiceSettingsBuilder
 *     .getLicensePoolSettings()
 *     .setRetrySettings(
 *         licenseManagementServiceSettingsBuilder
 *             .getLicensePoolSettings()
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
 * LicenseManagementServiceStubSettings licenseManagementServiceSettings =
 *     licenseManagementServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 */
@Generated("by gapic-generator-java")
public class LicenseManagementServiceStubSettings
    extends StubSettings<LicenseManagementServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<GetLicensePoolRequest, LicensePool> getLicensePoolSettings;
  private final UnaryCallSettings<UpdateLicensePoolRequest, LicensePool> updateLicensePoolSettings;
  private final UnaryCallSettings<AssignRequest, AssignResponse> assignSettings;
  private final UnaryCallSettings<UnassignRequest, UnassignResponse> unassignSettings;
  private final PagedCallSettings<
          EnumerateLicensedUsersRequest,
          EnumerateLicensedUsersResponse,
          EnumerateLicensedUsersPagedResponse>
      enumerateLicensedUsersSettings;

  private static final PagedListDescriptor<
          EnumerateLicensedUsersRequest, EnumerateLicensedUsersResponse, LicensedUser>
      ENUMERATE_LICENSED_USERS_PAGE_STR_DESC =
          new PagedListDescriptor<
              EnumerateLicensedUsersRequest, EnumerateLicensedUsersResponse, LicensedUser>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public EnumerateLicensedUsersRequest injectToken(
                EnumerateLicensedUsersRequest payload, String token) {
              return EnumerateLicensedUsersRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public EnumerateLicensedUsersRequest injectPageSize(
                EnumerateLicensedUsersRequest payload, int pageSize) {
              return EnumerateLicensedUsersRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(EnumerateLicensedUsersRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(EnumerateLicensedUsersResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<LicensedUser> extractResources(EnumerateLicensedUsersResponse payload) {
              return payload.getLicensedUsersList();
            }
          };

  private static final PagedListResponseFactory<
          EnumerateLicensedUsersRequest,
          EnumerateLicensedUsersResponse,
          EnumerateLicensedUsersPagedResponse>
      ENUMERATE_LICENSED_USERS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              EnumerateLicensedUsersRequest,
              EnumerateLicensedUsersResponse,
              EnumerateLicensedUsersPagedResponse>() {
            @Override
            public ApiFuture<EnumerateLicensedUsersPagedResponse> getFuturePagedResponse(
                UnaryCallable<EnumerateLicensedUsersRequest, EnumerateLicensedUsersResponse>
                    callable,
                EnumerateLicensedUsersRequest request,
                ApiCallContext context,
                ApiFuture<EnumerateLicensedUsersResponse> futureResponse) {
              PageContext<
                      EnumerateLicensedUsersRequest, EnumerateLicensedUsersResponse, LicensedUser>
                  pageContext =
                      PageContext.create(
                          callable, ENUMERATE_LICENSED_USERS_PAGE_STR_DESC, request, context);
              return EnumerateLicensedUsersPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to getLicensePool. */
  public UnaryCallSettings<GetLicensePoolRequest, LicensePool> getLicensePoolSettings() {
    return getLicensePoolSettings;
  }

  /** Returns the object with the settings used for calls to updateLicensePool. */
  public UnaryCallSettings<UpdateLicensePoolRequest, LicensePool> updateLicensePoolSettings() {
    return updateLicensePoolSettings;
  }

  /** Returns the object with the settings used for calls to assign. */
  public UnaryCallSettings<AssignRequest, AssignResponse> assignSettings() {
    return assignSettings;
  }

  /** Returns the object with the settings used for calls to unassign. */
  public UnaryCallSettings<UnassignRequest, UnassignResponse> unassignSettings() {
    return unassignSettings;
  }

  /** Returns the object with the settings used for calls to enumerateLicensedUsers. */
  public PagedCallSettings<
          EnumerateLicensedUsersRequest,
          EnumerateLicensedUsersResponse,
          EnumerateLicensedUsersPagedResponse>
      enumerateLicensedUsersSettings() {
    return enumerateLicensedUsersSettings;
  }

  public LicenseManagementServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcLicenseManagementServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonLicenseManagementServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "cloudcommerceconsumerprocurement";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "cloudcommerceconsumerprocurement.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "cloudcommerceconsumerprocurement.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(LicenseManagementServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(LicenseManagementServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return LicenseManagementServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected LicenseManagementServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getLicensePoolSettings = settingsBuilder.getLicensePoolSettings().build();
    updateLicensePoolSettings = settingsBuilder.updateLicensePoolSettings().build();
    assignSettings = settingsBuilder.assignSettings().build();
    unassignSettings = settingsBuilder.unassignSettings().build();
    enumerateLicensedUsersSettings = settingsBuilder.enumerateLicensedUsersSettings().build();
  }

  /** Builder for LicenseManagementServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<LicenseManagementServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetLicensePoolRequest, LicensePool>
        getLicensePoolSettings;
    private final UnaryCallSettings.Builder<UpdateLicensePoolRequest, LicensePool>
        updateLicensePoolSettings;
    private final UnaryCallSettings.Builder<AssignRequest, AssignResponse> assignSettings;
    private final UnaryCallSettings.Builder<UnassignRequest, UnassignResponse> unassignSettings;
    private final PagedCallSettings.Builder<
            EnumerateLicensedUsersRequest,
            EnumerateLicensedUsersResponse,
            EnumerateLicensedUsersPagedResponse>
        enumerateLicensedUsersSettings;
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

      getLicensePoolSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateLicensePoolSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      assignSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      unassignSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      enumerateLicensedUsersSettings =
          PagedCallSettings.newBuilder(ENUMERATE_LICENSED_USERS_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getLicensePoolSettings,
              updateLicensePoolSettings,
              assignSettings,
              unassignSettings,
              enumerateLicensedUsersSettings);
      initDefaults(this);
    }

    protected Builder(LicenseManagementServiceStubSettings settings) {
      super(settings);

      getLicensePoolSettings = settings.getLicensePoolSettings.toBuilder();
      updateLicensePoolSettings = settings.updateLicensePoolSettings.toBuilder();
      assignSettings = settings.assignSettings.toBuilder();
      unassignSettings = settings.unassignSettings.toBuilder();
      enumerateLicensedUsersSettings = settings.enumerateLicensedUsersSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getLicensePoolSettings,
              updateLicensePoolSettings,
              assignSettings,
              unassignSettings,
              enumerateLicensedUsersSettings);
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
          .getLicensePoolSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateLicensePoolSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .assignSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .unassignSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .enumerateLicensedUsersSettings()
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

    /** Returns the builder for the settings used for calls to getLicensePool. */
    public UnaryCallSettings.Builder<GetLicensePoolRequest, LicensePool> getLicensePoolSettings() {
      return getLicensePoolSettings;
    }

    /** Returns the builder for the settings used for calls to updateLicensePool. */
    public UnaryCallSettings.Builder<UpdateLicensePoolRequest, LicensePool>
        updateLicensePoolSettings() {
      return updateLicensePoolSettings;
    }

    /** Returns the builder for the settings used for calls to assign. */
    public UnaryCallSettings.Builder<AssignRequest, AssignResponse> assignSettings() {
      return assignSettings;
    }

    /** Returns the builder for the settings used for calls to unassign. */
    public UnaryCallSettings.Builder<UnassignRequest, UnassignResponse> unassignSettings() {
      return unassignSettings;
    }

    /** Returns the builder for the settings used for calls to enumerateLicensedUsers. */
    public PagedCallSettings.Builder<
            EnumerateLicensedUsersRequest,
            EnumerateLicensedUsersResponse,
            EnumerateLicensedUsersPagedResponse>
        enumerateLicensedUsersSettings() {
      return enumerateLicensedUsersSettings;
    }

    @Override
    public LicenseManagementServiceStubSettings build() throws IOException {
      return new LicenseManagementServiceStubSettings(this);
    }
  }
}
