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

package com.google.iam.v2.stub;

import static com.google.iam.v2.PoliciesClient.ListPoliciesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.grpc.ProtoOperationTransformers;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.longrunning.OperationTimedPollAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallSettings;
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
import com.google.iam.v2.CreatePolicyRequest;
import com.google.iam.v2.DeletePolicyRequest;
import com.google.iam.v2.GetPolicyRequest;
import com.google.iam.v2.ListPoliciesRequest;
import com.google.iam.v2.ListPoliciesResponse;
import com.google.iam.v2.Policy;
import com.google.iam.v2.PolicyOperationMetadata;
import com.google.iam.v2.UpdatePolicyRequest;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link PoliciesStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (iam.googleapis.com) and default port (443) are used.
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
 * PoliciesStubSettings.Builder policiesSettingsBuilder = PoliciesStubSettings.newBuilder();
 * policiesSettingsBuilder
 *     .getPolicySettings()
 *     .setRetrySettings(
 *         policiesSettingsBuilder.getPolicySettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * PoliciesStubSettings policiesSettings = policiesSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class PoliciesStubSettings extends StubSettings<PoliciesStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListPoliciesRequest, ListPoliciesResponse, ListPoliciesPagedResponse>
      listPoliciesSettings;
  private final UnaryCallSettings<GetPolicyRequest, Policy> getPolicySettings;
  private final UnaryCallSettings<CreatePolicyRequest, Operation> createPolicySettings;
  private final OperationCallSettings<CreatePolicyRequest, Policy, PolicyOperationMetadata>
      createPolicyOperationSettings;
  private final UnaryCallSettings<UpdatePolicyRequest, Operation> updatePolicySettings;
  private final OperationCallSettings<UpdatePolicyRequest, Policy, PolicyOperationMetadata>
      updatePolicyOperationSettings;
  private final UnaryCallSettings<DeletePolicyRequest, Operation> deletePolicySettings;
  private final OperationCallSettings<DeletePolicyRequest, Policy, PolicyOperationMetadata>
      deletePolicyOperationSettings;

  private static final PagedListDescriptor<ListPoliciesRequest, ListPoliciesResponse, Policy>
      LIST_POLICIES_PAGE_STR_DESC =
          new PagedListDescriptor<ListPoliciesRequest, ListPoliciesResponse, Policy>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListPoliciesRequest injectToken(ListPoliciesRequest payload, String token) {
              return ListPoliciesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListPoliciesRequest injectPageSize(ListPoliciesRequest payload, int pageSize) {
              return ListPoliciesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListPoliciesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListPoliciesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Policy> extractResources(ListPoliciesResponse payload) {
              return payload.getPoliciesList() == null
                  ? ImmutableList.<Policy>of()
                  : payload.getPoliciesList();
            }
          };

  private static final PagedListResponseFactory<
          ListPoliciesRequest, ListPoliciesResponse, ListPoliciesPagedResponse>
      LIST_POLICIES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListPoliciesRequest, ListPoliciesResponse, ListPoliciesPagedResponse>() {
            @Override
            public ApiFuture<ListPoliciesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListPoliciesRequest, ListPoliciesResponse> callable,
                ListPoliciesRequest request,
                ApiCallContext context,
                ApiFuture<ListPoliciesResponse> futureResponse) {
              PageContext<ListPoliciesRequest, ListPoliciesResponse, Policy> pageContext =
                  PageContext.create(callable, LIST_POLICIES_PAGE_STR_DESC, request, context);
              return ListPoliciesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listPolicies. */
  public PagedCallSettings<ListPoliciesRequest, ListPoliciesResponse, ListPoliciesPagedResponse>
      listPoliciesSettings() {
    return listPoliciesSettings;
  }

  /** Returns the object with the settings used for calls to getPolicy. */
  public UnaryCallSettings<GetPolicyRequest, Policy> getPolicySettings() {
    return getPolicySettings;
  }

  /** Returns the object with the settings used for calls to createPolicy. */
  public UnaryCallSettings<CreatePolicyRequest, Operation> createPolicySettings() {
    return createPolicySettings;
  }

  /** Returns the object with the settings used for calls to createPolicy. */
  public OperationCallSettings<CreatePolicyRequest, Policy, PolicyOperationMetadata>
      createPolicyOperationSettings() {
    return createPolicyOperationSettings;
  }

  /** Returns the object with the settings used for calls to updatePolicy. */
  public UnaryCallSettings<UpdatePolicyRequest, Operation> updatePolicySettings() {
    return updatePolicySettings;
  }

  /** Returns the object with the settings used for calls to updatePolicy. */
  public OperationCallSettings<UpdatePolicyRequest, Policy, PolicyOperationMetadata>
      updatePolicyOperationSettings() {
    return updatePolicyOperationSettings;
  }

  /** Returns the object with the settings used for calls to deletePolicy. */
  public UnaryCallSettings<DeletePolicyRequest, Operation> deletePolicySettings() {
    return deletePolicySettings;
  }

  /** Returns the object with the settings used for calls to deletePolicy. */
  public OperationCallSettings<DeletePolicyRequest, Policy, PolicyOperationMetadata>
      deletePolicyOperationSettings() {
    return deletePolicyOperationSettings;
  }

  public PoliciesStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcPoliciesStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonPoliciesStub.create(this);
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
    return "iam.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "iam.mtls.googleapis.com:443";
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
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(PoliciesStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(PoliciesStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return PoliciesStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected PoliciesStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listPoliciesSettings = settingsBuilder.listPoliciesSettings().build();
    getPolicySettings = settingsBuilder.getPolicySettings().build();
    createPolicySettings = settingsBuilder.createPolicySettings().build();
    createPolicyOperationSettings = settingsBuilder.createPolicyOperationSettings().build();
    updatePolicySettings = settingsBuilder.updatePolicySettings().build();
    updatePolicyOperationSettings = settingsBuilder.updatePolicyOperationSettings().build();
    deletePolicySettings = settingsBuilder.deletePolicySettings().build();
    deletePolicyOperationSettings = settingsBuilder.deletePolicyOperationSettings().build();
  }

  /** Builder for PoliciesStubSettings. */
  public static class Builder extends StubSettings.Builder<PoliciesStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListPoliciesRequest, ListPoliciesResponse, ListPoliciesPagedResponse>
        listPoliciesSettings;
    private final UnaryCallSettings.Builder<GetPolicyRequest, Policy> getPolicySettings;
    private final UnaryCallSettings.Builder<CreatePolicyRequest, Operation> createPolicySettings;
    private final OperationCallSettings.Builder<
            CreatePolicyRequest, Policy, PolicyOperationMetadata>
        createPolicyOperationSettings;
    private final UnaryCallSettings.Builder<UpdatePolicyRequest, Operation> updatePolicySettings;
    private final OperationCallSettings.Builder<
            UpdatePolicyRequest, Policy, PolicyOperationMetadata>
        updatePolicyOperationSettings;
    private final UnaryCallSettings.Builder<DeletePolicyRequest, Operation> deletePolicySettings;
    private final OperationCallSettings.Builder<
            DeletePolicyRequest, Policy, PolicyOperationMetadata>
        deletePolicyOperationSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(10000L))
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listPoliciesSettings = PagedCallSettings.newBuilder(LIST_POLICIES_PAGE_STR_FACT);
      getPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createPolicyOperationSettings = OperationCallSettings.newBuilder();
      updatePolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updatePolicyOperationSettings = OperationCallSettings.newBuilder();
      deletePolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deletePolicyOperationSettings = OperationCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listPoliciesSettings,
              getPolicySettings,
              createPolicySettings,
              updatePolicySettings,
              deletePolicySettings);
      initDefaults(this);
    }

    protected Builder(PoliciesStubSettings settings) {
      super(settings);

      listPoliciesSettings = settings.listPoliciesSettings.toBuilder();
      getPolicySettings = settings.getPolicySettings.toBuilder();
      createPolicySettings = settings.createPolicySettings.toBuilder();
      createPolicyOperationSettings = settings.createPolicyOperationSettings.toBuilder();
      updatePolicySettings = settings.updatePolicySettings.toBuilder();
      updatePolicyOperationSettings = settings.updatePolicyOperationSettings.toBuilder();
      deletePolicySettings = settings.deletePolicySettings.toBuilder();
      deletePolicyOperationSettings = settings.deletePolicyOperationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listPoliciesSettings,
              getPolicySettings,
              createPolicySettings,
              updatePolicySettings,
              deletePolicySettings);
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
          .listPoliciesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updatePolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deletePolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createPolicyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreatePolicyRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Policy.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(PolicyOperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updatePolicyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdatePolicyRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Policy.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(PolicyOperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deletePolicyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeletePolicyRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Policy.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(PolicyOperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

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

    /** Returns the builder for the settings used for calls to listPolicies. */
    public PagedCallSettings.Builder<
            ListPoliciesRequest, ListPoliciesResponse, ListPoliciesPagedResponse>
        listPoliciesSettings() {
      return listPoliciesSettings;
    }

    /** Returns the builder for the settings used for calls to getPolicy. */
    public UnaryCallSettings.Builder<GetPolicyRequest, Policy> getPolicySettings() {
      return getPolicySettings;
    }

    /** Returns the builder for the settings used for calls to createPolicy. */
    public UnaryCallSettings.Builder<CreatePolicyRequest, Operation> createPolicySettings() {
      return createPolicySettings;
    }

    /** Returns the builder for the settings used for calls to createPolicy. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<CreatePolicyRequest, Policy, PolicyOperationMetadata>
        createPolicyOperationSettings() {
      return createPolicyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updatePolicy. */
    public UnaryCallSettings.Builder<UpdatePolicyRequest, Operation> updatePolicySettings() {
      return updatePolicySettings;
    }

    /** Returns the builder for the settings used for calls to updatePolicy. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<UpdatePolicyRequest, Policy, PolicyOperationMetadata>
        updatePolicyOperationSettings() {
      return updatePolicyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deletePolicy. */
    public UnaryCallSettings.Builder<DeletePolicyRequest, Operation> deletePolicySettings() {
      return deletePolicySettings;
    }

    /** Returns the builder for the settings used for calls to deletePolicy. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeletePolicyRequest, Policy, PolicyOperationMetadata>
        deletePolicyOperationSettings() {
      return deletePolicyOperationSettings;
    }

    @Override
    public PoliciesStubSettings build() throws IOException {
      return new PoliciesStubSettings(this);
    }
  }
}
