/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.SecurityPoliciesClient.ListPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
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
import com.google.cloud.compute.v1.AddRuleSecurityPolicyRequest;
import com.google.cloud.compute.v1.DeleteSecurityPolicyRequest;
import com.google.cloud.compute.v1.GetRuleSecurityPolicyRequest;
import com.google.cloud.compute.v1.GetSecurityPolicyRequest;
import com.google.cloud.compute.v1.InsertSecurityPolicyRequest;
import com.google.cloud.compute.v1.ListPreconfiguredExpressionSetsSecurityPoliciesRequest;
import com.google.cloud.compute.v1.ListSecurityPoliciesRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchRuleSecurityPolicyRequest;
import com.google.cloud.compute.v1.PatchSecurityPolicyRequest;
import com.google.cloud.compute.v1.RemoveRuleSecurityPolicyRequest;
import com.google.cloud.compute.v1.SecurityPoliciesListPreconfiguredExpressionSetsResponse;
import com.google.cloud.compute.v1.SecurityPolicy;
import com.google.cloud.compute.v1.SecurityPolicyList;
import com.google.cloud.compute.v1.SecurityPolicyRule;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link SecurityPoliciesStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (compute.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of addRule to 30 seconds:
 *
 * <pre>{@code
 * SecurityPoliciesStubSettings.Builder securityPoliciesSettingsBuilder =
 *     SecurityPoliciesStubSettings.newBuilder();
 * securityPoliciesSettingsBuilder
 *     .addRuleSettings()
 *     .setRetrySettings(
 *         securityPoliciesSettingsBuilder
 *             .addRuleSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * SecurityPoliciesStubSettings securityPoliciesSettings = securityPoliciesSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class SecurityPoliciesStubSettings extends StubSettings<SecurityPoliciesStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/compute")
          .add("https://www.googleapis.com/auth/cloud-platform")
          .build();

  private final UnaryCallSettings<AddRuleSecurityPolicyRequest, Operation> addRuleSettings;
  private final UnaryCallSettings<DeleteSecurityPolicyRequest, Operation> deleteSettings;
  private final UnaryCallSettings<GetSecurityPolicyRequest, SecurityPolicy> getSettings;
  private final UnaryCallSettings<GetRuleSecurityPolicyRequest, SecurityPolicyRule> getRuleSettings;
  private final UnaryCallSettings<InsertSecurityPolicyRequest, Operation> insertSettings;
  private final PagedCallSettings<
          ListSecurityPoliciesRequest, SecurityPolicyList, ListPagedResponse>
      listSettings;
  private final UnaryCallSettings<
          ListPreconfiguredExpressionSetsSecurityPoliciesRequest,
          SecurityPoliciesListPreconfiguredExpressionSetsResponse>
      listPreconfiguredExpressionSetsSettings;
  private final UnaryCallSettings<PatchSecurityPolicyRequest, Operation> patchSettings;
  private final UnaryCallSettings<PatchRuleSecurityPolicyRequest, Operation> patchRuleSettings;
  private final UnaryCallSettings<RemoveRuleSecurityPolicyRequest, Operation> removeRuleSettings;

  private static final PagedListDescriptor<
          ListSecurityPoliciesRequest, SecurityPolicyList, SecurityPolicy>
      LIST_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListSecurityPoliciesRequest, SecurityPolicyList, SecurityPolicy>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListSecurityPoliciesRequest injectToken(
                ListSecurityPoliciesRequest payload, String token) {
              return ListSecurityPoliciesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListSecurityPoliciesRequest injectPageSize(
                ListSecurityPoliciesRequest payload, int pageSize) {
              return ListSecurityPoliciesRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListSecurityPoliciesRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(SecurityPolicyList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<SecurityPolicy> extractResources(SecurityPolicyList payload) {
              return payload.getItemsList() == null
                  ? ImmutableList.<SecurityPolicy>of()
                  : payload.getItemsList();
            }
          };

  private static final PagedListResponseFactory<
          ListSecurityPoliciesRequest, SecurityPolicyList, ListPagedResponse>
      LIST_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListSecurityPoliciesRequest, SecurityPolicyList, ListPagedResponse>() {
            @Override
            public ApiFuture<ListPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListSecurityPoliciesRequest, SecurityPolicyList> callable,
                ListSecurityPoliciesRequest request,
                ApiCallContext context,
                ApiFuture<SecurityPolicyList> futureResponse) {
              PageContext<ListSecurityPoliciesRequest, SecurityPolicyList, SecurityPolicy>
                  pageContext = PageContext.create(callable, LIST_PAGE_STR_DESC, request, context);
              return ListPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to addRule. */
  public UnaryCallSettings<AddRuleSecurityPolicyRequest, Operation> addRuleSettings() {
    return addRuleSettings;
  }

  /** Returns the object with the settings used for calls to delete. */
  public UnaryCallSettings<DeleteSecurityPolicyRequest, Operation> deleteSettings() {
    return deleteSettings;
  }

  /** Returns the object with the settings used for calls to get. */
  public UnaryCallSettings<GetSecurityPolicyRequest, SecurityPolicy> getSettings() {
    return getSettings;
  }

  /** Returns the object with the settings used for calls to getRule. */
  public UnaryCallSettings<GetRuleSecurityPolicyRequest, SecurityPolicyRule> getRuleSettings() {
    return getRuleSettings;
  }

  /** Returns the object with the settings used for calls to insert. */
  public UnaryCallSettings<InsertSecurityPolicyRequest, Operation> insertSettings() {
    return insertSettings;
  }

  /** Returns the object with the settings used for calls to list. */
  public PagedCallSettings<ListSecurityPoliciesRequest, SecurityPolicyList, ListPagedResponse>
      listSettings() {
    return listSettings;
  }

  /** Returns the object with the settings used for calls to listPreconfiguredExpressionSets. */
  public UnaryCallSettings<
          ListPreconfiguredExpressionSetsSecurityPoliciesRequest,
          SecurityPoliciesListPreconfiguredExpressionSetsResponse>
      listPreconfiguredExpressionSetsSettings() {
    return listPreconfiguredExpressionSetsSettings;
  }

  /** Returns the object with the settings used for calls to patch. */
  public UnaryCallSettings<PatchSecurityPolicyRequest, Operation> patchSettings() {
    return patchSettings;
  }

  /** Returns the object with the settings used for calls to patchRule. */
  public UnaryCallSettings<PatchRuleSecurityPolicyRequest, Operation> patchRuleSettings() {
    return patchRuleSettings;
  }

  /** Returns the object with the settings used for calls to removeRule. */
  public UnaryCallSettings<RemoveRuleSecurityPolicyRequest, Operation> removeRuleSettings() {
    return removeRuleSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public SecurityPoliciesStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonSecurityPoliciesStub.create(this);
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
    return "compute.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "compute.mtls.googleapis.com:443";
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
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstantiatingHttpJsonChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultHttpJsonTransportProviderBuilder().build();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(SecurityPoliciesStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
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

  protected SecurityPoliciesStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    addRuleSettings = settingsBuilder.addRuleSettings().build();
    deleteSettings = settingsBuilder.deleteSettings().build();
    getSettings = settingsBuilder.getSettings().build();
    getRuleSettings = settingsBuilder.getRuleSettings().build();
    insertSettings = settingsBuilder.insertSettings().build();
    listSettings = settingsBuilder.listSettings().build();
    listPreconfiguredExpressionSetsSettings =
        settingsBuilder.listPreconfiguredExpressionSetsSettings().build();
    patchSettings = settingsBuilder.patchSettings().build();
    patchRuleSettings = settingsBuilder.patchRuleSettings().build();
    removeRuleSettings = settingsBuilder.removeRuleSettings().build();
  }

  /** Builder for SecurityPoliciesStubSettings. */
  public static class Builder extends StubSettings.Builder<SecurityPoliciesStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<AddRuleSecurityPolicyRequest, Operation>
        addRuleSettings;
    private final UnaryCallSettings.Builder<DeleteSecurityPolicyRequest, Operation> deleteSettings;
    private final UnaryCallSettings.Builder<GetSecurityPolicyRequest, SecurityPolicy> getSettings;
    private final UnaryCallSettings.Builder<GetRuleSecurityPolicyRequest, SecurityPolicyRule>
        getRuleSettings;
    private final UnaryCallSettings.Builder<InsertSecurityPolicyRequest, Operation> insertSettings;
    private final PagedCallSettings.Builder<
            ListSecurityPoliciesRequest, SecurityPolicyList, ListPagedResponse>
        listSettings;
    private final UnaryCallSettings.Builder<
            ListPreconfiguredExpressionSetsSecurityPoliciesRequest,
            SecurityPoliciesListPreconfiguredExpressionSetsResponse>
        listPreconfiguredExpressionSetsSettings;
    private final UnaryCallSettings.Builder<PatchSecurityPolicyRequest, Operation> patchSettings;
    private final UnaryCallSettings.Builder<PatchRuleSecurityPolicyRequest, Operation>
        patchRuleSettings;
    private final UnaryCallSettings.Builder<RemoveRuleSecurityPolicyRequest, Operation>
        removeRuleSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "no_retry_1_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
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
              .setInitialRpcTimeout(Duration.ofMillis(600000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(600000L))
              .setTotalTimeout(Duration.ofMillis(600000L))
              .build();
      definitions.put("no_retry_1_params", settings);
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

      addRuleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getRuleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      insertSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listSettings = PagedCallSettings.newBuilder(LIST_PAGE_STR_FACT);
      listPreconfiguredExpressionSetsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      patchSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      patchRuleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      removeRuleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              addRuleSettings,
              deleteSettings,
              getSettings,
              getRuleSettings,
              insertSettings,
              listSettings,
              listPreconfiguredExpressionSetsSettings,
              patchSettings,
              patchRuleSettings,
              removeRuleSettings);
      initDefaults(this);
    }

    protected Builder(SecurityPoliciesStubSettings settings) {
      super(settings);

      addRuleSettings = settings.addRuleSettings.toBuilder();
      deleteSettings = settings.deleteSettings.toBuilder();
      getSettings = settings.getSettings.toBuilder();
      getRuleSettings = settings.getRuleSettings.toBuilder();
      insertSettings = settings.insertSettings.toBuilder();
      listSettings = settings.listSettings.toBuilder();
      listPreconfiguredExpressionSetsSettings =
          settings.listPreconfiguredExpressionSetsSettings.toBuilder();
      patchSettings = settings.patchSettings.toBuilder();
      patchRuleSettings = settings.patchRuleSettings.toBuilder();
      removeRuleSettings = settings.removeRuleSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              addRuleSettings,
              deleteSettings,
              getSettings,
              getRuleSettings,
              insertSettings,
              listSettings,
              listPreconfiguredExpressionSetsSettings,
              patchSettings,
              patchRuleSettings,
              removeRuleSettings);
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
          .addRuleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getRuleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .insertSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listPreconfiguredExpressionSetsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .patchSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .patchRuleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .removeRuleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      return builder;
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'.
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

    /** Returns the builder for the settings used for calls to addRule. */
    public UnaryCallSettings.Builder<AddRuleSecurityPolicyRequest, Operation> addRuleSettings() {
      return addRuleSettings;
    }

    /** Returns the builder for the settings used for calls to delete. */
    public UnaryCallSettings.Builder<DeleteSecurityPolicyRequest, Operation> deleteSettings() {
      return deleteSettings;
    }

    /** Returns the builder for the settings used for calls to get. */
    public UnaryCallSettings.Builder<GetSecurityPolicyRequest, SecurityPolicy> getSettings() {
      return getSettings;
    }

    /** Returns the builder for the settings used for calls to getRule. */
    public UnaryCallSettings.Builder<GetRuleSecurityPolicyRequest, SecurityPolicyRule>
        getRuleSettings() {
      return getRuleSettings;
    }

    /** Returns the builder for the settings used for calls to insert. */
    public UnaryCallSettings.Builder<InsertSecurityPolicyRequest, Operation> insertSettings() {
      return insertSettings;
    }

    /** Returns the builder for the settings used for calls to list. */
    public PagedCallSettings.Builder<
            ListSecurityPoliciesRequest, SecurityPolicyList, ListPagedResponse>
        listSettings() {
      return listSettings;
    }

    /** Returns the builder for the settings used for calls to listPreconfiguredExpressionSets. */
    public UnaryCallSettings.Builder<
            ListPreconfiguredExpressionSetsSecurityPoliciesRequest,
            SecurityPoliciesListPreconfiguredExpressionSetsResponse>
        listPreconfiguredExpressionSetsSettings() {
      return listPreconfiguredExpressionSetsSettings;
    }

    /** Returns the builder for the settings used for calls to patch. */
    public UnaryCallSettings.Builder<PatchSecurityPolicyRequest, Operation> patchSettings() {
      return patchSettings;
    }

    /** Returns the builder for the settings used for calls to patchRule. */
    public UnaryCallSettings.Builder<PatchRuleSecurityPolicyRequest, Operation>
        patchRuleSettings() {
      return patchRuleSettings;
    }

    /** Returns the builder for the settings used for calls to removeRule. */
    public UnaryCallSettings.Builder<RemoveRuleSecurityPolicyRequest, Operation>
        removeRuleSettings() {
      return removeRuleSettings;
    }

    @Override
    public SecurityPoliciesStubSettings build() throws IOException {
      return new SecurityPoliciesStubSettings(this);
    }
  }
}
