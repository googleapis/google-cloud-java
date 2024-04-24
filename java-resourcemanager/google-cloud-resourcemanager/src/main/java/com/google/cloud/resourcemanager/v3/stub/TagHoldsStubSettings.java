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

package com.google.cloud.resourcemanager.v3.stub;

import static com.google.cloud.resourcemanager.v3.TagHoldsClient.ListTagHoldsPagedResponse;

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
import com.google.cloud.resourcemanager.v3.CreateTagHoldMetadata;
import com.google.cloud.resourcemanager.v3.CreateTagHoldRequest;
import com.google.cloud.resourcemanager.v3.DeleteTagHoldMetadata;
import com.google.cloud.resourcemanager.v3.DeleteTagHoldRequest;
import com.google.cloud.resourcemanager.v3.ListTagHoldsRequest;
import com.google.cloud.resourcemanager.v3.ListTagHoldsResponse;
import com.google.cloud.resourcemanager.v3.TagHold;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link TagHoldsStub}.
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
 * <p>For example, to set the total timeout of createTagHold to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * TagHoldsStubSettings.Builder tagHoldsSettingsBuilder = TagHoldsStubSettings.newBuilder();
 * tagHoldsSettingsBuilder
 *     .createTagHoldSettings()
 *     .setRetrySettings(
 *         tagHoldsSettingsBuilder
 *             .createTagHoldSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * TagHoldsStubSettings tagHoldsSettings = tagHoldsSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class TagHoldsStubSettings extends StubSettings<TagHoldsStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/cloud-platform.read-only")
          .build();

  private final UnaryCallSettings<CreateTagHoldRequest, Operation> createTagHoldSettings;
  private final OperationCallSettings<CreateTagHoldRequest, TagHold, CreateTagHoldMetadata>
      createTagHoldOperationSettings;
  private final UnaryCallSettings<DeleteTagHoldRequest, Operation> deleteTagHoldSettings;
  private final OperationCallSettings<DeleteTagHoldRequest, Empty, DeleteTagHoldMetadata>
      deleteTagHoldOperationSettings;
  private final PagedCallSettings<
          ListTagHoldsRequest, ListTagHoldsResponse, ListTagHoldsPagedResponse>
      listTagHoldsSettings;

  private static final PagedListDescriptor<ListTagHoldsRequest, ListTagHoldsResponse, TagHold>
      LIST_TAG_HOLDS_PAGE_STR_DESC =
          new PagedListDescriptor<ListTagHoldsRequest, ListTagHoldsResponse, TagHold>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListTagHoldsRequest injectToken(ListTagHoldsRequest payload, String token) {
              return ListTagHoldsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListTagHoldsRequest injectPageSize(ListTagHoldsRequest payload, int pageSize) {
              return ListTagHoldsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListTagHoldsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListTagHoldsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<TagHold> extractResources(ListTagHoldsResponse payload) {
              return payload.getTagHoldsList() == null
                  ? ImmutableList.<TagHold>of()
                  : payload.getTagHoldsList();
            }
          };

  private static final PagedListResponseFactory<
          ListTagHoldsRequest, ListTagHoldsResponse, ListTagHoldsPagedResponse>
      LIST_TAG_HOLDS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListTagHoldsRequest, ListTagHoldsResponse, ListTagHoldsPagedResponse>() {
            @Override
            public ApiFuture<ListTagHoldsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListTagHoldsRequest, ListTagHoldsResponse> callable,
                ListTagHoldsRequest request,
                ApiCallContext context,
                ApiFuture<ListTagHoldsResponse> futureResponse) {
              PageContext<ListTagHoldsRequest, ListTagHoldsResponse, TagHold> pageContext =
                  PageContext.create(callable, LIST_TAG_HOLDS_PAGE_STR_DESC, request, context);
              return ListTagHoldsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createTagHold. */
  public UnaryCallSettings<CreateTagHoldRequest, Operation> createTagHoldSettings() {
    return createTagHoldSettings;
  }

  /** Returns the object with the settings used for calls to createTagHold. */
  public OperationCallSettings<CreateTagHoldRequest, TagHold, CreateTagHoldMetadata>
      createTagHoldOperationSettings() {
    return createTagHoldOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteTagHold. */
  public UnaryCallSettings<DeleteTagHoldRequest, Operation> deleteTagHoldSettings() {
    return deleteTagHoldSettings;
  }

  /** Returns the object with the settings used for calls to deleteTagHold. */
  public OperationCallSettings<DeleteTagHoldRequest, Empty, DeleteTagHoldMetadata>
      deleteTagHoldOperationSettings() {
    return deleteTagHoldOperationSettings;
  }

  /** Returns the object with the settings used for calls to listTagHolds. */
  public PagedCallSettings<ListTagHoldsRequest, ListTagHoldsResponse, ListTagHoldsPagedResponse>
      listTagHoldsSettings() {
    return listTagHoldsSettings;
  }

  public TagHoldsStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcTagHoldsStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonTagHoldsStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "cloudresourcemanager";
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

  public static ApiClientHeaderProvider.Builder defaultGrpcApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(TagHoldsStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(TagHoldsStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return TagHoldsStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected TagHoldsStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createTagHoldSettings = settingsBuilder.createTagHoldSettings().build();
    createTagHoldOperationSettings = settingsBuilder.createTagHoldOperationSettings().build();
    deleteTagHoldSettings = settingsBuilder.deleteTagHoldSettings().build();
    deleteTagHoldOperationSettings = settingsBuilder.deleteTagHoldOperationSettings().build();
    listTagHoldsSettings = settingsBuilder.listTagHoldsSettings().build();
  }

  /** Builder for TagHoldsStubSettings. */
  public static class Builder extends StubSettings.Builder<TagHoldsStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateTagHoldRequest, Operation> createTagHoldSettings;
    private final OperationCallSettings.Builder<
            CreateTagHoldRequest, TagHold, CreateTagHoldMetadata>
        createTagHoldOperationSettings;
    private final UnaryCallSettings.Builder<DeleteTagHoldRequest, Operation> deleteTagHoldSettings;
    private final OperationCallSettings.Builder<DeleteTagHoldRequest, Empty, DeleteTagHoldMetadata>
        deleteTagHoldOperationSettings;
    private final PagedCallSettings.Builder<
            ListTagHoldsRequest, ListTagHoldsResponse, ListTagHoldsPagedResponse>
        listTagHoldsSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createTagHoldSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createTagHoldOperationSettings = OperationCallSettings.newBuilder();
      deleteTagHoldSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteTagHoldOperationSettings = OperationCallSettings.newBuilder();
      listTagHoldsSettings = PagedCallSettings.newBuilder(LIST_TAG_HOLDS_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createTagHoldSettings, deleteTagHoldSettings, listTagHoldsSettings);
      initDefaults(this);
    }

    protected Builder(TagHoldsStubSettings settings) {
      super(settings);

      createTagHoldSettings = settings.createTagHoldSettings.toBuilder();
      createTagHoldOperationSettings = settings.createTagHoldOperationSettings.toBuilder();
      deleteTagHoldSettings = settings.deleteTagHoldSettings.toBuilder();
      deleteTagHoldOperationSettings = settings.deleteTagHoldOperationSettings.toBuilder();
      listTagHoldsSettings = settings.listTagHoldsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createTagHoldSettings, deleteTagHoldSettings, listTagHoldsSettings);
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

    private static Builder createHttpJsonDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultHttpJsonTransportProviderBuilder().build());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultHttpJsonApiClientHeaderProviderBuilder().build());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .createTagHoldSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteTagHoldSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listTagHoldsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createTagHoldOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateTagHoldRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(TagHold.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(CreateTagHoldMetadata.class))
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
          .deleteTagHoldOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteTagHoldRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(DeleteTagHoldMetadata.class))
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

    /** Returns the builder for the settings used for calls to createTagHold. */
    public UnaryCallSettings.Builder<CreateTagHoldRequest, Operation> createTagHoldSettings() {
      return createTagHoldSettings;
    }

    /** Returns the builder for the settings used for calls to createTagHold. */
    public OperationCallSettings.Builder<CreateTagHoldRequest, TagHold, CreateTagHoldMetadata>
        createTagHoldOperationSettings() {
      return createTagHoldOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteTagHold. */
    public UnaryCallSettings.Builder<DeleteTagHoldRequest, Operation> deleteTagHoldSettings() {
      return deleteTagHoldSettings;
    }

    /** Returns the builder for the settings used for calls to deleteTagHold. */
    public OperationCallSettings.Builder<DeleteTagHoldRequest, Empty, DeleteTagHoldMetadata>
        deleteTagHoldOperationSettings() {
      return deleteTagHoldOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listTagHolds. */
    public PagedCallSettings.Builder<
            ListTagHoldsRequest, ListTagHoldsResponse, ListTagHoldsPagedResponse>
        listTagHoldsSettings() {
      return listTagHoldsSettings;
    }

    @Override
    public TagHoldsStubSettings build() throws IOException {
      return new TagHoldsStubSettings(this);
    }
  }
}
