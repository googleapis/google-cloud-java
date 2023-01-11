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

package com.google.appengine.v1.stub;

import static com.google.appengine.v1.FirewallClient.ListIngressRulesPagedResponse;

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
import com.google.appengine.v1.BatchUpdateIngressRulesRequest;
import com.google.appengine.v1.BatchUpdateIngressRulesResponse;
import com.google.appengine.v1.CreateIngressRuleRequest;
import com.google.appengine.v1.DeleteIngressRuleRequest;
import com.google.appengine.v1.GetIngressRuleRequest;
import com.google.appengine.v1.ListIngressRulesRequest;
import com.google.appengine.v1.ListIngressRulesResponse;
import com.google.appengine.v1.UpdateIngressRuleRequest;
import com.google.appengine.v1.firewall.FirewallRule;
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
 * Settings class to configure an instance of {@link FirewallStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (appengine.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of batchUpdateIngressRules to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * FirewallStubSettings.Builder firewallSettingsBuilder = FirewallStubSettings.newBuilder();
 * firewallSettingsBuilder
 *     .batchUpdateIngressRulesSettings()
 *     .setRetrySettings(
 *         firewallSettingsBuilder
 *             .batchUpdateIngressRulesSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * FirewallStubSettings firewallSettings = firewallSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class FirewallStubSettings extends StubSettings<FirewallStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/appengine.admin")
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/cloud-platform.read-only")
          .build();

  private final PagedCallSettings<
          ListIngressRulesRequest, ListIngressRulesResponse, ListIngressRulesPagedResponse>
      listIngressRulesSettings;
  private final UnaryCallSettings<BatchUpdateIngressRulesRequest, BatchUpdateIngressRulesResponse>
      batchUpdateIngressRulesSettings;
  private final UnaryCallSettings<CreateIngressRuleRequest, FirewallRule> createIngressRuleSettings;
  private final UnaryCallSettings<GetIngressRuleRequest, FirewallRule> getIngressRuleSettings;
  private final UnaryCallSettings<UpdateIngressRuleRequest, FirewallRule> updateIngressRuleSettings;
  private final UnaryCallSettings<DeleteIngressRuleRequest, Empty> deleteIngressRuleSettings;

  private static final PagedListDescriptor<
          ListIngressRulesRequest, ListIngressRulesResponse, FirewallRule>
      LIST_INGRESS_RULES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListIngressRulesRequest, ListIngressRulesResponse, FirewallRule>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListIngressRulesRequest injectToken(
                ListIngressRulesRequest payload, String token) {
              return ListIngressRulesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListIngressRulesRequest injectPageSize(
                ListIngressRulesRequest payload, int pageSize) {
              return ListIngressRulesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListIngressRulesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListIngressRulesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<FirewallRule> extractResources(ListIngressRulesResponse payload) {
              return payload.getIngressRulesList() == null
                  ? ImmutableList.<FirewallRule>of()
                  : payload.getIngressRulesList();
            }
          };

  private static final PagedListResponseFactory<
          ListIngressRulesRequest, ListIngressRulesResponse, ListIngressRulesPagedResponse>
      LIST_INGRESS_RULES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListIngressRulesRequest, ListIngressRulesResponse, ListIngressRulesPagedResponse>() {
            @Override
            public ApiFuture<ListIngressRulesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListIngressRulesRequest, ListIngressRulesResponse> callable,
                ListIngressRulesRequest request,
                ApiCallContext context,
                ApiFuture<ListIngressRulesResponse> futureResponse) {
              PageContext<ListIngressRulesRequest, ListIngressRulesResponse, FirewallRule>
                  pageContext =
                      PageContext.create(
                          callable, LIST_INGRESS_RULES_PAGE_STR_DESC, request, context);
              return ListIngressRulesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listIngressRules. */
  public PagedCallSettings<
          ListIngressRulesRequest, ListIngressRulesResponse, ListIngressRulesPagedResponse>
      listIngressRulesSettings() {
    return listIngressRulesSettings;
  }

  /** Returns the object with the settings used for calls to batchUpdateIngressRules. */
  public UnaryCallSettings<BatchUpdateIngressRulesRequest, BatchUpdateIngressRulesResponse>
      batchUpdateIngressRulesSettings() {
    return batchUpdateIngressRulesSettings;
  }

  /** Returns the object with the settings used for calls to createIngressRule. */
  public UnaryCallSettings<CreateIngressRuleRequest, FirewallRule> createIngressRuleSettings() {
    return createIngressRuleSettings;
  }

  /** Returns the object with the settings used for calls to getIngressRule. */
  public UnaryCallSettings<GetIngressRuleRequest, FirewallRule> getIngressRuleSettings() {
    return getIngressRuleSettings;
  }

  /** Returns the object with the settings used for calls to updateIngressRule. */
  public UnaryCallSettings<UpdateIngressRuleRequest, FirewallRule> updateIngressRuleSettings() {
    return updateIngressRuleSettings;
  }

  /** Returns the object with the settings used for calls to deleteIngressRule. */
  public UnaryCallSettings<DeleteIngressRuleRequest, Empty> deleteIngressRuleSettings() {
    return deleteIngressRuleSettings;
  }

  public FirewallStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcFirewallStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonFirewallStub.create(this);
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
    return "appengine.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "appengine.mtls.googleapis.com:443";
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
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(FirewallStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(FirewallStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return FirewallStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected FirewallStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listIngressRulesSettings = settingsBuilder.listIngressRulesSettings().build();
    batchUpdateIngressRulesSettings = settingsBuilder.batchUpdateIngressRulesSettings().build();
    createIngressRuleSettings = settingsBuilder.createIngressRuleSettings().build();
    getIngressRuleSettings = settingsBuilder.getIngressRuleSettings().build();
    updateIngressRuleSettings = settingsBuilder.updateIngressRuleSettings().build();
    deleteIngressRuleSettings = settingsBuilder.deleteIngressRuleSettings().build();
  }

  /** Builder for FirewallStubSettings. */
  public static class Builder extends StubSettings.Builder<FirewallStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListIngressRulesRequest, ListIngressRulesResponse, ListIngressRulesPagedResponse>
        listIngressRulesSettings;
    private final UnaryCallSettings.Builder<
            BatchUpdateIngressRulesRequest, BatchUpdateIngressRulesResponse>
        batchUpdateIngressRulesSettings;
    private final UnaryCallSettings.Builder<CreateIngressRuleRequest, FirewallRule>
        createIngressRuleSettings;
    private final UnaryCallSettings.Builder<GetIngressRuleRequest, FirewallRule>
        getIngressRuleSettings;
    private final UnaryCallSettings.Builder<UpdateIngressRuleRequest, FirewallRule>
        updateIngressRuleSettings;
    private final UnaryCallSettings.Builder<DeleteIngressRuleRequest, Empty>
        deleteIngressRuleSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "no_retry_0_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
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
      definitions.put("no_retry_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listIngressRulesSettings = PagedCallSettings.newBuilder(LIST_INGRESS_RULES_PAGE_STR_FACT);
      batchUpdateIngressRulesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createIngressRuleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIngressRuleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateIngressRuleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteIngressRuleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listIngressRulesSettings,
              batchUpdateIngressRulesSettings,
              createIngressRuleSettings,
              getIngressRuleSettings,
              updateIngressRuleSettings,
              deleteIngressRuleSettings);
      initDefaults(this);
    }

    protected Builder(FirewallStubSettings settings) {
      super(settings);

      listIngressRulesSettings = settings.listIngressRulesSettings.toBuilder();
      batchUpdateIngressRulesSettings = settings.batchUpdateIngressRulesSettings.toBuilder();
      createIngressRuleSettings = settings.createIngressRuleSettings.toBuilder();
      getIngressRuleSettings = settings.getIngressRuleSettings.toBuilder();
      updateIngressRuleSettings = settings.updateIngressRuleSettings.toBuilder();
      deleteIngressRuleSettings = settings.deleteIngressRuleSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listIngressRulesSettings,
              batchUpdateIngressRulesSettings,
              createIngressRuleSettings,
              getIngressRuleSettings,
              updateIngressRuleSettings,
              deleteIngressRuleSettings);
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
          .listIngressRulesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .batchUpdateIngressRulesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createIngressRuleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getIngressRuleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateIngressRuleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteIngressRuleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

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

    /** Returns the builder for the settings used for calls to listIngressRules. */
    public PagedCallSettings.Builder<
            ListIngressRulesRequest, ListIngressRulesResponse, ListIngressRulesPagedResponse>
        listIngressRulesSettings() {
      return listIngressRulesSettings;
    }

    /** Returns the builder for the settings used for calls to batchUpdateIngressRules. */
    public UnaryCallSettings.Builder<
            BatchUpdateIngressRulesRequest, BatchUpdateIngressRulesResponse>
        batchUpdateIngressRulesSettings() {
      return batchUpdateIngressRulesSettings;
    }

    /** Returns the builder for the settings used for calls to createIngressRule. */
    public UnaryCallSettings.Builder<CreateIngressRuleRequest, FirewallRule>
        createIngressRuleSettings() {
      return createIngressRuleSettings;
    }

    /** Returns the builder for the settings used for calls to getIngressRule. */
    public UnaryCallSettings.Builder<GetIngressRuleRequest, FirewallRule> getIngressRuleSettings() {
      return getIngressRuleSettings;
    }

    /** Returns the builder for the settings used for calls to updateIngressRule. */
    public UnaryCallSettings.Builder<UpdateIngressRuleRequest, FirewallRule>
        updateIngressRuleSettings() {
      return updateIngressRuleSettings;
    }

    /** Returns the builder for the settings used for calls to deleteIngressRule. */
    public UnaryCallSettings.Builder<DeleteIngressRuleRequest, Empty> deleteIngressRuleSettings() {
      return deleteIngressRuleSettings;
    }

    @Override
    public FirewallStubSettings build() throws IOException {
      return new FirewallStubSettings(this);
    }
  }
}
