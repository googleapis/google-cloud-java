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

package com.google.apps.events.subscriptions.v1.stub;

import static com.google.apps.events.subscriptions.v1.SubscriptionsServiceClient.ListSubscriptionsPagedResponse;

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
import com.google.apps.events.subscriptions.v1.CreateSubscriptionMetadata;
import com.google.apps.events.subscriptions.v1.CreateSubscriptionRequest;
import com.google.apps.events.subscriptions.v1.DeleteSubscriptionMetadata;
import com.google.apps.events.subscriptions.v1.DeleteSubscriptionRequest;
import com.google.apps.events.subscriptions.v1.GetSubscriptionRequest;
import com.google.apps.events.subscriptions.v1.ListSubscriptionsRequest;
import com.google.apps.events.subscriptions.v1.ListSubscriptionsResponse;
import com.google.apps.events.subscriptions.v1.ReactivateSubscriptionMetadata;
import com.google.apps.events.subscriptions.v1.ReactivateSubscriptionRequest;
import com.google.apps.events.subscriptions.v1.Subscription;
import com.google.apps.events.subscriptions.v1.UpdateSubscriptionMetadata;
import com.google.apps.events.subscriptions.v1.UpdateSubscriptionRequest;
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
 * Settings class to configure an instance of {@link SubscriptionsServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (workspaceevents.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getSubscription to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SubscriptionsServiceStubSettings.Builder subscriptionsServiceSettingsBuilder =
 *     SubscriptionsServiceStubSettings.newBuilder();
 * subscriptionsServiceSettingsBuilder
 *     .getSubscriptionSettings()
 *     .setRetrySettings(
 *         subscriptionsServiceSettingsBuilder
 *             .getSubscriptionSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * SubscriptionsServiceStubSettings subscriptionsServiceSettings =
 *     subscriptionsServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class SubscriptionsServiceStubSettings
    extends StubSettings<SubscriptionsServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/chat.bot")
          .add("https://www.googleapis.com/auth/chat.memberships")
          .add("https://www.googleapis.com/auth/chat.memberships.readonly")
          .add("https://www.googleapis.com/auth/chat.messages")
          .add("https://www.googleapis.com/auth/chat.messages.reactions")
          .add("https://www.googleapis.com/auth/chat.messages.reactions.readonly")
          .add("https://www.googleapis.com/auth/chat.messages.readonly")
          .add("https://www.googleapis.com/auth/chat.spaces")
          .add("https://www.googleapis.com/auth/chat.spaces.readonly")
          .add("https://www.googleapis.com/auth/meetings.space.created")
          .add("https://www.googleapis.com/auth/meetings.space.readonly")
          .build();

  private final UnaryCallSettings<CreateSubscriptionRequest, Operation> createSubscriptionSettings;
  private final OperationCallSettings<
          CreateSubscriptionRequest, Subscription, CreateSubscriptionMetadata>
      createSubscriptionOperationSettings;
  private final UnaryCallSettings<DeleteSubscriptionRequest, Operation> deleteSubscriptionSettings;
  private final OperationCallSettings<DeleteSubscriptionRequest, Empty, DeleteSubscriptionMetadata>
      deleteSubscriptionOperationSettings;
  private final UnaryCallSettings<GetSubscriptionRequest, Subscription> getSubscriptionSettings;
  private final PagedCallSettings<
          ListSubscriptionsRequest, ListSubscriptionsResponse, ListSubscriptionsPagedResponse>
      listSubscriptionsSettings;
  private final UnaryCallSettings<UpdateSubscriptionRequest, Operation> updateSubscriptionSettings;
  private final OperationCallSettings<
          UpdateSubscriptionRequest, Subscription, UpdateSubscriptionMetadata>
      updateSubscriptionOperationSettings;
  private final UnaryCallSettings<ReactivateSubscriptionRequest, Operation>
      reactivateSubscriptionSettings;
  private final OperationCallSettings<
          ReactivateSubscriptionRequest, Subscription, ReactivateSubscriptionMetadata>
      reactivateSubscriptionOperationSettings;

  private static final PagedListDescriptor<
          ListSubscriptionsRequest, ListSubscriptionsResponse, Subscription>
      LIST_SUBSCRIPTIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListSubscriptionsRequest, ListSubscriptionsResponse, Subscription>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListSubscriptionsRequest injectToken(
                ListSubscriptionsRequest payload, String token) {
              return ListSubscriptionsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListSubscriptionsRequest injectPageSize(
                ListSubscriptionsRequest payload, int pageSize) {
              return ListSubscriptionsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListSubscriptionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListSubscriptionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Subscription> extractResources(ListSubscriptionsResponse payload) {
              return payload.getSubscriptionsList() == null
                  ? ImmutableList.<Subscription>of()
                  : payload.getSubscriptionsList();
            }
          };

  private static final PagedListResponseFactory<
          ListSubscriptionsRequest, ListSubscriptionsResponse, ListSubscriptionsPagedResponse>
      LIST_SUBSCRIPTIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListSubscriptionsRequest,
              ListSubscriptionsResponse,
              ListSubscriptionsPagedResponse>() {
            @Override
            public ApiFuture<ListSubscriptionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListSubscriptionsRequest, ListSubscriptionsResponse> callable,
                ListSubscriptionsRequest request,
                ApiCallContext context,
                ApiFuture<ListSubscriptionsResponse> futureResponse) {
              PageContext<ListSubscriptionsRequest, ListSubscriptionsResponse, Subscription>
                  pageContext =
                      PageContext.create(
                          callable, LIST_SUBSCRIPTIONS_PAGE_STR_DESC, request, context);
              return ListSubscriptionsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createSubscription. */
  public UnaryCallSettings<CreateSubscriptionRequest, Operation> createSubscriptionSettings() {
    return createSubscriptionSettings;
  }

  /** Returns the object with the settings used for calls to createSubscription. */
  public OperationCallSettings<CreateSubscriptionRequest, Subscription, CreateSubscriptionMetadata>
      createSubscriptionOperationSettings() {
    return createSubscriptionOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteSubscription. */
  public UnaryCallSettings<DeleteSubscriptionRequest, Operation> deleteSubscriptionSettings() {
    return deleteSubscriptionSettings;
  }

  /** Returns the object with the settings used for calls to deleteSubscription. */
  public OperationCallSettings<DeleteSubscriptionRequest, Empty, DeleteSubscriptionMetadata>
      deleteSubscriptionOperationSettings() {
    return deleteSubscriptionOperationSettings;
  }

  /** Returns the object with the settings used for calls to getSubscription. */
  public UnaryCallSettings<GetSubscriptionRequest, Subscription> getSubscriptionSettings() {
    return getSubscriptionSettings;
  }

  /** Returns the object with the settings used for calls to listSubscriptions. */
  public PagedCallSettings<
          ListSubscriptionsRequest, ListSubscriptionsResponse, ListSubscriptionsPagedResponse>
      listSubscriptionsSettings() {
    return listSubscriptionsSettings;
  }

  /** Returns the object with the settings used for calls to updateSubscription. */
  public UnaryCallSettings<UpdateSubscriptionRequest, Operation> updateSubscriptionSettings() {
    return updateSubscriptionSettings;
  }

  /** Returns the object with the settings used for calls to updateSubscription. */
  public OperationCallSettings<UpdateSubscriptionRequest, Subscription, UpdateSubscriptionMetadata>
      updateSubscriptionOperationSettings() {
    return updateSubscriptionOperationSettings;
  }

  /** Returns the object with the settings used for calls to reactivateSubscription. */
  public UnaryCallSettings<ReactivateSubscriptionRequest, Operation>
      reactivateSubscriptionSettings() {
    return reactivateSubscriptionSettings;
  }

  /** Returns the object with the settings used for calls to reactivateSubscription. */
  public OperationCallSettings<
          ReactivateSubscriptionRequest, Subscription, ReactivateSubscriptionMetadata>
      reactivateSubscriptionOperationSettings() {
    return reactivateSubscriptionOperationSettings;
  }

  public SubscriptionsServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcSubscriptionsServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonSubscriptionsServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "workspaceevents";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "workspaceevents.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "workspaceevents.mtls.googleapis.com:443";
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
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(SubscriptionsServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(SubscriptionsServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return SubscriptionsServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected SubscriptionsServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createSubscriptionSettings = settingsBuilder.createSubscriptionSettings().build();
    createSubscriptionOperationSettings =
        settingsBuilder.createSubscriptionOperationSettings().build();
    deleteSubscriptionSettings = settingsBuilder.deleteSubscriptionSettings().build();
    deleteSubscriptionOperationSettings =
        settingsBuilder.deleteSubscriptionOperationSettings().build();
    getSubscriptionSettings = settingsBuilder.getSubscriptionSettings().build();
    listSubscriptionsSettings = settingsBuilder.listSubscriptionsSettings().build();
    updateSubscriptionSettings = settingsBuilder.updateSubscriptionSettings().build();
    updateSubscriptionOperationSettings =
        settingsBuilder.updateSubscriptionOperationSettings().build();
    reactivateSubscriptionSettings = settingsBuilder.reactivateSubscriptionSettings().build();
    reactivateSubscriptionOperationSettings =
        settingsBuilder.reactivateSubscriptionOperationSettings().build();
  }

  /** Builder for SubscriptionsServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<SubscriptionsServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateSubscriptionRequest, Operation>
        createSubscriptionSettings;
    private final OperationCallSettings.Builder<
            CreateSubscriptionRequest, Subscription, CreateSubscriptionMetadata>
        createSubscriptionOperationSettings;
    private final UnaryCallSettings.Builder<DeleteSubscriptionRequest, Operation>
        deleteSubscriptionSettings;
    private final OperationCallSettings.Builder<
            DeleteSubscriptionRequest, Empty, DeleteSubscriptionMetadata>
        deleteSubscriptionOperationSettings;
    private final UnaryCallSettings.Builder<GetSubscriptionRequest, Subscription>
        getSubscriptionSettings;
    private final PagedCallSettings.Builder<
            ListSubscriptionsRequest, ListSubscriptionsResponse, ListSubscriptionsPagedResponse>
        listSubscriptionsSettings;
    private final UnaryCallSettings.Builder<UpdateSubscriptionRequest, Operation>
        updateSubscriptionSettings;
    private final OperationCallSettings.Builder<
            UpdateSubscriptionRequest, Subscription, UpdateSubscriptionMetadata>
        updateSubscriptionOperationSettings;
    private final UnaryCallSettings.Builder<ReactivateSubscriptionRequest, Operation>
        reactivateSubscriptionSettings;
    private final OperationCallSettings.Builder<
            ReactivateSubscriptionRequest, Subscription, ReactivateSubscriptionMetadata>
        reactivateSubscriptionOperationSettings;
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

      createSubscriptionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createSubscriptionOperationSettings = OperationCallSettings.newBuilder();
      deleteSubscriptionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteSubscriptionOperationSettings = OperationCallSettings.newBuilder();
      getSubscriptionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listSubscriptionsSettings = PagedCallSettings.newBuilder(LIST_SUBSCRIPTIONS_PAGE_STR_FACT);
      updateSubscriptionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateSubscriptionOperationSettings = OperationCallSettings.newBuilder();
      reactivateSubscriptionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      reactivateSubscriptionOperationSettings = OperationCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createSubscriptionSettings,
              deleteSubscriptionSettings,
              getSubscriptionSettings,
              listSubscriptionsSettings,
              updateSubscriptionSettings,
              reactivateSubscriptionSettings);
      initDefaults(this);
    }

    protected Builder(SubscriptionsServiceStubSettings settings) {
      super(settings);

      createSubscriptionSettings = settings.createSubscriptionSettings.toBuilder();
      createSubscriptionOperationSettings =
          settings.createSubscriptionOperationSettings.toBuilder();
      deleteSubscriptionSettings = settings.deleteSubscriptionSettings.toBuilder();
      deleteSubscriptionOperationSettings =
          settings.deleteSubscriptionOperationSettings.toBuilder();
      getSubscriptionSettings = settings.getSubscriptionSettings.toBuilder();
      listSubscriptionsSettings = settings.listSubscriptionsSettings.toBuilder();
      updateSubscriptionSettings = settings.updateSubscriptionSettings.toBuilder();
      updateSubscriptionOperationSettings =
          settings.updateSubscriptionOperationSettings.toBuilder();
      reactivateSubscriptionSettings = settings.reactivateSubscriptionSettings.toBuilder();
      reactivateSubscriptionOperationSettings =
          settings.reactivateSubscriptionOperationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createSubscriptionSettings,
              deleteSubscriptionSettings,
              getSubscriptionSettings,
              listSubscriptionsSettings,
              updateSubscriptionSettings,
              reactivateSubscriptionSettings);
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
          .createSubscriptionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteSubscriptionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getSubscriptionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listSubscriptionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateSubscriptionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .reactivateSubscriptionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .createSubscriptionOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateSubscriptionRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Subscription.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  CreateSubscriptionMetadata.class))
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
          .deleteSubscriptionOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteSubscriptionRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  DeleteSubscriptionMetadata.class))
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
          .updateSubscriptionOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateSubscriptionRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Subscription.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  UpdateSubscriptionMetadata.class))
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
          .reactivateSubscriptionOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ReactivateSubscriptionRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Subscription.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  ReactivateSubscriptionMetadata.class))
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

    /** Returns the builder for the settings used for calls to createSubscription. */
    public UnaryCallSettings.Builder<CreateSubscriptionRequest, Operation>
        createSubscriptionSettings() {
      return createSubscriptionSettings;
    }

    /** Returns the builder for the settings used for calls to createSubscription. */
    public OperationCallSettings.Builder<
            CreateSubscriptionRequest, Subscription, CreateSubscriptionMetadata>
        createSubscriptionOperationSettings() {
      return createSubscriptionOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteSubscription. */
    public UnaryCallSettings.Builder<DeleteSubscriptionRequest, Operation>
        deleteSubscriptionSettings() {
      return deleteSubscriptionSettings;
    }

    /** Returns the builder for the settings used for calls to deleteSubscription. */
    public OperationCallSettings.Builder<
            DeleteSubscriptionRequest, Empty, DeleteSubscriptionMetadata>
        deleteSubscriptionOperationSettings() {
      return deleteSubscriptionOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getSubscription. */
    public UnaryCallSettings.Builder<GetSubscriptionRequest, Subscription>
        getSubscriptionSettings() {
      return getSubscriptionSettings;
    }

    /** Returns the builder for the settings used for calls to listSubscriptions. */
    public PagedCallSettings.Builder<
            ListSubscriptionsRequest, ListSubscriptionsResponse, ListSubscriptionsPagedResponse>
        listSubscriptionsSettings() {
      return listSubscriptionsSettings;
    }

    /** Returns the builder for the settings used for calls to updateSubscription. */
    public UnaryCallSettings.Builder<UpdateSubscriptionRequest, Operation>
        updateSubscriptionSettings() {
      return updateSubscriptionSettings;
    }

    /** Returns the builder for the settings used for calls to updateSubscription. */
    public OperationCallSettings.Builder<
            UpdateSubscriptionRequest, Subscription, UpdateSubscriptionMetadata>
        updateSubscriptionOperationSettings() {
      return updateSubscriptionOperationSettings;
    }

    /** Returns the builder for the settings used for calls to reactivateSubscription. */
    public UnaryCallSettings.Builder<ReactivateSubscriptionRequest, Operation>
        reactivateSubscriptionSettings() {
      return reactivateSubscriptionSettings;
    }

    /** Returns the builder for the settings used for calls to reactivateSubscription. */
    public OperationCallSettings.Builder<
            ReactivateSubscriptionRequest, Subscription, ReactivateSubscriptionMetadata>
        reactivateSubscriptionOperationSettings() {
      return reactivateSubscriptionOperationSettings;
    }

    @Override
    public SubscriptionsServiceStubSettings build() throws IOException {
      return new SubscriptionsServiceStubSettings(this);
    }
  }
}
