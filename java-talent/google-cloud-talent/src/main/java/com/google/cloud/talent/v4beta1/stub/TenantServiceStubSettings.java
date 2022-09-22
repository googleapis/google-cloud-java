/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.talent.v4beta1.stub;

import static com.google.cloud.talent.v4beta1.TenantServiceClient.ListTenantsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
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
import com.google.cloud.talent.v4beta1.CreateTenantRequest;
import com.google.cloud.talent.v4beta1.DeleteTenantRequest;
import com.google.cloud.talent.v4beta1.GetTenantRequest;
import com.google.cloud.talent.v4beta1.ListTenantsRequest;
import com.google.cloud.talent.v4beta1.ListTenantsResponse;
import com.google.cloud.talent.v4beta1.Tenant;
import com.google.cloud.talent.v4beta1.UpdateTenantRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link TenantServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (jobs.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createTenant to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * TenantServiceStubSettings.Builder tenantServiceSettingsBuilder =
 *     TenantServiceStubSettings.newBuilder();
 * tenantServiceSettingsBuilder
 *     .createTenantSettings()
 *     .setRetrySettings(
 *         tenantServiceSettingsBuilder.createTenantSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * TenantServiceStubSettings tenantServiceSettings = tenantServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class TenantServiceStubSettings extends StubSettings<TenantServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/jobs")
          .build();

  private final UnaryCallSettings<CreateTenantRequest, Tenant> createTenantSettings;
  private final UnaryCallSettings<GetTenantRequest, Tenant> getTenantSettings;
  private final UnaryCallSettings<UpdateTenantRequest, Tenant> updateTenantSettings;
  private final UnaryCallSettings<DeleteTenantRequest, Empty> deleteTenantSettings;
  private final PagedCallSettings<ListTenantsRequest, ListTenantsResponse, ListTenantsPagedResponse>
      listTenantsSettings;

  private static final PagedListDescriptor<ListTenantsRequest, ListTenantsResponse, Tenant>
      LIST_TENANTS_PAGE_STR_DESC =
          new PagedListDescriptor<ListTenantsRequest, ListTenantsResponse, Tenant>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListTenantsRequest injectToken(ListTenantsRequest payload, String token) {
              return ListTenantsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListTenantsRequest injectPageSize(ListTenantsRequest payload, int pageSize) {
              return ListTenantsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListTenantsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListTenantsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Tenant> extractResources(ListTenantsResponse payload) {
              return payload.getTenantsList() == null
                  ? ImmutableList.<Tenant>of()
                  : payload.getTenantsList();
            }
          };

  private static final PagedListResponseFactory<
          ListTenantsRequest, ListTenantsResponse, ListTenantsPagedResponse>
      LIST_TENANTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListTenantsRequest, ListTenantsResponse, ListTenantsPagedResponse>() {
            @Override
            public ApiFuture<ListTenantsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListTenantsRequest, ListTenantsResponse> callable,
                ListTenantsRequest request,
                ApiCallContext context,
                ApiFuture<ListTenantsResponse> futureResponse) {
              PageContext<ListTenantsRequest, ListTenantsResponse, Tenant> pageContext =
                  PageContext.create(callable, LIST_TENANTS_PAGE_STR_DESC, request, context);
              return ListTenantsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createTenant. */
  public UnaryCallSettings<CreateTenantRequest, Tenant> createTenantSettings() {
    return createTenantSettings;
  }

  /** Returns the object with the settings used for calls to getTenant. */
  public UnaryCallSettings<GetTenantRequest, Tenant> getTenantSettings() {
    return getTenantSettings;
  }

  /** Returns the object with the settings used for calls to updateTenant. */
  public UnaryCallSettings<UpdateTenantRequest, Tenant> updateTenantSettings() {
    return updateTenantSettings;
  }

  /** Returns the object with the settings used for calls to deleteTenant. */
  public UnaryCallSettings<DeleteTenantRequest, Empty> deleteTenantSettings() {
    return deleteTenantSettings;
  }

  /** Returns the object with the settings used for calls to listTenants. */
  public PagedCallSettings<ListTenantsRequest, ListTenantsResponse, ListTenantsPagedResponse>
      listTenantsSettings() {
    return listTenantsSettings;
  }

  public TenantServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcTenantServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonTenantServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "jobs.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "jobs.mtls.googleapis.com:443";
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

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultGrpcApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(TenantServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(TenantServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return TenantServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected TenantServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createTenantSettings = settingsBuilder.createTenantSettings().build();
    getTenantSettings = settingsBuilder.getTenantSettings().build();
    updateTenantSettings = settingsBuilder.updateTenantSettings().build();
    deleteTenantSettings = settingsBuilder.deleteTenantSettings().build();
    listTenantsSettings = settingsBuilder.listTenantsSettings().build();
  }

  /** Builder for TenantServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<TenantServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateTenantRequest, Tenant> createTenantSettings;
    private final UnaryCallSettings.Builder<GetTenantRequest, Tenant> getTenantSettings;
    private final UnaryCallSettings.Builder<UpdateTenantRequest, Tenant> updateTenantSettings;
    private final UnaryCallSettings.Builder<DeleteTenantRequest, Empty> deleteTenantSettings;
    private final PagedCallSettings.Builder<
            ListTenantsRequest, ListTenantsResponse, ListTenantsPagedResponse>
        listTenantsSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "no_retry_7_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(30000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(30000L))
              .setTotalTimeout(Duration.ofMillis(30000L))
              .build();
      definitions.put("no_retry_7_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(30000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(30000L))
              .setTotalTimeout(Duration.ofMillis(30000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createTenantSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getTenantSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateTenantSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteTenantSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listTenantsSettings = PagedCallSettings.newBuilder(LIST_TENANTS_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createTenantSettings,
              getTenantSettings,
              updateTenantSettings,
              deleteTenantSettings,
              listTenantsSettings);
      initDefaults(this);
    }

    protected Builder(TenantServiceStubSettings settings) {
      super(settings);

      createTenantSettings = settings.createTenantSettings.toBuilder();
      getTenantSettings = settings.getTenantSettings.toBuilder();
      updateTenantSettings = settings.updateTenantSettings.toBuilder();
      deleteTenantSettings = settings.deleteTenantSettings.toBuilder();
      listTenantsSettings = settings.listTenantsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createTenantSettings,
              getTenantSettings,
              updateTenantSettings,
              deleteTenantSettings,
              listTenantsSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder createHttpJsonDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultHttpJsonTransportProviderBuilder().build());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultHttpJsonApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .createTenantSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_7_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_7_params"));

      builder
          .getTenantSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateTenantSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_7_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_7_params"));

      builder
          .deleteTenantSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listTenantsSettings()
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

    /** Returns the builder for the settings used for calls to createTenant. */
    public UnaryCallSettings.Builder<CreateTenantRequest, Tenant> createTenantSettings() {
      return createTenantSettings;
    }

    /** Returns the builder for the settings used for calls to getTenant. */
    public UnaryCallSettings.Builder<GetTenantRequest, Tenant> getTenantSettings() {
      return getTenantSettings;
    }

    /** Returns the builder for the settings used for calls to updateTenant. */
    public UnaryCallSettings.Builder<UpdateTenantRequest, Tenant> updateTenantSettings() {
      return updateTenantSettings;
    }

    /** Returns the builder for the settings used for calls to deleteTenant. */
    public UnaryCallSettings.Builder<DeleteTenantRequest, Empty> deleteTenantSettings() {
      return deleteTenantSettings;
    }

    /** Returns the builder for the settings used for calls to listTenants. */
    public PagedCallSettings.Builder<
            ListTenantsRequest, ListTenantsResponse, ListTenantsPagedResponse>
        listTenantsSettings() {
      return listTenantsSettings;
    }

    @Override
    public TenantServiceStubSettings build() throws IOException {
      return new TenantServiceStubSettings(this);
    }
  }
}
