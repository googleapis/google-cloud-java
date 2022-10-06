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

package com.google.cloud.securitycenter.settings.v1beta1.stub;

import static com.google.cloud.securitycenter.settings.v1beta1.SecurityCenterSettingsServiceClient.ListComponentsPagedResponse;
import static com.google.cloud.securitycenter.settings.v1beta1.SecurityCenterSettingsServiceClient.ListDetectorsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
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
import com.google.cloud.securitycenter.settings.v1beta1.BatchCalculateEffectiveSettingsRequest;
import com.google.cloud.securitycenter.settings.v1beta1.BatchCalculateEffectiveSettingsResponse;
import com.google.cloud.securitycenter.settings.v1beta1.BatchGetSettingsRequest;
import com.google.cloud.securitycenter.settings.v1beta1.BatchGetSettingsResponse;
import com.google.cloud.securitycenter.settings.v1beta1.CalculateEffectiveComponentSettingsRequest;
import com.google.cloud.securitycenter.settings.v1beta1.CalculateEffectiveSettingsRequest;
import com.google.cloud.securitycenter.settings.v1beta1.ComponentSettings;
import com.google.cloud.securitycenter.settings.v1beta1.Detector;
import com.google.cloud.securitycenter.settings.v1beta1.GetComponentSettingsRequest;
import com.google.cloud.securitycenter.settings.v1beta1.GetServiceAccountRequest;
import com.google.cloud.securitycenter.settings.v1beta1.GetSettingsRequest;
import com.google.cloud.securitycenter.settings.v1beta1.ListComponentsRequest;
import com.google.cloud.securitycenter.settings.v1beta1.ListComponentsResponse;
import com.google.cloud.securitycenter.settings.v1beta1.ListDetectorsRequest;
import com.google.cloud.securitycenter.settings.v1beta1.ListDetectorsResponse;
import com.google.cloud.securitycenter.settings.v1beta1.ResetComponentSettingsRequest;
import com.google.cloud.securitycenter.settings.v1beta1.ResetSettingsRequest;
import com.google.cloud.securitycenter.settings.v1beta1.ServiceAccount;
import com.google.cloud.securitycenter.settings.v1beta1.Settings;
import com.google.cloud.securitycenter.settings.v1beta1.UpdateComponentSettingsRequest;
import com.google.cloud.securitycenter.settings.v1beta1.UpdateSettingsRequest;
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
 * Settings class to configure an instance of {@link SecurityCenterSettingsServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (securitycenter.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getServiceAccount to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SecurityCenterSettingsServiceStubSettings.Builder securityCenterSettingsServiceSettingsBuilder =
 *     SecurityCenterSettingsServiceStubSettings.newBuilder();
 * securityCenterSettingsServiceSettingsBuilder
 *     .getServiceAccountSettings()
 *     .setRetrySettings(
 *         securityCenterSettingsServiceSettingsBuilder
 *             .getServiceAccountSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * SecurityCenterSettingsServiceStubSettings securityCenterSettingsServiceSettings =
 *     securityCenterSettingsServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class SecurityCenterSettingsServiceStubSettings
    extends StubSettings<SecurityCenterSettingsServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<GetServiceAccountRequest, ServiceAccount>
      getServiceAccountSettings;
  private final UnaryCallSettings<GetSettingsRequest, Settings> getSettingsSettings;
  private final UnaryCallSettings<UpdateSettingsRequest, Settings> updateSettingsSettings;
  private final UnaryCallSettings<ResetSettingsRequest, Empty> resetSettingsSettings;
  private final UnaryCallSettings<BatchGetSettingsRequest, BatchGetSettingsResponse>
      batchGetSettingsSettings;
  private final UnaryCallSettings<CalculateEffectiveSettingsRequest, Settings>
      calculateEffectiveSettingsSettings;
  private final UnaryCallSettings<
          BatchCalculateEffectiveSettingsRequest, BatchCalculateEffectiveSettingsResponse>
      batchCalculateEffectiveSettingsSettings;
  private final UnaryCallSettings<GetComponentSettingsRequest, ComponentSettings>
      getComponentSettingsSettings;
  private final UnaryCallSettings<UpdateComponentSettingsRequest, ComponentSettings>
      updateComponentSettingsSettings;
  private final UnaryCallSettings<ResetComponentSettingsRequest, Empty>
      resetComponentSettingsSettings;
  private final UnaryCallSettings<CalculateEffectiveComponentSettingsRequest, ComponentSettings>
      calculateEffectiveComponentSettingsSettings;
  private final PagedCallSettings<
          ListDetectorsRequest, ListDetectorsResponse, ListDetectorsPagedResponse>
      listDetectorsSettings;
  private final PagedCallSettings<
          ListComponentsRequest, ListComponentsResponse, ListComponentsPagedResponse>
      listComponentsSettings;

  private static final PagedListDescriptor<ListDetectorsRequest, ListDetectorsResponse, Detector>
      LIST_DETECTORS_PAGE_STR_DESC =
          new PagedListDescriptor<ListDetectorsRequest, ListDetectorsResponse, Detector>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDetectorsRequest injectToken(ListDetectorsRequest payload, String token) {
              return ListDetectorsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListDetectorsRequest injectPageSize(ListDetectorsRequest payload, int pageSize) {
              return ListDetectorsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListDetectorsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDetectorsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Detector> extractResources(ListDetectorsResponse payload) {
              return payload.getDetectorsList() == null
                  ? ImmutableList.<Detector>of()
                  : payload.getDetectorsList();
            }
          };

  private static final PagedListDescriptor<ListComponentsRequest, ListComponentsResponse, String>
      LIST_COMPONENTS_PAGE_STR_DESC =
          new PagedListDescriptor<ListComponentsRequest, ListComponentsResponse, String>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListComponentsRequest injectToken(ListComponentsRequest payload, String token) {
              return ListComponentsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListComponentsRequest injectPageSize(
                ListComponentsRequest payload, int pageSize) {
              return ListComponentsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListComponentsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListComponentsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<String> extractResources(ListComponentsResponse payload) {
              return payload.getComponentsList() == null
                  ? ImmutableList.<String>of()
                  : payload.getComponentsList();
            }
          };

  private static final PagedListResponseFactory<
          ListDetectorsRequest, ListDetectorsResponse, ListDetectorsPagedResponse>
      LIST_DETECTORS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDetectorsRequest, ListDetectorsResponse, ListDetectorsPagedResponse>() {
            @Override
            public ApiFuture<ListDetectorsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDetectorsRequest, ListDetectorsResponse> callable,
                ListDetectorsRequest request,
                ApiCallContext context,
                ApiFuture<ListDetectorsResponse> futureResponse) {
              PageContext<ListDetectorsRequest, ListDetectorsResponse, Detector> pageContext =
                  PageContext.create(callable, LIST_DETECTORS_PAGE_STR_DESC, request, context);
              return ListDetectorsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListComponentsRequest, ListComponentsResponse, ListComponentsPagedResponse>
      LIST_COMPONENTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListComponentsRequest, ListComponentsResponse, ListComponentsPagedResponse>() {
            @Override
            public ApiFuture<ListComponentsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListComponentsRequest, ListComponentsResponse> callable,
                ListComponentsRequest request,
                ApiCallContext context,
                ApiFuture<ListComponentsResponse> futureResponse) {
              PageContext<ListComponentsRequest, ListComponentsResponse, String> pageContext =
                  PageContext.create(callable, LIST_COMPONENTS_PAGE_STR_DESC, request, context);
              return ListComponentsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to getServiceAccount. */
  public UnaryCallSettings<GetServiceAccountRequest, ServiceAccount> getServiceAccountSettings() {
    return getServiceAccountSettings;
  }

  /** Returns the object with the settings used for calls to getSettings. */
  public UnaryCallSettings<GetSettingsRequest, Settings> getSettingsSettings() {
    return getSettingsSettings;
  }

  /** Returns the object with the settings used for calls to updateSettings. */
  public UnaryCallSettings<UpdateSettingsRequest, Settings> updateSettingsSettings() {
    return updateSettingsSettings;
  }

  /** Returns the object with the settings used for calls to resetSettings. */
  public UnaryCallSettings<ResetSettingsRequest, Empty> resetSettingsSettings() {
    return resetSettingsSettings;
  }

  /** Returns the object with the settings used for calls to batchGetSettings. */
  public UnaryCallSettings<BatchGetSettingsRequest, BatchGetSettingsResponse>
      batchGetSettingsSettings() {
    return batchGetSettingsSettings;
  }

  /** Returns the object with the settings used for calls to calculateEffectiveSettings. */
  public UnaryCallSettings<CalculateEffectiveSettingsRequest, Settings>
      calculateEffectiveSettingsSettings() {
    return calculateEffectiveSettingsSettings;
  }

  /** Returns the object with the settings used for calls to batchCalculateEffectiveSettings. */
  public UnaryCallSettings<
          BatchCalculateEffectiveSettingsRequest, BatchCalculateEffectiveSettingsResponse>
      batchCalculateEffectiveSettingsSettings() {
    return batchCalculateEffectiveSettingsSettings;
  }

  /** Returns the object with the settings used for calls to getComponentSettings. */
  public UnaryCallSettings<GetComponentSettingsRequest, ComponentSettings>
      getComponentSettingsSettings() {
    return getComponentSettingsSettings;
  }

  /** Returns the object with the settings used for calls to updateComponentSettings. */
  public UnaryCallSettings<UpdateComponentSettingsRequest, ComponentSettings>
      updateComponentSettingsSettings() {
    return updateComponentSettingsSettings;
  }

  /** Returns the object with the settings used for calls to resetComponentSettings. */
  public UnaryCallSettings<ResetComponentSettingsRequest, Empty> resetComponentSettingsSettings() {
    return resetComponentSettingsSettings;
  }

  /** Returns the object with the settings used for calls to calculateEffectiveComponentSettings. */
  public UnaryCallSettings<CalculateEffectiveComponentSettingsRequest, ComponentSettings>
      calculateEffectiveComponentSettingsSettings() {
    return calculateEffectiveComponentSettingsSettings;
  }

  /** Returns the object with the settings used for calls to listDetectors. */
  public PagedCallSettings<ListDetectorsRequest, ListDetectorsResponse, ListDetectorsPagedResponse>
      listDetectorsSettings() {
    return listDetectorsSettings;
  }

  /** Returns the object with the settings used for calls to listComponents. */
  public PagedCallSettings<
          ListComponentsRequest, ListComponentsResponse, ListComponentsPagedResponse>
      listComponentsSettings() {
    return listComponentsSettings;
  }

  public SecurityCenterSettingsServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcSecurityCenterSettingsServiceStub.create(this);
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
    return "securitycenter.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "securitycenter.mtls.googleapis.com:443";
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

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic",
            GaxProperties.getLibraryVersion(SecurityCenterSettingsServiceStubSettings.class))
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

  protected SecurityCenterSettingsServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getServiceAccountSettings = settingsBuilder.getServiceAccountSettings().build();
    getSettingsSettings = settingsBuilder.getSettingsSettings().build();
    updateSettingsSettings = settingsBuilder.updateSettingsSettings().build();
    resetSettingsSettings = settingsBuilder.resetSettingsSettings().build();
    batchGetSettingsSettings = settingsBuilder.batchGetSettingsSettings().build();
    calculateEffectiveSettingsSettings =
        settingsBuilder.calculateEffectiveSettingsSettings().build();
    batchCalculateEffectiveSettingsSettings =
        settingsBuilder.batchCalculateEffectiveSettingsSettings().build();
    getComponentSettingsSettings = settingsBuilder.getComponentSettingsSettings().build();
    updateComponentSettingsSettings = settingsBuilder.updateComponentSettingsSettings().build();
    resetComponentSettingsSettings = settingsBuilder.resetComponentSettingsSettings().build();
    calculateEffectiveComponentSettingsSettings =
        settingsBuilder.calculateEffectiveComponentSettingsSettings().build();
    listDetectorsSettings = settingsBuilder.listDetectorsSettings().build();
    listComponentsSettings = settingsBuilder.listComponentsSettings().build();
  }

  /** Builder for SecurityCenterSettingsServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<SecurityCenterSettingsServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetServiceAccountRequest, ServiceAccount>
        getServiceAccountSettings;
    private final UnaryCallSettings.Builder<GetSettingsRequest, Settings> getSettingsSettings;
    private final UnaryCallSettings.Builder<UpdateSettingsRequest, Settings> updateSettingsSettings;
    private final UnaryCallSettings.Builder<ResetSettingsRequest, Empty> resetSettingsSettings;
    private final UnaryCallSettings.Builder<BatchGetSettingsRequest, BatchGetSettingsResponse>
        batchGetSettingsSettings;
    private final UnaryCallSettings.Builder<CalculateEffectiveSettingsRequest, Settings>
        calculateEffectiveSettingsSettings;
    private final UnaryCallSettings.Builder<
            BatchCalculateEffectiveSettingsRequest, BatchCalculateEffectiveSettingsResponse>
        batchCalculateEffectiveSettingsSettings;
    private final UnaryCallSettings.Builder<GetComponentSettingsRequest, ComponentSettings>
        getComponentSettingsSettings;
    private final UnaryCallSettings.Builder<UpdateComponentSettingsRequest, ComponentSettings>
        updateComponentSettingsSettings;
    private final UnaryCallSettings.Builder<ResetComponentSettingsRequest, Empty>
        resetComponentSettingsSettings;
    private final UnaryCallSettings.Builder<
            CalculateEffectiveComponentSettingsRequest, ComponentSettings>
        calculateEffectiveComponentSettingsSettings;
    private final PagedCallSettings.Builder<
            ListDetectorsRequest, ListDetectorsResponse, ListDetectorsPagedResponse>
        listDetectorsSettings;
    private final PagedCallSettings.Builder<
            ListComponentsRequest, ListComponentsResponse, ListComponentsPagedResponse>
        listComponentsSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
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
              .setInitialRetryDelay(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(600000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(600000L))
              .setTotalTimeout(Duration.ofMillis(600000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      getServiceAccountSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getSettingsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateSettingsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      resetSettingsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchGetSettingsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      calculateEffectiveSettingsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchCalculateEffectiveSettingsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getComponentSettingsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateComponentSettingsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      resetComponentSettingsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      calculateEffectiveComponentSettingsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listDetectorsSettings = PagedCallSettings.newBuilder(LIST_DETECTORS_PAGE_STR_FACT);
      listComponentsSettings = PagedCallSettings.newBuilder(LIST_COMPONENTS_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getServiceAccountSettings,
              getSettingsSettings,
              updateSettingsSettings,
              resetSettingsSettings,
              batchGetSettingsSettings,
              calculateEffectiveSettingsSettings,
              batchCalculateEffectiveSettingsSettings,
              getComponentSettingsSettings,
              updateComponentSettingsSettings,
              resetComponentSettingsSettings,
              calculateEffectiveComponentSettingsSettings,
              listDetectorsSettings,
              listComponentsSettings);
      initDefaults(this);
    }

    protected Builder(SecurityCenterSettingsServiceStubSettings settings) {
      super(settings);

      getServiceAccountSettings = settings.getServiceAccountSettings.toBuilder();
      getSettingsSettings = settings.getSettingsSettings.toBuilder();
      updateSettingsSettings = settings.updateSettingsSettings.toBuilder();
      resetSettingsSettings = settings.resetSettingsSettings.toBuilder();
      batchGetSettingsSettings = settings.batchGetSettingsSettings.toBuilder();
      calculateEffectiveSettingsSettings = settings.calculateEffectiveSettingsSettings.toBuilder();
      batchCalculateEffectiveSettingsSettings =
          settings.batchCalculateEffectiveSettingsSettings.toBuilder();
      getComponentSettingsSettings = settings.getComponentSettingsSettings.toBuilder();
      updateComponentSettingsSettings = settings.updateComponentSettingsSettings.toBuilder();
      resetComponentSettingsSettings = settings.resetComponentSettingsSettings.toBuilder();
      calculateEffectiveComponentSettingsSettings =
          settings.calculateEffectiveComponentSettingsSettings.toBuilder();
      listDetectorsSettings = settings.listDetectorsSettings.toBuilder();
      listComponentsSettings = settings.listComponentsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getServiceAccountSettings,
              getSettingsSettings,
              updateSettingsSettings,
              resetSettingsSettings,
              batchGetSettingsSettings,
              calculateEffectiveSettingsSettings,
              batchCalculateEffectiveSettingsSettings,
              getComponentSettingsSettings,
              updateComponentSettingsSettings,
              resetComponentSettingsSettings,
              calculateEffectiveComponentSettingsSettings,
              listDetectorsSettings,
              listComponentsSettings);
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

    private static Builder initDefaults(Builder builder) {
      builder
          .getServiceAccountSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getSettingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateSettingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .resetSettingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .batchGetSettingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .calculateEffectiveSettingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .batchCalculateEffectiveSettingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getComponentSettingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateComponentSettingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .resetComponentSettingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .calculateEffectiveComponentSettingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listDetectorsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listComponentsSettings()
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

    /** Returns the builder for the settings used for calls to getServiceAccount. */
    public UnaryCallSettings.Builder<GetServiceAccountRequest, ServiceAccount>
        getServiceAccountSettings() {
      return getServiceAccountSettings;
    }

    /** Returns the builder for the settings used for calls to getSettings. */
    public UnaryCallSettings.Builder<GetSettingsRequest, Settings> getSettingsSettings() {
      return getSettingsSettings;
    }

    /** Returns the builder for the settings used for calls to updateSettings. */
    public UnaryCallSettings.Builder<UpdateSettingsRequest, Settings> updateSettingsSettings() {
      return updateSettingsSettings;
    }

    /** Returns the builder for the settings used for calls to resetSettings. */
    public UnaryCallSettings.Builder<ResetSettingsRequest, Empty> resetSettingsSettings() {
      return resetSettingsSettings;
    }

    /** Returns the builder for the settings used for calls to batchGetSettings. */
    public UnaryCallSettings.Builder<BatchGetSettingsRequest, BatchGetSettingsResponse>
        batchGetSettingsSettings() {
      return batchGetSettingsSettings;
    }

    /** Returns the builder for the settings used for calls to calculateEffectiveSettings. */
    public UnaryCallSettings.Builder<CalculateEffectiveSettingsRequest, Settings>
        calculateEffectiveSettingsSettings() {
      return calculateEffectiveSettingsSettings;
    }

    /** Returns the builder for the settings used for calls to batchCalculateEffectiveSettings. */
    public UnaryCallSettings.Builder<
            BatchCalculateEffectiveSettingsRequest, BatchCalculateEffectiveSettingsResponse>
        batchCalculateEffectiveSettingsSettings() {
      return batchCalculateEffectiveSettingsSettings;
    }

    /** Returns the builder for the settings used for calls to getComponentSettings. */
    public UnaryCallSettings.Builder<GetComponentSettingsRequest, ComponentSettings>
        getComponentSettingsSettings() {
      return getComponentSettingsSettings;
    }

    /** Returns the builder for the settings used for calls to updateComponentSettings. */
    public UnaryCallSettings.Builder<UpdateComponentSettingsRequest, ComponentSettings>
        updateComponentSettingsSettings() {
      return updateComponentSettingsSettings;
    }

    /** Returns the builder for the settings used for calls to resetComponentSettings. */
    public UnaryCallSettings.Builder<ResetComponentSettingsRequest, Empty>
        resetComponentSettingsSettings() {
      return resetComponentSettingsSettings;
    }

    /**
     * Returns the builder for the settings used for calls to calculateEffectiveComponentSettings.
     */
    public UnaryCallSettings.Builder<CalculateEffectiveComponentSettingsRequest, ComponentSettings>
        calculateEffectiveComponentSettingsSettings() {
      return calculateEffectiveComponentSettingsSettings;
    }

    /** Returns the builder for the settings used for calls to listDetectors. */
    public PagedCallSettings.Builder<
            ListDetectorsRequest, ListDetectorsResponse, ListDetectorsPagedResponse>
        listDetectorsSettings() {
      return listDetectorsSettings;
    }

    /** Returns the builder for the settings used for calls to listComponents. */
    public PagedCallSettings.Builder<
            ListComponentsRequest, ListComponentsResponse, ListComponentsPagedResponse>
        listComponentsSettings() {
      return listComponentsSettings;
    }

    @Override
    public SecurityCenterSettingsServiceStubSettings build() throws IOException {
      return new SecurityCenterSettingsServiceStubSettings(this);
    }
  }
}
