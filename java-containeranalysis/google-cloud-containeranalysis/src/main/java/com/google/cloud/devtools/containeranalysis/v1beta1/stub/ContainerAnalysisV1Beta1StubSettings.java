/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.devtools.containeranalysis.v1beta1.stub;

import static com.google.cloud.devtools.containeranalysis.v1beta1.ContainerAnalysisV1Beta1Client.ListScanConfigsPagedResponse;

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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.containeranalysis.v1beta1.GetScanConfigRequest;
import com.google.containeranalysis.v1beta1.ListScanConfigsRequest;
import com.google.containeranalysis.v1beta1.ListScanConfigsResponse;
import com.google.containeranalysis.v1beta1.ScanConfig;
import com.google.containeranalysis.v1beta1.UpdateScanConfigRequest;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link ContainerAnalysisV1Beta1Stub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (containeranalysis.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of setIamPolicy to 30 seconds:
 *
 * <pre>
 * <code>
 * ContainerAnalysisV1Beta1StubSettings.Builder containerAnalysisV1Beta1SettingsBuilder =
 *     ContainerAnalysisV1Beta1StubSettings.newBuilder();
 * containerAnalysisV1Beta1SettingsBuilder
 *     .setIamPolicySettings()
 *     .setRetrySettings(
 *         containerAnalysisV1Beta1SettingsBuilder.setIamPolicySettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ContainerAnalysisV1Beta1StubSettings containerAnalysisV1Beta1Settings = containerAnalysisV1Beta1SettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class ContainerAnalysisV1Beta1StubSettings
    extends StubSettings<ContainerAnalysisV1Beta1StubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;
  private final UnaryCallSettings<GetScanConfigRequest, ScanConfig> getScanConfigSettings;
  private final PagedCallSettings<
          ListScanConfigsRequest, ListScanConfigsResponse, ListScanConfigsPagedResponse>
      listScanConfigsSettings;
  private final UnaryCallSettings<UpdateScanConfigRequest, ScanConfig> updateScanConfigSettings;

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

  /** Returns the object with the settings used for calls to getScanConfig. */
  public UnaryCallSettings<GetScanConfigRequest, ScanConfig> getScanConfigSettings() {
    return getScanConfigSettings;
  }

  /** Returns the object with the settings used for calls to listScanConfigs. */
  public PagedCallSettings<
          ListScanConfigsRequest, ListScanConfigsResponse, ListScanConfigsPagedResponse>
      listScanConfigsSettings() {
    return listScanConfigsSettings;
  }

  /** Returns the object with the settings used for calls to updateScanConfig. */
  public UnaryCallSettings<UpdateScanConfigRequest, ScanConfig> updateScanConfigSettings() {
    return updateScanConfigSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public ContainerAnalysisV1Beta1Stub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcContainerAnalysisV1Beta1Stub.create(this);
    } else {
      throw new UnsupportedOperationException(
          "Transport not supported: " + getTransportChannelProvider().getTransportName());
    }
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "containeranalysis.googleapis.com:443";
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder().setScopesToApply(DEFAULT_SERVICE_SCOPES);
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
            "gapic", GaxProperties.getLibraryVersion(ContainerAnalysisV1Beta1StubSettings.class))
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

  protected ContainerAnalysisV1Beta1StubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
    getScanConfigSettings = settingsBuilder.getScanConfigSettings().build();
    listScanConfigsSettings = settingsBuilder.listScanConfigsSettings().build();
    updateScanConfigSettings = settingsBuilder.updateScanConfigSettings().build();
  }

  private static final PagedListDescriptor<
          ListScanConfigsRequest, ListScanConfigsResponse, ScanConfig>
      LIST_SCAN_CONFIGS_PAGE_STR_DESC =
          new PagedListDescriptor<ListScanConfigsRequest, ListScanConfigsResponse, ScanConfig>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListScanConfigsRequest injectToken(
                ListScanConfigsRequest payload, String token) {
              return ListScanConfigsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListScanConfigsRequest injectPageSize(
                ListScanConfigsRequest payload, int pageSize) {
              return ListScanConfigsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListScanConfigsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListScanConfigsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ScanConfig> extractResources(ListScanConfigsResponse payload) {
              return payload.getScanConfigsList() != null
                  ? payload.getScanConfigsList()
                  : ImmutableList.<ScanConfig>of();
            }
          };

  private static final PagedListResponseFactory<
          ListScanConfigsRequest, ListScanConfigsResponse, ListScanConfigsPagedResponse>
      LIST_SCAN_CONFIGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListScanConfigsRequest, ListScanConfigsResponse, ListScanConfigsPagedResponse>() {
            @Override
            public ApiFuture<ListScanConfigsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListScanConfigsRequest, ListScanConfigsResponse> callable,
                ListScanConfigsRequest request,
                ApiCallContext context,
                ApiFuture<ListScanConfigsResponse> futureResponse) {
              PageContext<ListScanConfigsRequest, ListScanConfigsResponse, ScanConfig> pageContext =
                  PageContext.create(callable, LIST_SCAN_CONFIGS_PAGE_STR_DESC, request, context);
              return ListScanConfigsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Builder for ContainerAnalysisV1Beta1StubSettings. */
  public static class Builder
      extends StubSettings.Builder<ContainerAnalysisV1Beta1StubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;

    private final UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings;
    private final UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings;
    private final UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings;
    private final UnaryCallSettings.Builder<GetScanConfigRequest, ScanConfig> getScanConfigSettings;
    private final PagedCallSettings.Builder<
            ListScanConfigsRequest, ListScanConfigsResponse, ListScanConfigsPagedResponse>
        listScanConfigsSettings;
    private final UnaryCallSettings.Builder<UpdateScanConfigRequest, ScanConfig>
        updateScanConfigSettings;

    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "idempotent",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
      definitions.put("non_idempotent", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
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
              .setInitialRpcTimeout(Duration.ofMillis(20000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(20000L))
              .setTotalTimeout(Duration.ofMillis(600000L))
              .build();
      definitions.put("default", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getScanConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listScanConfigsSettings = PagedCallSettings.newBuilder(LIST_SCAN_CONFIGS_PAGE_STR_FACT);

      updateScanConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings,
              getScanConfigSettings,
              listScanConfigsSettings,
              updateScanConfigSettings);

      initDefaults(this);
    }

    private static Builder createDefault() {
      Builder builder = new Builder((ClientContext) null);
      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {

      builder
          .setIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .testIamPermissionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getScanConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listScanConfigsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .updateScanConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      return builder;
    }

    protected Builder(ContainerAnalysisV1Beta1StubSettings settings) {
      super(settings);

      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();
      getScanConfigSettings = settings.getScanConfigSettings.toBuilder();
      listScanConfigsSettings = settings.listScanConfigsSettings.toBuilder();
      updateScanConfigSettings = settings.updateScanConfigSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings,
              getScanConfigSettings,
              listScanConfigsSettings,
              updateScanConfigSettings);
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'
    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) throws Exception {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, settingsUpdater);
      return this;
    }

    public ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders() {
      return unaryMethodSettingsBuilders;
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

    /** Returns the builder for the settings used for calls to getScanConfig. */
    public UnaryCallSettings.Builder<GetScanConfigRequest, ScanConfig> getScanConfigSettings() {
      return getScanConfigSettings;
    }

    /** Returns the builder for the settings used for calls to listScanConfigs. */
    public PagedCallSettings.Builder<
            ListScanConfigsRequest, ListScanConfigsResponse, ListScanConfigsPagedResponse>
        listScanConfigsSettings() {
      return listScanConfigsSettings;
    }

    /** Returns the builder for the settings used for calls to updateScanConfig. */
    public UnaryCallSettings.Builder<UpdateScanConfigRequest, ScanConfig>
        updateScanConfigSettings() {
      return updateScanConfigSettings;
    }

    @Override
    public ContainerAnalysisV1Beta1StubSettings build() throws IOException {
      return new ContainerAnalysisV1Beta1StubSettings(this);
    }
  }
}
