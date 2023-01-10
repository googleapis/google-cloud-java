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

import static com.google.cloud.resourcemanager.v3.TagValuesClient.ListTagValuesPagedResponse;

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
import com.google.cloud.resourcemanager.v3.CreateTagValueMetadata;
import com.google.cloud.resourcemanager.v3.CreateTagValueRequest;
import com.google.cloud.resourcemanager.v3.DeleteTagValueMetadata;
import com.google.cloud.resourcemanager.v3.DeleteTagValueRequest;
import com.google.cloud.resourcemanager.v3.GetTagValueRequest;
import com.google.cloud.resourcemanager.v3.ListTagValuesRequest;
import com.google.cloud.resourcemanager.v3.ListTagValuesResponse;
import com.google.cloud.resourcemanager.v3.TagValue;
import com.google.cloud.resourcemanager.v3.UpdateTagValueMetadata;
import com.google.cloud.resourcemanager.v3.UpdateTagValueRequest;
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
 * Settings class to configure an instance of {@link TagValuesStub}.
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
 * <p>For example, to set the total timeout of getTagValue to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * TagValuesStubSettings.Builder tagValuesSettingsBuilder = TagValuesStubSettings.newBuilder();
 * tagValuesSettingsBuilder
 *     .getTagValueSettings()
 *     .setRetrySettings(
 *         tagValuesSettingsBuilder
 *             .getTagValueSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * TagValuesStubSettings tagValuesSettings = tagValuesSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class TagValuesStubSettings extends StubSettings<TagValuesStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/cloud-platform.read-only")
          .build();

  private final PagedCallSettings<
          ListTagValuesRequest, ListTagValuesResponse, ListTagValuesPagedResponse>
      listTagValuesSettings;
  private final UnaryCallSettings<GetTagValueRequest, TagValue> getTagValueSettings;
  private final UnaryCallSettings<CreateTagValueRequest, Operation> createTagValueSettings;
  private final OperationCallSettings<CreateTagValueRequest, TagValue, CreateTagValueMetadata>
      createTagValueOperationSettings;
  private final UnaryCallSettings<UpdateTagValueRequest, Operation> updateTagValueSettings;
  private final OperationCallSettings<UpdateTagValueRequest, TagValue, UpdateTagValueMetadata>
      updateTagValueOperationSettings;
  private final UnaryCallSettings<DeleteTagValueRequest, Operation> deleteTagValueSettings;
  private final OperationCallSettings<DeleteTagValueRequest, TagValue, DeleteTagValueMetadata>
      deleteTagValueOperationSettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<ListTagValuesRequest, ListTagValuesResponse, TagValue>
      LIST_TAG_VALUES_PAGE_STR_DESC =
          new PagedListDescriptor<ListTagValuesRequest, ListTagValuesResponse, TagValue>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListTagValuesRequest injectToken(ListTagValuesRequest payload, String token) {
              return ListTagValuesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListTagValuesRequest injectPageSize(ListTagValuesRequest payload, int pageSize) {
              return ListTagValuesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListTagValuesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListTagValuesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<TagValue> extractResources(ListTagValuesResponse payload) {
              return payload.getTagValuesList() == null
                  ? ImmutableList.<TagValue>of()
                  : payload.getTagValuesList();
            }
          };

  private static final PagedListResponseFactory<
          ListTagValuesRequest, ListTagValuesResponse, ListTagValuesPagedResponse>
      LIST_TAG_VALUES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListTagValuesRequest, ListTagValuesResponse, ListTagValuesPagedResponse>() {
            @Override
            public ApiFuture<ListTagValuesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListTagValuesRequest, ListTagValuesResponse> callable,
                ListTagValuesRequest request,
                ApiCallContext context,
                ApiFuture<ListTagValuesResponse> futureResponse) {
              PageContext<ListTagValuesRequest, ListTagValuesResponse, TagValue> pageContext =
                  PageContext.create(callable, LIST_TAG_VALUES_PAGE_STR_DESC, request, context);
              return ListTagValuesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listTagValues. */
  public PagedCallSettings<ListTagValuesRequest, ListTagValuesResponse, ListTagValuesPagedResponse>
      listTagValuesSettings() {
    return listTagValuesSettings;
  }

  /** Returns the object with the settings used for calls to getTagValue. */
  public UnaryCallSettings<GetTagValueRequest, TagValue> getTagValueSettings() {
    return getTagValueSettings;
  }

  /** Returns the object with the settings used for calls to createTagValue. */
  public UnaryCallSettings<CreateTagValueRequest, Operation> createTagValueSettings() {
    return createTagValueSettings;
  }

  /** Returns the object with the settings used for calls to createTagValue. */
  public OperationCallSettings<CreateTagValueRequest, TagValue, CreateTagValueMetadata>
      createTagValueOperationSettings() {
    return createTagValueOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateTagValue. */
  public UnaryCallSettings<UpdateTagValueRequest, Operation> updateTagValueSettings() {
    return updateTagValueSettings;
  }

  /** Returns the object with the settings used for calls to updateTagValue. */
  public OperationCallSettings<UpdateTagValueRequest, TagValue, UpdateTagValueMetadata>
      updateTagValueOperationSettings() {
    return updateTagValueOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteTagValue. */
  public UnaryCallSettings<DeleteTagValueRequest, Operation> deleteTagValueSettings() {
    return deleteTagValueSettings;
  }

  /** Returns the object with the settings used for calls to deleteTagValue. */
  public OperationCallSettings<DeleteTagValueRequest, TagValue, DeleteTagValueMetadata>
      deleteTagValueOperationSettings() {
    return deleteTagValueOperationSettings;
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

  public TagValuesStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcTagValuesStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonTagValuesStub.create(this);
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
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(TagValuesStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(TagValuesStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return TagValuesStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected TagValuesStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listTagValuesSettings = settingsBuilder.listTagValuesSettings().build();
    getTagValueSettings = settingsBuilder.getTagValueSettings().build();
    createTagValueSettings = settingsBuilder.createTagValueSettings().build();
    createTagValueOperationSettings = settingsBuilder.createTagValueOperationSettings().build();
    updateTagValueSettings = settingsBuilder.updateTagValueSettings().build();
    updateTagValueOperationSettings = settingsBuilder.updateTagValueOperationSettings().build();
    deleteTagValueSettings = settingsBuilder.deleteTagValueSettings().build();
    deleteTagValueOperationSettings = settingsBuilder.deleteTagValueOperationSettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  /** Builder for TagValuesStubSettings. */
  public static class Builder extends StubSettings.Builder<TagValuesStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListTagValuesRequest, ListTagValuesResponse, ListTagValuesPagedResponse>
        listTagValuesSettings;
    private final UnaryCallSettings.Builder<GetTagValueRequest, TagValue> getTagValueSettings;
    private final UnaryCallSettings.Builder<CreateTagValueRequest, Operation>
        createTagValueSettings;
    private final OperationCallSettings.Builder<
            CreateTagValueRequest, TagValue, CreateTagValueMetadata>
        createTagValueOperationSettings;
    private final UnaryCallSettings.Builder<UpdateTagValueRequest, Operation>
        updateTagValueSettings;
    private final OperationCallSettings.Builder<
            UpdateTagValueRequest, TagValue, UpdateTagValueMetadata>
        updateTagValueOperationSettings;
    private final UnaryCallSettings.Builder<DeleteTagValueRequest, Operation>
        deleteTagValueSettings;
    private final OperationCallSettings.Builder<
            DeleteTagValueRequest, TagValue, DeleteTagValueMetadata>
        deleteTagValueOperationSettings;
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

      listTagValuesSettings = PagedCallSettings.newBuilder(LIST_TAG_VALUES_PAGE_STR_FACT);
      getTagValueSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createTagValueSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createTagValueOperationSettings = OperationCallSettings.newBuilder();
      updateTagValueSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateTagValueOperationSettings = OperationCallSettings.newBuilder();
      deleteTagValueSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteTagValueOperationSettings = OperationCallSettings.newBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listTagValuesSettings,
              getTagValueSettings,
              createTagValueSettings,
              updateTagValueSettings,
              deleteTagValueSettings,
              getIamPolicySettings,
              setIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(TagValuesStubSettings settings) {
      super(settings);

      listTagValuesSettings = settings.listTagValuesSettings.toBuilder();
      getTagValueSettings = settings.getTagValueSettings.toBuilder();
      createTagValueSettings = settings.createTagValueSettings.toBuilder();
      createTagValueOperationSettings = settings.createTagValueOperationSettings.toBuilder();
      updateTagValueSettings = settings.updateTagValueSettings.toBuilder();
      updateTagValueOperationSettings = settings.updateTagValueOperationSettings.toBuilder();
      deleteTagValueSettings = settings.deleteTagValueSettings.toBuilder();
      deleteTagValueOperationSettings = settings.deleteTagValueOperationSettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listTagValuesSettings,
              getTagValueSettings,
              createTagValueSettings,
              updateTagValueSettings,
              deleteTagValueSettings,
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
          .listTagValuesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getTagValueSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createTagValueSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateTagValueSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteTagValueSettings()
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
          .createTagValueOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateTagValueRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(TagValue.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(CreateTagValueMetadata.class))
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
          .updateTagValueOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateTagValueRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(TagValue.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(UpdateTagValueMetadata.class))
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
          .deleteTagValueOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteTagValueRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(TagValue.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(DeleteTagValueMetadata.class))
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

    /** Returns the builder for the settings used for calls to listTagValues. */
    public PagedCallSettings.Builder<
            ListTagValuesRequest, ListTagValuesResponse, ListTagValuesPagedResponse>
        listTagValuesSettings() {
      return listTagValuesSettings;
    }

    /** Returns the builder for the settings used for calls to getTagValue. */
    public UnaryCallSettings.Builder<GetTagValueRequest, TagValue> getTagValueSettings() {
      return getTagValueSettings;
    }

    /** Returns the builder for the settings used for calls to createTagValue. */
    public UnaryCallSettings.Builder<CreateTagValueRequest, Operation> createTagValueSettings() {
      return createTagValueSettings;
    }

    /** Returns the builder for the settings used for calls to createTagValue. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<CreateTagValueRequest, TagValue, CreateTagValueMetadata>
        createTagValueOperationSettings() {
      return createTagValueOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateTagValue. */
    public UnaryCallSettings.Builder<UpdateTagValueRequest, Operation> updateTagValueSettings() {
      return updateTagValueSettings;
    }

    /** Returns the builder for the settings used for calls to updateTagValue. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<UpdateTagValueRequest, TagValue, UpdateTagValueMetadata>
        updateTagValueOperationSettings() {
      return updateTagValueOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteTagValue. */
    public UnaryCallSettings.Builder<DeleteTagValueRequest, Operation> deleteTagValueSettings() {
      return deleteTagValueSettings;
    }

    /** Returns the builder for the settings used for calls to deleteTagValue. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteTagValueRequest, TagValue, DeleteTagValueMetadata>
        deleteTagValueOperationSettings() {
      return deleteTagValueOperationSettings;
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
    public TagValuesStubSettings build() throws IOException {
      return new TagValuesStubSettings(this);
    }
  }
}
