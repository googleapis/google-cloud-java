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

package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.GlobalForwardingRulesClient.ListPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
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
import com.google.cloud.compute.v1.DeleteGlobalForwardingRuleRequest;
import com.google.cloud.compute.v1.ForwardingRule;
import com.google.cloud.compute.v1.ForwardingRuleList;
import com.google.cloud.compute.v1.GetGlobalForwardingRuleRequest;
import com.google.cloud.compute.v1.InsertGlobalForwardingRuleRequest;
import com.google.cloud.compute.v1.ListGlobalForwardingRulesRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchGlobalForwardingRuleRequest;
import com.google.cloud.compute.v1.SetLabelsGlobalForwardingRuleRequest;
import com.google.cloud.compute.v1.SetTargetGlobalForwardingRuleRequest;
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
 * Settings class to configure an instance of {@link GlobalForwardingRulesStub}.
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
 * GlobalForwardingRulesStubSettings.Builder globalForwardingRulesSettingsBuilder =
 *     GlobalForwardingRulesStubSettings.newBuilder();
 * globalForwardingRulesSettingsBuilder
 *     .getSettings()
 *     .setRetrySettings(
 *         globalForwardingRulesSettingsBuilder.getSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * GlobalForwardingRulesStubSettings globalForwardingRulesSettings =
 *     globalForwardingRulesSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class GlobalForwardingRulesStubSettings
    extends StubSettings<GlobalForwardingRulesStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/compute")
          .add("https://www.googleapis.com/auth/cloud-platform")
          .build();

  private final UnaryCallSettings<DeleteGlobalForwardingRuleRequest, Operation> deleteSettings;
  private final OperationCallSettings<DeleteGlobalForwardingRuleRequest, Operation, Operation>
      deleteOperationSettings;
  private final UnaryCallSettings<GetGlobalForwardingRuleRequest, ForwardingRule> getSettings;
  private final UnaryCallSettings<InsertGlobalForwardingRuleRequest, Operation> insertSettings;
  private final OperationCallSettings<InsertGlobalForwardingRuleRequest, Operation, Operation>
      insertOperationSettings;
  private final PagedCallSettings<
          ListGlobalForwardingRulesRequest, ForwardingRuleList, ListPagedResponse>
      listSettings;
  private final UnaryCallSettings<PatchGlobalForwardingRuleRequest, Operation> patchSettings;
  private final OperationCallSettings<PatchGlobalForwardingRuleRequest, Operation, Operation>
      patchOperationSettings;
  private final UnaryCallSettings<SetLabelsGlobalForwardingRuleRequest, Operation>
      setLabelsSettings;
  private final OperationCallSettings<SetLabelsGlobalForwardingRuleRequest, Operation, Operation>
      setLabelsOperationSettings;
  private final UnaryCallSettings<SetTargetGlobalForwardingRuleRequest, Operation>
      setTargetSettings;
  private final OperationCallSettings<SetTargetGlobalForwardingRuleRequest, Operation, Operation>
      setTargetOperationSettings;

  private static final PagedListDescriptor<
          ListGlobalForwardingRulesRequest, ForwardingRuleList, ForwardingRule>
      LIST_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListGlobalForwardingRulesRequest, ForwardingRuleList, ForwardingRule>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListGlobalForwardingRulesRequest injectToken(
                ListGlobalForwardingRulesRequest payload, String token) {
              return ListGlobalForwardingRulesRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListGlobalForwardingRulesRequest injectPageSize(
                ListGlobalForwardingRulesRequest payload, int pageSize) {
              return ListGlobalForwardingRulesRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListGlobalForwardingRulesRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(ForwardingRuleList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ForwardingRule> extractResources(ForwardingRuleList payload) {
              return payload.getItemsList() == null
                  ? ImmutableList.<ForwardingRule>of()
                  : payload.getItemsList();
            }
          };

  private static final PagedListResponseFactory<
          ListGlobalForwardingRulesRequest, ForwardingRuleList, ListPagedResponse>
      LIST_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListGlobalForwardingRulesRequest, ForwardingRuleList, ListPagedResponse>() {
            @Override
            public ApiFuture<ListPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListGlobalForwardingRulesRequest, ForwardingRuleList> callable,
                ListGlobalForwardingRulesRequest request,
                ApiCallContext context,
                ApiFuture<ForwardingRuleList> futureResponse) {
              PageContext<ListGlobalForwardingRulesRequest, ForwardingRuleList, ForwardingRule>
                  pageContext = PageContext.create(callable, LIST_PAGE_STR_DESC, request, context);
              return ListPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to delete. */
  public UnaryCallSettings<DeleteGlobalForwardingRuleRequest, Operation> deleteSettings() {
    return deleteSettings;
  }

  /** Returns the object with the settings used for calls to delete. */
  public OperationCallSettings<DeleteGlobalForwardingRuleRequest, Operation, Operation>
      deleteOperationSettings() {
    return deleteOperationSettings;
  }

  /** Returns the object with the settings used for calls to get. */
  public UnaryCallSettings<GetGlobalForwardingRuleRequest, ForwardingRule> getSettings() {
    return getSettings;
  }

  /** Returns the object with the settings used for calls to insert. */
  public UnaryCallSettings<InsertGlobalForwardingRuleRequest, Operation> insertSettings() {
    return insertSettings;
  }

  /** Returns the object with the settings used for calls to insert. */
  public OperationCallSettings<InsertGlobalForwardingRuleRequest, Operation, Operation>
      insertOperationSettings() {
    return insertOperationSettings;
  }

  /** Returns the object with the settings used for calls to list. */
  public PagedCallSettings<ListGlobalForwardingRulesRequest, ForwardingRuleList, ListPagedResponse>
      listSettings() {
    return listSettings;
  }

  /** Returns the object with the settings used for calls to patch. */
  public UnaryCallSettings<PatchGlobalForwardingRuleRequest, Operation> patchSettings() {
    return patchSettings;
  }

  /** Returns the object with the settings used for calls to patch. */
  public OperationCallSettings<PatchGlobalForwardingRuleRequest, Operation, Operation>
      patchOperationSettings() {
    return patchOperationSettings;
  }

  /** Returns the object with the settings used for calls to setLabels. */
  public UnaryCallSettings<SetLabelsGlobalForwardingRuleRequest, Operation> setLabelsSettings() {
    return setLabelsSettings;
  }

  /** Returns the object with the settings used for calls to setLabels. */
  public OperationCallSettings<SetLabelsGlobalForwardingRuleRequest, Operation, Operation>
      setLabelsOperationSettings() {
    return setLabelsOperationSettings;
  }

  /** Returns the object with the settings used for calls to setTarget. */
  public UnaryCallSettings<SetTargetGlobalForwardingRuleRequest, Operation> setTargetSettings() {
    return setTargetSettings;
  }

  /** Returns the object with the settings used for calls to setTarget. */
  public OperationCallSettings<SetTargetGlobalForwardingRuleRequest, Operation, Operation>
      setTargetOperationSettings() {
    return setTargetOperationSettings;
  }

  public GlobalForwardingRulesStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonGlobalForwardingRulesStub.create(this);
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

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(GlobalForwardingRulesStubSettings.class))
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

  protected GlobalForwardingRulesStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    deleteSettings = settingsBuilder.deleteSettings().build();
    deleteOperationSettings = settingsBuilder.deleteOperationSettings().build();
    getSettings = settingsBuilder.getSettings().build();
    insertSettings = settingsBuilder.insertSettings().build();
    insertOperationSettings = settingsBuilder.insertOperationSettings().build();
    listSettings = settingsBuilder.listSettings().build();
    patchSettings = settingsBuilder.patchSettings().build();
    patchOperationSettings = settingsBuilder.patchOperationSettings().build();
    setLabelsSettings = settingsBuilder.setLabelsSettings().build();
    setLabelsOperationSettings = settingsBuilder.setLabelsOperationSettings().build();
    setTargetSettings = settingsBuilder.setTargetSettings().build();
    setTargetOperationSettings = settingsBuilder.setTargetOperationSettings().build();
  }

  /** Builder for GlobalForwardingRulesStubSettings. */
  public static class Builder
      extends StubSettings.Builder<GlobalForwardingRulesStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<DeleteGlobalForwardingRuleRequest, Operation>
        deleteSettings;
    private final OperationCallSettings.Builder<
            DeleteGlobalForwardingRuleRequest, Operation, Operation>
        deleteOperationSettings;
    private final UnaryCallSettings.Builder<GetGlobalForwardingRuleRequest, ForwardingRule>
        getSettings;
    private final UnaryCallSettings.Builder<InsertGlobalForwardingRuleRequest, Operation>
        insertSettings;
    private final OperationCallSettings.Builder<
            InsertGlobalForwardingRuleRequest, Operation, Operation>
        insertOperationSettings;
    private final PagedCallSettings.Builder<
            ListGlobalForwardingRulesRequest, ForwardingRuleList, ListPagedResponse>
        listSettings;
    private final UnaryCallSettings.Builder<PatchGlobalForwardingRuleRequest, Operation>
        patchSettings;
    private final OperationCallSettings.Builder<
            PatchGlobalForwardingRuleRequest, Operation, Operation>
        patchOperationSettings;
    private final UnaryCallSettings.Builder<SetLabelsGlobalForwardingRuleRequest, Operation>
        setLabelsSettings;
    private final OperationCallSettings.Builder<
            SetLabelsGlobalForwardingRuleRequest, Operation, Operation>
        setLabelsOperationSettings;
    private final UnaryCallSettings.Builder<SetTargetGlobalForwardingRuleRequest, Operation>
        setTargetSettings;
    private final OperationCallSettings.Builder<
            SetTargetGlobalForwardingRuleRequest, Operation, Operation>
        setTargetOperationSettings;
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

      deleteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteOperationSettings = OperationCallSettings.newBuilder();
      getSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      insertSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      insertOperationSettings = OperationCallSettings.newBuilder();
      listSettings = PagedCallSettings.newBuilder(LIST_PAGE_STR_FACT);
      patchSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      patchOperationSettings = OperationCallSettings.newBuilder();
      setLabelsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setLabelsOperationSettings = OperationCallSettings.newBuilder();
      setTargetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setTargetOperationSettings = OperationCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              deleteSettings,
              getSettings,
              insertSettings,
              listSettings,
              patchSettings,
              setLabelsSettings,
              setTargetSettings);
      initDefaults(this);
    }

    protected Builder(GlobalForwardingRulesStubSettings settings) {
      super(settings);

      deleteSettings = settings.deleteSettings.toBuilder();
      deleteOperationSettings = settings.deleteOperationSettings.toBuilder();
      getSettings = settings.getSettings.toBuilder();
      insertSettings = settings.insertSettings.toBuilder();
      insertOperationSettings = settings.insertOperationSettings.toBuilder();
      listSettings = settings.listSettings.toBuilder();
      patchSettings = settings.patchSettings.toBuilder();
      patchOperationSettings = settings.patchOperationSettings.toBuilder();
      setLabelsSettings = settings.setLabelsSettings.toBuilder();
      setLabelsOperationSettings = settings.setLabelsOperationSettings.toBuilder();
      setTargetSettings = settings.setTargetSettings.toBuilder();
      setTargetOperationSettings = settings.setTargetOperationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              deleteSettings,
              getSettings,
              insertSettings,
              listSettings,
              patchSettings,
              setLabelsSettings,
              setTargetSettings);
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
          .deleteSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getSettings()
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
          .setLabelsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .setTargetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteGlobalForwardingRuleRequest, OperationSnapshot>
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
                  .<InsertGlobalForwardingRuleRequest, OperationSnapshot>
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
                  .<PatchGlobalForwardingRuleRequest, OperationSnapshot>
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
          .setLabelsOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<SetLabelsGlobalForwardingRuleRequest, OperationSnapshot>
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
          .setTargetOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<SetTargetGlobalForwardingRuleRequest, OperationSnapshot>
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

    /** Returns the builder for the settings used for calls to delete. */
    public UnaryCallSettings.Builder<DeleteGlobalForwardingRuleRequest, Operation>
        deleteSettings() {
      return deleteSettings;
    }

    /** Returns the builder for the settings used for calls to delete. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteGlobalForwardingRuleRequest, Operation, Operation>
        deleteOperationSettings() {
      return deleteOperationSettings;
    }

    /** Returns the builder for the settings used for calls to get. */
    public UnaryCallSettings.Builder<GetGlobalForwardingRuleRequest, ForwardingRule> getSettings() {
      return getSettings;
    }

    /** Returns the builder for the settings used for calls to insert. */
    public UnaryCallSettings.Builder<InsertGlobalForwardingRuleRequest, Operation>
        insertSettings() {
      return insertSettings;
    }

    /** Returns the builder for the settings used for calls to insert. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<InsertGlobalForwardingRuleRequest, Operation, Operation>
        insertOperationSettings() {
      return insertOperationSettings;
    }

    /** Returns the builder for the settings used for calls to list. */
    public PagedCallSettings.Builder<
            ListGlobalForwardingRulesRequest, ForwardingRuleList, ListPagedResponse>
        listSettings() {
      return listSettings;
    }

    /** Returns the builder for the settings used for calls to patch. */
    public UnaryCallSettings.Builder<PatchGlobalForwardingRuleRequest, Operation> patchSettings() {
      return patchSettings;
    }

    /** Returns the builder for the settings used for calls to patch. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<PatchGlobalForwardingRuleRequest, Operation, Operation>
        patchOperationSettings() {
      return patchOperationSettings;
    }

    /** Returns the builder for the settings used for calls to setLabels. */
    public UnaryCallSettings.Builder<SetLabelsGlobalForwardingRuleRequest, Operation>
        setLabelsSettings() {
      return setLabelsSettings;
    }

    /** Returns the builder for the settings used for calls to setLabels. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<SetLabelsGlobalForwardingRuleRequest, Operation, Operation>
        setLabelsOperationSettings() {
      return setLabelsOperationSettings;
    }

    /** Returns the builder for the settings used for calls to setTarget. */
    public UnaryCallSettings.Builder<SetTargetGlobalForwardingRuleRequest, Operation>
        setTargetSettings() {
      return setTargetSettings;
    }

    /** Returns the builder for the settings used for calls to setTarget. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<SetTargetGlobalForwardingRuleRequest, Operation, Operation>
        setTargetOperationSettings() {
      return setTargetOperationSettings;
    }

    @Override
    public GlobalForwardingRulesStubSettings build() throws IOException {
      return new GlobalForwardingRulesStubSettings(this);
    }
  }
}
