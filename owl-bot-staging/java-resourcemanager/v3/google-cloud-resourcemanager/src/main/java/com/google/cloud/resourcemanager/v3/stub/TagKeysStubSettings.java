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

package com.google.cloud.resourcemanager.v3.stub;

import static com.google.cloud.resourcemanager.v3.TagKeysClient.ListTagKeysPagedResponse;

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
import com.google.cloud.resourcemanager.v3.CreateTagKeyMetadata;
import com.google.cloud.resourcemanager.v3.CreateTagKeyRequest;
import com.google.cloud.resourcemanager.v3.DeleteTagKeyMetadata;
import com.google.cloud.resourcemanager.v3.DeleteTagKeyRequest;
import com.google.cloud.resourcemanager.v3.GetTagKeyRequest;
import com.google.cloud.resourcemanager.v3.ListTagKeysRequest;
import com.google.cloud.resourcemanager.v3.ListTagKeysResponse;
import com.google.cloud.resourcemanager.v3.TagKey;
import com.google.cloud.resourcemanager.v3.UpdateTagKeyMetadata;
import com.google.cloud.resourcemanager.v3.UpdateTagKeyRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link TagKeysStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (cloudresourcemanager.googleapis.com) and default port (443)
 *       are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getTagKey to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * TagKeysStubSettings.Builder tagKeysSettingsBuilder = TagKeysStubSettings.newBuilder();
 * tagKeysSettingsBuilder
 *     .getTagKeySettings()
 *     .setRetrySettings(
 *         tagKeysSettingsBuilder
 *             .getTagKeySettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * TagKeysStubSettings tagKeysSettings = tagKeysSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class TagKeysStubSettings extends StubSettings<TagKeysStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/cloud-platform.read-only")
          .build();

  private final PagedCallSettings<ListTagKeysRequest, ListTagKeysResponse, ListTagKeysPagedResponse>
      listTagKeysSettings;
  private final UnaryCallSettings<GetTagKeyRequest, TagKey> getTagKeySettings;
  private final UnaryCallSettings<CreateTagKeyRequest, Operation> createTagKeySettings;
  private final OperationCallSettings<CreateTagKeyRequest, TagKey, CreateTagKeyMetadata>
      createTagKeyOperationSettings;
  private final UnaryCallSettings<UpdateTagKeyRequest, Operation> updateTagKeySettings;
  private final OperationCallSettings<UpdateTagKeyRequest, TagKey, UpdateTagKeyMetadata>
      updateTagKeyOperationSettings;
  private final UnaryCallSettings<DeleteTagKeyRequest, Operation> deleteTagKeySettings;
  private final OperationCallSettings<DeleteTagKeyRequest, TagKey, DeleteTagKeyMetadata>
      deleteTagKeyOperationSettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<ListTagKeysRequest, ListTagKeysResponse, TagKey>
      LIST_TAG_KEYS_PAGE_STR_DESC =
          new PagedListDescriptor<ListTagKeysRequest, ListTagKeysResponse, TagKey>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListTagKeysRequest injectToken(ListTagKeysRequest payload, String token) {
              return ListTagKeysRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListTagKeysRequest injectPageSize(ListTagKeysRequest payload, int pageSize) {
              return ListTagKeysRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListTagKeysRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListTagKeysResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<TagKey> extractResources(ListTagKeysResponse payload) {
              return payload.getTagKeysList() == null
                  ? ImmutableList.<TagKey>of()
                  : payload.getTagKeysList();
            }
          };

  private static final PagedListResponseFactory<
          ListTagKeysRequest, ListTagKeysResponse, ListTagKeysPagedResponse>
      LIST_TAG_KEYS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListTagKeysRequest, ListTagKeysResponse, ListTagKeysPagedResponse>() {
            @Override
            public ApiFuture<ListTagKeysPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListTagKeysRequest, ListTagKeysResponse> callable,
                ListTagKeysRequest request,
                ApiCallContext context,
                ApiFuture<ListTagKeysResponse> futureResponse) {
              PageContext<ListTagKeysRequest, ListTagKeysResponse, TagKey> pageContext =
                  PageContext.create(callable, LIST_TAG_KEYS_PAGE_STR_DESC, request, context);
              return ListTagKeysPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listTagKeys. */
  public PagedCallSettings<ListTagKeysRequest, ListTagKeysResponse, ListTagKeysPagedResponse>
      listTagKeysSettings() {
    return listTagKeysSettings;
  }

  /** Returns the object with the settings used for calls to getTagKey. */
  public UnaryCallSettings<GetTagKeyRequest, TagKey> getTagKeySettings() {
    return getTagKeySettings;
  }

  /** Returns the object with the settings used for calls to createTagKey. */
  public UnaryCallSettings<CreateTagKeyRequest, Operation> createTagKeySettings() {
    return createTagKeySettings;
  }

  /** Returns the object with the settings used for calls to createTagKey. */
  public OperationCallSettings<CreateTagKeyRequest, TagKey, CreateTagKeyMetadata>
      createTagKeyOperationSettings() {
    return createTagKeyOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateTagKey. */
  public UnaryCallSettings<UpdateTagKeyRequest, Operation> updateTagKeySettings() {
    return updateTagKeySettings;
  }

  /** Returns the object with the settings used for calls to updateTagKey. */
  public OperationCallSettings<UpdateTagKeyRequest, TagKey, UpdateTagKeyMetadata>
      updateTagKeyOperationSettings() {
    return updateTagKeyOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteTagKey. */
  public UnaryCallSettings<DeleteTagKeyRequest, Operation> deleteTagKeySettings() {
    return deleteTagKeySettings;
  }

  /** Returns the object with the settings used for calls to deleteTagKey. */
  public OperationCallSettings<DeleteTagKeyRequest, TagKey, DeleteTagKeyMetadata>
      deleteTagKeyOperationSettings() {
    return deleteTagKeyOperationSettings;
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return getIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return setIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return testIamPermissionsSettings;
  }

  public TagKeysStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcTagKeysStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonTagKeysStub.create(this);
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
    return "cloudresourcemanager.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "cloudresourcemanager.mtls.googleapis.com:443";
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
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(TagKeysStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(TagKeysStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return TagKeysStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected TagKeysStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listTagKeysSettings = settingsBuilder.listTagKeysSettings().build();
    getTagKeySettings = settingsBuilder.getTagKeySettings().build();
    createTagKeySettings = settingsBuilder.createTagKeySettings().build();
    createTagKeyOperationSettings = settingsBuilder.createTagKeyOperationSettings().build();
    updateTagKeySettings = settingsBuilder.updateTagKeySettings().build();
    updateTagKeyOperationSettings = settingsBuilder.updateTagKeyOperationSettings().build();
    deleteTagKeySettings = settingsBuilder.deleteTagKeySettings().build();
    deleteTagKeyOperationSettings = settingsBuilder.deleteTagKeyOperationSettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  /** Builder for TagKeysStubSettings. */
  public static class Builder extends StubSettings.Builder<TagKeysStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListTagKeysRequest, ListTagKeysResponse, ListTagKeysPagedResponse>
        listTagKeysSettings;
    private final UnaryCallSettings.Builder<GetTagKeyRequest, TagKey> getTagKeySettings;
    private final UnaryCallSettings.Builder<CreateTagKeyRequest, Operation> createTagKeySettings;
    private final OperationCallSettings.Builder<CreateTagKeyRequest, TagKey, CreateTagKeyMetadata>
        createTagKeyOperationSettings;
    private final UnaryCallSettings.Builder<UpdateTagKeyRequest, Operation> updateTagKeySettings;
    private final OperationCallSettings.Builder<UpdateTagKeyRequest, TagKey, UpdateTagKeyMetadata>
        updateTagKeyOperationSettings;
    private final UnaryCallSettings.Builder<DeleteTagKeyRequest, Operation> deleteTagKeySettings;
    private final OperationCallSettings.Builder<DeleteTagKeyRequest, TagKey, DeleteTagKeyMetadata>
        deleteTagKeyOperationSettings;
    private final UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings;
    private final UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings;
    private final UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      definitions.put(
          "no_retry_1_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
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
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_1_params", settings);
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listTagKeysSettings = PagedCallSettings.newBuilder(LIST_TAG_KEYS_PAGE_STR_FACT);
      getTagKeySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createTagKeySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createTagKeyOperationSettings = OperationCallSettings.newBuilder();
      updateTagKeySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateTagKeyOperationSettings = OperationCallSettings.newBuilder();
      deleteTagKeySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteTagKeyOperationSettings = OperationCallSettings.newBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listTagKeysSettings,
              getTagKeySettings,
              createTagKeySettings,
              updateTagKeySettings,
              deleteTagKeySettings,
              getIamPolicySettings,
              setIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(TagKeysStubSettings settings) {
      super(settings);

      listTagKeysSettings = settings.listTagKeysSettings.toBuilder();
      getTagKeySettings = settings.getTagKeySettings.toBuilder();
      createTagKeySettings = settings.createTagKeySettings.toBuilder();
      createTagKeyOperationSettings = settings.createTagKeyOperationSettings.toBuilder();
      updateTagKeySettings = settings.updateTagKeySettings.toBuilder();
      updateTagKeyOperationSettings = settings.updateTagKeyOperationSettings.toBuilder();
      deleteTagKeySettings = settings.deleteTagKeySettings.toBuilder();
      deleteTagKeyOperationSettings = settings.deleteTagKeyOperationSettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listTagKeysSettings,
              getTagKeySettings,
              createTagKeySettings,
              updateTagKeySettings,
              deleteTagKeySettings,
              getIamPolicySettings,
              setIamPolicySettings,
              testIamPermissionsSettings);
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
          .listTagKeysSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getTagKeySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createTagKeySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateTagKeySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteTagKeySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .setIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .testIamPermissionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createTagKeyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateTagKeyRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(TagKey.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(CreateTagKeyMetadata.class))
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
          .updateTagKeyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateTagKeyRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(TagKey.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(UpdateTagKeyMetadata.class))
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
          .deleteTagKeyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteTagKeyRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(TagKey.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(DeleteTagKeyMetadata.class))
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

    /** Returns the builder for the settings used for calls to listTagKeys. */
    public PagedCallSettings.Builder<
            ListTagKeysRequest, ListTagKeysResponse, ListTagKeysPagedResponse>
        listTagKeysSettings() {
      return listTagKeysSettings;
    }

    /** Returns the builder for the settings used for calls to getTagKey. */
    public UnaryCallSettings.Builder<GetTagKeyRequest, TagKey> getTagKeySettings() {
      return getTagKeySettings;
    }

    /** Returns the builder for the settings used for calls to createTagKey. */
    public UnaryCallSettings.Builder<CreateTagKeyRequest, Operation> createTagKeySettings() {
      return createTagKeySettings;
    }

    /** Returns the builder for the settings used for calls to createTagKey. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<CreateTagKeyRequest, TagKey, CreateTagKeyMetadata>
        createTagKeyOperationSettings() {
      return createTagKeyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateTagKey. */
    public UnaryCallSettings.Builder<UpdateTagKeyRequest, Operation> updateTagKeySettings() {
      return updateTagKeySettings;
    }

    /** Returns the builder for the settings used for calls to updateTagKey. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<UpdateTagKeyRequest, TagKey, UpdateTagKeyMetadata>
        updateTagKeyOperationSettings() {
      return updateTagKeyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteTagKey. */
    public UnaryCallSettings.Builder<DeleteTagKeyRequest, Operation> deleteTagKeySettings() {
      return deleteTagKeySettings;
    }

    /** Returns the builder for the settings used for calls to deleteTagKey. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteTagKeyRequest, TagKey, DeleteTagKeyMetadata>
        deleteTagKeyOperationSettings() {
      return deleteTagKeyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return setIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return testIamPermissionsSettings;
    }

    @Override
    public TagKeysStubSettings build() throws IOException {
      return new TagKeysStubSettings(this);
    }
  }
}
