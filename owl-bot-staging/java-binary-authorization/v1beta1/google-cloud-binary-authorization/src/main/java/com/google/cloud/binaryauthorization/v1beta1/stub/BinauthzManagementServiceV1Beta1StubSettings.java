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

package com.google.cloud.binaryauthorization.v1beta1.stub;

import static com.google.cloud.binaryauthorization.v1beta1.BinauthzManagementServiceV1Beta1Client.ListAttestorsPagedResponse;

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
import com.google.cloud.binaryauthorization.v1beta1.Attestor;
import com.google.cloud.binaryauthorization.v1beta1.CreateAttestorRequest;
import com.google.cloud.binaryauthorization.v1beta1.DeleteAttestorRequest;
import com.google.cloud.binaryauthorization.v1beta1.GetAttestorRequest;
import com.google.cloud.binaryauthorization.v1beta1.GetPolicyRequest;
import com.google.cloud.binaryauthorization.v1beta1.ListAttestorsRequest;
import com.google.cloud.binaryauthorization.v1beta1.ListAttestorsResponse;
import com.google.cloud.binaryauthorization.v1beta1.Policy;
import com.google.cloud.binaryauthorization.v1beta1.UpdateAttestorRequest;
import com.google.cloud.binaryauthorization.v1beta1.UpdatePolicyRequest;
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
 * Settings class to configure an instance of {@link BinauthzManagementServiceV1Beta1Stub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (binaryauthorization.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getPolicy to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * BinauthzManagementServiceV1Beta1StubSettings.Builder
 *     binauthzManagementServiceV1Beta1SettingsBuilder =
 *         BinauthzManagementServiceV1Beta1StubSettings.newBuilder();
 * binauthzManagementServiceV1Beta1SettingsBuilder
 *     .getPolicySettings()
 *     .setRetrySettings(
 *         binauthzManagementServiceV1Beta1SettingsBuilder
 *             .getPolicySettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * BinauthzManagementServiceV1Beta1StubSettings binauthzManagementServiceV1Beta1Settings =
 *     binauthzManagementServiceV1Beta1SettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class BinauthzManagementServiceV1Beta1StubSettings
    extends StubSettings<BinauthzManagementServiceV1Beta1StubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<GetPolicyRequest, Policy> getPolicySettings;
  private final UnaryCallSettings<UpdatePolicyRequest, Policy> updatePolicySettings;
  private final UnaryCallSettings<CreateAttestorRequest, Attestor> createAttestorSettings;
  private final UnaryCallSettings<GetAttestorRequest, Attestor> getAttestorSettings;
  private final UnaryCallSettings<UpdateAttestorRequest, Attestor> updateAttestorSettings;
  private final PagedCallSettings<
          ListAttestorsRequest, ListAttestorsResponse, ListAttestorsPagedResponse>
      listAttestorsSettings;
  private final UnaryCallSettings<DeleteAttestorRequest, Empty> deleteAttestorSettings;

  private static final PagedListDescriptor<ListAttestorsRequest, ListAttestorsResponse, Attestor>
      LIST_ATTESTORS_PAGE_STR_DESC =
          new PagedListDescriptor<ListAttestorsRequest, ListAttestorsResponse, Attestor>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAttestorsRequest injectToken(ListAttestorsRequest payload, String token) {
              return ListAttestorsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAttestorsRequest injectPageSize(ListAttestorsRequest payload, int pageSize) {
              return ListAttestorsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListAttestorsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAttestorsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Attestor> extractResources(ListAttestorsResponse payload) {
              return payload.getAttestorsList() == null
                  ? ImmutableList.<Attestor>of()
                  : payload.getAttestorsList();
            }
          };

  private static final PagedListResponseFactory<
          ListAttestorsRequest, ListAttestorsResponse, ListAttestorsPagedResponse>
      LIST_ATTESTORS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAttestorsRequest, ListAttestorsResponse, ListAttestorsPagedResponse>() {
            @Override
            public ApiFuture<ListAttestorsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAttestorsRequest, ListAttestorsResponse> callable,
                ListAttestorsRequest request,
                ApiCallContext context,
                ApiFuture<ListAttestorsResponse> futureResponse) {
              PageContext<ListAttestorsRequest, ListAttestorsResponse, Attestor> pageContext =
                  PageContext.create(callable, LIST_ATTESTORS_PAGE_STR_DESC, request, context);
              return ListAttestorsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to getPolicy. */
  public UnaryCallSettings<GetPolicyRequest, Policy> getPolicySettings() {
    return getPolicySettings;
  }

  /** Returns the object with the settings used for calls to updatePolicy. */
  public UnaryCallSettings<UpdatePolicyRequest, Policy> updatePolicySettings() {
    return updatePolicySettings;
  }

  /** Returns the object with the settings used for calls to createAttestor. */
  public UnaryCallSettings<CreateAttestorRequest, Attestor> createAttestorSettings() {
    return createAttestorSettings;
  }

  /** Returns the object with the settings used for calls to getAttestor. */
  public UnaryCallSettings<GetAttestorRequest, Attestor> getAttestorSettings() {
    return getAttestorSettings;
  }

  /** Returns the object with the settings used for calls to updateAttestor. */
  public UnaryCallSettings<UpdateAttestorRequest, Attestor> updateAttestorSettings() {
    return updateAttestorSettings;
  }

  /** Returns the object with the settings used for calls to listAttestors. */
  public PagedCallSettings<ListAttestorsRequest, ListAttestorsResponse, ListAttestorsPagedResponse>
      listAttestorsSettings() {
    return listAttestorsSettings;
  }

  /** Returns the object with the settings used for calls to deleteAttestor. */
  public UnaryCallSettings<DeleteAttestorRequest, Empty> deleteAttestorSettings() {
    return deleteAttestorSettings;
  }

  public BinauthzManagementServiceV1Beta1Stub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcBinauthzManagementServiceV1Beta1Stub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonBinauthzManagementServiceV1Beta1Stub.create(this);
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
    return "binaryauthorization.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "binaryauthorization.mtls.googleapis.com:443";
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
            "gapic",
            GaxProperties.getLibraryVersion(BinauthzManagementServiceV1Beta1StubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic",
            GaxProperties.getLibraryVersion(BinauthzManagementServiceV1Beta1StubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return BinauthzManagementServiceV1Beta1StubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected BinauthzManagementServiceV1Beta1StubSettings(Builder settingsBuilder)
      throws IOException {
    super(settingsBuilder);

    getPolicySettings = settingsBuilder.getPolicySettings().build();
    updatePolicySettings = settingsBuilder.updatePolicySettings().build();
    createAttestorSettings = settingsBuilder.createAttestorSettings().build();
    getAttestorSettings = settingsBuilder.getAttestorSettings().build();
    updateAttestorSettings = settingsBuilder.updateAttestorSettings().build();
    listAttestorsSettings = settingsBuilder.listAttestorsSettings().build();
    deleteAttestorSettings = settingsBuilder.deleteAttestorSettings().build();
  }

  /** Builder for BinauthzManagementServiceV1Beta1StubSettings. */
  public static class Builder
      extends StubSettings.Builder<BinauthzManagementServiceV1Beta1StubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetPolicyRequest, Policy> getPolicySettings;
    private final UnaryCallSettings.Builder<UpdatePolicyRequest, Policy> updatePolicySettings;
    private final UnaryCallSettings.Builder<CreateAttestorRequest, Attestor> createAttestorSettings;
    private final UnaryCallSettings.Builder<GetAttestorRequest, Attestor> getAttestorSettings;
    private final UnaryCallSettings.Builder<UpdateAttestorRequest, Attestor> updateAttestorSettings;
    private final PagedCallSettings.Builder<
            ListAttestorsRequest, ListAttestorsResponse, ListAttestorsPagedResponse>
        listAttestorsSettings;
    private final UnaryCallSettings.Builder<DeleteAttestorRequest, Empty> deleteAttestorSettings;
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
              .setInitialRetryDelay(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(600000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(600000L))
              .setTotalTimeout(Duration.ofMillis(600000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(600000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(600000L))
              .setTotalTimeout(Duration.ofMillis(600000L))
              .build();
      definitions.put("no_retry_1_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      getPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updatePolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createAttestorSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getAttestorSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateAttestorSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listAttestorsSettings = PagedCallSettings.newBuilder(LIST_ATTESTORS_PAGE_STR_FACT);
      deleteAttestorSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getPolicySettings,
              updatePolicySettings,
              createAttestorSettings,
              getAttestorSettings,
              updateAttestorSettings,
              listAttestorsSettings,
              deleteAttestorSettings);
      initDefaults(this);
    }

    protected Builder(BinauthzManagementServiceV1Beta1StubSettings settings) {
      super(settings);

      getPolicySettings = settings.getPolicySettings.toBuilder();
      updatePolicySettings = settings.updatePolicySettings.toBuilder();
      createAttestorSettings = settings.createAttestorSettings.toBuilder();
      getAttestorSettings = settings.getAttestorSettings.toBuilder();
      updateAttestorSettings = settings.updateAttestorSettings.toBuilder();
      listAttestorsSettings = settings.listAttestorsSettings.toBuilder();
      deleteAttestorSettings = settings.deleteAttestorSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getPolicySettings,
              updatePolicySettings,
              createAttestorSettings,
              getAttestorSettings,
              updateAttestorSettings,
              listAttestorsSettings,
              deleteAttestorSettings);
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
          .getPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updatePolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createAttestorSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getAttestorSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateAttestorSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listAttestorsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteAttestorSettings()
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

    /** Returns the builder for the settings used for calls to getPolicy. */
    public UnaryCallSettings.Builder<GetPolicyRequest, Policy> getPolicySettings() {
      return getPolicySettings;
    }

    /** Returns the builder for the settings used for calls to updatePolicy. */
    public UnaryCallSettings.Builder<UpdatePolicyRequest, Policy> updatePolicySettings() {
      return updatePolicySettings;
    }

    /** Returns the builder for the settings used for calls to createAttestor. */
    public UnaryCallSettings.Builder<CreateAttestorRequest, Attestor> createAttestorSettings() {
      return createAttestorSettings;
    }

    /** Returns the builder for the settings used for calls to getAttestor. */
    public UnaryCallSettings.Builder<GetAttestorRequest, Attestor> getAttestorSettings() {
      return getAttestorSettings;
    }

    /** Returns the builder for the settings used for calls to updateAttestor. */
    public UnaryCallSettings.Builder<UpdateAttestorRequest, Attestor> updateAttestorSettings() {
      return updateAttestorSettings;
    }

    /** Returns the builder for the settings used for calls to listAttestors. */
    public PagedCallSettings.Builder<
            ListAttestorsRequest, ListAttestorsResponse, ListAttestorsPagedResponse>
        listAttestorsSettings() {
      return listAttestorsSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAttestor. */
    public UnaryCallSettings.Builder<DeleteAttestorRequest, Empty> deleteAttestorSettings() {
      return deleteAttestorSettings;
    }

    @Override
    public BinauthzManagementServiceV1Beta1StubSettings build() throws IOException {
      return new BinauthzManagementServiceV1Beta1StubSettings(this);
    }
  }
}
