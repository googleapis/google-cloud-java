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

import static com.google.cloud.compute.v1.BackendBucketsClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.AddSignedUrlKeyBackendBucketRequest;
import com.google.cloud.compute.v1.BackendBucket;
import com.google.cloud.compute.v1.BackendBucketList;
import com.google.cloud.compute.v1.DeleteBackendBucketRequest;
import com.google.cloud.compute.v1.DeleteSignedUrlKeyBackendBucketRequest;
import com.google.cloud.compute.v1.GetBackendBucketRequest;
import com.google.cloud.compute.v1.InsertBackendBucketRequest;
import com.google.cloud.compute.v1.ListBackendBucketsRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchBackendBucketRequest;
import com.google.cloud.compute.v1.SetEdgeSecurityPolicyBackendBucketRequest;
import com.google.cloud.compute.v1.UpdateBackendBucketRequest;
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
 * Settings class to configure an instance of {@link BackendBucketsStub}.
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
 * BackendBucketsStubSettings.Builder backendBucketsSettingsBuilder =
 *     BackendBucketsStubSettings.newBuilder();
 * backendBucketsSettingsBuilder
 *     .getSettings()
 *     .setRetrySettings(
 *         backendBucketsSettingsBuilder.getSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * BackendBucketsStubSettings backendBucketsSettings = backendBucketsSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class BackendBucketsStubSettings extends StubSettings<BackendBucketsStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/compute")
          .add("https://www.googleapis.com/auth/cloud-platform")
          .build();

  private final UnaryCallSettings<AddSignedUrlKeyBackendBucketRequest, Operation>
      addSignedUrlKeySettings;
  private final OperationCallSettings<AddSignedUrlKeyBackendBucketRequest, Operation, Operation>
      addSignedUrlKeyOperationSettings;
  private final UnaryCallSettings<DeleteBackendBucketRequest, Operation> deleteSettings;
  private final OperationCallSettings<DeleteBackendBucketRequest, Operation, Operation>
      deleteOperationSettings;
  private final UnaryCallSettings<DeleteSignedUrlKeyBackendBucketRequest, Operation>
      deleteSignedUrlKeySettings;
  private final OperationCallSettings<DeleteSignedUrlKeyBackendBucketRequest, Operation, Operation>
      deleteSignedUrlKeyOperationSettings;
  private final UnaryCallSettings<GetBackendBucketRequest, BackendBucket> getSettings;
  private final UnaryCallSettings<InsertBackendBucketRequest, Operation> insertSettings;
  private final OperationCallSettings<InsertBackendBucketRequest, Operation, Operation>
      insertOperationSettings;
  private final PagedCallSettings<ListBackendBucketsRequest, BackendBucketList, ListPagedResponse>
      listSettings;
  private final UnaryCallSettings<PatchBackendBucketRequest, Operation> patchSettings;
  private final OperationCallSettings<PatchBackendBucketRequest, Operation, Operation>
      patchOperationSettings;
  private final UnaryCallSettings<SetEdgeSecurityPolicyBackendBucketRequest, Operation>
      setEdgeSecurityPolicySettings;
  private final OperationCallSettings<
          SetEdgeSecurityPolicyBackendBucketRequest, Operation, Operation>
      setEdgeSecurityPolicyOperationSettings;
  private final UnaryCallSettings<UpdateBackendBucketRequest, Operation> updateSettings;
  private final OperationCallSettings<UpdateBackendBucketRequest, Operation, Operation>
      updateOperationSettings;

  private static final PagedListDescriptor<
          ListBackendBucketsRequest, BackendBucketList, BackendBucket>
      LIST_PAGE_STR_DESC =
          new PagedListDescriptor<ListBackendBucketsRequest, BackendBucketList, BackendBucket>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListBackendBucketsRequest injectToken(
                ListBackendBucketsRequest payload, String token) {
              return ListBackendBucketsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListBackendBucketsRequest injectPageSize(
                ListBackendBucketsRequest payload, int pageSize) {
              return ListBackendBucketsRequest.newBuilder(payload).setMaxResults(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListBackendBucketsRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(BackendBucketList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<BackendBucket> extractResources(BackendBucketList payload) {
              return payload.getItemsList() == null
                  ? ImmutableList.<BackendBucket>of()
                  : payload.getItemsList();
            }
          };

  private static final PagedListResponseFactory<
          ListBackendBucketsRequest, BackendBucketList, ListPagedResponse>
      LIST_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListBackendBucketsRequest, BackendBucketList, ListPagedResponse>() {
            @Override
            public ApiFuture<ListPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListBackendBucketsRequest, BackendBucketList> callable,
                ListBackendBucketsRequest request,
                ApiCallContext context,
                ApiFuture<BackendBucketList> futureResponse) {
              PageContext<ListBackendBucketsRequest, BackendBucketList, BackendBucket> pageContext =
                  PageContext.create(callable, LIST_PAGE_STR_DESC, request, context);
              return ListPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to addSignedUrlKey. */
  public UnaryCallSettings<AddSignedUrlKeyBackendBucketRequest, Operation>
      addSignedUrlKeySettings() {
    return addSignedUrlKeySettings;
  }

  /** Returns the object with the settings used for calls to addSignedUrlKey. */
  public OperationCallSettings<AddSignedUrlKeyBackendBucketRequest, Operation, Operation>
      addSignedUrlKeyOperationSettings() {
    return addSignedUrlKeyOperationSettings;
  }

  /** Returns the object with the settings used for calls to delete. */
  public UnaryCallSettings<DeleteBackendBucketRequest, Operation> deleteSettings() {
    return deleteSettings;
  }

  /** Returns the object with the settings used for calls to delete. */
  public OperationCallSettings<DeleteBackendBucketRequest, Operation, Operation>
      deleteOperationSettings() {
    return deleteOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteSignedUrlKey. */
  public UnaryCallSettings<DeleteSignedUrlKeyBackendBucketRequest, Operation>
      deleteSignedUrlKeySettings() {
    return deleteSignedUrlKeySettings;
  }

  /** Returns the object with the settings used for calls to deleteSignedUrlKey. */
  public OperationCallSettings<DeleteSignedUrlKeyBackendBucketRequest, Operation, Operation>
      deleteSignedUrlKeyOperationSettings() {
    return deleteSignedUrlKeyOperationSettings;
  }

  /** Returns the object with the settings used for calls to get. */
  public UnaryCallSettings<GetBackendBucketRequest, BackendBucket> getSettings() {
    return getSettings;
  }

  /** Returns the object with the settings used for calls to insert. */
  public UnaryCallSettings<InsertBackendBucketRequest, Operation> insertSettings() {
    return insertSettings;
  }

  /** Returns the object with the settings used for calls to insert. */
  public OperationCallSettings<InsertBackendBucketRequest, Operation, Operation>
      insertOperationSettings() {
    return insertOperationSettings;
  }

  /** Returns the object with the settings used for calls to list. */
  public PagedCallSettings<ListBackendBucketsRequest, BackendBucketList, ListPagedResponse>
      listSettings() {
    return listSettings;
  }

  /** Returns the object with the settings used for calls to patch. */
  public UnaryCallSettings<PatchBackendBucketRequest, Operation> patchSettings() {
    return patchSettings;
  }

  /** Returns the object with the settings used for calls to patch. */
  public OperationCallSettings<PatchBackendBucketRequest, Operation, Operation>
      patchOperationSettings() {
    return patchOperationSettings;
  }

  /** Returns the object with the settings used for calls to setEdgeSecurityPolicy. */
  public UnaryCallSettings<SetEdgeSecurityPolicyBackendBucketRequest, Operation>
      setEdgeSecurityPolicySettings() {
    return setEdgeSecurityPolicySettings;
  }

  /** Returns the object with the settings used for calls to setEdgeSecurityPolicy. */
  public OperationCallSettings<SetEdgeSecurityPolicyBackendBucketRequest, Operation, Operation>
      setEdgeSecurityPolicyOperationSettings() {
    return setEdgeSecurityPolicyOperationSettings;
  }

  /** Returns the object with the settings used for calls to update. */
  public UnaryCallSettings<UpdateBackendBucketRequest, Operation> updateSettings() {
    return updateSettings;
  }

  /** Returns the object with the settings used for calls to update. */
  public OperationCallSettings<UpdateBackendBucketRequest, Operation, Operation>
      updateOperationSettings() {
    return updateOperationSettings;
  }

  public BackendBucketsStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonBackendBucketsStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(BackendBucketsStubSettings.class))
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

  protected BackendBucketsStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    addSignedUrlKeySettings = settingsBuilder.addSignedUrlKeySettings().build();
    addSignedUrlKeyOperationSettings = settingsBuilder.addSignedUrlKeyOperationSettings().build();
    deleteSettings = settingsBuilder.deleteSettings().build();
    deleteOperationSettings = settingsBuilder.deleteOperationSettings().build();
    deleteSignedUrlKeySettings = settingsBuilder.deleteSignedUrlKeySettings().build();
    deleteSignedUrlKeyOperationSettings =
        settingsBuilder.deleteSignedUrlKeyOperationSettings().build();
    getSettings = settingsBuilder.getSettings().build();
    insertSettings = settingsBuilder.insertSettings().build();
    insertOperationSettings = settingsBuilder.insertOperationSettings().build();
    listSettings = settingsBuilder.listSettings().build();
    patchSettings = settingsBuilder.patchSettings().build();
    patchOperationSettings = settingsBuilder.patchOperationSettings().build();
    setEdgeSecurityPolicySettings = settingsBuilder.setEdgeSecurityPolicySettings().build();
    setEdgeSecurityPolicyOperationSettings =
        settingsBuilder.setEdgeSecurityPolicyOperationSettings().build();
    updateSettings = settingsBuilder.updateSettings().build();
    updateOperationSettings = settingsBuilder.updateOperationSettings().build();
  }

  /** Builder for BackendBucketsStubSettings. */
  public static class Builder extends StubSettings.Builder<BackendBucketsStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<AddSignedUrlKeyBackendBucketRequest, Operation>
        addSignedUrlKeySettings;
    private final OperationCallSettings.Builder<
            AddSignedUrlKeyBackendBucketRequest, Operation, Operation>
        addSignedUrlKeyOperationSettings;
    private final UnaryCallSettings.Builder<DeleteBackendBucketRequest, Operation> deleteSettings;
    private final OperationCallSettings.Builder<DeleteBackendBucketRequest, Operation, Operation>
        deleteOperationSettings;
    private final UnaryCallSettings.Builder<DeleteSignedUrlKeyBackendBucketRequest, Operation>
        deleteSignedUrlKeySettings;
    private final OperationCallSettings.Builder<
            DeleteSignedUrlKeyBackendBucketRequest, Operation, Operation>
        deleteSignedUrlKeyOperationSettings;
    private final UnaryCallSettings.Builder<GetBackendBucketRequest, BackendBucket> getSettings;
    private final UnaryCallSettings.Builder<InsertBackendBucketRequest, Operation> insertSettings;
    private final OperationCallSettings.Builder<InsertBackendBucketRequest, Operation, Operation>
        insertOperationSettings;
    private final PagedCallSettings.Builder<
            ListBackendBucketsRequest, BackendBucketList, ListPagedResponse>
        listSettings;
    private final UnaryCallSettings.Builder<PatchBackendBucketRequest, Operation> patchSettings;
    private final OperationCallSettings.Builder<PatchBackendBucketRequest, Operation, Operation>
        patchOperationSettings;
    private final UnaryCallSettings.Builder<SetEdgeSecurityPolicyBackendBucketRequest, Operation>
        setEdgeSecurityPolicySettings;
    private final OperationCallSettings.Builder<
            SetEdgeSecurityPolicyBackendBucketRequest, Operation, Operation>
        setEdgeSecurityPolicyOperationSettings;
    private final UnaryCallSettings.Builder<UpdateBackendBucketRequest, Operation> updateSettings;
    private final OperationCallSettings.Builder<UpdateBackendBucketRequest, Operation, Operation>
        updateOperationSettings;
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

      addSignedUrlKeySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      addSignedUrlKeyOperationSettings = OperationCallSettings.newBuilder();
      deleteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteOperationSettings = OperationCallSettings.newBuilder();
      deleteSignedUrlKeySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteSignedUrlKeyOperationSettings = OperationCallSettings.newBuilder();
      getSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      insertSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      insertOperationSettings = OperationCallSettings.newBuilder();
      listSettings = PagedCallSettings.newBuilder(LIST_PAGE_STR_FACT);
      patchSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      patchOperationSettings = OperationCallSettings.newBuilder();
      setEdgeSecurityPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setEdgeSecurityPolicyOperationSettings = OperationCallSettings.newBuilder();
      updateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateOperationSettings = OperationCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              addSignedUrlKeySettings,
              deleteSettings,
              deleteSignedUrlKeySettings,
              getSettings,
              insertSettings,
              listSettings,
              patchSettings,
              setEdgeSecurityPolicySettings,
              updateSettings);
      initDefaults(this);
    }

    protected Builder(BackendBucketsStubSettings settings) {
      super(settings);

      addSignedUrlKeySettings = settings.addSignedUrlKeySettings.toBuilder();
      addSignedUrlKeyOperationSettings = settings.addSignedUrlKeyOperationSettings.toBuilder();
      deleteSettings = settings.deleteSettings.toBuilder();
      deleteOperationSettings = settings.deleteOperationSettings.toBuilder();
      deleteSignedUrlKeySettings = settings.deleteSignedUrlKeySettings.toBuilder();
      deleteSignedUrlKeyOperationSettings =
          settings.deleteSignedUrlKeyOperationSettings.toBuilder();
      getSettings = settings.getSettings.toBuilder();
      insertSettings = settings.insertSettings.toBuilder();
      insertOperationSettings = settings.insertOperationSettings.toBuilder();
      listSettings = settings.listSettings.toBuilder();
      patchSettings = settings.patchSettings.toBuilder();
      patchOperationSettings = settings.patchOperationSettings.toBuilder();
      setEdgeSecurityPolicySettings = settings.setEdgeSecurityPolicySettings.toBuilder();
      setEdgeSecurityPolicyOperationSettings =
          settings.setEdgeSecurityPolicyOperationSettings.toBuilder();
      updateSettings = settings.updateSettings.toBuilder();
      updateOperationSettings = settings.updateOperationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              addSignedUrlKeySettings,
              deleteSettings,
              deleteSignedUrlKeySettings,
              getSettings,
              insertSettings,
              listSettings,
              patchSettings,
              setEdgeSecurityPolicySettings,
              updateSettings);
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
          .addSignedUrlKeySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteSignedUrlKeySettings()
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
          .setEdgeSecurityPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .addSignedUrlKeyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<AddSignedUrlKeyBackendBucketRequest, OperationSnapshot>
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
                  .<DeleteBackendBucketRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
          .deleteSignedUrlKeyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteSignedUrlKeyBackendBucketRequest, OperationSnapshot>
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
                  .<InsertBackendBucketRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
                  .<PatchBackendBucketRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
          .setEdgeSecurityPolicyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<SetEdgeSecurityPolicyBackendBucketRequest, OperationSnapshot>
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
          .updateOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateBackendBucketRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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

    /** Returns the builder for the settings used for calls to addSignedUrlKey. */
    public UnaryCallSettings.Builder<AddSignedUrlKeyBackendBucketRequest, Operation>
        addSignedUrlKeySettings() {
      return addSignedUrlKeySettings;
    }

    /** Returns the builder for the settings used for calls to addSignedUrlKey. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<AddSignedUrlKeyBackendBucketRequest, Operation, Operation>
        addSignedUrlKeyOperationSettings() {
      return addSignedUrlKeyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to delete. */
    public UnaryCallSettings.Builder<DeleteBackendBucketRequest, Operation> deleteSettings() {
      return deleteSettings;
    }

    /** Returns the builder for the settings used for calls to delete. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteBackendBucketRequest, Operation, Operation>
        deleteOperationSettings() {
      return deleteOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteSignedUrlKey. */
    public UnaryCallSettings.Builder<DeleteSignedUrlKeyBackendBucketRequest, Operation>
        deleteSignedUrlKeySettings() {
      return deleteSignedUrlKeySettings;
    }

    /** Returns the builder for the settings used for calls to deleteSignedUrlKey. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            DeleteSignedUrlKeyBackendBucketRequest, Operation, Operation>
        deleteSignedUrlKeyOperationSettings() {
      return deleteSignedUrlKeyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to get. */
    public UnaryCallSettings.Builder<GetBackendBucketRequest, BackendBucket> getSettings() {
      return getSettings;
    }

    /** Returns the builder for the settings used for calls to insert. */
    public UnaryCallSettings.Builder<InsertBackendBucketRequest, Operation> insertSettings() {
      return insertSettings;
    }

    /** Returns the builder for the settings used for calls to insert. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<InsertBackendBucketRequest, Operation, Operation>
        insertOperationSettings() {
      return insertOperationSettings;
    }

    /** Returns the builder for the settings used for calls to list. */
    public PagedCallSettings.Builder<
            ListBackendBucketsRequest, BackendBucketList, ListPagedResponse>
        listSettings() {
      return listSettings;
    }

    /** Returns the builder for the settings used for calls to patch. */
    public UnaryCallSettings.Builder<PatchBackendBucketRequest, Operation> patchSettings() {
      return patchSettings;
    }

    /** Returns the builder for the settings used for calls to patch. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<PatchBackendBucketRequest, Operation, Operation>
        patchOperationSettings() {
      return patchOperationSettings;
    }

    /** Returns the builder for the settings used for calls to setEdgeSecurityPolicy. */
    public UnaryCallSettings.Builder<SetEdgeSecurityPolicyBackendBucketRequest, Operation>
        setEdgeSecurityPolicySettings() {
      return setEdgeSecurityPolicySettings;
    }

    /** Returns the builder for the settings used for calls to setEdgeSecurityPolicy. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            SetEdgeSecurityPolicyBackendBucketRequest, Operation, Operation>
        setEdgeSecurityPolicyOperationSettings() {
      return setEdgeSecurityPolicyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to update. */
    public UnaryCallSettings.Builder<UpdateBackendBucketRequest, Operation> updateSettings() {
      return updateSettings;
    }

    /** Returns the builder for the settings used for calls to update. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<UpdateBackendBucketRequest, Operation, Operation>
        updateOperationSettings() {
      return updateOperationSettings;
    }

    @Override
    public BackendBucketsStubSettings build() throws IOException {
      return new BackendBucketsStubSettings(this);
    }
  }
}
