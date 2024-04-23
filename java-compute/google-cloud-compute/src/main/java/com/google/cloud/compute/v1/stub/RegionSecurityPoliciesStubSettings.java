/*
 * Copyright 2024 Google LLC
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

import static com.google.cloud.compute.v1.RegionSecurityPoliciesClient.ListPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.httpjson.ProtoOperationTransformers;
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
import com.google.cloud.compute.v1.AddRuleRegionSecurityPolicyRequest;
import com.google.cloud.compute.v1.DeleteRegionSecurityPolicyRequest;
import com.google.cloud.compute.v1.GetRegionSecurityPolicyRequest;
import com.google.cloud.compute.v1.GetRuleRegionSecurityPolicyRequest;
import com.google.cloud.compute.v1.InsertRegionSecurityPolicyRequest;
import com.google.cloud.compute.v1.ListRegionSecurityPoliciesRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchRegionSecurityPolicyRequest;
import com.google.cloud.compute.v1.PatchRuleRegionSecurityPolicyRequest;
import com.google.cloud.compute.v1.RemoveRuleRegionSecurityPolicyRequest;
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
 * Settings class to configure an instance of {@link RegionSecurityPoliciesStub}.
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
 * <p>For example, to set the total timeout of get to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * RegionSecurityPoliciesStubSettings.Builder regionSecurityPoliciesSettingsBuilder =
 *     RegionSecurityPoliciesStubSettings.newBuilder();
 * regionSecurityPoliciesSettingsBuilder
 *     .getSettings()
 *     .setRetrySettings(
 *         regionSecurityPoliciesSettingsBuilder
 *             .getSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * RegionSecurityPoliciesStubSettings regionSecurityPoliciesSettings =
 *     regionSecurityPoliciesSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class RegionSecurityPoliciesStubSettings
    extends StubSettings<RegionSecurityPoliciesStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/compute")
          .add("https://www.googleapis.com/auth/cloud-platform")
          .build();

  private final UnaryCallSettings<AddRuleRegionSecurityPolicyRequest, Operation> addRuleSettings;
  private final OperationCallSettings<AddRuleRegionSecurityPolicyRequest, Operation, Operation>
      addRuleOperationSettings;
  private final UnaryCallSettings<DeleteRegionSecurityPolicyRequest, Operation> deleteSettings;
  private final OperationCallSettings<DeleteRegionSecurityPolicyRequest, Operation, Operation>
      deleteOperationSettings;
  private final UnaryCallSettings<GetRegionSecurityPolicyRequest, SecurityPolicy> getSettings;
  private final UnaryCallSettings<GetRuleRegionSecurityPolicyRequest, SecurityPolicyRule>
      getRuleSettings;
  private final UnaryCallSettings<InsertRegionSecurityPolicyRequest, Operation> insertSettings;
  private final OperationCallSettings<InsertRegionSecurityPolicyRequest, Operation, Operation>
      insertOperationSettings;
  private final PagedCallSettings<
          ListRegionSecurityPoliciesRequest, SecurityPolicyList, ListPagedResponse>
      listSettings;
  private final UnaryCallSettings<PatchRegionSecurityPolicyRequest, Operation> patchSettings;
  private final OperationCallSettings<PatchRegionSecurityPolicyRequest, Operation, Operation>
      patchOperationSettings;
  private final UnaryCallSettings<PatchRuleRegionSecurityPolicyRequest, Operation>
      patchRuleSettings;
  private final OperationCallSettings<PatchRuleRegionSecurityPolicyRequest, Operation, Operation>
      patchRuleOperationSettings;
  private final UnaryCallSettings<RemoveRuleRegionSecurityPolicyRequest, Operation>
      removeRuleSettings;
  private final OperationCallSettings<RemoveRuleRegionSecurityPolicyRequest, Operation, Operation>
      removeRuleOperationSettings;

  private static final PagedListDescriptor<
          ListRegionSecurityPoliciesRequest, SecurityPolicyList, SecurityPolicy>
      LIST_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListRegionSecurityPoliciesRequest, SecurityPolicyList, SecurityPolicy>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListRegionSecurityPoliciesRequest injectToken(
                ListRegionSecurityPoliciesRequest payload, String token) {
              return ListRegionSecurityPoliciesRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListRegionSecurityPoliciesRequest injectPageSize(
                ListRegionSecurityPoliciesRequest payload, int pageSize) {
              return ListRegionSecurityPoliciesRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListRegionSecurityPoliciesRequest payload) {
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
          ListRegionSecurityPoliciesRequest, SecurityPolicyList, ListPagedResponse>
      LIST_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListRegionSecurityPoliciesRequest, SecurityPolicyList, ListPagedResponse>() {
            @Override
            public ApiFuture<ListPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListRegionSecurityPoliciesRequest, SecurityPolicyList> callable,
                ListRegionSecurityPoliciesRequest request,
                ApiCallContext context,
                ApiFuture<SecurityPolicyList> futureResponse) {
              PageContext<ListRegionSecurityPoliciesRequest, SecurityPolicyList, SecurityPolicy>
                  pageContext = PageContext.create(callable, LIST_PAGE_STR_DESC, request, context);
              return ListPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to addRule. */
  public UnaryCallSettings<AddRuleRegionSecurityPolicyRequest, Operation> addRuleSettings() {
    return addRuleSettings;
  }

  /** Returns the object with the settings used for calls to addRule. */
  public OperationCallSettings<AddRuleRegionSecurityPolicyRequest, Operation, Operation>
      addRuleOperationSettings() {
    return addRuleOperationSettings;
  }

  /** Returns the object with the settings used for calls to delete. */
  public UnaryCallSettings<DeleteRegionSecurityPolicyRequest, Operation> deleteSettings() {
    return deleteSettings;
  }

  /** Returns the object with the settings used for calls to delete. */
  public OperationCallSettings<DeleteRegionSecurityPolicyRequest, Operation, Operation>
      deleteOperationSettings() {
    return deleteOperationSettings;
  }

  /** Returns the object with the settings used for calls to get. */
  public UnaryCallSettings<GetRegionSecurityPolicyRequest, SecurityPolicy> getSettings() {
    return getSettings;
  }

  /** Returns the object with the settings used for calls to getRule. */
  public UnaryCallSettings<GetRuleRegionSecurityPolicyRequest, SecurityPolicyRule>
      getRuleSettings() {
    return getRuleSettings;
  }

  /** Returns the object with the settings used for calls to insert. */
  public UnaryCallSettings<InsertRegionSecurityPolicyRequest, Operation> insertSettings() {
    return insertSettings;
  }

  /** Returns the object with the settings used for calls to insert. */
  public OperationCallSettings<InsertRegionSecurityPolicyRequest, Operation, Operation>
      insertOperationSettings() {
    return insertOperationSettings;
  }

  /** Returns the object with the settings used for calls to list. */
  public PagedCallSettings<ListRegionSecurityPoliciesRequest, SecurityPolicyList, ListPagedResponse>
      listSettings() {
    return listSettings;
  }

  /** Returns the object with the settings used for calls to patch. */
  public UnaryCallSettings<PatchRegionSecurityPolicyRequest, Operation> patchSettings() {
    return patchSettings;
  }

  /** Returns the object with the settings used for calls to patch. */
  public OperationCallSettings<PatchRegionSecurityPolicyRequest, Operation, Operation>
      patchOperationSettings() {
    return patchOperationSettings;
  }

  /** Returns the object with the settings used for calls to patchRule. */
  public UnaryCallSettings<PatchRuleRegionSecurityPolicyRequest, Operation> patchRuleSettings() {
    return patchRuleSettings;
  }

  /** Returns the object with the settings used for calls to patchRule. */
  public OperationCallSettings<PatchRuleRegionSecurityPolicyRequest, Operation, Operation>
      patchRuleOperationSettings() {
    return patchRuleOperationSettings;
  }

  /** Returns the object with the settings used for calls to removeRule. */
  public UnaryCallSettings<RemoveRuleRegionSecurityPolicyRequest, Operation> removeRuleSettings() {
    return removeRuleSettings;
  }

  /** Returns the object with the settings used for calls to removeRule. */
  public OperationCallSettings<RemoveRuleRegionSecurityPolicyRequest, Operation, Operation>
      removeRuleOperationSettings() {
    return removeRuleOperationSettings;
  }

  public RegionSecurityPoliciesStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonRegionSecurityPoliciesStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "compute";
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
    return GoogleCredentialsProvider.newBuilder()
        .setScopesToApply(DEFAULT_SERVICE_SCOPES)
        .setUseJwtAccessWithScope(true);
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstantiatingHttpJsonChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultHttpJsonTransportProviderBuilder().build();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(RegionSecurityPoliciesStubSettings.class))
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

  protected RegionSecurityPoliciesStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    addRuleSettings = settingsBuilder.addRuleSettings().build();
    addRuleOperationSettings = settingsBuilder.addRuleOperationSettings().build();
    deleteSettings = settingsBuilder.deleteSettings().build();
    deleteOperationSettings = settingsBuilder.deleteOperationSettings().build();
    getSettings = settingsBuilder.getSettings().build();
    getRuleSettings = settingsBuilder.getRuleSettings().build();
    insertSettings = settingsBuilder.insertSettings().build();
    insertOperationSettings = settingsBuilder.insertOperationSettings().build();
    listSettings = settingsBuilder.listSettings().build();
    patchSettings = settingsBuilder.patchSettings().build();
    patchOperationSettings = settingsBuilder.patchOperationSettings().build();
    patchRuleSettings = settingsBuilder.patchRuleSettings().build();
    patchRuleOperationSettings = settingsBuilder.patchRuleOperationSettings().build();
    removeRuleSettings = settingsBuilder.removeRuleSettings().build();
    removeRuleOperationSettings = settingsBuilder.removeRuleOperationSettings().build();
  }

  /** Builder for RegionSecurityPoliciesStubSettings. */
  public static class Builder
      extends StubSettings.Builder<RegionSecurityPoliciesStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<AddRuleRegionSecurityPolicyRequest, Operation>
        addRuleSettings;
    private final OperationCallSettings.Builder<
            AddRuleRegionSecurityPolicyRequest, Operation, Operation>
        addRuleOperationSettings;
    private final UnaryCallSettings.Builder<DeleteRegionSecurityPolicyRequest, Operation>
        deleteSettings;
    private final OperationCallSettings.Builder<
            DeleteRegionSecurityPolicyRequest, Operation, Operation>
        deleteOperationSettings;
    private final UnaryCallSettings.Builder<GetRegionSecurityPolicyRequest, SecurityPolicy>
        getSettings;
    private final UnaryCallSettings.Builder<GetRuleRegionSecurityPolicyRequest, SecurityPolicyRule>
        getRuleSettings;
    private final UnaryCallSettings.Builder<InsertRegionSecurityPolicyRequest, Operation>
        insertSettings;
    private final OperationCallSettings.Builder<
            InsertRegionSecurityPolicyRequest, Operation, Operation>
        insertOperationSettings;
    private final PagedCallSettings.Builder<
            ListRegionSecurityPoliciesRequest, SecurityPolicyList, ListPagedResponse>
        listSettings;
    private final UnaryCallSettings.Builder<PatchRegionSecurityPolicyRequest, Operation>
        patchSettings;
    private final OperationCallSettings.Builder<
            PatchRegionSecurityPolicyRequest, Operation, Operation>
        patchOperationSettings;
    private final UnaryCallSettings.Builder<PatchRuleRegionSecurityPolicyRequest, Operation>
        patchRuleSettings;
    private final OperationCallSettings.Builder<
            PatchRuleRegionSecurityPolicyRequest, Operation, Operation>
        patchRuleOperationSettings;
    private final UnaryCallSettings.Builder<RemoveRuleRegionSecurityPolicyRequest, Operation>
        removeRuleSettings;
    private final OperationCallSettings.Builder<
            RemoveRuleRegionSecurityPolicyRequest, Operation, Operation>
        removeRuleOperationSettings;
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
      addRuleOperationSettings = OperationCallSettings.newBuilder();
      deleteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteOperationSettings = OperationCallSettings.newBuilder();
      getSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getRuleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      insertSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      insertOperationSettings = OperationCallSettings.newBuilder();
      listSettings = PagedCallSettings.newBuilder(LIST_PAGE_STR_FACT);
      patchSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      patchOperationSettings = OperationCallSettings.newBuilder();
      patchRuleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      patchRuleOperationSettings = OperationCallSettings.newBuilder();
      removeRuleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      removeRuleOperationSettings = OperationCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              addRuleSettings,
              deleteSettings,
              getSettings,
              getRuleSettings,
              insertSettings,
              listSettings,
              patchSettings,
              patchRuleSettings,
              removeRuleSettings);
      initDefaults(this);
    }

    protected Builder(RegionSecurityPoliciesStubSettings settings) {
      super(settings);

      addRuleSettings = settings.addRuleSettings.toBuilder();
      addRuleOperationSettings = settings.addRuleOperationSettings.toBuilder();
      deleteSettings = settings.deleteSettings.toBuilder();
      deleteOperationSettings = settings.deleteOperationSettings.toBuilder();
      getSettings = settings.getSettings.toBuilder();
      getRuleSettings = settings.getRuleSettings.toBuilder();
      insertSettings = settings.insertSettings.toBuilder();
      insertOperationSettings = settings.insertOperationSettings.toBuilder();
      listSettings = settings.listSettings.toBuilder();
      patchSettings = settings.patchSettings.toBuilder();
      patchOperationSettings = settings.patchOperationSettings.toBuilder();
      patchRuleSettings = settings.patchRuleSettings.toBuilder();
      patchRuleOperationSettings = settings.patchRuleOperationSettings.toBuilder();
      removeRuleSettings = settings.removeRuleSettings.toBuilder();
      removeRuleOperationSettings = settings.removeRuleOperationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              addRuleSettings,
              deleteSettings,
              getSettings,
              getRuleSettings,
              insertSettings,
              listSettings,
              patchSettings,
              patchRuleSettings,
              removeRuleSettings);
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

      builder
          .addRuleOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<AddRuleRegionSecurityPolicyRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(20000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(600000L))
                      .build()));

      builder
          .deleteOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteRegionSecurityPolicyRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(20000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(600000L))
                      .build()));

      builder
          .insertOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<InsertRegionSecurityPolicyRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(20000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(600000L))
                      .build()));

      builder
          .patchOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<PatchRegionSecurityPolicyRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(20000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(600000L))
                      .build()));

      builder
          .patchRuleOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<PatchRuleRegionSecurityPolicyRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(20000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(600000L))
                      .build()));

      builder
          .removeRuleOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<RemoveRuleRegionSecurityPolicyRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(20000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(600000L))
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

    /** Returns the builder for the settings used for calls to addRule. */
    public UnaryCallSettings.Builder<AddRuleRegionSecurityPolicyRequest, Operation>
        addRuleSettings() {
      return addRuleSettings;
    }

    /** Returns the builder for the settings used for calls to addRule. */
    public OperationCallSettings.Builder<AddRuleRegionSecurityPolicyRequest, Operation, Operation>
        addRuleOperationSettings() {
      return addRuleOperationSettings;
    }

    /** Returns the builder for the settings used for calls to delete. */
    public UnaryCallSettings.Builder<DeleteRegionSecurityPolicyRequest, Operation>
        deleteSettings() {
      return deleteSettings;
    }

    /** Returns the builder for the settings used for calls to delete. */
    public OperationCallSettings.Builder<DeleteRegionSecurityPolicyRequest, Operation, Operation>
        deleteOperationSettings() {
      return deleteOperationSettings;
    }

    /** Returns the builder for the settings used for calls to get. */
    public UnaryCallSettings.Builder<GetRegionSecurityPolicyRequest, SecurityPolicy> getSettings() {
      return getSettings;
    }

    /** Returns the builder for the settings used for calls to getRule. */
    public UnaryCallSettings.Builder<GetRuleRegionSecurityPolicyRequest, SecurityPolicyRule>
        getRuleSettings() {
      return getRuleSettings;
    }

    /** Returns the builder for the settings used for calls to insert. */
    public UnaryCallSettings.Builder<InsertRegionSecurityPolicyRequest, Operation>
        insertSettings() {
      return insertSettings;
    }

    /** Returns the builder for the settings used for calls to insert. */
    public OperationCallSettings.Builder<InsertRegionSecurityPolicyRequest, Operation, Operation>
        insertOperationSettings() {
      return insertOperationSettings;
    }

    /** Returns the builder for the settings used for calls to list. */
    public PagedCallSettings.Builder<
            ListRegionSecurityPoliciesRequest, SecurityPolicyList, ListPagedResponse>
        listSettings() {
      return listSettings;
    }

    /** Returns the builder for the settings used for calls to patch. */
    public UnaryCallSettings.Builder<PatchRegionSecurityPolicyRequest, Operation> patchSettings() {
      return patchSettings;
    }

    /** Returns the builder for the settings used for calls to patch. */
    public OperationCallSettings.Builder<PatchRegionSecurityPolicyRequest, Operation, Operation>
        patchOperationSettings() {
      return patchOperationSettings;
    }

    /** Returns the builder for the settings used for calls to patchRule. */
    public UnaryCallSettings.Builder<PatchRuleRegionSecurityPolicyRequest, Operation>
        patchRuleSettings() {
      return patchRuleSettings;
    }

    /** Returns the builder for the settings used for calls to patchRule. */
    public OperationCallSettings.Builder<PatchRuleRegionSecurityPolicyRequest, Operation, Operation>
        patchRuleOperationSettings() {
      return patchRuleOperationSettings;
    }

    /** Returns the builder for the settings used for calls to removeRule. */
    public UnaryCallSettings.Builder<RemoveRuleRegionSecurityPolicyRequest, Operation>
        removeRuleSettings() {
      return removeRuleSettings;
    }

    /** Returns the builder for the settings used for calls to removeRule. */
    public OperationCallSettings.Builder<
            RemoveRuleRegionSecurityPolicyRequest, Operation, Operation>
        removeRuleOperationSettings() {
      return removeRuleOperationSettings;
    }

    @Override
    public RegionSecurityPoliciesStubSettings build() throws IOException {
      return new RegionSecurityPoliciesStubSettings(this);
    }
  }
}
