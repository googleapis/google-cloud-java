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

package com.google.cloud.contentwarehouse.v1.stub;

import static com.google.cloud.contentwarehouse.v1.RuleSetServiceClient.ListRuleSetsPagedResponse;

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
import com.google.cloud.contentwarehouse.v1.CreateRuleSetRequest;
import com.google.cloud.contentwarehouse.v1.DeleteRuleSetRequest;
import com.google.cloud.contentwarehouse.v1.GetRuleSetRequest;
import com.google.cloud.contentwarehouse.v1.ListRuleSetsRequest;
import com.google.cloud.contentwarehouse.v1.ListRuleSetsResponse;
import com.google.cloud.contentwarehouse.v1.RuleSet;
import com.google.cloud.contentwarehouse.v1.UpdateRuleSetRequest;
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
 * Settings class to configure an instance of {@link RuleSetServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (contentwarehouse.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createRuleSet to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * RuleSetServiceStubSettings.Builder ruleSetServiceSettingsBuilder =
 *     RuleSetServiceStubSettings.newBuilder();
 * ruleSetServiceSettingsBuilder
 *     .createRuleSetSettings()
 *     .setRetrySettings(
 *         ruleSetServiceSettingsBuilder.createRuleSetSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * RuleSetServiceStubSettings ruleSetServiceSettings = ruleSetServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class RuleSetServiceStubSettings extends StubSettings<RuleSetServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateRuleSetRequest, RuleSet> createRuleSetSettings;
  private final UnaryCallSettings<GetRuleSetRequest, RuleSet> getRuleSetSettings;
  private final UnaryCallSettings<UpdateRuleSetRequest, RuleSet> updateRuleSetSettings;
  private final UnaryCallSettings<DeleteRuleSetRequest, Empty> deleteRuleSetSettings;
  private final PagedCallSettings<
          ListRuleSetsRequest, ListRuleSetsResponse, ListRuleSetsPagedResponse>
      listRuleSetsSettings;

  private static final PagedListDescriptor<ListRuleSetsRequest, ListRuleSetsResponse, RuleSet>
      LIST_RULE_SETS_PAGE_STR_DESC =
          new PagedListDescriptor<ListRuleSetsRequest, ListRuleSetsResponse, RuleSet>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListRuleSetsRequest injectToken(ListRuleSetsRequest payload, String token) {
              return ListRuleSetsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListRuleSetsRequest injectPageSize(ListRuleSetsRequest payload, int pageSize) {
              return ListRuleSetsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListRuleSetsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListRuleSetsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<RuleSet> extractResources(ListRuleSetsResponse payload) {
              return payload.getRuleSetsList() == null
                  ? ImmutableList.<RuleSet>of()
                  : payload.getRuleSetsList();
            }
          };

  private static final PagedListResponseFactory<
          ListRuleSetsRequest, ListRuleSetsResponse, ListRuleSetsPagedResponse>
      LIST_RULE_SETS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListRuleSetsRequest, ListRuleSetsResponse, ListRuleSetsPagedResponse>() {
            @Override
            public ApiFuture<ListRuleSetsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListRuleSetsRequest, ListRuleSetsResponse> callable,
                ListRuleSetsRequest request,
                ApiCallContext context,
                ApiFuture<ListRuleSetsResponse> futureResponse) {
              PageContext<ListRuleSetsRequest, ListRuleSetsResponse, RuleSet> pageContext =
                  PageContext.create(callable, LIST_RULE_SETS_PAGE_STR_DESC, request, context);
              return ListRuleSetsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createRuleSet. */
  public UnaryCallSettings<CreateRuleSetRequest, RuleSet> createRuleSetSettings() {
    return createRuleSetSettings;
  }

  /** Returns the object with the settings used for calls to getRuleSet. */
  public UnaryCallSettings<GetRuleSetRequest, RuleSet> getRuleSetSettings() {
    return getRuleSetSettings;
  }

  /** Returns the object with the settings used for calls to updateRuleSet. */
  public UnaryCallSettings<UpdateRuleSetRequest, RuleSet> updateRuleSetSettings() {
    return updateRuleSetSettings;
  }

  /** Returns the object with the settings used for calls to deleteRuleSet. */
  public UnaryCallSettings<DeleteRuleSetRequest, Empty> deleteRuleSetSettings() {
    return deleteRuleSetSettings;
  }

  /** Returns the object with the settings used for calls to listRuleSets. */
  public PagedCallSettings<ListRuleSetsRequest, ListRuleSetsResponse, ListRuleSetsPagedResponse>
      listRuleSetsSettings() {
    return listRuleSetsSettings;
  }

  public RuleSetServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcRuleSetServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonRuleSetServiceStub.create(this);
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
    return "contentwarehouse.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "contentwarehouse.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(RuleSetServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(RuleSetServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return RuleSetServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected RuleSetServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createRuleSetSettings = settingsBuilder.createRuleSetSettings().build();
    getRuleSetSettings = settingsBuilder.getRuleSetSettings().build();
    updateRuleSetSettings = settingsBuilder.updateRuleSetSettings().build();
    deleteRuleSetSettings = settingsBuilder.deleteRuleSetSettings().build();
    listRuleSetsSettings = settingsBuilder.listRuleSetsSettings().build();
  }

  /** Builder for RuleSetServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<RuleSetServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateRuleSetRequest, RuleSet> createRuleSetSettings;
    private final UnaryCallSettings.Builder<GetRuleSetRequest, RuleSet> getRuleSetSettings;
    private final UnaryCallSettings.Builder<UpdateRuleSetRequest, RuleSet> updateRuleSetSettings;
    private final UnaryCallSettings.Builder<DeleteRuleSetRequest, Empty> deleteRuleSetSettings;
    private final PagedCallSettings.Builder<
            ListRuleSetsRequest, ListRuleSetsResponse, ListRuleSetsPagedResponse>
        listRuleSetsSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "no_retry_1_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
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
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_1_params", settings);
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

      createRuleSetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getRuleSetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateRuleSetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteRuleSetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listRuleSetsSettings = PagedCallSettings.newBuilder(LIST_RULE_SETS_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createRuleSetSettings,
              getRuleSetSettings,
              updateRuleSetSettings,
              deleteRuleSetSettings,
              listRuleSetsSettings);
      initDefaults(this);
    }

    protected Builder(RuleSetServiceStubSettings settings) {
      super(settings);

      createRuleSetSettings = settings.createRuleSetSettings.toBuilder();
      getRuleSetSettings = settings.getRuleSetSettings.toBuilder();
      updateRuleSetSettings = settings.updateRuleSetSettings.toBuilder();
      deleteRuleSetSettings = settings.deleteRuleSetSettings.toBuilder();
      listRuleSetsSettings = settings.listRuleSetsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createRuleSetSettings,
              getRuleSetSettings,
              updateRuleSetSettings,
              deleteRuleSetSettings,
              listRuleSetsSettings);
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
          .createRuleSetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getRuleSetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateRuleSetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteRuleSetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listRuleSetsSettings()
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

    /** Returns the builder for the settings used for calls to createRuleSet. */
    public UnaryCallSettings.Builder<CreateRuleSetRequest, RuleSet> createRuleSetSettings() {
      return createRuleSetSettings;
    }

    /** Returns the builder for the settings used for calls to getRuleSet. */
    public UnaryCallSettings.Builder<GetRuleSetRequest, RuleSet> getRuleSetSettings() {
      return getRuleSetSettings;
    }

    /** Returns the builder for the settings used for calls to updateRuleSet. */
    public UnaryCallSettings.Builder<UpdateRuleSetRequest, RuleSet> updateRuleSetSettings() {
      return updateRuleSetSettings;
    }

    /** Returns the builder for the settings used for calls to deleteRuleSet. */
    public UnaryCallSettings.Builder<DeleteRuleSetRequest, Empty> deleteRuleSetSettings() {
      return deleteRuleSetSettings;
    }

    /** Returns the builder for the settings used for calls to listRuleSets. */
    public PagedCallSettings.Builder<
            ListRuleSetsRequest, ListRuleSetsResponse, ListRuleSetsPagedResponse>
        listRuleSetsSettings() {
      return listRuleSetsSettings;
    }

    @Override
    public RuleSetServiceStubSettings build() throws IOException {
      return new RuleSetServiceStubSettings(this);
    }
  }
}
